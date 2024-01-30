/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2018.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ast.ASTfunctionDefinition;
import com.paracamplus.ilp2.partiel2018.interfaces.IASTcountingFunctionDefinition;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public class ASTcountingFunctionDefinition extends ASTfunctionDefinition
        implements IASTcountingFunctionDefinition {

    public ASTcountingFunctionDefinition(
            boolean isCounting,
            IASTvariable functionVariable,
            IASTvariable[] variables,
            IASTexpression body) {
        super(functionVariable, variables, body);
        this.isCounting = isCounting;
    }

    private final boolean isCounting;

    @Override
    public boolean isCounting() {
        return isCounting;
    }

}
