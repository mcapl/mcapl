// $ANTLR 3.5.1 /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2015-10-19 16:31:03

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
	@Override public String getGrammarFileName() { return "/Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g"; }


	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
	private static HashMap<PredicateIndicator,Abstract_MentalState> macros = new HashMap<PredicateIndicator, Abstract_MentalState>();
	private static HashMap<PredicateIndicator,Abstract_Term> macro_subs = new HashMap<PredicateIndicator, Abstract_Term>();
	private String name = "";



	// $ANTLR start "mas"
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:53:1: mas returns [Abstract_MAS mas] : MAIN COLON i= id CURLYOPEN ( moduleImport |gm= module )+ CURLYCLOSE ;
	public final Abstract_MAS mas() throws RecognitionException {
		Abstract_MAS mas = null;


		String i =null;
		Abstract_GOALModule gm =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:54:2: ( MAIN COLON i= id CURLYOPEN ( moduleImport |gm= module )+ CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:54:4: MAIN COLON i= id CURLYOPEN ( moduleImport |gm= module )+ CURLYCLOSE
			{
			mas = new Abstract_MAS(); ArrayList<Abstract_GOALAgent> agents = new ArrayList<Abstract_GOALAgent>();
			match(input,MAIN,FOLLOW_MAIN_in_mas74); 
			match(input,COLON,FOLLOW_COLON_in_mas76); 
			pushFollow(FOLLOW_id_in_mas80);
			i=id();
			state._fsp--;

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_mas82); 
			 Abstract_GOALAgent gl = new Abstract_GOALAgent(i); agents.add(gl);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:2: ( moduleImport |gm= module )+
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:3: moduleImport
					{
					pushFollow(FOLLOW_moduleImport_in_mas89);
					moduleImport();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:57:18: gm= module
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:62:1: moduleImport : '#import' MODULEFILE STOP ;
	public final void moduleImport() throws RecognitionException {
		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:2: ( '#import' MODULEFILE STOP )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:63:4: '#import' MODULEFILE STOP
			{
			match(input,64,FOLLOW_64_in_moduleImport116); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:66:1: module returns [Abstract_GOALModule gl] : def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE ;
	public final Abstract_GOALModule module() throws RecognitionException {
		Abstract_GOALModule gl = null;


		int def =0;
		ArrayList<Abstract_ActionSpec> as =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:2: (def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:4: def= moduleDef ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )? CURLYOPEN ( krImport )? ( knowledge[gl] )? ( beliefs[gl] )? ( goals[gl] )? ( program[gl] )? (as= actionSpecs )? CURLYCLOSE
			{
			pushFollow(FOLLOW_moduleDef_in_module137);
			def=moduleDef();
			state._fsp--;

			gl = new Abstract_GOALModule(def);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:56: ( SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==SQOPEN) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:57: SQOPEN moduleOption[gl] ( COMMA moduleOption[gl] )* SQCLOSE
					{
					match(input,SQOPEN,FOLLOW_SQOPEN_in_module142); 
					pushFollow(FOLLOW_moduleOption_in_module144);
					moduleOption(gl);
					state._fsp--;

					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:81: ( COMMA moduleOption[gl] )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0==COMMA) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:67:82: COMMA moduleOption[gl]
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
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:12: ( krImport )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==64) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:12: krImport
					{
					pushFollow(FOLLOW_krImport_in_module162);
					krImport();
					state._fsp--;

					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:22: ( knowledge[gl] )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==KNOWLEDGE) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:22: knowledge[gl]
					{
					pushFollow(FOLLOW_knowledge_in_module165);
					knowledge(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:38: ( beliefs[gl] )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==BELIEFS) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:38: beliefs[gl]
					{
					pushFollow(FOLLOW_beliefs_in_module170);
					beliefs(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:51: ( goals[gl] )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==GOALS) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:51: goals[gl]
					{
					pushFollow(FOLLOW_goals_in_module174);
					goals(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:62: ( program[gl] )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==PROGRAM) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:68:62: program[gl]
					{
					pushFollow(FOLLOW_program_in_module178);
					program(gl);
					state._fsp--;

					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:2: (as= actionSpecs )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==ACTIONSPEC) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:69:3: as= actionSpecs
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:73:1: moduleDef returns [int i] : ( MODULE declaration | INIT MODULE | MAIN MODULE | EVENT MODULE );
	public final int moduleDef() throws RecognitionException {
		int i = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:2: ( MODULE declaration | INIT MODULE | MAIN MODULE | EVENT MODULE )
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:74:4: MODULE declaration
					{
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef210); 
					pushFollow(FOLLOW_declaration_in_moduleDef212);
					declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:75:4: INIT MODULE
					{
					match(input,INIT,FOLLOW_INIT_in_moduleDef217); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef219); 
					i = Abstract_GOALModule.init;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:76:4: MAIN MODULE
					{
					match(input,MAIN,FOLLOW_MAIN_in_moduleDef226); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef228); 
					i = Abstract_GOALModule.main;
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:77:4: EVENT MODULE
					{
					match(input,EVENT,FOLLOW_EVENT_in_moduleDef235); 
					match(input,MODULE,FOLLOW_MODULE_in_moduleDef237); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:81:1: moduleOption[Abstract_GOALModule gl] : (key= 'exit' EQUALS value= ( 'always' | 'never' | 'nogoals' | 'noaction' ) |key= 'focus' EQUALS value= ( 'none' | 'new' | 'select' | 'filter' ) );
	public final void moduleOption(Abstract_GOALModule gl) throws RecognitionException {
		Token key=null;
		Token value=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:2: (key= 'exit' EQUALS value= ( 'always' | 'never' | 'nogoals' | 'noaction' ) |key= 'focus' EQUALS value= ( 'none' | 'new' | 'select' | 'filter' ) )
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:4: key= 'exit' EQUALS value= ( 'always' | 'never' | 'nogoals' | 'noaction' )
					{
					key=(Token)match(input,73,FOLLOW_73_in_moduleOption256); 
					match(input,EQUALS,FOLLOW_EQUALS_in_moduleOption258); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:31: ( 'always' | 'never' | 'nogoals' | 'noaction' )
					int alt11=4;
					switch ( input.LA(1) ) {
					case 70:
						{
						alt11=1;
						}
						break;
					case 81:
						{
						alt11=2;
						}
						break;
					case 84:
						{
						alt11=3;
						}
						break;
					case 83:
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
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:82:32: 'always'
							{
							value=(Token)match(input,70,FOLLOW_70_in_moduleOption265); 
							gl.setExitCondition(Abstract_GOALModule.always);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:83:6: 'never'
							{
							value=(Token)match(input,81,FOLLOW_81_in_moduleOption275); 
							gl.setExitCondition(Abstract_GOALModule.never);
							}
							break;
						case 3 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:84:6: 'nogoals'
							{
							value=(Token)match(input,84,FOLLOW_84_in_moduleOption285); 
							gl.setExitCondition(Abstract_GOALModule.nogoals);
							}
							break;
						case 4 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:85:7: 'noaction'
							{
							value=(Token)match(input,83,FOLLOW_83_in_moduleOption296); 
							gl.setExitCondition(Abstract_GOALModule.noaction);
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:86:4: key= 'focus' EQUALS value= ( 'none' | 'new' | 'select' | 'filter' )
					{
					key=(Token)match(input,76,FOLLOW_76_in_moduleOption310); 
					match(input,EQUALS,FOLLOW_EQUALS_in_moduleOption312); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:89:1: krImport : '#import' ( stringLiteral | singleQuotedStringLiteral ) STOP ;
	public final void krImport() throws RecognitionException {
		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:2: ( '#import' ( stringLiteral | singleQuotedStringLiteral ) STOP )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:4: '#import' ( stringLiteral | singleQuotedStringLiteral ) STOP
			{
			match(input,64,FOLLOW_64_in_krImport343); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:14: ( stringLiteral | singleQuotedStringLiteral )
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:15: stringLiteral
					{
					pushFollow(FOLLOW_stringLiteral_in_krImport346);
					stringLiteral();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:90:31: singleQuotedStringLiteral
					{
					pushFollow(FOLLOW_singleQuotedStringLiteral_in_krImport350);
					singleQuotedStringLiteral();
					state._fsp--;

					}
					break;

			}

			match(input,STOP,FOLLOW_STOP_in_krImport353); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:93:1: knowledge[Abstract_GOALModule gl] : KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE ;
	public final void knowledge(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:2: ( KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:94:4: KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE
			{
			match(input,KNOWLEDGE,FOLLOW_KNOWLEDGE_in_knowledge366); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_knowledge368); 
			pushFollow(FOLLOW_krspec_in_knowledge370);
			krspec(gl);
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_knowledge373); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:1: krspec[Abstract_GOALModule gl] : (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+ ;
	public final void krspec(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_Predicate hd =null;
		ArrayList<Abstract_LogicalFormula> body =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:31: ( (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==CONST) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:97:34: hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP )
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_krspec385);
					hd=declarationOrCallWithTerms();
					state._fsp--;

					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:98:2: ( STOP | PROLOGARROW body= no_bracket_literals STOP )
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
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:98:3: STOP
							{
							match(input,STOP,FOLLOW_STOP_in_krspec389); 
							gl.addFact((Abstract_Predicate) hd);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:99:2: PROLOGARROW body= no_bracket_literals STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_krspec396); 
							pushFollow(FOLLOW_no_bracket_literals_in_krspec400);
							body=no_bracket_literals();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_krspec402); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:101:1: beliefs[Abstract_GOALModule gl] : BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE ;
	public final void beliefs(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:2: ( BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:102:4: BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE
			{
			match(input,BELIEFS,FOLLOW_BELIEFS_in_beliefs418); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_beliefs420); 
			pushFollow(FOLLOW_brspec_in_beliefs422);
			brspec(gl);
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_beliefs425); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:1: brspec[Abstract_GOALModule gl] : (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+ ;
	public final void brspec(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_Predicate hd =null;
		ArrayList<Abstract_LogicalFormula> body =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:31: ( (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:33: (hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP ) )+
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:105:34: hd= declarationOrCallWithTerms ( STOP | PROLOGARROW body= no_bracket_literals STOP )
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_brspec437);
					hd=declarationOrCallWithTerms();
					state._fsp--;

					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:106:2: ( STOP | PROLOGARROW body= no_bracket_literals STOP )
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
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:106:3: STOP
							{
							match(input,STOP,FOLLOW_STOP_in_brspec441); 
							gl.addBel((Abstract_Predicate) hd);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:107:2: PROLOGARROW body= no_bracket_literals STOP
							{
							match(input,PROLOGARROW,FOLLOW_PROLOGARROW_in_brspec448); 
							pushFollow(FOLLOW_no_bracket_literals_in_brspec452);
							body=no_bracket_literals();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_brspec454); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:110:1: goals[Abstract_GOALModule gl] : GOALS CURLYOPEN le= goal_list CURLYCLOSE ;
	public final void goals(Abstract_GOALModule gl) throws RecognitionException {
		ArrayList<Abstract_Term> le =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:2: ( GOALS CURLYOPEN le= goal_list CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:111:4: GOALS CURLYOPEN le= goal_list CURLYCLOSE
			{
			match(input,GOALS,FOLLOW_GOALS_in_goals471); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_goals473); 
			pushFollow(FOLLOW_goal_list_in_goals477);
			le=goal_list();
			state._fsp--;

			gl.addGoal(le);
			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_goals481); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:113:1: atom returns [Abstract_LogicalFormula l] : (p= declarationOrCallWithTerms |e= equation );
	public final Abstract_LogicalFormula atom() throws RecognitionException {
		Abstract_LogicalFormula l = null;


		Abstract_Predicate p =null;
		Abstract_Equation e =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:114:2: (p= declarationOrCallWithTerms |e= equation )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==CONST) ) {
				alt18=1;
			}
			else if ( (LA18_0==MINUS||LA18_0==NUMBER||(LA18_0 >= UNNAMEDVAR && LA18_0 <= VAR)) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:114:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_atom497);
					p=declarationOrCallWithTerms();
					state._fsp--;

					l =p;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:115:4: e= equation
					{
					pushFollow(FOLLOW_equation_in_atom506);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:119:1: program[Abstract_GOALModule gl] : PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* ( programRule[gl] )* CURLYCLOSE ;
	public final void program(Abstract_GOALModule gl) throws RecognitionException {
		int i =0;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:2: ( PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* ( programRule[gl] )* CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:4: PROGRAM ( SQOPEN i= ruleEvaluationOrder SQCLOSE )? CURLYOPEN ( macroDef )* ( programRule[gl] )* CURLYCLOSE
			{
			match(input,PROGRAM,FOLLOW_PROGRAM_in_program521); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:12: ( SQOPEN i= ruleEvaluationOrder SQCLOSE )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==SQOPEN) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:120:13: SQOPEN i= ruleEvaluationOrder SQCLOSE
					{
					match(input,SQOPEN,FOLLOW_SQOPEN_in_program524); 
					pushFollow(FOLLOW_ruleEvaluationOrder_in_program528);
					i=ruleEvaluationOrder();
					state._fsp--;

					gl.setOptionOrder(i);
					match(input,SQCLOSE,FOLLOW_SQCLOSE_in_program532); 
					}
					break;

			}

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_program538); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:12: ( macroDef )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==HASH) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:12: macroDef
					{
					pushFollow(FOLLOW_macroDef_in_program540);
					macroDef();
					state._fsp--;

					}
					break;

				default :
					break loop20;
				}
			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:22: ( programRule[gl] )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==IF||LA21_0==77||LA21_0==79) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:121:22: programRule[gl]
					{
					pushFollow(FOLLOW_programRule_in_program543);
					programRule(gl);
					state._fsp--;

					}
					break;

				default :
					break loop21;
				}
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_program547); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:125:1: ruleEvaluationOrder returns [int i] : ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE ) ;
	public final int ruleEvaluationOrder() throws RecognitionException {
		int i = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:2: ( ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:4: ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE )
			{
			match(input,ORDER,FOLLOW_ORDER_in_ruleEvaluationOrder564); 
			match(input,EQUALS,FOLLOW_EQUALS_in_ruleEvaluationOrder566); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:17: ( LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE )
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:126:19: LINEAR
					{
					match(input,LINEAR,FOLLOW_LINEAR_in_ruleEvaluationOrder570); 
					i =Abstract_GOALModule.linear;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:127:2: LINEARALL
					{
					match(input,LINEARALL,FOLLOW_LINEARALL_in_ruleEvaluationOrder577); 
					i =Abstract_GOALModule.linearall;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:128:2: RANDOM
					{
					match(input,RANDOM,FOLLOW_RANDOM_in_ruleEvaluationOrder583); 
					i =Abstract_GOALModule.random;
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:129:2: RANDOMALL
					{
					match(input,RANDOMALL,FOLLOW_RANDOMALL_in_ruleEvaluationOrder589); 
					i =Abstract_GOALModule.randomall;
					}
					break;
				case 5 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:130:2: ADAPTIVE
					{
					match(input,ADAPTIVE,FOLLOW_ADAPTIVE_in_ruleEvaluationOrder596); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:133:1: macroDef : HASH DEFINE p= declarationOrCallWithTerms msc= mentalstate STOP ;
	public final void macroDef() throws RecognitionException {
		Abstract_Predicate p =null;
		Abstract_MentalState msc =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:134:2: ( HASH DEFINE p= declarationOrCallWithTerms msc= mentalstate STOP )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:134:4: HASH DEFINE p= declarationOrCallWithTerms msc= mentalstate STOP
			{
			match(input,HASH,FOLLOW_HASH_in_macroDef610); 
			match(input,DEFINE,FOLLOW_DEFINE_in_macroDef612); 
			pushFollow(FOLLOW_declarationOrCallWithTerms_in_macroDef616);
			p=declarationOrCallWithTerms();
			state._fsp--;

			pushFollow(FOLLOW_mentalstate_in_macroDef621);
			msc=mentalstate();
			state._fsp--;

			PredicateIndicator pi = new PredicateIndicator(p.getFunctor(), p.getTermSize()); macros.put(pi, msc);
				macro_subs.put(pi, p);
			match(input,STOP,FOLLOW_STOP_in_macroDef627); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:140:1: programRule[Abstract_GOALModule gl] : ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] ) | 'forall' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] ) ) ;
	public final void programRule(Abstract_GOALModule gl) throws RecognitionException {
		Abstract_MentalState lf =null;
		ArrayList<Abstract_Deed> dl =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:141:2: ( ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] ) | 'forall' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] ) ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:141:3: ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] ) | 'forall' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] ) )
			{
			Abstract_ActionRule rule = new Abstract_ActionRule();
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:2: ( IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] ) | 'forall' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] ) | 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] ) )
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
			case 79:
				{
				int LA27_3 = input.LA(2);
				if ( (LA27_3==VAR) ) {
					int LA27_4 = input.LA(3);
					if ( (LA27_4==66) ) {
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
				else if ( (LA27_3==AGOAL||LA27_3==BEL||LA27_3==CONST||(LA27_3 >= GOAL && LA27_3 <= GOALA)||LA27_3==NOT||LA27_3==TRUE||(LA27_3 >= 68 && LA27_3 <= 69)||LA27_3==88||(LA27_3 >= 91 && LA27_3 <= 93)) ) {
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:3: IF lf= mentalstatecond THEN (dl= actions STOP | nestedRules[gl] )
					{
					match(input,IF,FOLLOW_IF_in_programRule641); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule645);
					lf=mentalstatecond();
					state._fsp--;

					rule.setMentalStateCond(lf);
					match(input,THEN,FOLLOW_THEN_in_programRule649); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:61: (dl= actions STOP | nestedRules[gl] )
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==CONST||LA23_0==EVENT||LA23_0==INIT||LA23_0==MAIN||LA23_0==VAR||(LA23_0 >= 67 && LA23_0 <= 69)||(LA23_0 >= 71 && LA23_0 <= 72)||LA23_0==74||LA23_0==78||LA23_0==80||LA23_0==86||(LA23_0 >= 88 && LA23_0 <= 93)) ) {
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
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:63: dl= actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule655);
							dl=actions();
							state._fsp--;

							rule.setBody(dl);
							match(input,STOP,FOLLOW_STOP_in_programRule659); 
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:142:101: nestedRules[gl]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule663);
							nestedRules(gl);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:4: 'forall' mentalstatecond DO ( actions STOP | nestedRules[gl] )
					{
					match(input,77,FOLLOW_77_in_programRule672); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule674);
					mentalstatecond();
					state._fsp--;

					match(input,DO,FOLLOW_DO_in_programRule676); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:32: ( actions STOP | nestedRules[gl] )
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==CONST||LA24_0==EVENT||LA24_0==INIT||LA24_0==MAIN||LA24_0==VAR||(LA24_0 >= 67 && LA24_0 <= 69)||(LA24_0 >= 71 && LA24_0 <= 72)||LA24_0==74||LA24_0==78||LA24_0==80||LA24_0==86||(LA24_0 >= 88 && LA24_0 <= 93)) ) {
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
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:33: actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule679);
							actions();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_programRule681); 
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:143:48: nestedRules[gl]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule685);
							nestedRules(gl);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:4: 'listall' VAR '<-' mentalstatecond DO ( actions STOP | nestedRules[gl] )
					{
					match(input,79,FOLLOW_79_in_programRule693); 
					match(input,VAR,FOLLOW_VAR_in_programRule695); 
					match(input,66,FOLLOW_66_in_programRule697); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule699);
					mentalstatecond();
					state._fsp--;

					match(input,DO,FOLLOW_DO_in_programRule701); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:42: ( actions STOP | nestedRules[gl] )
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
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:43: actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule704);
							actions();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_programRule706); 
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:144:58: nestedRules[gl]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule710);
							nestedRules(gl);
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:145:4: 'listall' mentalstatecond '->' VAR DO ( actions STOP | nestedRules[gl] )
					{
					match(input,79,FOLLOW_79_in_programRule719); 
					pushFollow(FOLLOW_mentalstatecond_in_programRule721);
					mentalstatecond();
					state._fsp--;

					match(input,65,FOLLOW_65_in_programRule723); 
					match(input,VAR,FOLLOW_VAR_in_programRule725); 
					match(input,DO,FOLLOW_DO_in_programRule727); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:145:42: ( actions STOP | nestedRules[gl] )
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
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:145:43: actions STOP
							{
							pushFollow(FOLLOW_actions_in_programRule730);
							actions();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_programRule732); 
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:145:58: nestedRules[gl]
							{
							pushFollow(FOLLOW_nestedRules_in_programRule736);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:148:1: nestedRules[Abstract_GOALModule gl] : CURLYOPEN ( programRule[gl] )+ CURLYCLOSE ;
	public final void nestedRules(Abstract_GOALModule gl) throws RecognitionException {
		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:2: ( CURLYOPEN ( programRule[gl] )+ CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:4: CURLYOPEN ( programRule[gl] )+ CURLYCLOSE
			{
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_nestedRules754); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:14: ( programRule[gl] )+
			int cnt28=0;
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==IF||LA28_0==77||LA28_0==79) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:149:14: programRule[gl]
					{
					pushFollow(FOLLOW_programRule_in_nestedRules756);
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

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_nestedRules760); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:153:1: mentalstatecond returns [Abstract_MentalState lf] : ma= basicCondition ( COMMA ms2= basicCondition )* ;
	public final Abstract_MentalState mentalstatecond() throws RecognitionException {
		Abstract_MentalState lf = null;


		Abstract_MentalState ma =null;
		Abstract_MentalState ms2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:2: (ma= basicCondition ( COMMA ms2= basicCondition )* )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:154:4: ma= basicCondition ( COMMA ms2= basicCondition )*
			{
			pushFollow(FOLLOW_basicCondition_in_mentalstatecond778);
			ma=basicCondition();
			state._fsp--;

			Abstract_MentalState ms =  ma;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:155:2: ( COMMA ms2= basicCondition )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==COMMA) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:155:3: COMMA ms2= basicCondition
					{
					match(input,COMMA,FOLLOW_COMMA_in_mentalstatecond784); 
					pushFollow(FOLLOW_basicCondition_in_mentalstatecond788);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:158:1: mentalstate returns [Abstract_MentalState ms] : (ma= mentalatom | NOT OPEN mentalatom CLOSE | TRUE );
	public final Abstract_MentalState mentalstate() throws RecognitionException {
		Abstract_MentalState ms = null;


		Abstract_MentalState ma =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:159:2: (ma= mentalatom | NOT OPEN mentalatom CLOSE | TRUE )
			int alt30=3;
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:159:4: ma= mentalatom
					{
					pushFollow(FOLLOW_mentalatom_in_mentalstate811);
					ma=mentalatom();
					state._fsp--;

					ms = new Abstract_MentalState(ma);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:160:4: NOT OPEN mentalatom CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_mentalstate818); 
					match(input,OPEN,FOLLOW_OPEN_in_mentalstate820); 
					pushFollow(FOLLOW_mentalatom_in_mentalstate822);
					mentalatom();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_mentalstate824); 
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:161:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_mentalstate829); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:164:1: basicCondition returns [Abstract_MentalState ms] : (ms1= mentalstate |p= declarationOrCallWithTerms );
	public final Abstract_MentalState basicCondition() throws RecognitionException {
		Abstract_MentalState ms = null;


		Abstract_MentalState ms1 =null;
		Abstract_Predicate p =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:2: (ms1= mentalstate |p= declarationOrCallWithTerms )
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==CONST) ) {
				int LA31_1 = input.LA(2);
				if ( (LA31_1==STOP) ) {
					alt31=1;
				}
				else if ( (LA31_1==COMMA||LA31_1==DO||LA31_1==OPEN||LA31_1==THEN||LA31_1==65) ) {
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
			else if ( (LA31_0==AGOAL||LA31_0==BEL||(LA31_0 >= GOAL && LA31_0 <= GOALA)||LA31_0==NOT||LA31_0==TRUE||LA31_0==VAR||(LA31_0 >= 68 && LA31_0 <= 69)||LA31_0==88||(LA31_0 >= 91 && LA31_0 <= 93)) ) {
				alt31=1;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:165:4: ms1= mentalstate
					{
					pushFollow(FOLLOW_mentalstate_in_basicCondition849);
					ms1=mentalstate();
					state._fsp--;

					ms = ms1;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:166:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_basicCondition858);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:173:1: mentalatom returns [Abstract_MentalState ms] : ( selector STOP )? b= mentalOperator tl= atom_parameters ;
	public final Abstract_MentalState mentalatom() throws RecognitionException {
		Abstract_MentalState ms = null;


		byte b =0;
		Abstract_LogExpr tl =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:174:2: ( ( selector STOP )? b= mentalOperator tl= atom_parameters )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:175:2: ( selector STOP )? b= mentalOperator tl= atom_parameters
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:175:2: ( selector STOP )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==CONST||LA32_0==VAR||(LA32_0 >= 68 && LA32_0 <= 69)||LA32_0==88||(LA32_0 >= 91 && LA32_0 <= 93)) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:175:3: selector STOP
					{
					pushFollow(FOLLOW_selector_in_mentalatom878);
					selector();
					state._fsp--;

					match(input,STOP,FOLLOW_STOP_in_mentalatom880); 
					}
					break;

			}

			pushFollow(FOLLOW_mentalOperator_in_mentalatom886);
			b=mentalOperator();
			state._fsp--;

			pushFollow(FOLLOW_atom_parameters_in_mentalatom890);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:188:1: atom_parameters returns [Abstract_LogExpr ts] : OPEN (t= atom ( COMMA t1= atom | SEMI t1= atom )* |ap= atom_parameters ) CLOSE ;
	public final Abstract_LogExpr atom_parameters() throws RecognitionException {
		Abstract_LogExpr ts = null;


		Abstract_LogicalFormula t =null;
		Abstract_LogicalFormula t1 =null;
		Abstract_LogExpr ap =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:189:2: ( OPEN (t= atom ( COMMA t1= atom | SEMI t1= atom )* |ap= atom_parameters ) CLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:189:4: OPEN (t= atom ( COMMA t1= atom | SEMI t1= atom )* |ap= atom_parameters ) CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_atom_parameters909); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:189:9: (t= atom ( COMMA t1= atom | SEMI t1= atom )* |ap= atom_parameters )
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==CONST||LA34_0==MINUS||LA34_0==NUMBER||(LA34_0 >= UNNAMEDVAR && LA34_0 <= VAR)) ) {
				alt34=1;
			}
			else if ( (LA34_0==OPEN) ) {
				alt34=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:190:2: t= atom ( COMMA t1= atom | SEMI t1= atom )*
					{
					pushFollow(FOLLOW_atom_in_atom_parameters916);
					t=atom();
					state._fsp--;

					Abstract_LogExpr tl = new Abstract_LogExpr(Abstract_LogExpr.none, t);
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:191:2: ( COMMA t1= atom | SEMI t1= atom )*
					loop33:
					while (true) {
						int alt33=3;
						int LA33_0 = input.LA(1);
						if ( (LA33_0==COMMA) ) {
							alt33=1;
						}
						else if ( (LA33_0==SEMI) ) {
							alt33=2;
						}

						switch (alt33) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:191:3: COMMA t1= atom
							{
							match(input,COMMA,FOLLOW_COMMA_in_atom_parameters922); 
							pushFollow(FOLLOW_atom_in_atom_parameters926);
							t1=atom();
							state._fsp--;

							tl = new Abstract_LogExpr(tl, Abstract_LogExpr.and, t1);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:192:4: SEMI t1= atom
							{
							match(input,SEMI,FOLLOW_SEMI_in_atom_parameters933); 
							pushFollow(FOLLOW_atom_in_atom_parameters939);
							t1=atom();
							state._fsp--;

							tl = new Abstract_LogExpr(tl, Abstract_LogExpr.or, t1);
							}
							break;

						default :
							break loop33;
						}
					}

					 ts = tl;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:194:5: ap= atom_parameters
					{
					pushFollow(FOLLOW_atom_parameters_in_atom_parameters956);
					ap=atom_parameters();
					state._fsp--;

					ts = ap;
					}
					break;

			}

			match(input,CLOSE,FOLLOW_CLOSE_in_atom_parameters964); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:199:1: mentalOperator returns [byte b] : (op= BEL |op= GOAL |op= AGOAL |op= GOALA );
	public final byte mentalOperator() throws RecognitionException {
		byte b = 0;


		Token op=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:2: (op= BEL |op= GOAL |op= AGOAL |op= GOALA )
			int alt35=4;
			switch ( input.LA(1) ) {
			case BEL:
				{
				alt35=1;
				}
				break;
			case GOAL:
				{
				alt35=2;
				}
				break;
			case AGOAL:
				{
				alt35=3;
				}
				break;
			case GOALA:
				{
				alt35=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}
			switch (alt35) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:200:4: op= BEL
					{
					op=(Token)match(input,BEL,FOLLOW_BEL_in_mentalOperator985); 
					b = Abstract_BaseAILStructure.AILBel;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:201:4: op= GOAL
					{
					op=(Token)match(input,GOAL,FOLLOW_GOAL_in_mentalOperator996); 
					b = Abstract_BaseAILStructure.AILGoal;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:202:4: op= AGOAL
					{
					op=(Token)match(input,AGOAL,FOLLOW_AGOAL_in_mentalOperator1007); 
					b = Abstract_MentalAtom.agoal;
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:203:4: op= GOALA
					{
					op=(Token)match(input,GOALA,FOLLOW_GOALA_in_mentalOperator1018); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:206:1: actions returns [ArrayList<Abstract_Deed> dl] :a= action ( PLUS a1= action )* ;
	public final ArrayList<Abstract_Deed> actions() throws RecognitionException {
		ArrayList<Abstract_Deed> dl = null;


		Abstract_Deed a =null;
		Abstract_Deed a1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:2: (a= action ( PLUS a1= action )* )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:207:4: a= action ( PLUS a1= action )*
			{
			dl = new ArrayList<Abstract_Deed>();
			pushFollow(FOLLOW_action_in_actions1041);
			a=action();
			state._fsp--;

			dl.add(a);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:209:2: ( PLUS a1= action )*
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( (LA36_0==PLUS) ) {
					alt36=1;
				}

				switch (alt36) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:209:3: PLUS a1= action
					{
					match(input,PLUS,FOLLOW_PLUS_in_actions1048); 
					pushFollow(FOLLOW_action_in_actions1052);
					a1=action();
					state._fsp--;

					dl.add(a1);
					}
					break;

				default :
					break loop36;
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:212:1: action returns [Abstract_Deed d] : ( ( selector STOP )? d1= actionOperator tl= parameters |op= 'exit-module' |op= 'log' |op= INIT |op= MAIN |op= EVENT |p= declarationOrCallWithTerms );
	public final Abstract_Deed action() throws RecognitionException {
		Abstract_Deed d = null;


		Token op=null;
		Abstract_Deed d1 =null;
		ArrayList<Abstract_Term> tl =null;
		Abstract_Predicate p =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:213:2: ( ( selector STOP )? d1= actionOperator tl= parameters |op= 'exit-module' |op= 'log' |op= INIT |op= MAIN |op= EVENT |p= declarationOrCallWithTerms )
			int alt38=7;
			switch ( input.LA(1) ) {
			case CONST:
				{
				int LA38_1 = input.LA(2);
				if ( (LA38_1==STOP) ) {
					int LA38_8 = input.LA(3);
					if ( (LA38_8==67||(LA38_8 >= 71 && LA38_8 <= 72)||LA38_8==78||LA38_8==80||LA38_8==86||(LA38_8 >= 89 && LA38_8 <= 90)) ) {
						alt38=1;
					}
					else if ( (LA38_8==CURLYCLOSE||LA38_8==IF||LA38_8==77||LA38_8==79) ) {
						alt38=7;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 38, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA38_1==OPEN||LA38_1==PLUS) ) {
					alt38=7;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 1, input);
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
				alt38=1;
				}
				break;
			case 80:
				{
				int LA38_3 = input.LA(2);
				if ( (LA38_3==OPEN) ) {
					alt38=1;
				}
				else if ( (LA38_3==PLUS||LA38_3==STOP) ) {
					alt38=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 74:
				{
				alt38=2;
				}
				break;
			case INIT:
				{
				alt38=4;
				}
				break;
			case MAIN:
				{
				alt38=5;
				}
				break;
			case EVENT:
				{
				alt38=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}
			switch (alt38) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:213:4: ( selector STOP )? d1= actionOperator tl= parameters
					{
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:213:4: ( selector STOP )?
					int alt37=2;
					int LA37_0 = input.LA(1);
					if ( (LA37_0==CONST||LA37_0==VAR||(LA37_0 >= 68 && LA37_0 <= 69)||LA37_0==88||(LA37_0 >= 91 && LA37_0 <= 93)) ) {
						alt37=1;
					}
					switch (alt37) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:213:5: selector STOP
							{
							pushFollow(FOLLOW_selector_in_action1072);
							selector();
							state._fsp--;

							match(input,STOP,FOLLOW_STOP_in_action1074); 
							}
							break;

					}

					pushFollow(FOLLOW_actionOperator_in_action1080);
					d1=actionOperator();
					state._fsp--;

					pushFollow(FOLLOW_parameters_in_action1084);
					tl=parameters();
					state._fsp--;

					d1.addParams(tl); d =d1;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:215:4: op= 'exit-module'
					{
					op=(Token)match(input,74,FOLLOW_74_in_action1096); 
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:216:4: op= 'log'
					{
					op=(Token)match(input,80,FOLLOW_80_in_action1105); 
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:217:4: op= INIT
					{
					op=(Token)match(input,INIT,FOLLOW_INIT_in_action1114); 
					}
					break;
				case 5 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:218:4: op= MAIN
					{
					op=(Token)match(input,MAIN,FOLLOW_MAIN_in_action1123); 
					}
					break;
				case 6 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:219:4: op= EVENT
					{
					op=(Token)match(input,EVENT,FOLLOW_EVENT_in_action1132); 
					}
					break;
				case 7 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:220:4: p= declarationOrCallWithTerms
					{
					pushFollow(FOLLOW_declarationOrCallWithTerms_in_action1139);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:223:1: actionOperator returns [Abstract_Deed d] : (op= 'adopt' |op= 'drop' |op= 'insert' |op= 'delete' |op= 'send' |op= 'sendonce' |op= 'print' |op= 'log' );
	public final Abstract_Deed actionOperator() throws RecognitionException {
		Abstract_Deed d = null;


		Token op=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:224:2: (op= 'adopt' |op= 'drop' |op= 'insert' |op= 'delete' |op= 'send' |op= 'sendonce' |op= 'print' |op= 'log' )
			int alt39=8;
			switch ( input.LA(1) ) {
			case 67:
				{
				alt39=1;
				}
				break;
			case 72:
				{
				alt39=2;
				}
				break;
			case 78:
				{
				alt39=3;
				}
				break;
			case 71:
				{
				alt39=4;
				}
				break;
			case 89:
				{
				alt39=5;
				}
				break;
			case 90:
				{
				alt39=6;
				}
				break;
			case 86:
				{
				alt39=7;
				}
				break;
			case 80:
				{
				alt39=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}
			switch (alt39) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:224:4: op= 'adopt'
					{
					op=(Token)match(input,67,FOLLOW_67_in_actionOperator1160); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:225:4: op= 'drop'
					{
					op=(Token)match(input,72,FOLLOW_72_in_actionOperator1169); 
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:226:4: op= 'insert'
					{
					op=(Token)match(input,78,FOLLOW_78_in_actionOperator1178); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, Abstract_BaseAILStructure.AILBel);
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:227:4: op= 'delete'
					{
					op=(Token)match(input,71,FOLLOW_71_in_actionOperator1189); 
					d = new Abstract_Deed(Abstract_BaseAILStructure.AILDeletion, Abstract_BaseAILStructure.AILBel);
					}
					break;
				case 5 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:228:4: op= 'send'
					{
					op=(Token)match(input,89,FOLLOW_89_in_actionOperator1201); 
					}
					break;
				case 6 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:229:4: op= 'sendonce'
					{
					op=(Token)match(input,90,FOLLOW_90_in_actionOperator1210); 
					}
					break;
				case 7 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:230:4: op= 'print'
					{
					op=(Token)match(input,86,FOLLOW_86_in_actionOperator1219); 
					d = new Abstract_Deed(new Abstract_PrintAction());
					}
					break;
				case 8 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:231:4: op= 'log'
					{
					op=(Token)match(input,80,FOLLOW_80_in_actionOperator1230); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:235:1: selector : ( word |op= 'all' |op= 'allother' |op= 'self' |op= 'some' |op= 'someother' |op= 'this' );
	public final void selector() throws RecognitionException {
		Token op=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:236:2: ( word |op= 'all' |op= 'allother' |op= 'self' |op= 'some' |op= 'someother' |op= 'this' )
			int alt40=7;
			switch ( input.LA(1) ) {
			case CONST:
			case VAR:
				{
				alt40=1;
				}
				break;
			case 68:
				{
				alt40=2;
				}
				break;
			case 69:
				{
				alt40=3;
				}
				break;
			case 88:
				{
				alt40=4;
				}
				break;
			case 91:
				{
				alt40=5;
				}
				break;
			case 92:
				{
				alt40=6;
				}
				break;
			case 93:
				{
				alt40=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}
			switch (alt40) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:236:4: word
					{
					pushFollow(FOLLOW_word_in_selector1242);
					word();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:237:4: op= 'all'
					{
					op=(Token)match(input,68,FOLLOW_68_in_selector1251); 
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:238:4: op= 'allother'
					{
					op=(Token)match(input,69,FOLLOW_69_in_selector1260); 
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:239:4: op= 'self'
					{
					op=(Token)match(input,88,FOLLOW_88_in_selector1269); 
					}
					break;
				case 5 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:240:4: op= 'some'
					{
					op=(Token)match(input,91,FOLLOW_91_in_selector1278); 
					}
					break;
				case 6 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:241:4: op= 'someother'
					{
					op=(Token)match(input,92,FOLLOW_92_in_selector1287); 
					}
					break;
				case 7 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:242:4: op= 'this'
					{
					op=(Token)match(input,93,FOLLOW_93_in_selector1296); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:245:1: actionSpecs returns [ArrayList<Abstract_ActionSpec> as] : ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE ;
	public final ArrayList<Abstract_ActionSpec> actionSpecs() throws RecognitionException {
		ArrayList<Abstract_ActionSpec> as = null;


		Abstract_ActionSpec a =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:246:2: ( ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:246:4: ACTIONSPEC CURLYOPEN (a= actionSpec )+ CURLYCLOSE
			{
			as = new ArrayList<Abstract_ActionSpec>();
			match(input,ACTIONSPEC,FOLLOW_ACTIONSPEC_in_actionSpecs1315); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionSpecs1317); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:247:23: (a= actionSpec )+
			int cnt41=0;
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==CONST) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:247:24: a= actionSpec
					{
					pushFollow(FOLLOW_actionSpec_in_actionSpecs1322);
					a=actionSpec();
					state._fsp--;

					as.add(a);
					}
					break;

				default :
					if ( cnt41 >= 1 ) break loop41;
					EarlyExitException eee = new EarlyExitException(41, input);
					throw eee;
				}
				cnt41++;
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionSpecs1328); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:250:1: actionSpec returns [Abstract_ActionSpec as] : cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE ;
	public final Abstract_ActionSpec actionSpec() throws RecognitionException {
		Abstract_ActionSpec as = null;


		Abstract_Predicate cap =null;
		Abstract_LogicalFormula pre =null;
		Abstract_LogicalFormula post =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:251:2: (cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:251:4: cap= declarationOrCallWithTerms ( INTERNAL | EXTERNAL )? CURLYOPEN pre= precondition post= postcondition CURLYCLOSE
			{
			pushFollow(FOLLOW_declarationOrCallWithTerms_in_actionSpec1345);
			cap=declarationOrCallWithTerms();
			state._fsp--;

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:251:35: ( INTERNAL | EXTERNAL )?
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==EXTERNAL||LA42_0==INTERNAL) ) {
				alt42=1;
			}
			switch (alt42) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
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

			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_actionSpec1358); 
			pushFollow(FOLLOW_precondition_in_actionSpec1362);
			pre=precondition();
			state._fsp--;

			pushFollow(FOLLOW_postcondition_in_actionSpec1366);
			post=postcondition();
			state._fsp--;

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_actionSpec1368); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:256:1: precondition returns [Abstract_LogicalFormula f] : PRE CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE ;
	public final Abstract_LogicalFormula precondition() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		ArrayList<Abstract_LogicalFormula> tl =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:257:2: ( PRE CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:257:4: PRE CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE
			{
			match(input,PRE,FOLLOW_PRE_in_precondition1386); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_precondition1388); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:257:19: ( TRUE |tl= no_bracket_literals )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==TRUE) ) {
				alt43=1;
			}
			else if ( (LA43_0==CONST||LA43_0==MINUS||(LA43_0 >= NOT && LA43_0 <= NUMBER)||(LA43_0 >= UNNAMEDVAR && LA43_0 <= VAR)) ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:257:20: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_precondition1392); 
					f = new Abstract_LogExpr();
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:258:4: tl= no_bracket_literals
					{
					pushFollow(FOLLOW_no_bracket_literals_in_precondition1402);
					tl=no_bracket_literals();
					state._fsp--;

					f = new Abstract_LogExpr(tl);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_precondition1407); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:261:1: postcondition returns [Abstract_LogicalFormula f] : POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE ;
	public final Abstract_LogicalFormula postcondition() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		ArrayList<Abstract_LogicalFormula> tl =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:262:2: ( POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:262:4: POST CURLYOPEN ( TRUE |tl= no_bracket_literals ) CURLYCLOSE
			{
			match(input,POST,FOLLOW_POST_in_postcondition1422); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_postcondition1425); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:263:2: ( TRUE |tl= no_bracket_literals )
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==TRUE) ) {
				alt44=1;
			}
			else if ( (LA44_0==CONST||LA44_0==MINUS||(LA44_0 >= NOT && LA44_0 <= NUMBER)||(LA44_0 >= UNNAMEDVAR && LA44_0 <= VAR)) ) {
				alt44=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}

			switch (alt44) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:263:3: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_postcondition1429); 
					f = new Abstract_LogExpr();
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:264:4: tl= no_bracket_literals
					{
					pushFollow(FOLLOW_no_bracket_literals_in_postcondition1439);
					tl=no_bracket_literals();
					state._fsp--;


							f = new Abstract_LogExpr(tl);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_postcondition1448); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:270:1: declaration returns [Abstract_Predicate p] : f= id (tl= parameters )? ;
	public final Abstract_Predicate declaration() throws RecognitionException {
		Abstract_Predicate p = null;


		String f =null;
		ArrayList<Abstract_Term> tl =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:271:2: (f= id (tl= parameters )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:271:4: f= id (tl= parameters )?
			{
			pushFollow(FOLLOW_id_in_declaration1465);
			f=id();
			state._fsp--;

			p= new Abstract_Predicate(f);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:271:41: (tl= parameters )?
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==OPEN) ) {
				alt45=1;
			}
			switch (alt45) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:271:42: tl= parameters
					{
					pushFollow(FOLLOW_parameters_in_declaration1472);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:274:1: declarationOrCallWithTerms returns [Abstract_Predicate p] : f= function_term ;
	public final Abstract_Predicate declarationOrCallWithTerms() throws RecognitionException {
		Abstract_Predicate p = null;


		Abstract_Term f =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:275:2: (f= function_term )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:275:4: f= function_term
			{
			pushFollow(FOLLOW_function_term_in_declarationOrCallWithTerms1493);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:278:1: id returns [String s] : ( CONST | VAR ) ;
	public final String id() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:279:2: ( ( CONST | VAR ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:279:4: ( CONST | VAR )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:279:4: ( CONST | VAR )
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==CONST) ) {
				alt46=1;
			}
			else if ( (LA46_0==VAR) ) {
				alt46=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}

			switch (alt46) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:279:5: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_id1512); 
					s = CONST1.getText();
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:280:4: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_id1519); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:284:1: parameters returns [ArrayList<Abstract_Term>ts] : OPEN t= term ( COMMA t1= term )* CLOSE ;
	public final ArrayList<Abstract_Term> parameters() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:285:2: ( OPEN t= term ( COMMA t1= term )* CLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:285:4: OPEN t= term ( COMMA t1= term )* CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_parameters1542); 
			pushFollow(FOLLOW_term_in_parameters1546);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:286:2: ( COMMA t1= term )*
			loop47:
			while (true) {
				int alt47=2;
				int LA47_0 = input.LA(1);
				if ( (LA47_0==COMMA) ) {
					alt47=1;
				}

				switch (alt47) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:286:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_parameters1552); 
					pushFollow(FOLLOW_term_in_parameters1556);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop47;
				}
			}

			match(input,CLOSE,FOLLOW_CLOSE_in_parameters1564); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:290:1: no_bracket_parameters returns [ArrayList<Abstract_Term>ts] : t= term ( COMMA t1= term )* ;
	public final ArrayList<Abstract_Term> no_bracket_parameters() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:291:2: (t= term ( COMMA t1= term )* )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:291:5: t= term ( COMMA t1= term )*
			{
			pushFollow(FOLLOW_term_in_no_bracket_parameters1586);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:292:2: ( COMMA t1= term )*
			loop48:
			while (true) {
				int alt48=2;
				int LA48_0 = input.LA(1);
				if ( (LA48_0==COMMA) ) {
					alt48=1;
				}

				switch (alt48) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:292:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_no_bracket_parameters1592); 
					pushFollow(FOLLOW_term_in_no_bracket_parameters1596);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop48;
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:296:1: no_bracket_literals returns [ArrayList<Abstract_LogicalFormula>ts] : ( ( NOT OPEN t= atom CLOSE ) |t= atom ) ( COMMA ( NOT OPEN t1= atom CLOSE |t1= atom ) )* ;
	public final ArrayList<Abstract_LogicalFormula> no_bracket_literals() throws RecognitionException {
		ArrayList<Abstract_LogicalFormula> ts = null;


		Abstract_LogicalFormula t =null;
		Abstract_LogicalFormula t1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:297:2: ( ( ( NOT OPEN t= atom CLOSE ) |t= atom ) ( COMMA ( NOT OPEN t1= atom CLOSE |t1= atom ) )* )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:297:5: ( ( NOT OPEN t= atom CLOSE ) |t= atom ) ( COMMA ( NOT OPEN t1= atom CLOSE |t1= atom ) )*
			{
			ArrayList<Abstract_LogicalFormula> tl = new ArrayList<Abstract_LogicalFormula>();
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:298:2: ( ( NOT OPEN t= atom CLOSE ) |t= atom )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==NOT) ) {
				alt49=1;
			}
			else if ( (LA49_0==CONST||LA49_0==MINUS||LA49_0==NUMBER||(LA49_0 >= UNNAMEDVAR && LA49_0 <= VAR)) ) {
				alt49=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}

			switch (alt49) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:298:3: ( NOT OPEN t= atom CLOSE )
					{
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:298:3: ( NOT OPEN t= atom CLOSE )
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:298:4: NOT OPEN t= atom CLOSE
					{
					match(input,NOT,FOLLOW_NOT_in_no_bracket_literals1626); 
					match(input,OPEN,FOLLOW_OPEN_in_no_bracket_literals1628); 
					pushFollow(FOLLOW_atom_in_no_bracket_literals1632);
					t=atom();
					state._fsp--;

					Abstract_LogExpr l=new Abstract_LogExpr(Abstract_LogExpr.not, t); tl.add(l);
					match(input,CLOSE,FOLLOW_CLOSE_in_no_bracket_literals1636); 
					}

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:299:4: t= atom
					{
					pushFollow(FOLLOW_atom_in_no_bracket_literals1644);
					t=atom();
					state._fsp--;

					 tl.add(t);
					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:300:2: ( COMMA ( NOT OPEN t1= atom CLOSE |t1= atom ) )*
			loop51:
			while (true) {
				int alt51=2;
				int LA51_0 = input.LA(1);
				if ( (LA51_0==COMMA) ) {
					alt51=1;
				}

				switch (alt51) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:300:3: COMMA ( NOT OPEN t1= atom CLOSE |t1= atom )
					{
					match(input,COMMA,FOLLOW_COMMA_in_no_bracket_literals1651); 
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:300:9: ( NOT OPEN t1= atom CLOSE |t1= atom )
					int alt50=2;
					int LA50_0 = input.LA(1);
					if ( (LA50_0==NOT) ) {
						alt50=1;
					}
					else if ( (LA50_0==CONST||LA50_0==MINUS||LA50_0==NUMBER||(LA50_0 >= UNNAMEDVAR && LA50_0 <= VAR)) ) {
						alt50=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 50, 0, input);
						throw nvae;
					}

					switch (alt50) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:300:10: NOT OPEN t1= atom CLOSE
							{
							match(input,NOT,FOLLOW_NOT_in_no_bracket_literals1654); 
							match(input,OPEN,FOLLOW_OPEN_in_no_bracket_literals1656); 
							pushFollow(FOLLOW_atom_in_no_bracket_literals1660);
							t1=atom();
							state._fsp--;

							Abstract_LogExpr l=new Abstract_LogExpr(Abstract_LogExpr.not, t1); tl.add(l);
							match(input,CLOSE,FOLLOW_CLOSE_in_no_bracket_literals1664); 
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:301:4: t1= atom
							{
							pushFollow(FOLLOW_atom_in_no_bracket_literals1673);
							t1=atom();
							state._fsp--;

							tl.add(t1);
							}
							break;

					}

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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:306:1: goal_list returns [ArrayList<Abstract_Term>ts] : t= term ( COMMA t1= term )* STOP ;
	public final ArrayList<Abstract_Term> goal_list() throws RecognitionException {
		ArrayList<Abstract_Term> ts = null;


		Abstract_Term t =null;
		Abstract_Term t1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:307:2: (t= term ( COMMA t1= term )* STOP )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:307:4: t= term ( COMMA t1= term )* STOP
			{
			pushFollow(FOLLOW_term_in_goal_list1701);
			t=term();
			state._fsp--;

			ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:308:2: ( COMMA t1= term )*
			loop52:
			while (true) {
				int alt52=2;
				int LA52_0 = input.LA(1);
				if ( (LA52_0==COMMA) ) {
					alt52=1;
				}

				switch (alt52) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:308:3: COMMA t1= term
					{
					match(input,COMMA,FOLLOW_COMMA_in_goal_list1708); 
					pushFollow(FOLLOW_term_in_goal_list1712);
					t1=term();
					state._fsp--;

					tl.add(t1);
					}
					break;

				default :
					break loop52;
				}
			}

			match(input,STOP,FOLLOW_STOP_in_goal_list1719); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:353:1: term returns [Abstract_Term t] : (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) ;
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_StringTerm st =null;
		Abstract_Term ft =null;
		Abstract_NumberTerm at =null;
		Abstract_ListTermImpl lt =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:354:2: ( (st= stringterm |ft= function_term |at= arithexpr |lt= listterm ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:354:4: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:354:4: (st= stringterm |ft= function_term |at= arithexpr |lt= listterm )
			int alt53=4;
			switch ( input.LA(1) ) {
			case STRING:
				{
				alt53=1;
				}
				break;
			case CONST:
				{
				alt53=2;
				}
				break;
			case MINUS:
			case NUMBER:
			case UNNAMEDVAR:
			case VAR:
				{
				alt53=3;
				}
				break;
			case SQOPEN:
				{
				alt53=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 53, 0, input);
				throw nvae;
			}
			switch (alt53) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:354:5: st= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term2005);
					st=stringterm();
					state._fsp--;

					t = st;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:355:4: ft= function_term
					{
					pushFollow(FOLLOW_function_term_in_term2015);
					ft=function_term();
					state._fsp--;

					t =ft;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:356:4: at= arithexpr
					{
					pushFollow(FOLLOW_arithexpr_in_term2025);
					at=arithexpr();
					state._fsp--;

					t =at;
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:357:4: lt= listterm
					{
					pushFollow(FOLLOW_listterm_in_term2034);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:359:1: function_term returns [Abstract_Term t] : c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? ;
	public final Abstract_Term function_term() throws RecognitionException {
		Abstract_Term t = null;


		Token c=null;
		Abstract_Term t1 =null;
		Abstract_Term t2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:360:2: (c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:360:4: c= CONST ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			{
			c=(Token)match(input,CONST,FOLLOW_CONST_in_function_term2052); 
			t=new Abstract_Predicate(c.getText());
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:361:2: ( OPEN t1= term ( COMMA t2= term )* CLOSE )?
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==OPEN) ) {
				alt55=1;
			}
			switch (alt55) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:361:3: OPEN t1= term ( COMMA t2= term )* CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function_term2059); 
					pushFollow(FOLLOW_term_in_function_term2063);
					t1=term();
					state._fsp--;

					((Abstract_Predicate) t).addTerm(t1);
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:362:2: ( COMMA t2= term )*
					loop54:
					while (true) {
						int alt54=2;
						int LA54_0 = input.LA(1);
						if ( (LA54_0==COMMA) ) {
							alt54=1;
						}

						switch (alt54) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:362:3: COMMA t2= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_function_term2070); 
							pushFollow(FOLLOW_term_in_function_term2074);
							t2=term();
							state._fsp--;

							((Abstract_Predicate) t).addTerm(t2);
							}
							break;

						default :
							break loop54;
						}
					}

					match(input,CLOSE,FOLLOW_CLOSE_in_function_term2080); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:366:1: var returns [Abstract_VarTerm v] : ( VAR | UNNAMEDVAR ) ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR3=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:367:2: ( ( VAR | UNNAMEDVAR ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:367:4: ( VAR | UNNAMEDVAR )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:367:4: ( VAR | UNNAMEDVAR )
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==VAR) ) {
				alt56=1;
			}
			else if ( (LA56_0==UNNAMEDVAR) ) {
				alt56=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 56, 0, input);
				throw nvae;
			}

			switch (alt56) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:367:5: VAR
					{
					VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_var2100); 
					if (variables.containsKey(VAR3.getText())) {
							v = variables.get(VAR3.getText());
						            } else {
							v = new Abstract_VarTerm(VAR3.getText());
					                                                     variables.put(VAR3.getText(), v);
						           }
						
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:373:6: UNNAMEDVAR
					{
					match(input,UNNAMEDVAR,FOLLOW_UNNAMEDVAR_in_var2106); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:375:1: stringLiteral returns [Abstract_StringTerm s] : st= stringterm ;
	public final Abstract_StringTerm stringLiteral() throws RecognitionException {
		Abstract_StringTerm s = null;


		Abstract_StringTerm st =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:376:2: (st= stringterm )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:376:4: st= stringterm
			{
			pushFollow(FOLLOW_stringterm_in_stringLiteral2124);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:377:1: singleQuotedStringLiteral returns [Abstract_StringTerm s] : SINGLEQUOTE w= word SINGLEQUOTE ;
	public final Abstract_StringTerm singleQuotedStringLiteral() throws RecognitionException {
		Abstract_StringTerm s = null;


		String w =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:378:2: ( SINGLEQUOTE w= word SINGLEQUOTE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:378:4: SINGLEQUOTE w= word SINGLEQUOTE
			{
			match(input,SINGLEQUOTE,FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2138); 
			pushFollow(FOLLOW_word_in_singleQuotedStringLiteral2142);
			w=word();
			state._fsp--;

			match(input,SINGLEQUOTE,FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2144); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:380:1: stringterm returns [Abstract_StringTerm s] : STRING ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING4=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:381:2: ( STRING )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:381:4: STRING
			{
			STRING4=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm2161); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:384:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST5=null;
		Token VAR6=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:384:25: ( ( CONST | VAR ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:384:27: ( CONST | VAR )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:384:27: ( CONST | VAR )
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==CONST) ) {
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
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:384:28: CONST
					{
					CONST5=(Token)match(input,CONST,FOLLOW_CONST_in_word2178); 
					s =CONST5.getText();
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:384:59: VAR
					{
					VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_word2184); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:386:1: listterm returns [Abstract_ListTermImpl l] : SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE ;
	public final Abstract_ListTermImpl listterm() throws RecognitionException {
		Abstract_ListTermImpl l = null;


		Token v=null;
		Abstract_Term h =null;
		Abstract_Term t =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:387:3: ( SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:387:5: SQOPEN (h= term ( COMMA t= term )* ( BAR v= VAR )? )? SQCLOSE
			{
			l = new Abstract_ListTermImpl(); Abstract_ListTerm lrunning = l;
			match(input,SQOPEN,FOLLOW_SQOPEN_in_listterm2205); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:388:10: (h= term ( COMMA t= term )* ( BAR v= VAR )? )?
			int alt60=2;
			int LA60_0 = input.LA(1);
			if ( (LA60_0==CONST||LA60_0==MINUS||LA60_0==NUMBER||LA60_0==SQOPEN||LA60_0==STRING||(LA60_0 >= UNNAMEDVAR && LA60_0 <= VAR)) ) {
				alt60=1;
			}
			switch (alt60) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:388:11: h= term ( COMMA t= term )* ( BAR v= VAR )?
					{
					pushFollow(FOLLOW_term_in_listterm2210);
					h=term();
					state._fsp--;

					l.addHead(h); l.addTail(new Abstract_ListTermImpl());
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:389:3: ( COMMA t= term )*
					loop58:
					while (true) {
						int alt58=2;
						int LA58_0 = input.LA(1);
						if ( (LA58_0==COMMA) ) {
							alt58=1;
						}

						switch (alt58) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:389:4: COMMA t= term
							{
							match(input,COMMA,FOLLOW_COMMA_in_listterm2217); 
							pushFollow(FOLLOW_term_in_listterm2221);
							t=term();
							state._fsp--;

							Abstract_ListTerm l2 = new Abstract_ListTermImpl(); l2.addHead(t); l2.addTail(new Abstract_ListTermImpl()); lrunning.addTail(l2); lrunning=l2;
							}
							break;

						default :
							break loop58;
						}
					}

					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:390:3: ( BAR v= VAR )?
					int alt59=2;
					int LA59_0 = input.LA(1);
					if ( (LA59_0==BAR) ) {
						alt59=1;
					}
					switch (alt59) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:390:4: BAR v= VAR
							{
							match(input,BAR,FOLLOW_BAR_in_listterm2230); 
							v=(Token)match(input,VAR,FOLLOW_VAR_in_listterm2234); 
							lrunning.addTail(new Abstract_VarTerm(v.getText()));
							}
							break;

					}

					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_listterm2246); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:394:1: equation returns [Abstract_Equation e] : a1= arithexpr i= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation e = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:395:2: (a1= arithexpr i= eqoper a2= arithexpr )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:395:4: a1= arithexpr i= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation2264);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation2268);
			i=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation2272);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:398:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:399:2: ( ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:399:4: ( MINUS )? (n1= NUMBER ( STOP n2= NUMBER )? )
			{
			s = "";
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:399:15: ( MINUS )?
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==MINUS) ) {
				alt61=1;
			}
			switch (alt61) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:399:16: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring2292); 
					s += "-";
					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:400:2: (n1= NUMBER ( STOP n2= NUMBER )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:400:3: n1= NUMBER ( STOP n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2303); 
			s += n1.getText();
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:401:2: ( STOP n2= NUMBER )?
			int alt62=2;
			int LA62_0 = input.LA(1);
			if ( (LA62_0==STOP) ) {
				int LA62_1 = input.LA(2);
				if ( (LA62_1==NUMBER) ) {
					alt62=1;
				}
			}
			switch (alt62) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:401:3: STOP n2= NUMBER
					{
					match(input,STOP,FOLLOW_STOP_in_numberstring2309); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2315); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:403:1: arithexpr returns [Abstract_NumberTerm ae] : a1= multexpr (i= addoper a2= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:404:2: (a1= multexpr (i= addoper a2= multexpr )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:404:4: a1= multexpr (i= addoper a2= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr2335);
			a1=multexpr();
			state._fsp--;

			ae = a1;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:404:28: (i= addoper a2= multexpr )?
			int alt63=2;
			int LA63_0 = input.LA(1);
			if ( (LA63_0==MINUS||LA63_0==PLUS) ) {
				alt63=1;
			}
			switch (alt63) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:404:29: i= addoper a2= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr2342);
					i=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr2346);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:405:1: multexpr returns [Abstract_NumberTerm ae] : a1= atom_term (i= multoper a2= atom_term )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm ae = null;


		Abstract_NumberTerm a1 =null;
		int i =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:406:2: (a1= atom_term (i= multoper a2= atom_term )? )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:406:4: a1= atom_term (i= multoper a2= atom_term )?
			{
			pushFollow(FOLLOW_atom_term_in_multexpr2364);
			a1=atom_term();
			state._fsp--;

			ae = a1;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:406:28: (i= multoper a2= atom_term )?
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==DIV||LA64_0==MULT) ) {
				alt64=1;
			}
			switch (alt64) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:406:29: i= multoper a2= atom_term
					{
					pushFollow(FOLLOW_multoper_in_multexpr2370);
					i=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_term_in_multexpr2374);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:408:1: atom_term returns [Abstract_NumberTerm t] : (n= numberstring |v= var ) ;
	public final Abstract_NumberTerm atom_term() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:409:2: ( (n= numberstring |v= var ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:409:4: (n= numberstring |v= var )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:409:4: (n= numberstring |v= var )
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==MINUS||LA65_0==NUMBER) ) {
				alt65=1;
			}
			else if ( ((LA65_0 >= UNNAMEDVAR && LA65_0 <= VAR)) ) {
				alt65=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 65, 0, input);
				throw nvae;
			}

			switch (alt65) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:409:5: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom_term2396);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:409:66: v= var
					{
					pushFollow(FOLLOW_var_in_atom_term2404);
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:412:1: addoper returns [int i] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:413:2: ( ( PLUS | MINUS ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:413:4: ( PLUS | MINUS )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:413:4: ( PLUS | MINUS )
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==PLUS) ) {
				alt66=1;
			}
			else if ( (LA66_0==MINUS) ) {
				alt66=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 66, 0, input);
				throw nvae;
			}

			switch (alt66) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:413:5: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper2423); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:413:22: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper2429); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:414:1: multoper returns [int i] : ( MULT | DIV ) ;
	public final int multoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:2: ( ( MULT | DIV ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:4: ( MULT | DIV )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:4: ( MULT | DIV )
			int alt67=2;
			int LA67_0 = input.LA(1);
			if ( (LA67_0==MULT) ) {
				alt67=1;
			}
			else if ( (LA67_0==DIV) ) {
				alt67=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 67, 0, input);
				throw nvae;
			}

			switch (alt67) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:5: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper2446); 
					i = 3;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:415:22: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper2452); 
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
	// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:1: eqoper returns [int i] : ( LESS | ( IS | EQUALS ) ) ;
	public final int eqoper() throws RecognitionException {
		int i = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:24: ( ( LESS | ( IS | EQUALS ) ) )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:26: ( LESS | ( IS | EQUALS ) )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:26: ( LESS | ( IS | EQUALS ) )
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==LESS) ) {
				alt68=1;
			}
			else if ( (LA68_0==EQUALS||LA68_0==IS) ) {
				alt68=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 68, 0, input);
				throw nvae;
			}

			switch (alt68) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:27: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2468); 
					i = 1;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:416:44: ( IS | EQUALS )
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
	public static final BitSet FOLLOW_64_in_moduleImport116 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_MODULEFILE_in_moduleImport118 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_moduleImport120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_moduleDef_in_module137 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_SQOPEN_in_module142 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001200L});
	public static final BitSet FOLLOW_moduleOption_in_module144 = new BitSet(new long[]{0x0080000000001000L});
	public static final BitSet FOLLOW_COMMA_in_module148 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001200L});
	public static final BitSet FOLLOW_moduleOption_in_module150 = new BitSet(new long[]{0x0080000000001000L});
	public static final BitSet FOLLOW_SQCLOSE_in_module155 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_module160 = new BitSet(new long[]{0x0002000082008210L,0x0000000000000001L});
	public static final BitSet FOLLOW_krImport_in_module162 = new BitSet(new long[]{0x0002000082008210L});
	public static final BitSet FOLLOW_knowledge_in_module165 = new BitSet(new long[]{0x0002000002008210L});
	public static final BitSet FOLLOW_beliefs_in_module170 = new BitSet(new long[]{0x0002000002008010L});
	public static final BitSet FOLLOW_goals_in_module174 = new BitSet(new long[]{0x0002000000008010L});
	public static final BitSet FOLLOW_program_in_module178 = new BitSet(new long[]{0x0000000000008010L});
	public static final BitSet FOLLOW_actionSpecs_in_module187 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_module195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef210 = new BitSet(new long[]{0x4000000000004000L});
	public static final BitSet FOLLOW_declaration_in_moduleDef212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INIT_in_moduleDef217 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_moduleDef226 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EVENT_in_moduleDef235 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_MODULE_in_moduleDef237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_73_in_moduleOption256 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_EQUALS_in_moduleOption258 = new BitSet(new long[]{0x0000000000000000L,0x00000000001A0040L});
	public static final BitSet FOLLOW_70_in_moduleOption265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_81_in_moduleOption275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_moduleOption285 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_83_in_moduleOption296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_moduleOption310 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_EQUALS_in_moduleOption312 = new BitSet(new long[]{0x0000000000000000L,0x0000000000A40800L});
	public static final BitSet FOLLOW_set_in_moduleOption318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_krImport343 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_stringLiteral_in_krImport346 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_singleQuotedStringLiteral_in_krImport350 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_krImport353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KNOWLEDGE_in_knowledge366 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_knowledge368 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_krspec_in_knowledge370 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_knowledge373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_krspec385 = new BitSet(new long[]{0x0204000000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec389 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_krspec396 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_krspec400 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_krspec402 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_BELIEFS_in_beliefs418 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_beliefs420 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_brspec_in_beliefs422 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_beliefs425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_brspec437 = new BitSet(new long[]{0x0204000000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec441 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_PROLOGARROW_in_brspec448 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_brspec452 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_brspec454 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_GOALS_in_goals471 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_goals473 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_goal_list_in_goals477 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_goals481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_atom497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_atom506 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROGRAM_in_program521 = new BitSet(new long[]{0x0100000000010000L});
	public static final BitSet FOLLOW_SQOPEN_in_program524 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_ruleEvaluationOrder_in_program528 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_program532 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_program538 = new BitSet(new long[]{0x000000000C008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_macroDef_in_program540 = new BitSet(new long[]{0x000000000C008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_programRule_in_program543 = new BitSet(new long[]{0x0000000008008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_program547 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_in_ruleEvaluationOrder564 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_EQUALS_in_ruleEvaluationOrder566 = new BitSet(new long[]{0x0018000600000020L});
	public static final BitSet FOLLOW_LINEAR_in_ruleEvaluationOrder570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LINEARALL_in_ruleEvaluationOrder577 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANDOM_in_ruleEvaluationOrder583 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANDOMALL_in_ruleEvaluationOrder589 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADAPTIVE_in_ruleEvaluationOrder596 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HASH_in_macroDef610 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_DEFINE_in_macroDef612 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_macroDef616 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstate_in_macroDef621 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_macroDef627 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_programRule641 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule645 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_THEN_in_programRule649 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule655 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule659 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule663 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_programRule672 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule674 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule676 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule679 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule681 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_programRule693 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_VAR_in_programRule695 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_programRule697 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule699 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule701 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule704 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule710 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_programRule719 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalstatecond_in_programRule721 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_programRule723 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_VAR_in_programRule725 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_DO_in_programRule727 = new BitSet(new long[]{0x4000001010214000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_actions_in_programRule730 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_programRule732 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nestedRules_in_programRule736 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURLYOPEN_in_nestedRules754 = new BitSet(new long[]{0x0000000008000000L,0x000000000000A000L});
	public static final BitSet FOLLOW_programRule_in_nestedRules756 = new BitSet(new long[]{0x0000000008008000L,0x000000000000A000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_nestedRules760 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_basicCondition_in_mentalstatecond778 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_mentalstatecond784 = new BitSet(new long[]{0x5000040001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_basicCondition_in_mentalstatecond788 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_mentalatom_in_mentalstate811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_mentalstate818 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_OPEN_in_mentalstate820 = new BitSet(new long[]{0x4000000001804140L,0x0000000039000030L});
	public static final BitSet FOLLOW_mentalatom_in_mentalstate822 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_mentalstate824 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_mentalstate829 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mentalstate_in_basicCondition849 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_basicCondition858 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selector_in_mentalatom878 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_mentalatom880 = new BitSet(new long[]{0x0000000001800140L});
	public static final BitSet FOLLOW_mentalOperator_in_mentalatom886 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_atom_parameters_in_mentalatom890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom_parameters909 = new BitSet(new long[]{0x6000182000004000L});
	public static final BitSet FOLLOW_atom_in_atom_parameters916 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_COMMA_in_atom_parameters922 = new BitSet(new long[]{0x6000082000004000L});
	public static final BitSet FOLLOW_atom_in_atom_parameters926 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_SEMI_in_atom_parameters933 = new BitSet(new long[]{0x6000082000004000L});
	public static final BitSet FOLLOW_atom_in_atom_parameters939 = new BitSet(new long[]{0x0020000000001400L});
	public static final BitSet FOLLOW_atom_parameters_in_atom_parameters956 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_atom_parameters964 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEL_in_mentalOperator985 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_mentalOperator996 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AGOAL_in_mentalOperator1007 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOALA_in_mentalOperator1018 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_actions1041 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_PLUS_in_actions1048 = new BitSet(new long[]{0x4000001010204000L,0x000000003F4145B8L});
	public static final BitSet FOLLOW_action_in_actions1052 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_selector_in_action1072 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STOP_in_action1074 = new BitSet(new long[]{0x0000000000000000L,0x0000000006414188L});
	public static final BitSet FOLLOW_actionOperator_in_action1080 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_parameters_in_action1084 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_74_in_action1096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_action1105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INIT_in_action1114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_action1123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EVENT_in_action1132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_action1139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_67_in_actionOperator1160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_actionOperator1169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_actionOperator1178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_actionOperator1189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_89_in_actionOperator1201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_90_in_actionOperator1210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_86_in_actionOperator1219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_actionOperator1230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_selector1242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_selector1251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_selector1260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_88_in_selector1269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_91_in_selector1278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_92_in_selector1287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_93_in_selector1296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACTIONSPEC_in_actionSpecs1315 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionSpecs1317 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_actionSpec_in_actionSpecs1322 = new BitSet(new long[]{0x000000000000C000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionSpecs1328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarationOrCallWithTerms_in_actionSpec1345 = new BitSet(new long[]{0x0000000020410000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_actionSpec1358 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_precondition_in_actionSpec1362 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_postcondition_in_actionSpec1366 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_actionSpec1368 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRE_in_precondition1386 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_precondition1388 = new BitSet(new long[]{0x70000C2000004000L});
	public static final BitSet FOLLOW_TRUE_in_precondition1392 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_precondition1402 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_precondition1407 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POST_in_postcondition1422 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_postcondition1425 = new BitSet(new long[]{0x70000C2000004000L});
	public static final BitSet FOLLOW_TRUE_in_postcondition1429 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_no_bracket_literals_in_postcondition1439 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_postcondition1448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_id_in_declaration1465 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_parameters_in_declaration1472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_declarationOrCallWithTerms1493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_id1512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_id1519 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_parameters1542 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_parameters1546 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_parameters1552 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_parameters1556 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_parameters1564 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_no_bracket_parameters1586 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_no_bracket_parameters1592 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_no_bracket_parameters1596 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_NOT_in_no_bracket_literals1626 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_OPEN_in_no_bracket_literals1628 = new BitSet(new long[]{0x6000082000004000L});
	public static final BitSet FOLLOW_atom_in_no_bracket_literals1632 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_no_bracket_literals1636 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_atom_in_no_bracket_literals1644 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_no_bracket_literals1651 = new BitSet(new long[]{0x60000C2000004000L});
	public static final BitSet FOLLOW_NOT_in_no_bracket_literals1654 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_OPEN_in_no_bracket_literals1656 = new BitSet(new long[]{0x6000082000004000L});
	public static final BitSet FOLLOW_atom_in_no_bracket_literals1660 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLOSE_in_no_bracket_literals1664 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_atom_in_no_bracket_literals1673 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_term_in_goal_list1701 = new BitSet(new long[]{0x0200000000001000L});
	public static final BitSet FOLLOW_COMMA_in_goal_list1708 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_goal_list1712 = new BitSet(new long[]{0x0200000000001000L});
	public static final BitSet FOLLOW_STOP_in_goal_list1719 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_term2005 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_term_in_term2015 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_term2025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listterm_in_term2034 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function_term2052 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_OPEN_in_function_term2059 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_function_term2063 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_COMMA_in_function_term2070 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_function_term2074 = new BitSet(new long[]{0x0000000000001400L});
	public static final BitSet FOLLOW_CLOSE_in_function_term2080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var2100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNNAMEDVAR_in_var2106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_stringLiteral2124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2138 = new BitSet(new long[]{0x4000000000004000L});
	public static final BitSet FOLLOW_word_in_singleQuotedStringLiteral2142 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SINGLEQUOTE_in_singleQuotedStringLiteral2144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_stringterm2161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_word2178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word2184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SQOPEN_in_listterm2205 = new BitSet(new long[]{0x6580082000004000L});
	public static final BitSet FOLLOW_term_in_listterm2210 = new BitSet(new long[]{0x0080000000001080L});
	public static final BitSet FOLLOW_COMMA_in_listterm2217 = new BitSet(new long[]{0x6500082000004000L});
	public static final BitSet FOLLOW_term_in_listterm2221 = new BitSet(new long[]{0x0080000000001080L});
	public static final BitSet FOLLOW_BAR_in_listterm2230 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_VAR_in_listterm2234 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_listterm2246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation2264 = new BitSet(new long[]{0x0000000140100000L});
	public static final BitSet FOLLOW_eqoper_in_equation2268 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_arithexpr_in_equation2272 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring2292 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2303 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_STOP_in_numberstring2309 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2315 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2335 = new BitSet(new long[]{0x0000402000000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr2342 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2364 = new BitSet(new long[]{0x0000010000040002L});
	public static final BitSet FOLLOW_multoper_in_multexpr2370 = new BitSet(new long[]{0x6000082000000000L});
	public static final BitSet FOLLOW_atom_term_in_multexpr2374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom_term2396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom_term2404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper2423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper2429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper2446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper2452 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_eqoper2474 = new BitSet(new long[]{0x0000000000000002L});
}
