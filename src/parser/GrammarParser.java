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
		RULE_start = 0, RULE_variable = 1, RULE_varDefinition = 2, RULE_parameters = 3, 
		RULE_definition = 4, RULE_type = 5, RULE_statement = 6, RULE_invocation = 7, 
		RULE_expression = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "variable", "varDefinition", "parameters", "definition", "type", 
			"statement", "invocation", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'var'", "';'", "','", "'('", "')'", "'{'", "'}'", "'struct'", 
			"'int'", "'float'", "'char'", "'['", "']'", "'='", "'if'", "'else'", 
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
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__8) | (1L << IDENT))) != 0)) {
				{
				{
				setState(18);
				((StartContext)_localctx).definition = definition();
				((StartContext)_localctx).definitions.add(((StartContext)_localctx).definition);
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
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

	public static class VariableContext extends ParserRuleContext {
		public Variable ast;
		public Token IDENT;
		public TypeContext type;
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
			setState(27);
			((VariableContext)_localctx).IDENT = match(IDENT);
			setState(28);
			match(T__0);
			setState(29);
			((VariableContext)_localctx).type = type();
			((VariableContext)_localctx).ast = new Variable(((VariableContext)_localctx).type.ast,(((VariableContext)_localctx).IDENT!=null?((VariableContext)_localctx).IDENT.getText():null));
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

	public static class VarDefinitionContext extends ParserRuleContext {
		public VarDefinition ast;
		public VariableContext variable;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VarDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefinition; }
	}

	public final VarDefinitionContext varDefinition() throws RecognitionException {
		VarDefinitionContext _localctx = new VarDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__1);
			setState(33);
			((VarDefinitionContext)_localctx).variable = variable();
			setState(34);
			match(T__2);
			((VarDefinitionContext)_localctx).ast = new VarDefinition(((VarDefinitionContext)_localctx).variable.ast.getName(),((VarDefinitionContext)_localctx).variable.ast.getType()); 
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
		public List<Variable> list = new ArrayList<Variable>();;
		public VariableContext variable;
		public List<VariableContext> var = new ArrayList<VariableContext>();
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(37);
				((ParametersContext)_localctx).variable = variable();
				((ParametersContext)_localctx).var.add(((ParametersContext)_localctx).variable);
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(38);
					match(T__3);
					setState(39);
					((ParametersContext)_localctx).variable = variable();
					((ParametersContext)_localctx).var.add(((ParametersContext)_localctx).variable);
					}
					}
					setState(44);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			((ParametersContext)_localctx).list = ((ParametersContext)_localctx).var;
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
		public VarDefinitionContext varDefinition;
		public List<VarDefinitionContext> localDefs = new ArrayList<VarDefinitionContext>();
		public StatementContext statement;
		public List<StatementContext> sts = new ArrayList<StatementContext>();
		public VariableContext variable;
		public List<VariableContext> fields = new ArrayList<VariableContext>();
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
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
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_definition);
		int _la;
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(50);
				match(T__4);
				setState(51);
				((DefinitionContext)_localctx).parameters = parameters();
				setState(52);
				match(T__5);
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(53);
					match(T__0);
					setState(54);
					((DefinitionContext)_localctx).type = type();
					}
				}

				setState(57);
				match(T__6);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(58);
					((DefinitionContext)_localctx).varDefinition = varDefinition();
					((DefinitionContext)_localctx).localDefs.add(((DefinitionContext)_localctx).varDefinition);
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << IDENT))) != 0)) {
					{
					{
					setState(64);
					((DefinitionContext)_localctx).statement = statement();
					((DefinitionContext)_localctx).sts.add(((DefinitionContext)_localctx).statement);
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(70);
				match(T__7);
				((DefinitionContext)_localctx).ast = new FunctionDefinition((((DefinitionContext)_localctx).IDENT!=null?((DefinitionContext)_localctx).IDENT.getText():null), ((DefinitionContext)_localctx).parameters.list, ((DefinitionContext)_localctx).type.ast, ((DefinitionContext)_localctx).localDefs, ((DefinitionContext)_localctx).sts);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				((DefinitionContext)_localctx).varDefinition = varDefinition();
				((DefinitionContext)_localctx).ast = ((DefinitionContext)_localctx).varDefinition.ast;
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(T__8);
				setState(77);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(78);
				match(T__6);
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENT) {
					{
					{
					setState(79);
					((DefinitionContext)_localctx).variable = variable();
					((DefinitionContext)_localctx).fields.add(((DefinitionContext)_localctx).variable);
					setState(80);
					match(T__2);
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87);
				match(T__7);
				setState(88);
				match(T__2);
				((DefinitionContext)_localctx).ast = new StructDefinition((((DefinitionContext)_localctx).IDENT!=null?((DefinitionContext)_localctx).IDENT.getText():null), ((DefinitionContext)_localctx).fields);
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

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Token INT_CONSTANT;
		public List<Token> dimensions = new ArrayList<Token>();
		public TypeContext type;
		public Token IDENT;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> INT_CONSTANT() { return getTokens(GrammarParser.INT_CONSTANT); }
		public TerminalNode INT_CONSTANT(int i) {
			return getToken(GrammarParser.INT_CONSTANT, i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			int _alt;
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				match(T__9);
				((TypeContext)_localctx).ast = new IntType();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(T__10);
				((TypeContext)_localctx).ast = new FloatType();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				match(T__11);
				((TypeContext)_localctx).ast = new CharType();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(101); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(98);
						match(T__12);
						setState(99);
						((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
						((TypeContext)_localctx).dimensions.add(((TypeContext)_localctx).INT_CONSTANT);
						setState(100);
						match(T__13);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(103); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(105);
				((TypeContext)_localctx).type = type();
				((TypeContext)_localctx).ast = new ArrayType(((TypeContext)_localctx).dimensions,((TypeContext)_localctx).type.ast );
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				((TypeContext)_localctx).IDENT = match(IDENT);
				((TypeContext)_localctx).ast = new StructType((((TypeContext)_localctx).IDENT!=null?((TypeContext)_localctx).IDENT.getText():null) );
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
		public Token IDENT;
		public ExpressionContext expression;
		public ExpressionContext condition;
		public StatementContext statement;
		public List<StatementContext> ifBody = new ArrayList<StatementContext>();
		public List<StatementContext> elseBody = new ArrayList<StatementContext>();
		public List<StatementContext> body = new ArrayList<StatementContext>();
		public Token variant;
		public InvocationContext invocation;
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
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		int _la;
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				((StatementContext)_localctx).IDENT = match(IDENT);
				setState(113);
				match(T__14);
				setState(114);
				((StatementContext)_localctx).expression = expression(0);
				setState(115);
				match(T__2);
				((StatementContext)_localctx).ast = new Assignment((((StatementContext)_localctx).IDENT!=null?((StatementContext)_localctx).IDENT.getText():null), ((StatementContext)_localctx).expression.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				match(T__15);
				setState(119);
				match(T__4);
				setState(120);
				((StatementContext)_localctx).condition = expression(0);
				setState(121);
				match(T__5);
				setState(122);
				match(T__6);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << IDENT))) != 0)) {
					{
					{
					setState(123);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).ifBody.add(((StatementContext)_localctx).statement);
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(129);
				match(T__7);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(130);
					match(T__16);
					setState(131);
					match(T__6);
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << IDENT))) != 0)) {
						{
						{
						setState(132);
						((StatementContext)_localctx).statement = statement();
						((StatementContext)_localctx).elseBody.add(((StatementContext)_localctx).statement);
						}
						}
						setState(137);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(138);
					match(T__7);
					}
				}

				((StatementContext)_localctx).ast = new IfStatement( ((StatementContext)_localctx).condition.ast, ((StatementContext)_localctx).ifBody, ((StatementContext)_localctx).elseBody);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				match(T__17);
				setState(144);
				match(T__4);
				setState(145);
				((StatementContext)_localctx).condition = expression(0);
				setState(146);
				match(T__5);
				setState(147);
				match(T__6);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << IDENT))) != 0)) {
					{
					{
					setState(148);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).body.add(((StatementContext)_localctx).statement);
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(154);
				match(T__7);
				((StatementContext)_localctx).ast = new While(((StatementContext)_localctx).condition.ast, ((StatementContext)_localctx).body);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				match(T__18);
				setState(158);
				((StatementContext)_localctx).expression = expression(0);
				setState(159);
				match(T__2);
				((StatementContext)_localctx).ast = new Read(((StatementContext)_localctx).expression.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(162);
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
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(163);
					((StatementContext)_localctx).expression = expression(0);
					}
				}

				setState(166);
				match(T__2);
				((StatementContext)_localctx).ast = new Print(((StatementContext)_localctx).variant,((StatementContext)_localctx).expression.ast);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(168);
				((StatementContext)_localctx).invocation = invocation();
				setState(169);
				match(T__2);
				((StatementContext)_localctx).ast =  ((StatementContext)_localctx).invocation.ast;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(172);
				match(T__22);
				setState(173);
				((StatementContext)_localctx).expression = expression(0);
				setState(174);
				match(T__2);
				((StatementContext)_localctx).ast = new Return(((StatementContext)_localctx).expression.ast);
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
		enterRule(_localctx, 14, RULE_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			((InvocationContext)_localctx).IDENT = match(IDENT);
			setState(180);
			match(T__4);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__28) | (1L << T__35) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				setState(181);
				((InvocationContext)_localctx).expression = expression(0);
				((InvocationContext)_localctx).arguments.add(((InvocationContext)_localctx).expression);
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(182);
					match(T__3);
					setState(183);
					((InvocationContext)_localctx).expression = expression(0);
					((InvocationContext)_localctx).arguments.add(((InvocationContext)_localctx).expression);
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(191);
			match(T__5);
			((InvocationContext)_localctx).ast = new Invocation((((InvocationContext)_localctx).IDENT!=null?((InvocationContext)_localctx).IDENT.getText():null), ((InvocationContext)_localctx).arguments);
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
		public List<ExpressionContext> dimensions = new ArrayList<ExpressionContext>();
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(195);
				((ExpressionContext)_localctx).IDENT = match(IDENT);
				}
				break;
			case 2:
				{
				setState(196);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				((ExpressionContext)_localctx).ast = new IntValue((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null));
				}
				break;
			case 3:
				{
				setState(198);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast = new FloatValue((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null));
				}
				break;
			case 4:
				{
				setState(200);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExpressionContext)_localctx).ast = new CharValue((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null));
				}
				break;
			case 5:
				{
				setState(202);
				match(T__35);
				setState(203);
				((ExpressionContext)_localctx).expression = expression(6);
				((ExpressionContext)_localctx).ast = new Not(((ExpressionContext)_localctx).expression.ast);
				}
				break;
			case 6:
				{
				setState(206);
				match(T__28);
				setState(207);
				((ExpressionContext)_localctx).type = type();
				setState(208);
				match(T__27);
				setState(209);
				match(T__4);
				setState(210);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(211);
				match(T__5);
				((ExpressionContext)_localctx).ast = new Cast(((ExpressionContext)_localctx).type.ast,((ExpressionContext)_localctx).expression.ast);
				}
				break;
			case 7:
				{
				setState(214);
				((ExpressionContext)_localctx).invocation = invocation();
				((ExpressionContext)_localctx).ast = ((ExpressionContext)_localctx).invocation.ast;
				}
				break;
			case 8:
				{
				setState(217);
				match(T__4);
				setState(218);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(219);
				match(T__5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(263);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(223);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(224);
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
						setState(225);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(12);
						((ExpressionContext)_localctx).ast = new ArithmeticExpression(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).operator, ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(229);
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
						setState(230);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(11);
						((ExpressionContext)_localctx).ast = new ArithmeticExpression(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).operator, ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(233);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(234);
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
						setState(235);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(10);
						((ExpressionContext)_localctx).ast = new Comparison(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).operator, ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(238);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(239);
						match(T__33);
						setState(240);
						((ExpressionContext)_localctx).expression = expression(9);
						((ExpressionContext)_localctx).ast = new And(((ExpressionContext)_localctx).left.ast , ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(243);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(244);
						match(T__34);
						setState(245);
						((ExpressionContext)_localctx).expression = expression(8);
						((ExpressionContext)_localctx).ast = new Or(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.array = _prevctx;
						_localctx.array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(248);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(253); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(249);
								match(T__12);
								setState(250);
								((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
								((ExpressionContext)_localctx).dimensions.add(((ExpressionContext)_localctx).expression);
								setState(251);
								match(T__13);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(255); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						((ExpressionContext)_localctx).ast = new ArrayAccess(((ExpressionContext)_localctx).array.ast,((ExpressionContext)_localctx).dimensions);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.struct = _prevctx;
						_localctx.struct = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(259);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(260);
						match(T__36);
						setState(261);
						((ExpressionContext)_localctx).IDENT = match(IDENT);
						((ExpressionContext)_localctx).ast = new StructFieldAccess(((ExpressionContext)_localctx).struct.ast,(((ExpressionContext)_localctx).IDENT!=null?((ExpressionContext)_localctx).IDENT.getText():null));
						}
						break;
					}
					} 
				}
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		case 8:
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
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u010f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2"+
		"\26\n\2\f\2\16\2\31\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\7\5+\n\5\f\5\16\5.\13\5\5\5\60\n\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6:\n\6\3\6\3\6\7\6>\n\6\f\6\16\6A\13\6\3\6\7\6D\n\6"+
		"\f\6\16\6G\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6U\n"+
		"\6\f\6\16\6X\13\6\3\6\3\6\3\6\5\6]\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\6\7h\n\7\r\7\16\7i\3\7\3\7\3\7\3\7\3\7\5\7q\n\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\177\n\b\f\b\16\b\u0082\13\b\3\b\3\b"+
		"\3\b\3\b\7\b\u0088\n\b\f\b\16\b\u008b\13\b\3\b\5\b\u008e\n\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\7\b\u0098\n\b\f\b\16\b\u009b\13\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a7\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u00b4\n\b\3\t\3\t\3\t\3\t\3\t\7\t\u00bb\n\t\f\t\16"+
		"\t\u00be\13\t\5\t\u00c0\n\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u00e0\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\6\n\u0100\n\n\r\n\16\n\u0101\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u010a\n\n"+
		"\f\n\16\n\u010d\13\n\3\n\2\3\22\13\2\4\6\b\n\f\16\20\22\2\6\3\2\26\30"+
		"\3\2\32\33\3\2\34\35\3\2\36#\2\u012f\2\27\3\2\2\2\4\35\3\2\2\2\6\"\3\2"+
		"\2\2\b/\3\2\2\2\n\\\3\2\2\2\fp\3\2\2\2\16\u00b3\3\2\2\2\20\u00b5\3\2\2"+
		"\2\22\u00df\3\2\2\2\24\26\5\n\6\2\25\24\3\2\2\2\26\31\3\2\2\2\27\25\3"+
		"\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2\2\32\33\7\2\2\3\33\34\b"+
		"\2\1\2\34\3\3\2\2\2\35\36\7+\2\2\36\37\7\3\2\2\37 \5\f\7\2 !\b\3\1\2!"+
		"\5\3\2\2\2\"#\7\4\2\2#$\5\4\3\2$%\7\5\2\2%&\b\4\1\2&\7\3\2\2\2\',\5\4"+
		"\3\2()\7\6\2\2)+\5\4\3\2*(\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\60\3"+
		"\2\2\2.,\3\2\2\2/\'\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\62\b\5\1\2\62"+
		"\t\3\2\2\2\63\64\7+\2\2\64\65\7\7\2\2\65\66\5\b\5\2\669\7\b\2\2\678\7"+
		"\3\2\28:\5\f\7\29\67\3\2\2\29:\3\2\2\2:;\3\2\2\2;?\7\t\2\2<>\5\6\4\2="+
		"<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@E\3\2\2\2A?\3\2\2\2BD\5\16\b\2"+
		"CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\n\2\2"+
		"IJ\b\6\1\2J]\3\2\2\2KL\5\6\4\2LM\b\6\1\2M]\3\2\2\2NO\7\13\2\2OP\7+\2\2"+
		"PV\7\t\2\2QR\5\4\3\2RS\7\5\2\2SU\3\2\2\2TQ\3\2\2\2UX\3\2\2\2VT\3\2\2\2"+
		"VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7\n\2\2Z[\7\5\2\2[]\b\6\1\2\\\63\3\2"+
		"\2\2\\K\3\2\2\2\\N\3\2\2\2]\13\3\2\2\2^_\7\f\2\2_q\b\7\1\2`a\7\r\2\2a"+
		"q\b\7\1\2bc\7\16\2\2cq\b\7\1\2de\7\17\2\2ef\7(\2\2fh\7\20\2\2gd\3\2\2"+
		"\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\5\f\7\2lm\b\7\1\2mq\3\2\2"+
		"\2no\7+\2\2oq\b\7\1\2p^\3\2\2\2p`\3\2\2\2pb\3\2\2\2pg\3\2\2\2pn\3\2\2"+
		"\2q\r\3\2\2\2rs\7+\2\2st\7\21\2\2tu\5\22\n\2uv\7\5\2\2vw\b\b\1\2w\u00b4"+
		"\3\2\2\2xy\7\22\2\2yz\7\7\2\2z{\5\22\n\2{|\7\b\2\2|\u0080\7\t\2\2}\177"+
		"\5\16\b\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2"+
		"\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u008d\7\n\2\2\u0084\u0085"+
		"\7\23\2\2\u0085\u0089\7\t\2\2\u0086\u0088\5\16\b\2\u0087\u0086\3\2\2\2"+
		"\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c"+
		"\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008e\7\n\2\2\u008d\u0084\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\b\b\1\2\u0090\u00b4\3\2"+
		"\2\2\u0091\u0092\7\24\2\2\u0092\u0093\7\7\2\2\u0093\u0094\5\22\n\2\u0094"+
		"\u0095\7\b\2\2\u0095\u0099\7\t\2\2\u0096\u0098\5\16\b\2\u0097\u0096\3"+
		"\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7\n\2\2\u009d\u009e\b\b"+
		"\1\2\u009e\u00b4\3\2\2\2\u009f\u00a0\7\25\2\2\u00a0\u00a1\5\22\n\2\u00a1"+
		"\u00a2\7\5\2\2\u00a2\u00a3\b\b\1\2\u00a3\u00b4\3\2\2\2\u00a4\u00a6\t\2"+
		"\2\2\u00a5\u00a7\5\22\n\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\7\5\2\2\u00a9\u00b4\b\b\1\2\u00aa\u00ab\5\20"+
		"\t\2\u00ab\u00ac\7\5\2\2\u00ac\u00ad\b\b\1\2\u00ad\u00b4\3\2\2\2\u00ae"+
		"\u00af\7\31\2\2\u00af\u00b0\5\22\n\2\u00b0\u00b1\7\5\2\2\u00b1\u00b2\b"+
		"\b\1\2\u00b2\u00b4\3\2\2\2\u00b3r\3\2\2\2\u00b3x\3\2\2\2\u00b3\u0091\3"+
		"\2\2\2\u00b3\u009f\3\2\2\2\u00b3\u00a4\3\2\2\2\u00b3\u00aa\3\2\2\2\u00b3"+
		"\u00ae\3\2\2\2\u00b4\17\3\2\2\2\u00b5\u00b6\7+\2\2\u00b6\u00bf\7\7\2\2"+
		"\u00b7\u00bc\5\22\n\2\u00b8\u00b9\7\6\2\2\u00b9\u00bb\5\22\n\2\u00ba\u00b8"+
		"\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00b7\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7\b\2\2\u00c2\u00c3\b\t\1\2\u00c3"+
		"\21\3\2\2\2\u00c4\u00c5\b\n\1\2\u00c5\u00e0\7+\2\2\u00c6\u00c7\7(\2\2"+
		"\u00c7\u00e0\b\n\1\2\u00c8\u00c9\7)\2\2\u00c9\u00e0\b\n\1\2\u00ca\u00cb"+
		"\7*\2\2\u00cb\u00e0\b\n\1\2\u00cc\u00cd\7&\2\2\u00cd\u00ce\5\22\n\b\u00ce"+
		"\u00cf\b\n\1\2\u00cf\u00e0\3\2\2\2\u00d0\u00d1\7\37\2\2\u00d1\u00d2\5"+
		"\f\7\2\u00d2\u00d3\7\36\2\2\u00d3\u00d4\7\7\2\2\u00d4\u00d5\5\22\n\2\u00d5"+
		"\u00d6\7\b\2\2\u00d6\u00d7\b\n\1\2\u00d7\u00e0\3\2\2\2\u00d8\u00d9\5\20"+
		"\t\2\u00d9\u00da\b\n\1\2\u00da\u00e0\3\2\2\2\u00db\u00dc\7\7\2\2\u00dc"+
		"\u00dd\5\22\n\2\u00dd\u00de\7\b\2\2\u00de\u00e0\3\2\2\2\u00df\u00c4\3"+
		"\2\2\2\u00df\u00c6\3\2\2\2\u00df\u00c8\3\2\2\2\u00df\u00ca\3\2\2\2\u00df"+
		"\u00cc\3\2\2\2\u00df\u00d0\3\2\2\2\u00df\u00d8\3\2\2\2\u00df\u00db\3\2"+
		"\2\2\u00e0\u010b\3\2\2\2\u00e1\u00e2\f\r\2\2\u00e2\u00e3\t\3\2\2\u00e3"+
		"\u00e4\5\22\n\16\u00e4\u00e5\b\n\1\2\u00e5\u010a\3\2\2\2\u00e6\u00e7\f"+
		"\f\2\2\u00e7\u00e8\t\4\2\2\u00e8\u00e9\5\22\n\r\u00e9\u00ea\b\n\1\2\u00ea"+
		"\u010a\3\2\2\2\u00eb\u00ec\f\13\2\2\u00ec\u00ed\t\5\2\2\u00ed\u00ee\5"+
		"\22\n\f\u00ee\u00ef\b\n\1\2\u00ef\u010a\3\2\2\2\u00f0\u00f1\f\n\2\2\u00f1"+
		"\u00f2\7$\2\2\u00f2\u00f3\5\22\n\13\u00f3\u00f4\b\n\1\2\u00f4\u010a\3"+
		"\2\2\2\u00f5\u00f6\f\t\2\2\u00f6\u00f7\7%\2\2\u00f7\u00f8\5\22\n\n\u00f8"+
		"\u00f9\b\n\1\2\u00f9\u010a\3\2\2\2\u00fa\u00ff\f\6\2\2\u00fb\u00fc\7\17"+
		"\2\2\u00fc\u00fd\5\22\n\2\u00fd\u00fe\7\20\2\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00fb\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102\u0103\3\2\2\2\u0103\u0104\b\n\1\2\u0104\u010a\3\2\2\2\u0105"+
		"\u0106\f\5\2\2\u0106\u0107\7\'\2\2\u0107\u0108\7+\2\2\u0108\u010a\b\n"+
		"\1\2\u0109\u00e1\3\2\2\2\u0109\u00e6\3\2\2\2\u0109\u00eb\3\2\2\2\u0109"+
		"\u00f0\3\2\2\2\u0109\u00f5\3\2\2\2\u0109\u00fa\3\2\2\2\u0109\u0105\3\2"+
		"\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\23\3\2\2\2\u010d\u010b\3\2\2\2\30\27,/9?EV\\ip\u0080\u0089\u008d\u0099"+
		"\u00a6\u00b3\u00bc\u00bf\u00df\u0101\u0109\u010b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}