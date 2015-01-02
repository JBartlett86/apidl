package org.apidl.language.java;

import org.apidl.model.DeclaredInterface;
import org.apidl.model.impl.DeclaredInterfaceImpl;
import org.apidl.model.impl.DeclaredMethodImpl;
import org.apidl.model.impl.DeclaredMethodParameterImpl;
import org.apidl.model.impl.RestrictionImpl;
import org.apidl.model.impl.TypeImpl;
import org.apidl.model.impl.DeclaredInterfaceImpl.AccessType;
import org.apidl.model.Restriction;
import org.junit.Test;

public class JavaSourceWriterTests {
	
	@Test
	public void testCreateInterfaceDeclarationStatement() {

		DeclaredMethodImpl helloWorldMethod = new DeclaredMethodImpl("helloWorld");
		DeclaredMethodParameterImpl param = new DeclaredMethodParameterImpl();
		param.setName("message");
		param.setType(new TypeImpl("String"));
		helloWorldMethod.addParameter(param);

		DeclaredInterface declaredInterface = new DeclaredInterfaceImpl();
		declaredInterface.setType(AccessType.PUBLIC);
		declaredInterface.setName("TestInterface");
		declaredInterface.addMethod(helloWorldMethod);

		Restriction javaRestriction = new RestrictionImpl("Java");
		javaRestriction.setOperator(">=");
		javaRestriction.setVersion("1.6");
		
		JavaSourceWriter writer = new JavaSourceWriter(javaRestriction);


//		String statementString = "public interface TestInterface \n{";
//		String interfaceDeclarationStatement = writer.createInterfaceDeclarationStatement(declaredInterface);
//		assertEquals(statementString,interfaceDeclarationStatement);
	}
}