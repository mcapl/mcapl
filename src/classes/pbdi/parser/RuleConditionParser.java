// Generated from RuleCondition.g4 by ANTLR 4.7
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
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, BELIEVE=2, NOT=3, SHORT_BELIEVE=4, WORD=5, SINGLE_QUOTE=6, OPEN_BRACKET=7, 
		CLOSE_BRACKET=8, DOT=9;
	public static final int
		RULE_rule_condition = 0, RULE_not_expr = 1, RULE_belief_expression = 2, 
		RULE_dot_expr = 3;
	public static final String[] ruleNames = {
		"rule_condition", "not_expr", "belief_expression", "dot_expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'believe'", "'NOT'", "'B'", null, "'''", "'('", "')'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "BELIEVE", "NOT", "SHORT_BELIEVE", "WORD", "SINGLE_QUOTE", 
		"OPEN_BRACKET", "CLOSE_BRACKET", "DOT"
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
	public static class Rule_conditionContext extends ParserRuleContext {
		public Not_exprContext not_expr() {
			return getRuleContext(Not_exprContext.class,0);
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
			setState(8);
			not_expr();
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
		enterRule(_localctx, 2, RULE_not_expr);
		try {
			setState(18);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				dot_expr();
				setState(11);
				match(DOT);
				setState(12);
				match(NOT);
				setState(13);
				match(OPEN_BRACKET);
				setState(14);
				rule_condition();
				setState(15);
				match(CLOSE_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
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
		enterRule(_localctx, 4, RULE_belief_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			dot_expr();
			setState(21);
			match(DOT);
			setState(22);
			_la = _input.LA(1);
			if ( !(_la==BELIEVE || _la==SHORT_BELIEVE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(23);
			match(OPEN_BRACKET);
			setState(24);
			match(SINGLE_QUOTE);
			setState(25);
			match(WORD);
			setState(26);
			match(SINGLE_QUOTE);
			setState(27);
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
		enterRule(_localctx, 6, RULE_dot_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(WORD);
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(30);
					match(DOT);
					setState(31);
					match(WORD);
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13(\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\25\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5#\n\5\f\5\16\5&\13"+
		"\5\3\5\2\2\6\2\4\6\b\2\3\4\2\4\4\6\6\2%\2\n\3\2\2\2\4\24\3\2\2\2\6\26"+
		"\3\2\2\2\b\37\3\2\2\2\n\13\5\4\3\2\13\3\3\2\2\2\f\r\5\b\5\2\r\16\7\13"+
		"\2\2\16\17\7\5\2\2\17\20\7\t\2\2\20\21\5\2\2\2\21\22\7\n\2\2\22\25\3\2"+
		"\2\2\23\25\5\6\4\2\24\f\3\2\2\2\24\23\3\2\2\2\25\5\3\2\2\2\26\27\5\b\5"+
		"\2\27\30\7\13\2\2\30\31\t\2\2\2\31\32\7\t\2\2\32\33\7\b\2\2\33\34\7\7"+
		"\2\2\34\35\7\b\2\2\35\36\7\n\2\2\36\7\3\2\2\2\37$\7\7\2\2 !\7\13\2\2!"+
		"#\7\7\2\2\" \3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\t\3\2\2\2&$\3\2\2"+
		"\2\4\24$";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}