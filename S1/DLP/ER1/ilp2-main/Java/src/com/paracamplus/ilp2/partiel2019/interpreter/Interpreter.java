/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2019.interpreter;

import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.partiel2019.interfaces.IASTfreeze;
import com.paracamplus.ilp2.partiel2019.interfaces.IASTfrozen;
import com.paracamplus.ilp2.partiel2019.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interpreter.EmptyLexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;

public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter
        implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment, IOperatorEnvironment operatorEnvironment) {
        super(globalVariableEnvironment, operatorEnvironment);
    }

    public Object visit(IASTprogram iast, ILexicalEnvironment lexenv)
            throws EvaluationException {
        for (IASTfunctionDefinition fd : iast.getFunctionDefinitions()) {
            Object f = this.visit(fd, lexenv);
            String v = fd.getName();
            getGlobalVariableEnvironment().addGlobalVariableValue(v, f);
        }
        try {
            return iast.getBody().accept(this, lexenv);
        } catch (Exception exc) {
            return exc;
        }
    }

    public Function visit(IASTfunctionDefinition iast, ILexicalEnvironment lexenv)
            throws EvaluationException {
        Function fun = new Function(iast.getVariables(),
                iast.getBody(),
                new EmptyLexicalEnvironment());
        return fun;
    }

    // freeze prend une fonction et un ensemble d’arguments et invoque la fonction
    // avec les arguments puis stocke le résultat en interne.
    @Override
    public Object visit(IASTfreeze iast, ILexicalEnvironment data) throws EvaluationException {
        Object fun = visit((IASTinvocation) iast, data); // Resultat
        Function function = (Function) iast.getFunction().accept(this, data); // instance de la fonction
        function.setCache(fun);
        return fun;
    }

    @Override
    public Object visit(IASTfrozen iast, ILexicalEnvironment data) throws EvaluationException {

        Function function = (Function) iast.getFunction().accept(this, data);
        Object result = function.getCache();

        return result;

    }

}
