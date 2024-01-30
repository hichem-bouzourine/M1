// Generated from /home/hichem/Desktop/M1/S1/DLP/ER1/ilp2-main/Java/src/com/paracamplus/ilp2/partiel2017/ANTLRGrammars/ILPMLgrammar1.g4 by ANTLR 4.13.1

    package antlr4;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ILPMLgrammar1Parser}.
 */
public interface ILPMLgrammar1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ILPMLgrammar1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ILPMLgrammar1Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILPMLgrammar1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ILPMLgrammar1Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Binding}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinding(ILPMLgrammar1Parser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binding}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinding(ILPMLgrammar1Parser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstTrue}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstTrue(ILPMLgrammar1Parser.ConstTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstTrue}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstTrue(ILPMLgrammar1Parser.ConstTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstInteger}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstInteger(ILPMLgrammar1Parser.ConstIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstInteger}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstInteger(ILPMLgrammar1Parser.ConstIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ILPMLgrammar1Parser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ILPMLgrammar1Parser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Alternative}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAlternative(ILPMLgrammar1Parser.AlternativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Alternative}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAlternative(ILPMLgrammar1Parser.AlternativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Invocation}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInvocation(ILPMLgrammar1Parser.InvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Invocation}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInvocation(ILPMLgrammar1Parser.InvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstFloat}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstFloat(ILPMLgrammar1Parser.ConstFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstFloat}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstFloat(ILPMLgrammar1Parser.ConstFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstString}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstString(ILPMLgrammar1Parser.ConstStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstString}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstString(ILPMLgrammar1Parser.ConstStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSequence(ILPMLgrammar1Parser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSequence(ILPMLgrammar1Parser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinary(ILPMLgrammar1Parser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinary(ILPMLgrammar1Parser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstFalse}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstFalse(ILPMLgrammar1Parser.ConstFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstFalse}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstFalse(ILPMLgrammar1Parser.ConstFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary(ILPMLgrammar1Parser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link ILPMLgrammar1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary(ILPMLgrammar1Parser.UnaryContext ctx);
}