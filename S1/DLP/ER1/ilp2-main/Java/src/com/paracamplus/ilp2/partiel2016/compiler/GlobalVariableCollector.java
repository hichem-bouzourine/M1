/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.compiler;

import java.util.Set;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalInvocation;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalVariable;
import com.paracamplus.ilp2.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp2.partiel2016.compiler.interfaces.IASTCglobalInvocationOpt;
import com.paracamplus.ilp2.partiel2016.compiler.interfaces.IASTCvisitor;

public class GlobalVariableCollector extends com.paracamplus.ilp2.compiler.GlobalVariableCollector
        implements IASTCvisitor<Set<IASTCglobalVariable>, Set<IASTCglobalVariable>, CompilationException> {

    public Set<IASTCglobalVariable> analyze(IASTCprogram program)
            throws CompilationException {
        for (IASTfunctionDefinition ifd : program.getFunctionDefinitions()) {
            result = ifd.getBody().accept(this, result);
        }
        result = program.getBody().accept(this, result);
        return result;
    }

    @Override
    public Set<IASTCglobalVariable> visit(IASTCglobalInvocation iast, Set<IASTCglobalVariable> result)
            throws CompilationException {
        return visit((IASTinvocation) iast, result);
    }

    @Override
    public Set<IASTCglobalVariable> visit(IASTCglobalInvocationOpt iast, Set<IASTCglobalVariable> result)
            throws CompilationException {
        result = iast.getFunction().accept(this, result);
        IASTexpression[] args = iast.getArguments();
        for (IASTexpression exp : args) {
            result = exp.accept(this, result);
        }
        IASTbinding[] optArgs = iast.getOptionalArgs();
        for (IASTbinding Arg : optArgs) {
            result = Arg.getInitialisation().accept(this, result);
        }

        return result;

    }

}
