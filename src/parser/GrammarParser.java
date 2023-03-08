// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;

    import ast.*;
    import ast.definition.*;
    import ast.statement.*;
    import ast.type.*;
    import ast.expression.*;


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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, INT_CONSTANT=38, 
		REAL_CONSTANT=39, CHAR_CONSTANT=40, IDENT=41, LINE_COMMENT=42, MULTILINE_COMMENT=43, 
		WHITESPACE=44;
	public static final int
		RULE_start = 0, RULE_definition = 1, RULE_parameters = 2, RULE_parameter = 3, 
		RULE_localDefinition = 4, RULE_structField = 5, RULE_type = 6, RULE_dimension = 7, 
		RULE_statement = 8, RULE_returnValue = 9, RULE_invocation = 10, RULE_expression = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "definition", "parameters", "parameter", "localDefinition", 
			"structField", "type", "dimension", "statement", "returnValue", "invocation", 
			"expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "':'", "'{'", "'}'", "'var'", "';'", "'struct'", 
			"','", "'int'", "'float'", "'char'", "'['", "']'", "'='", "'if'", "'else'", 
			"'while'", "'read'", "'print'", "'printsp'", "'println'", "'return'", 
			"'*'", "'/'", "'+'", "'-'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", 
			"'&&'", "'||'", "'!'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "IDENT", 
			"LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
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
		public Program ast;
		public DefinitionContext definition;
		public List<DefinitionContext> definitions = new ArrayList<DefinitionContext>();
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
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << IDENT))) != 0)) {
				{
				{
				setState(24);
				((StartContext)_localctx).definition = definition();
				((StartContext)_localctx).definitions.add(((StartContext)_localctx).definition);
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
			match(EOF);
			((StartContext)_localctx).ast = new Program(((StartContext)_localctx).definitions);
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
		public Definition ast;
		public Token IDENT;
		public ParametersContext parameters;
		public TypeContext type;
		public LocalDefinitionContext localDefinition;
		public List<LocalDefinitionContext> localDefs = new ArrayList<LocalDefinitionContext>();
		public StatementContext statement;
		public List<StatementContext> sts = new ArrayList<StatementContext>();
		public StructFieldContext structField;
		public List<StructFieldContext> fields = new ArrayList<StructFieldContext>();
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<LocalDefinitionContext> localDefinition() {
			return getRuleContexts(LocalDefinitionContext.class);
		}
		public LocalDefinitionContext localDefinition(int i) {
			return getRuleContext(LocalDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StructFieldContext> structField() {
			return getRuleContexts(StructFieldContext.class);
		}
		public StructFieldContext structField(int i) {
			return getRuleContext(StructFieldContext.class,i);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		int _la;
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(34);
				match(T__0);
				setState(35);
				((DefinitionContext)_localctx).parameters = parameters();
				setState(36);
				match(T__1);
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(37);
					match(T__2);
					setState(38);
					((DefinitionContext)_localctx).type = type();
					}
				}

				setState(41);
				match(T__3);
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(42);
					((DefinitionContext)_localctx).localDefinition = localDefinition();
					((DefinitionContext)_localctx).localDefs.add(((DefinitionContext)_localctx).localDefinition);
					}
					}
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					{
					setState(48);
					((DefinitionContext)_localctx).statement = statement();
					((DefinitionContext)_localctx).sts.add(((DefinitionContext)_localctx).statement);
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(54);
				match(T__4);
				((DefinitionContext)_localctx).ast = new FunctionDefinition(((DefinitionContext)_localctx).IDENT, ((DefinitionContext)_localctx).parameters.list, (_localctx.type!=null ? ((DefinitionContext)_localctx).type.ast :new VoidType()), ((DefinitionContext)_localctx).localDefs, ((DefinitionContext)_localctx).sts);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(T__5);
				setState(58);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(59);
				match(T__2);
				setState(60);
				((DefinitionContext)_localctx).type = type();
				setState(61);
				match(T__6);
				((DefinitionContext)_localctx).ast = new VarDefinition(((DefinitionContext)_localctx).IDENT,((DefinitionContext)_localctx).type.ast); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				match(T__7);
				setState(65);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(66);
				match(T__3);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENT) {
					{
					{
					setState(67);
					((DefinitionContext)_localctx).structField = structField();
					((DefinitionContext)_localctx).fields.add(((DefinitionContext)_localctx).structField);
					setState(68);
					match(T__6);
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(75);
				match(T__4);
				setState(76);
				match(T__6);
				((DefinitionContext)_localctx).ast = new StructDefinition(((DefinitionContext)_localctx).IDENT, ((DefinitionContext)_localctx).fields);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public List<Variable> list = new ArrayList<>();;
		public ParameterContext parameter;
		public List<ParameterContext> params = new ArrayList<ParameterContext>();
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(80);
				((ParametersContext)_localctx).parameter = parameter();
				((ParametersContext)_localctx).params.add(((ParametersContext)_localctx).parameter);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(81);
					match(T__8);
					setState(82);
					((ParametersContext)_localctx).parameter = parameter();
					((ParametersContext)_localctx).params.add(((ParametersContext)_localctx).parameter);
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			((ParametersContext)_localctx).list = new ArrayList(((ParametersContext)_localctx).params);
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

	public static class ParameterContext extends ParserRuleContext {
		public Variable ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((ParameterContext)_localctx).IDENT = match(IDENT);
			setState(93);
			match(T__2);
			setState(94);
			((ParameterContext)_localctx).type = type();
			((ParameterContext)_localctx).ast = new Variable(((ParameterContext)_localctx).IDENT,((ParameterContext)_localctx).type.ast);
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

	public static class LocalDefinitionContext extends ParserRuleContext {
		public VarDefinition ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LocalDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDefinition; }
	}

	public final LocalDefinitionContext localDefinition() throws RecognitionException {
		LocalDefinitionContext _localctx = new LocalDefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_localDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__5);
			setState(98);
			((LocalDefinitionContext)_localctx).IDENT = match(IDENT);
			setState(99);
			match(T__2);
			setState(100);
			((LocalDefinitionContext)_localctx).type = type();
			setState(101);
			match(T__6);
			((LocalDefinitionContext)_localctx).ast = new VarDefinition(((LocalDefinitionContext)_localctx).IDENT,((LocalDefinitionContext)_localctx).type.ast); 
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

	public static class StructFieldContext extends ParserRuleContext {
		public StructField ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StructFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structField; }
	}

	public final StructFieldContext structField() throws RecognitionException {
		StructFieldContext _localctx = new StructFieldContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_structField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			((StructFieldContext)_localctx).IDENT = match(IDENT);
			setState(105);
			match(T__2);
			setState(106);
			((StructFieldContext)_localctx).type = type();
			((StructFieldContext)_localctx).ast = new StructField(((StructFieldContext)_localctx).IDENT,((StructFieldContext)_localctx).type.ast);
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
		public Type ast;
		public DimensionContext dimension;
		public List<DimensionContext> dimensions = new ArrayList<DimensionContext>();
		public TypeContext type;
		public Token IDENT;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<DimensionContext> dimension() {
			return getRuleContexts(DimensionContext.class);
		}
		public DimensionContext dimension(int i) {
			return getRuleContext(DimensionContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			int _alt;
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(T__9);
				((TypeContext)_localctx).ast = new IntType();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(T__10);
				((TypeContext)_localctx).ast = new FloatType();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(T__11);
				((TypeContext)_localctx).ast = new CharType();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(119); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(115);
						match(T__12);
						setState(116);
						((TypeContext)_localctx).dimension = dimension();
						((TypeContext)_localctx).dimensions.add(((TypeContext)_localctx).dimension);
						setState(117);
						match(T__13);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(121); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(123);
				((TypeContext)_localctx).type = type();
				((TypeContext)_localctx).ast = new ArrayType(((TypeContext)_localctx).dimensions,((TypeContext)_localctx).type.ast );
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
				((TypeContext)_localctx).IDENT = match(IDENT);
				((TypeContext)_localctx).ast = new StructType(((TypeContext)_localctx).IDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DimensionContext extends ParserRuleContext {
		public LiteralInt ast;
		public Token INT_CONSTANT;
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public DimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimension; }
	}

	public final DimensionContext dimension() throws RecognitionException {
		DimensionContext _localctx = new DimensionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dimension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			((DimensionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
			((DimensionContext)_localctx).ast = new LiteralInt(((DimensionContext)_localctx).INT_CONSTANT);
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
		public Statement ast;
		public ExpressionContext left;
		public ExpressionContext right;
		public ExpressionContext condition;
		public StatementContext statement;
		public List<StatementContext> ifBody = new ArrayList<StatementContext>();
		public List<StatementContext> elseBody = new ArrayList<StatementContext>();
		public List<StatementContext> body = new ArrayList<StatementContext>();
		public ExpressionContext expression;
		public Token variant;
		public InvocationContext invocation;
		public ReturnValueContext returnValue;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public ReturnValueContext returnValue() {
			return getRuleContext(ReturnValueContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				((StatementContext)_localctx).left = expression(0);
				setState(134);
				match(T__14);
				setState(135);
				((StatementContext)_localctx).right = expression(0);
				setState(136);
				match(T__6);
				((StatementContext)_localctx).ast = new Assignment(((StatementContext)_localctx).left.ast , ((StatementContext)_localctx).right.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(T__15);
				setState(140);
				match(T__0);
				setState(141);
				((StatementContext)_localctx).condition = expression(0);
				setState(142);
				match(T__1);
				setState(143);
				match(T__3);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					{
					setState(144);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).ifBody.add(((StatementContext)_localctx).statement);
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(150);
				match(T__4);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(151);
					match(T__16);
					setState(152);
					match(T__3);
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
						{
						{
						setState(153);
						((StatementContext)_localctx).statement = statement();
						((StatementContext)_localctx).elseBody.add(((StatementContext)_localctx).statement);
						}
						}
						setState(158);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(159);
					match(T__4);
					}
				}

				((StatementContext)_localctx).ast = new IfStatement( ((StatementContext)_localctx).condition.ast, ((StatementContext)_localctx).ifBody,((StatementContext)_localctx).elseBody );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				match(T__17);
				setState(165);
				match(T__0);
				setState(166);
				((StatementContext)_localctx).condition = expression(0);
				setState(167);
				match(T__1);
				setState(168);
				match(T__3);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					{
					setState(169);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).body.add(((StatementContext)_localctx).statement);
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
				match(T__4);
				((StatementContext)_localctx).ast = new While(((StatementContext)_localctx).condition.ast, ((StatementContext)_localctx).body);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
				match(T__18);
				setState(179);
				((StatementContext)_localctx).expression = expression(0);
				setState(180);
				match(T__6);
				((StatementContext)_localctx).ast = new Read(((StatementContext)_localctx).expression.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(183);
				((StatementContext)_localctx).variant = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
					((StatementContext)_localctx).variant = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(184);
					((StatementContext)_localctx).expression = expression(0);
					}
				}

				setState(187);
				match(T__6);
				((StatementContext)_localctx).ast = new Print((_localctx.expression != null ? ((StatementContext)_localctx).expression.ast : new VoidType()),((StatementContext)_localctx).variant);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(189);
				((StatementContext)_localctx).invocation = invocation();
				setState(190);
				match(T__6);
				((StatementContext)_localctx).ast =  ((StatementContext)_localctx).invocation.ast;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(193);
				match(T__22);
				setState(194);
				((StatementContext)_localctx).returnValue = returnValue();
				((StatementContext)_localctx).ast = new Return(((StatementContext)_localctx).returnValue.ast);
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

	public static class ReturnValueContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnValue; }
	}

	public final ReturnValueContext returnValue() throws RecognitionException {
		ReturnValueContext _localctx = new ReturnValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_returnValue);
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__28:
			case T__35:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				((ReturnValueContext)_localctx).expression = expression(0);
				setState(200);
				match(T__6);
				((ReturnValueContext)_localctx).ast =  ((ReturnValueContext)_localctx).expression.ast ;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public Invocation ast;
		public Token IDENT;
		public ExpressionContext expression;
		public List<ExpressionContext> arguments = new ArrayList<ExpressionContext>();
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invocation; }
	}

	public final InvocationContext invocation() throws RecognitionException {
		InvocationContext _localctx = new InvocationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			((InvocationContext)_localctx).IDENT = match(IDENT);
			setState(207);
			match(T__0);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				setState(208);
				((InvocationContext)_localctx).expression = expression(0);
				((InvocationContext)_localctx).arguments.add(((InvocationContext)_localctx).expression);
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(209);
					match(T__8);
					setState(210);
					((InvocationContext)_localctx).expression = expression(0);
					((InvocationContext)_localctx).arguments.add(((InvocationContext)_localctx).expression);
					}
					}
					setState(215);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(218);
			match(T__1);
			((InvocationContext)_localctx).ast = new Invocation(((InvocationContext)_localctx).IDENT, ((InvocationContext)_localctx).arguments);
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
		public Expression ast;
		public ExpressionContext array;
		public ExpressionContext left;
		public ExpressionContext struct;
		public Token IDENT;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public ExpressionContext expression;
		public TypeContext type;
		public InvocationContext invocation;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> positionCoord = new ArrayList<ExpressionContext>();
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(GrammarParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(GrammarParser.CHAR_CONSTANT, 0); }
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(222);
				((ExpressionContext)_localctx).IDENT = match(IDENT);
				((ExpressionContext)_localctx).ast = new VariableReference(((ExpressionContext)_localctx).IDENT);
				}
				break;
			case 2:
				{
				setState(224);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				((ExpressionContext)_localctx).ast = new LiteralInt(((ExpressionContext)_localctx).INT_CONSTANT);
				}
				break;
			case 3:
				{
				setState(226);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast = new LiteralFloat(((ExpressionContext)_localctx).REAL_CONSTANT);
				}
				break;
			case 4:
				{
				setState(228);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExpressionContext)_localctx).ast = new LiteralChar(((ExpressionContext)_localctx).CHAR_CONSTANT);
				}
				break;
			case 5:
				{
				setState(230);
				match(T__0);
				setState(231);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(232);
				match(T__1);
				((ExpressionContext)_localctx).ast = ((ExpressionContext)_localctx).expression.ast;
				}
				break;
			case 6:
				{
				setState(235);
				match(T__35);
				setState(236);
				((ExpressionContext)_localctx).expression = expression(4);
				((ExpressionContext)_localctx).ast = new Not(((ExpressionContext)_localctx).expression.ast);
				}
				break;
			case 7:
				{
				setState(239);
				match(T__28);
				setState(240);
				((ExpressionContext)_localctx).type = type();
				setState(241);
				match(T__27);
				setState(242);
				match(T__0);
				setState(243);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(244);
				match(T__1);
				((ExpressionContext)_localctx).ast = new Cast(((ExpressionContext)_localctx).type.ast,((ExpressionContext)_localctx).expression.ast);
				}
				break;
			case 8:
				{
				setState(247);
				((ExpressionContext)_localctx).invocation = invocation();
				((ExpressionContext)_localctx).ast = ((ExpressionContext)_localctx).invocation.ast;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(294);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(292);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(252);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(253);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(254);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(10);
						((ExpressionContext)_localctx).ast = new ArithmeticExpression(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).operator, ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(257);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(258);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__26) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(259);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(9);
						((ExpressionContext)_localctx).ast = new ArithmeticExpression(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).operator, ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(262);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(263);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(264);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(8);
						((ExpressionContext)_localctx).ast = new Comparison(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).operator, ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(268);
						match(T__33);
						setState(269);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(7);
						((ExpressionContext)_localctx).ast = new And(((ExpressionContext)_localctx).left.ast , ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(272);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(273);
						match(T__34);
						setState(274);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(6);
						((ExpressionContext)_localctx).ast = new Or(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.array = _prevctx;
						_localctx.array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(277);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(282); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(278);
								match(T__12);
								setState(279);
								((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
								((ExpressionContext)_localctx).positionCoord.add(((ExpressionContext)_localctx).expression);
								setState(280);
								match(T__13);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(284); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						((ExpressionContext)_localctx).ast = new ArrayAccess(((ExpressionContext)_localctx).array.ast,((ExpressionContext)_localctx).positionCoord);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.struct = _prevctx;
						_localctx.struct = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(288);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(289);
						match(T__36);
						setState(290);
						((ExpressionContext)_localctx).IDENT = match(IDENT);
						((ExpressionContext)_localctx).ast = new StructFieldAccess(((ExpressionContext)_localctx).struct.ast,((ExpressionContext)_localctx).IDENT);
						}
						break;
					}
					} 
				}
				setState(296);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u012c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3*\n\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\3\7\3"+
		"\64\n\3\f\3\16\3\67\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\7\3I\n\3\f\3\16\3L\13\3\3\3\3\3\3\3\5\3Q\n\3\3\4\3"+
		"\4\3\4\7\4V\n\4\f\4\16\4Y\13\4\5\4[\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\6\bz\n\b\r\b\16\b{\3\b\3\b\3\b\3\b\3\b\5\b\u0083\n\b"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0094"+
		"\n\n\f\n\16\n\u0097\13\n\3\n\3\n\3\n\3\n\7\n\u009d\n\n\f\n\16\n\u00a0"+
		"\13\n\3\n\5\n\u00a3\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00ad\n\n"+
		"\f\n\16\n\u00b0\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00bc"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c8\n\n\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u00cf\n\13\3\f\3\f\3\f\3\f\3\f\7\f\u00d6\n\f\f\f\16"+
		"\f\u00d9\13\f\5\f\u00db\n\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u00fd\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\6\r\u011d\n\r\r\r\16\r\u011e\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0127"+
		"\n\r\f\r\16\r\u012a\13\r\3\r\2\3\30\16\2\4\6\b\n\f\16\20\22\24\26\30\2"+
		"\6\3\2\26\30\3\2\32\33\3\2\34\35\3\2\36#\2\u014a\2\35\3\2\2\2\4P\3\2\2"+
		"\2\6Z\3\2\2\2\b^\3\2\2\2\nc\3\2\2\2\fj\3\2\2\2\16\u0082\3\2\2\2\20\u0084"+
		"\3\2\2\2\22\u00c7\3\2\2\2\24\u00ce\3\2\2\2\26\u00d0\3\2\2\2\30\u00fc\3"+
		"\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3"+
		"\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\7\2\2\3!\"\b\2\1\2\"\3\3\2\2\2#$\7"+
		"+\2\2$%\7\3\2\2%&\5\6\4\2&)\7\4\2\2\'(\7\5\2\2(*\5\16\b\2)\'\3\2\2\2)"+
		"*\3\2\2\2*+\3\2\2\2+/\7\6\2\2,.\5\n\6\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2"+
		"\2/\60\3\2\2\2\60\65\3\2\2\2\61/\3\2\2\2\62\64\5\22\n\2\63\62\3\2\2\2"+
		"\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\28"+
		"9\7\7\2\29:\b\3\1\2:Q\3\2\2\2;<\7\b\2\2<=\7+\2\2=>\7\5\2\2>?\5\16\b\2"+
		"?@\7\t\2\2@A\b\3\1\2AQ\3\2\2\2BC\7\n\2\2CD\7+\2\2DJ\7\6\2\2EF\5\f\7\2"+
		"FG\7\t\2\2GI\3\2\2\2HE\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2"+
		"LJ\3\2\2\2MN\7\7\2\2NO\7\t\2\2OQ\b\3\1\2P#\3\2\2\2P;\3\2\2\2PB\3\2\2\2"+
		"Q\5\3\2\2\2RW\5\b\5\2ST\7\13\2\2TV\5\b\5\2US\3\2\2\2VY\3\2\2\2WU\3\2\2"+
		"\2WX\3\2\2\2X[\3\2\2\2YW\3\2\2\2ZR\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\b\4"+
		"\1\2]\7\3\2\2\2^_\7+\2\2_`\7\5\2\2`a\5\16\b\2ab\b\5\1\2b\t\3\2\2\2cd\7"+
		"\b\2\2de\7+\2\2ef\7\5\2\2fg\5\16\b\2gh\7\t\2\2hi\b\6\1\2i\13\3\2\2\2j"+
		"k\7+\2\2kl\7\5\2\2lm\5\16\b\2mn\b\7\1\2n\r\3\2\2\2op\7\f\2\2p\u0083\b"+
		"\b\1\2qr\7\r\2\2r\u0083\b\b\1\2st\7\16\2\2t\u0083\b\b\1\2uv\7\17\2\2v"+
		"w\5\20\t\2wx\7\20\2\2xz\3\2\2\2yu\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2"+
		"\2|}\3\2\2\2}~\5\16\b\2~\177\b\b\1\2\177\u0083\3\2\2\2\u0080\u0081\7+"+
		"\2\2\u0081\u0083\b\b\1\2\u0082o\3\2\2\2\u0082q\3\2\2\2\u0082s\3\2\2\2"+
		"\u0082y\3\2\2\2\u0082\u0080\3\2\2\2\u0083\17\3\2\2\2\u0084\u0085\7(\2"+
		"\2\u0085\u0086\b\t\1\2\u0086\21\3\2\2\2\u0087\u0088\5\30\r\2\u0088\u0089"+
		"\7\21\2\2\u0089\u008a\5\30\r\2\u008a\u008b\7\t\2\2\u008b\u008c\b\n\1\2"+
		"\u008c\u00c8\3\2\2\2\u008d\u008e\7\22\2\2\u008e\u008f\7\3\2\2\u008f\u0090"+
		"\5\30\r\2\u0090\u0091\7\4\2\2\u0091\u0095\7\6\2\2\u0092\u0094\5\22\n\2"+
		"\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u00a2\7\7\2\2\u0099"+
		"\u009a\7\23\2\2\u009a\u009e\7\6\2\2\u009b\u009d\5\22\n\2\u009c\u009b\3"+
		"\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a3\7\7\2\2\u00a2\u0099\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\n\1\2\u00a5"+
		"\u00c8\3\2\2\2\u00a6\u00a7\7\24\2\2\u00a7\u00a8\7\3\2\2\u00a8\u00a9\5"+
		"\30\r\2\u00a9\u00aa\7\4\2\2\u00aa\u00ae\7\6\2\2\u00ab\u00ad\5\22\n\2\u00ac"+
		"\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\7\7\2\2\u00b2"+
		"\u00b3\b\n\1\2\u00b3\u00c8\3\2\2\2\u00b4\u00b5\7\25\2\2\u00b5\u00b6\5"+
		"\30\r\2\u00b6\u00b7\7\t\2\2\u00b7\u00b8\b\n\1\2\u00b8\u00c8\3\2\2\2\u00b9"+
		"\u00bb\t\2\2\2\u00ba\u00bc\5\30\r\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3"+
		"\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\7\t\2\2\u00be\u00c8\b\n\1\2\u00bf"+
		"\u00c0\5\26\f\2\u00c0\u00c1\7\t\2\2\u00c1\u00c2\b\n\1\2\u00c2\u00c8\3"+
		"\2\2\2\u00c3\u00c4\7\31\2\2\u00c4\u00c5\5\24\13\2\u00c5\u00c6\b\n\1\2"+
		"\u00c6\u00c8\3\2\2\2\u00c7\u0087\3\2\2\2\u00c7\u008d\3\2\2\2\u00c7\u00a6"+
		"\3\2\2\2\u00c7\u00b4\3\2\2\2\u00c7\u00b9\3\2\2\2\u00c7\u00bf\3\2\2\2\u00c7"+
		"\u00c3\3\2\2\2\u00c8\23\3\2\2\2\u00c9\u00ca\5\30\r\2\u00ca\u00cb\7\t\2"+
		"\2\u00cb\u00cc\b\13\1\2\u00cc\u00cf\3\2\2\2\u00cd\u00cf\7\t\2\2\u00ce"+
		"\u00c9\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\25\3\2\2\2\u00d0\u00d1\7+\2\2"+
		"\u00d1\u00da\7\3\2\2\u00d2\u00d7\5\30\r\2\u00d3\u00d4\7\13\2\2\u00d4\u00d6"+
		"\5\30\r\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2"+
		"\u00d7\u00d8\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00d2"+
		"\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7\4\2\2\u00dd"+
		"\u00de\b\f\1\2\u00de\27\3\2\2\2\u00df\u00e0\b\r\1\2\u00e0\u00e1\7+\2\2"+
		"\u00e1\u00fd\b\r\1\2\u00e2\u00e3\7(\2\2\u00e3\u00fd\b\r\1\2\u00e4\u00e5"+
		"\7)\2\2\u00e5\u00fd\b\r\1\2\u00e6\u00e7\7*\2\2\u00e7\u00fd\b\r\1\2\u00e8"+
		"\u00e9\7\3\2\2\u00e9\u00ea\5\30\r\2\u00ea\u00eb\7\4\2\2\u00eb\u00ec\b"+
		"\r\1\2\u00ec\u00fd\3\2\2\2\u00ed\u00ee\7&\2\2\u00ee\u00ef\5\30\r\6\u00ef"+
		"\u00f0\b\r\1\2\u00f0\u00fd\3\2\2\2\u00f1\u00f2\7\37\2\2\u00f2\u00f3\5"+
		"\16\b\2\u00f3\u00f4\7\36\2\2\u00f4\u00f5\7\3\2\2\u00f5\u00f6\5\30\r\2"+
		"\u00f6\u00f7\7\4\2\2\u00f7\u00f8\b\r\1\2\u00f8\u00fd\3\2\2\2\u00f9\u00fa"+
		"\5\26\f\2\u00fa\u00fb\b\r\1\2\u00fb\u00fd\3\2\2\2\u00fc\u00df\3\2\2\2"+
		"\u00fc\u00e2\3\2\2\2\u00fc\u00e4\3\2\2\2\u00fc\u00e6\3\2\2\2\u00fc\u00e8"+
		"\3\2\2\2\u00fc\u00ed\3\2\2\2\u00fc\u00f1\3\2\2\2\u00fc\u00f9\3\2\2\2\u00fd"+
		"\u0128\3\2\2\2\u00fe\u00ff\f\13\2\2\u00ff\u0100\t\3\2\2\u0100\u0101\5"+
		"\30\r\f\u0101\u0102\b\r\1\2\u0102\u0127\3\2\2\2\u0103\u0104\f\n\2\2\u0104"+
		"\u0105\t\4\2\2\u0105\u0106\5\30\r\13\u0106\u0107\b\r\1\2\u0107\u0127\3"+
		"\2\2\2\u0108\u0109\f\t\2\2\u0109\u010a\t\5\2\2\u010a\u010b\5\30\r\n\u010b"+
		"\u010c\b\r\1\2\u010c\u0127\3\2\2\2\u010d\u010e\f\b\2\2\u010e\u010f\7$"+
		"\2\2\u010f\u0110\5\30\r\t\u0110\u0111\b\r\1\2\u0111\u0127\3\2\2\2\u0112"+
		"\u0113\f\7\2\2\u0113\u0114\7%\2\2\u0114\u0115\5\30\r\b\u0115\u0116\b\r"+
		"\1\2\u0116\u0127\3\2\2\2\u0117\u011c\f\f\2\2\u0118\u0119\7\17\2\2\u0119"+
		"\u011a\5\30\r\2\u011a\u011b\7\20\2\2\u011b\u011d\3\2\2\2\u011c\u0118\3"+
		"\2\2\2\u011d\u011e\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u0120\3\2\2\2\u0120\u0121\b\r\1\2\u0121\u0127\3\2\2\2\u0122\u0123\f\4"+
		"\2\2\u0123\u0124\7\'\2\2\u0124\u0125\7+\2\2\u0125\u0127\b\r\1\2\u0126"+
		"\u00fe\3\2\2\2\u0126\u0103\3\2\2\2\u0126\u0108\3\2\2\2\u0126\u010d\3\2"+
		"\2\2\u0126\u0112\3\2\2\2\u0126\u0117\3\2\2\2\u0126\u0122\3\2\2\2\u0127"+
		"\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\31\3\2\2"+
		"\2\u012a\u0128\3\2\2\2\31\35)/\65JPWZ{\u0082\u0095\u009e\u00a2\u00ae\u00bb"+
		"\u00c7\u00ce\u00d7\u00da\u00fc\u011e\u0126\u0128";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}