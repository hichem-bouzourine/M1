/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2021.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.exam2021.interfaces.IASTtag;
import com.paracamplus.ilp4.exam2021.interfaces.IASTvisitor;

public class ASTtag extends ASTexpression
        implements IASTtag {

    public ASTtag(String tag, IASTexpression[] arguments) {
        this.tag = tag;
        this.arguments = arguments;
    }

    private final String tag;
    private final IASTexpression[] arguments;

    @Override
    public String getTag() {
        return tag;
    }

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
