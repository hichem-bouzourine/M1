/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2021.interpreter;

import java.math.BigInteger;

import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp2.partiel2021.interpreter.interfaces.ILexicalEnvironment;

public class LexicalEnvironmentRange extends com.paracamplus.ilp1.interpreter.LexicalEnvironment
        implements com.paracamplus.ilp2.partiel2021.interpreter.interfaces.ILexicalEnvironment {

    public LexicalEnvironmentRange(IASTvariable variable, Object low, Object high, Object value,
            ILexicalEnvironment next) throws EvaluationException {
        super(variable, value, next);
        if (!(low instanceof BigInteger && high instanceof BigInteger))
            throw new EvaluationException("Bounds must be integer values");
        this.low = (BigInteger) low;
        this.high = (BigInteger) high;
        if (this.low.compareTo(this.high) > 0)
            throw new EvaluationException("Low bound must be smaller than high bound");
        updateValueBounded(value);
    }

    public void updateValueBounded(Object v) throws EvaluationException {
        if (!(v instanceof BigInteger))
            throw new EvaluationException("Bounded variables must have integer values");
        BigInteger i = (BigInteger) v;
        super.updateValue(i.max(low).min(high));
    }

    @Override
    public void update(IASTvariable key, Object value) throws EvaluationException {
        if (key.getName().equals(getKey().getName()))
            updateValueBounded(value);
        else
            getNext().update(key, value);
    }

    private BigInteger low, high;

    @Override
    public BigInteger getLow() {
        return low;
    }

    @Override
    public BigInteger getHigh() {
        return high;
    }

}
