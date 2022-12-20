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
		NOT=47, COLON=48, CURLYOPEN=49, CURLYCLOSE=50, COMMA=51, SEMI=52, TELL=53, 
		SHRIEK=54, OPEN=55, CLOSE=56, MULT=57, PLUS=58, MINUS=59, LESS=60, EQUAL=61, 
		IDPUNCT=62, RULEARROW=63, TRUE=64, PL_CONST=65, PL_VAR=66, NUMBER=67, 
		QUOTED_STRING=68;
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
		"NOT", "COLON", "CURLYOPEN", "CURLYCLOSE", "COMMA", "SEMI", "TELL", "SHRIEK", 
		"OPEN", "CLOSE", "MULT", "PLUS", "MINUS", "LESS", "EQUAL", "IDPUNCT", 
		"RULEARROW", "TRUE", "PL_CONST", "PL_VAR", "NUMBER", "QUOTED_STRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'GWENDOLEN'", null, null, null, null, null, null, "':Initial Beliefs:'", 
		"':Reasoning Rules:'", null, null, null, null, null, null, null, null, 
		null, null, null, null, "':Plans:'", null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "'.send'", "'.received'", 
		null, null, "'.sent'", "'.lock'", "'achieve'", "'perform'", null, null, 
		null, "':'", "'{'", "'}'", "','", "';'", "':tell'", "'!'", "'('", "')'", 
		"'*'", "'+'", "'-'", "'<'", "'=='", "'.'", "'<-'", "'True'"
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
		"NOT", "COLON", "CURLYOPEN", "CURLYCLOSE", "COMMA", "SEMI", "TELL", "SHRIEK", 
		"OPEN", "CLOSE", "MULT", "PLUS", "MINUS", "LESS", "EQUAL", "IDPUNCT", 
		"RULEARROW", "TRUE", "PL_CONST", "PL_VAR", "NUMBER", "QUOTED_STRING"
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
		case 48:
			CURLYOPEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 49:
			CURLYCLOSE_action((RuleContext)_localctx, actionIndex);
			break;
		case 54:
			OPEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 55:
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
		case 46:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2F\u0272\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)"+
		"\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\6\4"+
		"\u00a2\n\4\r\4\16\4\u00a3\3\5\3\5\3\5\3\5\7\5\u00aa\n\5\f\5\16\5\u00ad"+
		"\13\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\u00b8\n\6\f\6\16\6\u00bb"+
		"\13\6\3\6\3\6\3\7\5\7\u00c0\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u0108\n\f\f\f"+
		"\16\f\u010b\13\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u0116\n\r\f\r"+
		"\16\r\u0119\13\r\3\r\3\r\3\16\5\16\u011e\n\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\20\6\20\u0129\n\20\r\20\16\20\u012a\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\7\22\u0143\n\22\f\22\16\22\u0146\13\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u0151\n\23\f\23\16\23\u0154"+
		"\13\23\3\23\3\23\3\24\5\24\u0159\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\6\26\u0165\n\26\r\26\16\26\u0166\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u0177\n\30\f\30"+
		"\16\30\u017a\13\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u0185"+
		"\n\31\f\31\16\31\u0188\13\31\3\31\3\31\3\32\5\32\u018d\n\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3 \6 \u01b0\n \r \16 \u01b1\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\""+
		"\3\"\3\"\3\"\7\"\u01c1\n\"\f\"\16\"\u01c4\13\"\3\"\3\"\3\"\3\"\3\"\3#"+
		"\3#\3#\3#\7#\u01cf\n#\f#\16#\u01d2\13#\3#\3#\3$\5$\u01d7\n$\3$\3$\3$\3"+
		"$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3(\3(\3(\3(\5(\u01f5\n(\3)\3)\3)\3)\5)\u01fb\n)\3*\3*\3*\3*\3*\3*\3"+
		"+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3.\3"+
		".\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3"+
		"\64\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\38\38\38\39\39\3"+
		"9\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3>\3?\3?\3@\3@\3@\3A\3A\3A\3A\3A\3B\3"+
		"B\6B\u0251\nB\rB\16B\u0252\3C\3C\7C\u0257\nC\fC\16C\u025a\13C\3D\6D\u025d"+
		"\nD\rD\16D\u025e\3E\3E\7E\u0263\nE\fE\16E\u0266\13E\3E\3E\3E\7E\u026b"+
		"\nE\fE\16E\u026e\13E\3E\5E\u0271\nE\t\u00ab\u0109\u0144\u0178\u01c2\u0264"+
		"\u026c\2F\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37"+
		"\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35="+
		"\36?\37A C!E\"G#I$K%M&O\'Q(S)U*W+Y,[-]._/a\60c\61e\62g\63i\64k\65m\66"+
		"o\67q8s9u:w;y<{=}>\177?\u0081@\u0083A\u0085B\u0087C\u0089D\u008bE\u008d"+
		"F\7\2\3\4\5\6\n\6\2\62;C\\aac|\3\2\f\f\4\2\13\13\"\"\t\2\"\"*+.\60\62"+
		";C\\aac|\b\2*+..\62;C\\aac|\5\2\"\"==\u0080\u0080\n\2\"\"*+..\60\60\62"+
		";C\\aac|\4\2C\\aa\2\u028a\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2"+
		"\3\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2\2\2\3\37\3\2\2\2\3!\3\2\2\2\3#\3\2"+
		"\2\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3\2\2\2\4+\3\2\2\2\4-\3\2\2\2\4/\3\2\2"+
		"\2\5\61\3\2\2\2\5\63\3\2\2\2\5\65\3\2\2\2\5\67\3\2\2\2\59\3\2\2\2\5;\3"+
		"\2\2\2\5=\3\2\2\2\5?\3\2\2\2\5A\3\2\2\2\5C\3\2\2\2\6E\3\2\2\2\6G\3\2\2"+
		"\2\6I\3\2\2\2\6K\3\2\2\2\6M\3\2\2\2\6O\3\2\2\2\6Q\3\2\2\2\6S\3\2\2\2\6"+
		"U\3\2\2\2\6W\3\2\2\2\6Y\3\2\2\2\6[\3\2\2\2\6]\3\2\2\2\6_\3\2\2\2\6a\3"+
		"\2\2\2\6c\3\2\2\2\6e\3\2\2\2\6g\3\2\2\2\6i\3\2\2\2\6k\3\2\2\2\6m\3\2\2"+
		"\2\6o\3\2\2\2\6q\3\2\2\2\6s\3\2\2\2\6u\3\2\2\2\6w\3\2\2\2\6y\3\2\2\2\6"+
		"{\3\2\2\2\6}\3\2\2\2\6\177\3\2\2\2\6\u0081\3\2\2\2\6\u0083\3\2\2\2\6\u0085"+
		"\3\2\2\2\6\u0087\3\2\2\2\6\u0089\3\2\2\2\6\u008b\3\2\2\2\6\u008d\3\2\2"+
		"\2\7\u008f\3\2\2\2\t\u0099\3\2\2\2\13\u00a1\3\2\2\2\r\u00a5\3\2\2\2\17"+
		"\u00b3\3\2\2\2\21\u00bf\3\2\2\2\23\u00c5\3\2\2\2\25\u00c9\3\2\2\2\27\u00dd"+
		"\3\2\2\2\31\u00f1\3\2\2\2\33\u0103\3\2\2\2\35\u0111\3\2\2\2\37\u011d\3"+
		"\2\2\2!\u0123\3\2\2\2#\u0128\3\2\2\2%\u012c\3\2\2\2\'\u013e\3\2\2\2)\u014c"+
		"\3\2\2\2+\u0158\3\2\2\2-\u015c\3\2\2\2/\u0164\3\2\2\2\61\u0168\3\2\2\2"+
		"\63\u0172\3\2\2\2\65\u0180\3\2\2\2\67\u018c\3\2\2\29\u0192\3\2\2\2;\u0196"+
		"\3\2\2\2=\u019f\3\2\2\2?\u01a8\3\2\2\2A\u01ab\3\2\2\2C\u01af\3\2\2\2E"+
		"\u01b3\3\2\2\2G\u01bc\3\2\2\2I\u01ca\3\2\2\2K\u01d6\3\2\2\2M\u01dc\3\2"+
		"\2\2O\u01e0\3\2\2\2Q\u01e6\3\2\2\2S\u01f0\3\2\2\2U\u01f6\3\2\2\2W\u01fc"+
		"\3\2\2\2Y\u0202\3\2\2\2[\u0208\3\2\2\2]\u0210\3\2\2\2_\u0218\3\2\2\2a"+
		"\u021a\3\2\2\2c\u021c\3\2\2\2e\u021f\3\2\2\2g\u0221\3\2\2\2i\u0224\3\2"+
		"\2\2k\u0227\3\2\2\2m\u0229\3\2\2\2o\u022b\3\2\2\2q\u0231\3\2\2\2s\u0233"+
		"\3\2\2\2u\u0236\3\2\2\2w\u0239\3\2\2\2y\u023b\3\2\2\2{\u023d\3\2\2\2}"+
		"\u023f\3\2\2\2\177\u0241\3\2\2\2\u0081\u0244\3\2\2\2\u0083\u0246\3\2\2"+
		"\2\u0085\u0249\3\2\2\2\u0087\u024e\3\2\2\2\u0089\u0254\3\2\2\2\u008b\u025c"+
		"\3\2\2\2\u008d\u0270\3\2\2\2\u008f\u0090\7I\2\2\u0090\u0091\7Y\2\2\u0091"+
		"\u0092\7G\2\2\u0092\u0093\7P\2\2\u0093\u0094\7F\2\2\u0094\u0095\7Q\2\2"+
		"\u0095\u0096\7N\2\2\u0096\u0097\7G\2\2\u0097\u0098\7P\2\2\u0098\b\3\2"+
		"\2\2\u0099\u009a\7<\2\2\u009a\u009b\7p\2\2\u009b\u009c\7c\2\2\u009c\u009d"+
		"\7o\2\2\u009d\u009e\7g\2\2\u009e\u009f\7<\2\2\u009f\n\3\2\2\2\u00a0\u00a2"+
		"\t\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\f\3\2\2\2\u00a5\u00a6\7\61\2\2\u00a6\u00a7\7,\2\2"+
		"\u00a7\u00ab\3\2\2\2\u00a8\u00aa\13\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad"+
		"\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ae\u00af\7,\2\2\u00af\u00b0\7\61\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\u00b2\b\5\2\2\u00b2\16\3\2\2\2\u00b3\u00b4\7\61\2\2\u00b4\u00b5"+
		"\7\61\2\2\u00b5\u00b9\3\2\2\2\u00b6\u00b8\n\3\2\2\u00b7\u00b6\3\2\2\2"+
		"\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\b\6\2\2\u00bd\20\3\2\2\2\u00be"+
		"\u00c0\7\17\2\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3"+
		"\2\2\2\u00c1\u00c2\7\f\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\b\7\2\2\u00c4"+
		"\22\3\2\2\2\u00c5\u00c6\t\4\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b\b\2"+
		"\2\u00c8\24\3\2\2\2\u00c9\u00ca\7<\2\2\u00ca\u00cb\7K\2\2\u00cb\u00cc"+
		"\7p\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7k\2\2\u00cf"+
		"\u00d0\7c\2\2\u00d0\u00d1\7n\2\2\u00d1\u00d2\7\"\2\2\u00d2\u00d3\7D\2"+
		"\2\u00d3\u00d4\7g\2\2\u00d4\u00d5\7n\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7"+
		"\7g\2\2\u00d7\u00d8\7h\2\2\u00d8\u00d9\7u\2\2\u00d9\u00da\7<\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dc\b\t\3\2\u00dc\26\3\2\2\2\u00dd\u00de\7<\2\2"+
		"\u00de\u00df\7T\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2"+
		"\7u\2\2\u00e2\u00e3\7q\2\2\u00e3\u00e4\7p\2\2\u00e4\u00e5\7k\2\2\u00e5"+
		"\u00e6\7p\2\2\u00e6\u00e7\7i\2\2\u00e7\u00e8\7\"\2\2\u00e8\u00e9\7T\2"+
		"\2\u00e9\u00ea\7w\2\2\u00ea\u00eb\7n\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed"+
		"\7u\2\2\u00ed\u00ee\7<\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b\n\4\2\u00f0"+
		"\30\3\2\2\2\u00f1\u00f2\7<\2\2\u00f2\u00f3\7K\2\2\u00f3\u00f4\7p\2\2\u00f4"+
		"\u00f5\7k\2\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8\7c\2\2"+
		"\u00f8\u00f9\7n\2\2\u00f9\u00fa\7\"\2\2\u00fa\u00fb\7I\2\2\u00fb\u00fc"+
		"\7q\2\2\u00fc\u00fd\7c\2\2\u00fd\u00fe\7n\2\2\u00fe\u00ff\7u\2\2\u00ff"+
		"\u0100\7<\2\2\u0100\u0101\3\2\2\2\u0101\u0102\b\13\5\2\u0102\32\3\2\2"+
		"\2\u0103\u0104\7\61\2\2\u0104\u0105\7,\2\2\u0105\u0109\3\2\2\2\u0106\u0108"+
		"\13\2\2\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u010a\3\2\2\2"+
		"\u0109\u0107\3\2\2\2\u010a\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010d"+
		"\7,\2\2\u010d\u010e\7\61\2\2\u010e\u010f\3\2\2\2\u010f\u0110\b\f\2\2\u0110"+
		"\34\3\2\2\2\u0111\u0112\7\61\2\2\u0112\u0113\7\61\2\2\u0113\u0117\3\2"+
		"\2\2\u0114\u0116\n\3\2\2\u0115\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117"+
		"\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011a\3\2\2\2\u0119\u0117\3\2"+
		"\2\2\u011a\u011b\b\r\2\2\u011b\36\3\2\2\2\u011c\u011e\7\17\2\2\u011d\u011c"+
		"\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\7\f\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u0122\b\16\2\2\u0122 \3\2\2\2\u0123\u0124\t\4\2\2"+
		"\u0124\u0125\3\2\2\2\u0125\u0126\b\17\2\2\u0126\"\3\2\2\2\u0127\u0129"+
		"\t\5\2\2\u0128\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b$\3\2\2\2\u012c\u012d\7<\2\2\u012d\u012e\7K\2\2\u012e"+
		"\u012f\7p\2\2\u012f\u0130\7k\2\2\u0130\u0131\7v\2\2\u0131\u0132\7k\2\2"+
		"\u0132\u0133\7c\2\2\u0133\u0134\7n\2\2\u0134\u0135\7\"\2\2\u0135\u0136"+
		"\7I\2\2\u0136\u0137\7q\2\2\u0137\u0138\7c\2\2\u0138\u0139\7n\2\2\u0139"+
		"\u013a\7u\2\2\u013a\u013b\7<\2\2\u013b\u013c\3\2\2\2\u013c\u013d\b\21"+
		"\5\2\u013d&\3\2\2\2\u013e\u013f\7\61\2\2\u013f\u0140\7,\2\2\u0140\u0144"+
		"\3\2\2\2\u0141\u0143\13\2\2\2\u0142\u0141\3\2\2\2\u0143\u0146\3\2\2\2"+
		"\u0144\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0147\3\2\2\2\u0146\u0144"+
		"\3\2\2\2\u0147\u0148\7,\2\2\u0148\u0149\7\61\2\2\u0149\u014a\3\2\2\2\u014a"+
		"\u014b\b\22\2\2\u014b(\3\2\2\2\u014c\u014d\7\61\2\2\u014d\u014e\7\61\2"+
		"\2\u014e\u0152\3\2\2\2\u014f\u0151\n\3\2\2\u0150\u014f\3\2\2\2\u0151\u0154"+
		"\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0155\3\2\2\2\u0154"+
		"\u0152\3\2\2\2\u0155\u0156\b\23\2\2\u0156*\3\2\2\2\u0157\u0159\7\17\2"+
		"\2\u0158\u0157\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b"+
		"\7\f\2\2\u015b,\3\2\2\2\u015c\u015d\t\4\2\2\u015d\u015e\3\2\2\2\u015e"+
		"\u015f\b\25\2\2\u015f.\3\2\2\2\u0160\u0165\t\6\2\2\u0161\u0162\7<\2\2"+
		"\u0162\u0165\7/\2\2\u0163\u0165\t\7\2\2\u0164\u0160\3\2\2\2\u0164\u0161"+
		"\3\2\2\2\u0164\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0164\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\60\3\2\2\2\u0168\u0169\7<\2\2\u0169\u016a\7R\2\2"+
		"\u016a\u016b\7n\2\2\u016b\u016c\7c\2\2\u016c\u016d\7p\2\2\u016d\u016e"+
		"\7u\2\2\u016e\u016f\7<\2\2\u016f\u0170\3\2\2\2\u0170\u0171\b\27\6\2\u0171"+
		"\62\3\2\2\2\u0172\u0173\7\61\2\2\u0173\u0174\7,\2\2\u0174\u0178\3\2\2"+
		"\2\u0175\u0177\13\2\2\2\u0176\u0175\3\2\2\2\u0177\u017a\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u0178\3\2"+
		"\2\2\u017b\u017c\7,\2\2\u017c\u017d\7\61\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\u017f\b\30\2\2\u017f\64\3\2\2\2\u0180\u0181\7\61\2\2\u0181\u0182\7\61"+
		"\2\2\u0182\u0186\3\2\2\2\u0183\u0185\n\3\2\2\u0184\u0183\3\2\2\2\u0185"+
		"\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0189\3\2"+
		"\2\2\u0188\u0186\3\2\2\2\u0189\u018a\b\31\2\2\u018a\66\3\2\2\2\u018b\u018d"+
		"\7\17\2\2\u018c\u018b\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\3\2\2\2"+
		"\u018e\u018f\7\f\2\2\u018f\u0190\3\2\2\2\u0190\u0191\b\32\2\2\u01918\3"+
		"\2\2\2\u0192\u0193\t\4\2\2\u0193\u0194\3\2\2\2\u0194\u0195\b\33\2\2\u0195"+
		":\3\2\2\2\u0196\u0197\6\34\2\2\u0197\u0198\7c\2\2\u0198\u0199\7e\2\2\u0199"+
		"\u019a\7j\2\2\u019a\u019b\7k\2\2\u019b\u019c\7g\2\2\u019c\u019d\7x\2\2"+
		"\u019d\u019e\7g\2\2\u019e<\3\2\2\2\u019f\u01a0\6\35\3\2\u01a0\u01a1\7"+
		"r\2\2\u01a1\u01a2\7g\2\2\u01a2\u01a3\7t\2\2\u01a3\u01a4\7h\2\2\u01a4\u01a5"+
		"\7q\2\2\u01a5\u01a6\7t\2\2\u01a6\u01a7\7o\2\2\u01a7>\3\2\2\2\u01a8\u01a9"+
		"\7]\2\2\u01a9\u01aa\b\36\7\2\u01aa@\3\2\2\2\u01ab\u01ac\7_\2\2\u01ac\u01ad"+
		"\b\37\b\2\u01adB\3\2\2\2\u01ae\u01b0\t\b\2\2\u01af\u01ae\3\2\2\2\u01b0"+
		"\u01b1\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2D\3\2\2\2"+
		"\u01b3\u01b4\7<\2\2\u01b4\u01b5\7p\2\2\u01b5\u01b6\7c\2\2\u01b6\u01b7"+
		"\7o\2\2\u01b7\u01b8\7g\2\2\u01b8\u01b9\7<\2\2\u01b9\u01ba\3\2\2\2\u01ba"+
		"\u01bb\b!\t\2\u01bbF\3\2\2\2\u01bc\u01bd\7\61\2\2\u01bd\u01be\7,\2\2\u01be"+
		"\u01c2\3\2\2\2\u01bf\u01c1\13\2\2\2\u01c0\u01bf\3\2\2\2\u01c1\u01c4\3"+
		"\2\2\2\u01c2\u01c3\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4"+
		"\u01c2\3\2\2\2\u01c5\u01c6\7,\2\2\u01c6\u01c7\7\61\2\2\u01c7\u01c8\3\2"+
		"\2\2\u01c8\u01c9\b\"\2\2\u01c9H\3\2\2\2\u01ca\u01cb\7\61\2\2\u01cb\u01cc"+
		"\7\61\2\2\u01cc\u01d0\3\2\2\2\u01cd\u01cf\n\3\2\2\u01ce\u01cd\3\2\2\2"+
		"\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d3"+
		"\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01d4\b#\2\2\u01d4J\3\2\2\2\u01d5\u01d7"+
		"\7\17\2\2\u01d6\u01d5\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d8\3\2\2\2"+
		"\u01d8\u01d9\7\f\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\b$\2\2\u01dbL\3\2"+
		"\2\2\u01dc\u01dd\t\4\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\b%\2\2\u01df"+
		"N\3\2\2\2\u01e0\u01e1\7\60\2\2\u01e1\u01e2\7u\2\2\u01e2\u01e3\7g\2\2\u01e3"+
		"\u01e4\7p\2\2\u01e4\u01e5\7f\2\2\u01e5P\3\2\2\2\u01e6\u01e7\7\60\2\2\u01e7"+
		"\u01e8\7t\2\2\u01e8\u01e9\7g\2\2\u01e9\u01ea\7e\2\2\u01ea\u01eb\7g\2\2"+
		"\u01eb\u01ec\7k\2\2\u01ec\u01ed\7x\2\2\u01ed\u01ee\7g\2\2\u01ee\u01ef"+
		"\7f\2\2\u01efR\3\2\2\2\u01f0\u01f4\6(\4\2\u01f1\u01f5\7D\2\2\u01f2\u01f3"+
		"\7\60\2\2\u01f3\u01f5\7D\2\2\u01f4\u01f1\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5"+
		"T\3\2\2\2\u01f6\u01fa\6)\5\2\u01f7\u01fb\7I\2\2\u01f8\u01f9\7\60\2\2\u01f9"+
		"\u01fb\7I\2\2\u01fa\u01f7\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fbV\3\2\2\2\u01fc"+
		"\u01fd\7\60\2\2\u01fd\u01fe\7u\2\2\u01fe\u01ff\7g\2\2\u01ff\u0200\7p\2"+
		"\2\u0200\u0201\7v\2\2\u0201X\3\2\2\2\u0202\u0203\7\60\2\2\u0203\u0204"+
		"\7n\2\2\u0204\u0205\7q\2\2\u0205\u0206\7e\2\2\u0206\u0207\7m\2\2\u0207"+
		"Z\3\2\2\2\u0208\u0209\7c\2\2\u0209\u020a\7e\2\2\u020a\u020b\7j\2\2\u020b"+
		"\u020c\7k\2\2\u020c\u020d\7g\2\2\u020d\u020e\7x\2\2\u020e\u020f\7g\2\2"+
		"\u020f\\\3\2\2\2\u0210\u0211\7r\2\2\u0211\u0212\7g\2\2\u0212\u0213\7t"+
		"\2\2\u0213\u0214\7h\2\2\u0214\u0215\7q\2\2\u0215\u0216\7t\2\2\u0216\u0217"+
		"\7o\2\2\u0217^\3\2\2\2\u0218\u0219\7]\2\2\u0219`\3\2\2\2\u021a\u021b\7"+
		"_\2\2\u021bb\3\2\2\2\u021c\u021d\6\60\6\2\u021d\u021e\7\u0080\2\2\u021e"+
		"d\3\2\2\2\u021f\u0220\7<\2\2\u0220f\3\2\2\2\u0221\u0222\7}\2\2\u0222\u0223"+
		"\b\62\n\2\u0223h\3\2\2\2\u0224\u0225\7\177\2\2\u0225\u0226\b\63\13\2\u0226"+
		"j\3\2\2\2\u0227\u0228\7.\2\2\u0228l\3\2\2\2\u0229\u022a\7=\2\2\u022an"+
		"\3\2\2\2\u022b\u022c\7<\2\2\u022c\u022d\7v\2\2\u022d\u022e\7g\2\2\u022e"+
		"\u022f\7n\2\2\u022f\u0230\7n\2\2\u0230p\3\2\2\2\u0231\u0232\7#\2\2\u0232"+
		"r\3\2\2\2\u0233\u0234\7*\2\2\u0234\u0235\b8\f\2\u0235t\3\2\2\2\u0236\u0237"+
		"\7+\2\2\u0237\u0238\b9\r\2\u0238v\3\2\2\2\u0239\u023a\7,\2\2\u023ax\3"+
		"\2\2\2\u023b\u023c\7-\2\2\u023cz\3\2\2\2\u023d\u023e\7/\2\2\u023e|\3\2"+
		"\2\2\u023f\u0240\7>\2\2\u0240~\3\2\2\2\u0241\u0242\7?\2\2\u0242\u0243"+
		"\7?\2\2\u0243\u0080\3\2\2\2\u0244\u0245\7\60\2\2\u0245\u0082\3\2\2\2\u0246"+
		"\u0247\7>\2\2\u0247\u0248\7/\2\2\u0248\u0084\3\2\2\2\u0249\u024a\7V\2"+
		"\2\u024a\u024b\7t\2\2\u024b\u024c\7w\2\2\u024c\u024d\7g\2\2\u024d\u0086"+
		"\3\2\2\2\u024e\u0250\4c|\2\u024f\u0251\t\2\2\2\u0250\u024f\3\2\2\2\u0251"+
		"\u0252\3\2\2\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0088\3\2"+
		"\2\2\u0254\u0258\t\t\2\2\u0255\u0257\t\2\2\2\u0256\u0255\3\2\2\2\u0257"+
		"\u025a\3\2\2\2\u0258\u0256\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u008a\3\2"+
		"\2\2\u025a\u0258\3\2\2\2\u025b\u025d\4\62;\2\u025c\u025b\3\2\2\2\u025d"+
		"\u025e\3\2\2\2\u025e\u025c\3\2\2\2\u025e\u025f\3\2\2\2\u025f\u008c\3\2"+
		"\2\2\u0260\u0264\7$\2\2\u0261\u0263\13\2\2\2\u0262\u0261\3\2\2\2\u0263"+
		"\u0266\3\2\2\2\u0264\u0265\3\2\2\2\u0264\u0262\3\2\2\2\u0265\u0267\3\2"+
		"\2\2\u0266\u0264\3\2\2\2\u0267\u0271\7$\2\2\u0268\u026c\7)\2\2\u0269\u026b"+
		"\13\2\2\2\u026a\u0269\3\2\2\2\u026b\u026e\3\2\2\2\u026c\u026d\3\2\2\2"+
		"\u026c\u026a\3\2\2\2\u026d\u026f\3\2\2\2\u026e\u026c\3\2\2\2\u026f\u0271"+
		"\7)\2\2\u0270\u0260\3\2\2\2\u0270\u0268\3\2\2\2\u0271\u008e\3\2\2\2#\2"+
		"\3\4\5\6\u00a3\u00ab\u00b9\u00bf\u0109\u0117\u011d\u012a\u0144\u0152\u0158"+
		"\u0164\u0166\u0178\u0186\u018c\u01b1\u01c2\u01d0\u01d6\u01f4\u01fa\u0252"+
		"\u0258\u025e\u0264\u026c\u0270\16\b\2\2\4\3\2\4\4\2\4\5\2\4\6\2\3\36\2"+
		"\3\37\3\4\2\2\3\62\4\3\63\5\38\6\39\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}