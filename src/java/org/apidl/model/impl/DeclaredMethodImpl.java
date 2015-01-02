package org.apidl.model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apidl.model.DeclaredMethod;
import org.apidl.model.DeclaredMethodParameter;
import org.apidl.model.Restriction;
import org.apidl.model.Type;

public class DeclaredMethodImpl implements DeclaredMethod {

	private String name;
	private Type returnType;
	private List<DeclaredMethodParameter> parameters;
	private List<Restriction> restrictions;

	public DeclaredMethodImpl(String name) {
		super();
		this.name = name;
		this.parameters = new ArrayList<DeclaredMethodParameter>();
		this.restrictions = new ArrayList<Restriction>();
	}

	@Override
	public boolean hasReturnType() {
		return returnType != null;
	}

	@Override
	public Type getReturnType() {
		return returnType;
	}

	@Override
	public void setReturnType(Type returnType) {
		this.returnType = returnType;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public boolean hasParameters() {
		return !parameters.isEmpty();
	}

	@Override
	public List<DeclaredMethodParameter> getParameters() {
		return parameters;
	}

	@Override
	public void addParameter(DeclaredMethodParameter parameter) {
		parameters.add(parameter);
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
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("method");
		builder.append(" ");
		builder.append(name);
		builder.append("(");
		
		if (hasParameters()) {
			Iterator<DeclaredMethodParameter> parameterIterator = parameters.iterator();
			while (parameterIterator.hasNext()) {
				builder.append(parameterIterator.next().toString());
				
				if (parameterIterator.hasNext()) {
					builder.append(", ");
				}
			}
		}
		
		builder.append(")");
		
		if (returnType != null) {
			builder.append(" ");
			builder.append("returns");
			builder.append(" ");
			builder.append(returnType.getName());
			if (returnType.getGenericType() != null) {
				builder.append("<");
				builder.append(returnType.getGenericType());
				builder.append(">");
			}
		}
		
		if (hasRestrictions()) {
			builder.append(" for ");
			Iterator<Restriction> restrictionIterator = restrictions.iterator();
			while (restrictionIterator.hasNext()) {
				builder.append(restrictionIterator.next().toString());
				if (restrictionIterator.hasNext()) {
					builder.append(" or ");
				}
			}
		}
		
		builder.append(";");
		
		return builder.toString();
	}
}
