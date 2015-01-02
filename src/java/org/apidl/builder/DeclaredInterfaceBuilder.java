package org.apidl.builder;

import org.antlr.runtime.CharStream;
import org.apidl.model.DeclaredInterface;

public interface DeclaredInterfaceBuilder{
	
	DeclaredInterface build(String fileName) throws Exception;

	DeclaredInterface build(CharStream stream) throws Exception;
	
}
