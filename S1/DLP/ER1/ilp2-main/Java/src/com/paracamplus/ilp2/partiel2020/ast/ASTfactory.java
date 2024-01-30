/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2020.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.partiel2020.interfaces.IASTsequenceN;

public class ASTfactory extends com.paracamplus.ilp2.ast.ASTfactory
        implements com.paracamplus.ilp2.partiel2020.interfaces.IASTfactory {

    @Override
    public IASTsequenceN newSequenceN(IASTexpression firstExpr, IASTexpression[] expressions) {
        return new ASTsequenceN(firstExpr, expressions);
    }

}
