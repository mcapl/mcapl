// $ANTLR 3.5.1 /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g 2014-09-29 11:20:44

package ethical_governor.parser;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class EthicalGovernorLexer extends Lexer {
	public static final int EOF=-1;
	public static final int AGENT=4;
	public static final int CLOSE=5;
	public static final int COLON=6;
	public static final int COMMA=7;
	public static final int COMMENT=8;
	public static final int CONST=9;
	public static final int CURLYCLOSE=10;
	public static final int CURLYOPEN=11;
	public static final int DEG=12;
	public static final int DIV=13;
	public static final int DOUBLEQUOTE=14;
	public static final int EQ=15;
	public static final int GEQ=16;
	public static final int LESS=17;
	public static final int LINE_COMMENT=18;
	public static final int MINUS=19;
	public static final int MOD=20;
	public static final int MULT=21;
	public static final int NAME=22;
	public static final int NEWLINE=23;
	public static final int NOT=24;
	public static final int NUMBER=25;
	public static final int OPEN=26;
	public static final int PLUS=27;
	public static final int POINT=28;
	public static final int PRECEDENCE=29;
	public static final int QUERY=30;
	public static final int SCORES=31;
	public static final int SEMI=32;
	public static final int SHRIEK=33;
	public static final int SQCLOSE=34;
	public static final int SQOPEN=35;
	public static final int STRING=36;
	public static final int TRUE=37;
	public static final int VAR=38;
	public static final int WS=39;

	    public int plain_nesting = 0;
	    public int sq_nesting = 0;
	    public int curly_nesting = 0;
	    public boolean stringterm = false;
	    public int belief_rules = 0;


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public EthicalGovernorLexer() {} 
	public EthicalGovernorLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public EthicalGovernorLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g"; }

	// $ANTLR start "GEQ"
	public final void mGEQ() throws RecognitionException {
		try {
			int _type = GEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:76:6: ( '>' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:76:8: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GEQ"

	// $ANTLR start "SCORES"
	public final void mSCORES() throws RecognitionException {
		try {
			int _type = SCORES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:77:8: ( ':Outcome Scores:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:77:10: ':Outcome Scores:'
			{
			match(":Outcome Scores:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SCORES"

	// $ANTLR start "PRECEDENCE"
	public final void mPRECEDENCE() throws RecognitionException {
		try {
			int _type = PRECEDENCE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:79:2: ( ':Ethical Precedence:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:79:4: ':Ethical Precedence:'
			{
			match(":Ethical Precedence:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRECEDENCE"

	// $ANTLR start "DEG"
	public final void mDEG() throws RecognitionException {
		try {
			int _type = DEG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:80:5: ({...}? => 'ETHICAL GOVERNOR' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:80:7: {...}? => 'ETHICAL GOVERNOR'
			{
			if ( !((curly_nesting == 0)) ) {
				throw new FailedPredicateException(input, "DEG", "curly_nesting == 0");
			}
			match("ETHICAL GOVERNOR"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEG"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:81:6: ( ':name:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:81:8: ':name:'
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

	// $ANTLR start "AGENT"
	public final void mAGENT() throws RecognitionException {
		try {
			int _type = AGENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:83:2: ( ':agent:' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:83:4: ':agent:'
			{
			match(":agent:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AGENT"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:84:6: ({...}? => 'True' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:84:8: {...}? => 'True'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:137:5: ( '/*' ( . )* '*/' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:137:7: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:137:12: ( . )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='*') ) {
					int LA1_1 = input.LA(2);
					if ( (LA1_1=='/') ) {
						alt1=2;
					}
					else if ( ((LA1_1 >= '\u0000' && LA1_1 <= '.')||(LA1_1 >= '0' && LA1_1 <= '\uFFFF')) ) {
						alt1=1;
					}

				}
				else if ( ((LA1_0 >= '\u0000' && LA1_0 <= ')')||(LA1_0 >= '+' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:137:12: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop1;
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:140:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:140:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:140:12: (~ ( '\\n' | '\\r' ) )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:
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
					break loop2;
				}
			}

			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:140:26: ( '\\r' )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='\r') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:140:26: '\\r'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:142:8: ( ( '\\r' )? '\\n' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:142:9: ( '\\r' )? '\\n'
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:142:9: ( '\\r' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\r') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:142:9: '\\r'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:143:5: ( ( ' ' | '\\t' )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:143:9: ( ' ' | '\\t' )+
			{
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:143:9: ( ' ' | '\\t' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='\t'||LA5_0==' ') ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:
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
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:146:6: ( '(' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:146:9: '('
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:147:7: ( ')' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:147:9: ')'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:148:8: ( '[' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:148:10: '['
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:149:9: ( ']' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:149:11: ']'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:150:11: ( '{' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:150:13: '{'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:151:12: ( '}' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:151:14: '}'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:153:2: ( '\"' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:153:4: '\"'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:155:5: ( '~' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:155:7: '~'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:157:8: ({...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:157:10: {...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
			{
			if ( !((stringterm)) ) {
				throw new FailedPredicateException(input, "STRING", "stringterm");
			}
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:157:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:
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
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:158:8: ({...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:158:11: {...}? => 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "CONST", "!stringterm");
			}
			matchRange('a','z'); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:158:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:
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
					break loop7;
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:159:5: ({...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:159:7: {...}? => 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "VAR", "!stringterm");
			}
			matchRange('A','Z'); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:159:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:
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
	// $ANTLR end "VAR"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:160:8: ({...}? => '0' .. '9' ( '0' .. '9' )* )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:160:10: {...}? => '0' .. '9' ( '0' .. '9' )*
			{
			if ( !((!stringterm)) ) {
				throw new FailedPredicateException(input, "NUMBER", "!stringterm");
			}
			matchRange('0','9'); 
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:160:35: ( '0' .. '9' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:
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
	// $ANTLR end "NUMBER"

	// $ANTLR start "LESS"
	public final void mLESS() throws RecognitionException {
		try {
			int _type = LESS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:163:6: ( '<' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:163:8: '<'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:164:4: ( '==' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:164:7: '=='
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:165:7: ( '.' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:165:9: '.'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:166:6: ( '*' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:166:8: '*'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:167:6: ( '+' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:167:8: '+'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:168:7: ( '-' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:168:9: '-'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:169:5: ( '/' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:169:7: '/'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:170:5: ( '%' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:170:7: '%'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:172:8: ( '!' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:172:10: '!'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:173:7: ( ',' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:173:9: ','
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:174:6: ( ';' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:174:8: ';'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:175:7: ( ':' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:175:9: ':'
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
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:176:7: ( '?' )
			// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:176:9: '?'
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
		// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:8: ( GEQ | SCORES | PRECEDENCE | DEG | NAME | AGENT | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY )
		int alt10=36;
		alt10 = dfa10.predict(input);
		switch (alt10) {
			case 1 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:10: GEQ
				{
				mGEQ(); 

				}
				break;
			case 2 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:14: SCORES
				{
				mSCORES(); 

				}
				break;
			case 3 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:21: PRECEDENCE
				{
				mPRECEDENCE(); 

				}
				break;
			case 4 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:32: DEG
				{
				mDEG(); 

				}
				break;
			case 5 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:36: NAME
				{
				mNAME(); 

				}
				break;
			case 6 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:41: AGENT
				{
				mAGENT(); 

				}
				break;
			case 7 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:47: TRUE
				{
				mTRUE(); 

				}
				break;
			case 8 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:52: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 9 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:60: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;
			case 10 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:73: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 11 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:81: WS
				{
				mWS(); 

				}
				break;
			case 12 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:84: OPEN
				{
				mOPEN(); 

				}
				break;
			case 13 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:89: CLOSE
				{
				mCLOSE(); 

				}
				break;
			case 14 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:95: SQOPEN
				{
				mSQOPEN(); 

				}
				break;
			case 15 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:102: SQCLOSE
				{
				mSQCLOSE(); 

				}
				break;
			case 16 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:110: CURLYOPEN
				{
				mCURLYOPEN(); 

				}
				break;
			case 17 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:120: CURLYCLOSE
				{
				mCURLYCLOSE(); 

				}
				break;
			case 18 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:131: DOUBLEQUOTE
				{
				mDOUBLEQUOTE(); 

				}
				break;
			case 19 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:143: NOT
				{
				mNOT(); 

				}
				break;
			case 20 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:147: STRING
				{
				mSTRING(); 

				}
				break;
			case 21 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:154: CONST
				{
				mCONST(); 

				}
				break;
			case 22 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:160: VAR
				{
				mVAR(); 

				}
				break;
			case 23 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:164: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 24 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:171: LESS
				{
				mLESS(); 

				}
				break;
			case 25 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:176: EQ
				{
				mEQ(); 

				}
				break;
			case 26 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:179: POINT
				{
				mPOINT(); 

				}
				break;
			case 27 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:185: MULT
				{
				mMULT(); 

				}
				break;
			case 28 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:190: PLUS
				{
				mPLUS(); 

				}
				break;
			case 29 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:195: MINUS
				{
				mMINUS(); 

				}
				break;
			case 30 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:201: DIV
				{
				mDIV(); 

				}
				break;
			case 31 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:205: MOD
				{
				mMOD(); 

				}
				break;
			case 32 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:209: SHRIEK
				{
				mSHRIEK(); 

				}
				break;
			case 33 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:216: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 34 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:222: SEMI
				{
				mSEMI(); 

				}
				break;
			case 35 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:227: COLON
				{
				mCOLON(); 

				}
				break;
			case 36 :
				// /Users/louiseadennis/Eclipse/mcapl/src/classes/ethical_governor/parser/EthicalGovernor.g:1:233: QUERY
				{
				mQUERY(); 

				}
				break;

		}
	}


	protected DFA10 dfa10 = new DFA10(this);
	static final String DFA10_eotS =
		"\2\uffff\1\43\2\45\1\52\12\uffff\1\53\1\45\1\55\21\uffff\1\45\1\uffff"+
		"\2\45\4\uffff\1\53\1\uffff\1\55\1\45\1\uffff\1\45\2\uffff\1\45\1\67\1"+
		"\45\1\uffff\1\45\1\uffff\1\45\1\uffff";
	static final String DFA10_eofS =
		"\74\uffff";
	static final String DFA10_minS =
		"\1\11\1\uffff\1\105\2\60\1\52\12\uffff\3\60\21\uffff\1\60\1\0\2\60\3\uffff"+
		"\1\0\1\60\1\0\2\60\1\uffff\1\60\2\uffff\3\60\1\0\1\60\1\uffff\1\40\1\uffff";
	static final String DFA10_maxS =
		"\1\176\1\uffff\1\156\2\172\1\57\12\uffff\3\172\21\uffff\1\172\1\0\2\172"+
		"\3\uffff\1\0\1\172\1\0\2\172\1\uffff\1\172\2\uffff\3\172\1\0\1\172\1\uffff"+
		"\1\172\1\uffff";
	static final String DFA10_acceptS =
		"\1\uffff\1\1\4\uffff\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
		"\3\uffff\1\24\1\30\1\31\1\32\1\33\1\34\1\35\1\37\1\40\1\41\1\42\1\44\1"+
		"\2\1\3\1\5\1\6\1\43\4\uffff\1\10\1\11\1\36\5\uffff\1\26\1\uffff\1\25\1"+
		"\27\5\uffff\1\7\1\uffff\1\4";
	static final String DFA10_specialS =
		"\1\14\2\uffff\1\10\1\13\13\uffff\1\16\1\5\1\25\21\uffff\1\0\1\21\1\11"+
		"\1\23\3\uffff\1\17\1\22\1\20\1\15\1\1\1\uffff\1\24\2\uffff\1\2\1\12\1"+
		"\3\1\7\1\4\1\uffff\1\6\1\uffff}>";
	static final String[] DFA10_transitionS = {
			"\1\7\1\6\2\uffff\1\6\22\uffff\1\7\1\33\1\16\2\uffff\1\32\2\uffff\1\10"+
			"\1\11\1\27\1\30\1\34\1\31\1\26\1\5\12\22\1\2\1\35\1\24\1\25\1\1\1\36"+
			"\1\uffff\4\21\1\3\16\21\1\4\6\21\1\12\1\uffff\1\13\1\uffff\1\23\1\uffff"+
			"\32\20\1\14\1\uffff\1\15\1\17",
			"",
			"\1\40\11\uffff\1\37\21\uffff\1\42\14\uffff\1\41",
			"\12\46\7\uffff\23\46\1\44\6\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\21\46\1\47\10\46",
			"\1\50\4\uffff\1\51",
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
			"\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\56\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
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
			"",
			"\12\46\7\uffff\7\46\1\57\22\46\4\uffff\1\46\1\uffff\32\46",
			"\1\uffff",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\24\46\1\61\5\46",
			"",
			"",
			"",
			"\1\uffff",
			"\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\uffff",
			"\12\56\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\12\46\7\uffff\10\46\1\64\21\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\4\46\1\65\25\46",
			"",
			"",
			"\12\46\7\uffff\2\46\1\66\27\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\1\70\31\46\4\uffff\1\46\1\uffff\32\46",
			"\1\uffff",
			"\12\46\7\uffff\13\46\1\72\16\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"\1\73\17\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			""
	};

	static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
	static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
	static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
	static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
	static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
	static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
	static final short[][] DFA10_transition;

	static {
		int numStates = DFA10_transitionS.length;
		DFA10_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
		}
	}

	protected class DFA10 extends DFA {

		public DFA10(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 10;
			this.eot = DFA10_eot;
			this.eof = DFA10_eof;
			this.min = DFA10_min;
			this.max = DFA10_max;
			this.accept = DFA10_accept;
			this.special = DFA10_special;
			this.transition = DFA10_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( GEQ | SCORES | PRECEDENCE | DEG | NAME | AGENT | TRUE | COMMENT | LINE_COMMENT | NEWLINE | WS | OPEN | CLOSE | SQOPEN | SQCLOSE | CURLYOPEN | CURLYCLOSE | DOUBLEQUOTE | NOT | STRING | CONST | VAR | NUMBER | LESS | EQ | POINT | MULT | PLUS | MINUS | DIV | MOD | SHRIEK | COMMA | SEMI | COLON | QUERY );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA10_36 = input.LA(1);
						 
						int index10_36 = input.index();
						input.rewind();
						s = -1;
						if ( (LA10_36=='H') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 47;}
						else if ( ((LA10_36 >= '0' && LA10_36 <= '9')||(LA10_36 >= 'A' && LA10_36 <= 'G')||(LA10_36 >= 'I' && LA10_36 <= 'Z')||LA10_36=='_'||(LA10_36 >= 'a' && LA10_36 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 38;}
						else s = 37;
						 
						input.seek(index10_36);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA10_47 = input.LA(1);
						 
						int index10_47 = input.index();
						input.rewind();
						s = -1;
						if ( (LA10_47=='I') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 52;}
						else if ( ((LA10_47 >= '0' && LA10_47 <= '9')||(LA10_47 >= 'A' && LA10_47 <= 'H')||(LA10_47 >= 'J' && LA10_47 <= 'Z')||LA10_47=='_'||(LA10_47 >= 'a' && LA10_47 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 38;}
						else s = 37;
						 
						input.seek(index10_47);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA10_52 = input.LA(1);
						 
						int index10_52 = input.index();
						input.rewind();
						s = -1;
						if ( (LA10_52=='C') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 54;}
						else if ( ((LA10_52 >= '0' && LA10_52 <= '9')||(LA10_52 >= 'A' && LA10_52 <= 'B')||(LA10_52 >= 'D' && LA10_52 <= 'Z')||LA10_52=='_'||(LA10_52 >= 'a' && LA10_52 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 38;}
						else s = 37;
						 
						input.seek(index10_52);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA10_54 = input.LA(1);
						 
						int index10_54 = input.index();
						input.rewind();
						s = -1;
						if ( (LA10_54=='A') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 56;}
						else if ( ((LA10_54 >= '0' && LA10_54 <= '9')||(LA10_54 >= 'B' && LA10_54 <= 'Z')||LA10_54=='_'||(LA10_54 >= 'a' && LA10_54 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 38;}
						else s = 37;
						 
						input.seek(index10_54);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA10_56 = input.LA(1);
						 
						int index10_56 = input.index();
						input.rewind();
						s = -1;
						if ( (LA10_56=='L') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 58;}
						else if ( ((LA10_56 >= '0' && LA10_56 <= '9')||(LA10_56 >= 'A' && LA10_56 <= 'K')||(LA10_56 >= 'M' && LA10_56 <= 'Z')||LA10_56=='_'||(LA10_56 >= 'a' && LA10_56 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 38;}
						else s = 37;
						 
						input.seek(index10_56);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA10_17 = input.LA(1);
						 
						int index10_17 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA10_17 >= '0' && LA10_17 <= '9')||(LA10_17 >= 'A' && LA10_17 <= 'Z')||LA10_17=='_'||(LA10_17 >= 'a' && LA10_17 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 38;}
						else s = 37;
						 
						input.seek(index10_17);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA10_58 = input.LA(1);
						 
						int index10_58 = input.index();
						input.rewind();
						s = -1;
						if ( (LA10_58==' ') && ((curly_nesting == 0))) {s = 59;}
						else if ( ((LA10_58 >= '0' && LA10_58 <= '9')||(LA10_58 >= 'A' && LA10_58 <= 'Z')||LA10_58=='_'||(LA10_58 >= 'a' && LA10_58 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 38;}
						else s = 37;
						 
						input.seek(index10_58);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA10_55 = input.LA(1);
						 
						int index10_55 = input.index();
						input.rewind();
						s = -1;
						if ( ((curly_nesting > 0 && plain_nesting == 0)) ) {s = 57;}
						else if ( ((stringterm)) ) {s = 19;}
						else if ( ((!stringterm)) ) {s = 48;}
						 
						input.seek(index10_55);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA10_3 = input.LA(1);
						 
						int index10_3 = input.index();
						input.rewind();
						s = -1;
						if ( (LA10_3=='T') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 36;}
						else if ( ((LA10_3 >= '0' && LA10_3 <= '9')||(LA10_3 >= 'A' && LA10_3 <= 'S')||(LA10_3 >= 'U' && LA10_3 <= 'Z')||LA10_3=='_'||(LA10_3 >= 'a' && LA10_3 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 38;}
						else s = 37;
						 
						input.seek(index10_3);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA10_38 = input.LA(1);
						 
						int index10_38 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA10_38 >= '0' && LA10_38 <= '9')||(LA10_38 >= 'A' && LA10_38 <= 'Z')||LA10_38=='_'||(LA10_38 >= 'a' && LA10_38 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 38;}
						else s = 37;
						 
						input.seek(index10_38);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA10_53 = input.LA(1);
						 
						int index10_53 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA10_53 >= '0' && LA10_53 <= '9')||(LA10_53 >= 'A' && LA10_53 <= 'Z')||LA10_53=='_'||(LA10_53 >= 'a' && LA10_53 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 38;}
						else s = 55;
						 
						input.seek(index10_53);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA10_4 = input.LA(1);
						 
						int index10_4 = input.index();
						input.rewind();
						s = -1;
						if ( (LA10_4=='r') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 39;}
						else if ( ((LA10_4 >= '0' && LA10_4 <= '9')||(LA10_4 >= 'A' && LA10_4 <= 'Z')||LA10_4=='_'||(LA10_4 >= 'a' && LA10_4 <= 'q')||(LA10_4 >= 's' && LA10_4 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 38;}
						else s = 37;
						 
						input.seek(index10_4);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA10_0 = input.LA(1);
						 
						int index10_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA10_0=='>') ) {s = 1;}
						else if ( (LA10_0==':') ) {s = 2;}
						else if ( (LA10_0=='E') && (((curly_nesting == 0)||(!stringterm)||(stringterm)))) {s = 3;}
						else if ( (LA10_0=='T') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 4;}
						else if ( (LA10_0=='/') ) {s = 5;}
						else if ( (LA10_0=='\n'||LA10_0=='\r') ) {s = 6;}
						else if ( (LA10_0=='\t'||LA10_0==' ') ) {s = 7;}
						else if ( (LA10_0=='(') ) {s = 8;}
						else if ( (LA10_0==')') ) {s = 9;}
						else if ( (LA10_0=='[') ) {s = 10;}
						else if ( (LA10_0==']') ) {s = 11;}
						else if ( (LA10_0=='{') ) {s = 12;}
						else if ( (LA10_0=='}') ) {s = 13;}
						else if ( (LA10_0=='\"') ) {s = 14;}
						else if ( (LA10_0=='~') ) {s = 15;}
						else if ( ((LA10_0 >= 'a' && LA10_0 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 16;}
						else if ( ((LA10_0 >= 'A' && LA10_0 <= 'D')||(LA10_0 >= 'F' && LA10_0 <= 'S')||(LA10_0 >= 'U' && LA10_0 <= 'Z')) && (((!stringterm)||(stringterm)))) {s = 17;}
						else if ( ((LA10_0 >= '0' && LA10_0 <= '9')) && (((!stringterm)||(stringterm)))) {s = 18;}
						else if ( (LA10_0=='_') && ((stringterm))) {s = 19;}
						else if ( (LA10_0=='<') ) {s = 20;}
						else if ( (LA10_0=='=') ) {s = 21;}
						else if ( (LA10_0=='.') ) {s = 22;}
						else if ( (LA10_0=='*') ) {s = 23;}
						else if ( (LA10_0=='+') ) {s = 24;}
						else if ( (LA10_0=='-') ) {s = 25;}
						else if ( (LA10_0=='%') ) {s = 26;}
						else if ( (LA10_0=='!') ) {s = 27;}
						else if ( (LA10_0==',') ) {s = 28;}
						else if ( (LA10_0==';') ) {s = 29;}
						else if ( (LA10_0=='?') ) {s = 30;}
						 
						input.seek(index10_0);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA10_46 = input.LA(1);
						 
						int index10_46 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA10_46 >= '0' && LA10_46 <= '9')) && (((!stringterm)||(stringterm)))) {s = 46;}
						else if ( ((LA10_46 >= 'A' && LA10_46 <= 'Z')||LA10_46=='_'||(LA10_46 >= 'a' && LA10_46 <= 'z')) && ((stringterm))) {s = 19;}
						else s = 45;
						 
						input.seek(index10_46);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA10_16 = input.LA(1);
						 
						int index10_16 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA10_16 >= '0' && LA10_16 <= '9')||(LA10_16 >= 'A' && LA10_16 <= 'Z')||LA10_16=='_'||(LA10_16 >= 'a' && LA10_16 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 44;}
						else s = 43;
						 
						input.seek(index10_16);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA10_43 = input.LA(1);
						 
						int index10_43 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 19;}
						else if ( ((!stringterm)) ) {s = 50;}
						 
						input.seek(index10_43);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA10_45 = input.LA(1);
						 
						int index10_45 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 19;}
						else if ( ((!stringterm)) ) {s = 51;}
						 
						input.seek(index10_45);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA10_37 = input.LA(1);
						 
						int index10_37 = input.index();
						input.rewind();
						s = -1;
						if ( ((stringterm)) ) {s = 19;}
						else if ( ((!stringterm)) ) {s = 48;}
						 
						input.seek(index10_37);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA10_44 = input.LA(1);
						 
						int index10_44 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA10_44 >= '0' && LA10_44 <= '9')||(LA10_44 >= 'A' && LA10_44 <= 'Z')||LA10_44=='_'||(LA10_44 >= 'a' && LA10_44 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 44;}
						else s = 43;
						 
						input.seek(index10_44);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA10_39 = input.LA(1);
						 
						int index10_39 = input.index();
						input.rewind();
						s = -1;
						if ( (LA10_39=='u') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 49;}
						else if ( ((LA10_39 >= '0' && LA10_39 <= '9')||(LA10_39 >= 'A' && LA10_39 <= 'Z')||LA10_39=='_'||(LA10_39 >= 'a' && LA10_39 <= 't')||(LA10_39 >= 'v' && LA10_39 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 38;}
						else s = 37;
						 
						input.seek(index10_39);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA10_49 = input.LA(1);
						 
						int index10_49 = input.index();
						input.rewind();
						s = -1;
						if ( (LA10_49=='e') && (((curly_nesting > 0 && plain_nesting == 0)||(!stringterm)||(stringterm)))) {s = 53;}
						else if ( ((LA10_49 >= '0' && LA10_49 <= '9')||(LA10_49 >= 'A' && LA10_49 <= 'Z')||LA10_49=='_'||(LA10_49 >= 'a' && LA10_49 <= 'd')||(LA10_49 >= 'f' && LA10_49 <= 'z')) && (((!stringterm)||(stringterm)))) {s = 38;}
						else s = 37;
						 
						input.seek(index10_49);
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA10_18 = input.LA(1);
						 
						int index10_18 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA10_18 >= '0' && LA10_18 <= '9')) && (((!stringterm)||(stringterm)))) {s = 46;}
						else if ( ((LA10_18 >= 'A' && LA10_18 <= 'Z')||LA10_18=='_'||(LA10_18 >= 'a' && LA10_18 <= 'z')) && ((stringterm))) {s = 19;}
						else s = 45;
						 
						input.seek(index10_18);
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 10, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
