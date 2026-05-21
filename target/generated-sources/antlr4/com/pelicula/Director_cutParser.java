// Generated from com\pelicula\Director_cut.g4 by ANTLR 4.9.2
package com.pelicula;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Director_cutParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, PREMIERE=7, CAST=8, STAR=9, 
		Type_TICKET=10, RATING=11, SCRIPT=12, SPOILER=13, HIT=14, FLOP=15, SUBTITLE=16, 
		AUDITION=17, PLOT_TWIST=18, SPIN_OFF=19, ALTERNATE_ENDING=20, REPLAY=21, 
		CROSSOVER=22, CUT=23, FRANCHISE=24, SPLIT_SCREEN=25, BOX_OFFICE_LEADER=26, 
		FLOP_MATCH=27, CRITIC_AGREEMENT=28, ROLE=29, FRAME=30, DURATION=31, DIALOGUE=32, 
		WS=33, COMMENT=34, MULTILINE_COMMENT=35;
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_type = 2, RULE_statement = 3, RULE_printStmt = 4, 
		RULE_valorImprimible = 5, RULE_ifStmt = 6, RULE_forStmt = 7, RULE_condExpr = 8, 
		RULE_expr = 9, RULE_term = 10, RULE_factor = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "block", "type", "statement", "printStmt", "valorImprimible", 
			"ifStmt", "forStmt", "condExpr", "expr", "term", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'='", "';'", "'('", "')'", "'premiere'", "'cast'", 
			"'star'", "'ticket'", "'rating'", "'script'", "'spoiler'", "'hit'", "'flop'", 
			"'subtitle'", "'audition'", "'plot_twist'", "'spin_off'", "'alternate_ending'", 
			"'replay'", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", "'=='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "PREMIERE", "CAST", "STAR", 
			"Type_TICKET", "RATING", "SCRIPT", "SPOILER", "HIT", "FLOP", "SUBTITLE", 
			"AUDITION", "PLOT_TWIST", "SPIN_OFF", "ALTERNATE_ENDING", "REPLAY", "CROSSOVER", 
			"CUT", "FRANCHISE", "SPLIT_SCREEN", "BOX_OFFICE_LEADER", "FLOP_MATCH", 
			"CRITIC_AGREEMENT", "ROLE", "FRAME", "DURATION", "DIALOGUE", "WS", "COMMENT", 
			"MULTILINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Director_cut.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Director_cutParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PREMIERE() { return getToken(Director_cutParser.PREMIERE, 0); }
		public TerminalNode EOF() { return getToken(Director_cutParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Director_cutVisitor ) return ((Director_cutVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(PREMIERE);
			setState(25);
			match(T__0);
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << CAST) | (1L << STAR) | (1L << Type_TICKET) | (1L << RATING) | (1L << SCRIPT) | (1L << SPOILER) | (1L << HIT) | (1L << FLOP) | (1L << SUBTITLE) | (1L << PLOT_TWIST) | (1L << REPLAY) | (1L << ROLE) | (1L << FRAME) | (1L << DURATION) | (1L << DIALOGUE))) != 0)) {
				{
				{
				setState(26);
				statement();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
			match(T__1);
			setState(33);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Director_cutVisitor ) return ((Director_cutVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__0);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << CAST) | (1L << STAR) | (1L << Type_TICKET) | (1L << RATING) | (1L << SCRIPT) | (1L << SPOILER) | (1L << HIT) | (1L << FLOP) | (1L << SUBTITLE) | (1L << PLOT_TWIST) | (1L << REPLAY) | (1L << ROLE) | (1L << FRAME) | (1L << DURATION) | (1L << DIALOGUE))) != 0)) {
				{
				{
				setState(36);
				statement();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Type_TICKET() { return getToken(Director_cutParser.Type_TICKET, 0); }
		public TerminalNode RATING() { return getToken(Director_cutParser.RATING, 0); }
		public TerminalNode SCRIPT() { return getToken(Director_cutParser.SCRIPT, 0); }
		public TerminalNode SPOILER() { return getToken(Director_cutParser.SPOILER, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Director_cutVisitor ) return ((Director_cutVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Type_TICKET) | (1L << RATING) | (1L << SCRIPT) | (1L << SPOILER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode CAST() { return getToken(Director_cutParser.CAST, 0); }
		public TerminalNode ROLE() { return getToken(Director_cutParser.ROLE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CondExprContext condExpr() {
			return getRuleContext(CondExprContext.class,0);
		}
		public TerminalNode STAR() { return getToken(Director_cutParser.STAR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public PrintStmtContext printStmt() {
			return getRuleContext(PrintStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Director_cutVisitor ) return ((Director_cutVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(CAST);
				setState(47);
				match(ROLE);
				setState(48);
				match(T__2);
				setState(51);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(49);
					expr();
					}
					break;
				case 2:
					{
					setState(50);
					condExpr();
					}
					break;
				}
				setState(53);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(STAR);
				setState(56);
				match(ROLE);
				setState(57);
				match(T__2);
				setState(60);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(58);
					expr();
					}
					break;
				case 2:
					{
					setState(59);
					condExpr();
					}
					break;
				}
				setState(62);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				type();
				setState(65);
				match(ROLE);
				setState(66);
				match(T__2);
				setState(69);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(67);
					expr();
					}
					break;
				case 2:
					{
					setState(68);
					condExpr();
					}
					break;
				}
				setState(71);
				match(T__3);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				match(ROLE);
				setState(74);
				match(T__2);
				setState(77);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(75);
					expr();
					}
					break;
				case 2:
					{
					setState(76);
					condExpr();
					}
					break;
				}
				setState(79);
				match(T__3);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				printStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				ifStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(83);
				forStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(84);
				expr();
				setState(85);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStmtContext extends ParserRuleContext {
		public TerminalNode SUBTITLE() { return getToken(Director_cutParser.SUBTITLE, 0); }
		public ValorImprimibleContext valorImprimible() {
			return getRuleContext(ValorImprimibleContext.class,0);
		}
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).enterPrintStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).exitPrintStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Director_cutVisitor ) return ((Director_cutVisitor<? extends T>)visitor).visitPrintStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStmtContext printStmt() throws RecognitionException {
		PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_printStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(SUBTITLE);
			setState(90);
			match(T__4);
			setState(91);
			valorImprimible();
			setState(92);
			match(T__5);
			setState(93);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValorImprimibleContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CondExprContext condExpr() {
			return getRuleContext(CondExprContext.class,0);
		}
		public TerminalNode DIALOGUE() { return getToken(Director_cutParser.DIALOGUE, 0); }
		public ValorImprimibleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valorImprimible; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).enterValorImprimible(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).exitValorImprimible(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Director_cutVisitor ) return ((Director_cutVisitor<? extends T>)visitor).visitValorImprimible(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValorImprimibleContext valorImprimible() throws RecognitionException {
		ValorImprimibleContext _localctx = new ValorImprimibleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_valorImprimible);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				condExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(DIALOGUE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode PLOT_TWIST() { return getToken(Director_cutParser.PLOT_TWIST, 0); }
		public List<CondExprContext> condExpr() {
			return getRuleContexts(CondExprContext.class);
		}
		public CondExprContext condExpr(int i) {
			return getRuleContext(CondExprContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TerminalNode> SPIN_OFF() { return getTokens(Director_cutParser.SPIN_OFF); }
		public TerminalNode SPIN_OFF(int i) {
			return getToken(Director_cutParser.SPIN_OFF, i);
		}
		public TerminalNode ALTERNATE_ENDING() { return getToken(Director_cutParser.ALTERNATE_ENDING, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Director_cutVisitor ) return ((Director_cutVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(PLOT_TWIST);
			setState(101);
			match(T__4);
			setState(102);
			condExpr();
			setState(103);
			match(T__5);
			setState(104);
			block();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPIN_OFF) {
				{
				{
				setState(105);
				match(SPIN_OFF);
				setState(106);
				match(T__4);
				setState(107);
				condExpr();
				setState(108);
				match(T__5);
				setState(109);
				block();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALTERNATE_ENDING) {
				{
				setState(116);
				match(ALTERNATE_ENDING);
				setState(117);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode REPLAY() { return getToken(Director_cutParser.REPLAY, 0); }
		public CondExprContext condExpr() {
			return getRuleContext(CondExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> ROLE() { return getTokens(Director_cutParser.ROLE); }
		public TerminalNode ROLE(int i) {
			return getToken(Director_cutParser.ROLE, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Director_cutVisitor ) return ((Director_cutVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(REPLAY);
			setState(121);
			match(T__4);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ROLE) {
				{
				setState(122);
				match(ROLE);
				setState(123);
				match(T__2);
				setState(124);
				expr();
				}
			}

			setState(127);
			match(T__3);
			setState(128);
			condExpr();
			setState(129);
			match(T__3);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ROLE) {
				{
				setState(130);
				match(ROLE);
				setState(131);
				match(T__2);
				setState(132);
				expr();
				}
			}

			setState(135);
			match(T__5);
			setState(136);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondExprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BOX_OFFICE_LEADER() { return getToken(Director_cutParser.BOX_OFFICE_LEADER, 0); }
		public TerminalNode CRITIC_AGREEMENT() { return getToken(Director_cutParser.CRITIC_AGREEMENT, 0); }
		public TerminalNode FLOP_MATCH() { return getToken(Director_cutParser.FLOP_MATCH, 0); }
		public CondExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).enterCondExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).exitCondExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Director_cutVisitor ) return ((Director_cutVisitor<? extends T>)visitor).visitCondExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondExprContext condExpr() throws RecognitionException {
		CondExprContext _localctx = new CondExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_condExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			expr();
			setState(139);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOX_OFFICE_LEADER) | (1L << FLOP_MATCH) | (1L << CRITIC_AGREEMENT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(140);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> CROSSOVER() { return getTokens(Director_cutParser.CROSSOVER); }
		public TerminalNode CROSSOVER(int i) {
			return getToken(Director_cutParser.CROSSOVER, i);
		}
		public List<TerminalNode> CUT() { return getTokens(Director_cutParser.CUT); }
		public TerminalNode CUT(int i) {
			return getToken(Director_cutParser.CUT, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Director_cutVisitor ) return ((Director_cutVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			term();
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CROSSOVER || _la==CUT) {
				{
				{
				setState(143);
				_la = _input.LA(1);
				if ( !(_la==CROSSOVER || _la==CUT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(144);
				term();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> FRANCHISE() { return getTokens(Director_cutParser.FRANCHISE); }
		public TerminalNode FRANCHISE(int i) {
			return getToken(Director_cutParser.FRANCHISE, i);
		}
		public List<TerminalNode> SPLIT_SCREEN() { return getTokens(Director_cutParser.SPLIT_SCREEN); }
		public TerminalNode SPLIT_SCREEN(int i) {
			return getToken(Director_cutParser.SPLIT_SCREEN, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Director_cutVisitor ) return ((Director_cutVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			factor();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FRANCHISE || _la==SPLIT_SCREEN) {
				{
				{
				setState(151);
				_la = _input.LA(1);
				if ( !(_la==FRANCHISE || _la==SPLIT_SCREEN) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(152);
				factor();
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ROLE() { return getToken(Director_cutParser.ROLE, 0); }
		public TerminalNode FRAME() { return getToken(Director_cutParser.FRAME, 0); }
		public TerminalNode DURATION() { return getToken(Director_cutParser.DURATION, 0); }
		public TerminalNode DIALOGUE() { return getToken(Director_cutParser.DIALOGUE, 0); }
		public TerminalNode HIT() { return getToken(Director_cutParser.HIT, 0); }
		public TerminalNode FLOP() { return getToken(Director_cutParser.FLOP, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Director_cutListener ) ((Director_cutListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Director_cutVisitor ) return ((Director_cutVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_factor);
		try {
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(T__4);
				setState(159);
				expr();
				setState(160);
				match(T__5);
				}
				break;
			case ROLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				match(ROLE);
				}
				break;
			case FRAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				match(FRAME);
				}
				break;
			case DURATION:
				enterOuterAlt(_localctx, 4);
				{
				setState(164);
				match(DURATION);
				}
				break;
			case DIALOGUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(165);
				match(DIALOGUE);
				}
				break;
			case HIT:
				enterOuterAlt(_localctx, 6);
				{
				setState(166);
				match(HIT);
				}
				break;
			case FLOP:
				enterOuterAlt(_localctx, 7);
				{
				setState(167);
				match(FLOP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00ad\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3\2"+
		"\3\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5"+
		"\5\66\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5?\n\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\5\5H\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5P\n\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5Z\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\5\7e\n\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\br\n\b\f\b\16\bu\13\b\3\b\3\b\5"+
		"\by\n\b\3\t\3\t\3\t\3\t\3\t\5\t\u0080\n\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t"+
		"\u0088\n\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u0094\n\13"+
		"\f\13\16\13\u0097\13\13\3\f\3\f\3\f\7\f\u009c\n\f\f\f\16\f\u009f\13\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ab\n\r\3\r\2\2\16\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\2\6\3\2\f\17\3\2\34\36\3\2\30\31\3\2\32\33"+
		"\2\u00bb\2\32\3\2\2\2\4%\3\2\2\2\6.\3\2\2\2\bY\3\2\2\2\n[\3\2\2\2\fd\3"+
		"\2\2\2\16f\3\2\2\2\20z\3\2\2\2\22\u008c\3\2\2\2\24\u0090\3\2\2\2\26\u0098"+
		"\3\2\2\2\30\u00aa\3\2\2\2\32\33\7\t\2\2\33\37\7\3\2\2\34\36\5\b\5\2\35"+
		"\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2"+
		"\2\"#\7\4\2\2#$\7\2\2\3$\3\3\2\2\2%)\7\3\2\2&(\5\b\5\2\'&\3\2\2\2(+\3"+
		"\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\7\4\2\2-\5\3\2\2\2."+
		"/\t\2\2\2/\7\3\2\2\2\60\61\7\n\2\2\61\62\7\37\2\2\62\65\7\5\2\2\63\66"+
		"\5\24\13\2\64\66\5\22\n\2\65\63\3\2\2\2\65\64\3\2\2\2\66\67\3\2\2\2\67"+
		"8\7\6\2\28Z\3\2\2\29:\7\13\2\2:;\7\37\2\2;>\7\5\2\2<?\5\24\13\2=?\5\22"+
		"\n\2><\3\2\2\2>=\3\2\2\2?@\3\2\2\2@A\7\6\2\2AZ\3\2\2\2BC\5\6\4\2CD\7\37"+
		"\2\2DG\7\5\2\2EH\5\24\13\2FH\5\22\n\2GE\3\2\2\2GF\3\2\2\2HI\3\2\2\2IJ"+
		"\7\6\2\2JZ\3\2\2\2KL\7\37\2\2LO\7\5\2\2MP\5\24\13\2NP\5\22\n\2OM\3\2\2"+
		"\2ON\3\2\2\2PQ\3\2\2\2QR\7\6\2\2RZ\3\2\2\2SZ\5\n\6\2TZ\5\16\b\2UZ\5\20"+
		"\t\2VW\5\24\13\2WX\7\6\2\2XZ\3\2\2\2Y\60\3\2\2\2Y9\3\2\2\2YB\3\2\2\2Y"+
		"K\3\2\2\2YS\3\2\2\2YT\3\2\2\2YU\3\2\2\2YV\3\2\2\2Z\t\3\2\2\2[\\\7\22\2"+
		"\2\\]\7\7\2\2]^\5\f\7\2^_\7\b\2\2_`\7\6\2\2`\13\3\2\2\2ae\5\24\13\2be"+
		"\5\22\n\2ce\7\"\2\2da\3\2\2\2db\3\2\2\2dc\3\2\2\2e\r\3\2\2\2fg\7\24\2"+
		"\2gh\7\7\2\2hi\5\22\n\2ij\7\b\2\2js\5\4\3\2kl\7\25\2\2lm\7\7\2\2mn\5\22"+
		"\n\2no\7\b\2\2op\5\4\3\2pr\3\2\2\2qk\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2"+
		"\2\2tx\3\2\2\2us\3\2\2\2vw\7\26\2\2wy\5\4\3\2xv\3\2\2\2xy\3\2\2\2y\17"+
		"\3\2\2\2z{\7\27\2\2{\177\7\7\2\2|}\7\37\2\2}~\7\5\2\2~\u0080\5\24\13\2"+
		"\177|\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\7\6\2"+
		"\2\u0082\u0083\5\22\n\2\u0083\u0087\7\6\2\2\u0084\u0085\7\37\2\2\u0085"+
		"\u0086\7\5\2\2\u0086\u0088\5\24\13\2\u0087\u0084\3\2\2\2\u0087\u0088\3"+
		"\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\7\b\2\2\u008a\u008b\5\4\3\2\u008b"+
		"\21\3\2\2\2\u008c\u008d\5\24\13\2\u008d\u008e\t\3\2\2\u008e\u008f\5\24"+
		"\13\2\u008f\23\3\2\2\2\u0090\u0095\5\26\f\2\u0091\u0092\t\4\2\2\u0092"+
		"\u0094\5\26\f\2\u0093\u0091\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3"+
		"\2\2\2\u0095\u0096\3\2\2\2\u0096\25\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u009d\5\30\r\2\u0099\u009a\t\5\2\2\u009a\u009c\5\30\r\2\u009b\u0099\3"+
		"\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\27\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7\7\2\2\u00a1\u00a2\5\24\13"+
		"\2\u00a2\u00a3\7\b\2\2\u00a3\u00ab\3\2\2\2\u00a4\u00ab\7\37\2\2\u00a5"+
		"\u00ab\7 \2\2\u00a6\u00ab\7!\2\2\u00a7\u00ab\7\"\2\2\u00a8\u00ab\7\20"+
		"\2\2\u00a9\u00ab\7\21\2\2\u00aa\u00a0\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa"+
		"\u00a5\3\2\2\2\u00aa\u00a6\3\2\2\2\u00aa\u00a7\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00aa\u00a9\3\2\2\2\u00ab\31\3\2\2\2\21\37)\65>GOYdsx\177\u0087\u0095"+
		"\u009d\u00aa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}