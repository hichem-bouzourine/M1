package com.paracamplus.ilp2.partiel2021.interfaces;

import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTblockRange extends IASTexpression {

    interface IASTrangeBinding extends IASTblock.IASTbinding {
        IASTexpression getLow();

        IASTexpression gethigh();
    }

    IASTrangeBinding[] getBindings();

    IASTexpression getBody();
}
