/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.interfaces;

import com.paracamplus.ilp1.interfaces.IASTblock;

public interface IASTinvocationOpt extends com.paracamplus.ilp1.interfaces.IASTinvocation {

	IASTblock.IASTbinding[] getOptionalArgs();
}
