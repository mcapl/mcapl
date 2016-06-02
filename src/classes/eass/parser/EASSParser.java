// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g 2016-03-30 19:39:43

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
		"ARROW", "BAR", "BELIEFRULES", "BELIEFS", "BELIEVE", "BRULEARROW", "CALCULATE", 
		"CAPABILITIES", "CAPABILITY", "CLOSE", "COLON", "COMMA", "COMMENT", "CONST", 
		"CURLYCLOSE", "CURLYOPEN", "DIV", "DOUBLEQUOTE", "EASS", "EQ", "EQ_ASSGN", 
		"GOAL", "GOALS", "IMPLICATION", "LESS", "LINE_COMMENT", "LOCK", "MINUS", 
		"MOD", "MULT", "NAME", "NEWLINE", "NOT", "NUMBER", "OPEN", "PERFORM", 
		"PERFORMGOAL", "PLAN", "PLANS", "PLUS", "POINT", "QUERY", "QUERYCOM", 
		"RECEIVED", "RULEARROW", "SEMI", "SEND", "SENT", "SHRIEK", "SQCLOSE", 
		"SQOPEN", "STRING", "SUBSTITUTE", "TELL", "TRUE", "UNNAMEDVAR", "UPDATE", 
		"VAR", "WAIT", "WS"
	};
	public static final int EOF=-1;
	public static final int ABSTRACTION=4;
	public static final int ACHIEVE=5;
	public static final int ACHIEVEGOAL=6;
	public static final int ARROW=7;
	public static final int BAR=8;
	public static final int BELIEFRULES=9;
	public static final int BELIEFS=10;
	public static final int BELIEVE=11;
	public static final int BRULEARROW=12;
	public static final int CALCULATE=13;
	public static final int CAPABILITIES=14;
	public static final int CAPABILITY=15;
	public static final int CLOSE=16;
	public static final int COLON=17;
	public static final int COMMA=18;
	public static final int COMMENT=19;
	public static final int CONST=20;
	public static final int CURLYCLOSE=21;
	public static final int CURLYOPEN=22;
	public static final int DIV=23;
	public static final int DOUBLEQUOTE=24;
	public static final int EASS=25;
	public static final int EQ=26;
	public static final int EQ_ASSGN=27;
	public static final int GOAL=28;
	public static final int GOALS=29;
	public static final int IMPLICATION=30;
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
	public static final int PLAN=44;
	public static final int PLANS=45;
	public static final int PLUS=46;
	public static final int POINT=47;
	public static final int QUERY=48;
	public static final int QUERYCOM=49;
	public static final int RECEIVED=50;
	public static final int RULEARROW=51;
	public static final int SEMI=52;
	public static final int SEND=53;
	public static final int SENT=54;
	public static final int SHRIEK=55;
	public static final int SQCLOSE=56;
	public static final int SQOPEN=57;
	public static final int STRING=58;
	public static final int SUBSTITUTE=59;
	public static final int TELL=60;
	public static final int TRUE=61;
	public static final int UNNAMEDVAR=62;
	public static final int UPDATE=63;
	public static final int VAR=64;
	public static final int WAIT=65;
	public static final int WS=66;

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
				if ( (LA3_0==CONST||LA3_0==NOT||(LA3_0 >= TRUE && LA3_0 <= UNNAMEDVAR)||LA3_0==VAR) ) {
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
						if ( (LA4_0==CONST||LA4_0==UNNAMEDVAR||LA4_0==VAR) ) {
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
				if ( (LA8_0==CONST||LA8_0==NOT||(LA8_0 >= TRUE && LA8_0 <= UNNAMEDVAR)||LA8_0==VAR) ) {
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
			pushFollow(FOLLOW_literal_in_goal237);
			l=literal();
			state._fsp--;

			match(input,SQOPEN,FOLLOW_SQOPEN_in_goal239); 
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
					match(input,ACHIEVEGOAL,FOLLOW_ACHIEVEGOAL_in_goal242); 
					g = new Abstract_Goal(l, Abstract_Goal.achieveGoal);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:78:2: PERFORMGOAL
					{
					match(input,PERFORMGOAL,FOLLOW_PERFORMGOAL_in_goal250); 
					g = new Abstract_Goal(l, Abstract_Goal.performGoal);
					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_goal255); 
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
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_capability270); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:81:12: (pre= clogicalfmla )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==CONST||LA11_0==NOT||LA11_0==UNNAMEDVAR||LA11_0==VAR) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:81:13: pre= clogicalfmla
					{
					pushFollow(FOLLOW_clogicalfmla_in_capability275);
					pre=clogicalfmla();
					state._fsp--;

					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_capability279); 
			pushFollow(FOLLOW_pred_in_capability285);
			cap=pred();
			state._fsp--;

			c = new Abstract_Capability(cap); if (pre != null) {c.addPre(pre);}
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_capability290); 
			pushFollow(FOLLOW_clogicalfmla_in_capability294);
			post=clogicalfmla();
			state._fsp--;

			c.addPost(post);
			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_capability298); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:86:1: plan returns [Abstract_GPlan p] : e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed[deeds] ( COMMA d= deed[deeds] )* )? SEMI ;
	public final Abstract_GPlan plan() throws RecognitionException {
		Abstract_GPlan p = null;


		Abstract_Event e =null;
		Abstract_GLogicalFormula gb =null;
		Abstract_Deed d =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:87:2: (e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed[deeds] ( COMMA d= deed[deeds] )* )? SEMI )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:87:4: e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed[deeds] ( COMMA d= deed[deeds] )* )? SEMI
			{
			pushFollow(FOLLOW_event_in_plan316);
			e=event();
			state._fsp--;

			ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();
			match(input,COLON,FOLLOW_COLON_in_plan324); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_plan326); 
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
					match(input,NOT,FOLLOW_NOT_in_plan331); 
					gneg=false;
					}
					break;

			}

			pushFollow(FOLLOW_guard_atom_in_plan339);
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
					match(input,COMMA,FOLLOW_COMMA_in_plan347); 
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
							match(input,NOT,FOLLOW_NOT_in_plan352); 
							gneg=false;
							}
							break;

					}

					pushFollow(FOLLOW_guard_atom_in_plan360);
					gb=guard_atom();
					state._fsp--;

					g.add(gb, gneg);
					}
					break;

				default :
					break loop14;
				}
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_plan366); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:93: ( RULEARROW d= deed[deeds] ( COMMA d= deed[deeds] )* )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==RULEARROW) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:94: RULEARROW d= deed[deeds] ( COMMA d= deed[deeds] )*
					{
					match(input,RULEARROW,FOLLOW_RULEARROW_in_plan369); 
					pushFollow(FOLLOW_deed_in_plan374);
					d=deed(deeds);
					state._fsp--;

					deeds.add(d);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:90:35: ( COMMA d= deed[deeds] )*
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( (LA15_0==COMMA) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:90:36: COMMA d= deed[deeds]
							{
							match(input,COMMA,FOLLOW_COMMA_in_plan380); 
							pushFollow(FOLLOW_deed_in_plan384);
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

			match(input,SEMI,FOLLOW_SEMI_in_plan395); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:1: event returns [Abstract_Event e] : ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) ) ;
	public final Abstract_Event event() throws RecognitionException {
		Abstract_Event e = null;


		int p =0;
		Abstract_Predicate t =null;
		Abstract_Literal l =null;
		Abstract_Goal g =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:34: ( ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:36: ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:36: ( PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:37: PLUS ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) )
					{
					match(input,PLUS,FOLLOW_PLUS_in_event412); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:42: ( RECEIVED OPEN p= performative COMMA t= pred CLOSE | (l= literal | SHRIEK g= goal ) )
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==RECEIVED) ) {
						alt18=1;
					}
					else if ( (LA18_0==CONST||LA18_0==NOT||LA18_0==SHRIEK||(LA18_0 >= TRUE && LA18_0 <= UNNAMEDVAR)||LA18_0==VAR) ) {
						alt18=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 18, 0, input);
						throw nvae;
					}

					switch (alt18) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:43: RECEIVED OPEN p= performative COMMA t= pred CLOSE
							{
							match(input,RECEIVED,FOLLOW_RECEIVED_in_event415); 
							match(input,OPEN,FOLLOW_OPEN_in_event417); 
							pushFollow(FOLLOW_performative_in_event421);
							p=performative();
							state._fsp--;

							match(input,COMMA,FOLLOW_COMMA_in_event423); 
							pushFollow(FOLLOW_pred_in_event427);
							t=pred();
							state._fsp--;

							match(input,CLOSE,FOLLOW_CLOSE_in_event429); 
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
							if ( (LA17_0==CONST||LA17_0==NOT||(LA17_0 >= TRUE && LA17_0 <= UNNAMEDVAR)||LA17_0==VAR) ) {
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
									pushFollow(FOLLOW_literal_in_event446);
									l=literal();
									state._fsp--;

									e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, l);
									}
									break;
								case 2 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:98:5: SHRIEK g= goal
									{
									match(input,SHRIEK,FOLLOW_SHRIEK_in_event456); 
									pushFollow(FOLLOW_goal_in_event460);
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
					match(input,MINUS,FOLLOW_MINUS_in_event474); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:99:13: (l= literal | SHRIEK g= goal )
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==CONST||LA19_0==NOT||(LA19_0 >= TRUE && LA19_0 <= UNNAMEDVAR)||LA19_0==VAR) ) {
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
							pushFollow(FOLLOW_literal_in_event479);
							l=literal();
							state._fsp--;

							e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, l);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:100:5: SHRIEK g= goal
							{
							match(input,SHRIEK,FOLLOW_SHRIEK_in_event489); 
							pushFollow(FOLLOW_goal_in_event493);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:1: guard_atom returns [Abstract_GLogicalFormula g] : ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE ) ;
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

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:49: ( ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | TRUE )
			int alt23=5;
			switch ( input.LA(1) ) {
			case BELIEVE:
				{
				alt23=1;
				}
				break;
			case GOAL:
				{
				alt23=2;
				}
				break;
			case SENT:
				{
				alt23=3;
				}
				break;
			case MINUS:
			case NUMBER:
			case OPEN:
			case UNNAMEDVAR:
			case VAR:
				{
				alt23=4;
				}
				break;
			case TRUE:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:52: BELIEVE l= literal
					{
					match(input,BELIEVE,FOLLOW_BELIEVE_in_guard_atom515); 
					pushFollow(FOLLOW_literal_in_guard_atom519);
					l=literal();
					state._fsp--;

					g = new Abstract_GBelief(l);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:103:5: GOAL gl= goal
					{
					match(input,GOAL,FOLLOW_GOAL_in_guard_atom529); 
					pushFollow(FOLLOW_goal_in_guard_atom533);
					gl=goal();
					state._fsp--;

					g = new Abstract_Goal(gl);
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:5: SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE
					{
					match(input,SENT,FOLLOW_SENT_in_guard_atom543); 
					match(input,OPEN,FOLLOW_OPEN_in_guard_atom545); 
					Abstract_StringTerm an1=agentname;
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:52: (st= stringterm |v= var )
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==DOUBLEQUOTE) ) {
						alt21=1;
					}
					else if ( (LA21_0==UNNAMEDVAR||LA21_0==VAR) ) {
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
							pushFollow(FOLLOW_stringterm_in_guard_atom552);
							st=stringterm();
							state._fsp--;

							an1=st;
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:79: v= var
							{
							pushFollow(FOLLOW_var_in_guard_atom560);
							v=var();
							state._fsp--;

							an1 = v;
							}
							break;

					}

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom565); 
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
							pushFollow(FOLLOW_stringterm_in_guard_atom572);
							an2=stringterm();
							state._fsp--;

							match(input,COMMA,FOLLOW_COMMA_in_guard_atom580); 
							agn = an2;
							}
							break;

					}

					pushFollow(FOLLOW_performative_in_guard_atom588);
					p=performative();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom596); 
					pushFollow(FOLLOW_pred_in_guard_atom600);
					t=pred();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_guard_atom602); 
					g = new Abstract_GuardMessage(Abstract_BaseAILStructure.AILSent, agn, an1, p, t);
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:107:5: eq= equation
					{
					pushFollow(FOLLOW_equation_in_guard_atom616);
					eq=equation();
					state._fsp--;

					g = eq;
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:114:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_guard_atom658); 
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
			int alt28=3;
			switch ( input.LA(1) ) {
			case CALCULATE:
			case CONST:
			case MINUS:
			case NUMBER:
			case OPEN:
			case PLUS:
			case QUERYCOM:
			case SEND:
			case UNNAMEDVAR:
			case UPDATE:
			case VAR:
			case WAIT:
				{
				alt28=1;
				}
				break;
			case MULT:
				{
				alt28=2;
				}
				break;
			case SUBSTITUTE:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:64: ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:64: ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action )
					int alt27=6;
					switch ( input.LA(1) ) {
					case PLUS:
						{
						alt27=1;
						}
						break;
					case MINUS:
						{
						int LA27_2 = input.LA(2);
						if ( (LA27_2==CONST||LA27_2==LOCK||LA27_2==NOT||LA27_2==PLAN||LA27_2==SHRIEK||(LA27_2 >= TRUE && LA27_2 <= UNNAMEDVAR)||LA27_2==VAR) ) {
							alt27=1;
						}
						else if ( (LA27_2==NUMBER) ) {
							alt27=6;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 27, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case UPDATE:
						{
						alt27=2;
						}
						break;
					case CALCULATE:
						{
						alt27=3;
						}
						break;
					case QUERYCOM:
						{
						alt27=4;
						}
						break;
					case WAIT:
						{
						alt27=5;
						}
						break;
					case CONST:
					case NUMBER:
					case OPEN:
					case SEND:
					case UNNAMEDVAR:
					case VAR:
						{
						alt27=6;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 27, 0, input);
						throw nvae;
					}
					switch (alt27) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:65: ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) )
							{
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:65: ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) )
							int alt26=2;
							int LA26_0 = input.LA(1);
							if ( (LA26_0==PLUS) ) {
								alt26=1;
							}
							else if ( (LA26_0==MINUS) ) {
								alt26=2;
							}

							else {
								NoViableAltException nvae =
									new NoViableAltException("", 26, 0, input);
								throw nvae;
							}

							switch (alt26) {
								case 1 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:66: PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE )
									{
									match(input,PLUS,FOLLOW_PLUS_in_deed683); 
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:71: (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE )
									int alt24=4;
									switch ( input.LA(1) ) {
									case CONST:
									case NOT:
									case TRUE:
									case UNNAMEDVAR:
									case VAR:
										{
										alt24=1;
										}
										break;
									case SHRIEK:
										{
										alt24=2;
										}
										break;
									case LOCK:
										{
										alt24=3;
										}
										break;
									case PLAN:
										{
										alt24=4;
										}
										break;
									default:
										NoViableAltException nvae =
											new NoViableAltException("", 24, 0, input);
										throw nvae;
									}
									switch (alt24) {
										case 1 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:116:72: l= literal
											{
											pushFollow(FOLLOW_literal_in_deed688);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, l);
											}
											break;
										case 2 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:117:5: SHRIEK g= goal
											{
											match(input,SHRIEK,FOLLOW_SHRIEK_in_deed698); 
											pushFollow(FOLLOW_goal_in_deed702);
											g=goal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, g);
											}
											break;
										case 3 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:118:5: LOCK
											{
											match(input,LOCK,FOLLOW_LOCK_in_deed712); 
											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);
											}
											break;
										case 4 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:119:5: PLAN OPEN p= pred CLOSE
											{
											match(input,PLAN,FOLLOW_PLAN_in_deed721); 
											match(input,OPEN,FOLLOW_OPEN_in_deed723); 
											pushFollow(FOLLOW_pred_in_deed727);
											p=pred();
											state._fsp--;

											match(input,CLOSE,FOLLOW_CLOSE_in_deed729); 
											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.DPlan, p);
											}
											break;

									}

									}
									break;
								case 2 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:120:7: MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE )
									{
									match(input,MINUS,FOLLOW_MINUS_in_deed742); 
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:120:13: (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE )
									int alt25=4;
									switch ( input.LA(1) ) {
									case CONST:
									case NOT:
									case TRUE:
									case UNNAMEDVAR:
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
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:120:14: l= literal
											{
											pushFollow(FOLLOW_literal_in_deed747);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, l);
											}
											break;
										case 2 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:121:5: SHRIEK g= goal
											{
											match(input,SHRIEK,FOLLOW_SHRIEK_in_deed757); 
											pushFollow(FOLLOW_goal_in_deed761);
											g=goal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILDeletion, g);
											}
											break;
										case 3 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:122:5: LOCK
											{
											match(input,LOCK,FOLLOW_LOCK_in_deed771); 
											d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.Dlock);
											}
											break;
										case 4 :
											// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:123:5: PLAN OPEN p= pred CLOSE
											{
											match(input,PLAN,FOLLOW_PLAN_in_deed781); 
											match(input,OPEN,FOLLOW_OPEN_in_deed783); 
											pushFollow(FOLLOW_pred_in_deed787);
											p=pred();
											state._fsp--;

											match(input,CLOSE,FOLLOW_CLOSE_in_deed789); 
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
							match(input,UPDATE,FOLLOW_UPDATE_in_deed806); 
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:125:12: (l= literal )
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:125:13: l= literal
							{
							pushFollow(FOLLOW_literal_in_deed811);
							l=literal();
							state._fsp--;

							d = new Abstract_Deed(Abstract_Deed.AILUpdate, Abstract_Deed.AILBel, l);
							}

							}
							break;
						case 3 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:126:5: CALCULATE c= calculation[ds]
							{
							match(input,CALCULATE,FOLLOW_CALCULATE_in_deed822); 
							pushFollow(FOLLOW_calculation_in_deed826);
							c=calculation(ds);
							state._fsp--;

							d = c;
							}
							break;
						case 4 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:127:5: QUERYCOM q= query[ds]
							{
							match(input,QUERYCOM,FOLLOW_QUERYCOM_in_deed837); 
							pushFollow(FOLLOW_query_in_deed841);
							q=query(ds);
							state._fsp--;

							d = q;
							}
							break;
						case 5 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:128:5: WAIT w= wait[ds]
							{
							match(input,WAIT,FOLLOW_WAIT_in_deed852); 
							pushFollow(FOLLOW_wait_in_deed856);
							w=wait(ds);
							state._fsp--;

							d = w;
							}
							break;
						case 6 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:129:5: a= action
							{
							pushFollow(FOLLOW_action_in_deed869);
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
					pushFollow(FOLLOW_waitfor_in_deed882);
					wf=waitfor();
					state._fsp--;

					d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, wf);
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:131:5: SUBSTITUTE s= substitution[ds]
					{
					match(input,SUBSTITUTE,FOLLOW_SUBSTITUTE_in_deed892); 
					pushFollow(FOLLOW_substitution_in_deed896);
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
			match(input,OPEN,FOLLOW_OPEN_in_substitution928); 
			pushFollow(FOLLOW_pred_in_substitution932);
			pl1=pred();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_substitution934); 
			pushFollow(FOLLOW_pred_in_substitution940);
			c1=pred();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_substitution942); 
			pushFollow(FOLLOW_pred_in_substitution947);
			c2=pred();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_substitution949); 
			pushFollow(FOLLOW_pred_in_substitution955);
			pl2=pred();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_substitution957); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:137:1: calculation[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN l1= literal COMMA v= var CLOSE ;
	public final Abstract_Deed calculation(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Literal l1 =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:137:68: ( OPEN l1= literal COMMA v= var CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:137:70: OPEN l1= literal COMMA v= var CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_calculation973); 
			pushFollow(FOLLOW_literal_in_calculation979);
			l1=literal();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_calculation981); 
			pushFollow(FOLLOW_var_in_calculation985);
			v=var();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_calculation987); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:142:1: query[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN l1= literal CLOSE ;
	public final Abstract_Deed query(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Literal l1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:142:62: ( OPEN l1= literal CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:142:64: OPEN l1= literal CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_query1005); 
			pushFollow(FOLLOW_literal_in_query1011);
			l1=literal();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_query1014); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:147:1: wait[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN l1= term COMMA l2= literal CLOSE ;
	public final Abstract_Deed wait(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Term l1 =null;
		Abstract_Literal l2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:147:61: ( OPEN l1= term COMMA l2= literal CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:147:63: OPEN l1= term COMMA l2= literal CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_wait1032); 
			pushFollow(FOLLOW_term_in_wait1038);
			l1=term();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_wait1040); 
			pushFollow(FOLLOW_literal_in_wait1044);
			l2=literal();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_wait1046); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:152:1: brule returns [Abstract_Rule r] : head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) ;
	public final Abstract_Rule brule() throws RecognitionException {
		Abstract_Rule r = null;


		Abstract_Predicate head =null;
		Abstract_LogicalFormula f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:152:33: (head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:152:35: head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI )
			{
			pushFollow(FOLLOW_pred_in_brule1069);
			head=pred();
			state._fsp--;

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:152:45: ( BRULEARROW f= logicalfmla SEMI | SEMI )
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==BRULEARROW) ) {
				alt29=1;
			}
			else if ( (LA29_0==SEMI) ) {
				alt29=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}

			switch (alt29) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:152:46: BRULEARROW f= logicalfmla SEMI
					{
					match(input,BRULEARROW,FOLLOW_BRULEARROW_in_brule1072); 
					pushFollow(FOLLOW_logicalfmla_in_brule1076);
					f=logicalfmla();
					state._fsp--;

					r = new Abstract_Rule(head, f);
					match(input,SEMI,FOLLOW_SEMI_in_brule1080); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:152:116: SEMI
					{
					match(input,SEMI,FOLLOW_SEMI_in_brule1084); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:154:1: logicalfmla returns [Abstract_LogicalFormula f] : n= notfmla ( COMMA n2= notfmla )* ;
	public final Abstract_LogicalFormula logicalfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula n =null;
		Abstract_LogicalFormula n2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:154:49: (n= notfmla ( COMMA n2= notfmla )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:154:51: n= notfmla ( COMMA n2= notfmla )*
			{
			pushFollow(FOLLOW_notfmla_in_logicalfmla1102);
			n=notfmla();
			state._fsp--;

			f = n;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:155:16: ( COMMA n2= notfmla )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==COMMA) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:155:17: COMMA n2= notfmla
					{
					match(input,COMMA,FOLLOW_COMMA_in_logicalfmla1122); 
					pushFollow(FOLLOW_notfmla_in_logicalfmla1126);
					n2=notfmla();
					state._fsp--;

					f = new Abstract_LogExpr(f, Abstract_LogExpr.and, n2);
					}
					break;

				default :
					break loop30;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:157:1: notfmla returns [Abstract_LogicalFormula f] : ( (gb= pred | SQOPEN eq= equation SQCLOSE ) | NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla ) );
	public final Abstract_LogicalFormula notfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_Predicate gb =null;
		Abstract_Equation eq =null;
		Abstract_Predicate gb2 =null;
		Abstract_LogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:157:45: ( (gb= pred | SQOPEN eq= equation SQCLOSE ) | NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla ) )
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==CONST||LA33_0==SQOPEN||LA33_0==UNNAMEDVAR||LA33_0==VAR) ) {
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:157:47: (gb= pred | SQOPEN eq= equation SQCLOSE )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:157:47: (gb= pred | SQOPEN eq= equation SQCLOSE )
					int alt31=2;
					int LA31_0 = input.LA(1);
					if ( (LA31_0==CONST||LA31_0==UNNAMEDVAR||LA31_0==VAR) ) {
						alt31=1;
					}
					else if ( (LA31_0==SQOPEN) ) {
						alt31=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 31, 0, input);
						throw nvae;
					}

					switch (alt31) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:157:48: gb= pred
							{
							pushFollow(FOLLOW_pred_in_notfmla1162);
							gb=pred();
							state._fsp--;

							f = gb;
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:157:73: SQOPEN eq= equation SQCLOSE
							{
							match(input,SQOPEN,FOLLOW_SQOPEN_in_notfmla1170); 
							pushFollow(FOLLOW_equation_in_notfmla1176);
							eq=equation();
							state._fsp--;

							f = eq;
							match(input,SQCLOSE,FOLLOW_SQCLOSE_in_notfmla1180); 
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:158:79: NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla )
					{
					match(input,NOT,FOLLOW_NOT_in_notfmla1264); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:158:83: (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla )
					int alt32=3;
					switch ( input.LA(1) ) {
					case CONST:
					case UNNAMEDVAR:
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:158:84: gb2= pred
							{
							pushFollow(FOLLOW_pred_in_notfmla1271);
							gb2=pred();
							state._fsp--;

							f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:159:79: SQOPEN eq= equation SQCLOSE
							{
							match(input,SQOPEN,FOLLOW_SQOPEN_in_notfmla1355); 
							pushFollow(FOLLOW_equation_in_notfmla1361);
							eq=equation();
							state._fsp--;

							match(input,SQCLOSE,FOLLOW_SQCLOSE_in_notfmla1363); 
							f = new Abstract_LogExpr(Abstract_LogExpr.not, eq);
							}
							break;
						case 3 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:160:80: lf= subfmla
							{
							pushFollow(FOLLOW_subfmla_in_notfmla1452);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:161:1: subfmla returns [Abstract_LogicalFormula f] : OPEN lf= logicalfmla CLOSE ;
	public final Abstract_LogicalFormula subfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:161:45: ( OPEN lf= logicalfmla CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:161:47: OPEN lf= logicalfmla CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_subfmla1466); 
			pushFollow(FOLLOW_logicalfmla_in_subfmla1472);
			lf=logicalfmla();
			state._fsp--;

			f = lf;
			match(input,CLOSE,FOLLOW_CLOSE_in_subfmla1476); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:1: clogicalfmla returns [Abstract_GLogicalFormula f] : n= cnotfmla ( COMMA n2= cnotfmla )* ;
	public final Abstract_GLogicalFormula clogicalfmla() throws RecognitionException {
		Abstract_GLogicalFormula f = null;


		Abstract_GLogicalFormula n =null;
		Abstract_GLogicalFormula n2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:51: (n= cnotfmla ( COMMA n2= cnotfmla )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:53: n= cnotfmla ( COMMA n2= cnotfmla )*
			{
			pushFollow(FOLLOW_cnotfmla_in_clogicalfmla1491);
			n=cnotfmla();
			state._fsp--;

			f = n;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:164:16: ( COMMA n2= cnotfmla )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==COMMA) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:164:17: COMMA n2= cnotfmla
					{
					match(input,COMMA,FOLLOW_COMMA_in_clogicalfmla1511); 
					pushFollow(FOLLOW_cnotfmla_in_clogicalfmla1515);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:166:1: cnotfmla returns [Abstract_GLogicalFormula f] : (gb= pred | NOT (gb2= pred |lf= csubfmla ) );
	public final Abstract_GLogicalFormula cnotfmla() throws RecognitionException {
		Abstract_GLogicalFormula f = null;


		Abstract_Predicate gb =null;
		Abstract_Predicate gb2 =null;
		Abstract_GLogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:166:47: (gb= pred | NOT (gb2= pred |lf= csubfmla ) )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==CONST||LA36_0==UNNAMEDVAR||LA36_0==VAR) ) {
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:166:49: gb= pred
					{
					pushFollow(FOLLOW_pred_in_cnotfmla1550);
					gb=pred();
					state._fsp--;

					f = new Abstract_GBelief(new Abstract_Literal(gb));
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:167:79: NOT (gb2= pred |lf= csubfmla )
					{
					match(input,NOT,FOLLOW_NOT_in_cnotfmla1635); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:167:83: (gb2= pred |lf= csubfmla )
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==CONST||LA35_0==UNNAMEDVAR||LA35_0==VAR) ) {
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:167:84: gb2= pred
							{
							pushFollow(FOLLOW_pred_in_cnotfmla1642);
							gb2=pred();
							state._fsp--;

							f = new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal(gb2)));
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:168:79: lf= csubfmla
							{
							pushFollow(FOLLOW_csubfmla_in_cnotfmla1731);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:169:1: csubfmla returns [Abstract_GLogicalFormula f] : OPEN lf= clogicalfmla CLOSE ;
	public final Abstract_GLogicalFormula csubfmla() throws RecognitionException {
		Abstract_GLogicalFormula f = null;


		Abstract_GLogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:169:47: ( OPEN lf= clogicalfmla CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:169:49: OPEN lf= clogicalfmla CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_csubfmla1745); 
			pushFollow(FOLLOW_clogicalfmla_in_csubfmla1751);
			lf=clogicalfmla();
			state._fsp--;

			f = lf;
			match(input,CLOSE,FOLLOW_CLOSE_in_csubfmla1755); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:172:1: waitfor returns [Abstract_Literal wf] : MULT l= literal ;
	public final Abstract_Literal waitfor() throws RecognitionException {
		Abstract_Literal wf = null;


		Abstract_Literal l =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:172:39: ( MULT l= literal )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:172:42: MULT l= literal
			{
			match(input,MULT,FOLLOW_MULT_in_waitfor1771); 
			pushFollow(FOLLOW_literal_in_waitfor1775);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:174:1: action returns [Abstract_Action a] : ( (a1= atom PLUS a2= atom EQ_ASSGN v= var ) | ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred );
	public final Abstract_Action action() throws RecognitionException {
		Abstract_Action a = null;


		Abstract_NumberTerm a1 =null;
		Abstract_NumberTerm a2 =null;
		Abstract_VarTerm v =null;
		Abstract_Literal an =null;
		int p =0;
		Abstract_Predicate t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:174:36: ( (a1= atom PLUS a2= atom EQ_ASSGN v= var ) | ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred )
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
			case UNNAMEDVAR:
				{
				int LA37_4 = input.LA(2);
				if ( (LA37_4==PLUS) ) {
					alt37=1;
				}
				else if ( (LA37_4==COMMA||LA37_4==SEMI) ) {
					alt37=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 37, 4, input);
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:175:2: (a1= atom PLUS a2= atom EQ_ASSGN v= var )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:175:2: (a1= atom PLUS a2= atom EQ_ASSGN v= var )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:175:3: a1= atom PLUS a2= atom EQ_ASSGN v= var
					{
					pushFollow(FOLLOW_atom_in_action1795);
					a1=atom();
					state._fsp--;

					match(input,PLUS,FOLLOW_PLUS_in_action1797); 
					pushFollow(FOLLOW_atom_in_action1801);
					a2=atom();
					state._fsp--;

					match(input,EQ_ASSGN,FOLLOW_EQ_ASSGN_in_action1803); 
					pushFollow(FOLLOW_var_in_action1807);
					v=var();
					state._fsp--;

					a = new Abstract_Action("sum"); a.addTerm(a1); a.addTerm(a2); a.addTerm(v); 
					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:176:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:176:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:176:3: SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE
					{
					match(input,SEND,FOLLOW_SEND_in_action1816); 
					match(input,OPEN,FOLLOW_OPEN_in_action1818); 
					pushFollow(FOLLOW_literal_in_action1822);
					an=literal();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_action1824); 
					pushFollow(FOLLOW_performative_in_action1828);
					p=performative();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_action1830); 
					pushFollow(FOLLOW_pred_in_action1834);
					t=pred();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_action1836); 
					a = new Abstract_SendAction(an, p, t);
					}

					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:177:2: t= pred
					{
					pushFollow(FOLLOW_pred_in_action1847);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:179:1: performative returns [int b] : ( TELL | PERFORM | ACHIEVE ) ;
	public final int performative() throws RecognitionException {
		int b = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:179:30: ( ( TELL | PERFORM | ACHIEVE ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:179:32: ( TELL | PERFORM | ACHIEVE )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:179:32: ( TELL | PERFORM | ACHIEVE )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:179:33: TELL
					{
					match(input,TELL,FOLLOW_TELL_in_performative1863); 
					b =1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:179:48: PERFORM
					{
					match(input,PERFORM,FOLLOW_PERFORM_in_performative1869); 
					b =2;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:179:66: ACHIEVE
					{
					match(input,ACHIEVE,FOLLOW_ACHIEVE_in_performative1875); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:1: environment returns [String env] : w= classpath ;
	public final String environment() throws RecognitionException {
		String env = null;


		String w =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:34: (w= classpath )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:222:36: w= classpath
			{
			pushFollow(FOLLOW_classpath_in_environment2167);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:223:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
	public final String classpath() throws RecognitionException {
		String s = null;


		String w =null;
		String w1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:223:30: (w= word ( POINT w1= word )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:223:32: w= word ( POINT w1= word )+
			{
			pushFollow(FOLLOW_word_in_classpath2182);
			w=word();
			state._fsp--;

			s = w;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:223:52: ( POINT w1= word )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:223:53: POINT w1= word
					{
					match(input,POINT,FOLLOW_POINT_in_classpath2187); 
					pushFollow(FOLLOW_word_in_classpath2191);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:224:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:224:25: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:224:27: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:224:27: ( CONST | VAR )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:224:28: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_word2292); 
					s =CONST1.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:224:59: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_word2298); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:226:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
	public final Abstract_StringTerm agentnameterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token CONST3=null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:226:47: ( CONST |v= var )
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==CONST) ) {
				alt41=1;
			}
			else if ( (LA41_0==UNNAMEDVAR||LA41_0==VAR) ) {
				alt41=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}

			switch (alt41) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:226:49: CONST
					{
					CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm2398); 
					s = new Abstract_StringTermImpl(CONST3.getText());
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:226:111: v= var
					{
					pushFollow(FOLLOW_var_in_agentnameterm2406);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:229:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
	public final Abstract_Literal literal() throws RecognitionException {
		Abstract_Literal l = null;


		Abstract_Predicate nt =null;
		Abstract_Predicate t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:229:37: ( ( TRUE | NOT nt= pred ) |t= pred )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==NOT||LA43_0==TRUE) ) {
				alt43=1;
			}
			else if ( (LA43_0==CONST||LA43_0==UNNAMEDVAR||LA43_0==VAR) ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:229:40: ( TRUE | NOT nt= pred )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:229:40: ( TRUE | NOT nt= pred )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:229:41: TRUE
							{
							match(input,TRUE,FOLLOW_TRUE_in_literal2423); 
							l = new Abstract_Literal(Abstract_Literal.LTrue);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:230:5: NOT nt= pred
							{
							match(input,NOT,FOLLOW_NOT_in_literal2434); 
							pushFollow(FOLLOW_pred_in_literal2438);
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:234:5: t= pred
					{
					pushFollow(FOLLOW_pred_in_literal2452);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:1: pred returns [Abstract_Predicate t] : (v= var |f= function );
	public final Abstract_Predicate pred() throws RecognitionException {
		Abstract_Predicate t = null;


		Abstract_VarTerm v =null;
		Abstract_Predicate f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:37: (v= var |f= function )
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==UNNAMEDVAR||LA44_0==VAR) ) {
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:39: v= var
					{
					pushFollow(FOLLOW_var_in_pred2469);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:238:59: f= function
					{
					pushFollow(FOLLOW_function_in_pred2476);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:239:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
	public final Abstract_Predicate function() throws RecognitionException {
		Abstract_Predicate f = null;


		Token CONST4=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:239:40: ( CONST ( OPEN terms[$f] CLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:239:42: CONST ( OPEN terms[$f] CLOSE )?
			{
			CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_function2489); 
			f = new Abstract_Predicate(CONST4.getText());
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:239:97: ( OPEN terms[$f] CLOSE )?
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==OPEN) ) {
				alt45=1;
			}
			switch (alt45) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:239:98: OPEN terms[$f] CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function2494); 
					pushFollow(FOLLOW_terms_in_function2496);
					terms(f);
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_function2499); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
	public final void terms(Abstract_Predicate f) throws RecognitionException {
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:29: (t= term ( COMMA terms[$f] )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:31: t= term ( COMMA terms[$f] )?
			{
			pushFollow(FOLLOW_term_in_terms2513);
			t=term();
			state._fsp--;

			f.addTerm(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:58: ( COMMA terms[$f] )?
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==COMMA) ) {
				alt46=1;
			}
			switch (alt46) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:241:59: COMMA terms[$f]
					{
					match(input,COMMA,FOLLOW_COMMA_in_terms2518); 
					pushFollow(FOLLOW_terms_in_terms2520);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:242:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |f= function |l= listterm );
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_NumberTerm a =null;
		Abstract_StringTerm s =null;
		Abstract_Predicate f =null;
		Abstract_ListTerm l =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:242:31: (a= atom |s= stringterm |f= function |l= listterm )
			int alt47=4;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
			case OPEN:
			case UNNAMEDVAR:
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
			case SQOPEN:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:242:34: a= atom
					{
					pushFollow(FOLLOW_atom_in_term2539);
					a=atom();
					state._fsp--;

					t = a;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:243:2: s= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term2551);
					s=stringterm();
					state._fsp--;

					t = s;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:244:2: f= function
					{
					pushFollow(FOLLOW_function_in_term2561);
					f=function();
					state._fsp--;

					t = f;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:245:2: l= listterm
					{
					pushFollow(FOLLOW_listterm_in_term2572);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:247:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
	public final Abstract_NumberTerm atom() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;
		Abstract_NumberTerm a =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:247:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
			int alt48=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
				{
				alt48=1;
				}
				break;
			case UNNAMEDVAR:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:247:40: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom2591);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:6: v= var
					{
					pushFollow(FOLLOW_var_in_atom2604);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:27: OPEN a= arithexpr CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_atom2610); 
					pushFollow(FOLLOW_arithexpr_in_atom2614);
					a=arithexpr();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_atom2616); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:250:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING5=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:250:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:250:46: DOUBLEQUOTE STRING DOUBLEQUOTE
			{
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2630); 
			STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm2633); 
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2635); 
					 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:1: listterm returns [Abstract_ListTerm l] : SQOPEN (hl= listheads ( BAR v= var )? )? SQCLOSE ;
	public final Abstract_ListTerm listterm() throws RecognitionException {
		Abstract_ListTerm l = null;


		ArrayList<Abstract_Term> hl =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:40: ( SQOPEN (hl= listheads ( BAR v= var )? )? SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:42: SQOPEN (hl= listheads ( BAR v= var )? )? SQCLOSE
			{
			l = new Abstract_ListTermImpl();
			match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2670); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:85: (hl= listheads ( BAR v= var )? )?
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==CONST||LA50_0==DOUBLEQUOTE||LA50_0==MINUS||(LA50_0 >= NUMBER && LA50_0 <= OPEN)||LA50_0==SQOPEN||LA50_0==UNNAMEDVAR||LA50_0==VAR) ) {
				alt50=1;
			}
			switch (alt50) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:86: hl= listheads ( BAR v= var )?
					{
					pushFollow(FOLLOW_listheads_in_listterm2675);
					hl=listheads();
					state._fsp--;

					l.addAll(hl);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:120: ( BAR v= var )?
					int alt49=2;
					int LA49_0 = input.LA(1);
					if ( (LA49_0==BAR) ) {
						alt49=1;
					}
					switch (alt49) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:121: BAR v= var
							{
							match(input,BAR,FOLLOW_BAR_in_listterm2680); 
							pushFollow(FOLLOW_var_in_listterm2684);
							v=var();
							state._fsp--;

							l.addTail(v);
							}
							break;

					}

					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2692); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:255:1: listheads returns [ArrayList<Abstract_Term> tl] : t1= term ( COMMA tl2= term )* ;
	public final ArrayList<Abstract_Term> listheads() throws RecognitionException {
		ArrayList<Abstract_Term> tl = null;


		Abstract_Term t1 =null;
		Abstract_Term tl2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:255:48: (t1= term ( COMMA tl2= term )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:255:50: t1= term ( COMMA tl2= term )*
			{
			pushFollow(FOLLOW_term_in_listheads2708);
			t1=term();
			state._fsp--;

			tl = new ArrayList<Abstract_Term>(); tl.add(t1);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:255:116: ( COMMA tl2= term )*
			loop51:
			while (true) {
				int alt51=2;
				int LA51_0 = input.LA(1);
				if ( (LA51_0==COMMA) ) {
					alt51=1;
				}

				switch (alt51) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:255:117: COMMA tl2= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_listheads2713); 
					pushFollow(FOLLOW_term_in_listheads2718);
					tl2=term();
					state._fsp--;

					tl.add(tl2);
					}
					break;

				default :
					break loop51;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:258:1: var returns [Abstract_VarTerm v] : ( VAR | UNNAMEDVAR ) ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR6=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:258:34: ( ( VAR | UNNAMEDVAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:258:36: ( VAR | UNNAMEDVAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:258:36: ( VAR | UNNAMEDVAR )
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==VAR) ) {
				alt52=1;
			}
			else if ( (LA52_0==UNNAMEDVAR) ) {
				alt52=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 52, 0, input);
				throw nvae;
			}

			switch (alt52) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:258:37: VAR
					{
					VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_var2736); 

						if (variables.containsKey(VAR6.getText())) {
							v = variables.get(VAR6.getText());
							} else {
							v = new Abstract_VarTerm(VAR6.getText());
							variables.put(VAR6.getText(), v);
							}
						
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:265:6: UNNAMEDVAR
					{
					match(input,UNNAMEDVAR,FOLLOW_UNNAMEDVAR_in_var2742); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:267:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:267:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:267:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
			{
			s = "";
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:267:46: ( MINUS )?
			int alt53=2;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==MINUS) ) {
				alt53=1;
			}
			switch (alt53) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:267:47: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring2760); 
					s += "-";
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:267:68: (n1= NUMBER ( POINT n2= NUMBER )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:267:69: n1= NUMBER ( POINT n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2769); 
			s += n1.getText();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:268:6: ( POINT n2= NUMBER )?
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==POINT) ) {
				alt54=1;
			}
			switch (alt54) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:268:7: POINT n2= NUMBER
					{
					match(input,POINT,FOLLOW_POINT_in_numberstring2779); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2785); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:269:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation eq = null;


		Abstract_NumberTerm a1 =null;
		int oper =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:269:40: (a1= arithexpr oper= eqoper a2= arithexpr )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:269:42: a1= arithexpr oper= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation2803);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation2807);
			oper=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation2811);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:270:1: eqoper returns [int oper] : ( LESS | EQ );
	public final int eqoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:270:27: ( LESS | EQ )
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==LESS) ) {
				alt55=1;
			}
			else if ( (LA55_0==EQ) ) {
				alt55=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 55, 0, input);
				throw nvae;
			}

			switch (alt55) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:270:29: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2825); 
					oper =Abstract_Equation.less;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:270:68: EQ
					{
					match(input,EQ,FOLLOW_EQ_in_eqoper2831); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:272:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm m =null;
		int oper =0;
		Abstract_NumberTerm m1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:272:43: (m= multexpr (oper= addoper m1= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:272:45: m= multexpr (oper= addoper m1= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr2847);
			m=multexpr();
			state._fsp--;

			t = m;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:272:69: (oper= addoper m1= multexpr )?
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==MINUS||LA56_0==PLUS) ) {
				alt56=1;
			}
			switch (alt56) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:272:71: oper= addoper m1= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr2855);
					oper=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr2859);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:273:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm a =null;
		int oper =0;
		Abstract_NumberTerm a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:273:42: (a= atom (oper= multoper a1= atom )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:273:44: a= atom (oper= multoper a1= atom )?
			{
			pushFollow(FOLLOW_atom_in_multexpr2876);
			a=atom();
			state._fsp--;

			t = a;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:273:64: (oper= multoper a1= atom )?
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==DIV||(LA57_0 >= MOD && LA57_0 <= MULT)) ) {
				alt57=1;
			}
			switch (alt57) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:273:65: oper= multoper a1= atom
					{
					pushFollow(FOLLOW_multoper_in_multexpr2883);
					oper=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_in_multexpr2887);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:275:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:275:28: ( ( PLUS | MINUS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:275:30: ( PLUS | MINUS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:275:30: ( PLUS | MINUS )
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==PLUS) ) {
				alt58=1;
			}
			else if ( (LA58_0==MINUS) ) {
				alt58=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 58, 0, input);
				throw nvae;
			}

			switch (alt58) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:275:31: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper2904); 
					oper =Abstract_ArithExpr.plus;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:275:70: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper2909); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:276:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
	public final int multoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:276:29: ( ( MULT | DIV | MOD ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:276:31: ( MULT | DIV | MOD )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:276:31: ( MULT | DIV | MOD )
			int alt59=3;
			switch ( input.LA(1) ) {
			case MULT:
				{
				alt59=1;
				}
				break;
			case DIV:
				{
				alt59=2;
				}
				break;
			case MOD:
				{
				alt59=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 59, 0, input);
				throw nvae;
			}
			switch (alt59) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:276:32: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper2924); 
					oper =Abstract_ArithExpr.times;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:276:73: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper2930); 
					oper =Abstract_ArithExpr.div;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/eass/parser/EASS.g:276:111: MOD
					{
					match(input,MOD,FOLLOW_MOD_in_multoper2936); 
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
	public static final BitSet FOLLOW_EASS_in_eassagents102 = new BitSet(new long[]{0x0000002000000010L});
	public static final BitSet FOLLOW_eassagent_in_eassagents111 = new BitSet(new long[]{0x0000002000000012L});
	public static final BitSet FOLLOW_NAME_in_eassagent130 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_word_in_eassagent134 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ABSTRACTION_in_eassagent141 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_word_in_eassagent145 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_BELIEFS_in_eassagent157 = new BitSet(new long[]{0x6000008020104200L,0x0000000000000001L});
	public static final BitSet FOLLOW_literal_in_eassagent162 = new BitSet(new long[]{0x6000008020104200L,0x0000000000000001L});
	public static final BitSet FOLLOW_BELIEFRULES_in_eassagent170 = new BitSet(new long[]{0x4000000020104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_brule_in_eassagent175 = new BitSet(new long[]{0x4000000020104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_CAPABILITIES_in_eassagent185 = new BitSet(new long[]{0x0000000020400000L});
	public static final BitSet FOLLOW_capability_in_eassagent190 = new BitSet(new long[]{0x0000000020400000L});
	public static final BitSet FOLLOW_GOALS_in_eassagent199 = new BitSet(new long[]{0x6000208000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goal_in_eassagent204 = new BitSet(new long[]{0x6000208000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_PLANS_in_eassagent211 = new BitSet(new long[]{0x0000400400000002L});
	public static final BitSet FOLLOW_plan_in_eassagent216 = new BitSet(new long[]{0x0000400400000002L});
	public static final BitSet FOLLOW_literal_in_goal237 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_SQOPEN_in_goal239 = new BitSet(new long[]{0x0000080000000040L});
	public static final BitSet FOLLOW_ACHIEVEGOAL_in_goal242 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_PERFORMGOAL_in_goal250 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_goal255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURLYOPEN_in_capability270 = new BitSet(new long[]{0x4000008000300000L,0x0000000000000001L});
	public static final BitSet FOLLOW_clogicalfmla_in_capability275 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_capability279 = new BitSet(new long[]{0x4000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_pred_in_capability285 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_capability290 = new BitSet(new long[]{0x4000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_clogicalfmla_in_capability294 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_capability298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_event_in_plan316 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COLON_in_plan324 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_plan326 = new BitSet(new long[]{0x6040038410000800L,0x0000000000000001L});
	public static final BitSet FOLLOW_NOT_in_plan331 = new BitSet(new long[]{0x6040030410000800L,0x0000000000000001L});
	public static final BitSet FOLLOW_guard_atom_in_plan339 = new BitSet(new long[]{0x0000000000240000L});
	public static final BitSet FOLLOW_COMMA_in_plan347 = new BitSet(new long[]{0x6040038410000800L,0x0000000000000001L});
	public static final BitSet FOLLOW_NOT_in_plan352 = new BitSet(new long[]{0x6040030410000800L,0x0000000000000001L});
	public static final BitSet FOLLOW_guard_atom_in_plan360 = new BitSet(new long[]{0x0000000000240000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_plan366 = new BitSet(new long[]{0x0018000000000000L});
	public static final BitSet FOLLOW_RULEARROW_in_plan369 = new BitSet(new long[]{0xC822431400102000L,0x0000000000000003L});
	public static final BitSet FOLLOW_deed_in_plan374 = new BitSet(new long[]{0x0010000000040000L});
	public static final BitSet FOLLOW_COMMA_in_plan380 = new BitSet(new long[]{0xC822431400102000L,0x0000000000000003L});
	public static final BitSet FOLLOW_deed_in_plan384 = new BitSet(new long[]{0x0010000000040000L});
	public static final BitSet FOLLOW_SEMI_in_plan395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_event412 = new BitSet(new long[]{0x6084008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_RECEIVED_in_event415 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_OPEN_in_event417 = new BitSet(new long[]{0x1000040000000020L});
	public static final BitSet FOLLOW_performative_in_event421 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COMMA_in_event423 = new BitSet(new long[]{0x4000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_pred_in_event427 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CLOSE_in_event429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_event446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_event456 = new BitSet(new long[]{0x6000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goal_in_event460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_event474 = new BitSet(new long[]{0x6080008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_literal_in_event479 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_event489 = new BitSet(new long[]{0x6000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goal_in_event493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BELIEVE_in_guard_atom515 = new BitSet(new long[]{0x6000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_literal_in_guard_atom519 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_guard_atom529 = new BitSet(new long[]{0x6000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goal_in_guard_atom533 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SENT_in_guard_atom543 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_OPEN_in_guard_atom545 = new BitSet(new long[]{0x4000000001000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_stringterm_in_guard_atom552 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_var_in_guard_atom560 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom565 = new BitSet(new long[]{0x1000040001000020L});
	public static final BitSet FOLLOW_stringterm_in_guard_atom572 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom580 = new BitSet(new long[]{0x1000040000000020L});
	public static final BitSet FOLLOW_performative_in_guard_atom588 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom596 = new BitSet(new long[]{0x4000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_pred_in_guard_atom600 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CLOSE_in_guard_atom602 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_guard_atom616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_guard_atom658 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_deed683 = new BitSet(new long[]{0x6080108200100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_literal_in_deed688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_deed698 = new BitSet(new long[]{0x6000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goal_in_deed702 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOCK_in_deed712 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLAN_in_deed721 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_OPEN_in_deed723 = new BitSet(new long[]{0x4000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_pred_in_deed727 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CLOSE_in_deed729 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_deed742 = new BitSet(new long[]{0x6080108200100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_literal_in_deed747 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_deed757 = new BitSet(new long[]{0x6000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goal_in_deed761 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOCK_in_deed771 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLAN_in_deed781 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_OPEN_in_deed783 = new BitSet(new long[]{0x4000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_pred_in_deed787 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CLOSE_in_deed789 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_deed806 = new BitSet(new long[]{0x6000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_literal_in_deed811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CALCULATE_in_deed822 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_calculation_in_deed826 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QUERYCOM_in_deed837 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_query_in_deed841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WAIT_in_deed852 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_wait_in_deed856 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_deed869 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_waitfor_in_deed882 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUBSTITUTE_in_deed892 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_substitution_in_deed896 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_substitution928 = new BitSet(new long[]{0x4000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_pred_in_substitution932 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COMMA_in_substitution934 = new BitSet(new long[]{0x4000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_pred_in_substitution940 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COMMA_in_substitution942 = new BitSet(new long[]{0x4000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_pred_in_substitution947 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COMMA_in_substitution949 = new BitSet(new long[]{0x4000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_pred_in_substitution955 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CLOSE_in_substitution957 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_calculation973 = new BitSet(new long[]{0x6000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_literal_in_calculation979 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COMMA_in_calculation981 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_var_in_calculation985 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CLOSE_in_calculation987 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_query1005 = new BitSet(new long[]{0x6000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_literal_in_query1011 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CLOSE_in_query1014 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_wait1032 = new BitSet(new long[]{0x4200030401100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_wait1038 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COMMA_in_wait1040 = new BitSet(new long[]{0x6000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_literal_in_wait1044 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CLOSE_in_wait1046 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_brule1069 = new BitSet(new long[]{0x0010000000001000L});
	public static final BitSet FOLLOW_BRULEARROW_in_brule1072 = new BitSet(new long[]{0x4200008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_logicalfmla_in_brule1076 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_brule1080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMI_in_brule1084 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla1102 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_COMMA_in_logicalfmla1122 = new BitSet(new long[]{0x4200008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla1126 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_pred_in_notfmla1162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_notfmla1170 = new BitSet(new long[]{0x4000030400000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_equation_in_notfmla1176 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_notfmla1180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_notfmla1264 = new BitSet(new long[]{0x4200020000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_pred_in_notfmla1271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_notfmla1355 = new BitSet(new long[]{0x4000030400000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_equation_in_notfmla1361 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_notfmla1363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subfmla_in_notfmla1452 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_subfmla1466 = new BitSet(new long[]{0x4200008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_logicalfmla_in_subfmla1472 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CLOSE_in_subfmla1476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cnotfmla_in_clogicalfmla1491 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_COMMA_in_clogicalfmla1511 = new BitSet(new long[]{0x4000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_cnotfmla_in_clogicalfmla1515 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_pred_in_cnotfmla1550 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_cnotfmla1635 = new BitSet(new long[]{0x4000020000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_pred_in_cnotfmla1642 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_csubfmla_in_cnotfmla1731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_csubfmla1745 = new BitSet(new long[]{0x4000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_clogicalfmla_in_csubfmla1751 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CLOSE_in_csubfmla1755 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_waitfor1771 = new BitSet(new long[]{0x6000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_literal_in_waitfor1775 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_action1795 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_PLUS_in_action1797 = new BitSet(new long[]{0x4000030400000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_atom_in_action1801 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_EQ_ASSGN_in_action1803 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_var_in_action1807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEND_in_action1816 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_OPEN_in_action1818 = new BitSet(new long[]{0x6000008000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_literal_in_action1822 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COMMA_in_action1824 = new BitSet(new long[]{0x1000040000000020L});
	public static final BitSet FOLLOW_performative_in_action1828 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COMMA_in_action1830 = new BitSet(new long[]{0x4000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_pred_in_action1834 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CLOSE_in_action1836 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_action1847 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TELL_in_performative1863 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PERFORM_in_performative1869 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACHIEVE_in_performative1875 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_classpath_in_environment2167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_classpath2182 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_POINT_in_classpath2187 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_word_in_classpath2191 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_CONST_in_word2292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word2298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_agentnameterm2398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_agentnameterm2406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_literal2423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_literal2434 = new BitSet(new long[]{0x4000000000100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_pred_in_literal2438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_literal2452 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_pred2469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_pred2476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function2489 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_OPEN_in_function2494 = new BitSet(new long[]{0x4200030401100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_terms_in_function2496 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CLOSE_in_function2499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_terms2513 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_COMMA_in_terms2518 = new BitSet(new long[]{0x4200030401100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_terms_in_terms2520 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_term2539 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_term2551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_term2561 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_term2572 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom2591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom2604 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom2610 = new BitSet(new long[]{0x4000030400000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_arithexpr_in_atom2614 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CLOSE_in_atom2616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2630 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_STRING_in_stringterm2633 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_listterm2670 = new BitSet(new long[]{0x4300030401100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_listheads_in_listterm2675 = new BitSet(new long[]{0x0100000000000100L});
	public static final BitSet FOLLOW_BAR_in_listterm2680 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_var_in_listterm2684 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_listterm2692 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_listheads2708 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_COMMA_in_listheads2713 = new BitSet(new long[]{0x4200030401100000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_listheads2718 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_VAR_in_var2736 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNNAMEDVAR_in_var2742 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring2760 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2769 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_POINT_in_numberstring2779 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2785 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation2803 = new BitSet(new long[]{0x0000000084000000L});
	public static final BitSet FOLLOW_eqoper_in_equation2807 = new BitSet(new long[]{0x4000030400000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_arithexpr_in_equation2811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_eqoper2831 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2847 = new BitSet(new long[]{0x0000400400000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr2855 = new BitSet(new long[]{0x4000030400000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2859 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_multexpr2876 = new BitSet(new long[]{0x0000001800800002L});
	public static final BitSet FOLLOW_multoper_in_multexpr2883 = new BitSet(new long[]{0x4000030400000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_atom_in_multexpr2887 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper2904 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper2909 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper2924 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper2930 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_multoper2936 = new BitSet(new long[]{0x0000000000000002L});
}
