/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.exam2022.interpreter;

import java.io.Writer;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp4.exam2022.interpreter.primitive.get;

public class GlobalVariableStuff extends com.paracamplus.ilp1.interpreter.GlobalVariableStuff {
  public static void fillGlobalVariables(IGlobalVariableEnvironment env, Writer out) {
    com.paracamplus.ilp4.interpreter.GlobalVariableStuff.fillGlobalVariables(env, out);
    env.addGlobalVariableValue(new get());
  }
}
