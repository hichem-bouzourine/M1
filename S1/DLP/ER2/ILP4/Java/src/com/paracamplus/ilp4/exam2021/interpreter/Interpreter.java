/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2021.interpreter;

import com.paracamplus.ilp4.exam2021.interfaces.IASTmatchWith;
import com.paracamplus.ilp4.exam2021.interfaces.IASTtag;
import com.paracamplus.ilp4.exam2021.interfaces.IASTvisitor;
import com.paracamplus.ilp4.exam2021.interpreter.interfaces.ISum;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp4.interpreter.interfaces.IClassEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;

public class Interpreter extends com.paracamplus.ilp4.interpreter.Interpreter
        implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment,
            IOperatorEnvironment operatorEnvironment,
            IClassEnvironment classEnvironment) {
        super(globalVariableEnvironment, operatorEnvironment, classEnvironment);
    }

    @Override
    public Object visit(IASTtag iast, ILexicalEnvironment lexenv) throws EvaluationException {
        String tag = iast.getTag();
        IASTexpression[] args = iast.getArguments();
        IASTexpression[] newArgs = new IASTexpression[args.length];
        for (int i = 0; i < args.length; i++)
            newArgs[i] = (IASTexpression) args[i].accept(this, lexenv);

        ISum sum = new Sum(tag, newArgs);

        return sum;
    }

    @Override
    public Object visit(IASTmatchWith iast, ILexicalEnvironment lexenv) throws EvaluationException {
        Object somme = iast.getSomme().accept(this, lexenv);
        if ((somme instanceof IASTtag)) {
            IASTtag castedSum = (IASTtag) somme;
            ISum sumOfMatch = new Sum(castedSum);

            ISum sumOfwith = new Sum(iast.getTag(), iast.getVariables());

            // si expr est bien de type somme avec discriminant tag
            if ((sumOfMatch.equals(sumOfwith))) {
                // then est exécutée
                if (sumOfMatch.getArguments().length < sumOfwith.getArguments().length) {
                    throw new EvaluationException("Il y a moins d'arguments que de variables");
                }

                ILexicalEnvironment lexenv2 = lexenv;
                IASTvariable[] vars = iast.getVariables();
                for (int i = 0; i < vars.length; i++) {
                    Object v = vars[i].accept(this, lexenv2);
                    lexenv2 = lexenv2.extend(vars[i], v);
                }

                return iast.getConsequence().accept(this, lexenv2);
            } else {
                // else est exécutée
                return iast.getAlternant().accept(this, lexenv);
            }
        } else {
            // else est exécutée
            return iast.getAlternant().accept(this, lexenv);
        }
    }

}
