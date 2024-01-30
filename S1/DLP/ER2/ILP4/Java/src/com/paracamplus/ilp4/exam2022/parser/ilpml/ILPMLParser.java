package com.paracamplus.ilp4.exam2022.parser.ilpml;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr4.ILPgrammarExam2021Lexer;
import antlr4.ILPgrammarExam2021Parser;

import com.paracamplus.ilp4.exam2022.interfaces.IASTfactory;
import com.paracamplus.ilp4.interfaces.IASTprogram;
import com.paracamplus.ilp1.parser.ParseException;

public class ILPMLParser
		extends com.paracamplus.ilp4.parser.ilpml.ILPMLParser {

	public ILPMLParser(IASTfactory factory) {
		super(factory);
	}

	@Override
	public IASTprogram getProgram() throws ParseException {
		try {
			ANTLRInputStream in = new ANTLRInputStream(input.getText());
			// flux de caractères -> analyseur lexical
			ILPgrammarExam2021Lexer lexer = new ILPgrammarExam2021Lexer(in);
			// analyseur lexical -> flux de tokens
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			// flux tokens -> analyseur syntaxique
			ILPgrammarExam2021Parser parser = new ILPgrammarExam2021Parser(tokens);
			// démarage de l'analyse syntaxique
			ILPgrammarExam2021Parser.ProgContext tree = parser.prog();
			// parcours de l'arbre syntaxique et appels du Listener
			ParseTreeWalker walker = new ParseTreeWalker();
			ILPMLListener extractor = new ILPMLListener((IASTfactory) factory);
			walker.walk(extractor, tree);
			return tree.node;
		} catch (Exception e) {
			throw new ParseException(e);
		}
	}

}
