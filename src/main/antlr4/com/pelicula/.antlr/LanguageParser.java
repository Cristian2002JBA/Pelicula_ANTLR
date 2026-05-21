// Generated from c:\Users\chiva\OneDrive\Escritorio\Proyecto-pelicula\antlr-pelicual\src\main\antlr4\com\pelicula\Language.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, PREMIERE=7, CREDITS=8, 
		CAST=9, STAR=10, Type_TICKET=11, RATING=12, SCRIPT=13, SPOILER=14, HIT=15, 
		FLOP=16, SUBTITLE=17, AUDITION=18, PLOT_TWIST=19, SPIN_OFF=20, ALTERNATE_ENDING=21, 
		REPLAY=22, MONTAGE=23, INTERMISSION=24, JUMP_CUT=25, SCENE=26, WRAP=27, 
		EXTRA=28, ID=29, INT=30, FLOAT=31, STRING=32, WS=33;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_mainBlock = 2, RULE_block = 3, RULE_type = 4, 
		RULE_statement = 5, RULE_printStmt = 6, RULE_ifStmt = 7, RULE_start = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "mainBlock", "block", "type", "statement", "printStmt", 
			"ifStmt", "start"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'='", "';'", "'('", "')'", "'premiere'", "'credits'", 
			"'cast'", "'star'", "'ticket'", "'rating'", "'script'", "'spoiler'", 
			"'hit'", "'flop'", "'subtitle'", "'audition'", "'plot_twist'", "'spin_off'", 
			"'alternate_ending'", "'replay'", "'montage'", "'intermission'", "'jump_cut'", 
			"'scene'", "'wrap'", "'extra'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "PREMIERE", "CREDITS", "CAST", 
			"STAR", "Type_TICKET", "RATING", "SCRIPT", "SPOILER", "HIT", "FLOP", 
			"SUBTITLE", "AUDITION", "PLOT_TWIST", "SPIN_OFF", "ALTERNATE_ENDING", 
			"REPLAY", "MONTAGE", "INTERMISSION", "JUMP_CUT", "SCENE", "WRAP", "EXTRA", 
			"ID", "INT", "FLOAT", "STRING", "WS"
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
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public MainBlockContext mainBlock() {
			return getRuleContext(MainBlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LanguageParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			mainBlock();
			setState(19);
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode INT() { return getToken(LanguageParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LanguageParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(LanguageParser.STRING, 0); }
		public TerminalNode HIT() { return getToken(LanguageParser.HIT, 0); }
		public TerminalNode FLOP() { return getToken(LanguageParser.FLOP, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HIT) | (1L << FLOP) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << STRING))) != 0)) ) {
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

	public static class MainBlockContext extends ParserRuleContext {
		public TerminalNode PREMIERE() { return getToken(LanguageParser.PREMIERE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainBlock; }
	}

	public final MainBlockContext mainBlock() throws RecognitionException {
		MainBlockContext _localctx = new MainBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mainBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			match(PREMIERE);
			setState(24);
			match(T__0);
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CREDITS) | (1L << CAST) | (1L << STAR) | (1L << Type_TICKET) | (1L << RATING) | (1L << SCRIPT) | (1L << SPOILER) | (1L << HIT) | (1L << FLOP) | (1L << SUBTITLE) | (1L << PLOT_TWIST) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << STRING))) != 0)) {
				{
				{
				setState(25);
				statement();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
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
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(T__0);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CREDITS) | (1L << CAST) | (1L << STAR) | (1L << Type_TICKET) | (1L << RATING) | (1L << SCRIPT) | (1L << SPOILER) | (1L << HIT) | (1L << FLOP) | (1L << SUBTITLE) | (1L << PLOT_TWIST) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << STRING))) != 0)) {
				{
				{
				setState(34);
				statement();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
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
		public TerminalNode Type_TICKET() { return getToken(LanguageParser.Type_TICKET, 0); }
		public TerminalNode RATING() { return getToken(LanguageParser.RATING, 0); }
		public TerminalNode SCRIPT() { return getToken(LanguageParser.SCRIPT, 0); }
		public TerminalNode SPOILER() { return getToken(LanguageParser.SPOILER, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
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
		public TerminalNode CAST() { return getToken(LanguageParser.CAST, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STAR() { return getToken(LanguageParser.STAR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CREDITS() { return getToken(LanguageParser.CREDITS, 0); }
		public PrintStmtContext printStmt() {
			return getRuleContext(PrintStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAST:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				match(CAST);
				setState(45);
				match(ID);
				setState(46);
				match(T__2);
				setState(47);
				expr();
				setState(48);
				match(T__3);
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(STAR);
				setState(51);
				match(ID);
				setState(52);
				match(T__2);
				setState(53);
				expr();
				setState(54);
				match(T__3);
				}
				break;
			case Type_TICKET:
			case RATING:
			case SCRIPT:
			case SPOILER:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				type();
				setState(57);
				match(ID);
				setState(58);
				match(T__2);
				setState(59);
				expr();
				setState(60);
				match(T__3);
				}
				break;
			case CREDITS:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				match(CREDITS);
				setState(63);
				match(T__4);
				setState(64);
				expr();
				setState(65);
				match(T__5);
				setState(66);
				match(T__3);
				}
				break;
			case SUBTITLE:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				printStmt();
				}
				break;
			case PLOT_TWIST:
				enterOuterAlt(_localctx, 6);
				{
				setState(69);
				ifStmt();
				}
				break;
			case HIT:
			case FLOP:
			case ID:
			case INT:
			case FLOAT:
			case STRING:
				enterOuterAlt(_localctx, 7);
				{
				setState(70);
				expr();
				setState(71);
				match(T__3);
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

	public static class PrintStmtContext extends ParserRuleContext {
		public TerminalNode SUBTITLE() { return getToken(LanguageParser.SUBTITLE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
	}

	public final PrintStmtContext printStmt() throws RecognitionException {
		PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_printStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(SUBTITLE);
			setState(76);
			match(T__4);
			setState(77);
			expr();
			setState(78);
			match(T__5);
			setState(79);
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

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode PLOT_TWIST() { return getToken(LanguageParser.PLOT_TWIST, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ALTERNATE_ENDING() { return getToken(LanguageParser.ALTERNATE_ENDING, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifStmt);
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(PLOT_TWIST);
				setState(82);
				match(T__4);
				setState(83);
				expr();
				setState(84);
				match(T__5);
				setState(85);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				match(PLOT_TWIST);
				setState(88);
				match(T__4);
				setState(89);
				expr();
				setState(90);
				match(T__5);
				setState(91);
				block();
				setState(92);
				match(ALTERNATE_ENDING);
				setState(93);
				block();
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

	public static class StartContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LanguageParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			expr();
			setState(98);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#g\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\4\7\4\35\n\4\f\4\16\4 \13\4\3\4\3\4\3\5\3\5\7\5&\n\5"+
		"\f\5\16\5)\13\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\5\7L\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tb\n\t\3\n\3\n\3\n\3\n\2\2\13\2\4\6\b\n"+
		"\f\16\20\22\2\4\4\2\21\22\37\"\3\2\r\20\2f\2\24\3\2\2\2\4\27\3\2\2\2\6"+
		"\31\3\2\2\2\b#\3\2\2\2\n,\3\2\2\2\fK\3\2\2\2\16M\3\2\2\2\20a\3\2\2\2\22"+
		"c\3\2\2\2\24\25\5\6\4\2\25\26\7\2\2\3\26\3\3\2\2\2\27\30\t\2\2\2\30\5"+
		"\3\2\2\2\31\32\7\t\2\2\32\36\7\3\2\2\33\35\5\f\7\2\34\33\3\2\2\2\35 \3"+
		"\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37!\3\2\2\2 \36\3\2\2\2!\"\7\4\2\2"+
		"\"\7\3\2\2\2#\'\7\3\2\2$&\5\f\7\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3"+
		"\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\7\4\2\2+\t\3\2\2\2,-\t\3\2\2-\13\3\2\2\2"+
		"./\7\13\2\2/\60\7\37\2\2\60\61\7\5\2\2\61\62\5\4\3\2\62\63\7\6\2\2\63"+
		"L\3\2\2\2\64\65\7\f\2\2\65\66\7\37\2\2\66\67\7\5\2\2\678\5\4\3\289\7\6"+
		"\2\29L\3\2\2\2:;\5\n\6\2;<\7\37\2\2<=\7\5\2\2=>\5\4\3\2>?\7\6\2\2?L\3"+
		"\2\2\2@A\7\n\2\2AB\7\7\2\2BC\5\4\3\2CD\7\b\2\2DE\7\6\2\2EL\3\2\2\2FL\5"+
		"\16\b\2GL\5\20\t\2HI\5\4\3\2IJ\7\6\2\2JL\3\2\2\2K.\3\2\2\2K\64\3\2\2\2"+
		"K:\3\2\2\2K@\3\2\2\2KF\3\2\2\2KG\3\2\2\2KH\3\2\2\2L\r\3\2\2\2MN\7\23\2"+
		"\2NO\7\7\2\2OP\5\4\3\2PQ\7\b\2\2QR\7\6\2\2R\17\3\2\2\2ST\7\25\2\2TU\7"+
		"\7\2\2UV\5\4\3\2VW\7\b\2\2WX\5\b\5\2Xb\3\2\2\2YZ\7\25\2\2Z[\7\7\2\2[\\"+
		"\5\4\3\2\\]\7\b\2\2]^\5\b\5\2^_\7\27\2\2_`\5\b\5\2`b\3\2\2\2aS\3\2\2\2"+
		"aY\3\2\2\2b\21\3\2\2\2cd\5\4\3\2de\7\2\2\3e\23\3\2\2\2\6\36\'Ka";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}