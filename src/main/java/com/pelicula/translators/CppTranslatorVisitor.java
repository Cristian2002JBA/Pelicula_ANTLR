package com.pelicula.translators;

import com.pelicula.Director_cutParser.*;

public class CppTranslatorVisitor extends CTranslatorVisitor {

    @Override
    protected String getProgramStart() {
        indentationLevel = 1;
        return "#include <iostream>\n#include <string>\n\nint main() {\n";
    }

    @Override
    protected String getDeclarationString(String id, String value, String type, boolean isCast, boolean isStar) {
        String cppType = "auto";
        if (type != null) {
            switch(type) {
                case "ticket": cppType = "int"; break;
                case "rating": cppType = "float"; break;
                case "script": cppType = "std::string"; break;
                case "spoiler": cppType = "bool"; break;
            }
        }
        return cppType + " " + id + " = " + value + ";";
    }

    @Override
    public String visitPrintStmt(PrintStmtContext ctx) {
        return getIndent() + "std::cout << " + getPrintValue(ctx.valorImprimible()) + " << std::endl;\n";
    }

    @Override
    public String visitForStmt(ForStmtContext ctx) {
        StringBuilder sb = new StringBuilder();

        String init = "";
        String update = "";

        if (ctx.ROLE(0) != null && ctx.getChild(2).getText().equals(ctx.ROLE(0).getText())) {
            init = "auto " + ctx.ROLE(0).getText() + " = " + visit(ctx.expr(0));
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
