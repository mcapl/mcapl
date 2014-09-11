// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g 2014-09-11 16:40:25

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
		"ARROW", "BELIEFRULES", "BELIEFS", "BELIEVE", "BRULEARROW", "CALCULATE", 
		"CAPABILITIES", "CAPABILITY", "CLOSE", "COLON", "COMMA", "COMMENT", "CONST", 
		"CURLYCLOSE", "CURLYOPEN", "DIV", "DOUBLEQUOTE", "EASS", "EQ", "EQ_ASSGN", 
		"GOAL", "GOALS", "IMPLICATION", "LESS", "LINE_COMMENT", "LOCK", "MINUS", 
		"MOD", "MULT", "NAME", "NEWLINE", "NOT", "NUMBER", "OPEN", "PERFORM", 
		"PERFORMGOAL", "PLAN", "PLANS", "PLUS", "POINT", "QUERY", "QUERYCOM", 
		"RECEIVED", "RULEARROW", "SEMI", "SEND", "SENT", "SHRIEK", "SQCLOSE", 
		"SQOPEN", "STRING", "SUBSTITUTE", "TELL", "TRUE", "UPDATE", "VAR", "WAIT", 
		"WS"
	};
	public static final int EOF=-1;
	public static final int ABSTRACTION=4;
	public static final int ACHIEVE=5;
	public static final int ACHIEVEGOAL=6;
	public static final int ARROW=7;
	public static final int BELIEFRULES=8;
	public static final int BELIEFS=9;
	public static final int BELIEVE=10;
	public static final int BRULEARROW=11;
	public static final int CALCULATE=12;
	public static final int CAPABILITIES=13;
	public static final int CAPABILITY=14;
	public static final int CLOSE=15;
	public static final int COLON=16;
	public static final int COMMA=17;
	public static final int COMMENT=18;
	public static final int CONST=19;
	public static final int CURLYCLOSE=20;
	public static final int CURLYOPEN=21;
	public static final int DIV=22;
	public static final int DOUBLEQUOTE=23;
	public static final int EASS=24;
	public static final int EQ=25;
	public static final int EQ_ASSGN=26;
	public static final int GOAL=27;
	public static final int GOALS=28;
	public static final int IMPLICATION=29;
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
	public static final int PLAN=43;
	public static final int PLANS=44;
	public static final int PLUS=45;
	public static final int POINT=46;
	public static final int QUERY=47;
	public static final int QUERYCOM=48;
	public static final int RECEIVED=49;
	public static final int RULEARROW=50;
	public static final int SEMI=51;
	public static final int SEND=52;
	public static final int SENT=53;
	public static final int SHRIEK=54;
	public static final int SQCLOSE=55;
	public static final int SQOPEN=56;
	public static final int STRING=57;
	public static final int SUBSTITUTE=58;
	public static final int TELL=59;
	public static final int TRUE=60;
	public static final int UPDATE=61;
	public static final int VAR=62;
	public static final int WAIT=63;
	public static final int WS=64;

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:65:1: eassagent returns [Abstract_EASSAgent g] : ( NAME w= word | ABSTRACTION w= word ) BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? ( CAPABILITIES (c= capability )* )? GOALS (gl= goal )* PLANS (p= plan )* ;
	public final Abstract_EASSAgent eassagent() throws RecognitionException {
		Abstract_EASSAgent g = null;


		String w =null;
		Abstract_Literal l =null;
		Abstract_Rule r =null;
		Abstract_Capability c =null;
		Abstract_Goal gl =null;
		Abstract_GPlan p =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:65:42: ( ( NAME w= word | ABSTRACTION w= word ) BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? ( CAPABILITIES (c= capability )* )? GOALS (gl= goal )* PLANS (p= plan )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:66:2: ( NAME w= word | ABSTRACTION w= word ) BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? ( CAPABILITIES (c= capability )* )? GOALS (gl= goal )* PLANS (p= plan )*
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

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:72:2: ( CAPABILITIES (c= capability )* )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==CAPABILITIES) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:72:3: CAPABILITIES (c= capability )*
					{
					match(input,CAPABILITIES,FOLLOW_CAPABILITIES_in_eassagent185); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:72:16: (c= capability )*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==CURLYOPEN) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:72:17: c= capability
							{
							pushFollow(FOLLOW_capability_in_eassagent190);
							c=capability();
							state._fsp--;

							g.addCap(c);
							}
							break;

						default :
							break loop6;
						}
					}

					}
					break;

			}

			match(input,GOALS,FOLLOW_GOALS_in_eassagent199); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:73:8: (gl= goal )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==CONST||LA8_0==NOT||LA8_0==TRUE||LA8_0==VAR) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:73:9: gl= goal
					{
					pushFollow(FOLLOW_goal_in_eassagent204);
					gl=goal();
					state._fsp--;

					g.addInitialGoal(gl);
					}
					break;

				default :
					break loop8;
				}
			}

			match(input,PLANS,FOLLOW_PLANS_in_eassagent211); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:74:8: (p= plan )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==MINUS||LA9_0==PLUS) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:74:9: p= plan
					{
					pushFollow(FOLLOW_plan_in_eassagent216);
					p=plan();
					state._fsp--;

					try {g.addPlan(p);} catch (Exception e) {System.err.println(e);}
					}
					break;

				default :
					break loop9;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:77:1: goal returns [Abstract_Goal g] : l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE ;
	public final Abstract_Goal goal() throws RecognitionException {
		Abstract_Goal g = null;


		Abstract_Literal l =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:77:32: (l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:77:34: l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE
			{
			pushFollow(FOLLOW_literal_in_goal236);
			l=literal();
			state._fsp--;

			match(input,SQOPEN,FOLLOW_SQOPEN_in_goal238); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:77:51: ( ACHIEVEGOAL | PERFORMGOAL )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:77:52: ACHIEVEGOAL
					{
					match(input,ACHIEVEGOAL,FOLLOW_ACHIEVEGOAL_in_goal241); 
					g = new Abstract_Goal(l, Abstract_Goal.achieveGoal);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:78:2: PERFORMGOAL
					{
					match(input,PERFORMGOAL,FOLLOW_PERFORMGOAL_in_goal249); 
					g = new Abstract_Goal(l, Abstract_Goal.performGoal);
					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_goal254); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:80:1: capability returns [Abstract_Capability c] : CURLYOPEN (pre= clogicalfmla )? CURLYCLOSE cap= pred CURLYOPEN post= clogicalfmla CURLYCLOSE ;
	public final Abstract_Capability capability() throws RecognitionException {
		Abstract_Capability c = null;


		Abstract_GLogicalFormula pre =null;
		Abstract_Predicate cap =null;
		Abstract_GLogicalFormula post =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:80:44: ( CURLYOPEN (pre= clogicalfmla )? CURLYCLOSE cap= pred CURLYOPEN post= clogicalfmla CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:81:2: CURLYOPEN (pre= clogicalfmla )? CURLYCLOSE cap= pred CURLYOPEN post= clogicalfmla CURLYCLOSE
			{
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_capability269); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:81:12: (pre= clogicalfmla )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==CONST||LA11_0==NOT||LA11_0==VAR) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:81:13: pre= clogicalfmla
					{
					pushFollow(FOLLOW_clogicalfmla_in_capability274);
					pre=clogicalfmla();
					state._fsp--;

					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_capability278); 
			pushFollow(FOLLOW_pred_in_capability284);
			cap=pred();
			state._fsp--;

			c = new Abstract_Capability(cap); if (pre != null) {c.addPre(pre);}
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_capability289); 
			pushFollow(FOLLOW_clogicalfmla_in_capability293);
			post=clogicalfmla();
			state._fsp--;

			c.addPost(post);
			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_capability297); 
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



	// $ANTLR start "plan"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:86:1: plan returns [Abstract_GPlan p] : e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )* )? SEMI ;
	public final Abstract_GPlan plan() throws RecognitionException {
		Abstract_GPlan p = null;


		Abstract_Event e =null;
		Abstract_GLogicalFormula gb =null;
		Abstract_Deed d =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:87:2: (e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )* )? SEMI )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:87:4: e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )* )? SEMI
			{
			pushFollow(FOLLOW_event_in_plan313);
			e=event();
			state._fsp--;

			ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();
			match(input,COLON,FOLLOW_COLON_in_plan321); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_plan323); 
			boolean gneg=true;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:88:40: ( NOT )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==NOT) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:88:41: NOT
					{
					match(input,NOT,FOLLOW_NOT_in_plan328); 
					gneg=false;
					}
					break;

			}

			pushFollow(FOLLOW_guard_atom_in_plan336);
			gb=guard_atom();
			state._fsp--;

			g.add(gb, gneg);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:3: ( COMMA ( NOT )? gb= guard_atom )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==COMMA) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:4: COMMA ( NOT )? gb= guard_atom
					{
					match(input,COMMA,FOLLOW_COMMA_in_plan344); 
					gneg=true;
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:23: ( NOT )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==NOT) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:24: NOT
							{
							match(input,NOT,FOLLOW_NOT_in_plan349); 
							gneg=false;
							}
							break;

					}

					pushFollow(FOLLOW_guard_atom_in_plan357);
					gb=guard_atom();
					state._fsp--;

					g.add(gb, gneg);
					}
					break;

				default :
					break loop14;
				}
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_plan363); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:93: ( RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )* )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==RULEARROW) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:94: RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )*
					{
					match(input,RULEARROW,FOLLOW_RULEARROW_in_plan366); 
					pushFollow(FOLLOW_deed_in_plan371);
					d=deed(deeds);
					state._fsp--;

					deeds.add(d);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:90:35: ( ',' d= deed[deeds] )*
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( (LA15_0==COMMA) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:90:36: ',' d= deed[deeds]
							{
							match(input,COMMA,FOLLOW_COMMA_in_plan377); 
							pushFollow(FOLLOW_deed_in_plan381);
							d=deed(deeds);
							state._fsp--;

							deeds.add(d);
							}
							break;

						default :
							break loop15;
						}
					}

					}
					break;

			}

			match(input,SEMI,FOLLOW_SEMI_in_plan392); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:1: event returns [Abstract_Event e] : ( PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) ) ;
	public final Abstract_Event event() throws RecognitionException {
		Abstract_Event e = null;


		int p =0;
		Abstract_Predicate t =null;
		Abstract_Literal l =null;
		Abstract_Goal g =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:34: ( ( PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:36: ( PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:36: ( PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:37: PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) )
					{
					match(input,PLUS,FOLLOW_PLUS_in_event408); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:42: ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) )
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==RECEIVED) ) {
						alt18=1;
					}
					else if ( (LA18_0==CONST||LA18_0==NOT||LA18_0==SHRIEK||LA18_0==TRUE||LA18_0==VAR) ) {
						alt18=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 18, 0, input);
						throw nvae;
					}

					switch (alt18) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:43: RECEIVED OPEN p= performative ',' t= pred ')'
							{
							match(input,RECEIVED,FOLLOW_RECEIVED_in_event411); 
							match(input,OPEN,FOLLOW_OPEN_in_event413); 
							pushFollow(FOLLOW_performative_in_event417);
							p=performative();
							state._fsp--;

							match(input,COMMA,FOLLOW_COMMA_in_event419); 
							pushFollow(FOLLOW_pred_in_event423);
							t=pred();
							state._fsp--;

							match(input,CLOSE,FOLLOW_CLOSE_in_event425); 
							Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), 
												new Abstract_VarTerm("To"), p, t); 
												e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILReceived, message);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:97:5: (l= literal | SHRIEK g= goal )
							{
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:97:5: (l= literal | SHRIEK g= goal )
							int alt17=2;
							int LA17_0 = input.LA(1);
							if ( (LA17_0==CONST||LA17_0==NOT||LA17_0==TRUE||LA17_0==VAR) ) {
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
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:97:6: l= literal
									{
									pushFollow(FOLLOW_literal_in_event443);
									l=literal();
									state._fsp--;

									e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, l);
									}
									break;
								case 2 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:98:5: SHRIEK g= goal
									{
									match(input,SHRIEK,FOLLOW_SHRIEK_in_event453); 
									pushFollow(FOLLOW_goal_in_event457);
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:99:7: MINUS (l= literal | SHRIEK g= goal )
					{
					match(input,MINUS,FOLLOW_MINUS_in_event471); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:99:13: (l= literal | SHRIEK g= goal )
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==CONST||LA19_0==NOT||LA19_0==TRUE||LA19_0==VAR) ) {
						alt19=1;
					}
					else if ( (LA19_0==SHRIEK) ) {
						alt19=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 19, 0, input);
						throw nvae;
					}

					switch (alt19) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:99:14: l= literal
							{
							pushFollow(FOLLOW_literal_in_event476);
							l=literal();
							state._fsp--;

							e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, l);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:100:5: SHRIEK g= goal
							{
							match(input,SHRIEK,FOLLOW_SHRIEK_in_event486); 
							pushFollow(FOLLOW_goal_in_event490);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:1: guard_atom returns [Abstract_GLogicalFormula g] : ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | PLAN OPEN (v= var |s= numberstring ) COMMA ga= pred COMMA c= pred COMMA post= pred CLOSE | TRUE ) ;
	public final Abstract_GLogicalFormula guard_atom() throws RecognitionException {
		Abstract_GLogicalFormula g = null;


		Abstract_Literal l =null;
		Abstract_Goal gl =null;
		Abstract_StringTerm st =null;
		Abstract_VarTerm v =null;
		Abstract_StringTerm an2 =null;
		int p =0;
		Abstract_Predicate t =null;
		Abstract_Equation eq =null;
		String s =null;
		Abstract_Predicate ga =null;
		Abstract_Predicate c =null;
		Abstract_Predicate post =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:49: ( ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | PLAN OPEN (v= var |s= numberstring ) COMMA ga= pred COMMA c= pred COMMA post= pred CLOSE | TRUE ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | PLAN OPEN (v= var |s= numberstring ) COMMA ga= pred COMMA c= pred COMMA post= pred CLOSE | TRUE )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | PLAN OPEN (v= var |s= numberstring ) COMMA ga= pred COMMA c= pred COMMA post= pred CLOSE | TRUE )
			int alt24=6;
			switch ( input.LA(1) ) {
			case BELIEVE:
				{
				alt24=1;
				}
				break;
			case GOAL:
				{
				alt24=2;
				}
				break;
			case SENT:
				{
				alt24=3;
				}
				break;
			case MINUS:
			case NUMBER:
			case OPEN:
			case VAR:
				{
				alt24=4;
				}
				break;
			case PLAN:
				{
				alt24=5;
				}
				break;
			case TRUE:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:52: BELIEVE l= literal
					{
					match(input,BELIEVE,FOLLOW_BELIEVE_in_guard_atom511); 
					pushFollow(FOLLOW_literal_in_guard_atom515);
					l=literal();
					state._fsp--;

					g = new Abstract_GBelief(l);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:103:5: GOAL gl= goal
					{
					match(input,GOAL,FOLLOW_GOAL_in_guard_atom525); 
					pushFollow(FOLLOW_goal_in_guard_atom529);
					gl=goal();
					state._fsp--;

					g = new Abstract_Goal(gl);
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:5: SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE
					{
					match(input,SENT,FOLLOW_SENT_in_guard_atom539); 
					match(input,OPEN,FOLLOW_OPEN_in_guard_atom541); 
					Abstract_StringTerm an1=agentname;
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:52: (st= stringterm |v= var )
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==DOUBLEQUOTE) ) {
						alt21=1;
					}
					else if ( (LA21_0==VAR) ) {
						alt21=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 21, 0, input);
						throw nvae;
					}

					switch (alt21) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:53: st= stringterm
							{
							pushFollow(FOLLOW_stringterm_in_guard_atom548);
							st=stringterm();
							state._fsp--;

							an1=st;
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:79: v= var
							{
							pushFollow(FOLLOW_var_in_guard_atom556);
							v=var();
							state._fsp--;

							an1 = v;
							}
							break;

					}

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom561); 
					Abstract_StringTerm agn = agentname;
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:142: (an2= stringterm COMMA )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0==DOUBLEQUOTE) ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:143: an2= stringterm COMMA
							{
							pushFollow(FOLLOW_stringterm_in_guard_atom568);
							an2=stringterm();
							state._fsp--;

							match(input,COMMA,FOLLOW_COMMA_in_guard_atom576); 
							agn = an2;
							}
							break;

					}

					pushFollow(FOLLOW_performative_in_guard_atom584);
					p=performative();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom592); 
					pushFollow(FOLLOW_pred_in_guard_atom596);
					t=pred();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_guard_atom598); 
					g = new Abstract_GuardMessage(Abstract_BaseAILStructure.AILSent, agn, an1, p, t);
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:107:5: eq= equation
					{
					pushFollow(FOLLOW_equation_in_guard_atom612);
					eq=equation();
					state._fsp--;

					g = eq;
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:110:5: PLAN OPEN (v= var |s= numberstring ) COMMA ga= pred COMMA c= pred COMMA post= pred CLOSE
					{
					match(input,PLAN,FOLLOW_PLAN_in_guard_atom632); 
					match(input,OPEN,FOLLOW_OPEN_in_guard_atom634); 
					Abstract_NumberTerm n=new Abstract_NumberTermImpl("0");
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:110:73: (v= var |s= numberstring )
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==VAR) ) {
						alt23=1;
					}
					else if ( (LA23_0==MINUS||LA23_0==NUMBER) ) {
						alt23=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 23, 0, input);
						throw nvae;
					}

					switch (alt23) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:110:74: v= var
							{
							pushFollow(FOLLOW_var_in_guard_atom641);
							v=var();
							state._fsp--;

							n = v;
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:110:93: s= numberstring
							{
							pushFollow(FOLLOW_numberstring_in_guard_atom648);
							s=numberstring();
							state._fsp--;

							n = new Abstract_NumberTermImpl(s);
							}
							break;

					}

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom653); 
					pushFollow(FOLLOW_pred_in_guard_atom701);
					ga=pred();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom703); 
					pushFollow(FOLLOW_pred_in_guard_atom752);
					c=pred();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom754); 
					pushFollow(FOLLOW_pred_in_guard_atom758);
					post=pred();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_guard_atom760); 
					g = new Abstract_GuardPlan(n, c, ga, post);
					}
					break;
				case 6 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:114:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_guard_atom817); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:1: deed[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : ( ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action ) |wf= waitfor | SUBSTITUTE s= substitution[ds] ) ;
	public final Abstract_Deed deed(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Literal l =null;
		Abstract_Goal g =null;
		Abstract_Predicate p =null;
		Abstract_Deed c =null;
		Abstract_Deed q =null;
		Abstract_Deed w =null;
		Abstract_Action a =null;
		Abstract_Literal wf =null;
		Abstract_Deed s =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:61: ( ( ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action ) |wf= waitfor | SUBSTITUTE s= substitution[ds] ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:63: ( ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action ) |wf= waitfor | SUBSTITUTE s= substitution[ds] )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:63: ( ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action ) |wf= waitfor | SUBSTITUTE s= substitution[ds] )
			int alt29=3;
			switch ( input.LA(1) ) {
			case CALCULATE:
			case CONST:
			case MINUS:
			case NUMBER:
			case OPEN:
			case PLUS:
			case QUERYCOM:
			case SEND:
			case UPDATE:
			case VAR:
			case WAIT:
				{
				alt29=1;
				}
				break;
			case MULT:
				{
				alt29=2;
				}
				break;
			case SUBSTITUTE:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:64: ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:64: ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action )
					int alt28=6;
					switch ( input.LA(1) ) {
					case PLUS:
						{
						alt28=1;
						}
						break;
					case MINUS:
						{
						int LA28_2 = input.LA(2);
						if ( (LA28_2==CONST||LA28_2==LOCK||LA28_2==NOT||LA28_2==PLAN||LA28_2==SHRIEK||LA28_2==TRUE||LA28_2==VAR) ) {
							alt28=1;
						}
						else if ( (LA28_2==NUMBER) ) {
							alt28=6;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 28, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case UPDATE:
						{
						alt28=2;
						}
						break;
					case CALCULATE:
						{
						alt28=3;
						}
						break;
					case QUERYCOM:
						{
						alt28=4;
						}
						break;
					case WAIT:
						{
						alt28=5;
						}
						break;
					case CONST:
					case NUMBER:
					case OPEN:
					case SEND:
					case VAR:
						{
						alt28=6;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 28, 0, input);
						throw nvae;
					}
					switch (alt28) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:65: ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) )
							{
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:65: ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) )
							int alt27=2;
							int LA27_0 = input.LA(1);
							if ( (LA27_0==PLUS) ) {
								alt27=1;
							}
							else if ( (LA27_0==MINUS) ) {
								alt27=2;
							}

							else {
								NoViableAltException nvae =
									new NoViableAltException("", 27, 0, input);
								throw nvae;
							}

							switch (alt27) {
								case 1 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:66: PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE )
									{
									match(input,PLUS,FOLLOW_PLUS_in_deed841); 
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:71: (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE )
									int alt25=4;
									switch ( input.LA(1) ) {
									case CONST:
									case NOT:
									case TRUE:
									case VAR:
										{
										alt25=1;
										}
										break;
									case SHRIEK:
										{
										alt25=2;
										}
										break;
									case LOCK:
										{
										alt25=3;
										}
										break;
									case PLAN:
										{
										alt25=4;
										}
										break;
									default:
										NoViableAltException nvae =
											new NoViableAltException("", 25, 0, input);
										throw nvae;
									}
									switch (alt25) {
										case 1 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:72: l= literal
											{
											pushFollow(FOLLOW_literal_in_deed846);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, l);
											}
											break;
										case 2 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:117:5: SHRIEK g= goal
											{
											match(input,SHRIEK,FOLLOW_SHRIEK_in_deed856); 
											pushFollow(FOLLOW_goal_in_deed860);
											g=goal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, g);
											}
											break;
										case 3 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:118:5: LOCK
											{
											match(input,LOCK,FOLLOW_LOCK_in_deed870); 
											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);
											}
											break;
										case 4 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:119:5: PLAN OPEN p= pred CLOSE
											{
											match(input,PLAN,FOLLOW_PLAN_in_deed879); 
											match(input,OPEN,FOLLOW_OPEN_in_deed881); 
											pushFollow(FOLLOW_pred_in_deed885);
											p=pred();
											state._fsp--;

											match(input,CLOSE,FOLLOW_CLOSE_in_deed887); 
											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.DPlan, p);
											}
											break;

									}

									}
									break;
								case 2 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:120:7: MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE )
									{
									match(input,MINUS,FOLLOW_MINUS_in_deed900); 
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:120:13: (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE )
									int alt26=4;
									switch ( input.LA(1) ) {
									case CONST:
									case NOT:
									case TRUE:
									case VAR:
										{
										alt26=1;
										}
										break;
									case SHRIEK:
										{
										alt26=2;
										}
										break;
									case LOCK:
										{
										alt26=3;
										}
										break;
									case PLAN:
										{
										alt26=4;
										}
										break;
									default:
										NoViableAltException nvae =
											new NoViableAltException("", 26, 0, input);
										throw nvae;
									}
									switch (alt26) {
										case 1 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:120:14: l= literal
											{
											pushFollow(FOLLOW_literal_in_deed905);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, l);
											}
											break;
										case 2 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:121:5: SHRIEK g= goal
											{
											match(input,SHRIEK,FOLLOW_SHRIEK_in_deed915); 
											pushFollow(FOLLOW_goal_in_deed919);
											g=goal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILDeletion, g);
											}
											break;
										case 3 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:122:5: LOCK
											{
											match(input,LOCK,FOLLOW_LOCK_in_deed929); 
											d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.Dlock);
											}
											break;
										case 4 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:123:5: PLAN OPEN p= pred CLOSE
											{
											match(input,PLAN,FOLLOW_PLAN_in_deed939); 
											match(input,OPEN,FOLLOW_OPEN_in_deed941); 
											pushFollow(FOLLOW_pred_in_deed945);
											p=pred();
											state._fsp--;

											match(input,CLOSE,FOLLOW_CLOSE_in_deed947); 
											d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.DPlan, p);
											}
											break;

									}

									}
									break;

							}

							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:125:5: UPDATE (l= literal )
							{
							match(input,UPDATE,FOLLOW_UPDATE_in_deed964); 
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:125:12: (l= literal )
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:125:13: l= literal
							{
							pushFollow(FOLLOW_literal_in_deed969);
							l=literal();
							state._fsp--;

							d = new Abstract_Deed(Abstract_Deed.AILUpdate, Abstract_Deed.AILBel, l);
							}

							}
							break;
						case 3 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:126:5: CALCULATE c= calculation[ds]
							{
							match(input,CALCULATE,FOLLOW_CALCULATE_in_deed980); 
							pushFollow(FOLLOW_calculation_in_deed984);
							c=calculation(ds);
							state._fsp--;

							d = c;
							}
							break;
						case 4 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:127:5: QUERYCOM q= query[ds]
							{
							match(input,QUERYCOM,FOLLOW_QUERYCOM_in_deed995); 
							pushFollow(FOLLOW_query_in_deed999);
							q=query(ds);
							state._fsp--;

							d = q;
							}
							break;
						case 5 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:128:5: WAIT w= wait[ds]
							{
							match(input,WAIT,FOLLOW_WAIT_in_deed1010); 
							pushFollow(FOLLOW_wait_in_deed1014);
							w=wait(ds);
							state._fsp--;

							d = w;
							}
							break;
						case 6 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:129:5: a= action
							{
							pushFollow(FOLLOW_action_in_deed1027);
							a=action();
							state._fsp--;

							d = new Abstract_Deed(a);
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:130:5: wf= waitfor
					{
					pushFollow(FOLLOW_waitfor_in_deed1040);
					wf=waitfor();
					state._fsp--;

					d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, wf);
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:131:5: SUBSTITUTE s= substitution[ds]
					{
					match(input,SUBSTITUTE,FOLLOW_SUBSTITUTE_in_deed1050); 
					pushFollow(FOLLOW_substitution_in_deed1054);
					s=substitution(ds);
					state._fsp--;

					d = s;
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



	// $ANTLR start "substitution"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:135:1: substitution[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN pl1= pred COMMA c1= pred COMMA c2= pred COMMA pl2= pred CLOSE ;
	public final Abstract_Deed substitution(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Predicate pl1 =null;
		Abstract_Predicate c1 =null;
		Abstract_Predicate c2 =null;
		Abstract_Predicate pl2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:135:69: ( OPEN pl1= pred COMMA c1= pred COMMA c2= pred COMMA pl2= pred CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:135:71: OPEN pl1= pred COMMA c1= pred COMMA c2= pred COMMA pl2= pred CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_substitution1085); 
			pushFollow(FOLLOW_pred_in_substitution1089);
			pl1=pred();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_substitution1091); 
			pushFollow(FOLLOW_pred_in_substitution1097);
			c1=pred();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_substitution1099); 
			pushFollow(FOLLOW_pred_in_substitution1104);
			c2=pred();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_substitution1106); 
			pushFollow(FOLLOW_pred_in_substitution1112);
			pl2=pred();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_substitution1114); 
			Abstract_Action a = new Abstract_Action("substitute"); a.addTerm(pl1); a.addTerm(c1); a.addTerm(c2); a.addTerm(pl2); d = new Abstract_Deed(a);
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
	// $ANTLR end "substitution"



	// $ANTLR start "calculation"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:138:1: calculation[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN l1= literal COMMA v= var CLOSE ;
	public final Abstract_Deed calculation(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Literal l1 =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:138:68: ( OPEN l1= literal COMMA v= var CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:138:70: OPEN l1= literal COMMA v= var CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_calculation1134); 
			pushFollow(FOLLOW_literal_in_calculation1140);
			l1=literal();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_calculation1142); 
			pushFollow(FOLLOW_var_in_calculation1146);
			v=var();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_calculation1148); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:143:1: query[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN l1= literal CLOSE ;
	public final Abstract_Deed query(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Literal l1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:143:62: ( OPEN l1= literal CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:143:64: OPEN l1= literal CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_query1166); 
			pushFollow(FOLLOW_literal_in_query1172);
			l1=literal();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_query1175); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:148:1: wait[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN l1= term COMMA l2= literal CLOSE ;
	public final Abstract_Deed wait(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Term l1 =null;
		Abstract_Literal l2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:148:61: ( OPEN l1= term COMMA l2= literal CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:148:63: OPEN l1= term COMMA l2= literal CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_wait1193); 
			pushFollow(FOLLOW_term_in_wait1199);
			l1=term();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_wait1201); 
			pushFollow(FOLLOW_literal_in_wait1205);
			l2=literal();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_wait1207); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:153:1: brule returns [Abstract_Rule r] : head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) ;
	public final Abstract_Rule brule() throws RecognitionException {
		Abstract_Rule r = null;


		Abstract_Predicate head =null;
		Abstract_LogicalFormula f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:153:33: (head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:153:35: head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI )
			{
			pushFollow(FOLLOW_pred_in_brule1229);
			head=pred();
			state._fsp--;

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:153:45: ( BRULEARROW f= logicalfmla SEMI | SEMI )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==BRULEARROW) ) {
				alt30=1;
			}
			else if ( (LA30_0==SEMI) ) {
				alt30=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:153:46: BRULEARROW f= logicalfmla SEMI
					{
					match(input,BRULEARROW,FOLLOW_BRULEARROW_in_brule1232); 
					pushFollow(FOLLOW_logicalfmla_in_brule1236);
					f=logicalfmla();
					state._fsp--;

					r = new Abstract_Rule(head, f);
					match(input,SEMI,FOLLOW_SEMI_in_brule1240); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:153:116: SEMI
					{
					match(input,SEMI,FOLLOW_SEMI_in_brule1244); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:155:1: logicalfmla returns [Abstract_LogicalFormula f] : n= notfmla ( COMMA n2= notfmla )* ;
	public final Abstract_LogicalFormula logicalfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula n =null;
		Abstract_LogicalFormula n2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:155:49: (n= notfmla ( COMMA n2= notfmla )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:155:51: n= notfmla ( COMMA n2= notfmla )*
			{
			pushFollow(FOLLOW_notfmla_in_logicalfmla1261);
			n=notfmla();
			state._fsp--;

			f = n;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:156:16: ( COMMA n2= notfmla )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==COMMA) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:156:17: COMMA n2= notfmla
					{
					match(input,COMMA,FOLLOW_COMMA_in_logicalfmla1281); 
					pushFollow(FOLLOW_notfmla_in_logicalfmla1285);
					n2=notfmla();
					state._fsp--;

					f = new Abstract_LogExpr(f, Abstract_LogExpr.and, n2);
					}
					break;

				default :
					break loop31;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:158:1: notfmla returns [Abstract_LogicalFormula f] : (gb= pred | NOT (gb2= pred |lf= subfmla ) );
	public final Abstract_LogicalFormula notfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_Predicate gb =null;
		Abstract_Predicate gb2 =null;
		Abstract_LogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:158:45: (gb= pred | NOT (gb2= pred |lf= subfmla ) )
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==CONST||LA33_0==VAR) ) {
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:158:47: gb= pred
					{
					pushFollow(FOLLOW_pred_in_notfmla1320);
					gb=pred();
					state._fsp--;

					f = gb;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:159:79: NOT (gb2= pred |lf= subfmla )
					{
					match(input,NOT,FOLLOW_NOT_in_notfmla1405); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:159:83: (gb2= pred |lf= subfmla )
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0==CONST||LA32_0==VAR) ) {
						alt32=1;
					}
					else if ( (LA32_0==OPEN) ) {
						alt32=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 32, 0, input);
						throw nvae;
					}

					switch (alt32) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:159:84: gb2= pred
							{
							pushFollow(FOLLOW_pred_in_notfmla1412);
							gb2=pred();
							state._fsp--;

							f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:159:153: lf= subfmla
							{
							pushFollow(FOLLOW_subfmla_in_notfmla1422);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:160:1: subfmla returns [Abstract_LogicalFormula f] : OPEN lf= logicalfmla CLOSE ;
	public final Abstract_LogicalFormula subfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:160:45: ( OPEN lf= logicalfmla CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:160:47: OPEN lf= logicalfmla CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_subfmla1436); 
			pushFollow(FOLLOW_logicalfmla_in_subfmla1442);
			lf=logicalfmla();
			state._fsp--;

			f = lf;
			match(input,CLOSE,FOLLOW_CLOSE_in_subfmla1446); 
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



	// $ANTLR start "clogicalfmla"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:162:1: clogicalfmla returns [Abstract_GLogicalFormula f] : n= cnotfmla ( COMMA n2= cnotfmla )* ;
	public final Abstract_GLogicalFormula clogicalfmla() throws RecognitionException {
		Abstract_GLogicalFormula f = null;


		Abstract_GLogicalFormula n =null;
		Abstract_GLogicalFormula n2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:162:51: (n= cnotfmla ( COMMA n2= cnotfmla )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:162:53: n= cnotfmla ( COMMA n2= cnotfmla )*
			{
			pushFollow(FOLLOW_cnotfmla_in_clogicalfmla1460);
			n=cnotfmla();
			state._fsp--;

			f = n;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:16: ( COMMA n2= cnotfmla )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==COMMA) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:17: COMMA n2= cnotfmla
					{
					match(input,COMMA,FOLLOW_COMMA_in_clogicalfmla1480); 
					pushFollow(FOLLOW_cnotfmla_in_clogicalfmla1484);
					n2=cnotfmla();
					state._fsp--;

					f = new Abstract_Guard(f, Abstract_Guard.and, n2);
					}
					break;

				default :
					break loop34;
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
	// $ANTLR end "clogicalfmla"



	// $ANTLR start "cnotfmla"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:165:1: cnotfmla returns [Abstract_GLogicalFormula f] : (gb= pred | NOT (gb2= pred |lf= csubfmla ) );
	public final Abstract_GLogicalFormula cnotfmla() throws RecognitionException {
		Abstract_GLogicalFormula f = null;


		Abstract_Predicate gb =null;
		Abstract_Predicate gb2 =null;
		Abstract_GLogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:165:47: (gb= pred | NOT (gb2= pred |lf= csubfmla ) )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==CONST||LA36_0==VAR) ) {
				alt36=1;
			}
			else if ( (LA36_0==NOT) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:165:49: gb= pred
					{
					pushFollow(FOLLOW_pred_in_cnotfmla1519);
					gb=pred();
					state._fsp--;

					f = new Abstract_GBelief(new Abstract_Literal(gb));
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:166:79: NOT (gb2= pred |lf= csubfmla )
					{
					match(input,NOT,FOLLOW_NOT_in_cnotfmla1604); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:166:83: (gb2= pred |lf= csubfmla )
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==CONST||LA35_0==VAR) ) {
						alt35=1;
					}
					else if ( (LA35_0==OPEN) ) {
						alt35=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 35, 0, input);
						throw nvae;
					}

					switch (alt35) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:166:84: gb2= pred
							{
							pushFollow(FOLLOW_pred_in_cnotfmla1611);
							gb2=pred();
							state._fsp--;

							f = new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal(gb2)));
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:167:79: lf= csubfmla
							{
							pushFollow(FOLLOW_csubfmla_in_cnotfmla1700);
							lf=csubfmla();
							state._fsp--;

							f = new Abstract_Guard(Abstract_Guard.not, lf);
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
	// $ANTLR end "cnotfmla"



	// $ANTLR start "csubfmla"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:168:1: csubfmla returns [Abstract_GLogicalFormula f] : OPEN lf= clogicalfmla CLOSE ;
	public final Abstract_GLogicalFormula csubfmla() throws RecognitionException {
		Abstract_GLogicalFormula f = null;


		Abstract_GLogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:168:47: ( OPEN lf= clogicalfmla CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:168:49: OPEN lf= clogicalfmla CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_csubfmla1714); 
			pushFollow(FOLLOW_clogicalfmla_in_csubfmla1720);
			lf=clogicalfmla();
			state._fsp--;

			f = lf;
			match(input,CLOSE,FOLLOW_CLOSE_in_csubfmla1724); 
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
	// $ANTLR end "csubfmla"



	// $ANTLR start "waitfor"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:171:1: waitfor returns [Abstract_Literal wf] : MULT l= literal ;
	public final Abstract_Literal waitfor() throws RecognitionException {
		Abstract_Literal wf = null;


		Abstract_Literal l =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:171:39: ( MULT l= literal )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:171:42: MULT l= literal
			{
			match(input,MULT,FOLLOW_MULT_in_waitfor1739); 
			pushFollow(FOLLOW_literal_in_waitfor1743);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:173:1: action returns [Abstract_Action a] : ( (a1= atom PLUS a2= atom EQ_ASSGN v= var ) | ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred );
	public final Abstract_Action action() throws RecognitionException {
		Abstract_Action a = null;


		Abstract_NumberTerm a1 =null;
		Abstract_NumberTerm a2 =null;
		Abstract_VarTerm v =null;
		Abstract_Literal an =null;
		int p =0;
		Abstract_Predicate t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:173:36: ( (a1= atom PLUS a2= atom EQ_ASSGN v= var ) | ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred )
			int alt37=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
			case OPEN:
				{
				alt37=1;
				}
				break;
			case VAR:
				{
				int LA37_3 = input.LA(2);
				if ( (LA37_3==PLUS) ) {
					alt37=1;
				}
				else if ( (LA37_3==COMMA||LA37_3==SEMI) ) {
					alt37=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 37, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case SEND:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:174:2: (a1= atom PLUS a2= atom EQ_ASSGN v= var )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:174:2: (a1= atom PLUS a2= atom EQ_ASSGN v= var )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:174:3: a1= atom PLUS a2= atom EQ_ASSGN v= var
					{
					pushFollow(FOLLOW_atom_in_action1762);
					a1=atom();
					state._fsp--;

					match(input,PLUS,FOLLOW_PLUS_in_action1764); 
					pushFollow(FOLLOW_atom_in_action1768);
					a2=atom();
					state._fsp--;

					match(input,EQ_ASSGN,FOLLOW_EQ_ASSGN_in_action1770); 
					pushFollow(FOLLOW_var_in_action1774);
					v=var();
					state._fsp--;

					a = new Abstract_Action("sum"); a.addTerm(a1); a.addTerm(a2); a.addTerm(v); 
					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:175:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:175:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:175:3: SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE
					{
					match(input,SEND,FOLLOW_SEND_in_action1783); 
					match(input,OPEN,FOLLOW_OPEN_in_action1785); 
					pushFollow(FOLLOW_literal_in_action1789);
					an=literal();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_action1791); 
					pushFollow(FOLLOW_performative_in_action1795);
					p=performative();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_action1797); 
					pushFollow(FOLLOW_pred_in_action1801);
					t=pred();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_action1803); 
					a = new Abstract_SendAction(an, p, t);
					}

					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:176:2: t= pred
					{
					pushFollow(FOLLOW_pred_in_action1814);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:178:1: performative returns [int b] : ( TELL | PERFORM | ACHIEVE ) ;
	public final int performative() throws RecognitionException {
		int b = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:178:30: ( ( TELL | PERFORM | ACHIEVE ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:178:32: ( TELL | PERFORM | ACHIEVE )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:178:32: ( TELL | PERFORM | ACHIEVE )
			int alt38=3;
			switch ( input.LA(1) ) {
			case TELL:
				{
				alt38=1;
				}
				break;
			case PERFORM:
				{
				alt38=2;
				}
				break;
			case ACHIEVE:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:178:33: TELL
					{
					match(input,TELL,FOLLOW_TELL_in_performative1829); 
					b =1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:178:48: PERFORM
					{
					match(input,PERFORM,FOLLOW_PERFORM_in_performative1835); 
					b =2;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:178:66: ACHIEVE
					{
					match(input,ACHIEVE,FOLLOW_ACHIEVE_in_performative1841); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:221:1: environment returns [String env] : w= classpath ;
	public final String environment() throws RecognitionException {
		String env = null;


		String w =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:221:34: (w= classpath )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:221:36: w= classpath
			{
			pushFollow(FOLLOW_classpath_in_environment2132);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
	public final String classpath() throws RecognitionException {
		String s = null;


		String w =null;
		String w1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:30: (w= word ( POINT w1= word )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:32: w= word ( POINT w1= word )+
			{
			pushFollow(FOLLOW_word_in_classpath2147);
			w=word();
			state._fsp--;

			s = w;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:52: ( POINT w1= word )+
			int cnt39=0;
			loop39:
			while (true) {
				int alt39=2;
				int LA39_0 = input.LA(1);
				if ( (LA39_0==POINT) ) {
					alt39=1;
				}

				switch (alt39) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:53: POINT w1= word
					{
					match(input,POINT,FOLLOW_POINT_in_classpath2152); 
					pushFollow(FOLLOW_word_in_classpath2156);
					w1=word();
					state._fsp--;

					s+="."; s+=w1;
					}
					break;

				default :
					if ( cnt39 >= 1 ) break loop39;
					EarlyExitException eee = new EarlyExitException(39, input);
					throw eee;
				}
				cnt39++;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:223:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:223:25: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:223:27: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:223:27: ( CONST | VAR )
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==CONST) ) {
				alt40=1;
			}
			else if ( (LA40_0==VAR) ) {
				alt40=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}

			switch (alt40) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:223:28: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_word2257); 
					s =CONST1.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:223:59: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_word2263); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
	public final Abstract_StringTerm agentnameterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token CONST3=null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:47: ( CONST |v= var )
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==CONST) ) {
				alt41=1;
			}
			else if ( (LA41_0==VAR) ) {
				alt41=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}

			switch (alt41) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:49: CONST
					{
					CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm2363); 
					s = new Abstract_StringTermImpl(CONST3.getText());
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:111: v= var
					{
					pushFollow(FOLLOW_var_in_agentnameterm2371);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
	public final Abstract_Literal literal() throws RecognitionException {
		Abstract_Literal l = null;


		Abstract_Predicate nt =null;
		Abstract_Predicate t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:37: ( ( TRUE | NOT nt= pred ) |t= pred )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==NOT||LA43_0==TRUE) ) {
				alt43=1;
			}
			else if ( (LA43_0==CONST||LA43_0==VAR) ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:40: ( TRUE | NOT nt= pred )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:40: ( TRUE | NOT nt= pred )
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==TRUE) ) {
						alt42=1;
					}
					else if ( (LA42_0==NOT) ) {
						alt42=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 42, 0, input);
						throw nvae;
					}

					switch (alt42) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:41: TRUE
							{
							match(input,TRUE,FOLLOW_TRUE_in_literal2387); 
							l = new Abstract_Literal(Abstract_Literal.LTrue);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:229:5: NOT nt= pred
							{
							match(input,NOT,FOLLOW_NOT_in_literal2398); 
							pushFollow(FOLLOW_pred_in_literal2402);
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:233:5: t= pred
					{
					pushFollow(FOLLOW_pred_in_literal2416);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:237:1: pred returns [Abstract_Predicate t] : (v= var |f= function );
	public final Abstract_Predicate pred() throws RecognitionException {
		Abstract_Predicate t = null;


		Abstract_VarTerm v =null;
		Abstract_Predicate f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:237:37: (v= var |f= function )
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==VAR) ) {
				alt44=1;
			}
			else if ( (LA44_0==CONST) ) {
				alt44=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}

			switch (alt44) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:237:39: v= var
					{
					pushFollow(FOLLOW_var_in_pred2432);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:237:59: f= function
					{
					pushFollow(FOLLOW_function_in_pred2439);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
	public final Abstract_Predicate function() throws RecognitionException {
		Abstract_Predicate f = null;


		Token CONST4=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:40: ( CONST ( OPEN terms[$f] CLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:42: CONST ( OPEN terms[$f] CLOSE )?
			{
			CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_function2451); 
			f = new Abstract_Predicate(CONST4.getText());
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:97: ( OPEN terms[$f] CLOSE )?
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==OPEN) ) {
				alt45=1;
			}
			switch (alt45) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:98: OPEN terms[$f] CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function2456); 
					pushFollow(FOLLOW_terms_in_function2458);
					terms(f);
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_function2461); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:240:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
	public final void terms(Abstract_Predicate f) throws RecognitionException {
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:240:29: (t= term ( COMMA terms[$f] )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:240:31: t= term ( COMMA terms[$f] )?
			{
			pushFollow(FOLLOW_term_in_terms2474);
			t=term();
			state._fsp--;

			f.addTerm(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:240:58: ( COMMA terms[$f] )?
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==COMMA) ) {
				alt46=1;
			}
			switch (alt46) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:240:59: COMMA terms[$f]
					{
					match(input,COMMA,FOLLOW_COMMA_in_terms2479); 
					pushFollow(FOLLOW_terms_in_terms2481);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |f= function );
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_NumberTerm a =null;
		Abstract_StringTerm s =null;
		Abstract_Predicate f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:31: (a= atom |s= stringterm |f= function )
			int alt47=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
			case OPEN:
			case VAR:
				{
				alt47=1;
				}
				break;
			case DOUBLEQUOTE:
				{
				alt47=2;
				}
				break;
			case CONST:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:34: a= atom
					{
					pushFollow(FOLLOW_atom_in_term2500);
					a=atom();
					state._fsp--;

					t = a;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:58: s= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term2510);
					s=stringterm();
					state._fsp--;

					t = s;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:88: f= function
					{
					pushFollow(FOLLOW_function_in_term2518);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:243:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
	public final Abstract_NumberTerm atom() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;
		Abstract_NumberTerm a =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:243:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
			int alt48=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
				{
				alt48=1;
				}
				break;
			case VAR:
				{
				alt48=2;
				}
				break;
			case OPEN:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:243:40: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom2536);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:244:6: v= var
					{
					pushFollow(FOLLOW_var_in_atom2549);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:244:27: OPEN a= arithexpr CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_atom2555); 
					pushFollow(FOLLOW_arithexpr_in_atom2559);
					a=arithexpr();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_atom2561); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:245:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING5=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:245:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:245:46: DOUBLEQUOTE STRING DOUBLEQUOTE
			{
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2574); 
			STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm2577); 
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2579); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:247:1: var returns [Abstract_VarTerm v] : VAR ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR6=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:247:34: ( VAR )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:247:36: VAR
			{
			VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_var2593); 

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
			{
			s = "";
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:46: ( MINUS )?
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==MINUS) ) {
				alt49=1;
			}
			switch (alt49) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:47: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring2610); 
					s += "-";
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:68: (n1= NUMBER ( POINT n2= NUMBER )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:69: n1= NUMBER ( POINT n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2619); 
			s += n1.getText();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:257:6: ( POINT n2= NUMBER )?
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==POINT) ) {
				alt50=1;
			}
			switch (alt50) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:257:7: POINT n2= NUMBER
					{
					match(input,POINT,FOLLOW_POINT_in_numberstring2629); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2635); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:258:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation eq = null;


		Abstract_NumberTerm a1 =null;
		int oper =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:258:40: (a1= arithexpr oper= eqoper a2= arithexpr )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:258:42: a1= arithexpr oper= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation2652);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation2656);
			oper=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation2660);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:259:1: eqoper returns [int oper] : ( LESS | EQ );
	public final int eqoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:259:27: ( LESS | EQ )
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==LESS) ) {
				alt51=1;
			}
			else if ( (LA51_0==EQ) ) {
				alt51=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 51, 0, input);
				throw nvae;
			}

			switch (alt51) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:259:29: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2674); 
					oper =Abstract_Equation.less;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:259:68: EQ
					{
					match(input,EQ,FOLLOW_EQ_in_eqoper2680); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:261:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm m =null;
		int oper =0;
		Abstract_NumberTerm m1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:261:43: (m= multexpr (oper= addoper m1= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:261:45: m= multexpr (oper= addoper m1= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr2696);
			m=multexpr();
			state._fsp--;

			t = m;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:261:69: (oper= addoper m1= multexpr )?
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==MINUS||LA52_0==PLUS) ) {
				alt52=1;
			}
			switch (alt52) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:261:71: oper= addoper m1= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr2704);
					oper=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr2708);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm a =null;
		int oper =0;
		Abstract_NumberTerm a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:42: (a= atom (oper= multoper a1= atom )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:44: a= atom (oper= multoper a1= atom )?
			{
			pushFollow(FOLLOW_atom_in_multexpr2725);
			a=atom();
			state._fsp--;

			t = a;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:64: (oper= multoper a1= atom )?
			int alt53=2;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==DIV||(LA53_0 >= MOD && LA53_0 <= MULT)) ) {
				alt53=1;
			}
			switch (alt53) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:65: oper= multoper a1= atom
					{
					pushFollow(FOLLOW_multoper_in_multexpr2732);
					oper=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_in_multexpr2736);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:264:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:264:28: ( ( PLUS | MINUS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:264:30: ( PLUS | MINUS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:264:30: ( PLUS | MINUS )
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==PLUS) ) {
				alt54=1;
			}
			else if ( (LA54_0==MINUS) ) {
				alt54=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 54, 0, input);
				throw nvae;
			}

			switch (alt54) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:264:31: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper2753); 
					oper =Abstract_ArithExpr.plus;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:264:70: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper2758); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
	public final int multoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:29: ( ( MULT | DIV | MOD ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:31: ( MULT | DIV | MOD )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:31: ( MULT | DIV | MOD )
			int alt55=3;
			switch ( input.LA(1) ) {
			case MULT:
				{
				alt55=1;
				}
				break;
			case DIV:
				{
				alt55=2;
				}
				break;
			case MOD:
				{
				alt55=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 55, 0, input);
				throw nvae;
			}
			switch (alt55) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:32: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper2773); 
					oper =Abstract_ArithExpr.times;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:73: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper2779); 
					oper =Abstract_ArithExpr.div;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:111: MOD
					{
					match(input,MOD,FOLLOW_MOD_in_multoper2785); 
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
	public static final BitSet FOLLOW_EASS_in_eassagents102 = new BitSet(new long[]{0x0000001000000010L});
	public static final BitSet FOLLOW_eassagent_in_eassagents111 = new BitSet(new long[]{0x0000001000000012L});
	public static final BitSet FOLLOW_NAME_in_eassagent130 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_word_in_eassagent134 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ABSTRACTION_in_eassagent141 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_word_in_eassagent145 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_BELIEFS_in_eassagent157 = new BitSet(new long[]{0x5000004010082100L});
	public static final BitSet FOLLOW_literal_in_eassagent162 = new BitSet(new long[]{0x5000004010082100L});
	public static final BitSet FOLLOW_BELIEFRULES_in_eassagent170 = new BitSet(new long[]{0x4000000010082000L});
	public static final BitSet FOLLOW_brule_in_eassagent175 = new BitSet(new long[]{0x4000000010082000L});
	public static final BitSet FOLLOW_CAPABILITIES_in_eassagent185 = new BitSet(new long[]{0x0000000010200000L});
	public static final BitSet FOLLOW_capability_in_eassagent190 = new BitSet(new long[]{0x0000000010200000L});
	public static final BitSet FOLLOW_GOALS_in_eassagent199 = new BitSet(new long[]{0x5000104000080000L});
	public static final BitSet FOLLOW_goal_in_eassagent204 = new BitSet(new long[]{0x5000104000080000L});
	public static final BitSet FOLLOW_PLANS_in_eassagent211 = new BitSet(new long[]{0x0000200200000002L});
	public static final BitSet FOLLOW_plan_in_eassagent216 = new BitSet(new long[]{0x0000200200000002L});
	public static final BitSet FOLLOW_literal_in_goal236 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_SQOPEN_in_goal238 = new BitSet(new long[]{0x0000040000000040L});
	public static final BitSet FOLLOW_ACHIEVEGOAL_in_goal241 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_PERFORMGOAL_in_goal249 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_goal254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURLYOPEN_in_capability269 = new BitSet(new long[]{0x4000004000180000L});
	public static final BitSet FOLLOW_clogicalfmla_in_capability274 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_capability278 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_capability284 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_capability289 = new BitSet(new long[]{0x4000004000080000L});
	public static final BitSet FOLLOW_clogicalfmla_in_capability293 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_capability297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_event_in_plan313 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_COLON_in_plan321 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_plan323 = new BitSet(new long[]{0x502009C208000400L});
	public static final BitSet FOLLOW_NOT_in_plan328 = new BitSet(new long[]{0x5020098208000400L});
	public static final BitSet FOLLOW_guard_atom_in_plan336 = new BitSet(new long[]{0x0000000000120000L});
	public static final BitSet FOLLOW_COMMA_in_plan344 = new BitSet(new long[]{0x502009C208000400L});
	public static final BitSet FOLLOW_NOT_in_plan349 = new BitSet(new long[]{0x5020098208000400L});
	public static final BitSet FOLLOW_guard_atom_in_plan357 = new BitSet(new long[]{0x0000000000120000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_plan363 = new BitSet(new long[]{0x000C000000000000L});
	public static final BitSet FOLLOW_RULEARROW_in_plan366 = new BitSet(new long[]{0xE411218A00081000L});
	public static final BitSet FOLLOW_deed_in_plan371 = new BitSet(new long[]{0x0008000000020000L});
	public static final BitSet FOLLOW_COMMA_in_plan377 = new BitSet(new long[]{0xE411218A00081000L});
	public static final BitSet FOLLOW_deed_in_plan381 = new BitSet(new long[]{0x0008000000020000L});
	public static final BitSet FOLLOW_SEMI_in_plan392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_event408 = new BitSet(new long[]{0x5042004000080000L});
	public static final BitSet FOLLOW_RECEIVED_in_event411 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_event413 = new BitSet(new long[]{0x0800020000000020L});
	public static final BitSet FOLLOW_performative_in_event417 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_event419 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_event423 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_event425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_event443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_event453 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_goal_in_event457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_event471 = new BitSet(new long[]{0x5040004000080000L});
	public static final BitSet FOLLOW_literal_in_event476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_event486 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_goal_in_event490 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BELIEVE_in_guard_atom511 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_guard_atom515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_guard_atom525 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_goal_in_guard_atom529 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SENT_in_guard_atom539 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_guard_atom541 = new BitSet(new long[]{0x4000000000800000L});
	public static final BitSet FOLLOW_stringterm_in_guard_atom548 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_var_in_guard_atom556 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom561 = new BitSet(new long[]{0x0800020000800020L});
	public static final BitSet FOLLOW_stringterm_in_guard_atom568 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom576 = new BitSet(new long[]{0x0800020000000020L});
	public static final BitSet FOLLOW_performative_in_guard_atom584 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom592 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom596 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_guard_atom598 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_guard_atom612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLAN_in_guard_atom632 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_guard_atom634 = new BitSet(new long[]{0x4000008200000000L});
	public static final BitSet FOLLOW_var_in_guard_atom641 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_numberstring_in_guard_atom648 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom653 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom701 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom703 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom752 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom754 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom758 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_guard_atom760 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_guard_atom817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_deed841 = new BitSet(new long[]{0x5040084100080000L});
	public static final BitSet FOLLOW_literal_in_deed846 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_deed856 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_goal_in_deed860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOCK_in_deed870 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLAN_in_deed879 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_deed881 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_deed885 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_deed887 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_deed900 = new BitSet(new long[]{0x5040084100080000L});
	public static final BitSet FOLLOW_literal_in_deed905 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_deed915 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_goal_in_deed919 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOCK_in_deed929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLAN_in_deed939 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_deed941 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_deed945 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_deed947 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_deed964 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_deed969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CALCULATE_in_deed980 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_calculation_in_deed984 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QUERYCOM_in_deed995 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_query_in_deed999 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WAIT_in_deed1010 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_wait_in_deed1014 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_deed1027 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_waitfor_in_deed1040 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUBSTITUTE_in_deed1050 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_substitution_in_deed1054 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_substitution1085 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_substitution1089 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_substitution1091 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_substitution1097 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_substitution1099 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_substitution1104 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_substitution1106 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_substitution1112 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_substitution1114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_calculation1134 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_calculation1140 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_calculation1142 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_var_in_calculation1146 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_calculation1148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_query1166 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_query1172 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_query1175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_wait1193 = new BitSet(new long[]{0x4000018200880000L});
	public static final BitSet FOLLOW_term_in_wait1199 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_wait1201 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_wait1205 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_wait1207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_brule1229 = new BitSet(new long[]{0x0008000000000800L});
	public static final BitSet FOLLOW_BRULEARROW_in_brule1232 = new BitSet(new long[]{0x4000004000080000L});
	public static final BitSet FOLLOW_logicalfmla_in_brule1236 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_SEMI_in_brule1240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMI_in_brule1244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla1261 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_COMMA_in_logicalfmla1281 = new BitSet(new long[]{0x4000004000080000L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla1285 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_pred_in_notfmla1320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_notfmla1405 = new BitSet(new long[]{0x4000010000080000L});
	public static final BitSet FOLLOW_pred_in_notfmla1412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subfmla_in_notfmla1422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_subfmla1436 = new BitSet(new long[]{0x4000004000080000L});
	public static final BitSet FOLLOW_logicalfmla_in_subfmla1442 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_subfmla1446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cnotfmla_in_clogicalfmla1460 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_COMMA_in_clogicalfmla1480 = new BitSet(new long[]{0x4000004000080000L});
	public static final BitSet FOLLOW_cnotfmla_in_clogicalfmla1484 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_pred_in_cnotfmla1519 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_cnotfmla1604 = new BitSet(new long[]{0x4000010000080000L});
	public static final BitSet FOLLOW_pred_in_cnotfmla1611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_csubfmla_in_cnotfmla1700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_csubfmla1714 = new BitSet(new long[]{0x4000004000080000L});
	public static final BitSet FOLLOW_clogicalfmla_in_csubfmla1720 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_csubfmla1724 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_waitfor1739 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_waitfor1743 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_action1762 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_PLUS_in_action1764 = new BitSet(new long[]{0x4000018200000000L});
	public static final BitSet FOLLOW_atom_in_action1768 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_EQ_ASSGN_in_action1770 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_var_in_action1774 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEND_in_action1783 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_action1785 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_action1789 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_action1791 = new BitSet(new long[]{0x0800020000000020L});
	public static final BitSet FOLLOW_performative_in_action1795 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_action1797 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_action1801 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_action1803 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_action1814 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TELL_in_performative1829 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PERFORM_in_performative1835 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACHIEVE_in_performative1841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_classpath_in_environment2132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_classpath2147 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_POINT_in_classpath2152 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_word_in_classpath2156 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_CONST_in_word2257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word2263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_agentnameterm2363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_agentnameterm2371 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_literal2387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_literal2398 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_literal2402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_literal2416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_pred2432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_pred2439 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function2451 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_OPEN_in_function2456 = new BitSet(new long[]{0x4000018200880000L});
	public static final BitSet FOLLOW_terms_in_function2458 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_function2461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_terms2474 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_COMMA_in_terms2479 = new BitSet(new long[]{0x4000018200880000L});
	public static final BitSet FOLLOW_terms_in_terms2481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_term2500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_term2510 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_term2518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom2536 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom2549 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom2555 = new BitSet(new long[]{0x4000018200000000L});
	public static final BitSet FOLLOW_arithexpr_in_atom2559 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_atom2561 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2574 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STRING_in_stringterm2577 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var2593 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring2610 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2619 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_POINT_in_numberstring2629 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation2652 = new BitSet(new long[]{0x0000000042000000L});
	public static final BitSet FOLLOW_eqoper_in_equation2656 = new BitSet(new long[]{0x4000018200000000L});
	public static final BitSet FOLLOW_arithexpr_in_equation2660 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_eqoper2680 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2696 = new BitSet(new long[]{0x0000200200000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr2704 = new BitSet(new long[]{0x4000018200000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_multexpr2725 = new BitSet(new long[]{0x0000000C00400002L});
	public static final BitSet FOLLOW_multoper_in_multexpr2732 = new BitSet(new long[]{0x4000018200000000L});
	public static final BitSet FOLLOW_atom_in_multexpr2736 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper2753 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper2758 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper2773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper2779 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_multoper2785 = new BitSet(new long[]{0x0000000000000002L});
}
