// $ANTLR 3.4 /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2013-09-03 16:22:53

package goal.parser;

import ail.syntax.ast.*;
import goal.syntax.ast.*;
import java.util.HashMap;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class GOALParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTIONSPEC", "ADOPT", "BAR", "BEL", "BELIEFS", "CLOSE", "COLON", "COMMA", "CURLYCLOSE", "CURLYOPEN", "DEFINE", "DELETE", "DOUBLEQUOTE", "DROP", "EQUALS", "EVENT", "GOAL", "GOALS", "HASH", "IF", "INSERT", "KNOWLEDGE", "LINEAR", "LINEARALL", "MAIN", "MODULE", "NOT", "OPEN", "ORDER", "PLUS", "POST", "PRE", "PROGRAM", "PROLOGARROW", "RANDOM", "RANDOMALL", "SEND", "SQCLOSE", "SQOPEN", "STOP", "THEN", "TRUE", "'$'", "'0'", "'9'", "'A'", "'Z'", "'_'", "'a'", "'z'"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public GOALParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public GOALParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return GOALParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g"; }


    	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
    	private String name = "";



    // $ANTLR start "program"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:49:1: program : MAIN COLON id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )? ( BELIEFS CURLYOPEN krspec CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module CURLYCLOSE EVENT MODULE CURLYOPEN module CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? CURLYCLOSE ;
    public final void program() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:49:9: ( MAIN COLON id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )? ( BELIEFS CURLYOPEN krspec CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module CURLYCLOSE EVENT MODULE CURLYOPEN module CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? CURLYCLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:49:14: MAIN COLON id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )? ( BELIEFS CURLYOPEN krspec CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module CURLYCLOSE EVENT MODULE CURLYOPEN module CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? CURLYCLOSE
            {
            match(input,MAIN,FOLLOW_MAIN_in_program69); 

            match(input,COLON,FOLLOW_COLON_in_program71); 

            pushFollow(FOLLOW_id_in_program73);
            id();

            state._fsp--;


            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program75); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:50:41: ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==KNOWLEDGE) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:50:42: KNOWLEDGE CURLYOPEN krspec CURLYCLOSE
                    {
                    match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_program118); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program120); 

                    pushFollow(FOLLOW_krspec_in_program122);
                    krspec();

                    state._fsp--;


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program124); 

                    }
                    break;

            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:51:41: ( BELIEFS CURLYOPEN krspec CURLYCLOSE )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==BELIEFS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:51:42: BELIEFS CURLYOPEN krspec CURLYCLOSE
                    {
                    match(input,BELIEFS,FOLLOW_BELIEFS_in_program169); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program171); 

                    pushFollow(FOLLOW_krspec_in_program173);
                    krspec();

                    state._fsp--;


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program175); 

                    }
                    break;

            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:52:41: ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==GOALS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:52:42: GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE
                    {
                    match(input,GOALS,FOLLOW_GOALS_in_program220); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program222); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:52:58: ( poslitconj )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==46||LA3_0==51) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:52:58: poslitconj
                    	    {
                    	    pushFollow(FOLLOW_poslitconj_in_program224);
                    	    poslitconj();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program227); 

                    }
                    break;

            }


            match(input,MAIN,FOLLOW_MAIN_in_program272); 

            match(input,MODULE,FOLLOW_MODULE_in_program274); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program276); 

            pushFollow(FOLLOW_module_in_program278);
            module();

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program280); 

            match(input,EVENT,FOLLOW_EVENT_in_program323); 

            match(input,MODULE,FOLLOW_MODULE_in_program325); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program327); 

            pushFollow(FOLLOW_module_in_program329);
            module();

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program331); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:42: ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ACTIONSPEC) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:43: ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE
                    {
                    match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_program375); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program377); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:64: ( actionspec )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==ADOPT||LA5_0==DELETE||LA5_0==DROP||LA5_0==INSERT||LA5_0==SEND||LA5_0==46||LA5_0==51) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:64: actionspec
                    	    {
                    	    pushFollow(FOLLOW_actionspec_in_program379);
                    	    actionspec();

                    	    state._fsp--;


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


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program382); 

                    }
                    break;

            }


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program427); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "program"



    // $ANTLR start "module"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:1: module : ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? ;
    public final void module() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:8: ( ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:10: ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )?
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:10: ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==KNOWLEDGE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:11: KNOWLEDGE CURLYOPEN krspec CURLYCLOSE
                    {
                    match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_module471); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module473); 

                    pushFollow(FOLLOW_krspec_in_module475);
                    krspec();

                    state._fsp--;


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module477); 

                    }
                    break;

            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:59:30: ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==GOALS) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:59:31: GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE
                    {
                    match(input,GOALS,FOLLOW_GOALS_in_module511); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module513); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:59:47: ( poslitconj )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==46||LA8_0==51) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:59:47: poslitconj
                    	    {
                    	    pushFollow(FOLLOW_poslitconj_in_module515);
                    	    poslitconj();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module518); 

                    }
                    break;

            }


            match(input,PROGRAM,FOLLOW_PROGRAM_in_module551); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:60:38: ( optionorder )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==SQOPEN) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:60:39: optionorder
                    {
                    pushFollow(FOLLOW_optionorder_in_module554);
                    optionorder();

                    state._fsp--;


                    }
                    break;

            }


            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module558); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:61:34: ( macro )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==HASH) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:61:34: macro
            	    {
            	    pushFollow(FOLLOW_macro_in_module593);
            	    macro();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:34: ( actionrule )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==IF) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:34: actionrule
            	    {
            	    pushFollow(FOLLOW_actionrule_in_module629);
            	    actionrule();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module661); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:64:30: ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ACTIONSPEC) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:64:31: ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE
                    {
                    match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_module693); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module695); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:64:52: ( actionspec )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==ADOPT||LA13_0==DELETE||LA13_0==DROP||LA13_0==INSERT||LA13_0==SEND||LA13_0==46||LA13_0==51) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:64:52: actionspec
                    	    {
                    	    pushFollow(FOLLOW_actionspec_in_module697);
                    	    actionspec();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module700); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "module"



    // $ANTLR start "krspec"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:1: krspec : atom ( STOP | PROLOGARROW litconj STOP ) ( atom ( STOP | PROLOGARROW litconj STOP ) )* ;
    public final void krspec() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:7: ( atom ( STOP | PROLOGARROW litconj STOP ) ( atom ( STOP | PROLOGARROW litconj STOP ) )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:10: atom ( STOP | PROLOGARROW litconj STOP ) ( atom ( STOP | PROLOGARROW litconj STOP ) )*
            {
            pushFollow(FOLLOW_atom_in_krspec739);
            atom();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:15: ( STOP | PROLOGARROW litconj STOP )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==STOP) ) {
                alt15=1;
            }
            else if ( (LA15_0==PROLOGARROW) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:16: STOP
                    {
                    match(input,STOP,FOLLOW_STOP_in_krspec742); 

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:23: PROLOGARROW litconj STOP
                    {
                    match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_krspec746); 

                    pushFollow(FOLLOW_litconj_in_krspec748);
                    litconj();

                    state._fsp--;


                    match(input,STOP,FOLLOW_STOP_in_krspec750); 

                    }
                    break;

            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:49: ( atom ( STOP | PROLOGARROW litconj STOP ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==46||LA17_0==51) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:50: atom ( STOP | PROLOGARROW litconj STOP )
            	    {
            	    pushFollow(FOLLOW_atom_in_krspec754);
            	    atom();

            	    state._fsp--;


            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:55: ( STOP | PROLOGARROW litconj STOP )
            	    int alt16=2;
            	    int LA16_0 = input.LA(1);

            	    if ( (LA16_0==STOP) ) {
            	        alt16=1;
            	    }
            	    else if ( (LA16_0==PROLOGARROW) ) {
            	        alt16=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 16, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt16) {
            	        case 1 :
            	            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:56: STOP
            	            {
            	            match(input,STOP,FOLLOW_STOP_in_krspec757); 

            	            }
            	            break;
            	        case 2 :
            	            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:63: PROLOGARROW litconj STOP
            	            {
            	            match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_krspec761); 

            	            pushFollow(FOLLOW_litconj_in_krspec763);
            	            litconj();

            	            state._fsp--;


            	            match(input,STOP,FOLLOW_STOP_in_krspec765); 

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "krspec"



    // $ANTLR start "poslitconj"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:1: poslitconj : atom ( COMMA atom )* STOP ;
    public final void poslitconj() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:12: ( atom ( COMMA atom )* STOP )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:14: atom ( COMMA atom )* STOP
            {
            pushFollow(FOLLOW_atom_in_poslitconj817);
            atom();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:19: ( COMMA atom )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==COMMA) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:20: COMMA atom
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_poslitconj820); 

            	    pushFollow(FOLLOW_atom_in_poslitconj822);
            	    atom();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            match(input,STOP,FOLLOW_STOP_in_poslitconj826); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "poslitconj"



    // $ANTLR start "litconj"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:1: litconj : literal ( COMMA literal )* STOP ;
    public final void litconj() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:9: ( literal ( COMMA literal )* STOP )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:11: literal ( COMMA literal )* STOP
            {
            pushFollow(FOLLOW_literal_in_litconj834);
            literal();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:19: ( COMMA literal )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COMMA) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:20: COMMA literal
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_litconj837); 

            	    pushFollow(FOLLOW_literal_in_litconj839);
            	    literal();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            match(input,STOP,FOLLOW_STOP_in_litconj843); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "litconj"



    // $ANTLR start "literal"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:1: literal : ( atom | NOT OPEN atom CLOSE );
    public final void literal() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:9: ( atom | NOT OPEN atom CLOSE )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==46||LA20_0==51) ) {
                alt20=1;
            }
            else if ( (LA20_0==NOT) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:11: atom
                    {
                    pushFollow(FOLLOW_atom_in_literal851);
                    atom();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:18: NOT OPEN atom CLOSE
                    {
                    match(input,NOT,FOLLOW_NOT_in_literal855); 

                    match(input,OPEN,FOLLOW_OPEN_in_literal857); 

                    pushFollow(FOLLOW_atom_in_literal859);
                    atom();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_literal861); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "literal"



    // $ANTLR start "atom"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:1: atom : id ( parameters )? ;
    public final void atom() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:6: ( id ( parameters )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:8: id ( parameters )?
            {
            pushFollow(FOLLOW_id_in_atom869);
            id();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:11: ( parameters )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==OPEN) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:12: parameters
                    {
                    pushFollow(FOLLOW_parameters_in_atom872);
                    parameters();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "atom"



    // $ANTLR start "parameters"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:1: parameters : OPEN term ( COMMA term )* CLOSE ;
    public final void parameters() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:12: ( OPEN term ( COMMA term )* CLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:14: OPEN term ( COMMA term )* CLOSE
            {
            match(input,OPEN,FOLLOW_OPEN_in_parameters882); 

            pushFollow(FOLLOW_term_in_parameters884);
            term();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:24: ( COMMA term )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==COMMA) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:25: COMMA term
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_parameters887); 

            	    pushFollow(FOLLOW_term_in_parameters889);
            	    term();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            match(input,CLOSE,FOLLOW_CLOSE_in_parameters893); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "parameters"



    // $ANTLR start "optionorder"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:1: optionorder : SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE ;
    public final void optionorder() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:13: ( SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:15: SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE
            {
            match(input,SQOPEN,FOLLOW_SQOPEN_in_optionorder902); 

            match(input,ORDER,FOLLOW_ORDER_in_optionorder904); 

            match(input,EQUALS,FOLLOW_EQUALS_in_optionorder906); 

            if ( (input.LA(1) >= LINEAR && input.LA(1) <= LINEARALL)||(input.LA(1) >= RANDOM && input.LA(1) <= RANDOMALL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,SQCLOSE,FOLLOW_SQCLOSE_in_optionorder926); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "optionorder"



    // $ANTLR start "macro"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:1: macro : HASH DEFINE id ( parameters ) mentalstatecond STOP ;
    public final void macro() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:7: ( HASH DEFINE id ( parameters ) mentalstatecond STOP )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:9: HASH DEFINE id ( parameters ) mentalstatecond STOP
            {
            match(input,HASH,FOLLOW_HASH_in_macro934); 

            match(input,DEFINE,FOLLOW_DEFINE_in_macro936); 

            pushFollow(FOLLOW_id_in_macro938);
            id();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:24: ( parameters )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:25: parameters
            {
            pushFollow(FOLLOW_parameters_in_macro941);
            parameters();

            state._fsp--;


            }


            pushFollow(FOLLOW_mentalstatecond_in_macro944);
            mentalstatecond();

            state._fsp--;


            match(input,STOP,FOLLOW_STOP_in_macro946); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "macro"



    // $ANTLR start "actionrule"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:1: actionrule : IF mentalstatecond THEN actioncombo STOP ;
    public final void actionrule() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:15: ( IF mentalstatecond THEN actioncombo STOP )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:17: IF mentalstatecond THEN actioncombo STOP
            {
            match(input,IF,FOLLOW_IF_in_actionrule957); 

            pushFollow(FOLLOW_mentalstatecond_in_actionrule959);
            mentalstatecond();

            state._fsp--;


            match(input,THEN,FOLLOW_THEN_in_actionrule961); 

            pushFollow(FOLLOW_actioncombo_in_actionrule963);
            actioncombo();

            state._fsp--;


            match(input,STOP,FOLLOW_STOP_in_actionrule965); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "actionrule"



    // $ANTLR start "mentalstatecond"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:1: mentalstatecond : mentalliteral ( COMMA mentalliteral )* ;
    public final void mentalstatecond() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:2: ( mentalliteral ( COMMA mentalliteral )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:4: mentalliteral ( COMMA mentalliteral )*
            {
            pushFollow(FOLLOW_mentalliteral_in_mentalstatecond975);
            mentalliteral();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:18: ( COMMA mentalliteral )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==COMMA) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:19: COMMA mentalliteral
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_mentalstatecond978); 

            	    pushFollow(FOLLOW_mentalliteral_in_mentalstatecond980);
            	    mentalliteral();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "mentalstatecond"



    // $ANTLR start "mentalliteral"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:1: mentalliteral : ( TRUE | mentalatom | NOT OPEN mentalatom CLOSE );
    public final void mentalliteral() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:2: ( TRUE | mentalatom | NOT OPEN mentalatom CLOSE )
            int alt24=3;
            switch ( input.LA(1) ) {
            case TRUE:
                {
                alt24=1;
                }
                break;
            case BEL:
            case GOAL:
                {
                alt24=2;
                }
                break;
            case NOT:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:4: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_mentalliteral993); 

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:11: mentalatom
                    {
                    pushFollow(FOLLOW_mentalatom_in_mentalliteral997);
                    mentalatom();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:24: NOT OPEN mentalatom CLOSE
                    {
                    match(input,NOT,FOLLOW_NOT_in_mentalliteral1001); 

                    match(input,OPEN,FOLLOW_OPEN_in_mentalliteral1003); 

                    pushFollow(FOLLOW_mentalatom_in_mentalliteral1005);
                    mentalatom();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_mentalliteral1007); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "mentalliteral"



    // $ANTLR start "mentalatom"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:1: mentalatom : ( BEL OPEN litconj CLOSE | GOAL OPEN litconj CLOSE );
    public final void mentalatom() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:2: ( BEL OPEN litconj CLOSE | GOAL OPEN litconj CLOSE )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==BEL) ) {
                alt25=1;
            }
            else if ( (LA25_0==GOAL) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }
            switch (alt25) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:4: BEL OPEN litconj CLOSE
                    {
                    match(input,BEL,FOLLOW_BEL_in_mentalatom1017); 

                    match(input,OPEN,FOLLOW_OPEN_in_mentalatom1019); 

                    pushFollow(FOLLOW_litconj_in_mentalatom1021);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1023); 

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:29: GOAL OPEN litconj CLOSE
                    {
                    match(input,GOAL,FOLLOW_GOAL_in_mentalatom1027); 

                    match(input,OPEN,FOLLOW_OPEN_in_mentalatom1029); 

                    pushFollow(FOLLOW_litconj_in_mentalatom1031);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1033); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "mentalatom"



    // $ANTLR start "actionspec"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:1: actionspec : action CURLYOPEN PRE CURLYOPEN litconj CURLYCLOSE POST CURLYOPEN litconj CURLYCLOSE CURLYCLOSE ;
    public final void actionspec() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:11: ( action CURLYOPEN PRE CURLYOPEN litconj CURLYCLOSE POST CURLYOPEN litconj CURLYCLOSE CURLYCLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:13: action CURLYOPEN PRE CURLYOPEN litconj CURLYCLOSE POST CURLYOPEN litconj CURLYCLOSE CURLYCLOSE
            {
            pushFollow(FOLLOW_action_in_actionspec1042);
            action();

            state._fsp--;


            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1044); 

            match(input,PRE,FOLLOW_PRE_in_actionspec1046); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1048); 

            pushFollow(FOLLOW_litconj_in_actionspec1050);
            litconj();

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1052); 

            match(input,POST,FOLLOW_POST_in_actionspec1054); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1056); 

            pushFollow(FOLLOW_litconj_in_actionspec1058);
            litconj();

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1060); 

            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1062); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "actionspec"



    // $ANTLR start "actioncombo"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:96:1: actioncombo : action ( PLUS action )* ;
    public final void actioncombo() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:2: ( action ( PLUS action )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:4: action ( PLUS action )*
            {
            pushFollow(FOLLOW_action_in_actioncombo1071);
            action();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:11: ( PLUS action )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==PLUS) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:12: PLUS action
            	    {
            	    match(input,PLUS,FOLLOW_PLUS_in_actioncombo1074); 

            	    pushFollow(FOLLOW_action_in_actioncombo1076);
            	    action();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "actioncombo"



    // $ANTLR start "action"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:1: action : ( userdefaction | builtinaction | communication );
    public final void action() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:8: ( userdefaction | builtinaction | communication )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 46:
            case 51:
                {
                alt27=1;
                }
                break;
            case ADOPT:
            case DELETE:
            case DROP:
            case INSERT:
                {
                alt27=2;
                }
                break;
            case SEND:
                {
                alt27=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }

            switch (alt27) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:10: userdefaction
                    {
                    pushFollow(FOLLOW_userdefaction_in_action1087);
                    userdefaction();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:26: builtinaction
                    {
                    pushFollow(FOLLOW_builtinaction_in_action1091);
                    builtinaction();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:42: communication
                    {
                    pushFollow(FOLLOW_communication_in_action1095);
                    communication();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "action"



    // $ANTLR start "userdefaction"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:101:1: userdefaction : id ( parameters )+ ;
    public final void userdefaction() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:2: ( id ( parameters )+ )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:4: id ( parameters )+
            {
            pushFollow(FOLLOW_id_in_userdefaction1104);
            id();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:7: ( parameters )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==OPEN) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:8: parameters
            	    {
            	    pushFollow(FOLLOW_parameters_in_userdefaction1107);
            	    parameters();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "userdefaction"



    // $ANTLR start "builtinaction"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:104:1: builtinaction : ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN litconj CLOSE | DROP OPEN litconj CLOSE );
    public final void builtinaction() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:2: ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN litconj CLOSE | DROP OPEN litconj CLOSE )
            int alt29=4;
            switch ( input.LA(1) ) {
            case INSERT:
                {
                alt29=1;
                }
                break;
            case DELETE:
                {
                alt29=2;
                }
                break;
            case ADOPT:
                {
                alt29=3;
                }
                break;
            case DROP:
                {
                alt29=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }

            switch (alt29) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:4: INSERT OPEN litconj CLOSE
                    {
                    match(input,INSERT,FOLLOW_INSERT_in_builtinaction1119); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1121); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1123);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1125); 

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:106:3: DELETE OPEN litconj CLOSE
                    {
                    match(input,DELETE,FOLLOW_DELETE_in_builtinaction1131); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1133); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1135);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1137); 

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:4: ADOPT OPEN litconj CLOSE
                    {
                    match(input,ADOPT,FOLLOW_ADOPT_in_builtinaction1144); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1146); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1148);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1150); 

                    }
                    break;
                case 4 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:4: DROP OPEN litconj CLOSE
                    {
                    match(input,DROP,FOLLOW_DROP_in_builtinaction1157); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1159); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1161);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1163); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "builtinaction"



    // $ANTLR start "communication"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:1: communication : SEND OPEN id COMMA poslitconj CLOSE ;
    public final void communication() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:2: ( SEND OPEN id COMMA poslitconj CLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:4: SEND OPEN id COMMA poslitconj CLOSE
            {
            match(input,SEND,FOLLOW_SEND_in_communication1175); 

            match(input,OPEN,FOLLOW_OPEN_in_communication1177); 

            pushFollow(FOLLOW_id_in_communication1179);
            id();

            state._fsp--;


            match(input,COMMA,FOLLOW_COMMA_in_communication1181); 

            pushFollow(FOLLOW_poslitconj_in_communication1183);
            poslitconj();

            state._fsp--;


            match(input,CLOSE,FOLLOW_CLOSE_in_communication1185); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "communication"



    // $ANTLR start "id"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:1: id : ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '$' )* ;
    public final void id() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:4: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '$' )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:6: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '$' )*
            {
            if ( input.LA(1)==46||input.LA(1)==51 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '$' )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==46||LA30_0==51) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
            	    {
            	    if ( input.LA(1)==46||input.LA(1)==51 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "id"



    // $ANTLR start "term"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:2: term : ( atom | stringterm | numberterm | listterm | var ) ;
    public final void term() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:7: ( ( atom | stringterm | numberterm | listterm | var ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:9: ( atom | stringterm | numberterm | listterm | var )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:9: ( atom | stringterm | numberterm | listterm | var )
            int alt31=5;
            switch ( input.LA(1) ) {
            case 46:
            case 51:
                {
                alt31=1;
                }
                break;
            case DOUBLEQUOTE:
                {
                alt31=2;
                }
                break;

                {
                alt31=3;
                }
                break;
            case SQOPEN:
                {
                alt31=4;
                }
                break;

                {
                alt31=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }

            switch (alt31) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:10: atom
                    {
                    pushFollow(FOLLOW_atom_in_term1591);
                    atom();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:17: stringterm
                    {
                    pushFollow(FOLLOW_stringterm_in_term1595);
                    stringterm();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:30: numberterm
                    {
                    pushFollow(FOLLOW_numberterm_in_term1599);
                    numberterm();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:43: listterm
                    {
                    pushFollow(FOLLOW_listterm_in_term1603);
                    listterm();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:54: var
                    {
                    pushFollow(FOLLOW_var_in_term1607);
                    var();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "term"



    // $ANTLR start "stringterm"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:2: stringterm : DOUBLEQUOTE word DOUBLEQUOTE ;
    public final void stringterm() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:3: ( DOUBLEQUOTE word DOUBLEQUOTE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:5: DOUBLEQUOTE word DOUBLEQUOTE
            {
            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1618); 

            pushFollow(FOLLOW_word_in_stringterm1620);
            word();

            state._fsp--;


            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1622); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "stringterm"



    // $ANTLR start "numberterm"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:155:2: numberterm : ( '0' .. '9' ) ( '0' .. '9' )* ;
    public final void numberterm() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:156:3: ( ( '0' .. '9' ) ( '0' .. '9' )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:156:5: ( '0' .. '9' ) ( '0' .. '9' )*
            {
            if (  ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:156:16: ( '0' .. '9' )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( () ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
            	    {
            	    if (  ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "numberterm"



    // $ANTLR start "word"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:157:2: word : ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* ;
    public final void word() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:157:7: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:157:9: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if (  ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:157:42: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( () ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
            	    {
            	    if (  ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "word"



    // $ANTLR start "listterm"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:159:2: listterm : SQOPEN ( term ( COMMA term )* ( BAR var )? )? SQCLOSE ;
    public final void listterm() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:3: ( SQOPEN ( term ( COMMA term )* ( BAR var )? )? SQCLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:5: SQOPEN ( term ( COMMA term )* ( BAR var )? )? SQCLOSE
            {
            match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm1694); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:12: ( term ( COMMA term )* ( BAR var )? )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==DOUBLEQUOTE||LA36_0==SQOPEN||LA36_0==46||LA36_0==51) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:13: term ( COMMA term )* ( BAR var )?
                    {
                    pushFollow(FOLLOW_term_in_listterm1697);
                    term();

                    state._fsp--;


                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:18: ( COMMA term )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==COMMA) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:19: COMMA term
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_listterm1700); 

                    	    pushFollow(FOLLOW_term_in_listterm1702);
                    	    term();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:32: ( BAR var )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==BAR) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:33: BAR var
                            {
                            match(input,BAR,FOLLOW_BAR_in_listterm1707); 

                            pushFollow(FOLLOW_var_in_listterm1709);
                            var();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;

            }


            match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm1716); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "listterm"



    // $ANTLR start "var"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:161:2: var : ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* ;
    public final void var() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:161:6: ( ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:161:8: ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if (  ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:161:19: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( () ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
            	    {
            	    if (  ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "var"

    // Delegated rules


 

    public static final BitSet FOLLOW_MAIN_in_program69 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_program71 = new BitSet(new long[]{0x0008400000000000L});
    public static final BitSet FOLLOW_id_in_program73 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program75 = new BitSet(new long[]{0x0000000012200100L});
    public static final BitSet FOLLOW_KNOWLEDGE_in_program118 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program120 = new BitSet(new long[]{0x0008400000000000L});
    public static final BitSet FOLLOW_krspec_in_program122 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program124 = new BitSet(new long[]{0x0000000010200100L});
    public static final BitSet FOLLOW_BELIEFS_in_program169 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program171 = new BitSet(new long[]{0x0008400000000000L});
    public static final BitSet FOLLOW_krspec_in_program173 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program175 = new BitSet(new long[]{0x0000000010200000L});
    public static final BitSet FOLLOW_GOALS_in_program220 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program222 = new BitSet(new long[]{0x0008400000001000L});
    public static final BitSet FOLLOW_poslitconj_in_program224 = new BitSet(new long[]{0x0008400000001000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program227 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_MAIN_in_program272 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_MODULE_in_program274 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program276 = new BitSet(new long[]{0x0000001002200000L});
    public static final BitSet FOLLOW_module_in_program278 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program280 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_EVENT_in_program323 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_MODULE_in_program325 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program327 = new BitSet(new long[]{0x0000001002200000L});
    public static final BitSet FOLLOW_module_in_program329 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program331 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ACTIONSPEC_in_program375 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program377 = new BitSet(new long[]{0x0008410001028020L});
    public static final BitSet FOLLOW_actionspec_in_program379 = new BitSet(new long[]{0x0008410001029020L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program382 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KNOWLEDGE_in_module471 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module473 = new BitSet(new long[]{0x0008400000000000L});
    public static final BitSet FOLLOW_krspec_in_module475 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module477 = new BitSet(new long[]{0x0000001000200000L});
    public static final BitSet FOLLOW_GOALS_in_module511 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module513 = new BitSet(new long[]{0x0008400000001000L});
    public static final BitSet FOLLOW_poslitconj_in_module515 = new BitSet(new long[]{0x0008400000001000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module518 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_PROGRAM_in_module551 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_optionorder_in_module554 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module558 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_macro_in_module593 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_actionrule_in_module629 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module661 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ACTIONSPEC_in_module693 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module695 = new BitSet(new long[]{0x0008410001028020L});
    public static final BitSet FOLLOW_actionspec_in_module697 = new BitSet(new long[]{0x0008410001029020L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_krspec739 = new BitSet(new long[]{0x0000082000000000L});
    public static final BitSet FOLLOW_STOP_in_krspec742 = new BitSet(new long[]{0x0008400000000002L});
    public static final BitSet FOLLOW_PROLOGARROW_in_krspec746 = new BitSet(new long[]{0x0008400040000000L});
    public static final BitSet FOLLOW_litconj_in_krspec748 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_STOP_in_krspec750 = new BitSet(new long[]{0x0008400000000002L});
    public static final BitSet FOLLOW_atom_in_krspec754 = new BitSet(new long[]{0x0000082000000000L});
    public static final BitSet FOLLOW_STOP_in_krspec757 = new BitSet(new long[]{0x0008400000000002L});
    public static final BitSet FOLLOW_PROLOGARROW_in_krspec761 = new BitSet(new long[]{0x0008400040000000L});
    public static final BitSet FOLLOW_litconj_in_krspec763 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_STOP_in_krspec765 = new BitSet(new long[]{0x0008400000000002L});
    public static final BitSet FOLLOW_atom_in_poslitconj817 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_COMMA_in_poslitconj820 = new BitSet(new long[]{0x0008400000000000L});
    public static final BitSet FOLLOW_atom_in_poslitconj822 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_STOP_in_poslitconj826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_litconj834 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_COMMA_in_litconj837 = new BitSet(new long[]{0x0008400040000000L});
    public static final BitSet FOLLOW_literal_in_litconj839 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_STOP_in_litconj843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_literal851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_literal855 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_OPEN_in_literal857 = new BitSet(new long[]{0x0008400000000000L});
    public static final BitSet FOLLOW_atom_in_literal859 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_literal861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_atom869 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_parameters_in_atom872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_parameters882 = new BitSet(new long[]{0x0008440000010000L});
    public static final BitSet FOLLOW_term_in_parameters884 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_COMMA_in_parameters887 = new BitSet(new long[]{0x0008440000010000L});
    public static final BitSet FOLLOW_term_in_parameters889 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_CLOSE_in_parameters893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQOPEN_in_optionorder902 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ORDER_in_optionorder904 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EQUALS_in_optionorder906 = new BitSet(new long[]{0x000000C00C000000L});
    public static final BitSet FOLLOW_set_in_optionorder908 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_optionorder926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HASH_in_macro934 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DEFINE_in_macro936 = new BitSet(new long[]{0x0008400000000000L});
    public static final BitSet FOLLOW_id_in_macro938 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_parameters_in_macro941 = new BitSet(new long[]{0x0000200040100080L});
    public static final BitSet FOLLOW_mentalstatecond_in_macro944 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_STOP_in_macro946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_actionrule957 = new BitSet(new long[]{0x0000200040100080L});
    public static final BitSet FOLLOW_mentalstatecond_in_actionrule959 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_THEN_in_actionrule961 = new BitSet(new long[]{0x0008410001028020L});
    public static final BitSet FOLLOW_actioncombo_in_actionrule963 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_STOP_in_actionrule965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond975 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_mentalstatecond978 = new BitSet(new long[]{0x0000200040100080L});
    public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond980 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_TRUE_in_mentalliteral993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mentalatom_in_mentalliteral997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_mentalliteral1001 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_OPEN_in_mentalliteral1003 = new BitSet(new long[]{0x0000000000100080L});
    public static final BitSet FOLLOW_mentalatom_in_mentalliteral1005 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_mentalliteral1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BEL_in_mentalatom1017 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_OPEN_in_mentalatom1019 = new BitSet(new long[]{0x0008400040000000L});
    public static final BitSet FOLLOW_litconj_in_mentalatom1021 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_mentalatom1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GOAL_in_mentalatom1027 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_OPEN_in_mentalatom1029 = new BitSet(new long[]{0x0008400040000000L});
    public static final BitSet FOLLOW_litconj_in_mentalatom1031 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_mentalatom1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_actionspec1042 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1044 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_PRE_in_actionspec1046 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1048 = new BitSet(new long[]{0x0008400040000000L});
    public static final BitSet FOLLOW_litconj_in_actionspec1050 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1052 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_POST_in_actionspec1054 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1056 = new BitSet(new long[]{0x0008400040000000L});
    public static final BitSet FOLLOW_litconj_in_actionspec1058 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1060 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_actioncombo1071 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_PLUS_in_actioncombo1074 = new BitSet(new long[]{0x0008410001028020L});
    public static final BitSet FOLLOW_action_in_actioncombo1076 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_userdefaction_in_action1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_builtinaction_in_action1091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_communication_in_action1095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_userdefaction1104 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_parameters_in_userdefaction1107 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_INSERT_in_builtinaction1119 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1121 = new BitSet(new long[]{0x0008400040000000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1123 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_builtinaction1131 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1133 = new BitSet(new long[]{0x0008400040000000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1135 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADOPT_in_builtinaction1144 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1146 = new BitSet(new long[]{0x0008400040000000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1148 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_builtinaction1157 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1159 = new BitSet(new long[]{0x0008400040000000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1161 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEND_in_communication1175 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_OPEN_in_communication1177 = new BitSet(new long[]{0x0008400000000000L});
    public static final BitSet FOLLOW_id_in_communication1179 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COMMA_in_communication1181 = new BitSet(new long[]{0x0008400000000000L});
    public static final BitSet FOLLOW_poslitconj_in_communication1183 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_communication1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_id1234 = new BitSet(new long[]{0x0008400000000002L});
    public static final BitSet FOLLOW_atom_in_term1591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringterm_in_term1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numberterm_in_term1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listterm_in_term1603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_term1607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_word_in_stringterm1620 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_numberterm1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_word1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQOPEN_in_listterm1694 = new BitSet(new long[]{0x0008460000010000L});
    public static final BitSet FOLLOW_term_in_listterm1697 = new BitSet(new long[]{0x0000020000000840L});
    public static final BitSet FOLLOW_COMMA_in_listterm1700 = new BitSet(new long[]{0x0008440000010000L});
    public static final BitSet FOLLOW_term_in_listterm1702 = new BitSet(new long[]{0x0000020000000840L});
    public static final BitSet FOLLOW_BAR_in_listterm1707 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_var_in_listterm1709 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_listterm1716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_var1724 = new BitSet(new long[]{0x0000000000000002L});

}