// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, INT_CONSTANT=37, REAL_CONSTANT=38, 
		CHAR_CONSTANT=39, IDENT=40, LINE_COMMENT=41, MULTILINE_COMMENT=42, WHITESPACE=43;
	public static final int
		RULE_start = 0, RULE_variable = 1, RULE_vardef = 2, RULE_definition = 3, 
		RULE_type = 4, RULE_parameters = 5, RULE_arguments = 6, RULE_statement = 7, 
		RULE_invocation = 8, RULE_expression = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "variable", "vardef", "definition", "type", "parameters", "arguments", 
			"statement", "invocation", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'var'", "';'", "'('", "')'", "'{'", "'}'", "'struct'", 
			"'['", "']'", "'int'", "'float'", "'char'", "','", "'='", "'if'", "'else'", 
			"'while'", "'print'", "'printsp'", "'println'", "'return'", "'*'", "'/'", 
			"'+'", "'-'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", 
			"'!'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "IDENT", "LINE_COMMENT", 
			"MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__7) | (1L << IDENT))) != 0)) {
				{
				{
				setState(20);
				definition();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(IDENT);
			setState(29);
			match(T__0);
			setState(30);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardefContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VardefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardef; }
	}

	public final VardefContext vardef() throws RecognitionException {
		VardefContext _localctx = new VardefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vardef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__1);
			setState(33);
			variable();
			setState(34);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VardefContext> vardef() {
			return getRuleContexts(VardefContext.class);
		}
		public VardefContext vardef(int i) {
			return getRuleContext(VardefContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_definition);
		int _la;
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(IDENT);
				setState(37);
				match(T__3);
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(38);
					parameters();
					}
				}

				setState(41);
				match(T__4);
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(42);
					match(T__0);
					setState(43);
					type();
					}
				}

				setState(46);
				match(T__5);
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(47);
					vardef();
					}
					}
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << IDENT))) != 0)) {
					{
					{
					setState(53);
					statement();
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(59);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				vardef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				match(T__7);
				setState(62);
				match(IDENT);
				setState(63);
				match(T__5);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENT) {
					{
					{
					setState(64);
					variable();
					setState(65);
					match(T__2);
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(72);
				match(T__6);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				match(IDENT);
				setState(74);
				match(T__0);
				setState(75);
				type();
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(76);
					match(T__8);
					setState(77);
					expression(0);
					setState(78);
					match(T__9);
					}
					}
					setState(82); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__8 );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameters);
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				variable();
				setState(90);
				match(T__13);
				setState(91);
				parameters();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arguments);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				expression(0);
				setState(97);
				match(T__13);
				setState(98);
				arguments();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		int _la;
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				invocation();
				setState(103);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				match(IDENT);
				setState(106);
				match(T__14);
				setState(107);
				expression(0);
				setState(108);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				match(T__15);
				setState(111);
				match(T__3);
				setState(112);
				expression(0);
				setState(113);
				match(T__4);
				setState(114);
				match(T__5);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << IDENT))) != 0)) {
					{
					{
					setState(115);
					statement();
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(121);
				match(T__6);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(122);
					match(T__16);
					setState(123);
					match(T__5);
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << IDENT))) != 0)) {
						{
						{
						setState(124);
						statement();
						}
						}
						setState(129);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(130);
					match(T__6);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				match(T__17);
				setState(134);
				match(T__3);
				setState(135);
				expression(0);
				setState(136);
				match(T__4);
				setState(137);
				match(T__5);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << IDENT))) != 0)) {
					{
					{
					setState(138);
					statement();
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(144);
				match(T__6);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(146);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__27) | (1L << T__34) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(147);
					expression(0);
					}
				}

				setState(150);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(151);
				invocation();
				setState(152);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(154);
				match(T__21);
				setState(155);
				expression(0);
				setState(156);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvocationContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public InvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invocation; }
	}

	public final InvocationContext invocation() throws RecognitionException {
		InvocationContext _localctx = new InvocationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_invocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(IDENT);
			setState(161);
			match(T__3);
			setState(162);
			arguments();
			setState(163);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(GrammarParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(GrammarParser.CHAR_CONSTANT, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(166);
				match(INT_CONSTANT);
				}
				break;
			case 2:
				{
				setState(167);
				match(REAL_CONSTANT);
				}
				break;
			case 3:
				{
				setState(168);
				match(CHAR_CONSTANT);
				}
				break;
			case 4:
				{
				setState(169);
				match(IDENT);
				}
				break;
			case 5:
				{
				setState(170);
				match(T__34);
				setState(171);
				expression(6);
				}
				break;
			case 6:
				{
				setState(172);
				match(T__27);
				setState(173);
				type();
				setState(174);
				match(T__26);
				setState(175);
				match(T__3);
				setState(176);
				expression(0);
				setState(177);
				match(T__4);
				}
				break;
			case 7:
				{
				setState(179);
				invocation();
				}
				break;
			case 8:
				{
				setState(180);
				match(T__3);
				setState(181);
				expression(0);
				setState(182);
				match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(213);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(187);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(188);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(189);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(190);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(191);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(193);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(194);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(196);
						match(T__32);
						setState(197);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(198);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(199);
						match(T__33);
						setState(200);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(202);
						match(T__35);
						setState(203);
						expression(4);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(209); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(205);
								match(T__8);
								setState(206);
								expression(0);
								setState(207);
								match(T__9);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(211); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u00dd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\5\5*\n\5\3\5\3\5\3\5\5\5/\n\5\3\5\3\5\7\5\63\n\5\f"+
		"\5\16\5\66\13\5\3\5\7\59\n\5\f\5\16\5<\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\7\5F\n\5\f\5\16\5I\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5S\n"+
		"\5\r\5\16\5T\5\5W\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7`\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\5\bg\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\7\tw\n\t\f\t\16\tz\13\t\3\t\3\t\3\t\3\t\7\t\u0080\n\t\f\t\16\t\u0083"+
		"\13\t\3\t\5\t\u0086\n\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u008e\n\t\f\t\16\t"+
		"\u0091\13\t\3\t\3\t\3\t\3\t\5\t\u0097\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\5\t\u00a1\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00bb"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u00d4\n\13\r\13"+
		"\16\13\u00d5\7\13\u00d8\n\13\f\13\16\13\u00db\13\13\3\13\2\3\24\f\2\4"+
		"\6\b\n\f\16\20\22\24\2\7\3\2\r\17\3\2\25\27\3\2\31\32\3\2\33\34\3\2\35"+
		"\"\2\u00f8\2\31\3\2\2\2\4\36\3\2\2\2\6\"\3\2\2\2\bV\3\2\2\2\nX\3\2\2\2"+
		"\f_\3\2\2\2\16f\3\2\2\2\20\u00a0\3\2\2\2\22\u00a2\3\2\2\2\24\u00ba\3\2"+
		"\2\2\26\30\5\b\5\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2"+
		"\2\2\32\34\3\2\2\2\33\31\3\2\2\2\34\35\7\2\2\3\35\3\3\2\2\2\36\37\7*\2"+
		"\2\37 \7\3\2\2 !\5\n\6\2!\5\3\2\2\2\"#\7\4\2\2#$\5\4\3\2$%\7\5\2\2%\7"+
		"\3\2\2\2&\'\7*\2\2\')\7\6\2\2(*\5\f\7\2)(\3\2\2\2)*\3\2\2\2*+\3\2\2\2"+
		"+.\7\7\2\2,-\7\3\2\2-/\5\n\6\2.,\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\64\7"+
		"\b\2\2\61\63\5\6\4\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3"+
		"\2\2\2\65:\3\2\2\2\66\64\3\2\2\2\679\5\20\t\28\67\3\2\2\29<\3\2\2\2:8"+
		"\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=W\7\t\2\2>W\5\6\4\2?@\7\n\2\2@"+
		"A\7*\2\2AG\7\b\2\2BC\5\4\3\2CD\7\5\2\2DF\3\2\2\2EB\3\2\2\2FI\3\2\2\2G"+
		"E\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JW\7\t\2\2KL\7*\2\2LM\7\3\2\2M"+
		"R\5\n\6\2NO\7\13\2\2OP\5\24\13\2PQ\7\f\2\2QS\3\2\2\2RN\3\2\2\2ST\3\2\2"+
		"\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2V&\3\2\2\2V>\3\2\2\2V?\3\2\2\2VK\3\2\2"+
		"\2W\t\3\2\2\2XY\t\2\2\2Y\13\3\2\2\2Z`\5\4\3\2[\\\5\4\3\2\\]\7\20\2\2]"+
		"^\5\f\7\2^`\3\2\2\2_Z\3\2\2\2_[\3\2\2\2`\r\3\2\2\2ag\5\24\13\2bc\5\24"+
		"\13\2cd\7\20\2\2de\5\16\b\2eg\3\2\2\2fa\3\2\2\2fb\3\2\2\2g\17\3\2\2\2"+
		"hi\5\22\n\2ij\7\5\2\2j\u00a1\3\2\2\2kl\7*\2\2lm\7\21\2\2mn\5\24\13\2n"+
		"o\7\5\2\2o\u00a1\3\2\2\2pq\7\22\2\2qr\7\6\2\2rs\5\24\13\2st\7\7\2\2tx"+
		"\7\b\2\2uw\5\20\t\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2"+
		"zx\3\2\2\2{\u0085\7\t\2\2|}\7\23\2\2}\u0081\7\b\2\2~\u0080\5\20\t\2\177"+
		"~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0086\7\t\2\2\u0085|\3\2\2\2"+
		"\u0085\u0086\3\2\2\2\u0086\u00a1\3\2\2\2\u0087\u0088\7\24\2\2\u0088\u0089"+
		"\7\6\2\2\u0089\u008a\5\24\13\2\u008a\u008b\7\7\2\2\u008b\u008f\7\b\2\2"+
		"\u008c\u008e\5\20\t\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0093\7\t\2\2\u0093\u00a1\3\2\2\2\u0094\u0096\t\3\2\2\u0095\u0097\5\24"+
		"\13\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u00a1\7\5\2\2\u0099\u009a\5\22\n\2\u009a\u009b\7\5\2\2\u009b\u00a1\3"+
		"\2\2\2\u009c\u009d\7\30\2\2\u009d\u009e\5\24\13\2\u009e\u009f\7\5\2\2"+
		"\u009f\u00a1\3\2\2\2\u00a0h\3\2\2\2\u00a0k\3\2\2\2\u00a0p\3\2\2\2\u00a0"+
		"\u0087\3\2\2\2\u00a0\u0094\3\2\2\2\u00a0\u0099\3\2\2\2\u00a0\u009c\3\2"+
		"\2\2\u00a1\21\3\2\2\2\u00a2\u00a3\7*\2\2\u00a3\u00a4\7\6\2\2\u00a4\u00a5"+
		"\5\16\b\2\u00a5\u00a6\7\7\2\2\u00a6\23\3\2\2\2\u00a7\u00a8\b\13\1\2\u00a8"+
		"\u00bb\7\'\2\2\u00a9\u00bb\7(\2\2\u00aa\u00bb\7)\2\2\u00ab\u00bb\7*\2"+
		"\2\u00ac\u00ad\7%\2\2\u00ad\u00bb\5\24\13\b\u00ae\u00af\7\36\2\2\u00af"+
		"\u00b0\5\n\6\2\u00b0\u00b1\7\35\2\2\u00b1\u00b2\7\6\2\2\u00b2\u00b3\5"+
		"\24\13\2\u00b3\u00b4\7\7\2\2\u00b4\u00bb\3\2\2\2\u00b5\u00bb\5\22\n\2"+
		"\u00b6\u00b7\7\6\2\2\u00b7\u00b8\5\24\13\2\u00b8\u00b9\7\7\2\2\u00b9\u00bb"+
		"\3\2\2\2\u00ba\u00a7\3\2\2\2\u00ba\u00a9\3\2\2\2\u00ba\u00aa\3\2\2\2\u00ba"+
		"\u00ab\3\2\2\2\u00ba\u00ac\3\2\2\2\u00ba\u00ae\3\2\2\2\u00ba\u00b5\3\2"+
		"\2\2\u00ba\u00b6\3\2\2\2\u00bb\u00d9\3\2\2\2\u00bc\u00bd\f\r\2\2\u00bd"+
		"\u00be\t\4\2\2\u00be\u00d8\5\24\13\16\u00bf\u00c0\f\f\2\2\u00c0\u00c1"+
		"\t\5\2\2\u00c1\u00d8\5\24\13\r\u00c2\u00c3\f\13\2\2\u00c3\u00c4\t\6\2"+
		"\2\u00c4\u00d8\5\24\13\f\u00c5\u00c6\f\n\2\2\u00c6\u00c7\7#\2\2\u00c7"+
		"\u00d8\5\24\13\13\u00c8\u00c9\f\t\2\2\u00c9\u00ca\7$\2\2\u00ca\u00d8\5"+
		"\24\13\n\u00cb\u00cc\f\5\2\2\u00cc\u00cd\7&\2\2\u00cd\u00d8\5\24\13\6"+
		"\u00ce\u00d3\f\6\2\2\u00cf\u00d0\7\13\2\2\u00d0\u00d1\5\24\13\2\u00d1"+
		"\u00d2\7\f\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00cf\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7"+
		"\u00bc\3\2\2\2\u00d7\u00bf\3\2\2\2\u00d7\u00c2\3\2\2\2\u00d7\u00c5\3\2"+
		"\2\2\u00d7\u00c8\3\2\2\2\u00d7\u00cb\3\2\2\2\u00d7\u00ce\3\2\2\2\u00d8"+
		"\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\25\3\2\2"+
		"\2\u00db\u00d9\3\2\2\2\26\31).\64:GTV_fx\u0081\u0085\u008f\u0096\u00a0"+
		"\u00ba\u00d5\u00d7\u00d9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}