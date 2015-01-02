package org.apidl.language.java;

import org.apidl.language.TypeMapper;
import org.apidl.model.Restriction;

public class JavaTypeMapper implements TypeMapper
{
	private Restriction restriction;

	public JavaTypeMapper(Restriction restriction) {
		super();
		this.restriction = restriction;
	}

	/**
	 * 
	 *
	 *
	 */
	public String getNativeTypeName(String languageTypeName) {
		return languageTypeName;
	}

	/**
	 * Return the Language 
	 *
	 *
	 *
	 **/
	public String getLanguageTypeName(String nativeTypeName) {
		return nativeTypeName;
	}
}