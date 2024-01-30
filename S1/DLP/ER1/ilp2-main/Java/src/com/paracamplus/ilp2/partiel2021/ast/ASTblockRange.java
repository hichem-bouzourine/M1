package com.paracamplus.ilp2.partiel2021.ast;

import com.paracamplus.ilp1.ast.ASTblock;
import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.partiel2021.interfaces.IASTblockRange;

public class ASTblockRange extends ASTexpression implements IASTblockRange {

    public static class ASTrangeBinding extends ASTblock.ASTbinding implements IASTblockRange.IASTrangeBinding {
        public ASTrangeBinding(IASTvariable variable, IASTexpression initialisation, IASTexpression low,
                IASTexpression high) {
            super(variable, initialisation);
            this.low = low;
            this.high = high;
        }

        private final IASTexpression low;
        private final IASTexpression high;

        @Override
        public IASTexpression getLow() {
            return low;
        }

        @Override
        public IASTexpression gethigh() {
            return high;
        }
    }

    public ASTblockRange(IASTblockRange.IASTrangeBinding[] binding, IASTexpression body) {
        this.binding = binding;
        this.body = body;
    }

    private final IASTblockRange.IASTrangeBinding[] binding;
    private final IASTexpression body;

    @Override
    public IASTblockRange.IASTrangeBinding[] getBindings() {
        return binding;
    }

    @Override
    public IASTexpression getBody() {
        return body;
    }

    @Override
    public <Result, Data, Anomaly extends Throwable> Result accept(
            com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
            Data data) throws Anomaly {
        return ((com.paracamplus.ilp2.partiel2021.interfaces.IASTvisitor<Result, Data, Anomaly>) visitor).visit(this,
                data);
    }
}
