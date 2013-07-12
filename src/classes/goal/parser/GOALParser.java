// $ANTLR 3.4 /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g 2013-05-16 12:42:39

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADOPT", "AGNAME", "AND", "ANON_VAR", "BELIEFS", "BELIEVE", "BRULEARROW", "BRULES", "CAPABILITIES", "CLOSE", "CLOSEKEY", "COLON", "COMMA", "COMMENT", "CONDACTIONS", "CONST", "CONTENT", "CONTEXT", "CURLYCLOSE", "CURLYOPEN", "DEL", "DIV", "DOUBLEQUOTE", "DROP", "EQ", "GOAL", "GOALS", "HAVEGOAL", "IF", "INS", "IN_CONTENT", "IN_CONTEXT", "LESS", "LINE_COMMENT", "MINUS", "MOD", "MULT", "NAME", "NEWLINE", "NOT", "NUMBER", "NUMMARKER", "OPEN", "PLUS", "POINT", "QUERY", "SEMI", "SEND", "SHRIEK", "SQCLOSE", "SQOPEN", "STRING", "THEN", "TRUE", "VAR", "WS"
    };

    public static final int EOF=-1;
    public static final int ADOPT=4;
    public static final int AGNAME=5;
    public static final int AND=6;
    public static final int ANON_VAR=7;
    public static final int BELIEFS=8;
    public static final int BELIEVE=9;
    public static final int BRULEARROW=10;
    public static final int BRULES=11;
    public static final int CAPABILITIES=12;
    public static final int CLOSE=13;
    public static final int CLOSEKEY=14;
    public static final int COLON=15;
    public static final int COMMA=16;
    public static final int COMMENT=17;
    public static final int CONDACTIONS=18;
    public static final int CONST=19;
    public static final int CONTENT=20;
    public static final int CONTEXT=21;
    public static final int CURLYCLOSE=22;
    public static final int CURLYOPEN=23;
    public static final int DEL=24;
    public static final int DIV=25;
    public static final int DOUBLEQUOTE=26;
    public static final int DROP=27;
    public static final int EQ=28;
    public static final int GOAL=29;
    public static final int GOALS=30;
    public static final int HAVEGOAL=31;
    public static final int IF=32;
    public static final int INS=33;
    public static final int IN_CONTENT=34;
    public static final int IN_CONTEXT=35;
    public static final int LESS=36;
    public static final int LINE_COMMENT=37;
    public static final int MINUS=38;
    public static final int MOD=39;
    public static final int MULT=40;
    public static final int NAME=41;
    public static final int NEWLINE=42;
    public static final int NOT=43;
    public static final int NUMBER=44;
    public static final int NUMMARKER=45;
    public static final int OPEN=46;
    public static final int PLUS=47;
    public static final int POINT=48;
    public static final int QUERY=49;
    public static final int SEMI=50;
    public static final int SEND=51;
    public static final int SHRIEK=52;
    public static final int SQCLOSE=53;
    public static final int SQOPEN=54;
    public static final int STRING=55;
    public static final int THEN=56;
    public static final int TRUE=57;
    public static final int VAR=58;
    public static final int WS=59;

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
    public String getGrammarFileName() { return "/Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g"; }


    	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
    	private String name = "";



    // $ANTLR start "mas"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:58:1: mas returns [Abstract_MAS mas] :glist= goalagents ;
    public final Abstract_MAS mas() throws RecognitionException {
        Abstract_MAS mas = null;


        ArrayList<Abstract_GOALAgent> glist =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:58:32: (glist= goalagents )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:58:34: glist= goalagents
            {
            mas = new Abstract_MAS();

            pushFollow(FOLLOW_goalagents_in_mas76);
            glist=goalagents();

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



    // $ANTLR start "goalagents"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:61:1: goalagents returns [ArrayList<Abstract_GOALAgent> gags] : GOAL (g= goalagent )+ ;
    public final ArrayList<Abstract_GOALAgent> goalagents() throws RecognitionException {
        ArrayList<Abstract_GOALAgent> gags = null;


        Abstract_GOALAgent g =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:61:55: ( GOAL (g= goalagent )+ )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:61:57: GOAL (g= goalagent )+
            {
            match(input,GOAL,FOLLOW_GOAL_in_goalagents88); 

            gags=new ArrayList<Abstract_GOALAgent>();

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:62:2: (g= goalagent )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==NAME) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:62:3: g= goalagent
            	    {
            	    pushFollow(FOLLOW_goalagent_in_goalagents97);
            	    g=goalagent();

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
    // $ANTLR end "goalagents"



    // $ANTLR start "brule"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:64:1: brule returns [Abstract_Rule r] : head= literal BRULEARROW gb= fmla ;
    public final Abstract_Rule brule() throws RecognitionException {
        Abstract_Rule r = null;


        Abstract_Literal head =null;

        Abstract_LogicalFormula gb =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:64:32: (head= literal BRULEARROW gb= fmla )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:64:34: head= literal BRULEARROW gb= fmla
            {
            pushFollow(FOLLOW_literal_in_brule285);
            head=literal();

            state._fsp--;


            match(input,BRULEARROW,FOLLOW_BRULEARROW_in_brule287); 

            pushFollow(FOLLOW_fmla_in_brule291);
            gb=fmla();

            state._fsp--;


            r = new Abstract_Rule(new Abstract_GBelief(Abstract_GBelief.AILBel, head), gb);

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



    // $ANTLR start "fmla"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:66:1: fmla returns [Abstract_LogicalFormula f] : gb= literal ( COMMA and= fmla | ( SEMI and= fmla ) )* ;
    public final Abstract_LogicalFormula fmla() throws RecognitionException {
        Abstract_LogicalFormula f = null;


        Abstract_Literal gb =null;

        Abstract_LogicalFormula and =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:66:42: (gb= literal ( COMMA and= fmla | ( SEMI and= fmla ) )* )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:66:44: gb= literal ( COMMA and= fmla | ( SEMI and= fmla ) )*
            {
            pushFollow(FOLLOW_literal_in_fmla311);
            gb=literal();

            state._fsp--;


            f = new Abstract_GBelief(Abstract_GBelief.AILBel, gb);

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:67:2: ( COMMA and= fmla | ( SEMI and= fmla ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==COMMA) ) {
                    alt2=1;
                }
                else if ( (LA2_0==SEMI) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:67:3: COMMA and= fmla
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_fmla318); 

            	    pushFollow(FOLLOW_fmla_in_fmla322);
            	    and=fmla();

            	    state._fsp--;


            	    f = new Abstract_LogExpr(new Abstract_GBelief(Abstract_GBelief.AILBel, gb), Abstract_LogExpr.and, and);

            	    }
            	    break;
            	case 2 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:69:2: ( SEMI and= fmla )
            	    {
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:69:2: ( SEMI and= fmla )
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:69:3: SEMI and= fmla
            	    {
            	    match(input,SEMI,FOLLOW_SEMI_in_fmla332); 

            	    pushFollow(FOLLOW_fmla_in_fmla336);
            	    and=fmla();

            	    state._fsp--;


            	    f = new Abstract_LogExpr(new Abstract_GBelief(Abstract_GBelief.AILBel, gb), Abstract_LogExpr.or, and);

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "fmla"



    // $ANTLR start "goalagent"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:72:1: goalagent returns [Abstract_GOALAgent g] : NAME w= word BELIEFS (l= literal )* BRULES (r= brule )* GOALS (l1= literal )* CONDACTIONS (ca= condaction )* CAPABILITIES (cap= capability )* ;
    public final Abstract_GOALAgent goalagent() throws RecognitionException {
        Abstract_GOALAgent g = null;


        String w =null;

        Abstract_Literal l =null;

        Abstract_Rule r =null;

        Abstract_Literal l1 =null;

        Abstract_ActionRule ca =null;

        Abstract_ActionSpec cap =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:72:42: ( NAME w= word BELIEFS (l= literal )* BRULES (r= brule )* GOALS (l1= literal )* CONDACTIONS (ca= condaction )* CAPABILITIES (cap= capability )* )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:72:44: NAME w= word BELIEFS (l= literal )* BRULES (r= brule )* GOALS (l1= literal )* CONDACTIONS (ca= condaction )* CAPABILITIES (cap= capability )*
            {
            match(input,NAME,FOLLOW_NAME_in_goalagent354); 

            pushFollow(FOLLOW_word_in_goalagent358);
            w=word();

            state._fsp--;


            name = w;

            try {g = new Abstract_GOALAgent(w);} catch (Exception e) {System.err.println(e);}

            match(input,BELIEFS,FOLLOW_BELIEFS_in_goalagent367); 

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:74:10: (l= literal )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ANON_VAR||LA3_0==CONST||LA3_0==NOT||(LA3_0 >= TRUE && LA3_0 <= VAR)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:74:11: l= literal
            	    {
            	    pushFollow(FOLLOW_literal_in_goalagent372);
            	    l=literal();

            	    state._fsp--;


            	    g.addInitialBel(l);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input,BRULES,FOLLOW_BRULES_in_goalagent379); 

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:75:9: (r= brule )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==ANON_VAR||LA4_0==CONST||LA4_0==NOT||(LA4_0 >= TRUE && LA4_0 <= VAR)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:75:10: r= brule
            	    {
            	    pushFollow(FOLLOW_brule_in_goalagent384);
            	    r=brule();

            	    state._fsp--;


            	    g.addRule(r);

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            match(input,GOALS,FOLLOW_GOALS_in_goalagent391); 

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:76:8: (l1= literal )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ANON_VAR||LA5_0==CONST||LA5_0==NOT||(LA5_0 >= TRUE && LA5_0 <= VAR)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:76:9: l1= literal
            	    {
            	    Abstract_StringTerm zero = new Abstract_StringTermImpl("");

            	    pushFollow(FOLLOW_literal_in_goalagent398);
            	    l1=literal();

            	    state._fsp--;


            	    g.addGoal(l1, new Abstract_StringTermImpl(""));

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match(input,CONDACTIONS,FOLLOW_CONDACTIONS_in_goalagent405); 

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:77:14: (ca= condaction )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==IF) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:77:15: ca= condaction
            	    {
            	    pushFollow(FOLLOW_condaction_in_goalagent410);
            	    ca=condaction();

            	    state._fsp--;


            	    try {g.addPlan(ca);} catch (Exception e) {System.err.println(e);}

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            match(input,CAPABILITIES,FOLLOW_CAPABILITIES_in_goalagent417); 

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:78:15: (cap= capability )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ANON_VAR||LA7_0==CONST||LA7_0==NOT||(LA7_0 >= TRUE && LA7_0 <= VAR)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:78:16: cap= capability
            	    {
            	    pushFollow(FOLLOW_capability_in_goalagent422);
            	    cap=capability();

            	    state._fsp--;


            	    try {g.addPlan(cap);} catch (Exception e) {System.err.println(e);}

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
    // $ANTLR end "goalagent"



    // $ANTLR start "goal"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:80:1: goal[Abstract_StringTerm i] returns [Abstract_Goal g] : l= literal ( AND l2= literal )* ;
    public final Abstract_Goal goal(Abstract_StringTerm i) throws RecognitionException {
        Abstract_Goal g = null;


        Abstract_Literal l =null;

        Abstract_Literal l2 =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:80:55: (l= literal ( AND l2= literal )* )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:80:58: l= literal ( AND l2= literal )*
            {
            pushFollow(FOLLOW_literal_in_goal443);
            l=literal();

            state._fsp--;


            Abstract_Literal l1 = l;

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:81:2: ( AND l2= literal )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==AND) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:81:3: AND l2= literal
            	    {
            	    match(input,AND,FOLLOW_AND_in_goal450); 

            	    pushFollow(FOLLOW_literal_in_goal454);
            	    l2=literal();

            	    state._fsp--;


            	    Abstract_Literal l3 = new Abstract_Literal("and"); l3.addTerm(l1); l3.addTerm(l2); l1 = l3;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            g = new Abstract_Goal(l1, Abstract_Goal.achieveGoal); g.setGoalBase(i);

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



    // $ANTLR start "capability"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:84:1: capability returns [Abstract_ActionSpec c] : g= capname CURLYOPEN ms= precondition CURLYCLOSE CURLYOPEN postcondition[deeds] CURLYCLOSE ;
    public final Abstract_ActionSpec capability() throws RecognitionException {
        Abstract_ActionSpec c = null;


        Abstract_Goal g =null;

        Abstract_MentalState ms =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:85:2: (g= capname CURLYOPEN ms= precondition CURLYCLOSE CURLYOPEN postcondition[deeds] CURLYCLOSE )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:85:4: g= capname CURLYOPEN ms= precondition CURLYCLOSE CURLYOPEN postcondition[deeds] CURLYCLOSE
            {
            pushFollow(FOLLOW_capname_in_capability477);
            g=capname();

            state._fsp--;


            ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>();

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_capability484); 

            pushFollow(FOLLOW_precondition_in_capability490);
            ms=precondition();

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_capability492); 

            match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_capability496); 

            pushFollow(FOLLOW_postcondition_in_capability498);
            postcondition(deeds);

            state._fsp--;


            match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_capability501); 

            c = new Abstract_ActionSpec(g, ms, deeds); variables.clear();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return c;
    }
    // $ANTLR end "capability"



    // $ANTLR start "condaction"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:89:1: condaction returns [Abstract_ActionRule cact] : IF ms= precondition THEN ca= capostcondition[deeds] ;
    public final Abstract_ActionRule condaction() throws RecognitionException {
        Abstract_ActionRule cact = null;


        Abstract_MentalState ms =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:90:2: ( IF ms= precondition THEN ca= capostcondition[deeds] )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:90:4: IF ms= precondition THEN ca= capostcondition[deeds]
            {
            match(input,IF,FOLLOW_IF_in_condaction517); 

            pushFollow(FOLLOW_precondition_in_condaction521);
            ms=precondition();

            state._fsp--;


            match(input,THEN,FOLLOW_THEN_in_condaction523); 

            ArrayList<Abstract_Deed> deeds = new ArrayList<Abstract_Deed>();

            pushFollow(FOLLOW_capostcondition_in_condaction529);
            capostcondition(deeds);

            state._fsp--;


            cact = new Abstract_ActionRule(ms, deeds); cact.reverseBody(); variables.clear();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return cact;
    }
    // $ANTLR end "condaction"



    // $ANTLR start "capostcondition"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:92:1: capostcondition[ArrayList<Abstract_Deed> deeds] : ( INS OPEN (s2= dbnumb COMMA )? l= literal CLOSE | DEL OPEN (s2= dbnumb COMMA )? l= literal CLOSE | ADOPT OPEN (s2= dbnumb COMMA )? g= goal[s1] CLOSE | DROP OPEN (s2= dbnumb COMMA )? g= goal[s1] CLOSE | CONTENT OPEN l= literal CLOSE | CONTEXT OPEN l= literal CLOSE | SEND OPEN st= conv_id ':' SQOPEN (i= dbnumb )+ SQCLOSE COMMA ( MULT | MOD | QUERY | SHRIEK | POINT ) t= literal ( COMMA ( QUERY | SHRIEK | POINT ) t1= literal )* CLOSE | CLOSEKEY OPEN s= conv_id CLOSE |gl= capname ) ( COMMA capostcondition[deeds] )* ;
    public final void capostcondition(ArrayList<Abstract_Deed> deeds) throws RecognitionException {
        Abstract_StringTerm s2 =null;

        Abstract_Literal l =null;

        Abstract_Goal g =null;

        Abstract_StringTerm st =null;

        Abstract_StringTerm i =null;

        Abstract_Literal t =null;

        Abstract_Literal t1 =null;

        Abstract_StringTerm s =null;

        Abstract_Goal gl =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:93:2: ( ( INS OPEN (s2= dbnumb COMMA )? l= literal CLOSE | DEL OPEN (s2= dbnumb COMMA )? l= literal CLOSE | ADOPT OPEN (s2= dbnumb COMMA )? g= goal[s1] CLOSE | DROP OPEN (s2= dbnumb COMMA )? g= goal[s1] CLOSE | CONTENT OPEN l= literal CLOSE | CONTEXT OPEN l= literal CLOSE | SEND OPEN st= conv_id ':' SQOPEN (i= dbnumb )+ SQCLOSE COMMA ( MULT | MOD | QUERY | SHRIEK | POINT ) t= literal ( COMMA ( QUERY | SHRIEK | POINT ) t1= literal )* CLOSE | CLOSEKEY OPEN s= conv_id CLOSE |gl= capname ) ( COMMA capostcondition[deeds] )* )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:93:4: ( INS OPEN (s2= dbnumb COMMA )? l= literal CLOSE | DEL OPEN (s2= dbnumb COMMA )? l= literal CLOSE | ADOPT OPEN (s2= dbnumb COMMA )? g= goal[s1] CLOSE | DROP OPEN (s2= dbnumb COMMA )? g= goal[s1] CLOSE | CONTENT OPEN l= literal CLOSE | CONTEXT OPEN l= literal CLOSE | SEND OPEN st= conv_id ':' SQOPEN (i= dbnumb )+ SQCLOSE COMMA ( MULT | MOD | QUERY | SHRIEK | POINT ) t= literal ( COMMA ( QUERY | SHRIEK | POINT ) t1= literal )* CLOSE | CLOSEKEY OPEN s= conv_id CLOSE |gl= capname ) ( COMMA capostcondition[deeds] )*
            {
            Abstract_StringTerm s1 = new Abstract_StringTermImpl("");

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:94:2: ( INS OPEN (s2= dbnumb COMMA )? l= literal CLOSE | DEL OPEN (s2= dbnumb COMMA )? l= literal CLOSE | ADOPT OPEN (s2= dbnumb COMMA )? g= goal[s1] CLOSE | DROP OPEN (s2= dbnumb COMMA )? g= goal[s1] CLOSE | CONTENT OPEN l= literal CLOSE | CONTEXT OPEN l= literal CLOSE | SEND OPEN st= conv_id ':' SQOPEN (i= dbnumb )+ SQCLOSE COMMA ( MULT | MOD | QUERY | SHRIEK | POINT ) t= literal ( COMMA ( QUERY | SHRIEK | POINT ) t1= literal )* CLOSE | CLOSEKEY OPEN s= conv_id CLOSE |gl= capname )
            int alt17=9;
            switch ( input.LA(1) ) {
            case INS:
                {
                alt17=1;
                }
                break;
            case DEL:
                {
                alt17=2;
                }
                break;
            case ADOPT:
                {
                alt17=3;
                }
                break;
            case DROP:
                {
                alt17=4;
                }
                break;
            case CONTENT:
                {
                alt17=5;
                }
                break;
            case CONTEXT:
                {
                alt17=6;
                }
                break;
            case SEND:
                {
                alt17=7;
                }
                break;
            case CLOSEKEY:
                {
                alt17=8;
                }
                break;
            case ANON_VAR:
            case CONST:
            case NOT:
            case TRUE:
            case VAR:
                {
                alt17=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:94:3: INS OPEN (s2= dbnumb COMMA )? l= literal CLOSE
                    {
                    match(input,INS,FOLLOW_INS_in_capostcondition548); 

                    match(input,OPEN,FOLLOW_OPEN_in_capostcondition550); 

                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:94:12: (s2= dbnumb COMMA )?
                    int alt9=2;
                    switch ( input.LA(1) ) {
                        case CONST:
                            {
                            int LA9_1 = input.LA(2);

                            if ( (LA9_1==COMMA) ) {
                                alt9=1;
                            }
                            }
                            break;
                        case VAR:
                            {
                            int LA9_2 = input.LA(2);

                            if ( (LA9_2==COMMA) ) {
                                alt9=1;
                            }
                            }
                            break;
                        case ANON_VAR:
                            {
                            int LA9_3 = input.LA(2);

                            if ( (LA9_3==COMMA) ) {
                                alt9=1;
                            }
                            }
                            break;
                    }

                    switch (alt9) {
                        case 1 :
                            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:94:13: s2= dbnumb COMMA
                            {
                            pushFollow(FOLLOW_dbnumb_in_capostcondition555);
                            s2=dbnumb();

                            state._fsp--;


                            match(input,COMMA,FOLLOW_COMMA_in_capostcondition557); 

                            s1 = s2;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_literal_in_capostcondition565);
                    l=literal();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_capostcondition567); 

                    Abstract_Deed d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, l); d.setDBnum(s1); deeds.add(d);

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:95:4: DEL OPEN (s2= dbnumb COMMA )? l= literal CLOSE
                    {
                    match(input,DEL,FOLLOW_DEL_in_capostcondition576); 

                    match(input,OPEN,FOLLOW_OPEN_in_capostcondition579); 

                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:95:14: (s2= dbnumb COMMA )?
                    int alt10=2;
                    switch ( input.LA(1) ) {
                        case CONST:
                            {
                            int LA10_1 = input.LA(2);

                            if ( (LA10_1==COMMA) ) {
                                alt10=1;
                            }
                            }
                            break;
                        case VAR:
                            {
                            int LA10_2 = input.LA(2);

                            if ( (LA10_2==COMMA) ) {
                                alt10=1;
                            }
                            }
                            break;
                        case ANON_VAR:
                            {
                            int LA10_3 = input.LA(2);

                            if ( (LA10_3==COMMA) ) {
                                alt10=1;
                            }
                            }
                            break;
                    }

                    switch (alt10) {
                        case 1 :
                            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:95:15: s2= dbnumb COMMA
                            {
                            pushFollow(FOLLOW_dbnumb_in_capostcondition584);
                            s2=dbnumb();

                            state._fsp--;


                            match(input,COMMA,FOLLOW_COMMA_in_capostcondition586); 

                            s1 = s2;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_literal_in_capostcondition594);
                    l=literal();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_capostcondition596); 

                    Abstract_Deed d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, l); d.setDBnum(s1); deeds.add(d);

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:96:4: ADOPT OPEN (s2= dbnumb COMMA )? g= goal[s1] CLOSE
                    {
                    match(input,ADOPT,FOLLOW_ADOPT_in_capostcondition605); 

                    match(input,OPEN,FOLLOW_OPEN_in_capostcondition608); 

                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:96:16: (s2= dbnumb COMMA )?
                    int alt11=2;
                    switch ( input.LA(1) ) {
                        case CONST:
                            {
                            int LA11_1 = input.LA(2);

                            if ( (LA11_1==COMMA) ) {
                                alt11=1;
                            }
                            }
                            break;
                        case VAR:
                            {
                            int LA11_2 = input.LA(2);

                            if ( (LA11_2==COMMA) ) {
                                alt11=1;
                            }
                            }
                            break;
                        case ANON_VAR:
                            {
                            int LA11_3 = input.LA(2);

                            if ( (LA11_3==COMMA) ) {
                                alt11=1;
                            }
                            }
                            break;
                    }

                    switch (alt11) {
                        case 1 :
                            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:96:17: s2= dbnumb COMMA
                            {
                            pushFollow(FOLLOW_dbnumb_in_capostcondition613);
                            s2=dbnumb();

                            state._fsp--;


                            match(input,COMMA,FOLLOW_COMMA_in_capostcondition615); 

                            s1 = s2;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_goal_in_capostcondition623);
                    g=goal(s1);

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_capostcondition626); 

                    deeds.add(new Abstract_Deed(Abstract_Deed.AILAddition, g));

                    }
                    break;
                case 4 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:97:4: DROP OPEN (s2= dbnumb COMMA )? g= goal[s1] CLOSE
                    {
                    match(input,DROP,FOLLOW_DROP_in_capostcondition635); 

                    match(input,OPEN,FOLLOW_OPEN_in_capostcondition638); 

                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:97:15: (s2= dbnumb COMMA )?
                    int alt12=2;
                    switch ( input.LA(1) ) {
                        case CONST:
                            {
                            int LA12_1 = input.LA(2);

                            if ( (LA12_1==COMMA) ) {
                                alt12=1;
                            }
                            }
                            break;
                        case VAR:
                            {
                            int LA12_2 = input.LA(2);

                            if ( (LA12_2==COMMA) ) {
                                alt12=1;
                            }
                            }
                            break;
                        case ANON_VAR:
                            {
                            int LA12_3 = input.LA(2);

                            if ( (LA12_3==COMMA) ) {
                                alt12=1;
                            }
                            }
                            break;
                    }

                    switch (alt12) {
                        case 1 :
                            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:97:16: s2= dbnumb COMMA
                            {
                            pushFollow(FOLLOW_dbnumb_in_capostcondition643);
                            s2=dbnumb();

                            state._fsp--;


                            match(input,COMMA,FOLLOW_COMMA_in_capostcondition645); 

                            s1 = s2;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_goal_in_capostcondition653);
                    g=goal(s1);

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_capostcondition656); 

                    deeds.add(new Abstract_Deed(Abstract_Deed.AILDeletion, g));

                    }
                    break;
                case 5 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:98:4: CONTENT OPEN l= literal CLOSE
                    {
                    match(input,CONTENT,FOLLOW_CONTENT_in_capostcondition665); 

                    match(input,OPEN,FOLLOW_OPEN_in_capostcondition667); 

                    pushFollow(FOLLOW_literal_in_capostcondition671);
                    l=literal();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_capostcondition673); 

                    deeds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContent, l));

                    }
                    break;
                case 6 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:99:4: CONTEXT OPEN l= literal CLOSE
                    {
                    match(input,CONTEXT,FOLLOW_CONTEXT_in_capostcondition682); 

                    match(input,OPEN,FOLLOW_OPEN_in_capostcondition684); 

                    pushFollow(FOLLOW_literal_in_capostcondition688);
                    l=literal();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_capostcondition690); 

                    deeds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContext, l));

                    }
                    break;
                case 7 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:100:4: SEND OPEN st= conv_id ':' SQOPEN (i= dbnumb )+ SQCLOSE COMMA ( MULT | MOD | QUERY | SHRIEK | POINT ) t= literal ( COMMA ( QUERY | SHRIEK | POINT ) t1= literal )* CLOSE
                    {
                    match(input,SEND,FOLLOW_SEND_in_capostcondition699); 

                    match(input,OPEN,FOLLOW_OPEN_in_capostcondition701); 

                    pushFollow(FOLLOW_conv_id_in_capostcondition705);
                    st=conv_id();

                    state._fsp--;


                    match(input,COLON,FOLLOW_COLON_in_capostcondition707); 

                    ArrayList<Abstract_Term> rs = new ArrayList<Abstract_Term>(); int ilf = 0;

                    match(input,SQOPEN,FOLLOW_SQOPEN_in_capostcondition716); 

                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:101:12: (i= dbnumb )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==ANON_VAR||LA13_0==CONST||LA13_0==VAR) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:101:13: i= dbnumb
                    	    {
                    	    pushFollow(FOLLOW_dbnumb_in_capostcondition721);
                    	    i=dbnumb();

                    	    state._fsp--;


                    	    rs.add(i);

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


                    match(input,SQCLOSE,FOLLOW_SQCLOSE_in_capostcondition727); 

                    match(input,COMMA,FOLLOW_COMMA_in_capostcondition729); 

                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:102:5: ( MULT | MOD | QUERY | SHRIEK | POINT )
                    int alt14=5;
                    switch ( input.LA(1) ) {
                    case MULT:
                        {
                        alt14=1;
                        }
                        break;
                    case MOD:
                        {
                        alt14=2;
                        }
                        break;
                    case QUERY:
                        {
                        alt14=3;
                        }
                        break;
                    case SHRIEK:
                        {
                        alt14=4;
                        }
                        break;
                    case POINT:
                        {
                        alt14=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;

                    }

                    switch (alt14) {
                        case 1 :
                            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:102:6: MULT
                            {
                            match(input,MULT,FOLLOW_MULT_in_capostcondition736); 

                            ilf = 4;

                            }
                            break;
                        case 2 :
                            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:102:24: MOD
                            {
                            match(input,MOD,FOLLOW_MOD_in_capostcondition742); 

                            ilf = 5;

                            }
                            break;
                        case 3 :
                            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:102:41: QUERY
                            {
                            match(input,QUERY,FOLLOW_QUERY_in_capostcondition748); 

                            ilf = 3;

                            }
                            break;
                        case 4 :
                            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:102:60: SHRIEK
                            {
                            match(input,SHRIEK,FOLLOW_SHRIEK_in_capostcondition754); 

                            ilf = 2;

                            }
                            break;
                        case 5 :
                            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:102:80: POINT
                            {
                            match(input,POINT,FOLLOW_POINT_in_capostcondition760); 

                            ilf = 1;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_literal_in_capostcondition767);
                    t=literal();

                    state._fsp--;


                    deeds.add(new Abstract_Deed(new Abstract_BroadcastSendAction(rs, ilf, t, st)));

                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:104:5: ( COMMA ( QUERY | SHRIEK | POINT ) t1= literal )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==COMMA) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:104:6: COMMA ( QUERY | SHRIEK | POINT ) t1= literal
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_capostcondition782); 

                    	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:104:12: ( QUERY | SHRIEK | POINT )
                    	    int alt15=3;
                    	    switch ( input.LA(1) ) {
                    	    case QUERY:
                    	        {
                    	        alt15=1;
                    	        }
                    	        break;
                    	    case SHRIEK:
                    	        {
                    	        alt15=2;
                    	        }
                    	        break;
                    	    case POINT:
                    	        {
                    	        alt15=3;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 15, 0, input);

                    	        throw nvae;

                    	    }

                    	    switch (alt15) {
                    	        case 1 :
                    	            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:104:13: QUERY
                    	            {
                    	            match(input,QUERY,FOLLOW_QUERY_in_capostcondition785); 

                    	            ilf = 3;

                    	            }
                    	            break;
                    	        case 2 :
                    	            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:104:32: SHRIEK
                    	            {
                    	            match(input,SHRIEK,FOLLOW_SHRIEK_in_capostcondition791); 

                    	            ilf = 2;

                    	            }
                    	            break;
                    	        case 3 :
                    	            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:104:52: POINT
                    	            {
                    	            match(input,POINT,FOLLOW_POINT_in_capostcondition797); 

                    	            ilf = 1;

                    	            }
                    	            break;

                    	    }


                    	    pushFollow(FOLLOW_literal_in_capostcondition804);
                    	    t1=literal();

                    	    state._fsp--;


                    	    deeds.add(new Abstract_Deed(new Abstract_BroadcastSendAction(rs, ilf, t1, st)));

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    match(input,CLOSE,FOLLOW_CLOSE_in_capostcondition818); 

                    }
                    break;
                case 8 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:107:4: CLOSEKEY OPEN s= conv_id CLOSE
                    {
                    match(input,CLOSEKEY,FOLLOW_CLOSEKEY_in_capostcondition825); 

                    match(input,OPEN,FOLLOW_OPEN_in_capostcondition827); 

                    pushFollow(FOLLOW_conv_id_in_capostcondition831);
                    s=conv_id();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_capostcondition833); 

                    Abstract_Predicate cl=new Abstract_Predicate("close"); cl.addTerm(s); deeds.add(new Abstract_Deed(new Abstract_Action(cl, 0)));

                    }
                    break;
                case 9 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:108:4: gl= capname
                    {
                    pushFollow(FOLLOW_capname_in_capostcondition844);
                    gl=capname();

                    state._fsp--;


                    deeds.add(new Abstract_Deed(Abstract_Deed.AILAddition, gl));

                    }
                    break;

            }


            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:109:4: ( COMMA capostcondition[deeds] )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==COMMA) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:109:5: COMMA capostcondition[deeds]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_capostcondition852); 

            	    pushFollow(FOLLOW_capostcondition_in_capostcondition854);
            	    capostcondition(deeds);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // $ANTLR end "capostcondition"



    // $ANTLR start "conv_id"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:111:1: conv_id returns [Abstract_StringTerm s] : (v= var | CONST );
    public final Abstract_StringTerm conv_id() throws RecognitionException {
        Abstract_StringTerm s = null;


        Token CONST1=null;
        Abstract_VarTerm v =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:111:40: (v= var | CONST )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==ANON_VAR||LA19_0==VAR) ) {
                alt19=1;
            }
            else if ( (LA19_0==CONST) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:111:42: v= var
                    {
                    pushFollow(FOLLOW_var_in_conv_id871);
                    v=var();

                    state._fsp--;


                    s = v;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:111:63: CONST
                    {
                    CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_conv_id877); 

                    s = new Abstract_StringTermImpl(CONST1.getText());

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
    // $ANTLR end "conv_id"



    // $ANTLR start "dbnumb"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:113:1: dbnumb returns [Abstract_StringTerm i] : ( CONST |v= var ) ;
    public final Abstract_StringTerm dbnumb() throws RecognitionException {
        Abstract_StringTerm i = null;


        Token CONST2=null;
        Abstract_VarTerm v =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:113:40: ( ( CONST |v= var ) )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:114:3: ( CONST |v= var )
            {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:114:3: ( CONST |v= var )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==CONST) ) {
                alt20=1;
            }
            else if ( (LA20_0==ANON_VAR||LA20_0==VAR) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:114:4: CONST
                    {
                    CONST2=(Token)match(input,CONST,FOLLOW_CONST_in_dbnumb895); 

                    i = new Abstract_StringTermImpl(CONST2.getText());

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:115:5: v= var
                    {
                    pushFollow(FOLLOW_var_in_dbnumb908);
                    v=var();

                    state._fsp--;


                    i = v;

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
    // $ANTLR end "dbnumb"



    // $ANTLR start "capname"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:117:1: capname returns [Abstract_Goal g] : l= literal ;
    public final Abstract_Goal capname() throws RecognitionException {
        Abstract_Goal g = null;


        Abstract_Literal l =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:117:35: (l= literal )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:117:37: l= literal
            {
            pushFollow(FOLLOW_literal_in_capname925);
            l=literal();

            state._fsp--;


            g = new Abstract_Goal(l, Abstract_Goal.performGoal);

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
    // $ANTLR end "capname"



    // $ANTLR start "precondition"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:121:1: precondition returns [Abstract_MentalState ms] : ( ( NOT )? ( TRUE | BELIEVE ( NUMMARKER i1= dbnumb )? l= literal | HAVEGOAL ( NUMMARKER i1= dbnumb )? g= goal[i] | IN_CONTENT NUMMARKER i1= dbnumb | IN_CONTEXT NUMMARKER i1= dbnumb ) ) ( COMMA ms1= precondition )* ;
    public final Abstract_MentalState precondition() throws RecognitionException {
        Abstract_MentalState ms = null;


        Abstract_StringTerm i1 =null;

        Abstract_Literal l =null;

        Abstract_Goal g =null;

        Abstract_MentalState ms1 =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:122:2: ( ( ( NOT )? ( TRUE | BELIEVE ( NUMMARKER i1= dbnumb )? l= literal | HAVEGOAL ( NUMMARKER i1= dbnumb )? g= goal[i] | IN_CONTENT NUMMARKER i1= dbnumb | IN_CONTEXT NUMMARKER i1= dbnumb ) ) ( COMMA ms1= precondition )* )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:122:4: ( ( NOT )? ( TRUE | BELIEVE ( NUMMARKER i1= dbnumb )? l= literal | HAVEGOAL ( NUMMARKER i1= dbnumb )? g= goal[i] | IN_CONTENT NUMMARKER i1= dbnumb | IN_CONTEXT NUMMARKER i1= dbnumb ) ) ( COMMA ms1= precondition )*
            {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:122:4: ( ( NOT )? ( TRUE | BELIEVE ( NUMMARKER i1= dbnumb )? l= literal | HAVEGOAL ( NUMMARKER i1= dbnumb )? g= goal[i] | IN_CONTENT NUMMARKER i1= dbnumb | IN_CONTEXT NUMMARKER i1= dbnumb ) )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:122:6: ( NOT )? ( TRUE | BELIEVE ( NUMMARKER i1= dbnumb )? l= literal | HAVEGOAL ( NUMMARKER i1= dbnumb )? g= goal[i] | IN_CONTENT NUMMARKER i1= dbnumb | IN_CONTEXT NUMMARKER i1= dbnumb )
            {
            boolean negflag=false;

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:122:31: ( NOT )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==NOT) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:122:32: NOT
                    {
                    match(input,NOT,FOLLOW_NOT_in_precondition947); 

                    negflag = true;

                    }
                    break;

            }


            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:123:2: ( TRUE | BELIEVE ( NUMMARKER i1= dbnumb )? l= literal | HAVEGOAL ( NUMMARKER i1= dbnumb )? g= goal[i] | IN_CONTENT NUMMARKER i1= dbnumb | IN_CONTEXT NUMMARKER i1= dbnumb )
            int alt24=5;
            switch ( input.LA(1) ) {
            case TRUE:
                {
                alt24=1;
                }
                break;
            case BELIEVE:
                {
                alt24=2;
                }
                break;
            case HAVEGOAL:
                {
                alt24=3;
                }
                break;
            case IN_CONTENT:
                {
                alt24=4;
                }
                break;
            case IN_CONTEXT:
                {
                alt24=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:123:3: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_precondition955); 

                    ms = new Abstract_MentalState(new Abstract_GBelief(Abstract_GBelief.GTrue));

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:124:2: BELIEVE ( NUMMARKER i1= dbnumb )? l= literal
                    {
                    match(input,BELIEVE,FOLLOW_BELIEVE_in_precondition962); 

                    Abstract_StringTerm i = new Abstract_StringTermImpl("");

                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:124:69: ( NUMMARKER i1= dbnumb )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==NUMMARKER) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:124:71: NUMMARKER i1= dbnumb
                            {
                            match(input,NUMMARKER,FOLLOW_NUMMARKER_in_precondition968); 

                            pushFollow(FOLLOW_dbnumb_in_precondition972);
                            i1=dbnumb();

                            state._fsp--;


                            i = i1;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_literal_in_precondition980);
                    l=literal();

                    state._fsp--;


                    ms = new Abstract_MentalState(i, new Abstract_GBelief(Abstract_GBelief.AILBel, l)); 
                    	                                  if (negflag) {ms = new Abstract_MentalState(ms);}

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:126:2: HAVEGOAL ( NUMMARKER i1= dbnumb )? g= goal[i]
                    {
                    match(input,HAVEGOAL,FOLLOW_HAVEGOAL_in_precondition988); 

                    Abstract_StringTerm i = new Abstract_StringTermImpl("");

                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:126:70: ( NUMMARKER i1= dbnumb )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==NUMMARKER) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:126:71: NUMMARKER i1= dbnumb
                            {
                            match(input,NUMMARKER,FOLLOW_NUMMARKER_in_precondition993); 

                            pushFollow(FOLLOW_dbnumb_in_precondition997);
                            i1=dbnumb();

                            state._fsp--;


                            i = i1;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_goal_in_precondition1005);
                    g=goal(i);

                    state._fsp--;


                    ms = new Abstract_MentalState(g); if (negflag) {ms = new Abstract_MentalState(ms);}

                    }
                    break;
                case 4 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:128:2: IN_CONTENT NUMMARKER i1= dbnumb
                    {
                    match(input,IN_CONTENT,FOLLOW_IN_CONTENT_in_precondition1017); 

                    match(input,NUMMARKER,FOLLOW_NUMMARKER_in_precondition1020); 

                    pushFollow(FOLLOW_dbnumb_in_precondition1024);
                    i1=dbnumb();

                    state._fsp--;


                    ms = new Abstract_MentalState(new Abstract_GBelief(Abstract_GBelief.AILContent, i1)); if (negflag) {ms = new Abstract_MentalState(ms);}

                    }
                    break;
                case 5 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:129:2: IN_CONTEXT NUMMARKER i1= dbnumb
                    {
                    match(input,IN_CONTEXT,FOLLOW_IN_CONTEXT_in_precondition1031); 

                    match(input,NUMMARKER,FOLLOW_NUMMARKER_in_precondition1034); 

                    pushFollow(FOLLOW_dbnumb_in_precondition1038);
                    i1=dbnumb();

                    state._fsp--;


                    ms = new Abstract_MentalState(new Abstract_GBelief(Abstract_GBelief.AILContext, i1)); if (negflag) {ms = new Abstract_MentalState(ms);}

                    }
                    break;

            }


            }


            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:131:2: ( COMMA ms1= precondition )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==COMMA) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:131:3: COMMA ms1= precondition
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_precondition1051); 

            	    pushFollow(FOLLOW_precondition_in_precondition1055);
            	    ms1=precondition();

            	    state._fsp--;


            	    Abstract_MentalState mstmp = ms; ms = new Abstract_MentalState(mstmp, ms1);

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
        return ms;
    }
    // $ANTLR end "precondition"



    // $ANTLR start "postcondition"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:133:1: postcondition[ArrayList<Abstract_Deed> deeds] : l= literal ( COMMA postcondition[deeds] )* ;
    public final void postcondition(ArrayList<Abstract_Deed> deeds) throws RecognitionException {
        Abstract_Literal l =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:134:2: (l= literal ( COMMA postcondition[deeds] )* )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:134:4: l= literal ( COMMA postcondition[deeds] )*
            {
            pushFollow(FOLLOW_literal_in_postcondition1071);
            l=literal();

            state._fsp--;


            boolean flag = !l.negated(); int intflag; if (flag) {intflag = 0;} else {intflag = 1;}; l.setNegated(true); 
            	                   deeds.add(0, new Abstract_Deed(intflag, Abstract_Deed.AILBel, l));

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:135:89: ( COMMA postcondition[deeds] )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==COMMA) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:135:90: COMMA postcondition[deeds]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_postcondition1076); 

            	    pushFollow(FOLLOW_postcondition_in_postcondition1078);
            	    postcondition(deeds);

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
    // $ANTLR end "postcondition"



    // $ANTLR start "environment"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:171:1: environment returns [String env] : w= classpath ;
    public final String environment() throws RecognitionException {
        String env = null;


        String w =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:171:34: (w= classpath )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:171:36: w= classpath
            {
            pushFollow(FOLLOW_classpath_in_environment1339);
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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:172:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
    public final String classpath() throws RecognitionException {
        String s = null;


        String w =null;

        String w1 =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:172:30: (w= word ( POINT w1= word )+ )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:172:32: w= word ( POINT w1= word )+
            {
            pushFollow(FOLLOW_word_in_classpath1354);
            w=word();

            state._fsp--;


            s = w;

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:172:52: ( POINT w1= word )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==POINT) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:172:53: POINT w1= word
            	    {
            	    match(input,POINT,FOLLOW_POINT_in_classpath1359); 

            	    pushFollow(FOLLOW_word_in_classpath1363);
            	    w1=word();

            	    state._fsp--;


            	    s+="."; s+=w1;

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:173:1: word returns [String s] : ( CONST | VAR ) ;
    public final String word() throws RecognitionException {
        String s = null;


        Token CONST3=null;
        Token VAR4=null;

        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:173:25: ( ( CONST | VAR ) )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:173:27: ( CONST | VAR )
            {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:173:27: ( CONST | VAR )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==CONST) ) {
                alt28=1;
            }
            else if ( (LA28_0==VAR) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }
            switch (alt28) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:173:28: CONST
                    {
                    CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_word1464); 

                    s =CONST3.getText();

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:173:59: VAR
                    {
                    VAR4=(Token)match(input,VAR,FOLLOW_VAR_in_word1470); 

                    s =VAR4.getText();

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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:175:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
    public final Abstract_StringTerm agentnameterm() throws RecognitionException {
        Abstract_StringTerm s = null;


        Token CONST5=null;
        Abstract_VarTerm v =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:175:47: ( CONST |v= var )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==CONST) ) {
                alt29=1;
            }
            else if ( (LA29_0==ANON_VAR||LA29_0==VAR) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:175:49: CONST
                    {
                    CONST5=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm1570); 

                    s = new Abstract_StringTermImpl(CONST5.getText());

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:175:111: v= var
                    {
                    pushFollow(FOLLOW_var_in_agentnameterm1578);
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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:178:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
    public final Abstract_Literal literal() throws RecognitionException {
        Abstract_Literal l = null;


        Abstract_Predicate nt =null;

        Abstract_Predicate t =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:178:37: ( ( TRUE | NOT nt= pred ) |t= pred )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==NOT||LA31_0==TRUE) ) {
                alt31=1;
            }
            else if ( (LA31_0==ANON_VAR||LA31_0==CONST||LA31_0==VAR) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }
            switch (alt31) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:178:40: ( TRUE | NOT nt= pred )
                    {
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:178:40: ( TRUE | NOT nt= pred )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==TRUE) ) {
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
                            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:178:41: TRUE
                            {
                            match(input,TRUE,FOLLOW_TRUE_in_literal1594); 

                            l = new Abstract_Literal(Abstract_Literal.LTrue);

                            }
                            break;
                        case 2 :
                            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:179:5: NOT nt= pred
                            {
                            match(input,NOT,FOLLOW_NOT_in_literal1605); 

                            pushFollow(FOLLOW_pred_in_literal1609);
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
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:183:5: t= pred
                    {
                    pushFollow(FOLLOW_pred_in_literal1623);
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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:187:1: pred returns [Abstract_Predicate t] : (v= var |f= function );
    public final Abstract_Predicate pred() throws RecognitionException {
        Abstract_Predicate t = null;


        Abstract_VarTerm v =null;

        Abstract_Predicate f =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:187:37: (v= var |f= function )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==ANON_VAR||LA32_0==VAR) ) {
                alt32=1;
            }
            else if ( (LA32_0==CONST) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;

            }
            switch (alt32) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:187:39: v= var
                    {
                    pushFollow(FOLLOW_var_in_pred1639);
                    v=var();

                    state._fsp--;


                    t = v;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:187:59: f= function
                    {
                    pushFollow(FOLLOW_function_in_pred1646);
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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:188:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
    public final Abstract_Predicate function() throws RecognitionException {
        Abstract_Predicate f = null;


        Token CONST6=null;

        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:188:40: ( CONST ( OPEN terms[$f] CLOSE )? )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:188:42: CONST ( OPEN terms[$f] CLOSE )?
            {
            CONST6=(Token)match(input,CONST,FOLLOW_CONST_in_function1658); 

            f = new Abstract_Predicate(CONST6.getText());

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:188:97: ( OPEN terms[$f] CLOSE )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==OPEN) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:188:98: OPEN terms[$f] CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_function1663); 

                    pushFollow(FOLLOW_terms_in_function1665);
                    terms(f);

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_function1668); 

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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:190:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
    public final void terms(Abstract_Predicate f) throws RecognitionException {
        Abstract_Term t =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:190:29: (t= term ( COMMA terms[$f] )? )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:190:31: t= term ( COMMA terms[$f] )?
            {
            pushFollow(FOLLOW_term_in_terms1681);
            t=term();

            state._fsp--;


            f.addTerm(t);

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:190:58: ( COMMA terms[$f] )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==COMMA) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:190:59: COMMA terms[$f]
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_terms1686); 

                    pushFollow(FOLLOW_terms_in_terms1688);
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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:191:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |f= function | AGNAME );
    public final Abstract_Term term() throws RecognitionException {
        Abstract_Term t = null;


        Abstract_NumberTerm a =null;

        Abstract_StringTerm s =null;

        Abstract_Predicate f =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:191:31: (a= atom |s= stringterm |f= function | AGNAME )
            int alt35=4;
            switch ( input.LA(1) ) {
            case ANON_VAR:
            case MINUS:
            case NUMBER:
            case OPEN:
            case VAR:
                {
                alt35=1;
                }
                break;
            case DOUBLEQUOTE:
                {
                alt35=2;
                }
                break;
            case CONST:
                {
                alt35=3;
                }
                break;
            case AGNAME:
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
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:191:34: a= atom
                    {
                    pushFollow(FOLLOW_atom_in_term1707);
                    a=atom();

                    state._fsp--;


                    t = a;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:191:58: s= stringterm
                    {
                    pushFollow(FOLLOW_stringterm_in_term1717);
                    s=stringterm();

                    state._fsp--;


                    t = s;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:191:88: f= function
                    {
                    pushFollow(FOLLOW_function_in_term1725);
                    f=function();

                    state._fsp--;


                    t = f;

                    }
                    break;
                case 4 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:191:114: AGNAME
                    {
                    match(input,AGNAME,FOLLOW_AGNAME_in_term1731); 

                    t = new Abstract_Predicate(name);

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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:193:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
    public final Abstract_NumberTerm atom() throws RecognitionException {
        Abstract_NumberTerm t = null;


        String n =null;

        Abstract_VarTerm v =null;

        Abstract_NumberTerm a =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:193:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
            int alt36=3;
            switch ( input.LA(1) ) {
            case MINUS:
            case NUMBER:
                {
                alt36=1;
                }
                break;
            case ANON_VAR:
            case VAR:
                {
                alt36=2;
                }
                break;
            case OPEN:
                {
                alt36=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }

            switch (alt36) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:193:40: n= numberstring
                    {
                    pushFollow(FOLLOW_numberstring_in_atom1749);
                    n=numberstring();

                    state._fsp--;


                    t = new Abstract_NumberTermImpl(n);

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:194:6: v= var
                    {
                    pushFollow(FOLLOW_var_in_atom1762);
                    v=var();

                    state._fsp--;


                    t = v;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:194:27: OPEN a= arithexpr CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_atom1768); 

                    pushFollow(FOLLOW_arithexpr_in_atom1772);
                    a=arithexpr();

                    state._fsp--;


                    match(input,CLOSE,FOLLOW_CLOSE_in_atom1774); 

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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:195:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
    public final Abstract_StringTerm stringterm() throws RecognitionException {
        Abstract_StringTerm s = null;


        Token STRING7=null;

        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:195:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:195:46: DOUBLEQUOTE STRING DOUBLEQUOTE
            {
            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1787); 

            STRING7=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm1790); 

            match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1792); 

            s = new Abstract_StringTermImpl(STRING7.getText());

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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:197:1: var returns [Abstract_VarTerm v] : ( VAR | ANON_VAR ) ;
    public final Abstract_VarTerm var() throws RecognitionException {
        Abstract_VarTerm v = null;


        Token VAR8=null;

        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:197:34: ( ( VAR | ANON_VAR ) )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:197:36: ( VAR | ANON_VAR )
            {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:197:36: ( VAR | ANON_VAR )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==VAR) ) {
                alt37=1;
            }
            else if ( (LA37_0==ANON_VAR) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:197:37: VAR
                    {
                    VAR8=(Token)match(input,VAR,FOLLOW_VAR_in_var1807); 


                    	if (variables.containsKey(VAR8.getText())) {
                    		v = variables.get(VAR8.getText());
                    		} else {
                    		v = new Abstract_VarTerm(VAR8.getText());
                    		variables.put(VAR8.getText(), v);
                    		}
                    	

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:204:6: ANON_VAR
                    {
                    match(input,ANON_VAR,FOLLOW_ANON_VAR_in_var1813); 

                    v = new Abstract_UnnamedVar();

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
        return v;
    }
    // $ANTLR end "var"



    // $ANTLR start "numberstring"
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:206:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
    public final String numberstring() throws RecognitionException {
        String s = null;


        Token n1=null;
        Token n2=null;

        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:206:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:206:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
            {
            s = "";

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:206:46: ( MINUS )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==MINUS) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:206:47: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_numberstring1831); 

                    s += "-";

                    }
                    break;

            }


            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:206:68: (n1= NUMBER ( POINT n2= NUMBER )? )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:206:69: n1= NUMBER ( POINT n2= NUMBER )?
            {
            n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1840); 

            s += n1.getText();

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:207:6: ( POINT n2= NUMBER )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==POINT) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:207:7: POINT n2= NUMBER
                    {
                    match(input,POINT,FOLLOW_POINT_in_numberstring1850); 

                    s += ".";

                    n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1856); 

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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:208:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
    public final Abstract_Equation equation() throws RecognitionException {
        Abstract_Equation eq = null;


        Abstract_NumberTerm a1 =null;

        int oper =0;

        Abstract_NumberTerm a2 =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:208:40: (a1= arithexpr oper= eqoper a2= arithexpr )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:208:42: a1= arithexpr oper= eqoper a2= arithexpr
            {
            pushFollow(FOLLOW_arithexpr_in_equation1873);
            a1=arithexpr();

            state._fsp--;


            pushFollow(FOLLOW_eqoper_in_equation1877);
            oper=eqoper();

            state._fsp--;


            pushFollow(FOLLOW_arithexpr_in_equation1881);
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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:209:1: eqoper returns [int oper] : ( LESS | EQ );
    public final int eqoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:209:27: ( LESS | EQ )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==LESS) ) {
                alt40=1;
            }
            else if ( (LA40_0==EQ) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }
            switch (alt40) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:209:29: LESS
                    {
                    match(input,LESS,FOLLOW_LESS_in_eqoper1895); 

                    oper =Abstract_Equation.less;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:209:68: EQ
                    {
                    match(input,EQ,FOLLOW_EQ_in_eqoper1901); 

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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:211:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
    public final Abstract_NumberTerm arithexpr() throws RecognitionException {
        Abstract_NumberTerm t = null;


        Abstract_NumberTerm m =null;

        int oper =0;

        Abstract_NumberTerm m1 =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:211:43: (m= multexpr (oper= addoper m1= multexpr )? )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:211:45: m= multexpr (oper= addoper m1= multexpr )?
            {
            pushFollow(FOLLOW_multexpr_in_arithexpr1917);
            m=multexpr();

            state._fsp--;


            t = m;

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:211:69: (oper= addoper m1= multexpr )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==MINUS||LA41_0==PLUS) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:211:71: oper= addoper m1= multexpr
                    {
                    pushFollow(FOLLOW_addoper_in_arithexpr1925);
                    oper=addoper();

                    state._fsp--;


                    pushFollow(FOLLOW_multexpr_in_arithexpr1929);
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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:212:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
    public final Abstract_NumberTerm multexpr() throws RecognitionException {
        Abstract_NumberTerm t = null;


        Abstract_NumberTerm a =null;

        int oper =0;

        Abstract_NumberTerm a1 =null;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:212:42: (a= atom (oper= multoper a1= atom )? )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:212:44: a= atom (oper= multoper a1= atom )?
            {
            pushFollow(FOLLOW_atom_in_multexpr1946);
            a=atom();

            state._fsp--;


            t = a;

            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:212:64: (oper= multoper a1= atom )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==DIV||(LA42_0 >= MOD && LA42_0 <= MULT)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:212:65: oper= multoper a1= atom
                    {
                    pushFollow(FOLLOW_multoper_in_multexpr1953);
                    oper=multoper();

                    state._fsp--;


                    pushFollow(FOLLOW_atom_in_multexpr1957);
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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:214:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
    public final int addoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:214:28: ( ( PLUS | MINUS ) )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:214:30: ( PLUS | MINUS )
            {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:214:30: ( PLUS | MINUS )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==PLUS) ) {
                alt43=1;
            }
            else if ( (LA43_0==MINUS) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }
            switch (alt43) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:214:31: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_addoper1974); 

                    oper =Abstract_ArithExpr.plus;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:214:70: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_addoper1979); 

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
    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:215:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
    public final int multoper() throws RecognitionException {
        int oper = 0;


        try {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:215:29: ( ( MULT | DIV | MOD ) )
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:215:31: ( MULT | DIV | MOD )
            {
            // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:215:31: ( MULT | DIV | MOD )
            int alt44=3;
            switch ( input.LA(1) ) {
            case MULT:
                {
                alt44=1;
                }
                break;
            case DIV:
                {
                alt44=2;
                }
                break;
            case MOD:
                {
                alt44=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }

            switch (alt44) {
                case 1 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:215:32: MULT
                    {
                    match(input,MULT,FOLLOW_MULT_in_multoper1994); 

                    oper =Abstract_ArithExpr.times;

                    }
                    break;
                case 2 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:215:73: DIV
                    {
                    match(input,DIV,FOLLOW_DIV_in_multoper2000); 

                    oper =Abstract_ArithExpr.div;

                    }
                    break;
                case 3 :
                    // /Users/lad/Eclipse/ajpf/src/classes/goal/parser/GOAL.g:215:111: MOD
                    {
                    match(input,MOD,FOLLOW_MOD_in_multoper2006); 

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


 

    public static final BitSet FOLLOW_goalagents_in_mas76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GOAL_in_goalagents88 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_goalagent_in_goalagents97 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_literal_in_brule285 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_BRULEARROW_in_brule287 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_fmla_in_brule291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_fmla311 = new BitSet(new long[]{0x0004000000010002L});
    public static final BitSet FOLLOW_COMMA_in_fmla318 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_fmla_in_fmla322 = new BitSet(new long[]{0x0004000000010002L});
    public static final BitSet FOLLOW_SEMI_in_fmla332 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_fmla_in_fmla336 = new BitSet(new long[]{0x0004000000010002L});
    public static final BitSet FOLLOW_NAME_in_goalagent354 = new BitSet(new long[]{0x0400000000080000L});
    public static final BitSet FOLLOW_word_in_goalagent358 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_BELIEFS_in_goalagent367 = new BitSet(new long[]{0x0600080000080880L});
    public static final BitSet FOLLOW_literal_in_goalagent372 = new BitSet(new long[]{0x0600080000080880L});
    public static final BitSet FOLLOW_BRULES_in_goalagent379 = new BitSet(new long[]{0x0600080040080080L});
    public static final BitSet FOLLOW_brule_in_goalagent384 = new BitSet(new long[]{0x0600080040080080L});
    public static final BitSet FOLLOW_GOALS_in_goalagent391 = new BitSet(new long[]{0x06000800000C0080L});
    public static final BitSet FOLLOW_literal_in_goalagent398 = new BitSet(new long[]{0x06000800000C0080L});
    public static final BitSet FOLLOW_CONDACTIONS_in_goalagent405 = new BitSet(new long[]{0x0000000100001000L});
    public static final BitSet FOLLOW_condaction_in_goalagent410 = new BitSet(new long[]{0x0000000100001000L});
    public static final BitSet FOLLOW_CAPABILITIES_in_goalagent417 = new BitSet(new long[]{0x0600080000080082L});
    public static final BitSet FOLLOW_capability_in_goalagent422 = new BitSet(new long[]{0x0600080000080082L});
    public static final BitSet FOLLOW_literal_in_goal443 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_AND_in_goal450 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_literal_in_goal454 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_capname_in_capability477 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_capability484 = new BitSet(new long[]{0x0200080C80000200L});
    public static final BitSet FOLLOW_precondition_in_capability490 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_capability492 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CURLYOPEN_in_capability496 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_postcondition_in_capability498 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_CURLYCLOSE_in_capability501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_condaction517 = new BitSet(new long[]{0x0200080C80000200L});
    public static final BitSet FOLLOW_precondition_in_condaction521 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_THEN_in_condaction523 = new BitSet(new long[]{0x0608080209384090L});
    public static final BitSet FOLLOW_capostcondition_in_condaction529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INS_in_capostcondition548 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_OPEN_in_capostcondition550 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_dbnumb_in_capostcondition555 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_capostcondition557 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_literal_in_capostcondition565 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CLOSE_in_capostcondition567 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_DEL_in_capostcondition576 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_OPEN_in_capostcondition579 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_dbnumb_in_capostcondition584 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_capostcondition586 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_literal_in_capostcondition594 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CLOSE_in_capostcondition596 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ADOPT_in_capostcondition605 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_OPEN_in_capostcondition608 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_dbnumb_in_capostcondition613 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_capostcondition615 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_goal_in_capostcondition623 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CLOSE_in_capostcondition626 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_DROP_in_capostcondition635 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_OPEN_in_capostcondition638 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_dbnumb_in_capostcondition643 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_capostcondition645 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_goal_in_capostcondition653 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CLOSE_in_capostcondition656 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_CONTENT_in_capostcondition665 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_OPEN_in_capostcondition667 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_literal_in_capostcondition671 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CLOSE_in_capostcondition673 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_CONTEXT_in_capostcondition682 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_OPEN_in_capostcondition684 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_literal_in_capostcondition688 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CLOSE_in_capostcondition690 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_SEND_in_capostcondition699 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_OPEN_in_capostcondition701 = new BitSet(new long[]{0x0400000000080080L});
    public static final BitSet FOLLOW_conv_id_in_capostcondition705 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_capostcondition707 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_SQOPEN_in_capostcondition716 = new BitSet(new long[]{0x0400000000080080L});
    public static final BitSet FOLLOW_dbnumb_in_capostcondition721 = new BitSet(new long[]{0x0420000000080080L});
    public static final BitSet FOLLOW_SQCLOSE_in_capostcondition727 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_capostcondition729 = new BitSet(new long[]{0x0013018000000000L});
    public static final BitSet FOLLOW_MULT_in_capostcondition736 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_MOD_in_capostcondition742 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_QUERY_in_capostcondition748 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_SHRIEK_in_capostcondition754 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_POINT_in_capostcondition760 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_literal_in_capostcondition767 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COMMA_in_capostcondition782 = new BitSet(new long[]{0x0013000000000000L});
    public static final BitSet FOLLOW_QUERY_in_capostcondition785 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_SHRIEK_in_capostcondition791 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_POINT_in_capostcondition797 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_literal_in_capostcondition804 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_CLOSE_in_capostcondition818 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_CLOSEKEY_in_capostcondition825 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_OPEN_in_capostcondition827 = new BitSet(new long[]{0x0400000000080080L});
    public static final BitSet FOLLOW_conv_id_in_capostcondition831 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CLOSE_in_capostcondition833 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_capname_in_capostcondition844 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_COMMA_in_capostcondition852 = new BitSet(new long[]{0x0608080209384090L});
    public static final BitSet FOLLOW_capostcondition_in_capostcondition854 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_var_in_conv_id871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_conv_id877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_dbnumb895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_dbnumb908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_capname925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_precondition947 = new BitSet(new long[]{0x0200000C80000200L});
    public static final BitSet FOLLOW_TRUE_in_precondition955 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_BELIEVE_in_precondition962 = new BitSet(new long[]{0x0600280000080080L});
    public static final BitSet FOLLOW_NUMMARKER_in_precondition968 = new BitSet(new long[]{0x0400000000080080L});
    public static final BitSet FOLLOW_dbnumb_in_precondition972 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_literal_in_precondition980 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_HAVEGOAL_in_precondition988 = new BitSet(new long[]{0x0600280000080080L});
    public static final BitSet FOLLOW_NUMMARKER_in_precondition993 = new BitSet(new long[]{0x0400000000080080L});
    public static final BitSet FOLLOW_dbnumb_in_precondition997 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_goal_in_precondition1005 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_IN_CONTENT_in_precondition1017 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_NUMMARKER_in_precondition1020 = new BitSet(new long[]{0x0400000000080080L});
    public static final BitSet FOLLOW_dbnumb_in_precondition1024 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_IN_CONTEXT_in_precondition1031 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_NUMMARKER_in_precondition1034 = new BitSet(new long[]{0x0400000000080080L});
    public static final BitSet FOLLOW_dbnumb_in_precondition1038 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_COMMA_in_precondition1051 = new BitSet(new long[]{0x0200080C80000200L});
    public static final BitSet FOLLOW_precondition_in_precondition1055 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_literal_in_postcondition1071 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_COMMA_in_postcondition1076 = new BitSet(new long[]{0x0600080000080080L});
    public static final BitSet FOLLOW_postcondition_in_postcondition1078 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_classpath_in_environment1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_word_in_classpath1354 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_POINT_in_classpath1359 = new BitSet(new long[]{0x0400000000080000L});
    public static final BitSet FOLLOW_word_in_classpath1363 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_CONST_in_word1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_word1470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_agentnameterm1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_agentnameterm1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_literal1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_literal1605 = new BitSet(new long[]{0x0400000000080080L});
    public static final BitSet FOLLOW_pred_in_literal1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pred_in_literal1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_pred1639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_pred1646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_function1658 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_OPEN_in_function1663 = new BitSet(new long[]{0x04005040040800A0L});
    public static final BitSet FOLLOW_terms_in_function1665 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CLOSE_in_function1668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_terms1681 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_COMMA_in_terms1686 = new BitSet(new long[]{0x04005040040800A0L});
    public static final BitSet FOLLOW_terms_in_terms1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_term1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringterm_in_term1717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_term1725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AGNAME_in_term1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numberstring_in_atom1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_atom1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_atom1768 = new BitSet(new long[]{0x0400504000000080L});
    public static final BitSet FOLLOW_arithexpr_in_atom1772 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CLOSE_in_atom1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1787 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_STRING_in_stringterm1790 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_var1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANON_VAR_in_var1813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_numberstring1831 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring1840 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_POINT_in_numberstring1850 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_NUMBER_in_numberstring1856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithexpr_in_equation1873 = new BitSet(new long[]{0x0000001010000000L});
    public static final BitSet FOLLOW_eqoper_in_equation1877 = new BitSet(new long[]{0x0400504000000080L});
    public static final BitSet FOLLOW_arithexpr_in_equation1881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_in_eqoper1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_eqoper1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr1917 = new BitSet(new long[]{0x0000804000000002L});
    public static final BitSet FOLLOW_addoper_in_arithexpr1925 = new BitSet(new long[]{0x0400504000000080L});
    public static final BitSet FOLLOW_multexpr_in_arithexpr1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_multexpr1946 = new BitSet(new long[]{0x0000018002000002L});
    public static final BitSet FOLLOW_multoper_in_multexpr1953 = new BitSet(new long[]{0x0400504000000080L});
    public static final BitSet FOLLOW_atom_in_multexpr1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_addoper1974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_addoper1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULT_in_multoper1994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_multoper2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOD_in_multoper2006 = new BitSet(new long[]{0x0000000000000002L});

}