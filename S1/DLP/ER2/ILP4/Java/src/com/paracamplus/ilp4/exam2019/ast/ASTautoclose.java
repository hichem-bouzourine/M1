/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2019.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp4.exam2019.interfaces.IASTautoclose;
import com.paracamplus.ilp4.exam2019.interfaces.IASTvisitor;

public class ASTautoclose extends ASTexpression
        implements IASTautoclose {

    public ASTautoclose(IASTvariable variable, IASTexpression initialisation, IASTexpression body) {
        this.variable = variable;
        this.initialisation = initialisation;
        this.body = body;
    }

    private final IASTvariable variable;
    private final IASTexpression initialisation;
    private final IASTexpression body;

    @Override
    public IASTvariable getVariable() {
        return variable;
    }

    @Override
    public IASTexpression getInitialisation() {
        return initialisation;
    }

    @Override
    public IASTexpression getBody() {
        return body;
    }

    @Override
    public <Result, Data, Anomaly extends Throwable> Result accept(
            com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
            Data data) throws Anomaly {
        return ((IASTvisitor<Result, Data, Anomaly>) visitor).visit(this, data);
    }
}
