package org.apidl.language;

public interface TypeMapper
{
	public String getNativeTypeName(String languageTypeName);

	public String getLanguageTypeName(String nativeTypeName);
}