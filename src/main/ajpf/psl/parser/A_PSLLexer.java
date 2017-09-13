// Generated from A_PSLLexer.g4 by ANTLR 4.7
package ajpf.psl.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class A_PSLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALWAYS=1, FINALLY=2, UNTIL=3, RELEASE=4, AND=5, OR=6, NOT=7, IMP=8, BELIEVE=9, 
		GOAL=10, FALSE=11, INTENTION=12, ACTION=13, PERCEPT=14, TRUE=15, INTENDTODO=16, 
		CONST=17, OPEN=18, CLOSE=19, COMMASEP=20, IDPUNCT=21, COMMENT=22, LINE_COMMENT=23, 
		NEWLINE=24, WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ALWAYS", "FINALLY", "UNTIL", "RELEASE", "AND", "OR", "NOT", "IMP", "BELIEVE", 
		"GOAL", "FALSE", "INTENTION", "ACTION", "PERCEPT", "TRUE", "INTENDTODO", 
		"CONST", "OPEN", "CLOSE", "COMMASEP", "IDPUNCT", "COMMENT", "LINE_COMMENT", 
		"NEWLINE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'U'", "'R'", "'&'", "'||'", "'~'", "'->'", "'B'", "'G'", 
		"'F'", "'I'", "'D'", "'P'", "'T'", "'ItD'", null, "'('", "')'", "','", 
		"'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ALWAYS", "FINALLY", "UNTIL", "RELEASE", "AND", "OR", "NOT", "IMP", 
		"BELIEVE", "GOAL", "FALSE", "INTENTION", "ACTION", "PERCEPT", "TRUE", 
		"INTENDTODO", "CONST", "OPEN", "CLOSE", "COMMASEP", "IDPUNCT", "COMMENT", 
		"LINE_COMMENT", "NEWLINE", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public A_PSLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "A_PSLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u0091\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\5\29\n\2\3\3\3\3\3\3\5\3>\n\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\6"+
		"\22b\n\22\r\22\16\22c\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\7\27r\n\27\f\27\16\27u\13\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\7\30\u0080\n\30\f\30\16\30\u0083\13\30\3\30\3\30\3\31"+
		"\5\31\u0088\n\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3s\2\33\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\5\6\2\62;C\\aac|\3\2"+
		"\f\f\4\2\13\13\"\"\2\u0097\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\38\3\2\2\2\5=\3\2"+
		"\2\2\7?\3\2\2\2\tA\3\2\2\2\13C\3\2\2\2\rE\3\2\2\2\17H\3\2\2\2\21J\3\2"+
		"\2\2\23M\3\2\2\2\25O\3\2\2\2\27Q\3\2\2\2\31S\3\2\2\2\33U\3\2\2\2\35W\3"+
		"\2\2\2\37Y\3\2\2\2![\3\2\2\2#a\3\2\2\2%e\3\2\2\2\'g\3\2\2\2)i\3\2\2\2"+
		"+k\3\2\2\2-m\3\2\2\2/{\3\2\2\2\61\u0087\3\2\2\2\63\u008d\3\2\2\2\659\7"+
		"C\2\2\66\67\7]\2\2\679\7_\2\28\65\3\2\2\28\66\3\2\2\29\4\3\2\2\2:>\7G"+
		"\2\2;<\7>\2\2<>\7@\2\2=:\3\2\2\2=;\3\2\2\2>\6\3\2\2\2?@\7W\2\2@\b\3\2"+
		"\2\2AB\7T\2\2B\n\3\2\2\2CD\7(\2\2D\f\3\2\2\2EF\7~\2\2FG\7~\2\2G\16\3\2"+
		"\2\2HI\7\u0080\2\2I\20\3\2\2\2JK\7/\2\2KL\7@\2\2L\22\3\2\2\2MN\7D\2\2"+
		"N\24\3\2\2\2OP\7I\2\2P\26\3\2\2\2QR\7H\2\2R\30\3\2\2\2ST\7K\2\2T\32\3"+
		"\2\2\2UV\7F\2\2V\34\3\2\2\2WX\7R\2\2X\36\3\2\2\2YZ\7V\2\2Z \3\2\2\2[\\"+
		"\7K\2\2\\]\7v\2\2]^\7F\2\2^\"\3\2\2\2_b\t\2\2\2`b\3\2\2\2a_\3\2\2\2a`"+
		"\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2d$\3\2\2\2ef\7*\2\2f&\3\2\2\2gh"+
		"\7+\2\2h(\3\2\2\2ij\7.\2\2j*\3\2\2\2kl\7\60\2\2l,\3\2\2\2mn\7\61\2\2n"+
		"o\7,\2\2os\3\2\2\2pr\13\2\2\2qp\3\2\2\2ru\3\2\2\2st\3\2\2\2sq\3\2\2\2"+
		"tv\3\2\2\2us\3\2\2\2vw\7,\2\2wx\7\61\2\2xy\3\2\2\2yz\b\27\2\2z.\3\2\2"+
		"\2{|\7\61\2\2|}\7\61\2\2}\u0081\3\2\2\2~\u0080\n\3\2\2\177~\3\2\2\2\u0080"+
		"\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2"+
		"\2\u0083\u0081\3\2\2\2\u0084\u0085\b\30\2\2\u0085\60\3\2\2\2\u0086\u0088"+
		"\7\17\2\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0089\u008a\7\f\2\2\u008a\u008b\3\2\2\2\u008b\u008c\b\31\2\2\u008c\62"+
		"\3\2\2\2\u008d\u008e\t\4\2\2\u008e\u008f\3\2\2\2\u008f\u0090\b\32\2\2"+
		"\u0090\64\3\2\2\2\n\28=acs\u0081\u0087\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}