// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2015-12-01 17:56:04

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:54:1: mas returns [Abstract_MAS mas] : ( moduleImport |gm= module )+ ;
	public final Abstract_MAS mas() throws RecognitionException {
		Abstract_MAS mas = null;


		Abstract_GOALModule gm =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:2: ( ( moduleImport |gm= module )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:55:4: ( moduleImport |gm= module )+
			{
			mas = new Abstract_MAS(); ArrayList<Abstract_GOALAgent> agents = new ArrayList<Abstract_GOALAgent>();
			 Abstract_GOALAgent gl = new Abstract_GOALAgent("goal_agent"); agents.add(gl);
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
					pushFollow(FOLLOW_moduleImport_in_mas80);
					moduleImport();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:58:18: gm= module
					{
					pushFollow(FOLLOW_module_in_mas86);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:1: goalagent returns [Abstract_GOALAgent gl] : ( moduleImport |gm= module )+ ;
	public final Abstract_GOALAgent goalagent() throws RecognitionException {
		Abstract_GOALAgent gl = null;


		Abstract_GOALModule gm =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:64:2: ( ( moduleImport |gm= module )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:64:4: ( moduleImport |gm= module )+
			{
			 gl = new Abstract_GOALAgent("goal_agent");
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:2: ( moduleImport |gm= module )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:3: moduleImport
					{
					pushFollow(FOLLOW_moduleImport_in_goalagent115);
					moduleImport();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:65:18: gm= module
					{
					pushFollow(FOLLOW_module_in_goalagent121);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:1: moduleImport : '#import' MODULEFILE STOP ;
	public final void moduleImport() throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:2: ( '#import' MODULEFILE STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:4: '#import' MODULEFILE STOP
			{
			match(input,64,FOLLOW_64_in_moduleImport134); 
			match(input,MODULEFILE,FOLLOW_MODULEFILE_in_moduleImport136); 
			match(input,STOP,FOLLOW_STOP_in_moduleImport138); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:71:1: module returns [Abstract_GOALModule gl] : def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE ;
	public final Abstract_GOALModule module() throws RecognitionException {
		Abstract_GOALModule gl = null;


		Abstract_ModuleDef def =null;
		ArrayList<Abstract_ActionSpec> as =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:2: (def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:4: def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE
			{
			pushFollow(FOLLOW_moduleDef_in_module155);
			def=moduleDef();
			state._fsp--;

			gl = new Abstract_GOALModule(def);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:56: ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==SQOPEN) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:57: SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE
					{
					match(input,SQOPEN,FOLLOW_SQOPEN_in_module160); 
					pushFollow(FOLLOW_moduleOption_in_module162);
					moduleOption(gl);
					state._fsp--;

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:81: ( COMMA moduleOption[gl] )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==COMMA) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:72:82: COMMA moduleOption[gl]
							{
							match(input,COMMA,FOLLOW_COMMA_in_module166); 
							pushFollow(FOLLOW_moduleOption_in_module168);
							moduleOption(gl);
							state._fsp--;

							}
							break;

						default :
							break loop3;
						}
					}

					match(input,SQCLOSE,FOLLOW_SQCLOSE_in_module173); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module178); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:12: ( krImport )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==64) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:12: krImport
					{
					pushFollow(FOLLOW_krImport_in_module180);
					krImport();
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:22: ( knowledge[gl] )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==KNOWLEDGE) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:22: knowledge[gl]
					{
					pushFollow(FOLLOW_knowledge_in_module183);
					knowledge(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:38: ( beliefs[gl] )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==BELIEFS) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:38: beliefs[gl]
					{
					pushFollow(FOLLOW_beliefs_in_module188);
					beliefs(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:51: ( goals[gl] )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==GOALS) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:51: goals[gl]
					{
					pushFollow(FOLLOW_goals_in_module192);
					goals(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:62: ( program[gl] )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==PROGRAM) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:62: program[gl]
					{
					pushFollow(FOLLOW_program_in_module196);
					program(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:2: (as= actionSpecs )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==ACTIONSPEC) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:3: as= actionSpecs
					{
					pushFollow(FOLLOW_actionSpecs_in_module205);
					as=actionSpecs();
					state._fsp--;

					gl.addAllCap(as);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module213); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:78:1: moduleDef returns [Abstract_ModuleDef i] : ( MODULE d= declaration | INIT MODULE | MAIN MODULE | EVENT MODULE );
	public final Abstract_ModuleDef moduleDef() throws RecognitionException {
		Abstract_ModuleDef i = null;


		Abstract_Predicate d =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:79:2: ( MODULE d= declaration | INIT MODULE | MAIN MODULE | EVENT MODULE )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:79:4: MODULE d= declaration
					{
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef228); 
					pushFollow(FOLLOW_declaration_in_moduleDef232);
					d=declaration();
					state._fsp--;

					i = new Abstract_ModuleDef(d);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:80:4: INIT MODULE
					{
					match(input,INIT,FOLLOW_INIT_in_moduleDef239); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef241); 
					i = Abstract_GOALModule.init;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:81:4: MAIN MODULE
					{
					match(input,MAIN,FOLLOW_MAIN_in_moduleDef248); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef250); 
					i = Abstract_GOALModule.main;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:4: EVENT MODULE
					{
					match(input,EVENT,FOLLOW_EVENT_in_moduleDef257); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef259); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:1: moduleOption[Abstract_GOALModule gl] : (key= 'exit' EQUALS value= ( 'always' | 'never' | 'nogoals' | 'noaction' ) |key= 'focus' EQUALS value= ( 'none' | 'new' | 'select' | 'filter' ) );
	public final void moduleOption(Abstract_GOALModule gl) throws RecognitionException {
		Token key=null;
		Token value=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:2: (key= 'exit' EQUALS value= ( 'always' | 'never' | 'nogoals' | 'noaction' ) |key= 'focus' EQUALS value= ( 'none' | 'new' | 'select' | 'filter' ) )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:4: key= 'exit' EQUALS value= ( 'always' | 'never' | 'nogoals' | 'noaction' )
					{
					key=(Token)match(input,73,FOLLOW_73_in_moduleOption278); 
					match(input,EQUALS,FOLLOW_EQUALS_in_moduleOption280); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:31: ( 'always' | 'never' | 'nogoals' | 'noaction' )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:87:32: 'always'
							{
							value=(Token)match(input,70,FOLLOW_70_in_moduleOption287); 
							gl.setExitCondition(Abstract_GOALModule.always);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:88:6: 'never'
							{
							value=(Token)match(input,81,FOLLOW_81_in_moduleOption297); 
							gl.setExitCondition(Abstract_GOALModule.never);
							}
							break;
						case 3 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:89:6: 'nogoals'
							{
							value=(Token)match(input,84,FOLLOW_84_in_moduleOption307); 
							gl.setExitCondition(Abstract_GOALModule.nogoals);
							}
							break;
						case 4 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:7: 'noaction'
							{
							value=(Token)match(input,83,FOLLOW_83_in_moduleOption318); 
							gl.setExitCondition(Abstract_GOALModule.noaction);
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:91:4: key= 'focus' EQUALS value= ( 'none' | 'new' | 'select' | 'filter' )
					{
					key=(Token)match(input,76,FOLLOW_76_in_moduleOption332); 
					match(input,EQUALS,FOLLOW_EQUALS_in_moduleOption334); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:1: krImport : '#import' ( stringLiteral | singleQuotedStringLiteral ) STOP ;
	public final void krImport() throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:95:2: ( '#import' ( stringLiteral | singleQuotedStringLiteral ) STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:95:4: '#import' ( stringLiteral | singleQuotedStringLiteral ) STOP
			{
			match(input,64,FOLLOW_64_in_krImport365); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:95:14: ( stringLiteral | singleQuotedStringLiteral )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:95:15: stringLiteral
					{
					pushFollow(FOLLOW_stringLiteral_in_krImport368);
					stringLiteral();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:95:31: singleQuotedStringLiteral
					{
					pushFollow(FOLLOW_singleQuotedStringLiteral_in_krImport372);
					singleQuotedStringLiteral();
					state._fsp--;

					}
					break;

			}

			match(input,STOP,FOLLOW_STOP_in_krImport375); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:98:1: knowledge[Abstract_GOALModule gl] : KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE ;
	public final void knowledge(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:2: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:4: KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE
			{
			match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_knowledge388); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_knowledge390); 
			pushFollow(FOLLOW_krspec_in_knowledge392);
			krspec(gl);
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_knowledge395); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:1: krspec[Abstract_GOALModule gl] : (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP ) )+ ;
	public final void krspec(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_Predicate hd =null;
		ArrayList<Abstract_LogicalFormula> body =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:31: ( (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP ) )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP ) )+
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP ) )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:34: hd= declarationOrCallWithTerms ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP )
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_krspec407);
					hd=declarationOrCallWithTerms();
					state._fsp--;

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:103:2: ( STOP | PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:103:3: STOP
							{
							match(input,STOP,FOLLOW_STOP_in_krspec411); 
							gl.addFact((Abstract_Predicate) hd);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:104:2: PROLOGARROW (body= no_bracket_literals |body= forall_expr ) STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_krspec418); 
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:104:14: (body= no_bracket_literals |body= forall_expr )
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
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:104:16: body= no_bracket_literals
									{
									pushFollow(FOLLOW_no_bracket_literals_in_krspec424);
									body=no_bracket_literals();
									state._fsp--;

									}
									break;
								case 2 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:104:43: body= forall_expr
									{
									pushFollow(FOLLOW_forall_expr_in_krspec430);
									body=forall_expr();
									state._fsp--;

									}
									break;

							}

							match(input,STOP,FOLLOW_STOP_in_krspec434); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:106:1: beliefs[Abstract_GOALModule gl] : BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE ;
	public final void beliefs(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:2: ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:4: BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE
			{
			match(input,BELIEFS,FOLLOW_BELIEFS_in_beliefs451); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_beliefs453); 
			pushFollow(FOLLOW_brspec_in_beliefs455);
			brspec(gl);
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_beliefs458); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:1: brspec[Abstract_GOALModule gl] : (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+ ;
	public final void brspec(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_Predicate hd =null;
		ArrayList<Abstract_LogicalFormula> body =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:31: ( (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:34: hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP )
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_brspec470);
					hd=declarationOrCallWithTerms();
					state._fsp--;

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:2: ( STOP | PROLOGARROW body= no_bracket_literals STOP )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:3: STOP
							{
							match(input,STOP,FOLLOW_STOP_in_brspec474); 
							gl.addBel((Abstract_Predicate) hd);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:112:2: PROLOGARROW body= no_bracket_literals STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_brspec481); 
							pushFollow(FOLLOW_no_bracket_literals_in_brspec485);
							body=no_bracket_literals();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_brspec487); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:115:1: goals[Abstract_GOALModule gl] : GOALS CURLYOPEN le= goal_list CURLYCLOSE ;
	public final void goals(Abstract_GOALModule gl) throws RecognitionException {
		ArrayList<ArrayList<Abstract_Term>> le =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:116:2: ( GOALS CURLYOPEN le= goal_list CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:116:4: GOALS CURLYOPEN le= goal_list CURLYCLOSE
			{
			match(input,GOALS,FOLLOW_GOALS_in_goals504); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_goals506); 
			pushFollow(FOLLOW_goal_list_in_goals510);
			le=goal_list();
			state._fsp--;

			gl.addGoal(le);
			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_goals514); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:118:1: atom returns [Abstract_LogicalFormula l] : ( NOT OPEN (p= declarationOrCallWithTerms |e= equation ) CLOSE |p= declarationOrCallWithTerms |e= equation );
	public final Abstract_LogicalFormula atom() throws RecognitionException {
		Abstract_LogicalFormula l = null;


		Abstract_Predicate p =null;
		Abstract_Equation e =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:2: ( NOT OPEN (p= declarationOrCallWithTerms |e= equation ) CLOSE |p= declarationOrCallWithTerms |e= equation )
			int alt21=3;
			switch ( input.LA(1) ) {
			case NOT:
				{
				alt21=1;
				}
				break;
			case CONST:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:4: NOT OPEN (p= declarationOrCallWithTerms |e= equation ) CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_atom528); 
					match(input,OPEN,FOLLOW_OPEN_in_atom530); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:13: (p= declarationOrCallWithTerms |e= equation )
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==CONST) ) {
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:15: p= declarationOrCallWithTerms
							{
							pushFollow(FOLLOW_declarationOrCallWithTerms_in_atom536);
							p=declarationOrCallWithTerms();
							state._fsp--;

							l = new Abstract_LogExpr(Abstract_LogExpr.not, p);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:5: e= equation
							{
							pushFollow(FOLLOW_equation_in_atom546);
							e=equation();
							state._fsp--;

							l = new Abstract_LogExpr(Abstract_LogExpr.not, e);
							}
							break;

					}

					match(input,CLOSE,FOLLOW_CLOSE_in_atom552); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_atom559);
					p=declarationOrCallWithTerms();
					state._fsp--;

					l =p;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:122:4: e= equation
					{
					pushFollow(FOLLOW_equation_in_atom568);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:1: program[Abstract_GOALModule gl] : PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* (rule= programRule )* CURLYCLOSE ;
	public final void program(Abstract_GOALModule gl) throws RecognitionException {
		int i =0;
		Abstract_ActionRule rule =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:2: ( PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* (rule= programRule )* CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:4: PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* (rule= programRule )* CURLYCLOSE
			{
			match(input,PROGRAM,FOLLOW_PROGRAM_in_program583); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:12: ( SQOPEN i= ruleEvaluationOrder SQCLOSE )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==SQOPEN) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:13: SQOPEN i= ruleEvaluationOrder SQCLOSE
					{
					match(input,SQOPEN,FOLLOW_SQOPEN_in_program586); 
					pushFollow(FOLLOW_ruleEvaluationOrder_in_program590);
					i=ruleEvaluationOrder();
					state._fsp--;

					gl.setOptionOrder(i);
					match(input,SQCLOSE,FOLLOW_SQCLOSE_in_program594); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program600); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:12: ( macroDef )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==HASH) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:12: macroDef
					{
					pushFollow(FOLLOW_macroDef_in_program602);
					macroDef();
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:22: (rule= programRule )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==IF||LA24_0==77||LA24_0==79) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:23: rule= programRule
					{
					pushFollow(FOLLOW_programRule_in_program610);
					rule=programRule();
					state._fsp--;

					gl.addPlan(rule);
					}
					break;

				default :
					break loop24;
				}
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program616); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:132:1: ruleEvaluationOrder returns [int i] : ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE ) ;
	public final int ruleEvaluationOrder() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:2: ( ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:4: ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE )
			{
			match(input,ORDER,FOLLOW_ORDER_in_ruleEvaluationOrder633); 
			match(input,EQUALS,FOLLOW_EQUALS_in_ruleEvaluationOrder635); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:17: ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:19: LINEAR
					{
					match(input,LINEAR,FOLLOW_LINEAR_in_ruleEvaluationOrder639); 
					i =Abstract_GOALModule.linear;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:134:2: LINEARALL
					{
					match(input,LINEARALL,FOLLOW_LINEARALL_in_ruleEvaluationOrder646); 
					i =Abstract_GOALModule.linearall;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:2: RANDOM
					{
					match(input,RANDOM,FOLLOW_RANDOM_in_ruleEvaluationOrder652); 
					i =Abstract_GOALModule.random;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:136:2: RANDOMALL
					{
					match(input,RANDOMALL,FOLLOW_RANDOMALL_in_ruleEvaluationOrder658); 
					i =Abstract_GOALModule.randomall;
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:137:2: ADAPTIVE
					{
					match(input,ADAPTIVE,FOLLOW_ADAPTIVE_in_ruleEvaluationOrder665); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:140:1: macroDef : HASH DEFINE p= declarationOrCallWithTerms msc= mentalstatecond STOP ;
	public final void macroDef() throws RecognitionException {
		Abstract_Predicate p =null;
		Abstract_MentalState msc =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:141:2: ( HASH DEFINE p= declarationOrCallWithTerms msc= mentalstatecond STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:141:4: HASH DEFINE p= declarationOrCallWithTerms msc= mentalstatecond STOP
			{
			match(input,HASH,FOLLOW_HASH_in_macroDef679); 
			match(input,DEFINE,FOLLOW_DEFINE_in_macroDef681); 
			pushFollow(FOLLOW_declarationOrCallWithTerms_in_macroDef685);
			p=declarationOrCallWithTerms();
			state._fsp--;

			pushFollow(FOLLOW_mentalstatecond_in_macroDef690);
			msc=mentalstatecond();
			state._fsp--;

			PredicateIndicator pi = new PredicateIndicator(p.getFunctor(), p.getTermSize()); macros.put(pi, msc);
				macro_subs.put(pi, p);
			match(input,STOP,FOLLOW_STOP_in_macroDef696); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:147:1: programRule returns [Abstract_ActionRule rule] : ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] ) ) ;
	public final Abstract_ActionRule programRule() throws RecognitionException {
		Abstract_ActionRule rule = null;


		Abstract_MentalState lf =null;
		ArrayList<Abstract_Deed> dl =null;
		Abstract_VarTerm v =null;
		Abstract_MentalState ms =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:2: ( ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] ) ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:3: ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] ) )
			{
			rule = new Abstract_ActionRule();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:2: ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] ) )
			int alt30=4;
			switch ( input.LA(1) ) {
			case IF:
				{
				alt30=1;
				}
				break;
			case 77:
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
					if ( (LA30_4==66) ) {
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
				case GOAL:
				case GOALA:
				case NOT:
				case TRUE:
				case 68:
				case 69:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:3: IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] )
					{
					match(input,IF,FOLLOW_IF_in_programRule713); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule717);
					lf=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(lf);
					match(input,THEN,FOLLOW_THEN_in_programRule721); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:61: (dl= actions STOP | nestedRules[rule] )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:63: dl= actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule727);
							dl=actions();
							state._fsp--;

							rule.setBody(dl);
							match(input,STOP,FOLLOW_STOP_in_programRule731); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:101: nestedRules[rule]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule735);
							nestedRules(rule);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:150:4: 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] )
					{
					match(input,77,FOLLOW_77_in_programRule744); 
					rule.setType(ActionRule.foralldo);
					pushFollow(FOLLOW_mentalstatecond_in_programRule750);
					lf=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(lf);
					match(input,DO,FOLLOW_DO_in_programRule754); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:150:103: (dl= actions STOP | nestedRules[rule] )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:150:104: dl= actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule759);
							dl=actions();
							state._fsp--;

							rule.setBody(dl);
							match(input,STOP,FOLLOW_STOP_in_programRule763); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:150:142: nestedRules[rule]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule767);
							nestedRules(rule);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:151:4: 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] )
					{
					match(input,79,FOLLOW_79_in_programRule775); 
					rule.setType(ActionRule.listalldo);
					pushFollow(FOLLOW_var_in_programRule781);
					v=var();
					state._fsp--;

					match(input,66,FOLLOW_66_in_programRule783); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule787);
					ms=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(new Abstract_MentalState(v, ms));
					match(input,DO,FOLLOW_DO_in_programRule794); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:6: (dl= actions STOP | nestedRules[rule] )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:7: dl= actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule799);
							dl=actions();
							state._fsp--;

							rule.setBody(dl);
							match(input,STOP,FOLLOW_STOP_in_programRule804); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:46: nestedRules[rule]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule808);
							nestedRules(rule);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:4: 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] )
					{
					match(input,79,FOLLOW_79_in_programRule817); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule819);
					mentalstatecond();
					state._fsp--;

					match(input,65,FOLLOW_65_in_programRule821); 
					pushFollow(FOLLOW_var_in_programRule823);
					var();
					state._fsp--;

					match(input,DO,FOLLOW_DO_in_programRule825); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:42: ( actions STOP | nestedRules[rule] )
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==CONST||LA29_0==EVENT||LA29_0==INIT||LA29_0==MAIN||LA29_0==VAR||(LA29_0 >= 67 && LA29_0 <= 69)||(LA29_0 >= 71 && LA29_0 <= 72)||LA29_0==74||LA29_0==78||LA29_0==80||LA29_0==86||(LA29_0 >= 88 && LA29_0 <= 93)) ) {
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:43: actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule828);
							actions();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_programRule830); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:58: nestedRules[rule]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule834);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:156:1: nestedRules[Abstract_ActionRule rule] : CURLYOPEN (r= programRule )+ CURLYCLOSE ;
	public final void nestedRules(Abstract_ActionRule rule) throws RecognitionException {
		Abstract_ActionRule r =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:157:2: ( CURLYOPEN (r= programRule )+ CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:157:4: CURLYOPEN (r= programRule )+ CURLYCLOSE
			{
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_nestedRules851); 
			ArrayList<Abstract_ActionRule> rules = new ArrayList<Abstract_ActionRule>();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:157:93: (r= programRule )+
			int cnt31=0;
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==IF||LA31_0==77||LA31_0==79) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:157:94: r= programRule
					{
					pushFollow(FOLLOW_programRule_in_nestedRules858);
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
			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_nestedRules865); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:161:1: mentalstatecond returns [Abstract_MentalState lf] : ma= basicCondition ( COMMA ms2= basicCondition )* ;
	public final Abstract_MentalState mentalstatecond() throws RecognitionException {
		Abstract_MentalState lf = null;


		Abstract_MentalState ma =null;
		Abstract_MentalState ms2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:162:2: (ma= basicCondition ( COMMA ms2= basicCondition )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:162:4: ma= basicCondition ( COMMA ms2= basicCondition )*
			{
			pushFollow(FOLLOW_basicCondition_in_mentalstatecond883);
			ma=basicCondition();
			state._fsp--;

			Abstract_MentalState ms =  ma;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:163:2: ( COMMA ms2= basicCondition )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==COMMA) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:163:3: COMMA ms2= basicCondition
					{
					match(input,COMMA,FOLLOW_COMMA_in_mentalstatecond889); 
					pushFollow(FOLLOW_basicCondition_in_mentalstatecond893);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:166:1: mentalstate returns [Abstract_MentalState ms] : (ma= mentalatom | NOT OPEN mentalatom CLOSE | TRUE );
	public final Abstract_MentalState mentalstate() throws RecognitionException {
		Abstract_MentalState ms = null;


		Abstract_MentalState ma =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:2: (ma= mentalatom | NOT OPEN mentalatom CLOSE | TRUE )
			int alt33=3;
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:4: ma= mentalatom
					{
					pushFollow(FOLLOW_mentalatom_in_mentalstate916);
					ma=mentalatom();
					state._fsp--;

					ms = new Abstract_MentalState(ma);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:168:4: NOT OPEN mentalatom CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_mentalstate923); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalstate925); 
					pushFollow(FOLLOW_mentalatom_in_mentalstate927);
					mentalatom();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_mentalstate929); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:169:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_mentalstate934); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:1: basicCondition returns [Abstract_MentalState ms] : (ms1= mentalstate |p= declarationOrCallWithTerms );
	public final Abstract_MentalState basicCondition() throws RecognitionException {
		Abstract_MentalState ms = null;


		Abstract_MentalState ms1 =null;
		Abstract_Predicate p =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:2: (ms1= mentalstate |p= declarationOrCallWithTerms )
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==CONST) ) {
				int LA34_1 = input.LA(2);
				if ( (LA34_1==STOP) ) {
					int LA34_3 = input.LA(3);
					if ( (LA34_3==AGOAL||LA34_3==BEL||(LA34_3 >= GOAL && LA34_3 <= GOALA)) ) {
						alt34=1;
					}
					else if ( (LA34_3==CURLYCLOSE||(LA34_3 >= HASH && LA34_3 <= IF)||LA34_3==77||LA34_3==79) ) {
						alt34=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 34, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA34_1==COMMA||LA34_1==DO||LA34_1==OPEN||LA34_1==THEN||LA34_1==65) ) {
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
			else if ( (LA34_0==AGOAL||LA34_0==BEL||(LA34_0 >= GOAL && LA34_0 <= GOALA)||LA34_0==NOT||LA34_0==TRUE||LA34_0==VAR||(LA34_0 >= 68 && LA34_0 <= 69)||LA34_0==88||(LA34_0 >= 91 && LA34_0 <= 93)) ) {
				alt34=1;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:4: ms1= mentalstate
					{
					pushFollow(FOLLOW_mentalstate_in_basicCondition954);
					ms1=mentalstate();
					state._fsp--;

					ms = ms1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_basicCondition963);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:181:1: mentalatom returns [Abstract_MentalState ms] : ( selector STOP )? b= mentalOperator tl= atom_parameters ;
	public final Abstract_MentalState mentalatom() throws RecognitionException {
		Abstract_MentalState ms = null;


		byte b =0;
		Abstract_LogExpr tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:2: ( ( selector STOP )? b= mentalOperator tl= atom_parameters )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:183:2: ( selector STOP )? b= mentalOperator tl= atom_parameters
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:183:2: ( selector STOP )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==CONST||LA35_0==VAR||(LA35_0 >= 68 && LA35_0 <= 69)||LA35_0==88||(LA35_0 >= 91 && LA35_0 <= 93)) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:183:3: selector STOP
					{
					pushFollow(FOLLOW_selector_in_mentalatom983);
					selector();
					state._fsp--;

					match(input,STOP,FOLLOW_STOP_in_mentalatom985); 
					}
					break;

			}

			pushFollow(FOLLOW_mentalOperator_in_mentalatom991);
			b=mentalOperator();
			state._fsp--;

			pushFollow(FOLLOW_atom_parameters_in_mentalatom995);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:1: atom_parameters returns [Abstract_LogExpr ts] : OPEN (t= atom ( COMMA (t1= atom |ap= atom_parameters ) | SEMI (t1= atom |ap= atom_parameters ) )* |ap= atom_parameters ) CLOSE ;
	public final Abstract_LogExpr atom_parameters() throws RecognitionException {
		Abstract_LogExpr ts = null;


		Abstract_LogicalFormula t =null;
		Abstract_LogicalFormula t1 =null;
		Abstract_LogExpr ap =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:2: ( OPEN (t= atom ( COMMA (t1= atom |ap= atom_parameters ) | SEMI (t1= atom |ap= atom_parameters ) )* |ap= atom_parameters ) CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:4: OPEN (t= atom ( COMMA (t1= atom |ap= atom_parameters ) | SEMI (t1= atom |ap= atom_parameters ) )* |ap= atom_parameters ) CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_atom_parameters1014); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:9: (t= atom ( COMMA (t1= atom |ap= atom_parameters ) | SEMI (t1= atom |ap= atom_parameters ) )* |ap= atom_parameters )
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==CONST||LA39_0==MINUS||(LA39_0 >= NOT && LA39_0 <= NUMBER)||(LA39_0 >= UNNAMEDVAR && LA39_0 <= VAR)) ) {
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:198:3: t= atom ( COMMA (t1= atom |ap= atom_parameters ) | SEMI (t1= atom |ap= atom_parameters ) )*
					{
					pushFollow(FOLLOW_atom_in_atom_parameters1023);
					t=atom();
					state._fsp--;

					Abstract_LogExpr tl = new Abstract_LogExpr(Abstract_LogExpr.none, t);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:2: ( COMMA (t1= atom |ap= atom_parameters ) | SEMI (t1= atom |ap= atom_parameters ) )*
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:3: COMMA (t1= atom |ap= atom_parameters )
							{
							match(input,COMMA,FOLLOW_COMMA_in_atom_parameters1029); 
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:10: (t1= atom |ap= atom_parameters )
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
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:12: t1= atom
									{
									pushFollow(FOLLOW_atom_in_atom_parameters1036);
									t1=atom();
									state._fsp--;

									tl = new Abstract_LogExpr(tl, Abstract_LogExpr.and,  t1);
									}
									break;
								case 2 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:5: ap= atom_parameters
									{
									pushFollow(FOLLOW_atom_parameters_in_atom_parameters1046);
									ap=atom_parameters();
									state._fsp--;

									tl = new Abstract_LogExpr(tl, Abstract_LogExpr.and,  ap);
									}
									break;

							}

							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:4: SEMI (t1= atom |ap= atom_parameters )
							{
							match(input,SEMI,FOLLOW_SEMI_in_atom_parameters1054); 
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:10: (t1= atom |ap= atom_parameters )
							int alt37=2;
							int LA37_0 = input.LA(1);
							if ( (LA37_0==CONST||LA37_0==MINUS||(LA37_0 >= NOT && LA37_0 <= NUMBER)||(LA37_0 >= UNNAMEDVAR && LA37_0 <= VAR)) ) {
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
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:11: t1= atom
									{
									pushFollow(FOLLOW_atom_in_atom_parameters1062);
									t1=atom();
									state._fsp--;

									tl = new Abstract_LogExpr(tl, Abstract_LogExpr.or,  t1);
									}
									break;
								case 2 :
									// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:202:5: ap= atom_parameters
									{
									pushFollow(FOLLOW_atom_parameters_in_atom_parameters1072);
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:204:5: ap= atom_parameters
					{
					pushFollow(FOLLOW_atom_parameters_in_atom_parameters1090);
					ap=atom_parameters();
					state._fsp--;

					ts = ap;
					}
					break;

			}

			match(input,CLOSE,FOLLOW_CLOSE_in_atom_parameters1098); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:209:1: mentalOperator returns [byte b] : (op= BEL |op= GOAL |op= AGOAL |op= GOALA );
	public final byte mentalOperator() throws RecognitionException {
		byte b = 0;


		Token op=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:2: (op= BEL |op= GOAL |op= AGOAL |op= GOALA )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:4: op= BEL
					{
					op=(Token)match(input,BEL,FOLLOW_BEL_in_mentalOperator1119); 
					b = Abstract_BaseAILStructure.AILBel;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:211:4: op= GOAL
					{
					op=(Token)match(input,GOAL,FOLLOW_GOAL_in_mentalOperator1130); 
					b = Abstract_BaseAILStructure.AILGoal;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:212:4: op= AGOAL
					{
					op=(Token)match(input,AGOAL,FOLLOW_AGOAL_in_mentalOperator1141); 
					b = Abstract_MentalAtom.agoal;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:213:4: op= GOALA
					{
					op=(Token)match(input,GOALA,FOLLOW_GOALA_in_mentalOperator1152); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:216:1: actions returns [ArrayList<Abstract_Deed> dl] :a= action ( PLUS a1= action )* ;
	public final ArrayList<Abstract_Deed> actions() throws RecognitionException {
		ArrayList<Abstract_Deed> dl = null;


		Abstract_Deed a =null;
		Abstract_Deed a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:217:2: (a= action ( PLUS a1= action )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:217:4: a= action ( PLUS a1= action )*
			{
			dl = new ArrayList<Abstract_Deed>();
			pushFollow(FOLLOW_action_in_actions1175);
			a=action();
			state._fsp--;

			dl.add(a);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:2: ( PLUS a1= action )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==PLUS) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:3: PLUS a1= action
					{
					match(input,PLUS,FOLLOW_PLUS_in_actions1182); 
					pushFollow(FOLLOW_action_in_actions1186);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:222:1: action returns [Abstract_Deed d] : ( ( selector STOP )? d1= actionOperator tl= parameters |op= 'exit-module' |op= 'log' |op= INIT |op= MAIN |op= EVENT |p= declarationOrCallWithTerms );
	public final Abstract_Deed action() throws RecognitionException {
		Abstract_Deed d = null;


		Token op=null;
		Abstract_Deed d1 =null;
		ArrayList<Abstract_Term> tl =null;
		Abstract_Predicate p =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:223:2: ( ( selector STOP )? d1= actionOperator tl= parameters |op= 'exit-module' |op= 'log' |op= INIT |op= MAIN |op= EVENT |p= declarationOrCallWithTerms )
			int alt43=7;
			switch ( input.LA(1) ) {
			case CONST:
				{
				int LA43_1 = input.LA(2);
				if ( (LA43_1==STOP) ) {
					int LA43_8 = input.LA(3);
					if ( (LA43_8==67||(LA43_8 >= 71 && LA43_8 <= 72)||LA43_8==78||LA43_8==80||LA43_8==86||(LA43_8 >= 89 && LA43_8 <= 90)) ) {
						alt43=1;
					}
					else if ( (LA43_8==CURLYCLOSE||LA43_8==IF||LA43_8==77||LA43_8==79) ) {
						alt43=7;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 43, 8, input);
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
			case 74:
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
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}
			switch (alt43) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:223:4: ( selector STOP )? d1= actionOperator tl= parameters
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:223:4: ( selector STOP )?
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==CONST||LA42_0==VAR||(LA42_0 >= 68 && LA42_0 <= 69)||LA42_0==88||(LA42_0 >= 91 && LA42_0 <= 93)) ) {
						alt42=1;
					}
					switch (alt42) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:223:5: selector STOP
							{
							pushFollow(FOLLOW_selector_in_action1206);
							selector();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_action1208); 
							}
							break;

					}

					pushFollow(FOLLOW_actionOperator_in_action1214);
					d1=actionOperator();
					state._fsp--;

					pushFollow(FOLLOW_parameters_in_action1218);
					tl=parameters();
					state._fsp--;

					d1.addParams(tl); d =d1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:225:4: op= 'exit-module'
					{
					op=(Token)match(input,74,FOLLOW_74_in_action1230); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:226:4: op= 'log'
					{
					op=(Token)match(input,80,FOLLOW_80_in_action1239); 
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:227:4: op= INIT
					{
					op=(Token)match(input,INIT,FOLLOW_INIT_in_action1248); 
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:228:4: op= MAIN
					{
					op=(Token)match(input,MAIN,FOLLOW_MAIN_in_action1257); 
					}
					break;
				case 6 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:229:4: op= EVENT
					{
					op=(Token)match(input,EVENT,FOLLOW_EVENT_in_action1266); 
					}
					break;
				case 7 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:230:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_action1273);
					p=declarationOrCallWithTerms();
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:233:1: actionOperator returns [Abstract_Deed d] : (op= 'adopt' |op= 'drop' |op= 'insert' |op= 'delete' |op= 'send' |op= 'sendonce' |op= 'print' |op= 'log' );
	public final Abstract_Deed actionOperator() throws RecognitionException {
		Abstract_Deed d = null;


		Token op=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:234:2: (op= 'adopt' |op= 'drop' |op= 'insert' |op= 'delete' |op= 'send' |op= 'sendonce' |op= 'print' |op= 'log' )
			int alt44=8;
			switch ( input.LA(1) ) {
			case 67:
				{
				alt44=1;
				}
				break;
			case 72:
				{
				alt44=2;
				}
				break;
			case 78:
				{
				alt44=3;
				}
				break;
			case 71:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:234:4: op= 'adopt'
					{
					op=(Token)match(input,67,FOLLOW_67_in_actionOperator1294); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, Abstract_BaseAILStructure.AILGoal);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:235:4: op= 'drop'
					{
					op=(Token)match(input,72,FOLLOW_72_in_actionOperator1305); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILDeletion, Abstract_BaseAILStructure.AILGoal);
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:236:4: op= 'insert'
					{
					op=(Token)match(input,78,FOLLOW_78_in_actionOperator1316); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, Abstract_BaseAILStructure.AILBel);
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:237:4: op= 'delete'
					{
					op=(Token)match(input,71,FOLLOW_71_in_actionOperator1327); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILDeletion, Abstract_BaseAILStructure.AILBel);
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:238:4: op= 'send'
					{
					op=(Token)match(input,89,FOLLOW_89_in_actionOperator1339); 
					}
					break;
				case 6 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:239:4: op= 'sendonce'
					{
					op=(Token)match(input,90,FOLLOW_90_in_actionOperator1348); 
					}
					break;
				case 7 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:240:4: op= 'print'
					{
					op=(Token)match(input,86,FOLLOW_86_in_actionOperator1357); 
					d = new Abstract_Deed(new Abstract_PrintAction());
					}
					break;
				case 8 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:241:4: op= 'log'
					{
					op=(Token)match(input,80,FOLLOW_80_in_actionOperator1368); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:245:1: selector : ( word |op= 'all' |op= 'allother' |op= 'self' |op= 'some' |op= 'someother' |op= 'this' );
	public final void selector() throws RecognitionException {
		Token op=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:246:2: ( word |op= 'all' |op= 'allother' |op= 'self' |op= 'some' |op= 'someother' |op= 'this' )
			int alt45=7;
			switch ( input.LA(1) ) {
			case CONST:
			case VAR:
				{
				alt45=1;
				}
				break;
			case 68:
				{
				alt45=2;
				}
				break;
			case 69:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:246:4: word
					{
					pushFollow(FOLLOW_word_in_selector1380);
					word();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:247:4: op= 'all'
					{
					op=(Token)match(input,68,FOLLOW_68_in_selector1389); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:248:4: op= 'allother'
					{
					op=(Token)match(input,69,FOLLOW_69_in_selector1398); 
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:249:4: op= 'self'
					{
					op=(Token)match(input,88,FOLLOW_88_in_selector1407); 
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:250:4: op= 'some'
					{
					op=(Token)match(input,91,FOLLOW_91_in_selector1416); 
					}
					break;
				case 6 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:251:4: op= 'someother'
					{
					op=(Token)match(input,92,FOLLOW_92_in_selector1425); 
					}
					break;
				case 7 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:252:4: op= 'this'
					{
					op=(Token)match(input,93,FOLLOW_93_in_selector1434); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:255:1: actionSpecs returns [ArrayList<Abstract_ActionSpec> as] : ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE ;
	public final ArrayList<Abstract_ActionSpec> actionSpecs() throws RecognitionException {
		ArrayList<Abstract_ActionSpec> as = null;


		Abstract_ActionSpec a =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:256:2: ( ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:256:4: ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE
			{
			as = new ArrayList<Abstract_ActionSpec>();
			match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_actionSpecs1453); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionSpecs1455); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:257:23: (a= actionSpec )+
			int cnt46=0;
			loop46:
			while (true) {
				int alt46=2;
				int LA46_0 = input.LA(1);
				if ( (LA46_0==CONST) ) {
					alt46=1;
				}

				switch (alt46) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:257:24: a= actionSpec
					{
					pushFollow(FOLLOW_actionSpec_in_actionSpecs1460);
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

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionSpecs1466); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:260:1: actionSpec returns [Abstract_ActionSpec as] :cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE ;
	public final Abstract_ActionSpec actionSpec() throws RecognitionException {
		Abstract_ActionSpec as = null;


		Abstract_Predicate cap =null;
		Abstract_LogicalFormula pre =null;
		Abstract_LogicalFormula post =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:261:2: (cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:261:4: cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE
			{
			boolean internal=false;
			pushFollow(FOLLOW_declarationOrCallWithTerms_in_actionSpec1485);
			cap=declarationOrCallWithTerms();
			state._fsp--;

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:261:61: ( INTERNAL | EXTERNAL )?
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:261:62: INTERNAL
					{
					match(input,INTERNAL,FOLLOW_INTERNAL_in_actionSpec1488); 
					internal = true;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:261:92: EXTERNAL
					{
					match(input,EXTERNAL,FOLLOW_EXTERNAL_in_actionSpec1494); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionSpec1500); 
			pushFollow(FOLLOW_precondition_in_actionSpec1504);
			pre=precondition();
			state._fsp--;

			pushFollow(FOLLOW_postcondition_in_actionSpec1508);
			post=postcondition();
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionSpec1510); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:266:1: precondition returns [Abstract_LogicalFormula f] : PRE CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE ;
	public final Abstract_LogicalFormula precondition() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		ArrayList<Abstract_LogicalFormula> tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:267:2: ( PRE CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:267:4: PRE CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE
			{
			match(input,PRE,FOLLOW_PRE_in_precondition1528); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_precondition1530); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:267:19: ( TRUE |tl= no_bracket_literals )
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==TRUE) ) {
				alt48=1;
			}
			else if ( (LA48_0==CONST||LA48_0==MINUS||(LA48_0 >= NOT && LA48_0 <= NUMBER)||(LA48_0 >= UNNAMEDVAR && LA48_0 <= VAR)) ) {
				alt48=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}

			switch (alt48) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:267:20: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_precondition1534); 
					f = new Abstract_LogExpr();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:268:4: tl= no_bracket_literals
					{
					pushFollow(FOLLOW_no_bracket_literals_in_precondition1544);
					tl=no_bracket_literals();
					state._fsp--;

					f = new Abstract_LogExpr(tl);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_precondition1549); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:271:1: postcondition returns [Abstract_LogicalFormula f] : POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE ;
	public final Abstract_LogicalFormula postcondition() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		ArrayList<Abstract_LogicalFormula> tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:272:2: ( POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:272:4: POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE
			{
			match(input,POST,FOLLOW_POST_in_postcondition1564); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_postcondition1567); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:273:2: ( TRUE |tl= no_bracket_literals )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==TRUE) ) {
				alt49=1;
			}
			else if ( (LA49_0==CONST||LA49_0==MINUS||(LA49_0 >= NOT && LA49_0 <= NUMBER)||(LA49_0 >= UNNAMEDVAR && LA49_0 <= VAR)) ) {
				alt49=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}

			switch (alt49) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:273:3: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_postcondition1571); 
					f = new Abstract_LogExpr();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:274:4: tl= no_bracket_literals
					{
					pushFollow(FOLLOW_no_bracket_literals_in_postcondition1581);
					tl=no_bracket_literals();
					state._fsp--;


							f = new Abstract_LogExpr(tl);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_postcondition1590); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:280:1: declaration returns [Abstract_Predicate p] : f= id (tl= parameters )? ;
	public final Abstract_Predicate declaration() throws RecognitionException {
		Abstract_Predicate p = null;


		String f =null;
		ArrayList<Abstract_Term> tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:281:2: (f= id (tl= parameters )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:281:4: f= id (tl= parameters )?
			{
			pushFollow(FOLLOW_id_in_declaration1607);
			f=id();
			state._fsp--;

			p= new Abstract_Predicate(f);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:281:41: (tl= parameters )?
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==OPEN) ) {
				alt50=1;
			}
			switch (alt50) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:281:42: tl= parameters
					{
					pushFollow(FOLLOW_parameters_in_declaration1614);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:284:1: declarationOrCallWithTerms returns [Abstract_Predicate p] : f= function_term ;
	public final Abstract_Predicate declarationOrCallWithTerms() throws RecognitionException {
		Abstract_Predicate p = null;


		Abstract_Term f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:285:2: (f= function_term )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:285:4: f= function_term
			{
			pushFollow(FOLLOW_function_term_in_declarationOrCallWithTerms1635);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:288:1: id returns [String s] : ( CONST | VAR ) ;
	public final String id() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:289:2: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:289:4: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:289:4: ( CONST | VAR )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:289:5: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_id1654); 
					s = CONST1.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:290:4: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_id1661); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:294:1: parameters returns [ArrayList<Abstract_Term>ts] : OPEN t= term ( COMMA t1= term )* CLOSE ;
	public final ArrayList<Abstract_Term> parameters() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:295:2: ( OPEN t= term ( COMMA t1= term )* CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:295:4: OPEN t= term ( COMMA t1= term )* CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_parameters1684); 
			pushFollow(FOLLOW_term_in_parameters1688);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:296:2: ( COMMA t1= term )*
			loop52:
			while (true) {
				int alt52=2;
				int LA52_0 = input.LA(1);
				if ( (LA52_0==COMMA) ) {
					alt52=1;
				}

				switch (alt52) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:296:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_parameters1694); 
					pushFollow(FOLLOW_term_in_parameters1698);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop52;
				}
			}

			match(input,CLOSE,FOLLOW_CLOSE_in_parameters1706); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:300:1: no_bracket_parameters returns [ArrayList<Abstract_Term>ts] : t= term ( COMMA t1= term )* ;
	public final ArrayList<Abstract_Term> no_bracket_parameters() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:301:2: (t= term ( COMMA t1= term )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:301:5: t= term ( COMMA t1= term )*
			{
			pushFollow(FOLLOW_term_in_no_bracket_parameters1728);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:302:2: ( COMMA t1= term )*
			loop53:
			while (true) {
				int alt53=2;
				int LA53_0 = input.LA(1);
				if ( (LA53_0==COMMA) ) {
					alt53=1;
				}

				switch (alt53) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:302:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_no_bracket_parameters1734); 
					pushFollow(FOLLOW_term_in_no_bracket_parameters1738);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop53;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:306:1: no_bracket_literals returns [ArrayList<Abstract_LogicalFormula>ts] :t= atom ( COMMA t1= atom )* ;
	public final ArrayList<Abstract_LogicalFormula> no_bracket_literals() throws RecognitionException {
		ArrayList<Abstract_LogicalFormula> ts = null;


		Abstract_LogicalFormula t =null;
		Abstract_LogicalFormula t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:307:2: (t= atom ( COMMA t1= atom )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:307:5: t= atom ( COMMA t1= atom )*
			{
			ArrayList<Abstract_LogicalFormula> tl = new ArrayList<Abstract_LogicalFormula>();
			pushFollow(FOLLOW_atom_in_no_bracket_literals1769);
			t=atom();
			state._fsp--;

			 tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:309:2: ( COMMA t1= atom )*
			loop54:
			while (true) {
				int alt54=2;
				int LA54_0 = input.LA(1);
				if ( (LA54_0==COMMA) ) {
					alt54=1;
				}

				switch (alt54) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:309:3: COMMA t1= atom
					{
					match(input,COMMA,FOLLOW_COMMA_in_no_bracket_literals1775); 
					pushFollow(FOLLOW_atom_in_no_bracket_literals1782);
					t1=atom();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop54;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:315:1: goal_list returns [ArrayList<ArrayList<Abstract_Term>>ts] : (t= term ( COMMA t1= term )* STOP )+ ;
	public final ArrayList<ArrayList<Abstract_Term>> goal_list() throws RecognitionException {
		ArrayList<ArrayList<Abstract_Term>> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:316:2: ( (t= term ( COMMA t1= term )* STOP )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:316:4: (t= term ( COMMA t1= term )* STOP )+
			{
			ArrayList<ArrayList<Abstract_Term>> tll = new ArrayList<ArrayList<Abstract_Term>>();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:317:2: (t= term ( COMMA t1= term )* STOP )+
			int cnt56=0;
			loop56:
			while (true) {
				int alt56=2;
				int LA56_0 = input.LA(1);
				if ( (LA56_0==CONST||LA56_0==MINUS||LA56_0==NUMBER||LA56_0==SQOPEN||LA56_0==STRING||(LA56_0 >= UNNAMEDVAR && LA56_0 <= VAR)) ) {
					alt56=1;
				}

				switch (alt56) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:317:3: t= term ( COMMA t1= term )* STOP
					{
					pushFollow(FOLLOW_term_in_goal_list1814);
					t=term();
					state._fsp--;

					ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:318:2: ( COMMA t1= term )*
					loop55:
					while (true) {
						int alt55=2;
						int LA55_0 = input.LA(1);
						if ( (LA55_0==COMMA) ) {
							alt55=1;
						}

						switch (alt55) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:318:3: COMMA t1= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_goal_list1821); 
							pushFollow(FOLLOW_term_in_goal_list1825);
							t1=term();
							state._fsp--;

							tl.add(t1);
							}
							break;

						default :
							break loop55;
						}
					}

					match(input,STOP,FOLLOW_STOP_in_goal_list1832); 
					tll.add(tl);
					}
					break;

				default :
					if ( cnt56 >= 1 ) break loop56;
					EarlyExitException eee = new EarlyExitException(56, input);
					throw eee;
				}
				cnt56++;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:363:1: term returns [Abstract_Term t] : (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) ;
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_StringTerm st =null;
		Abstract_Term ft =null;
		Abstract_NumberTerm at =null;
		Abstract_ListTermImpl lt =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:364:2: ( (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:364:4: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:364:4: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			int alt57=4;
			switch ( input.LA(1) ) {
			case STRING:
				{
				alt57=1;
				}
				break;
			case CONST:
				{
				alt57=2;
				}
				break;
			case MINUS:
			case NUMBER:
			case UNNAMEDVAR:
			case VAR:
				{
				alt57=3;
				}
				break;
			case SQOPEN:
				{
				alt57=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 57, 0, input);
				throw nvae;
			}
			switch (alt57) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:364:5: st= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term2122);
					st=stringterm();
					state._fsp--;

					t = st;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:365:4: ft= function_term
					{
					pushFollow(FOLLOW_function_term_in_term2132);
					ft=function_term();
					state._fsp--;

					t =ft;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:366:4: at= arithexpr
					{
					pushFollow(FOLLOW_arithexpr_in_term2142);
					at=arithexpr();
					state._fsp--;

					t =at;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:367:4: lt= listterm
					{
					pushFollow(FOLLOW_listterm_in_term2151);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:369:1: function_term returns [Abstract_Term t] : c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? ;
	public final Abstract_Term function_term() throws RecognitionException {
		Abstract_Term t = null;


		Token c=null;
		Abstract_Term t1 =null;
		Abstract_Term t2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:370:2: (c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:370:4: c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			{
			c=(Token)match(input,CONST,FOLLOW_CONST_in_function_term2169); 
			t=new Abstract_Predicate(c.getText());
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:371:2: ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			int alt59=2;
			int LA59_0 = input.LA(1);
			if ( (LA59_0==OPEN) ) {
				alt59=1;
			}
			switch (alt59) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:371:3: OPEN t1= term ( COMMA t2= term )* CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function_term2176); 
					pushFollow(FOLLOW_term_in_function_term2180);
					t1=term();
					state._fsp--;

					((Abstract_Predicate) t).addTerm(t1);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:372:2: ( COMMA t2= term )*
					loop58:
					while (true) {
						int alt58=2;
						int LA58_0 = input.LA(1);
						if ( (LA58_0==COMMA) ) {
							alt58=1;
						}

						switch (alt58) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:372:3: COMMA t2= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_function_term2187); 
							pushFollow(FOLLOW_term_in_function_term2191);
							t2=term();
							state._fsp--;

							((Abstract_Predicate) t).addTerm(t2);
							}
							break;

						default :
							break loop58;
						}
					}

					match(input,CLOSE,FOLLOW_CLOSE_in_function_term2197); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:376:1: var returns [Abstract_VarTerm v] : ( VAR | UNNAMEDVAR ) ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR3=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:377:2: ( ( VAR | UNNAMEDVAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:377:4: ( VAR | UNNAMEDVAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:377:4: ( VAR | UNNAMEDVAR )
			int alt60=2;
			int LA60_0 = input.LA(1);
			if ( (LA60_0==VAR) ) {
				alt60=1;
			}
			else if ( (LA60_0==UNNAMEDVAR) ) {
				alt60=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 60, 0, input);
				throw nvae;
			}

			switch (alt60) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:377:5: VAR
					{
					VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_var2217); 
					if (variables.containsKey(VAR3.getText())) {
							v = variables.get(VAR3.getText());
						            } else {
							v = new Abstract_VarTerm(VAR3.getText());
					                                                     variables.put(VAR3.getText(), v);
						           }
						
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:383:6: UNNAMEDVAR
					{
					match(input,UNNAMEDVAR,FOLLOW_UNNAMEDVAR_in_var2223); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:385:1: stringLiteral returns [Abstract_StringTerm s] : st= stringterm ;
	public final Abstract_StringTerm stringLiteral() throws RecognitionException {
		Abstract_StringTerm s = null;


		Abstract_StringTerm st =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:386:2: (st= stringterm )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:386:4: st= stringterm
			{
			pushFollow(FOLLOW_stringterm_in_stringLiteral2241);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:387:1: singleQuotedStringLiteral returns [Abstract_StringTerm s] : SINGLEQUOTE w= word SINGLEQUOTE ;
	public final Abstract_StringTerm singleQuotedStringLiteral() throws RecognitionException {
		Abstract_StringTerm s = null;


		String w =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:388:2: ( SINGLEQUOTE w= word SINGLEQUOTE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:388:4: SINGLEQUOTE w= word SINGLEQUOTE
			{
			match(input,SINGLEQUOTE,FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2255); 
			pushFollow(FOLLOW_word_in_singleQuotedStringLiteral2259);
			w=word();
			state._fsp--;

			match(input,SINGLEQUOTE,FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2261); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:390:1: stringterm returns [Abstract_StringTerm s] : STRING ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING4=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:391:2: ( STRING )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:391:4: STRING
			{
			STRING4=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm2278); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:394:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST5=null;
		Token VAR6=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:394:25: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:394:27: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:394:27: ( CONST | VAR )
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==CONST) ) {
				alt61=1;
			}
			else if ( (LA61_0==VAR) ) {
				alt61=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 61, 0, input);
				throw nvae;
			}

			switch (alt61) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:394:28: CONST
					{
					CONST5=(Token)match(input,CONST,FOLLOW_CONST_in_word2295); 
					s =CONST5.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:394:59: VAR
					{
					VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_word2301); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:396:1: listterm returns [Abstract_ListTermImpl l] : SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE ;
	public final Abstract_ListTermImpl listterm() throws RecognitionException {
		Abstract_ListTermImpl l = null;


		Token v=null;
		Abstract_Term h =null;
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:397:3: ( SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:397:5: SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE
			{
			l = new Abstract_ListTermImpl(); Abstract_ListTerm lrunning = l;
			match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2322); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:398:10: (h= term ( COMMA t= term )* ( BAR v= VAR )? )?
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==CONST||LA64_0==MINUS||LA64_0==NUMBER||LA64_0==SQOPEN||LA64_0==STRING||(LA64_0 >= UNNAMEDVAR && LA64_0 <= VAR)) ) {
				alt64=1;
			}
			switch (alt64) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:398:11: h= term ( COMMA t= term )* ( BAR v= VAR )?
					{
					pushFollow(FOLLOW_term_in_listterm2327);
					h=term();
					state._fsp--;

					l.addHead(h); l.addTail(new Abstract_ListTermImpl());
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:399:3: ( COMMA t= term )*
					loop62:
					while (true) {
						int alt62=2;
						int LA62_0 = input.LA(1);
						if ( (LA62_0==COMMA) ) {
							alt62=1;
						}

						switch (alt62) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:399:4: COMMA t= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_listterm2334); 
							pushFollow(FOLLOW_term_in_listterm2338);
							t=term();
							state._fsp--;

							Abstract_ListTerm l2 = new Abstract_ListTermImpl(); l2.addHead(t); l2.addTail(new Abstract_ListTermImpl()); lrunning.addTail(l2); lrunning=l2;
							}
							break;

						default :
							break loop62;
						}
					}

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:400:3: ( BAR v= VAR )?
					int alt63=2;
					int LA63_0 = input.LA(1);
					if ( (LA63_0==BAR) ) {
						alt63=1;
					}
					switch (alt63) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:400:4: BAR v= VAR
							{
							match(input,BAR,FOLLOW_BAR_in_listterm2347); 
							v=(Token)match(input,VAR,FOLLOW_VAR_in_listterm2351); 
							lrunning.addTail(new Abstract_VarTerm(v.getText()));
							}
							break;

					}

					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2363); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:404:1: equation returns [Abstract_Equation e] : ( (a1= arithexprg i= eqoper a2= arithexpr ) | (v= var EQUALS (a2= arithexpr |ft= term ) ) );
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation e = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;
		Abstract_VarTerm v =null;
		Abstract_Term ft =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:405:2: ( (a1= arithexprg i= eqoper a2= arithexpr ) | (v= var EQUALS (a2= arithexpr |ft= term ) ) )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:405:4: (a1= arithexprg i= eqoper a2= arithexpr )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:405:4: (a1= arithexprg i= eqoper a2= arithexpr )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:405:6: a1= arithexprg i= eqoper a2= arithexpr
					{
					pushFollow(FOLLOW_arithexprg_in_equation2383);
					a1=arithexprg();
					state._fsp--;

					pushFollow(FOLLOW_eqoper_in_equation2387);
					i=eqoper();
					state._fsp--;

					pushFollow(FOLLOW_arithexpr_in_equation2391);
					a2=arithexpr();
					state._fsp--;

					e = new Abstract_Equation(a1, i, a2);
					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:406:5: (v= var EQUALS (a2= arithexpr |ft= term ) )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:406:5: (v= var EQUALS (a2= arithexpr |ft= term ) )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:406:6: v= var EQUALS (a2= arithexpr |ft= term )
					{
					pushFollow(FOLLOW_var_in_equation2406);
					v=var();
					state._fsp--;

					match(input,EQUALS,FOLLOW_EQUALS_in_equation2408); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:406:19: (a2= arithexpr |ft= term )
					int alt65=2;
					switch ( input.LA(1) ) {
					case MINUS:
						{
						int LA65_1 = input.LA(2);
						if ( (LA65_1==NUMBER) ) {
							alt65=1;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 65, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case NUMBER:
						{
						alt65=1;
						}
						break;
					case VAR:
						{
						alt65=1;
						}
						break;
					case UNNAMEDVAR:
						{
						alt65=1;
						}
						break;
					case CONST:
					case SQOPEN:
					case STRING:
						{
						alt65=2;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 65, 0, input);
						throw nvae;
					}
					switch (alt65) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:406:20: a2= arithexpr
							{
							pushFollow(FOLLOW_arithexpr_in_equation2413);
							a2=arithexpr();
							state._fsp--;

							e = new Abstract_Equation(v, 2, a2);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:406:74: ft= term
							{
							pushFollow(FOLLOW_term_in_equation2421);
							ft=term();
							state._fsp--;

							e = new Abstract_Equation(v, 3, ft);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:408:1: forall_expr returns [ArrayList<Abstract_LogicalFormula> ts] : 'forall' OPEN t1= atom COMMA t2= atom CLOSE ;
	public final ArrayList<Abstract_LogicalFormula> forall_expr() throws RecognitionException {
		ArrayList<Abstract_LogicalFormula> ts = null;


		Abstract_LogicalFormula t1 =null;
		Abstract_LogicalFormula t2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:409:2: ( 'forall' OPEN t1= atom COMMA t2= atom CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:409:5: 'forall' OPEN t1= atom COMMA t2= atom CLOSE
			{
			ArrayList<Abstract_LogicalFormula> tl = new ArrayList<Abstract_LogicalFormula>();
			match(input,77,FOLLOW_77_in_forall_expr2444); 
			match(input,OPEN,FOLLOW_OPEN_in_forall_expr2446); 
			pushFollow(FOLLOW_atom_in_forall_expr2450);
			t1=atom();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_forall_expr2452); 
			pushFollow(FOLLOW_atom_in_forall_expr2456);
			t2=atom();
			state._fsp--;

			Abstract_LogExpr l = new Abstract_LogExpr(t1, Abstract_LogExpr.forall, t2); tl.add(l);
			match(input,CLOSE,FOLLOW_CLOSE_in_forall_expr2460); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:2: ( ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:4: ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? )
			{
			s = "";
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:15: ( MINUS )?
			int alt67=2;
			int LA67_0 = input.LA(1);
			if ( (LA67_0==MINUS) ) {
				alt67=1;
			}
			switch (alt67) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:16: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring2483); 
					s += "-";
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:417:2: (n1= NUMBER ( STOP n2= NUMBER )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:417:3: n1= NUMBER ( STOP n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2494); 
			s += n1.getText();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:418:2: ( STOP n2= NUMBER )?
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==STOP) ) {
				int LA68_1 = input.LA(2);
				if ( (LA68_1==NUMBER) ) {
					alt68=1;
				}
			}
			switch (alt68) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:418:3: STOP n2= NUMBER
					{
					match(input,STOP,FOLLOW_STOP_in_numberstring2500); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2506); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:420:1: arithexpr returns [Abstract_NumberTerm ae] : a1= multexpr (i= addoper a2= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:421:2: (a1= multexpr (i= addoper a2= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:421:4: a1= multexpr (i= addoper a2= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr2526);
			a1=multexpr();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:421:28: (i= addoper a2= multexpr )?
			int alt69=2;
			int LA69_0 = input.LA(1);
			if ( (LA69_0==MINUS||LA69_0==PLUS) ) {
				alt69=1;
			}
			switch (alt69) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:421:29: i= addoper a2= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr2533);
					i=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr2537);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:422:1: multexpr returns [Abstract_NumberTerm ae] : a1= atom_term (i= multoper a2= atom_term )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:2: (a1= atom_term (i= multoper a2= atom_term )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:4: a1= atom_term (i= multoper a2= atom_term )?
			{
			pushFollow(FOLLOW_atom_term_in_multexpr2555);
			a1=atom_term();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:28: (i= multoper a2= atom_term )?
			int alt70=2;
			int LA70_0 = input.LA(1);
			if ( (LA70_0==DIV||LA70_0==MULT) ) {
				alt70=1;
			}
			switch (alt70) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:29: i= multoper a2= atom_term
					{
					pushFollow(FOLLOW_multoper_in_multexpr2561);
					i=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_term_in_multexpr2565);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:425:1: atom_term returns [Abstract_NumberTerm t] : (n= numberstring |v= var ) ;
	public final Abstract_NumberTerm atom_term() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:426:2: ( (n= numberstring |v= var ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:426:4: (n= numberstring |v= var )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:426:4: (n= numberstring |v= var )
			int alt71=2;
			int LA71_0 = input.LA(1);
			if ( (LA71_0==MINUS||LA71_0==NUMBER) ) {
				alt71=1;
			}
			else if ( ((LA71_0 >= UNNAMEDVAR && LA71_0 <= VAR)) ) {
				alt71=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 71, 0, input);
				throw nvae;
			}

			switch (alt71) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:426:5: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom_term2587);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:426:66: v= var
					{
					pushFollow(FOLLOW_var_in_atom_term2595);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:1: arithexprg returns [Abstract_NumberTerm ae] : a1= multexprg (i= addoper a2= multexpr )? ;
	public final Abstract_NumberTerm arithexprg() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:2: (a1= multexprg (i= addoper a2= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:4: a1= multexprg (i= addoper a2= multexpr )?
			{
			pushFollow(FOLLOW_multexprg_in_arithexprg2616);
			a1=multexprg();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:29: (i= addoper a2= multexpr )?
			int alt72=2;
			int LA72_0 = input.LA(1);
			if ( (LA72_0==MINUS||LA72_0==PLUS) ) {
				alt72=1;
			}
			switch (alt72) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:30: i= addoper a2= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexprg2623);
					i=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexprg2627);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:431:1: multexprg returns [Abstract_NumberTerm ae] : a1= atom_termg (i= multoper a2= atom_term )? ;
	public final Abstract_NumberTerm multexprg() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:432:2: (a1= atom_termg (i= multoper a2= atom_term )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:432:4: a1= atom_termg (i= multoper a2= atom_term )?
			{
			pushFollow(FOLLOW_atom_termg_in_multexprg2645);
			a1=atom_termg();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:432:29: (i= multoper a2= atom_term )?
			int alt73=2;
			int LA73_0 = input.LA(1);
			if ( (LA73_0==DIV||LA73_0==MULT) ) {
				alt73=1;
			}
			switch (alt73) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:432:30: i= multoper a2= atom_term
					{
					pushFollow(FOLLOW_multoper_in_multexprg2651);
					i=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_term_in_multexprg2655);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:434:1: atom_termg returns [Abstract_NumberTerm t] : n= numberstring ;
	public final Abstract_NumberTerm atom_termg() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:435:2: (n= numberstring )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:435:4: n= numberstring
			{
			pushFollow(FOLLOW_numberstring_in_atom_termg2676);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:439:1: addoper returns [int i] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:2: ( ( PLUS | MINUS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:4: ( PLUS | MINUS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:4: ( PLUS | MINUS )
			int alt74=2;
			int LA74_0 = input.LA(1);
			if ( (LA74_0==PLUS) ) {
				alt74=1;
			}
			else if ( (LA74_0==MINUS) ) {
				alt74=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 74, 0, input);
				throw nvae;
			}

			switch (alt74) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:5: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper2696); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:22: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper2702); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:441:1: multoper returns [int i] : ( MULT | DIV ) ;
	public final int multoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:442:2: ( ( MULT | DIV ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:442:4: ( MULT | DIV )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:442:4: ( MULT | DIV )
			int alt75=2;
			int LA75_0 = input.LA(1);
			if ( (LA75_0==MULT) ) {
				alt75=1;
			}
			else if ( (LA75_0==DIV) ) {
				alt75=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 75, 0, input);
				throw nvae;
			}

			switch (alt75) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:442:5: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper2719); 
					i = 3;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:442:22: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper2725); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:443:1: eqoper returns [int i] : ( LESS | ( IS | EQUALS ) ) ;
	public final int eqoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:443:24: ( ( LESS | ( IS | EQUALS ) ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:443:26: ( LESS | ( IS | EQUALS ) )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:443:26: ( LESS | ( IS | EQUALS ) )
			int alt76=2;
			int LA76_0 = input.LA(1);
			if ( (LA76_0==LESS) ) {
				alt76=1;
			}
			else if ( (LA76_0==EQUALS||LA76_0==IS) ) {
				alt76=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 76, 0, input);
				throw nvae;
			}

			switch (alt76) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:443:27: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2741); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:443:44: ( IS | EQUALS )
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



	public static final BitSet FOLLOW_moduleImport_in_mas80 = new BitSet(new long[]{0x0000005010200002L,0x0000000000000001L});
	public static final BitSet FOLLOW_module_in_mas86 = new BitSet(new long[]{0x0000005010200002L,0x0000000000000001L});
	public static final BitSet FOLLOW_moduleImport_in_goalagent115 = new BitSet(new long[]{0x0000005010200002L,0x0000000000000001L});
	public static final BitSet FOLLOW_module_in_goalagent121 = new BitSet(new long[]{0x0000005010200002L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_moduleImport134 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_MODULEFILE_in_moduleImport136 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_moduleImport138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_moduleDef_in_module155 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_SQOPEN_in_module160 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001200L});
	public static final BitSet FOLLOW_moduleOption_in_module162 = new BitSet(new long[]{0x0080000000001000L});
	public static final BitSet FOLLOW_COMMA_in_module166 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001200L});
	public static final BitSet FOLLOW_moduleOption_in_module168 = new BitSet(new long[]{0x0080000000001000L});
	public static final BitSet FOLLOW_SQCLOSE_in_module173 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module178 = new BitSet(new long[]{0x0002000082008210L,0x0000000000000001L});
	public static final BitSet FOLLOW_krImport_in_module180 = new BitSet(new long[]{0x0002000082008210L});
	public static final BitSet FOLLOW_knowledge_in_module183 = new BitSet(new long[]{0x0002000002008210L});
	public static final BitSet FOLLOW_beliefs_in_module188 = new BitSet(new long[]{0x0002000002008010L});
	public static final BitSet FOLLOW_goals_in_module192 = new BitSet(new long[]{0x0002000000008010L});
	public static final BitSet FOLLOW_program_in_module196 = new BitSet(new long[]{0x0000000000008010L});
	public static final BitSet FOLLOW_actionSpecs_in_module205 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef228 = new BitSet(new long[]{0x4000000000004000L});
	public static final BitSet FOLLOW_declaration_in_moduleDef232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INIT_in_moduleDef239 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef241 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_moduleDef248 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EVENT_in_moduleDef257 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef259 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_73_in_moduleOption278 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_EQUALS_in_moduleOption280 = new BitSet(new long[]{0x0000000000000000L,0x00000000001A0040L});
	public static final BitSet FOLLOW_70_in_moduleOption287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_81_in_moduleOption297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_moduleOption307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_83_in_moduleOption318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_moduleOption332 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_EQUALS_in_moduleOption334 = new BitSet(new long[]{0x0000000000000000L,0x0000000000A40800L});
	public static final BitSet FOLLOW_set_in_moduleOption340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_krImport365 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_stringLiteral_in_krImport368 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_singleQuotedStringLiteral_in_krImport372 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_krImport375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KNOWLEDGE_in_knowledge388 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_knowledge390 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_krspec_in_knowledge392 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_knowledge395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_krspec407 = new BitSet(new long[]{0x0204000000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec411 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_krspec418 = new BitSet(new long[]{0x60000C2000004000L,0x0000000000002000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_krspec424 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_forall_expr_in_krspec430 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec434 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_BELIEFS_in_beliefs451 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_beliefs453 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_brspec_in_beliefs455 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_beliefs458 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_brspec470 = new BitSet(new long[]{0x0204000000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec474 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_brspec481 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_brspec485 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec487 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_GOALS_in_goals504 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_goals506 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_goal_list_in_goals510 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_goals514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_atom528 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_OPEN_in_atom530 = new BitSet(new long[]{0x6000082000004000L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_atom536 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_equation_in_atom546 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_atom552 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_atom559 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_atom568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROGRAM_in_program583 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_SQOPEN_in_program586 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_ruleEvaluationOrder_in_program590 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_program594 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program600 = new BitSet(new long[]{0x000000000C008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_macroDef_in_program602 = new BitSet(new long[]{0x000000000C008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_programRule_in_program610 = new BitSet(new long[]{0x0000000008008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_in_ruleEvaluationOrder633 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_EQUALS_in_ruleEvaluationOrder635 = new BitSet(new long[]{0x0018000600000020L});
	public static final BitSet FOLLOW_LINEAR_in_ruleEvaluationOrder639 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LINEARALL_in_ruleEvaluationOrder646 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANDOM_in_ruleEvaluationOrder652 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANDOMALL_in_ruleEvaluationOrder658 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADAPTIVE_in_ruleEvaluationOrder665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HASH_in_macroDef679 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_DEFINE_in_macroDef681 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_macroDef685 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_macroDef690 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_macroDef696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_programRule713 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule717 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_THEN_in_programRule721 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule727 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule735 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_programRule744 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule750 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule754 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule759 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule763 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule767 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_programRule775 = new BitSet(new long[]{0x6000000000000000L});
	public static final BitSet FOLLOW_var_in_programRule781 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_programRule783 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule787 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule794 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule799 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule804 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_programRule817 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule819 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_programRule821 = new BitSet(new long[]{0x6000000000000000L});
	public static final BitSet FOLLOW_var_in_programRule823 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule825 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule828 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule834 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURLYOPEN_in_nestedRules851 = new BitSet(new long[]{0x0000000008000000L,0x000000000000A000L});
	public static final BitSet FOLLOW_programRule_in_nestedRules858 = new BitSet(new long[]{0x0000000008008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_nestedRules865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_basicCondition_in_mentalstatecond883 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_mentalstatecond889 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_basicCondition_in_mentalstatecond893 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_mentalatom_in_mentalstate916 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_mentalstate923 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalstate925 = new BitSet(new long[]{0x4000000001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalatom_in_mentalstate927 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_mentalstate929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_mentalstate934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mentalstate_in_basicCondition954 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_basicCondition963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selector_in_mentalatom983 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_mentalatom985 = new BitSet(new long[]{0x0000000001800140L});
	public static final BitSet FOLLOW_mentalOperator_in_mentalatom991 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_atom_parameters_in_mentalatom995 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom_parameters1014 = new BitSet(new long[]{0x60001C2000004000L});
	public static final BitSet FOLLOW_atom_in_atom_parameters1023 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_COMMA_in_atom_parameters1029 = new BitSet(new long[]{0x60001C2000004000L});
	public static final BitSet FOLLOW_atom_in_atom_parameters1036 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_atom_parameters_in_atom_parameters1046 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_SEMI_in_atom_parameters1054 = new BitSet(new long[]{0x60001C2000004000L});
	public static final BitSet FOLLOW_atom_in_atom_parameters1062 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_atom_parameters_in_atom_parameters1072 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_atom_parameters_in_atom_parameters1090 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_atom_parameters1098 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEL_in_mentalOperator1119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_mentalOperator1130 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AGOAL_in_mentalOperator1141 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOALA_in_mentalOperator1152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actions1175 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_PLUS_in_actions1182 = new BitSet(new long[]{0x4000001010204000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_action_in_actions1186 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_selector_in_action1206 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_action1208 = new BitSet(new long[]{0x0000000000000000L,0x0000000006414188L});
	public static final BitSet FOLLOW_actionOperator_in_action1214 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_parameters_in_action1218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_74_in_action1230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_action1239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INIT_in_action1248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_action1257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EVENT_in_action1266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_action1273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_67_in_actionOperator1294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_actionOperator1305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_actionOperator1316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_actionOperator1327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_89_in_actionOperator1339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_90_in_actionOperator1348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_86_in_actionOperator1357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_actionOperator1368 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_selector1380 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_selector1389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_selector1398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_88_in_selector1407 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_91_in_selector1416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_92_in_selector1425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_93_in_selector1434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTIONSPEC_in_actionSpecs1453 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionSpecs1455 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_actionSpec_in_actionSpecs1460 = new BitSet(new long[]{0x000000000000C000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionSpecs1466 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_actionSpec1485 = new BitSet(new long[]{0x0000000020410000L});
	public static final BitSet FOLLOW_INTERNAL_in_actionSpec1488 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_EXTERNAL_in_actionSpec1494 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionSpec1500 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_precondition_in_actionSpec1504 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_postcondition_in_actionSpec1508 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionSpec1510 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRE_in_precondition1528 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_precondition1530 = new BitSet(new long[]{0x70000C2000004000L});
	public static final BitSet FOLLOW_TRUE_in_precondition1534 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_precondition1544 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_precondition1549 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POST_in_postcondition1564 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_postcondition1567 = new BitSet(new long[]{0x70000C2000004000L});
	public static final BitSet FOLLOW_TRUE_in_postcondition1571 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_postcondition1581 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_postcondition1590 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_declaration1607 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_parameters_in_declaration1614 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_declarationOrCallWithTerms1635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_id1654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_id1661 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_parameters1684 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_parameters1688 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_parameters1694 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_parameters1698 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_parameters1706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_no_bracket_parameters1728 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_no_bracket_parameters1734 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_no_bracket_parameters1738 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_atom_in_no_bracket_literals1769 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_no_bracket_literals1775 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_atom_in_no_bracket_literals1782 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_term_in_goal_list1814 = new BitSet(new long[]{0x0200000000001000L});
	public static final BitSet FOLLOW_COMMA_in_goal_list1821 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_goal_list1825 = new BitSet(new long[]{0x0200000000001000L});
	public static final BitSet FOLLOW_STOP_in_goal_list1832 = new BitSet(new long[]{0x6500082000004002L});
	public static final BitSet FOLLOW_stringterm_in_term2122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_term2132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_term2142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_term2151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function_term2169 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_OPEN_in_function_term2176 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_function_term2180 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_function_term2187 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_function_term2191 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_function_term2197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var2217 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNNAMEDVAR_in_var2223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_stringLiteral2241 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2255 = new BitSet(new long[]{0x4000000000004000L});
	public static final BitSet FOLLOW_word_in_singleQuotedStringLiteral2259 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2261 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_stringterm2278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_word2295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word2301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_listterm2322 = new BitSet(new long[]{0x6580082000004000L});
	public static final BitSet FOLLOW_term_in_listterm2327 = new BitSet(new long[]{0x0080000000001080L});
	public static final BitSet FOLLOW_COMMA_in_listterm2334 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_listterm2338 = new BitSet(new long[]{0x0080000000001080L});
	public static final BitSet FOLLOW_BAR_in_listterm2347 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_VAR_in_listterm2351 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_listterm2363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexprg_in_equation2383 = new BitSet(new long[]{0x0000000140100000L});
	public static final BitSet FOLLOW_eqoper_in_equation2387 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_arithexpr_in_equation2391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_equation2406 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_EQUALS_in_equation2408 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_arithexpr_in_equation2413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_equation2421 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_forall_expr2444 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_OPEN_in_forall_expr2446 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_atom_in_forall_expr2450 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COMMA_in_forall_expr2452 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_atom_in_forall_expr2456 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_forall_expr2460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring2483 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2494 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_STOP_in_numberstring2500 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2506 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2526 = new BitSet(new long[]{0x0000402000000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr2533 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2537 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2555 = new BitSet(new long[]{0x0000010000040002L});
	public static final BitSet FOLLOW_multoper_in_multexpr2561 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom_term2587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom_term2595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexprg_in_arithexprg2616 = new BitSet(new long[]{0x0000402000000002L});
	public static final BitSet FOLLOW_addoper_in_arithexprg2623 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexprg2627 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_termg_in_multexprg2645 = new BitSet(new long[]{0x0000010000040002L});
	public static final BitSet FOLLOW_multoper_in_multexprg2651 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_atom_term_in_multexprg2655 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom_termg2676 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper2696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper2702 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper2719 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper2725 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2741 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_eqoper2747 = new BitSet(new long[]{0x0000000000000002L});
}
