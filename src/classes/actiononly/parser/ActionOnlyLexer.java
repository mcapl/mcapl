// Generated from ActionOnlyLexer.g4 by ANTLR 4.7
package actiononly.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ActionOnlyLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ACTIONONLY=1, BELIEFS=2, NAME=3, WORD=4, COMMENT=5, LINE_COMMENT=6, NEWLINE=7, 
		WS=8, BELIEFRULES=9, GOAL_IB=10, IB_COMMENT=11, IB_LINE_COMMENT=12, IB_NEWLINE=13, 
		IB_WS=14, BELIEF_BLOCK=15, GOAL_RR=16, RR_COMMENT=17, RR_LINE_COMMENT=18, 
		RR_NEWLINE=19, RR_WS=20, RR_BLOCK=21, ACTIONS=22, GL_COMMENT=23, GL_LINE_COMMENT=24, 
		GL_NEWLINE=25, GL_WS=26, GOAL_BLOCK=27, CURLYOPEN=28, CURLYCLOSE=29, A_COMMENT=30, 
		A_LINE_COMMENT=31, A_NEWLINE=32, A_WS=33, ACTION_BLOCK=34;
	public static final int
		INITIAL_BELIEFS=1, REASONING_RULES=2, GOALS=3, ACTIONS_MODE=4;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "INITIAL_BELIEFS", "REASONING_RULES", "GOALS", "ACTIONS_MODE"
	};

	public static final String[] ruleNames = {
		"ACTIONONLY", "BELIEFS", "NAME", "WORD", "COMMENT", "LINE_COMMENT", "NEWLINE", 
		"WS", "BELIEFRULES", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", "IB_NEWLINE", 
		"IB_WS", "BELIEF_BLOCK", "GOAL_RR", "RR_COMMENT", "RR_LINE_COMMENT", "RR_NEWLINE", 
		"RR_WS", "RR_BLOCK", "ACTIONS", "GL_COMMENT", "GL_LINE_COMMENT", "GL_NEWLINE", 
		"GL_WS", "GOAL_BLOCK", "CURLYOPEN", "CURLYCLOSE", "A_COMMENT", "A_LINE_COMMENT", 
		"A_NEWLINE", "A_WS", "ACTION_BLOCK"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'AO'", "':Initial Beliefs:'", "':name:'", null, null, null, null, 
		null, "':Reasoning Rules:'", null, null, null, null, null, null, null, 
		null, null, null, null, null, "':Actions:'", null, null, null, null, null, 
		"'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ACTIONONLY", "BELIEFS", "NAME", "WORD", "COMMENT", "LINE_COMMENT", 
		"NEWLINE", "WS", "BELIEFRULES", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", 
		"IB_NEWLINE", "IB_WS", "BELIEF_BLOCK", "GOAL_RR", "RR_COMMENT", "RR_LINE_COMMENT", 
		"RR_NEWLINE", "RR_WS", "RR_BLOCK", "ACTIONS", "GL_COMMENT", "GL_LINE_COMMENT", 
		"GL_NEWLINE", "GL_WS", "GOAL_BLOCK", "CURLYOPEN", "CURLYCLOSE", "A_COMMENT", 
		"A_LINE_COMMENT", "A_NEWLINE", "A_WS", "ACTION_BLOCK"
	};
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


	public ActionOnlyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ActionOnlyLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u0179\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\6\5k\n\5\r\5\16\5l\3\6\3\6\3\6\3\6\7\6s\n\6\f\6\16"+
		"\6v\13\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7\u0081\n\7\f\7\16\7\u0084"+
		"\13\7\3\7\3\7\3\b\5\b\u0089\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u00bc\n\f\f\f\16\f\u00bf\13\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00ca\n\r\f\r\16\r\u00cd\13\r"+
		"\3\r\3\r\3\16\5\16\u00d2\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\6\20"+
		"\u00db\n\20\r\20\16\20\u00dc\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u00f4"+
		"\n\22\f\22\16\22\u00f7\13\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\7\23\u0102\n\23\f\23\16\23\u0105\13\23\3\23\3\23\3\24\5\24\u010a\n"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\6\26\u0116\n\26"+
		"\r\26\16\26\u0117\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\7\30\u012a\n\30\f\30\16\30\u012d\13\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u0138\n\31\f\31\16\31"+
		"\u013b\13\31\3\31\3\31\3\32\5\32\u0140\n\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\33\3\34\6\34\u0149\n\34\r\34\16\34\u014a\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\7\37\u0155\n\37\f\37\16\37\u0158\13\37\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \7 \u0163\n \f \16 \u0166\13 \3 \3 \3!\5!\u016b\n!\3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\6#\u0176\n#\r#\16#\u0177\7t\u00bd\u00f5"+
		"\u012b\u0156\2$\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35"+
		"\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34"+
		";\35=\36?\37A C!E\"G#I$\7\2\3\4\5\6\7\6\2\62;C\\aac|\3\2\f\f\4\2\13\13"+
		"\"\"\n\2\"\"*+..\60\60\62;C\\aac|\b\2*+..\62;C\\aac|\2\u018a\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\3\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2"+
		"\2\2\3\37\3\2\2\2\3!\3\2\2\2\3#\3\2\2\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3\2"+
		"\2\2\4+\3\2\2\2\4-\3\2\2\2\4/\3\2\2\2\5\61\3\2\2\2\5\63\3\2\2\2\5\65\3"+
		"\2\2\2\5\67\3\2\2\2\59\3\2\2\2\5;\3\2\2\2\6=\3\2\2\2\6?\3\2\2\2\6A\3\2"+
		"\2\2\6C\3\2\2\2\6E\3\2\2\2\6G\3\2\2\2\6I\3\2\2\2\7K\3\2\2\2\tN\3\2\2\2"+
		"\13b\3\2\2\2\rj\3\2\2\2\17n\3\2\2\2\21|\3\2\2\2\23\u0088\3\2\2\2\25\u008e"+
		"\3\2\2\2\27\u0092\3\2\2\2\31\u00a6\3\2\2\2\33\u00b7\3\2\2\2\35\u00c5\3"+
		"\2\2\2\37\u00d1\3\2\2\2!\u00d5\3\2\2\2#\u00da\3\2\2\2%\u00de\3\2\2\2\'"+
		"\u00ef\3\2\2\2)\u00fd\3\2\2\2+\u0109\3\2\2\2-\u010d\3\2\2\2/\u0115\3\2"+
		"\2\2\61\u0119\3\2\2\2\63\u0125\3\2\2\2\65\u0133\3\2\2\2\67\u013f\3\2\2"+
		"\29\u0143\3\2\2\2;\u0148\3\2\2\2=\u014c\3\2\2\2?\u014e\3\2\2\2A\u0150"+
		"\3\2\2\2C\u015e\3\2\2\2E\u016a\3\2\2\2G\u0170\3\2\2\2I\u0175\3\2\2\2K"+
		"L\7C\2\2LM\7Q\2\2M\b\3\2\2\2NO\7<\2\2OP\7K\2\2PQ\7p\2\2QR\7k\2\2RS\7v"+
		"\2\2ST\7k\2\2TU\7c\2\2UV\7n\2\2VW\7\"\2\2WX\7D\2\2XY\7g\2\2YZ\7n\2\2Z"+
		"[\7k\2\2[\\\7g\2\2\\]\7h\2\2]^\7u\2\2^_\7<\2\2_`\3\2\2\2`a\b\3\2\2a\n"+
		"\3\2\2\2bc\7<\2\2cd\7p\2\2de\7c\2\2ef\7o\2\2fg\7g\2\2gh\7<\2\2h\f\3\2"+
		"\2\2ik\t\2\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\16\3\2\2\2no\7"+
		"\61\2\2op\7,\2\2pt\3\2\2\2qs\13\2\2\2rq\3\2\2\2sv\3\2\2\2tu\3\2\2\2tr"+
		"\3\2\2\2uw\3\2\2\2vt\3\2\2\2wx\7,\2\2xy\7\61\2\2yz\3\2\2\2z{\b\6\3\2{"+
		"\20\3\2\2\2|}\7\61\2\2}~\7\61\2\2~\u0082\3\2\2\2\177\u0081\n\3\2\2\u0080"+
		"\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2"+
		"\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\b\7\3\2\u0086\22"+
		"\3\2\2\2\u0087\u0089\7\17\2\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0089\u008a\3\2\2\2\u008a\u008b\7\f\2\2\u008b\u008c\3\2\2\2\u008c\u008d"+
		"\b\b\3\2\u008d\24\3\2\2\2\u008e\u008f\t\4\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0091\b\t\3\2\u0091\26\3\2\2\2\u0092\u0093\7<\2\2\u0093\u0094\7T\2\2"+
		"\u0094\u0095\7g\2\2\u0095\u0096\7c\2\2\u0096\u0097\7u\2\2\u0097\u0098"+
		"\7q\2\2\u0098\u0099\7p\2\2\u0099\u009a\7k\2\2\u009a\u009b\7p\2\2\u009b"+
		"\u009c\7i\2\2\u009c\u009d\7\"\2\2\u009d\u009e\7T\2\2\u009e\u009f\7w\2"+
		"\2\u009f\u00a0\7n\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a3"+
		"\7<\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\n\4\2\u00a5\30\3\2\2\2\u00a6"+
		"\u00a7\7<\2\2\u00a7\u00a8\7K\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7k\2\2"+
		"\u00aa\u00ab\7v\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae"+
		"\7n\2\2\u00ae\u00af\7\"\2\2\u00af\u00b0\7I\2\2\u00b0\u00b1\7q\2\2\u00b1"+
		"\u00b2\7c\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7<\2\2\u00b4\u00b5\3\2\2"+
		"\2\u00b5\u00b6\b\13\5\2\u00b6\32\3\2\2\2\u00b7\u00b8\7\61\2\2\u00b8\u00b9"+
		"\7,\2\2\u00b9\u00bd\3\2\2\2\u00ba\u00bc\13\2\2\2\u00bb\u00ba\3\2\2\2\u00bc"+
		"\u00bf\3\2\2\2\u00bd\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c0\3\2"+
		"\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\7,\2\2\u00c1\u00c2\7\61\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c4\b\f\3\2\u00c4\34\3\2\2\2\u00c5\u00c6\7\61\2"+
		"\2\u00c6\u00c7\7\61\2\2\u00c7\u00cb\3\2\2\2\u00c8\u00ca\n\3\2\2\u00c9"+
		"\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\b\r\3\2\u00cf"+
		"\36\3\2\2\2\u00d0\u00d2\7\17\2\2\u00d1\u00d0\3\2\2\2\u00d1\u00d2\3\2\2"+
		"\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\7\f\2\2\u00d4 \3\2\2\2\u00d5\u00d6"+
		"\t\4\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\b\17\3\2\u00d8\"\3\2\2\2\u00d9"+
		"\u00db\t\5\2\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2"+
		"\2\2\u00dc\u00dd\3\2\2\2\u00dd$\3\2\2\2\u00de\u00df\7<\2\2\u00df\u00e0"+
		"\7K\2\2\u00e0\u00e1\7p\2\2\u00e1\u00e2\7k\2\2\u00e2\u00e3\7v\2\2\u00e3"+
		"\u00e4\7k\2\2\u00e4\u00e5\7c\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e7\7\"\2"+
		"\2\u00e7\u00e8\7I\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea\7c\2\2\u00ea\u00eb"+
		"\7n\2\2\u00eb\u00ec\7<\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\b\21\5\2\u00ee"+
		"&\3\2\2\2\u00ef\u00f0\7\61\2\2\u00f0\u00f1\7,\2\2\u00f1\u00f5\3\2\2\2"+
		"\u00f2\u00f4\13\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f6"+
		"\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8"+
		"\u00f9\7,\2\2\u00f9\u00fa\7\61\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\b\22"+
		"\3\2\u00fc(\3\2\2\2\u00fd\u00fe\7\61\2\2\u00fe\u00ff\7\61\2\2\u00ff\u0103"+
		"\3\2\2\2\u0100\u0102\n\3\2\2\u0101\u0100\3\2\2\2\u0102\u0105\3\2\2\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0106\3\2\2\2\u0105\u0103\3\2"+
		"\2\2\u0106\u0107\b\23\3\2\u0107*\3\2\2\2\u0108\u010a\7\17\2\2\u0109\u0108"+
		"\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\7\f\2\2\u010c"+
		",\3\2\2\2\u010d\u010e\t\4\2\2\u010e\u010f\3\2\2\2\u010f\u0110\b\25\3\2"+
		"\u0110.\3\2\2\2\u0111\u0116\t\6\2\2\u0112\u0113\7<\2\2\u0113\u0116\7/"+
		"\2\2\u0114\u0116\7\"\2\2\u0115\u0111\3\2\2\2\u0115\u0112\3\2\2\2\u0115"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\60\3\2\2\2\u0119\u011a\7<\2\2\u011a\u011b\7C\2\2\u011b\u011c"+
		"\7e\2\2\u011c\u011d\7v\2\2\u011d\u011e\7k\2\2\u011e\u011f\7q\2\2\u011f"+
		"\u0120\7p\2\2\u0120\u0121\7u\2\2\u0121\u0122\7<\2\2\u0122\u0123\3\2\2"+
		"\2\u0123\u0124\b\27\6\2\u0124\62\3\2\2\2\u0125\u0126\7\61\2\2\u0126\u0127"+
		"\7,\2\2\u0127\u012b\3\2\2\2\u0128\u012a\13\2\2\2\u0129\u0128\3\2\2\2\u012a"+
		"\u012d\3\2\2\2\u012b\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012e\3\2"+
		"\2\2\u012d\u012b\3\2\2\2\u012e\u012f\7,\2\2\u012f\u0130\7\61\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0132\b\30\3\2\u0132\64\3\2\2\2\u0133\u0134\7\61"+
		"\2\2\u0134\u0135\7\61\2\2\u0135\u0139\3\2\2\2\u0136\u0138\n\3\2\2\u0137"+
		"\u0136\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2"+
		"\2\2\u013a\u013c\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013d\b\31\3\2\u013d"+
		"\66\3\2\2\2\u013e\u0140\7\17\2\2\u013f\u013e\3\2\2\2\u013f\u0140\3\2\2"+
		"\2\u0140\u0141\3\2\2\2\u0141\u0142\7\f\2\2\u01428\3\2\2\2\u0143\u0144"+
		"\t\4\2\2\u0144\u0145\3\2\2\2\u0145\u0146\b\33\3\2\u0146:\3\2\2\2\u0147"+
		"\u0149\t\5\2\2\u0148\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u0148\3\2"+
		"\2\2\u014a\u014b\3\2\2\2\u014b<\3\2\2\2\u014c\u014d\7}\2\2\u014d>\3\2"+
		"\2\2\u014e\u014f\7\177\2\2\u014f@\3\2\2\2\u0150\u0151\7\61\2\2\u0151\u0152"+
		"\7,\2\2\u0152\u0156\3\2\2\2\u0153\u0155\13\2\2\2\u0154\u0153\3\2\2\2\u0155"+
		"\u0158\3\2\2\2\u0156\u0157\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0159\3\2"+
		"\2\2\u0158\u0156\3\2\2\2\u0159\u015a\7,\2\2\u015a\u015b\7\61\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\u015d\b\37\3\2\u015dB\3\2\2\2\u015e\u015f\7\61\2"+
		"\2\u015f\u0160\7\61\2\2\u0160\u0164\3\2\2\2\u0161\u0163\n\3\2\2\u0162"+
		"\u0161\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2"+
		"\2\2\u0165\u0167\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0168\b \3\2\u0168"+
		"D\3\2\2\2\u0169\u016b\7\17\2\2\u016a\u0169\3\2\2\2\u016a\u016b\3\2\2\2"+
		"\u016b\u016c\3\2\2\2\u016c\u016d\7\f\2\2\u016d\u016e\3\2\2\2\u016e\u016f"+
		"\b!\3\2\u016fF\3\2\2\2\u0170\u0171\t\4\2\2\u0171\u0172\3\2\2\2\u0172\u0173"+
		"\b\"\3\2\u0173H\3\2\2\2\u0174\u0176\t\5\2\2\u0175\u0174\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178J\3\2\2\2"+
		"\34\2\3\4\5\6lt\u0082\u0088\u00bd\u00cb\u00d1\u00dc\u00f5\u0103\u0109"+
		"\u0115\u0117\u012b\u0139\u013f\u014a\u0156\u0164\u016a\u0177\7\4\3\2\b"+
		"\2\2\4\4\2\4\5\2\4\6\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}