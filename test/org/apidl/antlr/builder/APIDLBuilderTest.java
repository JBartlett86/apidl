package org.apidl.antlr.builder;

import static org.junit.Assert.*;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.apidl.builder.DeclaredInterfaceBuilder;
import org.apidl.builder.impl.DeclaredInterfaceBuilderImpl;
import org.apidl.model.DeclaredInterface;
import org.apidl.model.impl.DeclaredInterfaceImpl.AccessType;
import org.apidl.model.DeclaredMethod;
import org.apidl.model.DeclaredMethodParameter;
import org.apidl.model.DeclaredNamespace;
import org.apidl.model.DeclaredRequire;
import org.apidl.model.Restriction;
import org.junit.Test;

public class APIDLBuilderTest {

	private DeclaredInterfaceBuilder declaredInterfaceBuilder = new DeclaredInterfaceBuilderImpl();
	
	@Test
	public void testDeclaredMethod() throws Exception {
		CharStream cs = new ANTLRFileStream(
				"common/definitions/DeclaredMethod.apidl");
		DeclaredInterface dInterface = declaredInterfaceBuilder.build(cs);
		assertNotNull(dInterface);
		
		// validate namespaces
		assertEquals(2, dInterface.getNamespaces().size());
		DeclaredNamespace ns = dInterface.getNamespaces().get(0);
	    assertEquals("org.apidl.model", ns.getName());
	    assertEquals(2, ns.getRestrictions().size());
	    Restriction r1 = ns.getRestrictions().get(0);
	    assertEquals("java", r1.getPlatform());
	    Restriction r2 = ns.getRestrictions().get(1);
	    assertEquals("C", r2.getPlatform());
	    assertEquals(">", r2.getOperator());
	    assertEquals("1.3", r2.getVersion());
	    
	    // validate requires
	    assertEquals(1, dInterface.getRequires().size());
	    DeclaredRequire require = dInterface.getRequires().get(0);
	    assertEquals("com.home.info", require.getName());
	    assertEquals(1, require.getRestrictions().size());
	    Restriction res = require.getRestrictions().get(0);
	    assertEquals("java", res.getPlatform());
	    
	    assertEquals(AccessType.PUBLIC, dInterface.getType());
	    assertEquals("DeclaredInterface", dInterface.getName());
	    
	    // validate 2 methods with varying contents
	    assertEquals(12, dInterface.getMethods().size());
	    
	    // method DeclaredMethod(String name) for Java or C;
	    DeclaredMethod method1 = dInterface.getMethods().get(0);
	    assertEquals("DeclaredMethod", method1.getName());
	    assertEquals(1, method1.getParameters().size());
	    DeclaredMethodParameter param = method1.getParameters().get(0);
	    assertEquals("name", param.getName());
	    assertEquals("String", param.getType().getName());
	    assertNull(param.getType().getGenericType());
	    assertEquals(2, method1.getRestrictions().size());
	    assertEquals("java", method1.getRestrictions().get(0).getPlatform());
	    assertEquals("C", method1.getRestrictions().get(1).getPlatform());
	    
	    // method DeclaredMethod(String name, List<DeclaredMethodParameter> parameters) for Java;
	    DeclaredMethod method2 = dInterface.getMethods().get(1);
	    assertEquals("DeclaredMethod", method2.getName());
	    assertEquals(2, method2.getParameters().size());
	    DeclaredMethodParameter param1 = method2.getParameters().get(0);
	    assertEquals("name", param1.getName());
	    assertEquals("String", param1.getType().getName());
	    assertNull(param1.getType().getGenericType());
	    DeclaredMethodParameter param2 = method2.getParameters().get(1);
	    assertEquals("parameters", param2.getName());
	    assertEquals("List", param2.getType().getName());
	    assertEquals("DeclaredMethodParameter", param2.getType().getGenericType());
	    assertEquals(1, method2.getRestrictions().size());
	    assertEquals("java", method2.getRestrictions().get(0).getPlatform());
	    
	    
	}
	
}
