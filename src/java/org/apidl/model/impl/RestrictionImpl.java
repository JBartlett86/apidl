package org.apidl.model.impl;

import org.apidl.model.Restriction;

public class RestrictionImpl implements Restriction {

	private final String platform;

	private String operator;

	private String version;

	public RestrictionImpl(String platform) {
		super();
		this.platform = platform;
	}

	public String getPlatform() {
		return platform;
	}

	public String getOperator() {
		return operator;
	}

	public String getVersion() {
		return version;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(platform);
		if (operator != null && version != null) {
			builder.append(" ");
			builder.append(operator);
			builder.append(" ");
			builder.append(version);
		}		
		return builder.toString();
	}
}
