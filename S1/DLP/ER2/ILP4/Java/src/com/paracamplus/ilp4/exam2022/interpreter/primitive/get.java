/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2022.interpreter.primitive;

import java.util.List;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.Primitive;

public class get extends Primitive {

    public get() {
        super("get");
    }

    public int getArity() {
        return 2;
    }

    @Override
    public Object apply(Object o1, Object o2) throws EvaluationException {
        List<Object> list;
        if (o1 instanceof List<?>) {
            list = (List<Object>) o1;
        } else {
            throw new EvaluationException("o1 is not of type List");
        }

        if (o2 instanceof Integer) {
            if ((int) o2 < 0 || (int) o2 > list.size()) {
                throw new EvaluationException("o2 is out of bound");
            }
        } else {
            throw new EvaluationException("o2 is not of type Integer");
        }

        return list.get((int) o2);
    }

}
