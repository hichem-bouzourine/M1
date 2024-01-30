/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2016.interpreter;

import java.util.List;
import java.util.Vector;

import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.partiel2016.ast.ASTfunctionDefinitionOpt;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.partiel2016.interfaces.IASTinvocationOpt;
import com.paracamplus.ilp2.partiel2016.interfaces.IASTvisitor;
import com.paracamplus.ilp2.partiel2016.interpreter.interfaces.IFunction;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interpreter.EmptyLexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.Invocable;

public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter
        implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

    //

    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment,
            IOperatorEnvironment operatorEnvironment) {
        super(globalVariableEnvironment, operatorEnvironment);
    }

    public Object visit(IASTprogram iast, ILexicalEnvironment lexenv)
            throws EvaluationException {
        for (IASTfunctionDefinition fd : iast.getFunctionDefinitions()) {
            Object f = this.visit((com.paracamplus.ilp2.partiel2016.interfaces.IASTfunctionDefinitionOpt) fd, lexenv);
            String v = fd.getName();
            getGlobalVariableEnvironment().addGlobalVariableValue(v, f);
        }
        try {
            return iast.getBody().accept(this, lexenv);
        } catch (Exception exc) {
            return exc;
        }
    }

    //

    public Invocable visit(ASTfunctionDefinitionOpt iast, ILexicalEnvironment lexenv) throws EvaluationException {
        boolean opt = iast.isOptionalVars();
        Invocable fun;
        if (opt == true) {
            fun = new Function(iast.getVariables(),
                    iast.getBody(),
                    new EmptyLexicalEnvironment(),
                    iast.getOptionalVars());
        } else {
            fun = new com.paracamplus.ilp1.interpreter.Function(iast.getVariables(),
                    iast.getBody(),
                    new EmptyLexicalEnvironment());
        }
        return fun;
    }

    @Override
    public Object visit(IASTinvocationOpt iast, ILexicalEnvironment lexenv) throws EvaluationException {
        Object function = iast.getFunction().accept(this, lexenv);

        List<Object> args = new Vector<Object>();
        for (IASTexpression arg : iast.getArguments()) {
            Object value = arg.accept(this, lexenv);
            args.add(value);
        }

        if (function instanceof IFunction) {
            IFunction f = (IFunction) function;

            IASTblock.IASTbinding[] bindings = iast.getOptionalArgs();

            return f.apply(this, args.toArray(), bindings);
        }

        if (function instanceof Invocable) {
            Invocable f = (Invocable) function;

            return f.apply(this, args.toArray());
        } else {
            String msg = "Cannot apply " + function;
            throw new EvaluationException(msg);
        }
    }

}
