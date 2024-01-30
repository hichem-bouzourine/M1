package com.paracamplus.ilp4.exam2021.interpreter;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.exam2021.interfaces.IASTtag;
import com.paracamplus.ilp4.exam2021.interpreter.interfaces.ISum;

public class Sum implements ISum {

    private String discriminant;
    private IASTexpression[] arguments;

    public Sum(String discriminant, IASTexpression[] arguments) {
        this.discriminant = discriminant;
        this.arguments = arguments;
    }

    public Sum(IASTtag tag) {
        this.discriminant = tag.getTag();
        this.arguments = tag.getArguments();
    }

    @Override
    public String getDiscriminant() {
        return discriminant;
    }

    @Override
    public IASTexpression[] getArguments() {
        return arguments;
    }

}
