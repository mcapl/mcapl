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
		null, "':Reasoning Rules:'", null, null, null, null, null, "'abelief'", 
		null, null, null, null, null, null, "':Actions:'", null, null, null, null, 
		null, "'{'", "'}'"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u018e\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\6\5k\n\5\r\5\16\5l\3\6\3\6\3\6\3\6\7\6s\n\6\f\6\16"+
		"\6v\13\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7\u0081\n\7\f\7\16\7\u0084"+
		"\13\7\3\7\3\7\3\b\5\b\u0089\n\b\3\b\3\b\3\b\3\b\3\t\6\t\u0090\n\t\r\t"+
		"\16\t\u0091\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u00bf"+
		"\n\f\f\f\16\f\u00c2\13\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00cd"+
		"\n\r\f\r\16\r\u00d0\13\r\3\r\3\r\3\16\5\16\u00d5\n\16\3\16\3\16\3\16\3"+
		"\16\3\17\6\17\u00dc\n\17\r\17\16\17\u00dd\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u00ff\n\22"+
		"\f\22\16\22\u0102\13\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\7"+
		"\23\u010d\n\23\f\23\16\23\u0110\13\23\3\23\3\23\3\24\5\24\u0115\n\24\3"+
		"\24\3\24\3\24\3\24\3\25\6\25\u011c\n\25\r\25\16\25\u011d\3\25\3\25\3\26"+
		"\6\26\u0123\n\26\r\26\16\26\u0124\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u0137\n\30\f\30\16\30"+
		"\u013a\13\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u0145\n"+
		"\31\f\31\16\31\u0148\13\31\3\31\3\31\3\32\5\32\u014d\n\32\3\32\3\32\3"+
		"\32\3\32\3\33\6\33\u0154\n\33\r\33\16\33\u0155\3\33\3\33\3\34\6\34\u015b"+
		"\n\34\r\34\16\34\u015c\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u0167"+
		"\n\37\f\37\16\37\u016a\13\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \7 \u0175"+
		"\n \f \16 \u0178\13 \3 \3 \3!\5!\u017d\n!\3!\3!\3!\3!\3\"\6\"\u0184\n"+
		"\"\r\"\16\"\u0185\3\"\3\"\3#\6#\u018b\n#\r#\16#\u018c\tt\u00c0\u0100\u0124"+
		"\u0138\u0168\u018c\2$\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f"+
		"\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67"+
		"\339\34;\35=\36?\37A C!E\"G#I$\7\2\3\4\5\6\6\6\2\62;C\\aac|\3\2\f\f\4"+
		"\2\13\13\"\"\b\2*+..\62;C\\aac|\2\u01a1\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\3\27\3\2\2\2\3\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2\2\2\3\37\3\2\2\2\3!\3"+
		"\2\2\2\3#\3\2\2\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3\2\2\2\4+\3\2\2\2\4-\3\2"+
		"\2\2\4/\3\2\2\2\5\61\3\2\2\2\5\63\3\2\2\2\5\65\3\2\2\2\5\67\3\2\2\2\5"+
		"9\3\2\2\2\5;\3\2\2\2\6=\3\2\2\2\6?\3\2\2\2\6A\3\2\2\2\6C\3\2\2\2\6E\3"+
		"\2\2\2\6G\3\2\2\2\6I\3\2\2\2\7K\3\2\2\2\tN\3\2\2\2\13b\3\2\2\2\rj\3\2"+
		"\2\2\17n\3\2\2\2\21|\3\2\2\2\23\u0088\3\2\2\2\25\u008f\3\2\2\2\27\u0095"+
		"\3\2\2\2\31\u00a9\3\2\2\2\33\u00ba\3\2\2\2\35\u00c8\3\2\2\2\37\u00d4\3"+
		"\2\2\2!\u00db\3\2\2\2#\u00e1\3\2\2\2%\u00e9\3\2\2\2\'\u00fa\3\2\2\2)\u0108"+
		"\3\2\2\2+\u0114\3\2\2\2-\u011b\3\2\2\2/\u0122\3\2\2\2\61\u0126\3\2\2\2"+
		"\63\u0132\3\2\2\2\65\u0140\3\2\2\2\67\u014c\3\2\2\29\u0153\3\2\2\2;\u015a"+
		"\3\2\2\2=\u015e\3\2\2\2?\u0160\3\2\2\2A\u0162\3\2\2\2C\u0170\3\2\2\2E"+
		"\u017c\3\2\2\2G\u0183\3\2\2\2I\u018a\3\2\2\2KL\7C\2\2LM\7Q\2\2M\b\3\2"+
		"\2\2NO\7<\2\2OP\7K\2\2PQ\7p\2\2QR\7k\2\2RS\7v\2\2ST\7k\2\2TU\7c\2\2UV"+
		"\7n\2\2VW\7\"\2\2WX\7D\2\2XY\7g\2\2YZ\7n\2\2Z[\7k\2\2[\\\7g\2\2\\]\7h"+
		"\2\2]^\7u\2\2^_\7<\2\2_`\3\2\2\2`a\b\3\2\2a\n\3\2\2\2bc\7<\2\2cd\7p\2"+
		"\2de\7c\2\2ef\7o\2\2fg\7g\2\2gh\7<\2\2h\f\3\2\2\2ik\t\2\2\2ji\3\2\2\2"+
		"kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\16\3\2\2\2no\7\61\2\2op\7,\2\2pt\3\2\2"+
		"\2qs\13\2\2\2rq\3\2\2\2sv\3\2\2\2tu\3\2\2\2tr\3\2\2\2uw\3\2\2\2vt\3\2"+
		"\2\2wx\7,\2\2xy\7\61\2\2yz\3\2\2\2z{\b\6\3\2{\20\3\2\2\2|}\7\61\2\2}~"+
		"\7\61\2\2~\u0082\3\2\2\2\177\u0081\n\3\2\2\u0080\177\3\2\2\2\u0081\u0084"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0085\u0086\b\7\3\2\u0086\22\3\2\2\2\u0087\u0089\7\17\2"+
		"\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b"+
		"\7\f\2\2\u008b\u008c\3\2\2\2\u008c\u008d\b\b\3\2\u008d\24\3\2\2\2\u008e"+
		"\u0090\t\4\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\b\t\3\2\u0094"+
		"\26\3\2\2\2\u0095\u0096\7<\2\2\u0096\u0097\7T\2\2\u0097\u0098\7g\2\2\u0098"+
		"\u0099\7c\2\2\u0099\u009a\7u\2\2\u009a\u009b\7q\2\2\u009b\u009c\7p\2\2"+
		"\u009c\u009d\7k\2\2\u009d\u009e\7p\2\2\u009e\u009f\7i\2\2\u009f\u00a0"+
		"\7\"\2\2\u00a0\u00a1\7T\2\2\u00a1\u00a2\7w\2\2\u00a2\u00a3\7n\2\2\u00a3"+
		"\u00a4\7g\2\2\u00a4\u00a5\7u\2\2\u00a5\u00a6\7<\2\2\u00a6\u00a7\3\2\2"+
		"\2\u00a7\u00a8\b\n\4\2\u00a8\30\3\2\2\2\u00a9\u00aa\7<\2\2\u00aa\u00ab"+
		"\7K\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7v\2\2\u00ae"+
		"\u00af\7k\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7\"\2"+
		"\2\u00b2\u00b3\7I\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b6"+
		"\7n\2\2\u00b6\u00b7\7<\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\b\13\5\2\u00b9"+
		"\32\3\2\2\2\u00ba\u00bb\7\61\2\2\u00bb\u00bc\7,\2\2\u00bc\u00c0\3\2\2"+
		"\2\u00bd\u00bf\13\2\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c3\u00c4\7,\2\2\u00c4\u00c5\7\61\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c7\b\f\3\2\u00c7\34\3\2\2\2\u00c8\u00c9\7\61\2\2\u00c9\u00ca\7\61"+
		"\2\2\u00ca\u00ce\3\2\2\2\u00cb\u00cd\n\3\2\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2"+
		"\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\b\r\3\2\u00d2\36\3\2\2\2\u00d3\u00d5"+
		"\7\17\2\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2"+
		"\u00d6\u00d7\7\f\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\b\16\3\2\u00d9 \3"+
		"\2\2\2\u00da\u00dc\t\4\2\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\b\17"+
		"\3\2\u00e0\"\3\2\2\2\u00e1\u00e2\7c\2\2\u00e2\u00e3\7d\2\2\u00e3\u00e4"+
		"\7g\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7k\2\2\u00e6\u00e7\7g\2\2\u00e7"+
		"\u00e8\7h\2\2\u00e8$\3\2\2\2\u00e9\u00ea\7<\2\2\u00ea\u00eb\7K\2\2\u00eb"+
		"\u00ec\7p\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7k\2\2"+
		"\u00ef\u00f0\7c\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f2\7\"\2\2\u00f2\u00f3"+
		"\7I\2\2\u00f3\u00f4\7q\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7n\2\2\u00f6"+
		"\u00f7\7<\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\b\21\5\2\u00f9&\3\2\2\2"+
		"\u00fa\u00fb\7\61\2\2\u00fb\u00fc\7,\2\2\u00fc\u0100\3\2\2\2\u00fd\u00ff"+
		"\13\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u0101\3\2\2\2"+
		"\u0100\u00fe\3\2\2\2\u0101\u0103\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104"+
		"\7,\2\2\u0104\u0105\7\61\2\2\u0105\u0106\3\2\2\2\u0106\u0107\b\22\3\2"+
		"\u0107(\3\2\2\2\u0108\u0109\7\61\2\2\u0109\u010a\7\61\2\2\u010a\u010e"+
		"\3\2\2\2\u010b\u010d\n\3\2\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u010e\3\2"+
		"\2\2\u0111\u0112\b\23\3\2\u0112*\3\2\2\2\u0113\u0115\7\17\2\2\u0114\u0113"+
		"\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\7\f\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u0119\b\24\3\2\u0119,\3\2\2\2\u011a\u011c\t\4\2\2"+
		"\u011b\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e"+
		"\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\b\25\3\2\u0120.\3\2\2\2\u0121"+
		"\u0123\13\2\2\2\u0122\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3"+
		"\2\2\2\u0124\u0122\3\2\2\2\u0125\60\3\2\2\2\u0126\u0127\7<\2\2\u0127\u0128"+
		"\7C\2\2\u0128\u0129\7e\2\2\u0129\u012a\7v\2\2\u012a\u012b\7k\2\2\u012b"+
		"\u012c\7q\2\2\u012c\u012d\7p\2\2\u012d\u012e\7u\2\2\u012e\u012f\7<\2\2"+
		"\u012f\u0130\3\2\2\2\u0130\u0131\b\27\6\2\u0131\62\3\2\2\2\u0132\u0133"+
		"\7\61\2\2\u0133\u0134\7,\2\2\u0134\u0138\3\2\2\2\u0135\u0137\13\2\2\2"+
		"\u0136\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0139\3\2\2\2\u0138\u0136"+
		"\3\2\2\2\u0139\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\7,\2\2\u013c"+
		"\u013d\7\61\2\2\u013d\u013e\3\2\2\2\u013e\u013f\b\30\3\2\u013f\64\3\2"+
		"\2\2\u0140\u0141\7\61\2\2\u0141\u0142\7\61\2\2\u0142\u0146\3\2\2\2\u0143"+
		"\u0145\n\3\2\2\u0144\u0143\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2"+
		"\2\2\u0146\u0147\3\2\2\2\u0147\u0149\3\2\2\2\u0148\u0146\3\2\2\2\u0149"+
		"\u014a\b\31\3\2\u014a\66\3\2\2\2\u014b\u014d\7\17\2\2\u014c\u014b\3\2"+
		"\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\7\f\2\2\u014f"+
		"\u0150\3\2\2\2\u0150\u0151\b\32\3\2\u01518\3\2\2\2\u0152\u0154\t\4\2\2"+
		"\u0153\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156"+
		"\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\b\33\7\2\u0158:\3\2\2\2\u0159"+
		"\u015b\t\5\2\2\u015a\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015a\3\2"+
		"\2\2\u015c\u015d\3\2\2\2\u015d<\3\2\2\2\u015e\u015f\7}\2\2\u015f>\3\2"+
		"\2\2\u0160\u0161\7\177\2\2\u0161@\3\2\2\2\u0162\u0163\7\61\2\2\u0163\u0164"+
		"\7,\2\2\u0164\u0168\3\2\2\2\u0165\u0167\13\2\2\2\u0166\u0165\3\2\2\2\u0167"+
		"\u016a\3\2\2\2\u0168\u0169\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u016b\3\2"+
		"\2\2\u016a\u0168\3\2\2\2\u016b\u016c\7,\2\2\u016c\u016d\7\61\2\2\u016d"+
		"\u016e\3\2\2\2\u016e\u016f\b\37\3\2\u016fB\3\2\2\2\u0170\u0171\7\61\2"+
		"\2\u0171\u0172\7\61\2\2\u0172\u0176\3\2\2\2\u0173\u0175\n\3\2\2\u0174"+
		"\u0173\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2"+
		"\2\2\u0177\u0179\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u017a\b \3\2\u017a"+
		"D\3\2\2\2\u017b\u017d\7\17\2\2\u017c\u017b\3\2\2\2\u017c\u017d\3\2\2\2"+
		"\u017d\u017e\3\2\2\2\u017e\u017f\7\f\2\2\u017f\u0180\3\2\2\2\u0180\u0181"+
		"\b!\3\2\u0181F\3\2\2\2\u0182\u0184\t\4\2\2\u0183\u0182\3\2\2\2\u0184\u0185"+
		"\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\3\2\2\2\u0187"+
		"\u0188\b\"\3\2\u0188H\3\2\2\2\u0189\u018b\13\2\2\2\u018a\u0189\3\2\2\2"+
		"\u018b\u018c\3\2\2\2\u018c\u018d\3\2\2\2\u018c\u018a\3\2\2\2\u018dJ\3"+
		"\2\2\2\37\2\3\4\5\6lt\u0082\u0088\u0091\u00c0\u00ce\u00d4\u00dd\u0100"+
		"\u010e\u0114\u011d\u0124\u0138\u0146\u014c\u0155\u015c\u0168\u0176\u017c"+
		"\u0185\u018c\b\4\3\2\b\2\2\4\4\2\4\5\2\4\6\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}