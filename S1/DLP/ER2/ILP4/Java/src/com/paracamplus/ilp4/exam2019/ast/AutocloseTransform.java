package com.paracamplus.ilp4.exam2019.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public class AutocloseTransform extends ASTautoclose {
    public AutocloseTransform(IASTvariable variable, IASTexpression initialisation, IASTexpression body) {
        super(variable, initialisation, body);
    }

}
