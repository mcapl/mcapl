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
		CONST=17, QUOTED_STRING=18, OPEN=19, CLOSE=20, COMMASEP=21, IDPUNCT=22, 
		SQOPEN=23, SQCLOSE=24, COMMENT=25, LINE_COMMENT=26, NEWLINE=27, WS=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'"
	};
	public static final String[] ruleNames = {
		"ALWAYS", "FINALLY", "UNTIL", "RELEASE", "AND", "OR", "NOT", "IMP", "BELIEVE", 
		"GOAL", "FALSE", "INTENTION", "ACTION", "PERCEPT", "TRUE", "INTENDTODO", 
		"CONST", "QUOTED_STRING", "OPEN", "CLOSE", "COMMASEP", "IDPUNCT", "SQOPEN", 
		"SQCLOSE", "COMMENT", "LINE_COMMENT", "NEWLINE", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00ac\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\5\2?\n\2\3\3"+
		"\3\3\3\3\5\3D\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\22\6\22g\n\22\r\22\16\22h\3\23\3\23\7\23m\n\23\f"+
		"\23\16\23p\13\23\3\23\3\23\3\23\7\23u\n\23\f\23\16\23x\13\23\3\23\5\23"+
		"{\n\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\7\32\u008d\n\32\f\32\16\32\u0090\13\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u009b\n\33\f\33\16\33\u009e\13\33"+
		"\3\33\3\33\3\34\5\34\u00a3\n\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\5nv\u008e\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36\3\2\5\7\2\62;>>C\\aac|\3\2\f\f\4\2\13\13\"\"\u00b4\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3>\3\2\2\2"+
		"\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK\3\2\2\2\17N\3\2\2\2\21"+
		"P\3\2\2\2\23S\3\2\2\2\25U\3\2\2\2\27W\3\2\2\2\31Y\3\2\2\2\33[\3\2\2\2"+
		"\35]\3\2\2\2\37_\3\2\2\2!a\3\2\2\2#f\3\2\2\2%z\3\2\2\2\'|\3\2\2\2)~\3"+
		"\2\2\2+\u0080\3\2\2\2-\u0082\3\2\2\2/\u0084\3\2\2\2\61\u0086\3\2\2\2\63"+
		"\u0088\3\2\2\2\65\u0096\3\2\2\2\67\u00a2\3\2\2\29\u00a8\3\2\2\2;?\7C\2"+
		"\2<=\7]\2\2=?\7_\2\2>;\3\2\2\2><\3\2\2\2?\4\3\2\2\2@D\7G\2\2AB\7>\2\2"+
		"BD\7@\2\2C@\3\2\2\2CA\3\2\2\2D\6\3\2\2\2EF\7W\2\2F\b\3\2\2\2GH\7T\2\2"+
		"H\n\3\2\2\2IJ\7(\2\2J\f\3\2\2\2KL\7~\2\2LM\7~\2\2M\16\3\2\2\2NO\7\u0080"+
		"\2\2O\20\3\2\2\2PQ\7/\2\2QR\7@\2\2R\22\3\2\2\2ST\7D\2\2T\24\3\2\2\2UV"+
		"\7I\2\2V\26\3\2\2\2WX\7H\2\2X\30\3\2\2\2YZ\7K\2\2Z\32\3\2\2\2[\\\7F\2"+
		"\2\\\34\3\2\2\2]^\7R\2\2^\36\3\2\2\2_`\7V\2\2` \3\2\2\2ab\7K\2\2bc\7v"+
		"\2\2cd\7F\2\2d\"\3\2\2\2eg\t\2\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2"+
		"\2\2i$\3\2\2\2jn\7$\2\2km\13\2\2\2lk\3\2\2\2mp\3\2\2\2no\3\2\2\2nl\3\2"+
		"\2\2oq\3\2\2\2pn\3\2\2\2q{\7$\2\2rv\7)\2\2su\13\2\2\2ts\3\2\2\2ux\3\2"+
		"\2\2vw\3\2\2\2vt\3\2\2\2wy\3\2\2\2xv\3\2\2\2y{\7)\2\2zj\3\2\2\2zr\3\2"+
		"\2\2{&\3\2\2\2|}\7*\2\2}(\3\2\2\2~\177\7+\2\2\177*\3\2\2\2\u0080\u0081"+
		"\7.\2\2\u0081,\3\2\2\2\u0082\u0083\7\60\2\2\u0083.\3\2\2\2\u0084\u0085"+
		"\7]\2\2\u0085\60\3\2\2\2\u0086\u0087\7_\2\2\u0087\62\3\2\2\2\u0088\u0089"+
		"\7\61\2\2\u0089\u008a\7,\2\2\u008a\u008e\3\2\2\2\u008b\u008d\13\2\2\2"+
		"\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008f\3\2\2\2\u008e\u008c"+
		"\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7,\2\2\u0092"+
		"\u0093\7\61\2\2\u0093\u0094\3\2\2\2\u0094\u0095\b\32\2\2\u0095\64\3\2"+
		"\2\2\u0096\u0097\7\61\2\2\u0097\u0098\7\61\2\2\u0098\u009c\3\2\2\2\u0099"+
		"\u009b\n\3\2\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a0\b\33\2\2\u00a0\66\3\2\2\2\u00a1\u00a3\7\17\2\2\u00a2\u00a1\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\7\f\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a7\b\34\2\2\u00a78\3\2\2\2\u00a8\u00a9\t\4\2\2"+
		"\u00a9\u00aa\3\2\2\2\u00aa\u00ab\b\35\2\2\u00ab:\3\2\2\2\f\2>Chnvz\u008e"+
		"\u009c\u00a2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}