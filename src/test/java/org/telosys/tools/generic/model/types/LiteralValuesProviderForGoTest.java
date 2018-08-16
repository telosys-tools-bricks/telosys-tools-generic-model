package org.telosys.tools.generic.model.types;

import static org.telosys.tools.generic.model.types.AttributeTypeInfo.NONE;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LiteralValuesProviderForGoTest {
	
	//----------------------------------------------------------------------------------
	private TypeConverter getTypeConverter() {
		return new TypeConverterForGo() ;
	}
	private LiteralValuesProvider getLiteralValuesProvider() {
		return new LiteralValuesProviderForGo() ;
	}
	private LanguageType getLanguageType(AttributeTypeInfo typeInfo ) {
		System.out.println( typeInfo + " --> " + typeInfo );
		LanguageType lt = getTypeConverter().getType(typeInfo);
		return lt ;
	}
	private LanguageType getLanguageType(String neutralType, int typeInfo ) {
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(neutralType, typeInfo);
		System.out.println("AttributeTypeInfo : " + attributeTypeInfo);
		return getLanguageType(attributeTypeInfo);
	}
	//----------------------------------------------------------------------------------

	@Test
	public void testLiteralNull() {
		assertEquals("nil", getLiteralValuesProvider().getLiteralNull() );
	}

	@Test
	public void testLiteralBooleanValues() {
		LanguageType lt = getLanguageType(NeutralType.BOOLEAN, NONE );
		assertEquals("true",  getLiteralValuesProvider().generateLiteralValue(lt, 0, 1) );
		assertEquals("false", getLiteralValuesProvider().generateLiteralValue(lt, 0, 2) );
		assertEquals("true",  getLiteralValuesProvider().generateLiteralValue(lt, 0, 3) );
	}

	@Test
	public void testLiteralStringValues() {
		LanguageType lt = getLanguageType(NeutralType.STRING, NONE );
		assertEquals("\"AAA\"",   getLiteralValuesProvider().generateLiteralValue(lt, 3, 1) );
		assertEquals("\"BBB\"",   getLiteralValuesProvider().generateLiteralValue(lt, 3, 2) );
		assertEquals("\"CCCCC\"", getLiteralValuesProvider().generateLiteralValue(lt, 5, 3) );
	}

	@Test
	public void testLiteralIntegerValues() {
		LanguageType lt = getLanguageType(NeutralType.INTEGER, NONE );
		assertEquals("100", getLiteralValuesProvider().generateLiteralValue(lt, 0, 1) );
		assertEquals("200", getLiteralValuesProvider().generateLiteralValue(lt, 0, 2) );
	}

	@Test
	public void testLiteralLongValues() {
		LanguageType lt = getLanguageType(NeutralType.LONG, NONE );
		assertEquals("1000", getLiteralValuesProvider().generateLiteralValue(lt, 0, 1) );
		assertEquals("2000", getLiteralValuesProvider().generateLiteralValue(lt, 0, 2) );
	}

	@Test
	public void testLiteralFloatValues() {
		LanguageType lt = getLanguageType(NeutralType.FLOAT, NONE );
		assertEquals("1000.5", getLiteralValuesProvider().generateLiteralValue(lt, 0, 1) );
		assertEquals("2000.5", getLiteralValuesProvider().generateLiteralValue(lt, 0, 2) );
	}

	@Test
	public void testEqualsStatement() {
		assertEquals(" == foo", getLiteralValuesProvider().getEqualsStatement("foo", getLanguageType(NeutralType.STRING, NONE )) );
		assertEquals(" == foo", getLiteralValuesProvider().getEqualsStatement("foo", getLanguageType(NeutralType.BOOLEAN, NONE )) );
		assertEquals(" == foo", getLiteralValuesProvider().getEqualsStatement("foo", getLanguageType(NeutralType.INTEGER, NONE )) );
		assertEquals(" == foo", getLiteralValuesProvider().getEqualsStatement("foo", getLanguageType(NeutralType.FLOAT, NONE )) );
	}

}
