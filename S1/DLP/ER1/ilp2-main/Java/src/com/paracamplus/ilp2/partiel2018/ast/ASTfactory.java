/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2018.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.partiel2018.interfaces.*;

public class ASTfactory extends com.paracamplus.ilp2.ast.ASTfactory
        implements IASTfactory {

    @Override
    public IASTcountingFunctionDefinition newCountingFunctionDefinition(
            boolean isCounting,
            IASTvariable functionVariable,
            IASTvariable[] variables,
            IASTexpression body) {
        return new ASTcountingFunctionDefinition(isCounting, functionVariable, variables, body);
    }

}
