// Generated from c:\Users\chiva\OneDrive\Escritorio\Proyecto-pelicula\antlr-pelicual\src\main\antlr4\com\pelicula\Director_cut.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "PREMIERE", "CREDITS", 
			"CAST", "STAR", "Type_TICKET", "RATING", "SCRIPT", "SPOILER", "HIT", 
			"FLOP", "SUBTITLE", "AUDITION", "PLOT_TWIST", "SPIN_OFF", "ALTERNATE_ENDING", 
			"REPLAY", "MONTAGE", "INTERMISSION", "JUMP_CUT", "SCENE", "WRAP", "EXTRA", 
			"ID", "INT", "FLOAT", "STRING", "WS"
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


	public LanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Director_cut.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u0126\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\7\36"+
		"\u0102\n\36\f\36\16\36\u0105\13\36\3\37\6\37\u0108\n\37\r\37\16\37\u0109"+
		"\3 \6 \u010d\n \r \16 \u010e\3 \3 \6 \u0113\n \r \16 \u0114\3!\3!\7!\u0119"+
		"\n!\f!\16!\u011c\13!\3!\3!\3\"\6\"\u0121\n\"\r\"\16\"\u0122\3\"\3\"\3"+
		"\u011a\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#\3\2\6\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\5\2\13\f"+
		"\17\17\"\"\2\u012b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E"+
		"\3\2\2\2\5G\3\2\2\2\7I\3\2\2\2\tK\3\2\2\2\13M\3\2\2\2\rO\3\2\2\2\17Q\3"+
		"\2\2\2\21Z\3\2\2\2\23b\3\2\2\2\25g\3\2\2\2\27l\3\2\2\2\31s\3\2\2\2\33"+
		"z\3\2\2\2\35\u0081\3\2\2\2\37\u0089\3\2\2\2!\u008d\3\2\2\2#\u0092\3\2"+
		"\2\2%\u009b\3\2\2\2\'\u00a4\3\2\2\2)\u00af\3\2\2\2+\u00b8\3\2\2\2-\u00c9"+
		"\3\2\2\2/\u00d0\3\2\2\2\61\u00d8\3\2\2\2\63\u00e5\3\2\2\2\65\u00ee\3\2"+
		"\2\2\67\u00f4\3\2\2\29\u00f9\3\2\2\2;\u00ff\3\2\2\2=\u0107\3\2\2\2?\u010c"+
		"\3\2\2\2A\u0116\3\2\2\2C\u0120\3\2\2\2EF\7}\2\2F\4\3\2\2\2GH\7\177\2\2"+
		"H\6\3\2\2\2IJ\7?\2\2J\b\3\2\2\2KL\7=\2\2L\n\3\2\2\2MN\7*\2\2N\f\3\2\2"+
		"\2OP\7+\2\2P\16\3\2\2\2QR\7r\2\2RS\7t\2\2ST\7g\2\2TU\7o\2\2UV\7k\2\2V"+
		"W\7g\2\2WX\7t\2\2XY\7g\2\2Y\20\3\2\2\2Z[\7e\2\2[\\\7t\2\2\\]\7g\2\2]^"+
		"\7f\2\2^_\7k\2\2_`\7v\2\2`a\7u\2\2a\22\3\2\2\2bc\7e\2\2cd\7c\2\2de\7u"+
		"\2\2ef\7v\2\2f\24\3\2\2\2gh\7u\2\2hi\7v\2\2ij\7c\2\2jk\7t\2\2k\26\3\2"+
		"\2\2lm\7v\2\2mn\7k\2\2no\7e\2\2op\7m\2\2pq\7g\2\2qr\7v\2\2r\30\3\2\2\2"+
		"st\7t\2\2tu\7c\2\2uv\7v\2\2vw\7k\2\2wx\7p\2\2xy\7i\2\2y\32\3\2\2\2z{\7"+
		"u\2\2{|\7e\2\2|}\7t\2\2}~\7k\2\2~\177\7r\2\2\177\u0080\7v\2\2\u0080\34"+
		"\3\2\2\2\u0081\u0082\7u\2\2\u0082\u0083\7r\2\2\u0083\u0084\7q\2\2\u0084"+
		"\u0085\7k\2\2\u0085\u0086\7n\2\2\u0086\u0087\7g\2\2\u0087\u0088\7t\2\2"+
		"\u0088\36\3\2\2\2\u0089\u008a\7j\2\2\u008a\u008b\7k\2\2\u008b\u008c\7"+
		"v\2\2\u008c \3\2\2\2\u008d\u008e\7h\2\2\u008e\u008f\7n\2\2\u008f\u0090"+
		"\7q\2\2\u0090\u0091\7r\2\2\u0091\"\3\2\2\2\u0092\u0093\7u\2\2\u0093\u0094"+
		"\7w\2\2\u0094\u0095\7d\2\2\u0095\u0096\7v\2\2\u0096\u0097\7k\2\2\u0097"+
		"\u0098\7v\2\2\u0098\u0099\7n\2\2\u0099\u009a\7g\2\2\u009a$\3\2\2\2\u009b"+
		"\u009c\7c\2\2\u009c\u009d\7w\2\2\u009d\u009e\7f\2\2\u009e\u009f\7k\2\2"+
		"\u009f\u00a0\7v\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2\7q\2\2\u00a2\u00a3"+
		"\7p\2\2\u00a3&\3\2\2\2\u00a4\u00a5\7r\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7"+
		"\7q\2\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7a\2\2\u00a9\u00aa\7v\2\2\u00aa"+
		"\u00ab\7y\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7v\2\2"+
		"\u00ae(\3\2\2\2\u00af\u00b0\7u\2\2\u00b0\u00b1\7r\2\2\u00b1\u00b2\7k\2"+
		"\2\u00b2\u00b3\7p\2\2\u00b3\u00b4\7a\2\2\u00b4\u00b5\7q\2\2\u00b5\u00b6"+
		"\7h\2\2\u00b6\u00b7\7h\2\2\u00b7*\3\2\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba"+
		"\7n\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7t\2\2\u00bd"+
		"\u00be\7p\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7g\2\2"+
		"\u00c1\u00c2\7a\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5"+
		"\7f\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7i\2\2\u00c8"+
		",\3\2\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7r\2\2\u00cc"+
		"\u00cd\7n\2\2\u00cd\u00ce\7c\2\2\u00ce\u00cf\7{\2\2\u00cf.\3\2\2\2\u00d0"+
		"\u00d1\7o\2\2\u00d1\u00d2\7q\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7v\2\2"+
		"\u00d4\u00d5\7c\2\2\u00d5\u00d6\7i\2\2\u00d6\u00d7\7g\2\2\u00d7\60\3\2"+
		"\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da\7p\2\2\u00da\u00db\7v\2\2\u00db\u00dc"+
		"\7g\2\2\u00dc\u00dd\7t\2\2\u00dd\u00de\7o\2\2\u00de\u00df\7k\2\2\u00df"+
		"\u00e0\7u\2\2\u00e0\u00e1\7u\2\2\u00e1\u00e2\7k\2\2\u00e2\u00e3\7q\2\2"+
		"\u00e3\u00e4\7p\2\2\u00e4\62\3\2\2\2\u00e5\u00e6\7l\2\2\u00e6\u00e7\7"+
		"w\2\2\u00e7\u00e8\7o\2\2\u00e8\u00e9\7r\2\2\u00e9\u00ea\7a\2\2\u00ea\u00eb"+
		"\7e\2\2\u00eb\u00ec\7w\2\2\u00ec\u00ed\7v\2\2\u00ed\64\3\2\2\2\u00ee\u00ef"+
		"\7u\2\2\u00ef\u00f0\7e\2\2\u00f0\u00f1\7g\2\2\u00f1\u00f2\7p\2\2\u00f2"+
		"\u00f3\7g\2\2\u00f3\66\3\2\2\2\u00f4\u00f5\7y\2\2\u00f5\u00f6\7t\2\2\u00f6"+
		"\u00f7\7c\2\2\u00f7\u00f8\7r\2\2\u00f88\3\2\2\2\u00f9\u00fa\7g\2\2\u00fa"+
		"\u00fb\7z\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7t\2\2\u00fd\u00fe\7c\2\2"+
		"\u00fe:\3\2\2\2\u00ff\u0103\t\2\2\2\u0100\u0102\t\3\2\2\u0101\u0100\3"+
		"\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"<\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0108\t\4\2\2\u0107\u0106\3\2\2\2"+
		"\u0108\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a>\3"+
		"\2\2\2\u010b\u010d\t\4\2\2\u010c\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\7\60"+
		"\2\2\u0111\u0113\t\4\2\2\u0112\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115@\3\2\2\2\u0116\u011a\7$\2\2\u0117"+
		"\u0119\13\2\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u011b\3"+
		"\2\2\2\u011a\u0118\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d"+
		"\u011e\7$\2\2\u011eB\3\2\2\2\u011f\u0121\t\5\2\2\u0120\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0125\b\"\2\2\u0125D\3\2\2\2\t\2\u0103\u0109\u010e\u0114\u011a"+
		"\u0122\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}