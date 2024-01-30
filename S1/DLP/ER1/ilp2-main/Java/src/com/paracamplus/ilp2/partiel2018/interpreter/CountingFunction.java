package com.paracamplus.ilp2.partiel2018.interpreter;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interpreter.Function;
import com.paracamplus.ilp1.interpreter.Interpreter;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;

public class CountingFunction extends Function {
    public CountingFunction(IASTvariable[] variables,
            IASTexpression body,
            ILexicalEnvironment lexenv) {
        super(variables, body, lexenv);
        this.count = 0;
    }

    private int count;

    public int getCount() {
        return count;
    }

    @Override
    public Object apply(Interpreter interpreter, Object[] argument) throws EvaluationException {
        count++;
        return super.apply(interpreter, argument);
    }
}
