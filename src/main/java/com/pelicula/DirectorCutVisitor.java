package com.pelicula;

import java.util.HashMap;
import java.util.Map;

import com.pelicula.Director_cutParser.*;
import com.pelicula.Director_cutParser.BlockContext;
import com.pelicula.Director_cutParser.CondExprContext;
import com.pelicula.Director_cutParser.ExprContext;
import com.pelicula.Director_cutParser.FactorContext;
import com.pelicula.Director_cutParser.IfStmtContext;
import com.pelicula.Director_cutParser.PrintStmtContext;
import com.pelicula.Director_cutParser.ProgramContext;
import com.pelicula.Director_cutParser.ForStmtContext;
import com.pelicula.Director_cutParser.StatementContext;
import com.pelicula.Director_cutParser.TermContext;
import com.pelicula.Director_cutParser.ValorImprimibleContext;

public class DirectorCutVisitor extends Director_cutBaseVisitor<Simbolo> {

    public final Map<String, Simbolo> tablaSimbolos = new HashMap<>();

    @Override
    public Simbolo visitProgram(ProgramContext ctx) {
        Simbolo result = null;
        for (StatementContext stmt : ctx.statement()) {
            result = visit(stmt);
        }
        return result;
    }

    @Override
    public Simbolo visitStatement(StatementContext ctx) {
        if (ctx.printStmt() != null)
            return visit(ctx.printStmt());
        if (ctx.ifStmt() != null)
            return visit(ctx.ifStmt());
        if (ctx.forStmt() != null)
            return visit(ctx.forStmt());

        if (ctx.ROLE() != null) {
            String id = ctx.ROLE().getText();
            boolean esDeclaracion = ctx.CAST() != null || ctx.STAR() != null || ctx.type() != null;

            Simbolo valorSimbolo = null;

            if (ctx.expr() != null && ctx.expr().getText().startsWith("\"")) {
                String text = ctx.expr().getText();
                String stringValue = text.substring(1, text.length() - 1);
                valorSimbolo = new Simbolo(Simbolo.TipoDato.STRING, stringValue);
            } else if (ctx.expr() != null) {
                valorSimbolo = visit(ctx.expr());
            } else if (ctx.condExpr() != null) {
                valorSimbolo = visit(ctx.condExpr());
            }

            if (!esDeclaracion) {
                Simbolo varDeclarada = tablaSimbolos.get(id);
                if (varDeclarada == null) {
                    throw new RuntimeException(
                            "Error: Variable " + id + " no declarada. (Line:" + ctx.getStart().getLine() + ")");
                }
                if (varDeclarada.tipo != valorSimbolo.tipo) {

                    throw new RuntimeException("Error: No se puede asignar " + valorSimbolo.tipo + " a "
                            + varDeclarada.tipo + ". (Line:" + ctx.getStart().getLine() + ")");
                }
            } else {
                if (tablaSimbolos.containsKey(id)) {
                    throw new RuntimeException(
                            "Error Semántico: No se puede declarar dos veces el mismo ROLE. La variable '" + id
                                    + "' ya ha sido declarada. (Line:" + ctx.getStart().getLine() + ")");
                }
            }

            tablaSimbolos.put(id, valorSimbolo);
            System.out
                    .println("[Línea " + ctx.getStart().getLine() + "] Se asigno: " + id + " = " + valorSimbolo.valor);
            return valorSimbolo;
        }

        if (ctx.expr() != null)
            return visit(ctx.expr());

        return null;
    }

    @Override
    public Simbolo visitCondExpr(CondExprContext ctx) {
        Simbolo s1 = visit(ctx.expr(0));
        Simbolo s2 = visit(ctx.expr(1));
        String operador = ctx.getChild(1).getText();

        boolean resultado = false;

        if (s1.tipo == s2.tipo) {
            switch (operador) {
                case ">":
                    if (s1.tipo == Simbolo.TipoDato.INT) {
                        resultado = (Integer) s1.valor > (Integer) s2.valor;
                    } else if (s1.tipo == Simbolo.TipoDato.FLOAT) {
                        resultado = (Float) s1.valor > (Float) s2.valor;
                    }
                    break;
                case "<":
                    if (s1.tipo == Simbolo.TipoDato.INT) {
                        resultado = (Integer) s1.valor < (Integer) s2.valor;
                    } else if (s1.tipo == Simbolo.TipoDato.FLOAT) {
                        resultado = (Float) s1.valor < (Float) s2.valor;
                    }
                    break;
                case "==":
                    resultado = s1.valor.equals(s2.valor);
                    break;
                default:
                    throw new RuntimeException(
                            "Operador desconocido: " + operador + ". (Line:" + ctx.getStart().getLine() + ")");
            }
        } else {
            throw new RuntimeException("Error: No se pueden comparar tipos distintos " + s1.tipo + " y " + s2.tipo
                    + ". (Line:" + ctx.getStart().getLine() + ")");
        }

        return new Simbolo(Simbolo.TipoDato.BOOLEAN, resultado);
    }

    @Override
    public Simbolo visitExpr(ExprContext ctx) {
        Simbolo resultado = visit(ctx.term(0));

        for (int i = 1; i < ctx.term().size(); i++) {
            String operador = ctx.getChild(i * 2 - 1).getText();
            Simbolo sigTermino = visit(ctx.term(i));

            if (resultado.tipo != Simbolo.TipoDato.INT && resultado.tipo != Simbolo.TipoDato.FLOAT) {
                throw new RuntimeException(
                        "Error Semántico: Las operaciones matemáticas como CROSSOVER (+) o CUT (-) solo funcionan con números. Tipo inválido: "
                                + resultado.tipo + ". (Line:" + ctx.getStart().getLine() + ")");
            }
            if (sigTermino.tipo != Simbolo.TipoDato.INT && sigTermino.tipo != Simbolo.TipoDato.FLOAT) {
                throw new RuntimeException(
                        "Error Semántico: Las operaciones matemáticas como CROSSOVER (+) o CUT (-) solo funcionan con números. Tipo inválido: "
                                + sigTermino.tipo + ". (Line:" + ctx.getStart().getLine() + ")");
            }

            if (resultado.tipo == sigTermino.tipo) {
                if (resultado.tipo == Simbolo.TipoDato.INT) {
                    int acumulado = (Integer) resultado.valor;
                    int operando = (Integer) sigTermino.valor;
                    if (operador.equals("+")) {
                        resultado = new Simbolo(Simbolo.TipoDato.INT, acumulado + operando);
                    } else if (operador.equals("-")) {
                        resultado = new Simbolo(Simbolo.TipoDato.INT, acumulado - operando);
                    }
                } else if (resultado.tipo == Simbolo.TipoDato.FLOAT) {
                    float acumulado = (Float) resultado.valor;
                    float operando = (Float) sigTermino.valor;
                    if (operador.equals("+")) {
                        resultado = new Simbolo(Simbolo.TipoDato.FLOAT, acumulado + operando);
                    } else if (operador.equals("-")) {
                        resultado = new Simbolo(Simbolo.TipoDato.FLOAT, acumulado - operando);
                    }
                }
            } else {
                throw new RuntimeException("Error: Tipos incompatibles " + resultado.tipo + " y " + sigTermino.tipo
                        + ". (Line:" + ctx.getStart().getLine() + ")");
            }
        }
        return resultado;
    }

    @Override
    public Simbolo visitTerm(TermContext ctx) {
        Simbolo resultado = visit(ctx.factor(0));

        for (int i = 1; i < ctx.factor().size(); i++) {
            String operador = ctx.getChild(i * 2 - 1).getText();
            Simbolo sigFactor = visit(ctx.factor(i));

            if (resultado.tipo != Simbolo.TipoDato.INT && resultado.tipo != Simbolo.TipoDato.FLOAT) {
                throw new RuntimeException(
                        "Error Semántico: Las operaciones matemáticas como FRANCHISE (*) o SPLIT_SCREEN (/) solo funcionan con números. Tipo inválido: "
                                + resultado.tipo + ". (Line:" + ctx.getStart().getLine() + ")");
            }
            if (sigFactor.tipo != Simbolo.TipoDato.INT && sigFactor.tipo != Simbolo.TipoDato.FLOAT) {
                throw new RuntimeException(
                        "Error Semántico: Las operaciones matemáticas como FRANCHISE (*) o SPLIT_SCREEN (/) solo funcionan con números. Tipo inválido: "
                                + sigFactor.tipo + ". (Line:" + ctx.getStart().getLine() + ")");
            }

            if (resultado.tipo == sigFactor.tipo) {
                if (resultado.tipo == Simbolo.TipoDato.INT) {
                    int acumulado = (Integer) resultado.valor;
                    int operando = (Integer) sigFactor.valor;
                    if (operador.equals("*")) {
                        resultado = new Simbolo(Simbolo.TipoDato.INT, acumulado * operando);
                    } else if (operador.equals("/")) {
                        if (operando == 0) {
                            throw new RuntimeException(
                                    "Error: División por cero. (Line:" + ctx.getStart().getLine() + ")");
                        }
                        resultado = new Simbolo(Simbolo.TipoDato.INT, acumulado / operando);
                    }
                } else if (resultado.tipo == Simbolo.TipoDato.FLOAT) {
                    float acumulado = (Float) resultado.valor;
                    float operando = (Float) sigFactor.valor;
                    if (operador.equals("*")) {
                        resultado = new Simbolo(Simbolo.TipoDato.FLOAT, acumulado * operando);
                    } else if (operador.equals("/")) {
                        if (operando == 0.0f) {
                            throw new RuntimeException(
                                    "Error: División por cero. (Line:" + ctx.getStart().getLine() + ")");
                        }
                        resultado = new Simbolo(Simbolo.TipoDato.FLOAT, acumulado / operando);
                    }
                }
            } else {
                throw new RuntimeException("Error: Tipos incompatibles " + resultado.tipo + " y " + sigFactor.tipo
                        + ". (Line:" + ctx.getStart().getLine() + ")");
            }
        }
        return resultado;
    }

    @Override
    public Simbolo visitFactor(FactorContext ctx) {
        if (ctx.FRAME() != null) {
            return new Simbolo(Simbolo.TipoDato.INT, Integer.parseInt(ctx.FRAME().getText()));
        } else if (ctx.DURATION() != null) {
            return new Simbolo(Simbolo.TipoDato.FLOAT, Float.parseFloat(ctx.DURATION().getText()));
        } else if (ctx.HIT() != null) {
            return new Simbolo(Simbolo.TipoDato.BOOLEAN, true);
        } else if (ctx.FLOP() != null) {
            return new Simbolo(Simbolo.TipoDato.BOOLEAN, false);
        } else if (ctx.DIALOGUE() != null) {
            String texto = ctx.DIALOGUE().getText();
            return new Simbolo(Simbolo.TipoDato.STRING, texto.substring(1, texto.length() - 1));
        } else if (ctx.ROLE() != null) {
            String id = ctx.ROLE().getText();
            Simbolo valorVariable = tablaSimbolos.get(id);
            if (valorVariable == null) {
                throw new RuntimeException("Error semántico: variable " + id + " no ha sido declarada. (Line:"
                        + ctx.getStart().getLine() + ")");
            }
            return valorVariable;
        } else if (ctx.expr() != null) {
            return visit(ctx.expr());
        }
        return null;
    }

    @Override
    public Simbolo visitIfStmt(IfStmtContext ctx) {
        Simbolo cond = visit(ctx.condExpr(0));

        if (cond.tipo == Simbolo.TipoDato.BOOLEAN && (Boolean) cond.valor) {
            for (StatementContext stmt : ctx.block(0).statement()) {
                visit(stmt);
            }
            return new Simbolo(Simbolo.TipoDato.BOOLEAN, true);
        }

        int numCondiciones = ctx.condExpr().size();
        for (int i = 1; i < numCondiciones; i++) {
            Simbolo subCond = visit(ctx.condExpr(i));
            if (subCond.tipo == Simbolo.TipoDato.BOOLEAN && (Boolean) subCond.valor) {
                for (StatementContext stmt : ctx.block(i).statement()) {
                    visit(stmt);
                }
                return new Simbolo(Simbolo.TipoDato.BOOLEAN, true);
            }
        }

        if (ctx.ALTERNATE_ENDING() != null) {
            for (StatementContext stmt : ctx.block(ctx.block().size() - 1).statement()) {
                visit(stmt);
            }
            return new Simbolo(Simbolo.TipoDato.BOOLEAN, true);
        }

        return new Simbolo(Simbolo.TipoDato.BOOLEAN, false);
    }

    @Override
    public Simbolo visitForStmt(ForStmtContext ctx) {
        if (ctx.ROLE(0) != null && ctx.getChild(2).getText().equals(ctx.ROLE(0).getText())) {
            Simbolo val = visit(ctx.expr(0));
            if (val.tipo != Simbolo.TipoDato.INT && val.tipo != Simbolo.TipoDato.FLOAT) {
                throw new RuntimeException(
                        "Error Semántico: La variable de control de un REPLAY (ciclo) debe ser de tipo numérico (FRAME o DURATION). Tipo actual: "
                                + val.tipo + ". (Line:" + ctx.getStart().getLine() + ")");
            }
            tablaSimbolos.put(ctx.ROLE(0).getText(), val);
        }

        while (true) {
            Simbolo cond = visit(ctx.condExpr());

            if (cond.tipo != Simbolo.TipoDato.BOOLEAN || !(Boolean) cond.valor) {
                break;
            }

            visit(ctx.block());

            // Actualización
            if (ctx.ROLE().size() > 1) {
                String idActualizar = ctx.ROLE(1).getText();
                Simbolo nuevoVal = visit(ctx.expr(ctx.expr().size() - 1));
                tablaSimbolos.put(idActualizar, nuevoVal);
            } else if (ctx.ROLE().size() == 1 && ctx.getChild(2).getText().equals(";")) {
                String idActualizar = ctx.ROLE(0).getText();
                Simbolo nuevoVal = visit(ctx.expr(0));
                tablaSimbolos.put(idActualizar, nuevoVal);
            }
        }
        return null;
    }

    @Override
    public Simbolo visitPrintStmt(PrintStmtContext ctx) {
        ValorImprimibleContext v = ctx.valorImprimible();
        Simbolo valor;

        String prefix = "[Línea " + ctx.getStart().getLine() + "] ";
        if (v.DIALOGUE() != null) {
            System.out.println(prefix + v.DIALOGUE().getText().replace("\"", ""));
        } else if (v.condExpr() != null) {
            valor = visit(v.condExpr());
            System.out.println(prefix + (Boolean) valor.valor);
        } else if (v.expr() != null) {
            String exprText = v.expr().getText();
            if (exprText.startsWith("\"")) {
                System.out.println(prefix + exprText.substring(1, exprText.length() - 1));
            } else {
                valor = visit(v.expr());
                System.out.println(prefix + valor.valor);
            }
        }

        return new Simbolo(Simbolo.TipoDato.BOOLEAN, true);
    }

    @Override
    public Simbolo visitBlock(BlockContext ctx) {
        Simbolo resultado = null;
        for (StatementContext stmt : ctx.statement()) {
            resultado = visit(stmt);
        }
        return resultado;
    }
}
