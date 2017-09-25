// Generated from A_PSLLexer.g4 by ANTLR 4.4
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
public class A_PSLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALWAYS=1, FINALLY=2, UNTIL=3, RELEASE=4, AND=5, OR=6, NOT=7, IMP=8, BELIEVE=9, 
		GOAL=10, FALSE=11, INTENTION=12, ACTION=13, PERCEPT=14, TRUE=15, INTENDTODO=16, 
		CONST=17, OPEN=18, CLOSE=19, COMMASEP=20, IDPUNCT=21, SQOPEN=22, SQCLOSE=23, 
		COMMENT=24, LINE_COMMENT=25, NEWLINE=26, WS=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'"
	};
	public static final String[] ruleNames = {
		"ALWAYS", "FINALLY", "UNTIL", "RELEASE", "AND", "OR", "NOT", "IMP", "BELIEVE", 
		"GOAL", "FALSE", "INTENTION", "ACTION", "PERCEPT", "TRUE", "INTENDTODO", 
		"CONST", "OPEN", "CLOSE", "COMMASEP", "IDPUNCT", "SQOPEN", "SQCLOSE", 
		"COMMENT", "LINE_COMMENT", "NEWLINE", "WS"
	};


	public A_PSLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "A_PSLLexer.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u0098\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\5\2=\n\2\3\3\3\3\3\3\5"+
		"\3B\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\22\6\22e\n\22\r\22\16\22f\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\7\31y\n\31\f\31\16\31|\13"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u0087\n\32\f\32"+
		"\16\32\u008a\13\32\3\32\3\32\3\33\5\33\u008f\n\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3z\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\35\3\2\5\6\2\62;C\\aac|\3\2\f\f\4\2\13\13\"\"\u009d"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\3<\3\2\2\2\5A\3"+
		"\2\2\2\7C\3\2\2\2\tE\3\2\2\2\13G\3\2\2\2\rI\3\2\2\2\17L\3\2\2\2\21N\3"+
		"\2\2\2\23Q\3\2\2\2\25S\3\2\2\2\27U\3\2\2\2\31W\3\2\2\2\33Y\3\2\2\2\35"+
		"[\3\2\2\2\37]\3\2\2\2!_\3\2\2\2#d\3\2\2\2%h\3\2\2\2\'j\3\2\2\2)l\3\2\2"+
		"\2+n\3\2\2\2-p\3\2\2\2/r\3\2\2\2\61t\3\2\2\2\63\u0082\3\2\2\2\65\u008e"+
		"\3\2\2\2\67\u0094\3\2\2\29=\7C\2\2:;\7]\2\2;=\7_\2\2<9\3\2\2\2<:\3\2\2"+
		"\2=\4\3\2\2\2>B\7G\2\2?@\7>\2\2@B\7@\2\2A>\3\2\2\2A?\3\2\2\2B\6\3\2\2"+
		"\2CD\7W\2\2D\b\3\2\2\2EF\7T\2\2F\n\3\2\2\2GH\7(\2\2H\f\3\2\2\2IJ\7~\2"+
		"\2JK\7~\2\2K\16\3\2\2\2LM\7\u0080\2\2M\20\3\2\2\2NO\7/\2\2OP\7@\2\2P\22"+
		"\3\2\2\2QR\7D\2\2R\24\3\2\2\2ST\7I\2\2T\26\3\2\2\2UV\7H\2\2V\30\3\2\2"+
		"\2WX\7K\2\2X\32\3\2\2\2YZ\7F\2\2Z\34\3\2\2\2[\\\7R\2\2\\\36\3\2\2\2]^"+
		"\7V\2\2^ \3\2\2\2_`\7K\2\2`a\7v\2\2ab\7F\2\2b\"\3\2\2\2ce\t\2\2\2dc\3"+
		"\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2g$\3\2\2\2hi\7*\2\2i&\3\2\2\2jk\7"+
		"+\2\2k(\3\2\2\2lm\7.\2\2m*\3\2\2\2no\7\60\2\2o,\3\2\2\2pq\7]\2\2q.\3\2"+
		"\2\2rs\7_\2\2s\60\3\2\2\2tu\7\61\2\2uv\7,\2\2vz\3\2\2\2wy\13\2\2\2xw\3"+
		"\2\2\2y|\3\2\2\2z{\3\2\2\2zx\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\7,\2\2~\177"+
		"\7\61\2\2\177\u0080\3\2\2\2\u0080\u0081\b\31\2\2\u0081\62\3\2\2\2\u0082"+
		"\u0083\7\61\2\2\u0083\u0084\7\61\2\2\u0084\u0088\3\2\2\2\u0085\u0087\n"+
		"\3\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\b\32"+
		"\2\2\u008c\64\3\2\2\2\u008d\u008f\7\17\2\2\u008e\u008d\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\7\f\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0093\b\33\2\2\u0093\66\3\2\2\2\u0094\u0095\t\4\2\2\u0095\u0096\3\2\2"+
		"\2\u0096\u0097\b\34\2\2\u00978\3\2\2\2\t\2<Afz\u0088\u008e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}