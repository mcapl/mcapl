// $ANTLR 3.4 /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g 2013-08-06 18:20:24

package eass.parser;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class EASSLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ABSTRACTION=4;
    public static final int ACHIEVE=5;
    public static final int ACHIEVEGOAL=6;
    public static final int BELIEFRULES=7;
    public static final int BELIEFS=8;
    public static final int BELIEVE=9;
    public static final int BRULEARROW=10;
    public static final int CALCULATE=11;
    public static final int CLOSE=12;
    public static final int COLON=13;
    public static final int COMMA=14;
    public static final int COMMENT=15;
    public static final int CONST=16;
    public static final int CURLYCLOSE=17;
    public static final int CURLYOPEN=18;
    public static final int DIV=19;
    public static final int DOUBLEQUOTE=20;
    public static final int EASS=21;
    public static final int EQ=22;
    public static final int EQ_ASSGN=23;
    public static final int GOAL=24;
    public static final int GOALS=25;
    public static final int LESS=26;
    public static final int LINE_COMMENT=27;
    public static final int LOCK=28;
    public static final int MINUS=29;
    public static final int MOD=30;
    public static final int MULT=31;
    public static final int NAME=32;
    public static final int NEWLINE=33;
    public static final int NOT=34;
    public static final int NUMBER=35;
    public static final int OPEN=36;
    public static final int PERFORM=37;
    public static final int PERFORMGOAL=38;
    public static final int PLANS=39;
    public static final int PLUS=40;
    public static final int POINT=41;
    public static final int QUERY=42;
    public static final int QUERYCOM=43;
    public static final int RECEIVED=44;
    public static final int RULEARROW=45;
    public static final int SEMI=46;
    public static final int SEND=47;
    public static final int SENT=48;
    public static final int SHRIEK=49;
    public static final int SQCLOSE=50;
    public static final int SQOPEN=51;
    public static final int STRING=52;
    public static final int TELL=53;
    public static final int TRUE=54;
    public static final int UPDATE=55;
    public static final int VAR=56;
    public static final int WAIT=57;
    public static final int WS=58;

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
    public String getGrammarFileName() { return "/Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g"; }

    // $ANTLR start "UPDATE"
    public final void mUPDATE() throws RecognitionException {
        try {
            int _type = UPDATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:152:9: ( '' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:152:11: ''
            {
            match('\u00B1'); 

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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:153:6: ( ':tell' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:153:8: ':tell'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:154:9: ( ':perform' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:154:11: ':perform'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:155:9: ( ':achieve' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:155:11: ':achieve'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:156:6: ( '.send' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:156:8: '.send'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:157:9: ( '.received' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:157:11: '.received'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:159:2: ( '.calculate' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:159:4: '.calculate'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:160:10: ( '.query' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:160:12: '.query'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:161:6: ( '.wait' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:161:8: '.wait'
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

    // $ANTLR start "BELIEVE"
    public final void mBELIEVE() throws RecognitionException {
        try {
            int _type = BELIEVE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:162:9: ({...}? => ( 'B' | '.B' ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:162:11: {...}? => ( 'B' | '.B' )
            {
            if ( !((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {
                throw new FailedPredicateException(input, "BELIEVE", "curly_nesting > 0 && plain_nesting == 0 || belief_rules==1");
            }

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:162:75: ( 'B' | '.B' )
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
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:162:76: 'B'
                    {
                    match('B'); 

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:162:82: '.B'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:6: ({...}? => ( 'G' | '.G' ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:8: {...}? => ( 'G' | '.G' )
            {
            if ( !((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {
                throw new FailedPredicateException(input, "GOAL", "curly_nesting > 0 && plain_nesting == 0|| belief_rules==1");
            }

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:71: ( 'G' | '.G' )
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
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:72: 'G'
                    {
                    match('G'); 

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:78: '.G'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:164:6: ({...}? => '.sent' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:164:8: {...}? => '.sent'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:165:6: ( '.lock' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:165:8: '.lock'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:166:7: ( ':Initial Goals:' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:166:9: ':Initial Goals:'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:167:9: ( ':Initial Beliefs:' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:167:11: ':Initial Beliefs:'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:169:2: ( ':Belief Rules:' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:169:4: ':Belief Rules:'
            {
            match(":Belief Rules:"); 



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

    // $ANTLR start "PLANS"
    public final void mPLANS() throws RecognitionException {
        try {
            int _type = PLANS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:170:7: ( ':Plans:' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:170:9: ':Plans:'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:171:6: ({...}? => 'EASS' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:171:8: {...}? => 'EASS'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:172:6: ( ':name:' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:172:8: ':name:'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:174:2: ( ':abstraction:' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:174:4: ':abstraction:'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:175:6: ({...}? => 'True' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:175:8: {...}? => 'True'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:176:13: ({...}? => 'achieve' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:176:15: {...}? => 'achieve'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:177:13: ({...}? => 'perform' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:177:15: {...}? => 'perform'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:180:2: ( ':-' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:180:4: ':-'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:11: ( '<-' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:13: '<-'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:182:10: ( '=' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:182:12: '='
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

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:235:5: ( '/*' ( . )* '*/' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:235:7: '/*' ( . )* '*/'
            {
            match("/*"); 



            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:235:12: ( . )*
            loop3:
            do {
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
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:235:12: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 



            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:12: (~ ( '\\n' | '\\r' ) )*
            loop4:
            do {
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
            } while (true);


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:26: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:26: '\\r'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:240:8: ( ( '\\r' )? '\\n' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:240:9: ( '\\r' )? '\\n'
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:240:9: ( '\\r' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:240:9: '\\r'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:5: ( ( ' ' | '\\t' )+ )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:9: ( ' ' | '\\t' )+
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:9: ( ' ' | '\\t' )+
            int cnt7=0;
            loop7:
            do {
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
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:244:6: ( '(' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:244:9: '('
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:245:7: ( ')' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:245:9: ')'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:246:8: ( '[' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:246:10: '['
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:247:9: ( ']' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:247:11: ']'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:11: ( '{' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:13: '{'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:249:12: ( '}' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:249:14: '}'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:251:2: ( '\"' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:251:4: '\"'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:5: ( '~' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:7: '~'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:255:8: ({...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:255:10: {...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
            {
            if ( !((stringterm)) ) {
                throw new FailedPredicateException(input, "STRING", "stringterm");
            }

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:255:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
                    alt8=1;
                }


                switch (alt8) {
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
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:8: ({...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:11: {...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( !((!stringterm)) ) {
                throw new FailedPredicateException(input, "CONST", "!stringterm");
            }

            matchRange('a','z'); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop9:
            do {
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
            } while (true);


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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:257:5: ({...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:257:7: {...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( !((!stringterm)) ) {
                throw new FailedPredicateException(input, "VAR", "!stringterm");
            }

            matchRange('A','Z'); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:257:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop10:
            do {
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
            } while (true);


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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:258:8: ({...}? => '0' .. '9' ( '0' .. '9' )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:258:10: {...}? => '0' .. '9' ( '0' .. '9' )*
            {
            if ( !((!stringterm)) ) {
                throw new FailedPredicateException(input, "NUMBER", "!stringterm");
            }

            matchRange('0','9'); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:258:35: ( '0' .. '9' )*
            loop11:
            do {
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
            } while (true);


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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:261:6: ( '<' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:261:8: '<'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:4: ( '==' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:7: '=='
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:263:7: ( '.' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:263:9: '.'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:264:6: ( '*' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:264:8: '*'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:6: ( '+' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:8: '+'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:266:7: ( '-' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:266:9: '-'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:267:5: ( '/' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:267:7: '/'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:268:5: ( '%' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:268:7: '%'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:270:8: ( '!' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:270:10: '!'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:271:7: ( ',' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:271:9: ','
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:272:6: ( ';' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:272:8: ';'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:273:7: ( ':' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:273:9: ':'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:274:7: ( '?' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:274:9: '?'
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

    public void mTokens() throws RecognitionException {
        // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:8: ( UPDATE | TELL | PERFORM | ACHIEVE | SEND | RECEIVED | CALCULATE | QUERYCOM | WAIT | BELIEVE | GOAL | SENT | LOCK | GOALS | BELIEFS | BELIEFRULES | PLANS | EASS | NAME | ABSTRACTION | TRUE | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | EQ_ASSGN | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY )
        int alt12=55;
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
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:76: BELIEVE
                {
                mBELIEVE(); 


                }
                break;
            case 11 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:84: GOAL
                {
                mGOAL(); 


                }
                break;
            case 12 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:89: SENT
                {
                mSENT(); 


                }
                break;
            case 13 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:94: LOCK
                {
                mLOCK(); 


                }
                break;
            case 14 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:99: GOALS
                {
                mGOALS(); 


                }
                break;
            case 15 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:105: BELIEFS
                {
                mBELIEFS(); 


                }
                break;
            case 16 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:113: BELIEFRULES
                {
                mBELIEFRULES(); 


                }
                break;
            case 17 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:125: PLANS
                {
                mPLANS(); 


                }
                break;
            case 18 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:131: EASS
                {
                mEASS(); 


                }
                break;
            case 19 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:136: NAME
                {
                mNAME(); 


                }
                break;
            case 20 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:141: ABSTRACTION
                {
                mABSTRACTION(); 


                }
                break;
            case 21 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:153: TRUE
                {
                mTRUE(); 


                }
                break;
            case 22 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:158: ACHIEVEGOAL
                {
                mACHIEVEGOAL(); 


                }
                break;
            case 23 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:170: PERFORMGOAL
                {
                mPERFORMGOAL(); 


                }
                break;
            case 24 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:182: BRULEARROW
                {
                mBRULEARROW(); 


                }
                break;
            case 25 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:193: RULEARROW
                {
                mRULEARROW(); 


                }
                break;
            case 26 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:203: EQ_ASSGN
                {
                mEQ_ASSGN(); 


                }
                break;
            case 27 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:212: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 28 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:220: LINE_COMMENT
                {
                mLINE_COMMENT(); 


                }
                break;
            case 29 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:233: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 30 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:241: WS
                {
                mWS(); 


                }
                break;
            case 31 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:244: OPEN
                {
                mOPEN(); 


                }
                break;
            case 32 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:249: CLOSE
                {
                mCLOSE(); 


                }
                break;
            case 33 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:255: SQOPEN
                {
                mSQOPEN(); 


                }
                break;
            case 34 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:262: SQCLOSE
                {
                mSQCLOSE(); 


                }
                break;
            case 35 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:270: CURLYOPEN
                {
                mCURLYOPEN(); 


                }
                break;
            case 36 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:280: CURLYCLOSE
                {
                mCURLYCLOSE(); 


                }
                break;
            case 37 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:291: DOUBLEQUOTE
                {
                mDOUBLEQUOTE(); 


                }
                break;
            case 38 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:303: NOT
                {
                mNOT(); 


                }
                break;
            case 39 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:307: STRING
                {
                mSTRING(); 


                }
                break;
            case 40 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:314: CONST
                {
                mCONST(); 


                }
                break;
            case 41 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:320: VAR
                {
                mVAR(); 


                }
                break;
            case 42 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:324: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 43 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:331: LESS
                {
                mLESS(); 


                }
                break;
            case 44 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:336: EQ
                {
                mEQ(); 


                }
                break;
            case 45 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:339: POINT
                {
                mPOINT(); 


                }
                break;
            case 46 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:345: MULT
                {
                mMULT(); 


                }
                break;
            case 47 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:350: PLUS
                {
                mPLUS(); 


                }
                break;
            case 48 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:355: MINUS
                {
                mMINUS(); 


                }
                break;
            case 49 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:361: DIV
                {
                mDIV(); 


                }
                break;
            case 50 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:365: MOD
                {
                mMOD(); 


                }
                break;
            case 51 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:369: SHRIEK
                {
                mSHRIEK(); 


                }
                break;
            case 52 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:376: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 53 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:382: SEMI
                {
                mSEMI(); 


                }
                break;
            case 54 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:387: COLON
                {
                mCOLON(); 


                }
                break;
            case 55 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:1:393: QUERY
                {
                mQUERY(); 


                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\2\uffff\1\53\1\64\1\65\1\67\2\71\2\74\1\100\1\102\1\105\12\uffff"+
        "\1\74\1\71\1\106\34\uffff\1\71\1\uffff\1\71\1\uffff\1\71\1\74\1"+
        "\uffff\2\74\10\uffff\1\106\5\uffff\2\71\1\74\1\uffff\1\74\3\uffff"+
        "\1\134\1\135\2\74\5\uffff\2\74\3\uffff\2\74\1\uffff\1\151\1\152"+
        "\10\uffff";
    static final String DFA12_eofS =
        "\160\uffff";
    static final String DFA12_minS =
        "\1\11\1\uffff\1\55\1\102\6\60\1\55\1\75\1\52\12\uffff\3\60\13\uffff"+
        "\1\142\1\156\5\uffff\1\145\10\uffff\1\0\1\60\1\0\1\60\1\0\2\60\1"+
        "\0\2\60\7\uffff\1\0\1\60\2\uffff\1\151\1\156\1\uffff\3\60\1\uffff"+
        "\1\60\1\uffff\1\164\1\144\4\60\1\151\2\uffff\2\0\2\60\1\141\2\uffff"+
        "\2\60\1\154\2\60\1\40\2\0\1\102\4\uffff";
    static final String DFA12_maxS =
        "\1\u00b1\1\uffff\1\164\1\167\6\172\1\55\1\75\1\57\12\uffff\3\172"+
        "\13\uffff\1\143\1\156\5\uffff\1\145\10\uffff\1\0\1\172\1\0\1\172"+
        "\1\0\2\172\1\0\2\172\7\uffff\1\0\1\172\2\uffff\1\151\1\156\1\uffff"+
        "\3\172\1\uffff\1\172\1\uffff\2\164\4\172\1\151\2\uffff\2\0\2\172"+
        "\1\141\2\uffff\2\172\1\154\2\172\1\40\2\0\1\107\4\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\13\uffff\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1"+
        "\45\1\46\3\uffff\1\47\1\56\1\57\1\60\1\62\1\63\1\64\1\65\1\67\1"+
        "\2\1\3\2\uffff\1\20\1\21\1\23\1\30\1\66\1\uffff\1\6\1\7\1\10\1\11"+
        "\1\12\1\13\1\15\1\55\12\uffff\1\31\1\53\1\54\1\32\1\33\1\34\1\61"+
        "\2\uffff\1\4\1\24\2\uffff\1\51\3\uffff\1\50\1\uffff\1\52\7\uffff"+
        "\1\5\1\14\5\uffff\1\22\1\25\11\uffff\1\26\1\27\1\16\1\17";
    static final String DFA12_specialS =
        "\1\45\2\uffff\1\33\1\12\1\34\1\47\1\30\1\40\1\50\15\uffff\1\27\1"+
        "\46\1\32\33\uffff\1\36\1\31\1\35\1\14\1\23\1\1\1\5\1\24\1\43\1\13"+
        "\7\uffff\1\22\1\25\5\uffff\1\16\1\3\1\6\1\uffff\1\15\2\uffff\1\26"+
        "\1\4\1\51\1\7\1\17\3\uffff\1\37\1\44\1\10\1\20\3\uffff\1\11\1\21"+
        "\1\uffff\1\2\1\0\1\uffff\1\42\1\41\5\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\16\1\15\2\uffff\1\15\22\uffff\1\16\1\37\1\25\2\uffff\1\36"+
            "\2\uffff\1\17\1\20\1\33\1\34\1\40\1\35\1\3\1\14\12\31\1\2\1"+
            "\41\1\12\1\13\1\uffff\1\42\1\uffff\1\30\1\4\2\30\1\6\1\30\1"+
            "\5\14\30\1\7\6\30\1\21\1\uffff\1\22\1\uffff\1\32\1\uffff\1\10"+
            "\16\27\1\11\12\27\1\23\1\uffff\1\24\1\26\62\uffff\1\1",
            "",
            "\1\52\24\uffff\1\47\6\uffff\1\46\6\uffff\1\50\20\uffff\1\45"+
            "\14\uffff\1\51\1\uffff\1\44\3\uffff\1\43",
            "\1\61\4\uffff\1\62\33\uffff\1\56\10\uffff\1\63\4\uffff\1\57"+
            "\1\55\1\54\3\uffff\1\60",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\1\70\31\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\72\10\66",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\2\75\1\73\27\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75\1\76\25\75",
            "\1\77",
            "\1\101",
            "\1\103\4\uffff\1\104",
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
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\107\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
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
            "\1\111\1\110",
            "\1\112",
            "",
            "",
            "",
            "",
            "",
            "\1\113",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\uffff",
            "\12\66\7\uffff\22\66\1\115\7\66\4\uffff\1\66\1\uffff\32\66",
            "\1\uffff",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\116\5\66",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\7\75\1\117\22\75",
            "\1\uffff",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\21\75\1\121\10\75",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\12\107\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\1\123",
            "\1\124",
            "",
            "\12\66\7\uffff\22\66\1\125\7\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\126\25\66",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\10\75\1\127\21\75",
            "",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\5\75\1\130\24\75",
            "",
            "\1\131",
            "\1\132\17\uffff\1\133",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75\1\136\25\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\16\75\1\137\13\75",
            "\1\140",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\25\75\1\143\4\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\21\75\1\144\10\75",
            "\1\145",
            "",
            "",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75\1\146\25\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\14\75\1\147\15\75",
            "\1\150",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\153",
            "\1\uffff",
            "\1\uffff",
            "\1\157\4\uffff\1\156",
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

    class DFA12 extends DFA {

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
        public String getDescription() {
            return "1:1: Tokens : ( UPDATE | TELL | PERFORM | ACHIEVE | SEND | RECEIVED | CALCULATE | QUERYCOM | WAIT | BELIEVE | GOAL | SENT | LOCK | GOALS | BELIEFS | BELIEFRULES | PLANS | EASS | NAME | ABSTRACTION | TRUE | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | EQ_ASSGN | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_103 = input.LA(1);

                         
                        int index12_103 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_103 >= '0' && LA12_103 <= '9')||(LA12_103 >= 'A' && LA12_103 <= 'Z')||LA12_103=='_'||(LA12_103 >= 'a' && LA12_103 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 106;

                         
                        input.seek(index12_103);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA12_58 = input.LA(1);

                         
                        int index12_58 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_58=='u') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 78;}

                        else if ( ((LA12_58 >= '0' && LA12_58 <= '9')||(LA12_58 >= 'A' && LA12_58 <= 'Z')||LA12_58=='_'||(LA12_58 >= 'a' && LA12_58 <= 't')||(LA12_58 >= 'v' && LA12_58 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 54;}

                        else s = 57;

                         
                        input.seek(index12_58);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA12_102 = input.LA(1);

                         
                        int index12_102 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_102 >= '0' && LA12_102 <= '9')||(LA12_102 >= 'A' && LA12_102 <= 'Z')||LA12_102=='_'||(LA12_102 >= 'a' && LA12_102 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 105;

                         
                        input.seek(index12_102);

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA12_78 = input.LA(1);

                         
                        int index12_78 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_78=='e') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 86;}

                        else if ( ((LA12_78 >= '0' && LA12_78 <= '9')||(LA12_78 >= 'A' && LA12_78 <= 'Z')||LA12_78=='_'||(LA12_78 >= 'a' && LA12_78 <= 'd')||(LA12_78 >= 'f' && LA12_78 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 54;}

                        else s = 57;

                         
                        input.seek(index12_78);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA12_85 = input.LA(1);

                         
                        int index12_85 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_85 >= '0' && LA12_85 <= '9')||(LA12_85 >= 'A' && LA12_85 <= 'Z')||LA12_85=='_'||(LA12_85 >= 'a' && LA12_85 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 54;}

                        else s = 92;

                         
                        input.seek(index12_85);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA12_59 = input.LA(1);

                         
                        int index12_59 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_59=='h') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 79;}

                        else if ( ((LA12_59 >= '0' && LA12_59 <= '9')||(LA12_59 >= 'A' && LA12_59 <= 'Z')||LA12_59=='_'||(LA12_59 >= 'a' && LA12_59 <= 'g')||(LA12_59 >= 'i' && LA12_59 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_59);

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA12_79 = input.LA(1);

                         
                        int index12_79 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_79=='i') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 87;}

                        else if ( ((LA12_79 >= '0' && LA12_79 <= '9')||(LA12_79 >= 'A' && LA12_79 <= 'Z')||LA12_79=='_'||(LA12_79 >= 'a' && LA12_79 <= 'h')||(LA12_79 >= 'j' && LA12_79 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_79);

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA12_87 = input.LA(1);

                         
                        int index12_87 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_87=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 94;}

                        else if ( ((LA12_87 >= '0' && LA12_87 <= '9')||(LA12_87 >= 'A' && LA12_87 <= 'Z')||LA12_87=='_'||(LA12_87 >= 'a' && LA12_87 <= 'd')||(LA12_87 >= 'f' && LA12_87 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_87);

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA12_94 = input.LA(1);

                         
                        int index12_94 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_94=='v') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 99;}

                        else if ( ((LA12_94 >= '0' && LA12_94 <= '9')||(LA12_94 >= 'A' && LA12_94 <= 'Z')||LA12_94=='_'||(LA12_94 >= 'a' && LA12_94 <= 'u')||(LA12_94 >= 'w' && LA12_94 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_94);

                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA12_99 = input.LA(1);

                         
                        int index12_99 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_99=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 102;}

                        else if ( ((LA12_99 >= '0' && LA12_99 <= '9')||(LA12_99 >= 'A' && LA12_99 <= 'Z')||LA12_99=='_'||(LA12_99 >= 'a' && LA12_99 <= 'd')||(LA12_99 >= 'f' && LA12_99 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_99);

                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA12_4 = input.LA(1);

                         
                        int index12_4 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_4 >= '0' && LA12_4 <= '9')||(LA12_4 >= 'A' && LA12_4 <= 'Z')||LA12_4=='_'||(LA12_4 >= 'a' && LA12_4 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 54;}

                        else s = 53;

                         
                        input.seek(index12_4);

                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA12_62 = input.LA(1);

                         
                        int index12_62 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_62=='r') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 81;}

                        else if ( ((LA12_62 >= '0' && LA12_62 <= '9')||(LA12_62 >= 'A' && LA12_62 <= 'Z')||LA12_62=='_'||(LA12_62 >= 'a' && LA12_62 <= 'q')||(LA12_62 >= 's' && LA12_62 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_62);

                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA12_56 = input.LA(1);

                         
                        int index12_56 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_56=='S') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 77;}

                        else if ( ((LA12_56 >= '0' && LA12_56 <= '9')||(LA12_56 >= 'A' && LA12_56 <= 'R')||(LA12_56 >= 'T' && LA12_56 <= 'Z')||LA12_56=='_'||(LA12_56 >= 'a' && LA12_56 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 54;}

                        else s = 57;

                         
                        input.seek(index12_56);

                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA12_81 = input.LA(1);

                         
                        int index12_81 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_81=='f') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 88;}

                        else if ( ((LA12_81 >= '0' && LA12_81 <= '9')||(LA12_81 >= 'A' && LA12_81 <= 'Z')||LA12_81=='_'||(LA12_81 >= 'a' && LA12_81 <= 'e')||(LA12_81 >= 'g' && LA12_81 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_81);

                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA12_77 = input.LA(1);

                         
                        int index12_77 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_77=='S') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 85;}

                        else if ( ((LA12_77 >= '0' && LA12_77 <= '9')||(LA12_77 >= 'A' && LA12_77 <= 'R')||(LA12_77 >= 'T' && LA12_77 <= 'Z')||LA12_77=='_'||(LA12_77 >= 'a' && LA12_77 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 54;}

                        else s = 57;

                         
                        input.seek(index12_77);

                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA12_88 = input.LA(1);

                         
                        int index12_88 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_88=='o') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 95;}

                        else if ( ((LA12_88 >= '0' && LA12_88 <= '9')||(LA12_88 >= 'A' && LA12_88 <= 'Z')||LA12_88=='_'||(LA12_88 >= 'a' && LA12_88 <= 'n')||(LA12_88 >= 'p' && LA12_88 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_88);

                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA12_95 = input.LA(1);

                         
                        int index12_95 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_95=='r') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 100;}

                        else if ( ((LA12_95 >= '0' && LA12_95 <= '9')||(LA12_95 >= 'A' && LA12_95 <= 'Z')||LA12_95=='_'||(LA12_95 >= 'a' && LA12_95 <= 'q')||(LA12_95 >= 's' && LA12_95 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_95);

                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA12_100 = input.LA(1);

                         
                        int index12_100 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_100=='m') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 103;}

                        else if ( ((LA12_100 >= '0' && LA12_100 <= '9')||(LA12_100 >= 'A' && LA12_100 <= 'Z')||LA12_100=='_'||(LA12_100 >= 'a' && LA12_100 <= 'l')||(LA12_100 >= 'n' && LA12_100 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_100);

                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA12_70 = input.LA(1);

                         
                        int index12_70 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((stringterm)) ) {s = 26;}

                        else if ( ((!stringterm)) ) {s = 82;}

                         
                        input.seek(index12_70);

                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA12_57 = input.LA(1);

                         
                        int index12_57 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((stringterm)) ) {s = 26;}

                        else if ( ((!stringterm)) ) {s = 76;}

                         
                        input.seek(index12_57);

                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA12_60 = input.LA(1);

                         
                        int index12_60 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((stringterm)) ) {s = 26;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index12_60);

                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA12_71 = input.LA(1);

                         
                        int index12_71 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_71 >= '0' && LA12_71 <= '9')) && (((!stringterm)||(stringterm)))) {s = 71;}

                        else if ( ((LA12_71 >= 'A' && LA12_71 <= 'Z')||LA12_71=='_'||(LA12_71 >= 'a' && LA12_71 <= 'z')) && ((stringterm))) {s = 26;}

                        else s = 70;

                         
                        input.seek(index12_71);

                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA12_84 = input.LA(1);

                         
                        int index12_84 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_84=='d') ) {s = 90;}

                        else if ( (LA12_84=='t') && ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1))) {s = 91;}

                         
                        input.seek(index12_84);

                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA12_23 = input.LA(1);

                         
                        int index12_23 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_23 >= '0' && LA12_23 <= '9')||(LA12_23 >= 'A' && LA12_23 <= 'Z')||LA12_23=='_'||(LA12_23 >= 'a' && LA12_23 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_23);

                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA12_7 = input.LA(1);

                         
                        int index12_7 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_7=='r') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 58;}

                        else if ( ((LA12_7 >= '0' && LA12_7 <= '9')||(LA12_7 >= 'A' && LA12_7 <= 'Z')||LA12_7=='_'||(LA12_7 >= 'a' && LA12_7 <= 'q')||(LA12_7 >= 's' && LA12_7 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 54;}

                        else s = 57;

                         
                        input.seek(index12_7);

                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA12_54 = input.LA(1);

                         
                        int index12_54 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_54 >= '0' && LA12_54 <= '9')||(LA12_54 >= 'A' && LA12_54 <= 'Z')||LA12_54=='_'||(LA12_54 >= 'a' && LA12_54 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 54;}

                        else s = 57;

                         
                        input.seek(index12_54);

                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA12_25 = input.LA(1);

                         
                        int index12_25 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_25 >= '0' && LA12_25 <= '9')) && (((!stringterm)||(stringterm)))) {s = 71;}

                        else if ( ((LA12_25 >= 'A' && LA12_25 <= 'Z')||LA12_25=='_'||(LA12_25 >= 'a' && LA12_25 <= 'z')) && ((stringterm))) {s = 26;}

                        else s = 70;

                         
                        input.seek(index12_25);

                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA12_3 = input.LA(1);

                         
                        int index12_3 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_3=='s') ) {s = 44;}

                        else if ( (LA12_3=='r') ) {s = 45;}

                        else if ( (LA12_3=='c') ) {s = 46;}

                        else if ( (LA12_3=='q') ) {s = 47;}

                        else if ( (LA12_3=='w') ) {s = 48;}

                        else if ( (LA12_3=='B') && ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1))) {s = 49;}

                        else if ( (LA12_3=='G') && ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1))) {s = 50;}

                        else if ( (LA12_3=='l') ) {s = 51;}

                        else s = 52;

                         
                        input.seek(index12_3);

                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA12_5 = input.LA(1);

                         
                        int index12_5 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_5 >= '0' && LA12_5 <= '9')||(LA12_5 >= 'A' && LA12_5 <= 'Z')||LA12_5=='_'||(LA12_5 >= 'a' && LA12_5 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 54;}

                        else s = 55;

                         
                        input.seek(index12_5);

                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA12_55 = input.LA(1);

                         
                        int index12_55 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 50;}

                        else if ( ((stringterm)) ) {s = 26;}

                        else if ( ((!stringterm)) ) {s = 76;}

                         
                        input.seek(index12_55);

                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA12_53 = input.LA(1);

                         
                        int index12_53 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 49;}

                        else if ( ((stringterm)) ) {s = 26;}

                        else if ( ((!stringterm)) ) {s = 76;}

                         
                        input.seek(index12_53);

                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA12_92 = input.LA(1);

                         
                        int index12_92 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting == 0)) ) {s = 97;}

                        else if ( ((stringterm)) ) {s = 26;}

                        else if ( ((!stringterm)) ) {s = 76;}

                         
                        input.seek(index12_92);

                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA12_8 = input.LA(1);

                         
                        int index12_8 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_8=='c') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 59;}

                        else if ( ((LA12_8 >= '0' && LA12_8 <= '9')||(LA12_8 >= 'A' && LA12_8 <= 'Z')||LA12_8=='_'||(LA12_8 >= 'a' && LA12_8 <= 'b')||(LA12_8 >= 'd' && LA12_8 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_8);

                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA12_106 = input.LA(1);

                         
                        int index12_106 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((sq_nesting > 0)) ) {s = 109;}

                        else if ( ((stringterm)) ) {s = 26;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index12_106);

                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA12_105 = input.LA(1);

                         
                        int index12_105 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((sq_nesting > 0)) ) {s = 108;}

                        else if ( ((stringterm)) ) {s = 26;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index12_105);

                        if ( s>=0 ) return s;
                        break;

                    case 35 : 
                        int LA12_61 = input.LA(1);

                         
                        int index12_61 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_61 >= '0' && LA12_61 <= '9')||(LA12_61 >= 'A' && LA12_61 <= 'Z')||LA12_61=='_'||(LA12_61 >= 'a' && LA12_61 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_61);

                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA12_93 = input.LA(1);

                         
                        int index12_93 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 98;}

                        else if ( ((stringterm)) ) {s = 26;}

                        else if ( ((!stringterm)) ) {s = 76;}

                         
                        input.seek(index12_93);

                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA12_0 = input.LA(1);

                         
                        int index12_0 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_0=='\u00B1') ) {s = 1;}

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

                        else if ( (LA12_0=='/') ) {s = 12;}

                        else if ( (LA12_0=='\n'||LA12_0=='\r') ) {s = 13;}

                        else if ( (LA12_0=='\t'||LA12_0==' ') ) {s = 14;}

                        else if ( (LA12_0=='(') ) {s = 15;}

                        else if ( (LA12_0==')') ) {s = 16;}

                        else if ( (LA12_0=='[') ) {s = 17;}

                        else if ( (LA12_0==']') ) {s = 18;}

                        else if ( (LA12_0=='{') ) {s = 19;}

                        else if ( (LA12_0=='}') ) {s = 20;}

                        else if ( (LA12_0=='\"') ) {s = 21;}

                        else if ( (LA12_0=='~') ) {s = 22;}

                        else if ( ((LA12_0 >= 'b' && LA12_0 <= 'o')||(LA12_0 >= 'q' && LA12_0 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 23;}

                        else if ( (LA12_0=='A'||(LA12_0 >= 'C' && LA12_0 <= 'D')||LA12_0=='F'||(LA12_0 >= 'H' && LA12_0 <= 'S')||(LA12_0 >= 'U' && LA12_0 <= 'Z')) && (((!stringterm)||(stringterm)))) {s = 24;}

                        else if ( ((LA12_0 >= '0' && LA12_0 <= '9')) && (((!stringterm)||(stringterm)))) {s = 25;}

                        else if ( (LA12_0=='_') && ((stringterm))) {s = 26;}

                        else if ( (LA12_0=='*') ) {s = 27;}

                        else if ( (LA12_0=='+') ) {s = 28;}

                        else if ( (LA12_0=='-') ) {s = 29;}

                        else if ( (LA12_0=='%') ) {s = 30;}

                        else if ( (LA12_0=='!') ) {s = 31;}

                        else if ( (LA12_0==',') ) {s = 32;}

                        else if ( (LA12_0==';') ) {s = 33;}

                        else if ( (LA12_0=='?') ) {s = 34;}

                         
                        input.seek(index12_0);

                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA12_24 = input.LA(1);

                         
                        int index12_24 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_24 >= '0' && LA12_24 <= '9')||(LA12_24 >= 'A' && LA12_24 <= 'Z')||LA12_24=='_'||(LA12_24 >= 'a' && LA12_24 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 54;}

                        else s = 57;

                         
                        input.seek(index12_24);

                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA12_6 = input.LA(1);

                         
                        int index12_6 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_6=='A') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 56;}

                        else if ( ((LA12_6 >= '0' && LA12_6 <= '9')||(LA12_6 >= 'B' && LA12_6 <= 'Z')||LA12_6=='_'||(LA12_6 >= 'a' && LA12_6 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 54;}

                        else s = 57;

                         
                        input.seek(index12_6);

                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA12_9 = input.LA(1);

                         
                        int index12_9 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_9=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 62;}

                        else if ( ((LA12_9 >= '0' && LA12_9 <= '9')||(LA12_9 >= 'A' && LA12_9 <= 'Z')||LA12_9=='_'||(LA12_9 >= 'a' && LA12_9 <= 'd')||(LA12_9 >= 'f' && LA12_9 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 61;}

                        else s = 60;

                         
                        input.seek(index12_9);

                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA12_86 = input.LA(1);

                         
                        int index12_86 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_86 >= '0' && LA12_86 <= '9')||(LA12_86 >= 'A' && LA12_86 <= 'Z')||LA12_86=='_'||(LA12_86 >= 'a' && LA12_86 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 54;}

                        else s = 93;

                         
                        input.seek(index12_86);

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