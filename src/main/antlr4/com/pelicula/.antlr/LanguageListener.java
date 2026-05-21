// Generated from c:/Users/chiva/OneDrive/Escritorio/Proyecto-pelicula/antlr-pelicual/src/main/antlr4/com/pelicula/Language.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#mainBlock}.
	 * @param ctx the parse tree
	 */
	void enterMainBlock(LanguageParser.MainBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#mainBlock}.
	 * @param ctx the parse tree
	 */
	void exitMainBlock(LanguageParser.MainBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LanguageParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LanguageParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LanguageParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LanguageParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LanguageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(LanguageParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(LanguageParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(LanguageParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(LanguageParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(LanguageParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(LanguageParser.StartContext ctx);
}