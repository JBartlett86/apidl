package org.apidl.antlr;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.apidl.antlr.APIDLParser.declaration_return;
import org.junit.Test;

public class APIDLParserTest {

	@Test
	public void testDeclaredMethod() throws Exception {
		CharStream cs = new ANTLRFileStream(
				"common/definitions/DeclaredMethod.apidl");
		APIDLLexer lexer = new APIDLLexer(cs);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		APIDLParser parser = new APIDLParser(tokens);
		declaration_return declaration = parser.declaration();
		CommonTree tree = (CommonTree) declaration.getTree();
		assertEquals(4, tree.getChildCount());
	}

	@Test
	public void testDeclaredMethodParameter() throws Exception {
		CharStream cs = new ANTLRFileStream(
				"common/definitions/DeclaredMethodParameter.apidl");
		APIDLLexer lexer = new APIDLLexer(cs);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		APIDLParser parser = new APIDLParser(tokens);
		declaration_return declaration = parser.declaration();
		CommonTree tree = (CommonTree) declaration.getTree();
		assertEquals(2, tree.getChildCount());
	}
}
