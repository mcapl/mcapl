// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2015-03-02 15:13:42

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:1: program returns [Abstract_MAS mas] : MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gl] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? CURLYCLOSE ;
	public final Abstract_MAS program() throws RecognitionException {
		Abstract_MAS mas = null;


		String i =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:36: ( MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gl] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:39: MAIN COLON i= id CURLYOPEN ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? MAIN MODULE CURLYOPEN module[gl] CURLYCLOSE ( EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE )? ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? CURLYCLOSE
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
			pushFollow(FOLLOW_module_in_program292);
			module(gl);
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program295); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:60:42: ( EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==EVENT) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:60:43: EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE
					{
					match(input,EVENT,FOLLOW_EVENT_in_program339); 
					match(input,MODULE,FOLLOW_MODULE_in_program341); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program343); 
					pushFollow(FOLLOW_module_in_program345);
					module(gl);
					state._fsp--;

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program348); 
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
					match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_program394); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program396); 
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
							pushFollow(FOLLOW_actionspec_in_program398);
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

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program402); 
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program494); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:1: module[Abstract_GOALAgent gl] : ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule[gl] )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? ;
	public final void module(Abstract_GOALAgent gl) throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:31: ( ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule[gl] )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:33: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )? ( GOALS CURLYOPEN ( poslitconj[gl] )* CURLYCLOSE )? PROGRAM ( optionorder )? CURLYOPEN ( macro )* ( actionrule[gl] )+ CURLYCLOSE ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )?
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:33: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==KNOWLEDGE) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:34: KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE
					{
					match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_module587); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module589); 
					pushFollow(FOLLOW_krspec_in_module591);
					krspec(gl);
					state._fsp--;

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module594); 
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
					match(input,GOALS,FOLLOW_GOALS_in_module628); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module630); 
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
							pushFollow(FOLLOW_poslitconj_in_module632);
							poslitconj(gl);
							state._fsp--;

							}
							break;

						default :
							break loop9;
						}
					}

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module636); 
					}
					break;

			}

			match(input,PROGRAM,FOLLOW_PROGRAM_in_module669); 
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
					pushFollow(FOLLOW_optionorder_in_module672);
					optionorder();
					state._fsp--;

					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module676); 
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
					pushFollow(FOLLOW_macro_in_module711);
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
					pushFollow(FOLLOW_actionrule_in_module747);
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

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module780); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:30: ( ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==ACTIONSPEC) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:31: ACTIONSPEC CURLYOPEN ( actionspec[gl] )+ CURLYCLOSE
					{
					match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_module812); 
					match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module814); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:52: ( actionspec[gl] )+
					int cnt14=0;
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==ADOPT||LA14_0==CONST||LA14_0==DELETE||LA14_0==DROP||LA14_0==INSERT||LA14_0==SEND||LA14_0==VAR) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:52: actionspec[gl]
							{
							pushFollow(FOLLOW_actionspec_in_module816);
							actionspec(gl);
							state._fsp--;

							}
							break;

						default :
							if ( cnt14 >= 1 ) break loop14;
							EarlyExitException eee = new EarlyExitException(14, input);
							throw eee;
						}
						cnt14++;
					}

					match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module820); 
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
	// $ANTLR end "module"



	// $ANTLR start "krspec"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:1: krspec[Abstract_GOALAgent gl] : (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ ;
	public final void krspec(Abstract_GOALAgent gl) throws RecognitionException {
		Abstract_Predicate hd =null;
		Abstract_LogicalFormula body =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:30: ( (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:33: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:33: (hd= atom ( STOP | PROLOGARROW body= litconj STOP ) )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:34: hd= atom ( STOP | PROLOGARROW body= litconj STOP )
					{
					pushFollow(FOLLOW_atom_in_krspec863);
					hd=atom();
					state._fsp--;

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:2: ( STOP | PROLOGARROW body= litconj STOP )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:3: STOP
							{
							match(input,STOP,FOLLOW_STOP_in_krspec867); 
							gl.addFact(hd);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:2: PROLOGARROW body= litconj STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_krspec875); 
							pushFollow(FOLLOW_litconj_in_krspec879);
							body=litconj();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_krspec881); 
							gl.addKRule(new Abstract_Rule(hd, body));
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
			int cnt19=0;
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==CONST||LA19_0==VAR) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:34: hd= atom ( STOP | PROLOGARROW body= litconj STOP )
					{
					pushFollow(FOLLOW_atom_in_brspec902);
					hd=atom();
					state._fsp--;

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:79:2: ( STOP | PROLOGARROW body= litconj STOP )
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==STOP) ) {
						alt18=1;
					}
					else if ( (LA18_0==PROLOGARROW) ) {
						alt18=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 18, 0, input);
						throw nvae;
					}

					switch (alt18) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:79:3: STOP
							{
							match(input,STOP,FOLLOW_STOP_in_brspec907); 
							gl.addBel(hd);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:2: PROLOGARROW body= litconj STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_brspec915); 
							pushFollow(FOLLOW_litconj_in_brspec919);
							body=litconj();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_brspec921); 
							gl.addRule(new Abstract_Rule(hd, body));
							}
							break;

					}

					}
					break;

				default :
					if ( cnt19 >= 1 ) break loop19;
					EarlyExitException eee = new EarlyExitException(19, input);
					throw eee;
				}
				cnt19++;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:1: poslitconj[Abstract_GOALAgent gl] : g= atom ( COMMA g1= atom )* STOP ;
	public final void poslitconj(Abstract_GOALAgent gl) throws RecognitionException {
		Abstract_Predicate g =null;
		Abstract_Predicate g1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:35: (g= atom ( COMMA g1= atom )* STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:37: g= atom ( COMMA g1= atom )* STOP
			{
			pushFollow(FOLLOW_atom_in_poslitconj974);
			g=atom();
			state._fsp--;

			gl.addGoal(g);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:62: ( COMMA g1= atom )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==COMMA) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:63: COMMA g1= atom
					{
					match(input,COMMA,FOLLOW_COMMA_in_poslitconj979); 
					pushFollow(FOLLOW_atom_in_poslitconj983);
					g1=atom();
					state._fsp--;

					gl.addGoal(g1);
					}
					break;

				default :
					break loop20;
				}
			}

			match(input,STOP,FOLLOW_STOP_in_poslitconj988); 
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
			pushFollow(FOLLOW_literal_in_litconj1001);
			l=literal();
			state._fsp--;

			f = l;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:66: ( COMMA l1= literal )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==COMMA) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:67: COMMA l1= literal
					{
					match(input,COMMA,FOLLOW_COMMA_in_litconj1006); 
					pushFollow(FOLLOW_literal_in_litconj1010);
					l1=literal();
					state._fsp--;

					f = new Abstract_LogExpr(l, Abstract_LogExpr.and, l1);
					}
					break;

				default :
					break loop21;
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
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==CONST||LA22_0==VAR) ) {
				alt22=1;
			}
			else if ( (LA22_0==NOT) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:46: a= atom
					{
					pushFollow(FOLLOW_atom_in_literal1028);
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
					match(input,NOT,FOLLOW_NOT_in_literal1035); 
					match(input,OPEN,FOLLOW_OPEN_in_literal1037); 
					pushFollow(FOLLOW_atom_in_literal1041);
					a1=atom();
					state._fsp--;

					l=new Abstract_LogExpr(Abstract_LogExpr.not, a1);
					match(input,CLOSE,FOLLOW_CLOSE_in_literal1045); 
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
			pushFollow(FOLLOW_id_in_atom1060);
			s=id();
			state._fsp--;

			Abstract_Predicate p =new Abstract_Predicate(s);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:94: (tl= parameters )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:96: tl= parameters
			{
			pushFollow(FOLLOW_parameters_in_atom1067);
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
			match(input,OPEN,FOLLOW_OPEN_in_parameters1083); 
			pushFollow(FOLLOW_term_in_parameters1087);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:92:2: ( COMMA t1= term )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==COMMA) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:92:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_parameters1094); 
					pushFollow(FOLLOW_term_in_parameters1098);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop23;
				}
			}

			match(input,CLOSE,FOLLOW_CLOSE_in_parameters1104); 
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
			match(input,SQOPEN,FOLLOW_SQOPEN_in_optionorder1115); 
			match(input,ORDER,FOLLOW_ORDER_in_optionorder1117); 
			match(input,EQUALS,FOLLOW_EQUALS_in_optionorder1119); 
			if ( (input.LA(1) >= LINEAR && input.LA(1) <= LINEARALL)||(input.LA(1) >= RANDOM && input.LA(1) <= RANDOMALL) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_optionorder1139); 
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
			match(input,HASH,FOLLOW_HASH_in_macro1147); 
			match(input,DEFINE,FOLLOW_DEFINE_in_macro1149); 
			pushFollow(FOLLOW_id_in_macro1153);
			f=id();
			state._fsp--;

			pushFollow(FOLLOW_parameters_in_macro1157);
			pl=parameters();
			state._fsp--;

			pushFollow(FOLLOW_mentalstatecond_in_macro1161);
			msc=mentalstatecond();
			state._fsp--;

			PredicateIndicator pi = new PredicateIndicator(f, pl.length); macros.put(pi, msc); 
			                                  Abstract_Predicate p = new Abstract_Predicate(f); p.setTerms(pl); macro_subs.put(pi, p);
			match(input,STOP,FOLLOW_STOP_in_macro1165); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:1: actionrule[Abstract_GOALAgent gl] : IF (lf= mentalstatecond |f= id pl= parameters ) THEN dl= actioncombo[gl] STOP ;
	public final void actionrule(Abstract_GOALAgent gl) throws RecognitionException {
		Abstract_MentalState lf =null;
		String f =null;
		Abstract_Term[] pl =null;
		ArrayList<Abstract_Deed> dl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:38: ( IF (lf= mentalstatecond |f= id pl= parameters ) THEN dl= actioncombo[gl] STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:40: IF (lf= mentalstatecond |f= id pl= parameters ) THEN dl= actioncombo[gl] STOP
			{
			Abstract_ActionRule rule = new Abstract_ActionRule();
			match(input,IF,FOLLOW_IF_in_actionrule1181); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:100:5: (lf= mentalstatecond |f= id pl= parameters )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==BEL||LA24_0==GOAL||LA24_0==NOT||LA24_0==TRUE) ) {
				alt24=1;
			}
			else if ( (LA24_0==CONST||LA24_0==VAR) ) {
				alt24=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:100:6: lf= mentalstatecond
					{
					pushFollow(FOLLOW_mentalstatecond_in_actionrule1186);
					lf=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(lf);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:101:4: f= id pl= parameters
					{
					pushFollow(FOLLOW_id_in_actionrule1196);
					f=id();
					state._fsp--;

					pushFollow(FOLLOW_parameters_in_actionrule1200);
					pl=parameters();
					state._fsp--;

					PredicateIndicator pi = new PredicateIndicator(f, pl.length); Abstract_MentalState macro=macros.get(pi); Abstract_Term sub=macro_subs.get(pi); Abstract_Unifier u=rule.getUnifier(f, pl, sub); Abstract_MentalState k = macro.apply(u); rule.setMentalStateCond(k);
					}
					break;

			}

			match(input,THEN,FOLLOW_THEN_in_actionrule1208); 
			pushFollow(FOLLOW_actioncombo_in_actionrule1212);
			dl=actioncombo(gl);
			state._fsp--;

			rule.setBody(dl);
			match(input,STOP,FOLLOW_STOP_in_actionrule1217); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:104:1: mentalstatecond returns [Abstract_MentalState lf] : ml= mentalliteral ( COMMA ml2= mentalliteral )* ;
	public final Abstract_MentalState mentalstatecond() throws RecognitionException {
		Abstract_MentalState lf = null;


		Abstract_GLogicalFormula ml =null;
		Abstract_GLogicalFormula ml2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:2: (ml= mentalliteral ( COMMA ml2= mentalliteral )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:4: ml= mentalliteral ( COMMA ml2= mentalliteral )*
			{
			pushFollow(FOLLOW_mentalliteral_in_mentalstatecond1235);
			ml=mentalliteral();
			state._fsp--;

			Abstract_MentalState ms = new Abstract_MentalState(ml);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:79: ( COMMA ml2= mentalliteral )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==COMMA) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:80: COMMA ml2= mentalliteral
					{
					match(input,COMMA,FOLLOW_COMMA_in_mentalstatecond1240); 
					pushFollow(FOLLOW_mentalliteral_in_mentalstatecond1244);
					ml2=mentalliteral();
					state._fsp--;

					ms = new Abstract_MentalState(ms, Abstract_Guard.and, ml2); lf = ms;
					}
					break;

				default :
					break loop25;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:1: mentalliteral returns [Abstract_GLogicalFormula lf] : ( TRUE |ma= mentalatom | NOT OPEN nma= mentalatom CLOSE );
	public final Abstract_GLogicalFormula mentalliteral() throws RecognitionException {
		Abstract_GLogicalFormula lf = null;


		Abstract_GLogicalFormula ma =null;
		Abstract_GLogicalFormula nma =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:2: ( TRUE |ma= mentalatom | NOT OPEN nma= mentalatom CLOSE )
			int alt26=3;
			switch ( input.LA(1) ) {
			case TRUE:
				{
				alt26=1;
				}
				break;
			case BEL:
			case GOAL:
				{
				alt26=2;
				}
				break;
			case NOT:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_mentalliteral1263); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:11: ma= mentalatom
					{
					pushFollow(FOLLOW_mentalatom_in_mentalliteral1269);
					ma=mentalatom();
					state._fsp--;

					lf = ma;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:39: NOT OPEN nma= mentalatom CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_mentalliteral1275); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalliteral1277); 
					pushFollow(FOLLOW_mentalatom_in_mentalliteral1281);
					nma=mentalatom();
					state._fsp--;

					lf = new Abstract_Guard(Abstract_Guard.not, nma);
					match(input,CLOSE,FOLLOW_CLOSE_in_mentalliteral1285); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:1: mentalatom returns [Abstract_GLogicalFormula lf] : ( BEL OPEN b= litconj CLOSE | GOAL OPEN g= litconj CLOSE );
	public final Abstract_GLogicalFormula mentalatom() throws RecognitionException {
		Abstract_GLogicalFormula lf = null;


		Abstract_LogicalFormula b =null;
		Abstract_LogicalFormula g =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:2: ( BEL OPEN b= litconj CLOSE | GOAL OPEN g= litconj CLOSE )
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==BEL) ) {
				alt27=1;
			}
			else if ( (LA27_0==GOAL) ) {
				alt27=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:4: BEL OPEN b= litconj CLOSE
					{
					match(input,BEL,FOLLOW_BEL_in_mentalatom1299); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalatom1301); 
					pushFollow(FOLLOW_litconj_in_mentalatom1305);
					b=litconj();
					state._fsp--;

					lf = new Abstract_MentalAtom(b, DefaultAILStructure.AILBel);
					match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1310); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:96: GOAL OPEN g= litconj CLOSE
					{
					match(input,GOAL,FOLLOW_GOAL_in_mentalatom1314); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalatom1316); 
					pushFollow(FOLLOW_litconj_in_mentalatom1320);
					g=litconj();
					state._fsp--;

					lf = new Abstract_MentalAtom(g, DefaultAILStructure.AILGoal);
					match(input,CLOSE,FOLLOW_CLOSE_in_mentalatom1323); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:114:1: actionspec[Abstract_GOALAgent gl] : deed= action[gl] CURLYOPEN PRE CURLYOPEN lf1= litconj CURLYCLOSE POST CURLYOPEN lf2= litconj CURLYCLOSE CURLYCLOSE ;
	public final void actionspec(Abstract_GOALAgent gl) throws RecognitionException {
		Abstract_Deed deed =null;
		Abstract_LogicalFormula lf1 =null;
		Abstract_LogicalFormula lf2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:114:34: (deed= action[gl] CURLYOPEN PRE CURLYOPEN lf1= litconj CURLYCLOSE POST CURLYOPEN lf2= litconj CURLYCLOSE CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:114:36: deed= action[gl] CURLYOPEN PRE CURLYOPEN lf1= litconj CURLYCLOSE POST CURLYOPEN lf2= litconj CURLYCLOSE CURLYCLOSE
			{
			pushFollow(FOLLOW_action_in_actionspec1335);
			deed=action(gl);
			state._fsp--;

			Abstract_Goal goal = (Abstract_Goal) deed.getContent();
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1342); 
			match(input,PRE,FOLLOW_PRE_in_actionspec1344); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1346); 
			pushFollow(FOLLOW_litconj_in_actionspec1350);
			lf1=litconj();
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1352); 
			Abstract_MentalAtom pres = new Abstract_MentalAtom(lf1, DefaultAILStructure.AILBel);
			match(input,POST,FOLLOW_POST_in_actionspec1357); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionspec1359); 
			pushFollow(FOLLOW_litconj_in_actionspec1363);
			lf2=litconj();
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1365); 
			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionspec1367); 
			gl.addPlan(new Abstract_ActionSpec(goal, pres, lf2));
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:118:1: actioncombo[Abstract_GOALAgent gl] returns [ArrayList<Abstract_Deed> dl] :a= action[gl] ( PLUS a1= action[gl] )* ;
	public final ArrayList<Abstract_Deed> actioncombo(Abstract_GOALAgent gl) throws RecognitionException {
		ArrayList<Abstract_Deed> dl = null;


		Abstract_Deed a =null;
		Abstract_Deed a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:2: (a= action[gl] ( PLUS a1= action[gl] )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:4: a= action[gl] ( PLUS a1= action[gl] )*
			{
			dl = new ArrayList<Abstract_Deed>();
			pushFollow(FOLLOW_action_in_actioncombo1387);
			a=action(gl);
			state._fsp--;

			dl.add(a);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:71: ( PLUS a1= action[gl] )*
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==PLUS) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:72: PLUS a1= action[gl]
					{
					match(input,PLUS,FOLLOW_PLUS_in_actioncombo1393); 
					pushFollow(FOLLOW_action_in_actioncombo1397);
					a1=action(gl);
					state._fsp--;

					dl.add(a1);
					}
					break;

				default :
					break loop28;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:1: action[Abstract_GOALAgent gl] returns [Abstract_Deed d] : (deed= userdefaction | builtinaction | communication[gl] ) ;
	public final Abstract_Deed action(Abstract_GOALAgent gl) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Deed deed =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:57: ( (deed= userdefaction | builtinaction | communication[gl] ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:59: (deed= userdefaction | builtinaction | communication[gl] )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:59: (deed= userdefaction | builtinaction | communication[gl] )
			int alt29=3;
			switch ( input.LA(1) ) {
			case CONST:
			case VAR:
				{
				alt29=1;
				}
				break;
			case ADOPT:
			case DELETE:
			case DROP:
			case INSERT:
				{
				alt29=2;
				}
				break;
			case SEND:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:60: deed= userdefaction
					{
					pushFollow(FOLLOW_userdefaction_in_action1419);
					deed=userdefaction();
					state._fsp--;

					d =deed;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:91: builtinaction
					{
					pushFollow(FOLLOW_builtinaction_in_action1424);
					builtinaction();
					state._fsp--;

					d = new Abstract_Deed(Abstract_Deed.DNull);
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:154: communication[gl]
					{
					pushFollow(FOLLOW_communication_in_action1430);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:1: userdefaction returns [Abstract_Deed d] : f= id (pl= parameters )+ ;
	public final Abstract_Deed userdefaction() throws RecognitionException {
		Abstract_Deed d = null;


		String f =null;
		Abstract_Term[] pl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:2: (f= id (pl= parameters )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:4: f= id (pl= parameters )+
			{
			pushFollow(FOLLOW_id_in_userdefaction1450);
			f=id();
			state._fsp--;

			Abstract_Predicate p = new Abstract_Predicate(f);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:61: (pl= parameters )+
			int cnt30=0;
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==OPEN) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:62: pl= parameters
					{
					pushFollow(FOLLOW_parameters_in_userdefaction1457);
					pl=parameters();
					state._fsp--;

					p.setTerms(pl);
					}
					break;

				default :
					if ( cnt30 >= 1 ) break loop30;
					EarlyExitException eee = new EarlyExitException(30, input);
					throw eee;
				}
				cnt30++;
			}

			d=new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, new Abstract_Goal(p, Abstract_Goal.performGoal));
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:1: builtinaction : ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN litconj CLOSE | DROP OPEN litconj CLOSE );
	public final void builtinaction() throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:2: ( INSERT OPEN litconj CLOSE | DELETE OPEN litconj CLOSE | ADOPT OPEN litconj CLOSE | DROP OPEN litconj CLOSE )
			int alt31=4;
			switch ( input.LA(1) ) {
			case INSERT:
				{
				alt31=1;
				}
				break;
			case DELETE:
				{
				alt31=2;
				}
				break;
			case ADOPT:
				{
				alt31=3;
				}
				break;
			case DROP:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:4: INSERT OPEN litconj CLOSE
					{
					match(input,INSERT,FOLLOW_INSERT_in_builtinaction1474); 
					match(input,OPEN,FOLLOW_OPEN_in_builtinaction1476); 
					pushFollow(FOLLOW_litconj_in_builtinaction1478);
					litconj();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1480); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:3: DELETE OPEN litconj CLOSE
					{
					match(input,DELETE,FOLLOW_DELETE_in_builtinaction1486); 
					match(input,OPEN,FOLLOW_OPEN_in_builtinaction1488); 
					pushFollow(FOLLOW_litconj_in_builtinaction1490);
					litconj();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1492); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:4: ADOPT OPEN litconj CLOSE
					{
					match(input,ADOPT,FOLLOW_ADOPT_in_builtinaction1499); 
					match(input,OPEN,FOLLOW_OPEN_in_builtinaction1501); 
					pushFollow(FOLLOW_litconj_in_builtinaction1503);
					litconj();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1505); 
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:4: DROP OPEN litconj CLOSE
					{
					match(input,DROP,FOLLOW_DROP_in_builtinaction1512); 
					match(input,OPEN,FOLLOW_OPEN_in_builtinaction1514); 
					pushFollow(FOLLOW_litconj_in_builtinaction1516);
					litconj();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_builtinaction1518); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:132:1: communication[Abstract_GOALAgent gl] returns [Abstract_Deed d] : SEND OPEN id COMMA poslitconj[gl] CLOSE ;
	public final Abstract_Deed communication(Abstract_GOALAgent gl) throws RecognitionException {
		Abstract_Deed d = null;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:2: ( SEND OPEN id COMMA poslitconj[gl] CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:4: SEND OPEN id COMMA poslitconj[gl] CLOSE
			{
			match(input,SEND,FOLLOW_SEND_in_communication1535); 
			match(input,OPEN,FOLLOW_OPEN_in_communication1537); 
			pushFollow(FOLLOW_id_in_communication1539);
			id();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_communication1541); 
			pushFollow(FOLLOW_poslitconj_in_communication1543);
			poslitconj(gl);
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_communication1546); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:1: id returns [String s] : ( CONST | VAR ) ;
	public final String id() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:23: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:25: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:25: ( CONST | VAR )
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==CONST) ) {
				alt32=1;
			}
			else if ( (LA32_0==VAR) ) {
				alt32=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}

			switch (alt32) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:26: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_id1600); 
					s = CONST1.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:58: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_id1605); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:2: equation returns [Abstract_Equation e] : a1= arithexpr i= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation e = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:175:3: (a1= arithexpr i= eqoper a2= arithexpr )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:175:5: a1= arithexpr i= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation1927);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation1931);
			i=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation1935);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:176:2: term returns [Abstract_Term t] : (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) ;
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_StringTerm st =null;
		Abstract_Term ft =null;
		Abstract_NumberTerm at =null;
		Abstract_ListTermImpl lt =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:176:33: ( (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:176:35: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:176:35: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			int alt33=4;
			switch ( input.LA(1) ) {
			case DOUBLEQUOTE:
				{
				alt33=1;
				}
				break;
			case CONST:
				{
				alt33=2;
				}
				break;
			case MINUS:
			case NUMBER:
			case VAR:
				{
				alt33=3;
				}
				break;
			case SQOPEN:
				{
				alt33=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}
			switch (alt33) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:176:36: st= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term1952);
					st=stringterm();
					state._fsp--;

					t = st;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:176:63: ft= function_term
					{
					pushFollow(FOLLOW_function_term_in_term1960);
					ft=function_term();
					state._fsp--;

					t =ft;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:176:91: at= arithexpr
					{
					pushFollow(FOLLOW_arithexpr_in_term1968);
					at=arithexpr();
					state._fsp--;

					t =at;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:176:114: lt= listterm
					{
					pushFollow(FOLLOW_listterm_in_term1975);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:177:2: function_term returns [Abstract_Term t] : c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? ;
	public final Abstract_Term function_term() throws RecognitionException {
		Abstract_Term t = null;


		Token c=null;
		Abstract_Term t1 =null;
		Abstract_Term t2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:178:3: (c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:178:5: c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			{
			c=(Token)match(input,CONST,FOLLOW_CONST_in_function_term1995); 
			t=new Abstract_Predicate(c.getText());
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:178:54: ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==OPEN) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:178:55: OPEN t1= term ( COMMA t2= term )* CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function_term2000); 
					pushFollow(FOLLOW_term_in_function_term2004);
					t1=term();
					state._fsp--;

					((Abstract_Predicate) t).addTerm(t1);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:178:111: ( COMMA t2= term )*
					loop34:
					while (true) {
						int alt34=2;
						int LA34_0 = input.LA(1);
						if ( (LA34_0==COMMA) ) {
							alt34=1;
						}

						switch (alt34) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:178:112: COMMA t2= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_function_term2009); 
							pushFollow(FOLLOW_term_in_function_term2013);
							t2=term();
							state._fsp--;

							((Abstract_Predicate) t).addTerm(t2);
							}
							break;

						default :
							break loop34;
						}
					}

					match(input,CLOSE,FOLLOW_CLOSE_in_function_term2019); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:179:2: atom_term returns [Abstract_NumberTerm t] : (n= numberstring |v= var ) ;
	public final Abstract_NumberTerm atom_term() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:179:44: ( (n= numberstring |v= var ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:179:46: (n= numberstring |v= var )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:179:46: (n= numberstring |v= var )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==MINUS||LA36_0==NUMBER) ) {
				alt36=1;
			}
			else if ( (LA36_0==VAR) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:179:47: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom_term2038);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:179:108: v= var
					{
					pushFollow(FOLLOW_var_in_atom_term2046);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:2: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE w= word DOUBLEQUOTE ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		String w =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:181:3: ( DOUBLEQUOTE w= word DOUBLEQUOTE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:181:5: DOUBLEQUOTE w= word DOUBLEQUOTE
			{
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2063); 
			pushFollow(FOLLOW_word_in_stringterm2067);
			w=word();
			state._fsp--;

			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2069); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:2: var returns [Abstract_VarTerm v] : VAR ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR3=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:35: ( VAR )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:37: VAR
			{
			VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_var2083); 

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:191:2: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:3: ( ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:5: ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? )
			{
			s = "";
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:16: ( MINUS )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==MINUS) ) {
				alt37=1;
			}
			switch (alt37) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:17: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring2103); 
					s += "-";
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:38: (n1= NUMBER ( STOP n2= NUMBER )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:39: n1= NUMBER ( STOP n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2112); 
			s += n1.getText();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:193:37: ( STOP n2= NUMBER )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==STOP) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:193:38: STOP n2= NUMBER
					{
					match(input,STOP,FOLLOW_STOP_in_numberstring2153); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2159); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:195:1: arithexpr returns [Abstract_NumberTerm ae] : a1= multexpr (i= addoper a2= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:3: (a1= multexpr (i= addoper a2= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:6: a1= multexpr (i= addoper a2= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr2213);
			a1=multexpr();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:30: (i= addoper a2= multexpr )?
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==MINUS||LA39_0==PLUS) ) {
				alt39=1;
			}
			switch (alt39) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:31: i= addoper a2= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr2220);
					i=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr2224);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:1: multexpr returns [Abstract_NumberTerm ae] : a1= atom_term (i= multoper a2= atom_term )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:42: (a1= atom_term (i= multoper a2= atom_term )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:44: a1= atom_term (i= multoper a2= atom_term )?
			{
			pushFollow(FOLLOW_atom_term_in_multexpr2240);
			a1=atom_term();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:68: (i= multoper a2= atom_term )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==DIV||LA40_0==MULT) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:69: i= multoper a2= atom_term
					{
					pushFollow(FOLLOW_multoper_in_multexpr2246);
					i=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_term_in_multexpr2250);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST4=null;
		Token VAR5=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:25: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:27: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:27: ( CONST | VAR )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:28: CONST
					{
					CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_word2267); 
					s =CONST4.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:59: VAR
					{
					VAR5=(Token)match(input,VAR,FOLLOW_VAR_in_word2273); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:202:2: listterm returns [Abstract_ListTermImpl l] : SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE ;
	public final Abstract_ListTermImpl listterm() throws RecognitionException {
		Abstract_ListTermImpl l = null;


		Token v=null;
		Abstract_Term h =null;
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:3: ( SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:5: SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE
			{
			l = new Abstract_ListTermImpl(); Abstract_ListTerm lrunning = l;
			match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2383); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:204:10: (h= term ( COMMA t= term )* ( BAR v= VAR )? )?
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==CONST||LA44_0==DOUBLEQUOTE||LA44_0==MINUS||LA44_0==NUMBER||LA44_0==SQOPEN||LA44_0==VAR) ) {
				alt44=1;
			}
			switch (alt44) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:204:11: h= term ( COMMA t= term )* ( BAR v= VAR )?
					{
					pushFollow(FOLLOW_term_in_listterm2388);
					h=term();
					state._fsp--;

					l.addHead(h); l.addTail(new Abstract_ListTermImpl());
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:205:3: ( COMMA t= term )*
					loop42:
					while (true) {
						int alt42=2;
						int LA42_0 = input.LA(1);
						if ( (LA42_0==COMMA) ) {
							alt42=1;
						}

						switch (alt42) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:205:4: COMMA t= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_listterm2396); 
							pushFollow(FOLLOW_term_in_listterm2400);
							t=term();
							state._fsp--;

							Abstract_ListTerm l2 = new Abstract_ListTermImpl();  l2.addHead(t); l2.addTail(new Abstract_ListTermImpl()); lrunning.addTail(l2); lrunning=l2;
							}
							break;

						default :
							break loop42;
						}
					}

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:3: ( BAR v= VAR )?
					int alt43=2;
					int LA43_0 = input.LA(1);
					if ( (LA43_0==BAR) ) {
						alt43=1;
					}
					switch (alt43) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:4: BAR v= VAR
							{
							match(input,BAR,FOLLOW_BAR_in_listterm2410); 
							v=(Token)match(input,VAR,FOLLOW_VAR_in_listterm2414); 
							lrunning.addTail(new Abstract_VarTerm(v.getText()));
							}
							break;

					}

					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2423); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:2: addoper returns [int i] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:25: ( ( PLUS | MINUS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:27: ( PLUS | MINUS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:27: ( PLUS | MINUS )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==PLUS) ) {
				alt45=1;
			}
			else if ( (LA45_0==MINUS) ) {
				alt45=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}

			switch (alt45) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:28: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper2438); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:45: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper2444); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:209:2: multoper returns [int i] : ( MULT | DIV ) ;
	public final int multoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:3: ( ( MULT | DIV ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:5: ( MULT | DIV )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:5: ( MULT | DIV )
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==MULT) ) {
				alt46=1;
			}
			else if ( (LA46_0==DIV) ) {
				alt46=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}

			switch (alt46) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:6: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper2463); 
					i = 3;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:23: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper2469); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:211:2: eqoper returns [int i] : ( LESS | EQUALS ) ;
	public final int eqoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:211:25: ( ( LESS | EQUALS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:211:27: ( LESS | EQUALS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:211:27: ( LESS | EQUALS )
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==LESS) ) {
				alt47=1;
			}
			else if ( (LA47_0==EQUALS) ) {
				alt47=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}

			switch (alt47) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:211:28: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2486); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:211:45: EQUALS
					{
					match(input,EQUALS,FOLLOW_EQUALS_in_eqoper2492); 
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
	public static final BitSet FOLLOW_module_in_program292 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program295 = new BitSet(new long[]{0x0000000000404010L});
	public static final BitSet FOLLOW_EVENT_in_program339 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_MODULE_in_program341 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program343 = new BitSet(new long[]{0x0000200011000000L});
	public static final BitSet FOLLOW_module_in_program345 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program348 = new BitSet(new long[]{0x0000000000004010L});
	public static final BitSet FOLLOW_ACTIONSPEC_in_program394 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program396 = new BitSet(new long[]{0x0082000008122020L});
	public static final BitSet FOLLOW_actionspec_in_program398 = new BitSet(new long[]{0x0082000008126020L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program402 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program494 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KNOWLEDGE_in_module587 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module589 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_krspec_in_module591 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module594 = new BitSet(new long[]{0x0000200001000000L});
	public static final BitSet FOLLOW_GOALS_in_module628 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module630 = new BitSet(new long[]{0x0080000000006000L});
	public static final BitSet FOLLOW_poslitconj_in_module632 = new BitSet(new long[]{0x0080000000006000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module636 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_PROGRAM_in_module669 = new BitSet(new long[]{0x0008000000008000L});
	public static final BitSet FOLLOW_optionorder_in_module672 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module676 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_macro_in_module711 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_actionrule_in_module747 = new BitSet(new long[]{0x0000000004004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module780 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_ACTIONSPEC_in_module812 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module814 = new BitSet(new long[]{0x0082000008122020L});
	public static final BitSet FOLLOW_actionspec_in_module816 = new BitSet(new long[]{0x0082000008126020L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module820 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_krspec863 = new BitSet(new long[]{0x0010400000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec867 = new BitSet(new long[]{0x0080000000002002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_krspec875 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_krspec879 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec881 = new BitSet(new long[]{0x0080000000002002L});
	public static final BitSet FOLLOW_atom_in_brspec902 = new BitSet(new long[]{0x0010400000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec907 = new BitSet(new long[]{0x0080000000002002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_brspec915 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_brspec919 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec921 = new BitSet(new long[]{0x0080000000002002L});
	public static final BitSet FOLLOW_atom_in_poslitconj974 = new BitSet(new long[]{0x0010000000000800L});
	public static final BitSet FOLLOW_COMMA_in_poslitconj979 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_atom_in_poslitconj983 = new BitSet(new long[]{0x0010000000000800L});
	public static final BitSet FOLLOW_STOP_in_poslitconj988 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_litconj1001 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_litconj1006 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_literal_in_litconj1010 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_atom_in_literal1028 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_literal1035 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_literal1037 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_atom_in_literal1041 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_literal1045 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_atom1060 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_parameters_in_atom1067 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_parameters1083 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_parameters1087 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_COMMA_in_parameters1094 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_parameters1098 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_CLOSE_in_parameters1104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_optionorder1115 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_ORDER_in_optionorder1117 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_EQUALS_in_optionorder1119 = new BitSet(new long[]{0x00018000C0000000L});
	public static final BitSet FOLLOW_set_in_optionorder1121 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_optionorder1139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HASH_in_macro1147 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DEFINE_in_macro1149 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_id_in_macro1153 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_parameters_in_macro1157 = new BitSet(new long[]{0x0040004000800080L});
	public static final BitSet FOLLOW_mentalstatecond_in_macro1161 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STOP_in_macro1165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_actionrule1181 = new BitSet(new long[]{0x00C0004000802080L});
	public static final BitSet FOLLOW_mentalstatecond_in_actionrule1186 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_id_in_actionrule1196 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_parameters_in_actionrule1200 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_THEN_in_actionrule1208 = new BitSet(new long[]{0x0082000008122020L});
	public static final BitSet FOLLOW_actioncombo_in_actionrule1212 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STOP_in_actionrule1217 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond1235 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_mentalstatecond1240 = new BitSet(new long[]{0x0040004000800080L});
	public static final BitSet FOLLOW_mentalliteral_in_mentalstatecond1244 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_TRUE_in_mentalliteral1263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mentalatom_in_mentalliteral1269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_mentalliteral1275 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalliteral1277 = new BitSet(new long[]{0x0000000000800080L});
	public static final BitSet FOLLOW_mentalatom_in_mentalliteral1281 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_mentalliteral1285 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEL_in_mentalatom1299 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalatom1301 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_mentalatom1305 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_mentalatom1310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_mentalatom1314 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalatom1316 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_mentalatom1320 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_mentalatom1323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actionspec1335 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1342 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_PRE_in_actionspec1344 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1346 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_actionspec1350 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1352 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_POST_in_actionspec1357 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionspec1359 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_actionspec1363 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1365 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionspec1367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actioncombo1387 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_PLUS_in_actioncombo1393 = new BitSet(new long[]{0x0082000008122020L});
	public static final BitSet FOLLOW_action_in_actioncombo1397 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_userdefaction_in_action1419 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_builtinaction_in_action1424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_communication_in_action1430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_userdefaction1450 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_parameters_in_userdefaction1457 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_INSERT_in_builtinaction1474 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_builtinaction1476 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_builtinaction1478 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_builtinaction1480 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DELETE_in_builtinaction1486 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_builtinaction1488 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_builtinaction1490 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_builtinaction1492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADOPT_in_builtinaction1499 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_builtinaction1501 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_builtinaction1503 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_builtinaction1505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_builtinaction1512 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_builtinaction1514 = new BitSet(new long[]{0x0080004000002000L});
	public static final BitSet FOLLOW_litconj_in_builtinaction1516 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_builtinaction1518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEND_in_communication1535 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_communication1537 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_id_in_communication1539 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_communication1541 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_poslitconj_in_communication1543 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLOSE_in_communication1546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_id1600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_id1605 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation1927 = new BitSet(new long[]{0x0000000020200000L});
	public static final BitSet FOLLOW_eqoper_in_equation1931 = new BitSet(new long[]{0x0080008400000000L});
	public static final BitSet FOLLOW_arithexpr_in_equation1935 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_term1952 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_term1960 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_term1968 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_term1975 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function_term1995 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_OPEN_in_function_term2000 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_function_term2004 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_COMMA_in_function_term2009 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_function_term2013 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_CLOSE_in_function_term2019 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom_term2038 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom_term2046 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2063 = new BitSet(new long[]{0x0080000000002000L});
	public static final BitSet FOLLOW_word_in_stringterm2067 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2069 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var2083 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring2103 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2112 = new BitSet(new long[]{0x0010000000000002L});
	public static final BitSet FOLLOW_STOP_in_numberstring2153 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2213 = new BitSet(new long[]{0x0000040400000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr2220 = new BitSet(new long[]{0x0080008400000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2240 = new BitSet(new long[]{0x0000001000040002L});
	public static final BitSet FOLLOW_multoper_in_multexpr2246 = new BitSet(new long[]{0x0080008400000000L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_word2267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word2273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_listterm2383 = new BitSet(new long[]{0x008C008400082000L});
	public static final BitSet FOLLOW_term_in_listterm2388 = new BitSet(new long[]{0x0004000000000840L});
	public static final BitSet FOLLOW_COMMA_in_listterm2396 = new BitSet(new long[]{0x0088008400082000L});
	public static final BitSet FOLLOW_term_in_listterm2400 = new BitSet(new long[]{0x0004000000000840L});
	public static final BitSet FOLLOW_BAR_in_listterm2410 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_VAR_in_listterm2414 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_listterm2423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper2438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper2444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper2463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper2469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQUALS_in_eqoper2492 = new BitSet(new long[]{0x0000000000000002L});
}
