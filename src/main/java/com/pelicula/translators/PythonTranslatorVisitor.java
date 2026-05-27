package com.pelicula.translators;

import com.pelicula.Director_cutParser.*;

public class PythonTranslatorVisitor extends BaseTranslatorVisitor {

    @Override
    protected String getProgramStart() {
        return "# Traducción a Python\n";
    }

    @Override
    protected String getProgramEnd() {
        return "";
    }

    // En Python los booleanos empiezan con mayúscula (True/False)
    @Override
    protected String getTrueString() { return "True"; }

    @Override
    protected String getFalseString() { return "False"; }

    // Python es de tipado dinámico y no usa palabras reservadas como let/var/int para declarar
    @Override
    protected String getDeclarationString(String id, String value, String type, boolean isCast, boolean isStar) {
        return id + " = " + value;
    }

    // La asignación es idéntica a la declaración en cuanto a sintaxis
    @Override
    protected String getAssignmentString(String id, String value) {
        return id + " = " + value;
    }

    // Python no lleva punto y coma al final de las sentencias
    @Override
    protected String getExpressionStatementString(String expr) {
        return expr;
    }

    @Override
    public String visitPrintStmt(PrintStmtContext ctx) {
        // En Python la función de impresión es simplemente 'print()'
        return getIndent() + "print(" + getPrintValue(ctx.valorImprimible()) + ")\n";
    }

    @Override
    public String visitIfStmt(IfStmtContext ctx) {
        StringBuilder sb = new StringBuilder();
        
        // Python no usa llaves, por lo que marcamos el bloque con ':' y manejamos la indentación en el helper
        sb.append(getIndent()).append("if ").append(visit(ctx.condExpr(0))).append(":\n");
        sb.append(formatBlockPython(ctx.block(0)));

        int blockIndex = 1;
        for (int i = 1; i < ctx.condExpr().size(); i++) {
            sb.append(getIndent()).append("elif ").append(visit(ctx.condExpr(i))).append(":\n");
            sb.append(formatBlockPython(ctx.block(blockIndex++)));
        }

        if (ctx.ALTERNATE_ENDING() != null) {
            sb.append(getIndent()).append("else:\n");
            sb.append(formatBlockPython(ctx.block(blockIndex)));
        }

        return sb.toString();
    }

    // Python no tiene un bucle "for clásico" al estilo C (for(i=0; i<10; i++)),
    // por lo que traducimos nuestro "replay" a un bucle "while" equivalente.
    @Override
    public String visitForStmt(ForStmtContext ctx) {
        StringBuilder sb = new StringBuilder();

        String init = "";
        String update = "";

        // Verificamos si hay una variable de inicialización
        if (ctx.ROLE(0) != null && ctx.getChild(2).getText().equals(ctx.ROLE(0).getText())) {
            init = ctx.ROLE(0).getText() + " = " + visit(ctx.expr(0));
            sb.append(getIndent()).append(init).append("\n");
        }

        if (ctx.ROLE().size() > 1) {
            update = ctx.ROLE(1).getText() + " = " + visit(ctx.expr(ctx.expr().size() - 1));
        } else if (ctx.ROLE().size() == 1 && ctx.getChild(2).getText().equals(";")) {
            update = ctx.ROLE(0).getText() + " = " + visit(ctx.expr(0));
        }

        String cond = visit(ctx.condExpr());

        sb.append(getIndent()).append("while ").append(cond).append(":\n");
        
        indentationLevel++;
        for (StatementContext stmt : ctx.block().statement()) {
            sb.append(visit(stmt));
        }
        if (!update.isEmpty()) {
            sb.append(getIndent()).append(update).append("\n");
        }
        indentationLevel--;

        return sb.toString();
    }

    // Función auxiliar para manejar bloques en Python.
    // Incrementa la indentación antes de procesar el bloque y si este está vacío,
    // inserta 'pass' para evitar un error de sintaxis en Python.
    private String formatBlockPython(BlockContext ctx) {
        StringBuilder sb = new StringBuilder();
        indentationLevel++;
        for (StatementContext stmt : ctx.statement()) {
            sb.append(visit(stmt));
        }
        if (ctx.statement().isEmpty()) {
            sb.append(getIndent()).append("pass\n");
        }
        indentationLevel--;
        return sb.toString();
    }
}
