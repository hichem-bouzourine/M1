/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2018.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.ast.ASTsuper;
import com.paracamplus.ilp4.exam2018.interfaces.IASTsuperWithArgs;
import com.paracamplus.ilp4.exam2018.interfaces.IASTvisitor;

public class ASTsuperWithArgs extends ASTsuper implements IASTsuperWithArgs {

    public ASTsuperWithArgs(IASTexpression[] args) {
        this.arguments = args;
    }

    IASTexpression[] arguments;

    @Override
    public IASTexpression[] getArguments() {
        return arguments;
    }

    @Override
    public <Result, Data, Anomaly extends Throwable> Result accept(
            com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
            Data data) throws Anomaly {
        return ((IASTvisitor<Result, Data, Anomaly>) visitor).visit(this, data);
    }
}
