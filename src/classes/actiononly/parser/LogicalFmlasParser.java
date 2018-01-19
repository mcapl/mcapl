// Generated from LogicalFmlas.g4 by ANTLR 4.7
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
public class LogicalFmlasParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LINE_COMMENT=2, NEWLINE=3, WS=4, OPEN=5, CLOSE=6, SQOPEN=7, 
		SQCLOSE=8, CURLYOPEN=9, CURLYCLOSE=10, QUOTED_STRING=11, NOT=12, TRUE=13, 
		CONST=14, VAR=15, NUMBER=16, RULEARROW=17, LESS=18, EQ=19, POINT=20, MULT=21, 
		PLUS=22, MINUS=23, DIV=24, MOD=25, SHRIEK=26, COMMA=27, SEMI=28, COLON=29, 
		QUERY=30;
	public static final int
		RULE_rulelist = 0, RULE_rulelist_poss_empty = 1, RULE_prolog_rule = 2, 
		RULE_logicalfmla = 3, RULE_notfmla = 4, RULE_subfmla = 5, RULE_litlist = 6, 
		RULE_litlist_poss_empty = 7, RULE_literal = 8, RULE_pred = 9, RULE_function = 10, 
		RULE_terms = 11, RULE_term = 12, RULE_atom = 13, RULE_stringterm = 14, 
		RULE_var = 15, RULE_numberstring = 16, RULE_equation = 17, RULE_eqoper = 18, 
		RULE_arithexpr = 19, RULE_multexpr = 20, RULE_addoper = 21, RULE_multoper = 22;
	public static final String[] ruleNames = {
		"rulelist", "rulelist_poss_empty", "prolog_rule", "logicalfmla", "notfmla", 
		"subfmla", "litlist", "litlist_poss_empty", "literal", "pred", "function", 
		"terms", "term", "atom", "stringterm", "var", "numberstring", "equation", 
		"eqoper", "arithexpr", "multexpr", "addoper", "multoper"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", 
		null, "'~'", "'True'", null, null, null, "':-'", "'<'", "'=='", "'.'", 
		"'*'", "'+'", "'-'", "'/'", "'%'", "'!'", "','", "';'", "':'", "'?'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "OPEN", "CLOSE", "SQOPEN", 
		"SQCLOSE", "CURLYOPEN", "CURLYCLOSE", "QUOTED_STRING", "NOT", "TRUE", 
		"CONST", "VAR", "NUMBER", "RULEARROW", "LESS", "EQ", "POINT", "MULT", 
		"PLUS", "MINUS", "DIV", "MOD", "SHRIEK", "COMMA", "SEMI", "COLON", "QUERY"
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
			setState(46);
			prolog_rule();
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST || _la==VAR) {
				{
				setState(47);
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
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST || _la==VAR) {
				{
				setState(50);
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
			setState(53);
			((Prolog_ruleContext)_localctx).head = pred();
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RULEARROW:
				{
				setState(54);
				match(RULEARROW);
				setState(55);
				((Prolog_ruleContext)_localctx).f = logicalfmla();
				setState(56);
				match(SEMI);
				}
				break;
			case SEMI:
				{
				setState(58);
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
			setState(61);
			((LogicalfmlaContext)_localctx).n = notfmla();
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(62);
					match(COMMA);
					setState(63);
					((LogicalfmlaContext)_localctx).n2 = notfmla();
					}
					} 
				}
				setState(68);
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

	public static class NotfmlaContext extends ParserRuleContext {
		public PredContext gb;
		public EquationContext eq;
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
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SQOPEN:
			case CONST:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CONST:
				case VAR:
					{
					setState(69);
					((NotfmlaContext)_localctx).gb = pred();
					}
					break;
				case SQOPEN:
					{
					setState(70);
					match(SQOPEN);
					setState(71);
					((NotfmlaContext)_localctx).eq = equation();
					setState(72);
					match(SQCLOSE);
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
				setState(76);
				match(NOT);
				setState(83);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CONST:
				case VAR:
					{
					setState(77);
					((NotfmlaContext)_localctx).gb2 = pred();
					}
					break;
				case SQOPEN:
					{
					setState(78);
					match(SQOPEN);
					setState(79);
					((NotfmlaContext)_localctx).eq2 = equation();
					setState(80);
					match(SQCLOSE);
					}
					break;
				case OPEN:
					{
					setState(82);
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
			setState(87);
			match(OPEN);
			setState(88);
			((SubfmlaContext)_localctx).lf = logicalfmla();
			setState(89);
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
			setState(91);
			literal();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << TRUE) | (1L << CONST) | (1L << VAR))) != 0)) {
				{
				setState(92);
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
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << TRUE) | (1L << CONST) | (1L << VAR))) != 0)) {
				{
				setState(95);
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
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				{
				setState(98);
				match(TRUE);
				}
				break;
			case NOT:
				{
				setState(99);
				match(NOT);
				setState(100);
				pred();
				}
				break;
			case CONST:
			case VAR:
				{
				setState(101);
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
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				((PredContext)_localctx).v = var();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
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
			setState(108);
			match(CONST);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN) {
				{
				setState(109);
				match(OPEN);
				setState(110);
				terms();
				setState(111);
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
			setState(115);
			((TermsContext)_localctx).t = term();
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(116);
				match(COMMA);
				setState(117);
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

	public static class TermContext extends ParserRuleContext {
		public AtomContext a;
		public StringtermContext s;
		public FunctionContext f;
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public StringtermContext stringterm() {
			return getRuleContext(StringtermContext.class,0);
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
			if ( visitor instanceof LogicalFmlasVisitor ) return ((LogicalFmlasVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_term);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN:
			case VAR:
			case NUMBER:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				((TermContext)_localctx).a = atom();
				}
				break;
			case QUOTED_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				((TermContext)_localctx).s = stringterm();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				((TermContext)_localctx).f = function();
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
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				((AtomContext)_localctx).n = numberstring();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				((AtomContext)_localctx).v = var();
				}
				break;
			case OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(OPEN);
				setState(128);
				((AtomContext)_localctx).a = arithexpr();
				setState(129);
				match(CLOSE);
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
			setState(133);
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LogicalFmlasParser.VAR, 0); }
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
		enterRule(_localctx, 30, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(VAR);
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
		enterRule(_localctx, 32, RULE_numberstring);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(137);
				match(MINUS);
				}
			}

			{
			setState(140);
			((NumberstringContext)_localctx).n1 = match(NUMBER);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==POINT) {
				{
				setState(141);
				match(POINT);
				setState(142);
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
		enterRule(_localctx, 34, RULE_equation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			((EquationContext)_localctx).a1 = arithexpr();
			setState(146);
			((EquationContext)_localctx).oper = eqoper();
			setState(147);
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

	public static class EqoperContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(LogicalFmlasParser.LESS, 0); }
		public TerminalNode EQ() { return getToken(LogicalFmlasParser.EQ, 0); }
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
		enterRule(_localctx, 36, RULE_eqoper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_la = _input.LA(1);
			if ( !(_la==LESS || _la==EQ) ) {
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
		enterRule(_localctx, 38, RULE_arithexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			((ArithexprContext)_localctx).m1 = multexpr();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(152);
				addoper();
				setState(153);
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
		enterRule(_localctx, 40, RULE_multexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			((MultexprContext)_localctx).a1 = atom();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) {
				{
				setState(158);
				multoper();
				setState(159);
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
		enterRule(_localctx, 42, RULE_addoper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
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
		enterRule(_localctx, 44, RULE_multoper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00aa\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\5"+
		"\2\63\n\2\3\3\5\3\66\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4>\n\4\3\5\3\5\3\5"+
		"\7\5C\n\5\f\5\16\5F\13\5\3\6\3\6\3\6\3\6\3\6\5\6M\n\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6V\n\6\5\6X\n\6\3\7\3\7\3\7\3\7\3\b\3\b\5\b`\n\b\3\t\5"+
		"\tc\n\t\3\n\3\n\3\n\3\n\5\ni\n\n\3\13\3\13\5\13m\n\13\3\f\3\f\3\f\3\f"+
		"\3\f\5\ft\n\f\3\r\3\r\3\r\5\ry\n\r\3\16\3\16\3\16\5\16~\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u0086\n\17\3\20\3\20\3\21\3\21\3\22\5\22\u008d"+
		"\n\22\3\22\3\22\3\22\5\22\u0092\n\22\3\23\3\23\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\5\25\u009e\n\25\3\26\3\26\3\26\3\26\5\26\u00a4\n\26\3"+
		"\27\3\27\3\30\3\30\3\30\3D\2\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\2\5\3\2\24\25\3\2\30\31\4\2\27\27\32\33\2\u00a9\2\60\3\2\2\2"+
		"\4\65\3\2\2\2\6\67\3\2\2\2\b?\3\2\2\2\nW\3\2\2\2\fY\3\2\2\2\16]\3\2\2"+
		"\2\20b\3\2\2\2\22h\3\2\2\2\24l\3\2\2\2\26n\3\2\2\2\30u\3\2\2\2\32}\3\2"+
		"\2\2\34\u0085\3\2\2\2\36\u0087\3\2\2\2 \u0089\3\2\2\2\"\u008c\3\2\2\2"+
		"$\u0093\3\2\2\2&\u0097\3\2\2\2(\u0099\3\2\2\2*\u009f\3\2\2\2,\u00a5\3"+
		"\2\2\2.\u00a7\3\2\2\2\60\62\5\6\4\2\61\63\5\2\2\2\62\61\3\2\2\2\62\63"+
		"\3\2\2\2\63\3\3\2\2\2\64\66\5\2\2\2\65\64\3\2\2\2\65\66\3\2\2\2\66\5\3"+
		"\2\2\2\67=\5\24\13\289\7\23\2\29:\5\b\5\2:;\7\36\2\2;>\3\2\2\2<>\7\36"+
		"\2\2=8\3\2\2\2=<\3\2\2\2>\7\3\2\2\2?D\5\n\6\2@A\7\35\2\2AC\5\n\6\2B@\3"+
		"\2\2\2CF\3\2\2\2DE\3\2\2\2DB\3\2\2\2E\t\3\2\2\2FD\3\2\2\2GM\5\24\13\2"+
		"HI\7\t\2\2IJ\5$\23\2JK\7\n\2\2KM\3\2\2\2LG\3\2\2\2LH\3\2\2\2MX\3\2\2\2"+
		"NU\7\16\2\2OV\5\24\13\2PQ\7\t\2\2QR\5$\23\2RS\7\n\2\2SV\3\2\2\2TV\5\f"+
		"\7\2UO\3\2\2\2UP\3\2\2\2UT\3\2\2\2VX\3\2\2\2WL\3\2\2\2WN\3\2\2\2X\13\3"+
		"\2\2\2YZ\7\7\2\2Z[\5\b\5\2[\\\7\b\2\2\\\r\3\2\2\2]_\5\22\n\2^`\5\16\b"+
		"\2_^\3\2\2\2_`\3\2\2\2`\17\3\2\2\2ac\5\16\b\2ba\3\2\2\2bc\3\2\2\2c\21"+
		"\3\2\2\2di\7\17\2\2ef\7\16\2\2fi\5\24\13\2gi\5\24\13\2hd\3\2\2\2he\3\2"+
		"\2\2hg\3\2\2\2i\23\3\2\2\2jm\5 \21\2km\5\26\f\2lj\3\2\2\2lk\3\2\2\2m\25"+
		"\3\2\2\2ns\7\20\2\2op\7\7\2\2pq\5\30\r\2qr\7\b\2\2rt\3\2\2\2so\3\2\2\2"+
		"st\3\2\2\2t\27\3\2\2\2ux\5\32\16\2vw\7\35\2\2wy\5\30\r\2xv\3\2\2\2xy\3"+
		"\2\2\2y\31\3\2\2\2z~\5\34\17\2{~\5\36\20\2|~\5\26\f\2}z\3\2\2\2}{\3\2"+
		"\2\2}|\3\2\2\2~\33\3\2\2\2\177\u0086\5\"\22\2\u0080\u0086\5 \21\2\u0081"+
		"\u0082\7\7\2\2\u0082\u0083\5(\25\2\u0083\u0084\7\b\2\2\u0084\u0086\3\2"+
		"\2\2\u0085\177\3\2\2\2\u0085\u0080\3\2\2\2\u0085\u0081\3\2\2\2\u0086\35"+
		"\3\2\2\2\u0087\u0088\7\r\2\2\u0088\37\3\2\2\2\u0089\u008a\7\21\2\2\u008a"+
		"!\3\2\2\2\u008b\u008d\7\31\2\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2"+
		"\u008d\u008e\3\2\2\2\u008e\u0091\7\22\2\2\u008f\u0090\7\26\2\2\u0090\u0092"+
		"\7\22\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092#\3\2\2\2\u0093"+
		"\u0094\5(\25\2\u0094\u0095\5&\24\2\u0095\u0096\5(\25\2\u0096%\3\2\2\2"+
		"\u0097\u0098\t\2\2\2\u0098\'\3\2\2\2\u0099\u009d\5*\26\2\u009a\u009b\5"+
		",\27\2\u009b\u009c\5*\26\2\u009c\u009e\3\2\2\2\u009d\u009a\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e)\3\2\2\2\u009f\u00a3\5\34\17\2\u00a0\u00a1\5.\30"+
		"\2\u00a1\u00a2\5\34\17\2\u00a2\u00a4\3\2\2\2\u00a3\u00a0\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4+\3\2\2\2\u00a5\u00a6\t\3\2\2\u00a6-\3\2\2\2\u00a7"+
		"\u00a8\t\4\2\2\u00a8/\3\2\2\2\25\62\65=DLUW_bhlsx}\u0085\u008c\u0091\u009d"+
		"\u00a3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}