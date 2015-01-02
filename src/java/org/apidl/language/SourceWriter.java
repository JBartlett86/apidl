package org.apidl.language;

import java.io.IOException;
import java.io.OutputStream;

import org.apidl.IllegalDeclarationException;
import org.apidl.model.DeclaredInterface;
import org.apidl.model.DeclaredMethod;
import org.apidl.model.DeclaredMethodParameter;

public interface SourceWriter
{
	public void write(DeclaredInterface declaredInterface, OutputStream outputStream) throws IllegalDeclarationException, IOException;

	public void write(DeclaredMethod declaredMethod, OutputStream outputStream) throws IOException;

	public void write(DeclaredMethodParameter declaredMethodParameter, OutputStream outputStream) throws IOException;
}