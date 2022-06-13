// Generated from GwendolenLexer.g4 by ANTLR 4.7
package gwendolen.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GwendolenLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GWENDOLEN=1, BELIEFS=2, NAME=3, COMMENT=4, LINE_COMMENT=5, NEWLINE=6, 
		WS=7, BELIEFRULES=8, GOAL_IB=9, IB_COMMENT=10, IB_LINE_COMMENT=11, IB_NEWLINE=12, 
		IB_WS=13, BELIEF_BLOCK=14, GOAL_RR=15, RR_COMMENT=16, RR_LINE_COMMENT=17, 
		RR_NEWLINE=18, RR_WS=19, RR_BLOCK=20, PLANS=21, GL_COMMENT=22, GL_LINE_COMMENT=23, 
		GL_NEWLINE=24, GL_WS=25, GOAL_BLOCK=26, ACHIEVEGOAL=27, PERFORMGOAL=28, 
		SQOPEN=29, SQCLOSE=30, SEND=31, RECEIVED=32, BELIEVE=33, GOAL=34, IN_CONTENT=35, 
		IN_CONTEXT=36, SENT=37, LOCK=38, ADD_PLAN=39, ADD_CONSTRAINT=40, ADD_CONTENT=41, 
		ADD_CONTEXT=42, ACHIEVEGOAL_PL=43, PERFORMGOAL_PL=44, SQOPEN_PL=45, SQCLOSE_PL=46, 
		TELL=47, PERFORM=48, ACHIEVE=49, TELLHOW=50, CONSTRAINT=51, RULEARROW=52, 
		TRUE=53;
	public static final int
		INITIAL_BELIEFS=1, REASONING_RULES=2, GOALS=3, PLANS_MODE=4;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "INITIAL_BELIEFS", "REASONING_RULES", "GOALS", "PLANS_MODE"
	};

	public static final String[] ruleNames = {
		"GWENDOLEN", "BELIEFS", "NAME", "COMMENT", "LINE_COMMENT", "NEWLINE", 
		"WS", "BELIEFRULES", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", "IB_NEWLINE", 
		"IB_WS", "BELIEF_BLOCK", "GOAL_RR", "RR_COMMENT", "RR_LINE_COMMENT", "RR_NEWLINE", 
		"RR_WS", "RR_BLOCK", "PLANS", "GL_COMMENT", "GL_LINE_COMMENT", "GL_NEWLINE", 
		"GL_WS", "GOAL_BLOCK", "ACHIEVEGOAL", "PERFORMGOAL", "SQOPEN", "SQCLOSE", 
		"SEND", "RECEIVED", "BELIEVE", "GOAL", "IN_CONTENT", "IN_CONTEXT", "SENT", 
		"LOCK", "ADD_PLAN", "ADD_CONSTRAINT", "ADD_CONTENT", "ADD_CONTEXT", "ACHIEVEGOAL_PL", 
		"PERFORMGOAL_PL", "SQOPEN_PL", "SQCLOSE_PL", "TELL", "PERFORM", "ACHIEVE", 
		"TELLHOW", "CONSTRAINT", "RULEARROW", "TRUE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'GWENDOLEN'", "':Initial Beliefs:'", "':name:'", null, null, null, 
		null, "':Reasoning Rules:'", null, null, null, null, null, null, null, 
		null, null, null, null, null, "':Plans:'", null, null, null, null, null, 
		null, null, null, null, "'.send'", "'.received'", null, null, null, null, 
		"'.sent'", "'.lock'", "'.plan'", "'.constraint'", "'.n'", "'.x'", null, 
		null, null, null, "':tell'", "':perform'", "':achieve'", "':how'", "':constrain'", 
		"'<-'", "'True'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "GWENDOLEN", "BELIEFS", "NAME", "COMMENT", "LINE_COMMENT", "NEWLINE", 
		"WS", "BELIEFRULES", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", "IB_NEWLINE", 
		"IB_WS", "BELIEF_BLOCK", "GOAL_RR", "RR_COMMENT", "RR_LINE_COMMENT", "RR_NEWLINE", 
		"RR_WS", "RR_BLOCK", "PLANS", "GL_COMMENT", "GL_LINE_COMMENT", "GL_NEWLINE", 
		"GL_WS", "GOAL_BLOCK", "ACHIEVEGOAL", "PERFORMGOAL", "SQOPEN", "SQCLOSE", 
		"SEND", "RECEIVED", "BELIEVE", "GOAL", "IN_CONTENT", "IN_CONTEXT", "SENT", 
		"LOCK", "ADD_PLAN", "ADD_CONSTRAINT", "ADD_CONTENT", "ADD_CONTEXT", "ACHIEVEGOAL_PL", 
		"PERFORMGOAL_PL", "SQOPEN_PL", "SQCLOSE_PL", "TELL", "PERFORM", "ACHIEVE", 
		"TELLHOW", "CONSTRAINT", "RULEARROW", "TRUE"
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


	public GwendolenLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GwendolenLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u020e\b\1\b\1"+
		"\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5\u009b"+
		"\n\5\f\5\16\5\u009e\13\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\u00a9"+
		"\n\6\f\6\16\6\u00ac\13\6\3\6\3\6\3\7\5\7\u00b1\n\7\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13\u00e5\n\13\f\13\16\13"+
		"\u00e8\13\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u00f3\n\f\f"+
		"\f\16\f\u00f6\13\f\3\f\3\f\3\r\5\r\u00fb\n\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\17\6\17\u0104\n\17\r\17\16\17\u0105\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\7\21\u011e\n\21\f\21\16\21\u0121\13\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\7\22\u012c\n\22\f\22\16\22\u012f\13\22\3\22"+
		"\3\22\3\23\5\23\u0134\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\6\25\u0140\n\25\r\25\16\25\u0141\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u0152\n\27\f\27\16\27\u0155"+
		"\13\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u0160\n\30\f"+
		"\30\16\30\u0163\13\30\3\30\3\30\3\31\5\31\u0168\n\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\3\33\6\33\u0171\n\33\r\33\16\33\u0172\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\""+
		"\5\"\u019c\n\"\3#\3#\3#\5#\u01a1\n#\3$\3$\3%\3%\3&\3&\3&\3&\3&\3&\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3"+
		"-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3"+
		"\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\6\u009c\u00e6\u011f\u0153"+
		"\2\67\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17"+
		"!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36"+
		"?\37A C!E\"G#I$K%M&O\'Q(S)U*W+Y,[-]._/a\60c\61e\62g\63i\64k\65m\66o\67"+
		"\7\2\3\4\5\6\7\3\2\f\f\4\2\13\13\"\"\n\2\"\"*+..\60\60\62;C\\aac|\b\2"+
		"*+..\62;C\\aac|\6\2\62;C\\aac|\2\u021c\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2"+
		"\3\27\3\2\2\2\3\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2\2\2\3\37\3\2\2\2\3!\3"+
		"\2\2\2\4#\3\2\2\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3\2\2\2\4+\3\2\2\2\4-\3\2"+
		"\2\2\5/\3\2\2\2\5\61\3\2\2\2\5\63\3\2\2\2\5\65\3\2\2\2\5\67\3\2\2\2\5"+
		"9\3\2\2\2\5;\3\2\2\2\5=\3\2\2\2\5?\3\2\2\2\5A\3\2\2\2\6C\3\2\2\2\6E\3"+
		"\2\2\2\6G\3\2\2\2\6I\3\2\2\2\6K\3\2\2\2\6M\3\2\2\2\6O\3\2\2\2\6Q\3\2\2"+
		"\2\6S\3\2\2\2\6U\3\2\2\2\6W\3\2\2\2\6Y\3\2\2\2\6[\3\2\2\2\6]\3\2\2\2\6"+
		"_\3\2\2\2\6a\3\2\2\2\6c\3\2\2\2\6e\3\2\2\2\6g\3\2\2\2\6i\3\2\2\2\6k\3"+
		"\2\2\2\6m\3\2\2\2\6o\3\2\2\2\7q\3\2\2\2\t{\3\2\2\2\13\u008f\3\2\2\2\r"+
		"\u0096\3\2\2\2\17\u00a4\3\2\2\2\21\u00b0\3\2\2\2\23\u00b6\3\2\2\2\25\u00ba"+
		"\3\2\2\2\27\u00ce\3\2\2\2\31\u00e0\3\2\2\2\33\u00ee\3\2\2\2\35\u00fa\3"+
		"\2\2\2\37\u00fe\3\2\2\2!\u0103\3\2\2\2#\u0107\3\2\2\2%\u0119\3\2\2\2\'"+
		"\u0127\3\2\2\2)\u0133\3\2\2\2+\u0137\3\2\2\2-\u013f\3\2\2\2/\u0143\3\2"+
		"\2\2\61\u014d\3\2\2\2\63\u015b\3\2\2\2\65\u0167\3\2\2\2\67\u016b\3\2\2"+
		"\29\u0170\3\2\2\2;\u0174\3\2\2\2=\u017c\3\2\2\2?\u0184\3\2\2\2A\u0186"+
		"\3\2\2\2C\u0188\3\2\2\2E\u018e\3\2\2\2G\u019b\3\2\2\2I\u01a0\3\2\2\2K"+
		"\u01a2\3\2\2\2M\u01a4\3\2\2\2O\u01a6\3\2\2\2Q\u01ac\3\2\2\2S\u01b2\3\2"+
		"\2\2U\u01b8\3\2\2\2W\u01c4\3\2\2\2Y\u01c7\3\2\2\2[\u01ca\3\2\2\2]\u01d2"+
		"\3\2\2\2_\u01da\3\2\2\2a\u01dc\3\2\2\2c\u01de\3\2\2\2e\u01e4\3\2\2\2g"+
		"\u01ed\3\2\2\2i\u01f6\3\2\2\2k\u01fb\3\2\2\2m\u0206\3\2\2\2o\u0209\3\2"+
		"\2\2qr\7I\2\2rs\7Y\2\2st\7G\2\2tu\7P\2\2uv\7F\2\2vw\7Q\2\2wx\7N\2\2xy"+
		"\7G\2\2yz\7P\2\2z\b\3\2\2\2{|\7<\2\2|}\7K\2\2}~\7p\2\2~\177\7k\2\2\177"+
		"\u0080\7v\2\2\u0080\u0081\7k\2\2\u0081\u0082\7c\2\2\u0082\u0083\7n\2\2"+
		"\u0083\u0084\7\"\2\2\u0084\u0085\7D\2\2\u0085\u0086\7g\2\2\u0086\u0087"+
		"\7n\2\2\u0087\u0088\7k\2\2\u0088\u0089\7g\2\2\u0089\u008a\7h\2\2\u008a"+
		"\u008b\7u\2\2\u008b\u008c\7<\2\2\u008c\u008d\3\2\2\2\u008d\u008e\b\3\2"+
		"\2\u008e\n\3\2\2\2\u008f\u0090\7<\2\2\u0090\u0091\7p\2\2\u0091\u0092\7"+
		"c\2\2\u0092\u0093\7o\2\2\u0093\u0094\7g\2\2\u0094\u0095\7<\2\2\u0095\f"+
		"\3\2\2\2\u0096\u0097\7\61\2\2\u0097\u0098\7,\2\2\u0098\u009c\3\2\2\2\u0099"+
		"\u009b\13\2\2\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009d\3"+
		"\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a0\7,\2\2\u00a0\u00a1\7\61\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\b\5"+
		"\3\2\u00a3\16\3\2\2\2\u00a4\u00a5\7\61\2\2\u00a5\u00a6\7\61\2\2\u00a6"+
		"\u00aa\3\2\2\2\u00a7\u00a9\n\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2"+
		"\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ad\u00ae\b\6\3\2\u00ae\20\3\2\2\2\u00af\u00b1\7\17\2"+
		"\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3"+
		"\7\f\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\b\7\3\2\u00b5\22\3\2\2\2\u00b6"+
		"\u00b7\t\3\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\b\b\3\2\u00b9\24\3\2\2"+
		"\2\u00ba\u00bb\7<\2\2\u00bb\u00bc\7T\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be"+
		"\7c\2\2\u00be\u00bf\7u\2\2\u00bf\u00c0\7q\2\2\u00c0\u00c1\7p\2\2\u00c1"+
		"\u00c2\7k\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7i\2\2\u00c4\u00c5\7\"\2"+
		"\2\u00c5\u00c6\7T\2\2\u00c6\u00c7\7w\2\2\u00c7\u00c8\7n\2\2\u00c8\u00c9"+
		"\7g\2\2\u00c9\u00ca\7u\2\2\u00ca\u00cb\7<\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\b\t\4\2\u00cd\26\3\2\2\2\u00ce\u00cf\7<\2\2\u00cf\u00d0\7K\2\2"+
		"\u00d0\u00d1\7p\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d4"+
		"\7k\2\2\u00d4\u00d5\7c\2\2\u00d5\u00d6\7n\2\2\u00d6\u00d7\7\"\2\2\u00d7"+
		"\u00d8\7I\2\2\u00d8\u00d9\7q\2\2\u00d9\u00da\7c\2\2\u00da\u00db\7n\2\2"+
		"\u00db\u00dc\7u\2\2\u00dc\u00dd\7<\2\2\u00dd\u00de\3\2\2\2\u00de\u00df"+
		"\b\n\5\2\u00df\30\3\2\2\2\u00e0\u00e1\7\61\2\2\u00e1\u00e2\7,\2\2\u00e2"+
		"\u00e6\3\2\2\2\u00e3\u00e5\13\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3"+
		"\2\2\2\u00e6\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e9\u00ea\7,\2\2\u00ea\u00eb\7\61\2\2\u00eb\u00ec\3\2"+
		"\2\2\u00ec\u00ed\b\13\3\2\u00ed\32\3\2\2\2\u00ee\u00ef\7\61\2\2\u00ef"+
		"\u00f0\7\61\2\2\u00f0\u00f4\3\2\2\2\u00f1\u00f3\n\2\2\2\u00f2\u00f1\3"+
		"\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f7\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\b\f\3\2\u00f8\34\3\2\2"+
		"\2\u00f9\u00fb\7\17\2\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fd\7\f\2\2\u00fd\36\3\2\2\2\u00fe\u00ff\t\3\2"+
		"\2\u00ff\u0100\3\2\2\2\u0100\u0101\b\16\3\2\u0101 \3\2\2\2\u0102\u0104"+
		"\t\4\2\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\"\3\2\2\2\u0107\u0108\7<\2\2\u0108\u0109\7K\2\2\u0109"+
		"\u010a\7p\2\2\u010a\u010b\7k\2\2\u010b\u010c\7v\2\2\u010c\u010d\7k\2\2"+
		"\u010d\u010e\7c\2\2\u010e\u010f\7n\2\2\u010f\u0110\7\"\2\2\u0110\u0111"+
		"\7I\2\2\u0111\u0112\7q\2\2\u0112\u0113\7c\2\2\u0113\u0114\7n\2\2\u0114"+
		"\u0115\7u\2\2\u0115\u0116\7<\2\2\u0116\u0117\3\2\2\2\u0117\u0118\b\20"+
		"\5\2\u0118$\3\2\2\2\u0119\u011a\7\61\2\2\u011a\u011b\7,\2\2\u011b\u011f"+
		"\3\2\2\2\u011c\u011e\13\2\2\2\u011d\u011c\3\2\2\2\u011e\u0121\3\2\2\2"+
		"\u011f\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u011f"+
		"\3\2\2\2\u0122\u0123\7,\2\2\u0123\u0124\7\61\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u0126\b\21\3\2\u0126&\3\2\2\2\u0127\u0128\7\61\2\2\u0128\u0129\7\61\2"+
		"\2\u0129\u012d\3\2\2\2\u012a\u012c\n\2\2\2\u012b\u012a\3\2\2\2\u012c\u012f"+
		"\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0130\3\2\2\2\u012f"+
		"\u012d\3\2\2\2\u0130\u0131\b\22\3\2\u0131(\3\2\2\2\u0132\u0134\7\17\2"+
		"\2\u0133\u0132\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136"+
		"\7\f\2\2\u0136*\3\2\2\2\u0137\u0138\t\3\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013a\b\24\3\2\u013a,\3\2\2\2\u013b\u0140\t\5\2\2\u013c\u013d\7<\2\2"+
		"\u013d\u0140\7/\2\2\u013e\u0140\7\"\2\2\u013f\u013b\3\2\2\2\u013f\u013c"+
		"\3\2\2\2\u013f\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u013f\3\2\2\2\u0141"+
		"\u0142\3\2\2\2\u0142.\3\2\2\2\u0143\u0144\7<\2\2\u0144\u0145\7R\2\2\u0145"+
		"\u0146\7n\2\2\u0146\u0147\7c\2\2\u0147\u0148\7p\2\2\u0148\u0149\7u\2\2"+
		"\u0149\u014a\7<\2\2\u014a\u014b\3\2\2\2\u014b\u014c\b\26\6\2\u014c\60"+
		"\3\2\2\2\u014d\u014e\7\61\2\2\u014e\u014f\7,\2\2\u014f\u0153\3\2\2\2\u0150"+
		"\u0152\13\2\2\2\u0151\u0150\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0154\3"+
		"\2\2\2\u0153\u0151\3\2\2\2\u0154\u0156\3\2\2\2\u0155\u0153\3\2\2\2\u0156"+
		"\u0157\7,\2\2\u0157\u0158\7\61\2\2\u0158\u0159\3\2\2\2\u0159\u015a\b\27"+
		"\3\2\u015a\62\3\2\2\2\u015b\u015c\7\61\2\2\u015c\u015d\7\61\2\2\u015d"+
		"\u0161\3\2\2\2\u015e\u0160\n\2\2\2\u015f\u015e\3\2\2\2\u0160\u0163\3\2"+
		"\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0164\3\2\2\2\u0163"+
		"\u0161\3\2\2\2\u0164\u0165\b\30\3\2\u0165\64\3\2\2\2\u0166\u0168\7\17"+
		"\2\2\u0167\u0166\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169\3\2\2\2\u0169"+
		"\u016a\7\f\2\2\u016a\66\3\2\2\2\u016b\u016c\t\3\2\2\u016c\u016d\3\2\2"+
		"\2\u016d\u016e\b\32\3\2\u016e8\3\2\2\2\u016f\u0171\t\6\2\2\u0170\u016f"+
		"\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173"+
		":\3\2\2\2\u0174\u0175\7c\2\2\u0175\u0176\7e\2\2\u0176\u0177\7j\2\2\u0177"+
		"\u0178\7k\2\2\u0178\u0179\7g\2\2\u0179\u017a\7x\2\2\u017a\u017b\7g\2\2"+
		"\u017b<\3\2\2\2\u017c\u017d\7r\2\2\u017d\u017e\7g\2\2\u017e\u017f\7t\2"+
		"\2\u017f\u0180\7h\2\2\u0180\u0181\7q\2\2\u0181\u0182\7t\2\2\u0182\u0183"+
		"\7o\2\2\u0183>\3\2\2\2\u0184\u0185\7]\2\2\u0185@\3\2\2\2\u0186\u0187\7"+
		"_\2\2\u0187B\3\2\2\2\u0188\u0189\7\60\2\2\u0189\u018a\7u\2\2\u018a\u018b"+
		"\7g\2\2\u018b\u018c\7p\2\2\u018c\u018d\7f\2\2\u018dD\3\2\2\2\u018e\u018f"+
		"\7\60\2\2\u018f\u0190\7t\2\2\u0190\u0191\7g\2\2\u0191\u0192\7e\2\2\u0192"+
		"\u0193\7g\2\2\u0193\u0194\7k\2\2\u0194\u0195\7x\2\2\u0195\u0196\7g\2\2"+
		"\u0196\u0197\7f\2\2\u0197F\3\2\2\2\u0198\u019c\7D\2\2\u0199\u019a\7\60"+
		"\2\2\u019a\u019c\7D\2\2\u019b\u0198\3\2\2\2\u019b\u0199\3\2\2\2\u019c"+
		"H\3\2\2\2\u019d\u01a1\7I\2\2\u019e\u019f\7\60\2\2\u019f\u01a1\7I\2\2\u01a0"+
		"\u019d\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1J\3\2\2\2\u01a2\u01a3\7P\2\2\u01a3"+
		"L\3\2\2\2\u01a4\u01a5\7Z\2\2\u01a5N\3\2\2\2\u01a6\u01a7\7\60\2\2\u01a7"+
		"\u01a8\7u\2\2\u01a8\u01a9\7g\2\2\u01a9\u01aa\7p\2\2\u01aa\u01ab\7v\2\2"+
		"\u01abP\3\2\2\2\u01ac\u01ad\7\60\2\2\u01ad\u01ae\7n\2\2\u01ae\u01af\7"+
		"q\2\2\u01af\u01b0\7e\2\2\u01b0\u01b1\7m\2\2\u01b1R\3\2\2\2\u01b2\u01b3"+
		"\7\60\2\2\u01b3\u01b4\7r\2\2\u01b4\u01b5\7n\2\2\u01b5\u01b6\7c\2\2\u01b6"+
		"\u01b7\7p\2\2\u01b7T\3\2\2\2\u01b8\u01b9\7\60\2\2\u01b9\u01ba\7e\2\2\u01ba"+
		"\u01bb\7q\2\2\u01bb\u01bc\7p\2\2\u01bc\u01bd\7u\2\2\u01bd\u01be\7v\2\2"+
		"\u01be\u01bf\7t\2\2\u01bf\u01c0\7c\2\2\u01c0\u01c1\7k\2\2\u01c1\u01c2"+
		"\7p\2\2\u01c2\u01c3\7v\2\2\u01c3V\3\2\2\2\u01c4\u01c5\7\60\2\2\u01c5\u01c6"+
		"\7p\2\2\u01c6X\3\2\2\2\u01c7\u01c8\7\60\2\2\u01c8\u01c9\7z\2\2\u01c9Z"+
		"\3\2\2\2\u01ca\u01cb\7c\2\2\u01cb\u01cc\7e\2\2\u01cc\u01cd\7j\2\2\u01cd"+
		"\u01ce\7k\2\2\u01ce\u01cf\7g\2\2\u01cf\u01d0\7x\2\2\u01d0\u01d1\7g\2\2"+
		"\u01d1\\\3\2\2\2\u01d2\u01d3\7r\2\2\u01d3\u01d4\7g\2\2\u01d4\u01d5\7t"+
		"\2\2\u01d5\u01d6\7h\2\2\u01d6\u01d7\7q\2\2\u01d7\u01d8\7t\2\2\u01d8\u01d9"+
		"\7o\2\2\u01d9^\3\2\2\2\u01da\u01db\7]\2\2\u01db`\3\2\2\2\u01dc\u01dd\7"+
		"_\2\2\u01ddb\3\2\2\2\u01de\u01df\7<\2\2\u01df\u01e0\7v\2\2\u01e0\u01e1"+
		"\7g\2\2\u01e1\u01e2\7n\2\2\u01e2\u01e3\7n\2\2\u01e3d\3\2\2\2\u01e4\u01e5"+
		"\7<\2\2\u01e5\u01e6\7r\2\2\u01e6\u01e7\7g\2\2\u01e7\u01e8\7t\2\2\u01e8"+
		"\u01e9\7h\2\2\u01e9\u01ea\7q\2\2\u01ea\u01eb\7t\2\2\u01eb\u01ec\7o\2\2"+
		"\u01ecf\3\2\2\2\u01ed\u01ee\7<\2\2\u01ee\u01ef\7c\2\2\u01ef\u01f0\7e\2"+
		"\2\u01f0\u01f1\7j\2\2\u01f1\u01f2\7k\2\2\u01f2\u01f3\7g\2\2\u01f3\u01f4"+
		"\7x\2\2\u01f4\u01f5\7g\2\2\u01f5h\3\2\2\2\u01f6\u01f7\7<\2\2\u01f7\u01f8"+
		"\7j\2\2\u01f8\u01f9\7q\2\2\u01f9\u01fa\7y\2\2\u01faj\3\2\2\2\u01fb\u01fc"+
		"\7<\2\2\u01fc\u01fd\7e\2\2\u01fd\u01fe\7q\2\2\u01fe\u01ff\7p\2\2\u01ff"+
		"\u0200\7u\2\2\u0200\u0201\7v\2\2\u0201\u0202\7t\2\2\u0202\u0203\7c\2\2"+
		"\u0203\u0204\7k\2\2\u0204\u0205\7p\2\2\u0205l\3\2\2\2\u0206\u0207\7>\2"+
		"\2\u0207\u0208\7/\2\2\u0208n\3\2\2\2\u0209\u020a\7V\2\2\u020a\u020b\7"+
		"t\2\2\u020b\u020c\7w\2\2\u020c\u020d\7g\2\2\u020dp\3\2\2\2\31\2\3\4\5"+
		"\6\u009c\u00aa\u00b0\u00e6\u00f4\u00fa\u0105\u011f\u012d\u0133\u013f\u0141"+
		"\u0153\u0161\u0167\u0172\u019b\u01a0\7\4\3\2\b\2\2\4\4\2\4\5\2\4\6\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}