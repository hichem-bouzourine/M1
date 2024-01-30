/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2021.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.partiel2021.interfaces.IASTblockRange.IASTrangeBinding;
import com.paracamplus.ilp2.partiel2021.interfaces.IASTfactory;

public class ASTfactory extends com.paracamplus.ilp2.ast.ASTfactory implements IASTfactory {

    @Override
    public ASTblockRange newBlockRange(IASTrangeBinding[] binding, IASTexpression body) {
        return new ASTblockRange(binding, body);
    }

    @Override
    public IASTrangeBinding newRangeBinding(IASTvariable v, IASTexpression exp, IASTexpression low,
            IASTexpression high) {
        return new ASTblockRange.ASTrangeBinding(v, exp, low, high);
    }

}
