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
		WS=8, BELIEFRULES=9, GOAL_IB=10, IB_COMMENT=11, IB_LINE_COMMENT=12, IB_NEWLINE=13, 
		IB_WS=14, BELIEF_BLOCK=15, GOAL_RR=16, RR_COMMENT=17, RR_LINE_COMMENT=18, 
		RR_NEWLINE=19, RR_WS=20, RR_BLOCK=21, ACTIONS=22, GL_COMMENT=23, GL_LINE_COMMENT=24, 
		GL_NEWLINE=25, GL_WS=26, GOAL_BLOCK=27, CURLYOPEN=28, CURLYCLOSE=29, A_COMMENT=30, 
		A_LINE_COMMENT=31, A_NEWLINE=32, A_WS=33, ACTION_BLOCK=34;
	public static final int
		RULE_mas = 0, RULE_aoagents = 1, RULE_aoagent = 2, RULE_capability = 3;
	public static final String[] ruleNames = {
		"mas", "aoagents", "aoagent", "capability"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'AO'", "':Initial Beliefs:'", "':name:'", null, null, null, null, 
		null, "':Reasoning Rules:'", null, null, null, null, null, null, null, 
		null, null, null, null, null, "':Actions:'", null, null, null, null, null, 
		"'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ACTIONONLY", "BELIEFS", "NAME", "WORD", "COMMENT", "LINE_COMMENT", 
		"NEWLINE", "WS", "BELIEFRULES", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", 
		"IB_NEWLINE", "IB_WS", "BELIEF_BLOCK", "GOAL_RR", "RR_COMMENT", "RR_LINE_COMMENT", 
		"RR_NEWLINE", "RR_WS", "RR_BLOCK", "ACTIONS", "GL_COMMENT", "GL_LINE_COMMENT", 
		"GL_NEWLINE", "GL_WS", "GOAL_BLOCK", "CURLYOPEN", "CURLYCLOSE", "A_COMMENT", 
		"A_LINE_COMMENT", "A_NEWLINE", "A_WS", "ACTION_BLOCK"
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
			setState(8);
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
			setState(10);
			match(ACTIONONLY);
			setState(12); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(11);
				aoagent();
				}
				}
				setState(14); 
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
		public CapabilityContext c;
		public TerminalNode NAME() { return getToken(ActionOnlyParser.NAME, 0); }
		public TerminalNode BELIEFS() { return getToken(ActionOnlyParser.BELIEFS, 0); }
		public TerminalNode ACTIONS() { return getToken(ActionOnlyParser.ACTIONS, 0); }
		public TerminalNode WORD() { return getToken(ActionOnlyParser.WORD, 0); }
		public TerminalNode GOAL_RR() { return getToken(ActionOnlyParser.GOAL_RR, 0); }
		public TerminalNode GOAL_IB() { return getToken(ActionOnlyParser.GOAL_IB, 0); }
		public List<TerminalNode> GL_NEWLINE() { return getTokens(ActionOnlyParser.GL_NEWLINE); }
		public TerminalNode GL_NEWLINE(int i) {
			return getToken(ActionOnlyParser.GL_NEWLINE, i);
		}
		public List<TerminalNode> IB_NEWLINE() { return getTokens(ActionOnlyParser.IB_NEWLINE); }
		public TerminalNode IB_NEWLINE(int i) {
			return getToken(ActionOnlyParser.IB_NEWLINE, i);
		}
		public TerminalNode BELIEFRULES() { return getToken(ActionOnlyParser.BELIEFRULES, 0); }
		public List<TerminalNode> GOAL_BLOCK() { return getTokens(ActionOnlyParser.GOAL_BLOCK); }
		public TerminalNode GOAL_BLOCK(int i) {
			return getToken(ActionOnlyParser.GOAL_BLOCK, i);
		}
		public List<CapabilityContext> capability() {
			return getRuleContexts(CapabilityContext.class);
		}
		public CapabilityContext capability(int i) {
			return getRuleContext(CapabilityContext.class,i);
		}
		public TerminalNode ACTIONONLY() { return getToken(ActionOnlyParser.ACTIONONLY, 0); }
		public List<TerminalNode> RR_BLOCK() { return getTokens(ActionOnlyParser.RR_BLOCK); }
		public TerminalNode RR_BLOCK(int i) {
			return getToken(ActionOnlyParser.RR_BLOCK, i);
		}
		public List<TerminalNode> RR_NEWLINE() { return getTokens(ActionOnlyParser.RR_NEWLINE); }
		public TerminalNode RR_NEWLINE(int i) {
			return getToken(ActionOnlyParser.RR_NEWLINE, i);
		}
		public List<TerminalNode> BELIEF_BLOCK() { return getTokens(ActionOnlyParser.BELIEF_BLOCK); }
		public TerminalNode BELIEF_BLOCK(int i) {
			return getToken(ActionOnlyParser.BELIEF_BLOCK, i);
		}
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
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACTIONONLY) {
				{
				setState(16);
				match(ACTIONONLY);
				}
			}

			}
			setState(19);
			match(NAME);
			setState(20);
			((AoagentContext)_localctx).w = match(WORD);
			setState(21);
			match(BELIEFS);
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IB_NEWLINE || _la==BELIEF_BLOCK) {
				{
				{
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BELIEF_BLOCK) {
					{
					setState(22);
					((AoagentContext)_localctx).bs = match(BELIEF_BLOCK);
					}
				}

				setState(25);
				match(IB_NEWLINE);
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BELIEFRULES) {
				{
				setState(31);
				match(BELIEFRULES);
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_NEWLINE) {
					{
					{
					setState(32);
					match(RR_NEWLINE);
					}
					}
					setState(37);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				{
				setState(38);
				match(RR_BLOCK);
				setState(39);
				match(RR_NEWLINE);
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_NEWLINE || _la==RR_BLOCK) {
					{
					{
					setState(42);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==RR_BLOCK) {
						{
						setState(41);
						match(RR_BLOCK);
						}
					}

					setState(44);
					match(RR_NEWLINE);
					}
					}
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(52);
			_la = _input.LA(1);
			if ( !(_la==GOAL_IB || _la==GOAL_RR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GL_NEWLINE) {
				{
				{
				setState(53);
				match(GL_NEWLINE);
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(59);
			((AoagentContext)_localctx).gs = match(GOAL_BLOCK);
			setState(60);
			match(GL_NEWLINE);
			}
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GL_NEWLINE || _la==GOAL_BLOCK) {
				{
				{
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GOAL_BLOCK) {
					{
					setState(62);
					match(GOAL_BLOCK);
					}
				}

				setState(65);
				match(GL_NEWLINE);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(ACTIONS);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CURLYOPEN) {
				{
				{
				setState(72);
				((AoagentContext)_localctx).c = capability();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class CapabilityContext extends ParserRuleContext {
		public Token pres;
		public Token a;
		public TerminalNode CURLYOPEN() { return getToken(ActionOnlyParser.CURLYOPEN, 0); }
		public TerminalNode CURLYCLOSE() { return getToken(ActionOnlyParser.CURLYCLOSE, 0); }
		public List<TerminalNode> ACTION_BLOCK() { return getTokens(ActionOnlyParser.ACTION_BLOCK); }
		public TerminalNode ACTION_BLOCK(int i) {
			return getToken(ActionOnlyParser.ACTION_BLOCK, i);
		}
		public CapabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capability; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitCapability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CapabilityContext capability() throws RecognitionException {
		CapabilityContext _localctx = new CapabilityContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_capability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(CURLYOPEN);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACTION_BLOCK) {
				{
				setState(79);
				((CapabilityContext)_localctx).pres = match(ACTION_BLOCK);
				}
			}

			setState(82);
			match(CURLYCLOSE);
			setState(83);
			((CapabilityContext)_localctx).a = match(ACTION_BLOCK);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$X\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\3\2\3\2\3\3\3\3\6\3\17\n\3\r\3\16\3\20\3\4\5\4\24\n\4"+
		"\3\4\3\4\3\4\3\4\5\4\32\n\4\3\4\7\4\35\n\4\f\4\16\4 \13\4\3\4\3\4\7\4"+
		"$\n\4\f\4\16\4\'\13\4\3\4\3\4\3\4\3\4\5\4-\n\4\3\4\7\4\60\n\4\f\4\16\4"+
		"\63\13\4\5\4\65\n\4\3\4\3\4\7\49\n\4\f\4\16\4<\13\4\3\4\3\4\3\4\3\4\5"+
		"\4B\n\4\3\4\7\4E\n\4\f\4\16\4H\13\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3"+
		"\5\3\5\5\5S\n\5\3\5\3\5\3\5\3\5\2\2\6\2\4\6\b\2\3\4\2\f\f\22\22\2`\2\n"+
		"\3\2\2\2\4\f\3\2\2\2\6\23\3\2\2\2\bP\3\2\2\2\n\13\5\4\3\2\13\3\3\2\2\2"+
		"\f\16\7\3\2\2\r\17\5\6\4\2\16\r\3\2\2\2\17\20\3\2\2\2\20\16\3\2\2\2\20"+
		"\21\3\2\2\2\21\5\3\2\2\2\22\24\7\3\2\2\23\22\3\2\2\2\23\24\3\2\2\2\24"+
		"\25\3\2\2\2\25\26\7\5\2\2\26\27\7\6\2\2\27\36\7\4\2\2\30\32\7\21\2\2\31"+
		"\30\3\2\2\2\31\32\3\2\2\2\32\33\3\2\2\2\33\35\7\17\2\2\34\31\3\2\2\2\35"+
		" \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\64\3\2\2\2 \36\3\2\2\2!%\7\13"+
		"\2\2\"$\7\25\2\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'"+
		"%\3\2\2\2()\7\27\2\2)*\7\25\2\2*\61\3\2\2\2+-\7\27\2\2,+\3\2\2\2,-\3\2"+
		"\2\2-.\3\2\2\2.\60\7\25\2\2/,\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62"+
		"\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\64!\3\2\2\2\64\65\3\2\2\2\65\66\3"+
		"\2\2\2\66:\t\2\2\2\679\7\33\2\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2"+
		"\2\2;=\3\2\2\2<:\3\2\2\2=>\7\35\2\2>?\7\33\2\2?F\3\2\2\2@B\7\35\2\2A@"+
		"\3\2\2\2AB\3\2\2\2BC\3\2\2\2CE\7\33\2\2DA\3\2\2\2EH\3\2\2\2FD\3\2\2\2"+
		"FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IM\7\30\2\2JL\5\b\5\2KJ\3\2\2\2LO\3\2\2"+
		"\2MK\3\2\2\2MN\3\2\2\2N\7\3\2\2\2OM\3\2\2\2PR\7\36\2\2QS\7$\2\2RQ\3\2"+
		"\2\2RS\3\2\2\2ST\3\2\2\2TU\7\37\2\2UV\7$\2\2V\t\3\2\2\2\17\20\23\31\36"+
		"%,\61\64:AFMR";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}