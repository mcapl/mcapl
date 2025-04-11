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
		ALWAYS=1, FINALLY=2, UNTIL=3, RELEASE=4, AND=5, OR=6, NOT=7, IMP=8, BELIEVE=9, 
		GOAL=10, FALSE=11, INTENTION=12, ACTION=13, PERCEPT=14, TRUE=15, INTENDTODO=16, 
		CONST=17, QUOTED_STRING=18, OPEN=19, CLOSE=20, COMMASEP=21, IDPUNCT=22, 
		SQOPEN=23, SQCLOSE=24, COMMENT=25, LINE_COMMENT=26, NEWLINE=27, WS=28;
	public static final int
		RULE_spec = 0, RULE_property = 1, RULE_untilproperty = 2, RULE_releaseproperty = 3, 
		RULE_impproperty = 4, RULE_andproperty = 5, RULE_orproperty = 6, RULE_alwaysproperty = 7, 
		RULE_finallyproperty = 8, RULE_notproperty = 9, RULE_atom = 10, RULE_proposition = 11, 
		RULE_beliefproperty = 12, RULE_goalproperty = 13, RULE_falseprop = 14, 
		RULE_intentionproperty = 15, RULE_lastactionproperty = 16, RULE_perceptproperty = 17, 
		RULE_intendtodoproperty = 18, RULE_trueprop = 19, RULE_agentname = 20, 
		RULE_fof_expr = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"spec", "property", "untilproperty", "releaseproperty", "impproperty", 
			"andproperty", "orproperty", "alwaysproperty", "finallyproperty", "notproperty", 
			"atom", "proposition", "beliefproperty", "goalproperty", "falseprop", 
			"intentionproperty", "lastactionproperty", "perceptproperty", "intendtodoproperty", 
			"trueprop", "agentname", "fof_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'U'", "'R'", "'&'", "'||'", "'~'", "'->'", "'B'", 
			"'G'", "'F'", "'I'", "'D'", "'P'", "'T'", "'ItD'", null, null, "'('", 
			"')'", "','", "'.'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ALWAYS", "FINALLY", "UNTIL", "RELEASE", "AND", "OR", "NOT", "IMP", 
			"BELIEVE", "GOAL", "FALSE", "INTENTION", "ACTION", "PERCEPT", "TRUE", 
			"INTENDTODO", "CONST", "QUOTED_STRING", "OPEN", "CLOSE", "COMMASEP", 
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
			setState(44);
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
			setState(46);
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
			setState(48);
			releaseproperty();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UNTIL) {
				{
				{
				setState(49);
				match(UNTIL);
				setState(50);
				releaseproperty();
				}
				}
				setState(55);
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
			setState(56);
			impproperty();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RELEASE) {
				{
				{
				setState(57);
				match(RELEASE);
				setState(58);
				impproperty();
				}
				}
				setState(63);
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
			setState(64);
			andproperty();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMP) {
				{
				{
				setState(65);
				match(IMP);
				setState(66);
				andproperty();
				}
				}
				setState(71);
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
			setState(72);
			orproperty();
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(73);
				match(AND);
				setState(74);
				orproperty();
				}
				}
				setState(79);
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
			setState(80);
			alwaysproperty();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(81);
				match(OR);
				setState(82);
				alwaysproperty();
				}
				}
				setState(87);
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
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FINALLY:
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
				setState(88);
				finallyproperty();
				}
				break;
			case ALWAYS:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(ALWAYS);
				setState(90);
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
		public NotpropertyContext notproperty() {
			return getRuleContext(NotpropertyContext.class,0);
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
			setState(96);
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
				setState(93);
				notproperty();
				}
				break;
			case FINALLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(FINALLY);
				setState(95);
				notproperty();
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
		enterRule(_localctx, 18, RULE_notproperty);
		try {
			setState(101);
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
				setState(98);
				atom();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(NOT);
				setState(100);
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
		enterRule(_localctx, 20, RULE_atom);
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
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				proposition();
				}
				break;
			case OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(OPEN);
				setState(105);
				property();
				setState(106);
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
		enterRule(_localctx, 22, RULE_proposition);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BELIEVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				beliefproperty();
				}
				break;
			case GOAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				goalproperty();
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				falseprop();
				}
				break;
			case INTENTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				intentionproperty();
				}
				break;
			case ACTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(114);
				lastactionproperty();
				}
				break;
			case PERCEPT:
				enterOuterAlt(_localctx, 6);
				{
				setState(115);
				perceptproperty();
				}
				break;
			case INTENDTODO:
				enterOuterAlt(_localctx, 7);
				{
				setState(116);
				intendtodoproperty();
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 8);
				{
				setState(117);
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
		enterRule(_localctx, 24, RULE_beliefproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(BELIEVE);
			setState(121);
			match(OPEN);
			setState(122);
			agentname();
			setState(123);
			match(COMMASEP);
			setState(124);
			fof_expr();
			setState(125);
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
		enterRule(_localctx, 26, RULE_goalproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(GOAL);
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
		enterRule(_localctx, 28, RULE_falseprop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
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
		enterRule(_localctx, 30, RULE_intentionproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(INTENTION);
			setState(137);
			match(OPEN);
			setState(138);
			agentname();
			setState(139);
			match(COMMASEP);
			setState(140);
			fof_expr();
			setState(141);
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
		enterRule(_localctx, 32, RULE_lastactionproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(ACTION);
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
		enterRule(_localctx, 34, RULE_perceptproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(PERCEPT);
			setState(151);
			match(OPEN);
			setState(152);
			fof_expr();
			setState(153);
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
		enterRule(_localctx, 36, RULE_intendtodoproperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(INTENDTODO);
			setState(156);
			match(OPEN);
			setState(157);
			agentname();
			setState(158);
			match(COMMASEP);
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
		enterRule(_localctx, 38, RULE_trueprop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
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
		enterRule(_localctx, 40, RULE_agentname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(CONST);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDPUNCT) {
				{
				{
				setState(165);
				match(IDPUNCT);
				setState(166);
				match(CONST);
				}
				}
				setState(171);
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
		enterRule(_localctx, 42, RULE_fof_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				{
				setState(172);
				match(CONST);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDPUNCT) {
					{
					{
					setState(173);
					match(IDPUNCT);
					setState(174);
					match(CONST);
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN) {
					{
					setState(180);
					match(OPEN);
					setState(183);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case CONST:
					case SQOPEN:
						{
						setState(181);
						fof_expr();
						}
						break;
					case QUOTED_STRING:
						{
						setState(182);
						match(QUOTED_STRING);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMASEP) {
						{
						{
						setState(185);
						match(COMMASEP);
						setState(188);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case CONST:
						case SQOPEN:
							{
							setState(186);
							fof_expr();
							}
							break;
						case QUOTED_STRING:
							{
							setState(187);
							match(QUOTED_STRING);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						}
						setState(194);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(195);
					match(CLOSE);
					}
				}

				}
				break;
			case SQOPEN:
				{
				setState(198);
				match(SQOPEN);
				setState(199);
				fof_expr();
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMASEP) {
					{
					{
					setState(200);
					match(COMMASEP);
					setState(201);
					fof_expr();
					}
					}
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(207);
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
		"\u0004\u0001\u001c\u00d4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u00024\b\u0002\n\u0002\f\u00027\t\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003<\b\u0003\n\u0003\f\u0003?\t"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004D\b\u0004\n\u0004"+
		"\f\u0004G\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005L\b\u0005"+
		"\n\u0005\f\u0005O\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"T\b\u0006\n\u0006\f\u0006W\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\\\b\u0007\u0001\b\u0001\b\u0001\b\u0003\ba\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0003\tf\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\nm\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000bw\b\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00a8"+
		"\b\u0014\n\u0014\f\u0014\u00ab\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0005\u0015\u00b0\b\u0015\n\u0015\f\u0015\u00b3\t\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u00b8\b\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u00bd\b\u0015\u0005\u0015\u00bf\b\u0015\n\u0015\f\u0015"+
		"\u00c2\t\u0015\u0001\u0015\u0003\u0015\u00c5\b\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00cb\b\u0015\n\u0015\f\u0015"+
		"\u00ce\t\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00d2\b\u0015\u0001"+
		"\u0015\u0000\u0000\u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*\u0000\u0000\u00d5\u0000,\u0001"+
		"\u0000\u0000\u0000\u0002.\u0001\u0000\u0000\u0000\u00040\u0001\u0000\u0000"+
		"\u0000\u00068\u0001\u0000\u0000\u0000\b@\u0001\u0000\u0000\u0000\nH\u0001"+
		"\u0000\u0000\u0000\fP\u0001\u0000\u0000\u0000\u000e[\u0001\u0000\u0000"+
		"\u0000\u0010`\u0001\u0000\u0000\u0000\u0012e\u0001\u0000\u0000\u0000\u0014"+
		"l\u0001\u0000\u0000\u0000\u0016v\u0001\u0000\u0000\u0000\u0018x\u0001"+
		"\u0000\u0000\u0000\u001a\u007f\u0001\u0000\u0000\u0000\u001c\u0086\u0001"+
		"\u0000\u0000\u0000\u001e\u0088\u0001\u0000\u0000\u0000 \u008f\u0001\u0000"+
		"\u0000\u0000\"\u0096\u0001\u0000\u0000\u0000$\u009b\u0001\u0000\u0000"+
		"\u0000&\u00a2\u0001\u0000\u0000\u0000(\u00a4\u0001\u0000\u0000\u0000*"+
		"\u00d1\u0001\u0000\u0000\u0000,-\u0003\u0002\u0001\u0000-\u0001\u0001"+
		"\u0000\u0000\u0000./\u0003\u0004\u0002\u0000/\u0003\u0001\u0000\u0000"+
		"\u000005\u0003\u0006\u0003\u000012\u0005\u0003\u0000\u000024\u0003\u0006"+
		"\u0003\u000031\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001"+
		"\u0000\u0000\u000056\u0001\u0000\u0000\u00006\u0005\u0001\u0000\u0000"+
		"\u000075\u0001\u0000\u0000\u00008=\u0003\b\u0004\u00009:\u0005\u0004\u0000"+
		"\u0000:<\u0003\b\u0004\u0000;9\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>\u0007\u0001"+
		"\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@E\u0003\n\u0005\u0000AB\u0005"+
		"\b\u0000\u0000BD\u0003\n\u0005\u0000CA\u0001\u0000\u0000\u0000DG\u0001"+
		"\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000"+
		"F\t\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000HM\u0003\f\u0006"+
		"\u0000IJ\u0005\u0005\u0000\u0000JL\u0003\f\u0006\u0000KI\u0001\u0000\u0000"+
		"\u0000LO\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000"+
		"\u0000\u0000N\u000b\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000"+
		"PU\u0003\u000e\u0007\u0000QR\u0005\u0006\u0000\u0000RT\u0003\u000e\u0007"+
		"\u0000SQ\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000"+
		"\u0000\u0000UV\u0001\u0000\u0000\u0000V\r\u0001\u0000\u0000\u0000WU\u0001"+
		"\u0000\u0000\u0000X\\\u0003\u0010\b\u0000YZ\u0005\u0001\u0000\u0000Z\\"+
		"\u0003\u0010\b\u0000[X\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"\\\u000f\u0001\u0000\u0000\u0000]a\u0003\u0012\t\u0000^_\u0005\u0002\u0000"+
		"\u0000_a\u0003\u0012\t\u0000`]\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000"+
		"\u0000a\u0011\u0001\u0000\u0000\u0000bf\u0003\u0014\n\u0000cd\u0005\u0007"+
		"\u0000\u0000df\u0003\u0014\n\u0000eb\u0001\u0000\u0000\u0000ec\u0001\u0000"+
		"\u0000\u0000f\u0013\u0001\u0000\u0000\u0000gm\u0003\u0016\u000b\u0000"+
		"hi\u0005\u0013\u0000\u0000ij\u0003\u0002\u0001\u0000jk\u0005\u0014\u0000"+
		"\u0000km\u0001\u0000\u0000\u0000lg\u0001\u0000\u0000\u0000lh\u0001\u0000"+
		"\u0000\u0000m\u0015\u0001\u0000\u0000\u0000nw\u0003\u0018\f\u0000ow\u0003"+
		"\u001a\r\u0000pw\u0003\u001c\u000e\u0000qw\u0003\u001e\u000f\u0000rw\u0003"+
		" \u0010\u0000sw\u0003\"\u0011\u0000tw\u0003$\u0012\u0000uw\u0003&\u0013"+
		"\u0000vn\u0001\u0000\u0000\u0000vo\u0001\u0000\u0000\u0000vp\u0001\u0000"+
		"\u0000\u0000vq\u0001\u0000\u0000\u0000vr\u0001\u0000\u0000\u0000vs\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vu\u0001\u0000\u0000\u0000"+
		"w\u0017\u0001\u0000\u0000\u0000xy\u0005\t\u0000\u0000yz\u0005\u0013\u0000"+
		"\u0000z{\u0003(\u0014\u0000{|\u0005\u0015\u0000\u0000|}\u0003*\u0015\u0000"+
		"}~\u0005\u0014\u0000\u0000~\u0019\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0005\n\u0000\u0000\u0080\u0081\u0005\u0013\u0000\u0000\u0081\u0082\u0003"+
		"(\u0014\u0000\u0082\u0083\u0005\u0015\u0000\u0000\u0083\u0084\u0003*\u0015"+
		"\u0000\u0084\u0085\u0005\u0014\u0000\u0000\u0085\u001b\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0005\u000b\u0000\u0000\u0087\u001d\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0005\f\u0000\u0000\u0089\u008a\u0005\u0013\u0000\u0000"+
		"\u008a\u008b\u0003(\u0014\u0000\u008b\u008c\u0005\u0015\u0000\u0000\u008c"+
		"\u008d\u0003*\u0015\u0000\u008d\u008e\u0005\u0014\u0000\u0000\u008e\u001f"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0005\r\u0000\u0000\u0090\u0091\u0005"+
		"\u0013\u0000\u0000\u0091\u0092\u0003(\u0014\u0000\u0092\u0093\u0005\u0015"+
		"\u0000\u0000\u0093\u0094\u0003*\u0015\u0000\u0094\u0095\u0005\u0014\u0000"+
		"\u0000\u0095!\u0001\u0000\u0000\u0000\u0096\u0097\u0005\u000e\u0000\u0000"+
		"\u0097\u0098\u0005\u0013\u0000\u0000\u0098\u0099\u0003*\u0015\u0000\u0099"+
		"\u009a\u0005\u0014\u0000\u0000\u009a#\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0005\u0010\u0000\u0000\u009c\u009d\u0005\u0013\u0000\u0000\u009d\u009e"+
		"\u0003(\u0014\u0000\u009e\u009f\u0005\u0015\u0000\u0000\u009f\u00a0\u0003"+
		"*\u0015\u0000\u00a0\u00a1\u0005\u0014\u0000\u0000\u00a1%\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0005\u000f\u0000\u0000\u00a3\'\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a9\u0005\u0011\u0000\u0000\u00a5\u00a6\u0005\u0016\u0000\u0000"+
		"\u00a6\u00a8\u0005\u0011\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa)\u0001\u0000\u0000\u0000\u00ab"+
		"\u00a9\u0001\u0000\u0000\u0000\u00ac\u00b1\u0005\u0011\u0000\u0000\u00ad"+
		"\u00ae\u0005\u0016\u0000\u0000\u00ae\u00b0\u0005\u0011\u0000\u0000\u00af"+
		"\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1"+
		"\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2"+
		"\u00c4\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b7\u0005\u0013\u0000\u0000\u00b5\u00b8\u0003*\u0015\u0000\u00b6\u00b8"+
		"\u0005\u0012\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b8\u00c0\u0001\u0000\u0000\u0000\u00b9\u00bc"+
		"\u0005\u0015\u0000\u0000\u00ba\u00bd\u0003*\u0015\u0000\u00bb\u00bd\u0005"+
		"\u0012\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bb\u0001"+
		"\u0000\u0000\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be\u00b9\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000\u00c0\u00be\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c5\u0005"+
		"\u0014\u0000\u0000\u00c4\u00b4\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c5\u00d2\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005"+
		"\u0017\u0000\u0000\u00c7\u00cc\u0003*\u0015\u0000\u00c8\u00c9\u0005\u0015"+
		"\u0000\u0000\u00c9\u00cb\u0003*\u0015\u0000\u00ca\u00c8\u0001\u0000\u0000"+
		"\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cf\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u0018\u0000"+
		"\u0000\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1\u00ac\u0001\u0000\u0000"+
		"\u0000\u00d1\u00c6\u0001\u0000\u0000\u0000\u00d2+\u0001\u0000\u0000\u0000"+
		"\u00125=EMU[`elv\u00a9\u00b1\u00b7\u00bc\u00c0\u00c4\u00cc\u00d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}