/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2022.compiler.ast;

import com.paracamplus.ilp1.compiler.ast.ASTCglobalVariable;
import com.paracamplus.ilp1.compiler.interfaces.IASTClocalVariable;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.exam2022.ast.ASTlist;
import com.paracamplus.ilp4.exam2022.compiler.interfaces.IASTClist;

public class ASTClist extends ASTlist implements IASTClist {

    public ASTClist(IASTexpression body, ASTCglobalVariable variable, IASTexpression max, IASTexpression cond) {
        super(body, variable, max, cond);
    }

    // visitor

    @Override
    public IASTClocalVariable getVariable() {
        return (IASTClocalVariable) super.getVar();
    }
}
