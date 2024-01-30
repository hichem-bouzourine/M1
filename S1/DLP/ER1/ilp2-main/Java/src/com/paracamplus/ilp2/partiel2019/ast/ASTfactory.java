/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2019.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.partiel2019.interfaces.IASTfactory;
import com.paracamplus.ilp2.partiel2019.interfaces.IASTfreeze;
import com.paracamplus.ilp2.partiel2019.interfaces.IASTfrozen;

public class ASTfactory extends com.paracamplus.ilp2.ast.ASTfactory
        implements IASTfactory {

    @Override
    public IASTfreeze newFreeze(IASTexpression function, IASTexpression[] arguments) {
        return new ASTfreeze(function, arguments);
    }

    @Override
    public IASTfrozen newFrozen(IASTexpression function) {
        return new ASTfrozen(function);
    }

}
