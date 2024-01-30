/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.compiler.interfaces;

import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalInvocation;

public interface IASTCglobalInvocationOpt extends IASTCglobalInvocation {
    IASTblock.IASTbinding[] getOptionalArgs();

}
