// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g 2014-09-29 11:20:43

package ethical_governor.parser;

import ail.syntax.ast.*;
import eass.syntax.ast.*;
import ethical_governor.syntax.ast.*;
import java.util.HashMap;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class EthicalGovernorParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AGENT", "CLOSE", "COLON", "COMMA", 
		"COMMENT", "CONST", "CURLYCLOSE", "CURLYOPEN", "DEG", "DIV", "DOUBLEQUOTE", 
		"EQ", "GEQ", "LESS", "LINE_COMMENT", "MINUS", "MOD", "MULT", "NAME", "NEWLINE", 
		"NOT", "NUMBER", "OPEN", "PLUS", "POINT", "PRECEDENCE", "QUERY", "SCORES", 
		"SEMI", "SHRIEK", "SQCLOSE", "SQOPEN", "STRING", "TRUE", "VAR", "WS"
	};
	public static final int EOF=-1;
	public static final int AGENT=4;
	public static final int CLOSE=5;
	public static final int COLON=6;
	public static final int COMMA=7;
	public static final int COMMENT=8;
	public static final int CONST=9;
	public static final int CURLYCLOSE=10;
	public static final int CURLYOPEN=11;
	public static final int DEG=12;
	public static final int DIV=13;
	public static final int DOUBLEQUOTE=14;
	public static final int EQ=15;
	public static final int GEQ=16;
	public static final int LESS=17;
	public static final int LINE_COMMENT=18;
	public static final int MINUS=19;
	public static final int MOD=20;
	public static final int MULT=21;
	public static final int NAME=22;
	public static final int NEWLINE=23;
	public static final int NOT=24;
	public static final int NUMBER=25;
	public static final int OPEN=26;
	public static final int PLUS=27;
	public static final int POINT=28;
	public static final int PRECEDENCE=29;
	public static final int QUERY=30;
	public static final int SCORES=31;
	public static final int SEMI=32;
	public static final int SHRIEK=33;
	public static final int SQCLOSE=34;
	public static final int SQOPEN=35;
	public static final int STRING=36;
	public static final int TRUE=37;
	public static final int VAR=38;
	public static final int WS=39;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public EthicalGovernorParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public EthicalGovernorParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return EthicalGovernorParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g"; }


		private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
		private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");
		


	// $ANTLR start "mas"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:59:1: mas returns [Abstract_MAS mas] :glist= degagents ;
	public final Abstract_MAS mas() throws RecognitionException {
		Abstract_MAS mas = null;


		ArrayList<Abstract_EthicalGovernor> glist =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:59:32: (glist= degagents )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:59:34: glist= degagents
			{
			mas = new Abstract_MAS();
			pushFollow(FOLLOW_degagents_in_mas89);
			glist=degagents();
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



	// $ANTLR start "degagents"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:62:1: degagents returns [ArrayList<Abstract_EthicalGovernor> gags] : DEG (g= degagent )+ ;
	public final ArrayList<Abstract_EthicalGovernor> degagents() throws RecognitionException {
		ArrayList<Abstract_EthicalGovernor> gags = null;


		Abstract_EthicalGovernor g =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:62:60: ( DEG (g= degagent )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:62:62: DEG (g= degagent )+
			{
			match(input,DEG,FOLLOW_DEG_in_degagents102); 
			gags=new ArrayList<Abstract_EthicalGovernor>();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:63:2: (g= degagent )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==NAME) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:63:3: g= degagent
					{
					pushFollow(FOLLOW_degagent_in_degagents111);
					g=degagent();
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
	// $ANTLR end "degagents"



	// $ANTLR start "degagent"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:65:1: degagent returns [Abstract_EthicalGovernor g] : ( NAME w= word AGENT w= word ) SCORES (l= word EQ n= numberstring )+ PRECEDENCE (p= pred ( GEQ p1= pred )+ ) ;
	public final Abstract_EthicalGovernor degagent() throws RecognitionException {
		Abstract_EthicalGovernor g = null;


		String w =null;
		String l =null;
		String n =null;
		Abstract_Predicate p =null;
		Abstract_Predicate p1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:65:47: ( ( NAME w= word AGENT w= word ) SCORES (l= word EQ n= numberstring )+ PRECEDENCE (p= pred ( GEQ p1= pred )+ ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:66:2: ( NAME w= word AGENT w= word ) SCORES (l= word EQ n= numberstring )+ PRECEDENCE (p= pred ( GEQ p1= pred )+ )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:66:2: ( NAME w= word AGENT w= word )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:66:3: NAME w= word AGENT w= word
			{
			match(input,NAME,FOLLOW_NAME_in_degagent130); 
			pushFollow(FOLLOW_word_in_degagent134);
			w=word();
			state._fsp--;

			try {g = new Abstract_EthicalGovernor(w);} catch (Exception e) {System.err.println(e);}
				              agentname = new Abstract_StringTermImpl(w);
			match(input,AGENT,FOLLOW_AGENT_in_degagent140); 
			pushFollow(FOLLOW_word_in_degagent144);
			w=word();
			state._fsp--;

			String s =  w; g.setGoverned(s); 
			}

			match(input,SCORES,FOLLOW_SCORES_in_degagent156); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:70:9: (l= word EQ n= numberstring )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==CONST||LA2_0==VAR) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:70:10: l= word EQ n= numberstring
					{
					pushFollow(FOLLOW_word_in_degagent161);
					l=word();
					state._fsp--;

					match(input,EQ,FOLLOW_EQ_in_degagent163); 
					pushFollow(FOLLOW_numberstring_in_degagent167);
					n=numberstring();
					state._fsp--;

					g.addScore(l, n);
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match(input,PRECEDENCE,FOLLOW_PRECEDENCE_in_degagent174); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:71:13: (p= pred ( GEQ p1= pred )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:71:14: p= pred ( GEQ p1= pred )+
			{
			pushFollow(FOLLOW_pred_in_degagent179);
			p=pred();
			state._fsp--;

			g.addPrec(p);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:71:41: ( GEQ p1= pred )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==GEQ) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:71:42: GEQ p1= pred
					{
					match(input,GEQ,FOLLOW_GEQ_in_degagent184); 
					pushFollow(FOLLOW_pred_in_degagent188);
					p1=pred();
					state._fsp--;

					g.addPrec(p1);
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
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
	// $ANTLR end "degagent"



	// $ANTLR start "environment"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:88:1: environment returns [String env] : w= classpath ;
	public final String environment() throws RecognitionException {
		String env = null;


		String w =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:88:34: (w= classpath )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:88:36: w= classpath
			{
			pushFollow(FOLLOW_classpath_in_environment274);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:89:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
	public final String classpath() throws RecognitionException {
		String s = null;


		String w =null;
		String w1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:89:30: (w= word ( POINT w1= word )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:89:32: w= word ( POINT w1= word )+
			{
			pushFollow(FOLLOW_word_in_classpath289);
			w=word();
			state._fsp--;

			s = w;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:89:52: ( POINT w1= word )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==POINT) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:89:53: POINT w1= word
					{
					match(input,POINT,FOLLOW_POINT_in_classpath294); 
					pushFollow(FOLLOW_word_in_classpath298);
					w1=word();
					state._fsp--;

					s+="."; s+=w1;
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:90:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:90:25: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:90:27: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:90:27: ( CONST | VAR )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==CONST) ) {
				alt5=1;
			}
			else if ( (LA5_0==VAR) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:90:28: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_word399); 
					s =CONST1.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:90:59: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_word405); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:92:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
	public final Abstract_StringTerm agentnameterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token CONST3=null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:92:47: ( CONST |v= var )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==CONST) ) {
				alt6=1;
			}
			else if ( (LA6_0==VAR) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:92:49: CONST
					{
					CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm505); 
					s = new Abstract_StringTermImpl(CONST3.getText());
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:92:111: v= var
					{
					pushFollow(FOLLOW_var_in_agentnameterm513);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:95:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
	public final Abstract_Literal literal() throws RecognitionException {
		Abstract_Literal l = null;


		Abstract_Predicate nt =null;
		Abstract_Predicate t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:95:37: ( ( TRUE | NOT nt= pred ) |t= pred )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==NOT||LA8_0==TRUE) ) {
				alt8=1;
			}
			else if ( (LA8_0==CONST||LA8_0==VAR) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:95:40: ( TRUE | NOT nt= pred )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:95:40: ( TRUE | NOT nt= pred )
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==TRUE) ) {
						alt7=1;
					}
					else if ( (LA7_0==NOT) ) {
						alt7=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 7, 0, input);
						throw nvae;
					}

					switch (alt7) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:95:41: TRUE
							{
							match(input,TRUE,FOLLOW_TRUE_in_literal529); 
							l = new Abstract_Literal(Abstract_Literal.LTrue);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:96:5: NOT nt= pred
							{
							match(input,NOT,FOLLOW_NOT_in_literal540); 
							pushFollow(FOLLOW_pred_in_literal544);
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:100:5: t= pred
					{
					pushFollow(FOLLOW_pred_in_literal558);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:104:1: pred returns [Abstract_Predicate t] : (v= var |f= function );
	public final Abstract_Predicate pred() throws RecognitionException {
		Abstract_Predicate t = null;


		Abstract_VarTerm v =null;
		Abstract_Predicate f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:104:37: (v= var |f= function )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==VAR) ) {
				alt9=1;
			}
			else if ( (LA9_0==CONST) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:104:39: v= var
					{
					pushFollow(FOLLOW_var_in_pred574);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:104:59: f= function
					{
					pushFollow(FOLLOW_function_in_pred581);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:105:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
	public final Abstract_Predicate function() throws RecognitionException {
		Abstract_Predicate f = null;


		Token CONST4=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:105:40: ( CONST ( OPEN terms[$f] CLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:105:42: CONST ( OPEN terms[$f] CLOSE )?
			{
			CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_function593); 
			f = new Abstract_Predicate(CONST4.getText());
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:105:97: ( OPEN terms[$f] CLOSE )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==OPEN) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:105:98: OPEN terms[$f] CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function598); 
					pushFollow(FOLLOW_terms_in_function600);
					terms(f);
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_function603); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:107:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
	public final void terms(Abstract_Predicate f) throws RecognitionException {
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:107:29: (t= term ( COMMA terms[$f] )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:107:31: t= term ( COMMA terms[$f] )?
			{
			pushFollow(FOLLOW_term_in_terms616);
			t=term();
			state._fsp--;

			f.addTerm(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:107:58: ( COMMA terms[$f] )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==COMMA) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:107:59: COMMA terms[$f]
					{
					match(input,COMMA,FOLLOW_COMMA_in_terms621); 
					pushFollow(FOLLOW_terms_in_terms623);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:108:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |f= function );
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_NumberTerm a =null;
		Abstract_StringTerm s =null;
		Abstract_Predicate f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:108:31: (a= atom |s= stringterm |f= function )
			int alt12=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
			case OPEN:
			case VAR:
				{
				alt12=1;
				}
				break;
			case DOUBLEQUOTE:
				{
				alt12=2;
				}
				break;
			case CONST:
				{
				alt12=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:108:34: a= atom
					{
					pushFollow(FOLLOW_atom_in_term642);
					a=atom();
					state._fsp--;

					t = a;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:108:58: s= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term652);
					s=stringterm();
					state._fsp--;

					t = s;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:108:88: f= function
					{
					pushFollow(FOLLOW_function_in_term660);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:110:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
	public final Abstract_NumberTerm atom() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;
		Abstract_NumberTerm a =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:110:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
			int alt13=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
				{
				alt13=1;
				}
				break;
			case VAR:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:110:40: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom678);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:111:6: v= var
					{
					pushFollow(FOLLOW_var_in_atom691);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:111:27: OPEN a= arithexpr CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_atom697); 
					pushFollow(FOLLOW_arithexpr_in_atom701);
					a=arithexpr();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_atom703); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:112:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING5=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:112:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:112:46: DOUBLEQUOTE STRING DOUBLEQUOTE
			{
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm716); 
			STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm719); 
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm721); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:114:1: var returns [Abstract_VarTerm v] : VAR ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR6=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:114:34: ( VAR )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:114:36: VAR
			{
			VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_var735); 

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:123:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:123:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:123:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
			{
			s = "";
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:123:46: ( MINUS )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==MINUS) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:123:47: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring752); 
					s += "-";
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:123:68: (n1= NUMBER ( POINT n2= NUMBER )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:123:69: n1= NUMBER ( POINT n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring761); 
			s += n1.getText();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:124:6: ( POINT n2= NUMBER )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==POINT) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:124:7: POINT n2= NUMBER
					{
					match(input,POINT,FOLLOW_POINT_in_numberstring771); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring777); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:125:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation eq = null;


		Abstract_NumberTerm a1 =null;
		int oper =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:125:40: (a1= arithexpr oper= eqoper a2= arithexpr )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:125:42: a1= arithexpr oper= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation794);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation798);
			oper=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation802);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:126:1: eqoper returns [int oper] : ( LESS | EQ );
	public final int eqoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:126:27: ( LESS | EQ )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==LESS) ) {
				alt16=1;
			}
			else if ( (LA16_0==EQ) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:126:29: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper816); 
					oper =Abstract_Equation.less;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:126:68: EQ
					{
					match(input,EQ,FOLLOW_EQ_in_eqoper822); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:128:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm m =null;
		int oper =0;
		Abstract_NumberTerm m1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:128:43: (m= multexpr (oper= addoper m1= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:128:45: m= multexpr (oper= addoper m1= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr838);
			m=multexpr();
			state._fsp--;

			t = m;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:128:69: (oper= addoper m1= multexpr )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==MINUS||LA17_0==PLUS) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:128:71: oper= addoper m1= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr846);
					oper=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr850);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:129:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm a =null;
		int oper =0;
		Abstract_NumberTerm a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:129:42: (a= atom (oper= multoper a1= atom )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:129:44: a= atom (oper= multoper a1= atom )?
			{
			pushFollow(FOLLOW_atom_in_multexpr867);
			a=atom();
			state._fsp--;

			t = a;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:129:64: (oper= multoper a1= atom )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==DIV||(LA18_0 >= MOD && LA18_0 <= MULT)) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:129:65: oper= multoper a1= atom
					{
					pushFollow(FOLLOW_multoper_in_multexpr874);
					oper=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_in_multexpr878);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:131:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:131:28: ( ( PLUS | MINUS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:131:30: ( PLUS | MINUS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:131:30: ( PLUS | MINUS )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:131:31: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper895); 
					oper =Abstract_ArithExpr.plus;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:131:70: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper900); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:132:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
	public final int multoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:132:29: ( ( MULT | DIV | MOD ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:132:31: ( MULT | DIV | MOD )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:132:31: ( MULT | DIV | MOD )
			int alt20=3;
			switch ( input.LA(1) ) {
			case MULT:
				{
				alt20=1;
				}
				break;
			case DIV:
				{
				alt20=2;
				}
				break;
			case MOD:
				{
				alt20=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}
			switch (alt20) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:132:32: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper915); 
					oper =Abstract_ArithExpr.times;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:132:73: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper921); 
					oper =Abstract_ArithExpr.div;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:132:111: MOD
					{
					match(input,MOD,FOLLOW_MOD_in_multoper927); 
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



	public static final BitSet FOLLOW_degagents_in_mas89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEG_in_degagents102 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_degagent_in_degagents111 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_NAME_in_degagent130 = new BitSet(new long[]{0x0000004000000200L});
	public static final BitSet FOLLOW_word_in_degagent134 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_AGENT_in_degagent140 = new BitSet(new long[]{0x0000004000000200L});
	public static final BitSet FOLLOW_word_in_degagent144 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_SCORES_in_degagent156 = new BitSet(new long[]{0x0000004000000200L});
	public static final BitSet FOLLOW_word_in_degagent161 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_EQ_in_degagent163 = new BitSet(new long[]{0x0000000002080000L});
	public static final BitSet FOLLOW_numberstring_in_degagent167 = new BitSet(new long[]{0x0000004020000200L});
	public static final BitSet FOLLOW_PRECEDENCE_in_degagent174 = new BitSet(new long[]{0x0000004000000200L});
	public static final BitSet FOLLOW_pred_in_degagent179 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_GEQ_in_degagent184 = new BitSet(new long[]{0x0000004000000200L});
	public static final BitSet FOLLOW_pred_in_degagent188 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_classpath_in_environment274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_classpath289 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_POINT_in_classpath294 = new BitSet(new long[]{0x0000004000000200L});
	public static final BitSet FOLLOW_word_in_classpath298 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_CONST_in_word399 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_agentnameterm505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_agentnameterm513 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_literal529 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_literal540 = new BitSet(new long[]{0x0000004000000200L});
	public static final BitSet FOLLOW_pred_in_literal544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_literal558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_pred574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_pred581 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function593 = new BitSet(new long[]{0x0000000004000002L});
	public static final BitSet FOLLOW_OPEN_in_function598 = new BitSet(new long[]{0x0000004006084200L});
	public static final BitSet FOLLOW_terms_in_function600 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_CLOSE_in_function603 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_terms616 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_COMMA_in_terms621 = new BitSet(new long[]{0x0000004006084200L});
	public static final BitSet FOLLOW_terms_in_terms623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_term642 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_term652 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_term660 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom678 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom691 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom697 = new BitSet(new long[]{0x0000004006080000L});
	public static final BitSet FOLLOW_arithexpr_in_atom701 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_CLOSE_in_atom703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm716 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_STRING_in_stringterm719 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm721 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var735 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring752 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring761 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_POINT_in_numberstring771 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring777 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation794 = new BitSet(new long[]{0x0000000000028000L});
	public static final BitSet FOLLOW_eqoper_in_equation798 = new BitSet(new long[]{0x0000004006080000L});
	public static final BitSet FOLLOW_arithexpr_in_equation802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper816 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_eqoper822 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr838 = new BitSet(new long[]{0x0000000008080002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr846 = new BitSet(new long[]{0x0000004006080000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr850 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_multexpr867 = new BitSet(new long[]{0x0000000000302002L});
	public static final BitSet FOLLOW_multoper_in_multexpr874 = new BitSet(new long[]{0x0000004006080000L});
	public static final BitSet FOLLOW_atom_in_multexpr878 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper895 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper900 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper915 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper921 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_multoper927 = new BitSet(new long[]{0x0000000000000002L});
}
