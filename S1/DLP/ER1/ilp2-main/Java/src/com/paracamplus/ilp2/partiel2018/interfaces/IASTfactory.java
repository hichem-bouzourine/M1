/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2018.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public interface IASTfactory extends com.paracamplus.ilp2.interfaces.IASTfactory {

        IASTcountingFunctionDefinition newCountingFunctionDefinition(
                        boolean isCounting,
                        IASTvariable functionVariable,
                        IASTvariable[] variables,
                        IASTexpression body);

}
