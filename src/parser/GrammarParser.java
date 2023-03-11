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
		RULE_localDefinition = 4, RULE_structField = 5, RULE_type = 6, RULE_statement = 7, 
		RULE_returnValue = 8, RULE_invocation = 9, RULE_expression = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "definition", "parameters", "parameter", "localDefinition", 
			"structField", "type", "statement", "returnValue", "invocation", "expression"
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
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << IDENT))) != 0)) {
				{
				{
				setState(22);
				((StartContext)_localctx).definition = definition();
				((StartContext)_localctx).definitions.add(((StartContext)_localctx).definition);
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
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
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(32);
				match(T__0);
				setState(33);
				((DefinitionContext)_localctx).parameters = parameters();
				setState(34);
				match(T__1);
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(35);
					match(T__2);
					setState(36);
					((DefinitionContext)_localctx).type = type();
					}
				}

				setState(39);
				match(T__3);
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(40);
					((DefinitionContext)_localctx).localDefinition = localDefinition();
					((DefinitionContext)_localctx).localDefs.add(((DefinitionContext)_localctx).localDefinition);
					}
					}
					setState(45);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					{
					setState(46);
					((DefinitionContext)_localctx).statement = statement();
					((DefinitionContext)_localctx).sts.add(((DefinitionContext)_localctx).statement);
					}
					}
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(52);
				match(T__4);
				((DefinitionContext)_localctx).ast = new FunctionDefinition(((DefinitionContext)_localctx).IDENT, ((DefinitionContext)_localctx).parameters.list, (_localctx.type!=null ? ((DefinitionContext)_localctx).type.ast :new VoidType()), ((DefinitionContext)_localctx).localDefs, ((DefinitionContext)_localctx).sts);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(T__5);
				setState(56);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(57);
				match(T__2);
				setState(58);
				((DefinitionContext)_localctx).type = type();
				setState(59);
				match(T__6);
				((DefinitionContext)_localctx).ast = new VarDefinition(((DefinitionContext)_localctx).IDENT,((DefinitionContext)_localctx).type.ast); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				match(T__7);
				setState(63);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(64);
				match(T__3);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENT) {
					{
					{
					setState(65);
					((DefinitionContext)_localctx).structField = structField();
					((DefinitionContext)_localctx).fields.add(((DefinitionContext)_localctx).structField);
					setState(66);
					match(T__6);
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(73);
				match(T__4);
				setState(74);
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
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(78);
				((ParametersContext)_localctx).parameter = parameter();
				((ParametersContext)_localctx).params.add(((ParametersContext)_localctx).parameter);
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(79);
					match(T__8);
					setState(80);
					((ParametersContext)_localctx).parameter = parameter();
					((ParametersContext)_localctx).params.add(((ParametersContext)_localctx).parameter);
					}
					}
					setState(85);
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
			setState(90);
			((ParameterContext)_localctx).IDENT = match(IDENT);
			setState(91);
			match(T__2);
			setState(92);
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
			setState(95);
			match(T__5);
			setState(96);
			((LocalDefinitionContext)_localctx).IDENT = match(IDENT);
			setState(97);
			match(T__2);
			setState(98);
			((LocalDefinitionContext)_localctx).type = type();
			setState(99);
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
			setState(102);
			((StructFieldContext)_localctx).IDENT = match(IDENT);
			setState(103);
			match(T__2);
			setState(104);
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
		public Token INT_CONSTANT;
		public TypeContext type;
		public Token IDENT;
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(T__9);
				((TypeContext)_localctx).ast = new IntType();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(T__10);
				((TypeContext)_localctx).ast = new FloatType();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(T__11);
				((TypeContext)_localctx).ast = new CharType();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				match(T__12);
				setState(114);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(115);
				match(T__13);
				setState(116);
				((TypeContext)_localctx).type = type();
				((TypeContext)_localctx).ast = new ArrayType(((TypeContext)_localctx).INT_CONSTANT,((TypeContext)_localctx).type.ast );
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(119);
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
		enterRule(_localctx, 14, RULE_statement);
		int _la;
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				((StatementContext)_localctx).left = expression(0);
				setState(124);
				match(T__14);
				setState(125);
				((StatementContext)_localctx).right = expression(0);
				setState(126);
				match(T__6);
				((StatementContext)_localctx).ast = new Assignment(((StatementContext)_localctx).left.ast , ((StatementContext)_localctx).right.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(T__15);
				setState(130);
				match(T__0);
				setState(131);
				((StatementContext)_localctx).condition = expression(0);
				setState(132);
				match(T__1);
				setState(133);
				match(T__3);
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					{
					setState(134);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).ifBody.add(((StatementContext)_localctx).statement);
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(140);
				match(T__4);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(141);
					match(T__16);
					setState(142);
					match(T__3);
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
						{
						{
						setState(143);
						((StatementContext)_localctx).statement = statement();
						((StatementContext)_localctx).elseBody.add(((StatementContext)_localctx).statement);
						}
						}
						setState(148);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(149);
					match(T__4);
					}
				}

				((StatementContext)_localctx).ast = new IfStatement( ((StatementContext)_localctx).condition.ast, ((StatementContext)_localctx).ifBody,((StatementContext)_localctx).elseBody );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				match(T__17);
				setState(155);
				match(T__0);
				setState(156);
				((StatementContext)_localctx).condition = expression(0);
				setState(157);
				match(T__1);
				setState(158);
				match(T__3);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					{
					setState(159);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).body.add(((StatementContext)_localctx).statement);
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(165);
				match(T__4);
				((StatementContext)_localctx).ast = new While(((StatementContext)_localctx).condition.ast, ((StatementContext)_localctx).body);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				match(T__18);
				setState(169);
				((StatementContext)_localctx).expression = expression(0);
				setState(170);
				match(T__6);
				((StatementContext)_localctx).ast = new Read(((StatementContext)_localctx).expression.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
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
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(174);
					((StatementContext)_localctx).expression = expression(0);
					}
				}

				setState(177);
				match(T__6);
				((StatementContext)_localctx).ast = new Print((_localctx.expression != null ? ((StatementContext)_localctx).expression.ast : new VoidType()),((StatementContext)_localctx).variant);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(179);
				((StatementContext)_localctx).invocation = invocation();
				setState(180);
				match(T__6);
				((StatementContext)_localctx).ast =  ((StatementContext)_localctx).invocation.ast;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(183);
				match(T__22);
				setState(184);
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
		enterRule(_localctx, 16, RULE_returnValue);
		try {
			setState(194);
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
				setState(189);
				((ReturnValueContext)_localctx).expression = expression(0);
				setState(190);
				match(T__6);
				((ReturnValueContext)_localctx).ast =  ((ReturnValueContext)_localctx).expression.ast ;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
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
		enterRule(_localctx, 18, RULE_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			((InvocationContext)_localctx).IDENT = match(IDENT);
			setState(197);
			match(T__0);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				setState(198);
				((InvocationContext)_localctx).expression = expression(0);
				((InvocationContext)_localctx).arguments.add(((InvocationContext)_localctx).expression);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(199);
					match(T__8);
					setState(200);
					((InvocationContext)_localctx).expression = expression(0);
					((InvocationContext)_localctx).arguments.add(((InvocationContext)_localctx).expression);
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(208);
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
		public ExpressionContext left;
		public ExpressionContext array;
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(212);
				((ExpressionContext)_localctx).IDENT = match(IDENT);
				((ExpressionContext)_localctx).ast = new VariableReference(((ExpressionContext)_localctx).IDENT);
				}
				break;
			case 2:
				{
				setState(214);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				((ExpressionContext)_localctx).ast = new LiteralInt(((ExpressionContext)_localctx).INT_CONSTANT);
				}
				break;
			case 3:
				{
				setState(216);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast = new LiteralFloat(((ExpressionContext)_localctx).REAL_CONSTANT);
				}
				break;
			case 4:
				{
				setState(218);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExpressionContext)_localctx).ast = new LiteralChar(((ExpressionContext)_localctx).CHAR_CONSTANT);
				}
				break;
			case 5:
				{
				setState(220);
				match(T__0);
				setState(221);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(222);
				match(T__1);
				((ExpressionContext)_localctx).ast = ((ExpressionContext)_localctx).expression.ast;
				}
				break;
			case 6:
				{
				setState(225);
				match(T__35);
				setState(226);
				((ExpressionContext)_localctx).expression = expression(5);
				((ExpressionContext)_localctx).ast = new Not(((ExpressionContext)_localctx).expression.ast);
				}
				break;
			case 7:
				{
				setState(229);
				match(T__28);
				setState(230);
				((ExpressionContext)_localctx).type = type();
				setState(231);
				match(T__27);
				setState(232);
				match(T__0);
				setState(233);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(234);
				match(T__1);
				((ExpressionContext)_localctx).ast = new Cast(((ExpressionContext)_localctx).type.ast,((ExpressionContext)_localctx).expression.ast);
				}
				break;
			case 8:
				{
				setState(237);
				((ExpressionContext)_localctx).invocation = invocation();
				((ExpressionContext)_localctx).ast = ((ExpressionContext)_localctx).invocation.ast;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(279);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(277);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(242);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(243);
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
						setState(244);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(11);
						((ExpressionContext)_localctx).ast = new ArithmeticExpression(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).operator, ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(247);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(248);
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
						setState(249);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(10);
						((ExpressionContext)_localctx).ast = new ArithmeticExpression(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).operator, ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(252);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(253);
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
						setState(254);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(9);
						((ExpressionContext)_localctx).ast = new Comparison(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).operator, ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(257);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(258);
						match(T__33);
						setState(259);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(8);
						((ExpressionContext)_localctx).ast = new And(((ExpressionContext)_localctx).left.ast , ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(262);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(263);
						match(T__34);
						setState(264);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(7);
						((ExpressionContext)_localctx).ast = new Or(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.array = _prevctx;
						_localctx.array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(268);
						match(T__12);
						setState(269);
						((ExpressionContext)_localctx).expression = expression(0);
						setState(270);
						match(T__13);
						((ExpressionContext)_localctx).ast = new ArrayAccess(((ExpressionContext)_localctx).array.ast,((ExpressionContext)_localctx).expression.ast);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.struct = _prevctx;
						_localctx.struct = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(273);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(274);
						match(T__36);
						setState(275);
						((ExpressionContext)_localctx).IDENT = match(IDENT);
						((ExpressionContext)_localctx).ast = new StructFieldAccess(((ExpressionContext)_localctx).struct.ast,((ExpressionContext)_localctx).IDENT);
						}
						break;
					}
					} 
				}
				setState(281);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		case 10:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u011d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\3(\n\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\7\3\62\n\3\f\3"+
		"\16\3\65\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\3G\n\3\f\3\16\3J\13\3\3\3\3\3\3\3\5\3O\n\3\3\4\3\4\3\4\7\4"+
		"T\n\4\f\4\16\4W\13\4\5\4Y\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\b|\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\7\t\u008a\n\t\f\t\16\t\u008d\13\t\3\t\3\t\3\t\3\t\7\t\u0093"+
		"\n\t\f\t\16\t\u0096\13\t\3\t\5\t\u0099\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\7\t\u00a3\n\t\f\t\16\t\u00a6\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\t\u00b2\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00be"+
		"\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u00c5\n\n\3\13\3\13\3\13\3\13\3\13\7\13\u00cc"+
		"\n\13\f\13\16\13\u00cf\13\13\5\13\u00d1\n\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f3\n\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0118\n\f\f\f\16"+
		"\f\u011b\13\f\3\f\2\3\26\r\2\4\6\b\n\f\16\20\22\24\26\2\6\3\2\26\30\3"+
		"\2\32\33\3\2\34\35\3\2\36#\2\u013a\2\33\3\2\2\2\4N\3\2\2\2\6X\3\2\2\2"+
		"\b\\\3\2\2\2\na\3\2\2\2\fh\3\2\2\2\16{\3\2\2\2\20\u00bd\3\2\2\2\22\u00c4"+
		"\3\2\2\2\24\u00c6\3\2\2\2\26\u00f2\3\2\2\2\30\32\5\4\3\2\31\30\3\2\2\2"+
		"\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\33\3\2\2\2"+
		"\36\37\7\2\2\3\37 \b\2\1\2 \3\3\2\2\2!\"\7+\2\2\"#\7\3\2\2#$\5\6\4\2$"+
		"\'\7\4\2\2%&\7\5\2\2&(\5\16\b\2\'%\3\2\2\2\'(\3\2\2\2()\3\2\2\2)-\7\6"+
		"\2\2*,\5\n\6\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\63\3\2\2\2/-\3"+
		"\2\2\2\60\62\5\20\t\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64"+
		"\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7\7\2\2\678\b\3\1\28O\3\2\2"+
		"\29:\7\b\2\2:;\7+\2\2;<\7\5\2\2<=\5\16\b\2=>\7\t\2\2>?\b\3\1\2?O\3\2\2"+
		"\2@A\7\n\2\2AB\7+\2\2BH\7\6\2\2CD\5\f\7\2DE\7\t\2\2EG\3\2\2\2FC\3\2\2"+
		"\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\7\7\2\2LM\7\t\2"+
		"\2MO\b\3\1\2N!\3\2\2\2N9\3\2\2\2N@\3\2\2\2O\5\3\2\2\2PU\5\b\5\2QR\7\13"+
		"\2\2RT\5\b\5\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VY\3\2\2\2WU\3\2"+
		"\2\2XP\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\b\4\1\2[\7\3\2\2\2\\]\7+\2\2]^\7"+
		"\5\2\2^_\5\16\b\2_`\b\5\1\2`\t\3\2\2\2ab\7\b\2\2bc\7+\2\2cd\7\5\2\2de"+
		"\5\16\b\2ef\7\t\2\2fg\b\6\1\2g\13\3\2\2\2hi\7+\2\2ij\7\5\2\2jk\5\16\b"+
		"\2kl\b\7\1\2l\r\3\2\2\2mn\7\f\2\2n|\b\b\1\2op\7\r\2\2p|\b\b\1\2qr\7\16"+
		"\2\2r|\b\b\1\2st\7\17\2\2tu\7(\2\2uv\7\20\2\2vw\5\16\b\2wx\b\b\1\2x|\3"+
		"\2\2\2yz\7+\2\2z|\b\b\1\2{m\3\2\2\2{o\3\2\2\2{q\3\2\2\2{s\3\2\2\2{y\3"+
		"\2\2\2|\17\3\2\2\2}~\5\26\f\2~\177\7\21\2\2\177\u0080\5\26\f\2\u0080\u0081"+
		"\7\t\2\2\u0081\u0082\b\t\1\2\u0082\u00be\3\2\2\2\u0083\u0084\7\22\2\2"+
		"\u0084\u0085\7\3\2\2\u0085\u0086\5\26\f\2\u0086\u0087\7\4\2\2\u0087\u008b"+
		"\7\6\2\2\u0088\u008a\5\20\t\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2"+
		"\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b"+
		"\3\2\2\2\u008e\u0098\7\7\2\2\u008f\u0090\7\23\2\2\u0090\u0094\7\6\2\2"+
		"\u0091\u0093\5\20\t\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097"+
		"\u0099\7\7\2\2\u0098\u008f\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009b\b\t\1\2\u009b\u00be\3\2\2\2\u009c\u009d\7\24\2\2\u009d"+
		"\u009e\7\3\2\2\u009e\u009f\5\26\f\2\u009f\u00a0\7\4\2\2\u00a0\u00a4\7"+
		"\6\2\2\u00a1\u00a3\5\20\t\2\u00a2\u00a1\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a4\3\2"+
		"\2\2\u00a7\u00a8\7\7\2\2\u00a8\u00a9\b\t\1\2\u00a9\u00be\3\2\2\2\u00aa"+
		"\u00ab\7\25\2\2\u00ab\u00ac\5\26\f\2\u00ac\u00ad\7\t\2\2\u00ad\u00ae\b"+
		"\t\1\2\u00ae\u00be\3\2\2\2\u00af\u00b1\t\2\2\2\u00b0\u00b2\5\26\f\2\u00b1"+
		"\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\t"+
		"\2\2\u00b4\u00be\b\t\1\2\u00b5\u00b6\5\24\13\2\u00b6\u00b7\7\t\2\2\u00b7"+
		"\u00b8\b\t\1\2\u00b8\u00be\3\2\2\2\u00b9\u00ba\7\31\2\2\u00ba\u00bb\5"+
		"\22\n\2\u00bb\u00bc\b\t\1\2\u00bc\u00be\3\2\2\2\u00bd}\3\2\2\2\u00bd\u0083"+
		"\3\2\2\2\u00bd\u009c\3\2\2\2\u00bd\u00aa\3\2\2\2\u00bd\u00af\3\2\2\2\u00bd"+
		"\u00b5\3\2\2\2\u00bd\u00b9\3\2\2\2\u00be\21\3\2\2\2\u00bf\u00c0\5\26\f"+
		"\2\u00c0\u00c1\7\t\2\2\u00c1\u00c2\b\n\1\2\u00c2\u00c5\3\2\2\2\u00c3\u00c5"+
		"\7\t\2\2\u00c4\u00bf\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\23\3\2\2\2\u00c6"+
		"\u00c7\7+\2\2\u00c7\u00d0\7\3\2\2\u00c8\u00cd\5\26\f\2\u00c9\u00ca\7\13"+
		"\2\2\u00ca\u00cc\5\26\f\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2"+
		"\2\2\u00d0\u00c8\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d3\7\4\2\2\u00d3\u00d4\b\13\1\2\u00d4\25\3\2\2\2\u00d5\u00d6\b\f\1"+
		"\2\u00d6\u00d7\7+\2\2\u00d7\u00f3\b\f\1\2\u00d8\u00d9\7(\2\2\u00d9\u00f3"+
		"\b\f\1\2\u00da\u00db\7)\2\2\u00db\u00f3\b\f\1\2\u00dc\u00dd\7*\2\2\u00dd"+
		"\u00f3\b\f\1\2\u00de\u00df\7\3\2\2\u00df\u00e0\5\26\f\2\u00e0\u00e1\7"+
		"\4\2\2\u00e1\u00e2\b\f\1\2\u00e2\u00f3\3\2\2\2\u00e3\u00e4\7&\2\2\u00e4"+
		"\u00e5\5\26\f\7\u00e5\u00e6\b\f\1\2\u00e6\u00f3\3\2\2\2\u00e7\u00e8\7"+
		"\37\2\2\u00e8\u00e9\5\16\b\2\u00e9\u00ea\7\36\2\2\u00ea\u00eb\7\3\2\2"+
		"\u00eb\u00ec\5\26\f\2\u00ec\u00ed\7\4\2\2\u00ed\u00ee\b\f\1\2\u00ee\u00f3"+
		"\3\2\2\2\u00ef\u00f0\5\24\13\2\u00f0\u00f1\b\f\1\2\u00f1\u00f3\3\2\2\2"+
		"\u00f2\u00d5\3\2\2\2\u00f2\u00d8\3\2\2\2\u00f2\u00da\3\2\2\2\u00f2\u00dc"+
		"\3\2\2\2\u00f2\u00de\3\2\2\2\u00f2\u00e3\3\2\2\2\u00f2\u00e7\3\2\2\2\u00f2"+
		"\u00ef\3\2\2\2\u00f3\u0119\3\2\2\2\u00f4\u00f5\f\f\2\2\u00f5\u00f6\t\3"+
		"\2\2\u00f6\u00f7\5\26\f\r\u00f7\u00f8\b\f\1\2\u00f8\u0118\3\2\2\2\u00f9"+
		"\u00fa\f\13\2\2\u00fa\u00fb\t\4\2\2\u00fb\u00fc\5\26\f\f\u00fc\u00fd\b"+
		"\f\1\2\u00fd\u0118\3\2\2\2\u00fe\u00ff\f\n\2\2\u00ff\u0100\t\5\2\2\u0100"+
		"\u0101\5\26\f\13\u0101\u0102\b\f\1\2\u0102\u0118\3\2\2\2\u0103\u0104\f"+
		"\t\2\2\u0104\u0105\7$\2\2\u0105\u0106\5\26\f\n\u0106\u0107\b\f\1\2\u0107"+
		"\u0118\3\2\2\2\u0108\u0109\f\b\2\2\u0109\u010a\7%\2\2\u010a\u010b\5\26"+
		"\f\t\u010b\u010c\b\f\1\2\u010c\u0118\3\2\2\2\u010d\u010e\f\5\2\2\u010e"+
		"\u010f\7\17\2\2\u010f\u0110\5\26\f\2\u0110\u0111\7\20\2\2\u0111\u0112"+
		"\b\f\1\2\u0112\u0118\3\2\2\2\u0113\u0114\f\4\2\2\u0114\u0115\7\'\2\2\u0115"+
		"\u0116\7+\2\2\u0116\u0118\b\f\1\2\u0117\u00f4\3\2\2\2\u0117\u00f9\3\2"+
		"\2\2\u0117\u00fe\3\2\2\2\u0117\u0103\3\2\2\2\u0117\u0108\3\2\2\2\u0117"+
		"\u010d\3\2\2\2\u0117\u0113\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2"+
		"\2\2\u0119\u011a\3\2\2\2\u011a\27\3\2\2\2\u011b\u0119\3\2\2\2\27\33\'"+
		"-\63HNUX{\u008b\u0094\u0098\u00a4\u00b1\u00bd\u00c4\u00cd\u00d0\u00f2"+
		"\u0117\u0119";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}