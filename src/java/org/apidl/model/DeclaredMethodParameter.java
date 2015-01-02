package org.apidl.model;


public interface DeclaredMethodParameter extends Restricted {

	public enum ParameterType {
		READONLY, OUTPUT,
	}
	
	public void setParameterType(ParameterType parameterType);

	public void setName(String name);

	public void setType(Type type);

	public String getName();

	public Type getType();

	public ParameterType getParameterType();
}