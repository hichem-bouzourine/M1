/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2021.interfaces;

import com.paracamplus.ilp2.partiel2021.interfaces.IASTblockRange.IASTrangeBinding;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public interface IASTfactory extends com.paracamplus.ilp2.interfaces.IASTfactory {

        IASTexpression newBlockRange(IASTrangeBinding[] binding, IASTexpression body);

        IASTrangeBinding newRangeBinding(IASTvariable v, IASTexpression exp, IASTexpression low, IASTexpression high);

}
