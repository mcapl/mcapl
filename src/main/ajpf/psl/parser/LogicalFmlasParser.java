// Generated from /Users/louisedennis/IdeaProjects/mcapl/src/main/ajpf/psl/parser/antlr/LogicalFmlas.g4 by ANTLR 4.13.1
package ajpf.psl.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LogicalFmlasParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LINE_COMMENT=2, NEWLINE=3, WS=4, OPEN=5, CLOSE=6, SQOPEN=7, 
		SQCLOSE=8, CURLYOPEN=9, CURLYCLOSE=10, QUOTED_STRING=11, NOT=12, TRUE=13, 
		CONST=14, VAR=15, NUMBER=16, UNNAMEDVAR=17, RULEARROW=18, LESS=19, EQ=20, 
		IS=21, POINT=22, MULT=23, PLUS=24, MINUS=25, DIV=26, MOD=27, SHRIEK=28, 
		COMMA=29, SEMI=30, COLON=31, QUERY=32, BAR=33;
	public static final int
		RULE_rulelist = 0, RULE_rulelist_poss_empty = 1, RULE_prolog_rule = 2, 
		RULE_logicalfmla = 3, RULE_notfmla = 4, RULE_subfmla = 5, RULE_litlist = 6, 
		RULE_litlist_poss_empty = 7, RULE_literal = 8, RULE_pred = 9, RULE_function = 10, 
		RULE_terms = 11, RULE_term = 12, RULE_atom = 13, RULE_stringterm = 14, 
		RULE_listterm = 15, RULE_listheads = 16, RULE_var = 17, RULE_numberstring = 18, 
		RULE_equation = 19, RULE_eqoper = 20, RULE_arithexpr = 21, RULE_multexpr = 22, 
		RULE_addoper = 23, RULE_multoper = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"rulelist", "rulelist_poss_empty", "prolog_rule", "logicalfmla", "notfmla", 
			"subfmla", "litlist", "litlist_poss_empty", "literal", "pred", "function", 
			"terms", "term", "atom", "stringterm", "listterm", "listheads", "var", 
			"numberstring", "equation", "eqoper", "arithexpr", "multexpr", "addoper", 
			"multoper"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", 
			null, "'~'", "'True'", null, null, null, "'_'", "':-'", "'<'", "'=='", 
			"'is'", "'.'", "'*'", "'+'", "'-'", "'/'", "'%'", "'!'", "','", "';'", 
			"':'", "'?'", "'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "OPEN", "CLOSE", "SQOPEN", 
			"SQCLOSE", "CURLYOPEN", "CURLYCLOSE", "QUOTED_STRING", "NOT", "TRUE", 
			"CONST", "VAR", "NUMBER", "UNNAMEDVAR", "RULEARROW", "LESS", "EQ", "IS", 
			"POINT", "MULT", "PLUS", "MINUS", "DIV", "MOD", "SHRIEK", "COMMA", "SEMI", 
			"COLON", "QUERY", "BAR"
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
	public String getGrammarFileName() { return "LogicalFmlas.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LogicalFmlasParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RulelistContext extends ParserRuleContext {
		public Prolog_ruleContext prolog_rule() {
			return getRuleContext(Prolog_ruleContext.class,0);
		}
		public RulelistContext rulelist() {
			return getRuleContext(RulelistContext.class,0);
		}
		public RulelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulelist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitRulelist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulelistContext rulelist() throws RecognitionException {
		RulelistContext _localctx = new RulelistContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rulelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			prolog_rule();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 180224L) != 0)) {
				{
				setState(51);
				rulelist();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Rulelist_poss_emptyContext extends ParserRuleContext {
		public RulelistContext rulelist() {
			return getRuleContext(RulelistContext.class,0);
		}
		public Rulelist_poss_emptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulelist_poss_empty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitRulelist_poss_empty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rulelist_poss_emptyContext rulelist_poss_empty() throws RecognitionException {
		Rulelist_poss_emptyContext _localctx = new Rulelist_poss_emptyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rulelist_poss_empty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 180224L) != 0)) {
				{
				setState(54);
				rulelist();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Prolog_ruleContext extends ParserRuleContext {
		public PredContext head;
		public LogicalfmlaContext f;
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public TerminalNode RULEARROW() { return getToken(LogicalFmlasParser.RULEARROW, 0); }
		public TerminalNode SEMI() { return getToken(LogicalFmlasParser.SEMI, 0); }
		public LogicalfmlaContext logicalfmla() {
			return getRuleContext(LogicalfmlaContext.class,0);
		}
		public Prolog_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prolog_rule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitProlog_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prolog_ruleContext prolog_rule() throws RecognitionException {
		Prolog_ruleContext _localctx = new Prolog_ruleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_prolog_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			((Prolog_ruleContext)_localctx).head = pred();
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RULEARROW:
				{
				setState(58);
				match(RULEARROW);
				setState(59);
				((Prolog_ruleContext)_localctx).f = logicalfmla();
				setState(60);
				match(SEMI);
				}
				break;
			case SEMI:
				{
				setState(62);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalfmlaContext extends ParserRuleContext {
		public NotfmlaContext n;
		public NotfmlaContext n2;
		public List<NotfmlaContext> notfmla() {
			return getRuleContexts(NotfmlaContext.class);
		}
		public NotfmlaContext notfmla(int i) {
			return getRuleContext(NotfmlaContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LogicalFmlasParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LogicalFmlasParser.COMMA, i);
		}
		public LogicalfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitLogicalfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalfmlaContext logicalfmla() throws RecognitionException {
		LogicalfmlaContext _localctx = new LogicalfmlaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_logicalfmla);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			((LogicalfmlaContext)_localctx).n = notfmla();
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(66);
					match(COMMA);
					setState(67);
					((LogicalfmlaContext)_localctx).n2 = notfmla();
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
	public static class NotfmlaContext extends ParserRuleContext {
		public PredContext gb;
		public EquationContext eq;
		public Token cut;
		public PredContext gb2;
		public EquationContext eq2;
		public SubfmlaContext lf;
		public TerminalNode SQOPEN() { return getToken(LogicalFmlasParser.SQOPEN, 0); }
		public TerminalNode SQCLOSE() { return getToken(LogicalFmlasParser.SQCLOSE, 0); }
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public EquationContext equation() {
			return getRuleContext(EquationContext.class,0);
		}
		public TerminalNode SHRIEK() { return getToken(LogicalFmlasParser.SHRIEK, 0); }
		public TerminalNode NOT() { return getToken(LogicalFmlasParser.NOT, 0); }
		public SubfmlaContext subfmla() {
			return getRuleContext(SubfmlaContext.class,0);
		}
		public NotfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitNotfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotfmlaContext notfmla() throws RecognitionException {
		NotfmlaContext _localctx = new NotfmlaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_notfmla);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SQOPEN:
			case CONST:
			case VAR:
			case UNNAMEDVAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CONST:
				case VAR:
				case UNNAMEDVAR:
					{
					setState(73);
					((NotfmlaContext)_localctx).gb = pred();
					}
					break;
				case SQOPEN:
					{
					setState(74);
					match(SQOPEN);
					setState(75);
					((NotfmlaContext)_localctx).eq = equation();
					setState(76);
					match(SQCLOSE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case SHRIEK:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				((NotfmlaContext)_localctx).cut = match(SHRIEK);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(NOT);
				setState(88);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CONST:
				case VAR:
				case UNNAMEDVAR:
					{
					setState(82);
					((NotfmlaContext)_localctx).gb2 = pred();
					}
					break;
				case SQOPEN:
					{
					setState(83);
					match(SQOPEN);
					setState(84);
					((NotfmlaContext)_localctx).eq2 = equation();
					setState(85);
					match(SQCLOSE);
					}
					break;
				case OPEN:
					{
					setState(87);
					((NotfmlaContext)_localctx).lf = subfmla();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SubfmlaContext extends ParserRuleContext {
		public LogicalfmlaContext lf;
		public TerminalNode OPEN() { return getToken(LogicalFmlasParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(LogicalFmlasParser.CLOSE, 0); }
		public LogicalfmlaContext logicalfmla() {
			return getRuleContext(LogicalfmlaContext.class,0);
		}
		public SubfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitSubfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubfmlaContext subfmla() throws RecognitionException {
		SubfmlaContext _localctx = new SubfmlaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_subfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(OPEN);
			setState(93);
			((SubfmlaContext)_localctx).lf = logicalfmla();
			setState(94);
			match(CLOSE);
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
	public static class LitlistContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LitlistContext litlist() {
			return getRuleContext(LitlistContext.class,0);
		}
		public LitlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_litlist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitLitlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LitlistContext litlist() throws RecognitionException {
		LitlistContext _localctx = new LitlistContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_litlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			literal();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 192512L) != 0)) {
				{
				setState(97);
				litlist();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Litlist_poss_emptyContext extends ParserRuleContext {
		public LitlistContext litlist() {
			return getRuleContext(LitlistContext.class,0);
		}
		public Litlist_poss_emptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_litlist_poss_empty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitLitlist_poss_empty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Litlist_poss_emptyContext litlist_poss_empty() throws RecognitionException {
		Litlist_poss_emptyContext _localctx = new Litlist_poss_emptyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_litlist_poss_empty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 192512L) != 0)) {
				{
				setState(100);
				litlist();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(LogicalFmlasParser.TRUE, 0); }
		public TerminalNode NOT() { return getToken(LogicalFmlasParser.NOT, 0); }
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				{
				setState(103);
				match(TRUE);
				}
				break;
			case NOT:
				{
				setState(104);
				match(NOT);
				setState(105);
				pred();
				}
				break;
			case CONST:
			case VAR:
			case UNNAMEDVAR:
				{
				setState(106);
				pred();
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
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitPred(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredContext pred() throws RecognitionException {
		PredContext _localctx = new PredContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pred);
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
			case UNNAMEDVAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				((PredContext)_localctx).v = var();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				((PredContext)_localctx).f = function();
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
	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(LogicalFmlasParser.CONST, 0); }
		public TerminalNode OPEN() { return getToken(LogicalFmlasParser.OPEN, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(LogicalFmlasParser.CLOSE, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(CONST);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN) {
				{
				setState(114);
				match(OPEN);
				setState(115);
				terms();
				setState(116);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermsContext extends ParserRuleContext {
		public TermContext t;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(LogicalFmlasParser.COMMA, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terms; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermsContext terms() throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			((TermsContext)_localctx).t = term();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(121);
				match(COMMA);
				setState(122);
				terms();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public AtomContext a;
		public FunctionContext f;
		public ListtermContext l;
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_term);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN:
			case QUOTED_STRING:
			case VAR:
			case NUMBER:
			case UNNAMEDVAR:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				((TermContext)_localctx).a = atom();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				((TermContext)_localctx).f = function();
				}
				break;
			case SQOPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				((TermContext)_localctx).l = listterm();
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
	public static class AtomContext extends ParserRuleContext {
		public NumberstringContext n;
		public VarContext v;
		public ArithexprContext a;
		public StringtermContext s;
		public NumberstringContext numberstring() {
			return getRuleContext(NumberstringContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(LogicalFmlasParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(LogicalFmlasParser.CLOSE, 0); }
		public ArithexprContext arithexpr() {
			return getRuleContext(ArithexprContext.class,0);
		}
		public StringtermContext stringterm() {
			return getRuleContext(StringtermContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_atom);
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				((AtomContext)_localctx).n = numberstring();
				}
				break;
			case VAR:
			case UNNAMEDVAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				((AtomContext)_localctx).v = var();
				}
				break;
			case OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				match(OPEN);
				setState(133);
				((AtomContext)_localctx).a = arithexpr();
				setState(134);
				match(CLOSE);
				}
				break;
			case QUOTED_STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(136);
				((AtomContext)_localctx).s = stringterm();
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
	public static class StringtermContext extends ParserRuleContext {
		public TerminalNode QUOTED_STRING() { return getToken(LogicalFmlasParser.QUOTED_STRING, 0); }
		public StringtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringterm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitStringterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringtermContext stringterm() throws RecognitionException {
		StringtermContext _localctx = new StringtermContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stringterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(QUOTED_STRING);
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
	public static class ListtermContext extends ParserRuleContext {
		public ListheadsContext hl;
		public VarContext v;
		public TerminalNode SQOPEN() { return getToken(LogicalFmlasParser.SQOPEN, 0); }
		public TerminalNode SQCLOSE() { return getToken(LogicalFmlasParser.SQCLOSE, 0); }
		public ListheadsContext listheads() {
			return getRuleContext(ListheadsContext.class,0);
		}
		public TerminalNode BAR() { return getToken(LogicalFmlasParser.BAR, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ListtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listterm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitListterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListtermContext listterm() throws RecognitionException {
		ListtermContext _localctx = new ListtermContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_listterm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(SQOPEN);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33802400L) != 0)) {
				{
				setState(142);
				((ListtermContext)_localctx).hl = listheads();
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BAR) {
					{
					setState(143);
					match(BAR);
					setState(144);
					((ListtermContext)_localctx).v = var();
					}
				}

				}
			}

			setState(149);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ListheadsContext extends ParserRuleContext {
		public TermContext t1;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LogicalFmlasParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LogicalFmlasParser.COMMA, i);
		}
		public ListheadsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listheads; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitListheads(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListheadsContext listheads() throws RecognitionException {
		ListheadsContext _localctx = new ListheadsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_listheads);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			((ListheadsContext)_localctx).t1 = term();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(152);
				match(COMMA);
				setState(153);
				term();
				}
				}
				setState(158);
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
	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LogicalFmlasParser.VAR, 0); }
		public TerminalNode UNNAMEDVAR() { return getToken(LogicalFmlasParser.UNNAMEDVAR, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if ( !(_la==VAR || _la==UNNAMEDVAR) ) {
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
	public static class NumberstringContext extends ParserRuleContext {
		public Token n1;
		public Token n2;
		public TerminalNode MINUS() { return getToken(LogicalFmlasParser.MINUS, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(LogicalFmlasParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(LogicalFmlasParser.NUMBER, i);
		}
		public TerminalNode POINT() { return getToken(LogicalFmlasParser.POINT, 0); }
		public NumberstringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberstring; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitNumberstring(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberstringContext numberstring() throws RecognitionException {
		NumberstringContext _localctx = new NumberstringContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_numberstring);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(161);
				match(MINUS);
				}
			}

			{
			setState(164);
			((NumberstringContext)_localctx).n1 = match(NUMBER);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==POINT) {
				{
				setState(165);
				match(POINT);
				setState(166);
				((NumberstringContext)_localctx).n2 = match(NUMBER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EquationContext extends ParserRuleContext {
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitEquation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EquationContext equation() throws RecognitionException {
		EquationContext _localctx = new EquationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_equation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			((EquationContext)_localctx).a1 = arithexpr();
			setState(170);
			((EquationContext)_localctx).oper = eqoper();
			setState(171);
			((EquationContext)_localctx).a2 = arithexpr();
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
	public static class EqoperContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(LogicalFmlasParser.LESS, 0); }
		public TerminalNode EQ() { return getToken(LogicalFmlasParser.EQ, 0); }
		public TerminalNode IS() { return getToken(LogicalFmlasParser.IS, 0); }
		public EqoperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqoper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitEqoper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqoperContext eqoper() throws RecognitionException {
		EqoperContext _localctx = new EqoperContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_eqoper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) ) {
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
	public static class ArithexprContext extends ParserRuleContext {
		public MultexprContext m1;
		public MultexprContext m2;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitArithexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithexprContext arithexpr() throws RecognitionException {
		ArithexprContext _localctx = new ArithexprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_arithexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			((ArithexprContext)_localctx).m1 = multexpr();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(176);
				addoper();
				setState(177);
				((ArithexprContext)_localctx).m2 = multexpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MultexprContext extends ParserRuleContext {
		public AtomContext a1;
		public AtomContext a2;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitMultexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultexprContext multexpr() throws RecognitionException {
		MultexprContext _localctx = new MultexprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_multexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			((MultexprContext)_localctx).a1 = atom();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 209715200L) != 0)) {
				{
				setState(182);
				multoper();
				setState(183);
				((MultexprContext)_localctx).a2 = atom();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AddoperContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(LogicalFmlasParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LogicalFmlasParser.MINUS, 0); }
		public AddoperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addoper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitAddoper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddoperContext addoper() throws RecognitionException {
		AddoperContext _localctx = new AddoperContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_addoper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
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
	public static class MultoperContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(LogicalFmlasParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(LogicalFmlasParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(LogicalFmlasParser.MOD, 0); }
		public MultoperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multoper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitMultoper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultoperContext multoper() throws RecognitionException {
		MultoperContext _localctx = new MultoperContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_multoper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 209715200L) != 0)) ) {
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
		"\u0004\u0001!\u00c0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0001\u0000\u0003\u00005\b\u0000\u0001\u0001\u0003\u0001"+
		"8\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002@\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003E\b\u0003\n\u0003\f\u0003H\t\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004O\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004Y\b\u0004\u0003\u0004[\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0003\u0006c\b"+
		"\u0006\u0001\u0007\u0003\u0007f\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\bl\b\b\u0001\t\u0001\t\u0003\tp\b\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\nw\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"|\b\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u0081\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u008a\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0092"+
		"\b\u000f\u0003\u000f\u0094\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u009b\b\u0010\n\u0010\f\u0010\u009e"+
		"\t\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0003\u0012\u00a3\b\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00a8\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00b4\b\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00ba\b\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001F\u0000\u0019\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.0\u0000\u0004\u0002\u0000\u000f\u000f\u0011\u0011\u0001"+
		"\u0000\u0013\u0015\u0001\u0000\u0018\u0019\u0002\u0000\u0017\u0017\u001a"+
		"\u001b\u00c2\u00002\u0001\u0000\u0000\u0000\u00027\u0001\u0000\u0000\u0000"+
		"\u00049\u0001\u0000\u0000\u0000\u0006A\u0001\u0000\u0000\u0000\bZ\u0001"+
		"\u0000\u0000\u0000\n\\\u0001\u0000\u0000\u0000\f`\u0001\u0000\u0000\u0000"+
		"\u000ee\u0001\u0000\u0000\u0000\u0010k\u0001\u0000\u0000\u0000\u0012o"+
		"\u0001\u0000\u0000\u0000\u0014q\u0001\u0000\u0000\u0000\u0016x\u0001\u0000"+
		"\u0000\u0000\u0018\u0080\u0001\u0000\u0000\u0000\u001a\u0089\u0001\u0000"+
		"\u0000\u0000\u001c\u008b\u0001\u0000\u0000\u0000\u001e\u008d\u0001\u0000"+
		"\u0000\u0000 \u0097\u0001\u0000\u0000\u0000\"\u009f\u0001\u0000\u0000"+
		"\u0000$\u00a2\u0001\u0000\u0000\u0000&\u00a9\u0001\u0000\u0000\u0000("+
		"\u00ad\u0001\u0000\u0000\u0000*\u00af\u0001\u0000\u0000\u0000,\u00b5\u0001"+
		"\u0000\u0000\u0000.\u00bb\u0001\u0000\u0000\u00000\u00bd\u0001\u0000\u0000"+
		"\u000024\u0003\u0004\u0002\u000035\u0003\u0000\u0000\u000043\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u00005\u0001\u0001\u0000\u0000\u0000"+
		"68\u0003\u0000\u0000\u000076\u0001\u0000\u0000\u000078\u0001\u0000\u0000"+
		"\u00008\u0003\u0001\u0000\u0000\u00009?\u0003\u0012\t\u0000:;\u0005\u0012"+
		"\u0000\u0000;<\u0003\u0006\u0003\u0000<=\u0005\u001e\u0000\u0000=@\u0001"+
		"\u0000\u0000\u0000>@\u0005\u001e\u0000\u0000?:\u0001\u0000\u0000\u0000"+
		"?>\u0001\u0000\u0000\u0000@\u0005\u0001\u0000\u0000\u0000AF\u0003\b\u0004"+
		"\u0000BC\u0005\u001d\u0000\u0000CE\u0003\b\u0004\u0000DB\u0001\u0000\u0000"+
		"\u0000EH\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000FD\u0001\u0000"+
		"\u0000\u0000G\u0007\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000"+
		"IO\u0003\u0012\t\u0000JK\u0005\u0007\u0000\u0000KL\u0003&\u0013\u0000"+
		"LM\u0005\b\u0000\u0000MO\u0001\u0000\u0000\u0000NI\u0001\u0000\u0000\u0000"+
		"NJ\u0001\u0000\u0000\u0000O[\u0001\u0000\u0000\u0000P[\u0005\u001c\u0000"+
		"\u0000QX\u0005\f\u0000\u0000RY\u0003\u0012\t\u0000ST\u0005\u0007\u0000"+
		"\u0000TU\u0003&\u0013\u0000UV\u0005\b\u0000\u0000VY\u0001\u0000\u0000"+
		"\u0000WY\u0003\n\u0005\u0000XR\u0001\u0000\u0000\u0000XS\u0001\u0000\u0000"+
		"\u0000XW\u0001\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000ZN\u0001\u0000"+
		"\u0000\u0000ZP\u0001\u0000\u0000\u0000ZQ\u0001\u0000\u0000\u0000[\t\u0001"+
		"\u0000\u0000\u0000\\]\u0005\u0005\u0000\u0000]^\u0003\u0006\u0003\u0000"+
		"^_\u0005\u0006\u0000\u0000_\u000b\u0001\u0000\u0000\u0000`b\u0003\u0010"+
		"\b\u0000ac\u0003\f\u0006\u0000ba\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000c\r\u0001\u0000\u0000\u0000df\u0003\f\u0006\u0000ed\u0001"+
		"\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000f\u000f\u0001\u0000\u0000"+
		"\u0000gl\u0005\r\u0000\u0000hi\u0005\f\u0000\u0000il\u0003\u0012\t\u0000"+
		"jl\u0003\u0012\t\u0000kg\u0001\u0000\u0000\u0000kh\u0001\u0000\u0000\u0000"+
		"kj\u0001\u0000\u0000\u0000l\u0011\u0001\u0000\u0000\u0000mp\u0003\"\u0011"+
		"\u0000np\u0003\u0014\n\u0000om\u0001\u0000\u0000\u0000on\u0001\u0000\u0000"+
		"\u0000p\u0013\u0001\u0000\u0000\u0000qv\u0005\u000e\u0000\u0000rs\u0005"+
		"\u0005\u0000\u0000st\u0003\u0016\u000b\u0000tu\u0005\u0006\u0000\u0000"+
		"uw\u0001\u0000\u0000\u0000vr\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000w\u0015\u0001\u0000\u0000\u0000x{\u0003\u0018\f\u0000yz\u0005\u001d"+
		"\u0000\u0000z|\u0003\u0016\u000b\u0000{y\u0001\u0000\u0000\u0000{|\u0001"+
		"\u0000\u0000\u0000|\u0017\u0001\u0000\u0000\u0000}\u0081\u0003\u001a\r"+
		"\u0000~\u0081\u0003\u0014\n\u0000\u007f\u0081\u0003\u001e\u000f\u0000"+
		"\u0080}\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u007f"+
		"\u0001\u0000\u0000\u0000\u0081\u0019\u0001\u0000\u0000\u0000\u0082\u008a"+
		"\u0003$\u0012\u0000\u0083\u008a\u0003\"\u0011\u0000\u0084\u0085\u0005"+
		"\u0005\u0000\u0000\u0085\u0086\u0003*\u0015\u0000\u0086\u0087\u0005\u0006"+
		"\u0000\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u008a\u0003\u001c"+
		"\u000e\u0000\u0089\u0082\u0001\u0000\u0000\u0000\u0089\u0083\u0001\u0000"+
		"\u0000\u0000\u0089\u0084\u0001\u0000\u0000\u0000\u0089\u0088\u0001\u0000"+
		"\u0000\u0000\u008a\u001b\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u000b"+
		"\u0000\u0000\u008c\u001d\u0001\u0000\u0000\u0000\u008d\u0093\u0005\u0007"+
		"\u0000\u0000\u008e\u0091\u0003 \u0010\u0000\u008f\u0090\u0005!\u0000\u0000"+
		"\u0090\u0092\u0003\"\u0011\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0001\u0000\u0000\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093"+
		"\u008e\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0005\b\u0000\u0000\u0096\u001f"+
		"\u0001\u0000\u0000\u0000\u0097\u009c\u0003\u0018\f\u0000\u0098\u0099\u0005"+
		"\u001d\u0000\u0000\u0099\u009b\u0003\u0018\f\u0000\u009a\u0098\u0001\u0000"+
		"\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000"+
		"\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d!\u0001\u0000\u0000"+
		"\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a0\u0007\u0000\u0000"+
		"\u0000\u00a0#\u0001\u0000\u0000\u0000\u00a1\u00a3\u0005\u0019\u0000\u0000"+
		"\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a7\u0005\u0010\u0000\u0000"+
		"\u00a5\u00a6\u0005\u0016\u0000\u0000\u00a6\u00a8\u0005\u0010\u0000\u0000"+
		"\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a8%\u0001\u0000\u0000\u0000\u00a9\u00aa\u0003*\u0015\u0000\u00aa\u00ab"+
		"\u0003(\u0014\u0000\u00ab\u00ac\u0003*\u0015\u0000\u00ac\'\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0007\u0001\u0000\u0000\u00ae)\u0001\u0000\u0000"+
		"\u0000\u00af\u00b3\u0003,\u0016\u0000\u00b0\u00b1\u0003.\u0017\u0000\u00b1"+
		"\u00b2\u0003,\u0016\u0000\u00b2\u00b4\u0001\u0000\u0000\u0000\u00b3\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4+\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b9\u0003\u001a\r\u0000\u00b6\u00b7\u00030"+
		"\u0018\u0000\u00b7\u00b8\u0003\u001a\r\u0000\u00b8\u00ba\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b6\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000"+
		"\u0000\u00ba-\u0001\u0000\u0000\u0000\u00bb\u00bc\u0007\u0002\u0000\u0000"+
		"\u00bc/\u0001\u0000\u0000\u0000\u00bd\u00be\u0007\u0003\u0000\u0000\u00be"+
		"1\u0001\u0000\u0000\u0000\u001647?FNXZbekov{\u0080\u0089\u0091\u0093\u009c"+
		"\u00a2\u00a7\u00b3\u00b9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}