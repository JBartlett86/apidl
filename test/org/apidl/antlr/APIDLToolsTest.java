package org.apidl.antlr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.apidl.ReflectiveDescriptor;
import org.apidl.APIDLTools;
import org.apidl.builder.DeclaredInterfaceBuilder;
import org.apidl.builder.impl.DeclaredInterfaceBuilderImpl;
import org.apidl.language.java.JavaSourceWriter;
import org.apidl.model.DeclaredInterface;
import org.apidl.model.DeclaredMethod;
import org.apidl.model.Restriction;
import org.apidl.model.impl.DeclaredInterfaceImpl;
import org.apidl.model.impl.RestrictionImpl;
import org.junit.Test;

public class APIDLToolsTest {

	private DeclaredInterfaceBuilder declaredInterfaceBuilder = new DeclaredInterfaceBuilderImpl();
	private APIDLTools tools = new APIDLTools();
	
	@Test
	public void testExtractContainedInterfaces() throws Exception {
		
		CharStream cs = new ANTLRFileStream("common/definitions/DeclaredMethod_real.apidl");
		DeclaredInterface dInterface = declaredInterfaceBuilder.build(cs);
		assertNotNull(dInterface);
		
		Map<Restriction, DeclaredInterface> containedInterfaces = tools.extractContainedInterfaces(dInterface);
		assertNotNull(containedInterfaces);
		assertEquals(2, containedInterfaces.size());
		
		Iterator<Restriction> keyRestrictionIterator = containedInterfaces.keySet().iterator();
		
		DeclaredInterface javaInterface = null;
		Restriction javaRestriction = null;
		
		while (keyRestrictionIterator.hasNext()) {
			Restriction restriction = keyRestrictionIterator.next();
			
			if (restriction.getPlatform().equalsIgnoreCase("java")) {
				javaInterface = containedInterfaces.get(restriction);
				javaRestriction = restriction;
			}
			
			System.out.println("\n\nDeclared Interface...("+restriction+")\n");
			tools.write(containedInterfaces.get(restriction), System.out);
		}
		
		assertNotNull(javaInterface);
		
		JavaSourceWriter sourceWriter = new JavaSourceWriter(javaRestriction);
		
		sourceWriter.write(javaInterface, System.out);
	}
	
	@Test
	public void testReflection() {
		ReflectiveDescriptor reflectionTools = new ReflectiveDescriptor();
		for (Method method : DeclaredMethod.class.getMethods()) {
			DeclaredMethod declaredMethod = reflectionTools.describeMethod(method);
			System.out.println("Method = "+declaredMethod.toString());
		}
	}
}
