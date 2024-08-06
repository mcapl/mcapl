// Generated from /Users/louisedennis/eclipse-workspace/mcapl/src/classes/gwendolen/parser/antlr/Gwendolen.g4 by ANTLR 4.7
package gwendolen.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GwendolenParser extends Parser {
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
		RULE_mas = 0, RULE_gwendolenagents = 1, RULE_gwendolenagent = 2, RULE_initial_goal = 3, 
		RULE_plan = 4, RULE_guard_atom = 5, RULE_event = 6, RULE_performative = 7, 
		RULE_deed = 8, RULE_goal = 9, RULE_waitfor = 10, RULE_action = 11, RULE_fof_expr = 12, 
		RULE_const_var = 13, RULE_oper = 14, RULE_agentnameterm = 15;
	public static final String[] ruleNames = {
		"mas", "gwendolenagents", "gwendolenagent", "initial_goal", "plan", "guard_atom", 
		"event", "performative", "deed", "goal", "waitfor", "action", "fof_expr", 
		"const_var", "oper", "agentnameterm"
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GWENDOLEN) | (1L << NAME) | (1L << NAME_PM))) != 0) );
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
			setState(65);
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
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_BLOCK) {
					{
					{
					setState(59);
					((GwendolenagentContext)_localctx).rr = match(RR_BLOCK);
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(67);
			_la = _input.LA(1);
			if ( !(_la==GOAL_IB || _la==GOAL_RR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GOAL_BLOCK) {
				{
				{
				setState(68);
				((GwendolenagentContext)_localctx).gs = initial_goal();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(PLANS);
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				((GwendolenagentContext)_localctx).p = plan();
				}
				}
				setState(78); 
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
			setState(80);
			((Initial_goalContext)_localctx).g = match(GOAL_BLOCK);
			setState(81);
			match(GL_SQOPEN);
			setState(82);
			_la = _input.LA(1);
			if ( !(_la==GL_ACHIEVEGOAL || _la==GL_PERFORMGOAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(83);
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
			setState(85);
			((PlanContext)_localctx).e = event();
			setState(86);
			match(COLON);
			setState(87);
			match(CURLYOPEN);
			setState(88);
			((PlanContext)_localctx).gb = guard_atom();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(89);
				match(COMMA);
				setState(90);
				((PlanContext)_localctx).gb = guard_atom();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			match(CURLYCLOSE);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULEARROW) {
				{
				setState(97);
				match(RULEARROW);
				setState(98);
				((PlanContext)_localctx).d = deed();
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(99);
					match(COMMA);
					setState(100);
					((PlanContext)_localctx).d = deed();
					}
					}
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(108);
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
			setState(135);
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
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(110);
					match(NOT);
					}
				}

				setState(132);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BELIEVE:
					{
					setState(113);
					match(BELIEVE);
					setState(114);
					((Guard_atomContext)_localctx).l = fof_expr();
					}
					break;
				case GOAL:
					{
					setState(115);
					match(GOAL);
					setState(116);
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
					setState(117);
					((Guard_atomContext)_localctx).eq = fof_expr();
					}
					break;
				case SENT:
					{
					setState(118);
					match(SENT);
					setState(119);
					match(OPEN);
					{
					setState(120);
					((Guard_atomContext)_localctx).s = agentnameterm();
					}
					setState(121);
					match(COMMA);
					setState(125);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PL_CONST || _la==PL_VAR) {
						{
						setState(122);
						((Guard_atomContext)_localctx).an2 = agentnameterm();
						setState(123);
						match(COMMA);
						}
					}

					setState(127);
					((Guard_atomContext)_localctx).p = performative();
					setState(128);
					match(COMMA);
					setState(129);
					((Guard_atomContext)_localctx).t = fof_expr();
					setState(130);
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
				setState(134);
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
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(137);
				match(PLUS);
				setState(150);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RECEIVED:
					{
					setState(138);
					match(RECEIVED);
					setState(139);
					match(OPEN);
					setState(140);
					((EventContext)_localctx).p = performative();
					setState(141);
					match(COMMA);
					setState(142);
					((EventContext)_localctx).t = fof_expr();
					setState(143);
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
					setState(148);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PL_SQOPEN:
					case OPEN:
					case MINUS:
					case PL_CONST:
					case PL_VAR:
					case NUMBER:
						{
						setState(145);
						((EventContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(146);
						match(SHRIEK);
						setState(147);
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
				setState(152);
				match(MINUS);
				setState(156);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PL_SQOPEN:
				case OPEN:
				case MINUS:
				case PL_CONST:
				case PL_VAR:
				case NUMBER:
					{
					setState(153);
					((EventContext)_localctx).l = fof_expr();
					}
					break;
				case SHRIEK:
					{
					setState(154);
					match(SHRIEK);
					setState(155);
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
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(160);
				match(TELL);
				}
				break;
			case 2:
				{
				setState(161);
				match(COLON);
				setState(162);
				match(PL_PERFORMGOAL);
				}
				break;
			case 3:
				{
				setState(163);
				match(COLON);
				setState(164);
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
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(181);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					{
					setState(167);
					match(PLUS);
					setState(172);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PL_SQOPEN:
					case OPEN:
					case MINUS:
					case PL_CONST:
					case PL_VAR:
					case NUMBER:
						{
						setState(168);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(169);
						match(SHRIEK);
						setState(170);
						((DeedContext)_localctx).g = goal();
						}
						break;
					case LOCK:
						{
						setState(171);
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
					setState(174);
					match(MINUS);
					setState(179);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PL_SQOPEN:
					case OPEN:
					case MINUS:
					case PL_CONST:
					case PL_VAR:
					case NUMBER:
						{
						setState(175);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(176);
						match(SHRIEK);
						setState(177);
						((DeedContext)_localctx).g = goal();
						}
						break;
					case LOCK:
						{
						setState(178);
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
				setState(183);
				((DeedContext)_localctx).a = action();
				}
				break;
			case 3:
				{
				setState(184);
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
			setState(187);
			((GoalContext)_localctx).g = fof_expr();
			setState(188);
			match(PL_SQOPEN);
			setState(189);
			_la = _input.LA(1);
			if ( !(_la==PL_ACHIEVEGOAL || _la==PL_PERFORMGOAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(190);
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
			setState(192);
			match(MULT);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(193);
				match(NOT);
				}
			}

			setState(196);
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
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEND:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(198);
				match(SEND);
				setState(199);
				match(OPEN);
				setState(200);
				((ActionContext)_localctx).an = fof_expr();
				setState(201);
				match(COMMA);
				setState(202);
				((ActionContext)_localctx).p = performative();
				setState(203);
				match(COMMA);
				setState(204);
				((ActionContext)_localctx).t = fof_expr();
				setState(205);
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
				setState(207);
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
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MINUS:
				case NUMBER:
					{
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==MINUS) {
						{
						setState(210);
						match(MINUS);
						}
					}

					setState(213);
					match(NUMBER);
					}
					break;
				case PL_VAR:
					{
					setState(214);
					match(PL_VAR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << LESS) | (1L << EQUAL))) != 0)) {
					{
					setState(217);
					oper();
					setState(223);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case MINUS:
					case NUMBER:
						{
						setState(219);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MINUS) {
							{
							setState(218);
							match(MINUS);
							}
						}

						setState(221);
						match(NUMBER);
						}
						break;
					case PL_VAR:
						{
						setState(222);
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
				setState(273);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PL_CONST:
				case PL_VAR:
					{
					setState(227);
					const_var();
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==IDPUNCT) {
						{
						{
						setState(228);
						match(IDPUNCT);
						setState(229);
						const_var();
						}
						}
						setState(234);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(251);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==OPEN) {
						{
						setState(235);
						match(OPEN);
						setState(238);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case PL_SQOPEN:
						case OPEN:
						case MINUS:
						case PL_CONST:
						case PL_VAR:
						case NUMBER:
							{
							setState(236);
							fof_expr();
							}
							break;
						case QUOTED_STRING:
							{
							setState(237);
							match(QUOTED_STRING);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(247);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(240);
							match(COMMA);
							setState(243);
							_errHandler.sync(this);
							switch (_input.LA(1)) {
							case PL_SQOPEN:
							case OPEN:
							case MINUS:
							case PL_CONST:
							case PL_VAR:
							case NUMBER:
								{
								setState(241);
								fof_expr();
								}
								break;
							case QUOTED_STRING:
								{
								setState(242);
								match(QUOTED_STRING);
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							}
							}
							setState(249);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(250);
						match(CLOSE);
						}
					}

					}
					break;
				case PL_SQOPEN:
					{
					setState(253);
					match(PL_SQOPEN);
					setState(266);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (PL_SQOPEN - 45)) | (1L << (OPEN - 45)) | (1L << (MINUS - 45)) | (1L << (PL_CONST - 45)) | (1L << (PL_VAR - 45)) | (1L << (NUMBER - 45)))) != 0)) {
						{
						setState(254);
						fof_expr();
						setState(259);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(255);
							match(COMMA);
							setState(256);
							fof_expr();
							}
							}
							setState(261);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(264);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==PL_BAR) {
							{
							setState(262);
							match(PL_BAR);
							setState(263);
							match(PL_VAR);
							}
						}

						}
					}

					setState(268);
					match(PL_SQCLOSE);
					}
					break;
				case OPEN:
					{
					setState(269);
					match(OPEN);
					setState(270);
					fof_expr();
					setState(271);
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
			setState(277);
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
			setState(279);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << LESS) | (1L << EQUAL))) != 0)) ) {
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
			setState(281);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3G\u011e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\6\3\'\n\3\r\3\16\3(\3\4\5\4,\n\4\3\4\3\4\3\4\3\4\7\4\62\n\4\f\4"+
		"\16\4\65\13\4\3\4\3\4\7\49\n\4\f\4\16\4<\13\4\3\4\7\4?\n\4\f\4\16\4B\13"+
		"\4\5\4D\n\4\3\4\3\4\7\4H\n\4\f\4\16\4K\13\4\3\4\3\4\6\4O\n\4\r\4\16\4"+
		"P\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13\6"+
		"\3\6\3\6\3\6\3\6\3\6\7\6h\n\6\f\6\16\6k\13\6\5\6m\n\6\3\6\3\6\3\7\5\7"+
		"r\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0080\n\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7\u0087\n\7\3\7\5\7\u008a\n\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0097\n\b\5\b\u0099\n\b\3\b\3\b\3\b\3\b\5"+
		"\b\u009f\n\b\5\b\u00a1\n\b\3\t\3\t\3\t\3\t\3\t\5\t\u00a8\n\t\3\n\3\n\3"+
		"\n\3\n\3\n\5\n\u00af\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u00b6\n\n\5\n\u00b8\n"+
		"\n\3\n\3\n\5\n\u00bc\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\5\f\u00c5\n"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d3\n\r\3\16"+
		"\5\16\u00d6\n\16\3\16\3\16\5\16\u00da\n\16\3\16\3\16\5\16\u00de\n\16\3"+
		"\16\3\16\5\16\u00e2\n\16\5\16\u00e4\n\16\3\16\3\16\3\16\7\16\u00e9\n\16"+
		"\f\16\16\16\u00ec\13\16\3\16\3\16\3\16\5\16\u00f1\n\16\3\16\3\16\3\16"+
		"\5\16\u00f6\n\16\7\16\u00f8\n\16\f\16\16\16\u00fb\13\16\3\16\5\16\u00fe"+
		"\n\16\3\16\3\16\3\16\3\16\7\16\u0104\n\16\f\16\16\16\u0107\13\16\3\16"+
		"\3\16\5\16\u010b\n\16\5\16\u010d\n\16\3\16\3\16\3\16\3\16\3\16\5\16\u0114"+
		"\n\16\5\16\u0116\n\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\2\2\22\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \2\b\4\2\4\4\"\"\4\2\f\f\22\22\3\2\35"+
		"\36\3\2-.\3\2DE\3\2=@\2\u013d\2\"\3\2\2\2\4$\3\2\2\2\6+\3\2\2\2\bR\3\2"+
		"\2\2\nW\3\2\2\2\f\u0089\3\2\2\2\16\u00a0\3\2\2\2\20\u00a7\3\2\2\2\22\u00bb"+
		"\3\2\2\2\24\u00bd\3\2\2\2\26\u00c2\3\2\2\2\30\u00d2\3\2\2\2\32\u0115\3"+
		"\2\2\2\34\u0117\3\2\2\2\36\u0119\3\2\2\2 \u011b\3\2\2\2\"#\5\4\3\2#\3"+
		"\3\2\2\2$&\7\3\2\2%\'\5\6\4\2&%\3\2\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2"+
		")\5\3\2\2\2*,\7\3\2\2+*\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\t\2\2\2./\7\5\2"+
		"\2/\63\7\n\2\2\60\62\7\21\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2"+
		"\2\63\64\3\2\2\2\64C\3\2\2\2\65\63\3\2\2\2\66:\7\13\2\2\679\7\25\2\28"+
		"\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;@\3\2\2\2<:\3\2\2\2=?\7\27\2"+
		"\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AD\3\2\2\2B@\3\2\2\2C\66\3\2"+
		"\2\2CD\3\2\2\2DE\3\2\2\2EI\t\3\2\2FH\5\b\5\2GF\3\2\2\2HK\3\2\2\2IG\3\2"+
		"\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LN\7\30\2\2MO\5\n\6\2NM\3\2\2\2OP\3"+
		"\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\7\3\2\2\2RS\7!\2\2ST\7\37\2\2TU\t\4\2\2UV"+
		"\7 \2\2V\t\3\2\2\2WX\5\16\b\2XY\7\63\2\2YZ\7\64\2\2Z_\5\f\7\2[\\\7\66"+
		"\2\2\\^\5\f\7\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3"+
		"\2\2\2bl\7\65\2\2cd\7B\2\2di\5\22\n\2ef\7\66\2\2fh\5\22\n\2ge\3\2\2\2"+
		"hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jm\3\2\2\2ki\3\2\2\2lc\3\2\2\2lm\3\2\2\2"+
		"mn\3\2\2\2no\7\67\2\2o\13\3\2\2\2pr\7\62\2\2qp\3\2\2\2qr\3\2\2\2r\u0086"+
		"\3\2\2\2st\7)\2\2t\u0087\5\32\16\2uv\7*\2\2v\u0087\5\24\13\2w\u0087\5"+
		"\32\16\2xy\7+\2\2yz\7:\2\2z{\5 \21\2{\177\7\66\2\2|}\5 \21\2}~\7\66\2"+
		"\2~\u0080\3\2\2\2\177|\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0082\5\20\t\2\u0082\u0083\7\66\2\2\u0083\u0084\5\32\16\2\u0084\u0085"+
		"\7;\2\2\u0085\u0087\3\2\2\2\u0086s\3\2\2\2\u0086u\3\2\2\2\u0086w\3\2\2"+
		"\2\u0086x\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u008a\7C\2\2\u0089q\3\2\2"+
		"\2\u0089\u0088\3\2\2\2\u008a\r\3\2\2\2\u008b\u0098\7=\2\2\u008c\u008d"+
		"\7(\2\2\u008d\u008e\7:\2\2\u008e\u008f\5\20\t\2\u008f\u0090\7\66\2\2\u0090"+
		"\u0091\5\32\16\2\u0091\u0092\7;\2\2\u0092\u0099\3\2\2\2\u0093\u0097\5"+
		"\32\16\2\u0094\u0095\79\2\2\u0095\u0097\5\24\13\2\u0096\u0093\3\2\2\2"+
		"\u0096\u0094\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u008c\3\2\2\2\u0098\u0096"+
		"\3\2\2\2\u0099\u00a1\3\2\2\2\u009a\u009e\7>\2\2\u009b\u009f\5\32\16\2"+
		"\u009c\u009d\79\2\2\u009d\u009f\5\24\13\2\u009e\u009b\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u008b\3\2\2\2\u00a0\u009a\3\2\2\2\u00a1"+
		"\17\3\2\2\2\u00a2\u00a8\78\2\2\u00a3\u00a4\7\63\2\2\u00a4\u00a8\7.\2\2"+
		"\u00a5\u00a6\7\63\2\2\u00a6\u00a8\7-\2\2\u00a7\u00a2\3\2\2\2\u00a7\u00a3"+
		"\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\21\3\2\2\2\u00a9\u00ae\7=\2\2\u00aa"+
		"\u00af\5\32\16\2\u00ab\u00ac\79\2\2\u00ac\u00af\5\24\13\2\u00ad\u00af"+
		"\7,\2\2\u00ae\u00aa\3\2\2\2\u00ae\u00ab\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af"+
		"\u00b8\3\2\2\2\u00b0\u00b5\7>\2\2\u00b1\u00b6\5\32\16\2\u00b2\u00b3\7"+
		"9\2\2\u00b3\u00b6\5\24\13\2\u00b4\u00b6\7,\2\2\u00b5\u00b1\3\2\2\2\u00b5"+
		"\u00b2\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00a9\3\2"+
		"\2\2\u00b7\u00b0\3\2\2\2\u00b8\u00bc\3\2\2\2\u00b9\u00bc\5\30\r\2\u00ba"+
		"\u00bc\5\26\f\2\u00bb\u00b7\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3"+
		"\2\2\2\u00bc\23\3\2\2\2\u00bd\u00be\5\32\16\2\u00be\u00bf\7/\2\2\u00bf"+
		"\u00c0\t\5\2\2\u00c0\u00c1\7\60\2\2\u00c1\25\3\2\2\2\u00c2\u00c4\7<\2"+
		"\2\u00c3\u00c5\7\62\2\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c7\5\32\16\2\u00c7\27\3\2\2\2\u00c8\u00c9\7\'"+
		"\2\2\u00c9\u00ca\7:\2\2\u00ca\u00cb\5\32\16\2\u00cb\u00cc\7\66\2\2\u00cc"+
		"\u00cd\5\20\t\2\u00cd\u00ce\7\66\2\2\u00ce\u00cf\5\32\16\2\u00cf\u00d0"+
		"\7;\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00d3\5\32\16\2\u00d2\u00c8\3\2\2\2"+
		"\u00d2\u00d1\3\2\2\2\u00d3\31\3\2\2\2\u00d4\u00d6\7>\2\2\u00d5\u00d4\3"+
		"\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00da\7F\2\2\u00d8"+
		"\u00da\7E\2\2\u00d9\u00d5\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00e3\3\2"+
		"\2\2\u00db\u00e1\5\36\20\2\u00dc\u00de\7>\2\2\u00dd\u00dc\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e2\7F\2\2\u00e0\u00e2\7E\2"+
		"\2\u00e1\u00dd\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00db"+
		"\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u0116\3\2\2\2\u00e5\u00ea\5\34\17\2"+
		"\u00e6\u00e7\7A\2\2\u00e7\u00e9\5\34\17\2\u00e8\u00e6\3\2\2\2\u00e9\u00ec"+
		"\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00fd\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ed\u00f0\7:\2\2\u00ee\u00f1\5\32\16\2\u00ef\u00f1\7"+
		"G\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f9\3\2\2\2\u00f2"+
		"\u00f5\7\66\2\2\u00f3\u00f6\5\32\16\2\u00f4\u00f6\7G\2\2\u00f5\u00f3\3"+
		"\2\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f2\3\2\2\2\u00f8"+
		"\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2"+
		"\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fe\7;\2\2\u00fd\u00ed\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u0114\3\2\2\2\u00ff\u010c\7/\2\2\u0100\u0105\5\32"+
		"\16\2\u0101\u0102\7\66\2\2\u0102\u0104\5\32\16\2\u0103\u0101\3\2\2\2\u0104"+
		"\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u010a\3\2"+
		"\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7\61\2\2\u0109\u010b\7E\2\2\u010a"+
		"\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010d\3\2\2\2\u010c\u0100\3\2"+
		"\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0114\7\60\2\2\u010f"+
		"\u0110\7:\2\2\u0110\u0111\5\32\16\2\u0111\u0112\7;\2\2\u0112\u0114\3\2"+
		"\2\2\u0113\u00e5\3\2\2\2\u0113\u00ff\3\2\2\2\u0113\u010f\3\2\2\2\u0114"+
		"\u0116\3\2\2\2\u0115\u00d9\3\2\2\2\u0115\u0113\3\2\2\2\u0116\33\3\2\2"+
		"\2\u0117\u0118\t\6\2\2\u0118\35\3\2\2\2\u0119\u011a\t\7\2\2\u011a\37\3"+
		"\2\2\2\u011b\u011c\t\6\2\2\u011c!\3\2\2\2+(+\63:@CIP_ilq\177\u0086\u0089"+
		"\u0096\u0098\u009e\u00a0\u00a7\u00ae\u00b5\u00b7\u00bb\u00c4\u00d2\u00d5"+
		"\u00d9\u00dd\u00e1\u00e3\u00ea\u00f0\u00f5\u00f9\u00fd\u0105\u010a\u010c"+
		"\u0113\u0115";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}