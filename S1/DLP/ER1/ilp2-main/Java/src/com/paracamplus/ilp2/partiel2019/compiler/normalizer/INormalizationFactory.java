/* *****************************************************************
 * ilp2 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp2
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2019.compiler.normalizer;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.partiel2019.interfaces.IASTfreeze;
import com.paracamplus.ilp2.partiel2019.interfaces.IASTfrozen;

public interface INormalizationFactory extends com.paracamplus.ilp2.compiler.normalizer.INormalizationFactory {

       IASTfreeze newFreeze(IASTexpression fun, IASTexpression[] args);

       IASTfrozen newFrozen(IASTexpression fun);

}
