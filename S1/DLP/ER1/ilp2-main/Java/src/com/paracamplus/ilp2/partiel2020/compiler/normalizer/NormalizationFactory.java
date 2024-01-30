/* *****************************************************************
 * ilp2 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp2
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2020.compiler.normalizer;

import com.paracamplus.ilp2.partiel2020.ast.ASTsequenceN;
import com.paracamplus.ilp2.partiel2020.interfaces.IASTsequenceN;
import com.paracamplus.ilp1.interfaces.IASTexpression;

public class NormalizationFactory
        extends com.paracamplus.ilp2.compiler.normalizer.NormalizationFactory
        implements INormalizationFactory {

    @Override
    public IASTsequenceN newSequenceN(IASTexpression firstExpre, IASTexpression[] expressions) {
        return new ASTsequenceN(firstExpre, expressions);
    }

}
