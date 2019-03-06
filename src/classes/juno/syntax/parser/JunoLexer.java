// Generated from JunoLexer.g4 by ANTLR 4.4
package juno.syntax.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JunoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LINE_COMMENT=2, NEWLINE=3, WS=4, CURLYOPEN=5, CURLYCLOSE=6, 
		OPEN=7, CLOSE=8, ADD=9, DEL=10, ARROW=11, COMMA=12, CONST=13, FILE_BLOCK=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'"
	};
	public static final String[] ruleNames = {
		"COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "CURLYOPEN", "CURLYCLOSE", 
		"OPEN", "CLOSE", "ADD", "DEL", "ARROW", "COMMA", "CONST", "FILE_BLOCK"
	};


	public JunoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JunoLexer.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\20^\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\7\2$\n\2\f\2\16"+
		"\2\'\13\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\62\n\3\f\3\16\3\65\13"+
		"\3\3\3\3\3\3\4\5\4:\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\6\16V\n"+
		"\16\r\16\16\16W\3\17\6\17[\n\17\r\17\16\17\\\3%\2\20\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\3\2\6\3\2\f\f\4\2\13"+
		"\13\"\"\7\2\62;>>C\\aac|\6\2\60;C\\aac|b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\3\37\3\2\2\2\5-\3\2\2\2\79\3\2\2\2\t?\3\2\2\2\13C\3\2\2\2\rE"+
		"\3\2\2\2\17G\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27O\3\2\2\2\31"+
		"R\3\2\2\2\33U\3\2\2\2\35Z\3\2\2\2\37 \7\61\2\2 !\7,\2\2!%\3\2\2\2\"$\13"+
		"\2\2\2#\"\3\2\2\2$\'\3\2\2\2%&\3\2\2\2%#\3\2\2\2&(\3\2\2\2\'%\3\2\2\2"+
		"()\7,\2\2)*\7\61\2\2*+\3\2\2\2+,\b\2\2\2,\4\3\2\2\2-.\7\61\2\2./\7\61"+
		"\2\2/\63\3\2\2\2\60\62\n\2\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2"+
		"\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\b\3\2\2\67\6\3\2\2"+
		"\28:\7\17\2\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\7\f\2\2<=\3\2\2\2=>\b\4"+
		"\2\2>\b\3\2\2\2?@\t\3\2\2@A\3\2\2\2AB\b\5\2\2B\n\3\2\2\2CD\7}\2\2D\f\3"+
		"\2\2\2EF\7\177\2\2F\16\3\2\2\2GH\7*\2\2H\20\3\2\2\2IJ\7+\2\2J\22\3\2\2"+
		"\2KL\7-\2\2L\24\3\2\2\2MN\7/\2\2N\26\3\2\2\2OP\7>\2\2PQ\7/\2\2Q\30\3\2"+
		"\2\2RS\7.\2\2S\32\3\2\2\2TV\t\4\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3"+
		"\2\2\2X\34\3\2\2\2Y[\t\5\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2"+
		"\2]\36\3\2\2\2\b\2%\639W\\\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}