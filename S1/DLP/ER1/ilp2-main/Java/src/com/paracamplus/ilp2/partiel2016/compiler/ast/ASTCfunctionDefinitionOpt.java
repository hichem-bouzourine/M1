/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.compiler.ast;

import com.paracamplus.ilp2.compiler.ast.ASTCfunctionDefinition;
import com.paracamplus.ilp2.partiel2016.compiler.interfaces.IASTCfunctionDefinitionOpt;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public class ASTCfunctionDefinitionOpt extends ASTCfunctionDefinition implements IASTCfunctionDefinitionOpt {

    public ASTCfunctionDefinitionOpt(IASTvariable functionVariable,
            IASTvariable[] variables,
            boolean isOptionalVars,
            IASTblock.IASTbinding[] optionalVars,
            IASTexpression body) {
        super(functionVariable, variables, body);
        this.isOptionalVars = isOptionalVars;
        this.OptionalVars = optionalVars;
    }

    private final boolean isOptionalVars;
    private final IASTblock.IASTbinding[] OptionalVars;

    @Override
    public boolean isOptionalVars() {
        return this.isOptionalVars;
    }

    @Override
    public IASTbinding[] getOptionalVars() {
        return this.OptionalVars;
    }
}
