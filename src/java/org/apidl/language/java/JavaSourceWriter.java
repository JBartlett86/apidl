package org.apidl.language.java;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.apidl.APIDLTools;
import org.apidl.IllegalDeclarationException;
import org.apidl.language.SourceWriter;
import org.apidl.language.TypeMapper;
import org.apidl.model.DeclaredInterface;
import org.apidl.model.DeclaredMethod;
import org.apidl.model.DeclaredMethodParameter;
import org.apidl.model.DeclaredNamespace;
import org.apidl.model.DeclaredRequire;
import org.apidl.model.Restriction;
import org.apidl.model.impl.DeclaredMethodImpl;
import org.apidl.model.impl.DeclaredRequireImpl;

public class JavaSourceWriter implements SourceWriter
{
	private JavaStatementGenerator statementGenerator;
	private TypeMapper typeMapper;
	private APIDLTools tools;
	private Restriction restriction;
	

	/**
	 * Constructs a new instance of JavaSourceWriter that can be used to express
	 * declared model structures as Java source code.
	 *
	 **/
	public JavaSourceWriter(Restriction restriction) {
		super();
		this.tools = new APIDLTools();
		this.typeMapper = new JavaTypeMapper(restriction);
		this.statementGenerator = new JavaStatementGenerator(restriction);
		this.restriction = restriction;
	}
	
	/**
	 *
	 *
	 * @param declaredInterface
	 * @param outputStream
	 * @throws IOException
	 **/
	public void write(DeclaredInterface declaredInterface, OutputStream outputStream) throws IllegalDeclarationException, IOException {
		List<DeclaredNamespace> namespaces = tools.findNamespace(declaredInterface, restriction);
		
		if (namespaces != null && !namespaces.isEmpty()) {
			if (namespaces.size() > 1) {
				throw new IllegalDeclarationException("Multiple namespaces specified but only one permitted.");
			}
			
			String namespace = namespaces.get(0).getName();
			String namespaceStatement = statementGenerator.generateNamespaceStatement(namespace);
			writeToOutputStream(namespaceStatement,outputStream,true);
		}
		
		List<DeclaredRequire> requiredList = tools.findRequired(declaredInterface, restriction);
		if (requiredList != null && !requiredList.isEmpty()) {
			for (DeclaredRequire requiredListItem : requiredList) {
				String importStatement = statementGenerator.generateExternalRequirementStatement(requiredListItem.getName());
				writeToOutputStream(importStatement, outputStream, true);
			}
		}

		outputStream.write("\n".getBytes());


		String interfaceDeclaration = statementGenerator.generateInterfaceDeclarationStatement(declaredInterface.getType(),
																							   declaredInterface.getName(),
																							   declaredInterface.getParentNames());
		writeToOutputStream(interfaceDeclaration,outputStream,false);
		
		writeToOutputStream("{",outputStream,true);
		
		List<DeclaredMethod> methodList = declaredInterface.getMethods();
		if (methodList != null && !methodList.isEmpty()) {
			for (DeclaredMethod method : methodList) {
				write(method,outputStream);
				outputStream.write("\n".getBytes());
			}
		}
		
		writeToOutputStream("}",outputStream,true);
		
	}

	/**
	 * Writes the declared method to the managed output stream, expressing it as Java
	 * source code.
	 *
	 * @param declaredMethod The declared method to be written tot he output stream as Java
	 *        source.
	 **/
	public void write(DeclaredMethod declaredMethod, OutputStream outputStream) throws IOException {
		StringBuilder buffer = new StringBuilder();

		// TODO: May want to remove this next line if not bothered about pretty printing
		//       OR if pretty printing/formatting should take place elsewhere...
		buffer.append("    ");
		
		// FIXME: STOP!...writing to stream every time (and converting to bytes). Build up a buffer then send once!!
		buffer.append("public ");

		if (declaredMethod.hasReturnType()) {
			buffer.append(declaredMethod.getReturnType().getName());
			
			if (declaredMethod.getReturnType().getGenericType() != null) {
				buffer.append("<");
				buffer.append(declaredMethod.getReturnType().getGenericType());
				buffer.append(">");
			}
			buffer.append(" ");
			// FIXME: Need to implement and use type mapping eventually..
		} else {
			buffer.append("void ");
		}
		
		buffer.append(declaredMethod.getName());

		buffer.append("(");

		if (declaredMethod.getParameters() != null) {
			Iterator<DeclaredMethodParameter> parameterIterator = declaredMethod.getParameters().iterator();
			while (parameterIterator.hasNext()) {
				DeclaredMethodParameter parameter = parameterIterator.next();
				
				buffer.append(parameter.getType().getName());
				if (parameter.getType().getGenericType() != null) {
					buffer.append("<");
					buffer.append(parameter.getType().getGenericType());
					buffer.append(">");
				}
				
				buffer.append(" ");
				buffer.append(parameter.getName());
				
				if (parameterIterator.hasNext()) {
					buffer.append(", ");
				}
			}
		}
		buffer.append(");");
		
		outputStream.write(buffer.toString().getBytes());
		
	}

	/**
	 * Writes the declared method parameter to the output stream, expressing it as Java
	 * source code.
	 *
	 * @param declaredMethodParameter The declared method parameter to write to the Output 
	 *        stream as Java source.
	 *
	 * @param outputStream The outputStream to write to.
	 * @throws IOException
	 **/
	public void write(DeclaredMethodParameter declaredMethodParameter, OutputStream outputStream) throws IOException {
		// FIXME: Fix this to correctly convert the Type
		String typeName = typeMapper.getLanguageTypeName(declaredMethodParameter.getType().toString());

		outputStream.write(typeName.getBytes());
		outputStream.write(" ".getBytes());
		outputStream.write(declaredMethodParameter.getName().getBytes());
		outputStream.flush();
	}

	private void writeToOutputStream(String stringToWrite, OutputStream outputStream, boolean appendNewLine) throws IOException {
		outputStream.write(stringToWrite.getBytes());
		if (appendNewLine) {
			outputStream.write("\n".getBytes());
		}
	}
}