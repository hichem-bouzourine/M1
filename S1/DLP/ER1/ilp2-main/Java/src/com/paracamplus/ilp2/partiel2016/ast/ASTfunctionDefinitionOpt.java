/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.ast;

import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.partiel2016.interfaces.IASTfunctionDefinitionOpt;

public class ASTfunctionDefinitionOpt extends com.paracamplus.ilp2.ast.ASTfunctionDefinition
        implements IASTfunctionDefinitionOpt {

    public ASTfunctionDefinitionOpt(IASTvariable functionVariable,
            IASTvariable[] variables,
            boolean isOptionalVars,
            IASTblock.IASTbinding[] optionalVars,
            IASTexpression body) {
        super(functionVariable, variables, body);
        this.optionalVars = optionalVars;

    }

    private final IASTblock.IASTbinding[] optionalVars;

    @Override
    public IASTbinding[] getOptionalVars() {
        return optionalVars;
    }

    @Override
    public boolean isOptionalVars() {
        return this.isOptionalVars();
    }
}
