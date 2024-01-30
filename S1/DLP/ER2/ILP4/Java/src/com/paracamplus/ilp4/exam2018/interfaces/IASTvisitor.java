/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2018.interfaces;

public interface IASTvisitor<Result, Data, Anomaly extends Throwable>
        extends com.paracamplus.ilp4.interfaces.IASTvisitor<Result, Data, Anomaly> {

    Result visit(IASTsuperWithArgs iast, Data data) throws Anomaly;

}
