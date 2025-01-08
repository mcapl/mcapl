// Generated from /Users/louisedennis/IdeaProjects/mcapl/src/classes/eass/parser/antlr/EASS.g4 by ANTLR 4.13.1
package eass.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EASSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EASS=1, ABSTRACTION=2, GWENDOLEN=3, NAME=4, CONST=5, COMMENT=6, LINE_COMMENT=7, 
		NEWLINE=8, WS=9, BELIEFS=10, BELIEFRULES=11, GOAL_IB=12, CAP_IB=13, IB_COMMENT=14, 
		IB_LINE_COMMENT=15, IB_NEWLINE=16, IB_WS=17, BELIEF_BLOCK=18, GOAL_RR=19, 
		CAP_RR=20, RR_COMMENT=21, RR_LINE_COMMENT=22, RR_NEWLINE=23, RR_WS=24, 
		RR_BLOCK=25, GOAL_C=26, CAP_COMMENT=27, CAP_LINE_COMMENT=28, CAP_NEWLINE=29, 
		CAP_WS=30, CAP_BLOCK=31, PLANS=32, GL_COMMENT=33, GL_LINE_COMMENT=34, 
		GL_NEWLINE=35, GL_WS=36, GL_ACHIEVEGOAL=37, GL_PERFORMGOAL=38, GL_SQOPEN=39, 
		GL_SQCLOSE=40, GOAL_BLOCK=41, NAME_PM=42, PL_COMMENT=43, PL_LINE_COMMENT=44, 
		PL_NEWLINE=45, PL_WS=46, SEND=47, RECEIVED=48, BELIEVE=49, GOAL=50, SENT=51, 
		LOCK=52, PL_ACHIEVEGOAL=53, PL_PERFORMGOAL=54, PL_SQOPEN=55, PL_SQCLOSE=56, 
		PL_BAR=57, NOT=58, COLON=59, CURLYOPEN=60, CURLYCLOSE=61, COMMA=62, SEMI=63, 
		TELL=64, SHRIEK=65, OPEN=66, CLOSE=67, MULT=68, PLUS=69, MINUS=70, LESS=71, 
		EQUAL=72, IDPUNCT=73, RULEARROW=74, TRUE=75, PL_CONST=76, PL_VAR=77, NUMBER=78, 
		QUOTED_STRING=79;
	public static final int
		RULE_mas = 0, RULE_eassagents = 1, RULE_eassagent = 2, RULE_gwendolenagents = 3, 
		RULE_gwendolenagent = 4, RULE_initial_goal = 5, RULE_plan = 6, RULE_guard_atom = 7, 
		RULE_event = 8, RULE_performative = 9, RULE_deed = 10, RULE_goal = 11, 
		RULE_waitfor = 12, RULE_action = 13, RULE_fof_expr = 14, RULE_const_var = 15, 
		RULE_oper = 16, RULE_agentnameterm = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"mas", "eassagents", "eassagent", "gwendolenagents", "gwendolenagent", 
			"initial_goal", "plan", "guard_atom", "event", "performative", "deed", 
			"goal", "waitfor", "action", "fof_expr", "const_var", "oper", "agentnameterm"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'EASS'", "'abstraction'", "'GWENDOLEN'", null, null, null, null, 
			null, null, "':Initial Beliefs:'", "':Reasoning Rules:'", null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'Initial Goals:'", null, null, null, null, null, "':Plans:'", null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'.send'", "'.received'", null, null, "'.sent'", "'.lock'", "'achieve'", 
			"'perform'", null, null, "'|'", "'~'", "':'", "'{'", "'}'", "','", "';'", 
			"':tell'", "'!'", "'('", "')'", "'*'", "'+'", "'-'", "'<'", "'=='", "'.'", 
			"'<-'", "'True'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "EASS", "ABSTRACTION", "GWENDOLEN", "NAME", "CONST", "COMMENT", 
			"LINE_COMMENT", "NEWLINE", "WS", "BELIEFS", "BELIEFRULES", "GOAL_IB", 
			"CAP_IB", "IB_COMMENT", "IB_LINE_COMMENT", "IB_NEWLINE", "IB_WS", "BELIEF_BLOCK", 
			"GOAL_RR", "CAP_RR", "RR_COMMENT", "RR_LINE_COMMENT", "RR_NEWLINE", "RR_WS", 
			"RR_BLOCK", "GOAL_C", "CAP_COMMENT", "CAP_LINE_COMMENT", "CAP_NEWLINE", 
			"CAP_WS", "CAP_BLOCK", "PLANS", "GL_COMMENT", "GL_LINE_COMMENT", "GL_NEWLINE", 
			"GL_WS", "GL_ACHIEVEGOAL", "GL_PERFORMGOAL", "GL_SQOPEN", "GL_SQCLOSE", 
			"GOAL_BLOCK", "NAME_PM", "PL_COMMENT", "PL_LINE_COMMENT", "PL_NEWLINE", 
			"PL_WS", "SEND", "RECEIVED", "BELIEVE", "GOAL", "SENT", "LOCK", "PL_ACHIEVEGOAL", 
			"PL_PERFORMGOAL", "PL_SQOPEN", "PL_SQCLOSE", "PL_BAR", "NOT", "COLON", 
			"CURLYOPEN", "CURLYCLOSE", "COMMA", "SEMI", "TELL", "SHRIEK", "OPEN", 
			"CLOSE", "MULT", "PLUS", "MINUS", "LESS", "EQUAL", "IDPUNCT", "RULEARROW", 
			"TRUE", "PL_CONST", "PL_VAR", "NUMBER", "QUOTED_STRING"
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
	public String getGrammarFileName() { return "EASS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EASSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MasContext extends ParserRuleContext {
		public EassagentsContext glist;
		public EassagentsContext eassagents() {
			return getRuleContext(EassagentsContext.class,0);
		}
		public MasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mas; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitMas(this);
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
			((MasContext)_localctx).glist = eassagents();
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
	public static class EassagentsContext extends ParserRuleContext {
		public EassagentContext g;
		public TerminalNode EASS() { return getToken(EASSParser.EASS, 0); }
		public List<EassagentContext> eassagent() {
			return getRuleContexts(EassagentContext.class);
		}
		public EassagentContext eassagent(int i) {
			return getRuleContext(EassagentContext.class,i);
		}
		public EassagentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eassagents; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitEassagents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EassagentsContext eassagents() throws RecognitionException {
		EassagentsContext _localctx = new EassagentsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_eassagents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(EASS);
			setState(40); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(39);
				((EassagentsContext)_localctx).g = eassagent();
				}
				}
				setState(42); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4398046511126L) != 0) );
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
	public static class EassagentContext extends ParserRuleContext {
		public Token w;
		public Token bs;
		public Token rr;
		public Token cap;
		public Initial_goalContext gs;
		public PlanContext p;
		public TerminalNode BELIEFS() { return getToken(EASSParser.BELIEFS, 0); }
		public TerminalNode PLANS() { return getToken(EASSParser.PLANS, 0); }
		public TerminalNode NAME() { return getToken(EASSParser.NAME, 0); }
		public TerminalNode NAME_PM() { return getToken(EASSParser.NAME_PM, 0); }
		public TerminalNode ABSTRACTION() { return getToken(EASSParser.ABSTRACTION, 0); }
		public TerminalNode CONST() { return getToken(EASSParser.CONST, 0); }
		public TerminalNode GOAL_IB() { return getToken(EASSParser.GOAL_IB, 0); }
		public TerminalNode GOAL_RR() { return getToken(EASSParser.GOAL_RR, 0); }
		public TerminalNode GOAL_C() { return getToken(EASSParser.GOAL_C, 0); }
		public TerminalNode BELIEFRULES() { return getToken(EASSParser.BELIEFRULES, 0); }
		public List<TerminalNode> BELIEF_BLOCK() { return getTokens(EASSParser.BELIEF_BLOCK); }
		public TerminalNode BELIEF_BLOCK(int i) {
			return getToken(EASSParser.BELIEF_BLOCK, i);
		}
		public TerminalNode CAP_IB() { return getToken(EASSParser.CAP_IB, 0); }
		public TerminalNode CAP_RR() { return getToken(EASSParser.CAP_RR, 0); }
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
		public TerminalNode EASS() { return getToken(EASSParser.EASS, 0); }
		public List<TerminalNode> RR_NEWLINE() { return getTokens(EASSParser.RR_NEWLINE); }
		public TerminalNode RR_NEWLINE(int i) {
			return getToken(EASSParser.RR_NEWLINE, i);
		}
		public List<TerminalNode> CAP_NEWLINE() { return getTokens(EASSParser.CAP_NEWLINE); }
		public TerminalNode CAP_NEWLINE(int i) {
			return getToken(EASSParser.CAP_NEWLINE, i);
		}
		public List<TerminalNode> RR_BLOCK() { return getTokens(EASSParser.RR_BLOCK); }
		public TerminalNode RR_BLOCK(int i) {
			return getToken(EASSParser.RR_BLOCK, i);
		}
		public List<TerminalNode> CAP_BLOCK() { return getTokens(EASSParser.CAP_BLOCK); }
		public TerminalNode CAP_BLOCK(int i) {
			return getToken(EASSParser.CAP_BLOCK, i);
		}
		public EassagentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eassagent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitEassagent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EassagentContext eassagent() throws RecognitionException {
		EassagentContext _localctx = new EassagentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_eassagent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EASS) {
				{
				setState(44);
				match(EASS);
				}
			}

			}
			setState(47);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4398046511124L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(48);
			((EassagentContext)_localctx).w = match(CONST);
			setState(49);
			match(BELIEFS);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BELIEF_BLOCK) {
				{
				{
				setState(50);
				((EassagentContext)_localctx).bs = match(BELIEF_BLOCK);
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BELIEFRULES) {
				{
				setState(56);
				match(BELIEFRULES);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_NEWLINE) {
					{
					{
					setState(57);
					match(RR_NEWLINE);
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_BLOCK) {
					{
					{
					setState(63);
					((EassagentContext)_localctx).rr = match(RR_BLOCK);
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CAP_IB || _la==CAP_RR) {
				{
				setState(71);
				_la = _input.LA(1);
				if ( !(_la==CAP_IB || _la==CAP_RR) ) {
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
				while (_la==CAP_NEWLINE) {
					{
					{
					setState(72);
					match(CAP_NEWLINE);
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAP_BLOCK) {
					{
					{
					setState(78);
					((EassagentContext)_localctx).cap = match(CAP_BLOCK);
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(86);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 67637248L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GOAL_BLOCK) {
				{
				{
				setState(87);
				((EassagentContext)_localctx).gs = initial_goal();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			match(PLANS);
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(94);
				((EassagentContext)_localctx).p = plan();
				}
				}
				setState(97); 
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
	public static class GwendolenagentsContext extends ParserRuleContext {
		public GwendolenagentContext g;
		public TerminalNode GWENDOLEN() { return getToken(EASSParser.GWENDOLEN, 0); }
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
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitGwendolenagents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GwendolenagentsContext gwendolenagents() throws RecognitionException {
		GwendolenagentsContext _localctx = new GwendolenagentsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_gwendolenagents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(GWENDOLEN);
			setState(101); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(100);
				((GwendolenagentsContext)_localctx).g = gwendolenagent();
				}
				}
				setState(103); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4398046511128L) != 0) );
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
		public TerminalNode BELIEFS() { return getToken(EASSParser.BELIEFS, 0); }
		public TerminalNode PLANS() { return getToken(EASSParser.PLANS, 0); }
		public TerminalNode NAME() { return getToken(EASSParser.NAME, 0); }
		public TerminalNode NAME_PM() { return getToken(EASSParser.NAME_PM, 0); }
		public TerminalNode CONST() { return getToken(EASSParser.CONST, 0); }
		public TerminalNode GOAL_IB() { return getToken(EASSParser.GOAL_IB, 0); }
		public TerminalNode GOAL_RR() { return getToken(EASSParser.GOAL_RR, 0); }
		public TerminalNode BELIEFRULES() { return getToken(EASSParser.BELIEFRULES, 0); }
		public List<TerminalNode> BELIEF_BLOCK() { return getTokens(EASSParser.BELIEF_BLOCK); }
		public TerminalNode BELIEF_BLOCK(int i) {
			return getToken(EASSParser.BELIEF_BLOCK, i);
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
		public TerminalNode GWENDOLEN() { return getToken(EASSParser.GWENDOLEN, 0); }
		public List<TerminalNode> RR_NEWLINE() { return getTokens(EASSParser.RR_NEWLINE); }
		public TerminalNode RR_NEWLINE(int i) {
			return getToken(EASSParser.RR_NEWLINE, i);
		}
		public List<TerminalNode> RR_BLOCK() { return getTokens(EASSParser.RR_BLOCK); }
		public TerminalNode RR_BLOCK(int i) {
			return getToken(EASSParser.RR_BLOCK, i);
		}
		public GwendolenagentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gwendolenagent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitGwendolenagent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GwendolenagentContext gwendolenagent() throws RecognitionException {
		GwendolenagentContext _localctx = new GwendolenagentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_gwendolenagent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GWENDOLEN) {
				{
				setState(105);
				match(GWENDOLEN);
				}
			}

			}
			setState(108);
			_la = _input.LA(1);
			if ( !(_la==NAME || _la==NAME_PM) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(109);
			((GwendolenagentContext)_localctx).w = match(CONST);
			setState(110);
			match(BELIEFS);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BELIEF_BLOCK) {
				{
				{
				setState(111);
				((GwendolenagentContext)_localctx).bs = match(BELIEF_BLOCK);
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BELIEFRULES) {
				{
				setState(117);
				match(BELIEFRULES);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_NEWLINE) {
					{
					{
					setState(118);
					match(RR_NEWLINE);
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RR_BLOCK) {
					{
					{
					setState(124);
					((GwendolenagentContext)_localctx).rr = match(RR_BLOCK);
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(132);
			_la = _input.LA(1);
			if ( !(_la==GOAL_IB || _la==GOAL_RR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GOAL_BLOCK) {
				{
				{
				setState(133);
				((GwendolenagentContext)_localctx).gs = initial_goal();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139);
			match(PLANS);
			setState(141); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(140);
				((GwendolenagentContext)_localctx).p = plan();
				}
				}
				setState(143); 
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
		public TerminalNode GL_SQOPEN() { return getToken(EASSParser.GL_SQOPEN, 0); }
		public TerminalNode GL_SQCLOSE() { return getToken(EASSParser.GL_SQCLOSE, 0); }
		public TerminalNode GOAL_BLOCK() { return getToken(EASSParser.GOAL_BLOCK, 0); }
		public TerminalNode GL_ACHIEVEGOAL() { return getToken(EASSParser.GL_ACHIEVEGOAL, 0); }
		public TerminalNode GL_PERFORMGOAL() { return getToken(EASSParser.GL_PERFORMGOAL, 0); }
		public Initial_goalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial_goal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitInitial_goal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Initial_goalContext initial_goal() throws RecognitionException {
		Initial_goalContext _localctx = new Initial_goalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_initial_goal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			((Initial_goalContext)_localctx).g = match(GOAL_BLOCK);
			setState(146);
			match(GL_SQOPEN);
			setState(147);
			_la = _input.LA(1);
			if ( !(_la==GL_ACHIEVEGOAL || _la==GL_PERFORMGOAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(148);
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
		public TerminalNode COLON() { return getToken(EASSParser.COLON, 0); }
		public TerminalNode CURLYOPEN() { return getToken(EASSParser.CURLYOPEN, 0); }
		public TerminalNode CURLYCLOSE() { return getToken(EASSParser.CURLYCLOSE, 0); }
		public TerminalNode SEMI() { return getToken(EASSParser.SEMI, 0); }
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public List<Guard_atomContext> guard_atom() {
			return getRuleContexts(Guard_atomContext.class);
		}
		public Guard_atomContext guard_atom(int i) {
			return getRuleContext(Guard_atomContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EASSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EASSParser.COMMA, i);
		}
		public TerminalNode RULEARROW() { return getToken(EASSParser.RULEARROW, 0); }
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
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitPlan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlanContext plan() throws RecognitionException {
		PlanContext _localctx = new PlanContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_plan);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			((PlanContext)_localctx).e = event();
			setState(151);
			match(COLON);
			setState(152);
			match(CURLYOPEN);
			setState(153);
			((PlanContext)_localctx).gb = guard_atom();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(154);
				match(COMMA);
				setState(155);
				((PlanContext)_localctx).gb = guard_atom();
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
			match(CURLYCLOSE);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULEARROW) {
				{
				setState(162);
				match(RULEARROW);
				setState(163);
				((PlanContext)_localctx).d = deed();
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(164);
					match(COMMA);
					setState(165);
					((PlanContext)_localctx).d = deed();
					}
					}
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(173);
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
		public TerminalNode TRUE() { return getToken(EASSParser.TRUE, 0); }
		public TerminalNode BELIEVE() { return getToken(EASSParser.BELIEVE, 0); }
		public TerminalNode GOAL() { return getToken(EASSParser.GOAL, 0); }
		public TerminalNode SENT() { return getToken(EASSParser.SENT, 0); }
		public TerminalNode OPEN() { return getToken(EASSParser.OPEN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EASSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EASSParser.COMMA, i);
		}
		public TerminalNode CLOSE() { return getToken(EASSParser.CLOSE, 0); }
		public TerminalNode NOT() { return getToken(EASSParser.NOT, 0); }
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
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitGuard_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Guard_atomContext guard_atom() throws RecognitionException {
		Guard_atomContext _localctx = new Guard_atomContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_guard_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
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
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(175);
					match(NOT);
					}
				}

				setState(197);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BELIEVE:
					{
					setState(178);
					match(BELIEVE);
					setState(179);
					((Guard_atomContext)_localctx).l = fof_expr();
					}
					break;
				case GOAL:
					{
					setState(180);
					match(GOAL);
					setState(181);
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
					setState(182);
					((Guard_atomContext)_localctx).eq = fof_expr();
					}
					break;
				case SENT:
					{
					setState(183);
					match(SENT);
					setState(184);
					match(OPEN);
					{
					setState(185);
					((Guard_atomContext)_localctx).s = agentnameterm();
					}
					setState(186);
					match(COMMA);
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PL_CONST || _la==PL_VAR) {
						{
						setState(187);
						((Guard_atomContext)_localctx).an2 = agentnameterm();
						setState(188);
						match(COMMA);
						}
					}

					setState(192);
					((Guard_atomContext)_localctx).p = performative();
					setState(193);
					match(COMMA);
					setState(194);
					((Guard_atomContext)_localctx).t = fof_expr();
					setState(195);
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
				setState(199);
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
		public TerminalNode PLUS() { return getToken(EASSParser.PLUS, 0); }
		public TerminalNode RECEIVED() { return getToken(EASSParser.RECEIVED, 0); }
		public TerminalNode OPEN() { return getToken(EASSParser.OPEN, 0); }
		public TerminalNode COMMA() { return getToken(EASSParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(EASSParser.CLOSE, 0); }
		public PerformativeContext performative() {
			return getRuleContext(PerformativeContext.class,0);
		}
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode SHRIEK() { return getToken(EASSParser.SHRIEK, 0); }
		public GoalContext goal() {
			return getRuleContext(GoalContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(EASSParser.MINUS, 0); }
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_event);
		try {
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(202);
				match(PLUS);
				setState(215);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RECEIVED:
					{
					setState(203);
					match(RECEIVED);
					setState(204);
					match(OPEN);
					setState(205);
					((EventContext)_localctx).p = performative();
					setState(206);
					match(COMMA);
					setState(207);
					((EventContext)_localctx).t = fof_expr();
					setState(208);
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
					setState(213);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PL_SQOPEN:
					case OPEN:
					case MINUS:
					case PL_CONST:
					case PL_VAR:
					case NUMBER:
						{
						setState(210);
						((EventContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(211);
						match(SHRIEK);
						setState(212);
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
				setState(217);
				match(MINUS);
				setState(221);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PL_SQOPEN:
				case OPEN:
				case MINUS:
				case PL_CONST:
				case PL_VAR:
				case NUMBER:
					{
					setState(218);
					((EventContext)_localctx).l = fof_expr();
					}
					break;
				case SHRIEK:
					{
					setState(219);
					match(SHRIEK);
					setState(220);
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
		public TerminalNode TELL() { return getToken(EASSParser.TELL, 0); }
		public TerminalNode COLON() { return getToken(EASSParser.COLON, 0); }
		public TerminalNode PL_PERFORMGOAL() { return getToken(EASSParser.PL_PERFORMGOAL, 0); }
		public TerminalNode PL_ACHIEVEGOAL() { return getToken(EASSParser.PL_ACHIEVEGOAL, 0); }
		public PerformativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_performative; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitPerformative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PerformativeContext performative() throws RecognitionException {
		PerformativeContext _localctx = new PerformativeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_performative);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(225);
				match(TELL);
				}
				break;
			case 2:
				{
				setState(226);
				match(COLON);
				setState(227);
				match(PL_PERFORMGOAL);
				}
				break;
			case 3:
				{
				setState(228);
				match(COLON);
				setState(229);
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
		public TerminalNode PLUS() { return getToken(EASSParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(EASSParser.MINUS, 0); }
		public TerminalNode SHRIEK() { return getToken(EASSParser.SHRIEK, 0); }
		public TerminalNode LOCK() { return getToken(EASSParser.LOCK, 0); }
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
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitDeed(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeedContext deed() throws RecognitionException {
		DeedContext _localctx = new DeedContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_deed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(246);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					{
					setState(232);
					match(PLUS);
					setState(237);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PL_SQOPEN:
					case OPEN:
					case MINUS:
					case PL_CONST:
					case PL_VAR:
					case NUMBER:
						{
						setState(233);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(234);
						match(SHRIEK);
						setState(235);
						((DeedContext)_localctx).g = goal();
						}
						break;
					case LOCK:
						{
						setState(236);
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
					setState(239);
					match(MINUS);
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
						setState(240);
						((DeedContext)_localctx).l = fof_expr();
						}
						break;
					case SHRIEK:
						{
						setState(241);
						match(SHRIEK);
						setState(242);
						((DeedContext)_localctx).g = goal();
						}
						break;
					case LOCK:
						{
						setState(243);
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
				setState(248);
				((DeedContext)_localctx).a = action();
				}
				break;
			case 3:
				{
				setState(249);
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
		public TerminalNode PL_SQOPEN() { return getToken(EASSParser.PL_SQOPEN, 0); }
		public TerminalNode PL_SQCLOSE() { return getToken(EASSParser.PL_SQCLOSE, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode PL_ACHIEVEGOAL() { return getToken(EASSParser.PL_ACHIEVEGOAL, 0); }
		public TerminalNode PL_PERFORMGOAL() { return getToken(EASSParser.PL_PERFORMGOAL, 0); }
		public GoalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitGoal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GoalContext goal() throws RecognitionException {
		GoalContext _localctx = new GoalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_goal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			((GoalContext)_localctx).g = fof_expr();
			setState(253);
			match(PL_SQOPEN);
			setState(254);
			_la = _input.LA(1);
			if ( !(_la==PL_ACHIEVEGOAL || _la==PL_PERFORMGOAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(255);
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
		public TerminalNode MULT() { return getToken(EASSParser.MULT, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(EASSParser.NOT, 0); }
		public WaitforContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_waitfor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitWaitfor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WaitforContext waitfor() throws RecognitionException {
		WaitforContext _localctx = new WaitforContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_waitfor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(MULT);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(258);
				match(NOT);
				}
			}

			setState(261);
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
		public TerminalNode SEND() { return getToken(EASSParser.SEND, 0); }
		public TerminalNode OPEN() { return getToken(EASSParser.OPEN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EASSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EASSParser.COMMA, i);
		}
		public TerminalNode CLOSE() { return getToken(EASSParser.CLOSE, 0); }
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
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_action);
		try {
			setState(273);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEND:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(263);
				match(SEND);
				setState(264);
				match(OPEN);
				setState(265);
				((ActionContext)_localctx).an = fof_expr();
				setState(266);
				match(COMMA);
				setState(267);
				((ActionContext)_localctx).p = performative();
				setState(268);
				match(COMMA);
				setState(269);
				((ActionContext)_localctx).t = fof_expr();
				setState(270);
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
				setState(272);
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
		public List<TerminalNode> NUMBER() { return getTokens(EASSParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(EASSParser.NUMBER, i);
		}
		public List<TerminalNode> PL_VAR() { return getTokens(EASSParser.PL_VAR); }
		public TerminalNode PL_VAR(int i) {
			return getToken(EASSParser.PL_VAR, i);
		}
		public OperContext oper() {
			return getRuleContext(OperContext.class,0);
		}
		public List<TerminalNode> MINUS() { return getTokens(EASSParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(EASSParser.MINUS, i);
		}
		public List<Const_varContext> const_var() {
			return getRuleContexts(Const_varContext.class);
		}
		public Const_varContext const_var(int i) {
			return getRuleContext(Const_varContext.class,i);
		}
		public TerminalNode PL_SQOPEN() { return getToken(EASSParser.PL_SQOPEN, 0); }
		public TerminalNode PL_SQCLOSE() { return getToken(EASSParser.PL_SQCLOSE, 0); }
		public TerminalNode OPEN() { return getToken(EASSParser.OPEN, 0); }
		public List<Fof_exprContext> fof_expr() {
			return getRuleContexts(Fof_exprContext.class);
		}
		public Fof_exprContext fof_expr(int i) {
			return getRuleContext(Fof_exprContext.class,i);
		}
		public TerminalNode CLOSE() { return getToken(EASSParser.CLOSE, 0); }
		public List<TerminalNode> IDPUNCT() { return getTokens(EASSParser.IDPUNCT); }
		public TerminalNode IDPUNCT(int i) {
			return getToken(EASSParser.IDPUNCT, i);
		}
		public List<TerminalNode> QUOTED_STRING() { return getTokens(EASSParser.QUOTED_STRING); }
		public TerminalNode QUOTED_STRING(int i) {
			return getToken(EASSParser.QUOTED_STRING, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EASSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EASSParser.COMMA, i);
		}
		public TerminalNode PL_BAR() { return getToken(EASSParser.PL_BAR, 0); }
		public Fof_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fof_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitFof_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fof_exprContext fof_expr() throws RecognitionException {
		Fof_exprContext _localctx = new Fof_exprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fof_expr);
		int _la;
		try {
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MINUS:
				case NUMBER:
					{
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==MINUS) {
						{
						setState(275);
						match(MINUS);
						}
					}

					setState(278);
					match(NUMBER);
					}
					break;
				case PL_VAR:
					{
					setState(279);
					match(PL_VAR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 15L) != 0)) {
					{
					setState(282);
					oper();
					setState(288);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case MINUS:
					case NUMBER:
						{
						setState(284);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MINUS) {
							{
							setState(283);
							match(MINUS);
							}
						}

						setState(286);
						match(NUMBER);
						}
						break;
					case PL_VAR:
						{
						setState(287);
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
				setState(338);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PL_CONST:
				case PL_VAR:
					{
					setState(292);
					const_var();
					setState(297);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==IDPUNCT) {
						{
						{
						setState(293);
						match(IDPUNCT);
						setState(294);
						const_var();
						}
						}
						setState(299);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(316);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==OPEN) {
						{
						setState(300);
						match(OPEN);
						setState(303);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case PL_SQOPEN:
						case OPEN:
						case MINUS:
						case PL_CONST:
						case PL_VAR:
						case NUMBER:
							{
							setState(301);
							fof_expr();
							}
							break;
						case QUOTED_STRING:
							{
							setState(302);
							match(QUOTED_STRING);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(312);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(305);
							match(COMMA);
							setState(308);
							_errHandler.sync(this);
							switch (_input.LA(1)) {
							case PL_SQOPEN:
							case OPEN:
							case MINUS:
							case PL_CONST:
							case PL_VAR:
							case NUMBER:
								{
								setState(306);
								fof_expr();
								}
								break;
							case QUOTED_STRING:
								{
								setState(307);
								match(QUOTED_STRING);
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							}
							}
							setState(314);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(315);
						match(CLOSE);
						}
					}

					}
					break;
				case PL_SQOPEN:
					{
					setState(318);
					match(PL_SQOPEN);
					setState(331);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 55)) & ~0x3f) == 0 && ((1L << (_la - 55)) & 14714881L) != 0)) {
						{
						setState(319);
						fof_expr();
						setState(324);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(320);
							match(COMMA);
							setState(321);
							fof_expr();
							}
							}
							setState(326);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(329);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==PL_BAR) {
							{
							setState(327);
							match(PL_BAR);
							setState(328);
							match(PL_VAR);
							}
						}

						}
					}

					setState(333);
					match(PL_SQCLOSE);
					}
					break;
				case OPEN:
					{
					setState(334);
					match(OPEN);
					setState(335);
					fof_expr();
					setState(336);
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
		public TerminalNode PL_CONST() { return getToken(EASSParser.PL_CONST, 0); }
		public TerminalNode PL_VAR() { return getToken(EASSParser.PL_VAR, 0); }
		public Const_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitConst_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_varContext const_var() throws RecognitionException {
		Const_varContext _localctx = new Const_varContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_const_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
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
		public TerminalNode EQUAL() { return getToken(EASSParser.EQUAL, 0); }
		public TerminalNode LESS() { return getToken(EASSParser.LESS, 0); }
		public TerminalNode PLUS() { return getToken(EASSParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(EASSParser.MINUS, 0); }
		public OperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitOper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperContext oper() throws RecognitionException {
		OperContext _localctx = new OperContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_la = _input.LA(1);
			if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 15L) != 0)) ) {
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
		public TerminalNode PL_CONST() { return getToken(EASSParser.PL_CONST, 0); }
		public TerminalNode PL_VAR() { return getToken(EASSParser.PL_VAR, 0); }
		public AgentnametermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentnameterm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EASSVisitor ) return ((EASSVisitor<? extends T>)visitor).visitAgentnameterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgentnametermContext agentnameterm() throws RecognitionException {
		AgentnametermContext _localctx = new AgentnametermContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_agentnameterm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
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
		"\u0004\u0001O\u015d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0004\u0001)\b\u0001\u000b\u0001\f\u0001*\u0001"+
		"\u0002\u0003\u0002.\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u00024\b\u0002\n\u0002\f\u00027\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002;\b\u0002\n\u0002\f\u0002>\t\u0002\u0001\u0002\u0005"+
		"\u0002A\b\u0002\n\u0002\f\u0002D\t\u0002\u0003\u0002F\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002J\b\u0002\n\u0002\f\u0002M\t\u0002\u0001\u0002"+
		"\u0005\u0002P\b\u0002\n\u0002\f\u0002S\t\u0002\u0003\u0002U\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002Y\b\u0002\n\u0002\f\u0002\\\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0004\u0002`\b\u0002\u000b\u0002\f\u0002a\u0001\u0003"+
		"\u0001\u0003\u0004\u0003f\b\u0003\u000b\u0003\f\u0003g\u0001\u0004\u0003"+
		"\u0004k\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004q\b\u0004\n\u0004\f\u0004t\t\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004x\b\u0004\n\u0004\f\u0004{\t\u0004\u0001\u0004\u0005\u0004~\b\u0004"+
		"\n\u0004\f\u0004\u0081\t\u0004\u0003\u0004\u0083\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u0087\b\u0004\n\u0004\f\u0004\u008a\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0004\u0004\u008e\b\u0004\u000b\u0004\f\u0004\u008f\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u009d"+
		"\b\u0006\n\u0006\f\u0006\u00a0\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006\u00a7\b\u0006\n\u0006\f\u0006\u00aa"+
		"\t\u0006\u0003\u0006\u00ac\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0003\u0007\u00b1\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u00bf\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00c6\b\u0007\u0001\u0007"+
		"\u0003\u0007\u00c9\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00d6\b\b\u0003\b\u00d8"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00de\b\b\u0003\b\u00e0\b"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00e7\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u00ee\b\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u00f5\b\n\u0003\n\u00f7\b\n\u0001\n\u0001\n\u0003\n"+
		"\u00fb\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0003\f\u0104\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0112"+
		"\b\r\u0001\u000e\u0003\u000e\u0115\b\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0119\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u011d\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u0121\b\u000e\u0003\u000e\u0123\b"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0128\b\u000e\n"+
		"\u000e\f\u000e\u012b\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0130\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0135"+
		"\b\u000e\u0005\u000e\u0137\b\u000e\n\u000e\f\u000e\u013a\t\u000e\u0001"+
		"\u000e\u0003\u000e\u013d\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u0143\b\u000e\n\u000e\f\u000e\u0146\t\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u014a\b\u000e\u0003\u000e\u014c\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0153"+
		"\b\u000e\u0003\u000e\u0155\b\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"\u0000\t\u0003\u0000\u0002\u0002\u0004\u0004**\u0002\u0000\r"+
		"\r\u0014\u0014\u0003\u0000\f\f\u0013\u0013\u001a\u001a\u0002\u0000\u0004"+
		"\u0004**\u0002\u0000\f\f\u0013\u0013\u0001\u0000%&\u0001\u000056\u0001"+
		"\u0000LM\u0001\u0000EH\u0185\u0000$\u0001\u0000\u0000\u0000\u0002&\u0001"+
		"\u0000\u0000\u0000\u0004-\u0001\u0000\u0000\u0000\u0006c\u0001\u0000\u0000"+
		"\u0000\bj\u0001\u0000\u0000\u0000\n\u0091\u0001\u0000\u0000\u0000\f\u0096"+
		"\u0001\u0000\u0000\u0000\u000e\u00c8\u0001\u0000\u0000\u0000\u0010\u00df"+
		"\u0001\u0000\u0000\u0000\u0012\u00e6\u0001\u0000\u0000\u0000\u0014\u00fa"+
		"\u0001\u0000\u0000\u0000\u0016\u00fc\u0001\u0000\u0000\u0000\u0018\u0101"+
		"\u0001\u0000\u0000\u0000\u001a\u0111\u0001\u0000\u0000\u0000\u001c\u0154"+
		"\u0001\u0000\u0000\u0000\u001e\u0156\u0001\u0000\u0000\u0000 \u0158\u0001"+
		"\u0000\u0000\u0000\"\u015a\u0001\u0000\u0000\u0000$%\u0003\u0002\u0001"+
		"\u0000%\u0001\u0001\u0000\u0000\u0000&(\u0005\u0001\u0000\u0000\')\u0003"+
		"\u0004\u0002\u0000(\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000"+
		"*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+\u0003\u0001\u0000"+
		"\u0000\u0000,.\u0005\u0001\u0000\u0000-,\u0001\u0000\u0000\u0000-.\u0001"+
		"\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/0\u0007\u0000\u0000\u0000"+
		"01\u0005\u0005\u0000\u000015\u0005\n\u0000\u000024\u0005\u0012\u0000\u0000"+
		"32\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u000056\u0001\u0000\u0000\u00006E\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u00008<\u0005\u000b\u0000\u00009;\u0005\u0017\u0000\u0000:9\u0001"+
		"\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=B\u0001\u0000\u0000\u0000><\u0001\u0000\u0000"+
		"\u0000?A\u0005\u0019\u0000\u0000@?\u0001\u0000\u0000\u0000AD\u0001\u0000"+
		"\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CF\u0001"+
		"\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000E8\u0001\u0000\u0000\u0000"+
		"EF\u0001\u0000\u0000\u0000FT\u0001\u0000\u0000\u0000GK\u0007\u0001\u0000"+
		"\u0000HJ\u0005\u001d\u0000\u0000IH\u0001\u0000\u0000\u0000JM\u0001\u0000"+
		"\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LQ\u0001"+
		"\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NP\u0005\u001f\u0000\u0000"+
		"ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000"+
		"\u0000QR\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000TG\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0001"+
		"\u0000\u0000\u0000VZ\u0007\u0002\u0000\u0000WY\u0003\n\u0005\u0000XW\u0001"+
		"\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000"+
		"Z[\u0001\u0000\u0000\u0000[]\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000"+
		"\u0000]_\u0005 \u0000\u0000^`\u0003\f\u0006\u0000_^\u0001\u0000\u0000"+
		"\u0000`a\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000"+
		"\u0000\u0000b\u0005\u0001\u0000\u0000\u0000ce\u0005\u0003\u0000\u0000"+
		"df\u0003\b\u0004\u0000ed\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000"+
		"ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\u0007\u0001\u0000"+
		"\u0000\u0000ik\u0005\u0003\u0000\u0000ji\u0001\u0000\u0000\u0000jk\u0001"+
		"\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0007\u0003\u0000\u0000"+
		"mn\u0005\u0005\u0000\u0000nr\u0005\n\u0000\u0000oq\u0005\u0012\u0000\u0000"+
		"po\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000"+
		"\u0000rs\u0001\u0000\u0000\u0000s\u0082\u0001\u0000\u0000\u0000tr\u0001"+
		"\u0000\u0000\u0000uy\u0005\u000b\u0000\u0000vx\u0005\u0017\u0000\u0000"+
		"wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000z\u007f\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000|~\u0005\u0019\u0000\u0000}|\u0001\u0000\u0000\u0000"+
		"~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u007f"+
		"\u0001\u0000\u0000\u0000\u0082u\u0001\u0000\u0000\u0000\u0082\u0083\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0088\u0007"+
		"\u0004\u0000\u0000\u0085\u0087\u0003\n\u0005\u0000\u0086\u0085\u0001\u0000"+
		"\u0000\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008b\u0001\u0000"+
		"\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b\u008d\u0005 \u0000"+
		"\u0000\u008c\u008e\u0003\f\u0006\u0000\u008d\u008c\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0001\u0000\u0000\u0000\u0090\t\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0005)\u0000\u0000\u0092\u0093\u0005\'\u0000\u0000\u0093\u0094"+
		"\u0007\u0005\u0000\u0000\u0094\u0095\u0005(\u0000\u0000\u0095\u000b\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0003\u0010\b\u0000\u0097\u0098\u0005;"+
		"\u0000\u0000\u0098\u0099\u0005<\u0000\u0000\u0099\u009e\u0003\u000e\u0007"+
		"\u0000\u009a\u009b\u0005>\u0000\u0000\u009b\u009d\u0003\u000e\u0007\u0000"+
		"\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000"+
		"\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000"+
		"\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000"+
		"\u00a1\u00ab\u0005=\u0000\u0000\u00a2\u00a3\u0005J\u0000\u0000\u00a3\u00a8"+
		"\u0003\u0014\n\u0000\u00a4\u00a5\u0005>\u0000\u0000\u00a5\u00a7\u0003"+
		"\u0014\n\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000"+
		"\u0000\u0000\u00ab\u00a2\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005?\u0000"+
		"\u0000\u00ae\r\u0001\u0000\u0000\u0000\u00af\u00b1\u0005:\u0000\u0000"+
		"\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u00c5\u0001\u0000\u0000\u0000\u00b2\u00b3\u00051\u0000\u0000\u00b3"+
		"\u00c6\u0003\u001c\u000e\u0000\u00b4\u00b5\u00052\u0000\u0000\u00b5\u00c6"+
		"\u0003\u0016\u000b\u0000\u00b6\u00c6\u0003\u001c\u000e\u0000\u00b7\u00b8"+
		"\u00053\u0000\u0000\u00b8\u00b9\u0005B\u0000\u0000\u00b9\u00ba\u0003\""+
		"\u0011\u0000\u00ba\u00be\u0005>\u0000\u0000\u00bb\u00bc\u0003\"\u0011"+
		"\u0000\u00bc\u00bd\u0005>\u0000\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000"+
		"\u00be\u00bb\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0003\u0012\t\u0000\u00c1"+
		"\u00c2\u0005>\u0000\u0000\u00c2\u00c3\u0003\u001c\u000e\u0000\u00c3\u00c4"+
		"\u0005C\u0000\u0000\u00c4\u00c6\u0001\u0000\u0000\u0000\u00c5\u00b2\u0001"+
		"\u0000\u0000\u0000\u00c5\u00b4\u0001\u0000\u0000\u0000\u00c5\u00b6\u0001"+
		"\u0000\u0000\u0000\u00c5\u00b7\u0001\u0000\u0000\u0000\u00c6\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c9\u0005K\u0000\u0000\u00c8\u00b0\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u000f\u0001\u0000"+
		"\u0000\u0000\u00ca\u00d7\u0005E\u0000\u0000\u00cb\u00cc\u00050\u0000\u0000"+
		"\u00cc\u00cd\u0005B\u0000\u0000\u00cd\u00ce\u0003\u0012\t\u0000\u00ce"+
		"\u00cf\u0005>\u0000\u0000\u00cf\u00d0\u0003\u001c\u000e\u0000\u00d0\u00d1"+
		"\u0005C\u0000\u0000\u00d1\u00d8\u0001\u0000\u0000\u0000\u00d2\u00d6\u0003"+
		"\u001c\u000e\u0000\u00d3\u00d4\u0005A\u0000\u0000\u00d4\u00d6\u0003\u0016"+
		"\u000b\u0000\u00d5\u00d2\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7\u00cb\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d8\u00e0\u0001\u0000"+
		"\u0000\u0000\u00d9\u00dd\u0005F\u0000\u0000\u00da\u00de\u0003\u001c\u000e"+
		"\u0000\u00db\u00dc\u0005A\u0000\u0000\u00dc\u00de\u0003\u0016\u000b\u0000"+
		"\u00dd\u00da\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000"+
		"\u00de\u00e0\u0001\u0000\u0000\u0000\u00df\u00ca\u0001\u0000\u0000\u0000"+
		"\u00df\u00d9\u0001\u0000\u0000\u0000\u00e0\u0011\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e7\u0005@\u0000\u0000\u00e2\u00e3\u0005;\u0000\u0000\u00e3\u00e7"+
		"\u00056\u0000\u0000\u00e4\u00e5\u0005;\u0000\u0000\u00e5\u00e7\u00055"+
		"\u0000\u0000\u00e6\u00e1\u0001\u0000\u0000\u0000\u00e6\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e7\u0013\u0001\u0000"+
		"\u0000\u0000\u00e8\u00ed\u0005E\u0000\u0000\u00e9\u00ee\u0003\u001c\u000e"+
		"\u0000\u00ea\u00eb\u0005A\u0000\u0000\u00eb\u00ee\u0003\u0016\u000b\u0000"+
		"\u00ec\u00ee\u00054\u0000\u0000\u00ed\u00e9\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000\u00ee"+
		"\u00f7\u0001\u0000\u0000\u0000\u00ef\u00f4\u0005F\u0000\u0000\u00f0\u00f5"+
		"\u0003\u001c\u000e\u0000\u00f1\u00f2\u0005A\u0000\u0000\u00f2\u00f5\u0003"+
		"\u0016\u000b\u0000\u00f3\u00f5\u00054\u0000\u0000\u00f4\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00e8\u0001\u0000"+
		"\u0000\u0000\u00f6\u00ef\u0001\u0000\u0000\u0000\u00f7\u00fb\u0001\u0000"+
		"\u0000\u0000\u00f8\u00fb\u0003\u001a\r\u0000\u00f9\u00fb\u0003\u0018\f"+
		"\u0000\u00fa\u00f6\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000"+
		"\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fb\u0015\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\u0003\u001c\u000e\u0000\u00fd\u00fe\u00057\u0000\u0000"+
		"\u00fe\u00ff\u0007\u0006\u0000\u0000\u00ff\u0100\u00058\u0000\u0000\u0100"+
		"\u0017\u0001\u0000\u0000\u0000\u0101\u0103\u0005D\u0000\u0000\u0102\u0104"+
		"\u0005:\u0000\u0000\u0103\u0102\u0001\u0000\u0000\u0000\u0103\u0104\u0001"+
		"\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0106\u0003"+
		"\u001c\u000e\u0000\u0106\u0019\u0001\u0000\u0000\u0000\u0107\u0108\u0005"+
		"/\u0000\u0000\u0108\u0109\u0005B\u0000\u0000\u0109\u010a\u0003\u001c\u000e"+
		"\u0000\u010a\u010b\u0005>\u0000\u0000\u010b\u010c\u0003\u0012\t\u0000"+
		"\u010c\u010d\u0005>\u0000\u0000\u010d\u010e\u0003\u001c\u000e\u0000\u010e"+
		"\u010f\u0005C\u0000\u0000\u010f\u0112\u0001\u0000\u0000\u0000\u0110\u0112"+
		"\u0003\u001c\u000e\u0000\u0111\u0107\u0001\u0000\u0000\u0000\u0111\u0110"+
		"\u0001\u0000\u0000\u0000\u0112\u001b\u0001\u0000\u0000\u0000\u0113\u0115"+
		"\u0005F\u0000\u0000\u0114\u0113\u0001\u0000\u0000\u0000\u0114\u0115\u0001"+
		"\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0119\u0005"+
		"N\u0000\u0000\u0117\u0119\u0005M\u0000\u0000\u0118\u0114\u0001\u0000\u0000"+
		"\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0119\u0122\u0001\u0000\u0000"+
		"\u0000\u011a\u0120\u0003 \u0010\u0000\u011b\u011d\u0005F\u0000\u0000\u011c"+
		"\u011b\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d"+
		"\u011e\u0001\u0000\u0000\u0000\u011e\u0121\u0005N\u0000\u0000\u011f\u0121"+
		"\u0005M\u0000\u0000\u0120\u011c\u0001\u0000\u0000\u0000\u0120\u011f\u0001"+
		"\u0000\u0000\u0000\u0121\u0123\u0001\u0000\u0000\u0000\u0122\u011a\u0001"+
		"\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0155\u0001"+
		"\u0000\u0000\u0000\u0124\u0129\u0003\u001e\u000f\u0000\u0125\u0126\u0005"+
		"I\u0000\u0000\u0126\u0128\u0003\u001e\u000f\u0000\u0127\u0125\u0001\u0000"+
		"\u0000\u0000\u0128\u012b\u0001\u0000\u0000\u0000\u0129\u0127\u0001\u0000"+
		"\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u013c\u0001\u0000"+
		"\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012c\u012f\u0005B\u0000"+
		"\u0000\u012d\u0130\u0003\u001c\u000e\u0000\u012e\u0130\u0005O\u0000\u0000"+
		"\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u012e\u0001\u0000\u0000\u0000"+
		"\u0130\u0138\u0001\u0000\u0000\u0000\u0131\u0134\u0005>\u0000\u0000\u0132"+
		"\u0135\u0003\u001c\u000e\u0000\u0133\u0135\u0005O\u0000\u0000\u0134\u0132"+
		"\u0001\u0000\u0000\u0000\u0134\u0133\u0001\u0000\u0000\u0000\u0135\u0137"+
		"\u0001\u0000\u0000\u0000\u0136\u0131\u0001\u0000\u0000\u0000\u0137\u013a"+
		"\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139"+
		"\u0001\u0000\u0000\u0000\u0139\u013b\u0001\u0000\u0000\u0000\u013a\u0138"+
		"\u0001\u0000\u0000\u0000\u013b\u013d\u0005C\u0000\u0000\u013c\u012c\u0001"+
		"\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u0153\u0001"+
		"\u0000\u0000\u0000\u013e\u014b\u00057\u0000\u0000\u013f\u0144\u0003\u001c"+
		"\u000e\u0000\u0140\u0141\u0005>\u0000\u0000\u0141\u0143\u0003\u001c\u000e"+
		"\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0143\u0146\u0001\u0000\u0000"+
		"\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000"+
		"\u0000\u0145\u0149\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000"+
		"\u0000\u0147\u0148\u00059\u0000\u0000\u0148\u014a\u0005M\u0000\u0000\u0149"+
		"\u0147\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a"+
		"\u014c\u0001\u0000\u0000\u0000\u014b\u013f\u0001\u0000\u0000\u0000\u014b"+
		"\u014c\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d"+
		"\u0153\u00058\u0000\u0000\u014e\u014f\u0005B\u0000\u0000\u014f\u0150\u0003"+
		"\u001c\u000e\u0000\u0150\u0151\u0005C\u0000\u0000\u0151\u0153\u0001\u0000"+
		"\u0000\u0000\u0152\u0124\u0001\u0000\u0000\u0000\u0152\u013e\u0001\u0000"+
		"\u0000\u0000\u0152\u014e\u0001\u0000\u0000\u0000\u0153\u0155\u0001\u0000"+
		"\u0000\u0000\u0154\u0118\u0001\u0000\u0000\u0000\u0154\u0152\u0001\u0000"+
		"\u0000\u0000\u0155\u001d\u0001\u0000\u0000\u0000\u0156\u0157\u0007\u0007"+
		"\u0000\u0000\u0157\u001f\u0001\u0000\u0000\u0000\u0158\u0159\u0007\b\u0000"+
		"\u0000\u0159!\u0001\u0000\u0000\u0000\u015a\u015b\u0007\u0007\u0000\u0000"+
		"\u015b#\u0001\u0000\u0000\u00004*-5<BEKQTZagjry\u007f\u0082\u0088\u008f"+
		"\u009e\u00a8\u00ab\u00b0\u00be\u00c5\u00c8\u00d5\u00d7\u00dd\u00df\u00e6"+
		"\u00ed\u00f4\u00f6\u00fa\u0103\u0111\u0114\u0118\u011c\u0120\u0122\u0129"+
		"\u012f\u0134\u0138\u013c\u0144\u0149\u014b\u0152\u0154";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}