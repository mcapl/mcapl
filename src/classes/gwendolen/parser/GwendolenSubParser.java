// Generated from ..\..\src\classes\gwendolen\parser\GwendolenSub.g by ANTLR 4.7

package gwendolen.parser;

import ail.syntax.ast.*;
import gwendolen.syntax.ast.*;
import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GwendolenSubParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LINE_COMMENT=2, NEWLINE=3, WS=4, TRUE=5, OPEN=6, CLOSE=7, SQOPEN=8, 
		SQCLOSE=9, CURLYOPEN=10, CURLYCLOSE=11, DOUBLEQUOTE=12, NOT=13, STRING=14, 
		CONST=15, VAR=16, NUMBER=17, UNNAMEDVAR=18, LESS=19, EQ=20, POINT=21, 
		MULT=22, PLUS=23, MINUS=24, DIV=25, MOD=26, SHRIEK=27, COMMA=28, SEMI=29, 
		COLON=30, QUERY=31, BAR=32;
	public static final int
		RULE_descriptions = 0, RULE_description = 1, RULE_function = 2, RULE_terms = 3, 
		RULE_term = 4, RULE_atom = 5, RULE_stringterm = 6, RULE_listterm = 7, 
		RULE_listheads = 8, RULE_var = 9, RULE_numberstring = 10, RULE_equation = 11, 
		RULE_eqoper = 12, RULE_arithexpr = 13, RULE_multexpr = 14, RULE_addoper = 15, 
		RULE_multoper = 16;
	public static final String[] ruleNames = {
		"descriptions", "description", "function", "terms", "term", "atom", "stringterm", 
		"listterm", "listheads", "var", "numberstring", "equation", "eqoper", 
		"arithexpr", "multexpr", "addoper", "multoper"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'True'", "'('", "')'", "'['", "']'", "'{'", 
		"'}'", "'\"'", "'~'", null, null, null, null, null, "'<'", "'=='", null, 
		"'*'", "'+'", "'-'", "'/'", "'%'", "'!'", "','", "';'", "':'", "'?'", 
		"'|'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "TRUE", "OPEN", "CLOSE", 
		"SQOPEN", "SQCLOSE", "CURLYOPEN", "CURLYCLOSE", "DOUBLEQUOTE", "NOT", 
		"STRING", "CONST", "VAR", "NUMBER", "UNNAMEDVAR", "LESS", "EQ", "POINT", 
		"MULT", "PLUS", "MINUS", "DIV", "MOD", "SHRIEK", "COMMA", "SEMI", "COLON", 
		"QUERY", "BAR"
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
	public String getGrammarFileName() { return "GwendolenSub.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
	    private boolean stringterm = false;

	public GwendolenSubParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DescriptionsContext extends ParserRuleContext {
		public ArrayList<Abstract_PredicateDescription> ds;
		public DescriptionContext d;
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public DescriptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptions; }
	}

	public final DescriptionsContext descriptions() throws RecognitionException {
		DescriptionsContext _localctx = new DescriptionsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_descriptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DescriptionsContext)_localctx).ds = new ArrayList<Abstract_PredicateDescription>();
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(35);
				((DescriptionsContext)_localctx).d = description();
				_localctx.ds.add(((DescriptionsContext)_localctx).d.d);
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CONST );
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

	public static class DescriptionContext extends ParserRuleContext {
		public Abstract_PredicateDescription d;
		public FunctionContext f;
		public StringtermContext s;
		public TerminalNode COLON() { return getToken(GwendolenSubParser.COLON, 0); }
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public StringtermContext stringterm() {
			return getRuleContext(StringtermContext.class,0);
		}
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			((DescriptionContext)_localctx).f = function();
			setState(43);
			match(COLON);
			setState(44);
			((DescriptionContext)_localctx).s = stringterm();
					 
			                   ((DescriptionContext)_localctx).d =  new Abstract_PredicateDescription(((DescriptionContext)_localctx).f.f,((DescriptionContext)_localctx).s.s);
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
		public Abstract_Predicate f;
		public Token CONST;
		public TerminalNode CONST() { return getToken(GwendolenSubParser.CONST, 0); }
		public TerminalNode OPEN() { return getToken(GwendolenSubParser.OPEN, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(GwendolenSubParser.CLOSE, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			((FunctionContext)_localctx).CONST = match(CONST);
			((FunctionContext)_localctx).f =  new Abstract_Predicate(((FunctionContext)_localctx).CONST.getText());
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN) {
				{
				setState(49);
				match(OPEN);
				setState(50);
				terms(_localctx.f);
				setState(51);
				match(CLOSE);
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
		public Abstract_Predicate f;
		public TermContext t;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(GwendolenSubParser.COMMA, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TermsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TermsContext(ParserRuleContext parent, int invokingState, Abstract_Predicate f) {
			super(parent, invokingState);
			this.f = f;
		}
		@Override public int getRuleIndex() { return RULE_terms; }
	}

	public final TermsContext terms(Abstract_Predicate f) throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState(), f);
		enterRule(_localctx, 6, RULE_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			((TermsContext)_localctx).t = term();
			_localctx.f.addTerm(((TermsContext)_localctx).t.t);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(57);
				match(COMMA);
				setState(58);
				terms(_localctx.f);
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
		public Abstract_Term t;
		public AtomContext a;
		public StringtermContext s;
		public FunctionContext f;
		public ListtermContext l;
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public StringtermContext stringterm() {
			return getRuleContext(StringtermContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ListtermContext listterm() {
			return getRuleContext(ListtermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_term);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN:
			case VAR:
			case NUMBER:
			case UNNAMEDVAR:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				((TermContext)_localctx).a = atom();
				((TermContext)_localctx).t =  ((TermContext)_localctx).a.t;
				}
				break;
			case DOUBLEQUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				((TermContext)_localctx).s = stringterm();
				((TermContext)_localctx).t =  ((TermContext)_localctx).s.s;
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				((TermContext)_localctx).f = function();
				((TermContext)_localctx).t =  ((TermContext)_localctx).f.f;
				}
				break;
			case SQOPEN:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				((TermContext)_localctx).l = listterm();
				((TermContext)_localctx).t =  ((TermContext)_localctx).l.l;
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
		public Abstract_NumberTerm t;
		public NumberstringContext n;
		public VarContext v;
		public ArithexprContext a;
		public NumberstringContext numberstring() {
			return getRuleContext(NumberstringContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(GwendolenSubParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(GwendolenSubParser.CLOSE, 0); }
		public ArithexprContext arithexpr() {
			return getRuleContext(ArithexprContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atom);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				((AtomContext)_localctx).n = numberstring();
				((AtomContext)_localctx).t =  new Abstract_NumberTermImpl(((AtomContext)_localctx).n.s);
				}
				break;
			case VAR:
			case UNNAMEDVAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				((AtomContext)_localctx).v = var();
				((AtomContext)_localctx).t =  ((AtomContext)_localctx).v.v;
				}
				break;
			case OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(OPEN);
				setState(82);
				((AtomContext)_localctx).a = arithexpr();
				setState(83);
				match(CLOSE);
				((AtomContext)_localctx).t =  ((AtomContext)_localctx).a.t;
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
		public Abstract_StringTerm s;
		public Token STRING;
		public List<TerminalNode> DOUBLEQUOTE() { return getTokens(GwendolenSubParser.DOUBLEQUOTE); }
		public TerminalNode DOUBLEQUOTE(int i) {
			return getToken(GwendolenSubParser.DOUBLEQUOTE, i);
		}
		public TerminalNode STRING() { return getToken(GwendolenSubParser.STRING, 0); }
		public StringtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringterm; }
	}

	public final StringtermContext stringterm() throws RecognitionException {
		StringtermContext _localctx = new StringtermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stringterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(DOUBLEQUOTE);
			setState(89);
			((StringtermContext)_localctx).STRING = match(STRING);
			setState(90);
			match(DOUBLEQUOTE);
					 
			                   ((StringtermContext)_localctx).s =  new Abstract_StringTermImpl(((StringtermContext)_localctx).STRING.getText());
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

	public static class ListtermContext extends ParserRuleContext {
		public Abstract_ListTerm l;
		public ListheadsContext hl;
		public VarContext v;
		public TerminalNode SQOPEN() { return getToken(GwendolenSubParser.SQOPEN, 0); }
		public TerminalNode SQCLOSE() { return getToken(GwendolenSubParser.SQCLOSE, 0); }
		public ListheadsContext listheads() {
			return getRuleContext(ListheadsContext.class,0);
		}
		public TerminalNode BAR() { return getToken(GwendolenSubParser.BAR, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ListtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listterm; }
	}

	public final ListtermContext listterm() throws RecognitionException {
		ListtermContext _localctx = new ListtermContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_listterm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ListtermContext)_localctx).l =  new Abstract_ListTermImpl();
			setState(94);
			match(SQOPEN);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << SQOPEN) | (1L << DOUBLEQUOTE) | (1L << CONST) | (1L << VAR) | (1L << NUMBER) | (1L << UNNAMEDVAR) | (1L << MINUS))) != 0)) {
				{
				setState(95);
				((ListtermContext)_localctx).hl = listheads();
				_localctx.l.addAll(((ListtermContext)_localctx).hl.tl);
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BAR) {
					{
					setState(97);
					match(BAR);
					setState(98);
					((ListtermContext)_localctx).v = var();
					_localctx.l.addTail(((ListtermContext)_localctx).v.v);
					}
				}

				}
			}

			setState(105);
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

	public static class ListheadsContext extends ParserRuleContext {
		public ArrayList<Abstract_Term> tl;
		public TermContext t1;
		public TermContext tl2;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GwendolenSubParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GwendolenSubParser.COMMA, i);
		}
		public ListheadsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listheads; }
	}

	public final ListheadsContext listheads() throws RecognitionException {
		ListheadsContext _localctx = new ListheadsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_listheads);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			((ListheadsContext)_localctx).t1 = term();
			((ListheadsContext)_localctx).tl =  new ArrayList<Abstract_Term>(); _localctx.tl.add(((ListheadsContext)_localctx).t1.t);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(109);
				match(COMMA);
				setState(110);
				((ListheadsContext)_localctx).tl2 = term();
				_localctx.tl.add(((ListheadsContext)_localctx).tl2.t);
				}
				}
				setState(117);
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

	public static class VarContext extends ParserRuleContext {
		public Abstract_VarTerm v;
		public Token VAR;
		public TerminalNode VAR() { return getToken(GwendolenSubParser.VAR, 0); }
		public TerminalNode UNNAMEDVAR() { return getToken(GwendolenSubParser.UNNAMEDVAR, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				setState(118);
				((VarContext)_localctx).VAR = match(VAR);

					if (variables.containsKey(((VarContext)_localctx).VAR.getText())) {
						((VarContext)_localctx).v =  variables.get(((VarContext)_localctx).VAR.getText());
						} else {
						((VarContext)_localctx).v =  new Abstract_VarTerm(((VarContext)_localctx).VAR.getText());
						variables.put(((VarContext)_localctx).VAR.getText(), _localctx.v);
						}
					
				}
				break;
			case UNNAMEDVAR:
				{
				setState(120);
				match(UNNAMEDVAR);
				((VarContext)_localctx).v =  new Abstract_UnnamedVar();
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

	public static class NumberstringContext extends ParserRuleContext {
		public String s;
		public Token n1;
		public Token n2;
		public TerminalNode MINUS() { return getToken(GwendolenSubParser.MINUS, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(GwendolenSubParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(GwendolenSubParser.NUMBER, i);
		}
		public TerminalNode POINT() { return getToken(GwendolenSubParser.POINT, 0); }
		public NumberstringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberstring; }
	}

	public final NumberstringContext numberstring() throws RecognitionException {
		NumberstringContext _localctx = new NumberstringContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_numberstring);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((NumberstringContext)_localctx).s =  "";
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(125);
				match(MINUS);
				_localctx.s += "-";
				}
			}

			{
			setState(129);
			((NumberstringContext)_localctx).n1 = match(NUMBER);
			_localctx.s += ((NumberstringContext)_localctx).n1.getText();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==POINT) {
				{
				setState(131);
				match(POINT);
				_localctx.s += ".";
				setState(133);
				((NumberstringContext)_localctx).n2 = match(NUMBER);
				_localctx.s += ((NumberstringContext)_localctx).n2.getText();
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
		public Abstract_Equation eq;
		public ArithexprContext a1;
		public EqoperContext oper;
		public ArithexprContext a2;
		public List<ArithexprContext> arithexpr() {
			return getRuleContexts(ArithexprContext.class);
		}
		public ArithexprContext arithexpr(int i) {
			return getRuleContext(ArithexprContext.class,i);
		}
		public EqoperContext eqoper() {
			return getRuleContext(EqoperContext.class,0);
		}
		public EquationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equation; }
	}

	public final EquationContext equation() throws RecognitionException {
		EquationContext _localctx = new EquationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_equation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			((EquationContext)_localctx).a1 = arithexpr();
			setState(138);
			((EquationContext)_localctx).oper = eqoper();
			setState(139);
			((EquationContext)_localctx).a2 = arithexpr();
			((EquationContext)_localctx).eq =  new Abstract_Equation(((EquationContext)_localctx).a1.t, ((EquationContext)_localctx).oper.oper, ((EquationContext)_localctx).a2.t);
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
		public int oper;
		public TerminalNode LESS() { return getToken(GwendolenSubParser.LESS, 0); }
		public TerminalNode EQ() { return getToken(GwendolenSubParser.EQ, 0); }
		public EqoperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqoper; }
	}

	public final EqoperContext eqoper() throws RecognitionException {
		EqoperContext _localctx = new EqoperContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_eqoper);
		try {
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LESS:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(LESS);
				((EqoperContext)_localctx).oper = Abstract_Equation.less;
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(EQ);
				((EqoperContext)_localctx).oper = Abstract_Equation.equal;
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

	public static class ArithexprContext extends ParserRuleContext {
		public Abstract_NumberTerm t;
		public MultexprContext m;
		public AddoperContext oper;
		public MultexprContext m1;
		public List<MultexprContext> multexpr() {
			return getRuleContexts(MultexprContext.class);
		}
		public MultexprContext multexpr(int i) {
			return getRuleContext(MultexprContext.class,i);
		}
		public AddoperContext addoper() {
			return getRuleContext(AddoperContext.class,0);
		}
		public ArithexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithexpr; }
	}

	public final ArithexprContext arithexpr() throws RecognitionException {
		ArithexprContext _localctx = new ArithexprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arithexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			((ArithexprContext)_localctx).m = multexpr();
			((ArithexprContext)_localctx).t =  ((ArithexprContext)_localctx).m.t;
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(150);
				((ArithexprContext)_localctx).oper = addoper();
				setState(151);
				((ArithexprContext)_localctx).m1 = multexpr();
				((ArithexprContext)_localctx).t =  new Abstract_ArithExpr(((ArithexprContext)_localctx).m.t, ((ArithexprContext)_localctx).oper.oper, ((ArithexprContext)_localctx).m1.t);
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
		public Abstract_NumberTerm t;
		public AtomContext a;
		public MultoperContext oper;
		public AtomContext a1;
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public MultoperContext multoper() {
			return getRuleContext(MultoperContext.class,0);
		}
		public MultexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multexpr; }
	}

	public final MultexprContext multexpr() throws RecognitionException {
		MultexprContext _localctx = new MultexprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_multexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			((MultexprContext)_localctx).a = atom();
			((MultexprContext)_localctx).t =  ((MultexprContext)_localctx).a.t;
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) {
				{
				setState(158);
				((MultexprContext)_localctx).oper = multoper();
				setState(159);
				((MultexprContext)_localctx).a1 = atom();
				((MultexprContext)_localctx).t =  new Abstract_ArithExpr(((MultexprContext)_localctx).a.t, ((MultexprContext)_localctx).oper.oper, ((MultexprContext)_localctx).a1.t);
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
		public int oper;
		public TerminalNode PLUS() { return getToken(GwendolenSubParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(GwendolenSubParser.MINUS, 0); }
		public AddoperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addoper; }
	}

	public final AddoperContext addoper() throws RecognitionException {
		AddoperContext _localctx = new AddoperContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_addoper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				{
				setState(164);
				match(PLUS);
				((AddoperContext)_localctx).oper = Abstract_ArithExpr.plus;
				}
				break;
			case MINUS:
				{
				setState(166);
				match(MINUS);
				((AddoperContext)_localctx).oper = Abstract_ArithExpr.minus;
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

	public static class MultoperContext extends ParserRuleContext {
		public int oper;
		public TerminalNode MULT() { return getToken(GwendolenSubParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(GwendolenSubParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(GwendolenSubParser.MOD, 0); }
		public MultoperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multoper; }
	}

	public final MultoperContext multoper() throws RecognitionException {
		MultoperContext _localctx = new MultoperContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_multoper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MULT:
				{
				setState(170);
				match(MULT);
				((MultoperContext)_localctx).oper = Abstract_ArithExpr.times;
				}
				break;
			case DIV:
				{
				setState(172);
				match(DIV);
				((MultoperContext)_localctx).oper = Abstract_ArithExpr.div;
				}
				break;
			case MOD:
				{
				setState(174);
				match(MOD);
				((MultoperContext)_localctx).oper = Abstract_ArithExpr.mod;
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00b5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\6\2)\n\2\r\2\16\2*\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\48\n\4\3\5\3\5\3\5\3\5\5\5>\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7Y\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\th\n\t\5\tj\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\7\nt\n\n\f\n\16\nw\13"+
		"\n\3\13\3\13\3\13\3\13\5\13}\n\13\3\f\3\f\3\f\5\f\u0082\n\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u008a\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\5"+
		"\16\u0095\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u009d\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00a5\n\20\3\21\3\21\3\21\3\21\5\21\u00ab\n"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00b3\n\22\3\22\2\2\23\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"\2\2\2\u00b7\2$\3\2\2\2\4,\3\2\2\2\6"+
		"\61\3\2\2\2\b9\3\2\2\2\nK\3\2\2\2\fX\3\2\2\2\16Z\3\2\2\2\20_\3\2\2\2\22"+
		"m\3\2\2\2\24|\3\2\2\2\26~\3\2\2\2\30\u008b\3\2\2\2\32\u0094\3\2\2\2\34"+
		"\u0096\3\2\2\2\36\u009e\3\2\2\2 \u00aa\3\2\2\2\"\u00b2\3\2\2\2$(\b\2\1"+
		"\2%&\5\4\3\2&\'\b\2\1\2\')\3\2\2\2(%\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2"+
		"\2\2+\3\3\2\2\2,-\5\6\4\2-.\7 \2\2./\5\16\b\2/\60\b\3\1\2\60\5\3\2\2\2"+
		"\61\62\7\21\2\2\62\67\b\4\1\2\63\64\7\b\2\2\64\65\5\b\5\2\65\66\7\t\2"+
		"\2\668\3\2\2\2\67\63\3\2\2\2\678\3\2\2\28\7\3\2\2\29:\5\n\6\2:=\b\5\1"+
		"\2;<\7\36\2\2<>\5\b\5\2=;\3\2\2\2=>\3\2\2\2>\t\3\2\2\2?@\5\f\7\2@A\b\6"+
		"\1\2AL\3\2\2\2BC\5\16\b\2CD\b\6\1\2DL\3\2\2\2EF\5\6\4\2FG\b\6\1\2GL\3"+
		"\2\2\2HI\5\20\t\2IJ\b\6\1\2JL\3\2\2\2K?\3\2\2\2KB\3\2\2\2KE\3\2\2\2KH"+
		"\3\2\2\2L\13\3\2\2\2MN\5\26\f\2NO\b\7\1\2OY\3\2\2\2PQ\5\24\13\2QR\b\7"+
		"\1\2RY\3\2\2\2ST\7\b\2\2TU\5\34\17\2UV\7\t\2\2VW\b\7\1\2WY\3\2\2\2XM\3"+
		"\2\2\2XP\3\2\2\2XS\3\2\2\2Y\r\3\2\2\2Z[\7\16\2\2[\\\7\20\2\2\\]\7\16\2"+
		"\2]^\b\b\1\2^\17\3\2\2\2_`\b\t\1\2`i\7\n\2\2ab\5\22\n\2bg\b\t\1\2cd\7"+
		"\"\2\2de\5\24\13\2ef\b\t\1\2fh\3\2\2\2gc\3\2\2\2gh\3\2\2\2hj\3\2\2\2i"+
		"a\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\7\13\2\2l\21\3\2\2\2mn\5\n\6\2nu\b\n\1"+
		"\2op\7\36\2\2pq\5\n\6\2qr\b\n\1\2rt\3\2\2\2so\3\2\2\2tw\3\2\2\2us\3\2"+
		"\2\2uv\3\2\2\2v\23\3\2\2\2wu\3\2\2\2xy\7\22\2\2y}\b\13\1\2z{\7\24\2\2"+
		"{}\b\13\1\2|x\3\2\2\2|z\3\2\2\2}\25\3\2\2\2~\u0081\b\f\1\2\177\u0080\7"+
		"\32\2\2\u0080\u0082\b\f\1\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\7\23\2\2\u0084\u0089\b\f\1\2\u0085\u0086\7"+
		"\27\2\2\u0086\u0087\b\f\1\2\u0087\u0088\7\23\2\2\u0088\u008a\b\f\1\2\u0089"+
		"\u0085\3\2\2\2\u0089\u008a\3\2\2\2\u008a\27\3\2\2\2\u008b\u008c\5\34\17"+
		"\2\u008c\u008d\5\32\16\2\u008d\u008e\5\34\17\2\u008e\u008f\b\r\1\2\u008f"+
		"\31\3\2\2\2\u0090\u0091\7\25\2\2\u0091\u0095\b\16\1\2\u0092\u0093\7\26"+
		"\2\2\u0093\u0095\b\16\1\2\u0094\u0090\3\2\2\2\u0094\u0092\3\2\2\2\u0095"+
		"\33\3\2\2\2\u0096\u0097\5\36\20\2\u0097\u009c\b\17\1\2\u0098\u0099\5 "+
		"\21\2\u0099\u009a\5\36\20\2\u009a\u009b\b\17\1\2\u009b\u009d\3\2\2\2\u009c"+
		"\u0098\3\2\2\2\u009c\u009d\3\2\2\2\u009d\35\3\2\2\2\u009e\u009f\5\f\7"+
		"\2\u009f\u00a4\b\20\1\2\u00a0\u00a1\5\"\22\2\u00a1\u00a2\5\f\7\2\u00a2"+
		"\u00a3\b\20\1\2\u00a3\u00a5\3\2\2\2\u00a4\u00a0\3\2\2\2\u00a4\u00a5\3"+
		"\2\2\2\u00a5\37\3\2\2\2\u00a6\u00a7\7\31\2\2\u00a7\u00ab\b\21\1\2\u00a8"+
		"\u00a9\7\32\2\2\u00a9\u00ab\b\21\1\2\u00aa\u00a6\3\2\2\2\u00aa\u00a8\3"+
		"\2\2\2\u00ab!\3\2\2\2\u00ac\u00ad\7\30\2\2\u00ad\u00b3\b\22\1\2\u00ae"+
		"\u00af\7\33\2\2\u00af\u00b3\b\22\1\2\u00b0\u00b1\7\34\2\2\u00b1\u00b3"+
		"\b\22\1\2\u00b2\u00ac\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b2\u00b0\3\2\2\2"+
		"\u00b3#\3\2\2\2\22*\67=KXgiu|\u0081\u0089\u0094\u009c\u00a4\u00aa\u00b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}