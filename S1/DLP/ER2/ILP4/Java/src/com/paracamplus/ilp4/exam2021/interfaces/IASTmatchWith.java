/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2021.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public interface IASTmatchWith extends IASTexpression {
	IASTexpression getSomme();

	String getTag();

	IASTvariable[] getVariables();

	IASTexpression getConsequence();

	IASTexpression getAlternant();
}
