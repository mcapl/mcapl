// Generated from /Users/louisedennis/IdeaProjects/mcapl/src/classes/hera/parser/antlr/Hera.g4 by ANTLR 4.13.1
package hera.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class HeraParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ATOM=1, NOT=2, OR=3, AND=4, IMPL=5, AFFECTS=6, AFFECTSPOS=7, AFFECTSNEG=8, 
		I=9, GOAL=10, MEANS=11, CAUSES=12, PCAUSES=13, SCAUSES=14, EXPLAINS=15, 
		PREVENTS=16, INTERVENTION=17, EXISTS=18, FORALL=19, GT=20, GEQ=21, MUST=22, 
		MAY=23, K=24, CONSEQUENCE=25, U=26, DR=27, DB=28, MINUS=29, SUB=30, ADD=31, 
		INT=32, WORD=33, QUOTE=34, COMMA=35, OPEN=36, CLOSE=37, COMMENT=38, LINE_COMMENT=39, 
		NEWLINE=40, WS=41;
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
	private static String[] makeRuleNames() {
		return new String[] {
			"formula", "atomfmla", "notfmla", "andfmla", "orfmla", "implfmla", "affectsfmla", 
			"affectsnegfmla", "affectsposfmla", "ifmla", "goalfmla", "meansfmla", 
			"causesfmla", "pcausesfmla", "scausesfmla", "explainsfmla", "preventsfmla", 
			"interventionfmla", "existsfmla", "forallfmla", "gtfmla", "geqfmla", 
			"mustfmla", "mayfmla", "kfmla", "consequencefmla", "stringfmla", "term", 
			"uterm", "drterm", "dbterm", "minusterm", "subterm", "addterm", "intterm"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Atom'", "'Not'", "'Or'", "'And'", "'Impl'", "'Affects'", "'AffectsPos'", 
			"'AffectsNeg'", "'I'", "'Goal'", "'Means'", "'Causes'", "'PCauses'", 
			"'SCauses'", "'Explains'", "'Prevents'", "'Intervention'", "'Exists'", 
			"'Forall'", "'Gt'", "'Geq'", "'Must'", "'May'", "'K'", "'Consequence'", 
			"'U'", "'DR'", "'DB'", "'Minus'", "'Sub'", "'Add'", null, null, "'''", 
			"','", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ATOM", "NOT", "OR", "AND", "IMPL", "AFFECTS", "AFFECTSPOS", "AFFECTSNEG", 
			"I", "GOAL", "MEANS", "CAUSES", "PCAUSES", "SCAUSES", "EXPLAINS", "PREVENTS", 
			"INTERVENTION", "EXISTS", "FORALL", "GT", "GEQ", "MUST", "MAY", "K", 
			"CONSEQUENCE", "U", "DR", "DB", "MINUS", "SUB", "ADD", "INT", "WORD", 
			"QUOTE", "COMMA", "OPEN", "CLOSE", "COMMENT", "LINE_COMMENT", "NEWLINE", 
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
	public String getGrammarFileName() { return "Hera.g4"; }

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

	@SuppressWarnings("CheckReturnValue")
	public static class FormulaContext extends ParserRuleContext {
		public AtomfmlaContext atomfmla() {
			return getRuleContext(AtomfmlaContext.class,0);
		}
		public NotfmlaContext notfmla() {
			return getRuleContext(NotfmlaContext.class,0);
		}
		public AndfmlaContext andfmla() {
			return getRuleContext(AndfmlaContext.class,0);
		}
		public OrfmlaContext orfmla() {
			return getRuleContext(OrfmlaContext.class,0);
		}
		public ImplfmlaContext implfmla() {
			return getRuleContext(ImplfmlaContext.class,0);
		}
		public AffectsfmlaContext affectsfmla() {
			return getRuleContext(AffectsfmlaContext.class,0);
		}
		public AffectsposfmlaContext affectsposfmla() {
			return getRuleContext(AffectsposfmlaContext.class,0);
		}
		public AffectsnegfmlaContext affectsnegfmla() {
			return getRuleContext(AffectsnegfmlaContext.class,0);
		}
		public IfmlaContext ifmla() {
			return getRuleContext(IfmlaContext.class,0);
		}
		public GoalfmlaContext goalfmla() {
			return getRuleContext(GoalfmlaContext.class,0);
		}
		public MeansfmlaContext meansfmla() {
			return getRuleContext(MeansfmlaContext.class,0);
		}
		public CausesfmlaContext causesfmla() {
			return getRuleContext(CausesfmlaContext.class,0);
		}
		public PcausesfmlaContext pcausesfmla() {
			return getRuleContext(PcausesfmlaContext.class,0);
		}
		public ScausesfmlaContext scausesfmla() {
			return getRuleContext(ScausesfmlaContext.class,0);
		}
		public ExplainsfmlaContext explainsfmla() {
			return getRuleContext(ExplainsfmlaContext.class,0);
		}
		public PreventsfmlaContext preventsfmla() {
			return getRuleContext(PreventsfmlaContext.class,0);
		}
		public InterventionfmlaContext interventionfmla() {
			return getRuleContext(InterventionfmlaContext.class,0);
		}
		public ExistsfmlaContext existsfmla() {
			return getRuleContext(ExistsfmlaContext.class,0);
		}
		public ForallfmlaContext forallfmla() {
			return getRuleContext(ForallfmlaContext.class,0);
		}
		public GtfmlaContext gtfmla() {
			return getRuleContext(GtfmlaContext.class,0);
		}
		public GeqfmlaContext geqfmla() {
			return getRuleContext(GeqfmlaContext.class,0);
		}
		public MustfmlaContext mustfmla() {
			return getRuleContext(MustfmlaContext.class,0);
		}
		public MayfmlaContext mayfmla() {
			return getRuleContext(MayfmlaContext.class,0);
		}
		public KfmlaContext kfmla() {
			return getRuleContext(KfmlaContext.class,0);
		}
		public ConsequencefmlaContext consequencefmla() {
			return getRuleContext(ConsequencefmlaContext.class,0);
		}
		public StringfmlaContext stringfmla() {
			return getRuleContext(StringfmlaContext.class,0);
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
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				atomfmla();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				notfmla();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				andfmla();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				orfmla();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				notfmla();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
				implfmla();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(76);
				affectsfmla();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(77);
				affectsposfmla();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(78);
				affectsnegfmla();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(79);
				ifmla();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(80);
				goalfmla();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(81);
				meansfmla();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(82);
				causesfmla();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(83);
				pcausesfmla();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(84);
				scausesfmla();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(85);
				explainsfmla();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(86);
				preventsfmla();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(87);
				interventionfmla();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(88);
				existsfmla();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(89);
				forallfmla();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(90);
				gtfmla();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(91);
				geqfmla();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(92);
				mustfmla();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(93);
				mayfmla();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(94);
				kfmla();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(95);
				consequencefmla();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(96);
				stringfmla();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AtomfmlaContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(HeraParser.ATOM, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
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
			setState(99);
			match(ATOM);
			setState(100);
			match(OPEN);
			setState(101);
			formula();
			setState(102);
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
			setState(104);
			match(NOT);
			setState(105);
			match(OPEN);
			setState(106);
			formula();
			setState(107);
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
	public static class AndfmlaContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(HeraParser.AND, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(109);
			match(AND);
			setState(110);
			match(OPEN);
			setState(111);
			formula();
			setState(112);
			match(COMMA);
			setState(113);
			formula();
			setState(114);
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
	public static class OrfmlaContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(HeraParser.OR, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(116);
			match(OR);
			setState(117);
			match(OPEN);
			setState(118);
			formula();
			setState(119);
			match(COMMA);
			setState(120);
			formula();
			setState(121);
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
	public static class ImplfmlaContext extends ParserRuleContext {
		public TerminalNode IMPL() { return getToken(HeraParser.IMPL, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(123);
			match(IMPL);
			setState(124);
			match(OPEN);
			setState(125);
			formula();
			setState(126);
			match(COMMA);
			setState(127);
			formula();
			setState(128);
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
	public static class AffectsfmlaContext extends ParserRuleContext {
		public TerminalNode AFFECTS() { return getToken(HeraParser.AFFECTS, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(130);
			match(AFFECTS);
			setState(131);
			formula();
			setState(132);
			match(COMMA);
			setState(133);
			formula();
			setState(134);
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
	public static class AffectsnegfmlaContext extends ParserRuleContext {
		public TerminalNode AFFECTSNEG() { return getToken(HeraParser.AFFECTSNEG, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(136);
			match(AFFECTSNEG);
			setState(137);
			match(OPEN);
			setState(138);
			formula();
			setState(139);
			match(COMMA);
			setState(140);
			formula();
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
	public static class AffectsposfmlaContext extends ParserRuleContext {
		public TerminalNode AFFECTSPOS() { return getToken(HeraParser.AFFECTSPOS, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(143);
			match(AFFECTSPOS);
			setState(144);
			match(OPEN);
			setState(145);
			formula();
			setState(146);
			match(COMMA);
			setState(147);
			formula();
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
	public static class IfmlaContext extends ParserRuleContext {
		public TerminalNode I() { return getToken(HeraParser.I, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(150);
			match(I);
			setState(151);
			match(OPEN);
			setState(152);
			formula();
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
	public static class GoalfmlaContext extends ParserRuleContext {
		public TerminalNode GOAL() { return getToken(HeraParser.GOAL, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(155);
			match(GOAL);
			setState(156);
			match(OPEN);
			setState(157);
			formula();
			setState(158);
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
	public static class MeansfmlaContext extends ParserRuleContext {
		public TerminalNode MEANS() { return getToken(HeraParser.MEANS, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(160);
			match(MEANS);
			setState(161);
			match(OPEN);
			setState(162);
			formula();
			setState(163);
			match(COMMA);
			setState(164);
			formula();
			setState(165);
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
	public static class CausesfmlaContext extends ParserRuleContext {
		public TerminalNode CAUSES() { return getToken(HeraParser.CAUSES, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(167);
			match(CAUSES);
			setState(168);
			match(OPEN);
			setState(169);
			formula();
			setState(170);
			match(COMMA);
			setState(171);
			formula();
			setState(172);
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
	public static class PcausesfmlaContext extends ParserRuleContext {
		public TerminalNode PCAUSES() { return getToken(HeraParser.PCAUSES, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(174);
			match(PCAUSES);
			setState(175);
			match(OPEN);
			setState(176);
			formula();
			setState(177);
			match(COMMA);
			setState(178);
			formula();
			setState(179);
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
	public static class ScausesfmlaContext extends ParserRuleContext {
		public TerminalNode SCAUSES() { return getToken(HeraParser.SCAUSES, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(181);
			match(SCAUSES);
			setState(182);
			match(OPEN);
			setState(183);
			formula();
			setState(184);
			match(COMMA);
			setState(185);
			formula();
			setState(186);
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
	public static class ExplainsfmlaContext extends ParserRuleContext {
		public TerminalNode EXPLAINS() { return getToken(HeraParser.EXPLAINS, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(188);
			match(EXPLAINS);
			setState(189);
			match(OPEN);
			setState(190);
			formula();
			setState(191);
			match(COMMA);
			setState(192);
			formula();
			setState(193);
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
	public static class PreventsfmlaContext extends ParserRuleContext {
		public TerminalNode PREVENTS() { return getToken(HeraParser.PREVENTS, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(195);
			match(PREVENTS);
			setState(196);
			match(OPEN);
			setState(197);
			formula();
			setState(198);
			match(COMMA);
			setState(199);
			formula();
			setState(200);
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
	public static class InterventionfmlaContext extends ParserRuleContext {
		public TerminalNode INTERVENTION() { return getToken(HeraParser.INTERVENTION, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(202);
			match(INTERVENTION);
			setState(203);
			match(OPEN);
			setState(204);
			formula();
			setState(205);
			match(COMMA);
			setState(206);
			formula();
			setState(207);
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
	public static class ExistsfmlaContext extends ParserRuleContext {
		public TerminalNode EXISTS() { return getToken(HeraParser.EXISTS, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(209);
			match(EXISTS);
			setState(210);
			match(OPEN);
			setState(211);
			formula();
			setState(212);
			match(COMMA);
			setState(213);
			formula();
			setState(214);
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
	public static class ForallfmlaContext extends ParserRuleContext {
		public TerminalNode FORALL() { return getToken(HeraParser.FORALL, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(216);
			match(FORALL);
			setState(217);
			match(OPEN);
			setState(218);
			formula();
			setState(219);
			match(COMMA);
			setState(220);
			formula();
			setState(221);
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
	public static class GtfmlaContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(HeraParser.GT, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
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
			setState(223);
			match(GT);
			setState(224);
			match(OPEN);
			setState(225);
			term();
			setState(226);
			match(COMMA);
			setState(227);
			term();
			setState(228);
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
			setState(230);
			match(GEQ);
			setState(231);
			match(OPEN);
			setState(232);
			term();
			setState(233);
			match(COMMA);
			setState(234);
			term();
			setState(235);
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
	public static class MustfmlaContext extends ParserRuleContext {
		public TerminalNode MUST() { return getToken(HeraParser.MUST, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
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
			setState(237);
			match(MUST);
			setState(238);
			match(OPEN);
			setState(239);
			formula();
			setState(240);
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
	public static class MayfmlaContext extends ParserRuleContext {
		public TerminalNode MAY() { return getToken(HeraParser.MAY, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(242);
			match(MAY);
			setState(243);
			match(OPEN);
			setState(244);
			formula();
			setState(245);
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
	public static class KfmlaContext extends ParserRuleContext {
		public TerminalNode K() { return getToken(HeraParser.K, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(247);
			match(K);
			setState(248);
			match(OPEN);
			setState(249);
			formula();
			setState(250);
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
	public static class ConsequencefmlaContext extends ParserRuleContext {
		public TerminalNode CONSEQUENCE() { return getToken(HeraParser.CONSEQUENCE, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(252);
			match(CONSEQUENCE);
			setState(253);
			match(OPEN);
			setState(254);
			formula();
			setState(255);
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
	public static class StringfmlaContext extends ParserRuleContext {
		public Token w;
		public List<TerminalNode> QUOTE() { return getTokens(HeraParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(HeraParser.QUOTE, i);
		}
		public TerminalNode WORD() { return getToken(HeraParser.WORD, 0); }
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
			setState(257);
			match(QUOTE);
			setState(258);
			((StringfmlaContext)_localctx).w = match(WORD);
			setState(259);
			match(QUOTE);
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
	public static class TermContext extends ParserRuleContext {
		public UtermContext uterm() {
			return getRuleContext(UtermContext.class,0);
		}
		public DrtermContext drterm() {
			return getRuleContext(DrtermContext.class,0);
		}
		public DbtermContext dbterm() {
			return getRuleContext(DbtermContext.class,0);
		}
		public MinustermContext minusterm() {
			return getRuleContext(MinustermContext.class,0);
		}
		public SubtermContext subterm() {
			return getRuleContext(SubtermContext.class,0);
		}
		public AddtermContext addterm() {
			return getRuleContext(AddtermContext.class,0);
		}
		public InttermContext intterm() {
			return getRuleContext(InttermContext.class,0);
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
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case U:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				uterm();
				}
				break;
			case DR:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				drterm();
				}
				break;
			case DB:
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				dbterm();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 4);
				{
				setState(264);
				minusterm();
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 5);
				{
				setState(265);
				subterm();
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 6);
				{
				setState(266);
				addterm();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 7);
				{
				setState(267);
				intterm();
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
	public static class UtermContext extends ParserRuleContext {
		public TerminalNode U() { return getToken(HeraParser.U, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(270);
			match(U);
			setState(271);
			match(OPEN);
			setState(272);
			formula();
			setState(273);
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
	public static class DrtermContext extends ParserRuleContext {
		public TerminalNode DR() { return getToken(HeraParser.DR, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(275);
			match(DR);
			setState(276);
			match(OPEN);
			setState(277);
			formula();
			setState(278);
			match(COMMA);
			setState(279);
			formula();
			setState(280);
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
	public static class DbtermContext extends ParserRuleContext {
		public TerminalNode DB() { return getToken(HeraParser.DB, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(282);
			match(DB);
			setState(283);
			match(OPEN);
			setState(284);
			formula();
			setState(285);
			match(COMMA);
			setState(286);
			formula();
			setState(287);
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
	public static class MinustermContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(HeraParser.MINUS, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(HeraParser.CLOSE, 0); }
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
			setState(289);
			match(MINUS);
			setState(290);
			match(OPEN);
			setState(291);
			term();
			setState(292);
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
	public static class SubtermContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(HeraParser.SUB, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
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
			setState(294);
			match(SUB);
			setState(295);
			match(OPEN);
			setState(296);
			term();
			setState(297);
			match(COMMA);
			setState(298);
			term();
			setState(299);
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
	public static class AddtermContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(HeraParser.ADD, 0); }
		public TerminalNode OPEN() { return getToken(HeraParser.OPEN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HeraParser.COMMA, 0); }
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
			setState(301);
			match(ADD);
			setState(302);
			match(OPEN);
			setState(303);
			term();
			setState(304);
			match(COMMA);
			setState(305);
			term();
			setState(306);
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
			setState(308);
			match(INT);
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
		"\u0004\u0001)\u0137\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u0000b\b\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u010d\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001\"\u0000\u0000#\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BD\u0000\u0000"+
		"\u0133\u0000a\u0001\u0000\u0000\u0000\u0002c\u0001\u0000\u0000\u0000\u0004"+
		"h\u0001\u0000\u0000\u0000\u0006m\u0001\u0000\u0000\u0000\bt\u0001\u0000"+
		"\u0000\u0000\n{\u0001\u0000\u0000\u0000\f\u0082\u0001\u0000\u0000\u0000"+
		"\u000e\u0088\u0001\u0000\u0000\u0000\u0010\u008f\u0001\u0000\u0000\u0000"+
		"\u0012\u0096\u0001\u0000\u0000\u0000\u0014\u009b\u0001\u0000\u0000\u0000"+
		"\u0016\u00a0\u0001\u0000\u0000\u0000\u0018\u00a7\u0001\u0000\u0000\u0000"+
		"\u001a\u00ae\u0001\u0000\u0000\u0000\u001c\u00b5\u0001\u0000\u0000\u0000"+
		"\u001e\u00bc\u0001\u0000\u0000\u0000 \u00c3\u0001\u0000\u0000\u0000\""+
		"\u00ca\u0001\u0000\u0000\u0000$\u00d1\u0001\u0000\u0000\u0000&\u00d8\u0001"+
		"\u0000\u0000\u0000(\u00df\u0001\u0000\u0000\u0000*\u00e6\u0001\u0000\u0000"+
		"\u0000,\u00ed\u0001\u0000\u0000\u0000.\u00f2\u0001\u0000\u0000\u00000"+
		"\u00f7\u0001\u0000\u0000\u00002\u00fc\u0001\u0000\u0000\u00004\u0101\u0001"+
		"\u0000\u0000\u00006\u010c\u0001\u0000\u0000\u00008\u010e\u0001\u0000\u0000"+
		"\u0000:\u0113\u0001\u0000\u0000\u0000<\u011a\u0001\u0000\u0000\u0000>"+
		"\u0121\u0001\u0000\u0000\u0000@\u0126\u0001\u0000\u0000\u0000B\u012d\u0001"+
		"\u0000\u0000\u0000D\u0134\u0001\u0000\u0000\u0000Fb\u0003\u0002\u0001"+
		"\u0000Gb\u0003\u0004\u0002\u0000Hb\u0003\u0006\u0003\u0000Ib\u0003\b\u0004"+
		"\u0000Jb\u0003\u0004\u0002\u0000Kb\u0003\n\u0005\u0000Lb\u0003\f\u0006"+
		"\u0000Mb\u0003\u0010\b\u0000Nb\u0003\u000e\u0007\u0000Ob\u0003\u0012\t"+
		"\u0000Pb\u0003\u0014\n\u0000Qb\u0003\u0016\u000b\u0000Rb\u0003\u0018\f"+
		"\u0000Sb\u0003\u001a\r\u0000Tb\u0003\u001c\u000e\u0000Ub\u0003\u001e\u000f"+
		"\u0000Vb\u0003 \u0010\u0000Wb\u0003\"\u0011\u0000Xb\u0003$\u0012\u0000"+
		"Yb\u0003&\u0013\u0000Zb\u0003(\u0014\u0000[b\u0003*\u0015\u0000\\b\u0003"+
		",\u0016\u0000]b\u0003.\u0017\u0000^b\u00030\u0018\u0000_b\u00032\u0019"+
		"\u0000`b\u00034\u001a\u0000aF\u0001\u0000\u0000\u0000aG\u0001\u0000\u0000"+
		"\u0000aH\u0001\u0000\u0000\u0000aI\u0001\u0000\u0000\u0000aJ\u0001\u0000"+
		"\u0000\u0000aK\u0001\u0000\u0000\u0000aL\u0001\u0000\u0000\u0000aM\u0001"+
		"\u0000\u0000\u0000aN\u0001\u0000\u0000\u0000aO\u0001\u0000\u0000\u0000"+
		"aP\u0001\u0000\u0000\u0000aQ\u0001\u0000\u0000\u0000aR\u0001\u0000\u0000"+
		"\u0000aS\u0001\u0000\u0000\u0000aT\u0001\u0000\u0000\u0000aU\u0001\u0000"+
		"\u0000\u0000aV\u0001\u0000\u0000\u0000aW\u0001\u0000\u0000\u0000aX\u0001"+
		"\u0000\u0000\u0000aY\u0001\u0000\u0000\u0000aZ\u0001\u0000\u0000\u0000"+
		"a[\u0001\u0000\u0000\u0000a\\\u0001\u0000\u0000\u0000a]\u0001\u0000\u0000"+
		"\u0000a^\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000a`\u0001\u0000"+
		"\u0000\u0000b\u0001\u0001\u0000\u0000\u0000cd\u0005\u0001\u0000\u0000"+
		"de\u0005$\u0000\u0000ef\u0003\u0000\u0000\u0000fg\u0005%\u0000\u0000g"+
		"\u0003\u0001\u0000\u0000\u0000hi\u0005\u0002\u0000\u0000ij\u0005$\u0000"+
		"\u0000jk\u0003\u0000\u0000\u0000kl\u0005%\u0000\u0000l\u0005\u0001\u0000"+
		"\u0000\u0000mn\u0005\u0004\u0000\u0000no\u0005$\u0000\u0000op\u0003\u0000"+
		"\u0000\u0000pq\u0005#\u0000\u0000qr\u0003\u0000\u0000\u0000rs\u0005%\u0000"+
		"\u0000s\u0007\u0001\u0000\u0000\u0000tu\u0005\u0003\u0000\u0000uv\u0005"+
		"$\u0000\u0000vw\u0003\u0000\u0000\u0000wx\u0005#\u0000\u0000xy\u0003\u0000"+
		"\u0000\u0000yz\u0005%\u0000\u0000z\t\u0001\u0000\u0000\u0000{|\u0005\u0005"+
		"\u0000\u0000|}\u0005$\u0000\u0000}~\u0003\u0000\u0000\u0000~\u007f\u0005"+
		"#\u0000\u0000\u007f\u0080\u0003\u0000\u0000\u0000\u0080\u0081\u0005%\u0000"+
		"\u0000\u0081\u000b\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u0006\u0000"+
		"\u0000\u0083\u0084\u0003\u0000\u0000\u0000\u0084\u0085\u0005#\u0000\u0000"+
		"\u0085\u0086\u0003\u0000\u0000\u0000\u0086\u0087\u0005%\u0000\u0000\u0087"+
		"\r\u0001\u0000\u0000\u0000\u0088\u0089\u0005\b\u0000\u0000\u0089\u008a"+
		"\u0005$\u0000\u0000\u008a\u008b\u0003\u0000\u0000\u0000\u008b\u008c\u0005"+
		"#\u0000\u0000\u008c\u008d\u0003\u0000\u0000\u0000\u008d\u008e\u0005%\u0000"+
		"\u0000\u008e\u000f\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u0007\u0000"+
		"\u0000\u0090\u0091\u0005$\u0000\u0000\u0091\u0092\u0003\u0000\u0000\u0000"+
		"\u0092\u0093\u0005#\u0000\u0000\u0093\u0094\u0003\u0000\u0000\u0000\u0094"+
		"\u0095\u0005%\u0000\u0000\u0095\u0011\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0005\t\u0000\u0000\u0097\u0098\u0005$\u0000\u0000\u0098\u0099\u0003"+
		"\u0000\u0000\u0000\u0099\u009a\u0005%\u0000\u0000\u009a\u0013\u0001\u0000"+
		"\u0000\u0000\u009b\u009c\u0005\n\u0000\u0000\u009c\u009d\u0005$\u0000"+
		"\u0000\u009d\u009e\u0003\u0000\u0000\u0000\u009e\u009f\u0005%\u0000\u0000"+
		"\u009f\u0015\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u000b\u0000\u0000"+
		"\u00a1\u00a2\u0005$\u0000\u0000\u00a2\u00a3\u0003\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0005#\u0000\u0000\u00a4\u00a5\u0003\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0005%\u0000\u0000\u00a6\u0017\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005"+
		"\f\u0000\u0000\u00a8\u00a9\u0005$\u0000\u0000\u00a9\u00aa\u0003\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0005#\u0000\u0000\u00ab\u00ac\u0003\u0000\u0000"+
		"\u0000\u00ac\u00ad\u0005%\u0000\u0000\u00ad\u0019\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0005\r\u0000\u0000\u00af\u00b0\u0005$\u0000\u0000\u00b0"+
		"\u00b1\u0003\u0000\u0000\u0000\u00b1\u00b2\u0005#\u0000\u0000\u00b2\u00b3"+
		"\u0003\u0000\u0000\u0000\u00b3\u00b4\u0005%\u0000\u0000\u00b4\u001b\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b6\u0005\u000e\u0000\u0000\u00b6\u00b7\u0005"+
		"$\u0000\u0000\u00b7\u00b8\u0003\u0000\u0000\u0000\u00b8\u00b9\u0005#\u0000"+
		"\u0000\u00b9\u00ba\u0003\u0000\u0000\u0000\u00ba\u00bb\u0005%\u0000\u0000"+
		"\u00bb\u001d\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\u000f\u0000\u0000"+
		"\u00bd\u00be\u0005$\u0000\u0000\u00be\u00bf\u0003\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0005#\u0000\u0000\u00c0\u00c1\u0003\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0005%\u0000\u0000\u00c2\u001f\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005"+
		"\u0010\u0000\u0000\u00c4\u00c5\u0005$\u0000\u0000\u00c5\u00c6\u0003\u0000"+
		"\u0000\u0000\u00c6\u00c7\u0005#\u0000\u0000\u00c7\u00c8\u0003\u0000\u0000"+
		"\u0000\u00c8\u00c9\u0005%\u0000\u0000\u00c9!\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cb\u0005\u0011\u0000\u0000\u00cb\u00cc\u0005$\u0000\u0000\u00cc\u00cd"+
		"\u0003\u0000\u0000\u0000\u00cd\u00ce\u0005#\u0000\u0000\u00ce\u00cf\u0003"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0005%\u0000\u0000\u00d0#\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0005\u0012\u0000\u0000\u00d2\u00d3\u0005$\u0000\u0000"+
		"\u00d3\u00d4\u0003\u0000\u0000\u0000\u00d4\u00d5\u0005#\u0000\u0000\u00d5"+
		"\u00d6\u0003\u0000\u0000\u0000\u00d6\u00d7\u0005%\u0000\u0000\u00d7%\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\u0005\u0013\u0000\u0000\u00d9\u00da\u0005"+
		"$\u0000\u0000\u00da\u00db\u0003\u0000\u0000\u0000\u00db\u00dc\u0005#\u0000"+
		"\u0000\u00dc\u00dd\u0003\u0000\u0000\u0000\u00dd\u00de\u0005%\u0000\u0000"+
		"\u00de\'\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u0014\u0000\u0000\u00e0"+
		"\u00e1\u0005$\u0000\u0000\u00e1\u00e2\u00036\u001b\u0000\u00e2\u00e3\u0005"+
		"#\u0000\u0000\u00e3\u00e4\u00036\u001b\u0000\u00e4\u00e5\u0005%\u0000"+
		"\u0000\u00e5)\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005\u0015\u0000\u0000"+
		"\u00e7\u00e8\u0005$\u0000\u0000\u00e8\u00e9\u00036\u001b\u0000\u00e9\u00ea"+
		"\u0005#\u0000\u0000\u00ea\u00eb\u00036\u001b\u0000\u00eb\u00ec\u0005%"+
		"\u0000\u0000\u00ec+\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005\u0016\u0000"+
		"\u0000\u00ee\u00ef\u0005$\u0000\u0000\u00ef\u00f0\u0003\u0000\u0000\u0000"+
		"\u00f0\u00f1\u0005%\u0000\u0000\u00f1-\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0005\u0017\u0000\u0000\u00f3\u00f4\u0005$\u0000\u0000\u00f4\u00f5\u0003"+
		"\u0000\u0000\u0000\u00f5\u00f6\u0005%\u0000\u0000\u00f6/\u0001\u0000\u0000"+
		"\u0000\u00f7\u00f8\u0005\u0018\u0000\u0000\u00f8\u00f9\u0005$\u0000\u0000"+
		"\u00f9\u00fa\u0003\u0000\u0000\u0000\u00fa\u00fb\u0005%\u0000\u0000\u00fb"+
		"1\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005\u0019\u0000\u0000\u00fd\u00fe"+
		"\u0005$\u0000\u0000\u00fe\u00ff\u0003\u0000\u0000\u0000\u00ff\u0100\u0005"+
		"%\u0000\u0000\u01003\u0001\u0000\u0000\u0000\u0101\u0102\u0005\"\u0000"+
		"\u0000\u0102\u0103\u0005!\u0000\u0000\u0103\u0104\u0005\"\u0000\u0000"+
		"\u01045\u0001\u0000\u0000\u0000\u0105\u010d\u00038\u001c\u0000\u0106\u010d"+
		"\u0003:\u001d\u0000\u0107\u010d\u0003<\u001e\u0000\u0108\u010d\u0003>"+
		"\u001f\u0000\u0109\u010d\u0003@ \u0000\u010a\u010d\u0003B!\u0000\u010b"+
		"\u010d\u0003D\"\u0000\u010c\u0105\u0001\u0000\u0000\u0000\u010c\u0106"+
		"\u0001\u0000\u0000\u0000\u010c\u0107\u0001\u0000\u0000\u0000\u010c\u0108"+
		"\u0001\u0000\u0000\u0000\u010c\u0109\u0001\u0000\u0000\u0000\u010c\u010a"+
		"\u0001\u0000\u0000\u0000\u010c\u010b\u0001\u0000\u0000\u0000\u010d7\u0001"+
		"\u0000\u0000\u0000\u010e\u010f\u0005\u001a\u0000\u0000\u010f\u0110\u0005"+
		"$\u0000\u0000\u0110\u0111\u0003\u0000\u0000\u0000\u0111\u0112\u0005%\u0000"+
		"\u0000\u01129\u0001\u0000\u0000\u0000\u0113\u0114\u0005\u001b\u0000\u0000"+
		"\u0114\u0115\u0005$\u0000\u0000\u0115\u0116\u0003\u0000\u0000\u0000\u0116"+
		"\u0117\u0005#\u0000\u0000\u0117\u0118\u0003\u0000\u0000\u0000\u0118\u0119"+
		"\u0005%\u0000\u0000\u0119;\u0001\u0000\u0000\u0000\u011a\u011b\u0005\u001c"+
		"\u0000\u0000\u011b\u011c\u0005$\u0000\u0000\u011c\u011d\u0003\u0000\u0000"+
		"\u0000\u011d\u011e\u0005#\u0000\u0000\u011e\u011f\u0003\u0000\u0000\u0000"+
		"\u011f\u0120\u0005%\u0000\u0000\u0120=\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0005\u001d\u0000\u0000\u0122\u0123\u0005$\u0000\u0000\u0123\u0124\u0003"+
		"6\u001b\u0000\u0124\u0125\u0005%\u0000\u0000\u0125?\u0001\u0000\u0000"+
		"\u0000\u0126\u0127\u0005\u001e\u0000\u0000\u0127\u0128\u0005$\u0000\u0000"+
		"\u0128\u0129\u00036\u001b\u0000\u0129\u012a\u0005#\u0000\u0000\u012a\u012b"+
		"\u00036\u001b\u0000\u012b\u012c\u0005%\u0000\u0000\u012cA\u0001\u0000"+
		"\u0000\u0000\u012d\u012e\u0005\u001f\u0000\u0000\u012e\u012f\u0005$\u0000"+
		"\u0000\u012f\u0130\u00036\u001b\u0000\u0130\u0131\u0005#\u0000\u0000\u0131"+
		"\u0132\u00036\u001b\u0000\u0132\u0133\u0005%\u0000\u0000\u0133C\u0001"+
		"\u0000\u0000\u0000\u0134\u0135\u0005 \u0000\u0000\u0135E\u0001\u0000\u0000"+
		"\u0000\u0002a\u010c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}