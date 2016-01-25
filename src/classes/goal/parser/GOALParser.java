// $ANTLR 3.5.1 /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2016-01-25 15:19:56

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
		"CURLYCLOSE", "CURLYOPEN", "DEFINE", "DIV", "DO", "DROP", "EQUALS", "EVENT", 
		"EXTERNAL", "GOAL", "GOALA", "GOALS", "HASH", "IF", "INIT", "INSERT", 
		"INTERNAL", "IS", "KNOWLEDGE", "LESS", "LINEAR", "LINEARALL", "LINE_COMMENT", 
		"MAIN", "MINUS", "MODULE", "MODULEFILE", "MULT", "NEWLINE", "NOT", "NUMBER", 
		"OPEN", "ORDER", "PLUS", "POST", "PRE", "PROGRAM", "PROLOGARROW", "RANDOM", 
		"RANDOMALL", "SEMI", "SINGLEQUOTE", "SQCLOSE", "SQOPEN", "STOP", "STRING", 
		"THEN", "TRUE", "UNNAMEDVAR", "VAR", "WS", "'#import'", "'->'", "'<-'", 
		"'adopt'", "'all'", "'allother'", "'always'", "'delete'", "'exit'", "'exit-module'", 
		"'filter'", "'focus'", "'forall'", "'listall'", "'log'", "'never'", "'new'", 
		"'noaction'", "'nogoals'", "'none'", "'print'", "'select'", "'self'", 
		"'send'", "'sendonce'", "'some'", "'someother'", "'this'"
	};
	public static final int EOF=-1;
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
	public static final int DROP=20;
	public static final int EQUALS=21;
	public static final int EVENT=22;
	public static final int EXTERNAL=23;
	public static final int GOAL=24;
	public static final int GOALA=25;
	public static final int GOALS=26;
	public static final int HASH=27;
	public static final int IF=28;
	public static final int INIT=29;
	public static final int INSERT=30;
	public static final int INTERNAL=31;
	public static final int IS=32;
	public static final int KNOWLEDGE=33;
	public static final int LESS=34;
	public static final int LINEAR=35;
	public static final int LINEARALL=36;
	public static final int LINE_COMMENT=37;
	public static final int MAIN=38;
	public static final int MINUS=39;
	public static final int MODULE=40;
	public static final int MODULEFILE=41;
	public static final int MULT=42;
	public static final int NEWLINE=43;
	public static final int NOT=44;
	public static final int NUMBER=45;
	public static final int OPEN=46;
	public static final int ORDER=47;
	public static final int PLUS=48;
	public static final int POST=49;
	public static final int PRE=50;
	public static final int PROGRAM=51;
	public static final int PROLOGARROW=52;
	public static final int RANDOM=53;
	public static final int RANDOMALL=54;
	public static final int SEMI=55;
	public static final int SINGLEQUOTE=56;
	public static final int SQCLOSE=57;
	public static final int SQOPEN=58;
	public static final int STOP=59;
	public static final int STRING=60;
	public static final int THEN=61;
	public static final int TRUE=62;
	public static final int UNNAMEDVAR=63;
	public static final int VAR=64;
	public static final int WS=65;

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
	@Override public String getGrammarFileName() { return "/Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g"; }


	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
	private static HashMap<PredicateIndicator,Abstract_MentalState> macros = new HashMap<PredicateIndicator, Abstract_MentalState>();
	private static HashMap<PredicateIndicator,Abstract_Term> macro_subs = new HashMap<PredicateIndicator, Abstract_Term>();
	private String name = "";



	// $ANTLR start "mas"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:51:1: mas returns [Abstract_MAS mas] : ( moduleImport |gm= module )+ ;
	public final Abstract_MAS mas() throws RecognitionException {
		Abstract_MAS mas = null;


		Abstract_GOALModule gm =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:52:2: ( ( moduleImport |gm= module )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:52:4: ( moduleImport |gm= module )+
			{
			mas = new Abstract_MAS(); ArrayList<Abstract_GOALAgent> agents = new ArrayList<Abstract_GOALAgent>();
			 Abstract_GOALAgent gl = new Abstract_GOALAgent("goal_agent"); agents.add(gl);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:2: ( moduleImport |gm= module )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==66) ) {
					alt1=1;
				}
				else if ( (LA1_0==EVENT||LA1_0==INIT||LA1_0==MAIN||LA1_0==MODULE) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:3: moduleImport
					{
					pushFollow(FOLLOW_moduleImport_in_mas72);
					moduleImport();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:18: gm= module
					{
					pushFollow(FOLLOW_module_in_mas78);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:60:1: goalagent returns [Abstract_GOALAgent gl] : ( moduleImport |gm= module )+ ;
	public final Abstract_GOALAgent goalagent() throws RecognitionException {
		Abstract_GOALAgent gl = null;


		Abstract_GOALModule gm =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:61:2: ( ( moduleImport |gm= module )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:61:4: ( moduleImport |gm= module )+
			{
			 gl = new Abstract_GOALAgent("goal_agent");
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:2: ( moduleImport |gm= module )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=3;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==66) ) {
					alt2=1;
				}
				else if ( (LA2_0==EVENT||LA2_0==INIT||LA2_0==MAIN||LA2_0==MODULE) ) {
					alt2=2;
				}

				switch (alt2) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:3: moduleImport
					{
					pushFollow(FOLLOW_moduleImport_in_goalagent107);
					moduleImport();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:18: gm= module
					{
					pushFollow(FOLLOW_module_in_goalagent113);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:64:1: moduleImport : '#import' MODULEFILE STOP ;
	public final void moduleImport() throws RecognitionException {
		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:2: ( '#import' MODULEFILE STOP )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:4: '#import' MODULEFILE STOP
			{
			match(input,66,FOLLOW_66_in_moduleImport126); 
			match(input,MODULEFILE,FOLLOW_MODULEFILE_in_moduleImport128); 
			match(input,STOP,FOLLOW_STOP_in_moduleImport130); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:1: module returns [Abstract_GOALModule gl] : def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE ;
	public final Abstract_GOALModule module() throws RecognitionException {
		Abstract_GOALModule gl = null;


		Abstract_ModuleDef def =null;
		ArrayList<Abstract_ActionSpec> as =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:2: (def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:4: def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE
			{
			pushFollow(FOLLOW_moduleDef_in_module147);
			def=moduleDef();
			state._fsp--;

			gl = new Abstract_GOALModule(def);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:56: ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==SQOPEN) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:57: SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE
					{
					match(input,SQOPEN,FOLLOW_SQOPEN_in_module152); 
					pushFollow(FOLLOW_moduleOption_in_module154);
					moduleOption(gl);
					state._fsp--;

					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:81: ( COMMA moduleOption[gl] )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==COMMA) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:82: COMMA moduleOption[gl]
							{
							match(input,COMMA,FOLLOW_COMMA_in_module158); 
							pushFollow(FOLLOW_moduleOption_in_module160);
							moduleOption(gl);
							state._fsp--;

							}
							break;

						default :
							break loop3;
						}
					}

					match(input,SQCLOSE,FOLLOW_SQCLOSE_in_module165); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module170); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:12: ( krImport )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==66) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:12: krImport
					{
					pushFollow(FOLLOW_krImport_in_module172);
					krImport();
					state._fsp--;

					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:22: ( knowledge[gl] )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==KNOWLEDGE) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:22: knowledge[gl]
					{
					pushFollow(FOLLOW_knowledge_in_module175);
					knowledge(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:38: ( beliefs[gl] )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==BELIEFS) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:38: beliefs[gl]
					{
					pushFollow(FOLLOW_beliefs_in_module180);
					beliefs(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:51: ( goals[gl] )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==GOALS) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:51: goals[gl]
					{
					pushFollow(FOLLOW_goals_in_module184);
					goals(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:62: ( program[gl] )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==PROGRAM) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:70:62: program[gl]
					{
					pushFollow(FOLLOW_program_in_module188);
					program(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:71:2: (as= actionSpecs )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==ACTIONSPEC) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:71:3: as= actionSpecs
					{
					pushFollow(FOLLOW_actionSpecs_in_module197);
					as=actionSpecs();
					state._fsp--;

					gl.addAllCap(as);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module205); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:1: moduleDef returns [Abstract_ModuleDef i] : ( MODULE d= declaration | INIT MODULE | MAIN MODULE | EVENT MODULE );
	public final Abstract_ModuleDef moduleDef() throws RecognitionException {
		Abstract_ModuleDef i = null;


		Abstract_Predicate d =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:2: ( MODULE d= declaration | INIT MODULE | MAIN MODULE | EVENT MODULE )
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:4: MODULE d= declaration
					{
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef220); 
					pushFollow(FOLLOW_declaration_in_moduleDef224);
					d=declaration();
					state._fsp--;

					i = new Abstract_ModuleDef(d);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:77:4: INIT MODULE
					{
					match(input,INIT,FOLLOW_INIT_in_moduleDef231); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef233); 
					i = Abstract_GOALModule.init;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:4: MAIN MODULE
					{
					match(input,MAIN,FOLLOW_MAIN_in_moduleDef240); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef242); 
					i = Abstract_GOALModule.main;
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:79:4: EVENT MODULE
					{
					match(input,EVENT,FOLLOW_EVENT_in_moduleDef249); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef251); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:83:1: moduleOption[Abstract_GOALModule gl] : (key= 'exit' EQUALS value= ( 'always' | 'never' | 'nogoals' | 'noaction' ) |key= 'focus' EQUALS value= ( 'none' | 'new' | 'select' | 'filter' ) );
	public final void moduleOption(Abstract_GOALModule gl) throws RecognitionException {
		Token key=null;
		Token value=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:2: (key= 'exit' EQUALS value= ( 'always' | 'never' | 'nogoals' | 'noaction' ) |key= 'focus' EQUALS value= ( 'none' | 'new' | 'select' | 'filter' ) )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==74) ) {
				alt13=1;
			}
			else if ( (LA13_0==77) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:4: key= 'exit' EQUALS value= ( 'always' | 'never' | 'nogoals' | 'noaction' )
					{
					key=(Token)match(input,74,FOLLOW_74_in_moduleOption270); 
					match(input,EQUALS,FOLLOW_EQUALS_in_moduleOption272); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:31: ( 'always' | 'never' | 'nogoals' | 'noaction' )
					int alt12=4;
					switch ( input.LA(1) ) {
					case 72:
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
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:32: 'always'
							{
							value=(Token)match(input,72,FOLLOW_72_in_moduleOption279); 
							gl.setExitCondition(Abstract_GOALModule.always);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:6: 'never'
							{
							value=(Token)match(input,81,FOLLOW_81_in_moduleOption289); 
							gl.setExitCondition(Abstract_GOALModule.never);
							}
							break;
						case 3 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:6: 'nogoals'
							{
							value=(Token)match(input,84,FOLLOW_84_in_moduleOption299); 
							gl.setExitCondition(Abstract_GOALModule.nogoals);
							}
							break;
						case 4 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:7: 'noaction'
							{
							value=(Token)match(input,83,FOLLOW_83_in_moduleOption310); 
							gl.setExitCondition(Abstract_GOALModule.noaction);
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:4: key= 'focus' EQUALS value= ( 'none' | 'new' | 'select' | 'filter' )
					{
					key=(Token)match(input,77,FOLLOW_77_in_moduleOption324); 
					match(input,EQUALS,FOLLOW_EQUALS_in_moduleOption326); 
					value=input.LT(1);
					if ( input.LA(1)==76||input.LA(1)==82||input.LA(1)==85||input.LA(1)==87 ) {
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:1: krImport : '#import' ( stringLiteral | singleQuotedStringLiteral ) STOP ;
	public final void krImport() throws RecognitionException {
		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:92:2: ( '#import' ( stringLiteral | singleQuotedStringLiteral ) STOP )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:92:4: '#import' ( stringLiteral | singleQuotedStringLiteral ) STOP
			{
			match(input,66,FOLLOW_66_in_krImport357); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:92:14: ( stringLiteral | singleQuotedStringLiteral )
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:92:15: stringLiteral
					{
					pushFollow(FOLLOW_stringLiteral_in_krImport360);
					stringLiteral();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:92:31: singleQuotedStringLiteral
					{
					pushFollow(FOLLOW_singleQuotedStringLiteral_in_krImport364);
					singleQuotedStringLiteral();
					state._fsp--;

					}
					break;

			}

			match(input,STOP,FOLLOW_STOP_in_krImport367); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:95:1: knowledge[Abstract_GOALModule gl] : KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE ;
	public final void knowledge(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:96:2: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:96:4: KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE
			{
			match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_knowledge380); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_knowledge382); 
			pushFollow(FOLLOW_krspec_in_knowledge384);
			krspec(gl);
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_knowledge387); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:1: krspec[Abstract_GOALModule gl] : (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP ) )+ ;
	public final void krspec(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_Predicate hd =null;
		ArrayList<Abstract_LogicalFormula> body =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:31: ( (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP ) )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP ) )+
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP ) )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==CONST||LA17_0==DROP||LA17_0==INSERT||LA17_0==NOT) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:34: hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP )
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_krspec399);
					hd=declarationOrCallWithTerms();
					state._fsp--;

					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:100:2: ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP )
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
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:100:3: STOP
							{
							match(input,STOP,FOLLOW_STOP_in_krspec403); 
							gl.addFact((Abstract_Predicate) hd);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:101:2: PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_krspec410); 
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:101:14: (body= no_bracket_literals |body= forall_expr )
							int alt15=2;
							int LA15_0 = input.LA(1);
							if ( (LA15_0==CONST||LA15_0==DROP||LA15_0==INSERT||LA15_0==MINUS||(LA15_0 >= NOT && LA15_0 <= NUMBER)||(LA15_0 >= UNNAMEDVAR && LA15_0 <= VAR)) ) {
								alt15=1;
							}
							else if ( (LA15_0==78) ) {
								alt15=2;
							}

							else {
								NoViableAltException nvae =
									new NoViableAltException("", 15, 0, input);
								throw nvae;
							}

							switch (alt15) {
								case 1 :
									// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:101:16: body= no_bracket_literals
									{
									pushFollow(FOLLOW_no_bracket_literals_in_krspec416);
									body=no_bracket_literals();
									state._fsp--;

									}
									break;
								case 2 :
									// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:101:43: body= forall_expr
									{
									pushFollow(FOLLOW_forall_expr_in_krspec422);
									body=forall_expr();
									state._fsp--;

									}
									break;

							}

							match(input,STOP,FOLLOW_STOP_in_krspec426); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:103:1: beliefs[Abstract_GOALModule gl] : BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE ;
	public final void beliefs(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:104:2: ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:104:4: BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE
			{
			match(input,BELIEFS,FOLLOW_BELIEFS_in_beliefs443); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_beliefs445); 
			pushFollow(FOLLOW_brspec_in_beliefs447);
			brspec(gl);
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_beliefs450); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:1: brspec[Abstract_GOALModule gl] : (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+ ;
	public final void brspec(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_Predicate hd =null;
		ArrayList<Abstract_LogicalFormula> body =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:31: ( (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+
			int cnt19=0;
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==CONST||LA19_0==DROP||LA19_0==INSERT||LA19_0==NOT) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:34: hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP )
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_brspec462);
					hd=declarationOrCallWithTerms();
					state._fsp--;

					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:2: ( STOP | PROLOGARROW body= no_bracket_literals STOP )
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
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:108:3: STOP
							{
							match(input,STOP,FOLLOW_STOP_in_brspec466); 
							gl.addBel((Abstract_Predicate) hd);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:109:2: PROLOGARROW body= no_bracket_literals STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_brspec473); 
							pushFollow(FOLLOW_no_bracket_literals_in_brspec477);
							body=no_bracket_literals();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_brspec479); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:112:1: goals[Abstract_GOALModule gl] : GOALS CURLYOPEN le= goal_list CURLYCLOSE ;
	public final void goals(Abstract_GOALModule gl) throws RecognitionException {
		ArrayList<ArrayList<Abstract_Term>> le =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:2: ( GOALS CURLYOPEN le= goal_list CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:4: GOALS CURLYOPEN le= goal_list CURLYCLOSE
			{
			match(input,GOALS,FOLLOW_GOALS_in_goals496); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_goals498); 
			pushFollow(FOLLOW_goal_list_in_goals502);
			le=goal_list();
			state._fsp--;

			gl.addGoal(le);
			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_goals506); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:115:1: atom returns [Abstract_LogicalFormula l] : ( NOT OPEN (p= declarationOrCallWithTerms |e= equation ) CLOSE |p= notnot_declarationOrCallWithTerms |e= equation );
	public final Abstract_LogicalFormula atom() throws RecognitionException {
		Abstract_LogicalFormula l = null;


		Abstract_Predicate p =null;
		Abstract_Equation e =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:116:2: ( NOT OPEN (p= declarationOrCallWithTerms |e= equation ) CLOSE |p= notnot_declarationOrCallWithTerms |e= equation )
			int alt21=3;
			switch ( input.LA(1) ) {
			case NOT:
				{
				alt21=1;
				}
				break;
			case CONST:
			case DROP:
			case INSERT:
				{
				alt21=2;
				}
				break;
			case MINUS:
			case NUMBER:
			case UNNAMEDVAR:
			case VAR:
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:116:4: NOT OPEN (p= declarationOrCallWithTerms |e= equation ) CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_atom520); 
					match(input,OPEN,FOLLOW_OPEN_in_atom522); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:116:13: (p= declarationOrCallWithTerms |e= equation )
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==CONST||LA20_0==DROP||LA20_0==INSERT||LA20_0==NOT) ) {
						alt20=1;
					}
					else if ( (LA20_0==MINUS||LA20_0==NUMBER||(LA20_0 >= UNNAMEDVAR && LA20_0 <= VAR)) ) {
						alt20=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 20, 0, input);
						throw nvae;
					}

					switch (alt20) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:116:15: p= declarationOrCallWithTerms
							{
							pushFollow(FOLLOW_declarationOrCallWithTerms_in_atom528);
							p=declarationOrCallWithTerms();
							state._fsp--;

							l = new Abstract_LogExpr(Abstract_LogExpr.not, p);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:117:5: e= equation
							{
							pushFollow(FOLLOW_equation_in_atom538);
							e=equation();
							state._fsp--;

							l = new Abstract_LogExpr(Abstract_LogExpr.not, e);
							}
							break;

					}

					match(input,CLOSE,FOLLOW_CLOSE_in_atom544); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:118:4: p= notnot_declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_notnot_declarationOrCallWithTerms_in_atom551);
					p=notnot_declarationOrCallWithTerms();
					state._fsp--;

					l =p;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:4: e= equation
					{
					pushFollow(FOLLOW_equation_in_atom560);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:123:1: program[Abstract_GOALModule gl] : PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* (rule= programRule )* CURLYCLOSE ;
	public final void program(Abstract_GOALModule gl) throws RecognitionException {
		int i =0;
		Abstract_ActionRule rule =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:2: ( PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* (rule= programRule )* CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:4: PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* (rule= programRule )* CURLYCLOSE
			{
			match(input,PROGRAM,FOLLOW_PROGRAM_in_program575); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:12: ( SQOPEN i= ruleEvaluationOrder SQCLOSE )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==SQOPEN) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:124:13: SQOPEN i= ruleEvaluationOrder SQCLOSE
					{
					match(input,SQOPEN,FOLLOW_SQOPEN_in_program578); 
					pushFollow(FOLLOW_ruleEvaluationOrder_in_program582);
					i=ruleEvaluationOrder();
					state._fsp--;

					gl.setOptionOrder(i);
					match(input,SQCLOSE,FOLLOW_SQCLOSE_in_program586); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program592); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:12: ( macroDef )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==HASH) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:12: macroDef
					{
					pushFollow(FOLLOW_macroDef_in_program594);
					macroDef();
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:22: (rule= programRule )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==IF||(LA24_0 >= 78 && LA24_0 <= 79)) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:23: rule= programRule
					{
					pushFollow(FOLLOW_programRule_in_program602);
					rule=programRule();
					state._fsp--;

					gl.addPlan(rule);
					}
					break;

				default :
					break loop24;
				}
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program608); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:1: ruleEvaluationOrder returns [int i] : ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE ) ;
	public final int ruleEvaluationOrder() throws RecognitionException {
		int i = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:2: ( ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:4: ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE )
			{
			match(input,ORDER,FOLLOW_ORDER_in_ruleEvaluationOrder625); 
			match(input,EQUALS,FOLLOW_EQUALS_in_ruleEvaluationOrder627); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:17: ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE )
			int alt25=5;
			switch ( input.LA(1) ) {
			case LINEAR:
				{
				alt25=1;
				}
				break;
			case LINEARALL:
				{
				alt25=2;
				}
				break;
			case RANDOM:
				{
				alt25=3;
				}
				break;
			case RANDOMALL:
				{
				alt25=4;
				}
				break;
			case ADAPTIVE:
				{
				alt25=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:19: LINEAR
					{
					match(input,LINEAR,FOLLOW_LINEAR_in_ruleEvaluationOrder631); 
					i =Abstract_GOALModule.linear;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:131:2: LINEARALL
					{
					match(input,LINEARALL,FOLLOW_LINEARALL_in_ruleEvaluationOrder638); 
					i =Abstract_GOALModule.linearall;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:132:2: RANDOM
					{
					match(input,RANDOM,FOLLOW_RANDOM_in_ruleEvaluationOrder644); 
					i =Abstract_GOALModule.random;
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:2: RANDOMALL
					{
					match(input,RANDOMALL,FOLLOW_RANDOMALL_in_ruleEvaluationOrder650); 
					i =Abstract_GOALModule.randomall;
					}
					break;
				case 5 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:134:2: ADAPTIVE
					{
					match(input,ADAPTIVE,FOLLOW_ADAPTIVE_in_ruleEvaluationOrder657); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:137:1: macroDef : HASH DEFINE p= declarationOrCallWithTerms msc= mentalstatecond STOP ;
	public final void macroDef() throws RecognitionException {
		Abstract_Predicate p =null;
		Abstract_MentalState msc =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:138:2: ( HASH DEFINE p= declarationOrCallWithTerms msc= mentalstatecond STOP )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:138:4: HASH DEFINE p= declarationOrCallWithTerms msc= mentalstatecond STOP
			{
			match(input,HASH,FOLLOW_HASH_in_macroDef671); 
			match(input,DEFINE,FOLLOW_DEFINE_in_macroDef673); 
			pushFollow(FOLLOW_declarationOrCallWithTerms_in_macroDef677);
			p=declarationOrCallWithTerms();
			state._fsp--;

			pushFollow(FOLLOW_mentalstatecond_in_macroDef682);
			msc=mentalstatecond();
			state._fsp--;

			PredicateIndicator pi = new PredicateIndicator(p.getFunctor(), p.getTermSize()); macros.put(pi, msc);
				macro_subs.put(pi, p);
			match(input,STOP,FOLLOW_STOP_in_macroDef688); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:1: programRule returns [Abstract_ActionRule rule] : ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] ) ) ;
	public final Abstract_ActionRule programRule() throws RecognitionException {
		Abstract_ActionRule rule = null;


		Abstract_MentalState lf =null;
		ArrayList<Abstract_Deed> dl =null;
		Abstract_VarTerm v =null;
		Abstract_MentalState ms =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:145:2: ( ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] ) ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:145:3: ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] ) )
			{
			rule = new Abstract_ActionRule();
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:146:2: ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] ) )
			int alt30=4;
			switch ( input.LA(1) ) {
			case IF:
				{
				alt30=1;
				}
				break;
			case 78:
				{
				alt30=2;
				}
				break;
			case 79:
				{
				switch ( input.LA(2) ) {
				case VAR:
					{
					int LA30_4 = input.LA(3);
					if ( (LA30_4==68) ) {
						alt30=3;
					}
					else if ( (LA30_4==STOP) ) {
						alt30=4;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 30, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case UNNAMEDVAR:
					{
					alt30=3;
					}
					break;
				case AGOAL:
				case BEL:
				case CONST:
				case DROP:
				case GOAL:
				case GOALA:
				case INSERT:
				case NOT:
				case TRUE:
				case 70:
				case 71:
				case 88:
				case 91:
				case 92:
				case 93:
					{
					alt30=4;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 30, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}
			switch (alt30) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:146:3: IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] )
					{
					match(input,IF,FOLLOW_IF_in_programRule705); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule709);
					lf=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(lf);
					match(input,THEN,FOLLOW_THEN_in_programRule713); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:146:61: (dl= actions STOP | nestedRules[rule] )
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==CONST||LA26_0==DROP||LA26_0==EVENT||(LA26_0 >= INIT && LA26_0 <= INSERT)||LA26_0==MAIN||LA26_0==NOT||LA26_0==VAR||(LA26_0 >= 69 && LA26_0 <= 71)||LA26_0==73||LA26_0==75||LA26_0==80||LA26_0==86||(LA26_0 >= 88 && LA26_0 <= 93)) ) {
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
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:146:63: dl= actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule719);
							dl=actions();
							state._fsp--;

							rule.setBody(dl);
							match(input,STOP,FOLLOW_STOP_in_programRule723); 
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:146:101: nestedRules[rule]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule727);
							nestedRules(rule);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:147:4: 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] )
					{
					match(input,78,FOLLOW_78_in_programRule736); 
					rule.setType(ActionRule.foralldo);
					pushFollow(FOLLOW_mentalstatecond_in_programRule742);
					lf=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(lf);
					match(input,DO,FOLLOW_DO_in_programRule746); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:147:103: (dl= actions STOP | nestedRules[rule] )
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==CONST||LA27_0==DROP||LA27_0==EVENT||(LA27_0 >= INIT && LA27_0 <= INSERT)||LA27_0==MAIN||LA27_0==NOT||LA27_0==VAR||(LA27_0 >= 69 && LA27_0 <= 71)||LA27_0==73||LA27_0==75||LA27_0==80||LA27_0==86||(LA27_0 >= 88 && LA27_0 <= 93)) ) {
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
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:147:104: dl= actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule751);
							dl=actions();
							state._fsp--;

							rule.setBody(dl);
							match(input,STOP,FOLLOW_STOP_in_programRule755); 
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:147:142: nestedRules[rule]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule759);
							nestedRules(rule);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:4: 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] )
					{
					match(input,79,FOLLOW_79_in_programRule767); 
					rule.setType(ActionRule.listalldo);
					pushFollow(FOLLOW_var_in_programRule773);
					v=var();
					state._fsp--;

					match(input,68,FOLLOW_68_in_programRule775); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule779);
					ms=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(new Abstract_MentalState(v, ms));
					match(input,DO,FOLLOW_DO_in_programRule786); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:6: (dl= actions STOP | nestedRules[rule] )
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0==CONST||LA28_0==DROP||LA28_0==EVENT||(LA28_0 >= INIT && LA28_0 <= INSERT)||LA28_0==MAIN||LA28_0==NOT||LA28_0==VAR||(LA28_0 >= 69 && LA28_0 <= 71)||LA28_0==73||LA28_0==75||LA28_0==80||LA28_0==86||(LA28_0 >= 88 && LA28_0 <= 93)) ) {
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
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:7: dl= actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule791);
							dl=actions();
							state._fsp--;

							rule.setBody(dl);
							match(input,STOP,FOLLOW_STOP_in_programRule796); 
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:46: nestedRules[rule]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule800);
							nestedRules(rule);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:150:4: 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] )
					{
					match(input,79,FOLLOW_79_in_programRule809); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule811);
					mentalstatecond();
					state._fsp--;

					match(input,67,FOLLOW_67_in_programRule813); 
					pushFollow(FOLLOW_var_in_programRule815);
					var();
					state._fsp--;

					match(input,DO,FOLLOW_DO_in_programRule817); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:150:42: ( actions STOP | nestedRules[rule] )
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==CONST||LA29_0==DROP||LA29_0==EVENT||(LA29_0 >= INIT && LA29_0 <= INSERT)||LA29_0==MAIN||LA29_0==NOT||LA29_0==VAR||(LA29_0 >= 69 && LA29_0 <= 71)||LA29_0==73||LA29_0==75||LA29_0==80||LA29_0==86||(LA29_0 >= 88 && LA29_0 <= 93)) ) {
						alt29=1;
					}
					else if ( (LA29_0==CURLYOPEN) ) {
						alt29=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 29, 0, input);
						throw nvae;
					}

					switch (alt29) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:150:43: actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule820);
							actions();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_programRule822); 
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:150:58: nestedRules[rule]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule826);
							nestedRules(rule);
							state._fsp--;

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
		return rule;
	}
	// $ANTLR end "programRule"



	// $ANTLR start "nestedRules"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:1: nestedRules[Abstract_ActionRule rule] : CURLYOPEN (r= programRule )+ CURLYCLOSE ;
	public final void nestedRules(Abstract_ActionRule rule) throws RecognitionException {
		Abstract_ActionRule r =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:2: ( CURLYOPEN (r= programRule )+ CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:4: CURLYOPEN (r= programRule )+ CURLYCLOSE
			{
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_nestedRules843); 
			ArrayList<Abstract_ActionRule> rules = new ArrayList<Abstract_ActionRule>();
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:93: (r= programRule )+
			int cnt31=0;
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==IF||(LA31_0 >= 78 && LA31_0 <= 79)) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:94: r= programRule
					{
					pushFollow(FOLLOW_programRule_in_nestedRules850);
					r=programRule();
					state._fsp--;

					rules.add(r);
					}
					break;

				default :
					if ( cnt31 >= 1 ) break loop31;
					EarlyExitException eee = new EarlyExitException(31, input);
					throw eee;
				}
				cnt31++;
			}

			rule.merge(rules);
			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_nestedRules857); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:158:1: mentalstatecond returns [Abstract_MentalState lf] : ma= basicCondition ( COMMA ms2= basicCondition )* ;
	public final Abstract_MentalState mentalstatecond() throws RecognitionException {
		Abstract_MentalState lf = null;


		Abstract_MentalState ma =null;
		Abstract_MentalState ms2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:159:2: (ma= basicCondition ( COMMA ms2= basicCondition )* )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:159:4: ma= basicCondition ( COMMA ms2= basicCondition )*
			{
			pushFollow(FOLLOW_basicCondition_in_mentalstatecond875);
			ma=basicCondition();
			state._fsp--;

			Abstract_MentalState ms =  ma;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:2: ( COMMA ms2= basicCondition )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==COMMA) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:3: COMMA ms2= basicCondition
					{
					match(input,COMMA,FOLLOW_COMMA_in_mentalstatecond881); 
					pushFollow(FOLLOW_basicCondition_in_mentalstatecond885);
					ms2=basicCondition();
					state._fsp--;

					ms = new Abstract_MentalState(ms, Abstract_Guard.and, ms2);
					}
					break;

				default :
					break loop32;
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:163:1: mentalstate returns [Abstract_MentalState ms] : (ma= mentalatom | NOT OPEN nma= mentalatom CLOSE | TRUE );
	public final Abstract_MentalState mentalstate() throws RecognitionException {
		Abstract_MentalState ms = null;


		Abstract_MentalState ma =null;
		Abstract_MentalState nma =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:2: (ma= mentalatom | NOT OPEN nma= mentalatom CLOSE | TRUE )
			int alt33=3;
			switch ( input.LA(1) ) {
			case AGOAL:
			case BEL:
			case CONST:
			case GOAL:
			case GOALA:
			case VAR:
			case 70:
			case 71:
			case 88:
			case 91:
			case 92:
			case 93:
				{
				alt33=1;
				}
				break;
			case NOT:
				{
				alt33=2;
				}
				break;
			case TRUE:
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:4: ma= mentalatom
					{
					pushFollow(FOLLOW_mentalatom_in_mentalstate908);
					ma=mentalatom();
					state._fsp--;

					ms = new Abstract_MentalState(ma);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:4: NOT OPEN nma= mentalatom CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_mentalstate915); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalstate917); 
					pushFollow(FOLLOW_mentalatom_in_mentalstate921);
					nma=mentalatom();
					state._fsp--;

					nma.negate(); ms = new Abstract_MentalState(nma);
					match(input,CLOSE,FOLLOW_CLOSE_in_mentalstate925); 
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:166:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_mentalstate930); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:1: basicCondition returns [Abstract_MentalState ms] : (ms1= mentalstate |p= declarationOrCallWithTerms );
	public final Abstract_MentalState basicCondition() throws RecognitionException {
		Abstract_MentalState ms = null;


		Abstract_MentalState ms1 =null;
		Abstract_Predicate p =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:170:2: (ms1= mentalstate |p= declarationOrCallWithTerms )
			int alt34=2;
			switch ( input.LA(1) ) {
			case CONST:
				{
				int LA34_1 = input.LA(2);
				if ( (LA34_1==STOP) ) {
					int LA34_5 = input.LA(3);
					if ( (LA34_5==AGOAL||LA34_5==BEL||(LA34_5 >= GOAL && LA34_5 <= GOALA)) ) {
						alt34=1;
					}
					else if ( (LA34_5==CURLYCLOSE||(LA34_5 >= HASH && LA34_5 <= IF)||(LA34_5 >= 78 && LA34_5 <= 79)) ) {
						alt34=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 34, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA34_1==COMMA||LA34_1==DO||LA34_1==OPEN||LA34_1==THEN||LA34_1==67) ) {
					alt34=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 34, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case AGOAL:
			case BEL:
			case GOAL:
			case GOALA:
			case TRUE:
			case VAR:
			case 70:
			case 71:
			case 88:
			case 91:
			case 92:
			case 93:
				{
				alt34=1;
				}
				break;
			case NOT:
				{
				int LA34_3 = input.LA(2);
				if ( (LA34_3==OPEN) ) {
					switch ( input.LA(3) ) {
					case CONST:
						{
						int LA34_7 = input.LA(4);
						if ( (LA34_7==STOP) ) {
							alt34=1;
						}
						else if ( (LA34_7==CLOSE||LA34_7==COMMA||LA34_7==OPEN) ) {
							alt34=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 34, 7, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case VAR:
						{
						int LA34_8 = input.LA(4);
						if ( (LA34_8==STOP) ) {
							alt34=1;
						}
						else if ( (LA34_8==CLOSE||LA34_8==COMMA||LA34_8==DIV||LA34_8==MINUS||LA34_8==MULT||LA34_8==PLUS) ) {
							alt34=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 34, 8, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case AGOAL:
					case BEL:
					case GOAL:
					case GOALA:
					case 70:
					case 71:
					case 88:
					case 91:
					case 92:
					case 93:
						{
						alt34=1;
						}
						break;
					case DROP:
					case INSERT:
					case MINUS:
					case NOT:
					case NUMBER:
					case SQOPEN:
					case STRING:
					case UNNAMEDVAR:
						{
						alt34=2;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 34, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
				else if ( (LA34_3==COMMA||LA34_3==DO||LA34_3==STOP||LA34_3==THEN||LA34_3==67) ) {
					alt34=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 34, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DROP:
			case INSERT:
				{
				alt34=2;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}
			switch (alt34) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:170:4: ms1= mentalstate
					{
					pushFollow(FOLLOW_mentalstate_in_basicCondition950);
					ms1=mentalstate();
					state._fsp--;

					ms = ms1;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:171:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_basicCondition959);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:178:1: mentalatom returns [Abstract_MentalState ms] : ( selector STOP )? b= mentalOperator tl= atom_parameters ;
	public final Abstract_MentalState mentalatom() throws RecognitionException {
		Abstract_MentalState ms = null;


		byte b =0;
		Abstract_LogExpr tl =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:179:2: ( ( selector STOP )? b= mentalOperator tl= atom_parameters )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:2: ( selector STOP )? b= mentalOperator tl= atom_parameters
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:2: ( selector STOP )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==CONST||LA35_0==VAR||(LA35_0 >= 70 && LA35_0 <= 71)||LA35_0==88||(LA35_0 >= 91 && LA35_0 <= 93)) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:3: selector STOP
					{
					pushFollow(FOLLOW_selector_in_mentalatom979);
					selector();
					state._fsp--;

					match(input,STOP,FOLLOW_STOP_in_mentalatom981); 
					}
					break;

			}

			pushFollow(FOLLOW_mentalOperator_in_mentalatom987);
			b=mentalOperator();
			state._fsp--;

			pushFollow(FOLLOW_atom_parameters_in_mentalatom991);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:193:1: atom_parameters returns [Abstract_LogExpr ts] : OPEN (t= atom ( COMMA (t1= atom |ap= atom_parameters ) | SEMI (t1= atom |ap= atom_parameters ) )* |ap= atom_parameters ) CLOSE ;
	public final Abstract_LogExpr atom_parameters() throws RecognitionException {
		Abstract_LogExpr ts = null;


		Abstract_LogicalFormula t =null;
		Abstract_LogicalFormula t1 =null;
		Abstract_LogExpr ap =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:194:2: ( OPEN (t= atom ( COMMA (t1= atom |ap= atom_parameters ) | SEMI (t1= atom |ap= atom_parameters ) )* |ap= atom_parameters ) CLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:194:4: OPEN (t= atom ( COMMA (t1= atom |ap= atom_parameters ) | SEMI (t1= atom |ap= atom_parameters ) )* |ap= atom_parameters ) CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_atom_parameters1011); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:194:9: (t= atom ( COMMA (t1= atom |ap= atom_parameters ) | SEMI (t1= atom |ap= atom_parameters ) )* |ap= atom_parameters )
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==CONST||LA39_0==DROP||LA39_0==INSERT||LA39_0==MINUS||(LA39_0 >= NOT && LA39_0 <= NUMBER)||(LA39_0 >= UNNAMEDVAR && LA39_0 <= VAR)) ) {
				alt39=1;
			}
			else if ( (LA39_0==OPEN) ) {
				alt39=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}

			switch (alt39) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:195:3: t= atom ( COMMA (t1= atom |ap= atom_parameters ) | SEMI (t1= atom |ap= atom_parameters ) )*
					{
					pushFollow(FOLLOW_atom_in_atom_parameters1020);
					t=atom();
					state._fsp--;

					Abstract_LogExpr tl = new Abstract_LogExpr(Abstract_LogExpr.none, t);
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:2: ( COMMA (t1= atom |ap= atom_parameters ) | SEMI (t1= atom |ap= atom_parameters ) )*
					loop38:
					while (true) {
						int alt38=3;
						int LA38_0 = input.LA(1);
						if ( (LA38_0==COMMA) ) {
							alt38=1;
						}
						else if ( (LA38_0==SEMI) ) {
							alt38=2;
						}

						switch (alt38) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:3: COMMA (t1= atom |ap= atom_parameters )
							{
							match(input,COMMA,FOLLOW_COMMA_in_atom_parameters1026); 
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:10: (t1= atom |ap= atom_parameters )
							int alt36=2;
							int LA36_0 = input.LA(1);
							if ( (LA36_0==CONST||LA36_0==DROP||LA36_0==INSERT||LA36_0==MINUS||(LA36_0 >= NOT && LA36_0 <= NUMBER)||(LA36_0 >= UNNAMEDVAR && LA36_0 <= VAR)) ) {
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
									// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:12: t1= atom
									{
									pushFollow(FOLLOW_atom_in_atom_parameters1033);
									t1=atom();
									state._fsp--;

									tl = new Abstract_LogExpr(tl, Abstract_LogExpr.and,  t1);
									}
									break;
								case 2 :
									// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:5: ap= atom_parameters
									{
									pushFollow(FOLLOW_atom_parameters_in_atom_parameters1043);
									ap=atom_parameters();
									state._fsp--;

									tl = new Abstract_LogExpr(tl, Abstract_LogExpr.and,  ap);
									}
									break;

							}

							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:198:4: SEMI (t1= atom |ap= atom_parameters )
							{
							match(input,SEMI,FOLLOW_SEMI_in_atom_parameters1051); 
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:198:10: (t1= atom |ap= atom_parameters )
							int alt37=2;
							int LA37_0 = input.LA(1);
							if ( (LA37_0==CONST||LA37_0==DROP||LA37_0==INSERT||LA37_0==MINUS||(LA37_0 >= NOT && LA37_0 <= NUMBER)||(LA37_0 >= UNNAMEDVAR && LA37_0 <= VAR)) ) {
								alt37=1;
							}
							else if ( (LA37_0==OPEN) ) {
								alt37=2;
							}

							else {
								NoViableAltException nvae =
									new NoViableAltException("", 37, 0, input);
								throw nvae;
							}

							switch (alt37) {
								case 1 :
									// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:198:11: t1= atom
									{
									pushFollow(FOLLOW_atom_in_atom_parameters1059);
									t1=atom();
									state._fsp--;

									tl = new Abstract_LogExpr(tl, Abstract_LogExpr.or,  t1);
									}
									break;
								case 2 :
									// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:5: ap= atom_parameters
									{
									pushFollow(FOLLOW_atom_parameters_in_atom_parameters1069);
									ap=atom_parameters();
									state._fsp--;

									tl = new Abstract_LogExpr(tl, Abstract_LogExpr.and,  ap);
									}
									break;

							}

							}
							break;

						default :
							break loop38;
						}
					}

					 ts = tl;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:5: ap= atom_parameters
					{
					pushFollow(FOLLOW_atom_parameters_in_atom_parameters1087);
					ap=atom_parameters();
					state._fsp--;

					ts = ap;
					}
					break;

			}

			match(input,CLOSE,FOLLOW_CLOSE_in_atom_parameters1095); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:1: mentalOperator returns [byte b] : (op= BEL |op= GOAL |op= AGOAL |op= GOALA );
	public final byte mentalOperator() throws RecognitionException {
		byte b = 0;


		Token op=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:2: (op= BEL |op= GOAL |op= AGOAL |op= GOALA )
			int alt40=4;
			switch ( input.LA(1) ) {
			case BEL:
				{
				alt40=1;
				}
				break;
			case GOAL:
				{
				alt40=2;
				}
				break;
			case AGOAL:
				{
				alt40=3;
				}
				break;
			case GOALA:
				{
				alt40=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}
			switch (alt40) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:4: op= BEL
					{
					op=(Token)match(input,BEL,FOLLOW_BEL_in_mentalOperator1116); 
					b = Abstract_BaseAILStructure.AILBel;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:4: op= GOAL
					{
					op=(Token)match(input,GOAL,FOLLOW_GOAL_in_mentalOperator1127); 
					b = Abstract_BaseAILStructure.AILGoal;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:209:4: op= AGOAL
					{
					op=(Token)match(input,AGOAL,FOLLOW_AGOAL_in_mentalOperator1138); 
					b = Abstract_MentalAtom.agoal;
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:4: op= GOALA
					{
					op=(Token)match(input,GOALA,FOLLOW_GOALA_in_mentalOperator1149); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:213:1: actions returns [ArrayList<Abstract_Deed> dl] :a= action ( PLUS a1= action )* ;
	public final ArrayList<Abstract_Deed> actions() throws RecognitionException {
		ArrayList<Abstract_Deed> dl = null;


		Abstract_Deed a =null;
		Abstract_Deed a1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:214:2: (a= action ( PLUS a1= action )* )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:214:4: a= action ( PLUS a1= action )*
			{
			dl = new ArrayList<Abstract_Deed>();
			pushFollow(FOLLOW_action_in_actions1172);
			a=action();
			state._fsp--;

			dl.add(a);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:216:2: ( PLUS a1= action )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==PLUS) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:216:3: PLUS a1= action
					{
					match(input,PLUS,FOLLOW_PLUS_in_actions1179); 
					pushFollow(FOLLOW_action_in_actions1183);
					a1=action();
					state._fsp--;

					dl.add(a1);
					}
					break;

				default :
					break loop41;
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:1: action returns [Abstract_Deed d] : ( ( selector STOP )? d1= actionOperator tl= parameters |op= 'exit-module' |op= 'log' |op= INIT |op= MAIN |op= EVENT |p= not_action_opdeclarationOrCallWithTerms );
	public final Abstract_Deed action() throws RecognitionException {
		Abstract_Deed d = null;


		Token op=null;
		Abstract_Deed d1 =null;
		ArrayList<Abstract_Term> tl =null;
		Abstract_Predicate p =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:2: ( ( selector STOP )? d1= actionOperator tl= parameters |op= 'exit-module' |op= 'log' |op= INIT |op= MAIN |op= EVENT |p= not_action_opdeclarationOrCallWithTerms )
			int alt43=7;
			switch ( input.LA(1) ) {
			case CONST:
				{
				int LA43_1 = input.LA(2);
				if ( (LA43_1==STOP) ) {
					int LA43_9 = input.LA(3);
					if ( (LA43_9==DROP||LA43_9==INSERT||LA43_9==69||LA43_9==73||LA43_9==80||LA43_9==86||(LA43_9 >= 89 && LA43_9 <= 90)) ) {
						alt43=1;
					}
					else if ( (LA43_9==CURLYCLOSE||LA43_9==IF||(LA43_9 >= 78 && LA43_9 <= 79)) ) {
						alt43=7;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 43, 9, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA43_1==OPEN||LA43_1==PLUS) ) {
					alt43=7;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 43, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DROP:
			case INSERT:
			case VAR:
			case 69:
			case 70:
			case 71:
			case 73:
			case 86:
			case 88:
			case 89:
			case 90:
			case 91:
			case 92:
			case 93:
				{
				alt43=1;
				}
				break;
			case 80:
				{
				int LA43_3 = input.LA(2);
				if ( (LA43_3==OPEN) ) {
					alt43=1;
				}
				else if ( (LA43_3==PLUS||LA43_3==STOP) ) {
					alt43=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 43, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 75:
				{
				alt43=2;
				}
				break;
			case INIT:
				{
				alt43=4;
				}
				break;
			case MAIN:
				{
				alt43=5;
				}
				break;
			case EVENT:
				{
				alt43=6;
				}
				break;
			case NOT:
				{
				alt43=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}
			switch (alt43) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:4: ( selector STOP )? d1= actionOperator tl= parameters
					{
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:4: ( selector STOP )?
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==CONST||LA42_0==VAR||(LA42_0 >= 70 && LA42_0 <= 71)||LA42_0==88||(LA42_0 >= 91 && LA42_0 <= 93)) ) {
						alt42=1;
					}
					switch (alt42) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:5: selector STOP
							{
							pushFollow(FOLLOW_selector_in_action1203);
							selector();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_action1205); 
							}
							break;

					}

					pushFollow(FOLLOW_actionOperator_in_action1211);
					d1=actionOperator();
					state._fsp--;

					pushFollow(FOLLOW_parameters_in_action1215);
					tl=parameters();
					state._fsp--;

					d1.addParams(tl); d =d1;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:222:4: op= 'exit-module'
					{
					op=(Token)match(input,75,FOLLOW_75_in_action1227); 
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:223:4: op= 'log'
					{
					op=(Token)match(input,80,FOLLOW_80_in_action1236); 
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:224:4: op= INIT
					{
					op=(Token)match(input,INIT,FOLLOW_INIT_in_action1245); 
					}
					break;
				case 5 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:225:4: op= MAIN
					{
					op=(Token)match(input,MAIN,FOLLOW_MAIN_in_action1254); 
					}
					break;
				case 6 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:226:4: op= EVENT
					{
					op=(Token)match(input,EVENT,FOLLOW_EVENT_in_action1263); 
					}
					break;
				case 7 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:227:4: p= not_action_opdeclarationOrCallWithTerms
					{
					pushFollow(FOLLOW_not_action_opdeclarationOrCallWithTerms_in_action1270);
					p=not_action_opdeclarationOrCallWithTerms();
					state._fsp--;

					d = new Abstract_Deed(new Abstract_UserSpecOrModuleCall(p));
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:230:1: actionOperator returns [Abstract_Deed d] : (op= 'adopt' |op= DROP |op= INSERT |op= 'delete' |op= 'send' |op= 'sendonce' |op= 'print' |op= 'log' );
	public final Abstract_Deed actionOperator() throws RecognitionException {
		Abstract_Deed d = null;


		Token op=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:231:2: (op= 'adopt' |op= DROP |op= INSERT |op= 'delete' |op= 'send' |op= 'sendonce' |op= 'print' |op= 'log' )
			int alt44=8;
			switch ( input.LA(1) ) {
			case 69:
				{
				alt44=1;
				}
				break;
			case DROP:
				{
				alt44=2;
				}
				break;
			case INSERT:
				{
				alt44=3;
				}
				break;
			case 73:
				{
				alt44=4;
				}
				break;
			case 89:
				{
				alt44=5;
				}
				break;
			case 90:
				{
				alt44=6;
				}
				break;
			case 86:
				{
				alt44=7;
				}
				break;
			case 80:
				{
				alt44=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}
			switch (alt44) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:231:4: op= 'adopt'
					{
					op=(Token)match(input,69,FOLLOW_69_in_actionOperator1291); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, Abstract_BaseAILStructure.AILGoal);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:232:4: op= DROP
					{
					op=(Token)match(input,DROP,FOLLOW_DROP_in_actionOperator1302); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILDeletion, Abstract_BaseAILStructure.AILGoal);
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:233:4: op= INSERT
					{
					op=(Token)match(input,INSERT,FOLLOW_INSERT_in_actionOperator1313); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, Abstract_BaseAILStructure.AILBel);
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:234:4: op= 'delete'
					{
					op=(Token)match(input,73,FOLLOW_73_in_actionOperator1324); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILDeletion, Abstract_BaseAILStructure.AILBel);
					}
					break;
				case 5 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:235:4: op= 'send'
					{
					op=(Token)match(input,89,FOLLOW_89_in_actionOperator1336); 
					}
					break;
				case 6 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:236:4: op= 'sendonce'
					{
					op=(Token)match(input,90,FOLLOW_90_in_actionOperator1345); 
					}
					break;
				case 7 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:237:4: op= 'print'
					{
					op=(Token)match(input,86,FOLLOW_86_in_actionOperator1354); 
					d = new Abstract_Deed(new Abstract_PrintAction());
					}
					break;
				case 8 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:238:4: op= 'log'
					{
					op=(Token)match(input,80,FOLLOW_80_in_actionOperator1365); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:242:1: selector : ( word |op= 'all' |op= 'allother' |op= 'self' |op= 'some' |op= 'someother' |op= 'this' );
	public final void selector() throws RecognitionException {
		Token op=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:243:2: ( word |op= 'all' |op= 'allother' |op= 'self' |op= 'some' |op= 'someother' |op= 'this' )
			int alt45=7;
			switch ( input.LA(1) ) {
			case CONST:
			case VAR:
				{
				alt45=1;
				}
				break;
			case 70:
				{
				alt45=2;
				}
				break;
			case 71:
				{
				alt45=3;
				}
				break;
			case 88:
				{
				alt45=4;
				}
				break;
			case 91:
				{
				alt45=5;
				}
				break;
			case 92:
				{
				alt45=6;
				}
				break;
			case 93:
				{
				alt45=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}
			switch (alt45) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:243:4: word
					{
					pushFollow(FOLLOW_word_in_selector1377);
					word();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:244:4: op= 'all'
					{
					op=(Token)match(input,70,FOLLOW_70_in_selector1386); 
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:245:4: op= 'allother'
					{
					op=(Token)match(input,71,FOLLOW_71_in_selector1395); 
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:246:4: op= 'self'
					{
					op=(Token)match(input,88,FOLLOW_88_in_selector1404); 
					}
					break;
				case 5 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:247:4: op= 'some'
					{
					op=(Token)match(input,91,FOLLOW_91_in_selector1413); 
					}
					break;
				case 6 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:248:4: op= 'someother'
					{
					op=(Token)match(input,92,FOLLOW_92_in_selector1422); 
					}
					break;
				case 7 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:249:4: op= 'this'
					{
					op=(Token)match(input,93,FOLLOW_93_in_selector1431); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:252:1: actionSpecs returns [ArrayList<Abstract_ActionSpec> as] : ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE ;
	public final ArrayList<Abstract_ActionSpec> actionSpecs() throws RecognitionException {
		ArrayList<Abstract_ActionSpec> as = null;


		Abstract_ActionSpec a =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:253:2: ( ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:253:4: ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE
			{
			as = new ArrayList<Abstract_ActionSpec>();
			match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_actionSpecs1450); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionSpecs1452); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:254:23: (a= actionSpec )+
			int cnt46=0;
			loop46:
			while (true) {
				int alt46=2;
				int LA46_0 = input.LA(1);
				if ( (LA46_0==CONST||LA46_0==DROP||LA46_0==INSERT||LA46_0==NOT) ) {
					alt46=1;
				}

				switch (alt46) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:254:24: a= actionSpec
					{
					pushFollow(FOLLOW_actionSpec_in_actionSpecs1457);
					a=actionSpec();
					state._fsp--;

					as.add(a);
					}
					break;

				default :
					if ( cnt46 >= 1 ) break loop46;
					EarlyExitException eee = new EarlyExitException(46, input);
					throw eee;
				}
				cnt46++;
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionSpecs1463); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:257:1: actionSpec returns [Abstract_ActionSpec as] :cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE ;
	public final Abstract_ActionSpec actionSpec() throws RecognitionException {
		Abstract_ActionSpec as = null;


		Abstract_Predicate cap =null;
		Abstract_LogicalFormula pre =null;
		Abstract_LogicalFormula post =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:258:2: (cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:258:4: cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE
			{
			boolean internal=false;
			pushFollow(FOLLOW_declarationOrCallWithTerms_in_actionSpec1482);
			cap=declarationOrCallWithTerms();
			state._fsp--;

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:258:61: ( INTERNAL | EXTERNAL )?
			int alt47=3;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==INTERNAL) ) {
				alt47=1;
			}
			else if ( (LA47_0==EXTERNAL) ) {
				alt47=2;
			}
			switch (alt47) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:258:62: INTERNAL
					{
					match(input,INTERNAL,FOLLOW_INTERNAL_in_actionSpec1485); 
					internal = true;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:258:92: EXTERNAL
					{
					match(input,EXTERNAL,FOLLOW_EXTERNAL_in_actionSpec1491); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionSpec1497); 
			pushFollow(FOLLOW_precondition_in_actionSpec1501);
			pre=precondition();
			state._fsp--;

			pushFollow(FOLLOW_postcondition_in_actionSpec1505);
			post=postcondition();
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionSpec1507); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:263:1: precondition returns [Abstract_LogicalFormula f] : PRE CURLYOPEN ( TRUE |tl= no_bracket_literals |ap= atom_parameters ) CURLYCLOSE ;
	public final Abstract_LogicalFormula precondition() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		ArrayList<Abstract_LogicalFormula> tl =null;
		Abstract_LogExpr ap =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:264:2: ( PRE CURLYOPEN ( TRUE |tl= no_bracket_literals |ap= atom_parameters ) CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:264:4: PRE CURLYOPEN ( TRUE |tl= no_bracket_literals |ap= atom_parameters ) CURLYCLOSE
			{
			match(input,PRE,FOLLOW_PRE_in_precondition1525); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_precondition1527); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:264:19: ( TRUE |tl= no_bracket_literals |ap= atom_parameters )
			int alt48=3;
			switch ( input.LA(1) ) {
			case TRUE:
				{
				alt48=1;
				}
				break;
			case CONST:
			case DROP:
			case INSERT:
			case MINUS:
			case NOT:
			case NUMBER:
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:264:20: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_precondition1531); 
					f = new Abstract_LogExpr();
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:265:4: tl= no_bracket_literals
					{
					pushFollow(FOLLOW_no_bracket_literals_in_precondition1541);
					tl=no_bracket_literals();
					state._fsp--;

					f = new Abstract_LogExpr(tl);
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:266:4: ap= atom_parameters
					{
					pushFollow(FOLLOW_atom_parameters_in_precondition1552);
					ap=atom_parameters();
					state._fsp--;

					f = ap;
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_precondition1558); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:269:1: postcondition returns [Abstract_LogicalFormula f] : POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE ;
	public final Abstract_LogicalFormula postcondition() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		ArrayList<Abstract_LogicalFormula> tl =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:270:2: ( POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:270:4: POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE
			{
			match(input,POST,FOLLOW_POST_in_postcondition1573); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_postcondition1576); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:271:2: ( TRUE |tl= no_bracket_literals )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==TRUE) ) {
				alt49=1;
			}
			else if ( (LA49_0==CONST||LA49_0==DROP||LA49_0==INSERT||LA49_0==MINUS||(LA49_0 >= NOT && LA49_0 <= NUMBER)||(LA49_0 >= UNNAMEDVAR && LA49_0 <= VAR)) ) {
				alt49=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}

			switch (alt49) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:271:3: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_postcondition1580); 
					f = new Abstract_LogExpr();
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:272:4: tl= no_bracket_literals
					{
					pushFollow(FOLLOW_no_bracket_literals_in_postcondition1590);
					tl=no_bracket_literals();
					state._fsp--;


							f = new Abstract_LogExpr(tl);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_postcondition1599); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:278:1: declaration returns [Abstract_Predicate p] : f= id (tl= parameters )? ;
	public final Abstract_Predicate declaration() throws RecognitionException {
		Abstract_Predicate p = null;


		String f =null;
		ArrayList<Abstract_Term> tl =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:279:2: (f= id (tl= parameters )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:279:4: f= id (tl= parameters )?
			{
			pushFollow(FOLLOW_id_in_declaration1616);
			f=id();
			state._fsp--;

			p= new Abstract_Predicate(f);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:279:41: (tl= parameters )?
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==OPEN) ) {
				alt50=1;
			}
			switch (alt50) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:279:42: tl= parameters
					{
					pushFollow(FOLLOW_parameters_in_declaration1623);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:282:1: declarationOrCallWithTerms returns [Abstract_Predicate p] : f= nested_function_term ;
	public final Abstract_Predicate declarationOrCallWithTerms() throws RecognitionException {
		Abstract_Predicate p = null;


		Abstract_Term f =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:283:2: (f= nested_function_term )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:283:4: f= nested_function_term
			{
			pushFollow(FOLLOW_nested_function_term_in_declarationOrCallWithTerms1644);
			f=nested_function_term();
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



	// $ANTLR start "notnot_declarationOrCallWithTerms"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:286:1: notnot_declarationOrCallWithTerms returns [Abstract_Predicate p] : f= notnot_function_term ;
	public final Abstract_Predicate notnot_declarationOrCallWithTerms() throws RecognitionException {
		Abstract_Predicate p = null;


		Abstract_Predicate f =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:287:2: (f= notnot_function_term )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:287:4: f= notnot_function_term
			{
			pushFollow(FOLLOW_notnot_function_term_in_notnot_declarationOrCallWithTerms1664);
			f=notnot_function_term();
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
	// $ANTLR end "notnot_declarationOrCallWithTerms"



	// $ANTLR start "not_action_opdeclarationOrCallWithTerms"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:290:1: not_action_opdeclarationOrCallWithTerms returns [Abstract_Predicate p] : f= not_action_opfunction_term ;
	public final Abstract_Predicate not_action_opdeclarationOrCallWithTerms() throws RecognitionException {
		Abstract_Predicate p = null;


		Abstract_Term f =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:291:2: (f= not_action_opfunction_term )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:291:4: f= not_action_opfunction_term
			{
			pushFollow(FOLLOW_not_action_opfunction_term_in_not_action_opdeclarationOrCallWithTerms1684);
			f=not_action_opfunction_term();
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
	// $ANTLR end "not_action_opdeclarationOrCallWithTerms"



	// $ANTLR start "id"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:294:1: id returns [String s] : ( CONST | VAR ) ;
	public final String id() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:295:2: ( ( CONST | VAR ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:295:4: ( CONST | VAR )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:295:4: ( CONST | VAR )
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==CONST) ) {
				alt51=1;
			}
			else if ( (LA51_0==VAR) ) {
				alt51=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 51, 0, input);
				throw nvae;
			}

			switch (alt51) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:295:5: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_id1703); 
					s = CONST1.getText();
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:296:4: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_id1710); 
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



	// $ANTLR start "not_action_opparameters"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:300:1: not_action_opparameters returns [ArrayList<Abstract_Term>ts] : OPEN ( NOT OPEN t= not_action_opterm CLOSE |t= toplevelterm ) ( COMMA ( NOT OPEN t1= not_action_opterm CLOSE |t1= toplevelterm ) )* CLOSE ;
	public final ArrayList<Abstract_Term> not_action_opparameters() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:301:2: ( OPEN ( NOT OPEN t= not_action_opterm CLOSE |t= toplevelterm ) ( COMMA ( NOT OPEN t1= not_action_opterm CLOSE |t1= toplevelterm ) )* CLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:301:4: OPEN ( NOT OPEN t= not_action_opterm CLOSE |t= toplevelterm ) ( COMMA ( NOT OPEN t1= not_action_opterm CLOSE |t1= toplevelterm ) )* CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_not_action_opparameters1733); 
			boolean negated=false;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:301:34: ( NOT OPEN t= not_action_opterm CLOSE |t= toplevelterm )
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==NOT) ) {
				alt52=1;
			}
			else if ( (LA52_0==CONST||LA52_0==MINUS||LA52_0==NUMBER||LA52_0==SQOPEN||LA52_0==STRING||(LA52_0 >= UNNAMEDVAR && LA52_0 <= VAR)) ) {
				alt52=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 52, 0, input);
				throw nvae;
			}

			switch (alt52) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:301:36: NOT OPEN t= not_action_opterm CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_not_action_opparameters1739); 
					negated = true;
					match(input,OPEN,FOLLOW_OPEN_in_not_action_opparameters1743); 
					pushFollow(FOLLOW_not_action_opterm_in_not_action_opparameters1747);
					t=not_action_opterm();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_not_action_opparameters1749); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:302:2: t= toplevelterm
					{
					pushFollow(FOLLOW_toplevelterm_in_not_action_opparameters1756);
					t=toplevelterm();
					state._fsp--;

					}
					break;

			}

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); 
					if (negated) {Abstract_Literal l = new Abstract_Literal((Abstract_Predicate) t);
					l.setNegated(negated); 
					t=l;}
					tl.add(t);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:308:2: ( COMMA ( NOT OPEN t1= not_action_opterm CLOSE |t1= toplevelterm ) )*
			loop54:
			while (true) {
				int alt54=2;
				int LA54_0 = input.LA(1);
				if ( (LA54_0==COMMA) ) {
					alt54=1;
				}

				switch (alt54) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:308:3: COMMA ( NOT OPEN t1= not_action_opterm CLOSE |t1= toplevelterm )
					{
					match(input,COMMA,FOLLOW_COMMA_in_not_action_opparameters1766); 
					negated = false;
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:308:28: ( NOT OPEN t1= not_action_opterm CLOSE |t1= toplevelterm )
					int alt53=2;
					int LA53_0 = input.LA(1);
					if ( (LA53_0==NOT) ) {
						alt53=1;
					}
					else if ( (LA53_0==CONST||LA53_0==MINUS||LA53_0==NUMBER||LA53_0==SQOPEN||LA53_0==STRING||(LA53_0 >= UNNAMEDVAR && LA53_0 <= VAR)) ) {
						alt53=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 53, 0, input);
						throw nvae;
					}

					switch (alt53) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:308:30: NOT OPEN t1= not_action_opterm CLOSE
							{
							match(input,NOT,FOLLOW_NOT_in_not_action_opparameters1772); 
							negated = true;
							match(input,OPEN,FOLLOW_OPEN_in_not_action_opparameters1776); 
							pushFollow(FOLLOW_not_action_opterm_in_not_action_opparameters1780);
							t1=not_action_opterm();
							state._fsp--;

							match(input,CLOSE,FOLLOW_CLOSE_in_not_action_opparameters1782); 
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:309:2: t1= toplevelterm
							{
							pushFollow(FOLLOW_toplevelterm_in_not_action_opparameters1791);
							t1=toplevelterm();
							state._fsp--;

							}
							break;

					}


						if (negated) {Abstract_Literal l1 = new Abstract_Literal((Abstract_Predicate) t1); l1.setNegated(negated); t1=l1;}
						 tl.add(t1);
					}
					break;

				default :
					break loop54;
				}
			}

			match(input,CLOSE,FOLLOW_CLOSE_in_not_action_opparameters1800); 
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
	// $ANTLR end "not_action_opparameters"



	// $ANTLR start "parameters"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:315:1: parameters returns [ArrayList<Abstract_Term>ts] : OPEN t= term ( COMMA t1= term )* CLOSE ;
	public final ArrayList<Abstract_Term> parameters() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:316:2: ( OPEN t= term ( COMMA t1= term )* CLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:316:4: OPEN t= term ( COMMA t1= term )* CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_parameters1818); 
			pushFollow(FOLLOW_term_in_parameters1823);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); 
					tl.add(t);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:319:2: ( COMMA t1= term )*
			loop55:
			while (true) {
				int alt55=2;
				int LA55_0 = input.LA(1);
				if ( (LA55_0==COMMA) ) {
					alt55=1;
				}

				switch (alt55) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:319:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_parameters1832); 
					pushFollow(FOLLOW_term_in_parameters1836);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop55;
				}
			}

			match(input,CLOSE,FOLLOW_CLOSE_in_parameters1845); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:323:1: no_bracket_parameters returns [ArrayList<Abstract_Term>ts] : t= term ( COMMA t1= term )* ;
	public final ArrayList<Abstract_Term> no_bracket_parameters() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:324:2: (t= term ( COMMA t1= term )* )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:324:5: t= term ( COMMA t1= term )*
			{
			pushFollow(FOLLOW_term_in_no_bracket_parameters1867);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:325:2: ( COMMA t1= term )*
			loop56:
			while (true) {
				int alt56=2;
				int LA56_0 = input.LA(1);
				if ( (LA56_0==COMMA) ) {
					alt56=1;
				}

				switch (alt56) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:325:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_no_bracket_parameters1873); 
					pushFollow(FOLLOW_term_in_no_bracket_parameters1877);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop56;
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:329:1: no_bracket_literals returns [ArrayList<Abstract_LogicalFormula>ts] :t= atom ( COMMA t1= atom )* ;
	public final ArrayList<Abstract_LogicalFormula> no_bracket_literals() throws RecognitionException {
		ArrayList<Abstract_LogicalFormula> ts = null;


		Abstract_LogicalFormula t =null;
		Abstract_LogicalFormula t1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:330:2: (t= atom ( COMMA t1= atom )* )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:330:5: t= atom ( COMMA t1= atom )*
			{
			ArrayList<Abstract_LogicalFormula> tl = new ArrayList<Abstract_LogicalFormula>();
			pushFollow(FOLLOW_atom_in_no_bracket_literals1908);
			t=atom();
			state._fsp--;

			 tl.add(t);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:332:2: ( COMMA t1= atom )*
			loop57:
			while (true) {
				int alt57=2;
				int LA57_0 = input.LA(1);
				if ( (LA57_0==COMMA) ) {
					alt57=1;
				}

				switch (alt57) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:332:3: COMMA t1= atom
					{
					match(input,COMMA,FOLLOW_COMMA_in_no_bracket_literals1914); 
					pushFollow(FOLLOW_atom_in_no_bracket_literals1921);
					t1=atom();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop57;
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



	// $ANTLR start "goal_list"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:338:1: goal_list returns [ArrayList<ArrayList<Abstract_Term>>ts] : (t= term ( COMMA t1= term )* STOP )+ ;
	public final ArrayList<ArrayList<Abstract_Term>> goal_list() throws RecognitionException {
		ArrayList<ArrayList<Abstract_Term>> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:339:2: ( (t= term ( COMMA t1= term )* STOP )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:339:4: (t= term ( COMMA t1= term )* STOP )+
			{
			ArrayList<ArrayList<Abstract_Term>> tll = new ArrayList<ArrayList<Abstract_Term>>();
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:340:2: (t= term ( COMMA t1= term )* STOP )+
			int cnt59=0;
			loop59:
			while (true) {
				int alt59=2;
				int LA59_0 = input.LA(1);
				if ( (LA59_0==CONST||LA59_0==DROP||LA59_0==INSERT||LA59_0==MINUS||(LA59_0 >= NOT && LA59_0 <= NUMBER)||LA59_0==SQOPEN||LA59_0==STRING||(LA59_0 >= UNNAMEDVAR && LA59_0 <= VAR)) ) {
					alt59=1;
				}

				switch (alt59) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:340:3: t= term ( COMMA t1= term )* STOP
					{
					pushFollow(FOLLOW_term_in_goal_list1953);
					t=term();
					state._fsp--;

					ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:341:2: ( COMMA t1= term )*
					loop58:
					while (true) {
						int alt58=2;
						int LA58_0 = input.LA(1);
						if ( (LA58_0==COMMA) ) {
							alt58=1;
						}

						switch (alt58) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:341:3: COMMA t1= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_goal_list1960); 
							pushFollow(FOLLOW_term_in_goal_list1964);
							t1=term();
							state._fsp--;

							tl.add(t1);
							}
							break;

						default :
							break loop58;
						}
					}

					match(input,STOP,FOLLOW_STOP_in_goal_list1971); 
					tll.add(tl);
					}
					break;

				default :
					if ( cnt59 >= 1 ) break loop59;
					EarlyExitException eee = new EarlyExitException(59, input);
					throw eee;
				}
				cnt59++;
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:388:1: term returns [Abstract_Term t] : (st= stringterm |ft= nested_function_term |at= arithexpr |lt= listterm ) ;
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_StringTerm st =null;
		Abstract_Term ft =null;
		Abstract_NumberTerm at =null;
		Abstract_ListTermImpl lt =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:389:2: ( (st= stringterm |ft= nested_function_term |at= arithexpr |lt= listterm ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:389:4: (st= stringterm |ft= nested_function_term |at= arithexpr |lt= listterm )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:389:4: (st= stringterm |ft= nested_function_term |at= arithexpr |lt= listterm )
			int alt60=4;
			switch ( input.LA(1) ) {
			case STRING:
				{
				alt60=1;
				}
				break;
			case CONST:
			case DROP:
			case INSERT:
			case NOT:
				{
				alt60=2;
				}
				break;
			case MINUS:
			case NUMBER:
			case UNNAMEDVAR:
			case VAR:
				{
				alt60=3;
				}
				break;
			case SQOPEN:
				{
				alt60=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 60, 0, input);
				throw nvae;
			}
			switch (alt60) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:389:5: st= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term2278);
					st=stringterm();
					state._fsp--;

					t = st;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:390:4: ft= nested_function_term
					{
					pushFollow(FOLLOW_nested_function_term_in_term2288);
					ft=nested_function_term();
					state._fsp--;

					t =ft;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:391:4: at= arithexpr
					{
					pushFollow(FOLLOW_arithexpr_in_term2298);
					at=arithexpr();
					state._fsp--;

					t =at;
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:392:4: lt= listterm
					{
					pushFollow(FOLLOW_listterm_in_term2307);
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



	// $ANTLR start "toplevelterm"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:394:1: toplevelterm returns [Abstract_Term t] : (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) ;
	public final Abstract_Term toplevelterm() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_StringTerm st =null;
		Abstract_Predicate ft =null;
		Abstract_NumberTerm at =null;
		Abstract_ListTermImpl lt =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:395:2: ( (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:395:4: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:395:4: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			int alt61=4;
			switch ( input.LA(1) ) {
			case STRING:
				{
				alt61=1;
				}
				break;
			case CONST:
				{
				alt61=2;
				}
				break;
			case MINUS:
			case NUMBER:
			case UNNAMEDVAR:
			case VAR:
				{
				alt61=3;
				}
				break;
			case SQOPEN:
				{
				alt61=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 61, 0, input);
				throw nvae;
			}
			switch (alt61) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:395:5: st= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_toplevelterm2328);
					st=stringterm();
					state._fsp--;

					t = st;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:396:4: ft= function_term
					{
					pushFollow(FOLLOW_function_term_in_toplevelterm2338);
					ft=function_term();
					state._fsp--;

					t =ft;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:397:4: at= arithexpr
					{
					pushFollow(FOLLOW_arithexpr_in_toplevelterm2348);
					at=arithexpr();
					state._fsp--;

					t =at;
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:398:4: lt= listterm
					{
					pushFollow(FOLLOW_listterm_in_toplevelterm2357);
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
	// $ANTLR end "toplevelterm"



	// $ANTLR start "notnotterm"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:401:1: notnotterm returns [Abstract_Term t] : (st= stringterm |ft= notnot_function_term |at= arithexpr |lt= listterm ) ;
	public final Abstract_Term notnotterm() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_StringTerm st =null;
		Abstract_Predicate ft =null;
		Abstract_NumberTerm at =null;
		Abstract_ListTermImpl lt =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:402:2: ( (st= stringterm |ft= notnot_function_term |at= arithexpr |lt= listterm ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:402:4: (st= stringterm |ft= notnot_function_term |at= arithexpr |lt= listterm )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:402:4: (st= stringterm |ft= notnot_function_term |at= arithexpr |lt= listterm )
			int alt62=4;
			switch ( input.LA(1) ) {
			case STRING:
				{
				alt62=1;
				}
				break;
			case CONST:
			case DROP:
			case INSERT:
				{
				alt62=2;
				}
				break;
			case MINUS:
			case NUMBER:
			case UNNAMEDVAR:
			case VAR:
				{
				alt62=3;
				}
				break;
			case SQOPEN:
				{
				alt62=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 62, 0, input);
				throw nvae;
			}
			switch (alt62) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:402:5: st= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_notnotterm2377);
					st=stringterm();
					state._fsp--;

					t = st;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:403:4: ft= notnot_function_term
					{
					pushFollow(FOLLOW_notnot_function_term_in_notnotterm2387);
					ft=notnot_function_term();
					state._fsp--;

					t =ft;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:404:4: at= arithexpr
					{
					pushFollow(FOLLOW_arithexpr_in_notnotterm2397);
					at=arithexpr();
					state._fsp--;

					t =at;
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:405:4: lt= listterm
					{
					pushFollow(FOLLOW_listterm_in_notnotterm2406);
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
	// $ANTLR end "notnotterm"



	// $ANTLR start "not_action_opterm"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:407:1: not_action_opterm returns [Abstract_Term t] : (st= stringterm |ft= not_action_opfunction_term |at= arithexpr |lt= listterm ) ;
	public final Abstract_Term not_action_opterm() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_StringTerm st =null;
		Abstract_Term ft =null;
		Abstract_NumberTerm at =null;
		Abstract_ListTermImpl lt =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:408:2: ( (st= stringterm |ft= not_action_opfunction_term |at= arithexpr |lt= listterm ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:408:4: (st= stringterm |ft= not_action_opfunction_term |at= arithexpr |lt= listterm )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:408:4: (st= stringterm |ft= not_action_opfunction_term |at= arithexpr |lt= listterm )
			int alt63=4;
			switch ( input.LA(1) ) {
			case STRING:
				{
				alt63=1;
				}
				break;
			case CONST:
			case NOT:
				{
				alt63=2;
				}
				break;
			case MINUS:
			case NUMBER:
			case UNNAMEDVAR:
			case VAR:
				{
				alt63=3;
				}
				break;
			case SQOPEN:
				{
				alt63=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 63, 0, input);
				throw nvae;
			}
			switch (alt63) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:408:5: st= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_not_action_opterm2426);
					st=stringterm();
					state._fsp--;

					t = st;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:409:4: ft= not_action_opfunction_term
					{
					pushFollow(FOLLOW_not_action_opfunction_term_in_not_action_opterm2436);
					ft=not_action_opfunction_term();
					state._fsp--;

					t =ft;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:410:4: at= arithexpr
					{
					pushFollow(FOLLOW_arithexpr_in_not_action_opterm2446);
					at=arithexpr();
					state._fsp--;

					t =at;
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:411:4: lt= listterm
					{
					pushFollow(FOLLOW_listterm_in_not_action_opterm2455);
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
	// $ANTLR end "not_action_opterm"



	// $ANTLR start "function_term"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:413:1: function_term returns [Abstract_Predicate t] : c= CONST ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )? ;
	public final Abstract_Predicate function_term() throws RecognitionException {
		Abstract_Predicate t = null;


		Token c=null;
		Abstract_Term t1 =null;
		Abstract_Term t2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:413:46: (c= CONST ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:414:3: c= CONST ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )?
			{
			c=(Token)match(input,CONST,FOLLOW_CONST_in_function_term2475); 
			t=new Abstract_Predicate(c.getText());
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:2: ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )?
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==OPEN) ) {
				alt65=1;
			}
			switch (alt65) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:3: OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function_term2482); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:8: (t1= term )
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:11: t1= term
					{
					pushFollow(FOLLOW_term_in_function_term2489);
					t1=term();
					state._fsp--;

					((Abstract_Predicate) t).addTerm(t1);
					}

					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:2: ( COMMA (t2= term ) )*
					loop64:
					while (true) {
						int alt64=2;
						int LA64_0 = input.LA(1);
						if ( (LA64_0==COMMA) ) {
							alt64=1;
						}

						switch (alt64) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:3: COMMA (t2= term )
							{
							match(input,COMMA,FOLLOW_COMMA_in_function_term2497); 
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:9: (t2= term )
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:12: t2= term
							{
							pushFollow(FOLLOW_term_in_function_term2504);
							t2=term();
							state._fsp--;

							((Abstract_Predicate) t).addTerm(t2);
							}

							}
							break;

						default :
							break loop64;
						}
					}

					match(input,CLOSE,FOLLOW_CLOSE_in_function_term2512); 
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



	// $ANTLR start "notnot_function_term"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:419:1: notnot_function_term returns [Abstract_Predicate t] : (c= CONST |s= notnot_goalkeywordsappearinginprolog ) ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )? ;
	public final Abstract_Predicate notnot_function_term() throws RecognitionException {
		Abstract_Predicate t = null;


		Token c=null;
		String s =null;
		Abstract_Term t1 =null;
		Abstract_Term t2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:419:53: ( (c= CONST |s= notnot_goalkeywordsappearinginprolog ) ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:420:3: (c= CONST |s= notnot_goalkeywordsappearinginprolog ) ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )?
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:420:3: (c= CONST |s= notnot_goalkeywordsappearinginprolog )
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==CONST) ) {
				alt66=1;
			}
			else if ( (LA66_0==DROP||LA66_0==INSERT) ) {
				alt66=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 66, 0, input);
				throw nvae;
			}

			switch (alt66) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:420:5: c= CONST
					{
					c=(Token)match(input,CONST,FOLLOW_CONST_in_notnot_function_term2536); 
					t=new Abstract_Predicate(c.getText());
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:421:5: s= notnot_goalkeywordsappearinginprolog
					{
					pushFollow(FOLLOW_notnot_goalkeywordsappearinginprolog_in_notnot_function_term2547);
					s=notnot_goalkeywordsappearinginprolog();
					state._fsp--;

					t=new Abstract_Predicate(s);
					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:2: ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )?
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==OPEN) ) {
				alt68=1;
			}
			switch (alt68) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:3: OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_notnot_function_term2557); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:8: (t1= term )
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:11: t1= term
					{
					pushFollow(FOLLOW_term_in_notnot_function_term2564);
					t1=term();
					state._fsp--;

					((Abstract_Predicate) t).addTerm(t1);
					}

					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:424:2: ( COMMA (t2= term ) )*
					loop67:
					while (true) {
						int alt67=2;
						int LA67_0 = input.LA(1);
						if ( (LA67_0==COMMA) ) {
							alt67=1;
						}

						switch (alt67) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:424:3: COMMA (t2= term )
							{
							match(input,COMMA,FOLLOW_COMMA_in_notnot_function_term2572); 
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:424:9: (t2= term )
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:424:13: t2= term
							{
							pushFollow(FOLLOW_term_in_notnot_function_term2580);
							t2=term();
							state._fsp--;

							((Abstract_Predicate) t).addTerm(t2);
							}

							}
							break;

						default :
							break loop67;
						}
					}

					match(input,CLOSE,FOLLOW_CLOSE_in_notnot_function_term2587); 
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
	// $ANTLR end "notnot_function_term"



	// $ANTLR start "not_action_opfunction_term"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:427:1: not_action_opfunction_term returns [Abstract_Term t] : (c= CONST |s= not_action_opgoalkeywordsappearinginprolog ) ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )? ;
	public final Abstract_Term not_action_opfunction_term() throws RecognitionException {
		Abstract_Term t = null;


		Token c=null;
		String s =null;
		Abstract_Term t1 =null;
		Abstract_Term t2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:428:2: ( (c= CONST |s= not_action_opgoalkeywordsappearinginprolog ) ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:428:4: (c= CONST |s= not_action_opgoalkeywordsappearinginprolog ) ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )?
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:428:4: (c= CONST |s= not_action_opgoalkeywordsappearinginprolog )
			int alt69=2;
			int LA69_0 = input.LA(1);
			if ( (LA69_0==CONST) ) {
				alt69=1;
			}
			else if ( (LA69_0==NOT) ) {
				alt69=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 69, 0, input);
				throw nvae;
			}

			switch (alt69) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:428:5: c= CONST
					{
					c=(Token)match(input,CONST,FOLLOW_CONST_in_not_action_opfunction_term2608); 
					t=new Abstract_Predicate(c.getText());
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:428:56: s= not_action_opgoalkeywordsappearinginprolog
					{
					pushFollow(FOLLOW_not_action_opgoalkeywordsappearinginprolog_in_not_action_opfunction_term2616);
					s=not_action_opgoalkeywordsappearinginprolog();
					state._fsp--;

					t=new Abstract_Predicate(s);
					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:2: ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )?
			int alt71=2;
			int LA71_0 = input.LA(1);
			if ( (LA71_0==OPEN) ) {
				alt71=1;
			}
			switch (alt71) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:3: OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_not_action_opfunction_term2623); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:8: (t1= term )
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:10: t1= term
					{
					pushFollow(FOLLOW_term_in_not_action_opfunction_term2629);
					t1=term();
					state._fsp--;

					((Abstract_Predicate) t).addTerm(t1);
					}

					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:2: ( COMMA (t2= term ) )*
					loop70:
					while (true) {
						int alt70=2;
						int LA70_0 = input.LA(1);
						if ( (LA70_0==COMMA) ) {
							alt70=1;
						}

						switch (alt70) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:3: COMMA (t2= term )
							{
							match(input,COMMA,FOLLOW_COMMA_in_not_action_opfunction_term2637); 
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:8: (t2= term )
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:11: t2= term
							{
							pushFollow(FOLLOW_term_in_not_action_opfunction_term2643);
							t2=term();
							state._fsp--;

							((Abstract_Predicate) t).addTerm(t2);
							}

							}
							break;

						default :
							break loop70;
						}
					}

					match(input,CLOSE,FOLLOW_CLOSE_in_not_action_opfunction_term2650); 
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
	// $ANTLR end "not_action_opfunction_term"



	// $ANTLR start "nested_function_term"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:435:1: nested_function_term returns [Abstract_Term t] : (c= CONST |s= goalkeywordsappearinginprolog ) ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )? ;
	public final Abstract_Term nested_function_term() throws RecognitionException {
		Abstract_Term t = null;


		Token c=null;
		String s =null;
		Abstract_Term t1 =null;
		Abstract_Term t2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:436:2: ( (c= CONST |s= goalkeywordsappearinginprolog ) ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:436:4: (c= CONST |s= goalkeywordsappearinginprolog ) ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )?
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:436:4: (c= CONST |s= goalkeywordsappearinginprolog )
			int alt72=2;
			int LA72_0 = input.LA(1);
			if ( (LA72_0==CONST) ) {
				alt72=1;
			}
			else if ( (LA72_0==DROP||LA72_0==INSERT||LA72_0==NOT) ) {
				alt72=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 72, 0, input);
				throw nvae;
			}

			switch (alt72) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:436:5: c= CONST
					{
					c=(Token)match(input,CONST,FOLLOW_CONST_in_nested_function_term2674); 
					t=new Abstract_Predicate(c.getText());
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:436:56: s= goalkeywordsappearinginprolog
					{
					pushFollow(FOLLOW_goalkeywordsappearinginprolog_in_nested_function_term2682);
					s=goalkeywordsappearinginprolog();
					state._fsp--;

					t=new Abstract_Predicate(s);
					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:437:2: ( OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE )?
			int alt74=2;
			int LA74_0 = input.LA(1);
			if ( (LA74_0==OPEN) ) {
				alt74=1;
			}
			switch (alt74) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:437:3: OPEN (t1= term ) ( COMMA (t2= term ) )* CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_nested_function_term2689); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:437:8: (t1= term )
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:437:11: t1= term
					{
					pushFollow(FOLLOW_term_in_nested_function_term2696);
					t1=term();
					state._fsp--;

					((Abstract_Predicate) t).addTerm(t1);
					}

					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:438:2: ( COMMA (t2= term ) )*
					loop73:
					while (true) {
						int alt73=2;
						int LA73_0 = input.LA(1);
						if ( (LA73_0==COMMA) ) {
							alt73=1;
						}

						switch (alt73) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:438:3: COMMA (t2= term )
							{
							match(input,COMMA,FOLLOW_COMMA_in_nested_function_term2704); 
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:438:9: (t2= term )
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:438:12: t2= term
							{
							pushFollow(FOLLOW_term_in_nested_function_term2711);
							t2=term();
							state._fsp--;

							((Abstract_Predicate) t).addTerm(t2);
							}

							}
							break;

						default :
							break loop73;
						}
					}

					match(input,CLOSE,FOLLOW_CLOSE_in_nested_function_term2718); 
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
	// $ANTLR end "nested_function_term"



	// $ANTLR start "goalkeywordsappearinginprolog"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:441:1: goalkeywordsappearinginprolog returns [String s] : ( NOT | DROP | INSERT ) ;
	public final String goalkeywordsappearinginprolog() throws RecognitionException {
		String s = null;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:442:2: ( ( NOT | DROP | INSERT ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:442:4: ( NOT | DROP | INSERT )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:442:4: ( NOT | DROP | INSERT )
			int alt75=3;
			switch ( input.LA(1) ) {
			case NOT:
				{
				alt75=1;
				}
				break;
			case DROP:
				{
				alt75=2;
				}
				break;
			case INSERT:
				{
				alt75=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 75, 0, input);
				throw nvae;
			}
			switch (alt75) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:442:5: NOT
					{
					match(input,NOT,FOLLOW_NOT_in_goalkeywordsappearinginprolog2736); 
					s = "not";
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:442:24: DROP
					{
					match(input,DROP,FOLLOW_DROP_in_goalkeywordsappearinginprolog2742); 
					s="drop";
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:442:42: INSERT
					{
					match(input,INSERT,FOLLOW_INSERT_in_goalkeywordsappearinginprolog2747); 
					s = "insert";
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
	// $ANTLR end "goalkeywordsappearinginprolog"



	// $ANTLR start "notnot_goalkeywordsappearinginprolog"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:444:1: notnot_goalkeywordsappearinginprolog returns [String s] : ( DROP | INSERT ) ;
	public final String notnot_goalkeywordsappearinginprolog() throws RecognitionException {
		String s = null;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:445:2: ( ( DROP | INSERT ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:445:4: ( DROP | INSERT )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:445:4: ( DROP | INSERT )
			int alt76=2;
			int LA76_0 = input.LA(1);
			if ( (LA76_0==DROP) ) {
				alt76=1;
			}
			else if ( (LA76_0==INSERT) ) {
				alt76=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 76, 0, input);
				throw nvae;
			}

			switch (alt76) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:445:5: DROP
					{
					match(input,DROP,FOLLOW_DROP_in_notnot_goalkeywordsappearinginprolog2764); 
					s="drop";
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:445:23: INSERT
					{
					match(input,INSERT,FOLLOW_INSERT_in_notnot_goalkeywordsappearinginprolog2769); 
					s = "insert";
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
	// $ANTLR end "notnot_goalkeywordsappearinginprolog"



	// $ANTLR start "not_action_opgoalkeywordsappearinginprolog"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:447:1: not_action_opgoalkeywordsappearinginprolog returns [String s] : ( NOT ) ;
	public final String not_action_opgoalkeywordsappearinginprolog() throws RecognitionException {
		String s = null;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:448:2: ( ( NOT ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:448:4: ( NOT )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:448:4: ( NOT )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:448:5: NOT
			{
			match(input,NOT,FOLLOW_NOT_in_not_action_opgoalkeywordsappearinginprolog2787); 
			s = "not";
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
	// $ANTLR end "not_action_opgoalkeywordsappearinginprolog"



	// $ANTLR start "var"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:451:1: var returns [Abstract_VarTerm v] : ( VAR | UNNAMEDVAR ) ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR3=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:452:2: ( ( VAR | UNNAMEDVAR ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:452:4: ( VAR | UNNAMEDVAR )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:452:4: ( VAR | UNNAMEDVAR )
			int alt77=2;
			int LA77_0 = input.LA(1);
			if ( (LA77_0==VAR) ) {
				alt77=1;
			}
			else if ( (LA77_0==UNNAMEDVAR) ) {
				alt77=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 77, 0, input);
				throw nvae;
			}

			switch (alt77) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:452:5: VAR
					{
					VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_var2806); 
					if (variables.containsKey(VAR3.getText())) {
							v = variables.get(VAR3.getText());
						            } else {
							v = new Abstract_VarTerm(VAR3.getText());
					                                                     variables.put(VAR3.getText(), v);
						           }
						
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:458:6: UNNAMEDVAR
					{
					match(input,UNNAMEDVAR,FOLLOW_UNNAMEDVAR_in_var2812); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:460:1: stringLiteral returns [Abstract_StringTerm s] : st= stringterm ;
	public final Abstract_StringTerm stringLiteral() throws RecognitionException {
		Abstract_StringTerm s = null;


		Abstract_StringTerm st =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:461:2: (st= stringterm )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:461:4: st= stringterm
			{
			pushFollow(FOLLOW_stringterm_in_stringLiteral2830);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:462:1: singleQuotedStringLiteral returns [Abstract_StringTerm s] : SINGLEQUOTE w= word SINGLEQUOTE ;
	public final Abstract_StringTerm singleQuotedStringLiteral() throws RecognitionException {
		Abstract_StringTerm s = null;


		String w =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:463:2: ( SINGLEQUOTE w= word SINGLEQUOTE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:463:4: SINGLEQUOTE w= word SINGLEQUOTE
			{
			match(input,SINGLEQUOTE,FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2844); 
			pushFollow(FOLLOW_word_in_singleQuotedStringLiteral2848);
			w=word();
			state._fsp--;

			match(input,SINGLEQUOTE,FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2850); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:465:1: stringterm returns [Abstract_StringTerm s] : STRING ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING4=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:466:2: ( STRING )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:466:4: STRING
			{
			STRING4=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm2867); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:469:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST5=null;
		Token VAR6=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:469:25: ( ( CONST | VAR ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:469:27: ( CONST | VAR )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:469:27: ( CONST | VAR )
			int alt78=2;
			int LA78_0 = input.LA(1);
			if ( (LA78_0==CONST) ) {
				alt78=1;
			}
			else if ( (LA78_0==VAR) ) {
				alt78=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 78, 0, input);
				throw nvae;
			}

			switch (alt78) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:469:28: CONST
					{
					CONST5=(Token)match(input,CONST,FOLLOW_CONST_in_word2884); 
					s =CONST5.getText();
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:469:59: VAR
					{
					VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_word2890); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:471:1: listterm returns [Abstract_ListTermImpl l] : SQOPEN (h= term ( COMMA t= term )* ( BAR v= var )? )? SQCLOSE ;
	public final Abstract_ListTermImpl listterm() throws RecognitionException {
		Abstract_ListTermImpl l = null;


		Abstract_Term h =null;
		Abstract_Term t =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:472:3: ( SQOPEN (h= term ( COMMA t= term )* ( BAR v= var )? )? SQCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:472:5: SQOPEN (h= term ( COMMA t= term )* ( BAR v= var )? )? SQCLOSE
			{
			l = new Abstract_ListTermImpl(); Abstract_ListTerm lrunning = l;
			match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2911); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:473:10: (h= term ( COMMA t= term )* ( BAR v= var )? )?
			int alt81=2;
			int LA81_0 = input.LA(1);
			if ( (LA81_0==CONST||LA81_0==DROP||LA81_0==INSERT||LA81_0==MINUS||(LA81_0 >= NOT && LA81_0 <= NUMBER)||LA81_0==SQOPEN||LA81_0==STRING||(LA81_0 >= UNNAMEDVAR && LA81_0 <= VAR)) ) {
				alt81=1;
			}
			switch (alt81) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:473:11: h= term ( COMMA t= term )* ( BAR v= var )?
					{
					pushFollow(FOLLOW_term_in_listterm2916);
					h=term();
					state._fsp--;

					l.addHead(h); l.addTail(new Abstract_ListTermImpl());
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:474:3: ( COMMA t= term )*
					loop79:
					while (true) {
						int alt79=2;
						int LA79_0 = input.LA(1);
						if ( (LA79_0==COMMA) ) {
							alt79=1;
						}

						switch (alt79) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:474:4: COMMA t= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_listterm2923); 
							pushFollow(FOLLOW_term_in_listterm2927);
							t=term();
							state._fsp--;

							Abstract_ListTerm l2 = new Abstract_ListTermImpl(); l2.addHead(t); l2.addTail(new Abstract_ListTermImpl()); lrunning.addTail(l2); lrunning=l2;
							}
							break;

						default :
							break loop79;
						}
					}

					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:475:3: ( BAR v= var )?
					int alt80=2;
					int LA80_0 = input.LA(1);
					if ( (LA80_0==BAR) ) {
						alt80=1;
					}
					switch (alt80) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:475:4: BAR v= var
							{
							match(input,BAR,FOLLOW_BAR_in_listterm2936); 
							pushFollow(FOLLOW_var_in_listterm2940);
							v=var();
							state._fsp--;

							lrunning.addTail(v);
							}
							break;

					}

					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2952); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:479:1: equation returns [Abstract_Equation e] : ( (a1= arithexprg i= eqoper a2= arithexpr ) | (v= var ( EQUALS | IS ) (a2= arithexpr | (ft= notnot_function_term |st= stringterm |lt= listterm ) ) ) );
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation e = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;
		Abstract_VarTerm v =null;
		Abstract_Predicate ft =null;
		Abstract_StringTerm st =null;
		Abstract_ListTermImpl lt =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:480:2: ( (a1= arithexprg i= eqoper a2= arithexpr ) | (v= var ( EQUALS | IS ) (a2= arithexpr | (ft= notnot_function_term |st= stringterm |lt= listterm ) ) ) )
			int alt84=2;
			int LA84_0 = input.LA(1);
			if ( (LA84_0==MINUS||LA84_0==NUMBER) ) {
				alt84=1;
			}
			else if ( ((LA84_0 >= UNNAMEDVAR && LA84_0 <= VAR)) ) {
				alt84=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 84, 0, input);
				throw nvae;
			}

			switch (alt84) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:480:4: (a1= arithexprg i= eqoper a2= arithexpr )
					{
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:480:4: (a1= arithexprg i= eqoper a2= arithexpr )
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:480:6: a1= arithexprg i= eqoper a2= arithexpr
					{
					pushFollow(FOLLOW_arithexprg_in_equation2972);
					a1=arithexprg();
					state._fsp--;

					pushFollow(FOLLOW_eqoper_in_equation2976);
					i=eqoper();
					state._fsp--;

					pushFollow(FOLLOW_arithexpr_in_equation2980);
					a2=arithexpr();
					state._fsp--;

					e = new Abstract_Equation(a1, i, a2);
					}

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:481:5: (v= var ( EQUALS | IS ) (a2= arithexpr | (ft= notnot_function_term |st= stringterm |lt= listterm ) ) )
					{
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:481:5: (v= var ( EQUALS | IS ) (a2= arithexpr | (ft= notnot_function_term |st= stringterm |lt= listterm ) ) )
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:481:6: v= var ( EQUALS | IS ) (a2= arithexpr | (ft= notnot_function_term |st= stringterm |lt= listterm ) )
					{
					pushFollow(FOLLOW_var_in_equation2995);
					v=var();
					state._fsp--;

					if ( input.LA(1)==EQUALS||input.LA(1)==IS ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:481:28: (a2= arithexpr | (ft= notnot_function_term |st= stringterm |lt= listterm ) )
					int alt83=2;
					int LA83_0 = input.LA(1);
					if ( (LA83_0==MINUS||LA83_0==NUMBER||(LA83_0 >= UNNAMEDVAR && LA83_0 <= VAR)) ) {
						alt83=1;
					}
					else if ( (LA83_0==CONST||LA83_0==DROP||LA83_0==INSERT||LA83_0==SQOPEN||LA83_0==STRING) ) {
						alt83=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 83, 0, input);
						throw nvae;
					}

					switch (alt83) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:481:29: a2= arithexpr
							{
							pushFollow(FOLLOW_arithexpr_in_equation3010);
							a2=arithexpr();
							state._fsp--;

							e = new Abstract_Equation(v, 2, a2);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:482:6: (ft= notnot_function_term |st= stringterm |lt= listterm )
							{
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:482:6: (ft= notnot_function_term |st= stringterm |lt= listterm )
							int alt82=3;
							switch ( input.LA(1) ) {
							case CONST:
							case DROP:
							case INSERT:
								{
								alt82=1;
								}
								break;
							case STRING:
								{
								alt82=2;
								}
								break;
							case SQOPEN:
								{
								alt82=3;
								}
								break;
							default:
								NoViableAltException nvae =
									new NoViableAltException("", 82, 0, input);
								throw nvae;
							}
							switch (alt82) {
								case 1 :
									// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:482:7: ft= notnot_function_term
									{
									pushFollow(FOLLOW_notnot_function_term_in_equation3025);
									ft=notnot_function_term();
									state._fsp--;

									e = new Abstract_Equation(v, 3, ft);
									}
									break;
								case 2 :
									// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:483:8: st= stringterm
									{
									pushFollow(FOLLOW_stringterm_in_equation3039);
									st=stringterm();
									state._fsp--;

									e = new Abstract_Equation(v, 3, st);
									}
									break;
								case 3 :
									// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:484:8: lt= listterm
									{
									pushFollow(FOLLOW_listterm_in_equation3054);
									lt=listterm();
									state._fsp--;

									e = new Abstract_Equation(v, 3, lt);
									}
									break;

							}

							}
							break;

					}

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
		return e;
	}
	// $ANTLR end "equation"



	// $ANTLR start "forall_expr"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:486:1: forall_expr returns [ArrayList<Abstract_LogicalFormula> ts] : 'forall' OPEN t1= atom COMMA t2= atom CLOSE ;
	public final ArrayList<Abstract_LogicalFormula> forall_expr() throws RecognitionException {
		ArrayList<Abstract_LogicalFormula> ts = null;


		Abstract_LogicalFormula t1 =null;
		Abstract_LogicalFormula t2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:487:2: ( 'forall' OPEN t1= atom COMMA t2= atom CLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:487:5: 'forall' OPEN t1= atom COMMA t2= atom CLOSE
			{
			ArrayList<Abstract_LogicalFormula> tl = new ArrayList<Abstract_LogicalFormula>();
			match(input,78,FOLLOW_78_in_forall_expr3077); 
			match(input,OPEN,FOLLOW_OPEN_in_forall_expr3079); 
			pushFollow(FOLLOW_atom_in_forall_expr3083);
			t1=atom();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_forall_expr3085); 
			pushFollow(FOLLOW_atom_in_forall_expr3089);
			t2=atom();
			state._fsp--;

			Abstract_LogExpr l = new Abstract_LogExpr(t1, Abstract_LogExpr.forall, t2); tl.add(l);
			match(input,CLOSE,FOLLOW_CLOSE_in_forall_expr3093); 
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



	// $ANTLR start "numberstring"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:493:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:494:2: ( ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:494:4: ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? )
			{
			s = "";
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:494:15: ( MINUS )?
			int alt85=2;
			int LA85_0 = input.LA(1);
			if ( (LA85_0==MINUS) ) {
				alt85=1;
			}
			switch (alt85) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:494:16: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring3116); 
					s += "-";
					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:495:2: (n1= NUMBER ( STOP n2= NUMBER )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:495:3: n1= NUMBER ( STOP n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring3127); 
			s += n1.getText();
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:496:2: ( STOP n2= NUMBER )?
			int alt86=2;
			int LA86_0 = input.LA(1);
			if ( (LA86_0==STOP) ) {
				int LA86_1 = input.LA(2);
				if ( (LA86_1==NUMBER) ) {
					alt86=1;
				}
			}
			switch (alt86) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:496:3: STOP n2= NUMBER
					{
					match(input,STOP,FOLLOW_STOP_in_numberstring3133); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring3139); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:498:1: arithexpr returns [Abstract_NumberTerm ae] : a1= multexpr (i= addoper a2= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:499:2: (a1= multexpr (i= addoper a2= multexpr )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:499:4: a1= multexpr (i= addoper a2= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr3159);
			a1=multexpr();
			state._fsp--;

			ae = a1;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:499:28: (i= addoper a2= multexpr )?
			int alt87=2;
			int LA87_0 = input.LA(1);
			if ( (LA87_0==MINUS||LA87_0==PLUS) ) {
				alt87=1;
			}
			switch (alt87) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:499:29: i= addoper a2= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr3166);
					i=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr3170);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:500:1: multexpr returns [Abstract_NumberTerm ae] : a1= atom_term (i= multoper a2= atom_term )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:501:2: (a1= atom_term (i= multoper a2= atom_term )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:501:4: a1= atom_term (i= multoper a2= atom_term )?
			{
			pushFollow(FOLLOW_atom_term_in_multexpr3188);
			a1=atom_term();
			state._fsp--;

			ae = a1;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:501:28: (i= multoper a2= atom_term )?
			int alt88=2;
			int LA88_0 = input.LA(1);
			if ( (LA88_0==DIV||LA88_0==MULT) ) {
				alt88=1;
			}
			switch (alt88) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:501:29: i= multoper a2= atom_term
					{
					pushFollow(FOLLOW_multoper_in_multexpr3194);
					i=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_term_in_multexpr3198);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:503:1: atom_term returns [Abstract_NumberTerm t] : (n= numberstring |v= var ) ;
	public final Abstract_NumberTerm atom_term() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:504:2: ( (n= numberstring |v= var ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:504:4: (n= numberstring |v= var )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:504:4: (n= numberstring |v= var )
			int alt89=2;
			int LA89_0 = input.LA(1);
			if ( (LA89_0==MINUS||LA89_0==NUMBER) ) {
				alt89=1;
			}
			else if ( ((LA89_0 >= UNNAMEDVAR && LA89_0 <= VAR)) ) {
				alt89=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 89, 0, input);
				throw nvae;
			}

			switch (alt89) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:504:5: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom_term3220);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:504:66: v= var
					{
					pushFollow(FOLLOW_var_in_atom_term3228);
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



	// $ANTLR start "arithexprg"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:507:1: arithexprg returns [Abstract_NumberTerm ae] : a1= multexprg (i= addoper a2= multexpr )? ;
	public final Abstract_NumberTerm arithexprg() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:508:2: (a1= multexprg (i= addoper a2= multexpr )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:508:4: a1= multexprg (i= addoper a2= multexpr )?
			{
			pushFollow(FOLLOW_multexprg_in_arithexprg3249);
			a1=multexprg();
			state._fsp--;

			ae = a1;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:508:29: (i= addoper a2= multexpr )?
			int alt90=2;
			int LA90_0 = input.LA(1);
			if ( (LA90_0==MINUS||LA90_0==PLUS) ) {
				alt90=1;
			}
			switch (alt90) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:508:30: i= addoper a2= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexprg3256);
					i=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexprg3260);
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
	// $ANTLR end "arithexprg"



	// $ANTLR start "multexprg"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:509:1: multexprg returns [Abstract_NumberTerm ae] : a1= atom_termg (i= multoper a2= atom_term )? ;
	public final Abstract_NumberTerm multexprg() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:510:2: (a1= atom_termg (i= multoper a2= atom_term )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:510:4: a1= atom_termg (i= multoper a2= atom_term )?
			{
			pushFollow(FOLLOW_atom_termg_in_multexprg3278);
			a1=atom_termg();
			state._fsp--;

			ae = a1;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:510:29: (i= multoper a2= atom_term )?
			int alt91=2;
			int LA91_0 = input.LA(1);
			if ( (LA91_0==DIV||LA91_0==MULT) ) {
				alt91=1;
			}
			switch (alt91) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:510:30: i= multoper a2= atom_term
					{
					pushFollow(FOLLOW_multoper_in_multexprg3284);
					i=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_term_in_multexprg3288);
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
	// $ANTLR end "multexprg"



	// $ANTLR start "atom_termg"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:512:1: atom_termg returns [Abstract_NumberTerm t] : n= numberstring ;
	public final Abstract_NumberTerm atom_termg() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:513:2: (n= numberstring )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:513:4: n= numberstring
			{
			pushFollow(FOLLOW_numberstring_in_atom_termg3309);
			n=numberstring();
			state._fsp--;

			t = new Abstract_NumberTermImpl(n);
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
	// $ANTLR end "atom_termg"



	// $ANTLR start "addoper"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:517:1: addoper returns [int i] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:518:2: ( ( PLUS | MINUS ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:518:4: ( PLUS | MINUS )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:518:4: ( PLUS | MINUS )
			int alt92=2;
			int LA92_0 = input.LA(1);
			if ( (LA92_0==PLUS) ) {
				alt92=1;
			}
			else if ( (LA92_0==MINUS) ) {
				alt92=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 92, 0, input);
				throw nvae;
			}

			switch (alt92) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:518:5: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper3329); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:518:22: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper3335); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:519:1: multoper returns [int i] : ( MULT | DIV ) ;
	public final int multoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:520:2: ( ( MULT | DIV ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:520:4: ( MULT | DIV )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:520:4: ( MULT | DIV )
			int alt93=2;
			int LA93_0 = input.LA(1);
			if ( (LA93_0==MULT) ) {
				alt93=1;
			}
			else if ( (LA93_0==DIV) ) {
				alt93=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 93, 0, input);
				throw nvae;
			}

			switch (alt93) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:520:5: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper3352); 
					i = 3;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:520:22: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper3358); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:521:1: eqoper returns [int i] : ( LESS | ( IS | EQUALS ) ) ;
	public final int eqoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:521:24: ( ( LESS | ( IS | EQUALS ) ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:521:26: ( LESS | ( IS | EQUALS ) )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:521:26: ( LESS | ( IS | EQUALS ) )
			int alt94=2;
			int LA94_0 = input.LA(1);
			if ( (LA94_0==LESS) ) {
				alt94=1;
			}
			else if ( (LA94_0==EQUALS||LA94_0==IS) ) {
				alt94=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 94, 0, input);
				throw nvae;
			}

			switch (alt94) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:521:27: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper3374); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:521:44: ( IS | EQUALS )
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



	public static final BitSet FOLLOW_moduleImport_in_mas72 = new BitSet(new long[]{0x0000014020400002L,0x0000000000000004L});
	public static final BitSet FOLLOW_module_in_mas78 = new BitSet(new long[]{0x0000014020400002L,0x0000000000000004L});
	public static final BitSet FOLLOW_moduleImport_in_goalagent107 = new BitSet(new long[]{0x0000014020400002L,0x0000000000000004L});
	public static final BitSet FOLLOW_module_in_goalagent113 = new BitSet(new long[]{0x0000014020400002L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_moduleImport126 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_MODULEFILE_in_moduleImport128 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_STOP_in_moduleImport130 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_moduleDef_in_module147 = new BitSet(new long[]{0x0400000000010000L});
	public static final BitSet FOLLOW_SQOPEN_in_module152 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002400L});
	public static final BitSet FOLLOW_moduleOption_in_module154 = new BitSet(new long[]{0x0200000000001000L});
	public static final BitSet FOLLOW_COMMA_in_module158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002400L});
	public static final BitSet FOLLOW_moduleOption_in_module160 = new BitSet(new long[]{0x0200000000001000L});
	public static final BitSet FOLLOW_SQCLOSE_in_module165 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module170 = new BitSet(new long[]{0x0008000204008210L,0x0000000000000004L});
	public static final BitSet FOLLOW_krImport_in_module172 = new BitSet(new long[]{0x0008000204008210L});
	public static final BitSet FOLLOW_knowledge_in_module175 = new BitSet(new long[]{0x0008000004008210L});
	public static final BitSet FOLLOW_beliefs_in_module180 = new BitSet(new long[]{0x0008000004008010L});
	public static final BitSet FOLLOW_goals_in_module184 = new BitSet(new long[]{0x0008000000008010L});
	public static final BitSet FOLLOW_program_in_module188 = new BitSet(new long[]{0x0000000000008010L});
	public static final BitSet FOLLOW_actionSpecs_in_module197 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module205 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef220 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000001L});
	public static final BitSet FOLLOW_declaration_in_moduleDef224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INIT_in_moduleDef231 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_moduleDef240 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EVENT_in_moduleDef249 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_74_in_moduleOption270 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_EQUALS_in_moduleOption272 = new BitSet(new long[]{0x0000000000000000L,0x00000000001A0100L});
	public static final BitSet FOLLOW_72_in_moduleOption279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_81_in_moduleOption289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_moduleOption299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_83_in_moduleOption310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_moduleOption324 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_EQUALS_in_moduleOption326 = new BitSet(new long[]{0x0000000000000000L,0x0000000000A41000L});
	public static final BitSet FOLLOW_set_in_moduleOption332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_66_in_krImport357 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_stringLiteral_in_krImport360 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_singleQuotedStringLiteral_in_krImport364 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_STOP_in_krImport367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KNOWLEDGE_in_knowledge380 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_knowledge382 = new BitSet(new long[]{0x0000100040104000L});
	public static final BitSet FOLLOW_krspec_in_knowledge384 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_knowledge387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_krspec399 = new BitSet(new long[]{0x0810000000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec403 = new BitSet(new long[]{0x0000100040104002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_krspec410 = new BitSet(new long[]{0x8000308040104000L,0x0000000000004001L});
	public static final BitSet FOLLOW_no_bracket_literals_in_krspec416 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_forall_expr_in_krspec422 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec426 = new BitSet(new long[]{0x0000100040104002L});
	public static final BitSet FOLLOW_BELIEFS_in_beliefs443 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_beliefs445 = new BitSet(new long[]{0x0000100040104000L});
	public static final BitSet FOLLOW_brspec_in_beliefs447 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_beliefs450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_brspec462 = new BitSet(new long[]{0x0810000000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec466 = new BitSet(new long[]{0x0000100040104002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_brspec473 = new BitSet(new long[]{0x8000308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_no_bracket_literals_in_brspec477 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec479 = new BitSet(new long[]{0x0000100040104002L});
	public static final BitSet FOLLOW_GOALS_in_goals496 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_goals498 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goal_list_in_goals502 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_goals506 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_atom520 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_OPEN_in_atom522 = new BitSet(new long[]{0x8000308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_atom528 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_equation_in_atom538 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_atom544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notnot_declarationOrCallWithTerms_in_atom551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_atom560 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROGRAM_in_program575 = new BitSet(new long[]{0x0400000000010000L});
	public static final BitSet FOLLOW_SQOPEN_in_program578 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_ruleEvaluationOrder_in_program582 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_program586 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program592 = new BitSet(new long[]{0x0000000018008000L,0x000000000000C000L});
	public static final BitSet FOLLOW_macroDef_in_program594 = new BitSet(new long[]{0x0000000018008000L,0x000000000000C000L});
	public static final BitSet FOLLOW_programRule_in_program602 = new BitSet(new long[]{0x0000000010008000L,0x000000000000C000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program608 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_in_ruleEvaluationOrder625 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_EQUALS_in_ruleEvaluationOrder627 = new BitSet(new long[]{0x0060001800000020L});
	public static final BitSet FOLLOW_LINEAR_in_ruleEvaluationOrder631 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LINEARALL_in_ruleEvaluationOrder638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANDOM_in_ruleEvaluationOrder644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANDOMALL_in_ruleEvaluationOrder650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADAPTIVE_in_ruleEvaluationOrder657 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HASH_in_macroDef671 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_DEFINE_in_macroDef673 = new BitSet(new long[]{0x0000100040104000L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_macroDef677 = new BitSet(new long[]{0x4000100043104140L,0x00000000390000C1L});
	public static final BitSet FOLLOW_mentalstatecond_in_macroDef682 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_STOP_in_macroDef688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_programRule705 = new BitSet(new long[]{0x4000100043104140L,0x00000000390000C1L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule709 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_THEN_in_programRule713 = new BitSet(new long[]{0x0000104060514000L,0x000000003F410AE1L});
	public static final BitSet FOLLOW_actions_in_programRule719 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule723 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule727 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_programRule736 = new BitSet(new long[]{0x4000100043104140L,0x00000000390000C1L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule742 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule746 = new BitSet(new long[]{0x0000104060514000L,0x000000003F410AE1L});
	public static final BitSet FOLLOW_actions_in_programRule751 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule755 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule759 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_programRule767 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_var_in_programRule773 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_programRule775 = new BitSet(new long[]{0x4000100043104140L,0x00000000390000C1L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule779 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule786 = new BitSet(new long[]{0x0000104060514000L,0x000000003F410AE1L});
	public static final BitSet FOLLOW_actions_in_programRule791 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule796 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule800 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_programRule809 = new BitSet(new long[]{0x4000100043104140L,0x00000000390000C1L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule811 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_programRule813 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_var_in_programRule815 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule817 = new BitSet(new long[]{0x0000104060514000L,0x000000003F410AE1L});
	public static final BitSet FOLLOW_actions_in_programRule820 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule822 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule826 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURLYOPEN_in_nestedRules843 = new BitSet(new long[]{0x0000000010000000L,0x000000000000C000L});
	public static final BitSet FOLLOW_programRule_in_nestedRules850 = new BitSet(new long[]{0x0000000010008000L,0x000000000000C000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_nestedRules857 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_basicCondition_in_mentalstatecond875 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_mentalstatecond881 = new BitSet(new long[]{0x4000100043104140L,0x00000000390000C1L});
	public static final BitSet FOLLOW_basicCondition_in_mentalstatecond885 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_mentalatom_in_mentalstate908 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_mentalstate915 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalstate917 = new BitSet(new long[]{0x0000000003004140L,0x00000000390000C1L});
	public static final BitSet FOLLOW_mentalatom_in_mentalstate921 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_mentalstate925 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_mentalstate930 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mentalstate_in_basicCondition950 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_basicCondition959 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selector_in_mentalatom979 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_STOP_in_mentalatom981 = new BitSet(new long[]{0x0000000003000140L});
	public static final BitSet FOLLOW_mentalOperator_in_mentalatom987 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_atom_parameters_in_mentalatom991 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom_parameters1011 = new BitSet(new long[]{0x8000708040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_atom_in_atom_parameters1020 = new BitSet(new long[]{0x0080000000001400L});
	public static final BitSet FOLLOW_COMMA_in_atom_parameters1026 = new BitSet(new long[]{0x8000708040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_atom_in_atom_parameters1033 = new BitSet(new long[]{0x0080000000001400L});
	public static final BitSet FOLLOW_atom_parameters_in_atom_parameters1043 = new BitSet(new long[]{0x0080000000001400L});
	public static final BitSet FOLLOW_SEMI_in_atom_parameters1051 = new BitSet(new long[]{0x8000708040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_atom_in_atom_parameters1059 = new BitSet(new long[]{0x0080000000001400L});
	public static final BitSet FOLLOW_atom_parameters_in_atom_parameters1069 = new BitSet(new long[]{0x0080000000001400L});
	public static final BitSet FOLLOW_atom_parameters_in_atom_parameters1087 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_atom_parameters1095 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEL_in_mentalOperator1116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_mentalOperator1127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AGOAL_in_mentalOperator1138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOALA_in_mentalOperator1149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actions1172 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_PLUS_in_actions1179 = new BitSet(new long[]{0x0000104060504000L,0x000000003F410AE1L});
	public static final BitSet FOLLOW_action_in_actions1183 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_selector_in_action1203 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_STOP_in_action1205 = new BitSet(new long[]{0x0000000040100000L,0x0000000006410220L});
	public static final BitSet FOLLOW_actionOperator_in_action1211 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_parameters_in_action1215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_75_in_action1227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_action1236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INIT_in_action1245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_action1254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EVENT_in_action1263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_not_action_opdeclarationOrCallWithTerms_in_action1270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_actionOperator1291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_actionOperator1302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INSERT_in_actionOperator1313 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_73_in_actionOperator1324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_89_in_actionOperator1336 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_90_in_actionOperator1345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_86_in_actionOperator1354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_actionOperator1365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_selector1377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_selector1386 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_selector1395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_88_in_selector1404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_91_in_selector1413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_92_in_selector1422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_93_in_selector1431 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTIONSPEC_in_actionSpecs1450 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionSpecs1452 = new BitSet(new long[]{0x0000100040104000L});
	public static final BitSet FOLLOW_actionSpec_in_actionSpecs1457 = new BitSet(new long[]{0x000010004010C000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionSpecs1463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_actionSpec1482 = new BitSet(new long[]{0x0000000080810000L});
	public static final BitSet FOLLOW_INTERNAL_in_actionSpec1485 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_EXTERNAL_in_actionSpec1491 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionSpec1497 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_precondition_in_actionSpec1501 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_postcondition_in_actionSpec1505 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionSpec1507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRE_in_precondition1525 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_precondition1527 = new BitSet(new long[]{0xC000708040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_TRUE_in_precondition1531 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_precondition1541 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_atom_parameters_in_precondition1552 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_precondition1558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POST_in_postcondition1573 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_postcondition1576 = new BitSet(new long[]{0xC000308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_TRUE_in_postcondition1580 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_postcondition1590 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_postcondition1599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_declaration1616 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_parameters_in_declaration1623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_function_term_in_declarationOrCallWithTerms1644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notnot_function_term_in_notnot_declarationOrCallWithTerms1664 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_not_action_opfunction_term_in_not_action_opdeclarationOrCallWithTerms1684 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_id1703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_id1710 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_not_action_opparameters1733 = new BitSet(new long[]{0x9400308000004000L,0x0000000000000001L});
	public static final BitSet FOLLOW_NOT_in_not_action_opparameters1739 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_OPEN_in_not_action_opparameters1743 = new BitSet(new long[]{0x9400308000004000L,0x0000000000000001L});
	public static final BitSet FOLLOW_not_action_opterm_in_not_action_opparameters1747 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_not_action_opparameters1749 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_toplevelterm_in_not_action_opparameters1756 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_not_action_opparameters1766 = new BitSet(new long[]{0x9400308000004000L,0x0000000000000001L});
	public static final BitSet FOLLOW_NOT_in_not_action_opparameters1772 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_OPEN_in_not_action_opparameters1776 = new BitSet(new long[]{0x9400308000004000L,0x0000000000000001L});
	public static final BitSet FOLLOW_not_action_opterm_in_not_action_opparameters1780 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_not_action_opparameters1782 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_toplevelterm_in_not_action_opparameters1791 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_not_action_opparameters1800 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_parameters1818 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_parameters1823 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_parameters1832 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_parameters1836 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_parameters1845 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_no_bracket_parameters1867 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_no_bracket_parameters1873 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_no_bracket_parameters1877 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_atom_in_no_bracket_literals1908 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_no_bracket_literals1914 = new BitSet(new long[]{0x8000308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_atom_in_no_bracket_literals1921 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_term_in_goal_list1953 = new BitSet(new long[]{0x0800000000001000L});
	public static final BitSet FOLLOW_COMMA_in_goal_list1960 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_goal_list1964 = new BitSet(new long[]{0x0800000000001000L});
	public static final BitSet FOLLOW_STOP_in_goal_list1971 = new BitSet(new long[]{0x9400308040104002L,0x0000000000000001L});
	public static final BitSet FOLLOW_stringterm_in_term2278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_function_term_in_term2288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_term2298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_term2307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_toplevelterm2328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_toplevelterm2338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_toplevelterm2348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_toplevelterm2357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_notnotterm2377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notnot_function_term_in_notnotterm2387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_notnotterm2397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_notnotterm2406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_not_action_opterm2426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_not_action_opfunction_term_in_not_action_opterm2436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_not_action_opterm2446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_not_action_opterm2455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function_term2475 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_OPEN_in_function_term2482 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_function_term2489 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_function_term2497 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_function_term2504 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_function_term2512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_notnot_function_term2536 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_notnot_goalkeywordsappearinginprolog_in_notnot_function_term2547 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_OPEN_in_notnot_function_term2557 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_notnot_function_term2564 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_notnot_function_term2572 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_notnot_function_term2580 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_notnot_function_term2587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_not_action_opfunction_term2608 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_not_action_opgoalkeywordsappearinginprolog_in_not_action_opfunction_term2616 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_OPEN_in_not_action_opfunction_term2623 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_not_action_opfunction_term2629 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_not_action_opfunction_term2637 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_not_action_opfunction_term2643 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_not_action_opfunction_term2650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_nested_function_term2674 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_goalkeywordsappearinginprolog_in_nested_function_term2682 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_OPEN_in_nested_function_term2689 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_nested_function_term2696 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_nested_function_term2704 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_nested_function_term2711 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_nested_function_term2718 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_goalkeywordsappearinginprolog2736 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_goalkeywordsappearinginprolog2742 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INSERT_in_goalkeywordsappearinginprolog2747 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_notnot_goalkeywordsappearinginprolog2764 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INSERT_in_notnot_goalkeywordsappearinginprolog2769 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_not_action_opgoalkeywordsappearinginprolog2787 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var2806 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNNAMEDVAR_in_var2812 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_stringLiteral2830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2844 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000001L});
	public static final BitSet FOLLOW_word_in_singleQuotedStringLiteral2848 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2850 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_stringterm2867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_word2884 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word2890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_listterm2911 = new BitSet(new long[]{0x9600308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_listterm2916 = new BitSet(new long[]{0x0200000000001080L});
	public static final BitSet FOLLOW_COMMA_in_listterm2923 = new BitSet(new long[]{0x9400308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_term_in_listterm2927 = new BitSet(new long[]{0x0200000000001080L});
	public static final BitSet FOLLOW_BAR_in_listterm2936 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_var_in_listterm2940 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_listterm2952 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexprg_in_equation2972 = new BitSet(new long[]{0x0000000500200000L});
	public static final BitSet FOLLOW_eqoper_in_equation2976 = new BitSet(new long[]{0x8000208000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_arithexpr_in_equation2980 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_equation2995 = new BitSet(new long[]{0x0000000100200000L});
	public static final BitSet FOLLOW_set_in_equation2997 = new BitSet(new long[]{0x9400208040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_arithexpr_in_equation3010 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notnot_function_term_in_equation3025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_equation3039 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_equation3054 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_forall_expr3077 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_OPEN_in_forall_expr3079 = new BitSet(new long[]{0x8000308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_atom_in_forall_expr3083 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COMMA_in_forall_expr3085 = new BitSet(new long[]{0x8000308040104000L,0x0000000000000001L});
	public static final BitSet FOLLOW_atom_in_forall_expr3089 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_forall_expr3093 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring3116 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring3127 = new BitSet(new long[]{0x0800000000000002L});
	public static final BitSet FOLLOW_STOP_in_numberstring3133 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring3139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr3159 = new BitSet(new long[]{0x0001008000000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr3166 = new BitSet(new long[]{0x8000208000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr3170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_term_in_multexpr3188 = new BitSet(new long[]{0x0000040000040002L});
	public static final BitSet FOLLOW_multoper_in_multexpr3194 = new BitSet(new long[]{0x8000208000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_atom_term_in_multexpr3198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom_term3220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom_term3228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexprg_in_arithexprg3249 = new BitSet(new long[]{0x0001008000000002L});
	public static final BitSet FOLLOW_addoper_in_arithexprg3256 = new BitSet(new long[]{0x8000208000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_multexpr_in_arithexprg3260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_termg_in_multexprg3278 = new BitSet(new long[]{0x0000040000040002L});
	public static final BitSet FOLLOW_multoper_in_multexprg3284 = new BitSet(new long[]{0x8000208000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_atom_term_in_multexprg3288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom_termg3309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper3329 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper3335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper3352 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper3358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper3374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_eqoper3380 = new BitSet(new long[]{0x0000000000000002L});
}
