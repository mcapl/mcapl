// Generated from Juno.g4 by ANTLR 4.4
package juno.syntax.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JunoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMA=12, ADD=9, NEWLINE=3, FILE_BLOCK=14, DEL=10, CLOSE=8, COMMENT=1, 
		OPEN=7, CURLYOPEN=5, LINE_COMMENT=2, ARROW=11, CURLYCLOSE=6, CONST=13, 
		WS=4;
	public static final String[] tokenNames = {
		"<INVALID>", "COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "'{'", "'}'", 
		"'('", "')'", "'+'", "'-'", "'<-'", "','", "CONST", "FILE_BLOCK"
	};
	public static final int
		RULE_junoAgent = 0, RULE_json_file = 1, RULE_belief_rule = 2, RULE_action_rule = 3, 
		RULE_belief_modifier = 4, RULE_fof_expr = 5;
	public static final String[] ruleNames = {
		"junoAgent", "json_file", "belief_rule", "action_rule", "belief_modifier", 
		"fof_expr"
	};

	@Override
	public String getGrammarFileName() { return "Juno.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JunoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class JunoAgentContext extends ParserRuleContext {
		public Belief_ruleContext bs;
		public Action_ruleContext as;
		public Json_fileContext json_file() {
			return getRuleContext(Json_fileContext.class,0);
		}
		public List<Belief_ruleContext> belief_rule() {
			return getRuleContexts(Belief_ruleContext.class);
		}
		public Belief_ruleContext belief_rule(int i) {
			return getRuleContext(Belief_ruleContext.class,i);
		}
		public List<Action_ruleContext> action_rule() {
			return getRuleContexts(Action_ruleContext.class);
		}
		public Action_ruleContext action_rule(int i) {
			return getRuleContext(Action_ruleContext.class,i);
		}
		public JunoAgentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_junoAgent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JunoVisitor ) return ((JunoVisitor<? extends T>)visitor).visitJunoAgent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JunoAgentContext junoAgent() throws RecognitionException {
		JunoAgentContext _localctx = new JunoAgentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_junoAgent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12); json_file();
			setState(16);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==DEL) {
				{
				{
				setState(13); ((JunoAgentContext)_localctx).bs = belief_rule();
				}
				}
				setState(18);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST) {
				{
				{
				setState(19); ((JunoAgentContext)_localctx).as = action_rule();
				}
				}
				setState(24);
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

	public static class Json_fileContext extends ParserRuleContext {
		public TerminalNode CURLYOPEN() { return getToken(JunoParser.CURLYOPEN, 0); }
		public TerminalNode CURLYCLOSE() { return getToken(JunoParser.CURLYCLOSE, 0); }
		public TerminalNode FILE_BLOCK() { return getToken(JunoParser.FILE_BLOCK, 0); }
		public Json_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_json_file; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JunoVisitor ) return ((JunoVisitor<? extends T>)visitor).visitJson_file(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Json_fileContext json_file() throws RecognitionException {
		Json_fileContext _localctx = new Json_fileContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_json_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); match(CURLYOPEN);
			setState(26); match(FILE_BLOCK);
			setState(27); match(CURLYCLOSE);
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

	public static class Belief_ruleContext extends ParserRuleContext {
		public Belief_modifierContext b;
		public Fof_exprContext bs1;
		public Fof_exprContext bs2;
		public Belief_modifierContext belief_modifier() {
			return getRuleContext(Belief_modifierContext.class,0);
		}
		public TerminalNode CURLYOPEN() { return getToken(JunoParser.CURLYOPEN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JunoParser.COMMA); }
		public List<Fof_exprContext> fof_expr() {
			return getRuleContexts(Fof_exprContext.class);
		}
		public TerminalNode CURLYCLOSE() { return getToken(JunoParser.CURLYCLOSE, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(JunoParser.COMMA, i);
		}
		public Fof_exprContext fof_expr(int i) {
			return getRuleContext(Fof_exprContext.class,i);
		}
		public Belief_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_belief_rule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JunoVisitor ) return ((JunoVisitor<? extends T>)visitor).visitBelief_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Belief_ruleContext belief_rule() throws RecognitionException {
		Belief_ruleContext _localctx = new Belief_ruleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_belief_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(29); ((Belief_ruleContext)_localctx).b = belief_modifier();
			}
			setState(30); match(CURLYOPEN);
			{
			setState(31); ((Belief_ruleContext)_localctx).bs1 = fof_expr();
			}
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(32); match(COMMA);
				setState(33); ((Belief_ruleContext)_localctx).bs2 = fof_expr();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39); match(CURLYCLOSE);
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

	public static class Action_ruleContext extends ParserRuleContext {
		public Fof_exprContext a;
		public Belief_modifierContext b;
		public Belief_modifierContext bs2;
		public List<Belief_modifierContext> belief_modifier() {
			return getRuleContexts(Belief_modifierContext.class);
		}
		public TerminalNode CURLYOPEN() { return getToken(JunoParser.CURLYOPEN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JunoParser.COMMA); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public Belief_modifierContext belief_modifier(int i) {
			return getRuleContext(Belief_modifierContext.class,i);
		}
		public TerminalNode CURLYCLOSE() { return getToken(JunoParser.CURLYCLOSE, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(JunoParser.COMMA, i);
		}
		public Action_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_rule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JunoVisitor ) return ((JunoVisitor<? extends T>)visitor).visitAction_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Action_ruleContext action_rule() throws RecognitionException {
		Action_ruleContext _localctx = new Action_ruleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_action_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(41); ((Action_ruleContext)_localctx).a = fof_expr();
			}
			setState(42); match(CURLYOPEN);
			{
			setState(43); ((Action_ruleContext)_localctx).b = belief_modifier();
			}
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(44); match(COMMA);
				{
				setState(45); ((Action_ruleContext)_localctx).bs2 = belief_modifier();
				}
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51); match(CURLYCLOSE);
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

	public static class Belief_modifierContext extends ParserRuleContext {
		public Fof_exprContext b;
		public TerminalNode ADD() { return getToken(JunoParser.ADD, 0); }
		public TerminalNode DEL() { return getToken(JunoParser.DEL, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public Belief_modifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_belief_modifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JunoVisitor ) return ((JunoVisitor<? extends T>)visitor).visitBelief_modifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Belief_modifierContext belief_modifier() throws RecognitionException {
		Belief_modifierContext _localctx = new Belief_modifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_belief_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==DEL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			{
			setState(54); ((Belief_modifierContext)_localctx).b = fof_expr();
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

	public static class Fof_exprContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(JunoParser.CONST, 0); }
		public TerminalNode OPEN() { return getToken(JunoParser.OPEN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JunoParser.COMMA); }
		public TerminalNode CLOSE() { return getToken(JunoParser.CLOSE, 0); }
		public List<Fof_exprContext> fof_expr() {
			return getRuleContexts(Fof_exprContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(JunoParser.COMMA, i);
		}
		public Fof_exprContext fof_expr(int i) {
			return getRuleContext(Fof_exprContext.class,i);
		}
		public Fof_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fof_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JunoVisitor ) return ((JunoVisitor<? extends T>)visitor).visitFof_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fof_exprContext fof_expr() throws RecognitionException {
		Fof_exprContext _localctx = new Fof_exprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fof_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); match(CONST);
			setState(68);
			_la = _input.LA(1);
			if (_la==OPEN) {
				{
				setState(57); match(OPEN);
				setState(58); fof_expr();
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(59); match(COMMA);
					setState(60); fof_expr();
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66); match(CLOSE);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20I\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\7\2\21\n\2\f\2\16\2\24\13\2"+
		"\3\2\7\2\27\n\2\f\2\16\2\32\13\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7"+
		"\4%\n\4\f\4\16\4(\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7\5\61\n\5\f\5\16\5"+
		"\64\13\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7@\n\7\f\7\16\7C\13"+
		"\7\3\7\3\7\5\7G\n\7\3\7\2\2\b\2\4\6\b\n\f\2\3\3\2\13\fH\2\16\3\2\2\2\4"+
		"\33\3\2\2\2\6\37\3\2\2\2\b+\3\2\2\2\n\67\3\2\2\2\f:\3\2\2\2\16\22\5\4"+
		"\3\2\17\21\5\6\4\2\20\17\3\2\2\2\21\24\3\2\2\2\22\20\3\2\2\2\22\23\3\2"+
		"\2\2\23\30\3\2\2\2\24\22\3\2\2\2\25\27\5\b\5\2\26\25\3\2\2\2\27\32\3\2"+
		"\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\3\3\2\2\2\32\30\3\2\2\2\33\34\7\7"+
		"\2\2\34\35\7\20\2\2\35\36\7\b\2\2\36\5\3\2\2\2\37 \5\n\6\2 !\7\7\2\2!"+
		"&\5\f\7\2\"#\7\16\2\2#%\5\f\7\2$\"\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2"+
		"\2\2\')\3\2\2\2(&\3\2\2\2)*\7\b\2\2*\7\3\2\2\2+,\5\f\7\2,-\7\7\2\2-\62"+
		"\5\n\6\2./\7\16\2\2/\61\5\n\6\2\60.\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2"+
		"\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66\7\b\2\2\66\t\3\2\2"+
		"\2\678\t\2\2\289\5\f\7\29\13\3\2\2\2:F\7\17\2\2;<\7\t\2\2<A\5\f\7\2=>"+
		"\7\16\2\2>@\5\f\7\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2"+
		"CA\3\2\2\2DE\7\n\2\2EG\3\2\2\2F;\3\2\2\2FG\3\2\2\2G\r\3\2\2\2\b\22\30"+
		"&\62AF";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}