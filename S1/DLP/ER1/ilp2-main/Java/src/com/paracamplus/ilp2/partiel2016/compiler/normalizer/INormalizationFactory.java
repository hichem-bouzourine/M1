/* *****************************************************************
 * ilp2 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp2
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.compiler.normalizer;

import com.paracamplus.ilp2.partiel2016.compiler.interfaces.IASTCfunctionDefinitionOpt;
import com.paracamplus.ilp2.partiel2016.compiler.interfaces.IASTCglobalInvocationOpt;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public interface INormalizationFactory
              extends com.paracamplus.ilp2.compiler.normalizer.INormalizationFactory {

       IASTCfunctionDefinitionOpt newFunctionDefinitionOpt(
                     IASTvariable functionVariable,
                     IASTvariable[] variables,
                     boolean isOptionalVars,
                     IASTblock.IASTbinding[] optionalVars,
                     IASTexpression body);

       IASTCglobalInvocationOpt newGlobalInvocationOpt(
                     IASTexpression function,
                     IASTexpression[] arguments,
                     IASTblock.IASTbinding[] optionalArgs);

}
