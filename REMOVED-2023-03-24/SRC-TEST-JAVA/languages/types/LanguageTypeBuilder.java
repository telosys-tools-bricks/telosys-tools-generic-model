package org.telosys.tools.generic.model.languages.types;

public class LanguageTypeBuilder {

	private LanguageTypeBuilder() {
	}

	public static LanguageType build(String neutralType, String simpleType, String fullType, boolean primitiveType, String wrapperType ) {
		return new LanguageType( neutralType, simpleType, fullType, primitiveType, wrapperType );
	}
}
