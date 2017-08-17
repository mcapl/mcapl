// Generated from LogicalFmlas.g4 by ANTLR 4.7
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
public class LogicalFmlasLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LINE_COMMENT=2, NEWLINE=3, WS=4, OPEN=5, CLOSE=6, SQOPEN=7, 
		SQCLOSE=8, CURLYOPEN=9, CURLYCLOSE=10, QUOTED_STRING=11, NOT=12, TRUE=13, 
		CONST=14, VAR=15, NUMBER=16, RULEARROW=17, LESS=18, EQ=19, POINT=20, MULT=21, 
		PLUS=22, MINUS=23, DIV=24, MOD=25, SHRIEK=26, COMMA=27, SEMI=28, COLON=29, 
		QUERY=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "OPEN", "CLOSE", "SQOPEN", 
		"SQCLOSE", "CURLYOPEN", "CURLYCLOSE", "QUOTED_STRING", "NOT", "TRUE", 
		"CONST", "VAR", "NUMBER", "RULEARROW", "LESS", "EQ", "POINT", "MULT", 
		"PLUS", "MINUS", "DIV", "MOD", "SHRIEK", "COMMA", "SEMI", "COLON", "QUERY"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", 
		null, "'~'", "'True'", null, null, null, "':-'", "'<'", "'=='", "'.'", 
		"'*'", "'+'", "'-'", "'/'", "'%'", "'!'", "','", "';'", "':'", "'?'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "OPEN", "CLOSE", "SQOPEN", 
		"SQCLOSE", "CURLYOPEN", "CURLYCLOSE", "QUOTED_STRING", "NOT", "TRUE", 
		"CONST", "VAR", "NUMBER", "RULEARROW", "LESS", "EQ", "POINT", "MULT", 
		"PLUS", "MINUS", "DIV", "MOD", "SHRIEK", "COMMA", "SEMI", "COLON", "QUERY"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u00b5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\7\2D\n\2\f\2\16\2G\13\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3"+
		"R\n\3\f\3\16\3U\13\3\3\3\3\3\3\4\5\4Z\n\4\3\4\3\4\3\4\3\4\3\5\6\5a\n\5"+
		"\r\5\16\5b\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\7\fu\n\f\f\f\16\fx\13\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\7\17\u0085\n\17\f\17\16\17\u0088\13\17\3\20\3\20\7\20\u008c"+
		"\n\20\f\20\16\20\u008f\13\20\3\21\3\21\7\21\u0093\n\21\f\21\16\21\u0096"+
		"\13\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\4Ev\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= \3\2\5\3\2\f\f\4\2\13\13\"\"\6\2\62;C\\aac|\2\u00bc"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5M\3\2\2\2\7Y\3\2\2\2\t`\3\2\2\2\13f\3\2"+
		"\2\2\rh\3\2\2\2\17j\3\2\2\2\21l\3\2\2\2\23n\3\2\2\2\25p\3\2\2\2\27r\3"+
		"\2\2\2\31{\3\2\2\2\33}\3\2\2\2\35\u0082\3\2\2\2\37\u0089\3\2\2\2!\u0090"+
		"\3\2\2\2#\u0097\3\2\2\2%\u009a\3\2\2\2\'\u009c\3\2\2\2)\u009f\3\2\2\2"+
		"+\u00a1\3\2\2\2-\u00a3\3\2\2\2/\u00a5\3\2\2\2\61\u00a7\3\2\2\2\63\u00a9"+
		"\3\2\2\2\65\u00ab\3\2\2\2\67\u00ad\3\2\2\29\u00af\3\2\2\2;\u00b1\3\2\2"+
		"\2=\u00b3\3\2\2\2?@\7\61\2\2@A\7,\2\2AE\3\2\2\2BD\13\2\2\2CB\3\2\2\2D"+
		"G\3\2\2\2EF\3\2\2\2EC\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7,\2\2IJ\7\61\2\2"+
		"JK\3\2\2\2KL\b\2\2\2L\4\3\2\2\2MN\7\61\2\2NO\7\61\2\2OS\3\2\2\2PR\n\2"+
		"\2\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\b\3"+
		"\2\2W\6\3\2\2\2XZ\7\17\2\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7\f\2\2\\"+
		"]\3\2\2\2]^\b\4\2\2^\b\3\2\2\2_a\t\3\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2"+
		"bc\3\2\2\2cd\3\2\2\2de\b\5\2\2e\n\3\2\2\2fg\7*\2\2g\f\3\2\2\2hi\7+\2\2"+
		"i\16\3\2\2\2jk\7]\2\2k\20\3\2\2\2lm\7_\2\2m\22\3\2\2\2no\7}\2\2o\24\3"+
		"\2\2\2pq\7\177\2\2q\26\3\2\2\2rv\7$\2\2su\13\2\2\2ts\3\2\2\2ux\3\2\2\2"+
		"vw\3\2\2\2vt\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7$\2\2z\30\3\2\2\2{|\7\u0080"+
		"\2\2|\32\3\2\2\2}~\7V\2\2~\177\7t\2\2\177\u0080\7w\2\2\u0080\u0081\7g"+
		"\2\2\u0081\34\3\2\2\2\u0082\u0086\4c|\2\u0083\u0085\t\4\2\2\u0084\u0083"+
		"\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\36\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008d\4C\\\2\u008a\u008c\t\4\2\2"+
		"\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e \3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0094\4\62;\2\u0091"+
		"\u0093\4\62;\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\"\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0098"+
		"\7<\2\2\u0098\u0099\7/\2\2\u0099$\3\2\2\2\u009a\u009b\7>\2\2\u009b&\3"+
		"\2\2\2\u009c\u009d\7?\2\2\u009d\u009e\7?\2\2\u009e(\3\2\2\2\u009f\u00a0"+
		"\7\60\2\2\u00a0*\3\2\2\2\u00a1\u00a2\7,\2\2\u00a2,\3\2\2\2\u00a3\u00a4"+
		"\7-\2\2\u00a4.\3\2\2\2\u00a5\u00a6\7/\2\2\u00a6\60\3\2\2\2\u00a7\u00a8"+
		"\7\61\2\2\u00a8\62\3\2\2\2\u00a9\u00aa\7\'\2\2\u00aa\64\3\2\2\2\u00ab"+
		"\u00ac\7#\2\2\u00ac\66\3\2\2\2\u00ad\u00ae\7.\2\2\u00ae8\3\2\2\2\u00af"+
		"\u00b0\7=\2\2\u00b0:\3\2\2\2\u00b1\u00b2\7<\2\2\u00b2<\3\2\2\2\u00b3\u00b4"+
		"\7A\2\2\u00b4>\3\2\2\2\13\2ESYbv\u0086\u008d\u0094\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}