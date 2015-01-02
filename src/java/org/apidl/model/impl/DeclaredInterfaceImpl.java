package org.apidl.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.apidl.model.DeclaredInterface;
import org.apidl.model.DeclaredMethod;
import org.apidl.model.DeclaredNamespace;
import org.apidl.model.DeclaredRequire;
import org.apidl.model.Restriction;

public class DeclaredInterfaceImpl implements DeclaredInterface {

	public enum AccessType {
		PUBLIC, PRIVATE
	}

	private AccessType type;
	private String name;
	private String extend;

	private List<DeclaredNamespace> namespaces;
	private List<DeclaredMethod> methods;
	private List<DeclaredRequire> requires;
	private List<String> parentNames;

	private List<Restriction> restrictions;

	public DeclaredInterfaceImpl() {
		super();
		this.namespaces = new ArrayList<DeclaredNamespace>();
		this.methods = new ArrayList<DeclaredMethod>();
		this.requires = new ArrayList<DeclaredRequire>();
		this.restrictions = new ArrayList<Restriction>();
		this.parentNames = new ArrayList<String>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public AccessType getType() {
		return type;
	}

	@Override
	public void setType(AccessType type) {
		this.type = type;
	}

	@Override
	public String getExtend() {
		return extend;
	}

	@Override
	public void setExtend(String extend) {
		this.extend = extend;
	}

	@Override
	public List<DeclaredNamespace> getNamespaces() {
		return namespaces;
	}

	@Override
	public void addNamespace(DeclaredNamespace namespace) {
		this.namespaces.add(namespace);
	}

	@Override
	public void addRequire(DeclaredRequire require) {
		requires.add(require);
	}

	@Override
	public List<DeclaredRequire> getRequires() {
		return requires;
	}
	
	@Override
	public void addParentName(String parentName) {
		parentNames.add(parentName);
	}

	@Override
	public List<String> getParentNames() {
		return parentNames;
	}

	@Override
	public void addMethod(DeclaredMethod method) {
		methods.add(method);
	}

	@Override
	public List<DeclaredMethod> getMethods() {
		return methods;
	}

	@Override
	public boolean hasRestrictions() {
		return !restrictions.isEmpty();
	}
	
	@Override
	public List<Restriction> getRestrictions() {
		return restrictions;
	}

	@Override
	public void addRestriction(Restriction restriction) {
		getRestrictions().add(restriction);
	}

	@Override
	public void addRestrictions(List<Restriction> restrictions) {
		for (Restriction restriction : restrictions) {
			addRestriction(restriction);
		}
	}
}
