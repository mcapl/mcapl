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
		PL_NEWLINE=35, PL_WS=36, SEND=37, RECEIVED=38, BELIEVE=39, GOAL=40, LOCK=41, 
		PL_ACHIEVEGOAL=42, PL_PERFORMGOAL=43, PL_SQOPEN=44, PL_SQCLOSE=45, NOT=46, 
		COLON=47, CURLYOPEN=48, CURLYCLOSE=49, COMMA=50, SEMI=51, TELL=52, SHRIEK=53, 
		OPEN=54, CLOSE=55, MULT=56, PLUS=57, MINUS=58, LESS=59, EQUAL=60, IDPUNCT=61, 
		RULEARROW=62, TRUE=63, PL_CONST=64, PL_VAR=65, NUMBER=66, QUOTED_STRING=67;
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
		"PL_NEWLINE", "PL_WS", "SEND", "RECEIVED", "BELIEVE", "GOAL", "LOCK", 
		"PL_ACHIEVEGOAL", "PL_PERFORMGOAL", "PL_SQOPEN", "PL_SQCLOSE", "NOT", 
		"COLON", "CURLYOPEN", "CURLYCLOSE", "COMMA", "SEMI", "TELL", "SHRIEK", 
		"OPEN", "CLOSE", "MULT", "PLUS", "MINUS", "LESS", "EQUAL", "IDPUNCT", 
		"RULEARROW", "TRUE", "PL_CONST", "PL_VAR", "NUMBER", "QUOTED_STRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'GWENDOLEN'", "':name:'", null, null, null, null, null, "':Initial Beliefs:'", 
		"':Reasoning Rules:'", null, null, null, null, null, null, null, null, 
		null, null, null, null, "':Plans:'", null, null, null, null, null, null, 
		null, null, null, "':name'", null, null, null, null, "'.send'", "'.received'", 
		null, null, "'.lock'", "'achieve'", "'perform'", null, null, null, "':'", 
		"'{'", "'}'", "','", "';'", "':tell'", "'!'", "'('", "')'", "'*'", "'+'", 
		"'-'", "'<'", "'=='", "'.'", "'<-'", "'True'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "GWENDOLEN", "NAME", "CONST", "COMMENT", "LINE_COMMENT", "NEWLINE", 
		"WS", "BELIEFS", "BELIEFRULES", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", 
		"IB_NEWLINE", "IB_WS", "BELIEF_BLOCK", "GOAL_RR", "RR_COMMENT", "RR_LINE_COMMENT", 
		"RR_NEWLINE", "RR_WS", "RR_BLOCK", "PLANS", "GL_COMMENT", "GL_LINE_COMMENT", 
		"GL_NEWLINE", "GL_WS", "GL_ACHIEVEGOAL", "GL_PERFORMGOAL", "GL_SQOPEN", 
		"GL_SQCLOSE", "GOAL_BLOCK", "NAME_PM", "PL_COMMENT", "PL_LINE_COMMENT", 
		"PL_NEWLINE", "PL_WS", "SEND", "RECEIVED", "BELIEVE", "GOAL", "LOCK", 
		"PL_ACHIEVEGOAL", "PL_PERFORMGOAL", "PL_SQOPEN", "PL_SQCLOSE", "NOT", 
		"COLON", "CURLYOPEN", "CURLYCLOSE", "COMMA", "SEMI", "TELL", "SHRIEK", 
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
		case 47:
			CURLYOPEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 48:
			CURLYCLOSE_action((RuleContext)_localctx, actionIndex);
			break;
		case 53:
			OPEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 54:
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
		case 45:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2E\u0269\b\1\b\1\b"+
		"\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t"+
		"\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4"+
		"\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
		"\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4"+
		"\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)"+
		"\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\6\4\u00a0"+
		"\n\4\r\4\16\4\u00a1\3\5\3\5\3\5\3\5\7\5\u00a8\n\5\f\5\16\5\u00ab\13\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\u00b6\n\6\f\6\16\6\u00b9\13\6"+
		"\3\6\3\6\3\7\5\7\u00be\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u0106\n\f\f\f\16\f\u0109"+
		"\13\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u0114\n\r\f\r\16\r\u0117"+
		"\13\r\3\r\3\r\3\16\5\16\u011c\n\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\20\6\20\u0127\n\20\r\20\16\20\u0128\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\7\22\u0141\n\22\f\22\16\22\u0144\13\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\7\23\u014f\n\23\f\23\16\23\u0152\13\23\3"+
		"\23\3\23\3\24\5\24\u0157\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\6\26\u0163\n\26\r\26\16\26\u0164\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u0175\n\30\f\30\16\30"+
		"\u0178\13\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u0183\n"+
		"\31\f\31\16\31\u0186\13\31\3\31\3\31\3\32\5\32\u018b\n\32\3\32\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3 \6 \u01ae\n \r \16 \u01af\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3"+
		"\"\3\"\7\"\u01be\n\"\f\"\16\"\u01c1\13\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#"+
		"\3#\7#\u01cc\n#\f#\16#\u01cf\13#\3#\3#\3$\5$\u01d4\n$\3$\3$\3$\3$\3%\3"+
		"%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3"+
		"(\3(\3(\5(\u01f2\n(\3)\3)\3)\3)\5)\u01f8\n)\3*\3*\3*\3*\3*\3*\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3.\3.\3/\3/\3/\3\60\3\60"+
		"\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\3:\3:\3;\3;\3<\3<\3"+
		"=\3=\3=\3>\3>\3?\3?\3?\3@\3@\3@\3@\3@\3A\3A\6A\u0248\nA\rA\16A\u0249\3"+
		"B\3B\7B\u024e\nB\fB\16B\u0251\13B\3C\6C\u0254\nC\rC\16C\u0255\3D\3D\7"+
		"D\u025a\nD\fD\16D\u025d\13D\3D\3D\3D\7D\u0262\nD\fD\16D\u0265\13D\3D\5"+
		"D\u0268\nD\t\u00a9\u0107\u0142\u0176\u01bf\u025b\u0263\2E\7\3\t\4\13\5"+
		"\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23"+
		")\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A C!E\"G#I$K%"+
		"M&O\'Q(S)U*W+Y,[-]._/a\60c\61e\62g\63i\64k\65m\66o\67q8s9u:w;y<{=}>\177"+
		"?\u0081@\u0083A\u0085B\u0087C\u0089D\u008bE\7\2\3\4\5\6\b\6\2\62;C\\a"+
		"ac|\3\2\f\f\4\2\13\13\"\"\n\2\"\"*+..\60\60\62;C\\aac|\b\2*+..\62;C\\"+
		"aac|\4\2\"\"==\2\u0281\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\3"+
		"\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2\2\2\3\37\3\2\2\2\3!\3\2\2\2\3#\3\2\2"+
		"\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3\2\2\2\4+\3\2\2\2\4-\3\2\2\2\4/\3\2\2\2"+
		"\5\61\3\2\2\2\5\63\3\2\2\2\5\65\3\2\2\2\5\67\3\2\2\2\59\3\2\2\2\5;\3\2"+
		"\2\2\5=\3\2\2\2\5?\3\2\2\2\5A\3\2\2\2\5C\3\2\2\2\6E\3\2\2\2\6G\3\2\2\2"+
		"\6I\3\2\2\2\6K\3\2\2\2\6M\3\2\2\2\6O\3\2\2\2\6Q\3\2\2\2\6S\3\2\2\2\6U"+
		"\3\2\2\2\6W\3\2\2\2\6Y\3\2\2\2\6[\3\2\2\2\6]\3\2\2\2\6_\3\2\2\2\6a\3\2"+
		"\2\2\6c\3\2\2\2\6e\3\2\2\2\6g\3\2\2\2\6i\3\2\2\2\6k\3\2\2\2\6m\3\2\2\2"+
		"\6o\3\2\2\2\6q\3\2\2\2\6s\3\2\2\2\6u\3\2\2\2\6w\3\2\2\2\6y\3\2\2\2\6{"+
		"\3\2\2\2\6}\3\2\2\2\6\177\3\2\2\2\6\u0081\3\2\2\2\6\u0083\3\2\2\2\6\u0085"+
		"\3\2\2\2\6\u0087\3\2\2\2\6\u0089\3\2\2\2\6\u008b\3\2\2\2\7\u008d\3\2\2"+
		"\2\t\u0097\3\2\2\2\13\u009f\3\2\2\2\r\u00a3\3\2\2\2\17\u00b1\3\2\2\2\21"+
		"\u00bd\3\2\2\2\23\u00c3\3\2\2\2\25\u00c7\3\2\2\2\27\u00db\3\2\2\2\31\u00ef"+
		"\3\2\2\2\33\u0101\3\2\2\2\35\u010f\3\2\2\2\37\u011b\3\2\2\2!\u0121\3\2"+
		"\2\2#\u0126\3\2\2\2%\u012a\3\2\2\2\'\u013c\3\2\2\2)\u014a\3\2\2\2+\u0156"+
		"\3\2\2\2-\u015a\3\2\2\2/\u0162\3\2\2\2\61\u0166\3\2\2\2\63\u0170\3\2\2"+
		"\2\65\u017e\3\2\2\2\67\u018a\3\2\2\29\u0190\3\2\2\2;\u0194\3\2\2\2=\u019d"+
		"\3\2\2\2?\u01a6\3\2\2\2A\u01a9\3\2\2\2C\u01ad\3\2\2\2E\u01b1\3\2\2\2G"+
		"\u01b9\3\2\2\2I\u01c7\3\2\2\2K\u01d3\3\2\2\2M\u01d9\3\2\2\2O\u01dd\3\2"+
		"\2\2Q\u01e3\3\2\2\2S\u01ed\3\2\2\2U\u01f3\3\2\2\2W\u01f9\3\2\2\2Y\u01ff"+
		"\3\2\2\2[\u0207\3\2\2\2]\u020f\3\2\2\2_\u0211\3\2\2\2a\u0213\3\2\2\2c"+
		"\u0216\3\2\2\2e\u0218\3\2\2\2g\u021b\3\2\2\2i\u021e\3\2\2\2k\u0220\3\2"+
		"\2\2m\u0222\3\2\2\2o\u0228\3\2\2\2q\u022a\3\2\2\2s\u022d\3\2\2\2u\u0230"+
		"\3\2\2\2w\u0232\3\2\2\2y\u0234\3\2\2\2{\u0236\3\2\2\2}\u0238\3\2\2\2\177"+
		"\u023b\3\2\2\2\u0081\u023d\3\2\2\2\u0083\u0240\3\2\2\2\u0085\u0245\3\2"+
		"\2\2\u0087\u024b\3\2\2\2\u0089\u0253\3\2\2\2\u008b\u0267\3\2\2\2\u008d"+
		"\u008e\7I\2\2\u008e\u008f\7Y\2\2\u008f\u0090\7G\2\2\u0090\u0091\7P\2\2"+
		"\u0091\u0092\7F\2\2\u0092\u0093\7Q\2\2\u0093\u0094\7N\2\2\u0094\u0095"+
		"\7G\2\2\u0095\u0096\7P\2\2\u0096\b\3\2\2\2\u0097\u0098\7<\2\2\u0098\u0099"+
		"\7p\2\2\u0099\u009a\7c\2\2\u009a\u009b\7o\2\2\u009b\u009c\7g\2\2\u009c"+
		"\u009d\7<\2\2\u009d\n\3\2\2\2\u009e\u00a0\t\2\2\2\u009f\u009e\3\2\2\2"+
		"\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\f\3"+
		"\2\2\2\u00a3\u00a4\7\61\2\2\u00a4\u00a5\7,\2\2\u00a5\u00a9\3\2\2\2\u00a6"+
		"\u00a8\13\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00aa\3"+
		"\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac"+
		"\u00ad\7,\2\2\u00ad\u00ae\7\61\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\b\5"+
		"\2\2\u00b0\16\3\2\2\2\u00b1\u00b2\7\61\2\2\u00b2\u00b3\7\61\2\2\u00b3"+
		"\u00b7\3\2\2\2\u00b4\u00b6\n\3\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00bb\b\6\2\2\u00bb\20\3\2\2\2\u00bc\u00be\7\17\2"+
		"\2\u00bd\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0"+
		"\7\f\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\b\7\2\2\u00c2\22\3\2\2\2\u00c3"+
		"\u00c4\t\4\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\b\b\2\2\u00c6\24\3\2\2"+
		"\2\u00c7\u00c8\7<\2\2\u00c8\u00c9\7K\2\2\u00c9\u00ca\7p\2\2\u00ca\u00cb"+
		"\7k\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7c\2\2\u00ce"+
		"\u00cf\7n\2\2\u00cf\u00d0\7\"\2\2\u00d0\u00d1\7D\2\2\u00d1\u00d2\7g\2"+
		"\2\u00d2\u00d3\7n\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6"+
		"\7h\2\2\u00d6\u00d7\7u\2\2\u00d7\u00d8\7<\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00da\b\t\3\2\u00da\26\3\2\2\2\u00db\u00dc\7<\2\2\u00dc\u00dd\7T\2\2"+
		"\u00dd\u00de\7g\2\2\u00de\u00df\7c\2\2\u00df\u00e0\7u\2\2\u00e0\u00e1"+
		"\7q\2\2\u00e1\u00e2\7p\2\2\u00e2\u00e3\7k\2\2\u00e3\u00e4\7p\2\2\u00e4"+
		"\u00e5\7i\2\2\u00e5\u00e6\7\"\2\2\u00e6\u00e7\7T\2\2\u00e7\u00e8\7w\2"+
		"\2\u00e8\u00e9\7n\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7u\2\2\u00eb\u00ec"+
		"\7<\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\b\n\4\2\u00ee\30\3\2\2\2\u00ef"+
		"\u00f0\7<\2\2\u00f0\u00f1\7K\2\2\u00f1\u00f2\7p\2\2\u00f2\u00f3\7k\2\2"+
		"\u00f3\u00f4\7v\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7"+
		"\7n\2\2\u00f7\u00f8\7\"\2\2\u00f8\u00f9\7I\2\2\u00f9\u00fa\7q\2\2\u00fa"+
		"\u00fb\7c\2\2\u00fb\u00fc\7n\2\2\u00fc\u00fd\7u\2\2\u00fd\u00fe\7<\2\2"+
		"\u00fe\u00ff\3\2\2\2\u00ff\u0100\b\13\5\2\u0100\32\3\2\2\2\u0101\u0102"+
		"\7\61\2\2\u0102\u0103\7,\2\2\u0103\u0107\3\2\2\2\u0104\u0106\13\2\2\2"+
		"\u0105\u0104\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0108\3\2\2\2\u0107\u0105"+
		"\3\2\2\2\u0108\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010b\7,\2\2\u010b"+
		"\u010c\7\61\2\2\u010c\u010d\3\2\2\2\u010d\u010e\b\f\2\2\u010e\34\3\2\2"+
		"\2\u010f\u0110\7\61\2\2\u0110\u0111\7\61\2\2\u0111\u0115\3\2\2\2\u0112"+
		"\u0114\n\3\2\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117\u0115\3\2\2\2\u0118"+
		"\u0119\b\r\2\2\u0119\36\3\2\2\2\u011a\u011c\7\17\2\2\u011b\u011a\3\2\2"+
		"\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\7\f\2\2\u011e\u011f"+
		"\3\2\2\2\u011f\u0120\b\16\2\2\u0120 \3\2\2\2\u0121\u0122\t\4\2\2\u0122"+
		"\u0123\3\2\2\2\u0123\u0124\b\17\2\2\u0124\"\3\2\2\2\u0125\u0127\t\5\2"+
		"\2\u0126\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129"+
		"\3\2\2\2\u0129$\3\2\2\2\u012a\u012b\7<\2\2\u012b\u012c\7K\2\2\u012c\u012d"+
		"\7p\2\2\u012d\u012e\7k\2\2\u012e\u012f\7v\2\2\u012f\u0130\7k\2\2\u0130"+
		"\u0131\7c\2\2\u0131\u0132\7n\2\2\u0132\u0133\7\"\2\2\u0133\u0134\7I\2"+
		"\2\u0134\u0135\7q\2\2\u0135\u0136\7c\2\2\u0136\u0137\7n\2\2\u0137\u0138"+
		"\7u\2\2\u0138\u0139\7<\2\2\u0139\u013a\3\2\2\2\u013a\u013b\b\21\5\2\u013b"+
		"&\3\2\2\2\u013c\u013d\7\61\2\2\u013d\u013e\7,\2\2\u013e\u0142\3\2\2\2"+
		"\u013f\u0141\13\2\2\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0143"+
		"\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145"+
		"\u0146\7,\2\2\u0146\u0147\7\61\2\2\u0147\u0148\3\2\2\2\u0148\u0149\b\22"+
		"\2\2\u0149(\3\2\2\2\u014a\u014b\7\61\2\2\u014b\u014c\7\61\2\2\u014c\u0150"+
		"\3\2\2\2\u014d\u014f\n\3\2\2\u014e\u014d\3\2\2\2\u014f\u0152\3\2\2\2\u0150"+
		"\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0153\3\2\2\2\u0152\u0150\3\2"+
		"\2\2\u0153\u0154\b\23\2\2\u0154*\3\2\2\2\u0155\u0157\7\17\2\2\u0156\u0155"+
		"\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\7\f\2\2\u0159"+
		",\3\2\2\2\u015a\u015b\t\4\2\2\u015b\u015c\3\2\2\2\u015c\u015d\b\25\2\2"+
		"\u015d.\3\2\2\2\u015e\u0163\t\6\2\2\u015f\u0160\7<\2\2\u0160\u0163\7/"+
		"\2\2\u0161\u0163\t\7\2\2\u0162\u015e\3\2\2\2\u0162\u015f\3\2\2\2\u0162"+
		"\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2"+
		"\2\2\u0165\60\3\2\2\2\u0166\u0167\7<\2\2\u0167\u0168\7R\2\2\u0168\u0169"+
		"\7n\2\2\u0169\u016a\7c\2\2\u016a\u016b\7p\2\2\u016b\u016c\7u\2\2\u016c"+
		"\u016d\7<\2\2\u016d\u016e\3\2\2\2\u016e\u016f\b\27\6\2\u016f\62\3\2\2"+
		"\2\u0170\u0171\7\61\2\2\u0171\u0172\7,\2\2\u0172\u0176\3\2\2\2\u0173\u0175"+
		"\13\2\2\2\u0174\u0173\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0177\3\2\2\2"+
		"\u0176\u0174\3\2\2\2\u0177\u0179\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u017a"+
		"\7,\2\2\u017a\u017b\7\61\2\2\u017b\u017c\3\2\2\2\u017c\u017d\b\30\2\2"+
		"\u017d\64\3\2\2\2\u017e\u017f\7\61\2\2\u017f\u0180\7\61\2\2\u0180\u0184"+
		"\3\2\2\2\u0181\u0183\n\3\2\2\u0182\u0181\3\2\2\2\u0183\u0186\3\2\2\2\u0184"+
		"\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0187\3\2\2\2\u0186\u0184\3\2"+
		"\2\2\u0187\u0188\b\31\2\2\u0188\66\3\2\2\2\u0189\u018b\7\17\2\2\u018a"+
		"\u0189\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\7\f"+
		"\2\2\u018d\u018e\3\2\2\2\u018e\u018f\b\32\2\2\u018f8\3\2\2\2\u0190\u0191"+
		"\t\4\2\2\u0191\u0192\3\2\2\2\u0192\u0193\b\33\2\2\u0193:\3\2\2\2\u0194"+
		"\u0195\6\34\2\2\u0195\u0196\7c\2\2\u0196\u0197\7e\2\2\u0197\u0198\7j\2"+
		"\2\u0198\u0199\7k\2\2\u0199\u019a\7g\2\2\u019a\u019b\7x\2\2\u019b\u019c"+
		"\7g\2\2\u019c<\3\2\2\2\u019d\u019e\6\35\3\2\u019e\u019f\7r\2\2\u019f\u01a0"+
		"\7g\2\2\u01a0\u01a1\7t\2\2\u01a1\u01a2\7h\2\2\u01a2\u01a3\7q\2\2\u01a3"+
		"\u01a4\7t\2\2\u01a4\u01a5\7o\2\2\u01a5>\3\2\2\2\u01a6\u01a7\7]\2\2\u01a7"+
		"\u01a8\b\36\7\2\u01a8@\3\2\2\2\u01a9\u01aa\7_\2\2\u01aa\u01ab\b\37\b\2"+
		"\u01abB\3\2\2\2\u01ac\u01ae\t\5\2\2\u01ad\u01ac\3\2\2\2\u01ae\u01af\3"+
		"\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0D\3\2\2\2\u01b1\u01b2"+
		"\7<\2\2\u01b2\u01b3\7p\2\2\u01b3\u01b4\7c\2\2\u01b4\u01b5\7o\2\2\u01b5"+
		"\u01b6\7g\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b8\b!\t\2\u01b8F\3\2\2\2\u01b9"+
		"\u01ba\7\61\2\2\u01ba\u01bb\7,\2\2\u01bb\u01bf\3\2\2\2\u01bc\u01be\13"+
		"\2\2\2\u01bd\u01bc\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01c0\3\2\2\2\u01bf"+
		"\u01bd\3\2\2\2\u01c0\u01c2\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c3\7,"+
		"\2\2\u01c3\u01c4\7\61\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\b\"\2\2\u01c6"+
		"H\3\2\2\2\u01c7\u01c8\7\61\2\2\u01c8\u01c9\7\61\2\2\u01c9\u01cd\3\2\2"+
		"\2\u01ca\u01cc\n\3\2\2\u01cb\u01ca\3\2\2\2\u01cc\u01cf\3\2\2\2\u01cd\u01cb"+
		"\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d0\3\2\2\2\u01cf\u01cd\3\2\2\2\u01d0"+
		"\u01d1\b#\2\2\u01d1J\3\2\2\2\u01d2\u01d4\7\17\2\2\u01d3\u01d2\3\2\2\2"+
		"\u01d3\u01d4\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\7\f\2\2\u01d6\u01d7"+
		"\3\2\2\2\u01d7\u01d8\b$\2\2\u01d8L\3\2\2\2\u01d9\u01da\t\4\2\2\u01da\u01db"+
		"\3\2\2\2\u01db\u01dc\b%\2\2\u01dcN\3\2\2\2\u01dd\u01de\7\60\2\2\u01de"+
		"\u01df\7u\2\2\u01df\u01e0\7g\2\2\u01e0\u01e1\7p\2\2\u01e1\u01e2\7f\2\2"+
		"\u01e2P\3\2\2\2\u01e3\u01e4\7\60\2\2\u01e4\u01e5\7t\2\2\u01e5\u01e6\7"+
		"g\2\2\u01e6\u01e7\7e\2\2\u01e7\u01e8\7g\2\2\u01e8\u01e9\7k\2\2\u01e9\u01ea"+
		"\7x\2\2\u01ea\u01eb\7g\2\2\u01eb\u01ec\7f\2\2\u01ecR\3\2\2\2\u01ed\u01f1"+
		"\6(\4\2\u01ee\u01f2\7D\2\2\u01ef\u01f0\7\60\2\2\u01f0\u01f2\7D\2\2\u01f1"+
		"\u01ee\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f2T\3\2\2\2\u01f3\u01f7\6)\5\2\u01f4"+
		"\u01f8\7I\2\2\u01f5\u01f6\7\60\2\2\u01f6\u01f8\7I\2\2\u01f7\u01f4\3\2"+
		"\2\2\u01f7\u01f5\3\2\2\2\u01f8V\3\2\2\2\u01f9\u01fa\7\60\2\2\u01fa\u01fb"+
		"\7n\2\2\u01fb\u01fc\7q\2\2\u01fc\u01fd\7e\2\2\u01fd\u01fe\7m\2\2\u01fe"+
		"X\3\2\2\2\u01ff\u0200\7c\2\2\u0200\u0201\7e\2\2\u0201\u0202\7j\2\2\u0202"+
		"\u0203\7k\2\2\u0203\u0204\7g\2\2\u0204\u0205\7x\2\2\u0205\u0206\7g\2\2"+
		"\u0206Z\3\2\2\2\u0207\u0208\7r\2\2\u0208\u0209\7g\2\2\u0209\u020a\7t\2"+
		"\2\u020a\u020b\7h\2\2\u020b\u020c\7q\2\2\u020c\u020d\7t\2\2\u020d\u020e"+
		"\7o\2\2\u020e\\\3\2\2\2\u020f\u0210\7]\2\2\u0210^\3\2\2\2\u0211\u0212"+
		"\7_\2\2\u0212`\3\2\2\2\u0213\u0214\6/\6\2\u0214\u0215\7\u0080\2\2\u0215"+
		"b\3\2\2\2\u0216\u0217\7<\2\2\u0217d\3\2\2\2\u0218\u0219\7}\2\2\u0219\u021a"+
		"\b\61\n\2\u021af\3\2\2\2\u021b\u021c\7\177\2\2\u021c\u021d\b\62\13\2\u021d"+
		"h\3\2\2\2\u021e\u021f\7.\2\2\u021fj\3\2\2\2\u0220\u0221\7=\2\2\u0221l"+
		"\3\2\2\2\u0222\u0223\7<\2\2\u0223\u0224\7v\2\2\u0224\u0225\7g\2\2\u0225"+
		"\u0226\7n\2\2\u0226\u0227\7n\2\2\u0227n\3\2\2\2\u0228\u0229\7#\2\2\u0229"+
		"p\3\2\2\2\u022a\u022b\7*\2\2\u022b\u022c\b\67\f\2\u022cr\3\2\2\2\u022d"+
		"\u022e\7+\2\2\u022e\u022f\b8\r\2\u022ft\3\2\2\2\u0230\u0231\7,\2\2\u0231"+
		"v\3\2\2\2\u0232\u0233\7-\2\2\u0233x\3\2\2\2\u0234\u0235\7/\2\2\u0235z"+
		"\3\2\2\2\u0236\u0237\7>\2\2\u0237|\3\2\2\2\u0238\u0239\7?\2\2\u0239\u023a"+
		"\7?\2\2\u023a~\3\2\2\2\u023b\u023c\7\60\2\2\u023c\u0080\3\2\2\2\u023d"+
		"\u023e\7>\2\2\u023e\u023f\7/\2\2\u023f\u0082\3\2\2\2\u0240\u0241\7V\2"+
		"\2\u0241\u0242\7t\2\2\u0242\u0243\7w\2\2\u0243\u0244\7g\2\2\u0244\u0084"+
		"\3\2\2\2\u0245\u0247\4c|\2\u0246\u0248\t\2\2\2\u0247\u0246\3\2\2\2\u0248"+
		"\u0249\3\2\2\2\u0249\u0247\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u0086\3\2"+
		"\2\2\u024b\u024f\4C\\\2\u024c\u024e\t\2\2\2\u024d\u024c\3\2\2\2\u024e"+
		"\u0251\3\2\2\2\u024f\u024d\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0088\3\2"+
		"\2\2\u0251\u024f\3\2\2\2\u0252\u0254\4\62;\2\u0253\u0252\3\2\2\2\u0254"+
		"\u0255\3\2\2\2\u0255\u0253\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u008a\3\2"+
		"\2\2\u0257\u025b\7$\2\2\u0258\u025a\13\2\2\2\u0259\u0258\3\2\2\2\u025a"+
		"\u025d\3\2\2\2\u025b\u025c\3\2\2\2\u025b\u0259\3\2\2\2\u025c\u025e\3\2"+
		"\2\2\u025d\u025b\3\2\2\2\u025e\u0268\7$\2\2\u025f\u0263\7)\2\2\u0260\u0262"+
		"\13\2\2\2\u0261\u0260\3\2\2\2\u0262\u0265\3\2\2\2\u0263\u0264\3\2\2\2"+
		"\u0263\u0261\3\2\2\2\u0264\u0266\3\2\2\2\u0265\u0263\3\2\2\2\u0266\u0268"+
		"\7)\2\2\u0267\u0257\3\2\2\2\u0267\u025f\3\2\2\2\u0268\u008c\3\2\2\2#\2"+
		"\3\4\5\6\u00a1\u00a9\u00b7\u00bd\u0107\u0115\u011b\u0128\u0142\u0150\u0156"+
		"\u0162\u0164\u0176\u0184\u018a\u01af\u01bf\u01cd\u01d3\u01f1\u01f7\u0249"+
		"\u024f\u0255\u025b\u0263\u0267\16\b\2\2\4\3\2\4\4\2\4\5\2\4\6\2\3\36\2"+
		"\3\37\3\4\2\2\3\61\4\3\62\5\3\67\6\38\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}