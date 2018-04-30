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
		GWENDOLEN=1, GOALS=2, BELIEFS=3, BELIEFRULES=4, PLANS=5, NAME=6, SEND=7, 
		LOCK=8, ADD_PLAN=9, TELL=10, PERFORM=11, ACHIEVE=12, ACHIEVEGOAL=13, PERFORMGOAL=14, 
		BRULEARROW=15, RULEARROW=16, NOT=17, TRUE=18, RECEIVED=19, BELIEVE=20, 
		GOAL=21, SENT=22, CONST=23, QUOTED_STRING=24, OPEN=25, CLOSE=26, CURLYOPEN=27, 
		CURLYCLOSE=28, SQOPEN=29, SQCLOSE=30, COMMASEP=31, IDPUNCT=32, BAR=33, 
		SEMI=34, COLON=35, QUERY=36, MULT=37, PLUS=38, MINUS=39, SHRIEK=40, COMMENT=41, 
		LINE_COMMENT=42, NEWLINE=43, WS=44;
	public static final int
		RULE_mas = 0, RULE_gwendolenagents = 1, RULE_gwendolenagent = 2, RULE_guard_atom = 3, 
		RULE_goal = 4, RULE_plan = 5, RULE_pn_guard_atom = 6, RULE_event = 7, 
		RULE_performative = 8, RULE_deed = 9, RULE_brule = 10, RULE_waitfor = 11, 
		RULE_action = 12, RULE_environment = 13, RULE_classpath = 14, RULE_word = 15, 
		RULE_agentnameterm = 16, RULE_fof_expr = 17;
	public static final String[] ruleNames = {
		"mas", "gwendolenagents", "gwendolenagent", "guard_atom", "goal", "plan", 
		"pn_guard_atom", "event", "performative", "deed", "brule", "waitfor", 
		"action", "environment", "classpath", "word", "agentnameterm", "fof_expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'GWENDOLEN'", "':Initial Goals:'", "':Initial Beliefs:'", "':Reasoning Rules:'", 
		"':Plans:'", "':name:'", "'.send'", "'.lock'", "'.plan'", "':tell'", "':perform'", 
		"':achieve'", null, null, "':-'", "'<-'", "'~'", "'True'", "'.received'", 
		null, null, "'.sent'", null, null, "'('", "')'", "'{'", "'}'", "'['", 
		"']'", "','", "'.'", "'|'", "';'", "':'", "'?'", "'*'", "'+'", "'-'", 
		"'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "GWENDOLEN", "GOALS", "BELIEFS", "BELIEFRULES", "PLANS", "NAME", 
		"SEND", "LOCK", "ADD_PLAN", "TELL", "PERFORM", "ACHIEVE", "ACHIEVEGOAL", 
		"PERFORMGOAL", "BRULEARROW", "RULEARROW", "NOT", "TRUE", "RECEIVED", "BELIEVE", 
		"GOAL", "SENT", "CONST", "QUOTED_STRING", "OPEN", "CLOSE", "CURLYOPEN", 
		"CURLYCLOSE", "SQOPEN", "SQCLOSE", "COMMASEP", "IDPUNCT", "BAR", "SEMI", 
		"COLON", "QUERY", "MULT", "PLUS", "MINUS", "SHRIEK", "COMMENT", "LINE_COMMENT", 
		"NEWLINE", "WS"
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
			setState(36);
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
			setState(38);
			match(GWENDOLEN);
			setState(40); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(39);
				((GwendolenagentsContext)_localctx).g = gwendolenagent();
				}
				}
				setState(42); 
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
		public Fof_exprContext l;
		public BruleContext r;
		public GoalContext gl;
		public PlanContext p;
		public TerminalNode NAME() { return getToken(GwendolenParser.NAME, 0); }
		public TerminalNode BELIEFS() { return getToken(GwendolenParser.BELIEFS, 0); }
		public TerminalNode GOALS() { return getToken(GwendolenParser.GOALS, 0); }
		public TerminalNode PLANS() { return getToken(GwendolenParser.PLANS, 0); }
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public TerminalNode BELIEFRULES() { return getToken(GwendolenParser.BELIEFRULES, 0); }
		public List<Fof_exprContext> fof_expr() {
			return getRuleContexts(Fof_exprContext.class);
		}
		public Fof_exprContext fof_expr(int i) {
			return getRuleContext(Fof_exprContext.class,i);
		}
		public List<GoalContext> goal() {
			return getRuleContexts(GoalContext.class);
		}
		public GoalContext goal(int i) {
			return getRuleContext(GoalContext.class,i);
		}
		public List<PlanContext> plan() {
			return getRuleContexts(PlanContext.class);
		}
		public PlanContext plan(int i) {
			return getRuleContext(PlanContext.class,i);
		}
		public TerminalNode GWENDOLEN() { return getToken(GwendolenParser.GWENDOLEN, 0); }
		public List<BruleContext> brule() {
			return getRuleContexts(BruleContext.class);
		}
		public BruleContext brule(int i) {
			return getRuleContext(BruleContext.class,i);
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
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GWENDOLEN) {
				{
				setState(44);
				match(GWENDOLEN);
				}
			}

			}
			setState(47);
			match(NAME);
			setState(48);
			((GwendolenagentContext)_localctx).w = word();
			setState(49);
			match(BELIEFS);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST || _la==SQOPEN) {
				{
				{
				setState(50);
				((GwendolenagentContext)_localctx).l = fof_expr();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BELIEFRULES) {
				{
				setState(56);
				match(BELIEFRULES);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CONST || _la==SQOPEN) {
					{
					{
					setState(57);
					((GwendolenagentContext)_localctx).r = brule();
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(65);
			match(GOALS);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST || _la==SQOPEN) {
				{
				{
				setState(66);
				((GwendolenagentContext)_localctx).gl = goal();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(PLANS);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(73);
				((GwendolenagentContext)_localctx).p = plan();
				}
				}
				setState(78);
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
		public List<TerminalNode> COMMASEP() { return getTokens(GwendolenParser.COMMASEP); }
		public TerminalNode COMMASEP(int i) {
			return getToken(GwendolenParser.COMMASEP, i);
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
		enterRule(_localctx, 6, RULE_guard_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BELIEVE:
				{
				setState(79);
				match(BELIEVE);
				setState(80);
				((Guard_atomContext)_localctx).l = fof_expr();
				}
				break;
			case GOAL:
				{
				setState(81);
				match(GOAL);
				setState(82);
				((Guard_atomContext)_localctx).gl = goal();
				}
				break;
			case SENT:
				{
				setState(83);
				match(SENT);
				setState(84);
				match(OPEN);
				{
				setState(85);
				((Guard_atomContext)_localctx).s = agentnameterm();
				}
				setState(86);
				match(COMMASEP);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONST) {
					{
					setState(87);
					((Guard_atomContext)_localctx).an2 = agentnameterm();
					setState(88);
					match(COMMASEP);
					}
				}

				setState(92);
				((Guard_atomContext)_localctx).p = performative();
				setState(93);
				match(COMMASEP);
				setState(94);
				((Guard_atomContext)_localctx).t = fof_expr();
				setState(95);
				match(CLOSE);
				}
				break;
			case CONST:
			case SQOPEN:
				{
				setState(97);
				((Guard_atomContext)_localctx).eq = fof_expr();
				}
				break;
			case TRUE:
				{
				setState(98);
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
		public Fof_exprContext l;
		public TerminalNode SQOPEN() { return getToken(GwendolenParser.SQOPEN, 0); }
		public TerminalNode SQCLOSE() { return getToken(GwendolenParser.SQCLOSE, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode ACHIEVEGOAL() { return getToken(GwendolenParser.ACHIEVEGOAL, 0); }
		public TerminalNode PERFORMGOAL() { return getToken(GwendolenParser.PERFORMGOAL, 0); }
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
		enterRule(_localctx, 8, RULE_goal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			((GoalContext)_localctx).l = fof_expr();
			setState(102);
			match(SQOPEN);
			setState(103);
			_la = _input.LA(1);
			if ( !(_la==ACHIEVEGOAL || _la==PERFORMGOAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(104);
			match(SQCLOSE);
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
		public Pn_guard_atomContext g1;
		public Pn_guard_atomContext gs;
		public DeedContext d;
		public DeedContext ds;
		public TerminalNode COLON() { return getToken(GwendolenParser.COLON, 0); }
		public TerminalNode CURLYOPEN() { return getToken(GwendolenParser.CURLYOPEN, 0); }
		public TerminalNode CURLYCLOSE() { return getToken(GwendolenParser.CURLYCLOSE, 0); }
		public TerminalNode SEMI() { return getToken(GwendolenParser.SEMI, 0); }
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public List<Pn_guard_atomContext> pn_guard_atom() {
			return getRuleContexts(Pn_guard_atomContext.class);
		}
		public Pn_guard_atomContext pn_guard_atom(int i) {
			return getRuleContext(Pn_guard_atomContext.class,i);
		}
		public List<TerminalNode> COMMASEP() { return getTokens(GwendolenParser.COMMASEP); }
		public TerminalNode COMMASEP(int i) {
			return getToken(GwendolenParser.COMMASEP, i);
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
		enterRule(_localctx, 10, RULE_plan);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			((PlanContext)_localctx).e = event();
			setState(107);
			match(COLON);
			setState(108);
			match(CURLYOPEN);
			setState(109);
			((PlanContext)_localctx).g1 = pn_guard_atom();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMASEP) {
				{
				{
				setState(110);
				match(COMMASEP);
				setState(111);
				((PlanContext)_localctx).gs = pn_guard_atom();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(CURLYCLOSE);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULEARROW) {
				{
				setState(118);
				match(RULEARROW);
				setState(119);
				((PlanContext)_localctx).d = deed();
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMASEP) {
					{
					{
					setState(120);
					match(COMMASEP);
					setState(121);
					((PlanContext)_localctx).ds = deed();
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(129);
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

	public static class Pn_guard_atomContext extends ParserRuleContext {
		public Guard_atomContext gb;
		public Guard_atomContext guard_atom() {
			return getRuleContext(Guard_atomContext.class,0);
		}
		public TerminalNode NOT() { return getToken(GwendolenParser.NOT, 0); }
		public Pn_guard_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pn_guard_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitPn_guard_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pn_guard_atomContext pn_guard_atom() throws RecognitionException {
		Pn_guard_atomContext _localctx = new Pn_guard_atomContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_pn_guard_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(131);
				match(NOT);
				}
			}

			setState(134);
			((Pn_guard_atomContext)_localctx).gb = guard_atom();
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
		public TerminalNode COMMASEP() { return getToken(GwendolenParser.COMMASEP, 0); }
		public TerminalNode CLOSE() { return getToken(GwendolenParser.CLOSE, 0); }
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
		enterRule(_localctx, 14, RULE_event);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				{
				setState(136);
				match(PLUS);
				setState(150);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RECEIVED:
					{
					setState(137);
					match(RECEIVED);
					setState(138);
					match(OPEN);
					setState(139);
					((EventContext)_localctx).p = performative();
					setState(140);
					match(COMMASEP);
					setState(141);
					((EventContext)_localctx).t = fof_expr();
					setState(142);
					match(CLOSE);
					}
					break;
				case CONST:
				case SQOPEN:
				case SHRIEK:
					{
					setState(147);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case CONST:
					case SQOPEN:
						{
						setState(144);
						((EventContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(145);
						match(SHRIEK);
						setState(146);
						((EventContext)_localctx).g = goal();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case COLON:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case MINUS:
				{
				setState(152);
				match(MINUS);
				setState(157);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CONST:
				case SQOPEN:
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
				case COLON:
					{
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
		enterRule(_localctx, 16, RULE_performative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TELL) | (1L << PERFORM) | (1L << ACHIEVE))) != 0)) ) {
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
		public ActionContext a;
		public WaitforContext wf;
		public WaitforContext waitfor() {
			return getRuleContext(WaitforContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(GwendolenParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(GwendolenParser.MINUS, 0); }
		public TerminalNode SHRIEK() { return getToken(GwendolenParser.SHRIEK, 0); }
		public TerminalNode ADD_PLAN() { return getToken(GwendolenParser.ADD_PLAN, 0); }
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
		enterRule(_localctx, 18, RULE_deed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEND:
			case CONST:
			case SQOPEN:
			case PLUS:
			case MINUS:
				{
				setState(182);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
				case MINUS:
					{
					setState(179);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PLUS:
						{
						setState(163);
						match(PLUS);
						setState(170);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case CONST:
						case SQOPEN:
							{
							setState(164);
							((DeedContext)_localctx).l = fof_expr();
							}
							break;
						case SHRIEK:
							{
							setState(165);
							match(SHRIEK);
							setState(166);
							((DeedContext)_localctx).g = goal();
							}
							break;
						case ADD_PLAN:
							{
							setState(167);
							match(ADD_PLAN);
							setState(168);
							((DeedContext)_localctx).p = fof_expr();
							}
							break;
						case LOCK:
							{
							setState(169);
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
						setState(172);
						match(MINUS);
						setState(177);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case CONST:
						case SQOPEN:
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
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case SEND:
				case CONST:
				case SQOPEN:
					{
					setState(181);
					((DeedContext)_localctx).a = action();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case MULT:
				{
				setState(184);
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

	public static class BruleContext extends ParserRuleContext {
		public Fof_exprContext head;
		public Fof_exprContext f;
		public List<Fof_exprContext> fof_expr() {
			return getRuleContexts(Fof_exprContext.class);
		}
		public Fof_exprContext fof_expr(int i) {
			return getRuleContext(Fof_exprContext.class,i);
		}
		public TerminalNode BRULEARROW() { return getToken(GwendolenParser.BRULEARROW, 0); }
		public TerminalNode SEMI() { return getToken(GwendolenParser.SEMI, 0); }
		public BruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_brule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitBrule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BruleContext brule() throws RecognitionException {
		BruleContext _localctx = new BruleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_brule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			((BruleContext)_localctx).head = fof_expr();
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRULEARROW:
				{
				setState(188);
				match(BRULEARROW);
				setState(189);
				((BruleContext)_localctx).f = fof_expr();
				setState(190);
				match(SEMI);
				}
				break;
			case SEMI:
				{
				setState(192);
				match(SEMI);
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
		enterRule(_localctx, 22, RULE_waitfor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(MULT);
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
		public List<TerminalNode> COMMASEP() { return getTokens(GwendolenParser.COMMASEP); }
		public TerminalNode COMMASEP(int i) {
			return getToken(GwendolenParser.COMMASEP, i);
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
		enterRule(_localctx, 24, RULE_action);
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
				match(COMMASEP);
				setState(202);
				((ActionContext)_localctx).p = performative();
				setState(203);
				match(COMMASEP);
				setState(204);
				((ActionContext)_localctx).t = fof_expr();
				setState(205);
				match(CLOSE);
				}
				}
				break;
			case CONST:
			case SQOPEN:
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
		enterRule(_localctx, 26, RULE_environment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
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
		public List<TerminalNode> IDPUNCT() { return getTokens(GwendolenParser.IDPUNCT); }
		public TerminalNode IDPUNCT(int i) {
			return getToken(GwendolenParser.IDPUNCT, i);
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
		enterRule(_localctx, 28, RULE_classpath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			((ClasspathContext)_localctx).w = word();
			setState(215); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(213);
				match(IDPUNCT);
				setState(214);
				((ClasspathContext)_localctx).w1 = word();
				}
				}
				setState(217); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDPUNCT );
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
		enterRule(_localctx, 30, RULE_word);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(CONST);
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
		public TerminalNode CONST() { return getToken(GwendolenParser.CONST, 0); }
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
		enterRule(_localctx, 32, RULE_agentnameterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(CONST);
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
		public TerminalNode BAR() { return getToken(GwendolenParser.BAR, 0); }
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
		enterRule(_localctx, 34, RULE_fof_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				{
				setState(223);
				match(CONST);
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDPUNCT) {
					{
					{
					setState(224);
					match(IDPUNCT);
					setState(225);
					match(CONST);
					}
					}
					setState(230);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN) {
					{
					setState(231);
					match(OPEN);
					setState(234);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case CONST:
					case SQOPEN:
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
					setState(243);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMASEP) {
						{
						{
						setState(236);
						match(COMMASEP);
						setState(239);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case CONST:
						case SQOPEN:
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
						}
						}
						setState(245);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(246);
					match(CLOSE);
					}
				}

				}
				break;
			case SQOPEN:
				{
				setState(249);
				match(SQOPEN);
				setState(250);
				fof_expr();
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMASEP) {
					{
					{
					setState(251);
					match(COMMASEP);
					setState(252);
					fof_expr();
					}
					}
					setState(257);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BAR) {
					{
					setState(258);
					match(BAR);
					setState(259);
					match(CONST);
					}
				}

				setState(262);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u010d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\6\3+\n\3\r\3\16\3,\3\4\5\4\60\n\4\3\4\3\4\3"+
		"\4\3\4\7\4\66\n\4\f\4\16\49\13\4\3\4\3\4\7\4=\n\4\f\4\16\4@\13\4\5\4B"+
		"\n\4\3\4\3\4\7\4F\n\4\f\4\16\4I\13\4\3\4\3\4\7\4M\n\4\f\4\16\4P\13\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5]\n\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5f\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7s\n"+
		"\7\f\7\16\7v\13\7\3\7\3\7\3\7\3\7\3\7\7\7}\n\7\f\7\16\7\u0080\13\7\5\7"+
		"\u0082\n\7\3\7\3\7\3\b\5\b\u0087\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u0096\n\t\3\t\5\t\u0099\n\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\t\u00a0\n\t\5\t\u00a2\n\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u00ad\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u00b4\n\13\5\13\u00b6\n"+
		"\13\3\13\5\13\u00b9\n\13\3\13\5\13\u00bc\n\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u00c4\n\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u00d3\n\16\3\17\3\17\3\20\3\20\3\20\6\20\u00da\n\20\r\20\16"+
		"\20\u00db\3\21\3\21\3\22\3\22\3\23\3\23\3\23\7\23\u00e5\n\23\f\23\16\23"+
		"\u00e8\13\23\3\23\3\23\3\23\5\23\u00ed\n\23\3\23\3\23\3\23\5\23\u00f2"+
		"\n\23\7\23\u00f4\n\23\f\23\16\23\u00f7\13\23\3\23\5\23\u00fa\n\23\3\23"+
		"\3\23\3\23\3\23\7\23\u0100\n\23\f\23\16\23\u0103\13\23\3\23\3\23\5\23"+
		"\u0107\n\23\3\23\3\23\5\23\u010b\n\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$\2\4\3\2\17\20\3\2\f\16\2\u0123\2&\3\2\2\2\4(\3"+
		"\2\2\2\6/\3\2\2\2\be\3\2\2\2\ng\3\2\2\2\fl\3\2\2\2\16\u0086\3\2\2\2\20"+
		"\u00a1\3\2\2\2\22\u00a3\3\2\2\2\24\u00bb\3\2\2\2\26\u00bd\3\2\2\2\30\u00c5"+
		"\3\2\2\2\32\u00d2\3\2\2\2\34\u00d4\3\2\2\2\36\u00d6\3\2\2\2 \u00dd\3\2"+
		"\2\2\"\u00df\3\2\2\2$\u010a\3\2\2\2&\'\5\4\3\2\'\3\3\2\2\2(*\7\3\2\2)"+
		"+\5\6\4\2*)\3\2\2\2+,\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\5\3\2\2\2.\60\7\3\2"+
		"\2/.\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\62\7\b\2\2\62\63\5 \21\2\63"+
		"\67\7\5\2\2\64\66\5$\23\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678"+
		"\3\2\2\28A\3\2\2\29\67\3\2\2\2:>\7\6\2\2;=\5\26\f\2<;\3\2\2\2=@\3\2\2"+
		"\2><\3\2\2\2>?\3\2\2\2?B\3\2\2\2@>\3\2\2\2A:\3\2\2\2AB\3\2\2\2BC\3\2\2"+
		"\2CG\7\4\2\2DF\5\n\6\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2"+
		"\2IG\3\2\2\2JN\7\7\2\2KM\5\f\7\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2"+
		"\2O\7\3\2\2\2PN\3\2\2\2QR\7\26\2\2Rf\5$\23\2ST\7\27\2\2Tf\5\n\6\2UV\7"+
		"\30\2\2VW\7\33\2\2WX\5\"\22\2X\\\7!\2\2YZ\5\"\22\2Z[\7!\2\2[]\3\2\2\2"+
		"\\Y\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\5\22\n\2_`\7!\2\2`a\5$\23\2ab\7\34"+
		"\2\2bf\3\2\2\2cf\5$\23\2df\7\24\2\2eQ\3\2\2\2eS\3\2\2\2eU\3\2\2\2ec\3"+
		"\2\2\2ed\3\2\2\2f\t\3\2\2\2gh\5$\23\2hi\7\37\2\2ij\t\2\2\2jk\7 \2\2k\13"+
		"\3\2\2\2lm\5\20\t\2mn\7%\2\2no\7\35\2\2ot\5\16\b\2pq\7!\2\2qs\5\16\b\2"+
		"rp\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2w\u0081\7"+
		"\36\2\2xy\7\22\2\2y~\5\24\13\2z{\7!\2\2{}\5\24\13\2|z\3\2\2\2}\u0080\3"+
		"\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0081x"+
		"\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7$\2\2\u0084"+
		"\r\3\2\2\2\u0085\u0087\7\23\2\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2"+
		"\2\u0087\u0088\3\2\2\2\u0088\u0089\5\b\5\2\u0089\17\3\2\2\2\u008a\u0098"+
		"\7(\2\2\u008b\u008c\7\25\2\2\u008c\u008d\7\33\2\2\u008d\u008e\5\22\n\2"+
		"\u008e\u008f\7!\2\2\u008f\u0090\5$\23\2\u0090\u0091\7\34\2\2\u0091\u0099"+
		"\3\2\2\2\u0092\u0096\5$\23\2\u0093\u0094\7*\2\2\u0094\u0096\5\n\6\2\u0095"+
		"\u0092\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0099\3\2"+
		"\2\2\u0098\u008b\3\2\2\2\u0098\u0095\3\2\2\2\u0098\u0097\3\2\2\2\u0099"+
		"\u00a2\3\2\2\2\u009a\u009f\7)\2\2\u009b\u00a0\5$\23\2\u009c\u009d\7*\2"+
		"\2\u009d\u00a0\5\n\6\2\u009e\u00a0\3\2\2\2\u009f\u009b\3\2\2\2\u009f\u009c"+
		"\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u008a\3\2\2\2\u00a1"+
		"\u009a\3\2\2\2\u00a2\21\3\2\2\2\u00a3\u00a4\t\3\2\2\u00a4\23\3\2\2\2\u00a5"+
		"\u00ac\7(\2\2\u00a6\u00ad\5$\23\2\u00a7\u00a8\7*\2\2\u00a8\u00ad\5\n\6"+
		"\2\u00a9\u00aa\7\13\2\2\u00aa\u00ad\5$\23\2\u00ab\u00ad\7\n\2\2\u00ac"+
		"\u00a6\3\2\2\2\u00ac\u00a7\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ac\u00ab\3\2"+
		"\2\2\u00ad\u00b6\3\2\2\2\u00ae\u00b3\7)\2\2\u00af\u00b4\5$\23\2\u00b0"+
		"\u00b1\7*\2\2\u00b1\u00b4\5\n\6\2\u00b2\u00b4\7\n\2\2\u00b3\u00af\3\2"+
		"\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5"+
		"\u00a5\3\2\2\2\u00b5\u00ae\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b9\5\32"+
		"\16\2\u00b8\u00b5\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba"+
		"\u00bc\5\30\r\2\u00bb\u00b8\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\25\3\2\2"+
		"\2\u00bd\u00c3\5$\23\2\u00be\u00bf\7\21\2\2\u00bf\u00c0\5$\23\2\u00c0"+
		"\u00c1\7$\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c4\7$\2\2\u00c3\u00be\3\2\2"+
		"\2\u00c3\u00c2\3\2\2\2\u00c4\27\3\2\2\2\u00c5\u00c6\7\'\2\2\u00c6\u00c7"+
		"\5$\23\2\u00c7\31\3\2\2\2\u00c8\u00c9\7\t\2\2\u00c9\u00ca\7\33\2\2\u00ca"+
		"\u00cb\5$\23\2\u00cb\u00cc\7!\2\2\u00cc\u00cd\5\22\n\2\u00cd\u00ce\7!"+
		"\2\2\u00ce\u00cf\5$\23\2\u00cf\u00d0\7\34\2\2\u00d0\u00d3\3\2\2\2\u00d1"+
		"\u00d3\5$\23\2\u00d2\u00c8\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\33\3\2\2"+
		"\2\u00d4\u00d5\5\36\20\2\u00d5\35\3\2\2\2\u00d6\u00d9\5 \21\2\u00d7\u00d8"+
		"\7\"\2\2\u00d8\u00da\5 \21\2\u00d9\u00d7\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\37\3\2\2\2\u00dd\u00de\7\31\2"+
		"\2\u00de!\3\2\2\2\u00df\u00e0\7\31\2\2\u00e0#\3\2\2\2\u00e1\u00e6\7\31"+
		"\2\2\u00e2\u00e3\7\"\2\2\u00e3\u00e5\7\31\2\2\u00e4\u00e2\3\2\2\2\u00e5"+
		"\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00f9\3\2"+
		"\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ec\7\33\2\2\u00ea\u00ed\5$\23\2\u00eb"+
		"\u00ed\7\32\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f5\3"+
		"\2\2\2\u00ee\u00f1\7!\2\2\u00ef\u00f2\5$\23\2\u00f0\u00f2\7\32\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00ee\3\2"+
		"\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00fa\7\34\2\2\u00f9\u00e9\3"+
		"\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u010b\3\2\2\2\u00fb\u00fc\7\37\2\2\u00fc"+
		"\u0101\5$\23\2\u00fd\u00fe\7!\2\2\u00fe\u0100\5$\23\2\u00ff\u00fd\3\2"+
		"\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0106\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7#\2\2\u0105\u0107\7\31"+
		"\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\u0109\7 \2\2\u0109\u010b\3\2\2\2\u010a\u00e1\3\2\2\2\u010a\u00fb\3\2"+
		"\2\2\u010b%\3\2\2\2#,/\67>AGN\\et~\u0081\u0086\u0095\u0098\u009f\u00a1"+
		"\u00ac\u00b3\u00b5\u00b8\u00bb\u00c3\u00d2\u00db\u00e6\u00ec\u00f1\u00f5"+
		"\u00f9\u0101\u0106\u010a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}