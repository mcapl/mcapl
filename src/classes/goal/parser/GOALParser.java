// $ANTLR 3.4 /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2013-09-30 15:39:57

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTIONSPEC", "ADOPT", "BAR", "BEL", "BELIEFS", "CLOSE", "COLON", "COMMA", "COMMENT", "CONST", "CURLYCLOSE", "CURLYOPEN", "DEFINE", "DELETE", "DIV", "DOUBLEQUOTE", "DROP", "EQUALS", "EVENT", "GOAL", "GOALS", "HASH", "IF", "INSERT", "KNOWLEDGE", "LESS", "LINEAR", "LINEARALL", "LINE_COMMENT", "MAIN", "MINUS", "MODULE", "MULT", "NEWLINE", "NOT", "NUMBER", "OPEN", "ORDER", "PLUS", "POST", "PRE", "PROGRAM", "PROLOGARROW", "RANDOM", "RANDOMALL", "SEND", "SQCLOSE", "SQOPEN", "STOP", "THEN", "TRUE", "VAR", "WS"
    };

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
    public String getGrammarFileName() { return "/Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g"; }


    	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
    	private String name = "";



    // $ANTLR start "program"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:49:1: program returns [Abstract_MAS mas] : MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )? ( BELIEFS CURLYOPEN krspec CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module CURLYCLOSE ( EVENT MODULE CURLYOPEN module CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? CURLYCLOSE ;
    public final Abstract_MAS program() throws RecognitionException {
        Abstract_MAS mas = null;


        String i =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:49:36: ( MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )? ( BELIEFS CURLYOPEN krspec CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module CURLYCLOSE ( EVENT MODULE CURLYOPEN module CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? CURLYCLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:49:39: MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )? ( BELIEFS CURLYOPEN krspec CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module CURLYCLOSE ( EVENT MODULE CURLYOPEN module CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? CURLYCLOSE
            {
            mas = new Abstract_MAS(); ArrayList<Abstract_GOALAgent> agents = new ArrayList<Abstract_GOALAgent>();

            match(input,MAIN,FOLLOW_MAIN_in_program94); 

            match(input,COLON,FOLLOW_COLON_in_program96); 

            pushFollow(FOLLOW_id_in_program100);
            i=id();

            state._fsp--;


            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program102); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:51:41: ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==KNOWLEDGE) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:51:42: KNOWLEDGE CURLYOPEN krspec CURLYCLOSE
                    {
                    match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_program146); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program148); 

                    pushFollow(FOLLOW_krspec_in_program150);
                    krspec();

                    state._fsp--;


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program152); 

                    }
                    break;

            }


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:52:41: ( BELIEFS CURLYOPEN krspec CURLYCLOSE )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==BELIEFS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:52:42: BELIEFS CURLYOPEN krspec CURLYCLOSE
                    {
                    match(input,BELIEFS,FOLLOW_BELIEFS_in_program197); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program199); 

                    pushFollow(FOLLOW_krspec_in_program201);
                    krspec();

                    state._fsp--;


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program203); 

                    }
                    break;

            }


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:41: ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==GOALS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:42: GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE
                    {
                    match(input,GOALS,FOLLOW_GOALS_in_program248); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program250); 

                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:58: ( poslitconj )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==CONST||LA3_0==MINUS||LA3_0==NUMBER||LA3_0==VAR) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:58: poslitconj
                    	    {
                    	    pushFollow(FOLLOW_poslitconj_in_program252);
                    	    poslitconj();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program255); 

                    }
                    break;

            }


            match(input,MAIN,FOLLOW_MAIN_in_program300); 

            match(input,MODULE,FOLLOW_MODULE_in_program302); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program304); 

            pushFollow(FOLLOW_module_in_program306);
            module();

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program308); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:42: ( EVENT MODULE CURLYOPEN module CURLYCLOSE )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==EVENT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:43: EVENT MODULE CURLYOPEN module CURLYCLOSE
                    {
                    match(input,EVENT,FOLLOW_EVENT_in_program352); 

                    match(input,MODULE,FOLLOW_MODULE_in_program354); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program356); 

                    pushFollow(FOLLOW_module_in_program358);
                    module();

                    state._fsp--;


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program360); 

                    }
                    break;

            }


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:56:42: ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ACTIONSPEC) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:56:43: ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE
                    {
                    match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_program406); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program408); 

                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:56:64: ( actionspec )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==ADOPT||LA6_0==CONST||LA6_0==DELETE||LA6_0==DROP||LA6_0==INSERT||LA6_0==SEND||LA6_0==VAR) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:56:64: actionspec
                    	    {
                    	    pushFollow(FOLLOW_actionspec_in_program410);
                    	    actionspec();

                    	    state._fsp--;


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


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program413); 

                    }
                    break;

            }


             try {Abstract_GOALAgent gl = new Abstract_GOALAgent(i); agents.add(gl);} 
            		       catch (Exception e) {System.err.println(e);}

            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program506); 

            mas.setAgs(agents);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return mas;
    }
    // $ANTLR end "program"



    // $ANTLR start "module"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:1: module : ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? ;
    public final void module() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:8: ( ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:10: ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )?
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:10: ( KNOWLEDGE CURLYOPEN krspec CURLYCLOSE )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==KNOWLEDGE) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:11: KNOWLEDGE CURLYOPEN krspec CURLYCLOSE
                    {
                    match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_module598); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module600); 

                    pushFollow(FOLLOW_krspec_in_module602);
                    krspec();

                    state._fsp--;


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module604); 

                    }
                    break;

            }


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:30: ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==GOALS) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:31: GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE
                    {
                    match(input,GOALS,FOLLOW_GOALS_in_module638); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module640); 

                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:47: ( poslitconj )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==CONST||LA9_0==MINUS||LA9_0==NUMBER||LA9_0==VAR) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:47: poslitconj
                    	    {
                    	    pushFollow(FOLLOW_poslitconj_in_module642);
                    	    poslitconj();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module645); 

                    }
                    break;

            }


            match(input,PROGRAM,FOLLOW_PROGRAM_in_module678); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:64:38: ( optionorder )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==SQOPEN) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:64:39: optionorder
                    {
                    pushFollow(FOLLOW_optionorder_in_module681);
                    optionorder();

                    state._fsp--;


                    }
                    break;

            }


            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module685); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:34: ( macro )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==HASH) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:34: macro
            	    {
            	    pushFollow(FOLLOW_macro_in_module720);
            	    macro();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:34: ( actionrule )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==IF) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:34: actionrule
            	    {
            	    pushFollow(FOLLOW_actionrule_in_module756);
            	    actionrule();

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


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module788); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:30: ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ACTIONSPEC) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:31: ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE
                    {
                    match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_module820); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module822); 

                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:52: ( actionspec )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==ADOPT||LA14_0==CONST||LA14_0==DELETE||LA14_0==DROP||LA14_0==INSERT||LA14_0==SEND||LA14_0==VAR) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:52: actionspec
                    	    {
                    	    pushFollow(FOLLOW_actionspec_in_module824);
                    	    actionspec();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module827); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:1: krspec : ( brule )+ ;
    public final void krspec() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:7: ( ( brule )+ )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:10: ( brule )+
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:10: ( brule )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==CONST||LA16_0==MINUS||LA16_0==NUMBER||LA16_0==VAR) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:10: brule
            	    {
            	    pushFollow(FOLLOW_brule_in_krspec866);
            	    brule();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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



    // $ANTLR start "brule"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:1: brule : atom ( STOP | PROLOGARROW litconj STOP ) ;
    public final void brule() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:7: ( atom ( STOP | PROLOGARROW litconj STOP ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:9: atom ( STOP | PROLOGARROW litconj STOP )
            {
            pushFollow(FOLLOW_atom_in_brule875);
            atom();

            state._fsp--;


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:14: ( STOP | PROLOGARROW litconj STOP )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==STOP) ) {
                alt17=1;
            }
            else if ( (LA17_0==PROLOGARROW) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:15: STOP
                    {
                    match(input,STOP,FOLLOW_STOP_in_brule878); 

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:22: PROLOGARROW litconj STOP
                    {
                    match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_brule882); 

                    pushFollow(FOLLOW_litconj_in_brule884);
                    litconj();

                    state._fsp--;


                    match(input,STOP,FOLLOW_STOP_in_brule886); 

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
    // $ANTLR end "brule"



    // $ANTLR start "poslitconj"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:1: poslitconj : atom ( COMMA atom )* STOP ;
    public final void poslitconj() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:12: ( atom ( COMMA atom )* STOP )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:14: atom ( COMMA atom )* STOP
            {
            pushFollow(FOLLOW_atom_in_poslitconj936);
            atom();

            state._fsp--;


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:19: ( COMMA atom )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==COMMA) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:20: COMMA atom
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_poslitconj939); 

            	    pushFollow(FOLLOW_atom_in_poslitconj941);
            	    atom();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            match(input,STOP,FOLLOW_STOP_in_poslitconj945); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:1: litconj : literal ( COMMA literal )* ;
    public final void litconj() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:9: ( literal ( COMMA literal )* )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:11: literal ( COMMA literal )*
            {
            pushFollow(FOLLOW_literal_in_litconj953);
            literal();

            state._fsp--;


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:19: ( COMMA literal )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COMMA) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:20: COMMA literal
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_litconj956); 

            	    pushFollow(FOLLOW_literal_in_litconj958);
            	    literal();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // $ANTLR end "litconj"



    // $ANTLR start "literal"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:1: literal : ( atom | NOT OPEN atom CLOSE );
    public final void literal() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:9: ( atom | NOT OPEN atom CLOSE )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==CONST||LA20_0==MINUS||LA20_0==NUMBER||LA20_0==VAR) ) {
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:11: atom
                    {
                    pushFollow(FOLLOW_atom_in_literal969);
                    atom();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:18: NOT OPEN atom CLOSE
                    {
                    match(input,NOT,FOLLOW_NOT_in_literal973); 

                    match(input,OPEN,FOLLOW_OPEN_in_literal975); 

                    pushFollow(FOLLOW_atom_in_literal977);
                    atom();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_literal979); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:1: atom : ( id ( parameters )? | equation ) ;
    public final void atom() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:6: ( ( id ( parameters )? | equation ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:8: ( id ( parameters )? | equation )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:8: ( id ( parameters )? | equation )
            int alt22=2;
            switch ( input.LA(1) ) {
            case CONST:
                {
                alt22=1;
                }
                break;
            case VAR:
                {
                int LA22_2 = input.LA(2);

                if ( (LA22_2==CLOSE||LA22_2==COMMA||LA22_2==CURLYCLOSE||LA22_2==OPEN||LA22_2==PROLOGARROW||LA22_2==STOP) ) {
                    alt22=1;
                }
                else if ( (LA22_2==DIV||LA22_2==EQUALS||LA22_2==LESS||LA22_2==MINUS||LA22_2==MULT||LA22_2==PLUS) ) {
                    alt22=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;

                }
                }
                break;
            case MINUS:
            case NUMBER:
                {
                alt22=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:9: id ( parameters )?
                    {
                    pushFollow(FOLLOW_id_in_atom988);
                    id();

                    state._fsp--;


                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:12: ( parameters )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==OPEN) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:14: parameters
                            {
                            pushFollow(FOLLOW_parameters_in_atom992);
                            parameters();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:29: equation
                    {
                    pushFollow(FOLLOW_equation_in_atom998);
                    equation();

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:1: parameters : OPEN term ( COMMA term )* CLOSE ;
    public final void parameters() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:12: ( OPEN term ( COMMA term )* CLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:14: OPEN term ( COMMA term )* CLOSE
            {
            match(input,OPEN,FOLLOW_OPEN_in_parameters1007); 

            pushFollow(FOLLOW_term_in_parameters1009);
            term();

            state._fsp--;


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:24: ( COMMA term )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==COMMA) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:25: COMMA term
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_parameters1012); 

            	    pushFollow(FOLLOW_term_in_parameters1014);
            	    term();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            match(input,CLOSE,FOLLOW_CLOSE_in_parameters1018); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:1: optionorder : SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE ;
    public final void optionorder() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:13: ( SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:15: SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE
            {
            match(input,SQOPEN,FOLLOW_SQOPEN_in_optionorder1027); 

            match(input,ORDER,FOLLOW_ORDER_in_optionorder1029); 

            match(input,EQUALS,FOLLOW_EQUALS_in_optionorder1031); 

            if ( (input.LA(1) >= LINEAR && input.LA(1) <= LINEARALL)||(input.LA(1) >= RANDOM && input.LA(1) <= RANDOMALL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,SQCLOSE,FOLLOW_SQCLOSE_in_optionorder1051); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:1: macro : HASH DEFINE id parameters mentalstatecond STOP ;
    public final void macro() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:7: ( HASH DEFINE id parameters mentalstatecond STOP )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:9: HASH DEFINE id parameters mentalstatecond STOP
            {
            match(input,HASH,FOLLOW_HASH_in_macro1059); 

            match(input,DEFINE,FOLLOW_DEFINE_in_macro1061); 

            pushFollow(FOLLOW_id_in_macro1063);
            id();

            state._fsp--;


            pushFollow(FOLLOW_parameters_in_macro1065);
            parameters();

            state._fsp--;


            pushFollow(FOLLOW_mentalstatecond_in_macro1067);
            mentalstatecond();

            state._fsp--;


            match(input,STOP,FOLLOW_STOP_in_macro1069); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:1: actionrule : IF ( mentalstatecond | id parameters ) THEN actioncombo STOP ;
    public final void actionrule() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:15: ( IF ( mentalstatecond | id parameters ) THEN actioncombo STOP )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:17: IF ( mentalstatecond | id parameters ) THEN actioncombo STOP
            {
            match(input,IF,FOLLOW_IF_in_actionrule1080); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:20: ( mentalstatecond | id parameters )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==BEL||LA24_0==GOAL||LA24_0==NOT||LA24_0==TRUE) ) {
                alt24=1;
            }
            else if ( (LA24_0==CONST||LA24_0==VAR) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }
            switch (alt24) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:21: mentalstatecond
                    {
                    pushFollow(FOLLOW_mentalstatecond_in_actionrule1083);
                    mentalstatecond();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:39: id parameters
                    {
                    pushFollow(FOLLOW_id_in_actionrule1087);
                    id();

                    state._fsp--;


                    pushFollow(FOLLOW_parameters_in_actionrule1089);
                    parameters();

                    state._fsp--;


                    }
                    break;

            }


            match(input,THEN,FOLLOW_THEN_in_actionrule1092); 

            pushFollow(FOLLOW_actioncombo_in_actionrule1094);
            actioncombo();

            state._fsp--;


            match(input,STOP,FOLLOW_STOP_in_actionrule1096); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:1: mentalstatecond : mentalliteral ( COMMA mentalliteral )* ;
    public final void mentalstatecond() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:2: ( mentalliteral ( COMMA mentalliteral )* )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:4: mentalliteral ( COMMA mentalliteral )*
            {
            pushFollow(FOLLOW_mentalliteral_in_mentalstatecond1106);
            mentalliteral();

            state._fsp--;


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:18: ( COMMA mentalliteral )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==COMMA) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:19: COMMA mentalliteral
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_mentalstatecond1109); 

            	    pushFollow(FOLLOW_mentalliteral_in_mentalstatecond1111);
            	    mentalliteral();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:93:1: mentalliteral : ( TRUE | mentalatom | NOT OPEN mentalatom CLOSE );
    public final void mentalliteral() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:2: ( TRUE | mentalatom | NOT OPEN mentalatom CLOSE )
            int alt26=3;
            switch ( input.LA(1) ) {
            case TRUE:
                {
                alt26=1;
                }
                break;
            case BEL:
            case GOAL:
                {
                alt26=2;
                }
                break;
            case NOT:
                {
                alt26=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:4: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_mentalliteral1124); 

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:11: mentalatom
                    {
                    pushFollow(FOLLOW_mentalatom_in_mentalliteral1128);
                    mentalatom();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:24: NOT OPEN mentalatom CLOSE
                    {
                    match(input,NOT,FOLLOW_NOT_in_mentalliteral1132); 

                    match(input,OPEN,FOLLOW_OPEN_in_mentalliteral1134); 

                    pushFollow(FOLLOW_mentalatom_in_mentalliteral1136);
                    mentalatom();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_mentalliteral1138); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:96:1: mentalatom : ( BEL OPEN litconj CLOSE | GOAL OPEN litconj CLOSE );
    public final void mentalatom() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:2: ( BEL OPEN litconj CLOSE | GOAL OPEN litconj CLOSE )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==BEL) ) {
                alt27=1;
            }
            else if ( (LA27_0==GOAL) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:4: BEL OPEN litconj CLOSE
                    {
                    match(input,BEL,FOLLOW_BEL_in_mentalatom1148); 

                    match(input,OPEN,FOLLOW_OPEN_in_mentalatom1150); 

                    pushFollow(FOLLOW_litconj_in_mentalatom1152);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1154); 

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:29: GOAL OPEN litconj CLOSE
                    {
                    match(input,GOAL,FOLLOW_GOAL_in_mentalatom1158); 

                    match(input,OPEN,FOLLOW_OPEN_in_mentalatom1160); 

                    pushFollow(FOLLOW_litconj_in_mentalatom1162);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1164); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:100:1: actionspec : action CURLYOPEN PRE CURLYOPEN litconj CURLYCLOSE POST CURLYOPEN litconj CURLYCLOSE CURLYCLOSE ;
    public final void actionspec() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:100:11: ( action CURLYOPEN PRE CURLYOPEN litconj CURLYCLOSE POST CURLYOPEN litconj CURLYCLOSE CURLYCLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:100:13: action CURLYOPEN PRE CURLYOPEN litconj CURLYCLOSE POST CURLYOPEN litconj CURLYCLOSE CURLYCLOSE
            {
            pushFollow(FOLLOW_action_in_actionspec1173);
            action();

            state._fsp--;


            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1175); 

            match(input,PRE,FOLLOW_PRE_in_actionspec1177); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1179); 

            pushFollow(FOLLOW_litconj_in_actionspec1181);
            litconj();

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1183); 

            match(input,POST,FOLLOW_POST_in_actionspec1185); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1187); 

            pushFollow(FOLLOW_litconj_in_actionspec1189);
            litconj();

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1191); 

            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1193); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:1: actioncombo : action ( PLUS action )* ;
    public final void actioncombo() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:103:2: ( action ( PLUS action )* )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:103:4: action ( PLUS action )*
            {
            pushFollow(FOLLOW_action_in_actioncombo1202);
            action();

            state._fsp--;


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:103:11: ( PLUS action )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==PLUS) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:103:12: PLUS action
            	    {
            	    match(input,PLUS,FOLLOW_PLUS_in_actioncombo1205); 

            	    pushFollow(FOLLOW_action_in_actioncombo1207);
            	    action();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:1: action : ( userdefaction | builtinaction | communication );
    public final void action() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:8: ( userdefaction | builtinaction | communication )
            int alt29=3;
            switch ( input.LA(1) ) {
            case CONST:
            case VAR:
                {
                alt29=1;
                }
                break;
            case ADOPT:
            case DELETE:
            case DROP:
            case INSERT:
                {
                alt29=2;
                }
                break;
            case SEND:
                {
                alt29=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }

            switch (alt29) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:10: userdefaction
                    {
                    pushFollow(FOLLOW_userdefaction_in_action1218);
                    userdefaction();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:26: builtinaction
                    {
                    pushFollow(FOLLOW_builtinaction_in_action1222);
                    builtinaction();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:42: communication
                    {
                    pushFollow(FOLLOW_communication_in_action1226);
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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:1: userdefaction : id ( parameters )+ ;
    public final void userdefaction() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:2: ( id ( parameters )+ )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:4: id ( parameters )+
            {
            pushFollow(FOLLOW_id_in_userdefaction1235);
            id();

            state._fsp--;


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:7: ( parameters )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==OPEN) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:8: parameters
            	    {
            	    pushFollow(FOLLOW_parameters_in_userdefaction1238);
            	    parameters();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:1: builtinaction : ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN litconj CLOSE | DROP OPEN litconj CLOSE );
    public final void builtinaction() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:2: ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN litconj CLOSE | DROP OPEN litconj CLOSE )
            int alt31=4;
            switch ( input.LA(1) ) {
            case INSERT:
                {
                alt31=1;
                }
                break;
            case DELETE:
                {
                alt31=2;
                }
                break;
            case ADOPT:
                {
                alt31=3;
                }
                break;
            case DROP:
                {
                alt31=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }

            switch (alt31) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:4: INSERT OPEN litconj CLOSE
                    {
                    match(input,INSERT,FOLLOW_INSERT_in_builtinaction1250); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1252); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1254);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1256); 

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:112:3: DELETE OPEN litconj CLOSE
                    {
                    match(input,DELETE,FOLLOW_DELETE_in_builtinaction1262); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1264); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1266);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1268); 

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:4: ADOPT OPEN litconj CLOSE
                    {
                    match(input,ADOPT,FOLLOW_ADOPT_in_builtinaction1275); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1277); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1279);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1281); 

                    }
                    break;
                case 4 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:114:4: DROP OPEN litconj CLOSE
                    {
                    match(input,DROP,FOLLOW_DROP_in_builtinaction1288); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1290); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1292);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1294); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:116:1: communication : SEND OPEN id COMMA poslitconj CLOSE ;
    public final void communication() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:2: ( SEND OPEN id COMMA poslitconj CLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:4: SEND OPEN id COMMA poslitconj CLOSE
            {
            match(input,SEND,FOLLOW_SEND_in_communication1306); 

            match(input,OPEN,FOLLOW_OPEN_in_communication1308); 

            pushFollow(FOLLOW_id_in_communication1310);
            id();

            state._fsp--;


            match(input,COMMA,FOLLOW_COMMA_in_communication1312); 

            pushFollow(FOLLOW_poslitconj_in_communication1314);
            poslitconj();

            state._fsp--;


            match(input,CLOSE,FOLLOW_CLOSE_in_communication1316); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:1: id returns [String s] : ( CONST | VAR ) ;
    public final String id() throws RecognitionException {
        String s = null;


        Token CONST1=null;
        Token VAR2=null;

        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:23: ( ( CONST | VAR ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:25: ( CONST | VAR )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:25: ( CONST | VAR )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==CONST) ) {
                alt32=1;
            }
            else if ( (LA32_0==VAR) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;

            }
            switch (alt32) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:26: CONST
                    {
                    CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_id1370); 

                    s = CONST1.getText();

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:58: VAR
                    {
                    VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_id1375); 

                    s = VAR2.getText();

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
        return s;
    }
    // $ANTLR end "id"



    // $ANTLR start "equation"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:158:2: equation : arithexpr eqoper arithexpr ;
    public final void equation() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:159:3: ( arithexpr eqoper arithexpr )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:159:5: arithexpr eqoper arithexpr
            {
            pushFollow(FOLLOW_arithexpr_in_equation1691);
            arithexpr();

            state._fsp--;


            pushFollow(FOLLOW_eqoper_in_equation1693);
            eqoper();

            state._fsp--;


            pushFollow(FOLLOW_arithexpr_in_equation1695);
            arithexpr();

            state._fsp--;


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
    // $ANTLR end "equation"



    // $ANTLR start "term"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:2: term : ( stringterm | function_term | arithexpr | listterm ) ;
    public final void term() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:7: ( ( stringterm | function_term | arithexpr | listterm ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:9: ( stringterm | function_term | arithexpr | listterm )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:9: ( stringterm | function_term | arithexpr | listterm )
            int alt33=4;
            switch ( input.LA(1) ) {
            case DOUBLEQUOTE:
                {
                alt33=1;
                }
                break;
            case CONST:
                {
                alt33=2;
                }
                break;
            case MINUS:
            case NUMBER:
            case VAR:
                {
                alt33=3;
                }
                break;
            case SQOPEN:
                {
                alt33=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }

            switch (alt33) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:10: stringterm
                    {
                    pushFollow(FOLLOW_stringterm_in_term1704);
                    stringterm();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:23: function_term
                    {
                    pushFollow(FOLLOW_function_term_in_term1708);
                    function_term();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:39: arithexpr
                    {
                    pushFollow(FOLLOW_arithexpr_in_term1712);
                    arithexpr();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:51: listterm
                    {
                    pushFollow(FOLLOW_listterm_in_term1716);
                    listterm();

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



    // $ANTLR start "function_term"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:161:2: function_term : CONST ( OPEN term ( COMMA term )* CLOSE )? ;
    public final void function_term() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:162:3: ( CONST ( OPEN term ( COMMA term )* CLOSE )? )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:162:5: CONST ( OPEN term ( COMMA term )* CLOSE )?
            {
            match(input,CONST,FOLLOW_CONST_in_function_term1728); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:162:11: ( OPEN term ( COMMA term )* CLOSE )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==OPEN) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:162:12: OPEN term ( COMMA term )* CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_function_term1731); 

                    pushFollow(FOLLOW_term_in_function_term1733);
                    term();

                    state._fsp--;


                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:162:22: ( COMMA term )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==COMMA) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:162:23: COMMA term
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_function_term1736); 

                    	    pushFollow(FOLLOW_term_in_function_term1738);
                    	    term();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    match(input,CLOSE,FOLLOW_CLOSE_in_function_term1742); 

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
    // $ANTLR end "function_term"



    // $ANTLR start "atom_term"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:163:2: atom_term : ( numberstring | var ) ;
    public final void atom_term() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:3: ( ( numberstring | var ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:5: ( numberstring | var )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:5: ( numberstring | var )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==MINUS||LA36_0==NUMBER) ) {
                alt36=1;
            }
            else if ( (LA36_0==VAR) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:6: numberstring
                    {
                    pushFollow(FOLLOW_numberstring_in_atom_term1756);
                    numberstring();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:21: var
                    {
                    pushFollow(FOLLOW_var_in_atom_term1760);
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
    // $ANTLR end "atom_term"



    // $ANTLR start "stringterm"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:2: stringterm : DOUBLEQUOTE word DOUBLEQUOTE ;
    public final void stringterm() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:166:3: ( DOUBLEQUOTE word DOUBLEQUOTE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:166:5: DOUBLEQUOTE word DOUBLEQUOTE
            {
            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1771); 

            pushFollow(FOLLOW_word_in_stringterm1773);
            word();

            state._fsp--;


            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1775); 

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



    // $ANTLR start "var"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:2: var : VAR ;
    public final void var() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:6: ( VAR )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:8: VAR
            {
            match(input,VAR,FOLLOW_VAR_in_var1783); 

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



    // $ANTLR start "numberstring"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:168:2: numberstring : ( MINUS )? ( NUMBER ( STOP NUMBER )? ) ;
    public final void numberstring() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:3: ( ( MINUS )? ( NUMBER ( STOP NUMBER )? ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:6: ( MINUS )? ( NUMBER ( STOP NUMBER )? )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:6: ( MINUS )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==MINUS) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:7: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_numberstring1796); 

                    }
                    break;

            }


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:15: ( NUMBER ( STOP NUMBER )? )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:16: NUMBER ( STOP NUMBER )?
            {
            match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1801); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:23: ( STOP NUMBER )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==STOP) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==NUMBER) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:24: STOP NUMBER
                    {
                    match(input,STOP,FOLLOW_STOP_in_numberstring1804); 

                    match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1806); 

                    }
                    break;

            }


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
    // $ANTLR end "numberstring"



    // $ANTLR start "arithexpr"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:171:2: arithexpr : multexpr ( addoper multexpr )? ;
    public final void arithexpr() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:3: ( multexpr ( addoper multexpr )? )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:5: multexpr ( addoper multexpr )?
            {
            pushFollow(FOLLOW_multexpr_in_arithexpr1822);
            multexpr();

            state._fsp--;


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:14: ( addoper multexpr )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==MINUS||LA39_0==PLUS) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:15: addoper multexpr
                    {
                    pushFollow(FOLLOW_addoper_in_arithexpr1825);
                    addoper();

                    state._fsp--;


                    pushFollow(FOLLOW_multexpr_in_arithexpr1827);
                    multexpr();

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
    // $ANTLR end "arithexpr"



    // $ANTLR start "multexpr"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:1: multexpr : atom_term ( multoper atom_term )? ;
    public final void multexpr() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:9: ( atom_term ( multoper atom_term )? )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:11: atom_term ( multoper atom_term )?
            {
            pushFollow(FOLLOW_atom_term_in_multexpr1835);
            atom_term();

            state._fsp--;


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:21: ( multoper atom_term )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==DIV||LA40_0==MULT) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:22: multoper atom_term
                    {
                    pushFollow(FOLLOW_multoper_in_multexpr1838);
                    multoper();

                    state._fsp--;


                    pushFollow(FOLLOW_atom_term_in_multexpr1840);
                    atom_term();

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
    // $ANTLR end "multexpr"



    // $ANTLR start "word"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:3: word : ( CONST | VAR | NUMBER )* ;
    public final void word() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:8: ( ( CONST | VAR | NUMBER )* )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:10: ( CONST | VAR | NUMBER )*
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:10: ( CONST | VAR | NUMBER )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==CONST||LA41_0==NUMBER||LA41_0==VAR) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
            	    {
            	    if ( input.LA(1)==CONST||input.LA(1)==NUMBER||input.LA(1)==VAR ) {
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
            	    break loop41;
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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:176:2: listterm : SQOPEN ( term ( COMMA term )* ( BAR VAR )? )? SQCLOSE ;
    public final void listterm() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:177:3: ( SQOPEN ( term ( COMMA term )* ( BAR VAR )? )? SQCLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:177:5: SQOPEN ( term ( COMMA term )* ( BAR VAR )? )? SQCLOSE
            {
            match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm1874); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:177:12: ( term ( COMMA term )* ( BAR VAR )? )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==CONST||LA44_0==DOUBLEQUOTE||LA44_0==MINUS||LA44_0==NUMBER||LA44_0==SQOPEN||LA44_0==VAR) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:177:13: term ( COMMA term )* ( BAR VAR )?
                    {
                    pushFollow(FOLLOW_term_in_listterm1877);
                    term();

                    state._fsp--;


                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:177:18: ( COMMA term )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==COMMA) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:177:19: COMMA term
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_listterm1880); 

                    	    pushFollow(FOLLOW_term_in_listterm1882);
                    	    term();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:177:32: ( BAR VAR )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==BAR) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:177:33: BAR VAR
                            {
                            match(input,BAR,FOLLOW_BAR_in_listterm1887); 

                            match(input,VAR,FOLLOW_VAR_in_listterm1889); 

                            }
                            break;

                    }


                    }
                    break;

            }


            match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm1896); 

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



    // $ANTLR start "addoper"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:179:2: addoper : ( PLUS | MINUS ) ;
    public final void addoper() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:179:9: ( ( PLUS | MINUS ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
            {
            if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "addoper"



    // $ANTLR start "multoper"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:2: multoper : ( MULT | DIV ) ;
    public final void multoper() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:181:3: ( ( MULT | DIV ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
            {
            if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "multoper"



    // $ANTLR start "eqoper"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:2: eqoper : ( LESS | EQUALS ) ;
    public final void eqoper() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:9: ( ( LESS | EQUALS ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
            {
            if ( input.LA(1)==EQUALS||input.LA(1)==LESS ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "eqoper"

    // Delegated rules


 

    public static final BitSet FOLLOW_MAIN_in_program94 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_program96 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_id_in_program100 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program102 = new BitSet(new long[]{0x0000000211000100L});
    public static final BitSet FOLLOW_KNOWLEDGE_in_program146 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program148 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_krspec_in_program150 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program152 = new BitSet(new long[]{0x0000000201000100L});
    public static final BitSet FOLLOW_BELIEFS_in_program197 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program199 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_krspec_in_program201 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program203 = new BitSet(new long[]{0x0000000201000000L});
    public static final BitSet FOLLOW_GOALS_in_program248 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program250 = new BitSet(new long[]{0x0080008400006000L});
    public static final BitSet FOLLOW_poslitconj_in_program252 = new BitSet(new long[]{0x0080008400006000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program255 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_MAIN_in_program300 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_MODULE_in_program302 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program304 = new BitSet(new long[]{0x0000200011000000L});
    public static final BitSet FOLLOW_module_in_program306 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program308 = new BitSet(new long[]{0x0000000000404010L});
    public static final BitSet FOLLOW_EVENT_in_program352 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_MODULE_in_program354 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program356 = new BitSet(new long[]{0x0000200011000000L});
    public static final BitSet FOLLOW_module_in_program358 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program360 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ACTIONSPEC_in_program406 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program408 = new BitSet(new long[]{0x0082000008122020L});
    public static final BitSet FOLLOW_actionspec_in_program410 = new BitSet(new long[]{0x0082000008126020L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program413 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KNOWLEDGE_in_module598 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module600 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_krspec_in_module602 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module604 = new BitSet(new long[]{0x0000200001000000L});
    public static final BitSet FOLLOW_GOALS_in_module638 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module640 = new BitSet(new long[]{0x0080008400006000L});
    public static final BitSet FOLLOW_poslitconj_in_module642 = new BitSet(new long[]{0x0080008400006000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module645 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_PROGRAM_in_module678 = new BitSet(new long[]{0x0008000000008000L});
    public static final BitSet FOLLOW_optionorder_in_module681 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module685 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_macro_in_module720 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_actionrule_in_module756 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module788 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ACTIONSPEC_in_module820 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module822 = new BitSet(new long[]{0x0082000008122020L});
    public static final BitSet FOLLOW_actionspec_in_module824 = new BitSet(new long[]{0x0082000008126020L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_brule_in_krspec866 = new BitSet(new long[]{0x0080008400002002L});
    public static final BitSet FOLLOW_atom_in_brule875 = new BitSet(new long[]{0x0010400000000000L});
    public static final BitSet FOLLOW_STOP_in_brule878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROLOGARROW_in_brule882 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_brule884 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_STOP_in_brule886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_poslitconj936 = new BitSet(new long[]{0x0010000000000800L});
    public static final BitSet FOLLOW_COMMA_in_poslitconj939 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_atom_in_poslitconj941 = new BitSet(new long[]{0x0010000000000800L});
    public static final BitSet FOLLOW_STOP_in_poslitconj945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_litconj953 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_litconj956 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_literal_in_litconj958 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_atom_in_literal969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_literal973 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_literal975 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_atom_in_literal977 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_literal979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_atom988 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_parameters_in_atom992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equation_in_atom998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_parameters1007 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_parameters1009 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_COMMA_in_parameters1012 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_parameters1014 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_CLOSE_in_parameters1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQOPEN_in_optionorder1027 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ORDER_in_optionorder1029 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_EQUALS_in_optionorder1031 = new BitSet(new long[]{0x00018000C0000000L});
    public static final BitSet FOLLOW_set_in_optionorder1033 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_optionorder1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HASH_in_macro1059 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DEFINE_in_macro1061 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_id_in_macro1063 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_parameters_in_macro1065 = new BitSet(new long[]{0x0040004000800080L});
    public static final BitSet FOLLOW_mentalstatecond_in_macro1067 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_STOP_in_macro1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_actionrule1080 = new BitSet(new long[]{0x00C0004000802080L});
    public static final BitSet FOLLOW_mentalstatecond_in_actionrule1083 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_id_in_actionrule1087 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_parameters_in_actionrule1089 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_THEN_in_actionrule1092 = new BitSet(new long[]{0x0082000008122020L});
    public static final BitSet FOLLOW_actioncombo_in_actionrule1094 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_STOP_in_actionrule1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond1106 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_mentalstatecond1109 = new BitSet(new long[]{0x0040004000800080L});
    public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond1111 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_TRUE_in_mentalliteral1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mentalatom_in_mentalliteral1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_mentalliteral1132 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_mentalliteral1134 = new BitSet(new long[]{0x0000000000800080L});
    public static final BitSet FOLLOW_mentalatom_in_mentalliteral1136 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_mentalliteral1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BEL_in_mentalatom1148 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_mentalatom1150 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_mentalatom1152 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_mentalatom1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GOAL_in_mentalatom1158 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_mentalatom1160 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_mentalatom1162 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_mentalatom1164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_actionspec1173 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1175 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_PRE_in_actionspec1177 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1179 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_actionspec1181 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1183 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_POST_in_actionspec1185 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1187 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_actionspec1189 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1191 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_actioncombo1202 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_PLUS_in_actioncombo1205 = new BitSet(new long[]{0x0082000008122020L});
    public static final BitSet FOLLOW_action_in_actioncombo1207 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_userdefaction_in_action1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_builtinaction_in_action1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_communication_in_action1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_userdefaction1235 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_parameters_in_userdefaction1238 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_INSERT_in_builtinaction1250 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1252 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1254 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_builtinaction1262 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1264 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1266 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADOPT_in_builtinaction1275 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1277 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1279 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_builtinaction1288 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1290 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1292 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEND_in_communication1306 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_communication1308 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_id_in_communication1310 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COMMA_in_communication1312 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_poslitconj_in_communication1314 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_communication1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_id1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_id1375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithexpr_in_equation1691 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_eqoper_in_equation1693 = new BitSet(new long[]{0x0080008400000000L});
    public static final BitSet FOLLOW_arithexpr_in_equation1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringterm_in_term1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_term_in_term1708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithexpr_in_term1712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listterm_in_term1716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_function_term1728 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_OPEN_in_function_term1731 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_function_term1733 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_COMMA_in_function_term1736 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_function_term1738 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_CLOSE_in_function_term1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numberstring_in_atom_term1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_atom_term1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1771 = new BitSet(new long[]{0x0080008000082000L});
    public static final BitSet FOLLOW_word_in_stringterm1773 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_var1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_numberstring1796 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring1801 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_STOP_in_numberstring1804 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr1822 = new BitSet(new long[]{0x0000040400000002L});
    public static final BitSet FOLLOW_addoper_in_arithexpr1825 = new BitSet(new long[]{0x0080008400000000L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr1827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_term_in_multexpr1835 = new BitSet(new long[]{0x0000001000040002L});
    public static final BitSet FOLLOW_multoper_in_multexpr1838 = new BitSet(new long[]{0x0080008400000000L});
    public static final BitSet FOLLOW_atom_term_in_multexpr1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQOPEN_in_listterm1874 = new BitSet(new long[]{0x008C008400082000L});
    public static final BitSet FOLLOW_term_in_listterm1877 = new BitSet(new long[]{0x0004000000000840L});
    public static final BitSet FOLLOW_COMMA_in_listterm1880 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_listterm1882 = new BitSet(new long[]{0x0004000000000840L});
    public static final BitSet FOLLOW_BAR_in_listterm1887 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_VAR_in_listterm1889 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_listterm1896 = new BitSet(new long[]{0x0000000000000002L});

}