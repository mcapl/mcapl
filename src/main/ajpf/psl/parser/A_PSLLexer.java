// $ANTLR 3.4 /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g 2015-03-24 14:16:30

package ajpf.psl.parser;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class A_PSLLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ACTION=4;
    public static final int ALWAYS=5;
    public static final int AND=6;
    public static final int BELIEVE=7;
    public static final int CLOSEBRACKET=8;
    public static final int COMMASEP=9;
    public static final int COMMENT=10;
    public static final int CONST=11;
    public static final int FALSE=12;
    public static final int FINALLY=13;
    public static final int GOAL=14;
    public static final int IMP=15;
    public static final int INTENDTODO=16;
    public static final int INTENTION=17;
    public static final int NEWLINE=18;
    public static final int NOT=19;
    public static final int NUMBER=20;
    public static final int OPENBRACKET=21;
    public static final int OR=22;
    public static final int PERCEPT=23;
    public static final int RELEASE=24;
    public static final int SQCLOSEBRACKET=25;
    public static final int SQOPENBRACKET=26;
    public static final int TRUE=27;
    public static final int UNNAMED_VAR=28;
    public static final int UNTIL=29;
    public static final int WS=30;

    	int nesting = 0;
    	boolean informula = false;


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public A_PSLLexer() {} 
    public A_PSLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public A_PSLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g"; }

    // $ANTLR start "ALWAYS"
    public final void mALWAYS() throws RecognitionException {
        try {
            int _type = ALWAYS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:125:9: ({...}? => ( 'A' | '[]' ) )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:125:11: {...}? => ( 'A' | '[]' )
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "ALWAYS", "!informula ");
            }

            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:125:28: ( 'A' | '[]' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='A') ) {
                alt1=1;
            }
            else if ( (LA1_0=='[') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:125:29: 'A'
                    {
                    match('A'); 

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:125:35: '[]'
                    {
                    match("[]"); 



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
    // $ANTLR end "ALWAYS"

    // $ANTLR start "FINALLY"
    public final void mFINALLY() throws RecognitionException {
        try {
            int _type = FINALLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:126:9: ({...}? => ( 'E' | '<>' ) )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:126:11: {...}? => ( 'E' | '<>' )
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "FINALLY", "!informula ");
            }

            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:126:28: ( 'E' | '<>' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='E') ) {
                alt2=1;
            }
            else if ( (LA2_0=='<') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:126:29: 'E'
                    {
                    match('E'); 

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:126:35: '<>'
                    {
                    match("<>"); 



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
    // $ANTLR end "FINALLY"

    // $ANTLR start "UNTIL"
    public final void mUNTIL() throws RecognitionException {
        try {
            int _type = UNTIL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:127:7: ({...}? => 'U' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:127:9: {...}? => 'U'
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "UNTIL", "!informula ");
            }

            match('U'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNTIL"

    // $ANTLR start "RELEASE"
    public final void mRELEASE() throws RecognitionException {
        try {
            int _type = RELEASE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:128:9: ({...}? => 'R' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:128:11: {...}? => 'R'
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "RELEASE", "!informula ");
            }

            match('R'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RELEASE"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:129:6: ({...}? => '&' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:129:8: {...}? => '&'
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "AND", "!informula ");
            }

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

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:130:4: ({...}? => '||' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:130:6: {...}? => '||'
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "OR", "!informula ");
            }

            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:131:5: ({...}? => '~' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:131:7: {...}? => '~'
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "NOT", "!informula ");
            }

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

    // $ANTLR start "IMP"
    public final void mIMP() throws RecognitionException {
        try {
            int _type = IMP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:132:5: ({...}? => '->' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:132:7: {...}? => '->'
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "IMP", "!informula ");
            }

            match("->"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IMP"

    // $ANTLR start "BELIEVE"
    public final void mBELIEVE() throws RecognitionException {
        try {
            int _type = BELIEVE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:134:2: ({...}? => 'B' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:134:5: {...}? => 'B'
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "BELIEVE", "!informula ");
            }

            match('B'); 

            informula=true;

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
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:135:7: ({...}? => 'G' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:135:9: {...}? => 'G'
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "GOAL", "!informula ");
            }

            match('G'); 

            informula=true;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GOAL"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:136:7: ({...}? => 'F' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:136:10: {...}? => 'F'
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "FALSE", "!informula ");
            }

            match('F'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "INTENTION"
    public final void mINTENTION() throws RecognitionException {
        try {
            int _type = INTENTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:138:2: ({...}? => 'I' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:138:4: {...}? => 'I'
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "INTENTION", "!informula ");
            }

            match('I'); 

            informula=true;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTENTION"

    // $ANTLR start "ACTION"
    public final void mACTION() throws RecognitionException {
        try {
            int _type = ACTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:139:8: ({...}? => 'D' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:139:10: {...}? => 'D'
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "ACTION", "!informula ");
            }

            match('D'); 

            informula=true;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACTION"

    // $ANTLR start "PERCEPT"
    public final void mPERCEPT() throws RecognitionException {
        try {
            int _type = PERCEPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:140:9: ({...}? => 'P' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:140:11: {...}? => 'P'
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "PERCEPT", "!informula ");
            }

            match('P'); 

             informula=true;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PERCEPT"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:141:6: ({...}? => 'T' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:141:8: {...}? => 'T'
            {
            if ( !((!informula )) ) {
                throw new FailedPredicateException(input, "TRUE", "!informula ");
            }

            match('T'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "INTENDTODO"
    public final void mINTENDTODO() throws RecognitionException {
        try {
            int _type = INTENDTODO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:143:2: ({...}? => 'ItD' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:143:4: {...}? => 'ItD'
            {
            if ( !((!informula)) ) {
                throw new FailedPredicateException(input, "INTENDTODO", "!informula");
            }

            match("ItD"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTENDTODO"

    // $ANTLR start "CONST"
    public final void mCONST() throws RecognitionException {
        try {
            int _type = CONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:145:7: ( 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:145:9: 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            matchRange('a','z'); 

            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:145:18: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:
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
    // $ANTLR end "CONST"

    // $ANTLR start "UNNAMED_VAR"
    public final void mUNNAMED_VAR() throws RecognitionException {
        try {
            int _type = UNNAMED_VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:146:13: ( '_' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:146:15: '_'
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
    // $ANTLR end "UNNAMED_VAR"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:147:8: ( '0' .. '9' ( '0' .. '9' )* )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:147:10: '0' .. '9' ( '0' .. '9' )*
            {
            matchRange('0','9'); 

            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:147:19: ( '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:
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
            	    break loop4;
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

    // $ANTLR start "OPENBRACKET"
    public final void mOPENBRACKET() throws RecognitionException {
        try {
            int _type = OPENBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:149:13: ( '(' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:149:16: '('
            {
            match('('); 

            if (informula) {nesting++;}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OPENBRACKET"

    // $ANTLR start "CLOSEBRACKET"
    public final void mCLOSEBRACKET() throws RecognitionException {
        try {
            int _type = CLOSEBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:150:14: ( ')' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:150:16: ')'
            {
            match(')'); 

            if (informula) {if (nesting > 0) {nesting--;} if (nesting == 0) {informula=false;}}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CLOSEBRACKET"

    // $ANTLR start "SQOPENBRACKET"
    public final void mSQOPENBRACKET() throws RecognitionException {
        try {
            int _type = SQOPENBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:151:15: ( '[' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:151:18: '['
            {
            match('['); 

            if (informula) {nesting++;}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SQOPENBRACKET"

    // $ANTLR start "SQCLOSEBRACKET"
    public final void mSQCLOSEBRACKET() throws RecognitionException {
        try {
            int _type = SQCLOSEBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:152:16: ( ']' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:152:18: ']'
            {
            match(']'); 

            if (informula) {if (nesting > 0) {nesting--;} if (nesting == 0) {informula=false;}}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SQCLOSEBRACKET"

    // $ANTLR start "COMMASEP"
    public final void mCOMMASEP() throws RecognitionException {
        try {
            int _type = COMMASEP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:153:10: ( ',' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:153:12: ','
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
    // $ANTLR end "COMMASEP"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:154:8: ( ( '\\r' )? '\\n' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:154:9: ( '\\r' )? '\\n'
            {
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:154:9: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:154:9: '\\r'
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
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:155:5: ( ( ' ' | '\\t' )+ )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:155:9: ( ' ' | '\\t' )+
            {
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:155:9: ( ' ' | '\\t' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:158:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:158:4: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:158:9: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1 >= '\u0000' && LA7_1 <= '.')||(LA7_1 >= '0' && LA7_1 <= '\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0 >= '\u0000' && LA7_0 <= ')')||(LA7_0 >= '+' && LA7_0 <= '\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:158:36: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
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

    public void mTokens() throws RecognitionException {
        // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:8: ( ALWAYS | FINALLY | UNTIL | RELEASE | AND | OR | NOT | IMP | BELIEVE | GOAL | FALSE | INTENTION | ACTION | PERCEPT | TRUE | INTENDTODO | CONST | UNNAMED_VAR | NUMBER | OPENBRACKET | CLOSEBRACKET | SQOPENBRACKET | SQCLOSEBRACKET | COMMASEP | NEWLINE | WS | COMMENT )
        int alt8=27;
        int LA8_0 = input.LA(1);

        if ( (LA8_0=='A') && ((!informula ))) {
            alt8=1;
        }
        else if ( (LA8_0=='[') ) {
            int LA8_2 = input.LA(2);

            if ( (LA8_2==']') && ((!informula ))) {
                alt8=1;
            }
            else {
                alt8=22;
            }
        }
        else if ( (LA8_0=='<'||LA8_0=='E') && ((!informula ))) {
            alt8=2;
        }
        else if ( (LA8_0=='U') && ((!informula ))) {
            alt8=3;
        }
        else if ( (LA8_0=='R') && ((!informula ))) {
            alt8=4;
        }
        else if ( (LA8_0=='&') && ((!informula ))) {
            alt8=5;
        }
        else if ( (LA8_0=='|') && ((!informula ))) {
            alt8=6;
        }
        else if ( (LA8_0=='~') && ((!informula ))) {
            alt8=7;
        }
        else if ( (LA8_0=='-') && ((!informula ))) {
            alt8=8;
        }
        else if ( (LA8_0=='B') && ((!informula ))) {
            alt8=9;
        }
        else if ( (LA8_0=='G') && ((!informula ))) {
            alt8=10;
        }
        else if ( (LA8_0=='F') && ((!informula ))) {
            alt8=11;
        }
        else if ( (LA8_0=='I') && (((!informula)||(!informula )))) {
            int LA8_13 = input.LA(2);

            if ( (LA8_13=='t') && ((!informula))) {
                alt8=16;
            }
            else {
                alt8=12;
            }
        }
        else if ( (LA8_0=='D') && ((!informula ))) {
            alt8=13;
        }
        else if ( (LA8_0=='P') && ((!informula ))) {
            alt8=14;
        }
        else if ( (LA8_0=='T') && ((!informula ))) {
            alt8=15;
        }
        else if ( ((LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
            alt8=17;
        }
        else if ( (LA8_0=='_') ) {
            alt8=18;
        }
        else if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
            alt8=19;
        }
        else if ( (LA8_0=='(') ) {
            alt8=20;
        }
        else if ( (LA8_0==')') ) {
            alt8=21;
        }
        else if ( (LA8_0==']') ) {
            alt8=23;
        }
        else if ( (LA8_0==',') ) {
            alt8=24;
        }
        else if ( (LA8_0=='\n'||LA8_0=='\r') ) {
            alt8=25;
        }
        else if ( (LA8_0=='\t'||LA8_0==' ') ) {
            alt8=26;
        }
        else if ( (LA8_0=='/') ) {
            alt8=27;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("", 8, 0, input);

            throw nvae;

        }
        switch (alt8) {
            case 1 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:10: ALWAYS
                {
                mALWAYS(); 


                }
                break;
            case 2 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:17: FINALLY
                {
                mFINALLY(); 


                }
                break;
            case 3 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:25: UNTIL
                {
                mUNTIL(); 


                }
                break;
            case 4 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:31: RELEASE
                {
                mRELEASE(); 


                }
                break;
            case 5 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:39: AND
                {
                mAND(); 


                }
                break;
            case 6 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:43: OR
                {
                mOR(); 


                }
                break;
            case 7 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:46: NOT
                {
                mNOT(); 


                }
                break;
            case 8 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:50: IMP
                {
                mIMP(); 


                }
                break;
            case 9 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:54: BELIEVE
                {
                mBELIEVE(); 


                }
                break;
            case 10 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:62: GOAL
                {
                mGOAL(); 


                }
                break;
            case 11 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:67: FALSE
                {
                mFALSE(); 


                }
                break;
            case 12 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:73: INTENTION
                {
                mINTENTION(); 


                }
                break;
            case 13 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:83: ACTION
                {
                mACTION(); 


                }
                break;
            case 14 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:90: PERCEPT
                {
                mPERCEPT(); 


                }
                break;
            case 15 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:98: TRUE
                {
                mTRUE(); 


                }
                break;
            case 16 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:103: INTENDTODO
                {
                mINTENDTODO(); 


                }
                break;
            case 17 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:114: CONST
                {
                mCONST(); 


                }
                break;
            case 18 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:120: UNNAMED_VAR
                {
                mUNNAMED_VAR(); 


                }
                break;
            case 19 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:132: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 20 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:139: OPENBRACKET
                {
                mOPENBRACKET(); 


                }
                break;
            case 21 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:151: CLOSEBRACKET
                {
                mCLOSEBRACKET(); 


                }
                break;
            case 22 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:164: SQOPENBRACKET
                {
                mSQOPENBRACKET(); 


                }
                break;
            case 23 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:178: SQCLOSEBRACKET
                {
                mSQCLOSEBRACKET(); 


                }
                break;
            case 24 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:193: COMMASEP
                {
                mCOMMASEP(); 


                }
                break;
            case 25 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:202: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 26 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:210: WS
                {
                mWS(); 


                }
                break;
            case 27 :
                // /Users/lad/Eclipse/mcapl/src/main/ajpf/psl/parser/A_PSL.g:1:213: COMMENT
                {
                mCOMMENT(); 


                }
                break;

        }

    }


 

}