/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2018.compiler.ast;

import com.paracamplus.ilp2.compiler.ast.ASTCfunctionDefinition;
import com.paracamplus.ilp2.partiel2018.compiler.interfaces.IASTCcountingFunctionDefinition;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public class ASTCcountingFunctionDefinition extends ASTCfunctionDefinition
        implements IASTCcountingFunctionDefinition {

    public ASTCcountingFunctionDefinition(
            boolean isCount,
            IASTvariable functionVariable,
            IASTvariable[] variables,
            IASTexpression body) {
        super(functionVariable, variables, body);
        this.isCount = isCount;
    }

    private boolean isCount;

    @Override
    public boolean isCounting() {
        return isCount;
    }

}
