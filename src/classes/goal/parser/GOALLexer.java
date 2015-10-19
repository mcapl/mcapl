// $ANTLR 3.5.1 /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g 2015-10-19 16:31:03

package goal.parser;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class GOALLexer extends Lexer {
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

	private boolean stringterm = false;


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public GOALLexer() {} 
	public GOALLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public GOALLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g"; }

	// $ANTLR start "T__64"
	public final void mT__64() throws RecognitionException {
		try {
			int _type = T__64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:9:7: ( '#import' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:9:9: '#import'
			{
			match("#import"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__64"

	// $ANTLR start "T__65"
	public final void mT__65() throws RecognitionException {
		try {
			int _type = T__65;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:10:7: ( '->' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:10:9: '->'
			{
			match("->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__65"

	// $ANTLR start "T__66"
	public final void mT__66() throws RecognitionException {
		try {
			int _type = T__66;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:11:7: ( '<-' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:11:9: '<-'
			{
			match("<-"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__66"

	// $ANTLR start "T__67"
	public final void mT__67() throws RecognitionException {
		try {
			int _type = T__67;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:12:7: ( 'adopt' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:12:9: 'adopt'
			{
			match("adopt"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__67"

	// $ANTLR start "T__68"
	public final void mT__68() throws RecognitionException {
		try {
			int _type = T__68;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:13:7: ( 'all' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:13:9: 'all'
			{
			match("all"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__68"

	// $ANTLR start "T__69"
	public final void mT__69() throws RecognitionException {
		try {
			int _type = T__69;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:14:7: ( 'allother' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:14:9: 'allother'
			{
			match("allother"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__69"

	// $ANTLR start "T__70"
	public final void mT__70() throws RecognitionException {
		try {
			int _type = T__70;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:15:7: ( 'always' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:15:9: 'always'
			{
			match("always"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__70"

	// $ANTLR start "T__71"
	public final void mT__71() throws RecognitionException {
		try {
			int _type = T__71;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:16:7: ( 'delete' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:16:9: 'delete'
			{
			match("delete"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__71"

	// $ANTLR start "T__72"
	public final void mT__72() throws RecognitionException {
		try {
			int _type = T__72;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:17:7: ( 'drop' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:17:9: 'drop'
			{
			match("drop"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__72"

	// $ANTLR start "T__73"
	public final void mT__73() throws RecognitionException {
		try {
			int _type = T__73;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:18:7: ( 'exit' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:18:9: 'exit'
			{
			match("exit"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__73"

	// $ANTLR start "T__74"
	public final void mT__74() throws RecognitionException {
		try {
			int _type = T__74;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:19:7: ( 'exit-module' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:19:9: 'exit-module'
			{
			match("exit-module"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__74"

	// $ANTLR start "T__75"
	public final void mT__75() throws RecognitionException {
		try {
			int _type = T__75;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:20:7: ( 'filter' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:20:9: 'filter'
			{
			match("filter"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__75"

	// $ANTLR start "T__76"
	public final void mT__76() throws RecognitionException {
		try {
			int _type = T__76;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:21:7: ( 'focus' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:21:9: 'focus'
			{
			match("focus"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__76"

	// $ANTLR start "T__77"
	public final void mT__77() throws RecognitionException {
		try {
			int _type = T__77;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:22:7: ( 'forall' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:22:9: 'forall'
			{
			match("forall"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__77"

	// $ANTLR start "T__78"
	public final void mT__78() throws RecognitionException {
		try {
			int _type = T__78;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:23:7: ( 'insert' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:23:9: 'insert'
			{
			match("insert"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__78"

	// $ANTLR start "T__79"
	public final void mT__79() throws RecognitionException {
		try {
			int _type = T__79;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:24:7: ( 'listall' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:24:9: 'listall'
			{
			match("listall"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__79"

	// $ANTLR start "T__80"
	public final void mT__80() throws RecognitionException {
		try {
			int _type = T__80;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:25:7: ( 'log' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:25:9: 'log'
			{
			match("log"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__80"

	// $ANTLR start "T__81"
	public final void mT__81() throws RecognitionException {
		try {
			int _type = T__81;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:26:7: ( 'never' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:26:9: 'never'
			{
			match("never"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__81"

	// $ANTLR start "T__82"
	public final void mT__82() throws RecognitionException {
		try {
			int _type = T__82;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:27:7: ( 'new' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:27:9: 'new'
			{
			match("new"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__82"

	// $ANTLR start "T__83"
	public final void mT__83() throws RecognitionException {
		try {
			int _type = T__83;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:28:7: ( 'noaction' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:28:9: 'noaction'
			{
			match("noaction"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__83"

	// $ANTLR start "T__84"
	public final void mT__84() throws RecognitionException {
		try {
			int _type = T__84;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:29:7: ( 'nogoals' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:29:9: 'nogoals'
			{
			match("nogoals"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__84"

	// $ANTLR start "T__85"
	public final void mT__85() throws RecognitionException {
		try {
			int _type = T__85;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:30:7: ( 'none' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:30:9: 'none'
			{
			match("none"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__85"

	// $ANTLR start "T__86"
	public final void mT__86() throws RecognitionException {
		try {
			int _type = T__86;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:31:7: ( 'print' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:31:9: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__86"

	// $ANTLR start "T__87"
	public final void mT__87() throws RecognitionException {
		try {
			int _type = T__87;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:32:7: ( 'select' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:32:9: 'select'
			{
			match("select"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__87"

	// $ANTLR start "T__88"
	public final void mT__88() throws RecognitionException {
		try {
			int _type = T__88;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:33:7: ( 'self' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:33:9: 'self'
			{
			match("self"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__88"

	// $ANTLR start "T__89"
	public final void mT__89() throws RecognitionException {
		try {
			int _type = T__89;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:34:7: ( 'send' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:34:9: 'send'
			{
			match("send"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__89"

	// $ANTLR start "T__90"
	public final void mT__90() throws RecognitionException {
		try {
			int _type = T__90;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:35:7: ( 'sendonce' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:35:9: 'sendonce'
			{
			match("sendonce"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__90"

	// $ANTLR start "T__91"
	public final void mT__91() throws RecognitionException {
		try {
			int _type = T__91;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:36:7: ( 'some' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:36:9: 'some'
			{
			match("some"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__91"

	// $ANTLR start "T__92"
	public final void mT__92() throws RecognitionException {
		try {
			int _type = T__92;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:37:7: ( 'someother' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:37:9: 'someother'
			{
			match("someother"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__92"

	// $ANTLR start "T__93"
	public final void mT__93() throws RecognitionException {
		try {
			int _type = T__93;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:38:7: ( 'this' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:38:9: 'this'
			{
			match("this"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__93"

	// $ANTLR start "MAIN"
	public final void mMAIN() throws RecognitionException {
		try {
			int _type = MAIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:314:6: ( 'main' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:314:8: 'main'
			{
			match("main"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAIN"

	// $ANTLR start "MODULEFILE"
	public final void mMODULEFILE() throws RecognitionException {
		try {
			int _type = MODULEFILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:315:12: ( '.mod2g' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:315:15: '.mod2g'
			{
			match(".mod2g"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MODULEFILE"

	// $ANTLR start "KNOWLEDGE"
	public final void mKNOWLEDGE() throws RecognitionException {
		try {
			int _type = KNOWLEDGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:316:11: ( 'knowledge' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:316:13: 'knowledge'
			{
			match("knowledge"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "KNOWLEDGE"

	// $ANTLR start "BELIEFS"
	public final void mBELIEFS() throws RecognitionException {
		try {
			int _type = BELIEFS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:317:9: ( 'beliefs' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:317:11: 'beliefs'
			{
			match("beliefs"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BELIEFS"

	// $ANTLR start "GOALS"
	public final void mGOALS() throws RecognitionException {
		try {
			int _type = GOALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:318:8: ( 'goals' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:318:10: 'goals'
			{
			match("goals"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GOALS"

	// $ANTLR start "EVENT"
	public final void mEVENT() throws RecognitionException {
		try {
			int _type = EVENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:319:8: ( 'event' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:319:10: 'event'
			{
			match("event"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EVENT"

	// $ANTLR start "INIT"
	public final void mINIT() throws RecognitionException {
		try {
			int _type = INIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:320:7: ( 'init' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:320:9: 'init'
			{
			match("init"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INIT"

	// $ANTLR start "ACTIONSPEC"
	public final void mACTIONSPEC() throws RecognitionException {
		try {
			int _type = ACTIONSPEC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:322:2: ( 'actionspec' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:322:4: 'actionspec'
			{
			match("actionspec"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ACTIONSPEC"

	// $ANTLR start "MODULE"
	public final void mMODULE() throws RecognitionException {
		try {
			int _type = MODULE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:323:9: ( 'module' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:323:11: 'module'
			{
			match("module"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MODULE"

	// $ANTLR start "PROGRAM"
	public final void mPROGRAM() throws RecognitionException {
		try {
			int _type = PROGRAM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:324:9: ( 'program' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:324:11: 'program'
			{
			match("program"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PROGRAM"

	// $ANTLR start "PROLOGARROW"
	public final void mPROLOGARROW() throws RecognitionException {
		try {
			int _type = PROLOGARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:326:2: ( ':-' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:326:4: ':-'
			{
			match(":-"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PROLOGARROW"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:327:6: ( 'not' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:327:8: 'not'
			{
			match("not"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "ORDER"
	public final void mORDER() throws RecognitionException {
		try {
			int _type = ORDER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:328:8: ( 'order' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:328:9: 'order'
			{
			match("order"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ORDER"

	// $ANTLR start "EQUALS"
	public final void mEQUALS() throws RecognitionException {
		try {
			int _type = EQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:329:9: ( '=' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:329:11: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUALS"

	// $ANTLR start "LINEAR"
	public final void mLINEAR() throws RecognitionException {
		try {
			int _type = LINEAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:330:9: ( 'linear' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:330:11: 'linear'
			{
			match("linear"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LINEAR"

	// $ANTLR start "LINEARALL"
	public final void mLINEARALL() throws RecognitionException {
		try {
			int _type = LINEARALL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:332:2: ( 'linearall' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:332:4: 'linearall'
			{
			match("linearall"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LINEARALL"

	// $ANTLR start "RANDOM"
	public final void mRANDOM() throws RecognitionException {
		try {
			int _type = RANDOM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:333:10: ( 'random' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:333:12: 'random'
			{
			match("random"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RANDOM"

	// $ANTLR start "RANDOMALL"
	public final void mRANDOMALL() throws RecognitionException {
		try {
			int _type = RANDOMALL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:335:2: ( 'randomall' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:335:4: 'randomall'
			{
			match("randomall"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RANDOMALL"

	// $ANTLR start "ADAPTIVE"
	public final void mADAPTIVE() throws RecognitionException {
		try {
			int _type = ADAPTIVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:336:10: ( 'adaptive' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:336:12: 'adaptive'
			{
			match("adaptive"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADAPTIVE"

	// $ANTLR start "DEFINE"
	public final void mDEFINE() throws RecognitionException {
		try {
			int _type = DEFINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:337:9: ( 'define' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:337:11: 'define'
			{
			match("define"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFINE"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:338:5: ( 'if' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:338:7: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "DO"
	public final void mDO() throws RecognitionException {
		try {
			int _type = DO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:339:5: ( 'do' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:339:7: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DO"

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:340:7: ( 'then' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:340:9: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:341:7: ( 'true' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:341:9: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "BEL"
	public final void mBEL() throws RecognitionException {
		try {
			int _type = BEL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:342:6: ( 'bel' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:342:8: 'bel'
			{
			match("bel"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BEL"

	// $ANTLR start "GOAL"
	public final void mGOAL() throws RecognitionException {
		try {
			int _type = GOAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:343:7: ( 'goal' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:343:9: 'goal'
			{
			match("goal"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GOAL"

	// $ANTLR start "AGOAL"
	public final void mAGOAL() throws RecognitionException {
		try {
			int _type = AGOAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:344:8: ( 'a-goal' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:344:10: 'a-goal'
			{
			match("a-goal"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AGOAL"

	// $ANTLR start "GOALA"
	public final void mGOALA() throws RecognitionException {
		try {
			int _type = GOALA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:345:8: ( 'goal-a' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:345:10: 'goal-a'
			{
			match("goal-a"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GOALA"

	// $ANTLR start "PRE"
	public final void mPRE() throws RecognitionException {
		try {
			int _type = PRE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:346:6: ( 'pre' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:346:8: 'pre'
			{
			match("pre"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRE"

	// $ANTLR start "POST"
	public final void mPOST() throws RecognitionException {
		try {
			int _type = POST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:347:7: ( 'post' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:347:9: 'post'
			{
			match("post"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POST"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:348:7: ( '+' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:348:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "INTERNAL"
	public final void mINTERNAL() throws RecognitionException {
		try {
			int _type = INTERNAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:349:11: ( '@int' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:349:13: '@int'
			{
			match("@int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTERNAL"

	// $ANTLR start "EXTERNAL"
	public final void mEXTERNAL() throws RecognitionException {
		try {
			int _type = EXTERNAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:350:11: ( '@ext' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:350:13: '@ext'
			{
			match("@ext"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTERNAL"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:419:8: ( ':' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:419:10: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "CURLYOPEN"
	public final void mCURLYOPEN() throws RecognitionException {
		try {
			int _type = CURLYOPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:420:11: ( '{' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:420:13: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURLYOPEN"

	// $ANTLR start "CURLYCLOSE"
	public final void mCURLYCLOSE() throws RecognitionException {
		try {
			int _type = CURLYCLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:422:2: ( '}' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:422:3: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURLYCLOSE"

	// $ANTLR start "STOP"
	public final void mSTOP() throws RecognitionException {
		try {
			int _type = STOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:7: ( '.' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:423:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STOP"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:424:8: ( ',' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:424:10: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:425:6: ( ';' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:425:7: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "OPEN"
	public final void mOPEN() throws RecognitionException {
		try {
			int _type = OPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:426:7: ( '(' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:426:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPEN"

	// $ANTLR start "CLOSE"
	public final void mCLOSE() throws RecognitionException {
		try {
			int _type = CLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:427:8: ( ')' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:427:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSE"

	// $ANTLR start "SQOPEN"
	public final void mSQOPEN() throws RecognitionException {
		try {
			int _type = SQOPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:428:9: ( '[' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:428:11: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SQOPEN"

	// $ANTLR start "SQCLOSE"
	public final void mSQCLOSE() throws RecognitionException {
		try {
			int _type = SQCLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:10: ( ']' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:429:12: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SQCLOSE"

	// $ANTLR start "HASH"
	public final void mHASH() throws RecognitionException {
		try {
			int _type = HASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:6: ( '#' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:430:8: '#'
			{
			match('#'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HASH"

	// $ANTLR start "SINGLEQUOTE"
	public final void mSINGLEQUOTE() throws RecognitionException {
		try {
			int _type = SINGLEQUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:432:2: ( '\\'' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:432:4: '\\''
			{
			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SINGLEQUOTE"

	// $ANTLR start "BAR"
	public final void mBAR() throws RecognitionException {
		try {
			int _type = BAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:433:6: ( '|' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:433:8: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BAR"

	// $ANTLR start "IS"
	public final void mIS() throws RecognitionException {
		try {
			int _type = IS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:435:4: ( 'is' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:435:7: 'is'
			{
			match("is"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IS"

	// $ANTLR start "CONST"
	public final void mCONST() throws RecognitionException {
		try {
			int _type = CONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:436:7: ( 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:436:9: 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			matchRange('a','z'); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:436:18: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONST"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:437:5: ( 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:437:7: 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			matchRange('A','Z'); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:437:16: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VAR"

	// $ANTLR start "UNNAMEDVAR"
	public final void mUNNAMEDVAR() throws RecognitionException {
		try {
			int _type = UNNAMEDVAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:439:2: ( '_' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:439:4: '_'
			{
			match('_'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNNAMEDVAR"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:8: ( '\"' ( 'a' .. 'z' | 'A' .. 'Z' | ',' | ' ' | '!' )+ '\"' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:10: '\"' ( 'a' .. 'z' | 'A' .. 'Z' | ',' | ' ' | '!' )+ '\"'
			{
			match('\"'); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:440:13: ( 'a' .. 'z' | 'A' .. 'Z' | ',' | ' ' | '!' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= ' ' && LA3_0 <= '!')||LA3_0==','||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
					{
					if ( (input.LA(1) >= ' ' && input.LA(1) <= '!')||input.LA(1)==','||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:441:8: ( '0' .. '9' ( '0' .. '9' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:441:10: '0' .. '9' ( '0' .. '9' )*
			{
			matchRange('0','9'); 
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:441:19: ( '0' .. '9' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:443:7: ( '-' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:443:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MULT"
	public final void mMULT() throws RecognitionException {
		try {
			int _type = MULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:444:6: ( '*' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:444:8: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULT"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:445:5: ( '/' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:445:7: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "LESS"
	public final void mLESS() throws RecognitionException {
		try {
			int _type = LESS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:446:6: ( '<' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:446:8: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:449:3: ( '/*' ( . )* '*/' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:449:3: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:449:8: ( . )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='*') ) {
					int LA5_1 = input.LA(2);
					if ( (LA5_1=='/') ) {
						alt5=2;
					}
					else if ( ((LA5_1 >= '\u0000' && LA5_1 <= '.')||(LA5_1 >= '0' && LA5_1 <= '\uFFFF')) ) {
						alt5=1;
					}

				}
				else if ( ((LA5_0 >= '\u0000' && LA5_0 <= ')')||(LA5_0 >= '+' && LA5_0 <= '\uFFFF')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:449:8: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop5;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "LINE_COMMENT"
	public final void mLINE_COMMENT() throws RecognitionException {
		try {
			int _type = LINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:452:3: ( ( '//' | '%' ) (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:452:3: ( '//' | '%' ) (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:452:3: ( '//' | '%' )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='/') ) {
				alt6=1;
			}
			else if ( (LA6_0=='%') ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:452:4: '//'
					{
					match("//"); 

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:452:9: '%'
					{
					match('%'); 
					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:452:14: (~ ( '\\n' | '\\r' ) )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\t')||(LA7_0 >= '\u000B' && LA7_0 <= '\f')||(LA7_0 >= '\u000E' && LA7_0 <= '\uFFFF')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop7;
				}
			}

			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:452:28: ( '\\r' )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='\r') ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:452:28: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LINE_COMMENT"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:454:8: ( ( '\\r' )? '\\n' )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:454:9: ( '\\r' )? '\\n'
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:454:9: ( '\\r' )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='\r') ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:454:9: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:455:4: ( ( ' ' | '\\t' )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:455:6: ( ' ' | '\\t' )+
			{
			// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:455:6: ( ' ' | '\\t' )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0=='\t'||LA10_0==' ') ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:8: ( T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | MAIN | MODULEFILE | KNOWLEDGE | BELIEFS | GOALS | EVENT | INIT | ACTIONSPEC | MODULE | PROGRAM | PROLOGARROW | NOT | ORDER | EQUALS | LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE | DEFINE | IF | DO | THEN | TRUE | BEL | GOAL | AGOAL | GOALA | PRE | POST | PLUS | INTERNAL | EXTERNAL | COLON | CURLYOPEN | CURLYCLOSE | STOP | COMMA | SEMI | OPEN | CLOSE | SQOPEN | SQCLOSE | HASH | SINGLEQUOTE | BAR | IS | CONST | VAR | UNNAMEDVAR | STRING | NUMBER | MINUS | MULT | DIV | LESS | COMMENT | LINE_COMMENT | NEWLINE | WS )
		int alt11=90;
		alt11 = dfa11.predict(input);
		switch (alt11) {
			case 1 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:10: T__64
				{
				mT__64(); 

				}
				break;
			case 2 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:16: T__65
				{
				mT__65(); 

				}
				break;
			case 3 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:22: T__66
				{
				mT__66(); 

				}
				break;
			case 4 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:28: T__67
				{
				mT__67(); 

				}
				break;
			case 5 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:34: T__68
				{
				mT__68(); 

				}
				break;
			case 6 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:40: T__69
				{
				mT__69(); 

				}
				break;
			case 7 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:46: T__70
				{
				mT__70(); 

				}
				break;
			case 8 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:52: T__71
				{
				mT__71(); 

				}
				break;
			case 9 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:58: T__72
				{
				mT__72(); 

				}
				break;
			case 10 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:64: T__73
				{
				mT__73(); 

				}
				break;
			case 11 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:70: T__74
				{
				mT__74(); 

				}
				break;
			case 12 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:76: T__75
				{
				mT__75(); 

				}
				break;
			case 13 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:82: T__76
				{
				mT__76(); 

				}
				break;
			case 14 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:88: T__77
				{
				mT__77(); 

				}
				break;
			case 15 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:94: T__78
				{
				mT__78(); 

				}
				break;
			case 16 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:100: T__79
				{
				mT__79(); 

				}
				break;
			case 17 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:106: T__80
				{
				mT__80(); 

				}
				break;
			case 18 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:112: T__81
				{
				mT__81(); 

				}
				break;
			case 19 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:118: T__82
				{
				mT__82(); 

				}
				break;
			case 20 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:124: T__83
				{
				mT__83(); 

				}
				break;
			case 21 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:130: T__84
				{
				mT__84(); 

				}
				break;
			case 22 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:136: T__85
				{
				mT__85(); 

				}
				break;
			case 23 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:142: T__86
				{
				mT__86(); 

				}
				break;
			case 24 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:148: T__87
				{
				mT__87(); 

				}
				break;
			case 25 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:154: T__88
				{
				mT__88(); 

				}
				break;
			case 26 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:160: T__89
				{
				mT__89(); 

				}
				break;
			case 27 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:166: T__90
				{
				mT__90(); 

				}
				break;
			case 28 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:172: T__91
				{
				mT__91(); 

				}
				break;
			case 29 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:178: T__92
				{
				mT__92(); 

				}
				break;
			case 30 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:184: T__93
				{
				mT__93(); 

				}
				break;
			case 31 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:190: MAIN
				{
				mMAIN(); 

				}
				break;
			case 32 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:195: MODULEFILE
				{
				mMODULEFILE(); 

				}
				break;
			case 33 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:206: KNOWLEDGE
				{
				mKNOWLEDGE(); 

				}
				break;
			case 34 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:216: BELIEFS
				{
				mBELIEFS(); 

				}
				break;
			case 35 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:224: GOALS
				{
				mGOALS(); 

				}
				break;
			case 36 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:230: EVENT
				{
				mEVENT(); 

				}
				break;
			case 37 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:236: INIT
				{
				mINIT(); 

				}
				break;
			case 38 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:241: ACTIONSPEC
				{
				mACTIONSPEC(); 

				}
				break;
			case 39 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:252: MODULE
				{
				mMODULE(); 

				}
				break;
			case 40 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:259: PROGRAM
				{
				mPROGRAM(); 

				}
				break;
			case 41 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:267: PROLOGARROW
				{
				mPROLOGARROW(); 

				}
				break;
			case 42 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:279: NOT
				{
				mNOT(); 

				}
				break;
			case 43 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:283: ORDER
				{
				mORDER(); 

				}
				break;
			case 44 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:289: EQUALS
				{
				mEQUALS(); 

				}
				break;
			case 45 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:296: LINEAR
				{
				mLINEAR(); 

				}
				break;
			case 46 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:303: LINEARALL
				{
				mLINEARALL(); 

				}
				break;
			case 47 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:313: RANDOM
				{
				mRANDOM(); 

				}
				break;
			case 48 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:320: RANDOMALL
				{
				mRANDOMALL(); 

				}
				break;
			case 49 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:330: ADAPTIVE
				{
				mADAPTIVE(); 

				}
				break;
			case 50 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:339: DEFINE
				{
				mDEFINE(); 

				}
				break;
			case 51 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:346: IF
				{
				mIF(); 

				}
				break;
			case 52 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:349: DO
				{
				mDO(); 

				}
				break;
			case 53 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:352: THEN
				{
				mTHEN(); 

				}
				break;
			case 54 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:357: TRUE
				{
				mTRUE(); 

				}
				break;
			case 55 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:362: BEL
				{
				mBEL(); 

				}
				break;
			case 56 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:366: GOAL
				{
				mGOAL(); 

				}
				break;
			case 57 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:371: AGOAL
				{
				mAGOAL(); 

				}
				break;
			case 58 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:377: GOALA
				{
				mGOALA(); 

				}
				break;
			case 59 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:383: PRE
				{
				mPRE(); 

				}
				break;
			case 60 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:387: POST
				{
				mPOST(); 

				}
				break;
			case 61 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:392: PLUS
				{
				mPLUS(); 

				}
				break;
			case 62 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:397: INTERNAL
				{
				mINTERNAL(); 

				}
				break;
			case 63 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:406: EXTERNAL
				{
				mEXTERNAL(); 

				}
				break;
			case 64 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:415: COLON
				{
				mCOLON(); 

				}
				break;
			case 65 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:421: CURLYOPEN
				{
				mCURLYOPEN(); 

				}
				break;
			case 66 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:431: CURLYCLOSE
				{
				mCURLYCLOSE(); 

				}
				break;
			case 67 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:442: STOP
				{
				mSTOP(); 

				}
				break;
			case 68 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:447: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 69 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:453: SEMI
				{
				mSEMI(); 

				}
				break;
			case 70 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:458: OPEN
				{
				mOPEN(); 

				}
				break;
			case 71 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:463: CLOSE
				{
				mCLOSE(); 

				}
				break;
			case 72 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:469: SQOPEN
				{
				mSQOPEN(); 

				}
				break;
			case 73 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:476: SQCLOSE
				{
				mSQCLOSE(); 

				}
				break;
			case 74 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:484: HASH
				{
				mHASH(); 

				}
				break;
			case 75 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:489: SINGLEQUOTE
				{
				mSINGLEQUOTE(); 

				}
				break;
			case 76 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:501: BAR
				{
				mBAR(); 

				}
				break;
			case 77 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:505: IS
				{
				mIS(); 

				}
				break;
			case 78 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:508: CONST
				{
				mCONST(); 

				}
				break;
			case 79 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:514: VAR
				{
				mVAR(); 

				}
				break;
			case 80 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:518: UNNAMEDVAR
				{
				mUNNAMEDVAR(); 

				}
				break;
			case 81 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:529: STRING
				{
				mSTRING(); 

				}
				break;
			case 82 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:536: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 83 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:543: MINUS
				{
				mMINUS(); 

				}
				break;
			case 84 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:549: MULT
				{
				mMULT(); 

				}
				break;
			case 85 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:554: DIV
				{
				mDIV(); 

				}
				break;
			case 86 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:558: LESS
				{
				mLESS(); 

				}
				break;
			case 87 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:563: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 88 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:571: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;
			case 89 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:584: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 90 :
				// /Users/lad/Eclipse/mcapl/src/classes/goal/parser/GOAL.g:1:592: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA11 dfa11 = new DFA11(this);
	static final String DFA11_eotS =
		"\1\uffff\1\56\1\60\1\62\13\43\1\116\3\43\1\123\1\43\1\uffff\1\43\22\uffff"+
		"\1\131\11\uffff\3\43\1\uffff\2\43\1\142\5\43\1\152\1\153\14\43\2\uffff"+
		"\3\43\2\uffff\2\43\4\uffff\2\43\1\u0089\5\43\1\uffff\7\43\2\uffff\2\43"+
		"\1\u0098\1\43\1\u009a\3\43\1\u009e\2\43\1\u00a1\12\43\1\u00ae\6\43\1\uffff"+
		"\4\43\1\u00b9\1\u00bb\5\43\1\u00c1\2\43\1\uffff\1\43\1\uffff\2\43\1\u00c7"+
		"\1\uffff\2\43\1\uffff\1\u00ca\1\43\1\u00cc\1\u00ce\1\u00d0\1\u00d1\1\u00d2"+
		"\1\u00d3\1\u00d4\3\43\1\uffff\1\u00da\2\43\1\u00dd\6\43\3\uffff\1\u00e4"+
		"\1\43\1\u00e6\2\43\1\uffff\2\43\1\u00eb\2\43\1\uffff\1\u00ee\1\43\1\uffff"+
		"\1\43\1\uffff\1\43\1\uffff\1\43\5\uffff\3\43\1\u00f6\2\uffff\1\u00f7\1"+
		"\43\1\uffff\2\43\1\u00fb\1\43\1\u00fd\1\u00fe\1\uffff\1\u00ff\1\uffff"+
		"\1\u0100\1\u0101\1\43\1\u0104\1\uffff\2\43\1\uffff\1\43\1\u0108\2\43\1"+
		"\u010b\2\43\2\uffff\1\u010f\2\43\1\uffff\1\43\5\uffff\1\u0113\1\43\1\uffff"+
		"\1\43\1\u0116\1\u0117\1\uffff\2\43\1\uffff\1\43\1\u011b\1\43\1\uffff\1"+
		"\u011d\1\u011e\1\43\1\uffff\1\43\1\u0121\2\uffff\1\u0122\2\43\1\uffff"+
		"\1\43\2\uffff\1\43\1\u0127\2\uffff\1\u0128\1\u0129\1\u012a\1\u012b\5\uffff";
	static final String DFA11_eofS =
		"\u012c\uffff";
	static final String DFA11_minS =
		"\1\11\1\151\1\76\2\55\1\145\1\166\1\151\1\146\1\151\1\145\1\157\1\145"+
		"\1\150\1\141\1\155\1\156\1\145\1\157\1\55\1\162\1\uffff\1\141\1\uffff"+
		"\1\145\20\uffff\1\52\11\uffff\1\141\1\154\1\164\1\uffff\1\146\1\157\1"+
		"\60\1\151\1\145\1\154\1\143\1\151\2\60\1\156\1\147\1\166\1\141\1\145\1"+
		"\163\1\154\1\155\1\145\1\165\1\151\1\144\2\uffff\1\157\1\154\1\141\2\uffff"+
		"\1\144\1\156\4\uffff\2\160\1\60\1\141\1\151\1\145\1\151\1\160\1\uffff"+
		"\1\164\1\156\1\164\1\165\1\141\1\145\1\164\2\uffff\1\164\1\145\1\60\1"+
		"\145\1\60\1\143\1\157\1\145\1\60\1\156\1\147\1\60\1\164\1\145\1\144\1"+
		"\145\1\163\1\156\1\145\1\156\1\165\1\167\1\60\1\154\1\145\1\144\3\164"+
		"\1\uffff\1\171\1\157\1\164\1\156\1\60\1\55\1\164\1\145\1\163\1\154\1\162"+
		"\1\60\2\141\1\uffff\1\162\1\uffff\1\164\1\141\1\60\1\uffff\1\164\1\162"+
		"\1\uffff\1\60\1\143\7\60\2\154\1\145\1\uffff\1\55\1\162\1\157\1\60\1\151"+
		"\1\150\1\163\1\156\2\145\3\uffff\1\60\1\162\1\60\1\154\1\164\1\uffff\1"+
		"\154\1\162\1\60\1\151\1\154\1\uffff\1\60\1\141\1\uffff\1\164\1\uffff\1"+
		"\156\1\uffff\1\164\5\uffff\2\145\1\146\1\60\2\uffff\1\60\1\155\1\uffff"+
		"\1\166\1\145\1\60\1\163\2\60\1\uffff\1\60\1\uffff\2\60\1\154\1\60\1\uffff"+
		"\1\157\1\163\1\uffff\1\155\1\60\1\143\1\150\1\60\1\144\1\163\2\uffff\1"+
		"\60\1\145\1\162\1\uffff\1\160\5\uffff\1\60\1\154\1\uffff\1\156\2\60\1"+
		"\uffff\2\145\1\uffff\1\147\1\60\1\154\1\uffff\2\60\1\145\1\uffff\1\154"+
		"\1\60\2\uffff\1\60\1\162\1\145\1\uffff\1\154\2\uffff\1\143\1\60\2\uffff"+
		"\4\60\5\uffff";
	static final String DFA11_maxS =
		"\1\175\1\151\1\76\1\55\1\154\1\162\1\170\1\157\1\163\2\157\1\162\1\157"+
		"\1\162\1\157\1\155\1\156\1\145\1\157\1\55\1\162\1\uffff\1\141\1\uffff"+
		"\1\151\20\uffff\1\57\11\uffff\1\157\1\167\1\164\1\uffff\1\154\1\157\1"+
		"\172\1\151\1\145\1\154\1\162\1\163\2\172\1\163\1\147\1\167\1\164\1\157"+
		"\1\163\1\156\1\155\1\151\1\165\1\151\1\144\2\uffff\1\157\1\154\1\141\2"+
		"\uffff\1\144\1\156\4\uffff\2\160\1\172\1\141\1\151\1\145\1\151\1\160\1"+
		"\uffff\1\164\1\156\1\164\1\165\1\141\1\145\1\164\2\uffff\1\164\1\145\1"+
		"\172\1\145\1\172\1\143\1\157\1\145\1\172\1\156\1\147\1\172\1\164\1\146"+
		"\1\144\1\145\1\163\1\156\1\145\1\156\1\165\1\167\1\172\1\154\1\145\1\144"+
		"\3\164\1\uffff\1\171\1\157\1\164\1\156\2\172\1\164\1\145\1\163\1\154\1"+
		"\162\1\172\2\141\1\uffff\1\162\1\uffff\1\164\1\141\1\172\1\uffff\1\164"+
		"\1\162\1\uffff\1\172\1\143\7\172\2\154\1\145\1\uffff\1\172\1\162\1\157"+
		"\1\172\1\151\1\150\1\163\1\156\2\145\3\uffff\1\172\1\162\1\172\1\154\1"+
		"\164\1\uffff\1\154\1\162\1\172\1\151\1\154\1\uffff\1\172\1\141\1\uffff"+
		"\1\164\1\uffff\1\156\1\uffff\1\164\5\uffff\2\145\1\146\1\172\2\uffff\1"+
		"\172\1\155\1\uffff\1\166\1\145\1\172\1\163\2\172\1\uffff\1\172\1\uffff"+
		"\2\172\1\154\1\172\1\uffff\1\157\1\163\1\uffff\1\155\1\172\1\143\1\150"+
		"\1\172\1\144\1\163\2\uffff\1\172\1\145\1\162\1\uffff\1\160\5\uffff\1\172"+
		"\1\154\1\uffff\1\156\2\172\1\uffff\2\145\1\uffff\1\147\1\172\1\154\1\uffff"+
		"\2\172\1\145\1\uffff\1\154\1\172\2\uffff\1\172\1\162\1\145\1\uffff\1\154"+
		"\2\uffff\1\143\1\172\2\uffff\4\172\5\uffff";
	static final String DFA11_acceptS =
		"\25\uffff\1\54\1\uffff\1\75\1\uffff\1\101\1\102\1\104\1\105\1\106\1\107"+
		"\1\110\1\111\1\113\1\114\1\116\1\117\1\120\1\121\1\122\1\124\1\uffff\1"+
		"\130\1\131\1\132\1\1\1\112\1\2\1\123\1\3\1\126\3\uffff\1\71\26\uffff\1"+
		"\40\1\103\3\uffff\1\51\1\100\2\uffff\1\76\1\77\1\127\1\125\10\uffff\1"+
		"\64\7\uffff\1\63\1\115\35\uffff\1\5\16\uffff\1\21\1\uffff\1\23\3\uffff"+
		"\1\52\2\uffff\1\73\14\uffff\1\67\12\uffff\1\11\1\13\1\12\5\uffff\1\45"+
		"\5\uffff\1\26\2\uffff\1\74\1\uffff\1\31\1\uffff\1\32\1\uffff\1\34\1\36"+
		"\1\65\1\66\1\37\4\uffff\1\72\1\70\2\uffff\1\4\6\uffff\1\44\1\uffff\1\15"+
		"\4\uffff\1\22\2\uffff\1\27\7\uffff\1\43\1\53\3\uffff\1\7\1\uffff\1\10"+
		"\1\62\1\14\1\16\1\17\2\uffff\1\55\3\uffff\1\30\2\uffff\1\47\3\uffff\1"+
		"\57\3\uffff\1\20\2\uffff\1\25\1\50\3\uffff\1\42\1\uffff\1\61\1\6\2\uffff"+
		"\1\24\1\33\4\uffff\1\56\1\35\1\41\1\60\1\46";
	static final String DFA11_specialS =
		"\u012c\uffff}>";
	static final String[] DFA11_transitionS = {
			"\1\54\1\53\2\uffff\1\53\22\uffff\1\54\1\uffff\1\46\1\1\1\uffff\1\52\1"+
			"\uffff\1\41\1\35\1\36\1\50\1\27\1\33\1\2\1\17\1\51\12\47\1\23\1\34\1"+
			"\3\1\25\2\uffff\1\30\32\44\1\37\1\uffff\1\40\1\uffff\1\45\1\uffff\1\4"+
			"\1\21\1\43\1\5\1\6\1\7\1\22\1\43\1\10\1\43\1\20\1\11\1\16\1\12\1\24\1"+
			"\13\1\43\1\26\1\14\1\15\6\43\1\31\1\42\1\32",
			"\1\55",
			"\1\57",
			"\1\61",
			"\1\66\65\uffff\1\65\1\63\7\uffff\1\64",
			"\1\67\11\uffff\1\71\2\uffff\1\70",
			"\1\73\1\uffff\1\72",
			"\1\74\5\uffff\1\75",
			"\1\77\7\uffff\1\76\4\uffff\1\100",
			"\1\101\5\uffff\1\102",
			"\1\103\11\uffff\1\104",
			"\1\106\2\uffff\1\105",
			"\1\107\11\uffff\1\110",
			"\1\111\11\uffff\1\112",
			"\1\113\15\uffff\1\114",
			"\1\115",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\122",
			"\1\124",
			"",
			"\1\125",
			"",
			"\1\127\3\uffff\1\126",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\130\4\uffff\1\52",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\133\15\uffff\1\132",
			"\1\134\12\uffff\1\135",
			"\1\136",
			"",
			"\1\140\5\uffff\1\137",
			"\1\141",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\143",
			"\1\144",
			"\1\145",
			"\1\146\16\uffff\1\147",
			"\1\151\11\uffff\1\150",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\155\4\uffff\1\154",
			"\1\156",
			"\1\157\1\160",
			"\1\161\5\uffff\1\162\6\uffff\1\163\5\uffff\1\164",
			"\1\167\3\uffff\1\165\5\uffff\1\166",
			"\1\170",
			"\1\171\1\uffff\1\172",
			"\1\173",
			"\1\175\3\uffff\1\174",
			"\1\176",
			"\1\177",
			"\1\u0080",
			"",
			"",
			"\1\u0081",
			"\1\u0082",
			"\1\u0083",
			"",
			"",
			"\1\u0084",
			"\1\u0085",
			"",
			"",
			"",
			"",
			"\1\u0086",
			"\1\u0087",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\16\43\1\u0088\13\43",
			"\1\u008a",
			"\1\u008b",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e",
			"",
			"\1\u008f",
			"\1\u0090",
			"\1\u0091",
			"\1\u0092",
			"\1\u0093",
			"\1\u0094",
			"\1\u0095",
			"",
			"",
			"\1\u0096",
			"\1\u0097",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u0099",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u009b",
			"\1\u009c",
			"\1\u009d",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u009f",
			"\1\u00a0",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u00a2",
			"\1\u00a3\1\u00a4",
			"\1\u00a5",
			"\1\u00a6",
			"\1\u00a7",
			"\1\u00a8",
			"\1\u00a9",
			"\1\u00aa",
			"\1\u00ab",
			"\1\u00ac",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\10\43\1\u00ad\21\43",
			"\1\u00af",
			"\1\u00b0",
			"\1\u00b1",
			"\1\u00b2",
			"\1\u00b3",
			"\1\u00b4",
			"",
			"\1\u00b5",
			"\1\u00b6",
			"\1\u00b7",
			"\1\u00b8",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u00ba\2\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u00bc",
			"\1\u00bd",
			"\1\u00be",
			"\1\u00bf",
			"\1\u00c0",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u00c2",
			"\1\u00c3",
			"",
			"\1\u00c4",
			"",
			"\1\u00c5",
			"\1\u00c6",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"\1\u00c8",
			"\1\u00c9",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u00cb",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\16\43\1\u00cd\13\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\16\43\1\u00cf\13\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u00d5",
			"\1\u00d6",
			"\1\u00d7",
			"",
			"\1\u00d9\2\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\22\43\1\u00d8"+
			"\7\43",
			"\1\u00db",
			"\1\u00dc",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u00de",
			"\1\u00df",
			"\1\u00e0",
			"\1\u00e1",
			"\1\u00e2",
			"\1\u00e3",
			"",
			"",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u00e5",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u00e7",
			"\1\u00e8",
			"",
			"\1\u00e9",
			"\1\u00ea",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u00ec",
			"\1\u00ed",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u00ef",
			"",
			"\1\u00f0",
			"",
			"\1\u00f1",
			"",
			"\1\u00f2",
			"",
			"",
			"",
			"",
			"",
			"\1\u00f3",
			"\1\u00f4",
			"\1\u00f5",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u00f8",
			"",
			"\1\u00f9",
			"\1\u00fa",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u00fc",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u0102",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\1\u0103\31\43",
			"",
			"\1\u0105",
			"\1\u0106",
			"",
			"\1\u0107",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u0109",
			"\1\u010a",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u010c",
			"\1\u010d",
			"",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\1\u010e\31\43",
			"\1\u0110",
			"\1\u0111",
			"",
			"\1\u0112",
			"",
			"",
			"",
			"",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u0114",
			"",
			"\1\u0115",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"\1\u0118",
			"\1\u0119",
			"",
			"\1\u011a",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u011c",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u011f",
			"",
			"\1\u0120",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u0123",
			"\1\u0124",
			"",
			"\1\u0125",
			"",
			"",
			"\1\u0126",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
	static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
	static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
	static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
	static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
	static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
	static final short[][] DFA11_transition;

	static {
		int numStates = DFA11_transitionS.length;
		DFA11_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
		}
	}

	protected class DFA11 extends DFA {

		public DFA11(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 11;
			this.eot = DFA11_eot;
			this.eof = DFA11_eof;
			this.min = DFA11_min;
			this.max = DFA11_max;
			this.accept = DFA11_accept;
			this.special = DFA11_special;
			this.transition = DFA11_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | MAIN | MODULEFILE | KNOWLEDGE | BELIEFS | GOALS | EVENT | INIT | ACTIONSPEC | MODULE | PROGRAM | PROLOGARROW | NOT | ORDER | EQUALS | LINEAR | LINEARALL | RANDOM | RANDOMALL | ADAPTIVE | DEFINE | IF | DO | THEN | TRUE | BEL | GOAL | AGOAL | GOALA | PRE | POST | PLUS | INTERNAL | EXTERNAL | COLON | CURLYOPEN | CURLYCLOSE | STOP | COMMA | SEMI | OPEN | CLOSE | SQOPEN | SQCLOSE | HASH | SINGLEQUOTE | BAR | IS | CONST | VAR | UNNAMEDVAR | STRING | NUMBER | MINUS | MULT | DIV | LESS | COMMENT | LINE_COMMENT | NEWLINE | WS );";
		}
	}

}
