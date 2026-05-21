// Generated from com\pelicula\Director_cut.g4 by ANTLR 4.9.2
package com.pelicula;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Director_cutParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Director_cutVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Director_cutParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Director_cutParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Director_cutParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(Director_cutParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Director_cutParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(Director_cutParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Director_cutParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(Director_cutParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Director_cutParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(Director_cutParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Director_cutParser#valorImprimible}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValorImprimible(Director_cutParser.ValorImprimibleContext ctx);
	/**
	 * Visit a parse tree produced by {@link Director_cutParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(Director_cutParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Director_cutParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(Director_cutParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Director_cutParser#condExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpr(Director_cutParser.CondExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Director_cutParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(Director_cutParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Director_cutParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(Director_cutParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link Director_cutParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(Director_cutParser.FactorContext ctx);
}