/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.partiel2019.interpreter.test;

import java.io.File;
import java.io.StringWriter;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.paracamplus.ilp1.interpreter.GlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.GlobalVariableStuff;
import com.paracamplus.ilp1.interpreter.OperatorEnvironment;
import com.paracamplus.ilp1.interpreter.OperatorStuff;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interpreter.test.InterpreterRunner;
import com.paracamplus.ilp1.parser.xml.IXMLParser;
import com.paracamplus.ilp2.ast.ASTfactory;
import com.paracamplus.ilp2.interfaces.IASTfactory;
import com.paracamplus.ilp2.parser.ilpml.ILPMLParser;
import com.paracamplus.ilp2.parser.xml.XMLParser;
import com.paracamplus.ilp2.partiel2019.interpreter.Interpreter;

@RunWith(Parameterized.class)
public class InterpreterTest extends com.paracamplus.ilp2.interpreter.test.InterpreterTest {

    protected static String[] samplesDirName = { "SamplesPartiel1" };

    public InterpreterTest(File file) {
        super(file);
    }

    public void configureRunner(InterpreterRunner run) throws EvaluationException {
        // configuration du parseur
        IASTfactory factory = new ASTfactory();
        IXMLParser xmlparser = new XMLParser(factory);
        xmlparser.setGrammar(new File(XMLgrammarFile));
        run.setXMLParser(xmlparser);
        run.setILPMLParser(new ILPMLParser(factory));

        // configuration de l'interprète
        StringWriter stdout = new StringWriter();
        run.setStdout(stdout);
        IGlobalVariableEnvironment gve = new GlobalVariableEnvironment();
        GlobalVariableStuff.fillGlobalVariables(gve, stdout);
        IOperatorEnvironment oe = new OperatorEnvironment();
        OperatorStuff.fillUnaryOperators(oe);
        OperatorStuff.fillBinaryOperators(oe);
        Interpreter interpreter = new Interpreter(gve, oe);
        run.setInterpreter(interpreter);
    }

}
