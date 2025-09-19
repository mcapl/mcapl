// Generated from /Users/louisedennis/IdeaProjects/mcapl/src/classes/actiononly/parser/antlr/ActionOnly.g4 by ANTLR 4.13.1
package actiononly.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ActionOnlyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

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
	private static String[] makeRuleNames() {
		return new String[] {
			"mas", "aoagents", "aoagent", "capability"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'AO'", "':Initial Beliefs:'", "':name:'", null, null, null, null, 
			null, "':Reasoning Rules:'", null, null, null, null, null, null, null, 
			null, null, null, null, null, "':Actions:'", null, null, null, null, 
			null, "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ACTIONONLY", "BELIEFS", "NAME", "WORD", "COMMENT", "LINE_COMMENT", 
			"NEWLINE", "WS", "BELIEFRULES", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", 
			"IB_NEWLINE", "IB_WS", "BELIEF_BLOCK", "GOAL_RR", "RR_COMMENT", "RR_LINE_COMMENT", 
			"RR_NEWLINE", "RR_WS", "RR_BLOCK", "ACTIONS", "GL_COMMENT", "GL_LINE_COMMENT", 
			"GL_NEWLINE", "GL_WS", "GOAL_BLOCK", "CURLYOPEN", "CURLYCLOSE", "A_COMMENT", 
			"A_LINE_COMMENT", "A_NEWLINE", "A_WS", "ACTION_BLOCK"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
		"\u0004\u0001\"V\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0004\u0001\r\b\u0001\u000b\u0001\f\u0001\u000e\u0001"+
		"\u0002\u0003\u0002\u0012\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002\u0018\b\u0002\u0001\u0002\u0005\u0002\u001b\b\u0002"+
		"\n\u0002\f\u0002\u001e\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002\"\b"+
		"\u0002\n\u0002\f\u0002%\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002+\b\u0002\u0001\u0002\u0005\u0002.\b\u0002\n\u0002\f"+
		"\u00021\t\u0002\u0003\u00023\b\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"7\b\u0002\n\u0002\f\u0002:\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002@\b\u0002\u0001\u0002\u0005\u0002C\b\u0002\n\u0002"+
		"\f\u0002F\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002J\b\u0002\n\u0002"+
		"\f\u0002M\t\u0002\u0001\u0003\u0001\u0003\u0003\u0003Q\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0000\u0000\u0004\u0000\u0002\u0004"+
		"\u0006\u0000\u0001\u0002\u0000\n\n\u0010\u0010^\u0000\b\u0001\u0000\u0000"+
		"\u0000\u0002\n\u0001\u0000\u0000\u0000\u0004\u0011\u0001\u0000\u0000\u0000"+
		"\u0006N\u0001\u0000\u0000\u0000\b\t\u0003\u0002\u0001\u0000\t\u0001\u0001"+
		"\u0000\u0000\u0000\n\f\u0005\u0001\u0000\u0000\u000b\r\u0003\u0004\u0002"+
		"\u0000\f\u000b\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000"+
		"\u000e\f\u0001\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f"+
		"\u0003\u0001\u0000\u0000\u0000\u0010\u0012\u0005\u0001\u0000\u0000\u0011"+
		"\u0010\u0001\u0000\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012"+
		"\u0013\u0001\u0000\u0000\u0000\u0013\u0014\u0005\u0003\u0000\u0000\u0014"+
		"\u0015\u0005\u0004\u0000\u0000\u0015\u001c\u0005\u0002\u0000\u0000\u0016"+
		"\u0018\u0005\u000f\u0000\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000\u0000\u0000\u0019"+
		"\u001b\u0005\r\u0000\u0000\u001a\u0017\u0001\u0000\u0000\u0000\u001b\u001e"+
		"\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0001\u0000\u0000\u0000\u001d2\u0001\u0000\u0000\u0000\u001e\u001c\u0001"+
		"\u0000\u0000\u0000\u001f#\u0005\t\u0000\u0000 \"\u0005\u0013\u0000\u0000"+
		"! \u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000"+
		"\u0000#$\u0001\u0000\u0000\u0000$&\u0001\u0000\u0000\u0000%#\u0001\u0000"+
		"\u0000\u0000&\'\u0005\u0015\u0000\u0000\'(\u0005\u0013\u0000\u0000(/\u0001"+
		"\u0000\u0000\u0000)+\u0005\u0015\u0000\u0000*)\u0001\u0000\u0000\u0000"+
		"*+\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0005\u0013\u0000"+
		"\u0000-*\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000\u0000/-\u0001\u0000"+
		"\u0000\u0000/0\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u00001/\u0001"+
		"\u0000\u0000\u00002\u001f\u0001\u0000\u0000\u000023\u0001\u0000\u0000"+
		"\u000034\u0001\u0000\u0000\u000048\u0007\u0000\u0000\u000057\u0005\u0019"+
		"\u0000\u000065\u0001\u0000\u0000\u00007:\u0001\u0000\u0000\u000086\u0001"+
		"\u0000\u0000\u000089\u0001\u0000\u0000\u00009;\u0001\u0000\u0000\u0000"+
		":8\u0001\u0000\u0000\u0000;<\u0005\u001b\u0000\u0000<=\u0005\u0019\u0000"+
		"\u0000=D\u0001\u0000\u0000\u0000>@\u0005\u001b\u0000\u0000?>\u0001\u0000"+
		"\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0005"+
		"\u0019\u0000\u0000B?\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EG\u0001\u0000\u0000"+
		"\u0000FD\u0001\u0000\u0000\u0000GK\u0005\u0016\u0000\u0000HJ\u0003\u0006"+
		"\u0003\u0000IH\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000L\u0005\u0001\u0000\u0000"+
		"\u0000MK\u0001\u0000\u0000\u0000NP\u0005\u001c\u0000\u0000OQ\u0005\"\u0000"+
		"\u0000PO\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0001\u0000"+
		"\u0000\u0000RS\u0005\u001d\u0000\u0000ST\u0005\"\u0000\u0000T\u0007\u0001"+
		"\u0000\u0000\u0000\r\u000e\u0011\u0017\u001c#*/28?DKP";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}