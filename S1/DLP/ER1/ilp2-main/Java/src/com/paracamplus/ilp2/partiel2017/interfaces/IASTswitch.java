/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2017.interfaces;

import com.paracamplus.ilp1.annotation.OrNull;
import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTswitch extends IASTexpression {
	IASTexpression getInitialCondition();

	IASTexpression[] getConditions();

	IASTexpression[] getEvals();

	@OrNull
	IASTexpression getDefaultExpr();

}
