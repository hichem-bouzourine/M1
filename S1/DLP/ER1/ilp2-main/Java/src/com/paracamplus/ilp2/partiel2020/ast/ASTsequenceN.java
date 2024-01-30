package com.paracamplus.ilp2.partiel2020.ast;

import com.paracamplus.ilp1.ast.ASTsequence;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.partiel2020.interfaces.IASTsequenceN;

public class ASTsequenceN extends ASTsequence implements IASTsequenceN {
    public ASTsequenceN(IASTexpression firstExpr, IASTexpression[] expressions) {
        super(expressions);
        this.firstExpr = firstExpr;
    }

    protected IASTexpression firstExpr;

    @Override
    public IASTexpression getFirstExpr() {
        return firstExpr;
    }

    @Override
    public <Result, Data, Anomaly extends Throwable> Result accept(
            com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor, Data data) throws Anomaly {
        return ((com.paracamplus.ilp2.partiel2020.interfaces.IASTvisitor<Result, Data, Anomaly>) visitor).visit(this,
                data);
    }

}
