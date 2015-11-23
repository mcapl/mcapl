// $ANTLR 3.5.1 /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g 2015-10-19 16:00:58

package gwendolen.parser;

import ail.syntax.ast.*;
import gwendolen.syntax.ast.*;
import java.util.HashMap;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class GwendolenParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACHIEVE", "ACHIEVEGOAL", "ADD_CONSTRAINT", 
		"ADD_CONTENT", "ADD_CONTEXT", "ADD_PLAN", "BAR", "BELIEFRULES", "BELIEFS", 
		"BELIEVE", "BRULEARROW", "CLOSE", "COLON", "COMMA", "COMMENT", "CONST", 
		"CONSTRAINT", "CURLYCLOSE", "CURLYOPEN", "DIV", "DOUBLEQUOTE", "EQ", "GOAL", 
		"GOALS", "GWENDOLEN", "IN_CONTENT", "IN_CONTEXT", "LESS", "LINE_COMMENT", 
		"LOCK", "MINUS", "MOD", "MULT", "NAME", "NEWLINE", "NOT", "NUMBER", "OPEN", 
		"PERFORM", "PERFORMGOAL", "PLANS", "PLUS", "POINT", "QUERY", "RECEIVED", 
		"RULEARROW", "SEMI", "SEND", "SENT", "SHRIEK", "SQCLOSE", "SQOPEN", "STRING", 
		"TELL", "TELLHOW", "TRUE", "UNNAMEDVAR", "VAR", "WS"
	};
	public static final int EOF=-1;
	public static final int ACHIEVE=4;
	public static final int ACHIEVEGOAL=5;
	public static final int ADD_CONSTRAINT=6;
	public static final int ADD_CONTENT=7;
	public static final int ADD_CONTEXT=8;
	public static final int ADD_PLAN=9;
	public static final int BAR=10;
	public static final int BELIEFRULES=11;
	public static final int BELIEFS=12;
	public static final int BELIEVE=13;
	public static final int BRULEARROW=14;
	public static final int CLOSE=15;
	public static final int COLON=16;
	public static final int COMMA=17;
	public static final int COMMENT=18;
	public static final int CONST=19;
	public static final int CONSTRAINT=20;
	public static final int CURLYCLOSE=21;
	public static final int CURLYOPEN=22;
	public static final int DIV=23;
	public static final int DOUBLEQUOTE=24;
	public static final int EQ=25;
	public static final int GOAL=26;
	public static final int GOALS=27;
	public static final int GWENDOLEN=28;
	public static final int IN_CONTENT=29;
	public static final int IN_CONTEXT=30;
	public static final int LESS=31;
	public static final int LINE_COMMENT=32;
	public static final int LOCK=33;
	public static final int MINUS=34;
	public static final int MOD=35;
	public static final int MULT=36;
	public static final int NAME=37;
	public static final int NEWLINE=38;
	public static final int NOT=39;
	public static final int NUMBER=40;
	public static final int OPEN=41;
	public static final int PERFORM=42;
	public static final int PERFORMGOAL=43;
	public static final int PLANS=44;
	public static final int PLUS=45;
	public static final int POINT=46;
	public static final int QUERY=47;
	public static final int RECEIVED=48;
	public static final int RULEARROW=49;
	public static final int SEMI=50;
	public static final int SEND=51;
	public static final int SENT=52;
	public static final int SHRIEK=53;
	public static final int SQCLOSE=54;
	public static final int SQOPEN=55;
	public static final int STRING=56;
	public static final int TELL=57;
	public static final int TELLHOW=58;
	public static final int TRUE=59;
	public static final int UNNAMEDVAR=60;
	public static final int VAR=61;
	public static final int WS=62;

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

	@Override public String[] getTokenNames() { return GwendolenParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g"; }


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
			while (true) {
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
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
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
			while (true) {
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
			}

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
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==CONST||(LA4_0 >= UNNAMEDVAR && LA4_0 <= VAR)) ) {
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
					}

					}
					break;

			}

			match(input,GOALS,FOLLOW_GOALS_in_gwendolenagent182); 
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:72:8: (gl= goal )*
			loop6:
			while (true) {
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
			}

			match(input,PLANS,FOLLOW_PLANS_in_gwendolenagent194); 
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:73:8: (p= plan )*
			loop7:
			while (true) {
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
	// $ANTLR end "gwendolenagent"



	// $ANTLR start "guard_atom"
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:1: guard_atom returns [Abstract_GLogicalFormula g] : ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE ) ;
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:49: ( ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:76:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE )
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
			case UNNAMEDVAR:
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:78:5: SENT OPEN (s= agentnameterm ) COMMA (an2= agentnameterm COMMA )? p= performative COMMA t= pred CLOSE
					{
					match(input,SENT,FOLLOW_SENT_in_guard_atom246); 
					match(input,OPEN,FOLLOW_OPEN_in_guard_atom248); 
					Abstract_StringTerm an1=agentname;
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:78:52: (s= agentnameterm )
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:78:53: s= agentnameterm
					{
					pushFollow(FOLLOW_agentnameterm_in_guard_atom255);
					s=agentnameterm();
					state._fsp--;

					an1 = s;
					}

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom289); 
					Abstract_StringTerm agn = agentname;
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:79:74: (an2= agentnameterm COMMA )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==CONST||(LA8_0 >= UNNAMEDVAR && LA8_0 <= VAR)) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:79:75: an2= agentnameterm COMMA
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:82:5: eq= equation
					{
					pushFollow(FOLLOW_equation_in_guard_atom340);
					eq=equation();
					state._fsp--;

					g = eq;
					}
					break;
				case 5 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:83:5: TRUE
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:1: goal returns [Abstract_Goal g] : l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE ;
	public final Abstract_Goal goal() throws RecognitionException {
		Abstract_Goal g = null;


		Abstract_Literal l =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:32: (l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:34: l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE
			{
			pushFollow(FOLLOW_literal_in_goal384);
			l=literal();
			state._fsp--;

			match(input,SQOPEN,FOLLOW_SQOPEN_in_goal386); 
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:51: ( ACHIEVEGOAL | PERFORMGOAL )
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:97:52: ACHIEVEGOAL
					{
					match(input,ACHIEVEGOAL,FOLLOW_ACHIEVEGOAL_in_goal389); 
					g = new Abstract_Goal(l, Abstract_Goal.achieveGoal);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:98:4: PERFORMGOAL
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:99:1: plan returns [Abstract_GPlan p] : e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI ;
	public final Abstract_GPlan plan() throws RecognitionException {
		Abstract_GPlan p = null;


		Abstract_Event e =null;
		Abstract_GLogicalFormula gb =null;
		Abstract_Deed d =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:100:2: (e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:100:4: e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed ( COMMA d= deed )* )? SEMI
			{
			pushFollow(FOLLOW_event_in_plan418);
			e=event();
			state._fsp--;

			ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();
			match(input,COLON,FOLLOW_COLON_in_plan426); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_plan428); 
			boolean gneg=true;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:101:40: ( NOT )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==NOT) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:101:41: NOT
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
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:3: ( COMMA ( NOT )? gb= guard_atom )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==COMMA) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:4: COMMA ( NOT )? gb= guard_atom
					{
					match(input,COMMA,FOLLOW_COMMA_in_plan449); 
					gneg=true;
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:23: ( NOT )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==NOT) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:24: NOT
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
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_plan468); 
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:93: ( RULEARROW d= deed ( COMMA d= deed )* )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==RULEARROW) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:102:94: RULEARROW d= deed ( COMMA d= deed )*
					{
					match(input,RULEARROW,FOLLOW_RULEARROW_in_plan471); 
					pushFollow(FOLLOW_deed_in_plan476);
					d=deed();
					state._fsp--;

					deeds.add(d);
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:103:28: ( COMMA d= deed )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==COMMA) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:103:29: COMMA d= deed
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
					}

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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:1: event returns [Abstract_Event e] : ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) ) ;
	public final Abstract_Event event() throws RecognitionException {
		Abstract_Event e = null;


		int p =0;
		Abstract_Predicate t =null;
		Abstract_Literal l =null;
		Abstract_Goal g =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:34: ( ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:36: ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:36: ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal ) )
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:37: PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
					{
					match(input,PLUS,FOLLOW_PLUS_in_event511); 
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:42: ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
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
					case UNNAMEDVAR:
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
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:106:43: RECEIVED OPEN p= performative COMMA t= pred CLOSE
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
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:111:5: (l= literal | SHRIEK g= goal )
							{
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:111:5: (l= literal | SHRIEK g= goal )
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
									// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:111:6: l= literal
									{
									pushFollow(FOLLOW_literal_in_event546);
									l=literal();
									state._fsp--;

									e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, l);
									}
									break;
								case 2 :
									// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:112:5: SHRIEK g= goal
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
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:113:5: ADD_CONTENT l= literal
							{
							match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_event571); 
							pushFollow(FOLLOW_literal_in_event575);
							l=literal();
							state._fsp--;

							e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContent, l);
							}
							break;
						case 4 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:114:5: ADD_CONTEXT l= literal
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:116:7: MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
					{
					match(input,MINUS,FOLLOW_MINUS_in_event607); 
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:116:13: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal )
					int alt18=4;
					switch ( input.LA(1) ) {
					case CONST:
					case NOT:
					case TRUE:
					case UNNAMEDVAR:
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
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:116:14: l= literal
							{
							pushFollow(FOLLOW_literal_in_event612);
							l=literal();
							state._fsp--;

							e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, l);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:117:5: SHRIEK g= goal
							{
							match(input,SHRIEK,FOLLOW_SHRIEK_in_event622); 
							pushFollow(FOLLOW_goal_in_event626);
							g=goal();
							state._fsp--;

							e = new Abstract_Event(Abstract_Event.AILDeletion, g);
							}
							break;
						case 3 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:118:5: ADD_CONTENT l= literal
							{
							match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_event636); 
							pushFollow(FOLLOW_literal_in_event640);
							l=literal();
							state._fsp--;

							e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContent, l);
							}
							break;
						case 4 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:119:5: ADD_CONTEXT l= literal
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:1: performative returns [int b] : ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT ) ;
	public final int performative() throws RecognitionException {
		int b = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:30: ( ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:32: ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:32: ( TELL | PERFORM | ACHIEVE | TELLHOW | CONSTRAINT )
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:33: TELL
					{
					match(input,TELL,FOLLOW_TELL_in_performative676); 
					b =1;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:48: PERFORM
					{
					match(input,PERFORM,FOLLOW_PERFORM_in_performative682); 
					b =2;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:66: ACHIEVE
					{
					match(input,ACHIEVE,FOLLOW_ACHIEVE_in_performative688); 
					b = 3;
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:86: TELLHOW
					{
					match(input,TELLHOW,FOLLOW_TELLHOW_in_performative694); 
					b = 4;
					}
					break;
				case 5 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:122:106: CONSTRAINT
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:1: deed returns [Abstract_Deed d] : ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor ) ;
	public final Abstract_Deed deed() throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Literal l =null;
		Abstract_Goal g =null;
		Abstract_Literal p =null;
		Abstract_Literal c =null;
		Abstract_Action a =null;
		Abstract_Literal wf =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:32: ( ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:34: ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:34: ( ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action ) |wf= waitfor )
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==CONST||LA25_0==MINUS||LA25_0==PLUS||LA25_0==SEND||(LA25_0 >= UNNAMEDVAR && LA25_0 <= VAR)) ) {
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:35: ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action )
					{
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:35: ( ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) ) |a= action )
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==MINUS||LA24_0==PLUS) ) {
						alt24=1;
					}
					else if ( (LA24_0==CONST||LA24_0==SEND||(LA24_0 >= UNNAMEDVAR && LA24_0 <= VAR)) ) {
						alt24=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 24, 0, input);
						throw nvae;
					}

					switch (alt24) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:36: ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) )
							{
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:36: ( PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK ) )
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
									// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:37: PLUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK )
									{
									match(input,PLUS,FOLLOW_PLUS_in_deed726); 
									// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:42: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | ADD_PLAN p= literal | ADD_CONSTRAINT c= literal | LOCK )
									int alt21=7;
									switch ( input.LA(1) ) {
									case CONST:
									case NOT:
									case TRUE:
									case UNNAMEDVAR:
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
											// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:124:43: l= literal
											{
											pushFollow(FOLLOW_literal_in_deed731);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, l);
											}
											break;
										case 2 :
											// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:125:5: SHRIEK g= goal
											{
											match(input,SHRIEK,FOLLOW_SHRIEK_in_deed741); 
											pushFollow(FOLLOW_goal_in_deed745);
											g=goal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, g);
											}
											break;
										case 3 :
											// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:126:5: ADD_CONTENT l= literal
											{
											match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_deed755); 
											pushFollow(FOLLOW_literal_in_deed759);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContent, l);
											}
											break;
										case 4 :
											// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:127:5: ADD_CONTEXT l= literal
											{
											match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_deed769); 
											pushFollow(FOLLOW_literal_in_deed773);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContext, l);
											}
											break;
										case 5 :
											// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:128:5: ADD_PLAN p= literal
											{
											match(input,ADD_PLAN,FOLLOW_ADD_PLAN_in_deed783); 
											pushFollow(FOLLOW_literal_in_deed787);
											p=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILPlan, p);
											}
											break;
										case 6 :
											// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:129:5: ADD_CONSTRAINT c= literal
											{
											match(input,ADD_CONSTRAINT,FOLLOW_ADD_CONSTRAINT_in_deed797); 
											pushFollow(FOLLOW_literal_in_deed801);
											c=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILConstraint, c);
											}
											break;
										case 7 :
											// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:130:5: LOCK
											{
											match(input,LOCK,FOLLOW_LOCK_in_deed811); 
											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);
											}
											break;

									}

									}
									break;
								case 2 :
									// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:131:7: MINUS (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK )
									{
									match(input,MINUS,FOLLOW_MINUS_in_deed824); 
									// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:131:13: (l= literal | SHRIEK g= goal | ADD_CONTENT l= literal | ADD_CONTEXT l= literal | LOCK )
									int alt22=5;
									switch ( input.LA(1) ) {
									case CONST:
									case NOT:
									case TRUE:
									case UNNAMEDVAR:
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
											// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:131:14: l= literal
											{
											pushFollow(FOLLOW_literal_in_deed829);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, l);
											}
											break;
										case 2 :
											// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:132:5: SHRIEK g= goal
											{
											match(input,SHRIEK,FOLLOW_SHRIEK_in_deed839); 
											pushFollow(FOLLOW_goal_in_deed843);
											g=goal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILDeletion, g);
											}
											break;
										case 3 :
											// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:133:5: ADD_CONTENT l= literal
											{
											match(input,ADD_CONTENT,FOLLOW_ADD_CONTENT_in_deed853); 
											pushFollow(FOLLOW_literal_in_deed857);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContent, l);
											}
											break;
										case 4 :
											// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:134:5: ADD_CONTEXT l= literal
											{
											match(input,ADD_CONTEXT,FOLLOW_ADD_CONTEXT_in_deed867); 
											pushFollow(FOLLOW_literal_in_deed871);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContext, l);
											}
											break;
										case 5 :
											// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:135:5: LOCK
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
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:137:5: a= action
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:138:5: wf= waitfor
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:1: brule returns [Abstract_Rule r] : head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) ;
	public final Abstract_Rule brule() throws RecognitionException {
		Abstract_Rule r = null;


		Abstract_Predicate head =null;
		Abstract_LogicalFormula f =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:33: (head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:35: head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI )
			{
			pushFollow(FOLLOW_pred_in_brule948);
			head=pred();
			state._fsp--;

			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:45: ( BRULEARROW f= logicalfmla SEMI | SEMI )
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:46: BRULEARROW f= logicalfmla SEMI
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:145:116: SEMI
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:147:1: logicalfmla returns [Abstract_LogicalFormula f] : n= notfmla ( COMMA n2= notfmla )* ;
	public final Abstract_LogicalFormula logicalfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula n =null;
		Abstract_LogicalFormula n2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:147:49: (n= notfmla ( COMMA n2= notfmla )* )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:147:51: n= notfmla ( COMMA n2= notfmla )*
			{
			pushFollow(FOLLOW_notfmla_in_logicalfmla980);
			n=notfmla();
			state._fsp--;

			f = n;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:148:16: ( COMMA n2= notfmla )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==COMMA) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:148:17: COMMA n2= notfmla
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
	// $ANTLR end "logicalfmla"



	// $ANTLR start "notfmla"
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:1: notfmla returns [Abstract_LogicalFormula f] : ( (gb= pred | SQOPEN eq= equation SQCLOSE ) | NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla ) );
	public final Abstract_LogicalFormula notfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_Predicate gb =null;
		Abstract_Equation eq =null;
		Abstract_Predicate gb2 =null;
		Abstract_LogicalFormula lf =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:45: ( (gb= pred | SQOPEN eq= equation SQCLOSE ) | NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla ) )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==CONST||LA30_0==SQOPEN||(LA30_0 >= UNNAMEDVAR && LA30_0 <= VAR)) ) {
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:47: (gb= pred | SQOPEN eq= equation SQCLOSE )
					{
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:47: (gb= pred | SQOPEN eq= equation SQCLOSE )
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0==CONST||(LA28_0 >= UNNAMEDVAR && LA28_0 <= VAR)) ) {
						alt28=1;
					}
					else if ( (LA28_0==SQOPEN) ) {
						alt28=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 28, 0, input);
						throw nvae;
					}

					switch (alt28) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:48: gb= pred
							{
							pushFollow(FOLLOW_pred_in_notfmla1040);
							gb=pred();
							state._fsp--;

							f = gb;
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:150:71: SQOPEN eq= equation SQCLOSE
							{
							match(input,SQOPEN,FOLLOW_SQOPEN_in_notfmla1046); 
							pushFollow(FOLLOW_equation_in_notfmla1052);
							eq=equation();
							state._fsp--;

							f = eq;
							match(input,SQCLOSE,FOLLOW_SQCLOSE_in_notfmla1056); 
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:151:79: NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla )
					{
					match(input,NOT,FOLLOW_NOT_in_notfmla1140); 
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:151:83: (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla )
					int alt29=3;
					switch ( input.LA(1) ) {
					case CONST:
					case UNNAMEDVAR:
					case VAR:
						{
						alt29=1;
						}
						break;
					case SQOPEN:
						{
						alt29=2;
						}
						break;
					case OPEN:
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
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:151:84: gb2= pred
							{
							pushFollow(FOLLOW_pred_in_notfmla1147);
							gb2=pred();
							state._fsp--;

							f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:152:81: SQOPEN eq= equation SQCLOSE
							{
							match(input,SQOPEN,FOLLOW_SQOPEN_in_notfmla1234); 
							pushFollow(FOLLOW_equation_in_notfmla1240);
							eq=equation();
							state._fsp--;

							match(input,SQCLOSE,FOLLOW_SQCLOSE_in_notfmla1242); 
							f = new Abstract_LogExpr(Abstract_LogExpr.not, eq);
							}
							break;
						case 3 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:153:80: lf= subfmla
							{
							pushFollow(FOLLOW_subfmla_in_notfmla1331);
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:154:1: subfmla returns [Abstract_LogicalFormula f] : OPEN lf= logicalfmla CLOSE ;
	public final Abstract_LogicalFormula subfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula lf =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:154:45: ( OPEN lf= logicalfmla CLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:154:47: OPEN lf= logicalfmla CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_subfmla1345); 
			pushFollow(FOLLOW_logicalfmla_in_subfmla1351);
			lf=logicalfmla();
			state._fsp--;

			f = lf;
			match(input,CLOSE,FOLLOW_CLOSE_in_subfmla1355); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:157:1: waitfor returns [Abstract_Literal wf] : MULT l= literal ;
	public final Abstract_Literal waitfor() throws RecognitionException {
		Abstract_Literal wf = null;


		Abstract_Literal l =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:157:39: ( MULT l= literal )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:157:42: MULT l= literal
			{
			match(input,MULT,FOLLOW_MULT_in_waitfor1370); 
			pushFollow(FOLLOW_literal_in_waitfor1374);
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:159:1: action returns [Abstract_Action a] : ( ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred );
	public final Abstract_Action action() throws RecognitionException {
		Abstract_Action a = null;


		Abstract_Literal an =null;
		int p =0;
		Abstract_Predicate t =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:159:36: ( ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred )
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==SEND) ) {
				alt31=1;
			}
			else if ( (LA31_0==CONST||(LA31_0 >= UNNAMEDVAR && LA31_0 <= VAR)) ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:160:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
					{
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:160:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:160:3: SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE
					{
					match(input,SEND,FOLLOW_SEND_in_action1391); 
					match(input,OPEN,FOLLOW_OPEN_in_action1393); 
					pushFollow(FOLLOW_literal_in_action1397);
					an=literal();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_action1399); 
					pushFollow(FOLLOW_performative_in_action1403);
					p=performative();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_action1405); 
					pushFollow(FOLLOW_pred_in_action1409);
					t=pred();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_action1411); 
					a = new Abstract_SendAction(an, p, t);
					}

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:161:2: t= pred
					{
					pushFollow(FOLLOW_pred_in_action1422);
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:1: environment returns [String env] : w= classpath ;
	public final String environment() throws RecognitionException {
		String env = null;


		String w =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:34: (w= classpath )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:203:36: w= classpath
			{
			pushFollow(FOLLOW_classpath_in_environment1702);
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:204:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
	public final String classpath() throws RecognitionException {
		String s = null;


		String w =null;
		String w1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:204:30: (w= word ( POINT w1= word )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:204:32: w= word ( POINT w1= word )+
			{
			pushFollow(FOLLOW_word_in_classpath1717);
			w=word();
			state._fsp--;

			s = w;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:204:52: ( POINT w1= word )+
			int cnt32=0;
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==POINT) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:204:53: POINT w1= word
					{
					match(input,POINT,FOLLOW_POINT_in_classpath1722); 
					pushFollow(FOLLOW_word_in_classpath1726);
					w1=word();
					state._fsp--;

					s+="."; s+=w1;
					}
					break;

				default :
					if ( cnt32 >= 1 ) break loop32;
					EarlyExitException eee = new EarlyExitException(32, input);
					throw eee;
				}
				cnt32++;
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
	// $ANTLR end "classpath"



	// $ANTLR start "word"
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:25: ( ( CONST | VAR ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:27: ( CONST | VAR )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:27: ( CONST | VAR )
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:28: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_word1827); 
					s =CONST1.getText();
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:205:59: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_word1833); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:207:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
	public final Abstract_StringTerm agentnameterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token CONST3=null;
		Abstract_VarTerm v =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:207:47: ( CONST |v= var )
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==CONST) ) {
				alt34=1;
			}
			else if ( ((LA34_0 >= UNNAMEDVAR && LA34_0 <= VAR)) ) {
				alt34=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:207:49: CONST
					{
					CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm1933); 
					s = new Abstract_StringTermImpl(CONST3.getText());
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:207:111: v= var
					{
					pushFollow(FOLLOW_var_in_agentnameterm1941);
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:210:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
	public final Abstract_Literal literal() throws RecognitionException {
		Abstract_Literal l = null;


		Abstract_Predicate nt =null;
		Abstract_Predicate t =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:210:37: ( ( TRUE | NOT nt= pred ) |t= pred )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==NOT||LA36_0==TRUE) ) {
				alt36=1;
			}
			else if ( (LA36_0==CONST||(LA36_0 >= UNNAMEDVAR && LA36_0 <= VAR)) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:210:40: ( TRUE | NOT nt= pred )
					{
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:210:40: ( TRUE | NOT nt= pred )
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
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:210:41: TRUE
							{
							match(input,TRUE,FOLLOW_TRUE_in_literal1957); 
							l = new Abstract_Literal(Abstract_Literal.LTrue);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:211:5: NOT nt= pred
							{
							match(input,NOT,FOLLOW_NOT_in_literal1968); 
							pushFollow(FOLLOW_pred_in_literal1972);
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:215:5: t= pred
					{
					pushFollow(FOLLOW_pred_in_literal1986);
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:219:1: pred returns [Abstract_Predicate t] : (v= var |f= function );
	public final Abstract_Predicate pred() throws RecognitionException {
		Abstract_Predicate t = null;


		Abstract_VarTerm v =null;
		Abstract_Predicate f =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:219:37: (v= var |f= function )
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( ((LA37_0 >= UNNAMEDVAR && LA37_0 <= VAR)) ) {
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
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:219:39: v= var
					{
					pushFollow(FOLLOW_var_in_pred2002);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:219:59: f= function
					{
					pushFollow(FOLLOW_function_in_pred2009);
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:220:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
	public final Abstract_Predicate function() throws RecognitionException {
		Abstract_Predicate f = null;


		Token CONST4=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:220:40: ( CONST ( OPEN terms[$f] CLOSE )? )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:220:42: CONST ( OPEN terms[$f] CLOSE )?
			{
			CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_function2021); 
			f = new Abstract_Predicate(CONST4.getText());
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:220:97: ( OPEN terms[$f] CLOSE )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==OPEN) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:220:98: OPEN terms[$f] CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function2026); 
					pushFollow(FOLLOW_terms_in_function2028);
					terms(f);
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_function2031); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:222:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
	public final void terms(Abstract_Predicate f) throws RecognitionException {
		Abstract_Term t =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:222:29: (t= term ( COMMA terms[$f] )? )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:222:31: t= term ( COMMA terms[$f] )?
			{
			pushFollow(FOLLOW_term_in_terms2044);
			t=term();
			state._fsp--;

			f.addTerm(t);
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:222:58: ( COMMA terms[$f] )?
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==COMMA) ) {
				alt39=1;
			}
			switch (alt39) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:222:59: COMMA terms[$f]
					{
					match(input,COMMA,FOLLOW_COMMA_in_terms2049); 
					pushFollow(FOLLOW_terms_in_terms2051);
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
	}
	// $ANTLR end "terms"



	// $ANTLR start "term"
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:223:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |f= function |l= listterm );
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_NumberTerm a =null;
		Abstract_StringTerm s =null;
		Abstract_Predicate f =null;
		Abstract_ListTerm l =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:223:31: (a= atom |s= stringterm |f= function |l= listterm )
			int alt40=4;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
			case OPEN:
			case UNNAMEDVAR:
			case VAR:
				{
				alt40=1;
				}
				break;
			case DOUBLEQUOTE:
				{
				alt40=2;
				}
				break;
			case CONST:
				{
				alt40=3;
				}
				break;
			case SQOPEN:
				{
				alt40=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}
			switch (alt40) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:223:34: a= atom
					{
					pushFollow(FOLLOW_atom_in_term2070);
					a=atom();
					state._fsp--;

					t = a;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:224:2: s= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term2082);
					s=stringterm();
					state._fsp--;

					t = s;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:225:2: f= function
					{
					pushFollow(FOLLOW_function_in_term2092);
					f=function();
					state._fsp--;

					t = f;
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:226:2: l= listterm
					{
					pushFollow(FOLLOW_listterm_in_term2103);
					l=listterm();
					state._fsp--;

					t = l;
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:228:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
	public final Abstract_NumberTerm atom() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;
		Abstract_NumberTerm a =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:228:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
			int alt41=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
				{
				alt41=1;
				}
				break;
			case UNNAMEDVAR:
			case VAR:
				{
				alt41=2;
				}
				break;
			case OPEN:
				{
				alt41=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}
			switch (alt41) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:228:40: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom2121);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:229:6: v= var
					{
					pushFollow(FOLLOW_var_in_atom2134);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:229:27: OPEN a= arithexpr CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_atom2140); 
					pushFollow(FOLLOW_arithexpr_in_atom2144);
					a=arithexpr();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_atom2146); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:231:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING5=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:231:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:231:46: DOUBLEQUOTE STRING DOUBLEQUOTE
			{
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2160); 
			STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm2163); 
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2165); 
					 
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:234:1: listterm returns [Abstract_ListTerm l] : SQOPEN (hl= listheads ( BAR v= var )? )? SQCLOSE ;
	public final Abstract_ListTerm listterm() throws RecognitionException {
		Abstract_ListTerm l = null;


		ArrayList<Abstract_Term> hl =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:234:40: ( SQOPEN (hl= listheads ( BAR v= var )? )? SQCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:234:42: SQOPEN (hl= listheads ( BAR v= var )? )? SQCLOSE
			{
			l = new Abstract_ListTermImpl();
			match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2200); 
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:234:85: (hl= listheads ( BAR v= var )? )?
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==CONST||LA43_0==DOUBLEQUOTE||LA43_0==MINUS||(LA43_0 >= NUMBER && LA43_0 <= OPEN)||LA43_0==SQOPEN||(LA43_0 >= UNNAMEDVAR && LA43_0 <= VAR)) ) {
				alt43=1;
			}
			switch (alt43) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:234:86: hl= listheads ( BAR v= var )?
					{
					pushFollow(FOLLOW_listheads_in_listterm2205);
					hl=listheads();
					state._fsp--;

					l.addAll(hl);
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:234:120: ( BAR v= var )?
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==BAR) ) {
						alt42=1;
					}
					switch (alt42) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:234:121: BAR v= var
							{
							match(input,BAR,FOLLOW_BAR_in_listterm2210); 
							pushFollow(FOLLOW_var_in_listterm2214);
							v=var();
							state._fsp--;

							l.addTail(v);
							}
							break;

					}

					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2222); 
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



	// $ANTLR start "listheads"
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:236:1: listheads returns [ArrayList<Abstract_Term> tl] : t1= term ( COMMA tl2= term )* ;
	public final ArrayList<Abstract_Term> listheads() throws RecognitionException {
		ArrayList<Abstract_Term> tl = null;


		Abstract_Term t1 =null;
		Abstract_Term tl2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:236:48: (t1= term ( COMMA tl2= term )* )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:236:50: t1= term ( COMMA tl2= term )*
			{
			pushFollow(FOLLOW_term_in_listheads2238);
			t1=term();
			state._fsp--;

			tl = new ArrayList<Abstract_Term>(); tl.add(t1);
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:236:116: ( COMMA tl2= term )*
			loop44:
			while (true) {
				int alt44=2;
				int LA44_0 = input.LA(1);
				if ( (LA44_0==COMMA) ) {
					alt44=1;
				}

				switch (alt44) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:236:117: COMMA tl2= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_listheads2243); 
					pushFollow(FOLLOW_term_in_listheads2248);
					tl2=term();
					state._fsp--;

					tl.add(tl2);
					}
					break;

				default :
					break loop44;
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
		return tl;
	}
	// $ANTLR end "listheads"



	// $ANTLR start "var"
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:239:1: var returns [Abstract_VarTerm v] : ( VAR | UNNAMEDVAR ) ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR6=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:239:34: ( ( VAR | UNNAMEDVAR ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:239:36: ( VAR | UNNAMEDVAR )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:239:36: ( VAR | UNNAMEDVAR )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==VAR) ) {
				alt45=1;
			}
			else if ( (LA45_0==UNNAMEDVAR) ) {
				alt45=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}

			switch (alt45) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:239:37: VAR
					{
					VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_var2266); 

						if (variables.containsKey(VAR6.getText())) {
							v = variables.get(VAR6.getText());
							} else {
							v = new Abstract_VarTerm(VAR6.getText());
							variables.put(VAR6.getText(), v);
							}
						
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:246:6: UNNAMEDVAR
					{
					match(input,UNNAMEDVAR,FOLLOW_UNNAMEDVAR_in_var2272); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:248:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:248:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:248:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
			{
			s = "";
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:248:46: ( MINUS )?
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==MINUS) ) {
				alt46=1;
			}
			switch (alt46) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:248:47: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring2290); 
					s += "-";
					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:248:68: (n1= NUMBER ( POINT n2= NUMBER )? )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:248:69: n1= NUMBER ( POINT n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2299); 
			s += n1.getText();
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:249:6: ( POINT n2= NUMBER )?
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==POINT) ) {
				alt47=1;
			}
			switch (alt47) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:249:7: POINT n2= NUMBER
					{
					match(input,POINT,FOLLOW_POINT_in_numberstring2309); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2315); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:250:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation eq = null;


		Abstract_NumberTerm a1 =null;
		int oper =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:250:40: (a1= arithexpr oper= eqoper a2= arithexpr )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:250:42: a1= arithexpr oper= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation2332);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation2336);
			oper=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation2340);
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:251:1: eqoper returns [int oper] : ( LESS | EQ );
	public final int eqoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:251:27: ( LESS | EQ )
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==LESS) ) {
				alt48=1;
			}
			else if ( (LA48_0==EQ) ) {
				alt48=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}

			switch (alt48) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:251:29: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2354); 
					oper =Abstract_Equation.less;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:251:68: EQ
					{
					match(input,EQ,FOLLOW_EQ_in_eqoper2360); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:253:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm m =null;
		int oper =0;
		Abstract_NumberTerm m1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:253:43: (m= multexpr (oper= addoper m1= multexpr )? )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:253:45: m= multexpr (oper= addoper m1= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr2376);
			m=multexpr();
			state._fsp--;

			t = m;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:253:69: (oper= addoper m1= multexpr )?
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==MINUS||LA49_0==PLUS) ) {
				alt49=1;
			}
			switch (alt49) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:253:71: oper= addoper m1= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr2384);
					oper=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr2388);
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:254:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm a =null;
		int oper =0;
		Abstract_NumberTerm a1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:254:42: (a= atom (oper= multoper a1= atom )? )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:254:44: a= atom (oper= multoper a1= atom )?
			{
			pushFollow(FOLLOW_atom_in_multexpr2405);
			a=atom();
			state._fsp--;

			t = a;
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:254:64: (oper= multoper a1= atom )?
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==DIV||(LA50_0 >= MOD && LA50_0 <= MULT)) ) {
				alt50=1;
			}
			switch (alt50) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:254:65: oper= multoper a1= atom
					{
					pushFollow(FOLLOW_multoper_in_multexpr2412);
					oper=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_in_multexpr2416);
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:256:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:256:28: ( ( PLUS | MINUS ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:256:30: ( PLUS | MINUS )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:256:30: ( PLUS | MINUS )
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==PLUS) ) {
				alt51=1;
			}
			else if ( (LA51_0==MINUS) ) {
				alt51=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 51, 0, input);
				throw nvae;
			}

			switch (alt51) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:256:31: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper2433); 
					oper =Abstract_ArithExpr.plus;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:256:70: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper2438); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:257:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
	public final int multoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:257:29: ( ( MULT | DIV | MOD ) )
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:257:31: ( MULT | DIV | MOD )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:257:31: ( MULT | DIV | MOD )
			int alt52=3;
			switch ( input.LA(1) ) {
			case MULT:
				{
				alt52=1;
				}
				break;
			case DIV:
				{
				alt52=2;
				}
				break;
			case MOD:
				{
				alt52=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 52, 0, input);
				throw nvae;
			}
			switch (alt52) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:257:32: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper2453); 
					oper =Abstract_ArithExpr.times;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:257:73: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper2459); 
					oper =Abstract_ArithExpr.div;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/gwendolen/parser/Gwendolen.g:257:111: MOD
					{
					match(input,MOD,FOLLOW_MOD_in_multoper2465); 
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
	public static final BitSet FOLLOW_GWENDOLEN_in_gwendolenagents102 = new BitSet(new long[]{0x0000002010000000L});
	public static final BitSet FOLLOW_gwendolenagent_in_gwendolenagents113 = new BitSet(new long[]{0x0000002010000002L});
	public static final BitSet FOLLOW_GWENDOLEN_in_gwendolenagent140 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_NAME_in_gwendolenagent146 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_word_in_gwendolenagent150 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_BELIEFS_in_gwendolenagent155 = new BitSet(new long[]{0x3800008008080800L});
	public static final BitSet FOLLOW_literal_in_gwendolenagent160 = new BitSet(new long[]{0x3800008008080800L});
	public static final BitSet FOLLOW_BELIEFRULES_in_gwendolenagent168 = new BitSet(new long[]{0x3000000008080000L});
	public static final BitSet FOLLOW_brule_in_gwendolenagent173 = new BitSet(new long[]{0x3000000008080000L});
	public static final BitSet FOLLOW_GOALS_in_gwendolenagent182 = new BitSet(new long[]{0x3800108000080000L});
	public static final BitSet FOLLOW_goal_in_gwendolenagent187 = new BitSet(new long[]{0x3800108000080000L});
	public static final BitSet FOLLOW_PLANS_in_gwendolenagent194 = new BitSet(new long[]{0x0000200400000002L});
	public static final BitSet FOLLOW_plan_in_gwendolenagent199 = new BitSet(new long[]{0x0000200400000002L});
	public static final BitSet FOLLOW_BELIEVE_in_guard_atom218 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_literal_in_guard_atom222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_guard_atom232 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_goal_in_guard_atom236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SENT_in_guard_atom246 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_OPEN_in_guard_atom248 = new BitSet(new long[]{0x3000000000080000L});
	public static final BitSet FOLLOW_agentnameterm_in_guard_atom255 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom289 = new BitSet(new long[]{0x3600040000180010L});
	public static final BitSet FOLLOW_agentnameterm_in_guard_atom296 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom304 = new BitSet(new long[]{0x0600040000100010L});
	public static final BitSet FOLLOW_performative_in_guard_atom312 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom320 = new BitSet(new long[]{0x3000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom324 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_guard_atom326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_guard_atom340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_guard_atom350 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_goal384 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_SQOPEN_in_goal386 = new BitSet(new long[]{0x0000080000000020L});
	public static final BitSet FOLLOW_ACHIEVEGOAL_in_goal389 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_PERFORMGOAL_in_goal399 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_goal404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_event_in_plan418 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_COLON_in_plan426 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_plan428 = new BitSet(new long[]{0x3810038404002000L});
	public static final BitSet FOLLOW_NOT_in_plan433 = new BitSet(new long[]{0x3810030404002000L});
	public static final BitSet FOLLOW_guard_atom_in_plan441 = new BitSet(new long[]{0x0000000000220000L});
	public static final BitSet FOLLOW_COMMA_in_plan449 = new BitSet(new long[]{0x3810038404002000L});
	public static final BitSet FOLLOW_NOT_in_plan454 = new BitSet(new long[]{0x3810030404002000L});
	public static final BitSet FOLLOW_guard_atom_in_plan462 = new BitSet(new long[]{0x0000000000220000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_plan468 = new BitSet(new long[]{0x0006000000000000L});
	public static final BitSet FOLLOW_RULEARROW_in_plan471 = new BitSet(new long[]{0x3008201400080000L});
	public static final BitSet FOLLOW_deed_in_plan476 = new BitSet(new long[]{0x0004000000020000L});
	public static final BitSet FOLLOW_COMMA_in_plan481 = new BitSet(new long[]{0x3008201400080000L});
	public static final BitSet FOLLOW_deed_in_plan485 = new BitSet(new long[]{0x0004000000020000L});
	public static final BitSet FOLLOW_SEMI_in_plan495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_event511 = new BitSet(new long[]{0x3821008000080180L});
	public static final BitSet FOLLOW_RECEIVED_in_event514 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_OPEN_in_event516 = new BitSet(new long[]{0x0600040000100010L});
	public static final BitSet FOLLOW_performative_in_event520 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_event522 = new BitSet(new long[]{0x3000000000080000L});
	public static final BitSet FOLLOW_pred_in_event526 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_event528 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_event546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_event556 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_goal_in_event560 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADD_CONTENT_in_event571 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_literal_in_event575 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADD_CONTEXT_in_event585 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_literal_in_event589 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_event607 = new BitSet(new long[]{0x3820008000080180L});
	public static final BitSet FOLLOW_literal_in_event612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_event622 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_goal_in_event626 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADD_CONTENT_in_event636 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_literal_in_event640 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADD_CONTEXT_in_event650 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_literal_in_event654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TELL_in_performative676 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PERFORM_in_performative682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACHIEVE_in_performative688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TELLHOW_in_performative694 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONSTRAINT_in_performative700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_deed726 = new BitSet(new long[]{0x38200082000803C0L});
	public static final BitSet FOLLOW_literal_in_deed731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_deed741 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_goal_in_deed745 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADD_CONTENT_in_deed755 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_literal_in_deed759 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADD_CONTEXT_in_deed769 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_literal_in_deed773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADD_PLAN_in_deed783 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_literal_in_deed787 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADD_CONSTRAINT_in_deed797 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_literal_in_deed801 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOCK_in_deed811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_deed824 = new BitSet(new long[]{0x3820008200080180L});
	public static final BitSet FOLLOW_literal_in_deed829 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_deed839 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_goal_in_deed843 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADD_CONTENT_in_deed853 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_literal_in_deed857 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADD_CONTEXT_in_deed867 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_literal_in_deed871 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOCK_in_deed881 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_deed900 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_waitfor_in_deed913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_brule948 = new BitSet(new long[]{0x0004000000004000L});
	public static final BitSet FOLLOW_BRULEARROW_in_brule951 = new BitSet(new long[]{0x3080008000080000L});
	public static final BitSet FOLLOW_logicalfmla_in_brule955 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_brule959 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMI_in_brule963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla980 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_COMMA_in_logicalfmla1000 = new BitSet(new long[]{0x3080008000080000L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla1004 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_pred_in_notfmla1040 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_notfmla1046 = new BitSet(new long[]{0x3000030400000000L});
	public static final BitSet FOLLOW_equation_in_notfmla1052 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_notfmla1056 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_notfmla1140 = new BitSet(new long[]{0x3080020000080000L});
	public static final BitSet FOLLOW_pred_in_notfmla1147 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_notfmla1234 = new BitSet(new long[]{0x3000030400000000L});
	public static final BitSet FOLLOW_equation_in_notfmla1240 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_notfmla1242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subfmla_in_notfmla1331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_subfmla1345 = new BitSet(new long[]{0x3080008000080000L});
	public static final BitSet FOLLOW_logicalfmla_in_subfmla1351 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_subfmla1355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_waitfor1370 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_literal_in_waitfor1374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEND_in_action1391 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_OPEN_in_action1393 = new BitSet(new long[]{0x3800008000080000L});
	public static final BitSet FOLLOW_literal_in_action1397 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_action1399 = new BitSet(new long[]{0x0600040000100010L});
	public static final BitSet FOLLOW_performative_in_action1403 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_action1405 = new BitSet(new long[]{0x3000000000080000L});
	public static final BitSet FOLLOW_pred_in_action1409 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_action1411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_action1422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_classpath_in_environment1702 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_classpath1717 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_POINT_in_classpath1722 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_word_in_classpath1726 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_CONST_in_word1827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word1833 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_agentnameterm1933 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_agentnameterm1941 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_literal1957 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_literal1968 = new BitSet(new long[]{0x3000000000080000L});
	public static final BitSet FOLLOW_pred_in_literal1972 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_literal1986 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_pred2002 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_pred2009 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function2021 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_OPEN_in_function2026 = new BitSet(new long[]{0x3080030401080000L});
	public static final BitSet FOLLOW_terms_in_function2028 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_function2031 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_terms2044 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_COMMA_in_terms2049 = new BitSet(new long[]{0x3080030401080000L});
	public static final BitSet FOLLOW_terms_in_terms2051 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_term2070 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_term2082 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_term2092 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_term2103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom2121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom2134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom2140 = new BitSet(new long[]{0x3000030400000000L});
	public static final BitSet FOLLOW_arithexpr_in_atom2144 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_atom2146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2160 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_STRING_in_stringterm2163 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_listterm2200 = new BitSet(new long[]{0x30C0030401080000L});
	public static final BitSet FOLLOW_listheads_in_listterm2205 = new BitSet(new long[]{0x0040000000000400L});
	public static final BitSet FOLLOW_BAR_in_listterm2210 = new BitSet(new long[]{0x3000000000000000L});
	public static final BitSet FOLLOW_var_in_listterm2214 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_listterm2222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_listheads2238 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_COMMA_in_listheads2243 = new BitSet(new long[]{0x3080030401080000L});
	public static final BitSet FOLLOW_term_in_listheads2248 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_VAR_in_var2266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNNAMEDVAR_in_var2272 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring2290 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2299 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_POINT_in_numberstring2309 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2315 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation2332 = new BitSet(new long[]{0x0000000082000000L});
	public static final BitSet FOLLOW_eqoper_in_equation2336 = new BitSet(new long[]{0x3000030400000000L});
	public static final BitSet FOLLOW_arithexpr_in_equation2340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_eqoper2360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2376 = new BitSet(new long[]{0x0000200400000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr2384 = new BitSet(new long[]{0x3000030400000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_multexpr2405 = new BitSet(new long[]{0x0000001800800002L});
	public static final BitSet FOLLOW_multoper_in_multexpr2412 = new BitSet(new long[]{0x3000030400000000L});
	public static final BitSet FOLLOW_atom_in_multexpr2416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper2433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper2438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper2453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper2459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_multoper2465 = new BitSet(new long[]{0x0000000000000002L});
}
