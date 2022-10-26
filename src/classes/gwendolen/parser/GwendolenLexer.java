// Generated from /Users/louisedennis/eclipse-workspace/mcapl/src/classes/gwendolen/parser/antlr/GwendolenLexer.g4 by ANTLR 4.7
package gwendolen.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GwendolenLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GWENDOLEN=1, NAME=2, CONST=3, COMMENT=4, LINE_COMMENT=5, NEWLINE=6, WS=7, 
		BELIEFS=8, BELIEFRULES=9, GOAL_IB=10, IB_COMMENT=11, IB_LINE_COMMENT=12, 
		IB_NEWLINE=13, IB_WS=14, BELIEF_BLOCK=15, GOAL_RR=16, RR_COMMENT=17, RR_LINE_COMMENT=18, 
		RR_NEWLINE=19, RR_WS=20, RR_BLOCK=21, PLANS=22, GL_COMMENT=23, GL_LINE_COMMENT=24, 
		GL_NEWLINE=25, GL_WS=26, GL_ACHIEVEGOAL=27, GL_PERFORMGOAL=28, GL_SQOPEN=29, 
		GL_SQCLOSE=30, GOAL_BLOCK=31, PL_COMMENT=32, PL_LINE_COMMENT=33, PL_NEWLINE=34, 
		PL_WS=35, RECEIVED=36, BELIEVE=37, GOAL=38, LOCK=39, PL_ACHIEVEGOAL=40, 
		PL_PERFORMGOAL=41, PL_SQOPEN=42, PL_SQCLOSE=43, NOT=44, COLON=45, CURLYOPEN=46, 
		CURLYCLOSE=47, COMMA=48, SEMI=49, TELL=50, SHRIEK=51, OPEN=52, CLOSE=53, 
		MULT=54, PLUS=55, MINUS=56, LESS=57, EQUAL=58, IDPUNCT=59, RULEARROW=60, 
		TRUE=61, PL_CONST=62, PL_VAR=63, NUMBER=64, QUOTED_STRING=65;
	public static final int
		INITIAL_BELIEFS=1, REASONING_RULES=2, GOALS=3, PLANS_MODE=4;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "INITIAL_BELIEFS", "REASONING_RULES", "GOALS", "PLANS_MODE"
	};

	public static final String[] ruleNames = {
		"GWENDOLEN", "NAME", "CONST", "COMMENT", "LINE_COMMENT", "NEWLINE", "WS", 
		"BELIEFS", "BELIEFRULES", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", 
		"IB_NEWLINE", "IB_WS", "BELIEF_BLOCK", "GOAL_RR", "RR_COMMENT", "RR_LINE_COMMENT", 
		"RR_NEWLINE", "RR_WS", "RR_BLOCK", "PLANS", "GL_COMMENT", "GL_LINE_COMMENT", 
		"GL_NEWLINE", "GL_WS", "GL_ACHIEVEGOAL", "GL_PERFORMGOAL", "GL_SQOPEN", 
		"GL_SQCLOSE", "GOAL_BLOCK", "PL_COMMENT", "PL_LINE_COMMENT", "PL_NEWLINE", 
		"PL_WS", "RECEIVED", "BELIEVE", "GOAL", "LOCK", "PL_ACHIEVEGOAL", "PL_PERFORMGOAL", 
		"PL_SQOPEN", "PL_SQCLOSE", "NOT", "COLON", "CURLYOPEN", "CURLYCLOSE", 
		"COMMA", "SEMI", "TELL", "SHRIEK", "OPEN", "CLOSE", "MULT", "PLUS", "MINUS", 
		"LESS", "EQUAL", "IDPUNCT", "RULEARROW", "TRUE", "PL_CONST", "PL_VAR", 
		"NUMBER", "QUOTED_STRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'GWENDOLEN'", "':name:'", null, null, null, null, null, "':Initial Beliefs:'", 
		"':Reasoning Rules:'", null, null, null, null, null, null, null, null, 
		null, null, null, null, "':Plans:'", null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "'.received'", null, null, "'.lock'", 
		"'achieve'", "'perform'", null, null, null, "':'", "'{'", "'}'", "','", 
		"';'", "':tell'", "'!'", "'('", "')'", "'*'", "'+'", "'-'", "'<'", "'=='", 
		"'.'", "'<-'", "'True'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "GWENDOLEN", "NAME", "CONST", "COMMENT", "LINE_COMMENT", "NEWLINE", 
		"WS", "BELIEFS", "BELIEFRULES", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", 
		"IB_NEWLINE", "IB_WS", "BELIEF_BLOCK", "GOAL_RR", "RR_COMMENT", "RR_LINE_COMMENT", 
		"RR_NEWLINE", "RR_WS", "RR_BLOCK", "PLANS", "GL_COMMENT", "GL_LINE_COMMENT", 
		"GL_NEWLINE", "GL_WS", "GL_ACHIEVEGOAL", "GL_PERFORMGOAL", "GL_SQOPEN", 
		"GL_SQCLOSE", "GOAL_BLOCK", "PL_COMMENT", "PL_LINE_COMMENT", "PL_NEWLINE", 
		"PL_WS", "RECEIVED", "BELIEVE", "GOAL", "LOCK", "PL_ACHIEVEGOAL", "PL_PERFORMGOAL", 
		"PL_SQOPEN", "PL_SQCLOSE", "NOT", "COLON", "CURLYOPEN", "CURLYCLOSE", 
		"COMMA", "SEMI", "TELL", "SHRIEK", "OPEN", "CLOSE", "MULT", "PLUS", "MINUS", 
		"LESS", "EQUAL", "IDPUNCT", "RULEARROW", "TRUE", "PL_CONST", "PL_VAR", 
		"NUMBER", "QUOTED_STRING"
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


	    public int plain_nesting = 0;
	    public int sq_nesting = 0;
	    public int curly_nesting = 0;
	   // public boolean stringterm = false;
	   //public boolean gwendolen = true;
	   // public int belief_rules = 0;


	public GwendolenLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GwendolenLexer.g4"; }

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
		case 28:
			GL_SQOPEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 29:
			GL_SQCLOSE_action((RuleContext)_localctx, actionIndex);
			break;
		case 45:
			CURLYOPEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 46:
			CURLYCLOSE_action((RuleContext)_localctx, actionIndex);
			break;
		case 51:
			OPEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 52:
			CLOSE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void GL_SQOPEN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			sq_nesting++;
			break;
		}
	}
	private void GL_SQCLOSE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			sq_nesting--;
			break;
		}
	}
	private void CURLYOPEN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			curly_nesting++;
			break;
		}
	}
	private void CURLYCLOSE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			curly_nesting--;
			break;
		}
	}
	private void OPEN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			plain_nesting++;
			break;
		}
	}
	private void CLOSE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			plain_nesting--;
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 26:
			return GL_ACHIEVEGOAL_sempred((RuleContext)_localctx, predIndex);
		case 27:
			return GL_PERFORMGOAL_sempred((RuleContext)_localctx, predIndex);
		case 36:
			return BELIEVE_sempred((RuleContext)_localctx, predIndex);
		case 37:
			return GOAL_sempred((RuleContext)_localctx, predIndex);
		case 43:
			return NOT_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean GL_ACHIEVEGOAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return sq_nesting > 0;
		}
		return true;
	}
	private boolean GL_PERFORMGOAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return sq_nesting > 0;
		}
		return true;
	}
	private boolean BELIEVE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return curly_nesting > 0;
		}
		return true;
	}
	private boolean GOAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return curly_nesting > 0;
		}
		return true;
	}
	private boolean NOT_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return curly_nesting > 0;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2C\u0257\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)"+
		"\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\6\4\u009c\n\4\r\4\16"+
		"\4\u009d\3\5\3\5\3\5\3\5\7\5\u00a4\n\5\f\5\16\5\u00a7\13\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\7\6\u00b2\n\6\f\6\16\6\u00b5\13\6\3\6\3\6\3\7"+
		"\5\7\u00ba\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u0102\n\f\f\f\16\f\u0105\13\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u0110\n\r\f\r\16\r\u0113\13\r\3\r"+
		"\3\r\3\16\5\16\u0118\n\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20"+
		"\6\20\u0123\n\20\r\20\16\20\u0124\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\7\22\u013d\n\22\f\22\16\22\u0140\13\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\7\23\u014b\n\23\f\23\16\23\u014e\13\23\3\23\3\23\3"+
		"\24\5\24\u0153\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\6\26\u015f\n\26\r\26\16\26\u0160\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u0171\n\30\f\30\16\30\u0174\13"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u017f\n\31\f\31"+
		"\16\31\u0182\13\31\3\31\3\31\3\32\5\32\u0187\n\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3 \6 \u01aa\n \r \16 \u01ab\3!\3!\3!\3!\7!\u01b2\n!\f!\16!\u01b5\13!"+
		"\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\7\"\u01c0\n\"\f\"\16\"\u01c3\13\"\3\""+
		"\3\"\3#\5#\u01c8\n#\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3&\3&\3&\3&\5&\u01e0\n&\3\'\3\'\3\'\3\'\5\'\u01e6\n\'\3(\3(\3(\3"+
		"(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3,\3,\3"+
		"-\3-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3"+
		"8\38\39\39\3:\3:\3;\3;\3;\3<\3<\3=\3=\3=\3>\3>\3>\3>\3>\3?\3?\6?\u0236"+
		"\n?\r?\16?\u0237\3@\3@\7@\u023c\n@\f@\16@\u023f\13@\3A\6A\u0242\nA\rA"+
		"\16A\u0243\3B\3B\7B\u0248\nB\fB\16B\u024b\13B\3B\3B\3B\7B\u0250\nB\fB"+
		"\16B\u0253\13B\3B\5B\u0256\nB\t\u00a5\u0103\u013e\u0172\u01b3\u0249\u0251"+
		"\2C\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!"+
		"\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?"+
		"\37A C!E\"G#I$K%M&O\'Q(S)U*W+Y,[-]._/a\60c\61e\62g\63i\64k\65m\66o\67"+
		"q8s9u:w;y<{=}>\177?\u0081@\u0083A\u0085B\u0087C\7\2\3\4\5\6\b\6\2\62;"+
		"C\\aac|\3\2\f\f\4\2\13\13\"\"\n\2\"\"*+..\60\60\62;C\\aac|\b\2*+..\62"+
		";C\\aac|\4\2\"\"==\2\u026f\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2"+
		"\2\3\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2\2\2\3\37\3\2\2\2\3!\3\2\2\2\3#\3"+
		"\2\2\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3\2\2\2\4+\3\2\2\2\4-\3\2\2\2\4/\3\2"+
		"\2\2\5\61\3\2\2\2\5\63\3\2\2\2\5\65\3\2\2\2\5\67\3\2\2\2\59\3\2\2\2\5"+
		";\3\2\2\2\5=\3\2\2\2\5?\3\2\2\2\5A\3\2\2\2\5C\3\2\2\2\6E\3\2\2\2\6G\3"+
		"\2\2\2\6I\3\2\2\2\6K\3\2\2\2\6M\3\2\2\2\6O\3\2\2\2\6Q\3\2\2\2\6S\3\2\2"+
		"\2\6U\3\2\2\2\6W\3\2\2\2\6Y\3\2\2\2\6[\3\2\2\2\6]\3\2\2\2\6_\3\2\2\2\6"+
		"a\3\2\2\2\6c\3\2\2\2\6e\3\2\2\2\6g\3\2\2\2\6i\3\2\2\2\6k\3\2\2\2\6m\3"+
		"\2\2\2\6o\3\2\2\2\6q\3\2\2\2\6s\3\2\2\2\6u\3\2\2\2\6w\3\2\2\2\6y\3\2\2"+
		"\2\6{\3\2\2\2\6}\3\2\2\2\6\177\3\2\2\2\6\u0081\3\2\2\2\6\u0083\3\2\2\2"+
		"\6\u0085\3\2\2\2\6\u0087\3\2\2\2\7\u0089\3\2\2\2\t\u0093\3\2\2\2\13\u009b"+
		"\3\2\2\2\r\u009f\3\2\2\2\17\u00ad\3\2\2\2\21\u00b9\3\2\2\2\23\u00bf\3"+
		"\2\2\2\25\u00c3\3\2\2\2\27\u00d7\3\2\2\2\31\u00eb\3\2\2\2\33\u00fd\3\2"+
		"\2\2\35\u010b\3\2\2\2\37\u0117\3\2\2\2!\u011d\3\2\2\2#\u0122\3\2\2\2%"+
		"\u0126\3\2\2\2\'\u0138\3\2\2\2)\u0146\3\2\2\2+\u0152\3\2\2\2-\u0156\3"+
		"\2\2\2/\u015e\3\2\2\2\61\u0162\3\2\2\2\63\u016c\3\2\2\2\65\u017a\3\2\2"+
		"\2\67\u0186\3\2\2\29\u018c\3\2\2\2;\u0190\3\2\2\2=\u0199\3\2\2\2?\u01a2"+
		"\3\2\2\2A\u01a5\3\2\2\2C\u01a9\3\2\2\2E\u01ad\3\2\2\2G\u01bb\3\2\2\2I"+
		"\u01c7\3\2\2\2K\u01cd\3\2\2\2M\u01d1\3\2\2\2O\u01db\3\2\2\2Q\u01e1\3\2"+
		"\2\2S\u01e7\3\2\2\2U\u01ed\3\2\2\2W\u01f5\3\2\2\2Y\u01fd\3\2\2\2[\u01ff"+
		"\3\2\2\2]\u0201\3\2\2\2_\u0204\3\2\2\2a\u0206\3\2\2\2c\u0209\3\2\2\2e"+
		"\u020c\3\2\2\2g\u020e\3\2\2\2i\u0210\3\2\2\2k\u0216\3\2\2\2m\u0218\3\2"+
		"\2\2o\u021b\3\2\2\2q\u021e\3\2\2\2s\u0220\3\2\2\2u\u0222\3\2\2\2w\u0224"+
		"\3\2\2\2y\u0226\3\2\2\2{\u0229\3\2\2\2}\u022b\3\2\2\2\177\u022e\3\2\2"+
		"\2\u0081\u0233\3\2\2\2\u0083\u0239\3\2\2\2\u0085\u0241\3\2\2\2\u0087\u0255"+
		"\3\2\2\2\u0089\u008a\7I\2\2\u008a\u008b\7Y\2\2\u008b\u008c\7G\2\2\u008c"+
		"\u008d\7P\2\2\u008d\u008e\7F\2\2\u008e\u008f\7Q\2\2\u008f\u0090\7N\2\2"+
		"\u0090\u0091\7G\2\2\u0091\u0092\7P\2\2\u0092\b\3\2\2\2\u0093\u0094\7<"+
		"\2\2\u0094\u0095\7p\2\2\u0095\u0096\7c\2\2\u0096\u0097\7o\2\2\u0097\u0098"+
		"\7g\2\2\u0098\u0099\7<\2\2\u0099\n\3\2\2\2\u009a\u009c\t\2\2\2\u009b\u009a"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\f\3\2\2\2\u009f\u00a0\7\61\2\2\u00a0\u00a1\7,\2\2\u00a1\u00a5\3\2\2\2"+
		"\u00a2\u00a4\13\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8"+
		"\u00a9\7,\2\2\u00a9\u00aa\7\61\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\b\5"+
		"\2\2\u00ac\16\3\2\2\2\u00ad\u00ae\7\61\2\2\u00ae\u00af\7\61\2\2\u00af"+
		"\u00b3\3\2\2\2\u00b0\u00b2\n\3\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2"+
		"\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b6\u00b7\b\6\2\2\u00b7\20\3\2\2\2\u00b8\u00ba\7\17\2"+
		"\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc"+
		"\7\f\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\b\7\2\2\u00be\22\3\2\2\2\u00bf"+
		"\u00c0\t\4\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\b\b\2\2\u00c2\24\3\2\2"+
		"\2\u00c3\u00c4\7<\2\2\u00c4\u00c5\7K\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7"+
		"\7k\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7c\2\2\u00ca"+
		"\u00cb\7n\2\2\u00cb\u00cc\7\"\2\2\u00cc\u00cd\7D\2\2\u00cd\u00ce\7g\2"+
		"\2\u00ce\u00cf\7n\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2"+
		"\7h\2\2\u00d2\u00d3\7u\2\2\u00d3\u00d4\7<\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d6\b\t\3\2\u00d6\26\3\2\2\2\u00d7\u00d8\7<\2\2\u00d8\u00d9\7T\2\2"+
		"\u00d9\u00da\7g\2\2\u00da\u00db\7c\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd"+
		"\7q\2\2\u00dd\u00de\7p\2\2\u00de\u00df\7k\2\2\u00df\u00e0\7p\2\2\u00e0"+
		"\u00e1\7i\2\2\u00e1\u00e2\7\"\2\2\u00e2\u00e3\7T\2\2\u00e3\u00e4\7w\2"+
		"\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7u\2\2\u00e7\u00e8"+
		"\7<\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\b\n\4\2\u00ea\30\3\2\2\2\u00eb"+
		"\u00ec\7<\2\2\u00ec\u00ed\7K\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef\7k\2\2"+
		"\u00ef\u00f0\7v\2\2\u00f0\u00f1\7k\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3"+
		"\7n\2\2\u00f3\u00f4\7\"\2\2\u00f4\u00f5\7I\2\2\u00f5\u00f6\7q\2\2\u00f6"+
		"\u00f7\7c\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9\7u\2\2\u00f9\u00fa\7<\2\2"+
		"\u00fa\u00fb\3\2\2\2\u00fb\u00fc\b\13\5\2\u00fc\32\3\2\2\2\u00fd\u00fe"+
		"\7\61\2\2\u00fe\u00ff\7,\2\2\u00ff\u0103\3\2\2\2\u0100\u0102\13\2\2\2"+
		"\u0101\u0100\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0104\3\2\2\2\u0103\u0101"+
		"\3\2\2\2\u0104\u0106\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\7,\2\2\u0107"+
		"\u0108\7\61\2\2\u0108\u0109\3\2\2\2\u0109\u010a\b\f\2\2\u010a\34\3\2\2"+
		"\2\u010b\u010c\7\61\2\2\u010c\u010d\7\61\2\2\u010d\u0111\3\2\2\2\u010e"+
		"\u0110\n\3\2\2\u010f\u010e\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2"+
		"\2\2\u0111\u0112\3\2\2\2\u0112\u0114\3\2\2\2\u0113\u0111\3\2\2\2\u0114"+
		"\u0115\b\r\2\2\u0115\36\3\2\2\2\u0116\u0118\7\17\2\2\u0117\u0116\3\2\2"+
		"\2\u0117\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\7\f\2\2\u011a\u011b"+
		"\3\2\2\2\u011b\u011c\b\16\2\2\u011c \3\2\2\2\u011d\u011e\t\4\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0120\b\17\2\2\u0120\"\3\2\2\2\u0121\u0123\t\5\2"+
		"\2\u0122\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125"+
		"\3\2\2\2\u0125$\3\2\2\2\u0126\u0127\7<\2\2\u0127\u0128\7K\2\2\u0128\u0129"+
		"\7p\2\2\u0129\u012a\7k\2\2\u012a\u012b\7v\2\2\u012b\u012c\7k\2\2\u012c"+
		"\u012d\7c\2\2\u012d\u012e\7n\2\2\u012e\u012f\7\"\2\2\u012f\u0130\7I\2"+
		"\2\u0130\u0131\7q\2\2\u0131\u0132\7c\2\2\u0132\u0133\7n\2\2\u0133\u0134"+
		"\7u\2\2\u0134\u0135\7<\2\2\u0135\u0136\3\2\2\2\u0136\u0137\b\21\5\2\u0137"+
		"&\3\2\2\2\u0138\u0139\7\61\2\2\u0139\u013a\7,\2\2\u013a\u013e\3\2\2\2"+
		"\u013b\u013d\13\2\2\2\u013c\u013b\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013f"+
		"\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0141\3\2\2\2\u0140\u013e\3\2\2\2\u0141"+
		"\u0142\7,\2\2\u0142\u0143\7\61\2\2\u0143\u0144\3\2\2\2\u0144\u0145\b\22"+
		"\2\2\u0145(\3\2\2\2\u0146\u0147\7\61\2\2\u0147\u0148\7\61\2\2\u0148\u014c"+
		"\3\2\2\2\u0149\u014b\n\3\2\2\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c"+
		"\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2"+
		"\2\2\u014f\u0150\b\23\2\2\u0150*\3\2\2\2\u0151\u0153\7\17\2\2\u0152\u0151"+
		"\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\7\f\2\2\u0155"+
		",\3\2\2\2\u0156\u0157\t\4\2\2\u0157\u0158\3\2\2\2\u0158\u0159\b\25\2\2"+
		"\u0159.\3\2\2\2\u015a\u015f\t\6\2\2\u015b\u015c\7<\2\2\u015c\u015f\7/"+
		"\2\2\u015d\u015f\t\7\2\2\u015e\u015a\3\2\2\2\u015e\u015b\3\2\2\2\u015e"+
		"\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2"+
		"\2\2\u0161\60\3\2\2\2\u0162\u0163\7<\2\2\u0163\u0164\7R\2\2\u0164\u0165"+
		"\7n\2\2\u0165\u0166\7c\2\2\u0166\u0167\7p\2\2\u0167\u0168\7u\2\2\u0168"+
		"\u0169\7<\2\2\u0169\u016a\3\2\2\2\u016a\u016b\b\27\6\2\u016b\62\3\2\2"+
		"\2\u016c\u016d\7\61\2\2\u016d\u016e\7,\2\2\u016e\u0172\3\2\2\2\u016f\u0171"+
		"\13\2\2\2\u0170\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0173\3\2\2\2"+
		"\u0172\u0170\3\2\2\2\u0173\u0175\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0176"+
		"\7,\2\2\u0176\u0177\7\61\2\2\u0177\u0178\3\2\2\2\u0178\u0179\b\30\2\2"+
		"\u0179\64\3\2\2\2\u017a\u017b\7\61\2\2\u017b\u017c\7\61\2\2\u017c\u0180"+
		"\3\2\2\2\u017d\u017f\n\3\2\2\u017e\u017d\3\2\2\2\u017f\u0182\3\2\2\2\u0180"+
		"\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u0180\3\2"+
		"\2\2\u0183\u0184\b\31\2\2\u0184\66\3\2\2\2\u0185\u0187\7\17\2\2\u0186"+
		"\u0185\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\7\f"+
		"\2\2\u0189\u018a\3\2\2\2\u018a\u018b\b\32\2\2\u018b8\3\2\2\2\u018c\u018d"+
		"\t\4\2\2\u018d\u018e\3\2\2\2\u018e\u018f\b\33\2\2\u018f:\3\2\2\2\u0190"+
		"\u0191\6\34\2\2\u0191\u0192\7c\2\2\u0192\u0193\7e\2\2\u0193\u0194\7j\2"+
		"\2\u0194\u0195\7k\2\2\u0195\u0196\7g\2\2\u0196\u0197\7x\2\2\u0197\u0198"+
		"\7g\2\2\u0198<\3\2\2\2\u0199\u019a\6\35\3\2\u019a\u019b\7r\2\2\u019b\u019c"+
		"\7g\2\2\u019c\u019d\7t\2\2\u019d\u019e\7h\2\2\u019e\u019f\7q\2\2\u019f"+
		"\u01a0\7t\2\2\u01a0\u01a1\7o\2\2\u01a1>\3\2\2\2\u01a2\u01a3\7]\2\2\u01a3"+
		"\u01a4\b\36\7\2\u01a4@\3\2\2\2\u01a5\u01a6\7_\2\2\u01a6\u01a7\b\37\b\2"+
		"\u01a7B\3\2\2\2\u01a8\u01aa\t\5\2\2\u01a9\u01a8\3\2\2\2\u01aa\u01ab\3"+
		"\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01acD\3\2\2\2\u01ad\u01ae"+
		"\7\61\2\2\u01ae\u01af\7,\2\2\u01af\u01b3\3\2\2\2\u01b0\u01b2\13\2\2\2"+
		"\u01b1\u01b0\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b3\u01b1"+
		"\3\2\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b7\7,\2\2\u01b7"+
		"\u01b8\7\61\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\b!\2\2\u01baF\3\2\2\2"+
		"\u01bb\u01bc\7\61\2\2\u01bc\u01bd\7\61\2\2\u01bd\u01c1\3\2\2\2\u01be\u01c0"+
		"\n\3\2\2\u01bf\u01be\3\2\2\2\u01c0\u01c3\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1"+
		"\u01c2\3\2\2\2\u01c2\u01c4\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4\u01c5\b\""+
		"\2\2\u01c5H\3\2\2\2\u01c6\u01c8\7\17\2\2\u01c7\u01c6\3\2\2\2\u01c7\u01c8"+
		"\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\7\f\2\2\u01ca\u01cb\3\2\2\2\u01cb"+
		"\u01cc\b#\2\2\u01ccJ\3\2\2\2\u01cd\u01ce\t\4\2\2\u01ce\u01cf\3\2\2\2\u01cf"+
		"\u01d0\b$\2\2\u01d0L\3\2\2\2\u01d1\u01d2\7\60\2\2\u01d2\u01d3\7t\2\2\u01d3"+
		"\u01d4\7g\2\2\u01d4\u01d5\7e\2\2\u01d5\u01d6\7g\2\2\u01d6\u01d7\7k\2\2"+
		"\u01d7\u01d8\7x\2\2\u01d8\u01d9\7g\2\2\u01d9\u01da\7f\2\2\u01daN\3\2\2"+
		"\2\u01db\u01df\6&\4\2\u01dc\u01e0\7D\2\2\u01dd\u01de\7\60\2\2\u01de\u01e0"+
		"\7D\2\2\u01df\u01dc\3\2\2\2\u01df\u01dd\3\2\2\2\u01e0P\3\2\2\2\u01e1\u01e5"+
		"\6\'\5\2\u01e2\u01e6\7I\2\2\u01e3\u01e4\7\60\2\2\u01e4\u01e6\7I\2\2\u01e5"+
		"\u01e2\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6R\3\2\2\2\u01e7\u01e8\7\60\2\2"+
		"\u01e8\u01e9\7n\2\2\u01e9\u01ea\7q\2\2\u01ea\u01eb\7e\2\2\u01eb\u01ec"+
		"\7m\2\2\u01ecT\3\2\2\2\u01ed\u01ee\7c\2\2\u01ee\u01ef\7e\2\2\u01ef\u01f0"+
		"\7j\2\2\u01f0\u01f1\7k\2\2\u01f1\u01f2\7g\2\2\u01f2\u01f3\7x\2\2\u01f3"+
		"\u01f4\7g\2\2\u01f4V\3\2\2\2\u01f5\u01f6\7r\2\2\u01f6\u01f7\7g\2\2\u01f7"+
		"\u01f8\7t\2\2\u01f8\u01f9\7h\2\2\u01f9\u01fa\7q\2\2\u01fa\u01fb\7t\2\2"+
		"\u01fb\u01fc\7o\2\2\u01fcX\3\2\2\2\u01fd\u01fe\7]\2\2\u01feZ\3\2\2\2\u01ff"+
		"\u0200\7_\2\2\u0200\\\3\2\2\2\u0201\u0202\6-\6\2\u0202\u0203\7\u0080\2"+
		"\2\u0203^\3\2\2\2\u0204\u0205\7<\2\2\u0205`\3\2\2\2\u0206\u0207\7}\2\2"+
		"\u0207\u0208\b/\t\2\u0208b\3\2\2\2\u0209\u020a\7\177\2\2\u020a\u020b\b"+
		"\60\n\2\u020bd\3\2\2\2\u020c\u020d\7.\2\2\u020df\3\2\2\2\u020e\u020f\7"+
		"=\2\2\u020fh\3\2\2\2\u0210\u0211\7<\2\2\u0211\u0212\7v\2\2\u0212\u0213"+
		"\7g\2\2\u0213\u0214\7n\2\2\u0214\u0215\7n\2\2\u0215j\3\2\2\2\u0216\u0217"+
		"\7#\2\2\u0217l\3\2\2\2\u0218\u0219\7*\2\2\u0219\u021a\b\65\13\2\u021a"+
		"n\3\2\2\2\u021b\u021c\7+\2\2\u021c\u021d\b\66\f\2\u021dp\3\2\2\2\u021e"+
		"\u021f\7,\2\2\u021fr\3\2\2\2\u0220\u0221\7-\2\2\u0221t\3\2\2\2\u0222\u0223"+
		"\7/\2\2\u0223v\3\2\2\2\u0224\u0225\7>\2\2\u0225x\3\2\2\2\u0226\u0227\7"+
		"?\2\2\u0227\u0228\7?\2\2\u0228z\3\2\2\2\u0229\u022a\7\60\2\2\u022a|\3"+
		"\2\2\2\u022b\u022c\7>\2\2\u022c\u022d\7/\2\2\u022d~\3\2\2\2\u022e\u022f"+
		"\7V\2\2\u022f\u0230\7t\2\2\u0230\u0231\7w\2\2\u0231\u0232\7g\2\2\u0232"+
		"\u0080\3\2\2\2\u0233\u0235\4c|\2\u0234\u0236\t\2\2\2\u0235\u0234\3\2\2"+
		"\2\u0236\u0237\3\2\2\2\u0237\u0235\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u0082"+
		"\3\2\2\2\u0239\u023d\4C\\\2\u023a\u023c\t\2\2\2\u023b\u023a\3\2\2\2\u023c"+
		"\u023f\3\2\2\2\u023d\u023b\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0084\3\2"+
		"\2\2\u023f\u023d\3\2\2\2\u0240\u0242\4\62;\2\u0241\u0240\3\2\2\2\u0242"+
		"\u0243\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0086\3\2"+
		"\2\2\u0245\u0249\7$\2\2\u0246\u0248\13\2\2\2\u0247\u0246\3\2\2\2\u0248"+
		"\u024b\3\2\2\2\u0249\u024a\3\2\2\2\u0249\u0247\3\2\2\2\u024a\u024c\3\2"+
		"\2\2\u024b\u0249\3\2\2\2\u024c\u0256\7$\2\2\u024d\u0251\7)\2\2\u024e\u0250"+
		"\13\2\2\2\u024f\u024e\3\2\2\2\u0250\u0253\3\2\2\2\u0251\u0252\3\2\2\2"+
		"\u0251\u024f\3\2\2\2\u0252\u0254\3\2\2\2\u0253\u0251\3\2\2\2\u0254\u0256"+
		"\7)\2\2\u0255\u0245\3\2\2\2\u0255\u024d\3\2\2\2\u0256\u0088\3\2\2\2#\2"+
		"\3\4\5\6\u009d\u00a5\u00b3\u00b9\u0103\u0111\u0117\u0124\u013e\u014c\u0152"+
		"\u015e\u0160\u0172\u0180\u0186\u01ab\u01b3\u01c1\u01c7\u01df\u01e5\u0237"+
		"\u023d\u0243\u0249\u0251\u0255\r\b\2\2\4\3\2\4\4\2\4\5\2\4\6\2\3\36\2"+
		"\3\37\3\3/\4\3\60\5\3\65\6\3\66\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}