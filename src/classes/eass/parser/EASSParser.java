// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g 2015-01-20 13:23:51

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
		"PERFORMGOAL", "PLAN", "PLANS", "PLUS", "POINT", "QUERYCOM", "RECEIVED", 
		"RULEARROW", "SEMI", "SEND", "SENT", "SHRIEK", "SQCLOSE", "SQOPEN", "STRING", 
		"SUBSTITUTE", "TELL", "TRUE", "UPDATE", "VAR", "WAIT", "WS", "'|'"
	};
	public static final int EOF=-1;
	public static final int T__64=64;
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
	public static final int QUERYCOM=47;
	public static final int RECEIVED=48;
	public static final int RULEARROW=49;
	public static final int SEMI=50;
	public static final int SEND=51;
	public static final int SENT=52;
	public static final int SHRIEK=53;
	public static final int SQCLOSE=54;
	public static final int SQOPEN=55;
	public static final int STRING=56;
	public static final int SUBSTITUTE=57;
	public static final int TELL=58;
	public static final int TRUE=59;
	public static final int UPDATE=60;
	public static final int VAR=61;
	public static final int WAIT=62;
	public static final int WS=63;

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:158:1: notfmla returns [Abstract_LogicalFormula f] : (gb= pred | SQOPEN eq= equation SQCLOSE | NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla ) );
	public final Abstract_LogicalFormula notfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_Predicate gb =null;
		Abstract_Equation eq =null;
		Abstract_Predicate gb2 =null;
		Abstract_LogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:158:45: (gb= pred | SQOPEN eq= equation SQCLOSE | NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla ) )
			int alt33=3;
			switch ( input.LA(1) ) {
			case CONST:
			case VAR:
				{
				alt33=1;
				}
				break;
			case SQOPEN:
				{
				alt33=2;
				}
				break;
			case NOT:
				{
				alt33=3;
				}
				break;
			default:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:159:80: SQOPEN eq= equation SQCLOSE
					{
					match(input,SQOPEN,FOLLOW_SQOPEN_in_notfmla1406); 
					pushFollow(FOLLOW_equation_in_notfmla1412);
					eq=equation();
					state._fsp--;

					match(input,SQCLOSE,FOLLOW_SQCLOSE_in_notfmla1414); 
					f = eq;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:160:78: NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla )
					{
					match(input,NOT,FOLLOW_NOT_in_notfmla1497); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:160:82: (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla )
					int alt32=3;
					switch ( input.LA(1) ) {
					case CONST:
					case VAR:
						{
						alt32=1;
						}
						break;
					case SQOPEN:
						{
						alt32=2;
						}
						break;
					case OPEN:
						{
						alt32=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 32, 0, input);
						throw nvae;
					}
					switch (alt32) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:160:83: gb2= pred
							{
							pushFollow(FOLLOW_pred_in_notfmla1504);
							gb2=pred();
							state._fsp--;

							f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:161:79: SQOPEN eq= equation SQCLOSE
							{
							match(input,SQOPEN,FOLLOW_SQOPEN_in_notfmla1589); 
							pushFollow(FOLLOW_equation_in_notfmla1595);
							eq=equation();
							state._fsp--;

							match(input,SQCLOSE,FOLLOW_SQCLOSE_in_notfmla1597); 
							f = new Abstract_LogExpr(Abstract_LogExpr.not, eq);
							}
							break;
						case 3 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:162:79: lf= subfmla
							{
							pushFollow(FOLLOW_subfmla_in_notfmla1685);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:1: subfmla returns [Abstract_LogicalFormula f] : OPEN lf= logicalfmla CLOSE ;
	public final Abstract_LogicalFormula subfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:45: ( OPEN lf= logicalfmla CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:47: OPEN lf= logicalfmla CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_subfmla1699); 
			pushFollow(FOLLOW_logicalfmla_in_subfmla1705);
			lf=logicalfmla();
			state._fsp--;

			f = lf;
			match(input,CLOSE,FOLLOW_CLOSE_in_subfmla1709); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:165:1: clogicalfmla returns [Abstract_GLogicalFormula f] : n= cnotfmla ( COMMA n2= cnotfmla )* ;
	public final Abstract_GLogicalFormula clogicalfmla() throws RecognitionException {
		Abstract_GLogicalFormula f = null;


		Abstract_GLogicalFormula n =null;
		Abstract_GLogicalFormula n2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:165:51: (n= cnotfmla ( COMMA n2= cnotfmla )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:165:53: n= cnotfmla ( COMMA n2= cnotfmla )*
			{
			pushFollow(FOLLOW_cnotfmla_in_clogicalfmla1723);
			n=cnotfmla();
			state._fsp--;

			f = n;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:166:16: ( COMMA n2= cnotfmla )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==COMMA) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:166:17: COMMA n2= cnotfmla
					{
					match(input,COMMA,FOLLOW_COMMA_in_clogicalfmla1743); 
					pushFollow(FOLLOW_cnotfmla_in_clogicalfmla1747);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:168:1: cnotfmla returns [Abstract_GLogicalFormula f] : (gb= pred | NOT (gb2= pred |lf= csubfmla ) );
	public final Abstract_GLogicalFormula cnotfmla() throws RecognitionException {
		Abstract_GLogicalFormula f = null;


		Abstract_Predicate gb =null;
		Abstract_Predicate gb2 =null;
		Abstract_GLogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:168:47: (gb= pred | NOT (gb2= pred |lf= csubfmla ) )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:168:49: gb= pred
					{
					pushFollow(FOLLOW_pred_in_cnotfmla1782);
					gb=pred();
					state._fsp--;

					f = new Abstract_GBelief(new Abstract_Literal(gb));
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:169:79: NOT (gb2= pred |lf= csubfmla )
					{
					match(input,NOT,FOLLOW_NOT_in_cnotfmla1867); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:169:83: (gb2= pred |lf= csubfmla )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:169:84: gb2= pred
							{
							pushFollow(FOLLOW_pred_in_cnotfmla1874);
							gb2=pred();
							state._fsp--;

							f = new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal(gb2)));
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:170:79: lf= csubfmla
							{
							pushFollow(FOLLOW_csubfmla_in_cnotfmla1963);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:171:1: csubfmla returns [Abstract_GLogicalFormula f] : OPEN lf= clogicalfmla CLOSE ;
	public final Abstract_GLogicalFormula csubfmla() throws RecognitionException {
		Abstract_GLogicalFormula f = null;


		Abstract_GLogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:171:47: ( OPEN lf= clogicalfmla CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:171:49: OPEN lf= clogicalfmla CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_csubfmla1977); 
			pushFollow(FOLLOW_clogicalfmla_in_csubfmla1983);
			lf=clogicalfmla();
			state._fsp--;

			f = lf;
			match(input,CLOSE,FOLLOW_CLOSE_in_csubfmla1987); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:174:1: waitfor returns [Abstract_Literal wf] : MULT l= literal ;
	public final Abstract_Literal waitfor() throws RecognitionException {
		Abstract_Literal wf = null;


		Abstract_Literal l =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:174:39: ( MULT l= literal )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:174:42: MULT l= literal
			{
			match(input,MULT,FOLLOW_MULT_in_waitfor2002); 
			pushFollow(FOLLOW_literal_in_waitfor2006);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:176:1: action returns [Abstract_Action a] : ( (a1= atom PLUS a2= atom EQ_ASSGN v= var ) | ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred );
	public final Abstract_Action action() throws RecognitionException {
		Abstract_Action a = null;


		Abstract_NumberTerm a1 =null;
		Abstract_NumberTerm a2 =null;
		Abstract_VarTerm v =null;
		Abstract_Literal an =null;
		int p =0;
		Abstract_Predicate t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:176:36: ( (a1= atom PLUS a2= atom EQ_ASSGN v= var ) | ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:177:2: (a1= atom PLUS a2= atom EQ_ASSGN v= var )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:177:2: (a1= atom PLUS a2= atom EQ_ASSGN v= var )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:177:3: a1= atom PLUS a2= atom EQ_ASSGN v= var
					{
					pushFollow(FOLLOW_atom_in_action2025);
					a1=atom();
					state._fsp--;

					match(input,PLUS,FOLLOW_PLUS_in_action2027); 
					pushFollow(FOLLOW_atom_in_action2031);
					a2=atom();
					state._fsp--;

					match(input,EQ_ASSGN,FOLLOW_EQ_ASSGN_in_action2033); 
					pushFollow(FOLLOW_var_in_action2037);
					v=var();
					state._fsp--;

					a = new Abstract_Action("sum"); a.addTerm(a1); a.addTerm(a2); a.addTerm(v); 
					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:178:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:178:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:178:3: SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE
					{
					match(input,SEND,FOLLOW_SEND_in_action2046); 
					match(input,OPEN,FOLLOW_OPEN_in_action2048); 
					pushFollow(FOLLOW_literal_in_action2052);
					an=literal();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_action2054); 
					pushFollow(FOLLOW_performative_in_action2058);
					p=performative();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_action2060); 
					pushFollow(FOLLOW_pred_in_action2064);
					t=pred();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_action2066); 
					a = new Abstract_SendAction(an, p, t);
					}

					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:179:2: t= pred
					{
					pushFollow(FOLLOW_pred_in_action2077);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:1: performative returns [int b] : ( TELL | PERFORM | ACHIEVE ) ;
	public final int performative() throws RecognitionException {
		int b = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:30: ( ( TELL | PERFORM | ACHIEVE ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:32: ( TELL | PERFORM | ACHIEVE )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:32: ( TELL | PERFORM | ACHIEVE )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:33: TELL
					{
					match(input,TELL,FOLLOW_TELL_in_performative2092); 
					b =1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:48: PERFORM
					{
					match(input,PERFORM,FOLLOW_PERFORM_in_performative2098); 
					b =2;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:181:66: ACHIEVE
					{
					match(input,ACHIEVE,FOLLOW_ACHIEVE_in_performative2104); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:224:1: environment returns [String env] : w= classpath ;
	public final String environment() throws RecognitionException {
		String env = null;


		String w =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:224:34: (w= classpath )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:224:36: w= classpath
			{
			pushFollow(FOLLOW_classpath_in_environment2395);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
	public final String classpath() throws RecognitionException {
		String s = null;


		String w =null;
		String w1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:30: (w= word ( POINT w1= word )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:32: w= word ( POINT w1= word )+
			{
			pushFollow(FOLLOW_word_in_classpath2410);
			w=word();
			state._fsp--;

			s = w;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:52: ( POINT w1= word )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:53: POINT w1= word
					{
					match(input,POINT,FOLLOW_POINT_in_classpath2415); 
					pushFollow(FOLLOW_word_in_classpath2419);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:226:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:226:25: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:226:27: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:226:27: ( CONST | VAR )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:226:28: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_word2520); 
					s =CONST1.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:226:59: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_word2526); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
	public final Abstract_StringTerm agentnameterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token CONST3=null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:47: ( CONST |v= var )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:49: CONST
					{
					CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm2626); 
					s = new Abstract_StringTermImpl(CONST3.getText());
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:228:111: v= var
					{
					pushFollow(FOLLOW_var_in_agentnameterm2634);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:231:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
	public final Abstract_Literal literal() throws RecognitionException {
		Abstract_Literal l = null;


		Abstract_Predicate nt =null;
		Abstract_Predicate t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:231:37: ( ( TRUE | NOT nt= pred ) |t= pred )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:231:40: ( TRUE | NOT nt= pred )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:231:40: ( TRUE | NOT nt= pred )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:231:41: TRUE
							{
							match(input,TRUE,FOLLOW_TRUE_in_literal2650); 
							l = new Abstract_Literal(Abstract_Literal.LTrue);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:232:5: NOT nt= pred
							{
							match(input,NOT,FOLLOW_NOT_in_literal2661); 
							pushFollow(FOLLOW_pred_in_literal2665);
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:236:5: t= pred
					{
					pushFollow(FOLLOW_pred_in_literal2679);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:240:1: pred returns [Abstract_Predicate t] : (v= var |f= function );
	public final Abstract_Predicate pred() throws RecognitionException {
		Abstract_Predicate t = null;


		Abstract_VarTerm v =null;
		Abstract_Predicate f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:240:37: (v= var |f= function )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:240:39: v= var
					{
					pushFollow(FOLLOW_var_in_pred2695);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:240:59: f= function
					{
					pushFollow(FOLLOW_function_in_pred2702);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
	public final Abstract_Predicate function() throws RecognitionException {
		Abstract_Predicate f = null;


		Token CONST4=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:40: ( CONST ( OPEN terms[$f] CLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:42: CONST ( OPEN terms[$f] CLOSE )?
			{
			CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_function2714); 
			f = new Abstract_Predicate(CONST4.getText());
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:97: ( OPEN terms[$f] CLOSE )?
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==OPEN) ) {
				alt45=1;
			}
			switch (alt45) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:98: OPEN terms[$f] CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function2719); 
					pushFollow(FOLLOW_terms_in_function2721);
					terms(f);
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_function2724); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:243:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
	public final void terms(Abstract_Predicate f) throws RecognitionException {
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:243:29: (t= term ( COMMA terms[$f] )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:243:31: t= term ( COMMA terms[$f] )?
			{
			pushFollow(FOLLOW_term_in_terms2737);
			t=term();
			state._fsp--;

			f.addTerm(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:243:58: ( COMMA terms[$f] )?
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==COMMA) ) {
				alt46=1;
			}
			switch (alt46) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:243:59: COMMA terms[$f]
					{
					match(input,COMMA,FOLLOW_COMMA_in_terms2742); 
					pushFollow(FOLLOW_terms_in_terms2744);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:244:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |l= listterm |f= function );
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_NumberTerm a =null;
		Abstract_StringTerm s =null;
		Abstract_ListTerm l =null;
		Abstract_Predicate f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:244:31: (a= atom |s= stringterm |l= listterm |f= function )
			int alt47=4;
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
			case SQOPEN:
				{
				alt47=3;
				}
				break;
			case CONST:
				{
				alt47=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}
			switch (alt47) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:244:34: a= atom
					{
					pushFollow(FOLLOW_atom_in_term2763);
					a=atom();
					state._fsp--;

					t = a;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:244:58: s= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term2773);
					s=stringterm();
					state._fsp--;

					t = s;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:244:88: l= listterm
					{
					pushFollow(FOLLOW_listterm_in_term2783);
					l=listterm();
					state._fsp--;

					t = l;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:244:116: f= function
					{
					pushFollow(FOLLOW_function_in_term2791);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:246:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
	public final Abstract_NumberTerm atom() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;
		Abstract_NumberTerm a =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:246:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:246:40: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom2809);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:247:6: v= var
					{
					pushFollow(FOLLOW_var_in_atom2822);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:247:27: OPEN a= arithexpr CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_atom2828); 
					pushFollow(FOLLOW_arithexpr_in_atom2832);
					a=arithexpr();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_atom2834); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING5=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:46: DOUBLEQUOTE STRING DOUBLEQUOTE
			{
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2847); 
			STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm2850); 
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2852); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:249:1: listterm returns [Abstract_ListTerm l] : SQOPEN (h= term '|' t= term )? SQCLOSE ;
	public final Abstract_ListTerm listterm() throws RecognitionException {
		Abstract_ListTerm l = null;


		Abstract_Term h =null;
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:249:40: ( SQOPEN (h= term '|' t= term )? SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:249:42: SQOPEN (h= term '|' t= term )? SQCLOSE
			{
			match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2865); 
			l = new Abstract_ListTermImpl();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:249:85: (h= term '|' t= term )?
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==CONST||LA49_0==DOUBLEQUOTE||LA49_0==MINUS||(LA49_0 >= NUMBER && LA49_0 <= OPEN)||LA49_0==SQOPEN||LA49_0==VAR) ) {
				alt49=1;
			}
			switch (alt49) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:249:86: h= term '|' t= term
					{
					pushFollow(FOLLOW_term_in_listterm2874);
					h=term();
					state._fsp--;

					match(input,64,FOLLOW_64_in_listterm2876); 
					pushFollow(FOLLOW_term_in_listterm2882);
					t=term();
					state._fsp--;

					l.addHead(h); l.addTail((Abstract_ListTerm) t);
					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2888); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:251:1: var returns [Abstract_VarTerm v] : VAR ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR6=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:251:34: ( VAR )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:251:36: VAR
			{
			VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_var2900); 

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:260:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:260:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:260:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
			{
			s = "";
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:260:46: ( MINUS )?
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==MINUS) ) {
				alt50=1;
			}
			switch (alt50) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:260:47: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring2917); 
					s += "-";
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:260:68: (n1= NUMBER ( POINT n2= NUMBER )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:260:69: n1= NUMBER ( POINT n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2926); 
			s += n1.getText();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:261:6: ( POINT n2= NUMBER )?
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==POINT) ) {
				alt51=1;
			}
			switch (alt51) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:261:7: POINT n2= NUMBER
					{
					match(input,POINT,FOLLOW_POINT_in_numberstring2936); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2942); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation eq = null;


		Abstract_NumberTerm a1 =null;
		int oper =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:40: (a1= arithexpr oper= eqoper a2= arithexpr )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:262:42: a1= arithexpr oper= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation2959);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation2963);
			oper=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation2967);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:263:1: eqoper returns [int oper] : ( LESS | EQ );
	public final int eqoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:263:27: ( LESS | EQ )
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==LESS) ) {
				alt52=1;
			}
			else if ( (LA52_0==EQ) ) {
				alt52=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 52, 0, input);
				throw nvae;
			}

			switch (alt52) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:263:29: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2981); 
					oper =Abstract_Equation.less;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:263:68: EQ
					{
					match(input,EQ,FOLLOW_EQ_in_eqoper2987); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm m =null;
		int oper =0;
		Abstract_NumberTerm m1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:43: (m= multexpr (oper= addoper m1= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:45: m= multexpr (oper= addoper m1= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr3003);
			m=multexpr();
			state._fsp--;

			t = m;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:69: (oper= addoper m1= multexpr )?
			int alt53=2;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==MINUS||LA53_0==PLUS) ) {
				alt53=1;
			}
			switch (alt53) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:71: oper= addoper m1= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr3011);
					oper=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr3015);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:266:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm a =null;
		int oper =0;
		Abstract_NumberTerm a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:266:42: (a= atom (oper= multoper a1= atom )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:266:44: a= atom (oper= multoper a1= atom )?
			{
			pushFollow(FOLLOW_atom_in_multexpr3032);
			a=atom();
			state._fsp--;

			t = a;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:266:64: (oper= multoper a1= atom )?
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==DIV||(LA54_0 >= MOD && LA54_0 <= MULT)) ) {
				alt54=1;
			}
			switch (alt54) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:266:65: oper= multoper a1= atom
					{
					pushFollow(FOLLOW_multoper_in_multexpr3039);
					oper=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_in_multexpr3043);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:268:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:268:28: ( ( PLUS | MINUS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:268:30: ( PLUS | MINUS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:268:30: ( PLUS | MINUS )
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==PLUS) ) {
				alt55=1;
			}
			else if ( (LA55_0==MINUS) ) {
				alt55=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 55, 0, input);
				throw nvae;
			}

			switch (alt55) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:268:31: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper3060); 
					oper =Abstract_ArithExpr.plus;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:268:70: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper3065); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:269:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
	public final int multoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:269:29: ( ( MULT | DIV | MOD ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:269:31: ( MULT | DIV | MOD )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:269:31: ( MULT | DIV | MOD )
			int alt56=3;
			switch ( input.LA(1) ) {
			case MULT:
				{
				alt56=1;
				}
				break;
			case DIV:
				{
				alt56=2;
				}
				break;
			case MOD:
				{
				alt56=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 56, 0, input);
				throw nvae;
			}
			switch (alt56) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:269:32: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper3080); 
					oper =Abstract_ArithExpr.times;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:269:73: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper3086); 
					oper =Abstract_ArithExpr.div;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:269:111: MOD
					{
					match(input,MOD,FOLLOW_MOD_in_multoper3092); 
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
	public static final BitSet FOLLOW_NAME_in_eassagent130 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_word_in_eassagent134 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ABSTRACTION_in_eassagent141 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_word_in_eassagent145 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_BELIEFS_in_eassagent157 = new BitSet(new long[]{0x2800004010082100L});
	public static final BitSet FOLLOW_literal_in_eassagent162 = new BitSet(new long[]{0x2800004010082100L});
	public static final BitSet FOLLOW_BELIEFRULES_in_eassagent170 = new BitSet(new long[]{0x2000000010082000L});
	public static final BitSet FOLLOW_brule_in_eassagent175 = new BitSet(new long[]{0x2000000010082000L});
	public static final BitSet FOLLOW_CAPABILITIES_in_eassagent185 = new BitSet(new long[]{0x0000000010200000L});
	public static final BitSet FOLLOW_capability_in_eassagent190 = new BitSet(new long[]{0x0000000010200000L});
	public static final BitSet FOLLOW_GOALS_in_eassagent199 = new BitSet(new long[]{0x2800104000080000L});
	public static final BitSet FOLLOW_goal_in_eassagent204 = new BitSet(new long[]{0x2800104000080000L});
	public static final BitSet FOLLOW_PLANS_in_eassagent211 = new BitSet(new long[]{0x0000200200000002L});
	public static final BitSet FOLLOW_plan_in_eassagent216 = new BitSet(new long[]{0x0000200200000002L});
	public static final BitSet FOLLOW_literal_in_goal236 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_SQOPEN_in_goal238 = new BitSet(new long[]{0x0000040000000040L});
	public static final BitSet FOLLOW_ACHIEVEGOAL_in_goal241 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_PERFORMGOAL_in_goal249 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_goal254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURLYOPEN_in_capability269 = new BitSet(new long[]{0x2000004000180000L});
	public static final BitSet FOLLOW_clogicalfmla_in_capability274 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_capability278 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_capability284 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_capability289 = new BitSet(new long[]{0x2000004000080000L});
	public static final BitSet FOLLOW_clogicalfmla_in_capability293 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_capability297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_event_in_plan313 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_COLON_in_plan321 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_plan323 = new BitSet(new long[]{0x281009C208000400L});
	public static final BitSet FOLLOW_NOT_in_plan328 = new BitSet(new long[]{0x2810098208000400L});
	public static final BitSet FOLLOW_guard_atom_in_plan336 = new BitSet(new long[]{0x0000000000120000L});
	public static final BitSet FOLLOW_COMMA_in_plan344 = new BitSet(new long[]{0x281009C208000400L});
	public static final BitSet FOLLOW_NOT_in_plan349 = new BitSet(new long[]{0x2810098208000400L});
	public static final BitSet FOLLOW_guard_atom_in_plan357 = new BitSet(new long[]{0x0000000000120000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_plan363 = new BitSet(new long[]{0x0006000000000000L});
	public static final BitSet FOLLOW_RULEARROW_in_plan366 = new BitSet(new long[]{0x7208A18A00081000L});
	public static final BitSet FOLLOW_deed_in_plan371 = new BitSet(new long[]{0x0004000000020000L});
	public static final BitSet FOLLOW_COMMA_in_plan377 = new BitSet(new long[]{0x7208A18A00081000L});
	public static final BitSet FOLLOW_deed_in_plan381 = new BitSet(new long[]{0x0004000000020000L});
	public static final BitSet FOLLOW_SEMI_in_plan392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_event408 = new BitSet(new long[]{0x2821004000080000L});
	public static final BitSet FOLLOW_RECEIVED_in_event411 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_event413 = new BitSet(new long[]{0x0400020000000020L});
	public static final BitSet FOLLOW_performative_in_event417 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_event419 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_event423 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_event425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_event443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_event453 = new BitSet(new long[]{0x2800004000080000L});
	public static final BitSet FOLLOW_goal_in_event457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_event471 = new BitSet(new long[]{0x2820004000080000L});
	public static final BitSet FOLLOW_literal_in_event476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_event486 = new BitSet(new long[]{0x2800004000080000L});
	public static final BitSet FOLLOW_goal_in_event490 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BELIEVE_in_guard_atom511 = new BitSet(new long[]{0x2800004000080000L});
	public static final BitSet FOLLOW_literal_in_guard_atom515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_guard_atom525 = new BitSet(new long[]{0x2800004000080000L});
	public static final BitSet FOLLOW_goal_in_guard_atom529 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SENT_in_guard_atom539 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_guard_atom541 = new BitSet(new long[]{0x2000000000800000L});
	public static final BitSet FOLLOW_stringterm_in_guard_atom548 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_var_in_guard_atom556 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom561 = new BitSet(new long[]{0x0400020000800020L});
	public static final BitSet FOLLOW_stringterm_in_guard_atom568 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom576 = new BitSet(new long[]{0x0400020000000020L});
	public static final BitSet FOLLOW_performative_in_guard_atom584 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom592 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom596 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_guard_atom598 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_guard_atom612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLAN_in_guard_atom632 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_guard_atom634 = new BitSet(new long[]{0x2000008200000000L});
	public static final BitSet FOLLOW_var_in_guard_atom641 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_numberstring_in_guard_atom648 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom653 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom701 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom703 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom752 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom754 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom758 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_guard_atom760 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_guard_atom817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_deed841 = new BitSet(new long[]{0x2820084100080000L});
	public static final BitSet FOLLOW_literal_in_deed846 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_deed856 = new BitSet(new long[]{0x2800004000080000L});
	public static final BitSet FOLLOW_goal_in_deed860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOCK_in_deed870 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLAN_in_deed879 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_deed881 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_deed885 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_deed887 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_deed900 = new BitSet(new long[]{0x2820084100080000L});
	public static final BitSet FOLLOW_literal_in_deed905 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_deed915 = new BitSet(new long[]{0x2800004000080000L});
	public static final BitSet FOLLOW_goal_in_deed919 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOCK_in_deed929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLAN_in_deed939 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_deed941 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_deed945 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_deed947 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_deed964 = new BitSet(new long[]{0x2800004000080000L});
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
	public static final BitSet FOLLOW_OPEN_in_substitution1085 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_substitution1089 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_substitution1091 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_substitution1097 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_substitution1099 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_substitution1104 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_substitution1106 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_substitution1112 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_substitution1114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_calculation1134 = new BitSet(new long[]{0x2800004000080000L});
	public static final BitSet FOLLOW_literal_in_calculation1140 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_calculation1142 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_var_in_calculation1146 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_calculation1148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_query1166 = new BitSet(new long[]{0x2800004000080000L});
	public static final BitSet FOLLOW_literal_in_query1172 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_query1175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_wait1193 = new BitSet(new long[]{0x2080018200880000L});
	public static final BitSet FOLLOW_term_in_wait1199 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_wait1201 = new BitSet(new long[]{0x2800004000080000L});
	public static final BitSet FOLLOW_literal_in_wait1205 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_wait1207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_brule1229 = new BitSet(new long[]{0x0004000000000800L});
	public static final BitSet FOLLOW_BRULEARROW_in_brule1232 = new BitSet(new long[]{0x2080004000080000L});
	public static final BitSet FOLLOW_logicalfmla_in_brule1236 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_brule1240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMI_in_brule1244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla1261 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_COMMA_in_logicalfmla1281 = new BitSet(new long[]{0x2080004000080000L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla1285 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_pred_in_notfmla1320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_notfmla1406 = new BitSet(new long[]{0x2000018200000000L});
	public static final BitSet FOLLOW_equation_in_notfmla1412 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_notfmla1414 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_notfmla1497 = new BitSet(new long[]{0x2080010000080000L});
	public static final BitSet FOLLOW_pred_in_notfmla1504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_notfmla1589 = new BitSet(new long[]{0x2000018200000000L});
	public static final BitSet FOLLOW_equation_in_notfmla1595 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_notfmla1597 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subfmla_in_notfmla1685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_subfmla1699 = new BitSet(new long[]{0x2080004000080000L});
	public static final BitSet FOLLOW_logicalfmla_in_subfmla1705 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_subfmla1709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cnotfmla_in_clogicalfmla1723 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_COMMA_in_clogicalfmla1743 = new BitSet(new long[]{0x2000004000080000L});
	public static final BitSet FOLLOW_cnotfmla_in_clogicalfmla1747 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_pred_in_cnotfmla1782 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_cnotfmla1867 = new BitSet(new long[]{0x2000010000080000L});
	public static final BitSet FOLLOW_pred_in_cnotfmla1874 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_csubfmla_in_cnotfmla1963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_csubfmla1977 = new BitSet(new long[]{0x2000004000080000L});
	public static final BitSet FOLLOW_clogicalfmla_in_csubfmla1983 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_csubfmla1987 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_waitfor2002 = new BitSet(new long[]{0x2800004000080000L});
	public static final BitSet FOLLOW_literal_in_waitfor2006 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_action2025 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_PLUS_in_action2027 = new BitSet(new long[]{0x2000018200000000L});
	public static final BitSet FOLLOW_atom_in_action2031 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_EQ_ASSGN_in_action2033 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_var_in_action2037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEND_in_action2046 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_action2048 = new BitSet(new long[]{0x2800004000080000L});
	public static final BitSet FOLLOW_literal_in_action2052 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_action2054 = new BitSet(new long[]{0x0400020000000020L});
	public static final BitSet FOLLOW_performative_in_action2058 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_action2060 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_action2064 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_action2066 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_action2077 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TELL_in_performative2092 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PERFORM_in_performative2098 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACHIEVE_in_performative2104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_classpath_in_environment2395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_classpath2410 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_POINT_in_classpath2415 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_word_in_classpath2419 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_CONST_in_word2520 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word2526 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_agentnameterm2626 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_agentnameterm2634 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_literal2650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_literal2661 = new BitSet(new long[]{0x2000000000080000L});
	public static final BitSet FOLLOW_pred_in_literal2665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_literal2679 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_pred2695 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_pred2702 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function2714 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_OPEN_in_function2719 = new BitSet(new long[]{0x2080018200880000L});
	public static final BitSet FOLLOW_terms_in_function2721 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_function2724 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_terms2737 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_COMMA_in_terms2742 = new BitSet(new long[]{0x2080018200880000L});
	public static final BitSet FOLLOW_terms_in_terms2744 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_term2763 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_term2773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_term2783 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_term2791 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom2809 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom2822 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom2828 = new BitSet(new long[]{0x2000018200000000L});
	public static final BitSet FOLLOW_arithexpr_in_atom2832 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_atom2834 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2847 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_STRING_in_stringterm2850 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2852 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_listterm2865 = new BitSet(new long[]{0x20C0018200880000L});
	public static final BitSet FOLLOW_term_in_listterm2874 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_listterm2876 = new BitSet(new long[]{0x2080018200880000L});
	public static final BitSet FOLLOW_term_in_listterm2882 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_listterm2888 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var2900 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring2917 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2926 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_POINT_in_numberstring2936 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2942 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation2959 = new BitSet(new long[]{0x0000000042000000L});
	public static final BitSet FOLLOW_eqoper_in_equation2963 = new BitSet(new long[]{0x2000018200000000L});
	public static final BitSet FOLLOW_arithexpr_in_equation2967 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2981 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_eqoper2987 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr3003 = new BitSet(new long[]{0x0000200200000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr3011 = new BitSet(new long[]{0x2000018200000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr3015 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_multexpr3032 = new BitSet(new long[]{0x0000000C00400002L});
	public static final BitSet FOLLOW_multoper_in_multexpr3039 = new BitSet(new long[]{0x2000018200000000L});
	public static final BitSet FOLLOW_atom_in_multexpr3043 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper3060 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper3065 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper3080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper3086 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_multoper3092 = new BitSet(new long[]{0x0000000000000002L});
}
