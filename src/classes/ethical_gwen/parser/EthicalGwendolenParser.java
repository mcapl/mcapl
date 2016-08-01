// $ANTLR 3.4 /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g 2014-04-04 13:09:37

package ethical_gwen.parser;

import ail.syntax.ast.*;
import gwendolen.syntax.ast.*;
import ethical_gwen.syntax.ast.*;
import java.util.HashMap;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class EthicalGwendolenParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACHIEVE", "ACHIEVEGOAL", "ADD_CONSTRAINT", "ADD_CONTENT", "ADD_CONTEXT", "ADD_PLAN", "BELIEFRULES", "BELIEFS", "BELIEVE", "BRULEARROW", "CLOSE", "COLON", "COMMA", "COMMENT", "CONST", "CONSTRAINT", "CURLYCLOSE", "CURLYOPEN", "DIV", "DOUBLEQUOTE", "EQ", "ETHIC", "ETHICS", "GOAL", "GOALS", "GWENDOLEN", "IN_CONTENT", "IN_CONTEXT", "LESS", "LINE_COMMENT", "LOCK", "MINUS", "MOD", "MULT", "NAME", "NEWLINE", "NOT", "NUMBER", "OPEN", "PERFORM", "PERFORMGOAL", "PLANS", "PLUS", "POINT", "QUERY", "RECEIVED", "RULEARROW", "SEMI", "SEND", "SENT", "SHRIEK", "SQCLOSE", "SQOPEN", "STRING", "TELL", "TELLHOW", "TRUE", "VAR", "WS", "'|'"
    };

    public static final int EOF=-1;
    public static final int T__63=63;
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
    public static final int ETHIC=25;
    public static final int ETHICS=26;
    public static final int GOAL=27;
    public static final int GOALS=28;
    public static final int GWENDOLEN=29;
    public static final int IN_CONTENT=30;
    public static final int IN_CONTEXT=31;
    public static final int LESS=32;
    public static final int LINE_COMMENT=33;
    public static final int LOCK=34;
    public static final int MINUS=35;
    public static final int MOD=36;
    public static final int MULT=37;
    public static final int NAME=38;
    public static final int NEWLINE=39;
    public static final int NOT=40;
    public static final int NUMBER=41;
    public static final int OPEN=42;
    public static final int PERFORM=43;
    public static final int PERFORMGOAL=44;
    public static final int PLANS=45;
    public static final int PLUS=46;
    public static final int POINT=47;
    public static final int QUERY=48;
    public static final int RECEIVED=49;
    public static final int RULEARROW=50;
    public static final int SEMI=51;
    public static final int SEND=52;
    public static final int SENT=53;
    public static final int SHRIEK=54;
    public static final int SQCLOSE=55;
    public static final int SQOPEN=56;
    public static final int STRING=57;
    public static final int TELL=58;
    public static final int TELLHOW=59;
    public static final int TRUE=60;
    public static final int VAR=61;
    public static final int WS=62;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public EthicalGwendolenParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public EthicalGwendolenParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return EthicalGwendolenParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g"; }


    	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
    	private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");
    	


    // $ANTLR start "mas"
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:59:1: mas returns [Abstract_MAS mas] :glist= egwendolenagents ;
    public final Abstract_MAS mas() throws RecognitionException {
        Abstract_MAS mas = null;


        ArrayList<Abstract_EthicalGwendolenAgent> glist =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:59:32: (glist= egwendolenagents )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:59:34: glist= egwendolenagents
            {
            mas = new Abstract_MAS();

            pushFollow(FOLLOW_egwendolenagents_in_mas90);
            glist=egwendolenagents();

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



    // $ANTLR start "egwendolenagents"
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:62:1: egwendolenagents returns [ArrayList<Abstract_EthicalGwendolenAgent> gags] : (g= gwendolenagent )+ ;
    public final ArrayList<Abstract_EthicalGwendolenAgent> egwendolenagents() throws RecognitionException {
        ArrayList<Abstract_EthicalGwendolenAgent> gags = null;


        Abstract_EthicalGwendolenAgent g =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:62:73: ( (g= gwendolenagent )+ )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:63:2: (g= gwendolenagent )+
            {
            gags=new ArrayList<Abstract_EthicalGwendolenAgent>();

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:64:2: (g= gwendolenagent )+
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
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:64:3: g= gwendolenagent
            	    {
            	    pushFollow(FOLLOW_gwendolenagent_in_egwendolenagents111);
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
    // $ANTLR end "egwendolenagents"



    // $ANTLR start "gwendolenagent"
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:67:1: gwendolenagent returns [Abstract_EthicalGwendolenAgent g] : ( ( GWENDOLEN )? ) NAME w= word ETHICS (e= ethic )* BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOALS (gl= goal )* PLANS (p= plan )* ;
    public final Abstract_EthicalGwendolenAgent gwendolenagent() throws RecognitionException {
        Abstract_EthicalGwendolenAgent g = null;


        String w =null;

        Abstract_Ethic e =null;

        Abstract_Literal l =null;

        Abstract_Rule r =null;

        Abstract_Goal gl =null;

        Abstract_GPlan p =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:67:59: ( ( ( GWENDOLEN )? ) NAME w= word ETHICS (e= ethic )* BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOALS (gl= goal )* PLANS (p= plan )* )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:68:9: ( ( GWENDOLEN )? ) NAME w= word ETHICS (e= ethic )* BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOALS (gl= goal )* PLANS (p= plan )*
            {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:68:9: ( ( GWENDOLEN )? )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:68:10: ( GWENDOLEN )?
            {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:68:10: ( GWENDOLEN )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==GWENDOLEN) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:68:10: GWENDOLEN
                    {
                    match(input,GWENDOLEN,FOLLOW_GWENDOLEN_in_gwendolenagent138); 

                    }
                    break;

            }


            }


            match(input,NAME,FOLLOW_NAME_in_gwendolenagent144); 

            pushFollow(FOLLOW_word_in_gwendolenagent148);
            w=word();

            state._fsp--;


            try {g = new Abstract_EthicalGwendolenAgent(w);} 
            		catch (Exception ex) {System.err.println(ex); agentname = new Abstract_StringTermImpl(w);}

            match(input,ETHICS,FOLLOW_ETHICS_in_gwendolenagent153); 

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:71:9: (e= ethic )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ETHIC) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:71:10: e= ethic
            	    {
            	    pushFollow(FOLLOW_ethic_in_gwendolenagent158);
            	    e=ethic();

            	    state._fsp--;


            	    g.addEthic(e);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input,BELIEFS,FOLLOW_BELIEFS_in_gwendolenagent165); 

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:72:10: (l= literal )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==CONST||LA4_0==NOT||(LA4_0 >= TRUE && LA4_0 <= VAR)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:72:11: l= literal
            	    {
            	    pushFollow(FOLLOW_literal_in_gwendolenagent170);
            	    l=literal();

            	    state._fsp--;


            	    g.addInitialBel(l);

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:73:2: ( BELIEFRULES (r= brule )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==BELIEFRULES) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:73:3: BELIEFRULES (r= brule )*
                    {
                    match(input,BELIEFRULES,FOLLOW_BELIEFRULES_in_gwendolenagent178); 

                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:73:15: (r= brule )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==CONST||LA5_0==VAR) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:73:16: r= brule
                    	    {
                    	    pushFollow(FOLLOW_brule_in_gwendolenagent183);
                    	    r=brule();

                    	    state._fsp--;


                    	    g.addRule(r);

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,GOALS,FOLLOW_GOALS_in_gwendolenagent192); 

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:74:8: (gl= goal )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==CONST||LA7_0==NOT||(LA7_0 >= TRUE && LA7_0 <= VAR)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:74:9: gl= goal
            	    {
            	    pushFollow(FOLLOW_goal_in_gwendolenagent197);
            	    gl=goal();

            	    state._fsp--;


            	    g.addInitialGoal(gl);

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            match(input,PLANS,FOLLOW_PLANS_in_gwendolenagent204); 

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:75:8: (p= plan )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==MINUS||LA8_0==PLUS) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:75:9: p= plan
            	    {
            	    pushFollow(FOLLOW_plan_in_gwendolenagent209);
            	    p=plan();

            	    state._fsp--;


            	    try {g.addPlan(p);} catch (Exception ex) {System.err.println(ex);}

            	    }
            	    break;

            	default :
            	    break loop8;
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



    // $ANTLR start "ethic"
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:77:1: ethic returns [Abstract_Ethic e] : ETHIC OPEN c= pred COMMA e1= pred COMMA n= NUMBER CLOSE ;
    public final Abstract_Ethic ethic() throws RecognitionException {
        Abstract_Ethic e = null;


        Token n=null;
        Abstract_Predicate c =null;

        Abstract_Predicate e1 =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:77:34: ( ETHIC OPEN c= pred COMMA e1= pred COMMA n= NUMBER CLOSE )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:77:36: ETHIC OPEN c= pred COMMA e1= pred COMMA n= NUMBER CLOSE
            {
            match(input,ETHIC,FOLLOW_ETHIC_in_ethic226); 

            match(input,OPEN,FOLLOW_OPEN_in_ethic228); 

            pushFollow(FOLLOW_pred_in_ethic232);
            c=pred();

            state._fsp--;


            match(input,COMMA,FOLLOW_COMMA_in_ethic234); 

            pushFollow(FOLLOW_pred_in_ethic238);
            e1=pred();

            state._fsp--;


            match(input,COMMA,FOLLOW_COMMA_in_ethic240); 

            n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_ethic244); 

            match(input,CLOSE,FOLLOW_CLOSE_in_ethic246); 

            e = new Abstract_Ethic(c, e1, n.getText());

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
    // $ANTLR end "ethic"



    // $ANTLR start "guard_atom"
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:79:1: guard_atom returns [Abstract_GLogicalFormula g] : ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE ) ;
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
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:79:49: ( ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:79:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE )
            {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:79:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE )
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
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:79:52: BELIEVE l= literal
                    {
                    match(input,BELIEVE,FOLLOW_BELIEVE_in_guard_atom262); 

                    pushFollow(FOLLOW_literal_in_guard_atom266);
                    l=literal();

                    state._fsp--;


                    g = new Abstract_GBelief(l);

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:80:5: GOAL gl= goal
                    {
                    match(input,GOAL,FOLLOW_GOAL_in_guard_atom276); 

                    pushFollow(FOLLOW_goal_in_guard_atom280);
                    gl=goal();

                    state._fsp--;


                    g = new Abstract_Goal(gl);

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:81:5: SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE
                    {
                    match(input,SENT,FOLLOW_SENT_in_guard_atom290); 

                    match(input,OPEN,FOLLOW_OPEN_in_guard_atom292); 

                    Abstract_StringTerm an1=agentname;

                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:81:52: (s= agentnameterm )
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:81:53: s= agentnameterm
                    {
                    pushFollow(FOLLOW_agentnameterm_in_guard_atom299);
                    s=agentnameterm();

                    state._fsp--;


                    an1 = s;

                    }


                    match(input,COMMA,FOLLOW_COMMA_in_guard_atom333); 

                    Abstract_StringTerm agn = agentname;

                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:82:74: (an2= agentnameterm COMMA )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==CONST||LA9_0==VAR) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:82:75: an2= agentnameterm COMMA
                            {
                            pushFollow(FOLLOW_agentnameterm_in_guard_atom340);
                            an2=agentnameterm();

                            state._fsp--;


                            match(input,COMMA,FOLLOW_COMMA_in_guard_atom348); 

                            agn = an2;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_performative_in_guard_atom356);
                    p=performative();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_guard_atom364); 

                    pushFollow(FOLLOW_pred_in_guard_atom368);
                    t=pred();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_guard_atom370); 

                    g = new Abstract_GuardMessage(Abstract_BaseAILStructure.AILSent, agn, an1, p, t);

                    }
                    break;
                case 4 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:85:5: eq= equation
                    {
                    pushFollow(FOLLOW_equation_in_guard_atom384);
                    eq=equation();

                    state._fsp--;


                    g = eq;

                    }
                    break;
                case 5 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:86:5: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_guard_atom394); 

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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:88:1: goal returns [Abstract_Goal g] : l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE ;
    public final Abstract_Goal goal() throws RecognitionException {
        Abstract_Goal g = null;


        Abstract_Literal l =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:88:32: (l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:88:34: l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE
            {
            pushFollow(FOLLOW_literal_in_goal412);
            l=literal();

            state._fsp--;


            match(input,SQOPEN,FOLLOW_SQOPEN_in_goal414); 

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:88:51: ( ACHIEVEGOAL | PERFORMGOAL )
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
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:88:52: ACHIEVEGOAL
                    {
                    match(input,ACHIEVEGOAL,FOLLOW_ACHIEVEGOAL_in_goal417); 

                    g = new Abstract_Goal(l, Abstract_Goal.achieveGoal);

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:89:4: PERFORMGOAL
                    {
                    match(input,PERFORMGOAL,FOLLOW_PERFORMGOAL_in_goal427); 

                    g = new Abstract_Goal(l, Abstract_Goal.performGoal);

                    }
                    break;

            }


            match(input,SQCLOSE,FOLLOW_SQCLOSE_in_goal432); 

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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:90:1: plan returns [Abstract_GPlan p] : e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI ;
    public final Abstract_GPlan plan() throws RecognitionException {
        Abstract_GPlan p = null;


        Abstract_Event e =null;

        Abstract_GLogicalFormula gb =null;

        Abstract_Deed d =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:91:2: (e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:91:4: e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI
            {
            pushFollow(FOLLOW_event_in_plan446);
            e=event();

            state._fsp--;


            ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();

            match(input,COLON,FOLLOW_COLON_in_plan454); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_plan456); 

            boolean gneg=true;

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:92:40: ( NOT )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NOT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:92:41: NOT
                    {
                    match(input,NOT,FOLLOW_NOT_in_plan461); 

                    gneg=false;

                    }
                    break;

            }


            pushFollow(FOLLOW_guard_atom_in_plan469);
            gb=guard_atom();

            state._fsp--;


            g.add(gb, gneg);

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:93:3: ( COMMA ( NOT )? gb= guard_atom )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==COMMA) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:93:4: COMMA ( NOT )? gb= guard_atom
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_plan477); 

            	    gneg=true;

            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:93:23: ( NOT )?
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==NOT) ) {
            	        alt13=1;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:93:24: NOT
            	            {
            	            match(input,NOT,FOLLOW_NOT_in_plan482); 

            	            gneg=false;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_guard_atom_in_plan490);
            	    gb=guard_atom();

            	    state._fsp--;


            	    g.add(gb, gneg);

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_plan496); 

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:93:93: ( RULEARROW d= deed ( COMMA d= deed )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULEARROW) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:93:94: RULEARROW d= deed ( COMMA d= deed )*
                    {
                    match(input,RULEARROW,FOLLOW_RULEARROW_in_plan499); 

                    pushFollow(FOLLOW_deed_in_plan504);
                    d=deed();

                    state._fsp--;


                    deeds.add(d);

                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:94:28: ( COMMA d= deed )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==COMMA) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:94:29: COMMA d= deed
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_plan509); 

                    	    pushFollow(FOLLOW_deed_in_plan513);
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


            match(input,SEMI,FOLLOW_SEMI_in_plan523); 

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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:97:1: event returns [Abstract_Event e] : ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) ) ;
    public final Abstract_Event event() throws RecognitionException {
        Abstract_Event e = null;


        int p =0;

        Abstract_Predicate t =null;

        Abstract_Literal l =null;

        Abstract_Goal g =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:97:34: ( ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:97:36: ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) )
            {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:97:36: ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) )
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
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:97:37: PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_event539); 

                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:97:42: ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
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
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:97:43: RECEIVED OPEN p= performative COMMA t= pred CLOSE
                            {
                            match(input,RECEIVED,FOLLOW_RECEIVED_in_event542); 

                            match(input,OPEN,FOLLOW_OPEN_in_event544); 

                            pushFollow(FOLLOW_performative_in_event548);
                            p=performative();

                            state._fsp--;


                            match(input,COMMA,FOLLOW_COMMA_in_event550); 

                            pushFollow(FOLLOW_pred_in_event554);
                            t=pred();

                            state._fsp--;


                            match(input,CLOSE,FOLLOW_CLOSE_in_event556); 

                            Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), 
                            						new Abstract_VarTerm("To"), p, t); 
                            						e = new Abstract_Event(Abstract_Event.AILAddition, 
                            						Abstract_Event.AILReceived, message);

                            }
                            break;
                        case 2 :
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:102:5: (l= literal | SHRIEK g= goal )
                            {
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:102:5: (l= literal | SHRIEK g= goal )
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
                                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:102:6: l= literal
                                    {
                                    pushFollow(FOLLOW_literal_in_event574);
                                    l=literal();

                                    state._fsp--;


                                    e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, l);

                                    }
                                    break;
                                case 2 :
                                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:103:5: SHRIEK g= goal
                                    {
                                    match(input,SHRIEK,FOLLOW_SHRIEK_in_event584); 

                                    pushFollow(FOLLOW_goal_in_event588);
                                    g=goal();

                                    state._fsp--;


                                    e = new Abstract_Event(Abstract_Event.AILAddition, g);

                                    }
                                    break;

                            }


                            }
                            break;
                        case 3 :
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:104:5: ADD_CONTENT l= literal
                            {
                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_event599); 

                            pushFollow(FOLLOW_literal_in_event603);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContent, l);

                            }
                            break;
                        case 4 :
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:105:5: ADD_CONTEXT l= literal
                            {
                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_event613); 

                            pushFollow(FOLLOW_literal_in_event617);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContext, l);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:107:7: MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_event635); 

                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:107:13: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
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
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:107:14: l= literal
                            {
                            pushFollow(FOLLOW_literal_in_event640);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, l);

                            }
                            break;
                        case 2 :
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:108:5: SHRIEK g= goal
                            {
                            match(input,SHRIEK,FOLLOW_SHRIEK_in_event650); 

                            pushFollow(FOLLOW_goal_in_event654);
                            g=goal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILDeletion, g);

                            }
                            break;
                        case 3 :
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:109:5: ADD_CONTENT l= literal
                            {
                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_event664); 

                            pushFollow(FOLLOW_literal_in_event668);
                            l=literal();

                            state._fsp--;


                            e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContent, l);

                            }
                            break;
                        case 4 :
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:110:5: ADD_CONTEXT l= literal
                            {
                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_event678); 

                            pushFollow(FOLLOW_literal_in_event682);
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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:113:1: performative returns [int b] : ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT ) ;
    public final int performative() throws RecognitionException {
        int b = 0;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:113:30: ( ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:113:32: ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT )
            {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:113:32: ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT )
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
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:113:33: TELL
                    {
                    match(input,TELL,FOLLOW_TELL_in_performative704); 

                    b =1;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:113:48: PERFORM
                    {
                    match(input,PERFORM,FOLLOW_PERFORM_in_performative710); 

                    b =2;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:113:66: ACHIEVE
                    {
                    match(input,ACHIEVE,FOLLOW_ACHIEVE_in_performative716); 

                    b = 3;

                    }
                    break;
                case 4 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:113:86: TELLHOW
                    {
                    match(input,TELLHOW,FOLLOW_TELLHOW_in_performative722); 

                    b = 4;

                    }
                    break;
                case 5 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:113:106: CONSTRAINT
                    {
                    match(input,CONSTRAINT,FOLLOW_CONSTRAINT_in_performative728); 

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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:115:1: deed returns [Abstract_Deed d] : ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor ) ;
    public final Abstract_Deed deed() throws RecognitionException {
        Abstract_Deed d = null;


        Abstract_Literal l =null;

        Abstract_Goal g =null;

        Abstract_Literal p =null;

        Abstract_Literal c =null;

        Abstract_Action a =null;

        Abstract_Literal wf =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:115:32: ( ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:115:34: ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor )
            {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:115:34: ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor )
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
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:115:35: ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action )
                    {
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:115:35: ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action )
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
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:115:36: ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) )
                            {
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:115:36: ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) )
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
                                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:115:37: PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK )
                                    {
                                    match(input,PLUS,FOLLOW_PLUS_in_deed754); 

                                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:115:42: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK )
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
                                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:115:43: l= literal
                                            {
                                            pushFollow(FOLLOW_literal_in_deed759);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, l);

                                            }
                                            break;
                                        case 2 :
                                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:116:5: SHRIEK g= goal
                                            {
                                            match(input,SHRIEK,FOLLOW_SHRIEK_in_deed769); 

                                            pushFollow(FOLLOW_goal_in_deed773);
                                            g=goal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, g);

                                            }
                                            break;
                                        case 3 :
                                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:117:5: ADD_CONTENT l= literal
                                            {
                                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_deed783); 

                                            pushFollow(FOLLOW_literal_in_deed787);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContent, l);

                                            }
                                            break;
                                        case 4 :
                                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:118:5: ADD_CONTEXT l= literal
                                            {
                                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_deed797); 

                                            pushFollow(FOLLOW_literal_in_deed801);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContext, l);

                                            }
                                            break;
                                        case 5 :
                                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:119:5: ADD_PLAN p= literal
                                            {
                                            match(input,ADD_PLAN,FOLLOW_ADD_PLAN_in_deed811); 

                                            pushFollow(FOLLOW_literal_in_deed815);
                                            p=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILPlan, p);

                                            }
                                            break;
                                        case 6 :
                                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:120:5: ADD_CONSTRAINT c= literal
                                            {
                                            match(input,ADD_CONSTRAINT,FOLLOW_ADD_CONSTRAINT_in_deed825); 

                                            pushFollow(FOLLOW_literal_in_deed829);
                                            c=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILConstraint, c);

                                            }
                                            break;
                                        case 7 :
                                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:121:5: LOCK
                                            {
                                            match(input,LOCK,FOLLOW_LOCK_in_deed839); 

                                            d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:122:7: MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK )
                                    {
                                    match(input,MINUS,FOLLOW_MINUS_in_deed852); 

                                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:122:13: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK )
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
                                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:122:14: l= literal
                                            {
                                            pushFollow(FOLLOW_literal_in_deed857);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, l);

                                            }
                                            break;
                                        case 2 :
                                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:123:5: SHRIEK g= goal
                                            {
                                            match(input,SHRIEK,FOLLOW_SHRIEK_in_deed867); 

                                            pushFollow(FOLLOW_goal_in_deed871);
                                            g=goal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, g);

                                            }
                                            break;
                                        case 3 :
                                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:124:5: ADD_CONTENT l= literal
                                            {
                                            match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_deed881); 

                                            pushFollow(FOLLOW_literal_in_deed885);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContent, l);

                                            }
                                            break;
                                        case 4 :
                                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:125:5: ADD_CONTEXT l= literal
                                            {
                                            match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_deed895); 

                                            pushFollow(FOLLOW_literal_in_deed899);
                                            l=literal();

                                            state._fsp--;


                                            d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContext, l);

                                            }
                                            break;
                                        case 5 :
                                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:126:5: LOCK
                                            {
                                            match(input,LOCK,FOLLOW_LOCK_in_deed909); 

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
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:128:5: a= action
                            {
                            pushFollow(FOLLOW_action_in_deed928);
                            a=action();

                            state._fsp--;


                            d = new Abstract_Deed(a);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:129:5: wf= waitfor
                    {
                    pushFollow(FOLLOW_waitfor_in_deed941);
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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:136:1: brule returns [Abstract_Rule r] : head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) ;
    public final Abstract_Rule brule() throws RecognitionException {
        Abstract_Rule r = null;


        Abstract_Predicate head =null;

        Abstract_LogicalFormula f =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:136:33: (head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:136:35: head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI )
            {
            pushFollow(FOLLOW_pred_in_brule976);
            head=pred();

            state._fsp--;


            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:136:45: ( BRULEARROW f= logicalfmla SEMI | SEMI )
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
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:136:46: BRULEARROW f= logicalfmla SEMI
                    {
                    match(input,BRULEARROW,FOLLOW_BRULEARROW_in_brule979); 

                    pushFollow(FOLLOW_logicalfmla_in_brule983);
                    f=logicalfmla();

                    state._fsp--;


                    r = new Abstract_Rule(head, f);

                    match(input,SEMI,FOLLOW_SEMI_in_brule987); 

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:136:116: SEMI
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_brule991); 

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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:138:1: logicalfmla returns [Abstract_LogicalFormula f] : n= notfmla ( COMMA n2= notfmla )* ;
    public final Abstract_LogicalFormula logicalfmla() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_LogicalFormula n =null;

        Abstract_LogicalFormula n2 =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:138:49: (n= notfmla ( COMMA n2= notfmla )* )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:138:51: n= notfmla ( COMMA n2= notfmla )*
            {
            pushFollow(FOLLOW_notfmla_in_logicalfmla1008);
            n=notfmla();

            state._fsp--;


            f = n;

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:139:16: ( COMMA n2= notfmla )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==COMMA) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:139:17: COMMA n2= notfmla
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_logicalfmla1028); 

            	    pushFollow(FOLLOW_notfmla_in_logicalfmla1032);
            	    n2=notfmla();

            	    state._fsp--;


            	    f = new Abstract_LogExpr(f, Abstract_LogExpr.and, n2);

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
        return f;
    }
    // $ANTLR end "logicalfmla"



    // $ANTLR start "notfmla"
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:141:1: notfmla returns [Abstract_LogicalFormula f] : (gb= pred | NOT (gb2= pred |lf= subfmla ) );
    public final Abstract_LogicalFormula notfmla() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_Predicate gb =null;

        Abstract_Predicate gb2 =null;

        Abstract_LogicalFormula lf =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:141:45: (gb= pred | NOT (gb2= pred |lf= subfmla ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==CONST||LA30_0==VAR) ) {
                alt30=1;
            }
            else if ( (LA30_0==NOT) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }
            switch (alt30) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:141:47: gb= pred
                    {
                    pushFollow(FOLLOW_pred_in_notfmla1067);
                    gb=pred();

                    state._fsp--;


                    f = gb;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:142:79: NOT (gb2= pred |lf= subfmla )
                    {
                    match(input,NOT,FOLLOW_NOT_in_notfmla1152); 

                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:142:83: (gb2= pred |lf= subfmla )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==CONST||LA29_0==VAR) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==OPEN) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;

                    }
                    switch (alt29) {
                        case 1 :
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:142:84: gb2= pred
                            {
                            pushFollow(FOLLOW_pred_in_notfmla1159);
                            gb2=pred();

                            state._fsp--;


                            f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);

                            }
                            break;
                        case 2 :
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:142:153: lf= subfmla
                            {
                            pushFollow(FOLLOW_subfmla_in_notfmla1169);
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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:143:1: subfmla returns [Abstract_LogicalFormula f] : OPEN lf= logicalfmla CLOSE ;
    public final Abstract_LogicalFormula subfmla() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_LogicalFormula lf =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:143:45: ( OPEN lf= logicalfmla CLOSE )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:143:47: OPEN lf= logicalfmla CLOSE
            {
            match(input,OPEN,FOLLOW_OPEN_in_subfmla1183); 

            pushFollow(FOLLOW_logicalfmla_in_subfmla1189);
            lf=logicalfmla();

            state._fsp--;


            f = lf;

            match(input,CLOSE,FOLLOW_CLOSE_in_subfmla1193); 

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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:145:1: waitfor returns [Abstract_Literal wf] : MULT l= literal ;
    public final Abstract_Literal waitfor() throws RecognitionException {
        Abstract_Literal wf = null;


        Abstract_Literal l =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:145:39: ( MULT l= literal )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:145:42: MULT l= literal
            {
            match(input,MULT,FOLLOW_MULT_in_waitfor1206); 

            pushFollow(FOLLOW_literal_in_waitfor1210);
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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:147:1: action returns [Abstract_Action a] : ( ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred );
    public final Abstract_Action action() throws RecognitionException {
        Abstract_Action a = null;


        Abstract_Literal an =null;

        int p =0;

        Abstract_Predicate t =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:147:36: ( ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==SEND) ) {
                alt31=1;
            }
            else if ( (LA31_0==CONST||LA31_0==VAR) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }
            switch (alt31) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:148:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
                    {
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:148:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:148:3: SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE
                    {
                    match(input,SEND,FOLLOW_SEND_in_action1227); 

                    match(input,OPEN,FOLLOW_OPEN_in_action1229); 

                    pushFollow(FOLLOW_literal_in_action1233);
                    an=literal();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_action1235); 

                    pushFollow(FOLLOW_performative_in_action1239);
                    p=performative();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_action1241); 

                    pushFollow(FOLLOW_pred_in_action1245);
                    t=pred();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_action1247); 

                    a = new Abstract_SendAction(an, p, t);

                    }


                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:149:2: t= pred
                    {
                    pushFollow(FOLLOW_pred_in_action1258);
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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:193:1: environment returns [String env] : w= classpath ;
    public final String environment() throws RecognitionException {
        String env = null;


        String w =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:193:34: (w= classpath )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:193:36: w= classpath
            {
            pushFollow(FOLLOW_classpath_in_environment1561);
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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:194:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
    public final String classpath() throws RecognitionException {
        String s = null;


        String w =null;

        String w1 =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:194:30: (w= word ( POINT w1= word )+ )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:194:32: w= word ( POINT w1= word )+
            {
            pushFollow(FOLLOW_word_in_classpath1576);
            w=word();

            state._fsp--;


            s = w;

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:194:52: ( POINT w1= word )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==POINT) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:194:53: POINT w1= word
            	    {
            	    match(input,POINT,FOLLOW_POINT_in_classpath1581); 

            	    pushFollow(FOLLOW_word_in_classpath1585);
            	    w1=word();

            	    state._fsp--;


            	    s+="."; s+=w1;

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
        return s;
    }
    // $ANTLR end "classpath"



    // $ANTLR start "word"
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:195:1: word returns [String s] : ( CONST | VAR ) ;
    public final String word() throws RecognitionException {
        String s = null;


        Token CONST1=null;
        Token VAR2=null;

        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:195:25: ( ( CONST | VAR ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:195:27: ( CONST | VAR )
            {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:195:27: ( CONST | VAR )
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
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:195:28: CONST
                    {
                    CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_word1686); 

                    s =CONST1.getText();

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:195:59: VAR
                    {
                    VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_word1692); 

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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:197:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
    public final Abstract_StringTerm agentnameterm() throws RecognitionException {
        Abstract_StringTerm s = null;


        Token CONST3=null;
        Abstract_VarTerm v =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:197:47: ( CONST |v= var )
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
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:197:49: CONST
                    {
                    CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm1792); 

                    s = new Abstract_StringTermImpl(CONST3.getText());

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:197:111: v= var
                    {
                    pushFollow(FOLLOW_var_in_agentnameterm1800);
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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:200:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
    public final Abstract_Literal literal() throws RecognitionException {
        Abstract_Literal l = null;


        Abstract_Predicate nt =null;

        Abstract_Predicate t =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:200:37: ( ( TRUE | NOT nt= pred ) |t= pred )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==NOT||LA36_0==TRUE) ) {
                alt36=1;
            }
            else if ( (LA36_0==CONST||LA36_0==VAR) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:200:40: ( TRUE | NOT nt= pred )
                    {
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:200:40: ( TRUE | NOT nt= pred )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==TRUE) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==NOT) ) {
                        alt35=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 0, input);

                        throw nvae;

                    }
                    switch (alt35) {
                        case 1 :
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:200:41: TRUE
                            {
                            match(input,TRUE,FOLLOW_TRUE_in_literal1816); 

                            l = new Abstract_Literal(Abstract_Literal.LTrue);

                            }
                            break;
                        case 2 :
                            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:201:5: NOT nt= pred
                            {
                            match(input,NOT,FOLLOW_NOT_in_literal1827); 

                            pushFollow(FOLLOW_pred_in_literal1831);
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
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:205:5: t= pred
                    {
                    pushFollow(FOLLOW_pred_in_literal1845);
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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:209:1: pred returns [Abstract_Predicate t] : (v= var |f= function ) ( SQOPEN w= word SQCLOSE )? ;
    public final Abstract_Predicate pred() throws RecognitionException {
        Abstract_Predicate t = null;


        Abstract_VarTerm v =null;

        Abstract_Predicate f =null;

        String w =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:209:37: ( (v= var |f= function ) ( SQOPEN w= word SQCLOSE )? )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:209:39: (v= var |f= function ) ( SQOPEN w= word SQCLOSE )?
            {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:209:39: (v= var |f= function )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==VAR) ) {
                alt37=1;
            }
            else if ( (LA37_0==CONST) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:209:40: v= var
                    {
                    pushFollow(FOLLOW_var_in_pred1862);
                    v=var();

                    state._fsp--;


                    t = v;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:209:60: f= function
                    {
                    pushFollow(FOLLOW_function_in_pred1869);
                    f=function();

                    state._fsp--;


                    t = f;

                    }
                    break;

            }


            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:209:85: ( SQOPEN w= word SQCLOSE )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==SQOPEN) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==CONST||LA38_1==VAR) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:209:86: SQOPEN w= word SQCLOSE
                    {
                    match(input,SQOPEN,FOLLOW_SQOPEN_in_pred1875); 

                    pushFollow(FOLLOW_word_in_pred1879);
                    w=word();

                    state._fsp--;


                    match(input,SQCLOSE,FOLLOW_SQCLOSE_in_pred1881); 

                    t = new Abstract_PredicatewEB(t, w);

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
    // $ANTLR end "pred"



    // $ANTLR start "function"
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:210:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
    public final Abstract_Predicate function() throws RecognitionException {
        Abstract_Predicate f = null;


        Token CONST4=null;

        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:210:40: ( CONST ( OPEN terms[$f] CLOSE )? )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:210:42: CONST ( OPEN terms[$f] CLOSE )?
            {
            CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_function1895); 

            f = new Abstract_Predicate(CONST4.getText());

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:210:97: ( OPEN terms[$f] CLOSE )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==OPEN) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:210:98: OPEN terms[$f] CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_function1900); 

                    pushFollow(FOLLOW_terms_in_function1902);
                    terms(f);

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_function1905); 

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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:212:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
    public final void terms(Abstract_Predicate f) throws RecognitionException {
        Abstract_Term t =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:212:29: (t= term ( COMMA terms[$f] )? )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:212:31: t= term ( COMMA terms[$f] )?
            {
            pushFollow(FOLLOW_term_in_terms1918);
            t=term();

            state._fsp--;


            f.addTerm(t);

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:212:58: ( COMMA terms[$f] )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==COMMA) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:212:59: COMMA terms[$f]
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_terms1923); 

                    pushFollow(FOLLOW_terms_in_terms1925);
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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:213:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |l= listterm |f= function );
    public final Abstract_Term term() throws RecognitionException {
        Abstract_Term t = null;


        Abstract_NumberTerm a =null;

        Abstract_StringTerm s =null;

        Abstract_ListTerm l =null;

        Abstract_Predicate f =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:213:31: (a= atom |s= stringterm |l= listterm |f= function )
            int alt41=4;
            switch ( input.LA(1) ) {
            case MINUS:
            case NUMBER:
            case OPEN:
            case VAR:
                {
                alt41=1;
                }
                break;
            case DOUBLEQUOTE:
                {
                alt41=2;
                }
                break;
            case SQOPEN:
                {
                alt41=3;
                }
                break;
            case CONST:
                {
                alt41=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }

            switch (alt41) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:213:34: a= atom
                    {
                    pushFollow(FOLLOW_atom_in_term1944);
                    a=atom();

                    state._fsp--;


                    t = a;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:213:58: s= stringterm
                    {
                    pushFollow(FOLLOW_stringterm_in_term1954);
                    s=stringterm();

                    state._fsp--;


                    t = s;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:213:88: l= listterm
                    {
                    pushFollow(FOLLOW_listterm_in_term1964);
                    l=listterm();

                    state._fsp--;


                    t = l;

                    }
                    break;
                case 4 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:213:115: f= function
                    {
                    pushFollow(FOLLOW_function_in_term1971);
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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:215:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
    public final Abstract_NumberTerm atom() throws RecognitionException {
        Abstract_NumberTerm t = null;


        String n =null;

        Abstract_VarTerm v =null;

        Abstract_NumberTerm a =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:215:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
            int alt42=3;
            switch ( input.LA(1) ) {
            case MINUS:
            case NUMBER:
                {
                alt42=1;
                }
                break;
            case VAR:
                {
                alt42=2;
                }
                break;
            case OPEN:
                {
                alt42=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }

            switch (alt42) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:215:40: n= numberstring
                    {
                    pushFollow(FOLLOW_numberstring_in_atom1989);
                    n=numberstring();

                    state._fsp--;


                    t = new Abstract_NumberTermImpl(n);

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:216:6: v= var
                    {
                    pushFollow(FOLLOW_var_in_atom2002);
                    v=var();

                    state._fsp--;


                    t = v;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:216:27: OPEN a= arithexpr CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_atom2008); 

                    pushFollow(FOLLOW_arithexpr_in_atom2012);
                    a=arithexpr();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_atom2014); 

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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:217:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
    public final Abstract_StringTerm stringterm() throws RecognitionException {
        Abstract_StringTerm s = null;


        Token STRING5=null;

        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:217:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:217:46: DOUBLEQUOTE STRING DOUBLEQUOTE
            {
            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2027); 

            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm2030); 

            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2032); 

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



    // $ANTLR start "listterm"
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:218:1: listterm returns [Abstract_ListTerm l] : SQOPEN (h= term '|' t= term )? SQCLOSE ;
    public final Abstract_ListTerm listterm() throws RecognitionException {
        Abstract_ListTerm l = null;


        Abstract_Term h =null;

        Abstract_Term t =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:218:40: ( SQOPEN (h= term '|' t= term )? SQCLOSE )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:218:42: SQOPEN (h= term '|' t= term )? SQCLOSE
            {
            match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2045); 

            l = new Abstract_ListTermImpl();

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:218:85: (h= term '|' t= term )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==CONST||LA43_0==DOUBLEQUOTE||LA43_0==MINUS||(LA43_0 >= NUMBER && LA43_0 <= OPEN)||LA43_0==SQOPEN||LA43_0==VAR) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:218:86: h= term '|' t= term
                    {
                    pushFollow(FOLLOW_term_in_listterm2054);
                    h=term();

                    state._fsp--;


                    match(input,63,FOLLOW_63_in_listterm2056); 

                    pushFollow(FOLLOW_term_in_listterm2062);
                    t=term();

                    state._fsp--;


                    l.addHead(h); l.addTail((Abstract_ListTerm) t);

                    }
                    break;

            }


            match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2068); 

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



    // $ANTLR start "var"
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:220:1: var returns [Abstract_VarTerm v] : VAR ;
    public final Abstract_VarTerm var() throws RecognitionException {
        Abstract_VarTerm v = null;


        Token VAR6=null;

        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:220:34: ( VAR )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:220:36: VAR
            {
            VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_var2080); 


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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:229:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
    public final String numberstring() throws RecognitionException {
        String s = null;


        Token n1=null;
        Token n2=null;

        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:229:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:229:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
            {
            s = "";

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:229:46: ( MINUS )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==MINUS) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:229:47: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_numberstring2097); 

                    s += "-";

                    }
                    break;

            }


            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:229:68: (n1= NUMBER ( POINT n2= NUMBER )? )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:229:69: n1= NUMBER ( POINT n2= NUMBER )?
            {
            n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2106); 

            s += n1.getText();

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:230:6: ( POINT n2= NUMBER )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==POINT) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:230:7: POINT n2= NUMBER
                    {
                    match(input,POINT,FOLLOW_POINT_in_numberstring2116); 

                    s += ".";

                    n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2122); 

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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:231:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
    public final Abstract_Equation equation() throws RecognitionException {
        Abstract_Equation eq = null;


        Abstract_NumberTerm a1 =null;

        int oper =0;

        Abstract_NumberTerm a2 =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:231:40: (a1= arithexpr oper= eqoper a2= arithexpr )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:231:42: a1= arithexpr oper= eqoper a2= arithexpr
            {
            pushFollow(FOLLOW_arithexpr_in_equation2139);
            a1=arithexpr();

            state._fsp--;


            pushFollow(FOLLOW_eqoper_in_equation2143);
            oper=eqoper();

            state._fsp--;


            pushFollow(FOLLOW_arithexpr_in_equation2147);
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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:232:1: eqoper returns [int oper] : ( LESS | EQ );
    public final int eqoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:232:27: ( LESS | EQ )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==LESS) ) {
                alt46=1;
            }
            else if ( (LA46_0==EQ) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }
            switch (alt46) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:232:29: LESS
                    {
                    match(input,LESS,FOLLOW_LESS_in_eqoper2161); 

                    oper =Abstract_Equation.less;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:232:68: EQ
                    {
                    match(input,EQ,FOLLOW_EQ_in_eqoper2167); 

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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:234:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
    public final Abstract_NumberTerm arithexpr() throws RecognitionException {
        Abstract_NumberTerm t = null;


        Abstract_NumberTerm m =null;

        int oper =0;

        Abstract_NumberTerm m1 =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:234:43: (m= multexpr (oper= addoper m1= multexpr )? )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:234:45: m= multexpr (oper= addoper m1= multexpr )?
            {
            pushFollow(FOLLOW_multexpr_in_arithexpr2183);
            m=multexpr();

            state._fsp--;


            t = m;

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:234:69: (oper= addoper m1= multexpr )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==MINUS||LA47_0==PLUS) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:234:71: oper= addoper m1= multexpr
                    {
                    pushFollow(FOLLOW_addoper_in_arithexpr2191);
                    oper=addoper();

                    state._fsp--;


                    pushFollow(FOLLOW_multexpr_in_arithexpr2195);
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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:235:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
    public final Abstract_NumberTerm multexpr() throws RecognitionException {
        Abstract_NumberTerm t = null;


        Abstract_NumberTerm a =null;

        int oper =0;

        Abstract_NumberTerm a1 =null;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:235:42: (a= atom (oper= multoper a1= atom )? )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:235:44: a= atom (oper= multoper a1= atom )?
            {
            pushFollow(FOLLOW_atom_in_multexpr2212);
            a=atom();

            state._fsp--;


            t = a;

            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:235:64: (oper= multoper a1= atom )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==DIV||(LA48_0 >= MOD && LA48_0 <= MULT)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:235:65: oper= multoper a1= atom
                    {
                    pushFollow(FOLLOW_multoper_in_multexpr2219);
                    oper=multoper();

                    state._fsp--;


                    pushFollow(FOLLOW_atom_in_multexpr2223);
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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:237:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
    public final int addoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:237:28: ( ( PLUS | MINUS ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:237:30: ( PLUS | MINUS )
            {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:237:30: ( PLUS | MINUS )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==PLUS) ) {
                alt49=1;
            }
            else if ( (LA49_0==MINUS) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }
            switch (alt49) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:237:31: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_addoper2240); 

                    oper =Abstract_ArithExpr.plus;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:237:70: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_addoper2245); 

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
    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:238:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
    public final int multoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:238:29: ( ( MULT | DIV | MOD ) )
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:238:31: ( MULT | DIV | MOD )
            {
            // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:238:31: ( MULT | DIV | MOD )
            int alt50=3;
            switch ( input.LA(1) ) {
            case MULT:
                {
                alt50=1;
                }
                break;
            case DIV:
                {
                alt50=2;
                }
                break;
            case MOD:
                {
                alt50=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }

            switch (alt50) {
                case 1 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:238:32: MULT
                    {
                    match(input,MULT,FOLLOW_MULT_in_multoper2260); 

                    oper =Abstract_ArithExpr.times;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:238:73: DIV
                    {
                    match(input,DIV,FOLLOW_DIV_in_multoper2266); 

                    oper =Abstract_ArithExpr.div;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/EthicalGwendolen/src/classes/ethical_gwen/parser/EthicalGwendolen.g:238:111: MOD
                    {
                    match(input,MOD,FOLLOW_MOD_in_multoper2272); 

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


 

    public static final BitSet FOLLOW_egwendolenagents_in_mas90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gwendolenagent_in_egwendolenagents111 = new BitSet(new long[]{0x0000004020000002L});
    public static final BitSet FOLLOW_GWENDOLEN_in_gwendolenagent138 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_NAME_in_gwendolenagent144 = new BitSet(new long[]{0x2000000000040000L});
    public static final BitSet FOLLOW_word_in_gwendolenagent148 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_ETHICS_in_gwendolenagent153 = new BitSet(new long[]{0x0000000002000800L});
    public static final BitSet FOLLOW_ethic_in_gwendolenagent158 = new BitSet(new long[]{0x0000000002000800L});
    public static final BitSet FOLLOW_BELIEFS_in_gwendolenagent165 = new BitSet(new long[]{0x3000010010040400L});
    public static final BitSet FOLLOW_literal_in_gwendolenagent170 = new BitSet(new long[]{0x3000010010040400L});
    public static final BitSet FOLLOW_BELIEFRULES_in_gwendolenagent178 = new BitSet(new long[]{0x2000000010040000L});
    public static final BitSet FOLLOW_brule_in_gwendolenagent183 = new BitSet(new long[]{0x2000000010040000L});
    public static final BitSet FOLLOW_GOALS_in_gwendolenagent192 = new BitSet(new long[]{0x3000210000040000L});
    public static final BitSet FOLLOW_goal_in_gwendolenagent197 = new BitSet(new long[]{0x3000210000040000L});
    public static final BitSet FOLLOW_PLANS_in_gwendolenagent204 = new BitSet(new long[]{0x0000400800000002L});
    public static final BitSet FOLLOW_plan_in_gwendolenagent209 = new BitSet(new long[]{0x0000400800000002L});
    public static final BitSet FOLLOW_ETHIC_in_ethic226 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_OPEN_in_ethic228 = new BitSet(new long[]{0x2000000000040000L});
    public static final BitSet FOLLOW_pred_in_ethic232 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_ethic234 = new BitSet(new long[]{0x2000000000040000L});
    public static final BitSet FOLLOW_pred_in_ethic238 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_ethic240 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_NUMBER_in_ethic244 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_ethic246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BELIEVE_in_guard_atom262 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_literal_in_guard_atom266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GOAL_in_guard_atom276 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_goal_in_guard_atom280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SENT_in_guard_atom290 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_OPEN_in_guard_atom292 = new BitSet(new long[]{0x2000000000040000L});
    public static final BitSet FOLLOW_agentnameterm_in_guard_atom299 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_guard_atom333 = new BitSet(new long[]{0x2C000800000C0010L});
    public static final BitSet FOLLOW_agentnameterm_in_guard_atom340 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_guard_atom348 = new BitSet(new long[]{0x0C00080000080010L});
    public static final BitSet FOLLOW_performative_in_guard_atom356 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_guard_atom364 = new BitSet(new long[]{0x2000000000040000L});
    public static final BitSet FOLLOW_pred_in_guard_atom368 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_guard_atom370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equation_in_guard_atom384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_guard_atom394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_goal412 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_SQOPEN_in_goal414 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_ACHIEVEGOAL_in_goal417 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_PERFORMGOAL_in_goal427 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_goal432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_in_plan446 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_plan454 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_plan456 = new BitSet(new long[]{0x3020070808001000L});
    public static final BitSet FOLLOW_NOT_in_plan461 = new BitSet(new long[]{0x3020060808001000L});
    public static final BitSet FOLLOW_guard_atom_in_plan469 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_COMMA_in_plan477 = new BitSet(new long[]{0x3020070808001000L});
    public static final BitSet FOLLOW_NOT_in_plan482 = new BitSet(new long[]{0x3020060808001000L});
    public static final BitSet FOLLOW_guard_atom_in_plan490 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_plan496 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_RULEARROW_in_plan499 = new BitSet(new long[]{0x2010402800040000L});
    public static final BitSet FOLLOW_deed_in_plan504 = new BitSet(new long[]{0x0008000000010000L});
    public static final BitSet FOLLOW_COMMA_in_plan509 = new BitSet(new long[]{0x2010402800040000L});
    public static final BitSet FOLLOW_deed_in_plan513 = new BitSet(new long[]{0x0008000000010000L});
    public static final BitSet FOLLOW_SEMI_in_plan523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_event539 = new BitSet(new long[]{0x3042010000040180L});
    public static final BitSet FOLLOW_RECEIVED_in_event542 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_OPEN_in_event544 = new BitSet(new long[]{0x0C00080000080010L});
    public static final BitSet FOLLOW_performative_in_event548 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_event550 = new BitSet(new long[]{0x2000000000040000L});
    public static final BitSet FOLLOW_pred_in_event554 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_event556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_event574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_event584 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_goal_in_event588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_event599 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_literal_in_event603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_event613 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_literal_in_event617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_event635 = new BitSet(new long[]{0x3040010000040180L});
    public static final BitSet FOLLOW_literal_in_event640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_event650 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_goal_in_event654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_event664 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_literal_in_event668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_event678 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_literal_in_event682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TELL_in_performative704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERFORM_in_performative710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACHIEVE_in_performative716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TELLHOW_in_performative722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTRAINT_in_performative728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_deed754 = new BitSet(new long[]{0x30400104000403C0L});
    public static final BitSet FOLLOW_literal_in_deed759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_deed769 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_goal_in_deed773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_deed783 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_literal_in_deed787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_deed797 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_literal_in_deed801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_PLAN_in_deed811 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_literal_in_deed815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONSTRAINT_in_deed825 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_literal_in_deed829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_in_deed839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_deed852 = new BitSet(new long[]{0x3040010400040180L});
    public static final BitSet FOLLOW_literal_in_deed857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHRIEK_in_deed867 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_goal_in_deed871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTENT_in_deed881 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_literal_in_deed885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_CONTEXT_in_deed895 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_literal_in_deed899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_in_deed909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_deed928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_waitfor_in_deed941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pred_in_brule976 = new BitSet(new long[]{0x0008000000002000L});
    public static final BitSet FOLLOW_BRULEARROW_in_brule979 = new BitSet(new long[]{0x2000010000040000L});
    public static final BitSet FOLLOW_logicalfmla_in_brule983 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_SEMI_in_brule987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_brule991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notfmla_in_logicalfmla1008 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_COMMA_in_logicalfmla1028 = new BitSet(new long[]{0x2000010000040000L});
    public static final BitSet FOLLOW_notfmla_in_logicalfmla1032 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_pred_in_notfmla1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_notfmla1152 = new BitSet(new long[]{0x2000040000040000L});
    public static final BitSet FOLLOW_pred_in_notfmla1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subfmla_in_notfmla1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_subfmla1183 = new BitSet(new long[]{0x2000010000040000L});
    public static final BitSet FOLLOW_logicalfmla_in_subfmla1189 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_subfmla1193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULT_in_waitfor1206 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_literal_in_waitfor1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEND_in_action1227 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_OPEN_in_action1229 = new BitSet(new long[]{0x3000010000040000L});
    public static final BitSet FOLLOW_literal_in_action1233 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_action1235 = new BitSet(new long[]{0x0C00080000080010L});
    public static final BitSet FOLLOW_performative_in_action1239 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_action1241 = new BitSet(new long[]{0x2000000000040000L});
    public static final BitSet FOLLOW_pred_in_action1245 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_action1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pred_in_action1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classpath_in_environment1561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_word_in_classpath1576 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_POINT_in_classpath1581 = new BitSet(new long[]{0x2000000000040000L});
    public static final BitSet FOLLOW_word_in_classpath1585 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_CONST_in_word1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_word1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_agentnameterm1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_agentnameterm1800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_literal1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_literal1827 = new BitSet(new long[]{0x2000000000040000L});
    public static final BitSet FOLLOW_pred_in_literal1831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pred_in_literal1845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_pred1862 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_function_in_pred1869 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_SQOPEN_in_pred1875 = new BitSet(new long[]{0x2000000000040000L});
    public static final BitSet FOLLOW_word_in_pred1879 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_pred1881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_function1895 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_OPEN_in_function1900 = new BitSet(new long[]{0x2100060800840000L});
    public static final BitSet FOLLOW_terms_in_function1902 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_function1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_terms1918 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_COMMA_in_terms1923 = new BitSet(new long[]{0x2100060800840000L});
    public static final BitSet FOLLOW_terms_in_terms1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_term1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringterm_in_term1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listterm_in_term1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_term1971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numberstring_in_atom1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_atom2002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_atom2008 = new BitSet(new long[]{0x2000060800000000L});
    public static final BitSet FOLLOW_arithexpr_in_atom2012 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_CLOSE_in_atom2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2027 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_STRING_in_stringterm2030 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQOPEN_in_listterm2045 = new BitSet(new long[]{0x2180060800840000L});
    public static final BitSet FOLLOW_term_in_listterm2054 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_listterm2056 = new BitSet(new long[]{0x2100060800840000L});
    public static final BitSet FOLLOW_term_in_listterm2062 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_SQCLOSE_in_listterm2068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_var2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_numberstring2097 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring2106 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_POINT_in_numberstring2116 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithexpr_in_equation2139 = new BitSet(new long[]{0x0000000101000000L});
    public static final BitSet FOLLOW_eqoper_in_equation2143 = new BitSet(new long[]{0x2000060800000000L});
    public static final BitSet FOLLOW_arithexpr_in_equation2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_in_eqoper2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_eqoper2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr2183 = new BitSet(new long[]{0x0000400800000002L});
    public static final BitSet FOLLOW_addoper_in_arithexpr2191 = new BitSet(new long[]{0x2000060800000000L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr2195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_multexpr2212 = new BitSet(new long[]{0x0000003000400002L});
    public static final BitSet FOLLOW_multoper_in_multexpr2219 = new BitSet(new long[]{0x2000060800000000L});
    public static final BitSet FOLLOW_atom_in_multexpr2223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_addoper2240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_addoper2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULT_in_multoper2260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_multoper2266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOD_in_multoper2272 = new BitSet(new long[]{0x0000000000000002L});

}