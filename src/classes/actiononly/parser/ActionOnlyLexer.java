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
		WS=8, GOAL_IB=9, IB_COMMENT=10, IB_LINE_COMMENT=11, IB_NEWLINE=12, IB_WS=13, 
		BELIEF_BLOCK=14, R1=15, R2=16, GL_COMMENT=17, GL_LINE_COMMENT=18, GL_NEWLINE=19, 
		GL_WS=20, GOAL_BLOCK=21;
	public static final int
		INITIAL_BELIEFS=1, REASONING_RULES=2, GOALS=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "INITIAL_BELIEFS", "REASONING_RULES", "GOALS"
	};

	public static final String[] ruleNames = {
		"ACTIONONLY", "BELIEFS", "NAME", "WORD", "COMMENT", "LINE_COMMENT", "NEWLINE", 
		"WS", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", "IB_NEWLINE", "IB_WS", 
		"BELIEF_BLOCK", "R1", "R2", "GL_COMMENT", "GL_LINE_COMMENT", "GL_NEWLINE", 
		"GL_WS", "GOAL_BLOCK"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'AO'", "':Initial Beliefs:'", "':name:'", null, null, null, null, 
		null, "':Initial Goal:'", null, null, null, null, null, "'a'", "'b'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ACTIONONLY", "BELIEFS", "NAME", "WORD", "COMMENT", "LINE_COMMENT", 
		"NEWLINE", "WS", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", "IB_NEWLINE", 
		"IB_WS", "BELIEF_BLOCK", "R1", "R2", "GL_COMMENT", "GL_LINE_COMMENT", 
		"GL_NEWLINE", "GL_WS", "GOAL_BLOCK"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00de\b\1\b\1"+
		"\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21"+
		"\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\6\5P\n\5\r\5\16\5Q\3\6\3\6\3"+
		"\6\3\6\7\6X\n\6\f\6\16\6[\13\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7"+
		"f\n\7\f\7\16\7i\13\7\3\7\3\7\3\b\5\bn\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\7\13\u008d\n\13\f\13\16\13\u0090\13\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u009b\n\f\f\f\16\f\u009e\13\f\3\f"+
		"\3\f\3\r\5\r\u00a3\n\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\6\17\u00ae"+
		"\n\17\r\17\16\17\u00af\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u00ba"+
		"\n\22\f\22\16\22\u00bd\13\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\7\23\u00c8\n\23\f\23\16\23\u00cb\13\23\3\23\3\23\3\24\5\24\u00d0\n"+
		"\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\6\26\u00db\n\26\r\26"+
		"\16\26\u00dc\5Y\u008e\u00bb\2\27\6\3\b\4\n\5\f\6\16\7\20\b\22\t\24\n\26"+
		"\13\30\f\32\r\34\16\36\17 \20\"\21$\22&\23(\24*\25,\26.\27\6\2\3\4\5\6"+
		"\6\2\62;C\\aac|\3\2\f\f\4\2\13\13\"\"\t\2*+..\60\60\62;C\\aac|\2\u00e6"+
		"\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2"+
		"\2\2\2\22\3\2\2\2\2\24\3\2\2\2\3\26\3\2\2\2\3\30\3\2\2\2\3\32\3\2\2\2"+
		"\3\34\3\2\2\2\3\36\3\2\2\2\3 \3\2\2\2\4\"\3\2\2\2\4$\3\2\2\2\5&\3\2\2"+
		"\2\5(\3\2\2\2\5*\3\2\2\2\5,\3\2\2\2\5.\3\2\2\2\6\60\3\2\2\2\b\63\3\2\2"+
		"\2\nG\3\2\2\2\fO\3\2\2\2\16S\3\2\2\2\20a\3\2\2\2\22m\3\2\2\2\24s\3\2\2"+
		"\2\26w\3\2\2\2\30\u0088\3\2\2\2\32\u0096\3\2\2\2\34\u00a2\3\2\2\2\36\u00a8"+
		"\3\2\2\2 \u00ad\3\2\2\2\"\u00b1\3\2\2\2$\u00b3\3\2\2\2&\u00b5\3\2\2\2"+
		"(\u00c3\3\2\2\2*\u00cf\3\2\2\2,\u00d5\3\2\2\2.\u00da\3\2\2\2\60\61\7C"+
		"\2\2\61\62\7Q\2\2\62\7\3\2\2\2\63\64\7<\2\2\64\65\7K\2\2\65\66\7p\2\2"+
		"\66\67\7k\2\2\678\7v\2\289\7k\2\29:\7c\2\2:;\7n\2\2;<\7\"\2\2<=\7D\2\2"+
		"=>\7g\2\2>?\7n\2\2?@\7k\2\2@A\7g\2\2AB\7h\2\2BC\7u\2\2CD\7<\2\2DE\3\2"+
		"\2\2EF\b\3\2\2F\t\3\2\2\2GH\7<\2\2HI\7p\2\2IJ\7c\2\2JK\7o\2\2KL\7g\2\2"+
		"LM\7<\2\2M\13\3\2\2\2NP\t\2\2\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2"+
		"\2R\r\3\2\2\2ST\7\61\2\2TU\7,\2\2UY\3\2\2\2VX\13\2\2\2WV\3\2\2\2X[\3\2"+
		"\2\2YZ\3\2\2\2YW\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\]\7,\2\2]^\7\61\2\2^_\3"+
		"\2\2\2_`\b\6\3\2`\17\3\2\2\2ab\7\61\2\2bc\7\61\2\2cg\3\2\2\2df\n\3\2\2"+
		"ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2ig\3\2\2\2jk\b\7\3\2"+
		"k\21\3\2\2\2ln\7\17\2\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\f\2\2pq\3\2"+
		"\2\2qr\b\b\3\2r\23\3\2\2\2st\t\4\2\2tu\3\2\2\2uv\b\t\3\2v\25\3\2\2\2w"+
		"x\7<\2\2xy\7K\2\2yz\7p\2\2z{\7k\2\2{|\7v\2\2|}\7k\2\2}~\7c\2\2~\177\7"+
		"n\2\2\177\u0080\7\"\2\2\u0080\u0081\7I\2\2\u0081\u0082\7q\2\2\u0082\u0083"+
		"\7c\2\2\u0083\u0084\7n\2\2\u0084\u0085\7<\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0087\b\n\4\2\u0087\27\3\2\2\2\u0088\u0089\7\61\2\2\u0089\u008a\7,\2"+
		"\2\u008a\u008e\3\2\2\2\u008b\u008d\13\2\2\2\u008c\u008b\3\2\2\2\u008d"+
		"\u0090\3\2\2\2\u008e\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0091\3\2"+
		"\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7,\2\2\u0092\u0093\7\61\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\b\13\3\2\u0095\31\3\2\2\2\u0096\u0097\7\61"+
		"\2\2\u0097\u0098\7\61\2\2\u0098\u009c\3\2\2\2\u0099\u009b\n\3\2\2\u009a"+
		"\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2"+
		"\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\b\f\3\2\u00a0"+
		"\33\3\2\2\2\u00a1\u00a3\7\17\2\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2"+
		"\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\7\f\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7"+
		"\b\r\3\2\u00a7\35\3\2\2\2\u00a8\u00a9\t\4\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\b\16\3\2\u00ab\37\3\2\2\2\u00ac\u00ae\t\5\2\2\u00ad\u00ac\3\2\2"+
		"\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0!"+
		"\3\2\2\2\u00b1\u00b2\7c\2\2\u00b2#\3\2\2\2\u00b3\u00b4\7d\2\2\u00b4%\3"+
		"\2\2\2\u00b5\u00b6\7\61\2\2\u00b6\u00b7\7,\2\2\u00b7\u00bb\3\2\2\2\u00b8"+
		"\u00ba\13\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00bc\3"+
		"\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00bf\7,\2\2\u00bf\u00c0\7\61\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\b\22"+
		"\3\2\u00c2\'\3\2\2\2\u00c3\u00c4\7\61\2\2\u00c4\u00c5\7\61\2\2\u00c5\u00c9"+
		"\3\2\2\2\u00c6\u00c8\n\3\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2"+
		"\2\2\u00cc\u00cd\b\23\3\2\u00cd)\3\2\2\2\u00ce\u00d0\7\17\2\2\u00cf\u00ce"+
		"\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\7\f\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d4\b\24\3\2\u00d4+\3\2\2\2\u00d5\u00d6\t\4\2\2"+
		"\u00d6\u00d7\3\2\2\2\u00d7\u00d8\b\25\3\2\u00d8-\3\2\2\2\u00d9\u00db\t"+
		"\5\2\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00dd/\3\2\2\2\22\2\3\4\5QYgm\u008e\u009c\u00a2\u00af\u00bb"+
		"\u00c9\u00cf\u00dc\5\4\3\2\b\2\2\4\5\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}