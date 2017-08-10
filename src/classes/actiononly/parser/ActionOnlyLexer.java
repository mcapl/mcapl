// Generated from ActionOnly.g4 by ANTLR 4.4
package actiononly.parser;

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
		ACTIONS=8, COMMENT=9, LINE_COMMENT=10, NEWLINE=11, WS=12, OPEN=13, CLOSE=14, 
		SQOPEN=15, SQCLOSE=16, CURLYOPEN=17, CURLYCLOSE=18, QUOTED_STRING=19, 
		NOT=20, TRUE=21, CONST=22, VAR=23, NUMBER=24, LESS=25, EQ=26, POINT=27, 
		MULT=28, PLUS=29, MINUS=30, DIV=31, MOD=32, SHRIEK=33, COMMA=34, SEMI=35, 
		COLON=36, QUERY=37;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'"
	};
	public static final String[] ruleNames = {
		"ACTIONONLY", "BELIEFS", "BELIEFRULES", "GOAL", "NAME", "BELIEVE", "BRULEARROW", 
		"ACTIONS", "COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "OPEN", "CLOSE", 
		"SQOPEN", "SQCLOSE", "CURLYOPEN", "CURLYCLOSE", "QUOTED_STRING", "NOT", 
		"TRUE", "CONST", "VAR", "NUMBER", "LESS", "EQ", "POINT", "MULT", "PLUS", 
		"MINUS", "DIV", "MOD", "SHRIEK", "COMMA", "SEMI", "COLON", "QUERY"
	};


	    public int plain_nesting = 0;
	    public int sq_nesting = 0;
	    public int curly_nesting = 0;
	    public boolean stringterm = false;
	    public boolean ao = true;
	    public int belief_rules = 0;


	public ActionOnlyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ActionOnly.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: ACTIONONLY_action((RuleContext)_localctx, actionIndex); break;
		case 2: BELIEFRULES_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void BELIEFRULES_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: belief_rules = 1; break;
		}
	}
	private void ACTIONONLY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: ao = true; break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0: return ACTIONONLY_sempred((RuleContext)_localctx, predIndex);
		case 5: return BELIEVE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean ACTIONONLY_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return curly_nesting == 0;
		}
		return true;
	}
	private boolean BELIEVE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return curly_nesting > 0 && plain_nesting == 0 || belief_rules==1;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\'\u0115\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u0094\n\7\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u00a7\n\n\f\n\16"+
		"\n\u00aa\13\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13\u00b5\n\13"+
		"\f\13\16\13\u00b8\13\13\3\13\3\13\3\f\5\f\u00bd\n\f\3\f\3\f\3\f\3\f\3"+
		"\r\6\r\u00c4\n\r\r\r\16\r\u00c5\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\7\24\u00d8\n\24\f\24\16\24\u00db"+
		"\13\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\7\27\u00e8"+
		"\n\27\f\27\16\27\u00eb\13\27\3\30\3\30\7\30\u00ef\n\30\f\30\16\30\u00f2"+
		"\13\30\3\31\3\31\7\31\u00f6\n\31\f\31\16\31\u00f9\13\31\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3#\3#\3$\3$\3%\3%\3&\3&\4\u00a8\u00d9\2\'\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'\3\2\5\3"+
		"\2\f\f\4\2\13\13\"\"\6\2\62;C\\aac|\u011d\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M"+
		"\3\2\2\2\5S\3\2\2\2\7e\3\2\2\2\ty\3\2\2\2\13\u0088\3\2\2\2\r\u008f\3\2"+
		"\2\2\17\u0095\3\2\2\2\21\u0098\3\2\2\2\23\u00a2\3\2\2\2\25\u00b0\3\2\2"+
		"\2\27\u00bc\3\2\2\2\31\u00c3\3\2\2\2\33\u00c9\3\2\2\2\35\u00cb\3\2\2\2"+
		"\37\u00cd\3\2\2\2!\u00cf\3\2\2\2#\u00d1\3\2\2\2%\u00d3\3\2\2\2\'\u00d5"+
		"\3\2\2\2)\u00de\3\2\2\2+\u00e0\3\2\2\2-\u00e5\3\2\2\2/\u00ec\3\2\2\2\61"+
		"\u00f3\3\2\2\2\63\u00fa\3\2\2\2\65\u00fc\3\2\2\2\67\u00ff\3\2\2\29\u0101"+
		"\3\2\2\2;\u0103\3\2\2\2=\u0105\3\2\2\2?\u0107\3\2\2\2A\u0109\3\2\2\2C"+
		"\u010b\3\2\2\2E\u010d\3\2\2\2G\u010f\3\2\2\2I\u0111\3\2\2\2K\u0113\3\2"+
		"\2\2MN\6\2\2\2NO\7C\2\2OP\7Q\2\2PQ\3\2\2\2QR\b\2\2\2R\4\3\2\2\2ST\7<\2"+
		"\2TU\7K\2\2UV\7p\2\2VW\7k\2\2WX\7v\2\2XY\7k\2\2YZ\7c\2\2Z[\7n\2\2[\\\7"+
		"\"\2\2\\]\7D\2\2]^\7g\2\2^_\7n\2\2_`\7k\2\2`a\7g\2\2ab\7h\2\2bc\7u\2\2"+
		"cd\7<\2\2d\6\3\2\2\2ef\7<\2\2fg\7T\2\2gh\7g\2\2hi\7c\2\2ij\7u\2\2jk\7"+
		"q\2\2kl\7p\2\2lm\7k\2\2mn\7p\2\2no\7i\2\2op\7\"\2\2pq\7T\2\2qr\7w\2\2"+
		"rs\7n\2\2st\7g\2\2tu\7u\2\2uv\7<\2\2vw\3\2\2\2wx\b\4\3\2x\b\3\2\2\2yz"+
		"\7<\2\2z{\7K\2\2{|\7p\2\2|}\7k\2\2}~\7v\2\2~\177\7k\2\2\177\u0080\7c\2"+
		"\2\u0080\u0081\7n\2\2\u0081\u0082\7\"\2\2\u0082\u0083\7I\2\2\u0083\u0084"+
		"\7q\2\2\u0084\u0085\7c\2\2\u0085\u0086\7n\2\2\u0086\u0087\7<\2\2\u0087"+
		"\n\3\2\2\2\u0088\u0089\7<\2\2\u0089\u008a\7p\2\2\u008a\u008b\7c\2\2\u008b"+
		"\u008c\7o\2\2\u008c\u008d\7g\2\2\u008d\u008e\7<\2\2\u008e\f\3\2\2\2\u008f"+
		"\u0093\6\7\3\2\u0090\u0094\7D\2\2\u0091\u0092\7\60\2\2\u0092\u0094\7D"+
		"\2\2\u0093\u0090\3\2\2\2\u0093\u0091\3\2\2\2\u0094\16\3\2\2\2\u0095\u0096"+
		"\7<\2\2\u0096\u0097\7/\2\2\u0097\20\3\2\2\2\u0098\u0099\7<\2\2\u0099\u009a"+
		"\7C\2\2\u009a\u009b\7e\2\2\u009b\u009c\7v\2\2\u009c\u009d\7k\2\2\u009d"+
		"\u009e\7q\2\2\u009e\u009f\7p\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7<\2\2"+
		"\u00a1\22\3\2\2\2\u00a2\u00a3\7\61\2\2\u00a3\u00a4\7,\2\2\u00a4\u00a8"+
		"\3\2\2\2\u00a5\u00a7\13\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2"+
		"\u00a8\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00ab\u00ac\7,\2\2\u00ac\u00ad\7\61\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00af\b\n\4\2\u00af\24\3\2\2\2\u00b0\u00b1\7\61\2\2\u00b1\u00b2\7\61"+
		"\2\2\u00b2\u00b6\3\2\2\2\u00b3\u00b5\n\2\2\2\u00b4\u00b3\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\b\13\4\2\u00ba\26\3\2\2\2\u00bb\u00bd"+
		"\7\17\2\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2"+
		"\u00be\u00bf\7\f\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\b\f\4\2\u00c1\30"+
		"\3\2\2\2\u00c2\u00c4\t\3\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b\r"+
		"\4\2\u00c8\32\3\2\2\2\u00c9\u00ca\7*\2\2\u00ca\34\3\2\2\2\u00cb\u00cc"+
		"\7+\2\2\u00cc\36\3\2\2\2\u00cd\u00ce\7]\2\2\u00ce \3\2\2\2\u00cf\u00d0"+
		"\7_\2\2\u00d0\"\3\2\2\2\u00d1\u00d2\7}\2\2\u00d2$\3\2\2\2\u00d3\u00d4"+
		"\7\177\2\2\u00d4&\3\2\2\2\u00d5\u00d9\7$\2\2\u00d6\u00d8\13\2\2\2\u00d7"+
		"\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00da\3\2\2\2\u00d9\u00d7\3\2"+
		"\2\2\u00da\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\7$\2\2\u00dd"+
		"(\3\2\2\2\u00de\u00df\7\u0080\2\2\u00df*\3\2\2\2\u00e0\u00e1\7V\2\2\u00e1"+
		"\u00e2\7t\2\2\u00e2\u00e3\7w\2\2\u00e3\u00e4\7g\2\2\u00e4,\3\2\2\2\u00e5"+
		"\u00e9\4c|\2\u00e6\u00e8\t\4\2\2\u00e7\u00e6\3\2\2\2\u00e8\u00eb\3\2\2"+
		"\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea.\3\2\2\2\u00eb\u00e9"+
		"\3\2\2\2\u00ec\u00f0\4C\\\2\u00ed\u00ef\t\4\2\2\u00ee\u00ed\3\2\2\2\u00ef"+
		"\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\60\3\2\2"+
		"\2\u00f2\u00f0\3\2\2\2\u00f3\u00f7\4\62;\2\u00f4\u00f6\4\62;\2\u00f5\u00f4"+
		"\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\62\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\7>\2\2\u00fb\64\3\2\2\2\u00fc"+
		"\u00fd\7?\2\2\u00fd\u00fe\7?\2\2\u00fe\66\3\2\2\2\u00ff\u0100\7\60\2\2"+
		"\u01008\3\2\2\2\u0101\u0102\7,\2\2\u0102:\3\2\2\2\u0103\u0104\7-\2\2\u0104"+
		"<\3\2\2\2\u0105\u0106\7/\2\2\u0106>\3\2\2\2\u0107\u0108\7\61\2\2\u0108"+
		"@\3\2\2\2\u0109\u010a\7\'\2\2\u010aB\3\2\2\2\u010b\u010c\7#\2\2\u010c"+
		"D\3\2\2\2\u010d\u010e\7.\2\2\u010eF\3\2\2\2\u010f\u0110\7=\2\2\u0110H"+
		"\3\2\2\2\u0111\u0112\7<\2\2\u0112J\3\2\2\2\u0113\u0114\7A\2\2\u0114L\3"+
		"\2\2\2\f\2\u0093\u00a8\u00b6\u00bc\u00c5\u00d9\u00e9\u00f0\u00f7\5\3\2"+
		"\2\3\4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}