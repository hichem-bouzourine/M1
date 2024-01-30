/* *****************************************************************
 * ilp4 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp4
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2019.compiler.normalizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.compiler.normalizer.NormalizationEnvironment;
import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp4.compiler.interfaces.IASTCclassDefinition;
import com.paracamplus.ilp2.compiler.interfaces.IASTCfunctionDefinition;
import com.paracamplus.ilp2.compiler.interfaces.IASTCglobalFunctionVariable;
import com.paracamplus.ilp4.compiler.interfaces.IASTCmethodDefinition;
import com.paracamplus.ilp4.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp4.exam2019.interfaces.IASTautoclose;
import com.paracamplus.ilp4.exam2019.interfaces.IASTvisitor;
import com.paracamplus.ilp4.interfaces.IASTclassDefinition;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.interfaces.IASTfieldRead;
import com.paracamplus.ilp4.interfaces.IASTfieldWrite;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp4.interfaces.IASTinstantiation;
import com.paracamplus.ilp4.interfaces.IASTmethodDefinition;
import com.paracamplus.ilp4.interfaces.IASTprogram;
import com.paracamplus.ilp4.interfaces.IASTself;
import com.paracamplus.ilp4.interfaces.IASTsend;
import com.paracamplus.ilp4.interfaces.IASTsuper;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public class Normalizer
        extends com.paracamplus.ilp4.compiler.normalizer.Normalizer
        implements
        IASTvisitor<IASTexpression, INormalizationEnvironment, CompilationException> {

    public Normalizer(INormalizationFactory factory, IASTCclassDefinition objectClass) {
        super(factory);
    }

    @Override
    public IASTexpression visit(IASTautoclose iast, INormalizationEnvironment env) throws CompilationException {
        IASTexpression newExpr = iast.getInitialisation().accept(this, env);
        IASTvariable var = iast.getVariable();
        IASTexpression newBody = iast.getBody().accept(this, env);
        return ((INormalizationFactory) factory).newAutoclose(
                var,
                newExpr,
                iast.getBody());

    }
}
