package org.apidl.language;

import java.util.List;

import org.apidl.model.impl.DeclaredInterfaceImpl.AccessType;

public interface StatementGenerator
{
	public String generateNamespaceStatement(String namespace);

	public String generateExternalRequirementStatement(String externalReference);

	public String generateInterfaceDeclarationStatement(AccessType accessType, String name, List<String> inheritedInterfaces);
}