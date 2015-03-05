// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2015-03-03 14:51:19

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:1: program returns [Abstract_MAS mas] : MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gm] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gme] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? CURLYCLOSE ;
	public final Abstract_MAS program() throws RecognitionException {
		Abstract_MAS mas = null;


		String i =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:36: ( MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gm] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gme] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:39: MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gm] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gme] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? CURLYCLOSE
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

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:41: ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==GOALS) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:42: GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE
					{
					match(input,GOALS,FOLLOW_GOALS_in_program233); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program235); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:58: ( poslitconj[gl] )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==CONST||LA3_0==VAR) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:58: poslitconj[gl]
							{
							pushFollow(FOLLOW_poslitconj_in_program237);
							poslitconj(gl);
							state._fsp--;

							}
							break;

						default :
							break loop3;
						}
					}

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program241); 
					}
					break;

			}

			match(input,MAIN,FOLLOW_MAIN_in_program286); 
			match(input,MODULE,FOLLOW_MODULE_in_program288); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program290); 
			 Abstract_GOALModule gm = new Abstract_GOALModule(Abstract_GOALModule.main); gl.addModule(gm);
			pushFollow(FOLLOW_module_in_program294);
			module(gm);
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program297); 
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
					match(input,EVENT,FOLLOW_EVENT_in_program341); 
					match(input,MODULE,FOLLOW_MODULE_in_program343); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program345); 
					 Abstract_GOALModule gme = new Abstract_GOALModule(Abstract_GOALModule.event); gl.addModule(gme);
					pushFollow(FOLLOW_module_in_program349);
					module(gme);
					state._fsp--;

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program352); 
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
					match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_program398); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program400); 
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
							pushFollow(FOLLOW_actionspec_in_program402);
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

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program406); 
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program498); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:1: module[Abstract_GOALModule gl] : ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule[gl] )+ CURLYCLOSE ;
	public final void module(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:33: ( ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule[gl] )+ CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:35: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule[gl] )+ CURLYCLOSE
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
					match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_module592); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module594); 
					pushFollow(FOLLOW_krspec_in_module596);
					krspec(gl);
					state._fsp--;

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module599); 
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:30: ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==GOALS) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:31: GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE
					{
					match(input,GOALS,FOLLOW_GOALS_in_module633); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module635); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:47: ( poslitconj[gl] )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==CONST||LA9_0==VAR) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:47: poslitconj[gl]
							{
							pushFollow(FOLLOW_poslitconj_in_module637);
							poslitconj(gl);
							state._fsp--;

							}
							break;

						default :
							break loop9;
						}
					}

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module641); 
					}
					break;

			}

			match(input,PROGRAM,FOLLOW_PROGRAM_in_module674); 
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
					pushFollow(FOLLOW_optionorder_in_module677);
					optionorder();
					state._fsp--;

					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module681); 
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
					pushFollow(FOLLOW_macro_in_module716);
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
					pushFollow(FOLLOW_actionrule_in_module752);
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

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module785); 
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
		Abstract_Predicate hd =null;
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
				if ( (LA15_0==CONST||LA15_0==VAR) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:32: hd= atom ( STOP | PROLOGARROW body= litconj STOP )
					{
					pushFollow(FOLLOW_atom_in_krspec833);
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
							match(input,STOP,FOLLOW_STOP_in_krspec837); 
							gl.addFact(hd);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:2: PROLOGARROW body= litconj STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_krspec845); 
							pushFollow(FOLLOW_litconj_in_krspec849);
							body=litconj();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_krspec851); 
							gl.addKRule(new Abstract_Rule(hd, body));
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
		Abstract_Predicate hd =null;
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
				if ( (LA17_0==CONST||LA17_0==VAR) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:34: hd= atom ( STOP | PROLOGARROW body= litconj STOP )
					{
					pushFollow(FOLLOW_atom_in_brspec872);
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
							match(input,STOP,FOLLOW_STOP_in_brspec877); 
							gl.addBel(hd);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:2: PROLOGARROW body= litconj STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_brspec885); 
							pushFollow(FOLLOW_litconj_in_brspec889);
							body=litconj();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_brspec891); 
							gl.addRule(new Abstract_Rule(hd, body));
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:1: poslitconj[Abstract_KRGOALS gl] : g= atom ( COMMA g1= atom )* STOP ;
	public final void poslitconj(Abstract_KRGOALS gl) throws RecognitionException {
		Abstract_Predicate g =null;
		Abstract_Predicate g1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:33: (g= atom ( COMMA g1= atom )* STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:35: g= atom ( COMMA g1= atom )* STOP
			{
			pushFollow(FOLLOW_atom_in_poslitconj944);
			g=atom();
			state._fsp--;

			gl.addGoal(g);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:60: ( COMMA g1= atom )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==COMMA) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:61: COMMA g1= atom
					{
					match(input,COMMA,FOLLOW_COMMA_in_poslitconj949); 
					pushFollow(FOLLOW_atom_in_poslitconj953);
					g1=atom();
					state._fsp--;

					gl.addGoal(g1);
					}
					break;

				default :
					break loop18;
				}
			}

			match(input,STOP,FOLLOW_STOP_in_poslitconj958); 
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
	// $ANTLR end "poslitconj"



	// $ANTLR start "litconj"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:1: litconj returns [Abstract_LogicalFormula f] : l= literal ( COMMA l1= literal )* ;
	public final Abstract_LogicalFormula litconj() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula l =null;
		Abstract_LogicalFormula l1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:44: (l= literal ( COMMA l1= literal )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:46: l= literal ( COMMA l1= literal )*
			{
			pushFollow(FOLLOW_literal_in_litconj971);
			l=literal();
			state._fsp--;

			f = l;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:66: ( COMMA l1= literal )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==COMMA) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:67: COMMA l1= literal
					{
					match(input,COMMA,FOLLOW_COMMA_in_litconj976); 
					pushFollow(FOLLOW_literal_in_litconj980);
					l1=literal();
					state._fsp--;

					f = new Abstract_LogExpr(l, Abstract_LogExpr.and, l1);
					}
					break;

				default :
					break loop19;
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
	// $ANTLR end "litconj"



	// $ANTLR start "literal"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:1: literal returns [Abstract_LogicalFormula l] : (a= atom | ( NOT OPEN a1= atom CLOSE ) );
	public final Abstract_LogicalFormula literal() throws RecognitionException {
		Abstract_LogicalFormula l = null;


		Abstract_Predicate a =null;
		Abstract_Predicate a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:44: (a= atom | ( NOT OPEN a1= atom CLOSE ) )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==CONST||LA20_0==VAR) ) {
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:46: a= atom
					{
					pushFollow(FOLLOW_atom_in_literal998);
					a=atom();
					state._fsp--;

					l=a;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:62: ( NOT OPEN a1= atom CLOSE )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:62: ( NOT OPEN a1= atom CLOSE )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:63: NOT OPEN a1= atom CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_literal1005); 
					match(input,OPEN,FOLLOW_OPEN_in_literal1007); 
					pushFollow(FOLLOW_atom_in_literal1011);
					a1=atom();
					state._fsp--;

					l=new Abstract_LogExpr(Abstract_LogExpr.not, a1);
					match(input,CLOSE,FOLLOW_CLOSE_in_literal1015); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:1: atom returns [Abstract_Predicate t] : s= id (tl= parameters ) ;
	public final Abstract_Predicate atom() throws RecognitionException {
		Abstract_Predicate t = null;


		String s =null;
		Abstract_Term[] tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:37: (s= id (tl= parameters ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:39: s= id (tl= parameters )
			{
			pushFollow(FOLLOW_id_in_atom1030);
			s=id();
			state._fsp--;

			Abstract_Predicate p =new Abstract_Predicate(s);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:94: (tl= parameters )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:96: tl= parameters
			{
			pushFollow(FOLLOW_parameters_in_atom1037);
			tl=parameters();
			state._fsp--;

			p.setTerms(tl); t = p;
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
	// $ANTLR end "atom"



	// $ANTLR start "parameters"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:1: parameters returns [Abstract_Term[] ts] : OPEN t= term ( COMMA t1= term )* CLOSE ;
	public final Abstract_Term[] parameters() throws RecognitionException {
		Abstract_Term[] ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:42: ( OPEN t= term ( COMMA t1= term )* CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:44: OPEN t= term ( COMMA t1= term )* CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_parameters1053); 
			pushFollow(FOLLOW_term_in_parameters1057);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:92:2: ( COMMA t1= term )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==COMMA) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:92:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_parameters1064); 
					pushFollow(FOLLOW_term_in_parameters1068);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop21;
				}
			}

			match(input,CLOSE,FOLLOW_CLOSE_in_parameters1074); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:1: optionorder : SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE ;
	public final void optionorder() throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:13: ( SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:15: SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE
			{
			match(input,SQOPEN,FOLLOW_SQOPEN_in_optionorder1085); 
			match(input,ORDER,FOLLOW_ORDER_in_optionorder1087); 
			match(input,EQUALS,FOLLOW_EQUALS_in_optionorder1089); 
			if ( (input.LA(1) >= LINEAR && input.LA(1) <= LINEARALL)||(input.LA(1) >= RANDOM && input.LA(1) <= RANDOMALL) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_optionorder1109); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:96:1: macro : HASH DEFINE f= id pl= parameters msc= mentalstatecond STOP ;
	public final void macro() throws RecognitionException {
		String f =null;
		Abstract_Term[] pl =null;
		Abstract_MentalState msc =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:96:7: ( HASH DEFINE f= id pl= parameters msc= mentalstatecond STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:96:9: HASH DEFINE f= id pl= parameters msc= mentalstatecond STOP
			{
			match(input,HASH,FOLLOW_HASH_in_macro1117); 
			match(input,DEFINE,FOLLOW_DEFINE_in_macro1119); 
			pushFollow(FOLLOW_id_in_macro1123);
			f=id();
			state._fsp--;

			pushFollow(FOLLOW_parameters_in_macro1127);
			pl=parameters();
			state._fsp--;

			pushFollow(FOLLOW_mentalstatecond_in_macro1131);
			msc=mentalstatecond();
			state._fsp--;

			PredicateIndicator pi = new PredicateIndicator(f, pl.length); macros.put(pi, msc); 
			                                  Abstract_Predicate p = new Abstract_Predicate(f); p.setTerms(pl); macro_subs.put(pi, p);
			match(input,STOP,FOLLOW_STOP_in_macro1135); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:1: actionrule[Abstract_GOALModule gl] : IF (lf= mentalstatecond |f= id pl= parameters ) THEN dl= actioncombo[gl] STOP ;
	public final void actionrule(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_MentalState lf =null;
		String f =null;
		Abstract_Term[] pl =null;
		ArrayList<Abstract_Deed> dl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:39: ( IF (lf= mentalstatecond |f= id pl= parameters ) THEN dl= actioncombo[gl] STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:41: IF (lf= mentalstatecond |f= id pl= parameters ) THEN dl= actioncombo[gl] STOP
			{
			Abstract_ActionRule rule = new Abstract_ActionRule();
			match(input,IF,FOLLOW_IF_in_actionrule1151); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:100:5: (lf= mentalstatecond |f= id pl= parameters )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==BEL||LA22_0==GOAL||LA22_0==NOT||LA22_0==TRUE) ) {
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:100:6: lf= mentalstatecond
					{
					pushFollow(FOLLOW_mentalstatecond_in_actionrule1156);
					lf=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(lf);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:101:4: f= id pl= parameters
					{
					pushFollow(FOLLOW_id_in_actionrule1166);
					f=id();
					state._fsp--;

					pushFollow(FOLLOW_parameters_in_actionrule1170);
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

			match(input,THEN,FOLLOW_THEN_in_actionrule1178); 
			pushFollow(FOLLOW_actioncombo_in_actionrule1182);
			dl=actioncombo(gl);
			state._fsp--;

			rule.setBody(dl);
			match(input,STOP,FOLLOW_STOP_in_actionrule1187); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:1: mentalstatecond returns [Abstract_MentalState lf] : ml= mentalliteral ( COMMA ml2= mentalliteral )* ;
	public final Abstract_MentalState mentalstatecond() throws RecognitionException {
		Abstract_MentalState lf = null;


		Abstract_GLogicalFormula ml =null;
		Abstract_GLogicalFormula ml2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:109:2: (ml= mentalliteral ( COMMA ml2= mentalliteral )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:109:4: ml= mentalliteral ( COMMA ml2= mentalliteral )*
			{
			pushFollow(FOLLOW_mentalliteral_in_mentalstatecond1205);
			ml=mentalliteral();
			state._fsp--;

			Abstract_MentalState ms = new Abstract_MentalState(ml);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:109:79: ( COMMA ml2= mentalliteral )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==COMMA) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:109:80: COMMA ml2= mentalliteral
					{
					match(input,COMMA,FOLLOW_COMMA_in_mentalstatecond1210); 
					pushFollow(FOLLOW_mentalliteral_in_mentalstatecond1214);
					ml2=mentalliteral();
					state._fsp--;

					ms = new Abstract_MentalState(ms, Abstract_Guard.and, ml2); lf = ms;
					}
					break;

				default :
					break loop23;
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
		return lf;
	}
	// $ANTLR end "mentalstatecond"



	// $ANTLR start "mentalliteral"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:1: mentalliteral returns [Abstract_GLogicalFormula lf] : ( TRUE |ma= mentalatom | NOT OPEN nma= mentalatom CLOSE );
	public final Abstract_GLogicalFormula mentalliteral() throws RecognitionException {
		Abstract_GLogicalFormula lf = null;


		Abstract_GLogicalFormula ma =null;
		Abstract_GLogicalFormula nma =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:112:2: ( TRUE |ma= mentalatom | NOT OPEN nma= mentalatom CLOSE )
			int alt24=3;
			switch ( input.LA(1) ) {
			case TRUE:
				{
				alt24=1;
				}
				break;
			case BEL:
			case GOAL:
				{
				alt24=2;
				}
				break;
			case NOT:
				{
				alt24=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}
			switch (alt24) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:112:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_mentalliteral1233); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:112:11: ma= mentalatom
					{
					pushFollow(FOLLOW_mentalatom_in_mentalliteral1239);
					ma=mentalatom();
					state._fsp--;

					lf = ma;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:112:39: NOT OPEN nma= mentalatom CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_mentalliteral1245); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalliteral1247); 
					pushFollow(FOLLOW_mentalatom_in_mentalliteral1251);
					nma=mentalatom();
					state._fsp--;

					lf = new Abstract_Guard(Abstract_Guard.not, nma);
					match(input,CLOSE,FOLLOW_CLOSE_in_mentalliteral1255); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:114:1: mentalatom returns [Abstract_GLogicalFormula lf] : ( BEL OPEN b= litconj CLOSE | GOAL OPEN g= litconj CLOSE );
	public final Abstract_GLogicalFormula mentalatom() throws RecognitionException {
		Abstract_GLogicalFormula lf = null;


		Abstract_LogicalFormula b =null;
		Abstract_LogicalFormula g =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:115:2: ( BEL OPEN b= litconj CLOSE | GOAL OPEN g= litconj CLOSE )
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==BEL) ) {
				alt25=1;
			}
			else if ( (LA25_0==GOAL) ) {
				alt25=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}

			switch (alt25) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:115:4: BEL OPEN b= litconj CLOSE
					{
					match(input,BEL,FOLLOW_BEL_in_mentalatom1269); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalatom1271); 
					pushFollow(FOLLOW_litconj_in_mentalatom1275);
					b=litconj();
					state._fsp--;

					lf = new Abstract_MentalAtom(b, DefaultAILStructure.AILBel);
					match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1280); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:115:96: GOAL OPEN g= litconj CLOSE
					{
					match(input,GOAL,FOLLOW_GOAL_in_mentalatom1284); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalatom1286); 
					pushFollow(FOLLOW_litconj_in_mentalatom1290);
					g=litconj();
					state._fsp--;

					lf = new Abstract_MentalAtom(g, DefaultAILStructure.AILGoal);
					match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1293); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:118:1: actionspec[Abstract_GOALAgent gl] : a= action[gl] CURLYOPEN PRE CURLYOPEN lf1= litconj CURLYCLOSE POST CURLYOPEN lf2= litconj CURLYCLOSE CURLYCLOSE ;
	public final void actionspec(Abstract_GOALAgent gl) throws RecognitionException {
		Abstract_Deed a =null;
		Abstract_LogicalFormula lf1 =null;
		Abstract_LogicalFormula lf2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:118:34: (a= action[gl] CURLYOPEN PRE CURLYOPEN lf1= litconj CURLYCLOSE POST CURLYOPEN lf2= litconj CURLYCLOSE CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:118:36: a= action[gl] CURLYOPEN PRE CURLYOPEN lf1= litconj CURLYCLOSE POST CURLYOPEN lf2= litconj CURLYCLOSE CURLYCLOSE
			{
			pushFollow(FOLLOW_action_in_actionspec1305);
			a=action(gl);
			state._fsp--;

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1310); 
			match(input,PRE,FOLLOW_PRE_in_actionspec1312); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1314); 
			pushFollow(FOLLOW_litconj_in_actionspec1318);
			lf1=litconj();
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1320); 
			Abstract_MentalAtom pres = new Abstract_MentalAtom(lf1, DefaultAILStructure.AILBel);
			match(input,POST,FOLLOW_POST_in_actionspec1325); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1327); 
			pushFollow(FOLLOW_litconj_in_actionspec1331);
			lf2=litconj();
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1333); 
			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1335); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:122:1: actioncombo[Abstract_GOALModule gl] returns [ArrayList<Abstract_Deed> dl] :a= action[gl] ( PLUS a1= action[gl] )* ;
	public final ArrayList<Abstract_Deed> actioncombo(Abstract_GOALModule gl) throws RecognitionException {
		ArrayList<Abstract_Deed> dl = null;


		Abstract_Deed a =null;
		Abstract_Deed a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:2: (a= action[gl] ( PLUS a1= action[gl] )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:4: a= action[gl] ( PLUS a1= action[gl] )*
			{
			dl = new ArrayList<Abstract_Deed>();
			pushFollow(FOLLOW_action_in_actioncombo1355);
			a=action(gl);
			state._fsp--;

			dl.add(a);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:71: ( PLUS a1= action[gl] )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==PLUS) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:72: PLUS a1= action[gl]
					{
					match(input,PLUS,FOLLOW_PLUS_in_actioncombo1361); 
					pushFollow(FOLLOW_action_in_actioncombo1365);
					a1=action(gl);
					state._fsp--;

					dl.add(a1);
					}
					break;

				default :
					break loop26;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:1: action[Abstract_KRGOALS gl] returns [Abstract_Deed d] : (deed= userdefaction | builtinaction | communication[gl] ) ;
	public final Abstract_Deed action(Abstract_KRGOALS gl) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Deed deed =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:55: ( (deed= userdefaction | builtinaction | communication[gl] ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:57: (deed= userdefaction | builtinaction | communication[gl] )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:57: (deed= userdefaction | builtinaction | communication[gl] )
			int alt27=3;
			switch ( input.LA(1) ) {
			case CONST:
			case VAR:
				{
				alt27=1;
				}
				break;
			case ADOPT:
			case DELETE:
			case DROP:
			case INSERT:
				{
				alt27=2;
				}
				break;
			case SEND:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:58: deed= userdefaction
					{
					pushFollow(FOLLOW_userdefaction_in_action1387);
					deed=userdefaction();
					state._fsp--;

					d =deed;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:89: builtinaction
					{
					pushFollow(FOLLOW_builtinaction_in_action1392);
					builtinaction();
					state._fsp--;

					d = new Abstract_Deed(Abstract_Deed.DNull);
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:152: communication[gl]
					{
					pushFollow(FOLLOW_communication_in_action1398);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:1: userdefaction returns [Abstract_Deed d] : f= id (pl= parameters )+ ;
	public final Abstract_Deed userdefaction() throws RecognitionException {
		Abstract_Deed d = null;


		String f =null;
		Abstract_Term[] pl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:2: (f= id (pl= parameters )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:4: f= id (pl= parameters )+
			{
			pushFollow(FOLLOW_id_in_userdefaction1418);
			f=id();
			state._fsp--;

			Abstract_Predicate p = new Abstract_Predicate(f);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:61: (pl= parameters )+
			int cnt28=0;
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==OPEN) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:62: pl= parameters
					{
					pushFollow(FOLLOW_parameters_in_userdefaction1425);
					pl=parameters();
					state._fsp--;

					p.setTerms(pl);
					}
					break;

				default :
					if ( cnt28 >= 1 ) break loop28;
					EarlyExitException eee = new EarlyExitException(28, input);
					throw eee;
				}
				cnt28++;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:1: builtinaction : ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN litconj CLOSE | DROP OPEN litconj CLOSE );
	public final void builtinaction() throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:131:2: ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN litconj CLOSE | DROP OPEN litconj CLOSE )
			int alt29=4;
			switch ( input.LA(1) ) {
			case INSERT:
				{
				alt29=1;
				}
				break;
			case DELETE:
				{
				alt29=2;
				}
				break;
			case ADOPT:
				{
				alt29=3;
				}
				break;
			case DROP:
				{
				alt29=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}
			switch (alt29) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:131:4: INSERT OPEN litconj CLOSE
					{
					match(input,INSERT,FOLLOW_INSERT_in_builtinaction1442); 
					match(input,OPEN,FOLLOW_OPEN_in_builtinaction1444); 
					pushFollow(FOLLOW_litconj_in_builtinaction1446);
					litconj();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1448); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:132:3: DELETE OPEN litconj CLOSE
					{
					match(input,DELETE,FOLLOW_DELETE_in_builtinaction1454); 
					match(input,OPEN,FOLLOW_OPEN_in_builtinaction1456); 
					pushFollow(FOLLOW_litconj_in_builtinaction1458);
					litconj();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1460); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:4: ADOPT OPEN litconj CLOSE
					{
					match(input,ADOPT,FOLLOW_ADOPT_in_builtinaction1467); 
					match(input,OPEN,FOLLOW_OPEN_in_builtinaction1469); 
					pushFollow(FOLLOW_litconj_in_builtinaction1471);
					litconj();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1473); 
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:134:4: DROP OPEN litconj CLOSE
					{
					match(input,DROP,FOLLOW_DROP_in_builtinaction1480); 
					match(input,OPEN,FOLLOW_OPEN_in_builtinaction1482); 
					pushFollow(FOLLOW_litconj_in_builtinaction1484);
					litconj();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1486); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:136:1: communication[Abstract_KRGOALS gl] returns [Abstract_Deed d] : SEND OPEN id COMMA poslitconj[gl] CLOSE ;
	public final Abstract_Deed communication(Abstract_KRGOALS gl) throws RecognitionException {
		Abstract_Deed d = null;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:137:2: ( SEND OPEN id COMMA poslitconj[gl] CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:137:4: SEND OPEN id COMMA poslitconj[gl] CLOSE
			{
			match(input,SEND,FOLLOW_SEND_in_communication1503); 
			match(input,OPEN,FOLLOW_OPEN_in_communication1505); 
			pushFollow(FOLLOW_id_in_communication1507);
			id();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_communication1509); 
			pushFollow(FOLLOW_poslitconj_in_communication1511);
			poslitconj(gl);
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_communication1514); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:139:1: id returns [String s] : ( CONST | VAR ) ;
	public final String id() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:139:23: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:139:25: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:139:25: ( CONST | VAR )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==CONST) ) {
				alt30=1;
			}
			else if ( (LA30_0==VAR) ) {
				alt30=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:139:26: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_id1568); 
					s = CONST1.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:139:58: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_id1573); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:178:2: equation returns [Abstract_Equation e] : a1= arithexpr i= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation e = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:179:3: (a1= arithexpr i= eqoper a2= arithexpr )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:179:5: a1= arithexpr i= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation1895);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation1899);
			i=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation1903);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:2: term returns [Abstract_Term t] : (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) ;
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_StringTerm st =null;
		Abstract_Term ft =null;
		Abstract_NumberTerm at =null;
		Abstract_ListTermImpl lt =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:33: ( (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:35: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:35: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			int alt31=4;
			switch ( input.LA(1) ) {
			case DOUBLEQUOTE:
				{
				alt31=1;
				}
				break;
			case CONST:
				{
				alt31=2;
				}
				break;
			case MINUS:
			case NUMBER:
			case VAR:
				{
				alt31=3;
				}
				break;
			case SQOPEN:
				{
				alt31=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}
			switch (alt31) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:36: st= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term1920);
					st=stringterm();
					state._fsp--;

					t = st;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:63: ft= function_term
					{
					pushFollow(FOLLOW_function_term_in_term1928);
					ft=function_term();
					state._fsp--;

					t =ft;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:91: at= arithexpr
					{
					pushFollow(FOLLOW_arithexpr_in_term1936);
					at=arithexpr();
					state._fsp--;

					t =at;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:114: lt= listterm
					{
					pushFollow(FOLLOW_listterm_in_term1943);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:181:2: function_term returns [Abstract_Term t] : c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? ;
	public final Abstract_Term function_term() throws RecognitionException {
		Abstract_Term t = null;


		Token c=null;
		Abstract_Term t1 =null;
		Abstract_Term t2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:3: (c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:5: c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			{
			c=(Token)match(input,CONST,FOLLOW_CONST_in_function_term1963); 
			t=new Abstract_Predicate(c.getText());
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:54: ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==OPEN) ) {
				alt33=1;
			}
			switch (alt33) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:55: OPEN t1= term ( COMMA t2= term )* CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function_term1968); 
					pushFollow(FOLLOW_term_in_function_term1972);
					t1=term();
					state._fsp--;

					((Abstract_Predicate) t).addTerm(t1);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:111: ( COMMA t2= term )*
					loop32:
					while (true) {
						int alt32=2;
						int LA32_0 = input.LA(1);
						if ( (LA32_0==COMMA) ) {
							alt32=1;
						}

						switch (alt32) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:112: COMMA t2= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_function_term1977); 
							pushFollow(FOLLOW_term_in_function_term1981);
							t2=term();
							state._fsp--;

							((Abstract_Predicate) t).addTerm(t2);
							}
							break;

						default :
							break loop32;
						}
					}

					match(input,CLOSE,FOLLOW_CLOSE_in_function_term1987); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:183:2: atom_term returns [Abstract_NumberTerm t] : (n= numberstring |v= var ) ;
	public final Abstract_NumberTerm atom_term() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:183:44: ( (n= numberstring |v= var ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:183:46: (n= numberstring |v= var )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:183:46: (n= numberstring |v= var )
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==MINUS||LA34_0==NUMBER) ) {
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:183:47: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom_term2006);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:183:108: v= var
					{
					pushFollow(FOLLOW_var_in_atom_term2014);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:184:2: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE w= word DOUBLEQUOTE ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		String w =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:3: ( DOUBLEQUOTE w= word DOUBLEQUOTE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:5: DOUBLEQUOTE w= word DOUBLEQUOTE
			{
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2031); 
			pushFollow(FOLLOW_word_in_stringterm2035);
			w=word();
			state._fsp--;

			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2037); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:186:2: var returns [Abstract_VarTerm v] : VAR ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR3=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:186:35: ( VAR )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:186:37: VAR
			{
			VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_var2051); 

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:195:2: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:3: ( ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:5: ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? )
			{
			s = "";
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:16: ( MINUS )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==MINUS) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:17: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring2071); 
					s += "-";
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:38: (n1= NUMBER ( STOP n2= NUMBER )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:39: n1= NUMBER ( STOP n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2080); 
			s += n1.getText();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:37: ( STOP n2= NUMBER )?
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==STOP) ) {
				alt36=1;
			}
			switch (alt36) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:38: STOP n2= NUMBER
					{
					match(input,STOP,FOLLOW_STOP_in_numberstring2121); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2127); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:1: arithexpr returns [Abstract_NumberTerm ae] : a1= multexpr (i= addoper a2= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:3: (a1= multexpr (i= addoper a2= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:6: a1= multexpr (i= addoper a2= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr2181);
			a1=multexpr();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:30: (i= addoper a2= multexpr )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==MINUS||LA37_0==PLUS) ) {
				alt37=1;
			}
			switch (alt37) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:31: i= addoper a2= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr2188);
					i=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr2192);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:1: multexpr returns [Abstract_NumberTerm ae] : a1= atom_term (i= multoper a2= atom_term )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:42: (a1= atom_term (i= multoper a2= atom_term )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:44: a1= atom_term (i= multoper a2= atom_term )?
			{
			pushFollow(FOLLOW_atom_term_in_multexpr2208);
			a1=atom_term();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:68: (i= multoper a2= atom_term )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==DIV||LA38_0==MULT) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:69: i= multoper a2= atom_term
					{
					pushFollow(FOLLOW_multoper_in_multexpr2214);
					i=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_term_in_multexpr2218);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST4=null;
		Token VAR5=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:25: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:27: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:27: ( CONST | VAR )
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==CONST) ) {
				alt39=1;
			}
			else if ( (LA39_0==VAR) ) {
				alt39=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}

			switch (alt39) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:28: CONST
					{
					CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_word2235); 
					s =CONST4.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:59: VAR
					{
					VAR5=(Token)match(input,VAR,FOLLOW_VAR_in_word2241); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:2: listterm returns [Abstract_ListTermImpl l] : SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE ;
	public final Abstract_ListTermImpl listterm() throws RecognitionException {
		Abstract_ListTermImpl l = null;


		Token v=null;
		Abstract_Term h =null;
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:3: ( SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:5: SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE
			{
			l = new Abstract_ListTermImpl(); Abstract_ListTerm lrunning = l;
			match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2351); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:10: (h= term ( COMMA t= term )* ( BAR v= VAR )? )?
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==CONST||LA42_0==DOUBLEQUOTE||LA42_0==MINUS||LA42_0==NUMBER||LA42_0==SQOPEN||LA42_0==VAR) ) {
				alt42=1;
			}
			switch (alt42) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:11: h= term ( COMMA t= term )* ( BAR v= VAR )?
					{
					pushFollow(FOLLOW_term_in_listterm2356);
					h=term();
					state._fsp--;

					l.addHead(h); l.addTail(new Abstract_ListTermImpl());
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:209:3: ( COMMA t= term )*
					loop40:
					while (true) {
						int alt40=2;
						int LA40_0 = input.LA(1);
						if ( (LA40_0==COMMA) ) {
							alt40=1;
						}

						switch (alt40) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:209:4: COMMA t= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_listterm2364); 
							pushFollow(FOLLOW_term_in_listterm2368);
							t=term();
							state._fsp--;

							Abstract_ListTerm l2 = new Abstract_ListTermImpl();  l2.addHead(t); l2.addTail(new Abstract_ListTermImpl()); lrunning.addTail(l2); lrunning=l2;
							}
							break;

						default :
							break loop40;
						}
					}

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:3: ( BAR v= VAR )?
					int alt41=2;
					int LA41_0 = input.LA(1);
					if ( (LA41_0==BAR) ) {
						alt41=1;
					}
					switch (alt41) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:4: BAR v= VAR
							{
							match(input,BAR,FOLLOW_BAR_in_listterm2378); 
							v=(Token)match(input,VAR,FOLLOW_VAR_in_listterm2382); 
							lrunning.addTail(new Abstract_VarTerm(v.getText()));
							}
							break;

					}

					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2391); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:212:2: addoper returns [int i] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:212:25: ( ( PLUS | MINUS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:212:27: ( PLUS | MINUS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:212:27: ( PLUS | MINUS )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:212:28: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper2406); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:212:45: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper2412); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:213:2: multoper returns [int i] : ( MULT | DIV ) ;
	public final int multoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:214:3: ( ( MULT | DIV ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:214:5: ( MULT | DIV )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:214:5: ( MULT | DIV )
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==MULT) ) {
				alt44=1;
			}
			else if ( (LA44_0==DIV) ) {
				alt44=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}

			switch (alt44) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:214:6: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper2431); 
					i = 3;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:214:23: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper2437); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:2: eqoper returns [int i] : ( LESS | EQUALS ) ;
	public final int eqoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:25: ( ( LESS | EQUALS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:27: ( LESS | EQUALS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:27: ( LESS | EQUALS )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==LESS) ) {
				alt45=1;
			}
			else if ( (LA45_0==EQUALS) ) {
				alt45=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}

			switch (alt45) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:28: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2454); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:45: EQUALS
					{
					match(input,EQUALS,FOLLOW_EQUALS_in_eqoper2460); 
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
	public static final BitSet FOLLOW_CURLYOPEN_in_program131 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_krspec_in_program133 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program136 = new BitSet(new long[]{0x0000000201000100L});
	public static final BitSet FOLLOW_BELIEFS_in_program181 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program183 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_brspec_in_program185 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program188 = new BitSet(new long[]{0x0000000201000000L});
	public static final BitSet FOLLOW_GOALS_in_program233 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program235 = new BitSet(new long[]{0x0080000000006000L});
	public static final BitSet FOLLOW_poslitconj_in_program237 = new BitSet(new long[]{0x0080000000006000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program241 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_MAIN_in_program286 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_MODULE_in_program288 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program290 = new BitSet(new long[]{0x0000200011000000L});
	public static final BitSet FOLLOW_module_in_program294 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program297 = new BitSet(new long[]{0x0000000000404010L});
	public static final BitSet FOLLOW_EVENT_in_program341 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_MODULE_in_program343 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program345 = new BitSet(new long[]{0x0000200011000000L});
	public static final BitSet FOLLOW_module_in_program349 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program352 = new BitSet(new long[]{0x0000000000004010L});
	public static final BitSet FOLLOW_ACTIONSPEC_in_program398 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program400 = new BitSet(new long[]{0x0082000008122020L});
	public static final BitSet FOLLOW_actionspec_in_program402 = new BitSet(new long[]{0x0082000008126020L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program406 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KNOWLEDGE_in_module592 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module594 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_krspec_in_module596 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module599 = new BitSet(new long[]{0x0000200001000000L});
	public static final BitSet FOLLOW_GOALS_in_module633 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module635 = new BitSet(new long[]{0x0080000000006000L});
	public static final BitSet FOLLOW_poslitconj_in_module637 = new BitSet(new long[]{0x0080000000006000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module641 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_PROGRAM_in_module674 = new BitSet(new long[]{0x0008000000008000L});
	public static final BitSet FOLLOW_optionorder_in_module677 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module681 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_macro_in_module716 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_actionrule_in_module752 = new BitSet(new long[]{0x0000000004004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module785 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_krspec833 = new BitSet(new long[]{0x0010400000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec837 = new BitSet(new long[]{0x0080000000002002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_krspec845 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_krspec849 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec851 = new BitSet(new long[]{0x0080000000002002L});
	public static final BitSet FOLLOW_atom_in_brspec872 = new BitSet(new long[]{0x0010400000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec877 = new BitSet(new long[]{0x0080000000002002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_brspec885 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_brspec889 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec891 = new BitSet(new long[]{0x0080000000002002L});
	public static final BitSet FOLLOW_atom_in_poslitconj944 = new BitSet(new long[]{0x0010000000000800L});
	public static final BitSet FOLLOW_COMMA_in_poslitconj949 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_atom_in_poslitconj953 = new BitSet(new long[]{0x0010000000000800L});
	public static final BitSet FOLLOW_STOP_in_poslitconj958 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_litconj971 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_litconj976 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_literal_in_litconj980 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_atom_in_literal998 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_literal1005 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_literal1007 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_atom_in_literal1011 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_literal1015 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_atom1030 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_parameters_in_atom1037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_parameters1053 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_parameters1057 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_COMMA_in_parameters1064 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_parameters1068 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_CLOSE_in_parameters1074 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_optionorder1085 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_ORDER_in_optionorder1087 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_EQUALS_in_optionorder1089 = new BitSet(new long[]{0x00018000C0000000L});
	public static final BitSet FOLLOW_set_in_optionorder1091 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_optionorder1109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HASH_in_macro1117 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DEFINE_in_macro1119 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_id_in_macro1123 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_parameters_in_macro1127 = new BitSet(new long[]{0x0040004000800080L});
	public static final BitSet FOLLOW_mentalstatecond_in_macro1131 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STOP_in_macro1135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_actionrule1151 = new BitSet(new long[]{0x00C0004000802080L});
	public static final BitSet FOLLOW_mentalstatecond_in_actionrule1156 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_id_in_actionrule1166 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_parameters_in_actionrule1170 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_THEN_in_actionrule1178 = new BitSet(new long[]{0x0082000008122020L});
	public static final BitSet FOLLOW_actioncombo_in_actionrule1182 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STOP_in_actionrule1187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond1205 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_mentalstatecond1210 = new BitSet(new long[]{0x0040004000800080L});
	public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond1214 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_TRUE_in_mentalliteral1233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mentalatom_in_mentalliteral1239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_mentalliteral1245 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalliteral1247 = new BitSet(new long[]{0x0000000000800080L});
	public static final BitSet FOLLOW_mentalatom_in_mentalliteral1251 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_mentalliteral1255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEL_in_mentalatom1269 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalatom1271 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_mentalatom1275 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_mentalatom1280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_mentalatom1284 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalatom1286 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_mentalatom1290 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_mentalatom1293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actionspec1305 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1310 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_PRE_in_actionspec1312 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1314 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_actionspec1318 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1320 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_POST_in_actionspec1325 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1327 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_actionspec1331 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1333 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actioncombo1355 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_PLUS_in_actioncombo1361 = new BitSet(new long[]{0x0082000008122020L});
	public static final BitSet FOLLOW_action_in_actioncombo1365 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_userdefaction_in_action1387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_builtinaction_in_action1392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_communication_in_action1398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_userdefaction1418 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_parameters_in_userdefaction1425 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_INSERT_in_builtinaction1442 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_builtinaction1444 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_builtinaction1446 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_builtinaction1448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DELETE_in_builtinaction1454 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_builtinaction1456 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_builtinaction1458 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_builtinaction1460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADOPT_in_builtinaction1467 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_builtinaction1469 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_builtinaction1471 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_builtinaction1473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_builtinaction1480 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_builtinaction1482 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_builtinaction1484 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_builtinaction1486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEND_in_communication1503 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_communication1505 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_id_in_communication1507 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_communication1509 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_poslitconj_in_communication1511 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_communication1514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_id1568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_id1573 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation1895 = new BitSet(new long[]{0x0000000020200000L});
	public static final BitSet FOLLOW_eqoper_in_equation1899 = new BitSet(new long[]{0x0080008400000000L});
	public static final BitSet FOLLOW_arithexpr_in_equation1903 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_term1920 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_term1928 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_term1936 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_term1943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function_term1963 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_OPEN_in_function_term1968 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_function_term1972 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_COMMA_in_function_term1977 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_function_term1981 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_CLOSE_in_function_term1987 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom_term2006 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom_term2014 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2031 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_word_in_stringterm2035 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var2051 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring2071 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2080 = new BitSet(new long[]{0x0010000000000002L});
	public static final BitSet FOLLOW_STOP_in_numberstring2121 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2181 = new BitSet(new long[]{0x0000040400000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr2188 = new BitSet(new long[]{0x0080008400000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2192 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2208 = new BitSet(new long[]{0x0000001000040002L});
	public static final BitSet FOLLOW_multoper_in_multexpr2214 = new BitSet(new long[]{0x0080008400000000L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_word2235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word2241 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_listterm2351 = new BitSet(new long[]{0x008C008400082000L});
	public static final BitSet FOLLOW_term_in_listterm2356 = new BitSet(new long[]{0x0004000000000840L});
	public static final BitSet FOLLOW_COMMA_in_listterm2364 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_listterm2368 = new BitSet(new long[]{0x0004000000000840L});
	public static final BitSet FOLLOW_BAR_in_listterm2378 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_VAR_in_listterm2382 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_listterm2391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper2406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper2412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper2431 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper2437 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2454 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQUALS_in_eqoper2460 = new BitSet(new long[]{0x0000000000000002L});
}
