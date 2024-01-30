/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2021.interpreter;

import java.math.BigInteger;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.partiel2021.interfaces.IASTblockRange;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;

public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter
        implements
        com.paracamplus.ilp2.partiel2021.interfaces.IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

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

    @Override
    public Object visit(IASTblockRange iast, ILexicalEnvironment lexenv) throws EvaluationException {
        ILexicalEnvironment lexenv2 = lexenv;

        for (IASTblockRange.IASTrangeBinding binding : iast.getBindings()) {
            Object low = binding.getLow().accept(this, lexenv);
            Object high = binding.gethigh().accept(this, lexenv);

            if (!(low instanceof BigInteger && high instanceof BigInteger)) {
                throw new EvaluationException("borders must be a number");
            }

            int l = ((BigInteger) low).intValue();
            int h = ((BigInteger) high).intValue();

            Object init = binding.getInitialisation().accept(this, lexenv);
            if (!(init instanceof BigInteger)) {
                throw new EvaluationException("Initialisation is not a number");
            }
            int n = ((BigInteger) init).intValue();
            if (n < l) {
                n = l;
            } else if (n > h) {
                n = h;
            }
            lexenv2 = lexenv2.extend(binding.getVariable(), n);
        }

        return iast.getBody().accept((this), lexenv2);
    }

    @Override
    public Object visit(IASTblock iast, ILexicalEnvironment lexenv)
            throws EvaluationException {
        ILexicalEnvironment lexenv2 = lexenv;
        for (IASTbinding binding : iast.getBindings()) {
            Object initialisation = binding.getInitialisation().accept(this, lexenv);
            lexenv2 = lexenv2.extend(binding.getVariable(), initialisation);
        }
        return iast.getBody().accept(this, lexenv2);
    }

    //

}
