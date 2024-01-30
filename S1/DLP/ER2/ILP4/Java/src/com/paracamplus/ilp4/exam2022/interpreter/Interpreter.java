/* *****************************************************************
 * ilp3 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp3
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2022.interpreter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp3.interfaces.IASTlambda;
import com.paracamplus.ilp3.interfaces.IASTprogram;
import com.paracamplus.ilp3.interfaces.IASTtry;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IFunction;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp3.interpreter.primitive.Throw.ThrownException;
import com.paracamplus.ilp4.exam2022.interfaces.IASTlist;
import com.paracamplus.ilp4.exam2022.interfaces.IASTvisitor;
import com.paracamplus.ilp4.interpreter.interfaces.IClassEnvironment;

public class Interpreter extends com.paracamplus.ilp4.interpreter.Interpreter
        implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment, IOperatorEnvironment operatorEnvironment,
            IClassEnvironment classEnvironment) {
        super(globalVariableEnvironment, operatorEnvironment, classEnvironment);
    }

    @Override
    public Object visit(com.paracamplus.ilp1.interfaces.IASTprogram iast, ILexicalEnvironment lexenv)
            throws EvaluationException {
        return visit((IASTprogram) iast, lexenv);
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
        } catch (ThrownException exc) {
            return exc.getThrownValue();
        } catch (Exception exc) {
            return exc;
        }
    }

    @Override
    public Object visit(IASTlist iast, ILexicalEnvironment lexenv) throws EvaluationException {
        Object max = iast.getMax().accept(this, lexenv);

        if (!(max instanceof BigInteger)) {
            throw new EvaluationException("max in not an integer ");
        }
        int maxvalue = ((BigInteger) max).intValue();

        List<Object> list = new ArrayList<Object>();

        ILexicalEnvironment lexenv2 = lexenv;
        IASTvariable var = iast.getVar();
        lexenv2.extend(var, null);

        for (int i = 0; i < maxvalue; i++) {
            lexenv2.update(var, i);
            Object condition = iast.getCond().accept(this, lexenv);
            if (condition != null) { // cond existe
                if (!(condition instanceof Boolean)) { // cond est non boolean donc erreur.
                    throw new EvaluationException("condition is not of type Boolean");
                } else {
                    if (condition == Boolean.FALSE) {
                        return list;
                    } else {
                        Object value = iast.getBody().accept(this, lexenv2);
                        list.add(value);
                    }
                }
            } // cond absente
            else {
                Object value = iast.getBody().accept(this, lexenv2);
                list.add(value);
            }

        }

        return list;
    }
}
