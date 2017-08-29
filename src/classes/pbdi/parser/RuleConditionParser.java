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
		WS=1, BELIEVE=2, WORD=3, SINGLE_QUOTE=4, OPEN_BRACKET=5, CLOSE_BRACKET=6, 
		DOT=7, SEMI=8;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "'believe'", "WORD", "'''", "'('", "')'", "'.'", "';'"
	};
	public static final int
		RULE_rule_condition = 0, RULE_dot_expr = 1;
	public static final String[] ruleNames = {
		"rule_condition", "dot_expr"
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
		public Dot_exprContext dot_expr() {
			return getRuleContext(Dot_exprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(RuleConditionParser.DOT, 0); }
		public TerminalNode SINGLE_QUOTE(int i) {
			return getToken(RuleConditionParser.SINGLE_QUOTE, i);
		}
		public TerminalNode WORD() { return getToken(RuleConditionParser.WORD, 0); }
		public TerminalNode SEMI() { return getToken(RuleConditionParser.SEMI, 0); }
		public TerminalNode BELIEVE() { return getToken(RuleConditionParser.BELIEVE, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(RuleConditionParser.OPEN_BRACKET, 0); }
		public List<TerminalNode> SINGLE_QUOTE() { return getTokens(RuleConditionParser.SINGLE_QUOTE); }
		public TerminalNode CLOSE_BRACKET() { return getToken(RuleConditionParser.CLOSE_BRACKET, 0); }
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
			setState(4); dot_expr();
			setState(5); match(DOT);
			setState(6); match(BELIEVE);
			setState(7); match(OPEN_BRACKET);
			setState(8); match(SINGLE_QUOTE);
			setState(9); match(WORD);
			setState(10); match(SINGLE_QUOTE);
			setState(11); match(CLOSE_BRACKET);
			setState(12); match(SEMI);
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
		enterRule(_localctx, 2, RULE_dot_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(14); match(WORD);
			setState(19);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(15); match(DOT);
					setState(16); match(WORD);
					}
					} 
				}
				setState(21);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\n\31\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3\24\n\3\f"+
		"\3\16\3\27\13\3\3\3\2\2\4\2\4\2\2\27\2\6\3\2\2\2\4\20\3\2\2\2\6\7\5\4"+
		"\3\2\7\b\7\t\2\2\b\t\7\4\2\2\t\n\7\7\2\2\n\13\7\6\2\2\13\f\7\5\2\2\f\r"+
		"\7\6\2\2\r\16\7\b\2\2\16\17\7\n\2\2\17\3\3\2\2\2\20\25\7\5\2\2\21\22\7"+
		"\t\2\2\22\24\7\5\2\2\23\21\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3"+
		"\2\2\2\26\5\3\2\2\2\27\25\3\2\2\2\3\25";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}