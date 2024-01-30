/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.compiler;

import java.util.HashSet;
import java.util.Set;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalInvocation;
import com.paracamplus.ilp1.compiler.interfaces.IASTClocalVariable;
import com.paracamplus.ilp2.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp2.partiel2016.compiler.interfaces.IASTCglobalInvocationOpt;
import com.paracamplus.ilp2.partiel2016.compiler.interfaces.IASTCvisitor;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;

public class FreeVariableCollector extends com.paracamplus.ilp2.compiler.FreeVariableCollector
        implements IASTCvisitor<Void, Set<IASTClocalVariable>, CompilationException> {

    public FreeVariableCollector(IASTCprogram program) {
        super(program);
    }

    @Override
    public IASTCprogram analyze()
            throws CompilationException {
        for (IASTfunctionDefinition ifd : ((IASTCprogram) program).getFunctionDefinitions()) {
            Set<IASTClocalVariable> newvars = new HashSet<>();
            visit(ifd, newvars);
        }
        Set<IASTClocalVariable> newvars = new HashSet<>();
        ((IASTCprogram) program).getBody().accept(this, newvars);
        return (IASTCprogram) program;
    }

    @Override
    public Void visit(IASTCglobalInvocation iast, Set<IASTClocalVariable> variables)
            throws CompilationException {
        return visit((IASTinvocation) iast, variables);
    }

    @Override
    public Void visit(IASTCglobalInvocationOpt iast, Set<IASTClocalVariable> variables) throws CompilationException {
        iast.getFunction().accept(this, variables);
        for (IASTexpression expression : iast.getArguments())
            expression.accept(this, variables);

        for (IASTbinding Arg : iast.getOptionalArgs()) {
            Arg.getInitialisation().accept(this, variables);
        }

        return null;
    }

}
