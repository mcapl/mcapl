// $ANTLR 3.4 /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g 2014-04-04 13:09:37

package ethical_gwen.parser;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class EthicalGwendolenLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__63=63;
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
    public static final int ETHIC=25;
    public static final int ETHICS=26;
    public static final int GOAL=27;
    public static final int GOALS=28;
    public static final int GWENDOLEN=29;
    public static final int IN_CONTENT=30;
    public static final int IN_CONTEXT=31;
    public static final int LESS=32;
    public static final int LINE_COMMENT=33;
    public static final int LOCK=34;
    public static final int MINUS=35;
    public static final int MOD=36;
    public static final int MULT=37;
    public static final int NAME=38;
    public static final int NEWLINE=39;
    public static final int NOT=40;
    public static final int NUMBER=41;
    public static final int OPEN=42;
    public static final int PERFORM=43;
    public static final int PERFORMGOAL=44;
    public static final int PLANS=45;
    public static final int PLUS=46;
    public static final int POINT=47;
    public static final int QUERY=48;
    public static final int RECEIVED=49;
    public static final int RULEARROW=50;
    public static final int SEMI=51;
    public static final int SEND=52;
    public static final int SENT=53;
    public static final int SHRIEK=54;
    public static final int SQCLOSE=55;
    public static final int SQOPEN=56;
    public static final int STRING=57;
    public static final int TELL=58;
    public static final int TELLHOW=59;
    public static final int TRUE=60;
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

    public EthicalGwendolenLexer() {} 
    public EthicalGwendolenLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public EthicalGwendolenLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g"; }

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:14:7: ( '|' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:14:9: '|'
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
    // $ANTLR end "T__63"

    // $ANTLR start "GWENDOLEN"
    public final void mGWENDOLEN() throws RecognitionException {
        try {
            int _type = GWENDOLEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:151:11: ({...}? => 'GWENDOLEN' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:151:12: {...}? => 'GWENDOLEN'
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

    // $ANTLR start "ETHICS"
    public final void mETHICS() throws RecognitionException {
        try {
            int _type = ETHICS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:153:9: ( ':Ethical Policy:' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:153:11: ':Ethical Policy:'
            {
            match(":Ethical Policy:"); 



            belief_rules = 1;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ETHICS"

    // $ANTLR start "GOALS"
    public final void mGOALS() throws RecognitionException {
        try {
            int _type = GOALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:154:7: ( ':Initial Goals:' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:154:9: ':Initial Goals:'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:155:9: ( ':Initial Beliefs:' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:155:11: ':Initial Beliefs:'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:157:2: ( ':Reasoning Rules:' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:157:4: ':Reasoning Rules:'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:158:7: ( ':Plans:' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:158:9: ':Plans:'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:159:6: ( ':name:' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:159:8: ':name:'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:161:6: ( '.send' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:161:8: '.send'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:162:9: ({...}? => '.received' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:162:11: {...}? => '.received'
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

    // $ANTLR start "ETHIC"
    public final void mETHIC() throws RecognitionException {
        try {
            int _type = ETHIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:163:7: ({...}? => ( 'E' ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:163:9: {...}? => ( 'E' )
            {
            if ( !((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {
                throw new FailedPredicateException(input, "ETHIC", "curly_nesting > 0 && plain_nesting == 0 || belief_rules==1");
            }

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:163:73: ( 'E' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:163:74: 'E'
            {
            match('E'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ETHIC"

    // $ANTLR start "BELIEVE"
    public final void mBELIEVE() throws RecognitionException {
        try {
            int _type = BELIEVE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:164:9: ({...}? => ( 'B' | '.B' ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:164:11: {...}? => ( 'B' | '.B' )
            {
            if ( !((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {
                throw new FailedPredicateException(input, "BELIEVE", "curly_nesting > 0 && plain_nesting == 0 || belief_rules==1");
            }

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:164:75: ( 'B' | '.B' )
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
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:164:76: 'B'
                    {
                    match('B'); 

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:164:82: '.B'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:165:6: ({...}? => ( 'G' | '.G' ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:165:8: {...}? => ( 'G' | '.G' )
            {
            if ( !((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {
                throw new FailedPredicateException(input, "GOAL", "curly_nesting > 0 && plain_nesting == 0|| belief_rules==1");
            }

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:165:71: ( 'G' | '.G' )
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
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:165:72: 'G'
                    {
                    match('G'); 

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:165:78: '.G'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:166:12: ({...}? => ( 'N' ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:166:14: {...}? => ( 'N' )
            {
            if ( !((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {
                throw new FailedPredicateException(input, "IN_CONTENT", "curly_nesting > 0 && plain_nesting == 0 || belief_rules==1");
            }

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:166:78: ( 'N' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:166:79: 'N'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:167:12: ({...}? => ( 'X' ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:167:14: {...}? => ( 'X' )
            {
            if ( !((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {
                throw new FailedPredicateException(input, "IN_CONTEXT", "curly_nesting > 0 && plain_nesting == 0|| belief_rules==1");
            }

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:167:77: ( 'X' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:167:78: 'X'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:168:6: ({...}? => '.sent' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:168:8: {...}? => '.sent'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:169:6: ( '.lock' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:169:8: '.lock'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:170:10: ( '.plan' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:170:12: '.plan'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:171:16: ( '.constraint' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:171:18: '.constraint'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:173:2: ( '.n' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:173:4: '.n'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:174:13: ( '.x' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:174:15: '.x'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:176:6: ( ':tell' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:176:8: ':tell'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:177:9: ( ':perform' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:177:11: ':perform'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:178:9: ( ':achieve' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:178:11: ':achieve'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:179:9: ( ':how' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:179:11: ':how'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:181:2: ( ':constrain' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:181:4: ':constrain'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:183:13: ({...}? => 'achieve' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:183:15: {...}? => 'achieve'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:184:13: ({...}? => 'perform' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:184:15: {...}? => 'perform'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:186:2: ( ':-' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:186:4: ':-'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:187:11: ( '<-' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:187:13: '<-'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:189:6: ({...}? => 'True' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:189:8: {...}? => 'True'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:242:5: ( '/*' ( . )* '*/' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:242:7: '/*' ( . )* '*/'
            {
            match("/*"); 



            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:242:12: ( . )*
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
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:242:12: .
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:245:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:245:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 



            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:245:12: (~ ( '\\n' | '\\r' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:
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


            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:245:26: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:245:26: '\\r'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:247:8: ( ( '\\r' )? '\\n' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:247:9: ( '\\r' )? '\\n'
            {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:247:9: ( '\\r' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:247:9: '\\r'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:248:5: ( ( ' ' | '\\t' )+ )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:248:9: ( ' ' | '\\t' )+
            {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:248:9: ( ' ' | '\\t' )+
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
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:251:6: ( '(' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:251:9: '('
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:252:7: ( ')' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:252:9: ')'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:253:8: ( '[' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:253:10: '['
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:254:9: ( ']' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:254:11: ']'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:255:11: ( '{' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:255:13: '{'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:256:12: ( '}' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:256:14: '}'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:258:2: ( '\"' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:258:4: '\"'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:259:5: ( '~' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:259:7: '~'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:261:8: ({...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:261:10: {...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
            {
            if ( !((stringterm)) ) {
                throw new FailedPredicateException(input, "STRING", "stringterm");
            }

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:261:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
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
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:262:8: ({...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:262:11: {...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( !((!stringterm)) ) {
                throw new FailedPredicateException(input, "CONST", "!stringterm");
            }

            matchRange('a','z'); 

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:262:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:263:5: ({...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:263:7: {...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( !((!stringterm)) ) {
                throw new FailedPredicateException(input, "VAR", "!stringterm");
            }

            matchRange('A','Z'); 

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:263:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '0' && LA10_0 <= '9')||(LA10_0 >= 'A' && LA10_0 <= 'Z')||LA10_0=='_'||(LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:264:8: ({...}? => '0' .. '9' ( '0' .. '9' )* )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:264:10: {...}? => '0' .. '9' ( '0' .. '9' )*
            {
            if ( !((!stringterm)) ) {
                throw new FailedPredicateException(input, "NUMBER", "!stringterm");
            }

            matchRange('0','9'); 

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:264:35: ( '0' .. '9' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:267:6: ( '<' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:267:8: '<'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:268:4: ( '==' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:268:7: '=='
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:269:7: ( '.' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:269:9: '.'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:270:6: ( '*' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:270:8: '*'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:271:6: ( '+' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:271:8: '+'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:272:7: ( '-' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:272:9: '-'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:273:5: ( '/' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:273:7: '/'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:274:5: ( '%' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:274:7: '%'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:276:8: ( '!' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:276:10: '!'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:277:7: ( ',' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:277:9: ','
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:278:6: ( ';' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:278:8: ';'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:279:7: ( ':' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:279:9: ':'
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:280:7: ( '?' )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:280:9: '?'
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
        // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:8: ( T__63 | GWENDOLEN | ETHICS | GOALS | BELIEFS | BELIEFRULES | PLANS | NAME | SEND | RECEIVED | ETHIC | BELIEVE | GOAL | IN_CONTENT | IN_CONTEXT | SENT | LOCK | ADD_PLAN | ADD_CONSTRAINT | ADD_CONTENT | ADD_CONTEXT | TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY )
        int alt12=60;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:10: T__63
                {
                mT__63(); 


                }
                break;
            case 2 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:16: GWENDOLEN
                {
                mGWENDOLEN(); 


                }
                break;
            case 3 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:26: ETHICS
                {
                mETHICS(); 


                }
                break;
            case 4 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:33: GOALS
                {
                mGOALS(); 


                }
                break;
            case 5 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:39: BELIEFS
                {
                mBELIEFS(); 


                }
                break;
            case 6 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:47: BELIEFRULES
                {
                mBELIEFRULES(); 


                }
                break;
            case 7 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:59: PLANS
                {
                mPLANS(); 


                }
                break;
            case 8 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:65: NAME
                {
                mNAME(); 


                }
                break;
            case 9 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:70: SEND
                {
                mSEND(); 


                }
                break;
            case 10 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:75: RECEIVED
                {
                mRECEIVED(); 


                }
                break;
            case 11 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:84: ETHIC
                {
                mETHIC(); 


                }
                break;
            case 12 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:90: BELIEVE
                {
                mBELIEVE(); 


                }
                break;
            case 13 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:98: GOAL
                {
                mGOAL(); 


                }
                break;
            case 14 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:103: IN_CONTENT
                {
                mIN_CONTENT(); 


                }
                break;
            case 15 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:114: IN_CONTEXT
                {
                mIN_CONTEXT(); 


                }
                break;
            case 16 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:125: SENT
                {
                mSENT(); 


                }
                break;
            case 17 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:130: LOCK
                {
                mLOCK(); 


                }
                break;
            case 18 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:135: ADD_PLAN
                {
                mADD_PLAN(); 


                }
                break;
            case 19 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:144: ADD_CONSTRAINT
                {
                mADD_CONSTRAINT(); 


                }
                break;
            case 20 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:159: ADD_CONTENT
                {
                mADD_CONTENT(); 


                }
                break;
            case 21 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:171: ADD_CONTEXT
                {
                mADD_CONTEXT(); 


                }
                break;
            case 22 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:183: TELL
                {
                mTELL(); 


                }
                break;
            case 23 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:188: PERFORM
                {
                mPERFORM(); 


                }
                break;
            case 24 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:196: ACHIEVE
                {
                mACHIEVE(); 


                }
                break;
            case 25 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:204: TELLHOW
                {
                mTELLHOW(); 


                }
                break;
            case 26 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:212: CONSTRAINT
                {
                mCONSTRAINT(); 


                }
                break;
            case 27 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:223: ACHIEVEGOAL
                {
                mACHIEVEGOAL(); 


                }
                break;
            case 28 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:235: PERFORMGOAL
                {
                mPERFORMGOAL(); 


                }
                break;
            case 29 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:247: BRULEARROW
                {
                mBRULEARROW(); 


                }
                break;
            case 30 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:258: RULEARROW
                {
                mRULEARROW(); 


                }
                break;
            case 31 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:268: TRUE
                {
                mTRUE(); 


                }
                break;
            case 32 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:273: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 33 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:281: LINE_COMMENT
                {
                mLINE_COMMENT(); 


                }
                break;
            case 34 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:294: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 35 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:302: WS
                {
                mWS(); 


                }
                break;
            case 36 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:305: OPEN
                {
                mOPEN(); 


                }
                break;
            case 37 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:310: CLOSE
                {
                mCLOSE(); 


                }
                break;
            case 38 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:316: SQOPEN
                {
                mSQOPEN(); 


                }
                break;
            case 39 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:323: SQCLOSE
                {
                mSQCLOSE(); 


                }
                break;
            case 40 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:331: CURLYOPEN
                {
                mCURLYOPEN(); 


                }
                break;
            case 41 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:341: CURLYCLOSE
                {
                mCURLYCLOSE(); 


                }
                break;
            case 42 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:352: DOUBLEQUOTE
                {
                mDOUBLEQUOTE(); 


                }
                break;
            case 43 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:364: NOT
                {
                mNOT(); 


                }
                break;
            case 44 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:368: STRING
                {
                mSTRING(); 


                }
                break;
            case 45 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:375: CONST
                {
                mCONST(); 


                }
                break;
            case 46 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:381: VAR
                {
                mVAR(); 


                }
                break;
            case 47 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:385: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 48 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:392: LESS
                {
                mLESS(); 


                }
                break;
            case 49 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:397: EQ
                {
                mEQ(); 


                }
                break;
            case 50 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:400: POINT
                {
                mPOINT(); 


                }
                break;
            case 51 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:406: MULT
                {
                mMULT(); 


                }
                break;
            case 52 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:411: PLUS
                {
                mPLUS(); 


                }
                break;
            case 53 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:416: MINUS
                {
                mMINUS(); 


                }
                break;
            case 54 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:422: DIV
                {
                mDIV(); 


                }
                break;
            case 55 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:426: MOD
                {
                mMOD(); 


                }
                break;
            case 56 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:430: SHRIEK
                {
                mSHRIEK(); 


                }
                break;
            case 57 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:437: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 58 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:443: SEMI
                {
                mSEMI(); 


                }
                break;
            case 59 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:448: COLON
                {
                mCOLON(); 


                }
                break;
            case 60 :
                // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:1:454: QUERY
                {
                mQUERY(); 


                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\2\uffff\1\46\1\63\1\75\1\76\1\77\1\100\1\101\2\103\1\107\1\111"+
        "\1\114\12\uffff\1\103\1\111\1\115\12\uffff\1\111\1\uffff\1\111\32"+
        "\uffff\1\103\1\uffff\2\103\2\uffff\1\111\5\uffff\1\115\1\111\6\uffff"+
        "\1\103\1\uffff\1\103\1\111\1\uffff\1\111\2\uffff\2\103\1\147\1\111"+
        "\3\uffff\2\103\1\uffff\1\111\1\uffff\2\103\1\uffff\1\111\1\uffff"+
        "\1\163\1\164\1\111\3\uffff\1\171\7\uffff";
    static final String DFA12_eofS =
        "\175\uffff";
    static final String DFA12_minS =
        "\1\11\1\uffff\1\60\1\55\1\102\6\60\1\55\1\60\1\52\12\uffff\3\60"+
        "\12\uffff\1\60\1\0\1\60\1\uffff\1\156\12\uffff\1\145\11\uffff\4"+
        "\0\1\60\1\0\2\60\2\uffff\1\60\1\0\3\uffff\1\0\2\60\1\uffff\1\151"+
        "\1\156\3\uffff\1\60\1\uffff\2\60\1\uffff\1\60\1\164\1\144\4\60\1"+
        "\151\2\uffff\2\60\1\0\1\60\1\141\2\60\1\uffff\1\60\1\154\3\60\1"+
        "\40\2\0\1\60\1\102\2\uffff\1\0\3\uffff";
    static final String DFA12_maxS =
        "\1\176\1\uffff\1\172\1\164\1\170\6\172\1\55\1\172\1\57\12\uffff"+
        "\3\172\12\uffff\1\172\1\0\1\172\1\uffff\1\156\12\uffff\1\145\11"+
        "\uffff\4\0\1\172\1\0\2\172\2\uffff\1\172\1\0\3\uffff\1\0\2\172\1"+
        "\uffff\1\151\1\156\3\uffff\1\172\1\uffff\2\172\1\uffff\1\172\2\164"+
        "\4\172\1\151\2\uffff\2\172\1\0\1\172\1\141\2\172\1\uffff\1\172\1"+
        "\154\3\172\1\40\2\0\1\172\1\107\2\uffff\1\0\3\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\14\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1"+
        "\52\1\53\3\uffff\1\54\1\61\1\63\1\64\1\65\1\67\1\70\1\71\1\72\1"+
        "\74\3\uffff\1\3\1\uffff\1\6\1\7\1\10\1\26\1\27\1\30\1\31\1\32\1"+
        "\35\1\73\1\uffff\1\12\1\14\1\15\1\21\1\22\1\23\1\24\1\25\1\62\10"+
        "\uffff\1\36\1\60\2\uffff\1\40\1\41\1\66\3\uffff\1\56\2\uffff\1\13"+
        "\1\16\1\17\1\uffff\1\55\2\uffff\1\57\10\uffff\1\11\1\20\7\uffff"+
        "\1\37\12\uffff\1\33\1\34\1\uffff\1\4\1\5\1\2";
    static final String DFA12_specialS =
        "\1\46\1\uffff\1\51\1\uffff\1\53\1\31\1\17\1\26\1\6\1\50\1\61\1\uffff"+
        "\1\30\13\uffff\1\25\1\40\1\52\12\uffff\1\12\1\35\1\7\26\uffff\1"+
        "\37\1\36\1\33\1\44\1\2\1\34\1\32\1\15\2\uffff\1\55\1\42\3\uffff"+
        "\1\41\1\27\1\10\6\uffff\1\4\1\uffff\1\11\1\56\1\uffff\1\16\1\uffff"+
        "\1\5\1\3\1\13\1\45\1\14\3\uffff\1\1\1\22\1\62\1\21\1\uffff\1\0\1"+
        "\24\1\uffff\1\20\1\uffff\1\63\1\54\1\23\1\uffff\1\57\1\60\1\43\3"+
        "\uffff\1\47\3\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\17\1\16\2\uffff\1\16\22\uffff\1\17\1\41\1\26\2\uffff\1\40"+
            "\2\uffff\1\20\1\21\1\35\1\36\1\42\1\37\1\4\1\15\12\32\1\3\1"+
            "\43\1\13\1\34\1\uffff\1\44\1\uffff\1\31\1\6\2\31\1\5\1\31\1"+
            "\2\6\31\1\7\5\31\1\14\3\31\1\10\2\31\1\22\1\uffff\1\23\1\uffff"+
            "\1\33\1\uffff\1\11\16\30\1\12\12\30\1\24\1\1\1\25\1\27",
            "",
            "\12\47\7\uffff\26\47\1\45\3\47\4\uffff\1\47\1\uffff\32\47",
            "\1\62\27\uffff\1\50\3\uffff\1\51\6\uffff\1\53\1\uffff\1\52"+
            "\16\uffff\1\57\1\uffff\1\61\4\uffff\1\60\5\uffff\1\54\1\uffff"+
            "\1\56\3\uffff\1\55",
            "\1\66\4\uffff\1\67\33\uffff\1\72\10\uffff\1\70\1\uffff\1\73"+
            "\1\uffff\1\71\1\uffff\1\65\1\64\4\uffff\1\74",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\2\104\1\102\27"+
            "\104",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\4\104\1\105\25"+
            "\104",
            "\1\106",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\21\47\1\110\10\47",
            "\1\112\4\uffff\1\113",
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
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\116\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
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
            "\12\47\7\uffff\4\47\1\117\25\47\4\uffff\1\47\1\uffff\32\47",
            "\1\uffff",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
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
            "\1\uffff",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\7\104\1\126\22"+
            "\104",
            "\1\uffff",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\21\104\1\130\10"+
            "\104",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\24\47\1\131\5\47",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "\12\116\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\47\7\uffff\15\47\1\133\14\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\134",
            "\1\135",
            "",
            "",
            "",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\10\104\1\136\21"+
            "\104",
            "",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\5\104\1\137\24"+
            "\104",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\140\25\47",
            "",
            "\12\47\7\uffff\3\47\1\141\26\47\4\uffff\1\47\1\uffff\32\47",
            "\1\142",
            "\1\143\17\uffff\1\144",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\4\104\1\145\25"+
            "\104",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\16\104\1\146\13"+
            "\104",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\16\47\1\150\13\47\4\uffff\1\47\1\uffff\32\47",
            "\1\151",
            "",
            "",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\25\104\1\152\4"+
            "\104",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\21\104\1\153\10"+
            "\104",
            "\1\uffff",
            "\12\47\7\uffff\13\47\1\155\16\47\4\uffff\1\47\1\uffff\32\47",
            "\1\156",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\4\104\1\157\25"+
            "\104",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\14\104\1\160\15"+
            "\104",
            "",
            "\12\47\7\uffff\4\47\1\161\25\47\4\uffff\1\47\1\uffff\32\47",
            "\1\162",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
            "\12\104\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
            "\12\47\7\uffff\15\47\1\165\14\47\4\uffff\1\47\1\uffff\32\47",
            "\1\166",
            "\1\uffff",
            "\1\uffff",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\173\4\uffff\1\172",
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
            return "1:1: Tokens : ( T__63 | GWENDOLEN | ETHICS | GOALS | BELIEFS | BELIEFRULES | PLANS | NAME | SEND | RECEIVED | ETHIC | BELIEVE | GOAL | IN_CONTENT | IN_CONTEXT | SENT | LOCK | ADD_PLAN | ADD_CONSTRAINT | ADD_CONTENT | ADD_CONTEXT | TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT | ACHIEVEGOAL | PERFORMGOAL | BRULEARROW | RULEARROW | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_106 = input.LA(1);

                         
                        int index12_106 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_106=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 111;}

                        else if ( ((LA12_106 >= '0' && LA12_106 <= '9')||(LA12_106 >= 'A' && LA12_106 <= 'Z')||LA12_106=='_'||(LA12_106 >= 'a' && LA12_106 <= 'd')||(LA12_106 >= 'f' && LA12_106 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_106);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA12_101 = input.LA(1);

                         
                        int index12_101 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_101=='v') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 106;}

                        else if ( ((LA12_101 >= '0' && LA12_101 <= '9')||(LA12_101 >= 'A' && LA12_101 <= 'Z')||LA12_101=='_'||(LA12_101 >= 'a' && LA12_101 <= 'u')||(LA12_101 >= 'w' && LA12_101 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_101);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA12_66 = input.LA(1);

                         
                        int index12_66 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_66=='h') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 86;}

                        else if ( ((LA12_66 >= '0' && LA12_66 <= '9')||(LA12_66 >= 'A' && LA12_66 <= 'Z')||LA12_66=='_'||(LA12_66 >= 'a' && LA12_66 <= 'g')||(LA12_66 >= 'i' && LA12_66 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_66);

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA12_94 = input.LA(1);

                         
                        int index12_94 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_94=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 101;}

                        else if ( ((LA12_94 >= '0' && LA12_94 <= '9')||(LA12_94 >= 'A' && LA12_94 <= 'Z')||LA12_94=='_'||(LA12_94 >= 'a' && LA12_94 <= 'd')||(LA12_94 >= 'f' && LA12_94 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_94);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA12_86 = input.LA(1);

                         
                        int index12_86 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_86=='i') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 94;}

                        else if ( ((LA12_86 >= '0' && LA12_86 <= '9')||(LA12_86 >= 'A' && LA12_86 <= 'Z')||LA12_86=='_'||(LA12_86 >= 'a' && LA12_86 <= 'h')||(LA12_86 >= 'j' && LA12_86 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_86);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA12_93 = input.LA(1);

                         
                        int index12_93 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_93=='d') ) {s = 99;}

                        else if ( (LA12_93=='t') && ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1))) {s = 100;}

                         
                        input.seek(index12_93);

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA12_8 = input.LA(1);

                         
                        int index12_8 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_8 >= '0' && LA12_8 <= '9')||(LA12_8 >= 'A' && LA12_8 <= 'Z')||LA12_8=='_'||(LA12_8 >= 'a' && LA12_8 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 65;

                         
                        input.seek(index12_8);

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA12_39 = input.LA(1);

                         
                        int index12_39 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_39 >= '0' && LA12_39 <= '9')||(LA12_39 >= 'A' && LA12_39 <= 'Z')||LA12_39=='_'||(LA12_39 >= 'a' && LA12_39 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 73;

                         
                        input.seek(index12_39);

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA12_79 = input.LA(1);

                         
                        int index12_79 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_79=='N') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 91;}

                        else if ( ((LA12_79 >= '0' && LA12_79 <= '9')||(LA12_79 >= 'A' && LA12_79 <= 'M')||(LA12_79 >= 'O' && LA12_79 <= 'Z')||LA12_79=='_'||(LA12_79 >= 'a' && LA12_79 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 73;

                         
                        input.seek(index12_79);

                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA12_88 = input.LA(1);

                         
                        int index12_88 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_88=='f') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 95;}

                        else if ( ((LA12_88 >= '0' && LA12_88 <= '9')||(LA12_88 >= 'A' && LA12_88 <= 'Z')||LA12_88=='_'||(LA12_88 >= 'a' && LA12_88 <= 'e')||(LA12_88 >= 'g' && LA12_88 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_88);

                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA12_37 = input.LA(1);

                         
                        int index12_37 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_37=='E') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 79;}

                        else if ( ((LA12_37 >= '0' && LA12_37 <= '9')||(LA12_37 >= 'A' && LA12_37 <= 'D')||(LA12_37 >= 'F' && LA12_37 <= 'Z')||LA12_37=='_'||(LA12_37 >= 'a' && LA12_37 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 73;

                         
                        input.seek(index12_37);

                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA12_95 = input.LA(1);

                         
                        int index12_95 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_95=='o') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 102;}

                        else if ( ((LA12_95 >= '0' && LA12_95 <= '9')||(LA12_95 >= 'A' && LA12_95 <= 'Z')||LA12_95=='_'||(LA12_95 >= 'a' && LA12_95 <= 'n')||(LA12_95 >= 'p' && LA12_95 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_95);

                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA12_97 = input.LA(1);

                         
                        int index12_97 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_97=='O') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 104;}

                        else if ( ((LA12_97 >= '0' && LA12_97 <= '9')||(LA12_97 >= 'A' && LA12_97 <= 'N')||(LA12_97 >= 'P' && LA12_97 <= 'Z')||LA12_97=='_'||(LA12_97 >= 'a' && LA12_97 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 73;

                         
                        input.seek(index12_97);

                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA12_69 = input.LA(1);

                         
                        int index12_69 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_69=='r') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 88;}

                        else if ( ((LA12_69 >= '0' && LA12_69 <= '9')||(LA12_69 >= 'A' && LA12_69 <= 'Z')||LA12_69=='_'||(LA12_69 >= 'a' && LA12_69 <= 'q')||(LA12_69 >= 's' && LA12_69 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_69);

                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA12_91 = input.LA(1);

                         
                        int index12_91 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_91=='D') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 97;}

                        else if ( ((LA12_91 >= '0' && LA12_91 <= '9')||(LA12_91 >= 'A' && LA12_91 <= 'C')||(LA12_91 >= 'E' && LA12_91 <= 'Z')||LA12_91=='_'||(LA12_91 >= 'a' && LA12_91 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 73;

                         
                        input.seek(index12_91);

                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA12_6 = input.LA(1);

                         
                        int index12_6 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_6 >= '0' && LA12_6 <= '9')||(LA12_6 >= 'A' && LA12_6 <= 'Z')||LA12_6=='_'||(LA12_6 >= 'a' && LA12_6 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 63;

                         
                        input.seek(index12_6);

                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA12_109 = input.LA(1);

                         
                        int index12_109 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_109=='E') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 113;}

                        else if ( ((LA12_109 >= '0' && LA12_109 <= '9')||(LA12_109 >= 'A' && LA12_109 <= 'D')||(LA12_109 >= 'F' && LA12_109 <= 'Z')||LA12_109=='_'||(LA12_109 >= 'a' && LA12_109 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 73;

                         
                        input.seek(index12_109);

                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA12_104 = input.LA(1);

                         
                        int index12_104 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_104=='L') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 109;}

                        else if ( ((LA12_104 >= '0' && LA12_104 <= '9')||(LA12_104 >= 'A' && LA12_104 <= 'K')||(LA12_104 >= 'M' && LA12_104 <= 'Z')||LA12_104=='_'||(LA12_104 >= 'a' && LA12_104 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 73;

                         
                        input.seek(index12_104);

                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA12_102 = input.LA(1);

                         
                        int index12_102 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_102=='r') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 107;}

                        else if ( ((LA12_102 >= '0' && LA12_102 <= '9')||(LA12_102 >= 'A' && LA12_102 <= 'Z')||LA12_102=='_'||(LA12_102 >= 'a' && LA12_102 <= 'q')||(LA12_102 >= 's' && LA12_102 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_102);

                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA12_113 = input.LA(1);

                         
                        int index12_113 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_113=='N') && (((curly_nesting == 0)||(stringterm)||(!stringterm)))) {s = 117;}

                        else if ( ((LA12_113 >= '0' && LA12_113 <= '9')||(LA12_113 >= 'A' && LA12_113 <= 'M')||(LA12_113 >= 'O' && LA12_113 <= 'Z')||LA12_113=='_'||(LA12_113 >= 'a' && LA12_113 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 73;

                         
                        input.seek(index12_113);

                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA12_107 = input.LA(1);

                         
                        int index12_107 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_107=='m') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 112;}

                        else if ( ((LA12_107 >= '0' && LA12_107 <= '9')||(LA12_107 >= 'A' && LA12_107 <= 'Z')||LA12_107=='_'||(LA12_107 >= 'a' && LA12_107 <= 'l')||(LA12_107 >= 'n' && LA12_107 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_107);

                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA12_24 = input.LA(1);

                         
                        int index12_24 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_24 >= '0' && LA12_24 <= '9')||(LA12_24 >= 'A' && LA12_24 <= 'Z')||LA12_24=='_'||(LA12_24 >= 'a' && LA12_24 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_24);

                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA12_7 = input.LA(1);

                         
                        int index12_7 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_7 >= '0' && LA12_7 <= '9')||(LA12_7 >= 'A' && LA12_7 <= 'Z')||LA12_7=='_'||(LA12_7 >= 'a' && LA12_7 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 64;

                         
                        input.seek(index12_7);

                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA12_78 = input.LA(1);

                         
                        int index12_78 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_78 >= '0' && LA12_78 <= '9')) && (((!stringterm)||(stringterm)))) {s = 78;}

                        else if ( ((LA12_78 >= 'A' && LA12_78 <= 'Z')||LA12_78=='_'||(LA12_78 >= 'a' && LA12_78 <= 'z')) && ((stringterm))) {s = 27;}

                        else s = 77;

                         
                        input.seek(index12_78);

                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA12_12 = input.LA(1);

                         
                        int index12_12 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_12=='r') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 72;}

                        else if ( ((LA12_12 >= '0' && LA12_12 <= '9')||(LA12_12 >= 'A' && LA12_12 <= 'Z')||LA12_12=='_'||(LA12_12 >= 'a' && LA12_12 <= 'q')||(LA12_12 >= 's' && LA12_12 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 73;

                         
                        input.seek(index12_12);

                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA12_5 = input.LA(1);

                         
                        int index12_5 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_5 >= '0' && LA12_5 <= '9')||(LA12_5 >= 'A' && LA12_5 <= 'Z')||LA12_5=='_'||(LA12_5 >= 'a' && LA12_5 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 62;

                         
                        input.seek(index12_5);

                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA12_68 = input.LA(1);

                         
                        int index12_68 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_68 >= '0' && LA12_68 <= '9')||(LA12_68 >= 'A' && LA12_68 <= 'Z')||LA12_68=='_'||(LA12_68 >= 'a' && LA12_68 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_68);

                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA12_64 = input.LA(1);

                         
                        int index12_64 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 84;}

                        else if ( ((stringterm)) ) {s = 27;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index12_64);

                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA12_67 = input.LA(1);

                         
                        int index12_67 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((stringterm)) ) {s = 27;}

                        else if ( ((!stringterm)) ) {s = 87;}

                         
                        input.seek(index12_67);

                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA12_38 = input.LA(1);

                         
                        int index12_38 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 55;}

                        else if ( ((stringterm)) ) {s = 27;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index12_38);

                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA12_63 = input.LA(1);

                         
                        int index12_63 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 54;}

                        else if ( ((stringterm)) ) {s = 27;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index12_63);

                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA12_62 = input.LA(1);

                         
                        int index12_62 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 83;}

                        else if ( ((stringterm)) ) {s = 27;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index12_62);

                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA12_25 = input.LA(1);

                         
                        int index12_25 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_25 >= '0' && LA12_25 <= '9')||(LA12_25 >= 'A' && LA12_25 <= 'Z')||LA12_25=='_'||(LA12_25 >= 'a' && LA12_25 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 73;

                         
                        input.seek(index12_25);

                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA12_77 = input.LA(1);

                         
                        int index12_77 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((stringterm)) ) {s = 27;}

                        else if ( ((!stringterm)) ) {s = 90;}

                         
                        input.seek(index12_77);

                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA12_73 = input.LA(1);

                         
                        int index12_73 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((stringterm)) ) {s = 27;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index12_73);

                        if ( s>=0 ) return s;
                        break;

                    case 35 : 
                        int LA12_117 = input.LA(1);

                         
                        int index12_117 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_117 >= '0' && LA12_117 <= '9')||(LA12_117 >= 'A' && LA12_117 <= 'Z')||LA12_117=='_'||(LA12_117 >= 'a' && LA12_117 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 121;

                         
                        input.seek(index12_117);

                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA12_65 = input.LA(1);

                         
                        int index12_65 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)) ) {s = 85;}

                        else if ( ((stringterm)) ) {s = 27;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index12_65);

                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA12_96 = input.LA(1);

                         
                        int index12_96 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_96 >= '0' && LA12_96 <= '9')||(LA12_96 >= 'A' && LA12_96 <= 'Z')||LA12_96=='_'||(LA12_96 >= 'a' && LA12_96 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 103;

                         
                        input.seek(index12_96);

                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA12_0 = input.LA(1);

                         
                        int index12_0 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_0=='|') ) {s = 1;}

                        else if ( (LA12_0=='G') && (((curly_nesting == 0)||(stringterm)||(!stringterm)||(curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)))) {s = 2;}

                        else if ( (LA12_0==':') ) {s = 3;}

                        else if ( (LA12_0=='.') ) {s = 4;}

                        else if ( (LA12_0=='E') && (((!stringterm)||(stringterm)||(curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)))) {s = 5;}

                        else if ( (LA12_0=='B') && (((stringterm)||(!stringterm)||(curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)))) {s = 6;}

                        else if ( (LA12_0=='N') && (((!stringterm)||(stringterm)||(curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)))) {s = 7;}

                        else if ( (LA12_0=='X') && (((!stringterm)||(stringterm)||(curly_nesting > 0 && plain_nesting == 0|| belief_rules==1)))) {s = 8;}

                        else if ( (LA12_0=='a') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 9;}

                        else if ( (LA12_0=='p') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 10;}

                        else if ( (LA12_0=='<') ) {s = 11;}

                        else if ( (LA12_0=='T') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 12;}

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

                        else if ( (LA12_0=='A'||(LA12_0 >= 'C' && LA12_0 <= 'D')||LA12_0=='F'||(LA12_0 >= 'H' && LA12_0 <= 'M')||(LA12_0 >= 'O' && LA12_0 <= 'S')||(LA12_0 >= 'U' && LA12_0 <= 'W')||(LA12_0 >= 'Y' && LA12_0 <= 'Z')) && (((!stringterm)||(stringterm)))) {s = 25;}

                        else if ( ((LA12_0 >= '0' && LA12_0 <= '9')) && (((!stringterm)||(stringterm)))) {s = 26;}

                        else if ( (LA12_0=='_') && ((stringterm))) {s = 27;}

                        else if ( (LA12_0=='=') ) {s = 28;}

                        else if ( (LA12_0=='*') ) {s = 29;}

                        else if ( (LA12_0=='+') ) {s = 30;}

                        else if ( (LA12_0=='-') ) {s = 31;}

                        else if ( (LA12_0=='%') ) {s = 32;}

                        else if ( (LA12_0=='!') ) {s = 33;}

                        else if ( (LA12_0==',') ) {s = 34;}

                        else if ( (LA12_0==';') ) {s = 35;}

                        else if ( (LA12_0=='?') ) {s = 36;}

                         
                        input.seek(index12_0);

                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA12_121 = input.LA(1);

                         
                        int index12_121 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting == 0)) ) {s = 124;}

                        else if ( ((stringterm)) ) {s = 27;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index12_121);

                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA12_9 = input.LA(1);

                         
                        int index12_9 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_9=='c') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 66;}

                        else if ( ((LA12_9 >= '0' && LA12_9 <= '9')||(LA12_9 >= 'A' && LA12_9 <= 'Z')||LA12_9=='_'||(LA12_9 >= 'a' && LA12_9 <= 'b')||(LA12_9 >= 'd' && LA12_9 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_9);

                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA12_2 = input.LA(1);

                         
                        int index12_2 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_2=='W') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 37;}

                        else if ( ((LA12_2 >= '0' && LA12_2 <= '9')||(LA12_2 >= 'A' && LA12_2 <= 'V')||(LA12_2 >= 'X' && LA12_2 <= 'Z')||LA12_2=='_'||(LA12_2 >= 'a' && LA12_2 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 38;

                         
                        input.seek(index12_2);

                        if ( s>=0 ) return s;
                        break;

                    case 42 : 
                        int LA12_26 = input.LA(1);

                         
                        int index12_26 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_26 >= '0' && LA12_26 <= '9')) && (((!stringterm)||(stringterm)))) {s = 78;}

                        else if ( ((LA12_26 >= 'A' && LA12_26 <= 'Z')||LA12_26=='_'||(LA12_26 >= 'a' && LA12_26 <= 'z')) && ((stringterm))) {s = 27;}

                        else s = 77;

                         
                        input.seek(index12_26);

                        if ( s>=0 ) return s;
                        break;

                    case 43 : 
                        int LA12_4 = input.LA(1);

                         
                        int index12_4 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_4=='s') ) {s = 52;}

                        else if ( (LA12_4=='r') && ((gwendolen))) {s = 53;}

                        else if ( (LA12_4=='B') && ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1))) {s = 54;}

                        else if ( (LA12_4=='G') && ((curly_nesting > 0 && plain_nesting == 0|| belief_rules==1))) {s = 55;}

                        else if ( (LA12_4=='l') ) {s = 56;}

                        else if ( (LA12_4=='p') ) {s = 57;}

                        else if ( (LA12_4=='c') ) {s = 58;}

                        else if ( (LA12_4=='n') ) {s = 59;}

                        else if ( (LA12_4=='x') ) {s = 60;}

                        else s = 61;

                         
                        input.seek(index12_4);

                        if ( s>=0 ) return s;
                        break;

                    case 44 : 
                        int LA12_112 = input.LA(1);

                         
                        int index12_112 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_112 >= '0' && LA12_112 <= '9')||(LA12_112 >= 'A' && LA12_112 <= 'Z')||LA12_112=='_'||(LA12_112 >= 'a' && LA12_112 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 116;

                         
                        input.seek(index12_112);

                        if ( s>=0 ) return s;
                        break;

                    case 45 : 
                        int LA12_72 = input.LA(1);

                         
                        int index12_72 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_72=='u') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 89;}

                        else if ( ((LA12_72 >= '0' && LA12_72 <= '9')||(LA12_72 >= 'A' && LA12_72 <= 'Z')||LA12_72=='_'||(LA12_72 >= 'a' && LA12_72 <= 't')||(LA12_72 >= 'v' && LA12_72 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 73;

                         
                        input.seek(index12_72);

                        if ( s>=0 ) return s;
                        break;

                    case 46 : 
                        int LA12_89 = input.LA(1);

                         
                        int index12_89 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_89=='e') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 96;}

                        else if ( ((LA12_89 >= '0' && LA12_89 <= '9')||(LA12_89 >= 'A' && LA12_89 <= 'Z')||LA12_89=='_'||(LA12_89 >= 'a' && LA12_89 <= 'd')||(LA12_89 >= 'f' && LA12_89 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 39;}

                        else s = 73;

                         
                        input.seek(index12_89);

                        if ( s>=0 ) return s;
                        break;

                    case 47 : 
                        int LA12_115 = input.LA(1);

                         
                        int index12_115 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((sq_nesting > 0)) ) {s = 119;}

                        else if ( ((stringterm)) ) {s = 27;}

                        else if ( ((!stringterm)) ) {s = 87;}

                         
                        input.seek(index12_115);

                        if ( s>=0 ) return s;
                        break;

                    case 48 : 
                        int LA12_116 = input.LA(1);

                         
                        int index12_116 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((sq_nesting > 0)) ) {s = 120;}

                        else if ( ((stringterm)) ) {s = 27;}

                        else if ( ((!stringterm)) ) {s = 87;}

                         
                        input.seek(index12_116);

                        if ( s>=0 ) return s;
                        break;

                    case 49 : 
                        int LA12_10 = input.LA(1);

                         
                        int index12_10 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA12_10=='e') && (((!stringterm)||(stringterm)||(sq_nesting > 0)))) {s = 69;}

                        else if ( ((LA12_10 >= '0' && LA12_10 <= '9')||(LA12_10 >= 'A' && LA12_10 <= 'Z')||LA12_10=='_'||(LA12_10 >= 'a' && LA12_10 <= 'd')||(LA12_10 >= 'f' && LA12_10 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 67;

                         
                        input.seek(index12_10);

                        if ( s>=0 ) return s;
                        break;

                    case 50 : 
                        int LA12_103 = input.LA(1);

                         
                        int index12_103 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 108;}

                        else if ( ((stringterm)) ) {s = 27;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index12_103);

                        if ( s>=0 ) return s;
                        break;

                    case 51 : 
                        int LA12_111 = input.LA(1);

                         
                        int index12_111 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA12_111 >= '0' && LA12_111 <= '9')||(LA12_111 >= 'A' && LA12_111 <= 'Z')||LA12_111=='_'||(LA12_111 >= 'a' && LA12_111 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 68;}

                        else s = 115;

                         
                        input.seek(index12_111);

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