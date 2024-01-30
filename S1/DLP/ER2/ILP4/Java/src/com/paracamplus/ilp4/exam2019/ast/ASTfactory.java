/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2019.ast;

import com.paracamplus.ilp4.exam2019.interfaces.IASTautoclose;
import com.paracamplus.ilp4.exam2019.interfaces.IASTfactory;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public class ASTfactory
        extends com.paracamplus.ilp4.ast.ASTfactory
        implements IASTfactory {

    @Override
    public IASTautoclose newAutoclose(IASTvariable variable,
            IASTexpression initialisation,
            IASTexpression body) {
        return new ASTautoclose(variable, initialisation, body);
    }

}
