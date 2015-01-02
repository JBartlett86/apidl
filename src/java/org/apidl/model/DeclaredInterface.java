package org.apidl.model;

import java.util.List;

import org.apidl.model.impl.DeclaredInterfaceImpl.AccessType;

public interface DeclaredInterface extends Restricted {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract AccessType getType();

	public abstract void setType(AccessType type);

	public abstract String getExtend();

	public abstract void setExtend(String extend);

	public abstract List<DeclaredNamespace> getNamespaces();

	public abstract void addNamespace(DeclaredNamespace namespace);

	public abstract void addRequire(DeclaredRequire require);

	public abstract List<DeclaredRequire> getRequires();

	public abstract void addParentName(String parentName);

	public abstract List<String> getParentNames();

	public abstract void addMethod(DeclaredMethod method);

	public abstract List<DeclaredMethod> getMethods();
}