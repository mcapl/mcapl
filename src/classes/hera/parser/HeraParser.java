// Generated from Hera.g4 by ANTLR 4.4
package hera.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HeraParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AFFECTSPOS=7, ADD=31, QUOTE=34, IMPL=5, MAY=23, AFFECTSNEG=8, SCAUSES=14, 
		I=9, FORALL=19, K=24, CLOSE=37, DR=27, INT=32, COMMENT=38, ATOM=1, MINUS=29, 
		U=26, CONSEQUENCE=25, WS=41, INTERVENTION=17, COMMA=35, SUB=30, WORD=33, 
		OR=3, EXISTS=18, NEWLINE=40, PREVENTS=16, GT=20, MUST=22, OPEN=36, NOT=2, 
		GOAL=10, GEQ=21, MEANS=11, LINE_COMMENT=39, AND=4, PCAUSES=13, CAUSES=12, 
		EXPLAINS=15, AFFECTS=6, DB=28;
	public static final String[] tokenNames = {
		"<INVALID>", "'Atom'", "'Not'", "'Or'", "'And'", "'Impl'", "'Affects'", 
		"'AffectsPos'", "'AffectsNeg'", "'I'", "'Goal'", "'Means'", "'Causes'", 
		"'PCauses'", "'SCauses'", "'Explains'", "'Prevents'", "'Intervention'", 
		"'Exists'", "'Forall'", "'Gt'", "'Geq'", "'Must'", "'May'", "'K'", "'Consequence'", 
		"'U'", "'DR'", "'DB'", "'Minus'", "'Sub'", "'Add'", "INT", "WORD", "'''", 
		"','", "'('", "')'", "COMMENT", "LINE_COMMENT", "NEWLINE", "WS"
	};
	public static final int
		RULE_formula = 0, RULE_atomfmla = 1, RULE_notfmla = 2, RULE_andfmla = 3, 
		RULE_orfmla = 4, RULE_implfmla = 5, RULE_affectsfmla = 6, RULE_affectsnegfmla = 7, 
		RULE_affectsposfmla = 8, RULE_ifmla = 9, RULE_goalfmla = 10, RULE_meansfmla = 11, 
		RULE_causesfmla = 12, RULE_pcausesfmla = 13, RULE_scausesfmla = 14, RULE_explainsfmla = 15, 
		RULE_preventsfmla = 16, RULE_interventionfmla = 17, RULE_existsfmla = 18, 
		RULE_forallfmla = 19, RULE_gtfmla = 20, RULE_geqfmla = 21, RULE_mustfmla = 22, 
		RULE_mayfmla = 23, RULE_kfmla = 24, RULE_consequencefmla = 25, RULE_stringfmla = 26, 
		RULE_term = 27, RULE_uterm = 28, RULE_drterm = 29, RULE_dbterm = 30, RULE_minusterm = 31, 
		RULE_subterm = 32, RULE_addterm = 33, RULE_intterm = 34;
	public static final String[] ruleNames = {
		"formula", "atomfmla", "notfmla", "andfmla", "orfmla", "implfmla", "affectsfmla", 
		"affectsnegfmla", "affectsposfmla", "ifmla", "goalfmla", "meansfmla", 
		"causesfmla", "pcausesfmla", "scausesfmla", "explainsfmla", "preventsfmla", 
		"interventionfmla", "existsfmla", "forallfmla", "gtfmla", "geqfmla", "mustfmla", 
		"mayfmla", "kfmla", "consequencefmla", "stringfmla", "term", "uterm", 
		"drterm", "dbterm", "minusterm", "subterm", "addterm", "intterm"
	};

	@Override
	public String getGrammarFileName() { return "Hera.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HeraParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormulaContext extends ParserRuleContext {
		public StringfmlaContext stringfmla() {
			return getRuleContext(StringfmlaContext.class,0);
		}
		public MeansfmlaContext meansfmla() {
			return getRuleContext(MeansfmlaContext.class,0);
		}
		public MustfmlaContext mustfmla() {
			return getRuleContext(MustfmlaContext.class,0);
		}
		public GeqfmlaContext geqfmla() {
			return getRuleContext(GeqfmlaContext.class,0);
		}
		public ExistsfmlaContext existsfmla() {
			return getRuleContext(ExistsfmlaContext.class,0);
		}
		public IfmlaContext ifmla() {
			return getRuleContext(IfmlaContext.class,0);
		}
		public ExplainsfmlaContext explainsfmla() {
			return getRuleContext(ExplainsfmlaContext.class,0);
		}
		public ScausesfmlaContext scausesfmla() {
			return getRuleContext(ScausesfmlaContext.class,0);
		}
		public KfmlaContext kfmla() {
			return getRuleContext(KfmlaContext.class,0);
		}
		public AffectsnegfmlaContext affectsnegfmla() {
			return getRuleContext(AffectsnegfmlaContext.class,0);
		}
		public MayfmlaContext mayfmla() {
			return getRuleContext(MayfmlaContext.class,0);
		}
		public OrfmlaContext orfmla() {
			return getRuleContext(OrfmlaContext.class,0);
		}
		public ForallfmlaContext forallfmla() {
			return getRuleContext(ForallfmlaContext.class,0);
		}
		public AndfmlaContext andfmla() {
			return getRuleContext(AndfmlaContext.class,0);
		}
		public PcausesfmlaContext pcausesfmla() {
			return getRuleContext(PcausesfmlaContext.class,0);
		}
		public ConsequencefmlaContext consequencefmla() {
			return getRuleContext(ConsequencefmlaContext.class,0);
		}
		public AffectsposfmlaContext affectsposfmla() {
			return getRuleContext(AffectsposfmlaContext.class,0);
		}
		public AffectsfmlaContext affectsfmla() {
			return getRuleContext(AffectsfmlaContext.class,0);
		}
		public AtomfmlaContext atomfmla() {
			return getRuleContext(AtomfmlaContext.class,0);
		}
		public NotfmlaContext notfmla() {
			return getRuleContext(NotfmlaContext.class,0);
		}
		public GoalfmlaContext goalfmla() {
			return getRuleContext(GoalfmlaContext.class,0);
		}
		public ImplfmlaContext implfmla() {
			return getRuleContext(ImplfmlaContext.class,0);
		}
		public CausesfmlaContext causesfmla() {
			return getRuleContext(CausesfmlaContext.class,0);
		}
		public InterventionfmlaContext interventionfmla() {
			return getRuleContext(InterventionfmlaContext.class,0);
		}
		public PreventsfmlaContext preventsfmla() {
			return getRuleContext(PreventsfmlaContext.class,0);
		}
		public GtfmlaContext gtfmla() {
			return getRuleContext(GtfmlaContext.class,0);
		}
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_formula);
		try {
			setState(97);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70); atomfmla();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71); notfmla();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72); andfmla();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(73); orfmla();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(74); notfmla();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(75); implfmla();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(76); affectsfmla();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(77); affectsposfmla();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(78); affectsnegfmla();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(79); ifmla();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(80); goalfmla();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(81); meansfmla();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(82); causesfmla();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(83); pcausesfmla();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(84); scausesfmla();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(85); explainsfmla();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(86); preventsfmla();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(87); interventionfmla();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(88); existsfmla();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(89); forallfmla();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(90); gtfmla();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(91); geqfmla();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(92); mustfmla();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(93); mayfmla();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(94); kfmla();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(95); consequencefmla();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(96); stringfmla();
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

	public static class AtomfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public TerminalNode ATOM() { return getToken(HeraParser.ATOM, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public AtomfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitAtomfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomfmlaContext atomfmla() throws RecognitionException {
		AtomfmlaContext _localctx = new AtomfmlaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_atomfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); match(ATOM);
			setState(100); match(OPEN);
			setState(101); formula();
			setState(102); match(CLOSE);
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

	public static class NotfmlaContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(HeraParser.NOT, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public NotfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitNotfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotfmlaContext notfmla() throws RecognitionException {
		NotfmlaContext _localctx = new NotfmlaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_notfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); match(NOT);
			setState(105); match(OPEN);
			setState(106); formula();
			setState(107); match(CLOSE);
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

	public static class AndfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public TerminalNode AND() { return getToken(HeraParser.AND, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public AndfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitAndfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndfmlaContext andfmla() throws RecognitionException {
		AndfmlaContext _localctx = new AndfmlaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_andfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109); match(AND);
			setState(110); match(OPEN);
			setState(111); formula();
			setState(112); match(COMMA);
			setState(113); formula();
			setState(114); match(CLOSE);
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

	public static class OrfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public TerminalNode OR() { return getToken(HeraParser.OR, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public OrfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitOrfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrfmlaContext orfmla() throws RecognitionException {
		OrfmlaContext _localctx = new OrfmlaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_orfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(OR);
			setState(117); match(OPEN);
			setState(118); formula();
			setState(119); match(COMMA);
			setState(120); formula();
			setState(121); match(CLOSE);
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

	public static class ImplfmlaContext extends ParserRuleContext {
		public TerminalNode IMPL() { return getToken(HeraParser.IMPL, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ImplfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitImplfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImplfmlaContext implfmla() throws RecognitionException {
		ImplfmlaContext _localctx = new ImplfmlaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_implfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(IMPL);
			setState(124); match(OPEN);
			setState(125); formula();
			setState(126); match(COMMA);
			setState(127); formula();
			setState(128); match(CLOSE);
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

	public static class AffectsfmlaContext extends ParserRuleContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode AFFECTS() { return getToken(HeraParser.AFFECTS, 0); }
		public AffectsfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affectsfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitAffectsfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AffectsfmlaContext affectsfmla() throws RecognitionException {
		AffectsfmlaContext _localctx = new AffectsfmlaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_affectsfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); match(AFFECTS);
			setState(131); formula();
			setState(132); match(COMMA);
			setState(133); formula();
			setState(134); match(CLOSE);
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

	public static class AffectsnegfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode AFFECTSNEG() { return getToken(HeraParser.AFFECTSNEG, 0); }
		public AffectsnegfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affectsnegfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitAffectsnegfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AffectsnegfmlaContext affectsnegfmla() throws RecognitionException {
		AffectsnegfmlaContext _localctx = new AffectsnegfmlaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_affectsnegfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); match(AFFECTSNEG);
			setState(137); match(OPEN);
			setState(138); formula();
			setState(139); match(COMMA);
			setState(140); formula();
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

	public static class AffectsposfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode AFFECTSPOS() { return getToken(HeraParser.AFFECTSPOS, 0); }
		public AffectsposfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affectsposfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitAffectsposfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AffectsposfmlaContext affectsposfmla() throws RecognitionException {
		AffectsposfmlaContext _localctx = new AffectsposfmlaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_affectsposfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); match(AFFECTSPOS);
			setState(144); match(OPEN);
			setState(145); formula();
			setState(146); match(COMMA);
			setState(147); formula();
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

	public static class IfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public TerminalNode I() { return getToken(HeraParser.I, 0); }
		public IfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitIfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfmlaContext ifmla() throws RecognitionException {
		IfmlaContext _localctx = new IfmlaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ifmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); match(I);
			setState(151); match(OPEN);
			setState(152); formula();
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

	public static class GoalfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public TerminalNode GOAL() { return getToken(HeraParser.GOAL, 0); }
		public GoalfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goalfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitGoalfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GoalfmlaContext goalfmla() throws RecognitionException {
		GoalfmlaContext _localctx = new GoalfmlaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_goalfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); match(GOAL);
			setState(156); match(OPEN);
			setState(157); formula();
			setState(158); match(CLOSE);
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

	public static class MeansfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public TerminalNode MEANS() { return getToken(HeraParser.MEANS, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public MeansfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meansfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitMeansfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MeansfmlaContext meansfmla() throws RecognitionException {
		MeansfmlaContext _localctx = new MeansfmlaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_meansfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); match(MEANS);
			setState(161); match(OPEN);
			setState(162); formula();
			setState(163); match(COMMA);
			setState(164); formula();
			setState(165); match(CLOSE);
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

	public static class CausesfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public TerminalNode CAUSES() { return getToken(HeraParser.CAUSES, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public CausesfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_causesfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitCausesfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CausesfmlaContext causesfmla() throws RecognitionException {
		CausesfmlaContext _localctx = new CausesfmlaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_causesfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167); match(CAUSES);
			setState(168); match(OPEN);
			setState(169); formula();
			setState(170); match(COMMA);
			setState(171); formula();
			setState(172); match(CLOSE);
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

	public static class PcausesfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public TerminalNode PCAUSES() { return getToken(HeraParser.PCAUSES, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public PcausesfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pcausesfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitPcausesfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PcausesfmlaContext pcausesfmla() throws RecognitionException {
		PcausesfmlaContext _localctx = new PcausesfmlaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pcausesfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(PCAUSES);
			setState(175); match(OPEN);
			setState(176); formula();
			setState(177); match(COMMA);
			setState(178); formula();
			setState(179); match(CLOSE);
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

	public static class ScausesfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public TerminalNode SCAUSES() { return getToken(HeraParser.SCAUSES, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ScausesfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scausesfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitScausesfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScausesfmlaContext scausesfmla() throws RecognitionException {
		ScausesfmlaContext _localctx = new ScausesfmlaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_scausesfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); match(SCAUSES);
			setState(182); match(OPEN);
			setState(183); formula();
			setState(184); match(COMMA);
			setState(185); formula();
			setState(186); match(CLOSE);
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

	public static class ExplainsfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode EXPLAINS() { return getToken(HeraParser.EXPLAINS, 0); }
		public ExplainsfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explainsfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitExplainsfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplainsfmlaContext explainsfmla() throws RecognitionException {
		ExplainsfmlaContext _localctx = new ExplainsfmlaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_explainsfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188); match(EXPLAINS);
			setState(189); match(OPEN);
			setState(190); formula();
			setState(191); match(COMMA);
			setState(192); formula();
			setState(193); match(CLOSE);
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

	public static class PreventsfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode PREVENTS() { return getToken(HeraParser.PREVENTS, 0); }
		public PreventsfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preventsfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitPreventsfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreventsfmlaContext preventsfmla() throws RecognitionException {
		PreventsfmlaContext _localctx = new PreventsfmlaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_preventsfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195); match(PREVENTS);
			setState(196); match(OPEN);
			setState(197); formula();
			setState(198); match(COMMA);
			setState(199); formula();
			setState(200); match(CLOSE);
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

	public static class InterventionfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public TerminalNode INTERVENTION() { return getToken(HeraParser.INTERVENTION, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public InterventionfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interventionfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitInterventionfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterventionfmlaContext interventionfmla() throws RecognitionException {
		InterventionfmlaContext _localctx = new InterventionfmlaContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_interventionfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); match(INTERVENTION);
			setState(203); match(OPEN);
			setState(204); formula();
			setState(205); match(COMMA);
			setState(206); formula();
			setState(207); match(CLOSE);
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

	public static class ExistsfmlaContext extends ParserRuleContext {
		public TerminalNode EXISTS() { return getToken(HeraParser.EXISTS, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ExistsfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_existsfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitExistsfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExistsfmlaContext existsfmla() throws RecognitionException {
		ExistsfmlaContext _localctx = new ExistsfmlaContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_existsfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209); match(EXISTS);
			setState(210); match(OPEN);
			setState(211); formula();
			setState(212); match(COMMA);
			setState(213); formula();
			setState(214); match(CLOSE);
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

	public static class ForallfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public TerminalNode FORALL() { return getToken(HeraParser.FORALL, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ForallfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forallfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitForallfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForallfmlaContext forallfmla() throws RecognitionException {
		ForallfmlaContext _localctx = new ForallfmlaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_forallfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); match(FORALL);
			setState(217); match(OPEN);
			setState(218); formula();
			setState(219); match(COMMA);
			setState(220); formula();
			setState(221); match(CLOSE);
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

	public static class GtfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode GT() { return getToken(HeraParser.GT, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public GtfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gtfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitGtfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GtfmlaContext gtfmla() throws RecognitionException {
		GtfmlaContext _localctx = new GtfmlaContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_gtfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223); match(GT);
			setState(224); match(OPEN);
			setState(225); term();
			setState(226); match(COMMA);
			setState(227); term();
			setState(228); match(CLOSE);
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

	public static class GeqfmlaContext extends ParserRuleContext {
		public TerminalNode GEQ() { return getToken(HeraParser.GEQ, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public GeqfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_geqfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitGeqfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeqfmlaContext geqfmla() throws RecognitionException {
		GeqfmlaContext _localctx = new GeqfmlaContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_geqfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); match(GEQ);
			setState(231); match(OPEN);
			setState(232); term();
			setState(233); match(COMMA);
			setState(234); term();
			setState(235); match(CLOSE);
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

	public static class MustfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode MUST() { return getToken(HeraParser.MUST, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public MustfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mustfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitMustfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MustfmlaContext mustfmla() throws RecognitionException {
		MustfmlaContext _localctx = new MustfmlaContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mustfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); match(MUST);
			setState(238); match(OPEN);
			setState(239); formula();
			setState(240); match(CLOSE);
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

	public static class MayfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public TerminalNode MAY() { return getToken(HeraParser.MAY, 0); }
		public MayfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mayfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitMayfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MayfmlaContext mayfmla() throws RecognitionException {
		MayfmlaContext _localctx = new MayfmlaContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_mayfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242); match(MAY);
			setState(243); match(OPEN);
			setState(244); formula();
			setState(245); match(CLOSE);
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

	public static class KfmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public TerminalNode K() { return getToken(HeraParser.K, 0); }
		public KfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitKfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KfmlaContext kfmla() throws RecognitionException {
		KfmlaContext _localctx = new KfmlaContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_kfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247); match(K);
			setState(248); match(OPEN);
			setState(249); formula();
			setState(250); match(CLOSE);
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

	public static class ConsequencefmlaContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public TerminalNode CONSEQUENCE() { return getToken(HeraParser.CONSEQUENCE, 0); }
		public ConsequencefmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consequencefmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitConsequencefmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConsequencefmlaContext consequencefmla() throws RecognitionException {
		ConsequencefmlaContext _localctx = new ConsequencefmlaContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_consequencefmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); match(CONSEQUENCE);
			setState(253); match(OPEN);
			setState(254); formula();
			setState(255); match(CLOSE);
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

	public static class StringfmlaContext extends ParserRuleContext {
		public Token w;
		public TerminalNode WORD() { return getToken(HeraParser.WORD, 0); }
		public List<TerminalNode> QUOTE() { return getTokens(HeraParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(HeraParser.QUOTE, i);
		}
		public StringfmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringfmla; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitStringfmla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringfmlaContext stringfmla() throws RecognitionException {
		StringfmlaContext _localctx = new StringfmlaContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_stringfmla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257); match(QUOTE);
			setState(258); ((StringfmlaContext)_localctx).w = match(WORD);
			setState(259); match(QUOTE);
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

	public static class TermContext extends ParserRuleContext {
		public DbtermContext dbterm() {
			return getRuleContext(DbtermContext.class,0);
		}
		public AddtermContext addterm() {
			return getRuleContext(AddtermContext.class,0);
		}
		public MinustermContext minusterm() {
			return getRuleContext(MinustermContext.class,0);
		}
		public InttermContext intterm() {
			return getRuleContext(InttermContext.class,0);
		}
		public DrtermContext drterm() {
			return getRuleContext(DrtermContext.class,0);
		}
		public UtermContext uterm() {
			return getRuleContext(UtermContext.class,0);
		}
		public SubtermContext subterm() {
			return getRuleContext(SubtermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_term);
		try {
			setState(268);
			switch (_input.LA(1)) {
			case U:
				enterOuterAlt(_localctx, 1);
				{
				setState(261); uterm();
				}
				break;
			case DR:
				enterOuterAlt(_localctx, 2);
				{
				setState(262); drterm();
				}
				break;
			case DB:
				enterOuterAlt(_localctx, 3);
				{
				setState(263); dbterm();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 4);
				{
				setState(264); minusterm();
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 5);
				{
				setState(265); subterm();
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 6);
				{
				setState(266); addterm();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 7);
				{
				setState(267); intterm();
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

	public static class UtermContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public TerminalNode U() { return getToken(HeraParser.U, 0); }
		public UtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uterm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitUterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UtermContext uterm() throws RecognitionException {
		UtermContext _localctx = new UtermContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_uterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270); match(U);
			setState(271); match(OPEN);
			setState(272); formula();
			setState(273); match(CLOSE);
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

	public static class DrtermContext extends ParserRuleContext {
		public TerminalNode DR() { return getToken(HeraParser.DR, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public DrtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drterm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitDrterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DrtermContext drterm() throws RecognitionException {
		DrtermContext _localctx = new DrtermContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_drterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275); match(DR);
			setState(276); match(OPEN);
			setState(277); formula();
			setState(278); match(COMMA);
			setState(279); formula();
			setState(280); match(CLOSE);
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

	public static class DbtermContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public TerminalNode DB() { return getToken(HeraParser.DB, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public DbtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dbterm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitDbterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DbtermContext dbterm() throws RecognitionException {
		DbtermContext _localctx = new DbtermContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_dbterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282); match(DB);
			setState(283); match(OPEN);
			setState(284); formula();
			setState(285); match(COMMA);
			setState(286); formula();
			setState(287); match(CLOSE);
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

	public static class MinustermContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public TerminalNode MINUS() { return getToken(HeraParser.MINUS, 0); }
		public MinustermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minusterm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitMinusterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MinustermContext minusterm() throws RecognitionException {
		MinustermContext _localctx = new MinustermContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_minusterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289); match(MINUS);
			setState(290); match(OPEN);
			setState(291); term();
			setState(292); match(CLOSE);
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

	public static class SubtermContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode SUB() { return getToken(HeraParser.SUB, 0); }
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public SubtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subterm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitSubterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtermContext subterm() throws RecognitionException {
		SubtermContext _localctx = new SubtermContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_subterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294); match(SUB);
			setState(295); match(OPEN);
			setState(296); term();
			setState(297); match(COMMA);
			setState(298); term();
			setState(299); match(CLOSE);
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

	public static class AddtermContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode ADD() { return getToken(HeraParser.ADD, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
		public AddtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addterm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitAddterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddtermContext addterm() throws RecognitionException {
		AddtermContext _localctx = new AddtermContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_addterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301); match(ADD);
			setState(302); match(OPEN);
			setState(303); term();
			setState(304); match(COMMA);
			setState(305); term();
			setState(306); match(CLOSE);
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

	public static class InttermContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(HeraParser.INT, 0); }
		public InttermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intterm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HeraVisitor ) return ((HeraVisitor<? extends T>)visitor).visitIntterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InttermContext intterm() throws RecognitionException {
		InttermContext _localctx = new InttermContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_intterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308); match(INT);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u0139\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2d\n"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\5\35\u010f\n\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\2\2%\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\2\u0135\2c\3\2\2\2\4"+
		"e\3\2\2\2\6j\3\2\2\2\bo\3\2\2\2\nv\3\2\2\2\f}\3\2\2\2\16\u0084\3\2\2\2"+
		"\20\u008a\3\2\2\2\22\u0091\3\2\2\2\24\u0098\3\2\2\2\26\u009d\3\2\2\2\30"+
		"\u00a2\3\2\2\2\32\u00a9\3\2\2\2\34\u00b0\3\2\2\2\36\u00b7\3\2\2\2 \u00be"+
		"\3\2\2\2\"\u00c5\3\2\2\2$\u00cc\3\2\2\2&\u00d3\3\2\2\2(\u00da\3\2\2\2"+
		"*\u00e1\3\2\2\2,\u00e8\3\2\2\2.\u00ef\3\2\2\2\60\u00f4\3\2\2\2\62\u00f9"+
		"\3\2\2\2\64\u00fe\3\2\2\2\66\u0103\3\2\2\28\u010e\3\2\2\2:\u0110\3\2\2"+
		"\2<\u0115\3\2\2\2>\u011c\3\2\2\2@\u0123\3\2\2\2B\u0128\3\2\2\2D\u012f"+
		"\3\2\2\2F\u0136\3\2\2\2Hd\5\4\3\2Id\5\6\4\2Jd\5\b\5\2Kd\5\n\6\2Ld\5\6"+
		"\4\2Md\5\f\7\2Nd\5\16\b\2Od\5\22\n\2Pd\5\20\t\2Qd\5\24\13\2Rd\5\26\f\2"+
		"Sd\5\30\r\2Td\5\32\16\2Ud\5\34\17\2Vd\5\36\20\2Wd\5 \21\2Xd\5\"\22\2Y"+
		"d\5$\23\2Zd\5&\24\2[d\5(\25\2\\d\5*\26\2]d\5,\27\2^d\5.\30\2_d\5\60\31"+
		"\2`d\5\62\32\2ad\5\64\33\2bd\5\66\34\2cH\3\2\2\2cI\3\2\2\2cJ\3\2\2\2c"+
		"K\3\2\2\2cL\3\2\2\2cM\3\2\2\2cN\3\2\2\2cO\3\2\2\2cP\3\2\2\2cQ\3\2\2\2"+
		"cR\3\2\2\2cS\3\2\2\2cT\3\2\2\2cU\3\2\2\2cV\3\2\2\2cW\3\2\2\2cX\3\2\2\2"+
		"cY\3\2\2\2cZ\3\2\2\2c[\3\2\2\2c\\\3\2\2\2c]\3\2\2\2c^\3\2\2\2c_\3\2\2"+
		"\2c`\3\2\2\2ca\3\2\2\2cb\3\2\2\2d\3\3\2\2\2ef\7\3\2\2fg\7&\2\2gh\5\2\2"+
		"\2hi\7\'\2\2i\5\3\2\2\2jk\7\4\2\2kl\7&\2\2lm\5\2\2\2mn\7\'\2\2n\7\3\2"+
		"\2\2op\7\6\2\2pq\7&\2\2qr\5\2\2\2rs\7%\2\2st\5\2\2\2tu\7\'\2\2u\t\3\2"+
		"\2\2vw\7\5\2\2wx\7&\2\2xy\5\2\2\2yz\7%\2\2z{\5\2\2\2{|\7\'\2\2|\13\3\2"+
		"\2\2}~\7\7\2\2~\177\7&\2\2\177\u0080\5\2\2\2\u0080\u0081\7%\2\2\u0081"+
		"\u0082\5\2\2\2\u0082\u0083\7\'\2\2\u0083\r\3\2\2\2\u0084\u0085\7\b\2\2"+
		"\u0085\u0086\5\2\2\2\u0086\u0087\7%\2\2\u0087\u0088\5\2\2\2\u0088\u0089"+
		"\7\'\2\2\u0089\17\3\2\2\2\u008a\u008b\7\n\2\2\u008b\u008c\7&\2\2\u008c"+
		"\u008d\5\2\2\2\u008d\u008e\7%\2\2\u008e\u008f\5\2\2\2\u008f\u0090\7\'"+
		"\2\2\u0090\21\3\2\2\2\u0091\u0092\7\t\2\2\u0092\u0093\7&\2\2\u0093\u0094"+
		"\5\2\2\2\u0094\u0095\7%\2\2\u0095\u0096\5\2\2\2\u0096\u0097\7\'\2\2\u0097"+
		"\23\3\2\2\2\u0098\u0099\7\13\2\2\u0099\u009a\7&\2\2\u009a\u009b\5\2\2"+
		"\2\u009b\u009c\7\'\2\2\u009c\25\3\2\2\2\u009d\u009e\7\f\2\2\u009e\u009f"+
		"\7&\2\2\u009f\u00a0\5\2\2\2\u00a0\u00a1\7\'\2\2\u00a1\27\3\2\2\2\u00a2"+
		"\u00a3\7\r\2\2\u00a3\u00a4\7&\2\2\u00a4\u00a5\5\2\2\2\u00a5\u00a6\7%\2"+
		"\2\u00a6\u00a7\5\2\2\2\u00a7\u00a8\7\'\2\2\u00a8\31\3\2\2\2\u00a9\u00aa"+
		"\7\16\2\2\u00aa\u00ab\7&\2\2\u00ab\u00ac\5\2\2\2\u00ac\u00ad\7%\2\2\u00ad"+
		"\u00ae\5\2\2\2\u00ae\u00af\7\'\2\2\u00af\33\3\2\2\2\u00b0\u00b1\7\17\2"+
		"\2\u00b1\u00b2\7&\2\2\u00b2\u00b3\5\2\2\2\u00b3\u00b4\7%\2\2\u00b4\u00b5"+
		"\5\2\2\2\u00b5\u00b6\7\'\2\2\u00b6\35\3\2\2\2\u00b7\u00b8\7\20\2\2\u00b8"+
		"\u00b9\7&\2\2\u00b9\u00ba\5\2\2\2\u00ba\u00bb\7%\2\2\u00bb\u00bc\5\2\2"+
		"\2\u00bc\u00bd\7\'\2\2\u00bd\37\3\2\2\2\u00be\u00bf\7\21\2\2\u00bf\u00c0"+
		"\7&\2\2\u00c0\u00c1\5\2\2\2\u00c1\u00c2\7%\2\2\u00c2\u00c3\5\2\2\2\u00c3"+
		"\u00c4\7\'\2\2\u00c4!\3\2\2\2\u00c5\u00c6\7\22\2\2\u00c6\u00c7\7&\2\2"+
		"\u00c7\u00c8\5\2\2\2\u00c8\u00c9\7%\2\2\u00c9\u00ca\5\2\2\2\u00ca\u00cb"+
		"\7\'\2\2\u00cb#\3\2\2\2\u00cc\u00cd\7\23\2\2\u00cd\u00ce\7&\2\2\u00ce"+
		"\u00cf\5\2\2\2\u00cf\u00d0\7%\2\2\u00d0\u00d1\5\2\2\2\u00d1\u00d2\7\'"+
		"\2\2\u00d2%\3\2\2\2\u00d3\u00d4\7\24\2\2\u00d4\u00d5\7&\2\2\u00d5\u00d6"+
		"\5\2\2\2\u00d6\u00d7\7%\2\2\u00d7\u00d8\5\2\2\2\u00d8\u00d9\7\'\2\2\u00d9"+
		"\'\3\2\2\2\u00da\u00db\7\25\2\2\u00db\u00dc\7&\2\2\u00dc\u00dd\5\2\2\2"+
		"\u00dd\u00de\7%\2\2\u00de\u00df\5\2\2\2\u00df\u00e0\7\'\2\2\u00e0)\3\2"+
		"\2\2\u00e1\u00e2\7\26\2\2\u00e2\u00e3\7&\2\2\u00e3\u00e4\58\35\2\u00e4"+
		"\u00e5\7%\2\2\u00e5\u00e6\58\35\2\u00e6\u00e7\7\'\2\2\u00e7+\3\2\2\2\u00e8"+
		"\u00e9\7\27\2\2\u00e9\u00ea\7&\2\2\u00ea\u00eb\58\35\2\u00eb\u00ec\7%"+
		"\2\2\u00ec\u00ed\58\35\2\u00ed\u00ee\7\'\2\2\u00ee-\3\2\2\2\u00ef\u00f0"+
		"\7\30\2\2\u00f0\u00f1\7&\2\2\u00f1\u00f2\5\2\2\2\u00f2\u00f3\7\'\2\2\u00f3"+
		"/\3\2\2\2\u00f4\u00f5\7\31\2\2\u00f5\u00f6\7&\2\2\u00f6\u00f7\5\2\2\2"+
		"\u00f7\u00f8\7\'\2\2\u00f8\61\3\2\2\2\u00f9\u00fa\7\32\2\2\u00fa\u00fb"+
		"\7&\2\2\u00fb\u00fc\5\2\2\2\u00fc\u00fd\7\'\2\2\u00fd\63\3\2\2\2\u00fe"+
		"\u00ff\7\33\2\2\u00ff\u0100\7&\2\2\u0100\u0101\5\2\2\2\u0101\u0102\7\'"+
		"\2\2\u0102\65\3\2\2\2\u0103\u0104\7$\2\2\u0104\u0105\7#\2\2\u0105\u0106"+
		"\7$\2\2\u0106\67\3\2\2\2\u0107\u010f\5:\36\2\u0108\u010f\5<\37\2\u0109"+
		"\u010f\5> \2\u010a\u010f\5@!\2\u010b\u010f\5B\"\2\u010c\u010f\5D#\2\u010d"+
		"\u010f\5F$\2\u010e\u0107\3\2\2\2\u010e\u0108\3\2\2\2\u010e\u0109\3\2\2"+
		"\2\u010e\u010a\3\2\2\2\u010e\u010b\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010d"+
		"\3\2\2\2\u010f9\3\2\2\2\u0110\u0111\7\34\2\2\u0111\u0112\7&\2\2\u0112"+
		"\u0113\5\2\2\2\u0113\u0114\7\'\2\2\u0114;\3\2\2\2\u0115\u0116\7\35\2\2"+
		"\u0116\u0117\7&\2\2\u0117\u0118\5\2\2\2\u0118\u0119\7%\2\2\u0119\u011a"+
		"\5\2\2\2\u011a\u011b\7\'\2\2\u011b=\3\2\2\2\u011c\u011d\7\36\2\2\u011d"+
		"\u011e\7&\2\2\u011e\u011f\5\2\2\2\u011f\u0120\7%\2\2\u0120\u0121\5\2\2"+
		"\2\u0121\u0122\7\'\2\2\u0122?\3\2\2\2\u0123\u0124\7\37\2\2\u0124\u0125"+
		"\7&\2\2\u0125\u0126\58\35\2\u0126\u0127\7\'\2\2\u0127A\3\2\2\2\u0128\u0129"+
		"\7 \2\2\u0129\u012a\7&\2\2\u012a\u012b\58\35\2\u012b\u012c\7%\2\2\u012c"+
		"\u012d\58\35\2\u012d\u012e\7\'\2\2\u012eC\3\2\2\2\u012f\u0130\7!\2\2\u0130"+
		"\u0131\7&\2\2\u0131\u0132\58\35\2\u0132\u0133\7%\2\2\u0133\u0134\58\35"+
		"\2\u0134\u0135\7\'\2\2\u0135E\3\2\2\2\u0136\u0137\7\"\2\2\u0137G\3\2\2"+
		"\2\4c\u010e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}