// Generated from /Users/louisedennis/eclipse-workspace/mcapl/src/main/ajpf/psl/parser/antlr/LogicalFmlas.g4 by ANTLR 4.7
package ajpf.psl.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LogicalFmlasLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LINE_COMMENT=2, NEWLINE=3, WS=4, OPEN=5, CLOSE=6, SQOPEN=7, 
		SQCLOSE=8, CURLYOPEN=9, CURLYCLOSE=10, QUOTED_STRING=11, NOT=12, TRUE=13, 
		CONST=14, VAR=15, NUMBER=16, UNNAMEDVAR=17, RULEARROW=18, LESS=19, EQ=20, 
		POINT=21, MULT=22, PLUS=23, MINUS=24, DIV=25, MOD=26, SHRIEK=27, COMMA=28, 
		SEMI=29, COLON=30, QUERY=31, BAR=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "OPEN", "CLOSE", "SQOPEN", 
		"SQCLOSE", "CURLYOPEN", "CURLYCLOSE", "QUOTED_STRING", "NOT", "TRUE", 
		"CONST", "VAR", "NUMBER", "UNNAMEDVAR", "RULEARROW", "LESS", "EQ", "POINT", 
		"MULT", "PLUS", "MINUS", "DIV", "MOD", "SHRIEK", "COMMA", "SEMI", "COLON", 
		"QUERY", "BAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", 
		null, "'~'", "'True'", null, null, null, "'_'", "':-'", "'<'", "'=='", 
		"'.'", "'*'", "'+'", "'-'", "'/'", "'%'", "'!'", "','", "';'", "':'", 
		"'?'", "'|'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "OPEN", "CLOSE", "SQOPEN", 
		"SQCLOSE", "CURLYOPEN", "CURLYCLOSE", "QUOTED_STRING", "NOT", "TRUE", 
		"CONST", "VAR", "NUMBER", "UNNAMEDVAR", "RULEARROW", "LESS", "EQ", "POINT", 
		"MULT", "PLUS", "MINUS", "DIV", "MOD", "SHRIEK", "COMMA", "SEMI", "COLON", 
		"QUERY", "BAR"
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


	public LogicalFmlasLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LogicalFmlas.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u00c6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\7\2H\n\2\f\2\16\2K\13\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\7\3V\n\3\f\3\16\3Y\13\3\3\3\3\3\3\4\5\4^\n\4\3\4\3\4\3\4\3"+
		"\4\3\5\6\5e\n\5\r\5\16\5f\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\7\fy\n\f\f\f\16\f|\13\f\3\f\3\f\3\f\7\f\u0081\n"+
		"\f\f\f\16\f\u0084\13\f\3\f\5\f\u0087\n\f\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\7\17\u0092\n\17\f\17\16\17\u0095\13\17\3\20\3\20\7\20\u0099"+
		"\n\20\f\20\16\20\u009c\13\20\3\21\3\21\7\21\u00a0\n\21\f\21\16\21\u00a3"+
		"\13\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\5Iz\u0082\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"\3\2\b\3\2\f\f\4\2\13"+
		"\13\"\"\4\2\60\60c|\7\2\60\60\62;C\\aac|\6\2\62;C\\aac|\4\2\60\60\62;"+
		"\2\u00cf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5Q\3\2\2\2"+
		"\7]\3\2\2\2\td\3\2\2\2\13j\3\2\2\2\rl\3\2\2\2\17n\3\2\2\2\21p\3\2\2\2"+
		"\23r\3\2\2\2\25t\3\2\2\2\27\u0086\3\2\2\2\31\u0088\3\2\2\2\33\u008a\3"+
		"\2\2\2\35\u008f\3\2\2\2\37\u0096\3\2\2\2!\u009d\3\2\2\2#\u00a4\3\2\2\2"+
		"%\u00a6\3\2\2\2\'\u00a9\3\2\2\2)\u00ab\3\2\2\2+\u00ae\3\2\2\2-\u00b0\3"+
		"\2\2\2/\u00b2\3\2\2\2\61\u00b4\3\2\2\2\63\u00b6\3\2\2\2\65\u00b8\3\2\2"+
		"\2\67\u00ba\3\2\2\29\u00bc\3\2\2\2;\u00be\3\2\2\2=\u00c0\3\2\2\2?\u00c2"+
		"\3\2\2\2A\u00c4\3\2\2\2CD\7\61\2\2DE\7,\2\2EI\3\2\2\2FH\13\2\2\2GF\3\2"+
		"\2\2HK\3\2\2\2IJ\3\2\2\2IG\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7,\2\2MN\7\61"+
		"\2\2NO\3\2\2\2OP\b\2\2\2P\4\3\2\2\2QR\7\61\2\2RS\7\61\2\2SW\3\2\2\2TV"+
		"\n\2\2\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z"+
		"[\b\3\2\2[\6\3\2\2\2\\^\7\17\2\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\7\f"+
		"\2\2`a\3\2\2\2ab\b\4\2\2b\b\3\2\2\2ce\t\3\2\2dc\3\2\2\2ef\3\2\2\2fd\3"+
		"\2\2\2fg\3\2\2\2gh\3\2\2\2hi\b\5\2\2i\n\3\2\2\2jk\7*\2\2k\f\3\2\2\2lm"+
		"\7+\2\2m\16\3\2\2\2no\7]\2\2o\20\3\2\2\2pq\7_\2\2q\22\3\2\2\2rs\7}\2\2"+
		"s\24\3\2\2\2tu\7\177\2\2u\26\3\2\2\2vz\7$\2\2wy\13\2\2\2xw\3\2\2\2y|\3"+
		"\2\2\2z{\3\2\2\2zx\3\2\2\2{}\3\2\2\2|z\3\2\2\2}\u0087\7$\2\2~\u0082\7"+
		")\2\2\177\u0081\13\2\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0087\7)\2\2\u0086v\3\2\2\2\u0086~\3\2\2\2\u0087\30\3\2\2\2\u0088\u0089"+
		"\7\u0080\2\2\u0089\32\3\2\2\2\u008a\u008b\7V\2\2\u008b\u008c\7t\2\2\u008c"+
		"\u008d\7w\2\2\u008d\u008e\7g\2\2\u008e\34\3\2\2\2\u008f\u0093\t\4\2\2"+
		"\u0090\u0092\t\5\2\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\36\3\2\2\2\u0095\u0093\3\2\2\2\u0096"+
		"\u009a\4C\\\2\u0097\u0099\t\6\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b \3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009d\u00a1\4\62;\2\u009e\u00a0\t\7\2\2\u009f\u009e\3\2\2\2\u00a0"+
		"\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\"\3\2\2\2"+
		"\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7a\2\2\u00a5$\3\2\2\2\u00a6\u00a7\7<"+
		"\2\2\u00a7\u00a8\7/\2\2\u00a8&\3\2\2\2\u00a9\u00aa\7>\2\2\u00aa(\3\2\2"+
		"\2\u00ab\u00ac\7?\2\2\u00ac\u00ad\7?\2\2\u00ad*\3\2\2\2\u00ae\u00af\7"+
		"\60\2\2\u00af,\3\2\2\2\u00b0\u00b1\7,\2\2\u00b1.\3\2\2\2\u00b2\u00b3\7"+
		"-\2\2\u00b3\60\3\2\2\2\u00b4\u00b5\7/\2\2\u00b5\62\3\2\2\2\u00b6\u00b7"+
		"\7\61\2\2\u00b7\64\3\2\2\2\u00b8\u00b9\7\'\2\2\u00b9\66\3\2\2\2\u00ba"+
		"\u00bb\7#\2\2\u00bb8\3\2\2\2\u00bc\u00bd\7.\2\2\u00bd:\3\2\2\2\u00be\u00bf"+
		"\7=\2\2\u00bf<\3\2\2\2\u00c0\u00c1\7<\2\2\u00c1>\3\2\2\2\u00c2\u00c3\7"+
		"A\2\2\u00c3@\3\2\2\2\u00c4\u00c5\7~\2\2\u00c5B\3\2\2\2\r\2IW]fz\u0082"+
		"\u0086\u0093\u009a\u00a1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}