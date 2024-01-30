/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2017.ast;

import com.paracamplus.ilp1.annotation.OrNull;
import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.partiel2017.interfaces.IASTswitch;
import com.paracamplus.ilp2.partiel2017.interfaces.IASTvisitor;

public class ASTswitch extends ASTexpression
        implements IASTswitch {

    public ASTswitch(IASTexpression initialCondition, IASTexpression[] conditions, IASTexpression[] evals,
            IASTexpression defaultExpr) {
        this.initialCondition = initialCondition;
        this.conditions = conditions;
        this.evals = evals;
        this.defaultExpr = defaultExpr;
    }

    private final IASTexpression initialCondition;
    private final IASTexpression[] conditions;
    private final IASTexpression[] evals;
    private @OrNull final IASTexpression defaultExpr;

    @Override
    public <Result, Data, Anomaly extends Throwable> Result accept(
            com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
            Data data) throws Anomaly {
        return ((IASTvisitor<Result, Data, Anomaly>) visitor).visit(this, data);
    }

    @Override
    public IASTexpression getInitialCondition() {
        return this.initialCondition;
    }

    @Override
    public IASTexpression[] getConditions() {
        return this.conditions;
    }

    @Override
    public IASTexpression[] getEvals() {
        return this.evals;
    }

    @Override
    @OrNull
    public IASTexpression getDefaultExpr() {
        return this.defaultExpr;
    }
}
