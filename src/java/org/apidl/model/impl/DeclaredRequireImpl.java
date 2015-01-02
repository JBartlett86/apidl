package org.apidl.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.apidl.model.DeclaredRequire;
import org.apidl.model.Restriction;


public class DeclaredRequireImpl implements DeclaredRequire {

	private String name;
	private List<Restriction> restrictions;

	public DeclaredRequireImpl(String name) {
		super();
		this.name = name;
		this.restrictions = new ArrayList<Restriction>();
	}

	public String getName() {
		return name;
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

}
