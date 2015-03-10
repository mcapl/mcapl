// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2015-03-10 17:18:37

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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTIONSPEC", "ADAPTIVE", "ADOPT", 
		"AGOAL", "BAR", "BEL", "BELIEFS", "CLOSE", "COLON", "COMMA", "COMMENT", 
		"CONST", "CURLYCLOSE", "CURLYOPEN", "DEFINE", "DELETE", "DIV", "DO", "DROP", 
		"EQUALS", "EVENT", "EXTERNAL", "GOAL", "GOALA", "GOALS", "HASH", "IF", 
		"INIT", "INSERT", "INTERNAL", "IS", "KNOWLEDGE", "LESS", "LINEAR", "LINEARALL", 
		"LINE_COMMENT", "MAIN", "MINUS", "MODULE", "MODULEFILE", "MULT", "NEWLINE", 
		"NOT", "NUMBER", "OPEN", "ORDER", "PLUS", "POST", "PRE", "PROGRAM", "PROLOGARROW", 
		"RANDOM", "RANDOMALL", "SEND", "SINGLEQUOTE", "SQCLOSE", "SQOPEN", "STOP", 
		"STRING", "THEN", "TRUE", "VAR", "WS", "'#import'", "'->'", "'<-'", "'all'", 
		"'allother'", "'always'", "'exit'", "'exit-module'", "'filter'", "'focus'", 
		"'forall'", "'listall'", "'log'", "'never'", "'new'", "'noaction'", "'nogoals'", 
		"'none'", "'print'", "'select'", "'self'", "'sendonce'", "'some'", "'someother'", 
		"'this'"
	};
	public static final int EOF=-1;
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
	public static final int ACTIONSPEC=4;
	public static final int ADAPTIVE=5;
	public static final int ADOPT=6;
	public static final int AGOAL=7;
	public static final int BAR=8;
	public static final int BEL=9;
	public static final int BELIEFS=10;
	public static final int CLOSE=11;
	public static final int COLON=12;
	public static final int COMMA=13;
	public static final int COMMENT=14;
	public static final int CONST=15;
	public static final int CURLYCLOSE=16;
	public static final int CURLYOPEN=17;
	public static final int DEFINE=18;
	public static final int DELETE=19;
	public static final int DIV=20;
	public static final int DO=21;
	public static final int DROP=22;
	public static final int EQUALS=23;
	public static final int EVENT=24;
	public static final int EXTERNAL=25;
	public static final int GOAL=26;
	public static final int GOALA=27;
	public static final int GOALS=28;
	public static final int HASH=29;
	public static final int IF=30;
	public static final int INIT=31;
	public static final int INSERT=32;
	public static final int INTERNAL=33;
	public static final int IS=34;
	public static final int KNOWLEDGE=35;
	public static final int LESS=36;
	public static final int LINEAR=37;
	public static final int LINEARALL=38;
	public static final int LINE_COMMENT=39;
	public static final int MAIN=40;
	public static final int MINUS=41;
	public static final int MODULE=42;
	public static final int MODULEFILE=43;
	public static final int MULT=44;
	public static final int NEWLINE=45;
	public static final int NOT=46;
	public static final int NUMBER=47;
	public static final int OPEN=48;
	public static final int ORDER=49;
	public static final int PLUS=50;
	public static final int POST=51;
	public static final int PRE=52;
	public static final int PROGRAM=53;
	public static final int PROLOGARROW=54;
	public static final int RANDOM=55;
	public static final int RANDOMALL=56;
	public static final int SEND=57;
	public static final int SINGLEQUOTE=58;
	public static final int SQCLOSE=59;
	public static final int SQOPEN=60;
	public static final int STOP=61;
	public static final int STRING=62;
	public static final int THEN=63;
	public static final int TRUE=64;
	public static final int VAR=65;
	public static final int WS=66;

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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:1: mas returns [Abstract_MAS mas] : MAIN COLON i= id CURLYOPEN ( moduleImport |gm= module )+ CURLYCLOSE ;
	public final Abstract_MAS mas() throws RecognitionException {
		Abstract_MAS mas = null;


		String i =null;
		Abstract_GOALModule gm =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:54:2: ( MAIN COLON i= id CURLYOPEN ( moduleImport |gm= module )+ CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:54:4: MAIN COLON i= id CURLYOPEN ( moduleImport |gm= module )+ CURLYCLOSE
			{
			mas = new Abstract_MAS(); ArrayList<Abstract_GOALAgent> agents = new ArrayList<Abstract_GOALAgent>();
			match(input,MAIN,FOLLOW_MAIN_in_mas74); 
			match(input,COLON,FOLLOW_COLON_in_mas76); 
			pushFollow(FOLLOW_id_in_mas80);
			i=id();
			state._fsp--;

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_mas82); 
			 Abstract_GOALAgent gl = new Abstract_GOALAgent(i); agents.add(gl);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:2: ( moduleImport |gm= module )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==67) ) {
					alt1=1;
				}
				else if ( (LA1_0==EVENT||LA1_0==INIT||LA1_0==MAIN||LA1_0==MODULE) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:3: moduleImport
					{
					pushFollow(FOLLOW_moduleImport_in_mas89);
					moduleImport();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:18: gm= module
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



	// $ANTLR start "moduleImport"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:1: moduleImport : '#import' MODULEFILE '.' ;
	public final void moduleImport() throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:2: ( '#import' MODULEFILE '.' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:4: '#import' MODULEFILE '.'
			{
			match(input,67,FOLLOW_67_in_moduleImport116); 
			match(input,MODULEFILE,FOLLOW_MODULEFILE_in_moduleImport118); 
			match(input,STOP,FOLLOW_STOP_in_moduleImport120); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:1: module returns [Abstract_GOALModule gl] : def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE ;
	public final Abstract_GOALModule module() throws RecognitionException {
		Abstract_GOALModule gl = null;


		int def =0;
		ArrayList<Abstract_ActionSpec> as =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:2: (def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:4: def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE
			{
			pushFollow(FOLLOW_moduleDef_in_module137);
			def=moduleDef();
			state._fsp--;

			gl = new Abstract_GOALModule(def);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:56: ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==SQOPEN) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:57: SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE
					{
					match(input,SQOPEN,FOLLOW_SQOPEN_in_module142); 
					pushFollow(FOLLOW_moduleOption_in_module144);
					moduleOption(gl);
					state._fsp--;

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:81: ( COMMA moduleOption[gl] )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0==COMMA) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:82: COMMA moduleOption[gl]
							{
							match(input,COMMA,FOLLOW_COMMA_in_module148); 
							pushFollow(FOLLOW_moduleOption_in_module150);
							moduleOption(gl);
							state._fsp--;

							}
							break;

						default :
							break loop2;
						}
					}

					match(input,SQCLOSE,FOLLOW_SQCLOSE_in_module155); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_module160); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:12: ( krImport )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==67) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:12: krImport
					{
					pushFollow(FOLLOW_krImport_in_module162);
					krImport();
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:22: ( knowledge[gl] )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==KNOWLEDGE) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:22: knowledge[gl]
					{
					pushFollow(FOLLOW_knowledge_in_module165);
					knowledge(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:38: ( beliefs[gl] )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==BELIEFS) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:38: beliefs[gl]
					{
					pushFollow(FOLLOW_beliefs_in_module170);
					beliefs(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:51: ( goals[gl] )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==GOALS) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:51: goals[gl]
					{
					pushFollow(FOLLOW_goals_in_module174);
					goals(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:62: ( program[gl] )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==PROGRAM) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:62: program[gl]
					{
					pushFollow(FOLLOW_program_in_module178);
					program(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:2: (as= actionSpecs )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==ACTIONSPEC) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:3: as= actionSpecs
					{
					pushFollow(FOLLOW_actionSpecs_in_module187);
					as=actionSpecs();
					state._fsp--;

					gl.addAllCap(as);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_module195); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:1: moduleDef returns [int i] : ( MODULE declaration | INIT MODULE | MAIN MODULE | EVENT MODULE );
	public final int moduleDef() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:2: ( MODULE declaration | INIT MODULE | MAIN MODULE | EVENT MODULE )
			int alt10=4;
			switch ( input.LA(1) ) {
			case MODULE:
				{
				alt10=1;
				}
				break;
			case INIT:
				{
				alt10=2;
				}
				break;
			case MAIN:
				{
				alt10=3;
				}
				break;
			case EVENT:
				{
				alt10=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:4: MODULE declaration
					{
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef210); 
					pushFollow(FOLLOW_declaration_in_moduleDef212);
					declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:4: INIT MODULE
					{
					match(input,INIT,FOLLOW_INIT_in_moduleDef217); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef219); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:4: MAIN MODULE
					{
					match(input,MAIN,FOLLOW_MAIN_in_moduleDef224); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef226); 
					i = Abstract_GOALModule.main;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:77:4: EVENT MODULE
					{
					match(input,EVENT,FOLLOW_EVENT_in_moduleDef233); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef235); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:81:1: moduleOption[Abstract_GOALModule gl] : (key= 'exit' '=' value= ( 'always' | 'never' | 'nogoals' | 'noaction' ) |key= 'focus' '=' value= ( 'none' | 'new' | 'select' | 'filter' ) );
	public final void moduleOption(Abstract_GOALModule gl) throws RecognitionException {
		Token key=null;
		Token value=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:2: (key= 'exit' '=' value= ( 'always' | 'never' | 'nogoals' | 'noaction' ) |key= 'focus' '=' value= ( 'none' | 'new' | 'select' | 'filter' ) )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==73) ) {
				alt12=1;
			}
			else if ( (LA12_0==76) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:4: key= 'exit' '=' value= ( 'always' | 'never' | 'nogoals' | 'noaction' )
					{
					key=(Token)match(input,73,FOLLOW_73_in_moduleOption252); 
					match(input,EQUALS,FOLLOW_EQUALS_in_moduleOption254); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:28: ( 'always' | 'never' | 'nogoals' | 'noaction' )
					int alt11=4;
					switch ( input.LA(1) ) {
					case 72:
						{
						alt11=1;
						}
						break;
					case 80:
						{
						alt11=2;
						}
						break;
					case 83:
						{
						alt11=3;
						}
						break;
					case 82:
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:29: 'always'
							{
							value=(Token)match(input,72,FOLLOW_72_in_moduleOption261); 
							gl.setExitCondition(Abstract_GOALModule.always);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:83:6: 'never'
							{
							value=(Token)match(input,80,FOLLOW_80_in_moduleOption271); 
							gl.setExitCondition(Abstract_GOALModule.never);
							}
							break;
						case 3 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:6: 'nogoals'
							{
							value=(Token)match(input,83,FOLLOW_83_in_moduleOption281); 
							gl.setExitCondition(Abstract_GOALModule.nogoals);
							}
							break;
						case 4 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:7: 'noaction'
							{
							value=(Token)match(input,82,FOLLOW_82_in_moduleOption292); 
							gl.setExitCondition(Abstract_GOALModule.noaction);
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:4: key= 'focus' '=' value= ( 'none' | 'new' | 'select' | 'filter' )
					{
					key=(Token)match(input,76,FOLLOW_76_in_moduleOption306); 
					match(input,EQUALS,FOLLOW_EQUALS_in_moduleOption308); 
					value=input.LT(1);
					if ( input.LA(1)==75||input.LA(1)==81||input.LA(1)==84||input.LA(1)==86 ) {
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:89:1: krImport : '#import' ( stringLiteral | singleQuotedStringLiteral ) '.' ;
	public final void krImport() throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:2: ( '#import' ( stringLiteral | singleQuotedStringLiteral ) '.' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:4: '#import' ( stringLiteral | singleQuotedStringLiteral ) '.'
			{
			match(input,67,FOLLOW_67_in_krImport339); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:14: ( stringLiteral | singleQuotedStringLiteral )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==STRING) ) {
				alt13=1;
			}
			else if ( (LA13_0==SINGLEQUOTE) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:15: stringLiteral
					{
					pushFollow(FOLLOW_stringLiteral_in_krImport342);
					stringLiteral();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:31: singleQuotedStringLiteral
					{
					pushFollow(FOLLOW_singleQuotedStringLiteral_in_krImport346);
					singleQuotedStringLiteral();
					state._fsp--;

					}
					break;

			}

			match(input,STOP,FOLLOW_STOP_in_krImport349); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:93:1: knowledge[Abstract_GOALModule gl] : KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE ;
	public final void knowledge(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:2: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:4: KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE
			{
			match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_knowledge362); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_knowledge364); 
			pushFollow(FOLLOW_krspec_in_knowledge366);
			krspec(gl);
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_knowledge369); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:1: krspec[Abstract_GOALModule gl] : (hd= atom ( STOP | PROLOGARROW body= parameters STOP ) )+ ;
	public final void krspec(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_LogicalFormula hd =null;
		ArrayList<Abstract_Term> body =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:31: ( (hd= atom ( STOP | PROLOGARROW body= parameters STOP ) )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:33: (hd= atom ( STOP | PROLOGARROW body= parameters STOP ) )+
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:33: (hd= atom ( STOP | PROLOGARROW body= parameters STOP ) )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:34: hd= atom ( STOP | PROLOGARROW body= parameters STOP )
					{
					pushFollow(FOLLOW_atom_in_krspec381);
					hd=atom();
					state._fsp--;

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:98:2: ( STOP | PROLOGARROW body= parameters STOP )
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:98:3: STOP
							{
							match(input,STOP,FOLLOW_STOP_in_krspec385); 
							gl.addFact((Abstract_Predicate) hd);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:2: PROLOGARROW body= parameters STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_krspec392); 
							pushFollow(FOLLOW_parameters_in_krspec396);
							body=parameters();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_krspec398); 
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



	// $ANTLR start "beliefs"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:101:1: beliefs[Abstract_GOALModule gl] : BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE ;
	public final void beliefs(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:2: ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:4: BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE
			{
			match(input,BELIEFS,FOLLOW_BELIEFS_in_beliefs414); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_beliefs416); 
			pushFollow(FOLLOW_brspec_in_beliefs418);
			brspec(gl);
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_beliefs421); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:1: brspec[Abstract_GOALModule gl] : (hd= atom ( STOP | PROLOGARROW body= parameters STOP ) )+ ;
	public final void brspec(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_LogicalFormula hd =null;
		ArrayList<Abstract_Term> body =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:31: ( (hd= atom ( STOP | PROLOGARROW body= parameters STOP ) )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:33: (hd= atom ( STOP | PROLOGARROW body= parameters STOP ) )+
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:33: (hd= atom ( STOP | PROLOGARROW body= parameters STOP ) )+
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:34: hd= atom ( STOP | PROLOGARROW body= parameters STOP )
					{
					pushFollow(FOLLOW_atom_in_brspec433);
					hd=atom();
					state._fsp--;

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:106:2: ( STOP | PROLOGARROW body= parameters STOP )
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
							match(input,STOP,FOLLOW_STOP_in_brspec437); 
							gl.addBel((Abstract_Predicate) hd);
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:2: PROLOGARROW body= parameters STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_brspec444); 
							pushFollow(FOLLOW_parameters_in_brspec448);
							body=parameters();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_brspec450); 
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



	// $ANTLR start "goals"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:1: goals[Abstract_GOALModule gl] : GOALS CURLYOPEN le= goal_list CURLYCLOSE ;
	public final void goals(Abstract_GOALModule gl) throws RecognitionException {
		ArrayList<Abstract_Term> le =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:2: ( GOALS CURLYOPEN le= goal_list CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:4: GOALS CURLYOPEN le= goal_list CURLYCLOSE
			{
			match(input,GOALS,FOLLOW_GOALS_in_goals467); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_goals469); 
			pushFollow(FOLLOW_goal_list_in_goals473);
			le=goal_list();
			state._fsp--;

			gl.addGoal(le);
			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_goals477); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:1: atom returns [Abstract_LogicalFormula l] : (p= declarationOrCallWithTerms |e= equation );
	public final Abstract_LogicalFormula atom() throws RecognitionException {
		Abstract_LogicalFormula l = null;


		Abstract_Predicate p =null;
		Abstract_Equation e =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:114:2: (p= declarationOrCallWithTerms |e= equation )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==CONST) ) {
				alt18=1;
			}
			else if ( (LA18_0==MINUS||LA18_0==NUMBER||LA18_0==VAR) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:114:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_atom493);
					p=declarationOrCallWithTerms();
					state._fsp--;

					l =p;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:115:4: e= equation
					{
					pushFollow(FOLLOW_equation_in_atom502);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:1: program[Abstract_GOALModule gl] : PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* ( programRule[gl] )* CURLYCLOSE ;
	public final void program(Abstract_GOALModule gl) throws RecognitionException {
		int i =0;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:2: ( PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* ( programRule[gl] )* CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:4: PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* ( programRule[gl] )* CURLYCLOSE
			{
			match(input,PROGRAM,FOLLOW_PROGRAM_in_program517); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:12: ( SQOPEN i= ruleEvaluationOrder SQCLOSE )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==SQOPEN) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:13: SQOPEN i= ruleEvaluationOrder SQCLOSE
					{
					match(input,SQOPEN,FOLLOW_SQOPEN_in_program520); 
					pushFollow(FOLLOW_ruleEvaluationOrder_in_program524);
					i=ruleEvaluationOrder();
					state._fsp--;

					gl.setOptionOrder(i);
					match(input,SQCLOSE,FOLLOW_SQCLOSE_in_program528); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program534); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:12: ( macroDef )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==HASH) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:12: macroDef
					{
					pushFollow(FOLLOW_macroDef_in_program536);
					macroDef();
					state._fsp--;

					}
					break;

				default :
					break loop20;
				}
			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:22: ( programRule[gl] )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==IF||(LA21_0 >= 77 && LA21_0 <= 78)) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:22: programRule[gl]
					{
					pushFollow(FOLLOW_programRule_in_program539);
					programRule(gl);
					state._fsp--;

					}
					break;

				default :
					break loop21;
				}
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program543); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:1: ruleEvaluationOrder returns [int i] : SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE ) SQCLOSE ;
	public final int ruleEvaluationOrder() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:2: ( SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE ) SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:4: SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE ) SQCLOSE
			{
			match(input,SQOPEN,FOLLOW_SQOPEN_in_ruleEvaluationOrder560); 
			match(input,ORDER,FOLLOW_ORDER_in_ruleEvaluationOrder562); 
			match(input,EQUALS,FOLLOW_EQUALS_in_ruleEvaluationOrder564); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:24: ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE )
			int alt22=5;
			switch ( input.LA(1) ) {
			case LINEAR:
				{
				alt22=1;
				}
				break;
			case LINEARALL:
				{
				alt22=2;
				}
				break;
			case RANDOM:
				{
				alt22=3;
				}
				break;
			case RANDOMALL:
				{
				alt22=4;
				}
				break;
			case ADAPTIVE:
				{
				alt22=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}
			switch (alt22) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:26: LINEAR
					{
					match(input,LINEAR,FOLLOW_LINEAR_in_ruleEvaluationOrder568); 
					i =Abstract_GOALModule.linear;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:2: LINEARALL
					{
					match(input,LINEARALL,FOLLOW_LINEARALL_in_ruleEvaluationOrder575); 
					i =Abstract_GOALModule.linearall;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:2: RANDOM
					{
					match(input,RANDOM,FOLLOW_RANDOM_in_ruleEvaluationOrder581); 
					i =Abstract_GOALModule.random;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:2: RANDOMALL
					{
					match(input,RANDOMALL,FOLLOW_RANDOMALL_in_ruleEvaluationOrder587); 
					i =Abstract_GOALModule.randomall;
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:2: ADAPTIVE
					{
					match(input,ADAPTIVE,FOLLOW_ADAPTIVE_in_ruleEvaluationOrder594); 
					i = Abstract_GOALModule.adaptive;
					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_ruleEvaluationOrder600); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:1: macroDef : HASH DEFINE p= declarationOrCallWithTerms msc= mentalstate STOP ;
	public final void macroDef() throws RecognitionException {
		Abstract_Predicate p =null;
		Abstract_MentalState msc =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:134:2: ( HASH DEFINE p= declarationOrCallWithTerms msc= mentalstate STOP )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:134:4: HASH DEFINE p= declarationOrCallWithTerms msc= mentalstate STOP
			{
			match(input,HASH,FOLLOW_HASH_in_macroDef609); 
			match(input,DEFINE,FOLLOW_DEFINE_in_macroDef611); 
			pushFollow(FOLLOW_declarationOrCallWithTerms_in_macroDef615);
			p=declarationOrCallWithTerms();
			state._fsp--;

			pushFollow(FOLLOW_mentalstate_in_macroDef620);
			msc=mentalstate();
			state._fsp--;

			PredicateIndicator pi = new PredicateIndicator(p.getFunctor(), p.getTermSize()); macros.put(pi, msc);
				macro_subs.put(pi, p);
			match(input,STOP,FOLLOW_STOP_in_macroDef626); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:140:1: programRule[Abstract_GOALModule gl] : ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] ) | 'forall' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] ) ) ;
	public final void programRule(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_MentalState lf =null;
		ArrayList<Abstract_Deed> dl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:141:2: ( ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] ) | 'forall' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] ) ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:141:3: ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] ) | 'forall' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] ) )
			{
			Abstract_ActionRule rule = new Abstract_ActionRule();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:2: ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] ) | 'forall' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] ) )
			int alt27=4;
			switch ( input.LA(1) ) {
			case IF:
				{
				alt27=1;
				}
				break;
			case 77:
				{
				alt27=2;
				}
				break;
			case 78:
				{
				int LA27_3 = input.LA(2);
				if ( (LA27_3==VAR) ) {
					int LA27_4 = input.LA(3);
					if ( (LA27_4==69) ) {
						alt27=3;
					}
					else if ( (LA27_4==STOP) ) {
						alt27=4;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 27, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA27_3==AGOAL||LA27_3==BEL||LA27_3==CONST||(LA27_3 >= GOAL && LA27_3 <= GOALA)||LA27_3==NOT||LA27_3==TRUE||(LA27_3 >= 70 && LA27_3 <= 71)||LA27_3==87||(LA27_3 >= 89 && LA27_3 <= 91)) ) {
					alt27=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 27, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}
			switch (alt27) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:3: IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] )
					{
					match(input,IF,FOLLOW_IF_in_programRule640); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule644);
					lf=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(lf);
					match(input,THEN,FOLLOW_THEN_in_programRule648); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:61: (dl= actions STOP | nestedRules[gl] )
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==ADOPT||LA23_0==CONST||LA23_0==DELETE||LA23_0==DROP||LA23_0==EVENT||(LA23_0 >= INIT && LA23_0 <= INSERT)||LA23_0==MAIN||LA23_0==SEND||LA23_0==VAR||(LA23_0 >= 70 && LA23_0 <= 71)||LA23_0==74||LA23_0==79||LA23_0==85||(LA23_0 >= 87 && LA23_0 <= 91)) ) {
						alt23=1;
					}
					else if ( (LA23_0==CURLYOPEN) ) {
						alt23=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 23, 0, input);
						throw nvae;
					}

					switch (alt23) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:63: dl= actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule654);
							dl=actions();
							state._fsp--;

							rule.setBody(dl);
							match(input,STOP,FOLLOW_STOP_in_programRule658); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:101: nestedRules[gl]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule662);
							nestedRules(gl);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:4: 'forall' mentalstatecond DO ( actions STOP | nestedRules[gl] )
					{
					match(input,77,FOLLOW_77_in_programRule671); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule673);
					mentalstatecond();
					state._fsp--;

					match(input,DO,FOLLOW_DO_in_programRule675); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:32: ( actions STOP | nestedRules[gl] )
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==ADOPT||LA24_0==CONST||LA24_0==DELETE||LA24_0==DROP||LA24_0==EVENT||(LA24_0 >= INIT && LA24_0 <= INSERT)||LA24_0==MAIN||LA24_0==SEND||LA24_0==VAR||(LA24_0 >= 70 && LA24_0 <= 71)||LA24_0==74||LA24_0==79||LA24_0==85||(LA24_0 >= 87 && LA24_0 <= 91)) ) {
						alt24=1;
					}
					else if ( (LA24_0==CURLYOPEN) ) {
						alt24=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 24, 0, input);
						throw nvae;
					}

					switch (alt24) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:33: actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule678);
							actions();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_programRule680); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:48: nestedRules[gl]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule684);
							nestedRules(gl);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:4: 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] )
					{
					match(input,78,FOLLOW_78_in_programRule692); 
					match(input,VAR,FOLLOW_VAR_in_programRule694); 
					match(input,69,FOLLOW_69_in_programRule696); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule698);
					mentalstatecond();
					state._fsp--;

					match(input,DO,FOLLOW_DO_in_programRule700); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:42: ( actions STOP | nestedRules[gl] )
					int alt25=2;
					int LA25_0 = input.LA(1);
					if ( (LA25_0==ADOPT||LA25_0==CONST||LA25_0==DELETE||LA25_0==DROP||LA25_0==EVENT||(LA25_0 >= INIT && LA25_0 <= INSERT)||LA25_0==MAIN||LA25_0==SEND||LA25_0==VAR||(LA25_0 >= 70 && LA25_0 <= 71)||LA25_0==74||LA25_0==79||LA25_0==85||(LA25_0 >= 87 && LA25_0 <= 91)) ) {
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:43: actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule703);
							actions();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_programRule705); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:58: nestedRules[gl]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule709);
							nestedRules(gl);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:145:4: 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] )
					{
					match(input,78,FOLLOW_78_in_programRule718); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule720);
					mentalstatecond();
					state._fsp--;

					match(input,68,FOLLOW_68_in_programRule722); 
					match(input,VAR,FOLLOW_VAR_in_programRule724); 
					match(input,DO,FOLLOW_DO_in_programRule726); 
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:145:42: ( actions STOP | nestedRules[gl] )
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==ADOPT||LA26_0==CONST||LA26_0==DELETE||LA26_0==DROP||LA26_0==EVENT||(LA26_0 >= INIT && LA26_0 <= INSERT)||LA26_0==MAIN||LA26_0==SEND||LA26_0==VAR||(LA26_0 >= 70 && LA26_0 <= 71)||LA26_0==74||LA26_0==79||LA26_0==85||(LA26_0 >= 87 && LA26_0 <= 91)) ) {
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
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:145:43: actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule729);
							actions();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_programRule731); 
							}
							break;
						case 2 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:145:58: nestedRules[gl]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule735);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:1: nestedRules[Abstract_GOALModule gl] : CURLYOPEN ( programRule[gl] )+ CURLYCLOSE ;
	public final void nestedRules(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:2: ( CURLYOPEN ( programRule[gl] )+ CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:4: CURLYOPEN ( programRule[gl] )+ CURLYCLOSE
			{
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_nestedRules753); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:14: ( programRule[gl] )+
			int cnt28=0;
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==IF||(LA28_0 >= 77 && LA28_0 <= 78)) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:14: programRule[gl]
					{
					pushFollow(FOLLOW_programRule_in_nestedRules755);
					programRule(gl);
					state._fsp--;

					}
					break;

				default :
					if ( cnt28 >= 1 ) break loop28;
					EarlyExitException eee = new EarlyExitException(28, input);
					throw eee;
				}
				cnt28++;
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_nestedRules759); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:1: mentalstatecond returns [Abstract_MentalState lf] : ma= basicCondition ( COMMA ms2= basicCondition )* ;
	public final Abstract_MentalState mentalstatecond() throws RecognitionException {
		Abstract_MentalState lf = null;


		Abstract_MentalState ma =null;
		Abstract_MentalState ms2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:2: (ma= basicCondition ( COMMA ms2= basicCondition )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:4: ma= basicCondition ( COMMA ms2= basicCondition )*
			{
			pushFollow(FOLLOW_basicCondition_in_mentalstatecond777);
			ma=basicCondition();
			state._fsp--;

			Abstract_MentalState ms =  ma;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:155:2: ( COMMA ms2= basicCondition )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==COMMA) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:155:3: COMMA ms2= basicCondition
					{
					match(input,COMMA,FOLLOW_COMMA_in_mentalstatecond783); 
					pushFollow(FOLLOW_basicCondition_in_mentalstatecond787);
					ms2=basicCondition();
					state._fsp--;

					ms = new Abstract_MentalState(ms, Abstract_Guard.and, ms2);
					}
					break;

				default :
					break loop29;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:158:1: mentalstate returns [Abstract_MentalState ms] : (ma= mentalatom | NOT OPEN mentalatom CLOSE | TRUE );
	public final Abstract_MentalState mentalstate() throws RecognitionException {
		Abstract_MentalState ms = null;


		Abstract_MentalAtom ma =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:159:2: (ma= mentalatom | NOT OPEN mentalatom CLOSE | TRUE )
			int alt30=3;
			switch ( input.LA(1) ) {
			case AGOAL:
			case BEL:
			case CONST:
			case GOAL:
			case GOALA:
			case VAR:
			case 70:
			case 71:
			case 87:
			case 89:
			case 90:
			case 91:
				{
				alt30=1;
				}
				break;
			case NOT:
				{
				alt30=2;
				}
				break;
			case TRUE:
				{
				alt30=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}
			switch (alt30) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:159:4: ma= mentalatom
					{
					pushFollow(FOLLOW_mentalatom_in_mentalstate810);
					ma=mentalatom();
					state._fsp--;

					ms = new Abstract_MentalState(ma);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:4: NOT OPEN mentalatom CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_mentalstate817); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalstate819); 
					pushFollow(FOLLOW_mentalatom_in_mentalstate821);
					mentalatom();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_mentalstate823); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:161:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_mentalstate828); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:1: basicCondition returns [Abstract_MentalState ms] : (ms1= mentalstate |p= declarationOrCallWithTerms );
	public final Abstract_MentalState basicCondition() throws RecognitionException {
		Abstract_MentalState ms = null;


		Abstract_MentalState ms1 =null;
		Abstract_Predicate p =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:2: (ms1= mentalstate |p= declarationOrCallWithTerms )
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==CONST) ) {
				int LA31_1 = input.LA(2);
				if ( (LA31_1==STOP) ) {
					alt31=1;
				}
				else if ( (LA31_1==COMMA||LA31_1==DO||LA31_1==OPEN||LA31_1==THEN||LA31_1==68) ) {
					alt31=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 31, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA31_0==AGOAL||LA31_0==BEL||(LA31_0 >= GOAL && LA31_0 <= GOALA)||LA31_0==NOT||(LA31_0 >= TRUE && LA31_0 <= VAR)||(LA31_0 >= 70 && LA31_0 <= 71)||LA31_0==87||(LA31_0 >= 89 && LA31_0 <= 91)) ) {
				alt31=1;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:4: ms1= mentalstate
					{
					pushFollow(FOLLOW_mentalstate_in_basicCondition848);
					ms1=mentalstate();
					state._fsp--;

					ms = ms1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:166:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_basicCondition857);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:1: mentalatom returns [Abstract_MentalAtom lf] : ( selector STOP )? b= mentalOperator tl= atom_parameters ;
	public final Abstract_MentalAtom mentalatom() throws RecognitionException {
		Abstract_MentalAtom lf = null;


		byte b =0;
		ArrayList<Abstract_LogicalFormula> tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:2: ( ( selector STOP )? b= mentalOperator tl= atom_parameters )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:4: ( selector STOP )? b= mentalOperator tl= atom_parameters
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:4: ( selector STOP )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==CONST||LA32_0==VAR||(LA32_0 >= 70 && LA32_0 <= 71)||LA32_0==87||(LA32_0 >= 89 && LA32_0 <= 91)) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:5: selector STOP
					{
					pushFollow(FOLLOW_selector_in_mentalatom875);
					selector();
					state._fsp--;

					match(input,STOP,FOLLOW_STOP_in_mentalatom877); 
					}
					break;

			}

			pushFollow(FOLLOW_mentalOperator_in_mentalatom883);
			b=mentalOperator();
			state._fsp--;

			pushFollow(FOLLOW_atom_parameters_in_mentalatom887);
			tl=atom_parameters();
			state._fsp--;

			lf = new Abstract_MentalAtom(tl, b);
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



	// $ANTLR start "mentalOperator"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:178:1: mentalOperator returns [byte b] : (op= BEL |op= GOAL |op= AGOAL |op= GOALA );
	public final byte mentalOperator() throws RecognitionException {
		byte b = 0;


		Token op=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:179:2: (op= BEL |op= GOAL |op= AGOAL |op= GOALA )
			int alt33=4;
			switch ( input.LA(1) ) {
			case BEL:
				{
				alt33=1;
				}
				break;
			case GOAL:
				{
				alt33=2;
				}
				break;
			case AGOAL:
				{
				alt33=3;
				}
				break;
			case GOALA:
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
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:179:4: op= BEL
					{
					op=(Token)match(input,BEL,FOLLOW_BEL_in_mentalOperator909); 
					b = Abstract_BaseAILStructure.AILBel;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:180:4: op= GOAL
					{
					op=(Token)match(input,GOAL,FOLLOW_GOAL_in_mentalOperator920); 
					b = Abstract_BaseAILStructure.AILGoal;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:181:4: op= AGOAL
					{
					op=(Token)match(input,AGOAL,FOLLOW_AGOAL_in_mentalOperator931); 
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:182:4: op= GOALA
					{
					op=(Token)match(input,GOALA,FOLLOW_GOALA_in_mentalOperator940); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:185:1: actions returns [ArrayList<Abstract_Deed> dl] :a= action ( PLUS a1= action )* ;
	public final ArrayList<Abstract_Deed> actions() throws RecognitionException {
		ArrayList<Abstract_Deed> dl = null;


		Abstract_Deed a =null;
		Abstract_Deed a1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:186:2: (a= action ( PLUS a1= action )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:186:4: a= action ( PLUS a1= action )*
			{
			dl = new ArrayList<Abstract_Deed>();
			pushFollow(FOLLOW_action_in_actions961);
			a=action();
			state._fsp--;

			dl.add(a);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:2: ( PLUS a1= action )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==PLUS) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:3: PLUS a1= action
					{
					match(input,PLUS,FOLLOW_PLUS_in_actions968); 
					pushFollow(FOLLOW_action_in_actions972);
					a1=action();
					state._fsp--;

					dl.add(a1);
					}
					break;

				default :
					break loop34;
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:191:1: action returns [Abstract_Deed d] : ( ( selector STOP )? d1= actionOperator tl= parameters |op= 'exit-module' |op= 'log' |op= INIT |op= MAIN |op= EVENT |p= declarationOrCallWithTerms );
	public final Abstract_Deed action() throws RecognitionException {
		Abstract_Deed d = null;


		Token op=null;
		Abstract_Deed d1 =null;
		ArrayList<Abstract_Term> tl =null;
		Abstract_Predicate p =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:2: ( ( selector STOP )? d1= actionOperator tl= parameters |op= 'exit-module' |op= 'log' |op= INIT |op= MAIN |op= EVENT |p= declarationOrCallWithTerms )
			int alt36=7;
			switch ( input.LA(1) ) {
			case CONST:
				{
				int LA36_1 = input.LA(2);
				if ( (LA36_1==STOP) ) {
					int LA36_8 = input.LA(3);
					if ( (LA36_8==ADOPT||LA36_8==DELETE||LA36_8==DROP||LA36_8==INSERT||LA36_8==SEND||LA36_8==79||LA36_8==85||LA36_8==88) ) {
						alt36=1;
					}
					else if ( (LA36_8==CURLYCLOSE||LA36_8==IF||(LA36_8 >= 77 && LA36_8 <= 78)) ) {
						alt36=7;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 36, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA36_1==OPEN||LA36_1==PLUS) ) {
					alt36=7;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 36, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case ADOPT:
			case DELETE:
			case DROP:
			case INSERT:
			case SEND:
			case VAR:
			case 70:
			case 71:
			case 85:
			case 87:
			case 88:
			case 89:
			case 90:
			case 91:
				{
				alt36=1;
				}
				break;
			case 79:
				{
				int LA36_3 = input.LA(2);
				if ( (LA36_3==OPEN) ) {
					alt36=1;
				}
				else if ( (LA36_3==PLUS||LA36_3==STOP) ) {
					alt36=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 36, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 74:
				{
				alt36=2;
				}
				break;
			case INIT:
				{
				alt36=4;
				}
				break;
			case MAIN:
				{
				alt36=5;
				}
				break;
			case EVENT:
				{
				alt36=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}
			switch (alt36) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:4: ( selector STOP )? d1= actionOperator tl= parameters
					{
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:4: ( selector STOP )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==CONST||LA35_0==VAR||(LA35_0 >= 70 && LA35_0 <= 71)||LA35_0==87||(LA35_0 >= 89 && LA35_0 <= 91)) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:5: selector STOP
							{
							pushFollow(FOLLOW_selector_in_action992);
							selector();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_action994); 
							}
							break;

					}

					pushFollow(FOLLOW_actionOperator_in_action1000);
					d1=actionOperator();
					state._fsp--;

					pushFollow(FOLLOW_parameters_in_action1004);
					tl=parameters();
					state._fsp--;

					d1.addParams(tl); d =d1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:194:4: op= 'exit-module'
					{
					op=(Token)match(input,74,FOLLOW_74_in_action1016); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:195:4: op= 'log'
					{
					op=(Token)match(input,79,FOLLOW_79_in_action1025); 
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:196:4: op= INIT
					{
					op=(Token)match(input,INIT,FOLLOW_INIT_in_action1034); 
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:197:4: op= MAIN
					{
					op=(Token)match(input,MAIN,FOLLOW_MAIN_in_action1043); 
					}
					break;
				case 6 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:198:4: op= EVENT
					{
					op=(Token)match(input,EVENT,FOLLOW_EVENT_in_action1052); 
					}
					break;
				case 7 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_action1059);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:202:1: actionOperator returns [Abstract_Deed d] : (op= 'adopt' |op= 'drop' |op= 'insert' |op= 'delete' |op= 'send' |op= 'sendonce' |op= 'print' |op= 'log' );
	public final Abstract_Deed actionOperator() throws RecognitionException {
		Abstract_Deed d = null;


		Token op=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:2: (op= 'adopt' |op= 'drop' |op= 'insert' |op= 'delete' |op= 'send' |op= 'sendonce' |op= 'print' |op= 'log' )
			int alt37=8;
			switch ( input.LA(1) ) {
			case ADOPT:
				{
				alt37=1;
				}
				break;
			case DROP:
				{
				alt37=2;
				}
				break;
			case INSERT:
				{
				alt37=3;
				}
				break;
			case DELETE:
				{
				alt37=4;
				}
				break;
			case SEND:
				{
				alt37=5;
				}
				break;
			case 88:
				{
				alt37=6;
				}
				break;
			case 85:
				{
				alt37=7;
				}
				break;
			case 79:
				{
				alt37=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 37, 0, input);
				throw nvae;
			}
			switch (alt37) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:4: op= 'adopt'
					{
					op=(Token)match(input,ADOPT,FOLLOW_ADOPT_in_actionOperator1080); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:204:4: op= 'drop'
					{
					op=(Token)match(input,DROP,FOLLOW_DROP_in_actionOperator1089); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:205:4: op= 'insert'
					{
					op=(Token)match(input,INSERT,FOLLOW_INSERT_in_actionOperator1098); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, Abstract_BaseAILStructure.AILBel);
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:4: op= 'delete'
					{
					op=(Token)match(input,DELETE,FOLLOW_DELETE_in_actionOperator1109); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILDeletion, Abstract_BaseAILStructure.AILBel);
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:4: op= 'send'
					{
					op=(Token)match(input,SEND,FOLLOW_SEND_in_actionOperator1121); 
					}
					break;
				case 6 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:208:4: op= 'sendonce'
					{
					op=(Token)match(input,88,FOLLOW_88_in_actionOperator1130); 
					}
					break;
				case 7 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:209:4: op= 'print'
					{
					op=(Token)match(input,85,FOLLOW_85_in_actionOperator1139); 
					d = new Abstract_Deed(new Abstract_PrintAction());
					}
					break;
				case 8 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:210:4: op= 'log'
					{
					op=(Token)match(input,79,FOLLOW_79_in_actionOperator1150); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:214:1: selector : ( word |op= 'all' |op= 'allother' |op= 'self' |op= 'some' |op= 'someother' |op= 'this' );
	public final void selector() throws RecognitionException {
		Token op=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:2: ( word |op= 'all' |op= 'allother' |op= 'self' |op= 'some' |op= 'someother' |op= 'this' )
			int alt38=7;
			switch ( input.LA(1) ) {
			case CONST:
			case VAR:
				{
				alt38=1;
				}
				break;
			case 70:
				{
				alt38=2;
				}
				break;
			case 71:
				{
				alt38=3;
				}
				break;
			case 87:
				{
				alt38=4;
				}
				break;
			case 89:
				{
				alt38=5;
				}
				break;
			case 90:
				{
				alt38=6;
				}
				break;
			case 91:
				{
				alt38=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}
			switch (alt38) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:4: word
					{
					pushFollow(FOLLOW_word_in_selector1162);
					word();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:216:4: op= 'all'
					{
					op=(Token)match(input,70,FOLLOW_70_in_selector1171); 
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:217:4: op= 'allother'
					{
					op=(Token)match(input,71,FOLLOW_71_in_selector1180); 
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:218:4: op= 'self'
					{
					op=(Token)match(input,87,FOLLOW_87_in_selector1189); 
					}
					break;
				case 5 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:4: op= 'some'
					{
					op=(Token)match(input,89,FOLLOW_89_in_selector1198); 
					}
					break;
				case 6 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:4: op= 'someother'
					{
					op=(Token)match(input,90,FOLLOW_90_in_selector1207); 
					}
					break;
				case 7 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:221:4: op= 'this'
					{
					op=(Token)match(input,91,FOLLOW_91_in_selector1216); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:224:1: actionSpecs returns [ArrayList<Abstract_ActionSpec> as] : ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE ;
	public final ArrayList<Abstract_ActionSpec> actionSpecs() throws RecognitionException {
		ArrayList<Abstract_ActionSpec> as = null;


		Abstract_ActionSpec a =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:225:2: ( ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:225:4: ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE
			{
			as = new ArrayList<Abstract_ActionSpec>();
			match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_actionSpecs1235); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionSpecs1237); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:226:23: (a= actionSpec )+
			int cnt39=0;
			loop39:
			while (true) {
				int alt39=2;
				int LA39_0 = input.LA(1);
				if ( (LA39_0==CONST) ) {
					alt39=1;
				}

				switch (alt39) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:226:24: a= actionSpec
					{
					pushFollow(FOLLOW_actionSpec_in_actionSpecs1242);
					a=actionSpec();
					state._fsp--;

					as.add(a);
					}
					break;

				default :
					if ( cnt39 >= 1 ) break loop39;
					EarlyExitException eee = new EarlyExitException(39, input);
					throw eee;
				}
				cnt39++;
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionSpecs1248); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:229:1: actionSpec returns [Abstract_ActionSpec as] : cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE ;
	public final Abstract_ActionSpec actionSpec() throws RecognitionException {
		Abstract_ActionSpec as = null;


		Abstract_Predicate cap =null;
		Abstract_LogicalFormula pre =null;
		Abstract_LogicalFormula post =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:230:2: (cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:230:4: cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE
			{
			pushFollow(FOLLOW_declarationOrCallWithTerms_in_actionSpec1265);
			cap=declarationOrCallWithTerms();
			state._fsp--;

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:230:35: ( INTERNAL | EXTERNAL )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==EXTERNAL||LA40_0==INTERNAL) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
					{
					if ( input.LA(1)==EXTERNAL||input.LA(1)==INTERNAL ) {
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

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionSpec1278); 
			pushFollow(FOLLOW_precondition_in_actionSpec1282);
			pre=precondition();
			state._fsp--;

			pushFollow(FOLLOW_postcondition_in_actionSpec1286);
			post=postcondition();
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionSpec1288); 
			as = new Abstract_ActionSpec(cap, pre, post);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:235:1: precondition returns [Abstract_LogicalFormula f] : PRE tl= parameters ;
	public final Abstract_LogicalFormula precondition() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		ArrayList<Abstract_Term> tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:236:2: ( PRE tl= parameters )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:236:4: PRE tl= parameters
			{
			match(input,PRE,FOLLOW_PRE_in_precondition1306); 
			pushFollow(FOLLOW_parameters_in_precondition1310);
			tl=parameters();
			state._fsp--;

			f = new Abstract_LogExpr(tl);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:239:1: postcondition returns [Abstract_LogicalFormula f] : POST tl= parameters ;
	public final Abstract_LogicalFormula postcondition() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		ArrayList<Abstract_Term> tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:240:2: ( POST tl= parameters )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:240:4: POST tl= parameters
			{
			match(input,POST,FOLLOW_POST_in_postcondition1327); 
			pushFollow(FOLLOW_parameters_in_postcondition1331);
			tl=parameters();
			state._fsp--;


					f = new Abstract_LogExpr(tl);
				
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:245:1: declaration returns [Abstract_Predicate p] : f= id (tl= parameters )? ;
	public final Abstract_Predicate declaration() throws RecognitionException {
		Abstract_Predicate p = null;


		String f =null;
		ArrayList<Abstract_Term> tl =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:246:2: (f= id (tl= parameters )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:246:4: f= id (tl= parameters )?
			{
			pushFollow(FOLLOW_id_in_declaration1350);
			f=id();
			state._fsp--;

			p= new Abstract_Predicate(f);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:246:41: (tl= parameters )?
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==OPEN) ) {
				alt41=1;
			}
			switch (alt41) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:246:42: tl= parameters
					{
					pushFollow(FOLLOW_parameters_in_declaration1357);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:249:1: declarationOrCallWithTerms returns [Abstract_Predicate p] : f= function_term ;
	public final Abstract_Predicate declarationOrCallWithTerms() throws RecognitionException {
		Abstract_Predicate p = null;


		Abstract_Term f =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:250:2: (f= function_term )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:250:4: f= function_term
			{
			pushFollow(FOLLOW_function_term_in_declarationOrCallWithTerms1378);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:253:1: id returns [String s] : ( CONST | VAR ) ;
	public final String id() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:254:2: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:254:4: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:254:4: ( CONST | VAR )
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==CONST) ) {
				alt42=1;
			}
			else if ( (LA42_0==VAR) ) {
				alt42=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 42, 0, input);
				throw nvae;
			}

			switch (alt42) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:254:5: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_id1397); 
					s = CONST1.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:255:4: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_id1404); 
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



	// $ANTLR start "atom_parameters"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:259:1: atom_parameters returns [ArrayList<Abstract_LogicalFormula>ts] : OPEN t= atom ( COMMA t1= atom )* CLOSE ;
	public final ArrayList<Abstract_LogicalFormula> atom_parameters() throws RecognitionException {
		ArrayList<Abstract_LogicalFormula> ts = null;


		Abstract_LogicalFormula t =null;
		Abstract_LogicalFormula t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:260:2: ( OPEN t= atom ( COMMA t1= atom )* CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:260:4: OPEN t= atom ( COMMA t1= atom )* CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_atom_parameters1427); 
			pushFollow(FOLLOW_atom_in_atom_parameters1431);
			t=atom();
			state._fsp--;

			ArrayList<Abstract_LogicalFormula> tl = new ArrayList<Abstract_LogicalFormula>(); tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:261:2: ( COMMA t1= atom )*
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( (LA43_0==COMMA) ) {
					alt43=1;
				}

				switch (alt43) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:261:3: COMMA t1= atom
					{
					match(input,COMMA,FOLLOW_COMMA_in_atom_parameters1437); 
					pushFollow(FOLLOW_atom_in_atom_parameters1441);
					t1=atom();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop43;
				}
			}

			match(input,CLOSE,FOLLOW_CLOSE_in_atom_parameters1449); 
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
	// $ANTLR end "atom_parameters"



	// $ANTLR start "parameters"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:265:1: parameters returns [ArrayList<Abstract_Term>ts] : OPEN t= term ( COMMA t1= term )* CLOSE ;
	public final ArrayList<Abstract_Term> parameters() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:266:2: ( OPEN t= term ( COMMA t1= term )* CLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:266:4: OPEN t= term ( COMMA t1= term )* CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_parameters1467); 
			pushFollow(FOLLOW_term_in_parameters1471);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:267:2: ( COMMA t1= term )*
			loop44:
			while (true) {
				int alt44=2;
				int LA44_0 = input.LA(1);
				if ( (LA44_0==COMMA) ) {
					alt44=1;
				}

				switch (alt44) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:267:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_parameters1477); 
					pushFollow(FOLLOW_term_in_parameters1481);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop44;
				}
			}

			match(input,CLOSE,FOLLOW_CLOSE_in_parameters1489); 
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



	// $ANTLR start "goal_list"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:271:1: goal_list returns [ArrayList<Abstract_Term>ts] : t= term STOP ( COMMA t1= term STOP )* ;
	public final ArrayList<Abstract_Term> goal_list() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:272:2: (t= term STOP ( COMMA t1= term STOP )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:272:4: t= term STOP ( COMMA t1= term STOP )*
			{
			pushFollow(FOLLOW_term_in_goal_list1509);
			t=term();
			state._fsp--;

			match(input,STOP,FOLLOW_STOP_in_goal_list1511); 
			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:273:2: ( COMMA t1= term STOP )*
			loop45:
			while (true) {
				int alt45=2;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==COMMA) ) {
					alt45=1;
				}

				switch (alt45) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:273:3: COMMA t1= term STOP
					{
					match(input,COMMA,FOLLOW_COMMA_in_goal_list1517); 
					pushFollow(FOLLOW_term_in_goal_list1521);
					t1=term();
					state._fsp--;

					match(input,STOP,FOLLOW_STOP_in_goal_list1523); 
					tl.add(t1);
					}
					break;

				default :
					break loop45;
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
	// $ANTLR end "goal_list"



	// $ANTLR start "term"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:323:1: term returns [Abstract_Term t] : (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) ;
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_StringTerm st =null;
		Abstract_Term ft =null;
		Abstract_NumberTerm at =null;
		Abstract_ListTermImpl lt =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:324:2: ( (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:324:4: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:324:4: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			int alt46=4;
			switch ( input.LA(1) ) {
			case STRING:
				{
				alt46=1;
				}
				break;
			case CONST:
				{
				alt46=2;
				}
				break;
			case MINUS:
			case NUMBER:
			case VAR:
				{
				alt46=3;
				}
				break;
			case SQOPEN:
				{
				alt46=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}
			switch (alt46) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:324:5: st= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term1854);
					st=stringterm();
					state._fsp--;

					t = st;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:325:4: ft= function_term
					{
					pushFollow(FOLLOW_function_term_in_term1864);
					ft=function_term();
					state._fsp--;

					t =ft;
					}
					break;
				case 3 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:326:4: at= arithexpr
					{
					pushFollow(FOLLOW_arithexpr_in_term1874);
					at=arithexpr();
					state._fsp--;

					t =at;
					}
					break;
				case 4 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:327:4: lt= listterm
					{
					pushFollow(FOLLOW_listterm_in_term1883);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:328:1: function_term returns [Abstract_Term t] : c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? ;
	public final Abstract_Term function_term() throws RecognitionException {
		Abstract_Term t = null;


		Token c=null;
		Abstract_Term t1 =null;
		Abstract_Term t2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:329:2: (c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:329:4: c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			{
			c=(Token)match(input,CONST,FOLLOW_CONST_in_function_term1900); 
			t=new Abstract_Predicate(c.getText());
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:330:2: ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==OPEN) ) {
				alt48=1;
			}
			switch (alt48) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:330:3: OPEN t1= term ( COMMA t2= term )* CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function_term1907); 
					pushFollow(FOLLOW_term_in_function_term1911);
					t1=term();
					state._fsp--;

					((Abstract_Predicate) t).addTerm(t1);
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:331:2: ( COMMA t2= term )*
					loop47:
					while (true) {
						int alt47=2;
						int LA47_0 = input.LA(1);
						if ( (LA47_0==COMMA) ) {
							alt47=1;
						}

						switch (alt47) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:331:3: COMMA t2= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_function_term1918); 
							pushFollow(FOLLOW_term_in_function_term1922);
							t2=term();
							state._fsp--;

							((Abstract_Predicate) t).addTerm(t2);
							}
							break;

						default :
							break loop47;
						}
					}

					match(input,CLOSE,FOLLOW_CLOSE_in_function_term1928); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:335:1: var returns [Abstract_VarTerm v] : VAR ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR3=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:336:2: ( VAR )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:336:4: VAR
			{
			VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_var1947); 
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



	// $ANTLR start "stringLiteral"
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:344:1: stringLiteral returns [Abstract_StringTerm s] : st= stringterm ;
	public final Abstract_StringTerm stringLiteral() throws RecognitionException {
		Abstract_StringTerm s = null;


		Abstract_StringTerm st =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:345:2: (st= stringterm )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:345:4: st= stringterm
			{
			pushFollow(FOLLOW_stringterm_in_stringLiteral1964);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:346:1: singleQuotedStringLiteral returns [Abstract_StringTerm s] : SINGLEQUOTE w= word SINGLEQUOTE ;
	public final Abstract_StringTerm singleQuotedStringLiteral() throws RecognitionException {
		Abstract_StringTerm s = null;


		String w =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:347:2: ( SINGLEQUOTE w= word SINGLEQUOTE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:347:4: SINGLEQUOTE w= word SINGLEQUOTE
			{
			match(input,SINGLEQUOTE,FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral1978); 
			pushFollow(FOLLOW_word_in_singleQuotedStringLiteral1982);
			w=word();
			state._fsp--;

			match(input,SINGLEQUOTE,FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral1984); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:349:1: stringterm returns [Abstract_StringTerm s] : STRING ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING4=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:350:2: ( STRING )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:350:4: STRING
			{
			STRING4=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm2001); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:353:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST5=null;
		Token VAR6=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:353:25: ( ( CONST | VAR ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:353:27: ( CONST | VAR )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:353:27: ( CONST | VAR )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==CONST) ) {
				alt49=1;
			}
			else if ( (LA49_0==VAR) ) {
				alt49=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}

			switch (alt49) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:353:28: CONST
					{
					CONST5=(Token)match(input,CONST,FOLLOW_CONST_in_word2018); 
					s =CONST5.getText();
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:353:59: VAR
					{
					VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_word2024); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:355:1: listterm returns [Abstract_ListTermImpl l] : SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE ;
	public final Abstract_ListTermImpl listterm() throws RecognitionException {
		Abstract_ListTermImpl l = null;


		Token v=null;
		Abstract_Term h =null;
		Abstract_Term t =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:356:3: ( SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:356:5: SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE
			{
			l = new Abstract_ListTermImpl(); Abstract_ListTerm lrunning = l;
			match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2045); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:357:10: (h= term ( COMMA t= term )* ( BAR v= VAR )? )?
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==CONST||LA52_0==MINUS||LA52_0==NUMBER||LA52_0==SQOPEN||LA52_0==STRING||LA52_0==VAR) ) {
				alt52=1;
			}
			switch (alt52) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:357:11: h= term ( COMMA t= term )* ( BAR v= VAR )?
					{
					pushFollow(FOLLOW_term_in_listterm2050);
					h=term();
					state._fsp--;

					l.addHead(h); l.addTail(new Abstract_ListTermImpl());
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:358:3: ( COMMA t= term )*
					loop50:
					while (true) {
						int alt50=2;
						int LA50_0 = input.LA(1);
						if ( (LA50_0==COMMA) ) {
							alt50=1;
						}

						switch (alt50) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:358:4: COMMA t= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_listterm2057); 
							pushFollow(FOLLOW_term_in_listterm2061);
							t=term();
							state._fsp--;

							Abstract_ListTerm l2 = new Abstract_ListTermImpl(); l2.addHead(t); l2.addTail(new Abstract_ListTermImpl()); lrunning.addTail(l2); lrunning=l2;
							}
							break;

						default :
							break loop50;
						}
					}

					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:359:3: ( BAR v= VAR )?
					int alt51=2;
					int LA51_0 = input.LA(1);
					if ( (LA51_0==BAR) ) {
						alt51=1;
					}
					switch (alt51) {
						case 1 :
							// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:359:4: BAR v= VAR
							{
							match(input,BAR,FOLLOW_BAR_in_listterm2070); 
							v=(Token)match(input,VAR,FOLLOW_VAR_in_listterm2074); 
							lrunning.addTail(new Abstract_VarTerm(v.getText()));
							}
							break;

					}

					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2086); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:363:1: equation returns [Abstract_Equation e] : a1= arithexpr i= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation e = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:364:2: (a1= arithexpr i= eqoper a2= arithexpr )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:364:4: a1= arithexpr i= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation2104);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation2108);
			i=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation2112);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:367:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:368:2: ( ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:368:4: ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? )
			{
			s = "";
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:368:15: ( MINUS )?
			int alt53=2;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==MINUS) ) {
				alt53=1;
			}
			switch (alt53) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:368:16: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring2132); 
					s += "-";
					}
					break;

			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:369:2: (n1= NUMBER ( STOP n2= NUMBER )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:369:3: n1= NUMBER ( STOP n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2143); 
			s += n1.getText();
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:370:2: ( STOP n2= NUMBER )?
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==STOP) ) {
				int LA54_1 = input.LA(2);
				if ( (LA54_1==NUMBER) ) {
					alt54=1;
				}
			}
			switch (alt54) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:370:3: STOP n2= NUMBER
					{
					match(input,STOP,FOLLOW_STOP_in_numberstring2149); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2155); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:372:1: arithexpr returns [Abstract_NumberTerm ae] : a1= multexpr (i= addoper a2= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:373:2: (a1= multexpr (i= addoper a2= multexpr )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:373:4: a1= multexpr (i= addoper a2= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr2175);
			a1=multexpr();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:373:28: (i= addoper a2= multexpr )?
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==MINUS||LA55_0==PLUS) ) {
				alt55=1;
			}
			switch (alt55) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:373:29: i= addoper a2= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr2182);
					i=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr2186);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:374:1: multexpr returns [Abstract_NumberTerm ae] : a1= atom_term (i= multoper a2= atom_term )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:375:2: (a1= atom_term (i= multoper a2= atom_term )? )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:375:4: a1= atom_term (i= multoper a2= atom_term )?
			{
			pushFollow(FOLLOW_atom_term_in_multexpr2204);
			a1=atom_term();
			state._fsp--;

			ae = a1;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:375:28: (i= multoper a2= atom_term )?
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==DIV||LA56_0==MULT) ) {
				alt56=1;
			}
			switch (alt56) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:375:29: i= multoper a2= atom_term
					{
					pushFollow(FOLLOW_multoper_in_multexpr2210);
					i=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_term_in_multexpr2214);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:377:1: atom_term returns [Abstract_NumberTerm t] : (n= numberstring |v= var ) ;
	public final Abstract_NumberTerm atom_term() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:378:2: ( (n= numberstring |v= var ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:378:4: (n= numberstring |v= var )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:378:4: (n= numberstring |v= var )
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==MINUS||LA57_0==NUMBER) ) {
				alt57=1;
			}
			else if ( (LA57_0==VAR) ) {
				alt57=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 57, 0, input);
				throw nvae;
			}

			switch (alt57) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:378:5: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom_term2236);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:378:66: v= var
					{
					pushFollow(FOLLOW_var_in_atom_term2244);
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:381:1: addoper returns [int i] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:382:2: ( ( PLUS | MINUS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:382:4: ( PLUS | MINUS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:382:4: ( PLUS | MINUS )
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==PLUS) ) {
				alt58=1;
			}
			else if ( (LA58_0==MINUS) ) {
				alt58=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 58, 0, input);
				throw nvae;
			}

			switch (alt58) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:382:5: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper2263); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:382:22: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper2269); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:383:1: multoper returns [int i] : ( MULT | DIV ) ;
	public final int multoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:384:2: ( ( MULT | DIV ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:384:4: ( MULT | DIV )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:384:4: ( MULT | DIV )
			int alt59=2;
			int LA59_0 = input.LA(1);
			if ( (LA59_0==MULT) ) {
				alt59=1;
			}
			else if ( (LA59_0==DIV) ) {
				alt59=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 59, 0, input);
				throw nvae;
			}

			switch (alt59) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:384:5: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper2286); 
					i = 3;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:384:22: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper2292); 
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
	// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:385:1: eqoper returns [int i] : ( LESS | IS ) ;
	public final int eqoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:385:24: ( ( LESS | IS ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:385:26: ( LESS | IS )
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:385:26: ( LESS | IS )
			int alt60=2;
			int LA60_0 = input.LA(1);
			if ( (LA60_0==LESS) ) {
				alt60=1;
			}
			else if ( (LA60_0==IS) ) {
				alt60=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 60, 0, input);
				throw nvae;
			}

			switch (alt60) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:385:27: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2308); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:385:44: IS
					{
					match(input,IS,FOLLOW_IS_in_eqoper2314); 
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



	public static final BitSet FOLLOW_MAIN_in_mas74 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COLON_in_mas76 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_mas80 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_mas82 = new BitSet(new long[]{0x0000050081000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_moduleImport_in_mas89 = new BitSet(new long[]{0x0000050081010000L,0x0000000000000008L});
	public static final BitSet FOLLOW_module_in_mas95 = new BitSet(new long[]{0x0000050081010000L,0x0000000000000008L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_mas102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_67_in_moduleImport116 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_MODULEFILE_in_moduleImport118 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_STOP_in_moduleImport120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_moduleDef_in_module137 = new BitSet(new long[]{0x1000000000020000L});
	public static final BitSet FOLLOW_SQOPEN_in_module142 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001200L});
	public static final BitSet FOLLOW_moduleOption_in_module144 = new BitSet(new long[]{0x0800000000002000L});
	public static final BitSet FOLLOW_COMMA_in_module148 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001200L});
	public static final BitSet FOLLOW_moduleOption_in_module150 = new BitSet(new long[]{0x0800000000002000L});
	public static final BitSet FOLLOW_SQCLOSE_in_module155 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module160 = new BitSet(new long[]{0x0020000810010410L,0x0000000000000008L});
	public static final BitSet FOLLOW_krImport_in_module162 = new BitSet(new long[]{0x0020000810010410L});
	public static final BitSet FOLLOW_knowledge_in_module165 = new BitSet(new long[]{0x0020000010010410L});
	public static final BitSet FOLLOW_beliefs_in_module170 = new BitSet(new long[]{0x0020000010010010L});
	public static final BitSet FOLLOW_goals_in_module174 = new BitSet(new long[]{0x0020000000010010L});
	public static final BitSet FOLLOW_program_in_module178 = new BitSet(new long[]{0x0000000000010010L});
	public static final BitSet FOLLOW_actionSpecs_in_module187 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef210 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_in_moduleDef212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INIT_in_moduleDef217 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_moduleDef224 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EVENT_in_moduleDef233 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_73_in_moduleOption252 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_EQUALS_in_moduleOption254 = new BitSet(new long[]{0x0000000000000000L,0x00000000000D0100L});
	public static final BitSet FOLLOW_72_in_moduleOption261 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_moduleOption271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_83_in_moduleOption281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_82_in_moduleOption292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_moduleOption306 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_EQUALS_in_moduleOption308 = new BitSet(new long[]{0x0000000000000000L,0x0000000000520800L});
	public static final BitSet FOLLOW_set_in_moduleOption314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_67_in_krImport339 = new BitSet(new long[]{0x4400000000000000L});
	public static final BitSet FOLLOW_stringLiteral_in_krImport342 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_singleQuotedStringLiteral_in_krImport346 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_STOP_in_krImport349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KNOWLEDGE_in_knowledge362 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_knowledge364 = new BitSet(new long[]{0x0000820000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_krspec_in_knowledge366 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_knowledge369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_krspec381 = new BitSet(new long[]{0x2040000000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec385 = new BitSet(new long[]{0x0000820000008002L,0x0000000000000002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_krspec392 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_parameters_in_krspec396 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec398 = new BitSet(new long[]{0x0000820000008002L,0x0000000000000002L});
	public static final BitSet FOLLOW_BELIEFS_in_beliefs414 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_beliefs416 = new BitSet(new long[]{0x0000820000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_brspec_in_beliefs418 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_beliefs421 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_brspec433 = new BitSet(new long[]{0x2040000000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec437 = new BitSet(new long[]{0x0000820000008002L,0x0000000000000002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_brspec444 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_parameters_in_brspec448 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec450 = new BitSet(new long[]{0x0000820000008002L,0x0000000000000002L});
	public static final BitSet FOLLOW_GOALS_in_goals467 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_goals469 = new BitSet(new long[]{0x5000820000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_goal_list_in_goals473 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_goals477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_atom493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_atom502 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROGRAM_in_program517 = new BitSet(new long[]{0x1000000000020000L});
	public static final BitSet FOLLOW_SQOPEN_in_program520 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_ruleEvaluationOrder_in_program524 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_program528 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program534 = new BitSet(new long[]{0x0000000060010000L,0x0000000000006000L});
	public static final BitSet FOLLOW_macroDef_in_program536 = new BitSet(new long[]{0x0000000060010000L,0x0000000000006000L});
	public static final BitSet FOLLOW_programRule_in_program539 = new BitSet(new long[]{0x0000000040010000L,0x0000000000006000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_ruleEvaluationOrder560 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_ORDER_in_ruleEvaluationOrder562 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_EQUALS_in_ruleEvaluationOrder564 = new BitSet(new long[]{0x0180006000000020L});
	public static final BitSet FOLLOW_LINEAR_in_ruleEvaluationOrder568 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_LINEARALL_in_ruleEvaluationOrder575 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_RANDOM_in_ruleEvaluationOrder581 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_RANDOMALL_in_ruleEvaluationOrder587 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_ADAPTIVE_in_ruleEvaluationOrder594 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_ruleEvaluationOrder600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HASH_in_macroDef609 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_DEFINE_in_macroDef611 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_macroDef615 = new BitSet(new long[]{0x000040000C008280L,0x000000000E8000C3L});
	public static final BitSet FOLLOW_mentalstate_in_macroDef620 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_STOP_in_macroDef626 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_programRule640 = new BitSet(new long[]{0x000040000C008280L,0x000000000E8000C3L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule644 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_THEN_in_programRule648 = new BitSet(new long[]{0x02000101814A8040L,0x000000000FA084C2L});
	public static final BitSet FOLLOW_actions_in_programRule654 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule658 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_programRule671 = new BitSet(new long[]{0x000040000C008280L,0x000000000E8000C3L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule673 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_DO_in_programRule675 = new BitSet(new long[]{0x02000101814A8040L,0x000000000FA084C2L});
	public static final BitSet FOLLOW_actions_in_programRule678 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule680 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule684 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_programRule692 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_programRule694 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_programRule696 = new BitSet(new long[]{0x000040000C008280L,0x000000000E8000C3L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule698 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_DO_in_programRule700 = new BitSet(new long[]{0x02000101814A8040L,0x000000000FA084C2L});
	public static final BitSet FOLLOW_actions_in_programRule703 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule705 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_programRule718 = new BitSet(new long[]{0x000040000C008280L,0x000000000E8000C3L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule720 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_programRule722 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_programRule724 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_DO_in_programRule726 = new BitSet(new long[]{0x02000101814A8040L,0x000000000FA084C2L});
	public static final BitSet FOLLOW_actions_in_programRule729 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule735 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURLYOPEN_in_nestedRules753 = new BitSet(new long[]{0x0000000040000000L,0x0000000000006000L});
	public static final BitSet FOLLOW_programRule_in_nestedRules755 = new BitSet(new long[]{0x0000000040010000L,0x0000000000006000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_nestedRules759 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_basicCondition_in_mentalstatecond777 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_COMMA_in_mentalstatecond783 = new BitSet(new long[]{0x000040000C008280L,0x000000000E8000C3L});
	public static final BitSet FOLLOW_basicCondition_in_mentalstatecond787 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_mentalatom_in_mentalstate810 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_mentalstate817 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalstate819 = new BitSet(new long[]{0x000000000C008280L,0x000000000E8000C2L});
	public static final BitSet FOLLOW_mentalatom_in_mentalstate821 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CLOSE_in_mentalstate823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_mentalstate828 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mentalstate_in_basicCondition848 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_basicCondition857 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selector_in_mentalatom875 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_STOP_in_mentalatom877 = new BitSet(new long[]{0x000000000C000280L});
	public static final BitSet FOLLOW_mentalOperator_in_mentalatom883 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_atom_parameters_in_mentalatom887 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEL_in_mentalOperator909 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_mentalOperator920 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AGOAL_in_mentalOperator931 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOALA_in_mentalOperator940 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actions961 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_PLUS_in_actions968 = new BitSet(new long[]{0x0200010181488040L,0x000000000FA084C2L});
	public static final BitSet FOLLOW_action_in_actions972 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_selector_in_action992 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_STOP_in_action994 = new BitSet(new long[]{0x0200000100480040L,0x0000000001208000L});
	public static final BitSet FOLLOW_actionOperator_in_action1000 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_parameters_in_action1004 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_74_in_action1016 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_action1025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INIT_in_action1034 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_action1043 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EVENT_in_action1052 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_action1059 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADOPT_in_actionOperator1080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_actionOperator1089 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INSERT_in_actionOperator1098 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DELETE_in_actionOperator1109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEND_in_actionOperator1121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_88_in_actionOperator1130 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_85_in_actionOperator1139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_actionOperator1150 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_selector1162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_selector1171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_selector1180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_87_in_selector1189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_89_in_selector1198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_90_in_selector1207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_91_in_selector1216 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTIONSPEC_in_actionSpecs1235 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionSpecs1237 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_actionSpec_in_actionSpecs1242 = new BitSet(new long[]{0x0000000000018000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionSpecs1248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_actionSpec1265 = new BitSet(new long[]{0x0000000202020000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionSpec1278 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_precondition_in_actionSpec1282 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_postcondition_in_actionSpec1286 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionSpec1288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRE_in_precondition1306 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_parameters_in_precondition1310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POST_in_postcondition1327 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_parameters_in_postcondition1331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_declaration1350 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_parameters_in_declaration1357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_declarationOrCallWithTerms1378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_id1397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_id1404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom_parameters1427 = new BitSet(new long[]{0x0000820000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_atom_parameters1431 = new BitSet(new long[]{0x0000000000002800L});
	public static final BitSet FOLLOW_COMMA_in_atom_parameters1437 = new BitSet(new long[]{0x0000820000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_atom_parameters1441 = new BitSet(new long[]{0x0000000000002800L});
	public static final BitSet FOLLOW_CLOSE_in_atom_parameters1449 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_parameters1467 = new BitSet(new long[]{0x5000820000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_parameters1471 = new BitSet(new long[]{0x0000000000002800L});
	public static final BitSet FOLLOW_COMMA_in_parameters1477 = new BitSet(new long[]{0x5000820000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_parameters1481 = new BitSet(new long[]{0x0000000000002800L});
	public static final BitSet FOLLOW_CLOSE_in_parameters1489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_goal_list1509 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_STOP_in_goal_list1511 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_COMMA_in_goal_list1517 = new BitSet(new long[]{0x5000820000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_goal_list1521 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_STOP_in_goal_list1523 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_stringterm_in_term1854 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_term1864 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_term1874 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_term1883 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function_term1900 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_OPEN_in_function_term1907 = new BitSet(new long[]{0x5000820000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_function_term1911 = new BitSet(new long[]{0x0000000000002800L});
	public static final BitSet FOLLOW_COMMA_in_function_term1918 = new BitSet(new long[]{0x5000820000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_function_term1922 = new BitSet(new long[]{0x0000000000002800L});
	public static final BitSet FOLLOW_CLOSE_in_function_term1928 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var1947 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_stringLiteral1964 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral1978 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_singleQuotedStringLiteral1982 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral1984 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_stringterm2001 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_word2018 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word2024 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_listterm2045 = new BitSet(new long[]{0x5800820000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_listterm2050 = new BitSet(new long[]{0x0800000000002100L});
	public static final BitSet FOLLOW_COMMA_in_listterm2057 = new BitSet(new long[]{0x5000820000008000L,0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_listterm2061 = new BitSet(new long[]{0x0800000000002100L});
	public static final BitSet FOLLOW_BAR_in_listterm2070 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_listterm2074 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_listterm2086 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation2104 = new BitSet(new long[]{0x0000001400000000L});
	public static final BitSet FOLLOW_eqoper_in_equation2108 = new BitSet(new long[]{0x0000820000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation2112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring2132 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2143 = new BitSet(new long[]{0x2000000000000002L});
	public static final BitSet FOLLOW_STOP_in_numberstring2149 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2175 = new BitSet(new long[]{0x0004020000000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr2182 = new BitSet(new long[]{0x0000820000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2204 = new BitSet(new long[]{0x0000100000100002L});
	public static final BitSet FOLLOW_multoper_in_multexpr2210 = new BitSet(new long[]{0x0000820000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom_term2236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom_term2244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper2263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper2269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper2286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper2292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IS_in_eqoper2314 = new BitSet(new long[]{0x0000000000000002L});
}
