/* *****************************************************************
 * ilp2 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp2
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2018.compiler.normalizer;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.compiler.normalizer.NormalizationEnvironment;
import com.paracamplus.ilp2.compiler.interfaces.IASTCfunctionDefinition;
import com.paracamplus.ilp2.compiler.interfaces.IASTCglobalFunctionVariable;
import com.paracamplus.ilp2.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.partiel2018.compiler.interfaces.IASTCcountingFunctionDefinition;
import com.paracamplus.ilp2.partiel2018.interfaces.IASTcountingFunctionDefinition;

public class Normalizer extends com.paracamplus.ilp2.compiler.normalizer.Normalizer {

    public Normalizer(INormalizationFactory factory) {
        super(factory);
    }

    public IASTCprogram transform(IASTprogram program) throws CompilationException {
        INormalizationEnvironment env = NormalizationEnvironment.EMPTY;
        IASTfunctionDefinition[] functions = program.getFunctionDefinitions();
        IASTCfunctionDefinition[] funs = new IASTCfunctionDefinition[functions.length];
        for (IASTfunctionDefinition function : functions) {
            IASTCglobalFunctionVariable gfv = ((INormalizationFactory) factory)
                    .newGlobalFunctionVariable(function.getName());
            env = env.extend(gfv, gfv);
        }
        for (int i = 0; i < functions.length; i++) {
            IASTfunctionDefinition function = functions[i];
            IASTCcountingFunctionDefinition newfunction = (IASTCcountingFunctionDefinition) visit(function, env);
            funs[i] = newfunction;
        }

        IASTexpression body = program.getBody();
        IASTexpression newbody = body.accept(this, env);
        return ((INormalizationFactory) factory).newProgram(funs, newbody);
    }

    public IASTCfunctionDefinition visit(IASTfunctionDefinition iast, INormalizationEnvironment env)
            throws CompilationException {
        String functionName = iast.getName();
        IASTvariable[] variables = iast.getVariables();
        IASTvariable[] newvariables = new IASTvariable[variables.length];
        INormalizationEnvironment newenv = env;
        for (int i = 0; i < variables.length; i++) {
            IASTvariable variable = variables[i];
            IASTvariable newvariable = factory.newLocalVariable(variable.getName());
            newvariables[i] = newvariable;
            newenv = newenv.extend(variable, newvariable);
        }
        IASTexpression newbody = iast.getBody().accept(this, newenv);

        IASTvariable functionVariable = ((INormalizationFactory) factory).newGlobalFunctionVariable(functionName);

        if (!(iast instanceof IASTcountingFunctionDefinition))
            throw new CompilationException("...");
        boolean counting = ((IASTcountingFunctionDefinition) iast).isCounting();
        return ((INormalizationFactory) factory).newCountingFunctionDefinition(counting, functionVariable, newvariables,
                newbody);

    }

}
