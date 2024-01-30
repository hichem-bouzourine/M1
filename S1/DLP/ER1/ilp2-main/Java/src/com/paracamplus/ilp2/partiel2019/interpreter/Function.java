package com.paracamplus.ilp2.partiel2019.interpreter;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;

public class Function extends com.paracamplus.ilp1.interpreter.Function {

    public Function(IASTvariable[] variables, IASTexpression body, ILexicalEnvironment lexenv) {
        super(variables, body, lexenv);
    }

    private Object cache;

    Object getCache() {
        return this.cache;
    }

    void setCache(Object cache) {
        this.cache = cache;
    }

}
