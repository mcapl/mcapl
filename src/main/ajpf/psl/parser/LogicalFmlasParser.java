// Generated from /Users/louisedennis/eclipse-workspace/mcapl/src/main/ajpf/psl/parser/antlr/LogicalFmlas.g4 by ANTLR 4.7
package ajpf.psl.parser;
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
		CONST=14, VAR=15, NUMBER=16, UNNAMEDVAR=17, RULEARROW=18, LESS=19, EQ=20, 
		POINT=21, MULT=22, PLUS=23, MINUS=24, DIV=25, MOD=26, SHRIEK=27, COMMA=28, 
		SEMI=29, COLON=30, QUERY=31, BAR=32;
	public static final int
		RULE_rulelist = 0, RULE_rulelist_poss_empty = 1, RULE_prolog_rule = 2, 
		RULE_logicalfmla = 3, RULE_notfmla = 4, RULE_subfmla = 5, RULE_litlist = 6, 
		RULE_litlist_poss_empty = 7, RULE_literal = 8, RULE_pred = 9, RULE_function = 10, 
		RULE_terms = 11, RULE_term = 12, RULE_atom = 13, RULE_stringterm = 14, 
		RULE_listterm = 15, RULE_listheads = 16, RULE_var = 17, RULE_numberstring = 18, 
		RULE_equation = 19, RULE_eqoper = 20, RULE_arithexpr = 21, RULE_multexpr = 22, 
		RULE_addoper = 23, RULE_multoper = 24;
	public static final String[] ruleNames = {
		"rulelist", "rulelist_poss_empty", "prolog_rule", "logicalfmla", "notfmla", 
		"subfmla", "litlist", "litlist_poss_empty", "literal", "pred", "function", 
		"terms", "term", "atom", "stringterm", "listterm", "listheads", "var", 
		"numberstring", "equation", "eqoper", "arithexpr", "multexpr", "addoper", 
		"multoper"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", 
		null, "'~'", "'True'", null, null, null, "'_'", "':-'", "'<'", "'=='", 
		"'.'", "'*'", "'+'", "'-'", "'/'", "'%'", "'!'", "','", "';'", "':'", 
		"'?'", "'|'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "OPEN", "CLOSE", "SQOPEN", 
		"SQCLOSE", "CURLYOPEN", "CURLYCLOSE", "QUOTED_STRING", "NOT", "TRUE", 
		"CONST", "VAR", "NUMBER", "UNNAMEDVAR", "RULEARROW", "LESS", "EQ", "POINT", 
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
			setState(50);
			prolog_rule();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << VAR) | (1L << UNNAMEDVAR))) != 0)) {
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << VAR) | (1L << UNNAMEDVAR))) != 0)) {
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << TRUE) | (1L << CONST) | (1L << VAR) | (1L << UNNAMEDVAR))) != 0)) {
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << TRUE) | (1L << CONST) | (1L << VAR) | (1L << UNNAMEDVAR))) != 0)) {
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << SQOPEN) | (1L << QUOTED_STRING) | (1L << CONST) | (1L << VAR) | (1L << NUMBER) | (1L << UNNAMEDVAR) | (1L << MINUS))) != 0)) {
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
		enterRule(_localctx, 40, RULE_eqoper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00c2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\5\2\67\n\2\3\3\5\3:\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"B\n\4\3\5\3\5\3\5\7\5G\n\5\f\5\16\5J\13\5\3\6\3\6\3\6\3\6\3\6\5\6Q\n\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6[\n\6\5\6]\n\6\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\5\be\n\b\3\t\5\th\n\t\3\n\3\n\3\n\3\n\5\nn\n\n\3\13\3\13\5\13r\n"+
		"\13\3\f\3\f\3\f\3\f\3\f\5\fy\n\f\3\r\3\r\3\r\5\r~\n\r\3\16\3\16\3\16\5"+
		"\16\u0083\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u008c\n\17\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\5\21\u0094\n\21\5\21\u0096\n\21\3\21\3\21\3"+
		"\22\3\22\3\22\7\22\u009d\n\22\f\22\16\22\u00a0\13\22\3\23\3\23\3\24\5"+
		"\24\u00a5\n\24\3\24\3\24\3\24\5\24\u00aa\n\24\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\5\27\u00b6\n\27\3\30\3\30\3\30\3\30\5\30\u00bc"+
		"\n\30\3\31\3\31\3\32\3\32\3\32\3H\2\33\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\2\6\4\2\21\21\23\23\3\2\25\26\3\2\31\32\4\2\30\30"+
		"\33\34\2\u00c4\2\64\3\2\2\2\49\3\2\2\2\6;\3\2\2\2\bC\3\2\2\2\n\\\3\2\2"+
		"\2\f^\3\2\2\2\16b\3\2\2\2\20g\3\2\2\2\22m\3\2\2\2\24q\3\2\2\2\26s\3\2"+
		"\2\2\30z\3\2\2\2\32\u0082\3\2\2\2\34\u008b\3\2\2\2\36\u008d\3\2\2\2 \u008f"+
		"\3\2\2\2\"\u0099\3\2\2\2$\u00a1\3\2\2\2&\u00a4\3\2\2\2(\u00ab\3\2\2\2"+
		"*\u00af\3\2\2\2,\u00b1\3\2\2\2.\u00b7\3\2\2\2\60\u00bd\3\2\2\2\62\u00bf"+
		"\3\2\2\2\64\66\5\6\4\2\65\67\5\2\2\2\66\65\3\2\2\2\66\67\3\2\2\2\67\3"+
		"\3\2\2\28:\5\2\2\298\3\2\2\29:\3\2\2\2:\5\3\2\2\2;A\5\24\13\2<=\7\24\2"+
		"\2=>\5\b\5\2>?\7\37\2\2?B\3\2\2\2@B\7\37\2\2A<\3\2\2\2A@\3\2\2\2B\7\3"+
		"\2\2\2CH\5\n\6\2DE\7\36\2\2EG\5\n\6\2FD\3\2\2\2GJ\3\2\2\2HI\3\2\2\2HF"+
		"\3\2\2\2I\t\3\2\2\2JH\3\2\2\2KQ\5\24\13\2LM\7\t\2\2MN\5(\25\2NO\7\n\2"+
		"\2OQ\3\2\2\2PK\3\2\2\2PL\3\2\2\2Q]\3\2\2\2R]\7\35\2\2SZ\7\16\2\2T[\5\24"+
		"\13\2UV\7\t\2\2VW\5(\25\2WX\7\n\2\2X[\3\2\2\2Y[\5\f\7\2ZT\3\2\2\2ZU\3"+
		"\2\2\2ZY\3\2\2\2[]\3\2\2\2\\P\3\2\2\2\\R\3\2\2\2\\S\3\2\2\2]\13\3\2\2"+
		"\2^_\7\7\2\2_`\5\b\5\2`a\7\b\2\2a\r\3\2\2\2bd\5\22\n\2ce\5\16\b\2dc\3"+
		"\2\2\2de\3\2\2\2e\17\3\2\2\2fh\5\16\b\2gf\3\2\2\2gh\3\2\2\2h\21\3\2\2"+
		"\2in\7\17\2\2jk\7\16\2\2kn\5\24\13\2ln\5\24\13\2mi\3\2\2\2mj\3\2\2\2m"+
		"l\3\2\2\2n\23\3\2\2\2or\5$\23\2pr\5\26\f\2qo\3\2\2\2qp\3\2\2\2r\25\3\2"+
		"\2\2sx\7\20\2\2tu\7\7\2\2uv\5\30\r\2vw\7\b\2\2wy\3\2\2\2xt\3\2\2\2xy\3"+
		"\2\2\2y\27\3\2\2\2z}\5\32\16\2{|\7\36\2\2|~\5\30\r\2}{\3\2\2\2}~\3\2\2"+
		"\2~\31\3\2\2\2\177\u0083\5\34\17\2\u0080\u0083\5\26\f\2\u0081\u0083\5"+
		" \21\2\u0082\177\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083"+
		"\33\3\2\2\2\u0084\u008c\5&\24\2\u0085\u008c\5$\23\2\u0086\u0087\7\7\2"+
		"\2\u0087\u0088\5,\27\2\u0088\u0089\7\b\2\2\u0089\u008c\3\2\2\2\u008a\u008c"+
		"\5\36\20\2\u008b\u0084\3\2\2\2\u008b\u0085\3\2\2\2\u008b\u0086\3\2\2\2"+
		"\u008b\u008a\3\2\2\2\u008c\35\3\2\2\2\u008d\u008e\7\r\2\2\u008e\37\3\2"+
		"\2\2\u008f\u0095\7\t\2\2\u0090\u0093\5\"\22\2\u0091\u0092\7\"\2\2\u0092"+
		"\u0094\5$\23\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2"+
		"\2\2\u0095\u0090\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\7\n\2\2\u0098!\3\2\2\2\u0099\u009e\5\32\16\2\u009a\u009b\7\36\2"+
		"\2\u009b\u009d\5\32\16\2\u009c\u009a\3\2\2\2\u009d\u00a0\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f#\3\2\2\2\u00a0\u009e\3\2\2\2"+
		"\u00a1\u00a2\t\2\2\2\u00a2%\3\2\2\2\u00a3\u00a5\7\32\2\2\u00a4\u00a3\3"+
		"\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a9\7\22\2\2\u00a7"+
		"\u00a8\7\27\2\2\u00a8\u00aa\7\22\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3"+
		"\2\2\2\u00aa\'\3\2\2\2\u00ab\u00ac\5,\27\2\u00ac\u00ad\5*\26\2\u00ad\u00ae"+
		"\5,\27\2\u00ae)\3\2\2\2\u00af\u00b0\t\3\2\2\u00b0+\3\2\2\2\u00b1\u00b5"+
		"\5.\30\2\u00b2\u00b3\5\60\31\2\u00b3\u00b4\5.\30\2\u00b4\u00b6\3\2\2\2"+
		"\u00b5\u00b2\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6-\3\2\2\2\u00b7\u00bb\5"+
		"\34\17\2\u00b8\u00b9\5\62\32\2\u00b9\u00ba\5\34\17\2\u00ba\u00bc\3\2\2"+
		"\2\u00bb\u00b8\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc/\3\2\2\2\u00bd\u00be"+
		"\t\4\2\2\u00be\61\3\2\2\2\u00bf\u00c0\t\5\2\2\u00c0\63\3\2\2\2\30\669"+
		"AHPZ\\dgmqx}\u0082\u008b\u0093\u0095\u009e\u00a4\u00a9\u00b5\u00bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}