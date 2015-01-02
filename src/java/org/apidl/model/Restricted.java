package org.apidl.model;

import java.util.List;

public interface Restricted {
	
	public List<Restriction> getRestrictions();

	public void addRestriction(Restriction restriction);

	public void addRestrictions(List<Restriction> restrictions);

	public boolean hasRestrictions();
}
