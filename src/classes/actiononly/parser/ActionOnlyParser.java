// $ANTLR 3.5.1 /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g 2014-09-25 10:51:35

package actiononly.parser;

import ail.syntax.ast.*;
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
		"CONST", "CURLYCLOSE", "CURLYOPEN", "DIV", "DOUBLEQUOTE", "EQ", "LESS", 
		"LINE_COMMENT", "MINUS", "MOD", "MULT", "NAME", "NEWLINE", "NOT", "NUMBER", 
		"OPEN", "PLUS", "POINT", "QUERY", "SEMI", "SHRIEK", "SQCLOSE", "SQOPEN", 
		"STRING", "TRUE", "VAR", "WS"
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
	public static final int LESS=20;
	public static final int LINE_COMMENT=21;
	public static final int MINUS=22;
	public static final int MOD=23;
	public static final int MULT=24;
	public static final int NAME=25;
	public static final int NEWLINE=26;
	public static final int NOT=27;
	public static final int NUMBER=28;
	public static final int OPEN=29;
	public static final int PLUS=30;
	public static final int POINT=31;
	public static final int QUERY=32;
	public static final int SEMI=33;
	public static final int SHRIEK=34;
	public static final int SQCLOSE=35;
	public static final int SQOPEN=36;
	public static final int STRING=37;
	public static final int TRUE=38;
	public static final int VAR=39;
	public static final int WS=40;

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
	@Override public String getGrammarFileName() { return "/Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g"; }


		private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
		private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");
		


	// $ANTLR start "mas"
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:57:1: mas returns [Abstract_MAS mas] :glist= aoagents ;
	public final Abstract_MAS mas() throws RecognitionException {
		Abstract_MAS mas = null;


		ArrayList<Abstract_Agent> glist =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:57:32: (glist= aoagents )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:57:34: glist= aoagents
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:60:1: aoagents returns [ArrayList<Abstract_Agent> gags] : ACTIONONLY (g= aoagent )+ ;
	public final ArrayList<Abstract_Agent> aoagents() throws RecognitionException {
		ArrayList<Abstract_Agent> gags = null;


		Abstract_Agent g =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:60:49: ( ACTIONONLY (g= aoagent )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:60:51: ACTIONONLY (g= aoagent )+
			{
			match(input,ACTIONONLY,FOLLOW_ACTIONONLY_in_aoagents102); 
			gags=new ArrayList<Abstract_Agent>();
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:62:2: (g= aoagent )+
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
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:62:3: g= aoagent
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:65:1: aoagent returns [Abstract_Agent g] : ( ( ACTIONONLY )? ) NAME w= word BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? ACTIONS (c= capability )* ;
	public final Abstract_Agent aoagent() throws RecognitionException {
		Abstract_Agent g = null;


		String w =null;
		Abstract_Literal l =null;
		Abstract_Rule r =null;
		Abstract_Capability c =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:65:36: ( ( ( ACTIONONLY )? ) NAME w= word BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? ACTIONS (c= capability )* )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:66:9: ( ( ACTIONONLY )? ) NAME w= word BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? ACTIONS (c= capability )*
			{
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:66:9: ( ( ACTIONONLY )? )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:66:10: ( ACTIONONLY )?
			{
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:66:10: ( ACTIONONLY )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ACTIONONLY) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:66:10: ACTIONONLY
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

			try {g = new Abstract_Agent(w);} 
					catch (Exception e) {System.err.println(e); agentname = new Abstract_StringTermImpl(w);}
			match(input,BELIEFS,FOLLOW_BELIEFS_in_aoagent155); 
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:69:10: (l= literal )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==CONST||LA3_0==NOT||(LA3_0 >= TRUE && LA3_0 <= VAR)) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:69:11: l= literal
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

			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:70:2: ( BELIEFRULES (r= brule )* )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==BELIEFRULES) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:70:3: BELIEFRULES (r= brule )*
					{
					match(input,BELIEFRULES,FOLLOW_BELIEFRULES_in_aoagent168); 
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:70:15: (r= brule )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==CONST||LA4_0==VAR) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:70:16: r= brule
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

			match(input,ACTIONS,FOLLOW_ACTIONS_in_aoagent182); 
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:71:10: (c= capability )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==CURLYOPEN) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:71:11: c= capability
					{
					pushFollow(FOLLOW_capability_in_aoagent189);
					c=capability();
					state._fsp--;

					g.addCapability(c);
					}
					break;

				default :
					break loop6;
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:74:1: guard_atom returns [Abstract_GLogicalFormula g] : ( BELIEVE l= literal |eq= equation | TRUE ) ;
	public final Abstract_GLogicalFormula guard_atom() throws RecognitionException {
		Abstract_GLogicalFormula g = null;


		Abstract_Literal l =null;
		Abstract_Equation eq =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:74:49: ( ( BELIEVE l= literal |eq= equation | TRUE ) )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:74:51: ( BELIEVE l= literal |eq= equation | TRUE )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:74:51: ( BELIEVE l= literal |eq= equation | TRUE )
			int alt7=3;
			switch ( input.LA(1) ) {
			case BELIEVE:
				{
				alt7=1;
				}
				break;
			case MINUS:
			case NUMBER:
			case OPEN:
			case VAR:
				{
				alt7=2;
				}
				break;
			case TRUE:
				{
				alt7=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:74:52: BELIEVE l= literal
					{
					match(input,BELIEVE,FOLLOW_BELIEVE_in_guard_atom208); 
					pushFollow(FOLLOW_literal_in_guard_atom212);
					l=literal();
					state._fsp--;

					g = new Abstract_GBelief(l);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:75:5: eq= equation
					{
					pushFollow(FOLLOW_equation_in_guard_atom226);
					eq=equation();
					state._fsp--;

					g = eq;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:76:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_guard_atom236); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:78:1: brule returns [Abstract_Rule r] : head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) ;
	public final Abstract_Rule brule() throws RecognitionException {
		Abstract_Rule r = null;


		Abstract_Predicate head =null;
		Abstract_LogicalFormula f =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:78:33: (head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:78:35: head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI )
			{
			pushFollow(FOLLOW_pred_in_brule258);
			head=pred();
			state._fsp--;

			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:78:45: ( BRULEARROW f= logicalfmla SEMI | SEMI )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==BRULEARROW) ) {
				alt8=1;
			}
			else if ( (LA8_0==SEMI) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:78:46: BRULEARROW f= logicalfmla SEMI
					{
					match(input,BRULEARROW,FOLLOW_BRULEARROW_in_brule261); 
					pushFollow(FOLLOW_logicalfmla_in_brule265);
					f=logicalfmla();
					state._fsp--;

					r = new Abstract_Rule(head, f);
					match(input,SEMI,FOLLOW_SEMI_in_brule269); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:78:116: SEMI
					{
					match(input,SEMI,FOLLOW_SEMI_in_brule273); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:80:1: capability returns [Abstract_Capability c] : CURLYOPEN f= logicalfmla CURLYCLOSE a= action ;
	public final Abstract_Capability capability() throws RecognitionException {
		Abstract_Capability c = null;


		Abstract_LogicalFormula f =null;
		Abstract_Action a =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:80:44: ( CURLYOPEN f= logicalfmla CURLYCLOSE a= action )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:80:46: CURLYOPEN f= logicalfmla CURLYCLOSE a= action
			{
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_capability288); 
			pushFollow(FOLLOW_logicalfmla_in_capability292);
			f=logicalfmla();
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_capability294); 
			pushFollow(FOLLOW_action_in_capability298);
			a=action();
			state._fsp--;

			c = new Abstract_Capability(a); c.addPre(f);
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:82:1: logicalfmla returns [Abstract_LogicalFormula f] : n= notfmla ( COMMA n2= notfmla )* ;
	public final Abstract_LogicalFormula logicalfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula n =null;
		Abstract_LogicalFormula n2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:82:49: (n= notfmla ( COMMA n2= notfmla )* )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:82:51: n= notfmla ( COMMA n2= notfmla )*
			{
			pushFollow(FOLLOW_notfmla_in_logicalfmla314);
			n=notfmla();
			state._fsp--;

			f = n;
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:83:16: ( COMMA n2= notfmla )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==COMMA) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:83:17: COMMA n2= notfmla
					{
					match(input,COMMA,FOLLOW_COMMA_in_logicalfmla334); 
					pushFollow(FOLLOW_notfmla_in_logicalfmla338);
					n2=notfmla();
					state._fsp--;

					f = new Abstract_LogExpr(f, Abstract_LogExpr.and, n2);
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
		return f;
	}
	// $ANTLR end "logicalfmla"



	// $ANTLR start "notfmla"
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:85:1: notfmla returns [Abstract_LogicalFormula f] : ( (gb= pred | SQOPEN eq= equation SQCLOSE ) | NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla ) );
	public final Abstract_LogicalFormula notfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_Predicate gb =null;
		Abstract_Equation eq =null;
		Abstract_Predicate gb2 =null;
		Abstract_LogicalFormula lf =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:85:45: ( (gb= pred | SQOPEN eq= equation SQCLOSE ) | NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla ) )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==CONST||LA12_0==SQOPEN||LA12_0==VAR) ) {
				alt12=1;
			}
			else if ( (LA12_0==NOT) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:85:47: (gb= pred | SQOPEN eq= equation SQCLOSE )
					{
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:85:47: (gb= pred | SQOPEN eq= equation SQCLOSE )
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==CONST||LA10_0==VAR) ) {
						alt10=1;
					}
					else if ( (LA10_0==SQOPEN) ) {
						alt10=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 10, 0, input);
						throw nvae;
					}

					switch (alt10) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:85:48: gb= pred
							{
							pushFollow(FOLLOW_pred_in_notfmla374);
							gb=pred();
							state._fsp--;

							f = gb;
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:85:71: SQOPEN eq= equation SQCLOSE
							{
							match(input,SQOPEN,FOLLOW_SQOPEN_in_notfmla380); 
							pushFollow(FOLLOW_equation_in_notfmla386);
							eq=equation();
							state._fsp--;

							f = eq;
							match(input,SQCLOSE,FOLLOW_SQCLOSE_in_notfmla390); 
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:86:79: NOT (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla )
					{
					match(input,NOT,FOLLOW_NOT_in_notfmla474); 
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:86:83: (gb2= pred | SQOPEN eq= equation SQCLOSE |lf= subfmla )
					int alt11=3;
					switch ( input.LA(1) ) {
					case CONST:
					case VAR:
						{
						alt11=1;
						}
						break;
					case SQOPEN:
						{
						alt11=2;
						}
						break;
					case OPEN:
						{
						alt11=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						throw nvae;
					}
					switch (alt11) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:86:84: gb2= pred
							{
							pushFollow(FOLLOW_pred_in_notfmla481);
							gb2=pred();
							state._fsp--;

							f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:87:81: SQOPEN eq= equation SQCLOSE
							{
							match(input,SQOPEN,FOLLOW_SQOPEN_in_notfmla568); 
							pushFollow(FOLLOW_equation_in_notfmla574);
							eq=equation();
							state._fsp--;

							match(input,SQCLOSE,FOLLOW_SQCLOSE_in_notfmla576); 
							f = new Abstract_LogExpr(Abstract_LogExpr.not, eq);
							}
							break;
						case 3 :
							// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:88:80: lf= subfmla
							{
							pushFollow(FOLLOW_subfmla_in_notfmla665);
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:89:1: subfmla returns [Abstract_LogicalFormula f] : OPEN lf= logicalfmla CLOSE ;
	public final Abstract_LogicalFormula subfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula lf =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:89:45: ( OPEN lf= logicalfmla CLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:89:47: OPEN lf= logicalfmla CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_subfmla679); 
			pushFollow(FOLLOW_logicalfmla_in_subfmla685);
			lf=logicalfmla();
			state._fsp--;

			f = lf;
			match(input,CLOSE,FOLLOW_CLOSE_in_subfmla689); 
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



	// $ANTLR start "action"
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:93:1: action returns [Abstract_Action a] : t= pred ;
	public final Abstract_Action action() throws RecognitionException {
		Abstract_Action a = null;


		Abstract_Predicate t =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:93:36: (t= pred )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:94:3: t= pred
			{
			pushFollow(FOLLOW_pred_in_action709);
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:111:1: environment returns [String env] : w= classpath ;
	public final String environment() throws RecognitionException {
		String env = null;


		String w =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:111:34: (w= classpath )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:111:36: w= classpath
			{
			pushFollow(FOLLOW_classpath_in_environment808);
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:112:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
	public final String classpath() throws RecognitionException {
		String s = null;


		String w =null;
		String w1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:112:30: (w= word ( POINT w1= word )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:112:32: w= word ( POINT w1= word )+
			{
			pushFollow(FOLLOW_word_in_classpath823);
			w=word();
			state._fsp--;

			s = w;
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:112:52: ( POINT w1= word )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==POINT) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:112:53: POINT w1= word
					{
					match(input,POINT,FOLLOW_POINT_in_classpath828); 
					pushFollow(FOLLOW_word_in_classpath832);
					w1=word();
					state._fsp--;

					s+="."; s+=w1;
					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:113:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:113:25: ( ( CONST | VAR ) )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:113:27: ( CONST | VAR )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:113:27: ( CONST | VAR )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==CONST) ) {
				alt14=1;
			}
			else if ( (LA14_0==VAR) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:113:28: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_word933); 
					s =CONST1.getText();
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:113:59: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_word939); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:115:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
	public final Abstract_StringTerm agentnameterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token CONST3=null;
		Abstract_VarTerm v =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:115:47: ( CONST |v= var )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==CONST) ) {
				alt15=1;
			}
			else if ( (LA15_0==VAR) ) {
				alt15=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:115:49: CONST
					{
					CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm1039); 
					s = new Abstract_StringTermImpl(CONST3.getText());
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:115:111: v= var
					{
					pushFollow(FOLLOW_var_in_agentnameterm1047);
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:118:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
	public final Abstract_Literal literal() throws RecognitionException {
		Abstract_Literal l = null;


		Abstract_Predicate nt =null;
		Abstract_Predicate t =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:118:37: ( ( TRUE | NOT nt= pred ) |t= pred )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==NOT||LA17_0==TRUE) ) {
				alt17=1;
			}
			else if ( (LA17_0==CONST||LA17_0==VAR) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:118:40: ( TRUE | NOT nt= pred )
					{
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:118:40: ( TRUE | NOT nt= pred )
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==TRUE) ) {
						alt16=1;
					}
					else if ( (LA16_0==NOT) ) {
						alt16=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						throw nvae;
					}

					switch (alt16) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:118:41: TRUE
							{
							match(input,TRUE,FOLLOW_TRUE_in_literal1063); 
							l = new Abstract_Literal(Abstract_Literal.LTrue);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:119:5: NOT nt= pred
							{
							match(input,NOT,FOLLOW_NOT_in_literal1074); 
							pushFollow(FOLLOW_pred_in_literal1078);
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
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:123:5: t= pred
					{
					pushFollow(FOLLOW_pred_in_literal1092);
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:127:1: pred returns [Abstract_Predicate t] : (v= var |f= function );
	public final Abstract_Predicate pred() throws RecognitionException {
		Abstract_Predicate t = null;


		Abstract_VarTerm v =null;
		Abstract_Predicate f =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:127:37: (v= var |f= function )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==VAR) ) {
				alt18=1;
			}
			else if ( (LA18_0==CONST) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:127:39: v= var
					{
					pushFollow(FOLLOW_var_in_pred1108);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:127:59: f= function
					{
					pushFollow(FOLLOW_function_in_pred1115);
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:128:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
	public final Abstract_Predicate function() throws RecognitionException {
		Abstract_Predicate f = null;


		Token CONST4=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:128:40: ( CONST ( OPEN terms[$f] CLOSE )? )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:128:42: CONST ( OPEN terms[$f] CLOSE )?
			{
			CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_function1127); 
			f = new Abstract_Predicate(CONST4.getText());
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:128:97: ( OPEN terms[$f] CLOSE )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==OPEN) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:128:98: OPEN terms[$f] CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function1132); 
					pushFollow(FOLLOW_terms_in_function1134);
					terms(f);
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_function1137); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:130:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
	public final void terms(Abstract_Predicate f) throws RecognitionException {
		Abstract_Term t =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:130:29: (t= term ( COMMA terms[$f] )? )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:130:31: t= term ( COMMA terms[$f] )?
			{
			pushFollow(FOLLOW_term_in_terms1150);
			t=term();
			state._fsp--;

			f.addTerm(t);
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:130:58: ( COMMA terms[$f] )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==COMMA) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:130:59: COMMA terms[$f]
					{
					match(input,COMMA,FOLLOW_COMMA_in_terms1155); 
					pushFollow(FOLLOW_terms_in_terms1157);
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:131:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |f= function );
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_NumberTerm a =null;
		Abstract_StringTerm s =null;
		Abstract_Predicate f =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:131:31: (a= atom |s= stringterm |f= function )
			int alt21=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
			case OPEN:
			case VAR:
				{
				alt21=1;
				}
				break;
			case DOUBLEQUOTE:
				{
				alt21=2;
				}
				break;
			case CONST:
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
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:131:34: a= atom
					{
					pushFollow(FOLLOW_atom_in_term1176);
					a=atom();
					state._fsp--;

					t = a;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:131:58: s= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term1186);
					s=stringterm();
					state._fsp--;

					t = s;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:131:88: f= function
					{
					pushFollow(FOLLOW_function_in_term1194);
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:133:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
	public final Abstract_NumberTerm atom() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;
		Abstract_NumberTerm a =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:133:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
			int alt22=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
				{
				alt22=1;
				}
				break;
			case VAR:
				{
				alt22=2;
				}
				break;
			case OPEN:
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
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:133:40: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom1212);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:134:6: v= var
					{
					pushFollow(FOLLOW_var_in_atom1225);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:134:27: OPEN a= arithexpr CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_atom1231); 
					pushFollow(FOLLOW_arithexpr_in_atom1235);
					a=arithexpr();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_atom1237); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:135:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING5=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:135:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:135:46: DOUBLEQUOTE STRING DOUBLEQUOTE
			{
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1250); 
			STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm1253); 
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm1255); 
					 
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:138:1: var returns [Abstract_VarTerm v] : VAR ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR6=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:138:34: ( VAR )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:138:36: VAR
			{
			VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_var1269); 

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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:147:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:147:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:147:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
			{
			s = "";
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:147:46: ( MINUS )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==MINUS) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:147:47: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring1286); 
					s += "-";
					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:147:68: (n1= NUMBER ( POINT n2= NUMBER )? )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:147:69: n1= NUMBER ( POINT n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1295); 
			s += n1.getText();
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:148:6: ( POINT n2= NUMBER )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==POINT) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:148:7: POINT n2= NUMBER
					{
					match(input,POINT,FOLLOW_POINT_in_numberstring1305); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring1311); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:149:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation eq = null;


		Abstract_NumberTerm a1 =null;
		int oper =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:149:40: (a1= arithexpr oper= eqoper a2= arithexpr )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:149:42: a1= arithexpr oper= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation1328);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation1332);
			oper=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation1336);
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:150:1: eqoper returns [int oper] : ( LESS | EQ );
	public final int eqoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:150:27: ( LESS | EQ )
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==LESS) ) {
				alt25=1;
			}
			else if ( (LA25_0==EQ) ) {
				alt25=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}

			switch (alt25) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:150:29: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper1350); 
					oper =Abstract_Equation.less;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:150:68: EQ
					{
					match(input,EQ,FOLLOW_EQ_in_eqoper1356); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:152:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm m =null;
		int oper =0;
		Abstract_NumberTerm m1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:152:43: (m= multexpr (oper= addoper m1= multexpr )? )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:152:45: m= multexpr (oper= addoper m1= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr1372);
			m=multexpr();
			state._fsp--;

			t = m;
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:152:69: (oper= addoper m1= multexpr )?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==MINUS||LA26_0==PLUS) ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:152:71: oper= addoper m1= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr1380);
					oper=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr1384);
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:153:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm a =null;
		int oper =0;
		Abstract_NumberTerm a1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:153:42: (a= atom (oper= multoper a1= atom )? )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:153:44: a= atom (oper= multoper a1= atom )?
			{
			pushFollow(FOLLOW_atom_in_multexpr1401);
			a=atom();
			state._fsp--;

			t = a;
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:153:64: (oper= multoper a1= atom )?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==DIV||(LA27_0 >= MOD && LA27_0 <= MULT)) ) {
				alt27=1;
			}
			switch (alt27) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:153:65: oper= multoper a1= atom
					{
					pushFollow(FOLLOW_multoper_in_multexpr1408);
					oper=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_in_multexpr1412);
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:155:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:155:28: ( ( PLUS | MINUS ) )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:155:30: ( PLUS | MINUS )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:155:30: ( PLUS | MINUS )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==PLUS) ) {
				alt28=1;
			}
			else if ( (LA28_0==MINUS) ) {
				alt28=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:155:31: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper1429); 
					oper =Abstract_ArithExpr.plus;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:155:70: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper1434); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:156:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
	public final int multoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:156:29: ( ( MULT | DIV | MOD ) )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:156:31: ( MULT | DIV | MOD )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:156:31: ( MULT | DIV | MOD )
			int alt29=3;
			switch ( input.LA(1) ) {
			case MULT:
				{
				alt29=1;
				}
				break;
			case DIV:
				{
				alt29=2;
				}
				break;
			case MOD:
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
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:156:32: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper1449); 
					oper =Abstract_ArithExpr.times;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:156:73: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper1455); 
					oper =Abstract_ArithExpr.div;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:156:111: MOD
					{
					match(input,MOD,FOLLOW_MOD_in_multoper1461); 
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
	public static final BitSet FOLLOW_ACTIONONLY_in_aoagents102 = new BitSet(new long[]{0x0000000002000010L});
	public static final BitSet FOLLOW_aoagent_in_aoagents113 = new BitSet(new long[]{0x0000000002000012L});
	public static final BitSet FOLLOW_ACTIONONLY_in_aoagent140 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_NAME_in_aoagent146 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_word_in_aoagent150 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BELIEFS_in_aoagent155 = new BitSet(new long[]{0x000000C008004060L});
	public static final BitSet FOLLOW_literal_in_aoagent160 = new BitSet(new long[]{0x000000C008004060L});
	public static final BitSet FOLLOW_BELIEFRULES_in_aoagent168 = new BitSet(new long[]{0x0000008000004020L});
	public static final BitSet FOLLOW_brule_in_aoagent173 = new BitSet(new long[]{0x0000008000004020L});
	public static final BitSet FOLLOW_ACTIONS_in_aoagent182 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_capability_in_aoagent189 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_BELIEVE_in_guard_atom208 = new BitSet(new long[]{0x000000C008004000L});
	public static final BitSet FOLLOW_literal_in_guard_atom212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_guard_atom226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_guard_atom236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_brule258 = new BitSet(new long[]{0x0000000200000200L});
	public static final BitSet FOLLOW_BRULEARROW_in_brule261 = new BitSet(new long[]{0x0000009008004000L});
	public static final BitSet FOLLOW_logicalfmla_in_brule265 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_SEMI_in_brule269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMI_in_brule273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURLYOPEN_in_capability288 = new BitSet(new long[]{0x0000009008004000L});
	public static final BitSet FOLLOW_logicalfmla_in_capability292 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_capability294 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_action_in_capability298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla314 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_logicalfmla334 = new BitSet(new long[]{0x0000009008004000L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla338 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_pred_in_notfmla374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_notfmla380 = new BitSet(new long[]{0x0000008030400000L});
	public static final BitSet FOLLOW_equation_in_notfmla386 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_notfmla390 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_notfmla474 = new BitSet(new long[]{0x0000009020004000L});
	public static final BitSet FOLLOW_pred_in_notfmla481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_notfmla568 = new BitSet(new long[]{0x0000008030400000L});
	public static final BitSet FOLLOW_equation_in_notfmla574 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_notfmla576 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subfmla_in_notfmla665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_subfmla679 = new BitSet(new long[]{0x0000009008004000L});
	public static final BitSet FOLLOW_logicalfmla_in_subfmla685 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_subfmla689 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_action709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_classpath_in_environment808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_classpath823 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_POINT_in_classpath828 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_word_in_classpath832 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_CONST_in_word933 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word939 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_agentnameterm1039 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_agentnameterm1047 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_literal1063 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_literal1074 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_pred_in_literal1078 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_literal1092 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_pred1108 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_pred1115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function1127 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_OPEN_in_function1132 = new BitSet(new long[]{0x0000008030444000L});
	public static final BitSet FOLLOW_terms_in_function1134 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_function1137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_terms1150 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_terms1155 = new BitSet(new long[]{0x0000008030444000L});
	public static final BitSet FOLLOW_terms_in_terms1157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_term1176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_term1186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_term1194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom1212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom1225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom1231 = new BitSet(new long[]{0x0000008030400000L});
	public static final BitSet FOLLOW_arithexpr_in_atom1235 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_atom1237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1250 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_STRING_in_stringterm1253 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm1255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var1269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring1286 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring1295 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_POINT_in_numberstring1305 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring1311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation1328 = new BitSet(new long[]{0x0000000000180000L});
	public static final BitSet FOLLOW_eqoper_in_equation1332 = new BitSet(new long[]{0x0000008030400000L});
	public static final BitSet FOLLOW_arithexpr_in_equation1336 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper1350 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_eqoper1356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr1372 = new BitSet(new long[]{0x0000000040400002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr1380 = new BitSet(new long[]{0x0000008030400000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr1384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_multexpr1401 = new BitSet(new long[]{0x0000000001820002L});
	public static final BitSet FOLLOW_multoper_in_multexpr1408 = new BitSet(new long[]{0x0000008030400000L});
	public static final BitSet FOLLOW_atom_in_multexpr1412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper1429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper1434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper1449 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper1455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_multoper1461 = new BitSet(new long[]{0x0000000000000002L});
}
