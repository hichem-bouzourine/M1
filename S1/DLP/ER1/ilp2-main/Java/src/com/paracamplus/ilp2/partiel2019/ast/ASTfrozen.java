package com.paracamplus.ilp2.partiel2019.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.partiel2019.interfaces.IASTfrozen;
import com.paracamplus.ilp2.partiel2019.interfaces.IASTvisitor;

public class ASTfrozen implements IASTfrozen {

    public ASTfrozen(IASTexpression function) {
        this.function = function;
    }

    private final IASTexpression function;

    @Override
    public IASTexpression getFunction() {
        return function;
    }

    @Override
    public <Result, Data, Anomaly extends Throwable> Result accept(
            com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
            Data data) throws Anomaly {

        return ((IASTvisitor<Result, Data, Anomaly>) visitor).visit(this, data);
    }

}
