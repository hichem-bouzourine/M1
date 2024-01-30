/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.compiler.ast;

import com.paracamplus.ilp1.compiler.ast.ASTCglobalInvocation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvisitable;
import com.paracamplus.ilp2.partiel2016.compiler.interfaces.IASTCglobalInvocationOpt;

public class ASTCglobalInvocationOpt extends ASTCglobalInvocation implements IASTCglobalInvocationOpt, IASTvisitable {

    public ASTCglobalInvocationOpt(IASTexpression function,
            IASTexpression[] arguments,
            IASTblock.IASTbinding[] optionalVars) {
        super(function, arguments);
        this.optionalVars = optionalVars;
    }

    private final IASTblock.IASTbinding[] optionalVars;

    @Override
    public IASTblock.IASTbinding[] getOptionalArgs() {
        return this.optionalVars;
    }

}
