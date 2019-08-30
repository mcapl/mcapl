// Generated from ..\..\src\classes\gwendolen\parser\GwendolenSub.g by ANTLR 4.7

package gwendolen.parser;

import ail.syntax.ast.*;
import gwendolen.syntax.ast.*;
import java.util.HashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GwendolenSubLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LINE_COMMENT=2, NEWLINE=3, WS=4, TRUE=5, OPEN=6, CLOSE=7, SQOPEN=8, 
		SQCLOSE=9, CURLYOPEN=10, CURLYCLOSE=11, DOUBLEQUOTE=12, NOT=13, STRING=14, 
		CONST=15, VAR=16, NUMBER=17, UNNAMEDVAR=18, LESS=19, EQ=20, POINT=21, 
		MULT=22, PLUS=23, MINUS=24, DIV=25, MOD=26, SHRIEK=27, COMMA=28, SEMI=29, 
		COLON=30, QUERY=31, BAR=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "TRUE", "OPEN", "CLOSE", "SQOPEN", 
		"SQCLOSE", "CURLYOPEN", "CURLYCLOSE", "DOUBLEQUOTE", "NOT", "STRING", 
		"CONST", "VAR", "NUMBER", "UNNAMEDVAR", "LESS", "EQ", "POINT", "MULT", 
		"PLUS", "MINUS", "DIV", "MOD", "SHRIEK", "COMMA", "SEMI", "COLON", "QUERY", 
		"BAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'True'", "'('", "')'", "'['", "']'", "'{'", 
		"'}'", "'\"'", "'~'", null, null, null, null, null, "'<'", "'=='", null, 
		"'*'", "'+'", "'-'", "'/'", "'%'", "'!'", "','", "';'", "':'", "'?'", 
		"'|'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "TRUE", "OPEN", "CLOSE", 
		"SQOPEN", "SQCLOSE", "CURLYOPEN", "CURLYCLOSE", "DOUBLEQUOTE", "NOT", 
		"STRING", "CONST", "VAR", "NUMBER", "UNNAMEDVAR", "LESS", "EQ", "POINT", 
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


		private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
	    private boolean stringterm = false;


	public GwendolenSubLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GwendolenSub.g"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 2:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 3:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 11:
			DOUBLEQUOTE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			skip();
			break;
		}
	}
	private void DOUBLEQUOTE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			if (stringterm) {stringterm = false;} else {stringterm = true;}
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return WS_sempred((RuleContext)_localctx, predIndex);
		case 13:
			return STRING_sempred((RuleContext)_localctx, predIndex);
		case 14:
			return CONST_sempred((RuleContext)_localctx, predIndex);
		case 15:
			return VAR_sempred((RuleContext)_localctx, predIndex);
		case 16:
			return NUMBER_sempred((RuleContext)_localctx, predIndex);
		case 17:
			return UNNAMEDVAR_sempred((RuleContext)_localctx, predIndex);
		case 20:
			return POINT_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean WS_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return !stringterm;
		}
		return true;
	}
	private boolean STRING_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return stringterm;
		}
		return true;
	}
	private boolean CONST_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return !stringterm;
		}
		return true;
	}
	private boolean VAR_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return !stringterm;
		}
		return true;
	}
	private boolean NUMBER_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return !stringterm;
		}
		return true;
	}
	private boolean UNNAMEDVAR_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return !stringterm;
		}
		return true;
	}
	private boolean POINT_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return !stringterm;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u00c5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\7\2H\n\2\f\2\16\2K\13\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\7\3V\n\3\f\3\16\3Y\13\3\3\3\5\3\\\n\3\3\3\3\3\3\3\3\3\3\4\5"+
		"\4c\n\4\3\4\3\4\3\4\3\5\3\5\6\5j\n\5\r\5\16\5k\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\7\17\u0088\n\17\f\17\16\17\u008b\13\17\3\20\3\20\3\20"+
		"\7\20\u0090\n\20\f\20\16\20\u0093\13\20\3\21\3\21\3\21\7\21\u0098\n\21"+
		"\f\21\16\21\u009b\13\21\3\22\3\22\3\22\7\22\u00a0\n\22\f\22\16\22\u00a3"+
		"\13\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3I\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"\3\2\6\4\2\f\f\17\17\4\2\13\13\"\""+
		"\5\2\f\f\17\17$$\6\2\62;C\\aac|\2\u00cd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\3C\3\2\2\2\5Q\3\2\2\2\7b\3\2\2\2\tg\3\2\2\2\13o\3\2\2\2\rt\3"+
		"\2\2\2\17v\3\2\2\2\21x\3\2\2\2\23z\3\2\2\2\25|\3\2\2\2\27~\3\2\2\2\31"+
		"\u0080\3\2\2\2\33\u0083\3\2\2\2\35\u0085\3\2\2\2\37\u008c\3\2\2\2!\u0094"+
		"\3\2\2\2#\u009c\3\2\2\2%\u00a4\3\2\2\2\'\u00a7\3\2\2\2)\u00a9\3\2\2\2"+
		"+\u00ac\3\2\2\2-\u00af\3\2\2\2/\u00b1\3\2\2\2\61\u00b3\3\2\2\2\63\u00b5"+
		"\3\2\2\2\65\u00b7\3\2\2\2\67\u00b9\3\2\2\29\u00bb\3\2\2\2;\u00bd\3\2\2"+
		"\2=\u00bf\3\2\2\2?\u00c1\3\2\2\2A\u00c3\3\2\2\2CD\7\61\2\2DE\7,\2\2EI"+
		"\3\2\2\2FH\13\2\2\2GF\3\2\2\2HK\3\2\2\2IJ\3\2\2\2IG\3\2\2\2JL\3\2\2\2"+
		"KI\3\2\2\2LM\7,\2\2MN\7\61\2\2NO\3\2\2\2OP\b\2\2\2P\4\3\2\2\2QR\7\61\2"+
		"\2RS\7\61\2\2SW\3\2\2\2TV\n\2\2\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2"+
		"\2\2X[\3\2\2\2YW\3\2\2\2Z\\\7\17\2\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]"+
		"^\7\f\2\2^_\3\2\2\2_`\b\3\2\2`\6\3\2\2\2ac\7\17\2\2ba\3\2\2\2bc\3\2\2"+
		"\2cd\3\2\2\2de\7\f\2\2ef\b\4\3\2f\b\3\2\2\2gi\6\5\2\2hj\t\3\2\2ih\3\2"+
		"\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\b\5\4\2n\n\3\2\2\2op\7"+
		"V\2\2pq\7t\2\2qr\7w\2\2rs\7g\2\2s\f\3\2\2\2tu\7*\2\2u\16\3\2\2\2vw\7+"+
		"\2\2w\20\3\2\2\2xy\7]\2\2y\22\3\2\2\2z{\7_\2\2{\24\3\2\2\2|}\7}\2\2}\26"+
		"\3\2\2\2~\177\7\177\2\2\177\30\3\2\2\2\u0080\u0081\7$\2\2\u0081\u0082"+
		"\b\r\5\2\u0082\32\3\2\2\2\u0083\u0084\7\u0080\2\2\u0084\34\3\2\2\2\u0085"+
		"\u0089\6\17\3\2\u0086\u0088\n\4\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3"+
		"\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\36\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008c\u008d\6\20\4\2\u008d\u0091\4c|\2\u008e\u0090\t\5"+
		"\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092 \3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\6\21\5\2"+
		"\u0095\u0099\4C\\\2\u0096\u0098\t\5\2\2\u0097\u0096\3\2\2\2\u0098\u009b"+
		"\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\"\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009c\u009d\6\22\6\2\u009d\u00a1\4\62;\2\u009e\u00a0\4"+
		"\62;\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2$\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\6\23\7\2"+
		"\u00a5\u00a6\7a\2\2\u00a6&\3\2\2\2\u00a7\u00a8\7>\2\2\u00a8(\3\2\2\2\u00a9"+
		"\u00aa\7?\2\2\u00aa\u00ab\7?\2\2\u00ab*\3\2\2\2\u00ac\u00ad\6\26\b\2\u00ad"+
		"\u00ae\7\60\2\2\u00ae,\3\2\2\2\u00af\u00b0\7,\2\2\u00b0.\3\2\2\2\u00b1"+
		"\u00b2\7-\2\2\u00b2\60\3\2\2\2\u00b3\u00b4\7/\2\2\u00b4\62\3\2\2\2\u00b5"+
		"\u00b6\7\61\2\2\u00b6\64\3\2\2\2\u00b7\u00b8\7\'\2\2\u00b8\66\3\2\2\2"+
		"\u00b9\u00ba\7#\2\2\u00ba8\3\2\2\2\u00bb\u00bc\7.\2\2\u00bc:\3\2\2\2\u00bd"+
		"\u00be\7=\2\2\u00be<\3\2\2\2\u00bf\u00c0\7<\2\2\u00c0>\3\2\2\2\u00c1\u00c2"+
		"\7A\2\2\u00c2@\3\2\2\2\u00c3\u00c4\7~\2\2\u00c4B\3\2\2\2\f\2IW[bk\u0089"+
		"\u0091\u0099\u00a1\6\2\3\2\3\4\2\3\5\3\3\r\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}