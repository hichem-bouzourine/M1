/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.ast;

import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.partiel2016.interfaces.IASTfactory;
import com.paracamplus.ilp2.partiel2016.interfaces.IASTfunctionDefinitionOpt;
import com.paracamplus.ilp2.partiel2016.interfaces.IASTinvocationOpt;

public class ASTfactory extends com.paracamplus.ilp2.ast.ASTfactory
        implements IASTfactory {

    @Override
    public IASTfunctionDefinitionOpt newFunctionDefinition(
            IASTvariable functionVariable,
            IASTvariable[] variables,
            boolean isOptionalVars,
            IASTblock.IASTbinding[] optionalVars,
            IASTexpression body) {
        return new ASTfunctionDefinitionOpt(functionVariable, variables, isOptionalVars, optionalVars, body);
    }

    @Override
    public IASTinvocationOpt newInvocation(IASTexpression function, IASTexpression[] arguments,
            IASTbinding[] optionalVars) {
        return new ASTinvocationOpt(function, arguments, optionalVars);
    }

}
