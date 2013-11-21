// $ANTLR 3.4 /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2013-11-21 15:10:26

package goal.parser;

import ail.syntax.ast.*;
import goal.syntax.ast.*;
import ail.syntax.PredicateIndicator;
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
    	private static HashMap<PredicateIndicator,Abstract_LogicalFormula> macros = new HashMap<PredicateIndicator, Abstract_LogicalFormula>();
    	private static HashMap<PredicateIndicator,Abstract_Term> macro_subs = new HashMap<PredicateIndicator, Abstract_Term>();
    	private String name = "";



    // $ANTLR start "program"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:52:1: program returns [Abstract_MAS mas] : MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gl] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? CURLYCLOSE ;
    public final Abstract_MAS program() throws RecognitionException {
        Abstract_MAS mas = null;


        String i =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:52:36: ( MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gl] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? CURLYCLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:52:39: MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gl] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? CURLYCLOSE
            {
            mas = new Abstract_MAS(); ArrayList<Abstract_GOALAgent> agents = new ArrayList<Abstract_GOALAgent>();

            match(input,MAIN,FOLLOW_MAIN_in_program94); 

            match(input,COLON,FOLLOW_COLON_in_program96); 

            pushFollow(FOLLOW_id_in_program100);
            i=id();

            state._fsp--;


            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program102); 

             Abstract_GOALAgent gl = new Abstract_GOALAgent(i); agents.add(gl);

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:20: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==KNOWLEDGE) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:21: KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE
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


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:56:41: ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==BELIEFS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:56:42: BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE
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


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:41: ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==GOALS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:42: GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE
                    {
                    match(input,GOALS,FOLLOW_GOALS_in_program233); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program235); 

                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:58: ( poslitconj[gl] )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==CONST||LA3_0==MINUS||LA3_0==NUMBER||LA3_0==VAR) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:58: poslitconj[gl]
                    	    {
                    	    pushFollow(FOLLOW_poslitconj_in_program237);
                    	    poslitconj(gl);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program241); 

                    }
                    break;

            }


            match(input,MAIN,FOLLOW_MAIN_in_program286); 

            match(input,MODULE,FOLLOW_MODULE_in_program288); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program290); 

            pushFollow(FOLLOW_module_in_program292);
            module(gl);

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program295); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:59:42: ( EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==EVENT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:59:43: EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE
                    {
                    match(input,EVENT,FOLLOW_EVENT_in_program339); 

                    match(input,MODULE,FOLLOW_MODULE_in_program341); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program343); 

                    pushFollow(FOLLOW_module_in_program345);
                    module(gl);

                    state._fsp--;


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program348); 

                    }
                    break;

            }


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:60:42: ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ACTIONSPEC) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:60:43: ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE
                    {
                    match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_program394); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program396); 

                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:60:64: ( actionspec[gl] )+
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
                    	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:60:64: actionspec[gl]
                    	    {
                    	    pushFollow(FOLLOW_actionspec_in_program398);
                    	    actionspec(gl);

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


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program402); 

                    }
                    break;

            }


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program494); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:1: module[Abstract_GOALAgent gl] : ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule[gl] )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? ;
    public final void module(Abstract_GOALAgent gl) throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:31: ( ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule[gl] )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:33: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule[gl] )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )?
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:33: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==KNOWLEDGE) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:34: KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE
                    {
                    match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_module587); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module589); 

                    pushFollow(FOLLOW_krspec_in_module591);
                    krspec(gl);

                    state._fsp--;


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module594); 

                    }
                    break;

            }


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:30: ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==GOALS) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:31: GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE
                    {
                    match(input,GOALS,FOLLOW_GOALS_in_module628); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module630); 

                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:47: ( poslitconj[gl] )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==CONST||LA9_0==MINUS||LA9_0==NUMBER||LA9_0==VAR) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:47: poslitconj[gl]
                    	    {
                    	    pushFollow(FOLLOW_poslitconj_in_module632);
                    	    poslitconj(gl);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module636); 

                    }
                    break;

            }


            match(input,PROGRAM,FOLLOW_PROGRAM_in_module669); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:38: ( optionorder )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==SQOPEN) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:39: optionorder
                    {
                    pushFollow(FOLLOW_optionorder_in_module672);
                    optionorder();

                    state._fsp--;


                    }
                    break;

            }


            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module676); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:34: ( macro )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==HASH) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:34: macro
            	    {
            	    pushFollow(FOLLOW_macro_in_module711);
            	    macro();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:34: ( actionrule[gl] )+
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
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:34: actionrule[gl]
            	    {
            	    pushFollow(FOLLOW_actionrule_in_module747);
            	    actionrule(gl);

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


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module780); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:71:30: ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ACTIONSPEC) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:71:31: ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE
                    {
                    match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_module812); 

                    match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module814); 

                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:71:52: ( actionspec[gl] )+
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
                    	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:71:52: actionspec[gl]
                    	    {
                    	    pushFollow(FOLLOW_actionspec_in_module816);
                    	    actionspec(gl);

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


                    match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module820); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:1: krspec[Abstract_GOALAgent gl] : (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ ;
    public final void krspec(Abstract_GOALAgent gl) throws RecognitionException {
        Abstract_GBelief hd =null;

        Abstract_LogicalFormula body =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:30: ( (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:33: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:33: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
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
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:34: hd= atom ( STOP | PROLOGARROW body= litconj STOP )
            	    {
            	    pushFollow(FOLLOW_atom_in_krspec863);
            	    hd=atom();

            	    state._fsp--;


            	    hd.setCategory(Abstract_BaseAILStructure.AILBel);

            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:2: ( STOP | PROLOGARROW body= litconj STOP )
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
            	            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:3: STOP
            	            {
            	            match(input,STOP,FOLLOW_STOP_in_krspec870); 

            	            gl.addFact(hd);

            	            }
            	            break;
            	        case 2 :
            	            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:2: PROLOGARROW body= litconj STOP
            	            {
            	            match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_krspec878); 

            	            pushFollow(FOLLOW_litconj_in_krspec882);
            	            body=litconj();

            	            state._fsp--;


            	            match(input,STOP,FOLLOW_STOP_in_krspec884); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:77:1: brspec[Abstract_GOALAgent gl] : (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ ;
    public final void brspec(Abstract_GOALAgent gl) throws RecognitionException {
        Abstract_GBelief hd =null;

        Abstract_LogicalFormula body =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:77:30: ( (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:77:33: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:77:33: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
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
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:77:34: hd= atom ( STOP | PROLOGARROW body= litconj STOP )
            	    {
            	    pushFollow(FOLLOW_atom_in_brspec905);
            	    hd=atom();

            	    state._fsp--;


            	    hd.setCategory(Abstract_BaseAILStructure.AILBel);

            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:2: ( STOP | PROLOGARROW body= litconj STOP )
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
            	            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:3: STOP
            	            {
            	            match(input,STOP,FOLLOW_STOP_in_brspec913); 

            	            gl.addBel(hd);

            	            }
            	            break;
            	        case 2 :
            	            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:79:2: PROLOGARROW body= litconj STOP
            	            {
            	            match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_brspec921); 

            	            pushFollow(FOLLOW_litconj_in_brspec925);
            	            body=litconj();

            	            state._fsp--;


            	            match(input,STOP,FOLLOW_STOP_in_brspec927); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:81:1: poslitconj[Abstract_GOALAgent gl] : g= atom ( COMMA g1= atom )* STOP ;
    public final void poslitconj(Abstract_GOALAgent gl) throws RecognitionException {
        Abstract_GBelief g =null;

        Abstract_GBelief g1 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:81:35: (g= atom ( COMMA g1= atom )* STOP )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:81:37: g= atom ( COMMA g1= atom )* STOP
            {
            pushFollow(FOLLOW_atom_in_poslitconj980);
            g=atom();

            state._fsp--;


            gl.addGoal(g.getContent());

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:81:75: ( COMMA g1= atom )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==COMMA) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:81:76: COMMA g1= atom
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_poslitconj985); 

            	    pushFollow(FOLLOW_atom_in_poslitconj989);
            	    g1=atom();

            	    state._fsp--;


            	    gl.addGoal(g.getContent());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            match(input,STOP,FOLLOW_STOP_in_poslitconj994); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:83:1: litconj returns [Abstract_LogicalFormula f] : l= literal ( COMMA l1= literal )* ;
    public final Abstract_LogicalFormula litconj() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_LogicalFormula l =null;

        Abstract_LogicalFormula l1 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:83:44: (l= literal ( COMMA l1= literal )* )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:83:46: l= literal ( COMMA l1= literal )*
            {
            pushFollow(FOLLOW_literal_in_litconj1007);
            l=literal();

            state._fsp--;


            f = l;

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:83:66: ( COMMA l1= literal )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==COMMA) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:83:67: COMMA l1= literal
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_litconj1012); 

            	    pushFollow(FOLLOW_literal_in_litconj1016);
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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:1: literal returns [Abstract_LogicalFormula l] : (a= atom | ( NOT OPEN a1= atom CLOSE ) );
    public final Abstract_LogicalFormula literal() throws RecognitionException {
        Abstract_LogicalFormula l = null;


        Abstract_GBelief a =null;

        Abstract_GBelief a1 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:44: (a= atom | ( NOT OPEN a1= atom CLOSE ) )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:46: a= atom
                    {
                    pushFollow(FOLLOW_atom_in_literal1034);
                    a=atom();

                    state._fsp--;


                    l=a;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:62: ( NOT OPEN a1= atom CLOSE )
                    {
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:62: ( NOT OPEN a1= atom CLOSE )
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:63: NOT OPEN a1= atom CLOSE
                    {
                    match(input,NOT,FOLLOW_NOT_in_literal1041); 

                    match(input,OPEN,FOLLOW_OPEN_in_literal1043); 

                    pushFollow(FOLLOW_atom_in_literal1047);
                    a1=atom();

                    state._fsp--;


                    l=new Abstract_LogExpr(Abstract_LogExpr.not, a1);

                    match(input,CLOSE,FOLLOW_CLOSE_in_literal1051); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:1: atom returns [Abstract_GBelief t] : (s= id (tl= parameters )? |e= equation ) ;
    public final Abstract_GBelief atom() throws RecognitionException {
        Abstract_GBelief t = null;


        String s =null;

        Abstract_Term[] tl =null;

        Abstract_Equation e =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:35: ( (s= id (tl= parameters )? |e= equation ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:37: (s= id (tl= parameters )? |e= equation )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:37: (s= id (tl= parameters )? |e= equation )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:38: s= id (tl= parameters )?
                    {
                    pushFollow(FOLLOW_id_in_atom1067);
                    s=id();

                    state._fsp--;


                    Abstract_Predicate p =new Abstract_Predicate(s);

                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:93: (tl= parameters )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==OPEN) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:95: tl= parameters
                            {
                            pushFollow(FOLLOW_parameters_in_atom1074);
                            tl=parameters();

                            state._fsp--;


                            p.setTerms(tl); t = new Abstract_GBelief(p);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:161: e= equation
                    {
                    pushFollow(FOLLOW_equation_in_atom1084);
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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:89:1: parameters returns [Abstract_Term[] ts] : OPEN t= term ( COMMA t1= term )* CLOSE ;
    public final Abstract_Term[] parameters() throws RecognitionException {
        Abstract_Term[] ts = null;


        Abstract_Term t =null;

        Abstract_Term t1 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:89:42: ( OPEN t= term ( COMMA t1= term )* CLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:89:44: OPEN t= term ( COMMA t1= term )* CLOSE
            {
            match(input,OPEN,FOLLOW_OPEN_in_parameters1099); 

            pushFollow(FOLLOW_term_in_parameters1103);
            t=term();

            state._fsp--;


            ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:2: ( COMMA t1= term )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==COMMA) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:3: COMMA t1= term
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_parameters1110); 

            	    pushFollow(FOLLOW_term_in_parameters1114);
            	    t1=term();

            	    state._fsp--;


            	    tl.add(t1);

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            match(input,CLOSE,FOLLOW_CLOSE_in_parameters1120); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:92:1: optionorder : SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE ;
    public final void optionorder() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:92:13: ( SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:92:15: SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE
            {
            match(input,SQOPEN,FOLLOW_SQOPEN_in_optionorder1131); 

            match(input,ORDER,FOLLOW_ORDER_in_optionorder1133); 

            match(input,EQUALS,FOLLOW_EQUALS_in_optionorder1135); 

            if ( (input.LA(1) >= LINEAR && input.LA(1) <= LINEARALL)||(input.LA(1) >= RANDOM && input.LA(1) <= RANDOMALL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,SQCLOSE,FOLLOW_SQCLOSE_in_optionorder1155); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:1: macro : HASH DEFINE f= id pl= parameters msc= mentalstatecond STOP ;
    public final void macro() throws RecognitionException {
        String f =null;

        Abstract_Term[] pl =null;

        Abstract_LogicalFormula msc =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:7: ( HASH DEFINE f= id pl= parameters msc= mentalstatecond STOP )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:9: HASH DEFINE f= id pl= parameters msc= mentalstatecond STOP
            {
            match(input,HASH,FOLLOW_HASH_in_macro1163); 

            match(input,DEFINE,FOLLOW_DEFINE_in_macro1165); 

            pushFollow(FOLLOW_id_in_macro1169);
            f=id();

            state._fsp--;


            pushFollow(FOLLOW_parameters_in_macro1173);
            pl=parameters();

            state._fsp--;


            pushFollow(FOLLOW_mentalstatecond_in_macro1177);
            msc=mentalstatecond();

            state._fsp--;


            PredicateIndicator pi = new PredicateIndicator(f, pl.length); macros.put(pi, msc); 
                                              Abstract_Predicate p = new Abstract_Predicate(f); p.setTerms(pl); macro_subs.put(pi, p);

            match(input,STOP,FOLLOW_STOP_in_macro1181); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:1: actionrule[Abstract_GOALAgent gl] : IF (lf= mentalstatecond |f= id pl= parameters ) THEN dl= actioncombo[gl] STOP ;
    public final void actionrule(Abstract_GOALAgent gl) throws RecognitionException {
        Abstract_LogicalFormula lf =null;

        String f =null;

        Abstract_Term[] pl =null;

        ArrayList<Abstract_Deed> dl =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:38: ( IF (lf= mentalstatecond |f= id pl= parameters ) THEN dl= actioncombo[gl] STOP )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:40: IF (lf= mentalstatecond |f= id pl= parameters ) THEN dl= actioncombo[gl] STOP
            {
            Abstract_ActionRule rule = new Abstract_ActionRule();

            match(input,IF,FOLLOW_IF_in_actionrule1197); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:98:5: (lf= mentalstatecond |f= id pl= parameters )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:98:6: lf= mentalstatecond
                    {
                    pushFollow(FOLLOW_mentalstatecond_in_actionrule1202);
                    lf=mentalstatecond();

                    state._fsp--;


                    rule.setMentalStateCond(lf);

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:4: f= id pl= parameters
                    {
                    pushFollow(FOLLOW_id_in_actionrule1212);
                    f=id();

                    state._fsp--;


                    pushFollow(FOLLOW_parameters_in_actionrule1216);
                    pl=parameters();

                    state._fsp--;


                    PredicateIndicator pi = new PredicateIndicator(f, pl.length); Abstract_LogicalFormula macro=macros.get(pi); Abstract_Term sub=macro_subs.get(pi); Abstract_Unifier u=rule.getUnifier(f, pl, sub); Abstract_LogicalFormula k = macro.apply(u); rule.setMentalStateCond(k);

                    }
                    break;

            }


            match(input,THEN,FOLLOW_THEN_in_actionrule1224); 

            pushFollow(FOLLOW_actioncombo_in_actionrule1228);
            dl=actioncombo(gl);

            state._fsp--;


            rule.setBody(dl);

            match(input,STOP,FOLLOW_STOP_in_actionrule1233); 

            gl.addPlan(rule);

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:1: mentalstatecond returns [Abstract_LogicalFormula lf] : ml= mentalliteral ( COMMA ml2= mentalliteral )* ;
    public final Abstract_LogicalFormula mentalstatecond() throws RecognitionException {
        Abstract_LogicalFormula lf = null;


        Abstract_LogicalFormula ml =null;

        Abstract_LogicalFormula ml2 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:103:2: (ml= mentalliteral ( COMMA ml2= mentalliteral )* )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:103:4: ml= mentalliteral ( COMMA ml2= mentalliteral )*
            {
            pushFollow(FOLLOW_mentalliteral_in_mentalstatecond1251);
            ml=mentalliteral();

            state._fsp--;


            lf = ml;

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:103:33: ( COMMA ml2= mentalliteral )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==COMMA) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:103:34: COMMA ml2= mentalliteral
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_mentalstatecond1256); 

            	    pushFollow(FOLLOW_mentalliteral_in_mentalstatecond1260);
            	    ml2=mentalliteral();

            	    state._fsp--;


            	    ml = new Abstract_LogExpr(ml, Abstract_LogExpr.and, ml2); lf = ml;

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
        return lf;
    }
    // $ANTLR end "mentalstatecond"



    // $ANTLR start "mentalliteral"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:1: mentalliteral returns [Abstract_LogicalFormula lf] : ( TRUE |ma= mentalatom | NOT OPEN nma= mentalatom CLOSE );
    public final Abstract_LogicalFormula mentalliteral() throws RecognitionException {
        Abstract_LogicalFormula lf = null;


        Abstract_LogicalFormula ma =null;

        Abstract_LogicalFormula nma =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:106:2: ( TRUE |ma= mentalatom | NOT OPEN nma= mentalatom CLOSE )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:106:4: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_mentalliteral1279); 

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:106:11: ma= mentalatom
                    {
                    pushFollow(FOLLOW_mentalatom_in_mentalliteral1285);
                    ma=mentalatom();

                    state._fsp--;


                    lf = ma;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:106:39: NOT OPEN nma= mentalatom CLOSE
                    {
                    match(input,NOT,FOLLOW_NOT_in_mentalliteral1291); 

                    match(input,OPEN,FOLLOW_OPEN_in_mentalliteral1293); 

                    pushFollow(FOLLOW_mentalatom_in_mentalliteral1297);
                    nma=mentalatom();

                    state._fsp--;


                    lf = new Abstract_LogExpr(Abstract_LogExpr.not, nma);

                    match(input,CLOSE,FOLLOW_CLOSE_in_mentalliteral1301); 

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
        return lf;
    }
    // $ANTLR end "mentalliteral"



    // $ANTLR start "mentalatom"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:1: mentalatom returns [Abstract_LogicalFormula lf] : ( BEL OPEN b= litconj CLOSE | GOAL OPEN g= litconj CLOSE );
    public final Abstract_LogicalFormula mentalatom() throws RecognitionException {
        Abstract_LogicalFormula lf = null;


        Abstract_LogicalFormula b =null;

        Abstract_LogicalFormula g =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:109:2: ( BEL OPEN b= litconj CLOSE | GOAL OPEN g= litconj CLOSE )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:109:4: BEL OPEN b= litconj CLOSE
                    {
                    match(input,BEL,FOLLOW_BEL_in_mentalatom1315); 

                    match(input,OPEN,FOLLOW_OPEN_in_mentalatom1317); 

                    pushFollow(FOLLOW_litconj_in_mentalatom1321);
                    b=litconj();

                    state._fsp--;


                    b.setCategory(Abstract_BaseAILStructure.AILBel); lf = b;

                    match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1326); 

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:109:92: GOAL OPEN g= litconj CLOSE
                    {
                    match(input,GOAL,FOLLOW_GOAL_in_mentalatom1330); 

                    match(input,OPEN,FOLLOW_OPEN_in_mentalatom1332); 

                    pushFollow(FOLLOW_litconj_in_mentalatom1336);
                    g=litconj();

                    state._fsp--;


                    g.setCategory(Abstract_BaseAILStructure.AILGoal); lf = g;

                    match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1339); 

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
        return lf;
    }
    // $ANTLR end "mentalatom"



    // $ANTLR start "actionspec"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:112:1: actionspec[Abstract_GOALAgent gl] : action[gl] CURLYOPEN PRE CURLYOPEN litconj CURLYCLOSE POST CURLYOPEN litconj CURLYCLOSE CURLYCLOSE ;
    public final void actionspec(Abstract_GOALAgent gl) throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:112:34: ( action[gl] CURLYOPEN PRE CURLYOPEN litconj CURLYCLOSE POST CURLYOPEN litconj CURLYCLOSE CURLYCLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:112:36: action[gl] CURLYOPEN PRE CURLYOPEN litconj CURLYCLOSE POST CURLYOPEN litconj CURLYCLOSE CURLYCLOSE
            {
            pushFollow(FOLLOW_action_in_actionspec1349);
            action(gl);

            state._fsp--;


            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1352); 

            match(input,PRE,FOLLOW_PRE_in_actionspec1354); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1356); 

            pushFollow(FOLLOW_litconj_in_actionspec1358);
            litconj();

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1360); 

            match(input,POST,FOLLOW_POST_in_actionspec1362); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1364); 

            pushFollow(FOLLOW_litconj_in_actionspec1366);
            litconj();

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1368); 

            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1370); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:114:1: actioncombo[Abstract_GOALAgent gl] returns [ArrayList<Abstract_Deed> dl] :a= action[gl] ( PLUS a1= action[gl] )* ;
    public final ArrayList<Abstract_Deed> actioncombo(Abstract_GOALAgent gl) throws RecognitionException {
        ArrayList<Abstract_Deed> dl = null;


        Abstract_Deed a =null;

        Abstract_Deed a1 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:115:2: (a= action[gl] ( PLUS a1= action[gl] )* )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:115:4: a= action[gl] ( PLUS a1= action[gl] )*
            {
            dl = new ArrayList<Abstract_Deed>();

            pushFollow(FOLLOW_action_in_actioncombo1388);
            a=action(gl);

            state._fsp--;


            dl.add(a);

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:115:71: ( PLUS a1= action[gl] )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==PLUS) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:115:72: PLUS a1= action[gl]
            	    {
            	    match(input,PLUS,FOLLOW_PLUS_in_actioncombo1394); 

            	    pushFollow(FOLLOW_action_in_actioncombo1398);
            	    a1=action(gl);

            	    state._fsp--;


            	    dl.add(a1);

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
        return dl;
    }
    // $ANTLR end "actioncombo"



    // $ANTLR start "action"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:1: action[Abstract_GOALAgent gl] returns [Abstract_Deed d] : ( userdefaction | builtinaction | communication[gl] ) ;
    public final Abstract_Deed action(Abstract_GOALAgent gl) throws RecognitionException {
        Abstract_Deed d = null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:57: ( ( userdefaction | builtinaction | communication[gl] ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:59: ( userdefaction | builtinaction | communication[gl] )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:59: ( userdefaction | builtinaction | communication[gl] )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:60: userdefaction
                    {
                    pushFollow(FOLLOW_userdefaction_in_action1418);
                    userdefaction();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:76: builtinaction
                    {
                    pushFollow(FOLLOW_builtinaction_in_action1422);
                    builtinaction();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:92: communication[gl]
                    {
                    pushFollow(FOLLOW_communication_in_action1426);
                    communication(gl);

                    state._fsp--;


                    }
                    break;

            }


            d = new Abstract_Deed(Abstract_Deed.DNull);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return d;
    }
    // $ANTLR end "action"



    // $ANTLR start "userdefaction"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:1: userdefaction : id ( parameters )+ ;
    public final void userdefaction() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:2: ( id ( parameters )+ )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:4: id ( parameters )+
            {
            pushFollow(FOLLOW_id_in_userdefaction1439);
            id();

            state._fsp--;


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:7: ( parameters )+
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
            	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:8: parameters
            	    {
            	    pushFollow(FOLLOW_parameters_in_userdefaction1442);
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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:122:1: builtinaction : ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN litconj CLOSE | DROP OPEN litconj CLOSE );
    public final void builtinaction() throws RecognitionException {
        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:2: ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN litconj CLOSE | DROP OPEN litconj CLOSE )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:4: INSERT OPEN litconj CLOSE
                    {
                    match(input,INSERT,FOLLOW_INSERT_in_builtinaction1454); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1456); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1458);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1460); 

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:3: DELETE OPEN litconj CLOSE
                    {
                    match(input,DELETE,FOLLOW_DELETE_in_builtinaction1466); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1468); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1470);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1472); 

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:4: ADOPT OPEN litconj CLOSE
                    {
                    match(input,ADOPT,FOLLOW_ADOPT_in_builtinaction1479); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1481); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1483);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1485); 

                    }
                    break;
                case 4 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:4: DROP OPEN litconj CLOSE
                    {
                    match(input,DROP,FOLLOW_DROP_in_builtinaction1492); 

                    match(input,OPEN,FOLLOW_OPEN_in_builtinaction1494); 

                    pushFollow(FOLLOW_litconj_in_builtinaction1496);
                    litconj();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1498); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:1: communication[Abstract_GOALAgent gl] returns [Abstract_Deed d] : SEND OPEN id COMMA poslitconj[gl] CLOSE ;
    public final Abstract_Deed communication(Abstract_GOALAgent gl) throws RecognitionException {
        Abstract_Deed d = null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:2: ( SEND OPEN id COMMA poslitconj[gl] CLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:4: SEND OPEN id COMMA poslitconj[gl] CLOSE
            {
            match(input,SEND,FOLLOW_SEND_in_communication1515); 

            match(input,OPEN,FOLLOW_OPEN_in_communication1517); 

            pushFollow(FOLLOW_id_in_communication1519);
            id();

            state._fsp--;


            match(input,COMMA,FOLLOW_COMMA_in_communication1521); 

            pushFollow(FOLLOW_poslitconj_in_communication1523);
            poslitconj(gl);

            state._fsp--;


            match(input,CLOSE,FOLLOW_CLOSE_in_communication1526); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return d;
    }
    // $ANTLR end "communication"



    // $ANTLR start "id"
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:131:1: id returns [String s] : ( CONST | VAR ) ;
    public final String id() throws RecognitionException {
        String s = null;


        Token CONST1=null;
        Token VAR2=null;

        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:131:23: ( ( CONST | VAR ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:131:25: ( CONST | VAR )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:131:25: ( CONST | VAR )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:131:26: CONST
                    {
                    CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_id1580); 

                    s = CONST1.getText();

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:131:58: VAR
                    {
                    VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_id1585); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:170:2: equation returns [Abstract_Equation e] : a1= arithexpr i= eqoper a2= arithexpr ;
    public final Abstract_Equation equation() throws RecognitionException {
        Abstract_Equation e = null;


        Abstract_NumberTerm a1 =null;

        int i =0;

        Abstract_NumberTerm a2 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:171:3: (a1= arithexpr i= eqoper a2= arithexpr )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:171:5: a1= arithexpr i= eqoper a2= arithexpr
            {
            pushFollow(FOLLOW_arithexpr_in_equation1907);
            a1=arithexpr();

            state._fsp--;


            pushFollow(FOLLOW_eqoper_in_equation1911);
            i=eqoper();

            state._fsp--;


            pushFollow(FOLLOW_arithexpr_in_equation1915);
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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:2: term returns [Abstract_Term t] : (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) ;
    public final Abstract_Term term() throws RecognitionException {
        Abstract_Term t = null;


        Abstract_StringTerm st =null;

        Abstract_Term ft =null;

        Abstract_NumberTerm at =null;

        Abstract_ListTermImpl lt =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:33: ( (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:35: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:35: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:36: st= stringterm
                    {
                    pushFollow(FOLLOW_stringterm_in_term1932);
                    st=stringterm();

                    state._fsp--;


                    t = st;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:63: ft= function_term
                    {
                    pushFollow(FOLLOW_function_term_in_term1940);
                    ft=function_term();

                    state._fsp--;


                    t =ft;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:91: at= arithexpr
                    {
                    pushFollow(FOLLOW_arithexpr_in_term1948);
                    at=arithexpr();

                    state._fsp--;


                    t =at;

                    }
                    break;
                case 4 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:114: lt= listterm
                    {
                    pushFollow(FOLLOW_listterm_in_term1955);
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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:2: function_term returns [Abstract_Term t] : c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? ;
    public final Abstract_Term function_term() throws RecognitionException {
        Abstract_Term t = null;


        Token c=null;
        Abstract_Term t1 =null;

        Abstract_Term t2 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:3: (c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:5: c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
            {
            c=(Token)match(input,CONST,FOLLOW_CONST_in_function_term1975); 

            t=new Abstract_Predicate(c.getText());

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:54: ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==OPEN) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:55: OPEN t1= term ( COMMA t2= term )* CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_function_term1980); 

                    pushFollow(FOLLOW_term_in_function_term1984);
                    t1=term();

                    state._fsp--;


                    ((Abstract_Predicate) t).addTerm(t1);

                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:111: ( COMMA t2= term )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==COMMA) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:112: COMMA t2= term
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_function_term1989); 

                    	    pushFollow(FOLLOW_term_in_function_term1993);
                    	    t2=term();

                    	    state._fsp--;


                    	    ((Abstract_Predicate) t).addTerm(t2);

                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    match(input,CLOSE,FOLLOW_CLOSE_in_function_term1999); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:175:2: atom_term returns [Abstract_NumberTerm t] : (n= numberstring |v= var ) ;
    public final Abstract_NumberTerm atom_term() throws RecognitionException {
        Abstract_NumberTerm t = null;


        String n =null;

        Abstract_VarTerm v =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:175:44: ( (n= numberstring |v= var ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:175:46: (n= numberstring |v= var )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:175:46: (n= numberstring |v= var )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:175:47: n= numberstring
                    {
                    pushFollow(FOLLOW_numberstring_in_atom_term2018);
                    n=numberstring();

                    state._fsp--;


                    t = new Abstract_NumberTermImpl(n);

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:175:108: v= var
                    {
                    pushFollow(FOLLOW_var_in_atom_term2026);
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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:176:2: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE w= word DOUBLEQUOTE ;
    public final Abstract_StringTerm stringterm() throws RecognitionException {
        Abstract_StringTerm s = null;


        String w =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:177:3: ( DOUBLEQUOTE w= word DOUBLEQUOTE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:177:5: DOUBLEQUOTE w= word DOUBLEQUOTE
            {
            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2043); 

            pushFollow(FOLLOW_word_in_stringterm2047);
            w=word();

            state._fsp--;


            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2049); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:178:2: var returns [Abstract_VarTerm v] : VAR ;
    public final Abstract_VarTerm var() throws RecognitionException {
        Abstract_VarTerm v = null;


        Token VAR3=null;

        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:178:35: ( VAR )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:178:37: VAR
            {
            VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_var2063); 


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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:187:2: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) ;
    public final String numberstring() throws RecognitionException {
        String s = null;


        Token n1=null;
        Token n2=null;

        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:3: ( ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:5: ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? )
            {
            s = "";

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:16: ( MINUS )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==MINUS) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:17: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_numberstring2083); 

                    s += "-";

                    }
                    break;

            }


            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:38: (n1= NUMBER ( STOP n2= NUMBER )? )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:39: n1= NUMBER ( STOP n2= NUMBER )?
            {
            n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2092); 

            s += n1.getText();

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:189:37: ( STOP n2= NUMBER )?
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:189:38: STOP n2= NUMBER
                    {
                    match(input,STOP,FOLLOW_STOP_in_numberstring2133); 

                    s += ".";

                    n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2139); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:191:1: arithexpr returns [Abstract_NumberTerm ae] : a1= multexpr (i= addoper a2= multexpr )? ;
    public final Abstract_NumberTerm arithexpr() throws RecognitionException {
        Abstract_NumberTerm ae = null;


        Abstract_NumberTerm a1 =null;

        int i =0;

        Abstract_NumberTerm a2 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:3: (a1= multexpr (i= addoper a2= multexpr )? )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:6: a1= multexpr (i= addoper a2= multexpr )?
            {
            pushFollow(FOLLOW_multexpr_in_arithexpr2193);
            a1=multexpr();

            state._fsp--;


            ae = a1;

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:30: (i= addoper a2= multexpr )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==MINUS||LA41_0==PLUS) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:31: i= addoper a2= multexpr
                    {
                    pushFollow(FOLLOW_addoper_in_arithexpr2200);
                    i=addoper();

                    state._fsp--;


                    pushFollow(FOLLOW_multexpr_in_arithexpr2204);
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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:193:1: multexpr returns [Abstract_NumberTerm ae] : a1= atom_term (i= multoper a2= atom_term )? ;
    public final Abstract_NumberTerm multexpr() throws RecognitionException {
        Abstract_NumberTerm ae = null;


        Abstract_NumberTerm a1 =null;

        int i =0;

        Abstract_NumberTerm a2 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:193:42: (a1= atom_term (i= multoper a2= atom_term )? )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:193:44: a1= atom_term (i= multoper a2= atom_term )?
            {
            pushFollow(FOLLOW_atom_term_in_multexpr2220);
            a1=atom_term();

            state._fsp--;


            ae = a1;

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:193:68: (i= multoper a2= atom_term )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==DIV||LA42_0==MULT) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:193:69: i= multoper a2= atom_term
                    {
                    pushFollow(FOLLOW_multoper_in_multexpr2226);
                    i=multoper();

                    state._fsp--;


                    pushFollow(FOLLOW_atom_term_in_multexpr2230);
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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:195:1: word returns [String s] : ( CONST | VAR ) ;
    public final String word() throws RecognitionException {
        String s = null;


        Token CONST4=null;
        Token VAR5=null;

        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:195:25: ( ( CONST | VAR ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:195:27: ( CONST | VAR )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:195:27: ( CONST | VAR )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:195:28: CONST
                    {
                    CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_word2247); 

                    s =CONST4.getText();

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:195:59: VAR
                    {
                    VAR5=(Token)match(input,VAR,FOLLOW_VAR_in_word2253); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:198:2: listterm returns [Abstract_ListTermImpl l] : SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE ;
    public final Abstract_ListTermImpl listterm() throws RecognitionException {
        Abstract_ListTermImpl l = null;


        Token v=null;
        Abstract_Term h =null;

        Abstract_Term t =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:3: ( SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:5: SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE
            {
            l = new Abstract_ListTermImpl(); Abstract_ListTerm lrunning = l;

            match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2363); 

            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:10: (h= term ( COMMA t= term )* ( BAR v= VAR )? )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==CONST||LA46_0==DOUBLEQUOTE||LA46_0==MINUS||LA46_0==NUMBER||LA46_0==SQOPEN||LA46_0==VAR) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:11: h= term ( COMMA t= term )* ( BAR v= VAR )?
                    {
                    pushFollow(FOLLOW_term_in_listterm2368);
                    h=term();

                    state._fsp--;


                    l.addHead(h); l.addTail(new Abstract_ListTermImpl());

                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:3: ( COMMA t= term )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==COMMA) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:4: COMMA t= term
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_listterm2376); 

                    	    pushFollow(FOLLOW_term_in_listterm2380);
                    	    t=term();

                    	    state._fsp--;


                    	    Abstract_ListTerm l2 = new Abstract_ListTermImpl();  l2.addHead(t); l2.addTail(new Abstract_ListTermImpl()); lrunning=l2;

                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);


                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:202:3: ( BAR v= VAR )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==BAR) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:202:4: BAR v= VAR
                            {
                            match(input,BAR,FOLLOW_BAR_in_listterm2390); 

                            v=(Token)match(input,VAR,FOLLOW_VAR_in_listterm2394); 

                            lrunning.addTail(new Abstract_VarTerm(v.getText()));

                            }
                            break;

                    }


                    }
                    break;

            }


            match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2403); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:204:2: addoper returns [int i] : ( PLUS | MINUS ) ;
    public final int addoper() throws RecognitionException {
        int i = 0;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:204:25: ( ( PLUS | MINUS ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:204:27: ( PLUS | MINUS )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:204:27: ( PLUS | MINUS )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:204:28: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_addoper2418); 

                    i = 1;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:204:45: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_addoper2424); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:205:2: multoper returns [int i] : ( MULT | DIV ) ;
    public final int multoper() throws RecognitionException {
        int i = 0;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:3: ( ( MULT | DIV ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:5: ( MULT | DIV )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:5: ( MULT | DIV )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:6: MULT
                    {
                    match(input,MULT,FOLLOW_MULT_in_multoper2443); 

                    i = 3;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:23: DIV
                    {
                    match(input,DIV,FOLLOW_DIV_in_multoper2449); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:2: eqoper returns [int i] : ( LESS | EQUALS ) ;
    public final int eqoper() throws RecognitionException {
        int i = 0;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:25: ( ( LESS | EQUALS ) )
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:27: ( LESS | EQUALS )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:27: ( LESS | EQUALS )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:28: LESS
                    {
                    match(input,LESS,FOLLOW_LESS_in_eqoper2466); 

                    i = 1;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:45: EQUALS
                    {
                    match(input,EQUALS,FOLLOW_EQUALS_in_eqoper2472); 

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
    public static final BitSet FOLLOW_CURLYCLOSE_in_program241 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_MAIN_in_program286 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_MODULE_in_program288 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program290 = new BitSet(new long[]{0x0000200011000000L});
    public static final BitSet FOLLOW_module_in_program292 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program295 = new BitSet(new long[]{0x0000000000404010L});
    public static final BitSet FOLLOW_EVENT_in_program339 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_MODULE_in_program341 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program343 = new BitSet(new long[]{0x0000200011000000L});
    public static final BitSet FOLLOW_module_in_program345 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program348 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ACTIONSPEC_in_program394 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_program396 = new BitSet(new long[]{0x0082000008122020L});
    public static final BitSet FOLLOW_actionspec_in_program398 = new BitSet(new long[]{0x0082000008126020L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program402 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_program494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KNOWLEDGE_in_module587 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module589 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_krspec_in_module591 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module594 = new BitSet(new long[]{0x0000200001000000L});
    public static final BitSet FOLLOW_GOALS_in_module628 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module630 = new BitSet(new long[]{0x0080008400006000L});
    public static final BitSet FOLLOW_poslitconj_in_module632 = new BitSet(new long[]{0x0080008400006000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module636 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_PROGRAM_in_module669 = new BitSet(new long[]{0x0008000000008000L});
    public static final BitSet FOLLOW_optionorder_in_module672 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module676 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_macro_in_module711 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_actionrule_in_module747 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module780 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ACTIONSPEC_in_module812 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_module814 = new BitSet(new long[]{0x0082000008122020L});
    public static final BitSet FOLLOW_actionspec_in_module816 = new BitSet(new long[]{0x0082000008126020L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_module820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_krspec863 = new BitSet(new long[]{0x0010400000000000L});
    public static final BitSet FOLLOW_STOP_in_krspec870 = new BitSet(new long[]{0x0080008400002002L});
    public static final BitSet FOLLOW_PROLOGARROW_in_krspec878 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_krspec882 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_STOP_in_krspec884 = new BitSet(new long[]{0x0080008400002002L});
    public static final BitSet FOLLOW_atom_in_brspec905 = new BitSet(new long[]{0x0010400000000000L});
    public static final BitSet FOLLOW_STOP_in_brspec913 = new BitSet(new long[]{0x0080008400002002L});
    public static final BitSet FOLLOW_PROLOGARROW_in_brspec921 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_brspec925 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_STOP_in_brspec927 = new BitSet(new long[]{0x0080008400002002L});
    public static final BitSet FOLLOW_atom_in_poslitconj980 = new BitSet(new long[]{0x0010000000000800L});
    public static final BitSet FOLLOW_COMMA_in_poslitconj985 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_atom_in_poslitconj989 = new BitSet(new long[]{0x0010000000000800L});
    public static final BitSet FOLLOW_STOP_in_poslitconj994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_litconj1007 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_litconj1012 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_literal_in_litconj1016 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_atom_in_literal1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_literal1041 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_literal1043 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_atom_in_literal1047 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_literal1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_atom1067 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_parameters_in_atom1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equation_in_atom1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_parameters1099 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_parameters1103 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_COMMA_in_parameters1110 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_parameters1114 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_CLOSE_in_parameters1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQOPEN_in_optionorder1131 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ORDER_in_optionorder1133 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_EQUALS_in_optionorder1135 = new BitSet(new long[]{0x00018000C0000000L});
    public static final BitSet FOLLOW_set_in_optionorder1137 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_optionorder1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HASH_in_macro1163 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DEFINE_in_macro1165 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_id_in_macro1169 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_parameters_in_macro1173 = new BitSet(new long[]{0x0040004000800080L});
    public static final BitSet FOLLOW_mentalstatecond_in_macro1177 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_STOP_in_macro1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_actionrule1197 = new BitSet(new long[]{0x00C0004000802080L});
    public static final BitSet FOLLOW_mentalstatecond_in_actionrule1202 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_id_in_actionrule1212 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_parameters_in_actionrule1216 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_THEN_in_actionrule1224 = new BitSet(new long[]{0x0082000008122020L});
    public static final BitSet FOLLOW_actioncombo_in_actionrule1228 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_STOP_in_actionrule1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond1251 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_mentalstatecond1256 = new BitSet(new long[]{0x0040004000800080L});
    public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond1260 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_TRUE_in_mentalliteral1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mentalatom_in_mentalliteral1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_mentalliteral1291 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_mentalliteral1293 = new BitSet(new long[]{0x0000000000800080L});
    public static final BitSet FOLLOW_mentalatom_in_mentalliteral1297 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_mentalliteral1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BEL_in_mentalatom1315 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_mentalatom1317 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_mentalatom1321 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_mentalatom1326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GOAL_in_mentalatom1330 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_mentalatom1332 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_mentalatom1336 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_mentalatom1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_actionspec1349 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1352 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_PRE_in_actionspec1354 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1356 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_actionspec1358 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1360 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_POST_in_actionspec1362 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1364 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_actionspec1366 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1368 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_actioncombo1388 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_PLUS_in_actioncombo1394 = new BitSet(new long[]{0x0082000008122020L});
    public static final BitSet FOLLOW_action_in_actioncombo1398 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_userdefaction_in_action1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_builtinaction_in_action1422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_communication_in_action1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_userdefaction1439 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_parameters_in_userdefaction1442 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_INSERT_in_builtinaction1454 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1456 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1458 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_builtinaction1466 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1468 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1470 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADOPT_in_builtinaction1479 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1481 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1483 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_builtinaction1492 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_builtinaction1494 = new BitSet(new long[]{0x008000C400002000L});
    public static final BitSet FOLLOW_litconj_in_builtinaction1496 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_builtinaction1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEND_in_communication1515 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_communication1517 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_id_in_communication1519 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COMMA_in_communication1521 = new BitSet(new long[]{0x0080008400002000L});
    public static final BitSet FOLLOW_poslitconj_in_communication1523 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CLOSE_in_communication1526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_id1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_id1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithexpr_in_equation1907 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_eqoper_in_equation1911 = new BitSet(new long[]{0x0080008400000000L});
    public static final BitSet FOLLOW_arithexpr_in_equation1915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringterm_in_term1932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_term_in_term1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithexpr_in_term1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listterm_in_term1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_function_term1975 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_OPEN_in_function_term1980 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_function_term1984 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_COMMA_in_function_term1989 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_function_term1993 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_CLOSE_in_function_term1999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numberstring_in_atom_term2018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_atom_term2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2043 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_word_in_stringterm2047 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_var2063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_numberstring2083 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring2092 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_STOP_in_numberstring2133 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr2193 = new BitSet(new long[]{0x0000040400000002L});
    public static final BitSet FOLLOW_addoper_in_arithexpr2200 = new BitSet(new long[]{0x0080008400000000L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_term_in_multexpr2220 = new BitSet(new long[]{0x0000001000040002L});
    public static final BitSet FOLLOW_multoper_in_multexpr2226 = new BitSet(new long[]{0x0080008400000000L});
    public static final BitSet FOLLOW_atom_term_in_multexpr2230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_word2247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_word2253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQOPEN_in_listterm2363 = new BitSet(new long[]{0x008C008400082000L});
    public static final BitSet FOLLOW_term_in_listterm2368 = new BitSet(new long[]{0x0004000000000840L});
    public static final BitSet FOLLOW_COMMA_in_listterm2376 = new BitSet(new long[]{0x0088008400082000L});
    public static final BitSet FOLLOW_term_in_listterm2380 = new BitSet(new long[]{0x0004000000000840L});
    public static final BitSet FOLLOW_BAR_in_listterm2390 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_VAR_in_listterm2394 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_listterm2403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_addoper2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_addoper2424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULT_in_multoper2443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_multoper2449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_in_eqoper2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_eqoper2472 = new BitSet(new long[]{0x0000000000000002L});

}