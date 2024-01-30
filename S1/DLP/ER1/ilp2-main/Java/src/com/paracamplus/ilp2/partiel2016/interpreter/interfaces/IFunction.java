/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.interpreter.interfaces;

import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp2.partiel2016.interpreter.Interpreter;

public interface IFunction extends com.paracamplus.ilp1.interpreter.interfaces.IFunction {
    IASTblock.IASTbinding[] getOptionalVars();

    Object apply(Interpreter interpreter, Object[] argument, IASTblock.IASTbinding[] opt) throws EvaluationException;

}
