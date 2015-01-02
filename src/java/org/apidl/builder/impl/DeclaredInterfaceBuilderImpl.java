package org.apidl.builder.impl;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apidl.antlr.APIDLBuilder;
import org.apidl.antlr.APIDLLexer;
import org.apidl.antlr.APIDLParser;
import org.apidl.builder.DeclaredInterfaceBuilder;
import org.apidl.model.DeclaredInterface;

public class DeclaredInterfaceBuilderImpl implements DeclaredInterfaceBuilder {

	public DeclaredInterface build(String fileName) throws Exception {
		return build(new ANTLRFileStream(fileName));
	}

	public DeclaredInterface build(CharStream cs) throws Exception {
		APIDLLexer lexer = new APIDLLexer(cs);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		APIDLParser parser = new APIDLParser(tokens);
		CommonTree tree = (CommonTree) parser.declaration().getTree();
		CommonTreeNodeStream s = new CommonTreeNodeStream(tree);
		APIDLBuilder builder = new APIDLBuilder(s);
		return builder.declaration();
	}
	
}
