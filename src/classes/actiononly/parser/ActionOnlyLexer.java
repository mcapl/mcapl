// $ANTLR 3.5.1 /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g 2014-09-25 16:06:04

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
	public static final int LESS=20;
	public static final int LINE_COMMENT=21;
	public static final int MINUS=22;
	public static final int MOD=23;
	public static final int MULT=24;
	public static final int NAME=25;
	public static final int NEWLINE=26;
	public static final int NOT=27;
	public static final int NUMBER=28;
	public static final int OPEN=29;
	public static final int PLUS=30;
	public static final int POINT=31;
	public static final int QUERY=32;
	public static final int SEMI=33;
	public static final int SHRIEK=34;
	public static final int SQCLOSE=35;
	public static final int SQOPEN=36;
	public static final int STRING=37;
	public static final int TRUE=38;
	public static final int VAR=39;
	public static final int WS=40;

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
	@Override public String getGrammarFileName() { return "/Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g"; }

	// $ANTLR start "ACTIONONLY"
	public final void mACTIONONLY() throws RecognitionException {
		try {
			int _type = ACTIONONLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:104:12: ({...}? => 'AO' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:104:13: {...}? => 'AO'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:106:9: ( ':Initial Beliefs:' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:106:11: ':Initial Beliefs:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:108:2: ( ':Reasoning Rules:' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:108:4: ':Reasoning Rules:'
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

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:109:6: ( ':name:' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:109:8: ':name:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:111:9: ({...}? => ( 'B' | '.B' ) )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:111:11: {...}? => ( 'B' | '.B' )
			{
			if ( !((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)) ) {
				throw new FailedPredicateException(input, "BELIEVE", "curly_nesting > 0 && plain_nesting == 0 || belief_rules==1");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:111:75: ( 'B' | '.B' )
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
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:111:76: 'B'
					{
					match('B'); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:111:82: '.B'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:113:2: ( ':-' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:113:4: ':-'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:114:9: ( ':Actions:' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:114:11: ':Actions:'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:115:6: ({...}? => 'True' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:115:8: {...}? => 'True'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:168:5: ( '/*' ( . )* '*/' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:168:7: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:168:12: ( . )*
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
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:168:12: .
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:171:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:171:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:171:12: (~ ( '\\n' | '\\r' ) )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:
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

			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:171:26: ( '\\r' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\r') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:171:26: '\\r'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:173:8: ( ( '\\r' )? '\\n' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:173:9: ( '\\r' )? '\\n'
			{
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:173:9: ( '\\r' )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='\r') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:173:9: '\\r'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:174:5: ( ( ' ' | '\\t' )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:174:9: ( ' ' | '\\t' )+
			{
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:174:9: ( ' ' | '\\t' )+
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
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:177:6: ( '(' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:177:9: '('
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:178:7: ( ')' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:178:9: ')'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:179:8: ( '[' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:179:10: '['
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:180:9: ( ']' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:180:11: ']'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:181:11: ( '{' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:181:13: '{'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:182:12: ( '}' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:182:14: '}'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:184:2: ( '\"' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:184:4: '\"'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:185:5: ( '~' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:185:7: '~'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:187:8: ({...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:187:10: {...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
			{
			if ( !((stringterm)) ) {
				throw new FailedPredicateException(input, "STRING", "stringterm");
			}
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:187:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
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
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:188:8: ({...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:188:11: {...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "CONST", "!stringterm");
			}
			matchRange('a','z'); 
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:188:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:189:5: ({...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:189:7: {...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "VAR", "!stringterm");
			}
			matchRange('A','Z'); 
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:189:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:190:8: ({...}? => '0' .. '9' ( '0' .. '9' )* )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:190:10: {...}? => '0' .. '9' ( '0' .. '9' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "NUMBER", "!stringterm");
			}
			matchRange('0','9'); 
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:190:35: ( '0' .. '9' )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:193:6: ( '<' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:193:8: '<'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:194:4: ( '==' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:194:7: '=='
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:195:7: ( '.' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:195:9: '.'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:196:6: ( '*' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:196:8: '*'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:197:6: ( '+' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:197:8: '+'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:198:7: ( '-' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:198:9: '-'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:199:5: ( '/' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:199:7: '/'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:200:5: ( '%' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:200:7: '%'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:202:8: ( '!' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:202:10: '!'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:203:7: ( ',' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:203:9: ','
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:204:6: ( ';' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:204:8: ';'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:205:7: ( ':' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:205:9: ':'
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
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:206:7: ( '?' )
			// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:206:9: '?'
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
		// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:8: ( ACTIONONLY | BELIEFS | BELIEFRULES | NAME | BELIEVE | BRULEARROW | ACTIONS | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY )
		int alt11=37;
		alt11 = dfa11.predict(input);
		switch (alt11) {
			case 1 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:10: ACTIONONLY
				{
				mACTIONONLY(); 

				}
				break;
			case 2 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:21: BELIEFS
				{
				mBELIEFS(); 

				}
				break;
			case 3 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:29: BELIEFRULES
				{
				mBELIEFRULES(); 

				}
				break;
			case 4 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:41: NAME
				{
				mNAME(); 

				}
				break;
			case 5 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:46: BELIEVE
				{
				mBELIEVE(); 

				}
				break;
			case 6 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:54: BRULEARROW
				{
				mBRULEARROW(); 

				}
				break;
			case 7 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:65: ACTIONS
				{
				mACTIONS(); 

				}
				break;
			case 8 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:73: TRUE
				{
				mTRUE(); 

				}
				break;
			case 9 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:78: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 10 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:86: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;
			case 11 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:99: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 12 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:107: WS
				{
				mWS(); 

				}
				break;
			case 13 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:110: OPEN
				{
				mOPEN(); 

				}
				break;
			case 14 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:115: CLOSE
				{
				mCLOSE(); 

				}
				break;
			case 15 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:121: SQOPEN
				{
				mSQOPEN(); 

				}
				break;
			case 16 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:128: SQCLOSE
				{
				mSQCLOSE(); 

				}
				break;
			case 17 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:136: CURLYOPEN
				{
				mCURLYOPEN(); 

				}
				break;
			case 18 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:146: CURLYCLOSE
				{
				mCURLYCLOSE(); 

				}
				break;
			case 19 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:157: DOUBLEQUOTE
				{
				mDOUBLEQUOTE(); 

				}
				break;
			case 20 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:169: NOT
				{
				mNOT(); 

				}
				break;
			case 21 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:173: STRING
				{
				mSTRING(); 

				}
				break;
			case 22 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:180: CONST
				{
				mCONST(); 

				}
				break;
			case 23 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:186: VAR
				{
				mVAR(); 

				}
				break;
			case 24 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:190: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 25 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:197: LESS
				{
				mLESS(); 

				}
				break;
			case 26 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:202: EQ
				{
				mEQ(); 

				}
				break;
			case 27 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:205: POINT
				{
				mPOINT(); 

				}
				break;
			case 28 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:211: MULT
				{
				mMULT(); 

				}
				break;
			case 29 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:216: PLUS
				{
				mPLUS(); 

				}
				break;
			case 30 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:221: MINUS
				{
				mMINUS(); 

				}
				break;
			case 31 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:227: DIV
				{
				mDIV(); 

				}
				break;
			case 32 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:231: MOD
				{
				mMOD(); 

				}
				break;
			case 33 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:235: SHRIEK
				{
				mSHRIEK(); 

				}
				break;
			case 34 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:242: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 35 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:248: SEMI
				{
				mSEMI(); 

				}
				break;
			case 36 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:253: COLON
				{
				mCOLON(); 

				}
				break;
			case 37 :
				// /Users/lad/Eclipse/mcapl/src/classes/actiononly/parser/ActionOnly.g:1:259: QUERY
				{
				mQUERY(); 

				}
				break;

		}
	}


	protected DFA11 dfa11 = new DFA11(this);
	static final String DFA11_eotS =
		"\1\uffff\1\40\1\47\1\50\1\52\1\40\1\56\12\uffff\1\57\1\40\1\61\13\uffff"+
		"\1\63\1\uffff\1\40\11\uffff\1\40\4\uffff\1\57\1\uffff\1\61\2\uffff\1\40"+
		"\3\uffff\1\72\2\uffff";
	static final String DFA11_eofS =
		"\74\uffff";
	static final String DFA11_minS =
		"\1\11\1\60\1\55\1\60\1\102\1\60\1\52\12\uffff\3\60\13\uffff\1\60\1\0\1"+
		"\60\6\uffff\1\0\2\uffff\1\60\3\uffff\1\0\1\60\1\0\1\60\1\0\1\uffff\1\60"+
		"\3\uffff\1\60\1\0\1\uffff";
	static final String DFA11_maxS =
		"\1\176\1\172\1\156\1\172\1\102\1\172\1\57\12\uffff\3\172\13\uffff\1\172"+
		"\1\0\1\172\6\uffff\1\0\2\uffff\1\172\3\uffff\1\0\1\172\1\0\1\172\1\0\1"+
		"\uffff\1\172\3\uffff\1\172\1\0\1\uffff";
	static final String DFA11_acceptS =
		"\7\uffff\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\3\uffff\1\25"+
		"\1\31\1\32\1\34\1\35\1\36\1\40\1\41\1\42\1\43\1\45\3\uffff\1\2\1\3\1\4"+
		"\1\6\1\7\1\44\1\uffff\1\5\1\33\1\uffff\1\11\1\12\1\37\5\uffff\1\27\1\uffff"+
		"\1\26\1\30\1\1\2\uffff\1\10";
	static final String DFA11_specialS =
		"\1\20\1\6\1\uffff\1\11\1\12\1\24\13\uffff\1\1\1\23\1\5\13\uffff\1\2\1"+
		"\16\1\10\6\uffff\1\14\2\uffff\1\4\3\uffff\1\15\1\22\1\17\1\3\1\7\1\uffff"+
		"\1\0\3\uffff\1\21\1\13\1\uffff}>";
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
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"",
			"",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\24\41\1\65\5\41",
			"",
			"",
			"",
			"\1\uffff",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
			"\1\uffff",
			"\12\62\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"\1\uffff",
			"",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\71\25\41",
			"",
			"",
			"",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\uffff",
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
			return "1:1: Tokens : ( ACTIONONLY | BELIEFS | BELIEFRULES | NAME | BELIEVE | BRULEARROW | ACTIONS | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA11_53 = input.LA(1);
						 
						int index11_53 = input.index();
						input.rewind();
						s = -1;
						if ( (LA11_53=='e') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 57;}
						else if ( ((LA11_53 >= '0' && LA11_53 <= '9')||(LA11_53 >= 'A' && LA11_53 <= 'Z')||LA11_53=='_'||(LA11_53 >= 'a' && LA11_53 <= 'd')||(LA11_53 >= 'f' && LA11_53 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 33;}
						else s = 32;
						 
						input.seek(index11_53);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA11_17 = input.LA(1);
						 
						int index11_17 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_17 >= '0' && LA11_17 <= '9')||(LA11_17 >= 'A' && LA11_17 <= 'Z')||LA11_17=='_'||(LA11_17 >= 'a' && LA11_17 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 48;}
						else s = 47;
						 
						input.seek(index11_17);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA11_31 = input.LA(1);
						 
						int index11_31 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_31 >= '0' && LA11_31 <= '9')||(LA11_31 >= 'A' && LA11_31 <= 'Z')||LA11_31=='_'||(LA11_31 >= 'a' && LA11_31 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 33;}
						else s = 51;
						 
						input.seek(index11_31);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA11_50 = input.LA(1);
						 
						int index11_50 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_50 >= '0' && LA11_50 <= '9')) && (((!stringterm)||(stringterm)))) {s = 50;}
						else if ( ((LA11_50 >= 'A' && LA11_50 <= 'Z')||LA11_50=='_'||(LA11_50 >= 'a' && LA11_50 <= 'z')) && ((stringterm))) {s = 20;}
						else s = 49;
						 
						input.seek(index11_50);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA11_43 = input.LA(1);
						 
						int index11_43 = input.index();
						input.rewind();
						s = -1;
						if ( (LA11_43=='u') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 53;}
						else if ( ((LA11_43 >= '0' && LA11_43 <= '9')||(LA11_43 >= 'A' && LA11_43 <= 'Z')||LA11_43=='_'||(LA11_43 >= 'a' && LA11_43 <= 't')||(LA11_43 >= 'v' && LA11_43 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 33;}
						else s = 32;
						 
						input.seek(index11_43);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA11_19 = input.LA(1);
						 
						int index11_19 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_19 >= '0' && LA11_19 <= '9')) && (((!stringterm)||(stringterm)))) {s = 50;}
						else if ( ((LA11_19 >= 'A' && LA11_19 <= 'Z')||LA11_19=='_'||(LA11_19 >= 'a' && LA11_19 <= 'z')) && ((stringterm))) {s = 20;}
						else s = 49;
						 
						input.seek(index11_19);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA11_1 = input.LA(1);
						 
						int index11_1 = input.index();
						input.rewind();
						s = -1;
						if ( (LA11_1=='O') && (((curly_nesting == 0)||(stringterm)||(!stringterm)))) {s = 31;}
						else if ( ((LA11_1 >= '0' && LA11_1 <= '9')||(LA11_1 >= 'A' && LA11_1 <= 'N')||(LA11_1 >= 'P' && LA11_1 <= 'Z')||LA11_1=='_'||(LA11_1 >= 'a' && LA11_1 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 33;}
						else s = 32;
						 
						input.seek(index11_1);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA11_51 = input.LA(1);
						 
						int index11_51 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting == 0)) ) {s = 56;}
						else if ( ((stringterm)) ) {s = 20;}
						else if ( ((!stringterm)) ) {s = 52;}
						 
						input.seek(index11_51);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA11_33 = input.LA(1);
						 
						int index11_33 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_33 >= '0' && LA11_33 <= '9')||(LA11_33 >= 'A' && LA11_33 <= 'Z')||LA11_33=='_'||(LA11_33 >= 'a' && LA11_33 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 33;}
						else s = 32;
						 
						input.seek(index11_33);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA11_3 = input.LA(1);
						 
						int index11_3 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_3 >= '0' && LA11_3 <= '9')||(LA11_3 >= 'A' && LA11_3 <= 'Z')||LA11_3=='_'||(LA11_3 >= 'a' && LA11_3 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 33;}
						else s = 40;
						 
						input.seek(index11_3);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA11_4 = input.LA(1);
						 
						int index11_4 = input.index();
						input.rewind();
						s = -1;
						if ( (LA11_4=='B') && ((curly_nesting > 0 && plain_nesting == 0 || belief_rules==1))) {s = 41;}
						else s = 42;
						 
						input.seek(index11_4);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA11_58 = input.LA(1);
						 
						int index11_58 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 59;}
						else if ( ((stringterm)) ) {s = 20;}
						else if ( ((!stringterm)) ) {s = 52;}
						 
						input.seek(index11_58);
						if ( s>=0 ) return s;
						break;

					case 12 : 
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

					case 13 : 
						int LA11_47 = input.LA(1);
						 
						int index11_47 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 20;}
						else if ( ((!stringterm)) ) {s = 54;}
						 
						input.seek(index11_47);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA11_32 = input.LA(1);
						 
						int index11_32 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 20;}
						else if ( ((!stringterm)) ) {s = 52;}
						 
						input.seek(index11_32);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA11_49 = input.LA(1);
						 
						int index11_49 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 20;}
						else if ( ((!stringterm)) ) {s = 55;}
						 
						input.seek(index11_49);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA11_0 = input.LA(1);
						 
						int index11_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA11_0=='A') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 1;}
						else if ( (LA11_0==':') ) {s = 2;}
						else if ( (LA11_0=='B') && (((stringterm)||(!stringterm)||(curly_nesting > 0 && plain_nesting == 0 || belief_rules==1)))) {s = 3;}
						else if ( (LA11_0=='.') ) {s = 4;}
						else if ( (LA11_0=='T') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 5;}
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
						else if ( ((LA11_0 >= 'a' && LA11_0 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 17;}
						else if ( ((LA11_0 >= 'C' && LA11_0 <= 'S')||(LA11_0 >= 'U' && LA11_0 <= 'Z')) && (((!stringterm)||(stringterm)))) {s = 18;}
						else if ( ((LA11_0 >= '0' && LA11_0 <= '9')) && (((!stringterm)||(stringterm)))) {s = 19;}
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

					case 17 : 
						int LA11_57 = input.LA(1);
						 
						int index11_57 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_57 >= '0' && LA11_57 <= '9')||(LA11_57 >= 'A' && LA11_57 <= 'Z')||LA11_57=='_'||(LA11_57 >= 'a' && LA11_57 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 33;}
						else s = 58;
						 
						input.seek(index11_57);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA11_48 = input.LA(1);
						 
						int index11_48 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_48 >= '0' && LA11_48 <= '9')||(LA11_48 >= 'A' && LA11_48 <= 'Z')||LA11_48=='_'||(LA11_48 >= 'a' && LA11_48 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 48;}
						else s = 47;
						 
						input.seek(index11_48);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA11_18 = input.LA(1);
						 
						int index11_18 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA11_18 >= '0' && LA11_18 <= '9')||(LA11_18 >= 'A' && LA11_18 <= 'Z')||LA11_18=='_'||(LA11_18 >= 'a' && LA11_18 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 33;}
						else s = 32;
						 
						input.seek(index11_18);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA11_5 = input.LA(1);
						 
						int index11_5 = input.index();
						input.rewind();
						s = -1;
						if ( (LA11_5=='r') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 43;}
						else if ( ((LA11_5 >= '0' && LA11_5 <= '9')||(LA11_5 >= 'A' && LA11_5 <= 'Z')||LA11_5=='_'||(LA11_5 >= 'a' && LA11_5 <= 'q')||(LA11_5 >= 's' && LA11_5 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 33;}
						else s = 32;
						 
						input.seek(index11_5);
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
