// $ANTLR 3.5.1 /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g 2015-10-19 16:00:58

package gwendolen.parser;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class GwendolenLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ACHIEVE=4;
	public static final int ACHIEVEGOAL=5;
	public static final int ADD_CONSTRAINT=6;
	public static final int ADD_CONTENT=7;
	public static final int ADD_CONTEXT=8;
	public static final int ADD_PLAN=9;
	public static final int BAR=10;
	public static final int BELIEFRULES=11;
	public static final int BELIEFS=12;
	public static final int BELIEVE=13;
	public static final int BRULEARROW=14;
	public static final int CLOSE=15;
	public static final int COLON=16;
	public static final int COMMA=17;
	public static final int COMMENT=18;
	public static final int CONST=19;
	public static final int CONSTRAINT=20;
	public static final int CURLYCLOSE=21;
	public static final int CURLYOPEN=22;
	public static final int DIV=23;
	public static final int DOUBLEQUOTE=24;
	public static final int EQ=25;
	public static final int GOAL=26;
	public static final int GOALS=27;
	public static final int GWENDOLEN=28;
	public static final int IN_CONTENT=29;
	public static final int IN_CONTEXT=30;
	public static final int LESS=31;
	public static final int LINE_COMMENT=32;
	public static final int LOCK=33;
	public static final int MINUS=34;
	public static final int MOD=35;
	public static final int MULT=36;
	public static final int NAME=37;
	public static final int NEWLINE=38;
	public static final int NOT=39;
	public static final int NUMBER=40;
	public static final int OPEN=41;
	public static final int PERFORM=42;
	public static final int PERFORMGOAL=43;
	public static final int PLANS=44;
	public static final int PLUS=45;
	public static final int POINT=46;
	public static final int QUERY=47;
	public static final int RECEIVED=48;
	public static final int RULEARROW=49;
	public static final int SEMI=50;
	public static final int SEND=51;
	public static final int SENT=52;
	public static final int SHRIEK=53;
	public static final int SQCLOSE=54;
	public static final int SQOPEN=55;
	public static final int STRING=56;
	public static final int TELL=57;
	public static final int TELLHOW=58;
	public static final int TRUE=59;
	public static final int UNNAMEDVAR=60;
	public static final int VAR=61;
	public static final int WS=62;

	    public int plain_nesting = 0;
	    public int sq_nesting = 0;
	    public int curly_nesting = 0;
	    public boolean stringterm = false;
	    public boolean gwendolen = true;
	    public int belief_rules = 0;


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public GwendolenLexer() {} 
	public GwendolenLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public GwendolenLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g"; }

	// $ANTLR start "GWENDOLEN"
	public final void mGWENDOLEN() throws RecognitionException {
		try {
			int _type = GWENDOLEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:163:11: ({...}? => 'GWENDOLEN' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:163:12: {...}? => 'GWENDOLEN'
			{
			if ( !((curly_nesting == 0)) ) {
				throw new FailedPredicateException(input, "GWENDOLEN", "curly_nesting == 0");
			}
			match("GWENDOLEN"); 

			gwendolen = true;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GWENDOLEN"

	// $ANTLR start "GOALS"
	public final void mGOALS() throws RecognitionException {
		try {
			int _type = GOALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:165:7: ( ':Initial Goals:' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:165:9: ':Initial Goals:'
			{
			match(":Initial Goals:"); 

			belief_rules = 0;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GOALS"

	// $ANTLR start "BELIEFS"
	public final void mBELIEFS() throws RecognitionException {
		try {
			int _type = BELIEFS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:166:9: ( ':Initial Beliefs:' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:166:11: ':Initial Beliefs:'
			{
			match(":Initial Beliefs:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BELIEFS"

	// $ANTLR start "BELIEFRULES"
	public final void mBELIEFRULES() throws RecognitionException {
		try {
			int _type = BELIEFRULES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:168:2: ( ':Reasoning Rules:' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:168:4: ':Reasoning Rules:'
			{
			match(":Reasoning Rules:"); 

			belief_rules = 1;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BELIEFRULES"

	// $ANTLR start "PLANS"
	public final void mPLANS() throws RecognitionException {
		try {
			int _type = PLANS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:169:7: ( ':Plans:' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:169:9: ':Plans:'
			{
			match(":Plans:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLANS"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:170:6: ( ':name:' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:170:8: ':name:'
			{
			match(":name:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "SEND"
	public final void mSEND() throws RecognitionException {
		try {
			int _type = SEND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:172:6: ( '.send' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:172:8: '.send'
			{
			match(".send"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEND"

	// $ANTLR start "RECEIVED"
	public final void mRECEIVED() throws RecognitionException {
		try {
			int _type = RECEIVED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:173:9: ({...}? => '.received' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:173:11: {...}? => '.received'
			{
			if ( !((gwendolen)) ) {
				throw new FailedPredicateException(input, "RECEIVED", "gwendolen");
			}
			match(".received"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RECEIVED"

	// $ANTLR start "BELIEVE"
	public final void mBELIEVE() throws RecognitionException {
		try {
			int _type = BELIEVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:174:9: ({...}? => ( 'B' | '.B' ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:174:11: {...}? => ( 'B' | '.B' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0)) ) {
				throw new FailedPredicateException(input, "BELIEVE", "curly_nesting > 0 && plain_nesting == 0");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:174:56: ( 'B' | '.B' )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='B') ) {
				alt1=1;
			}
			else if ( (LA1_0=='.') ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:174:57: 'B'
					{
					match('B'); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:174:63: '.B'
					{
					match(".B"); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BELIEVE"

	// $ANTLR start "GOAL"
	public final void mGOAL() throws RecognitionException {
		try {
			int _type = GOAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:175:6: ({...}? => ( 'G' | '.G' ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:175:8: {...}? => ( 'G' | '.G' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0)) ) {
				throw new FailedPredicateException(input, "GOAL", "curly_nesting > 0 && plain_nesting == 0");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:175:53: ( 'G' | '.G' )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='G') ) {
				alt2=1;
			}
			else if ( (LA2_0=='.') ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:175:54: 'G'
					{
					match('G'); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:175:60: '.G'
					{
					match(".G"); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GOAL"

	// $ANTLR start "IN_CONTENT"
	public final void mIN_CONTENT() throws RecognitionException {
		try {
			int _type = IN_CONTENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:176:12: ({...}? => ( 'N' ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:176:14: {...}? => ( 'N' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0)) ) {
				throw new FailedPredicateException(input, "IN_CONTENT", "curly_nesting > 0 && plain_nesting == 0");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:176:59: ( 'N' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:176:60: 'N'
			{
			match('N'); 
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN_CONTENT"

	// $ANTLR start "IN_CONTEXT"
	public final void mIN_CONTEXT() throws RecognitionException {
		try {
			int _type = IN_CONTEXT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:177:12: ({...}? => ( 'X' ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:177:14: {...}? => ( 'X' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0)) ) {
				throw new FailedPredicateException(input, "IN_CONTEXT", "curly_nesting > 0 && plain_nesting == 0");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:177:59: ( 'X' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:177:60: 'X'
			{
			match('X'); 
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN_CONTEXT"

	// $ANTLR start "SENT"
	public final void mSENT() throws RecognitionException {
		try {
			int _type = SENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:178:6: ({...}? => '.sent' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:178:8: {...}? => '.sent'
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {
				throw new FailedPredicateException(input, "SENT", "curly_nesting > 0 && plain_nesting == 0|| belief_rules==1");
			}
			match(".sent"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SENT"

	// $ANTLR start "LOCK"
	public final void mLOCK() throws RecognitionException {
		try {
			int _type = LOCK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:179:6: ( '.lock' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:179:8: '.lock'
			{
			match(".lock"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOCK"

	// $ANTLR start "ADD_PLAN"
	public final void mADD_PLAN() throws RecognitionException {
		try {
			int _type = ADD_PLAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:180:10: ( '.plan' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:180:12: '.plan'
			{
			match(".plan"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD_PLAN"

	// $ANTLR start "ADD_CONSTRAINT"
	public final void mADD_CONSTRAINT() throws RecognitionException {
		try {
			int _type = ADD_CONSTRAINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:181:16: ( '.constraint' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:181:18: '.constraint'
			{
			match(".constraint"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD_CONSTRAINT"

	// $ANTLR start "ADD_CONTENT"
	public final void mADD_CONTENT() throws RecognitionException {
		try {
			int _type = ADD_CONTENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:183:2: ( '.n' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:183:4: '.n'
			{
			match(".n"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD_CONTENT"

	// $ANTLR start "ADD_CONTEXT"
	public final void mADD_CONTEXT() throws RecognitionException {
		try {
			int _type = ADD_CONTEXT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:184:13: ( '.x' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:184:15: '.x'
			{
			match(".x"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD_CONTEXT"

	// $ANTLR start "TELL"
	public final void mTELL() throws RecognitionException {
		try {
			int _type = TELL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:186:6: ( ':tell' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:186:8: ':tell'
			{
			match(":tell"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TELL"

	// $ANTLR start "PERFORM"
	public final void mPERFORM() throws RecognitionException {
		try {
			int _type = PERFORM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:187:9: ( ':perform' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:187:11: ':perform'
			{
			match(":perform"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PERFORM"

	// $ANTLR start "ACHIEVE"
	public final void mACHIEVE() throws RecognitionException {
		try {
			int _type = ACHIEVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:188:9: ( ':achieve' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:188:11: ':achieve'
			{
			match(":achieve"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ACHIEVE"

	// $ANTLR start "TELLHOW"
	public final void mTELLHOW() throws RecognitionException {
		try {
			int _type = TELLHOW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:189:9: ( ':how' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:189:11: ':how'
			{
			match(":how"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TELLHOW"

	// $ANTLR start "CONSTRAINT"
	public final void mCONSTRAINT() throws RecognitionException {
		try {
			int _type = CONSTRAINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:191:2: ( ':constrain' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:191:4: ':constrain'
			{
			match(":constrain"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONSTRAINT"

	// $ANTLR start "ACHIEVEGOAL"
	public final void mACHIEVEGOAL() throws RecognitionException {
		try {
			int _type = ACHIEVEGOAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:193:13: ({...}? => 'achieve' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:193:15: {...}? => 'achieve'
			{
			if ( !((sq_nesting > 0)) ) {
				throw new FailedPredicateException(input, "ACHIEVEGOAL", "sq_nesting > 0");
			}
			match("achieve"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ACHIEVEGOAL"

	// $ANTLR start "PERFORMGOAL"
	public final void mPERFORMGOAL() throws RecognitionException {
		try {
			int _type = PERFORMGOAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:194:13: ({...}? => 'perform' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:194:15: {...}? => 'perform'
			{
			if ( !((sq_nesting > 0)) ) {
				throw new FailedPredicateException(input, "PERFORMGOAL", "sq_nesting > 0");
			}
			match("perform"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PERFORMGOAL"

	// $ANTLR start "BRULEARROW"
	public final void mBRULEARROW() throws RecognitionException {
		try {
			int _type = BRULEARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:196:2: ( ':-' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:196:4: ':-'
			{
			match(":-"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BRULEARROW"

	// $ANTLR start "RULEARROW"
	public final void mRULEARROW() throws RecognitionException {
		try {
			int _type = RULEARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:197:11: ( '<-' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:197:13: '<-'
			{
			match("<-"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULEARROW"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:199:6: ({...}? => 'True' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:199:8: {...}? => 'True'
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0)) ) {
				throw new FailedPredicateException(input, "TRUE", "curly_nesting > 0 && plain_nesting == 0");
			}
			match("True"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:261:5: ( '/*' ( . )* '*/' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:261:7: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:261:12: ( . )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='*') ) {
					int LA3_1 = input.LA(2);
					if ( (LA3_1=='/') ) {
						alt3=2;
					}
					else if ( ((LA3_1 >= '\u0000' && LA3_1 <= '.')||(LA3_1 >= '0' && LA3_1 <= '\uFFFF')) ) {
						alt3=1;
					}

				}
				else if ( ((LA3_0 >= '\u0000' && LA3_0 <= ')')||(LA3_0 >= '+' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:261:12: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop3;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "LINE_COMMENT"
	public final void mLINE_COMMENT() throws RecognitionException {
		try {
			int _type = LINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:264:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:264:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:264:12: (~ ( '\\n' | '\\r' ) )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:264:26: ( '\\r' )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='\r') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:264:26: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LINE_COMMENT"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:266:8: ( ( '\\r' )? '\\n' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:266:9: ( '\\r' )? '\\n'
			{
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:266:9: ( '\\r' )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='\r') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:266:9: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:267:5: ({...}? => ( ' ' | '\\t' )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:267:8: {...}? => ( ' ' | '\\t' )+
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "WS", "!stringterm");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:267:24: ( ' ' | '\\t' )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='\t'||LA7_0==' ') ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "OPEN"
	public final void mOPEN() throws RecognitionException {
		try {
			int _type = OPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:270:6: ( '(' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:270:9: '('
			{
			match('('); 
			plain_nesting++;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPEN"

	// $ANTLR start "CLOSE"
	public final void mCLOSE() throws RecognitionException {
		try {
			int _type = CLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:271:7: ( ')' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:271:9: ')'
			{
			match(')'); 
			plain_nesting--;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSE"

	// $ANTLR start "SQOPEN"
	public final void mSQOPEN() throws RecognitionException {
		try {
			int _type = SQOPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:272:8: ( '[' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:272:10: '['
			{
			match('['); 
			sq_nesting++;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SQOPEN"

	// $ANTLR start "SQCLOSE"
	public final void mSQCLOSE() throws RecognitionException {
		try {
			int _type = SQCLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:273:9: ( ']' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:273:11: ']'
			{
			match(']'); 
			sq_nesting--;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SQCLOSE"

	// $ANTLR start "CURLYOPEN"
	public final void mCURLYOPEN() throws RecognitionException {
		try {
			int _type = CURLYOPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:274:11: ( '{' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:274:13: '{'
			{
			match('{'); 
			curly_nesting++;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURLYOPEN"

	// $ANTLR start "CURLYCLOSE"
	public final void mCURLYCLOSE() throws RecognitionException {
		try {
			int _type = CURLYCLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:275:12: ( '}' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:275:14: '}'
			{
			match('}'); 
			curly_nesting--;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURLYCLOSE"

	// $ANTLR start "DOUBLEQUOTE"
	public final void mDOUBLEQUOTE() throws RecognitionException {
		try {
			int _type = DOUBLEQUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:277:2: ( '\"' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:277:4: '\"'
			{
			match('\"'); 
			if (stringterm) {stringterm = false;} else {stringterm = true;}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLEQUOTE"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:278:5: ( '~' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:278:7: '~'
			{
			match('~'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:280:8: ({...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:280:10: {...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' )+
			{
			if ( !((stringterm)) ) {
				throw new FailedPredicateException(input, "STRING", "stringterm");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:280:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==' '||LA8_0=='.'||(LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:
					{
					if ( input.LA(1)==' '||input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "CONST"
	public final void mCONST() throws RecognitionException {
		try {
			int _type = CONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:281:8: ({...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:281:11: {...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "CONST", "!stringterm");
			}
			matchRange('a','z'); 
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:281:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop9;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONST"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:282:5: ({...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:282:7: {...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "VAR", "!stringterm");
			}
			matchRange('A','Z'); 
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:282:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '0' && LA10_0 <= '9')||(LA10_0 >= 'A' && LA10_0 <= 'Z')||LA10_0=='_'||(LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop10;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VAR"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:283:8: ({...}? => '0' .. '9' ( '0' .. '9' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:283:10: {...}? => '0' .. '9' ( '0' .. '9' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "NUMBER", "!stringterm");
			}
			matchRange('0','9'); 
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:283:35: ( '0' .. '9' )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop11;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "UNNAMEDVAR"
	public final void mUNNAMEDVAR() throws RecognitionException {
		try {
			int _type = UNNAMEDVAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:285:2: ({...}? => '_' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:285:4: {...}? => '_'
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "UNNAMEDVAR", "!stringterm");
			}
			match('_'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNNAMEDVAR"

	// $ANTLR start "LESS"
	public final void mLESS() throws RecognitionException {
		try {
			int _type = LESS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:288:6: ( '<' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:288:8: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESS"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:289:4: ( '==' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:289:7: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "POINT"
	public final void mPOINT() throws RecognitionException {
		try {
			int _type = POINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:290:7: ({...}? => '.' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:290:9: {...}? => '.'
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "POINT", "!stringterm");
			}
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POINT"

	// $ANTLR start "MULT"
	public final void mMULT() throws RecognitionException {
		try {
			int _type = MULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:291:6: ( '*' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:291:8: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULT"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:292:6: ( '+' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:292:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:293:7: ( '-' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:293:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:294:5: ( '/' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:294:7: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "MOD"
	public final void mMOD() throws RecognitionException {
		try {
			int _type = MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:295:5: ( '%' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:295:7: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOD"

	// $ANTLR start "SHRIEK"
	public final void mSHRIEK() throws RecognitionException {
		try {
			int _type = SHRIEK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:297:8: ( '!' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:297:10: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SHRIEK"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:298:7: ( ',' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:298:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:299:6: ( ';' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:299:8: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:300:7: ( ':' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:300:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "QUERY"
	public final void mQUERY() throws RecognitionException {
		try {
			int _type = QUERY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:301:7: ( '?' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:301:9: '?'
			{
			match('?'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUERY"

	// $ANTLR start "BAR"
	public final void mBAR() throws RecognitionException {
		try {
			int _type = BAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:302:5: ( '|' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:302:7: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BAR"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:8: ( GWENDOLEN | GOALS | BELIEFS | BELIEFRULES | PLANS | NAME | SEND | RECEIVED | BELIEVE | GOAL | IN_CONTENT | IN_CONTEXT | SENT | LOCK | ADD_PLAN | ADD_CONSTRAINT | ADD_CONTENT | ADD_CONTEXT | TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | UNNAMEDVAR | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY | BAR )
		int alt12=59;
		alt12 = dfa12.predict(input);
		switch (alt12) {
			case 1 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:10: GWENDOLEN
				{
				mGWENDOLEN(); 

				}
				break;
			case 2 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:20: GOALS
				{
				mGOALS(); 

				}
				break;
			case 3 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:26: BELIEFS
				{
				mBELIEFS(); 

				}
				break;
			case 4 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:34: BELIEFRULES
				{
				mBELIEFRULES(); 

				}
				break;
			case 5 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:46: PLANS
				{
				mPLANS(); 

				}
				break;
			case 6 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:52: NAME
				{
				mNAME(); 

				}
				break;
			case 7 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:57: SEND
				{
				mSEND(); 

				}
				break;
			case 8 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:62: RECEIVED
				{
				mRECEIVED(); 

				}
				break;
			case 9 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:71: BELIEVE
				{
				mBELIEVE(); 

				}
				break;
			case 10 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:79: GOAL
				{
				mGOAL(); 

				}
				break;
			case 11 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:84: IN_CONTENT
				{
				mIN_CONTENT(); 

				}
				break;
			case 12 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:95: IN_CONTEXT
				{
				mIN_CONTEXT(); 

				}
				break;
			case 13 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:106: SENT
				{
				mSENT(); 

				}
				break;
			case 14 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:111: LOCK
				{
				mLOCK(); 

				}
				break;
			case 15 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:116: ADD_PLAN
				{
				mADD_PLAN(); 

				}
				break;
			case 16 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:125: ADD_CONSTRAINT
				{
				mADD_CONSTRAINT(); 

				}
				break;
			case 17 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:140: ADD_CONTENT
				{
				mADD_CONTENT(); 

				}
				break;
			case 18 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:152: ADD_CONTEXT
				{
				mADD_CONTEXT(); 

				}
				break;
			case 19 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:164: TELL
				{
				mTELL(); 

				}
				break;
			case 20 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:169: PERFORM
				{
				mPERFORM(); 

				}
				break;
			case 21 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:177: ACHIEVE
				{
				mACHIEVE(); 

				}
				break;
			case 22 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:185: TELLHOW
				{
				mTELLHOW(); 

				}
				break;
			case 23 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:193: CONSTRAINT
				{
				mCONSTRAINT(); 

				}
				break;
			case 24 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:204: ACHIEVEGOAL
				{
				mACHIEVEGOAL(); 

				}
				break;
			case 25 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:216: PERFORMGOAL
				{
				mPERFORMGOAL(); 

				}
				break;
			case 26 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:228: BRULEARROW
				{
				mBRULEARROW(); 

				}
				break;
			case 27 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:239: RULEARROW
				{
				mRULEARROW(); 

				}
				break;
			case 28 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:249: TRUE
				{
				mTRUE(); 

				}
				break;
			case 29 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:254: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 30 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:262: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;
			case 31 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:275: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 32 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:283: WS
				{
				mWS(); 

				}
				break;
			case 33 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:286: OPEN
				{
				mOPEN(); 

				}
				break;
			case 34 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:291: CLOSE
				{
				mCLOSE(); 

				}
				break;
			case 35 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:297: SQOPEN
				{
				mSQOPEN(); 

				}
				break;
			case 36 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:304: SQCLOSE
				{
				mSQCLOSE(); 

				}
				break;
			case 37 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:312: CURLYOPEN
				{
				mCURLYOPEN(); 

				}
				break;
			case 38 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:322: CURLYCLOSE
				{
				mCURLYCLOSE(); 

				}
				break;
			case 39 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:333: DOUBLEQUOTE
				{
				mDOUBLEQUOTE(); 

				}
				break;
			case 40 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:345: NOT
				{
				mNOT(); 

				}
				break;
			case 41 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:349: STRING
				{
				mSTRING(); 

				}
				break;
			case 42 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:356: CONST
				{
				mCONST(); 

				}
				break;
			case 43 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:362: VAR
				{
				mVAR(); 

				}
				break;
			case 44 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:366: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 45 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:373: UNNAMEDVAR
				{
				mUNNAMEDVAR(); 

				}
				break;
			case 46 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:384: LESS
				{
				mLESS(); 

				}
				break;
			case 47 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:389: EQ
				{
				mEQ(); 

				}
				break;
			case 48 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:392: POINT
				{
				mPOINT(); 

				}
				break;
			case 49 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:398: MULT
				{
				mMULT(); 

				}
				break;
			case 50 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:403: PLUS
				{
				mPLUS(); 

				}
				break;
			case 51 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:408: MINUS
				{
				mMINUS(); 

				}
				break;
			case 52 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:414: DIV
				{
				mDIV(); 

				}
				break;
			case 53 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:418: MOD
				{
				mMOD(); 

				}
				break;
			case 54 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:422: SHRIEK
				{
				mSHRIEK(); 

				}
				break;
			case 55 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:429: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 56 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:435: SEMI
				{
				mSEMI(); 

				}
				break;
			case 57 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:440: COLON
				{
				mCOLON(); 

				}
				break;
			case 58 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:446: QUERY
				{
				mQUERY(); 

				}
				break;
			case 59 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:452: BAR
				{
				mBAR(); 

				}
				break;

		}
	}


	protected DFA12 dfa12 = new DFA12(this);
	static final String DFA12_eotS =
		"\1\uffff\1\46\1\63\1\75\1\76\1\77\1\100\2\102\1\106\1\110\1\113\1\uffff"+
		"\1\114\11\uffff\1\102\1\110\1\115\1\117\12\uffff\1\110\1\uffff\1\110\14"+
		"\uffff\2\50\1\126\1\127\3\50\1\133\1\134\4\uffff\1\102\1\uffff\2\102\2"+
		"\uffff\1\110\6\uffff\1\115\1\uffff\1\110\3\uffff\2\50\2\uffff\3\50\6\uffff"+
		"\1\102\1\uffff\1\102\1\110\2\uffff\1\110\1\uffff\5\50\2\uffff\2\102\1"+
		"\175\1\110\1\uffff\1\u0080\1\u0081\1\50\1\u0083\1\u0084\1\50\2\102\1\uffff"+
		"\1\110\3\uffff\1\50\2\uffff\1\50\2\102\1\uffff\1\110\3\uffff\1\50\2\uffff"+
		"\1\50\1\u0097\1\u0098\1\110\1\uffff\2\50\2\uffff\1\u009f\1\uffff\1\u00a2"+
		"\1\50\6\uffff\1\50\2\uffff\1\u00a7\2\uffff";
	static final String DFA12_eofS =
		"\u00a9\uffff";
	static final String DFA12_minS =
		"\1\11\1\40\1\55\6\40\1\55\1\40\1\52\1\uffff\1\11\11\uffff\4\40\12\uffff"+
		"\1\40\1\0\1\40\1\uffff\1\156\12\uffff\2\145\2\40\1\157\1\154\1\157\2\40"+
		"\4\0\1\40\1\0\2\40\2\uffff\1\40\1\0\3\uffff\2\0\1\40\1\0\1\40\2\uffff"+
		"\1\151\1\156\1\143\2\0\1\143\1\141\1\156\2\0\4\uffff\1\40\1\uffff\2\40"+
		"\2\uffff\1\40\1\164\1\144\1\145\1\153\1\156\1\163\2\uffff\4\40\1\151\2"+
		"\40\1\151\2\40\1\164\2\40\1\0\1\40\1\141\2\0\1\166\2\0\1\162\2\40\1\uffff"+
		"\1\40\1\154\2\uffff\1\145\2\uffff\1\141\4\40\1\144\1\151\2\0\1\40\1\102"+
		"\1\40\1\156\2\uffff\1\0\2\uffff\1\0\1\164\2\uffff\1\40\1\0\1\uffff";
	static final String DFA12_maxS =
		"\1\176\1\172\1\164\6\172\1\55\1\172\1\57\1\uffff\1\172\11\uffff\4\172"+
		"\12\uffff\1\172\1\0\1\172\1\uffff\1\156\12\uffff\2\145\2\172\1\157\1\154"+
		"\1\157\2\172\4\0\1\172\1\0\2\172\2\uffff\1\172\1\0\3\uffff\2\0\1\172\1"+
		"\0\1\172\2\uffff\1\151\1\156\1\143\2\0\1\143\1\141\1\156\2\0\4\uffff\1"+
		"\172\1\uffff\2\172\2\uffff\1\172\2\164\1\145\1\153\1\156\1\163\2\uffff"+
		"\4\172\1\151\2\172\1\151\2\172\1\164\2\172\1\0\1\172\1\141\2\0\1\166\2"+
		"\0\1\162\2\172\1\uffff\1\172\1\154\2\uffff\1\145\2\uffff\1\141\3\172\1"+
		"\40\1\144\1\151\2\0\1\172\1\107\1\172\1\156\2\uffff\1\0\2\uffff\1\0\1"+
		"\164\2\uffff\1\172\1\0\1\uffff";
	static final String DFA12_acceptS =
		"\14\uffff\1\37\1\uffff\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\40\4"+
		"\uffff\1\57\1\61\1\62\1\63\1\65\1\66\1\67\1\70\1\72\1\73\3\uffff\1\51"+
		"\1\uffff\1\4\1\5\1\6\1\23\1\24\1\25\1\26\1\27\1\32\1\71\21\uffff\1\33"+
		"\1\56\2\uffff\1\35\1\36\1\64\5\uffff\1\12\1\53\12\uffff\1\60\1\11\1\13"+
		"\1\14\1\uffff\1\52\2\uffff\1\54\1\55\7\uffff\1\21\1\22\30\uffff\1\34\2"+
		"\uffff\1\7\1\15\1\uffff\1\16\1\17\15\uffff\1\30\1\31\1\uffff\1\2\1\3\2"+
		"\uffff\1\1\1\10\2\uffff\1\20";
	static final String DFA12_specialS =
		"\1\103\1\142\1\uffff\1\1\1\33\1\44\1\54\1\126\1\141\1\uffff\1\34\2\uffff"+
		"\1\63\11\uffff\1\36\1\76\1\4\1\6\12\uffff\1\114\1\110\1\35\14\uffff\1"+
		"\133\1\105\1\55\1\77\1\7\1\13\1\16\1\21\1\31\1\67\1\106\1\112\1\115\1"+
		"\65\1\60\1\22\1\73\2\uffff\1\2\1\61\3\uffff\1\56\1\62\1\57\1\64\1\117"+
		"\3\uffff\1\135\1\107\1\42\1\43\1\10\1\14\1\17\1\51\1\52\4\uffff\1\66\1"+
		"\uffff\1\74\1\3\2\uffff\1\121\1\uffff\1\137\1\111\1\11\1\15\1\20\2\uffff"+
		"\1\70\1\75\1\32\1\124\1\uffff\1\37\1\131\1\113\1\0\1\5\1\23\1\71\1\100"+
		"\1\140\1\125\1\uffff\1\40\1\45\1\116\1\46\1\47\1\24\1\72\1\101\1\uffff"+
		"\1\127\3\uffff\1\120\2\uffff\1\25\1\104\1\136\1\130\1\uffff\1\122\1\26"+
		"\1\132\1\134\1\123\1\uffff\1\53\1\27\2\uffff\1\102\2\uffff\1\41\1\30\2"+
		"\uffff\1\12\1\50\1\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\26\1\14\2\uffff\1\14\22\uffff\1\15\1\40\1\24\2\uffff\1\37\2\uffff"+
			"\1\16\1\17\1\34\1\35\1\41\1\36\1\3\1\13\12\31\1\2\1\42\1\11\1\33\1\uffff"+
			"\1\43\1\uffff\1\30\1\4\4\30\1\1\6\30\1\5\5\30\1\12\3\30\1\6\2\30\1\20"+
			"\1\uffff\1\21\1\uffff\1\32\1\uffff\1\7\16\27\1\10\12\27\1\22\1\44\1\23"+
			"\1\25",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\26\47\1\45\3\47\4\uffff\1"+
			"\47\1\uffff\32\47",
			"\1\62\33\uffff\1\51\6\uffff\1\53\1\uffff\1\52\16\uffff\1\57\1\uffff"+
			"\1\61\4\uffff\1\60\5\uffff\1\54\1\uffff\1\56\3\uffff\1\55",
			"\1\50\15\uffff\1\50\1\uffff\12\50\7\uffff\1\50\1\66\4\50\1\67\23\50"+
			"\4\uffff\1\50\1\uffff\2\50\1\72\10\50\1\70\1\50\1\73\1\50\1\71\1\50\1"+
			"\65\1\64\4\50\1\74\2\50",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\2\103\1\101\27\103",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\4\103\1\104\25\103",
			"\1\105",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\21\47\1\107\10\47",
			"\1\111\4\uffff\1\112",
			"",
			"\1\26\26\uffff\1\15\15\uffff\1\50\1\uffff\12\50\7\uffff\32\50\4\uffff"+
			"\1\50\1\uffff\32\50",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\32\103",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"\1\50\15\uffff\1\50\1\uffff\12\116\7\uffff\32\50\4\uffff\1\50\1\uffff"+
			"\32\50",
			"\1\50\15\uffff\1\50\1\uffff\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff"+
			"\32\50",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\4\47\1\120\25\47\4\uffff\1"+
			"\47\1\uffff\32\47",
			"\1\uffff",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"",
			"\1\123",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\124",
			"\1\125",
			"\1\50\15\uffff\1\50\1\uffff\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff"+
			"\32\50",
			"\1\50\15\uffff\1\50\1\uffff\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff"+
			"\32\50",
			"\1\130",
			"\1\131",
			"\1\132",
			"\1\50\15\uffff\1\50\1\uffff\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff"+
			"\32\50",
			"\1\50\15\uffff\1\50\1\uffff\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff"+
			"\32\50",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\7\103\1\141\22\103",
			"\1\uffff",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\32\103",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\21\103\1\143\10\103",
			"",
			"",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\24\47\1\144\5\47",
			"\1\uffff",
			"",
			"",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\50\15\uffff\1\50\1\uffff\12\116\7\uffff\32\50\4\uffff\1\50\1\uffff"+
			"\32\50",
			"\1\uffff",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\15\47\1\147\14\47\4\uffff"+
			"\1\47\1\uffff\32\47",
			"",
			"",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\uffff",
			"\1\uffff",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\uffff",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\10\103\1\160\21\103",
			"",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\5\103\1\161\24\103",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\4\47\1\162\25\47",
			"",
			"",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\3\47\1\163\26\47\4\uffff\1"+
			"\47\1\uffff\32\47",
			"\1\164",
			"\1\165\17\uffff\1\166",
			"\1\167",
			"\1\170",
			"\1\171",
			"\1\172",
			"",
			"",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\4\103\1\173\25\103",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\16\103\1\174\13\103",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\16\47\1\176\13\47\4\uffff"+
			"\1\47\1\uffff\32\47",
			"\1\177",
			"\1\50\15\uffff\1\50\1\uffff\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff"+
			"\32\50",
			"\1\50\15\uffff\1\50\1\uffff\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff"+
			"\32\50",
			"\1\u0082",
			"\1\50\15\uffff\1\50\1\uffff\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff"+
			"\32\50",
			"\1\50\15\uffff\1\50\1\uffff\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff"+
			"\32\50",
			"\1\u0085",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\25\103\1\u0086\4\103",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\21\103\1\u0087\10\103",
			"\1\uffff",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\13\47\1\u0089\16\47\4\uffff"+
			"\1\47\1\uffff\32\47",
			"\1\u008a",
			"\1\uffff",
			"\1\uffff",
			"\1\u008d",
			"\1\uffff",
			"\1\uffff",
			"\1\u0090",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\4\103\1\u0091\25\103",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\14\103\1\u0092\15\103",
			"",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\4\47\1\u0093\25\47\4\uffff"+
			"\1\47\1\uffff\32\47",
			"\1\u0094",
			"",
			"",
			"\1\u0095",
			"",
			"",
			"\1\u0096",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\32\103",
			"\1\50\15\uffff\1\50\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\32\103",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\15\47\1\u0099\14\47\4\uffff"+
			"\1\47\1\uffff\32\47",
			"\1\u009a",
			"\1\u009b",
			"\1\u009c",
			"\1\uffff",
			"\1\uffff",
			"\1\50\15\uffff\1\50\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"\1\u00a1\4\uffff\1\u00a0",
			"\1\50\15\uffff\1\50\1\uffff\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff"+
			"\32\50",
			"\1\u00a3",
			"",
			"",
			"\1\uffff",
			"",
			"",
			"\1\uffff",
			"\1\u00a6",
			"",
			"",
			"\1\50\15\uffff\1\50\1\uffff\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff"+
			"\32\50",
			"\1\uffff",
			""
	};

	static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
	static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
	static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
	static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
	static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
	static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
	static final short[][] DFA12_transition;

	static {
		int numStates = DFA12_transitionS.length;
		DFA12_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
		}
	}

	protected class DFA12 extends DFA {

		public DFA12(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 12;
			this.eot = DFA12_eot;
			this.eof = DFA12_eof;
			this.min = DFA12_min;
			this.max = DFA12_max;
			this.accept = DFA12_accept;
			this.special = DFA12_special;
			this.transition = DFA12_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( GWENDOLEN | GOALS | BELIEFS | BELIEFRULES | PLANS | NAME | SEND | RECEIVED | BELIEVE | GOAL | IN_CONTENT | IN_CONTEXT | SENT | LOCK | ADD_PLAN | ADD_CONSTRAINT | ADD_CONTENT | ADD_CONTEXT | TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | UNNAMEDVAR | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY | BAR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA12_120 = input.LA(1);
						 
						int index12_120 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_120==' '||LA12_120=='.'||(LA12_120 >= '0' && LA12_120 <= '9')||(LA12_120 >= 'A' && LA12_120 <= 'Z')||LA12_120=='_'||(LA12_120 >= 'a' && LA12_120 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 131;
						 
						input.seek(index12_120);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA12_3 = input.LA(1);
						 
						int index12_3 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_3=='s') ) {s = 52;}
						else if ( (LA12_3=='r') && (((gwendolen)||(stringterm)))) {s = 53;}
						else if ( (LA12_3=='B') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)))) {s = 54;}
						else if ( (LA12_3=='G') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)))) {s = 55;}
						else if ( (LA12_3=='l') ) {s = 56;}
						else if ( (LA12_3=='p') ) {s = 57;}
						else if ( (LA12_3=='c') ) {s = 58;}
						else if ( (LA12_3=='n') ) {s = 59;}
						else if ( (LA12_3=='x') ) {s = 60;}
						else if ( (LA12_3==' '||LA12_3=='.'||(LA12_3 >= '0' && LA12_3 <= '9')||LA12_3=='A'||(LA12_3 >= 'C' && LA12_3 <= 'F')||(LA12_3 >= 'H' && LA12_3 <= 'Z')||LA12_3=='_'||(LA12_3 >= 'a' && LA12_3 <= 'b')||(LA12_3 >= 'd' && LA12_3 <= 'k')||LA12_3=='m'||LA12_3=='o'||LA12_3=='q'||(LA12_3 >= 't' && LA12_3 <= 'w')||(LA12_3 >= 'y' && LA12_3 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 61;
						 
						input.seek(index12_3);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA12_71 = input.LA(1);
						 
						int index12_71 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_71=='u') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 100;}
						else if ( ((LA12_71 >= '0' && LA12_71 <= '9')||(LA12_71 >= 'A' && LA12_71 <= 'Z')||LA12_71=='_'||(LA12_71 >= 'a' && LA12_71 <= 't')||(LA12_71 >= 'v' && LA12_71 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_71==' '||LA12_71=='.') && ((stringterm))) {s = 40;}
						else s = 72;
						 
						input.seek(index12_71);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA12_100 = input.LA(1);
						 
						int index12_100 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_100=='e') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 114;}
						else if ( ((LA12_100 >= '0' && LA12_100 <= '9')||(LA12_100 >= 'A' && LA12_100 <= 'Z')||LA12_100=='_'||(LA12_100 >= 'a' && LA12_100 <= 'd')||(LA12_100 >= 'f' && LA12_100 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_100==' '||LA12_100=='.') && ((stringterm))) {s = 40;}
						else s = 72;
						 
						input.seek(index12_100);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA12_25 = input.LA(1);
						 
						int index12_25 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_25 >= '0' && LA12_25 <= '9')) && (((stringterm)||(!stringterm)))) {s = 78;}
						else if ( (LA12_25==' '||LA12_25=='.'||(LA12_25 >= 'A' && LA12_25 <= 'Z')||LA12_25=='_'||(LA12_25 >= 'a' && LA12_25 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 77;
						 
						input.seek(index12_25);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA12_121 = input.LA(1);
						 
						int index12_121 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_121==' '||LA12_121=='.'||(LA12_121 >= '0' && LA12_121 <= '9')||(LA12_121 >= 'A' && LA12_121 <= 'Z')||LA12_121=='_'||(LA12_121 >= 'a' && LA12_121 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 132;
						 
						input.seek(index12_121);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA12_26 = input.LA(1);
						 
						int index12_26 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_26==' '||LA12_26=='.'||(LA12_26 >= '0' && LA12_26 <= '9')||(LA12_26 >= 'A' && LA12_26 <= 'Z')||LA12_26=='_'||(LA12_26 >= 'a' && LA12_26 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 79;
						 
						input.seek(index12_26);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA12_56 = input.LA(1);
						 
						int index12_56 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_56=='o') ) {s = 88;}
						else s = 40;
						 
						input.seek(index12_56);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA12_88 = input.LA(1);
						 
						int index12_88 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_88=='c') ) {s = 107;}
						else s = 40;
						 
						input.seek(index12_88);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA12_107 = input.LA(1);
						 
						int index12_107 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_107=='k') ) {s = 120;}
						else s = 40;
						 
						input.seek(index12_107);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA12_166 = input.LA(1);
						 
						int index12_166 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_166==' '||LA12_166=='.'||(LA12_166 >= '0' && LA12_166 <= '9')||(LA12_166 >= 'A' && LA12_166 <= 'Z')||LA12_166=='_'||(LA12_166 >= 'a' && LA12_166 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 167;
						 
						input.seek(index12_166);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA12_57 = input.LA(1);
						 
						int index12_57 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_57=='l') ) {s = 89;}
						else s = 40;
						 
						input.seek(index12_57);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA12_89 = input.LA(1);
						 
						int index12_89 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_89=='a') ) {s = 108;}
						else s = 40;
						 
						input.seek(index12_89);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA12_108 = input.LA(1);
						 
						int index12_108 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_108=='n') ) {s = 121;}
						else s = 40;
						 
						input.seek(index12_108);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA12_58 = input.LA(1);
						 
						int index12_58 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_58=='o') ) {s = 90;}
						else s = 40;
						 
						input.seek(index12_58);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA12_90 = input.LA(1);
						 
						int index12_90 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_90=='n') ) {s = 109;}
						else s = 40;
						 
						input.seek(index12_90);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA12_109 = input.LA(1);
						 
						int index12_109 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_109=='s') ) {s = 122;}
						else s = 40;
						 
						input.seek(index12_109);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA12_59 = input.LA(1);
						 
						int index12_59 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_59==' '||LA12_59=='.'||(LA12_59 >= '0' && LA12_59 <= '9')||(LA12_59 >= 'A' && LA12_59 <= 'Z')||LA12_59=='_'||(LA12_59 >= 'a' && LA12_59 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 91;
						 
						input.seek(index12_59);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA12_67 = input.LA(1);
						 
						int index12_67 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_67 >= '0' && LA12_67 <= '9')||(LA12_67 >= 'A' && LA12_67 <= 'Z')||LA12_67=='_'||(LA12_67 >= 'a' && LA12_67 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_67==' '||LA12_67=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_67);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA12_122 = input.LA(1);
						 
						int index12_122 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_122=='t') ) {s = 133;}
						else s = 40;
						 
						input.seek(index12_122);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA12_133 = input.LA(1);
						 
						int index12_133 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_133=='r') ) {s = 144;}
						else s = 40;
						 
						input.seek(index12_133);
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA12_144 = input.LA(1);
						 
						int index12_144 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_144=='a') ) {s = 150;}
						else s = 40;
						 
						input.seek(index12_144);
						if ( s>=0 ) return s;
						break;

					case 22 : 
						int LA12_150 = input.LA(1);
						 
						int index12_150 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_150=='i') ) {s = 156;}
						else s = 40;
						 
						input.seek(index12_150);
						if ( s>=0 ) return s;
						break;

					case 23 : 
						int LA12_156 = input.LA(1);
						 
						int index12_156 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_156=='n') ) {s = 163;}
						else s = 40;
						 
						input.seek(index12_156);
						if ( s>=0 ) return s;
						break;

					case 24 : 
						int LA12_163 = input.LA(1);
						 
						int index12_163 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_163=='t') ) {s = 166;}
						else s = 40;
						 
						input.seek(index12_163);
						if ( s>=0 ) return s;
						break;

					case 25 : 
						int LA12_60 = input.LA(1);
						 
						int index12_60 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_60==' '||LA12_60=='.'||(LA12_60 >= '0' && LA12_60 <= '9')||(LA12_60 >= 'A' && LA12_60 <= 'Z')||LA12_60=='_'||(LA12_60 >= 'a' && LA12_60 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 92;
						 
						input.seek(index12_60);
						if ( s>=0 ) return s;
						break;

					case 26 : 
						int LA12_114 = input.LA(1);
						 
						int index12_114 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_114 >= '0' && LA12_114 <= '9')||(LA12_114 >= 'A' && LA12_114 <= 'Z')||LA12_114=='_'||(LA12_114 >= 'a' && LA12_114 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_114==' '||LA12_114=='.') && ((stringterm))) {s = 40;}
						else s = 125;
						 
						input.seek(index12_114);
						if ( s>=0 ) return s;
						break;

					case 27 : 
						int LA12_4 = input.LA(1);
						 
						int index12_4 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_4 >= '0' && LA12_4 <= '9')||(LA12_4 >= 'A' && LA12_4 <= 'Z')||LA12_4=='_'||(LA12_4 >= 'a' && LA12_4 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_4==' '||LA12_4=='.') && ((stringterm))) {s = 40;}
						else s = 62;
						 
						input.seek(index12_4);
						if ( s>=0 ) return s;
						break;

					case 28 : 
						int LA12_10 = input.LA(1);
						 
						int index12_10 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_10=='r') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 71;}
						else if ( ((LA12_10 >= '0' && LA12_10 <= '9')||(LA12_10 >= 'A' && LA12_10 <= 'Z')||LA12_10=='_'||(LA12_10 >= 'a' && LA12_10 <= 'q')||(LA12_10 >= 's' && LA12_10 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_10==' '||LA12_10=='.') && ((stringterm))) {s = 40;}
						else s = 72;
						 
						input.seek(index12_10);
						if ( s>=0 ) return s;
						break;

					case 29 : 
						int LA12_39 = input.LA(1);
						 
						int index12_39 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_39 >= '0' && LA12_39 <= '9')||(LA12_39 >= 'A' && LA12_39 <= 'Z')||LA12_39=='_'||(LA12_39 >= 'a' && LA12_39 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_39==' '||LA12_39=='.') && ((stringterm))) {s = 40;}
						else s = 72;
						 
						input.seek(index12_39);
						if ( s>=0 ) return s;
						break;

					case 30 : 
						int LA12_23 = input.LA(1);
						 
						int index12_23 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_23 >= '0' && LA12_23 <= '9')||(LA12_23 >= 'A' && LA12_23 <= 'Z')||LA12_23=='_'||(LA12_23 >= 'a' && LA12_23 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_23==' '||LA12_23=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_23);
						if ( s>=0 ) return s;
						break;

					case 31 : 
						int LA12_117 = input.LA(1);
						 
						int index12_117 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_117==' '||LA12_117=='.'||(LA12_117 >= '0' && LA12_117 <= '9')||(LA12_117 >= 'A' && LA12_117 <= 'Z')||LA12_117=='_'||(LA12_117 >= 'a' && LA12_117 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 128;
						 
						input.seek(index12_117);
						if ( s>=0 ) return s;
						break;

					case 32 : 
						int LA12_128 = input.LA(1);
						 
						int index12_128 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 139;}
						else if ( ((stringterm)) ) {s = 40;}
						 
						input.seek(index12_128);
						if ( s>=0 ) return s;
						break;

					case 33 : 
						int LA12_162 = input.LA(1);
						 
						int index12_162 = input.index();
						input.rewind();
						s = -1;
						if ( ((gwendolen)) ) {s = 165;}
						else if ( ((stringterm)) ) {s = 40;}
						 
						input.seek(index12_162);
						if ( s>=0 ) return s;
						break;

					case 34 : 
						int LA12_86 = input.LA(1);
						 
						int index12_86 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 94;}
						else if ( ((stringterm)) ) {s = 40;}
						 
						input.seek(index12_86);
						if ( s>=0 ) return s;
						break;

					case 35 : 
						int LA12_87 = input.LA(1);
						 
						int index12_87 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 81;}
						else if ( ((stringterm)) ) {s = 40;}
						 
						input.seek(index12_87);
						if ( s>=0 ) return s;
						break;

					case 36 : 
						int LA12_5 = input.LA(1);
						 
						int index12_5 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_5 >= '0' && LA12_5 <= '9')||(LA12_5 >= 'A' && LA12_5 <= 'Z')||LA12_5=='_'||(LA12_5 >= 'a' && LA12_5 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_5==' '||LA12_5=='.') && ((stringterm))) {s = 40;}
						else s = 63;
						 
						input.seek(index12_5);
						if ( s>=0 ) return s;
						break;

					case 37 : 
						int LA12_129 = input.LA(1);
						 
						int index12_129 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 140;}
						else if ( ((stringterm)) ) {s = 40;}
						 
						input.seek(index12_129);
						if ( s>=0 ) return s;
						break;

					case 38 : 
						int LA12_131 = input.LA(1);
						 
						int index12_131 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 142;}
						else if ( ((stringterm)) ) {s = 40;}
						 
						input.seek(index12_131);
						if ( s>=0 ) return s;
						break;

					case 39 : 
						int LA12_132 = input.LA(1);
						 
						int index12_132 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 143;}
						else if ( ((stringterm)) ) {s = 40;}
						 
						input.seek(index12_132);
						if ( s>=0 ) return s;
						break;

					case 40 : 
						int LA12_167 = input.LA(1);
						 
						int index12_167 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 168;}
						else if ( ((stringterm)) ) {s = 40;}
						 
						input.seek(index12_167);
						if ( s>=0 ) return s;
						break;

					case 41 : 
						int LA12_91 = input.LA(1);
						 
						int index12_91 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 110;}
						else if ( ((stringterm)) ) {s = 40;}
						 
						input.seek(index12_91);
						if ( s>=0 ) return s;
						break;

					case 42 : 
						int LA12_92 = input.LA(1);
						 
						int index12_92 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 111;}
						else if ( ((stringterm)) ) {s = 40;}
						 
						input.seek(index12_92);
						if ( s>=0 ) return s;
						break;

					case 43 : 
						int LA12_155 = input.LA(1);
						 
						int index12_155 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_155==' '||LA12_155=='.'||(LA12_155 >= '0' && LA12_155 <= '9')||(LA12_155 >= 'A' && LA12_155 <= 'Z')||LA12_155=='_'||(LA12_155 >= 'a' && LA12_155 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 162;
						 
						input.seek(index12_155);
						if ( s>=0 ) return s;
						break;

					case 44 : 
						int LA12_6 = input.LA(1);
						 
						int index12_6 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_6 >= '0' && LA12_6 <= '9')||(LA12_6 >= 'A' && LA12_6 <= 'Z')||LA12_6=='_'||(LA12_6 >= 'a' && LA12_6 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_6==' '||LA12_6=='.') && ((stringterm))) {s = 40;}
						else s = 64;
						 
						input.seek(index12_6);
						if ( s>=0 ) return s;
						break;

					case 45 : 
						int LA12_54 = input.LA(1);
						 
						int index12_54 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_54==' '||LA12_54=='.'||(LA12_54 >= '0' && LA12_54 <= '9')||(LA12_54 >= 'A' && LA12_54 <= 'Z')||LA12_54=='_'||(LA12_54 >= 'a' && LA12_54 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 86;
						 
						input.seek(index12_54);
						if ( s>=0 ) return s;
						break;

					case 46 : 
						int LA12_76 = input.LA(1);
						 
						int index12_76 = input.index();
						input.rewind();
						s = -1;
						if ( ((!stringterm)) ) {s = 22;}
						else if ( ((stringterm)) ) {s = 40;}
						 
						input.seek(index12_76);
						if ( s>=0 ) return s;
						break;

					case 47 : 
						int LA12_78 = input.LA(1);
						 
						int index12_78 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_78 >= '0' && LA12_78 <= '9')) && (((stringterm)||(!stringterm)))) {s = 78;}
						else if ( (LA12_78==' '||LA12_78=='.'||(LA12_78 >= 'A' && LA12_78 <= 'Z')||LA12_78=='_'||(LA12_78 >= 'a' && LA12_78 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 77;
						 
						input.seek(index12_78);
						if ( s>=0 ) return s;
						break;

					case 48 : 
						int LA12_66 = input.LA(1);
						 
						int index12_66 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 40;}
						else if ( ((!stringterm)) ) {s = 98;}
						 
						input.seek(index12_66);
						if ( s>=0 ) return s;
						break;

					case 49 : 
						int LA12_72 = input.LA(1);
						 
						int index12_72 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 40;}
						else if ( ((!stringterm)) ) {s = 82;}
						 
						input.seek(index12_72);
						if ( s>=0 ) return s;
						break;

					case 50 : 
						int LA12_77 = input.LA(1);
						 
						int index12_77 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 40;}
						else if ( ((!stringterm)) ) {s = 101;}
						 
						input.seek(index12_77);
						if ( s>=0 ) return s;
						break;

					case 51 : 
						int LA12_13 = input.LA(1);
						 
						int index12_13 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_13==' ') && (((stringterm)||(!stringterm)))) {s = 13;}
						else if ( (LA12_13=='\t') && ((!stringterm))) {s = 22;}
						else if ( (LA12_13=='.'||(LA12_13 >= '0' && LA12_13 <= '9')||(LA12_13 >= 'A' && LA12_13 <= 'Z')||LA12_13=='_'||(LA12_13 >= 'a' && LA12_13 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 76;
						 
						input.seek(index12_13);
						if ( s>=0 ) return s;
						break;

					case 52 : 
						int LA12_79 = input.LA(1);
						 
						int index12_79 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 40;}
						else if ( ((!stringterm)) ) {s = 102;}
						 
						input.seek(index12_79);
						if ( s>=0 ) return s;
						break;

					case 53 : 
						int LA12_65 = input.LA(1);
						 
						int index12_65 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_65=='h') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 97;}
						else if ( ((LA12_65 >= '0' && LA12_65 <= '9')||(LA12_65 >= 'A' && LA12_65 <= 'Z')||LA12_65=='_'||(LA12_65 >= 'a' && LA12_65 <= 'g')||(LA12_65 >= 'i' && LA12_65 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_65==' '||LA12_65=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_65);
						if ( s>=0 ) return s;
						break;

					case 54 : 
						int LA12_97 = input.LA(1);
						 
						int index12_97 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_97=='i') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 112;}
						else if ( ((LA12_97 >= '0' && LA12_97 <= '9')||(LA12_97 >= 'A' && LA12_97 <= 'Z')||LA12_97=='_'||(LA12_97 >= 'a' && LA12_97 <= 'h')||(LA12_97 >= 'j' && LA12_97 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_97==' '||LA12_97=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_97);
						if ( s>=0 ) return s;
						break;

					case 55 : 
						int LA12_61 = input.LA(1);
						 
						int index12_61 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 40;}
						else if ( ((!stringterm)) ) {s = 93;}
						 
						input.seek(index12_61);
						if ( s>=0 ) return s;
						break;

					case 56 : 
						int LA12_112 = input.LA(1);
						 
						int index12_112 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_112=='e') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 123;}
						else if ( ((LA12_112 >= '0' && LA12_112 <= '9')||(LA12_112 >= 'A' && LA12_112 <= 'Z')||LA12_112=='_'||(LA12_112 >= 'a' && LA12_112 <= 'd')||(LA12_112 >= 'f' && LA12_112 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_112==' '||LA12_112=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_112);
						if ( s>=0 ) return s;
						break;

					case 57 : 
						int LA12_123 = input.LA(1);
						 
						int index12_123 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_123=='v') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 134;}
						else if ( ((LA12_123 >= '0' && LA12_123 <= '9')||(LA12_123 >= 'A' && LA12_123 <= 'Z')||LA12_123=='_'||(LA12_123 >= 'a' && LA12_123 <= 'u')||(LA12_123 >= 'w' && LA12_123 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_123==' '||LA12_123=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_123);
						if ( s>=0 ) return s;
						break;

					case 58 : 
						int LA12_134 = input.LA(1);
						 
						int index12_134 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_134=='e') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 145;}
						else if ( ((LA12_134 >= '0' && LA12_134 <= '9')||(LA12_134 >= 'A' && LA12_134 <= 'Z')||LA12_134=='_'||(LA12_134 >= 'a' && LA12_134 <= 'd')||(LA12_134 >= 'f' && LA12_134 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_134==' '||LA12_134=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_134);
						if ( s>=0 ) return s;
						break;

					case 59 : 
						int LA12_68 = input.LA(1);
						 
						int index12_68 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_68=='r') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 99;}
						else if ( ((LA12_68 >= '0' && LA12_68 <= '9')||(LA12_68 >= 'A' && LA12_68 <= 'Z')||LA12_68=='_'||(LA12_68 >= 'a' && LA12_68 <= 'q')||(LA12_68 >= 's' && LA12_68 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_68==' '||LA12_68=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_68);
						if ( s>=0 ) return s;
						break;

					case 60 : 
						int LA12_99 = input.LA(1);
						 
						int index12_99 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_99=='f') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 113;}
						else if ( ((LA12_99 >= '0' && LA12_99 <= '9')||(LA12_99 >= 'A' && LA12_99 <= 'Z')||LA12_99=='_'||(LA12_99 >= 'a' && LA12_99 <= 'e')||(LA12_99 >= 'g' && LA12_99 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_99==' '||LA12_99=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_99);
						if ( s>=0 ) return s;
						break;

					case 61 : 
						int LA12_113 = input.LA(1);
						 
						int index12_113 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_113=='o') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 124;}
						else if ( ((LA12_113 >= '0' && LA12_113 <= '9')||(LA12_113 >= 'A' && LA12_113 <= 'Z')||LA12_113=='_'||(LA12_113 >= 'a' && LA12_113 <= 'n')||(LA12_113 >= 'p' && LA12_113 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_113==' '||LA12_113=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_113);
						if ( s>=0 ) return s;
						break;

					case 62 : 
						int LA12_24 = input.LA(1);
						 
						int index12_24 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_24 >= '0' && LA12_24 <= '9')||(LA12_24 >= 'A' && LA12_24 <= 'Z')||LA12_24=='_'||(LA12_24 >= 'a' && LA12_24 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_24==' '||LA12_24=='.') && ((stringterm))) {s = 40;}
						else s = 72;
						 
						input.seek(index12_24);
						if ( s>=0 ) return s;
						break;

					case 63 : 
						int LA12_55 = input.LA(1);
						 
						int index12_55 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_55==' '||LA12_55=='.'||(LA12_55 >= '0' && LA12_55 <= '9')||(LA12_55 >= 'A' && LA12_55 <= 'Z')||LA12_55=='_'||(LA12_55 >= 'a' && LA12_55 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 87;
						 
						input.seek(index12_55);
						if ( s>=0 ) return s;
						break;

					case 64 : 
						int LA12_124 = input.LA(1);
						 
						int index12_124 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_124=='r') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 135;}
						else if ( ((LA12_124 >= '0' && LA12_124 <= '9')||(LA12_124 >= 'A' && LA12_124 <= 'Z')||LA12_124=='_'||(LA12_124 >= 'a' && LA12_124 <= 'q')||(LA12_124 >= 's' && LA12_124 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_124==' '||LA12_124=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_124);
						if ( s>=0 ) return s;
						break;

					case 65 : 
						int LA12_135 = input.LA(1);
						 
						int index12_135 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_135=='m') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 146;}
						else if ( ((LA12_135 >= '0' && LA12_135 <= '9')||(LA12_135 >= 'A' && LA12_135 <= 'Z')||LA12_135=='_'||(LA12_135 >= 'a' && LA12_135 <= 'l')||(LA12_135 >= 'n' && LA12_135 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_135==' '||LA12_135=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_135);
						if ( s>=0 ) return s;
						break;

					case 66 : 
						int LA12_159 = input.LA(1);
						 
						int index12_159 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting == 0)) ) {s = 164;}
						else if ( ((stringterm)) ) {s = 40;}
						else if ( ((!stringterm)) ) {s = 82;}
						 
						input.seek(index12_159);
						if ( s>=0 ) return s;
						break;

					case 67 : 
						int LA12_0 = input.LA(1);
						 
						int index12_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_0=='G') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 1;}
						else if ( (LA12_0==':') ) {s = 2;}
						else if ( (LA12_0=='.') ) {s = 3;}
						else if ( (LA12_0=='B') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 4;}
						else if ( (LA12_0=='N') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 5;}
						else if ( (LA12_0=='X') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 6;}
						else if ( (LA12_0=='a') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 7;}
						else if ( (LA12_0=='p') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 8;}
						else if ( (LA12_0=='<') ) {s = 9;}
						else if ( (LA12_0=='T') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 10;}
						else if ( (LA12_0=='/') ) {s = 11;}
						else if ( (LA12_0=='\n'||LA12_0=='\r') ) {s = 12;}
						else if ( (LA12_0==' ') && (((stringterm)||(!stringterm)))) {s = 13;}
						else if ( (LA12_0=='(') ) {s = 14;}
						else if ( (LA12_0==')') ) {s = 15;}
						else if ( (LA12_0=='[') ) {s = 16;}
						else if ( (LA12_0==']') ) {s = 17;}
						else if ( (LA12_0=='{') ) {s = 18;}
						else if ( (LA12_0=='}') ) {s = 19;}
						else if ( (LA12_0=='\"') ) {s = 20;}
						else if ( (LA12_0=='~') ) {s = 21;}
						else if ( (LA12_0=='\t') && ((!stringterm))) {s = 22;}
						else if ( ((LA12_0 >= 'b' && LA12_0 <= 'o')||(LA12_0 >= 'q' && LA12_0 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 23;}
						else if ( (LA12_0=='A'||(LA12_0 >= 'C' && LA12_0 <= 'F')||(LA12_0 >= 'H' && LA12_0 <= 'M')||(LA12_0 >= 'O' && LA12_0 <= 'S')||(LA12_0 >= 'U' && LA12_0 <= 'W')||(LA12_0 >= 'Y' && LA12_0 <= 'Z')) && (((stringterm)||(!stringterm)))) {s = 24;}
						else if ( ((LA12_0 >= '0' && LA12_0 <= '9')) && (((stringterm)||(!stringterm)))) {s = 25;}
						else if ( (LA12_0=='_') && (((stringterm)||(!stringterm)))) {s = 26;}
						else if ( (LA12_0=='=') ) {s = 27;}
						else if ( (LA12_0=='*') ) {s = 28;}
						else if ( (LA12_0=='+') ) {s = 29;}
						else if ( (LA12_0=='-') ) {s = 30;}
						else if ( (LA12_0=='%') ) {s = 31;}
						else if ( (LA12_0=='!') ) {s = 32;}
						else if ( (LA12_0==',') ) {s = 33;}
						else if ( (LA12_0==';') ) {s = 34;}
						else if ( (LA12_0=='?') ) {s = 35;}
						else if ( (LA12_0=='|') ) {s = 36;}
						 
						input.seek(index12_0);
						if ( s>=0 ) return s;
						break;

					case 68 : 
						int LA12_145 = input.LA(1);
						 
						int index12_145 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_145 >= '0' && LA12_145 <= '9')||(LA12_145 >= 'A' && LA12_145 <= 'Z')||LA12_145=='_'||(LA12_145 >= 'a' && LA12_145 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_145==' '||LA12_145=='.') && ((stringterm))) {s = 40;}
						else s = 151;
						 
						input.seek(index12_145);
						if ( s>=0 ) return s;
						break;

					case 69 : 
						int LA12_53 = input.LA(1);
						 
						int index12_53 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_53=='e') && (((gwendolen)||(stringterm)))) {s = 85;}
						else s = 40;
						 
						input.seek(index12_53);
						if ( s>=0 ) return s;
						break;

					case 70 : 
						int LA12_62 = input.LA(1);
						 
						int index12_62 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 94;}
						else if ( ((stringterm)) ) {s = 40;}
						else if ( ((!stringterm)) ) {s = 82;}
						 
						input.seek(index12_62);
						if ( s>=0 ) return s;
						break;

					case 71 : 
						int LA12_85 = input.LA(1);
						 
						int index12_85 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_85=='c') && (((gwendolen)||(stringterm)))) {s = 106;}
						else s = 40;
						 
						input.seek(index12_85);
						if ( s>=0 ) return s;
						break;

					case 72 : 
						int LA12_38 = input.LA(1);
						 
						int index12_38 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 81;}
						else if ( ((stringterm)) ) {s = 40;}
						else if ( ((!stringterm)) ) {s = 82;}
						 
						input.seek(index12_38);
						if ( s>=0 ) return s;
						break;

					case 73 : 
						int LA12_106 = input.LA(1);
						 
						int index12_106 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_106=='e') && (((gwendolen)||(stringterm)))) {s = 119;}
						else s = 40;
						 
						input.seek(index12_106);
						if ( s>=0 ) return s;
						break;

					case 74 : 
						int LA12_63 = input.LA(1);
						 
						int index12_63 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 95;}
						else if ( ((stringterm)) ) {s = 40;}
						else if ( ((!stringterm)) ) {s = 82;}
						 
						input.seek(index12_63);
						if ( s>=0 ) return s;
						break;

					case 75 : 
						int LA12_119 = input.LA(1);
						 
						int index12_119 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_119=='i') && (((gwendolen)||(stringterm)))) {s = 130;}
						else s = 40;
						 
						input.seek(index12_119);
						if ( s>=0 ) return s;
						break;

					case 76 : 
						int LA12_37 = input.LA(1);
						 
						int index12_37 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_37=='E') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 80;}
						else if ( ((LA12_37 >= '0' && LA12_37 <= '9')||(LA12_37 >= 'A' && LA12_37 <= 'D')||(LA12_37 >= 'F' && LA12_37 <= 'Z')||LA12_37=='_'||(LA12_37 >= 'a' && LA12_37 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_37==' '||LA12_37=='.') && ((stringterm))) {s = 40;}
						else s = 72;
						 
						input.seek(index12_37);
						if ( s>=0 ) return s;
						break;

					case 77 : 
						int LA12_64 = input.LA(1);
						 
						int index12_64 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 96;}
						else if ( ((stringterm)) ) {s = 40;}
						else if ( ((!stringterm)) ) {s = 82;}
						 
						input.seek(index12_64);
						if ( s>=0 ) return s;
						break;

					case 78 : 
						int LA12_130 = input.LA(1);
						 
						int index12_130 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_130=='v') && (((gwendolen)||(stringterm)))) {s = 141;}
						else s = 40;
						 
						input.seek(index12_130);
						if ( s>=0 ) return s;
						break;

					case 79 : 
						int LA12_80 = input.LA(1);
						 
						int index12_80 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_80=='N') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 103;}
						else if ( ((LA12_80 >= '0' && LA12_80 <= '9')||(LA12_80 >= 'A' && LA12_80 <= 'M')||(LA12_80 >= 'O' && LA12_80 <= 'Z')||LA12_80=='_'||(LA12_80 >= 'a' && LA12_80 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_80==' '||LA12_80=='.') && ((stringterm))) {s = 40;}
						else s = 72;
						 
						input.seek(index12_80);
						if ( s>=0 ) return s;
						break;

					case 80 : 
						int LA12_141 = input.LA(1);
						 
						int index12_141 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_141=='e') && (((gwendolen)||(stringterm)))) {s = 149;}
						else s = 40;
						 
						input.seek(index12_141);
						if ( s>=0 ) return s;
						break;

					case 81 : 
						int LA12_103 = input.LA(1);
						 
						int index12_103 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_103=='D') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 115;}
						else if ( ((LA12_103 >= '0' && LA12_103 <= '9')||(LA12_103 >= 'A' && LA12_103 <= 'C')||(LA12_103 >= 'E' && LA12_103 <= 'Z')||LA12_103=='_'||(LA12_103 >= 'a' && LA12_103 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_103==' '||LA12_103=='.') && ((stringterm))) {s = 40;}
						else s = 72;
						 
						input.seek(index12_103);
						if ( s>=0 ) return s;
						break;

					case 82 : 
						int LA12_149 = input.LA(1);
						 
						int index12_149 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_149=='d') && (((gwendolen)||(stringterm)))) {s = 155;}
						else s = 40;
						 
						input.seek(index12_149);
						if ( s>=0 ) return s;
						break;

					case 83 : 
						int LA12_153 = input.LA(1);
						 
						int index12_153 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_153 >= '0' && LA12_153 <= '9')||(LA12_153 >= 'A' && LA12_153 <= 'Z')||LA12_153=='_'||(LA12_153 >= 'a' && LA12_153 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_153==' '||LA12_153=='.') && ((stringterm))) {s = 40;}
						else s = 159;
						 
						input.seek(index12_153);
						if ( s>=0 ) return s;
						break;

					case 84 : 
						int LA12_115 = input.LA(1);
						 
						int index12_115 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_115=='O') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 126;}
						else if ( ((LA12_115 >= '0' && LA12_115 <= '9')||(LA12_115 >= 'A' && LA12_115 <= 'N')||(LA12_115 >= 'P' && LA12_115 <= 'Z')||LA12_115=='_'||(LA12_115 >= 'a' && LA12_115 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_115==' '||LA12_115=='.') && ((stringterm))) {s = 40;}
						else s = 72;
						 
						input.seek(index12_115);
						if ( s>=0 ) return s;
						break;

					case 85 : 
						int LA12_126 = input.LA(1);
						 
						int index12_126 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_126=='L') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 137;}
						else if ( ((LA12_126 >= '0' && LA12_126 <= '9')||(LA12_126 >= 'A' && LA12_126 <= 'K')||(LA12_126 >= 'M' && LA12_126 <= 'Z')||LA12_126=='_'||(LA12_126 >= 'a' && LA12_126 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_126==' '||LA12_126=='.') && ((stringterm))) {s = 40;}
						else s = 72;
						 
						input.seek(index12_126);
						if ( s>=0 ) return s;
						break;

					case 86 : 
						int LA12_7 = input.LA(1);
						 
						int index12_7 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_7=='c') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 65;}
						else if ( ((LA12_7 >= '0' && LA12_7 <= '9')||(LA12_7 >= 'A' && LA12_7 <= 'Z')||LA12_7=='_'||(LA12_7 >= 'a' && LA12_7 <= 'b')||(LA12_7 >= 'd' && LA12_7 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_7==' '||LA12_7=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_7);
						if ( s>=0 ) return s;
						break;

					case 87 : 
						int LA12_137 = input.LA(1);
						 
						int index12_137 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_137=='E') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 147;}
						else if ( ((LA12_137 >= '0' && LA12_137 <= '9')||(LA12_137 >= 'A' && LA12_137 <= 'D')||(LA12_137 >= 'F' && LA12_137 <= 'Z')||LA12_137=='_'||(LA12_137 >= 'a' && LA12_137 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_137==' '||LA12_137=='.') && ((stringterm))) {s = 40;}
						else s = 72;
						 
						input.seek(index12_137);
						if ( s>=0 ) return s;
						break;

					case 88 : 
						int LA12_147 = input.LA(1);
						 
						int index12_147 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_147=='N') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 153;}
						else if ( ((LA12_147 >= '0' && LA12_147 <= '9')||(LA12_147 >= 'A' && LA12_147 <= 'M')||(LA12_147 >= 'O' && LA12_147 <= 'Z')||LA12_147=='_'||(LA12_147 >= 'a' && LA12_147 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_147==' '||LA12_147=='.') && ((stringterm))) {s = 40;}
						else s = 72;
						 
						input.seek(index12_147);
						if ( s>=0 ) return s;
						break;

					case 89 : 
						int LA12_118 = input.LA(1);
						 
						int index12_118 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_118==' '||LA12_118=='.'||(LA12_118 >= '0' && LA12_118 <= '9')||(LA12_118 >= 'A' && LA12_118 <= 'Z')||LA12_118=='_'||(LA12_118 >= 'a' && LA12_118 <= 'z')) && ((stringterm))) {s = 40;}
						else s = 129;
						 
						input.seek(index12_118);
						if ( s>=0 ) return s;
						break;

					case 90 : 
						int LA12_151 = input.LA(1);
						 
						int index12_151 = input.index();
						input.rewind();
						s = -1;
						if ( ((sq_nesting > 0)) ) {s = 157;}
						else if ( ((stringterm)) ) {s = 40;}
						else if ( ((!stringterm)) ) {s = 98;}
						 
						input.seek(index12_151);
						if ( s>=0 ) return s;
						break;

					case 91 : 
						int LA12_52 = input.LA(1);
						 
						int index12_52 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_52=='e') ) {s = 84;}
						else s = 40;
						 
						input.seek(index12_52);
						if ( s>=0 ) return s;
						break;

					case 92 : 
						int LA12_152 = input.LA(1);
						 
						int index12_152 = input.index();
						input.rewind();
						s = -1;
						if ( ((sq_nesting > 0)) ) {s = 158;}
						else if ( ((stringterm)) ) {s = 40;}
						else if ( ((!stringterm)) ) {s = 98;}
						 
						input.seek(index12_152);
						if ( s>=0 ) return s;
						break;

					case 93 : 
						int LA12_84 = input.LA(1);
						 
						int index12_84 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_84=='n') ) {s = 105;}
						else s = 40;
						 
						input.seek(index12_84);
						if ( s>=0 ) return s;
						break;

					case 94 : 
						int LA12_146 = input.LA(1);
						 
						int index12_146 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_146 >= '0' && LA12_146 <= '9')||(LA12_146 >= 'A' && LA12_146 <= 'Z')||LA12_146=='_'||(LA12_146 >= 'a' && LA12_146 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_146==' '||LA12_146=='.') && ((stringterm))) {s = 40;}
						else s = 152;
						 
						input.seek(index12_146);
						if ( s>=0 ) return s;
						break;

					case 95 : 
						int LA12_105 = input.LA(1);
						 
						int index12_105 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_105=='d') ) {s = 117;}
						else if ( (LA12_105=='t') && (((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)||(stringterm)))) {s = 118;}
						else s = 40;
						 
						input.seek(index12_105);
						if ( s>=0 ) return s;
						break;

					case 96 : 
						int LA12_125 = input.LA(1);
						 
						int index12_125 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 136;}
						else if ( ((stringterm)) ) {s = 40;}
						else if ( ((!stringterm)) ) {s = 82;}
						 
						input.seek(index12_125);
						if ( s>=0 ) return s;
						break;

					case 97 : 
						int LA12_8 = input.LA(1);
						 
						int index12_8 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_8=='e') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 68;}
						else if ( ((LA12_8 >= '0' && LA12_8 <= '9')||(LA12_8 >= 'A' && LA12_8 <= 'Z')||LA12_8=='_'||(LA12_8 >= 'a' && LA12_8 <= 'd')||(LA12_8 >= 'f' && LA12_8 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_8==' '||LA12_8=='.') && ((stringterm))) {s = 40;}
						else s = 66;
						 
						input.seek(index12_8);
						if ( s>=0 ) return s;
						break;

					case 98 : 
						int LA12_1 = input.LA(1);
						 
						int index12_1 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_1=='W') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 37;}
						else if ( ((LA12_1 >= '0' && LA12_1 <= '9')||(LA12_1 >= 'A' && LA12_1 <= 'V')||(LA12_1 >= 'X' && LA12_1 <= 'Z')||LA12_1=='_'||(LA12_1 >= 'a' && LA12_1 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_1==' '||LA12_1=='.') && ((stringterm))) {s = 40;}
						else s = 38;
						 
						input.seek(index12_1);
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 12, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
