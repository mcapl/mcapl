// $ANTLR 3.4 /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g 2014-03-26 16:57:50

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
    	private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");
    	


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
            		catch (Exception e) {System.err.println(e); agentname = new Abstract_StringTermImpl(w);}

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

                        if ( (LA4_0==CONST||LA4_0==NOT||(LA4_0 >= TRUE && LA4_0 <= VAR)) ) {
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:1: guard_atom returns [Abstract_GLogicalFormula g] : ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE ) ;
    public final Abstract_GLogicalFormula guard_atom() throws RecognitionException {
        Abstract_GLogicalFormula g = null;


        Abstract_Literal l =null;

        Abstract_Goal gl =null;

        Abstract_StringTerm s =null;

        Abstract_StringTerm an2 =null;

        int p =0;

        Abstract_Predicate t =null;

        Abstract_Equation eq =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:49: ( ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE )
            int alt9=5;
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
            case SENT:
                {
                alt9=3;
                }
                break;
            case MINUS:
            case NUMBER:
            case OPEN:
            case VAR:
                {
                alt9=4;
                }
                break;
            case TRUE:
                {
                alt9=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:52: BELIEVE l= literal
                    {
                    match(input,BELIEVE,FOLLOW_BELIEVE_in_guard_atom218); 

                    pushFollow(FOLLOW_literal_in_guard_atom222);
                    l=literal();

                    state._fsp--;


                    g = new Abstract_GBelief(l);

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:77:5: GOAL gl= goal
                    {
                    match(input,GOAL,FOLLOW_GOAL_in_guard_atom232); 

                    pushFollow(FOLLOW_goal_in_guard_atom236);
                    gl=goal();

                    state._fsp--;


                    g = new Abstract_Goal(gl);

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:78:5: SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE
                    {
                    match(input,SENT,FOLLOW_SENT_in_guard_atom246); 

                    match(input,OPEN,FOLLOW_OPEN_in_guard_atom248); 

                    Abstract_StringTerm an1=agentname;

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:78:52: (s= agentnameterm )
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:78:53: s= agentnameterm
                    {
                    pushFollow(FOLLOW_agentnameterm_in_guard_atom255);
                    s=agentnameterm();

                    state._fsp--;


                    an1 = s;

                    }


                    match(input,COMMA,FOLLOW_COMMA_in_guard_atom289); 

                    Abstract_StringTerm agn = agentname;

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:79:74: (an2= agentnameterm COMMA )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==CONST||LA8_0==VAR) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:79:75: an2= agentnameterm COMMA
                            {
                            pushFollow(FOLLOW_agentnameterm_in_guard_atom296);
                            an2=agentnameterm();

                            state._fsp--;


                            match(input,COMMA,FOLLOW_COMMA_in_guard_atom304); 

                            agn = an2;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_performative_in_guard_atom312);
                    p=performative();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_guard_atom320); 

                    pushFollow(FOLLOW_pred_in_guard_atom324);
                    t=pred();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_guard_atom326); 

                    g = new Abstract_GuardMessage(Abstract_BaseAILStructure.AILSent, agn, an1, p, t);

                    }
                    break;
                case 4 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:82:5: eq= equation
                    {
                    pushFollow(FOLLOW_equation_in_guard_atom340);
                    eq=equation();

                    state._fsp--;


                    g = eq;

                    }
                    break;
                case 5 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:83:5: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_guard_atom350); 

                    g = new Abstract_GBelief();

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:1: goal returns [Abstract_Goal g] : l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE ;
    public final Abstract_Goal goal() throws RecognitionException {
        Abstract_Goal g = null;


        Abstract_Literal l =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:32: (l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:34: l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE
            {
            pushFollow(FOLLOW_literal_in_goal384);
            l=literal();

            state._fsp--;


            match(input,SQOPEN,FOLLOW_SQOPEN_in_goal386); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:51: ( ACHIEVEGOAL | PERFORMGOAL )
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
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:52: ACHIEVEGOAL
                    {
                    match(input,ACHIEVEGOAL,FOLLOW_ACHIEVEGOAL_in_goal389); 

                    g = new Abstract_Goal(l, Abstract_Goal.achieveGoal);

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:98:4: PERFORMGOAL
                    {
                    match(input,PERFORMGOAL,FOLLOW_PERFORMGOAL_in_goal399); 

                    g = new Abstract_Goal(l, Abstract_Goal.performGoal);

                    }
                    break;

            }


            match(input,SQCLOSE,FOLLOW_SQCLOSE_in_goal404); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:99:1: plan returns [Abstract_GPlan p] : e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI ;
    public final Abstract_GPlan plan() throws RecognitionException {
        Abstract_GPlan p = null;


        Abstract_Event e =null;

        Abstract_GLogicalFormula gb =null;

        Abstract_Deed d =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:100:2: (e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:100:4: e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI
            {
            pushFollow(FOLLOW_event_in_plan418);
            e=event();

            state._fsp--;


            ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();

            match(input,COLON,FOLLOW_COLON_in_plan426); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_plan428); 

            boolean gneg=true;

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:101:40: ( NOT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NOT) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:101:41: NOT
                    {
                    match(input,NOT,FOLLOW_NOT_in_plan433); 

                    gneg=false;

                    }
                    break;

            }


            pushFollow(FOLLOW_guard_atom_in_plan441);
            gb=guard_atom();

            state._fsp--;


            g.add(gb, gneg);

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:3: ( COMMA ( NOT )? gb= guard_atom )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==COMMA) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:4: COMMA ( NOT )? gb= guard_atom
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_plan449); 

            	    gneg=true;

            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:23: ( NOT )?
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==NOT) ) {
            	        alt12=1;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:24: NOT
            	            {
            	            match(input,NOT,FOLLOW_NOT_in_plan454); 

            	            gneg=false;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_guard_atom_in_plan462);
            	    gb=guard_atom();

            	    state._fsp--;


            	    g.add(gb, gneg);

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_plan468); 

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:93: ( RULEARROW d= deed ( COMMA d= deed )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULEARROW) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:94: RULEARROW d= deed ( COMMA d= deed )*
                    {
                    match(input,RULEARROW,FOLLOW_RULEARROW_in_plan471); 

                    pushFollow(FOLLOW_deed_in_plan476);
                    d=deed();

                    state._fsp--;


                    deeds.add(d);

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:103:28: ( COMMA d= deed )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==COMMA) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:103:29: COMMA d= deed
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_plan481); 

                    	    pushFollow(FOLLOW_deed_in_plan485);
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


            match(input,SEMI,FOLLOW_SEMI_in_plan495); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:1: event returns [Abstract_Event e] : ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) ) ;
    public final Abstract_Event event() throws RecognitionException {
        Abstract_Event e = null;


        int p =0;

        Abstract_Predicate t =null;

        Abstract_Literal l =null;

        Abstract_Goal g =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:34: ( ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:36: ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:36: ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) )
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
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:37: PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_event511); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:42: ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
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
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:43: RECEIVED OPEN p= performative COMMA t= pred CLOSE
                            {
                            match(input,RECEIVED,FOLLOW_RECEIVED_in_event514); 

                            match(input,OPEN,FOLLOW_OPEN_in_event516); 

                            pushFollow(FOLLOW_performative_in_event520);
                            p=performative();

                            state._fsp--;


                            match(input,COMMA,FOLLOW_COMMA_in_event522); 

                            pushFollow(FOLLOW_pred_in_event526);
                            t=pred();

                            state._fsp--;


                            match(input,CLOSE,FOLLOW_CLOSE_in_event528); 

                            Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), 
                            						new Abstract_VarTerm("To"), p, t); 
                            						e = new Abstract_Event(Abstract_Event.AILAddition, 
                            						Abstract_Event.AILReceived, message);

                            }
                            break;
                        case 2 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:111:5: (l= literal | SHRIEK g= goal )
                            {
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:111:5: (l= literal | SHRIEK g= goal )
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
                                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:111:6: l= literal
                                    {
                                    pushFollow(FOLLOW_literal_in_event546);
                                    l=literal();

                                    state._fsp--;


                                    e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, l);

                                    }
                                    break;
                                case 2 :
                                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:112:5: SHRIEK g= goal
                                    {
                                    match(input,SHRIEK,FOLLOW_SHRIEK_in_event556); 

                                    pushFollow(FOLLOW_goal_in_event560);
                                    g=goal();

                                    state._fsp--;


                                    e = new Abstract_Event(Abstract_Event.AILAddition, g);

                                    }
                                    break;

                            }


                            }
                            break;
                        case 3 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:113:5: ADD_CONTENT l= literal
                            {
                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_event571); 

                            pushFollow(FOLLOW_literal_in_event575);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContent, l);

                            }
                            break;
                        case 4 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:114:5: ADD_CONTEXT l= literal
                            {
                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_event585); 

                            pushFollow(FOLLOW_literal_in_event589);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContext, l);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:116:7: MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_event607); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:116:13: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
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
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:116:14: l= literal
                            {
                            pushFollow(FOLLOW_literal_in_event612);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, l);

                            }
                            break;
                        case 2 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:117:5: SHRIEK g= goal
                            {
                            match(input,SHRIEK,FOLLOW_SHRIEK_in_event622); 

                            pushFollow(FOLLOW_goal_in_event626);
                            g=goal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILDeletion, g);

                            }
                            break;
                        case 3 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:118:5: ADD_CONTENT l= literal
                            {
                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_event636); 

                            pushFollow(FOLLOW_literal_in_event640);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContent, l);

                            }
                            break;
                        case 4 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:119:5: ADD_CONTEXT l= literal
                            {
                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_event650); 

                            pushFollow(FOLLOW_literal_in_event654);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:1: performative returns [int b] : ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT ) ;
    public final int performative() throws RecognitionException {
        int b = 0;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:30: ( ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:32: ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:32: ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT )
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
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:33: TELL
                    {
                    match(input,TELL,FOLLOW_TELL_in_performative676); 

                    b =1;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:48: PERFORM
                    {
                    match(input,PERFORM,FOLLOW_PERFORM_in_performative682); 

                    b =2;

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:66: ACHIEVE
                    {
                    match(input,ACHIEVE,FOLLOW_ACHIEVE_in_performative688); 

                    b = 3;

                    }
                    break;
                case 4 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:86: TELLHOW
                    {
                    match(input,TELLHOW,FOLLOW_TELLHOW_in_performative694); 

                    b = 4;

                    }
                    break;
                case 5 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:106: CONSTRAINT
                    {
                    match(input,CONSTRAINT,FOLLOW_CONSTRAINT_in_performative700); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:1: deed returns [Abstract_Deed d] : ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor ) ;
    public final Abstract_Deed deed() throws RecognitionException {
        Abstract_Deed d = null;


        Abstract_Literal l =null;

        Abstract_Goal g =null;

        Abstract_Literal p =null;

        Abstract_Literal c =null;

        Abstract_Action a =null;

        Abstract_Literal wf =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:32: ( ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:34: ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:34: ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor )
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
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:35: ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action )
                    {
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:35: ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action )
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
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:36: ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) )
                            {
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:36: ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) )
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
                                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:37: PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK )
                                    {
                                    match(input,PLUS,FOLLOW_PLUS_in_deed726); 

                                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:42: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK )
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
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:43: l= literal
                                            {
                                            pushFollow(FOLLOW_literal_in_deed731);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, l);

                                            }
                                            break;
                                        case 2 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:125:5: SHRIEK g= goal
                                            {
                                            match(input,SHRIEK,FOLLOW_SHRIEK_in_deed741); 

                                            pushFollow(FOLLOW_goal_in_deed745);
                                            g=goal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, g);

                                            }
                                            break;
                                        case 3 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:126:5: ADD_CONTENT l= literal
                                            {
                                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_deed755); 

                                            pushFollow(FOLLOW_literal_in_deed759);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContent, l);

                                            }
                                            break;
                                        case 4 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:127:5: ADD_CONTEXT l= literal
                                            {
                                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_deed769); 

                                            pushFollow(FOLLOW_literal_in_deed773);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContext, l);

                                            }
                                            break;
                                        case 5 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:128:5: ADD_PLAN p= literal
                                            {
                                            match(input,ADD_PLAN,FOLLOW_ADD_PLAN_in_deed783); 

                                            pushFollow(FOLLOW_literal_in_deed787);
                                            p=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILPlan, p);

                                            }
                                            break;
                                        case 6 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:129:5: ADD_CONSTRAINT c= literal
                                            {
                                            match(input,ADD_CONSTRAINT,FOLLOW_ADD_CONSTRAINT_in_deed797); 

                                            pushFollow(FOLLOW_literal_in_deed801);
                                            c=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILConstraint, c);

                                            }
                                            break;
                                        case 7 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:130:5: LOCK
                                            {
                                            match(input,LOCK,FOLLOW_LOCK_in_deed811); 

                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:131:7: MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK )
                                    {
                                    match(input,MINUS,FOLLOW_MINUS_in_deed824); 

                                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:131:13: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK )
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
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:131:14: l= literal
                                            {
                                            pushFollow(FOLLOW_literal_in_deed829);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, l);

                                            }
                                            break;
                                        case 2 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:132:5: SHRIEK g= goal
                                            {
                                            match(input,SHRIEK,FOLLOW_SHRIEK_in_deed839); 

                                            pushFollow(FOLLOW_goal_in_deed843);
                                            g=goal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, g);

                                            }
                                            break;
                                        case 3 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:133:5: ADD_CONTENT l= literal
                                            {
                                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_deed853); 

                                            pushFollow(FOLLOW_literal_in_deed857);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContent, l);

                                            }
                                            break;
                                        case 4 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:134:5: ADD_CONTEXT l= literal
                                            {
                                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_deed867); 

                                            pushFollow(FOLLOW_literal_in_deed871);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContext, l);

                                            }
                                            break;
                                        case 5 :
                                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:135:5: LOCK
                                            {
                                            match(input,LOCK,FOLLOW_LOCK_in_deed881); 

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
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:137:5: a= action
                            {
                            pushFollow(FOLLOW_action_in_deed900);
                            a=action();

                            state._fsp--;


                            d = new Abstract_Deed(a);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:138:5: wf= waitfor
                    {
                    pushFollow(FOLLOW_waitfor_in_deed913);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:1: brule returns [Abstract_Rule r] : head= literal ( BRULEARROW f= logicalfmla SEMI | SEMI ) ;
    public final Abstract_Rule brule() throws RecognitionException {
        Abstract_Rule r = null;


        Abstract_Literal head =null;

        Abstract_LogicalFormula f =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:33: (head= literal ( BRULEARROW f= logicalfmla SEMI | SEMI ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:35: head= literal ( BRULEARROW f= logicalfmla SEMI | SEMI )
            {
            pushFollow(FOLLOW_literal_in_brule948);
            head=literal();

            state._fsp--;


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:48: ( BRULEARROW f= logicalfmla SEMI | SEMI )
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
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:49: BRULEARROW f= logicalfmla SEMI
                    {
                    match(input,BRULEARROW,FOLLOW_BRULEARROW_in_brule951); 

                    pushFollow(FOLLOW_logicalfmla_in_brule955);
                    f=logicalfmla();

                    state._fsp--;


                    r = new Abstract_Rule(head, f);

                    match(input,SEMI,FOLLOW_SEMI_in_brule959); 

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:119: SEMI
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_brule963); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:147:1: logicalfmla returns [Abstract_LogicalFormula f] : n= notfmla ( COMMA n2= notfmla )* ;
    public final Abstract_LogicalFormula logicalfmla() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_LogicalFormula n =null;

        Abstract_LogicalFormula n2 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:147:49: (n= notfmla ( COMMA n2= notfmla )* )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:147:51: n= notfmla ( COMMA n2= notfmla )*
            {
            pushFollow(FOLLOW_notfmla_in_logicalfmla980);
            n=notfmla();

            state._fsp--;


            f = n;

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:148:16: ( COMMA n2= notfmla )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==COMMA) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:148:17: COMMA n2= notfmla
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_logicalfmla1000); 

            	    pushFollow(FOLLOW_notfmla_in_logicalfmla1004);
            	    n2=notfmla();

            	    state._fsp--;


            	    f = new Abstract_LogExpr(f, Abstract_LogExpr.and, n2);

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
        return f;
    }
    // $ANTLR end "logicalfmla"



    // $ANTLR start "notfmla"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:1: notfmla returns [Abstract_LogicalFormula f] : (gb= pred | NOT (gb2= pred |lf= subfmla ) );
    public final Abstract_LogicalFormula notfmla() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_Predicate gb =null;

        Abstract_Predicate gb2 =null;

        Abstract_LogicalFormula lf =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:45: (gb= pred | NOT (gb2= pred |lf= subfmla ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==CONST||LA29_0==VAR) ) {
                alt29=1;
            }
            else if ( (LA29_0==NOT) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:47: gb= pred
                    {
                    pushFollow(FOLLOW_pred_in_notfmla1039);
                    gb=pred();

                    state._fsp--;


                    f = gb;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:151:79: NOT (gb2= pred |lf= subfmla )
                    {
                    match(input,NOT,FOLLOW_NOT_in_notfmla1124); 

                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:151:83: (gb2= pred |lf= subfmla )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==CONST||LA28_0==VAR) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==OPEN) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 0, input);

                        throw nvae;

                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:151:84: gb2= pred
                            {
                            pushFollow(FOLLOW_pred_in_notfmla1131);
                            gb2=pred();

                            state._fsp--;


                            f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);

                            }
                            break;
                        case 2 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:151:153: lf= subfmla
                            {
                            pushFollow(FOLLOW_subfmla_in_notfmla1141);
                            lf=subfmla();

                            state._fsp--;


                            f = new Abstract_LogExpr(Abstract_LogExpr.not, lf);

                            }
                            break;

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
        return f;
    }
    // $ANTLR end "notfmla"



    // $ANTLR start "subfmla"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:152:1: subfmla returns [Abstract_LogicalFormula f] : OPEN lf= logicalfmla CLOSE ;
    public final Abstract_LogicalFormula subfmla() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_LogicalFormula lf =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:152:45: ( OPEN lf= logicalfmla CLOSE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:152:47: OPEN lf= logicalfmla CLOSE
            {
            match(input,OPEN,FOLLOW_OPEN_in_subfmla1155); 

            pushFollow(FOLLOW_logicalfmla_in_subfmla1161);
            lf=logicalfmla();

            state._fsp--;


            f = lf;

            match(input,CLOSE,FOLLOW_CLOSE_in_subfmla1165); 

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
    // $ANTLR end "subfmla"



    // $ANTLR start "waitfor"
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:155:1: waitfor returns [Abstract_Literal wf] : MULT l= literal ;
    public final Abstract_Literal waitfor() throws RecognitionException {
        Abstract_Literal wf = null;


        Abstract_Literal l =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:155:39: ( MULT l= literal )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:155:42: MULT l= literal
            {
            match(input,MULT,FOLLOW_MULT_in_waitfor1180); 

            pushFollow(FOLLOW_literal_in_waitfor1184);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:157:1: action returns [Abstract_Action a] : ( ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred );
    public final Abstract_Action action() throws RecognitionException {
        Abstract_Action a = null;


        Abstract_Literal an =null;

        int p =0;

        Abstract_Predicate t =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:157:36: ( ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==SEND) ) {
                alt30=1;
            }
            else if ( (LA30_0==CONST||LA30_0==VAR) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }
            switch (alt30) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:158:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
                    {
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:158:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:158:3: SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE
                    {
                    match(input,SEND,FOLLOW_SEND_in_action1201); 

                    match(input,OPEN,FOLLOW_OPEN_in_action1203); 

                    pushFollow(FOLLOW_literal_in_action1207);
                    an=literal();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_action1209); 

                    pushFollow(FOLLOW_performative_in_action1213);
                    p=performative();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_action1215); 

                    pushFollow(FOLLOW_pred_in_action1219);
                    t=pred();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_action1221); 

                    a = new Abstract_SendAction(an, p, t);

                    }


                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:159:2: t= pred
                    {
                    pushFollow(FOLLOW_pred_in_action1232);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:201:1: environment returns [String env] : w= classpath ;
    public final String environment() throws RecognitionException {
        String env = null;


        String w =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:201:34: (w= classpath )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:201:36: w= classpath
            {
            pushFollow(FOLLOW_classpath_in_environment1512);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:202:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
    public final String classpath() throws RecognitionException {
        String s = null;


        String w =null;

        String w1 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:202:30: (w= word ( POINT w1= word )+ )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:202:32: w= word ( POINT w1= word )+
            {
            pushFollow(FOLLOW_word_in_classpath1527);
            w=word();

            state._fsp--;


            s = w;

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:202:52: ( POINT w1= word )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==POINT) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:202:53: POINT w1= word
            	    {
            	    match(input,POINT,FOLLOW_POINT_in_classpath1532); 

            	    pushFollow(FOLLOW_word_in_classpath1536);
            	    w1=word();

            	    state._fsp--;


            	    s+="."; s+=w1;

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:1: word returns [String s] : ( CONST | VAR ) ;
    public final String word() throws RecognitionException {
        String s = null;


        Token CONST1=null;
        Token VAR2=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:25: ( ( CONST | VAR ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:27: ( CONST | VAR )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:27: ( CONST | VAR )
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
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:28: CONST
                    {
                    CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_word1637); 

                    s =CONST1.getText();

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:59: VAR
                    {
                    VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_word1643); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
    public final Abstract_StringTerm agentnameterm() throws RecognitionException {
        Abstract_StringTerm s = null;


        Token CONST3=null;
        Abstract_VarTerm v =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:47: ( CONST |v= var )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==CONST) ) {
                alt33=1;
            }
            else if ( (LA33_0==VAR) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }
            switch (alt33) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:49: CONST
                    {
                    CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm1743); 

                    s = new Abstract_StringTermImpl(CONST3.getText());

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:111: v= var
                    {
                    pushFollow(FOLLOW_var_in_agentnameterm1751);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:208:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
    public final Abstract_Literal literal() throws RecognitionException {
        Abstract_Literal l = null;


        Abstract_Predicate nt =null;

        Abstract_Predicate t =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:208:37: ( ( TRUE | NOT nt= pred ) |t= pred )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==NOT||LA35_0==TRUE) ) {
                alt35=1;
            }
            else if ( (LA35_0==CONST||LA35_0==VAR) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:208:40: ( TRUE | NOT nt= pred )
                    {
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:208:40: ( TRUE | NOT nt= pred )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==TRUE) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==NOT) ) {
                        alt34=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 0, input);

                        throw nvae;

                    }
                    switch (alt34) {
                        case 1 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:208:41: TRUE
                            {
                            match(input,TRUE,FOLLOW_TRUE_in_literal1767); 

                            l = new Abstract_Literal(Abstract_Literal.LTrue);

                            }
                            break;
                        case 2 :
                            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:209:5: NOT nt= pred
                            {
                            match(input,NOT,FOLLOW_NOT_in_literal1778); 

                            pushFollow(FOLLOW_pred_in_literal1782);
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
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:213:5: t= pred
                    {
                    pushFollow(FOLLOW_pred_in_literal1796);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:217:1: pred returns [Abstract_Predicate t] : (v= var |f= function );
    public final Abstract_Predicate pred() throws RecognitionException {
        Abstract_Predicate t = null;


        Abstract_VarTerm v =null;

        Abstract_Predicate f =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:217:37: (v= var |f= function )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==VAR) ) {
                alt36=1;
            }
            else if ( (LA36_0==CONST) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:217:39: v= var
                    {
                    pushFollow(FOLLOW_var_in_pred1812);
                    v=var();

                    state._fsp--;


                    t = v;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:217:59: f= function
                    {
                    pushFollow(FOLLOW_function_in_pred1819);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:218:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
    public final Abstract_Predicate function() throws RecognitionException {
        Abstract_Predicate f = null;


        Token CONST4=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:218:40: ( CONST ( OPEN terms[$f] CLOSE )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:218:42: CONST ( OPEN terms[$f] CLOSE )?
            {
            CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_function1831); 

            f = new Abstract_Predicate(CONST4.getText());

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:218:97: ( OPEN terms[$f] CLOSE )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==OPEN) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:218:98: OPEN terms[$f] CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_function1836); 

                    pushFollow(FOLLOW_terms_in_function1838);
                    terms(f);

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_function1841); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:220:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
    public final void terms(Abstract_Predicate f) throws RecognitionException {
        Abstract_Term t =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:220:29: (t= term ( COMMA terms[$f] )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:220:31: t= term ( COMMA terms[$f] )?
            {
            pushFollow(FOLLOW_term_in_terms1854);
            t=term();

            state._fsp--;


            f.addTerm(t);

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:220:58: ( COMMA terms[$f] )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==COMMA) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:220:59: COMMA terms[$f]
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_terms1859); 

                    pushFollow(FOLLOW_terms_in_terms1861);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:221:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |f= function );
    public final Abstract_Term term() throws RecognitionException {
        Abstract_Term t = null;


        Abstract_NumberTerm a =null;

        Abstract_StringTerm s =null;

        Abstract_Predicate f =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:221:31: (a= atom |s= stringterm |f= function )
            int alt39=3;
            switch ( input.LA(1) ) {
            case MINUS:
            case NUMBER:
            case OPEN:
            case VAR:
                {
                alt39=1;
                }
                break;
            case DOUBLEQUOTE:
                {
                alt39=2;
                }
                break;
            case CONST:
                {
                alt39=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }

            switch (alt39) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:221:34: a= atom
                    {
                    pushFollow(FOLLOW_atom_in_term1880);
                    a=atom();

                    state._fsp--;


                    t = a;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:221:58: s= stringterm
                    {
                    pushFollow(FOLLOW_stringterm_in_term1890);
                    s=stringterm();

                    state._fsp--;


                    t = s;

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:221:88: f= function
                    {
                    pushFollow(FOLLOW_function_in_term1898);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:223:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
    public final Abstract_NumberTerm atom() throws RecognitionException {
        Abstract_NumberTerm t = null;


        String n =null;

        Abstract_VarTerm v =null;

        Abstract_NumberTerm a =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:223:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
            int alt40=3;
            switch ( input.LA(1) ) {
            case MINUS:
            case NUMBER:
                {
                alt40=1;
                }
                break;
            case VAR:
                {
                alt40=2;
                }
                break;
            case OPEN:
                {
                alt40=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }

            switch (alt40) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:223:40: n= numberstring
                    {
                    pushFollow(FOLLOW_numberstring_in_atom1916);
                    n=numberstring();

                    state._fsp--;


                    t = new Abstract_NumberTermImpl(n);

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:224:6: v= var
                    {
                    pushFollow(FOLLOW_var_in_atom1929);
                    v=var();

                    state._fsp--;


                    t = v;

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:224:27: OPEN a= arithexpr CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_atom1935); 

                    pushFollow(FOLLOW_arithexpr_in_atom1939);
                    a=arithexpr();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_atom1941); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:225:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
    public final Abstract_StringTerm stringterm() throws RecognitionException {
        Abstract_StringTerm s = null;


        Token STRING5=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:225:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:225:46: DOUBLEQUOTE STRING DOUBLEQUOTE
            {
            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1954); 

            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm1957); 

            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1959); 

            		 
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:228:1: var returns [Abstract_VarTerm v] : VAR ;
    public final Abstract_VarTerm var() throws RecognitionException {
        Abstract_VarTerm v = null;


        Token VAR6=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:228:34: ( VAR )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:228:36: VAR
            {
            VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_var1973); 


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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
    public final String numberstring() throws RecognitionException {
        String s = null;


        Token n1=null;
        Token n2=null;

        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
            {
            s = "";

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:46: ( MINUS )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==MINUS) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:47: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_numberstring1990); 

                    s += "-";

                    }
                    break;

            }


            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:68: (n1= NUMBER ( POINT n2= NUMBER )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:69: n1= NUMBER ( POINT n2= NUMBER )?
            {
            n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1999); 

            s += n1.getText();

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:238:6: ( POINT n2= NUMBER )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==POINT) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:238:7: POINT n2= NUMBER
                    {
                    match(input,POINT,FOLLOW_POINT_in_numberstring2009); 

                    s += ".";

                    n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2015); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:239:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
    public final Abstract_Equation equation() throws RecognitionException {
        Abstract_Equation eq = null;


        Abstract_NumberTerm a1 =null;

        int oper =0;

        Abstract_NumberTerm a2 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:239:40: (a1= arithexpr oper= eqoper a2= arithexpr )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:239:42: a1= arithexpr oper= eqoper a2= arithexpr
            {
            pushFollow(FOLLOW_arithexpr_in_equation2032);
            a1=arithexpr();

            state._fsp--;


            pushFollow(FOLLOW_eqoper_in_equation2036);
            oper=eqoper();

            state._fsp--;


            pushFollow(FOLLOW_arithexpr_in_equation2040);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:1: eqoper returns [int oper] : ( LESS | EQ );
    public final int eqoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:27: ( LESS | EQ )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==LESS) ) {
                alt43=1;
            }
            else if ( (LA43_0==EQ) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }
            switch (alt43) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:29: LESS
                    {
                    match(input,LESS,FOLLOW_LESS_in_eqoper2054); 

                    oper =Abstract_Equation.less;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:68: EQ
                    {
                    match(input,EQ,FOLLOW_EQ_in_eqoper2060); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:242:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
    public final Abstract_NumberTerm arithexpr() throws RecognitionException {
        Abstract_NumberTerm t = null;


        Abstract_NumberTerm m =null;

        int oper =0;

        Abstract_NumberTerm m1 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:242:43: (m= multexpr (oper= addoper m1= multexpr )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:242:45: m= multexpr (oper= addoper m1= multexpr )?
            {
            pushFollow(FOLLOW_multexpr_in_arithexpr2076);
            m=multexpr();

            state._fsp--;


            t = m;

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:242:69: (oper= addoper m1= multexpr )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==MINUS||LA44_0==PLUS) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:242:71: oper= addoper m1= multexpr
                    {
                    pushFollow(FOLLOW_addoper_in_arithexpr2084);
                    oper=addoper();

                    state._fsp--;


                    pushFollow(FOLLOW_multexpr_in_arithexpr2088);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:243:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
    public final Abstract_NumberTerm multexpr() throws RecognitionException {
        Abstract_NumberTerm t = null;


        Abstract_NumberTerm a =null;

        int oper =0;

        Abstract_NumberTerm a1 =null;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:243:42: (a= atom (oper= multoper a1= atom )? )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:243:44: a= atom (oper= multoper a1= atom )?
            {
            pushFollow(FOLLOW_atom_in_multexpr2105);
            a=atom();

            state._fsp--;


            t = a;

            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:243:64: (oper= multoper a1= atom )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==DIV||(LA45_0 >= MOD && LA45_0 <= MULT)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:243:65: oper= multoper a1= atom
                    {
                    pushFollow(FOLLOW_multoper_in_multexpr2112);
                    oper=multoper();

                    state._fsp--;


                    pushFollow(FOLLOW_atom_in_multexpr2116);
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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:245:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
    public final int addoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:245:28: ( ( PLUS | MINUS ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:245:30: ( PLUS | MINUS )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:245:30: ( PLUS | MINUS )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==PLUS) ) {
                alt46=1;
            }
            else if ( (LA46_0==MINUS) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }
            switch (alt46) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:245:31: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_addoper2133); 

                    oper =Abstract_ArithExpr.plus;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:245:70: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_addoper2138); 

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
    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:246:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
    public final int multoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:246:29: ( ( MULT | DIV | MOD ) )
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:246:31: ( MULT | DIV | MOD )
            {
            // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:246:31: ( MULT | DIV | MOD )
            int alt47=3;
            switch ( input.LA(1) ) {
            case MULT:
                {
                alt47=1;
                }
                break;
            case DIV:
                {
                alt47=2;
                }
                break;
            case MOD:
                {
                alt47=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }

            switch (alt47) {
                case 1 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:246:32: MULT
                    {
                    match(input,MULT,FOLLOW_MULT_in_multoper2153); 

                    oper =Abstract_ArithExpr.times;

                    }
                    break;
                case 2 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:246:73: DIV
                    {
                    match(input,DIV,FOLLOW_DIV_in_multoper2159); 

                    oper =Abstract_ArithExpr.div;

                    }
                    break;
                case 3 :
                    // /Users/louiseadennis/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:246:111: MOD
                    {
                    match(input,MOD,FOLLOW_MOD_in_multoper2165); 

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
    public static final BitSet FOLLOW_BELIEFRULES_in_gwendolenagent168 = new BitSet(new long[]{0x0C00004004040000L});
    public static final BitSet FOLLOW_brule_in_gwendolenagent173 = new BitSet(new long[]{0x0C00004004040000L});
    public static final BitSet FOLLOW_GOALS_in_gwendolenagent182 = new BitSet(new long[]{0x0C00084000040000L});
    public static final BitSet FOLLOW_goal_in_gwendolenagent187 = new BitSet(new long[]{0x0C00084000040000L});
    public static final BitSet FOLLOW_PLANS_in_gwendolenagent194 = new BitSet(new long[]{0x0000100200000002L});
    public static final BitSet FOLLOW_plan_in_gwendolenagent199 = new BitSet(new long[]{0x0000100200000002L});
    public static final BitSet FOLLOW_BELIEVE_in_guard_atom218 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_guard_atom222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GOAL_in_guard_atom232 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_guard_atom236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SENT_in_guard_atom246 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_guard_atom248 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_agentnameterm_in_guard_atom255 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_guard_atom289 = new BitSet(new long[]{0x0B000200000C0010L});
    public static final BitSet FOLLOW_agentnameterm_in_guard_atom296 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_guard_atom304 = new BitSet(new long[]{0x0300020000080010L});
    public static final BitSet FOLLOW_performative_in_guard_atom312 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_guard_atom320 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_pred_in_guard_atom324 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_guard_atom326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equation_in_guard_atom340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_guard_atom350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_goal384 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_SQOPEN_in_goal386 = new BitSet(new long[]{0x0000040000000020L});
    public static final BitSet FOLLOW_ACHIEVEGOAL_in_goal389 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_PERFORMGOAL_in_goal399 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_goal404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_in_plan418 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_plan426 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_plan428 = new BitSet(new long[]{0x0C0801C202001000L});
    public static final BitSet FOLLOW_NOT_in_plan433 = new BitSet(new long[]{0x0C08018202001000L});
    public static final BitSet FOLLOW_guard_atom_in_plan441 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_COMMA_in_plan449 = new BitSet(new long[]{0x0C0801C202001000L});
    public static final BitSet FOLLOW_NOT_in_plan454 = new BitSet(new long[]{0x0C08018202001000L});
    public static final BitSet FOLLOW_guard_atom_in_plan462 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_plan468 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_RULEARROW_in_plan471 = new BitSet(new long[]{0x0804100A00040000L});
    public static final BitSet FOLLOW_deed_in_plan476 = new BitSet(new long[]{0x0002000000010000L});
    public static final BitSet FOLLOW_COMMA_in_plan481 = new BitSet(new long[]{0x0804100A00040000L});
    public static final BitSet FOLLOW_deed_in_plan485 = new BitSet(new long[]{0x0002000000010000L});
    public static final BitSet FOLLOW_SEMI_in_plan495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_event511 = new BitSet(new long[]{0x0C10804000040180L});
    public static final BitSet FOLLOW_RECEIVED_in_event514 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_event516 = new BitSet(new long[]{0x0300020000080010L});
    public static final BitSet FOLLOW_performative_in_event520 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_event522 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_pred_in_event526 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_event528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_event546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_event556 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_event560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_event571 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_event575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_event585 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_event589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_event607 = new BitSet(new long[]{0x0C10004000040180L});
    public static final BitSet FOLLOW_literal_in_event612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_event622 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_event626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_event636 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_event640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_event650 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_event654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TELL_in_performative676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERFORM_in_performative682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACHIEVE_in_performative688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TELLHOW_in_performative694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTRAINT_in_performative700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_deed726 = new BitSet(new long[]{0x0C100041000403C0L});
    public static final BitSet FOLLOW_literal_in_deed731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_deed741 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_deed745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_deed755 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_deed769 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_PLAN_in_deed783 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONSTRAINT_in_deed797 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_in_deed811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_deed824 = new BitSet(new long[]{0x0C10004100040180L});
    public static final BitSet FOLLOW_literal_in_deed829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_deed839 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_deed843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_deed853 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_deed867 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_in_deed881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_deed900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_waitfor_in_deed913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_brule948 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_BRULEARROW_in_brule951 = new BitSet(new long[]{0x0800004000040000L});
    public static final BitSet FOLLOW_logicalfmla_in_brule955 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_SEMI_in_brule959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_brule963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notfmla_in_logicalfmla980 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_COMMA_in_logicalfmla1000 = new BitSet(new long[]{0x0800004000040000L});
    public static final BitSet FOLLOW_notfmla_in_logicalfmla1004 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_pred_in_notfmla1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_notfmla1124 = new BitSet(new long[]{0x0800010000040000L});
    public static final BitSet FOLLOW_pred_in_notfmla1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subfmla_in_notfmla1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_subfmla1155 = new BitSet(new long[]{0x0800004000040000L});
    public static final BitSet FOLLOW_logicalfmla_in_subfmla1161 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_subfmla1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULT_in_waitfor1180 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_waitfor1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEND_in_action1201 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_action1203 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_action1207 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_action1209 = new BitSet(new long[]{0x0300020000080010L});
    public static final BitSet FOLLOW_performative_in_action1213 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_action1215 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_pred_in_action1219 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_action1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pred_in_action1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classpath_in_environment1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_word_in_classpath1527 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_POINT_in_classpath1532 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_word_in_classpath1536 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_CONST_in_word1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_word1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_agentnameterm1743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_agentnameterm1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_literal1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_literal1778 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_pred_in_literal1782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pred_in_literal1796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_pred1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_pred1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_function1831 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_OPEN_in_function1836 = new BitSet(new long[]{0x0800018200840000L});
    public static final BitSet FOLLOW_terms_in_function1838 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_function1841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_terms1854 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_COMMA_in_terms1859 = new BitSet(new long[]{0x0800018200840000L});
    public static final BitSet FOLLOW_terms_in_terms1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_term1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringterm_in_term1890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_term1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numberstring_in_atom1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_atom1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_atom1935 = new BitSet(new long[]{0x0800018200000000L});
    public static final BitSet FOLLOW_arithexpr_in_atom1939 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_atom1941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1954 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_STRING_in_stringterm1957 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_var1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_numberstring1990 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring1999 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_POINT_in_numberstring2009 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithexpr_in_equation2032 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_eqoper_in_equation2036 = new BitSet(new long[]{0x0800018200000000L});
    public static final BitSet FOLLOW_arithexpr_in_equation2040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_in_eqoper2054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_eqoper2060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr2076 = new BitSet(new long[]{0x0000100200000002L});
    public static final BitSet FOLLOW_addoper_in_arithexpr2084 = new BitSet(new long[]{0x0800018200000000L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_multexpr2105 = new BitSet(new long[]{0x0000000C00400002L});
    public static final BitSet FOLLOW_multoper_in_multexpr2112 = new BitSet(new long[]{0x0800018200000000L});
    public static final BitSet FOLLOW_atom_in_multexpr2116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_addoper2133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_addoper2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULT_in_multoper2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_multoper2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOD_in_multoper2165 = new BitSet(new long[]{0x0000000000000002L});

}