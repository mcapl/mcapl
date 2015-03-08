// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2015-03-08 20:09:30

package goal.parser;

import ail.syntax.ast.*;
import ail.syntax.DefaultAILStructure;
import goal.syntax.ast.*;
import ail.syntax.PredicateIndicator;
import java.util.HashMap;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class GOALParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTIONSPEC", "ADOPT", "BAR", 
		"BEL", "BELIEFS", "CLOSE", "COLON", "COMMA", "COMMENT", "CONST", "CURLYCLOSE", 
		"CURLYOPEN", "DEFINE", "DELETE", "DIV", "DOUBLEQUOTE", "DROP", "EQUALS", 
		"EVENT", "GOAL", "GOALS", "HASH", "IF", "INSERT", "KNOWLEDGE", "LESS", 
		"LINEAR", "LINEARALL", "LINE_COMMENT", "MAIN", "MINUS", "MODULE", "MULT", 
		"NEWLINE", "NOT", "NUMBER", "OPEN", "ORDER", "PLUS", "POST", "PRE", "PROGRAM", 
		"PROLOGARROW", "RANDOM", "RANDOMALL", "SEND", "SQCLOSE", "SQOPEN", "STOP", 
		"THEN", "TRUE", "VAR", "WS"
	};
	public static final int EOF=-1;
	public static final int ACTIONSPEC=4;
	public static final int ADOPT=5;
	public static final int BAR=6;
	public static final int BEL=7;
	public static final int BELIEFS=8;
	public static final int CLOSE=9;
	public static final int COLON=10;
	public static final int COMMA=11;
	public static final int COMMENT=12;
	public static final int CONST=13;
	public static final int CURLYCLOSE=14;
	public static final int CURLYOPEN=15;
	public static final int DEFINE=16;
	public static final int DELETE=17;
	public static final int DIV=18;
	public static final int DOUBLEQUOTE=19;
	public static final int DROP=20;
	public static final int EQUALS=21;
	public static final int EVENT=22;
	public static final int GOAL=23;
	public static final int GOALS=24;
	public static final int HASH=25;
	public static final int IF=26;
	public static final int INSERT=27;
	public static final int KNOWLEDGE=28;
	public static final int LESS=29;
	public static final int LINEAR=30;
	public static final int LINEARALL=31;
	public static final int LINE_COMMENT=32;
	public static final int MAIN=33;
	public static final int MINUS=34;
	public static final int MODULE=35;
	public static final int MULT=36;
	public static final int NEWLINE=37;
	public static final int NOT=38;
	public static final int NUMBER=39;
	public static final int OPEN=40;
	public static final int ORDER=41;
	public static final int PLUS=42;
	public static final int POST=43;
	public static final int PRE=44;
	public static final int PROGRAM=45;
	public static final int PROLOGARROW=46;
	public static final int RANDOM=47;
	public static final int RANDOMALL=48;
	public static final int SEND=49;
	public static final int SQCLOSE=50;
	public static final int SQOPEN=51;
	public static final int STOP=52;
	public static final int THEN=53;
	public static final int TRUE=54;
	public static final int VAR=55;
	public static final int WS=56;

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

	@Override public String[] getTokenNames() { return GOALParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g"; }


		private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
		private static HashMap<PredicateIndicator,Abstract_MentalState> macros = new HashMap<PredicateIndicator, Abstract_MentalState>();
		private static HashMap<PredicateIndicator,Abstract_Term> macro_subs = new HashMap<PredicateIndicator, Abstract_Term>();
		private String name = "";



	// $ANTLR start "program"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:1: program returns [Abstract_MAS mas] : MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN (le= poslitconj )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gm] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gme] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? CURLYCLOSE ;
	public final Abstract_MAS program() throws RecognitionException {
		Abstract_MAS mas = null;


		String i =null;
		Abstract_LogExpr le =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:36: ( MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN (le= poslitconj )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gm] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gme] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:39: MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN (le= poslitconj )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gm] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gme] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? CURLYCLOSE
			{
			mas = new Abstract_MAS(); ArrayList<Abstract_GOALAgent> agents = new ArrayList<Abstract_GOALAgent>();
			match(input,MAIN,FOLLOW_MAIN_in_program94); 
			match(input,COLON,FOLLOW_COLON_in_program96); 
			pushFollow(FOLLOW_id_in_program100);
			i=id();
			state._fsp--;

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program102); 
			 Abstract_GOALAgent gl = new Abstract_GOALAgent(i); agents.add(gl);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:56:20: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==KNOWLEDGE) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:56:21: KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE
					{
					match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_program129); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program131); 
					pushFollow(FOLLOW_krspec_in_program133);
					krspec(gl);
					state._fsp--;

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program136); 
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:41: ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==BELIEFS) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:42: BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE
					{
					match(input,BELIEFS,FOLLOW_BELIEFS_in_program181); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program183); 
					pushFollow(FOLLOW_brspec_in_program185);
					brspec(gl);
					state._fsp--;

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program188); 
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:41: ( GOALS CURLYOPEN (le= poslitconj )* CURLYCLOSE )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==GOALS) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:42: GOALS CURLYOPEN (le= poslitconj )* CURLYCLOSE
					{
					match(input,GOALS,FOLLOW_GOALS_in_program233); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program235); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:60: (le= poslitconj )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==CONST||LA3_0==MINUS||LA3_0==NUMBER||LA3_0==VAR) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:60: le= poslitconj
							{
							pushFollow(FOLLOW_poslitconj_in_program239);
							le=poslitconj();
							state._fsp--;

							}
							break;

						default :
							break loop3;
						}
					}

					gl.addGoal(le);
					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program244); 
					}
					break;

			}

			match(input,MAIN,FOLLOW_MAIN_in_program289); 
			match(input,MODULE,FOLLOW_MODULE_in_program291); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program293); 
			 Abstract_GOALModule gm = new Abstract_GOALModule(Abstract_GOALModule.main); gl.addModule(gm);
			pushFollow(FOLLOW_module_in_program297);
			module(gm);
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program300); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:60:42: ( EVENT MODULE CURLYOPEN module[gme] CURLYCLOSE )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==EVENT) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:60:43: EVENT MODULE CURLYOPEN module[gme] CURLYCLOSE
					{
					match(input,EVENT,FOLLOW_EVENT_in_program344); 
					match(input,MODULE,FOLLOW_MODULE_in_program346); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program348); 
					 Abstract_GOALModule gme = new Abstract_GOALModule(Abstract_GOALModule.event); gl.addModule(gme);
					pushFollow(FOLLOW_module_in_program352);
					module(gme);
					state._fsp--;

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program355); 
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:61:42: ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==ACTIONSPEC) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:61:43: ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE
					{
					match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_program401); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program403); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:61:64: ( actionspec[gl] )+
					int cnt6=0;
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==ADOPT||LA6_0==CONST||LA6_0==DELETE||LA6_0==DROP||LA6_0==INSERT||LA6_0==SEND||LA6_0==VAR) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:61:64: actionspec[gl]
							{
							pushFollow(FOLLOW_actionspec_in_program405);
							actionspec(gl);
							state._fsp--;

							}
							break;

						default :
							if ( cnt6 >= 1 ) break loop6;
							EarlyExitException eee = new EarlyExitException(6, input);
							throw eee;
						}
						cnt6++;
					}

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program409); 
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program501); 
			mas.setAgs(agents);
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
	// $ANTLR end "program"



	// $ANTLR start "module"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:1: module[Abstract_GOALModule gl] : ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN (le= poslitconj )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule[gl] )+ CURLYCLOSE ;
	public final void module(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_LogExpr le =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:33: ( ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN (le= poslitconj )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule[gl] )+ CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:35: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN (le= poslitconj )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule[gl] )+ CURLYCLOSE
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:35: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==KNOWLEDGE) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:36: KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE
					{
					match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_module595); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module597); 
					pushFollow(FOLLOW_krspec_in_module599);
					krspec(gl);
					state._fsp--;

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module602); 
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:30: ( GOALS CURLYOPEN (le= poslitconj )* CURLYCLOSE )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==GOALS) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:31: GOALS CURLYOPEN (le= poslitconj )* CURLYCLOSE
					{
					match(input,GOALS,FOLLOW_GOALS_in_module636); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module638); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:49: (le= poslitconj )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==CONST||LA9_0==MINUS||LA9_0==NUMBER||LA9_0==VAR) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:49: le= poslitconj
							{
							pushFollow(FOLLOW_poslitconj_in_module642);
							le=poslitconj();
							state._fsp--;

							}
							break;

						default :
							break loop9;
						}
					}

					gl.addGoal(le);
					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module647); 
					}
					break;

			}

			match(input,PROGRAM,FOLLOW_PROGRAM_in_module680); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:38: ( optionorder )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==SQOPEN) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:39: optionorder
					{
					pushFollow(FOLLOW_optionorder_in_module683);
					optionorder();
					state._fsp--;

					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module687); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:34: ( macro )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==HASH) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:34: macro
					{
					pushFollow(FOLLOW_macro_in_module722);
					macro();
					state._fsp--;

					}
					break;

				default :
					break loop12;
				}
			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:34: ( actionrule[gl] )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==IF) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:34: actionrule[gl]
					{
					pushFollow(FOLLOW_actionrule_in_module758);
					actionrule(gl);
					state._fsp--;

					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module791); 
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
	// $ANTLR end "module"



	// $ANTLR start "krspec"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:1: krspec[Abstract_KRGOALS gl] : (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ ;
	public final void krspec(Abstract_KRGOALS gl) throws RecognitionException {
		Abstract_LogicalFormula hd =null;
		Abstract_LogicalFormula body =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:28: ( (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:31: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:31: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==CONST||LA15_0==MINUS||LA15_0==NUMBER||LA15_0==VAR) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:32: hd= atom ( STOP | PROLOGARROW body= litconj STOP )
					{
					pushFollow(FOLLOW_atom_in_krspec839);
					hd=atom();
					state._fsp--;

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:2: ( STOP | PROLOGARROW body= litconj STOP )
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==STOP) ) {
						alt14=1;
					}
					else if ( (LA14_0==PROLOGARROW) ) {
						alt14=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}

					switch (alt14) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:3: STOP
							{
							match(input,STOP,FOLLOW_STOP_in_krspec843); 
							gl.addFact((Abstract_Predicate) hd);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:2: PROLOGARROW body= litconj STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_krspec851); 
							pushFollow(FOLLOW_litconj_in_krspec855);
							body=litconj();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_krspec857); 
							gl.addKRule(new Abstract_Rule((Abstract_Predicate) hd, body));
							}
							break;

					}

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
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
	// $ANTLR end "krspec"



	// $ANTLR start "brspec"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:1: brspec[Abstract_GOALAgent gl] : (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ ;
	public final void brspec(Abstract_GOALAgent gl) throws RecognitionException {
		Abstract_LogicalFormula hd =null;
		Abstract_LogicalFormula body =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:30: ( (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:33: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:33: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==CONST||LA17_0==MINUS||LA17_0==NUMBER||LA17_0==VAR) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:34: hd= atom ( STOP | PROLOGARROW body= litconj STOP )
					{
					pushFollow(FOLLOW_atom_in_brspec878);
					hd=atom();
					state._fsp--;

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:79:2: ( STOP | PROLOGARROW body= litconj STOP )
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==STOP) ) {
						alt16=1;
					}
					else if ( (LA16_0==PROLOGARROW) ) {
						alt16=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						throw nvae;
					}

					switch (alt16) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:79:3: STOP
							{
							match(input,STOP,FOLLOW_STOP_in_brspec883); 
							gl.addBel((Abstract_Predicate) hd);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:2: PROLOGARROW body= litconj STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_brspec891); 
							pushFollow(FOLLOW_litconj_in_brspec895);
							body=litconj();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_brspec897); 
							gl.addRule(new Abstract_Rule((Abstract_Predicate) hd, body));
							}
							break;

					}

					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
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
	// $ANTLR end "brspec"



	// $ANTLR start "poslitconj"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:1: poslitconj returns [Abstract_LogExpr le] : g= atom ( COMMA g1= atom )* STOP ;
	public final Abstract_LogExpr poslitconj() throws RecognitionException {
		Abstract_LogExpr le = null;


		Abstract_LogicalFormula g =null;
		Abstract_LogicalFormula g1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:42: (g= atom ( COMMA g1= atom )* STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:44: g= atom ( COMMA g1= atom )* STOP
			{
			pushFollow(FOLLOW_atom_in_poslitconj953);
			g=atom();
			state._fsp--;

			Abstract_LogExpr lge = new Abstract_LogExpr(Abstract_LogExpr.none, g);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:83:30: ( COMMA g1= atom )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==COMMA) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:83:31: COMMA g1= atom
					{
					match(input,COMMA,FOLLOW_COMMA_in_poslitconj988); 
					pushFollow(FOLLOW_atom_in_poslitconj992);
					g1=atom();
					state._fsp--;

					lge = new Abstract_LogExpr(lge, Abstract_LogExpr.and, g1);
					}
					break;

				default :
					break loop18;
				}
			}

			match(input,STOP,FOLLOW_STOP_in_poslitconj997); 
			le = lge;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return le;
	}
	// $ANTLR end "poslitconj"



	// $ANTLR start "litconj"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:1: litconj returns [Abstract_LogicalFormula f] : l= literal ( COMMA l1= literal )* ;
	public final Abstract_LogicalFormula litconj() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula l =null;
		Abstract_LogicalFormula l1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:44: (l= literal ( COMMA l1= literal )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:46: l= literal ( COMMA l1= literal )*
			{
			pushFollow(FOLLOW_literal_in_litconj1012);
			l=literal();
			state._fsp--;

			Abstract_LogExpr le = new Abstract_LogExpr(Abstract_LogExpr.none, l);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:2: ( COMMA l1= literal )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==COMMA) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:3: COMMA l1= literal
					{
					match(input,COMMA,FOLLOW_COMMA_in_litconj1019); 
					pushFollow(FOLLOW_literal_in_litconj1023);
					l1=literal();
					state._fsp--;

					le = new Abstract_LogExpr(le, Abstract_LogExpr.and, l1);
					}
					break;

				default :
					break loop19;
				}
			}

			f = le;
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
	// $ANTLR end "litconj"



	// $ANTLR start "literal"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:1: literal returns [Abstract_LogicalFormula l] : (a= atom | ( NOT OPEN a1= atom CLOSE ) );
	public final Abstract_LogicalFormula literal() throws RecognitionException {
		Abstract_LogicalFormula l = null;


		Abstract_LogicalFormula a =null;
		Abstract_LogicalFormula a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:44: (a= atom | ( NOT OPEN a1= atom CLOSE ) )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==CONST||LA20_0==MINUS||LA20_0==NUMBER||LA20_0==VAR) ) {
				alt20=1;
			}
			else if ( (LA20_0==NOT) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:46: a= atom
					{
					pushFollow(FOLLOW_atom_in_literal1043);
					a=atom();
					state._fsp--;

					l=a;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:62: ( NOT OPEN a1= atom CLOSE )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:62: ( NOT OPEN a1= atom CLOSE )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:63: NOT OPEN a1= atom CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_literal1050); 
					match(input,OPEN,FOLLOW_OPEN_in_literal1052); 
					pushFollow(FOLLOW_atom_in_literal1056);
					a1=atom();
					state._fsp--;

					l=new Abstract_LogExpr(Abstract_LogExpr.not, a1);
					match(input,CLOSE,FOLLOW_CLOSE_in_literal1060); 
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
		return l;
	}
	// $ANTLR end "literal"



	// $ANTLR start "atom"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:1: atom returns [Abstract_LogicalFormula t] : (s= id (tl= parameters ) |e= equation );
	public final Abstract_LogicalFormula atom() throws RecognitionException {
		Abstract_LogicalFormula t = null;


		String s =null;
		Abstract_Term[] tl =null;
		Abstract_Equation e =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:42: (s= id (tl= parameters ) |e= equation )
			int alt21=2;
			switch ( input.LA(1) ) {
			case CONST:
				{
				alt21=1;
				}
				break;
			case VAR:
				{
				int LA21_2 = input.LA(2);
				if ( (LA21_2==OPEN) ) {
					alt21=1;
				}
				else if ( (LA21_2==DIV||LA21_2==EQUALS||LA21_2==LESS||LA21_2==MINUS||LA21_2==MULT||LA21_2==PLUS) ) {
					alt21=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 21, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case MINUS:
			case NUMBER:
				{
				alt21=2;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:44: s= id (tl= parameters )
					{
					pushFollow(FOLLOW_id_in_atom1075);
					s=id();
					state._fsp--;

					Abstract_Predicate p =new Abstract_Predicate(s);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:99: (tl= parameters )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:101: tl= parameters
					{
					pushFollow(FOLLOW_parameters_in_atom1082);
					tl=parameters();
					state._fsp--;

					p.setTerms(tl); t = p;
					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:3: e= equation
					{
					pushFollow(FOLLOW_equation_in_atom1093);
					e=equation();
					state._fsp--;

					t = e;
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



	// $ANTLR start "parameters"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:1: parameters returns [Abstract_Term[] ts] : OPEN t= term ( COMMA t1= term )* CLOSE ;
	public final Abstract_Term[] parameters() throws RecognitionException {
		Abstract_Term[] ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:42: ( OPEN t= term ( COMMA t1= term )* CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:44: OPEN t= term ( COMMA t1= term )* CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_parameters1108); 
			pushFollow(FOLLOW_term_in_parameters1112);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:95:2: ( COMMA t1= term )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==COMMA) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:95:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_parameters1119); 
					pushFollow(FOLLOW_term_in_parameters1123);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop22;
				}
			}

			match(input,CLOSE,FOLLOW_CLOSE_in_parameters1129); 
			 ts = (Abstract_Term[]) tl.toArray(new Abstract_Term[0]);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ts;
	}
	// $ANTLR end "parameters"



	// $ANTLR start "optionorder"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:1: optionorder : SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE ;
	public final void optionorder() throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:13: ( SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:15: SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE
			{
			match(input,SQOPEN,FOLLOW_SQOPEN_in_optionorder1140); 
			match(input,ORDER,FOLLOW_ORDER_in_optionorder1142); 
			match(input,EQUALS,FOLLOW_EQUALS_in_optionorder1144); 
			if ( (input.LA(1) >= LINEAR && input.LA(1) <= LINEARALL)||(input.LA(1) >= RANDOM && input.LA(1) <= RANDOMALL) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_optionorder1164); 
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
	// $ANTLR end "optionorder"



	// $ANTLR start "macro"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:1: macro : HASH DEFINE f= id pl= parameters msc= mentalstatecond STOP ;
	public final void macro() throws RecognitionException {
		String f =null;
		Abstract_Term[] pl =null;
		Abstract_MentalState msc =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:7: ( HASH DEFINE f= id pl= parameters msc= mentalstatecond STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:9: HASH DEFINE f= id pl= parameters msc= mentalstatecond STOP
			{
			match(input,HASH,FOLLOW_HASH_in_macro1172); 
			match(input,DEFINE,FOLLOW_DEFINE_in_macro1174); 
			pushFollow(FOLLOW_id_in_macro1178);
			f=id();
			state._fsp--;

			pushFollow(FOLLOW_parameters_in_macro1182);
			pl=parameters();
			state._fsp--;

			pushFollow(FOLLOW_mentalstatecond_in_macro1186);
			msc=mentalstatecond();
			state._fsp--;

			PredicateIndicator pi = new PredicateIndicator(f, pl.length); macros.put(pi, msc); 
			                                  Abstract_Predicate p = new Abstract_Predicate(f); p.setTerms(pl); macro_subs.put(pi, p);
			match(input,STOP,FOLLOW_STOP_in_macro1190); 
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
	// $ANTLR end "macro"



	// $ANTLR start "actionrule"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:1: actionrule[Abstract_GOALModule gl] : IF (lf= mentalstatecond |f= id pl= parameters ) THEN dl= actioncombo[gl] STOP ;
	public final void actionrule(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_MentalState lf =null;
		String f =null;
		Abstract_Term[] pl =null;
		ArrayList<Abstract_Deed> dl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:39: ( IF (lf= mentalstatecond |f= id pl= parameters ) THEN dl= actioncombo[gl] STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:41: IF (lf= mentalstatecond |f= id pl= parameters ) THEN dl= actioncombo[gl] STOP
			{
			Abstract_ActionRule rule = new Abstract_ActionRule();
			match(input,IF,FOLLOW_IF_in_actionrule1206); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:103:5: (lf= mentalstatecond |f= id pl= parameters )
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==BEL||LA23_0==GOAL||LA23_0==NOT||LA23_0==TRUE) ) {
				alt23=1;
			}
			else if ( (LA23_0==CONST||LA23_0==VAR) ) {
				alt23=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}

			switch (alt23) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:103:6: lf= mentalstatecond
					{
					pushFollow(FOLLOW_mentalstatecond_in_actionrule1211);
					lf=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(lf);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:104:4: f= id pl= parameters
					{
					pushFollow(FOLLOW_id_in_actionrule1221);
					f=id();
					state._fsp--;

					pushFollow(FOLLOW_parameters_in_actionrule1225);
					pl=parameters();
					state._fsp--;

					PredicateIndicator pi = new PredicateIndicator(f, pl.length); 
							                                      Abstract_MentalState macro=macros.get(pi); 
							                                      Abstract_Term sub=macro_subs.get(pi); 
							                                      Abstract_Predicate p = new Abstract_Predicate(f); p.setTerms(pl);
								            Abstract_MentalState k = new Abstract_MentalState(macro, sub, p); rule.setMentalStateCond(k);
					}
					break;

			}

			match(input,THEN,FOLLOW_THEN_in_actionrule1233); 
			pushFollow(FOLLOW_actioncombo_in_actionrule1237);
			dl=actioncombo(gl);
			state._fsp--;

			rule.setBody(dl);
			match(input,STOP,FOLLOW_STOP_in_actionrule1242); 
			gl.addPlan(rule);
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
	// $ANTLR end "actionrule"



	// $ANTLR start "mentalstatecond"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:1: mentalstatecond returns [Abstract_MentalState lf] : ml= mentalliteral ( COMMA ml2= mentalliteral )* ;
	public final Abstract_MentalState mentalstatecond() throws RecognitionException {
		Abstract_MentalState lf = null;


		Abstract_GLogicalFormula ml =null;
		Abstract_GLogicalFormula ml2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:112:2: (ml= mentalliteral ( COMMA ml2= mentalliteral )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:112:4: ml= mentalliteral ( COMMA ml2= mentalliteral )*
			{
			pushFollow(FOLLOW_mentalliteral_in_mentalstatecond1260);
			ml=mentalliteral();
			state._fsp--;

			Abstract_MentalState ms = new Abstract_MentalState(ml);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:2: ( COMMA ml2= mentalliteral )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==COMMA) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:3: COMMA ml2= mentalliteral
					{
					match(input,COMMA,FOLLOW_COMMA_in_mentalstatecond1267); 
					pushFollow(FOLLOW_mentalliteral_in_mentalstatecond1271);
					ml2=mentalliteral();
					state._fsp--;

					ms = new Abstract_MentalState(ms, Abstract_Guard.and, ml2);
					}
					break;

				default :
					break loop24;
				}
			}

			lf = ms;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return lf;
	}
	// $ANTLR end "mentalstatecond"



	// $ANTLR start "mentalliteral"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:116:1: mentalliteral returns [Abstract_GLogicalFormula lf] : ( TRUE |ma= mentalatom | NOT OPEN nma= mentalatom CLOSE );
	public final Abstract_GLogicalFormula mentalliteral() throws RecognitionException {
		Abstract_GLogicalFormula lf = null;


		Abstract_GLogicalFormula ma =null;
		Abstract_GLogicalFormula nma =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:2: ( TRUE |ma= mentalatom | NOT OPEN nma= mentalatom CLOSE )
			int alt25=3;
			switch ( input.LA(1) ) {
			case TRUE:
				{
				alt25=1;
				}
				break;
			case BEL:
			case GOAL:
				{
				alt25=2;
				}
				break;
			case NOT:
				{
				alt25=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_mentalliteral1293); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:11: ma= mentalatom
					{
					pushFollow(FOLLOW_mentalatom_in_mentalliteral1299);
					ma=mentalatom();
					state._fsp--;

					lf = ma;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:39: NOT OPEN nma= mentalatom CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_mentalliteral1305); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalliteral1307); 
					pushFollow(FOLLOW_mentalatom_in_mentalliteral1311);
					nma=mentalatom();
					state._fsp--;

					lf = new Abstract_Guard(Abstract_Guard.not, nma);
					match(input,CLOSE,FOLLOW_CLOSE_in_mentalliteral1315); 
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
		return lf;
	}
	// $ANTLR end "mentalliteral"



	// $ANTLR start "mentalatom"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:1: mentalatom returns [Abstract_GLogicalFormula lf] : ( BEL OPEN b= litconj CLOSE | GOAL OPEN g= litconj CLOSE );
	public final Abstract_GLogicalFormula mentalatom() throws RecognitionException {
		Abstract_GLogicalFormula lf = null;


		Abstract_LogicalFormula b =null;
		Abstract_LogicalFormula g =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:2: ( BEL OPEN b= litconj CLOSE | GOAL OPEN g= litconj CLOSE )
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==BEL) ) {
				alt26=1;
			}
			else if ( (LA26_0==GOAL) ) {
				alt26=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:4: BEL OPEN b= litconj CLOSE
					{
					match(input,BEL,FOLLOW_BEL_in_mentalatom1329); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalatom1331); 
					pushFollow(FOLLOW_litconj_in_mentalatom1335);
					b=litconj();
					state._fsp--;

					lf = new Abstract_MentalAtom(b, DefaultAILStructure.AILBel);
					match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1340); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:96: GOAL OPEN g= litconj CLOSE
					{
					match(input,GOAL,FOLLOW_GOAL_in_mentalatom1344); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalatom1346); 
					pushFollow(FOLLOW_litconj_in_mentalatom1350);
					g=litconj();
					state._fsp--;

					lf = new Abstract_MentalAtom(g, DefaultAILStructure.AILGoal);
					match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1353); 
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
		return lf;
	}
	// $ANTLR end "mentalatom"



	// $ANTLR start "actionspec"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:1: actionspec[Abstract_GOALAgent gl] : a= action[gl] CURLYOPEN PRE CURLYOPEN lf1= litconj CURLYCLOSE POST CURLYOPEN lf2= litconj CURLYCLOSE CURLYCLOSE ;
	public final void actionspec(Abstract_GOALAgent gl) throws RecognitionException {
		Abstract_Deed a =null;
		Abstract_LogicalFormula lf1 =null;
		Abstract_LogicalFormula lf2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:34: (a= action[gl] CURLYOPEN PRE CURLYOPEN lf1= litconj CURLYCLOSE POST CURLYOPEN lf2= litconj CURLYCLOSE CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:36: a= action[gl] CURLYOPEN PRE CURLYOPEN lf1= litconj CURLYCLOSE POST CURLYOPEN lf2= litconj CURLYCLOSE CURLYCLOSE
			{
			pushFollow(FOLLOW_action_in_actionspec1365);
			a=action(gl);
			state._fsp--;

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1370); 
			match(input,PRE,FOLLOW_PRE_in_actionspec1372); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1374); 
			pushFollow(FOLLOW_litconj_in_actionspec1378);
			lf1=litconj();
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1380); 
			Abstract_MentalAtom pres = new Abstract_MentalAtom(lf1, DefaultAILStructure.AILBel);
			match(input,POST,FOLLOW_POST_in_actionspec1385); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1387); 
			pushFollow(FOLLOW_litconj_in_actionspec1391);
			lf2=litconj();
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1393); 
			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1395); 
			gl.addCap(new Abstract_ActionSpec(a, pres, lf2));
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
	// $ANTLR end "actionspec"



	// $ANTLR start "actioncombo"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:1: actioncombo[Abstract_GOALModule gl] returns [ArrayList<Abstract_Deed> dl] :a= action[gl] ( PLUS a1= action[gl] )* ;
	public final ArrayList<Abstract_Deed> actioncombo(Abstract_GOALModule gl) throws RecognitionException {
		ArrayList<Abstract_Deed> dl = null;


		Abstract_Deed a =null;
		Abstract_Deed a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:2: (a= action[gl] ( PLUS a1= action[gl] )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:4: a= action[gl] ( PLUS a1= action[gl] )*
			{
			dl = new ArrayList<Abstract_Deed>();
			pushFollow(FOLLOW_action_in_actioncombo1415);
			a=action(gl);
			state._fsp--;

			dl.add(a);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:71: ( PLUS a1= action[gl] )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==PLUS) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:72: PLUS a1= action[gl]
					{
					match(input,PLUS,FOLLOW_PLUS_in_actioncombo1421); 
					pushFollow(FOLLOW_action_in_actioncombo1425);
					a1=action(gl);
					state._fsp--;

					dl.add(a1);
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
		return dl;
	}
	// $ANTLR end "actioncombo"



	// $ANTLR start "action"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:1: action[Abstract_KRGOALS gl] returns [Abstract_Deed d] : (deed= userdefaction | builtinaction | communication[gl] ) ;
	public final Abstract_Deed action(Abstract_KRGOALS gl) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Deed deed =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:55: ( (deed= userdefaction | builtinaction | communication[gl] ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:57: (deed= userdefaction | builtinaction | communication[gl] )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:57: (deed= userdefaction | builtinaction | communication[gl] )
			int alt28=3;
			switch ( input.LA(1) ) {
			case CONST:
			case VAR:
				{
				alt28=1;
				}
				break;
			case ADOPT:
			case DELETE:
			case DROP:
			case INSERT:
				{
				alt28=2;
				}
				break;
			case SEND:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:58: deed= userdefaction
					{
					pushFollow(FOLLOW_userdefaction_in_action1447);
					deed=userdefaction();
					state._fsp--;

					d =deed;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:89: builtinaction
					{
					pushFollow(FOLLOW_builtinaction_in_action1452);
					builtinaction();
					state._fsp--;

					d = new Abstract_Deed(Abstract_Deed.DNull);
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:152: communication[gl]
					{
					pushFollow(FOLLOW_communication_in_action1458);
					communication(gl);
					state._fsp--;

					d = new Abstract_Deed(Abstract_Deed.DNull);
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
	// $ANTLR end "action"



	// $ANTLR start "userdefaction"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:132:1: userdefaction returns [Abstract_Deed d] : f= id (pl= parameters )+ ;
	public final Abstract_Deed userdefaction() throws RecognitionException {
		Abstract_Deed d = null;


		String f =null;
		Abstract_Term[] pl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:2: (f= id (pl= parameters )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:4: f= id (pl= parameters )+
			{
			pushFollow(FOLLOW_id_in_userdefaction1478);
			f=id();
			state._fsp--;

			Abstract_Predicate p = new Abstract_Predicate(f);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:61: (pl= parameters )+
			int cnt29=0;
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==OPEN) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:62: pl= parameters
					{
					pushFollow(FOLLOW_parameters_in_userdefaction1485);
					pl=parameters();
					state._fsp--;

					p.setTerms(pl);
					}
					break;

				default :
					if ( cnt29 >= 1 ) break loop29;
					EarlyExitException eee = new EarlyExitException(29, input);
					throw eee;
				}
				cnt29++;
			}

			d=new Abstract_Deed(p);
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
	// $ANTLR end "userdefaction"



	// $ANTLR start "builtinaction"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:1: builtinaction : ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN poslitconj CLOSE | DROP OPEN litconj CLOSE );
	public final void builtinaction() throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:136:2: ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN poslitconj CLOSE | DROP OPEN litconj CLOSE )
			int alt30=4;
			switch ( input.LA(1) ) {
			case INSERT:
				{
				alt30=1;
				}
				break;
			case DELETE:
				{
				alt30=2;
				}
				break;
			case ADOPT:
				{
				alt30=3;
				}
				break;
			case DROP:
				{
				alt30=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}
			switch (alt30) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:136:4: INSERT OPEN litconj CLOSE
					{
					match(input,INSERT,FOLLOW_INSERT_in_builtinaction1502); 
					match(input,OPEN,FOLLOW_OPEN_in_builtinaction1504); 
					pushFollow(FOLLOW_litconj_in_builtinaction1506);
					litconj();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1508); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:137:3: DELETE OPEN litconj CLOSE
					{
					match(input,DELETE,FOLLOW_DELETE_in_builtinaction1514); 
					match(input,OPEN,FOLLOW_OPEN_in_builtinaction1516); 
					pushFollow(FOLLOW_litconj_in_builtinaction1518);
					litconj();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1520); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:138:4: ADOPT OPEN poslitconj CLOSE
					{
					match(input,ADOPT,FOLLOW_ADOPT_in_builtinaction1527); 
					match(input,OPEN,FOLLOW_OPEN_in_builtinaction1529); 
					pushFollow(FOLLOW_poslitconj_in_builtinaction1531);
					poslitconj();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1533); 
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:139:4: DROP OPEN litconj CLOSE
					{
					match(input,DROP,FOLLOW_DROP_in_builtinaction1540); 
					match(input,OPEN,FOLLOW_OPEN_in_builtinaction1542); 
					pushFollow(FOLLOW_litconj_in_builtinaction1544);
					litconj();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1546); 
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
	}
	// $ANTLR end "builtinaction"



	// $ANTLR start "communication"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:141:1: communication[Abstract_KRGOALS gl] returns [Abstract_Deed d] : SEND OPEN id COMMA poslitconj CLOSE ;
	public final Abstract_Deed communication(Abstract_KRGOALS gl) throws RecognitionException {
		Abstract_Deed d = null;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:2: ( SEND OPEN id COMMA poslitconj CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:4: SEND OPEN id COMMA poslitconj CLOSE
			{
			match(input,SEND,FOLLOW_SEND_in_communication1563); 
			match(input,OPEN,FOLLOW_OPEN_in_communication1565); 
			pushFollow(FOLLOW_id_in_communication1567);
			id();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_communication1569); 
			pushFollow(FOLLOW_poslitconj_in_communication1571);
			poslitconj();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_communication1573); 
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
	// $ANTLR end "communication"



	// $ANTLR start "id"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:1: id returns [String s] : ( CONST | VAR ) ;
	public final String id() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:23: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:25: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:25: ( CONST | VAR )
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==CONST) ) {
				alt31=1;
			}
			else if ( (LA31_0==VAR) ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:26: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_id1627); 
					s = CONST1.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:58: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_id1632); 
					s = VAR2.getText();
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
	// $ANTLR end "id"



	// $ANTLR start "equation"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:183:2: equation returns [Abstract_Equation e] : a1= arithexpr i= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation e = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:184:3: (a1= arithexpr i= eqoper a2= arithexpr )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:184:5: a1= arithexpr i= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation1954);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation1958);
			i=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation1962);
			a2=arithexpr();
			state._fsp--;

			e = new Abstract_Equation(a1, i, a2);
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
	// $ANTLR end "equation"



	// $ANTLR start "term"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:2: term returns [Abstract_Term t] : (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) ;
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_StringTerm st =null;
		Abstract_Term ft =null;
		Abstract_NumberTerm at =null;
		Abstract_ListTermImpl lt =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:33: ( (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:35: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:35: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			int alt32=4;
			switch ( input.LA(1) ) {
			case DOUBLEQUOTE:
				{
				alt32=1;
				}
				break;
			case CONST:
				{
				alt32=2;
				}
				break;
			case MINUS:
			case NUMBER:
			case VAR:
				{
				alt32=3;
				}
				break;
			case SQOPEN:
				{
				alt32=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}
			switch (alt32) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:36: st= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term1979);
					st=stringterm();
					state._fsp--;

					t = st;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:63: ft= function_term
					{
					pushFollow(FOLLOW_function_term_in_term1987);
					ft=function_term();
					state._fsp--;

					t =ft;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:91: at= arithexpr
					{
					pushFollow(FOLLOW_arithexpr_in_term1995);
					at=arithexpr();
					state._fsp--;

					t =at;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:114: lt= listterm
					{
					pushFollow(FOLLOW_listterm_in_term2002);
					lt=listterm();
					state._fsp--;

					t =lt;
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
	// $ANTLR end "term"



	// $ANTLR start "function_term"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:186:2: function_term returns [Abstract_Term t] : c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? ;
	public final Abstract_Term function_term() throws RecognitionException {
		Abstract_Term t = null;


		Token c=null;
		Abstract_Term t1 =null;
		Abstract_Term t2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:187:3: (c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:187:5: c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			{
			c=(Token)match(input,CONST,FOLLOW_CONST_in_function_term2022); 
			t=new Abstract_Predicate(c.getText());
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:187:54: ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==OPEN) ) {
				alt34=1;
			}
			switch (alt34) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:187:55: OPEN t1= term ( COMMA t2= term )* CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function_term2027); 
					pushFollow(FOLLOW_term_in_function_term2031);
					t1=term();
					state._fsp--;

					((Abstract_Predicate) t).addTerm(t1);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:187:111: ( COMMA t2= term )*
					loop33:
					while (true) {
						int alt33=2;
						int LA33_0 = input.LA(1);
						if ( (LA33_0==COMMA) ) {
							alt33=1;
						}

						switch (alt33) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:187:112: COMMA t2= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_function_term2036); 
							pushFollow(FOLLOW_term_in_function_term2040);
							t2=term();
							state._fsp--;

							((Abstract_Predicate) t).addTerm(t2);
							}
							break;

						default :
							break loop33;
						}
					}

					match(input,CLOSE,FOLLOW_CLOSE_in_function_term2046); 
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
	// $ANTLR end "function_term"



	// $ANTLR start "atom_term"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:2: atom_term returns [Abstract_NumberTerm t] : (n= numberstring |v= var ) ;
	public final Abstract_NumberTerm atom_term() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:44: ( (n= numberstring |v= var ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:46: (n= numberstring |v= var )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:46: (n= numberstring |v= var )
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==MINUS||LA35_0==NUMBER) ) {
				alt35=1;
			}
			else if ( (LA35_0==VAR) ) {
				alt35=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}

			switch (alt35) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:47: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom_term2065);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:108: v= var
					{
					pushFollow(FOLLOW_var_in_atom_term2073);
					v=var();
					state._fsp--;

					t = v;
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
	// $ANTLR end "atom_term"



	// $ANTLR start "stringterm"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:189:2: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE w= word DOUBLEQUOTE ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		String w =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:190:3: ( DOUBLEQUOTE w= word DOUBLEQUOTE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:190:5: DOUBLEQUOTE w= word DOUBLEQUOTE
			{
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2090); 
			pushFollow(FOLLOW_word_in_stringterm2094);
			w=word();
			state._fsp--;

			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2096); 
			s=new Abstract_StringTermImpl(w);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:191:2: var returns [Abstract_VarTerm v] : VAR ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR3=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:191:35: ( VAR )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:191:37: VAR
			{
			VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_var2110); 

				if (variables.containsKey(VAR3.getText())) {
					v = variables.get(VAR3.getText());
					} else {
					v = new Abstract_VarTerm(VAR3.getText());
					variables.put(VAR3.getText(), v);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:2: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:3: ( ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:5: ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? )
			{
			s = "";
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:16: ( MINUS )?
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==MINUS) ) {
				alt36=1;
			}
			switch (alt36) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:17: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring2130); 
					s += "-";
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:38: (n1= NUMBER ( STOP n2= NUMBER )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:39: n1= NUMBER ( STOP n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2139); 
			s += n1.getText();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:202:37: ( STOP n2= NUMBER )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==STOP) ) {
				int LA37_1 = input.LA(2);
				if ( (LA37_1==NUMBER) ) {
					alt37=1;
				}
			}
			switch (alt37) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:202:38: STOP n2= NUMBER
					{
					match(input,STOP,FOLLOW_STOP_in_numberstring2180); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2186); 
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



	// $ANTLR start "arithexpr"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:204:1: arithexpr returns [Abstract_NumberTerm ae] : a1= multexpr (i= addoper a2= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:205:3: (a1= multexpr (i= addoper a2= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:205:6: a1= multexpr (i= addoper a2= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr2240);
			a1=multexpr();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:205:30: (i= addoper a2= multexpr )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==MINUS||LA38_0==PLUS) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:205:31: i= addoper a2= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr2247);
					i=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr2251);
					a2=multexpr();
					state._fsp--;

					ae = new Abstract_ArithExpr(ae, i, a2);
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
		return ae;
	}
	// $ANTLR end "arithexpr"



	// $ANTLR start "multexpr"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:1: multexpr returns [Abstract_NumberTerm ae] : a1= atom_term (i= multoper a2= atom_term )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:42: (a1= atom_term (i= multoper a2= atom_term )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:44: a1= atom_term (i= multoper a2= atom_term )?
			{
			pushFollow(FOLLOW_atom_term_in_multexpr2267);
			a1=atom_term();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:68: (i= multoper a2= atom_term )?
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==DIV||LA39_0==MULT) ) {
				alt39=1;
			}
			switch (alt39) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:69: i= multoper a2= atom_term
					{
					pushFollow(FOLLOW_multoper_in_multexpr2273);
					i=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_term_in_multexpr2277);
					a2=atom_term();
					state._fsp--;

					ae = new Abstract_ArithExpr(ae, i, a2);
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
		return ae;
	}
	// $ANTLR end "multexpr"



	// $ANTLR start "word"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST4=null;
		Token VAR5=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:25: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:27: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:27: ( CONST | VAR )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:28: CONST
					{
					CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_word2294); 
					s =CONST4.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:59: VAR
					{
					VAR5=(Token)match(input,VAR,FOLLOW_VAR_in_word2300); 
					s =VAR5.getText();
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



	// $ANTLR start "listterm"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:211:2: listterm returns [Abstract_ListTermImpl l] : SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE ;
	public final Abstract_ListTermImpl listterm() throws RecognitionException {
		Abstract_ListTermImpl l = null;


		Token v=null;
		Abstract_Term h =null;
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:212:3: ( SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:212:5: SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE
			{
			l = new Abstract_ListTermImpl(); Abstract_ListTerm lrunning = l;
			match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2410); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:213:10: (h= term ( COMMA t= term )* ( BAR v= VAR )? )?
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==CONST||LA43_0==DOUBLEQUOTE||LA43_0==MINUS||LA43_0==NUMBER||LA43_0==SQOPEN||LA43_0==VAR) ) {
				alt43=1;
			}
			switch (alt43) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:213:11: h= term ( COMMA t= term )* ( BAR v= VAR )?
					{
					pushFollow(FOLLOW_term_in_listterm2415);
					h=term();
					state._fsp--;

					l.addHead(h); l.addTail(new Abstract_ListTermImpl());
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:214:3: ( COMMA t= term )*
					loop41:
					while (true) {
						int alt41=2;
						int LA41_0 = input.LA(1);
						if ( (LA41_0==COMMA) ) {
							alt41=1;
						}

						switch (alt41) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:214:4: COMMA t= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_listterm2423); 
							pushFollow(FOLLOW_term_in_listterm2427);
							t=term();
							state._fsp--;

							Abstract_ListTerm l2 = new Abstract_ListTermImpl();  l2.addHead(t); l2.addTail(new Abstract_ListTermImpl()); lrunning.addTail(l2); lrunning=l2;
							}
							break;

						default :
							break loop41;
						}
					}

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:3: ( BAR v= VAR )?
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==BAR) ) {
						alt42=1;
					}
					switch (alt42) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:4: BAR v= VAR
							{
							match(input,BAR,FOLLOW_BAR_in_listterm2437); 
							v=(Token)match(input,VAR,FOLLOW_VAR_in_listterm2441); 
							lrunning.addTail(new Abstract_VarTerm(v.getText()));
							}
							break;

					}

					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2450); 
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



	// $ANTLR start "addoper"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:217:2: addoper returns [int i] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:217:25: ( ( PLUS | MINUS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:217:27: ( PLUS | MINUS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:217:27: ( PLUS | MINUS )
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==PLUS) ) {
				alt44=1;
			}
			else if ( (LA44_0==MINUS) ) {
				alt44=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}

			switch (alt44) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:217:28: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper2465); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:217:45: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper2471); 
					i = 2;
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
	// $ANTLR end "addoper"



	// $ANTLR start "multoper"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:218:2: multoper returns [int i] : ( MULT | DIV ) ;
	public final int multoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:3: ( ( MULT | DIV ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:5: ( MULT | DIV )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:5: ( MULT | DIV )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==MULT) ) {
				alt45=1;
			}
			else if ( (LA45_0==DIV) ) {
				alt45=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}

			switch (alt45) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:6: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper2490); 
					i = 3;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:23: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper2496); 
					i = 4;
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
	// $ANTLR end "multoper"



	// $ANTLR start "eqoper"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:2: eqoper returns [int i] : ( LESS | EQUALS ) ;
	public final int eqoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:25: ( ( LESS | EQUALS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:27: ( LESS | EQUALS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:27: ( LESS | EQUALS )
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==LESS) ) {
				alt46=1;
			}
			else if ( (LA46_0==EQUALS) ) {
				alt46=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}

			switch (alt46) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:28: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2513); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:45: EQUALS
					{
					match(input,EQUALS,FOLLOW_EQUALS_in_eqoper2519); 
					i = 2;
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
	// $ANTLR end "eqoper"

	// Delegated rules



	public static final BitSet FOLLOW_MAIN_in_program94 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_program96 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_id_in_program100 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program102 = new BitSet(new long[]{0x0000000211000100L});
	public static final BitSet FOLLOW_KNOWLEDGE_in_program129 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program131 = new BitSet(new long[]{0x0080008400002000L});
	public static final BitSet FOLLOW_krspec_in_program133 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program136 = new BitSet(new long[]{0x0000000201000100L});
	public static final BitSet FOLLOW_BELIEFS_in_program181 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program183 = new BitSet(new long[]{0x0080008400002000L});
	public static final BitSet FOLLOW_brspec_in_program185 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program188 = new BitSet(new long[]{0x0000000201000000L});
	public static final BitSet FOLLOW_GOALS_in_program233 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program235 = new BitSet(new long[]{0x0080008400006000L});
	public static final BitSet FOLLOW_poslitconj_in_program239 = new BitSet(new long[]{0x0080008400006000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program244 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_MAIN_in_program289 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_MODULE_in_program291 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program293 = new BitSet(new long[]{0x0000200011000000L});
	public static final BitSet FOLLOW_module_in_program297 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program300 = new BitSet(new long[]{0x0000000000404010L});
	public static final BitSet FOLLOW_EVENT_in_program344 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_MODULE_in_program346 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program348 = new BitSet(new long[]{0x0000200011000000L});
	public static final BitSet FOLLOW_module_in_program352 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program355 = new BitSet(new long[]{0x0000000000004010L});
	public static final BitSet FOLLOW_ACTIONSPEC_in_program401 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program403 = new BitSet(new long[]{0x0082000008122020L});
	public static final BitSet FOLLOW_actionspec_in_program405 = new BitSet(new long[]{0x0082000008126020L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program409 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KNOWLEDGE_in_module595 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module597 = new BitSet(new long[]{0x0080008400002000L});
	public static final BitSet FOLLOW_krspec_in_module599 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module602 = new BitSet(new long[]{0x0000200001000000L});
	public static final BitSet FOLLOW_GOALS_in_module636 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module638 = new BitSet(new long[]{0x0080008400006000L});
	public static final BitSet FOLLOW_poslitconj_in_module642 = new BitSet(new long[]{0x0080008400006000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module647 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_PROGRAM_in_module680 = new BitSet(new long[]{0x0008000000008000L});
	public static final BitSet FOLLOW_optionorder_in_module683 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module687 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_macro_in_module722 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_actionrule_in_module758 = new BitSet(new long[]{0x0000000004004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module791 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_krspec839 = new BitSet(new long[]{0x0010400000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec843 = new BitSet(new long[]{0x0080008400002002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_krspec851 = new BitSet(new long[]{0x008000C400002000L});
	public static final BitSet FOLLOW_litconj_in_krspec855 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec857 = new BitSet(new long[]{0x0080008400002002L});
	public static final BitSet FOLLOW_atom_in_brspec878 = new BitSet(new long[]{0x0010400000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec883 = new BitSet(new long[]{0x0080008400002002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_brspec891 = new BitSet(new long[]{0x008000C400002000L});
	public static final BitSet FOLLOW_litconj_in_brspec895 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec897 = new BitSet(new long[]{0x0080008400002002L});
	public static final BitSet FOLLOW_atom_in_poslitconj953 = new BitSet(new long[]{0x0010000000000800L});
	public static final BitSet FOLLOW_COMMA_in_poslitconj988 = new BitSet(new long[]{0x0080008400002000L});
	public static final BitSet FOLLOW_atom_in_poslitconj992 = new BitSet(new long[]{0x0010000000000800L});
	public static final BitSet FOLLOW_STOP_in_poslitconj997 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_litconj1012 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_litconj1019 = new BitSet(new long[]{0x008000C400002000L});
	public static final BitSet FOLLOW_literal_in_litconj1023 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_atom_in_literal1043 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_literal1050 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_literal1052 = new BitSet(new long[]{0x0080008400002000L});
	public static final BitSet FOLLOW_atom_in_literal1056 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_literal1060 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_atom1075 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_parameters_in_atom1082 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_atom1093 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_parameters1108 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_parameters1112 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_COMMA_in_parameters1119 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_parameters1123 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_CLOSE_in_parameters1129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_optionorder1140 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_ORDER_in_optionorder1142 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_EQUALS_in_optionorder1144 = new BitSet(new long[]{0x00018000C0000000L});
	public static final BitSet FOLLOW_set_in_optionorder1146 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_optionorder1164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HASH_in_macro1172 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DEFINE_in_macro1174 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_id_in_macro1178 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_parameters_in_macro1182 = new BitSet(new long[]{0x0040004000800080L});
	public static final BitSet FOLLOW_mentalstatecond_in_macro1186 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STOP_in_macro1190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_actionrule1206 = new BitSet(new long[]{0x00C0004000802080L});
	public static final BitSet FOLLOW_mentalstatecond_in_actionrule1211 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_id_in_actionrule1221 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_parameters_in_actionrule1225 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_THEN_in_actionrule1233 = new BitSet(new long[]{0x0082000008122020L});
	public static final BitSet FOLLOW_actioncombo_in_actionrule1237 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STOP_in_actionrule1242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond1260 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_mentalstatecond1267 = new BitSet(new long[]{0x0040004000800080L});
	public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond1271 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_TRUE_in_mentalliteral1293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mentalatom_in_mentalliteral1299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_mentalliteral1305 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalliteral1307 = new BitSet(new long[]{0x0000000000800080L});
	public static final BitSet FOLLOW_mentalatom_in_mentalliteral1311 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_mentalliteral1315 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEL_in_mentalatom1329 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalatom1331 = new BitSet(new long[]{0x008000C400002000L});
	public static final BitSet FOLLOW_litconj_in_mentalatom1335 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_mentalatom1340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_mentalatom1344 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalatom1346 = new BitSet(new long[]{0x008000C400002000L});
	public static final BitSet FOLLOW_litconj_in_mentalatom1350 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_mentalatom1353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actionspec1365 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1370 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_PRE_in_actionspec1372 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1374 = new BitSet(new long[]{0x008000C400002000L});
	public static final BitSet FOLLOW_litconj_in_actionspec1378 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1380 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_POST_in_actionspec1385 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1387 = new BitSet(new long[]{0x008000C400002000L});
	public static final BitSet FOLLOW_litconj_in_actionspec1391 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1393 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actioncombo1415 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_PLUS_in_actioncombo1421 = new BitSet(new long[]{0x0082000008122020L});
	public static final BitSet FOLLOW_action_in_actioncombo1425 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_userdefaction_in_action1447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_builtinaction_in_action1452 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_communication_in_action1458 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_userdefaction1478 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_parameters_in_userdefaction1485 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_INSERT_in_builtinaction1502 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_builtinaction1504 = new BitSet(new long[]{0x008000C400002000L});
	public static final BitSet FOLLOW_litconj_in_builtinaction1506 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_builtinaction1508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DELETE_in_builtinaction1514 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_builtinaction1516 = new BitSet(new long[]{0x008000C400002000L});
	public static final BitSet FOLLOW_litconj_in_builtinaction1518 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_builtinaction1520 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADOPT_in_builtinaction1527 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_builtinaction1529 = new BitSet(new long[]{0x0080008400002000L});
	public static final BitSet FOLLOW_poslitconj_in_builtinaction1531 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_builtinaction1533 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_builtinaction1540 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_builtinaction1542 = new BitSet(new long[]{0x008000C400002000L});
	public static final BitSet FOLLOW_litconj_in_builtinaction1544 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_builtinaction1546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEND_in_communication1563 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_communication1565 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_id_in_communication1567 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_communication1569 = new BitSet(new long[]{0x0080008400002000L});
	public static final BitSet FOLLOW_poslitconj_in_communication1571 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_communication1573 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_id1627 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_id1632 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation1954 = new BitSet(new long[]{0x0000000020200000L});
	public static final BitSet FOLLOW_eqoper_in_equation1958 = new BitSet(new long[]{0x0080008400000000L});
	public static final BitSet FOLLOW_arithexpr_in_equation1962 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_term1979 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_term1987 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_term1995 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_term2002 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function_term2022 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_OPEN_in_function_term2027 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_function_term2031 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_COMMA_in_function_term2036 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_function_term2040 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_CLOSE_in_function_term2046 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom_term2065 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom_term2073 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2090 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_word_in_stringterm2094 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var2110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring2130 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2139 = new BitSet(new long[]{0x0010000000000002L});
	public static final BitSet FOLLOW_STOP_in_numberstring2180 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2240 = new BitSet(new long[]{0x0000040400000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr2247 = new BitSet(new long[]{0x0080008400000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2267 = new BitSet(new long[]{0x0000001000040002L});
	public static final BitSet FOLLOW_multoper_in_multexpr2273 = new BitSet(new long[]{0x0080008400000000L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_word2294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word2300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_listterm2410 = new BitSet(new long[]{0x008C008400082000L});
	public static final BitSet FOLLOW_term_in_listterm2415 = new BitSet(new long[]{0x0004000000000840L});
	public static final BitSet FOLLOW_COMMA_in_listterm2423 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_listterm2427 = new BitSet(new long[]{0x0004000000000840L});
	public static final BitSet FOLLOW_BAR_in_listterm2437 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_VAR_in_listterm2441 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_listterm2450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper2465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper2471 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper2490 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper2496 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2513 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQUALS_in_eqoper2519 = new BitSet(new long[]{0x0000000000000002L});
}
