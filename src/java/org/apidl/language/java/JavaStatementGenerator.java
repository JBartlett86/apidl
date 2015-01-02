package org.apidl.language.java;

import java.util.List;
import java.util.ListIterator;

import org.apidl.language.StatementGenerator;
import org.apidl.model.impl.DeclaredInterfaceImpl.AccessType;
import org.apidl.model.Restriction;


public class JavaStatementGenerator implements StatementGenerator
{
	// Access Modifier constants
	private static final String ACCESS_MODIFIER_PRIVATE = "private";
	private static final String ACCESS_MODIFIER_PUBLIC = "public";

	// Keyword constants
	private static final String IMPORT_KEYWORD = "import";
	private static final String INTERFACE_KEYWORD = "interface";
	private static final String EXTENDS_KEYWORD = "extends";
	private static final String PACKAGE_KEYWORD = "package";

	// 
	private static final String SEPARATOR = ",";
	private static final String BLOCK_BEGIN_TOKEN = "{";
	private static final String BLOCK_END_TOKEN = "}";
	private static final String STATEMENT_TERMINATOR = ";";

	//
	private static final char WHITESPACE_CHARACTER = ' ';
	private static final char CARRIAGE_RETURN_CHARACTER = '\n';


	private Restriction restriction;


	/**
	 *
	 * @param restriction
	 **/
	public JavaStatementGenerator(Restriction restriction) {
		super();
		this.restriction = restriction;
	}

	/**
	 * 
	 *
	 * @param namespace
	 * @return
	 **/
	public String generateNamespaceStatement(String namespace) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(PACKAGE_KEYWORD);
		buffer.append(WHITESPACE_CHARACTER);
		buffer.append(namespace);
		buffer.append(STATEMENT_TERMINATOR);
		return buffer.toString();
	}

	/**
	 *
	 *
	 * @param externalReference
	 * @return
	 **/
	public String generateExternalRequirementStatement(String externalReference) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(IMPORT_KEYWORD);
		buffer.append(WHITESPACE_CHARACTER);
		buffer.append(externalReference);
		buffer.append(STATEMENT_TERMINATOR);
		return buffer.toString();
	}

	/**
	 *
	 *
	 * @param accessType
	 * @param name
	 * @param inheritedInterfaces
	 * @return 
	 **/
	public String generateInterfaceDeclarationStatement(AccessType accessType, String name, List<String> inheritedInterfaces) {
		StringBuffer buffer = new StringBuffer();

		if (accessType == AccessType.PUBLIC) {
			buffer.append(ACCESS_MODIFIER_PUBLIC);
		} else {
			buffer.append(ACCESS_MODIFIER_PRIVATE);
		}

		buffer.append(WHITESPACE_CHARACTER);
		buffer.append(INTERFACE_KEYWORD);
		buffer.append(WHITESPACE_CHARACTER);
		buffer.append(name);
		buffer.append(WHITESPACE_CHARACTER);

		if (inheritedInterfaces != null && !inheritedInterfaces.isEmpty()) {
			buffer.append(EXTENDS_KEYWORD);
			buffer.append(WHITESPACE_CHARACTER);

			ListIterator<String> parentNamesIterator = inheritedInterfaces.listIterator();
			while (parentNamesIterator.hasNext()) {
				buffer.append(parentNamesIterator.next());
				if (parentNamesIterator.hasNext()) {
					buffer.append(SEPARATOR);
				}
			}
			buffer.append(WHITESPACE_CHARACTER);
		}

		return buffer.toString();
	}
}