/* *****************************************************************
 * ilp2 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp2
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2018.compiler.normalizer;

import com.paracamplus.ilp2.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp2.partiel2018.compiler.interfaces.IASTCcountingFunctionDefinition;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public interface INormalizationFactory
              extends com.paracamplus.ilp2.compiler.normalizer.INormalizationFactory {

       IASTCprogram newProgram(IASTCcountingFunctionDefinition[] functions,
                     IASTexpression expression);

       IASTCcountingFunctionDefinition newCountingFunctionDefinition(
                     boolean isCount,
                     IASTvariable functionVariable,
                     IASTvariable[] variables,
                     IASTexpression body);

}
