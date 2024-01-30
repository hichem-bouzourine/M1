package com.paracamplus.ilp2.partiel2017.parser.ilpml;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr4.ILPMLgrammar2017Lexer;
import antlr4.ILPMLgrammar2017Parser;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.partiel2017.interfaces.IASTfactory;
import com.paracamplus.ilp1.parser.ParseException;

public class ILPMLParser
		extends com.paracamplus.ilp2.parser.ilpml.ILPMLParser {

	public ILPMLParser(IASTfactory factory) {
		super(factory);
	}

	@Override
	public IASTprogram getProgram() throws ParseException {
		try {
			ANTLRInputStream in = new ANTLRInputStream(input.getText());
			// flux de caractères -> analyseur lexical
			ILPMLgrammar2017Lexer lexer = new ILPMLgrammar2017Lexer(in);
			// analyseur lexical -> flux de tokens
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			// flux tokens -> analyseur syntaxique
			ILPMLgrammar2017Parser parser = new ILPMLgrammar2017Parser(tokens);
			// démarage de l'analyse syntaxique
			ILPMLgrammar2017Parser.ProgContext tree = parser.prog();
			// parcours de l'arbre syntaxique et appels du Listener
			ParseTreeWalker walker = new ParseTreeWalker();
			ILPMLListener extractor = new ILPMLListener((IASTfactory) factory);
			walker.walk(extractor, tree);
			ASTtransformSwitch TransformSwitch = new ASTtransformSwitch((IASTfactory) factory);
			IASTprogram program = (IASTprogram) TransformSwitch.visit(tree.node, null);
			return program;
		} catch (Exception e) {
			throw new ParseException(e);
		}
	}

}
