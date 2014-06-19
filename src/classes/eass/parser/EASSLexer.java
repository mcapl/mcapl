// $ANTLR 3.5.1 /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g 2014-06-19 15:22:57

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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:172:9: ( '>' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:172:11: '>'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:173:6: ( ':tell' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:173:8: ':tell'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:174:9: ( ':perform' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:174:11: ':perform'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:175:9: ( ':achieve' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:175:11: ':achieve'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:176:6: ( '.send' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:176:8: '.send'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:177:9: ( '.received' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:177:11: '.received'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:179:2: ( '.calculate' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:179:4: '.calculate'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:180:10: ( '.query' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:180:12: '.query'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:6: ( '.wait' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:8: '.wait'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:182:12: ( '.cap' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:182:14: '.cap'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:183:6: ( '.plan' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:183:8: '.plan'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:184:13: ( '.imp' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:184:15: '.imp'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:186:2: ( '.substitute' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:186:4: '.substitute'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:187:9: ({...}? => ( 'B' | '.B' ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:187:11: {...}? => ( 'B' | '.B' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {
				throw new FailedPredicateException(input, "BELIEVE", "curly_nesting > 0 && plain_nesting == 0 || belief_rules==1");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:187:75: ( 'B' | '.B' )
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
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:187:76: 'B'
					{
					match('B'); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:187:82: '.B'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:6: ({...}? => ( 'G' | '.G' ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:8: {...}? => ( 'G' | '.G' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {
				throw new FailedPredicateException(input, "GOAL", "curly_nesting > 0 && plain_nesting == 0|| belief_rules==1");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:71: ( 'G' | '.G' )
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
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:72: 'G'
					{
					match('G'); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:78: '.G'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:6: ({...}? => '.sent' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:8: {...}? => '.sent'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:190:6: ( '.lock' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:190:8: '.lock'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:191:7: ( ':Initial Goals:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:191:9: ':Initial Goals:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:192:9: ( ':Initial Beliefs:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:192:11: ':Initial Beliefs:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:194:2: ( ':Reasoning Rules:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:194:4: ':Reasoning Rules:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:195:13: ( ':Capabilities:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:195:15: ':Capabilities:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:7: ( ':Plans:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:9: ':Plans:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:6: ({...}? => 'EASS' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:8: {...}? => 'EASS'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:198:6: ( ':name:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:198:8: ':name:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:200:2: ( ':abstraction:' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:200:4: ':abstraction:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:201:6: ({...}? => 'True' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:201:8: {...}? => 'True'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:202:13: ({...}? => 'achieve' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:202:15: {...}? => 'achieve'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:203:13: ({...}? => 'perform' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:203:15: {...}? => 'perform'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:206:2: ( ':-' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:206:4: ':-'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:207:11: ( '<-' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:207:13: '<-'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:208:10: ( '=' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:208:12: '='
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:209:7: ( '->' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:209:9: '->'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:5: ( '/*' ( . )* '*/' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:7: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:12: ( . )*
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
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:12: .
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:12: (~ ( '\\n' | '\\r' ) )*
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

			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:26: ( '\\r' )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='\r') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:26: '\\r'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:267:8: ( ( '\\r' )? '\\n' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:267:9: ( '\\r' )? '\\n'
			{
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:267:9: ( '\\r' )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='\r') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:267:9: '\\r'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:268:5: ( ( ' ' | '\\t' )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:268:9: ( ' ' | '\\t' )+
			{
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:268:9: ( ' ' | '\\t' )+
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:271:6: ( '(' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:271:9: '('
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:272:7: ( ')' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:272:9: ')'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:273:8: ( '[' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:273:10: '['
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:274:9: ( ']' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:274:11: ']'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:275:11: ( '{' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:275:13: '{'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:276:12: ( '}' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:276:14: '}'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:278:2: ( '\"' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:278:4: '\"'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:280:5: ( '~' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:280:7: '~'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:282:8: ({...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:282:10: {...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
			{
			if ( !((stringterm)) ) {
				throw new FailedPredicateException(input, "STRING", "stringterm");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:282:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}

				switch (alt8) {
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:283:8: ({...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:283:11: {...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "CONST", "!stringterm");
			}
			matchRange('a','z'); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:283:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:5: ({...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:7: {...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "VAR", "!stringterm");
			}
			matchRange('A','Z'); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:285:8: ({...}? => '0' .. '9' ( '0' .. '9' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:285:10: {...}? => '0' .. '9' ( '0' .. '9' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "NUMBER", "!stringterm");
			}
			matchRange('0','9'); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:285:35: ( '0' .. '9' )*
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:288:6: ( '<' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:288:8: '<'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:289:4: ( '==' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:289:7: '=='
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:290:7: ( '.' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:290:9: '.'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:291:6: ( '*' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:291:8: '*'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:292:6: ( '+' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:292:8: '+'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:293:7: ( '-' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:293:9: '-'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:294:5: ( '/' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:294:7: '/'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:295:5: ( '%' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:295:7: '%'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:297:8: ( '!' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:297:10: '!'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:298:7: ( ',' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:298:9: ','
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:299:6: ( ';' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:299:8: ';'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:300:7: ( ':' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:300:9: ':'
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
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:301:7: ( '?' )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:301:9: '?'
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
		"\2\uffff\1\54\1\67\1\70\1\72\2\74\2\77\1\103\1\105\1\107\1\112\12\uffff"+
		"\1\77\1\74\1\113\36\uffff\1\74\1\uffff\1\74\1\uffff\1\74\1\77\1\uffff"+
		"\2\77\12\uffff\1\113\7\uffff\2\74\1\77\1\uffff\1\77\5\uffff\1\145\1\146"+
		"\2\77\5\uffff\2\77\3\uffff\2\77\1\uffff\1\162\1\163\10\uffff";
	static final String DFA12_eofS =
		"\171\uffff";
	static final String DFA12_minS =
		"\1\11\1\uffff\1\55\1\102\6\60\1\55\1\75\1\76\1\52\12\uffff\3\60\12\uffff"+
		"\1\142\1\156\6\uffff\1\145\1\uffff\1\141\10\uffff\1\0\1\60\1\0\1\60\1"+
		"\0\2\60\1\0\2\60\11\uffff\1\0\1\60\2\uffff\1\151\1\156\1\uffff\1\154\1"+
		"\uffff\3\60\1\uffff\1\60\1\uffff\1\164\1\144\2\uffff\4\60\1\151\2\uffff"+
		"\2\0\2\60\1\141\2\uffff\2\60\1\154\2\60\1\40\2\0\1\102\4\uffff";
	static final String DFA12_maxS =
		"\1\176\1\uffff\1\164\1\167\6\172\1\55\1\75\1\76\1\57\12\uffff\3\172\12"+
		"\uffff\1\143\1\156\6\uffff\1\165\1\uffff\1\141\10\uffff\1\0\1\172\1\0"+
		"\1\172\1\0\2\172\1\0\2\172\11\uffff\1\0\1\172\2\uffff\1\151\1\156\1\uffff"+
		"\1\160\1\uffff\3\172\1\uffff\1\172\1\uffff\2\164\2\uffff\4\172\1\151\2"+
		"\uffff\2\0\2\172\1\141\2\uffff\2\172\1\154\2\172\1\40\2\0\1\107\4\uffff";
	static final String DFA12_acceptS =
		"\1\uffff\1\1\14\uffff\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54"+
		"\3\uffff\1\55\1\64\1\65\1\70\1\71\1\72\1\73\1\75\1\2\1\3\2\uffff\1\24"+
		"\1\25\1\26\1\30\1\35\1\74\1\uffff\1\6\1\uffff\1\10\1\11\1\13\1\14\1\16"+
		"\1\17\1\21\1\63\12\uffff\1\36\1\61\1\62\1\37\1\40\1\66\1\41\1\42\1\67"+
		"\2\uffff\1\4\1\31\2\uffff\1\15\1\uffff\1\57\3\uffff\1\56\1\uffff\1\60"+
		"\2\uffff\1\7\1\12\5\uffff\1\5\1\20\5\uffff\1\27\1\32\11\uffff\1\33\1\34"+
		"\1\22\1\23";
	static final String DFA12_specialS =
		"\1\2\2\uffff\1\33\1\16\1\35\1\3\1\40\1\6\1\5\16\uffff\1\34\1\51\1\1\35"+
		"\uffff\1\46\1\0\1\50\1\11\1\24\1\32\1\21\1\27\1\4\1\10\11\uffff\1\25\1"+
		"\45\7\uffff\1\14\1\31\1\20\1\uffff\1\12\2\uffff\1\36\2\uffff\1\47\1\30"+
		"\1\23\1\13\3\uffff\1\43\1\42\1\22\1\15\3\uffff\1\17\1\7\1\uffff\1\26\1"+
		"\37\1\uffff\1\41\1\44\5\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\17\1\16\2\uffff\1\16\22\uffff\1\17\1\37\1\26\2\uffff\1\36\2\uffff"+
			"\1\20\1\21\1\34\1\35\1\40\1\14\1\3\1\15\12\32\1\2\1\41\1\12\1\13\1\1"+
			"\1\42\1\uffff\1\31\1\4\2\31\1\6\1\31\1\5\14\31\1\7\6\31\1\22\1\uffff"+
			"\1\23\1\uffff\1\33\1\uffff\1\10\16\30\1\11\12\30\1\24\1\uffff\1\25\1"+
			"\27",
			"",
			"\1\53\25\uffff\1\50\5\uffff\1\46\6\uffff\1\51\1\uffff\1\47\16\uffff"+
			"\1\45\14\uffff\1\52\1\uffff\1\44\3\uffff\1\43",
			"\1\64\4\uffff\1\65\33\uffff\1\57\5\uffff\1\63\2\uffff\1\66\3\uffff\1"+
			"\62\1\60\1\56\1\55\3\uffff\1\61",
			"\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\12\71\7\uffff\1\73\31\71\4\uffff\1\71\1\uffff\32\71",
			"\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\21\71\1\75\10\71",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\2\100\1\76\27\100",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\4\100\1\101\25\100",
			"\1\102",
			"\1\104",
			"\1\106",
			"\1\110\4\uffff\1\111",
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
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
			"\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\12\114\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
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
			"\1\116\1\115",
			"\1\117",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\120\17\uffff\1\121",
			"",
			"\1\122",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\1\uffff",
			"\12\71\7\uffff\22\71\1\124\7\71\4\uffff\1\71\1\uffff\32\71",
			"\1\uffff",
			"\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\24\71\1\125\5\71",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\7\100\1\126\22\100",
			"\1\uffff",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\21\100\1\130\10\100",
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
			"\12\114\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
			"",
			"",
			"\1\132",
			"\1\133",
			"",
			"\1\134\3\uffff\1\135",
			"",
			"\12\71\7\uffff\22\71\1\136\7\71\4\uffff\1\71\1\uffff\32\71",
			"\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\4\71\1\137\25\71",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\10\100\1\140\21\100",
			"",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\5\100\1\141\24\100",
			"",
			"\1\142",
			"\1\143\17\uffff\1\144",
			"",
			"",
			"\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\4\100\1\147\25\100",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\16\100\1\150\13\100",
			"\1\151",
			"",
			"",
			"\1\uffff",
			"\1\uffff",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\25\100\1\154\4\100",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\21\100\1\155\10\100",
			"\1\156",
			"",
			"",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\4\100\1\157\25\100",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\14\100\1\160\15\100",
			"\1\161",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
			"\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
			"\1\164",
			"\1\uffff",
			"\1\uffff",
			"\1\170\4\uffff\1\167",
			"",
			"",
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
						int LA12_57 = input.LA(1);
						 
						int index12_57 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_57 >= '0' && LA12_57 <= '9')||(LA12_57 >= 'A' && LA12_57 <= 'Z')||LA12_57=='_'||(LA12_57 >= 'a' && LA12_57 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 57;}
						else s = 60;
						 
						input.seek(index12_57);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA12_26 = input.LA(1);
						 
						int index12_26 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_26 >= '0' && LA12_26 <= '9')) && (((!stringterm)||(stringterm)))) {s = 76;}
						else if ( ((LA12_26 >= 'A' && LA12_26 <= 'Z')||LA12_26=='_'||(LA12_26 >= 'a' && LA12_26 <= 'z')) && ((stringterm))) {s = 27;}
						else s = 75;
						 
						input.seek(index12_26);
						if ( s>=0 ) return s;
						break;

					case 2 : 
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
						else if ( (LA12_0=='\t'||LA12_0==' ') ) {s = 15;}
						else if ( (LA12_0=='(') ) {s = 16;}
						else if ( (LA12_0==')') ) {s = 17;}
						else if ( (LA12_0=='[') ) {s = 18;}
						else if ( (LA12_0==']') ) {s = 19;}
						else if ( (LA12_0=='{') ) {s = 20;}
						else if ( (LA12_0=='}') ) {s = 21;}
						else if ( (LA12_0=='\"') ) {s = 22;}
						else if ( (LA12_0=='~') ) {s = 23;}
						else if ( ((LA12_0 >= 'b' && LA12_0 <= 'o')||(LA12_0 >= 'q' && LA12_0 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 24;}
						else if ( (LA12_0=='A'||(LA12_0 >= 'C' && LA12_0 <= 'D')||LA12_0=='F'||(LA12_0 >= 'H' && LA12_0 <= 'S')||(LA12_0 >= 'U' && LA12_0 <= 'Z')) && (((!stringterm)||(stringterm)))) {s = 25;}
						else if ( ((LA12_0 >= '0' && LA12_0 <= '9')) && (((!stringterm)||(stringterm)))) {s = 26;}
						else if ( (LA12_0=='_') && ((stringterm))) {s = 27;}
						else if ( (LA12_0=='*') ) {s = 28;}
						else if ( (LA12_0=='+') ) {s = 29;}
						else if ( (LA12_0=='%') ) {s = 30;}
						else if ( (LA12_0=='!') ) {s = 31;}
						else if ( (LA12_0==',') ) {s = 32;}
						else if ( (LA12_0==';') ) {s = 33;}
						else if ( (LA12_0=='?') ) {s = 34;}
						 
						input.seek(index12_0);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA12_6 = input.LA(1);
						 
						int index12_6 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_6=='A') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 59;}
						else if ( ((LA12_6 >= '0' && LA12_6 <= '9')||(LA12_6 >= 'B' && LA12_6 <= 'Z')||LA12_6=='_'||(LA12_6 >= 'a' && LA12_6 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 57;}
						else s = 60;
						 
						input.seek(index12_6);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA12_64 = input.LA(1);
						 
						int index12_64 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_64 >= '0' && LA12_64 <= '9')||(LA12_64 >= 'A' && LA12_64 <= 'Z')||LA12_64=='_'||(LA12_64 >= 'a' && LA12_64 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_64);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA12_9 = input.LA(1);
						 
						int index12_9 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_9=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 65;}
						else if ( ((LA12_9 >= '0' && LA12_9 <= '9')||(LA12_9 >= 'A' && LA12_9 <= 'Z')||LA12_9=='_'||(LA12_9 >= 'a' && LA12_9 <= 'd')||(LA12_9 >= 'f' && LA12_9 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_9);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA12_8 = input.LA(1);
						 
						int index12_8 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_8=='c') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 62;}
						else if ( ((LA12_8 >= '0' && LA12_8 <= '9')||(LA12_8 >= 'A' && LA12_8 <= 'Z')||LA12_8=='_'||(LA12_8 >= 'a' && LA12_8 <= 'b')||(LA12_8 >= 'd' && LA12_8 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_8);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA12_109 = input.LA(1);
						 
						int index12_109 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_109=='m') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 112;}
						else if ( ((LA12_109 >= '0' && LA12_109 <= '9')||(LA12_109 >= 'A' && LA12_109 <= 'Z')||LA12_109=='_'||(LA12_109 >= 'a' && LA12_109 <= 'l')||(LA12_109 >= 'n' && LA12_109 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_109);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA12_65 = input.LA(1);
						 
						int index12_65 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_65=='r') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 88;}
						else if ( ((LA12_65 >= '0' && LA12_65 <= '9')||(LA12_65 >= 'A' && LA12_65 <= 'Z')||LA12_65=='_'||(LA12_65 >= 'a' && LA12_65 <= 'q')||(LA12_65 >= 's' && LA12_65 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_65);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA12_59 = input.LA(1);
						 
						int index12_59 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_59=='S') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 84;}
						else if ( ((LA12_59 >= '0' && LA12_59 <= '9')||(LA12_59 >= 'A' && LA12_59 <= 'R')||(LA12_59 >= 'T' && LA12_59 <= 'Z')||LA12_59=='_'||(LA12_59 >= 'a' && LA12_59 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 57;}
						else s = 60;
						 
						input.seek(index12_59);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA12_88 = input.LA(1);
						 
						int index12_88 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_88=='f') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 97;}
						else if ( ((LA12_88 >= '0' && LA12_88 <= '9')||(LA12_88 >= 'A' && LA12_88 <= 'Z')||LA12_88=='_'||(LA12_88 >= 'a' && LA12_88 <= 'e')||(LA12_88 >= 'g' && LA12_88 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_88);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA12_97 = input.LA(1);
						 
						int index12_97 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_97=='o') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 104;}
						else if ( ((LA12_97 >= '0' && LA12_97 <= '9')||(LA12_97 >= 'A' && LA12_97 <= 'Z')||LA12_97=='_'||(LA12_97 >= 'a' && LA12_97 <= 'n')||(LA12_97 >= 'p' && LA12_97 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_97);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA12_84 = input.LA(1);
						 
						int index12_84 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_84=='S') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 94;}
						else if ( ((LA12_84 >= '0' && LA12_84 <= '9')||(LA12_84 >= 'A' && LA12_84 <= 'R')||(LA12_84 >= 'T' && LA12_84 <= 'Z')||LA12_84=='_'||(LA12_84 >= 'a' && LA12_84 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 57;}
						else s = 60;
						 
						input.seek(index12_84);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA12_104 = input.LA(1);
						 
						int index12_104 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_104=='r') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 109;}
						else if ( ((LA12_104 >= '0' && LA12_104 <= '9')||(LA12_104 >= 'A' && LA12_104 <= 'Z')||LA12_104=='_'||(LA12_104 >= 'a' && LA12_104 <= 'q')||(LA12_104 >= 's' && LA12_104 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_104);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA12_4 = input.LA(1);
						 
						int index12_4 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_4 >= '0' && LA12_4 <= '9')||(LA12_4 >= 'A' && LA12_4 <= 'Z')||LA12_4=='_'||(LA12_4 >= 'a' && LA12_4 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 57;}
						else s = 56;
						 
						input.seek(index12_4);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA12_108 = input.LA(1);
						 
						int index12_108 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_108=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 111;}
						else if ( ((LA12_108 >= '0' && LA12_108 <= '9')||(LA12_108 >= 'A' && LA12_108 <= 'Z')||LA12_108=='_'||(LA12_108 >= 'a' && LA12_108 <= 'd')||(LA12_108 >= 'f' && LA12_108 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_108);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA12_86 = input.LA(1);
						 
						int index12_86 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_86=='i') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 96;}
						else if ( ((LA12_86 >= '0' && LA12_86 <= '9')||(LA12_86 >= 'A' && LA12_86 <= 'Z')||LA12_86=='_'||(LA12_86 >= 'a' && LA12_86 <= 'h')||(LA12_86 >= 'j' && LA12_86 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_86);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA12_62 = input.LA(1);
						 
						int index12_62 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_62=='h') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 86;}
						else if ( ((LA12_62 >= '0' && LA12_62 <= '9')||(LA12_62 >= 'A' && LA12_62 <= 'Z')||LA12_62=='_'||(LA12_62 >= 'a' && LA12_62 <= 'g')||(LA12_62 >= 'i' && LA12_62 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_62);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA12_103 = input.LA(1);
						 
						int index12_103 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_103=='v') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 108;}
						else if ( ((LA12_103 >= '0' && LA12_103 <= '9')||(LA12_103 >= 'A' && LA12_103 <= 'Z')||LA12_103=='_'||(LA12_103 >= 'a' && LA12_103 <= 'u')||(LA12_103 >= 'w' && LA12_103 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_103);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA12_96 = input.LA(1);
						 
						int index12_96 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_96=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 103;}
						else if ( ((LA12_96 >= '0' && LA12_96 <= '9')||(LA12_96 >= 'A' && LA12_96 <= 'Z')||LA12_96=='_'||(LA12_96 >= 'a' && LA12_96 <= 'd')||(LA12_96 >= 'f' && LA12_96 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_96);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA12_60 = input.LA(1);
						 
						int index12_60 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 27;}
						else if ( ((!stringterm)) ) {s = 83;}
						 
						input.seek(index12_60);
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA12_75 = input.LA(1);
						 
						int index12_75 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 27;}
						else if ( ((!stringterm)) ) {s = 89;}
						 
						input.seek(index12_75);
						if ( s>=0 ) return s;
						break;

					case 22 : 
						int LA12_111 = input.LA(1);
						 
						int index12_111 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_111 >= '0' && LA12_111 <= '9')||(LA12_111 >= 'A' && LA12_111 <= 'Z')||LA12_111=='_'||(LA12_111 >= 'a' && LA12_111 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 114;
						 
						input.seek(index12_111);
						if ( s>=0 ) return s;
						break;

					case 23 : 
						int LA12_63 = input.LA(1);
						 
						int index12_63 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 27;}
						else if ( ((!stringterm)) ) {s = 87;}
						 
						input.seek(index12_63);
						if ( s>=0 ) return s;
						break;

					case 24 : 
						int LA12_95 = input.LA(1);
						 
						int index12_95 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_95 >= '0' && LA12_95 <= '9')||(LA12_95 >= 'A' && LA12_95 <= 'Z')||LA12_95=='_'||(LA12_95 >= 'a' && LA12_95 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 57;}
						else s = 102;
						 
						input.seek(index12_95);
						if ( s>=0 ) return s;
						break;

					case 25 : 
						int LA12_85 = input.LA(1);
						 
						int index12_85 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_85=='e') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 95;}
						else if ( ((LA12_85 >= '0' && LA12_85 <= '9')||(LA12_85 >= 'A' && LA12_85 <= 'Z')||LA12_85=='_'||(LA12_85 >= 'a' && LA12_85 <= 'd')||(LA12_85 >= 'f' && LA12_85 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 57;}
						else s = 60;
						 
						input.seek(index12_85);
						if ( s>=0 ) return s;
						break;

					case 26 : 
						int LA12_61 = input.LA(1);
						 
						int index12_61 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_61=='u') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 85;}
						else if ( ((LA12_61 >= '0' && LA12_61 <= '9')||(LA12_61 >= 'A' && LA12_61 <= 'Z')||LA12_61=='_'||(LA12_61 >= 'a' && LA12_61 <= 't')||(LA12_61 >= 'v' && LA12_61 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 57;}
						else s = 60;
						 
						input.seek(index12_61);
						if ( s>=0 ) return s;
						break;

					case 27 : 
						int LA12_3 = input.LA(1);
						 
						int index12_3 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_3=='s') ) {s = 45;}
						else if ( (LA12_3=='r') ) {s = 46;}
						else if ( (LA12_3=='c') ) {s = 47;}
						else if ( (LA12_3=='q') ) {s = 48;}
						else if ( (LA12_3=='w') ) {s = 49;}
						else if ( (LA12_3=='p') ) {s = 50;}
						else if ( (LA12_3=='i') ) {s = 51;}
						else if ( (LA12_3=='B') && ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1))) {s = 52;}
						else if ( (LA12_3=='G') && ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1))) {s = 53;}
						else if ( (LA12_3=='l') ) {s = 54;}
						else s = 55;
						 
						input.seek(index12_3);
						if ( s>=0 ) return s;
						break;

					case 28 : 
						int LA12_24 = input.LA(1);
						 
						int index12_24 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_24 >= '0' && LA12_24 <= '9')||(LA12_24 >= 'A' && LA12_24 <= 'Z')||LA12_24=='_'||(LA12_24 >= 'a' && LA12_24 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 63;
						 
						input.seek(index12_24);
						if ( s>=0 ) return s;
						break;

					case 29 : 
						int LA12_5 = input.LA(1);
						 
						int index12_5 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_5 >= '0' && LA12_5 <= '9')||(LA12_5 >= 'A' && LA12_5 <= 'Z')||LA12_5=='_'||(LA12_5 >= 'a' && LA12_5 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 57;}
						else s = 58;
						 
						input.seek(index12_5);
						if ( s>=0 ) return s;
						break;

					case 30 : 
						int LA12_91 = input.LA(1);
						 
						int index12_91 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_91=='d') ) {s = 99;}
						else if ( (LA12_91=='t') && ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1))) {s = 100;}
						 
						input.seek(index12_91);
						if ( s>=0 ) return s;
						break;

					case 31 : 
						int LA12_112 = input.LA(1);
						 
						int index12_112 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_112 >= '0' && LA12_112 <= '9')||(LA12_112 >= 'A' && LA12_112 <= 'Z')||LA12_112=='_'||(LA12_112 >= 'a' && LA12_112 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}
						else s = 115;
						 
						input.seek(index12_112);
						if ( s>=0 ) return s;
						break;

					case 32 : 
						int LA12_7 = input.LA(1);
						 
						int index12_7 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_7=='r') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 61;}
						else if ( ((LA12_7 >= '0' && LA12_7 <= '9')||(LA12_7 >= 'A' && LA12_7 <= 'Z')||LA12_7=='_'||(LA12_7 >= 'a' && LA12_7 <= 'q')||(LA12_7 >= 's' && LA12_7 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 57;}
						else s = 60;
						 
						input.seek(index12_7);
						if ( s>=0 ) return s;
						break;

					case 33 : 
						int LA12_114 = input.LA(1);
						 
						int index12_114 = input.index();
						input.rewind();
						s = -1;
						if ( ((sq_nesting > 0)) ) {s = 117;}
						else if ( ((stringterm)) ) {s = 27;}
						else if ( ((!stringterm)) ) {s = 87;}
						 
						input.seek(index12_114);
						if ( s>=0 ) return s;
						break;

					case 34 : 
						int LA12_102 = input.LA(1);
						 
						int index12_102 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 107;}
						else if ( ((stringterm)) ) {s = 27;}
						else if ( ((!stringterm)) ) {s = 83;}
						 
						input.seek(index12_102);
						if ( s>=0 ) return s;
						break;

					case 35 : 
						int LA12_101 = input.LA(1);
						 
						int index12_101 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting == 0)) ) {s = 106;}
						else if ( ((stringterm)) ) {s = 27;}
						else if ( ((!stringterm)) ) {s = 83;}
						 
						input.seek(index12_101);
						if ( s>=0 ) return s;
						break;

					case 36 : 
						int LA12_115 = input.LA(1);
						 
						int index12_115 = input.index();
						input.rewind();
						s = -1;
						if ( ((sq_nesting > 0)) ) {s = 118;}
						else if ( ((stringterm)) ) {s = 27;}
						else if ( ((!stringterm)) ) {s = 87;}
						 
						input.seek(index12_115);
						if ( s>=0 ) return s;
						break;

					case 37 : 
						int LA12_76 = input.LA(1);
						 
						int index12_76 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_76 >= '0' && LA12_76 <= '9')) && (((!stringterm)||(stringterm)))) {s = 76;}
						else if ( ((LA12_76 >= 'A' && LA12_76 <= 'Z')||LA12_76=='_'||(LA12_76 >= 'a' && LA12_76 <= 'z')) && ((stringterm))) {s = 27;}
						else s = 75;
						 
						input.seek(index12_76);
						if ( s>=0 ) return s;
						break;

					case 38 : 
						int LA12_56 = input.LA(1);
						 
						int index12_56 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 52;}
						else if ( ((stringterm)) ) {s = 27;}
						else if ( ((!stringterm)) ) {s = 83;}
						 
						input.seek(index12_56);
						if ( s>=0 ) return s;
						break;

					case 39 : 
						int LA12_94 = input.LA(1);
						 
						int index12_94 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_94 >= '0' && LA12_94 <= '9')||(LA12_94 >= 'A' && LA12_94 <= 'Z')||LA12_94=='_'||(LA12_94 >= 'a' && LA12_94 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 57;}
						else s = 101;
						 
						input.seek(index12_94);
						if ( s>=0 ) return s;
						break;

					case 40 : 
						int LA12_58 = input.LA(1);
						 
						int index12_58 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 53;}
						else if ( ((stringterm)) ) {s = 27;}
						else if ( ((!stringterm)) ) {s = 83;}
						 
						input.seek(index12_58);
						if ( s>=0 ) return s;
						break;

					case 41 : 
						int LA12_25 = input.LA(1);
						 
						int index12_25 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_25 >= '0' && LA12_25 <= '9')||(LA12_25 >= 'A' && LA12_25 <= 'Z')||LA12_25=='_'||(LA12_25 >= 'a' && LA12_25 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 57;}
						else s = 60;
						 
						input.seek(index12_25);
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
