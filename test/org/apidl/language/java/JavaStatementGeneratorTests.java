package org.apidl.language.java;

import static org.junit.Assert.assertEquals;

import org.apidl.model.Restriction;
import org.apidl.model.impl.RestrictionImpl;
import org.junit.Test;

public class JavaStatementGeneratorTests
{
	@Test
	public void testGenerateNamespaceStatement() {
		Restriction java6Restriction = new RestrictionImpl("Java");
		java6Restriction.setVersion("1.6");
		java6Restriction.setOperator(">=");
		
		JavaStatementGenerator statementGenerator = new JavaStatementGenerator(java6Restriction);

		String examplePackageStatement = "package org.apidl.language.java;";
		String generatedPackageStatement = statementGenerator.generateNamespaceStatement("org.apidl.language.java");
		assertEquals(examplePackageStatement, generatedPackageStatement);
	}

	// FIXME: Add more tests here ... a bit late in the day/early in the morning to start now....


}