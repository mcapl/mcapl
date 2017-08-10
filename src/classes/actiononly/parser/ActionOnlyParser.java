// Generated from ActionOnly.g4 by ANTLR 4.4
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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ACTIONONLY=1, BELIEFS=2, BELIEFRULES=3, GOAL=4, NAME=5, BELIEVE=6, BRULEARROW=7, 
		ACTIONS=8, COMMENT=9, LINE_COMMENT=10, NEWLINE=11, WS=12, OPEN=13, CLOSE=14, 
		SQOPEN=15, SQCLOSE=16, CURLYOPEN=17, CURLYCLOSE=18, QUOTED_STRING=19, 
		NOT=20, TRUE=21, CONST=22, VAR=23, NUMBER=24, LESS=25, EQ=26, POINT=27, 
		MULT=28, PLUS=29, MINUS=30, DIV=31, MOD=32, SHRIEK=33, COMMA=34, SEMI=35, 
		COLON=36, QUERY=37;
	public static final String[] tokenNames = {
		"<INVALID>", "ACTIONONLY", "':Initial Beliefs:'", "':Reasoning Rules:'", 
		"':Initial Goal:'", "':name:'", "BELIEVE", "':-'", "':Actions:'", "COMMENT", 
		"LINE_COMMENT", "NEWLINE", "WS", "'('", "')'", "'['", "']'", "'{'", "'}'", 
		"QUOTED_STRING", "'~'", "'True'", "CONST", "VAR", "NUMBER", "'<'", "'=='", 
		"'.'", "'*'", "'+'", "'-'", "'/'", "'%'", "'!'", "','", "';'", "':'", 
		"'?'"
	};
	public static final int
		RULE_mas = 0, RULE_aoagents = 1, RULE_aoagent = 2, RULE_guard_atom = 3, 
		RULE_brule = 4, RULE_capability = 5, RULE_logicalfmla = 6, RULE_notfmla = 7, 
		RULE_subfmla = 8, RULE_clogicalfmla = 9, RULE_cnotfmla = 10, RULE_csubfmla = 11, 
		RULE_environment = 12, RULE_classpath = 13, RULE_word = 14, RULE_agentnameterm = 15, 
		RULE_action = 16, RULE_literal = 17, RULE_pred = 18, RULE_function = 19, 
		RULE_terms = 20, RULE_term = 21, RULE_atom = 22, RULE_stringterm = 23, 
		RULE_var = 24, RULE_numberstring = 25, RULE_equation = 26, RULE_eqoper = 27, 
		RULE_arithexpr = 28, RULE_multexpr = 29, RULE_addoper = 30, RULE_multoper = 31;
	public static final String[] ruleNames = {
		"mas", "aoagents", "aoagent", "guard_atom", "brule", "capability", "logicalfmla", 
		"notfmla", "subfmla", "clogicalfmla", "cnotfmla", "csubfmla", "environment", 
		"classpath", "word", "agentnameterm", "action", "literal", "pred", "function", 
		"terms", "term", "atom", "stringterm", "var", "numberstring", "equation", 
		"eqoper", "arithexpr", "multexpr", "addoper", "multoper"
	};

	@Override
	public String getGrammarFileName() { return "ActionOnly.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
			setState(64); aoagents();
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
		public ArrayList<Abstract_ActionOnlyAgent> gags;
		public AoagentContext g;
		public AoagentContext aoagent(int i) {
			return getRuleContext(AoagentContext.class,i);
		}
		public TerminalNode ACTIONONLY() { return getToken(ActionOnlyParser.ACTIONONLY, 0); }
		public List<AoagentContext> aoagent() {
			return getRuleContexts(AoagentContext.class);
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
			setState(66); match(ACTIONONLY);
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67); ((AoagentsContext)_localctx).g = aoagent();
				gags.add(((AoagentsContext)_localctx).g.g);
				}
				}
				setState(72); 
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
		public Abstract_ActionOnlyAgent g;
		public WordContext w;
		public LiteralContext l;
		public BruleContext r;
		public CapabilityContext c;
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public List<BruleContext> brule() {
			return getRuleContexts(BruleContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public TerminalNode BELIEFS() { return getToken(ActionOnlyParser.BELIEFS, 0); }
		public List<CapabilityContext> capability() {
			return getRuleContexts(CapabilityContext.class);
		}
		public TerminalNode BELIEFRULES() { return getToken(ActionOnlyParser.BELIEFRULES, 0); }
		public TerminalNode NAME() { return getToken(ActionOnlyParser.NAME, 0); }
		public TerminalNode ACTIONONLY() { return getToken(ActionOnlyParser.ACTIONONLY, 0); }
		public BruleContext brule(int i) {
			return getRuleContext(BruleContext.class,i);
		}
		public TerminalNode ACTIONS() { return getToken(ActionOnlyParser.ACTIONS, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public TerminalNode GOAL() { return getToken(ActionOnlyParser.GOAL, 0); }
		public CapabilityContext capability(int i) {
			return getRuleContext(CapabilityContext.class,i);
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
			setState(75);
			_la = _input.LA(1);
			if (_la==ACTIONONLY) {
				{
				setState(74); match(ACTIONONLY);
				}
			}

			}
			setState(77); match(NAME);
			setState(78); ((AoagentContext)_localctx).w = word();
			try {((AoagentContext)_localctx).g =  new Abstract_ActionOnlyAgent(((AoagentContext)_localctx).w.s);} 
					catch (Exception e) {System.err.println(e); agentname = new Abstract_StringTermImpl(((AoagentContext)_localctx).w.s);}
			setState(80); match(BELIEFS);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << TRUE) | (1L << CONST) | (1L << VAR))) != 0)) {
				{
				{
				setState(81); ((AoagentContext)_localctx).l = literal();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			_la = _input.LA(1);
			if (_la==BELIEFRULES) {
				{
				setState(87); match(BELIEFRULES);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CONST || _la==VAR) {
					{
					{
					setState(88); ((AoagentContext)_localctx).r = brule();
					_localctx.g.addRule(((AoagentContext)_localctx).r.r);
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(98); match(GOAL);
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(99); ((AoagentContext)_localctx).l = literal();
				}
				}
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << TRUE) | (1L << CONST) | (1L << VAR))) != 0) );
			setState(104); match(ACTIONS);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CURLYOPEN) {
				{
				{
				setState(105); ((AoagentContext)_localctx).c = capability();
				_localctx.g.addCapability(((AoagentContext)_localctx).c.c);
				}
				}
				setState(112);
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
		public Abstract_GLogicalFormula g;
		public LiteralContext l;
		public EquationContext eq;
		public EquationContext equation() {
			return getRuleContext(EquationContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(ActionOnlyParser.TRUE, 0); }
		public TerminalNode BELIEVE() { return getToken(ActionOnlyParser.BELIEVE, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Guard_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitGuard_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Guard_atomContext guard_atom() throws RecognitionException {
		Guard_atomContext _localctx = new Guard_atomContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_guard_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			switch (_input.LA(1)) {
			case BELIEVE:
				{
				setState(113); match(BELIEVE);
				setState(114); ((Guard_atomContext)_localctx).l = literal();
				}
				break;
			case OPEN:
			case VAR:
			case NUMBER:
			case MINUS:
				{
				setState(115); ((Guard_atomContext)_localctx).eq = equation();
				}
				break;
			case TRUE:
				{
				setState(116); match(TRUE);
				((Guard_atomContext)_localctx).g =  new Abstract_GBelief();
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
		public Abstract_Rule r;
		public PredContext head;
		public LogicalfmlaContext f;
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ActionOnlyParser.SEMI, 0); }
		public LogicalfmlaContext logicalfmla() {
			return getRuleContext(LogicalfmlaContext.class,0);
		}
		public TerminalNode BRULEARROW() { return getToken(ActionOnlyParser.BRULEARROW, 0); }
		public BruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_brule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitBrule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BruleContext brule() throws RecognitionException {
		BruleContext _localctx = new BruleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_brule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); ((BruleContext)_localctx).head = pred();
			setState(128);
			switch (_input.LA(1)) {
			case BRULEARROW:
				{
				setState(121); match(BRULEARROW);
				setState(122); ((BruleContext)_localctx).f = logicalfmla();
				((BruleContext)_localctx).r =  new Abstract_Rule(head, ((BruleContext)_localctx).f.f);
				setState(124); match(SEMI);
				}
				break;
			case SEMI:
				{
				setState(126); match(SEMI);
				((BruleContext)_localctx).r =  new Abstract_Rule(head);
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

	public static class CapabilityContext extends ParserRuleContext {
		public Abstract_Capability c;
		public ClogicalfmlaContext f;
		public ActionContext a;
		public ClogicalfmlaContext clogicalfmla() {
			return getRuleContext(ClogicalfmlaContext.class,0);
		}
		public TerminalNode CURLYOPEN() { return getToken(ActionOnlyParser.CURLYOPEN, 0); }
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public TerminalNode CURLYCLOSE() { return getToken(ActionOnlyParser.CURLYCLOSE, 0); }
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
		enterRule(_localctx, 10, RULE_capability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); match(CURLYOPEN);
			setState(132);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << CONST) | (1L << VAR))) != 0)) {
				{
				setState(131); ((CapabilityContext)_localctx).f = clogicalfmla();
				}
			}

			setState(134); match(CURLYCLOSE);
			setState(135); ((CapabilityContext)_localctx).a = action();
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

	public static class LogicalfmlaContext extends ParserRuleContext {
		public Abstract_LogicalFormula f;
		public NotfmlaContext n;
		public NotfmlaContext n2;
		public NotfmlaContext notfmla(int i) {
			return getRuleContext(NotfmlaContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ActionOnlyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ActionOnlyParser.COMMA, i);
		}
		public List<NotfmlaContext> notfmla() {
			return getRuleContexts(NotfmlaContext.class);
		}
		public LogicalfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitLogicalfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalfmlaContext logicalfmla() throws RecognitionException {
		LogicalfmlaContext _localctx = new LogicalfmlaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_logicalfmla);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(137); ((LogicalfmlaContext)_localctx).n = notfmla();
			((LogicalfmlaContext)_localctx).f =  ((LogicalfmlaContext)_localctx).n.f;
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(139); match(COMMA);
					setState(140); ((LogicalfmlaContext)_localctx).n2 = notfmla();
					((LogicalfmlaContext)_localctx).f =  new Abstract_LogExpr(_localctx.f, Abstract_LogExpr.and, ((LogicalfmlaContext)_localctx).n2.f);
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class NotfmlaContext extends ParserRuleContext {
		public Abstract_LogicalFormula f;
		public PredContext gb;
		public EquationContext eq;
		public PredContext gb2;
		public SubfmlaContext lf;
		public TerminalNode NOT() { return getToken(ActionOnlyParser.NOT, 0); }
		public EquationContext equation() {
			return getRuleContext(EquationContext.class,0);
		}
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public SubfmlaContext subfmla() {
			return getRuleContext(SubfmlaContext.class,0);
		}
		public TerminalNode SQOPEN() { return getToken(ActionOnlyParser.SQOPEN, 0); }
		public TerminalNode SQCLOSE() { return getToken(ActionOnlyParser.SQCLOSE, 0); }
		public NotfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitNotfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotfmlaContext notfmla() throws RecognitionException {
		NotfmlaContext _localctx = new NotfmlaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_notfmla);
		try {
			setState(172);
			switch (_input.LA(1)) {
			case SQOPEN:
			case CONST:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				switch (_input.LA(1)) {
				case CONST:
				case VAR:
					{
					setState(148); ((NotfmlaContext)_localctx).gb = pred();
					((NotfmlaContext)_localctx).f =  gb;
					}
					break;
				case SQOPEN:
					{
					setState(151); match(SQOPEN);
					setState(152); ((NotfmlaContext)_localctx).eq = equation();
					((NotfmlaContext)_localctx).f =  eq;
					setState(154); match(SQCLOSE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(158); match(NOT);
				setState(170);
				switch (_input.LA(1)) {
				case CONST:
				case VAR:
					{
					setState(159); ((NotfmlaContext)_localctx).gb2 = pred();
					((NotfmlaContext)_localctx).f =  new Abstract_LogExpr(Abstract_LogExpr.not, gb2);
					}
					break;
				case SQOPEN:
					{
					setState(162); match(SQOPEN);
					setState(163); ((NotfmlaContext)_localctx).eq = equation();
					setState(164); match(SQCLOSE);
					((NotfmlaContext)_localctx).f =  new Abstract_LogExpr(Abstract_LogExpr.not, eq);
					}
					break;
				case OPEN:
					{
					setState(167); ((NotfmlaContext)_localctx).lf = subfmla();
					((NotfmlaContext)_localctx).f =  new Abstract_LogExpr(Abstract_LogExpr.not, ((NotfmlaContext)_localctx).lf.f);
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

	public static class SubfmlaContext extends ParserRuleContext {
		public Abstract_LogicalFormula f;
		public LogicalfmlaContext lf;
		public TerminalNode OPEN() { return getToken(ActionOnlyParser.OPEN, 0); }
		public LogicalfmlaContext logicalfmla() {
			return getRuleContext(LogicalfmlaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(ActionOnlyParser.CLOSE, 0); }
		public SubfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitSubfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubfmlaContext subfmla() throws RecognitionException {
		SubfmlaContext _localctx = new SubfmlaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_subfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(OPEN);
			setState(175); ((SubfmlaContext)_localctx).lf = logicalfmla();
			((SubfmlaContext)_localctx).f =  ((SubfmlaContext)_localctx).lf.f;
			setState(177); match(CLOSE);
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

	public static class ClogicalfmlaContext extends ParserRuleContext {
		public Abstract_GLogicalFormula f;
		public CnotfmlaContext n;
		public CnotfmlaContext n2;
		public List<CnotfmlaContext> cnotfmla() {
			return getRuleContexts(CnotfmlaContext.class);
		}
		public CnotfmlaContext cnotfmla(int i) {
			return getRuleContext(CnotfmlaContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ActionOnlyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ActionOnlyParser.COMMA, i);
		}
		public ClogicalfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clogicalfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitClogicalfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClogicalfmlaContext clogicalfmla() throws RecognitionException {
		ClogicalfmlaContext _localctx = new ClogicalfmlaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_clogicalfmla);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(179); ((ClogicalfmlaContext)_localctx).n = cnotfmla();
			((ClogicalfmlaContext)_localctx).f =  ((ClogicalfmlaContext)_localctx).n.f;
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(181); match(COMMA);
					setState(182); ((ClogicalfmlaContext)_localctx).n2 = cnotfmla();
					((ClogicalfmlaContext)_localctx).f =  new Abstract_Guard(_localctx.f, Abstract_Guard.and, ((ClogicalfmlaContext)_localctx).n2.f);
					}
					} 
				}
				setState(189);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class CnotfmlaContext extends ParserRuleContext {
		public Abstract_GLogicalFormula f;
		public PredContext gb;
		public PredContext gb2;
		public CsubfmlaContext lf;
		public TerminalNode NOT() { return getToken(ActionOnlyParser.NOT, 0); }
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public CsubfmlaContext csubfmla() {
			return getRuleContext(CsubfmlaContext.class,0);
		}
		public CnotfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cnotfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitCnotfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CnotfmlaContext cnotfmla() throws RecognitionException {
		CnotfmlaContext _localctx = new CnotfmlaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cnotfmla);
		try {
			setState(202);
			switch (_input.LA(1)) {
			case CONST:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(190); ((CnotfmlaContext)_localctx).gb = pred();
				((CnotfmlaContext)_localctx).f =  new Abstract_GBelief(new Abstract_Literal(gb));
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(193); match(NOT);
				setState(200);
				switch (_input.LA(1)) {
				case CONST:
				case VAR:
					{
					setState(194); ((CnotfmlaContext)_localctx).gb2 = pred();
					((CnotfmlaContext)_localctx).f =  new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal(gb2)));
					}
					break;
				case OPEN:
					{
					setState(197); ((CnotfmlaContext)_localctx).lf = csubfmla();
					((CnotfmlaContext)_localctx).f =  new Abstract_Guard(Abstract_Guard.not, ((CnotfmlaContext)_localctx).lf.f);
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

	public static class CsubfmlaContext extends ParserRuleContext {
		public Abstract_GLogicalFormula f;
		public ClogicalfmlaContext lf;
		public TerminalNode OPEN() { return getToken(ActionOnlyParser.OPEN, 0); }
		public ClogicalfmlaContext clogicalfmla() {
			return getRuleContext(ClogicalfmlaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(ActionOnlyParser.CLOSE, 0); }
		public CsubfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_csubfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitCsubfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CsubfmlaContext csubfmla() throws RecognitionException {
		CsubfmlaContext _localctx = new CsubfmlaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_csubfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204); match(OPEN);
			setState(205); ((CsubfmlaContext)_localctx).lf = clogicalfmla();
			((CsubfmlaContext)_localctx).f =  ((CsubfmlaContext)_localctx).lf.f;
			setState(207); match(CLOSE);
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
		public String env;
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
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitEnvironment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvironmentContext environment() throws RecognitionException {
		EnvironmentContext _localctx = new EnvironmentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_environment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209); ((EnvironmentContext)_localctx).w = classpath();
			((EnvironmentContext)_localctx).env =  ((EnvironmentContext)_localctx).w.s;
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
		public String s;
		public WordContext w;
		public WordContext w1;
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public List<TerminalNode> POINT() { return getTokens(ActionOnlyParser.POINT); }
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public TerminalNode POINT(int i) {
			return getToken(ActionOnlyParser.POINT, i);
		}
		public ClasspathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classpath; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitClasspath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClasspathContext classpath() throws RecognitionException {
		ClasspathContext _localctx = new ClasspathContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_classpath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212); ((ClasspathContext)_localctx).w = word();
			((ClasspathContext)_localctx).s =  ((ClasspathContext)_localctx).w.s;
			setState(218); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(214); match(POINT);
				setState(215); ((ClasspathContext)_localctx).w1 = word();
				_localctx.s+="."; _localctx.s+=((ClasspathContext)_localctx).w1.s;
				}
				}
				setState(220); 
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
		public String s;
		public Token CONST;
		public Token VAR;
		public TerminalNode CONST() { return getToken(ActionOnlyParser.CONST, 0); }
		public TerminalNode VAR() { return getToken(ActionOnlyParser.VAR, 0); }
		public WordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_word; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordContext word() throws RecognitionException {
		WordContext _localctx = new WordContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_word);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			switch (_input.LA(1)) {
			case CONST:
				{
				setState(222); ((WordContext)_localctx).CONST = match(CONST);
				((WordContext)_localctx).s = ((WordContext)_localctx).CONST.getText();
				}
				break;
			case VAR:
				{
				setState(224); ((WordContext)_localctx).VAR = match(VAR);
				((WordContext)_localctx).s = ((WordContext)_localctx).VAR.getText();
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

	public static class AgentnametermContext extends ParserRuleContext {
		public Abstract_StringTerm s;
		public Token CONST;
		public VarContext v;
		public TerminalNode CONST() { return getToken(ActionOnlyParser.CONST, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public AgentnametermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentnameterm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitAgentnameterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgentnametermContext agentnameterm() throws RecognitionException {
		AgentnametermContext _localctx = new AgentnametermContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_agentnameterm);
		try {
			setState(231);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(228); ((AgentnametermContext)_localctx).CONST = match(CONST);
				((AgentnametermContext)_localctx).s =  new Abstract_StringTermImpl(((AgentnametermContext)_localctx).CONST.getText());
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(230); ((AgentnametermContext)_localctx).v = var();
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

	public static class ActionContext extends ParserRuleContext {
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233); pred();
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(ActionOnlyParser.NOT, 0); }
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(ActionOnlyParser.TRUE, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			switch (_input.LA(1)) {
			case TRUE:
				{
				setState(235); match(TRUE);
				}
				break;
			case NOT:
				{
				setState(236); match(NOT);
				setState(237); pred();
				}
				break;
			case CONST:
			case VAR:
				{
				setState(238); pred();
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

	public static class PredContext extends ParserRuleContext {
		public VarContext v;
		public FunctionContext f;
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public PredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pred; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitPred(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredContext pred() throws RecognitionException {
		PredContext _localctx = new PredContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_pred);
		try {
			setState(243);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(241); ((PredContext)_localctx).v = var();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(242); ((PredContext)_localctx).f = function();
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(ActionOnlyParser.CONST, 0); }
		public TerminalNode OPEN() { return getToken(ActionOnlyParser.OPEN, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(ActionOnlyParser.CLOSE, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245); match(CONST);
			setState(250);
			_la = _input.LA(1);
			if (_la==OPEN) {
				{
				setState(246); match(OPEN);
				setState(247); terms();
				setState(248); match(CLOSE);
				}
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

	public static class TermsContext extends ParserRuleContext {
		public TermContext t;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ActionOnlyParser.COMMA, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terms; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermsContext terms() throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); ((TermsContext)_localctx).t = term();
			setState(255);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(253); match(COMMA);
				setState(254); terms();
				}
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

	public static class TermContext extends ParserRuleContext {
		public AtomContext a;
		public StringtermContext s;
		public FunctionContext f;
		public StringtermContext stringterm() {
			return getRuleContext(StringtermContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_term);
		try {
			setState(260);
			switch (_input.LA(1)) {
			case OPEN:
			case VAR:
			case NUMBER:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(257); ((TermContext)_localctx).a = atom();
				}
				break;
			case QUOTED_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(258); ((TermContext)_localctx).s = stringterm();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(259); ((TermContext)_localctx).f = function();
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

	public static class AtomContext extends ParserRuleContext {
		public NumberstringContext n;
		public VarContext v;
		public ArithexprContext a;
		public ArithexprContext arithexpr() {
			return getRuleContext(ArithexprContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(ActionOnlyParser.OPEN, 0); }
		public NumberstringContext numberstring() {
			return getRuleContext(NumberstringContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(ActionOnlyParser.CLOSE, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_atom);
		try {
			setState(268);
			switch (_input.LA(1)) {
			case NUMBER:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(262); ((AtomContext)_localctx).n = numberstring();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(263); ((AtomContext)_localctx).v = var();
				}
				break;
			case OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(264); match(OPEN);
				setState(265); ((AtomContext)_localctx).a = arithexpr();
				setState(266); match(CLOSE);
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

	public static class StringtermContext extends ParserRuleContext {
		public TerminalNode QUOTED_STRING() { return getToken(ActionOnlyParser.QUOTED_STRING, 0); }
		public StringtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringterm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitStringterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringtermContext stringterm() throws RecognitionException {
		StringtermContext _localctx = new StringtermContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_stringterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270); match(QUOTED_STRING);
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(ActionOnlyParser.VAR, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272); match(VAR);
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

	public static class NumberstringContext extends ParserRuleContext {
		public Token n1;
		public Token n2;
		public TerminalNode NUMBER(int i) {
			return getToken(ActionOnlyParser.NUMBER, i);
		}
		public TerminalNode POINT() { return getToken(ActionOnlyParser.POINT, 0); }
		public TerminalNode MINUS() { return getToken(ActionOnlyParser.MINUS, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(ActionOnlyParser.NUMBER); }
		public NumberstringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberstring; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitNumberstring(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberstringContext numberstring() throws RecognitionException {
		NumberstringContext _localctx = new NumberstringContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_numberstring);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(274); match(MINUS);
				}
			}

			{
			setState(277); ((NumberstringContext)_localctx).n1 = match(NUMBER);
			setState(280);
			_la = _input.LA(1);
			if (_la==POINT) {
				{
				setState(278); match(POINT);
				setState(279); ((NumberstringContext)_localctx).n2 = match(NUMBER);
				}
			}

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

	public static class EquationContext extends ParserRuleContext {
		public ArithexprContext a1;
		public EqoperContext oper;
		public ArithexprContext a2;
		public List<ArithexprContext> arithexpr() {
			return getRuleContexts(ArithexprContext.class);
		}
		public EqoperContext eqoper() {
			return getRuleContext(EqoperContext.class,0);
		}
		public ArithexprContext arithexpr(int i) {
			return getRuleContext(ArithexprContext.class,i);
		}
		public EquationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitEquation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EquationContext equation() throws RecognitionException {
		EquationContext _localctx = new EquationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_equation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282); ((EquationContext)_localctx).a1 = arithexpr();
			setState(283); ((EquationContext)_localctx).oper = eqoper();
			setState(284); ((EquationContext)_localctx).a2 = arithexpr();
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

	public static class EqoperContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(ActionOnlyParser.LESS, 0); }
		public TerminalNode EQ() { return getToken(ActionOnlyParser.EQ, 0); }
		public EqoperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqoper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitEqoper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqoperContext eqoper() throws RecognitionException {
		EqoperContext _localctx = new EqoperContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_eqoper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_la = _input.LA(1);
			if ( !(_la==LESS || _la==EQ) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ArithexprContext extends ParserRuleContext {
		public MultexprContext m1;
		public MultexprContext m2;
		public MultexprContext multexpr(int i) {
			return getRuleContext(MultexprContext.class,i);
		}
		public AddoperContext addoper() {
			return getRuleContext(AddoperContext.class,0);
		}
		public List<MultexprContext> multexpr() {
			return getRuleContexts(MultexprContext.class);
		}
		public ArithexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithexpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitArithexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithexprContext arithexpr() throws RecognitionException {
		ArithexprContext _localctx = new ArithexprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arithexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288); ((ArithexprContext)_localctx).m1 = multexpr();
			setState(292);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(289); addoper();
				setState(290); ((ArithexprContext)_localctx).m2 = multexpr();
				}
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

	public static class MultexprContext extends ParserRuleContext {
		public AtomContext a1;
		public AtomContext a2;
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public MultoperContext multoper() {
			return getRuleContext(MultoperContext.class,0);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public MultexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multexpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitMultexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultexprContext multexpr() throws RecognitionException {
		MultexprContext _localctx = new MultexprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_multexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294); ((MultexprContext)_localctx).a1 = atom();
			setState(298);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) {
				{
				setState(295); multoper();
				setState(296); ((MultexprContext)_localctx).a2 = atom();
				}
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

	public static class AddoperContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(ActionOnlyParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ActionOnlyParser.MINUS, 0); }
		public AddoperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addoper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitAddoper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddoperContext addoper() throws RecognitionException {
		AddoperContext _localctx = new AddoperContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_addoper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class MultoperContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(ActionOnlyParser.MULT, 0); }
		public TerminalNode MOD() { return getToken(ActionOnlyParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(ActionOnlyParser.DIV, 0); }
		public MultoperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multoper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActionOnlyVisitor ) return ((ActionOnlyVisitor<? extends T>)visitor).visitMultoper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultoperContext multoper() throws RecognitionException {
		MultoperContext _localctx = new MultoperContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_multoper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u0133\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\3\3\3\6\3I\n\3\r\3\16\3J\3\4\5\4N\n\4\3\4\3\4\3"+
		"\4\3\4\3\4\7\4U\n\4\f\4\16\4X\13\4\3\4\3\4\3\4\3\4\7\4^\n\4\f\4\16\4a"+
		"\13\4\5\4c\n\4\3\4\3\4\6\4g\n\4\r\4\16\4h\3\4\3\4\3\4\3\4\7\4o\n\4\f\4"+
		"\16\4r\13\4\3\5\3\5\3\5\3\5\3\5\5\5y\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6\u0083\n\6\3\7\3\7\5\7\u0087\n\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\7\b\u0092\n\b\f\b\16\b\u0095\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\t\u009f\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ad"+
		"\n\t\5\t\u00af\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7"+
		"\13\u00bc\n\13\f\13\16\13\u00bf\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00cb\n\f\5\f\u00cd\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u00dd\n\17\r\17\16\17\u00de\3\20\3"+
		"\20\3\20\3\20\5\20\u00e5\n\20\3\21\3\21\3\21\5\21\u00ea\n\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\5\23\u00f2\n\23\3\24\3\24\5\24\u00f6\n\24\3\25\3"+
		"\25\3\25\3\25\3\25\5\25\u00fd\n\25\3\26\3\26\3\26\5\26\u0102\n\26\3\27"+
		"\3\27\3\27\5\27\u0107\n\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u010f\n"+
		"\30\3\31\3\31\3\32\3\32\3\33\5\33\u0116\n\33\3\33\3\33\3\33\5\33\u011b"+
		"\n\33\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\5\36\u0127\n\36"+
		"\3\37\3\37\3\37\3\37\5\37\u012d\n\37\3 \3 \3!\3!\3!\4\u0093\u00bd\2\""+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@\2\5"+
		"\3\2\33\34\3\2\37 \4\2\36\36!\"\u0135\2B\3\2\2\2\4D\3\2\2\2\6M\3\2\2\2"+
		"\bx\3\2\2\2\nz\3\2\2\2\f\u0084\3\2\2\2\16\u008b\3\2\2\2\20\u00ae\3\2\2"+
		"\2\22\u00b0\3\2\2\2\24\u00b5\3\2\2\2\26\u00cc\3\2\2\2\30\u00ce\3\2\2\2"+
		"\32\u00d3\3\2\2\2\34\u00d6\3\2\2\2\36\u00e4\3\2\2\2 \u00e9\3\2\2\2\"\u00eb"+
		"\3\2\2\2$\u00f1\3\2\2\2&\u00f5\3\2\2\2(\u00f7\3\2\2\2*\u00fe\3\2\2\2,"+
		"\u0106\3\2\2\2.\u010e\3\2\2\2\60\u0110\3\2\2\2\62\u0112\3\2\2\2\64\u0115"+
		"\3\2\2\2\66\u011c\3\2\2\28\u0120\3\2\2\2:\u0122\3\2\2\2<\u0128\3\2\2\2"+
		">\u012e\3\2\2\2@\u0130\3\2\2\2BC\5\4\3\2C\3\3\2\2\2DH\7\3\2\2EF\5\6\4"+
		"\2FG\b\3\1\2GI\3\2\2\2HE\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\5\3\2"+
		"\2\2LN\7\3\2\2ML\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7\7\2\2PQ\5\36\20\2QR\b"+
		"\4\1\2RV\7\4\2\2SU\5$\23\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2Wb\3"+
		"\2\2\2XV\3\2\2\2Y_\7\5\2\2Z[\5\n\6\2[\\\b\4\1\2\\^\3\2\2\2]Z\3\2\2\2^"+
		"a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`c\3\2\2\2a_\3\2\2\2bY\3\2\2\2bc\3\2\2\2"+
		"cd\3\2\2\2df\7\6\2\2eg\5$\23\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2"+
		"ij\3\2\2\2jp\7\n\2\2kl\5\f\7\2lm\b\4\1\2mo\3\2\2\2nk\3\2\2\2or\3\2\2\2"+
		"pn\3\2\2\2pq\3\2\2\2q\7\3\2\2\2rp\3\2\2\2st\7\b\2\2ty\5$\23\2uy\5\66\34"+
		"\2vw\7\27\2\2wy\b\5\1\2xs\3\2\2\2xu\3\2\2\2xv\3\2\2\2y\t\3\2\2\2z\u0082"+
		"\5&\24\2{|\7\t\2\2|}\5\16\b\2}~\b\6\1\2~\177\7%\2\2\177\u0083\3\2\2\2"+
		"\u0080\u0081\7%\2\2\u0081\u0083\b\6\1\2\u0082{\3\2\2\2\u0082\u0080\3\2"+
		"\2\2\u0083\13\3\2\2\2\u0084\u0086\7\23\2\2\u0085\u0087\5\24\13\2\u0086"+
		"\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\24"+
		"\2\2\u0089\u008a\5\"\22\2\u008a\r\3\2\2\2\u008b\u008c\5\20\t\2\u008c\u0093"+
		"\b\b\1\2\u008d\u008e\7$\2\2\u008e\u008f\5\20\t\2\u008f\u0090\b\b\1\2\u0090"+
		"\u0092\3\2\2\2\u0091\u008d\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\17\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097"+
		"\5&\24\2\u0097\u0098\b\t\1\2\u0098\u009f\3\2\2\2\u0099\u009a\7\21\2\2"+
		"\u009a\u009b\5\66\34\2\u009b\u009c\b\t\1\2\u009c\u009d\7\22\2\2\u009d"+
		"\u009f\3\2\2\2\u009e\u0096\3\2\2\2\u009e\u0099\3\2\2\2\u009f\u00af\3\2"+
		"\2\2\u00a0\u00ac\7\26\2\2\u00a1\u00a2\5&\24\2\u00a2\u00a3\b\t\1\2\u00a3"+
		"\u00ad\3\2\2\2\u00a4\u00a5\7\21\2\2\u00a5\u00a6\5\66\34\2\u00a6\u00a7"+
		"\7\22\2\2\u00a7\u00a8\b\t\1\2\u00a8\u00ad\3\2\2\2\u00a9\u00aa\5\22\n\2"+
		"\u00aa\u00ab\b\t\1\2\u00ab\u00ad\3\2\2\2\u00ac\u00a1\3\2\2\2\u00ac\u00a4"+
		"\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u009e\3\2\2\2\u00ae"+
		"\u00a0\3\2\2\2\u00af\21\3\2\2\2\u00b0\u00b1\7\17\2\2\u00b1\u00b2\5\16"+
		"\b\2\u00b2\u00b3\b\n\1\2\u00b3\u00b4\7\20\2\2\u00b4\23\3\2\2\2\u00b5\u00b6"+
		"\5\26\f\2\u00b6\u00bd\b\13\1\2\u00b7\u00b8\7$\2\2\u00b8\u00b9\5\26\f\2"+
		"\u00b9\u00ba\b\13\1\2\u00ba\u00bc\3\2\2\2\u00bb\u00b7\3\2\2\2\u00bc\u00bf"+
		"\3\2\2\2\u00bd\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\25\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00c0\u00c1\5&\24\2\u00c1\u00c2\b\f\1\2\u00c2\u00cd\3\2"+
		"\2\2\u00c3\u00ca\7\26\2\2\u00c4\u00c5\5&\24\2\u00c5\u00c6\b\f\1\2\u00c6"+
		"\u00cb\3\2\2\2\u00c7\u00c8\5\30\r\2\u00c8\u00c9\b\f\1\2\u00c9\u00cb\3"+
		"\2\2\2\u00ca\u00c4\3\2\2\2\u00ca\u00c7\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc"+
		"\u00c0\3\2\2\2\u00cc\u00c3\3\2\2\2\u00cd\27\3\2\2\2\u00ce\u00cf\7\17\2"+
		"\2\u00cf\u00d0\5\24\13\2\u00d0\u00d1\b\r\1\2\u00d1\u00d2\7\20\2\2\u00d2"+
		"\31\3\2\2\2\u00d3\u00d4\5\34\17\2\u00d4\u00d5\b\16\1\2\u00d5\33\3\2\2"+
		"\2\u00d6\u00d7\5\36\20\2\u00d7\u00dc\b\17\1\2\u00d8\u00d9\7\35\2\2\u00d9"+
		"\u00da\5\36\20\2\u00da\u00db\b\17\1\2\u00db\u00dd\3\2\2\2\u00dc\u00d8"+
		"\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\35\3\2\2\2\u00e0\u00e1\7\30\2\2\u00e1\u00e5\b\20\1\2\u00e2\u00e3\7\31"+
		"\2\2\u00e3\u00e5\b\20\1\2\u00e4\u00e0\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5"+
		"\37\3\2\2\2\u00e6\u00e7\7\30\2\2\u00e7\u00ea\b\21\1\2\u00e8\u00ea\5\62"+
		"\32\2\u00e9\u00e6\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea!\3\2\2\2\u00eb\u00ec"+
		"\5&\24\2\u00ec#\3\2\2\2\u00ed\u00f2\7\27\2\2\u00ee\u00ef\7\26\2\2\u00ef"+
		"\u00f2\5&\24\2\u00f0\u00f2\5&\24\2\u00f1\u00ed\3\2\2\2\u00f1\u00ee\3\2"+
		"\2\2\u00f1\u00f0\3\2\2\2\u00f2%\3\2\2\2\u00f3\u00f6\5\62\32\2\u00f4\u00f6"+
		"\5(\25\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6\'\3\2\2\2\u00f7"+
		"\u00fc\7\30\2\2\u00f8\u00f9\7\17\2\2\u00f9\u00fa\5*\26\2\u00fa\u00fb\7"+
		"\20\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		")\3\2\2\2\u00fe\u0101\5,\27\2\u00ff\u0100\7$\2\2\u0100\u0102\5*\26\2\u0101"+
		"\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102+\3\2\2\2\u0103\u0107\5.\30\2"+
		"\u0104\u0107\5\60\31\2\u0105\u0107\5(\25\2\u0106\u0103\3\2\2\2\u0106\u0104"+
		"\3\2\2\2\u0106\u0105\3\2\2\2\u0107-\3\2\2\2\u0108\u010f\5\64\33\2\u0109"+
		"\u010f\5\62\32\2\u010a\u010b\7\17\2\2\u010b\u010c\5:\36\2\u010c\u010d"+
		"\7\20\2\2\u010d\u010f\3\2\2\2\u010e\u0108\3\2\2\2\u010e\u0109\3\2\2\2"+
		"\u010e\u010a\3\2\2\2\u010f/\3\2\2\2\u0110\u0111\7\25\2\2\u0111\61\3\2"+
		"\2\2\u0112\u0113\7\31\2\2\u0113\63\3\2\2\2\u0114\u0116\7 \2\2\u0115\u0114"+
		"\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u011a\7\32\2\2"+
		"\u0118\u0119\7\35\2\2\u0119\u011b\7\32\2\2\u011a\u0118\3\2\2\2\u011a\u011b"+
		"\3\2\2\2\u011b\65\3\2\2\2\u011c\u011d\5:\36\2\u011d\u011e\58\35\2\u011e"+
		"\u011f\5:\36\2\u011f\67\3\2\2\2\u0120\u0121\t\2\2\2\u01219\3\2\2\2\u0122"+
		"\u0126\5<\37\2\u0123\u0124\5> \2\u0124\u0125\5<\37\2\u0125\u0127\3\2\2"+
		"\2\u0126\u0123\3\2\2\2\u0126\u0127\3\2\2\2\u0127;\3\2\2\2\u0128\u012c"+
		"\5.\30\2\u0129\u012a\5@!\2\u012a\u012b\5.\30\2\u012b\u012d\3\2\2\2\u012c"+
		"\u0129\3\2\2\2\u012c\u012d\3\2\2\2\u012d=\3\2\2\2\u012e\u012f\t\3\2\2"+
		"\u012f?\3\2\2\2\u0130\u0131\t\4\2\2\u0131A\3\2\2\2 JMV_bhpx\u0082\u0086"+
		"\u0093\u009e\u00ac\u00ae\u00bd\u00ca\u00cc\u00de\u00e4\u00e9\u00f1\u00f5"+
		"\u00fc\u0101\u0106\u010e\u0115\u011a\u0126\u012c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}