/* *****************************************************************
 * ilp3 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp3
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2022.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp4.exam2022.interfaces.IASTfactory;
import com.paracamplus.ilp4.exam2022.interfaces.IASTlist;

public class ASTfactory extends com.paracamplus.ilp4.ast.ASTfactory
        implements IASTfactory {

    @Override
    public IASTlist newList(IASTexpression body, IASTvariable var, IASTexpression max, IASTexpression cond) {
        return new ASTlist(body, var, max, cond);
    }

}
