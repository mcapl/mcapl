// Generated from /Users/louisedennis/IdeaProjects/mcapl/src/main/ajpf/psl/parser/antlr/A_PSL.g4 by ANTLR 4.13.1
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
public class A_PSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALWAYS=1, FINALLY=2, UNTIL=3, RELEASE=4, NEXT=5, AND=6, OR=7, NOT=8, IMP=9, 
		BELIEVE=10, GOAL=11, FALSE=12, INTENTION=13, ACTION=14, PERCEPT=15, TRUE=16, 
		INTENDTODO=17, CONST=18, QUOTED_STRING=19, OPEN=20, CLOSE=21, COMMASEP=22, 
		IDPUNCT=23, SQOPEN=24, SQCLOSE=25, COMMENT=26, LINE_COMMENT=27, NEWLINE=28, 
		WS=29;
	public static final int
		RULE_spec = 0, RULE_property = 1, RULE_untilproperty = 2, RULE_releaseproperty = 3, 
		RULE_impproperty = 4, RULE_andproperty = 5, RULE_orproperty = 6, RULE_alwaysproperty = 7, 
		RULE_finallyproperty = 8, RULE_nextproperty = 9, RULE_notproperty = 10, 
		RULE_atom = 11, RULE_proposition = 12, RULE_beliefproperty = 13, RULE_goalproperty = 14, 
		RULE_falseprop = 15, RULE_intentionproperty = 16, RULE_lastactionproperty = 17, 
		RULE_perceptproperty = 18, RULE_intendtodoproperty = 19, RULE_trueprop = 20, 
		RULE_agentname = 21, RULE_fof_expr = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"spec", "property", "untilproperty", "releaseproperty", "impproperty", 
			"andproperty", "orproperty", "alwaysproperty", "finallyproperty", "nextproperty", 
			"notproperty", "atom", "proposition", "beliefproperty", "goalproperty", 
			"falseprop", "intentionproperty", "lastactionproperty", "perceptproperty", 
			"intendtodoproperty", "trueprop", "agentname", "fof_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'U'", "'R'", "'X'", "'&'", "'||'", "'~'", "'->'", 
			"'B'", "'G'", "'F'", "'I'", "'D'", "'P'", "'T'", "'ItD'", null, null, 
			"'('", "')'", "','", "'.'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ALWAYS", "FINALLY", "UNTIL", "RELEASE", "NEXT", "AND", "OR", "NOT", 
			"IMP", "BELIEVE", "GOAL", "FALSE", "INTENTION", "ACTION", "PERCEPT", 
			"TRUE", "INTENDTODO", "CONST", "QUOTED_STRING", "OPEN", "CLOSE", "COMMASEP", 
			"IDPUNCT", "SQOPEN", "SQCLOSE", "COMMENT", "LINE_COMMENT", "NEWLINE", 
			"WS"
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
	public String getGrammarFileName() { return "A_PSL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public A_PSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecContext extends ParserRuleContext {
		public PropertyContext p;
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public SpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecContext spec() throws RecognitionException {
		SpecContext _localctx = new SpecContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			((SpecContext)_localctx).p = property();
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
	public static class PropertyContext extends ParserRuleContext {
		public UntilpropertyContext untilproperty() {
			return getRuleContext(UntilpropertyContext.class,0);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			untilproperty();
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
	public static class UntilpropertyContext extends ParserRuleContext {
		public List<ReleasepropertyContext> releaseproperty() {
			return getRuleContexts(ReleasepropertyContext.class);
		}
		public ReleasepropertyContext releaseproperty(int i) {
			return getRuleContext(ReleasepropertyContext.class,i);
		}
		public List<TerminalNode> UNTIL() { return getTokens(A_PSLParser.UNTIL); }
		public TerminalNode UNTIL(int i) {
			return getToken(A_PSLParser.UNTIL, i);
		}
		public UntilpropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_untilproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitUntilproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UntilpropertyContext untilproperty() throws RecognitionException {
		UntilpropertyContext _localctx = new UntilpropertyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_untilproperty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			releaseproperty();
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UNTIL) {
				{
				{
				setState(51);
				match(UNTIL);
				setState(52);
				releaseproperty();
				}
				}
				setState(57);
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
	public static class ReleasepropertyContext extends ParserRuleContext {
		public List<ImppropertyContext> impproperty() {
			return getRuleContexts(ImppropertyContext.class);
		}
		public ImppropertyContext impproperty(int i) {
			return getRuleContext(ImppropertyContext.class,i);
		}
		public List<TerminalNode> RELEASE() { return getTokens(A_PSLParser.RELEASE); }
		public TerminalNode RELEASE(int i) {
			return getToken(A_PSLParser.RELEASE, i);
		}
		public ReleasepropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_releaseproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitReleaseproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReleasepropertyContext releaseproperty() throws RecognitionException {
		ReleasepropertyContext _localctx = new ReleasepropertyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_releaseproperty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			impproperty();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RELEASE) {
				{
				{
				setState(59);
				match(RELEASE);
				setState(60);
				impproperty();
				}
				}
				setState(65);
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
	public static class ImppropertyContext extends ParserRuleContext {
		public List<AndpropertyContext> andproperty() {
			return getRuleContexts(AndpropertyContext.class);
		}
		public AndpropertyContext andproperty(int i) {
			return getRuleContext(AndpropertyContext.class,i);
		}
		public List<TerminalNode> IMP() { return getTokens(A_PSLParser.IMP); }
		public TerminalNode IMP(int i) {
			return getToken(A_PSLParser.IMP, i);
		}
		public ImppropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitImpproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImppropertyContext impproperty() throws RecognitionException {
		ImppropertyContext _localctx = new ImppropertyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_impproperty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			andproperty();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMP) {
				{
				{
				setState(67);
				match(IMP);
				setState(68);
				andproperty();
				}
				}
				setState(73);
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
	public static class AndpropertyContext extends ParserRuleContext {
		public List<OrpropertyContext> orproperty() {
			return getRuleContexts(OrpropertyContext.class);
		}
		public OrpropertyContext orproperty(int i) {
			return getRuleContext(OrpropertyContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(A_PSLParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(A_PSLParser.AND, i);
		}
		public AndpropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitAndproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndpropertyContext andproperty() throws RecognitionException {
		AndpropertyContext _localctx = new AndpropertyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_andproperty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			orproperty();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(75);
				match(AND);
				setState(76);
				orproperty();
				}
				}
				setState(81);
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
	public static class OrpropertyContext extends ParserRuleContext {
		public List<AlwayspropertyContext> alwaysproperty() {
			return getRuleContexts(AlwayspropertyContext.class);
		}
		public AlwayspropertyContext alwaysproperty(int i) {
			return getRuleContext(AlwayspropertyContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(A_PSLParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(A_PSLParser.OR, i);
		}
		public OrpropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitOrproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrpropertyContext orproperty() throws RecognitionException {
		OrpropertyContext _localctx = new OrpropertyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_orproperty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			alwaysproperty();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(83);
				match(OR);
				setState(84);
				alwaysproperty();
				}
				}
				setState(89);
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
	public static class AlwayspropertyContext extends ParserRuleContext {
		public FinallypropertyContext finallyproperty() {
			return getRuleContext(FinallypropertyContext.class,0);
		}
		public TerminalNode ALWAYS() { return getToken(A_PSLParser.ALWAYS, 0); }
		public AlwayspropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alwaysproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitAlwaysproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlwayspropertyContext alwaysproperty() throws RecognitionException {
		AlwayspropertyContext _localctx = new AlwayspropertyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_alwaysproperty);
		try {
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FINALLY:
			case NEXT:
			case NOT:
			case BELIEVE:
			case GOAL:
			case FALSE:
			case INTENTION:
			case ACTION:
			case PERCEPT:
			case TRUE:
			case INTENDTODO:
			case OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				finallyproperty();
				}
				break;
			case ALWAYS:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(ALWAYS);
				setState(92);
				finallyproperty();
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
	public static class FinallypropertyContext extends ParserRuleContext {
		public NextpropertyContext nextproperty() {
			return getRuleContext(NextpropertyContext.class,0);
		}
		public TerminalNode FINALLY() { return getToken(A_PSLParser.FINALLY, 0); }
		public FinallypropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitFinallyproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinallypropertyContext finallyproperty() throws RecognitionException {
		FinallypropertyContext _localctx = new FinallypropertyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_finallyproperty);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEXT:
			case NOT:
			case BELIEVE:
			case GOAL:
			case FALSE:
			case INTENTION:
			case ACTION:
			case PERCEPT:
			case TRUE:
			case INTENDTODO:
			case OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				nextproperty();
				}
				break;
			case FINALLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				match(FINALLY);
				setState(97);
				nextproperty();
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
	public static class NextpropertyContext extends ParserRuleContext {
		public NotpropertyContext notproperty() {
			return getRuleContext(NotpropertyContext.class,0);
		}
		public TerminalNode NEXT() { return getToken(A_PSLParser.NEXT, 0); }
		public NextpropertyContext nextproperty() {
			return getRuleContext(NextpropertyContext.class,0);
		}
		public NextpropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nextproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitNextproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NextpropertyContext nextproperty() throws RecognitionException {
		NextpropertyContext _localctx = new NextpropertyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nextproperty);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case BELIEVE:
			case GOAL:
			case FALSE:
			case INTENTION:
			case ACTION:
			case PERCEPT:
			case TRUE:
			case INTENDTODO:
			case OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				notproperty();
				}
				break;
			case NEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(NEXT);
				setState(102);
				nextproperty();
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
	public static class NotpropertyContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode NOT() { return getToken(A_PSLParser.NOT, 0); }
		public NotpropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitNotproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotpropertyContext notproperty() throws RecognitionException {
		NotpropertyContext _localctx = new NotpropertyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_notproperty);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BELIEVE:
			case GOAL:
			case FALSE:
			case INTENTION:
			case ACTION:
			case PERCEPT:
			case TRUE:
			case INTENDTODO:
			case OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				atom();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(NOT);
				setState(107);
				atom();
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
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_atom);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BELIEVE:
			case GOAL:
			case FALSE:
			case INTENTION:
			case ACTION:
			case PERCEPT:
			case TRUE:
			case INTENDTODO:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				proposition();
				}
				break;
			case OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(OPEN);
				setState(112);
				property();
				setState(113);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PropositionContext extends ParserRuleContext {
		public BeliefpropertyContext beliefproperty() {
			return getRuleContext(BeliefpropertyContext.class,0);
		}
		public GoalpropertyContext goalproperty() {
			return getRuleContext(GoalpropertyContext.class,0);
		}
		public FalsepropContext falseprop() {
			return getRuleContext(FalsepropContext.class,0);
		}
		public IntentionpropertyContext intentionproperty() {
			return getRuleContext(IntentionpropertyContext.class,0);
		}
		public LastactionpropertyContext lastactionproperty() {
			return getRuleContext(LastactionpropertyContext.class,0);
		}
		public PerceptpropertyContext perceptproperty() {
			return getRuleContext(PerceptpropertyContext.class,0);
		}
		public IntendtodopropertyContext intendtodoproperty() {
			return getRuleContext(IntendtodopropertyContext.class,0);
		}
		public TruepropContext trueprop() {
			return getRuleContext(TruepropContext.class,0);
		}
		public PropositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitProposition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropositionContext proposition() throws RecognitionException {
		PropositionContext _localctx = new PropositionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_proposition);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BELIEVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				beliefproperty();
				}
				break;
			case GOAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				goalproperty();
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				falseprop();
				}
				break;
			case INTENTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				intentionproperty();
				}
				break;
			case ACTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(121);
				lastactionproperty();
				}
				break;
			case PERCEPT:
				enterOuterAlt(_localctx, 6);
				{
				setState(122);
				perceptproperty();
				}
				break;
			case INTENDTODO:
				enterOuterAlt(_localctx, 7);
				{
				setState(123);
				intendtodoproperty();
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 8);
				{
				setState(124);
				trueprop();
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
	public static class BeliefpropertyContext extends ParserRuleContext {
		public TerminalNode BELIEVE() { return getToken(A_PSLParser.BELIEVE, 0); }
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public BeliefpropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beliefproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitBeliefproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeliefpropertyContext beliefproperty() throws RecognitionException {
		BeliefpropertyContext _localctx = new BeliefpropertyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_beliefproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(BELIEVE);
			setState(128);
			match(OPEN);
			setState(129);
			agentname();
			setState(130);
			match(COMMASEP);
			setState(131);
			fof_expr();
			setState(132);
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
	public static class GoalpropertyContext extends ParserRuleContext {
		public TerminalNode GOAL() { return getToken(A_PSLParser.GOAL, 0); }
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public GoalpropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goalproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitGoalproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GoalpropertyContext goalproperty() throws RecognitionException {
		GoalpropertyContext _localctx = new GoalpropertyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_goalproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(GOAL);
			setState(135);
			match(OPEN);
			setState(136);
			agentname();
			setState(137);
			match(COMMASEP);
			setState(138);
			fof_expr();
			setState(139);
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
	public static class FalsepropContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(A_PSLParser.FALSE, 0); }
		public FalsepropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_falseprop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitFalseprop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FalsepropContext falseprop() throws RecognitionException {
		FalsepropContext _localctx = new FalsepropContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_falseprop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(FALSE);
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
	public static class IntentionpropertyContext extends ParserRuleContext {
		public TerminalNode INTENTION() { return getToken(A_PSLParser.INTENTION, 0); }
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public IntentionpropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intentionproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitIntentionproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntentionpropertyContext intentionproperty() throws RecognitionException {
		IntentionpropertyContext _localctx = new IntentionpropertyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_intentionproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(INTENTION);
			setState(144);
			match(OPEN);
			setState(145);
			agentname();
			setState(146);
			match(COMMASEP);
			setState(147);
			fof_expr();
			setState(148);
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
	public static class LastactionpropertyContext extends ParserRuleContext {
		public TerminalNode ACTION() { return getToken(A_PSLParser.ACTION, 0); }
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public LastactionpropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastactionproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitLastactionproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LastactionpropertyContext lastactionproperty() throws RecognitionException {
		LastactionpropertyContext _localctx = new LastactionpropertyContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_lastactionproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(ACTION);
			setState(151);
			match(OPEN);
			setState(152);
			agentname();
			setState(153);
			match(COMMASEP);
			setState(154);
			fof_expr();
			setState(155);
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
	public static class PerceptpropertyContext extends ParserRuleContext {
		public TerminalNode PERCEPT() { return getToken(A_PSLParser.PERCEPT, 0); }
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public PerceptpropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_perceptproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitPerceptproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PerceptpropertyContext perceptproperty() throws RecognitionException {
		PerceptpropertyContext _localctx = new PerceptpropertyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_perceptproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(PERCEPT);
			setState(158);
			match(OPEN);
			setState(159);
			fof_expr();
			setState(160);
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
	public static class IntendtodopropertyContext extends ParserRuleContext {
		public TerminalNode INTENDTODO() { return getToken(A_PSLParser.INTENDTODO, 0); }
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public IntendtodopropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intendtodoproperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitIntendtodoproperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntendtodopropertyContext intendtodoproperty() throws RecognitionException {
		IntendtodopropertyContext _localctx = new IntendtodopropertyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_intendtodoproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(INTENDTODO);
			setState(163);
			match(OPEN);
			setState(164);
			agentname();
			setState(165);
			match(COMMASEP);
			setState(166);
			fof_expr();
			setState(167);
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
	public static class TruepropContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(A_PSLParser.TRUE, 0); }
		public TruepropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueprop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitTrueprop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TruepropContext trueprop() throws RecognitionException {
		TruepropContext _localctx = new TruepropContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_trueprop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(TRUE);
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
	public static class AgentnameContext extends ParserRuleContext {
		public List<TerminalNode> CONST() { return getTokens(A_PSLParser.CONST); }
		public TerminalNode CONST(int i) {
			return getToken(A_PSLParser.CONST, i);
		}
		public List<TerminalNode> IDPUNCT() { return getTokens(A_PSLParser.IDPUNCT); }
		public TerminalNode IDPUNCT(int i) {
			return getToken(A_PSLParser.IDPUNCT, i);
		}
		public AgentnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentname; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitAgentname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgentnameContext agentname() throws RecognitionException {
		AgentnameContext _localctx = new AgentnameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_agentname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(CONST);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDPUNCT) {
				{
				{
				setState(172);
				match(IDPUNCT);
				setState(173);
				match(CONST);
				}
				}
				setState(178);
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
	public static class Fof_exprContext extends ParserRuleContext {
		public List<TerminalNode> CONST() { return getTokens(A_PSLParser.CONST); }
		public TerminalNode CONST(int i) {
			return getToken(A_PSLParser.CONST, i);
		}
		public TerminalNode SQOPEN() { return getToken(A_PSLParser.SQOPEN, 0); }
		public List<Fof_exprContext> fof_expr() {
			return getRuleContexts(Fof_exprContext.class);
		}
		public Fof_exprContext fof_expr(int i) {
			return getRuleContext(Fof_exprContext.class,i);
		}
		public TerminalNode SQCLOSE() { return getToken(A_PSLParser.SQCLOSE, 0); }
		public List<TerminalNode> IDPUNCT() { return getTokens(A_PSLParser.IDPUNCT); }
		public TerminalNode IDPUNCT(int i) {
			return getToken(A_PSLParser.IDPUNCT, i);
		}
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public List<TerminalNode> COMMASEP() { return getTokens(A_PSLParser.COMMASEP); }
		public TerminalNode COMMASEP(int i) {
			return getToken(A_PSLParser.COMMASEP, i);
		}
		public List<TerminalNode> QUOTED_STRING() { return getTokens(A_PSLParser.QUOTED_STRING); }
		public TerminalNode QUOTED_STRING(int i) {
			return getToken(A_PSLParser.QUOTED_STRING, i);
		}
		public Fof_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fof_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitFof_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fof_exprContext fof_expr() throws RecognitionException {
		Fof_exprContext _localctx = new Fof_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_fof_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				{
				setState(179);
				match(CONST);
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDPUNCT) {
					{
					{
					setState(180);
					match(IDPUNCT);
					setState(181);
					match(CONST);
					}
					}
					setState(186);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN) {
					{
					setState(187);
					match(OPEN);
					setState(190);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case CONST:
					case SQOPEN:
						{
						setState(188);
						fof_expr();
						}
						break;
					case QUOTED_STRING:
						{
						setState(189);
						match(QUOTED_STRING);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMASEP) {
						{
						{
						setState(192);
						match(COMMASEP);
						setState(195);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case CONST:
						case SQOPEN:
							{
							setState(193);
							fof_expr();
							}
							break;
						case QUOTED_STRING:
							{
							setState(194);
							match(QUOTED_STRING);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						}
						setState(201);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(202);
					match(CLOSE);
					}
				}

				}
				break;
			case SQOPEN:
				{
				setState(205);
				match(SQOPEN);
				setState(206);
				fof_expr();
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMASEP) {
					{
					{
					setState(207);
					match(COMMASEP);
					setState(208);
					fof_expr();
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(214);
				match(SQCLOSE);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u00db\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00026\b\u0002\n\u0002"+
		"\f\u00029\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003>\b\u0003"+
		"\n\u0003\f\u0003A\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"F\b\u0004\n\u0004\f\u0004I\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005N\b\u0005\n\u0005\f\u0005Q\t\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006V\b\u0006\n\u0006\f\u0006Y\t\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007^\b\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0003\bc\b\b\u0001\t\u0001\t\u0001\t\u0003\th\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0003\nm\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000bt\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f~\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0005"+
		"\u0015\u00af\b\u0015\n\u0015\f\u0015\u00b2\t\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0005\u0016\u00b7\b\u0016\n\u0016\f\u0016\u00ba\t\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00bf\b\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u00c4\b\u0016\u0005\u0016\u00c6\b\u0016"+
		"\n\u0016\f\u0016\u00c9\t\u0016\u0001\u0016\u0003\u0016\u00cc\b\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u00d2\b\u0016\n"+
		"\u0016\f\u0016\u00d5\t\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00d9"+
		"\b\u0016\u0001\u0016\u0000\u0000\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,\u0000\u0000\u00dc"+
		"\u0000.\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u00042"+
		"\u0001\u0000\u0000\u0000\u0006:\u0001\u0000\u0000\u0000\bB\u0001\u0000"+
		"\u0000\u0000\nJ\u0001\u0000\u0000\u0000\fR\u0001\u0000\u0000\u0000\u000e"+
		"]\u0001\u0000\u0000\u0000\u0010b\u0001\u0000\u0000\u0000\u0012g\u0001"+
		"\u0000\u0000\u0000\u0014l\u0001\u0000\u0000\u0000\u0016s\u0001\u0000\u0000"+
		"\u0000\u0018}\u0001\u0000\u0000\u0000\u001a\u007f\u0001\u0000\u0000\u0000"+
		"\u001c\u0086\u0001\u0000\u0000\u0000\u001e\u008d\u0001\u0000\u0000\u0000"+
		" \u008f\u0001\u0000\u0000\u0000\"\u0096\u0001\u0000\u0000\u0000$\u009d"+
		"\u0001\u0000\u0000\u0000&\u00a2\u0001\u0000\u0000\u0000(\u00a9\u0001\u0000"+
		"\u0000\u0000*\u00ab\u0001\u0000\u0000\u0000,\u00d8\u0001\u0000\u0000\u0000"+
		"./\u0003\u0002\u0001\u0000/\u0001\u0001\u0000\u0000\u000001\u0003\u0004"+
		"\u0002\u00001\u0003\u0001\u0000\u0000\u000027\u0003\u0006\u0003\u0000"+
		"34\u0005\u0003\u0000\u000046\u0003\u0006\u0003\u000053\u0001\u0000\u0000"+
		"\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000"+
		"\u0000\u00008\u0005\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000"+
		":?\u0003\b\u0004\u0000;<\u0005\u0004\u0000\u0000<>\u0003\b\u0004\u0000"+
		"=;\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@\u0007\u0001\u0000\u0000\u0000A?\u0001"+
		"\u0000\u0000\u0000BG\u0003\n\u0005\u0000CD\u0005\t\u0000\u0000DF\u0003"+
		"\n\u0005\u0000EC\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H\t\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000JO\u0003\f\u0006\u0000KL\u0005\u0006\u0000\u0000"+
		"LN\u0003\f\u0006\u0000MK\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000"+
		"OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\u000b\u0001\u0000"+
		"\u0000\u0000QO\u0001\u0000\u0000\u0000RW\u0003\u000e\u0007\u0000ST\u0005"+
		"\u0007\u0000\u0000TV\u0003\u000e\u0007\u0000US\u0001\u0000\u0000\u0000"+
		"VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000X\r\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z^\u0003\u0010"+
		"\b\u0000[\\\u0005\u0001\u0000\u0000\\^\u0003\u0010\b\u0000]Z\u0001\u0000"+
		"\u0000\u0000][\u0001\u0000\u0000\u0000^\u000f\u0001\u0000\u0000\u0000"+
		"_c\u0003\u0012\t\u0000`a\u0005\u0002\u0000\u0000ac\u0003\u0012\t\u0000"+
		"b_\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000c\u0011\u0001\u0000"+
		"\u0000\u0000dh\u0003\u0014\n\u0000ef\u0005\u0005\u0000\u0000fh\u0003\u0012"+
		"\t\u0000gd\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000h\u0013\u0001"+
		"\u0000\u0000\u0000im\u0003\u0016\u000b\u0000jk\u0005\b\u0000\u0000km\u0003"+
		"\u0016\u000b\u0000li\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000"+
		"m\u0015\u0001\u0000\u0000\u0000nt\u0003\u0018\f\u0000op\u0005\u0014\u0000"+
		"\u0000pq\u0003\u0002\u0001\u0000qr\u0005\u0015\u0000\u0000rt\u0001\u0000"+
		"\u0000\u0000sn\u0001\u0000\u0000\u0000so\u0001\u0000\u0000\u0000t\u0017"+
		"\u0001\u0000\u0000\u0000u~\u0003\u001a\r\u0000v~\u0003\u001c\u000e\u0000"+
		"w~\u0003\u001e\u000f\u0000x~\u0003 \u0010\u0000y~\u0003\"\u0011\u0000"+
		"z~\u0003$\u0012\u0000{~\u0003&\u0013\u0000|~\u0003(\u0014\u0000}u\u0001"+
		"\u0000\u0000\u0000}v\u0001\u0000\u0000\u0000}w\u0001\u0000\u0000\u0000"+
		"}x\u0001\u0000\u0000\u0000}y\u0001\u0000\u0000\u0000}z\u0001\u0000\u0000"+
		"\u0000}{\u0001\u0000\u0000\u0000}|\u0001\u0000\u0000\u0000~\u0019\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0005\n\u0000\u0000\u0080\u0081\u0005\u0014"+
		"\u0000\u0000\u0081\u0082\u0003*\u0015\u0000\u0082\u0083\u0005\u0016\u0000"+
		"\u0000\u0083\u0084\u0003,\u0016\u0000\u0084\u0085\u0005\u0015\u0000\u0000"+
		"\u0085\u001b\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u000b\u0000\u0000"+
		"\u0087\u0088\u0005\u0014\u0000\u0000\u0088\u0089\u0003*\u0015\u0000\u0089"+
		"\u008a\u0005\u0016\u0000\u0000\u008a\u008b\u0003,\u0016\u0000\u008b\u008c"+
		"\u0005\u0015\u0000\u0000\u008c\u001d\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0005\f\u0000\u0000\u008e\u001f\u0001\u0000\u0000\u0000\u008f\u0090\u0005"+
		"\r\u0000\u0000\u0090\u0091\u0005\u0014\u0000\u0000\u0091\u0092\u0003*"+
		"\u0015\u0000\u0092\u0093\u0005\u0016\u0000\u0000\u0093\u0094\u0003,\u0016"+
		"\u0000\u0094\u0095\u0005\u0015\u0000\u0000\u0095!\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0005\u000e\u0000\u0000\u0097\u0098\u0005\u0014\u0000\u0000"+
		"\u0098\u0099\u0003*\u0015\u0000\u0099\u009a\u0005\u0016\u0000\u0000\u009a"+
		"\u009b\u0003,\u0016\u0000\u009b\u009c\u0005\u0015\u0000\u0000\u009c#\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0005\u000f\u0000\u0000\u009e\u009f\u0005"+
		"\u0014\u0000\u0000\u009f\u00a0\u0003,\u0016\u0000\u00a0\u00a1\u0005\u0015"+
		"\u0000\u0000\u00a1%\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\u0011\u0000"+
		"\u0000\u00a3\u00a4\u0005\u0014\u0000\u0000\u00a4\u00a5\u0003*\u0015\u0000"+
		"\u00a5\u00a6\u0005\u0016\u0000\u0000\u00a6\u00a7\u0003,\u0016\u0000\u00a7"+
		"\u00a8\u0005\u0015\u0000\u0000\u00a8\'\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0005\u0010\u0000\u0000\u00aa)\u0001\u0000\u0000\u0000\u00ab\u00b0\u0005"+
		"\u0012\u0000\u0000\u00ac\u00ad\u0005\u0017\u0000\u0000\u00ad\u00af\u0005"+
		"\u0012\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b1+\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b8\u0005\u0012\u0000\u0000\u00b4\u00b5\u0005\u0017"+
		"\u0000\u0000\u00b5\u00b7\u0005\u0012\u0000\u0000\u00b6\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00cb\u0001\u0000"+
		"\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00bb\u00be\u0005\u0014"+
		"\u0000\u0000\u00bc\u00bf\u0003,\u0016\u0000\u00bd\u00bf\u0005\u0013\u0000"+
		"\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bd\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c7\u0001\u0000\u0000\u0000\u00c0\u00c3\u0005\u0016\u0000"+
		"\u0000\u00c1\u00c4\u0003,\u0016\u0000\u00c2\u00c4\u0005\u0013\u0000\u0000"+
		"\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c6\u0001\u0000\u0000\u0000\u00c5\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c9\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00ca\u0001\u0000\u0000\u0000"+
		"\u00c9\u00c7\u0001\u0000\u0000\u0000\u00ca\u00cc\u0005\u0015\u0000\u0000"+
		"\u00cb\u00bb\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000"+
		"\u00cc\u00d9\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\u0018\u0000\u0000"+
		"\u00ce\u00d3\u0003,\u0016\u0000\u00cf\u00d0\u0005\u0016\u0000\u0000\u00d0"+
		"\u00d2\u0003,\u0016\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d6\u0001\u0000\u0000\u0000\u00d5\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\u0019\u0000\u0000\u00d7\u00d9"+
		"\u0001\u0000\u0000\u0000\u00d8\u00b3\u0001\u0000\u0000\u0000\u00d8\u00cd"+
		"\u0001\u0000\u0000\u0000\u00d9-\u0001\u0000\u0000\u0000\u00137?GOW]bg"+
		"ls}\u00b0\u00b8\u00be\u00c3\u00c7\u00cb\u00d3\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}