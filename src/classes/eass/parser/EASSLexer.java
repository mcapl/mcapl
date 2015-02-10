// $ANTLR 3.5.1 /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g 2015-02-10 13:02:13

package eass.parser;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class EASSLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ABSTRACTION=4;
	public static final int ACHIEVE=5;
	public static final int ACHIEVEGOAL=6;
	public static final int ARROW=7;
	public static final int BELIEFRULES=8;
	public static final int BELIEFS=9;
	public static final int BELIEVE=10;
	public static final int BRULEARROW=11;
	public static final int CALCULATE=12;
	public static final int CAPABILITIES=13;
	public static final int CAPABILITY=14;
	public static final int CLOSE=15;
	public static final int COLON=16;
	public static final int COMMA=17;
	public static final int COMMENT=18;
	public static final int CONST=19;
	public static final int CURLYCLOSE=20;
	public static final int CURLYOPEN=21;
	public static final int DIV=22;
	public static final int DOUBLEQUOTE=23;
	public static final int EASS=24;
	public static final int EQ=25;
	public static final int EQ_ASSGN=26;
	public static final int GOAL=27;
	public static final int GOALS=28;
	public static final int IMPLICATION=29;
	public static final int LESS=30;
	public static final int LINE_COMMENT=31;
	public static final int LOCK=32;
	public static final int MINUS=33;
	public static final int MOD=34;
	public static final int MULT=35;
	public static final int NAME=36;
	public static final int NEWLINE=37;
	public static final int NOT=38;
	public static final int NUMBER=39;
	public static final int OPEN=40;
	public static final int PERFORM=41;
	public static final int PERFORMGOAL=42;
	public static final int PLAN=43;
	public static final int PLANS=44;
	public static final int PLUS=45;
	public static final int POINT=46;
	public static final int QUERY=47;
	public static final int QUERYCOM=48;
	public static final int RECEIVED=49;
	public static final int RULEARROW=50;
	public static final int SEMI=51;
	public static final int SEND=52;
	public static final int SENT=53;
	public static final int SHRIEK=54;
	public static final int SQCLOSE=55;
	public static final int SQOPEN=56;
	public static final int STRING=57;
	public static final int SUBSTITUTE=58;
	public static final int TELL=59;
	public static final int TRUE=60;
	public static final int UPDATE=61;
	public static final int VAR=62;
	public static final int WAIT=63;
	public static final int WS=64;

	    public int plain_nesting = 0;
	    public int sq_nesting = 0;
	    public int curly_nesting = 0;
	    public boolean stringterm = false;
	    public int belief_rules = 0;


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public EASSLexer() {} 
	public EASSLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public EASSLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g"; }

	// $ANTLR start "UPDATE"
	public final void mUPDATE() throws RecognitionException {
		try {
			int _type = UPDATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:182:9: ( '>' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:182:11: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPDATE"

	// $ANTLR start "TELL"
	public final void mTELL() throws RecognitionException {
		try {
			int _type = TELL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:183:6: ( ':tell' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:183:8: ':tell'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:184:9: ( ':perform' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:184:11: ':perform'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:185:9: ( ':achieve' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:185:11: ':achieve'
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

	// $ANTLR start "SEND"
	public final void mSEND() throws RecognitionException {
		try {
			int _type = SEND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:186:6: ( '.send' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:186:8: '.send'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:187:9: ( '.received' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:187:11: '.received'
			{
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

	// $ANTLR start "CALCULATE"
	public final void mCALCULATE() throws RecognitionException {
		try {
			int _type = CALCULATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:2: ( '.calculate' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:4: '.calculate'
			{
			match(".calculate"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CALCULATE"

	// $ANTLR start "QUERYCOM"
	public final void mQUERYCOM() throws RecognitionException {
		try {
			int _type = QUERYCOM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:190:10: ( '.query' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:190:12: '.query'
			{
			match(".query"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUERYCOM"

	// $ANTLR start "WAIT"
	public final void mWAIT() throws RecognitionException {
		try {
			int _type = WAIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:191:6: ( '.wait' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:191:8: '.wait'
			{
			match(".wait"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WAIT"

	// $ANTLR start "CAPABILITY"
	public final void mCAPABILITY() throws RecognitionException {
		try {
			int _type = CAPABILITY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:192:12: ( '.cap' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:192:14: '.cap'
			{
			match(".cap"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CAPABILITY"

	// $ANTLR start "PLAN"
	public final void mPLAN() throws RecognitionException {
		try {
			int _type = PLAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:193:6: ( '.plan' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:193:8: '.plan'
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
	// $ANTLR end "PLAN"

	// $ANTLR start "IMPLICATION"
	public final void mIMPLICATION() throws RecognitionException {
		try {
			int _type = IMPLICATION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:194:13: ( '.imp' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:194:15: '.imp'
			{
			match(".imp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMPLICATION"

	// $ANTLR start "SUBSTITUTE"
	public final void mSUBSTITUTE() throws RecognitionException {
		try {
			int _type = SUBSTITUTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:2: ( '.substitute' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:4: '.substitute'
			{
			match(".substitute"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUBSTITUTE"

	// $ANTLR start "BELIEVE"
	public final void mBELIEVE() throws RecognitionException {
		try {
			int _type = BELIEVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:9: ({...}? => ( 'B' | '.B' ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:11: {...}? => ( 'B' | '.B' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {
				throw new FailedPredicateException(input, "BELIEVE", "curly_nesting > 0 && plain_nesting == 0 || belief_rules==1");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:75: ( 'B' | '.B' )
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
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:76: 'B'
					{
					match('B'); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:82: '.B'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:198:6: ({...}? => ( 'G' | '.G' ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:198:8: {...}? => ( 'G' | '.G' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {
				throw new FailedPredicateException(input, "GOAL", "curly_nesting > 0 && plain_nesting == 0|| belief_rules==1");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:198:71: ( 'G' | '.G' )
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
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:198:72: 'G'
					{
					match('G'); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:198:78: '.G'
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

	// $ANTLR start "SENT"
	public final void mSENT() throws RecognitionException {
		try {
			int _type = SENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:199:6: ({...}? => '.sent' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:199:8: {...}? => '.sent'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:200:6: ( '.lock' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:200:8: '.lock'
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

	// $ANTLR start "GOALS"
	public final void mGOALS() throws RecognitionException {
		try {
			int _type = GOALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:201:7: ( ':Initial Goals:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:201:9: ':Initial Goals:'
			{
			match(":Initial Goals:"); 

			belief_rules=0;
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:202:9: ( ':Initial Beliefs:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:202:11: ':Initial Beliefs:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:204:2: ( ':Reasoning Rules:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:204:4: ':Reasoning Rules:'
			{
			match(":Reasoning Rules:"); 

			belief_rules=1;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BELIEFRULES"

	// $ANTLR start "CAPABILITIES"
	public final void mCAPABILITIES() throws RecognitionException {
		try {
			int _type = CAPABILITIES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:205:13: ( ':Capabilities:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:205:15: ':Capabilities:'
			{
			match(":Capabilities:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CAPABILITIES"

	// $ANTLR start "PLANS"
	public final void mPLANS() throws RecognitionException {
		try {
			int _type = PLANS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:206:7: ( ':Plans:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:206:9: ':Plans:'
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

	// $ANTLR start "EASS"
	public final void mEASS() throws RecognitionException {
		try {
			int _type = EASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:207:6: ({...}? => 'EASS' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:207:8: {...}? => 'EASS'
			{
			if ( !((curly_nesting == 0)) ) {
				throw new FailedPredicateException(input, "EASS", "curly_nesting == 0");
			}
			match("EASS"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EASS"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:208:6: ( ':name:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:208:8: ':name:'
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

	// $ANTLR start "ABSTRACTION"
	public final void mABSTRACTION() throws RecognitionException {
		try {
			int _type = ABSTRACTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:210:2: ( ':abstraction:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:210:4: ':abstraction:'
			{
			match(":abstraction:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ABSTRACTION"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:211:6: ({...}? => 'True' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:211:8: {...}? => 'True'
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

	// $ANTLR start "ACHIEVEGOAL"
	public final void mACHIEVEGOAL() throws RecognitionException {
		try {
			int _type = ACHIEVEGOAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:212:13: ({...}? => 'achieve' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:212:15: {...}? => 'achieve'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:213:13: ({...}? => 'perform' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:213:15: {...}? => 'perform'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:216:2: ( ':-' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:216:4: ':-'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:217:11: ( '<-' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:217:13: '<-'
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

	// $ANTLR start "EQ_ASSGN"
	public final void mEQ_ASSGN() throws RecognitionException {
		try {
			int _type = EQ_ASSGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:218:10: ( '=' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:218:12: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ_ASSGN"

	// $ANTLR start "ARROW"
	public final void mARROW() throws RecognitionException {
		try {
			int _type = ARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:219:7: ( '->' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:219:9: '->'
			{
			match("->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARROW"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:272:5: ( '/*' ( . )* '*/' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:272:7: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:272:12: ( . )*
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
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:272:12: .
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:275:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:275:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:275:12: (~ ( '\\n' | '\\r' ) )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:
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

			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:275:26: ( '\\r' )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='\r') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:275:26: '\\r'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:277:8: ( ( '\\r' )? '\\n' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:277:9: ( '\\r' )? '\\n'
			{
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:277:9: ( '\\r' )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='\r') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:277:9: '\\r'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:278:5: ({...}? => ( ' ' | '\\t' )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:278:8: {...}? => ( ' ' | '\\t' )+
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "WS", "!stringterm");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:278:24: ( ' ' | '\\t' )+
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
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:281:6: ( '(' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:281:9: '('
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:282:7: ( ')' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:282:9: ')'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:283:8: ( '[' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:283:10: '['
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:9: ( ']' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:11: ']'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:285:11: ( '{' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:285:13: '{'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:286:12: ( '}' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:286:14: '}'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:288:2: ( '\"' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:288:4: '\"'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:290:5: ( '~' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:290:7: '~'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:292:8: ({...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:292:10: {...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' )+
			{
			if ( !((stringterm)) ) {
				throw new FailedPredicateException(input, "STRING", "stringterm");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:292:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' )+
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
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:293:8: ({...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:293:11: {...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "CONST", "!stringterm");
			}
			matchRange('a','z'); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:293:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:294:5: ({...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:294:7: {...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "VAR", "!stringterm");
			}
			matchRange('A','Z'); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:294:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '0' && LA10_0 <= '9')||(LA10_0 >= 'A' && LA10_0 <= 'Z')||LA10_0=='_'||(LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:295:8: ({...}? => '0' .. '9' ( '0' .. '9' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:295:10: {...}? => '0' .. '9' ( '0' .. '9' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "NUMBER", "!stringterm");
			}
			matchRange('0','9'); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:295:35: ( '0' .. '9' )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:298:6: ( '<' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:298:8: '<'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:299:4: ( '==' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:299:7: '=='
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:300:7: ( '.' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:300:9: '.'
			{
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:301:6: ( '*' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:301:8: '*'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:302:6: ( '+' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:302:8: '+'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:303:7: ( '-' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:303:9: '-'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:304:5: ( '/' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:304:7: '/'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:305:5: ( '%' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:305:7: '%'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:307:8: ( '!' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:307:10: '!'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:308:7: ( ',' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:308:9: ','
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:309:6: ( ';' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:309:8: ';'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:310:7: ( ':' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:310:9: ':'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:311:7: ( '?' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:311:9: '?'
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

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:8: ( UPDATE | TELL | PERFORM | ACHIEVE | SEND | RECEIVED | CALCULATE | QUERYCOM | WAIT | CAPABILITY | PLAN | IMPLICATION | SUBSTITUTE | BELIEVE | GOAL | SENT | LOCK | GOALS | BELIEFS | BELIEFRULES | CAPABILITIES | PLANS | EASS | NAME | ABSTRACTION | TRUE | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | EQ_ASSGN | ARROW | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY )
		int alt12=61;
		alt12 = dfa12.predict(input);
		switch (alt12) {
			case 1 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:10: UPDATE
				{
				mUPDATE(); 

				}
				break;
			case 2 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:17: TELL
				{
				mTELL(); 

				}
				break;
			case 3 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:22: PERFORM
				{
				mPERFORM(); 

				}
				break;
			case 4 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:30: ACHIEVE
				{
				mACHIEVE(); 

				}
				break;
			case 5 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:38: SEND
				{
				mSEND(); 

				}
				break;
			case 6 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:43: RECEIVED
				{
				mRECEIVED(); 

				}
				break;
			case 7 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:52: CALCULATE
				{
				mCALCULATE(); 

				}
				break;
			case 8 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:62: QUERYCOM
				{
				mQUERYCOM(); 

				}
				break;
			case 9 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:71: WAIT
				{
				mWAIT(); 

				}
				break;
			case 10 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:76: CAPABILITY
				{
				mCAPABILITY(); 

				}
				break;
			case 11 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:87: PLAN
				{
				mPLAN(); 

				}
				break;
			case 12 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:92: IMPLICATION
				{
				mIMPLICATION(); 

				}
				break;
			case 13 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:104: SUBSTITUTE
				{
				mSUBSTITUTE(); 

				}
				break;
			case 14 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:115: BELIEVE
				{
				mBELIEVE(); 

				}
				break;
			case 15 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:123: GOAL
				{
				mGOAL(); 

				}
				break;
			case 16 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:128: SENT
				{
				mSENT(); 

				}
				break;
			case 17 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:133: LOCK
				{
				mLOCK(); 

				}
				break;
			case 18 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:138: GOALS
				{
				mGOALS(); 

				}
				break;
			case 19 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:144: BELIEFS
				{
				mBELIEFS(); 

				}
				break;
			case 20 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:152: BELIEFRULES
				{
				mBELIEFRULES(); 

				}
				break;
			case 21 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:164: CAPABILITIES
				{
				mCAPABILITIES(); 

				}
				break;
			case 22 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:177: PLANS
				{
				mPLANS(); 

				}
				break;
			case 23 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:183: EASS
				{
				mEASS(); 

				}
				break;
			case 24 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:188: NAME
				{
				mNAME(); 

				}
				break;
			case 25 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:193: ABSTRACTION
				{
				mABSTRACTION(); 

				}
				break;
			case 26 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:205: TRUE
				{
				mTRUE(); 

				}
				break;
			case 27 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:210: ACHIEVEGOAL
				{
				mACHIEVEGOAL(); 

				}
				break;
			case 28 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:222: PERFORMGOAL
				{
				mPERFORMGOAL(); 

				}
				break;
			case 29 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:234: BRULEARROW
				{
				mBRULEARROW(); 

				}
				break;
			case 30 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:245: RULEARROW
				{
				mRULEARROW(); 

				}
				break;
			case 31 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:255: EQ_ASSGN
				{
				mEQ_ASSGN(); 

				}
				break;
			case 32 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:264: ARROW
				{
				mARROW(); 

				}
				break;
			case 33 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:270: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 34 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:278: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;
			case 35 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:291: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 36 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:299: WS
				{
				mWS(); 

				}
				break;
			case 37 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:302: OPEN
				{
				mOPEN(); 

				}
				break;
			case 38 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:307: CLOSE
				{
				mCLOSE(); 

				}
				break;
			case 39 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:313: SQOPEN
				{
				mSQOPEN(); 

				}
				break;
			case 40 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:320: SQCLOSE
				{
				mSQCLOSE(); 

				}
				break;
			case 41 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:328: CURLYOPEN
				{
				mCURLYOPEN(); 

				}
				break;
			case 42 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:338: CURLYCLOSE
				{
				mCURLYCLOSE(); 

				}
				break;
			case 43 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:349: DOUBLEQUOTE
				{
				mDOUBLEQUOTE(); 

				}
				break;
			case 44 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:361: NOT
				{
				mNOT(); 

				}
				break;
			case 45 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:365: STRING
				{
				mSTRING(); 

				}
				break;
			case 46 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:372: CONST
				{
				mCONST(); 

				}
				break;
			case 47 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:378: VAR
				{
				mVAR(); 

				}
				break;
			case 48 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:382: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 49 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:389: LESS
				{
				mLESS(); 

				}
				break;
			case 50 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:394: EQ
				{
				mEQ(); 

				}
				break;
			case 51 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:397: POINT
				{
				mPOINT(); 

				}
				break;
			case 52 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:403: MULT
				{
				mMULT(); 

				}
				break;
			case 53 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:408: PLUS
				{
				mPLUS(); 

				}
				break;
			case 54 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:413: MINUS
				{
				mMINUS(); 

				}
				break;
			case 55 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:419: DIV
				{
				mDIV(); 

				}
				break;
			case 56 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:423: MOD
				{
				mMOD(); 

				}
				break;
			case 57 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:427: SHRIEK
				{
				mSHRIEK(); 

				}
				break;
			case 58 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:434: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 59 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:440: SEMI
				{
				mSEMI(); 

				}
				break;
			case 60 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:445: COLON
				{
				mCOLON(); 

				}
				break;
			case 61 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:451: QUERY
				{
				mQUERY(); 

				}
				break;

		}
	}


	protected DFA12 dfa12 = new DFA12(this);
	static final String DFA12_eotS =
		"\2\uffff\1\55\1\70\1\71\1\73\2\75\2\100\1\104\1\106\1\110\1\113\1\uffff"+
		"\1\114\11\uffff\1\100\1\75\1\115\22\uffff\7\34\1\132\1\133\1\34\2\uffff"+
		"\1\75\1\uffff\1\75\1\uffff\1\75\1\100\1\uffff\2\100\13\uffff\1\115\3\uffff"+
		"\10\34\2\uffff\1\34\4\uffff\2\75\1\100\1\uffff\1\100\2\uffff\4\34\1\174"+
		"\3\34\1\u0080\1\34\1\u0082\1\u0083\2\100\1\uffff\1\u0087\1\u0088\3\34"+
		"\1\uffff\1\34\1\u008e\1\u008f\1\uffff\1\u0091\2\uffff\2\100\3\uffff\3"+
		"\34\1\uffff\1\u009c\6\uffff\2\100\3\uffff\3\34\4\uffff\1\u00a7\1\u00a8"+
		"\1\uffff\3\34\4\uffff\1\34\1\u00b2\1\34\4\uffff\1\34\1\uffff\1\u00b6\1"+
		"\u00b7\5\uffff";
	static final String DFA12_eofS =
		"\u00ba\uffff";
	static final String DFA12_minS =
		"\1\11\1\uffff\1\55\7\40\1\55\1\75\1\76\1\52\1\uffff\1\11\11\uffff\3\40"+
		"\12\uffff\1\142\1\156\6\uffff\2\145\1\141\1\165\1\141\1\154\1\155\2\40"+
		"\1\157\2\0\1\40\1\0\1\40\1\0\2\40\1\0\2\40\11\uffff\2\0\1\40\2\uffff\1"+
		"\151\1\156\1\142\1\143\1\154\1\145\1\151\1\141\1\160\2\0\1\143\4\uffff"+
		"\3\40\1\uffff\1\40\1\uffff\1\164\1\144\1\163\1\145\1\143\1\40\1\162\1"+
		"\164\1\156\1\40\1\153\4\40\1\151\2\40\1\164\1\151\1\165\1\0\1\171\2\40"+
		"\1\0\1\40\2\0\2\40\1\141\2\0\1\151\1\166\1\154\1\uffff\1\40\2\0\1\uffff"+
		"\1\0\2\uffff\2\40\1\154\2\uffff\1\164\1\145\1\141\1\0\3\uffff\3\40\1\165"+
		"\1\144\1\164\1\uffff\2\0\1\102\1\164\1\40\1\145\4\uffff\1\145\1\0\2\40"+
		"\1\uffff\2\0\2\uffff";
	static final String DFA12_maxS =
		"\1\176\1\uffff\1\164\7\172\1\55\1\75\1\76\1\57\1\uffff\1\172\11\uffff"+
		"\3\172\12\uffff\1\143\1\156\6\uffff\1\165\1\145\1\141\1\165\1\141\1\154"+
		"\1\155\2\172\1\157\2\0\1\172\1\0\1\172\1\0\2\172\1\0\2\172\11\uffff\2"+
		"\0\1\172\2\uffff\1\151\1\156\1\142\1\143\1\160\1\145\1\151\1\141\1\160"+
		"\2\0\1\143\4\uffff\3\172\1\uffff\1\172\1\uffff\2\164\1\163\1\145\1\143"+
		"\1\172\1\162\1\164\1\156\1\172\1\153\4\172\1\151\2\172\1\164\1\151\1\165"+
		"\1\0\1\171\2\172\1\0\1\172\2\0\2\172\1\141\2\0\1\151\1\166\1\154\1\uffff"+
		"\1\172\2\0\1\uffff\1\0\2\uffff\2\172\1\154\2\uffff\1\164\1\145\1\141\1"+
		"\0\3\uffff\2\172\1\40\1\165\1\144\1\164\1\uffff\2\0\1\107\1\164\1\172"+
		"\1\145\4\uffff\1\145\1\0\2\172\1\uffff\2\0\2\uffff";
	static final String DFA12_acceptS =
		"\1\uffff\1\1\14\uffff\1\43\1\uffff\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
		"\1\54\1\44\3\uffff\1\55\1\64\1\65\1\70\1\71\1\72\1\73\1\75\1\2\1\3\2\uffff"+
		"\1\24\1\25\1\26\1\30\1\35\1\74\25\uffff\1\36\1\61\1\62\1\37\1\40\1\66"+
		"\1\41\1\42\1\67\3\uffff\1\4\1\31\14\uffff\1\63\1\16\1\57\1\17\3\uffff"+
		"\1\56\1\uffff\1\60\45\uffff\1\12\3\uffff\1\14\1\uffff\1\27\1\32\3\uffff"+
		"\1\5\1\20\4\uffff\1\11\1\13\1\21\6\uffff\1\10\6\uffff\1\33\1\34\1\22\1"+
		"\23\4\uffff\1\6\2\uffff\1\7\1\15";
	static final String DFA12_specialS =
		"\1\4\2\uffff\1\127\1\60\1\124\1\74\1\40\1\11\1\12\5\uffff\1\41\11\uffff"+
		"\1\126\1\0\1\16\22\uffff\1\36\1\23\1\63\1\145\1\141\1\154\1\123\1\56\1"+
		"\31\1\3\1\21\1\151\1\10\1\152\1\70\1\52\1\15\1\115\1\54\1\20\1\71\11\uffff"+
		"\1\42\1\53\1\140\3\uffff\1\34\1\120\1\32\1\76\1\146\1\142\1\153\1\125"+
		"\1\111\1\113\1\5\4\uffff\1\65\1\17\1\112\1\uffff\1\67\2\uffff\1\22\1\121"+
		"\1\33\1\43\1\44\1\147\1\143\1\155\1\66\1\6\1\30\1\13\1\110\1\64\1\uffff"+
		"\1\7\1\2\1\116\1\26\1\37\1\101\1\150\1\25\1\55\1\104\1\1\1\130\1\133\1"+
		"\107\1\62\1\uffff\1\72\1\114\1\117\1\27\1\35\1\uffff\1\156\1\100\1\102"+
		"\1\uffff\1\24\2\uffff\1\103\1\61\3\uffff\1\137\1\51\1\47\1\77\3\uffff"+
		"\1\106\1\57\1\uffff\1\136\1\50\1\46\1\uffff\1\132\1\131\1\uffff\1\135"+
		"\1\122\1\45\4\uffff\1\134\1\73\1\144\1\14\1\uffff\1\75\1\105\2\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\30\1\16\2\uffff\1\16\22\uffff\1\17\1\40\1\26\2\uffff\1\37\2\uffff"+
			"\1\20\1\21\1\35\1\36\1\41\1\14\1\3\1\15\12\33\1\2\1\42\1\12\1\13\1\1"+
			"\1\43\1\uffff\1\32\1\4\2\32\1\6\1\32\1\5\14\32\1\7\6\32\1\22\1\uffff"+
			"\1\23\1\uffff\1\34\1\uffff\1\10\16\31\1\11\12\31\1\24\1\uffff\1\25\1"+
			"\27",
			"",
			"\1\54\25\uffff\1\51\5\uffff\1\47\6\uffff\1\52\1\uffff\1\50\16\uffff"+
			"\1\46\14\uffff\1\53\1\uffff\1\45\3\uffff\1\44",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\1\34\1\65\4\34\1\66\23\34"+
			"\4\uffff\1\34\1\uffff\2\34\1\60\5\34\1\64\2\34\1\67\3\34\1\63\1\61\1"+
			"\57\1\56\3\34\1\62\3\34",
			"\1\34\15\uffff\1\34\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\34\15\uffff\1\34\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\34\15\uffff\1\34\1\uffff\12\72\7\uffff\1\74\31\72\4\uffff\1\72\1"+
			"\uffff\32\72",
			"\1\34\15\uffff\1\34\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\21\72\1\76\10\72",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\2\101\1\77\27\101",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\4\101\1\102\25\101",
			"\1\103",
			"\1\105",
			"\1\107",
			"\1\111\4\uffff\1\112",
			"",
			"\1\30\26\uffff\1\17\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff"+
			"\1\34\1\uffff\32\34",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\32\101",
			"\1\34\15\uffff\1\34\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\34\15\uffff\1\34\1\uffff\12\116\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
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
			"\1\120\1\117",
			"\1\121",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\122\17\uffff\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\134",
			"\1\uffff",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\72\7\uffff\22\72\1\141\7\72\4\uffff\1"+
			"\72\1\uffff\32\72",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\24\72\1\142\5\72",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\7\101\1\143\22\101",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\32\101",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\21\101\1\145\10\101",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\116\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"",
			"",
			"\1\147",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\153\3\uffff\1\154",
			"\1\155",
			"\1\156",
			"\1\157",
			"\1\160",
			"\1\uffff",
			"\1\uffff",
			"\1\161",
			"",
			"",
			"",
			"",
			"\1\34\15\uffff\1\34\1\uffff\12\72\7\uffff\22\72\1\162\7\72\4\uffff\1"+
			"\72\1\uffff\32\72",
			"\1\34\15\uffff\1\34\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\4\72\1\163\25\72",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\10\101\1\164\21\101",
			"",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\5\101\1\165\24\101",
			"",
			"\1\166",
			"\1\167\17\uffff\1\170",
			"\1\171",
			"\1\172",
			"\1\173",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\175",
			"\1\176",
			"\1\177",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\u0081",
			"\1\34\15\uffff\1\34\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\34\15\uffff\1\34\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\4\101\1\u0084\25\101",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\16\101\1\u0085\13\101",
			"\1\u0086",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\u0089",
			"\1\u008a",
			"\1\u008b",
			"\1\uffff",
			"\1\u008d",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\uffff",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\25\101\1\u0094\4\101",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\21\101\1\u0095\10\101",
			"\1\u0096",
			"\1\uffff",
			"\1\uffff",
			"\1\u0099",
			"\1\u009a",
			"\1\u009b",
			"",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\uffff",
			"\1\uffff",
			"",
			"\1\uffff",
			"",
			"",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\4\101\1\u00a0\25\101",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\14\101\1\u00a1\15\101",
			"\1\u00a2",
			"",
			"",
			"\1\u00a3",
			"\1\u00a4",
			"\1\u00a5",
			"\1\uffff",
			"",
			"",
			"",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\32\101",
			"\1\34\15\uffff\1\34\1\uffff\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff"+
			"\32\101",
			"\1\u00a9",
			"\1\u00aa",
			"\1\u00ab",
			"\1\u00ac",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\u00b0\4\uffff\1\u00af",
			"\1\u00b1",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\u00b3",
			"",
			"",
			"",
			"",
			"\1\u00b4",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"",
			"\1\uffff",
			"\1\uffff",
			"",
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
			return "1:1: Tokens : ( UPDATE | TELL | PERFORM | ACHIEVE | SEND | RECEIVED | CALCULATE | QUERYCOM | WAIT | CAPABILITY | PLAN | IMPLICATION | SUBSTITUTE | BELIEVE | GOAL | SENT | LOCK | GOALS | BELIEFS | BELIEFRULES | CAPABILITIES | PLANS | EASS | NAME | ABSTRACTION | TRUE | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | EQ_ASSGN | ARROW | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA12_26 = input.LA(1);
						 
						int index12_26 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_26 >= '0' && LA12_26 <= '9')||(LA12_26 >= 'A' && LA12_26 <= 'Z')||LA12_26=='_'||(LA12_26 >= 'a' && LA12_26 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 58;}
						else if ( (LA12_26==' '||LA12_26=='.') && ((stringterm))) {s = 28;}
						else s = 61;
						 
						input.seek(index12_26);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA12_129 = input.LA(1);
						 
						int index12_129 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_129==' '||LA12_129=='.'||(LA12_129 >= '0' && LA12_129 <= '9')||(LA12_129 >= 'A' && LA12_129 <= 'Z')||LA12_129=='_'||(LA12_129 >= 'a' && LA12_129 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 145;
						 
						input.seek(index12_129);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA12_120 = input.LA(1);
						 
						int index12_120 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_120==' '||LA12_120=='.'||(LA12_120 >= '0' && LA12_120 <= '9')||(LA12_120 >= 'A' && LA12_120 <= 'Z')||LA12_120=='_'||(LA12_120 >= 'a' && LA12_120 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 136;
						 
						input.seek(index12_120);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA12_55 = input.LA(1);
						 
						int index12_55 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_55=='o') ) {s = 92;}
						else s = 28;
						 
						input.seek(index12_55);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA12_0 = input.LA(1);
						 
						int index12_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_0=='>') ) {s = 1;}
						else if ( (LA12_0==':') ) {s = 2;}
						else if ( (LA12_0=='.') ) {s = 3;}
						else if ( (LA12_0=='B') && (((stringterm)||(!stringterm)||(curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)))) {s = 4;}
						else if ( (LA12_0=='G') && (((stringterm)||(!stringterm)||(curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)))) {s = 5;}
						else if ( (LA12_0=='E') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 6;}
						else if ( (LA12_0=='T') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 7;}
						else if ( (LA12_0=='a') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 8;}
						else if ( (LA12_0=='p') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 9;}
						else if ( (LA12_0=='<') ) {s = 10;}
						else if ( (LA12_0=='=') ) {s = 11;}
						else if ( (LA12_0=='-') ) {s = 12;}
						else if ( (LA12_0=='/') ) {s = 13;}
						else if ( (LA12_0=='\n'||LA12_0=='\r') ) {s = 14;}
						else if ( (LA12_0==' ') && (((!stringterm)||(stringterm)))) {s = 15;}
						else if ( (LA12_0=='(') ) {s = 16;}
						else if ( (LA12_0==')') ) {s = 17;}
						else if ( (LA12_0=='[') ) {s = 18;}
						else if ( (LA12_0==']') ) {s = 19;}
						else if ( (LA12_0=='{') ) {s = 20;}
						else if ( (LA12_0=='}') ) {s = 21;}
						else if ( (LA12_0=='\"') ) {s = 22;}
						else if ( (LA12_0=='~') ) {s = 23;}
						else if ( (LA12_0=='\t') && ((!stringterm))) {s = 24;}
						else if ( ((LA12_0 >= 'b' && LA12_0 <= 'o')||(LA12_0 >= 'q' && LA12_0 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 25;}
						else if ( (LA12_0=='A'||(LA12_0 >= 'C' && LA12_0 <= 'D')||LA12_0=='F'||(LA12_0 >= 'H' && LA12_0 <= 'S')||(LA12_0 >= 'U' && LA12_0 <= 'Z')) && (((!stringterm)||(stringterm)))) {s = 26;}
						else if ( ((LA12_0 >= '0' && LA12_0 <= '9')) && (((!stringterm)||(stringterm)))) {s = 27;}
						else if ( (LA12_0=='_') && ((stringterm))) {s = 28;}
						else if ( (LA12_0=='*') ) {s = 29;}
						else if ( (LA12_0=='+') ) {s = 30;}
						else if ( (LA12_0=='%') ) {s = 31;}
						else if ( (LA12_0=='!') ) {s = 32;}
						else if ( (LA12_0==',') ) {s = 33;}
						else if ( (LA12_0==';') ) {s = 34;}
						else if ( (LA12_0=='?') ) {s = 35;}
						 
						input.seek(index12_0);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA12_92 = input.LA(1);
						 
						int index12_92 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_92=='c') ) {s = 113;}
						else s = 28;
						 
						input.seek(index12_92);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA12_113 = input.LA(1);
						 
						int index12_113 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_113=='k') ) {s = 129;}
						else s = 28;
						 
						input.seek(index12_113);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA12_119 = input.LA(1);
						 
						int index12_119 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_119==' '||LA12_119=='.'||(LA12_119 >= '0' && LA12_119 <= '9')||(LA12_119 >= 'A' && LA12_119 <= 'Z')||LA12_119=='_'||(LA12_119 >= 'a' && LA12_119 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 135;
						 
						input.seek(index12_119);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA12_58 = input.LA(1);
						 
						int index12_58 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_58 >= '0' && LA12_58 <= '9')||(LA12_58 >= 'A' && LA12_58 <= 'Z')||LA12_58=='_'||(LA12_58 >= 'a' && LA12_58 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 58;}
						else if ( (LA12_58==' '||LA12_58=='.') && ((stringterm))) {s = 28;}
						else s = 61;
						 
						input.seek(index12_58);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA12_8 = input.LA(1);
						 
						int index12_8 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_8=='c') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 63;}
						else if ( ((LA12_8 >= '0' && LA12_8 <= '9')||(LA12_8 >= 'A' && LA12_8 <= 'Z')||LA12_8=='_'||(LA12_8 >= 'a' && LA12_8 <= 'b')||(LA12_8 >= 'd' && LA12_8 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_8==' '||LA12_8=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_8);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA12_9 = input.LA(1);
						 
						int index12_9 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_9=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 66;}
						else if ( ((LA12_9 >= '0' && LA12_9 <= '9')||(LA12_9 >= 'A' && LA12_9 <= 'Z')||LA12_9=='_'||(LA12_9 >= 'a' && LA12_9 <= 'd')||(LA12_9 >= 'f' && LA12_9 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_9==' '||LA12_9=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_9);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA12_115 = input.LA(1);
						 
						int index12_115 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_115 >= '0' && LA12_115 <= '9')||(LA12_115 >= 'A' && LA12_115 <= 'Z')||LA12_115=='_'||(LA12_115 >= 'a' && LA12_115 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 58;}
						else if ( (LA12_115==' '||LA12_115=='.') && ((stringterm))) {s = 28;}
						else s = 131;
						 
						input.seek(index12_115);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA12_180 = input.LA(1);
						 
						int index12_180 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_180==' '||LA12_180=='.'||(LA12_180 >= '0' && LA12_180 <= '9')||(LA12_180 >= 'A' && LA12_180 <= 'Z')||LA12_180=='_'||(LA12_180 >= 'a' && LA12_180 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 183;
						 
						input.seek(index12_180);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA12_62 = input.LA(1);
						 
						int index12_62 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_62=='u') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 98;}
						else if ( ((LA12_62 >= '0' && LA12_62 <= '9')||(LA12_62 >= 'A' && LA12_62 <= 'Z')||LA12_62=='_'||(LA12_62 >= 'a' && LA12_62 <= 't')||(LA12_62 >= 'v' && LA12_62 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 58;}
						else if ( (LA12_62==' '||LA12_62=='.') && ((stringterm))) {s = 28;}
						else s = 61;
						 
						input.seek(index12_62);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA12_27 = input.LA(1);
						 
						int index12_27 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_27 >= '0' && LA12_27 <= '9')) && (((!stringterm)||(stringterm)))) {s = 78;}
						else if ( (LA12_27==' '||LA12_27=='.'||(LA12_27 >= 'A' && LA12_27 <= 'Z')||LA12_27=='_'||(LA12_27 >= 'a' && LA12_27 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 77;
						 
						input.seek(index12_27);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA12_98 = input.LA(1);
						 
						int index12_98 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_98=='e') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 115;}
						else if ( ((LA12_98 >= '0' && LA12_98 <= '9')||(LA12_98 >= 'A' && LA12_98 <= 'Z')||LA12_98=='_'||(LA12_98 >= 'a' && LA12_98 <= 'd')||(LA12_98 >= 'f' && LA12_98 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 58;}
						else if ( (LA12_98==' '||LA12_98=='.') && ((stringterm))) {s = 28;}
						else s = 61;
						 
						input.seek(index12_98);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA12_65 = input.LA(1);
						 
						int index12_65 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_65 >= '0' && LA12_65 <= '9')||(LA12_65 >= 'A' && LA12_65 <= 'Z')||LA12_65=='_'||(LA12_65 >= 'a' && LA12_65 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_65==' '||LA12_65=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_65);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA12_56 = input.LA(1);
						 
						int index12_56 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 28;}
						else if ( (true) ) {s = 93;}
						 
						input.seek(index12_56);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA12_104 = input.LA(1);
						 
						int index12_104 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_104=='d') ) {s = 119;}
						else if ( (LA12_104=='t') && (((stringterm)||(curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)))) {s = 120;}
						else s = 28;
						 
						input.seek(index12_104);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA12_47 = input.LA(1);
						 
						int index12_47 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_47=='e') ) {s = 84;}
						else s = 28;
						 
						input.seek(index12_47);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA12_145 = input.LA(1);
						 
						int index12_145 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 159;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_145);
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA12_126 = input.LA(1);
						 
						int index12_126 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_126==' '||LA12_126=='.'||(LA12_126 >= '0' && LA12_126 <= '9')||(LA12_126 >= 'A' && LA12_126 <= 'Z')||LA12_126=='_'||(LA12_126 >= 'a' && LA12_126 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 142;
						 
						input.seek(index12_126);
						if ( s>=0 ) return s;
						break;

					case 22 : 
						int LA12_122 = input.LA(1);
						 
						int index12_122 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_122=='i') ) {s = 138;}
						else s = 28;
						 
						input.seek(index12_122);
						if ( s>=0 ) return s;
						break;

					case 23 : 
						int LA12_138 = input.LA(1);
						 
						int index12_138 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_138=='v') ) {s = 154;}
						else s = 28;
						 
						input.seek(index12_138);
						if ( s>=0 ) return s;
						break;

					case 24 : 
						int LA12_114 = input.LA(1);
						 
						int index12_114 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_114 >= '0' && LA12_114 <= '9')||(LA12_114 >= 'A' && LA12_114 <= 'Z')||LA12_114=='_'||(LA12_114 >= 'a' && LA12_114 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 58;}
						else if ( (LA12_114==' '||LA12_114=='.') && ((stringterm))) {s = 28;}
						else s = 130;
						 
						input.seek(index12_114);
						if ( s>=0 ) return s;
						break;

					case 25 : 
						int LA12_54 = input.LA(1);
						 
						int index12_54 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_54==' '||LA12_54=='.'||(LA12_54 >= '0' && LA12_54 <= '9')||(LA12_54 >= 'A' && LA12_54 <= 'Z')||LA12_54=='_'||(LA12_54 >= 'a' && LA12_54 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 91;
						 
						input.seek(index12_54);
						if ( s>=0 ) return s;
						break;

					case 26 : 
						int LA12_84 = input.LA(1);
						 
						int index12_84 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_84=='c') ) {s = 106;}
						else s = 28;
						 
						input.seek(index12_84);
						if ( s>=0 ) return s;
						break;

					case 27 : 
						int LA12_106 = input.LA(1);
						 
						int index12_106 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_106=='e') ) {s = 122;}
						else s = 28;
						 
						input.seek(index12_106);
						if ( s>=0 ) return s;
						break;

					case 28 : 
						int LA12_82 = input.LA(1);
						 
						int index12_82 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_82=='n') ) {s = 104;}
						else s = 28;
						 
						input.seek(index12_82);
						if ( s>=0 ) return s;
						break;

					case 29 : 
						int LA12_139 = input.LA(1);
						 
						int index12_139 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_139=='l') ) {s = 155;}
						else s = 28;
						 
						input.seek(index12_139);
						if ( s>=0 ) return s;
						break;

					case 30 : 
						int LA12_46 = input.LA(1);
						 
						int index12_46 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_46=='e') ) {s = 82;}
						else if ( (LA12_46=='u') ) {s = 83;}
						else s = 28;
						 
						input.seek(index12_46);
						if ( s>=0 ) return s;
						break;

					case 31 : 
						int LA12_123 = input.LA(1);
						 
						int index12_123 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_123=='u') ) {s = 139;}
						else s = 28;
						 
						input.seek(index12_123);
						if ( s>=0 ) return s;
						break;

					case 32 : 
						int LA12_7 = input.LA(1);
						 
						int index12_7 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_7=='r') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 62;}
						else if ( ((LA12_7 >= '0' && LA12_7 <= '9')||(LA12_7 >= 'A' && LA12_7 <= 'Z')||LA12_7=='_'||(LA12_7 >= 'a' && LA12_7 <= 'q')||(LA12_7 >= 's' && LA12_7 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 58;}
						else if ( (LA12_7==' '||LA12_7=='.') && ((stringterm))) {s = 28;}
						else s = 61;
						 
						input.seek(index12_7);
						if ( s>=0 ) return s;
						break;

					case 33 : 
						int LA12_15 = input.LA(1);
						 
						int index12_15 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_15==' ') && (((!stringterm)||(stringterm)))) {s = 15;}
						else if ( (LA12_15=='\t') && ((!stringterm))) {s = 24;}
						else if ( (LA12_15=='.'||(LA12_15 >= '0' && LA12_15 <= '9')||(LA12_15 >= 'A' && LA12_15 <= 'Z')||LA12_15=='_'||(LA12_15 >= 'a' && LA12_15 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 76;
						 
						input.seek(index12_15);
						if ( s>=0 ) return s;
						break;

					case 34 : 
						int LA12_76 = input.LA(1);
						 
						int index12_76 = input.index();
						input.rewind();
						s = -1;
						if ( ((!stringterm)) ) {s = 24;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_76);
						if ( s>=0 ) return s;
						break;

					case 35 : 
						int LA12_107 = input.LA(1);
						 
						int index12_107 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_107=='c') ) {s = 123;}
						else s = 28;
						 
						input.seek(index12_107);
						if ( s>=0 ) return s;
						break;

					case 36 : 
						int LA12_108 = input.LA(1);
						 
						int index12_108 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_108==' '||LA12_108=='.'||(LA12_108 >= '0' && LA12_108 <= '9')||(LA12_108 >= 'A' && LA12_108 <= 'Z')||LA12_108=='_'||(LA12_108 >= 'a' && LA12_108 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 124;
						 
						input.seek(index12_108);
						if ( s>=0 ) return s;
						break;

					case 37 : 
						int LA12_172 = input.LA(1);
						 
						int index12_172 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_172=='e') ) {s = 179;}
						else s = 28;
						 
						input.seek(index12_172);
						if ( s>=0 ) return s;
						break;

					case 38 : 
						int LA12_165 = input.LA(1);
						 
						int index12_165 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_165=='t') ) {s = 172;}
						else s = 28;
						 
						input.seek(index12_165);
						if ( s>=0 ) return s;
						break;

					case 39 : 
						int LA12_155 = input.LA(1);
						 
						int index12_155 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_155=='a') ) {s = 165;}
						else s = 28;
						 
						input.seek(index12_155);
						if ( s>=0 ) return s;
						break;

					case 40 : 
						int LA12_164 = input.LA(1);
						 
						int index12_164 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_164=='d') ) {s = 171;}
						else s = 28;
						 
						input.seek(index12_164);
						if ( s>=0 ) return s;
						break;

					case 41 : 
						int LA12_154 = input.LA(1);
						 
						int index12_154 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_154=='e') ) {s = 164;}
						else s = 28;
						 
						input.seek(index12_154);
						if ( s>=0 ) return s;
						break;

					case 42 : 
						int LA12_61 = input.LA(1);
						 
						int index12_61 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 95;}
						 
						input.seek(index12_61);
						if ( s>=0 ) return s;
						break;

					case 43 : 
						int LA12_77 = input.LA(1);
						 
						int index12_77 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 102;}
						 
						input.seek(index12_77);
						if ( s>=0 ) return s;
						break;

					case 44 : 
						int LA12_64 = input.LA(1);
						 
						int index12_64 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 100;}
						 
						input.seek(index12_64);
						if ( s>=0 ) return s;
						break;

					case 45 : 
						int LA12_127 = input.LA(1);
						 
						int index12_127 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_127==' '||LA12_127=='.'||(LA12_127 >= '0' && LA12_127 <= '9')||(LA12_127 >= 'A' && LA12_127 <= 'Z')||LA12_127=='_'||(LA12_127 >= 'a' && LA12_127 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 143;
						 
						input.seek(index12_127);
						if ( s>=0 ) return s;
						break;

					case 46 : 
						int LA12_53 = input.LA(1);
						 
						int index12_53 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_53==' '||LA12_53=='.'||(LA12_53 >= '0' && LA12_53 <= '9')||(LA12_53 >= 'A' && LA12_53 <= 'Z')||LA12_53=='_'||(LA12_53 >= 'a' && LA12_53 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 90;
						 
						input.seek(index12_53);
						if ( s>=0 ) return s;
						break;

					case 47 : 
						int LA12_161 = input.LA(1);
						 
						int index12_161 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_161 >= '0' && LA12_161 <= '9')||(LA12_161 >= 'A' && LA12_161 <= 'Z')||LA12_161=='_'||(LA12_161 >= 'a' && LA12_161 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_161==' '||LA12_161=='.') && ((stringterm))) {s = 28;}
						else s = 168;
						 
						input.seek(index12_161);
						if ( s>=0 ) return s;
						break;

					case 48 : 
						int LA12_4 = input.LA(1);
						 
						int index12_4 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_4 >= '0' && LA12_4 <= '9')||(LA12_4 >= 'A' && LA12_4 <= 'Z')||LA12_4=='_'||(LA12_4 >= 'a' && LA12_4 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 58;}
						else if ( (LA12_4==' '||LA12_4=='.') && ((stringterm))) {s = 28;}
						else s = 57;
						 
						input.seek(index12_4);
						if ( s>=0 ) return s;
						break;

					case 49 : 
						int LA12_149 = input.LA(1);
						 
						int index12_149 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_149=='m') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 161;}
						else if ( ((LA12_149 >= '0' && LA12_149 <= '9')||(LA12_149 >= 'A' && LA12_149 <= 'Z')||LA12_149=='_'||(LA12_149 >= 'a' && LA12_149 <= 'l')||(LA12_149 >= 'n' && LA12_149 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_149==' '||LA12_149=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_149);
						if ( s>=0 ) return s;
						break;

					case 50 : 
						int LA12_133 = input.LA(1);
						 
						int index12_133 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_133=='r') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 149;}
						else if ( ((LA12_133 >= '0' && LA12_133 <= '9')||(LA12_133 >= 'A' && LA12_133 <= 'Z')||LA12_133=='_'||(LA12_133 >= 'a' && LA12_133 <= 'q')||(LA12_133 >= 's' && LA12_133 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_133==' '||LA12_133=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_133);
						if ( s>=0 ) return s;
						break;

					case 51 : 
						int LA12_48 = input.LA(1);
						 
						int index12_48 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_48=='a') ) {s = 85;}
						else s = 28;
						 
						input.seek(index12_48);
						if ( s>=0 ) return s;
						break;

					case 52 : 
						int LA12_117 = input.LA(1);
						 
						int index12_117 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_117=='o') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 133;}
						else if ( ((LA12_117 >= '0' && LA12_117 <= '9')||(LA12_117 >= 'A' && LA12_117 <= 'Z')||LA12_117=='_'||(LA12_117 >= 'a' && LA12_117 <= 'n')||(LA12_117 >= 'p' && LA12_117 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_117==' '||LA12_117=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_117);
						if ( s>=0 ) return s;
						break;

					case 53 : 
						int LA12_97 = input.LA(1);
						 
						int index12_97 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_97=='S') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 114;}
						else if ( ((LA12_97 >= '0' && LA12_97 <= '9')||(LA12_97 >= 'A' && LA12_97 <= 'R')||(LA12_97 >= 'T' && LA12_97 <= 'Z')||LA12_97=='_'||(LA12_97 >= 'a' && LA12_97 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 58;}
						else if ( (LA12_97==' '||LA12_97=='.') && ((stringterm))) {s = 28;}
						else s = 61;
						 
						input.seek(index12_97);
						if ( s>=0 ) return s;
						break;

					case 54 : 
						int LA12_112 = input.LA(1);
						 
						int index12_112 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_112==' '||LA12_112=='.'||(LA12_112 >= '0' && LA12_112 <= '9')||(LA12_112 >= 'A' && LA12_112 <= 'Z')||LA12_112=='_'||(LA12_112 >= 'a' && LA12_112 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 128;
						 
						input.seek(index12_112);
						if ( s>=0 ) return s;
						break;

					case 55 : 
						int LA12_101 = input.LA(1);
						 
						int index12_101 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_101=='f') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 117;}
						else if ( ((LA12_101 >= '0' && LA12_101 <= '9')||(LA12_101 >= 'A' && LA12_101 <= 'Z')||LA12_101=='_'||(LA12_101 >= 'a' && LA12_101 <= 'e')||(LA12_101 >= 'g' && LA12_101 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_101==' '||LA12_101=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_101);
						if ( s>=0 ) return s;
						break;

					case 56 : 
						int LA12_60 = input.LA(1);
						 
						int index12_60 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_60=='S') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 97;}
						else if ( ((LA12_60 >= '0' && LA12_60 <= '9')||(LA12_60 >= 'A' && LA12_60 <= 'R')||(LA12_60 >= 'T' && LA12_60 <= 'Z')||LA12_60=='_'||(LA12_60 >= 'a' && LA12_60 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 58;}
						else if ( (LA12_60==' '||LA12_60=='.') && ((stringterm))) {s = 28;}
						else s = 61;
						 
						input.seek(index12_60);
						if ( s>=0 ) return s;
						break;

					case 57 : 
						int LA12_66 = input.LA(1);
						 
						int index12_66 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_66=='r') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 101;}
						else if ( ((LA12_66 >= '0' && LA12_66 <= '9')||(LA12_66 >= 'A' && LA12_66 <= 'Z')||LA12_66=='_'||(LA12_66 >= 'a' && LA12_66 <= 'q')||(LA12_66 >= 's' && LA12_66 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_66==' '||LA12_66=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_66);
						if ( s>=0 ) return s;
						break;

					case 58 : 
						int LA12_135 = input.LA(1);
						 
						int index12_135 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 151;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_135);
						if ( s>=0 ) return s;
						break;

					case 59 : 
						int LA12_178 = input.LA(1);
						 
						int index12_178 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 181;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_178);
						if ( s>=0 ) return s;
						break;

					case 60 : 
						int LA12_6 = input.LA(1);
						 
						int index12_6 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_6=='A') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 60;}
						else if ( ((LA12_6 >= '0' && LA12_6 <= '9')||(LA12_6 >= 'B' && LA12_6 <= 'Z')||LA12_6=='_'||(LA12_6 >= 'a' && LA12_6 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 58;}
						else if ( (LA12_6==' '||LA12_6=='.') && ((stringterm))) {s = 28;}
						else s = 61;
						 
						input.seek(index12_6);
						if ( s>=0 ) return s;
						break;

					case 61 : 
						int LA12_182 = input.LA(1);
						 
						int index12_182 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 184;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_182);
						if ( s>=0 ) return s;
						break;

					case 62 : 
						int LA12_85 = input.LA(1);
						 
						int index12_85 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_85=='l') ) {s = 107;}
						else if ( (LA12_85=='p') ) {s = 108;}
						else s = 28;
						 
						input.seek(index12_85);
						if ( s>=0 ) return s;
						break;

					case 63 : 
						int LA12_156 = input.LA(1);
						 
						int index12_156 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 166;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_156);
						if ( s>=0 ) return s;
						break;

					case 64 : 
						int LA12_142 = input.LA(1);
						 
						int index12_142 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 157;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_142);
						if ( s>=0 ) return s;
						break;

					case 65 : 
						int LA12_124 = input.LA(1);
						 
						int index12_124 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 140;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_124);
						if ( s>=0 ) return s;
						break;

					case 66 : 
						int LA12_143 = input.LA(1);
						 
						int index12_143 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 158;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_143);
						if ( s>=0 ) return s;
						break;

					case 67 : 
						int LA12_148 = input.LA(1);
						 
						int index12_148 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_148=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 160;}
						else if ( ((LA12_148 >= '0' && LA12_148 <= '9')||(LA12_148 >= 'A' && LA12_148 <= 'Z')||LA12_148=='_'||(LA12_148 >= 'a' && LA12_148 <= 'd')||(LA12_148 >= 'f' && LA12_148 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_148==' '||LA12_148=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_148);
						if ( s>=0 ) return s;
						break;

					case 68 : 
						int LA12_128 = input.LA(1);
						 
						int index12_128 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 144;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_128);
						if ( s>=0 ) return s;
						break;

					case 69 : 
						int LA12_183 = input.LA(1);
						 
						int index12_183 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 185;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_183);
						if ( s>=0 ) return s;
						break;

					case 70 : 
						int LA12_160 = input.LA(1);
						 
						int index12_160 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_160 >= '0' && LA12_160 <= '9')||(LA12_160 >= 'A' && LA12_160 <= 'Z')||LA12_160=='_'||(LA12_160 >= 'a' && LA12_160 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_160==' '||LA12_160=='.') && ((stringterm))) {s = 28;}
						else s = 167;
						 
						input.seek(index12_160);
						if ( s>=0 ) return s;
						break;

					case 71 : 
						int LA12_132 = input.LA(1);
						 
						int index12_132 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_132=='v') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 148;}
						else if ( ((LA12_132 >= '0' && LA12_132 <= '9')||(LA12_132 >= 'A' && LA12_132 <= 'Z')||LA12_132=='_'||(LA12_132 >= 'a' && LA12_132 <= 'u')||(LA12_132 >= 'w' && LA12_132 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_132==' '||LA12_132=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_132);
						if ( s>=0 ) return s;
						break;

					case 72 : 
						int LA12_116 = input.LA(1);
						 
						int index12_116 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_116=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 132;}
						else if ( ((LA12_116 >= '0' && LA12_116 <= '9')||(LA12_116 >= 'A' && LA12_116 <= 'Z')||LA12_116=='_'||(LA12_116 >= 'a' && LA12_116 <= 'd')||(LA12_116 >= 'f' && LA12_116 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_116==' '||LA12_116=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_116);
						if ( s>=0 ) return s;
						break;

					case 73 : 
						int LA12_90 = input.LA(1);
						 
						int index12_90 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 94;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_90);
						if ( s>=0 ) return s;
						break;

					case 74 : 
						int LA12_99 = input.LA(1);
						 
						int index12_99 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_99=='i') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 116;}
						else if ( ((LA12_99 >= '0' && LA12_99 <= '9')||(LA12_99 >= 'A' && LA12_99 <= 'Z')||LA12_99=='_'||(LA12_99 >= 'a' && LA12_99 <= 'h')||(LA12_99 >= 'j' && LA12_99 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_99==' '||LA12_99=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_99);
						if ( s>=0 ) return s;
						break;

					case 75 : 
						int LA12_91 = input.LA(1);
						 
						int index12_91 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 96;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_91);
						if ( s>=0 ) return s;
						break;

					case 76 : 
						int LA12_136 = input.LA(1);
						 
						int index12_136 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 152;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_136);
						if ( s>=0 ) return s;
						break;

					case 77 : 
						int LA12_63 = input.LA(1);
						 
						int index12_63 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_63=='h') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 99;}
						else if ( ((LA12_63 >= '0' && LA12_63 <= '9')||(LA12_63 >= 'A' && LA12_63 <= 'Z')||LA12_63=='_'||(LA12_63 >= 'a' && LA12_63 <= 'g')||(LA12_63 >= 'i' && LA12_63 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_63==' '||LA12_63=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_63);
						if ( s>=0 ) return s;
						break;

					case 78 : 
						int LA12_121 = input.LA(1);
						 
						int index12_121 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_121=='t') ) {s = 137;}
						else s = 28;
						 
						input.seek(index12_121);
						if ( s>=0 ) return s;
						break;

					case 79 : 
						int LA12_137 = input.LA(1);
						 
						int index12_137 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_137=='i') ) {s = 153;}
						else s = 28;
						 
						input.seek(index12_137);
						if ( s>=0 ) return s;
						break;

					case 80 : 
						int LA12_83 = input.LA(1);
						 
						int index12_83 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_83=='b') ) {s = 105;}
						else s = 28;
						 
						input.seek(index12_83);
						if ( s>=0 ) return s;
						break;

					case 81 : 
						int LA12_105 = input.LA(1);
						 
						int index12_105 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_105=='s') ) {s = 121;}
						else s = 28;
						 
						input.seek(index12_105);
						if ( s>=0 ) return s;
						break;

					case 82 : 
						int LA12_171 = input.LA(1);
						 
						int index12_171 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_171==' '||LA12_171=='.'||(LA12_171 >= '0' && LA12_171 <= '9')||(LA12_171 >= 'A' && LA12_171 <= 'Z')||LA12_171=='_'||(LA12_171 >= 'a' && LA12_171 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 178;
						 
						input.seek(index12_171);
						if ( s>=0 ) return s;
						break;

					case 83 : 
						int LA12_52 = input.LA(1);
						 
						int index12_52 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_52=='m') ) {s = 89;}
						else s = 28;
						 
						input.seek(index12_52);
						if ( s>=0 ) return s;
						break;

					case 84 : 
						int LA12_5 = input.LA(1);
						 
						int index12_5 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_5 >= '0' && LA12_5 <= '9')||(LA12_5 >= 'A' && LA12_5 <= 'Z')||LA12_5=='_'||(LA12_5 >= 'a' && LA12_5 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 58;}
						else if ( (LA12_5==' '||LA12_5=='.') && ((stringterm))) {s = 28;}
						else s = 59;
						 
						input.seek(index12_5);
						if ( s>=0 ) return s;
						break;

					case 85 : 
						int LA12_89 = input.LA(1);
						 
						int index12_89 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_89=='p') ) {s = 112;}
						else s = 28;
						 
						input.seek(index12_89);
						if ( s>=0 ) return s;
						break;

					case 86 : 
						int LA12_25 = input.LA(1);
						 
						int index12_25 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_25 >= '0' && LA12_25 <= '9')||(LA12_25 >= 'A' && LA12_25 <= 'Z')||LA12_25=='_'||(LA12_25 >= 'a' && LA12_25 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 65;}
						else if ( (LA12_25==' '||LA12_25=='.') && ((stringterm))) {s = 28;}
						else s = 64;
						 
						input.seek(index12_25);
						if ( s>=0 ) return s;
						break;

					case 87 : 
						int LA12_3 = input.LA(1);
						 
						int index12_3 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_3=='s') ) {s = 46;}
						else if ( (LA12_3=='r') ) {s = 47;}
						else if ( (LA12_3=='c') ) {s = 48;}
						else if ( (LA12_3=='q') ) {s = 49;}
						else if ( (LA12_3=='w') ) {s = 50;}
						else if ( (LA12_3=='p') ) {s = 51;}
						else if ( (LA12_3=='i') ) {s = 52;}
						else if ( (LA12_3=='B') && (((stringterm)||(curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)))) {s = 53;}
						else if ( (LA12_3=='G') && (((stringterm)||(curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)))) {s = 54;}
						else if ( (LA12_3=='l') ) {s = 55;}
						else if ( (LA12_3==' '||LA12_3=='.'||(LA12_3 >= '0' && LA12_3 <= '9')||LA12_3=='A'||(LA12_3 >= 'C' && LA12_3 <= 'F')||(LA12_3 >= 'H' && LA12_3 <= 'Z')||LA12_3=='_'||(LA12_3 >= 'a' && LA12_3 <= 'b')||(LA12_3 >= 'd' && LA12_3 <= 'h')||(LA12_3 >= 'j' && LA12_3 <= 'k')||(LA12_3 >= 'm' && LA12_3 <= 'o')||(LA12_3 >= 't' && LA12_3 <= 'v')||(LA12_3 >= 'x' && LA12_3 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 56;
						 
						input.seek(index12_3);
						if ( s>=0 ) return s;
						break;

					case 88 : 
						int LA12_130 = input.LA(1);
						 
						int index12_130 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting == 0)) ) {s = 146;}
						else if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 95;}
						 
						input.seek(index12_130);
						if ( s>=0 ) return s;
						break;

					case 89 : 
						int LA12_168 = input.LA(1);
						 
						int index12_168 = input.index();
						input.rewind();
						s = -1;
						if ( ((sq_nesting > 0)) ) {s = 174;}
						else if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 100;}
						 
						input.seek(index12_168);
						if ( s>=0 ) return s;
						break;

					case 90 : 
						int LA12_167 = input.LA(1);
						 
						int index12_167 = input.index();
						input.rewind();
						s = -1;
						if ( ((sq_nesting > 0)) ) {s = 173;}
						else if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 100;}
						 
						input.seek(index12_167);
						if ( s>=0 ) return s;
						break;

					case 91 : 
						int LA12_131 = input.LA(1);
						 
						int index12_131 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 147;}
						else if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 95;}
						 
						input.seek(index12_131);
						if ( s>=0 ) return s;
						break;

					case 92 : 
						int LA12_177 = input.LA(1);
						 
						int index12_177 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_177=='e') ) {s = 180;}
						else s = 28;
						 
						input.seek(index12_177);
						if ( s>=0 ) return s;
						break;

					case 93 : 
						int LA12_170 = input.LA(1);
						 
						int index12_170 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_170=='t') ) {s = 177;}
						else s = 28;
						 
						input.seek(index12_170);
						if ( s>=0 ) return s;
						break;

					case 94 : 
						int LA12_163 = input.LA(1);
						 
						int index12_163 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_163=='u') ) {s = 170;}
						else s = 28;
						 
						input.seek(index12_163);
						if ( s>=0 ) return s;
						break;

					case 95 : 
						int LA12_153 = input.LA(1);
						 
						int index12_153 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_153=='t') ) {s = 163;}
						else s = 28;
						 
						input.seek(index12_153);
						if ( s>=0 ) return s;
						break;

					case 96 : 
						int LA12_78 = input.LA(1);
						 
						int index12_78 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_78 >= '0' && LA12_78 <= '9')) && (((!stringterm)||(stringterm)))) {s = 78;}
						else if ( (LA12_78==' '||LA12_78=='.'||(LA12_78 >= 'A' && LA12_78 <= 'Z')||LA12_78=='_'||(LA12_78 >= 'a' && LA12_78 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 77;
						 
						input.seek(index12_78);
						if ( s>=0 ) return s;
						break;

					case 97 : 
						int LA12_50 = input.LA(1);
						 
						int index12_50 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_50=='a') ) {s = 87;}
						else s = 28;
						 
						input.seek(index12_50);
						if ( s>=0 ) return s;
						break;

					case 98 : 
						int LA12_87 = input.LA(1);
						 
						int index12_87 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_87=='i') ) {s = 110;}
						else s = 28;
						 
						input.seek(index12_87);
						if ( s>=0 ) return s;
						break;

					case 99 : 
						int LA12_110 = input.LA(1);
						 
						int index12_110 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_110=='t') ) {s = 126;}
						else s = 28;
						 
						input.seek(index12_110);
						if ( s>=0 ) return s;
						break;

					case 100 : 
						int LA12_179 = input.LA(1);
						 
						int index12_179 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_179==' '||LA12_179=='.'||(LA12_179 >= '0' && LA12_179 <= '9')||(LA12_179 >= 'A' && LA12_179 <= 'Z')||LA12_179=='_'||(LA12_179 >= 'a' && LA12_179 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 182;
						 
						input.seek(index12_179);
						if ( s>=0 ) return s;
						break;

					case 101 : 
						int LA12_49 = input.LA(1);
						 
						int index12_49 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_49=='u') ) {s = 86;}
						else s = 28;
						 
						input.seek(index12_49);
						if ( s>=0 ) return s;
						break;

					case 102 : 
						int LA12_86 = input.LA(1);
						 
						int index12_86 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_86=='e') ) {s = 109;}
						else s = 28;
						 
						input.seek(index12_86);
						if ( s>=0 ) return s;
						break;

					case 103 : 
						int LA12_109 = input.LA(1);
						 
						int index12_109 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_109=='r') ) {s = 125;}
						else s = 28;
						 
						input.seek(index12_109);
						if ( s>=0 ) return s;
						break;

					case 104 : 
						int LA12_125 = input.LA(1);
						 
						int index12_125 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_125=='y') ) {s = 141;}
						else s = 28;
						 
						input.seek(index12_125);
						if ( s>=0 ) return s;
						break;

					case 105 : 
						int LA12_57 = input.LA(1);
						 
						int index12_57 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 94;}
						else if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 95;}
						 
						input.seek(index12_57);
						if ( s>=0 ) return s;
						break;

					case 106 : 
						int LA12_59 = input.LA(1);
						 
						int index12_59 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 96;}
						else if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 95;}
						 
						input.seek(index12_59);
						if ( s>=0 ) return s;
						break;

					case 107 : 
						int LA12_88 = input.LA(1);
						 
						int index12_88 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_88=='a') ) {s = 111;}
						else s = 28;
						 
						input.seek(index12_88);
						if ( s>=0 ) return s;
						break;

					case 108 : 
						int LA12_51 = input.LA(1);
						 
						int index12_51 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_51=='l') ) {s = 88;}
						else s = 28;
						 
						input.seek(index12_51);
						if ( s>=0 ) return s;
						break;

					case 109 : 
						int LA12_111 = input.LA(1);
						 
						int index12_111 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_111=='n') ) {s = 127;}
						else s = 28;
						 
						input.seek(index12_111);
						if ( s>=0 ) return s;
						break;

					case 110 : 
						int LA12_141 = input.LA(1);
						 
						int index12_141 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_141==' '||LA12_141=='.'||(LA12_141 >= '0' && LA12_141 <= '9')||(LA12_141 >= 'A' && LA12_141 <= 'Z')||LA12_141=='_'||(LA12_141 >= 'a' && LA12_141 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 156;
						 
						input.seek(index12_141);
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
