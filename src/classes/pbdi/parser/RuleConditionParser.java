// Generated from /Users/louisedennis/IdeaProjects/mcapl/src/classes/pbdi/parser/RuleCondition.g4 by ANTLR 4.13.1
package pbdi.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RuleConditionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, BELIEVE=2, NOT=3, AND=4, SHORT_BELIEVE=5, WORD=6, SINGLE_QUOTE=7, 
		OPEN_BRACKET=8, CLOSE_BRACKET=9, DOT=10, COMMA=11;
	public static final int
		RULE_rule_condition = 0, RULE_and_expr = 1, RULE_not_expr = 2, RULE_belief_expression = 3, 
		RULE_dot_expr = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"rule_condition", "and_expr", "not_expr", "belief_expression", "dot_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'believe'", "'NOT'", "'AND'", "'B'", null, "'''", "'('", 
			"')'", "'.'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "BELIEVE", "NOT", "AND", "SHORT_BELIEVE", "WORD", "SINGLE_QUOTE", 
			"OPEN_BRACKET", "CLOSE_BRACKET", "DOT", "COMMA"
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
	public String getGrammarFileName() { return "RuleCondition.g4"; }

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

	@SuppressWarnings("CheckReturnValue")
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
			setState(10);
			and_expr();
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
	public static class And_exprContext extends ParserRuleContext {
		public Dot_exprContext dot_expr() {
			return getRuleContext(Dot_exprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(RuleConditionParser.DOT, 0); }
		public TerminalNode AND() { return getToken(RuleConditionParser.AND, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(RuleConditionParser.OPEN_BRACKET, 0); }
		public List<Rule_conditionContext> rule_condition() {
			return getRuleContexts(Rule_conditionContext.class);
		}
		public Rule_conditionContext rule_condition(int i) {
			return getRuleContext(Rule_conditionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(RuleConditionParser.COMMA, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(RuleConditionParser.CLOSE_BRACKET, 0); }
		public Not_exprContext not_expr() {
			return getRuleContext(Not_exprContext.class,0);
		}
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
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				dot_expr();
				setState(13);
				match(DOT);
				setState(14);
				match(AND);
				setState(15);
				match(OPEN_BRACKET);
				setState(16);
				rule_condition();
				setState(17);
				match(COMMA);
				setState(18);
				rule_condition();
				setState(19);
				match(CLOSE_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				not_expr();
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
	public static class Not_exprContext extends ParserRuleContext {
		public Dot_exprContext dot_expr() {
			return getRuleContext(Dot_exprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(RuleConditionParser.DOT, 0); }
		public TerminalNode NOT() { return getToken(RuleConditionParser.NOT, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(RuleConditionParser.OPEN_BRACKET, 0); }
		public Rule_conditionContext rule_condition() {
			return getRuleContext(Rule_conditionContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(RuleConditionParser.CLOSE_BRACKET, 0); }
		public Belief_expressionContext belief_expression() {
			return getRuleContext(Belief_expressionContext.class,0);
		}
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
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				dot_expr();
				setState(25);
				match(DOT);
				setState(26);
				match(NOT);
				setState(27);
				match(OPEN_BRACKET);
				setState(28);
				rule_condition();
				setState(29);
				match(CLOSE_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				belief_expression();
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
	public static class Belief_expressionContext extends ParserRuleContext {
		public Dot_exprContext dot_expr() {
			return getRuleContext(Dot_exprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(RuleConditionParser.DOT, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(RuleConditionParser.OPEN_BRACKET, 0); }
		public List<TerminalNode> SINGLE_QUOTE() { return getTokens(RuleConditionParser.SINGLE_QUOTE); }
		public TerminalNode SINGLE_QUOTE(int i) {
			return getToken(RuleConditionParser.SINGLE_QUOTE, i);
		}
		public TerminalNode WORD() { return getToken(RuleConditionParser.WORD, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(RuleConditionParser.CLOSE_BRACKET, 0); }
		public TerminalNode BELIEVE() { return getToken(RuleConditionParser.BELIEVE, 0); }
		public TerminalNode SHORT_BELIEVE() { return getToken(RuleConditionParser.SHORT_BELIEVE, 0); }
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
			setState(34);
			dot_expr();
			setState(35);
			match(DOT);
			setState(36);
			_la = _input.LA(1);
			if ( !(_la==BELIEVE || _la==SHORT_BELIEVE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(37);
			match(OPEN_BRACKET);
			setState(38);
			match(SINGLE_QUOTE);
			setState(39);
			match(WORD);
			setState(40);
			match(SINGLE_QUOTE);
			setState(41);
			match(CLOSE_BRACKET);
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
	public static class Dot_exprContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(RuleConditionParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(RuleConditionParser.WORD, i);
		}
		public List<TerminalNode> DOT() { return getTokens(RuleConditionParser.DOT); }
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
			setState(43);
			match(WORD);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(44);
					match(DOT);
					setState(45);
					match(WORD);
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
		"\u0004\u0001\u000b4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u0017\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002!\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004/\b\u0004\n\u0004\f\u00042\t\u0004\u0001\u0004\u0000\u0000\u0005"+
		"\u0000\u0002\u0004\u0006\b\u0000\u0001\u0002\u0000\u0002\u0002\u0005\u0005"+
		"1\u0000\n\u0001\u0000\u0000\u0000\u0002\u0016\u0001\u0000\u0000\u0000"+
		"\u0004 \u0001\u0000\u0000\u0000\u0006\"\u0001\u0000\u0000\u0000\b+\u0001"+
		"\u0000\u0000\u0000\n\u000b\u0003\u0002\u0001\u0000\u000b\u0001\u0001\u0000"+
		"\u0000\u0000\f\r\u0003\b\u0004\u0000\r\u000e\u0005\n\u0000\u0000\u000e"+
		"\u000f\u0005\u0004\u0000\u0000\u000f\u0010\u0005\b\u0000\u0000\u0010\u0011"+
		"\u0003\u0000\u0000\u0000\u0011\u0012\u0005\u000b\u0000\u0000\u0012\u0013"+
		"\u0003\u0000\u0000\u0000\u0013\u0014\u0005\t\u0000\u0000\u0014\u0017\u0001"+
		"\u0000\u0000\u0000\u0015\u0017\u0003\u0004\u0002\u0000\u0016\f\u0001\u0000"+
		"\u0000\u0000\u0016\u0015\u0001\u0000\u0000\u0000\u0017\u0003\u0001\u0000"+
		"\u0000\u0000\u0018\u0019\u0003\b\u0004\u0000\u0019\u001a\u0005\n\u0000"+
		"\u0000\u001a\u001b\u0005\u0003\u0000\u0000\u001b\u001c\u0005\b\u0000\u0000"+
		"\u001c\u001d\u0003\u0000\u0000\u0000\u001d\u001e\u0005\t\u0000\u0000\u001e"+
		"!\u0001\u0000\u0000\u0000\u001f!\u0003\u0006\u0003\u0000 \u0018\u0001"+
		"\u0000\u0000\u0000 \u001f\u0001\u0000\u0000\u0000!\u0005\u0001\u0000\u0000"+
		"\u0000\"#\u0003\b\u0004\u0000#$\u0005\n\u0000\u0000$%\u0007\u0000\u0000"+
		"\u0000%&\u0005\b\u0000\u0000&\'\u0005\u0007\u0000\u0000\'(\u0005\u0006"+
		"\u0000\u0000()\u0005\u0007\u0000\u0000)*\u0005\t\u0000\u0000*\u0007\u0001"+
		"\u0000\u0000\u0000+0\u0005\u0006\u0000\u0000,-\u0005\n\u0000\u0000-/\u0005"+
		"\u0006\u0000\u0000.,\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u0000"+
		"0.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001\t\u0001\u0000\u0000"+
		"\u000020\u0001\u0000\u0000\u0000\u0003\u0016 0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}