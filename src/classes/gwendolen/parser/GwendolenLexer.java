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
		GL_SQCLOSE=30, GOAL_BLOCK=31, NAME_PM=32, PL_COMMENT=33, PL_LINE_COMMENT=34, 
		PL_NEWLINE=35, PL_WS=36, SEND=37, RECEIVED=38, BELIEVE=39, GOAL=40, SENT=41, 
		LOCK=42, PL_ACHIEVEGOAL=43, PL_PERFORMGOAL=44, PL_SQOPEN=45, PL_SQCLOSE=46, 
		PL_BAR=47, NOT=48, COLON=49, CURLYOPEN=50, CURLYCLOSE=51, COMMA=52, SEMI=53, 
		TELL=54, SHRIEK=55, OPEN=56, CLOSE=57, MULT=58, PLUS=59, MINUS=60, LESS=61, 
		EQUAL=62, IDPUNCT=63, RULEARROW=64, TRUE=65, PL_CONST=66, PL_VAR=67, NUMBER=68, 
		QUOTED_STRING=69;
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
		"GL_SQCLOSE", "GOAL_BLOCK", "NAME_PM", "PL_COMMENT", "PL_LINE_COMMENT", 
		"PL_NEWLINE", "PL_WS", "SEND", "RECEIVED", "BELIEVE", "GOAL", "SENT", 
		"LOCK", "PL_ACHIEVEGOAL", "PL_PERFORMGOAL", "PL_SQOPEN", "PL_SQCLOSE", 
		"PL_BAR", "NOT", "COLON", "CURLYOPEN", "CURLYCLOSE", "COMMA", "SEMI", 
		"TELL", "SHRIEK", "OPEN", "CLOSE", "MULT", "PLUS", "MINUS", "LESS", "EQUAL", 
		"IDPUNCT", "RULEARROW", "TRUE", "PL_CONST", "PL_VAR", "NUMBER", "QUOTED_STRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'GWENDOLEN'", null, null, null, null, null, null, "':Initial Beliefs:'", 
		"':Reasoning Rules:'", null, null, null, null, null, null, null, null, 
		null, null, null, null, "':Plans:'", null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "'.send'", "'.received'", 
		null, null, "'.sent'", "'.lock'", "'achieve'", "'perform'", null, null, 
		"'|'", "'~'", "':'", "'{'", "'}'", "','", "';'", "':tell'", "'!'", "'('", 
		"')'", "'*'", "'+'", "'-'", "'<'", "'=='", "'.'", "'<-'", "'True'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "GWENDOLEN", "NAME", "CONST", "COMMENT", "LINE_COMMENT", "NEWLINE", 
		"WS", "BELIEFS", "BELIEFRULES", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", 
		"IB_NEWLINE", "IB_WS", "BELIEF_BLOCK", "GOAL_RR", "RR_COMMENT", "RR_LINE_COMMENT", 
		"RR_NEWLINE", "RR_WS", "RR_BLOCK", "PLANS", "GL_COMMENT", "GL_LINE_COMMENT", 
		"GL_NEWLINE", "GL_WS", "GL_ACHIEVEGOAL", "GL_PERFORMGOAL", "GL_SQOPEN", 
		"GL_SQCLOSE", "GOAL_BLOCK", "NAME_PM", "PL_COMMENT", "PL_LINE_COMMENT", 
		"PL_NEWLINE", "PL_WS", "SEND", "RECEIVED", "BELIEVE", "GOAL", "SENT", 
		"LOCK", "PL_ACHIEVEGOAL", "PL_PERFORMGOAL", "PL_SQOPEN", "PL_SQCLOSE", 
		"PL_BAR", "NOT", "COLON", "CURLYOPEN", "CURLYCLOSE", "COMMA", "SEMI", 
		"TELL", "SHRIEK", "OPEN", "CLOSE", "MULT", "PLUS", "MINUS", "LESS", "EQUAL", 
		"IDPUNCT", "RULEARROW", "TRUE", "PL_CONST", "PL_VAR", "NUMBER", "QUOTED_STRING"
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
		case 49:
			CURLYOPEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 50:
			CURLYCLOSE_action((RuleContext)_localctx, actionIndex);
			break;
		case 55:
			OPEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 56:
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
		case 38:
			return BELIEVE_sempred((RuleContext)_localctx, predIndex);
		case 39:
			return GOAL_sempred((RuleContext)_localctx, predIndex);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2G\u0278\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)"+
		"\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\6\4\u00a4\n\4\r\4\16\4\u00a5\3\5\3\5\3\5\3\5\7\5\u00ac\n\5\f\5\16"+
		"\5\u00af\13\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\u00ba\n\6\f\6\16"+
		"\6\u00bd\13\6\3\6\3\6\3\7\5\7\u00c2\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u010a"+
		"\n\f\f\f\16\f\u010d\13\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u0118"+
		"\n\r\f\r\16\r\u011b\13\r\3\r\3\r\3\16\5\16\u0120\n\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\20\6\20\u012b\n\20\r\20\16\20\u012c\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u0145\n\22\f\22\16\22\u0148\13\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u0153\n\23\f\23\16"+
		"\23\u0156\13\23\3\23\3\23\3\24\5\24\u015b\n\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\6\26\u0167\n\26\r\26\16\26\u0168\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u0179"+
		"\n\30\f\30\16\30\u017c\13\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\7\31\u0187\n\31\f\31\16\31\u018a\13\31\3\31\3\31\3\32\5\32\u018f\n"+
		"\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3 \6 \u01b2\n \r \16 \u01b3\3!\3!\3!\3!\3!\3!"+
		"\3!\3!\3!\3\"\3\"\3\"\3\"\7\"\u01c3\n\"\f\"\16\"\u01c6\13\"\3\"\3\"\3"+
		"\"\3\"\3\"\3#\3#\3#\3#\7#\u01d1\n#\f#\16#\u01d4\13#\3#\3#\3$\5$\u01d9"+
		"\n$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3(\3(\3(\3(\5(\u01f7\n(\3)\3)\3)\3)\5)\u01fd\n)\3*\3"+
		"*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3"+
		"-\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3"+
		"\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\38\38"+
		"\39\39\39\3:\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3?\3@\3@\3A\3A\3A\3B"+
		"\3B\3B\3B\3B\3C\3C\7C\u0254\nC\fC\16C\u0257\13C\3D\3D\7D\u025b\nD\fD\16"+
		"D\u025e\13D\3E\3E\7E\u0262\nE\fE\16E\u0265\13E\3F\3F\7F\u0269\nF\fF\16"+
		"F\u026c\13F\3F\3F\3F\7F\u0271\nF\fF\16F\u0274\13F\3F\5F\u0277\nF\t\u00ad"+
		"\u010b\u0146\u017a\u01c4\u026a\u0272\2G\7\3\t\4\13\5\r\6\17\7\21\b\23"+
		"\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61"+
		"\30\63\31\65\32\67\339\34;\35=\36?\37A C!E\"G#I$K%M&O\'Q(S)U*W+Y,[-]."+
		"_/a\60c\61e\62g\63i\64k\65m\66o\67q8s9u:w;y<{=}>\177?\u0081@\u0083A\u0085"+
		"B\u0087C\u0089D\u008bE\u008dF\u008fG\7\2\3\4\5\6\f\6\2\62;C\\aac|\3\2"+
		"\f\f\4\2\13\13\"\"\16\2\13\f\17\17\"\"$$*+.\60\62;C]__aac|~~\b\2*+..\62"+
		";C\\aac|\n\2\13\f\17\17\"#==]]__~~\u0080\u0080\n\2\"\"*+..\60\60\62;C"+
		"\\aac|\7\2\60\60\62;C\\aac|\4\2C\\aa\4\2\60\60\62;\2\u0290\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\3\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2\2"+
		"\2\3\37\3\2\2\2\3!\3\2\2\2\3#\3\2\2\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3\2\2"+
		"\2\4+\3\2\2\2\4-\3\2\2\2\4/\3\2\2\2\5\61\3\2\2\2\5\63\3\2\2\2\5\65\3\2"+
		"\2\2\5\67\3\2\2\2\59\3\2\2\2\5;\3\2\2\2\5=\3\2\2\2\5?\3\2\2\2\5A\3\2\2"+
		"\2\5C\3\2\2\2\6E\3\2\2\2\6G\3\2\2\2\6I\3\2\2\2\6K\3\2\2\2\6M\3\2\2\2\6"+
		"O\3\2\2\2\6Q\3\2\2\2\6S\3\2\2\2\6U\3\2\2\2\6W\3\2\2\2\6Y\3\2\2\2\6[\3"+
		"\2\2\2\6]\3\2\2\2\6_\3\2\2\2\6a\3\2\2\2\6c\3\2\2\2\6e\3\2\2\2\6g\3\2\2"+
		"\2\6i\3\2\2\2\6k\3\2\2\2\6m\3\2\2\2\6o\3\2\2\2\6q\3\2\2\2\6s\3\2\2\2\6"+
		"u\3\2\2\2\6w\3\2\2\2\6y\3\2\2\2\6{\3\2\2\2\6}\3\2\2\2\6\177\3\2\2\2\6"+
		"\u0081\3\2\2\2\6\u0083\3\2\2\2\6\u0085\3\2\2\2\6\u0087\3\2\2\2\6\u0089"+
		"\3\2\2\2\6\u008b\3\2\2\2\6\u008d\3\2\2\2\6\u008f\3\2\2\2\7\u0091\3\2\2"+
		"\2\t\u009b\3\2\2\2\13\u00a3\3\2\2\2\r\u00a7\3\2\2\2\17\u00b5\3\2\2\2\21"+
		"\u00c1\3\2\2\2\23\u00c7\3\2\2\2\25\u00cb\3\2\2\2\27\u00df\3\2\2\2\31\u00f3"+
		"\3\2\2\2\33\u0105\3\2\2\2\35\u0113\3\2\2\2\37\u011f\3\2\2\2!\u0125\3\2"+
		"\2\2#\u012a\3\2\2\2%\u012e\3\2\2\2\'\u0140\3\2\2\2)\u014e\3\2\2\2+\u015a"+
		"\3\2\2\2-\u015e\3\2\2\2/\u0166\3\2\2\2\61\u016a\3\2\2\2\63\u0174\3\2\2"+
		"\2\65\u0182\3\2\2\2\67\u018e\3\2\2\29\u0194\3\2\2\2;\u0198\3\2\2\2=\u01a1"+
		"\3\2\2\2?\u01aa\3\2\2\2A\u01ad\3\2\2\2C\u01b1\3\2\2\2E\u01b5\3\2\2\2G"+
		"\u01be\3\2\2\2I\u01cc\3\2\2\2K\u01d8\3\2\2\2M\u01de\3\2\2\2O\u01e2\3\2"+
		"\2\2Q\u01e8\3\2\2\2S\u01f2\3\2\2\2U\u01f8\3\2\2\2W\u01fe\3\2\2\2Y\u0204"+
		"\3\2\2\2[\u020a\3\2\2\2]\u0212\3\2\2\2_\u021a\3\2\2\2a\u021c\3\2\2\2c"+
		"\u021e\3\2\2\2e\u0220\3\2\2\2g\u0222\3\2\2\2i\u0224\3\2\2\2k\u0227\3\2"+
		"\2\2m\u022a\3\2\2\2o\u022c\3\2\2\2q\u022e\3\2\2\2s\u0234\3\2\2\2u\u0236"+
		"\3\2\2\2w\u0239\3\2\2\2y\u023c\3\2\2\2{\u023e\3\2\2\2}\u0240\3\2\2\2\177"+
		"\u0242\3\2\2\2\u0081\u0244\3\2\2\2\u0083\u0247\3\2\2\2\u0085\u0249\3\2"+
		"\2\2\u0087\u024c\3\2\2\2\u0089\u0251\3\2\2\2\u008b\u0258\3\2\2\2\u008d"+
		"\u025f\3\2\2\2\u008f\u0276\3\2\2\2\u0091\u0092\7I\2\2\u0092\u0093\7Y\2"+
		"\2\u0093\u0094\7G\2\2\u0094\u0095\7P\2\2\u0095\u0096\7F\2\2\u0096\u0097"+
		"\7Q\2\2\u0097\u0098\7N\2\2\u0098\u0099\7G\2\2\u0099\u009a\7P\2\2\u009a"+
		"\b\3\2\2\2\u009b\u009c\7<\2\2\u009c\u009d\7p\2\2\u009d\u009e\7c\2\2\u009e"+
		"\u009f\7o\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7<\2\2\u00a1\n\3\2\2\2\u00a2"+
		"\u00a4\t\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\f\3\2\2\2\u00a7\u00a8\7\61\2\2\u00a8\u00a9"+
		"\7,\2\2\u00a9\u00ad\3\2\2\2\u00aa\u00ac\13\2\2\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b0\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7,\2\2\u00b1\u00b2\7\61\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b4\b\5\2\2\u00b4\16\3\2\2\2\u00b5\u00b6\7\61\2"+
		"\2\u00b6\u00b7\7\61\2\2\u00b7\u00bb\3\2\2\2\u00b8\u00ba\n\3\2\2\u00b9"+
		"\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\b\6\2\2\u00bf"+
		"\20\3\2\2\2\u00c0\u00c2\7\17\2\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2"+
		"\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7\f\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6"+
		"\b\7\2\2\u00c6\22\3\2\2\2\u00c7\u00c8\t\4\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00ca\b\b\2\2\u00ca\24\3\2\2\2\u00cb\u00cc\7<\2\2\u00cc\u00cd\7K\2\2"+
		"\u00cd\u00ce\7p\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1"+
		"\7k\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7n\2\2\u00d3\u00d4\7\"\2\2\u00d4"+
		"\u00d5\7D\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7n\2\2\u00d7\u00d8\7k\2\2"+
		"\u00d8\u00d9\7g\2\2\u00d9\u00da\7h\2\2\u00da\u00db\7u\2\2\u00db\u00dc"+
		"\7<\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\b\t\3\2\u00de\26\3\2\2\2\u00df"+
		"\u00e0\7<\2\2\u00e0\u00e1\7T\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7c\2\2"+
		"\u00e3\u00e4\7u\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6\7p\2\2\u00e6\u00e7"+
		"\7k\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9\7i\2\2\u00e9\u00ea\7\"\2\2\u00ea"+
		"\u00eb\7T\2\2\u00eb\u00ec\7w\2\2\u00ec\u00ed\7n\2\2\u00ed\u00ee\7g\2\2"+
		"\u00ee\u00ef\7u\2\2\u00ef\u00f0\7<\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2"+
		"\b\n\4\2\u00f2\30\3\2\2\2\u00f3\u00f4\7<\2\2\u00f4\u00f5\7K\2\2\u00f5"+
		"\u00f6\7p\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8\7v\2\2\u00f8\u00f9\7k\2\2"+
		"\u00f9\u00fa\7c\2\2\u00fa\u00fb\7n\2\2\u00fb\u00fc\7\"\2\2\u00fc\u00fd"+
		"\7I\2\2\u00fd\u00fe\7q\2\2\u00fe\u00ff\7c\2\2\u00ff\u0100\7n\2\2\u0100"+
		"\u0101\7u\2\2\u0101\u0102\7<\2\2\u0102\u0103\3\2\2\2\u0103\u0104\b\13"+
		"\5\2\u0104\32\3\2\2\2\u0105\u0106\7\61\2\2\u0106\u0107\7,\2\2\u0107\u010b"+
		"\3\2\2\2\u0108\u010a\13\2\2\2\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2"+
		"\u010b\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u010b"+
		"\3\2\2\2\u010e\u010f\7,\2\2\u010f\u0110\7\61\2\2\u0110\u0111\3\2\2\2\u0111"+
		"\u0112\b\f\2\2\u0112\34\3\2\2\2\u0113\u0114\7\61\2\2\u0114\u0115\7\61"+
		"\2\2\u0115\u0119\3\2\2\2\u0116\u0118\n\3\2\2\u0117\u0116\3\2\2\2\u0118"+
		"\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2"+
		"\2\2\u011b\u0119\3\2\2\2\u011c\u011d\b\r\2\2\u011d\36\3\2\2\2\u011e\u0120"+
		"\7\17\2\2\u011f\u011e\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2\2\2"+
		"\u0121\u0122\7\f\2\2\u0122\u0123\3\2\2\2\u0123\u0124\b\16\2\2\u0124 \3"+
		"\2\2\2\u0125\u0126\t\4\2\2\u0126\u0127\3\2\2\2\u0127\u0128\b\17\2\2\u0128"+
		"\"\3\2\2\2\u0129\u012b\t\5\2\2\u012a\u0129\3\2\2\2\u012b\u012c\3\2\2\2"+
		"\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d$\3\2\2\2\u012e\u012f\7"+
		"<\2\2\u012f\u0130\7K\2\2\u0130\u0131\7p\2\2\u0131\u0132\7k\2\2\u0132\u0133"+
		"\7v\2\2\u0133\u0134\7k\2\2\u0134\u0135\7c\2\2\u0135\u0136\7n\2\2\u0136"+
		"\u0137\7\"\2\2\u0137\u0138\7I\2\2\u0138\u0139\7q\2\2\u0139\u013a\7c\2"+
		"\2\u013a\u013b\7n\2\2\u013b\u013c\7u\2\2\u013c\u013d\7<\2\2\u013d\u013e"+
		"\3\2\2\2\u013e\u013f\b\21\5\2\u013f&\3\2\2\2\u0140\u0141\7\61\2\2\u0141"+
		"\u0142\7,\2\2\u0142\u0146\3\2\2\2\u0143\u0145\13\2\2\2\u0144\u0143\3\2"+
		"\2\2\u0145\u0148\3\2\2\2\u0146\u0147\3\2\2\2\u0146\u0144\3\2\2\2\u0147"+
		"\u0149\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014a\7,\2\2\u014a\u014b\7\61"+
		"\2\2\u014b\u014c\3\2\2\2\u014c\u014d\b\22\2\2\u014d(\3\2\2\2\u014e\u014f"+
		"\7\61\2\2\u014f\u0150\7\61\2\2\u0150\u0154\3\2\2\2\u0151\u0153\n\3\2\2"+
		"\u0152\u0151\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155"+
		"\3\2\2\2\u0155\u0157\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0158\b\23\2\2"+
		"\u0158*\3\2\2\2\u0159\u015b\7\17\2\2\u015a\u0159\3\2\2\2\u015a\u015b\3"+
		"\2\2\2\u015b\u015c\3\2\2\2\u015c\u015d\7\f\2\2\u015d,\3\2\2\2\u015e\u015f"+
		"\t\4\2\2\u015f\u0160\3\2\2\2\u0160\u0161\b\25\2\2\u0161.\3\2\2\2\u0162"+
		"\u0167\t\6\2\2\u0163\u0164\7<\2\2\u0164\u0167\7/\2\2\u0165\u0167\t\7\2"+
		"\2\u0166\u0162\3\2\2\2\u0166\u0163\3\2\2\2\u0166\u0165\3\2\2\2\u0167\u0168"+
		"\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\60\3\2\2\2\u016a"+
		"\u016b\7<\2\2\u016b\u016c\7R\2\2\u016c\u016d\7n\2\2\u016d\u016e\7c\2\2"+
		"\u016e\u016f\7p\2\2\u016f\u0170\7u\2\2\u0170\u0171\7<\2\2\u0171\u0172"+
		"\3\2\2\2\u0172\u0173\b\27\6\2\u0173\62\3\2\2\2\u0174\u0175\7\61\2\2\u0175"+
		"\u0176\7,\2\2\u0176\u017a\3\2\2\2\u0177\u0179\13\2\2\2\u0178\u0177\3\2"+
		"\2\2\u0179\u017c\3\2\2\2\u017a\u017b\3\2\2\2\u017a\u0178\3\2\2\2\u017b"+
		"\u017d\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017e\7,\2\2\u017e\u017f\7\61"+
		"\2\2\u017f\u0180\3\2\2\2\u0180\u0181\b\30\2\2\u0181\64\3\2\2\2\u0182\u0183"+
		"\7\61\2\2\u0183\u0184\7\61\2\2\u0184\u0188\3\2\2\2\u0185\u0187\n\3\2\2"+
		"\u0186\u0185\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189"+
		"\3\2\2\2\u0189\u018b\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u018c\b\31\2\2"+
		"\u018c\66\3\2\2\2\u018d\u018f\7\17\2\2\u018e\u018d\3\2\2\2\u018e\u018f"+
		"\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\7\f\2\2\u0191\u0192\3\2\2\2\u0192"+
		"\u0193\b\32\2\2\u01938\3\2\2\2\u0194\u0195\t\4\2\2\u0195\u0196\3\2\2\2"+
		"\u0196\u0197\b\33\2\2\u0197:\3\2\2\2\u0198\u0199\6\34\2\2\u0199\u019a"+
		"\7c\2\2\u019a\u019b\7e\2\2\u019b\u019c\7j\2\2\u019c\u019d\7k\2\2\u019d"+
		"\u019e\7g\2\2\u019e\u019f\7x\2\2\u019f\u01a0\7g\2\2\u01a0<\3\2\2\2\u01a1"+
		"\u01a2\6\35\3\2\u01a2\u01a3\7r\2\2\u01a3\u01a4\7g\2\2\u01a4\u01a5\7t\2"+
		"\2\u01a5\u01a6\7h\2\2\u01a6\u01a7\7q\2\2\u01a7\u01a8\7t\2\2\u01a8\u01a9"+
		"\7o\2\2\u01a9>\3\2\2\2\u01aa\u01ab\7]\2\2\u01ab\u01ac\b\36\7\2\u01ac@"+
		"\3\2\2\2\u01ad\u01ae\7_\2\2\u01ae\u01af\b\37\b\2\u01afB\3\2\2\2\u01b0"+
		"\u01b2\t\b\2\2\u01b1\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b1\3\2"+
		"\2\2\u01b3\u01b4\3\2\2\2\u01b4D\3\2\2\2\u01b5\u01b6\7<\2\2\u01b6\u01b7"+
		"\7p\2\2\u01b7\u01b8\7c\2\2\u01b8\u01b9\7o\2\2\u01b9\u01ba\7g\2\2\u01ba"+
		"\u01bb\7<\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd\b!\t\2\u01bdF\3\2\2\2\u01be"+
		"\u01bf\7\61\2\2\u01bf\u01c0\7,\2\2\u01c0\u01c4\3\2\2\2\u01c1\u01c3\13"+
		"\2\2\2\u01c2\u01c1\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c4"+
		"\u01c2\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01c8\7,"+
		"\2\2\u01c8\u01c9\7\61\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\b\"\2\2\u01cb"+
		"H\3\2\2\2\u01cc\u01cd\7\61\2\2\u01cd\u01ce\7\61\2\2\u01ce\u01d2\3\2\2"+
		"\2\u01cf\u01d1\n\3\2\2\u01d0\u01cf\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d0"+
		"\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d5\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5"+
		"\u01d6\b#\2\2\u01d6J\3\2\2\2\u01d7\u01d9\7\17\2\2\u01d8\u01d7\3\2\2\2"+
		"\u01d8\u01d9\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\7\f\2\2\u01db\u01dc"+
		"\3\2\2\2\u01dc\u01dd\b$\2\2\u01ddL\3\2\2\2\u01de\u01df\t\4\2\2\u01df\u01e0"+
		"\3\2\2\2\u01e0\u01e1\b%\2\2\u01e1N\3\2\2\2\u01e2\u01e3\7\60\2\2\u01e3"+
		"\u01e4\7u\2\2\u01e4\u01e5\7g\2\2\u01e5\u01e6\7p\2\2\u01e6\u01e7\7f\2\2"+
		"\u01e7P\3\2\2\2\u01e8\u01e9\7\60\2\2\u01e9\u01ea\7t\2\2\u01ea\u01eb\7"+
		"g\2\2\u01eb\u01ec\7e\2\2\u01ec\u01ed\7g\2\2\u01ed\u01ee\7k\2\2\u01ee\u01ef"+
		"\7x\2\2\u01ef\u01f0\7g\2\2\u01f0\u01f1\7f\2\2\u01f1R\3\2\2\2\u01f2\u01f6"+
		"\6(\4\2\u01f3\u01f7\7D\2\2\u01f4\u01f5\7\60\2\2\u01f5\u01f7\7D\2\2\u01f6"+
		"\u01f3\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f7T\3\2\2\2\u01f8\u01fc\6)\5\2\u01f9"+
		"\u01fd\7I\2\2\u01fa\u01fb\7\60\2\2\u01fb\u01fd\7I\2\2\u01fc\u01f9\3\2"+
		"\2\2\u01fc\u01fa\3\2\2\2\u01fdV\3\2\2\2\u01fe\u01ff\7\60\2\2\u01ff\u0200"+
		"\7u\2\2\u0200\u0201\7g\2\2\u0201\u0202\7p\2\2\u0202\u0203\7v\2\2\u0203"+
		"X\3\2\2\2\u0204\u0205\7\60\2\2\u0205\u0206\7n\2\2\u0206\u0207\7q\2\2\u0207"+
		"\u0208\7e\2\2\u0208\u0209\7m\2\2\u0209Z\3\2\2\2\u020a\u020b\7c\2\2\u020b"+
		"\u020c\7e\2\2\u020c\u020d\7j\2\2\u020d\u020e\7k\2\2\u020e\u020f\7g\2\2"+
		"\u020f\u0210\7x\2\2\u0210\u0211\7g\2\2\u0211\\\3\2\2\2\u0212\u0213\7r"+
		"\2\2\u0213\u0214\7g\2\2\u0214\u0215\7t\2\2\u0215\u0216\7h\2\2\u0216\u0217"+
		"\7q\2\2\u0217\u0218\7t\2\2\u0218\u0219\7o\2\2\u0219^\3\2\2\2\u021a\u021b"+
		"\7]\2\2\u021b`\3\2\2\2\u021c\u021d\7_\2\2\u021db\3\2\2\2\u021e\u021f\7"+
		"~\2\2\u021fd\3\2\2\2\u0220\u0221\7\u0080\2\2\u0221f\3\2\2\2\u0222\u0223"+
		"\7<\2\2\u0223h\3\2\2\2\u0224\u0225\7}\2\2\u0225\u0226\b\63\n\2\u0226j"+
		"\3\2\2\2\u0227\u0228\7\177\2\2\u0228\u0229\b\64\13\2\u0229l\3\2\2\2\u022a"+
		"\u022b\7.\2\2\u022bn\3\2\2\2\u022c\u022d\7=\2\2\u022dp\3\2\2\2\u022e\u022f"+
		"\7<\2\2\u022f\u0230\7v\2\2\u0230\u0231\7g\2\2\u0231\u0232\7n\2\2\u0232"+
		"\u0233\7n\2\2\u0233r\3\2\2\2\u0234\u0235\7#\2\2\u0235t\3\2\2\2\u0236\u0237"+
		"\7*\2\2\u0237\u0238\b9\f\2\u0238v\3\2\2\2\u0239\u023a\7+\2\2\u023a\u023b"+
		"\b:\r\2\u023bx\3\2\2\2\u023c\u023d\7,\2\2\u023dz\3\2\2\2\u023e\u023f\7"+
		"-\2\2\u023f|\3\2\2\2\u0240\u0241\7/\2\2\u0241~\3\2\2\2\u0242\u0243\7>"+
		"\2\2\u0243\u0080\3\2\2\2\u0244\u0245\7?\2\2\u0245\u0246\7?\2\2\u0246\u0082"+
		"\3\2\2\2\u0247\u0248\7\60\2\2\u0248\u0084\3\2\2\2\u0249\u024a\7>\2\2\u024a"+
		"\u024b\7/\2\2\u024b\u0086\3\2\2\2\u024c\u024d\7V\2\2\u024d\u024e\7t\2"+
		"\2\u024e\u024f\7w\2\2\u024f\u0250\7g\2\2\u0250\u0088\3\2\2\2\u0251\u0255"+
		"\4c|\2\u0252\u0254\t\t\2\2\u0253\u0252\3\2\2\2\u0254\u0257\3\2\2\2\u0255"+
		"\u0253\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u008a\3\2\2\2\u0257\u0255\3\2"+
		"\2\2\u0258\u025c\t\n\2\2\u0259\u025b\t\2\2\2\u025a\u0259\3\2\2\2\u025b"+
		"\u025e\3\2\2\2\u025c\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u008c\3\2"+
		"\2\2\u025e\u025c\3\2\2\2\u025f\u0263\4\62;\2\u0260\u0262\t\13\2\2\u0261"+
		"\u0260\3\2\2\2\u0262\u0265\3\2\2\2\u0263\u0261\3\2\2\2\u0263\u0264\3\2"+
		"\2\2\u0264\u008e\3\2\2\2\u0265\u0263\3\2\2\2\u0266\u026a\7$\2\2\u0267"+
		"\u0269\13\2\2\2\u0268\u0267\3\2\2\2\u0269\u026c\3\2\2\2\u026a\u026b\3"+
		"\2\2\2\u026a\u0268\3\2\2\2\u026b\u026d\3\2\2\2\u026c\u026a\3\2\2\2\u026d"+
		"\u0277\7$\2\2\u026e\u0272\7)\2\2\u026f\u0271\13\2\2\2\u0270\u026f\3\2"+
		"\2\2\u0271\u0274\3\2\2\2\u0272\u0273\3\2\2\2\u0272\u0270\3\2\2\2\u0273"+
		"\u0275\3\2\2\2\u0274\u0272\3\2\2\2\u0275\u0277\7)\2\2\u0276\u0266\3\2"+
		"\2\2\u0276\u026e\3\2\2\2\u0277\u0090\3\2\2\2#\2\3\4\5\6\u00a5\u00ad\u00bb"+
		"\u00c1\u010b\u0119\u011f\u012c\u0146\u0154\u015a\u0166\u0168\u017a\u0188"+
		"\u018e\u01b3\u01c4\u01d2\u01d8\u01f6\u01fc\u0255\u025c\u0263\u026a\u0272"+
		"\u0276\16\b\2\2\4\3\2\4\4\2\4\5\2\4\6\2\3\36\2\3\37\3\4\2\2\3\63\4\3\64"+
		"\5\39\6\3:\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}