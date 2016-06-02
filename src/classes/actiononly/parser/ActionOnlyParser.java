// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g 2016-06-02 13:52:30

package actiononly.parser;

import ail.syntax.ast.*;
import actiononly.syntax.ast.*;
import java.util.HashMap;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ActionOnlyParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTIONONLY", "ACTIONS", "BELIEFRULES", 
		"BELIEFS", "BELIEVE", "BRULEARROW", "CLOSE", "COLON", "COMMA", "COMMENT", 
		"CONST", "CURLYCLOSE", "CURLYOPEN", "DIV", "DOUBLEQUOTE", "EQ", "GOAL", 
		"LESS", "LINE_COMMENT", "MINUS", "MOD", "MULT", "NAME", "NEWLINE", "NOT", 
		"NUMBER", "OPEN", "PLUS", "POINT", "QUERY", "SEMI", "SHRIEK", "SQCLOSE", 
		"SQOPEN", "STRING", "TRUE", "VAR", "WS"
	};
	public static final int EOF=-1;
	public static final int ACTIONONLY=4;
	public static final int ACTIONS=5;
	public static final int BELIEFRULES=6;
	public static final int BELIEFS=7;
	public static final int BELIEVE=8;
	public static final int BRULEARROW=9;
	public static final int CLOSE=10;
	public static final int COLON=11;
	public static final int COMMA=12;
	public static final int COMMENT=13;
	public static final int CONST=14;
	public static final int CURLYCLOSE=15;
	public static final int CURLYOPEN=16;
	public static final int DIV=17;
	public static final int DOUBLEQUOTE=18;
	public static final int EQ=19;
	public static final int GOAL=20;
	public static final int LESS=21;
	public static final int LINE_COMMENT=22;
	public static final int MINUS=23;
	public static final int MOD=24;
	public static final int MULT=25;
	public static final int NAME=26;
	public static final int NEWLINE=27;
	public static final int NOT=28;
	public static final int NUMBER=29;
	public static final int OPEN=30;
	public static final int PLUS=31;
	public static final int POINT=32;
	public static final int QUERY=33;
	public static final int SEMI=34;
	public static final int SHRIEK=35;
	public static final int SQCLOSE=36;
	public static final int SQOPEN=37;
	public static final int STRING=38;
	public static final int TRUE=39;
	public static final int VAR=40;
	public static final int WS=41;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ActionOnlyParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ActionOnlyParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ActionOnlyParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g"; }


		private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
		private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");
		


	// $ANTLR start "mas"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:58:1: mas returns [Abstract_MAS mas] :glist= aoagents ;
	public final Abstract_MAS mas() throws RecognitionException {
		Abstract_MAS mas = null;


		ArrayList<Abstract_ActionOnlyAgent> glist =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:58:32: (glist= aoagents )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:58:34: glist= aoagents
			{
			mas = new Abstract_MAS();
			pushFollow(FOLLOW_aoagents_in_mas90);
			glist=aoagents();
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



	// $ANTLR start "aoagents"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:61:1: aoagents returns [ArrayList<Abstract_ActionOnlyAgent> gags] : ACTIONONLY (g= aoagent )+ ;
	public final ArrayList<Abstract_ActionOnlyAgent> aoagents() throws RecognitionException {
		ArrayList<Abstract_ActionOnlyAgent> gags = null;


		Abstract_ActionOnlyAgent g =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:61:59: ( ACTIONONLY (g= aoagent )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:61:61: ACTIONONLY (g= aoagent )+
			{
			match(input,ACTIONONLY,FOLLOW_ACTIONONLY_in_aoagents102); 
			gags=new ArrayList<Abstract_ActionOnlyAgent>();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:63:2: (g= aoagent )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ACTIONONLY||LA1_0==NAME) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:63:3: g= aoagent
					{
					pushFollow(FOLLOW_aoagent_in_aoagents113);
					g=aoagent();
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
	// $ANTLR end "aoagents"



	// $ANTLR start "aoagent"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:66:1: aoagent returns [Abstract_ActionOnlyAgent g] : ( ( ACTIONONLY )? ) NAME w= word BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOAL (l= literal )+ ACTIONS (c= capability )* ;
	public final Abstract_ActionOnlyAgent aoagent() throws RecognitionException {
		Abstract_ActionOnlyAgent g = null;


		String w =null;
		Abstract_Literal l =null;
		Abstract_Rule r =null;
		Abstract_Capability c =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:66:46: ( ( ( ACTIONONLY )? ) NAME w= word BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOAL (l= literal )+ ACTIONS (c= capability )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:67:9: ( ( ACTIONONLY )? ) NAME w= word BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? GOAL (l= literal )+ ACTIONS (c= capability )*
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:67:9: ( ( ACTIONONLY )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:67:10: ( ACTIONONLY )?
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:67:10: ( ACTIONONLY )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ACTIONONLY) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:67:10: ACTIONONLY
					{
					match(input,ACTIONONLY,FOLLOW_ACTIONONLY_in_aoagent140); 
					}
					break;

			}

			}

			match(input,NAME,FOLLOW_NAME_in_aoagent146); 
			pushFollow(FOLLOW_word_in_aoagent150);
			w=word();
			state._fsp--;

			try {g = new Abstract_ActionOnlyAgent(w);} 
					catch (Exception e) {System.err.println(e); agentname = new Abstract_StringTermImpl(w);}
			match(input,BELIEFS,FOLLOW_BELIEFS_in_aoagent155); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:70:10: (l= literal )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==CONST||LA3_0==NOT||(LA3_0 >= TRUE && LA3_0 <= VAR)) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:70:11: l= literal
					{
					pushFollow(FOLLOW_literal_in_aoagent160);
					l=literal();
					state._fsp--;

					g.addInitialBel(l);
					}
					break;

				default :
					break loop3;
				}
			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:71:2: ( BELIEFRULES (r= brule )* )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==BELIEFRULES) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:71:3: BELIEFRULES (r= brule )*
					{
					match(input,BELIEFRULES,FOLLOW_BELIEFRULES_in_aoagent168); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:71:15: (r= brule )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==CONST||LA4_0==VAR) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:71:16: r= brule
							{
							pushFollow(FOLLOW_brule_in_aoagent173);
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

			match(input,GOAL,FOLLOW_GOAL_in_aoagent182); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:72:7: (l= literal )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==CONST||LA6_0==NOT||(LA6_0 >= TRUE && LA6_0 <= VAR)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:72:8: l= literal
					{
					pushFollow(FOLLOW_literal_in_aoagent189);
					l=literal();
					state._fsp--;

					g.addInitialGoal(new Abstract_Goal(l, Abstract_Goal.achieveGoal));
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			match(input,ACTIONS,FOLLOW_ACTIONS_in_aoagent196); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:73:10: (c= capability )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==CURLYOPEN) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:73:11: c= capability
					{
					pushFollow(FOLLOW_capability_in_aoagent203);
					c=capability();
					state._fsp--;

					g.addCapability(c);
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
	// $ANTLR end "aoagent"



	// $ANTLR start "guard_atom"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:76:1: guard_atom returns [Abstract_GLogicalFormula g] : ( BELIEVE l= literal |eq= equation | TRUE ) ;
	public final Abstract_GLogicalFormula guard_atom() throws RecognitionException {
		Abstract_GLogicalFormula g = null;


		Abstract_Literal l =null;
		Abstract_Equation eq =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:76:49: ( ( BELIEVE l= literal |eq= equation | TRUE ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:76:51: ( BELIEVE l= literal |eq= equation | TRUE )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:76:51: ( BELIEVE l= literal |eq= equation | TRUE )
			int alt8=3;
			switch ( input.LA(1) ) {
			case BELIEVE:
				{
				alt8=1;
				}
				break;
			case MINUS:
			case NUMBER:
			case OPEN:
			case VAR:
				{
				alt8=2;
				}
				break;
			case TRUE:
				{
				alt8=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:76:52: BELIEVE l= literal
					{
					match(input,BELIEVE,FOLLOW_BELIEVE_in_guard_atom222); 
					pushFollow(FOLLOW_literal_in_guard_atom226);
					l=literal();
					state._fsp--;

					g = new Abstract_GBelief(l);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:77:5: eq= equation
					{
					pushFollow(FOLLOW_equation_in_guard_atom240);
					eq=equation();
					state._fsp--;

					g = eq;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:78:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_guard_atom250); 
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



	// $ANTLR start "brule"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:80:1: brule returns [Abstract_Rule r] : head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) ;
	public final Abstract_Rule brule() throws RecognitionException {
		Abstract_Rule r = null;


		Abstract_Predicate head =null;
		Abstract_LogicalFormula f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:80:33: (head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:80:35: head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI )
			{
			pushFollow(FOLLOW_pred_in_brule272);
			head=pred();
			state._fsp--;

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:80:45: ( BRULEARROW f= logicalfmla SEMI | SEMI )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==BRULEARROW) ) {
				alt9=1;
			}
			else if ( (LA9_0==SEMI) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:80:46: BRULEARROW f= logicalfmla SEMI
					{
					match(input,BRULEARROW,FOLLOW_BRULEARROW_in_brule275); 
					pushFollow(FOLLOW_logicalfmla_in_brule279);
					f=logicalfmla();
					state._fsp--;

					r = new Abstract_Rule(head, f);
					match(input,SEMI,FOLLOW_SEMI_in_brule283); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:80:116: SEMI
					{
					match(input,SEMI,FOLLOW_SEMI_in_brule287); 
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



	// $ANTLR start "capability"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:82:1: capability returns [Abstract_Capability c] : CURLYOPEN (f= clogicalfmla )? CURLYCLOSE a= action ;
	public final Abstract_Capability capability() throws RecognitionException {
		Abstract_Capability c = null;


		Abstract_GLogicalFormula f =null;
		Abstract_Action a =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:82:44: ( CURLYOPEN (f= clogicalfmla )? CURLYCLOSE a= action )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:82:46: CURLYOPEN (f= clogicalfmla )? CURLYCLOSE a= action
			{
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_capability302); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:82:56: (f= clogicalfmla )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==CONST||LA10_0==NOT||LA10_0==VAR) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:82:57: f= clogicalfmla
					{
					pushFollow(FOLLOW_clogicalfmla_in_capability307);
					f=clogicalfmla();
					state._fsp--;

					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_capability311); 
			pushFollow(FOLLOW_action_in_capability315);
			a=action();
			state._fsp--;

			c = new Abstract_Capability(a); if (f != null) {c.addPre(f); c.addPost(new Abstract_GBelief());}
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



	// $ANTLR start "logicalfmla"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:84:1: logicalfmla returns [Abstract_LogicalFormula f] : n= notfmla ( COMMA n2= notfmla )* ;
	public final Abstract_LogicalFormula logicalfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula n =null;
		Abstract_LogicalFormula n2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:84:49: (n= notfmla ( COMMA n2= notfmla )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:84:51: n= notfmla ( COMMA n2= notfmla )*
			{
			pushFollow(FOLLOW_notfmla_in_logicalfmla331);
			n=notfmla();
			state._fsp--;

			f = n;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:85:16: ( COMMA n2= notfmla )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==COMMA) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:85:17: COMMA n2= notfmla
					{
					match(input,COMMA,FOLLOW_COMMA_in_logicalfmla351); 
					pushFollow(FOLLOW_notfmla_in_logicalfmla355);
					n2=notfmla();
					state._fsp--;

					f = new Abstract_LogExpr(f, Abstract_LogExpr.and, n2);
					}
					break;

				default :
					break loop11;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:87:1: notfmla returns [Abstract_LogicalFormula f] : ( (gb= pred | SQOPEN eq= equation SQCLOSE ) | NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla ) );
	public final Abstract_LogicalFormula notfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_Predicate gb =null;
		Abstract_Equation eq =null;
		Abstract_Predicate gb2 =null;
		Abstract_LogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:87:45: ( (gb= pred | SQOPEN eq= equation SQCLOSE ) | NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla ) )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==CONST||LA14_0==SQOPEN||LA14_0==VAR) ) {
				alt14=1;
			}
			else if ( (LA14_0==NOT) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:87:47: (gb= pred | SQOPEN eq= equation SQCLOSE )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:87:47: (gb= pred | SQOPEN eq= equation SQCLOSE )
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==CONST||LA12_0==VAR) ) {
						alt12=1;
					}
					else if ( (LA12_0==SQOPEN) ) {
						alt12=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 12, 0, input);
						throw nvae;
					}

					switch (alt12) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:87:48: gb= pred
							{
							pushFollow(FOLLOW_pred_in_notfmla391);
							gb=pred();
							state._fsp--;

							f = gb;
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:87:71: SQOPEN eq= equation SQCLOSE
							{
							match(input,SQOPEN,FOLLOW_SQOPEN_in_notfmla397); 
							pushFollow(FOLLOW_equation_in_notfmla403);
							eq=equation();
							state._fsp--;

							f = eq;
							match(input,SQCLOSE,FOLLOW_SQCLOSE_in_notfmla407); 
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:88:79: NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla )
					{
					match(input,NOT,FOLLOW_NOT_in_notfmla491); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:88:83: (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla )
					int alt13=3;
					switch ( input.LA(1) ) {
					case CONST:
					case VAR:
						{
						alt13=1;
						}
						break;
					case SQOPEN:
						{
						alt13=2;
						}
						break;
					case OPEN:
						{
						alt13=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 13, 0, input);
						throw nvae;
					}
					switch (alt13) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:88:84: gb2= pred
							{
							pushFollow(FOLLOW_pred_in_notfmla498);
							gb2=pred();
							state._fsp--;

							f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:89:81: SQOPEN eq= equation SQCLOSE
							{
							match(input,SQOPEN,FOLLOW_SQOPEN_in_notfmla585); 
							pushFollow(FOLLOW_equation_in_notfmla591);
							eq=equation();
							state._fsp--;

							match(input,SQCLOSE,FOLLOW_SQCLOSE_in_notfmla593); 
							f = new Abstract_LogExpr(Abstract_LogExpr.not, eq);
							}
							break;
						case 3 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:90:80: lf= subfmla
							{
							pushFollow(FOLLOW_subfmla_in_notfmla682);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:91:1: subfmla returns [Abstract_LogicalFormula f] : OPEN lf= logicalfmla CLOSE ;
	public final Abstract_LogicalFormula subfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:91:45: ( OPEN lf= logicalfmla CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:91:47: OPEN lf= logicalfmla CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_subfmla696); 
			pushFollow(FOLLOW_logicalfmla_in_subfmla702);
			lf=logicalfmla();
			state._fsp--;

			f = lf;
			match(input,CLOSE,FOLLOW_CLOSE_in_subfmla706); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:93:1: clogicalfmla returns [Abstract_GLogicalFormula f] : n= cnotfmla ( COMMA n2= cnotfmla )* ;
	public final Abstract_GLogicalFormula clogicalfmla() throws RecognitionException {
		Abstract_GLogicalFormula f = null;


		Abstract_GLogicalFormula n =null;
		Abstract_GLogicalFormula n2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:93:51: (n= cnotfmla ( COMMA n2= cnotfmla )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:93:53: n= cnotfmla ( COMMA n2= cnotfmla )*
			{
			pushFollow(FOLLOW_cnotfmla_in_clogicalfmla721);
			n=cnotfmla();
			state._fsp--;

			f = n;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:94:16: ( COMMA n2= cnotfmla )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==COMMA) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:94:17: COMMA n2= cnotfmla
					{
					match(input,COMMA,FOLLOW_COMMA_in_clogicalfmla741); 
					pushFollow(FOLLOW_cnotfmla_in_clogicalfmla745);
					n2=cnotfmla();
					state._fsp--;

					f = new Abstract_Guard(f, Abstract_Guard.and, n2);
					}
					break;

				default :
					break loop15;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:95:2: cnotfmla returns [Abstract_GLogicalFormula f] : (gb= pred | NOT (gb2= pred |lf= csubfmla ) );
	public final Abstract_GLogicalFormula cnotfmla() throws RecognitionException {
		Abstract_GLogicalFormula f = null;


		Abstract_Predicate gb =null;
		Abstract_Predicate gb2 =null;
		Abstract_GLogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:95:48: (gb= pred | NOT (gb2= pred |lf= csubfmla ) )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==CONST||LA17_0==VAR) ) {
				alt17=1;
			}
			else if ( (LA17_0==NOT) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:95:50: gb= pred
					{
					pushFollow(FOLLOW_pred_in_cnotfmla765);
					gb=pred();
					state._fsp--;

					f = new Abstract_GBelief(new Abstract_Literal(gb));
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:96:79: NOT (gb2= pred |lf= csubfmla )
					{
					match(input,NOT,FOLLOW_NOT_in_cnotfmla850); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:96:83: (gb2= pred |lf= csubfmla )
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==CONST||LA16_0==VAR) ) {
						alt16=1;
					}
					else if ( (LA16_0==OPEN) ) {
						alt16=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						throw nvae;
					}

					switch (alt16) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:96:84: gb2= pred
							{
							pushFollow(FOLLOW_pred_in_cnotfmla857);
							gb2=pred();
							state._fsp--;

							f = new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal(gb2)));
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:97:79: lf= csubfmla
							{
							pushFollow(FOLLOW_csubfmla_in_cnotfmla946);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:98:1: csubfmla returns [Abstract_GLogicalFormula f] : OPEN lf= clogicalfmla CLOSE ;
	public final Abstract_GLogicalFormula csubfmla() throws RecognitionException {
		Abstract_GLogicalFormula f = null;


		Abstract_GLogicalFormula lf =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:98:47: ( OPEN lf= clogicalfmla CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:98:49: OPEN lf= clogicalfmla CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_csubfmla960); 
			pushFollow(FOLLOW_clogicalfmla_in_csubfmla966);
			lf=clogicalfmla();
			state._fsp--;

			f = lf;
			match(input,CLOSE,FOLLOW_CLOSE_in_csubfmla970); 
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



	// $ANTLR start "action"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:102:1: action returns [Abstract_Action a] : t= pred ;
	public final Abstract_Action action() throws RecognitionException {
		Abstract_Action a = null;


		Abstract_Predicate t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:102:36: (t= pred )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:103:3: t= pred
			{
			pushFollow(FOLLOW_pred_in_action989);
			t=pred();
			state._fsp--;

			a = new Abstract_Action(t, Abstract_Action.normalAction);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:121:1: environment returns [String env] : w= classpath ;
	public final String environment() throws RecognitionException {
		String env = null;


		String w =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:121:34: (w= classpath )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:121:36: w= classpath
			{
			pushFollow(FOLLOW_classpath_in_environment1095);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:122:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
	public final String classpath() throws RecognitionException {
		String s = null;


		String w =null;
		String w1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:122:30: (w= word ( POINT w1= word )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:122:32: w= word ( POINT w1= word )+
			{
			pushFollow(FOLLOW_word_in_classpath1110);
			w=word();
			state._fsp--;

			s = w;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:122:52: ( POINT w1= word )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==POINT) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:122:53: POINT w1= word
					{
					match(input,POINT,FOLLOW_POINT_in_classpath1115); 
					pushFollow(FOLLOW_word_in_classpath1119);
					w1=word();
					state._fsp--;

					s+="."; s+=w1;
					}
					break;

				default :
					if ( cnt18 >= 1 ) break loop18;
					EarlyExitException eee = new EarlyExitException(18, input);
					throw eee;
				}
				cnt18++;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:123:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:123:25: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:123:27: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:123:27: ( CONST | VAR )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==CONST) ) {
				alt19=1;
			}
			else if ( (LA19_0==VAR) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:123:28: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_word1220); 
					s =CONST1.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:123:59: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_word1226); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:125:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
	public final Abstract_StringTerm agentnameterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token CONST3=null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:125:47: ( CONST |v= var )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==CONST) ) {
				alt20=1;
			}
			else if ( (LA20_0==VAR) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:125:49: CONST
					{
					CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm1326); 
					s = new Abstract_StringTermImpl(CONST3.getText());
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:125:111: v= var
					{
					pushFollow(FOLLOW_var_in_agentnameterm1334);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:128:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
	public final Abstract_Literal literal() throws RecognitionException {
		Abstract_Literal l = null;


		Abstract_Predicate nt =null;
		Abstract_Predicate t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:128:37: ( ( TRUE | NOT nt= pred ) |t= pred )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==NOT||LA22_0==TRUE) ) {
				alt22=1;
			}
			else if ( (LA22_0==CONST||LA22_0==VAR) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:128:40: ( TRUE | NOT nt= pred )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:128:40: ( TRUE | NOT nt= pred )
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==TRUE) ) {
						alt21=1;
					}
					else if ( (LA21_0==NOT) ) {
						alt21=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 21, 0, input);
						throw nvae;
					}

					switch (alt21) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:128:41: TRUE
							{
							match(input,TRUE,FOLLOW_TRUE_in_literal1350); 
							l = new Abstract_Literal(Abstract_Literal.LTrue);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:129:5: NOT nt= pred
							{
							match(input,NOT,FOLLOW_NOT_in_literal1361); 
							pushFollow(FOLLOW_pred_in_literal1365);
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:133:5: t= pred
					{
					pushFollow(FOLLOW_pred_in_literal1379);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:137:1: pred returns [Abstract_Predicate t] : (v= var |f= function );
	public final Abstract_Predicate pred() throws RecognitionException {
		Abstract_Predicate t = null;


		Abstract_VarTerm v =null;
		Abstract_Predicate f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:137:37: (v= var |f= function )
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==VAR) ) {
				alt23=1;
			}
			else if ( (LA23_0==CONST) ) {
				alt23=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}

			switch (alt23) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:137:39: v= var
					{
					pushFollow(FOLLOW_var_in_pred1395);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:137:59: f= function
					{
					pushFollow(FOLLOW_function_in_pred1402);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:138:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
	public final Abstract_Predicate function() throws RecognitionException {
		Abstract_Predicate f = null;


		Token CONST4=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:138:40: ( CONST ( OPEN terms[$f] CLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:138:42: CONST ( OPEN terms[$f] CLOSE )?
			{
			CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_function1414); 
			f = new Abstract_Predicate(CONST4.getText());
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:138:97: ( OPEN terms[$f] CLOSE )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==OPEN) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:138:98: OPEN terms[$f] CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function1419); 
					pushFollow(FOLLOW_terms_in_function1421);
					terms(f);
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_function1424); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:140:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
	public final void terms(Abstract_Predicate f) throws RecognitionException {
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:140:29: (t= term ( COMMA terms[$f] )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:140:31: t= term ( COMMA terms[$f] )?
			{
			pushFollow(FOLLOW_term_in_terms1437);
			t=term();
			state._fsp--;

			f.addTerm(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:140:58: ( COMMA terms[$f] )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==COMMA) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:140:59: COMMA terms[$f]
					{
					match(input,COMMA,FOLLOW_COMMA_in_terms1442); 
					pushFollow(FOLLOW_terms_in_terms1444);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:141:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |f= function );
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_NumberTerm a =null;
		Abstract_StringTerm s =null;
		Abstract_Predicate f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:141:31: (a= atom |s= stringterm |f= function )
			int alt26=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
			case OPEN:
			case VAR:
				{
				alt26=1;
				}
				break;
			case DOUBLEQUOTE:
				{
				alt26=2;
				}
				break;
			case CONST:
				{
				alt26=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}
			switch (alt26) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:141:34: a= atom
					{
					pushFollow(FOLLOW_atom_in_term1463);
					a=atom();
					state._fsp--;

					t = a;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:141:58: s= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term1473);
					s=stringterm();
					state._fsp--;

					t = s;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:141:88: f= function
					{
					pushFollow(FOLLOW_function_in_term1481);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:143:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
	public final Abstract_NumberTerm atom() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;
		Abstract_NumberTerm a =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:143:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
			int alt27=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
				{
				alt27=1;
				}
				break;
			case VAR:
				{
				alt27=2;
				}
				break;
			case OPEN:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:143:40: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom1499);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:144:6: v= var
					{
					pushFollow(FOLLOW_var_in_atom1512);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:144:27: OPEN a= arithexpr CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_atom1518); 
					pushFollow(FOLLOW_arithexpr_in_atom1522);
					a=arithexpr();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_atom1524); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:145:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING5=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:145:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:145:46: DOUBLEQUOTE STRING DOUBLEQUOTE
			{
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1537); 
			STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm1540); 
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1542); 
					 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:148:1: var returns [Abstract_VarTerm v] : VAR ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR6=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:148:34: ( VAR )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:148:36: VAR
			{
			VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_var1556); 

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:157:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:157:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:157:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
			{
			s = "";
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:157:46: ( MINUS )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==MINUS) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:157:47: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring1573); 
					s += "-";
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:157:68: (n1= NUMBER ( POINT n2= NUMBER )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:157:69: n1= NUMBER ( POINT n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1582); 
			s += n1.getText();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:158:6: ( POINT n2= NUMBER )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==POINT) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:158:7: POINT n2= NUMBER
					{
					match(input,POINT,FOLLOW_POINT_in_numberstring1592); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1598); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:159:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation eq = null;


		Abstract_NumberTerm a1 =null;
		int oper =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:159:40: (a1= arithexpr oper= eqoper a2= arithexpr )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:159:42: a1= arithexpr oper= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation1615);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation1619);
			oper=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation1623);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:160:1: eqoper returns [int oper] : ( LESS | EQ );
	public final int eqoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:160:27: ( LESS | EQ )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==LESS) ) {
				alt30=1;
			}
			else if ( (LA30_0==EQ) ) {
				alt30=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:160:29: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper1637); 
					oper =Abstract_Equation.less;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:160:68: EQ
					{
					match(input,EQ,FOLLOW_EQ_in_eqoper1643); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:162:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm m =null;
		int oper =0;
		Abstract_NumberTerm m1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:162:43: (m= multexpr (oper= addoper m1= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:162:45: m= multexpr (oper= addoper m1= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr1659);
			m=multexpr();
			state._fsp--;

			t = m;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:162:69: (oper= addoper m1= multexpr )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==MINUS||LA31_0==PLUS) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:162:71: oper= addoper m1= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr1667);
					oper=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr1671);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:163:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm a =null;
		int oper =0;
		Abstract_NumberTerm a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:163:42: (a= atom (oper= multoper a1= atom )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:163:44: a= atom (oper= multoper a1= atom )?
			{
			pushFollow(FOLLOW_atom_in_multexpr1688);
			a=atom();
			state._fsp--;

			t = a;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:163:64: (oper= multoper a1= atom )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==DIV||(LA32_0 >= MOD && LA32_0 <= MULT)) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:163:65: oper= multoper a1= atom
					{
					pushFollow(FOLLOW_multoper_in_multexpr1695);
					oper=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_in_multexpr1699);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:165:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:165:28: ( ( PLUS | MINUS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:165:30: ( PLUS | MINUS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:165:30: ( PLUS | MINUS )
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==PLUS) ) {
				alt33=1;
			}
			else if ( (LA33_0==MINUS) ) {
				alt33=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}

			switch (alt33) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:165:31: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper1716); 
					oper =Abstract_ArithExpr.plus;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:165:70: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper1721); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:166:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
	public final int multoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:166:29: ( ( MULT | DIV | MOD ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:166:31: ( MULT | DIV | MOD )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:166:31: ( MULT | DIV | MOD )
			int alt34=3;
			switch ( input.LA(1) ) {
			case MULT:
				{
				alt34=1;
				}
				break;
			case DIV:
				{
				alt34=2;
				}
				break;
			case MOD:
				{
				alt34=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}
			switch (alt34) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:166:32: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper1736); 
					oper =Abstract_ArithExpr.times;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:166:73: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper1742); 
					oper =Abstract_ArithExpr.div;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:166:111: MOD
					{
					match(input,MOD,FOLLOW_MOD_in_multoper1748); 
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



	public static final BitSet FOLLOW_aoagents_in_mas90 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTIONONLY_in_aoagents102 = new BitSet(new long[]{0x0000000004000010L});
	public static final BitSet FOLLOW_aoagent_in_aoagents113 = new BitSet(new long[]{0x0000000004000012L});
	public static final BitSet FOLLOW_ACTIONONLY_in_aoagent140 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_NAME_in_aoagent146 = new BitSet(new long[]{0x0000010000004000L});
	public static final BitSet FOLLOW_word_in_aoagent150 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BELIEFS_in_aoagent155 = new BitSet(new long[]{0x0000018010104040L});
	public static final BitSet FOLLOW_literal_in_aoagent160 = new BitSet(new long[]{0x0000018010104040L});
	public static final BitSet FOLLOW_BELIEFRULES_in_aoagent168 = new BitSet(new long[]{0x0000010000104000L});
	public static final BitSet FOLLOW_brule_in_aoagent173 = new BitSet(new long[]{0x0000010000104000L});
	public static final BitSet FOLLOW_GOAL_in_aoagent182 = new BitSet(new long[]{0x0000018010004000L});
	public static final BitSet FOLLOW_literal_in_aoagent189 = new BitSet(new long[]{0x0000018010004020L});
	public static final BitSet FOLLOW_ACTIONS_in_aoagent196 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_capability_in_aoagent203 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_BELIEVE_in_guard_atom222 = new BitSet(new long[]{0x0000018010004000L});
	public static final BitSet FOLLOW_literal_in_guard_atom226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_guard_atom240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_guard_atom250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_brule272 = new BitSet(new long[]{0x0000000400000200L});
	public static final BitSet FOLLOW_BRULEARROW_in_brule275 = new BitSet(new long[]{0x0000012010004000L});
	public static final BitSet FOLLOW_logicalfmla_in_brule279 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_SEMI_in_brule283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMI_in_brule287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURLYOPEN_in_capability302 = new BitSet(new long[]{0x000001001000C000L});
	public static final BitSet FOLLOW_clogicalfmla_in_capability307 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_capability311 = new BitSet(new long[]{0x0000010000004000L});
	public static final BitSet FOLLOW_action_in_capability315 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla331 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_logicalfmla351 = new BitSet(new long[]{0x0000012010004000L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla355 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_pred_in_notfmla391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_notfmla397 = new BitSet(new long[]{0x0000010060800000L});
	public static final BitSet FOLLOW_equation_in_notfmla403 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_notfmla407 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_notfmla491 = new BitSet(new long[]{0x0000012040004000L});
	public static final BitSet FOLLOW_pred_in_notfmla498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_notfmla585 = new BitSet(new long[]{0x0000010060800000L});
	public static final BitSet FOLLOW_equation_in_notfmla591 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_notfmla593 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subfmla_in_notfmla682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_subfmla696 = new BitSet(new long[]{0x0000012010004000L});
	public static final BitSet FOLLOW_logicalfmla_in_subfmla702 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_subfmla706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cnotfmla_in_clogicalfmla721 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_clogicalfmla741 = new BitSet(new long[]{0x0000010010004000L});
	public static final BitSet FOLLOW_cnotfmla_in_clogicalfmla745 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_pred_in_cnotfmla765 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_cnotfmla850 = new BitSet(new long[]{0x0000010040004000L});
	public static final BitSet FOLLOW_pred_in_cnotfmla857 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_csubfmla_in_cnotfmla946 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_csubfmla960 = new BitSet(new long[]{0x0000010010004000L});
	public static final BitSet FOLLOW_clogicalfmla_in_csubfmla966 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_csubfmla970 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_action989 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_classpath_in_environment1095 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_classpath1110 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_POINT_in_classpath1115 = new BitSet(new long[]{0x0000010000004000L});
	public static final BitSet FOLLOW_word_in_classpath1119 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_CONST_in_word1220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word1226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_agentnameterm1326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_agentnameterm1334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_literal1350 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_literal1361 = new BitSet(new long[]{0x0000010000004000L});
	public static final BitSet FOLLOW_pred_in_literal1365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_literal1379 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_pred1395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_pred1402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function1414 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_OPEN_in_function1419 = new BitSet(new long[]{0x0000010060844000L});
	public static final BitSet FOLLOW_terms_in_function1421 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_function1424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_terms1437 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_terms1442 = new BitSet(new long[]{0x0000010060844000L});
	public static final BitSet FOLLOW_terms_in_terms1444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_term1463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_term1473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_term1481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom1499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom1512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom1518 = new BitSet(new long[]{0x0000010060800000L});
	public static final BitSet FOLLOW_arithexpr_in_atom1522 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_atom1524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1537 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_STRING_in_stringterm1540 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1542 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var1556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring1573 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring1582 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_POINT_in_numberstring1592 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring1598 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation1615 = new BitSet(new long[]{0x0000000000280000L});
	public static final BitSet FOLLOW_eqoper_in_equation1619 = new BitSet(new long[]{0x0000010060800000L});
	public static final BitSet FOLLOW_arithexpr_in_equation1623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper1637 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_eqoper1643 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr1659 = new BitSet(new long[]{0x0000000080800002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr1667 = new BitSet(new long[]{0x0000010060800000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr1671 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_multexpr1688 = new BitSet(new long[]{0x0000000003020002L});
	public static final BitSet FOLLOW_multoper_in_multexpr1695 = new BitSet(new long[]{0x0000010060800000L});
	public static final BitSet FOLLOW_atom_in_multexpr1699 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper1716 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper1721 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper1736 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper1742 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_multoper1748 = new BitSet(new long[]{0x0000000000000002L});
}
