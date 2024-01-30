/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2022.compiler;

import java.util.Set;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTClocalVariable;
import com.paracamplus.ilp4.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp4.exam2022.compiler.interfaces.IASTClist;
import com.paracamplus.ilp4.exam2022.interfaces.IASTlist;

public class FreeVariableCollector
        extends com.paracamplus.ilp4.compiler.FreeVariableCollector
        implements
        com.paracamplus.ilp4.exam2022.compiler.interfaces.IASTCvisitor<Void, Set<IASTClocalVariable>, CompilationException> {

    public FreeVariableCollector(IASTCprogram program) {
        super(program);
    }

    @Override
    public Void visit(IASTlist iast, Set<IASTClocalVariable> variables) throws CompilationException {
        iast.getBody().accept(this, variables);
        iast.getMax().accept(this, variables);
        iast.getVar().accept(this, variables);
        iast.getCond().accept(this, variables);
        return null;
    }

    @Override
    public Void visit(IASTClist iast, Set<IASTClocalVariable> variables) throws CompilationException {
        return visit((IASTlist) iast, variables);
    }

}
