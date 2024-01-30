/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2021.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp4.exam2021.interfaces.IASTmatchWith;
import com.paracamplus.ilp4.exam2021.interfaces.IASTvisitor;

public class ASTmatchWith extends ASTexpression
        implements IASTmatchWith {

    public ASTmatchWith(IASTexpression somme, String tag, IASTvariable[] variables, IASTexpression consequence,
            IASTexpression alternant) {
        this.somme = somme;
        this.tag = tag;
        this.variables = variables;
        this.consequence = consequence;
        this.alternant = alternant;
    }

    private final IASTexpression somme;
    private final String tag;
    private final IASTvariable[] variables;
    private final IASTexpression consequence;
    private final IASTexpression alternant;

    @Override
    public IASTexpression getSomme() {
        return this.somme;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public IASTvariable[] getVariables() {
        return this.variables;
    }

    @Override
    public IASTexpression getConsequence() {
        return this.consequence;
    }

    @Override
    public IASTexpression getAlternant() {
        return this.alternant;
    }

    @Override
    public <Result, Data, Anomaly extends Throwable> Result accept(
            com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
            Data data) throws Anomaly {
        return ((IASTvisitor<Result, Data, Anomaly>) visitor).visit(this, data);
    }
}
