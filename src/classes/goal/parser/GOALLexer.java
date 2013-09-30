// $ANTLR 3.4 /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2013-09-03 16:22:53

package goal.parser;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class GOALLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int ACTIONSPEC=4;
    public static final int ADOPT=5;
    public static final int BAR=6;
    public static final int BEL=7;
    public static final int BELIEFS=8;
    public static final int CLOSE=9;
    public static final int COLON=10;
    public static final int COMMA=11;
    public static final int CURLYCLOSE=12;
    public static final int CURLYOPEN=13;
    public static final int DEFINE=14;
    public static final int DELETE=15;
    public static final int DOUBLEQUOTE=16;
    public static final int DROP=17;
    public static final int EQUALS=18;
    public static final int EVENT=19;
    public static final int GOAL=20;
    public static final int GOALS=21;
    public static final int HASH=22;
    public static final int IF=23;
    public static final int INSERT=24;
    public static final int KNOWLEDGE=25;
    public static final int LINEAR=26;
    public static final int LINEARALL=27;
    public static final int MAIN=28;
    public static final int MODULE=29;
    public static final int NOT=30;
    public static final int OPEN=31;
    public static final int ORDER=32;
    public static final int PLUS=33;
    public static final int POST=34;
    public static final int PRE=35;
    public static final int PROGRAM=36;
    public static final int PROLOGARROW=37;
    public static final int RANDOM=38;
    public static final int RANDOMALL=39;
    public static final int SEND=40;
    public static final int SQCLOSE=41;
    public static final int SQOPEN=42;
    public static final int STOP=43;
    public static final int THEN=44;
    public static final int TRUE=45;



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

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:8:7: ( '$' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:8:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:9:7: ( '0' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:9:9: '0'
            {
            match('0'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:10:7: ( '9' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:10:9: '9'
            {
            match('9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:11:7: ( 'A' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:11:9: 'A'
            {
            match('A'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:12:7: ( 'Z' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:12:9: 'Z'
            {
            match('Z'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:13:7: ( '_' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:13:9: '_'
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
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:14:7: ( 'a' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:14:9: 'a'
            {
            match('a'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:15:7: ( 'z' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:15:9: 'z'
            {
            match('z'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "MAIN"
    public final void mMAIN() throws RecognitionException {
        try {
            int _type = MAIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:116:5: ( 'main' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:116:7: 'main'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:10: ( 'knowledge' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:13: 'knowledge'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:118:8: ( 'beliefs' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:118:10: 'beliefs'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:7: ( 'goals' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:9: 'goals'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:7: ( 'event' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:9: 'event'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:122:3: ( 'action-spec' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:122:5: 'action-spec'
            {
            match("action-spec"); 



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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:8: ( 'module' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:10: 'module'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:8: ( 'program' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:10: 'program'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:3: ( ':-' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:5: ':-'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:5: ( 'not' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:7: 'not'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:7: ( 'order' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:8: 'order'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:8: ( '=' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:10: '='
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:8: ( 'linear' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:10: 'linear'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:132:3: ( 'linearall' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:132:5: 'linearall'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:8: ( 'random' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:10: 'random'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:3: ( 'randomall' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:5: 'randomall'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:136:8: ( 'define' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:136:10: 'define'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:137:4: ( 'if' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:137:6: 'if'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:138:6: ( 'then' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:138:8: 'then'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:139:6: ( 'true' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:139:8: 'true'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:140:5: ( 'bel' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:140:7: 'bel'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:141:6: ( 'goal' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:141:8: 'goal'
            {
            match("goal"); 



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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:5: ( 'pre' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:7: 'pre'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:6: ( 'post' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:8: 'post'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:6: ( '+' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:8: '+'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:145:8: ( 'insert' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:145:10: 'insert'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:146:8: ( 'delete' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:146:10: 'delete'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:147:7: ( 'adopt' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:147:9: 'adopt'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:6: ( 'drop' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:8: 'drop'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:6: ( 'send' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:8: 'send'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:7: ( ':' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:9: ':'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:10: ( '{' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:12: '{'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:2: ( '}' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:3: '}'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:168:6: ( '.' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:168:8: '.'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:7: ( ',' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:9: ','
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:170:6: ( '(' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:170:8: '('
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:171:7: ( ')' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:171:9: ')'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:8: ( '[' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:10: '['
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:9: ( ']' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:11: ']'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:5: ( '#' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:7: '#'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:176:2: ( '\"' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:176:4: '\"'
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
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:177:5: ( '|' )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:177:7: '|'
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

    public void mTokens() throws RecognitionException {
        // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:8: ( T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | MAIN | KNOWLEDGE | BELIEFS | GOALS | EVENT | ACTIONSPEC | MODULE | PROGRAM | PROLOGARROW | NOT | ORDER | EQUALS | LINEAR | LINEARALL | RANDOM | RANDOMALL | DEFINE | IF | THEN | TRUE | BEL | GOAL | PRE | POST | PLUS | INSERT | DELETE | ADOPT | DROP | SEND | COLON | CURLYOPEN | CURLYCLOSE | STOP | COMMA | OPEN | CLOSE | SQOPEN | SQCLOSE | HASH | DOUBLEQUOTE | BAR )
        int alt1=50;
        alt1 = dfa1.predict(input);
        switch (alt1) {
            case 1 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:10: T__46
                {
                mT__46(); 


                }
                break;
            case 2 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:16: T__47
                {
                mT__47(); 


                }
                break;
            case 3 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:22: T__48
                {
                mT__48(); 


                }
                break;
            case 4 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:28: T__49
                {
                mT__49(); 


                }
                break;
            case 5 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:34: T__50
                {
                mT__50(); 


                }
                break;
            case 6 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:40: T__51
                {
                mT__51(); 


                }
                break;
            case 7 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:46: T__52
                {
                mT__52(); 


                }
                break;
            case 8 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:52: T__53
                {
                mT__53(); 


                }
                break;
            case 9 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:58: MAIN
                {
                mMAIN(); 


                }
                break;
            case 10 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:63: KNOWLEDGE
                {
                mKNOWLEDGE(); 


                }
                break;
            case 11 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:73: BELIEFS
                {
                mBELIEFS(); 


                }
                break;
            case 12 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:81: GOALS
                {
                mGOALS(); 


                }
                break;
            case 13 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:87: EVENT
                {
                mEVENT(); 


                }
                break;
            case 14 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:93: ACTIONSPEC
                {
                mACTIONSPEC(); 


                }
                break;
            case 15 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:104: MODULE
                {
                mMODULE(); 


                }
                break;
            case 16 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:111: PROGRAM
                {
                mPROGRAM(); 


                }
                break;
            case 17 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:119: PROLOGARROW
                {
                mPROLOGARROW(); 


                }
                break;
            case 18 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:131: NOT
                {
                mNOT(); 


                }
                break;
            case 19 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:135: ORDER
                {
                mORDER(); 


                }
                break;
            case 20 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:141: EQUALS
                {
                mEQUALS(); 


                }
                break;
            case 21 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:148: LINEAR
                {
                mLINEAR(); 


                }
                break;
            case 22 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:155: LINEARALL
                {
                mLINEARALL(); 


                }
                break;
            case 23 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:165: RANDOM
                {
                mRANDOM(); 


                }
                break;
            case 24 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:172: RANDOMALL
                {
                mRANDOMALL(); 


                }
                break;
            case 25 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:182: DEFINE
                {
                mDEFINE(); 


                }
                break;
            case 26 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:189: IF
                {
                mIF(); 


                }
                break;
            case 27 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:192: THEN
                {
                mTHEN(); 


                }
                break;
            case 28 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:197: TRUE
                {
                mTRUE(); 


                }
                break;
            case 29 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:202: BEL
                {
                mBEL(); 


                }
                break;
            case 30 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:206: GOAL
                {
                mGOAL(); 


                }
                break;
            case 31 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:211: PRE
                {
                mPRE(); 


                }
                break;
            case 32 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:215: POST
                {
                mPOST(); 


                }
                break;
            case 33 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:220: PLUS
                {
                mPLUS(); 


                }
                break;
            case 34 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:225: INSERT
                {
                mINSERT(); 


                }
                break;
            case 35 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:232: DELETE
                {
                mDELETE(); 


                }
                break;
            case 36 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:239: ADOPT
                {
                mADOPT(); 


                }
                break;
            case 37 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:245: DROP
                {
                mDROP(); 


                }
                break;
            case 38 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:250: SEND
                {
                mSEND(); 


                }
                break;
            case 39 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:255: COLON
                {
                mCOLON(); 


                }
                break;
            case 40 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:261: CURLYOPEN
                {
                mCURLYOPEN(); 


                }
                break;
            case 41 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:271: CURLYCLOSE
                {
                mCURLYCLOSE(); 


                }
                break;
            case 42 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:282: STOP
                {
                mSTOP(); 


                }
                break;
            case 43 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:287: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 44 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:293: OPEN
                {
                mOPEN(); 


                }
                break;
            case 45 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:298: CLOSE
                {
                mCLOSE(); 


                }
                break;
            case 46 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:304: SQOPEN
                {
                mSQOPEN(); 


                }
                break;
            case 47 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:311: SQCLOSE
                {
                mSQCLOSE(); 


                }
                break;
            case 48 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:319: HASH
                {
                mHASH(); 


                }
                break;
            case 49 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:324: DOUBLEQUOTE
                {
                mDOUBLEQUOTE(); 


                }
                break;
            case 50 :
                // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:336: BAR
                {
                mBAR(); 


                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\7\uffff\1\47\7\uffff\1\57\50\uffff\1\101\11\uffff\1\106\6\uffff"+
        "\1\114\1\116\4\uffff";
    static final String DFA1_eofS =
        "\117\uffff";
    static final String DFA1_minS =
        "\1\42\6\uffff\1\143\1\uffff\1\141\1\uffff\1\145\1\157\1\uffff\1"+
        "\157\1\55\3\uffff\1\151\1\141\1\145\1\146\1\150\22\uffff\1\154\1"+
        "\141\1\145\3\uffff\2\156\1\146\5\uffff\1\151\1\154\2\uffff\1\145"+
        "\1\144\4\uffff\1\163\1\141\1\157\2\uffff\1\162\1\155\2\141\4\uffff";
    static final String DFA1_maxS =
        "\1\175\6\uffff\1\144\1\uffff\1\157\1\uffff\1\145\1\157\1\uffff\1"+
        "\162\1\55\3\uffff\1\151\1\141\1\162\1\156\1\162\22\uffff\1\154\1"+
        "\141\1\157\3\uffff\2\156\1\154\5\uffff\1\151\1\154\2\uffff\1\145"+
        "\1\144\4\uffff\1\163\1\141\1\157\2\uffff\1\162\1\155\2\141\4\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\uffff\1\12\2\uffff"+
        "\1\15\2\uffff\1\22\1\23\1\24\5\uffff\1\41\1\46\1\50\1\51\1\52\1"+
        "\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\16\1\44\1\7\1\11\1\17\3"+
        "\uffff\1\40\1\21\1\47\3\uffff\1\45\1\32\1\42\1\33\1\34\2\uffff\1"+
        "\20\1\37\2\uffff\1\31\1\43\1\13\1\35\3\uffff\1\14\1\36\4\uffff\1"+
        "\26\1\25\1\30\1\27";
    static final String DFA1_specialS =
        "\117\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\43\1\42\1\1\3\uffff\1\36\1\37\1\uffff\1\30\1\35\1\uffff\1"+
            "\34\1\uffff\1\2\10\uffff\1\3\1\17\2\uffff\1\22\3\uffff\1\4\30"+
            "\uffff\1\5\1\40\1\uffff\1\41\1\uffff\1\6\1\uffff\1\7\1\13\1"+
            "\uffff\1\25\1\15\1\uffff\1\14\1\uffff\1\26\1\uffff\1\12\1\23"+
            "\1\11\1\20\1\21\1\16\1\uffff\1\24\1\31\1\27\5\uffff\1\10\1\32"+
            "\1\44\1\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\45\1\46",
            "",
            "\1\50\15\uffff\1\51",
            "",
            "\1\52",
            "\1\53",
            "",
            "\1\55\2\uffff\1\54",
            "\1\56",
            "",
            "",
            "",
            "\1\60",
            "\1\61",
            "\1\62\14\uffff\1\63",
            "\1\64\7\uffff\1\65",
            "\1\66\11\uffff\1\67",
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
            "\1\70",
            "\1\71",
            "\1\73\11\uffff\1\72",
            "",
            "",
            "",
            "\1\74",
            "\1\75",
            "\1\76\5\uffff\1\77",
            "",
            "",
            "",
            "",
            "",
            "\1\100",
            "\1\102",
            "",
            "",
            "\1\103",
            "\1\104",
            "",
            "",
            "",
            "",
            "\1\105",
            "\1\107",
            "\1\110",
            "",
            "",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\115",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | MAIN | KNOWLEDGE | BELIEFS | GOALS | EVENT | ACTIONSPEC | MODULE | PROGRAM | PROLOGARROW | NOT | ORDER | EQUALS | LINEAR | LINEARALL | RANDOM | RANDOMALL | DEFINE | IF | THEN | TRUE | BEL | GOAL | PRE | POST | PLUS | INSERT | DELETE | ADOPT | DROP | SEND | COLON | CURLYOPEN | CURLYCLOSE | STOP | COMMA | OPEN | CLOSE | SQOPEN | SQCLOSE | HASH | DOUBLEQUOTE | BAR );";
        }
    }
 

}