// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g 2014-12-16 11:03:28

package eass.parser;

import ail.syntax.ast.*;
import eass.syntax.ast.*;
import gwendolen.syntax.ast.*;
import java.util.HashMap;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class EASSParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ABSTRACTION", "ACHIEVE", "ACHIEVEGOAL", 
		"BELIEFRULES", "BELIEFS", "BELIEVE", "BRULEARROW", "CALCULATE", "CLOSE", 
		"COLON", "COMMA", "COMMENT", "CONST", "CURLYCLOSE", "CURLYOPEN", "DIV", 
		"DOUBLEQUOTE", "EASS", "EQ", "EQ_ASSGN", "GOAL", "GOALS", "LESS", "LINE_COMMENT", 
		"LOCK", "MINUS", "MOD", "MULT", "NAME", "NEWLINE", "NOT", "NUMBER", "OPEN", 
		"PERFORM", "PERFORMGOAL", "PLANS", "PLUS", "POINT", "QUERY", "QUERYCOM", 
		"RECEIVED", "RULEARROW", "SEMI", "SEND", "SENT", "SHRIEK", "SQCLOSE", 
		"SQOPEN", "STRING", "TELL", "TRUE", "UPDATE", "VAR", "WAIT", "WS"
	};
	public static final int EOF=-1;
	public static final int ABSTRACTION=4;
	public static final int ACHIEVE=5;
	public static final int ACHIEVEGOAL=6;
	public static final int BELIEFRULES=7;
	public static final int BELIEFS=8;
	public static final int BELIEVE=9;
	public static final int BRULEARROW=10;
	public static final int CALCULATE=11;
	public static final int CLOSE=12;
	public static final int COLON=13;
	public static final int COMMA=14;
	public static final int COMMENT=15;
	public static final int CONST=16;
	public static final int CURLYCLOSE=17;
	public static final int CURLYOPEN=18;
	public static final int DIV=19;
	public static final int DOUBLEQUOTE=20;
	public static final int EASS=21;
	public static final int EQ=22;
	public static final int EQ_ASSGN=23;
	public static final int GOAL=24;
	public static final int GOALS=25;
	public static final int LESS=26;
	public static final int LINE_COMMENT=27;
	public static final int LOCK=28;
	public static final int MINUS=29;
	public static final int MOD=30;
	public static final int MULT=31;
	public static final int NAME=32;
	public static final int NEWLINE=33;
	public static final int NOT=34;
	public static final int NUMBER=35;
	public static final int OPEN=36;
	public static final int PERFORM=37;
	public static final int PERFORMGOAL=38;
	public static final int PLANS=39;
	public static final int PLUS=40;
	public static final int POINT=41;
	public static final int QUERY=42;
	public static final int QUERYCOM=43;
	public static final int RECEIVED=44;
	public static final int RULEARROW=45;
	public static final int SEMI=46;
	public static final int SEND=47;
	public static final int SENT=48;
	public static final int SHRIEK=49;
	public static final int SQCLOSE=50;
	public static final int SQOPEN=51;
	public static final int STRING=52;
	public static final int TELL=53;
	public static final int TRUE=54;
	public static final int UPDATE=55;
	public static final int VAR=56;
	public static final int WAIT=57;
	public static final int WS=58;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public EASSParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public EASSParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return EASSParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g"; }


		private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
		private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");
		


	// $ANTLR start "mas"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:59:1: mas returns [Abstract_MAS mas] :glist= eassagents ;
	public final Abstract_MAS mas() throws RecognitionException {
		Abstract_MAS mas = null;


		ArrayList<Abstract_EASSAgent> glist =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:59:32: (glist= eassagents )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:59:34: glist= eassagents
			{
			mas = new Abstract_MAS();
			pushFollow(FOLLOW_eassagents_in_mas89);
			glist=eassagents();
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



	// $ANTLR start "eassagents"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:62:1: eassagents returns [ArrayList<Abstract_EASSAgent> gags] : EASS (g= eassagent )+ ;
	public final ArrayList<Abstract_EASSAgent> eassagents() throws RecognitionException {
		ArrayList<Abstract_EASSAgent> gags = null;


		Abstract_EASSAgent g =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:62:55: ( EASS (g= eassagent )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:62:57: EASS (g= eassagent )+
			{
			match(input,EASS,FOLLOW_EASS_in_eassagents102); 
			gags=new ArrayList<Abstract_EASSAgent>();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:63:2: (g= eassagent )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ABSTRACTION||LA1_0==NAME) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:63:3: g= eassagent
					{
					pushFollow(FOLLOW_eassagent_in_eassagents111);
					g=eassagent();
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
	// $ANTLR end "eassagents"



	// $ANTLR start "eassagent"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:65:1: eassagent returns [Abstract_EASSAgent g] : ( NAME w= word | ABSTRACTION w= word ) BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOALS (gl= goal )* PLANS (p= plan )* ;
	public final Abstract_EASSAgent eassagent() throws RecognitionException {
		Abstract_EASSAgent g = null;


		String w =null;
		Abstract_Literal l =null;
		Abstract_Rule r =null;
		Abstract_Goal gl =null;
		Abstract_GPlan p =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:65:42: ( ( NAME w= word | ABSTRACTION w= word ) BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOALS (gl= goal )* PLANS (p= plan )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:66:2: ( NAME w= word | ABSTRACTION w= word ) BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOALS (gl= goal )* PLANS (p= plan )*
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:66:2: ( NAME w= word | ABSTRACTION w= word )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==NAME) ) {
				alt2=1;
			}
			else if ( (LA2_0==ABSTRACTION) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:66:3: NAME w= word
					{
					match(input,NAME,FOLLOW_NAME_in_eassagent130); 
					pushFollow(FOLLOW_word_in_eassagent134);
					w=word();
					state._fsp--;

					try {g = new Abstract_EASSAgent(w);} catch (Exception e) {System.err.println(e);}
						              agentname = new Abstract_StringTermImpl(w);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:68:2: ABSTRACTION w= word
					{
					match(input,ABSTRACTION,FOLLOW_ABSTRACTION_in_eassagent141); 
					pushFollow(FOLLOW_word_in_eassagent145);
					w=word();
					state._fsp--;

					String s = "abstraction_" + w; g = new Abstract_EASSAgent(s); g.setAbstraction(w);
					}
					break;

			}

			match(input,BELIEFS,FOLLOW_BELIEFS_in_eassagent157); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:70:10: (l= literal )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==CONST||LA3_0==NOT||LA3_0==TRUE||LA3_0==VAR) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:70:11: l= literal
					{
					pushFollow(FOLLOW_literal_in_eassagent162);
					l=literal();
					state._fsp--;

					g.addInitialBel(l);
					}
					break;

				default :
					break loop3;
				}
			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:71:2: ( BELIEFRULES (r= brule )* )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==BELIEFRULES) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:71:3: BELIEFRULES (r= brule )*
					{
					match(input,BELIEFRULES,FOLLOW_BELIEFRULES_in_eassagent170); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:71:15: (r= brule )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==CONST||LA4_0==VAR) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:71:16: r= brule
							{
							pushFollow(FOLLOW_brule_in_eassagent175);
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

			match(input,GOALS,FOLLOW_GOALS_in_eassagent184); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:72:8: (gl= goal )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==CONST||LA6_0==NOT||LA6_0==TRUE||LA6_0==VAR) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:72:9: gl= goal
					{
					pushFollow(FOLLOW_goal_in_eassagent189);
					gl=goal();
					state._fsp--;

					g.addInitialGoal(gl);
					}
					break;

				default :
					break loop6;
				}
			}

			match(input,PLANS,FOLLOW_PLANS_in_eassagent196); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:73:8: (p= plan )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==MINUS||LA7_0==PLUS) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:73:9: p= plan
					{
					pushFollow(FOLLOW_plan_in_eassagent201);
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
	// $ANTLR end "eassagent"



	// $ANTLR start "goal"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:76:1: goal returns [Abstract_Goal g] : l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE ;
	public final Abstract_Goal goal() throws RecognitionException {
		Abstract_Goal g = null;


		Abstract_Literal l =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:76:32: (l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:76:34: l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE
			{
			pushFollow(FOLLOW_literal_in_goal221);
			l=literal();
			state._fsp--;

			match(input,SQOPEN,FOLLOW_SQOPEN_in_goal223); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:76:51: ( ACHIEVEGOAL | PERFORMGOAL )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==ACHIEVEGOAL) ) {
				alt8=1;
			}
			else if ( (LA8_0==PERFORMGOAL) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:76:52: ACHIEVEGOAL
					{
					match(input,ACHIEVEGOAL,FOLLOW_ACHIEVEGOAL_in_goal226); 
					g = new Abstract_Goal(l, Abstract_Goal.achieveGoal);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:77:2: PERFORMGOAL
					{
					match(input,PERFORMGOAL,FOLLOW_PERFORMGOAL_in_goal234); 
					g = new Abstract_Goal(l, Abstract_Goal.performGoal);
					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_goal239); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:80:1: plan returns [Abstract_GPlan p] : e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )* )? SEMI ;
	public final Abstract_GPlan plan() throws RecognitionException {
		Abstract_GPlan p = null;


		Abstract_Event e =null;
		Abstract_GLogicalFormula gb =null;
		Abstract_Deed d =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:81:2: (e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )* )? SEMI )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:81:4: e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )* )? SEMI
			{
			pushFollow(FOLLOW_event_in_plan255);
			e=event();
			state._fsp--;

			ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();
			match(input,COLON,FOLLOW_COLON_in_plan263); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_plan265); 
			boolean gneg=true;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:82:40: ( NOT )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==NOT) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:82:41: NOT
					{
					match(input,NOT,FOLLOW_NOT_in_plan270); 
					gneg=false;
					}
					break;

			}

			pushFollow(FOLLOW_guard_atom_in_plan278);
			gb=guard_atom();
			state._fsp--;

			g.add(gb, gneg);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:83:3: ( COMMA ( NOT )? gb= guard_atom )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==COMMA) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:83:4: COMMA ( NOT )? gb= guard_atom
					{
					match(input,COMMA,FOLLOW_COMMA_in_plan286); 
					gneg=true;
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:83:23: ( NOT )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==NOT) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:83:24: NOT
							{
							match(input,NOT,FOLLOW_NOT_in_plan291); 
							gneg=false;
							}
							break;

					}

					pushFollow(FOLLOW_guard_atom_in_plan299);
					gb=guard_atom();
					state._fsp--;

					g.add(gb, gneg);
					}
					break;

				default :
					break loop11;
				}
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_plan305); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:83:93: ( RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )* )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==RULEARROW) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:83:94: RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )*
					{
					match(input,RULEARROW,FOLLOW_RULEARROW_in_plan308); 
					pushFollow(FOLLOW_deed_in_plan313);
					d=deed(deeds);
					state._fsp--;

					deeds.add(d);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:84:35: ( ',' d= deed[deeds] )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==COMMA) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:84:36: ',' d= deed[deeds]
							{
							match(input,COMMA,FOLLOW_COMMA_in_plan319); 
							pushFollow(FOLLOW_deed_in_plan323);
							d=deed(deeds);
							state._fsp--;

							deeds.add(d);
							}
							break;

						default :
							break loop12;
						}
					}

					}
					break;

			}

			match(input,SEMI,FOLLOW_SEMI_in_plan334); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:87:1: event returns [Abstract_Event e] : ( PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) ) ;
	public final Abstract_Event event() throws RecognitionException {
		Abstract_Event e = null;


		int p =0;
		Abstract_Predicate t =null;
		Abstract_Literal l =null;
		Abstract_Goal g =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:87:34: ( ( PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:87:36: ( PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:87:36: ( PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==PLUS) ) {
				alt17=1;
			}
			else if ( (LA17_0==MINUS) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:87:37: PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) )
					{
					match(input,PLUS,FOLLOW_PLUS_in_event350); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:87:42: ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) )
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==RECEIVED) ) {
						alt15=1;
					}
					else if ( (LA15_0==CONST||LA15_0==NOT||LA15_0==SHRIEK||LA15_0==TRUE||LA15_0==VAR) ) {
						alt15=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 15, 0, input);
						throw nvae;
					}

					switch (alt15) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:87:43: RECEIVED OPEN p= performative ',' t= pred ')'
							{
							match(input,RECEIVED,FOLLOW_RECEIVED_in_event353); 
							match(input,OPEN,FOLLOW_OPEN_in_event355); 
							pushFollow(FOLLOW_performative_in_event359);
							p=performative();
							state._fsp--;

							match(input,COMMA,FOLLOW_COMMA_in_event361); 
							pushFollow(FOLLOW_pred_in_event365);
							t=pred();
							state._fsp--;

							match(input,CLOSE,FOLLOW_CLOSE_in_event367); 
							Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), 
												new Abstract_VarTerm("To"), p, t); 
												e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILReceived, message);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:91:5: (l= literal | SHRIEK g= goal )
							{
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:91:5: (l= literal | SHRIEK g= goal )
							int alt14=2;
							int LA14_0 = input.LA(1);
							if ( (LA14_0==CONST||LA14_0==NOT||LA14_0==TRUE||LA14_0==VAR) ) {
								alt14=1;
							}
							else if ( (LA14_0==SHRIEK) ) {
								alt14=2;
							}

							else {
								NoViableAltException nvae =
									new NoViableAltException("", 14, 0, input);
								throw nvae;
							}

							switch (alt14) {
								case 1 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:91:6: l= literal
									{
									pushFollow(FOLLOW_literal_in_event385);
									l=literal();
									state._fsp--;

									e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, l);
									}
									break;
								case 2 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:92:5: SHRIEK g= goal
									{
									match(input,SHRIEK,FOLLOW_SHRIEK_in_event395); 
									pushFollow(FOLLOW_goal_in_event399);
									g=goal();
									state._fsp--;

									e = new Abstract_Event(Abstract_Event.AILAddition, g);
									}
									break;

							}

							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:7: MINUS (l= literal | SHRIEK g= goal )
					{
					match(input,MINUS,FOLLOW_MINUS_in_event413); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:13: (l= literal | SHRIEK g= goal )
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==CONST||LA16_0==NOT||LA16_0==TRUE||LA16_0==VAR) ) {
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:14: l= literal
							{
							pushFollow(FOLLOW_literal_in_event418);
							l=literal();
							state._fsp--;

							e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, l);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:94:5: SHRIEK g= goal
							{
							match(input,SHRIEK,FOLLOW_SHRIEK_in_event428); 
							pushFollow(FOLLOW_goal_in_event432);
							g=goal();
							state._fsp--;

							e = new Abstract_Event(Abstract_Event.AILDeletion, g);
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



	// $ANTLR start "guard_atom"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:96:1: guard_atom returns [Abstract_GLogicalFormula g] : ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE ) ;
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:96:49: ( ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:96:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:96:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (s= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE )
			int alt20=5;
			switch ( input.LA(1) ) {
			case BELIEVE:
				{
				alt20=1;
				}
				break;
			case GOAL:
				{
				alt20=2;
				}
				break;
			case SENT:
				{
				alt20=3;
				}
				break;
			case MINUS:
			case NUMBER:
			case OPEN:
			case VAR:
				{
				alt20=4;
				}
				break;
			case TRUE:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:96:52: BELIEVE l= literal
					{
					match(input,BELIEVE,FOLLOW_BELIEVE_in_guard_atom453); 
					pushFollow(FOLLOW_literal_in_guard_atom457);
					l=literal();
					state._fsp--;

					g = new Abstract_GBelief(l);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:97:5: GOAL gl= goal
					{
					match(input,GOAL,FOLLOW_GOAL_in_guard_atom467); 
					pushFollow(FOLLOW_goal_in_guard_atom471);
					gl=goal();
					state._fsp--;

					g = new Abstract_Goal(gl);
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:98:5: SENT OPEN (s= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE
					{
					match(input,SENT,FOLLOW_SENT_in_guard_atom481); 
					match(input,OPEN,FOLLOW_OPEN_in_guard_atom483); 
					Abstract_StringTerm an1=agentname;
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:98:52: (s= stringterm |v= var )
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==DOUBLEQUOTE) ) {
						alt18=1;
					}
					else if ( (LA18_0==VAR) ) {
						alt18=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 18, 0, input);
						throw nvae;
					}

					switch (alt18) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:98:53: s= stringterm
							{
							pushFollow(FOLLOW_stringterm_in_guard_atom490);
							s=stringterm();
							state._fsp--;

							an1=s;
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:98:77: v= var
							{
							pushFollow(FOLLOW_var_in_guard_atom498);
							v=var();
							state._fsp--;

							an1 = v;
							}
							break;

					}

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom503); 
					Abstract_StringTerm agn = agentname;
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:98:140: (an2= stringterm COMMA )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==DOUBLEQUOTE) ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:98:141: an2= stringterm COMMA
							{
							pushFollow(FOLLOW_stringterm_in_guard_atom510);
							an2=stringterm();
							state._fsp--;

							match(input,COMMA,FOLLOW_COMMA_in_guard_atom518); 
							agn = an2;
							}
							break;

					}

					pushFollow(FOLLOW_performative_in_guard_atom526);
					p=performative();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom534); 
					pushFollow(FOLLOW_pred_in_guard_atom538);
					t=pred();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_guard_atom540); 
					g = new Abstract_GuardMessage(Abstract_BaseAILStructure.AILSent, agn, an1, p, t);
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:101:5: eq= equation
					{
					pushFollow(FOLLOW_equation_in_guard_atom554);
					eq=equation();
					state._fsp--;

					g = eq;
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_guard_atom564); 
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



	// $ANTLR start "deed"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:1: deed[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : ( ( ( PLUS (l= literal | SHRIEK g= goal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | LOCK ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action ) |wf= waitfor ) ;
	public final Abstract_Deed deed(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Literal l =null;
		Abstract_Goal g =null;
		Abstract_Deed c =null;
		Abstract_Deed q =null;
		Abstract_Deed w =null;
		Abstract_Action a =null;
		Abstract_Literal wf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:61: ( ( ( ( PLUS (l= literal | SHRIEK g= goal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | LOCK ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action ) |wf= waitfor ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:63: ( ( ( PLUS (l= literal | SHRIEK g= goal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | LOCK ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action ) |wf= waitfor )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:63: ( ( ( PLUS (l= literal | SHRIEK g= goal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | LOCK ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action ) |wf= waitfor )
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==CALCULATE||LA25_0==CONST||LA25_0==MINUS||(LA25_0 >= NUMBER && LA25_0 <= OPEN)||LA25_0==PLUS||LA25_0==QUERYCOM||LA25_0==SEND||(LA25_0 >= UPDATE && LA25_0 <= WAIT)) ) {
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:64: ( ( PLUS (l= literal | SHRIEK g= goal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | LOCK ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:64: ( ( PLUS (l= literal | SHRIEK g= goal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | LOCK ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action )
					int alt24=6;
					switch ( input.LA(1) ) {
					case PLUS:
						{
						alt24=1;
						}
						break;
					case MINUS:
						{
						int LA24_2 = input.LA(2);
						if ( (LA24_2==CONST||LA24_2==LOCK||LA24_2==NOT||LA24_2==SHRIEK||LA24_2==TRUE||LA24_2==VAR) ) {
							alt24=1;
						}
						else if ( (LA24_2==NUMBER) ) {
							alt24=6;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 24, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case UPDATE:
						{
						alt24=2;
						}
						break;
					case CALCULATE:
						{
						alt24=3;
						}
						break;
					case QUERYCOM:
						{
						alt24=4;
						}
						break;
					case WAIT:
						{
						alt24=5;
						}
						break;
					case CONST:
					case NUMBER:
					case OPEN:
					case SEND:
					case VAR:
						{
						alt24=6;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 24, 0, input);
						throw nvae;
					}
					switch (alt24) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:65: ( PLUS (l= literal | SHRIEK g= goal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | LOCK ) )
							{
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:65: ( PLUS (l= literal | SHRIEK g= goal | LOCK ) | MINUS (l= literal | SHRIEK g= goal | LOCK ) )
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
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:66: PLUS (l= literal | SHRIEK g= goal | LOCK )
									{
									match(input,PLUS,FOLLOW_PLUS_in_deed588); 
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:71: (l= literal | SHRIEK g= goal | LOCK )
									int alt21=3;
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
									case LOCK:
										{
										alt21=3;
										}
										break;
									default:
										NoViableAltException nvae =
											new NoViableAltException("", 21, 0, input);
										throw nvae;
									}
									switch (alt21) {
										case 1 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:72: l= literal
											{
											pushFollow(FOLLOW_literal_in_deed593);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, l);
											}
											break;
										case 2 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:105:5: SHRIEK g= goal
											{
											match(input,SHRIEK,FOLLOW_SHRIEK_in_deed603); 
											pushFollow(FOLLOW_goal_in_deed607);
											g=goal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, g);
											}
											break;
										case 3 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:106:5: LOCK
											{
											match(input,LOCK,FOLLOW_LOCK_in_deed617); 
											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);
											}
											break;

									}

									}
									break;
								case 2 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:107:7: MINUS (l= literal | SHRIEK g= goal | LOCK )
									{
									match(input,MINUS,FOLLOW_MINUS_in_deed630); 
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:107:13: (l= literal | SHRIEK g= goal | LOCK )
									int alt22=3;
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
									case LOCK:
										{
										alt22=3;
										}
										break;
									default:
										NoViableAltException nvae =
											new NoViableAltException("", 22, 0, input);
										throw nvae;
									}
									switch (alt22) {
										case 1 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:107:14: l= literal
											{
											pushFollow(FOLLOW_literal_in_deed635);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, l);
											}
											break;
										case 2 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:108:5: SHRIEK g= goal
											{
											match(input,SHRIEK,FOLLOW_SHRIEK_in_deed645); 
											pushFollow(FOLLOW_goal_in_deed649);
											g=goal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILDeletion, g);
											}
											break;
										case 3 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:109:5: LOCK
											{
											match(input,LOCK,FOLLOW_LOCK_in_deed659); 
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:111:5: UPDATE (l= literal )
							{
							match(input,UPDATE,FOLLOW_UPDATE_in_deed676); 
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:111:12: (l= literal )
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:111:13: l= literal
							{
							pushFollow(FOLLOW_literal_in_deed681);
							l=literal();
							state._fsp--;

							d = new Abstract_Deed(Abstract_Deed.AILUpdate, Abstract_Deed.AILBel, l);
							}

							}
							break;
						case 3 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:112:5: CALCULATE c= calculation[ds]
							{
							match(input,CALCULATE,FOLLOW_CALCULATE_in_deed692); 
							pushFollow(FOLLOW_calculation_in_deed696);
							c=calculation(ds);
							state._fsp--;

							d = c;
							}
							break;
						case 4 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:113:5: QUERYCOM q= query[ds]
							{
							match(input,QUERYCOM,FOLLOW_QUERYCOM_in_deed707); 
							pushFollow(FOLLOW_query_in_deed711);
							q=query(ds);
							state._fsp--;

							d = q;
							}
							break;
						case 5 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:114:5: WAIT w= wait[ds]
							{
							match(input,WAIT,FOLLOW_WAIT_in_deed722); 
							pushFollow(FOLLOW_wait_in_deed726);
							w=wait(ds);
							state._fsp--;

							d = w;
							}
							break;
						case 6 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:115:5: a= action
							{
							pushFollow(FOLLOW_action_in_deed739);
							a=action();
							state._fsp--;

							d = new Abstract_Deed(a);
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:5: wf= waitfor
					{
					pushFollow(FOLLOW_waitfor_in_deed752);
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



	// $ANTLR start "calculation"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:120:1: calculation[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN l1= literal COMMA v= var CLOSE ;
	public final Abstract_Deed calculation(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Literal l1 =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:120:68: ( OPEN l1= literal COMMA v= var CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:120:70: OPEN l1= literal COMMA v= var CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_calculation782); 
			pushFollow(FOLLOW_literal_in_calculation788);
			l1=literal();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_calculation790); 
			pushFollow(FOLLOW_var_in_calculation794);
			v=var();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_calculation796); 
			Abstract_Action a = new Abstract_Action("calculate"); a.addTerm(l1); a.addTerm(new Abstract_VarTerm("NewVarForCalculate")); ds.add(new Abstract_Deed(a));
				Abstract_Literal wf = new Abstract_Literal("result"); wf.addTerm(l1); wf.addTerm(v); ds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, wf));
				Abstract_Action rs = new Abstract_Action("remove_shared"); rs.addTerm(wf); d = new Abstract_Deed(rs);
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
	// $ANTLR end "calculation"



	// $ANTLR start "query"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:125:1: query[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN l1= literal CLOSE ;
	public final Abstract_Deed query(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Literal l1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:125:62: ( OPEN l1= literal CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:125:64: OPEN l1= literal CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_query814); 
			pushFollow(FOLLOW_literal_in_query820);
			l1=literal();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_query823); 
			Abstract_Action a = new Abstract_Action("query"); a.addTerm(l1); ds.add(new Abstract_Deed(a));
				ds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, l1));
				Abstract_Action rs = new Abstract_Action("remove_shared"); rs.addTerm(l1); d = new Abstract_Deed(rs);
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
	// $ANTLR end "query"



	// $ANTLR start "wait"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:130:1: wait[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN l1= term COMMA l2= literal CLOSE ;
	public final Abstract_Deed wait(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Term l1 =null;
		Abstract_Literal l2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:130:61: ( OPEN l1= term COMMA l2= literal CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:130:63: OPEN l1= term COMMA l2= literal CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_wait841); 
			pushFollow(FOLLOW_term_in_wait847);
			l1=term();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_wait849); 
			pushFollow(FOLLOW_literal_in_wait853);
			l2=literal();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_wait855); 
			Abstract_Action a = new Abstract_Action("wait"); a.addTerm(l1); a.addTerm(l2); ds.add(new Abstract_Deed(a));
				Abstract_Literal wf = new Abstract_Literal("waited"); wf.addTerm(l2); ds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, wf));
				Abstract_Action rs = new Abstract_Action("remove_shared"); rs.addTerm(wf); d = new Abstract_Deed(rs);
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
	// $ANTLR end "wait"



	// $ANTLR start "brule"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:135:1: brule returns [Abstract_Rule r] : head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) ;
	public final Abstract_Rule brule() throws RecognitionException {
		Abstract_Rule r = null;


		Abstract_Predicate head =null;
		Abstract_LogicalFormula f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:135:33: (head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:135:35: head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI )
			{
			pushFollow(FOLLOW_pred_in_brule877);
			head=pred();
			state._fsp--;

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:135:45: ( BRULEARROW f= logicalfmla SEMI | SEMI )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:135:46: BRULEARROW f= logicalfmla SEMI
					{
					match(input,BRULEARROW,FOLLOW_BRULEARROW_in_brule880); 
					pushFollow(FOLLOW_logicalfmla_in_brule884);
					f=logicalfmla();
					state._fsp--;

					r = new Abstract_Rule(head, f);
					match(input,SEMI,FOLLOW_SEMI_in_brule888); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:135:116: SEMI
					{
					match(input,SEMI,FOLLOW_SEMI_in_brule892); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:137:1: logicalfmla returns [Abstract_LogicalFormula f] : n= notfmla ( COMMA n2= notfmla )* ;
	public final Abstract_LogicalFormula logicalfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula n =null;
		Abstract_LogicalFormula n2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:137:49: (n= notfmla ( COMMA n2= notfmla )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:137:51: n= notfmla ( COMMA n2= notfmla )*
			{
			pushFollow(FOLLOW_notfmla_in_logicalfmla909);
			n=notfmla();
			state._fsp--;

			f = n;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:138:16: ( COMMA n2= notfmla )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==COMMA) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:138:17: COMMA n2= notfmla
					{
					match(input,COMMA,FOLLOW_COMMA_in_logicalfmla929); 
					pushFollow(FOLLOW_notfmla_in_logicalfmla933);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:140:1: notfmla returns [Abstract_LogicalFormula f] : (gb= pred | NOT (gb2= pred |lf= subfmla ) );
	public final Abstract_LogicalFormula notfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_Predicate gb =null;
		Abstract_Predicate gb2 =null;
		Abstract_LogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:140:45: (gb= pred | NOT (gb2= pred |lf= subfmla ) )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:140:47: gb= pred
					{
					pushFollow(FOLLOW_pred_in_notfmla968);
					gb=pred();
					state._fsp--;

					f = gb;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:141:79: NOT (gb2= pred |lf= subfmla )
					{
					match(input,NOT,FOLLOW_NOT_in_notfmla1053); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:141:83: (gb2= pred |lf= subfmla )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:141:84: gb2= pred
							{
							pushFollow(FOLLOW_pred_in_notfmla1060);
							gb2=pred();
							state._fsp--;

							f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:141:153: lf= subfmla
							{
							pushFollow(FOLLOW_subfmla_in_notfmla1070);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:142:1: subfmla returns [Abstract_LogicalFormula f] : OPEN lf= logicalfmla CLOSE ;
	public final Abstract_LogicalFormula subfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:142:45: ( OPEN lf= logicalfmla CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:142:47: OPEN lf= logicalfmla CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_subfmla1084); 
			pushFollow(FOLLOW_logicalfmla_in_subfmla1090);
			lf=logicalfmla();
			state._fsp--;

			f = lf;
			match(input,CLOSE,FOLLOW_CLOSE_in_subfmla1094); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:144:1: waitfor returns [Abstract_Literal wf] : MULT l= literal ;
	public final Abstract_Literal waitfor() throws RecognitionException {
		Abstract_Literal wf = null;


		Abstract_Literal l =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:144:39: ( MULT l= literal )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:144:42: MULT l= literal
			{
			match(input,MULT,FOLLOW_MULT_in_waitfor1108); 
			pushFollow(FOLLOW_literal_in_waitfor1112);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:146:1: action returns [Abstract_Action a] : ( (a1= atom PLUS a2= atom EQ_ASSGN v= var ) | ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred );
	public final Abstract_Action action() throws RecognitionException {
		Abstract_Action a = null;


		Abstract_NumberTerm a1 =null;
		Abstract_NumberTerm a2 =null;
		Abstract_VarTerm v =null;
		Abstract_Literal an =null;
		int p =0;
		Abstract_Predicate t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:146:36: ( (a1= atom PLUS a2= atom EQ_ASSGN v= var ) | ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred )
			int alt30=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
			case OPEN:
				{
				alt30=1;
				}
				break;
			case VAR:
				{
				int LA30_3 = input.LA(2);
				if ( (LA30_3==PLUS) ) {
					alt30=1;
				}
				else if ( (LA30_3==COMMA||LA30_3==SEMI) ) {
					alt30=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 30, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case SEND:
				{
				alt30=2;
				}
				break;
			case CONST:
				{
				alt30=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}
			switch (alt30) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:147:2: (a1= atom PLUS a2= atom EQ_ASSGN v= var )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:147:2: (a1= atom PLUS a2= atom EQ_ASSGN v= var )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:147:3: a1= atom PLUS a2= atom EQ_ASSGN v= var
					{
					pushFollow(FOLLOW_atom_in_action1131);
					a1=atom();
					state._fsp--;

					match(input,PLUS,FOLLOW_PLUS_in_action1133); 
					pushFollow(FOLLOW_atom_in_action1137);
					a2=atom();
					state._fsp--;

					match(input,EQ_ASSGN,FOLLOW_EQ_ASSGN_in_action1139); 
					pushFollow(FOLLOW_var_in_action1143);
					v=var();
					state._fsp--;

					a = new Abstract_Action("sum"); a.addTerm(a1); a.addTerm(a2); a.addTerm(v); 
					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:148:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:148:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:148:3: SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE
					{
					match(input,SEND,FOLLOW_SEND_in_action1152); 
					match(input,OPEN,FOLLOW_OPEN_in_action1154); 
					pushFollow(FOLLOW_literal_in_action1158);
					an=literal();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_action1160); 
					pushFollow(FOLLOW_performative_in_action1164);
					p=performative();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_action1166); 
					pushFollow(FOLLOW_pred_in_action1170);
					t=pred();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_action1172); 
					a = new Abstract_SendAction(an, p, t);
					}

					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:149:2: t= pred
					{
					pushFollow(FOLLOW_pred_in_action1183);
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



	// $ANTLR start "performative"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:151:1: performative returns [int b] : ( TELL | PERFORM | ACHIEVE ) ;
	public final int performative() throws RecognitionException {
		int b = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:151:30: ( ( TELL | PERFORM | ACHIEVE ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:151:32: ( TELL | PERFORM | ACHIEVE )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:151:32: ( TELL | PERFORM | ACHIEVE )
			int alt31=3;
			switch ( input.LA(1) ) {
			case TELL:
				{
				alt31=1;
				}
				break;
			case PERFORM:
				{
				alt31=2;
				}
				break;
			case ACHIEVE:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:151:33: TELL
					{
					match(input,TELL,FOLLOW_TELL_in_performative1198); 
					b =1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:151:48: PERFORM
					{
					match(input,PERFORM,FOLLOW_PERFORM_in_performative1204); 
					b =2;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:151:66: ACHIEVE
					{
					match(input,ACHIEVE,FOLLOW_ACHIEVE_in_performative1210); 
					b = 3;
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



	// $ANTLR start "environment"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:187:1: environment returns [String env] : w= classpath ;
	public final String environment() throws RecognitionException {
		String env = null;


		String w =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:187:34: (w= classpath )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:187:36: w= classpath
			{
			pushFollow(FOLLOW_classpath_in_environment1459);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
	public final String classpath() throws RecognitionException {
		String s = null;


		String w =null;
		String w1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:30: (w= word ( POINT w1= word )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:32: w= word ( POINT w1= word )+
			{
			pushFollow(FOLLOW_word_in_classpath1474);
			w=word();
			state._fsp--;

			s = w;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:52: ( POINT w1= word )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:188:53: POINT w1= word
					{
					match(input,POINT,FOLLOW_POINT_in_classpath1479); 
					pushFollow(FOLLOW_word_in_classpath1483);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:25: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:27: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:27: ( CONST | VAR )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:28: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_word1584); 
					s =CONST1.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:189:59: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_word1590); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:191:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
	public final Abstract_StringTerm agentnameterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token CONST3=null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:191:47: ( CONST |v= var )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:191:49: CONST
					{
					CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm1690); 
					s = new Abstract_StringTermImpl(CONST3.getText());
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:191:111: v= var
					{
					pushFollow(FOLLOW_var_in_agentnameterm1698);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:194:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
	public final Abstract_Literal literal() throws RecognitionException {
		Abstract_Literal l = null;


		Abstract_Predicate nt =null;
		Abstract_Predicate t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:194:37: ( ( TRUE | NOT nt= pred ) |t= pred )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:194:40: ( TRUE | NOT nt= pred )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:194:40: ( TRUE | NOT nt= pred )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:194:41: TRUE
							{
							match(input,TRUE,FOLLOW_TRUE_in_literal1714); 
							l = new Abstract_Literal(Abstract_Literal.LTrue);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:195:5: NOT nt= pred
							{
							match(input,NOT,FOLLOW_NOT_in_literal1725); 
							pushFollow(FOLLOW_pred_in_literal1729);
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:199:5: t= pred
					{
					pushFollow(FOLLOW_pred_in_literal1743);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:203:1: pred returns [Abstract_Predicate t] : (v= var |f= function );
	public final Abstract_Predicate pred() throws RecognitionException {
		Abstract_Predicate t = null;


		Abstract_VarTerm v =null;
		Abstract_Predicate f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:203:37: (v= var |f= function )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:203:39: v= var
					{
					pushFollow(FOLLOW_var_in_pred1759);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:203:59: f= function
					{
					pushFollow(FOLLOW_function_in_pred1766);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:204:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
	public final Abstract_Predicate function() throws RecognitionException {
		Abstract_Predicate f = null;


		Token CONST4=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:204:40: ( CONST ( OPEN terms[$f] CLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:204:42: CONST ( OPEN terms[$f] CLOSE )?
			{
			CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_function1778); 
			f = new Abstract_Predicate(CONST4.getText());
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:204:97: ( OPEN terms[$f] CLOSE )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==OPEN) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:204:98: OPEN terms[$f] CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function1783); 
					pushFollow(FOLLOW_terms_in_function1785);
					terms(f);
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_function1788); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:206:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
	public final void terms(Abstract_Predicate f) throws RecognitionException {
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:206:29: (t= term ( COMMA terms[$f] )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:206:31: t= term ( COMMA terms[$f] )?
			{
			pushFollow(FOLLOW_term_in_terms1801);
			t=term();
			state._fsp--;

			f.addTerm(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:206:58: ( COMMA terms[$f] )?
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==COMMA) ) {
				alt39=1;
			}
			switch (alt39) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:206:59: COMMA terms[$f]
					{
					match(input,COMMA,FOLLOW_COMMA_in_terms1806); 
					pushFollow(FOLLOW_terms_in_terms1808);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:207:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |f= function );
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_NumberTerm a =null;
		Abstract_StringTerm s =null;
		Abstract_Predicate f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:207:31: (a= atom |s= stringterm |f= function )
			int alt40=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
			case OPEN:
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
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}
			switch (alt40) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:207:34: a= atom
					{
					pushFollow(FOLLOW_atom_in_term1827);
					a=atom();
					state._fsp--;

					t = a;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:207:58: s= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term1837);
					s=stringterm();
					state._fsp--;

					t = s;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:207:88: f= function
					{
					pushFollow(FOLLOW_function_in_term1845);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:209:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
	public final Abstract_NumberTerm atom() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;
		Abstract_NumberTerm a =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:209:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
			int alt41=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
				{
				alt41=1;
				}
				break;
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:209:40: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom1863);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:210:6: v= var
					{
					pushFollow(FOLLOW_var_in_atom1876);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:210:27: OPEN a= arithexpr CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_atom1882); 
					pushFollow(FOLLOW_arithexpr_in_atom1886);
					a=arithexpr();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_atom1888); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:211:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING5=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:211:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:211:46: DOUBLEQUOTE STRING DOUBLEQUOTE
			{
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1901); 
			STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm1904); 
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1906); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:213:1: var returns [Abstract_VarTerm v] : VAR ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR6=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:213:34: ( VAR )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:213:36: VAR
			{
			VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_var1920); 

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
			{
			s = "";
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:46: ( MINUS )?
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==MINUS) ) {
				alt42=1;
			}
			switch (alt42) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:47: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring1937); 
					s += "-";
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:68: (n1= NUMBER ( POINT n2= NUMBER )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:69: n1= NUMBER ( POINT n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1946); 
			s += n1.getText();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:223:6: ( POINT n2= NUMBER )?
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==POINT) ) {
				alt43=1;
			}
			switch (alt43) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:223:7: POINT n2= NUMBER
					{
					match(input,POINT,FOLLOW_POINT_in_numberstring1956); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1962); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:224:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation eq = null;


		Abstract_NumberTerm a1 =null;
		int oper =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:224:40: (a1= arithexpr oper= eqoper a2= arithexpr )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:224:42: a1= arithexpr oper= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation1979);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation1983);
			oper=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation1987);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:1: eqoper returns [int oper] : ( LESS | EQ );
	public final int eqoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:27: ( LESS | EQ )
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==LESS) ) {
				alt44=1;
			}
			else if ( (LA44_0==EQ) ) {
				alt44=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}

			switch (alt44) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:29: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2001); 
					oper =Abstract_Equation.less;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:68: EQ
					{
					match(input,EQ,FOLLOW_EQ_in_eqoper2007); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:227:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm m =null;
		int oper =0;
		Abstract_NumberTerm m1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:227:43: (m= multexpr (oper= addoper m1= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:227:45: m= multexpr (oper= addoper m1= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr2023);
			m=multexpr();
			state._fsp--;

			t = m;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:227:69: (oper= addoper m1= multexpr )?
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==MINUS||LA45_0==PLUS) ) {
				alt45=1;
			}
			switch (alt45) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:227:71: oper= addoper m1= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr2031);
					oper=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr2035);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm a =null;
		int oper =0;
		Abstract_NumberTerm a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:42: (a= atom (oper= multoper a1= atom )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:44: a= atom (oper= multoper a1= atom )?
			{
			pushFollow(FOLLOW_atom_in_multexpr2052);
			a=atom();
			state._fsp--;

			t = a;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:64: (oper= multoper a1= atom )?
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==DIV||(LA46_0 >= MOD && LA46_0 <= MULT)) ) {
				alt46=1;
			}
			switch (alt46) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:65: oper= multoper a1= atom
					{
					pushFollow(FOLLOW_multoper_in_multexpr2059);
					oper=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_in_multexpr2063);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:230:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:230:28: ( ( PLUS | MINUS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:230:30: ( PLUS | MINUS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:230:30: ( PLUS | MINUS )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:230:31: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper2080); 
					oper =Abstract_ArithExpr.plus;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:230:70: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper2085); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:231:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
	public final int multoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:231:29: ( ( MULT | DIV | MOD ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:231:31: ( MULT | DIV | MOD )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:231:31: ( MULT | DIV | MOD )
			int alt48=3;
			switch ( input.LA(1) ) {
			case MULT:
				{
				alt48=1;
				}
				break;
			case DIV:
				{
				alt48=2;
				}
				break;
			case MOD:
				{
				alt48=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}
			switch (alt48) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:231:32: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper2100); 
					oper =Abstract_ArithExpr.times;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:231:73: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper2106); 
					oper =Abstract_ArithExpr.div;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:231:111: MOD
					{
					match(input,MOD,FOLLOW_MOD_in_multoper2112); 
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



	public static final BitSet FOLLOW_eassagents_in_mas89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EASS_in_eassagents102 = new BitSet(new long[]{0x0000000100000010L});
	public static final BitSet FOLLOW_eassagent_in_eassagents111 = new BitSet(new long[]{0x0000000100000012L});
	public static final BitSet FOLLOW_NAME_in_eassagent130 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_word_in_eassagent134 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ABSTRACTION_in_eassagent141 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_word_in_eassagent145 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_BELIEFS_in_eassagent157 = new BitSet(new long[]{0x0140000402010080L});
	public static final BitSet FOLLOW_literal_in_eassagent162 = new BitSet(new long[]{0x0140000402010080L});
	public static final BitSet FOLLOW_BELIEFRULES_in_eassagent170 = new BitSet(new long[]{0x0100000002010000L});
	public static final BitSet FOLLOW_brule_in_eassagent175 = new BitSet(new long[]{0x0100000002010000L});
	public static final BitSet FOLLOW_GOALS_in_eassagent184 = new BitSet(new long[]{0x0140008400010000L});
	public static final BitSet FOLLOW_goal_in_eassagent189 = new BitSet(new long[]{0x0140008400010000L});
	public static final BitSet FOLLOW_PLANS_in_eassagent196 = new BitSet(new long[]{0x0000010020000002L});
	public static final BitSet FOLLOW_plan_in_eassagent201 = new BitSet(new long[]{0x0000010020000002L});
	public static final BitSet FOLLOW_literal_in_goal221 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_SQOPEN_in_goal223 = new BitSet(new long[]{0x0000004000000040L});
	public static final BitSet FOLLOW_ACHIEVEGOAL_in_goal226 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_PERFORMGOAL_in_goal234 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_goal239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_event_in_plan255 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_COLON_in_plan263 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_plan265 = new BitSet(new long[]{0x0141001C21000200L});
	public static final BitSet FOLLOW_NOT_in_plan270 = new BitSet(new long[]{0x0141001821000200L});
	public static final BitSet FOLLOW_guard_atom_in_plan278 = new BitSet(new long[]{0x0000000000024000L});
	public static final BitSet FOLLOW_COMMA_in_plan286 = new BitSet(new long[]{0x0141001C21000200L});
	public static final BitSet FOLLOW_NOT_in_plan291 = new BitSet(new long[]{0x0141001821000200L});
	public static final BitSet FOLLOW_guard_atom_in_plan299 = new BitSet(new long[]{0x0000000000024000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_plan305 = new BitSet(new long[]{0x0000600000000000L});
	public static final BitSet FOLLOW_RULEARROW_in_plan308 = new BitSet(new long[]{0x03808918A0010800L});
	public static final BitSet FOLLOW_deed_in_plan313 = new BitSet(new long[]{0x0000400000004000L});
	public static final BitSet FOLLOW_COMMA_in_plan319 = new BitSet(new long[]{0x03808918A0010800L});
	public static final BitSet FOLLOW_deed_in_plan323 = new BitSet(new long[]{0x0000400000004000L});
	public static final BitSet FOLLOW_SEMI_in_plan334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_event350 = new BitSet(new long[]{0x0142100400010000L});
	public static final BitSet FOLLOW_RECEIVED_in_event353 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_OPEN_in_event355 = new BitSet(new long[]{0x0020002000000020L});
	public static final BitSet FOLLOW_performative_in_event359 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COMMA_in_event361 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_pred_in_event365 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CLOSE_in_event367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_event385 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_event395 = new BitSet(new long[]{0x0140000400010000L});
	public static final BitSet FOLLOW_goal_in_event399 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_event413 = new BitSet(new long[]{0x0142000400010000L});
	public static final BitSet FOLLOW_literal_in_event418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_event428 = new BitSet(new long[]{0x0140000400010000L});
	public static final BitSet FOLLOW_goal_in_event432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BELIEVE_in_guard_atom453 = new BitSet(new long[]{0x0140000400010000L});
	public static final BitSet FOLLOW_literal_in_guard_atom457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_guard_atom467 = new BitSet(new long[]{0x0140000400010000L});
	public static final BitSet FOLLOW_goal_in_guard_atom471 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SENT_in_guard_atom481 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_OPEN_in_guard_atom483 = new BitSet(new long[]{0x0100000000100000L});
	public static final BitSet FOLLOW_stringterm_in_guard_atom490 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_var_in_guard_atom498 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom503 = new BitSet(new long[]{0x0020002000100020L});
	public static final BitSet FOLLOW_stringterm_in_guard_atom510 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom518 = new BitSet(new long[]{0x0020002000000020L});
	public static final BitSet FOLLOW_performative_in_guard_atom526 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom534 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_pred_in_guard_atom538 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CLOSE_in_guard_atom540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_guard_atom554 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_guard_atom564 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_deed588 = new BitSet(new long[]{0x0142000410010000L});
	public static final BitSet FOLLOW_literal_in_deed593 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_deed603 = new BitSet(new long[]{0x0140000400010000L});
	public static final BitSet FOLLOW_goal_in_deed607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOCK_in_deed617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_deed630 = new BitSet(new long[]{0x0142000410010000L});
	public static final BitSet FOLLOW_literal_in_deed635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_deed645 = new BitSet(new long[]{0x0140000400010000L});
	public static final BitSet FOLLOW_goal_in_deed649 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOCK_in_deed659 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_deed676 = new BitSet(new long[]{0x0140000400010000L});
	public static final BitSet FOLLOW_literal_in_deed681 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CALCULATE_in_deed692 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_calculation_in_deed696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QUERYCOM_in_deed707 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_query_in_deed711 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WAIT_in_deed722 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_wait_in_deed726 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_deed739 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_waitfor_in_deed752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_calculation782 = new BitSet(new long[]{0x0140000400010000L});
	public static final BitSet FOLLOW_literal_in_calculation788 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COMMA_in_calculation790 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_var_in_calculation794 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CLOSE_in_calculation796 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_query814 = new BitSet(new long[]{0x0140000400010000L});
	public static final BitSet FOLLOW_literal_in_query820 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CLOSE_in_query823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_wait841 = new BitSet(new long[]{0x0100001820110000L});
	public static final BitSet FOLLOW_term_in_wait847 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COMMA_in_wait849 = new BitSet(new long[]{0x0140000400010000L});
	public static final BitSet FOLLOW_literal_in_wait853 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CLOSE_in_wait855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_brule877 = new BitSet(new long[]{0x0000400000000400L});
	public static final BitSet FOLLOW_BRULEARROW_in_brule880 = new BitSet(new long[]{0x0100000400010000L});
	public static final BitSet FOLLOW_logicalfmla_in_brule884 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_brule888 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMI_in_brule892 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla909 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_COMMA_in_logicalfmla929 = new BitSet(new long[]{0x0100000400010000L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla933 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_pred_in_notfmla968 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_notfmla1053 = new BitSet(new long[]{0x0100001000010000L});
	public static final BitSet FOLLOW_pred_in_notfmla1060 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subfmla_in_notfmla1070 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_subfmla1084 = new BitSet(new long[]{0x0100000400010000L});
	public static final BitSet FOLLOW_logicalfmla_in_subfmla1090 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CLOSE_in_subfmla1094 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_waitfor1108 = new BitSet(new long[]{0x0140000400010000L});
	public static final BitSet FOLLOW_literal_in_waitfor1112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_action1131 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_PLUS_in_action1133 = new BitSet(new long[]{0x0100001820000000L});
	public static final BitSet FOLLOW_atom_in_action1137 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_EQ_ASSGN_in_action1139 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_var_in_action1143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEND_in_action1152 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_OPEN_in_action1154 = new BitSet(new long[]{0x0140000400010000L});
	public static final BitSet FOLLOW_literal_in_action1158 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COMMA_in_action1160 = new BitSet(new long[]{0x0020002000000020L});
	public static final BitSet FOLLOW_performative_in_action1164 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COMMA_in_action1166 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_pred_in_action1170 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CLOSE_in_action1172 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_action1183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TELL_in_performative1198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PERFORM_in_performative1204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACHIEVE_in_performative1210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_classpath_in_environment1459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_classpath1474 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_POINT_in_classpath1479 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_word_in_classpath1483 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_CONST_in_word1584 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word1590 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_agentnameterm1690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_agentnameterm1698 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_literal1714 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_literal1725 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_pred_in_literal1729 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_literal1743 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_pred1759 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_pred1766 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function1778 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_OPEN_in_function1783 = new BitSet(new long[]{0x0100001820110000L});
	public static final BitSet FOLLOW_terms_in_function1785 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CLOSE_in_function1788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_terms1801 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_COMMA_in_terms1806 = new BitSet(new long[]{0x0100001820110000L});
	public static final BitSet FOLLOW_terms_in_terms1808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_term1827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_term1837 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_term1845 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom1863 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom1876 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom1882 = new BitSet(new long[]{0x0100001820000000L});
	public static final BitSet FOLLOW_arithexpr_in_atom1886 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CLOSE_in_atom1888 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1901 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STRING_in_stringterm1904 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1906 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var1920 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring1937 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring1946 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_POINT_in_numberstring1956 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring1962 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation1979 = new BitSet(new long[]{0x0000000004400000L});
	public static final BitSet FOLLOW_eqoper_in_equation1983 = new BitSet(new long[]{0x0100001820000000L});
	public static final BitSet FOLLOW_arithexpr_in_equation1987 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2001 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_eqoper2007 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2023 = new BitSet(new long[]{0x0000010020000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr2031 = new BitSet(new long[]{0x0100001820000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2035 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_multexpr2052 = new BitSet(new long[]{0x00000000C0080002L});
	public static final BitSet FOLLOW_multoper_in_multexpr2059 = new BitSet(new long[]{0x0100001820000000L});
	public static final BitSet FOLLOW_atom_in_multexpr2063 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper2080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper2085 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper2100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper2106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_multoper2112 = new BitSet(new long[]{0x0000000000000002L});
}
