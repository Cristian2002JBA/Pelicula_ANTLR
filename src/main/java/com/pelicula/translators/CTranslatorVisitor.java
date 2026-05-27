package com.pelicula.translators;

import com.pelicula.Director_cutParser.*;
import java.util.HashMap;
import java.util.Map;

public class CTranslatorVisitor extends BaseTranslatorVisitor {

    private Map<String, String> symbolMap = new HashMap<>();

    @Override
    protected String getProgramStart() {
        indentationLevel = 1;
        // Cabeceras estándar de C para entrada/salida y booleanos
        return "#include <stdio.h>\n#include <stdbool.h>\n\nint main() {\n";
    }

    @Override
    protected String getProgramEnd() {
        indentationLevel = 0;
        return "    return 0;\n}\n";
    }

    @Override
    protected String getDeclarationString(String id, String value, String type, boolean isCast, boolean isStar) {
        String cType = "int"; // default
        if (type != null) {
            switch(type) {
                case "ticket": cType = "int"; break;
                case "rating": cType = "float"; break;
                case "script": cType = "char*"; break;
                case "spoiler": cType = "bool"; break;
            }
        }
        symbolMap.put(id, cType);
        return cType + " " + id + " = " + value + ";";
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
        String value = getPrintValue(ctx.valorImprimible());
        String format = "\"%d\\n\""; 
        
        // Inferimos el formato para printf dependiendo del tipo de dato
        if (value.startsWith("\"")) {
            format = "\"%s\\n\"";
        } else if (symbolMap.containsKey(value)) {
            String type = symbolMap.get(value);
            if (type.equals("float")) format = "\"%.1f\\n\"";
            else if (type.equals("char*")) format = "\"%s\\n\"";
        } else {
            // Si es una expresión aritmética, intentamos deducir si es un número decimal (float)
            boolean isFloat = value.contains(".");
            for (String var : symbolMap.keySet()) {
                if (value.contains(var) && "float".equals(symbolMap.get(var))) {
                    isFloat = true;
                    break;
                }
            }
            if (isFloat) {
                format = "\"%.1f\\n\"";
            }
        }
        return getIndent() + "printf(" + format + ", " + value + ");\n";
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
            init = "int " + ctx.ROLE(0).getText() + " = " + visit(ctx.expr(0));
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
