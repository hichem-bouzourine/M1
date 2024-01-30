/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2017.interpreter;

import com.paracamplus.ilp2.partiel2017.interfaces.IASTswitch;
import com.paracamplus.ilp2.partiel2017.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;

public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter
        implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

    //

    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment,
            IOperatorEnvironment operatorEnvironment) {
        super(globalVariableEnvironment, operatorEnvironment);
    }

    @Override
    public Object visit(IASTswitch iast, ILexicalEnvironment lexenv) throws EvaluationException {
        Object initialCondition = iast.getInitialCondition().accept(this, lexenv);
        Object defaultExpr = iast.getDefaultExpr();
        IASTexpression[] conditions = iast.getConditions();
        IASTexpression[] evals = iast.getEvals();
        if (conditions.length != evals.length)
            throw new EvaluationException("Error, Cases are not equals to possible evaluation");
        int i = 0;

        while (i < conditions.length) {

            if (conditions[i].accept(this, lexenv).equals(initialCondition)) {
                return evals[i].accept(this, lexenv);
            }
            i++;
        }

        if (defaultExpr != null) {
            return iast.getDefaultExpr().accept(this, lexenv);
        } else {
            return Boolean.FALSE;
        }
    }
}
