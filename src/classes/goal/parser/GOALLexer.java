// $ANTLR 3.4 /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g 2013-05-16 12:42:39

package goal.parser;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class GOALLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ADOPT=4;
    public static final int AGNAME=5;
    public static final int AND=6;
    public static final int ANON_VAR=7;
    public static final int BELIEFS=8;
    public static final int BELIEVE=9;
    public static final int BRULEARROW=10;
    public static final int BRULES=11;
    public static final int CAPABILITIES=12;
    public static final int CLOSE=13;
    public static final int CLOSEKEY=14;
    public static final int COLON=15;
    public static final int COMMA=16;
    public static final int COMMENT=17;
    public static final int CONDACTIONS=18;
    public static final int CONST=19;
    public static final int CONTENT=20;
    public static final int CONTEXT=21;
    public static final int CURLYCLOSE=22;
    public static final int CURLYOPEN=23;
    public static final int DEL=24;
    public static final int DIV=25;
    public static final int DOUBLEQUOTE=26;
    public static final int DROP=27;
    public static final int EQ=28;
    public static final int GOAL=29;
    public static final int GOALS=30;
    public static final int HAVEGOAL=31;
    public static final int IF=32;
    public static final int INS=33;
    public static final int IN_CONTENT=34;
    public static final int IN_CONTEXT=35;
    public static final int LESS=36;
    public static final int LINE_COMMENT=37;
    public static final int MINUS=38;
    public static final int MOD=39;
    public static final int MULT=40;
    public static final int NAME=41;
    public static final int NEWLINE=42;
    public static final int NOT=43;
    public static final int NUMBER=44;
    public static final int NUMMARKER=45;
    public static final int OPEN=46;
    public static final int PLUS=47;
    public static final int POINT=48;
    public static final int QUERY=49;
    public static final int SEMI=50;
    public static final int SEND=51;
    public static final int SHRIEK=52;
    public static final int SQCLOSE=53;
    public static final int SQOPEN=54;
    public static final int STRING=55;
    public static final int THEN=56;
    public static final int TRUE=57;
    public static final int VAR=58;
    public static final int WS=59;

        public int plain_nesting = 0;
        public int sq_nesting = 0;
        public int curly_nesting = 0;
        public boolean stringterm = false;
        public boolean preconditiontypemode = false;
        public boolean condaction = false;
        public boolean actionspec = false;
        public boolean start = true;
        public int commacount = 0;


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public GOALLexer() {} 
    public GOALLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public GOALLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g"; }

    // $ANTLR start "GOALS"
    public final void mGOALS() throws RecognitionException {
        try {
            int _type = GOALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:137:7: ( ':goals' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:137:9: ':goals'
            {
            match(":goals"); 



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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:138:9: ( ':beliefs' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:138:11: ':beliefs'
            {
            match(":beliefs"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BELIEFS"

    // $ANTLR start "CAPABILITIES"
    public final void mCAPABILITIES() throws RecognitionException {
        try {
            int _type = CAPABILITIES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:140:2: ( ':Action Specifications:' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:140:4: ':Action Specifications:'
            {
            match(":Action Specifications:"); 



            actionspec=true; condaction=false;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CAPABILITIES"

    // $ANTLR start "CONDACTIONS"
    public final void mCONDACTIONS() throws RecognitionException {
        try {
            int _type = CONDACTIONS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:141:13: ( ':Conditional Actions:' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:141:15: ':Conditional Actions:'
            {
            match(":Conditional Actions:"); 



            condaction=true;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONDACTIONS"

    // $ANTLR start "GOAL"
    public final void mGOAL() throws RecognitionException {
        try {
            int _type = GOAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:142:6: ({...}? => 'GOAL' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:142:8: {...}? => 'GOAL'
            {
            if ( !((start)) ) {
                throw new FailedPredicateException(input, "GOAL", "start");
            }

            match("GOAL"); 



            start = false;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GOAL"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:143:6: ( ':name:' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:143:8: ':name:'
            {
            match(":name:"); 



            actionspec=false;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NAME"

    // $ANTLR start "AGNAME"
    public final void mAGNAME() throws RecognitionException {
        try {
            int _type = AGNAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:144:8: ( ':me' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:144:10: ':me'
            {
            match(":me"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AGNAME"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:145:6: ( 'True' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:145:8: 'True'
            {
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

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:146:4: ({...}? => 'if' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:146:6: {...}? => 'if'
            {
            if ( !((condaction)) ) {
                throw new FailedPredicateException(input, "IF", "condaction");
            }

            match("if"); 



            preconditiontypemode = true;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:147:6: ({...}? => 'then' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:147:8: {...}? => 'then'
            {
            if ( !((condaction)) ) {
                throw new FailedPredicateException(input, "THEN", "condaction");
            }

            match("then"); 



            preconditiontypemode = false;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "BELIEVE"
    public final void mBELIEVE() throws RecognitionException {
        try {
            int _type = BELIEVE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:148:9: ({...}? => 'B' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:148:11: {...}? => 'B'
            {
            if ( !(((preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0))) ) {
                throw new FailedPredicateException(input, "BELIEVE", "(preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0)");
            }

            match('B'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BELIEVE"

    // $ANTLR start "HAVEGOAL"
    public final void mHAVEGOAL() throws RecognitionException {
        try {
            int _type = HAVEGOAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:150:2: ({...}? => 'G' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:150:4: {...}? => 'G'
            {
            if ( !(((preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0))) ) {
                throw new FailedPredicateException(input, "HAVEGOAL", "(preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0)");
            }

            match('G'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HAVEGOAL"

    // $ANTLR start "IN_CONTENT"
    public final void mIN_CONTENT() throws RecognitionException {
        try {
            int _type = IN_CONTENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:152:2: ({...}? => 'N' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:152:4: {...}? => 'N'
            {
            if ( !(((preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0))) ) {
                throw new FailedPredicateException(input, "IN_CONTENT", "(preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0)");
            }

            match('N'); 

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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:154:2: ({...}? => 'X' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:154:4: {...}? => 'X'
            {
            if ( !(((preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0))) ) {
                throw new FailedPredicateException(input, "IN_CONTEXT", "(preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0)");
            }

            match('X'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IN_CONTEXT"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:155:5: ( '&' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:155:8: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "NUMMARKER"
    public final void mNUMMARKER() throws RecognitionException {
        try {
            int _type = NUMMARKER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:157:2: ( '_' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:157:4: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMMARKER"

    // $ANTLR start "BRULEARROW"
    public final void mBRULEARROW() throws RecognitionException {
        try {
            int _type = BRULEARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:158:12: ( ':-' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:158:14: ':-'
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

    // $ANTLR start "BRULES"
    public final void mBRULES() throws RecognitionException {
        try {
            int _type = BRULES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:159:9: ( ':Belief Rules:' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:159:11: ':Belief Rules:'
            {
            match(":Belief Rules:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BRULES"

    // $ANTLR start "DEL"
    public final void mDEL() throws RecognitionException {
        try {
            int _type = DEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:160:5: ({...}? => 'del' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:160:7: {...}? => 'del'
            {
            if ( !(((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {
                throw new FailedPredicateException(input, "DEL", "(condaction==true && preconditiontypemode==false && plain_nesting==0)");
            }

            match("del"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEL"

    // $ANTLR start "ADOPT"
    public final void mADOPT() throws RecognitionException {
        try {
            int _type = ADOPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:161:7: ({...}? => 'adopt' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:161:9: {...}? => 'adopt'
            {
            if ( !(((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {
                throw new FailedPredicateException(input, "ADOPT", "(condaction==true && preconditiontypemode==false && plain_nesting==0)");
            }

            match("adopt"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ADOPT"

    // $ANTLR start "CLOSEKEY"
    public final void mCLOSEKEY() throws RecognitionException {
        try {
            int _type = CLOSEKEY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:162:10: ({...}? => 'close' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:162:12: {...}? => 'close'
            {
            if ( !(((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {
                throw new FailedPredicateException(input, "CLOSEKEY", "(condaction==true && preconditiontypemode==false && plain_nesting==0)");
            }

            match("close"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CLOSEKEY"

    // $ANTLR start "SEND"
    public final void mSEND() throws RecognitionException {
        try {
            int _type = SEND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:163:6: ({...}? => 'send' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:163:8: {...}? => 'send'
            {
            if ( !(((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {
                throw new FailedPredicateException(input, "SEND", "(condaction==true && preconditiontypemode==false && plain_nesting==0)");
            }

            match("send"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEND"

    // $ANTLR start "DROP"
    public final void mDROP() throws RecognitionException {
        try {
            int _type = DROP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:164:6: ({...}? => 'drop' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:164:8: {...}? => 'drop'
            {
            if ( !(((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {
                throw new FailedPredicateException(input, "DROP", "(condaction==true && preconditiontypemode==false && plain_nesting==0)");
            }

            match("drop"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DROP"

    // $ANTLR start "INS"
    public final void mINS() throws RecognitionException {
        try {
            int _type = INS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:165:5: ({...}? => 'ins' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:165:7: {...}? => 'ins'
            {
            if ( !(((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {
                throw new FailedPredicateException(input, "INS", "(condaction==true && preconditiontypemode==false && plain_nesting==0)");
            }

            match("ins"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INS"

    // $ANTLR start "CONTENT"
    public final void mCONTENT() throws RecognitionException {
        try {
            int _type = CONTENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:166:9: ({...}? => 'nt' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:166:11: {...}? => 'nt'
            {
            if ( !(((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {
                throw new FailedPredicateException(input, "CONTENT", "(condaction==true && preconditiontypemode==false && plain_nesting==0)");
            }

            match("nt"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONTENT"

    // $ANTLR start "CONTEXT"
    public final void mCONTEXT() throws RecognitionException {
        try {
            int _type = CONTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:167:9: ({...}? => 'xt' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:167:11: {...}? => 'xt'
            {
            if ( !(((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {
                throw new FailedPredicateException(input, "CONTEXT", "(condaction==true && preconditiontypemode==false && plain_nesting==0)");
            }

            match("xt"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONTEXT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:219:5: ( '/*' ( . )* '*/' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:219:7: '/*' ( . )* '*/'
            {
            match("/*"); 



            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:219:12: ( . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1 >= '\u0000' && LA1_1 <= '.')||(LA1_1 >= '0' && LA1_1 <= '\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0 >= '\u0000' && LA1_0 <= ')')||(LA1_0 >= '+' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:219:12: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:222:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:222:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 



            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:222:12: (~ ( '\\n' | '\\r' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:
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
            	    break loop2;
                }
            } while (true);


            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:222:26: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:222:26: '\\r'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:224:8: ( ( '\\r' )? '\\n' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:224:9: ( '\\r' )? '\\n'
            {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:224:9: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:224:9: '\\r'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:225:5: ( ( ' ' | '\\t' )+ )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:225:9: ( ' ' | '\\t' )+
            {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:225:9: ( ' ' | '\\t' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:
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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:228:6: ( '(' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:228:9: '('
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:229:7: ( ')' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:229:9: ')'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:230:8: ( '[' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:230:10: '['
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:231:9: ( ']' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:231:11: ']'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:232:11: ( '{' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:232:13: '{'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:233:12: ( '}' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:233:14: '}'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:235:2: ( '\"' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:235:4: '\"'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:237:5: ( '~' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:237:7: '~'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:239:8: ({...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:239:10: {...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
            {
            if ( !((stringterm)) ) {
                throw new FailedPredicateException(input, "STRING", "stringterm");
            }

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:239:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:240:8: ({...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:240:11: {...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( !((!stringterm)) ) {
                throw new FailedPredicateException(input, "CONST", "!stringterm");
            }

            matchRange('a','z'); 

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:240:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:
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
            	    break loop7;
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:241:5: ({...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:241:7: {...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( !((!stringterm)) ) {
                throw new FailedPredicateException(input, "VAR", "!stringterm");
            }

            matchRange('A','Z'); 

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:241:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:
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
            	    break loop8;
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:242:8: ({...}? => '0' .. '9' ( '0' .. '9' )* )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:242:10: {...}? => '0' .. '9' ( '0' .. '9' )*
            {
            if ( !((!stringterm)) ) {
                throw new FailedPredicateException(input, "NUMBER", "!stringterm");
            }

            matchRange('0','9'); 

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:242:35: ( '0' .. '9' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:
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
    // $ANTLR end "NUMBER"

    // $ANTLR start "ANON_VAR"
    public final void mANON_VAR() throws RecognitionException {
        try {
            int _type = ANON_VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:243:10: ({...}? => '_' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:243:12: {...}? => '_'
            {
            if ( !((!stringterm)) ) {
                throw new FailedPredicateException(input, "ANON_VAR", "!stringterm");
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
    // $ANTLR end "ANON_VAR"

    // $ANTLR start "LESS"
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:246:6: ( '<' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:246:8: '<'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:247:4: ( '==' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:247:7: '=='
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:248:7: ( '.' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:248:9: '.'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:249:6: ( '*' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:249:8: '*'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:250:6: ( '+' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:250:8: '+'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:251:7: ( '-' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:251:9: '-'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:252:5: ( '/' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:252:7: '/'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:253:5: ( '%' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:253:7: '%'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:255:8: ( '!' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:255:10: '!'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:256:7: ( ',' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:256:9: ','
            {
            match(','); 

            commacount++;

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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:257:6: ( ';' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:257:8: ';'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:258:7: ( ':' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:258:9: ':'
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
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:259:7: ( '?' )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:259:9: '?'
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
        // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:8: ( GOALS | BELIEFS | CAPABILITIES | CONDACTIONS | GOAL | NAME | AGNAME | TRUE | IF | THEN | BELIEVE | HAVEGOAL | IN_CONTENT | IN_CONTEXT | AND | NUMMARKER | BRULEARROW | BRULES | DEL | ADOPT | CLOSEKEY | SEND | DROP | INS | CONTENT | CONTEXT | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | ANON_VAR | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY )
        int alt10=56;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:10: GOALS
                {
                mGOALS(); 


                }
                break;
            case 2 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:16: BELIEFS
                {
                mBELIEFS(); 


                }
                break;
            case 3 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:24: CAPABILITIES
                {
                mCAPABILITIES(); 


                }
                break;
            case 4 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:37: CONDACTIONS
                {
                mCONDACTIONS(); 


                }
                break;
            case 5 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:49: GOAL
                {
                mGOAL(); 


                }
                break;
            case 6 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:54: NAME
                {
                mNAME(); 


                }
                break;
            case 7 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:59: AGNAME
                {
                mAGNAME(); 


                }
                break;
            case 8 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:66: TRUE
                {
                mTRUE(); 


                }
                break;
            case 9 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:71: IF
                {
                mIF(); 


                }
                break;
            case 10 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:74: THEN
                {
                mTHEN(); 


                }
                break;
            case 11 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:79: BELIEVE
                {
                mBELIEVE(); 


                }
                break;
            case 12 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:87: HAVEGOAL
                {
                mHAVEGOAL(); 


                }
                break;
            case 13 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:96: IN_CONTENT
                {
                mIN_CONTENT(); 


                }
                break;
            case 14 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:107: IN_CONTEXT
                {
                mIN_CONTEXT(); 


                }
                break;
            case 15 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:118: AND
                {
                mAND(); 


                }
                break;
            case 16 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:122: NUMMARKER
                {
                mNUMMARKER(); 


                }
                break;
            case 17 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:132: BRULEARROW
                {
                mBRULEARROW(); 


                }
                break;
            case 18 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:143: BRULES
                {
                mBRULES(); 


                }
                break;
            case 19 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:150: DEL
                {
                mDEL(); 


                }
                break;
            case 20 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:154: ADOPT
                {
                mADOPT(); 


                }
                break;
            case 21 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:160: CLOSEKEY
                {
                mCLOSEKEY(); 


                }
                break;
            case 22 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:169: SEND
                {
                mSEND(); 


                }
                break;
            case 23 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:174: DROP
                {
                mDROP(); 


                }
                break;
            case 24 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:179: INS
                {
                mINS(); 


                }
                break;
            case 25 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:183: CONTENT
                {
                mCONTENT(); 


                }
                break;
            case 26 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:191: CONTEXT
                {
                mCONTEXT(); 


                }
                break;
            case 27 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:199: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 28 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:207: LINE_COMMENT
                {
                mLINE_COMMENT(); 


                }
                break;
            case 29 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:220: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 30 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:228: WS
                {
                mWS(); 


                }
                break;
            case 31 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:231: OPEN
                {
                mOPEN(); 


                }
                break;
            case 32 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:236: CLOSE
                {
                mCLOSE(); 


                }
                break;
            case 33 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:242: SQOPEN
                {
                mSQOPEN(); 


                }
                break;
            case 34 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:249: SQCLOSE
                {
                mSQCLOSE(); 


                }
                break;
            case 35 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:257: CURLYOPEN
                {
                mCURLYOPEN(); 


                }
                break;
            case 36 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:267: CURLYCLOSE
                {
                mCURLYCLOSE(); 


                }
                break;
            case 37 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:278: DOUBLEQUOTE
                {
                mDOUBLEQUOTE(); 


                }
                break;
            case 38 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:290: NOT
                {
                mNOT(); 


                }
                break;
            case 39 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:294: STRING
                {
                mSTRING(); 


                }
                break;
            case 40 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:301: CONST
                {
                mCONST(); 


                }
                break;
            case 41 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:307: VAR
                {
                mVAR(); 


                }
                break;
            case 42 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:311: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 43 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:318: ANON_VAR
                {
                mANON_VAR(); 


                }
                break;
            case 44 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:327: LESS
                {
                mLESS(); 


                }
                break;
            case 45 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:332: EQ
                {
                mEQ(); 


                }
                break;
            case 46 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:335: POINT
                {
                mPOINT(); 


                }
                break;
            case 47 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:341: MULT
                {
                mMULT(); 


                }
                break;
            case 48 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:346: PLUS
                {
                mPLUS(); 


                }
                break;
            case 49 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:351: MINUS
                {
                mMINUS(); 


                }
                break;
            case 50 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:357: DIV
                {
                mDIV(); 


                }
                break;
            case 51 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:361: MOD
                {
                mMOD(); 


                }
                break;
            case 52 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:365: SHRIEK
                {
                mSHRIEK(); 


                }
                break;
            case 53 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:372: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 54 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:378: SEMI
                {
                mSEMI(); 


                }
                break;
            case 55 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:383: COLON
                {
                mCOLON(); 


                }
                break;
            case 56 :
                // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:1:389: QUERY
                {
                mQUERY(); 


                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\1\uffff\1\62\1\64\1\67\2\72\1\75\1\76\1\77\1\uffff\1\100\6\72\1"+
        "\113\12\uffff\1\72\1\67\1\114\24\uffff\1\67\1\uffff\2\67\1\uffff"+
        "\1\122\1\72\1\uffff\2\72\5\uffff\5\72\1\140\1\141\4\uffff\1\114"+
        "\1\67\2\uffff\1\67\1\uffff\1\146\1\uffff\1\72\5\uffff\1\150\4\72"+
        "\3\uffff\1\157\1\160\2\uffff\1\162\1\uffff\1\164\2\72\1\167\10\uffff"+
        "\1\174\1\175\12\uffff";
    static final String DFA10_eofS =
        "\u0081\uffff";
    static final String DFA10_minS =
        "\1\11\1\55\7\60\1\uffff\7\60\1\52\12\uffff\3\60\24\uffff\1\60\1"+
        "\0\2\60\1\0\2\60\1\0\2\60\4\0\1\uffff\7\60\3\uffff\1\0\2\60\2\uffff"+
        "\1\60\1\0\1\60\1\uffff\1\60\5\uffff\5\60\2\0\1\uffff\2\60\1\uffff"+
        "\1\0\1\60\1\0\4\60\2\uffff\2\0\1\uffff\1\0\1\uffff\1\0\2\60\1\0"+
        "\4\uffff\2\0\3\uffff";
    static final String DFA10_maxS =
        "\1\176\1\156\7\172\1\uffff\7\172\1\57\12\uffff\3\172\24\uffff\1"+
        "\172\1\0\2\172\1\0\2\172\1\0\2\172\4\0\1\uffff\7\172\3\uffff\1\0"+
        "\2\172\2\uffff\1\172\1\0\1\172\1\uffff\1\172\5\uffff\5\172\2\0\1"+
        "\uffff\2\172\1\uffff\1\0\1\172\1\0\4\172\2\uffff\2\0\1\uffff\1\0"+
        "\1\uffff\1\0\2\172\1\0\4\uffff\2\0\3\uffff";
    static final String DFA10_acceptS =
        "\11\uffff\1\17\10\uffff\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
        "\1\45\1\46\3\uffff\1\54\1\55\1\56\1\57\1\60\1\61\1\63\1\64\1\65"+
        "\1\66\1\70\1\1\1\2\1\3\1\4\1\6\1\7\1\21\1\22\1\67\16\uffff\1\47"+
        "\7\uffff\1\33\1\34\1\62\3\uffff\1\14\1\51\3\uffff\1\50\1\uffff\1"+
        "\13\1\15\1\16\1\20\1\53\7\uffff\1\52\2\uffff\1\11\7\uffff\1\31\1"+
        "\32\2\uffff\1\30\1\uffff\1\23\4\uffff\1\5\1\10\1\12\1\27\2\uffff"+
        "\1\26\1\24\1\25";
    static final String DFA10_specialS =
        "\1\40\1\uffff\1\26\1\1\1\0\1\20\1\73\1\103\1\106\1\uffff\1\72\1"+
        "\102\1\4\1\6\1\11\1\15\1\100\13\uffff\1\105\1\71\1\41\24\uffff\1"+
        "\75\1\55\1\5\1\66\1\21\1\12\1\27\1\33\1\101\1\76\1\47\1\54\1\53"+
        "\1\60\1\uffff\1\45\1\23\1\34\1\42\1\30\1\2\1\7\3\uffff\1\22\1\13"+
        "\1\74\2\uffff\1\64\1\52\1\14\1\uffff\1\77\5\uffff\1\31\1\25\1\36"+
        "\1\43\1\32\1\67\1\70\1\uffff\1\17\1\104\1\uffff\1\61\1\3\1\57\1"+
        "\10\1\37\1\44\1\24\2\uffff\1\46\1\51\1\uffff\1\50\1\uffff\1\62\1"+
        "\35\1\16\1\63\4\uffff\1\56\1\65\3\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\23\1\22\2\uffff\1\22\22\uffff\1\23\1\46\1\32\2\uffff\1\45"+
            "\1\11\1\uffff\1\24\1\25\1\42\1\43\1\47\1\44\1\41\1\21\12\36"+
            "\1\1\1\50\1\37\1\40\1\uffff\1\51\1\uffff\1\35\1\6\4\35\1\2\6"+
            "\35\1\7\5\35\1\3\3\35\1\10\2\35\1\26\1\uffff\1\27\1\uffff\1"+
            "\12\1\uffff\1\14\1\34\1\15\1\13\4\34\1\4\4\34\1\17\4\34\1\16"+
            "\1\5\3\34\1\20\2\34\1\30\1\uffff\1\31\1\33",
            "\1\60\23\uffff\1\54\1\61\1\55\36\uffff\1\53\4\uffff\1\52\5"+
            "\uffff\1\57\1\56",
            "\12\65\7\uffff\16\65\1\63\13\65\4\uffff\1\65\1\uffff\32\65",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\66\10\65",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\5\73\1\70\7\73\1"+
            "\71\14\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\7\73\1\74\22\73",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\4\73\1\102\14\73"+
            "\1\103\10\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\3\73\1\104\26\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\13\73\1\105\16\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\4\73\1\106\25\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\23\73\1\107\6\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\23\73\1\110\6\73",
            "\1\111\4\uffff\1\112",
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
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\32\73",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\12\115\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\65\7\uffff\1\116\31\65\4\uffff\1\65\1\uffff\32\65",
            "\1\uffff",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\24\65\1\121\5\65",
            "\1\uffff",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\32\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\22\73\1\123\7\73",
            "\1\uffff",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\32\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\4\73\1\125\25\73",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\13\73\1\133\16\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\16\73\1\134\13\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\16\73\1\135\13\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\16\73\1\136\13\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\15\73\1\137\14\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\32\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\32\73",
            "",
            "",
            "",
            "\1\uffff",
            "\12\115\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
            "\12\65\7\uffff\13\65\1\143\16\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\144\25\65",
            "\1\uffff",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\32\73",
            "",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\15\73\1\147\14\73",
            "",
            "",
            "",
            "",
            "",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\32\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\17\73\1\151\12\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\17\73\1\152\12\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\22\73\1\153\7\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\3\73\1\154\26\73",
            "\1\uffff",
            "\1\uffff",
            "",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\uffff",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\32\73",
            "\1\uffff",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\32\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\23\73\1\165\6\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\4\73\1\166\25\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\32\73",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\32\73",
            "\12\73\7\uffff\32\73\4\uffff\1\73\1\uffff\32\73",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( GOALS | BELIEFS | CAPABILITIES | CONDACTIONS | GOAL | NAME | AGNAME | TRUE | IF | THEN | BELIEVE | HAVEGOAL | IN_CONTENT | IN_CONTEXT | AND | NUMMARKER | BRULEARROW | BRULES | DEL | ADOPT | CLOSEKEY | SEND | DROP | INS | CONTENT | CONTEXT | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | ANON_VAR | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_4 = input.LA(1);

                         
                        int index10_4 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_4=='f') && (((condaction)||(stringterm)||(!stringterm)))) {s = 56;}

                        else if ( (LA10_4=='n') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 57;}

                        else if ( ((LA10_4 >= '0' && LA10_4 <= '9')||(LA10_4 >= 'A' && LA10_4 <= 'Z')||LA10_4=='_'||(LA10_4 >= 'a' && LA10_4 <= 'e')||(LA10_4 >= 'g' && LA10_4 <= 'm')||(LA10_4 >= 'o' && LA10_4 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_4);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA10_3 = input.LA(1);

                         
                        int index10_3 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_3=='r') ) {s = 54;}

                        else if ( ((LA10_3 >= '0' && LA10_3 <= '9')||(LA10_3 >= 'A' && LA10_3 <= 'Z')||LA10_3=='_'||(LA10_3 >= 'a' && LA10_3 <= 'q')||(LA10_3 >= 's' && LA10_3 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 53;}

                        else s = 55;

                         
                        input.seek(index10_3);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA10_71 = input.LA(1);

                         
                        int index10_71 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_71 >= '0' && LA10_71 <= '9')||(LA10_71 >= 'A' && LA10_71 <= 'Z')||LA10_71=='_'||(LA10_71 >= 'a' && LA10_71 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 96;

                         
                        input.seek(index10_71);

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA10_103 = input.LA(1);

                         
                        int index10_103 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_103 >= '0' && LA10_103 <= '9')||(LA10_103 >= 'A' && LA10_103 <= 'Z')||LA10_103=='_'||(LA10_103 >= 'a' && LA10_103 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 114;

                         
                        input.seek(index10_103);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA10_12 = input.LA(1);

                         
                        int index10_12 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_12=='d') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 68;}

                        else if ( ((LA10_12 >= '0' && LA10_12 <= '9')||(LA10_12 >= 'A' && LA10_12 <= 'Z')||LA10_12=='_'||(LA10_12 >= 'a' && LA10_12 <= 'c')||(LA10_12 >= 'e' && LA10_12 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_12);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA10_53 = input.LA(1);

                         
                        int index10_53 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_53 >= '0' && LA10_53 <= '9')||(LA10_53 >= 'A' && LA10_53 <= 'Z')||LA10_53=='_'||(LA10_53 >= 'a' && LA10_53 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 53;}

                        else s = 55;

                         
                        input.seek(index10_53);

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA10_13 = input.LA(1);

                         
                        int index10_13 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_13=='l') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 69;}

                        else if ( ((LA10_13 >= '0' && LA10_13 <= '9')||(LA10_13 >= 'A' && LA10_13 <= 'Z')||LA10_13=='_'||(LA10_13 >= 'a' && LA10_13 <= 'k')||(LA10_13 >= 'm' && LA10_13 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_13);

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA10_72 = input.LA(1);

                         
                        int index10_72 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_72 >= '0' && LA10_72 <= '9')||(LA10_72 >= 'A' && LA10_72 <= 'Z')||LA10_72=='_'||(LA10_72 >= 'a' && LA10_72 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 97;

                         
                        input.seek(index10_72);

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA10_105 = input.LA(1);

                         
                        int index10_105 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_105 >= '0' && LA10_105 <= '9')||(LA10_105 >= 'A' && LA10_105 <= 'Z')||LA10_105=='_'||(LA10_105 >= 'a' && LA10_105 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 116;

                         
                        input.seek(index10_105);

                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA10_14 = input.LA(1);

                         
                        int index10_14 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_14=='e') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 70;}

                        else if ( ((LA10_14 >= '0' && LA10_14 <= '9')||(LA10_14 >= 'A' && LA10_14 <= 'Z')||LA10_14=='_'||(LA10_14 >= 'a' && LA10_14 <= 'd')||(LA10_14 >= 'f' && LA10_14 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_14);

                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA10_56 = input.LA(1);

                         
                        int index10_56 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_56 >= '0' && LA10_56 <= '9')||(LA10_56 >= 'A' && LA10_56 <= 'Z')||LA10_56=='_'||(LA10_56 >= 'a' && LA10_56 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 82;

                         
                        input.seek(index10_56);

                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA10_77 = input.LA(1);

                         
                        int index10_77 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_77 >= '0' && LA10_77 <= '9')) && (((!stringterm)||(stringterm)))) {s = 77;}

                        else if ( ((LA10_77 >= 'A' && LA10_77 <= 'Z')||LA10_77=='_'||(LA10_77 >= 'a' && LA10_77 <= 'z')) && ((stringterm))) {s = 65;}

                        else s = 76;

                         
                        input.seek(index10_77);

                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA10_83 = input.LA(1);

                         
                        int index10_83 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_83 >= '0' && LA10_83 <= '9')||(LA10_83 >= 'A' && LA10_83 <= 'Z')||LA10_83=='_'||(LA10_83 >= 'a' && LA10_83 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 102;

                         
                        input.seek(index10_83);

                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA10_15 = input.LA(1);

                         
                        int index10_15 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_15=='t') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 71;}

                        else if ( ((LA10_15 >= '0' && LA10_15 <= '9')||(LA10_15 >= 'A' && LA10_15 <= 'Z')||LA10_15=='_'||(LA10_15 >= 'a' && LA10_15 <= 's')||(LA10_15 >= 'u' && LA10_15 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_15);

                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA10_118 = input.LA(1);

                         
                        int index10_118 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_118 >= '0' && LA10_118 <= '9')||(LA10_118 >= 'A' && LA10_118 <= 'Z')||LA10_118=='_'||(LA10_118 >= 'a' && LA10_118 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 125;

                         
                        input.seek(index10_118);

                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA10_99 = input.LA(1);

                         
                        int index10_99 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_99 >= '0' && LA10_99 <= '9')||(LA10_99 >= 'A' && LA10_99 <= 'Z')||LA10_99=='_'||(LA10_99 >= 'a' && LA10_99 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 53;}

                        else s = 111;

                         
                        input.seek(index10_99);

                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA10_5 = input.LA(1);

                         
                        int index10_5 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_5=='h') && (((condaction)||(!stringterm)||(stringterm)))) {s = 60;}

                        else if ( ((LA10_5 >= '0' && LA10_5 <= '9')||(LA10_5 >= 'A' && LA10_5 <= 'Z')||LA10_5=='_'||(LA10_5 >= 'a' && LA10_5 <= 'g')||(LA10_5 >= 'i' && LA10_5 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_5);

                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA10_55 = input.LA(1);

                         
                        int index10_55 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index10_55);

                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA10_76 = input.LA(1);

                         
                        int index10_76 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 98;}

                         
                        input.seek(index10_76);

                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA10_67 = input.LA(1);

                         
                        int index10_67 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_67=='o') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 92;}

                        else if ( ((LA10_67 >= '0' && LA10_67 <= '9')||(LA10_67 >= 'A' && LA10_67 <= 'Z')||LA10_67=='_'||(LA10_67 >= 'a' && LA10_67 <= 'n')||(LA10_67 >= 'p' && LA10_67 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_67);

                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA10_108 = input.LA(1);

                         
                        int index10_108 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_108 >= '0' && LA10_108 <= '9')||(LA10_108 >= 'A' && LA10_108 <= 'Z')||LA10_108=='_'||(LA10_108 >= 'a' && LA10_108 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 119;

                         
                        input.seek(index10_108);

                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA10_92 = input.LA(1);

                         
                        int index10_92 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_92=='p') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 105;}

                        else if ( ((LA10_92 >= '0' && LA10_92 <= '9')||(LA10_92 >= 'A' && LA10_92 <= 'Z')||LA10_92=='_'||(LA10_92 >= 'a' && LA10_92 <= 'o')||(LA10_92 >= 'q' && LA10_92 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_92);

                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA10_2 = input.LA(1);

                         
                        int index10_2 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_2=='O') && (((start)||(!stringterm)||(stringterm)))) {s = 51;}

                        else if ( ((LA10_2 >= '0' && LA10_2 <= '9')||(LA10_2 >= 'A' && LA10_2 <= 'N')||(LA10_2 >= 'P' && LA10_2 <= 'Z')||LA10_2=='_'||(LA10_2 >= 'a' && LA10_2 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 53;}

                        else s = 52;

                         
                        input.seek(index10_2);

                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA10_57 = input.LA(1);

                         
                        int index10_57 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_57=='s') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 83;}

                        else if ( ((LA10_57 >= '0' && LA10_57 <= '9')||(LA10_57 >= 'A' && LA10_57 <= 'Z')||LA10_57=='_'||(LA10_57 >= 'a' && LA10_57 <= 'r')||(LA10_57 >= 't' && LA10_57 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_57);

                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA10_70 = input.LA(1);

                         
                        int index10_70 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_70=='n') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 95;}

                        else if ( ((LA10_70 >= '0' && LA10_70 <= '9')||(LA10_70 >= 'A' && LA10_70 <= 'Z')||LA10_70=='_'||(LA10_70 >= 'a' && LA10_70 <= 'm')||(LA10_70 >= 'o' && LA10_70 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_70);

                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA10_91 = input.LA(1);

                         
                        int index10_91 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_91 >= '0' && LA10_91 <= '9')||(LA10_91 >= 'A' && LA10_91 <= 'Z')||LA10_91=='_'||(LA10_91 >= 'a' && LA10_91 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 104;

                         
                        input.seek(index10_91);

                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA10_95 = input.LA(1);

                         
                        int index10_95 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_95=='d') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 108;}

                        else if ( ((LA10_95 >= '0' && LA10_95 <= '9')||(LA10_95 >= 'A' && LA10_95 <= 'Z')||LA10_95=='_'||(LA10_95 >= 'a' && LA10_95 <= 'c')||(LA10_95 >= 'e' && LA10_95 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_95);

                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA10_58 = input.LA(1);

                         
                        int index10_58 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 84;}

                         
                        input.seek(index10_58);

                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA10_68 = input.LA(1);

                         
                        int index10_68 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_68=='o') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 93;}

                        else if ( ((LA10_68 >= '0' && LA10_68 <= '9')||(LA10_68 >= 'A' && LA10_68 <= 'Z')||LA10_68=='_'||(LA10_68 >= 'a' && LA10_68 <= 'n')||(LA10_68 >= 'p' && LA10_68 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_68);

                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA10_117 = input.LA(1);

                         
                        int index10_117 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_117 >= '0' && LA10_117 <= '9')||(LA10_117 >= 'A' && LA10_117 <= 'Z')||LA10_117=='_'||(LA10_117 >= 'a' && LA10_117 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 124;

                         
                        input.seek(index10_117);

                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA10_93 = input.LA(1);

                         
                        int index10_93 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_93=='p') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 106;}

                        else if ( ((LA10_93 >= '0' && LA10_93 <= '9')||(LA10_93 >= 'A' && LA10_93 <= 'Z')||LA10_93=='_'||(LA10_93 >= 'a' && LA10_93 <= 'o')||(LA10_93 >= 'q' && LA10_93 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_93);

                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA10_106 = input.LA(1);

                         
                        int index10_106 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_106=='t') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 117;}

                        else if ( ((LA10_106 >= '0' && LA10_106 <= '9')||(LA10_106 >= 'A' && LA10_106 <= 'Z')||LA10_106=='_'||(LA10_106 >= 'a' && LA10_106 <= 's')||(LA10_106 >= 'u' && LA10_106 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_106);

                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA10_0 = input.LA(1);

                         
                        int index10_0 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_0==':') ) {s = 1;}

                        else if ( (LA10_0=='G') && (((start)||(!stringterm)||(stringterm)||((preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0))))) {s = 2;}

                        else if ( (LA10_0=='T') ) {s = 3;}

                        else if ( (LA10_0=='i') && (((condaction)||(!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 4;}

                        else if ( (LA10_0=='t') && (((condaction)||(!stringterm)||(stringterm)))) {s = 5;}

                        else if ( (LA10_0=='B') && (((!stringterm)||(stringterm)||((preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0))))) {s = 6;}

                        else if ( (LA10_0=='N') && (((!stringterm)||(stringterm)||((preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0))))) {s = 7;}

                        else if ( (LA10_0=='X') && (((!stringterm)||(stringterm)||((preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0))))) {s = 8;}

                        else if ( (LA10_0=='&') ) {s = 9;}

                        else if ( (LA10_0=='_') ) {s = 10;}

                        else if ( (LA10_0=='d') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 11;}

                        else if ( (LA10_0=='a') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 12;}

                        else if ( (LA10_0=='c') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 13;}

                        else if ( (LA10_0=='s') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 14;}

                        else if ( (LA10_0=='n') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 15;}

                        else if ( (LA10_0=='x') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 16;}

                        else if ( (LA10_0=='/') ) {s = 17;}

                        else if ( (LA10_0=='\n'||LA10_0=='\r') ) {s = 18;}

                        else if ( (LA10_0=='\t'||LA10_0==' ') ) {s = 19;}

                        else if ( (LA10_0=='(') ) {s = 20;}

                        else if ( (LA10_0==')') ) {s = 21;}

                        else if ( (LA10_0=='[') ) {s = 22;}

                        else if ( (LA10_0==']') ) {s = 23;}

                        else if ( (LA10_0=='{') ) {s = 24;}

                        else if ( (LA10_0=='}') ) {s = 25;}

                        else if ( (LA10_0=='\"') ) {s = 26;}

                        else if ( (LA10_0=='~') ) {s = 27;}

                        else if ( (LA10_0=='b'||(LA10_0 >= 'e' && LA10_0 <= 'h')||(LA10_0 >= 'j' && LA10_0 <= 'm')||(LA10_0 >= 'o' && LA10_0 <= 'r')||(LA10_0 >= 'u' && LA10_0 <= 'w')||(LA10_0 >= 'y' && LA10_0 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 28;}

                        else if ( (LA10_0=='A'||(LA10_0 >= 'C' && LA10_0 <= 'F')||(LA10_0 >= 'H' && LA10_0 <= 'M')||(LA10_0 >= 'O' && LA10_0 <= 'S')||(LA10_0 >= 'U' && LA10_0 <= 'W')||(LA10_0 >= 'Y' && LA10_0 <= 'Z')) && (((!stringterm)||(stringterm)))) {s = 29;}

                        else if ( ((LA10_0 >= '0' && LA10_0 <= '9')) && (((!stringterm)||(stringterm)))) {s = 30;}

                        else if ( (LA10_0=='<') ) {s = 31;}

                        else if ( (LA10_0=='=') ) {s = 32;}

                        else if ( (LA10_0=='.') ) {s = 33;}

                        else if ( (LA10_0=='*') ) {s = 34;}

                        else if ( (LA10_0=='+') ) {s = 35;}

                        else if ( (LA10_0=='-') ) {s = 36;}

                        else if ( (LA10_0=='%') ) {s = 37;}

                        else if ( (LA10_0=='!') ) {s = 38;}

                        else if ( (LA10_0==',') ) {s = 39;}

                        else if ( (LA10_0==';') ) {s = 40;}

                        else if ( (LA10_0=='?') ) {s = 41;}

                         
                        input.seek(index10_0);

                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA10_30 = input.LA(1);

                         
                        int index10_30 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_30 >= '0' && LA10_30 <= '9')) && (((!stringterm)||(stringterm)))) {s = 77;}

                        else if ( ((LA10_30 >= 'A' && LA10_30 <= 'Z')||LA10_30=='_'||(LA10_30 >= 'a' && LA10_30 <= 'z')) && ((stringterm))) {s = 65;}

                        else s = 76;

                         
                        input.seek(index10_30);

                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA10_69 = input.LA(1);

                         
                        int index10_69 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_69=='o') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 94;}

                        else if ( ((LA10_69 >= '0' && LA10_69 <= '9')||(LA10_69 >= 'A' && LA10_69 <= 'Z')||LA10_69=='_'||(LA10_69 >= 'a' && LA10_69 <= 'n')||(LA10_69 >= 'p' && LA10_69 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_69);

                        if ( s>=0 ) return s;
                        break;

                    case 35 : 
                        int LA10_94 = input.LA(1);

                         
                        int index10_94 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_94=='s') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 107;}

                        else if ( ((LA10_94 >= '0' && LA10_94 <= '9')||(LA10_94 >= 'A' && LA10_94 <= 'Z')||LA10_94=='_'||(LA10_94 >= 'a' && LA10_94 <= 'r')||(LA10_94 >= 't' && LA10_94 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_94);

                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA10_107 = input.LA(1);

                         
                        int index10_107 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_107=='e') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 118;}

                        else if ( ((LA10_107 >= '0' && LA10_107 <= '9')||(LA10_107 >= 'A' && LA10_107 <= 'Z')||LA10_107=='_'||(LA10_107 >= 'a' && LA10_107 <= 'd')||(LA10_107 >= 'f' && LA10_107 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_107);

                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA10_66 = input.LA(1);

                         
                        int index10_66 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_66=='l') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 91;}

                        else if ( ((LA10_66 >= '0' && LA10_66 <= '9')||(LA10_66 >= 'A' && LA10_66 <= 'Z')||LA10_66=='_'||(LA10_66 >= 'a' && LA10_66 <= 'k')||(LA10_66 >= 'm' && LA10_66 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_66);

                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA10_111 = input.LA(1);

                         
                        int index10_111 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((start)) ) {s = 120;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index10_111);

                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA10_61 = input.LA(1);

                         
                        int index10_61 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0))) ) {s = 86;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index10_61);

                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA10_114 = input.LA(1);

                         
                        int index10_114 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((condaction)) ) {s = 122;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 84;}

                         
                        input.seek(index10_114);

                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA10_112 = input.LA(1);

                         
                        int index10_112 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((((!stringterm)||(stringterm))))) ) {s = 121;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index10_112);

                        if ( s>=0 ) return s;
                        break;

                    case 42 : 
                        int LA10_82 = input.LA(1);

                         
                        int index10_82 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((condaction)) ) {s = 101;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 84;}

                         
                        input.seek(index10_82);

                        if ( s>=0 ) return s;
                        break;

                    case 43 : 
                        int LA10_63 = input.LA(1);

                         
                        int index10_63 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0))) ) {s = 88;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index10_63);

                        if ( s>=0 ) return s;
                        break;

                    case 44 : 
                        int LA10_62 = input.LA(1);

                         
                        int index10_62 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0))) ) {s = 87;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index10_62);

                        if ( s>=0 ) return s;
                        break;

                    case 45 : 
                        int LA10_52 = input.LA(1);

                         
                        int index10_52 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0))) ) {s = 79;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 80;}

                         
                        input.seek(index10_52);

                        if ( s>=0 ) return s;
                        break;

                    case 46 : 
                        int LA10_124 = input.LA(1);

                         
                        int index10_124 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {s = 127;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 84;}

                         
                        input.seek(index10_124);

                        if ( s>=0 ) return s;
                        break;

                    case 47 : 
                        int LA10_104 = input.LA(1);

                         
                        int index10_104 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {s = 115;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 84;}

                         
                        input.seek(index10_104);

                        if ( s>=0 ) return s;
                        break;

                    case 48 : 
                        int LA10_64 = input.LA(1);

                         
                        int index10_64 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((((!stringterm)||(stringterm))))) ) {s = 89;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 90;}

                         
                        input.seek(index10_64);

                        if ( s>=0 ) return s;
                        break;

                    case 49 : 
                        int LA10_102 = input.LA(1);

                         
                        int index10_102 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {s = 113;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 84;}

                         
                        input.seek(index10_102);

                        if ( s>=0 ) return s;
                        break;

                    case 50 : 
                        int LA10_116 = input.LA(1);

                         
                        int index10_116 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {s = 123;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 84;}

                         
                        input.seek(index10_116);

                        if ( s>=0 ) return s;
                        break;

                    case 51 : 
                        int LA10_119 = input.LA(1);

                         
                        int index10_119 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {s = 126;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 84;}

                         
                        input.seek(index10_119);

                        if ( s>=0 ) return s;
                        break;

                    case 52 : 
                        int LA10_81 = input.LA(1);

                         
                        int index10_81 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_81=='e') ) {s = 100;}

                        else if ( ((LA10_81 >= '0' && LA10_81 <= '9')||(LA10_81 >= 'A' && LA10_81 <= 'Z')||LA10_81=='_'||(LA10_81 >= 'a' && LA10_81 <= 'd')||(LA10_81 >= 'f' && LA10_81 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 53;}

                        else s = 55;

                         
                        input.seek(index10_81);

                        if ( s>=0 ) return s;
                        break;

                    case 53 : 
                        int LA10_125 = input.LA(1);

                         
                        int index10_125 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {s = 128;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 84;}

                         
                        input.seek(index10_125);

                        if ( s>=0 ) return s;
                        break;

                    case 54 : 
                        int LA10_54 = input.LA(1);

                         
                        int index10_54 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_54=='u') ) {s = 81;}

                        else if ( ((LA10_54 >= '0' && LA10_54 <= '9')||(LA10_54 >= 'A' && LA10_54 <= 'Z')||LA10_54=='_'||(LA10_54 >= 'a' && LA10_54 <= 't')||(LA10_54 >= 'v' && LA10_54 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 53;}

                        else s = 55;

                         
                        input.seek(index10_54);

                        if ( s>=0 ) return s;
                        break;

                    case 55 : 
                        int LA10_96 = input.LA(1);

                         
                        int index10_96 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {s = 109;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 84;}

                         
                        input.seek(index10_96);

                        if ( s>=0 ) return s;
                        break;

                    case 56 : 
                        int LA10_97 = input.LA(1);

                         
                        int index10_97 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((condaction==true && preconditiontypemode==false && plain_nesting==0))) ) {s = 110;}

                        else if ( ((stringterm)) ) {s = 65;}

                        else if ( ((!stringterm)) ) {s = 84;}

                         
                        input.seek(index10_97);

                        if ( s>=0 ) return s;
                        break;

                    case 57 : 
                        int LA10_29 = input.LA(1);

                         
                        int index10_29 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_29 >= '0' && LA10_29 <= '9')||(LA10_29 >= 'A' && LA10_29 <= 'Z')||LA10_29=='_'||(LA10_29 >= 'a' && LA10_29 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 53;}

                        else s = 55;

                         
                        input.seek(index10_29);

                        if ( s>=0 ) return s;
                        break;

                    case 58 : 
                        int LA10_10 = input.LA(1);

                         
                        int index10_10 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_10 >= '0' && LA10_10 <= '9')||(LA10_10 >= 'A' && LA10_10 <= 'Z')||LA10_10=='_'||(LA10_10 >= 'a' && LA10_10 <= 'z')) && ((stringterm))) {s = 65;}

                        else s = 64;

                         
                        input.seek(index10_10);

                        if ( s>=0 ) return s;
                        break;

                    case 59 : 
                        int LA10_6 = input.LA(1);

                         
                        int index10_6 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_6 >= '0' && LA10_6 <= '9')||(LA10_6 >= 'A' && LA10_6 <= 'Z')||LA10_6=='_'||(LA10_6 >= 'a' && LA10_6 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 53;}

                        else s = 61;

                         
                        input.seek(index10_6);

                        if ( s>=0 ) return s;
                        break;

                    case 60 : 
                        int LA10_78 = input.LA(1);

                         
                        int index10_78 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_78=='L') && (((start)||(stringterm)||(!stringterm)))) {s = 99;}

                        else if ( ((LA10_78 >= '0' && LA10_78 <= '9')||(LA10_78 >= 'A' && LA10_78 <= 'K')||(LA10_78 >= 'M' && LA10_78 <= 'Z')||LA10_78=='_'||(LA10_78 >= 'a' && LA10_78 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 53;}

                        else s = 55;

                         
                        input.seek(index10_78);

                        if ( s>=0 ) return s;
                        break;

                    case 61 : 
                        int LA10_51 = input.LA(1);

                         
                        int index10_51 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_51=='A') && (((start)||(!stringterm)||(stringterm)))) {s = 78;}

                        else if ( ((LA10_51 >= '0' && LA10_51 <= '9')||(LA10_51 >= 'B' && LA10_51 <= 'Z')||LA10_51=='_'||(LA10_51 >= 'a' && LA10_51 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 53;}

                        else s = 55;

                         
                        input.seek(index10_51);

                        if ( s>=0 ) return s;
                        break;

                    case 62 : 
                        int LA10_60 = input.LA(1);

                         
                        int index10_60 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_60=='e') && (((condaction)||(!stringterm)||(stringterm)))) {s = 85;}

                        else if ( ((LA10_60 >= '0' && LA10_60 <= '9')||(LA10_60 >= 'A' && LA10_60 <= 'Z')||LA10_60=='_'||(LA10_60 >= 'a' && LA10_60 <= 'd')||(LA10_60 >= 'f' && LA10_60 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_60);

                        if ( s>=0 ) return s;
                        break;

                    case 63 : 
                        int LA10_85 = input.LA(1);

                         
                        int index10_85 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_85=='n') && (((condaction)||(stringterm)||(!stringterm)))) {s = 103;}

                        else if ( ((LA10_85 >= '0' && LA10_85 <= '9')||(LA10_85 >= 'A' && LA10_85 <= 'Z')||LA10_85=='_'||(LA10_85 >= 'a' && LA10_85 <= 'm')||(LA10_85 >= 'o' && LA10_85 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_85);

                        if ( s>=0 ) return s;
                        break;

                    case 64 : 
                        int LA10_16 = input.LA(1);

                         
                        int index10_16 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_16=='t') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 72;}

                        else if ( ((LA10_16 >= '0' && LA10_16 <= '9')||(LA10_16 >= 'A' && LA10_16 <= 'Z')||LA10_16=='_'||(LA10_16 >= 'a' && LA10_16 <= 's')||(LA10_16 >= 'u' && LA10_16 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_16);

                        if ( s>=0 ) return s;
                        break;

                    case 65 : 
                        int LA10_59 = input.LA(1);

                         
                        int index10_59 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_59 >= '0' && LA10_59 <= '9')||(LA10_59 >= 'A' && LA10_59 <= 'Z')||LA10_59=='_'||(LA10_59 >= 'a' && LA10_59 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_59);

                        if ( s>=0 ) return s;
                        break;

                    case 66 : 
                        int LA10_11 = input.LA(1);

                         
                        int index10_11 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_11=='e') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 66;}

                        else if ( (LA10_11=='r') && (((!stringterm)||(stringterm)||((condaction==true && preconditiontypemode==false && plain_nesting==0))))) {s = 67;}

                        else if ( ((LA10_11 >= '0' && LA10_11 <= '9')||(LA10_11 >= 'A' && LA10_11 <= 'Z')||LA10_11=='_'||(LA10_11 >= 'a' && LA10_11 <= 'd')||(LA10_11 >= 'f' && LA10_11 <= 'q')||(LA10_11 >= 's' && LA10_11 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_11);

                        if ( s>=0 ) return s;
                        break;

                    case 67 : 
                        int LA10_7 = input.LA(1);

                         
                        int index10_7 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_7 >= '0' && LA10_7 <= '9')||(LA10_7 >= 'A' && LA10_7 <= 'Z')||LA10_7=='_'||(LA10_7 >= 'a' && LA10_7 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 53;}

                        else s = 62;

                         
                        input.seek(index10_7);

                        if ( s>=0 ) return s;
                        break;

                    case 68 : 
                        int LA10_100 = input.LA(1);

                         
                        int index10_100 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_100 >= '0' && LA10_100 <= '9')||(LA10_100 >= 'A' && LA10_100 <= 'Z')||LA10_100=='_'||(LA10_100 >= 'a' && LA10_100 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 53;}

                        else s = 112;

                         
                        input.seek(index10_100);

                        if ( s>=0 ) return s;
                        break;

                    case 69 : 
                        int LA10_28 = input.LA(1);

                         
                        int index10_28 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_28 >= '0' && LA10_28 <= '9')||(LA10_28 >= 'A' && LA10_28 <= 'Z')||LA10_28=='_'||(LA10_28 >= 'a' && LA10_28 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 59;}

                        else s = 58;

                         
                        input.seek(index10_28);

                        if ( s>=0 ) return s;
                        break;

                    case 70 : 
                        int LA10_8 = input.LA(1);

                         
                        int index10_8 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_8 >= '0' && LA10_8 <= '9')||(LA10_8 >= 'A' && LA10_8 <= 'Z')||LA10_8=='_'||(LA10_8 >= 'a' && LA10_8 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 53;}

                        else s = 63;

                         
                        input.seek(index10_8);

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}