/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2021.compiler;

import java.util.Set;

import com.paracamplus.ilp4.compiler.interfaces.IASTCinstantiation;
import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTClocalVariable;
import com.paracamplus.ilp4.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp4.compiler.interfaces.IASTCvisitor;
import com.paracamplus.ilp4.exam2021.interfaces.IASTmatchWith;
import com.paracamplus.ilp4.exam2021.interfaces.IASTtag;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp4.interfaces.IASTinstantiation;

public class FreeVariableCollector
        extends com.paracamplus.ilp4.compiler.FreeVariableCollector
        implements IASTCvisitor<Void, Set<IASTClocalVariable>, CompilationException> {

    public FreeVariableCollector(IASTCprogram program) {
        super(program);
    }

    public Void visit(IASTmatchWith iast, Set<IASTClocalVariable> variables) throws CompilationException {
        iast.getSomme().accept(this, variables);

        for (IASTvariable var : iast.getVariables()) {
            var.accept(this, variables);
        }

        iast.getConsequence().accept(this, variables);
        iast.getAlternant().accept(this, variables);

        return null;
    }

    public Void visit(IASTCmatchWith iast, Set<IASTClocalVariable> variables) throws CompilationException {
        return visit((IASTmatchWith) iast, variables);
    }

}
