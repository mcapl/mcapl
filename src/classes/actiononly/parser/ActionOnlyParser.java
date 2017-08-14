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
		BELIEFRULES=3, FOF_BLOCK=9, WORD=14, NAME=5, CURLYOPEN=11, GOAL=4, ACTIONONLY=1, 
		CURLYCLOSE=12, ACTIONS=8, PRED_BLOCK=10, BELIEFS=2, BRULEARROW=7, POINT=13, 
		BELIEVE=6;
	public static final String[] tokenNames = {
		"<INVALID>", "'AO'", "':Initial Beliefs:'", "':Reasoning Rules:'", "':Initial Goal:'", 
		"':name:'", "BELIEVE", "':-'", "':Actions:'", "FOF_BLOCK", "PRED_BLOCK", 
		"'{'", "'}'", "'.'", "WORD"
	};
	public static final int
		RULE_mas = 0, RULE_aoagents = 1, RULE_aoagent = 2, RULE_capability = 3;
	public static final String[] ruleNames = {
		"mas", "aoagents", "aoagent", "capability"
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
			setState(8); aoagents();
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
			setState(10); match(ACTIONONLY);
			setState(12); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(11); aoagent();
				}
				}
				setState(14); 
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
		public Token w;
		public Token bs;
		public Token brs;
		public Token gs;
		public CapabilityContext c;
		public TerminalNode NAME() { return getToken(ActionOnlyParser.NAME, 0); }
		public TerminalNode BELIEFS() { return getToken(ActionOnlyParser.BELIEFS, 0); }
		public TerminalNode WORD() { return getToken(ActionOnlyParser.WORD, 0); }
		public List<CapabilityContext> capability() {
			return getRuleContexts(CapabilityContext.class);
		}
		public TerminalNode ACTIONONLY() { return getToken(ActionOnlyParser.ACTIONONLY, 0); }
		public TerminalNode ACTIONS() { return getToken(ActionOnlyParser.ACTIONS, 0); }
		public TerminalNode GOAL() { return getToken(ActionOnlyParser.GOAL, 0); }
		public TerminalNode PRED_BLOCK(int i) {
			return getToken(ActionOnlyParser.PRED_BLOCK, i);
		}
		public CapabilityContext capability(int i) {
			return getRuleContext(CapabilityContext.class,i);
		}
		public TerminalNode BELIEFRULES() { return getToken(ActionOnlyParser.BELIEFRULES, 0); }
		public List<TerminalNode> PRED_BLOCK() { return getTokens(ActionOnlyParser.PRED_BLOCK); }
		public TerminalNode FOF_BLOCK() { return getToken(ActionOnlyParser.FOF_BLOCK, 0); }
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
			setState(17);
			_la = _input.LA(1);
			if (_la==ACTIONONLY) {
				{
				setState(16); match(ACTIONONLY);
				}
			}

			}
			setState(19); match(NAME);
			setState(20); ((AoagentContext)_localctx).w = match(WORD);
			setState(21); match(BELIEFS);
			setState(22); ((AoagentContext)_localctx).bs = match(PRED_BLOCK);
			setState(25);
			_la = _input.LA(1);
			if (_la==BELIEFRULES) {
				{
				setState(23); match(BELIEFRULES);
				setState(24); ((AoagentContext)_localctx).brs = match(FOF_BLOCK);
				}
			}

			setState(27); match(GOAL);
			setState(28); ((AoagentContext)_localctx).gs = match(PRED_BLOCK);
			setState(29); match(ACTIONS);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CURLYOPEN) {
				{
				{
				setState(30); ((AoagentContext)_localctx).c = capability();
				}
				}
				setState(35);
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

	public static class CapabilityContext extends ParserRuleContext {
		public Abstract_Capability c;
		public Token pres;
		public Token a;
		public TerminalNode CURLYOPEN() { return getToken(ActionOnlyParser.CURLYOPEN, 0); }
		public TerminalNode CURLYCLOSE() { return getToken(ActionOnlyParser.CURLYCLOSE, 0); }
		public TerminalNode PRED_BLOCK() { return getToken(ActionOnlyParser.PRED_BLOCK, 0); }
		public TerminalNode FOF_BLOCK() { return getToken(ActionOnlyParser.FOF_BLOCK, 0); }
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
		enterRule(_localctx, 6, RULE_capability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(CURLYOPEN);
			setState(38);
			_la = _input.LA(1);
			if (_la==FOF_BLOCK) {
				{
				setState(37); ((CapabilityContext)_localctx).pres = match(FOF_BLOCK);
				}
			}

			setState(40); match(CURLYCLOSE);
			setState(41); ((CapabilityContext)_localctx).a = match(PRED_BLOCK);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20.\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\3\3\3\6\3\17\n\3\r\3\16\3\20\3\4\5\4\24\n"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\34\n\4\3\4\3\4\3\4\3\4\7\4\"\n\4\f\4\16"+
		"\4%\13\4\3\5\3\5\5\5)\n\5\3\5\3\5\3\5\3\5\2\2\6\2\4\6\b\2\2.\2\n\3\2\2"+
		"\2\4\f\3\2\2\2\6\23\3\2\2\2\b&\3\2\2\2\n\13\5\4\3\2\13\3\3\2\2\2\f\16"+
		"\7\3\2\2\r\17\5\6\4\2\16\r\3\2\2\2\17\20\3\2\2\2\20\16\3\2\2\2\20\21\3"+
		"\2\2\2\21\5\3\2\2\2\22\24\7\3\2\2\23\22\3\2\2\2\23\24\3\2\2\2\24\25\3"+
		"\2\2\2\25\26\7\7\2\2\26\27\7\20\2\2\27\30\7\4\2\2\30\33\7\f\2\2\31\32"+
		"\7\5\2\2\32\34\7\13\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36"+
		"\7\6\2\2\36\37\7\f\2\2\37#\7\n\2\2 \"\5\b\5\2! \3\2\2\2\"%\3\2\2\2#!\3"+
		"\2\2\2#$\3\2\2\2$\7\3\2\2\2%#\3\2\2\2&(\7\r\2\2\')\7\13\2\2(\'\3\2\2\2"+
		"()\3\2\2\2)*\3\2\2\2*+\7\16\2\2+,\7\f\2\2,\t\3\2\2\2\7\20\23\33#(";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}