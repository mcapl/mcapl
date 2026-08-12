// Generated from /Users/louisedennis/IdeaProjects/mcapl/src/main/ajpf/psl/parser/antlr/A_PSLLexer.g4 by ANTLR 4.13.1
package ajpf.psl.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class A_PSLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALWAYS=1, FINALLY=2, UNTIL=3, RELEASE=4, NEXT=5, AND=6, OR=7, NOT=8, IMP=9, 
		BELIEVE=10, GOAL=11, FALSE=12, INTENTION=13, ACTION=14, PERCEPT=15, TRUE=16, 
		INTENDTODO=17, CONST=18, QUOTED_STRING=19, OPEN=20, CLOSE=21, COMMASEP=22, 
		IDPUNCT=23, SQOPEN=24, SQCLOSE=25, COMMENT=26, LINE_COMMENT=27, NEWLINE=28, 
		WS=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ALWAYS", "FINALLY", "UNTIL", "RELEASE", "NEXT", "AND", "OR", "NOT", 
			"IMP", "BELIEVE", "GOAL", "FALSE", "INTENTION", "ACTION", "PERCEPT", 
			"TRUE", "INTENDTODO", "CONST", "QUOTED_STRING", "OPEN", "CLOSE", "COMMASEP", 
			"IDPUNCT", "SQOPEN", "SQCLOSE", "COMMENT", "LINE_COMMENT", "NEWLINE", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'U'", "'R'", "'X'", "'&'", "'||'", "'~'", "'->'", 
			"'B'", "'G'", "'F'", "'I'", "'D'", "'P'", "'T'", "'ItD'", null, null, 
			"'('", "')'", "','", "'.'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ALWAYS", "FINALLY", "UNTIL", "RELEASE", "NEXT", "AND", "OR", "NOT", 
			"IMP", "BELIEVE", "GOAL", "FALSE", "INTENTION", "ACTION", "PERCEPT", 
			"TRUE", "INTENDTODO", "CONST", "QUOTED_STRING", "OPEN", "CLOSE", "COMMASEP", 
			"IDPUNCT", "SQOPEN", "SQCLOSE", "COMMENT", "LINE_COMMENT", "NEWLINE", 
			"WS"
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


	public A_PSLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "A_PSLLexer.g4"; }

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
		"\u0004\u0000\u001d\u00ae\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0003\u0000?\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001D\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0004\u0011i\b\u0011\u000b\u0011"+
		"\f\u0011j\u0001\u0012\u0001\u0012\u0005\u0012o\b\u0012\n\u0012\f\u0012"+
		"r\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012w\b\u0012\n\u0012"+
		"\f\u0012z\t\u0012\u0001\u0012\u0003\u0012}\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0005\u0019\u008f\b\u0019\n\u0019\f\u0019\u0092"+
		"\t\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u009d\b\u001a\n"+
		"\u001a\f\u001a\u00a0\t\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0003"+
		"\u001b\u00a5\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003px\u0090\u0000\u001d\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b7\u001c9\u001d\u0001\u0000\u0003\u0005\u0000"+
		"09<<AZ__az\u0001\u0000\n\n\u0002\u0000\t\t  \u00b6\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001"+
		"\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000"+
		"\u0000\u0001>\u0001\u0000\u0000\u0000\u0003C\u0001\u0000\u0000\u0000\u0005"+
		"E\u0001\u0000\u0000\u0000\u0007G\u0001\u0000\u0000\u0000\tI\u0001\u0000"+
		"\u0000\u0000\u000bK\u0001\u0000\u0000\u0000\rM\u0001\u0000\u0000\u0000"+
		"\u000fP\u0001\u0000\u0000\u0000\u0011R\u0001\u0000\u0000\u0000\u0013U"+
		"\u0001\u0000\u0000\u0000\u0015W\u0001\u0000\u0000\u0000\u0017Y\u0001\u0000"+
		"\u0000\u0000\u0019[\u0001\u0000\u0000\u0000\u001b]\u0001\u0000\u0000\u0000"+
		"\u001d_\u0001\u0000\u0000\u0000\u001fa\u0001\u0000\u0000\u0000!c\u0001"+
		"\u0000\u0000\u0000#h\u0001\u0000\u0000\u0000%|\u0001\u0000\u0000\u0000"+
		"\'~\u0001\u0000\u0000\u0000)\u0080\u0001\u0000\u0000\u0000+\u0082\u0001"+
		"\u0000\u0000\u0000-\u0084\u0001\u0000\u0000\u0000/\u0086\u0001\u0000\u0000"+
		"\u00001\u0088\u0001\u0000\u0000\u00003\u008a\u0001\u0000\u0000\u00005"+
		"\u0098\u0001\u0000\u0000\u00007\u00a4\u0001\u0000\u0000\u00009\u00aa\u0001"+
		"\u0000\u0000\u0000;?\u0005A\u0000\u0000<=\u0005[\u0000\u0000=?\u0005]"+
		"\u0000\u0000>;\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000?\u0002"+
		"\u0001\u0000\u0000\u0000@D\u0005E\u0000\u0000AB\u0005<\u0000\u0000BD\u0005"+
		">\u0000\u0000C@\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000D\u0004"+
		"\u0001\u0000\u0000\u0000EF\u0005U\u0000\u0000F\u0006\u0001\u0000\u0000"+
		"\u0000GH\u0005R\u0000\u0000H\b\u0001\u0000\u0000\u0000IJ\u0005X\u0000"+
		"\u0000J\n\u0001\u0000\u0000\u0000KL\u0005&\u0000\u0000L\f\u0001\u0000"+
		"\u0000\u0000MN\u0005|\u0000\u0000NO\u0005|\u0000\u0000O\u000e\u0001\u0000"+
		"\u0000\u0000PQ\u0005~\u0000\u0000Q\u0010\u0001\u0000\u0000\u0000RS\u0005"+
		"-\u0000\u0000ST\u0005>\u0000\u0000T\u0012\u0001\u0000\u0000\u0000UV\u0005"+
		"B\u0000\u0000V\u0014\u0001\u0000\u0000\u0000WX\u0005G\u0000\u0000X\u0016"+
		"\u0001\u0000\u0000\u0000YZ\u0005F\u0000\u0000Z\u0018\u0001\u0000\u0000"+
		"\u0000[\\\u0005I\u0000\u0000\\\u001a\u0001\u0000\u0000\u0000]^\u0005D"+
		"\u0000\u0000^\u001c\u0001\u0000\u0000\u0000_`\u0005P\u0000\u0000`\u001e"+
		"\u0001\u0000\u0000\u0000ab\u0005T\u0000\u0000b \u0001\u0000\u0000\u0000"+
		"cd\u0005I\u0000\u0000de\u0005t\u0000\u0000ef\u0005D\u0000\u0000f\"\u0001"+
		"\u0000\u0000\u0000gi\u0007\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000k$\u0001\u0000\u0000\u0000lp\u0005\"\u0000\u0000mo\t\u0000\u0000"+
		"\u0000nm\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pq\u0001\u0000"+
		"\u0000\u0000pn\u0001\u0000\u0000\u0000qs\u0001\u0000\u0000\u0000rp\u0001"+
		"\u0000\u0000\u0000s}\u0005\"\u0000\u0000tx\u0005\'\u0000\u0000uw\t\u0000"+
		"\u0000\u0000vu\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000y{\u0001\u0000\u0000\u0000"+
		"zx\u0001\u0000\u0000\u0000{}\u0005\'\u0000\u0000|l\u0001\u0000\u0000\u0000"+
		"|t\u0001\u0000\u0000\u0000}&\u0001\u0000\u0000\u0000~\u007f\u0005(\u0000"+
		"\u0000\u007f(\u0001\u0000\u0000\u0000\u0080\u0081\u0005)\u0000\u0000\u0081"+
		"*\u0001\u0000\u0000\u0000\u0082\u0083\u0005,\u0000\u0000\u0083,\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005.\u0000\u0000\u0085.\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0005[\u0000\u0000\u00870\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0005]\u0000\u0000\u00892\u0001\u0000\u0000\u0000\u008a\u008b\u0005"+
		"/\u0000\u0000\u008b\u008c\u0005*\u0000\u0000\u008c\u0090\u0001\u0000\u0000"+
		"\u0000\u008d\u008f\t\u0000\u0000\u0000\u008e\u008d\u0001\u0000\u0000\u0000"+
		"\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000"+
		"\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0093\u0001\u0000\u0000\u0000"+
		"\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0094\u0005*\u0000\u0000\u0094"+
		"\u0095\u0005/\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0006\u0019\u0000\u0000\u00974\u0001\u0000\u0000\u0000\u0098\u0099\u0005"+
		"/\u0000\u0000\u0099\u009a\u0005/\u0000\u0000\u009a\u009e\u0001\u0000\u0000"+
		"\u0000\u009b\u009d\b\u0001\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000"+
		"\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a2\u0006\u001a\u0000\u0000"+
		"\u00a26\u0001\u0000\u0000\u0000\u00a3\u00a5\u0005\r\u0000\u0000\u00a4"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\n\u0000\u0000\u00a7\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0006\u001b\u0000\u0000\u00a98\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0007\u0002\u0000\u0000\u00ab\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0006\u001c\u0000\u0000\u00ad:\u0001\u0000"+
		"\u0000\u0000\n\u0000>Cjpx|\u0090\u009e\u00a4\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}