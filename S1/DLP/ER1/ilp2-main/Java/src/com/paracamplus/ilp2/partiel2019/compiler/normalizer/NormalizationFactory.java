/* *****************************************************************
 * ilp2 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp2
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2019.compiler.normalizer;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.partiel2019.ast.ASTfreeze;
import com.paracamplus.ilp2.partiel2019.ast.ASTfrozen;
import com.paracamplus.ilp2.partiel2019.interfaces.IASTfreeze;
import com.paracamplus.ilp2.partiel2019.interfaces.IASTfrozen;

public class NormalizationFactory extends com.paracamplus.ilp2.compiler.normalizer.NormalizationFactory
        implements INormalizationFactory {

    @Override
    public IASTfreeze newFreeze(IASTexpression fun, IASTexpression[] args) {
        return new ASTfreeze(fun, args);
    }

    @Override
    public IASTfrozen newFrozen(IASTexpression fun) {
        return new ASTfrozen(fun);
    }

}
