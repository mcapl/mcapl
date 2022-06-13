// Generated from Gwendolen.g4 by ANTLR 4.7
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
		GWENDOLEN=1, NAME=2, BELIEFS=3, BELIEF_BLOCK=4, IB_NEWLINE=5, BELIEFRULES=6, 
		RR_NEWLINE=7, RR_BLOCK=8, GOAL_RR=9, GOAL_IB=10, GL_NEWLINE=11, GOAL_BLOCK=12, 
		SQOPEN=13, ACHIVEGOAL=14, PERFORMGOAL=15, SQCLOSE=16, PLANS=17, COLON=18, 
		CURLYOPEN=19, NOT=20, COMMA=21, CURLYCLOSE=22, RULEARROW=23, SEMI=24, 
		BELIEVE=25, GOAL=26, SENT=27, OPEN=28, CLOSE=29, TRUE=30, SQOPEN_PL=31, 
		ACHIEVEGOAL_PL=32, PERFORMGOAL_PL=33, SQCLOSE_PL=34, PLUS=35, RECEIVED=36, 
		SHRIEK=37, ADD_CONTENT=38, ADD_CONTEXT=39, MINUS=40, TELL=41, PERFORM=42, 
		ACHIEVE=43, TELLHOW=44, CONSTRAINT=45, ADD_PLAN=46, ADD_CONSTRAINT=47, 
		LOCK=48, MULT=49, SEND=50, POINT=51, CONST=52, VAR=53, IDPUNCT=54, QUOTED_STRING=55, 
		COMMASEP=56;
	public static final int
		RULE_mas = 0, RULE_gwendolenagents = 1, RULE_gwendolenagent = 2, RULE_plan = 3, 
		RULE_guard_atom = 4, RULE_goal = 5, RULE_event = 6, RULE_performative = 7, 
		RULE_deed = 8, RULE_waitfor = 9, RULE_action = 10, RULE_environment = 11, 
		RULE_classpath = 12, RULE_word = 13, RULE_agentnameterm = 14, RULE_fof_expr = 15;
	public static final String[] ruleNames = {
		"mas", "gwendolenagents", "gwendolenagent", "plan", "guard_atom", "goal", 
		"event", "performative", "deed", "waitfor", "action", "environment", "classpath", 
		"word", "agentnameterm", "fof_expr"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "GWENDOLEN", "NAME", "BELIEFS", "BELIEF_BLOCK", "IB_NEWLINE", "BELIEFRULES", 
		"RR_NEWLINE", "RR_BLOCK", "GOAL_RR", "GOAL_IB", "GL_NEWLINE", "GOAL_BLOCK", 
		"SQOPEN", "ACHIVEGOAL", "PERFORMGOAL", "SQCLOSE", "PLANS", "COLON", "CURLYOPEN", 
		"NOT", "COMMA", "CURLYCLOSE", "RULEARROW", "SEMI", "BELIEVE", "GOAL", 
		"SENT", "OPEN", "CLOSE", "TRUE", "SQOPEN_PL", "ACHIEVEGOAL_PL", "PERFORMGOAL_PL", 
		"SQCLOSE_PL", "PLUS", "RECEIVED", "SHRIEK", "ADD_CONTENT", "ADD_CONTEXT", 
		"MINUS", "TELL", "PERFORM", "ACHIEVE", "TELLHOW", "CONSTRAINT", "ADD_PLAN", 
		"ADD_CONSTRAINT", "LOCK", "MULT", "SEND", "POINT", "CONST", "VAR", "IDPUNCT", 
		"QUOTED_STRING", "COMMASEP"
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
			} while ( _la==GWENDOLEN || _la==NAME );
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
		public WordContext w;
		public Token bs;
		public Token gs;
		public PlanContext p;
		public TerminalNode NAME() { return getToken(GwendolenParser.NAME, 0); }
		public TerminalNode BELIEFS() { return getToken(GwendolenParser.BELIEFS, 0); }
		public TerminalNode PLANS() { return getToken(GwendolenParser.PLANS, 0); }
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public TerminalNode GOAL_RR() { return getToken(GwendolenParser.GOAL_RR, 0); }
		public TerminalNode GOAL_IB() { return getToken(GwendolenParser.GOAL_IB, 0); }
		public TerminalNode SQOPEN() { return getToken(GwendolenParser.SQOPEN, 0); }
		public TerminalNode SQCLOSE() { return getToken(GwendolenParser.SQCLOSE, 0); }
		public List<TerminalNode> GL_NEWLINE() { return getTokens(GwendolenParser.GL_NEWLINE); }
		public TerminalNode GL_NEWLINE(int i) {
			return getToken(GwendolenParser.GL_NEWLINE, i);
		}
		public List<TerminalNode> IB_NEWLINE() { return getTokens(GwendolenParser.IB_NEWLINE); }
		public TerminalNode IB_NEWLINE(int i) {
			return getToken(GwendolenParser.IB_NEWLINE, i);
		}
		public TerminalNode BELIEFRULES() { return getToken(GwendolenParser.BELIEFRULES, 0); }
		public List<TerminalNode> GOAL_BLOCK() { return getTokens(GwendolenParser.GOAL_BLOCK); }
		public TerminalNode GOAL_BLOCK(int i) {
			return getToken(GwendolenParser.GOAL_BLOCK, i);
		}
		public TerminalNode ACHIVEGOAL() { return getToken(GwendolenParser.ACHIVEGOAL, 0); }
		public TerminalNode PERFORMGOAL() { return getToken(GwendolenParser.PERFORMGOAL, 0); }
		public List<PlanContext> plan() {
			return getRuleContexts(PlanContext.class);
		}
		public PlanContext plan(int i) {
			return getRuleContext(PlanContext.class,i);
		}
		public TerminalNode GWENDOLEN() { return getToken(GwendolenParser.GWENDOLEN, 0); }
		public List<TerminalNode> RR_BLOCK() { return getTokens(GwendolenParser.RR_BLOCK); }
		public TerminalNode RR_BLOCK(int i) {
			return getToken(GwendolenParser.RR_BLOCK, i);
		}
		public List<TerminalNode> RR_NEWLINE() { return getTokens(GwendolenParser.RR_NEWLINE); }
		public TerminalNode RR_NEWLINE(int i) {
			return getToken(GwendolenParser.RR_NEWLINE, i);
		}
		public List<TerminalNode> BELIEF_BLOCK() { return getTokens(GwendolenParser.BELIEF_BLOCK); }
		public TerminalNode BELIEF_BLOCK(int i) {
			return getToken(GwendolenParser.BELIEF_BLOCK, i);
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
			match(NAME);
			setState(44);
			((GwendolenagentContext)_localctx).w = word();
			setState(45);
			match(BELIEFS);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BELIEF_BLOCK || _la==IB_NEWLINE) {
				{
				{
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BELIEF_BLOCK) {
					{
					setState(46);
					((GwendolenagentContext)_localctx).bs = match(BELIEF_BLOCK);
					}
				}

				setState(49);
				match(IB_NEWLINE);
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BELIEFRULES) {
				{
				setState(55);
				match(BELIEFRULES);
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_NEWLINE) {
					{
					{
					setState(56);
					match(RR_NEWLINE);
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				{
				setState(62);
				match(RR_BLOCK);
				setState(63);
				match(RR_NEWLINE);
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_NEWLINE || _la==RR_BLOCK) {
					{
					{
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==RR_BLOCK) {
						{
						setState(65);
						match(RR_BLOCK);
						}
					}

					setState(68);
					match(RR_NEWLINE);
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(76);
			_la = _input.LA(1);
			if ( !(_la==GOAL_RR || _la==GOAL_IB) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GL_NEWLINE) {
				{
				{
				setState(77);
				match(GL_NEWLINE);
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(83);
			((GwendolenagentContext)_localctx).gs = match(GOAL_BLOCK);
			setState(84);
			match(SQOPEN);
			setState(85);
			_la = _input.LA(1);
			if ( !(_la==ACHIVEGOAL || _la==PERFORMGOAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(86);
			match(SQCLOSE);
			setState(87);
			match(GL_NEWLINE);
			}
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GL_NEWLINE || _la==GOAL_BLOCK) {
				{
				{
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GOAL_BLOCK) {
					{
					setState(89);
					match(GOAL_BLOCK);
					}
				}

				setState(92);
				match(GL_NEWLINE);
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			match(PLANS);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(99);
				((GwendolenagentContext)_localctx).p = plan();
				}
				}
				setState(104);
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
		public List<TerminalNode> NOT() { return getTokens(GwendolenParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(GwendolenParser.NOT, i);
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
		enterRule(_localctx, 6, RULE_plan);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			((PlanContext)_localctx).e = event();
			setState(106);
			match(COLON);
			setState(107);
			match(CURLYOPEN);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(108);
				match(NOT);
				}
			}

			setState(111);
			((PlanContext)_localctx).gb = guard_atom();
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(112);
				match(COMMA);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(113);
					match(NOT);
					}
				}

				setState(116);
				((PlanContext)_localctx).gb = guard_atom();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			match(CURLYCLOSE);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULEARROW) {
				{
				setState(123);
				match(RULEARROW);
				setState(124);
				((PlanContext)_localctx).d = deed();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(125);
					match(COMMA);
					setState(126);
					((PlanContext)_localctx).d = deed();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(134);
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
		public AgentnametermContext s;
		public AgentnametermContext an2;
		public PerformativeContext p;
		public Fof_exprContext t;
		public Fof_exprContext eq;
		public TerminalNode BELIEVE() { return getToken(GwendolenParser.BELIEVE, 0); }
		public TerminalNode GOAL() { return getToken(GwendolenParser.GOAL, 0); }
		public TerminalNode SENT() { return getToken(GwendolenParser.SENT, 0); }
		public TerminalNode OPEN() { return getToken(GwendolenParser.OPEN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GwendolenParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GwendolenParser.COMMA, i);
		}
		public TerminalNode CLOSE() { return getToken(GwendolenParser.CLOSE, 0); }
		public TerminalNode TRUE() { return getToken(GwendolenParser.TRUE, 0); }
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
		enterRule(_localctx, 8, RULE_guard_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BELIEVE:
				{
				setState(136);
				match(BELIEVE);
				setState(137);
				((Guard_atomContext)_localctx).l = fof_expr();
				}
				break;
			case GOAL:
				{
				setState(138);
				match(GOAL);
				setState(139);
				((Guard_atomContext)_localctx).gl = goal();
				}
				break;
			case SENT:
				{
				setState(140);
				match(SENT);
				setState(141);
				match(OPEN);
				{
				setState(142);
				((Guard_atomContext)_localctx).s = agentnameterm();
				}
				setState(143);
				match(COMMA);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONST || _la==VAR) {
					{
					setState(144);
					((Guard_atomContext)_localctx).an2 = agentnameterm();
					setState(145);
					match(COMMA);
					}
				}

				setState(149);
				((Guard_atomContext)_localctx).p = performative();
				setState(150);
				match(COMMA);
				setState(151);
				((Guard_atomContext)_localctx).t = fof_expr();
				setState(152);
				match(CLOSE);
				}
				break;
			case SQOPEN:
			case CONST:
				{
				setState(154);
				((Guard_atomContext)_localctx).eq = fof_expr();
				}
				break;
			case TRUE:
				{
				setState(155);
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

	public static class GoalContext extends ParserRuleContext {
		public Fof_exprContext gl;
		public TerminalNode SQOPEN_PL() { return getToken(GwendolenParser.SQOPEN_PL, 0); }
		public TerminalNode SQCLOSE_PL() { return getToken(GwendolenParser.SQCLOSE_PL, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode ACHIEVEGOAL_PL() { return getToken(GwendolenParser.ACHIEVEGOAL_PL, 0); }
		public TerminalNode PERFORMGOAL_PL() { return getToken(GwendolenParser.PERFORMGOAL_PL, 0); }
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
		enterRule(_localctx, 10, RULE_goal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			((GoalContext)_localctx).gl = fof_expr();
			setState(159);
			match(SQOPEN_PL);
			setState(160);
			_la = _input.LA(1);
			if ( !(_la==ACHIEVEGOAL_PL || _la==PERFORMGOAL_PL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(161);
			match(SQCLOSE_PL);
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
		public TerminalNode MINUS() { return getToken(GwendolenParser.MINUS, 0); }
		public TerminalNode RECEIVED() { return getToken(GwendolenParser.RECEIVED, 0); }
		public TerminalNode OPEN() { return getToken(GwendolenParser.OPEN, 0); }
		public TerminalNode COMMA() { return getToken(GwendolenParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(GwendolenParser.CLOSE, 0); }
		public TerminalNode ADD_CONTENT() { return getToken(GwendolenParser.ADD_CONTENT, 0); }
		public TerminalNode ADD_CONTEXT() { return getToken(GwendolenParser.ADD_CONTEXT, 0); }
		public TerminalNode SHRIEK() { return getToken(GwendolenParser.SHRIEK, 0); }
		public PerformativeContext performative() {
			return getRuleContext(PerformativeContext.class,0);
		}
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public GoalContext goal() {
			return getRuleContext(GoalContext.class,0);
		}
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
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				{
				setState(163);
				match(PLUS);
				setState(180);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RECEIVED:
					{
					setState(164);
					match(RECEIVED);
					setState(165);
					match(OPEN);
					setState(166);
					((EventContext)_localctx).p = performative();
					setState(167);
					match(COMMA);
					setState(168);
					((EventContext)_localctx).t = fof_expr();
					setState(169);
					match(CLOSE);
					}
					break;
				case SQOPEN:
				case SHRIEK:
				case CONST:
					{
					setState(174);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SQOPEN:
					case CONST:
						{
						setState(171);
						((EventContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(172);
						match(SHRIEK);
						setState(173);
						((EventContext)_localctx).g = goal();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case ADD_CONTENT:
					{
					setState(176);
					match(ADD_CONTENT);
					setState(177);
					((EventContext)_localctx).l = fof_expr();
					}
					break;
				case ADD_CONTEXT:
					{
					setState(178);
					match(ADD_CONTEXT);
					setState(179);
					((EventContext)_localctx).l = fof_expr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case MINUS:
				{
				setState(182);
				match(MINUS);
				setState(190);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SQOPEN:
				case CONST:
					{
					setState(183);
					((EventContext)_localctx).l = fof_expr();
					}
					break;
				case SHRIEK:
					{
					setState(184);
					match(SHRIEK);
					setState(185);
					((EventContext)_localctx).g = goal();
					}
					break;
				case ADD_CONTENT:
					{
					setState(186);
					match(ADD_CONTENT);
					setState(187);
					((EventContext)_localctx).l = fof_expr();
					}
					break;
				case ADD_CONTEXT:
					{
					setState(188);
					match(ADD_CONTEXT);
					setState(189);
					((EventContext)_localctx).l = fof_expr();
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
		public TerminalNode PERFORM() { return getToken(GwendolenParser.PERFORM, 0); }
		public TerminalNode ACHIEVE() { return getToken(GwendolenParser.ACHIEVE, 0); }
		public TerminalNode TELLHOW() { return getToken(GwendolenParser.TELLHOW, 0); }
		public TerminalNode CONSTRAINT() { return getToken(GwendolenParser.CONSTRAINT, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TELL) | (1L << PERFORM) | (1L << ACHIEVE) | (1L << TELLHOW) | (1L << CONSTRAINT))) != 0)) ) {
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

	public static class DeedContext extends ParserRuleContext {
		public Fof_exprContext l;
		public GoalContext g;
		public Fof_exprContext p;
		public Fof_exprContext c;
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
		public TerminalNode ADD_CONTENT() { return getToken(GwendolenParser.ADD_CONTENT, 0); }
		public TerminalNode ADD_CONTEXT() { return getToken(GwendolenParser.ADD_CONTEXT, 0); }
		public TerminalNode ADD_PLAN() { return getToken(GwendolenParser.ADD_PLAN, 0); }
		public TerminalNode ADD_CONSTRAINT() { return getToken(GwendolenParser.ADD_CONSTRAINT, 0); }
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
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
				{
				setState(222);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(196);
					match(PLUS);
					setState(209);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SQOPEN:
					case CONST:
						{
						setState(197);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(198);
						match(SHRIEK);
						setState(199);
						((DeedContext)_localctx).g = goal();
						}
						break;
					case ADD_CONTENT:
						{
						setState(200);
						match(ADD_CONTENT);
						setState(201);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case ADD_CONTEXT:
						{
						setState(202);
						match(ADD_CONTEXT);
						setState(203);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case ADD_PLAN:
						{
						setState(204);
						match(ADD_PLAN);
						setState(205);
						((DeedContext)_localctx).p = fof_expr();
						}
						break;
					case ADD_CONSTRAINT:
						{
						setState(206);
						match(ADD_CONSTRAINT);
						setState(207);
						((DeedContext)_localctx).c = fof_expr();
						}
						break;
					case LOCK:
						{
						setState(208);
						match(LOCK);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case MINUS:
					{
					setState(211);
					match(MINUS);
					setState(220);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SQOPEN:
					case CONST:
						{
						setState(212);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(213);
						match(SHRIEK);
						setState(214);
						((DeedContext)_localctx).g = goal();
						}
						break;
					case ADD_CONTENT:
						{
						setState(215);
						match(ADD_CONTENT);
						setState(216);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case ADD_CONTEXT:
						{
						setState(217);
						match(ADD_CONTEXT);
						setState(218);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case LOCK:
						{
						setState(219);
						match(LOCK);
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
				break;
			case SQOPEN:
			case SEND:
			case CONST:
				{
				setState(224);
				((DeedContext)_localctx).a = action();
				}
				break;
			case MULT:
				{
				setState(225);
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
		enterRule(_localctx, 18, RULE_waitfor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(MULT);
			setState(229);
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
		enterRule(_localctx, 20, RULE_action);
		try {
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEND:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(231);
				match(SEND);
				setState(232);
				match(OPEN);
				setState(233);
				((ActionContext)_localctx).an = fof_expr();
				setState(234);
				match(COMMA);
				setState(235);
				((ActionContext)_localctx).p = performative();
				setState(236);
				match(COMMA);
				setState(237);
				((ActionContext)_localctx).t = fof_expr();
				setState(238);
				match(CLOSE);
				}
				}
				break;
			case SQOPEN:
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
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

	public static class EnvironmentContext extends ParserRuleContext {
		public ClasspathContext w;
		public ClasspathContext classpath() {
			return getRuleContext(ClasspathContext.class,0);
		}
		public EnvironmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_environment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitEnvironment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvironmentContext environment() throws RecognitionException {
		EnvironmentContext _localctx = new EnvironmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_environment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			((EnvironmentContext)_localctx).w = classpath();
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

	public static class ClasspathContext extends ParserRuleContext {
		public WordContext w;
		public WordContext w1;
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public List<TerminalNode> POINT() { return getTokens(GwendolenParser.POINT); }
		public TerminalNode POINT(int i) {
			return getToken(GwendolenParser.POINT, i);
		}
		public ClasspathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classpath; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitClasspath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClasspathContext classpath() throws RecognitionException {
		ClasspathContext _localctx = new ClasspathContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_classpath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			((ClasspathContext)_localctx).w = word();
			setState(248); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(246);
				match(POINT);
				setState(247);
				((ClasspathContext)_localctx).w1 = word();
				}
				}
				setState(250); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==POINT );
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

	public static class WordContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(GwendolenParser.CONST, 0); }
		public TerminalNode VAR() { return getToken(GwendolenParser.VAR, 0); }
		public WordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_word; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordContext word() throws RecognitionException {
		WordContext _localctx = new WordContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_word);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ( !(_la==CONST || _la==VAR) ) {
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
		public Token v;
		public TerminalNode CONST() { return getToken(GwendolenParser.CONST, 0); }
		public TerminalNode VAR() { return getToken(GwendolenParser.VAR, 0); }
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
		enterRule(_localctx, 28, RULE_agentnameterm);
		try {
			setState(256);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(CONST);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				((AgentnametermContext)_localctx).v = match(VAR);
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
		public List<TerminalNode> CONST() { return getTokens(GwendolenParser.CONST); }
		public TerminalNode CONST(int i) {
			return getToken(GwendolenParser.CONST, i);
		}
		public TerminalNode SQOPEN() { return getToken(GwendolenParser.SQOPEN, 0); }
		public List<Fof_exprContext> fof_expr() {
			return getRuleContexts(Fof_exprContext.class);
		}
		public Fof_exprContext fof_expr(int i) {
			return getRuleContext(Fof_exprContext.class,i);
		}
		public TerminalNode SQCLOSE() { return getToken(GwendolenParser.SQCLOSE, 0); }
		public List<TerminalNode> IDPUNCT() { return getTokens(GwendolenParser.IDPUNCT); }
		public TerminalNode IDPUNCT(int i) {
			return getToken(GwendolenParser.IDPUNCT, i);
		}
		public TerminalNode OPEN() { return getToken(GwendolenParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(GwendolenParser.CLOSE, 0); }
		public List<TerminalNode> COMMASEP() { return getTokens(GwendolenParser.COMMASEP); }
		public TerminalNode COMMASEP(int i) {
			return getToken(GwendolenParser.COMMASEP, i);
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
		enterRule(_localctx, 30, RULE_fof_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				{
				setState(258);
				match(CONST);
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDPUNCT) {
					{
					{
					setState(259);
					match(IDPUNCT);
					setState(260);
					match(CONST);
					}
					}
					setState(265);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN) {
					{
					setState(266);
					match(OPEN);
					setState(269);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SQOPEN:
					case CONST:
						{
						setState(267);
						fof_expr();
						}
						break;
					case QUOTED_STRING:
						{
						setState(268);
						match(QUOTED_STRING);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(278);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMASEP) {
						{
						{
						setState(271);
						match(COMMASEP);
						setState(274);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case SQOPEN:
						case CONST:
							{
							setState(272);
							fof_expr();
							}
							break;
						case QUOTED_STRING:
							{
							setState(273);
							match(QUOTED_STRING);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						}
						setState(280);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(281);
					match(CLOSE);
					}
				}

				}
				break;
			case SQOPEN:
				{
				setState(284);
				match(SQOPEN);
				setState(285);
				fof_expr();
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMASEP) {
					{
					{
					setState(286);
					match(COMMASEP);
					setState(287);
					fof_expr();
					}
					}
					setState(292);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(293);
				match(SQCLOSE);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u012c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\6\3\'\n\3\r\3\16\3(\3\4\5\4,\n\4\3\4\3\4\3\4\3\4\5\4\62\n\4\3\4"+
		"\7\4\65\n\4\f\4\16\48\13\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4\3\4\3\4"+
		"\3\4\5\4E\n\4\3\4\7\4H\n\4\f\4\16\4K\13\4\5\4M\n\4\3\4\3\4\7\4Q\n\4\f"+
		"\4\16\4T\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4]\n\4\3\4\7\4`\n\4\f\4\16"+
		"\4c\13\4\3\4\3\4\7\4g\n\4\f\4\16\4j\13\4\3\5\3\5\3\5\3\5\5\5p\n\5\3\5"+
		"\3\5\3\5\5\5u\n\5\3\5\7\5x\n\5\f\5\16\5{\13\5\3\5\3\5\3\5\3\5\3\5\7\5"+
		"\u0082\n\5\f\5\16\5\u0085\13\5\5\5\u0087\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0096\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5"+
		"\6\u009f\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\b\u00b1\n\b\3\b\3\b\3\b\3\b\5\b\u00b7\n\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00c1\n\b\5\b\u00c3\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00d4\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\5\n\u00df\n\n\5\n\u00e1\n\n\3\n\3\n\5\n\u00e5\n\n\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f4\n\f\3\r\3\r\3"+
		"\16\3\16\3\16\6\16\u00fb\n\16\r\16\16\16\u00fc\3\17\3\17\3\20\3\20\5\20"+
		"\u0103\n\20\3\21\3\21\3\21\7\21\u0108\n\21\f\21\16\21\u010b\13\21\3\21"+
		"\3\21\3\21\5\21\u0110\n\21\3\21\3\21\3\21\5\21\u0115\n\21\7\21\u0117\n"+
		"\21\f\21\16\21\u011a\13\21\3\21\5\21\u011d\n\21\3\21\3\21\3\21\3\21\7"+
		"\21\u0123\n\21\f\21\16\21\u0126\13\21\3\21\3\21\5\21\u012a\n\21\3\21\2"+
		"\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\7\3\2\13\f\3\2\20\21\3"+
		"\2\"#\3\2+/\3\2\66\67\2\u0150\2\"\3\2\2\2\4$\3\2\2\2\6+\3\2\2\2\bk\3\2"+
		"\2\2\n\u009e\3\2\2\2\f\u00a0\3\2\2\2\16\u00c2\3\2\2\2\20\u00c4\3\2\2\2"+
		"\22\u00e4\3\2\2\2\24\u00e6\3\2\2\2\26\u00f3\3\2\2\2\30\u00f5\3\2\2\2\32"+
		"\u00f7\3\2\2\2\34\u00fe\3\2\2\2\36\u0102\3\2\2\2 \u0129\3\2\2\2\"#\5\4"+
		"\3\2#\3\3\2\2\2$&\7\3\2\2%\'\5\6\4\2&%\3\2\2\2\'(\3\2\2\2(&\3\2\2\2()"+
		"\3\2\2\2)\5\3\2\2\2*,\7\3\2\2+*\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\4\2\2"+
		"./\5\34\17\2/\66\7\5\2\2\60\62\7\6\2\2\61\60\3\2\2\2\61\62\3\2\2\2\62"+
		"\63\3\2\2\2\63\65\7\7\2\2\64\61\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67"+
		"\3\2\2\2\67L\3\2\2\28\66\3\2\2\29=\7\b\2\2:<\7\t\2\2;:\3\2\2\2<?\3\2\2"+
		"\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\n\2\2AB\7\t\2\2BI\3\2\2"+
		"\2CE\7\n\2\2DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2FH\7\t\2\2GD\3\2\2\2HK\3\2\2"+
		"\2IG\3\2\2\2IJ\3\2\2\2JM\3\2\2\2KI\3\2\2\2L9\3\2\2\2LM\3\2\2\2MN\3\2\2"+
		"\2NR\t\2\2\2OQ\7\r\2\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2"+
		"\2TR\3\2\2\2UV\7\16\2\2VW\7\17\2\2WX\t\3\2\2XY\7\22\2\2YZ\7\r\2\2Za\3"+
		"\2\2\2[]\7\16\2\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^`\7\r\2\2_\\\3\2\2\2"+
		"`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2dh\7\23\2\2eg\5\b\5"+
		"\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\7\3\2\2\2jh\3\2\2\2kl\5\16"+
		"\b\2lm\7\24\2\2mo\7\25\2\2np\7\26\2\2on\3\2\2\2op\3\2\2\2pq\3\2\2\2qy"+
		"\5\n\6\2rt\7\27\2\2su\7\26\2\2ts\3\2\2\2tu\3\2\2\2uv\3\2\2\2vx\5\n\6\2"+
		"wr\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2\2\2|\u0086\7"+
		"\30\2\2}~\7\31\2\2~\u0083\5\22\n\2\177\u0080\7\27\2\2\u0080\u0082\5\22"+
		"\n\2\u0081\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0086}\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\32\2\2\u0089\t\3\2\2"+
		"\2\u008a\u008b\7\33\2\2\u008b\u009f\5 \21\2\u008c\u008d\7\34\2\2\u008d"+
		"\u009f\5\f\7\2\u008e\u008f\7\35\2\2\u008f\u0090\7\36\2\2\u0090\u0091\5"+
		"\36\20\2\u0091\u0095\7\27\2\2\u0092\u0093\5\36\20\2\u0093\u0094\7\27\2"+
		"\2\u0094\u0096\3\2\2\2\u0095\u0092\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097"+
		"\3\2\2\2\u0097\u0098\5\20\t\2\u0098\u0099\7\27\2\2\u0099\u009a\5 \21\2"+
		"\u009a\u009b\7\37\2\2\u009b\u009f\3\2\2\2\u009c\u009f\5 \21\2\u009d\u009f"+
		"\7 \2\2\u009e\u008a\3\2\2\2\u009e\u008c\3\2\2\2\u009e\u008e\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\13\3\2\2\2\u00a0\u00a1\5 \21"+
		"\2\u00a1\u00a2\7!\2\2\u00a2\u00a3\t\4\2\2\u00a3\u00a4\7$\2\2\u00a4\r\3"+
		"\2\2\2\u00a5\u00b6\7%\2\2\u00a6\u00a7\7&\2\2\u00a7\u00a8\7\36\2\2\u00a8"+
		"\u00a9\5\20\t\2\u00a9\u00aa\7\27\2\2\u00aa\u00ab\5 \21\2\u00ab\u00ac\7"+
		"\37\2\2\u00ac\u00b7\3\2\2\2\u00ad\u00b1\5 \21\2\u00ae\u00af\7\'\2\2\u00af"+
		"\u00b1\5\f\7\2\u00b0\u00ad\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b7\3\2"+
		"\2\2\u00b2\u00b3\7(\2\2\u00b3\u00b7\5 \21\2\u00b4\u00b5\7)\2\2\u00b5\u00b7"+
		"\5 \21\2\u00b6\u00a6\3\2\2\2\u00b6\u00b0\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b7\u00c3\3\2\2\2\u00b8\u00c0\7*\2\2\u00b9\u00c1\5 \21"+
		"\2\u00ba\u00bb\7\'\2\2\u00bb\u00c1\5\f\7\2\u00bc\u00bd\7(\2\2\u00bd\u00c1"+
		"\5 \21\2\u00be\u00bf\7)\2\2\u00bf\u00c1\5 \21\2\u00c0\u00b9\3\2\2\2\u00c0"+
		"\u00ba\3\2\2\2\u00c0\u00bc\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c3\3\2"+
		"\2\2\u00c2\u00a5\3\2\2\2\u00c2\u00b8\3\2\2\2\u00c3\17\3\2\2\2\u00c4\u00c5"+
		"\t\5\2\2\u00c5\21\3\2\2\2\u00c6\u00d3\7%\2\2\u00c7\u00d4\5 \21\2\u00c8"+
		"\u00c9\7\'\2\2\u00c9\u00d4\5\f\7\2\u00ca\u00cb\7(\2\2\u00cb\u00d4\5 \21"+
		"\2\u00cc\u00cd\7)\2\2\u00cd\u00d4\5 \21\2\u00ce\u00cf\7\60\2\2\u00cf\u00d4"+
		"\5 \21\2\u00d0\u00d1\7\61\2\2\u00d1\u00d4\5 \21\2\u00d2\u00d4\7\62\2\2"+
		"\u00d3\u00c7\3\2\2\2\u00d3\u00c8\3\2\2\2\u00d3\u00ca\3\2\2\2\u00d3\u00cc"+
		"\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d3\u00d0\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4"+
		"\u00e1\3\2\2\2\u00d5\u00de\7*\2\2\u00d6\u00df\5 \21\2\u00d7\u00d8\7\'"+
		"\2\2\u00d8\u00df\5\f\7\2\u00d9\u00da\7(\2\2\u00da\u00df\5 \21\2\u00db"+
		"\u00dc\7)\2\2\u00dc\u00df\5 \21\2\u00dd\u00df\7\62\2\2\u00de\u00d6\3\2"+
		"\2\2\u00de\u00d7\3\2\2\2\u00de\u00d9\3\2\2\2\u00de\u00db\3\2\2\2\u00de"+
		"\u00dd\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00c6\3\2\2\2\u00e0\u00d5\3\2"+
		"\2\2\u00e1\u00e5\3\2\2\2\u00e2\u00e5\5\26\f\2\u00e3\u00e5\5\24\13\2\u00e4"+
		"\u00e0\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\23\3\2\2"+
		"\2\u00e6\u00e7\7\63\2\2\u00e7\u00e8\5 \21\2\u00e8\25\3\2\2\2\u00e9\u00ea"+
		"\7\64\2\2\u00ea\u00eb\7\36\2\2\u00eb\u00ec\5 \21\2\u00ec\u00ed\7\27\2"+
		"\2\u00ed\u00ee\5\20\t\2\u00ee\u00ef\7\27\2\2\u00ef\u00f0\5 \21\2\u00f0"+
		"\u00f1\7\37\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f4\5 \21\2\u00f3\u00e9\3"+
		"\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\27\3\2\2\2\u00f5\u00f6\5\32\16\2\u00f6"+
		"\31\3\2\2\2\u00f7\u00fa\5\34\17\2\u00f8\u00f9\7\65\2\2\u00f9\u00fb\5\34"+
		"\17\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\33\3\2\2\2\u00fe\u00ff\t\6\2\2\u00ff\35\3\2\2\2\u0100"+
		"\u0103\7\66\2\2\u0101\u0103\7\67\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3"+
		"\2\2\2\u0103\37\3\2\2\2\u0104\u0109\7\66\2\2\u0105\u0106\78\2\2\u0106"+
		"\u0108\7\66\2\2\u0107\u0105\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3"+
		"\2\2\2\u0109\u010a\3\2\2\2\u010a\u011c\3\2\2\2\u010b\u0109\3\2\2\2\u010c"+
		"\u010f\7\36\2\2\u010d\u0110\5 \21\2\u010e\u0110\79\2\2\u010f\u010d\3\2"+
		"\2\2\u010f\u010e\3\2\2\2\u0110\u0118\3\2\2\2\u0111\u0114\7:\2\2\u0112"+
		"\u0115\5 \21\2\u0113\u0115\79\2\2\u0114\u0112\3\2\2\2\u0114\u0113\3\2"+
		"\2\2\u0115\u0117\3\2\2\2\u0116\u0111\3\2\2\2\u0117\u011a\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u0118\3\2"+
		"\2\2\u011b\u011d\7\37\2\2\u011c\u010c\3\2\2\2\u011c\u011d\3\2\2\2\u011d"+
		"\u012a\3\2\2\2\u011e\u011f\7\17\2\2\u011f\u0124\5 \21\2\u0120\u0121\7"+
		":\2\2\u0121\u0123\5 \21\2\u0122\u0120\3\2\2\2\u0123\u0126\3\2\2\2\u0124"+
		"\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0124\3\2"+
		"\2\2\u0127\u0128\7\22\2\2\u0128\u012a\3\2\2\2\u0129\u0104\3\2\2\2\u0129"+
		"\u011e\3\2\2\2\u012a!\3\2\2\2\'(+\61\66=DILR\\ahoty\u0083\u0086\u0095"+
		"\u009e\u00b0\u00b6\u00c0\u00c2\u00d3\u00de\u00e0\u00e4\u00f3\u00fc\u0102"+
		"\u0109\u010f\u0114\u0118\u011c\u0124\u0129";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}