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
		GWENDOLEN=1, NAME=2, CONST=3, COMMENT=4, LINE_COMMENT=5, NEWLINE=6, WS=7, 
		BELIEFS=8, BELIEFRULES=9, GOAL_IB=10, CAP_IB=11, IB_COMMENT=12, IB_LINE_COMMENT=13, 
		IB_NEWLINE=14, IB_WS=15, BELIEF_BLOCK=16, GOAL_RR=17, CAP_RR=18, RR_COMMENT=19, 
		RR_LINE_COMMENT=20, RR_NEWLINE=21, RR_WS=22, RR_BLOCK=23, GOAL_C=24, CAP_COMMENT=25, 
		CAP_LINE_COMMENT=26, CAP_NEWLINE=27, CAP_WS=28, CAP_CURLYOPEN=29, CAP_CURLYCLOSE=30, 
		CAP_BLOCK=31, PLANS=32, GL_COMMENT=33, GL_LINE_COMMENT=34, GL_NEWLINE=35, 
		GL_WS=36, GL_ACHIEVEGOAL=37, GL_PERFORMGOAL=38, GL_SQOPEN=39, GL_SQCLOSE=40, 
		GOAL_BLOCK=41, NAME_PM=42, PL_COMMENT=43, PL_LINE_COMMENT=44, PL_NEWLINE=45, 
		PL_WS=46, SEND=47, RECEIVED=48, BELIEVE=49, GOAL=50, SENT=51, LOCK=52, 
		QUERYCOM=53, PL_ACHIEVEGOAL=54, PL_PERFORMGOAL=55, PL_SQOPEN=56, PL_SQCLOSE=57, 
		PL_BAR=58, NOT=59, COLON=60, CURLYOPEN=61, CURLYCLOSE=62, COMMA=63, SEMI=64, 
		TELL=65, SHRIEK=66, OPEN=67, CLOSE=68, MULT=69, PLUS=70, MINUS=71, LESS=72, 
		EQUAL=73, IDPUNCT=74, RULEARROW=75, TRUE=76, PL_CONST=77, PL_VAR=78, NUMBER=79, 
		QUOTED_STRING=80;
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
			null, "'GWENDOLEN'", null, null, null, null, null, null, "':Initial Beliefs:'", 
			"':Reasoning Rules:'", null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'Initial Goals:'", null, null, null, 
			null, null, null, null, "':Plans:'", null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "'.send'", "'.received'", 
			null, null, "'.sent'", "'.lock'", "'.query'", "'achieve'", "'perform'", 
			null, null, "'|'", "'~'", "':'", null, null, "','", "';'", "':tell'", 
			"'!'", "'('", "')'", "'*'", "'+'", "'-'", "'<'", "'=='", "'.'", "'<-'", 
			"'True'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "GWENDOLEN", "NAME", "CONST", "COMMENT", "LINE_COMMENT", "NEWLINE", 
			"WS", "BELIEFS", "BELIEFRULES", "GOAL_IB", "CAP_IB", "IB_COMMENT", "IB_LINE_COMMENT", 
			"IB_NEWLINE", "IB_WS", "BELIEF_BLOCK", "GOAL_RR", "CAP_RR", "RR_COMMENT", 
			"RR_LINE_COMMENT", "RR_NEWLINE", "RR_WS", "RR_BLOCK", "GOAL_C", "CAP_COMMENT", 
			"CAP_LINE_COMMENT", "CAP_NEWLINE", "CAP_WS", "CAP_CURLYOPEN", "CAP_CURLYCLOSE", 
			"CAP_BLOCK", "PLANS", "GL_COMMENT", "GL_LINE_COMMENT", "GL_NEWLINE", 
			"GL_WS", "GL_ACHIEVEGOAL", "GL_PERFORMGOAL", "GL_SQOPEN", "GL_SQCLOSE", 
			"GOAL_BLOCK", "NAME_PM", "PL_COMMENT", "PL_LINE_COMMENT", "PL_NEWLINE", 
			"PL_WS", "SEND", "RECEIVED", "BELIEVE", "GOAL", "SENT", "LOCK", "QUERYCOM", 
			"PL_ACHIEVEGOAL", "PL_PERFORMGOAL", "PL_SQOPEN", "PL_SQCLOSE", "PL_BAR", 
			"NOT", "COLON", "CURLYOPEN", "CURLYCLOSE", "COMMA", "SEMI", "TELL", "SHRIEK", 
			"OPEN", "CLOSE", "MULT", "PLUS", "MINUS", "LESS", "EQUAL", "IDPUNCT", 
			"RULEARROW", "TRUE", "PL_CONST", "PL_VAR", "NUMBER", "QUOTED_STRING"
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4398046511110L) != 0) );
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
		public List<TerminalNode> RR_NEWLINE() { return getTokens(GwendolenParser.RR_NEWLINE); }
		public TerminalNode RR_NEWLINE(int i) {
			return getToken(GwendolenParser.RR_NEWLINE, i);
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
			setState(45);
			match(BELIEFS);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BELIEF_BLOCK) {
				{
				{
				setState(46);
				((GwendolenagentContext)_localctx).bs = match(BELIEF_BLOCK);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BELIEFRULES) {
				{
				setState(52);
				match(BELIEFRULES);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_NEWLINE) {
					{
					{
					setState(53);
					match(RR_NEWLINE);
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_BLOCK) {
					{
					{
					setState(59);
					((GwendolenagentContext)_localctx).rr = match(RR_BLOCK);
					setState(60);
					match(RR_NEWLINE);
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(68);
			_la = _input.LA(1);
			if ( !(_la==GOAL_IB || _la==GOAL_RR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GOAL_BLOCK) {
				{
				{
				setState(69);
				((GwendolenagentContext)_localctx).gs = initial_goal();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			match(PLANS);
			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(76);
				((GwendolenagentContext)_localctx).p = plan();
				}
				}
				setState(79); 
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
			setState(81);
			((Initial_goalContext)_localctx).g = match(GOAL_BLOCK);
			setState(82);
			match(GL_SQOPEN);
			setState(83);
			_la = _input.LA(1);
			if ( !(_la==GL_ACHIEVEGOAL || _la==GL_PERFORMGOAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(84);
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
			setState(86);
			((PlanContext)_localctx).e = event();
			setState(87);
			match(COLON);
			setState(88);
			match(CURLYOPEN);
			setState(89);
			((PlanContext)_localctx).gb = guard_atom();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(90);
				match(COMMA);
				setState(91);
				((PlanContext)_localctx).gb = guard_atom();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
			match(CURLYCLOSE);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULEARROW) {
				{
				setState(98);
				match(RULEARROW);
				setState(99);
				((PlanContext)_localctx).d = deed();
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(100);
					match(COMMA);
					setState(101);
					((PlanContext)_localctx).d = deed();
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(109);
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
			setState(136);
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
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(111);
					match(NOT);
					}
				}

				setState(133);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BELIEVE:
					{
					setState(114);
					match(BELIEVE);
					setState(115);
					((Guard_atomContext)_localctx).l = fof_expr();
					}
					break;
				case GOAL:
					{
					setState(116);
					match(GOAL);
					setState(117);
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
					setState(118);
					((Guard_atomContext)_localctx).eq = fof_expr();
					}
					break;
				case SENT:
					{
					setState(119);
					match(SENT);
					setState(120);
					match(OPEN);
					{
					setState(121);
					((Guard_atomContext)_localctx).s = agentnameterm();
					}
					setState(122);
					match(COMMA);
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PL_CONST || _la==PL_VAR) {
						{
						setState(123);
						((Guard_atomContext)_localctx).an2 = agentnameterm();
						setState(124);
						match(COMMA);
						}
					}

					setState(128);
					((Guard_atomContext)_localctx).p = performative();
					setState(129);
					match(COMMA);
					setState(130);
					((Guard_atomContext)_localctx).t = fof_expr();
					setState(131);
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
				setState(135);
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
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(138);
				match(PLUS);
				setState(151);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RECEIVED:
					{
					setState(139);
					match(RECEIVED);
					setState(140);
					match(OPEN);
					setState(141);
					((EventContext)_localctx).p = performative();
					setState(142);
					match(COMMA);
					setState(143);
					((EventContext)_localctx).t = fof_expr();
					setState(144);
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
					setState(149);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PL_SQOPEN:
					case OPEN:
					case MINUS:
					case PL_CONST:
					case PL_VAR:
					case NUMBER:
						{
						setState(146);
						((EventContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(147);
						match(SHRIEK);
						setState(148);
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
				setState(153);
				match(MINUS);
				setState(157);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PL_SQOPEN:
				case OPEN:
				case MINUS:
				case PL_CONST:
				case PL_VAR:
				case NUMBER:
					{
					setState(154);
					((EventContext)_localctx).l = fof_expr();
					}
					break;
				case SHRIEK:
					{
					setState(155);
					match(SHRIEK);
					setState(156);
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
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(161);
				match(TELL);
				}
				break;
			case 2:
				{
				setState(162);
				match(COLON);
				setState(163);
				match(PL_PERFORMGOAL);
				}
				break;
			case 3:
				{
				setState(164);
				match(COLON);
				setState(165);
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
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(182);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					{
					setState(168);
					match(PLUS);
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
						setState(169);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(170);
						match(SHRIEK);
						setState(171);
						((DeedContext)_localctx).g = goal();
						}
						break;
					case LOCK:
						{
						setState(172);
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
					setState(175);
					match(MINUS);
					setState(180);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PL_SQOPEN:
					case OPEN:
					case MINUS:
					case PL_CONST:
					case PL_VAR:
					case NUMBER:
						{
						setState(176);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(177);
						match(SHRIEK);
						setState(178);
						((DeedContext)_localctx).g = goal();
						}
						break;
					case LOCK:
						{
						setState(179);
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
				setState(184);
				((DeedContext)_localctx).a = action();
				}
				break;
			case 3:
				{
				setState(185);
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
			setState(188);
			((GoalContext)_localctx).g = fof_expr();
			setState(189);
			match(PL_SQOPEN);
			setState(190);
			_la = _input.LA(1);
			if ( !(_la==PL_ACHIEVEGOAL || _la==PL_PERFORMGOAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(191);
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
			setState(193);
			match(MULT);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(194);
				match(NOT);
				}
			}

			setState(197);
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
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEND:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(199);
				match(SEND);
				setState(200);
				match(OPEN);
				setState(201);
				((ActionContext)_localctx).an = fof_expr();
				setState(202);
				match(COMMA);
				setState(203);
				((ActionContext)_localctx).p = performative();
				setState(204);
				match(COMMA);
				setState(205);
				((ActionContext)_localctx).t = fof_expr();
				setState(206);
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
				setState(208);
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
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MINUS:
				case NUMBER:
					{
					setState(212);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==MINUS) {
						{
						setState(211);
						match(MINUS);
						}
					}

					setState(214);
					match(NUMBER);
					}
					break;
				case PL_VAR:
					{
					setState(215);
					match(PL_VAR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 15L) != 0)) {
					{
					setState(218);
					oper();
					setState(224);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case MINUS:
					case NUMBER:
						{
						setState(220);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MINUS) {
							{
							setState(219);
							match(MINUS);
							}
						}

						setState(222);
						match(NUMBER);
						}
						break;
					case PL_VAR:
						{
						setState(223);
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
				setState(274);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PL_CONST:
				case PL_VAR:
					{
					setState(228);
					const_var();
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==IDPUNCT) {
						{
						{
						setState(229);
						match(IDPUNCT);
						setState(230);
						const_var();
						}
						}
						setState(235);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==OPEN) {
						{
						setState(236);
						match(OPEN);
						setState(239);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case PL_SQOPEN:
						case OPEN:
						case MINUS:
						case PL_CONST:
						case PL_VAR:
						case NUMBER:
							{
							setState(237);
							fof_expr();
							}
							break;
						case QUOTED_STRING:
							{
							setState(238);
							match(QUOTED_STRING);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(248);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(241);
							match(COMMA);
							setState(244);
							_errHandler.sync(this);
							switch (_input.LA(1)) {
							case PL_SQOPEN:
							case OPEN:
							case MINUS:
							case PL_CONST:
							case PL_VAR:
							case NUMBER:
								{
								setState(242);
								fof_expr();
								}
								break;
							case QUOTED_STRING:
								{
								setState(243);
								match(QUOTED_STRING);
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							}
							}
							setState(250);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(251);
						match(CLOSE);
						}
					}

					}
					break;
				case PL_SQOPEN:
					{
					setState(254);
					match(PL_SQOPEN);
					setState(267);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & 14714881L) != 0)) {
						{
						setState(255);
						fof_expr();
						setState(260);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(256);
							match(COMMA);
							setState(257);
							fof_expr();
							}
							}
							setState(262);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(265);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==PL_BAR) {
							{
							setState(263);
							match(PL_BAR);
							setState(264);
							match(PL_VAR);
							}
						}

						}
					}

					setState(269);
					match(PL_SQCLOSE);
					}
					break;
				case OPEN:
					{
					setState(270);
					match(OPEN);
					setState(271);
					fof_expr();
					setState(272);
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
			setState(278);
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
			setState(280);
			_la = _input.LA(1);
			if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 15L) != 0)) ) {
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
			setState(282);
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
		"\u0004\u0001P\u011d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0004\u0001%\b\u0001"+
		"\u000b\u0001\f\u0001&\u0001\u0002\u0003\u0002*\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u00020\b\u0002\n\u0002\f\u00023\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u00027\b\u0002\n\u0002\f\u0002:\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002>\b\u0002\n\u0002\f\u0002A\t"+
		"\u0002\u0003\u0002C\b\u0002\u0001\u0002\u0001\u0002\u0005\u0002G\b\u0002"+
		"\n\u0002\f\u0002J\t\u0002\u0001\u0002\u0001\u0002\u0004\u0002N\b\u0002"+
		"\u000b\u0002\f\u0002O\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004]\b\u0004\n\u0004\f\u0004`\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004g\b\u0004"+
		"\n\u0004\f\u0004j\t\u0004\u0003\u0004l\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0003\u0005q\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u007f\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0086\b\u0005"+
		"\u0001\u0005\u0003\u0005\u0089\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u0096\b\u0006\u0003\u0006\u0098\b"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u009e"+
		"\b\u0006\u0003\u0006\u00a0\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u00a7\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u00ae\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u00b5\b\b\u0003\b\u00b7\b\b\u0001\b\u0001\b\u0003\b\u00bb\b"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n\u00c4"+
		"\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00d2\b\u000b\u0001\f\u0003\f\u00d5\b\f\u0001\f\u0001\f\u0003\f"+
		"\u00d9\b\f\u0001\f\u0001\f\u0003\f\u00dd\b\f\u0001\f\u0001\f\u0003\f\u00e1"+
		"\b\f\u0003\f\u00e3\b\f\u0001\f\u0001\f\u0001\f\u0005\f\u00e8\b\f\n\f\f"+
		"\f\u00eb\t\f\u0001\f\u0001\f\u0001\f\u0003\f\u00f0\b\f\u0001\f\u0001\f"+
		"\u0001\f\u0003\f\u00f5\b\f\u0005\f\u00f7\b\f\n\f\f\f\u00fa\t\f\u0001\f"+
		"\u0003\f\u00fd\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0103\b\f\n"+
		"\f\f\f\u0106\t\f\u0001\f\u0001\f\u0003\f\u010a\b\f\u0003\f\u010c\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0113\b\f\u0003\f\u0115\b\f"+
		"\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0006\u0002\u0000\u0002\u0002"+
		"**\u0002\u0000\n\n\u0011\u0011\u0001\u0000%&\u0001\u000067\u0001\u0000"+
		"MN\u0001\u0000FI\u013c\u0000 \u0001\u0000\u0000\u0000\u0002\"\u0001\u0000"+
		"\u0000\u0000\u0004)\u0001\u0000\u0000\u0000\u0006Q\u0001\u0000\u0000\u0000"+
		"\bV\u0001\u0000\u0000\u0000\n\u0088\u0001\u0000\u0000\u0000\f\u009f\u0001"+
		"\u0000\u0000\u0000\u000e\u00a6\u0001\u0000\u0000\u0000\u0010\u00ba\u0001"+
		"\u0000\u0000\u0000\u0012\u00bc\u0001\u0000\u0000\u0000\u0014\u00c1\u0001"+
		"\u0000\u0000\u0000\u0016\u00d1\u0001\u0000\u0000\u0000\u0018\u0114\u0001"+
		"\u0000\u0000\u0000\u001a\u0116\u0001\u0000\u0000\u0000\u001c\u0118\u0001"+
		"\u0000\u0000\u0000\u001e\u011a\u0001\u0000\u0000\u0000 !\u0003\u0002\u0001"+
		"\u0000!\u0001\u0001\u0000\u0000\u0000\"$\u0005\u0001\u0000\u0000#%\u0003"+
		"\u0004\u0002\u0000$#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000"+
		"&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'\u0003\u0001\u0000"+
		"\u0000\u0000(*\u0005\u0001\u0000\u0000)(\u0001\u0000\u0000\u0000)*\u0001"+
		"\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+,\u0007\u0000\u0000\u0000"+
		",-\u0005\u0003\u0000\u0000-1\u0005\b\u0000\u0000.0\u0005\u0010\u0000\u0000"+
		"/.\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u00001/\u0001\u0000\u0000"+
		"\u000012\u0001\u0000\u0000\u00002B\u0001\u0000\u0000\u000031\u0001\u0000"+
		"\u0000\u000048\u0005\t\u0000\u000057\u0005\u0015\u0000\u000065\u0001\u0000"+
		"\u0000\u00007:\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001"+
		"\u0000\u0000\u00009?\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000"+
		";<\u0005\u0017\u0000\u0000<>\u0005\u0015\u0000\u0000=;\u0001\u0000\u0000"+
		"\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000"+
		"\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000B4\u0001"+
		"\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000"+
		"DH\u0007\u0001\u0000\u0000EG\u0003\u0006\u0003\u0000FE\u0001\u0000\u0000"+
		"\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000"+
		"\u0000\u0000IK\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KM\u0005"+
		" \u0000\u0000LN\u0003\b\u0004\u0000ML\u0001\u0000\u0000\u0000NO\u0001"+
		"\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000"+
		"P\u0005\u0001\u0000\u0000\u0000QR\u0005)\u0000\u0000RS\u0005\'\u0000\u0000"+
		"ST\u0007\u0002\u0000\u0000TU\u0005(\u0000\u0000U\u0007\u0001\u0000\u0000"+
		"\u0000VW\u0003\f\u0006\u0000WX\u0005<\u0000\u0000XY\u0005=\u0000\u0000"+
		"Y^\u0003\n\u0005\u0000Z[\u0005?\u0000\u0000[]\u0003\n\u0005\u0000\\Z\u0001"+
		"\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000"+
		"^_\u0001\u0000\u0000\u0000_a\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000"+
		"\u0000ak\u0005>\u0000\u0000bc\u0005K\u0000\u0000ch\u0003\u0010\b\u0000"+
		"de\u0005?\u0000\u0000eg\u0003\u0010\b\u0000fd\u0001\u0000\u0000\u0000"+
		"gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000"+
		"\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000kb\u0001\u0000"+
		"\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0005"+
		"@\u0000\u0000n\t\u0001\u0000\u0000\u0000oq\u0005;\u0000\u0000po\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000q\u0085\u0001\u0000\u0000"+
		"\u0000rs\u00051\u0000\u0000s\u0086\u0003\u0018\f\u0000tu\u00052\u0000"+
		"\u0000u\u0086\u0003\u0012\t\u0000v\u0086\u0003\u0018\f\u0000wx\u00053"+
		"\u0000\u0000xy\u0005C\u0000\u0000yz\u0003\u001e\u000f\u0000z~\u0005?\u0000"+
		"\u0000{|\u0003\u001e\u000f\u0000|}\u0005?\u0000\u0000}\u007f\u0001\u0000"+
		"\u0000\u0000~{\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0003\u000e\u0007\u0000"+
		"\u0081\u0082\u0005?\u0000\u0000\u0082\u0083\u0003\u0018\f\u0000\u0083"+
		"\u0084\u0005D\u0000\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085r\u0001"+
		"\u0000\u0000\u0000\u0085t\u0001\u0000\u0000\u0000\u0085v\u0001\u0000\u0000"+
		"\u0000\u0085w\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000"+
		"\u0087\u0089\u0005L\u0000\u0000\u0088p\u0001\u0000\u0000\u0000\u0088\u0087"+
		"\u0001\u0000\u0000\u0000\u0089\u000b\u0001\u0000\u0000\u0000\u008a\u0097"+
		"\u0005F\u0000\u0000\u008b\u008c\u00050\u0000\u0000\u008c\u008d\u0005C"+
		"\u0000\u0000\u008d\u008e\u0003\u000e\u0007\u0000\u008e\u008f\u0005?\u0000"+
		"\u0000\u008f\u0090\u0003\u0018\f\u0000\u0090\u0091\u0005D\u0000\u0000"+
		"\u0091\u0098\u0001\u0000\u0000\u0000\u0092\u0096\u0003\u0018\f\u0000\u0093"+
		"\u0094\u0005B\u0000\u0000\u0094\u0096\u0003\u0012\t\u0000\u0095\u0092"+
		"\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u0098"+
		"\u0001\u0000\u0000\u0000\u0097\u008b\u0001\u0000\u0000\u0000\u0097\u0095"+
		"\u0001\u0000\u0000\u0000\u0098\u00a0\u0001\u0000\u0000\u0000\u0099\u009d"+
		"\u0005G\u0000\u0000\u009a\u009e\u0003\u0018\f\u0000\u009b\u009c\u0005"+
		"B\u0000\u0000\u009c\u009e\u0003\u0012\t\u0000\u009d\u009a\u0001\u0000"+
		"\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u00a0\u0001\u0000"+
		"\u0000\u0000\u009f\u008a\u0001\u0000\u0000\u0000\u009f\u0099\u0001\u0000"+
		"\u0000\u0000\u00a0\r\u0001\u0000\u0000\u0000\u00a1\u00a7\u0005A\u0000"+
		"\u0000\u00a2\u00a3\u0005<\u0000\u0000\u00a3\u00a7\u00057\u0000\u0000\u00a4"+
		"\u00a5\u0005<\u0000\u0000\u00a5\u00a7\u00056\u0000\u0000\u00a6\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a2\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a7\u000f\u0001\u0000\u0000\u0000\u00a8\u00ad\u0005"+
		"F\u0000\u0000\u00a9\u00ae\u0003\u0018\f\u0000\u00aa\u00ab\u0005B\u0000"+
		"\u0000\u00ab\u00ae\u0003\u0012\t\u0000\u00ac\u00ae\u00054\u0000\u0000"+
		"\u00ad\u00a9\u0001\u0000\u0000\u0000\u00ad\u00aa\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae\u00b7\u0001\u0000\u0000\u0000"+
		"\u00af\u00b4\u0005G\u0000\u0000\u00b0\u00b5\u0003\u0018\f\u0000\u00b1"+
		"\u00b2\u0005B\u0000\u0000\u00b2\u00b5\u0003\u0012\t\u0000\u00b3\u00b5"+
		"\u00054\u0000\u0000\u00b4\u00b0\u0001\u0000\u0000\u0000\u00b4\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b6\u00a8\u0001\u0000\u0000\u0000\u00b6\u00af\u0001"+
		"\u0000\u0000\u0000\u00b7\u00bb\u0001\u0000\u0000\u0000\u00b8\u00bb\u0003"+
		"\u0016\u000b\u0000\u00b9\u00bb\u0003\u0014\n\u0000\u00ba\u00b6\u0001\u0000"+
		"\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00b9\u0001\u0000"+
		"\u0000\u0000\u00bb\u0011\u0001\u0000\u0000\u0000\u00bc\u00bd\u0003\u0018"+
		"\f\u0000\u00bd\u00be\u00058\u0000\u0000\u00be\u00bf\u0007\u0003\u0000"+
		"\u0000\u00bf\u00c0\u00059\u0000\u0000\u00c0\u0013\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c3\u0005E\u0000\u0000\u00c2\u00c4\u0005;\u0000\u0000\u00c3\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c6\u0003\u0018\f\u0000\u00c6\u0015\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c8\u0005/\u0000\u0000\u00c8\u00c9\u0005C\u0000"+
		"\u0000\u00c9\u00ca\u0003\u0018\f\u0000\u00ca\u00cb\u0005?\u0000\u0000"+
		"\u00cb\u00cc\u0003\u000e\u0007\u0000\u00cc\u00cd\u0005?\u0000\u0000\u00cd"+
		"\u00ce\u0003\u0018\f\u0000\u00ce\u00cf\u0005D\u0000\u0000\u00cf\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d0\u00d2\u0003\u0018\f\u0000\u00d1\u00c7\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d2\u0017\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d5\u0005G\u0000\u0000\u00d4\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d9\u0005O\u0000\u0000\u00d7\u00d9\u0005N\u0000\u0000"+
		"\u00d8\u00d4\u0001\u0000\u0000\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d9\u00e2\u0001\u0000\u0000\u0000\u00da\u00e0\u0003\u001c\u000e\u0000"+
		"\u00db\u00dd\u0005G\u0000\u0000\u00dc\u00db\u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de"+
		"\u00e1\u0005O\u0000\u0000\u00df\u00e1\u0005N\u0000\u0000\u00e0\u00dc\u0001"+
		"\u0000\u0000\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e1\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e2\u00da\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e3\u0115\u0001\u0000\u0000\u0000\u00e4\u00e9\u0003"+
		"\u001a\r\u0000\u00e5\u00e6\u0005J\u0000\u0000\u00e6\u00e8\u0003\u001a"+
		"\r\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000"+
		"\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ea\u00fc\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ef\u0005C\u0000\u0000\u00ed\u00f0\u0003\u0018\f\u0000"+
		"\u00ee\u00f0\u0005P\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef"+
		"\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f8\u0001\u0000\u0000\u0000\u00f1"+
		"\u00f4\u0005?\u0000\u0000\u00f2\u00f5\u0003\u0018\f\u0000\u00f3\u00f5"+
		"\u0005P\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fd\u0005"+
		"D\u0000\u0000\u00fc\u00ec\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000"+
		"\u0000\u0000\u00fd\u0113\u0001\u0000\u0000\u0000\u00fe\u010b\u00058\u0000"+
		"\u0000\u00ff\u0104\u0003\u0018\f\u0000\u0100\u0101\u0005?\u0000\u0000"+
		"\u0101\u0103\u0003\u0018\f\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0103"+
		"\u0106\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104"+
		"\u0105\u0001\u0000\u0000\u0000\u0105\u0109\u0001\u0000\u0000\u0000\u0106"+
		"\u0104\u0001\u0000\u0000\u0000\u0107\u0108\u0005:\u0000\u0000\u0108\u010a"+
		"\u0005N\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u010a\u0001"+
		"\u0000\u0000\u0000\u010a\u010c\u0001\u0000\u0000\u0000\u010b\u00ff\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010d\u0001"+
		"\u0000\u0000\u0000\u010d\u0113\u00059\u0000\u0000\u010e\u010f\u0005C\u0000"+
		"\u0000\u010f\u0110\u0003\u0018\f\u0000\u0110\u0111\u0005D\u0000\u0000"+
		"\u0111\u0113\u0001\u0000\u0000\u0000\u0112\u00e4\u0001\u0000\u0000\u0000"+
		"\u0112\u00fe\u0001\u0000\u0000\u0000\u0112\u010e\u0001\u0000\u0000\u0000"+
		"\u0113\u0115\u0001\u0000\u0000\u0000\u0114\u00d8\u0001\u0000\u0000\u0000"+
		"\u0114\u0112\u0001\u0000\u0000\u0000\u0115\u0019\u0001\u0000\u0000\u0000"+
		"\u0116\u0117\u0007\u0004\u0000\u0000\u0117\u001b\u0001\u0000\u0000\u0000"+
		"\u0118\u0119\u0007\u0005\u0000\u0000\u0119\u001d\u0001\u0000\u0000\u0000"+
		"\u011a\u011b\u0007\u0004\u0000\u0000\u011b\u001f\u0001\u0000\u0000\u0000"+
		")&)18?BHO^hkp~\u0085\u0088\u0095\u0097\u009d\u009f\u00a6\u00ad\u00b4\u00b6"+
		"\u00ba\u00c3\u00d1\u00d4\u00d8\u00dc\u00e0\u00e2\u00e9\u00ef\u00f4\u00f8"+
		"\u00fc\u0104\u0109\u010b\u0112\u0114";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}