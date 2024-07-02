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
		ALWAYS=1, FINALLY=2, UNTIL=3, RELEASE=4, AND=5, OR=6, NOT=7, IMP=8, BELIEVE=9, 
		GOAL=10, FALSE=11, INTENTION=12, ACTION=13, PERCEPT=14, TRUE=15, INTENDTODO=16, 
		CONST=17, QUOTED_STRING=18, OPEN=19, CLOSE=20, COMMASEP=21, IDPUNCT=22, 
		SQOPEN=23, SQCLOSE=24, COMMENT=25, LINE_COMMENT=26, NEWLINE=27, WS=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ALWAYS", "FINALLY", "UNTIL", "RELEASE", "AND", "OR", "NOT", "IMP", "BELIEVE", 
			"GOAL", "FALSE", "INTENTION", "ACTION", "PERCEPT", "TRUE", "INTENDTODO", 
			"CONST", "QUOTED_STRING", "OPEN", "CLOSE", "COMMASEP", "IDPUNCT", "SQOPEN", 
			"SQCLOSE", "COMMENT", "LINE_COMMENT", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'U'", "'R'", "'&'", "'||'", "'~'", "'->'", "'B'", 
			"'G'", "'F'", "'I'", "'D'", "'P'", "'T'", "'ItD'", null, null, "'('", 
			"')'", "','", "'.'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ALWAYS", "FINALLY", "UNTIL", "RELEASE", "AND", "OR", "NOT", "IMP", 
			"BELIEVE", "GOAL", "FALSE", "INTENTION", "ACTION", "PERCEPT", "TRUE", 
			"INTENDTODO", "CONST", "QUOTED_STRING", "OPEN", "CLOSE", "COMMASEP", 
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
		"\u0004\u0000\u001c\u00aa\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000"+
		"=\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001B\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0004\u0010"+
		"e\b\u0010\u000b\u0010\f\u0010f\u0001\u0011\u0001\u0011\u0005\u0011k\b"+
		"\u0011\n\u0011\f\u0011n\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005"+
		"\u0011s\b\u0011\n\u0011\f\u0011v\t\u0011\u0001\u0011\u0003\u0011y\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u008b\b\u0018"+
		"\n\u0018\f\u0018\u008e\t\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005"+
		"\u0019\u0099\b\u0019\n\u0019\f\u0019\u009c\t\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0003\u001a\u00a1\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003lt\u008c"+
		"\u0000\u001c\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016"+
		"-\u0017/\u00181\u00193\u001a5\u001b7\u001c\u0001\u0000\u0003\u0005\u0000"+
		"09<<AZ__az\u0001\u0000\n\n\u0002\u0000\t\t  \u00b2\u0000\u0001\u0001\u0000"+
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
		"\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u0001<\u0001\u0000\u0000"+
		"\u0000\u0003A\u0001\u0000\u0000\u0000\u0005C\u0001\u0000\u0000\u0000\u0007"+
		"E\u0001\u0000\u0000\u0000\tG\u0001\u0000\u0000\u0000\u000bI\u0001\u0000"+
		"\u0000\u0000\rL\u0001\u0000\u0000\u0000\u000fN\u0001\u0000\u0000\u0000"+
		"\u0011Q\u0001\u0000\u0000\u0000\u0013S\u0001\u0000\u0000\u0000\u0015U"+
		"\u0001\u0000\u0000\u0000\u0017W\u0001\u0000\u0000\u0000\u0019Y\u0001\u0000"+
		"\u0000\u0000\u001b[\u0001\u0000\u0000\u0000\u001d]\u0001\u0000\u0000\u0000"+
		"\u001f_\u0001\u0000\u0000\u0000!d\u0001\u0000\u0000\u0000#x\u0001\u0000"+
		"\u0000\u0000%z\u0001\u0000\u0000\u0000\'|\u0001\u0000\u0000\u0000)~\u0001"+
		"\u0000\u0000\u0000+\u0080\u0001\u0000\u0000\u0000-\u0082\u0001\u0000\u0000"+
		"\u0000/\u0084\u0001\u0000\u0000\u00001\u0086\u0001\u0000\u0000\u00003"+
		"\u0094\u0001\u0000\u0000\u00005\u00a0\u0001\u0000\u0000\u00007\u00a6\u0001"+
		"\u0000\u0000\u00009=\u0005A\u0000\u0000:;\u0005[\u0000\u0000;=\u0005]"+
		"\u0000\u0000<9\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=\u0002"+
		"\u0001\u0000\u0000\u0000>B\u0005E\u0000\u0000?@\u0005<\u0000\u0000@B\u0005"+
		">\u0000\u0000A>\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000B\u0004"+
		"\u0001\u0000\u0000\u0000CD\u0005U\u0000\u0000D\u0006\u0001\u0000\u0000"+
		"\u0000EF\u0005R\u0000\u0000F\b\u0001\u0000\u0000\u0000GH\u0005&\u0000"+
		"\u0000H\n\u0001\u0000\u0000\u0000IJ\u0005|\u0000\u0000JK\u0005|\u0000"+
		"\u0000K\f\u0001\u0000\u0000\u0000LM\u0005~\u0000\u0000M\u000e\u0001\u0000"+
		"\u0000\u0000NO\u0005-\u0000\u0000OP\u0005>\u0000\u0000P\u0010\u0001\u0000"+
		"\u0000\u0000QR\u0005B\u0000\u0000R\u0012\u0001\u0000\u0000\u0000ST\u0005"+
		"G\u0000\u0000T\u0014\u0001\u0000\u0000\u0000UV\u0005F\u0000\u0000V\u0016"+
		"\u0001\u0000\u0000\u0000WX\u0005I\u0000\u0000X\u0018\u0001\u0000\u0000"+
		"\u0000YZ\u0005D\u0000\u0000Z\u001a\u0001\u0000\u0000\u0000[\\\u0005P\u0000"+
		"\u0000\\\u001c\u0001\u0000\u0000\u0000]^\u0005T\u0000\u0000^\u001e\u0001"+
		"\u0000\u0000\u0000_`\u0005I\u0000\u0000`a\u0005t\u0000\u0000ab\u0005D"+
		"\u0000\u0000b \u0001\u0000\u0000\u0000ce\u0007\u0000\u0000\u0000dc\u0001"+
		"\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"fg\u0001\u0000\u0000\u0000g\"\u0001\u0000\u0000\u0000hl\u0005\"\u0000"+
		"\u0000ik\t\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000"+
		"\u0000lm\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mo\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000oy\u0005\"\u0000\u0000pt\u0005\'"+
		"\u0000\u0000qs\t\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000sv\u0001\u0000"+
		"\u0000\u0000tu\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000uw\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wy\u0005\'\u0000\u0000xh\u0001"+
		"\u0000\u0000\u0000xp\u0001\u0000\u0000\u0000y$\u0001\u0000\u0000\u0000"+
		"z{\u0005(\u0000\u0000{&\u0001\u0000\u0000\u0000|}\u0005)\u0000\u0000}"+
		"(\u0001\u0000\u0000\u0000~\u007f\u0005,\u0000\u0000\u007f*\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0005.\u0000\u0000\u0081,\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0005[\u0000\u0000\u0083.\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0005]\u0000\u0000\u00850\u0001\u0000\u0000\u0000\u0086\u0087\u0005/"+
		"\u0000\u0000\u0087\u0088\u0005*\u0000\u0000\u0088\u008c\u0001\u0000\u0000"+
		"\u0000\u0089\u008b\t\u0000\u0000\u0000\u008a\u0089\u0001\u0000\u0000\u0000"+
		"\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000"+
		"\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u008f\u0001\u0000\u0000\u0000"+
		"\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0090\u0005*\u0000\u0000\u0090"+
		"\u0091\u0005/\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0006\u0018\u0000\u0000\u00932\u0001\u0000\u0000\u0000\u0094\u0095\u0005"+
		"/\u0000\u0000\u0095\u0096\u0005/\u0000\u0000\u0096\u009a\u0001\u0000\u0000"+
		"\u0000\u0097\u0099\b\u0001\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000"+
		"\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009d\u0001\u0000\u0000\u0000"+
		"\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u009e\u0006\u0019\u0000\u0000"+
		"\u009e4\u0001\u0000\u0000\u0000\u009f\u00a1\u0005\r\u0000\u0000\u00a0"+
		"\u009f\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\n\u0000\u0000\u00a3\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a5\u0006\u001a\u0000\u0000\u00a56\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a7\u0007\u0002\u0000\u0000\u00a7\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0006\u001b\u0000\u0000\u00a98\u0001\u0000"+
		"\u0000\u0000\n\u0000<Afltx\u008c\u009a\u00a0\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}