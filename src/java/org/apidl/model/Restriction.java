package org.apidl.model;

public interface Restriction {

	public String getPlatform();

	public String getOperator();

	public String getVersion();

	public void setOperator(String operator);

	public void setVersion(String version);

}