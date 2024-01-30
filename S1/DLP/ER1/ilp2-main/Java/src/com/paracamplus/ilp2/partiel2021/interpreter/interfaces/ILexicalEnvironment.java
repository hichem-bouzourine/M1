/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2021.interpreter.interfaces;

import java.math.BigInteger;

public interface ILexicalEnvironment extends com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment {
    public BigInteger getLow();

    public BigInteger getHigh();

}
