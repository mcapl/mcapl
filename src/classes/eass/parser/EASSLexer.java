// $ANTLR 3.5.1 /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g 2015-07-03 15:09:33

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
	public static final int BAR=8;
	public static final int BELIEFRULES=9;
	public static final int BELIEFS=10;
	public static final int BELIEVE=11;
	public static final int BRULEARROW=12;
	public static final int CALCULATE=13;
	public static final int CAPABILITIES=14;
	public static final int CAPABILITY=15;
	public static final int CLOSE=16;
	public static final int COLON=17;
	public static final int COMMA=18;
	public static final int COMMENT=19;
	public static final int CONST=20;
	public static final int CURLYCLOSE=21;
	public static final int CURLYOPEN=22;
	public static final int DIV=23;
	public static final int DOUBLEQUOTE=24;
	public static final int EASS=25;
	public static final int EQ=26;
	public static final int EQ_ASSGN=27;
	public static final int GOAL=28;
	public static final int GOALS=29;
	public static final int IMPLICATION=30;
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
	public static final int PLAN=44;
	public static final int PLANS=45;
	public static final int PLUS=46;
	public static final int POINT=47;
	public static final int QUERY=48;
	public static final int QUERYCOM=49;
	public static final int RECEIVED=50;
	public static final int RULEARROW=51;
	public static final int SEMI=52;
	public static final int SEND=53;
	public static final int SENT=54;
	public static final int SHRIEK=55;
	public static final int SQCLOSE=56;
	public static final int SQOPEN=57;
	public static final int STRING=58;
	public static final int SUBSTITUTE=59;
	public static final int TELL=60;
	public static final int TRUE=61;
	public static final int UPDATE=62;
	public static final int VAR=63;
	public static final int WAIT=64;
	public static final int WS=65;

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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:9: ( '>' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:11: '>'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:182:6: ( ':tell' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:182:8: ':tell'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:183:9: ( ':perform' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:183:11: ':perform'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:184:9: ( ':achieve' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:184:11: ':achieve'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:185:6: ( '.send' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:185:8: '.send'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:186:9: ( '.received' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:186:11: '.received'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:2: ( '.calculate' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:4: '.calculate'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:10: ( '.query' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:12: '.query'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:190:6: ( '.wait' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:190:8: '.wait'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:191:12: ( '.cap' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:191:14: '.cap'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:192:6: ( '.plan' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:192:8: '.plan'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:193:13: ( '.imp' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:193:15: '.imp'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:195:2: ( '.substitute' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:195:4: '.substitute'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:9: ({...}? => ( 'B' | '.B' ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:11: {...}? => ( 'B' | '.B' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {
				throw new FailedPredicateException(input, "BELIEVE", "curly_nesting > 0 && plain_nesting == 0 || belief_rules==1");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:75: ( 'B' | '.B' )
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
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:76: 'B'
					{
					match('B'); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:82: '.B'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:6: ({...}? => ( 'G' | '.G' ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:8: {...}? => ( 'G' | '.G' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {
				throw new FailedPredicateException(input, "GOAL", "curly_nesting > 0 && plain_nesting == 0|| belief_rules==1");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:71: ( 'G' | '.G' )
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
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:72: 'G'
					{
					match('G'); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:78: '.G'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:198:6: ({...}? => '.sent' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:198:8: {...}? => '.sent'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:199:6: ( '.lock' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:199:8: '.lock'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:200:7: ( ':Initial Goals:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:200:9: ':Initial Goals:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:201:9: ( ':Initial Beliefs:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:201:11: ':Initial Beliefs:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:203:2: ( ':Reasoning Rules:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:203:4: ':Reasoning Rules:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:204:13: ( ':Capabilities:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:204:15: ':Capabilities:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:205:7: ( ':Plans:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:205:9: ':Plans:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:206:6: ({...}? => 'EASS' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:206:8: {...}? => 'EASS'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:207:6: ( ':name:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:207:8: ':name:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:209:2: ( ':abstraction:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:209:4: ':abstraction:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:210:6: ({...}? => 'True' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:210:8: {...}? => 'True'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:211:13: ({...}? => 'achieve' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:211:15: {...}? => 'achieve'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:212:13: ({...}? => 'perform' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:212:15: {...}? => 'perform'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:215:2: ( ':-' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:215:4: ':-'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:216:11: ( '<-' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:216:13: '<-'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:217:10: ( '=' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:217:12: '='
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:218:7: ( '->' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:218:9: '->'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:281:5: ( '/*' ( . )* '*/' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:281:7: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:281:12: ( . )*
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
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:281:12: .
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:12: (~ ( '\\n' | '\\r' ) )*
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

			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:26: ( '\\r' )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='\r') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:26: '\\r'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:286:8: ( ( '\\r' )? '\\n' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:286:9: ( '\\r' )? '\\n'
			{
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:286:9: ( '\\r' )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='\r') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:286:9: '\\r'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:287:5: ({...}? => ( ' ' | '\\t' )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:287:8: {...}? => ( ' ' | '\\t' )+
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "WS", "!stringterm");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:287:24: ( ' ' | '\\t' )+
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:290:6: ( '(' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:290:9: '('
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:291:7: ( ')' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:291:9: ')'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:292:8: ( '[' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:292:10: '['
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:293:9: ( ']' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:293:11: ']'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:294:11: ( '{' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:294:13: '{'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:295:12: ( '}' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:295:14: '}'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:297:2: ( '\"' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:297:4: '\"'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:299:5: ( '~' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:299:7: '~'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:301:8: ({...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:301:10: {...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' )+
			{
			if ( !((stringterm)) ) {
				throw new FailedPredicateException(input, "STRING", "stringterm");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:301:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' )+
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:302:8: ({...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:302:11: {...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "CONST", "!stringterm");
			}
			matchRange('a','z'); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:302:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:303:5: ({...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:303:7: {...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "VAR", "!stringterm");
			}
			matchRange('A','Z'); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:303:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:304:8: ({...}? => '0' .. '9' ( '0' .. '9' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:304:10: {...}? => '0' .. '9' ( '0' .. '9' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "NUMBER", "!stringterm");
			}
			matchRange('0','9'); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:304:35: ( '0' .. '9' )*
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:307:6: ( '<' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:307:8: '<'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:308:4: ( '==' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:308:7: '=='
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:309:7: ( '.' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:309:9: '.'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:310:6: ( '*' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:310:8: '*'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:311:6: ( '+' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:311:8: '+'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:312:7: ( '-' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:312:9: '-'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:313:5: ( '/' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:313:7: '/'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:314:5: ( '%' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:314:7: '%'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:316:8: ( '!' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:316:10: '!'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:317:7: ( ',' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:317:9: ','
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:318:6: ( ';' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:318:8: ';'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:319:7: ( ':' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:319:9: ':'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:320:7: ( '?' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:320:9: '?'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:321:5: ( '|' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:321:7: '|'
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
		// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:8: ( UPDATE | TELL | PERFORM | ACHIEVE | SEND | RECEIVED | CALCULATE | QUERYCOM | WAIT | CAPABILITY | PLAN | IMPLICATION | SUBSTITUTE | BELIEVE | GOAL | SENT | LOCK | GOALS | BELIEFS | BELIEFRULES | CAPABILITIES | PLANS | EASS | NAME | ABSTRACTION | TRUE | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | EQ_ASSGN | ARROW | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY | BAR )
		int alt12=62;
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
			case 62 :
				// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:457: BAR
				{
				mBAR(); 

				}
				break;

		}
	}


	protected DFA12 dfa12 = new DFA12(this);
	static final String DFA12_eotS =
		"\2\uffff\1\56\1\71\1\72\1\74\2\76\2\101\1\105\1\107\1\111\1\114\1\uffff"+
		"\1\115\11\uffff\1\101\1\76\1\116\23\uffff\7\34\1\133\1\134\1\34\2\uffff"+
		"\1\76\1\uffff\1\76\1\uffff\1\76\1\101\1\uffff\2\101\13\uffff\1\116\3\uffff"+
		"\10\34\2\uffff\1\34\4\uffff\2\76\1\101\1\uffff\1\101\2\uffff\4\34\1\175"+
		"\3\34\1\u0081\1\34\1\u0083\1\u0084\2\101\1\uffff\1\u0088\1\u0089\3\34"+
		"\1\uffff\1\34\1\u008f\1\u0090\1\uffff\1\u0092\2\uffff\2\101\3\uffff\3"+
		"\34\1\uffff\1\u009d\6\uffff\2\101\3\uffff\3\34\4\uffff\1\u00a8\1\u00a9"+
		"\1\uffff\3\34\4\uffff\1\34\1\u00b3\1\34\4\uffff\1\34\1\uffff\1\u00b7\1"+
		"\u00b8\5\uffff";
	static final String DFA12_eofS =
		"\u00bb\uffff";
	static final String DFA12_minS =
		"\1\11\1\uffff\1\55\7\40\1\55\1\75\1\76\1\52\1\uffff\1\11\11\uffff\3\40"+
		"\13\uffff\1\142\1\156\6\uffff\2\145\1\141\1\165\1\141\1\154\1\155\2\40"+
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
		"\3\172\13\uffff\1\143\1\156\6\uffff\1\165\1\145\1\141\1\165\1\141\1\154"+
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
		"\1\54\1\44\3\uffff\1\55\1\64\1\65\1\70\1\71\1\72\1\73\1\75\1\76\1\2\1"+
		"\3\2\uffff\1\24\1\25\1\26\1\30\1\35\1\74\25\uffff\1\36\1\61\1\62\1\37"+
		"\1\40\1\66\1\41\1\42\1\67\3\uffff\1\4\1\31\14\uffff\1\63\1\16\1\57\1\17"+
		"\3\uffff\1\56\1\uffff\1\60\45\uffff\1\12\3\uffff\1\14\1\uffff\1\27\1\32"+
		"\3\uffff\1\5\1\20\4\uffff\1\11\1\13\1\21\6\uffff\1\10\6\uffff\1\33\1\34"+
		"\1\22\1\23\4\uffff\1\6\2\uffff\1\7\1\15";
	static final String DFA12_specialS =
		"\1\55\2\uffff\1\24\1\50\1\61\1\100\1\131\1\66\1\72\5\uffff\1\12\11\uffff"+
		"\1\153\1\44\1\63\23\uffff\1\75\1\76\1\67\1\122\1\126\1\150\1\155\1\41"+
		"\1\45\1\36\1\23\1\52\1\64\1\53\1\27\1\16\1\42\1\13\1\14\1\46\1\26\11\uffff"+
		"\1\1\1\20\1\116\3\uffff\1\110\1\0\1\77\1\71\1\123\1\127\1\151\1\156\1"+
		"\144\1\145\1\37\4\uffff\1\31\1\43\1\15\1\uffff\1\30\2\uffff\1\112\1\2"+
		"\1\101\1\111\1\154\1\124\1\132\1\152\1\25\1\40\1\62\1\104\1\17\1\32\1"+
		"\uffff\1\65\1\47\1\3\1\102\1\113\1\140\1\125\1\135\1\5\1\142\1\51\1\54"+
		"\1\56\1\21\1\33\1\uffff\1\130\1\146\1\4\1\103\1\114\1\uffff\1\121\1\137"+
		"\1\141\1\uffff\1\147\2\uffff\1\22\1\34\3\uffff\1\6\1\105\1\115\1\136\3"+
		"\uffff\1\70\1\74\1\uffff\1\7\1\107\1\117\1\uffff\1\57\1\60\1\uffff\1\10"+
		"\1\73\1\120\4\uffff\1\11\1\133\1\106\1\35\1\uffff\1\134\1\143\2\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\30\1\16\2\uffff\1\16\22\uffff\1\17\1\40\1\26\2\uffff\1\37\2\uffff"+
			"\1\20\1\21\1\35\1\36\1\41\1\14\1\3\1\15\12\33\1\2\1\42\1\12\1\13\1\1"+
			"\1\43\1\uffff\1\32\1\4\2\32\1\6\1\32\1\5\14\32\1\7\6\32\1\22\1\uffff"+
			"\1\23\1\uffff\1\34\1\uffff\1\10\16\31\1\11\12\31\1\24\1\44\1\25\1\27",
			"",
			"\1\55\25\uffff\1\52\5\uffff\1\50\6\uffff\1\53\1\uffff\1\51\16\uffff"+
			"\1\47\14\uffff\1\54\1\uffff\1\46\3\uffff\1\45",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\1\34\1\66\4\34\1\67\23\34"+
			"\4\uffff\1\34\1\uffff\2\34\1\61\5\34\1\65\2\34\1\70\3\34\1\64\1\62\1"+
			"\60\1\57\3\34\1\63\3\34",
			"\1\34\15\uffff\1\34\1\uffff\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff"+
			"\32\73",
			"\1\34\15\uffff\1\34\1\uffff\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff"+
			"\32\73",
			"\1\34\15\uffff\1\34\1\uffff\12\73\7\uffff\1\75\31\73\4\uffff\1\73\1"+
			"\uffff\32\73",
			"\1\34\15\uffff\1\34\1\uffff\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff"+
			"\21\73\1\77\10\73",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\2\102\1\100\27\102",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\4\102\1\103\25\102",
			"\1\104",
			"\1\106",
			"\1\110",
			"\1\112\4\uffff\1\113",
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
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\32\102",
			"\1\34\15\uffff\1\34\1\uffff\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff"+
			"\32\73",
			"\1\34\15\uffff\1\34\1\uffff\12\117\7\uffff\32\34\4\uffff\1\34\1\uffff"+
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
			"",
			"\1\121\1\120",
			"\1\122",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\123\17\uffff\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\132",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\135",
			"\1\uffff",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff"+
			"\32\73",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\73\7\uffff\22\73\1\142\7\73\4\uffff\1"+
			"\73\1\uffff\32\73",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff"+
			"\24\73\1\143\5\73",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\7\102\1\144\22\102",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\32\102",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\21\102\1\146\10\102",
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
			"\1\34\15\uffff\1\34\1\uffff\12\117\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"",
			"",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\153",
			"\1\154\3\uffff\1\155",
			"\1\156",
			"\1\157",
			"\1\160",
			"\1\161",
			"\1\uffff",
			"\1\uffff",
			"\1\162",
			"",
			"",
			"",
			"",
			"\1\34\15\uffff\1\34\1\uffff\12\73\7\uffff\22\73\1\163\7\73\4\uffff\1"+
			"\73\1\uffff\32\73",
			"\1\34\15\uffff\1\34\1\uffff\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff"+
			"\4\73\1\164\25\73",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\10\102\1\165\21\102",
			"",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\5\102\1\166\24\102",
			"",
			"\1\167",
			"\1\170\17\uffff\1\171",
			"\1\172",
			"\1\173",
			"\1\174",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\176",
			"\1\177",
			"\1\u0080",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\u0082",
			"\1\34\15\uffff\1\34\1\uffff\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff"+
			"\32\73",
			"\1\34\15\uffff\1\34\1\uffff\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff"+
			"\32\73",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\4\102\1\u0085\25\102",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\16\102\1\u0086\13\102",
			"\1\u0087",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\u008a",
			"\1\u008b",
			"\1\u008c",
			"\1\uffff",
			"\1\u008e",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\uffff",
			"\1\uffff",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\25\102\1\u0095\4\102",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\21\102\1\u0096\10\102",
			"\1\u0097",
			"\1\uffff",
			"\1\uffff",
			"\1\u009a",
			"\1\u009b",
			"\1\u009c",
			"",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\uffff",
			"\1\uffff",
			"",
			"\1\uffff",
			"",
			"",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\4\102\1\u00a1\25\102",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\14\102\1\u00a2\15\102",
			"\1\u00a3",
			"",
			"",
			"\1\u00a4",
			"\1\u00a5",
			"\1\u00a6",
			"\1\uffff",
			"",
			"",
			"",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\32\102",
			"\1\34\15\uffff\1\34\1\uffff\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff"+
			"\32\102",
			"\1\u00aa",
			"\1\u00ab",
			"\1\u00ac",
			"\1\u00ad",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\u00b1\4\uffff\1\u00b0",
			"\1\u00b2",
			"\1\34\15\uffff\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff"+
			"\32\34",
			"\1\u00b4",
			"",
			"",
			"",
			"",
			"\1\u00b5",
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
			return "1:1: Tokens : ( UPDATE | TELL | PERFORM | ACHIEVE | SEND | RECEIVED | CALCULATE | QUERYCOM | WAIT | CAPABILITY | PLAN | IMPLICATION | SUBSTITUTE | BELIEVE | GOAL | SENT | LOCK | GOALS | BELIEFS | BELIEFRULES | CAPABILITIES | PLANS | EASS | NAME | ABSTRACTION | TRUE | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | EQ_ASSGN | ARROW | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY | BAR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA12_84 = input.LA(1);
						 
						int index12_84 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_84=='b') ) {s = 106;}
						else s = 28;
						 
						input.seek(index12_84);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA12_77 = input.LA(1);
						 
						int index12_77 = input.index();
						input.rewind();
						s = -1;
						if ( ((!stringterm)) ) {s = 24;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_77);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA12_106 = input.LA(1);
						 
						int index12_106 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_106=='s') ) {s = 122;}
						else s = 28;
						 
						input.seek(index12_106);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA12_122 = input.LA(1);
						 
						int index12_122 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_122=='t') ) {s = 138;}
						else s = 28;
						 
						input.seek(index12_122);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA12_138 = input.LA(1);
						 
						int index12_138 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_138=='i') ) {s = 154;}
						else s = 28;
						 
						input.seek(index12_138);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA12_128 = input.LA(1);
						 
						int index12_128 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_128==' '||LA12_128=='.'||(LA12_128 >= '0' && LA12_128 <= '9')||(LA12_128 >= 'A' && LA12_128 <= 'Z')||LA12_128=='_'||(LA12_128 >= 'a' && LA12_128 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 144;
						 
						input.seek(index12_128);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA12_154 = input.LA(1);
						 
						int index12_154 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_154=='t') ) {s = 164;}
						else s = 28;
						 
						input.seek(index12_154);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA12_164 = input.LA(1);
						 
						int index12_164 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_164=='u') ) {s = 171;}
						else s = 28;
						 
						input.seek(index12_164);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA12_171 = input.LA(1);
						 
						int index12_171 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_171=='t') ) {s = 178;}
						else s = 28;
						 
						input.seek(index12_171);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA12_178 = input.LA(1);
						 
						int index12_178 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_178=='e') ) {s = 181;}
						else s = 28;
						 
						input.seek(index12_178);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA12_15 = input.LA(1);
						 
						int index12_15 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_15==' ') && (((stringterm)||(!stringterm)))) {s = 15;}
						else if ( (LA12_15=='\t') && ((!stringterm))) {s = 24;}
						else if ( (LA12_15=='.'||(LA12_15 >= '0' && LA12_15 <= '9')||(LA12_15 >= 'A' && LA12_15 <= 'Z')||LA12_15=='_'||(LA12_15 >= 'a' && LA12_15 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 77;
						 
						input.seek(index12_15);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA12_64 = input.LA(1);
						 
						int index12_64 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_64=='h') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 100;}
						else if ( ((LA12_64 >= '0' && LA12_64 <= '9')||(LA12_64 >= 'A' && LA12_64 <= 'Z')||LA12_64=='_'||(LA12_64 >= 'a' && LA12_64 <= 'g')||(LA12_64 >= 'i' && LA12_64 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_64==' '||LA12_64=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_64);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA12_65 = input.LA(1);
						 
						int index12_65 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 101;}
						 
						input.seek(index12_65);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA12_100 = input.LA(1);
						 
						int index12_100 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_100=='i') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 117;}
						else if ( ((LA12_100 >= '0' && LA12_100 <= '9')||(LA12_100 >= 'A' && LA12_100 <= 'Z')||LA12_100=='_'||(LA12_100 >= 'a' && LA12_100 <= 'h')||(LA12_100 >= 'j' && LA12_100 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_100==' '||LA12_100=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_100);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA12_62 = input.LA(1);
						 
						int index12_62 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 96;}
						 
						input.seek(index12_62);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA12_117 = input.LA(1);
						 
						int index12_117 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_117=='e') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 133;}
						else if ( ((LA12_117 >= '0' && LA12_117 <= '9')||(LA12_117 >= 'A' && LA12_117 <= 'Z')||LA12_117=='_'||(LA12_117 >= 'a' && LA12_117 <= 'd')||(LA12_117 >= 'f' && LA12_117 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_117==' '||LA12_117=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_117);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA12_78 = input.LA(1);
						 
						int index12_78 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 103;}
						 
						input.seek(index12_78);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA12_133 = input.LA(1);
						 
						int index12_133 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_133=='v') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 149;}
						else if ( ((LA12_133 >= '0' && LA12_133 <= '9')||(LA12_133 >= 'A' && LA12_133 <= 'Z')||LA12_133=='_'||(LA12_133 >= 'a' && LA12_133 <= 'u')||(LA12_133 >= 'w' && LA12_133 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_133==' '||LA12_133=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_133);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA12_149 = input.LA(1);
						 
						int index12_149 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_149=='e') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 161;}
						else if ( ((LA12_149 >= '0' && LA12_149 <= '9')||(LA12_149 >= 'A' && LA12_149 <= 'Z')||LA12_149=='_'||(LA12_149 >= 'a' && LA12_149 <= 'd')||(LA12_149 >= 'f' && LA12_149 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_149==' '||LA12_149=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_149);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA12_57 = input.LA(1);
						 
						int index12_57 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 28;}
						else if ( (true) ) {s = 94;}
						 
						input.seek(index12_57);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA12_3 = input.LA(1);
						 
						int index12_3 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_3=='s') ) {s = 47;}
						else if ( (LA12_3=='r') ) {s = 48;}
						else if ( (LA12_3=='c') ) {s = 49;}
						else if ( (LA12_3=='q') ) {s = 50;}
						else if ( (LA12_3=='w') ) {s = 51;}
						else if ( (LA12_3=='p') ) {s = 52;}
						else if ( (LA12_3=='i') ) {s = 53;}
						else if ( (LA12_3=='B') && (((stringterm)||(curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)))) {s = 54;}
						else if ( (LA12_3=='G') && (((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)||(stringterm)))) {s = 55;}
						else if ( (LA12_3=='l') ) {s = 56;}
						else if ( (LA12_3==' '||LA12_3=='.'||(LA12_3 >= '0' && LA12_3 <= '9')||LA12_3=='A'||(LA12_3 >= 'C' && LA12_3 <= 'F')||(LA12_3 >= 'H' && LA12_3 <= 'Z')||LA12_3=='_'||(LA12_3 >= 'a' && LA12_3 <= 'b')||(LA12_3 >= 'd' && LA12_3 <= 'h')||(LA12_3 >= 'j' && LA12_3 <= 'k')||(LA12_3 >= 'm' && LA12_3 <= 'o')||(LA12_3 >= 't' && LA12_3 <= 'v')||(LA12_3 >= 'x' && LA12_3 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 57;
						 
						input.seek(index12_3);
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA12_113 = input.LA(1);
						 
						int index12_113 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_113==' '||LA12_113=='.'||(LA12_113 >= '0' && LA12_113 <= '9')||(LA12_113 >= 'A' && LA12_113 <= 'Z')||LA12_113=='_'||(LA12_113 >= 'a' && LA12_113 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 129;
						 
						input.seek(index12_113);
						if ( s>=0 ) return s;
						break;

					case 22 : 
						int LA12_67 = input.LA(1);
						 
						int index12_67 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_67=='r') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 102;}
						else if ( ((LA12_67 >= '0' && LA12_67 <= '9')||(LA12_67 >= 'A' && LA12_67 <= 'Z')||LA12_67=='_'||(LA12_67 >= 'a' && LA12_67 <= 'q')||(LA12_67 >= 's' && LA12_67 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_67==' '||LA12_67=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_67);
						if ( s>=0 ) return s;
						break;

					case 23 : 
						int LA12_61 = input.LA(1);
						 
						int index12_61 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_61=='S') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 98;}
						else if ( ((LA12_61 >= '0' && LA12_61 <= '9')||(LA12_61 >= 'A' && LA12_61 <= 'R')||(LA12_61 >= 'T' && LA12_61 <= 'Z')||LA12_61=='_'||(LA12_61 >= 'a' && LA12_61 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 59;}
						else if ( (LA12_61==' '||LA12_61=='.') && ((stringterm))) {s = 28;}
						else s = 62;
						 
						input.seek(index12_61);
						if ( s>=0 ) return s;
						break;

					case 24 : 
						int LA12_102 = input.LA(1);
						 
						int index12_102 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_102=='f') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 118;}
						else if ( ((LA12_102 >= '0' && LA12_102 <= '9')||(LA12_102 >= 'A' && LA12_102 <= 'Z')||LA12_102=='_'||(LA12_102 >= 'a' && LA12_102 <= 'e')||(LA12_102 >= 'g' && LA12_102 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_102==' '||LA12_102=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_102);
						if ( s>=0 ) return s;
						break;

					case 25 : 
						int LA12_98 = input.LA(1);
						 
						int index12_98 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_98=='S') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 115;}
						else if ( ((LA12_98 >= '0' && LA12_98 <= '9')||(LA12_98 >= 'A' && LA12_98 <= 'R')||(LA12_98 >= 'T' && LA12_98 <= 'Z')||LA12_98=='_'||(LA12_98 >= 'a' && LA12_98 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 59;}
						else if ( (LA12_98==' '||LA12_98=='.') && ((stringterm))) {s = 28;}
						else s = 62;
						 
						input.seek(index12_98);
						if ( s>=0 ) return s;
						break;

					case 26 : 
						int LA12_118 = input.LA(1);
						 
						int index12_118 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_118=='o') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 134;}
						else if ( ((LA12_118 >= '0' && LA12_118 <= '9')||(LA12_118 >= 'A' && LA12_118 <= 'Z')||LA12_118=='_'||(LA12_118 >= 'a' && LA12_118 <= 'n')||(LA12_118 >= 'p' && LA12_118 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_118==' '||LA12_118=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_118);
						if ( s>=0 ) return s;
						break;

					case 27 : 
						int LA12_134 = input.LA(1);
						 
						int index12_134 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_134=='r') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 150;}
						else if ( ((LA12_134 >= '0' && LA12_134 <= '9')||(LA12_134 >= 'A' && LA12_134 <= 'Z')||LA12_134=='_'||(LA12_134 >= 'a' && LA12_134 <= 'q')||(LA12_134 >= 's' && LA12_134 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_134==' '||LA12_134=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_134);
						if ( s>=0 ) return s;
						break;

					case 28 : 
						int LA12_150 = input.LA(1);
						 
						int index12_150 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_150=='m') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 162;}
						else if ( ((LA12_150 >= '0' && LA12_150 <= '9')||(LA12_150 >= 'A' && LA12_150 <= 'Z')||LA12_150=='_'||(LA12_150 >= 'a' && LA12_150 <= 'l')||(LA12_150 >= 'n' && LA12_150 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_150==' '||LA12_150=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_150);
						if ( s>=0 ) return s;
						break;

					case 29 : 
						int LA12_181 = input.LA(1);
						 
						int index12_181 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_181==' '||LA12_181=='.'||(LA12_181 >= '0' && LA12_181 <= '9')||(LA12_181 >= 'A' && LA12_181 <= 'Z')||LA12_181=='_'||(LA12_181 >= 'a' && LA12_181 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 184;
						 
						input.seek(index12_181);
						if ( s>=0 ) return s;
						break;

					case 30 : 
						int LA12_56 = input.LA(1);
						 
						int index12_56 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_56=='o') ) {s = 93;}
						else s = 28;
						 
						input.seek(index12_56);
						if ( s>=0 ) return s;
						break;

					case 31 : 
						int LA12_93 = input.LA(1);
						 
						int index12_93 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_93=='c') ) {s = 114;}
						else s = 28;
						 
						input.seek(index12_93);
						if ( s>=0 ) return s;
						break;

					case 32 : 
						int LA12_114 = input.LA(1);
						 
						int index12_114 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_114=='k') ) {s = 130;}
						else s = 28;
						 
						input.seek(index12_114);
						if ( s>=0 ) return s;
						break;

					case 33 : 
						int LA12_54 = input.LA(1);
						 
						int index12_54 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_54==' '||LA12_54=='.'||(LA12_54 >= '0' && LA12_54 <= '9')||(LA12_54 >= 'A' && LA12_54 <= 'Z')||LA12_54=='_'||(LA12_54 >= 'a' && LA12_54 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 91;
						 
						input.seek(index12_54);
						if ( s>=0 ) return s;
						break;

					case 34 : 
						int LA12_63 = input.LA(1);
						 
						int index12_63 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_63=='u') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 99;}
						else if ( ((LA12_63 >= '0' && LA12_63 <= '9')||(LA12_63 >= 'A' && LA12_63 <= 'Z')||LA12_63=='_'||(LA12_63 >= 'a' && LA12_63 <= 't')||(LA12_63 >= 'v' && LA12_63 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 59;}
						else if ( (LA12_63==' '||LA12_63=='.') && ((stringterm))) {s = 28;}
						else s = 62;
						 
						input.seek(index12_63);
						if ( s>=0 ) return s;
						break;

					case 35 : 
						int LA12_99 = input.LA(1);
						 
						int index12_99 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_99=='e') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 116;}
						else if ( ((LA12_99 >= '0' && LA12_99 <= '9')||(LA12_99 >= 'A' && LA12_99 <= 'Z')||LA12_99=='_'||(LA12_99 >= 'a' && LA12_99 <= 'd')||(LA12_99 >= 'f' && LA12_99 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 59;}
						else if ( (LA12_99==' '||LA12_99=='.') && ((stringterm))) {s = 28;}
						else s = 62;
						 
						input.seek(index12_99);
						if ( s>=0 ) return s;
						break;

					case 36 : 
						int LA12_26 = input.LA(1);
						 
						int index12_26 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_26 >= '0' && LA12_26 <= '9')||(LA12_26 >= 'A' && LA12_26 <= 'Z')||LA12_26=='_'||(LA12_26 >= 'a' && LA12_26 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 59;}
						else if ( (LA12_26==' '||LA12_26=='.') && ((stringterm))) {s = 28;}
						else s = 62;
						 
						input.seek(index12_26);
						if ( s>=0 ) return s;
						break;

					case 37 : 
						int LA12_55 = input.LA(1);
						 
						int index12_55 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_55==' '||LA12_55=='.'||(LA12_55 >= '0' && LA12_55 <= '9')||(LA12_55 >= 'A' && LA12_55 <= 'Z')||LA12_55=='_'||(LA12_55 >= 'a' && LA12_55 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 92;
						 
						input.seek(index12_55);
						if ( s>=0 ) return s;
						break;

					case 38 : 
						int LA12_66 = input.LA(1);
						 
						int index12_66 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_66 >= '0' && LA12_66 <= '9')||(LA12_66 >= 'A' && LA12_66 <= 'Z')||LA12_66=='_'||(LA12_66 >= 'a' && LA12_66 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_66==' '||LA12_66=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_66);
						if ( s>=0 ) return s;
						break;

					case 39 : 
						int LA12_121 = input.LA(1);
						 
						int index12_121 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_121==' '||LA12_121=='.'||(LA12_121 >= '0' && LA12_121 <= '9')||(LA12_121 >= 'A' && LA12_121 <= 'Z')||LA12_121=='_'||(LA12_121 >= 'a' && LA12_121 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 137;
						 
						input.seek(index12_121);
						if ( s>=0 ) return s;
						break;

					case 40 : 
						int LA12_4 = input.LA(1);
						 
						int index12_4 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_4 >= '0' && LA12_4 <= '9')||(LA12_4 >= 'A' && LA12_4 <= 'Z')||LA12_4=='_'||(LA12_4 >= 'a' && LA12_4 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 59;}
						else if ( (LA12_4==' '||LA12_4=='.') && ((stringterm))) {s = 28;}
						else s = 58;
						 
						input.seek(index12_4);
						if ( s>=0 ) return s;
						break;

					case 41 : 
						int LA12_130 = input.LA(1);
						 
						int index12_130 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_130==' '||LA12_130=='.'||(LA12_130 >= '0' && LA12_130 <= '9')||(LA12_130 >= 'A' && LA12_130 <= 'Z')||LA12_130=='_'||(LA12_130 >= 'a' && LA12_130 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 146;
						 
						input.seek(index12_130);
						if ( s>=0 ) return s;
						break;

					case 42 : 
						int LA12_58 = input.LA(1);
						 
						int index12_58 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 95;}
						else if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 96;}
						 
						input.seek(index12_58);
						if ( s>=0 ) return s;
						break;

					case 43 : 
						int LA12_60 = input.LA(1);
						 
						int index12_60 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 97;}
						else if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 96;}
						 
						input.seek(index12_60);
						if ( s>=0 ) return s;
						break;

					case 44 : 
						int LA12_131 = input.LA(1);
						 
						int index12_131 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting == 0)) ) {s = 147;}
						else if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 96;}
						 
						input.seek(index12_131);
						if ( s>=0 ) return s;
						break;

					case 45 : 
						int LA12_0 = input.LA(1);
						 
						int index12_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_0=='>') ) {s = 1;}
						else if ( (LA12_0==':') ) {s = 2;}
						else if ( (LA12_0=='.') ) {s = 3;}
						else if ( (LA12_0=='B') && (((stringterm)||(!stringterm)||(curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)))) {s = 4;}
						else if ( (LA12_0=='G') && (((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)||(stringterm)||(!stringterm)))) {s = 5;}
						else if ( (LA12_0=='E') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 6;}
						else if ( (LA12_0=='T') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 7;}
						else if ( (LA12_0=='a') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 8;}
						else if ( (LA12_0=='p') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 9;}
						else if ( (LA12_0=='<') ) {s = 10;}
						else if ( (LA12_0=='=') ) {s = 11;}
						else if ( (LA12_0=='-') ) {s = 12;}
						else if ( (LA12_0=='/') ) {s = 13;}
						else if ( (LA12_0=='\n'||LA12_0=='\r') ) {s = 14;}
						else if ( (LA12_0==' ') && (((stringterm)||(!stringterm)))) {s = 15;}
						else if ( (LA12_0=='(') ) {s = 16;}
						else if ( (LA12_0==')') ) {s = 17;}
						else if ( (LA12_0=='[') ) {s = 18;}
						else if ( (LA12_0==']') ) {s = 19;}
						else if ( (LA12_0=='{') ) {s = 20;}
						else if ( (LA12_0=='}') ) {s = 21;}
						else if ( (LA12_0=='\"') ) {s = 22;}
						else if ( (LA12_0=='~') ) {s = 23;}
						else if ( (LA12_0=='\t') && ((!stringterm))) {s = 24;}
						else if ( ((LA12_0 >= 'b' && LA12_0 <= 'o')||(LA12_0 >= 'q' && LA12_0 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 25;}
						else if ( (LA12_0=='A'||(LA12_0 >= 'C' && LA12_0 <= 'D')||LA12_0=='F'||(LA12_0 >= 'H' && LA12_0 <= 'S')||(LA12_0 >= 'U' && LA12_0 <= 'Z')) && (((stringterm)||(!stringterm)))) {s = 26;}
						else if ( ((LA12_0 >= '0' && LA12_0 <= '9')) && (((stringterm)||(!stringterm)))) {s = 27;}
						else if ( (LA12_0=='_') && ((stringterm))) {s = 28;}
						else if ( (LA12_0=='*') ) {s = 29;}
						else if ( (LA12_0=='+') ) {s = 30;}
						else if ( (LA12_0=='%') ) {s = 31;}
						else if ( (LA12_0=='!') ) {s = 32;}
						else if ( (LA12_0==',') ) {s = 33;}
						else if ( (LA12_0==';') ) {s = 34;}
						else if ( (LA12_0=='?') ) {s = 35;}
						else if ( (LA12_0=='|') ) {s = 36;}
						 
						input.seek(index12_0);
						if ( s>=0 ) return s;
						break;

					case 46 : 
						int LA12_132 = input.LA(1);
						 
						int index12_132 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 148;}
						else if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 96;}
						 
						input.seek(index12_132);
						if ( s>=0 ) return s;
						break;

					case 47 : 
						int LA12_168 = input.LA(1);
						 
						int index12_168 = input.index();
						input.rewind();
						s = -1;
						if ( ((sq_nesting > 0)) ) {s = 174;}
						else if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 101;}
						 
						input.seek(index12_168);
						if ( s>=0 ) return s;
						break;

					case 48 : 
						int LA12_169 = input.LA(1);
						 
						int index12_169 = input.index();
						input.rewind();
						s = -1;
						if ( ((sq_nesting > 0)) ) {s = 175;}
						else if ( ((stringterm)) ) {s = 28;}
						else if ( ((!stringterm)) ) {s = 101;}
						 
						input.seek(index12_169);
						if ( s>=0 ) return s;
						break;

					case 49 : 
						int LA12_5 = input.LA(1);
						 
						int index12_5 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_5 >= '0' && LA12_5 <= '9')||(LA12_5 >= 'A' && LA12_5 <= 'Z')||LA12_5=='_'||(LA12_5 >= 'a' && LA12_5 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 59;}
						else if ( (LA12_5==' '||LA12_5=='.') && ((stringterm))) {s = 28;}
						else s = 60;
						 
						input.seek(index12_5);
						if ( s>=0 ) return s;
						break;

					case 50 : 
						int LA12_115 = input.LA(1);
						 
						int index12_115 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_115 >= '0' && LA12_115 <= '9')||(LA12_115 >= 'A' && LA12_115 <= 'Z')||LA12_115=='_'||(LA12_115 >= 'a' && LA12_115 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 59;}
						else if ( (LA12_115==' '||LA12_115=='.') && ((stringterm))) {s = 28;}
						else s = 131;
						 
						input.seek(index12_115);
						if ( s>=0 ) return s;
						break;

					case 51 : 
						int LA12_27 = input.LA(1);
						 
						int index12_27 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_27 >= '0' && LA12_27 <= '9')) && (((stringterm)||(!stringterm)))) {s = 79;}
						else if ( (LA12_27==' '||LA12_27=='.'||(LA12_27 >= 'A' && LA12_27 <= 'Z')||LA12_27=='_'||(LA12_27 >= 'a' && LA12_27 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 78;
						 
						input.seek(index12_27);
						if ( s>=0 ) return s;
						break;

					case 52 : 
						int LA12_59 = input.LA(1);
						 
						int index12_59 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_59 >= '0' && LA12_59 <= '9')||(LA12_59 >= 'A' && LA12_59 <= 'Z')||LA12_59=='_'||(LA12_59 >= 'a' && LA12_59 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 59;}
						else if ( (LA12_59==' '||LA12_59=='.') && ((stringterm))) {s = 28;}
						else s = 62;
						 
						input.seek(index12_59);
						if ( s>=0 ) return s;
						break;

					case 53 : 
						int LA12_120 = input.LA(1);
						 
						int index12_120 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_120==' '||LA12_120=='.'||(LA12_120 >= '0' && LA12_120 <= '9')||(LA12_120 >= 'A' && LA12_120 <= 'Z')||LA12_120=='_'||(LA12_120 >= 'a' && LA12_120 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 136;
						 
						input.seek(index12_120);
						if ( s>=0 ) return s;
						break;

					case 54 : 
						int LA12_8 = input.LA(1);
						 
						int index12_8 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_8=='c') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 64;}
						else if ( ((LA12_8 >= '0' && LA12_8 <= '9')||(LA12_8 >= 'A' && LA12_8 <= 'Z')||LA12_8=='_'||(LA12_8 >= 'a' && LA12_8 <= 'b')||(LA12_8 >= 'd' && LA12_8 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_8==' '||LA12_8=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_8);
						if ( s>=0 ) return s;
						break;

					case 55 : 
						int LA12_49 = input.LA(1);
						 
						int index12_49 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_49=='a') ) {s = 86;}
						else s = 28;
						 
						input.seek(index12_49);
						if ( s>=0 ) return s;
						break;

					case 56 : 
						int LA12_161 = input.LA(1);
						 
						int index12_161 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_161 >= '0' && LA12_161 <= '9')||(LA12_161 >= 'A' && LA12_161 <= 'Z')||LA12_161=='_'||(LA12_161 >= 'a' && LA12_161 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_161==' '||LA12_161=='.') && ((stringterm))) {s = 28;}
						else s = 168;
						 
						input.seek(index12_161);
						if ( s>=0 ) return s;
						break;

					case 57 : 
						int LA12_86 = input.LA(1);
						 
						int index12_86 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_86=='l') ) {s = 108;}
						else if ( (LA12_86=='p') ) {s = 109;}
						else s = 28;
						 
						input.seek(index12_86);
						if ( s>=0 ) return s;
						break;

					case 58 : 
						int LA12_9 = input.LA(1);
						 
						int index12_9 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_9=='e') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 67;}
						else if ( ((LA12_9 >= '0' && LA12_9 <= '9')||(LA12_9 >= 'A' && LA12_9 <= 'Z')||LA12_9=='_'||(LA12_9 >= 'a' && LA12_9 <= 'd')||(LA12_9 >= 'f' && LA12_9 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_9==' '||LA12_9=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_9);
						if ( s>=0 ) return s;
						break;

					case 59 : 
						int LA12_172 = input.LA(1);
						 
						int index12_172 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_172==' '||LA12_172=='.'||(LA12_172 >= '0' && LA12_172 <= '9')||(LA12_172 >= 'A' && LA12_172 <= 'Z')||LA12_172=='_'||(LA12_172 >= 'a' && LA12_172 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 179;
						 
						input.seek(index12_172);
						if ( s>=0 ) return s;
						break;

					case 60 : 
						int LA12_162 = input.LA(1);
						 
						int index12_162 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_162 >= '0' && LA12_162 <= '9')||(LA12_162 >= 'A' && LA12_162 <= 'Z')||LA12_162=='_'||(LA12_162 >= 'a' && LA12_162 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_162==' '||LA12_162=='.') && ((stringterm))) {s = 28;}
						else s = 169;
						 
						input.seek(index12_162);
						if ( s>=0 ) return s;
						break;

					case 61 : 
						int LA12_47 = input.LA(1);
						 
						int index12_47 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_47=='e') ) {s = 83;}
						else if ( (LA12_47=='u') ) {s = 84;}
						else s = 28;
						 
						input.seek(index12_47);
						if ( s>=0 ) return s;
						break;

					case 62 : 
						int LA12_48 = input.LA(1);
						 
						int index12_48 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_48=='e') ) {s = 85;}
						else s = 28;
						 
						input.seek(index12_48);
						if ( s>=0 ) return s;
						break;

					case 63 : 
						int LA12_85 = input.LA(1);
						 
						int index12_85 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_85=='c') ) {s = 107;}
						else s = 28;
						 
						input.seek(index12_85);
						if ( s>=0 ) return s;
						break;

					case 64 : 
						int LA12_6 = input.LA(1);
						 
						int index12_6 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_6=='A') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 61;}
						else if ( ((LA12_6 >= '0' && LA12_6 <= '9')||(LA12_6 >= 'B' && LA12_6 <= 'Z')||LA12_6=='_'||(LA12_6 >= 'a' && LA12_6 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 59;}
						else if ( (LA12_6==' '||LA12_6=='.') && ((stringterm))) {s = 28;}
						else s = 62;
						 
						input.seek(index12_6);
						if ( s>=0 ) return s;
						break;

					case 65 : 
						int LA12_107 = input.LA(1);
						 
						int index12_107 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_107=='e') ) {s = 123;}
						else s = 28;
						 
						input.seek(index12_107);
						if ( s>=0 ) return s;
						break;

					case 66 : 
						int LA12_123 = input.LA(1);
						 
						int index12_123 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_123=='i') ) {s = 139;}
						else s = 28;
						 
						input.seek(index12_123);
						if ( s>=0 ) return s;
						break;

					case 67 : 
						int LA12_139 = input.LA(1);
						 
						int index12_139 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_139=='v') ) {s = 155;}
						else s = 28;
						 
						input.seek(index12_139);
						if ( s>=0 ) return s;
						break;

					case 68 : 
						int LA12_116 = input.LA(1);
						 
						int index12_116 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_116 >= '0' && LA12_116 <= '9')||(LA12_116 >= 'A' && LA12_116 <= 'Z')||LA12_116=='_'||(LA12_116 >= 'a' && LA12_116 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 59;}
						else if ( (LA12_116==' '||LA12_116=='.') && ((stringterm))) {s = 28;}
						else s = 132;
						 
						input.seek(index12_116);
						if ( s>=0 ) return s;
						break;

					case 69 : 
						int LA12_155 = input.LA(1);
						 
						int index12_155 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_155=='e') ) {s = 165;}
						else s = 28;
						 
						input.seek(index12_155);
						if ( s>=0 ) return s;
						break;

					case 70 : 
						int LA12_180 = input.LA(1);
						 
						int index12_180 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_180==' '||LA12_180=='.'||(LA12_180 >= '0' && LA12_180 <= '9')||(LA12_180 >= 'A' && LA12_180 <= 'Z')||LA12_180=='_'||(LA12_180 >= 'a' && LA12_180 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 183;
						 
						input.seek(index12_180);
						if ( s>=0 ) return s;
						break;

					case 71 : 
						int LA12_165 = input.LA(1);
						 
						int index12_165 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_165=='d') ) {s = 172;}
						else s = 28;
						 
						input.seek(index12_165);
						if ( s>=0 ) return s;
						break;

					case 72 : 
						int LA12_83 = input.LA(1);
						 
						int index12_83 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_83=='n') ) {s = 105;}
						else s = 28;
						 
						input.seek(index12_83);
						if ( s>=0 ) return s;
						break;

					case 73 : 
						int LA12_108 = input.LA(1);
						 
						int index12_108 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_108=='c') ) {s = 124;}
						else s = 28;
						 
						input.seek(index12_108);
						if ( s>=0 ) return s;
						break;

					case 74 : 
						int LA12_105 = input.LA(1);
						 
						int index12_105 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_105=='d') ) {s = 120;}
						else if ( (LA12_105=='t') && (((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)||(stringterm)))) {s = 121;}
						else s = 28;
						 
						input.seek(index12_105);
						if ( s>=0 ) return s;
						break;

					case 75 : 
						int LA12_124 = input.LA(1);
						 
						int index12_124 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_124=='u') ) {s = 140;}
						else s = 28;
						 
						input.seek(index12_124);
						if ( s>=0 ) return s;
						break;

					case 76 : 
						int LA12_140 = input.LA(1);
						 
						int index12_140 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_140=='l') ) {s = 156;}
						else s = 28;
						 
						input.seek(index12_140);
						if ( s>=0 ) return s;
						break;

					case 77 : 
						int LA12_156 = input.LA(1);
						 
						int index12_156 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_156=='a') ) {s = 166;}
						else s = 28;
						 
						input.seek(index12_156);
						if ( s>=0 ) return s;
						break;

					case 78 : 
						int LA12_79 = input.LA(1);
						 
						int index12_79 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_79 >= '0' && LA12_79 <= '9')) && (((stringterm)||(!stringterm)))) {s = 79;}
						else if ( (LA12_79==' '||LA12_79=='.'||(LA12_79 >= 'A' && LA12_79 <= 'Z')||LA12_79=='_'||(LA12_79 >= 'a' && LA12_79 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 78;
						 
						input.seek(index12_79);
						if ( s>=0 ) return s;
						break;

					case 79 : 
						int LA12_166 = input.LA(1);
						 
						int index12_166 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_166=='t') ) {s = 173;}
						else s = 28;
						 
						input.seek(index12_166);
						if ( s>=0 ) return s;
						break;

					case 80 : 
						int LA12_173 = input.LA(1);
						 
						int index12_173 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_173=='e') ) {s = 180;}
						else s = 28;
						 
						input.seek(index12_173);
						if ( s>=0 ) return s;
						break;

					case 81 : 
						int LA12_142 = input.LA(1);
						 
						int index12_142 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_142==' '||LA12_142=='.'||(LA12_142 >= '0' && LA12_142 <= '9')||(LA12_142 >= 'A' && LA12_142 <= 'Z')||LA12_142=='_'||(LA12_142 >= 'a' && LA12_142 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 157;
						 
						input.seek(index12_142);
						if ( s>=0 ) return s;
						break;

					case 82 : 
						int LA12_50 = input.LA(1);
						 
						int index12_50 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_50=='u') ) {s = 87;}
						else s = 28;
						 
						input.seek(index12_50);
						if ( s>=0 ) return s;
						break;

					case 83 : 
						int LA12_87 = input.LA(1);
						 
						int index12_87 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_87=='e') ) {s = 110;}
						else s = 28;
						 
						input.seek(index12_87);
						if ( s>=0 ) return s;
						break;

					case 84 : 
						int LA12_110 = input.LA(1);
						 
						int index12_110 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_110=='r') ) {s = 126;}
						else s = 28;
						 
						input.seek(index12_110);
						if ( s>=0 ) return s;
						break;

					case 85 : 
						int LA12_126 = input.LA(1);
						 
						int index12_126 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_126=='y') ) {s = 142;}
						else s = 28;
						 
						input.seek(index12_126);
						if ( s>=0 ) return s;
						break;

					case 86 : 
						int LA12_51 = input.LA(1);
						 
						int index12_51 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_51=='a') ) {s = 88;}
						else s = 28;
						 
						input.seek(index12_51);
						if ( s>=0 ) return s;
						break;

					case 87 : 
						int LA12_88 = input.LA(1);
						 
						int index12_88 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_88=='i') ) {s = 111;}
						else s = 28;
						 
						input.seek(index12_88);
						if ( s>=0 ) return s;
						break;

					case 88 : 
						int LA12_136 = input.LA(1);
						 
						int index12_136 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 152;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_136);
						if ( s>=0 ) return s;
						break;

					case 89 : 
						int LA12_7 = input.LA(1);
						 
						int index12_7 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_7=='r') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 63;}
						else if ( ((LA12_7 >= '0' && LA12_7 <= '9')||(LA12_7 >= 'A' && LA12_7 <= 'Z')||LA12_7=='_'||(LA12_7 >= 'a' && LA12_7 <= 'q')||(LA12_7 >= 's' && LA12_7 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 59;}
						else if ( (LA12_7==' '||LA12_7=='.') && ((stringterm))) {s = 28;}
						else s = 62;
						 
						input.seek(index12_7);
						if ( s>=0 ) return s;
						break;

					case 90 : 
						int LA12_111 = input.LA(1);
						 
						int index12_111 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_111=='t') ) {s = 127;}
						else s = 28;
						 
						input.seek(index12_111);
						if ( s>=0 ) return s;
						break;

					case 91 : 
						int LA12_179 = input.LA(1);
						 
						int index12_179 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 182;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_179);
						if ( s>=0 ) return s;
						break;

					case 92 : 
						int LA12_183 = input.LA(1);
						 
						int index12_183 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 185;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_183);
						if ( s>=0 ) return s;
						break;

					case 93 : 
						int LA12_127 = input.LA(1);
						 
						int index12_127 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_127==' '||LA12_127=='.'||(LA12_127 >= '0' && LA12_127 <= '9')||(LA12_127 >= 'A' && LA12_127 <= 'Z')||LA12_127=='_'||(LA12_127 >= 'a' && LA12_127 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 143;
						 
						input.seek(index12_127);
						if ( s>=0 ) return s;
						break;

					case 94 : 
						int LA12_157 = input.LA(1);
						 
						int index12_157 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 167;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_157);
						if ( s>=0 ) return s;
						break;

					case 95 : 
						int LA12_143 = input.LA(1);
						 
						int index12_143 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 158;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_143);
						if ( s>=0 ) return s;
						break;

					case 96 : 
						int LA12_125 = input.LA(1);
						 
						int index12_125 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 141;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_125);
						if ( s>=0 ) return s;
						break;

					case 97 : 
						int LA12_144 = input.LA(1);
						 
						int index12_144 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 159;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_144);
						if ( s>=0 ) return s;
						break;

					case 98 : 
						int LA12_129 = input.LA(1);
						 
						int index12_129 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 145;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_129);
						if ( s>=0 ) return s;
						break;

					case 99 : 
						int LA12_184 = input.LA(1);
						 
						int index12_184 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 186;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_184);
						if ( s>=0 ) return s;
						break;

					case 100 : 
						int LA12_91 = input.LA(1);
						 
						int index12_91 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 95;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_91);
						if ( s>=0 ) return s;
						break;

					case 101 : 
						int LA12_92 = input.LA(1);
						 
						int index12_92 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 97;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_92);
						if ( s>=0 ) return s;
						break;

					case 102 : 
						int LA12_137 = input.LA(1);
						 
						int index12_137 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 153;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_137);
						if ( s>=0 ) return s;
						break;

					case 103 : 
						int LA12_146 = input.LA(1);
						 
						int index12_146 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 160;}
						else if ( ((stringterm)) ) {s = 28;}
						 
						input.seek(index12_146);
						if ( s>=0 ) return s;
						break;

					case 104 : 
						int LA12_52 = input.LA(1);
						 
						int index12_52 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_52=='l') ) {s = 89;}
						else s = 28;
						 
						input.seek(index12_52);
						if ( s>=0 ) return s;
						break;

					case 105 : 
						int LA12_89 = input.LA(1);
						 
						int index12_89 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_89=='a') ) {s = 112;}
						else s = 28;
						 
						input.seek(index12_89);
						if ( s>=0 ) return s;
						break;

					case 106 : 
						int LA12_112 = input.LA(1);
						 
						int index12_112 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_112=='n') ) {s = 128;}
						else s = 28;
						 
						input.seek(index12_112);
						if ( s>=0 ) return s;
						break;

					case 107 : 
						int LA12_25 = input.LA(1);
						 
						int index12_25 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_25 >= '0' && LA12_25 <= '9')||(LA12_25 >= 'A' && LA12_25 <= 'Z')||LA12_25=='_'||(LA12_25 >= 'a' && LA12_25 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 66;}
						else if ( (LA12_25==' '||LA12_25=='.') && ((stringterm))) {s = 28;}
						else s = 65;
						 
						input.seek(index12_25);
						if ( s>=0 ) return s;
						break;

					case 108 : 
						int LA12_109 = input.LA(1);
						 
						int index12_109 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_109==' '||LA12_109=='.'||(LA12_109 >= '0' && LA12_109 <= '9')||(LA12_109 >= 'A' && LA12_109 <= 'Z')||LA12_109=='_'||(LA12_109 >= 'a' && LA12_109 <= 'z')) && ((stringterm))) {s = 28;}
						else s = 125;
						 
						input.seek(index12_109);
						if ( s>=0 ) return s;
						break;

					case 109 : 
						int LA12_53 = input.LA(1);
						 
						int index12_53 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_53=='m') ) {s = 90;}
						else s = 28;
						 
						input.seek(index12_53);
						if ( s>=0 ) return s;
						break;

					case 110 : 
						int LA12_90 = input.LA(1);
						 
						int index12_90 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_90=='p') ) {s = 113;}
						else s = 28;
						 
						input.seek(index12_90);
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
