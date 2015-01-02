package org.apidl.model;

import java.util.List;

public interface DeclaredMethod extends Restricted {

	public abstract boolean hasReturnType();

	public abstract Type getReturnType();

	public abstract void setReturnType(Type returnType);

	public abstract String getName();

	public abstract boolean hasParameters();

	public abstract List<DeclaredMethodParameter> getParameters();

	public abstract void addParameter(DeclaredMethodParameter parameter);
}