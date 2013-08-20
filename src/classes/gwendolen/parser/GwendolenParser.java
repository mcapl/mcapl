// $ANTLR 3.4 /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g 2013-08-10 12:05:57

package gwendolen.parser;

import ail.syntax.ast.*;
import gwendolen.syntax.ast.*;
import java.util.HashMap;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class GwendolenParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACHIEVE", "ACHIEVEGOAL", "ADD_CONSTRAINT", "ADD_CONTENT", "ADD_CONTEXT", "ADD_PLAN", "BELIEFRULES", "BELIEFS", "BELIEVE", "BRULEARROW", "CLOSE", "COLON", "COMMA", "COMMENT", "CONST", "CONSTRAINT", "CURLYCLOSE", "CURLYOPEN", "DIV", "DOUBLEQUOTE", "EQ", "GOAL", "GOALS", "GWENDOLEN", "IN_CONTENT", "IN_CONTEXT", "LESS", "LINE_COMMENT", "LOCK", "MINUS", "MOD", "MULT", "NAME", "NEWLINE", "NOT", "NUMBER", "OPEN", "PERFORM", "PERFORMGOAL", "PLANS", "PLUS", "POINT", "QUERY", "RECEIVED", "RULEARROW", "SEMI", "SEND", "SENT", "SHRIEK", "SQCLOSE", "SQOPEN", "STRING", "TELL", "TELLHOW", "TRUE", "VAR", "WS"
    };

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

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public GwendolenParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public GwendolenParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return GwendolenParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g"; }


    	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
    	private Abstract_Literal agentname = new Abstract_Literal("");
    	


    // $ANTLR start "mas"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:58:1: mas returns [Abstract_MAS mas] :glist= gwendolenagents ;
    public final Abstract_MAS mas() throws RecognitionException {
        Abstract_MAS mas = null;


        ArrayList<Abstract_GwendolenAgent> glist =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:58:32: (glist= gwendolenagents )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:58:34: glist= gwendolenagents
            {
            mas = new Abstract_MAS();

            pushFollow(FOLLOW_gwendolenagents_in_mas90);
            glist=gwendolenagents();

            state._fsp--;


            mas.setAgs(glist);

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
    // $ANTLR end "mas"



    // $ANTLR start "gwendolenagents"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:61:1: gwendolenagents returns [ArrayList<Abstract_GwendolenAgent> gags] : GWENDOLEN (g= gwendolenagent )+ ;
    public final ArrayList<Abstract_GwendolenAgent> gwendolenagents() throws RecognitionException {
        ArrayList<Abstract_GwendolenAgent> gags = null;


        Abstract_GwendolenAgent g =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:61:65: ( GWENDOLEN (g= gwendolenagent )+ )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:61:67: GWENDOLEN (g= gwendolenagent )+
            {
            match(input,GWENDOLEN,FOLLOW_GWENDOLEN_in_gwendolenagents102); 

            gags=new ArrayList<Abstract_GwendolenAgent>();

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:63:2: (g= gwendolenagent )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==GWENDOLEN||LA1_0==NAME) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:63:3: g= gwendolenagent
            	    {
            	    pushFollow(FOLLOW_gwendolenagent_in_gwendolenagents113);
            	    g=gwendolenagent();

            	    state._fsp--;


            	    gags.add(g);

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
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
        return gags;
    }
    // $ANTLR end "gwendolenagents"



    // $ANTLR start "gwendolenagent"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:66:1: gwendolenagent returns [Abstract_GwendolenAgent g] : ( ( GWENDOLEN )? ) NAME w= word BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOALS (gl= goal )* PLANS (p= plan )* ;
    public final Abstract_GwendolenAgent gwendolenagent() throws RecognitionException {
        Abstract_GwendolenAgent g = null;


        String w =null;

        Abstract_Literal l =null;

        Abstract_Rule r =null;

        Abstract_Goal gl =null;

        Abstract_GPlan p =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:66:52: ( ( ( GWENDOLEN )? ) NAME w= word BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOALS (gl= goal )* PLANS (p= plan )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:67:9: ( ( GWENDOLEN )? ) NAME w= word BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOALS (gl= goal )* PLANS (p= plan )*
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:67:9: ( ( GWENDOLEN )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:67:10: ( GWENDOLEN )?
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:67:10: ( GWENDOLEN )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==GWENDOLEN) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:67:10: GWENDOLEN
                    {
                    match(input,GWENDOLEN,FOLLOW_GWENDOLEN_in_gwendolenagent140); 

                    }
                    break;

            }


            }


            match(input,NAME,FOLLOW_NAME_in_gwendolenagent146); 

            pushFollow(FOLLOW_word_in_gwendolenagent150);
            w=word();

            state._fsp--;


            try {g = new Abstract_GwendolenAgent(w);} 
            		catch (Exception e) {System.err.println(e); agentname = new Abstract_Literal(w);}

            match(input,BELIEFS,FOLLOW_BELIEFS_in_gwendolenagent155); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:70:10: (l= literal )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==CONST||LA3_0==NOT||(LA3_0 >= TRUE && LA3_0 <= VAR)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:70:11: l= literal
            	    {
            	    pushFollow(FOLLOW_literal_in_gwendolenagent160);
            	    l=literal();

            	    state._fsp--;


            	    g.addInitialBel(l);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:71:2: ( BELIEFRULES (r= brule )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==BELIEFRULES) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:71:3: BELIEFRULES (r= brule )*
                    {
                    match(input,BELIEFRULES,FOLLOW_BELIEFRULES_in_gwendolenagent168); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:71:15: (r= brule )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==BELIEVE||LA4_0==GOAL||(LA4_0 >= IN_CONTENT && LA4_0 <= IN_CONTEXT)||LA4_0==SENT||LA4_0==SQOPEN||LA4_0==TRUE) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:71:16: r= brule
                    	    {
                    	    pushFollow(FOLLOW_brule_in_gwendolenagent173);
                    	    r=brule();

                    	    state._fsp--;


                    	    g.addRule(r);

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,GOALS,FOLLOW_GOALS_in_gwendolenagent182); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:72:8: (gl= goal )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==CONST||LA6_0==NOT||(LA6_0 >= TRUE && LA6_0 <= VAR)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:72:9: gl= goal
            	    {
            	    pushFollow(FOLLOW_goal_in_gwendolenagent187);
            	    gl=goal();

            	    state._fsp--;


            	    g.addInitialGoal(gl);

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            match(input,PLANS,FOLLOW_PLANS_in_gwendolenagent194); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:73:8: (p= plan )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==MINUS||LA7_0==PLUS) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:73:9: p= plan
            	    {
            	    pushFollow(FOLLOW_plan_in_gwendolenagent199);
            	    p=plan();

            	    state._fsp--;


            	    try {g.addPlan(p);} catch (Exception e) {System.err.println(e);}

            	    }
            	    break;

            	default :
            	    break loop7;
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
        return g;
    }
    // $ANTLR end "gwendolenagent"



    // $ANTLR start "guard_atom"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:1: guard_atom returns [Abstract_GuardAtom g] : ( BELIEVE l= literal | GOAL gl= goal | IN_CONTENT w= word | IN_CONTEXT w= word | SENT OPEN an1= literal COMMA (an2= literal COMMA )? p= performative COMMA t= pred CLOSE | SQOPEN eq= equation SQCLOSE | TRUE ) ;
    public final Abstract_GuardAtom guard_atom() throws RecognitionException {
        Abstract_GuardAtom g = null;


        Abstract_Literal l =null;

        Abstract_Goal gl =null;

        String w =null;

        Abstract_Literal an1 =null;

        Abstract_Literal an2 =null;

        int p =0;

        Abstract_Predicate t =null;

        Abstract_Equation eq =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:43: ( ( BELIEVE l= literal | GOAL gl= goal | IN_CONTENT w= word | IN_CONTEXT w= word | SENT OPEN an1= literal COMMA (an2= literal COMMA )? p= performative COMMA t= pred CLOSE | SQOPEN eq= equation SQCLOSE | TRUE ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:45: ( BELIEVE l= literal | GOAL gl= goal | IN_CONTENT w= word | IN_CONTEXT w= word | SENT OPEN an1= literal COMMA (an2= literal COMMA )? p= performative COMMA t= pred CLOSE | SQOPEN eq= equation SQCLOSE | TRUE )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:45: ( BELIEVE l= literal | GOAL gl= goal | IN_CONTENT w= word | IN_CONTEXT w= word | SENT OPEN an1= literal COMMA (an2= literal COMMA )? p= performative COMMA t= pred CLOSE | SQOPEN eq= equation SQCLOSE | TRUE )
            int alt9=7;
            switch ( input.LA(1) ) {
            case BELIEVE:
                {
                alt9=1;
                }
                break;
            case GOAL:
                {
                alt9=2;
                }
                break;
            case IN_CONTENT:
                {
                alt9=3;
                }
                break;
            case IN_CONTEXT:
                {
                alt9=4;
                }
                break;
            case SENT:
                {
                alt9=5;
                }
                break;
            case SQOPEN:
                {
                alt9=6;
                }
                break;
            case TRUE:
                {
                alt9=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:46: BELIEVE l= literal
                    {
                    match(input,BELIEVE,FOLLOW_BELIEVE_in_guard_atom218); 

                    pushFollow(FOLLOW_literal_in_guard_atom222);
                    l=literal();

                    state._fsp--;


                    g = new Abstract_GBelief(Abstract_GBelief.AILBel, l);

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:77:5: GOAL gl= goal
                    {
                    match(input,GOAL,FOLLOW_GOAL_in_guard_atom232); 

                    pushFollow(FOLLOW_goal_in_guard_atom236);
                    gl=goal();

                    state._fsp--;


                    g = gl;

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:78:5: IN_CONTENT w= word
                    {
                    match(input,IN_CONTENT,FOLLOW_IN_CONTENT_in_guard_atom246); 

                    pushFollow(FOLLOW_word_in_guard_atom250);
                    w=word();

                    state._fsp--;


                    g = new Abstract_GBelief(Abstract_GBelief.AILContent, w);

                    }
                    break;
                case 4 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:79:5: IN_CONTEXT w= word
                    {
                    match(input,IN_CONTEXT,FOLLOW_IN_CONTEXT_in_guard_atom260); 

                    pushFollow(FOLLOW_word_in_guard_atom264);
                    w=word();

                    state._fsp--;


                    g = new Abstract_GBelief(Abstract_GBelief.AILContext, w);

                    }
                    break;
                case 5 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:80:5: SENT OPEN an1= literal COMMA (an2= literal COMMA )? p= performative COMMA t= pred CLOSE
                    {
                    match(input,SENT,FOLLOW_SENT_in_guard_atom274); 

                    match(input,OPEN,FOLLOW_OPEN_in_guard_atom276); 

                    pushFollow(FOLLOW_literal_in_guard_atom280);
                    an1=literal();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_guard_atom282); 

                    Abstract_Literal agn = agentname;

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:81:6: (an2= literal COMMA )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==CONST||LA8_0==NOT||(LA8_0 >= TRUE && LA8_0 <= VAR)) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:81:7: an2= literal COMMA
                            {
                            pushFollow(FOLLOW_literal_in_guard_atom295);
                            an2=literal();

                            state._fsp--;


                            match(input,COMMA,FOLLOW_COMMA_in_guard_atom297); 

                            agn = an2;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_performative_in_guard_atom305);
                    p=performative();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_guard_atom307); 

                    pushFollow(FOLLOW_pred_in_guard_atom317);
                    t=pred();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_guard_atom319); 

                    Abstract_GMessage mess = new Abstract_GMessage(agn, an1, p, new Abstract_Pred(t)); 
                    						g = new Abstract_GBelief(Abstract_GBelief.AILSent, mess);

                    }
                    break;
                case 6 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:85:5: SQOPEN eq= equation SQCLOSE
                    {
                    match(input,SQOPEN,FOLLOW_SQOPEN_in_guard_atom336); 

                    pushFollow(FOLLOW_equation_in_guard_atom342);
                    eq=equation();

                    state._fsp--;


                    g = eq;

                    match(input,SQCLOSE,FOLLOW_SQCLOSE_in_guard_atom346); 

                    }
                    break;
                case 7 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:86:5: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_guard_atom354); 

                    g = new Abstract_GBelief(Abstract_GBelief.GTrue);

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
        return g;
    }
    // $ANTLR end "guard_atom"



    // $ANTLR start "goal"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:88:1: goal returns [Abstract_Goal g] : l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE ;
    public final Abstract_Goal goal() throws RecognitionException {
        Abstract_Goal g = null;


        Abstract_Literal l =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:88:32: (l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:88:34: l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE
            {
            pushFollow(FOLLOW_literal_in_goal372);
            l=literal();

            state._fsp--;


            match(input,SQOPEN,FOLLOW_SQOPEN_in_goal374); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:88:51: ( ACHIEVEGOAL | PERFORMGOAL )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ACHIEVEGOAL) ) {
                alt10=1;
            }
            else if ( (LA10_0==PERFORMGOAL) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:88:52: ACHIEVEGOAL
                    {
                    match(input,ACHIEVEGOAL,FOLLOW_ACHIEVEGOAL_in_goal377); 

                    g = new Abstract_Goal(l, Abstract_Goal.achieveGoal);

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:89:4: PERFORMGOAL
                    {
                    match(input,PERFORMGOAL,FOLLOW_PERFORMGOAL_in_goal387); 

                    g = new Abstract_Goal(l, Abstract_Goal.performGoal);

                    }
                    break;

            }


            match(input,SQCLOSE,FOLLOW_SQCLOSE_in_goal392); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return g;
    }
    // $ANTLR end "goal"



    // $ANTLR start "plan"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:90:1: plan returns [Abstract_GPlan p] : e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI ;
    public final Abstract_GPlan plan() throws RecognitionException {
        Abstract_GPlan p = null;


        Abstract_Event e =null;

        Abstract_GuardAtom gb =null;

        Abstract_Deed d =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:91:2: (e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:91:4: e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI
            {
            pushFollow(FOLLOW_event_in_plan406);
            e=event();

            state._fsp--;


            ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();

            match(input,COLON,FOLLOW_COLON_in_plan414); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_plan416); 

            boolean gneg=true;

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:92:40: ( NOT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NOT) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:92:41: NOT
                    {
                    match(input,NOT,FOLLOW_NOT_in_plan421); 

                    gneg=false;

                    }
                    break;

            }


            pushFollow(FOLLOW_guard_atom_in_plan429);
            gb=guard_atom();

            state._fsp--;


            g.add(gb, gneg);

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:93:3: ( COMMA ( NOT )? gb= guard_atom )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==COMMA) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:93:4: COMMA ( NOT )? gb= guard_atom
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_plan437); 

            	    gneg=true;

            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:93:23: ( NOT )?
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==NOT) ) {
            	        alt12=1;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:93:24: NOT
            	            {
            	            match(input,NOT,FOLLOW_NOT_in_plan442); 

            	            gneg=false;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_guard_atom_in_plan450);
            	    gb=guard_atom();

            	    state._fsp--;


            	    g.add(gb, gneg);

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_plan456); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:93:93: ( RULEARROW d= deed ( COMMA d= deed )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULEARROW) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:93:94: RULEARROW d= deed ( COMMA d= deed )*
                    {
                    match(input,RULEARROW,FOLLOW_RULEARROW_in_plan459); 

                    pushFollow(FOLLOW_deed_in_plan464);
                    d=deed();

                    state._fsp--;


                    deeds.add(d);

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:94:28: ( COMMA d= deed )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==COMMA) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:94:29: COMMA d= deed
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_plan469); 

                    	    pushFollow(FOLLOW_deed_in_plan473);
                    	    d=deed();

                    	    state._fsp--;


                    	    deeds.add(d);

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,SEMI,FOLLOW_SEMI_in_plan483); 

            p = new Abstract_GPlan(e, g, deeds); p.reverseBody(); variables.clear();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return p;
    }
    // $ANTLR end "plan"



    // $ANTLR start "event"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:1: event returns [Abstract_Event e] : ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) ) ;
    public final Abstract_Event event() throws RecognitionException {
        Abstract_Event e = null;


        int p =0;

        Abstract_Predicate t =null;

        Abstract_Literal l =null;

        Abstract_Goal g =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:34: ( ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:36: ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:36: ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==PLUS) ) {
                alt19=1;
            }
            else if ( (LA19_0==MINUS) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:37: PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_event499); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:42: ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
                    int alt17=4;
                    switch ( input.LA(1) ) {
                    case RECEIVED:
                        {
                        alt17=1;
                        }
                        break;
                    case CONST:
                    case NOT:
                    case SHRIEK:
                    case TRUE:
                    case VAR:
                        {
                        alt17=2;
                        }
                        break;
                    case ADD_CONTENT:
                        {
                        alt17=3;
                        }
                        break;
                    case ADD_CONTEXT:
                        {
                        alt17=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;

                    }

                    switch (alt17) {
                        case 1 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:43: RECEIVED OPEN p= performative COMMA t= pred CLOSE
                            {
                            match(input,RECEIVED,FOLLOW_RECEIVED_in_event502); 

                            match(input,OPEN,FOLLOW_OPEN_in_event504); 

                            pushFollow(FOLLOW_performative_in_event508);
                            p=performative();

                            state._fsp--;


                            match(input,COMMA,FOLLOW_COMMA_in_event510); 

                            pushFollow(FOLLOW_pred_in_event514);
                            t=pred();

                            state._fsp--;


                            match(input,CLOSE,FOLLOW_CLOSE_in_event516); 

                            Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), 
                            						new Abstract_VarTerm("To"), p, t); 
                            						e = new Abstract_Event(Abstract_Event.AILAddition, 
                            						Abstract_Event.AILReceived, message);

                            }
                            break;
                        case 2 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:5: (l= literal | SHRIEK g= goal )
                            {
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:5: (l= literal | SHRIEK g= goal )
                            int alt16=2;
                            int LA16_0 = input.LA(1);

                            if ( (LA16_0==CONST||LA16_0==NOT||(LA16_0 >= TRUE && LA16_0 <= VAR)) ) {
                                alt16=1;
                            }
                            else if ( (LA16_0==SHRIEK) ) {
                                alt16=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 16, 0, input);

                                throw nvae;

                            }
                            switch (alt16) {
                                case 1 :
                                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:6: l= literal
                                    {
                                    pushFollow(FOLLOW_literal_in_event534);
                                    l=literal();

                                    state._fsp--;


                                    e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, l);

                                    }
                                    break;
                                case 2 :
                                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:103:5: SHRIEK g= goal
                                    {
                                    match(input,SHRIEK,FOLLOW_SHRIEK_in_event544); 

                                    pushFollow(FOLLOW_goal_in_event548);
                                    g=goal();

                                    state._fsp--;


                                    e = new Abstract_Event(Abstract_Event.AILAddition, g);

                                    }
                                    break;

                            }


                            }
                            break;
                        case 3 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:104:5: ADD_CONTENT l= literal
                            {
                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_event559); 

                            pushFollow(FOLLOW_literal_in_event563);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContent, l);

                            }
                            break;
                        case 4 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:105:5: ADD_CONTEXT l= literal
                            {
                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_event573); 

                            pushFollow(FOLLOW_literal_in_event577);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContext, l);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:107:7: MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_event595); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:107:13: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
                    int alt18=4;
                    switch ( input.LA(1) ) {
                    case CONST:
                    case NOT:
                    case TRUE:
                    case VAR:
                        {
                        alt18=1;
                        }
                        break;
                    case SHRIEK:
                        {
                        alt18=2;
                        }
                        break;
                    case ADD_CONTENT:
                        {
                        alt18=3;
                        }
                        break;
                    case ADD_CONTEXT:
                        {
                        alt18=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;

                    }

                    switch (alt18) {
                        case 1 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:107:14: l= literal
                            {
                            pushFollow(FOLLOW_literal_in_event600);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, l);

                            }
                            break;
                        case 2 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:108:5: SHRIEK g= goal
                            {
                            match(input,SHRIEK,FOLLOW_SHRIEK_in_event610); 

                            pushFollow(FOLLOW_goal_in_event614);
                            g=goal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILDeletion, g);

                            }
                            break;
                        case 3 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:109:5: ADD_CONTENT l= literal
                            {
                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_event624); 

                            pushFollow(FOLLOW_literal_in_event628);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContent, l);

                            }
                            break;
                        case 4 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:110:5: ADD_CONTEXT l= literal
                            {
                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_event638); 

                            pushFollow(FOLLOW_literal_in_event642);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContext, l);

                            }
                            break;

                    }


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
        return e;
    }
    // $ANTLR end "event"



    // $ANTLR start "performative"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:113:1: performative returns [int b] : ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT ) ;
    public final int performative() throws RecognitionException {
        int b = 0;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:113:30: ( ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:113:32: ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:113:32: ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT )
            int alt20=5;
            switch ( input.LA(1) ) {
            case TELL:
                {
                alt20=1;
                }
                break;
            case PERFORM:
                {
                alt20=2;
                }
                break;
            case ACHIEVE:
                {
                alt20=3;
                }
                break;
            case TELLHOW:
                {
                alt20=4;
                }
                break;
            case CONSTRAINT:
                {
                alt20=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }

            switch (alt20) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:113:33: TELL
                    {
                    match(input,TELL,FOLLOW_TELL_in_performative664); 

                    b =1;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:113:48: PERFORM
                    {
                    match(input,PERFORM,FOLLOW_PERFORM_in_performative670); 

                    b =2;

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:113:66: ACHIEVE
                    {
                    match(input,ACHIEVE,FOLLOW_ACHIEVE_in_performative676); 

                    b = 3;

                    }
                    break;
                case 4 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:113:86: TELLHOW
                    {
                    match(input,TELLHOW,FOLLOW_TELLHOW_in_performative682); 

                    b = 4;

                    }
                    break;
                case 5 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:113:106: CONSTRAINT
                    {
                    match(input,CONSTRAINT,FOLLOW_CONSTRAINT_in_performative688); 

                    b = 5;

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
        return b;
    }
    // $ANTLR end "performative"



    // $ANTLR start "deed"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:1: deed returns [Abstract_Deed d] : ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor ) ;
    public final Abstract_Deed deed() throws RecognitionException {
        Abstract_Deed d = null;


        Abstract_Literal l =null;

        Abstract_Goal g =null;

        Abstract_Literal p =null;

        Abstract_Literal c =null;

        Abstract_Action a =null;

        Abstract_Literal wf =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:32: ( ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:34: ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:34: ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==CONST||LA25_0==MINUS||LA25_0==PLUS||LA25_0==SEND||LA25_0==VAR) ) {
                alt25=1;
            }
            else if ( (LA25_0==MULT) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }
            switch (alt25) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:35: ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action )
                    {
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:35: ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==MINUS||LA24_0==PLUS) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==CONST||LA24_0==SEND||LA24_0==VAR) ) {
                        alt24=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;

                    }
                    switch (alt24) {
                        case 1 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:36: ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) )
                            {
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:36: ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) )
                            int alt23=2;
                            int LA23_0 = input.LA(1);

                            if ( (LA23_0==PLUS) ) {
                                alt23=1;
                            }
                            else if ( (LA23_0==MINUS) ) {
                                alt23=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 23, 0, input);

                                throw nvae;

                            }
                            switch (alt23) {
                                case 1 :
                                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:37: PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK )
                                    {
                                    match(input,PLUS,FOLLOW_PLUS_in_deed714); 

                                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:42: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK )
                                    int alt21=7;
                                    switch ( input.LA(1) ) {
                                    case CONST:
                                    case NOT:
                                    case TRUE:
                                    case VAR:
                                        {
                                        alt21=1;
                                        }
                                        break;
                                    case SHRIEK:
                                        {
                                        alt21=2;
                                        }
                                        break;
                                    case ADD_CONTENT:
                                        {
                                        alt21=3;
                                        }
                                        break;
                                    case ADD_CONTEXT:
                                        {
                                        alt21=4;
                                        }
                                        break;
                                    case ADD_PLAN:
                                        {
                                        alt21=5;
                                        }
                                        break;
                                    case ADD_CONSTRAINT:
                                        {
                                        alt21=6;
                                        }
                                        break;
                                    case LOCK:
                                        {
                                        alt21=7;
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 21, 0, input);

                                        throw nvae;

                                    }

                                    switch (alt21) {
                                        case 1 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:43: l= literal
                                            {
                                            pushFollow(FOLLOW_literal_in_deed719);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, l);

                                            }
                                            break;
                                        case 2 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:116:5: SHRIEK g= goal
                                            {
                                            match(input,SHRIEK,FOLLOW_SHRIEK_in_deed729); 

                                            pushFollow(FOLLOW_goal_in_deed733);
                                            g=goal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, g);

                                            }
                                            break;
                                        case 3 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:117:5: ADD_CONTENT l= literal
                                            {
                                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_deed743); 

                                            pushFollow(FOLLOW_literal_in_deed747);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContent, l);

                                            }
                                            break;
                                        case 4 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:118:5: ADD_CONTEXT l= literal
                                            {
                                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_deed757); 

                                            pushFollow(FOLLOW_literal_in_deed761);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContext, l);

                                            }
                                            break;
                                        case 5 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:119:5: ADD_PLAN p= literal
                                            {
                                            match(input,ADD_PLAN,FOLLOW_ADD_PLAN_in_deed771); 

                                            pushFollow(FOLLOW_literal_in_deed775);
                                            p=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILPlan, p);

                                            }
                                            break;
                                        case 6 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:120:5: ADD_CONSTRAINT c= literal
                                            {
                                            match(input,ADD_CONSTRAINT,FOLLOW_ADD_CONSTRAINT_in_deed785); 

                                            pushFollow(FOLLOW_literal_in_deed789);
                                            c=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILConstraint, c);

                                            }
                                            break;
                                        case 7 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:121:5: LOCK
                                            {
                                            match(input,LOCK,FOLLOW_LOCK_in_deed799); 

                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:7: MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK )
                                    {
                                    match(input,MINUS,FOLLOW_MINUS_in_deed812); 

                                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:13: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK )
                                    int alt22=5;
                                    switch ( input.LA(1) ) {
                                    case CONST:
                                    case NOT:
                                    case TRUE:
                                    case VAR:
                                        {
                                        alt22=1;
                                        }
                                        break;
                                    case SHRIEK:
                                        {
                                        alt22=2;
                                        }
                                        break;
                                    case ADD_CONTENT:
                                        {
                                        alt22=3;
                                        }
                                        break;
                                    case ADD_CONTEXT:
                                        {
                                        alt22=4;
                                        }
                                        break;
                                    case LOCK:
                                        {
                                        alt22=5;
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 22, 0, input);

                                        throw nvae;

                                    }

                                    switch (alt22) {
                                        case 1 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:14: l= literal
                                            {
                                            pushFollow(FOLLOW_literal_in_deed817);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, l);

                                            }
                                            break;
                                        case 2 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:123:5: SHRIEK g= goal
                                            {
                                            match(input,SHRIEK,FOLLOW_SHRIEK_in_deed827); 

                                            pushFollow(FOLLOW_goal_in_deed831);
                                            g=goal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, g);

                                            }
                                            break;
                                        case 3 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:5: ADD_CONTENT l= literal
                                            {
                                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_deed841); 

                                            pushFollow(FOLLOW_literal_in_deed845);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContent, l);

                                            }
                                            break;
                                        case 4 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:125:5: ADD_CONTEXT l= literal
                                            {
                                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_deed855); 

                                            pushFollow(FOLLOW_literal_in_deed859);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContext, l);

                                            }
                                            break;
                                        case 5 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:126:5: LOCK
                                            {
                                            match(input,LOCK,FOLLOW_LOCK_in_deed869); 

                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.Dlock);

                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:128:5: a= action
                            {
                            pushFollow(FOLLOW_action_in_deed888);
                            a=action();

                            state._fsp--;


                            d = new Abstract_Deed(a);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:129:5: wf= waitfor
                    {
                    pushFollow(FOLLOW_waitfor_in_deed901);
                    wf=waitfor();

                    state._fsp--;


                    d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, wf);

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
        return d;
    }
    // $ANTLR end "deed"



    // $ANTLR start "brule"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:136:1: brule returns [Abstract_Rule r] : head= guard_atom ( BRULEARROW f= logicalfmla SEMI | SEMI ) ;
    public final Abstract_Rule brule() throws RecognitionException {
        Abstract_Rule r = null;


        Abstract_GuardAtom head =null;

        Abstract_LogicalFormula f =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:136:33: (head= guard_atom ( BRULEARROW f= logicalfmla SEMI | SEMI ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:136:35: head= guard_atom ( BRULEARROW f= logicalfmla SEMI | SEMI )
            {
            pushFollow(FOLLOW_guard_atom_in_brule936);
            head=guard_atom();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:136:51: ( BRULEARROW f= logicalfmla SEMI | SEMI )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==BRULEARROW) ) {
                alt26=1;
            }
            else if ( (LA26_0==SEMI) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }
            switch (alt26) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:136:52: BRULEARROW f= logicalfmla SEMI
                    {
                    match(input,BRULEARROW,FOLLOW_BRULEARROW_in_brule939); 

                    pushFollow(FOLLOW_logicalfmla_in_brule943);
                    f=logicalfmla();

                    state._fsp--;


                    r = new Abstract_Rule(head, f);

                    match(input,SEMI,FOLLOW_SEMI_in_brule947); 

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:137:6: SEMI
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_brule957); 

                    r = new Abstract_Rule(head);

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
        return r;
    }
    // $ANTLR end "brule"



    // $ANTLR start "logicalfmla"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:138:1: logicalfmla returns [Abstract_LogicalFormula f] : (n= notfmla |a= andfmla |gb= guard_atom );
    public final Abstract_LogicalFormula logicalfmla() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_LogicalFormula n =null;

        Abstract_LogicalFormula a =null;

        Abstract_GuardAtom gb =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:138:49: (n= notfmla |a= andfmla |gb= guard_atom )
            int alt27=3;
            switch ( input.LA(1) ) {
            case NOT:
                {
                alt27=1;
                }
                break;
            case OPEN:
                {
                alt27=2;
                }
                break;
            case BELIEVE:
            case GOAL:
            case IN_CONTENT:
            case IN_CONTEXT:
            case SENT:
            case SQOPEN:
            case TRUE:
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
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:138:51: n= notfmla
                    {
                    pushFollow(FOLLOW_notfmla_in_logicalfmla973);
                    n=notfmla();

                    state._fsp--;


                    f = n;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:138:75: a= andfmla
                    {
                    pushFollow(FOLLOW_andfmla_in_logicalfmla980);
                    a=andfmla();

                    state._fsp--;


                    f = a;

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:138:100: gb= guard_atom
                    {
                    pushFollow(FOLLOW_guard_atom_in_logicalfmla990);
                    gb=guard_atom();

                    state._fsp--;


                    f = gb;

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
        return f;
    }
    // $ANTLR end "logicalfmla"



    // $ANTLR start "notfmla"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:139:1: notfmla returns [Abstract_LogicalFormula f] : NOT OPEN lf= logicalfmla CLOSE ;
    public final Abstract_LogicalFormula notfmla() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_LogicalFormula lf =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:139:45: ( NOT OPEN lf= logicalfmla CLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:139:47: NOT OPEN lf= logicalfmla CLOSE
            {
            match(input,NOT,FOLLOW_NOT_in_notfmla1003); 

            match(input,OPEN,FOLLOW_OPEN_in_notfmla1005); 

            pushFollow(FOLLOW_logicalfmla_in_notfmla1011);
            lf=logicalfmla();

            state._fsp--;


            f = new Abstract_LogExpr(Abstract_LogExpr.not, lf);

            match(input,CLOSE,FOLLOW_CLOSE_in_notfmla1015); 

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
    // $ANTLR end "notfmla"



    // $ANTLR start "andfmla"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:140:1: andfmla returns [Abstract_LogicalFormula f] : OPEN f1= logicalfmla COMMA and= logicalfmla CLOSE ;
    public final Abstract_LogicalFormula andfmla() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_LogicalFormula f1 =null;

        Abstract_LogicalFormula and =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:140:45: ( OPEN f1= logicalfmla COMMA and= logicalfmla CLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:140:47: OPEN f1= logicalfmla COMMA and= logicalfmla CLOSE
            {
            match(input,OPEN,FOLLOW_OPEN_in_andfmla1026); 

            pushFollow(FOLLOW_logicalfmla_in_andfmla1032);
            f1=logicalfmla();

            state._fsp--;


            match(input,COMMA,FOLLOW_COMMA_in_andfmla1035); 

            pushFollow(FOLLOW_logicalfmla_in_andfmla1039);
            and=logicalfmla();

            state._fsp--;


            f = new Abstract_LogExpr(f1, Abstract_LogExpr.and, and);

            match(input,CLOSE,FOLLOW_CLOSE_in_andfmla1043); 

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
    // $ANTLR end "andfmla"



    // $ANTLR start "waitfor"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:142:1: waitfor returns [Abstract_Literal wf] : MULT l= literal ;
    public final Abstract_Literal waitfor() throws RecognitionException {
        Abstract_Literal wf = null;


        Abstract_Literal l =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:142:39: ( MULT l= literal )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:142:42: MULT l= literal
            {
            match(input,MULT,FOLLOW_MULT_in_waitfor1056); 

            pushFollow(FOLLOW_literal_in_waitfor1060);
            l=literal();

            state._fsp--;


            wf = l;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return wf;
    }
    // $ANTLR end "waitfor"



    // $ANTLR start "action"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:144:1: action returns [Abstract_Action a] : ( ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred );
    public final Abstract_Action action() throws RecognitionException {
        Abstract_Action a = null;


        Abstract_Literal an =null;

        int p =0;

        Abstract_Predicate t =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:144:36: ( ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==SEND) ) {
                alt28=1;
            }
            else if ( (LA28_0==CONST||LA28_0==VAR) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }
            switch (alt28) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
                    {
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:3: SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE
                    {
                    match(input,SEND,FOLLOW_SEND_in_action1077); 

                    match(input,OPEN,FOLLOW_OPEN_in_action1079); 

                    pushFollow(FOLLOW_literal_in_action1083);
                    an=literal();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_action1085); 

                    pushFollow(FOLLOW_performative_in_action1089);
                    p=performative();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_action1091); 

                    pushFollow(FOLLOW_pred_in_action1095);
                    t=pred();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_action1097); 

                    a = new Abstract_SendAction(an, p, t);

                    }


                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:146:2: t= pred
                    {
                    pushFollow(FOLLOW_pred_in_action1108);
                    t=pred();

                    state._fsp--;


                    a = new Abstract_Action(t, Abstract_Action.normalAction);

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
        return a;
    }
    // $ANTLR end "action"



    // $ANTLR start "environment"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:188:1: environment returns [String env] : w= classpath ;
    public final String environment() throws RecognitionException {
        String env = null;


        String w =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:188:34: (w= classpath )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:188:36: w= classpath
            {
            pushFollow(FOLLOW_classpath_in_environment1388);
            w=classpath();

            state._fsp--;


            env = w;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return env;
    }
    // $ANTLR end "environment"



    // $ANTLR start "classpath"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:189:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
    public final String classpath() throws RecognitionException {
        String s = null;


        String w =null;

        String w1 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:189:30: (w= word ( POINT w1= word )+ )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:189:32: w= word ( POINT w1= word )+
            {
            pushFollow(FOLLOW_word_in_classpath1403);
            w=word();

            state._fsp--;


            s = w;

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:189:52: ( POINT w1= word )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==POINT) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:189:53: POINT w1= word
            	    {
            	    match(input,POINT,FOLLOW_POINT_in_classpath1408); 

            	    pushFollow(FOLLOW_word_in_classpath1412);
            	    w1=word();

            	    state._fsp--;


            	    s+="."; s+=w1;

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
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
        return s;
    }
    // $ANTLR end "classpath"



    // $ANTLR start "word"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:190:1: word returns [String s] : ( CONST | VAR ) ;
    public final String word() throws RecognitionException {
        String s = null;


        Token CONST1=null;
        Token VAR2=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:190:25: ( ( CONST | VAR ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:190:27: ( CONST | VAR )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:190:27: ( CONST | VAR )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==CONST) ) {
                alt30=1;
            }
            else if ( (LA30_0==VAR) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }
            switch (alt30) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:190:28: CONST
                    {
                    CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_word1513); 

                    s =CONST1.getText();

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:190:59: VAR
                    {
                    VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_word1519); 

                    s =VAR2.getText();

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



    // $ANTLR start "agentnameterm"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:192:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
    public final Abstract_StringTerm agentnameterm() throws RecognitionException {
        Abstract_StringTerm s = null;


        Token CONST3=null;
        Abstract_VarTerm v =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:192:47: ( CONST |v= var )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==CONST) ) {
                alt31=1;
            }
            else if ( (LA31_0==VAR) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }
            switch (alt31) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:192:49: CONST
                    {
                    CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm1619); 

                    s = new Abstract_StringTermImpl(CONST3.getText());

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:192:111: v= var
                    {
                    pushFollow(FOLLOW_var_in_agentnameterm1627);
                    v=var();

                    state._fsp--;


                    s = v;

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
        return s;
    }
    // $ANTLR end "agentnameterm"



    // $ANTLR start "literal"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:195:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
    public final Abstract_Literal literal() throws RecognitionException {
        Abstract_Literal l = null;


        Abstract_Predicate nt =null;

        Abstract_Predicate t =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:195:37: ( ( TRUE | NOT nt= pred ) |t= pred )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==NOT||LA33_0==TRUE) ) {
                alt33=1;
            }
            else if ( (LA33_0==CONST||LA33_0==VAR) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }
            switch (alt33) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:195:40: ( TRUE | NOT nt= pred )
                    {
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:195:40: ( TRUE | NOT nt= pred )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==TRUE) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==NOT) ) {
                        alt32=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;

                    }
                    switch (alt32) {
                        case 1 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:195:41: TRUE
                            {
                            match(input,TRUE,FOLLOW_TRUE_in_literal1643); 

                            l = new Abstract_Literal(Abstract_Literal.LTrue);

                            }
                            break;
                        case 2 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:196:5: NOT nt= pred
                            {
                            match(input,NOT,FOLLOW_NOT_in_literal1654); 

                            pushFollow(FOLLOW_pred_in_literal1658);
                            nt=pred();

                            state._fsp--;



                            				if (nt instanceof Abstract_VarTerm) 
                            					{l = (Abstract_VarTerm) nt; l.setNegated(false);}
                            					else { l = new Abstract_Literal(Abstract_Literal.LNeg, new Abstract_Pred(nt));}

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:200:5: t= pred
                    {
                    pushFollow(FOLLOW_pred_in_literal1672);
                    t=pred();

                    state._fsp--;


                    if (t instanceof Abstract_VarTerm) 
                    				            {l = (Abstract_VarTerm) t;} 
                    				            else {l = new Abstract_Literal(Abstract_Literal.LPos, new Abstract_Pred(t));}

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



    // $ANTLR start "pred"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:204:1: pred returns [Abstract_Predicate t] : (v= var |f= function );
    public final Abstract_Predicate pred() throws RecognitionException {
        Abstract_Predicate t = null;


        Abstract_VarTerm v =null;

        Abstract_Predicate f =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:204:37: (v= var |f= function )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==VAR) ) {
                alt34=1;
            }
            else if ( (LA34_0==CONST) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }
            switch (alt34) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:204:39: v= var
                    {
                    pushFollow(FOLLOW_var_in_pred1688);
                    v=var();

                    state._fsp--;


                    t = v;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:204:59: f= function
                    {
                    pushFollow(FOLLOW_function_in_pred1695);
                    f=function();

                    state._fsp--;


                    t = f;

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
        return t;
    }
    // $ANTLR end "pred"



    // $ANTLR start "function"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
    public final Abstract_Predicate function() throws RecognitionException {
        Abstract_Predicate f = null;


        Token CONST4=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:40: ( CONST ( OPEN terms[$f] CLOSE )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:42: CONST ( OPEN terms[$f] CLOSE )?
            {
            CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_function1707); 

            f = new Abstract_Predicate(CONST4.getText());

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:97: ( OPEN terms[$f] CLOSE )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==OPEN) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:98: OPEN terms[$f] CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_function1712); 

                    pushFollow(FOLLOW_terms_in_function1714);
                    terms(f);

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_function1717); 

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
        return f;
    }
    // $ANTLR end "function"



    // $ANTLR start "terms"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:207:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
    public final void terms(Abstract_Predicate f) throws RecognitionException {
        Abstract_Term t =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:207:29: (t= term ( COMMA terms[$f] )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:207:31: t= term ( COMMA terms[$f] )?
            {
            pushFollow(FOLLOW_term_in_terms1730);
            t=term();

            state._fsp--;


            f.addTerm(t);

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:207:58: ( COMMA terms[$f] )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==COMMA) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:207:59: COMMA terms[$f]
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_terms1735); 

                    pushFollow(FOLLOW_terms_in_terms1737);
                    terms(f);

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
    // $ANTLR end "terms"



    // $ANTLR start "term"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:208:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |f= function );
    public final Abstract_Term term() throws RecognitionException {
        Abstract_Term t = null;


        Abstract_NumberTerm a =null;

        Abstract_StringTerm s =null;

        Abstract_Predicate f =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:208:31: (a= atom |s= stringterm |f= function )
            int alt37=3;
            switch ( input.LA(1) ) {
            case MINUS:
            case NUMBER:
            case OPEN:
            case VAR:
                {
                alt37=1;
                }
                break;
            case DOUBLEQUOTE:
                {
                alt37=2;
                }
                break;
            case CONST:
                {
                alt37=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }

            switch (alt37) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:208:34: a= atom
                    {
                    pushFollow(FOLLOW_atom_in_term1756);
                    a=atom();

                    state._fsp--;


                    t = a;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:208:58: s= stringterm
                    {
                    pushFollow(FOLLOW_stringterm_in_term1766);
                    s=stringterm();

                    state._fsp--;


                    t = s;

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:208:88: f= function
                    {
                    pushFollow(FOLLOW_function_in_term1774);
                    f=function();

                    state._fsp--;


                    t = f;

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
        return t;
    }
    // $ANTLR end "term"



    // $ANTLR start "atom"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:210:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
    public final Abstract_NumberTerm atom() throws RecognitionException {
        Abstract_NumberTerm t = null;


        String n =null;

        Abstract_VarTerm v =null;

        Abstract_NumberTerm a =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:210:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
            int alt38=3;
            switch ( input.LA(1) ) {
            case MINUS:
            case NUMBER:
                {
                alt38=1;
                }
                break;
            case VAR:
                {
                alt38=2;
                }
                break;
            case OPEN:
                {
                alt38=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }

            switch (alt38) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:210:40: n= numberstring
                    {
                    pushFollow(FOLLOW_numberstring_in_atom1792);
                    n=numberstring();

                    state._fsp--;


                    t = new Abstract_NumberTermImpl(n);

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:211:6: v= var
                    {
                    pushFollow(FOLLOW_var_in_atom1805);
                    v=var();

                    state._fsp--;


                    t = v;

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:211:27: OPEN a= arithexpr CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_atom1811); 

                    pushFollow(FOLLOW_arithexpr_in_atom1815);
                    a=arithexpr();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_atom1817); 

                    t = a;

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
        return t;
    }
    // $ANTLR end "atom"



    // $ANTLR start "stringterm"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:212:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
    public final Abstract_StringTerm stringterm() throws RecognitionException {
        Abstract_StringTerm s = null;


        Token STRING5=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:212:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:212:46: DOUBLEQUOTE STRING DOUBLEQUOTE
            {
            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1830); 

            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm1833); 

            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1835); 

            		 
                               s = new Abstract_StringTermImpl(STRING5.getText());

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:215:1: var returns [Abstract_VarTerm v] : VAR ;
    public final Abstract_VarTerm var() throws RecognitionException {
        Abstract_VarTerm v = null;


        Token VAR6=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:215:34: ( VAR )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:215:36: VAR
            {
            VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_var1849); 


            	if (variables.containsKey(VAR6.getText())) {
            		v = variables.get(VAR6.getText());
            		} else {
            		v = new Abstract_VarTerm(VAR6.getText());
            		variables.put(VAR6.getText(), v);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:224:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
    public final String numberstring() throws RecognitionException {
        String s = null;


        Token n1=null;
        Token n2=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:224:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:224:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
            {
            s = "";

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:224:46: ( MINUS )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==MINUS) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:224:47: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_numberstring1866); 

                    s += "-";

                    }
                    break;

            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:224:68: (n1= NUMBER ( POINT n2= NUMBER )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:224:69: n1= NUMBER ( POINT n2= NUMBER )?
            {
            n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1875); 

            s += n1.getText();

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:225:6: ( POINT n2= NUMBER )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==POINT) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:225:7: POINT n2= NUMBER
                    {
                    match(input,POINT,FOLLOW_POINT_in_numberstring1885); 

                    s += ".";

                    n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1891); 

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



    // $ANTLR start "equation"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:226:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
    public final Abstract_Equation equation() throws RecognitionException {
        Abstract_Equation eq = null;


        Abstract_NumberTerm a1 =null;

        int oper =0;

        Abstract_NumberTerm a2 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:226:40: (a1= arithexpr oper= eqoper a2= arithexpr )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:226:42: a1= arithexpr oper= eqoper a2= arithexpr
            {
            pushFollow(FOLLOW_arithexpr_in_equation1908);
            a1=arithexpr();

            state._fsp--;


            pushFollow(FOLLOW_eqoper_in_equation1912);
            oper=eqoper();

            state._fsp--;


            pushFollow(FOLLOW_arithexpr_in_equation1916);
            a2=arithexpr();

            state._fsp--;


            eq = new Abstract_Equation(a1, oper, a2);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return eq;
    }
    // $ANTLR end "equation"



    // $ANTLR start "eqoper"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:227:1: eqoper returns [int oper] : ( LESS | EQ );
    public final int eqoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:227:27: ( LESS | EQ )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==LESS) ) {
                alt41=1;
            }
            else if ( (LA41_0==EQ) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:227:29: LESS
                    {
                    match(input,LESS,FOLLOW_LESS_in_eqoper1930); 

                    oper =Abstract_Equation.less;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:227:68: EQ
                    {
                    match(input,EQ,FOLLOW_EQ_in_eqoper1936); 

                    oper =Abstract_Equation.equal;

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
        return oper;
    }
    // $ANTLR end "eqoper"



    // $ANTLR start "arithexpr"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:229:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
    public final Abstract_NumberTerm arithexpr() throws RecognitionException {
        Abstract_NumberTerm t = null;


        Abstract_NumberTerm m =null;

        int oper =0;

        Abstract_NumberTerm m1 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:229:43: (m= multexpr (oper= addoper m1= multexpr )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:229:45: m= multexpr (oper= addoper m1= multexpr )?
            {
            pushFollow(FOLLOW_multexpr_in_arithexpr1952);
            m=multexpr();

            state._fsp--;


            t = m;

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:229:69: (oper= addoper m1= multexpr )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==MINUS||LA42_0==PLUS) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:229:71: oper= addoper m1= multexpr
                    {
                    pushFollow(FOLLOW_addoper_in_arithexpr1960);
                    oper=addoper();

                    state._fsp--;


                    pushFollow(FOLLOW_multexpr_in_arithexpr1964);
                    m1=multexpr();

                    state._fsp--;


                    t = new Abstract_ArithExpr(m, oper, m1);

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
    // $ANTLR end "arithexpr"



    // $ANTLR start "multexpr"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:230:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
    public final Abstract_NumberTerm multexpr() throws RecognitionException {
        Abstract_NumberTerm t = null;


        Abstract_NumberTerm a =null;

        int oper =0;

        Abstract_NumberTerm a1 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:230:42: (a= atom (oper= multoper a1= atom )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:230:44: a= atom (oper= multoper a1= atom )?
            {
            pushFollow(FOLLOW_atom_in_multexpr1981);
            a=atom();

            state._fsp--;


            t = a;

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:230:64: (oper= multoper a1= atom )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==DIV||(LA43_0 >= MOD && LA43_0 <= MULT)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:230:65: oper= multoper a1= atom
                    {
                    pushFollow(FOLLOW_multoper_in_multexpr1988);
                    oper=multoper();

                    state._fsp--;


                    pushFollow(FOLLOW_atom_in_multexpr1992);
                    a1=atom();

                    state._fsp--;


                    t = new Abstract_ArithExpr(a, oper, a1);

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
    // $ANTLR end "multexpr"



    // $ANTLR start "addoper"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:232:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
    public final int addoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:232:28: ( ( PLUS | MINUS ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:232:30: ( PLUS | MINUS )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:232:30: ( PLUS | MINUS )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==PLUS) ) {
                alt44=1;
            }
            else if ( (LA44_0==MINUS) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }
            switch (alt44) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:232:31: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_addoper2009); 

                    oper =Abstract_ArithExpr.plus;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:232:70: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_addoper2014); 

                    oper =Abstract_ArithExpr.minus;

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
        return oper;
    }
    // $ANTLR end "addoper"



    // $ANTLR start "multoper"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:233:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
    public final int multoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:233:29: ( ( MULT | DIV | MOD ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:233:31: ( MULT | DIV | MOD )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:233:31: ( MULT | DIV | MOD )
            int alt45=3;
            switch ( input.LA(1) ) {
            case MULT:
                {
                alt45=1;
                }
                break;
            case DIV:
                {
                alt45=2;
                }
                break;
            case MOD:
                {
                alt45=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }

            switch (alt45) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:233:32: MULT
                    {
                    match(input,MULT,FOLLOW_MULT_in_multoper2029); 

                    oper =Abstract_ArithExpr.times;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:233:73: DIV
                    {
                    match(input,DIV,FOLLOW_DIV_in_multoper2035); 

                    oper =Abstract_ArithExpr.div;

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:233:111: MOD
                    {
                    match(input,MOD,FOLLOW_MOD_in_multoper2041); 

                    oper =Abstract_ArithExpr.mod;

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
        return oper;
    }
    // $ANTLR end "multoper"

    // Delegated rules


 

    public static final BitSet FOLLOW_gwendolenagents_in_mas90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GWENDOLEN_in_gwendolenagents102 = new BitSet(new long[]{0x0000001008000000L});
    public static final BitSet FOLLOW_gwendolenagent_in_gwendolenagents113 = new BitSet(new long[]{0x0000001008000002L});
    public static final BitSet FOLLOW_GWENDOLEN_in_gwendolenagent140 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NAME_in_gwendolenagent146 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_word_in_gwendolenagent150 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_BELIEFS_in_gwendolenagent155 = new BitSet(new long[]{0x0C00004004040400L});
    public static final BitSet FOLLOW_literal_in_gwendolenagent160 = new BitSet(new long[]{0x0C00004004040400L});
    public static final BitSet FOLLOW_BELIEFRULES_in_gwendolenagent168 = new BitSet(new long[]{0x0448000036001000L});
    public static final BitSet FOLLOW_brule_in_gwendolenagent173 = new BitSet(new long[]{0x0448000036001000L});
    public static final BitSet FOLLOW_GOALS_in_gwendolenagent182 = new BitSet(new long[]{0x0C00084000040000L});
    public static final BitSet FOLLOW_goal_in_gwendolenagent187 = new BitSet(new long[]{0x0C00084000040000L});
    public static final BitSet FOLLOW_PLANS_in_gwendolenagent194 = new BitSet(new long[]{0x0000100200000002L});
    public static final BitSet FOLLOW_plan_in_gwendolenagent199 = new BitSet(new long[]{0x0000100200000002L});
    public static final BitSet FOLLOW_BELIEVE_in_guard_atom218 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_guard_atom222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GOAL_in_guard_atom232 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_guard_atom236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IN_CONTENT_in_guard_atom246 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_word_in_guard_atom250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IN_CONTEXT_in_guard_atom260 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_word_in_guard_atom264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SENT_in_guard_atom274 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_guard_atom276 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_guard_atom280 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_guard_atom282 = new BitSet(new long[]{0x0F000240000C0010L});
    public static final BitSet FOLLOW_literal_in_guard_atom295 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_guard_atom297 = new BitSet(new long[]{0x0300020000080010L});
    public static final BitSet FOLLOW_performative_in_guard_atom305 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_guard_atom307 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_pred_in_guard_atom317 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_guard_atom319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQOPEN_in_guard_atom336 = new BitSet(new long[]{0x0800018200000000L});
    public static final BitSet FOLLOW_equation_in_guard_atom342 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_guard_atom346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_guard_atom354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_goal372 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_SQOPEN_in_goal374 = new BitSet(new long[]{0x0000040000000020L});
    public static final BitSet FOLLOW_ACHIEVEGOAL_in_goal377 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_PERFORMGOAL_in_goal387 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_goal392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_in_plan406 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_plan414 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_plan416 = new BitSet(new long[]{0x0448004032001000L});
    public static final BitSet FOLLOW_NOT_in_plan421 = new BitSet(new long[]{0x0448000032001000L});
    public static final BitSet FOLLOW_guard_atom_in_plan429 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_COMMA_in_plan437 = new BitSet(new long[]{0x0448004032001000L});
    public static final BitSet FOLLOW_NOT_in_plan442 = new BitSet(new long[]{0x0448000032001000L});
    public static final BitSet FOLLOW_guard_atom_in_plan450 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_plan456 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_RULEARROW_in_plan459 = new BitSet(new long[]{0x0804100A00040000L});
    public static final BitSet FOLLOW_deed_in_plan464 = new BitSet(new long[]{0x0002000000010000L});
    public static final BitSet FOLLOW_COMMA_in_plan469 = new BitSet(new long[]{0x0804100A00040000L});
    public static final BitSet FOLLOW_deed_in_plan473 = new BitSet(new long[]{0x0002000000010000L});
    public static final BitSet FOLLOW_SEMI_in_plan483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_event499 = new BitSet(new long[]{0x0C10804000040180L});
    public static final BitSet FOLLOW_RECEIVED_in_event502 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_event504 = new BitSet(new long[]{0x0300020000080010L});
    public static final BitSet FOLLOW_performative_in_event508 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_event510 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_pred_in_event514 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_event516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_event534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_event544 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_event548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_event559 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_event563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_event573 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_event577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_event595 = new BitSet(new long[]{0x0C10004000040180L});
    public static final BitSet FOLLOW_literal_in_event600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_event610 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_event614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_event624 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_event628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_event638 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_event642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TELL_in_performative664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERFORM_in_performative670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACHIEVE_in_performative676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TELLHOW_in_performative682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTRAINT_in_performative688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_deed714 = new BitSet(new long[]{0x0C100041000403C0L});
    public static final BitSet FOLLOW_literal_in_deed719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_deed729 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_deed733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_deed743 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_deed757 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_PLAN_in_deed771 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONSTRAINT_in_deed785 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_in_deed799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_deed812 = new BitSet(new long[]{0x0C10004100040180L});
    public static final BitSet FOLLOW_literal_in_deed817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_deed827 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_deed831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_deed841 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_deed855 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_in_deed869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_deed888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_waitfor_in_deed901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_guard_atom_in_brule936 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_BRULEARROW_in_brule939 = new BitSet(new long[]{0x0448014032001000L});
    public static final BitSet FOLLOW_logicalfmla_in_brule943 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_SEMI_in_brule947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_brule957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notfmla_in_logicalfmla973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andfmla_in_logicalfmla980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_guard_atom_in_logicalfmla990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_notfmla1003 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_notfmla1005 = new BitSet(new long[]{0x0448014032001000L});
    public static final BitSet FOLLOW_logicalfmla_in_notfmla1011 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_notfmla1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_andfmla1026 = new BitSet(new long[]{0x0448014032001000L});
    public static final BitSet FOLLOW_logicalfmla_in_andfmla1032 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_andfmla1035 = new BitSet(new long[]{0x0448014032001000L});
    public static final BitSet FOLLOW_logicalfmla_in_andfmla1039 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_andfmla1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULT_in_waitfor1056 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_waitfor1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEND_in_action1077 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_action1079 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_action1083 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_action1085 = new BitSet(new long[]{0x0300020000080010L});
    public static final BitSet FOLLOW_performative_in_action1089 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_action1091 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_pred_in_action1095 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_action1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pred_in_action1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classpath_in_environment1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_word_in_classpath1403 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_POINT_in_classpath1408 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_word_in_classpath1412 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_CONST_in_word1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_word1519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_agentnameterm1619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_agentnameterm1627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_literal1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_literal1654 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_pred_in_literal1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pred_in_literal1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_pred1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_pred1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_function1707 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_OPEN_in_function1712 = new BitSet(new long[]{0x0800018200840000L});
    public static final BitSet FOLLOW_terms_in_function1714 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_function1717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_terms1730 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_COMMA_in_terms1735 = new BitSet(new long[]{0x0800018200840000L});
    public static final BitSet FOLLOW_terms_in_terms1737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_term1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringterm_in_term1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_term1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numberstring_in_atom1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_atom1805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_atom1811 = new BitSet(new long[]{0x0800018200000000L});
    public static final BitSet FOLLOW_arithexpr_in_atom1815 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_atom1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1830 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_STRING_in_stringterm1833 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_var1849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_numberstring1866 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring1875 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_POINT_in_numberstring1885 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithexpr_in_equation1908 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_eqoper_in_equation1912 = new BitSet(new long[]{0x0800018200000000L});
    public static final BitSet FOLLOW_arithexpr_in_equation1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_in_eqoper1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_eqoper1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr1952 = new BitSet(new long[]{0x0000100200000002L});
    public static final BitSet FOLLOW_addoper_in_arithexpr1960 = new BitSet(new long[]{0x0800018200000000L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_multexpr1981 = new BitSet(new long[]{0x0000000C00400002L});
    public static final BitSet FOLLOW_multoper_in_multexpr1988 = new BitSet(new long[]{0x0800018200000000L});
    public static final BitSet FOLLOW_atom_in_multexpr1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_addoper2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_addoper2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULT_in_multoper2029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_multoper2035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOD_in_multoper2041 = new BitSet(new long[]{0x0000000000000002L});

}