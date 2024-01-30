/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.compiler;

import java.util.Set;

import com.paracamplus.ilp4.compiler.interfaces.IASTCfieldRead;
import com.paracamplus.ilp4.compiler.interfaces.IASTCfieldWrite;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalVariable;
import com.paracamplus.ilp4.compiler.interfaces.IASTCinstantiation;
import com.paracamplus.ilp4.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp4.compiler.interfaces.IASTCvisitor;
import com.paracamplus.ilp4.exam2021.interfaces.IASTmatchWith;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.interfaces.IASTfieldRead;
import com.paracamplus.ilp4.interfaces.IASTfieldWrite;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp4.interfaces.IASTinstantiation;
import com.paracamplus.ilp4.interfaces.IASTself;
import com.paracamplus.ilp4.interfaces.IASTsend;
import com.paracamplus.ilp4.interfaces.IASTsuper;
import com.paracamplus.ilp1.compiler.CompilationException;

public class GlobalVariableCollector
        extends com.paracamplus.ilp4.compiler.GlobalVariableCollector
        implements IASTCvisitor<Set<IASTCglobalVariable>, Set<IASTCglobalVariable>, CompilationException> {

    @Override
    public Set<IASTCglobalVariable> visit(IASTmatchWith iast, Set<IASTCglobalVariable> result)
            throws CompilationException {
        if (iast instanceof IASTCmatchWith) {
            return visit((IASTCmatchWith) iast, result);
        } else {
            throw new CompilationException("should not occur");
        }
    }

    public Set<IASTCglobalVariable> visit(IASTCmatchWith iast, Set<IASTCglobalVariable> result)
            throws CompilationException {
        result = iast.getSomme().accept(this, result);
        result = iast.getConsequence().accept(this, result);
        result = iast.getAlternant().accept(this, result);

        return result;
    }

}
