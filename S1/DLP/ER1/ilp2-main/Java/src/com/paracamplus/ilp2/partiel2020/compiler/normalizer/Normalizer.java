/* *****************************************************************
 * ilp2 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp2
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2020.compiler.normalizer;

import java.math.BigInteger;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.partiel2020.interfaces.IASTsequenceN;

public class Normalizer
        extends com.paracamplus.ilp2.compiler.normalizer.Normalizer
        implements
        com.paracamplus.ilp2.partiel2020.interfaces.IASTvisitor<IASTexpression, INormalizationEnvironment, CompilationException> {

    public Normalizer(INormalizationFactory factory) {
        super(factory);
    }

    @Override
    public IASTexpression visit(IASTsequenceN iast, INormalizationEnvironment data) throws CompilationException {
        IASTexpression firstExpr = (IASTexpression) iast.getFirstExpr().accept(this, data);

        if (!(firstExpr instanceof BigInteger)) {
            throw new CompilationException("firstExpr is not a number");
        }
        int n = ((BigInteger) firstExpr).intValue();

        return iast.getExpressions()[n].accept(this, data);
    }

}
