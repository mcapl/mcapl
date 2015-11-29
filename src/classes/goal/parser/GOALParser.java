// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2015-11-27 16:59:14

package goal.parser;

import ail.syntax.ast.*;
import ail.syntax.DefaultAILStructure;
import goal.syntax.ActionRule;
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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTIONSPEC", "ADAPTIVE", "AGOAL", 
		"BAR", "BEL", "BELIEFS", "CLOSE", "COLON", "COMMA", "COMMENT", "CONST", 
		"CURLYCLOSE", "CURLYOPEN", "DEFINE", "DIV", "DO", "EQUALS", "EVENT", "EXTERNAL", 
		"GOAL", "GOALA", "GOALS", "HASH", "IF", "INIT", "INTERNAL", "IS", "KNOWLEDGE", 
		"LESS", "LINEAR", "LINEARALL", "LINE_COMMENT", "MAIN", "MINUS", "MODULE", 
		"MODULEFILE", "MULT", "NEWLINE", "NOT", "NUMBER", "OPEN", "ORDER", "PLUS", 
		"POST", "PRE", "PROGRAM", "PROLOGARROW", "RANDOM", "RANDOMALL", "SEMI", 
		"SINGLEQUOTE", "SQCLOSE", "SQOPEN", "STOP", "STRING", "THEN", "TRUE", 
		"UNNAMEDVAR", "VAR", "WS", "'#import'", "'->'", "'<-'", "'adopt'", "'all'", 
		"'allother'", "'always'", "'delete'", "'drop'", "'exit'", "'exit-module'", 
		"'filter'", "'focus'", "'forall'", "'insert'", "'listall'", "'log'", "'never'", 
		"'new'", "'noaction'", "'nogoals'", "'none'", "'print'", "'select'", "'self'", 
		"'send'", "'sendonce'", "'some'", "'someother'", "'this'"
	};
	public static final int EOF=-1;
	public static final int T__64=64;
	public static final int T__65=65;
	public static final int T__66=66;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__70=70;
	public static final int T__71=71;
	public static final int T__72=72;
	public static final int T__73=73;
	public static final int T__74=74;
	public static final int T__75=75;
	public static final int T__76=76;
	public static final int T__77=77;
	public static final int T__78=78;
	public static final int T__79=79;
	public static final int T__80=80;
	public static final int T__81=81;
	public static final int T__82=82;
	public static final int T__83=83;
	public static final int T__84=84;
	public static final int T__85=85;
	public static final int T__86=86;
	public static final int T__87=87;
	public static final int T__88=88;
	public static final int T__89=89;
	public static final int T__90=90;
	public static final int T__91=91;
	public static final int T__92=92;
	public static final int T__93=93;
	public static final int ACTIONSPEC=4;
	public static final int ADAPTIVE=5;
	public static final int AGOAL=6;
	public static final int BAR=7;
	public static final int BEL=8;
	public static final int BELIEFS=9;
	public static final int CLOSE=10;
	public static final int COLON=11;
	public static final int COMMA=12;
	public static final int COMMENT=13;
	public static final int CONST=14;
	public static final int CURLYCLOSE=15;
	public static final int CURLYOPEN=16;
	public static final int DEFINE=17;
	public static final int DIV=18;
	public static final int DO=19;
	public static final int EQUALS=20;
	public static final int EVENT=21;
	public static final int EXTERNAL=22;
	public static final int GOAL=23;
	public static final int GOALA=24;
	public static final int GOALS=25;
	public static final int HASH=26;
	public static final int IF=27;
	public static final int INIT=28;
	public static final int INTERNAL=29;
	public static final int IS=30;
	public static final int KNOWLEDGE=31;
	public static final int LESS=32;
	public static final int LINEAR=33;
	public static final int LINEARALL=34;
	public static final int LINE_COMMENT=35;
	public static final int MAIN=36;
	public static final int MINUS=37;
	public static final int MODULE=38;
	public static final int MODULEFILE=39;
	public static final int MULT=40;
	public static final int NEWLINE=41;
	public static final int NOT=42;
	public static final int NUMBER=43;
	public static final int OPEN=44;
	public static final int ORDER=45;
	public static final int PLUS=46;
	public static final int POST=47;
	public static final int PRE=48;
	public static final int PROGRAM=49;
	public static final int PROLOGARROW=50;
	public static final int RANDOM=51;
	public static final int RANDOMALL=52;
	public static final int SEMI=53;
	public static final int SINGLEQUOTE=54;
	public static final int SQCLOSE=55;
	public static final int SQOPEN=56;
	public static final int STOP=57;
	public static final int STRING=58;
	public static final int THEN=59;
	public static final int TRUE=60;
	public static final int UNNAMEDVAR=61;
	public static final int VAR=62;
	public static final int WS=63;

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



	// $ANTLR start "mas"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:54:1: mas returns [Abstract_MAS mas] : MAIN COLON i= id CURLYOPEN ( moduleImport |gm= module )+ CURLYCLOSE ;
	public final Abstract_MAS mas() throws RecognitionException {
		Abstract_MAS mas = null;


		String i =null;
		Abstract_GOALModule gm =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:2: ( MAIN COLON i= id CURLYOPEN ( moduleImport |gm= module )+ CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:4: MAIN COLON i= id CURLYOPEN ( moduleImport |gm= module )+ CURLYCLOSE
			{
			mas = new Abstract_MAS(); ArrayList<Abstract_GOALAgent> agents = new ArrayList<Abstract_GOALAgent>();
			match(input,MAIN,FOLLOW_MAIN_in_mas74); 
			match(input,COLON,FOLLOW_COLON_in_mas76); 
			pushFollow(FOLLOW_id_in_mas80);
			i=id();
			state._fsp--;

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_mas82); 
			 Abstract_GOALAgent gl = new Abstract_GOALAgent(i); agents.add(gl);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:2: ( moduleImport |gm= module )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==64) ) {
					alt1=1;
				}
				else if ( (LA1_0==EVENT||LA1_0==INIT||LA1_0==MAIN||LA1_0==MODULE) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:3: moduleImport
					{
					pushFollow(FOLLOW_moduleImport_in_mas89);
					moduleImport();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:18: gm= module
					{
					pushFollow(FOLLOW_module_in_mas95);
					gm=module();
					state._fsp--;

					gl.addModule(gm);
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_mas102); 
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
	// $ANTLR end "mas"



	// $ANTLR start "goalagent"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:1: goalagent returns [Abstract_GOALAgent gl] : MAIN COLON i= id CURLYOPEN ( moduleImport |gm= module )+ CURLYCLOSE ;
	public final Abstract_GOALAgent goalagent() throws RecognitionException {
		Abstract_GOALAgent gl = null;


		String i =null;
		Abstract_GOALModule gm =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:64:2: ( MAIN COLON i= id CURLYOPEN ( moduleImport |gm= module )+ CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:64:4: MAIN COLON i= id CURLYOPEN ( moduleImport |gm= module )+ CURLYCLOSE
			{
			match(input,MAIN,FOLLOW_MAIN_in_goalagent121); 
			match(input,COLON,FOLLOW_COLON_in_goalagent123); 
			pushFollow(FOLLOW_id_in_goalagent127);
			i=id();
			state._fsp--;

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_goalagent129); 
			 gl = new Abstract_GOALAgent(i);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:2: ( moduleImport |gm= module )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=3;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==64) ) {
					alt2=1;
				}
				else if ( (LA2_0==EVENT||LA2_0==INIT||LA2_0==MAIN||LA2_0==MODULE) ) {
					alt2=2;
				}

				switch (alt2) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:3: moduleImport
					{
					pushFollow(FOLLOW_moduleImport_in_goalagent136);
					moduleImport();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:18: gm= module
					{
					pushFollow(FOLLOW_module_in_goalagent142);
					gm=module();
					state._fsp--;

					gl.addModule(gm);
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_goalagent149); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return gl;
	}
	// $ANTLR end "goalagent"



	// $ANTLR start "moduleImport"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:1: moduleImport : '#import' MODULEFILE STOP ;
	public final void moduleImport() throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:71:2: ( '#import' MODULEFILE STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:71:4: '#import' MODULEFILE STOP
			{
			match(input,64,FOLLOW_64_in_moduleImport159); 
			match(input,MODULEFILE,FOLLOW_MODULEFILE_in_moduleImport161); 
			match(input,STOP,FOLLOW_STOP_in_moduleImport163); 
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
	// $ANTLR end "moduleImport"



	// $ANTLR start "module"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:1: module returns [Abstract_GOALModule gl] : def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE ;
	public final Abstract_GOALModule module() throws RecognitionException {
		Abstract_GOALModule gl = null;


		int def =0;
		ArrayList<Abstract_ActionSpec> as =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:2: (def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:4: def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE
			{
			pushFollow(FOLLOW_moduleDef_in_module180);
			def=moduleDef();
			state._fsp--;

			gl = new Abstract_GOALModule(def);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:56: ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==SQOPEN) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:57: SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE
					{
					match(input,SQOPEN,FOLLOW_SQOPEN_in_module185); 
					pushFollow(FOLLOW_moduleOption_in_module187);
					moduleOption(gl);
					state._fsp--;

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:81: ( COMMA moduleOption[gl] )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==COMMA) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:82: COMMA moduleOption[gl]
							{
							match(input,COMMA,FOLLOW_COMMA_in_module191); 
							pushFollow(FOLLOW_moduleOption_in_module193);
							moduleOption(gl);
							state._fsp--;

							}
							break;

						default :
							break loop3;
						}
					}

					match(input,SQCLOSE,FOLLOW_SQCLOSE_in_module198); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module203); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:12: ( krImport )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==64) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:12: krImport
					{
					pushFollow(FOLLOW_krImport_in_module205);
					krImport();
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:22: ( knowledge[gl] )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==KNOWLEDGE) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:22: knowledge[gl]
					{
					pushFollow(FOLLOW_knowledge_in_module208);
					knowledge(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:38: ( beliefs[gl] )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==BELIEFS) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:38: beliefs[gl]
					{
					pushFollow(FOLLOW_beliefs_in_module213);
					beliefs(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:51: ( goals[gl] )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==GOALS) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:51: goals[gl]
					{
					pushFollow(FOLLOW_goals_in_module217);
					goals(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:62: ( program[gl] )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==PROGRAM) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:62: program[gl]
					{
					pushFollow(FOLLOW_program_in_module221);
					program(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:77:2: (as= actionSpecs )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==ACTIONSPEC) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:77:3: as= actionSpecs
					{
					pushFollow(FOLLOW_actionSpecs_in_module230);
					as=actionSpecs();
					state._fsp--;

					gl.addAllCap(as);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module238); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return gl;
	}
	// $ANTLR end "module"



	// $ANTLR start "moduleDef"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:81:1: moduleDef returns [int i] : ( MODULE declaration | INIT MODULE | MAIN MODULE | EVENT MODULE );
	public final int moduleDef() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:2: ( MODULE declaration | INIT MODULE | MAIN MODULE | EVENT MODULE )
			int alt11=4;
			switch ( input.LA(1) ) {
			case MODULE:
				{
				alt11=1;
				}
				break;
			case INIT:
				{
				alt11=2;
				}
				break;
			case MAIN:
				{
				alt11=3;
				}
				break;
			case EVENT:
				{
				alt11=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:4: MODULE declaration
					{
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef253); 
					pushFollow(FOLLOW_declaration_in_moduleDef255);
					declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:83:4: INIT MODULE
					{
					match(input,INIT,FOLLOW_INIT_in_moduleDef260); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef262); 
					i = Abstract_GOALModule.init;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:4: MAIN MODULE
					{
					match(input,MAIN,FOLLOW_MAIN_in_moduleDef269); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef271); 
					i = Abstract_GOALModule.main;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:4: EVENT MODULE
					{
					match(input,EVENT,FOLLOW_EVENT_in_moduleDef278); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef280); 
					i = Abstract_GOALModule.event;
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
		return i;
	}
	// $ANTLR end "moduleDef"



	// $ANTLR start "moduleOption"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:89:1: moduleOption[Abstract_GOALModule gl] : (key= 'exit' EQUALS value= ( 'always' | 'never' | 'nogoals' | 'noaction' ) |key= 'focus' EQUALS value= ( 'none' | 'new' | 'select' | 'filter' ) );
	public final void moduleOption(Abstract_GOALModule gl) throws RecognitionException {
		Token key=null;
		Token value=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:2: (key= 'exit' EQUALS value= ( 'always' | 'never' | 'nogoals' | 'noaction' ) |key= 'focus' EQUALS value= ( 'none' | 'new' | 'select' | 'filter' ) )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==73) ) {
				alt13=1;
			}
			else if ( (LA13_0==76) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:4: key= 'exit' EQUALS value= ( 'always' | 'never' | 'nogoals' | 'noaction' )
					{
					key=(Token)match(input,73,FOLLOW_73_in_moduleOption299); 
					match(input,EQUALS,FOLLOW_EQUALS_in_moduleOption301); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:31: ( 'always' | 'never' | 'nogoals' | 'noaction' )
					int alt12=4;
					switch ( input.LA(1) ) {
					case 70:
						{
						alt12=1;
						}
						break;
					case 81:
						{
						alt12=2;
						}
						break;
					case 84:
						{
						alt12=3;
						}
						break;
					case 83:
						{
						alt12=4;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 12, 0, input);
						throw nvae;
					}
					switch (alt12) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:32: 'always'
							{
							value=(Token)match(input,70,FOLLOW_70_in_moduleOption308); 
							gl.setExitCondition(Abstract_GOALModule.always);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:6: 'never'
							{
							value=(Token)match(input,81,FOLLOW_81_in_moduleOption318); 
							gl.setExitCondition(Abstract_GOALModule.never);
							}
							break;
						case 3 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:92:6: 'nogoals'
							{
							value=(Token)match(input,84,FOLLOW_84_in_moduleOption328); 
							gl.setExitCondition(Abstract_GOALModule.nogoals);
							}
							break;
						case 4 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:93:7: 'noaction'
							{
							value=(Token)match(input,83,FOLLOW_83_in_moduleOption339); 
							gl.setExitCondition(Abstract_GOALModule.noaction);
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:4: key= 'focus' EQUALS value= ( 'none' | 'new' | 'select' | 'filter' )
					{
					key=(Token)match(input,76,FOLLOW_76_in_moduleOption353); 
					match(input,EQUALS,FOLLOW_EQUALS_in_moduleOption355); 
					value=input.LT(1);
					if ( input.LA(1)==75||input.LA(1)==82||input.LA(1)==85||input.LA(1)==87 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
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
	}
	// $ANTLR end "moduleOption"



	// $ANTLR start "krImport"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:1: krImport : '#import' ( stringLiteral | singleQuotedStringLiteral ) STOP ;
	public final void krImport() throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:98:2: ( '#import' ( stringLiteral | singleQuotedStringLiteral ) STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:98:4: '#import' ( stringLiteral | singleQuotedStringLiteral ) STOP
			{
			match(input,64,FOLLOW_64_in_krImport386); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:98:14: ( stringLiteral | singleQuotedStringLiteral )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==STRING) ) {
				alt14=1;
			}
			else if ( (LA14_0==SINGLEQUOTE) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:98:15: stringLiteral
					{
					pushFollow(FOLLOW_stringLiteral_in_krImport389);
					stringLiteral();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:98:31: singleQuotedStringLiteral
					{
					pushFollow(FOLLOW_singleQuotedStringLiteral_in_krImport393);
					singleQuotedStringLiteral();
					state._fsp--;

					}
					break;

			}

			match(input,STOP,FOLLOW_STOP_in_krImport396); 
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
	// $ANTLR end "krImport"



	// $ANTLR start "knowledge"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:101:1: knowledge[Abstract_GOALModule gl] : KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE ;
	public final void knowledge(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:2: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:4: KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE
			{
			match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_knowledge409); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_knowledge411); 
			pushFollow(FOLLOW_krspec_in_knowledge413);
			krspec(gl);
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_knowledge416); 
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
	// $ANTLR end "knowledge"



	// $ANTLR start "krspec"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:1: krspec[Abstract_GOALModule gl] : (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP ) )+ ;
	public final void krspec(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_Predicate hd =null;
		ArrayList<Abstract_LogicalFormula> body =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:31: ( (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP ) )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP ) )+
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP ) )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==CONST) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:34: hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP )
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_krspec428);
					hd=declarationOrCallWithTerms();
					state._fsp--;

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:106:2: ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:106:3: STOP
							{
							match(input,STOP,FOLLOW_STOP_in_krspec432); 
							gl.addFact((Abstract_Predicate) hd);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:2: PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_krspec439); 
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:14: (body= no_bracket_literals |body= forall_expr )
							int alt15=2;
							int LA15_0 = input.LA(1);
							if ( (LA15_0==CONST||LA15_0==MINUS||(LA15_0 >= NOT && LA15_0 <= NUMBER)||(LA15_0 >= UNNAMEDVAR && LA15_0 <= VAR)) ) {
								alt15=1;
							}
							else if ( (LA15_0==77) ) {
								alt15=2;
							}

							else {
								NoViableAltException nvae =
									new NoViableAltException("", 15, 0, input);
								throw nvae;
							}

							switch (alt15) {
								case 1 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:16: body= no_bracket_literals
									{
									pushFollow(FOLLOW_no_bracket_literals_in_krspec445);
									body=no_bracket_literals();
									state._fsp--;

									}
									break;
								case 2 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:43: body= forall_expr
									{
									pushFollow(FOLLOW_forall_expr_in_krspec451);
									body=forall_expr();
									state._fsp--;

									}
									break;

							}

							match(input,STOP,FOLLOW_STOP_in_krspec455); 
							gl.addKRule(new Abstract_Rule((Abstract_Predicate) hd, body));
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



	// $ANTLR start "beliefs"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:109:1: beliefs[Abstract_GOALModule gl] : BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE ;
	public final void beliefs(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:2: ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:4: BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE
			{
			match(input,BELIEFS,FOLLOW_BELIEFS_in_beliefs472); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_beliefs474); 
			pushFollow(FOLLOW_brspec_in_beliefs476);
			brspec(gl);
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_beliefs479); 
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
	// $ANTLR end "beliefs"



	// $ANTLR start "brspec"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:1: brspec[Abstract_GOALModule gl] : (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+ ;
	public final void brspec(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_Predicate hd =null;
		ArrayList<Abstract_LogicalFormula> body =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:31: ( (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+
			int cnt19=0;
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==CONST) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:34: hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP )
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_brspec491);
					hd=declarationOrCallWithTerms();
					state._fsp--;

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:114:2: ( STOP | PROLOGARROW body= no_bracket_literals STOP )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:114:3: STOP
							{
							match(input,STOP,FOLLOW_STOP_in_brspec495); 
							gl.addBel((Abstract_Predicate) hd);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:115:2: PROLOGARROW body= no_bracket_literals STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_brspec502); 
							pushFollow(FOLLOW_no_bracket_literals_in_brspec506);
							body=no_bracket_literals();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_brspec508); 
							gl.addRule(new Abstract_Rule((Abstract_Predicate) hd, body));
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



	// $ANTLR start "goals"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:118:1: goals[Abstract_GOALModule gl] : GOALS CURLYOPEN le= goal_list CURLYCLOSE ;
	public final void goals(Abstract_GOALModule gl) throws RecognitionException {
		ArrayList<ArrayList<Abstract_Term>> le =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:2: ( GOALS CURLYOPEN le= goal_list CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:4: GOALS CURLYOPEN le= goal_list CURLYCLOSE
			{
			match(input,GOALS,FOLLOW_GOALS_in_goals525); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_goals527); 
			pushFollow(FOLLOW_goal_list_in_goals531);
			le=goal_list();
			state._fsp--;

			gl.addGoal(le);
			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_goals535); 
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
	// $ANTLR end "goals"



	// $ANTLR start "atom"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:1: atom returns [Abstract_LogicalFormula l] : ( NOT OPEN p= declarationOrCallWithTerms CLOSE |p= declarationOrCallWithTerms |e= equation );
	public final Abstract_LogicalFormula atom() throws RecognitionException {
		Abstract_LogicalFormula l = null;


		Abstract_Predicate p =null;
		Abstract_Equation e =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:122:2: ( NOT OPEN p= declarationOrCallWithTerms CLOSE |p= declarationOrCallWithTerms |e= equation )
			int alt20=3;
			switch ( input.LA(1) ) {
			case NOT:
				{
				alt20=1;
				}
				break;
			case CONST:
				{
				alt20=2;
				}
				break;
			case MINUS:
			case NUMBER:
			case UNNAMEDVAR:
			case VAR:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:122:4: NOT OPEN p= declarationOrCallWithTerms CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_atom549); 
					match(input,OPEN,FOLLOW_OPEN_in_atom551); 
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_atom555);
					p=declarationOrCallWithTerms();
					state._fsp--;

					l = new Abstract_LogExpr(Abstract_LogExpr.not, p);
					match(input,CLOSE,FOLLOW_CLOSE_in_atom558); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_atom565);
					p=declarationOrCallWithTerms();
					state._fsp--;

					l =p;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:4: e= equation
					{
					pushFollow(FOLLOW_equation_in_atom574);
					e=equation();
					state._fsp--;

					l = e;
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
	// $ANTLR end "atom"



	// $ANTLR start "program"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:1: program[Abstract_GOALModule gl] : PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* ( programRule[gl] )* CURLYCLOSE ;
	public final void program(Abstract_GOALModule gl) throws RecognitionException {
		int i =0;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:2: ( PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* ( programRule[gl] )* CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:4: PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* ( programRule[gl] )* CURLYCLOSE
			{
			match(input,PROGRAM,FOLLOW_PROGRAM_in_program589); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:12: ( SQOPEN i= ruleEvaluationOrder SQCLOSE )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==SQOPEN) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:13: SQOPEN i= ruleEvaluationOrder SQCLOSE
					{
					match(input,SQOPEN,FOLLOW_SQOPEN_in_program592); 
					pushFollow(FOLLOW_ruleEvaluationOrder_in_program596);
					i=ruleEvaluationOrder();
					state._fsp--;

					gl.setOptionOrder(i);
					match(input,SQCLOSE,FOLLOW_SQCLOSE_in_program600); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program606); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:12: ( macroDef )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==HASH) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:12: macroDef
					{
					pushFollow(FOLLOW_macroDef_in_program608);
					macroDef();
					state._fsp--;

					}
					break;

				default :
					break loop22;
				}
			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:22: ( programRule[gl] )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==IF||LA23_0==77||LA23_0==79) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:22: programRule[gl]
					{
					pushFollow(FOLLOW_programRule_in_program611);
					programRule(gl);
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program615); 
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
	// $ANTLR end "program"



	// $ANTLR start "ruleEvaluationOrder"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:134:1: ruleEvaluationOrder returns [int i] : ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE ) ;
	public final int ruleEvaluationOrder() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:2: ( ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:4: ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE )
			{
			match(input,ORDER,FOLLOW_ORDER_in_ruleEvaluationOrder632); 
			match(input,EQUALS,FOLLOW_EQUALS_in_ruleEvaluationOrder634); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:17: ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE )
			int alt24=5;
			switch ( input.LA(1) ) {
			case LINEAR:
				{
				alt24=1;
				}
				break;
			case LINEARALL:
				{
				alt24=2;
				}
				break;
			case RANDOM:
				{
				alt24=3;
				}
				break;
			case RANDOMALL:
				{
				alt24=4;
				}
				break;
			case ADAPTIVE:
				{
				alt24=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}
			switch (alt24) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:19: LINEAR
					{
					match(input,LINEAR,FOLLOW_LINEAR_in_ruleEvaluationOrder638); 
					i =Abstract_GOALModule.linear;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:136:2: LINEARALL
					{
					match(input,LINEARALL,FOLLOW_LINEARALL_in_ruleEvaluationOrder645); 
					i =Abstract_GOALModule.linearall;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:137:2: RANDOM
					{
					match(input,RANDOM,FOLLOW_RANDOM_in_ruleEvaluationOrder651); 
					i =Abstract_GOALModule.random;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:138:2: RANDOMALL
					{
					match(input,RANDOMALL,FOLLOW_RANDOMALL_in_ruleEvaluationOrder657); 
					i =Abstract_GOALModule.randomall;
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:139:2: ADAPTIVE
					{
					match(input,ADAPTIVE,FOLLOW_ADAPTIVE_in_ruleEvaluationOrder664); 
					i = Abstract_GOALModule.adaptive;
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
	// $ANTLR end "ruleEvaluationOrder"



	// $ANTLR start "macroDef"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:1: macroDef : HASH DEFINE p= declarationOrCallWithTerms msc= mentalstate STOP ;
	public final void macroDef() throws RecognitionException {
		Abstract_Predicate p =null;
		Abstract_MentalState msc =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:2: ( HASH DEFINE p= declarationOrCallWithTerms msc= mentalstate STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:4: HASH DEFINE p= declarationOrCallWithTerms msc= mentalstate STOP
			{
			match(input,HASH,FOLLOW_HASH_in_macroDef678); 
			match(input,DEFINE,FOLLOW_DEFINE_in_macroDef680); 
			pushFollow(FOLLOW_declarationOrCallWithTerms_in_macroDef684);
			p=declarationOrCallWithTerms();
			state._fsp--;

			pushFollow(FOLLOW_mentalstate_in_macroDef689);
			msc=mentalstate();
			state._fsp--;

			PredicateIndicator pi = new PredicateIndicator(p.getFunctor(), p.getTermSize()); macros.put(pi, msc);
				macro_subs.put(pi, p);
			match(input,STOP,FOLLOW_STOP_in_macroDef695); 
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
	// $ANTLR end "macroDef"



	// $ANTLR start "programRule"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:1: programRule[Abstract_GOALModule gl] : ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[gl] ) | 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] ) ) ;
	public final void programRule(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_MentalState lf =null;
		ArrayList<Abstract_Deed> dl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:150:2: ( ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[gl] ) | 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] ) ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:150:3: ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[gl] ) | 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] ) )
			{
			Abstract_ActionRule rule = new Abstract_ActionRule();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:151:2: ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[gl] ) | 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] ) )
			int alt29=4;
			switch ( input.LA(1) ) {
			case IF:
				{
				alt29=1;
				}
				break;
			case 77:
				{
				alt29=2;
				}
				break;
			case 79:
				{
				int LA29_3 = input.LA(2);
				if ( (LA29_3==VAR) ) {
					int LA29_4 = input.LA(3);
					if ( (LA29_4==66) ) {
						alt29=3;
					}
					else if ( (LA29_4==STOP) ) {
						alt29=4;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 29, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA29_3==AGOAL||LA29_3==BEL||LA29_3==CONST||(LA29_3 >= GOAL && LA29_3 <= GOALA)||LA29_3==NOT||LA29_3==TRUE||(LA29_3 >= 68 && LA29_3 <= 69)||LA29_3==88||(LA29_3 >= 91 && LA29_3 <= 93)) ) {
					alt29=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 29, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}
			switch (alt29) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:151:3: IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] )
					{
					match(input,IF,FOLLOW_IF_in_programRule709); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule713);
					lf=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(lf);
					match(input,THEN,FOLLOW_THEN_in_programRule717); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:151:61: (dl= actions STOP | nestedRules[gl] )
					int alt25=2;
					int LA25_0 = input.LA(1);
					if ( (LA25_0==CONST||LA25_0==EVENT||LA25_0==INIT||LA25_0==MAIN||LA25_0==VAR||(LA25_0 >= 67 && LA25_0 <= 69)||(LA25_0 >= 71 && LA25_0 <= 72)||LA25_0==74||LA25_0==78||LA25_0==80||LA25_0==86||(LA25_0 >= 88 && LA25_0 <= 93)) ) {
						alt25=1;
					}
					else if ( (LA25_0==CURLYOPEN) ) {
						alt25=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 25, 0, input);
						throw nvae;
					}

					switch (alt25) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:151:63: dl= actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule723);
							dl=actions();
							state._fsp--;

							rule.setBody(dl);
							match(input,STOP,FOLLOW_STOP_in_programRule727); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:151:101: nestedRules[gl]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule731);
							nestedRules(gl);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:4: 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[gl] )
					{
					match(input,77,FOLLOW_77_in_programRule740); 
					rule.setType(ActionRule.foralldo);
					pushFollow(FOLLOW_mentalstatecond_in_programRule746);
					lf=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(lf);
					match(input,DO,FOLLOW_DO_in_programRule750); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:103: (dl= actions STOP | nestedRules[gl] )
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==CONST||LA26_0==EVENT||LA26_0==INIT||LA26_0==MAIN||LA26_0==VAR||(LA26_0 >= 67 && LA26_0 <= 69)||(LA26_0 >= 71 && LA26_0 <= 72)||LA26_0==74||LA26_0==78||LA26_0==80||LA26_0==86||(LA26_0 >= 88 && LA26_0 <= 93)) ) {
						alt26=1;
					}
					else if ( (LA26_0==CURLYOPEN) ) {
						alt26=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 26, 0, input);
						throw nvae;
					}

					switch (alt26) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:104: dl= actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule755);
							dl=actions();
							state._fsp--;

							rule.setBody(dl);
							match(input,STOP,FOLLOW_STOP_in_programRule759); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:142: nestedRules[gl]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule763);
							nestedRules(gl);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:4: 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] )
					{
					match(input,79,FOLLOW_79_in_programRule771); 
					match(input,VAR,FOLLOW_VAR_in_programRule773); 
					match(input,66,FOLLOW_66_in_programRule775); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule777);
					mentalstatecond();
					state._fsp--;

					match(input,DO,FOLLOW_DO_in_programRule779); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:42: ( actions STOP | nestedRules[gl] )
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==CONST||LA27_0==EVENT||LA27_0==INIT||LA27_0==MAIN||LA27_0==VAR||(LA27_0 >= 67 && LA27_0 <= 69)||(LA27_0 >= 71 && LA27_0 <= 72)||LA27_0==74||LA27_0==78||LA27_0==80||LA27_0==86||(LA27_0 >= 88 && LA27_0 <= 93)) ) {
						alt27=1;
					}
					else if ( (LA27_0==CURLYOPEN) ) {
						alt27=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 27, 0, input);
						throw nvae;
					}

					switch (alt27) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:43: actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule782);
							actions();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_programRule784); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:58: nestedRules[gl]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule788);
							nestedRules(gl);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:4: 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] )
					{
					match(input,79,FOLLOW_79_in_programRule797); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule799);
					mentalstatecond();
					state._fsp--;

					match(input,65,FOLLOW_65_in_programRule801); 
					match(input,VAR,FOLLOW_VAR_in_programRule803); 
					match(input,DO,FOLLOW_DO_in_programRule805); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:42: ( actions STOP | nestedRules[gl] )
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0==CONST||LA28_0==EVENT||LA28_0==INIT||LA28_0==MAIN||LA28_0==VAR||(LA28_0 >= 67 && LA28_0 <= 69)||(LA28_0 >= 71 && LA28_0 <= 72)||LA28_0==74||LA28_0==78||LA28_0==80||LA28_0==86||(LA28_0 >= 88 && LA28_0 <= 93)) ) {
						alt28=1;
					}
					else if ( (LA28_0==CURLYOPEN) ) {
						alt28=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 28, 0, input);
						throw nvae;
					}

					switch (alt28) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:43: actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule808);
							actions();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_programRule810); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:58: nestedRules[gl]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule814);
							nestedRules(gl);
							state._fsp--;

							}
							break;

					}

					}
					break;

			}

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
	// $ANTLR end "programRule"



	// $ANTLR start "nestedRules"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:157:1: nestedRules[Abstract_GOALModule gl] : CURLYOPEN ( programRule[gl] )+ CURLYCLOSE ;
	public final void nestedRules(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:158:2: ( CURLYOPEN ( programRule[gl] )+ CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:158:4: CURLYOPEN ( programRule[gl] )+ CURLYCLOSE
			{
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_nestedRules832); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:158:14: ( programRule[gl] )+
			int cnt30=0;
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==IF||LA30_0==77||LA30_0==79) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:158:14: programRule[gl]
					{
					pushFollow(FOLLOW_programRule_in_nestedRules834);
					programRule(gl);
					state._fsp--;

					}
					break;

				default :
					if ( cnt30 >= 1 ) break loop30;
					EarlyExitException eee = new EarlyExitException(30, input);
					throw eee;
				}
				cnt30++;
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_nestedRules838); 
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
	// $ANTLR end "nestedRules"



	// $ANTLR start "mentalstatecond"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:162:1: mentalstatecond returns [Abstract_MentalState lf] : ma= basicCondition ( COMMA ms2= basicCondition )* ;
	public final Abstract_MentalState mentalstatecond() throws RecognitionException {
		Abstract_MentalState lf = null;


		Abstract_MentalState ma =null;
		Abstract_MentalState ms2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:163:2: (ma= basicCondition ( COMMA ms2= basicCondition )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:163:4: ma= basicCondition ( COMMA ms2= basicCondition )*
			{
			pushFollow(FOLLOW_basicCondition_in_mentalstatecond856);
			ma=basicCondition();
			state._fsp--;

			Abstract_MentalState ms =  ma;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:2: ( COMMA ms2= basicCondition )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==COMMA) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:3: COMMA ms2= basicCondition
					{
					match(input,COMMA,FOLLOW_COMMA_in_mentalstatecond862); 
					pushFollow(FOLLOW_basicCondition_in_mentalstatecond866);
					ms2=basicCondition();
					state._fsp--;

					ms = new Abstract_MentalState(ms, Abstract_Guard.and, ms2);
					}
					break;

				default :
					break loop31;
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



	// $ANTLR start "mentalstate"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:1: mentalstate returns [Abstract_MentalState ms] : (ma= mentalatom | NOT OPEN mentalatom CLOSE | TRUE );
	public final Abstract_MentalState mentalstate() throws RecognitionException {
		Abstract_MentalState ms = null;


		Abstract_MentalState ma =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:168:2: (ma= mentalatom | NOT OPEN mentalatom CLOSE | TRUE )
			int alt32=3;
			switch ( input.LA(1) ) {
			case AGOAL:
			case BEL:
			case CONST:
			case GOAL:
			case GOALA:
			case VAR:
			case 68:
			case 69:
			case 88:
			case 91:
			case 92:
			case 93:
				{
				alt32=1;
				}
				break;
			case NOT:
				{
				alt32=2;
				}
				break;
			case TRUE:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:168:4: ma= mentalatom
					{
					pushFollow(FOLLOW_mentalatom_in_mentalstate889);
					ma=mentalatom();
					state._fsp--;

					ms = new Abstract_MentalState(ma);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:4: NOT OPEN mentalatom CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_mentalstate896); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalstate898); 
					pushFollow(FOLLOW_mentalatom_in_mentalstate900);
					mentalatom();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_mentalstate902); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:170:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_mentalstate907); 
					ms = new Abstract_MentalState();
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
		return ms;
	}
	// $ANTLR end "mentalstate"



	// $ANTLR start "basicCondition"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:1: basicCondition returns [Abstract_MentalState ms] : (ms1= mentalstate |p= declarationOrCallWithTerms );
	public final Abstract_MentalState basicCondition() throws RecognitionException {
		Abstract_MentalState ms = null;


		Abstract_MentalState ms1 =null;
		Abstract_Predicate p =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:2: (ms1= mentalstate |p= declarationOrCallWithTerms )
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==CONST) ) {
				int LA33_1 = input.LA(2);
				if ( (LA33_1==STOP) ) {
					alt33=1;
				}
				else if ( (LA33_1==COMMA||LA33_1==DO||LA33_1==OPEN||LA33_1==THEN||LA33_1==65) ) {
					alt33=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 33, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA33_0==AGOAL||LA33_0==BEL||(LA33_0 >= GOAL && LA33_0 <= GOALA)||LA33_0==NOT||LA33_0==TRUE||LA33_0==VAR||(LA33_0 >= 68 && LA33_0 <= 69)||LA33_0==88||(LA33_0 >= 91 && LA33_0 <= 93)) ) {
				alt33=1;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}

			switch (alt33) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:4: ms1= mentalstate
					{
					pushFollow(FOLLOW_mentalstate_in_basicCondition927);
					ms1=mentalstate();
					state._fsp--;

					ms = ms1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:175:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_basicCondition936);
					p=declarationOrCallWithTerms();
					state._fsp--;

					PredicateIndicator pi = new PredicateIndicator(p.getFunctor(), p.getTermSize());
							Abstract_MentalState macro=macros.get(pi);
							Abstract_Term sub=macro_subs.get(pi);
							Abstract_MentalState k = new Abstract_MentalState(macro, sub, p); ms = k;
						
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
		return ms;
	}
	// $ANTLR end "basicCondition"



	// $ANTLR start "mentalatom"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:1: mentalatom returns [Abstract_MentalState ms] : ( selector STOP )? b= mentalOperator tl= atom_parameters ;
	public final Abstract_MentalState mentalatom() throws RecognitionException {
		Abstract_MentalState ms = null;


		byte b =0;
		Abstract_LogExpr tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:183:2: ( ( selector STOP )? b= mentalOperator tl= atom_parameters )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:184:2: ( selector STOP )? b= mentalOperator tl= atom_parameters
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:184:2: ( selector STOP )?
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==CONST||LA34_0==VAR||(LA34_0 >= 68 && LA34_0 <= 69)||LA34_0==88||(LA34_0 >= 91 && LA34_0 <= 93)) ) {
				alt34=1;
			}
			switch (alt34) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:184:3: selector STOP
					{
					pushFollow(FOLLOW_selector_in_mentalatom956);
					selector();
					state._fsp--;

					match(input,STOP,FOLLOW_STOP_in_mentalatom958); 
					}
					break;

			}

			pushFollow(FOLLOW_mentalOperator_in_mentalatom964);
			b=mentalOperator();
			state._fsp--;

			pushFollow(FOLLOW_atom_parameters_in_mentalatom968);
			tl=atom_parameters();
			state._fsp--;

			 if (b == Abstract_MentalAtom.agoal) {
				      Abstract_MentalAtom g = new Abstract_MentalAtom(tl, Abstract_BaseAILStructure.AILGoal);
				      Abstract_MentalAtom bl = new Abstract_MentalAtom(tl, Abstract_BaseAILStructure.AILBel);
				      ms = new Abstract_MentalState(new Abstract_MentalState(g), Abstract_Guard.and, new Abstract_MentalState(Abstract_Guard.not, bl));
				   } else if (b == Abstract_MentalAtom.goala) {
				      Abstract_MentalAtom g = new Abstract_MentalAtom(tl, Abstract_BaseAILStructure.AILGoal);
				      Abstract_MentalAtom bl = new Abstract_MentalAtom(tl, Abstract_BaseAILStructure.AILBel);
				      ms = new Abstract_MentalState(new Abstract_MentalState(g), Abstract_Guard.and, new Abstract_MentalState(bl));
				   } else {ms = new Abstract_MentalState(new Abstract_MentalAtom(tl, b));}
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ms;
	}
	// $ANTLR end "mentalatom"



	// $ANTLR start "atom_parameters"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:1: atom_parameters returns [Abstract_LogExpr ts] : OPEN (t= atom ( COMMA t1= atom | SEMI t1= atom )* |ap= atom_parameters ) CLOSE ;
	public final Abstract_LogExpr atom_parameters() throws RecognitionException {
		Abstract_LogExpr ts = null;


		Abstract_LogicalFormula t =null;
		Abstract_LogicalFormula t1 =null;
		Abstract_LogExpr ap =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:198:2: ( OPEN (t= atom ( COMMA t1= atom | SEMI t1= atom )* |ap= atom_parameters ) CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:198:4: OPEN (t= atom ( COMMA t1= atom | SEMI t1= atom )* |ap= atom_parameters ) CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_atom_parameters987); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:198:9: (t= atom ( COMMA t1= atom | SEMI t1= atom )* |ap= atom_parameters )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==CONST||LA36_0==MINUS||(LA36_0 >= NOT && LA36_0 <= NUMBER)||(LA36_0 >= UNNAMEDVAR && LA36_0 <= VAR)) ) {
				alt36=1;
			}
			else if ( (LA36_0==OPEN) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:3: t= atom ( COMMA t1= atom | SEMI t1= atom )*
					{
					pushFollow(FOLLOW_atom_in_atom_parameters996);
					t=atom();
					state._fsp--;

					Abstract_LogExpr tl = new Abstract_LogExpr(Abstract_LogExpr.none, t);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:2: ( COMMA t1= atom | SEMI t1= atom )*
					loop35:
					while (true) {
						int alt35=3;
						int LA35_0 = input.LA(1);
						if ( (LA35_0==COMMA) ) {
							alt35=1;
						}
						else if ( (LA35_0==SEMI) ) {
							alt35=2;
						}

						switch (alt35) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:3: COMMA t1= atom
							{
							match(input,COMMA,FOLLOW_COMMA_in_atom_parameters1002); 
							pushFollow(FOLLOW_atom_in_atom_parameters1007);
							t1=atom();
							state._fsp--;

							tl = new Abstract_LogExpr(tl, Abstract_LogExpr.and,  t1);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:4: SEMI t1= atom
							{
							match(input,SEMI,FOLLOW_SEMI_in_atom_parameters1014); 
							pushFollow(FOLLOW_atom_in_atom_parameters1021);
							t1=atom();
							state._fsp--;

							tl = new Abstract_LogExpr(tl, Abstract_LogExpr.or,  t1);
							}
							break;

						default :
							break loop35;
						}
					}

					 ts = tl;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:5: ap= atom_parameters
					{
					pushFollow(FOLLOW_atom_parameters_in_atom_parameters1038);
					ap=atom_parameters();
					state._fsp--;

					ts = ap;
					}
					break;

			}

			match(input,CLOSE,FOLLOW_CLOSE_in_atom_parameters1046); 
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
	// $ANTLR end "atom_parameters"



	// $ANTLR start "mentalOperator"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:1: mentalOperator returns [byte b] : (op= BEL |op= GOAL |op= AGOAL |op= GOALA );
	public final byte mentalOperator() throws RecognitionException {
		byte b = 0;


		Token op=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:209:2: (op= BEL |op= GOAL |op= AGOAL |op= GOALA )
			int alt37=4;
			switch ( input.LA(1) ) {
			case BEL:
				{
				alt37=1;
				}
				break;
			case GOAL:
				{
				alt37=2;
				}
				break;
			case AGOAL:
				{
				alt37=3;
				}
				break;
			case GOALA:
				{
				alt37=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 37, 0, input);
				throw nvae;
			}
			switch (alt37) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:209:4: op= BEL
					{
					op=(Token)match(input,BEL,FOLLOW_BEL_in_mentalOperator1067); 
					b = Abstract_BaseAILStructure.AILBel;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:4: op= GOAL
					{
					op=(Token)match(input,GOAL,FOLLOW_GOAL_in_mentalOperator1078); 
					b = Abstract_BaseAILStructure.AILGoal;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:211:4: op= AGOAL
					{
					op=(Token)match(input,AGOAL,FOLLOW_AGOAL_in_mentalOperator1089); 
					b = Abstract_MentalAtom.agoal;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:212:4: op= GOALA
					{
					op=(Token)match(input,GOALA,FOLLOW_GOALA_in_mentalOperator1100); 
					b = Abstract_MentalAtom.goala;
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
		return b;
	}
	// $ANTLR end "mentalOperator"



	// $ANTLR start "actions"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:1: actions returns [ArrayList<Abstract_Deed> dl] :a= action ( PLUS a1= action )* ;
	public final ArrayList<Abstract_Deed> actions() throws RecognitionException {
		ArrayList<Abstract_Deed> dl = null;


		Abstract_Deed a =null;
		Abstract_Deed a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:216:2: (a= action ( PLUS a1= action )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:216:4: a= action ( PLUS a1= action )*
			{
			dl = new ArrayList<Abstract_Deed>();
			pushFollow(FOLLOW_action_in_actions1123);
			a=action();
			state._fsp--;

			dl.add(a);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:218:2: ( PLUS a1= action )*
			loop38:
			while (true) {
				int alt38=2;
				int LA38_0 = input.LA(1);
				if ( (LA38_0==PLUS) ) {
					alt38=1;
				}

				switch (alt38) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:218:3: PLUS a1= action
					{
					match(input,PLUS,FOLLOW_PLUS_in_actions1130); 
					pushFollow(FOLLOW_action_in_actions1134);
					a1=action();
					state._fsp--;

					dl.add(a1);
					}
					break;

				default :
					break loop38;
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
	// $ANTLR end "actions"



	// $ANTLR start "action"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:221:1: action returns [Abstract_Deed d] : ( ( selector STOP )? d1= actionOperator tl= parameters |op= 'exit-module' |op= 'log' |op= INIT |op= MAIN |op= EVENT |p= declarationOrCallWithTerms );
	public final Abstract_Deed action() throws RecognitionException {
		Abstract_Deed d = null;


		Token op=null;
		Abstract_Deed d1 =null;
		ArrayList<Abstract_Term> tl =null;
		Abstract_Predicate p =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:222:2: ( ( selector STOP )? d1= actionOperator tl= parameters |op= 'exit-module' |op= 'log' |op= INIT |op= MAIN |op= EVENT |p= declarationOrCallWithTerms )
			int alt40=7;
			switch ( input.LA(1) ) {
			case CONST:
				{
				int LA40_1 = input.LA(2);
				if ( (LA40_1==STOP) ) {
					int LA40_8 = input.LA(3);
					if ( (LA40_8==67||(LA40_8 >= 71 && LA40_8 <= 72)||LA40_8==78||LA40_8==80||LA40_8==86||(LA40_8 >= 89 && LA40_8 <= 90)) ) {
						alt40=1;
					}
					else if ( (LA40_8==CURLYCLOSE||LA40_8==IF||LA40_8==77||LA40_8==79) ) {
						alt40=7;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 40, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA40_1==OPEN||LA40_1==PLUS) ) {
					alt40=7;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 40, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case VAR:
			case 67:
			case 68:
			case 69:
			case 71:
			case 72:
			case 78:
			case 86:
			case 88:
			case 89:
			case 90:
			case 91:
			case 92:
			case 93:
				{
				alt40=1;
				}
				break;
			case 80:
				{
				int LA40_3 = input.LA(2);
				if ( (LA40_3==OPEN) ) {
					alt40=1;
				}
				else if ( (LA40_3==PLUS||LA40_3==STOP) ) {
					alt40=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 40, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 74:
				{
				alt40=2;
				}
				break;
			case INIT:
				{
				alt40=4;
				}
				break;
			case MAIN:
				{
				alt40=5;
				}
				break;
			case EVENT:
				{
				alt40=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}
			switch (alt40) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:222:4: ( selector STOP )? d1= actionOperator tl= parameters
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:222:4: ( selector STOP )?
					int alt39=2;
					int LA39_0 = input.LA(1);
					if ( (LA39_0==CONST||LA39_0==VAR||(LA39_0 >= 68 && LA39_0 <= 69)||LA39_0==88||(LA39_0 >= 91 && LA39_0 <= 93)) ) {
						alt39=1;
					}
					switch (alt39) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:222:5: selector STOP
							{
							pushFollow(FOLLOW_selector_in_action1154);
							selector();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_action1156); 
							}
							break;

					}

					pushFollow(FOLLOW_actionOperator_in_action1162);
					d1=actionOperator();
					state._fsp--;

					pushFollow(FOLLOW_parameters_in_action1166);
					tl=parameters();
					state._fsp--;

					d1.addParams(tl); d =d1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:224:4: op= 'exit-module'
					{
					op=(Token)match(input,74,FOLLOW_74_in_action1178); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:225:4: op= 'log'
					{
					op=(Token)match(input,80,FOLLOW_80_in_action1187); 
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:226:4: op= INIT
					{
					op=(Token)match(input,INIT,FOLLOW_INIT_in_action1196); 
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:227:4: op= MAIN
					{
					op=(Token)match(input,MAIN,FOLLOW_MAIN_in_action1205); 
					}
					break;
				case 6 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:228:4: op= EVENT
					{
					op=(Token)match(input,EVENT,FOLLOW_EVENT_in_action1214); 
					}
					break;
				case 7 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:229:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_action1221);
					p=declarationOrCallWithTerms();
					state._fsp--;

					d = new Abstract_Deed(p);
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
		return d;
	}
	// $ANTLR end "action"



	// $ANTLR start "actionOperator"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:232:1: actionOperator returns [Abstract_Deed d] : (op= 'adopt' |op= 'drop' |op= 'insert' |op= 'delete' |op= 'send' |op= 'sendonce' |op= 'print' |op= 'log' );
	public final Abstract_Deed actionOperator() throws RecognitionException {
		Abstract_Deed d = null;


		Token op=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:233:2: (op= 'adopt' |op= 'drop' |op= 'insert' |op= 'delete' |op= 'send' |op= 'sendonce' |op= 'print' |op= 'log' )
			int alt41=8;
			switch ( input.LA(1) ) {
			case 67:
				{
				alt41=1;
				}
				break;
			case 72:
				{
				alt41=2;
				}
				break;
			case 78:
				{
				alt41=3;
				}
				break;
			case 71:
				{
				alt41=4;
				}
				break;
			case 89:
				{
				alt41=5;
				}
				break;
			case 90:
				{
				alt41=6;
				}
				break;
			case 86:
				{
				alt41=7;
				}
				break;
			case 80:
				{
				alt41=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}
			switch (alt41) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:233:4: op= 'adopt'
					{
					op=(Token)match(input,67,FOLLOW_67_in_actionOperator1242); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, Abstract_BaseAILStructure.AILGoal);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:234:4: op= 'drop'
					{
					op=(Token)match(input,72,FOLLOW_72_in_actionOperator1253); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILDeletion, Abstract_BaseAILStructure.AILGoal);
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:235:4: op= 'insert'
					{
					op=(Token)match(input,78,FOLLOW_78_in_actionOperator1264); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, Abstract_BaseAILStructure.AILBel);
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:236:4: op= 'delete'
					{
					op=(Token)match(input,71,FOLLOW_71_in_actionOperator1275); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILDeletion, Abstract_BaseAILStructure.AILBel);
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:237:4: op= 'send'
					{
					op=(Token)match(input,89,FOLLOW_89_in_actionOperator1287); 
					}
					break;
				case 6 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:238:4: op= 'sendonce'
					{
					op=(Token)match(input,90,FOLLOW_90_in_actionOperator1296); 
					}
					break;
				case 7 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:239:4: op= 'print'
					{
					op=(Token)match(input,86,FOLLOW_86_in_actionOperator1305); 
					d = new Abstract_Deed(new Abstract_PrintAction());
					}
					break;
				case 8 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:240:4: op= 'log'
					{
					op=(Token)match(input,80,FOLLOW_80_in_actionOperator1316); 
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
		return d;
	}
	// $ANTLR end "actionOperator"



	// $ANTLR start "selector"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:244:1: selector : ( word |op= 'all' |op= 'allother' |op= 'self' |op= 'some' |op= 'someother' |op= 'this' );
	public final void selector() throws RecognitionException {
		Token op=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:245:2: ( word |op= 'all' |op= 'allother' |op= 'self' |op= 'some' |op= 'someother' |op= 'this' )
			int alt42=7;
			switch ( input.LA(1) ) {
			case CONST:
			case VAR:
				{
				alt42=1;
				}
				break;
			case 68:
				{
				alt42=2;
				}
				break;
			case 69:
				{
				alt42=3;
				}
				break;
			case 88:
				{
				alt42=4;
				}
				break;
			case 91:
				{
				alt42=5;
				}
				break;
			case 92:
				{
				alt42=6;
				}
				break;
			case 93:
				{
				alt42=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 42, 0, input);
				throw nvae;
			}
			switch (alt42) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:245:4: word
					{
					pushFollow(FOLLOW_word_in_selector1328);
					word();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:246:4: op= 'all'
					{
					op=(Token)match(input,68,FOLLOW_68_in_selector1337); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:247:4: op= 'allother'
					{
					op=(Token)match(input,69,FOLLOW_69_in_selector1346); 
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:248:4: op= 'self'
					{
					op=(Token)match(input,88,FOLLOW_88_in_selector1355); 
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:249:4: op= 'some'
					{
					op=(Token)match(input,91,FOLLOW_91_in_selector1364); 
					}
					break;
				case 6 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:250:4: op= 'someother'
					{
					op=(Token)match(input,92,FOLLOW_92_in_selector1373); 
					}
					break;
				case 7 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:251:4: op= 'this'
					{
					op=(Token)match(input,93,FOLLOW_93_in_selector1382); 
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
	// $ANTLR end "selector"



	// $ANTLR start "actionSpecs"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:254:1: actionSpecs returns [ArrayList<Abstract_ActionSpec> as] : ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE ;
	public final ArrayList<Abstract_ActionSpec> actionSpecs() throws RecognitionException {
		ArrayList<Abstract_ActionSpec> as = null;


		Abstract_ActionSpec a =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:255:2: ( ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:255:4: ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE
			{
			as = new ArrayList<Abstract_ActionSpec>();
			match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_actionSpecs1401); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionSpecs1403); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:256:23: (a= actionSpec )+
			int cnt43=0;
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( (LA43_0==CONST) ) {
					alt43=1;
				}

				switch (alt43) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:256:24: a= actionSpec
					{
					pushFollow(FOLLOW_actionSpec_in_actionSpecs1408);
					a=actionSpec();
					state._fsp--;

					as.add(a);
					}
					break;

				default :
					if ( cnt43 >= 1 ) break loop43;
					EarlyExitException eee = new EarlyExitException(43, input);
					throw eee;
				}
				cnt43++;
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionSpecs1414); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return as;
	}
	// $ANTLR end "actionSpecs"



	// $ANTLR start "actionSpec"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:259:1: actionSpec returns [Abstract_ActionSpec as] :cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE ;
	public final Abstract_ActionSpec actionSpec() throws RecognitionException {
		Abstract_ActionSpec as = null;


		Abstract_Predicate cap =null;
		Abstract_LogicalFormula pre =null;
		Abstract_LogicalFormula post =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:260:2: (cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:260:4: cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE
			{
			boolean internal=false;
			pushFollow(FOLLOW_declarationOrCallWithTerms_in_actionSpec1433);
			cap=declarationOrCallWithTerms();
			state._fsp--;

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:260:61: ( INTERNAL | EXTERNAL )?
			int alt44=3;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==INTERNAL) ) {
				alt44=1;
			}
			else if ( (LA44_0==EXTERNAL) ) {
				alt44=2;
			}
			switch (alt44) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:260:62: INTERNAL
					{
					match(input,INTERNAL,FOLLOW_INTERNAL_in_actionSpec1436); 
					internal = true;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:260:92: EXTERNAL
					{
					match(input,EXTERNAL,FOLLOW_EXTERNAL_in_actionSpec1442); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionSpec1448); 
			pushFollow(FOLLOW_precondition_in_actionSpec1452);
			pre=precondition();
			state._fsp--;

			pushFollow(FOLLOW_postcondition_in_actionSpec1456);
			post=postcondition();
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionSpec1458); 
			as = new Abstract_ActionSpec(cap, pre, post, internal);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return as;
	}
	// $ANTLR end "actionSpec"



	// $ANTLR start "precondition"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:265:1: precondition returns [Abstract_LogicalFormula f] : PRE CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE ;
	public final Abstract_LogicalFormula precondition() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		ArrayList<Abstract_LogicalFormula> tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:266:2: ( PRE CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:266:4: PRE CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE
			{
			match(input,PRE,FOLLOW_PRE_in_precondition1476); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_precondition1478); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:266:19: ( TRUE |tl= no_bracket_literals )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==TRUE) ) {
				alt45=1;
			}
			else if ( (LA45_0==CONST||LA45_0==MINUS||(LA45_0 >= NOT && LA45_0 <= NUMBER)||(LA45_0 >= UNNAMEDVAR && LA45_0 <= VAR)) ) {
				alt45=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}

			switch (alt45) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:266:20: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_precondition1482); 
					f = new Abstract_LogExpr();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:267:4: tl= no_bracket_literals
					{
					pushFollow(FOLLOW_no_bracket_literals_in_precondition1492);
					tl=no_bracket_literals();
					state._fsp--;

					f = new Abstract_LogExpr(tl);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_precondition1497); 
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
	// $ANTLR end "precondition"



	// $ANTLR start "postcondition"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:270:1: postcondition returns [Abstract_LogicalFormula f] : POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE ;
	public final Abstract_LogicalFormula postcondition() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		ArrayList<Abstract_LogicalFormula> tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:271:2: ( POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:271:4: POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE
			{
			match(input,POST,FOLLOW_POST_in_postcondition1512); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_postcondition1515); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:272:2: ( TRUE |tl= no_bracket_literals )
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==TRUE) ) {
				alt46=1;
			}
			else if ( (LA46_0==CONST||LA46_0==MINUS||(LA46_0 >= NOT && LA46_0 <= NUMBER)||(LA46_0 >= UNNAMEDVAR && LA46_0 <= VAR)) ) {
				alt46=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}

			switch (alt46) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:272:3: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_postcondition1519); 
					f = new Abstract_LogExpr();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:273:4: tl= no_bracket_literals
					{
					pushFollow(FOLLOW_no_bracket_literals_in_postcondition1529);
					tl=no_bracket_literals();
					state._fsp--;


							f = new Abstract_LogExpr(tl);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_postcondition1538); 
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
	// $ANTLR end "postcondition"



	// $ANTLR start "declaration"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:279:1: declaration returns [Abstract_Predicate p] : f= id (tl= parameters )? ;
	public final Abstract_Predicate declaration() throws RecognitionException {
		Abstract_Predicate p = null;


		String f =null;
		ArrayList<Abstract_Term> tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:280:2: (f= id (tl= parameters )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:280:4: f= id (tl= parameters )?
			{
			pushFollow(FOLLOW_id_in_declaration1555);
			f=id();
			state._fsp--;

			p= new Abstract_Predicate(f);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:280:41: (tl= parameters )?
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==OPEN) ) {
				alt47=1;
			}
			switch (alt47) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:280:42: tl= parameters
					{
					pushFollow(FOLLOW_parameters_in_declaration1562);
					tl=parameters();
					state._fsp--;

					p.setTerms(tl);
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
		return p;
	}
	// $ANTLR end "declaration"



	// $ANTLR start "declarationOrCallWithTerms"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:283:1: declarationOrCallWithTerms returns [Abstract_Predicate p] : f= function_term ;
	public final Abstract_Predicate declarationOrCallWithTerms() throws RecognitionException {
		Abstract_Predicate p = null;


		Abstract_Term f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:284:2: (f= function_term )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:284:4: f= function_term
			{
			pushFollow(FOLLOW_function_term_in_declarationOrCallWithTerms1583);
			f=function_term();
			state._fsp--;

			p = (Abstract_Predicate) f;
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
	// $ANTLR end "declarationOrCallWithTerms"



	// $ANTLR start "id"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:287:1: id returns [String s] : ( CONST | VAR ) ;
	public final String id() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:288:2: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:288:4: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:288:4: ( CONST | VAR )
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==CONST) ) {
				alt48=1;
			}
			else if ( (LA48_0==VAR) ) {
				alt48=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}

			switch (alt48) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:288:5: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_id1602); 
					s = CONST1.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:289:4: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_id1609); 
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



	// $ANTLR start "parameters"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:293:1: parameters returns [ArrayList<Abstract_Term>ts] : OPEN t= term ( COMMA t1= term )* CLOSE ;
	public final ArrayList<Abstract_Term> parameters() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:294:2: ( OPEN t= term ( COMMA t1= term )* CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:294:4: OPEN t= term ( COMMA t1= term )* CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_parameters1632); 
			pushFollow(FOLLOW_term_in_parameters1636);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:295:2: ( COMMA t1= term )*
			loop49:
			while (true) {
				int alt49=2;
				int LA49_0 = input.LA(1);
				if ( (LA49_0==COMMA) ) {
					alt49=1;
				}

				switch (alt49) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:295:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_parameters1642); 
					pushFollow(FOLLOW_term_in_parameters1646);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop49;
				}
			}

			match(input,CLOSE,FOLLOW_CLOSE_in_parameters1654); 
			 ts = tl;
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



	// $ANTLR start "no_bracket_parameters"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:299:1: no_bracket_parameters returns [ArrayList<Abstract_Term>ts] : t= term ( COMMA t1= term )* ;
	public final ArrayList<Abstract_Term> no_bracket_parameters() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:300:2: (t= term ( COMMA t1= term )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:300:5: t= term ( COMMA t1= term )*
			{
			pushFollow(FOLLOW_term_in_no_bracket_parameters1676);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:301:2: ( COMMA t1= term )*
			loop50:
			while (true) {
				int alt50=2;
				int LA50_0 = input.LA(1);
				if ( (LA50_0==COMMA) ) {
					alt50=1;
				}

				switch (alt50) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:301:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_no_bracket_parameters1682); 
					pushFollow(FOLLOW_term_in_no_bracket_parameters1686);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop50;
				}
			}

			 ts = tl;
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
	// $ANTLR end "no_bracket_parameters"



	// $ANTLR start "no_bracket_literals"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:305:1: no_bracket_literals returns [ArrayList<Abstract_LogicalFormula>ts] :t= atom ( COMMA t1= atom )* ;
	public final ArrayList<Abstract_LogicalFormula> no_bracket_literals() throws RecognitionException {
		ArrayList<Abstract_LogicalFormula> ts = null;


		Abstract_LogicalFormula t =null;
		Abstract_LogicalFormula t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:306:2: (t= atom ( COMMA t1= atom )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:306:5: t= atom ( COMMA t1= atom )*
			{
			ArrayList<Abstract_LogicalFormula> tl = new ArrayList<Abstract_LogicalFormula>();
			pushFollow(FOLLOW_atom_in_no_bracket_literals1717);
			t=atom();
			state._fsp--;

			 tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:308:2: ( COMMA t1= atom )*
			loop51:
			while (true) {
				int alt51=2;
				int LA51_0 = input.LA(1);
				if ( (LA51_0==COMMA) ) {
					alt51=1;
				}

				switch (alt51) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:308:3: COMMA t1= atom
					{
					match(input,COMMA,FOLLOW_COMMA_in_no_bracket_literals1723); 
					pushFollow(FOLLOW_atom_in_no_bracket_literals1730);
					t1=atom();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop51;
				}
			}

			 ts = tl;
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
	// $ANTLR end "no_bracket_literals"



	// $ANTLR start "forall_expr"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:312:1: forall_expr returns [ArrayList<Abstract_LogicalFormula> ts] : 'forall' OPEN t1= atom COMMA t2= atom CLOSE ;
	public final ArrayList<Abstract_LogicalFormula> forall_expr() throws RecognitionException {
		ArrayList<Abstract_LogicalFormula> ts = null;


		Abstract_LogicalFormula t1 =null;
		Abstract_LogicalFormula t2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:313:2: ( 'forall' OPEN t1= atom COMMA t2= atom CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:313:5: 'forall' OPEN t1= atom COMMA t2= atom CLOSE
			{
			ArrayList<Abstract_LogicalFormula> tl = new ArrayList<Abstract_LogicalFormula>();
			match(input,77,FOLLOW_77_in_forall_expr1757); 
			match(input,OPEN,FOLLOW_OPEN_in_forall_expr1759); 
			pushFollow(FOLLOW_atom_in_forall_expr1763);
			t1=atom();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_forall_expr1765); 
			pushFollow(FOLLOW_atom_in_forall_expr1769);
			t2=atom();
			state._fsp--;

			Abstract_LogExpr l = new Abstract_LogExpr(t1, Abstract_LogExpr.forall, t2); tl.add(l);
			match(input,CLOSE,FOLLOW_CLOSE_in_forall_expr1773); 
			 ts = tl;
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
	// $ANTLR end "forall_expr"



	// $ANTLR start "goal_list"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:319:1: goal_list returns [ArrayList<ArrayList<Abstract_Term>>ts] : (t= term ( COMMA t1= term )* STOP )+ ;
	public final ArrayList<ArrayList<Abstract_Term>> goal_list() throws RecognitionException {
		ArrayList<ArrayList<Abstract_Term>> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:320:2: ( (t= term ( COMMA t1= term )* STOP )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:320:4: (t= term ( COMMA t1= term )* STOP )+
			{
			ArrayList<ArrayList<Abstract_Term>> tll = new ArrayList<ArrayList<Abstract_Term>>();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:321:2: (t= term ( COMMA t1= term )* STOP )+
			int cnt53=0;
			loop53:
			while (true) {
				int alt53=2;
				int LA53_0 = input.LA(1);
				if ( (LA53_0==CONST||LA53_0==MINUS||LA53_0==NUMBER||LA53_0==SQOPEN||LA53_0==STRING||(LA53_0 >= UNNAMEDVAR && LA53_0 <= VAR)) ) {
					alt53=1;
				}

				switch (alt53) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:321:3: t= term ( COMMA t1= term )* STOP
					{
					pushFollow(FOLLOW_term_in_goal_list1799);
					t=term();
					state._fsp--;

					ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:322:2: ( COMMA t1= term )*
					loop52:
					while (true) {
						int alt52=2;
						int LA52_0 = input.LA(1);
						if ( (LA52_0==COMMA) ) {
							alt52=1;
						}

						switch (alt52) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:322:3: COMMA t1= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_goal_list1806); 
							pushFollow(FOLLOW_term_in_goal_list1810);
							t1=term();
							state._fsp--;

							tl.add(t1);
							}
							break;

						default :
							break loop52;
						}
					}

					match(input,STOP,FOLLOW_STOP_in_goal_list1817); 
					tll.add(tl);
					}
					break;

				default :
					if ( cnt53 >= 1 ) break loop53;
					EarlyExitException eee = new EarlyExitException(53, input);
					throw eee;
				}
				cnt53++;
			}

			 ts = tll;
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
	// $ANTLR end "goal_list"



	// $ANTLR start "term"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:367:1: term returns [Abstract_Term t] : (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) ;
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_StringTerm st =null;
		Abstract_Term ft =null;
		Abstract_NumberTerm at =null;
		Abstract_ListTermImpl lt =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:368:2: ( (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:368:4: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:368:4: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			int alt54=4;
			switch ( input.LA(1) ) {
			case STRING:
				{
				alt54=1;
				}
				break;
			case CONST:
				{
				alt54=2;
				}
				break;
			case MINUS:
			case NUMBER:
			case UNNAMEDVAR:
			case VAR:
				{
				alt54=3;
				}
				break;
			case SQOPEN:
				{
				alt54=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 54, 0, input);
				throw nvae;
			}
			switch (alt54) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:368:5: st= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term2107);
					st=stringterm();
					state._fsp--;

					t = st;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:369:4: ft= function_term
					{
					pushFollow(FOLLOW_function_term_in_term2117);
					ft=function_term();
					state._fsp--;

					t =ft;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:370:4: at= arithexpr
					{
					pushFollow(FOLLOW_arithexpr_in_term2127);
					at=arithexpr();
					state._fsp--;

					t =at;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:371:4: lt= listterm
					{
					pushFollow(FOLLOW_listterm_in_term2136);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:373:1: function_term returns [Abstract_Term t] : c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? ;
	public final Abstract_Term function_term() throws RecognitionException {
		Abstract_Term t = null;


		Token c=null;
		Abstract_Term t1 =null;
		Abstract_Term t2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:374:2: (c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:374:4: c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			{
			c=(Token)match(input,CONST,FOLLOW_CONST_in_function_term2154); 
			t=new Abstract_Predicate(c.getText());
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:375:2: ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==OPEN) ) {
				alt56=1;
			}
			switch (alt56) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:375:3: OPEN t1= term ( COMMA t2= term )* CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function_term2161); 
					pushFollow(FOLLOW_term_in_function_term2165);
					t1=term();
					state._fsp--;

					((Abstract_Predicate) t).addTerm(t1);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:376:2: ( COMMA t2= term )*
					loop55:
					while (true) {
						int alt55=2;
						int LA55_0 = input.LA(1);
						if ( (LA55_0==COMMA) ) {
							alt55=1;
						}

						switch (alt55) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:376:3: COMMA t2= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_function_term2172); 
							pushFollow(FOLLOW_term_in_function_term2176);
							t2=term();
							state._fsp--;

							((Abstract_Predicate) t).addTerm(t2);
							}
							break;

						default :
							break loop55;
						}
					}

					match(input,CLOSE,FOLLOW_CLOSE_in_function_term2182); 
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



	// $ANTLR start "var"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:380:1: var returns [Abstract_VarTerm v] : ( VAR | UNNAMEDVAR ) ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR3=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:381:2: ( ( VAR | UNNAMEDVAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:381:4: ( VAR | UNNAMEDVAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:381:4: ( VAR | UNNAMEDVAR )
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==VAR) ) {
				alt57=1;
			}
			else if ( (LA57_0==UNNAMEDVAR) ) {
				alt57=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 57, 0, input);
				throw nvae;
			}

			switch (alt57) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:381:5: VAR
					{
					VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_var2202); 
					if (variables.containsKey(VAR3.getText())) {
							v = variables.get(VAR3.getText());
						            } else {
							v = new Abstract_VarTerm(VAR3.getText());
					                                                     variables.put(VAR3.getText(), v);
						           }
						
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:387:6: UNNAMEDVAR
					{
					match(input,UNNAMEDVAR,FOLLOW_UNNAMEDVAR_in_var2208); 
					v =new Abstract_UnnamedVar();
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



	// $ANTLR start "stringLiteral"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:389:1: stringLiteral returns [Abstract_StringTerm s] : st= stringterm ;
	public final Abstract_StringTerm stringLiteral() throws RecognitionException {
		Abstract_StringTerm s = null;


		Abstract_StringTerm st =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:390:2: (st= stringterm )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:390:4: st= stringterm
			{
			pushFollow(FOLLOW_stringterm_in_stringLiteral2226);
			st=stringterm();
			state._fsp--;

			s = st;
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
	// $ANTLR end "stringLiteral"



	// $ANTLR start "singleQuotedStringLiteral"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:391:1: singleQuotedStringLiteral returns [Abstract_StringTerm s] : SINGLEQUOTE w= word SINGLEQUOTE ;
	public final Abstract_StringTerm singleQuotedStringLiteral() throws RecognitionException {
		Abstract_StringTerm s = null;


		String w =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:392:2: ( SINGLEQUOTE w= word SINGLEQUOTE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:392:4: SINGLEQUOTE w= word SINGLEQUOTE
			{
			match(input,SINGLEQUOTE,FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2240); 
			pushFollow(FOLLOW_word_in_singleQuotedStringLiteral2244);
			w=word();
			state._fsp--;

			match(input,SINGLEQUOTE,FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2246); 
			s = new Abstract_StringTermImpl(w);
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
	// $ANTLR end "singleQuotedStringLiteral"



	// $ANTLR start "stringterm"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:394:1: stringterm returns [Abstract_StringTerm s] : STRING ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING4=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:395:2: ( STRING )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:395:4: STRING
			{
			STRING4=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm2263); 
			String str = STRING4.getText();s=new Abstract_StringTermImpl(str.substring(1,str.length()-1));
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



	// $ANTLR start "word"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:398:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST5=null;
		Token VAR6=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:398:25: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:398:27: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:398:27: ( CONST | VAR )
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==CONST) ) {
				alt58=1;
			}
			else if ( (LA58_0==VAR) ) {
				alt58=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 58, 0, input);
				throw nvae;
			}

			switch (alt58) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:398:28: CONST
					{
					CONST5=(Token)match(input,CONST,FOLLOW_CONST_in_word2280); 
					s =CONST5.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:398:59: VAR
					{
					VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_word2286); 
					s =VAR6.getText();
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:400:1: listterm returns [Abstract_ListTermImpl l] : SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE ;
	public final Abstract_ListTermImpl listterm() throws RecognitionException {
		Abstract_ListTermImpl l = null;


		Token v=null;
		Abstract_Term h =null;
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:401:3: ( SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:401:5: SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE
			{
			l = new Abstract_ListTermImpl(); Abstract_ListTerm lrunning = l;
			match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2307); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:402:10: (h= term ( COMMA t= term )* ( BAR v= VAR )? )?
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==CONST||LA61_0==MINUS||LA61_0==NUMBER||LA61_0==SQOPEN||LA61_0==STRING||(LA61_0 >= UNNAMEDVAR && LA61_0 <= VAR)) ) {
				alt61=1;
			}
			switch (alt61) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:402:11: h= term ( COMMA t= term )* ( BAR v= VAR )?
					{
					pushFollow(FOLLOW_term_in_listterm2312);
					h=term();
					state._fsp--;

					l.addHead(h); l.addTail(new Abstract_ListTermImpl());
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:403:3: ( COMMA t= term )*
					loop59:
					while (true) {
						int alt59=2;
						int LA59_0 = input.LA(1);
						if ( (LA59_0==COMMA) ) {
							alt59=1;
						}

						switch (alt59) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:403:4: COMMA t= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_listterm2319); 
							pushFollow(FOLLOW_term_in_listterm2323);
							t=term();
							state._fsp--;

							Abstract_ListTerm l2 = new Abstract_ListTermImpl(); l2.addHead(t); l2.addTail(new Abstract_ListTermImpl()); lrunning.addTail(l2); lrunning=l2;
							}
							break;

						default :
							break loop59;
						}
					}

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:404:3: ( BAR v= VAR )?
					int alt60=2;
					int LA60_0 = input.LA(1);
					if ( (LA60_0==BAR) ) {
						alt60=1;
					}
					switch (alt60) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:404:4: BAR v= VAR
							{
							match(input,BAR,FOLLOW_BAR_in_listterm2332); 
							v=(Token)match(input,VAR,FOLLOW_VAR_in_listterm2336); 
							lrunning.addTail(new Abstract_VarTerm(v.getText()));
							}
							break;

					}

					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2348); 
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



	// $ANTLR start "equation"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:408:1: equation returns [Abstract_Equation e] : a1= arithexpr i= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation e = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:409:2: (a1= arithexpr i= eqoper a2= arithexpr )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:409:4: a1= arithexpr i= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation2366);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation2370);
			i=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation2374);
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



	// $ANTLR start "numberstring"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:412:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:413:2: ( ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:413:4: ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? )
			{
			s = "";
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:413:15: ( MINUS )?
			int alt62=2;
			int LA62_0 = input.LA(1);
			if ( (LA62_0==MINUS) ) {
				alt62=1;
			}
			switch (alt62) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:413:16: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring2394); 
					s += "-";
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:414:2: (n1= NUMBER ( STOP n2= NUMBER )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:414:3: n1= NUMBER ( STOP n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2405); 
			s += n1.getText();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:2: ( STOP n2= NUMBER )?
			int alt63=2;
			int LA63_0 = input.LA(1);
			if ( (LA63_0==STOP) ) {
				int LA63_1 = input.LA(2);
				if ( (LA63_1==NUMBER) ) {
					alt63=1;
				}
			}
			switch (alt63) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:3: STOP n2= NUMBER
					{
					match(input,STOP,FOLLOW_STOP_in_numberstring2411); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2417); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:417:1: arithexpr returns [Abstract_NumberTerm ae] : a1= multexpr (i= addoper a2= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:418:2: (a1= multexpr (i= addoper a2= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:418:4: a1= multexpr (i= addoper a2= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr2437);
			a1=multexpr();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:418:28: (i= addoper a2= multexpr )?
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==MINUS||LA64_0==PLUS) ) {
				alt64=1;
			}
			switch (alt64) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:418:29: i= addoper a2= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr2444);
					i=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr2448);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:419:1: multexpr returns [Abstract_NumberTerm ae] : a1= atom_term (i= multoper a2= atom_term )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:420:2: (a1= atom_term (i= multoper a2= atom_term )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:420:4: a1= atom_term (i= multoper a2= atom_term )?
			{
			pushFollow(FOLLOW_atom_term_in_multexpr2466);
			a1=atom_term();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:420:28: (i= multoper a2= atom_term )?
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==DIV||LA65_0==MULT) ) {
				alt65=1;
			}
			switch (alt65) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:420:29: i= multoper a2= atom_term
					{
					pushFollow(FOLLOW_multoper_in_multexpr2472);
					i=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_term_in_multexpr2476);
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



	// $ANTLR start "atom_term"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:422:1: atom_term returns [Abstract_NumberTerm t] : (n= numberstring |v= var ) ;
	public final Abstract_NumberTerm atom_term() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:2: ( (n= numberstring |v= var ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:4: (n= numberstring |v= var )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:4: (n= numberstring |v= var )
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==MINUS||LA66_0==NUMBER) ) {
				alt66=1;
			}
			else if ( ((LA66_0 >= UNNAMEDVAR && LA66_0 <= VAR)) ) {
				alt66=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 66, 0, input);
				throw nvae;
			}

			switch (alt66) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:5: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom_term2498);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:66: v= var
					{
					pushFollow(FOLLOW_var_in_atom_term2506);
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



	// $ANTLR start "addoper"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:426:1: addoper returns [int i] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:427:2: ( ( PLUS | MINUS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:427:4: ( PLUS | MINUS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:427:4: ( PLUS | MINUS )
			int alt67=2;
			int LA67_0 = input.LA(1);
			if ( (LA67_0==PLUS) ) {
				alt67=1;
			}
			else if ( (LA67_0==MINUS) ) {
				alt67=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 67, 0, input);
				throw nvae;
			}

			switch (alt67) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:427:5: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper2525); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:427:22: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper2531); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:428:1: multoper returns [int i] : ( MULT | DIV ) ;
	public final int multoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:2: ( ( MULT | DIV ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:4: ( MULT | DIV )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:4: ( MULT | DIV )
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==MULT) ) {
				alt68=1;
			}
			else if ( (LA68_0==DIV) ) {
				alt68=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 68, 0, input);
				throw nvae;
			}

			switch (alt68) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:5: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper2548); 
					i = 3;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:22: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper2554); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:1: eqoper returns [int i] : ( LESS | ( IS | EQUALS ) ) ;
	public final int eqoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:24: ( ( LESS | ( IS | EQUALS ) ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:26: ( LESS | ( IS | EQUALS ) )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:26: ( LESS | ( IS | EQUALS ) )
			int alt69=2;
			int LA69_0 = input.LA(1);
			if ( (LA69_0==LESS) ) {
				alt69=1;
			}
			else if ( (LA69_0==EQUALS||LA69_0==IS) ) {
				alt69=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 69, 0, input);
				throw nvae;
			}

			switch (alt69) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:27: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2570); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:44: ( IS | EQUALS )
					{
					if ( input.LA(1)==EQUALS||input.LA(1)==IS ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
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



	public static final BitSet FOLLOW_MAIN_in_mas74 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COLON_in_mas76 = new BitSet(new long[]{0x4000000000004000L});
	public static final BitSet FOLLOW_id_in_mas80 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_mas82 = new BitSet(new long[]{0x0000005010200000L,0x0000000000000001L});
	public static final BitSet FOLLOW_moduleImport_in_mas89 = new BitSet(new long[]{0x0000005010208000L,0x0000000000000001L});
	public static final BitSet FOLLOW_module_in_mas95 = new BitSet(new long[]{0x0000005010208000L,0x0000000000000001L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_mas102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_goalagent121 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COLON_in_goalagent123 = new BitSet(new long[]{0x4000000000004000L});
	public static final BitSet FOLLOW_id_in_goalagent127 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_goalagent129 = new BitSet(new long[]{0x0000005010200000L,0x0000000000000001L});
	public static final BitSet FOLLOW_moduleImport_in_goalagent136 = new BitSet(new long[]{0x0000005010208000L,0x0000000000000001L});
	public static final BitSet FOLLOW_module_in_goalagent142 = new BitSet(new long[]{0x0000005010208000L,0x0000000000000001L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_goalagent149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_moduleImport159 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_MODULEFILE_in_moduleImport161 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_moduleImport163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_moduleDef_in_module180 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_SQOPEN_in_module185 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001200L});
	public static final BitSet FOLLOW_moduleOption_in_module187 = new BitSet(new long[]{0x0080000000001000L});
	public static final BitSet FOLLOW_COMMA_in_module191 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001200L});
	public static final BitSet FOLLOW_moduleOption_in_module193 = new BitSet(new long[]{0x0080000000001000L});
	public static final BitSet FOLLOW_SQCLOSE_in_module198 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module203 = new BitSet(new long[]{0x0002000082008210L,0x0000000000000001L});
	public static final BitSet FOLLOW_krImport_in_module205 = new BitSet(new long[]{0x0002000082008210L});
	public static final BitSet FOLLOW_knowledge_in_module208 = new BitSet(new long[]{0x0002000002008210L});
	public static final BitSet FOLLOW_beliefs_in_module213 = new BitSet(new long[]{0x0002000002008010L});
	public static final BitSet FOLLOW_goals_in_module217 = new BitSet(new long[]{0x0002000000008010L});
	public static final BitSet FOLLOW_program_in_module221 = new BitSet(new long[]{0x0000000000008010L});
	public static final BitSet FOLLOW_actionSpecs_in_module230 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef253 = new BitSet(new long[]{0x4000000000004000L});
	public static final BitSet FOLLOW_declaration_in_moduleDef255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INIT_in_moduleDef260 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_moduleDef269 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EVENT_in_moduleDef278 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_73_in_moduleOption299 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_EQUALS_in_moduleOption301 = new BitSet(new long[]{0x0000000000000000L,0x00000000001A0040L});
	public static final BitSet FOLLOW_70_in_moduleOption308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_81_in_moduleOption318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_moduleOption328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_83_in_moduleOption339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_moduleOption353 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_EQUALS_in_moduleOption355 = new BitSet(new long[]{0x0000000000000000L,0x0000000000A40800L});
	public static final BitSet FOLLOW_set_in_moduleOption361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_krImport386 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_stringLiteral_in_krImport389 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_singleQuotedStringLiteral_in_krImport393 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_krImport396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KNOWLEDGE_in_knowledge409 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_knowledge411 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_krspec_in_knowledge413 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_knowledge416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_krspec428 = new BitSet(new long[]{0x0204000000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec432 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_krspec439 = new BitSet(new long[]{0x60000C2000004000L,0x0000000000002000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_krspec445 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_forall_expr_in_krspec451 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec455 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_BELIEFS_in_beliefs472 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_beliefs474 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_brspec_in_beliefs476 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_beliefs479 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_brspec491 = new BitSet(new long[]{0x0204000000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec495 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_brspec502 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_brspec506 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec508 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_GOALS_in_goals525 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_goals527 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_goal_list_in_goals531 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_goals535 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_atom549 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_OPEN_in_atom551 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_atom555 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_atom558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_atom565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_atom574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROGRAM_in_program589 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_SQOPEN_in_program592 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_ruleEvaluationOrder_in_program596 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_program600 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program606 = new BitSet(new long[]{0x000000000C008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_macroDef_in_program608 = new BitSet(new long[]{0x000000000C008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_programRule_in_program611 = new BitSet(new long[]{0x0000000008008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program615 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_in_ruleEvaluationOrder632 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_EQUALS_in_ruleEvaluationOrder634 = new BitSet(new long[]{0x0018000600000020L});
	public static final BitSet FOLLOW_LINEAR_in_ruleEvaluationOrder638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LINEARALL_in_ruleEvaluationOrder645 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANDOM_in_ruleEvaluationOrder651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANDOMALL_in_ruleEvaluationOrder657 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADAPTIVE_in_ruleEvaluationOrder664 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HASH_in_macroDef678 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_DEFINE_in_macroDef680 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_macroDef684 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstate_in_macroDef689 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_macroDef695 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_programRule709 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule713 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_THEN_in_programRule717 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule723 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule727 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_programRule740 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule746 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule750 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule755 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule759 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule763 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_programRule771 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_VAR_in_programRule773 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_programRule775 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule777 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule779 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule782 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule784 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_programRule797 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule799 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_programRule801 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_VAR_in_programRule803 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule805 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule808 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule810 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule814 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURLYOPEN_in_nestedRules832 = new BitSet(new long[]{0x0000000008000000L,0x000000000000A000L});
	public static final BitSet FOLLOW_programRule_in_nestedRules834 = new BitSet(new long[]{0x0000000008008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_nestedRules838 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_basicCondition_in_mentalstatecond856 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_mentalstatecond862 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_basicCondition_in_mentalstatecond866 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_mentalatom_in_mentalstate889 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_mentalstate896 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalstate898 = new BitSet(new long[]{0x4000000001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalatom_in_mentalstate900 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_mentalstate902 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_mentalstate907 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mentalstate_in_basicCondition927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_basicCondition936 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selector_in_mentalatom956 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_mentalatom958 = new BitSet(new long[]{0x0000000001800140L});
	public static final BitSet FOLLOW_mentalOperator_in_mentalatom964 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_atom_parameters_in_mentalatom968 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom_parameters987 = new BitSet(new long[]{0x60001C2000004000L});
	public static final BitSet FOLLOW_atom_in_atom_parameters996 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_COMMA_in_atom_parameters1002 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_atom_in_atom_parameters1007 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_SEMI_in_atom_parameters1014 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_atom_in_atom_parameters1021 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_atom_parameters_in_atom_parameters1038 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_atom_parameters1046 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEL_in_mentalOperator1067 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_mentalOperator1078 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AGOAL_in_mentalOperator1089 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOALA_in_mentalOperator1100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actions1123 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_PLUS_in_actions1130 = new BitSet(new long[]{0x4000001010204000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_action_in_actions1134 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_selector_in_action1154 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_action1156 = new BitSet(new long[]{0x0000000000000000L,0x0000000006414188L});
	public static final BitSet FOLLOW_actionOperator_in_action1162 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_parameters_in_action1166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_74_in_action1178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_action1187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INIT_in_action1196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_action1205 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EVENT_in_action1214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_action1221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_67_in_actionOperator1242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_actionOperator1253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_actionOperator1264 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_actionOperator1275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_89_in_actionOperator1287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_90_in_actionOperator1296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_86_in_actionOperator1305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_actionOperator1316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_selector1328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_selector1337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_selector1346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_88_in_selector1355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_91_in_selector1364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_92_in_selector1373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_93_in_selector1382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTIONSPEC_in_actionSpecs1401 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionSpecs1403 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_actionSpec_in_actionSpecs1408 = new BitSet(new long[]{0x000000000000C000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionSpecs1414 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_actionSpec1433 = new BitSet(new long[]{0x0000000020410000L});
	public static final BitSet FOLLOW_INTERNAL_in_actionSpec1436 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_EXTERNAL_in_actionSpec1442 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionSpec1448 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_precondition_in_actionSpec1452 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_postcondition_in_actionSpec1456 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionSpec1458 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRE_in_precondition1476 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_precondition1478 = new BitSet(new long[]{0x70000C2000004000L});
	public static final BitSet FOLLOW_TRUE_in_precondition1482 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_precondition1492 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_precondition1497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POST_in_postcondition1512 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_postcondition1515 = new BitSet(new long[]{0x70000C2000004000L});
	public static final BitSet FOLLOW_TRUE_in_postcondition1519 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_postcondition1529 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_postcondition1538 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_declaration1555 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_parameters_in_declaration1562 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_declarationOrCallWithTerms1583 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_id1602 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_id1609 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_parameters1632 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_parameters1636 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_parameters1642 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_parameters1646 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_parameters1654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_no_bracket_parameters1676 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_no_bracket_parameters1682 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_no_bracket_parameters1686 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_atom_in_no_bracket_literals1717 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_no_bracket_literals1723 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_atom_in_no_bracket_literals1730 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_77_in_forall_expr1757 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_OPEN_in_forall_expr1759 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_atom_in_forall_expr1763 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COMMA_in_forall_expr1765 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_atom_in_forall_expr1769 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_forall_expr1773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_goal_list1799 = new BitSet(new long[]{0x0200000000001000L});
	public static final BitSet FOLLOW_COMMA_in_goal_list1806 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_goal_list1810 = new BitSet(new long[]{0x0200000000001000L});
	public static final BitSet FOLLOW_STOP_in_goal_list1817 = new BitSet(new long[]{0x6500082000004002L});
	public static final BitSet FOLLOW_stringterm_in_term2107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_term2117 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_term2127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_term2136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function_term2154 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_OPEN_in_function_term2161 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_function_term2165 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_function_term2172 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_function_term2176 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_function_term2182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var2202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNNAMEDVAR_in_var2208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_stringLiteral2226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2240 = new BitSet(new long[]{0x4000000000004000L});
	public static final BitSet FOLLOW_word_in_singleQuotedStringLiteral2244 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_stringterm2263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_word2280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word2286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_listterm2307 = new BitSet(new long[]{0x6580082000004000L});
	public static final BitSet FOLLOW_term_in_listterm2312 = new BitSet(new long[]{0x0080000000001080L});
	public static final BitSet FOLLOW_COMMA_in_listterm2319 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_listterm2323 = new BitSet(new long[]{0x0080000000001080L});
	public static final BitSet FOLLOW_BAR_in_listterm2332 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_VAR_in_listterm2336 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_listterm2348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation2366 = new BitSet(new long[]{0x0000000140100000L});
	public static final BitSet FOLLOW_eqoper_in_equation2370 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_arithexpr_in_equation2374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring2394 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2405 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_STOP_in_numberstring2411 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2437 = new BitSet(new long[]{0x0000402000000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr2444 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2466 = new BitSet(new long[]{0x0000010000040002L});
	public static final BitSet FOLLOW_multoper_in_multexpr2472 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom_term2498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom_term2506 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper2525 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper2531 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper2548 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper2554 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_eqoper2576 = new BitSet(new long[]{0x0000000000000002L});
}
