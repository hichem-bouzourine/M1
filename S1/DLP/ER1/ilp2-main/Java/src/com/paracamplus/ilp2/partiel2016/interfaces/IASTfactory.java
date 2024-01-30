/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.interfaces;

import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public interface IASTfactory extends com.paracamplus.ilp2.interfaces.IASTfactory {
        IASTfunctionDefinitionOpt newFunctionDefinition(
                        IASTvariable functionVariable,
                        IASTvariable[] variables,
                        boolean isOptionalVars,
                        IASTblock.IASTbinding[] optionalVars,
                        IASTexpression body);

        IASTinvocationOpt newInvocation(
                        IASTexpression function,
                        IASTexpression[] arguments,
                        IASTblock.IASTbinding[] optionalVars);

}
