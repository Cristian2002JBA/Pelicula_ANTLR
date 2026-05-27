package com.pelicula.translators;

import com.pelicula.Director_cutParser.*;

public class JavaScriptTranslatorVisitor extends BaseTranslatorVisitor {

    @Override
    protected String getProgramStart() {
        return "// Traducción a JavaScript\n";
    }

    @Override
    protected String getProgramEnd() {
        return "";
    }

    @Override
    protected String getDeclarationString(String id, String value, String type, boolean isCast, boolean isStar) {
        return "let " + id + " = " + value + ";";
    }

    @Override
    protected String getAssignmentString(String id, String value) {
        return id + " = " + value + ";";
    }

    @Override
    protected String getExpressionStatementString(String expr) {
        return expr + ";";
    }

    @Override
    public String visitPrintStmt(PrintStmtContext ctx) {
        // En JS usamos console.log para mostrar mensajes
        return getIndent() + "console.log(" + getPrintValue(ctx.valorImprimible()) + ");\n";
    }

    @Override
    public String visitIfStmt(IfStmtContext ctx) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(getIndent()).append("if (").append(visit(ctx.condExpr(0))).append(") {\n");
        sb.append(formatBlock(ctx.block(0)));
        sb.append(getIndent()).append("}\n");

        int blockIndex = 1;
        for (int i = 1; i < ctx.condExpr().size(); i++) {
            sb.append(getIndent()).append("else if (").append(visit(ctx.condExpr(i))).append(") {\n");
            sb.append(formatBlock(ctx.block(blockIndex++)));
            sb.append(getIndent()).append("}\n");
        }

        if (ctx.ALTERNATE_ENDING() != null) {
            sb.append(getIndent()).append("else {\n");
            sb.append(formatBlock(ctx.block(blockIndex)));
            sb.append(getIndent()).append("}\n");
        }

        return sb.toString();
    }

    @Override
    public String visitForStmt(ForStmtContext ctx) {
        StringBuilder sb = new StringBuilder();

        String init = "";
        String update = "";

        if (ctx.ROLE(0) != null && ctx.getChild(2).getText().equals(ctx.ROLE(0).getText())) {
            init = "let " + ctx.ROLE(0).getText() + " = " + visit(ctx.expr(0));
        }

        if (ctx.ROLE().size() > 1) {
            update = ctx.ROLE(1).getText() + " = " + visit(ctx.expr(ctx.expr().size() - 1));
        } else if (ctx.ROLE().size() == 1 && ctx.getChild(2).getText().equals(";")) {
            update = ctx.ROLE(0).getText() + " = " + visit(ctx.expr(0));
        }

        String cond = visit(ctx.condExpr());

        sb.append(getIndent()).append("for (").append(init).append("; ").append(cond).append("; ").append(update).append(") {\n");
        sb.append(formatBlock(ctx.block()));
        sb.append(getIndent()).append("}\n");

        return sb.toString();
    }
}
