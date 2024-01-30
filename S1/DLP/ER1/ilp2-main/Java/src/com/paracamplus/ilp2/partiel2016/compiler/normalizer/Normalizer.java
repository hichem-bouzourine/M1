/* *****************************************************************
 * ilp2 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp2
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.compiler.normalizer;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalVariable;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.compiler.normalizer.NormalizationEnvironment;
import com.paracamplus.ilp2.compiler.interfaces.IASTCfunctionDefinition;
import com.paracamplus.ilp2.compiler.interfaces.IASTCglobalFunctionVariable;
import com.paracamplus.ilp2.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp2.partiel2016.compiler.interfaces.IASTCfunctionDefinitionOpt;
import com.paracamplus.ilp2.partiel2016.interfaces.*;

public class Normalizer
        extends com.paracamplus.ilp2.compiler.normalizer.Normalizer
        implements
        IASTvisitor<IASTexpression, INormalizationEnvironment, CompilationException> {

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
            IASTCfunctionDefinition newfunction = visit((IASTCfunctionDefinitionOpt) function, env);
            funs[i] = newfunction;
        }

        IASTexpression body = program.getBody();
        IASTexpression newbody = body.accept(this, env);
        return ((INormalizationFactory) factory).newProgram(funs, newbody);
    }

    public IASTCfunctionDefinition visit(IASTfunctionDefinitionOpt iast, INormalizationEnvironment env)
            throws CompilationException {
        String functionName = iast.getName();
        IASTvariable functionVariable = ((INormalizationFactory) factory).newGlobalFunctionVariable(functionName);

        boolean isOptionalVars = iast.isOptionalVars();

        IASTvariable[] variables = iast.getVariables();
        IASTvariable[] newvariables = new IASTvariable[variables.length];
        INormalizationEnvironment newenv = env;
        for (int i = 0; i < variables.length; i++) {
            IASTvariable variable = variables[i];
            IASTvariable newvariable = factory.newLocalVariable(variable.getName());
            newvariables[i] = newvariable;
            newenv = newenv.extend(variable, newvariable);
        }

        IASTbinding[] optionalVars = iast.getOptionalVars();

        IASTblock.IASTbinding[] newbindings = new IASTblock.IASTbinding[optionalVars.length];
        for (int i = 0; i < optionalVars.length; i++) {
            IASTbinding binding = optionalVars[i];
            IASTexpression expr = binding.getInitialisation();
            IASTexpression newexpr = expr.accept(this, env);
            IASTvariable variable = binding.getVariable();
            IASTvariable newvariable = factory.newLocalVariable(variable.getName());
            newenv = newenv.extend(variable, newvariable);
            newbindings[i] = factory.newBinding(newvariable, newexpr);
        }

        IASTexpression newbody = iast.getBody().accept(this, newenv);
        return ((INormalizationFactory) factory).newFunctionDefinitionOpt(
                functionVariable, newvariables, isOptionalVars, iast.getOptionalVars(), newbody);
    }

    @Override
    public IASTexpression visit(IASTinvocationOpt iast, INormalizationEnvironment env) throws CompilationException {
        IASTexpression funexpr = iast.getFunction().accept(this, env);
        IASTexpression[] arguments = iast.getArguments();
        IASTexpression[] args = new IASTexpression[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            IASTexpression argument = arguments[i];
            IASTexpression arg = argument.accept(this, env);
            args[i] = arg;
        }

        IASTblock.IASTbinding[] optArgs = iast.getOptionalArgs();
        IASTblock.IASTbinding[] newbindings = new IASTblock.IASTbinding[optArgs.length];
        INormalizationEnvironment newenv = env;
        for (int i = 0; i < optArgs.length; i++) {
            IASTbinding binding = optArgs[i];
            IASTexpression expr = binding.getInitialisation();
            IASTexpression newexpr = expr.accept(this, env);
            IASTvariable variable = binding.getVariable();
            IASTvariable newvariable = factory.newLocalVariable(variable.getName());
            newenv = newenv.extend(variable, newvariable);
            newbindings[i] = factory.newBinding(newvariable, newexpr);
        }

        if (funexpr instanceof IASTCglobalVariable) {
            IASTCglobalVariable f = (IASTCglobalVariable) funexpr;
            return ((INormalizationFactory) factory).newGlobalInvocationOpt(f, args, optArgs);
        } else {
            return ((INormalizationFactory) factory).newComputedInvocation(funexpr, args);
        }
    }

}
