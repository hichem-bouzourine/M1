/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2021.ast;

import com.paracamplus.ilp4.exam2021.interfaces.IASTfactory;
import com.paracamplus.ilp4.exam2021.interfaces.IASTmatchWith;
import com.paracamplus.ilp4.exam2021.interfaces.IASTtag;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public class ASTfactory
        extends com.paracamplus.ilp4.ast.ASTfactory
        implements IASTfactory {

    @Override
    public IASTtag newTag(
            String tag,
            IASTexpression[] arguments) {
        return new ASTtag(tag, arguments);
    }

    @Override
    public IASTmatchWith newMatchWith(IASTexpression somme, String tag, IASTvariable[] variables,
            IASTexpression consequence,
            IASTexpression alternant) {
        return new ASTmatchWith(somme, tag, variables, consequence, alternant);
    }

}
