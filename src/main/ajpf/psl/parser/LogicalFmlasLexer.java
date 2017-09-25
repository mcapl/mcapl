// Generated from LogicalFmlas.g4 by ANTLR 4.4
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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LINE_COMMENT=2, NEWLINE=3, WS=4, OPEN=5, CLOSE=6, SQOPEN=7, 
		SQCLOSE=8, CURLYOPEN=9, CURLYCLOSE=10, QUOTED_STRING=11, NOT=12, TRUE=13, 
		CONST=14, VAR=15, NUMBER=16, UNNAMEDVAR=17, RULEARROW=18, LESS=19, EQ=20, 
		POINT=21, MULT=22, PLUS=23, MINUS=24, DIV=25, MOD=26, SHRIEK=27, COMMA=28, 
		SEMI=29, COLON=30, QUERY=31, BAR=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '"
	};
	public static final String[] ruleNames = {
		"COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "OPEN", "CLOSE", "SQOPEN", 
		"SQCLOSE", "CURLYOPEN", "CURLYCLOSE", "QUOTED_STRING", "NOT", "TRUE", 
		"CONST", "VAR", "NUMBER", "UNNAMEDVAR", "RULEARROW", "LESS", "EQ", "POINT", 
		"MULT", "PLUS", "MINUS", "DIV", "MOD", "SHRIEK", "COMMA", "SEMI", "COLON", 
		"QUERY", "BAR"
	};


	public LogicalFmlasLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LogicalFmlas.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u00bd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\7\2H\n\2\f\2\16\2K\13\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\7\3V\n\3\f\3\16\3Y\13\3\3\3\3\3\3\4\5\4^\n\4\3\4\3\4\3\4\3"+
		"\4\3\5\6\5e\n\5\r\5\16\5f\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\7\fy\n\f\f\f\16\f|\13\f\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\7\17\u0089\n\17\f\17\16\17\u008c\13\17\3"+
		"\20\3\20\7\20\u0090\n\20\f\20\16\20\u0093\13\20\3\21\3\21\7\21\u0097\n"+
		"\21\f\21\16\21\u009a\13\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\4Iz\2\"\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"\3\2\6"+
		"\3\2\f\f\4\2\13\13\"\"\7\2\60\60\62;C\\aac|\6\2\62;C\\aac|\u00c4\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5Q\3\2\2\2\7]\3\2\2\2\td"+
		"\3\2\2\2\13j\3\2\2\2\rl\3\2\2\2\17n\3\2\2\2\21p\3\2\2\2\23r\3\2\2\2\25"+
		"t\3\2\2\2\27v\3\2\2\2\31\177\3\2\2\2\33\u0081\3\2\2\2\35\u0086\3\2\2\2"+
		"\37\u008d\3\2\2\2!\u0094\3\2\2\2#\u009b\3\2\2\2%\u009d\3\2\2\2\'\u00a0"+
		"\3\2\2\2)\u00a2\3\2\2\2+\u00a5\3\2\2\2-\u00a7\3\2\2\2/\u00a9\3\2\2\2\61"+
		"\u00ab\3\2\2\2\63\u00ad\3\2\2\2\65\u00af\3\2\2\2\67\u00b1\3\2\2\29\u00b3"+
		"\3\2\2\2;\u00b5\3\2\2\2=\u00b7\3\2\2\2?\u00b9\3\2\2\2A\u00bb\3\2\2\2C"+
		"D\7\61\2\2DE\7,\2\2EI\3\2\2\2FH\13\2\2\2GF\3\2\2\2HK\3\2\2\2IJ\3\2\2\2"+
		"IG\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7,\2\2MN\7\61\2\2NO\3\2\2\2OP\b\2\2\2"+
		"P\4\3\2\2\2QR\7\61\2\2RS\7\61\2\2SW\3\2\2\2TV\n\2\2\2UT\3\2\2\2VY\3\2"+
		"\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\b\3\2\2[\6\3\2\2\2\\^\7"+
		"\17\2\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\7\f\2\2`a\3\2\2\2ab\b\4\2\2b"+
		"\b\3\2\2\2ce\t\3\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gh\3\2\2\2"+
		"hi\b\5\2\2i\n\3\2\2\2jk\7*\2\2k\f\3\2\2\2lm\7+\2\2m\16\3\2\2\2no\7]\2"+
		"\2o\20\3\2\2\2pq\7_\2\2q\22\3\2\2\2rs\7}\2\2s\24\3\2\2\2tu\7\177\2\2u"+
		"\26\3\2\2\2vz\7$\2\2wy\13\2\2\2xw\3\2\2\2y|\3\2\2\2z{\3\2\2\2zx\3\2\2"+
		"\2{}\3\2\2\2|z\3\2\2\2}~\7$\2\2~\30\3\2\2\2\177\u0080\7\u0080\2\2\u0080"+
		"\32\3\2\2\2\u0081\u0082\7V\2\2\u0082\u0083\7t\2\2\u0083\u0084\7w\2\2\u0084"+
		"\u0085\7g\2\2\u0085\34\3\2\2\2\u0086\u008a\4c|\2\u0087\u0089\t\4\2\2\u0088"+
		"\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2"+
		"\2\2\u008b\36\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u0091\4C\\\2\u008e\u0090"+
		"\t\5\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092 \3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0098\4\62;\2"+
		"\u0095\u0097\4\62;\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\"\3\2\2\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009c\7a\2\2\u009c$\3\2\2\2\u009d\u009e\7<\2\2\u009e\u009f\7/\2\2\u009f"+
		"&\3\2\2\2\u00a0\u00a1\7>\2\2\u00a1(\3\2\2\2\u00a2\u00a3\7?\2\2\u00a3\u00a4"+
		"\7?\2\2\u00a4*\3\2\2\2\u00a5\u00a6\7\60\2\2\u00a6,\3\2\2\2\u00a7\u00a8"+
		"\7,\2\2\u00a8.\3\2\2\2\u00a9\u00aa\7-\2\2\u00aa\60\3\2\2\2\u00ab\u00ac"+
		"\7/\2\2\u00ac\62\3\2\2\2\u00ad\u00ae\7\61\2\2\u00ae\64\3\2\2\2\u00af\u00b0"+
		"\7\'\2\2\u00b0\66\3\2\2\2\u00b1\u00b2\7#\2\2\u00b28\3\2\2\2\u00b3\u00b4"+
		"\7.\2\2\u00b4:\3\2\2\2\u00b5\u00b6\7=\2\2\u00b6<\3\2\2\2\u00b7\u00b8\7"+
		"<\2\2\u00b8>\3\2\2\2\u00b9\u00ba\7A\2\2\u00ba@\3\2\2\2\u00bb\u00bc\7~"+
		"\2\2\u00bcB\3\2\2\2\13\2IW]fz\u008a\u0091\u0098\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}