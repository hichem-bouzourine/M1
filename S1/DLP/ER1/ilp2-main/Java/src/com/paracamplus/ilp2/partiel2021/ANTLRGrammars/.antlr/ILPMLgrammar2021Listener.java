// Generated from /home/ubuntu/Desktop/M1/S1/DLP/ER1/ilp2-main/Java/src/com/paracamplus/ilp2/partiel2021/ANTLRGrammars/ILPMLgrammar2021.g4 by ANTLR 4.13.1

    package antlr4;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ILPMLgrammar2021Parser}.
 */
public interface ILPMLgrammar2021Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ILPMLgrammar2021Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ILPMLgrammar2021Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILPMLgrammar2021Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ILPMLgrammar2021Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILPMLgrammar2021Parser#globalFunDef}.
	 * @param ctx the parse tree
	 */
	void enterGlobalFunDef(ILPMLgrammar2021Parser.GlobalFunDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILPMLgrammar2021Parser#globalFunDef}.
	 * @param ctx the parse tree
	 */
	void exitGlobalFunDef(ILPMLgrammar2021Parser.GlobalFunDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Binding}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinding(ILPMLgrammar2021Parser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binding}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinding(ILPMLgrammar2021Parser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Loop}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLoop(ILPMLgrammar2021Parser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Loop}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLoop(ILPMLgrammar2021Parser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ILPMLgrammar2021Parser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ILPMLgrammar2021Parser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Alternative}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAlternative(ILPMLgrammar2021Parser.AlternativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Alternative}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAlternative(ILPMLgrammar2021Parser.AlternativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Invocation}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInvocation(ILPMLgrammar2021Parser.InvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Invocation}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInvocation(ILPMLgrammar2021Parser.InvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstFloat}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstFloat(ILPMLgrammar2021Parser.ConstFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstFloat}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstFloat(ILPMLgrammar2021Parser.ConstFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSequence(ILPMLgrammar2021Parser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSequence(ILPMLgrammar2021Parser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableAssign}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssign(ILPMLgrammar2021Parser.VariableAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableAssign}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssign(ILPMLgrammar2021Parser.VariableAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstFalse}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstFalse(ILPMLgrammar2021Parser.ConstFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstFalse}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstFalse(ILPMLgrammar2021Parser.ConstFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary(ILPMLgrammar2021Parser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary(ILPMLgrammar2021Parser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstTrue}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstTrue(ILPMLgrammar2021Parser.ConstTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstTrue}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstTrue(ILPMLgrammar2021Parser.ConstTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstInteger}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstInteger(ILPMLgrammar2021Parser.ConstIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstInteger}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstInteger(ILPMLgrammar2021Parser.ConstIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockRange}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBlockRange(ILPMLgrammar2021Parser.BlockRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockRange}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBlockRange(ILPMLgrammar2021Parser.BlockRangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstString}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstString(ILPMLgrammar2021Parser.ConstStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstString}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstString(ILPMLgrammar2021Parser.ConstStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinary(ILPMLgrammar2021Parser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link ILPMLgrammar2021Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinary(ILPMLgrammar2021Parser.BinaryContext ctx);
}