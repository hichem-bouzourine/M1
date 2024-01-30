/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2017.interfaces;

public interface IASTvisitor<Result, Data, Anomaly extends Throwable>
        extends com.paracamplus.ilp2.interfaces.IASTvisitor<Result, Data, Anomaly> {

    Result visit(IASTswitch iast, Data data) throws Anomaly;
}
