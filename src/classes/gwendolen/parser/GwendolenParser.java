// Generated from /Users/louisedennis/eclipse-workspace/mcapl/src/classes/gwendolen/parser/antlr/Gwendolen.g4 by ANTLR 4.7
package gwendolen.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GwendolenParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GWENDOLEN=1, NAME=2, AGNAME=3, COMMENT=4, LINE_COMMENT=5, NEWLINE=6, WS=7;
	public static final int
		RULE_mas = 0, RULE_gwendolenagents = 1, RULE_gwendolenagent = 2;
	public static final String[] ruleNames = {
		"mas", "gwendolenagents", "gwendolenagent"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'GWENDOLEN'", "':name:'", "'ag1'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "GWENDOLEN", "NAME", "AGNAME", "COMMENT", "LINE_COMMENT", "NEWLINE", 
		"WS"
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
	public String getGrammarFileName() { return "Gwendolen.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GwendolenParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MasContext extends ParserRuleContext {
		public GwendolenagentsContext glist;
		public GwendolenagentsContext gwendolenagents() {
			return getRuleContext(GwendolenagentsContext.class,0);
		}
		public MasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mas; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitMas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MasContext mas() throws RecognitionException {
		MasContext _localctx = new MasContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mas);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			((MasContext)_localctx).glist = gwendolenagents();
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

	public static class GwendolenagentsContext extends ParserRuleContext {
		public GwendolenagentContext g;
		public TerminalNode GWENDOLEN() { return getToken(GwendolenParser.GWENDOLEN, 0); }
		public List<GwendolenagentContext> gwendolenagent() {
			return getRuleContexts(GwendolenagentContext.class);
		}
		public GwendolenagentContext gwendolenagent(int i) {
			return getRuleContext(GwendolenagentContext.class,i);
		}
		public GwendolenagentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gwendolenagents; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitGwendolenagents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GwendolenagentsContext gwendolenagents() throws RecognitionException {
		GwendolenagentsContext _localctx = new GwendolenagentsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_gwendolenagents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(GWENDOLEN);
			setState(10); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(9);
				((GwendolenagentsContext)_localctx).g = gwendolenagent();
				}
				}
				setState(12); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==GWENDOLEN || _la==NAME );
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

	public static class GwendolenagentContext extends ParserRuleContext {
		public Token w;
		public TerminalNode NAME() { return getToken(GwendolenParser.NAME, 0); }
		public TerminalNode AGNAME() { return getToken(GwendolenParser.AGNAME, 0); }
		public TerminalNode GWENDOLEN() { return getToken(GwendolenParser.GWENDOLEN, 0); }
		public GwendolenagentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gwendolenagent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GwendolenVisitor ) return ((GwendolenVisitor<? extends T>)visitor).visitGwendolenagent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GwendolenagentContext gwendolenagent() throws RecognitionException {
		GwendolenagentContext _localctx = new GwendolenagentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_gwendolenagent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GWENDOLEN) {
				{
				setState(14);
				match(GWENDOLEN);
				}
			}

			}
			setState(17);
			match(NAME);
			setState(18);
			((GwendolenagentContext)_localctx).w = match(AGNAME);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\t\27\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\3\3\3\6\3\r\n\3\r\3\16\3\16\3\4\5\4\22\n\4\3\4"+
		"\3\4\3\4\3\4\2\2\5\2\4\6\2\2\2\25\2\b\3\2\2\2\4\n\3\2\2\2\6\21\3\2\2\2"+
		"\b\t\5\4\3\2\t\3\3\2\2\2\n\f\7\3\2\2\13\r\5\6\4\2\f\13\3\2\2\2\r\16\3"+
		"\2\2\2\16\f\3\2\2\2\16\17\3\2\2\2\17\5\3\2\2\2\20\22\7\3\2\2\21\20\3\2"+
		"\2\2\21\22\3\2\2\2\22\23\3\2\2\2\23\24\7\4\2\2\24\25\7\5\2\2\25\7\3\2"+
		"\2\2\4\16\21";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}