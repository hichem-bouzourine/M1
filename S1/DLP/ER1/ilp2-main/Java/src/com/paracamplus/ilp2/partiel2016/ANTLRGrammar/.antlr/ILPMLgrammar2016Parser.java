// Generated from /home/ubuntu/Desktop/M1/S1/DLP/ER1/ilp2-main/Java/src/com/paracamplus/ilp2/partiel2016/ANTLRGrammar/ILPMLgrammar2016.g4 by ANTLR 4.13.1

    package antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ILPMLgrammar2016Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, IDENT=34, INT=35, FLOAT=36, STRING=37, ESC=38, LINE_COMMENT=39, 
		COMMENT=40, SPACE=41;
	public static final int
		RULE_prog = 0, RULE_globalFunDef = 1, RULE_expr = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "globalFunDef", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'function'", "'('", "','", "'&keys'", "')'", "':'", "'-'", 
			"'!'", "'*'", "'/'", "'%'", "'+'", "'<'", "'<='", "'>'", "'>='", "'=='", 
			"'!='", "'&'", "'|'", "'^'", "'true'", "'false'", "'let'", "'='", "'and'", 
			"'in'", "'if'", "'then'", "'else'", "'while'", "'do'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "IDENT", 
			"INT", "FLOAT", "STRING", "ESC", "LINE_COMMENT", "COMMENT", "SPACE"
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
	public String getGrammarFileName() { return "ILPMLgrammar2016.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ILPMLgrammar2016Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public com.paracamplus.ilp2.interfaces.IASTprogram node;
		public GlobalFunDefContext globalFunDef;
		public List<GlobalFunDefContext> defs = new ArrayList<GlobalFunDefContext>();
		public ExprContext expr;
		public List<ExprContext> exprs = new ArrayList<ExprContext>();
		public TerminalNode EOF() { return getToken(ILPMLgrammar2016Parser.EOF, 0); }
		public List<GlobalFunDefContext> globalFunDef() {
			return getRuleContexts(GlobalFunDefContext.class);
		}
		public GlobalFunDefContext globalFunDef(int i) {
			return getRuleContext(GlobalFunDefContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(6);
				((ProgContext)_localctx).globalFunDef = globalFunDef();
				((ProgContext)_localctx).defs.add(((ProgContext)_localctx).globalFunDef);
				setState(8);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(7);
					match(T__0);
					}
				}

				}
				}
				setState(14);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 262588597000L) != 0)) {
				{
				{
				setState(15);
				((ProgContext)_localctx).expr = expr(0);
				((ProgContext)_localctx).exprs.add(((ProgContext)_localctx).expr);
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(16);
					match(T__0);
					}
				}

				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
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

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalFunDefContext extends ParserRuleContext {
		public com.paracamplus.ilp2.partiel2016.interfaces.IASTfunctionDefinitionOpt node;
		public Token name;
		public Token IDENT;
		public List<Token> vars = new ArrayList<Token>();
		public Token keys;
		public List<Token> nvars = new ArrayList<Token>();
		public ExprContext expr;
		public List<ExprContext> vals = new ArrayList<ExprContext>();
		public ExprContext body;
		public List<TerminalNode> IDENT() { return getTokens(ILPMLgrammar2016Parser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(ILPMLgrammar2016Parser.IDENT, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GlobalFunDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalFunDef; }
	}

	public final GlobalFunDefContext globalFunDef() throws RecognitionException {
		GlobalFunDefContext _localctx = new GlobalFunDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalFunDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__1);
			setState(27);
			((GlobalFunDefContext)_localctx).name = match(IDENT);
			setState(28);
			match(T__2);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(29);
				((GlobalFunDefContext)_localctx).IDENT = match(IDENT);
				((GlobalFunDefContext)_localctx).vars.add(((GlobalFunDefContext)_localctx).IDENT);
				}
			}

			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(32);
				match(T__3);
				setState(33);
				((GlobalFunDefContext)_localctx).IDENT = match(IDENT);
				((GlobalFunDefContext)_localctx).vars.add(((GlobalFunDefContext)_localctx).IDENT);
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(39);
				((GlobalFunDefContext)_localctx).keys = match(T__4);
				setState(40);
				((GlobalFunDefContext)_localctx).IDENT = match(IDENT);
				((GlobalFunDefContext)_localctx).nvars.add(((GlobalFunDefContext)_localctx).IDENT);
				setState(41);
				((GlobalFunDefContext)_localctx).expr = expr(0);
				((GlobalFunDefContext)_localctx).vals.add(((GlobalFunDefContext)_localctx).expr);
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(42);
					match(T__3);
					setState(43);
					((GlobalFunDefContext)_localctx).IDENT = match(IDENT);
					((GlobalFunDefContext)_localctx).nvars.add(((GlobalFunDefContext)_localctx).IDENT);
					setState(44);
					((GlobalFunDefContext)_localctx).expr = expr(0);
					((GlobalFunDefContext)_localctx).vals.add(((GlobalFunDefContext)_localctx).expr);
					}
					}
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(52);
			match(T__5);
			setState(53);
			((GlobalFunDefContext)_localctx).body = expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public com.paracamplus.ilp1.interfaces.IASTexpression node;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.node = ctx.node;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BindingContext extends ExprContext {
		public Token IDENT;
		public List<Token> vars = new ArrayList<Token>();
		public ExprContext expr;
		public List<ExprContext> vals = new ArrayList<ExprContext>();
		public ExprContext body;
		public List<TerminalNode> IDENT() { return getTokens(ILPMLgrammar2016Parser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(ILPMLgrammar2016Parser.IDENT, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BindingContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopContext extends ExprContext {
		public ExprContext condition;
		public ExprContext body;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LoopContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ExprContext {
		public Token var;
		public TerminalNode IDENT() { return getToken(ILPMLgrammar2016Parser.IDENT, 0); }
		public VariableContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AlternativeContext extends ExprContext {
		public ExprContext condition;
		public ExprContext consequence;
		public ExprContext alternant;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AlternativeContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InvocationContext extends ExprContext {
		public ExprContext fun;
		public ExprContext expr;
		public List<ExprContext> args = new ArrayList<ExprContext>();
		public Token IDENT;
		public List<Token> names = new ArrayList<Token>();
		public List<ExprContext> nargs = new ArrayList<ExprContext>();
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> IDENT() { return getTokens(ILPMLgrammar2016Parser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(ILPMLgrammar2016Parser.IDENT, i);
		}
		public InvocationContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstFloatContext extends ExprContext {
		public Token floatConst;
		public TerminalNode FLOAT() { return getToken(ILPMLgrammar2016Parser.FLOAT, 0); }
		public ConstFloatContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SequenceContext extends ExprContext {
		public ExprContext expr;
		public List<ExprContext> exprs = new ArrayList<ExprContext>();
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SequenceContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableAssignContext extends ExprContext {
		public Token var;
		public ExprContext val;
		public TerminalNode IDENT() { return getToken(ILPMLgrammar2016Parser.IDENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VariableAssignContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstFalseContext extends ExprContext {
		public ConstFalseContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryContext extends ExprContext {
		public Token op;
		public ExprContext arg;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstTrueContext extends ExprContext {
		public ConstTrueContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstIntegerContext extends ExprContext {
		public Token intConst;
		public TerminalNode INT() { return getToken(ILPMLgrammar2016Parser.INT, 0); }
		public ConstIntegerContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstStringContext extends ExprContext {
		public Token stringConst;
		public TerminalNode STRING() { return getToken(ILPMLgrammar2016Parser.STRING, 0); }
		public ConstStringContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryContext extends ExprContext {
		public ExprContext arg1;
		public Token op;
		public ExprContext arg2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new SequenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(56);
				match(T__2);
				setState(57);
				((SequenceContext)_localctx).expr = expr(0);
				((SequenceContext)_localctx).exprs.add(((SequenceContext)_localctx).expr);
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(59);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__0) {
							{
							setState(58);
							match(T__0);
							}
						}

						setState(61);
						((SequenceContext)_localctx).expr = expr(0);
						((SequenceContext)_localctx).exprs.add(((SequenceContext)_localctx).expr);
						}
						} 
					}
					setState(66);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(67);
					match(T__0);
					}
				}

				setState(70);
				match(T__5);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(73);
				((UnaryContext)_localctx).arg = expr(17);
				}
				break;
			case 3:
				{
				_localctx = new ConstTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				match(T__22);
				}
				break;
			case 4:
				{
				_localctx = new ConstFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75);
				match(T__23);
				}
				break;
			case 5:
				{
				_localctx = new ConstIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				((ConstIntegerContext)_localctx).intConst = match(INT);
				}
				break;
			case 6:
				{
				_localctx = new ConstFloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				((ConstFloatContext)_localctx).floatConst = match(FLOAT);
				}
				break;
			case 7:
				{
				_localctx = new ConstStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				((ConstStringContext)_localctx).stringConst = match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				((VariableContext)_localctx).var = match(IDENT);
				}
				break;
			case 9:
				{
				_localctx = new BindingContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				match(T__24);
				setState(81);
				((BindingContext)_localctx).IDENT = match(IDENT);
				((BindingContext)_localctx).vars.add(((BindingContext)_localctx).IDENT);
				setState(82);
				match(T__25);
				setState(83);
				((BindingContext)_localctx).expr = expr(0);
				((BindingContext)_localctx).vals.add(((BindingContext)_localctx).expr);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__26) {
					{
					{
					setState(84);
					match(T__26);
					setState(85);
					((BindingContext)_localctx).IDENT = match(IDENT);
					((BindingContext)_localctx).vars.add(((BindingContext)_localctx).IDENT);
					setState(86);
					match(T__25);
					setState(87);
					((BindingContext)_localctx).expr = expr(0);
					((BindingContext)_localctx).vals.add(((BindingContext)_localctx).expr);
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(93);
				match(T__27);
				setState(94);
				((BindingContext)_localctx).body = expr(4);
				}
				break;
			case 10:
				{
				_localctx = new AlternativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				match(T__28);
				setState(97);
				((AlternativeContext)_localctx).condition = expr(0);
				setState(98);
				match(T__29);
				setState(99);
				((AlternativeContext)_localctx).consequence = expr(0);
				setState(102);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(100);
					match(T__30);
					setState(101);
					((AlternativeContext)_localctx).alternant = expr(0);
					}
					break;
				}
				}
				break;
			case 11:
				{
				_localctx = new VariableAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				((VariableAssignContext)_localctx).var = match(IDENT);
				setState(105);
				match(T__25);
				setState(106);
				((VariableAssignContext)_localctx).val = expr(2);
				}
				break;
			case 12:
				{
				_localctx = new LoopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(107);
				match(T__31);
				setState(108);
				((LoopContext)_localctx).condition = expr(0);
				setState(109);
				match(T__32);
				setState(110);
				((LoopContext)_localctx).body = expr(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(154);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						((BinaryContext)_localctx).arg1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(114);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(115);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7168L) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(116);
						((BinaryContext)_localctx).arg2 = expr(17);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						((BinaryContext)_localctx).arg1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(117);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(118);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__7 || _la==T__12) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(119);
						((BinaryContext)_localctx).arg2 = expr(16);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						((BinaryContext)_localctx).arg1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(120);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(121);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(122);
						((BinaryContext)_localctx).arg2 = expr(15);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						((BinaryContext)_localctx).arg1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(123);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(124);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__18) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(125);
						((BinaryContext)_localctx).arg2 = expr(14);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						((BinaryContext)_localctx).arg1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(126);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(127);
						((BinaryContext)_localctx).op = match(T__19);
						setState(128);
						((BinaryContext)_localctx).arg2 = expr(13);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						((BinaryContext)_localctx).arg1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(129);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(130);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__21) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(131);
						((BinaryContext)_localctx).arg2 = expr(12);
						}
						break;
					case 7:
						{
						_localctx = new InvocationContext(new ExprContext(_parentctx, _parentState));
						((InvocationContext)_localctx).fun = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(132);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(133);
						match(T__2);
						setState(135);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 262588597000L) != 0)) {
							{
							setState(134);
							((InvocationContext)_localctx).expr = expr(0);
							((InvocationContext)_localctx).args.add(((InvocationContext)_localctx).expr);
							}
						}

						setState(141);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(137);
								match(T__3);
								setState(138);
								((InvocationContext)_localctx).expr = expr(0);
								((InvocationContext)_localctx).args.add(((InvocationContext)_localctx).expr);
								}
								} 
							}
							setState(143);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
						}
						setState(150);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__3) {
							{
							{
							setState(144);
							match(T__3);
							setState(145);
							match(T__6);
							setState(146);
							((InvocationContext)_localctx).IDENT = match(IDENT);
							((InvocationContext)_localctx).names.add(((InvocationContext)_localctx).IDENT);
							setState(147);
							((InvocationContext)_localctx).expr = expr(0);
							((InvocationContext)_localctx).nargs.add(((InvocationContext)_localctx).expr);
							}
							}
							setState(152);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(153);
						match(T__5);
						}
						break;
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001)\u00a0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0003\u0000\t\b\u0000\u0005"+
		"\u0000\u000b\b\u0000\n\u0000\f\u0000\u000e\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u0000\u0012\b\u0000\u0005\u0000\u0014\b\u0000\n\u0000\f\u0000\u0017"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\u001f\b\u0001\u0001\u0001\u0001\u0001\u0005\u0001#"+
		"\b\u0001\n\u0001\f\u0001&\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001.\b\u0001\n\u0001\f\u0001"+
		"1\t\u0001\u0003\u00013\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002<\b\u0002\u0001"+
		"\u0002\u0005\u0002?\b\u0002\n\u0002\f\u0002B\t\u0002\u0001\u0002\u0003"+
		"\u0002E\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002Y\b\u0002\n\u0002\f\u0002\\\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002g\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002q\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002\u0088\b\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u008c\b\u0002"+
		"\n\u0002\f\u0002\u008f\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u0095\b\u0002\n\u0002\f\u0002\u0098\t\u0002\u0001\u0002"+
		"\u0005\u0002\u009b\b\u0002\n\u0002\f\u0002\u009e\t\u0002\u0001\u0002\u0000"+
		"\u0001\u0004\u0003\u0000\u0002\u0004\u0000\u0006\u0001\u0000\b\t\u0001"+
		"\u0000\n\f\u0002\u0000\b\b\r\r\u0001\u0000\u000e\u0011\u0001\u0000\u0012"+
		"\u0013\u0001\u0000\u0015\u0016\u00be\u0000\f\u0001\u0000\u0000\u0000\u0002"+
		"\u001a\u0001\u0000\u0000\u0000\u0004p\u0001\u0000\u0000\u0000\u0006\b"+
		"\u0003\u0002\u0001\u0000\u0007\t\u0005\u0001\u0000\u0000\b\u0007\u0001"+
		"\u0000\u0000\u0000\b\t\u0001\u0000\u0000\u0000\t\u000b\u0001\u0000\u0000"+
		"\u0000\n\u0006\u0001\u0000\u0000\u0000\u000b\u000e\u0001\u0000\u0000\u0000"+
		"\f\n\u0001\u0000\u0000\u0000\f\r\u0001\u0000\u0000\u0000\r\u0015\u0001"+
		"\u0000\u0000\u0000\u000e\f\u0001\u0000\u0000\u0000\u000f\u0011\u0003\u0004"+
		"\u0002\u0000\u0010\u0012\u0005\u0001\u0000\u0000\u0011\u0010\u0001\u0000"+
		"\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0014\u0001\u0000"+
		"\u0000\u0000\u0013\u000f\u0001\u0000\u0000\u0000\u0014\u0017\u0001\u0000"+
		"\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0015\u0016\u0001\u0000"+
		"\u0000\u0000\u0016\u0018\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000"+
		"\u0000\u0000\u0018\u0019\u0005\u0000\u0000\u0001\u0019\u0001\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0005\u0002\u0000\u0000\u001b\u001c\u0005\"\u0000"+
		"\u0000\u001c\u001e\u0005\u0003\u0000\u0000\u001d\u001f\u0005\"\u0000\u0000"+
		"\u001e\u001d\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000"+
		"\u001f$\u0001\u0000\u0000\u0000 !\u0005\u0004\u0000\u0000!#\u0005\"\u0000"+
		"\u0000\" \u0001\u0000\u0000\u0000#&\u0001\u0000\u0000\u0000$\"\u0001\u0000"+
		"\u0000\u0000$%\u0001\u0000\u0000\u0000%2\u0001\u0000\u0000\u0000&$\u0001"+
		"\u0000\u0000\u0000\'(\u0005\u0005\u0000\u0000()\u0005\"\u0000\u0000)/"+
		"\u0003\u0004\u0002\u0000*+\u0005\u0004\u0000\u0000+,\u0005\"\u0000\u0000"+
		",.\u0003\u0004\u0002\u0000-*\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000003\u0001\u0000"+
		"\u0000\u00001/\u0001\u0000\u0000\u00002\'\u0001\u0000\u0000\u000023\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0005\u0006\u0000\u0000"+
		"56\u0003\u0004\u0002\u00006\u0003\u0001\u0000\u0000\u000078\u0006\u0002"+
		"\uffff\uffff\u000089\u0005\u0003\u0000\u00009@\u0003\u0004\u0002\u0000"+
		":<\u0005\u0001\u0000\u0000;:\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000"+
		"\u0000<=\u0001\u0000\u0000\u0000=?\u0003\u0004\u0002\u0000>;\u0001\u0000"+
		"\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001"+
		"\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000"+
		"CE\u0005\u0001\u0000\u0000DC\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FG\u0005\u0006\u0000\u0000Gq\u0001\u0000"+
		"\u0000\u0000HI\u0007\u0000\u0000\u0000Iq\u0003\u0004\u0002\u0011Jq\u0005"+
		"\u0017\u0000\u0000Kq\u0005\u0018\u0000\u0000Lq\u0005#\u0000\u0000Mq\u0005"+
		"$\u0000\u0000Nq\u0005%\u0000\u0000Oq\u0005\"\u0000\u0000PQ\u0005\u0019"+
		"\u0000\u0000QR\u0005\"\u0000\u0000RS\u0005\u001a\u0000\u0000SZ\u0003\u0004"+
		"\u0002\u0000TU\u0005\u001b\u0000\u0000UV\u0005\"\u0000\u0000VW\u0005\u001a"+
		"\u0000\u0000WY\u0003\u0004\u0002\u0000XT\u0001\u0000\u0000\u0000Y\\\u0001"+
		"\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000"+
		"[]\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]^\u0005\u001c\u0000"+
		"\u0000^_\u0003\u0004\u0002\u0004_q\u0001\u0000\u0000\u0000`a\u0005\u001d"+
		"\u0000\u0000ab\u0003\u0004\u0002\u0000bc\u0005\u001e\u0000\u0000cf\u0003"+
		"\u0004\u0002\u0000de\u0005\u001f\u0000\u0000eg\u0003\u0004\u0002\u0000"+
		"fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gq\u0001\u0000\u0000"+
		"\u0000hi\u0005\"\u0000\u0000ij\u0005\u001a\u0000\u0000jq\u0003\u0004\u0002"+
		"\u0002kl\u0005 \u0000\u0000lm\u0003\u0004\u0002\u0000mn\u0005!\u0000\u0000"+
		"no\u0003\u0004\u0002\u0001oq\u0001\u0000\u0000\u0000p7\u0001\u0000\u0000"+
		"\u0000pH\u0001\u0000\u0000\u0000pJ\u0001\u0000\u0000\u0000pK\u0001\u0000"+
		"\u0000\u0000pL\u0001\u0000\u0000\u0000pM\u0001\u0000\u0000\u0000pN\u0001"+
		"\u0000\u0000\u0000pO\u0001\u0000\u0000\u0000pP\u0001\u0000\u0000\u0000"+
		"p`\u0001\u0000\u0000\u0000ph\u0001\u0000\u0000\u0000pk\u0001\u0000\u0000"+
		"\u0000q\u009c\u0001\u0000\u0000\u0000rs\n\u0010\u0000\u0000st\u0007\u0001"+
		"\u0000\u0000t\u009b\u0003\u0004\u0002\u0011uv\n\u000f\u0000\u0000vw\u0007"+
		"\u0002\u0000\u0000w\u009b\u0003\u0004\u0002\u0010xy\n\u000e\u0000\u0000"+
		"yz\u0007\u0003\u0000\u0000z\u009b\u0003\u0004\u0002\u000f{|\n\r\u0000"+
		"\u0000|}\u0007\u0004\u0000\u0000}\u009b\u0003\u0004\u0002\u000e~\u007f"+
		"\n\f\u0000\u0000\u007f\u0080\u0005\u0014\u0000\u0000\u0080\u009b\u0003"+
		"\u0004\u0002\r\u0081\u0082\n\u000b\u0000\u0000\u0082\u0083\u0007\u0005"+
		"\u0000\u0000\u0083\u009b\u0003\u0004\u0002\f\u0084\u0085\n\u0012\u0000"+
		"\u0000\u0085\u0087\u0005\u0003\u0000\u0000\u0086\u0088\u0003\u0004\u0002"+
		"\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u008d\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u0004\u0000"+
		"\u0000\u008a\u008c\u0003\u0004\u0002\u0000\u008b\u0089\u0001\u0000\u0000"+
		"\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0096\u0001\u0000\u0000"+
		"\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0005\u0004\u0000"+
		"\u0000\u0091\u0092\u0005\u0007\u0000\u0000\u0092\u0093\u0005\"\u0000\u0000"+
		"\u0093\u0095\u0003\u0004\u0002\u0000\u0094\u0090\u0001\u0000\u0000\u0000"+
		"\u0095\u0098\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0099\u0001\u0000\u0000\u0000"+
		"\u0098\u0096\u0001\u0000\u0000\u0000\u0099\u009b\u0005\u0006\u0000\u0000"+
		"\u009ar\u0001\u0000\u0000\u0000\u009au\u0001\u0000\u0000\u0000\u009ax"+
		"\u0001\u0000\u0000\u0000\u009a{\u0001\u0000\u0000\u0000\u009a~\u0001\u0000"+
		"\u0000\u0000\u009a\u0081\u0001\u0000\u0000\u0000\u009a\u0084\u0001\u0000"+
		"\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000"+
		"\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u0005\u0001\u0000"+
		"\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u0013\b\f\u0011\u0015"+
		"\u001e$/2;@DZfp\u0087\u008d\u0096\u009a\u009c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}