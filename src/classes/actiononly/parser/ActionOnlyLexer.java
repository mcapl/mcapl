// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g 2016-06-02 13:52:30

package actiononly.parser;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ActionOnlyLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ACTIONONLY=4;
	public static final int ACTIONS=5;
	public static final int BELIEFRULES=6;
	public static final int BELIEFS=7;
	public static final int BELIEVE=8;
	public static final int BRULEARROW=9;
	public static final int CLOSE=10;
	public static final int COLON=11;
	public static final int COMMA=12;
	public static final int COMMENT=13;
	public static final int CONST=14;
	public static final int CURLYCLOSE=15;
	public static final int CURLYOPEN=16;
	public static final int DIV=17;
	public static final int DOUBLEQUOTE=18;
	public static final int EQ=19;
	public static final int GOAL=20;
	public static final int LESS=21;
	public static final int LINE_COMMENT=22;
	public static final int MINUS=23;
	public static final int MOD=24;
	public static final int MULT=25;
	public static final int NAME=26;
	public static final int NEWLINE=27;
	public static final int NOT=28;
	public static final int NUMBER=29;
	public static final int OPEN=30;
	public static final int PLUS=31;
	public static final int POINT=32;
	public static final int QUERY=33;
	public static final int SEMI=34;
	public static final int SHRIEK=35;
	public static final int SQCLOSE=36;
	public static final int SQOPEN=37;
	public static final int STRING=38;
	public static final int TRUE=39;
	public static final int VAR=40;
	public static final int WS=41;

	    public int plain_nesting = 0;
	    public int sq_nesting = 0;
	    public int curly_nesting = 0;
	    public boolean stringterm = false;
	    public boolean ao = true;
	    public int belief_rules = 0;


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ActionOnlyLexer() {} 
	public ActionOnlyLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ActionOnlyLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g"; }

	// $ANTLR start "ACTIONONLY"
	public final void mACTIONONLY() throws RecognitionException {
		try {
			int _type = ACTIONONLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:105:12: ({...}? => 'AO' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:105:13: {...}? => 'AO'
			{
			if ( !((curly_nesting == 0)) ) {
				throw new FailedPredicateException(input, "ACTIONONLY", "curly_nesting == 0");
			}
			match("AO"); 

			ao = true;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ACTIONONLY"

	// $ANTLR start "BELIEFS"
	public final void mBELIEFS() throws RecognitionException {
		try {
			int _type = BELIEFS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:107:9: ( ':Initial Beliefs:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:107:11: ':Initial Beliefs:'
			{
			match(":Initial Beliefs:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BELIEFS"

	// $ANTLR start "BELIEFRULES"
	public final void mBELIEFRULES() throws RecognitionException {
		try {
			int _type = BELIEFRULES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:109:2: ( ':Reasoning Rules:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:109:4: ':Reasoning Rules:'
			{
			match(":Reasoning Rules:"); 

			belief_rules = 1;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BELIEFRULES"

	// $ANTLR start "GOAL"
	public final void mGOAL() throws RecognitionException {
		try {
			int _type = GOAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:110:6: ( ':Initial Goal:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:110:8: ':Initial Goal:'
			{
			match(":Initial Goal:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GOAL"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:111:6: ( ':name:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:111:8: ':name:'
			{
			match(":name:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "BELIEVE"
	public final void mBELIEVE() throws RecognitionException {
		try {
			int _type = BELIEVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:113:9: ({...}? => ( 'B' | '.B' ) )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:113:11: {...}? => ( 'B' | '.B' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {
				throw new FailedPredicateException(input, "BELIEVE", "curly_nesting > 0 && plain_nesting == 0 || belief_rules==1");
			}
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:113:75: ( 'B' | '.B' )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='B') ) {
				alt1=1;
			}
			else if ( (LA1_0=='.') ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:113:76: 'B'
					{
					match('B'); 
					}
					break;
				case 2 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:113:82: '.B'
					{
					match(".B"); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BELIEVE"

	// $ANTLR start "BRULEARROW"
	public final void mBRULEARROW() throws RecognitionException {
		try {
			int _type = BRULEARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:115:2: ( ':-' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:115:4: ':-'
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
	// $ANTLR end "BRULEARROW"

	// $ANTLR start "ACTIONS"
	public final void mACTIONS() throws RecognitionException {
		try {
			int _type = ACTIONS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:116:9: ( ':Actions:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:116:11: ':Actions:'
			{
			match(":Actions:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ACTIONS"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:117:6: ({...}? => 'True' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:117:8: {...}? => 'True'
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0)) ) {
				throw new FailedPredicateException(input, "TRUE", "curly_nesting > 0 && plain_nesting == 0");
			}
			match("True"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:170:5: ( '/*' ( . )* '*/' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:170:7: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:170:12: ( . )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='*') ) {
					int LA2_1 = input.LA(2);
					if ( (LA2_1=='/') ) {
						alt2=2;
					}
					else if ( ((LA2_1 >= '\u0000' && LA2_1 <= '.')||(LA2_1 >= '0' && LA2_1 <= '\uFFFF')) ) {
						alt2=1;
					}

				}
				else if ( ((LA2_0 >= '\u0000' && LA2_0 <= ')')||(LA2_0 >= '+' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:170:12: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop2;
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:173:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:173:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:173:12: (~ ( '\\n' | '\\r' ) )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:
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
					break loop3;
				}
			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:173:26: ( '\\r' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\r') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:173:26: '\\r'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:175:8: ( ( '\\r' )? '\\n' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:175:9: ( '\\r' )? '\\n'
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:175:9: ( '\\r' )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='\r') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:175:9: '\\r'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:176:5: ( ( ' ' | '\\t' )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:176:9: ( ' ' | '\\t' )+
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:176:9: ( ' ' | '\\t' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='\t'||LA6_0==' ') ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:
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
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
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

	// $ANTLR start "OPEN"
	public final void mOPEN() throws RecognitionException {
		try {
			int _type = OPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:179:6: ( '(' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:179:9: '('
			{
			match('('); 
			plain_nesting++;
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:180:7: ( ')' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:180:9: ')'
			{
			match(')'); 
			plain_nesting--;
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:181:8: ( '[' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:181:10: '['
			{
			match('['); 
			sq_nesting++;
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:182:9: ( ']' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:182:11: ']'
			{
			match(']'); 
			sq_nesting--;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SQCLOSE"

	// $ANTLR start "CURLYOPEN"
	public final void mCURLYOPEN() throws RecognitionException {
		try {
			int _type = CURLYOPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:183:11: ( '{' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:183:13: '{'
			{
			match('{'); 
			curly_nesting++;
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:184:12: ( '}' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:184:14: '}'
			{
			match('}'); 
			curly_nesting--;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURLYCLOSE"

	// $ANTLR start "DOUBLEQUOTE"
	public final void mDOUBLEQUOTE() throws RecognitionException {
		try {
			int _type = DOUBLEQUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:186:2: ( '\"' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:186:4: '\"'
			{
			match('\"'); 
			if (stringterm) {stringterm = false;} else {stringterm = true;}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLEQUOTE"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:187:5: ( '~' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:187:7: '~'
			{
			match('~'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:189:8: ({...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:189:10: {...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
			{
			if ( !((stringterm)) ) {
				throw new FailedPredicateException(input, "STRING", "stringterm");
			}
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:189:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:
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
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "CONST"
	public final void mCONST() throws RecognitionException {
		try {
			int _type = CONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:190:8: ({...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:190:11: {...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "CONST", "!stringterm");
			}
			matchRange('a','z'); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:190:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:
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
					break loop8;
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:191:5: ({...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:191:7: {...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "VAR", "!stringterm");
			}
			matchRange('A','Z'); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:191:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:
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
					break loop9;
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

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:192:8: ({...}? => '0' .. '9' ( '0' .. '9' )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:192:10: {...}? => '0' .. '9' ( '0' .. '9' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "NUMBER", "!stringterm");
			}
			matchRange('0','9'); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:192:35: ( '0' .. '9' )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:
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
					break loop10;
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

	// $ANTLR start "LESS"
	public final void mLESS() throws RecognitionException {
		try {
			int _type = LESS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:195:6: ( '<' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:195:8: '<'
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

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:196:4: ( '==' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:196:7: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "POINT"
	public final void mPOINT() throws RecognitionException {
		try {
			int _type = POINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:197:7: ( '.' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:197:9: '.'
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
	// $ANTLR end "POINT"

	// $ANTLR start "MULT"
	public final void mMULT() throws RecognitionException {
		try {
			int _type = MULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:198:6: ( '*' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:198:8: '*'
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

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:199:6: ( '+' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:199:8: '+'
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

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:200:7: ( '-' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:200:9: '-'
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

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:201:5: ( '/' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:201:7: '/'
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

	// $ANTLR start "MOD"
	public final void mMOD() throws RecognitionException {
		try {
			int _type = MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:202:5: ( '%' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:202:7: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOD"

	// $ANTLR start "SHRIEK"
	public final void mSHRIEK() throws RecognitionException {
		try {
			int _type = SHRIEK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:204:8: ( '!' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:204:10: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SHRIEK"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:205:7: ( ',' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:205:9: ','
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:206:6: ( ';' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:206:8: ';'
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

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:207:7: ( ':' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:207:9: ':'
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

	// $ANTLR start "QUERY"
	public final void mQUERY() throws RecognitionException {
		try {
			int _type = QUERY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:208:7: ( '?' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:208:9: '?'
			{
			match('?'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUERY"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:8: ( ACTIONONLY | BELIEFS | BELIEFRULES | GOAL | NAME | BELIEVE | BRULEARROW | ACTIONS | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY )
		int alt11=38;
		alt11 = dfa11.predict(input);
		switch (alt11) {
			case 1 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:10: ACTIONONLY
				{
				mACTIONONLY(); 

				}
				break;
			case 2 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:21: BELIEFS
				{
				mBELIEFS(); 

				}
				break;
			case 3 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:29: BELIEFRULES
				{
				mBELIEFRULES(); 

				}
				break;
			case 4 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:41: GOAL
				{
				mGOAL(); 

				}
				break;
			case 5 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:46: NAME
				{
				mNAME(); 

				}
				break;
			case 6 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:51: BELIEVE
				{
				mBELIEVE(); 

				}
				break;
			case 7 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:59: BRULEARROW
				{
				mBRULEARROW(); 

				}
				break;
			case 8 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:70: ACTIONS
				{
				mACTIONS(); 

				}
				break;
			case 9 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:78: TRUE
				{
				mTRUE(); 

				}
				break;
			case 10 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:83: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 11 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:91: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;
			case 12 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:104: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 13 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:112: WS
				{
				mWS(); 

				}
				break;
			case 14 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:115: OPEN
				{
				mOPEN(); 

				}
				break;
			case 15 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:120: CLOSE
				{
				mCLOSE(); 

				}
				break;
			case 16 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:126: SQOPEN
				{
				mSQOPEN(); 

				}
				break;
			case 17 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:133: SQCLOSE
				{
				mSQCLOSE(); 

				}
				break;
			case 18 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:141: CURLYOPEN
				{
				mCURLYOPEN(); 

				}
				break;
			case 19 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:151: CURLYCLOSE
				{
				mCURLYCLOSE(); 

				}
				break;
			case 20 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:162: DOUBLEQUOTE
				{
				mDOUBLEQUOTE(); 

				}
				break;
			case 21 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:174: NOT
				{
				mNOT(); 

				}
				break;
			case 22 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:178: STRING
				{
				mSTRING(); 

				}
				break;
			case 23 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:185: CONST
				{
				mCONST(); 

				}
				break;
			case 24 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:191: VAR
				{
				mVAR(); 

				}
				break;
			case 25 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:195: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 26 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:202: LESS
				{
				mLESS(); 

				}
				break;
			case 27 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:207: EQ
				{
				mEQ(); 

				}
				break;
			case 28 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:210: POINT
				{
				mPOINT(); 

				}
				break;
			case 29 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:216: MULT
				{
				mMULT(); 

				}
				break;
			case 30 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:221: PLUS
				{
				mPLUS(); 

				}
				break;
			case 31 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:226: MINUS
				{
				mMINUS(); 

				}
				break;
			case 32 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:232: DIV
				{
				mDIV(); 

				}
				break;
			case 33 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:236: MOD
				{
				mMOD(); 

				}
				break;
			case 34 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:240: SHRIEK
				{
				mSHRIEK(); 

				}
				break;
			case 35 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:247: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 36 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:253: SEMI
				{
				mSEMI(); 

				}
				break;
			case 37 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:258: COLON
				{
				mCOLON(); 

				}
				break;
			case 38 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:264: QUERY
				{
				mQUERY(); 

				}
				break;

		}
	}


	protected DFA11 dfa11 = new DFA11(this);
	static final String DFA11_eotS =
		"\1\uffff\1\40\1\47\1\50\1\52\1\40\1\56\12\uffff\1\57\1\40\1\61\13\uffff"+
		"\1\63\1\uffff\1\40\11\uffff\1\40\4\uffff\1\57\1\uffff\1\61\3\uffff\1\40"+
		"\4\uffff\1\75\11\uffff";
	static final String DFA11_eofS =
		"\105\uffff";
	static final String DFA11_minS =
		"\1\11\1\60\1\55\1\60\1\102\1\60\1\52\12\uffff\3\60\13\uffff\1\60\1\0\1"+
		"\60\1\156\5\uffff\1\0\2\uffff\1\60\3\uffff\1\0\1\60\1\0\1\60\1\0\1\uffff"+
		"\1\151\1\60\3\uffff\1\164\1\60\1\151\1\0\1\141\1\uffff\1\154\1\40\1\102"+
		"\2\uffff";
	static final String DFA11_maxS =
		"\1\176\1\172\1\156\1\172\1\102\1\172\1\57\12\uffff\3\172\13\uffff\1\172"+
		"\1\0\1\172\1\156\5\uffff\1\0\2\uffff\1\172\3\uffff\1\0\1\172\1\0\1\172"+
		"\1\0\1\uffff\1\151\1\172\3\uffff\1\164\1\172\1\151\1\0\1\141\1\uffff\1"+
		"\154\1\40\1\107\2\uffff";
	static final String DFA11_acceptS =
		"\7\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\3\uffff\1\26"+
		"\1\32\1\33\1\35\1\36\1\37\1\41\1\42\1\43\1\44\1\46\4\uffff\1\3\1\5\1\7"+
		"\1\10\1\45\1\uffff\1\6\1\34\1\uffff\1\12\1\13\1\40\5\uffff\1\30\2\uffff"+
		"\1\27\1\31\1\1\5\uffff\1\11\3\uffff\1\2\1\4";
	static final String DFA11_specialS =
		"\1\2\1\21\1\uffff\1\22\1\15\1\16\13\uffff\1\12\1\0\1\20\13\uffff\1\1\1"+
		"\5\1\24\6\uffff\1\7\2\uffff\1\13\3\uffff\1\3\1\17\1\6\1\11\1\4\2\uffff"+
		"\1\14\4\uffff\1\23\1\uffff\1\10\7\uffff}>";
	static final String[] DFA11_transitionS = {
			"\1\10\1\7\2\uffff\1\7\22\uffff\1\10\1\33\1\17\2\uffff\1\32\2\uffff\1"+
			"\11\1\12\1\27\1\30\1\34\1\31\1\4\1\6\12\23\1\2\1\35\1\25\1\26\1\uffff"+
			"\1\36\1\uffff\1\1\1\3\21\22\1\5\6\22\1\13\1\uffff\1\14\1\uffff\1\24\1"+
			"\uffff\32\21\1\15\1\uffff\1\16\1\20",
			"\12\41\7\uffff\16\41\1\37\13\41\4\uffff\1\41\1\uffff\32\41",
			"\1\45\23\uffff\1\46\7\uffff\1\42\10\uffff\1\43\33\uffff\1\44",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\51",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\21\41\1\53\10\41",
			"\1\54\4\uffff\1\55",
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
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\12\62\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
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
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\uffff",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\65",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"",
			"",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\24\41\1\66\5\41",
			"",
			"",
			"",
			"\1\uffff",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
			"\1\uffff",
			"\12\62\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"\1\uffff",
			"",
			"\1\72",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\73\25\41",
			"",
			"",
			"",
			"\1\74",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\76",
			"\1\uffff",
			"\1\100",
			"",
			"\1\101",
			"\1\102",
			"\1\103\4\uffff\1\104",
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
			return "1:1: Tokens : ( ACTIONONLY | BELIEFS | BELIEFRULES | GOAL | NAME | BELIEVE | BRULEARROW | ACTIONS | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA11_18 = input.LA(1);
						 
						int index11_18 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_18 >= '0' && LA11_18 <= '9')||(LA11_18 >= 'A' && LA11_18 <= 'Z')||LA11_18=='_'||(LA11_18 >= 'a' && LA11_18 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 33;}
						else s = 32;
						 
						input.seek(index11_18);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA11_31 = input.LA(1);
						 
						int index11_31 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_31 >= '0' && LA11_31 <= '9')||(LA11_31 >= 'A' && LA11_31 <= 'Z')||LA11_31=='_'||(LA11_31 >= 'a' && LA11_31 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 33;}
						else s = 51;
						 
						input.seek(index11_31);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA11_0 = input.LA(1);
						 
						int index11_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA11_0=='A') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 1;}
						else if ( (LA11_0==':') ) {s = 2;}
						else if ( (LA11_0=='B') && (((stringterm)||(!stringterm)||(curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)))) {s = 3;}
						else if ( (LA11_0=='.') ) {s = 4;}
						else if ( (LA11_0=='T') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 5;}
						else if ( (LA11_0=='/') ) {s = 6;}
						else if ( (LA11_0=='\n'||LA11_0=='\r') ) {s = 7;}
						else if ( (LA11_0=='\t'||LA11_0==' ') ) {s = 8;}
						else if ( (LA11_0=='(') ) {s = 9;}
						else if ( (LA11_0==')') ) {s = 10;}
						else if ( (LA11_0=='[') ) {s = 11;}
						else if ( (LA11_0==']') ) {s = 12;}
						else if ( (LA11_0=='{') ) {s = 13;}
						else if ( (LA11_0=='}') ) {s = 14;}
						else if ( (LA11_0=='\"') ) {s = 15;}
						else if ( (LA11_0=='~') ) {s = 16;}
						else if ( ((LA11_0 >= 'a' && LA11_0 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 17;}
						else if ( ((LA11_0 >= 'C' && LA11_0 <= 'S')||(LA11_0 >= 'U' && LA11_0 <= 'Z')) && (((stringterm)||(!stringterm)))) {s = 18;}
						else if ( ((LA11_0 >= '0' && LA11_0 <= '9')) && (((stringterm)||(!stringterm)))) {s = 19;}
						else if ( (LA11_0=='_') && ((stringterm))) {s = 20;}
						else if ( (LA11_0=='<') ) {s = 21;}
						else if ( (LA11_0=='=') ) {s = 22;}
						else if ( (LA11_0=='*') ) {s = 23;}
						else if ( (LA11_0=='+') ) {s = 24;}
						else if ( (LA11_0=='-') ) {s = 25;}
						else if ( (LA11_0=='%') ) {s = 26;}
						else if ( (LA11_0=='!') ) {s = 27;}
						else if ( (LA11_0==',') ) {s = 28;}
						else if ( (LA11_0==';') ) {s = 29;}
						else if ( (LA11_0=='?') ) {s = 30;}
						 
						input.seek(index11_0);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA11_47 = input.LA(1);
						 
						int index11_47 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 20;}
						else if ( ((!stringterm)) ) {s = 55;}
						 
						input.seek(index11_47);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA11_51 = input.LA(1);
						 
						int index11_51 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting == 0)) ) {s = 57;}
						else if ( ((stringterm)) ) {s = 20;}
						else if ( ((!stringterm)) ) {s = 52;}
						 
						input.seek(index11_51);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA11_32 = input.LA(1);
						 
						int index11_32 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 20;}
						else if ( ((!stringterm)) ) {s = 52;}
						 
						input.seek(index11_32);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA11_49 = input.LA(1);
						 
						int index11_49 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 20;}
						else if ( ((!stringterm)) ) {s = 56;}
						 
						input.seek(index11_49);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA11_40 = input.LA(1);
						 
						int index11_40 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {s = 41;}
						else if ( ((stringterm)) ) {s = 20;}
						else if ( ((!stringterm)) ) {s = 52;}
						 
						input.seek(index11_40);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA11_61 = input.LA(1);
						 
						int index11_61 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 63;}
						else if ( ((stringterm)) ) {s = 20;}
						else if ( ((!stringterm)) ) {s = 52;}
						 
						input.seek(index11_61);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA11_50 = input.LA(1);
						 
						int index11_50 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_50 >= '0' && LA11_50 <= '9')) && (((stringterm)||(!stringterm)))) {s = 50;}
						else if ( ((LA11_50 >= 'A' && LA11_50 <= 'Z')||LA11_50=='_'||(LA11_50 >= 'a' && LA11_50 <= 'z')) && ((stringterm))) {s = 20;}
						else s = 49;
						 
						input.seek(index11_50);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA11_17 = input.LA(1);
						 
						int index11_17 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_17 >= '0' && LA11_17 <= '9')||(LA11_17 >= 'A' && LA11_17 <= 'Z')||LA11_17=='_'||(LA11_17 >= 'a' && LA11_17 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 48;}
						else s = 47;
						 
						input.seek(index11_17);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA11_43 = input.LA(1);
						 
						int index11_43 = input.index();
						input.rewind();
						s = -1;
						if ( (LA11_43=='u') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 54;}
						else if ( ((LA11_43 >= '0' && LA11_43 <= '9')||(LA11_43 >= 'A' && LA11_43 <= 'Z')||LA11_43=='_'||(LA11_43 >= 'a' && LA11_43 <= 't')||(LA11_43 >= 'v' && LA11_43 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 33;}
						else s = 32;
						 
						input.seek(index11_43);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA11_54 = input.LA(1);
						 
						int index11_54 = input.index();
						input.rewind();
						s = -1;
						if ( (LA11_54=='e') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 59;}
						else if ( ((LA11_54 >= '0' && LA11_54 <= '9')||(LA11_54 >= 'A' && LA11_54 <= 'Z')||LA11_54=='_'||(LA11_54 >= 'a' && LA11_54 <= 'd')||(LA11_54 >= 'f' && LA11_54 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 33;}
						else s = 32;
						 
						input.seek(index11_54);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA11_4 = input.LA(1);
						 
						int index11_4 = input.index();
						input.rewind();
						s = -1;
						if ( (LA11_4=='B') && ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1))) {s = 41;}
						else s = 42;
						 
						input.seek(index11_4);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA11_5 = input.LA(1);
						 
						int index11_5 = input.index();
						input.rewind();
						s = -1;
						if ( (LA11_5=='r') && (((curly_nesting > 0 && plain_nesting == 0)||(stringterm)||(!stringterm)))) {s = 43;}
						else if ( ((LA11_5 >= '0' && LA11_5 <= '9')||(LA11_5 >= 'A' && LA11_5 <= 'Z')||LA11_5=='_'||(LA11_5 >= 'a' && LA11_5 <= 'q')||(LA11_5 >= 's' && LA11_5 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 33;}
						else s = 32;
						 
						input.seek(index11_5);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA11_48 = input.LA(1);
						 
						int index11_48 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_48 >= '0' && LA11_48 <= '9')||(LA11_48 >= 'A' && LA11_48 <= 'Z')||LA11_48=='_'||(LA11_48 >= 'a' && LA11_48 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 48;}
						else s = 47;
						 
						input.seek(index11_48);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA11_19 = input.LA(1);
						 
						int index11_19 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_19 >= '0' && LA11_19 <= '9')) && (((stringterm)||(!stringterm)))) {s = 50;}
						else if ( ((LA11_19 >= 'A' && LA11_19 <= 'Z')||LA11_19=='_'||(LA11_19 >= 'a' && LA11_19 <= 'z')) && ((stringterm))) {s = 20;}
						else s = 49;
						 
						input.seek(index11_19);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA11_1 = input.LA(1);
						 
						int index11_1 = input.index();
						input.rewind();
						s = -1;
						if ( (LA11_1=='O') && (((stringterm)||(!stringterm)||(curly_nesting == 0)))) {s = 31;}
						else if ( ((LA11_1 >= '0' && LA11_1 <= '9')||(LA11_1 >= 'A' && LA11_1 <= 'N')||(LA11_1 >= 'P' && LA11_1 <= 'Z')||LA11_1=='_'||(LA11_1 >= 'a' && LA11_1 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 33;}
						else s = 32;
						 
						input.seek(index11_1);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA11_3 = input.LA(1);
						 
						int index11_3 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_3 >= '0' && LA11_3 <= '9')||(LA11_3 >= 'A' && LA11_3 <= 'Z')||LA11_3=='_'||(LA11_3 >= 'a' && LA11_3 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 33;}
						else s = 40;
						 
						input.seek(index11_3);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA11_59 = input.LA(1);
						 
						int index11_59 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_59 >= '0' && LA11_59 <= '9')||(LA11_59 >= 'A' && LA11_59 <= 'Z')||LA11_59=='_'||(LA11_59 >= 'a' && LA11_59 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 33;}
						else s = 61;
						 
						input.seek(index11_59);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA11_33 = input.LA(1);
						 
						int index11_33 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_33 >= '0' && LA11_33 <= '9')||(LA11_33 >= 'A' && LA11_33 <= 'Z')||LA11_33=='_'||(LA11_33 >= 'a' && LA11_33 <= 'z')) && (((stringterm)||(!stringterm)))) {s = 33;}
						else s = 32;
						 
						input.seek(index11_33);
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 11, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
