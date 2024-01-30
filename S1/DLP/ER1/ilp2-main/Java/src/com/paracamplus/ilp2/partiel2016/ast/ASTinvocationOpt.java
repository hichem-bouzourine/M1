/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.ast;

import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interfaces.IASTvisitor;
import com.paracamplus.ilp2.partiel2016.interfaces.IASTinvocationOpt;

public class ASTinvocationOpt extends com.paracamplus.ilp1.ast.ASTinvocation implements IASTinvocationOpt {

    public ASTinvocationOpt(IASTexpression function, IASTexpression[] arguments, IASTblock.IASTbinding[] optionalVars) {
        super(function, arguments);
        this.optionalVars = optionalVars;
    }

    private final IASTblock.IASTbinding[] optionalVars;

    @Override
    public IASTbinding[] getOptionalArgs() {
        return this.optionalVars;
    }

    @Override
    public <Result, Data, Anomaly extends Throwable> Result accept(IASTvisitor<Result, Data, Anomaly> visitor,
            Data data)
            throws Anomaly {
        return ((com.paracamplus.ilp2.partiel2016.interfaces.IASTvisitor<Result, Data, Anomaly>) visitor).visit(this,
                data);
    }

}
