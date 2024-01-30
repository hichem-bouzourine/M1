/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2018.ast;

import com.paracamplus.ilp4.exam2018.interfaces.IASTfactory;
import com.paracamplus.ilp4.exam2018.interfaces.IASTsuperWithArgs;
import com.paracamplus.ilp1.interfaces.IASTexpression;

public class ASTfactory
        extends com.paracamplus.ilp4.ast.ASTfactory
        implements IASTfactory {

    @Override
    public IASTsuperWithArgs newSuperWithArgs(IASTexpression[] args) {
        return new ASTsuperWithArgs(args);
    }
}
