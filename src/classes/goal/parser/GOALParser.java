// $ANTLR 3.4 /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2013-11-01 16:17:40

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
    public String getGrammarFileName() { return "/Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g"; }


    	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
    	private String name = "";



    // $ANTLR start "program"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:49:1: program returns [Abstract_MAS mas] : MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gl] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? CURLYCLOSE ;
    public final Abstract_MAS program() throws RecognitionException {
        Abstract_MAS mas = null;


        String i =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:49:36: ( MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gl] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? CURLYCLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:49:39: MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gl] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? CURLYCLOSE
            {
            mas = new Abstract_MAS(); ArrayList<Abstract_GOALAgent> agents = new ArrayList<Abstract_GOALAgent>();

            match(input,MAIN,FOLLOW_MAIN_in_program94); 

            match(input,COLON,FOLLOW_COLON_in_program96); 

            pushFollow(FOLLOW_id_in_program100);
            i=id();

            state._fsp--;


            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program102); 

             Abstract_GOALAgent gl = new Abstract_GOALAgent(i); agents.add(gl);

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:52:20: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==KNOWLEDGE) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:52:21: KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE
                    {
                    match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_program129); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program131); 

                    pushFollow(FOLLOW_krspec_in_program133);
                    krspec(gl);

                    state._fsp--;


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program136); 

                    }
                    break;

            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:41: ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==BELIEFS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:42: BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE
                    {
                    match(input,BELIEFS,FOLLOW_BELIEFS_in_program181); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program183); 

                    pushFollow(FOLLOW_brspec_in_program185);
                    brspec(gl);

                    state._fsp--;


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program188); 

                    }
                    break;

            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:54:41: ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==GOALS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:54:42: GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE
                    {
                    match(input,GOALS,FOLLOW_GOALS_in_program233); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program235); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:54:58: ( poslitconj )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==CONST||LA3_0==MINUS||LA3_0==NUMBER||LA3_0==VAR) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:54:58: poslitconj
                    	    {
                    	    pushFollow(FOLLOW_poslitconj_in_program237);
                    	    poslitconj();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program240); 

                    }
                    break;

            }


            match(input,MAIN,FOLLOW_MAIN_in_program285); 

            match(input,MODULE,FOLLOW_MODULE_in_program287); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program289); 

            pushFollow(FOLLOW_module_in_program291);
            module(gl);

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program294); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:56:42: ( EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==EVENT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:56:43: EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE
                    {
                    match(input,EVENT,FOLLOW_EVENT_in_program338); 

                    match(input,MODULE,FOLLOW_MODULE_in_program340); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program342); 

                    pushFollow(FOLLOW_module_in_program344);
                    module(gl);

                    state._fsp--;


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program347); 

                    }
                    break;

            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:42: ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ACTIONSPEC) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:43: ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE
                    {
                    match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_program393); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program395); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:64: ( actionspec )+
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
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:64: actionspec
                    	    {
                    	    pushFollow(FOLLOW_actionspec_in_program397);
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


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program400); 

                    }
                    break;

            }


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program492); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:1: module[Abstract_GOALAgent gl] : ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? ;
    public final void module(Abstract_GOALAgent gl) throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:31: ( ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:33: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )?
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:33: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==KNOWLEDGE) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:34: KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE
                    {
                    match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_module585); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module587); 

                    pushFollow(FOLLOW_krspec_in_module589);
                    krspec(gl);

                    state._fsp--;


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module592); 

                    }
                    break;

            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:30: ( GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==GOALS) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:31: GOALS CURLYOPEN ( poslitconj )* CURLYCLOSE
                    {
                    match(input,GOALS,FOLLOW_GOALS_in_module626); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module628); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:47: ( poslitconj )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==CONST||LA9_0==MINUS||LA9_0==NUMBER||LA9_0==VAR) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:47: poslitconj
                    	    {
                    	    pushFollow(FOLLOW_poslitconj_in_module630);
                    	    poslitconj();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module633); 

                    }
                    break;

            }


            match(input,PROGRAM,FOLLOW_PROGRAM_in_module666); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:64:38: ( optionorder )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==SQOPEN) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:64:39: optionorder
                    {
                    pushFollow(FOLLOW_optionorder_in_module669);
                    optionorder();

                    state._fsp--;


                    }
                    break;

            }


            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module673); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:34: ( macro )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==HASH) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:34: macro
            	    {
            	    pushFollow(FOLLOW_macro_in_module708);
            	    macro();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:34: ( actionrule )+
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
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:34: actionrule
            	    {
            	    pushFollow(FOLLOW_actionrule_in_module744);
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


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module776); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:30: ( ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ACTIONSPEC) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:31: ACTIONSPEC CURLYOPEN ( actionspec )+ CURLYCLOSE
                    {
                    match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_module808); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module810); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:52: ( actionspec )+
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
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:52: actionspec
                    	    {
                    	    pushFollow(FOLLOW_actionspec_in_module812);
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


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module815); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:1: krspec[Abstract_GOALAgent gl] : (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ ;
    public final void krspec(Abstract_GOALAgent gl) throws RecognitionException {
        Abstract_GBelief hd =null;

        Abstract_LogicalFormula body =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:30: ( (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:33: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:33: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==CONST||LA17_0==MINUS||LA17_0==NUMBER||LA17_0==VAR) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:34: hd= atom ( STOP | PROLOGARROW body= litconj STOP )
            	    {
            	    pushFollow(FOLLOW_atom_in_krspec858);
            	    hd=atom();

            	    state._fsp--;


            	    hd.setCategory(Abstract_BaseAILStructure.AILBel);

            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:71:2: ( STOP | PROLOGARROW body= litconj STOP )
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
            	            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:71:3: STOP
            	            {
            	            match(input,STOP,FOLLOW_STOP_in_krspec865); 

            	            gl.addFact(hd);

            	            }
            	            break;
            	        case 2 :
            	            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:2: PROLOGARROW body= litconj STOP
            	            {
            	            match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_krspec873); 

            	            pushFollow(FOLLOW_litconj_in_krspec877);
            	            body=litconj();

            	            state._fsp--;


            	            match(input,STOP,FOLLOW_STOP_in_krspec879); 

            	            gl.addKRule(new Abstract_Rule(hd, body));

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
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



    // $ANTLR start "brspec"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:1: brspec[Abstract_GOALAgent gl] : (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ ;
    public final void brspec(Abstract_GOALAgent gl) throws RecognitionException {
        Abstract_GBelief hd =null;

        Abstract_LogicalFormula body =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:30: ( (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:33: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:33: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==CONST||LA19_0==MINUS||LA19_0==NUMBER||LA19_0==VAR) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:34: hd= atom ( STOP | PROLOGARROW body= litconj STOP )
            	    {
            	    pushFollow(FOLLOW_atom_in_brspec900);
            	    hd=atom();

            	    state._fsp--;


            	    hd.setCategory(Abstract_BaseAILStructure.AILBel);

            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:2: ( STOP | PROLOGARROW body= litconj STOP )
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==STOP) ) {
            	        alt18=1;
            	    }
            	    else if ( (LA18_0==PROLOGARROW) ) {
            	        alt18=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:3: STOP
            	            {
            	            match(input,STOP,FOLLOW_STOP_in_brspec908); 

            	            gl.addBel(hd);

            	            }
            	            break;
            	        case 2 :
            	            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:2: PROLOGARROW body= litconj STOP
            	            {
            	            match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_brspec916); 

            	            pushFollow(FOLLOW_litconj_in_brspec920);
            	            body=litconj();

            	            state._fsp--;


            	            match(input,STOP,FOLLOW_STOP_in_brspec922); 

            	            gl.addRule(new Abstract_Rule(hd, body));

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
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
    // $ANTLR end "brspec"



    // $ANTLR start "poslitconj"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:1: poslitconj : atom ( COMMA atom )* STOP ;
    public final void poslitconj() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:12: ( atom ( COMMA atom )* STOP )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:14: atom ( COMMA atom )* STOP
            {
            pushFollow(FOLLOW_atom_in_poslitconj972);
            atom();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:19: ( COMMA atom )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==COMMA) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:20: COMMA atom
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_poslitconj975); 

            	    pushFollow(FOLLOW_atom_in_poslitconj977);
            	    atom();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            match(input,STOP,FOLLOW_STOP_in_poslitconj981); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:1: litconj returns [Abstract_LogicalFormula f] : l= literal ( COMMA l1= literal )* ;
    public final Abstract_LogicalFormula litconj() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_LogicalFormula l =null;

        Abstract_LogicalFormula l1 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:44: (l= literal ( COMMA l1= literal )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:46: l= literal ( COMMA l1= literal )*
            {
            pushFollow(FOLLOW_literal_in_litconj994);
            l=literal();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:56: ( COMMA l1= literal )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==COMMA) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:57: COMMA l1= literal
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_litconj997); 

            	    pushFollow(FOLLOW_literal_in_litconj1001);
            	    l1=literal();

            	    state._fsp--;


            	    f = new Abstract_LogExpr(l, Abstract_LogExpr.and, l1);

            	    }
            	    break;

            	default :
            	    break loop21;
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
        return f;
    }
    // $ANTLR end "litconj"



    // $ANTLR start "literal"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:1: literal returns [Abstract_LogicalFormula l] : (a= atom | ( NOT OPEN a1= atom CLOSE ) );
    public final Abstract_LogicalFormula literal() throws RecognitionException {
        Abstract_LogicalFormula l = null;


        Abstract_GBelief a =null;

        Abstract_GBelief a1 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:44: (a= atom | ( NOT OPEN a1= atom CLOSE ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==CONST||LA22_0==MINUS||LA22_0==NUMBER||LA22_0==VAR) ) {
                alt22=1;
            }
            else if ( (LA22_0==NOT) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:46: a= atom
                    {
                    pushFollow(FOLLOW_atom_in_literal1019);
                    a=atom();

                    state._fsp--;


                    l=a;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:62: ( NOT OPEN a1= atom CLOSE )
                    {
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:62: ( NOT OPEN a1= atom CLOSE )
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:63: NOT OPEN a1= atom CLOSE
                    {
                    match(input,NOT,FOLLOW_NOT_in_literal1026); 

                    match(input,OPEN,FOLLOW_OPEN_in_literal1028); 

                    pushFollow(FOLLOW_atom_in_literal1032);
                    a1=atom();

                    state._fsp--;


                    l=new Abstract_LogExpr(Abstract_LogExpr.not, a1);

                    match(input,CLOSE,FOLLOW_CLOSE_in_literal1036); 

                    }


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
        return l;
    }
    // $ANTLR end "literal"



    // $ANTLR start "atom"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:1: atom returns [Abstract_GBelief t] : (s= id (tl= parameters )? |e= equation ) ;
    public final Abstract_GBelief atom() throws RecognitionException {
        Abstract_GBelief t = null;


        String s =null;

        Abstract_Term[] tl =null;

        Abstract_Equation e =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:35: ( (s= id (tl= parameters )? |e= equation ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:37: (s= id (tl= parameters )? |e= equation )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:37: (s= id (tl= parameters )? |e= equation )
            int alt24=2;
            switch ( input.LA(1) ) {
            case CONST:
                {
                alt24=1;
                }
                break;
            case VAR:
                {
                int LA24_2 = input.LA(2);

                if ( (LA24_2==CLOSE||LA24_2==COMMA||LA24_2==CURLYCLOSE||LA24_2==OPEN||LA24_2==PROLOGARROW||LA24_2==STOP) ) {
                    alt24=1;
                }
                else if ( (LA24_2==DIV||LA24_2==EQUALS||LA24_2==LESS||LA24_2==MINUS||LA24_2==MULT||LA24_2==PLUS) ) {
                    alt24=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 2, input);

                    throw nvae;

                }
                }
                break;
            case MINUS:
            case NUMBER:
                {
                alt24=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:38: s= id (tl= parameters )?
                    {
                    pushFollow(FOLLOW_id_in_atom1052);
                    s=id();

                    state._fsp--;


                    Abstract_Predicate p =new Abstract_Predicate(s);

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:93: (tl= parameters )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==OPEN) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:95: tl= parameters
                            {
                            pushFollow(FOLLOW_parameters_in_atom1059);
                            tl=parameters();

                            state._fsp--;


                            p.setTerms(tl); t = new Abstract_GBelief(p);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:161: e= equation
                    {
                    pushFollow(FOLLOW_equation_in_atom1069);
                    e=equation();

                    state._fsp--;


                    t =e;

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
        return t;
    }
    // $ANTLR end "atom"



    // $ANTLR start "parameters"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:1: parameters returns [Abstract_Term[] ts] : OPEN t= term ( COMMA t1= term )* CLOSE ;
    public final Abstract_Term[] parameters() throws RecognitionException {
        Abstract_Term[] ts = null;


        Abstract_Term t =null;

        Abstract_Term t1 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:42: ( OPEN t= term ( COMMA t1= term )* CLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:44: OPEN t= term ( COMMA t1= term )* CLOSE
            {
            match(input,OPEN,FOLLOW_OPEN_in_parameters1084); 

            pushFollow(FOLLOW_term_in_parameters1088);
            t=term();

            state._fsp--;


            ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:2: ( COMMA t1= term )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==COMMA) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:3: COMMA t1= term
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_parameters1095); 

            	    pushFollow(FOLLOW_term_in_parameters1099);
            	    t1=term();

            	    state._fsp--;


            	    tl.add(t1);

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            match(input,CLOSE,FOLLOW_CLOSE_in_parameters1105); 

             ts = (Abstract_Term[]) tl.toArray(new Abstract_Term[0]);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ts;
    }
    // $ANTLR end "parameters"



    // $ANTLR start "optionorder"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:89:1: optionorder : SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE ;
    public final void optionorder() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:89:13: ( SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:89:15: SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE
            {
            match(input,SQOPEN,FOLLOW_SQOPEN_in_optionorder1116); 

            match(input,ORDER,FOLLOW_ORDER_in_optionorder1118); 

            match(input,EQUALS,FOLLOW_EQUALS_in_optionorder1120); 

            if ( (input.LA(1) >= LINEAR && input.LA(1) <= LINEARALL)||(input.LA(1) >= RANDOM && input.LA(1) <= RANDOMALL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,SQCLOSE,FOLLOW_SQCLOSE_in_optionorder1140); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:1: macro : HASH DEFINE id parameters mentalstatecond STOP ;
    public final void macro() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:7: ( HASH DEFINE id parameters mentalstatecond STOP )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:9: HASH DEFINE id parameters mentalstatecond STOP
            {
            match(input,HASH,FOLLOW_HASH_in_macro1148); 

            match(input,DEFINE,FOLLOW_DEFINE_in_macro1150); 

            pushFollow(FOLLOW_id_in_macro1152);
            id();

            state._fsp--;


            pushFollow(FOLLOW_parameters_in_macro1154);
            parameters();

            state._fsp--;


            pushFollow(FOLLOW_mentalstatecond_in_macro1156);
            mentalstatecond();

            state._fsp--;


            match(input,STOP,FOLLOW_STOP_in_macro1158); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:93:1: actionrule : IF ( mentalstatecond | id parameters ) THEN actioncombo STOP ;
    public final void actionrule() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:93:15: ( IF ( mentalstatecond | id parameters ) THEN actioncombo STOP )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:93:17: IF ( mentalstatecond | id parameters ) THEN actioncombo STOP
            {
            match(input,IF,FOLLOW_IF_in_actionrule1169); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:93:20: ( mentalstatecond | id parameters )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==BEL||LA26_0==GOAL||LA26_0==NOT||LA26_0==TRUE) ) {
                alt26=1;
            }
            else if ( (LA26_0==CONST||LA26_0==VAR) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }
            switch (alt26) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:93:21: mentalstatecond
                    {
                    pushFollow(FOLLOW_mentalstatecond_in_actionrule1172);
                    mentalstatecond();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:93:39: id parameters
                    {
                    pushFollow(FOLLOW_id_in_actionrule1176);
                    id();

                    state._fsp--;


                    pushFollow(FOLLOW_parameters_in_actionrule1178);
                    parameters();

                    state._fsp--;


                    }
                    break;

            }


            match(input,THEN,FOLLOW_THEN_in_actionrule1181); 

            pushFollow(FOLLOW_actioncombo_in_actionrule1183);
            actioncombo();

            state._fsp--;


            match(input,STOP,FOLLOW_STOP_in_actionrule1185); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:95:1: mentalstatecond : mentalliteral ( COMMA mentalliteral )* ;
    public final void mentalstatecond() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:96:2: ( mentalliteral ( COMMA mentalliteral )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:96:4: mentalliteral ( COMMA mentalliteral )*
            {
            pushFollow(FOLLOW_mentalliteral_in_mentalstatecond1195);
            mentalliteral();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:96:18: ( COMMA mentalliteral )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==COMMA) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:96:19: COMMA mentalliteral
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_mentalstatecond1198); 

            	    pushFollow(FOLLOW_mentalliteral_in_mentalstatecond1200);
            	    mentalliteral();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:98:1: mentalliteral : ( TRUE | mentalatom | NOT OPEN mentalatom CLOSE );
    public final void mentalliteral() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:2: ( TRUE | mentalatom | NOT OPEN mentalatom CLOSE )
            int alt28=3;
            switch ( input.LA(1) ) {
            case TRUE:
                {
                alt28=1;
                }
                break;
            case BEL:
            case GOAL:
                {
                alt28=2;
                }
                break;
            case NOT:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }

            switch (alt28) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:4: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_mentalliteral1213); 

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:11: mentalatom
                    {
                    pushFollow(FOLLOW_mentalatom_in_mentalliteral1217);
                    mentalatom();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:24: NOT OPEN mentalatom CLOSE
                    {
                    match(input,NOT,FOLLOW_NOT_in_mentalliteral1221); 

                    match(input,OPEN,FOLLOW_OPEN_in_mentalliteral1223); 

                    pushFollow(FOLLOW_mentalatom_in_mentalliteral1225);
                    mentalatom();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_mentalliteral1227); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:101:1: mentalatom : ( BEL OPEN litconj CLOSE | GOAL OPEN litconj CLOSE );
    public final void mentalatom() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:2: ( BEL OPEN litconj CLOSE | GOAL OPEN litconj CLOSE )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==BEL) ) {
                alt29=1;
            }
            else if ( (LA29_0==GOAL) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:4: BEL OPEN litconj CLOSE
                    {
                    match(input,BEL,FOLLOW_BEL_in_mentalatom1237); 

                    match(input,OPEN,FOLLOW_OPEN_in_mentalatom1239); 

                    pushFollow(FOLLOW_litconj_in_mentalatom1241);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1243); 

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:29: GOAL OPEN litconj CLOSE
                    {
                    match(input,GOAL,FOLLOW_GOAL_in_mentalatom1247); 

                    match(input,OPEN,FOLLOW_OPEN_in_mentalatom1249); 

                    pushFollow(FOLLOW_litconj_in_mentalatom1251);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1253); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:1: actionspec : action CURLYOPEN PRE CURLYOPEN litconj CURLYCLOSE POST CURLYOPEN litconj CURLYCLOSE CURLYCLOSE ;
    public final void actionspec() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:11: ( action CURLYOPEN PRE CURLYOPEN litconj CURLYCLOSE POST CURLYOPEN litconj CURLYCLOSE CURLYCLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:13: action CURLYOPEN PRE CURLYOPEN litconj CURLYCLOSE POST CURLYOPEN litconj CURLYCLOSE CURLYCLOSE
            {
            pushFollow(FOLLOW_action_in_actionspec1262);
            action();

            state._fsp--;


            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1264); 

            match(input,PRE,FOLLOW_PRE_in_actionspec1266); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1268); 

            pushFollow(FOLLOW_litconj_in_actionspec1270);
            litconj();

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1272); 

            match(input,POST,FOLLOW_POST_in_actionspec1274); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1276); 

            pushFollow(FOLLOW_litconj_in_actionspec1278);
            litconj();

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1280); 

            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1282); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:1: actioncombo : action ( PLUS action )* ;
    public final void actioncombo() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:2: ( action ( PLUS action )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:4: action ( PLUS action )*
            {
            pushFollow(FOLLOW_action_in_actioncombo1291);
            action();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:11: ( PLUS action )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==PLUS) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:12: PLUS action
            	    {
            	    match(input,PLUS,FOLLOW_PLUS_in_actioncombo1294); 

            	    pushFollow(FOLLOW_action_in_actioncombo1296);
            	    action();

            	    state._fsp--;


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
    // $ANTLR end "actioncombo"



    // $ANTLR start "action"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:1: action : ( userdefaction | builtinaction | communication );
    public final void action() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:8: ( userdefaction | builtinaction | communication )
            int alt31=3;
            switch ( input.LA(1) ) {
            case CONST:
            case VAR:
                {
                alt31=1;
                }
                break;
            case ADOPT:
            case DELETE:
            case DROP:
            case INSERT:
                {
                alt31=2;
                }
                break;
            case SEND:
                {
                alt31=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }

            switch (alt31) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:10: userdefaction
                    {
                    pushFollow(FOLLOW_userdefaction_in_action1307);
                    userdefaction();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:26: builtinaction
                    {
                    pushFollow(FOLLOW_builtinaction_in_action1311);
                    builtinaction();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:42: communication
                    {
                    pushFollow(FOLLOW_communication_in_action1315);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:112:1: userdefaction : id ( parameters )+ ;
    public final void userdefaction() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:2: ( id ( parameters )+ )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:4: id ( parameters )+
            {
            pushFollow(FOLLOW_id_in_userdefaction1324);
            id();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:7: ( parameters )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==OPEN) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:8: parameters
            	    {
            	    pushFollow(FOLLOW_parameters_in_userdefaction1327);
            	    parameters();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:115:1: builtinaction : ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN litconj CLOSE | DROP OPEN litconj CLOSE );
    public final void builtinaction() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:116:2: ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN litconj CLOSE | DROP OPEN litconj CLOSE )
            int alt33=4;
            switch ( input.LA(1) ) {
            case INSERT:
                {
                alt33=1;
                }
                break;
            case DELETE:
                {
                alt33=2;
                }
                break;
            case ADOPT:
                {
                alt33=3;
                }
                break;
            case DROP:
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
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:116:4: INSERT OPEN litconj CLOSE
                    {
                    match(input,INSERT,FOLLOW_INSERT_in_builtinaction1339); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1341); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1343);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1345); 

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:3: DELETE OPEN litconj CLOSE
                    {
                    match(input,DELETE,FOLLOW_DELETE_in_builtinaction1351); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1353); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1355);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1357); 

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:118:4: ADOPT OPEN litconj CLOSE
                    {
                    match(input,ADOPT,FOLLOW_ADOPT_in_builtinaction1364); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1366); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1368);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1370); 

                    }
                    break;
                case 4 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:4: DROP OPEN litconj CLOSE
                    {
                    match(input,DROP,FOLLOW_DROP_in_builtinaction1377); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1379); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1381);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1383); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:1: communication : SEND OPEN id COMMA poslitconj CLOSE ;
    public final void communication() throws RecognitionException {
        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:122:2: ( SEND OPEN id COMMA poslitconj CLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:122:4: SEND OPEN id COMMA poslitconj CLOSE
            {
            match(input,SEND,FOLLOW_SEND_in_communication1395); 

            match(input,OPEN,FOLLOW_OPEN_in_communication1397); 

            pushFollow(FOLLOW_id_in_communication1399);
            id();

            state._fsp--;


            match(input,COMMA,FOLLOW_COMMA_in_communication1401); 

            pushFollow(FOLLOW_poslitconj_in_communication1403);
            poslitconj();

            state._fsp--;


            match(input,CLOSE,FOLLOW_CLOSE_in_communication1405); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:1: id returns [String s] : ( CONST | VAR ) ;
    public final String id() throws RecognitionException {
        String s = null;


        Token CONST1=null;
        Token VAR2=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:23: ( ( CONST | VAR ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:25: ( CONST | VAR )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:25: ( CONST | VAR )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==CONST) ) {
                alt34=1;
            }
            else if ( (LA34_0==VAR) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }
            switch (alt34) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:26: CONST
                    {
                    CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_id1459); 

                    s = CONST1.getText();

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:58: VAR
                    {
                    VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_id1464); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:163:2: equation returns [Abstract_Equation e] : a1= arithexpr i= eqoper a2= arithexpr ;
    public final Abstract_Equation equation() throws RecognitionException {
        Abstract_Equation e = null;


        Abstract_NumberTerm a1 =null;

        int i =0;

        Abstract_NumberTerm a2 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:3: (a1= arithexpr i= eqoper a2= arithexpr )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:5: a1= arithexpr i= eqoper a2= arithexpr
            {
            pushFollow(FOLLOW_arithexpr_in_equation1786);
            a1=arithexpr();

            state._fsp--;


            pushFollow(FOLLOW_eqoper_in_equation1790);
            i=eqoper();

            state._fsp--;


            pushFollow(FOLLOW_arithexpr_in_equation1794);
            a2=arithexpr();

            state._fsp--;


            e = new Abstract_Equation(a1, i, a2);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return e;
    }
    // $ANTLR end "equation"



    // $ANTLR start "term"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:2: term returns [Abstract_Term t] : (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) ;
    public final Abstract_Term term() throws RecognitionException {
        Abstract_Term t = null;


        Abstract_StringTerm st =null;

        Abstract_Term ft =null;

        Abstract_NumberTerm at =null;

        Abstract_ListTermImpl lt =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:33: ( (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:35: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:35: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
            int alt35=4;
            switch ( input.LA(1) ) {
            case DOUBLEQUOTE:
                {
                alt35=1;
                }
                break;
            case CONST:
                {
                alt35=2;
                }
                break;
            case MINUS:
            case NUMBER:
            case VAR:
                {
                alt35=3;
                }
                break;
            case SQOPEN:
                {
                alt35=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }

            switch (alt35) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:36: st= stringterm
                    {
                    pushFollow(FOLLOW_stringterm_in_term1811);
                    st=stringterm();

                    state._fsp--;


                    t = st;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:63: ft= function_term
                    {
                    pushFollow(FOLLOW_function_term_in_term1819);
                    ft=function_term();

                    state._fsp--;


                    t =ft;

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:91: at= arithexpr
                    {
                    pushFollow(FOLLOW_arithexpr_in_term1827);
                    at=arithexpr();

                    state._fsp--;


                    t =at;

                    }
                    break;
                case 4 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:114: lt= listterm
                    {
                    pushFollow(FOLLOW_listterm_in_term1834);
                    lt=listterm();

                    state._fsp--;


                    t =lt;

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
        return t;
    }
    // $ANTLR end "term"



    // $ANTLR start "function_term"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:166:2: function_term returns [Abstract_Term t] : c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? ;
    public final Abstract_Term function_term() throws RecognitionException {
        Abstract_Term t = null;


        Token c=null;
        Abstract_Term t1 =null;

        Abstract_Term t2 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:3: (c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:5: c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
            {
            c=(Token)match(input,CONST,FOLLOW_CONST_in_function_term1854); 

            t=new Abstract_Predicate(c.getText());

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:54: ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==OPEN) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:55: OPEN t1= term ( COMMA t2= term )* CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_function_term1859); 

                    pushFollow(FOLLOW_term_in_function_term1863);
                    t1=term();

                    state._fsp--;


                    ((Abstract_Predicate) t).addTerm(t1);

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:111: ( COMMA t2= term )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==COMMA) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:112: COMMA t2= term
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_function_term1868); 

                    	    pushFollow(FOLLOW_term_in_function_term1872);
                    	    t2=term();

                    	    state._fsp--;


                    	    ((Abstract_Predicate) t).addTerm(t2);

                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    match(input,CLOSE,FOLLOW_CLOSE_in_function_term1878); 

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
        return t;
    }
    // $ANTLR end "function_term"



    // $ANTLR start "atom_term"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:168:2: atom_term returns [Abstract_NumberTerm t] : (n= numberstring |v= var ) ;
    public final Abstract_NumberTerm atom_term() throws RecognitionException {
        Abstract_NumberTerm t = null;


        String n =null;

        Abstract_VarTerm v =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:168:44: ( (n= numberstring |v= var ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:168:46: (n= numberstring |v= var )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:168:46: (n= numberstring |v= var )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==MINUS||LA38_0==NUMBER) ) {
                alt38=1;
            }
            else if ( (LA38_0==VAR) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }
            switch (alt38) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:168:47: n= numberstring
                    {
                    pushFollow(FOLLOW_numberstring_in_atom_term1897);
                    n=numberstring();

                    state._fsp--;


                    t = new Abstract_NumberTermImpl(n);

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:168:108: v= var
                    {
                    pushFollow(FOLLOW_var_in_atom_term1905);
                    v=var();

                    state._fsp--;


                    t = v;

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
        return t;
    }
    // $ANTLR end "atom_term"



    // $ANTLR start "stringterm"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:2: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE w= word DOUBLEQUOTE ;
    public final Abstract_StringTerm stringterm() throws RecognitionException {
        Abstract_StringTerm s = null;


        String w =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:170:3: ( DOUBLEQUOTE w= word DOUBLEQUOTE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:170:5: DOUBLEQUOTE w= word DOUBLEQUOTE
            {
            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1922); 

            pushFollow(FOLLOW_word_in_stringterm1926);
            w=word();

            state._fsp--;


            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1928); 

            s=new Abstract_StringTermImpl(w);

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
    // $ANTLR end "stringterm"



    // $ANTLR start "var"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:171:2: var returns [Abstract_VarTerm v] : VAR ;
    public final Abstract_VarTerm var() throws RecognitionException {
        Abstract_VarTerm v = null;


        Token VAR3=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:171:35: ( VAR )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:171:37: VAR
            {
            VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_var1942); 


            	if (variables.containsKey(VAR3.getText())) {
            		v = variables.get(VAR3.getText());
            		} else {
            		v = new Abstract_VarTerm(VAR3.getText());
            		variables.put(VAR3.getText(), v);
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
        return v;
    }
    // $ANTLR end "var"



    // $ANTLR start "numberstring"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:2: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) ;
    public final String numberstring() throws RecognitionException {
        String s = null;


        Token n1=null;
        Token n2=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:181:3: ( ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:181:5: ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? )
            {
            s = "";

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:181:16: ( MINUS )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==MINUS) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:181:17: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_numberstring1962); 

                    s += "-";

                    }
                    break;

            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:181:38: (n1= NUMBER ( STOP n2= NUMBER )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:181:39: n1= NUMBER ( STOP n2= NUMBER )?
            {
            n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1971); 

            s += n1.getText();

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:37: ( STOP n2= NUMBER )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==STOP) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==NUMBER) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:38: STOP n2= NUMBER
                    {
                    match(input,STOP,FOLLOW_STOP_in_numberstring2012); 

                    s += ".";

                    n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2018); 

                    s += n2.getText();

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
        return s;
    }
    // $ANTLR end "numberstring"



    // $ANTLR start "arithexpr"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:184:1: arithexpr returns [Abstract_NumberTerm ae] : a1= multexpr (i= addoper a2= multexpr )? ;
    public final Abstract_NumberTerm arithexpr() throws RecognitionException {
        Abstract_NumberTerm ae = null;


        Abstract_NumberTerm a1 =null;

        int i =0;

        Abstract_NumberTerm a2 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:3: (a1= multexpr (i= addoper a2= multexpr )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:6: a1= multexpr (i= addoper a2= multexpr )?
            {
            pushFollow(FOLLOW_multexpr_in_arithexpr2072);
            a1=multexpr();

            state._fsp--;


            ae = a1;

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:30: (i= addoper a2= multexpr )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==MINUS||LA41_0==PLUS) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:31: i= addoper a2= multexpr
                    {
                    pushFollow(FOLLOW_addoper_in_arithexpr2079);
                    i=addoper();

                    state._fsp--;


                    pushFollow(FOLLOW_multexpr_in_arithexpr2083);
                    a2=multexpr();

                    state._fsp--;


                    ae = new Abstract_ArithExpr(ae, i, a2);

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
        return ae;
    }
    // $ANTLR end "arithexpr"



    // $ANTLR start "multexpr"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:186:1: multexpr returns [Abstract_NumberTerm ae] : a1= atom_term (i= multoper a2= atom_term )? ;
    public final Abstract_NumberTerm multexpr() throws RecognitionException {
        Abstract_NumberTerm ae = null;


        Abstract_NumberTerm a1 =null;

        int i =0;

        Abstract_NumberTerm a2 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:186:42: (a1= atom_term (i= multoper a2= atom_term )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:186:44: a1= atom_term (i= multoper a2= atom_term )?
            {
            pushFollow(FOLLOW_atom_term_in_multexpr2099);
            a1=atom_term();

            state._fsp--;


            ae = a1;

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:186:68: (i= multoper a2= atom_term )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==DIV||LA42_0==MULT) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:186:69: i= multoper a2= atom_term
                    {
                    pushFollow(FOLLOW_multoper_in_multexpr2105);
                    i=multoper();

                    state._fsp--;


                    pushFollow(FOLLOW_atom_term_in_multexpr2109);
                    a2=atom_term();

                    state._fsp--;


                    ae = new Abstract_ArithExpr(ae, i, a2);

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
        return ae;
    }
    // $ANTLR end "multexpr"



    // $ANTLR start "word"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:1: word returns [String s] : ( CONST | VAR ) ;
    public final String word() throws RecognitionException {
        String s = null;


        Token CONST4=null;
        Token VAR5=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:25: ( ( CONST | VAR ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:27: ( CONST | VAR )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:27: ( CONST | VAR )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==CONST) ) {
                alt43=1;
            }
            else if ( (LA43_0==VAR) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }
            switch (alt43) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:28: CONST
                    {
                    CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_word2126); 

                    s =CONST4.getText();

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:59: VAR
                    {
                    VAR5=(Token)match(input,VAR,FOLLOW_VAR_in_word2132); 

                    s =VAR5.getText();

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
    // $ANTLR end "word"



    // $ANTLR start "listterm"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:191:2: listterm returns [Abstract_ListTermImpl l] : SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE ;
    public final Abstract_ListTermImpl listterm() throws RecognitionException {
        Abstract_ListTermImpl l = null;


        Token v=null;
        Abstract_Term h =null;

        Abstract_Term t =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:3: ( SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:5: SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE
            {
            l = new Abstract_ListTermImpl(); Abstract_ListTerm lrunning = l;

            match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2242); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:193:10: (h= term ( COMMA t= term )* ( BAR v= VAR )? )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==CONST||LA46_0==DOUBLEQUOTE||LA46_0==MINUS||LA46_0==NUMBER||LA46_0==SQOPEN||LA46_0==VAR) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:193:11: h= term ( COMMA t= term )* ( BAR v= VAR )?
                    {
                    pushFollow(FOLLOW_term_in_listterm2247);
                    h=term();

                    state._fsp--;


                    l.addHead(h); l.addTail(new Abstract_ListTermImpl());

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:194:3: ( COMMA t= term )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==COMMA) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:194:4: COMMA t= term
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_listterm2255); 

                    	    pushFollow(FOLLOW_term_in_listterm2259);
                    	    t=term();

                    	    state._fsp--;


                    	    Abstract_ListTerm l2 = new Abstract_ListTermImpl();  l2.addHead(t); l2.addTail(new Abstract_ListTermImpl()); lrunning=l2;

                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);


                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:195:3: ( BAR v= VAR )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==BAR) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:195:4: BAR v= VAR
                            {
                            match(input,BAR,FOLLOW_BAR_in_listterm2269); 

                            v=(Token)match(input,VAR,FOLLOW_VAR_in_listterm2273); 

                            lrunning.addTail(new Abstract_VarTerm(v.getText()));

                            }
                            break;

                    }


                    }
                    break;

            }


            match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2282); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return l;
    }
    // $ANTLR end "listterm"



    // $ANTLR start "addoper"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:2: addoper returns [int i] : ( PLUS | MINUS ) ;
    public final int addoper() throws RecognitionException {
        int i = 0;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:25: ( ( PLUS | MINUS ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:27: ( PLUS | MINUS )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:27: ( PLUS | MINUS )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==PLUS) ) {
                alt47=1;
            }
            else if ( (LA47_0==MINUS) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }
            switch (alt47) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:28: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_addoper2297); 

                    i = 1;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:45: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_addoper2303); 

                    i = 2;

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
        return i;
    }
    // $ANTLR end "addoper"



    // $ANTLR start "multoper"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:198:2: multoper returns [int i] : ( MULT | DIV ) ;
    public final int multoper() throws RecognitionException {
        int i = 0;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:3: ( ( MULT | DIV ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:5: ( MULT | DIV )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:5: ( MULT | DIV )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==MULT) ) {
                alt48=1;
            }
            else if ( (LA48_0==DIV) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }
            switch (alt48) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:6: MULT
                    {
                    match(input,MULT,FOLLOW_MULT_in_multoper2322); 

                    i = 3;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:23: DIV
                    {
                    match(input,DIV,FOLLOW_DIV_in_multoper2328); 

                    i = 4;

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
        return i;
    }
    // $ANTLR end "multoper"



    // $ANTLR start "eqoper"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:2: eqoper returns [int i] : ( LESS | EQUALS ) ;
    public final int eqoper() throws RecognitionException {
        int i = 0;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:25: ( ( LESS | EQUALS ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:27: ( LESS | EQUALS )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:27: ( LESS | EQUALS )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==LESS) ) {
                alt49=1;
            }
            else if ( (LA49_0==EQUALS) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }
            switch (alt49) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:28: LESS
                    {
                    match(input,LESS,FOLLOW_LESS_in_eqoper2345); 

                    i = 1;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:45: EQUALS
                    {
                    match(input,EQUALS,FOLLOW_EQUALS_in_eqoper2351); 

                    i = 2;

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
        return i;
    }
    // $ANTLR end "eqoper"

    // Delegated rules


 

    public static final BitSet FOLLOW_MAIN_in_program94 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_program96 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_id_in_program100 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program102 = new BitSet(new long[]{0x0000000211000100L});
    public static final BitSet FOLLOW_KNOWLEDGE_in_program129 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program131 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_krspec_in_program133 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program136 = new BitSet(new long[]{0x0000000201000100L});
    public static final BitSet FOLLOW_BELIEFS_in_program181 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program183 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_brspec_in_program185 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program188 = new BitSet(new long[]{0x0000000201000000L});
    public static final BitSet FOLLOW_GOALS_in_program233 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program235 = new BitSet(new long[]{0x0080008400006000L});
    public static final BitSet FOLLOW_poslitconj_in_program237 = new BitSet(new long[]{0x0080008400006000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program240 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_MAIN_in_program285 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_MODULE_in_program287 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program289 = new BitSet(new long[]{0x0000200011000000L});
    public static final BitSet FOLLOW_module_in_program291 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program294 = new BitSet(new long[]{0x0000000000404010L});
    public static final BitSet FOLLOW_EVENT_in_program338 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_MODULE_in_program340 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program342 = new BitSet(new long[]{0x0000200011000000L});
    public static final BitSet FOLLOW_module_in_program344 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program347 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ACTIONSPEC_in_program393 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program395 = new BitSet(new long[]{0x0082000008122020L});
    public static final BitSet FOLLOW_actionspec_in_program397 = new BitSet(new long[]{0x0082000008126020L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program400 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KNOWLEDGE_in_module585 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module587 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_krspec_in_module589 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module592 = new BitSet(new long[]{0x0000200001000000L});
    public static final BitSet FOLLOW_GOALS_in_module626 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module628 = new BitSet(new long[]{0x0080008400006000L});
    public static final BitSet FOLLOW_poslitconj_in_module630 = new BitSet(new long[]{0x0080008400006000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module633 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_PROGRAM_in_module666 = new BitSet(new long[]{0x0008000000008000L});
    public static final BitSet FOLLOW_optionorder_in_module669 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module673 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_macro_in_module708 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_actionrule_in_module744 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module776 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ACTIONSPEC_in_module808 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module810 = new BitSet(new long[]{0x0082000008122020L});
    public static final BitSet FOLLOW_actionspec_in_module812 = new BitSet(new long[]{0x0082000008126020L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_krspec858 = new BitSet(new long[]{0x0010400000000000L});
    public static final BitSet FOLLOW_STOP_in_krspec865 = new BitSet(new long[]{0x0080008400002002L});
    public static final BitSet FOLLOW_PROLOGARROW_in_krspec873 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_krspec877 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_STOP_in_krspec879 = new BitSet(new long[]{0x0080008400002002L});
    public static final BitSet FOLLOW_atom_in_brspec900 = new BitSet(new long[]{0x0010400000000000L});
    public static final BitSet FOLLOW_STOP_in_brspec908 = new BitSet(new long[]{0x0080008400002002L});
    public static final BitSet FOLLOW_PROLOGARROW_in_brspec916 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_brspec920 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_STOP_in_brspec922 = new BitSet(new long[]{0x0080008400002002L});
    public static final BitSet FOLLOW_atom_in_poslitconj972 = new BitSet(new long[]{0x0010000000000800L});
    public static final BitSet FOLLOW_COMMA_in_poslitconj975 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_atom_in_poslitconj977 = new BitSet(new long[]{0x0010000000000800L});
    public static final BitSet FOLLOW_STOP_in_poslitconj981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_litconj994 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_litconj997 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_literal_in_litconj1001 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_atom_in_literal1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_literal1026 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_literal1028 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_atom_in_literal1032 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_literal1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_atom1052 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_parameters_in_atom1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equation_in_atom1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_parameters1084 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_parameters1088 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_COMMA_in_parameters1095 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_parameters1099 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_CLOSE_in_parameters1105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQOPEN_in_optionorder1116 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ORDER_in_optionorder1118 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_EQUALS_in_optionorder1120 = new BitSet(new long[]{0x00018000C0000000L});
    public static final BitSet FOLLOW_set_in_optionorder1122 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_optionorder1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HASH_in_macro1148 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DEFINE_in_macro1150 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_id_in_macro1152 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_parameters_in_macro1154 = new BitSet(new long[]{0x0040004000800080L});
    public static final BitSet FOLLOW_mentalstatecond_in_macro1156 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_STOP_in_macro1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_actionrule1169 = new BitSet(new long[]{0x00C0004000802080L});
    public static final BitSet FOLLOW_mentalstatecond_in_actionrule1172 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_id_in_actionrule1176 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_parameters_in_actionrule1178 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_THEN_in_actionrule1181 = new BitSet(new long[]{0x0082000008122020L});
    public static final BitSet FOLLOW_actioncombo_in_actionrule1183 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_STOP_in_actionrule1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond1195 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_mentalstatecond1198 = new BitSet(new long[]{0x0040004000800080L});
    public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond1200 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_TRUE_in_mentalliteral1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mentalatom_in_mentalliteral1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_mentalliteral1221 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_mentalliteral1223 = new BitSet(new long[]{0x0000000000800080L});
    public static final BitSet FOLLOW_mentalatom_in_mentalliteral1225 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_mentalliteral1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BEL_in_mentalatom1237 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_mentalatom1239 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_mentalatom1241 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_mentalatom1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GOAL_in_mentalatom1247 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_mentalatom1249 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_mentalatom1251 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_mentalatom1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_actionspec1262 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1264 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_PRE_in_actionspec1266 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1268 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_actionspec1270 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1272 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_POST_in_actionspec1274 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1276 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_actionspec1278 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1280 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_actioncombo1291 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_PLUS_in_actioncombo1294 = new BitSet(new long[]{0x0082000008122020L});
    public static final BitSet FOLLOW_action_in_actioncombo1296 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_userdefaction_in_action1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_builtinaction_in_action1311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_communication_in_action1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_userdefaction1324 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_parameters_in_userdefaction1327 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_INSERT_in_builtinaction1339 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1341 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1343 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_builtinaction1351 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1353 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1355 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADOPT_in_builtinaction1364 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1366 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1368 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_builtinaction1377 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1379 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1381 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEND_in_communication1395 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_communication1397 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_id_in_communication1399 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COMMA_in_communication1401 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_poslitconj_in_communication1403 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_communication1405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_id1459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_id1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithexpr_in_equation1786 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_eqoper_in_equation1790 = new BitSet(new long[]{0x0080008400000000L});
    public static final BitSet FOLLOW_arithexpr_in_equation1794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringterm_in_term1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_term_in_term1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithexpr_in_term1827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listterm_in_term1834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_function_term1854 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_OPEN_in_function_term1859 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_function_term1863 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_COMMA_in_function_term1868 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_function_term1872 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_CLOSE_in_function_term1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numberstring_in_atom_term1897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_atom_term1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1922 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_word_in_stringterm1926 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_var1942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_numberstring1962 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring1971 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_STOP_in_numberstring2012 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring2018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr2072 = new BitSet(new long[]{0x0000040400000002L});
    public static final BitSet FOLLOW_addoper_in_arithexpr2079 = new BitSet(new long[]{0x0080008400000000L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_term_in_multexpr2099 = new BitSet(new long[]{0x0000001000040002L});
    public static final BitSet FOLLOW_multoper_in_multexpr2105 = new BitSet(new long[]{0x0080008400000000L});
    public static final BitSet FOLLOW_atom_term_in_multexpr2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_word2126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_word2132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQOPEN_in_listterm2242 = new BitSet(new long[]{0x008C008400082000L});
    public static final BitSet FOLLOW_term_in_listterm2247 = new BitSet(new long[]{0x0004000000000840L});
    public static final BitSet FOLLOW_COMMA_in_listterm2255 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_listterm2259 = new BitSet(new long[]{0x0004000000000840L});
    public static final BitSet FOLLOW_BAR_in_listterm2269 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_VAR_in_listterm2273 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_listterm2282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_addoper2297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_addoper2303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULT_in_multoper2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_multoper2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_in_eqoper2345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_eqoper2351 = new BitSet(new long[]{0x0000000000000002L});

}