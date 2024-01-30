/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2018.interpreter;

import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.partiel2018.interfaces.IASTcountingFunctionDefinition;
import com.paracamplus.ilp1.interpreter.EmptyLexicalEnvironment;
import com.paracamplus.ilp1.interpreter.Function;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.Invocable;

public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter {

    //

    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment,
            IOperatorEnvironment operatorEnvironment) {
        super(globalVariableEnvironment, operatorEnvironment);
    }

    @Override
    public Object visit(com.paracamplus.ilp1.interfaces.IASTprogram iast, ILexicalEnvironment lexenv)
            throws EvaluationException {
        return visit((IASTprogram) iast, lexenv);
    }

    public Object visit(IASTprogram iast, ILexicalEnvironment lexenv)
            throws EvaluationException {
        for (IASTfunctionDefinition fd : iast.getFunctionDefinitions()) {

            Object f = this.visit((IASTcountingFunctionDefinition) fd, lexenv);
            String v = fd.getName();
            getGlobalVariableEnvironment().addGlobalVariableValue(v, f);
        }
        try {
            return iast.getBody().accept(this, lexenv);
        } catch (Exception exc) {
            return exc;
        }
    }

    //

    public Invocable visit(IASTcountingFunctionDefinition iast, ILexicalEnvironment lexenv) throws EvaluationException {
        boolean isCounting = iast.isCounting();

        if (isCounting) {
            Invocable countFun = new CountingFunction(iast.getVariables(), iast.getBody(),
                    new EmptyLexicalEnvironment());
            return countFun;
        } else {
            Invocable fun = new Function(iast.getVariables(), iast.getBody(), new EmptyLexicalEnvironment());
            return fun;
        }
    }

}
