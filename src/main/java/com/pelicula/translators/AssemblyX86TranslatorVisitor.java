package com.pelicula.translators;

import java.util.HashSet;
import java.util.Set;

import com.pelicula.Director_cutBaseVisitor;
import com.pelicula.Director_cutParser.*;

public class AssemblyX86TranslatorVisitor extends Director_cutBaseVisitor<String> {

    private StringBuilder dataSection = new StringBuilder();
    private StringBuilder textSection = new StringBuilder();
    private int labelCount = 0;
    private int stringCount = 0;
    private Set<String> declaredVars = new HashSet<>();

    public AssemblyX86TranslatorVisitor() {
        // Preparamos la sección de datos (para variables globales o literales string)
        dataSection.append("section .data\n");
        dataSection.append("    format_int db \"%lld\", 10, 0\n");

        // Preparamos la sección de código ejecutable
        textSection.append("section .text\n");
        textSection.append("    global main\n");
        textSection.append("    extern printf\n\n");
        textSection.append("main:\n");
        textSection.append("    push rbp\n");
        textSection.append("    mov rbp, rsp\n");
        textSection.append("    sub rsp, 32\n");
    }

    private String newLabel() {
        return "L" + (labelCount++);
    }

    private String newStringLabel() {
        return "str" + (stringCount++);
    }

    @Override
    public String visitProgram(ProgramContext ctx) {
        for (StatementContext stmt : ctx.statement()) {
            textSection.append(visit(stmt));
        }

        textSection.append("    add rsp, 32\n");
        textSection.append("    mov eax, 0\n");
        textSection.append("    pop rbp\n");
        textSection.append("    ret\n");

        return dataSection.toString() + "\n" + textSection.toString();
    }

    @Override
    public String visitStatement(StatementContext ctx) {
        if (ctx.printStmt() != null) return visit(ctx.printStmt());
        if (ctx.ifStmt() != null) return visit(ctx.ifStmt());
        if (ctx.forStmt() != null) return visit(ctx.forStmt());

        if (ctx.ROLE() != null) {
            String varName = ctx.ROLE().getText();
            boolean isDeclaration = ctx.CAST() != null || ctx.STAR() != null || ctx.type() != null;
            
            if (isDeclaration && !declaredVars.contains(varName)) {
                dataSection.append("    ").append(varName).append(" dq 0\n");
                declaredVars.add(varName);
            }

            String code = "";
            if (ctx.expr() != null) {
                code += visit(ctx.expr());
            } else if (ctx.condExpr() != null) {
                code += "    mov rax, 0\n";
            }
            code += "    mov qword [rel " + varName + "], rax\n";
            return code;
        }

        if (ctx.expr() != null) {
            return visit(ctx.expr());
        }

        return "";
    }

    @Override
    public String visitPrintStmt(PrintStmtContext ctx) {
        ValorImprimibleContext v = ctx.valorImprimible();
        if (v.DIALOGUE() != null) {
            String label = newStringLabel();
            String text = v.DIALOGUE().getText();
            dataSection.append("    ").append(label).append(" db ").append(text).append(", 10, 0\n");
            return "    lea rcx, [rel " + label + "]\n    call printf\n";
        } else if (v.expr() != null) {
            String exprText = v.expr().getText();
            if (exprText.startsWith("\"")) { 
                String label = newStringLabel();
                dataSection.append("    ").append(label).append(" db ").append(exprText).append(", 10, 0\n");
                return "    lea rcx, [rel " + label + "]\n    call printf\n";
            }
            String code = visit(v.expr());
            code += "    lea rcx, [rel format_int]\n    mov rdx, rax\n    call printf\n";
            return code;
        }
        return "";
    }

    @Override
    public String visitIfStmt(IfStmtContext ctx) {
        // Creamos etiquetas únicas para controlar los saltos del if/else
        String lEnd = newLabel();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ctx.condExpr().size(); i++) {
            String lNext = newLabel();
            String lTrue = newLabel();

            sb.append(generateCondition(ctx.condExpr(i), lTrue, lNext));
            
            sb.append(lTrue).append(":\n");
            for(StatementContext stmt : ctx.block(i).statement()) {
                sb.append(visit(stmt));
            }
            sb.append("    jmp ").append(lEnd).append("\n");
            
            sb.append(lNext).append(":\n");
        }

        if (ctx.ALTERNATE_ENDING() != null) {
            for(StatementContext stmt : ctx.block(ctx.block().size() - 1).statement()) {
                sb.append(visit(stmt));
            }
        }

        sb.append(lEnd).append(":\n");
        return sb.toString();
    }

    @Override
    public String visitForStmt(ForStmtContext ctx) {
        String lStart = newLabel();
        String lEnd = newLabel();
        StringBuilder sb = new StringBuilder();

        if (ctx.ROLE(0) != null && ctx.getChild(2).getText().equals(ctx.ROLE(0).getText())) {
            String varName = ctx.ROLE(0).getText();
            if (!declaredVars.contains(varName)) {
                dataSection.append("    ").append(varName).append(" dq 0\n");
                declaredVars.add(varName);
            }
            sb.append(visit(ctx.expr(0)));
            sb.append("    mov qword [rel ").append(varName).append("], rax\n");
        }

        sb.append(lStart).append(":\n");

        String lTrue = newLabel();
        sb.append(generateCondition(ctx.condExpr(), lTrue, lEnd));
        sb.append(lTrue).append(":\n");

        for(StatementContext stmt : ctx.block().statement()) {
            sb.append(visit(stmt));
        }

        if (ctx.ROLE().size() > 1) {
            String varName = ctx.ROLE(1).getText();
            sb.append(visit(ctx.expr(ctx.expr().size() - 1)));
            sb.append("    mov qword [rel ").append(varName).append("], rax\n");
        } else if (ctx.ROLE().size() == 1 && ctx.getChild(2).getText().equals(";")) {
            String varName = ctx.ROLE(0).getText();
            sb.append(visit(ctx.expr(0)));
            sb.append("    mov qword [rel ").append(varName).append("], rax\n");
        }

        sb.append("    jmp ").append(lStart).append("\n");
        sb.append(lEnd).append(":\n");

        return sb.toString();
    }

    private String generateCondition(CondExprContext ctx, String lTrue, String lFalse) {
        String code = visit(ctx.expr(0)); 
        code += "    push rax\n";
        code += visit(ctx.expr(1)); 
        code += "    mov rbx, rax\n";
        code += "    pop rax\n";
        code += "    cmp rax, rbx\n"; 
        
        String op = ctx.getChild(1).getText();
        if (op.equals("==")) {
            code += "    je " + lTrue + "\n";
        } else if (op.equals(">")) {
            code += "    jg " + lTrue + "\n";
        } else if (op.equals("<")) {
            code += "    jl " + lTrue + "\n";
        }
        code += "    jmp " + lFalse + "\n";
        return code;
    }

    @Override
    public String visitExpr(ExprContext ctx) {
        String result = visit(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            result += "    push rax\n";
            result += visit(ctx.term(i));
            result += "    mov rbx, rax\n";
            result += "    pop rax\n";
            String op = ctx.getChild(i * 2 - 1).getText();
            if (op.equals("+")) {
                result += "    add rax, rbx\n";
            } else if (op.equals("-")) {
                result += "    sub rax, rbx\n";
            }
        }
        return result;
    }

    @Override
    public String visitTerm(TermContext ctx) {
        String result = visit(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            result += "    push rax\n";
            result += visit(ctx.factor(i));
            result += "    mov rbx, rax\n";
            result += "    pop rax\n";
            String op = ctx.getChild(i * 2 - 1).getText();
            if (op.equals("*")) {
                result += "    imul rax, rbx\n";
            } else if (op.equals("/")) {
                result += "    cqo\n";
                result += "    idiv rbx\n";
            }
        }
        return result;
    }

    @Override
    public String visitFactor(FactorContext ctx) {
        if (ctx.FRAME() != null) {
            return "    mov rax, " + ctx.FRAME().getText() + "\n";
        } else if (ctx.ROLE() != null) {
            String varName = ctx.ROLE().getText();
            return "    mov rax, qword [rel " + varName + "]\n";
        } else if (ctx.expr() != null) {
            return visit(ctx.expr());
        } else if (ctx.HIT() != null) {
            return "    mov rax, 1\n";
        } else if (ctx.FLOP() != null) {
            return "    mov rax, 0\n";
        }
        return "    mov rax, 0\n";
    }
}
