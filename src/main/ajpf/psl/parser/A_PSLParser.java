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
		FOF_BLOCK=17, OR=6, NEWLINE=20, TRUE=15, INTENDTODO=16, RELEASE=4, FINALLY=2, 
		UNTIL=3, ALWAYS=1, IMP=8, COMMENT=18, PERCEPT=14, NOT=7, GOAL=10, LINE_COMMENT=19, 
		ACTION=13, AND=5, INTENTION=12, FALSE=11, WS=21, BELIEVE=9, OPENBRACKET=22, 
		CLOSEBRACKET=23, COMMASEP=24, CONST=25, NUMBER=26, UNNAMED_VAR=27, SQOPENBRACKET=28, 
		SQCLOSEBRACKET=29;
	public static final String[] tokenNames = {
		"<INVALID>", "ALWAYS", "FINALLY", "'U'", "'R'", "'&'", "'||'", "'~'", 
		"'->'", "'B'", "'G'", "'F'", "'I'", "'D'", "'P'", "'T'", "'ItD'", "FOF_BLOCK", 
		"COMMENT", "LINE_COMMENT", "NEWLINE", "WS", "OPENBRACKET", "CLOSEBRACKET", 
		"COMMASEP", "CONST", "NUMBER", "UNNAMED_VAR", "SQOPENBRACKET", "SQCLOSEBRACKET"
	};
	public static final int
		RULE_spec = 0, RULE_property = 1, RULE_untilproperty = 2, RULE_releaseproperty = 3, 
		RULE_impproperty = 4, RULE_andproperty = 5, RULE_orproperty = 6, RULE_alwaysproperty = 7, 
		RULE_finallyproperty = 8, RULE_notproperty = 9, RULE_atom = 10, RULE_proposition = 11, 
		RULE_beliefproperty = 12, RULE_goalproperty = 13, RULE_falseprop = 14, 
		RULE_intentionproperty = 15, RULE_lastactionproperty = 16, RULE_perceptproperty = 17, 
		RULE_intendtodoproperty = 18, RULE_trueprop = 19, RULE_agentname = 20, 
		RULE_formula = 21, RULE_subformula = 22, RULE_terms = 23;
	public static final String[] ruleNames = {
		"spec", "property", "untilproperty", "releaseproperty", "impproperty", 
		"andproperty", "orproperty", "alwaysproperty", "finallyproperty", "notproperty", 
		"atom", "proposition", "beliefproperty", "goalproperty", "falseprop", 
		"intentionproperty", "lastactionproperty", "perceptproperty", "intendtodoproperty", 
		"trueprop", "agentname", "formula", "subformula", "terms"
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
		public Abstract_Property p1;
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
			setState(48); ((SpecContext)_localctx).p = property();
			((SpecContext)_localctx).p1 =  ((SpecContext)_localctx).p.p1;
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
		public Abstract_Property p1;
		public UntilpropertyContext p;
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
			setState(51); ((PropertyContext)_localctx).p = untilproperty();
			((PropertyContext)_localctx).p1 =  ((PropertyContext)_localctx).p.p;
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
		public Abstract_Property p;
		public ReleasepropertyContext rp;
		public ReleasepropertyContext a;
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
			setState(54); ((UntilpropertyContext)_localctx).rp = releaseproperty();
			Abstract_Property prop = ((UntilpropertyContext)_localctx).rp.p;
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UNTIL) {
				{
				{
				setState(56); match(UNTIL);
				setState(57); ((UntilpropertyContext)_localctx).a = releaseproperty();
				prop = new Abstract_Until(prop, ((UntilpropertyContext)_localctx).a.p);
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((UntilpropertyContext)_localctx).p =  prop;
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
		public Abstract_Property p;
		public ImppropertyContext ip;
		public ImppropertyContext a;
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
			setState(67); ((ReleasepropertyContext)_localctx).ip = impproperty();
			Abstract_Property prop = ((ReleasepropertyContext)_localctx).ip.p;
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RELEASE) {
				{
				{
				setState(69); match(RELEASE);
				setState(70); ((ReleasepropertyContext)_localctx).a = impproperty();
				prop = new Abstract_Release(prop, ((ReleasepropertyContext)_localctx).a.p);
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((ReleasepropertyContext)_localctx).p =  prop;
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
		public Abstract_Property p;
		public AndpropertyContext ap;
		public AndpropertyContext a;
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
			setState(80); ((ImppropertyContext)_localctx).ap = andproperty();
			Abstract_Property prop = ((ImppropertyContext)_localctx).ap.p;
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMP) {
				{
				{
				setState(82); match(IMP);
				setState(83); ((ImppropertyContext)_localctx).a = andproperty();
				prop = new Abstract_Or(new Abstract_Not(prop), ((ImppropertyContext)_localctx).a.p);
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((ImppropertyContext)_localctx).p =  prop;
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
		public Abstract_Property p;
		public OrpropertyContext at;
		public OrpropertyContext a;
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
			setState(93); ((AndpropertyContext)_localctx).at = orproperty();
			Abstract_Property prop = ((AndpropertyContext)_localctx).at.p;
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(95); match(AND);
				setState(96); ((AndpropertyContext)_localctx).a = orproperty();
				prop = new Abstract_And(prop, ((AndpropertyContext)_localctx).a.p);
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((AndpropertyContext)_localctx).p =  prop;
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
		public Abstract_Property p;
		public AlwayspropertyContext at;
		public AlwayspropertyContext a;
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
			setState(106); ((OrpropertyContext)_localctx).at = alwaysproperty();
			Abstract_Property prop = ((OrpropertyContext)_localctx).at.p;
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(108); match(OR);
				setState(109); ((OrpropertyContext)_localctx).a = alwaysproperty();
				prop = new Abstract_Or(prop, ((OrpropertyContext)_localctx).a.p);
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((OrpropertyContext)_localctx).p =  prop;
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
		public Abstract_Property p;
		public FinallypropertyContext np;
		public FinallypropertyContext pl;
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
			setState(126);
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
			case OPENBRACKET:
				enterOuterAlt(_localctx, 1);
				{
				setState(119); ((AlwayspropertyContext)_localctx).np = finallyproperty();
				((AlwayspropertyContext)_localctx).p =  ((AlwayspropertyContext)_localctx).np.p;
				}
				break;
			case ALWAYS:
				enterOuterAlt(_localctx, 2);
				{
				setState(122); match(ALWAYS);
				setState(123); ((AlwayspropertyContext)_localctx).pl = finallyproperty();
				((AlwayspropertyContext)_localctx).p =  new Abstract_Always(((AlwayspropertyContext)_localctx).pl.p);
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
		public Abstract_Property p;
		public NotpropertyContext np;
		public NotpropertyContext pl;
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
			setState(135);
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
			case OPENBRACKET:
				enterOuterAlt(_localctx, 1);
				{
				setState(128); ((FinallypropertyContext)_localctx).np = notproperty();
				((FinallypropertyContext)_localctx).p =  ((FinallypropertyContext)_localctx).np.p;
				}
				break;
			case FINALLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(131); match(FINALLY);
				setState(132); ((FinallypropertyContext)_localctx).pl = notproperty();
				((FinallypropertyContext)_localctx).p =  new Abstract_Finally(((FinallypropertyContext)_localctx).pl.p);
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
		public Abstract_Property p;
		public AtomContext at;
		public AtomContext p1;
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
			setState(144);
			switch (_input.LA(1)) {
			case BELIEVE:
			case GOAL:
			case FALSE:
			case INTENTION:
			case ACTION:
			case PERCEPT:
			case TRUE:
			case INTENDTODO:
			case OPENBRACKET:
				enterOuterAlt(_localctx, 1);
				{
				setState(137); ((NotpropertyContext)_localctx).at = atom();
				((NotpropertyContext)_localctx).p =  ((NotpropertyContext)_localctx).at.p;
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(140); match(NOT);
				setState(141); ((NotpropertyContext)_localctx).p1 = atom();
				((NotpropertyContext)_localctx).p =  new Abstract_Not(((NotpropertyContext)_localctx).p1.p);
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
		public Abstract_Property p;
		public PropositionContext prop;
		public PropertyContext tp;
		public TerminalNode OPENBRACKET() { return getToken(A_PSLParser.OPENBRACKET, 0); }
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(A_PSLParser.CLOSEBRACKET, 0); }
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
			setState(154);
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
				setState(146); ((AtomContext)_localctx).prop = proposition();
				((AtomContext)_localctx).p =  ((AtomContext)_localctx).prop.p1;
				}
				break;
			case OPENBRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(149); match(OPENBRACKET);
				setState(150); ((AtomContext)_localctx).tp = property();
				((AtomContext)_localctx).p =  ((AtomContext)_localctx).tp.p1;
				setState(152); match(CLOSEBRACKET);
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
		public Abstract_Proposition p1;
		public BeliefpropertyContext p2;
		public GoalpropertyContext p3;
		public FalsepropContext p4;
		public IntentionpropertyContext p5;
		public LastactionpropertyContext p6;
		public PerceptpropertyContext p7;
		public IntendtodopropertyContext p8;
		public TruepropContext p;
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
			setState(180);
			switch (_input.LA(1)) {
			case BELIEVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(156); ((PropositionContext)_localctx).p2 = beliefproperty();
				((PropositionContext)_localctx).p1 =  (Abstract_Proposition) ((PropositionContext)_localctx).p2.p;
				}
				break;
			case GOAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(159); ((PropositionContext)_localctx).p3 = goalproperty();
				((PropositionContext)_localctx).p1 =  (Abstract_Proposition) ((PropositionContext)_localctx).p3.p;
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(162); ((PropositionContext)_localctx).p4 = falseprop();
				((PropositionContext)_localctx).p1 =  (Abstract_Proposition) ((PropositionContext)_localctx).p4.p;
				}
				break;
			case INTENTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(165); ((PropositionContext)_localctx).p5 = intentionproperty();
				((PropositionContext)_localctx).p1 =  (Abstract_Proposition) ((PropositionContext)_localctx).p5.p;
				}
				break;
			case ACTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(168); ((PropositionContext)_localctx).p6 = lastactionproperty();
				((PropositionContext)_localctx).p1 =  (Abstract_Proposition) ((PropositionContext)_localctx).p6.p;
				}
				break;
			case PERCEPT:
				enterOuterAlt(_localctx, 6);
				{
				setState(171); ((PropositionContext)_localctx).p7 = perceptproperty();
				((PropositionContext)_localctx).p1 =  (Abstract_Proposition) ((PropositionContext)_localctx).p7.p;
				}
				break;
			case INTENDTODO:
				enterOuterAlt(_localctx, 7);
				{
				setState(174); ((PropositionContext)_localctx).p8 = intendtodoproperty();
				((PropositionContext)_localctx).p1 =  (Abstract_Proposition) ((PropositionContext)_localctx).p8.p;
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 8);
				{
				setState(177); ((PropositionContext)_localctx).p = trueprop();
				((PropositionContext)_localctx).p1 =  (Abstract_Proposition) ((PropositionContext)_localctx).p.p;
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
		public Abstract_AgBelief p;
		public AgentnameContext ag;
		public FormulaContext f;
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode OPENBRACKET() { return getToken(A_PSLParser.OPENBRACKET, 0); }
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public TerminalNode BELIEVE() { return getToken(A_PSLParser.BELIEVE, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(A_PSLParser.CLOSEBRACKET, 0); }
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
			setState(182); match(BELIEVE);
			setState(183); match(OPENBRACKET);
			setState(184); ((BeliefpropertyContext)_localctx).ag = agentname();
			setState(185); match(COMMASEP);
			setState(186); ((BeliefpropertyContext)_localctx).f = formula();
			setState(187); match(CLOSEBRACKET);
			((BeliefpropertyContext)_localctx).p =  new Abstract_AgBelief(((BeliefpropertyContext)_localctx).ag.s, (Abstract_Formula) ((BeliefpropertyContext)_localctx).f.f);
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
		public Abstract_AgGoal p;
		public AgentnameContext ag;
		public FormulaContext f;
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode OPENBRACKET() { return getToken(A_PSLParser.OPENBRACKET, 0); }
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode GOAL() { return getToken(A_PSLParser.GOAL, 0); }
		public TerminalNode CLOSEBRACKET() { return getToken(A_PSLParser.CLOSEBRACKET, 0); }
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
			setState(190); match(GOAL);
			setState(191); match(OPENBRACKET);
			setState(192); ((GoalpropertyContext)_localctx).ag = agentname();
			setState(193); match(COMMASEP);
			setState(194); ((GoalpropertyContext)_localctx).f = formula();
			setState(195); match(CLOSEBRACKET);
			((GoalpropertyContext)_localctx).p =  new Abstract_AgGoal(((GoalpropertyContext)_localctx).ag.s, (Abstract_Formula) ((GoalpropertyContext)_localctx).f.f);
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
		public Abstract_FalseProp p;
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
			setState(198); match(FALSE);
			((FalsepropContext)_localctx).p =  new Abstract_FalseProp();
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
		public Abstract_AgIntention p;
		public AgentnameContext ag;
		public FormulaContext f;
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode INTENTION() { return getToken(A_PSLParser.INTENTION, 0); }
		public TerminalNode OPENBRACKET() { return getToken(A_PSLParser.OPENBRACKET, 0); }
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(A_PSLParser.CLOSEBRACKET, 0); }
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
			setState(201); match(INTENTION);
			setState(202); match(OPENBRACKET);
			setState(203); ((IntentionpropertyContext)_localctx).ag = agentname();
			setState(204); match(COMMASEP);
			setState(205); ((IntentionpropertyContext)_localctx).f = formula();
			setState(206); match(CLOSEBRACKET);
			((IntentionpropertyContext)_localctx).p =  new Abstract_AgIntention(((IntentionpropertyContext)_localctx).ag.s, (Abstract_Formula) ((IntentionpropertyContext)_localctx).f.f);
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
		public Abstract_LastAction p;
		public AgentnameContext ag;
		public FormulaContext f;
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode OPENBRACKET() { return getToken(A_PSLParser.OPENBRACKET, 0); }
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public TerminalNode ACTION() { return getToken(A_PSLParser.ACTION, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(A_PSLParser.CLOSEBRACKET, 0); }
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
			setState(209); match(ACTION);
			setState(210); match(OPENBRACKET);
			setState(211); ((LastactionpropertyContext)_localctx).ag = agentname();
			setState(212); match(COMMASEP);
			setState(213); ((LastactionpropertyContext)_localctx).f = formula();
			setState(214); match(CLOSEBRACKET);
			((LastactionpropertyContext)_localctx).p =  new Abstract_LastAction(((LastactionpropertyContext)_localctx).ag.s, (Abstract_Formula) ((LastactionpropertyContext)_localctx).f.f);
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
		public Abstract_Percept p;
		public FormulaContext f;
		public TerminalNode OPENBRACKET() { return getToken(A_PSLParser.OPENBRACKET, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(A_PSLParser.CLOSEBRACKET, 0); }
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
			setState(217); match(PERCEPT);
			setState(218); match(OPENBRACKET);
			setState(219); ((PerceptpropertyContext)_localctx).f = formula();
			setState(220); match(CLOSEBRACKET);
			((PerceptpropertyContext)_localctx).p =  new Abstract_Percept((Abstract_Formula) ((PerceptpropertyContext)_localctx).f.f);
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
		public Abstract_AgIntendToDo p;
		public AgentnameContext ag;
		public FormulaContext f;
		public AgentnameContext agentname() {
			return getRuleContext(AgentnameContext.class,0);
		}
		public TerminalNode OPENBRACKET() { return getToken(A_PSLParser.OPENBRACKET, 0); }
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode INTENDTODO() { return getToken(A_PSLParser.INTENDTODO, 0); }
		public TerminalNode CLOSEBRACKET() { return getToken(A_PSLParser.CLOSEBRACKET, 0); }
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
			setState(223); match(INTENDTODO);
			setState(224); match(OPENBRACKET);
			setState(225); ((IntendtodopropertyContext)_localctx).ag = agentname();
			setState(226); match(COMMASEP);
			setState(227); ((IntendtodopropertyContext)_localctx).f = formula();
			setState(228); match(CLOSEBRACKET);
			((IntendtodopropertyContext)_localctx).p =  new Abstract_AgIntendToDo(((IntendtodopropertyContext)_localctx).ag.s, (Abstract_Formula) ((IntendtodopropertyContext)_localctx).f.f);
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
		public Abstract_TrueProp p;
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
			setState(231); match(TRUE);
			((TruepropContext)_localctx).p =  new Abstract_TrueProp();
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
		public String s;
		public Token CONST;
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
			setState(234); ((AgentnameContext)_localctx).CONST = match(CONST);
			((AgentnameContext)_localctx).s =  ((AgentnameContext)_localctx).CONST.getText();
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

	public static class FormulaContext extends ParserRuleContext {
		public Abstract_Formula f;
		public Token CONST;
		public TerminalNode CONST() { return getToken(A_PSLParser.CONST, 0); }
		public TerminalNode OPENBRACKET() { return getToken(A_PSLParser.OPENBRACKET, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(A_PSLParser.CLOSEBRACKET, 0); }
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_formula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); ((FormulaContext)_localctx).CONST = match(CONST);
			((FormulaContext)_localctx).f =  new Abstract_MCAPLPredicate(((FormulaContext)_localctx).CONST.getText());
			setState(243);
			_la = _input.LA(1);
			if (_la==OPENBRACKET) {
				{
				setState(239); match(OPENBRACKET);
				setState(240); terms(_localctx.f);
				setState(241); match(CLOSEBRACKET);
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

	public static class SubformulaContext extends ParserRuleContext {
		public Abstract_MCAPLTerm f;
		public Token NUMBER;
		public Token UNNAMED_VAR;
		public SubformulaContext h;
		public SubformulaContext t;
		public Token CONST;
		public TerminalNode SQCLOSEBRACKET() { return getToken(A_PSLParser.SQCLOSEBRACKET, 0); }
		public TerminalNode CONST() { return getToken(A_PSLParser.CONST, 0); }
		public TerminalNode SQOPENBRACKET() { return getToken(A_PSLParser.SQOPENBRACKET, 0); }
		public TerminalNode COMMASEP(int i) {
			return getToken(A_PSLParser.COMMASEP, i);
		}
		public TerminalNode OPENBRACKET() { return getToken(A_PSLParser.OPENBRACKET, 0); }
		public List<SubformulaContext> subformula() {
			return getRuleContexts(SubformulaContext.class);
		}
		public SubformulaContext subformula(int i) {
			return getRuleContext(SubformulaContext.class,i);
		}
		public List<TerminalNode> COMMASEP() { return getTokens(A_PSLParser.COMMASEP); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TerminalNode UNNAMED_VAR() { return getToken(A_PSLParser.UNNAMED_VAR, 0); }
		public TerminalNode NUMBER() { return getToken(A_PSLParser.NUMBER, 0); }
		public TerminalNode CLOSEBRACKET() { return getToken(A_PSLParser.CLOSEBRACKET, 0); }
		public SubformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subformula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitSubformula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubformulaContext subformula() throws RecognitionException {
		SubformulaContext _localctx = new SubformulaContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_subformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(245); ((SubformulaContext)_localctx).NUMBER = match(NUMBER);
				((SubformulaContext)_localctx).f =  new Abstract_MCAPLNumberTermImpl(((SubformulaContext)_localctx).NUMBER.getText());
				}
				break;
			case UNNAMED_VAR:
				{
				setState(247); ((SubformulaContext)_localctx).UNNAMED_VAR = match(UNNAMED_VAR);
				((SubformulaContext)_localctx).f =  new Abstract_TermImpl(((SubformulaContext)_localctx).UNNAMED_VAR.getText());
				}
				break;
			case SQOPENBRACKET:
				{
				setState(249); match(SQOPENBRACKET);
				setState(250); ((SubformulaContext)_localctx).h = subformula();
				((SubformulaContext)_localctx).f =  new Abstract_MCAPLListTermImpl(((SubformulaContext)_localctx).h.f);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMASEP) {
					{
					{
					setState(252); match(COMMASEP);
					setState(253); ((SubformulaContext)_localctx).t = subformula();
					((Abstract_MCAPLListTerm) _localctx.f).addEnd(((SubformulaContext)_localctx).t.f);
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(261); match(SQCLOSEBRACKET);
				}
				break;
			case CONST:
				{
				setState(263); ((SubformulaContext)_localctx).CONST = match(CONST);
				((SubformulaContext)_localctx).f =  new Abstract_TermImpl(((SubformulaContext)_localctx).CONST.getText());
				setState(269);
				_la = _input.LA(1);
				if (_la==OPENBRACKET) {
					{
					setState(265); match(OPENBRACKET);
					setState(266); terms(_localctx.f);
					setState(267); match(CLOSEBRACKET);
					}
				}

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

	public static class TermsContext extends ParserRuleContext {
		public Abstract_MCAPLTerm f;
		public SubformulaContext t;
		public SubformulaContext subformula() {
			return getRuleContext(SubformulaContext.class,0);
		}
		public TerminalNode COMMASEP() { return getToken(A_PSLParser.COMMASEP, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TermsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TermsContext(ParserRuleContext parent, int invokingState, Abstract_MCAPLTerm f) {
			super(parent, invokingState);
			this.f = f;
		}
		@Override public int getRuleIndex() { return RULE_terms; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof A_PSLVisitor ) return ((A_PSLVisitor<? extends T>)visitor).visitTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermsContext terms(Abstract_MCAPLTerm f) throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState(), f);
		enterRule(_localctx, 46, RULE_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); ((TermsContext)_localctx).t = subformula();
			((Abstract_TermImpl) _localctx.f).addTerm(((TermsContext)_localctx).t.f);
			setState(277);
			_la = _input.LA(1);
			if (_la==COMMASEP) {
				{
				setState(275); match(COMMASEP);
				setState(276); terms(_localctx.f);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u011a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4?\n\4\f\4\16\4B\13"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5L\n\5\f\5\16\5O\13\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\7\6Y\n\6\f\6\16\6\\\13\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\7\7f\n\7\f\7\16\7i\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bs"+
		"\n\b\f\b\16\bv\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0081\n\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u008a\n\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u0093\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u009d\n\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b7\n\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u00f6\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30"+
		"\u0103\n\30\f\30\16\30\u0106\13\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u0110\n\30\5\30\u0112\n\30\3\31\3\31\3\31\3\31\5\31\u0118\n"+
		"\31\3\31\2\2\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\2"+
		"\u0118\2\62\3\2\2\2\4\65\3\2\2\2\68\3\2\2\2\bE\3\2\2\2\nR\3\2\2\2\f_\3"+
		"\2\2\2\16l\3\2\2\2\20\u0080\3\2\2\2\22\u0089\3\2\2\2\24\u0092\3\2\2\2"+
		"\26\u009c\3\2\2\2\30\u00b6\3\2\2\2\32\u00b8\3\2\2\2\34\u00c0\3\2\2\2\36"+
		"\u00c8\3\2\2\2 \u00cb\3\2\2\2\"\u00d3\3\2\2\2$\u00db\3\2\2\2&\u00e1\3"+
		"\2\2\2(\u00e9\3\2\2\2*\u00ec\3\2\2\2,\u00ef\3\2\2\2.\u0111\3\2\2\2\60"+
		"\u0113\3\2\2\2\62\63\5\4\3\2\63\64\b\2\1\2\64\3\3\2\2\2\65\66\5\6\4\2"+
		"\66\67\b\3\1\2\67\5\3\2\2\289\5\b\5\29@\b\4\1\2:;\7\5\2\2;<\5\b\5\2<="+
		"\b\4\1\2=?\3\2\2\2>:\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B"+
		"@\3\2\2\2CD\b\4\1\2D\7\3\2\2\2EF\5\n\6\2FM\b\5\1\2GH\7\6\2\2HI\5\n\6\2"+
		"IJ\b\5\1\2JL\3\2\2\2KG\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2"+
		"OM\3\2\2\2PQ\b\5\1\2Q\t\3\2\2\2RS\5\f\7\2SZ\b\6\1\2TU\7\n\2\2UV\5\f\7"+
		"\2VW\b\6\1\2WY\3\2\2\2XT\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2"+
		"\2\2\\Z\3\2\2\2]^\b\6\1\2^\13\3\2\2\2_`\5\16\b\2`g\b\7\1\2ab\7\7\2\2b"+
		"c\5\16\b\2cd\b\7\1\2df\3\2\2\2ea\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2"+
		"hj\3\2\2\2ig\3\2\2\2jk\b\7\1\2k\r\3\2\2\2lm\5\20\t\2mt\b\b\1\2no\7\b\2"+
		"\2op\5\20\t\2pq\b\b\1\2qs\3\2\2\2rn\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2"+
		"\2\2uw\3\2\2\2vt\3\2\2\2wx\b\b\1\2x\17\3\2\2\2yz\5\22\n\2z{\b\t\1\2{\u0081"+
		"\3\2\2\2|}\7\3\2\2}~\5\22\n\2~\177\b\t\1\2\177\u0081\3\2\2\2\u0080y\3"+
		"\2\2\2\u0080|\3\2\2\2\u0081\21\3\2\2\2\u0082\u0083\5\24\13\2\u0083\u0084"+
		"\b\n\1\2\u0084\u008a\3\2\2\2\u0085\u0086\7\4\2\2\u0086\u0087\5\24\13\2"+
		"\u0087\u0088\b\n\1\2\u0088\u008a\3\2\2\2\u0089\u0082\3\2\2\2\u0089\u0085"+
		"\3\2\2\2\u008a\23\3\2\2\2\u008b\u008c\5\26\f\2\u008c\u008d\b\13\1\2\u008d"+
		"\u0093\3\2\2\2\u008e\u008f\7\t\2\2\u008f\u0090\5\26\f\2\u0090\u0091\b"+
		"\13\1\2\u0091\u0093\3\2\2\2\u0092\u008b\3\2\2\2\u0092\u008e\3\2\2\2\u0093"+
		"\25\3\2\2\2\u0094\u0095\5\30\r\2\u0095\u0096\b\f\1\2\u0096\u009d\3\2\2"+
		"\2\u0097\u0098\7\30\2\2\u0098\u0099\5\4\3\2\u0099\u009a\b\f\1\2\u009a"+
		"\u009b\7\31\2\2\u009b\u009d\3\2\2\2\u009c\u0094\3\2\2\2\u009c\u0097\3"+
		"\2\2\2\u009d\27\3\2\2\2\u009e\u009f\5\32\16\2\u009f\u00a0\b\r\1\2\u00a0"+
		"\u00b7\3\2\2\2\u00a1\u00a2\5\34\17\2\u00a2\u00a3\b\r\1\2\u00a3\u00b7\3"+
		"\2\2\2\u00a4\u00a5\5\36\20\2\u00a5\u00a6\b\r\1\2\u00a6\u00b7\3\2\2\2\u00a7"+
		"\u00a8\5 \21\2\u00a8\u00a9\b\r\1\2\u00a9\u00b7\3\2\2\2\u00aa\u00ab\5\""+
		"\22\2\u00ab\u00ac\b\r\1\2\u00ac\u00b7\3\2\2\2\u00ad\u00ae\5$\23\2\u00ae"+
		"\u00af\b\r\1\2\u00af\u00b7\3\2\2\2\u00b0\u00b1\5&\24\2\u00b1\u00b2\b\r"+
		"\1\2\u00b2\u00b7\3\2\2\2\u00b3\u00b4\5(\25\2\u00b4\u00b5\b\r\1\2\u00b5"+
		"\u00b7\3\2\2\2\u00b6\u009e\3\2\2\2\u00b6\u00a1\3\2\2\2\u00b6\u00a4\3\2"+
		"\2\2\u00b6\u00a7\3\2\2\2\u00b6\u00aa\3\2\2\2\u00b6\u00ad\3\2\2\2\u00b6"+
		"\u00b0\3\2\2\2\u00b6\u00b3\3\2\2\2\u00b7\31\3\2\2\2\u00b8\u00b9\7\13\2"+
		"\2\u00b9\u00ba\7\30\2\2\u00ba\u00bb\5*\26\2\u00bb\u00bc\7\32\2\2\u00bc"+
		"\u00bd\5,\27\2\u00bd\u00be\7\31\2\2\u00be\u00bf\b\16\1\2\u00bf\33\3\2"+
		"\2\2\u00c0\u00c1\7\f\2\2\u00c1\u00c2\7\30\2\2\u00c2\u00c3\5*\26\2\u00c3"+
		"\u00c4\7\32\2\2\u00c4\u00c5\5,\27\2\u00c5\u00c6\7\31\2\2\u00c6\u00c7\b"+
		"\17\1\2\u00c7\35\3\2\2\2\u00c8\u00c9\7\r\2\2\u00c9\u00ca\b\20\1\2\u00ca"+
		"\37\3\2\2\2\u00cb\u00cc\7\16\2\2\u00cc\u00cd\7\30\2\2\u00cd\u00ce\5*\26"+
		"\2\u00ce\u00cf\7\32\2\2\u00cf\u00d0\5,\27\2\u00d0\u00d1\7\31\2\2\u00d1"+
		"\u00d2\b\21\1\2\u00d2!\3\2\2\2\u00d3\u00d4\7\17\2\2\u00d4\u00d5\7\30\2"+
		"\2\u00d5\u00d6\5*\26\2\u00d6\u00d7\7\32\2\2\u00d7\u00d8\5,\27\2\u00d8"+
		"\u00d9\7\31\2\2\u00d9\u00da\b\22\1\2\u00da#\3\2\2\2\u00db\u00dc\7\20\2"+
		"\2\u00dc\u00dd\7\30\2\2\u00dd\u00de\5,\27\2\u00de\u00df\7\31\2\2\u00df"+
		"\u00e0\b\23\1\2\u00e0%\3\2\2\2\u00e1\u00e2\7\22\2\2\u00e2\u00e3\7\30\2"+
		"\2\u00e3\u00e4\5*\26\2\u00e4\u00e5\7\32\2\2\u00e5\u00e6\5,\27\2\u00e6"+
		"\u00e7\7\31\2\2\u00e7\u00e8\b\24\1\2\u00e8\'\3\2\2\2\u00e9\u00ea\7\21"+
		"\2\2\u00ea\u00eb\b\25\1\2\u00eb)\3\2\2\2\u00ec\u00ed\7\33\2\2\u00ed\u00ee"+
		"\b\26\1\2\u00ee+\3\2\2\2\u00ef\u00f0\7\33\2\2\u00f0\u00f5\b\27\1\2\u00f1"+
		"\u00f2\7\30\2\2\u00f2\u00f3\5\60\31\2\u00f3\u00f4\7\31\2\2\u00f4\u00f6"+
		"\3\2\2\2\u00f5\u00f1\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6-\3\2\2\2\u00f7"+
		"\u00f8\7\34\2\2\u00f8\u0112\b\30\1\2\u00f9\u00fa\7\35\2\2\u00fa\u0112"+
		"\b\30\1\2\u00fb\u00fc\7\36\2\2\u00fc\u00fd\5.\30\2\u00fd\u0104\b\30\1"+
		"\2\u00fe\u00ff\7\32\2\2\u00ff\u0100\5.\30\2\u0100\u0101\b\30\1\2\u0101"+
		"\u0103\3\2\2\2\u0102\u00fe\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2"+
		"\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107"+
		"\u0108\7\37\2\2\u0108\u0112\3\2\2\2\u0109\u010a\7\33\2\2\u010a\u010f\b"+
		"\30\1\2\u010b\u010c\7\30\2\2\u010c\u010d\5\60\31\2\u010d\u010e\7\31\2"+
		"\2\u010e\u0110\3\2\2\2\u010f\u010b\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112"+
		"\3\2\2\2\u0111\u00f7\3\2\2\2\u0111\u00f9\3\2\2\2\u0111\u00fb\3\2\2\2\u0111"+
		"\u0109\3\2\2\2\u0112/\3\2\2\2\u0113\u0114\5.\30\2\u0114\u0117\b\31\1\2"+
		"\u0115\u0116\7\32\2\2\u0116\u0118\5\60\31\2\u0117\u0115\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\61\3\2\2\2\21@MZgt\u0080\u0089\u0092\u009c\u00b6"+
		"\u00f5\u0104\u010f\u0111\u0117";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}