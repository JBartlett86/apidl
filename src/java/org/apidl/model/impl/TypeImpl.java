package org.apidl.model.impl;

import org.apidl.model.Type;

public class TypeImpl implements Type {

	private String name;

	private String genericType;

	public TypeImpl(String name) {
		super();
		this.name = name;
	}

	public void setGenericType(String genericType) {
		this.genericType = genericType;
	}

	public String getName() {
		return name;
	}

	public String getGenericType() {
		return genericType;
	}
	
}
