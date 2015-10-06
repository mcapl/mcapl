// $ANTLR 3.5.1 /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g 2015-07-30 15:51:40

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
	public static final int VAR=60;
	public static final int WS=61;

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

	// $ANTLR start "LESS"
	public final void mLESS() throws RecognitionException {
		try {
			int _type = LESS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:286:6: ( '<' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:286:8: '<'
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:287:4: ( '==' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:287:7: '=='
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:288:7: ({...}? => '.' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:288:9: {...}? => '.'
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:289:6: ( '*' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:289:8: '*'
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:290:6: ( '+' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:290:8: '+'
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:291:7: ( '-' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:291:9: '-'
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:292:5: ( '/' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:292:7: '/'
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:293:5: ( '%' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:293:7: '%'
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:295:8: ( '!' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:295:10: '!'
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:296:7: ( ',' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:296:9: ','
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:297:6: ( ';' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:297:8: ';'
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:298:7: ( ':' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:298:9: ':'
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:299:7: ( '?' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:299:9: '?'
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:300:5: ( '|' )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:300:7: '|'
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
		// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:8: ( GWENDOLEN | GOALS | BELIEFS | BELIEFRULES | PLANS | NAME | SEND | RECEIVED | BELIEVE | GOAL | IN_CONTENT | IN_CONTEXT | SENT | LOCK | ADD_PLAN | ADD_CONSTRAINT | ADD_CONTENT | ADD_CONTEXT | TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY | BAR )
		int alt12=58;
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
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:373: LESS
				{
				mLESS(); 

				}
				break;
			case 46 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:378: EQ
				{
				mEQ(); 

				}
				break;
			case 47 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:381: POINT
				{
				mPOINT(); 

				}
				break;
			case 48 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:387: MULT
				{
				mMULT(); 

				}
				break;
			case 49 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:392: PLUS
				{
				mPLUS(); 

				}
				break;
			case 50 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:397: MINUS
				{
				mMINUS(); 

				}
				break;
			case 51 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:403: DIV
				{
				mDIV(); 

				}
				break;
			case 52 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:407: MOD
				{
				mMOD(); 

				}
				break;
			case 53 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:411: SHRIEK
				{
				mSHRIEK(); 

				}
				break;
			case 54 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:418: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 55 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:424: SEMI
				{
				mSEMI(); 

				}
				break;
			case 56 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:429: COLON
				{
				mCOLON(); 

				}
				break;
			case 57 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:435: QUERY
				{
				mQUERY(); 

				}
				break;
			case 58 :
				// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:441: BAR
				{
				mBAR(); 

				}
				break;

		}
	}


	protected DFA12 dfa12 = new DFA12(this);
	static final String DFA12_eotS =
		"\1\uffff\1\46\1\62\1\74\1\75\1\76\1\77\2\101\1\105\1\107\1\112\1\uffff"+
		"\1\113\11\uffff\1\101\1\107\1\114\13\uffff\1\107\1\uffff\1\107\13\uffff"+
		"\2\32\1\124\1\125\3\32\1\131\1\132\4\uffff\1\101\1\uffff\2\101\2\uffff"+
		"\1\107\6\uffff\1\114\1\107\3\uffff\2\32\2\uffff\3\32\6\uffff\1\101\1\uffff"+
		"\1\101\1\107\1\uffff\1\107\1\uffff\5\32\2\uffff\2\101\1\172\1\107\1\uffff"+
		"\1\175\1\176\1\32\1\u0080\1\u0081\1\32\2\101\1\uffff\1\107\3\uffff\1\32"+
		"\2\uffff\1\32\2\101\1\uffff\1\107\3\uffff\1\32\2\uffff\1\32\1\u0094\1"+
		"\u0095\1\107\1\uffff\2\32\2\uffff\1\u009c\1\uffff\1\u009f\1\32\6\uffff"+
		"\1\32\2\uffff\1\u00a4\2\uffff";
	static final String DFA12_eofS =
		"\u00a6\uffff";
	static final String DFA12_minS =
		"\1\11\1\40\1\55\6\40\1\55\1\40\1\52\1\uffff\1\11\11\uffff\3\40\13\uffff"+
		"\1\40\1\0\1\40\1\156\12\uffff\2\145\2\40\1\157\1\154\1\157\2\40\4\0\1"+
		"\40\1\0\2\40\2\uffff\1\40\1\0\3\uffff\2\0\2\40\2\uffff\1\151\1\156\1\143"+
		"\2\0\1\143\1\141\1\156\2\0\4\uffff\1\40\1\uffff\2\40\1\uffff\1\40\1\164"+
		"\1\144\1\145\1\153\1\156\1\163\2\uffff\4\40\1\151\2\40\1\151\2\40\1\164"+
		"\2\40\1\0\1\40\1\141\2\0\1\166\2\0\1\162\2\40\1\uffff\1\40\1\154\2\uffff"+
		"\1\145\2\uffff\1\141\4\40\1\144\1\151\2\0\1\40\1\102\1\40\1\156\2\uffff"+
		"\1\0\2\uffff\1\0\1\164\2\uffff\1\40\1\0\1\uffff";
	static final String DFA12_maxS =
		"\1\176\1\172\1\164\6\172\1\55\1\172\1\57\1\uffff\1\172\11\uffff\3\172"+
		"\13\uffff\1\172\1\0\1\172\1\156\12\uffff\2\145\2\172\1\157\1\154\1\157"+
		"\2\172\4\0\1\172\1\0\2\172\2\uffff\1\172\1\0\3\uffff\2\0\2\172\2\uffff"+
		"\1\151\1\156\1\143\2\0\1\143\1\141\1\156\2\0\4\uffff\1\172\1\uffff\2\172"+
		"\1\uffff\1\172\2\164\1\145\1\153\1\156\1\163\2\uffff\4\172\1\151\2\172"+
		"\1\151\2\172\1\164\2\172\1\0\1\172\1\141\2\0\1\166\2\0\1\162\2\172\1\uffff"+
		"\1\172\1\154\2\uffff\1\145\2\uffff\1\141\3\172\1\40\1\144\1\151\2\0\1"+
		"\172\1\107\1\172\1\156\2\uffff\1\0\2\uffff\1\0\1\164\2\uffff\1\172\1\0"+
		"\1\uffff";
	static final String DFA12_acceptS =
		"\14\uffff\1\37\1\uffff\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\40\3"+
		"\uffff\1\51\1\56\1\60\1\61\1\62\1\64\1\65\1\66\1\67\1\71\1\72\4\uffff"+
		"\1\4\1\5\1\6\1\23\1\24\1\25\1\26\1\27\1\32\1\70\21\uffff\1\33\1\55\2\uffff"+
		"\1\35\1\36\1\63\4\uffff\1\12\1\53\12\uffff\1\57\1\11\1\13\1\14\1\uffff"+
		"\1\52\2\uffff\1\54\7\uffff\1\21\1\22\30\uffff\1\34\2\uffff\1\7\1\15\1"+
		"\uffff\1\16\1\17\15\uffff\1\30\1\31\1\uffff\1\2\1\3\2\uffff\1\1\1\10\2"+
		"\uffff\1\20";
	static final String DFA12_specialS =
		"\1\23\1\74\1\uffff\1\103\1\10\1\30\1\31\1\77\1\110\1\uffff\1\25\2\uffff"+
		"\1\42\11\uffff\1\27\1\57\1\134\13\uffff\1\76\1\113\1\26\13\uffff\1\131"+
		"\1\116\1\35\1\65\1\1\1\5\1\13\1\2\1\11\1\72\1\112\1\114\1\115\1\44\1\66"+
		"\1\0\1\56\2\uffff\1\130\1\67\3\uffff\1\64\1\70\1\34\1\100\3\uffff\1\135"+
		"\1\117\1\40\1\41\1\3\1\6\1\14\1\52\1\54\4\uffff\1\46\1\uffff\1\60\1\132"+
		"\1\uffff\1\101\1\uffff\1\136\1\120\1\4\1\7\1\15\2\uffff\1\50\1\61\1\12"+
		"\1\102\1\uffff\1\32\1\111\1\121\1\125\1\137\1\16\1\53\1\62\1\133\1\104"+
		"\1\uffff\1\36\1\43\1\122\1\45\1\47\1\17\1\55\1\63\1\uffff\1\105\3\uffff"+
		"\1\123\2\uffff\1\20\1\71\1\75\1\106\1\uffff\1\124\1\21\1\126\1\127\1\73"+
		"\1\uffff\1\33\1\22\2\uffff\1\107\2\uffff\1\37\1\24\2\uffff\1\140\1\51"+
		"\1\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\26\1\14\2\uffff\1\14\22\uffff\1\15\1\40\1\24\2\uffff\1\37\2\uffff"+
			"\1\16\1\17\1\34\1\35\1\41\1\36\1\3\1\13\12\31\1\2\1\42\1\11\1\33\1\uffff"+
			"\1\43\1\uffff\1\30\1\4\4\30\1\1\6\30\1\5\5\30\1\12\3\30\1\6\2\30\1\20"+
			"\1\uffff\1\21\1\uffff\1\32\1\uffff\1\7\16\27\1\10\12\27\1\22\1\44\1\23"+
			"\1\25",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\26\47\1\45\3\47\4\uffff\1"+
			"\47\1\uffff\32\47",
			"\1\61\33\uffff\1\50\6\uffff\1\52\1\uffff\1\51\16\uffff\1\56\1\uffff"+
			"\1\60\4\uffff\1\57\5\uffff\1\53\1\uffff\1\55\3\uffff\1\54",
			"\1\32\15\uffff\1\32\1\uffff\12\32\7\uffff\1\32\1\65\4\32\1\66\23\32"+
			"\4\uffff\1\32\1\uffff\2\32\1\71\10\32\1\67\1\32\1\72\1\32\1\70\1\32\1"+
			"\64\1\63\4\32\1\73\2\32",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\2\102\1\100\27\102",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\4\102\1\103\25\102",
			"\1\104",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\21\47\1\106\10\47",
			"\1\110\4\uffff\1\111",
			"",
			"\1\26\26\uffff\1\15\15\uffff\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff"+
			"\1\32\1\uffff\32\32",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\32\102",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"\1\32\15\uffff\1\32\1\uffff\12\115\7\uffff\32\32\4\uffff\1\32\1\uffff"+
			"\32\32",
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
			"",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\4\47\1\116\25\47\4\uffff\1"+
			"\47\1\uffff\32\47",
			"\1\uffff",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"\1\121",
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
			"\1\122",
			"\1\123",
			"\1\32\15\uffff\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff"+
			"\32\32",
			"\1\32\15\uffff\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff"+
			"\32\32",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\32\15\uffff\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff"+
			"\32\32",
			"\1\32\15\uffff\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff"+
			"\32\32",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\7\102\1\137\22\102",
			"\1\uffff",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\32\102",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\21\102\1\141\10\102",
			"",
			"",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\24\47\1\142\5\47",
			"\1\uffff",
			"",
			"",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\32\15\uffff\1\32\1\uffff\12\115\7\uffff\32\32\4\uffff\1\32\1\uffff"+
			"\32\32",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\15\47\1\144\14\47\4\uffff"+
			"\1\47\1\uffff\32\47",
			"",
			"",
			"\1\145",
			"\1\146",
			"\1\147",
			"\1\uffff",
			"\1\uffff",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\uffff",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\10\102\1\155\21\102",
			"",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\5\102\1\156\24\102",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\4\47\1\157\25\47",
			"",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\3\47\1\160\26\47\4\uffff\1"+
			"\47\1\uffff\32\47",
			"\1\161",
			"\1\162\17\uffff\1\163",
			"\1\164",
			"\1\165",
			"\1\166",
			"\1\167",
			"",
			"",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\4\102\1\170\25\102",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\16\102\1\171\13\102",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\16\47\1\173\13\47\4\uffff"+
			"\1\47\1\uffff\32\47",
			"\1\174",
			"\1\32\15\uffff\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff"+
			"\32\32",
			"\1\32\15\uffff\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff"+
			"\32\32",
			"\1\177",
			"\1\32\15\uffff\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff"+
			"\32\32",
			"\1\32\15\uffff\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff"+
			"\32\32",
			"\1\u0082",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\25\102\1\u0083\4\102",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\21\102\1\u0084\10\102",
			"\1\uffff",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\13\47\1\u0086\16\47\4\uffff"+
			"\1\47\1\uffff\32\47",
			"\1\u0087",
			"\1\uffff",
			"\1\uffff",
			"\1\u008a",
			"\1\uffff",
			"\1\uffff",
			"\1\u008d",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\4\102\1\u008e\25\102",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\14\102\1\u008f\15\102",
			"",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\4\47\1\u0090\25\47\4\uffff"+
			"\1\47\1\uffff\32\47",
			"\1\u0091",
			"",
			"",
			"\1\u0092",
			"",
			"",
			"\1\u0093",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\32\102",
			"\1\32\15\uffff\1\32\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\32\102",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\15\47\1\u0096\14\47\4\uffff"+
			"\1\47\1\uffff\32\47",
			"\1\u0097",
			"\1\u0098",
			"\1\u0099",
			"\1\uffff",
			"\1\uffff",
			"\1\32\15\uffff\1\32\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff"+
			"\32\47",
			"\1\u009e\4\uffff\1\u009d",
			"\1\32\15\uffff\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff"+
			"\32\32",
			"\1\u00a0",
			"",
			"",
			"\1\uffff",
			"",
			"",
			"\1\uffff",
			"\1\u00a3",
			"",
			"",
			"\1\32\15\uffff\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff"+
			"\32\32",
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
			return "1:1: Tokens : ( GWENDOLEN | GOALS | BELIEFS | BELIEFRULES | PLANS | NAME | SEND | RECEIVED | BELIEVE | GOAL | IN_CONTENT | IN_CONTEXT | SENT | LOCK | ADD_PLAN | ADD_CONSTRAINT | ADD_CONTENT | ADD_CONTEXT | TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY | BAR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA12_66 = input.LA(1);
						 
						int index12_66 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_66 >= '0' && LA12_66 <= '9')||(LA12_66 >= 'A' && LA12_66 <= 'Z')||LA12_66=='_'||(LA12_66 >= 'a' && LA12_66 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_66==' '||LA12_66=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_66);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA12_55 = input.LA(1);
						 
						int index12_55 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_55=='o') ) {s = 86;}
						else s = 26;
						 
						input.seek(index12_55);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA12_58 = input.LA(1);
						 
						int index12_58 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_58==' '||LA12_58=='.'||(LA12_58 >= '0' && LA12_58 <= '9')||(LA12_58 >= 'A' && LA12_58 <= 'Z')||LA12_58=='_'||(LA12_58 >= 'a' && LA12_58 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 89;
						 
						input.seek(index12_58);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA12_86 = input.LA(1);
						 
						int index12_86 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_86=='c') ) {s = 104;}
						else s = 26;
						 
						input.seek(index12_86);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA12_104 = input.LA(1);
						 
						int index12_104 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_104=='k') ) {s = 117;}
						else s = 26;
						 
						input.seek(index12_104);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA12_56 = input.LA(1);
						 
						int index12_56 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_56=='l') ) {s = 87;}
						else s = 26;
						 
						input.seek(index12_56);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA12_87 = input.LA(1);
						 
						int index12_87 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_87=='a') ) {s = 105;}
						else s = 26;
						 
						input.seek(index12_87);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA12_105 = input.LA(1);
						 
						int index12_105 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_105=='n') ) {s = 118;}
						else s = 26;
						 
						input.seek(index12_105);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA12_4 = input.LA(1);
						 
						int index12_4 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_4 >= '0' && LA12_4 <= '9')||(LA12_4 >= 'A' && LA12_4 <= 'Z')||LA12_4=='_'||(LA12_4 >= 'a' && LA12_4 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_4==' '||LA12_4=='.') && ((stringterm))) {s = 26;}
						else s = 61;
						 
						input.seek(index12_4);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA12_59 = input.LA(1);
						 
						int index12_59 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_59==' '||LA12_59=='.'||(LA12_59 >= '0' && LA12_59 <= '9')||(LA12_59 >= 'A' && LA12_59 <= 'Z')||LA12_59=='_'||(LA12_59 >= 'a' && LA12_59 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 90;
						 
						input.seek(index12_59);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA12_111 = input.LA(1);
						 
						int index12_111 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_111 >= '0' && LA12_111 <= '9')||(LA12_111 >= 'A' && LA12_111 <= 'Z')||LA12_111=='_'||(LA12_111 >= 'a' && LA12_111 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_111==' '||LA12_111=='.') && ((stringterm))) {s = 26;}
						else s = 122;
						 
						input.seek(index12_111);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA12_57 = input.LA(1);
						 
						int index12_57 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_57=='o') ) {s = 88;}
						else s = 26;
						 
						input.seek(index12_57);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA12_88 = input.LA(1);
						 
						int index12_88 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_88=='n') ) {s = 106;}
						else s = 26;
						 
						input.seek(index12_88);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA12_106 = input.LA(1);
						 
						int index12_106 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_106=='s') ) {s = 119;}
						else s = 26;
						 
						input.seek(index12_106);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA12_119 = input.LA(1);
						 
						int index12_119 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_119=='t') ) {s = 130;}
						else s = 26;
						 
						input.seek(index12_119);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA12_130 = input.LA(1);
						 
						int index12_130 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_130=='r') ) {s = 141;}
						else s = 26;
						 
						input.seek(index12_130);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA12_141 = input.LA(1);
						 
						int index12_141 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_141=='a') ) {s = 147;}
						else s = 26;
						 
						input.seek(index12_141);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA12_147 = input.LA(1);
						 
						int index12_147 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_147=='i') ) {s = 153;}
						else s = 26;
						 
						input.seek(index12_147);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA12_153 = input.LA(1);
						 
						int index12_153 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_153=='n') ) {s = 160;}
						else s = 26;
						 
						input.seek(index12_153);
						if ( s>=0 ) return s;
						break;

					case 19 : 
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
						else if ( (LA12_0=='_') && ((stringterm))) {s = 26;}
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

					case 20 : 
						int LA12_160 = input.LA(1);
						 
						int index12_160 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_160=='t') ) {s = 163;}
						else s = 26;
						 
						input.seek(index12_160);
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA12_10 = input.LA(1);
						 
						int index12_10 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_10=='r') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 70;}
						else if ( ((LA12_10 >= '0' && LA12_10 <= '9')||(LA12_10 >= 'A' && LA12_10 <= 'Z')||LA12_10=='_'||(LA12_10 >= 'a' && LA12_10 <= 'q')||(LA12_10 >= 's' && LA12_10 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_10==' '||LA12_10=='.') && ((stringterm))) {s = 26;}
						else s = 71;
						 
						input.seek(index12_10);
						if ( s>=0 ) return s;
						break;

					case 22 : 
						int LA12_39 = input.LA(1);
						 
						int index12_39 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_39 >= '0' && LA12_39 <= '9')||(LA12_39 >= 'A' && LA12_39 <= 'Z')||LA12_39=='_'||(LA12_39 >= 'a' && LA12_39 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_39==' '||LA12_39=='.') && ((stringterm))) {s = 26;}
						else s = 71;
						 
						input.seek(index12_39);
						if ( s>=0 ) return s;
						break;

					case 23 : 
						int LA12_23 = input.LA(1);
						 
						int index12_23 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_23 >= '0' && LA12_23 <= '9')||(LA12_23 >= 'A' && LA12_23 <= 'Z')||LA12_23=='_'||(LA12_23 >= 'a' && LA12_23 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_23==' '||LA12_23=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_23);
						if ( s>=0 ) return s;
						break;

					case 24 : 
						int LA12_5 = input.LA(1);
						 
						int index12_5 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_5 >= '0' && LA12_5 <= '9')||(LA12_5 >= 'A' && LA12_5 <= 'Z')||LA12_5=='_'||(LA12_5 >= 'a' && LA12_5 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_5==' '||LA12_5=='.') && ((stringterm))) {s = 26;}
						else s = 62;
						 
						input.seek(index12_5);
						if ( s>=0 ) return s;
						break;

					case 25 : 
						int LA12_6 = input.LA(1);
						 
						int index12_6 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_6 >= '0' && LA12_6 <= '9')||(LA12_6 >= 'A' && LA12_6 <= 'Z')||LA12_6=='_'||(LA12_6 >= 'a' && LA12_6 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_6==' '||LA12_6=='.') && ((stringterm))) {s = 26;}
						else s = 63;
						 
						input.seek(index12_6);
						if ( s>=0 ) return s;
						break;

					case 26 : 
						int LA12_114 = input.LA(1);
						 
						int index12_114 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_114==' '||LA12_114=='.'||(LA12_114 >= '0' && LA12_114 <= '9')||(LA12_114 >= 'A' && LA12_114 <= 'Z')||LA12_114=='_'||(LA12_114 >= 'a' && LA12_114 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 125;
						 
						input.seek(index12_114);
						if ( s>=0 ) return s;
						break;

					case 27 : 
						int LA12_152 = input.LA(1);
						 
						int index12_152 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_152==' '||LA12_152=='.'||(LA12_152 >= '0' && LA12_152 <= '9')||(LA12_152 >= 'A' && LA12_152 <= 'Z')||LA12_152=='_'||(LA12_152 >= 'a' && LA12_152 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 159;
						 
						input.seek(index12_152);
						if ( s>=0 ) return s;
						break;

					case 28 : 
						int LA12_77 = input.LA(1);
						 
						int index12_77 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_77 >= '0' && LA12_77 <= '9')) && (((stringterm)||(!stringterm)))) {s = 77;}
						else if ( (LA12_77==' '||LA12_77=='.'||(LA12_77 >= 'A' && LA12_77 <= 'Z')||LA12_77=='_'||(LA12_77 >= 'a' && LA12_77 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 76;
						 
						input.seek(index12_77);
						if ( s>=0 ) return s;
						break;

					case 29 : 
						int LA12_53 = input.LA(1);
						 
						int index12_53 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_53==' '||LA12_53=='.'||(LA12_53 >= '0' && LA12_53 <= '9')||(LA12_53 >= 'A' && LA12_53 <= 'Z')||LA12_53=='_'||(LA12_53 >= 'a' && LA12_53 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 84;
						 
						input.seek(index12_53);
						if ( s>=0 ) return s;
						break;

					case 30 : 
						int LA12_125 = input.LA(1);
						 
						int index12_125 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 136;}
						else if ( ((stringterm)) ) {s = 26;}
						 
						input.seek(index12_125);
						if ( s>=0 ) return s;
						break;

					case 31 : 
						int LA12_159 = input.LA(1);
						 
						int index12_159 = input.index();
						input.rewind();
						s = -1;
						if ( ((gwendolen)) ) {s = 162;}
						else if ( ((stringterm)) ) {s = 26;}
						 
						input.seek(index12_159);
						if ( s>=0 ) return s;
						break;

					case 32 : 
						int LA12_84 = input.LA(1);
						 
						int index12_84 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 92;}
						else if ( ((stringterm)) ) {s = 26;}
						 
						input.seek(index12_84);
						if ( s>=0 ) return s;
						break;

					case 33 : 
						int LA12_85 = input.LA(1);
						 
						int index12_85 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 79;}
						else if ( ((stringterm)) ) {s = 26;}
						 
						input.seek(index12_85);
						if ( s>=0 ) return s;
						break;

					case 34 : 
						int LA12_13 = input.LA(1);
						 
						int index12_13 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_13==' ') && (((stringterm)||(!stringterm)))) {s = 13;}
						else if ( (LA12_13=='\t') && ((!stringterm))) {s = 22;}
						else if ( (LA12_13=='.'||(LA12_13 >= '0' && LA12_13 <= '9')||(LA12_13 >= 'A' && LA12_13 <= 'Z')||LA12_13=='_'||(LA12_13 >= 'a' && LA12_13 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 75;
						 
						input.seek(index12_13);
						if ( s>=0 ) return s;
						break;

					case 35 : 
						int LA12_126 = input.LA(1);
						 
						int index12_126 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 137;}
						else if ( ((stringterm)) ) {s = 26;}
						 
						input.seek(index12_126);
						if ( s>=0 ) return s;
						break;

					case 36 : 
						int LA12_64 = input.LA(1);
						 
						int index12_64 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_64=='h') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 95;}
						else if ( ((LA12_64 >= '0' && LA12_64 <= '9')||(LA12_64 >= 'A' && LA12_64 <= 'Z')||LA12_64=='_'||(LA12_64 >= 'a' && LA12_64 <= 'g')||(LA12_64 >= 'i' && LA12_64 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_64==' '||LA12_64=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_64);
						if ( s>=0 ) return s;
						break;

					case 37 : 
						int LA12_128 = input.LA(1);
						 
						int index12_128 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 139;}
						else if ( ((stringterm)) ) {s = 26;}
						 
						input.seek(index12_128);
						if ( s>=0 ) return s;
						break;

					case 38 : 
						int LA12_95 = input.LA(1);
						 
						int index12_95 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_95=='i') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 109;}
						else if ( ((LA12_95 >= '0' && LA12_95 <= '9')||(LA12_95 >= 'A' && LA12_95 <= 'Z')||LA12_95=='_'||(LA12_95 >= 'a' && LA12_95 <= 'h')||(LA12_95 >= 'j' && LA12_95 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_95==' '||LA12_95=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_95);
						if ( s>=0 ) return s;
						break;

					case 39 : 
						int LA12_129 = input.LA(1);
						 
						int index12_129 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 140;}
						else if ( ((stringterm)) ) {s = 26;}
						 
						input.seek(index12_129);
						if ( s>=0 ) return s;
						break;

					case 40 : 
						int LA12_109 = input.LA(1);
						 
						int index12_109 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_109=='e') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 120;}
						else if ( ((LA12_109 >= '0' && LA12_109 <= '9')||(LA12_109 >= 'A' && LA12_109 <= 'Z')||LA12_109=='_'||(LA12_109 >= 'a' && LA12_109 <= 'd')||(LA12_109 >= 'f' && LA12_109 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_109==' '||LA12_109=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_109);
						if ( s>=0 ) return s;
						break;

					case 41 : 
						int LA12_164 = input.LA(1);
						 
						int index12_164 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 165;}
						else if ( ((stringterm)) ) {s = 26;}
						 
						input.seek(index12_164);
						if ( s>=0 ) return s;
						break;

					case 42 : 
						int LA12_89 = input.LA(1);
						 
						int index12_89 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 107;}
						else if ( ((stringterm)) ) {s = 26;}
						 
						input.seek(index12_89);
						if ( s>=0 ) return s;
						break;

					case 43 : 
						int LA12_120 = input.LA(1);
						 
						int index12_120 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_120=='v') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 131;}
						else if ( ((LA12_120 >= '0' && LA12_120 <= '9')||(LA12_120 >= 'A' && LA12_120 <= 'Z')||LA12_120=='_'||(LA12_120 >= 'a' && LA12_120 <= 'u')||(LA12_120 >= 'w' && LA12_120 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_120==' '||LA12_120=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_120);
						if ( s>=0 ) return s;
						break;

					case 44 : 
						int LA12_90 = input.LA(1);
						 
						int index12_90 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 108;}
						else if ( ((stringterm)) ) {s = 26;}
						 
						input.seek(index12_90);
						if ( s>=0 ) return s;
						break;

					case 45 : 
						int LA12_131 = input.LA(1);
						 
						int index12_131 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_131=='e') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 142;}
						else if ( ((LA12_131 >= '0' && LA12_131 <= '9')||(LA12_131 >= 'A' && LA12_131 <= 'Z')||LA12_131=='_'||(LA12_131 >= 'a' && LA12_131 <= 'd')||(LA12_131 >= 'f' && LA12_131 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_131==' '||LA12_131=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_131);
						if ( s>=0 ) return s;
						break;

					case 46 : 
						int LA12_67 = input.LA(1);
						 
						int index12_67 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_67=='r') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 97;}
						else if ( ((LA12_67 >= '0' && LA12_67 <= '9')||(LA12_67 >= 'A' && LA12_67 <= 'Z')||LA12_67=='_'||(LA12_67 >= 'a' && LA12_67 <= 'q')||(LA12_67 >= 's' && LA12_67 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_67==' '||LA12_67=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_67);
						if ( s>=0 ) return s;
						break;

					case 47 : 
						int LA12_24 = input.LA(1);
						 
						int index12_24 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_24 >= '0' && LA12_24 <= '9')||(LA12_24 >= 'A' && LA12_24 <= 'Z')||LA12_24=='_'||(LA12_24 >= 'a' && LA12_24 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_24==' '||LA12_24=='.') && ((stringterm))) {s = 26;}
						else s = 71;
						 
						input.seek(index12_24);
						if ( s>=0 ) return s;
						break;

					case 48 : 
						int LA12_97 = input.LA(1);
						 
						int index12_97 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_97=='f') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 110;}
						else if ( ((LA12_97 >= '0' && LA12_97 <= '9')||(LA12_97 >= 'A' && LA12_97 <= 'Z')||LA12_97=='_'||(LA12_97 >= 'a' && LA12_97 <= 'e')||(LA12_97 >= 'g' && LA12_97 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_97==' '||LA12_97=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_97);
						if ( s>=0 ) return s;
						break;

					case 49 : 
						int LA12_110 = input.LA(1);
						 
						int index12_110 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_110=='o') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 121;}
						else if ( ((LA12_110 >= '0' && LA12_110 <= '9')||(LA12_110 >= 'A' && LA12_110 <= 'Z')||LA12_110=='_'||(LA12_110 >= 'a' && LA12_110 <= 'n')||(LA12_110 >= 'p' && LA12_110 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_110==' '||LA12_110=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_110);
						if ( s>=0 ) return s;
						break;

					case 50 : 
						int LA12_121 = input.LA(1);
						 
						int index12_121 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_121=='r') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 132;}
						else if ( ((LA12_121 >= '0' && LA12_121 <= '9')||(LA12_121 >= 'A' && LA12_121 <= 'Z')||LA12_121=='_'||(LA12_121 >= 'a' && LA12_121 <= 'q')||(LA12_121 >= 's' && LA12_121 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_121==' '||LA12_121=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_121);
						if ( s>=0 ) return s;
						break;

					case 51 : 
						int LA12_132 = input.LA(1);
						 
						int index12_132 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_132=='m') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 143;}
						else if ( ((LA12_132 >= '0' && LA12_132 <= '9')||(LA12_132 >= 'A' && LA12_132 <= 'Z')||LA12_132=='_'||(LA12_132 >= 'a' && LA12_132 <= 'l')||(LA12_132 >= 'n' && LA12_132 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_132==' '||LA12_132=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_132);
						if ( s>=0 ) return s;
						break;

					case 52 : 
						int LA12_75 = input.LA(1);
						 
						int index12_75 = input.index();
						input.rewind();
						s = -1;
						if ( ((!stringterm)) ) {s = 22;}
						else if ( ((stringterm)) ) {s = 26;}
						 
						input.seek(index12_75);
						if ( s>=0 ) return s;
						break;

					case 53 : 
						int LA12_54 = input.LA(1);
						 
						int index12_54 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_54==' '||LA12_54=='.'||(LA12_54 >= '0' && LA12_54 <= '9')||(LA12_54 >= 'A' && LA12_54 <= 'Z')||LA12_54=='_'||(LA12_54 >= 'a' && LA12_54 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 85;
						 
						input.seek(index12_54);
						if ( s>=0 ) return s;
						break;

					case 54 : 
						int LA12_65 = input.LA(1);
						 
						int index12_65 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 26;}
						else if ( ((!stringterm)) ) {s = 96;}
						 
						input.seek(index12_65);
						if ( s>=0 ) return s;
						break;

					case 55 : 
						int LA12_71 = input.LA(1);
						 
						int index12_71 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 26;}
						else if ( ((!stringterm)) ) {s = 80;}
						 
						input.seek(index12_71);
						if ( s>=0 ) return s;
						break;

					case 56 : 
						int LA12_76 = input.LA(1);
						 
						int index12_76 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 26;}
						else if ( ((!stringterm)) ) {s = 99;}
						 
						input.seek(index12_76);
						if ( s>=0 ) return s;
						break;

					case 57 : 
						int LA12_142 = input.LA(1);
						 
						int index12_142 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_142 >= '0' && LA12_142 <= '9')||(LA12_142 >= 'A' && LA12_142 <= 'Z')||LA12_142=='_'||(LA12_142 >= 'a' && LA12_142 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_142==' '||LA12_142=='.') && ((stringterm))) {s = 26;}
						else s = 148;
						 
						input.seek(index12_142);
						if ( s>=0 ) return s;
						break;

					case 58 : 
						int LA12_60 = input.LA(1);
						 
						int index12_60 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 26;}
						else if ( ((!stringterm)) ) {s = 91;}
						 
						input.seek(index12_60);
						if ( s>=0 ) return s;
						break;

					case 59 : 
						int LA12_150 = input.LA(1);
						 
						int index12_150 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_150 >= '0' && LA12_150 <= '9')||(LA12_150 >= 'A' && LA12_150 <= 'Z')||LA12_150=='_'||(LA12_150 >= 'a' && LA12_150 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_150==' '||LA12_150=='.') && ((stringterm))) {s = 26;}
						else s = 156;
						 
						input.seek(index12_150);
						if ( s>=0 ) return s;
						break;

					case 60 : 
						int LA12_1 = input.LA(1);
						 
						int index12_1 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_1=='W') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 37;}
						else if ( ((LA12_1 >= '0' && LA12_1 <= '9')||(LA12_1 >= 'A' && LA12_1 <= 'V')||(LA12_1 >= 'X' && LA12_1 <= 'Z')||LA12_1=='_'||(LA12_1 >= 'a' && LA12_1 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_1==' '||LA12_1=='.') && ((stringterm))) {s = 26;}
						else s = 38;
						 
						input.seek(index12_1);
						if ( s>=0 ) return s;
						break;

					case 61 : 
						int LA12_143 = input.LA(1);
						 
						int index12_143 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_143 >= '0' && LA12_143 <= '9')||(LA12_143 >= 'A' && LA12_143 <= 'Z')||LA12_143=='_'||(LA12_143 >= 'a' && LA12_143 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_143==' '||LA12_143=='.') && ((stringterm))) {s = 26;}
						else s = 149;
						 
						input.seek(index12_143);
						if ( s>=0 ) return s;
						break;

					case 62 : 
						int LA12_37 = input.LA(1);
						 
						int index12_37 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_37=='E') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 78;}
						else if ( ((LA12_37 >= '0' && LA12_37 <= '9')||(LA12_37 >= 'A' && LA12_37 <= 'D')||(LA12_37 >= 'F' && LA12_37 <= 'Z')||LA12_37=='_'||(LA12_37 >= 'a' && LA12_37 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_37==' '||LA12_37=='.') && ((stringterm))) {s = 26;}
						else s = 71;
						 
						input.seek(index12_37);
						if ( s>=0 ) return s;
						break;

					case 63 : 
						int LA12_7 = input.LA(1);
						 
						int index12_7 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_7=='c') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 64;}
						else if ( ((LA12_7 >= '0' && LA12_7 <= '9')||(LA12_7 >= 'A' && LA12_7 <= 'Z')||LA12_7=='_'||(LA12_7 >= 'a' && LA12_7 <= 'b')||(LA12_7 >= 'd' && LA12_7 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_7==' '||LA12_7=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_7);
						if ( s>=0 ) return s;
						break;

					case 64 : 
						int LA12_78 = input.LA(1);
						 
						int index12_78 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_78=='N') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 100;}
						else if ( ((LA12_78 >= '0' && LA12_78 <= '9')||(LA12_78 >= 'A' && LA12_78 <= 'M')||(LA12_78 >= 'O' && LA12_78 <= 'Z')||LA12_78=='_'||(LA12_78 >= 'a' && LA12_78 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_78==' '||LA12_78=='.') && ((stringterm))) {s = 26;}
						else s = 71;
						 
						input.seek(index12_78);
						if ( s>=0 ) return s;
						break;

					case 65 : 
						int LA12_100 = input.LA(1);
						 
						int index12_100 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_100=='D') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 112;}
						else if ( ((LA12_100 >= '0' && LA12_100 <= '9')||(LA12_100 >= 'A' && LA12_100 <= 'C')||(LA12_100 >= 'E' && LA12_100 <= 'Z')||LA12_100=='_'||(LA12_100 >= 'a' && LA12_100 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_100==' '||LA12_100=='.') && ((stringterm))) {s = 26;}
						else s = 71;
						 
						input.seek(index12_100);
						if ( s>=0 ) return s;
						break;

					case 66 : 
						int LA12_112 = input.LA(1);
						 
						int index12_112 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_112=='O') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 123;}
						else if ( ((LA12_112 >= '0' && LA12_112 <= '9')||(LA12_112 >= 'A' && LA12_112 <= 'N')||(LA12_112 >= 'P' && LA12_112 <= 'Z')||LA12_112=='_'||(LA12_112 >= 'a' && LA12_112 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_112==' '||LA12_112=='.') && ((stringterm))) {s = 26;}
						else s = 71;
						 
						input.seek(index12_112);
						if ( s>=0 ) return s;
						break;

					case 67 : 
						int LA12_3 = input.LA(1);
						 
						int index12_3 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_3=='s') ) {s = 51;}
						else if ( (LA12_3=='r') && (((gwendolen)||(stringterm)))) {s = 52;}
						else if ( (LA12_3=='B') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)))) {s = 53;}
						else if ( (LA12_3=='G') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)))) {s = 54;}
						else if ( (LA12_3=='l') ) {s = 55;}
						else if ( (LA12_3=='p') ) {s = 56;}
						else if ( (LA12_3=='c') ) {s = 57;}
						else if ( (LA12_3=='n') ) {s = 58;}
						else if ( (LA12_3=='x') ) {s = 59;}
						else if ( (LA12_3==' '||LA12_3=='.'||(LA12_3 >= '0' && LA12_3 <= '9')||LA12_3=='A'||(LA12_3 >= 'C' && LA12_3 <= 'F')||(LA12_3 >= 'H' && LA12_3 <= 'Z')||LA12_3=='_'||(LA12_3 >= 'a' && LA12_3 <= 'b')||(LA12_3 >= 'd' && LA12_3 <= 'k')||LA12_3=='m'||LA12_3=='o'||LA12_3=='q'||(LA12_3 >= 't' && LA12_3 <= 'w')||(LA12_3 >= 'y' && LA12_3 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 60;
						 
						input.seek(index12_3);
						if ( s>=0 ) return s;
						break;

					case 68 : 
						int LA12_123 = input.LA(1);
						 
						int index12_123 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_123=='L') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 134;}
						else if ( ((LA12_123 >= '0' && LA12_123 <= '9')||(LA12_123 >= 'A' && LA12_123 <= 'K')||(LA12_123 >= 'M' && LA12_123 <= 'Z')||LA12_123=='_'||(LA12_123 >= 'a' && LA12_123 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_123==' '||LA12_123=='.') && ((stringterm))) {s = 26;}
						else s = 71;
						 
						input.seek(index12_123);
						if ( s>=0 ) return s;
						break;

					case 69 : 
						int LA12_134 = input.LA(1);
						 
						int index12_134 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_134=='E') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 144;}
						else if ( ((LA12_134 >= '0' && LA12_134 <= '9')||(LA12_134 >= 'A' && LA12_134 <= 'D')||(LA12_134 >= 'F' && LA12_134 <= 'Z')||LA12_134=='_'||(LA12_134 >= 'a' && LA12_134 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_134==' '||LA12_134=='.') && ((stringterm))) {s = 26;}
						else s = 71;
						 
						input.seek(index12_134);
						if ( s>=0 ) return s;
						break;

					case 70 : 
						int LA12_144 = input.LA(1);
						 
						int index12_144 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_144=='N') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 150;}
						else if ( ((LA12_144 >= '0' && LA12_144 <= '9')||(LA12_144 >= 'A' && LA12_144 <= 'M')||(LA12_144 >= 'O' && LA12_144 <= 'Z')||LA12_144=='_'||(LA12_144 >= 'a' && LA12_144 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_144==' '||LA12_144=='.') && ((stringterm))) {s = 26;}
						else s = 71;
						 
						input.seek(index12_144);
						if ( s>=0 ) return s;
						break;

					case 71 : 
						int LA12_156 = input.LA(1);
						 
						int index12_156 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting == 0)) ) {s = 161;}
						else if ( ((stringterm)) ) {s = 26;}
						else if ( ((!stringterm)) ) {s = 80;}
						 
						input.seek(index12_156);
						if ( s>=0 ) return s;
						break;

					case 72 : 
						int LA12_8 = input.LA(1);
						 
						int index12_8 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_8=='e') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 67;}
						else if ( ((LA12_8 >= '0' && LA12_8 <= '9')||(LA12_8 >= 'A' && LA12_8 <= 'Z')||LA12_8=='_'||(LA12_8 >= 'a' && LA12_8 <= 'd')||(LA12_8 >= 'f' && LA12_8 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_8==' '||LA12_8=='.') && ((stringterm))) {s = 26;}
						else s = 65;
						 
						input.seek(index12_8);
						if ( s>=0 ) return s;
						break;

					case 73 : 
						int LA12_115 = input.LA(1);
						 
						int index12_115 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_115==' '||LA12_115=='.'||(LA12_115 >= '0' && LA12_115 <= '9')||(LA12_115 >= 'A' && LA12_115 <= 'Z')||LA12_115=='_'||(LA12_115 >= 'a' && LA12_115 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 126;
						 
						input.seek(index12_115);
						if ( s>=0 ) return s;
						break;

					case 74 : 
						int LA12_61 = input.LA(1);
						 
						int index12_61 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 92;}
						else if ( ((stringterm)) ) {s = 26;}
						else if ( ((!stringterm)) ) {s = 80;}
						 
						input.seek(index12_61);
						if ( s>=0 ) return s;
						break;

					case 75 : 
						int LA12_38 = input.LA(1);
						 
						int index12_38 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 79;}
						else if ( ((stringterm)) ) {s = 26;}
						else if ( ((!stringterm)) ) {s = 80;}
						 
						input.seek(index12_38);
						if ( s>=0 ) return s;
						break;

					case 76 : 
						int LA12_62 = input.LA(1);
						 
						int index12_62 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 93;}
						else if ( ((stringterm)) ) {s = 26;}
						else if ( ((!stringterm)) ) {s = 80;}
						 
						input.seek(index12_62);
						if ( s>=0 ) return s;
						break;

					case 77 : 
						int LA12_63 = input.LA(1);
						 
						int index12_63 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 94;}
						else if ( ((stringterm)) ) {s = 26;}
						else if ( ((!stringterm)) ) {s = 80;}
						 
						input.seek(index12_63);
						if ( s>=0 ) return s;
						break;

					case 78 : 
						int LA12_52 = input.LA(1);
						 
						int index12_52 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_52=='e') && (((gwendolen)||(stringterm)))) {s = 83;}
						else s = 26;
						 
						input.seek(index12_52);
						if ( s>=0 ) return s;
						break;

					case 79 : 
						int LA12_83 = input.LA(1);
						 
						int index12_83 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_83=='c') && (((gwendolen)||(stringterm)))) {s = 103;}
						else s = 26;
						 
						input.seek(index12_83);
						if ( s>=0 ) return s;
						break;

					case 80 : 
						int LA12_103 = input.LA(1);
						 
						int index12_103 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_103=='e') && (((gwendolen)||(stringterm)))) {s = 116;}
						else s = 26;
						 
						input.seek(index12_103);
						if ( s>=0 ) return s;
						break;

					case 81 : 
						int LA12_116 = input.LA(1);
						 
						int index12_116 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_116=='i') && (((gwendolen)||(stringterm)))) {s = 127;}
						else s = 26;
						 
						input.seek(index12_116);
						if ( s>=0 ) return s;
						break;

					case 82 : 
						int LA12_127 = input.LA(1);
						 
						int index12_127 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_127=='v') && (((gwendolen)||(stringterm)))) {s = 138;}
						else s = 26;
						 
						input.seek(index12_127);
						if ( s>=0 ) return s;
						break;

					case 83 : 
						int LA12_138 = input.LA(1);
						 
						int index12_138 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_138=='e') && (((gwendolen)||(stringterm)))) {s = 146;}
						else s = 26;
						 
						input.seek(index12_138);
						if ( s>=0 ) return s;
						break;

					case 84 : 
						int LA12_146 = input.LA(1);
						 
						int index12_146 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_146=='d') && (((gwendolen)||(stringterm)))) {s = 152;}
						else s = 26;
						 
						input.seek(index12_146);
						if ( s>=0 ) return s;
						break;

					case 85 : 
						int LA12_117 = input.LA(1);
						 
						int index12_117 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_117==' '||LA12_117=='.'||(LA12_117 >= '0' && LA12_117 <= '9')||(LA12_117 >= 'A' && LA12_117 <= 'Z')||LA12_117=='_'||(LA12_117 >= 'a' && LA12_117 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 128;
						 
						input.seek(index12_117);
						if ( s>=0 ) return s;
						break;

					case 86 : 
						int LA12_148 = input.LA(1);
						 
						int index12_148 = input.index();
						input.rewind();
						s = -1;
						if ( ((sq_nesting > 0)) ) {s = 154;}
						else if ( ((stringterm)) ) {s = 26;}
						else if ( ((!stringterm)) ) {s = 96;}
						 
						input.seek(index12_148);
						if ( s>=0 ) return s;
						break;

					case 87 : 
						int LA12_149 = input.LA(1);
						 
						int index12_149 = input.index();
						input.rewind();
						s = -1;
						if ( ((sq_nesting > 0)) ) {s = 155;}
						else if ( ((stringterm)) ) {s = 26;}
						else if ( ((!stringterm)) ) {s = 96;}
						 
						input.seek(index12_149);
						if ( s>=0 ) return s;
						break;

					case 88 : 
						int LA12_70 = input.LA(1);
						 
						int index12_70 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_70=='u') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 98;}
						else if ( ((LA12_70 >= '0' && LA12_70 <= '9')||(LA12_70 >= 'A' && LA12_70 <= 'Z')||LA12_70=='_'||(LA12_70 >= 'a' && LA12_70 <= 't')||(LA12_70 >= 'v' && LA12_70 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_70==' '||LA12_70=='.') && ((stringterm))) {s = 26;}
						else s = 71;
						 
						input.seek(index12_70);
						if ( s>=0 ) return s;
						break;

					case 89 : 
						int LA12_51 = input.LA(1);
						 
						int index12_51 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_51=='e') ) {s = 82;}
						else s = 26;
						 
						input.seek(index12_51);
						if ( s>=0 ) return s;
						break;

					case 90 : 
						int LA12_98 = input.LA(1);
						 
						int index12_98 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_98=='e') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 111;}
						else if ( ((LA12_98 >= '0' && LA12_98 <= '9')||(LA12_98 >= 'A' && LA12_98 <= 'Z')||LA12_98=='_'||(LA12_98 >= 'a' && LA12_98 <= 'd')||(LA12_98 >= 'f' && LA12_98 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 39;}
						else if ( (LA12_98==' '||LA12_98=='.') && ((stringterm))) {s = 26;}
						else s = 71;
						 
						input.seek(index12_98);
						if ( s>=0 ) return s;
						break;

					case 91 : 
						int LA12_122 = input.LA(1);
						 
						int index12_122 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 133;}
						else if ( ((stringterm)) ) {s = 26;}
						else if ( ((!stringterm)) ) {s = 80;}
						 
						input.seek(index12_122);
						if ( s>=0 ) return s;
						break;

					case 92 : 
						int LA12_25 = input.LA(1);
						 
						int index12_25 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_25 >= '0' && LA12_25 <= '9')) && (((stringterm)||(!stringterm)))) {s = 77;}
						else if ( (LA12_25==' '||LA12_25=='.'||(LA12_25 >= 'A' && LA12_25 <= 'Z')||LA12_25=='_'||(LA12_25 >= 'a' && LA12_25 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 76;
						 
						input.seek(index12_25);
						if ( s>=0 ) return s;
						break;

					case 93 : 
						int LA12_82 = input.LA(1);
						 
						int index12_82 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_82=='n') ) {s = 102;}
						else s = 26;
						 
						input.seek(index12_82);
						if ( s>=0 ) return s;
						break;

					case 94 : 
						int LA12_102 = input.LA(1);
						 
						int index12_102 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_102=='d') ) {s = 114;}
						else if ( (LA12_102=='t') && (((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)||(stringterm)))) {s = 115;}
						else s = 26;
						 
						input.seek(index12_102);
						if ( s>=0 ) return s;
						break;

					case 95 : 
						int LA12_118 = input.LA(1);
						 
						int index12_118 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_118==' '||LA12_118=='.'||(LA12_118 >= '0' && LA12_118 <= '9')||(LA12_118 >= 'A' && LA12_118 <= 'Z')||LA12_118=='_'||(LA12_118 >= 'a' && LA12_118 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 129;
						 
						input.seek(index12_118);
						if ( s>=0 ) return s;
						break;

					case 96 : 
						int LA12_163 = input.LA(1);
						 
						int index12_163 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_163==' '||LA12_163=='.'||(LA12_163 >= '0' && LA12_163 <= '9')||(LA12_163 >= 'A' && LA12_163 <= 'Z')||LA12_163=='_'||(LA12_163 >= 'a' && LA12_163 <= 'z')) && ((stringterm))) {s = 26;}
						else s = 164;
						 
						input.seek(index12_163);
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
