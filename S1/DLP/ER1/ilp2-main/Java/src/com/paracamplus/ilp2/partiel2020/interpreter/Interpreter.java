/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2020.interpreter;

import com.paracamplus.ilp2.partiel2020.interfaces.IASTsequenceN;
import com.paracamplus.ilp2.partiel2020.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;

public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter
        implements
        IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

    //

    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment,
            IOperatorEnvironment operatorEnvironment) {
        super(globalVariableEnvironment, operatorEnvironment);
    }

    @Override
    public Object visit(IASTsequenceN iast, ILexicalEnvironment lexenv) throws EvaluationException {
        // eval firstExpr then go to the arg with index of the result of the firstExpr
        // and evaluate it and return it.

        int firstExpr = (int) iast.getFirstExpr().accept(this, lexenv);

        IASTexpression[] expressions = iast.getExpressions();

        if (firstExpr > expressions.length) {
            throw new EvaluationException("Index out of range");
        }

        Object result = expressions[firstExpr].accept(this, lexenv);

        return result;

    }

}
