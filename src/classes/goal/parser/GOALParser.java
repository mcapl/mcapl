// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2015-12-01 11:43:05

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:118:1: atom returns [Abstract_LogicalFormula l] : ( NOT OPEN p= declarationOrCallWithTerms CLOSE |p= declarationOrCallWithTerms |e= equation );
	public final Abstract_LogicalFormula atom() throws RecognitionException {
		Abstract_LogicalFormula l = null;


		Abstract_Predicate p =null;
		Abstract_Equation e =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:2: ( NOT OPEN p= declarationOrCallWithTerms CLOSE |p= declarationOrCallWithTerms |e= equation )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:4: NOT OPEN p= declarationOrCallWithTerms CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_atom528); 
					match(input,OPEN,FOLLOW_OPEN_in_atom530); 
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_atom534);
					p=declarationOrCallWithTerms();
					state._fsp--;

					l = new Abstract_LogExpr(Abstract_LogExpr.not, p);
					match(input,CLOSE,FOLLOW_CLOSE_in_atom537); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_atom544);
					p=declarationOrCallWithTerms();
					state._fsp--;

					l =p;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:4: e= equation
					{
					pushFollow(FOLLOW_equation_in_atom553);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:1: program[Abstract_GOALModule gl] : PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* (rule= programRule )* CURLYCLOSE ;
	public final void program(Abstract_GOALModule gl) throws RecognitionException {
		int i =0;
		Abstract_ActionRule rule =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:2: ( PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* (rule= programRule )* CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:4: PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* (rule= programRule )* CURLYCLOSE
			{
			match(input,PROGRAM,FOLLOW_PROGRAM_in_program568); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:12: ( SQOPEN i= ruleEvaluationOrder SQCLOSE )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==SQOPEN) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:13: SQOPEN i= ruleEvaluationOrder SQCLOSE
					{
					match(input,SQOPEN,FOLLOW_SQOPEN_in_program571); 
					pushFollow(FOLLOW_ruleEvaluationOrder_in_program575);
					i=ruleEvaluationOrder();
					state._fsp--;

					gl.setOptionOrder(i);
					match(input,SQCLOSE,FOLLOW_SQCLOSE_in_program579); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program585); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:12: ( macroDef )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==HASH) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:12: macroDef
					{
					pushFollow(FOLLOW_macroDef_in_program587);
					macroDef();
					state._fsp--;

					}
					break;

				default :
					break loop22;
				}
			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:22: (rule= programRule )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==IF||LA23_0==77||LA23_0==79) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:23: rule= programRule
					{
					pushFollow(FOLLOW_programRule_in_program595);
					rule=programRule();
					state._fsp--;

					gl.addPlan(rule);
					}
					break;

				default :
					break loop23;
				}
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program601); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:131:1: ruleEvaluationOrder returns [int i] : ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE ) ;
	public final int ruleEvaluationOrder() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:132:2: ( ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:132:4: ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE )
			{
			match(input,ORDER,FOLLOW_ORDER_in_ruleEvaluationOrder618); 
			match(input,EQUALS,FOLLOW_EQUALS_in_ruleEvaluationOrder620); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:132:17: ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:132:19: LINEAR
					{
					match(input,LINEAR,FOLLOW_LINEAR_in_ruleEvaluationOrder624); 
					i =Abstract_GOALModule.linear;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:2: LINEARALL
					{
					match(input,LINEARALL,FOLLOW_LINEARALL_in_ruleEvaluationOrder631); 
					i =Abstract_GOALModule.linearall;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:134:2: RANDOM
					{
					match(input,RANDOM,FOLLOW_RANDOM_in_ruleEvaluationOrder637); 
					i =Abstract_GOALModule.random;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:135:2: RANDOMALL
					{
					match(input,RANDOMALL,FOLLOW_RANDOMALL_in_ruleEvaluationOrder643); 
					i =Abstract_GOALModule.randomall;
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:136:2: ADAPTIVE
					{
					match(input,ADAPTIVE,FOLLOW_ADAPTIVE_in_ruleEvaluationOrder650); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:139:1: macroDef : HASH DEFINE p= declarationOrCallWithTerms msc= mentalstatecond STOP ;
	public final void macroDef() throws RecognitionException {
		Abstract_Predicate p =null;
		Abstract_MentalState msc =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:140:2: ( HASH DEFINE p= declarationOrCallWithTerms msc= mentalstatecond STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:140:4: HASH DEFINE p= declarationOrCallWithTerms msc= mentalstatecond STOP
			{
			match(input,HASH,FOLLOW_HASH_in_macroDef664); 
			match(input,DEFINE,FOLLOW_DEFINE_in_macroDef666); 
			pushFollow(FOLLOW_declarationOrCallWithTerms_in_macroDef670);
			p=declarationOrCallWithTerms();
			state._fsp--;

			pushFollow(FOLLOW_mentalstatecond_in_macroDef675);
			msc=mentalstatecond();
			state._fsp--;

			PredicateIndicator pi = new PredicateIndicator(p.getFunctor(), p.getTermSize()); macros.put(pi, msc);
				macro_subs.put(pi, p);
			match(input,STOP,FOLLOW_STOP_in_macroDef681); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:146:1: programRule returns [Abstract_ActionRule rule] : ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] ) ) ;
	public final Abstract_ActionRule programRule() throws RecognitionException {
		Abstract_ActionRule rule = null;


		Abstract_MentalState lf =null;
		ArrayList<Abstract_Deed> dl =null;
		Abstract_VarTerm v =null;
		Abstract_MentalState ms =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:147:2: ( ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] ) ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:147:3: ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] ) )
			{
			rule = new Abstract_ActionRule();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:2: ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] ) | 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] ) | 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] ) )
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
				switch ( input.LA(2) ) {
				case VAR:
					{
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
					break;
				case UNNAMEDVAR:
					{
					alt29=3;
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
					alt29=4;
					}
					break;
				default:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:3: IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[rule] )
					{
					match(input,IF,FOLLOW_IF_in_programRule698); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule702);
					lf=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(lf);
					match(input,THEN,FOLLOW_THEN_in_programRule706); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:61: (dl= actions STOP | nestedRules[rule] )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:63: dl= actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule712);
							dl=actions();
							state._fsp--;

							rule.setBody(dl);
							match(input,STOP,FOLLOW_STOP_in_programRule716); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:101: nestedRules[rule]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule720);
							nestedRules(rule);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:4: 'forall' lf= mentalstatecond DO (dl= actions STOP | nestedRules[rule] )
					{
					match(input,77,FOLLOW_77_in_programRule729); 
					rule.setType(ActionRule.foralldo);
					pushFollow(FOLLOW_mentalstatecond_in_programRule735);
					lf=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(lf);
					match(input,DO,FOLLOW_DO_in_programRule739); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:103: (dl= actions STOP | nestedRules[rule] )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:104: dl= actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule744);
							dl=actions();
							state._fsp--;

							rule.setBody(dl);
							match(input,STOP,FOLLOW_STOP_in_programRule748); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:142: nestedRules[rule]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule752);
							nestedRules(rule);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:150:4: 'listall' v= var '<-' ms= mentalstatecond DO (dl= actions STOP | nestedRules[rule] )
					{
					match(input,79,FOLLOW_79_in_programRule760); 
					rule.setType(ActionRule.listalldo);
					pushFollow(FOLLOW_var_in_programRule766);
					v=var();
					state._fsp--;

					match(input,66,FOLLOW_66_in_programRule768); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule772);
					ms=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(new Abstract_MentalState(v, ms));
					match(input,DO,FOLLOW_DO_in_programRule779); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:151:6: (dl= actions STOP | nestedRules[rule] )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:151:7: dl= actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule784);
							dl=actions();
							state._fsp--;

							rule.setBody(dl);
							match(input,STOP,FOLLOW_STOP_in_programRule789); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:151:46: nestedRules[rule]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule793);
							nestedRules(rule);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:4: 'listall' mentalstatecond '->' var DO ( actions STOP | nestedRules[rule] )
					{
					match(input,79,FOLLOW_79_in_programRule802); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule804);
					mentalstatecond();
					state._fsp--;

					match(input,65,FOLLOW_65_in_programRule806); 
					pushFollow(FOLLOW_var_in_programRule808);
					var();
					state._fsp--;

					match(input,DO,FOLLOW_DO_in_programRule810); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:42: ( actions STOP | nestedRules[rule] )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:43: actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule813);
							actions();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_programRule815); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:152:58: nestedRules[rule]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule819);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:155:1: nestedRules[Abstract_ActionRule rule] : CURLYOPEN (r= programRule )+ CURLYCLOSE ;
	public final void nestedRules(Abstract_ActionRule rule) throws RecognitionException {
		Abstract_ActionRule r =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:156:2: ( CURLYOPEN (r= programRule )+ CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:156:4: CURLYOPEN (r= programRule )+ CURLYCLOSE
			{
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_nestedRules836); 
			ArrayList<Abstract_ActionRule> rules = new ArrayList<Abstract_ActionRule>();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:156:93: (r= programRule )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:156:94: r= programRule
					{
					pushFollow(FOLLOW_programRule_in_nestedRules843);
					r=programRule();
					state._fsp--;

					rules.add(r);
					}
					break;

				default :
					if ( cnt30 >= 1 ) break loop30;
					EarlyExitException eee = new EarlyExitException(30, input);
					throw eee;
				}
				cnt30++;
			}

			rule.merge(rules);
			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_nestedRules850); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:1: mentalstatecond returns [Abstract_MentalState lf] : ma= basicCondition ( COMMA ms2= basicCondition )* ;
	public final Abstract_MentalState mentalstatecond() throws RecognitionException {
		Abstract_MentalState lf = null;


		Abstract_MentalState ma =null;
		Abstract_MentalState ms2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:161:2: (ma= basicCondition ( COMMA ms2= basicCondition )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:161:4: ma= basicCondition ( COMMA ms2= basicCondition )*
			{
			pushFollow(FOLLOW_basicCondition_in_mentalstatecond868);
			ma=basicCondition();
			state._fsp--;

			Abstract_MentalState ms =  ma;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:162:2: ( COMMA ms2= basicCondition )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==COMMA) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:162:3: COMMA ms2= basicCondition
					{
					match(input,COMMA,FOLLOW_COMMA_in_mentalstatecond874); 
					pushFollow(FOLLOW_basicCondition_in_mentalstatecond878);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:1: mentalstate returns [Abstract_MentalState ms] : (ma= mentalatom | NOT OPEN mentalatom CLOSE | TRUE );
	public final Abstract_MentalState mentalstate() throws RecognitionException {
		Abstract_MentalState ms = null;


		Abstract_MentalState ma =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:166:2: (ma= mentalatom | NOT OPEN mentalatom CLOSE | TRUE )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:166:4: ma= mentalatom
					{
					pushFollow(FOLLOW_mentalatom_in_mentalstate901);
					ma=mentalatom();
					state._fsp--;

					ms = new Abstract_MentalState(ma);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:167:4: NOT OPEN mentalatom CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_mentalstate908); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalstate910); 
					pushFollow(FOLLOW_mentalatom_in_mentalstate912);
					mentalatom();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_mentalstate914); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:168:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_mentalstate919); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:171:1: basicCondition returns [Abstract_MentalState ms] : (ms1= mentalstate |p= declarationOrCallWithTerms );
	public final Abstract_MentalState basicCondition() throws RecognitionException {
		Abstract_MentalState ms = null;


		Abstract_MentalState ms1 =null;
		Abstract_Predicate p =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:2: (ms1= mentalstate |p= declarationOrCallWithTerms )
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==CONST) ) {
				int LA33_1 = input.LA(2);
				if ( (LA33_1==STOP) ) {
					int LA33_3 = input.LA(3);
					if ( (LA33_3==AGOAL||LA33_3==BEL||(LA33_3 >= GOAL && LA33_3 <= GOALA)) ) {
						alt33=1;
					}
					else if ( (LA33_3==CURLYCLOSE||(LA33_3 >= HASH && LA33_3 <= IF)||LA33_3==77||LA33_3==79) ) {
						alt33=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 33, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:172:4: ms1= mentalstate
					{
					pushFollow(FOLLOW_mentalstate_in_basicCondition939);
					ms1=mentalstate();
					state._fsp--;

					ms = ms1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_basicCondition948);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:1: mentalatom returns [Abstract_MentalState ms] : ( selector STOP )? b= mentalOperator tl= atom_parameters ;
	public final Abstract_MentalState mentalatom() throws RecognitionException {
		Abstract_MentalState ms = null;


		byte b =0;
		Abstract_LogExpr tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:181:2: ( ( selector STOP )? b= mentalOperator tl= atom_parameters )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:2: ( selector STOP )? b= mentalOperator tl= atom_parameters
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:2: ( selector STOP )?
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==CONST||LA34_0==VAR||(LA34_0 >= 68 && LA34_0 <= 69)||LA34_0==88||(LA34_0 >= 91 && LA34_0 <= 93)) ) {
				alt34=1;
			}
			switch (alt34) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:3: selector STOP
					{
					pushFollow(FOLLOW_selector_in_mentalatom968);
					selector();
					state._fsp--;

					match(input,STOP,FOLLOW_STOP_in_mentalatom970); 
					}
					break;

			}

			pushFollow(FOLLOW_mentalOperator_in_mentalatom976);
			b=mentalOperator();
			state._fsp--;

			pushFollow(FOLLOW_atom_parameters_in_mentalatom980);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:195:1: atom_parameters returns [Abstract_LogExpr ts] : OPEN (t= atom ( COMMA t1= atom | SEMI t1= atom )* |ap= atom_parameters ) CLOSE ;
	public final Abstract_LogExpr atom_parameters() throws RecognitionException {
		Abstract_LogExpr ts = null;


		Abstract_LogicalFormula t =null;
		Abstract_LogicalFormula t1 =null;
		Abstract_LogExpr ap =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:2: ( OPEN (t= atom ( COMMA t1= atom | SEMI t1= atom )* |ap= atom_parameters ) CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:4: OPEN (t= atom ( COMMA t1= atom | SEMI t1= atom )* |ap= atom_parameters ) CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_atom_parameters999); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:9: (t= atom ( COMMA t1= atom | SEMI t1= atom )* |ap= atom_parameters )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:3: t= atom ( COMMA t1= atom | SEMI t1= atom )*
					{
					pushFollow(FOLLOW_atom_in_atom_parameters1008);
					t=atom();
					state._fsp--;

					Abstract_LogExpr tl = new Abstract_LogExpr(Abstract_LogExpr.none, t);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:198:2: ( COMMA t1= atom | SEMI t1= atom )*
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:198:3: COMMA t1= atom
							{
							match(input,COMMA,FOLLOW_COMMA_in_atom_parameters1014); 
							pushFollow(FOLLOW_atom_in_atom_parameters1019);
							t1=atom();
							state._fsp--;

							tl = new Abstract_LogExpr(tl, Abstract_LogExpr.and,  t1);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:4: SEMI t1= atom
							{
							match(input,SEMI,FOLLOW_SEMI_in_atom_parameters1026); 
							pushFollow(FOLLOW_atom_in_atom_parameters1033);
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:5: ap= atom_parameters
					{
					pushFollow(FOLLOW_atom_parameters_in_atom_parameters1050);
					ap=atom_parameters();
					state._fsp--;

					ts = ap;
					}
					break;

			}

			match(input,CLOSE,FOLLOW_CLOSE_in_atom_parameters1058); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:1: mentalOperator returns [byte b] : (op= BEL |op= GOAL |op= AGOAL |op= GOALA );
	public final byte mentalOperator() throws RecognitionException {
		byte b = 0;


		Token op=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:2: (op= BEL |op= GOAL |op= AGOAL |op= GOALA )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:4: op= BEL
					{
					op=(Token)match(input,BEL,FOLLOW_BEL_in_mentalOperator1079); 
					b = Abstract_BaseAILStructure.AILBel;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:4: op= GOAL
					{
					op=(Token)match(input,GOAL,FOLLOW_GOAL_in_mentalOperator1090); 
					b = Abstract_BaseAILStructure.AILGoal;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:209:4: op= AGOAL
					{
					op=(Token)match(input,AGOAL,FOLLOW_AGOAL_in_mentalOperator1101); 
					b = Abstract_MentalAtom.agoal;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:4: op= GOALA
					{
					op=(Token)match(input,GOALA,FOLLOW_GOALA_in_mentalOperator1112); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:213:1: actions returns [ArrayList<Abstract_Deed> dl] :a= action ( PLUS a1= action )* ;
	public final ArrayList<Abstract_Deed> actions() throws RecognitionException {
		ArrayList<Abstract_Deed> dl = null;


		Abstract_Deed a =null;
		Abstract_Deed a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:214:2: (a= action ( PLUS a1= action )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:214:4: a= action ( PLUS a1= action )*
			{
			dl = new ArrayList<Abstract_Deed>();
			pushFollow(FOLLOW_action_in_actions1135);
			a=action();
			state._fsp--;

			dl.add(a);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:216:2: ( PLUS a1= action )*
			loop38:
			while (true) {
				int alt38=2;
				int LA38_0 = input.LA(1);
				if ( (LA38_0==PLUS) ) {
					alt38=1;
				}

				switch (alt38) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:216:3: PLUS a1= action
					{
					match(input,PLUS,FOLLOW_PLUS_in_actions1142); 
					pushFollow(FOLLOW_action_in_actions1146);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:1: action returns [Abstract_Deed d] : ( ( selector STOP )? d1= actionOperator tl= parameters |op= 'exit-module' |op= 'log' |op= INIT |op= MAIN |op= EVENT |p= declarationOrCallWithTerms );
	public final Abstract_Deed action() throws RecognitionException {
		Abstract_Deed d = null;


		Token op=null;
		Abstract_Deed d1 =null;
		ArrayList<Abstract_Term> tl =null;
		Abstract_Predicate p =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:2: ( ( selector STOP )? d1= actionOperator tl= parameters |op= 'exit-module' |op= 'log' |op= INIT |op= MAIN |op= EVENT |p= declarationOrCallWithTerms )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:4: ( selector STOP )? d1= actionOperator tl= parameters
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:4: ( selector STOP )?
					int alt39=2;
					int LA39_0 = input.LA(1);
					if ( (LA39_0==CONST||LA39_0==VAR||(LA39_0 >= 68 && LA39_0 <= 69)||LA39_0==88||(LA39_0 >= 91 && LA39_0 <= 93)) ) {
						alt39=1;
					}
					switch (alt39) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:5: selector STOP
							{
							pushFollow(FOLLOW_selector_in_action1166);
							selector();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_action1168); 
							}
							break;

					}

					pushFollow(FOLLOW_actionOperator_in_action1174);
					d1=actionOperator();
					state._fsp--;

					pushFollow(FOLLOW_parameters_in_action1178);
					tl=parameters();
					state._fsp--;

					d1.addParams(tl); d =d1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:222:4: op= 'exit-module'
					{
					op=(Token)match(input,74,FOLLOW_74_in_action1190); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:223:4: op= 'log'
					{
					op=(Token)match(input,80,FOLLOW_80_in_action1199); 
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:224:4: op= INIT
					{
					op=(Token)match(input,INIT,FOLLOW_INIT_in_action1208); 
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:225:4: op= MAIN
					{
					op=(Token)match(input,MAIN,FOLLOW_MAIN_in_action1217); 
					}
					break;
				case 6 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:226:4: op= EVENT
					{
					op=(Token)match(input,EVENT,FOLLOW_EVENT_in_action1226); 
					}
					break;
				case 7 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:227:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_action1233);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:230:1: actionOperator returns [Abstract_Deed d] : (op= 'adopt' |op= 'drop' |op= 'insert' |op= 'delete' |op= 'send' |op= 'sendonce' |op= 'print' |op= 'log' );
	public final Abstract_Deed actionOperator() throws RecognitionException {
		Abstract_Deed d = null;


		Token op=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:231:2: (op= 'adopt' |op= 'drop' |op= 'insert' |op= 'delete' |op= 'send' |op= 'sendonce' |op= 'print' |op= 'log' )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:231:4: op= 'adopt'
					{
					op=(Token)match(input,67,FOLLOW_67_in_actionOperator1254); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, Abstract_BaseAILStructure.AILGoal);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:232:4: op= 'drop'
					{
					op=(Token)match(input,72,FOLLOW_72_in_actionOperator1265); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILDeletion, Abstract_BaseAILStructure.AILGoal);
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:233:4: op= 'insert'
					{
					op=(Token)match(input,78,FOLLOW_78_in_actionOperator1276); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, Abstract_BaseAILStructure.AILBel);
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:234:4: op= 'delete'
					{
					op=(Token)match(input,71,FOLLOW_71_in_actionOperator1287); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILDeletion, Abstract_BaseAILStructure.AILBel);
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:235:4: op= 'send'
					{
					op=(Token)match(input,89,FOLLOW_89_in_actionOperator1299); 
					}
					break;
				case 6 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:236:4: op= 'sendonce'
					{
					op=(Token)match(input,90,FOLLOW_90_in_actionOperator1308); 
					}
					break;
				case 7 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:237:4: op= 'print'
					{
					op=(Token)match(input,86,FOLLOW_86_in_actionOperator1317); 
					d = new Abstract_Deed(new Abstract_PrintAction());
					}
					break;
				case 8 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:238:4: op= 'log'
					{
					op=(Token)match(input,80,FOLLOW_80_in_actionOperator1328); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:242:1: selector : ( word |op= 'all' |op= 'allother' |op= 'self' |op= 'some' |op= 'someother' |op= 'this' );
	public final void selector() throws RecognitionException {
		Token op=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:243:2: ( word |op= 'all' |op= 'allother' |op= 'self' |op= 'some' |op= 'someother' |op= 'this' )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:243:4: word
					{
					pushFollow(FOLLOW_word_in_selector1340);
					word();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:244:4: op= 'all'
					{
					op=(Token)match(input,68,FOLLOW_68_in_selector1349); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:245:4: op= 'allother'
					{
					op=(Token)match(input,69,FOLLOW_69_in_selector1358); 
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:246:4: op= 'self'
					{
					op=(Token)match(input,88,FOLLOW_88_in_selector1367); 
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:247:4: op= 'some'
					{
					op=(Token)match(input,91,FOLLOW_91_in_selector1376); 
					}
					break;
				case 6 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:248:4: op= 'someother'
					{
					op=(Token)match(input,92,FOLLOW_92_in_selector1385); 
					}
					break;
				case 7 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:249:4: op= 'this'
					{
					op=(Token)match(input,93,FOLLOW_93_in_selector1394); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:252:1: actionSpecs returns [ArrayList<Abstract_ActionSpec> as] : ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE ;
	public final ArrayList<Abstract_ActionSpec> actionSpecs() throws RecognitionException {
		ArrayList<Abstract_ActionSpec> as = null;


		Abstract_ActionSpec a =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:253:2: ( ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:253:4: ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE
			{
			as = new ArrayList<Abstract_ActionSpec>();
			match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_actionSpecs1413); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionSpecs1415); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:254:23: (a= actionSpec )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:254:24: a= actionSpec
					{
					pushFollow(FOLLOW_actionSpec_in_actionSpecs1420);
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

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionSpecs1426); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:257:1: actionSpec returns [Abstract_ActionSpec as] :cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE ;
	public final Abstract_ActionSpec actionSpec() throws RecognitionException {
		Abstract_ActionSpec as = null;


		Abstract_Predicate cap =null;
		Abstract_LogicalFormula pre =null;
		Abstract_LogicalFormula post =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:258:2: (cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:258:4: cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE
			{
			boolean internal=false;
			pushFollow(FOLLOW_declarationOrCallWithTerms_in_actionSpec1445);
			cap=declarationOrCallWithTerms();
			state._fsp--;

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:258:61: ( INTERNAL | EXTERNAL )?
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:258:62: INTERNAL
					{
					match(input,INTERNAL,FOLLOW_INTERNAL_in_actionSpec1448); 
					internal = true;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:258:92: EXTERNAL
					{
					match(input,EXTERNAL,FOLLOW_EXTERNAL_in_actionSpec1454); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionSpec1460); 
			pushFollow(FOLLOW_precondition_in_actionSpec1464);
			pre=precondition();
			state._fsp--;

			pushFollow(FOLLOW_postcondition_in_actionSpec1468);
			post=postcondition();
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionSpec1470); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:263:1: precondition returns [Abstract_LogicalFormula f] : PRE CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE ;
	public final Abstract_LogicalFormula precondition() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		ArrayList<Abstract_LogicalFormula> tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:264:2: ( PRE CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:264:4: PRE CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE
			{
			match(input,PRE,FOLLOW_PRE_in_precondition1488); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_precondition1490); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:264:19: ( TRUE |tl= no_bracket_literals )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:264:20: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_precondition1494); 
					f = new Abstract_LogExpr();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:265:4: tl= no_bracket_literals
					{
					pushFollow(FOLLOW_no_bracket_literals_in_precondition1504);
					tl=no_bracket_literals();
					state._fsp--;

					f = new Abstract_LogExpr(tl);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_precondition1509); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:268:1: postcondition returns [Abstract_LogicalFormula f] : POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE ;
	public final Abstract_LogicalFormula postcondition() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		ArrayList<Abstract_LogicalFormula> tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:269:2: ( POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:269:4: POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE
			{
			match(input,POST,FOLLOW_POST_in_postcondition1524); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_postcondition1527); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:270:2: ( TRUE |tl= no_bracket_literals )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:270:3: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_postcondition1531); 
					f = new Abstract_LogExpr();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:271:4: tl= no_bracket_literals
					{
					pushFollow(FOLLOW_no_bracket_literals_in_postcondition1541);
					tl=no_bracket_literals();
					state._fsp--;


							f = new Abstract_LogExpr(tl);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_postcondition1550); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:277:1: declaration returns [Abstract_Predicate p] : f= id (tl= parameters )? ;
	public final Abstract_Predicate declaration() throws RecognitionException {
		Abstract_Predicate p = null;


		String f =null;
		ArrayList<Abstract_Term> tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:278:2: (f= id (tl= parameters )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:278:4: f= id (tl= parameters )?
			{
			pushFollow(FOLLOW_id_in_declaration1567);
			f=id();
			state._fsp--;

			p= new Abstract_Predicate(f);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:278:41: (tl= parameters )?
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==OPEN) ) {
				alt47=1;
			}
			switch (alt47) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:278:42: tl= parameters
					{
					pushFollow(FOLLOW_parameters_in_declaration1574);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:281:1: declarationOrCallWithTerms returns [Abstract_Predicate p] : f= function_term ;
	public final Abstract_Predicate declarationOrCallWithTerms() throws RecognitionException {
		Abstract_Predicate p = null;


		Abstract_Term f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:282:2: (f= function_term )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:282:4: f= function_term
			{
			pushFollow(FOLLOW_function_term_in_declarationOrCallWithTerms1595);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:285:1: id returns [String s] : ( CONST | VAR ) ;
	public final String id() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:286:2: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:286:4: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:286:4: ( CONST | VAR )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:286:5: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_id1614); 
					s = CONST1.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:287:4: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_id1621); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:291:1: parameters returns [ArrayList<Abstract_Term>ts] : OPEN t= term ( COMMA t1= term )* CLOSE ;
	public final ArrayList<Abstract_Term> parameters() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:292:2: ( OPEN t= term ( COMMA t1= term )* CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:292:4: OPEN t= term ( COMMA t1= term )* CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_parameters1644); 
			pushFollow(FOLLOW_term_in_parameters1648);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:293:2: ( COMMA t1= term )*
			loop49:
			while (true) {
				int alt49=2;
				int LA49_0 = input.LA(1);
				if ( (LA49_0==COMMA) ) {
					alt49=1;
				}

				switch (alt49) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:293:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_parameters1654); 
					pushFollow(FOLLOW_term_in_parameters1658);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop49;
				}
			}

			match(input,CLOSE,FOLLOW_CLOSE_in_parameters1666); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:297:1: no_bracket_parameters returns [ArrayList<Abstract_Term>ts] : t= term ( COMMA t1= term )* ;
	public final ArrayList<Abstract_Term> no_bracket_parameters() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:298:2: (t= term ( COMMA t1= term )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:298:5: t= term ( COMMA t1= term )*
			{
			pushFollow(FOLLOW_term_in_no_bracket_parameters1688);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:299:2: ( COMMA t1= term )*
			loop50:
			while (true) {
				int alt50=2;
				int LA50_0 = input.LA(1);
				if ( (LA50_0==COMMA) ) {
					alt50=1;
				}

				switch (alt50) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:299:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_no_bracket_parameters1694); 
					pushFollow(FOLLOW_term_in_no_bracket_parameters1698);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:303:1: no_bracket_literals returns [ArrayList<Abstract_LogicalFormula>ts] :t= atom ( COMMA t1= atom )* ;
	public final ArrayList<Abstract_LogicalFormula> no_bracket_literals() throws RecognitionException {
		ArrayList<Abstract_LogicalFormula> ts = null;


		Abstract_LogicalFormula t =null;
		Abstract_LogicalFormula t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:304:2: (t= atom ( COMMA t1= atom )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:304:5: t= atom ( COMMA t1= atom )*
			{
			ArrayList<Abstract_LogicalFormula> tl = new ArrayList<Abstract_LogicalFormula>();
			pushFollow(FOLLOW_atom_in_no_bracket_literals1729);
			t=atom();
			state._fsp--;

			 tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:306:2: ( COMMA t1= atom )*
			loop51:
			while (true) {
				int alt51=2;
				int LA51_0 = input.LA(1);
				if ( (LA51_0==COMMA) ) {
					alt51=1;
				}

				switch (alt51) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:306:3: COMMA t1= atom
					{
					match(input,COMMA,FOLLOW_COMMA_in_no_bracket_literals1735); 
					pushFollow(FOLLOW_atom_in_no_bracket_literals1742);
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



	// $ANTLR start "goal_list"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:312:1: goal_list returns [ArrayList<ArrayList<Abstract_Term>>ts] : (t= term ( COMMA t1= term )* STOP )+ ;
	public final ArrayList<ArrayList<Abstract_Term>> goal_list() throws RecognitionException {
		ArrayList<ArrayList<Abstract_Term>> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:313:2: ( (t= term ( COMMA t1= term )* STOP )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:313:4: (t= term ( COMMA t1= term )* STOP )+
			{
			ArrayList<ArrayList<Abstract_Term>> tll = new ArrayList<ArrayList<Abstract_Term>>();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:314:2: (t= term ( COMMA t1= term )* STOP )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:314:3: t= term ( COMMA t1= term )* STOP
					{
					pushFollow(FOLLOW_term_in_goal_list1774);
					t=term();
					state._fsp--;

					ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:315:2: ( COMMA t1= term )*
					loop52:
					while (true) {
						int alt52=2;
						int LA52_0 = input.LA(1);
						if ( (LA52_0==COMMA) ) {
							alt52=1;
						}

						switch (alt52) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:315:3: COMMA t1= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_goal_list1781); 
							pushFollow(FOLLOW_term_in_goal_list1785);
							t1=term();
							state._fsp--;

							tl.add(t1);
							}
							break;

						default :
							break loop52;
						}
					}

					match(input,STOP,FOLLOW_STOP_in_goal_list1792); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:360:1: term returns [Abstract_Term t] : (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) ;
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_StringTerm st =null;
		Abstract_Term ft =null;
		Abstract_NumberTerm at =null;
		Abstract_ListTermImpl lt =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:361:2: ( (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:361:4: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:361:4: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:361:5: st= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term2082);
					st=stringterm();
					state._fsp--;

					t = st;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:362:4: ft= function_term
					{
					pushFollow(FOLLOW_function_term_in_term2092);
					ft=function_term();
					state._fsp--;

					t =ft;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:363:4: at= arithexpr
					{
					pushFollow(FOLLOW_arithexpr_in_term2102);
					at=arithexpr();
					state._fsp--;

					t =at;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:364:4: lt= listterm
					{
					pushFollow(FOLLOW_listterm_in_term2111);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:366:1: function_term returns [Abstract_Term t] : c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? ;
	public final Abstract_Term function_term() throws RecognitionException {
		Abstract_Term t = null;


		Token c=null;
		Abstract_Term t1 =null;
		Abstract_Term t2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:367:2: (c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:367:4: c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			{
			c=(Token)match(input,CONST,FOLLOW_CONST_in_function_term2129); 
			t=new Abstract_Predicate(c.getText());
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:368:2: ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==OPEN) ) {
				alt56=1;
			}
			switch (alt56) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:368:3: OPEN t1= term ( COMMA t2= term )* CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function_term2136); 
					pushFollow(FOLLOW_term_in_function_term2140);
					t1=term();
					state._fsp--;

					((Abstract_Predicate) t).addTerm(t1);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:369:2: ( COMMA t2= term )*
					loop55:
					while (true) {
						int alt55=2;
						int LA55_0 = input.LA(1);
						if ( (LA55_0==COMMA) ) {
							alt55=1;
						}

						switch (alt55) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:369:3: COMMA t2= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_function_term2147); 
							pushFollow(FOLLOW_term_in_function_term2151);
							t2=term();
							state._fsp--;

							((Abstract_Predicate) t).addTerm(t2);
							}
							break;

						default :
							break loop55;
						}
					}

					match(input,CLOSE,FOLLOW_CLOSE_in_function_term2157); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:373:1: var returns [Abstract_VarTerm v] : ( VAR | UNNAMEDVAR ) ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR3=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:374:2: ( ( VAR | UNNAMEDVAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:374:4: ( VAR | UNNAMEDVAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:374:4: ( VAR | UNNAMEDVAR )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:374:5: VAR
					{
					VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_var2177); 
					if (variables.containsKey(VAR3.getText())) {
							v = variables.get(VAR3.getText());
						            } else {
							v = new Abstract_VarTerm(VAR3.getText());
					                                                     variables.put(VAR3.getText(), v);
						           }
						
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:380:6: UNNAMEDVAR
					{
					match(input,UNNAMEDVAR,FOLLOW_UNNAMEDVAR_in_var2183); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:382:1: stringLiteral returns [Abstract_StringTerm s] : st= stringterm ;
	public final Abstract_StringTerm stringLiteral() throws RecognitionException {
		Abstract_StringTerm s = null;


		Abstract_StringTerm st =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:383:2: (st= stringterm )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:383:4: st= stringterm
			{
			pushFollow(FOLLOW_stringterm_in_stringLiteral2201);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:384:1: singleQuotedStringLiteral returns [Abstract_StringTerm s] : SINGLEQUOTE w= word SINGLEQUOTE ;
	public final Abstract_StringTerm singleQuotedStringLiteral() throws RecognitionException {
		Abstract_StringTerm s = null;


		String w =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:385:2: ( SINGLEQUOTE w= word SINGLEQUOTE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:385:4: SINGLEQUOTE w= word SINGLEQUOTE
			{
			match(input,SINGLEQUOTE,FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2215); 
			pushFollow(FOLLOW_word_in_singleQuotedStringLiteral2219);
			w=word();
			state._fsp--;

			match(input,SINGLEQUOTE,FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2221); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:387:1: stringterm returns [Abstract_StringTerm s] : STRING ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING4=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:388:2: ( STRING )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:388:4: STRING
			{
			STRING4=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm2238); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:391:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST5=null;
		Token VAR6=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:391:25: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:391:27: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:391:27: ( CONST | VAR )
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:391:28: CONST
					{
					CONST5=(Token)match(input,CONST,FOLLOW_CONST_in_word2255); 
					s =CONST5.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:391:59: VAR
					{
					VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_word2261); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:393:1: listterm returns [Abstract_ListTermImpl l] : SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE ;
	public final Abstract_ListTermImpl listterm() throws RecognitionException {
		Abstract_ListTermImpl l = null;


		Token v=null;
		Abstract_Term h =null;
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:394:3: ( SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:394:5: SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE
			{
			l = new Abstract_ListTermImpl(); Abstract_ListTerm lrunning = l;
			match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2282); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:395:10: (h= term ( COMMA t= term )* ( BAR v= VAR )? )?
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==CONST||LA61_0==MINUS||LA61_0==NUMBER||LA61_0==SQOPEN||LA61_0==STRING||(LA61_0 >= UNNAMEDVAR && LA61_0 <= VAR)) ) {
				alt61=1;
			}
			switch (alt61) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:395:11: h= term ( COMMA t= term )* ( BAR v= VAR )?
					{
					pushFollow(FOLLOW_term_in_listterm2287);
					h=term();
					state._fsp--;

					l.addHead(h); l.addTail(new Abstract_ListTermImpl());
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:396:3: ( COMMA t= term )*
					loop59:
					while (true) {
						int alt59=2;
						int LA59_0 = input.LA(1);
						if ( (LA59_0==COMMA) ) {
							alt59=1;
						}

						switch (alt59) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:396:4: COMMA t= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_listterm2294); 
							pushFollow(FOLLOW_term_in_listterm2298);
							t=term();
							state._fsp--;

							Abstract_ListTerm l2 = new Abstract_ListTermImpl(); l2.addHead(t); l2.addTail(new Abstract_ListTermImpl()); lrunning.addTail(l2); lrunning=l2;
							}
							break;

						default :
							break loop59;
						}
					}

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:397:3: ( BAR v= VAR )?
					int alt60=2;
					int LA60_0 = input.LA(1);
					if ( (LA60_0==BAR) ) {
						alt60=1;
					}
					switch (alt60) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:397:4: BAR v= VAR
							{
							match(input,BAR,FOLLOW_BAR_in_listterm2307); 
							v=(Token)match(input,VAR,FOLLOW_VAR_in_listterm2311); 
							lrunning.addTail(new Abstract_VarTerm(v.getText()));
							}
							break;

					}

					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2323); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:401:1: equation returns [Abstract_Equation e] : ( (a1= arithexprg i= eqoper a2= arithexpr ) | (v= var EQUALS (a2= arithexpr |ft= function_term ) ) );
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation e = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;
		Abstract_VarTerm v =null;
		Abstract_Term ft =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:402:2: ( (a1= arithexprg i= eqoper a2= arithexpr ) | (v= var EQUALS (a2= arithexpr |ft= function_term ) ) )
			int alt63=2;
			int LA63_0 = input.LA(1);
			if ( (LA63_0==MINUS||LA63_0==NUMBER) ) {
				alt63=1;
			}
			else if ( ((LA63_0 >= UNNAMEDVAR && LA63_0 <= VAR)) ) {
				alt63=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 63, 0, input);
				throw nvae;
			}

			switch (alt63) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:402:4: (a1= arithexprg i= eqoper a2= arithexpr )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:402:4: (a1= arithexprg i= eqoper a2= arithexpr )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:402:6: a1= arithexprg i= eqoper a2= arithexpr
					{
					pushFollow(FOLLOW_arithexprg_in_equation2343);
					a1=arithexprg();
					state._fsp--;

					pushFollow(FOLLOW_eqoper_in_equation2347);
					i=eqoper();
					state._fsp--;

					pushFollow(FOLLOW_arithexpr_in_equation2351);
					a2=arithexpr();
					state._fsp--;

					e = new Abstract_Equation(a1, i, a2);
					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:403:5: (v= var EQUALS (a2= arithexpr |ft= function_term ) )
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:403:5: (v= var EQUALS (a2= arithexpr |ft= function_term ) )
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:403:6: v= var EQUALS (a2= arithexpr |ft= function_term )
					{
					pushFollow(FOLLOW_var_in_equation2366);
					v=var();
					state._fsp--;

					match(input,EQUALS,FOLLOW_EQUALS_in_equation2368); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:403:19: (a2= arithexpr |ft= function_term )
					int alt62=2;
					int LA62_0 = input.LA(1);
					if ( (LA62_0==MINUS||LA62_0==NUMBER||(LA62_0 >= UNNAMEDVAR && LA62_0 <= VAR)) ) {
						alt62=1;
					}
					else if ( (LA62_0==CONST) ) {
						alt62=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 62, 0, input);
						throw nvae;
					}

					switch (alt62) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:403:20: a2= arithexpr
							{
							pushFollow(FOLLOW_arithexpr_in_equation2373);
							a2=arithexpr();
							state._fsp--;

							e = new Abstract_Equation(v, 2, a2);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:403:74: ft= function_term
							{
							pushFollow(FOLLOW_function_term_in_equation2381);
							ft=function_term();
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:405:1: forall_expr returns [ArrayList<Abstract_LogicalFormula> ts] : 'forall' OPEN t1= atom COMMA t2= atom CLOSE ;
	public final ArrayList<Abstract_LogicalFormula> forall_expr() throws RecognitionException {
		ArrayList<Abstract_LogicalFormula> ts = null;


		Abstract_LogicalFormula t1 =null;
		Abstract_LogicalFormula t2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:406:2: ( 'forall' OPEN t1= atom COMMA t2= atom CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:406:5: 'forall' OPEN t1= atom COMMA t2= atom CLOSE
			{
			ArrayList<Abstract_LogicalFormula> tl = new ArrayList<Abstract_LogicalFormula>();
			match(input,77,FOLLOW_77_in_forall_expr2404); 
			match(input,OPEN,FOLLOW_OPEN_in_forall_expr2406); 
			pushFollow(FOLLOW_atom_in_forall_expr2410);
			t1=atom();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_forall_expr2412); 
			pushFollow(FOLLOW_atom_in_forall_expr2416);
			t2=atom();
			state._fsp--;

			Abstract_LogExpr l = new Abstract_LogExpr(t1, Abstract_LogExpr.forall, t2); tl.add(l);
			match(input,CLOSE,FOLLOW_CLOSE_in_forall_expr2420); 
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
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==MINUS) ) {
				alt64=1;
			}
			switch (alt64) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:413:16: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring2443); 
					s += "-";
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:414:2: (n1= NUMBER ( STOP n2= NUMBER )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:414:3: n1= NUMBER ( STOP n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2454); 
			s += n1.getText();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:2: ( STOP n2= NUMBER )?
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==STOP) ) {
				int LA65_1 = input.LA(2);
				if ( (LA65_1==NUMBER) ) {
					alt65=1;
				}
			}
			switch (alt65) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:3: STOP n2= NUMBER
					{
					match(input,STOP,FOLLOW_STOP_in_numberstring2460); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2466); 
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
			pushFollow(FOLLOW_multexpr_in_arithexpr2486);
			a1=multexpr();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:418:28: (i= addoper a2= multexpr )?
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==MINUS||LA66_0==PLUS) ) {
				alt66=1;
			}
			switch (alt66) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:418:29: i= addoper a2= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr2493);
					i=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr2497);
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
			pushFollow(FOLLOW_atom_term_in_multexpr2515);
			a1=atom_term();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:420:28: (i= multoper a2= atom_term )?
			int alt67=2;
			int LA67_0 = input.LA(1);
			if ( (LA67_0==DIV||LA67_0==MULT) ) {
				alt67=1;
			}
			switch (alt67) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:420:29: i= multoper a2= atom_term
					{
					pushFollow(FOLLOW_multoper_in_multexpr2521);
					i=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_term_in_multexpr2525);
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
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==MINUS||LA68_0==NUMBER) ) {
				alt68=1;
			}
			else if ( ((LA68_0 >= UNNAMEDVAR && LA68_0 <= VAR)) ) {
				alt68=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 68, 0, input);
				throw nvae;
			}

			switch (alt68) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:5: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom_term2547);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:66: v= var
					{
					pushFollow(FOLLOW_var_in_atom_term2555);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:426:1: arithexprg returns [Abstract_NumberTerm ae] : a1= multexprg (i= addoper a2= multexpr )? ;
	public final Abstract_NumberTerm arithexprg() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:427:2: (a1= multexprg (i= addoper a2= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:427:4: a1= multexprg (i= addoper a2= multexpr )?
			{
			pushFollow(FOLLOW_multexprg_in_arithexprg2576);
			a1=multexprg();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:427:29: (i= addoper a2= multexpr )?
			int alt69=2;
			int LA69_0 = input.LA(1);
			if ( (LA69_0==MINUS||LA69_0==PLUS) ) {
				alt69=1;
			}
			switch (alt69) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:427:30: i= addoper a2= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexprg2583);
					i=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexprg2587);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:428:1: multexprg returns [Abstract_NumberTerm ae] : a1= atom_termg (i= multoper a2= atom_term )? ;
	public final Abstract_NumberTerm multexprg() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:2: (a1= atom_termg (i= multoper a2= atom_term )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:4: a1= atom_termg (i= multoper a2= atom_term )?
			{
			pushFollow(FOLLOW_atom_termg_in_multexprg2605);
			a1=atom_termg();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:29: (i= multoper a2= atom_term )?
			int alt70=2;
			int LA70_0 = input.LA(1);
			if ( (LA70_0==DIV||LA70_0==MULT) ) {
				alt70=1;
			}
			switch (alt70) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:30: i= multoper a2= atom_term
					{
					pushFollow(FOLLOW_multoper_in_multexprg2611);
					i=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_term_in_multexprg2615);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:431:1: atom_termg returns [Abstract_NumberTerm t] : n= numberstring ;
	public final Abstract_NumberTerm atom_termg() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:432:2: (n= numberstring )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:432:4: n= numberstring
			{
			pushFollow(FOLLOW_numberstring_in_atom_termg2636);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:436:1: addoper returns [int i] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:437:2: ( ( PLUS | MINUS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:437:4: ( PLUS | MINUS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:437:4: ( PLUS | MINUS )
			int alt71=2;
			int LA71_0 = input.LA(1);
			if ( (LA71_0==PLUS) ) {
				alt71=1;
			}
			else if ( (LA71_0==MINUS) ) {
				alt71=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 71, 0, input);
				throw nvae;
			}

			switch (alt71) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:437:5: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper2656); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:437:22: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper2662); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:438:1: multoper returns [int i] : ( MULT | DIV ) ;
	public final int multoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:439:2: ( ( MULT | DIV ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:439:4: ( MULT | DIV )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:439:4: ( MULT | DIV )
			int alt72=2;
			int LA72_0 = input.LA(1);
			if ( (LA72_0==MULT) ) {
				alt72=1;
			}
			else if ( (LA72_0==DIV) ) {
				alt72=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 72, 0, input);
				throw nvae;
			}

			switch (alt72) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:439:5: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper2679); 
					i = 3;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:439:22: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper2685); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:1: eqoper returns [int i] : ( LESS | ( IS | EQUALS ) ) ;
	public final int eqoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:24: ( ( LESS | ( IS | EQUALS ) ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:26: ( LESS | ( IS | EQUALS ) )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:26: ( LESS | ( IS | EQUALS ) )
			int alt73=2;
			int LA73_0 = input.LA(1);
			if ( (LA73_0==LESS) ) {
				alt73=1;
			}
			else if ( (LA73_0==EQUALS||LA73_0==IS) ) {
				alt73=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 73, 0, input);
				throw nvae;
			}

			switch (alt73) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:27: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2701); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:44: ( IS | EQUALS )
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
	public static final BitSet FOLLOW_OPEN_in_atom530 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_atom534 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_atom537 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_atom544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_atom553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROGRAM_in_program568 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_SQOPEN_in_program571 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_ruleEvaluationOrder_in_program575 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_program579 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program585 = new BitSet(new long[]{0x000000000C008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_macroDef_in_program587 = new BitSet(new long[]{0x000000000C008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_programRule_in_program595 = new BitSet(new long[]{0x0000000008008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program601 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_in_ruleEvaluationOrder618 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_EQUALS_in_ruleEvaluationOrder620 = new BitSet(new long[]{0x0018000600000020L});
	public static final BitSet FOLLOW_LINEAR_in_ruleEvaluationOrder624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LINEARALL_in_ruleEvaluationOrder631 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANDOM_in_ruleEvaluationOrder637 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANDOMALL_in_ruleEvaluationOrder643 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADAPTIVE_in_ruleEvaluationOrder650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HASH_in_macroDef664 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_DEFINE_in_macroDef666 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_macroDef670 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_macroDef675 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_macroDef681 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_programRule698 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule702 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_THEN_in_programRule706 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule712 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule716 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_programRule729 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule735 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule739 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule744 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule748 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_programRule760 = new BitSet(new long[]{0x6000000000000000L});
	public static final BitSet FOLLOW_var_in_programRule766 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_programRule768 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule772 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule779 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule784 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule789 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule793 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_programRule802 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule804 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_programRule806 = new BitSet(new long[]{0x6000000000000000L});
	public static final BitSet FOLLOW_var_in_programRule808 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule810 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule813 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule815 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule819 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURLYOPEN_in_nestedRules836 = new BitSet(new long[]{0x0000000008000000L,0x000000000000A000L});
	public static final BitSet FOLLOW_programRule_in_nestedRules843 = new BitSet(new long[]{0x0000000008008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_nestedRules850 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_basicCondition_in_mentalstatecond868 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_mentalstatecond874 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_basicCondition_in_mentalstatecond878 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_mentalatom_in_mentalstate901 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_mentalstate908 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalstate910 = new BitSet(new long[]{0x4000000001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalatom_in_mentalstate912 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_mentalstate914 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_mentalstate919 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mentalstate_in_basicCondition939 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_basicCondition948 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selector_in_mentalatom968 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_mentalatom970 = new BitSet(new long[]{0x0000000001800140L});
	public static final BitSet FOLLOW_mentalOperator_in_mentalatom976 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_atom_parameters_in_mentalatom980 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom_parameters999 = new BitSet(new long[]{0x60001C2000004000L});
	public static final BitSet FOLLOW_atom_in_atom_parameters1008 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_COMMA_in_atom_parameters1014 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_atom_in_atom_parameters1019 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_SEMI_in_atom_parameters1026 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_atom_in_atom_parameters1033 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_atom_parameters_in_atom_parameters1050 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_atom_parameters1058 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEL_in_mentalOperator1079 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_mentalOperator1090 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AGOAL_in_mentalOperator1101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOALA_in_mentalOperator1112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actions1135 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_PLUS_in_actions1142 = new BitSet(new long[]{0x4000001010204000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_action_in_actions1146 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_selector_in_action1166 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_action1168 = new BitSet(new long[]{0x0000000000000000L,0x0000000006414188L});
	public static final BitSet FOLLOW_actionOperator_in_action1174 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_parameters_in_action1178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_74_in_action1190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_action1199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INIT_in_action1208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_action1217 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EVENT_in_action1226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_action1233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_67_in_actionOperator1254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_actionOperator1265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_actionOperator1276 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_actionOperator1287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_89_in_actionOperator1299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_90_in_actionOperator1308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_86_in_actionOperator1317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_actionOperator1328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_selector1340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_selector1349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_selector1358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_88_in_selector1367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_91_in_selector1376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_92_in_selector1385 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_93_in_selector1394 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTIONSPEC_in_actionSpecs1413 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionSpecs1415 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_actionSpec_in_actionSpecs1420 = new BitSet(new long[]{0x000000000000C000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionSpecs1426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_actionSpec1445 = new BitSet(new long[]{0x0000000020410000L});
	public static final BitSet FOLLOW_INTERNAL_in_actionSpec1448 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_EXTERNAL_in_actionSpec1454 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionSpec1460 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_precondition_in_actionSpec1464 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_postcondition_in_actionSpec1468 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionSpec1470 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRE_in_precondition1488 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_precondition1490 = new BitSet(new long[]{0x70000C2000004000L});
	public static final BitSet FOLLOW_TRUE_in_precondition1494 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_precondition1504 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_precondition1509 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POST_in_postcondition1524 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_postcondition1527 = new BitSet(new long[]{0x70000C2000004000L});
	public static final BitSet FOLLOW_TRUE_in_postcondition1531 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_postcondition1541 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_postcondition1550 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_declaration1567 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_parameters_in_declaration1574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_declarationOrCallWithTerms1595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_id1614 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_id1621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_parameters1644 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_parameters1648 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_parameters1654 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_parameters1658 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_parameters1666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_no_bracket_parameters1688 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_no_bracket_parameters1694 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_no_bracket_parameters1698 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_atom_in_no_bracket_literals1729 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_no_bracket_literals1735 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_atom_in_no_bracket_literals1742 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_term_in_goal_list1774 = new BitSet(new long[]{0x0200000000001000L});
	public static final BitSet FOLLOW_COMMA_in_goal_list1781 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_goal_list1785 = new BitSet(new long[]{0x0200000000001000L});
	public static final BitSet FOLLOW_STOP_in_goal_list1792 = new BitSet(new long[]{0x6500082000004002L});
	public static final BitSet FOLLOW_stringterm_in_term2082 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_term2092 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_term2102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_term2111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function_term2129 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_OPEN_in_function_term2136 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_function_term2140 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_function_term2147 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_function_term2151 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_function_term2157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var2177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNNAMEDVAR_in_var2183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_stringLiteral2201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2215 = new BitSet(new long[]{0x4000000000004000L});
	public static final BitSet FOLLOW_word_in_singleQuotedStringLiteral2219 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_stringterm2238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_word2255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word2261 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_listterm2282 = new BitSet(new long[]{0x6580082000004000L});
	public static final BitSet FOLLOW_term_in_listterm2287 = new BitSet(new long[]{0x0080000000001080L});
	public static final BitSet FOLLOW_COMMA_in_listterm2294 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_listterm2298 = new BitSet(new long[]{0x0080000000001080L});
	public static final BitSet FOLLOW_BAR_in_listterm2307 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_VAR_in_listterm2311 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_listterm2323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexprg_in_equation2343 = new BitSet(new long[]{0x0000000140100000L});
	public static final BitSet FOLLOW_eqoper_in_equation2347 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_arithexpr_in_equation2351 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_equation2366 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_EQUALS_in_equation2368 = new BitSet(new long[]{0x6000082000004000L});
	public static final BitSet FOLLOW_arithexpr_in_equation2373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_equation2381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_forall_expr2404 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_OPEN_in_forall_expr2406 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_atom_in_forall_expr2410 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COMMA_in_forall_expr2412 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_atom_in_forall_expr2416 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_forall_expr2420 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring2443 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2454 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_STOP_in_numberstring2460 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2466 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2486 = new BitSet(new long[]{0x0000402000000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr2493 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2515 = new BitSet(new long[]{0x0000010000040002L});
	public static final BitSet FOLLOW_multoper_in_multexpr2521 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2525 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom_term2547 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom_term2555 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexprg_in_arithexprg2576 = new BitSet(new long[]{0x0000402000000002L});
	public static final BitSet FOLLOW_addoper_in_arithexprg2583 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexprg2587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_termg_in_multexprg2605 = new BitSet(new long[]{0x0000010000040002L});
	public static final BitSet FOLLOW_multoper_in_multexprg2611 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_atom_term_in_multexprg2615 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom_termg2636 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper2656 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper2662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper2679 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper2685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2701 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_eqoper2707 = new BitSet(new long[]{0x0000000000000002L});
}
