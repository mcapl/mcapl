// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g 2016-03-30 19:39:43

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
	public static final int UNNAMEDVAR=62;
	public static final int UPDATE=63;
	public static final int VAR=64;
	public static final int WAIT=65;
	public static final int WS=66;

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
	@Override public String getGrammarFileName() { return "/Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g"; }

	// $ANTLR start "UPDATE"
	public final void mUPDATE() throws RecognitionException {
		try {
			int _type = UPDATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:9: ( '>' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:11: '>'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:182:6: ( ':tell' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:182:8: ':tell'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:183:9: ( ':perform' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:183:11: ':perform'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:184:9: ( ':achieve' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:184:11: ':achieve'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:185:6: ( '.send' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:185:8: '.send'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:186:9: ( '.received' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:186:11: '.received'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:2: ( '.calculate' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:4: '.calculate'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:10: ( '.query' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:12: '.query'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:190:6: ( '.wait' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:190:8: '.wait'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:191:12: ( '.cap' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:191:14: '.cap'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:192:6: ( '.plan' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:192:8: '.plan'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:193:13: ( '.imp' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:193:15: '.imp'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:195:2: ( '.substitute' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:195:4: '.substitute'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:9: ({...}? => ( 'B' | '.B' ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:11: {...}? => ( 'B' | '.B' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {
				throw new FailedPredicateException(input, "BELIEVE", "curly_nesting > 0 && plain_nesting == 0 || belief_rules==1");
			}
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:75: ( 'B' | '.B' )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:76: 'B'
					{
					match('B'); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:196:82: '.B'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:6: ({...}? => ( 'G' | '.G' ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:8: {...}? => ( 'G' | '.G' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {
				throw new FailedPredicateException(input, "GOAL", "curly_nesting > 0 && plain_nesting == 0|| belief_rules==1");
			}
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:71: ( 'G' | '.G' )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:72: 'G'
					{
					match('G'); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:197:78: '.G'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:198:6: ({...}? => '.sent' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:198:8: {...}? => '.sent'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:199:6: ( '.lock' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:199:8: '.lock'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:200:7: ( ':Initial Goals:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:200:9: ':Initial Goals:'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:201:9: ( ':Initial Beliefs:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:201:11: ':Initial Beliefs:'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:203:2: ( ':Reasoning Rules:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:203:4: ':Reasoning Rules:'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:204:13: ( ':Capabilities:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:204:15: ':Capabilities:'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:205:7: ( ':Plans:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:205:9: ':Plans:'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:206:6: ({...}? => 'EASS' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:206:8: {...}? => 'EASS'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:207:6: ( ':name:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:207:8: ':name:'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:209:2: ( ':abstraction:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:209:4: ':abstraction:'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:210:6: ({...}? => 'True' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:210:8: {...}? => 'True'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:211:13: ({...}? => 'achieve' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:211:15: {...}? => 'achieve'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:212:13: ({...}? => 'perform' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:212:15: {...}? => 'perform'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:215:2: ( ':-' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:215:4: ':-'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:216:11: ( '<-' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:216:13: '<-'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:217:10: ( '=' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:217:12: '='
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:218:7: ( '->' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:218:9: '->'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:281:5: ( '/*' ( . )* '*/' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:281:7: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:281:12: ( . )*
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:281:12: .
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:12: (~ ( '\\n' | '\\r' ) )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:
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

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:26: ( '\\r' )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='\r') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:284:26: '\\r'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:286:8: ( ( '\\r' )? '\\n' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:286:9: ( '\\r' )? '\\n'
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:286:9: ( '\\r' )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='\r') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:286:9: '\\r'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:287:5: ({...}? => ( ' ' | '\\t' )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:287:8: {...}? => ( ' ' | '\\t' )+
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "WS", "!stringterm");
			}
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:287:24: ( ' ' | '\\t' )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:290:6: ( '(' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:290:9: '('
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:291:7: ( ')' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:291:9: ')'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:292:8: ( '[' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:292:10: '['
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:293:9: ( ']' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:293:11: ']'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:294:11: ( '{' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:294:13: '{'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:295:12: ( '}' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:295:14: '}'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:297:2: ( '\"' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:297:4: '\"'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:299:5: ( '~' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:299:7: '~'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:301:8: ({...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:301:10: {...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' )+
			{
			if ( !((stringterm)) ) {
				throw new FailedPredicateException(input, "STRING", "stringterm");
			}
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:301:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | ' ' | '.' )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:302:8: ({...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:302:11: {...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "CONST", "!stringterm");
			}
			matchRange('a','z'); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:302:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:303:5: ({...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:303:7: {...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "VAR", "!stringterm");
			}
			matchRange('A','Z'); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:303:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '0' && LA10_0 <= '9')||(LA10_0 >= 'A' && LA10_0 <= 'Z')||LA10_0=='_'||(LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:304:8: ({...}? => '0' .. '9' ( '0' .. '9' )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:304:10: {...}? => '0' .. '9' ( '0' .. '9' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "NUMBER", "!stringterm");
			}
			matchRange('0','9'); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:304:35: ( '0' .. '9' )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:306:2: ({...}? => '_' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:306:4: {...}? => '_'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:309:6: ( '<' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:309:8: '<'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:310:4: ( '==' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:310:7: '=='
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:311:7: ( '.' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:311:9: '.'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:312:6: ( '*' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:312:8: '*'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:313:6: ( '+' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:313:8: '+'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:314:7: ( '-' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:314:9: '-'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:315:5: ( '/' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:315:7: '/'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:316:5: ( '%' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:316:7: '%'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:318:8: ( '!' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:318:10: '!'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:319:7: ( ',' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:319:9: ','
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:320:6: ( ';' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:320:8: ';'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:321:7: ( ':' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:321:9: ':'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:322:7: ( '?' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:322:9: '?'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:323:5: ( '|' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:323:7: '|'
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
		// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:8: ( UPDATE | TELL | PERFORM | ACHIEVE | SEND | RECEIVED | CALCULATE | QUERYCOM | WAIT | CAPABILITY | PLAN | IMPLICATION | SUBSTITUTE | BELIEVE | GOAL | SENT | LOCK | GOALS | BELIEFS | BELIEFRULES | CAPABILITIES | PLANS | EASS | NAME | ABSTRACTION | TRUE | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | EQ_ASSGN | ARROW | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | UNNAMEDVAR | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY | BAR )
		int alt12=63;
		alt12 = dfa12.predict(input);
		switch (alt12) {
			case 1 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:10: UPDATE
				{
				mUPDATE(); 

				}
				break;
			case 2 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:17: TELL
				{
				mTELL(); 

				}
				break;
			case 3 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:22: PERFORM
				{
				mPERFORM(); 

				}
				break;
			case 4 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:30: ACHIEVE
				{
				mACHIEVE(); 

				}
				break;
			case 5 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:38: SEND
				{
				mSEND(); 

				}
				break;
			case 6 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:43: RECEIVED
				{
				mRECEIVED(); 

				}
				break;
			case 7 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:52: CALCULATE
				{
				mCALCULATE(); 

				}
				break;
			case 8 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:62: QUERYCOM
				{
				mQUERYCOM(); 

				}
				break;
			case 9 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:71: WAIT
				{
				mWAIT(); 

				}
				break;
			case 10 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:76: CAPABILITY
				{
				mCAPABILITY(); 

				}
				break;
			case 11 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:87: PLAN
				{
				mPLAN(); 

				}
				break;
			case 12 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:92: IMPLICATION
				{
				mIMPLICATION(); 

				}
				break;
			case 13 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:104: SUBSTITUTE
				{
				mSUBSTITUTE(); 

				}
				break;
			case 14 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:115: BELIEVE
				{
				mBELIEVE(); 

				}
				break;
			case 15 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:123: GOAL
				{
				mGOAL(); 

				}
				break;
			case 16 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:128: SENT
				{
				mSENT(); 

				}
				break;
			case 17 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:133: LOCK
				{
				mLOCK(); 

				}
				break;
			case 18 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:138: GOALS
				{
				mGOALS(); 

				}
				break;
			case 19 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:144: BELIEFS
				{
				mBELIEFS(); 

				}
				break;
			case 20 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:152: BELIEFRULES
				{
				mBELIEFRULES(); 

				}
				break;
			case 21 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:164: CAPABILITIES
				{
				mCAPABILITIES(); 

				}
				break;
			case 22 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:177: PLANS
				{
				mPLANS(); 

				}
				break;
			case 23 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:183: EASS
				{
				mEASS(); 

				}
				break;
			case 24 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:188: NAME
				{
				mNAME(); 

				}
				break;
			case 25 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:193: ABSTRACTION
				{
				mABSTRACTION(); 

				}
				break;
			case 26 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:205: TRUE
				{
				mTRUE(); 

				}
				break;
			case 27 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:210: ACHIEVEGOAL
				{
				mACHIEVEGOAL(); 

				}
				break;
			case 28 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:222: PERFORMGOAL
				{
				mPERFORMGOAL(); 

				}
				break;
			case 29 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:234: BRULEARROW
				{
				mBRULEARROW(); 

				}
				break;
			case 30 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:245: RULEARROW
				{
				mRULEARROW(); 

				}
				break;
			case 31 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:255: EQ_ASSGN
				{
				mEQ_ASSGN(); 

				}
				break;
			case 32 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:264: ARROW
				{
				mARROW(); 

				}
				break;
			case 33 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:270: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 34 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:278: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;
			case 35 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:291: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 36 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:299: WS
				{
				mWS(); 

				}
				break;
			case 37 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:302: OPEN
				{
				mOPEN(); 

				}
				break;
			case 38 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:307: CLOSE
				{
				mCLOSE(); 

				}
				break;
			case 39 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:313: SQOPEN
				{
				mSQOPEN(); 

				}
				break;
			case 40 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:320: SQCLOSE
				{
				mSQCLOSE(); 

				}
				break;
			case 41 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:328: CURLYOPEN
				{
				mCURLYOPEN(); 

				}
				break;
			case 42 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:338: CURLYCLOSE
				{
				mCURLYCLOSE(); 

				}
				break;
			case 43 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:349: DOUBLEQUOTE
				{
				mDOUBLEQUOTE(); 

				}
				break;
			case 44 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:361: NOT
				{
				mNOT(); 

				}
				break;
			case 45 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:365: STRING
				{
				mSTRING(); 

				}
				break;
			case 46 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:372: CONST
				{
				mCONST(); 

				}
				break;
			case 47 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:378: VAR
				{
				mVAR(); 

				}
				break;
			case 48 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:382: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 49 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:389: UNNAMEDVAR
				{
				mUNNAMEDVAR(); 

				}
				break;
			case 50 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:400: LESS
				{
				mLESS(); 

				}
				break;
			case 51 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:405: EQ
				{
				mEQ(); 

				}
				break;
			case 52 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:408: POINT
				{
				mPOINT(); 

				}
				break;
			case 53 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:414: MULT
				{
				mMULT(); 

				}
				break;
			case 54 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:419: PLUS
				{
				mPLUS(); 

				}
				break;
			case 55 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:424: MINUS
				{
				mMINUS(); 

				}
				break;
			case 56 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:430: DIV
				{
				mDIV(); 

				}
				break;
			case 57 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:434: MOD
				{
				mMOD(); 

				}
				break;
			case 58 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:438: SHRIEK
				{
				mSHRIEK(); 

				}
				break;
			case 59 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:445: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 60 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:451: SEMI
				{
				mSEMI(); 

				}
				break;
			case 61 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:456: COLON
				{
				mCOLON(); 

				}
				break;
			case 62 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:462: QUERY
				{
				mQUERY(); 

				}
				break;
			case 63 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:468: BAR
				{
				mBAR(); 

				}
				break;

		}
	}


	protected DFA12 dfa12 = new DFA12(this);
	static final String DFA12_eotS =
		"\2\uffff\1\56\1\71\1\73\1\75\2\77\2\102\1\106\1\110\1\112\1\115\1\uffff"+
		"\1\116\11\uffff\1\102\1\77\1\117\1\121\22\uffff\7\72\1\135\1\136\1\72"+
		"\3\uffff\1\77\1\uffff\1\77\1\uffff\1\77\1\102\1\uffff\2\102\13\uffff\1"+
		"\117\4\uffff\10\72\2\uffff\1\72\4\uffff\2\77\1\102\1\uffff\1\102\3\uffff"+
		"\4\72\1\u0080\3\72\1\u0084\1\72\1\u0086\1\u0087\2\102\1\uffff\1\u008b"+
		"\1\u008c\3\72\1\uffff\1\72\1\u0092\1\u0093\1\uffff\1\u0095\2\uffff\2\102"+
		"\3\uffff\3\72\1\uffff\1\u00a0\6\uffff\2\102\3\uffff\3\72\4\uffff\1\u00ab"+
		"\1\u00ac\1\uffff\3\72\4\uffff\1\72\1\u00b6\1\72\4\uffff\1\72\1\uffff\1"+
		"\u00ba\1\u00bb\5\uffff";
	static final String DFA12_eofS =
		"\u00be\uffff";
	static final String DFA12_minS =
		"\1\11\1\uffff\1\55\7\40\1\55\1\75\1\76\1\52\1\uffff\1\11\11\uffff\4\40"+
		"\12\uffff\1\142\1\156\6\uffff\2\145\1\141\1\165\1\141\1\154\1\155\2\40"+
		"\1\157\1\0\1\uffff\1\0\1\40\1\0\1\40\1\0\2\40\1\0\2\40\11\uffff\2\0\1"+
		"\40\1\0\2\uffff\1\151\1\156\1\142\1\143\1\154\1\145\1\151\1\141\1\160"+
		"\2\0\1\143\4\uffff\3\40\1\uffff\1\40\2\uffff\1\164\1\144\1\163\1\145\1"+
		"\143\1\40\1\162\1\164\1\156\1\40\1\153\4\40\1\151\2\40\1\164\1\151\1\165"+
		"\1\0\1\171\2\40\1\0\1\40\2\0\2\40\1\141\2\0\1\151\1\166\1\154\1\uffff"+
		"\1\40\2\0\1\uffff\1\0\2\uffff\2\40\1\154\2\uffff\1\164\1\145\1\141\1\0"+
		"\3\uffff\3\40\1\165\1\144\1\164\1\uffff\2\0\1\102\1\164\1\40\1\145\4\uffff"+
		"\1\145\1\0\2\40\1\uffff\2\0\2\uffff";
	static final String DFA12_maxS =
		"\1\176\1\uffff\1\164\7\172\1\55\1\75\1\76\1\57\1\uffff\1\172\11\uffff"+
		"\4\172\12\uffff\1\143\1\156\6\uffff\1\165\1\145\1\141\1\165\1\141\1\154"+
		"\1\155\2\172\1\157\1\0\1\uffff\1\0\1\172\1\0\1\172\1\0\2\172\1\0\2\172"+
		"\11\uffff\2\0\1\172\1\0\2\uffff\1\151\1\156\1\142\1\143\1\160\1\145\1"+
		"\151\1\141\1\160\2\0\1\143\4\uffff\3\172\1\uffff\1\172\2\uffff\2\164\1"+
		"\163\1\145\1\143\1\172\1\162\1\164\1\156\1\172\1\153\4\172\1\151\2\172"+
		"\1\164\1\151\1\165\1\0\1\171\2\172\1\0\1\172\2\0\2\172\1\141\2\0\1\151"+
		"\1\166\1\154\1\uffff\1\172\2\0\1\uffff\1\0\2\uffff\2\172\1\154\2\uffff"+
		"\1\164\1\145\1\141\1\0\3\uffff\2\172\1\40\1\165\1\144\1\164\1\uffff\2"+
		"\0\1\107\1\164\1\172\1\145\4\uffff\1\145\1\0\2\172\1\uffff\2\0\2\uffff";
	static final String DFA12_acceptS =
		"\1\uffff\1\1\14\uffff\1\43\1\uffff\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
		"\1\54\1\44\4\uffff\1\65\1\66\1\71\1\72\1\73\1\74\1\76\1\77\1\2\1\3\2\uffff"+
		"\1\24\1\25\1\26\1\30\1\35\1\75\13\uffff\1\55\12\uffff\1\36\1\62\1\63\1"+
		"\37\1\40\1\67\1\41\1\42\1\70\4\uffff\1\4\1\31\14\uffff\1\64\1\16\1\57"+
		"\1\17\3\uffff\1\56\1\uffff\1\60\1\61\45\uffff\1\12\3\uffff\1\14\1\uffff"+
		"\1\27\1\32\3\uffff\1\5\1\20\4\uffff\1\11\1\13\1\21\6\uffff\1\10\6\uffff"+
		"\1\33\1\34\1\22\1\23\4\uffff\1\6\2\uffff\1\7\1\15";
	static final String DFA12_specialS =
		"\1\44\2\uffff\1\74\1\112\1\121\1\157\1\30\1\123\1\134\5\uffff\1\51\11"+
		"\uffff\1\47\1\77\1\116\1\144\22\uffff\1\122\1\124\1\113\1\150\1\2\1\17"+
		"\1\24\1\73\1\100\1\60\1\46\1\uffff\1\102\1\117\1\104\1\63\1\37\1\75\1"+
		"\52\1\35\1\103\1\61\11\uffff\1\26\1\42\1\16\1\45\3\uffff\1\137\1\27\1"+
		"\125\1\114\1\151\1\4\1\21\1\25\1\11\1\12\1\62\4\uffff\1\66\1\76\1\53\1"+
		"\uffff\1\64\3\uffff\1\142\1\31\1\126\1\136\1\40\1\152\1\6\1\22\1\54\1"+
		"\65\1\120\1\20\1\55\1\67\1\uffff\1\115\1\101\1\32\1\130\1\140\1\3\1\153"+
		"\1\23\1\50\1\7\1\106\1\105\1\107\1\56\1\70\1\uffff\1\154\1\13\1\33\1\131"+
		"\1\141\1\uffff\1\14\1\0\1\5\1\uffff\1\15\2\uffff\1\57\1\71\3\uffff\1\34"+
		"\1\132\1\143\1\160\3\uffff\1\135\1\1\1\uffff\1\36\1\133\1\145\1\uffff"+
		"\1\110\1\111\1\uffff\1\41\1\127\1\146\4\uffff\1\43\1\155\1\147\1\72\1"+
		"\uffff\1\156\1\10\2\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\30\1\16\2\uffff\1\16\22\uffff\1\17\1\40\1\26\2\uffff\1\37\2\uffff"+
			"\1\20\1\21\1\35\1\36\1\41\1\14\1\3\1\15\12\33\1\2\1\42\1\12\1\13\1\1"+
			"\1\43\1\uffff\1\32\1\4\2\32\1\6\1\32\1\5\14\32\1\7\6\32\1\22\1\uffff"+
			"\1\23\1\uffff\1\34\1\uffff\1\10\16\31\1\11\12\31\1\24\1\44\1\25\1\27",
			"",
			"\1\55\25\uffff\1\52\5\uffff\1\50\6\uffff\1\53\1\uffff\1\51\16\uffff"+
			"\1\47\14\uffff\1\54\1\uffff\1\46\3\uffff\1\45",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\1\72\1\66\4\72\1\67\23\72"+
			"\4\uffff\1\72\1\uffff\2\72\1\61\5\72\1\65\2\72\1\70\3\72\1\64\1\62\1"+
			"\60\1\57\3\72\1\63\3\72",
			"\1\72\15\uffff\1\72\1\uffff\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff"+
			"\32\74",
			"\1\72\15\uffff\1\72\1\uffff\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff"+
			"\32\74",
			"\1\72\15\uffff\1\72\1\uffff\12\74\7\uffff\1\76\31\74\4\uffff\1\74\1"+
			"\uffff\32\74",
			"\1\72\15\uffff\1\72\1\uffff\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff"+
			"\21\74\1\100\10\74",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\2\103\1\101\27\103",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\4\103\1\104\25\103",
			"\1\105",
			"\1\107",
			"\1\111",
			"\1\113\4\uffff\1\114",
			"",
			"\1\30\26\uffff\1\17\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff"+
			"\1\72\1\uffff\32\72",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\32\103",
			"\1\72\15\uffff\1\72\1\uffff\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff"+
			"\32\74",
			"\1\72\15\uffff\1\72\1\uffff\12\120\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
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
			"\1\123\1\122",
			"\1\124",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\125\17\uffff\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\132",
			"\1\133",
			"\1\134",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\137",
			"\1\uffff",
			"",
			"\1\uffff",
			"\1\72\15\uffff\1\72\1\uffff\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff"+
			"\32\74",
			"\1\uffff",
			"\1\72\15\uffff\1\72\1\uffff\12\74\7\uffff\22\74\1\144\7\74\4\uffff\1"+
			"\74\1\uffff\32\74",
			"\1\uffff",
			"\1\72\15\uffff\1\72\1\uffff\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff"+
			"\24\74\1\145\5\74",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\7\103\1\146\22\103",
			"\1\uffff",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\32\103",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\21\103\1\150\10\103",
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
			"\1\72\15\uffff\1\72\1\uffff\12\120\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\uffff",
			"",
			"",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\156",
			"\1\157\3\uffff\1\160",
			"\1\161",
			"\1\162",
			"\1\163",
			"\1\164",
			"\1\uffff",
			"\1\uffff",
			"\1\165",
			"",
			"",
			"",
			"",
			"\1\72\15\uffff\1\72\1\uffff\12\74\7\uffff\22\74\1\166\7\74\4\uffff\1"+
			"\74\1\uffff\32\74",
			"\1\72\15\uffff\1\72\1\uffff\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff"+
			"\4\74\1\167\25\74",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\10\103\1\170\21\103",
			"",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\5\103\1\171\24\103",
			"",
			"",
			"\1\172",
			"\1\173\17\uffff\1\174",
			"\1\175",
			"\1\176",
			"\1\177",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\u0081",
			"\1\u0082",
			"\1\u0083",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\u0085",
			"\1\72\15\uffff\1\72\1\uffff\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff"+
			"\32\74",
			"\1\72\15\uffff\1\72\1\uffff\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff"+
			"\32\74",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\4\103\1\u0088\25\103",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\16\103\1\u0089\13\103",
			"\1\u008a",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\u008d",
			"\1\u008e",
			"\1\u008f",
			"\1\uffff",
			"\1\u0091",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\uffff",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\uffff",
			"\1\uffff",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\25\103\1\u0098\4\103",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\21\103\1\u0099\10\103",
			"\1\u009a",
			"\1\uffff",
			"\1\uffff",
			"\1\u009d",
			"\1\u009e",
			"\1\u009f",
			"",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\uffff",
			"\1\uffff",
			"",
			"\1\uffff",
			"",
			"",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\4\103\1\u00a4\25\103",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\14\103\1\u00a5\15\103",
			"\1\u00a6",
			"",
			"",
			"\1\u00a7",
			"\1\u00a8",
			"\1\u00a9",
			"\1\uffff",
			"",
			"",
			"",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\32\103",
			"\1\72\15\uffff\1\72\1\uffff\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff"+
			"\32\103",
			"\1\u00ad",
			"\1\u00ae",
			"\1\u00af",
			"\1\u00b0",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\u00b4\4\uffff\1\u00b3",
			"\1\u00b5",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\u00b7",
			"",
			"",
			"",
			"",
			"\1\u00b8",
			"\1\uffff",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
			"\1\72\15\uffff\1\72\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff"+
			"\32\72",
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
			return "1:1: Tokens : ( UPDATE | TELL | PERFORM | ACHIEVE | SEND | RECEIVED | CALCULATE | QUERYCOM | WAIT | CAPABILITY | PLAN | IMPLICATION | SUBSTITUTE | BELIEVE | GOAL | SENT | LOCK | GOALS | BELIEFS | BELIEFRULES | CAPABILITIES | PLANS | EASS | NAME | ABSTRACTION | TRUE | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | EQ_ASSGN | ARROW | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | UNNAMEDVAR | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY | BAR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA12_146 = input.LA(1);
						 
						int index12_146 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 161;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_146);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA12_165 = input.LA(1);
						 
						int index12_165 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_165 >= '0' && LA12_165 <= '9')||(LA12_165 >= 'A' && LA12_165 <= 'Z')||LA12_165=='_'||(LA12_165 >= 'a' && LA12_165 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_165==' '||LA12_165=='.') && ((stringterm))) {s = 58;}
						else s = 172;
						 
						input.seek(index12_165);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA12_51 = input.LA(1);
						 
						int index12_51 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_51=='a') ) {s = 90;}
						else s = 58;
						 
						input.seek(index12_51);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA12_128 = input.LA(1);
						 
						int index12_128 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 144;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_128);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA12_90 = input.LA(1);
						 
						int index12_90 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_90=='i') ) {s = 114;}
						else s = 58;
						 
						input.seek(index12_90);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA12_147 = input.LA(1);
						 
						int index12_147 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 162;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_147);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA12_114 = input.LA(1);
						 
						int index12_114 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_114=='t') ) {s = 130;}
						else s = 58;
						 
						input.seek(index12_114);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA12_132 = input.LA(1);
						 
						int index12_132 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 148;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_132);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA12_187 = input.LA(1);
						 
						int index12_187 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 189;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_187);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA12_93 = input.LA(1);
						 
						int index12_93 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 97;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_93);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA12_94 = input.LA(1);
						 
						int index12_94 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 99;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_94);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA12_140 = input.LA(1);
						 
						int index12_140 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 156;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_140);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA12_145 = input.LA(1);
						 
						int index12_145 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_145==' '||LA12_145=='.'||(LA12_145 >= '0' && LA12_145 <= '9')||(LA12_145 >= 'A' && LA12_145 <= 'Z')||LA12_145=='_'||(LA12_145 >= 'a' && LA12_145 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 160;
						 
						input.seek(index12_145);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA12_149 = input.LA(1);
						 
						int index12_149 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 163;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_149);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA12_80 = input.LA(1);
						 
						int index12_80 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_80 >= '0' && LA12_80 <= '9')) && (((stringterm)||(!stringterm)))) {s = 80;}
						else if ( (LA12_80==' '||LA12_80=='.'||(LA12_80 >= 'A' && LA12_80 <= 'Z')||LA12_80=='_'||(LA12_80 >= 'a' && LA12_80 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 79;
						 
						input.seek(index12_80);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA12_52 = input.LA(1);
						 
						int index12_52 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_52=='l') ) {s = 91;}
						else s = 58;
						 
						input.seek(index12_52);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA12_119 = input.LA(1);
						 
						int index12_119 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_119 >= '0' && LA12_119 <= '9')||(LA12_119 >= 'A' && LA12_119 <= 'Z')||LA12_119=='_'||(LA12_119 >= 'a' && LA12_119 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 60;}
						else if ( (LA12_119==' '||LA12_119=='.') && ((stringterm))) {s = 58;}
						else s = 135;
						 
						input.seek(index12_119);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA12_91 = input.LA(1);
						 
						int index12_91 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_91=='a') ) {s = 115;}
						else s = 58;
						 
						input.seek(index12_91);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA12_115 = input.LA(1);
						 
						int index12_115 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_115=='n') ) {s = 131;}
						else s = 58;
						 
						input.seek(index12_115);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA12_130 = input.LA(1);
						 
						int index12_130 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_130==' '||LA12_130=='.'||(LA12_130 >= '0' && LA12_130 <= '9')||(LA12_130 >= 'A' && LA12_130 <= 'Z')||LA12_130=='_'||(LA12_130 >= 'a' && LA12_130 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 146;
						 
						input.seek(index12_130);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA12_53 = input.LA(1);
						 
						int index12_53 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_53=='m') ) {s = 92;}
						else s = 58;
						 
						input.seek(index12_53);
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA12_92 = input.LA(1);
						 
						int index12_92 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_92=='p') ) {s = 116;}
						else s = 58;
						 
						input.seek(index12_92);
						if ( s>=0 ) return s;
						break;

					case 22 : 
						int LA12_78 = input.LA(1);
						 
						int index12_78 = input.index();
						input.rewind();
						s = -1;
						if ( ((!stringterm)) ) {s = 24;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_78);
						if ( s>=0 ) return s;
						break;

					case 23 : 
						int LA12_86 = input.LA(1);
						 
						int index12_86 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_86=='b') ) {s = 109;}
						else s = 58;
						 
						input.seek(index12_86);
						if ( s>=0 ) return s;
						break;

					case 24 : 
						int LA12_7 = input.LA(1);
						 
						int index12_7 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_7=='r') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 64;}
						else if ( ((LA12_7 >= '0' && LA12_7 <= '9')||(LA12_7 >= 'A' && LA12_7 <= 'Z')||LA12_7=='_'||(LA12_7 >= 'a' && LA12_7 <= 'q')||(LA12_7 >= 's' && LA12_7 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 60;}
						else if ( (LA12_7==' '||LA12_7=='.') && ((stringterm))) {s = 58;}
						else s = 63;
						 
						input.seek(index12_7);
						if ( s>=0 ) return s;
						break;

					case 25 : 
						int LA12_109 = input.LA(1);
						 
						int index12_109 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_109=='s') ) {s = 125;}
						else s = 58;
						 
						input.seek(index12_109);
						if ( s>=0 ) return s;
						break;

					case 26 : 
						int LA12_125 = input.LA(1);
						 
						int index12_125 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_125=='t') ) {s = 141;}
						else s = 58;
						 
						input.seek(index12_125);
						if ( s>=0 ) return s;
						break;

					case 27 : 
						int LA12_141 = input.LA(1);
						 
						int index12_141 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_141=='i') ) {s = 157;}
						else s = 58;
						 
						input.seek(index12_141);
						if ( s>=0 ) return s;
						break;

					case 28 : 
						int LA12_157 = input.LA(1);
						 
						int index12_157 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_157=='t') ) {s = 167;}
						else s = 58;
						 
						input.seek(index12_157);
						if ( s>=0 ) return s;
						break;

					case 29 : 
						int LA12_66 = input.LA(1);
						 
						int index12_66 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 58;}
						else if ( ((!stringterm)) ) {s = 103;}
						 
						input.seek(index12_66);
						if ( s>=0 ) return s;
						break;

					case 30 : 
						int LA12_167 = input.LA(1);
						 
						int index12_167 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_167=='u') ) {s = 174;}
						else s = 58;
						 
						input.seek(index12_167);
						if ( s>=0 ) return s;
						break;

					case 31 : 
						int LA12_63 = input.LA(1);
						 
						int index12_63 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 58;}
						else if ( ((!stringterm)) ) {s = 98;}
						 
						input.seek(index12_63);
						if ( s>=0 ) return s;
						break;

					case 32 : 
						int LA12_112 = input.LA(1);
						 
						int index12_112 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_112==' '||LA12_112=='.'||(LA12_112 >= '0' && LA12_112 <= '9')||(LA12_112 >= 'A' && LA12_112 <= 'Z')||LA12_112=='_'||(LA12_112 >= 'a' && LA12_112 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 128;
						 
						input.seek(index12_112);
						if ( s>=0 ) return s;
						break;

					case 33 : 
						int LA12_174 = input.LA(1);
						 
						int index12_174 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_174=='t') ) {s = 181;}
						else s = 58;
						 
						input.seek(index12_174);
						if ( s>=0 ) return s;
						break;

					case 34 : 
						int LA12_79 = input.LA(1);
						 
						int index12_79 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 58;}
						else if ( ((!stringterm)) ) {s = 105;}
						 
						input.seek(index12_79);
						if ( s>=0 ) return s;
						break;

					case 35 : 
						int LA12_181 = input.LA(1);
						 
						int index12_181 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_181=='e') ) {s = 184;}
						else s = 58;
						 
						input.seek(index12_181);
						if ( s>=0 ) return s;
						break;

					case 36 : 
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
						else if ( (LA12_0=='_') && (((stringterm)||(!stringterm)))) {s = 28;}
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

					case 37 : 
						int LA12_81 = input.LA(1);
						 
						int index12_81 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 58;}
						else if ( ((!stringterm)) ) {s = 106;}
						 
						input.seek(index12_81);
						if ( s>=0 ) return s;
						break;

					case 38 : 
						int LA12_57 = input.LA(1);
						 
						int index12_57 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 58;}
						else if ( (true) ) {s = 96;}
						 
						input.seek(index12_57);
						if ( s>=0 ) return s;
						break;

					case 39 : 
						int LA12_25 = input.LA(1);
						 
						int index12_25 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_25 >= '0' && LA12_25 <= '9')||(LA12_25 >= 'A' && LA12_25 <= 'Z')||LA12_25=='_'||(LA12_25 >= 'a' && LA12_25 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_25==' '||LA12_25=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_25);
						if ( s>=0 ) return s;
						break;

					case 40 : 
						int LA12_131 = input.LA(1);
						 
						int index12_131 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_131==' '||LA12_131=='.'||(LA12_131 >= '0' && LA12_131 <= '9')||(LA12_131 >= 'A' && LA12_131 <= 'Z')||LA12_131=='_'||(LA12_131 >= 'a' && LA12_131 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 147;
						 
						input.seek(index12_131);
						if ( s>=0 ) return s;
						break;

					case 41 : 
						int LA12_15 = input.LA(1);
						 
						int index12_15 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_15==' ') && (((stringterm)||(!stringterm)))) {s = 15;}
						else if ( (LA12_15=='\t') && ((!stringterm))) {s = 24;}
						else if ( (LA12_15=='.'||(LA12_15 >= '0' && LA12_15 <= '9')||(LA12_15 >= 'A' && LA12_15 <= 'Z')||LA12_15=='_'||(LA12_15 >= 'a' && LA12_15 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 78;
						 
						input.seek(index12_15);
						if ( s>=0 ) return s;
						break;

					case 42 : 
						int LA12_65 = input.LA(1);
						 
						int index12_65 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_65=='h') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 102;}
						else if ( ((LA12_65 >= '0' && LA12_65 <= '9')||(LA12_65 >= 'A' && LA12_65 <= 'Z')||LA12_65=='_'||(LA12_65 >= 'a' && LA12_65 <= 'g')||(LA12_65 >= 'i' && LA12_65 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_65==' '||LA12_65=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_65);
						if ( s>=0 ) return s;
						break;

					case 43 : 
						int LA12_102 = input.LA(1);
						 
						int index12_102 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_102=='i') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 120;}
						else if ( ((LA12_102 >= '0' && LA12_102 <= '9')||(LA12_102 >= 'A' && LA12_102 <= 'Z')||LA12_102=='_'||(LA12_102 >= 'a' && LA12_102 <= 'h')||(LA12_102 >= 'j' && LA12_102 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_102==' '||LA12_102=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_102);
						if ( s>=0 ) return s;
						break;

					case 44 : 
						int LA12_116 = input.LA(1);
						 
						int index12_116 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_116==' '||LA12_116=='.'||(LA12_116 >= '0' && LA12_116 <= '9')||(LA12_116 >= 'A' && LA12_116 <= 'Z')||LA12_116=='_'||(LA12_116 >= 'a' && LA12_116 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 132;
						 
						input.seek(index12_116);
						if ( s>=0 ) return s;
						break;

					case 45 : 
						int LA12_120 = input.LA(1);
						 
						int index12_120 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_120=='e') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 136;}
						else if ( ((LA12_120 >= '0' && LA12_120 <= '9')||(LA12_120 >= 'A' && LA12_120 <= 'Z')||LA12_120=='_'||(LA12_120 >= 'a' && LA12_120 <= 'd')||(LA12_120 >= 'f' && LA12_120 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_120==' '||LA12_120=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_120);
						if ( s>=0 ) return s;
						break;

					case 46 : 
						int LA12_136 = input.LA(1);
						 
						int index12_136 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_136=='v') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 152;}
						else if ( ((LA12_136 >= '0' && LA12_136 <= '9')||(LA12_136 >= 'A' && LA12_136 <= 'Z')||LA12_136=='_'||(LA12_136 >= 'a' && LA12_136 <= 'u')||(LA12_136 >= 'w' && LA12_136 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_136==' '||LA12_136=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_136);
						if ( s>=0 ) return s;
						break;

					case 47 : 
						int LA12_152 = input.LA(1);
						 
						int index12_152 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_152=='e') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 164;}
						else if ( ((LA12_152 >= '0' && LA12_152 <= '9')||(LA12_152 >= 'A' && LA12_152 <= 'Z')||LA12_152=='_'||(LA12_152 >= 'a' && LA12_152 <= 'd')||(LA12_152 >= 'f' && LA12_152 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_152==' '||LA12_152=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_152);
						if ( s>=0 ) return s;
						break;

					case 48 : 
						int LA12_56 = input.LA(1);
						 
						int index12_56 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_56=='o') ) {s = 95;}
						else s = 58;
						 
						input.seek(index12_56);
						if ( s>=0 ) return s;
						break;

					case 49 : 
						int LA12_68 = input.LA(1);
						 
						int index12_68 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_68=='r') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 104;}
						else if ( ((LA12_68 >= '0' && LA12_68 <= '9')||(LA12_68 >= 'A' && LA12_68 <= 'Z')||LA12_68=='_'||(LA12_68 >= 'a' && LA12_68 <= 'q')||(LA12_68 >= 's' && LA12_68 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_68==' '||LA12_68=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_68);
						if ( s>=0 ) return s;
						break;

					case 50 : 
						int LA12_95 = input.LA(1);
						 
						int index12_95 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_95=='c') ) {s = 117;}
						else s = 58;
						 
						input.seek(index12_95);
						if ( s>=0 ) return s;
						break;

					case 51 : 
						int LA12_62 = input.LA(1);
						 
						int index12_62 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_62=='S') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 100;}
						else if ( ((LA12_62 >= '0' && LA12_62 <= '9')||(LA12_62 >= 'A' && LA12_62 <= 'R')||(LA12_62 >= 'T' && LA12_62 <= 'Z')||LA12_62=='_'||(LA12_62 >= 'a' && LA12_62 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 60;}
						else if ( (LA12_62==' '||LA12_62=='.') && ((stringterm))) {s = 58;}
						else s = 63;
						 
						input.seek(index12_62);
						if ( s>=0 ) return s;
						break;

					case 52 : 
						int LA12_104 = input.LA(1);
						 
						int index12_104 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_104=='f') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 121;}
						else if ( ((LA12_104 >= '0' && LA12_104 <= '9')||(LA12_104 >= 'A' && LA12_104 <= 'Z')||LA12_104=='_'||(LA12_104 >= 'a' && LA12_104 <= 'e')||(LA12_104 >= 'g' && LA12_104 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_104==' '||LA12_104=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_104);
						if ( s>=0 ) return s;
						break;

					case 53 : 
						int LA12_117 = input.LA(1);
						 
						int index12_117 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_117=='k') ) {s = 133;}
						else s = 58;
						 
						input.seek(index12_117);
						if ( s>=0 ) return s;
						break;

					case 54 : 
						int LA12_100 = input.LA(1);
						 
						int index12_100 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_100=='S') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 118;}
						else if ( ((LA12_100 >= '0' && LA12_100 <= '9')||(LA12_100 >= 'A' && LA12_100 <= 'R')||(LA12_100 >= 'T' && LA12_100 <= 'Z')||LA12_100=='_'||(LA12_100 >= 'a' && LA12_100 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 60;}
						else if ( (LA12_100==' '||LA12_100=='.') && ((stringterm))) {s = 58;}
						else s = 63;
						 
						input.seek(index12_100);
						if ( s>=0 ) return s;
						break;

					case 55 : 
						int LA12_121 = input.LA(1);
						 
						int index12_121 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_121=='o') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 137;}
						else if ( ((LA12_121 >= '0' && LA12_121 <= '9')||(LA12_121 >= 'A' && LA12_121 <= 'Z')||LA12_121=='_'||(LA12_121 >= 'a' && LA12_121 <= 'n')||(LA12_121 >= 'p' && LA12_121 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_121==' '||LA12_121=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_121);
						if ( s>=0 ) return s;
						break;

					case 56 : 
						int LA12_137 = input.LA(1);
						 
						int index12_137 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_137=='r') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 153;}
						else if ( ((LA12_137 >= '0' && LA12_137 <= '9')||(LA12_137 >= 'A' && LA12_137 <= 'Z')||LA12_137=='_'||(LA12_137 >= 'a' && LA12_137 <= 'q')||(LA12_137 >= 's' && LA12_137 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_137==' '||LA12_137=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_137);
						if ( s>=0 ) return s;
						break;

					case 57 : 
						int LA12_153 = input.LA(1);
						 
						int index12_153 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_153=='m') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 165;}
						else if ( ((LA12_153 >= '0' && LA12_153 <= '9')||(LA12_153 >= 'A' && LA12_153 <= 'Z')||LA12_153=='_'||(LA12_153 >= 'a' && LA12_153 <= 'l')||(LA12_153 >= 'n' && LA12_153 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_153==' '||LA12_153=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_153);
						if ( s>=0 ) return s;
						break;

					case 58 : 
						int LA12_184 = input.LA(1);
						 
						int index12_184 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_184==' '||LA12_184=='.'||(LA12_184 >= '0' && LA12_184 <= '9')||(LA12_184 >= 'A' && LA12_184 <= 'Z')||LA12_184=='_'||(LA12_184 >= 'a' && LA12_184 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 187;
						 
						input.seek(index12_184);
						if ( s>=0 ) return s;
						break;

					case 59 : 
						int LA12_54 = input.LA(1);
						 
						int index12_54 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_54==' '||LA12_54=='.'||(LA12_54 >= '0' && LA12_54 <= '9')||(LA12_54 >= 'A' && LA12_54 <= 'Z')||LA12_54=='_'||(LA12_54 >= 'a' && LA12_54 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 93;
						 
						input.seek(index12_54);
						if ( s>=0 ) return s;
						break;

					case 60 : 
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
						else if ( (LA12_3==' '||LA12_3=='.'||(LA12_3 >= '0' && LA12_3 <= '9')||LA12_3=='A'||(LA12_3 >= 'C' && LA12_3 <= 'F')||(LA12_3 >= 'H' && LA12_3 <= 'Z')||LA12_3=='_'||(LA12_3 >= 'a' && LA12_3 <= 'b')||(LA12_3 >= 'd' && LA12_3 <= 'h')||(LA12_3 >= 'j' && LA12_3 <= 'k')||(LA12_3 >= 'm' && LA12_3 <= 'o')||(LA12_3 >= 't' && LA12_3 <= 'v')||(LA12_3 >= 'x' && LA12_3 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 57;
						 
						input.seek(index12_3);
						if ( s>=0 ) return s;
						break;

					case 61 : 
						int LA12_64 = input.LA(1);
						 
						int index12_64 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_64=='u') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 101;}
						else if ( ((LA12_64 >= '0' && LA12_64 <= '9')||(LA12_64 >= 'A' && LA12_64 <= 'Z')||LA12_64=='_'||(LA12_64 >= 'a' && LA12_64 <= 't')||(LA12_64 >= 'v' && LA12_64 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 60;}
						else if ( (LA12_64==' '||LA12_64=='.') && ((stringterm))) {s = 58;}
						else s = 63;
						 
						input.seek(index12_64);
						if ( s>=0 ) return s;
						break;

					case 62 : 
						int LA12_101 = input.LA(1);
						 
						int index12_101 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_101=='e') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 119;}
						else if ( ((LA12_101 >= '0' && LA12_101 <= '9')||(LA12_101 >= 'A' && LA12_101 <= 'Z')||LA12_101=='_'||(LA12_101 >= 'a' && LA12_101 <= 'd')||(LA12_101 >= 'f' && LA12_101 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 60;}
						else if ( (LA12_101==' '||LA12_101=='.') && ((stringterm))) {s = 58;}
						else s = 63;
						 
						input.seek(index12_101);
						if ( s>=0 ) return s;
						break;

					case 63 : 
						int LA12_26 = input.LA(1);
						 
						int index12_26 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_26 >= '0' && LA12_26 <= '9')||(LA12_26 >= 'A' && LA12_26 <= 'Z')||LA12_26=='_'||(LA12_26 >= 'a' && LA12_26 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 60;}
						else if ( (LA12_26==' '||LA12_26=='.') && ((stringterm))) {s = 58;}
						else s = 63;
						 
						input.seek(index12_26);
						if ( s>=0 ) return s;
						break;

					case 64 : 
						int LA12_55 = input.LA(1);
						 
						int index12_55 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_55==' '||LA12_55=='.'||(LA12_55 >= '0' && LA12_55 <= '9')||(LA12_55 >= 'A' && LA12_55 <= 'Z')||LA12_55=='_'||(LA12_55 >= 'a' && LA12_55 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 94;
						 
						input.seek(index12_55);
						if ( s>=0 ) return s;
						break;

					case 65 : 
						int LA12_124 = input.LA(1);
						 
						int index12_124 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_124==' '||LA12_124=='.'||(LA12_124 >= '0' && LA12_124 <= '9')||(LA12_124 >= 'A' && LA12_124 <= 'Z')||LA12_124=='_'||(LA12_124 >= 'a' && LA12_124 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 140;
						 
						input.seek(index12_124);
						if ( s>=0 ) return s;
						break;

					case 66 : 
						int LA12_59 = input.LA(1);
						 
						int index12_59 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 97;}
						else if ( ((stringterm)) ) {s = 58;}
						else if ( ((!stringterm)) ) {s = 98;}
						 
						input.seek(index12_59);
						if ( s>=0 ) return s;
						break;

					case 67 : 
						int LA12_67 = input.LA(1);
						 
						int index12_67 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_67 >= '0' && LA12_67 <= '9')||(LA12_67 >= 'A' && LA12_67 <= 'Z')||LA12_67=='_'||(LA12_67 >= 'a' && LA12_67 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_67==' '||LA12_67=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_67);
						if ( s>=0 ) return s;
						break;

					case 68 : 
						int LA12_61 = input.LA(1);
						 
						int index12_61 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 99;}
						else if ( ((stringterm)) ) {s = 58;}
						else if ( ((!stringterm)) ) {s = 98;}
						 
						input.seek(index12_61);
						if ( s>=0 ) return s;
						break;

					case 69 : 
						int LA12_134 = input.LA(1);
						 
						int index12_134 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting == 0)) ) {s = 150;}
						else if ( ((stringterm)) ) {s = 58;}
						else if ( ((!stringterm)) ) {s = 98;}
						 
						input.seek(index12_134);
						if ( s>=0 ) return s;
						break;

					case 70 : 
						int LA12_133 = input.LA(1);
						 
						int index12_133 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_133==' '||LA12_133=='.'||(LA12_133 >= '0' && LA12_133 <= '9')||(LA12_133 >= 'A' && LA12_133 <= 'Z')||LA12_133=='_'||(LA12_133 >= 'a' && LA12_133 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 149;
						 
						input.seek(index12_133);
						if ( s>=0 ) return s;
						break;

					case 71 : 
						int LA12_135 = input.LA(1);
						 
						int index12_135 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 151;}
						else if ( ((stringterm)) ) {s = 58;}
						else if ( ((!stringterm)) ) {s = 98;}
						 
						input.seek(index12_135);
						if ( s>=0 ) return s;
						break;

					case 72 : 
						int LA12_171 = input.LA(1);
						 
						int index12_171 = input.index();
						input.rewind();
						s = -1;
						if ( ((sq_nesting > 0)) ) {s = 177;}
						else if ( ((stringterm)) ) {s = 58;}
						else if ( ((!stringterm)) ) {s = 103;}
						 
						input.seek(index12_171);
						if ( s>=0 ) return s;
						break;

					case 73 : 
						int LA12_172 = input.LA(1);
						 
						int index12_172 = input.index();
						input.rewind();
						s = -1;
						if ( ((sq_nesting > 0)) ) {s = 178;}
						else if ( ((stringterm)) ) {s = 58;}
						else if ( ((!stringterm)) ) {s = 103;}
						 
						input.seek(index12_172);
						if ( s>=0 ) return s;
						break;

					case 74 : 
						int LA12_4 = input.LA(1);
						 
						int index12_4 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_4 >= '0' && LA12_4 <= '9')||(LA12_4 >= 'A' && LA12_4 <= 'Z')||LA12_4=='_'||(LA12_4 >= 'a' && LA12_4 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 60;}
						else if ( (LA12_4==' '||LA12_4=='.') && ((stringterm))) {s = 58;}
						else s = 59;
						 
						input.seek(index12_4);
						if ( s>=0 ) return s;
						break;

					case 75 : 
						int LA12_49 = input.LA(1);
						 
						int index12_49 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_49=='a') ) {s = 88;}
						else s = 58;
						 
						input.seek(index12_49);
						if ( s>=0 ) return s;
						break;

					case 76 : 
						int LA12_88 = input.LA(1);
						 
						int index12_88 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_88=='l') ) {s = 111;}
						else if ( (LA12_88=='p') ) {s = 112;}
						else s = 58;
						 
						input.seek(index12_88);
						if ( s>=0 ) return s;
						break;

					case 77 : 
						int LA12_123 = input.LA(1);
						 
						int index12_123 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_123==' '||LA12_123=='.'||(LA12_123 >= '0' && LA12_123 <= '9')||(LA12_123 >= 'A' && LA12_123 <= 'Z')||LA12_123=='_'||(LA12_123 >= 'a' && LA12_123 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 139;
						 
						input.seek(index12_123);
						if ( s>=0 ) return s;
						break;

					case 78 : 
						int LA12_27 = input.LA(1);
						 
						int index12_27 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_27 >= '0' && LA12_27 <= '9')) && (((stringterm)||(!stringterm)))) {s = 80;}
						else if ( (LA12_27==' '||LA12_27=='.'||(LA12_27 >= 'A' && LA12_27 <= 'Z')||LA12_27=='_'||(LA12_27 >= 'a' && LA12_27 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 79;
						 
						input.seek(index12_27);
						if ( s>=0 ) return s;
						break;

					case 79 : 
						int LA12_60 = input.LA(1);
						 
						int index12_60 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_60 >= '0' && LA12_60 <= '9')||(LA12_60 >= 'A' && LA12_60 <= 'Z')||LA12_60=='_'||(LA12_60 >= 'a' && LA12_60 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 60;}
						else if ( (LA12_60==' '||LA12_60=='.') && ((stringterm))) {s = 58;}
						else s = 63;
						 
						input.seek(index12_60);
						if ( s>=0 ) return s;
						break;

					case 80 : 
						int LA12_118 = input.LA(1);
						 
						int index12_118 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_118 >= '0' && LA12_118 <= '9')||(LA12_118 >= 'A' && LA12_118 <= 'Z')||LA12_118=='_'||(LA12_118 >= 'a' && LA12_118 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 60;}
						else if ( (LA12_118==' '||LA12_118=='.') && ((stringterm))) {s = 58;}
						else s = 134;
						 
						input.seek(index12_118);
						if ( s>=0 ) return s;
						break;

					case 81 : 
						int LA12_5 = input.LA(1);
						 
						int index12_5 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_5 >= '0' && LA12_5 <= '9')||(LA12_5 >= 'A' && LA12_5 <= 'Z')||LA12_5=='_'||(LA12_5 >= 'a' && LA12_5 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 60;}
						else if ( (LA12_5==' '||LA12_5=='.') && ((stringterm))) {s = 58;}
						else s = 61;
						 
						input.seek(index12_5);
						if ( s>=0 ) return s;
						break;

					case 82 : 
						int LA12_47 = input.LA(1);
						 
						int index12_47 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_47=='e') ) {s = 85;}
						else if ( (LA12_47=='u') ) {s = 86;}
						else s = 58;
						 
						input.seek(index12_47);
						if ( s>=0 ) return s;
						break;

					case 83 : 
						int LA12_8 = input.LA(1);
						 
						int index12_8 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_8=='c') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 65;}
						else if ( ((LA12_8 >= '0' && LA12_8 <= '9')||(LA12_8 >= 'A' && LA12_8 <= 'Z')||LA12_8=='_'||(LA12_8 >= 'a' && LA12_8 <= 'b')||(LA12_8 >= 'd' && LA12_8 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_8==' '||LA12_8=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_8);
						if ( s>=0 ) return s;
						break;

					case 84 : 
						int LA12_48 = input.LA(1);
						 
						int index12_48 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_48=='e') ) {s = 87;}
						else s = 58;
						 
						input.seek(index12_48);
						if ( s>=0 ) return s;
						break;

					case 85 : 
						int LA12_87 = input.LA(1);
						 
						int index12_87 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_87=='c') ) {s = 110;}
						else s = 58;
						 
						input.seek(index12_87);
						if ( s>=0 ) return s;
						break;

					case 86 : 
						int LA12_110 = input.LA(1);
						 
						int index12_110 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_110=='e') ) {s = 126;}
						else s = 58;
						 
						input.seek(index12_110);
						if ( s>=0 ) return s;
						break;

					case 87 : 
						int LA12_175 = input.LA(1);
						 
						int index12_175 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_175==' '||LA12_175=='.'||(LA12_175 >= '0' && LA12_175 <= '9')||(LA12_175 >= 'A' && LA12_175 <= 'Z')||LA12_175=='_'||(LA12_175 >= 'a' && LA12_175 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 182;
						 
						input.seek(index12_175);
						if ( s>=0 ) return s;
						break;

					case 88 : 
						int LA12_126 = input.LA(1);
						 
						int index12_126 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_126=='i') ) {s = 142;}
						else s = 58;
						 
						input.seek(index12_126);
						if ( s>=0 ) return s;
						break;

					case 89 : 
						int LA12_142 = input.LA(1);
						 
						int index12_142 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_142=='v') ) {s = 158;}
						else s = 58;
						 
						input.seek(index12_142);
						if ( s>=0 ) return s;
						break;

					case 90 : 
						int LA12_158 = input.LA(1);
						 
						int index12_158 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_158=='e') ) {s = 168;}
						else s = 58;
						 
						input.seek(index12_158);
						if ( s>=0 ) return s;
						break;

					case 91 : 
						int LA12_168 = input.LA(1);
						 
						int index12_168 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_168=='d') ) {s = 175;}
						else s = 58;
						 
						input.seek(index12_168);
						if ( s>=0 ) return s;
						break;

					case 92 : 
						int LA12_9 = input.LA(1);
						 
						int index12_9 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_9=='e') && (((sq_nesting > 0)||(stringterm)||(!stringterm)))) {s = 68;}
						else if ( ((LA12_9 >= '0' && LA12_9 <= '9')||(LA12_9 >= 'A' && LA12_9 <= 'Z')||LA12_9=='_'||(LA12_9 >= 'a' && LA12_9 <= 'd')||(LA12_9 >= 'f' && LA12_9 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_9==' '||LA12_9=='.') && ((stringterm))) {s = 58;}
						else s = 66;
						 
						input.seek(index12_9);
						if ( s>=0 ) return s;
						break;

					case 93 : 
						int LA12_164 = input.LA(1);
						 
						int index12_164 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA12_164 >= '0' && LA12_164 <= '9')||(LA12_164 >= 'A' && LA12_164 <= 'Z')||LA12_164=='_'||(LA12_164 >= 'a' && LA12_164 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 67;}
						else if ( (LA12_164==' '||LA12_164=='.') && ((stringterm))) {s = 58;}
						else s = 171;
						 
						input.seek(index12_164);
						if ( s>=0 ) return s;
						break;

					case 94 : 
						int LA12_111 = input.LA(1);
						 
						int index12_111 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_111=='c') ) {s = 127;}
						else s = 58;
						 
						input.seek(index12_111);
						if ( s>=0 ) return s;
						break;

					case 95 : 
						int LA12_85 = input.LA(1);
						 
						int index12_85 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_85=='n') ) {s = 108;}
						else s = 58;
						 
						input.seek(index12_85);
						if ( s>=0 ) return s;
						break;

					case 96 : 
						int LA12_127 = input.LA(1);
						 
						int index12_127 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_127=='u') ) {s = 143;}
						else s = 58;
						 
						input.seek(index12_127);
						if ( s>=0 ) return s;
						break;

					case 97 : 
						int LA12_143 = input.LA(1);
						 
						int index12_143 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_143=='l') ) {s = 159;}
						else s = 58;
						 
						input.seek(index12_143);
						if ( s>=0 ) return s;
						break;

					case 98 : 
						int LA12_108 = input.LA(1);
						 
						int index12_108 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_108=='d') ) {s = 123;}
						else if ( (LA12_108=='t') && (((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)||(stringterm)))) {s = 124;}
						else s = 58;
						 
						input.seek(index12_108);
						if ( s>=0 ) return s;
						break;

					case 99 : 
						int LA12_159 = input.LA(1);
						 
						int index12_159 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_159=='a') ) {s = 169;}
						else s = 58;
						 
						input.seek(index12_159);
						if ( s>=0 ) return s;
						break;

					case 100 : 
						int LA12_28 = input.LA(1);
						 
						int index12_28 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_28==' '||LA12_28=='.'||(LA12_28 >= '0' && LA12_28 <= '9')||(LA12_28 >= 'A' && LA12_28 <= 'Z')||LA12_28=='_'||(LA12_28 >= 'a' && LA12_28 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 81;
						 
						input.seek(index12_28);
						if ( s>=0 ) return s;
						break;

					case 101 : 
						int LA12_169 = input.LA(1);
						 
						int index12_169 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_169=='t') ) {s = 176;}
						else s = 58;
						 
						input.seek(index12_169);
						if ( s>=0 ) return s;
						break;

					case 102 : 
						int LA12_176 = input.LA(1);
						 
						int index12_176 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_176=='e') ) {s = 183;}
						else s = 58;
						 
						input.seek(index12_176);
						if ( s>=0 ) return s;
						break;

					case 103 : 
						int LA12_183 = input.LA(1);
						 
						int index12_183 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_183==' '||LA12_183=='.'||(LA12_183 >= '0' && LA12_183 <= '9')||(LA12_183 >= 'A' && LA12_183 <= 'Z')||LA12_183=='_'||(LA12_183 >= 'a' && LA12_183 <= 'z')) && ((stringterm))) {s = 58;}
						else s = 186;
						 
						input.seek(index12_183);
						if ( s>=0 ) return s;
						break;

					case 104 : 
						int LA12_50 = input.LA(1);
						 
						int index12_50 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_50=='u') ) {s = 89;}
						else s = 58;
						 
						input.seek(index12_50);
						if ( s>=0 ) return s;
						break;

					case 105 : 
						int LA12_89 = input.LA(1);
						 
						int index12_89 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_89=='e') ) {s = 113;}
						else s = 58;
						 
						input.seek(index12_89);
						if ( s>=0 ) return s;
						break;

					case 106 : 
						int LA12_113 = input.LA(1);
						 
						int index12_113 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_113=='r') ) {s = 129;}
						else s = 58;
						 
						input.seek(index12_113);
						if ( s>=0 ) return s;
						break;

					case 107 : 
						int LA12_129 = input.LA(1);
						 
						int index12_129 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_129=='y') ) {s = 145;}
						else s = 58;
						 
						input.seek(index12_129);
						if ( s>=0 ) return s;
						break;

					case 108 : 
						int LA12_139 = input.LA(1);
						 
						int index12_139 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 155;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_139);
						if ( s>=0 ) return s;
						break;

					case 109 : 
						int LA12_182 = input.LA(1);
						 
						int index12_182 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 185;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_182);
						if ( s>=0 ) return s;
						break;

					case 110 : 
						int LA12_186 = input.LA(1);
						 
						int index12_186 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 188;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_186);
						if ( s>=0 ) return s;
						break;

					case 111 : 
						int LA12_6 = input.LA(1);
						 
						int index12_6 = input.index();
						input.rewind();
						s = -1;
						if ( (LA12_6=='A') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 62;}
						else if ( ((LA12_6 >= '0' && LA12_6 <= '9')||(LA12_6 >= 'B' && LA12_6 <= 'Z')||LA12_6=='_'||(LA12_6 >= 'a' && LA12_6 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 60;}
						else if ( (LA12_6==' '||LA12_6=='.') && ((stringterm))) {s = 58;}
						else s = 63;
						 
						input.seek(index12_6);
						if ( s>=0 ) return s;
						break;

					case 112 : 
						int LA12_160 = input.LA(1);
						 
						int index12_160 = input.index();
						input.rewind();
						s = -1;
						if ( (!(((stringterm)))) ) {s = 170;}
						else if ( ((stringterm)) ) {s = 58;}
						 
						input.seek(index12_160);
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
