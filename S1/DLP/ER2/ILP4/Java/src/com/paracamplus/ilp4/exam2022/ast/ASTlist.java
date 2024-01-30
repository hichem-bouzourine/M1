package com.paracamplus.ilp4.exam2022.ast;

import org.antlr.v4.runtime.misc.Nullable;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp4.exam2022.interfaces.IASTlist;
import com.paracamplus.ilp4.exam2022.interfaces.IASTvisitor;

public class ASTlist extends ASTexpression implements IASTlist {

    public ASTlist(IASTexpression body,
            IASTvariable var,
            IASTexpression max,
            @Nullable IASTexpression cond) {
        this.body = body;
        this.var = var;
        this.max = max;
        this.cond = cond;
    }

    private final IASTexpression body;
    private final IASTvariable var;
    private final IASTexpression max;
    private final IASTexpression cond;

    @Override
    public IASTexpression getBody() {
        return body;
    }

    @Override
    public IASTvariable getVar() {
        return var;
    }

    @Override
    public IASTexpression getMax() {
        return max;
    }

    @Override
    public IASTexpression getCond() {
        return cond;
    }

    @Override
    public <Result, Data, Anomaly extends Throwable> Result accept(
            com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
            Data data) throws Anomaly {
        return ((IASTvisitor<Result, Data, Anomaly>) visitor).visit(this, data);
    }

}
