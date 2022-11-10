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
		NOT=47, COLON=48, CURLYOPEN=49, CURLYCLOSE=50, COMMA=51, SEMI=52, TELL=53, 
		SHRIEK=54, OPEN=55, CLOSE=56, MULT=57, PLUS=58, MINUS=59, LESS=60, EQUAL=61, 
		IDPUNCT=62, RULEARROW=63, TRUE=64, PL_CONST=65, PL_VAR=66, NUMBER=67, 
		QUOTED_STRING=68;
	public static final int
		RULE_mas = 0, RULE_gwendolenagents = 1, RULE_gwendolenagent = 2, RULE_initial_goal = 3, 
		RULE_plan = 4, RULE_guard_atom = 5, RULE_event = 6, RULE_performative = 7, 
		RULE_deed = 8, RULE_goal = 9, RULE_waitfor = 10, RULE_action = 11, RULE_fof_expr = 12, 
		RULE_const_var = 13, RULE_oper = 14;
	public static final String[] ruleNames = {
		"mas", "gwendolenagents", "gwendolenagent", "initial_goal", "plan", "guard_atom", 
		"event", "performative", "deed", "goal", "waitfor", "action", "fof_expr", 
		"const_var", "oper"
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
			setState(30);
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
			setState(32);
			match(GWENDOLEN);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				((GwendolenagentsContext)_localctx).g = gwendolenagent();
				}
				}
				setState(36); 
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
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GWENDOLEN) {
				{
				setState(38);
				match(GWENDOLEN);
				}
			}

			}
			setState(41);
			_la = _input.LA(1);
			if ( !(_la==NAME || _la==NAME_PM) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(42);
			((GwendolenagentContext)_localctx).w = match(CONST);
			setState(43);
			match(BELIEFS);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BELIEF_BLOCK) {
				{
				{
				setState(44);
				((GwendolenagentContext)_localctx).bs = match(BELIEF_BLOCK);
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BELIEFRULES) {
				{
				setState(50);
				match(BELIEFRULES);
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_NEWLINE) {
					{
					{
					setState(51);
					match(RR_NEWLINE);
					}
					}
					setState(56);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				{
				setState(57);
				((GwendolenagentContext)_localctx).rr = match(RR_BLOCK);
				setState(58);
				match(RR_NEWLINE);
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_NEWLINE || _la==RR_BLOCK) {
					{
					{
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==RR_BLOCK) {
						{
						setState(60);
						((GwendolenagentContext)_localctx).rr = match(RR_BLOCK);
						}
					}

					setState(63);
					match(RR_NEWLINE);
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(71);
			_la = _input.LA(1);
			if ( !(_la==GOAL_IB || _la==GOAL_RR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GOAL_BLOCK) {
				{
				{
				setState(72);
				((GwendolenagentContext)_localctx).gs = initial_goal();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			match(PLANS);
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				((GwendolenagentContext)_localctx).p = plan();
				}
				}
				setState(82); 
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
			setState(84);
			((Initial_goalContext)_localctx).g = match(GOAL_BLOCK);
			setState(85);
			match(GL_SQOPEN);
			setState(86);
			_la = _input.LA(1);
			if ( !(_la==GL_ACHIEVEGOAL || _la==GL_PERFORMGOAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(87);
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
			setState(89);
			((PlanContext)_localctx).e = event();
			setState(90);
			match(COLON);
			setState(91);
			match(CURLYOPEN);
			setState(92);
			((PlanContext)_localctx).gb = guard_atom();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(93);
				match(COMMA);
				setState(94);
				((PlanContext)_localctx).gb = guard_atom();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(CURLYCLOSE);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULEARROW) {
				{
				setState(101);
				match(RULEARROW);
				setState(102);
				((PlanContext)_localctx).d = deed();
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(103);
					match(COMMA);
					setState(104);
					((PlanContext)_localctx).d = deed();
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(112);
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
		public Fof_exprContext s;
		public Fof_exprContext an2;
		public PerformativeContext p;
		public Fof_exprContext t;
		public TerminalNode SENT() { return getToken(GwendolenParser.SENT, 0); }
		public TerminalNode OPEN() { return getToken(GwendolenParser.OPEN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GwendolenParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GwendolenParser.COMMA, i);
		}
		public TerminalNode CLOSE() { return getToken(GwendolenParser.CLOSE, 0); }
		public TerminalNode TRUE() { return getToken(GwendolenParser.TRUE, 0); }
		public PerformativeContext performative() {
			return getRuleContext(PerformativeContext.class,0);
		}
		public List<Fof_exprContext> fof_expr() {
			return getRuleContexts(Fof_exprContext.class);
		}
		public Fof_exprContext fof_expr(int i) {
			return getRuleContext(Fof_exprContext.class,i);
		}
		public TerminalNode BELIEVE() { return getToken(GwendolenParser.BELIEVE, 0); }
		public TerminalNode GOAL() { return getToken(GwendolenParser.GOAL, 0); }
		public TerminalNode NOT() { return getToken(GwendolenParser.NOT, 0); }
		public GoalContext goal() {
			return getRuleContext(GoalContext.class,0);
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
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BELIEVE:
			case GOAL:
			case PL_SQOPEN:
			case NOT:
			case PL_CONST:
			case PL_VAR:
			case NUMBER:
				{
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(114);
					match(NOT);
					}
				}

				setState(122);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BELIEVE:
					{
					setState(117);
					match(BELIEVE);
					setState(118);
					((Guard_atomContext)_localctx).l = fof_expr();
					}
					break;
				case GOAL:
					{
					setState(119);
					match(GOAL);
					setState(120);
					((Guard_atomContext)_localctx).gl = goal();
					}
					break;
				case PL_SQOPEN:
				case PL_CONST:
				case PL_VAR:
				case NUMBER:
					{
					setState(121);
					((Guard_atomContext)_localctx).eq = fof_expr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case SENT:
				{
				setState(124);
				match(SENT);
				setState(125);
				match(OPEN);
				{
				setState(126);
				((Guard_atomContext)_localctx).s = fof_expr();
				}
				setState(127);
				match(COMMA);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (PL_SQOPEN - 45)) | (1L << (PL_CONST - 45)) | (1L << (PL_VAR - 45)) | (1L << (NUMBER - 45)))) != 0)) {
					{
					setState(128);
					((Guard_atomContext)_localctx).an2 = fof_expr();
					setState(129);
					match(COMMA);
					}
				}

				setState(133);
				((Guard_atomContext)_localctx).p = performative();
				setState(134);
				match(COMMA);
				setState(135);
				((Guard_atomContext)_localctx).t = fof_expr();
				setState(136);
				match(CLOSE);
				}
				break;
			case CURLYCLOSE:
			case COMMA:
				{
				}
				break;
			case TRUE:
				{
				setState(139);
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
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(142);
				match(PLUS);
				setState(155);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RECEIVED:
					{
					setState(143);
					match(RECEIVED);
					setState(144);
					match(OPEN);
					setState(145);
					((EventContext)_localctx).p = performative();
					setState(146);
					match(COMMA);
					setState(147);
					((EventContext)_localctx).t = fof_expr();
					setState(148);
					match(CLOSE);
					}
					break;
				case PL_SQOPEN:
				case SHRIEK:
				case PL_CONST:
				case PL_VAR:
				case NUMBER:
					{
					setState(153);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PL_SQOPEN:
					case PL_CONST:
					case PL_VAR:
					case NUMBER:
						{
						setState(150);
						((EventContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(151);
						match(SHRIEK);
						setState(152);
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
				setState(157);
				match(MINUS);
				setState(161);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PL_SQOPEN:
				case PL_CONST:
				case PL_VAR:
				case NUMBER:
					{
					setState(158);
					((EventContext)_localctx).l = fof_expr();
					}
					break;
				case SHRIEK:
					{
					setState(159);
					match(SHRIEK);
					setState(160);
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
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(165);
				match(TELL);
				}
				break;
			case 2:
				{
				setState(166);
				match(COLON);
				setState(167);
				match(PL_PERFORMGOAL);
				}
				break;
			case 3:
				{
				setState(168);
				match(COLON);
				setState(169);
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
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
				{
				setState(186);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					{
					setState(172);
					match(PLUS);
					setState(177);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PL_SQOPEN:
					case PL_CONST:
					case PL_VAR:
					case NUMBER:
						{
						setState(173);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(174);
						match(SHRIEK);
						setState(175);
						((DeedContext)_localctx).g = goal();
						}
						break;
					case LOCK:
						{
						setState(176);
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
					setState(179);
					match(MINUS);
					setState(184);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PL_SQOPEN:
					case PL_CONST:
					case PL_VAR:
					case NUMBER:
						{
						setState(180);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(181);
						match(SHRIEK);
						setState(182);
						((DeedContext)_localctx).g = goal();
						}
						break;
					case LOCK:
						{
						setState(183);
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
			case SEND:
			case PL_SQOPEN:
			case PL_CONST:
			case PL_VAR:
			case NUMBER:
				{
				setState(188);
				((DeedContext)_localctx).a = action();
				}
				break;
			case MULT:
				{
				setState(189);
				((DeedContext)_localctx).wf = waitfor();
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
			setState(192);
			((GoalContext)_localctx).g = fof_expr();
			setState(193);
			match(PL_SQOPEN);
			setState(194);
			_la = _input.LA(1);
			if ( !(_la==PL_ACHIEVEGOAL || _la==PL_PERFORMGOAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(195);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(MULT);
			setState(198);
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
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEND:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(200);
				match(SEND);
				setState(201);
				match(OPEN);
				setState(202);
				((ActionContext)_localctx).an = fof_expr();
				setState(203);
				match(COMMA);
				setState(204);
				((ActionContext)_localctx).p = performative();
				setState(205);
				match(COMMA);
				setState(206);
				((ActionContext)_localctx).t = fof_expr();
				setState(207);
				match(CLOSE);
				}
				}
				break;
			case PL_SQOPEN:
			case PL_CONST:
			case PL_VAR:
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
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
		public List<Const_varContext> const_var() {
			return getRuleContexts(Const_varContext.class);
		}
		public Const_varContext const_var(int i) {
			return getRuleContext(Const_varContext.class,i);
		}
		public TerminalNode PL_SQOPEN() { return getToken(GwendolenParser.PL_SQOPEN, 0); }
		public List<Fof_exprContext> fof_expr() {
			return getRuleContexts(Fof_exprContext.class);
		}
		public Fof_exprContext fof_expr(int i) {
			return getRuleContext(Fof_exprContext.class,i);
		}
		public TerminalNode PL_SQCLOSE() { return getToken(GwendolenParser.PL_SQCLOSE, 0); }
		public List<TerminalNode> IDPUNCT() { return getTokens(GwendolenParser.IDPUNCT); }
		public TerminalNode IDPUNCT(int i) {
			return getToken(GwendolenParser.IDPUNCT, i);
		}
		public TerminalNode OPEN() { return getToken(GwendolenParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(GwendolenParser.CLOSE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GwendolenParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GwendolenParser.COMMA, i);
		}
		public List<TerminalNode> QUOTED_STRING() { return getTokens(GwendolenParser.QUOTED_STRING); }
		public TerminalNode QUOTED_STRING(int i) {
			return getToken(GwendolenParser.QUOTED_STRING, i);
		}
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
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				_la = _input.LA(1);
				if ( !(_la==PL_VAR || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LESS || _la==EQUAL) {
					{
					setState(213);
					oper();
					setState(214);
					_la = _input.LA(1);
					if ( !(_la==PL_VAR || _la==NUMBER) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PL_CONST:
				case PL_VAR:
					{
					setState(218);
					const_var();
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==IDPUNCT) {
						{
						{
						setState(219);
						match(IDPUNCT);
						setState(220);
						const_var();
						}
						}
						setState(225);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(242);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==OPEN) {
						{
						setState(226);
						match(OPEN);
						setState(229);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case PL_SQOPEN:
						case PL_CONST:
						case PL_VAR:
						case NUMBER:
							{
							setState(227);
							fof_expr();
							}
							break;
						case QUOTED_STRING:
							{
							setState(228);
							match(QUOTED_STRING);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(238);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(231);
							match(COMMA);
							setState(234);
							_errHandler.sync(this);
							switch (_input.LA(1)) {
							case PL_SQOPEN:
							case PL_CONST:
							case PL_VAR:
							case NUMBER:
								{
								setState(232);
								fof_expr();
								}
								break;
							case QUOTED_STRING:
								{
								setState(233);
								match(QUOTED_STRING);
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							}
							}
							setState(240);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(241);
						match(CLOSE);
						}
					}

					}
					break;
				case PL_SQOPEN:
					{
					setState(244);
					match(PL_SQOPEN);
					setState(245);
					fof_expr();
					setState(250);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(246);
						match(COMMA);
						setState(247);
						fof_expr();
						}
						}
						setState(252);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(253);
					match(PL_SQCLOSE);
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
			setState(259);
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
			setState(261);
			_la = _input.LA(1);
			if ( !(_la==LESS || _la==EQUAL) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3F\u010a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\6\3"+
		"%\n\3\r\3\16\3&\3\4\5\4*\n\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13"+
		"\4\3\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\4\3\4\3\4\3\4\5\4@\n\4\3\4\7\4"+
		"C\n\4\f\4\16\4F\13\4\5\4H\n\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\4\3\4"+
		"\6\4S\n\4\r\4\16\4T\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6b\n"+
		"\6\f\6\16\6e\13\6\3\6\3\6\3\6\3\6\3\6\7\6l\n\6\f\6\16\6o\13\6\5\6q\n\6"+
		"\3\6\3\6\3\7\5\7v\n\7\3\7\3\7\3\7\3\7\3\7\5\7}\n\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\5\7\u0086\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u008f\n\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u009c\n\b\5\b\u009e\n\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00a4\n\b\5\b\u00a6\n\b\3\t\3\t\3\t\3\t\3\t\5\t\u00ad"+
		"\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u00b4\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u00bb\n"+
		"\n\5\n\u00bd\n\n\3\n\3\n\5\n\u00c1\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d5\n\r\3\16\3\16"+
		"\3\16\3\16\5\16\u00db\n\16\3\16\3\16\3\16\7\16\u00e0\n\16\f\16\16\16\u00e3"+
		"\13\16\3\16\3\16\3\16\5\16\u00e8\n\16\3\16\3\16\3\16\5\16\u00ed\n\16\7"+
		"\16\u00ef\n\16\f\16\16\16\u00f2\13\16\3\16\5\16\u00f5\n\16\3\16\3\16\3"+
		"\16\3\16\7\16\u00fb\n\16\f\16\16\16\u00fe\13\16\3\16\3\16\5\16\u0102\n"+
		"\16\5\16\u0104\n\16\3\17\3\17\3\20\3\20\3\20\2\2\21\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36\2\t\4\2\4\4\"\"\4\2\f\f\22\22\3\2\35\36\3\2-.\3"+
		"\2DE\3\2CD\3\2>?\2\u0124\2 \3\2\2\2\4\"\3\2\2\2\6)\3\2\2\2\bV\3\2\2\2"+
		"\n[\3\2\2\2\f\u008e\3\2\2\2\16\u00a5\3\2\2\2\20\u00ac\3\2\2\2\22\u00c0"+
		"\3\2\2\2\24\u00c2\3\2\2\2\26\u00c7\3\2\2\2\30\u00d4\3\2\2\2\32\u0103\3"+
		"\2\2\2\34\u0105\3\2\2\2\36\u0107\3\2\2\2 !\5\4\3\2!\3\3\2\2\2\"$\7\3\2"+
		"\2#%\5\6\4\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\5\3\2\2\2(*\7"+
		"\3\2\2)(\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\t\2\2\2,-\7\5\2\2-\61\7\n\2\2."+
		"\60\7\21\2\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62G\3\2"+
		"\2\2\63\61\3\2\2\2\648\7\13\2\2\65\67\7\25\2\2\66\65\3\2\2\2\67:\3\2\2"+
		"\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\27\2\2<=\7\25\2\2=D\3"+
		"\2\2\2>@\7\27\2\2?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2AC\7\25\2\2B?\3\2\2\2C"+
		"F\3\2\2\2DB\3\2\2\2DE\3\2\2\2EH\3\2\2\2FD\3\2\2\2G\64\3\2\2\2GH\3\2\2"+
		"\2HI\3\2\2\2IM\t\3\2\2JL\5\b\5\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2"+
		"\2NP\3\2\2\2OM\3\2\2\2PR\7\30\2\2QS\5\n\6\2RQ\3\2\2\2ST\3\2\2\2TR\3\2"+
		"\2\2TU\3\2\2\2U\7\3\2\2\2VW\7!\2\2WX\7\37\2\2XY\t\4\2\2YZ\7 \2\2Z\t\3"+
		"\2\2\2[\\\5\16\b\2\\]\7\62\2\2]^\7\63\2\2^c\5\f\7\2_`\7\65\2\2`b\5\f\7"+
		"\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fp\7\64"+
		"\2\2gh\7A\2\2hm\5\22\n\2ij\7\65\2\2jl\5\22\n\2ki\3\2\2\2lo\3\2\2\2mk\3"+
		"\2\2\2mn\3\2\2\2nq\3\2\2\2om\3\2\2\2pg\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\7"+
		"\66\2\2s\13\3\2\2\2tv\7\61\2\2ut\3\2\2\2uv\3\2\2\2v|\3\2\2\2wx\7)\2\2"+
		"x}\5\32\16\2yz\7*\2\2z}\5\24\13\2{}\5\32\16\2|w\3\2\2\2|y\3\2\2\2|{\3"+
		"\2\2\2}\u008f\3\2\2\2~\177\7+\2\2\177\u0080\79\2\2\u0080\u0081\5\32\16"+
		"\2\u0081\u0085\7\65\2\2\u0082\u0083\5\32\16\2\u0083\u0084\7\65\2\2\u0084"+
		"\u0086\3\2\2\2\u0085\u0082\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u0088\5\20\t\2\u0088\u0089\7\65\2\2\u0089\u008a\5\32\16\2\u008a"+
		"\u008b\7:\2\2\u008b\u008f\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008f\7B\2"+
		"\2\u008eu\3\2\2\2\u008e~\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008d\3\2\2"+
		"\2\u008f\r\3\2\2\2\u0090\u009d\7<\2\2\u0091\u0092\7(\2\2\u0092\u0093\7"+
		"9\2\2\u0093\u0094\5\20\t\2\u0094\u0095\7\65\2\2\u0095\u0096\5\32\16\2"+
		"\u0096\u0097\7:\2\2\u0097\u009e\3\2\2\2\u0098\u009c\5\32\16\2\u0099\u009a"+
		"\78\2\2\u009a\u009c\5\24\13\2\u009b\u0098\3\2\2\2\u009b\u0099\3\2\2\2"+
		"\u009c\u009e\3\2\2\2\u009d\u0091\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a6"+
		"\3\2\2\2\u009f\u00a3\7=\2\2\u00a0\u00a4\5\32\16\2\u00a1\u00a2\78\2\2\u00a2"+
		"\u00a4\5\24\13\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a6\3"+
		"\2\2\2\u00a5\u0090\3\2\2\2\u00a5\u009f\3\2\2\2\u00a6\17\3\2\2\2\u00a7"+
		"\u00ad\7\67\2\2\u00a8\u00a9\7\62\2\2\u00a9\u00ad\7.\2\2\u00aa\u00ab\7"+
		"\62\2\2\u00ab\u00ad\7-\2\2\u00ac\u00a7\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ad\21\3\2\2\2\u00ae\u00b3\7<\2\2\u00af\u00b4\5\32\16"+
		"\2\u00b0\u00b1\78\2\2\u00b1\u00b4\5\24\13\2\u00b2\u00b4\7,\2\2\u00b3\u00af"+
		"\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00bd\3\2\2\2\u00b5"+
		"\u00ba\7=\2\2\u00b6\u00bb\5\32\16\2\u00b7\u00b8\78\2\2\u00b8\u00bb\5\24"+
		"\13\2\u00b9\u00bb\7,\2\2\u00ba\u00b6\3\2\2\2\u00ba\u00b7\3\2\2\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ae\3\2\2\2\u00bc\u00b5\3\2"+
		"\2\2\u00bd\u00c1\3\2\2\2\u00be\u00c1\5\30\r\2\u00bf\u00c1\5\26\f\2\u00c0"+
		"\u00bc\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\23\3\2\2"+
		"\2\u00c2\u00c3\5\32\16\2\u00c3\u00c4\7/\2\2\u00c4\u00c5\t\5\2\2\u00c5"+
		"\u00c6\7\60\2\2\u00c6\25\3\2\2\2\u00c7\u00c8\7;\2\2\u00c8\u00c9\5\32\16"+
		"\2\u00c9\27\3\2\2\2\u00ca\u00cb\7\'\2\2\u00cb\u00cc\79\2\2\u00cc\u00cd"+
		"\5\32\16\2\u00cd\u00ce\7\65\2\2\u00ce\u00cf\5\20\t\2\u00cf\u00d0\7\65"+
		"\2\2\u00d0\u00d1\5\32\16\2\u00d1\u00d2\7:\2\2\u00d2\u00d5\3\2\2\2\u00d3"+
		"\u00d5\5\32\16\2\u00d4\u00ca\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\31\3\2"+
		"\2\2\u00d6\u00da\t\6\2\2\u00d7\u00d8\5\36\20\2\u00d8\u00d9\t\6\2\2\u00d9"+
		"\u00db\3\2\2\2\u00da\u00d7\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u0104\3\2"+
		"\2\2\u00dc\u00e1\5\34\17\2\u00dd\u00de\7@\2\2\u00de\u00e0\5\34\17\2\u00df"+
		"\u00dd\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2"+
		"\2\2\u00e2\u00f4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e7\79\2\2\u00e5"+
		"\u00e8\5\32\16\2\u00e6\u00e8\7F\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3"+
		"\2\2\2\u00e8\u00f0\3\2\2\2\u00e9\u00ec\7\65\2\2\u00ea\u00ed\5\32\16\2"+
		"\u00eb\u00ed\7F\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00ef"+
		"\3\2\2\2\u00ee\u00e9\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f5\7:"+
		"\2\2\u00f4\u00e4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u0102\3\2\2\2\u00f6"+
		"\u00f7\7/\2\2\u00f7\u00fc\5\32\16\2\u00f8\u00f9\7\65\2\2\u00f9\u00fb\5"+
		"\32\16\2\u00fa\u00f8\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0100\7\60"+
		"\2\2\u0100\u0102\3\2\2\2\u0101\u00dc\3\2\2\2\u0101\u00f6\3\2\2\2\u0102"+
		"\u0104\3\2\2\2\u0103\u00d6\3\2\2\2\u0103\u0101\3\2\2\2\u0104\33\3\2\2"+
		"\2\u0105\u0106\t\7\2\2\u0106\35\3\2\2\2\u0107\u0108\t\b\2\2\u0108\37\3"+
		"\2\2\2%&)\618?DGMTcmpu|\u0085\u008e\u009b\u009d\u00a3\u00a5\u00ac\u00b3"+
		"\u00ba\u00bc\u00c0\u00d4\u00da\u00e1\u00e7\u00ec\u00f0\u00f4\u00fc\u0101"+
		"\u0103";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}