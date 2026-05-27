package com.pelicula.translators;

import com.pelicula.Director_cutBaseVisitor;
import com.pelicula.Director_cutParser.*;

/**
 * Clase base abstracta para todos los traductores (C, C++, JS, TS, etc.).
 * Implementa la estructura central del patrón Visitor de ANTLR.
 * Las clases hijas solo necesitan definir cómo se escribe la sintaxis de cada lenguaje.
 */
public abstract class BaseTranslatorVisitor extends Director_cutBaseVisitor<String> {
    protected int indentationLevel = 0;

    protected String getIndent() {
        return "    ".repeat(indentationLevel);
    }

    @Override
    public String visitProgram(ProgramContext ctx) {
        // Inicializamos el programa con las librerías o cabeceras necesarias
        StringBuilder builder = new StringBuilder();
        builder.append(getProgramStart());
        for (StatementContext stmt : ctx.statement()) {
            builder.append(visit(stmt));
        }
        builder.append(getProgramEnd());
        return builder.toString();
    }

    protected abstract String getProgramStart();
    protected abstract String getProgramEnd();

    @Override
    public String visitStatement(StatementContext ctx) {
        if (ctx.printStmt() != null) return visit(ctx.printStmt());
        if (ctx.ifStmt() != null) return visit(ctx.ifStmt());
        if (ctx.forStmt() != null) return visit(ctx.forStmt());

        if (ctx.ROLE() != null) {
            String roleName = ctx.ROLE().getText();
            String value = ctx.expr() != null ? visit(ctx.expr()) : visit(ctx.condExpr());
            boolean isDeclaration = ctx.CAST() != null || ctx.STAR() != null || ctx.type() != null;
            
            if (isDeclaration) {
                String typeStr = ctx.type() != null ? ctx.type().getText() : null;
                return getIndent() + getDeclarationString(roleName, value, typeStr, ctx.CAST() != null, ctx.STAR() != null) + "\n";
            } else {
                return getIndent() + getAssignmentString(roleName, value) + "\n";
            }
        }
        
        if (ctx.expr() != null) {
            return getIndent() + getExpressionStatementString(visit(ctx.expr())) + "\n";
        }

        return "";
    }

    protected abstract String getDeclarationString(String id, String value, String type, boolean isCast, boolean isStar);
    protected abstract String getAssignmentString(String id, String value);
    protected abstract String getExpressionStatementString(String expr);

    @Override
    public abstract String visitPrintStmt(PrintStmtContext ctx);

    @Override
    public abstract String visitIfStmt(IfStmtContext ctx);

    @Override
    public abstract String visitForStmt(ForStmtContext ctx);

    @Override
    public String visitCondExpr(CondExprContext ctx) {
        String s1 = visit(ctx.expr(0));
        String s2 = visit(ctx.expr(1));
        String operator = ctx.getChild(1).getText();
        return s1 + " " + operator + " " + s2;
    }

    @Override
    public String visitExpr(ExprContext ctx) {
        String result = visit(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            String operator = ctx.getChild(i * 2 - 1).getText();
            String nextTerm = visit(ctx.term(i));
            result += " " + operator + " " + nextTerm;
        }
        return result;
    }

    @Override
    public String visitTerm(TermContext ctx) {
        String result = visit(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            String operator = ctx.getChild(i * 2 - 1).getText();
            String nextFactor = visit(ctx.factor(i));
            result += " " + operator + " " + nextFactor;
        }
        return result;
    }

    @Override
    public String visitFactor(FactorContext ctx) {
        if (ctx.FRAME() != null) {
            return ctx.FRAME().getText();
        } else if (ctx.DURATION() != null) {
            return ctx.DURATION().getText();
        } else if (ctx.HIT() != null) {
            return getTrueString();
        } else if (ctx.FLOP() != null) {
            return getFalseString();
        } else if (ctx.DIALOGUE() != null) {
            return ctx.DIALOGUE().getText();
        } else if (ctx.ROLE() != null) {
            return ctx.ROLE().getText();
        } else if (ctx.expr() != null) {
            return "(" + visit(ctx.expr()) + ")";
        }
        return "";
    }

    protected String getTrueString() { return "true"; }
    protected String getFalseString() { return "false"; }
    
    // Auxiliar para evaluar qué imprimir (expr, condExpr o DIALOGUE)
    protected String getPrintValue(ValorImprimibleContext ctx) {
        if (ctx.DIALOGUE() != null) return ctx.DIALOGUE().getText();
        if (ctx.expr() != null) return visit(ctx.expr());
        if (ctx.condExpr() != null) return visit(ctx.condExpr());
        return "";
    }

    // Auxiliar para obtener el contenido de un bloque (para lenguajes sin indentación obligatoria pero con {})
    protected String formatBlock(BlockContext ctx) {
        StringBuilder sb = new StringBuilder();
        indentationLevel++;
        for (StatementContext stmt : ctx.statement()) {
            sb.append(visit(stmt));
        }
        indentationLevel--;
        return sb.toString();
    }
}
