package org.apidl.io;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.apidl.model.DeclaredInterface;
import org.apidl.model.DeclaredMethod;
import org.apidl.model.DeclaredNamespace;
import org.apidl.model.DeclaredRequire;
import org.apidl.model.Restriction;
import org.apidl.model.impl.RestrictionImpl;
import org.apidl.model.impl.DeclaredInterfaceImpl.AccessType;

public class APIDLWriter {

	// This could turn into its own writer class...
	public void write(DeclaredInterface declaredInterface, OutputStream outputStream) throws IOException {
		StringBuilder builder = new StringBuilder();
		
		// Namespaces
		for (DeclaredNamespace namespace : declaredInterface.getNamespaces()) {
			builder.append("namespace");
			builder.append(" ");
			builder.append(namespace.getName());
			
			if (namespace.hasRestrictions()) {
				append(namespace.getRestrictions(), builder);
			}
			builder.append(";");
			builder.append("\n");
			builder.append("\n");
		}
		
		// Requires
		for (DeclaredRequire require : declaredInterface.getRequires()) {
			builder.append("requires");
			builder.append(" ");
			builder.append(require.getName());
			
			if (require.hasRestrictions()) {
				append(require.getRestrictions(), builder);
			}
			builder.append("\n");
		}
		builder.append("\n");
		
		// Name and inheritence information
		if (declaredInterface.getType() == AccessType.PRIVATE) {
			builder.append("private"); 
		} else {
			builder.append("public");
		}
		
		builder.append(" ");
		builder.append(declaredInterface.getName());
		builder.append("\n");
		// FIXME: deal with extends/parent names/for restrictions here later..

		// Methods
		builder.append("{");
		builder.append("\n");
		for (DeclaredMethod method : declaredInterface.getMethods()) {
			builder.append("\t");
			builder.append(method);
			builder.append("\n");
		}
		
		// methods here
		
		builder.append("}");
		builder.append("\n");
		
		
		BufferedOutputStream bos = new BufferedOutputStream(outputStream);
		bos.write(builder.toString().getBytes());
		bos.flush();
	}
	
	public void append(List<Restriction>restrictions ,StringBuilder builder) {
		builder.append(" ");
		builder.append("for");
		builder.append(" ");
		Iterator<Restriction> restrictionsIterator = restrictions.iterator();
		
		while (restrictionsIterator.hasNext()) {
			Restriction restriction = restrictionsIterator.next();
			builder.append(restriction.getPlatform());
			
			if (restriction.getOperator() != null && restriction.getVersion() != null) {
				builder.append(" ");
				builder.append(restriction.getOperator());
				builder.append(" ");
				builder.append(restriction.getVersion());
			}
			
			if (restrictionsIterator.hasNext()) {
				builder.append(" or ");
			}
		}
	}
	
	
}
