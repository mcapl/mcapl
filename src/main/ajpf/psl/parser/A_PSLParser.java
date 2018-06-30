// Generated from A_PSL.g4 by ANTLR 4.4
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
public class A_PSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLOSE=20, SQCLOSE=24, FINALLY=2, ALWAYS=1, COMMENT=25, SQOPEN=23, COMMASEP=21, 
		CONST=17, INTENTION=12, WS=28, BELIEVE=9, IDPUNCT=22, OR=6, NEWLINE=27, 
		TRUE=15, INTENDTODO=16, RELEASE=4, UNTIL=3, IMP=8, OPEN=19, PERCEPT=14, 
		NOT=7, GOAL=10, LINE_COMMENT=26, ACTION=13, AND=5, FALSE=11, QUOTED_STRING=18;
	public static final String[] tokenNames = {
		"<INVALID>", "ALWAYS", "FINALLY", "'U'", "'R'", "'&'", "'||'", "'~'", 
		"'->'", "'B'", "'G'", "'F'", "'I'", "'D'", "'P'", "'T'", "'ItD'", "CONST", 
		"QUOTED_STRING", "'('", "')'", "','", "'.'", "'['", "']'", "COMMENT", 
		"LINE_COMMENT", "NEWLINE", "WS"
	};
	public static final int
		RULE_spec = 0, RULE_property = 1, RULE_untilproperty = 2, RULE_releaseproperty = 3, 
		RULE_impproperty = 4, RULE_andproperty = 5, RULE_orproperty = 6, RULE_alwaysproperty = 7, 
		RULE_finallyproperty = 8, RULE_notproperty = 9, RULE_atom = 10, RULE_proposition = 11, 
		RULE_beliefproperty = 12, RULE_goalproperty = 13, RULE_falseprop = 14, 
		RULE_intentionproperty = 15, RULE_lastactionproperty = 16, RULE_perceptproperty = 17, 
		RULE_intendtodoproperty = 18, RULE_trueprop = 19, RULE_agentname = 20, 
		RULE_fof_expr = 21;
	public static final String[] ruleNames = {
		"spec", "property", "untilproperty", "releaseproperty", "impproperty", 
		"andproperty", "orproperty", "alwaysproperty", "finallyproperty", "notproperty", 
		"atom", "proposition", "beliefproperty", "goalproperty", "falseprop", 
		"intentionproperty", "lastactionproperty", "perceptproperty", "intendtodoproperty", 
		"trueprop", "agentname", "fof_expr"
	};

	@Override
	public String getGrammarFileName() { return "A_PSL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
			setState(44); ((SpecContext)_localctx).p = property();
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
			setState(46); untilproperty();
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

	public static class UntilpropertyContext extends ParserRuleContext {
		public List<ReleasepropertyContext> releaseproperty() {
			return getRuleContexts(ReleasepropertyContext.class);
		}
		public TerminalNode UNTIL(int i) {
			return getToken(A_PSLParser.UNTIL, i);
		}
		public List<TerminalNode> UNTIL() { return getTokens(A_PSLParser.UNTIL); }
		public ReleasepropertyContext releaseproperty(int i) {
			return getRuleContext(ReleasepropertyContext.class,i);
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
			setState(48); releaseproperty();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UNTIL) {
				{
				{
				setState(49); match(UNTIL);
				setState(50); releaseproperty();
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

	public static class ReleasepropertyContext extends ParserRuleContext {
		public List<ImppropertyContext> impproperty() {
			return getRuleContexts(ImppropertyContext.class);
		}
		public TerminalNode RELEASE(int i) {
			return getToken(A_PSLParser.RELEASE, i);
		}
		public ImppropertyContext impproperty(int i) {
			return getRuleContext(ImppropertyContext.class,i);
		}
		public List<TerminalNode> RELEASE() { return getTokens(A_PSLParser.RELEASE); }
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
			setState(56); impproperty();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RELEASE) {
				{
				{
				setState(57); match(RELEASE);
				setState(58); impproperty();
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

	public static class ImppropertyContext extends ParserRuleContext {
		public TerminalNode IMP(int i) {
			return getToken(A_PSLParser.IMP, i);
		}
		public List<AndpropertyContext> andproperty() {
			return getRuleContexts(AndpropertyContext.class);
		}
		public List<TerminalNode> IMP() { return getTokens(A_PSLParser.IMP); }
		public AndpropertyContext andproperty(int i) {
			return getRuleContext(AndpropertyContext.class,i);
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
			setState(64); andproperty();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMP) {
				{
				{
				setState(65); match(IMP);
				setState(66); andproperty();
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

	public static class AndpropertyContext extends ParserRuleContext {
		public TerminalNode AND(int i) {
			return getToken(A_PSLParser.AND, i);
		}
		public List<OrpropertyContext> orproperty() {
			return getRuleContexts(OrpropertyContext.class);
		}
		public List<TerminalNode> AND() { return getTokens(A_PSLParser.AND); }
		public OrpropertyContext orproperty(int i) {
			return getRuleContext(OrpropertyContext.class,i);
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
			setState(72); orproperty();
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(73); match(AND);
				setState(74); orproperty();
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
			setState(80); alwaysproperty();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(81); match(OR);
				setState(82); alwaysproperty();
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
				setState(88); finallyproperty();
				}
				break;
			case ALWAYS:
				enterOuterAlt(_localctx, 2);
				{
				setState(89); match(ALWAYS);
				setState(90); finallyproperty();
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
				setState(93); notproperty();
				}
				break;
			case FINALLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(94); match(FINALLY);
				setState(95); notproperty();
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

	public static class NotpropertyContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(A_PSLParser.NOT, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
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
				setState(98); atom();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(99); match(NOT);
				setState(100); atom();
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
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
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
				setState(103); proposition();
				}
				break;
			case OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(104); match(OPEN);
				setState(105); property();
				setState(106); match(CLOSE);
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

	public static class PropositionContext extends ParserRuleContext {
		public GoalpropertyContext goalproperty() {
			return getRuleContext(GoalpropertyContext.class,0);
		}
		public FalsepropContext falseprop() {
			return getRuleContext(FalsepropContext.class,0);
		}
		public IntentionpropertyContext intentionproperty() {
			return getRuleContext(IntentionpropertyContext.class,0);
		}
		public PerceptpropertyContext perceptproperty() {
			return getRuleContext(PerceptpropertyContext.class,0);
		}
		public TruepropContext trueprop() {
			return getRuleContext(TruepropContext.class,0);
		}
		public LastactionpropertyContext lastactionproperty() {
			return getRuleContext(LastactionpropertyContext.class,0);
		}
		public IntendtodopropertyContext intendtodoproperty() {
			return getRuleContext(IntendtodopropertyContext.class,0);
		}
		public BeliefpropertyContext beliefproperty() {
			return getRuleContext(BeliefpropertyContext.class,0);
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
			switch (_input.LA(1)) {
			case BELIEVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(110); beliefproperty();
				}
				break;
			case GOAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(111); goalproperty();
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(112); falseprop();
				}
				break;
			case INTENTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(113); intentionproperty();
				}
				break;
			case ACTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(114); lastactionproperty();
				}
				break;
			case PERCEPT:
				enterOuterAlt(_localctx, 6);
				{
				setState(115); perceptproperty();
				}
				break;
			case INTENDTODO:
				enterOuterAlt(_localctx, 7);
				{
				setState(116); intendtodoproperty();
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 8);
				{
				setState(117); trueprop();
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

	public static class BeliefpropertyContext extends ParserRuleContext {
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public TerminalNode BELIEVE() { return getToken(A_PSLParser.BELIEVE, 0); }
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
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
			setState(120); match(BELIEVE);
			setState(121); match(OPEN);
			setState(122); agentname();
			setState(123); match(COMMASEP);
			setState(124); fof_expr();
			setState(125); match(CLOSE);
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

	public static class GoalpropertyContext extends ParserRuleContext {
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public TerminalNode GOAL() { return getToken(A_PSLParser.GOAL, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
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
			setState(127); match(GOAL);
			setState(128); match(OPEN);
			setState(129); agentname();
			setState(130); match(COMMASEP);
			setState(131); fof_expr();
			setState(132); match(CLOSE);
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
			setState(134); match(FALSE);
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

	public static class IntentionpropertyContext extends ParserRuleContext {
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public TerminalNode INTENTION() { return getToken(A_PSLParser.INTENTION, 0); }
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
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
			setState(136); match(INTENTION);
			setState(137); match(OPEN);
			setState(138); agentname();
			setState(139); match(COMMASEP);
			setState(140); fof_expr();
			setState(141); match(CLOSE);
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

	public static class LastactionpropertyContext extends ParserRuleContext {
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public TerminalNode ACTION() { return getToken(A_PSLParser.ACTION, 0); }
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
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
			setState(143); match(ACTION);
			setState(144); match(OPEN);
			setState(145); agentname();
			setState(146); match(COMMASEP);
			setState(147); fof_expr();
			setState(148); match(CLOSE);
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

	public static class PerceptpropertyContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode PERCEPT() { return getToken(A_PSLParser.PERCEPT, 0); }
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
			setState(150); match(PERCEPT);
			setState(151); match(OPEN);
			setState(152); fof_expr();
			setState(153); match(CLOSE);
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

	public static class IntendtodopropertyContext extends ParserRuleContext {
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public Fof_exprContext fof_expr() {
			return getRuleContext(Fof_exprContext.class,0);
		}
		public TerminalNode INTENDTODO() { return getToken(A_PSLParser.INTENDTODO, 0); }
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
			setState(155); match(INTENDTODO);
			setState(156); match(OPEN);
			setState(157); agentname();
			setState(158); match(COMMASEP);
			setState(159); fof_expr();
			setState(160); match(CLOSE);
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
			setState(162); match(TRUE);
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

	public static class AgentnameContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(A_PSLParser.CONST, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164); match(CONST);
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
		public List<TerminalNode> CONST() { return getTokens(A_PSLParser.CONST); }
		public TerminalNode IDPUNCT(int i) {
			return getToken(A_PSLParser.IDPUNCT, i);
		}
		public TerminalNode QUOTED_STRING(int i) {
			return getToken(A_PSLParser.QUOTED_STRING, i);
		}
		public List<Fof_exprContext> fof_expr() {
			return getRuleContexts(Fof_exprContext.class);
		}
		public Fof_exprContext fof_expr(int i) {
			return getRuleContext(Fof_exprContext.class,i);
		}
		public TerminalNode OPEN() { return getToken(A_PSLParser.OPEN, 0); }
		public TerminalNode COMMASEP(int i) {
			return getToken(A_PSLParser.COMMASEP, i);
		}
		public List<TerminalNode> COMMASEP() { return getTokens(A_PSLParser.COMMASEP); }
		public List<TerminalNode> QUOTED_STRING() { return getTokens(A_PSLParser.QUOTED_STRING); }
		public TerminalNode CONST(int i) {
			return getToken(A_PSLParser.CONST, i);
		}
		public TerminalNode SQOPEN() { return getToken(A_PSLParser.SQOPEN, 0); }
		public TerminalNode CLOSE() { return getToken(A_PSLParser.CLOSE, 0); }
		public List<TerminalNode> IDPUNCT() { return getTokens(A_PSLParser.IDPUNCT); }
		public TerminalNode SQCLOSE() { return getToken(A_PSLParser.SQCLOSE, 0); }
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
			setState(203);
			switch (_input.LA(1)) {
			case CONST:
				{
				setState(166); match(CONST);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDPUNCT) {
					{
					{
					setState(167); match(IDPUNCT);
					setState(168); match(CONST);
					}
					}
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(190);
				_la = _input.LA(1);
				if (_la==OPEN) {
					{
					setState(174); match(OPEN);
					setState(177);
					switch (_input.LA(1)) {
					case CONST:
					case SQOPEN:
						{
						setState(175); fof_expr();
						}
						break;
					case QUOTED_STRING:
						{
						setState(176); match(QUOTED_STRING);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(186);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMASEP) {
						{
						{
						setState(179); match(COMMASEP);
						setState(182);
						switch (_input.LA(1)) {
						case CONST:
						case SQOPEN:
							{
							setState(180); fof_expr();
							}
							break;
						case QUOTED_STRING:
							{
							setState(181); match(QUOTED_STRING);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						}
						setState(188);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(189); match(CLOSE);
					}
				}

				}
				break;
			case SQOPEN:
				{
				setState(192); match(SQOPEN);
				setState(193); fof_expr();
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMASEP) {
					{
					{
					setState(194); match(COMMASEP);
					setState(195); fof_expr();
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(201); match(SQCLOSE);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\36\u00d0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\4\7\4\66\n\4\f\4\16\49\13\4\3\5\3\5\3\5\7\5>\n\5\f\5\16\5A\13\5"+
		"\3\6\3\6\3\6\7\6F\n\6\f\6\16\6I\13\6\3\7\3\7\3\7\7\7N\n\7\f\7\16\7Q\13"+
		"\7\3\b\3\b\3\b\7\bV\n\b\f\b\16\bY\13\b\3\t\3\t\3\t\5\t^\n\t\3\n\3\n\3"+
		"\n\5\nc\n\n\3\13\3\13\3\13\5\13h\n\13\3\f\3\f\3\f\3\f\3\f\5\fo\n\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\ry\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\27\7\27\u00ac\n\27\f\27\16\27\u00af\13\27\3\27\3\27\3\27\5\27\u00b4\n"+
		"\27\3\27\3\27\3\27\5\27\u00b9\n\27\7\27\u00bb\n\27\f\27\16\27\u00be\13"+
		"\27\3\27\5\27\u00c1\n\27\3\27\3\27\3\27\3\27\7\27\u00c7\n\27\f\27\16\27"+
		"\u00ca\13\27\3\27\3\27\5\27\u00ce\n\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,\2\2\u00d0\2.\3\2\2\2\4\60\3\2\2\2\6\62\3\2"+
		"\2\2\b:\3\2\2\2\nB\3\2\2\2\fJ\3\2\2\2\16R\3\2\2\2\20]\3\2\2\2\22b\3\2"+
		"\2\2\24g\3\2\2\2\26n\3\2\2\2\30x\3\2\2\2\32z\3\2\2\2\34\u0081\3\2\2\2"+
		"\36\u0088\3\2\2\2 \u008a\3\2\2\2\"\u0091\3\2\2\2$\u0098\3\2\2\2&\u009d"+
		"\3\2\2\2(\u00a4\3\2\2\2*\u00a6\3\2\2\2,\u00cd\3\2\2\2./\5\4\3\2/\3\3\2"+
		"\2\2\60\61\5\6\4\2\61\5\3\2\2\2\62\67\5\b\5\2\63\64\7\5\2\2\64\66\5\b"+
		"\5\2\65\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\7\3\2\2\29\67"+
		"\3\2\2\2:?\5\n\6\2;<\7\6\2\2<>\5\n\6\2=;\3\2\2\2>A\3\2\2\2?=\3\2\2\2?"+
		"@\3\2\2\2@\t\3\2\2\2A?\3\2\2\2BG\5\f\7\2CD\7\n\2\2DF\5\f\7\2EC\3\2\2\2"+
		"FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\13\3\2\2\2IG\3\2\2\2JO\5\16\b\2KL\7\7"+
		"\2\2LN\5\16\b\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\r\3\2\2\2QO\3"+
		"\2\2\2RW\5\20\t\2ST\7\b\2\2TV\5\20\t\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2W"+
		"X\3\2\2\2X\17\3\2\2\2YW\3\2\2\2Z^\5\22\n\2[\\\7\3\2\2\\^\5\22\n\2]Z\3"+
		"\2\2\2][\3\2\2\2^\21\3\2\2\2_c\5\24\13\2`a\7\4\2\2ac\5\24\13\2b_\3\2\2"+
		"\2b`\3\2\2\2c\23\3\2\2\2dh\5\26\f\2ef\7\t\2\2fh\5\26\f\2gd\3\2\2\2ge\3"+
		"\2\2\2h\25\3\2\2\2io\5\30\r\2jk\7\25\2\2kl\5\4\3\2lm\7\26\2\2mo\3\2\2"+
		"\2ni\3\2\2\2nj\3\2\2\2o\27\3\2\2\2py\5\32\16\2qy\5\34\17\2ry\5\36\20\2"+
		"sy\5 \21\2ty\5\"\22\2uy\5$\23\2vy\5&\24\2wy\5(\25\2xp\3\2\2\2xq\3\2\2"+
		"\2xr\3\2\2\2xs\3\2\2\2xt\3\2\2\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2\2y\31\3\2"+
		"\2\2z{\7\13\2\2{|\7\25\2\2|}\5*\26\2}~\7\27\2\2~\177\5,\27\2\177\u0080"+
		"\7\26\2\2\u0080\33\3\2\2\2\u0081\u0082\7\f\2\2\u0082\u0083\7\25\2\2\u0083"+
		"\u0084\5*\26\2\u0084\u0085\7\27\2\2\u0085\u0086\5,\27\2\u0086\u0087\7"+
		"\26\2\2\u0087\35\3\2\2\2\u0088\u0089\7\r\2\2\u0089\37\3\2\2\2\u008a\u008b"+
		"\7\16\2\2\u008b\u008c\7\25\2\2\u008c\u008d\5*\26\2\u008d\u008e\7\27\2"+
		"\2\u008e\u008f\5,\27\2\u008f\u0090\7\26\2\2\u0090!\3\2\2\2\u0091\u0092"+
		"\7\17\2\2\u0092\u0093\7\25\2\2\u0093\u0094\5*\26\2\u0094\u0095\7\27\2"+
		"\2\u0095\u0096\5,\27\2\u0096\u0097\7\26\2\2\u0097#\3\2\2\2\u0098\u0099"+
		"\7\20\2\2\u0099\u009a\7\25\2\2\u009a\u009b\5,\27\2\u009b\u009c\7\26\2"+
		"\2\u009c%\3\2\2\2\u009d\u009e\7\22\2\2\u009e\u009f\7\25\2\2\u009f\u00a0"+
		"\5*\26\2\u00a0\u00a1\7\27\2\2\u00a1\u00a2\5,\27\2\u00a2\u00a3\7\26\2\2"+
		"\u00a3\'\3\2\2\2\u00a4\u00a5\7\21\2\2\u00a5)\3\2\2\2\u00a6\u00a7\7\23"+
		"\2\2\u00a7+\3\2\2\2\u00a8\u00ad\7\23\2\2\u00a9\u00aa\7\30\2\2\u00aa\u00ac"+
		"\7\23\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2"+
		"\u00ad\u00ae\3\2\2\2\u00ae\u00c0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b3"+
		"\7\25\2\2\u00b1\u00b4\5,\27\2\u00b2\u00b4\7\24\2\2\u00b3\u00b1\3\2\2\2"+
		"\u00b3\u00b2\3\2\2\2\u00b4\u00bc\3\2\2\2\u00b5\u00b8\7\27\2\2\u00b6\u00b9"+
		"\5,\27\2\u00b7\u00b9\7\24\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2"+
		"\u00b9\u00bb\3\2\2\2\u00ba\u00b5\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c1\7\26\2\2\u00c0\u00b0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00ce\3"+
		"\2\2\2\u00c2\u00c3\7\31\2\2\u00c3\u00c8\5,\27\2\u00c4\u00c5\7\27\2\2\u00c5"+
		"\u00c7\5,\27\2\u00c6\u00c4\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2"+
		"\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb"+
		"\u00cc\7\32\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00a8\3\2\2\2\u00cd\u00c2\3"+
		"\2\2\2\u00ce-\3\2\2\2\23\67?GOW]bgnx\u00ad\u00b3\u00b8\u00bc\u00c0\u00c8"+
		"\u00cd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}