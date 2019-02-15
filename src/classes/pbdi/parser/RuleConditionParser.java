// Generated from RuleCondition.g4 by ANTLR 4.4
package pbdi.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RuleConditionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, BELIEVE=2, NOT=3, AND=4, SHORT_BELIEVE=5, WORD=6, SINGLE_QUOTE=7, 
		OPEN_BRACKET=8, CLOSE_BRACKET=9, DOT=10, COMMA=11;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "'believe'", "'NOT'", "'AND'", "'B'", "WORD", "'''", 
		"'('", "')'", "'.'", "','"
	};
	public static final int
		RULE_rule_condition = 0, RULE_and_expr = 1, RULE_not_expr = 2, RULE_belief_expression = 3, 
		RULE_dot_expr = 4;
	public static final String[] ruleNames = {
		"rule_condition", "and_expr", "not_expr", "belief_expression", "dot_expr"
	};

	@Override
	public String getGrammarFileName() { return "RuleCondition.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RuleConditionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Rule_conditionContext extends ParserRuleContext {
		public And_exprContext and_expr() {
			return getRuleContext(And_exprContext.class,0);
		}
		public Rule_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleConditionVisitor ) return ((RuleConditionVisitor<? extends T>)visitor).visitRule_condition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rule_conditionContext rule_condition() throws RecognitionException {
		Rule_conditionContext _localctx = new Rule_conditionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rule_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); and_expr();
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

	public static class And_exprContext extends ParserRuleContext {
		public Dot_exprContext dot_expr() {
			return getRuleContext(Dot_exprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(RuleConditionParser.DOT, 0); }
		public List<Rule_conditionContext> rule_condition() {
			return getRuleContexts(Rule_conditionContext.class);
		}
		public Rule_conditionContext rule_condition(int i) {
			return getRuleContext(Rule_conditionContext.class,i);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(RuleConditionParser.OPEN_BRACKET, 0); }
		public TerminalNode COMMA() { return getToken(RuleConditionParser.COMMA, 0); }
		public TerminalNode AND() { return getToken(RuleConditionParser.AND, 0); }
		public Not_exprContext not_expr() {
			return getRuleContext(Not_exprContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(RuleConditionParser.CLOSE_BRACKET, 0); }
		public And_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleConditionVisitor ) return ((RuleConditionVisitor<? extends T>)visitor).visitAnd_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_exprContext and_expr() throws RecognitionException {
		And_exprContext _localctx = new And_exprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_and_expr);
		try {
			setState(22);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(12); dot_expr();
				setState(13); match(DOT);
				setState(14); match(AND);
				setState(15); match(OPEN_BRACKET);
				setState(16); rule_condition();
				setState(17); match(COMMA);
				setState(18); rule_condition();
				setState(19); match(CLOSE_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(21); not_expr();
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

	public static class Not_exprContext extends ParserRuleContext {
		public Dot_exprContext dot_expr() {
			return getRuleContext(Dot_exprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(RuleConditionParser.NOT, 0); }
		public TerminalNode DOT() { return getToken(RuleConditionParser.DOT, 0); }
		public Rule_conditionContext rule_condition() {
			return getRuleContext(Rule_conditionContext.class,0);
		}
		public Belief_expressionContext belief_expression() {
			return getRuleContext(Belief_expressionContext.class,0);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(RuleConditionParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(RuleConditionParser.CLOSE_BRACKET, 0); }
		public Not_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleConditionVisitor ) return ((RuleConditionVisitor<? extends T>)visitor).visitNot_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Not_exprContext not_expr() throws RecognitionException {
		Not_exprContext _localctx = new Not_exprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_not_expr);
		try {
			setState(32);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24); dot_expr();
				setState(25); match(DOT);
				setState(26); match(NOT);
				setState(27); match(OPEN_BRACKET);
				setState(28); rule_condition();
				setState(29); match(CLOSE_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31); belief_expression();
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

	public static class Belief_expressionContext extends ParserRuleContext {
		public Dot_exprContext dot_expr() {
			return getRuleContext(Dot_exprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(RuleConditionParser.DOT, 0); }
		public TerminalNode SINGLE_QUOTE(int i) {
			return getToken(RuleConditionParser.SINGLE_QUOTE, i);
		}
		public TerminalNode WORD() { return getToken(RuleConditionParser.WORD, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(RuleConditionParser.OPEN_BRACKET, 0); }
		public TerminalNode BELIEVE() { return getToken(RuleConditionParser.BELIEVE, 0); }
		public TerminalNode SHORT_BELIEVE() { return getToken(RuleConditionParser.SHORT_BELIEVE, 0); }
		public List<TerminalNode> SINGLE_QUOTE() { return getTokens(RuleConditionParser.SINGLE_QUOTE); }
		public TerminalNode CLOSE_BRACKET() { return getToken(RuleConditionParser.CLOSE_BRACKET, 0); }
		public Belief_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_belief_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleConditionVisitor ) return ((RuleConditionVisitor<? extends T>)visitor).visitBelief_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Belief_expressionContext belief_expression() throws RecognitionException {
		Belief_expressionContext _localctx = new Belief_expressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_belief_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); dot_expr();
			setState(35); match(DOT);
			setState(36);
			_la = _input.LA(1);
			if ( !(_la==BELIEVE || _la==SHORT_BELIEVE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(37); match(OPEN_BRACKET);
			setState(38); match(SINGLE_QUOTE);
			setState(39); match(WORD);
			setState(40); match(SINGLE_QUOTE);
			setState(41); match(CLOSE_BRACKET);
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

	public static class Dot_exprContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(RuleConditionParser.DOT); }
		public List<TerminalNode> WORD() { return getTokens(RuleConditionParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(RuleConditionParser.WORD, i);
		}
		public TerminalNode DOT(int i) {
			return getToken(RuleConditionParser.DOT, i);
		}
		public Dot_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleConditionVisitor ) return ((RuleConditionVisitor<? extends T>)visitor).visitDot_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dot_exprContext dot_expr() throws RecognitionException {
		Dot_exprContext _localctx = new Dot_exprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dot_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(43); match(WORD);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(44); match(DOT);
					setState(45); match(WORD);
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\r\66\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3\31\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4#\n\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6\61\n\6\f\6\16\6\64\13\6\3\6\2"+
		"\2\7\2\4\6\b\n\2\3\4\2\4\4\7\7\63\2\f\3\2\2\2\4\30\3\2\2\2\6\"\3\2\2\2"+
		"\b$\3\2\2\2\n-\3\2\2\2\f\r\5\4\3\2\r\3\3\2\2\2\16\17\5\n\6\2\17\20\7\f"+
		"\2\2\20\21\7\6\2\2\21\22\7\n\2\2\22\23\5\2\2\2\23\24\7\r\2\2\24\25\5\2"+
		"\2\2\25\26\7\13\2\2\26\31\3\2\2\2\27\31\5\6\4\2\30\16\3\2\2\2\30\27\3"+
		"\2\2\2\31\5\3\2\2\2\32\33\5\n\6\2\33\34\7\f\2\2\34\35\7\5\2\2\35\36\7"+
		"\n\2\2\36\37\5\2\2\2\37 \7\13\2\2 #\3\2\2\2!#\5\b\5\2\"\32\3\2\2\2\"!"+
		"\3\2\2\2#\7\3\2\2\2$%\5\n\6\2%&\7\f\2\2&\'\t\2\2\2\'(\7\n\2\2()\7\t\2"+
		"\2)*\7\b\2\2*+\7\t\2\2+,\7\13\2\2,\t\3\2\2\2-\62\7\b\2\2./\7\f\2\2/\61"+
		"\7\b\2\2\60.\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\13\3"+
		"\2\2\2\64\62\3\2\2\2\5\30\"\62";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}