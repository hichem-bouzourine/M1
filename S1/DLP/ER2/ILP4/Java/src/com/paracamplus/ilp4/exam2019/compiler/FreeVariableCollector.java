/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2019.compiler;

import java.util.HashSet;
import java.util.Set;

import com.paracamplus.ilp4.compiler.interfaces.IASTCfieldRead;
import com.paracamplus.ilp4.compiler.interfaces.IASTCfieldWrite;
import com.paracamplus.ilp4.compiler.interfaces.IASTCinstantiation;
import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTClocalVariable;
import com.paracamplus.ilp4.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp4.exam2019.interfaces.IASTautoclose;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.interfaces.IASTfieldRead;
import com.paracamplus.ilp4.interfaces.IASTfieldWrite;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp4.interfaces.IASTinstantiation;
import com.paracamplus.ilp4.interfaces.IASTself;
import com.paracamplus.ilp4.interfaces.IASTsend;
import com.paracamplus.ilp4.interfaces.IASTsuper;

public class FreeVariableCollector
        extends com.paracamplus.ilp4.compiler.FreeVariableCollector
        implements
        com.paracamplus.ilp4.exam2019.compiler.interfaces.IASTCvisitor<Void, Set<IASTClocalVariable>, CompilationException> {

    public FreeVariableCollector(IASTCprogram program) {
        super(program);
    }

    @Override
    public Void visit(IASTautoclose iast, Set<IASTClocalVariable> variables) throws CompilationException {
        iast.getInitialisation().accept(this, variables);
        iast.getBody().accept(this, variables);
        return null;

    }

    public Void visit(IASTCautoclose iast, Set<IASTClocalVariable> variables) throws CompilationException {
        return visit((IASTautoclose) iast, variables);
    }

}
