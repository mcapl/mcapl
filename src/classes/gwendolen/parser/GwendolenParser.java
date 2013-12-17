// $ANTLR 3.4 /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g 2013-12-17 15:36:43

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
    public String getGrammarFileName() { return "/Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g"; }


    	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
    	private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");
    	


    // $ANTLR start "mas"
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:58:1: mas returns [Abstract_MAS mas] :glist= gwendolenagents ;
    public final Abstract_MAS mas() throws RecognitionException {
        Abstract_MAS mas = null;


        ArrayList<Abstract_GwendolenAgent> glist =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:58:32: (glist= gwendolenagents )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:58:34: glist= gwendolenagents
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:61:1: gwendolenagents returns [ArrayList<Abstract_GwendolenAgent> gags] : GWENDOLEN (g= gwendolenagent )+ ;
    public final ArrayList<Abstract_GwendolenAgent> gwendolenagents() throws RecognitionException {
        ArrayList<Abstract_GwendolenAgent> gags = null;


        Abstract_GwendolenAgent g =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:61:65: ( GWENDOLEN (g= gwendolenagent )+ )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:61:67: GWENDOLEN (g= gwendolenagent )+
            {
            match(input,GWENDOLEN,FOLLOW_GWENDOLEN_in_gwendolenagents102); 

            gags=new ArrayList<Abstract_GwendolenAgent>();

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:63:2: (g= gwendolenagent )+
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
            	    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:63:3: g= gwendolenagent
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:66:1: gwendolenagent returns [Abstract_GwendolenAgent g] : ( ( GWENDOLEN )? ) NAME w= word BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOALS (gl= goal )* PLANS (p= plan )* ;
    public final Abstract_GwendolenAgent gwendolenagent() throws RecognitionException {
        Abstract_GwendolenAgent g = null;


        String w =null;

        Abstract_Literal l =null;

        Abstract_Rule r =null;

        Abstract_Goal gl =null;

        Abstract_GPlan p =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:66:52: ( ( ( GWENDOLEN )? ) NAME w= word BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOALS (gl= goal )* PLANS (p= plan )* )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:67:9: ( ( GWENDOLEN )? ) NAME w= word BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOALS (gl= goal )* PLANS (p= plan )*
            {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:67:9: ( ( GWENDOLEN )? )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:67:10: ( GWENDOLEN )?
            {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:67:10: ( GWENDOLEN )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==GWENDOLEN) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:67:10: GWENDOLEN
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

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:70:10: (l= literal )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==CONST||LA3_0==NOT||(LA3_0 >= TRUE && LA3_0 <= VAR)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:70:11: l= literal
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


            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:71:2: ( BELIEFRULES (r= brule )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==BELIEFRULES) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:71:3: BELIEFRULES (r= brule )*
                    {
                    match(input,BELIEFRULES,FOLLOW_BELIEFRULES_in_gwendolenagent168); 

                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:71:15: (r= brule )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==CONST||LA4_0==NOT||(LA4_0 >= TRUE && LA4_0 <= VAR)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:71:16: r= brule
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

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:72:8: (gl= goal )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==CONST||LA6_0==NOT||(LA6_0 >= TRUE && LA6_0 <= VAR)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:72:9: gl= goal
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

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:73:8: (p= plan )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==MINUS||LA7_0==PLUS) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:73:9: p= plan
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:1: guard_atom returns [Abstract_GLogicalFormula g] : ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE ) ;
    public final Abstract_GLogicalFormula guard_atom() throws RecognitionException {
        Abstract_GLogicalFormula g = null;


        Abstract_Literal l =null;

        Abstract_Goal gl =null;

        Abstract_StringTerm s =null;

        Abstract_VarTerm v =null;

        Abstract_StringTerm an2 =null;

        int p =0;

        Abstract_Predicate t =null;

        Abstract_Equation eq =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:49: ( ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE ) )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE )
            int alt10=5;
            switch ( input.LA(1) ) {
            case BELIEVE:
                {
                alt10=1;
                }
                break;
            case GOAL:
                {
                alt10=2;
                }
                break;
            case SENT:
                {
                alt10=3;
                }
                break;
            case MINUS:
            case NUMBER:
            case OPEN:
            case VAR:
                {
                alt10=4;
                }
                break;
            case TRUE:
                {
                alt10=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:52: BELIEVE l= literal
                    {
                    match(input,BELIEVE,FOLLOW_BELIEVE_in_guard_atom218); 

                    pushFollow(FOLLOW_literal_in_guard_atom222);
                    l=literal();

                    state._fsp--;


                    g = new Abstract_GBelief(l);

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:77:5: GOAL gl= goal
                    {
                    match(input,GOAL,FOLLOW_GOAL_in_guard_atom232); 

                    pushFollow(FOLLOW_goal_in_guard_atom236);
                    gl=goal();

                    state._fsp--;


                    g = new Abstract_Goal(gl);

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:78:5: SENT OPEN (s= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE
                    {
                    match(input,SENT,FOLLOW_SENT_in_guard_atom246); 

                    match(input,OPEN,FOLLOW_OPEN_in_guard_atom248); 

                    Abstract_StringTerm an1=agentname;

                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:78:52: (s= stringterm |v= var )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==DOUBLEQUOTE) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==VAR) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;

                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:78:53: s= stringterm
                            {
                            pushFollow(FOLLOW_stringterm_in_guard_atom255);
                            s=stringterm();

                            state._fsp--;


                            an1=s;

                            }
                            break;
                        case 2 :
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:78:77: v= var
                            {
                            pushFollow(FOLLOW_var_in_guard_atom263);
                            v=var();

                            state._fsp--;


                            an1 = v;

                            }
                            break;

                    }


                    match(input,COMMA,FOLLOW_COMMA_in_guard_atom268); 

                    Abstract_StringTerm agn = agentname;

                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:78:140: (an2= stringterm COMMA )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==DOUBLEQUOTE) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:78:141: an2= stringterm COMMA
                            {
                            pushFollow(FOLLOW_stringterm_in_guard_atom275);
                            an2=stringterm();

                            state._fsp--;


                            match(input,COMMA,FOLLOW_COMMA_in_guard_atom283); 

                            agn = an2;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_performative_in_guard_atom291);
                    p=performative();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_guard_atom299); 

                    pushFollow(FOLLOW_pred_in_guard_atom303);
                    t=pred();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_guard_atom305); 

                    g = new Abstract_GuardMessage(Abstract_BaseAILStructure.AILSent, agn, an1, p, t);

                    }
                    break;
                case 4 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:81:5: eq= equation
                    {
                    pushFollow(FOLLOW_equation_in_guard_atom319);
                    eq=equation();

                    state._fsp--;


                    g = eq;

                    }
                    break;
                case 5 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:82:5: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_guard_atom329); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:96:1: goal returns [Abstract_Goal g] : l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE ;
    public final Abstract_Goal goal() throws RecognitionException {
        Abstract_Goal g = null;


        Abstract_Literal l =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:96:32: (l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:96:34: l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE
            {
            pushFollow(FOLLOW_literal_in_goal363);
            l=literal();

            state._fsp--;


            match(input,SQOPEN,FOLLOW_SQOPEN_in_goal365); 

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:96:51: ( ACHIEVEGOAL | PERFORMGOAL )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ACHIEVEGOAL) ) {
                alt11=1;
            }
            else if ( (LA11_0==PERFORMGOAL) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:96:52: ACHIEVEGOAL
                    {
                    match(input,ACHIEVEGOAL,FOLLOW_ACHIEVEGOAL_in_goal368); 

                    g = new Abstract_Goal(l, Abstract_Goal.achieveGoal);

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:4: PERFORMGOAL
                    {
                    match(input,PERFORMGOAL,FOLLOW_PERFORMGOAL_in_goal378); 

                    g = new Abstract_Goal(l, Abstract_Goal.performGoal);

                    }
                    break;

            }


            match(input,SQCLOSE,FOLLOW_SQCLOSE_in_goal383); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:98:1: plan returns [Abstract_GPlan p] : e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI ;
    public final Abstract_GPlan plan() throws RecognitionException {
        Abstract_GPlan p = null;


        Abstract_Event e =null;

        Abstract_GLogicalFormula gb =null;

        Abstract_Deed d =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:99:2: (e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:99:4: e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI
            {
            pushFollow(FOLLOW_event_in_plan397);
            e=event();

            state._fsp--;


            ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();

            match(input,COLON,FOLLOW_COLON_in_plan405); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_plan407); 

            boolean gneg=true;

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:100:40: ( NOT )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NOT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:100:41: NOT
                    {
                    match(input,NOT,FOLLOW_NOT_in_plan412); 

                    gneg=false;

                    }
                    break;

            }


            pushFollow(FOLLOW_guard_atom_in_plan420);
            gb=guard_atom();

            state._fsp--;


            g.add(gb, gneg);

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:101:3: ( COMMA ( NOT )? gb= guard_atom )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==COMMA) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:101:4: COMMA ( NOT )? gb= guard_atom
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_plan428); 

            	    gneg=true;

            	    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:101:23: ( NOT )?
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==NOT) ) {
            	        alt13=1;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:101:24: NOT
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

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_plan447); 

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:101:93: ( RULEARROW d= deed ( COMMA d= deed )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULEARROW) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:101:94: RULEARROW d= deed ( COMMA d= deed )*
                    {
                    match(input,RULEARROW,FOLLOW_RULEARROW_in_plan450); 

                    pushFollow(FOLLOW_deed_in_plan455);
                    d=deed();

                    state._fsp--;


                    deeds.add(d);

                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:28: ( COMMA d= deed )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==COMMA) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:29: COMMA d= deed
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_plan460); 

                    	    pushFollow(FOLLOW_deed_in_plan464);
                    	    d=deed();

                    	    state._fsp--;


                    	    deeds.add(d);

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,SEMI,FOLLOW_SEMI_in_plan474); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:105:1: event returns [Abstract_Event e] : ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) ) ;
    public final Abstract_Event event() throws RecognitionException {
        Abstract_Event e = null;


        int p =0;

        Abstract_Predicate t =null;

        Abstract_Literal l =null;

        Abstract_Goal g =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:105:34: ( ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) ) )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:105:36: ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:105:36: ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==PLUS) ) {
                alt20=1;
            }
            else if ( (LA20_0==MINUS) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:105:37: PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_event490); 

                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:105:42: ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
                    int alt18=4;
                    switch ( input.LA(1) ) {
                    case RECEIVED:
                        {
                        alt18=1;
                        }
                        break;
                    case CONST:
                    case NOT:
                    case SHRIEK:
                    case TRUE:
                    case VAR:
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
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:105:43: RECEIVED OPEN p= performative COMMA t= pred CLOSE
                            {
                            match(input,RECEIVED,FOLLOW_RECEIVED_in_event493); 

                            match(input,OPEN,FOLLOW_OPEN_in_event495); 

                            pushFollow(FOLLOW_performative_in_event499);
                            p=performative();

                            state._fsp--;


                            match(input,COMMA,FOLLOW_COMMA_in_event501); 

                            pushFollow(FOLLOW_pred_in_event505);
                            t=pred();

                            state._fsp--;


                            match(input,CLOSE,FOLLOW_CLOSE_in_event507); 

                            Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), 
                            						new Abstract_VarTerm("To"), p, t); 
                            						e = new Abstract_Event(Abstract_Event.AILAddition, 
                            						Abstract_Event.AILReceived, message);

                            }
                            break;
                        case 2 :
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:110:5: (l= literal | SHRIEK g= goal )
                            {
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:110:5: (l= literal | SHRIEK g= goal )
                            int alt17=2;
                            int LA17_0 = input.LA(1);

                            if ( (LA17_0==CONST||LA17_0==NOT||(LA17_0 >= TRUE && LA17_0 <= VAR)) ) {
                                alt17=1;
                            }
                            else if ( (LA17_0==SHRIEK) ) {
                                alt17=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 17, 0, input);

                                throw nvae;

                            }
                            switch (alt17) {
                                case 1 :
                                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:110:6: l= literal
                                    {
                                    pushFollow(FOLLOW_literal_in_event525);
                                    l=literal();

                                    state._fsp--;


                                    e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, l);

                                    }
                                    break;
                                case 2 :
                                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:111:5: SHRIEK g= goal
                                    {
                                    match(input,SHRIEK,FOLLOW_SHRIEK_in_event535); 

                                    pushFollow(FOLLOW_goal_in_event539);
                                    g=goal();

                                    state._fsp--;


                                    e = new Abstract_Event(Abstract_Event.AILAddition, g);

                                    }
                                    break;

                            }


                            }
                            break;
                        case 3 :
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:112:5: ADD_CONTENT l= literal
                            {
                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_event550); 

                            pushFollow(FOLLOW_literal_in_event554);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContent, l);

                            }
                            break;
                        case 4 :
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:113:5: ADD_CONTEXT l= literal
                            {
                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_event564); 

                            pushFollow(FOLLOW_literal_in_event568);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContext, l);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:7: MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_event586); 

                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:13: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
                    int alt19=4;
                    switch ( input.LA(1) ) {
                    case CONST:
                    case NOT:
                    case TRUE:
                    case VAR:
                        {
                        alt19=1;
                        }
                        break;
                    case SHRIEK:
                        {
                        alt19=2;
                        }
                        break;
                    case ADD_CONTENT:
                        {
                        alt19=3;
                        }
                        break;
                    case ADD_CONTEXT:
                        {
                        alt19=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;

                    }

                    switch (alt19) {
                        case 1 :
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:115:14: l= literal
                            {
                            pushFollow(FOLLOW_literal_in_event591);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, l);

                            }
                            break;
                        case 2 :
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:116:5: SHRIEK g= goal
                            {
                            match(input,SHRIEK,FOLLOW_SHRIEK_in_event601); 

                            pushFollow(FOLLOW_goal_in_event605);
                            g=goal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILDeletion, g);

                            }
                            break;
                        case 3 :
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:117:5: ADD_CONTENT l= literal
                            {
                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_event615); 

                            pushFollow(FOLLOW_literal_in_event619);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContent, l);

                            }
                            break;
                        case 4 :
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:118:5: ADD_CONTEXT l= literal
                            {
                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_event629); 

                            pushFollow(FOLLOW_literal_in_event633);
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:121:1: performative returns [int b] : ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT ) ;
    public final int performative() throws RecognitionException {
        int b = 0;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:121:30: ( ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT ) )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:121:32: ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:121:32: ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT )
            int alt21=5;
            switch ( input.LA(1) ) {
            case TELL:
                {
                alt21=1;
                }
                break;
            case PERFORM:
                {
                alt21=2;
                }
                break;
            case ACHIEVE:
                {
                alt21=3;
                }
                break;
            case TELLHOW:
                {
                alt21=4;
                }
                break;
            case CONSTRAINT:
                {
                alt21=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }

            switch (alt21) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:121:33: TELL
                    {
                    match(input,TELL,FOLLOW_TELL_in_performative655); 

                    b =1;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:121:48: PERFORM
                    {
                    match(input,PERFORM,FOLLOW_PERFORM_in_performative661); 

                    b =2;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:121:66: ACHIEVE
                    {
                    match(input,ACHIEVE,FOLLOW_ACHIEVE_in_performative667); 

                    b = 3;

                    }
                    break;
                case 4 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:121:86: TELLHOW
                    {
                    match(input,TELLHOW,FOLLOW_TELLHOW_in_performative673); 

                    b = 4;

                    }
                    break;
                case 5 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:121:106: CONSTRAINT
                    {
                    match(input,CONSTRAINT,FOLLOW_CONSTRAINT_in_performative679); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:123:1: deed returns [Abstract_Deed d] : ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor ) ;
    public final Abstract_Deed deed() throws RecognitionException {
        Abstract_Deed d = null;


        Abstract_Literal l =null;

        Abstract_Goal g =null;

        Abstract_Literal p =null;

        Abstract_Literal c =null;

        Abstract_Action a =null;

        Abstract_Literal wf =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:123:32: ( ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor ) )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:123:34: ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:123:34: ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==CONST||LA26_0==MINUS||LA26_0==PLUS||LA26_0==SEND||LA26_0==VAR) ) {
                alt26=1;
            }
            else if ( (LA26_0==MULT) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }
            switch (alt26) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:123:35: ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action )
                    {
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:123:35: ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==MINUS||LA25_0==PLUS) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==CONST||LA25_0==SEND||LA25_0==VAR) ) {
                        alt25=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;

                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:123:36: ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) )
                            {
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:123:36: ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) )
                            int alt24=2;
                            int LA24_0 = input.LA(1);

                            if ( (LA24_0==PLUS) ) {
                                alt24=1;
                            }
                            else if ( (LA24_0==MINUS) ) {
                                alt24=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 24, 0, input);

                                throw nvae;

                            }
                            switch (alt24) {
                                case 1 :
                                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:123:37: PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK )
                                    {
                                    match(input,PLUS,FOLLOW_PLUS_in_deed705); 

                                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:123:42: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK )
                                    int alt22=7;
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
                                    case ADD_PLAN:
                                        {
                                        alt22=5;
                                        }
                                        break;
                                    case ADD_CONSTRAINT:
                                        {
                                        alt22=6;
                                        }
                                        break;
                                    case LOCK:
                                        {
                                        alt22=7;
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 22, 0, input);

                                        throw nvae;

                                    }

                                    switch (alt22) {
                                        case 1 :
                                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:123:43: l= literal
                                            {
                                            pushFollow(FOLLOW_literal_in_deed710);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, l);

                                            }
                                            break;
                                        case 2 :
                                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:5: SHRIEK g= goal
                                            {
                                            match(input,SHRIEK,FOLLOW_SHRIEK_in_deed720); 

                                            pushFollow(FOLLOW_goal_in_deed724);
                                            g=goal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, g);

                                            }
                                            break;
                                        case 3 :
                                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:125:5: ADD_CONTENT l= literal
                                            {
                                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_deed734); 

                                            pushFollow(FOLLOW_literal_in_deed738);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContent, l);

                                            }
                                            break;
                                        case 4 :
                                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:126:5: ADD_CONTEXT l= literal
                                            {
                                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_deed748); 

                                            pushFollow(FOLLOW_literal_in_deed752);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContext, l);

                                            }
                                            break;
                                        case 5 :
                                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:127:5: ADD_PLAN p= literal
                                            {
                                            match(input,ADD_PLAN,FOLLOW_ADD_PLAN_in_deed762); 

                                            pushFollow(FOLLOW_literal_in_deed766);
                                            p=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILPlan, p);

                                            }
                                            break;
                                        case 6 :
                                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:128:5: ADD_CONSTRAINT c= literal
                                            {
                                            match(input,ADD_CONSTRAINT,FOLLOW_ADD_CONSTRAINT_in_deed776); 

                                            pushFollow(FOLLOW_literal_in_deed780);
                                            c=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILConstraint, c);

                                            }
                                            break;
                                        case 7 :
                                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:129:5: LOCK
                                            {
                                            match(input,LOCK,FOLLOW_LOCK_in_deed790); 

                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:130:7: MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK )
                                    {
                                    match(input,MINUS,FOLLOW_MINUS_in_deed803); 

                                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:130:13: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK )
                                    int alt23=5;
                                    switch ( input.LA(1) ) {
                                    case CONST:
                                    case NOT:
                                    case TRUE:
                                    case VAR:
                                        {
                                        alt23=1;
                                        }
                                        break;
                                    case SHRIEK:
                                        {
                                        alt23=2;
                                        }
                                        break;
                                    case ADD_CONTENT:
                                        {
                                        alt23=3;
                                        }
                                        break;
                                    case ADD_CONTEXT:
                                        {
                                        alt23=4;
                                        }
                                        break;
                                    case LOCK:
                                        {
                                        alt23=5;
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 23, 0, input);

                                        throw nvae;

                                    }

                                    switch (alt23) {
                                        case 1 :
                                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:130:14: l= literal
                                            {
                                            pushFollow(FOLLOW_literal_in_deed808);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, l);

                                            }
                                            break;
                                        case 2 :
                                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:131:5: SHRIEK g= goal
                                            {
                                            match(input,SHRIEK,FOLLOW_SHRIEK_in_deed818); 

                                            pushFollow(FOLLOW_goal_in_deed822);
                                            g=goal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, g);

                                            }
                                            break;
                                        case 3 :
                                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:132:5: ADD_CONTENT l= literal
                                            {
                                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_deed832); 

                                            pushFollow(FOLLOW_literal_in_deed836);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContent, l);

                                            }
                                            break;
                                        case 4 :
                                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:133:5: ADD_CONTEXT l= literal
                                            {
                                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_deed846); 

                                            pushFollow(FOLLOW_literal_in_deed850);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContext, l);

                                            }
                                            break;
                                        case 5 :
                                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:134:5: LOCK
                                            {
                                            match(input,LOCK,FOLLOW_LOCK_in_deed860); 

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
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:136:5: a= action
                            {
                            pushFollow(FOLLOW_action_in_deed879);
                            a=action();

                            state._fsp--;


                            d = new Abstract_Deed(a);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:137:5: wf= waitfor
                    {
                    pushFollow(FOLLOW_waitfor_in_deed892);
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:144:1: brule returns [Abstract_Rule r] : head= literal ( BRULEARROW f= logicalfmla SEMI | SEMI ) ;
    public final Abstract_Rule brule() throws RecognitionException {
        Abstract_Rule r = null;


        Abstract_Literal head =null;

        Abstract_LogicalFormula f =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:144:33: (head= literal ( BRULEARROW f= logicalfmla SEMI | SEMI ) )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:144:35: head= literal ( BRULEARROW f= logicalfmla SEMI | SEMI )
            {
            pushFollow(FOLLOW_literal_in_brule927);
            head=literal();

            state._fsp--;


            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:144:48: ( BRULEARROW f= logicalfmla SEMI | SEMI )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==BRULEARROW) ) {
                alt27=1;
            }
            else if ( (LA27_0==SEMI) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:144:49: BRULEARROW f= logicalfmla SEMI
                    {
                    match(input,BRULEARROW,FOLLOW_BRULEARROW_in_brule930); 

                    pushFollow(FOLLOW_logicalfmla_in_brule934);
                    f=logicalfmla();

                    state._fsp--;


                    r = new Abstract_Rule(head, f);

                    match(input,SEMI,FOLLOW_SEMI_in_brule938); 

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:6: SEMI
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_brule948); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:146:1: logicalfmla returns [Abstract_LogicalFormula f] : (n= notfmla |a= andfmla |gb= literal );
    public final Abstract_LogicalFormula logicalfmla() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_LogicalFormula n =null;

        Abstract_LogicalFormula a =null;

        Abstract_Literal gb =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:146:49: (n= notfmla |a= andfmla |gb= literal )
            int alt28=3;
            switch ( input.LA(1) ) {
            case NOT:
                {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==OPEN) ) {
                    alt28=1;
                }
                else if ( (LA28_1==CONST||LA28_1==VAR) ) {
                    alt28=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;

                }
                }
                break;
            case OPEN:
                {
                alt28=2;
                }
                break;
            case CONST:
            case TRUE:
            case VAR:
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
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:146:51: n= notfmla
                    {
                    pushFollow(FOLLOW_notfmla_in_logicalfmla964);
                    n=notfmla();

                    state._fsp--;


                    f = n;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:146:75: a= andfmla
                    {
                    pushFollow(FOLLOW_andfmla_in_logicalfmla971);
                    a=andfmla();

                    state._fsp--;


                    f = a;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:146:100: gb= literal
                    {
                    pushFollow(FOLLOW_literal_in_logicalfmla981);
                    gb=literal();

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:147:1: notfmla returns [Abstract_LogicalFormula f] : NOT OPEN lf= logicalfmla CLOSE ;
    public final Abstract_LogicalFormula notfmla() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_LogicalFormula lf =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:147:45: ( NOT OPEN lf= logicalfmla CLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:147:47: NOT OPEN lf= logicalfmla CLOSE
            {
            match(input,NOT,FOLLOW_NOT_in_notfmla994); 

            match(input,OPEN,FOLLOW_OPEN_in_notfmla996); 

            pushFollow(FOLLOW_logicalfmla_in_notfmla1002);
            lf=logicalfmla();

            state._fsp--;


            f = new Abstract_LogExpr(Abstract_LogExpr.not, lf);

            match(input,CLOSE,FOLLOW_CLOSE_in_notfmla1006); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:148:1: andfmla returns [Abstract_LogicalFormula f] : OPEN f1= logicalfmla COMMA and= logicalfmla CLOSE ;
    public final Abstract_LogicalFormula andfmla() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_LogicalFormula f1 =null;

        Abstract_LogicalFormula and =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:148:45: ( OPEN f1= logicalfmla COMMA and= logicalfmla CLOSE )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:148:47: OPEN f1= logicalfmla COMMA and= logicalfmla CLOSE
            {
            match(input,OPEN,FOLLOW_OPEN_in_andfmla1017); 

            pushFollow(FOLLOW_logicalfmla_in_andfmla1023);
            f1=logicalfmla();

            state._fsp--;


            match(input,COMMA,FOLLOW_COMMA_in_andfmla1026); 

            pushFollow(FOLLOW_logicalfmla_in_andfmla1030);
            and=logicalfmla();

            state._fsp--;


            f = new Abstract_LogExpr(f1, Abstract_LogExpr.and, and);

            match(input,CLOSE,FOLLOW_CLOSE_in_andfmla1034); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:1: waitfor returns [Abstract_Literal wf] : MULT l= literal ;
    public final Abstract_Literal waitfor() throws RecognitionException {
        Abstract_Literal wf = null;


        Abstract_Literal l =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:39: ( MULT l= literal )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:42: MULT l= literal
            {
            match(input,MULT,FOLLOW_MULT_in_waitfor1047); 

            pushFollow(FOLLOW_literal_in_waitfor1051);
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:152:1: action returns [Abstract_Action a] : ( ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred );
    public final Abstract_Action action() throws RecognitionException {
        Abstract_Action a = null;


        Abstract_Literal an =null;

        int p =0;

        Abstract_Predicate t =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:152:36: ( ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==SEND) ) {
                alt29=1;
            }
            else if ( (LA29_0==CONST||LA29_0==VAR) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:153:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
                    {
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:153:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:153:3: SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE
                    {
                    match(input,SEND,FOLLOW_SEND_in_action1068); 

                    match(input,OPEN,FOLLOW_OPEN_in_action1070); 

                    pushFollow(FOLLOW_literal_in_action1074);
                    an=literal();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_action1076); 

                    pushFollow(FOLLOW_performative_in_action1080);
                    p=performative();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_action1082); 

                    pushFollow(FOLLOW_pred_in_action1086);
                    t=pred();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_action1088); 

                    a = new Abstract_SendAction(an, p, t);

                    }


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:154:2: t= pred
                    {
                    pushFollow(FOLLOW_pred_in_action1099);
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:196:1: environment returns [String env] : w= classpath ;
    public final String environment() throws RecognitionException {
        String env = null;


        String w =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:196:34: (w= classpath )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:196:36: w= classpath
            {
            pushFollow(FOLLOW_classpath_in_environment1379);
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:197:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
    public final String classpath() throws RecognitionException {
        String s = null;


        String w =null;

        String w1 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:197:30: (w= word ( POINT w1= word )+ )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:197:32: w= word ( POINT w1= word )+
            {
            pushFollow(FOLLOW_word_in_classpath1394);
            w=word();

            state._fsp--;


            s = w;

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:197:52: ( POINT w1= word )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==POINT) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:197:53: POINT w1= word
            	    {
            	    match(input,POINT,FOLLOW_POINT_in_classpath1399); 

            	    pushFollow(FOLLOW_word_in_classpath1403);
            	    w1=word();

            	    state._fsp--;


            	    s+="."; s+=w1;

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
        return s;
    }
    // $ANTLR end "classpath"



    // $ANTLR start "word"
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:198:1: word returns [String s] : ( CONST | VAR ) ;
    public final String word() throws RecognitionException {
        String s = null;


        Token CONST1=null;
        Token VAR2=null;

        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:198:25: ( ( CONST | VAR ) )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:198:27: ( CONST | VAR )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:198:27: ( CONST | VAR )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:198:28: CONST
                    {
                    CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_word1504); 

                    s =CONST1.getText();

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:198:59: VAR
                    {
                    VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_word1510); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:200:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
    public final Abstract_StringTerm agentnameterm() throws RecognitionException {
        Abstract_StringTerm s = null;


        Token CONST3=null;
        Abstract_VarTerm v =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:200:47: ( CONST |v= var )
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
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:200:49: CONST
                    {
                    CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm1610); 

                    s = new Abstract_StringTermImpl(CONST3.getText());

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:200:111: v= var
                    {
                    pushFollow(FOLLOW_var_in_agentnameterm1618);
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
    public final Abstract_Literal literal() throws RecognitionException {
        Abstract_Literal l = null;


        Abstract_Predicate nt =null;

        Abstract_Predicate t =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:37: ( ( TRUE | NOT nt= pred ) |t= pred )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==NOT||LA34_0==TRUE) ) {
                alt34=1;
            }
            else if ( (LA34_0==CONST||LA34_0==VAR) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }
            switch (alt34) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:40: ( TRUE | NOT nt= pred )
                    {
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:40: ( TRUE | NOT nt= pred )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==TRUE) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==NOT) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;

                    }
                    switch (alt33) {
                        case 1 :
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:41: TRUE
                            {
                            match(input,TRUE,FOLLOW_TRUE_in_literal1634); 

                            l = new Abstract_Literal(Abstract_Literal.LTrue);

                            }
                            break;
                        case 2 :
                            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:204:5: NOT nt= pred
                            {
                            match(input,NOT,FOLLOW_NOT_in_literal1645); 

                            pushFollow(FOLLOW_pred_in_literal1649);
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
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:208:5: t= pred
                    {
                    pushFollow(FOLLOW_pred_in_literal1663);
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:212:1: pred returns [Abstract_Predicate t] : (v= var |f= function );
    public final Abstract_Predicate pred() throws RecognitionException {
        Abstract_Predicate t = null;


        Abstract_VarTerm v =null;

        Abstract_Predicate f =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:212:37: (v= var |f= function )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==VAR) ) {
                alt35=1;
            }
            else if ( (LA35_0==CONST) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:212:39: v= var
                    {
                    pushFollow(FOLLOW_var_in_pred1679);
                    v=var();

                    state._fsp--;


                    t = v;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:212:59: f= function
                    {
                    pushFollow(FOLLOW_function_in_pred1686);
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:213:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
    public final Abstract_Predicate function() throws RecognitionException {
        Abstract_Predicate f = null;


        Token CONST4=null;

        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:213:40: ( CONST ( OPEN terms[$f] CLOSE )? )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:213:42: CONST ( OPEN terms[$f] CLOSE )?
            {
            CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_function1698); 

            f = new Abstract_Predicate(CONST4.getText());

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:213:97: ( OPEN terms[$f] CLOSE )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==OPEN) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:213:98: OPEN terms[$f] CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_function1703); 

                    pushFollow(FOLLOW_terms_in_function1705);
                    terms(f);

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_function1708); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:215:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
    public final void terms(Abstract_Predicate f) throws RecognitionException {
        Abstract_Term t =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:215:29: (t= term ( COMMA terms[$f] )? )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:215:31: t= term ( COMMA terms[$f] )?
            {
            pushFollow(FOLLOW_term_in_terms1721);
            t=term();

            state._fsp--;


            f.addTerm(t);

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:215:58: ( COMMA terms[$f] )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==COMMA) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:215:59: COMMA terms[$f]
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_terms1726); 

                    pushFollow(FOLLOW_terms_in_terms1728);
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:216:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |f= function );
    public final Abstract_Term term() throws RecognitionException {
        Abstract_Term t = null;


        Abstract_NumberTerm a =null;

        Abstract_StringTerm s =null;

        Abstract_Predicate f =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:216:31: (a= atom |s= stringterm |f= function )
            int alt38=3;
            switch ( input.LA(1) ) {
            case MINUS:
            case NUMBER:
            case OPEN:
            case VAR:
                {
                alt38=1;
                }
                break;
            case DOUBLEQUOTE:
                {
                alt38=2;
                }
                break;
            case CONST:
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
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:216:34: a= atom
                    {
                    pushFollow(FOLLOW_atom_in_term1747);
                    a=atom();

                    state._fsp--;


                    t = a;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:216:58: s= stringterm
                    {
                    pushFollow(FOLLOW_stringterm_in_term1757);
                    s=stringterm();

                    state._fsp--;


                    t = s;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:216:88: f= function
                    {
                    pushFollow(FOLLOW_function_in_term1765);
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:218:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
    public final Abstract_NumberTerm atom() throws RecognitionException {
        Abstract_NumberTerm t = null;


        String n =null;

        Abstract_VarTerm v =null;

        Abstract_NumberTerm a =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:218:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
            int alt39=3;
            switch ( input.LA(1) ) {
            case MINUS:
            case NUMBER:
                {
                alt39=1;
                }
                break;
            case VAR:
                {
                alt39=2;
                }
                break;
            case OPEN:
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
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:218:40: n= numberstring
                    {
                    pushFollow(FOLLOW_numberstring_in_atom1783);
                    n=numberstring();

                    state._fsp--;


                    t = new Abstract_NumberTermImpl(n);

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:219:6: v= var
                    {
                    pushFollow(FOLLOW_var_in_atom1796);
                    v=var();

                    state._fsp--;


                    t = v;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:219:27: OPEN a= arithexpr CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_atom1802); 

                    pushFollow(FOLLOW_arithexpr_in_atom1806);
                    a=arithexpr();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_atom1808); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:220:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
    public final Abstract_StringTerm stringterm() throws RecognitionException {
        Abstract_StringTerm s = null;


        Token STRING5=null;

        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:220:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:220:46: DOUBLEQUOTE STRING DOUBLEQUOTE
            {
            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1821); 

            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm1824); 

            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1826); 

            		 
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:223:1: var returns [Abstract_VarTerm v] : VAR ;
    public final Abstract_VarTerm var() throws RecognitionException {
        Abstract_VarTerm v = null;


        Token VAR6=null;

        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:223:34: ( VAR )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:223:36: VAR
            {
            VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_var1840); 


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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:232:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
    public final String numberstring() throws RecognitionException {
        String s = null;


        Token n1=null;
        Token n2=null;

        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:232:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:232:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
            {
            s = "";

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:232:46: ( MINUS )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==MINUS) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:232:47: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_numberstring1857); 

                    s += "-";

                    }
                    break;

            }


            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:232:68: (n1= NUMBER ( POINT n2= NUMBER )? )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:232:69: n1= NUMBER ( POINT n2= NUMBER )?
            {
            n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1866); 

            s += n1.getText();

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:233:6: ( POINT n2= NUMBER )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==POINT) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:233:7: POINT n2= NUMBER
                    {
                    match(input,POINT,FOLLOW_POINT_in_numberstring1876); 

                    s += ".";

                    n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1882); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:234:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
    public final Abstract_Equation equation() throws RecognitionException {
        Abstract_Equation eq = null;


        Abstract_NumberTerm a1 =null;

        int oper =0;

        Abstract_NumberTerm a2 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:234:40: (a1= arithexpr oper= eqoper a2= arithexpr )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:234:42: a1= arithexpr oper= eqoper a2= arithexpr
            {
            pushFollow(FOLLOW_arithexpr_in_equation1899);
            a1=arithexpr();

            state._fsp--;


            pushFollow(FOLLOW_eqoper_in_equation1903);
            oper=eqoper();

            state._fsp--;


            pushFollow(FOLLOW_arithexpr_in_equation1907);
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:235:1: eqoper returns [int oper] : ( LESS | EQ );
    public final int eqoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:235:27: ( LESS | EQ )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==LESS) ) {
                alt42=1;
            }
            else if ( (LA42_0==EQ) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }
            switch (alt42) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:235:29: LESS
                    {
                    match(input,LESS,FOLLOW_LESS_in_eqoper1921); 

                    oper =Abstract_Equation.less;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:235:68: EQ
                    {
                    match(input,EQ,FOLLOW_EQ_in_eqoper1927); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
    public final Abstract_NumberTerm arithexpr() throws RecognitionException {
        Abstract_NumberTerm t = null;


        Abstract_NumberTerm m =null;

        int oper =0;

        Abstract_NumberTerm m1 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:43: (m= multexpr (oper= addoper m1= multexpr )? )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:45: m= multexpr (oper= addoper m1= multexpr )?
            {
            pushFollow(FOLLOW_multexpr_in_arithexpr1943);
            m=multexpr();

            state._fsp--;


            t = m;

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:69: (oper= addoper m1= multexpr )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==MINUS||LA43_0==PLUS) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:237:71: oper= addoper m1= multexpr
                    {
                    pushFollow(FOLLOW_addoper_in_arithexpr1951);
                    oper=addoper();

                    state._fsp--;


                    pushFollow(FOLLOW_multexpr_in_arithexpr1955);
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:238:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
    public final Abstract_NumberTerm multexpr() throws RecognitionException {
        Abstract_NumberTerm t = null;


        Abstract_NumberTerm a =null;

        int oper =0;

        Abstract_NumberTerm a1 =null;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:238:42: (a= atom (oper= multoper a1= atom )? )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:238:44: a= atom (oper= multoper a1= atom )?
            {
            pushFollow(FOLLOW_atom_in_multexpr1972);
            a=atom();

            state._fsp--;


            t = a;

            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:238:64: (oper= multoper a1= atom )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==DIV||(LA44_0 >= MOD && LA44_0 <= MULT)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:238:65: oper= multoper a1= atom
                    {
                    pushFollow(FOLLOW_multoper_in_multexpr1979);
                    oper=multoper();

                    state._fsp--;


                    pushFollow(FOLLOW_atom_in_multexpr1983);
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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
    public final int addoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:28: ( ( PLUS | MINUS ) )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:30: ( PLUS | MINUS )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:30: ( PLUS | MINUS )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==PLUS) ) {
                alt45=1;
            }
            else if ( (LA45_0==MINUS) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }
            switch (alt45) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:31: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_addoper2000); 

                    oper =Abstract_ArithExpr.plus;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:240:70: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_addoper2005); 

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
    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:241:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
    public final int multoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:241:29: ( ( MULT | DIV | MOD ) )
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:241:31: ( MULT | DIV | MOD )
            {
            // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:241:31: ( MULT | DIV | MOD )
            int alt46=3;
            switch ( input.LA(1) ) {
            case MULT:
                {
                alt46=1;
                }
                break;
            case DIV:
                {
                alt46=2;
                }
                break;
            case MOD:
                {
                alt46=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:241:32: MULT
                    {
                    match(input,MULT,FOLLOW_MULT_in_multoper2020); 

                    oper =Abstract_ArithExpr.times;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:241:73: DIV
                    {
                    match(input,DIV,FOLLOW_DIV_in_multoper2026); 

                    oper =Abstract_ArithExpr.div;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:241:111: MOD
                    {
                    match(input,MOD,FOLLOW_MOD_in_multoper2032); 

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
    public static final BitSet FOLLOW_OPEN_in_guard_atom248 = new BitSet(new long[]{0x0800000000800000L});
    public static final BitSet FOLLOW_stringterm_in_guard_atom255 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_var_in_guard_atom263 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_guard_atom268 = new BitSet(new long[]{0x0300020000880010L});
    public static final BitSet FOLLOW_stringterm_in_guard_atom275 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_guard_atom283 = new BitSet(new long[]{0x0300020000080010L});
    public static final BitSet FOLLOW_performative_in_guard_atom291 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_guard_atom299 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_pred_in_guard_atom303 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_guard_atom305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equation_in_guard_atom319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_guard_atom329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_goal363 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_SQOPEN_in_goal365 = new BitSet(new long[]{0x0000040000000020L});
    public static final BitSet FOLLOW_ACHIEVEGOAL_in_goal368 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_PERFORMGOAL_in_goal378 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_goal383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_in_plan397 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_plan405 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_plan407 = new BitSet(new long[]{0x0C0801C202001000L});
    public static final BitSet FOLLOW_NOT_in_plan412 = new BitSet(new long[]{0x0C08018202001000L});
    public static final BitSet FOLLOW_guard_atom_in_plan420 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_COMMA_in_plan428 = new BitSet(new long[]{0x0C0801C202001000L});
    public static final BitSet FOLLOW_NOT_in_plan433 = new BitSet(new long[]{0x0C08018202001000L});
    public static final BitSet FOLLOW_guard_atom_in_plan441 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_plan447 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_RULEARROW_in_plan450 = new BitSet(new long[]{0x0804100A00040000L});
    public static final BitSet FOLLOW_deed_in_plan455 = new BitSet(new long[]{0x0002000000010000L});
    public static final BitSet FOLLOW_COMMA_in_plan460 = new BitSet(new long[]{0x0804100A00040000L});
    public static final BitSet FOLLOW_deed_in_plan464 = new BitSet(new long[]{0x0002000000010000L});
    public static final BitSet FOLLOW_SEMI_in_plan474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_event490 = new BitSet(new long[]{0x0C10804000040180L});
    public static final BitSet FOLLOW_RECEIVED_in_event493 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_event495 = new BitSet(new long[]{0x0300020000080010L});
    public static final BitSet FOLLOW_performative_in_event499 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_event501 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_pred_in_event505 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_event507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_event525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_event535 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_event539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_event550 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_event554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_event564 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_event568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_event586 = new BitSet(new long[]{0x0C10004000040180L});
    public static final BitSet FOLLOW_literal_in_event591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_event601 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_event605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_event615 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_event619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_event629 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_event633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TELL_in_performative655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERFORM_in_performative661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACHIEVE_in_performative667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TELLHOW_in_performative673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTRAINT_in_performative679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_deed705 = new BitSet(new long[]{0x0C100041000403C0L});
    public static final BitSet FOLLOW_literal_in_deed710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_deed720 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_deed724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_deed734 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_deed748 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_PLAN_in_deed762 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONSTRAINT_in_deed776 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_in_deed790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_deed803 = new BitSet(new long[]{0x0C10004100040180L});
    public static final BitSet FOLLOW_literal_in_deed808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_deed818 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_goal_in_deed822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_deed832 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_deed846 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_deed850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_in_deed860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_deed879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_waitfor_in_deed892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_brule927 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_BRULEARROW_in_brule930 = new BitSet(new long[]{0x0C00014000040000L});
    public static final BitSet FOLLOW_logicalfmla_in_brule934 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_SEMI_in_brule938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_brule948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notfmla_in_logicalfmla964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andfmla_in_logicalfmla971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_logicalfmla981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_notfmla994 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_notfmla996 = new BitSet(new long[]{0x0C00014000040000L});
    public static final BitSet FOLLOW_logicalfmla_in_notfmla1002 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_notfmla1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_andfmla1017 = new BitSet(new long[]{0x0C00014000040000L});
    public static final BitSet FOLLOW_logicalfmla_in_andfmla1023 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_andfmla1026 = new BitSet(new long[]{0x0C00014000040000L});
    public static final BitSet FOLLOW_logicalfmla_in_andfmla1030 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_andfmla1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULT_in_waitfor1047 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_waitfor1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEND_in_action1068 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_OPEN_in_action1070 = new BitSet(new long[]{0x0C00004000040000L});
    public static final BitSet FOLLOW_literal_in_action1074 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_action1076 = new BitSet(new long[]{0x0300020000080010L});
    public static final BitSet FOLLOW_performative_in_action1080 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_action1082 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_pred_in_action1086 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_action1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pred_in_action1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classpath_in_environment1379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_word_in_classpath1394 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_POINT_in_classpath1399 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_word_in_classpath1403 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_CONST_in_word1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_word1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_agentnameterm1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_agentnameterm1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_literal1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_literal1645 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_pred_in_literal1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pred_in_literal1663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_pred1679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_pred1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_function1698 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_OPEN_in_function1703 = new BitSet(new long[]{0x0800018200840000L});
    public static final BitSet FOLLOW_terms_in_function1705 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_function1708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_terms1721 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_COMMA_in_terms1726 = new BitSet(new long[]{0x0800018200840000L});
    public static final BitSet FOLLOW_terms_in_terms1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_term1747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringterm_in_term1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_term1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numberstring_in_atom1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_atom1796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_atom1802 = new BitSet(new long[]{0x0800018200000000L});
    public static final BitSet FOLLOW_arithexpr_in_atom1806 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_atom1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1821 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_STRING_in_stringterm1824 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_var1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_numberstring1857 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring1866 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_POINT_in_numberstring1876 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithexpr_in_equation1899 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_eqoper_in_equation1903 = new BitSet(new long[]{0x0800018200000000L});
    public static final BitSet FOLLOW_arithexpr_in_equation1907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_in_eqoper1921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_eqoper1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr1943 = new BitSet(new long[]{0x0000100200000002L});
    public static final BitSet FOLLOW_addoper_in_arithexpr1951 = new BitSet(new long[]{0x0800018200000000L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_multexpr1972 = new BitSet(new long[]{0x0000000C00400002L});
    public static final BitSet FOLLOW_multoper_in_multexpr1979 = new BitSet(new long[]{0x0800018200000000L});
    public static final BitSet FOLLOW_atom_in_multexpr1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_addoper2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_addoper2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULT_in_multoper2020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_multoper2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOD_in_multoper2032 = new BitSet(new long[]{0x0000000000000002L});

}