// Generated from c:/Users/chiva/Downloads/antlr-pelicual/src/main/antlr4/com/pelicula/Director_cut.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Director_cutParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

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

	@SuppressWarnings("CheckReturnValue")
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8055553824L) != 0)) {
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

	@SuppressWarnings("CheckReturnValue")
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8055553824L) != 0)) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Type_TICKET() { return getToken(Director_cutParser.Type_TICKET, 0); }
		public TerminalNode RATING() { return getToken(Director_cutParser.RATING, 0); }
		public TerminalNode SCRIPT() { return getToken(Director_cutParser.SCRIPT, 0); }
		public TerminalNode SPOILER() { return getToken(Director_cutParser.SPOILER, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15360L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStmtContext extends ParserRuleContext {
		public TerminalNode SUBTITLE() { return getToken(Director_cutParser.SUBTITLE, 0); }
		public ValorImprimibleContext valorImprimible() {
			return getRuleContext(ValorImprimibleContext.class,0);
		}
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 469762048L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
		"\u0004\u0001#\u00ab\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u001c\b\u0000\n\u0000\f\u0000"+
		"\u001f\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0005\u0001&\b\u0001\n\u0001\f\u0001)\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u00034\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003=\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003F\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003N\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003X\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005c\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006p\b\u0006\n\u0006\f\u0006s\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006w\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007~\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0086\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u0092\b\t\n\t\f\t\u0095\t\t\u0001\n\u0001\n"+
		"\u0001\n\u0005\n\u009a\b\n\n\n\f\n\u009d\t\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00a9\b\u000b\u0001\u000b\u0000\u0000\f"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0004"+
		"\u0001\u0000\n\r\u0001\u0000\u001a\u001c\u0001\u0000\u0016\u0017\u0001"+
		"\u0000\u0018\u0019\u00b9\u0000\u0018\u0001\u0000\u0000\u0000\u0002#\u0001"+
		"\u0000\u0000\u0000\u0004,\u0001\u0000\u0000\u0000\u0006W\u0001\u0000\u0000"+
		"\u0000\bY\u0001\u0000\u0000\u0000\nb\u0001\u0000\u0000\u0000\fd\u0001"+
		"\u0000\u0000\u0000\u000ex\u0001\u0000\u0000\u0000\u0010\u008a\u0001\u0000"+
		"\u0000\u0000\u0012\u008e\u0001\u0000\u0000\u0000\u0014\u0096\u0001\u0000"+
		"\u0000\u0000\u0016\u00a8\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0007"+
		"\u0000\u0000\u0019\u001d\u0005\u0001\u0000\u0000\u001a\u001c\u0003\u0006"+
		"\u0003\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000"+
		"\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000"+
		"\u0000\u0000\u001e \u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000"+
		"\u0000 !\u0005\u0002\u0000\u0000!\"\u0005\u0000\u0000\u0001\"\u0001\u0001"+
		"\u0000\u0000\u0000#\'\u0005\u0001\u0000\u0000$&\u0003\u0006\u0003\u0000"+
		"%$\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000"+
		"\u0000\'(\u0001\u0000\u0000\u0000(*\u0001\u0000\u0000\u0000)\'\u0001\u0000"+
		"\u0000\u0000*+\u0005\u0002\u0000\u0000+\u0003\u0001\u0000\u0000\u0000"+
		",-\u0007\u0000\u0000\u0000-\u0005\u0001\u0000\u0000\u0000./\u0005\b\u0000"+
		"\u0000/0\u0005\u001d\u0000\u000003\u0005\u0003\u0000\u000014\u0003\u0012"+
		"\t\u000024\u0003\u0010\b\u000031\u0001\u0000\u0000\u000032\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u000056\u0005\u0004\u0000\u00006X\u0001"+
		"\u0000\u0000\u000078\u0005\t\u0000\u000089\u0005\u001d\u0000\u00009<\u0005"+
		"\u0003\u0000\u0000:=\u0003\u0012\t\u0000;=\u0003\u0010\b\u0000<:\u0001"+
		"\u0000\u0000\u0000<;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000"+
		">?\u0005\u0004\u0000\u0000?X\u0001\u0000\u0000\u0000@A\u0003\u0004\u0002"+
		"\u0000AB\u0005\u001d\u0000\u0000BE\u0005\u0003\u0000\u0000CF\u0003\u0012"+
		"\t\u0000DF\u0003\u0010\b\u0000EC\u0001\u0000\u0000\u0000ED\u0001\u0000"+
		"\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0005\u0004\u0000\u0000HX\u0001"+
		"\u0000\u0000\u0000IJ\u0005\u001d\u0000\u0000JM\u0005\u0003\u0000\u0000"+
		"KN\u0003\u0012\t\u0000LN\u0003\u0010\b\u0000MK\u0001\u0000\u0000\u0000"+
		"ML\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0005\u0004\u0000"+
		"\u0000PX\u0001\u0000\u0000\u0000QX\u0003\b\u0004\u0000RX\u0003\f\u0006"+
		"\u0000SX\u0003\u000e\u0007\u0000TU\u0003\u0012\t\u0000UV\u0005\u0004\u0000"+
		"\u0000VX\u0001\u0000\u0000\u0000W.\u0001\u0000\u0000\u0000W7\u0001\u0000"+
		"\u0000\u0000W@\u0001\u0000\u0000\u0000WI\u0001\u0000\u0000\u0000WQ\u0001"+
		"\u0000\u0000\u0000WR\u0001\u0000\u0000\u0000WS\u0001\u0000\u0000\u0000"+
		"WT\u0001\u0000\u0000\u0000X\u0007\u0001\u0000\u0000\u0000YZ\u0005\u0010"+
		"\u0000\u0000Z[\u0005\u0005\u0000\u0000[\\\u0003\n\u0005\u0000\\]\u0005"+
		"\u0006\u0000\u0000]^\u0005\u0004\u0000\u0000^\t\u0001\u0000\u0000\u0000"+
		"_c\u0003\u0012\t\u0000`c\u0003\u0010\b\u0000ac\u0005 \u0000\u0000b_\u0001"+
		"\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000"+
		"c\u000b\u0001\u0000\u0000\u0000de\u0005\u0012\u0000\u0000ef\u0005\u0005"+
		"\u0000\u0000fg\u0003\u0010\b\u0000gh\u0005\u0006\u0000\u0000hq\u0003\u0002"+
		"\u0001\u0000ij\u0005\u0013\u0000\u0000jk\u0005\u0005\u0000\u0000kl\u0003"+
		"\u0010\b\u0000lm\u0005\u0006\u0000\u0000mn\u0003\u0002\u0001\u0000np\u0001"+
		"\u0000\u0000\u0000oi\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000"+
		"qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rv\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000tu\u0005\u0014\u0000\u0000uw\u0003\u0002"+
		"\u0001\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000w\r\u0001"+
		"\u0000\u0000\u0000xy\u0005\u0015\u0000\u0000y}\u0005\u0005\u0000\u0000"+
		"z{\u0005\u001d\u0000\u0000{|\u0005\u0003\u0000\u0000|~\u0003\u0012\t\u0000"+
		"}z\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0005\u0004\u0000\u0000\u0080\u0081\u0003\u0010"+
		"\b\u0000\u0081\u0085\u0005\u0004\u0000\u0000\u0082\u0083\u0005\u001d\u0000"+
		"\u0000\u0083\u0084\u0005\u0003\u0000\u0000\u0084\u0086\u0003\u0012\t\u0000"+
		"\u0085\u0082\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0006\u0000\u0000"+
		"\u0088\u0089\u0003\u0002\u0001\u0000\u0089\u000f\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0003\u0012\t\u0000\u008b\u008c\u0007\u0001\u0000\u0000\u008c"+
		"\u008d\u0003\u0012\t\u0000\u008d\u0011\u0001\u0000\u0000\u0000\u008e\u0093"+
		"\u0003\u0014\n\u0000\u008f\u0090\u0007\u0002\u0000\u0000\u0090\u0092\u0003"+
		"\u0014\n\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000"+
		"\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000"+
		"\u0000\u0000\u0094\u0013\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000"+
		"\u0000\u0000\u0096\u009b\u0003\u0016\u000b\u0000\u0097\u0098\u0007\u0003"+
		"\u0000\u0000\u0098\u009a\u0003\u0016\u000b\u0000\u0099\u0097\u0001\u0000"+
		"\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000"+
		"\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u0015\u0001\u0000"+
		"\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u0005"+
		"\u0000\u0000\u009f\u00a0\u0003\u0012\t\u0000\u00a0\u00a1\u0005\u0006\u0000"+
		"\u0000\u00a1\u00a9\u0001\u0000\u0000\u0000\u00a2\u00a9\u0005\u001d\u0000"+
		"\u0000\u00a3\u00a9\u0005\u001e\u0000\u0000\u00a4\u00a9\u0005\u001f\u0000"+
		"\u0000\u00a5\u00a9\u0005 \u0000\u0000\u00a6\u00a9\u0005\u000e\u0000\u0000"+
		"\u00a7\u00a9\u0005\u000f\u0000\u0000\u00a8\u009e\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a2\u0001\u0000\u0000\u0000\u00a8\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a4\u0001\u0000\u0000\u0000\u00a8\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a9\u0017\u0001\u0000\u0000\u0000\u000f\u001d\'3<EMWbqv}\u0085\u0093"+
		"\u009b\u00a8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}