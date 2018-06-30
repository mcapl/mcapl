// Generated from RuleCondition.g4 by ANTLR 4.7
package pbdi.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RuleConditionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, BELIEVE=2, NOT=3, SHORT_BELIEVE=4, WORD=5, SINGLE_QUOTE=6, OPEN_BRACKET=7, 
		CLOSE_BRACKET=8, DOT=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "BELIEVE", "NOT", "SHORT_BELIEVE", "WORD", "SINGLE_QUOTE", "OPEN_BRACKET", 
		"CLOSE_BRACKET", "DOT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'believe'", "'NOT'", "'B'", null, "'''", "'('", "')'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "BELIEVE", "NOT", "SHORT_BELIEVE", "WORD", "SINGLE_QUOTE", 
		"OPEN_BRACKET", "CLOSE_BRACKET", "DOT"
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


	public RuleConditionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RuleCondition.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13\67\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\6"+
		"\2\27\n\2\r\2\16\2\30\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\6\6\6,\n\6\r\6\16\6-\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\4\4\2\13\13\"\""+
		"\6\2\62;C\\aac|\28\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\26\3\2\2"+
		"\2\5\34\3\2\2\2\7$\3\2\2\2\t(\3\2\2\2\13+\3\2\2\2\r/\3\2\2\2\17\61\3\2"+
		"\2\2\21\63\3\2\2\2\23\65\3\2\2\2\25\27\t\2\2\2\26\25\3\2\2\2\27\30\3\2"+
		"\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\32\3\2\2\2\32\33\b\2\2\2\33\4\3\2"+
		"\2\2\34\35\7d\2\2\35\36\7g\2\2\36\37\7n\2\2\37 \7k\2\2 !\7g\2\2!\"\7x"+
		"\2\2\"#\7g\2\2#\6\3\2\2\2$%\7P\2\2%&\7Q\2\2&\'\7V\2\2\'\b\3\2\2\2()\7"+
		"D\2\2)\n\3\2\2\2*,\t\3\2\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\f"+
		"\3\2\2\2/\60\7)\2\2\60\16\3\2\2\2\61\62\7*\2\2\62\20\3\2\2\2\63\64\7+"+
		"\2\2\64\22\3\2\2\2\65\66\7\60\2\2\66\24\3\2\2\2\5\2\30-\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}