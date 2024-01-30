/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2019.interpreter;

import com.paracamplus.ilp4.exam2019.interfaces.IASTautoclose;
import com.paracamplus.ilp4.exam2019.interfaces.IASTvisitor;
import com.paracamplus.ilp4.interfaces.IASTprogram;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp4.interpreter.ILPInstance;
import com.paracamplus.ilp4.interpreter.interfaces.IClassEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;

public class Interpreter extends com.paracamplus.ilp4.interpreter.Interpreter
        implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment,
            IOperatorEnvironment operatorEnvironment,
            IClassEnvironment classEnvironment) {
        super(globalVariableEnvironment, operatorEnvironment, classEnvironment);

    }

    //
    @Override
    public Object visit(com.paracamplus.ilp1.interfaces.IASTprogram iast, ILexicalEnvironment lexenv)
            throws EvaluationException {
        return visit((IASTprogram) iast, lexenv);
    }

    @Override
    public Object visit(IASTautoclose iast, ILexicalEnvironment lexenv) throws EvaluationException {
        ILexicalEnvironment lexenv2 = lexenv;
        // Lexical env réservé juste pour ce bloc de autoclose.

        Object init = iast.getInitialisation().accept(this, lexenv2);
        if (!(init instanceof ILPInstance)) {
            throw new EvaluationException(init + " is not of type ILP CLASS");
        }
        ILPInstance i = (ILPInstance) init;

        lexenv2 = lexenv2.extend(iast.getVariable(), i);

        try {
            Object expr2 = iast.getBody().accept(this, lexenv2);
            i.send(this, "close", new Object[0]);
            return expr2;
        } catch (Exception e) {
            i.send(this, "close", new Object[0]);
            throw new EvaluationException(e.getMessage());
        }

    }

}
