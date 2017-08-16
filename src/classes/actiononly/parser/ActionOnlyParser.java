// Generated from ActionOnly.g4 by ANTLR 4.7
package actiononly.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ActionOnlyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ACTIONONLY=1, BELIEFS=2, NAME=3, WORD=4, COMMENT=5, LINE_COMMENT=6, NEWLINE=7, 
		WS=8, GOAL_IB=9, IB_COMMENT=10, IB_LINE_COMMENT=11, IB_NEWLINE=12, IB_WS=13, 
		BELIEF_BLOCK=14, GOAL_RR=15, GL_COMMENT=16, GL_LINE_COMMENT=17, GL_NEWLINE=18, 
		GL_WS=19, GOAL_BLOCK=20;
	public static final int
		RULE_mas = 0, RULE_aoagents = 1, RULE_aoagent = 2;
	public static final String[] ruleNames = {
		"mas", "aoagents", "aoagent"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'AO'", "':Initial Beliefs:'", "':name:'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ACTIONONLY", "BELIEFS", "NAME", "WORD", "COMMENT", "LINE_COMMENT", 
		"NEWLINE", "WS", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", "IB_NEWLINE", 
		"IB_WS", "BELIEF_BLOCK", "GOAL_RR", "GL_COMMENT", "GL_LINE_COMMENT", "GL_NEWLINE", 
		"GL_WS", "GOAL_BLOCK"
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

	@Override
	public String getGrammarFileName() { return "ActionOnly.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ActionOnlyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MasContext extends ParserRuleContext {
		public AoagentsContext aoagents() {
			return getRuleContext(AoagentsContext.class,0);
		}
		public MasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mas; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitMas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MasContext mas() throws RecognitionException {
		MasContext _localctx = new MasContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mas);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			aoagents();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AoagentsContext extends ParserRuleContext {
		public TerminalNode ACTIONONLY() { return getToken(ActionOnlyParser.ACTIONONLY, 0); }
		public List<AoagentContext> aoagent() {
			return getRuleContexts(AoagentContext.class);
		}
		public AoagentContext aoagent(int i) {
			return getRuleContext(AoagentContext.class,i);
		}
		public AoagentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aoagents; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitAoagents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AoagentsContext aoagents() throws RecognitionException {
		AoagentsContext _localctx = new AoagentsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_aoagents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(ACTIONONLY);
			setState(10); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(9);
				aoagent();
				}
				}
				setState(12); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ACTIONONLY || _la==NAME );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AoagentContext extends ParserRuleContext {
		public Token w;
		public Token bs;
		public Token gs;
		public TerminalNode NAME() { return getToken(ActionOnlyParser.NAME, 0); }
		public TerminalNode BELIEFS() { return getToken(ActionOnlyParser.BELIEFS, 0); }
		public TerminalNode GOAL_IB() { return getToken(ActionOnlyParser.GOAL_IB, 0); }
		public TerminalNode WORD() { return getToken(ActionOnlyParser.WORD, 0); }
		public TerminalNode GOAL_BLOCK() { return getToken(ActionOnlyParser.GOAL_BLOCK, 0); }
		public TerminalNode BELIEF_BLOCK() { return getToken(ActionOnlyParser.BELIEF_BLOCK, 0); }
		public TerminalNode ACTIONONLY() { return getToken(ActionOnlyParser.ACTIONONLY, 0); }
		public AoagentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aoagent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitAoagent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AoagentContext aoagent() throws RecognitionException {
		AoagentContext _localctx = new AoagentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_aoagent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACTIONONLY) {
				{
				setState(14);
				match(ACTIONONLY);
				}
			}

			}
			setState(17);
			match(NAME);
			setState(18);
			((AoagentContext)_localctx).w = match(WORD);
			setState(19);
			match(BELIEFS);
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BELIEF_BLOCK) {
				{
				setState(20);
				((AoagentContext)_localctx).bs = match(BELIEF_BLOCK);
				}
			}

			setState(23);
			match(GOAL_IB);
			setState(24);
			((AoagentContext)_localctx).gs = match(GOAL_BLOCK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\35\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\3\3\3\6\3\r\n\3\r\3\16\3\16\3\4\5\4\22\n\4\3\4"+
		"\3\4\3\4\3\4\5\4\30\n\4\3\4\3\4\3\4\3\4\2\2\5\2\4\6\2\2\2\34\2\b\3\2\2"+
		"\2\4\n\3\2\2\2\6\21\3\2\2\2\b\t\5\4\3\2\t\3\3\2\2\2\n\f\7\3\2\2\13\r\5"+
		"\6\4\2\f\13\3\2\2\2\r\16\3\2\2\2\16\f\3\2\2\2\16\17\3\2\2\2\17\5\3\2\2"+
		"\2\20\22\7\3\2\2\21\20\3\2\2\2\21\22\3\2\2\2\22\23\3\2\2\2\23\24\7\5\2"+
		"\2\24\25\7\6\2\2\25\27\7\4\2\2\26\30\7\20\2\2\27\26\3\2\2\2\27\30\3\2"+
		"\2\2\30\31\3\2\2\2\31\32\7\13\2\2\32\33\7\26\2\2\33\7\3\2\2\2\5\16\21"+
		"\27";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}