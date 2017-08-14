// Generated from ActionOnlyLexer.g4 by ANTLR 4.4
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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ACTIONONLY=1, BELIEFS=2, BELIEFRULES=3, GOAL=4, NAME=5, BELIEVE=6, BRULEARROW=7, 
		ACTIONS=8, FOF_BLOCK=9, PRED_BLOCK=10, CURLYOPEN=11, CURLYCLOSE=12, POINT=13, 
		WORD=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'"
	};
	public static final String[] ruleNames = {
		"ACTIONONLY", "BELIEFS", "BELIEFRULES", "GOAL", "NAME", "BELIEVE", "BRULEARROW", 
		"ACTIONS", "FOF_BLOCK", "PRED_BLOCK", "CURLYOPEN", "CURLYCLOSE", "POINT", 
		"WORD"
	};


	public ActionOnlyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ActionOnlyLexer.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\20\u0086\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\5\7`\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\7\np\n\n\f\n\16\ns\13\n\3\13\7\13v\n\13\f\13\16\13y\13"+
		"\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\7\17\u0082\n\17\f\17\16\17\u0085\13"+
		"\17\4qw\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\3\2\3\6\2\62;C\\aac|\u0089\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\3\37\3\2\2\2\5\"\3\2\2\2\7\64\3\2\2\2\tF\3\2\2\2\13U\3\2\2\2"+
		"\r_\3\2\2\2\17a\3\2\2\2\21d\3\2\2\2\23q\3\2\2\2\25w\3\2\2\2\27z\3\2\2"+
		"\2\31|\3\2\2\2\33~\3\2\2\2\35\u0083\3\2\2\2\37 \7C\2\2 !\7Q\2\2!\4\3\2"+
		"\2\2\"#\7<\2\2#$\7K\2\2$%\7p\2\2%&\7k\2\2&\'\7v\2\2\'(\7k\2\2()\7c\2\2"+
		")*\7n\2\2*+\7\"\2\2+,\7D\2\2,-\7g\2\2-.\7n\2\2./\7k\2\2/\60\7g\2\2\60"+
		"\61\7h\2\2\61\62\7u\2\2\62\63\7<\2\2\63\6\3\2\2\2\64\65\7<\2\2\65\66\7"+
		"T\2\2\66\67\7g\2\2\678\7c\2\289\7u\2\29:\7q\2\2:;\7p\2\2;<\7k\2\2<=\7"+
		"p\2\2=>\7i\2\2>?\7\"\2\2?@\7T\2\2@A\7w\2\2AB\7n\2\2BC\7g\2\2CD\7u\2\2"+
		"DE\7<\2\2E\b\3\2\2\2FG\7<\2\2GH\7K\2\2HI\7p\2\2IJ\7k\2\2JK\7v\2\2KL\7"+
		"k\2\2LM\7c\2\2MN\7n\2\2NO\7\"\2\2OP\7I\2\2PQ\7q\2\2QR\7c\2\2RS\7n\2\2"+
		"ST\7<\2\2T\n\3\2\2\2UV\7<\2\2VW\7p\2\2WX\7c\2\2XY\7o\2\2YZ\7g\2\2Z[\7"+
		"<\2\2[\f\3\2\2\2\\`\7D\2\2]^\7\60\2\2^`\7D\2\2_\\\3\2\2\2_]\3\2\2\2`\16"+
		"\3\2\2\2ab\7<\2\2bc\7/\2\2c\20\3\2\2\2de\7<\2\2ef\7C\2\2fg\7e\2\2gh\7"+
		"v\2\2hi\7k\2\2ij\7q\2\2jk\7p\2\2kl\7u\2\2lm\7<\2\2m\22\3\2\2\2np\13\2"+
		"\2\2on\3\2\2\2ps\3\2\2\2qr\3\2\2\2qo\3\2\2\2r\24\3\2\2\2sq\3\2\2\2tv\13"+
		"\2\2\2ut\3\2\2\2vy\3\2\2\2wx\3\2\2\2wu\3\2\2\2x\26\3\2\2\2yw\3\2\2\2z"+
		"{\7}\2\2{\30\3\2\2\2|}\7\177\2\2}\32\3\2\2\2~\177\7\60\2\2\177\34\3\2"+
		"\2\2\u0080\u0082\t\2\2\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\36\3\2\2\2\u0085\u0083\3\2\2"+
		"\2\7\2_qw\u0083\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}