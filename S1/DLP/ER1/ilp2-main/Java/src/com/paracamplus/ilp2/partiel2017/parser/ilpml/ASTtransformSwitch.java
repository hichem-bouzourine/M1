package com.paracamplus.ilp2.partiel2017.parser.ilpml;

import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp2.interfaces.IASTassignment;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTloop;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.partiel2017.interfaces.IASTfactory;
import com.paracamplus.ilp2.partiel2017.interfaces.IASTswitch;
import com.paracamplus.ilp2.partiel2017.interfaces.IASTvisitor;

public class ASTtransformSwitch implements IASTvisitor<IASTexpression, Void, EvaluationException> {

    public ASTtransformSwitch(IASTfactory factory) {
        this.factory = factory;
    }

    private final IASTfactory factory;

    public IASTprogram visit(IASTprogram iast, Void data) throws EvaluationException {

        IASTfunctionDefinition[] functions = new IASTfunctionDefinition[iast.getFunctionDefinitions().length];
        int i = 0;
        for (IASTfunctionDefinition fd : iast.getFunctionDefinitions()) {
            functions[i] = (IASTfunctionDefinition) this.visit(fd, data);
            i++;
        }
        return factory.newProgram(
                functions,
                iast.getBody().accept(this, data));
    }

    public Object visit(IASTfunctionDefinition iast, Void data) throws EvaluationException {

        IASTvariable[] oldVars = iast.getVariables();
        IASTvariable[] newVars = new IASTvariable[oldVars.length];

        for (int i = 0; i < oldVars.length; i++) {
            newVars[i] = (IASTvariable) oldVars[i].accept(this, data);
        }

        return factory.newFunctionDefinition(
                iast.getFunctionVariable(),
                newVars,
                iast.getBody().accept(this, data));
    }

    @Override
    public IASTexpression visit(IASTalternative node, Void data) throws EvaluationException {
        return factory.newAlternative(
                node.getCondition().accept(this, data),
                node.getConsequence().accept(this, data),
                (node.getAlternant() == null ? null : node.getConsequence().accept(this, data)));
    }

    @Override
    public IASTexpression visit(IASTswitch iast, Void data) throws EvaluationException {
        // return factory.newAlternative(
        // iast.getInitialCondition().accept(this, data)

        // )
        return iast.getDefaultExpr();
    }

    @Override
    public IASTexpression visit(IASTassignment iast, Void data) throws EvaluationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public IASTexpression visit(IASTloop iast, Void data) throws EvaluationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public IASTexpression visit(IASTbinaryOperation iast, Void data) throws EvaluationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public IASTexpression visit(IASTblock iast, Void data) throws EvaluationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public IASTexpression visit(IASTboolean iast, Void data) throws EvaluationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public IASTexpression visit(IASTfloat iast, Void data) throws EvaluationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public IASTexpression visit(IASTinteger iast, Void data) throws EvaluationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public IASTexpression visit(IASTinvocation iast, Void data) throws EvaluationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public IASTexpression visit(IASTsequence iast, Void data) throws EvaluationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public IASTexpression visit(IASTstring iast, Void data) throws EvaluationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public IASTexpression visit(IASTunaryOperation iast, Void data) throws EvaluationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public IASTexpression visit(IASTvariable iast, Void data) throws EvaluationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

}
