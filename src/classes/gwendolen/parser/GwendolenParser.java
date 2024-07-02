// Generated from /Users/louisedennis/IdeaProjects/mcapl/src/classes/gwendolen/parser/antlr/Gwendolen.g4 by ANTLR 4.13.1
package gwendolen.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GwendolenParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GWENDOLEN=1, IMPORTS=2, NAME=3, CONST=4, COMMENT=5, LINE_COMMENT=6, NEWLINE=7, 
		WS=8, BELIEFS=9, BELIEFRULES=10, GOAL_IB=11, IB_COMMENT=12, IB_LINE_COMMENT=13, 
		IB_NEWLINE=14, IB_WS=15, BELIEF_BLOCK=16, GOAL_RR=17, RR_COMMENT=18, RR_LINE_COMMENT=19, 
		RR_NEWLINE=20, RR_WS=21, RR_BLOCK=22, PLANS=23, GL_COMMENT=24, GL_LINE_COMMENT=25, 
		GL_NEWLINE=26, GL_WS=27, GL_ACHIEVEGOAL=28, GL_PERFORMGOAL=29, GL_SQOPEN=30, 
		GL_SQCLOSE=31, GOAL_BLOCK=32, NAME_PM=33, PL_COMMENT=34, PL_LINE_COMMENT=35, 
		PL_NEWLINE=36, PL_WS=37, SEND=38, RECEIVED=39, BELIEVE=40, GOAL=41, SENT=42, 
		LOCK=43, PL_ACHIEVEGOAL=44, PL_PERFORMGOAL=45, PL_SQOPEN=46, PL_SQCLOSE=47, 
		PL_BAR=48, NOT=49, COLON=50, CURLYOPEN=51, CURLYCLOSE=52, COMMA=53, SEMI=54, 
		TELL=55, SHRIEK=56, OPEN=57, CLOSE=58, MULT=59, PLUS=60, MINUS=61, LESS=62, 
		EQUAL=63, IDPUNCT=64, RULEARROW=65, TRUE=66, PL_CONST=67, PL_VAR=68, NUMBER=69, 
		QUOTED_STRING=70;
	public static final int
		RULE_mas = 0, RULE_gwendolenagents = 1, RULE_gwendolenagent = 2, RULE_initial_goal = 3, 
		RULE_plan = 4, RULE_guard_atom = 5, RULE_event = 6, RULE_performative = 7, 
		RULE_deed = 8, RULE_goal = 9, RULE_waitfor = 10, RULE_action = 11, RULE_fof_expr = 12, 
		RULE_const_var = 13, RULE_oper = 14, RULE_agentnameterm = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"mas", "gwendolenagents", "gwendolenagent", "initial_goal", "plan", "guard_atom", 
			"event", "performative", "deed", "goal", "waitfor", "action", "fof_expr", 
			"const_var", "oper", "agentnameterm"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'GWENDOLEN'", "':imports:'", null, null, null, null, null, null, 
			"':Initial Beliefs:'", "':Reasoning Rules:'", null, null, null, null, 
			null, null, null, null, null, null, null, null, "':Plans:'", null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'.send'", "'.received'", null, null, "'.sent'", "'.lock'", "'achieve'", 
			"'perform'", null, null, "'|'", "'~'", "':'", "'{'", "'}'", "','", "';'", 
			"':tell'", "'!'", "'('", "')'", "'*'", "'+'", "'-'", "'<'", "'=='", "'.'", 
			"'<-'", "'True'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "GWENDOLEN", "IMPORTS", "NAME", "CONST", "COMMENT", "LINE_COMMENT", 
			"NEWLINE", "WS", "BELIEFS", "BELIEFRULES", "GOAL_IB", "IB_COMMENT", "IB_LINE_COMMENT", 
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
	public String getGrammarFileName() { return "Gwendolen.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GwendolenParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MasContext extends ParserRuleContext {
		public GwendolenagentsContext glist;
		public GwendolenagentsContext gwendolenagents() {
			return getRuleContext(GwendolenagentsContext.class,0);
		}
		public MasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mas; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitMas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MasContext mas() throws RecognitionException {
		MasContext _localctx = new MasContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mas);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			((MasContext)_localctx).glist = gwendolenagents();
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
	public static class GwendolenagentsContext extends ParserRuleContext {
		public GwendolenagentContext g;
		public TerminalNode GWENDOLEN() { return getToken(GwendolenParser.GWENDOLEN, 0); }
		public List<GwendolenagentContext> gwendolenagent() {
			return getRuleContexts(GwendolenagentContext.class);
		}
		public GwendolenagentContext gwendolenagent(int i) {
			return getRuleContext(GwendolenagentContext.class,i);
		}
		public GwendolenagentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gwendolenagents; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitGwendolenagents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GwendolenagentsContext gwendolenagents() throws RecognitionException {
		GwendolenagentsContext _localctx = new GwendolenagentsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_gwendolenagents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(GWENDOLEN);
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(35);
				((GwendolenagentsContext)_localctx).g = gwendolenagent();
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8589934602L) != 0) );
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
	public static class GwendolenagentContext extends ParserRuleContext {
		public Token w;
		public Fof_exprContext eb;
		public Token bs;
		public Token rr;
		public Initial_goalContext gs;
		public PlanContext p;
		public TerminalNode BELIEFS() { return getToken(GwendolenParser.BELIEFS, 0); }
		public TerminalNode PLANS() { return getToken(GwendolenParser.PLANS, 0); }
		public TerminalNode NAME() { return getToken(GwendolenParser.NAME, 0); }
		public TerminalNode NAME_PM() { return getToken(GwendolenParser.NAME_PM, 0); }
		public TerminalNode CONST() { return getToken(GwendolenParser.CONST, 0); }
		public TerminalNode GOAL_IB() { return getToken(GwendolenParser.GOAL_IB, 0); }
		public TerminalNode GOAL_RR() { return getToken(GwendolenParser.GOAL_RR, 0); }
		public TerminalNode IMPORTS() { return getToken(GwendolenParser.IMPORTS, 0); }
		public TerminalNode BELIEFRULES() { return getToken(GwendolenParser.BELIEFRULES, 0); }
		public List<TerminalNode> BELIEF_BLOCK() { return getTokens(GwendolenParser.BELIEF_BLOCK); }
		public TerminalNode BELIEF_BLOCK(int i) {
			return getToken(GwendolenParser.BELIEF_BLOCK, i);
		}
		public List<Initial_goalContext> initial_goal() {
			return getRuleContexts(Initial_goalContext.class);
		}
		public Initial_goalContext initial_goal(int i) {
			return getRuleContext(Initial_goalContext.class,i);
		}
		public List<PlanContext> plan() {
			return getRuleContexts(PlanContext.class);
		}
		public PlanContext plan(int i) {
			return getRuleContext(PlanContext.class,i);
		}
		public TerminalNode GWENDOLEN() { return getToken(GwendolenParser.GWENDOLEN, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(GwendolenParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GwendolenParser.NEWLINE, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(GwendolenParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(GwendolenParser.SEMI, i);
		}
		public List<TerminalNode> RR_NEWLINE() { return getTokens(GwendolenParser.RR_NEWLINE); }
		public TerminalNode RR_NEWLINE(int i) {
			return getToken(GwendolenParser.RR_NEWLINE, i);
		}
		public List<Fof_exprContext> fof_expr() {
			return getRuleContexts(Fof_exprContext.class);
		}
		public Fof_exprContext fof_expr(int i) {
			return getRuleContext(Fof_exprContext.class,i);
		}
		public List<TerminalNode> RR_BLOCK() { return getTokens(GwendolenParser.RR_BLOCK); }
		public TerminalNode RR_BLOCK(int i) {
			return getToken(GwendolenParser.RR_BLOCK, i);
		}
		public GwendolenagentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gwendolenagent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitGwendolenagent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GwendolenagentContext gwendolenagent() throws RecognitionException {
		GwendolenagentContext _localctx = new GwendolenagentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_gwendolenagent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GWENDOLEN) {
				{
				setState(40);
				match(GWENDOLEN);
				}
			}

			}
			setState(43);
			_la = _input.LA(1);
			if ( !(_la==NAME || _la==NAME_PM) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(44);
			((GwendolenagentContext)_localctx).w = match(CONST);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPORTS) {
				{
				setState(45);
				match(IMPORTS);
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(46);
					match(NEWLINE);
					}
					}
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & 14714881L) != 0)) {
					{
					{
					setState(52);
					((GwendolenagentContext)_localctx).eb = fof_expr();
					setState(53);
					match(SEMI);
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(62);
			match(BELIEFS);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BELIEF_BLOCK) {
				{
				{
				setState(63);
				((GwendolenagentContext)_localctx).bs = match(BELIEF_BLOCK);
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BELIEFRULES) {
				{
				setState(69);
				match(BELIEFRULES);
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_NEWLINE) {
					{
					{
					setState(70);
					match(RR_NEWLINE);
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_BLOCK) {
					{
					{
					setState(76);
					((GwendolenagentContext)_localctx).rr = match(RR_BLOCK);
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(84);
			_la = _input.LA(1);
			if ( !(_la==GOAL_IB || _la==GOAL_RR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GOAL_BLOCK) {
				{
				{
				setState(85);
				((GwendolenagentContext)_localctx).gs = initial_goal();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			match(PLANS);
			setState(93); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(92);
				((GwendolenagentContext)_localctx).p = plan();
				}
				}
				setState(95); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PLUS || _la==MINUS );
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
	public static class Initial_goalContext extends ParserRuleContext {
		public Token g;
		public TerminalNode GL_SQOPEN() { return getToken(GwendolenParser.GL_SQOPEN, 0); }
		public TerminalNode GL_SQCLOSE() { return getToken(GwendolenParser.GL_SQCLOSE, 0); }
		public TerminalNode GOAL_BLOCK() { return getToken(GwendolenParser.GOAL_BLOCK, 0); }
		public TerminalNode GL_ACHIEVEGOAL() { return getToken(GwendolenParser.GL_ACHIEVEGOAL, 0); }
		public TerminalNode GL_PERFORMGOAL() { return getToken(GwendolenParser.GL_PERFORMGOAL, 0); }
		public Initial_goalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial_goal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitInitial_goal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Initial_goalContext initial_goal() throws RecognitionException {
		Initial_goalContext _localctx = new Initial_goalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_initial_goal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			((Initial_goalContext)_localctx).g = match(GOAL_BLOCK);
			setState(98);
			match(GL_SQOPEN);
			setState(99);
			_la = _input.LA(1);
			if ( !(_la==GL_ACHIEVEGOAL || _la==GL_PERFORMGOAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(100);
			match(GL_SQCLOSE);
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
	public static class PlanContext extends ParserRuleContext {
		public EventContext e;
		public Guard_atomContext gb;
		public DeedContext d;
		public TerminalNode COLON() { return getToken(GwendolenParser.COLON, 0); }
		public TerminalNode CURLYOPEN() { return getToken(GwendolenParser.CURLYOPEN, 0); }
		public TerminalNode CURLYCLOSE() { return getToken(GwendolenParser.CURLYCLOSE, 0); }
		public TerminalNode SEMI() { return getToken(GwendolenParser.SEMI, 0); }
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public List<Guard_atomContext> guard_atom() {
			return getRuleContexts(Guard_atomContext.class);
		}
		public Guard_atomContext guard_atom(int i) {
			return getRuleContext(Guard_atomContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GwendolenParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GwendolenParser.COMMA, i);
		}
		public TerminalNode RULEARROW() { return getToken(GwendolenParser.RULEARROW, 0); }
		public List<DeedContext> deed() {
			return getRuleContexts(DeedContext.class);
		}
		public DeedContext deed(int i) {
			return getRuleContext(DeedContext.class,i);
		}
		public PlanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plan; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitPlan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlanContext plan() throws RecognitionException {
		PlanContext _localctx = new PlanContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_plan);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			((PlanContext)_localctx).e = event();
			setState(103);
			match(COLON);
			setState(104);
			match(CURLYOPEN);
			setState(105);
			((PlanContext)_localctx).gb = guard_atom();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(106);
				match(COMMA);
				setState(107);
				((PlanContext)_localctx).gb = guard_atom();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			match(CURLYCLOSE);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULEARROW) {
				{
				setState(114);
				match(RULEARROW);
				setState(115);
				((PlanContext)_localctx).d = deed();
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(116);
					match(COMMA);
					setState(117);
					((PlanContext)_localctx).d = deed();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(125);
			match(SEMI);
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
	public static class Guard_atomContext extends ParserRuleContext {
		public Fof_exprContext l;
		public GoalContext gl;
		public Fof_exprContext eq;
		public AgentnametermContext s;
		public AgentnametermContext an2;
		public PerformativeContext p;
		public Fof_exprContext t;
		public TerminalNode TRUE() { return getToken(GwendolenParser.TRUE, 0); }
		public TerminalNode BELIEVE() { return getToken(GwendolenParser.BELIEVE, 0); }
		public TerminalNode GOAL() { return getToken(GwendolenParser.GOAL, 0); }
		public TerminalNode SENT() { return getToken(GwendolenParser.SENT, 0); }
		public TerminalNode OPEN() { return getToken(GwendolenParser.OPEN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GwendolenParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GwendolenParser.COMMA, i);
		}
		public TerminalNode CLOSE() { return getToken(GwendolenParser.CLOSE, 0); }
		public TerminalNode NOT() { return getToken(GwendolenParser.NOT, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public GoalContext goal() {
			return getRuleContext(GoalContext.class,0);
		}
		public PerformativeContext performative() {
			return getRuleContext(PerformativeContext.class,0);
		}
		public List<AgentnametermContext> agentnameterm() {
			return getRuleContexts(AgentnametermContext.class);
		}
		public AgentnametermContext agentnameterm(int i) {
			return getRuleContext(AgentnametermContext.class,i);
		}
		public Guard_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitGuard_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Guard_atomContext guard_atom() throws RecognitionException {
		Guard_atomContext _localctx = new Guard_atomContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_guard_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BELIEVE:
			case GOAL:
			case SENT:
			case PL_SQOPEN:
			case NOT:
			case OPEN:
			case MINUS:
			case PL_CONST:
			case PL_VAR:
			case NUMBER:
				{
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(127);
					match(NOT);
					}
				}

				setState(149);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BELIEVE:
					{
					setState(130);
					match(BELIEVE);
					setState(131);
					((Guard_atomContext)_localctx).l = fof_expr();
					}
					break;
				case GOAL:
					{
					setState(132);
					match(GOAL);
					setState(133);
					((Guard_atomContext)_localctx).gl = goal();
					}
					break;
				case PL_SQOPEN:
				case OPEN:
				case MINUS:
				case PL_CONST:
				case PL_VAR:
				case NUMBER:
					{
					setState(134);
					((Guard_atomContext)_localctx).eq = fof_expr();
					}
					break;
				case SENT:
					{
					setState(135);
					match(SENT);
					setState(136);
					match(OPEN);
					{
					setState(137);
					((Guard_atomContext)_localctx).s = agentnameterm();
					}
					setState(138);
					match(COMMA);
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PL_CONST || _la==PL_VAR) {
						{
						setState(139);
						((Guard_atomContext)_localctx).an2 = agentnameterm();
						setState(140);
						match(COMMA);
						}
					}

					setState(144);
					((Guard_atomContext)_localctx).p = performative();
					setState(145);
					match(COMMA);
					setState(146);
					((Guard_atomContext)_localctx).t = fof_expr();
					setState(147);
					match(CLOSE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case TRUE:
				{
				setState(151);
				match(TRUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class EventContext extends ParserRuleContext {
		public PerformativeContext p;
		public Fof_exprContext t;
		public Fof_exprContext l;
		public GoalContext g;
		public TerminalNode PLUS() { return getToken(GwendolenParser.PLUS, 0); }
		public TerminalNode RECEIVED() { return getToken(GwendolenParser.RECEIVED, 0); }
		public TerminalNode OPEN() { return getToken(GwendolenParser.OPEN, 0); }
		public TerminalNode COMMA() { return getToken(GwendolenParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(GwendolenParser.CLOSE, 0); }
		public PerformativeContext performative() {
			return getRuleContext(PerformativeContext.class,0);
		}
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode SHRIEK() { return getToken(GwendolenParser.SHRIEK, 0); }
		public GoalContext goal() {
			return getRuleContext(GoalContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(GwendolenParser.MINUS, 0); }
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_event);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(154);
				match(PLUS);
				setState(167);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RECEIVED:
					{
					setState(155);
					match(RECEIVED);
					setState(156);
					match(OPEN);
					setState(157);
					((EventContext)_localctx).p = performative();
					setState(158);
					match(COMMA);
					setState(159);
					((EventContext)_localctx).t = fof_expr();
					setState(160);
					match(CLOSE);
					}
					break;
				case PL_SQOPEN:
				case SHRIEK:
				case OPEN:
				case MINUS:
				case PL_CONST:
				case PL_VAR:
				case NUMBER:
					{
					setState(165);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PL_SQOPEN:
					case OPEN:
					case MINUS:
					case PL_CONST:
					case PL_VAR:
					case NUMBER:
						{
						setState(162);
						((EventContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(163);
						match(SHRIEK);
						setState(164);
						((EventContext)_localctx).g = goal();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(169);
				match(MINUS);
				setState(173);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PL_SQOPEN:
				case OPEN:
				case MINUS:
				case PL_CONST:
				case PL_VAR:
				case NUMBER:
					{
					setState(170);
					((EventContext)_localctx).l = fof_expr();
					}
					break;
				case SHRIEK:
					{
					setState(171);
					match(SHRIEK);
					setState(172);
					((EventContext)_localctx).g = goal();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class PerformativeContext extends ParserRuleContext {
		public TerminalNode TELL() { return getToken(GwendolenParser.TELL, 0); }
		public TerminalNode COLON() { return getToken(GwendolenParser.COLON, 0); }
		public TerminalNode PL_PERFORMGOAL() { return getToken(GwendolenParser.PL_PERFORMGOAL, 0); }
		public TerminalNode PL_ACHIEVEGOAL() { return getToken(GwendolenParser.PL_ACHIEVEGOAL, 0); }
		public PerformativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_performative; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitPerformative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PerformativeContext performative() throws RecognitionException {
		PerformativeContext _localctx = new PerformativeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_performative);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(177);
				match(TELL);
				}
				break;
			case 2:
				{
				setState(178);
				match(COLON);
				setState(179);
				match(PL_PERFORMGOAL);
				}
				break;
			case 3:
				{
				setState(180);
				match(COLON);
				setState(181);
				match(PL_ACHIEVEGOAL);
				}
				break;
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
	public static class DeedContext extends ParserRuleContext {
		public Fof_exprContext l;
		public GoalContext g;
		public ActionContext a;
		public WaitforContext wf;
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public WaitforContext waitfor() {
			return getRuleContext(WaitforContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(GwendolenParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(GwendolenParser.MINUS, 0); }
		public TerminalNode SHRIEK() { return getToken(GwendolenParser.SHRIEK, 0); }
		public TerminalNode LOCK() { return getToken(GwendolenParser.LOCK, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public GoalContext goal() {
			return getRuleContext(GoalContext.class,0);
		}
		public DeedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deed; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitDeed(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeedContext deed() throws RecognitionException {
		DeedContext _localctx = new DeedContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_deed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(198);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					{
					setState(184);
					match(PLUS);
					setState(189);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PL_SQOPEN:
					case OPEN:
					case MINUS:
					case PL_CONST:
					case PL_VAR:
					case NUMBER:
						{
						setState(185);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(186);
						match(SHRIEK);
						setState(187);
						((DeedContext)_localctx).g = goal();
						}
						break;
					case LOCK:
						{
						setState(188);
						match(LOCK);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					break;
				case MINUS:
					{
					{
					setState(191);
					match(MINUS);
					setState(196);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PL_SQOPEN:
					case OPEN:
					case MINUS:
					case PL_CONST:
					case PL_VAR:
					case NUMBER:
						{
						setState(192);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(193);
						match(SHRIEK);
						setState(194);
						((DeedContext)_localctx).g = goal();
						}
						break;
					case LOCK:
						{
						setState(195);
						match(LOCK);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				{
				setState(200);
				((DeedContext)_localctx).a = action();
				}
				break;
			case 3:
				{
				setState(201);
				((DeedContext)_localctx).wf = waitfor();
				}
				break;
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
	public static class GoalContext extends ParserRuleContext {
		public Fof_exprContext g;
		public TerminalNode PL_SQOPEN() { return getToken(GwendolenParser.PL_SQOPEN, 0); }
		public TerminalNode PL_SQCLOSE() { return getToken(GwendolenParser.PL_SQCLOSE, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode PL_ACHIEVEGOAL() { return getToken(GwendolenParser.PL_ACHIEVEGOAL, 0); }
		public TerminalNode PL_PERFORMGOAL() { return getToken(GwendolenParser.PL_PERFORMGOAL, 0); }
		public GoalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitGoal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GoalContext goal() throws RecognitionException {
		GoalContext _localctx = new GoalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_goal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			((GoalContext)_localctx).g = fof_expr();
			setState(205);
			match(PL_SQOPEN);
			setState(206);
			_la = _input.LA(1);
			if ( !(_la==PL_ACHIEVEGOAL || _la==PL_PERFORMGOAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(207);
			match(PL_SQCLOSE);
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
	public static class WaitforContext extends ParserRuleContext {
		public Fof_exprContext l;
		public TerminalNode MULT() { return getToken(GwendolenParser.MULT, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(GwendolenParser.NOT, 0); }
		public WaitforContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_waitfor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitWaitfor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WaitforContext waitfor() throws RecognitionException {
		WaitforContext _localctx = new WaitforContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_waitfor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(MULT);
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(210);
				match(NOT);
				}
			}

			setState(213);
			((WaitforContext)_localctx).l = fof_expr();
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
	public static class ActionContext extends ParserRuleContext {
		public Fof_exprContext an;
		public PerformativeContext p;
		public Fof_exprContext t;
		public TerminalNode SEND() { return getToken(GwendolenParser.SEND, 0); }
		public TerminalNode OPEN() { return getToken(GwendolenParser.OPEN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GwendolenParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GwendolenParser.COMMA, i);
		}
		public TerminalNode CLOSE() { return getToken(GwendolenParser.CLOSE, 0); }
		public List<Fof_exprContext> fof_expr() {
			return getRuleContexts(Fof_exprContext.class);
		}
		public Fof_exprContext fof_expr(int i) {
			return getRuleContext(Fof_exprContext.class,i);
		}
		public PerformativeContext performative() {
			return getRuleContext(PerformativeContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_action);
		try {
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEND:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(215);
				match(SEND);
				setState(216);
				match(OPEN);
				setState(217);
				((ActionContext)_localctx).an = fof_expr();
				setState(218);
				match(COMMA);
				setState(219);
				((ActionContext)_localctx).p = performative();
				setState(220);
				match(COMMA);
				setState(221);
				((ActionContext)_localctx).t = fof_expr();
				setState(222);
				match(CLOSE);
				}
				}
				break;
			case PL_SQOPEN:
			case OPEN:
			case MINUS:
			case PL_CONST:
			case PL_VAR:
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				((ActionContext)_localctx).t = fof_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Fof_exprContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(GwendolenParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(GwendolenParser.NUMBER, i);
		}
		public List<TerminalNode> PL_VAR() { return getTokens(GwendolenParser.PL_VAR); }
		public TerminalNode PL_VAR(int i) {
			return getToken(GwendolenParser.PL_VAR, i);
		}
		public OperContext oper() {
			return getRuleContext(OperContext.class,0);
		}
		public List<TerminalNode> MINUS() { return getTokens(GwendolenParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(GwendolenParser.MINUS, i);
		}
		public List<Const_varContext> const_var() {
			return getRuleContexts(Const_varContext.class);
		}
		public Const_varContext const_var(int i) {
			return getRuleContext(Const_varContext.class,i);
		}
		public TerminalNode PL_SQOPEN() { return getToken(GwendolenParser.PL_SQOPEN, 0); }
		public TerminalNode PL_SQCLOSE() { return getToken(GwendolenParser.PL_SQCLOSE, 0); }
		public TerminalNode OPEN() { return getToken(GwendolenParser.OPEN, 0); }
		public List<Fof_exprContext> fof_expr() {
			return getRuleContexts(Fof_exprContext.class);
		}
		public Fof_exprContext fof_expr(int i) {
			return getRuleContext(Fof_exprContext.class,i);
		}
		public TerminalNode CLOSE() { return getToken(GwendolenParser.CLOSE, 0); }
		public List<TerminalNode> IDPUNCT() { return getTokens(GwendolenParser.IDPUNCT); }
		public TerminalNode IDPUNCT(int i) {
			return getToken(GwendolenParser.IDPUNCT, i);
		}
		public List<TerminalNode> QUOTED_STRING() { return getTokens(GwendolenParser.QUOTED_STRING); }
		public TerminalNode QUOTED_STRING(int i) {
			return getToken(GwendolenParser.QUOTED_STRING, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GwendolenParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GwendolenParser.COMMA, i);
		}
		public TerminalNode PL_BAR() { return getToken(GwendolenParser.PL_BAR, 0); }
		public Fof_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fof_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitFof_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fof_exprContext fof_expr() throws RecognitionException {
		Fof_exprContext _localctx = new Fof_exprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fof_expr);
		int _la;
		try {
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MINUS:
				case NUMBER:
					{
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==MINUS) {
						{
						setState(227);
						match(MINUS);
						}
					}

					setState(230);
					match(NUMBER);
					}
					break;
				case PL_VAR:
					{
					setState(231);
					match(PL_VAR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1152921504606846976L) != 0)) {
					{
					setState(234);
					oper();
					setState(240);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case MINUS:
					case NUMBER:
						{
						setState(236);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MINUS) {
							{
							setState(235);
							match(MINUS);
							}
						}

						setState(238);
						match(NUMBER);
						}
						break;
					case PL_VAR:
						{
						setState(239);
						match(PL_VAR);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PL_CONST:
				case PL_VAR:
					{
					setState(244);
					const_var();
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==IDPUNCT) {
						{
						{
						setState(245);
						match(IDPUNCT);
						setState(246);
						const_var();
						}
						}
						setState(251);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==OPEN) {
						{
						setState(252);
						match(OPEN);
						setState(255);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case PL_SQOPEN:
						case OPEN:
						case MINUS:
						case PL_CONST:
						case PL_VAR:
						case NUMBER:
							{
							setState(253);
							fof_expr();
							}
							break;
						case QUOTED_STRING:
							{
							setState(254);
							match(QUOTED_STRING);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(264);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(257);
							match(COMMA);
							setState(260);
							_errHandler.sync(this);
							switch (_input.LA(1)) {
							case PL_SQOPEN:
							case OPEN:
							case MINUS:
							case PL_CONST:
							case PL_VAR:
							case NUMBER:
								{
								setState(258);
								fof_expr();
								}
								break;
							case QUOTED_STRING:
								{
								setState(259);
								match(QUOTED_STRING);
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							}
							}
							setState(266);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(267);
						match(CLOSE);
						}
					}

					}
					break;
				case PL_SQOPEN:
					{
					setState(270);
					match(PL_SQOPEN);
					setState(283);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & 14714881L) != 0)) {
						{
						setState(271);
						fof_expr();
						setState(276);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(272);
							match(COMMA);
							setState(273);
							fof_expr();
							}
							}
							setState(278);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(281);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==PL_BAR) {
							{
							setState(279);
							match(PL_BAR);
							setState(280);
							match(PL_VAR);
							}
						}

						}
					}

					setState(285);
					match(PL_SQCLOSE);
					}
					break;
				case OPEN:
					{
					setState(286);
					match(OPEN);
					setState(287);
					fof_expr();
					setState(288);
					match(CLOSE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
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
	public static class Const_varContext extends ParserRuleContext {
		public TerminalNode PL_CONST() { return getToken(GwendolenParser.PL_CONST, 0); }
		public TerminalNode PL_VAR() { return getToken(GwendolenParser.PL_VAR, 0); }
		public Const_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitConst_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_varContext const_var() throws RecognitionException {
		Const_varContext _localctx = new Const_varContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_const_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_la = _input.LA(1);
			if ( !(_la==PL_CONST || _la==PL_VAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class OperContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(GwendolenParser.EQUAL, 0); }
		public TerminalNode LESS() { return getToken(GwendolenParser.LESS, 0); }
		public TerminalNode PLUS() { return getToken(GwendolenParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(GwendolenParser.MINUS, 0); }
		public OperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitOper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperContext oper() throws RecognitionException {
		OperContext _localctx = new OperContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -1152921504606846976L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class AgentnametermContext extends ParserRuleContext {
		public TerminalNode PL_CONST() { return getToken(GwendolenParser.PL_CONST, 0); }
		public TerminalNode PL_VAR() { return getToken(GwendolenParser.PL_VAR, 0); }
		public AgentnametermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentnameterm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitAgentnameterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgentnametermContext agentnameterm() throws RecognitionException {
		AgentnametermContext _localctx = new AgentnametermContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_agentnameterm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			_la = _input.LA(1);
			if ( !(_la==PL_CONST || _la==PL_VAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001F\u012d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0004\u0001%\b\u0001"+
		"\u000b\u0001\f\u0001&\u0001\u0002\u0003\u0002*\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u00020\b\u0002\n\u0002\f\u00023\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00028\b\u0002\n\u0002"+
		"\f\u0002;\t\u0002\u0003\u0002=\b\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"A\b\u0002\n\u0002\f\u0002D\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"H\b\u0002\n\u0002\f\u0002K\t\u0002\u0001\u0002\u0005\u0002N\b\u0002\n"+
		"\u0002\f\u0002Q\t\u0002\u0003\u0002S\b\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002W\b\u0002\n\u0002\f\u0002Z\t\u0002\u0001\u0002\u0001\u0002\u0004"+
		"\u0002^\b\u0002\u000b\u0002\f\u0002_\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004m\b\u0004\n\u0004\f\u0004p\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"w\b\u0004\n\u0004\f\u0004z\t\u0004\u0003\u0004|\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0003\u0005\u0081\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u008f\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0096"+
		"\b\u0005\u0001\u0005\u0003\u0005\u0099\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00a6\b\u0006\u0003\u0006"+
		"\u00a8\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u00ae\b\u0006\u0003\u0006\u00b0\b\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00b7\b\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u00be\b\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00c5\b\b\u0003\b\u00c7\b\b\u0001\b\u0001\b\u0003\b"+
		"\u00cb\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0003"+
		"\n\u00d4\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00e2\b\u000b\u0001\f\u0003\f\u00e5\b\f\u0001\f\u0001"+
		"\f\u0003\f\u00e9\b\f\u0001\f\u0001\f\u0003\f\u00ed\b\f\u0001\f\u0001\f"+
		"\u0003\f\u00f1\b\f\u0003\f\u00f3\b\f\u0001\f\u0001\f\u0001\f\u0005\f\u00f8"+
		"\b\f\n\f\f\f\u00fb\t\f\u0001\f\u0001\f\u0001\f\u0003\f\u0100\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u0105\b\f\u0005\f\u0107\b\f\n\f\f\f\u010a\t"+
		"\f\u0001\f\u0003\f\u010d\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0113"+
		"\b\f\n\f\f\f\u0116\t\f\u0001\f\u0001\f\u0003\f\u011a\b\f\u0003\f\u011c"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0123\b\f\u0003\f"+
		"\u0125\b\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0006\u0002\u0000\u0003"+
		"\u0003!!\u0002\u0000\u000b\u000b\u0011\u0011\u0001\u0000\u001c\u001d\u0001"+
		"\u0000,-\u0001\u0000CD\u0001\u0000<?\u014f\u0000 \u0001\u0000\u0000\u0000"+
		"\u0002\"\u0001\u0000\u0000\u0000\u0004)\u0001\u0000\u0000\u0000\u0006"+
		"a\u0001\u0000\u0000\u0000\bf\u0001\u0000\u0000\u0000\n\u0098\u0001\u0000"+
		"\u0000\u0000\f\u00af\u0001\u0000\u0000\u0000\u000e\u00b6\u0001\u0000\u0000"+
		"\u0000\u0010\u00ca\u0001\u0000\u0000\u0000\u0012\u00cc\u0001\u0000\u0000"+
		"\u0000\u0014\u00d1\u0001\u0000\u0000\u0000\u0016\u00e1\u0001\u0000\u0000"+
		"\u0000\u0018\u0124\u0001\u0000\u0000\u0000\u001a\u0126\u0001\u0000\u0000"+
		"\u0000\u001c\u0128\u0001\u0000\u0000\u0000\u001e\u012a\u0001\u0000\u0000"+
		"\u0000 !\u0003\u0002\u0001\u0000!\u0001\u0001\u0000\u0000\u0000\"$\u0005"+
		"\u0001\u0000\u0000#%\u0003\u0004\u0002\u0000$#\u0001\u0000\u0000\u0000"+
		"%&\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000"+
		"\u0000\'\u0003\u0001\u0000\u0000\u0000(*\u0005\u0001\u0000\u0000)(\u0001"+
		"\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000"+
		"+,\u0007\u0000\u0000\u0000,<\u0005\u0004\u0000\u0000-1\u0005\u0002\u0000"+
		"\u0000.0\u0005\u0007\u0000\u0000/.\u0001\u0000\u0000\u000003\u0001\u0000"+
		"\u0000\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000029\u0001"+
		"\u0000\u0000\u000031\u0001\u0000\u0000\u000045\u0003\u0018\f\u000056\u0005"+
		"6\u0000\u000068\u0001\u0000\u0000\u000074\u0001\u0000\u0000\u00008;\u0001"+
		"\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000"+
		":=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<-\u0001\u0000\u0000"+
		"\u0000<=\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>B\u0005\t\u0000"+
		"\u0000?A\u0005\u0010\u0000\u0000@?\u0001\u0000\u0000\u0000AD\u0001\u0000"+
		"\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CR\u0001"+
		"\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000EI\u0005\n\u0000\u0000FH\u0005"+
		"\u0014\u0000\u0000GF\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JO\u0001\u0000\u0000"+
		"\u0000KI\u0001\u0000\u0000\u0000LN\u0005\u0016\u0000\u0000ML\u0001\u0000"+
		"\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001"+
		"\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000"+
		"RE\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000"+
		"\u0000TX\u0007\u0001\u0000\u0000UW\u0003\u0006\u0003\u0000VU\u0001\u0000"+
		"\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000"+
		"[]\u0005\u0017\u0000\u0000\\^\u0003\b\u0004\u0000]\\\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000"+
		"\u0000\u0000`\u0005\u0001\u0000\u0000\u0000ab\u0005 \u0000\u0000bc\u0005"+
		"\u001e\u0000\u0000cd\u0007\u0002\u0000\u0000de\u0005\u001f\u0000\u0000"+
		"e\u0007\u0001\u0000\u0000\u0000fg\u0003\f\u0006\u0000gh\u00052\u0000\u0000"+
		"hi\u00053\u0000\u0000in\u0003\n\u0005\u0000jk\u00055\u0000\u0000km\u0003"+
		"\n\u0005\u0000lj\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0001\u0000\u0000\u0000"+
		"pn\u0001\u0000\u0000\u0000q{\u00054\u0000\u0000rs\u0005A\u0000\u0000s"+
		"x\u0003\u0010\b\u0000tu\u00055\u0000\u0000uw\u0003\u0010\b\u0000vt\u0001"+
		"\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000"+
		"xy\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000"+
		"\u0000{r\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0001\u0000"+
		"\u0000\u0000}~\u00056\u0000\u0000~\t\u0001\u0000\u0000\u0000\u007f\u0081"+
		"\u00051\u0000\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0080\u0081\u0001"+
		"\u0000\u0000\u0000\u0081\u0095\u0001\u0000\u0000\u0000\u0082\u0083\u0005"+
		"(\u0000\u0000\u0083\u0096\u0003\u0018\f\u0000\u0084\u0085\u0005)\u0000"+
		"\u0000\u0085\u0096\u0003\u0012\t\u0000\u0086\u0096\u0003\u0018\f\u0000"+
		"\u0087\u0088\u0005*\u0000\u0000\u0088\u0089\u00059\u0000\u0000\u0089\u008a"+
		"\u0003\u001e\u000f\u0000\u008a\u008e\u00055\u0000\u0000\u008b\u008c\u0003"+
		"\u001e\u000f\u0000\u008c\u008d\u00055\u0000\u0000\u008d\u008f\u0001\u0000"+
		"\u0000\u0000\u008e\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0003\u000e"+
		"\u0007\u0000\u0091\u0092\u00055\u0000\u0000\u0092\u0093\u0003\u0018\f"+
		"\u0000\u0093\u0094\u0005:\u0000\u0000\u0094\u0096\u0001\u0000\u0000\u0000"+
		"\u0095\u0082\u0001\u0000\u0000\u0000\u0095\u0084\u0001\u0000\u0000\u0000"+
		"\u0095\u0086\u0001\u0000\u0000\u0000\u0095\u0087\u0001\u0000\u0000\u0000"+
		"\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0099\u0005B\u0000\u0000\u0098"+
		"\u0080\u0001\u0000\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099"+
		"\u000b\u0001\u0000\u0000\u0000\u009a\u00a7\u0005<\u0000\u0000\u009b\u009c"+
		"\u0005\'\u0000\u0000\u009c\u009d\u00059\u0000\u0000\u009d\u009e\u0003"+
		"\u000e\u0007\u0000\u009e\u009f\u00055\u0000\u0000\u009f\u00a0\u0003\u0018"+
		"\f\u0000\u00a0\u00a1\u0005:\u0000\u0000\u00a1\u00a8\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a6\u0003\u0018\f\u0000\u00a3\u00a4\u00058\u0000\u0000"+
		"\u00a4\u00a6\u0003\u0012\t\u0000\u00a5\u00a2\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000\u00a7"+
		"\u009b\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8"+
		"\u00b0\u0001\u0000\u0000\u0000\u00a9\u00ad\u0005=\u0000\u0000\u00aa\u00ae"+
		"\u0003\u0018\f\u0000\u00ab\u00ac\u00058\u0000\u0000\u00ac\u00ae\u0003"+
		"\u0012\t\u0000\u00ad\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af\u009a\u0001\u0000"+
		"\u0000\u0000\u00af\u00a9\u0001\u0000\u0000\u0000\u00b0\r\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b7\u00057\u0000\u0000\u00b2\u00b3\u00052\u0000\u0000\u00b3"+
		"\u00b7\u0005-\u0000\u0000\u00b4\u00b5\u00052\u0000\u0000\u00b5\u00b7\u0005"+
		",\u0000\u0000\u00b6\u00b1\u0001\u0000\u0000\u0000\u00b6\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u000f\u0001\u0000"+
		"\u0000\u0000\u00b8\u00bd\u0005<\u0000\u0000\u00b9\u00be\u0003\u0018\f"+
		"\u0000\u00ba\u00bb\u00058\u0000\u0000\u00bb\u00be\u0003\u0012\t\u0000"+
		"\u00bc\u00be\u0005+\u0000\u0000\u00bd\u00b9\u0001\u0000\u0000\u0000\u00bd"+
		"\u00ba\u0001\u0000\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be"+
		"\u00c7\u0001\u0000\u0000\u0000\u00bf\u00c4\u0005=\u0000\u0000\u00c0\u00c5"+
		"\u0003\u0018\f\u0000\u00c1\u00c2\u00058\u0000\u0000\u00c2\u00c5\u0003"+
		"\u0012\t\u0000\u00c3\u00c5\u0005+\u0000\u0000\u00c4\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6\u00b8\u0001\u0000"+
		"\u0000\u0000\u00c6\u00bf\u0001\u0000\u0000\u0000\u00c7\u00cb\u0001\u0000"+
		"\u0000\u0000\u00c8\u00cb\u0003\u0016\u000b\u0000\u00c9\u00cb\u0003\u0014"+
		"\n\u0000\u00ca\u00c6\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000"+
		"\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00cb\u0011\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0003\u0018\f\u0000\u00cd\u00ce\u0005.\u0000\u0000"+
		"\u00ce\u00cf\u0007\u0003\u0000\u0000\u00cf\u00d0\u0005/\u0000\u0000\u00d0"+
		"\u0013\u0001\u0000\u0000\u0000\u00d1\u00d3\u0005;\u0000\u0000\u00d2\u00d4"+
		"\u00051\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0003"+
		"\u0018\f\u0000\u00d6\u0015\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005&"+
		"\u0000\u0000\u00d8\u00d9\u00059\u0000\u0000\u00d9\u00da\u0003\u0018\f"+
		"\u0000\u00da\u00db\u00055\u0000\u0000\u00db\u00dc\u0003\u000e\u0007\u0000"+
		"\u00dc\u00dd\u00055\u0000\u0000\u00dd\u00de\u0003\u0018\f\u0000\u00de"+
		"\u00df\u0005:\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00e2"+
		"\u0003\u0018\f\u0000\u00e1\u00d7\u0001\u0000\u0000\u0000\u00e1\u00e0\u0001"+
		"\u0000\u0000\u0000\u00e2\u0017\u0001\u0000\u0000\u0000\u00e3\u00e5\u0005"+
		"=\u0000\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e9\u0005E\u0000"+
		"\u0000\u00e7\u00e9\u0005D\u0000\u0000\u00e8\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e9\u00f2\u0001\u0000\u0000\u0000"+
		"\u00ea\u00f0\u0003\u001c\u000e\u0000\u00eb\u00ed\u0005=\u0000\u0000\u00ec"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ee\u0001\u0000\u0000\u0000\u00ee\u00f1\u0005E\u0000\u0000\u00ef\u00f1"+
		"\u0005D\u0000\u0000\u00f0\u00ec\u0001\u0000\u0000\u0000\u00f0\u00ef\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f3\u0001\u0000\u0000\u0000\u00f2\u00ea\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u0125\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f9\u0003\u001a\r\u0000\u00f5\u00f6\u0005@"+
		"\u0000\u0000\u00f6\u00f8\u0003\u001a\r\u0000\u00f7\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u010c\u0001\u0000\u0000"+
		"\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00ff\u00059\u0000\u0000"+
		"\u00fd\u0100\u0003\u0018\f\u0000\u00fe\u0100\u0005F\u0000\u0000\u00ff"+
		"\u00fd\u0001\u0000\u0000\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u0100"+
		"\u0108\u0001\u0000\u0000\u0000\u0101\u0104\u00055\u0000\u0000\u0102\u0105"+
		"\u0003\u0018\f\u0000\u0103\u0105\u0005F\u0000\u0000\u0104\u0102\u0001"+
		"\u0000\u0000\u0000\u0104\u0103\u0001\u0000\u0000\u0000\u0105\u0107\u0001"+
		"\u0000\u0000\u0000\u0106\u0101\u0001\u0000\u0000\u0000\u0107\u010a\u0001"+
		"\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0108\u0109\u0001"+
		"\u0000\u0000\u0000\u0109\u010b\u0001\u0000\u0000\u0000\u010a\u0108\u0001"+
		"\u0000\u0000\u0000\u010b\u010d\u0005:\u0000\u0000\u010c\u00fc\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u0123\u0001\u0000"+
		"\u0000\u0000\u010e\u011b\u0005.\u0000\u0000\u010f\u0114\u0003\u0018\f"+
		"\u0000\u0110\u0111\u00055\u0000\u0000\u0111\u0113\u0003\u0018\f\u0000"+
		"\u0112\u0110\u0001\u0000\u0000\u0000\u0113\u0116\u0001\u0000\u0000\u0000"+
		"\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000"+
		"\u0115\u0119\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000"+
		"\u0117\u0118\u00050\u0000\u0000\u0118\u011a\u0005D\u0000\u0000\u0119\u0117"+
		"\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u011c"+
		"\u0001\u0000\u0000\u0000\u011b\u010f\u0001\u0000\u0000\u0000\u011b\u011c"+
		"\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u0123"+
		"\u0005/\u0000\u0000\u011e\u011f\u00059\u0000\u0000\u011f\u0120\u0003\u0018"+
		"\f\u0000\u0120\u0121\u0005:\u0000\u0000\u0121\u0123\u0001\u0000\u0000"+
		"\u0000\u0122\u00f4\u0001\u0000\u0000\u0000\u0122\u010e\u0001\u0000\u0000"+
		"\u0000\u0122\u011e\u0001\u0000\u0000\u0000\u0123\u0125\u0001\u0000\u0000"+
		"\u0000\u0124\u00e8\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000"+
		"\u0000\u0125\u0019\u0001\u0000\u0000\u0000\u0126\u0127\u0007\u0004\u0000"+
		"\u0000\u0127\u001b\u0001\u0000\u0000\u0000\u0128\u0129\u0007\u0005\u0000"+
		"\u0000\u0129\u001d\u0001\u0000\u0000\u0000\u012a\u012b\u0007\u0004\u0000"+
		"\u0000\u012b\u001f\u0001\u0000\u0000\u0000,&)19<BIORX_nx{\u0080\u008e"+
		"\u0095\u0098\u00a5\u00a7\u00ad\u00af\u00b6\u00bd\u00c4\u00c6\u00ca\u00d3"+
		"\u00e1\u00e4\u00e8\u00ec\u00f0\u00f2\u00f9\u00ff\u0104\u0108\u010c\u0114"+
		"\u0119\u011b\u0122\u0124";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}