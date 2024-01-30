/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2017.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.partiel2017.interfaces.IASTfactory;
import com.paracamplus.ilp2.partiel2017.interfaces.IASTswitch;

public class ASTfactory extends com.paracamplus.ilp2.ast.ASTfactory
        implements IASTfactory {

    @Override
    public IASTswitch newSwitch(
            IASTexpression initialCondition,
            IASTexpression[] conditions,
            IASTexpression[] evals,
            IASTexpression defaultExpr) {
        return new ASTswitch(initialCondition, conditions, evals, defaultExpr);
    }

}
