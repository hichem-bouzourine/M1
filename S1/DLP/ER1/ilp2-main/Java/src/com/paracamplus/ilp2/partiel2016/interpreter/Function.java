/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.interpreter;

import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp2.partiel2016.interpreter.interfaces.IFunction;

public class Function extends com.paracamplus.ilp1.interpreter.Function implements IFunction {

    public Function(IASTvariable[] variables,
            IASTexpression body,
            ILexicalEnvironment lexenv,
            IASTblock.IASTbinding[] optionalVars) {
        super(variables, body, lexenv);
        this.optionalVars = optionalVars;
    }

    private final IASTblock.IASTbinding[] optionalVars;

    @Override
    public IASTbinding[] getOptionalVars() {
        return this.optionalVars;
    }

    @Override
    public Object apply(Interpreter interpreter, Object[] argument, IASTblock.IASTbinding[] opt)
            throws EvaluationException {
        if (argument.length != getArity()) {
            String msg = "Wrong arity";
            throw new EvaluationException(msg);
        }
        ILexicalEnvironment lexenv2 = getClosedEnvironment();

        IASTvariable[] variables = getVariables();
        for (int i = 0; i < argument.length; i++) {
            lexenv2 = lexenv2.extend(variables[i], argument[i]);
        }

        for (IASTbinding binding : opt) {
            Object initialisation = binding.getInitialisation().accept(interpreter, lexenv2);
            lexenv2 = lexenv2.extend(binding.getVariable(), initialisation);
        }

        return getBody().accept(interpreter, lexenv2);
    }

}
