// $ANTLR 3.4 /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g 2013-08-10 12:05:57

package gwendolen.parser;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class GwendolenLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ACHIEVE=4;
    public static final int ACHIEVEGOAL=5;
    public static final int ADD_CONSTRAINT=6;
    public static final int ADD_CONTENT=7;
    public static final int ADD_CONTEXT=8;
    public static final int ADD_PLAN=9;
    public static final int BELIEFRULES=10;
    public static final int BELIEFS=11;
    public static final int BELIEVE=12;
    public static final int BRULEARROW=13;
    public static final int CLOSE=14;
    public static final int COLON=15;
    public static final int COMMA=16;
    public static final int COMMENT=17;
    public static final int CONST=18;
    public static final int CONSTRAINT=19;
    public static final int CURLYCLOSE=20;
    public static final int CURLYOPEN=21;
    public static final int DIV=22;
    public static final int DOUBLEQUOTE=23;
    public static final int EQ=24;
    public static final int GOAL=25;
    public static final int GOALS=26;
    public static final int GWENDOLEN=27;
    public static final int IN_CONTENT=28;
    public static final int IN_CONTEXT=29;
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
    public static final int PLANS=43;
    public static final int PLUS=44;
    public static final int POINT=45;
    public static final int QUERY=46;
    public static final int RECEIVED=47;
    public static final int RULEARROW=48;
    public static final int SEMI=49;
    public static final int SEND=50;
    public static final int SENT=51;
    public static final int SHRIEK=52;
    public static final int SQCLOSE=53;
    public static final int SQOPEN=54;
    public static final int STRING=55;
    public static final int TELL=56;
    public static final int TELLHOW=57;
    public static final int TRUE=58;
    public static final int VAR=59;
    public static final int WS=60;

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
    public String getGrammarFileName() { return "/Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g"; }

    // $ANTLR start "GWENDOLEN"
    public final void mGWENDOLEN() throws RecognitionException {
        try {
            int _type = GWENDOLEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:148:11: ({...}? => 'GWENDOLEN' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:148:12: {...}? => 'GWENDOLEN'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:7: ( ':Initial Goals:' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:9: ':Initial Goals:'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:151:9: ( ':Initial Beliefs:' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:151:11: ':Initial Beliefs:'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:153:2: ( ':Belief Rules:' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:153:4: ':Belief Rules:'
            {
            match(":Belief Rules:"); 



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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:154:7: ( ':Plans:' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:154:9: ':Plans:'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:155:6: ( ':name:' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:155:8: ':name:'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:157:6: ( '.send' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:157:8: '.send'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:158:9: ({...}? => '.received' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:158:11: {...}? => '.received'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:159:9: ({...}? => ( 'B' | '.B' ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:159:11: {...}? => ( 'B' | '.B' )
            {
            if ( !((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {
                throw new FailedPredicateException(input, "BELIEVE", "curly_nesting > 0 && plain_nesting == 0 || belief_rules==1");
            }

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:159:75: ( 'B' | '.B' )
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
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:159:76: 'B'
                    {
                    match('B'); 

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:159:82: '.B'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:160:6: ({...}? => ( 'G' | '.G' ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:160:8: {...}? => ( 'G' | '.G' )
            {
            if ( !((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {
                throw new FailedPredicateException(input, "GOAL", "curly_nesting > 0 && plain_nesting == 0|| belief_rules==1");
            }

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:160:71: ( 'G' | '.G' )
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
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:160:72: 'G'
                    {
                    match('G'); 

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:160:78: '.G'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:161:12: ({...}? => ( 'N' ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:161:14: {...}? => ( 'N' )
            {
            if ( !((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {
                throw new FailedPredicateException(input, "IN_CONTENT", "curly_nesting > 0 && plain_nesting == 0 || belief_rules==1");
            }

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:161:78: ( 'N' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:161:79: 'N'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:162:12: ({...}? => ( 'X' ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:162:14: {...}? => ( 'X' )
            {
            if ( !((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {
                throw new FailedPredicateException(input, "IN_CONTEXT", "curly_nesting > 0 && plain_nesting == 0|| belief_rules==1");
            }

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:162:77: ( 'X' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:162:78: 'X'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:163:6: ({...}? => '.sent' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:163:8: {...}? => '.sent'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:164:6: ( '.lock' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:164:8: '.lock'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:165:10: ( '.plan' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:165:12: '.plan'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:166:16: ( '.constraint' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:166:18: '.constraint'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:168:2: ( '.n' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:168:4: '.n'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:169:13: ( '.x' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:169:15: '.x'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:171:6: ( ':tell' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:171:8: ':tell'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:172:9: ( ':perform' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:172:11: ':perform'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:173:9: ( ':achieve' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:173:11: ':achieve'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:174:9: ( ':how' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:174:11: ':how'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:176:2: ( ':constrain' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:176:4: ':constrain'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:178:13: ({...}? => 'achieve' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:178:15: {...}? => 'achieve'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:179:13: ({...}? => 'perform' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:179:15: {...}? => 'perform'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:181:2: ( ':-' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:181:4: ':-'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:182:11: ( '<-' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:182:13: '<-'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:184:6: ({...}? => 'True' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:184:8: {...}? => 'True'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:5: ( '/*' ( . )* '*/' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:7: '/*' ( . )* '*/'
            {
            match("/*"); 



            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:12: ( . )*
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
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:12: .
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 



            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:12: (~ ( '\\n' | '\\r' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:
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


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:26: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:26: '\\r'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:242:8: ( ( '\\r' )? '\\n' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:242:9: ( '\\r' )? '\\n'
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:242:9: ( '\\r' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:242:9: '\\r'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:243:5: ( ( ' ' | '\\t' )+ )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:243:9: ( ' ' | '\\t' )+
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:243:9: ( ' ' | '\\t' )+
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
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:246:6: ( '(' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:246:9: '('
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:247:7: ( ')' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:247:9: ')'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:248:8: ( '[' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:248:10: '['
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:249:9: ( ']' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:249:11: ']'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:250:11: ( '{' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:250:13: '{'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:251:12: ( '}' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:251:14: '}'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:253:2: ( '\"' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:253:4: '\"'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:254:5: ( '~' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:254:7: '~'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:256:8: ({...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:256:10: {...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
            {
            if ( !((stringterm)) ) {
                throw new FailedPredicateException(input, "STRING", "stringterm");
            }

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:256:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
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
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:257:8: ({...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:257:11: {...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( !((!stringterm)) ) {
                throw new FailedPredicateException(input, "CONST", "!stringterm");
            }

            matchRange('a','z'); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:257:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:258:5: ({...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:258:7: {...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( !((!stringterm)) ) {
                throw new FailedPredicateException(input, "VAR", "!stringterm");
            }

            matchRange('A','Z'); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:258:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '0' && LA10_0 <= '9')||(LA10_0 >= 'A' && LA10_0 <= 'Z')||LA10_0=='_'||(LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:259:8: ({...}? => '0' .. '9' ( '0' .. '9' )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:259:10: {...}? => '0' .. '9' ( '0' .. '9' )*
            {
            if ( !((!stringterm)) ) {
                throw new FailedPredicateException(input, "NUMBER", "!stringterm");
            }

            matchRange('0','9'); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:259:35: ( '0' .. '9' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:262:6: ( '<' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:262:8: '<'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:263:4: ( '==' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:263:7: '=='
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:264:7: ( '.' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:264:9: '.'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:265:6: ( '*' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:265:8: '*'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:266:6: ( '+' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:266:8: '+'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:267:7: ( '-' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:267:9: '-'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:268:5: ( '/' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:268:7: '/'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:269:5: ( '%' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:269:7: '%'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:271:8: ( '!' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:271:10: '!'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:272:7: ( ',' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:272:9: ','
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:273:6: ( ';' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:273:8: ';'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:274:7: ( ':' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:274:9: ':'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:275:7: ( '?' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:275:9: '?'
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
        // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:8: ( GWENDOLEN | GOALS | BELIEFS | BELIEFRULES | PLANS | NAME | SEND | RECEIVED | BELIEVE | GOAL | IN_CONTENT | IN_CONTEXT | SENT | LOCK | ADD_PLAN | ADD_CONSTRAINT | ADD_CONTENT | ADD_CONTEXT | TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY )
        int alt12=57;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:10: GWENDOLEN
                {
                mGWENDOLEN(); 


                }
                break;
            case 2 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:20: GOALS
                {
                mGOALS(); 


                }
                break;
            case 3 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:26: BELIEFS
                {
                mBELIEFS(); 


                }
                break;
            case 4 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:34: BELIEFRULES
                {
                mBELIEFRULES(); 


                }
                break;
            case 5 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:46: PLANS
                {
                mPLANS(); 


                }
                break;
            case 6 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:52: NAME
                {
                mNAME(); 


                }
                break;
            case 7 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:57: SEND
                {
                mSEND(); 


                }
                break;
            case 8 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:62: RECEIVED
                {
                mRECEIVED(); 


                }
                break;
            case 9 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:71: BELIEVE
                {
                mBELIEVE(); 


                }
                break;
            case 10 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:79: GOAL
                {
                mGOAL(); 


                }
                break;
            case 11 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:84: IN_CONTENT
                {
                mIN_CONTENT(); 


                }
                break;
            case 12 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:95: IN_CONTEXT
                {
                mIN_CONTEXT(); 


                }
                break;
            case 13 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:106: SENT
                {
                mSENT(); 


                }
                break;
            case 14 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:111: LOCK
                {
                mLOCK(); 


                }
                break;
            case 15 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:116: ADD_PLAN
                {
                mADD_PLAN(); 


                }
                break;
            case 16 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:125: ADD_CONSTRAINT
                {
                mADD_CONSTRAINT(); 


                }
                break;
            case 17 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:140: ADD_CONTENT
                {
                mADD_CONTENT(); 


                }
                break;
            case 18 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:152: ADD_CONTEXT
                {
                mADD_CONTEXT(); 


                }
                break;
            case 19 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:164: TELL
                {
                mTELL(); 


                }
                break;
            case 20 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:169: PERFORM
                {
                mPERFORM(); 


                }
                break;
            case 21 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:177: ACHIEVE
                {
                mACHIEVE(); 


                }
                break;
            case 22 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:185: TELLHOW
                {
                mTELLHOW(); 


                }
                break;
            case 23 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:193: CONSTRAINT
                {
                mCONSTRAINT(); 


                }
                break;
            case 24 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:204: ACHIEVEGOAL
                {
                mACHIEVEGOAL(); 


                }
                break;
            case 25 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:216: PERFORMGOAL
                {
                mPERFORMGOAL(); 


                }
                break;
            case 26 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:228: BRULEARROW
                {
                mBRULEARROW(); 


                }
                break;
            case 27 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:239: RULEARROW
                {
                mRULEARROW(); 


                }
                break;
            case 28 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:249: TRUE
                {
                mTRUE(); 


                }
                break;
            case 29 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:254: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 30 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:262: LINE_COMMENT
                {
                mLINE_COMMENT(); 


                }
                break;
            case 31 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:275: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 32 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:283: WS
                {
                mWS(); 


                }
                break;
            case 33 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:286: OPEN
                {
                mOPEN(); 


                }
                break;
            case 34 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:291: CLOSE
                {
                mCLOSE(); 


                }
                break;
            case 35 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:297: SQOPEN
                {
                mSQOPEN(); 


                }
                break;
            case 36 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:304: SQCLOSE
                {
                mSQCLOSE(); 


                }
                break;
            case 37 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:312: CURLYOPEN
                {
                mCURLYOPEN(); 


                }
                break;
            case 38 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:322: CURLYCLOSE
                {
                mCURLYCLOSE(); 


                }
                break;
            case 39 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:333: DOUBLEQUOTE
                {
                mDOUBLEQUOTE(); 


                }
                break;
            case 40 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:345: NOT
                {
                mNOT(); 


                }
                break;
            case 41 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:349: STRING
                {
                mSTRING(); 


                }
                break;
            case 42 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:356: CONST
                {
                mCONST(); 


                }
                break;
            case 43 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:362: VAR
                {
                mVAR(); 


                }
                break;
            case 44 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:366: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 45 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:373: LESS
                {
                mLESS(); 


                }
                break;
            case 46 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:378: EQ
                {
                mEQ(); 


                }
                break;
            case 47 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:381: POINT
                {
                mPOINT(); 


                }
                break;
            case 48 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:387: MULT
                {
                mMULT(); 


                }
                break;
            case 49 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:392: PLUS
                {
                mPLUS(); 


                }
                break;
            case 50 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:397: MINUS
                {
                mMINUS(); 


                }
                break;
            case 51 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:403: DIV
                {
                mDIV(); 


                }
                break;
            case 52 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:407: MOD
                {
                mMOD(); 


                }
                break;
            case 53 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:411: SHRIEK
                {
                mSHRIEK(); 


                }
                break;
            case 54 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:418: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 55 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:424: SEMI
                {
                mSEMI(); 


                }
                break;
            case 56 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:429: COLON
                {
                mCOLON(); 


                }
                break;
            case 57 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:1:435: QUERY
                {
                mQUERY(); 


                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\44\1\60\1\72\1\73\1\74\1\75\2\77\1\103\1\105\1\110\12"+
        "\uffff\1\77\1\105\1\111\12\uffff\1\105\1\uffff\1\105\30\uffff\1"+
        "\77\1\uffff\2\77\2\uffff\1\105\5\uffff\1\111\1\105\5\uffff\1\77"+
        "\1\uffff\1\77\1\105\1\uffff\1\105\2\uffff\2\77\1\142\1\105\3\uffff"+
        "\2\77\1\uffff\1\105\1\uffff\2\77\1\uffff\1\105\1\uffff\1\156\1\157"+
        "\1\105\3\uffff\1\164\7\uffff";
    static final String DFA12_eofS =
        "\170\uffff";
    static final String DFA12_minS =
        "\1\11\1\60\1\55\1\102\5\60\1\55\1\60\1\52\12\uffff\3\60\12\uffff"+
        "\1\60\1\0\1\60\1\156\12\uffff\1\145\11\uffff\3\0\1\60\1\0\2\60\2"+
        "\uffff\1\60\1\0\3\uffff\1\0\2\60\1\uffff\1\151\1\156\2\uffff\1\60"+
        "\1\uffff\2\60\1\uffff\1\60\1\164\1\144\4\60\1\151\2\uffff\2\60\1"+
        "\0\1\60\1\141\2\60\1\uffff\1\60\1\154\3\60\1\40\2\0\1\60\1\102\2"+
        "\uffff\1\0\3\uffff";
    static final String DFA12_maxS =
        "\1\176\1\172\1\164\1\170\5\172\1\55\1\172\1\57\12\uffff\3\172\12"+
        "\uffff\1\172\1\0\1\172\1\156\12\uffff\1\145\11\uffff\3\0\1\172\1"+
        "\0\2\172\2\uffff\1\172\1\0\3\uffff\1\0\2\172\1\uffff\1\151\1\156"+
        "\2\uffff\1\172\1\uffff\2\172\1\uffff\1\172\2\164\4\172\1\151\2\uffff"+
        "\2\172\1\0\1\172\1\141\2\172\1\uffff\1\172\1\154\3\172\1\40\2\0"+
        "\1\172\1\107\2\uffff\1\0\3\uffff";
    static final String DFA12_acceptS =
        "\14\uffff\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\3\uffff"+
        "\1\51\1\56\1\60\1\61\1\62\1\64\1\65\1\66\1\67\1\71\4\uffff\1\4\1"+
        "\5\1\6\1\23\1\24\1\25\1\26\1\27\1\32\1\70\1\uffff\1\10\1\11\1\12"+
        "\1\16\1\17\1\20\1\21\1\22\1\57\7\uffff\1\33\1\55\2\uffff\1\35\1"+
        "\36\1\63\3\uffff\1\53\2\uffff\1\13\1\14\1\uffff\1\52\2\uffff\1\54"+
        "\10\uffff\1\7\1\15\7\uffff\1\34\12\uffff\1\30\1\31\1\uffff\1\2\1"+
        "\3\1\1";
    static final String DFA12_specialS =
        "\1\42\1\60\1\uffff\1\23\1\37\1\26\1\24\1\20\1\21\1\uffff\1\54\13"+
        "\uffff\1\57\1\22\1\17\12\uffff\1\32\1\11\1\15\25\uffff\1\10\1\3"+
        "\1\5\1\47\1\4\1\25\1\53\2\uffff\1\41\1\2\3\uffff\1\1\1\56\1\31\5"+
        "\uffff\1\46\1\uffff\1\55\1\40\1\uffff\1\34\1\uffff\1\61\1\45\1\51"+
        "\1\30\1\33\3\uffff\1\44\1\52\1\12\1\36\1\uffff\1\43\1\50\1\uffff"+
        "\1\35\1\uffff\1\6\1\16\1\27\1\uffff\1\14\1\13\1\7\3\uffff\1\0\3"+
        "\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\15\1\14\2\uffff\1\14\22\uffff\1\15\1\37\1\24\2\uffff\1\36"+
            "\2\uffff\1\16\1\17\1\33\1\34\1\40\1\35\1\3\1\13\12\30\1\2\1"+
            "\41\1\11\1\32\1\uffff\1\42\1\uffff\1\27\1\4\4\27\1\1\6\27\1"+
            "\5\5\27\1\12\3\27\1\6\2\27\1\20\1\uffff\1\21\1\uffff\1\31\1"+
            "\uffff\1\7\16\26\1\10\12\26\1\22\1\uffff\1\23\1\25",
            "\12\45\7\uffff\26\45\1\43\3\45\4\uffff\1\45\1\uffff\32\45",
            "\1\57\24\uffff\1\47\6\uffff\1\46\6\uffff\1\50\20\uffff\1\54"+
            "\1\uffff\1\56\4\uffff\1\55\5\uffff\1\51\1\uffff\1\53\3\uffff"+
            "\1\52",
            "\1\63\4\uffff\1\64\33\uffff\1\67\10\uffff\1\65\1\uffff\1\70"+
            "\1\uffff\1\66\1\uffff\1\62\1\61\4\uffff\1\71",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\2\100\1\76\27"+
            "\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\4\100\1\101\25"+
            "\100",
            "\1\102",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\21\45\1\104\10\45",
            "\1\106\4\uffff\1\107",
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
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\112\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
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
            "\12\45\7\uffff\4\45\1\113\25\45\4\uffff\1\45\1\uffff\32\45",
            "\1\uffff",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\115",
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
            "\1\116",
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
            "\1\uffff",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\7\100\1\121\22"+
            "\100",
            "\1\uffff",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\21\100\1\123\10"+
            "\100",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\24\45\1\124\5\45",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "\12\112\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\45\7\uffff\15\45\1\126\14\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\127",
            "\1\130",
            "",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\10\100\1\131\21"+
            "\100",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\5\100\1\132\24"+
            "\100",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\133\25\45",
            "",
            "\12\45\7\uffff\3\45\1\134\26\45\4\uffff\1\45\1\uffff\32\45",
            "\1\135",
            "\1\136\17\uffff\1\137",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\4\100\1\140\25"+
            "\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\16\100\1\141\13"+
            "\100",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\16\45\1\143\13\45\4\uffff\1\45\1\uffff\32\45",
            "\1\144",
            "",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\25\100\1\145\4"+
            "\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\21\100\1\146\10"+
            "\100",
            "\1\uffff",
            "\12\45\7\uffff\13\45\1\150\16\45\4\uffff\1\45\1\uffff\32\45",
            "\1\151",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\4\100\1\152\25"+
            "\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\14\100\1\153\15"+
            "\100",
            "",
            "\12\45\7\uffff\4\45\1\154\25\45\4\uffff\1\45\1\uffff\32\45",
            "\1\155",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\45\7\uffff\15\45\1\160\14\45\4\uffff\1\45\1\uffff\32\45",
            "\1\161",
            "\1\uffff",
            "\1\uffff",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\166\4\uffff\1\165",
            "",
            "",
            "\1\uffff",
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
            return "1:1: Tokens : ( GWENDOLEN | GOALS | BELIEFS | BELIEFRULES | PLANS | NAME | SEND | RECEIVED | BELIEVE | GOAL | IN_CONTENT | IN_CONTEXT | SENT | LOCK | ADD_PLAN | ADD_CONSTRAINT | ADD_CONTENT | ADD_CONTEXT | TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_116 = input.LA(1);

                         
                        int index12_116 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting == 0)) ) {s = 119;}

                        else if ( ((stringterm)) ) {s = 25;}

                        else if ( ((!stringterm)) ) {s = 76;}

                         
                        input.seek(index12_116);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA12_73 = input.LA(1);

                         
                        int index12_73 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((stringterm)) ) {s = 25;}

                        else if ( ((!stringterm)) ) {s = 85;}

                         
                        input.seek(index12_73);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA12_69 = input.LA(1);

                         
                        int index12_69 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((stringterm)) ) {s = 25;}

                        else if ( ((!stringterm)) ) {s = 76;}

                         
                        input.seek(index12_69);

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA12_60 = input.LA(1);

                         
                        int index12_60 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 79;}

                        else if ( ((stringterm)) ) {s = 25;}

                        else if ( ((!stringterm)) ) {s = 76;}

                         
                        input.seek(index12_60);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA12_63 = input.LA(1);

                         
                        int index12_63 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((stringterm)) ) {s = 25;}

                        else if ( ((!stringterm)) ) {s = 82;}

                         
                        input.seek(index12_63);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA12_61 = input.LA(1);

                         
                        int index12_61 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 80;}

                        else if ( ((stringterm)) ) {s = 25;}

                        else if ( ((!stringterm)) ) {s = 76;}

                         
                        input.seek(index12_61);

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA12_106 = input.LA(1);

                         
                        int index12_106 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_106 >= '0' && LA12_106 <= '9')||(LA12_106 >= 'A' && LA12_106 <= 'Z')||LA12_106=='_'||(LA12_106 >= 'a' && LA12_106 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 110;

                         
                        input.seek(index12_106);

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA12_112 = input.LA(1);

                         
                        int index12_112 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_112 >= '0' && LA12_112 <= '9')||(LA12_112 >= 'A' && LA12_112 <= 'Z')||LA12_112=='_'||(LA12_112 >= 'a' && LA12_112 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 116;

                         
                        input.seek(index12_112);

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA12_59 = input.LA(1);

                         
                        int index12_59 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 51;}

                        else if ( ((stringterm)) ) {s = 25;}

                        else if ( ((!stringterm)) ) {s = 76;}

                         
                        input.seek(index12_59);

                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA12_36 = input.LA(1);

                         
                        int index12_36 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 52;}

                        else if ( ((stringterm)) ) {s = 25;}

                        else if ( ((!stringterm)) ) {s = 76;}

                         
                        input.seek(index12_36);

                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA12_98 = input.LA(1);

                         
                        int index12_98 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 103;}

                        else if ( ((stringterm)) ) {s = 25;}

                        else if ( ((!stringterm)) ) {s = 76;}

                         
                        input.seek(index12_98);

                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA12_111 = input.LA(1);

                         
                        int index12_111 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((sq_nesting > 0)) ) {s = 115;}

                        else if ( ((stringterm)) ) {s = 25;}

                        else if ( ((!stringterm)) ) {s = 82;}

                         
                        input.seek(index12_111);

                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA12_110 = input.LA(1);

                         
                        int index12_110 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((sq_nesting > 0)) ) {s = 114;}

                        else if ( ((stringterm)) ) {s = 25;}

                        else if ( ((!stringterm)) ) {s = 82;}

                         
                        input.seek(index12_110);

                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA12_37 = input.LA(1);

                         
                        int index12_37 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_37 >= '0' && LA12_37 <= '9')||(LA12_37 >= 'A' && LA12_37 <= 'Z')||LA12_37=='_'||(LA12_37 >= 'a' && LA12_37 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 69;

                         
                        input.seek(index12_37);

                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA12_107 = input.LA(1);

                         
                        int index12_107 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_107 >= '0' && LA12_107 <= '9')||(LA12_107 >= 'A' && LA12_107 <= 'Z')||LA12_107=='_'||(LA12_107 >= 'a' && LA12_107 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 111;

                         
                        input.seek(index12_107);

                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA12_24 = input.LA(1);

                         
                        int index12_24 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_24 >= '0' && LA12_24 <= '9')) && (((!stringterm)||(stringterm)))) {s = 74;}

                        else if ( ((LA12_24 >= 'A' && LA12_24 <= 'Z')||LA12_24=='_'||(LA12_24 >= 'a' && LA12_24 <= 'z')) && ((stringterm))) {s = 25;}

                        else s = 73;

                         
                        input.seek(index12_24);

                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA12_7 = input.LA(1);

                         
                        int index12_7 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_7=='c') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 62;}

                        else if ( ((LA12_7 >= '0' && LA12_7 <= '9')||(LA12_7 >= 'A' && LA12_7 <= 'Z')||LA12_7=='_'||(LA12_7 >= 'a' && LA12_7 <= 'b')||(LA12_7 >= 'd' && LA12_7 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_7);

                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA12_8 = input.LA(1);

                         
                        int index12_8 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_8=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 65;}

                        else if ( ((LA12_8 >= '0' && LA12_8 <= '9')||(LA12_8 >= 'A' && LA12_8 <= 'Z')||LA12_8=='_'||(LA12_8 >= 'a' && LA12_8 <= 'd')||(LA12_8 >= 'f' && LA12_8 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_8);

                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA12_23 = input.LA(1);

                         
                        int index12_23 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_23 >= '0' && LA12_23 <= '9')||(LA12_23 >= 'A' && LA12_23 <= 'Z')||LA12_23=='_'||(LA12_23 >= 'a' && LA12_23 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 69;

                         
                        input.seek(index12_23);

                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA12_3 = input.LA(1);

                         
                        int index12_3 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_3=='s') ) {s = 49;}

                        else if ( (LA12_3=='r') && ((gwendolen))) {s = 50;}

                        else if ( (LA12_3=='B') && ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1))) {s = 51;}

                        else if ( (LA12_3=='G') && ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1))) {s = 52;}

                        else if ( (LA12_3=='l') ) {s = 53;}

                        else if ( (LA12_3=='p') ) {s = 54;}

                        else if ( (LA12_3=='c') ) {s = 55;}

                        else if ( (LA12_3=='n') ) {s = 56;}

                        else if ( (LA12_3=='x') ) {s = 57;}

                        else s = 58;

                         
                        input.seek(index12_3);

                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA12_6 = input.LA(1);

                         
                        int index12_6 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_6 >= '0' && LA12_6 <= '9')||(LA12_6 >= 'A' && LA12_6 <= 'Z')||LA12_6=='_'||(LA12_6 >= 'a' && LA12_6 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 61;

                         
                        input.seek(index12_6);

                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA12_64 = input.LA(1);

                         
                        int index12_64 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_64 >= '0' && LA12_64 <= '9')||(LA12_64 >= 'A' && LA12_64 <= 'Z')||LA12_64=='_'||(LA12_64 >= 'a' && LA12_64 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_64);

                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA12_5 = input.LA(1);

                         
                        int index12_5 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_5 >= '0' && LA12_5 <= '9')||(LA12_5 >= 'A' && LA12_5 <= 'Z')||LA12_5=='_'||(LA12_5 >= 'a' && LA12_5 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 60;

                         
                        input.seek(index12_5);

                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA12_108 = input.LA(1);

                         
                        int index12_108 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_108=='N') && (((curly_nesting == 0)||(stringterm)||(!stringterm)))) {s = 112;}

                        else if ( ((LA12_108 >= '0' && LA12_108 <= '9')||(LA12_108 >= 'A' && LA12_108 <= 'M')||(LA12_108 >= 'O' && LA12_108 <= 'Z')||LA12_108=='_'||(LA12_108 >= 'a' && LA12_108 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 69;

                         
                        input.seek(index12_108);

                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA12_91 = input.LA(1);

                         
                        int index12_91 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_91 >= '0' && LA12_91 <= '9')||(LA12_91 >= 'A' && LA12_91 <= 'Z')||LA12_91=='_'||(LA12_91 >= 'a' && LA12_91 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 98;

                         
                        input.seek(index12_91);

                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA12_75 = input.LA(1);

                         
                        int index12_75 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_75=='N') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 86;}

                        else if ( ((LA12_75 >= '0' && LA12_75 <= '9')||(LA12_75 >= 'A' && LA12_75 <= 'M')||(LA12_75 >= 'O' && LA12_75 <= 'Z')||LA12_75=='_'||(LA12_75 >= 'a' && LA12_75 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 69;

                         
                        input.seek(index12_75);

                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA12_35 = input.LA(1);

                         
                        int index12_35 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_35=='E') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 75;}

                        else if ( ((LA12_35 >= '0' && LA12_35 <= '9')||(LA12_35 >= 'A' && LA12_35 <= 'D')||(LA12_35 >= 'F' && LA12_35 <= 'Z')||LA12_35=='_'||(LA12_35 >= 'a' && LA12_35 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 69;

                         
                        input.seek(index12_35);

                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA12_92 = input.LA(1);

                         
                        int index12_92 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_92=='O') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 99;}

                        else if ( ((LA12_92 >= '0' && LA12_92 <= '9')||(LA12_92 >= 'A' && LA12_92 <= 'N')||(LA12_92 >= 'P' && LA12_92 <= 'Z')||LA12_92=='_'||(LA12_92 >= 'a' && LA12_92 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 69;

                         
                        input.seek(index12_92);

                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA12_86 = input.LA(1);

                         
                        int index12_86 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_86=='D') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 92;}

                        else if ( ((LA12_86 >= '0' && LA12_86 <= '9')||(LA12_86 >= 'A' && LA12_86 <= 'C')||(LA12_86 >= 'E' && LA12_86 <= 'Z')||LA12_86=='_'||(LA12_86 >= 'a' && LA12_86 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 69;

                         
                        input.seek(index12_86);

                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA12_104 = input.LA(1);

                         
                        int index12_104 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_104=='E') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 108;}

                        else if ( ((LA12_104 >= '0' && LA12_104 <= '9')||(LA12_104 >= 'A' && LA12_104 <= 'D')||(LA12_104 >= 'F' && LA12_104 <= 'Z')||LA12_104=='_'||(LA12_104 >= 'a' && LA12_104 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 69;

                         
                        input.seek(index12_104);

                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA12_99 = input.LA(1);

                         
                        int index12_99 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_99=='L') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 104;}

                        else if ( ((LA12_99 >= '0' && LA12_99 <= '9')||(LA12_99 >= 'A' && LA12_99 <= 'K')||(LA12_99 >= 'M' && LA12_99 <= 'Z')||LA12_99=='_'||(LA12_99 >= 'a' && LA12_99 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 69;

                         
                        input.seek(index12_99);

                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA12_4 = input.LA(1);

                         
                        int index12_4 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_4 >= '0' && LA12_4 <= '9')||(LA12_4 >= 'A' && LA12_4 <= 'Z')||LA12_4=='_'||(LA12_4 >= 'a' && LA12_4 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 59;

                         
                        input.seek(index12_4);

                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA12_84 = input.LA(1);

                         
                        int index12_84 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_84=='e') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 91;}

                        else if ( ((LA12_84 >= '0' && LA12_84 <= '9')||(LA12_84 >= 'A' && LA12_84 <= 'Z')||LA12_84=='_'||(LA12_84 >= 'a' && LA12_84 <= 'd')||(LA12_84 >= 'f' && LA12_84 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 69;

                         
                        input.seek(index12_84);

                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA12_68 = input.LA(1);

                         
                        int index12_68 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_68=='u') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 84;}

                        else if ( ((LA12_68 >= '0' && LA12_68 <= '9')||(LA12_68 >= 'A' && LA12_68 <= 'Z')||LA12_68=='_'||(LA12_68 >= 'a' && LA12_68 <= 't')||(LA12_68 >= 'v' && LA12_68 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 69;

                         
                        input.seek(index12_68);

                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA12_0 = input.LA(1);

                         
                        int index12_0 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_0=='G') && (((curly_nesting == 0)||(stringterm)||(!stringterm)||(curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)))) {s = 1;}

                        else if ( (LA12_0==':') ) {s = 2;}

                        else if ( (LA12_0=='.') ) {s = 3;}

                        else if ( (LA12_0=='B') && (((stringterm)||(!stringterm)||(curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)))) {s = 4;}

                        else if ( (LA12_0=='N') && (((!stringterm)||(stringterm)||(curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)))) {s = 5;}

                        else if ( (LA12_0=='X') && (((!stringterm)||(stringterm)||(curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)))) {s = 6;}

                        else if ( (LA12_0=='a') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 7;}

                        else if ( (LA12_0=='p') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 8;}

                        else if ( (LA12_0=='<') ) {s = 9;}

                        else if ( (LA12_0=='T') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 10;}

                        else if ( (LA12_0=='/') ) {s = 11;}

                        else if ( (LA12_0=='\n'||LA12_0=='\r') ) {s = 12;}

                        else if ( (LA12_0=='\t'||LA12_0==' ') ) {s = 13;}

                        else if ( (LA12_0=='(') ) {s = 14;}

                        else if ( (LA12_0==')') ) {s = 15;}

                        else if ( (LA12_0=='[') ) {s = 16;}

                        else if ( (LA12_0==']') ) {s = 17;}

                        else if ( (LA12_0=='{') ) {s = 18;}

                        else if ( (LA12_0=='}') ) {s = 19;}

                        else if ( (LA12_0=='\"') ) {s = 20;}

                        else if ( (LA12_0=='~') ) {s = 21;}

                        else if ( ((LA12_0 >= 'b' && LA12_0 <= 'o')||(LA12_0 >= 'q' && LA12_0 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 22;}

                        else if ( (LA12_0=='A'||(LA12_0 >= 'C' && LA12_0 <= 'F')||(LA12_0 >= 'H' && LA12_0 <= 'M')||(LA12_0 >= 'O' && LA12_0 <= 'S')||(LA12_0 >= 'U' && LA12_0 <= 'W')||(LA12_0 >= 'Y' && LA12_0 <= 'Z')) && (((!stringterm)||(stringterm)))) {s = 23;}

                        else if ( ((LA12_0 >= '0' && LA12_0 <= '9')) && (((!stringterm)||(stringterm)))) {s = 24;}

                        else if ( (LA12_0=='_') && ((stringterm))) {s = 25;}

                        else if ( (LA12_0=='=') ) {s = 26;}

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

                    case 35 : 
                        int LA12_101 = input.LA(1);

                         
                        int index12_101 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_101=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 106;}

                        else if ( ((LA12_101 >= '0' && LA12_101 <= '9')||(LA12_101 >= 'A' && LA12_101 <= 'Z')||LA12_101=='_'||(LA12_101 >= 'a' && LA12_101 <= 'd')||(LA12_101 >= 'f' && LA12_101 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_101);

                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA12_96 = input.LA(1);

                         
                        int index12_96 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_96=='v') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 101;}

                        else if ( ((LA12_96 >= '0' && LA12_96 <= '9')||(LA12_96 >= 'A' && LA12_96 <= 'Z')||LA12_96=='_'||(LA12_96 >= 'a' && LA12_96 <= 'u')||(LA12_96 >= 'w' && LA12_96 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_96);

                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA12_89 = input.LA(1);

                         
                        int index12_89 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_89=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 96;}

                        else if ( ((LA12_89 >= '0' && LA12_89 <= '9')||(LA12_89 >= 'A' && LA12_89 <= 'Z')||LA12_89=='_'||(LA12_89 >= 'a' && LA12_89 <= 'd')||(LA12_89 >= 'f' && LA12_89 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_89);

                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA12_81 = input.LA(1);

                         
                        int index12_81 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_81=='i') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 89;}

                        else if ( ((LA12_81 >= '0' && LA12_81 <= '9')||(LA12_81 >= 'A' && LA12_81 <= 'Z')||LA12_81=='_'||(LA12_81 >= 'a' && LA12_81 <= 'h')||(LA12_81 >= 'j' && LA12_81 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_81);

                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA12_62 = input.LA(1);

                         
                        int index12_62 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_62=='h') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 81;}

                        else if ( ((LA12_62 >= '0' && LA12_62 <= '9')||(LA12_62 >= 'A' && LA12_62 <= 'Z')||LA12_62=='_'||(LA12_62 >= 'a' && LA12_62 <= 'g')||(LA12_62 >= 'i' && LA12_62 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_62);

                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA12_102 = input.LA(1);

                         
                        int index12_102 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_102=='m') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 107;}

                        else if ( ((LA12_102 >= '0' && LA12_102 <= '9')||(LA12_102 >= 'A' && LA12_102 <= 'Z')||LA12_102=='_'||(LA12_102 >= 'a' && LA12_102 <= 'l')||(LA12_102 >= 'n' && LA12_102 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_102);

                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA12_90 = input.LA(1);

                         
                        int index12_90 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_90=='o') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 97;}

                        else if ( ((LA12_90 >= '0' && LA12_90 <= '9')||(LA12_90 >= 'A' && LA12_90 <= 'Z')||LA12_90=='_'||(LA12_90 >= 'a' && LA12_90 <= 'n')||(LA12_90 >= 'p' && LA12_90 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_90);

                        if ( s>=0 ) return s;
                        break;

                    case 42 : 
                        int LA12_97 = input.LA(1);

                         
                        int index12_97 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_97=='r') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 102;}

                        else if ( ((LA12_97 >= '0' && LA12_97 <= '9')||(LA12_97 >= 'A' && LA12_97 <= 'Z')||LA12_97=='_'||(LA12_97 >= 'a' && LA12_97 <= 'q')||(LA12_97 >= 's' && LA12_97 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_97);

                        if ( s>=0 ) return s;
                        break;

                    case 43 : 
                        int LA12_65 = input.LA(1);

                         
                        int index12_65 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_65=='r') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 83;}

                        else if ( ((LA12_65 >= '0' && LA12_65 <= '9')||(LA12_65 >= 'A' && LA12_65 <= 'Z')||LA12_65=='_'||(LA12_65 >= 'a' && LA12_65 <= 'q')||(LA12_65 >= 's' && LA12_65 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_65);

                        if ( s>=0 ) return s;
                        break;

                    case 44 : 
                        int LA12_10 = input.LA(1);

                         
                        int index12_10 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_10=='r') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 68;}

                        else if ( ((LA12_10 >= '0' && LA12_10 <= '9')||(LA12_10 >= 'A' && LA12_10 <= 'Z')||LA12_10=='_'||(LA12_10 >= 'a' && LA12_10 <= 'q')||(LA12_10 >= 's' && LA12_10 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 69;

                         
                        input.seek(index12_10);

                        if ( s>=0 ) return s;
                        break;

                    case 45 : 
                        int LA12_83 = input.LA(1);

                         
                        int index12_83 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_83=='f') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 90;}

                        else if ( ((LA12_83 >= '0' && LA12_83 <= '9')||(LA12_83 >= 'A' && LA12_83 <= 'Z')||LA12_83=='_'||(LA12_83 >= 'a' && LA12_83 <= 'e')||(LA12_83 >= 'g' && LA12_83 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_83);

                        if ( s>=0 ) return s;
                        break;

                    case 46 : 
                        int LA12_74 = input.LA(1);

                         
                        int index12_74 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_74 >= '0' && LA12_74 <= '9')) && (((!stringterm)||(stringterm)))) {s = 74;}

                        else if ( ((LA12_74 >= 'A' && LA12_74 <= 'Z')||LA12_74=='_'||(LA12_74 >= 'a' && LA12_74 <= 'z')) && ((stringterm))) {s = 25;}

                        else s = 73;

                         
                        input.seek(index12_74);

                        if ( s>=0 ) return s;
                        break;

                    case 47 : 
                        int LA12_22 = input.LA(1);

                         
                        int index12_22 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_22 >= '0' && LA12_22 <= '9')||(LA12_22 >= 'A' && LA12_22 <= 'Z')||LA12_22=='_'||(LA12_22 >= 'a' && LA12_22 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 64;}

                        else s = 63;

                         
                        input.seek(index12_22);

                        if ( s>=0 ) return s;
                        break;

                    case 48 : 
                        int LA12_1 = input.LA(1);

                         
                        int index12_1 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_1=='W') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 35;}

                        else if ( ((LA12_1 >= '0' && LA12_1 <= '9')||(LA12_1 >= 'A' && LA12_1 <= 'V')||(LA12_1 >= 'X' && LA12_1 <= 'Z')||LA12_1=='_'||(LA12_1 >= 'a' && LA12_1 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 37;}

                        else s = 36;

                         
                        input.seek(index12_1);

                        if ( s>=0 ) return s;
                        break;

                    case 49 : 
                        int LA12_88 = input.LA(1);

                         
                        int index12_88 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_88=='d') ) {s = 94;}

                        else if ( (LA12_88=='t') && ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1))) {s = 95;}

                         
                        input.seek(index12_88);

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