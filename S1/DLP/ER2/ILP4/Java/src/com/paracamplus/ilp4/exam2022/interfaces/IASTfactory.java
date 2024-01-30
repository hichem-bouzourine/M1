/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2022.interfaces;

import org.antlr.v4.runtime.misc.Nullable;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public interface IASTfactory extends com.paracamplus.ilp4.interfaces.IASTfactory {

    IASTlist newList(
            IASTexpression body,
            IASTvariable var,
            IASTexpression max,
            @Nullable IASTexpression cond);

}
