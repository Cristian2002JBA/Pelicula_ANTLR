// Generated from com\pelicula\Director_cut.g4 by ANTLR 4.9.2
package com.pelicula;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Director_cutParser}.
 */
public interface Director_cutListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Director_cutParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(Director_cutParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Director_cutParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(Director_cutParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link Director_cutParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Director_cutParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Director_cutParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Director_cutParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Director_cutParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(Director_cutParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Director_cutParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(Director_cutParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Director_cutParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Director_cutParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Director_cutParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Director_cutParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Director_cutParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(Director_cutParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Director_cutParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(Director_cutParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Director_cutParser#valorImprimible}.
	 * @param ctx the parse tree
	 */
	void enterValorImprimible(Director_cutParser.ValorImprimibleContext ctx);
	/**
	 * Exit a parse tree produced by {@link Director_cutParser#valorImprimible}.
	 * @param ctx the parse tree
	 */
	void exitValorImprimible(Director_cutParser.ValorImprimibleContext ctx);
	/**
	 * Enter a parse tree produced by {@link Director_cutParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(Director_cutParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Director_cutParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(Director_cutParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Director_cutParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(Director_cutParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Director_cutParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(Director_cutParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Director_cutParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void enterCondExpr(Director_cutParser.CondExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Director_cutParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void exitCondExpr(Director_cutParser.CondExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Director_cutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(Director_cutParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Director_cutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(Director_cutParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Director_cutParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(Director_cutParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link Director_cutParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(Director_cutParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link Director_cutParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(Director_cutParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Director_cutParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(Director_cutParser.FactorContext ctx);
}