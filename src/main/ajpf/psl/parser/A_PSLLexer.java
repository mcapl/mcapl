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
		FOF_BLOCK=17, COMMENT=18, LINE_COMMENT=19, NEWLINE=20, WS=21;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'"
	};
	public static final String[] ruleNames = {
		"ALWAYS", "FINALLY", "UNTIL", "RELEASE", "AND", "OR", "NOT", "IMP", "BELIEVE", 
		"GOAL", "FALSE", "INTENTION", "ACTION", "PERCEPT", "TRUE", "INTENDTODO", 
		"FOF_BLOCK", "COMMENT", "LINE_COMMENT", "NEWLINE", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\27\u0080\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\5\2\61\n\2\3"+
		"\3\3\3\3\3\5\3\66\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\22\6\22Y\n\22\r\22\16\22Z\3\23\3\23\3\23\3\23"+
		"\7\23a\n\23\f\23\16\23d\13\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\7\24o\n\24\f\24\16\24r\13\24\3\24\3\24\3\25\5\25w\n\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3b\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27\3"+
		"\2\5\n\2\"\"*+..\60\60\62;C\\aac|\3\2\f\f\4\2\13\13\"\"\u0085\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3\60\3\2\2\2\5\65\3\2\2\2\7\67"+
		"\3\2\2\2\t9\3\2\2\2\13;\3\2\2\2\r=\3\2\2\2\17@\3\2\2\2\21B\3\2\2\2\23"+
		"E\3\2\2\2\25G\3\2\2\2\27I\3\2\2\2\31K\3\2\2\2\33M\3\2\2\2\35O\3\2\2\2"+
		"\37Q\3\2\2\2!S\3\2\2\2#X\3\2\2\2%\\\3\2\2\2\'j\3\2\2\2)v\3\2\2\2+|\3\2"+
		"\2\2-\61\7C\2\2./\7]\2\2/\61\7_\2\2\60-\3\2\2\2\60.\3\2\2\2\61\4\3\2\2"+
		"\2\62\66\7G\2\2\63\64\7>\2\2\64\66\7@\2\2\65\62\3\2\2\2\65\63\3\2\2\2"+
		"\66\6\3\2\2\2\678\7W\2\28\b\3\2\2\29:\7T\2\2:\n\3\2\2\2;<\7(\2\2<\f\3"+
		"\2\2\2=>\7~\2\2>?\7~\2\2?\16\3\2\2\2@A\7\u0080\2\2A\20\3\2\2\2BC\7/\2"+
		"\2CD\7@\2\2D\22\3\2\2\2EF\7D\2\2F\24\3\2\2\2GH\7I\2\2H\26\3\2\2\2IJ\7"+
		"H\2\2J\30\3\2\2\2KL\7K\2\2L\32\3\2\2\2MN\7F\2\2N\34\3\2\2\2OP\7R\2\2P"+
		"\36\3\2\2\2QR\7V\2\2R \3\2\2\2ST\7K\2\2TU\7v\2\2UV\7F\2\2V\"\3\2\2\2W"+
		"Y\t\2\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[$\3\2\2\2\\]\7\61\2"+
		"\2]^\7,\2\2^b\3\2\2\2_a\13\2\2\2`_\3\2\2\2ad\3\2\2\2bc\3\2\2\2b`\3\2\2"+
		"\2ce\3\2\2\2db\3\2\2\2ef\7,\2\2fg\7\61\2\2gh\3\2\2\2hi\b\23\2\2i&\3\2"+
		"\2\2jk\7\61\2\2kl\7\61\2\2lp\3\2\2\2mo\n\3\2\2nm\3\2\2\2or\3\2\2\2pn\3"+
		"\2\2\2pq\3\2\2\2qs\3\2\2\2rp\3\2\2\2st\b\24\2\2t(\3\2\2\2uw\7\17\2\2v"+
		"u\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7\f\2\2yz\3\2\2\2z{\b\25\2\2{*\3\2\2\2"+
		"|}\t\4\2\2}~\3\2\2\2~\177\b\26\2\2\177,\3\2\2\2\t\2\60\65Zbpv\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}