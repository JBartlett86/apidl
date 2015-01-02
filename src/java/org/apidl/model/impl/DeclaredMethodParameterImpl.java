package org.apidl.model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apidl.model.DeclaredMethodParameter;
import org.apidl.model.Restriction;
import org.apidl.model.Type;

public class DeclaredMethodParameterImpl implements DeclaredMethodParameter {


	private ParameterType parameterType;
	private String name;
	private Type type;
	private List<Restriction> restrictions;
	
	public DeclaredMethodParameterImpl() {
		super();
		restrictions = new ArrayList<Restriction>();
	}

	public void setParameterType(ParameterType parameterType) {
		this.parameterType = parameterType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public ParameterType getParameterType() {
		return parameterType;
	}
	
	public boolean hasRestrictions() { 
		return !restrictions.isEmpty();
	}

	public List<Restriction> getRestrictions() {
		return restrictions;
	}
	
	public void addRestriction(Restriction restriction) {
		getRestrictions().add(restriction);
	}

	public void addRestrictions(List<Restriction> restrictions) {
		for (Restriction restriction : restrictions) {
			addRestriction(restriction);
		}
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		if (parameterType != null) {
			switch (parameterType) {
			case READONLY:
				// FIXME: Remember grammar here!
				break;
			case OUTPUT:
				// FIXME: Remember grammar here!
				break;
			}
			builder.append(" ");
		}
		
		builder.append(type.getName());

		if (type.getGenericType() != null) {
			builder.append("<");
			builder.append(type.getGenericType());
			builder.append(">");
		}
		
		builder.append(" ");
		builder.append(name);
		
		if (!restrictions.isEmpty()) {
			builder.append(" ");
			Iterator<Restriction> restrictionIterator = restrictions.iterator();
			while (restrictionIterator.hasNext()) {
				builder.append(restrictionIterator.next().toString());
				if (restrictionIterator.hasNext()) {
					builder.append(" or ");
				}
			}
		}
		return builder.toString();
	}

	
}
