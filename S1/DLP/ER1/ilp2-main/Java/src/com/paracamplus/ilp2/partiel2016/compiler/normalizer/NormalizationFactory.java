/* *****************************************************************
 * ilp2 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp2
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.compiler.normalizer;

import com.paracamplus.ilp2.partiel2016.compiler.ast.ASTCfunctionDefinitionOpt;
import com.paracamplus.ilp2.partiel2016.compiler.ast.ASTCglobalInvocationOpt;
import com.paracamplus.ilp2.partiel2016.compiler.interfaces.IASTCfunctionDefinitionOpt;
import com.paracamplus.ilp2.partiel2016.compiler.interfaces.IASTCglobalInvocationOpt;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public class NormalizationFactory
        extends com.paracamplus.ilp2.compiler.normalizer.NormalizationFactory
        implements INormalizationFactory {

    @Override
    public IASTCfunctionDefinitionOpt newFunctionDefinitionOpt(
            IASTvariable functionVariable,
            IASTvariable[] variables,
            boolean isOptionalVars,
            IASTblock.IASTbinding[] optionalVars,
            IASTexpression body) {
        return new ASTCfunctionDefinitionOpt(functionVariable, variables, isOptionalVars, optionalVars, body);
    }

    @Override
    public IASTCglobalInvocationOpt newGlobalInvocationOpt(
            IASTexpression function,
            IASTexpression[] arguments,
            IASTbinding[] optionalArgs) {
        return new ASTCglobalInvocationOpt(function, arguments, optionalArgs);
    }

}
