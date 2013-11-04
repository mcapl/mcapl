// $ANTLR 3.4 /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2013-11-01 16:17:40

package goal.parser;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class GOALLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ACTIONSPEC=4;
    public static final int ADOPT=5;
    public static final int BAR=6;
    public static final int BEL=7;
    public static final int BELIEFS=8;
    public static final int CLOSE=9;
    public static final int COLON=10;
    public static final int COMMA=11;
    public static final int COMMENT=12;
    public static final int CONST=13;
    public static final int CURLYCLOSE=14;
    public static final int CURLYOPEN=15;
    public static final int DEFINE=16;
    public static final int DELETE=17;
    public static final int DIV=18;
    public static final int DOUBLEQUOTE=19;
    public static final int DROP=20;
    public static final int EQUALS=21;
    public static final int EVENT=22;
    public static final int GOAL=23;
    public static final int GOALS=24;
    public static final int HASH=25;
    public static final int IF=26;
    public static final int INSERT=27;
    public static final int KNOWLEDGE=28;
    public static final int LESS=29;
    public static final int LINEAR=30;
    public static final int LINEARALL=31;
    public static final int LINE_COMMENT=32;
    public static final int MAIN=33;
    public static final int MINUS=34;
    public static final int MODULE=35;
    public static final int MULT=36;
    public static final int NEWLINE=37;
    public static final int NOT=38;
    public static final int NUMBER=39;
    public static final int OPEN=40;
    public static final int ORDER=41;
    public static final int PLUS=42;
    public static final int POST=43;
    public static final int PRE=44;
    public static final int PROGRAM=45;
    public static final int PROLOGARROW=46;
    public static final int RANDOM=47;
    public static final int RANDOMALL=48;
    public static final int SEND=49;
    public static final int SQCLOSE=50;
    public static final int SQOPEN=51;
    public static final int STOP=52;
    public static final int THEN=53;
    public static final int TRUE=54;
    public static final int VAR=55;
    public static final int WS=56;



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
    public String getGrammarFileName() { return "/Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g"; }

    // $ANTLR start "MAIN"
    public final void mMAIN() throws RecognitionException {
        try {
            int _type = MAIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:5: ( 'main' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:7: 'main'
            {
            match("main"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MAIN"

    // $ANTLR start "KNOWLEDGE"
    public final void mKNOWLEDGE() throws RecognitionException {
        try {
            int _type = KNOWLEDGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:10: ( 'knowledge' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:13: 'knowledge'
            {
            match("knowledge"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "KNOWLEDGE"

    // $ANTLR start "BELIEFS"
    public final void mBELIEFS() throws RecognitionException {
        try {
            int _type = BELIEFS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:8: ( 'beliefs' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:10: 'beliefs'
            {
            match("beliefs"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BELIEFS"

    // $ANTLR start "GOALS"
    public final void mGOALS() throws RecognitionException {
        try {
            int _type = GOALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:7: ( 'goals' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:9: 'goals'
            {
            match("goals"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GOALS"

    // $ANTLR start "EVENT"
    public final void mEVENT() throws RecognitionException {
        try {
            int _type = EVENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:131:7: ( 'event' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:131:9: 'event'
            {
            match("event"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EVENT"

    // $ANTLR start "ACTIONSPEC"
    public final void mACTIONSPEC() throws RecognitionException {
        try {
            int _type = ACTIONSPEC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:3: ( 'actionspec' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:5: 'actionspec'
            {
            match("actionspec"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACTIONSPEC"

    // $ANTLR start "MODULE"
    public final void mMODULE() throws RecognitionException {
        try {
            int _type = MODULE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:134:8: ( 'module' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:134:10: 'module'
            {
            match("module"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MODULE"

    // $ANTLR start "PROGRAM"
    public final void mPROGRAM() throws RecognitionException {
        try {
            int _type = PROGRAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:8: ( 'program' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:10: 'program'
            {
            match("program"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PROGRAM"

    // $ANTLR start "PROLOGARROW"
    public final void mPROLOGARROW() throws RecognitionException {
        try {
            int _type = PROLOGARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:137:3: ( ':-' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:137:5: ':-'
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
    // $ANTLR end "PROLOGARROW"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:138:5: ( 'not' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:138:7: 'not'
            {
            match("not"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "ORDER"
    public final void mORDER() throws RecognitionException {
        try {
            int _type = ORDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:139:7: ( 'order' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:139:8: 'order'
            {
            match("order"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ORDER"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:140:8: ( '=' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:140:10: '='
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
    // $ANTLR end "EQUALS"

    // $ANTLR start "LINEAR"
    public final void mLINEAR() throws RecognitionException {
        try {
            int _type = LINEAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:141:8: ( 'linear' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:141:10: 'linear'
            {
            match("linear"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEAR"

    // $ANTLR start "LINEARALL"
    public final void mLINEARALL() throws RecognitionException {
        try {
            int _type = LINEARALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:3: ( 'linearall' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:5: 'linearall'
            {
            match("linearall"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEARALL"

    // $ANTLR start "RANDOM"
    public final void mRANDOM() throws RecognitionException {
        try {
            int _type = RANDOM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:8: ( 'random' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:10: 'random'
            {
            match("random"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RANDOM"

    // $ANTLR start "RANDOMALL"
    public final void mRANDOMALL() throws RecognitionException {
        try {
            int _type = RANDOMALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:146:3: ( 'randomall' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:146:5: 'randomall'
            {
            match("randomall"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RANDOMALL"

    // $ANTLR start "DEFINE"
    public final void mDEFINE() throws RecognitionException {
        try {
            int _type = DEFINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:147:8: ( 'define' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:147:10: 'define'
            {
            match("define"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEFINE"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:4: ( 'if' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:6: 'if'
            {
            match("if"); 



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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:6: ( 'then' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:8: 'then'
            {
            match("then"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:150:6: ( 'true' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:150:8: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "BEL"
    public final void mBEL() throws RecognitionException {
        try {
            int _type = BEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:151:5: ( 'bel' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:151:7: 'bel'
            {
            match("bel"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BEL"

    // $ANTLR start "GOAL"
    public final void mGOAL() throws RecognitionException {
        try {
            int _type = GOAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:6: ( 'a-goal' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:8: 'a-goal'
            {
            match("a-goal"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GOAL"

    // $ANTLR start "PRE"
    public final void mPRE() throws RecognitionException {
        try {
            int _type = PRE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:5: ( 'pre' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:7: 'pre'
            {
            match("pre"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PRE"

    // $ANTLR start "POST"
    public final void mPOST() throws RecognitionException {
        try {
            int _type = POST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:6: ( 'post' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:8: 'post'
            {
            match("post"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "POST"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:155:6: ( '+' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:155:8: '+'
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

    // $ANTLR start "INSERT"
    public final void mINSERT() throws RecognitionException {
        try {
            int _type = INSERT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:156:8: ( 'insert' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:156:10: 'insert'
            {
            match("insert"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INSERT"

    // $ANTLR start "DELETE"
    public final void mDELETE() throws RecognitionException {
        try {
            int _type = DELETE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:157:8: ( 'delete' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:157:10: 'delete'
            {
            match("delete"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DELETE"

    // $ANTLR start "ADOPT"
    public final void mADOPT() throws RecognitionException {
        try {
            int _type = ADOPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:158:7: ( 'adopt' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:158:9: 'adopt'
            {
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

    // $ANTLR start "DROP"
    public final void mDROP() throws RecognitionException {
        try {
            int _type = DROP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:159:6: ( 'drop' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:159:8: 'drop'
            {
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

    // $ANTLR start "SEND"
    public final void mSEND() throws RecognitionException {
        try {
            int _type = SEND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:6: ( 'send' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:8: 'send'
            {
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

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:7: ( ':' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:9: ':'
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

    // $ANTLR start "CURLYOPEN"
    public final void mCURLYOPEN() throws RecognitionException {
        try {
            int _type = CURLYOPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:204:10: ( '{' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:204:12: '{'
            {
            match('{'); 

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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:2: ( '}' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:3: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CURLYCLOSE"

    // $ANTLR start "STOP"
    public final void mSTOP() throws RecognitionException {
        try {
            int _type = STOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:6: ( '.' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:8: '.'
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
    // $ANTLR end "STOP"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:7: ( ',' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:9: ','
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

    // $ANTLR start "OPEN"
    public final void mOPEN() throws RecognitionException {
        try {
            int _type = OPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:209:6: ( '(' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:209:8: '('
            {
            match('('); 

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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:7: ( ')' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:9: ')'
            {
            match(')'); 

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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:211:8: ( '[' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:211:10: '['
            {
            match('['); 

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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:212:9: ( ']' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:212:11: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SQCLOSE"

    // $ANTLR start "HASH"
    public final void mHASH() throws RecognitionException {
        try {
            int _type = HASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:213:5: ( '#' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:213:7: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HASH"

    // $ANTLR start "DOUBLEQUOTE"
    public final void mDOUBLEQUOTE() throws RecognitionException {
        try {
            int _type = DOUBLEQUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:2: ( '\"' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:4: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLEQUOTE"

    // $ANTLR start "BAR"
    public final void mBAR() throws RecognitionException {
        try {
            int _type = BAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:216:5: ( '|' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:216:7: '|'
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

    // $ANTLR start "CONST"
    public final void mCONST() throws RecognitionException {
        try {
            int _type = CONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:218:8: ( 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:218:11: 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            matchRange('a','z'); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:218:20: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
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
            	    break loop1;
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:5: ( ( 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:7: ( 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:22: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
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
            	    break loop2;
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:8: ( '0' .. '9' ( '0' .. '9' )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:10: '0' .. '9' ( '0' .. '9' )*
            {
            matchRange('0','9'); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:19: ( '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
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
            	    break loop3;
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

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:222:7: ( '-' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:222:9: '-'
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

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:223:6: ( '*' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:223:8: '*'
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

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:224:5: ( '/' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:224:7: '/'
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

    // $ANTLR start "LESS"
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:225:6: ( '<' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:225:8: '<'
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

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:228:5: ( '/*' ( . )* '*/' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:228:7: '/*' ( . )* '*/'
            {
            match("/*"); 



            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:228:12: ( . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='*') ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1=='/') ) {
                        alt4=2;
                    }
                    else if ( ((LA4_1 >= '\u0000' && LA4_1 <= '.')||(LA4_1 >= '0' && LA4_1 <= '\uFFFF')) ) {
                        alt4=1;
                    }


                }
                else if ( ((LA4_0 >= '\u0000' && LA4_0 <= ')')||(LA4_0 >= '+' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:228:12: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop4;
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:231:5: ( ( '//' | '%' ) (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:231:7: ( '//' | '%' ) (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:231:7: ( '//' | '%' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='/') ) {
                alt5=1;
            }
            else if ( (LA5_0=='%') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:231:8: '//'
                    {
                    match("//"); 



                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:231:13: '%'
                    {
                    match('%'); 

                    }
                    break;

            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:231:18: (~ ( '\\n' | '\\r' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
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
            	    break loop6;
                }
            } while (true);


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:231:32: ( '\\r' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\r') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:231:32: '\\r'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:233:8: ( ( '\\r' )? '\\n' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:233:9: ( '\\r' )? '\\n'
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:233:9: ( '\\r' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\r') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:233:9: '\\r'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:234:5: ( ( ' ' | '\\t' )+ )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:234:9: ( ' ' | '\\t' )+
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:234:9: ( ' ' | '\\t' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\t'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
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
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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

    public void mTokens() throws RecognitionException {
        // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:8: ( MAIN | KNOWLEDGE | BELIEFS | GOALS | EVENT | ACTIONSPEC | MODULE | PROGRAM | PROLOGARROW | NOT | ORDER | EQUALS | LINEAR | LINEARALL | RANDOM | RANDOMALL | DEFINE | IF | THEN | TRUE | BEL | GOAL | PRE | POST | PLUS | INSERT | DELETE | ADOPT | DROP | SEND | COLON | CURLYOPEN | CURLYCLOSE | STOP | COMMA | OPEN | CLOSE | SQOPEN | SQCLOSE | HASH | DOUBLEQUOTE | BAR | CONST | VAR | NUMBER | MINUS | MULT | DIV | LESS | COMMENT | LINE_COMMENT | NEWLINE | WS )
        int alt10=53;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:10: MAIN
                {
                mMAIN(); 


                }
                break;
            case 2 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:15: KNOWLEDGE
                {
                mKNOWLEDGE(); 


                }
                break;
            case 3 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:25: BELIEFS
                {
                mBELIEFS(); 


                }
                break;
            case 4 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:33: GOALS
                {
                mGOALS(); 


                }
                break;
            case 5 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:39: EVENT
                {
                mEVENT(); 


                }
                break;
            case 6 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:45: ACTIONSPEC
                {
                mACTIONSPEC(); 


                }
                break;
            case 7 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:56: MODULE
                {
                mMODULE(); 


                }
                break;
            case 8 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:63: PROGRAM
                {
                mPROGRAM(); 


                }
                break;
            case 9 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:71: PROLOGARROW
                {
                mPROLOGARROW(); 


                }
                break;
            case 10 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:83: NOT
                {
                mNOT(); 


                }
                break;
            case 11 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:87: ORDER
                {
                mORDER(); 


                }
                break;
            case 12 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:93: EQUALS
                {
                mEQUALS(); 


                }
                break;
            case 13 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:100: LINEAR
                {
                mLINEAR(); 


                }
                break;
            case 14 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:107: LINEARALL
                {
                mLINEARALL(); 


                }
                break;
            case 15 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:117: RANDOM
                {
                mRANDOM(); 


                }
                break;
            case 16 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:124: RANDOMALL
                {
                mRANDOMALL(); 


                }
                break;
            case 17 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:134: DEFINE
                {
                mDEFINE(); 


                }
                break;
            case 18 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:141: IF
                {
                mIF(); 


                }
                break;
            case 19 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:144: THEN
                {
                mTHEN(); 


                }
                break;
            case 20 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:149: TRUE
                {
                mTRUE(); 


                }
                break;
            case 21 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:154: BEL
                {
                mBEL(); 


                }
                break;
            case 22 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:158: GOAL
                {
                mGOAL(); 


                }
                break;
            case 23 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:163: PRE
                {
                mPRE(); 


                }
                break;
            case 24 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:167: POST
                {
                mPOST(); 


                }
                break;
            case 25 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:172: PLUS
                {
                mPLUS(); 


                }
                break;
            case 26 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:177: INSERT
                {
                mINSERT(); 


                }
                break;
            case 27 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:184: DELETE
                {
                mDELETE(); 


                }
                break;
            case 28 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:191: ADOPT
                {
                mADOPT(); 


                }
                break;
            case 29 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:197: DROP
                {
                mDROP(); 


                }
                break;
            case 30 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:202: SEND
                {
                mSEND(); 


                }
                break;
            case 31 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:207: COLON
                {
                mCOLON(); 


                }
                break;
            case 32 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:213: CURLYOPEN
                {
                mCURLYOPEN(); 


                }
                break;
            case 33 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:223: CURLYCLOSE
                {
                mCURLYCLOSE(); 


                }
                break;
            case 34 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:234: STOP
                {
                mSTOP(); 


                }
                break;
            case 35 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:239: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 36 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:245: OPEN
                {
                mOPEN(); 


                }
                break;
            case 37 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:250: CLOSE
                {
                mCLOSE(); 


                }
                break;
            case 38 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:256: SQOPEN
                {
                mSQOPEN(); 


                }
                break;
            case 39 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:263: SQCLOSE
                {
                mSQCLOSE(); 


                }
                break;
            case 40 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:271: HASH
                {
                mHASH(); 


                }
                break;
            case 41 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:276: DOUBLEQUOTE
                {
                mDOUBLEQUOTE(); 


                }
                break;
            case 42 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:288: BAR
                {
                mBAR(); 


                }
                break;
            case 43 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:292: CONST
                {
                mCONST(); 


                }
                break;
            case 44 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:298: VAR
                {
                mVAR(); 


                }
                break;
            case 45 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:302: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 46 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:309: MINUS
                {
                mMINUS(); 


                }
                break;
            case 47 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:315: MULT
                {
                mMULT(); 


                }
                break;
            case 48 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:320: DIV
                {
                mDIV(); 


                }
                break;
            case 49 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:324: LESS
                {
                mLESS(); 


                }
                break;
            case 50 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:329: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 51 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:337: LINE_COMMENT
                {
                mLINE_COMMENT(); 


                }
                break;
            case 52 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:350: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 53 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:358: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\1\uffff\7\36\1\64\2\36\1\uffff\5\36\1\uffff\1\36\20\uffff\1\101"+
        "\4\uffff\7\36\1\uffff\3\36\2\uffff\6\36\1\124\4\36\2\uffff\3\36"+
        "\1\135\5\36\1\143\1\36\1\145\6\36\1\uffff\4\36\1\160\3\36\1\uffff"+
        "\5\36\1\uffff\1\171\1\uffff\5\36\1\177\1\36\1\u0081\1\u0082\1\u0083"+
        "\1\uffff\3\36\1\u0087\1\u0088\1\36\1\u008a\1\36\1\uffff\1\u008c"+
        "\4\36\1\uffff\1\36\3\uffff\1\u0092\2\36\2\uffff\1\36\1\uffff\1\36"+
        "\1\uffff\1\u0098\1\u009a\1\u009b\1\u009c\1\u009d\1\uffff\1\36\1"+
        "\u009f\1\36\1\u00a1\1\36\1\uffff\1\36\4\uffff\1\36\1\uffff\1\36"+
        "\1\uffff\2\36\1\u00a8\1\36\1\u00aa\1\u00ab\1\uffff\1\u00ac\3\uffff";
    static final String DFA10_eofS =
        "\u00ad\uffff";
    static final String DFA10_minS =
        "\1\11\1\141\1\156\1\145\1\157\1\166\1\55\1\157\1\55\1\157\1\162"+
        "\1\uffff\1\151\1\141\1\145\1\146\1\150\1\uffff\1\145\20\uffff\1"+
        "\52\4\uffff\1\151\1\144\1\157\1\154\1\141\1\145\1\164\1\uffff\1"+
        "\157\1\145\1\163\2\uffff\1\164\1\144\2\156\1\146\1\157\1\60\1\163"+
        "\1\145\1\165\1\156\2\uffff\1\156\1\165\1\167\1\60\1\154\1\156\1"+
        "\151\1\160\1\147\1\60\1\164\1\60\2\145\1\144\1\151\1\145\1\160\1"+
        "\uffff\1\145\1\156\1\145\1\144\1\60\2\154\1\145\1\uffff\1\163\1"+
        "\164\1\157\1\164\1\162\1\uffff\1\60\1\uffff\1\162\1\141\1\157\1"+
        "\156\1\164\1\60\1\162\3\60\1\uffff\2\145\1\146\2\60\1\156\1\60\1"+
        "\141\1\uffff\1\60\1\162\1\155\2\145\1\uffff\1\164\3\uffff\1\60\1"+
        "\144\1\163\2\uffff\1\163\1\uffff\1\155\1\uffff\5\60\1\uffff\1\147"+
        "\1\60\1\160\1\60\1\154\1\uffff\1\154\4\uffff\1\145\1\uffff\1\145"+
        "\1\uffff\2\154\1\60\1\143\2\60\1\uffff\1\60\3\uffff";
    static final String DFA10_maxS =
        "\1\175\1\157\1\156\1\145\1\157\1\166\1\144\1\162\1\55\1\157\1\162"+
        "\1\uffff\1\151\1\141\1\162\1\156\1\162\1\uffff\1\145\20\uffff\1"+
        "\57\4\uffff\1\151\1\144\1\157\1\154\1\141\1\145\1\164\1\uffff\2"+
        "\157\1\163\2\uffff\1\164\1\144\2\156\1\154\1\157\1\172\1\163\1\145"+
        "\1\165\1\156\2\uffff\1\156\1\165\1\167\1\172\1\154\1\156\1\151\1"+
        "\160\1\147\1\172\1\164\1\172\2\145\1\144\1\151\1\145\1\160\1\uffff"+
        "\1\145\1\156\1\145\1\144\1\172\2\154\1\145\1\uffff\1\163\1\164\1"+
        "\157\1\164\1\162\1\uffff\1\172\1\uffff\1\162\1\141\1\157\1\156\1"+
        "\164\1\172\1\162\3\172\1\uffff\2\145\1\146\2\172\1\156\1\172\1\141"+
        "\1\uffff\1\172\1\162\1\155\2\145\1\uffff\1\164\3\uffff\1\172\1\144"+
        "\1\163\2\uffff\1\163\1\uffff\1\155\1\uffff\5\172\1\uffff\1\147\1"+
        "\172\1\160\1\172\1\154\1\uffff\1\154\4\uffff\1\145\1\uffff\1\145"+
        "\1\uffff\2\154\1\172\1\143\2\172\1\uffff\1\172\3\uffff";
    static final String DFA10_acceptS =
        "\13\uffff\1\14\5\uffff\1\31\1\uffff\1\40\1\41\1\42\1\43\1\44\1\45"+
        "\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\uffff\1\61"+
        "\1\63\1\64\1\65\7\uffff\1\26\3\uffff\1\11\1\37\13\uffff\1\62\1\60"+
        "\22\uffff\1\22\10\uffff\1\25\5\uffff\1\27\1\uffff\1\12\12\uffff"+
        "\1\1\10\uffff\1\30\5\uffff\1\35\1\uffff\1\23\1\24\1\36\3\uffff\1"+
        "\4\1\5\1\uffff\1\34\1\uffff\1\13\5\uffff\1\7\5\uffff\1\15\1\uffff"+
        "\1\17\1\21\1\33\1\32\1\uffff\1\3\1\uffff\1\10\6\uffff\1\2\1\uffff"+
        "\1\16\1\20\1\6";
    static final String DFA10_specialS =
        "\u00ad\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\47\1\46\2\uffff\1\46\22\uffff\1\47\1\uffff\1\34\1\33\1\uffff"+
            "\1\45\2\uffff\1\27\1\30\1\42\1\21\1\26\1\41\1\25\1\43\12\40"+
            "\1\10\1\uffff\1\44\1\13\3\uffff\32\37\1\31\1\uffff\1\32\1\uffff"+
            "\1\37\1\uffff\1\6\1\3\1\36\1\16\1\5\1\36\1\4\1\36\1\17\1\36"+
            "\1\2\1\14\1\1\1\11\1\12\1\7\1\36\1\15\1\22\1\20\6\36\1\23\1"+
            "\35\1\24",
            "\1\50\15\uffff\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\57\65\uffff\1\56\1\60",
            "\1\62\2\uffff\1\61",
            "\1\63",
            "\1\65",
            "\1\66",
            "",
            "\1\67",
            "\1\70",
            "\1\71\14\uffff\1\72",
            "\1\73\7\uffff\1\74",
            "\1\75\11\uffff\1\76",
            "",
            "\1\77",
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
            "\1\100\4\uffff\1\45",
            "",
            "",
            "",
            "",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "",
            "\1\111",
            "\1\113\11\uffff\1\112",
            "\1\114",
            "",
            "",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121\5\uffff\1\122",
            "\1\123",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "",
            "",
            "\1\131",
            "\1\132",
            "\1\133",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\10\36\1\134\21\36",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\144",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\161",
            "\1\162",
            "\1\163",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0080",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0089",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u008b",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "",
            "\1\u0091",
            "",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0093",
            "\1\u0094",
            "",
            "",
            "\1\u0095",
            "",
            "\1\u0096",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\1\u0097\31\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\1\u0099\31\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\u009e",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00a0",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00a2",
            "",
            "\1\u00a3",
            "",
            "",
            "",
            "",
            "\1\u00a4",
            "",
            "\1\u00a5",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00a9",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
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
            return "1:1: Tokens : ( MAIN | KNOWLEDGE | BELIEFS | GOALS | EVENT | ACTIONSPEC | MODULE | PROGRAM | PROLOGARROW | NOT | ORDER | EQUALS | LINEAR | LINEARALL | RANDOM | RANDOMALL | DEFINE | IF | THEN | TRUE | BEL | GOAL | PRE | POST | PLUS | INSERT | DELETE | ADOPT | DROP | SEND | COLON | CURLYOPEN | CURLYCLOSE | STOP | COMMA | OPEN | CLOSE | SQOPEN | SQCLOSE | HASH | DOUBLEQUOTE | BAR | CONST | VAR | NUMBER | MINUS | MULT | DIV | LESS | COMMENT | LINE_COMMENT | NEWLINE | WS );";
        }
    }
 

}