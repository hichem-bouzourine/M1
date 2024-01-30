/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2018.interpreter;

import java.util.List;
import java.util.Vector;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.interfaces.IASTsuper;
import com.paracamplus.ilp4.exam2018.interfaces.IASTsuperWithArgs;
import com.paracamplus.ilp4.exam2018.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp4.interpreter.interfaces.IClassEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp4.interpreter.interfaces.IMethod;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp4.interpreter.interfaces.ISuperCallInformation;

public class Interpreter extends com.paracamplus.ilp4.interpreter.Interpreter
        implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment,
            IOperatorEnvironment operatorEnvironment,
            IClassEnvironment classEnvironment) {
        super(globalVariableEnvironment, operatorEnvironment, classEnvironment);
    }

    @Override
    public Object visit(IASTsuper iast, ILexicalEnvironment lexenv)
            throws EvaluationException {
        ISuperCallInformation isci = ((com.paracamplus.ilp4.interpreter.interfaces.ISuperCallLexicalEnvironment) lexenv)
                .getSuperCallInformation();
        IMethod supermethod = isci.getSuperMethod();
        return supermethod.apply(this, isci.getArguments());
    }

    @Override
    public Object visit(IASTsuperWithArgs iast, ILexicalEnvironment data) throws EvaluationException {
        System.out.println(iast.getClass().getName());
        ISuperCallInformation isci = ((com.paracamplus.ilp4.interpreter.interfaces.ISuperCallLexicalEnvironment) data)
                .getSuperCallInformation();
        IMethod supermethod = isci.getSuperMethod();
        List<Object> args = new Vector<Object>();
        args.add(isci.getArguments()[0]);

        for (IASTexpression arg : iast.getArguments()) {
            Object value = arg.accept(this, data);
            args.add(value);
        }
        System.out.println("superArrity " + supermethod.getMethodArity());
        System.out.println("my Arrity " + args.size());
        return supermethod.apply(this, args.toArray());
    }

}
