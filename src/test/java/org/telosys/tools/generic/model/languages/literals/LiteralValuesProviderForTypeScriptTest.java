package org.telosys.tools.generic.model.languages.literals;

import static org.telosys.tools.generic.model.languages.types.AttributeTypeInfo.NONE;

import org.junit.Test;
import org.telosys.tools.generic.model.languages.literals.LiteralValuesProvider;
import org.telosys.tools.generic.model.languages.literals.LiteralValuesProviderForJavaScript;
import org.telosys.tools.generic.model.languages.types.AttributeTypeInfo;
import org.telosys.tools.generic.model.languages.types.LanguageType;
import org.telosys.tools.generic.model.languages.types.TypeConverter;
import org.telosys.tools.generic.model.languages.types.TypeConverterForJavaScript;
import org.telosys.tools.generic.model.types.NeutralType;

import static org.junit.Assert.assertEquals;

public class LiteralValuesProviderForTypeScriptTest {
	
	//----------------------------------------------------------------------------------
	private TypeConverter getTypeConverter() {
		return new TypeConverterForJavaScript() ;
	}
	private LiteralValuesProvider getLiteralValuesProvider() {
		return new LiteralValuesProviderForJavaScript() ;
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
		assertEquals("null", getLiteralValuesProvider().getLiteralNull() );
	}

	@Test
	public void testLiteralValuesForBOOLEAN() {
		LanguageType lt = getLanguageType(NeutralType.BOOLEAN, NONE );
		assertEquals("true",  getLiteralValuesProvider().generateLiteralValue(lt, 0, 1).getCurrentLanguageValue() );
		assertEquals("false", getLiteralValuesProvider().generateLiteralValue(lt, 0, 2).getCurrentLanguageValue() );
		assertEquals("true",  getLiteralValuesProvider().generateLiteralValue(lt, 0, 3).getCurrentLanguageValue() );
	}

	@Test
	public void testLiteralValuesForSTRING() {
		LanguageType lt = getLanguageType(NeutralType.STRING, NONE );
		assertEquals("\"AAA\"",   getLiteralValuesProvider().generateLiteralValue(lt, 3, 1).getCurrentLanguageValue() );
		assertEquals("\"BBB\"",   getLiteralValuesProvider().generateLiteralValue(lt, 3, 2).getCurrentLanguageValue() );
		assertEquals("\"CCCCC\"", getLiteralValuesProvider().generateLiteralValue(lt, 5, 3).getCurrentLanguageValue() );
	}

	@Test
	public void testLiteralValuesForBYTE() {
		LanguageType lt = getLanguageType(NeutralType.BYTE, NONE );
		assertEquals("1", getLiteralValuesProvider().generateLiteralValue(lt, 0, 1).getCurrentLanguageValue() );
		assertEquals("2", getLiteralValuesProvider().generateLiteralValue(lt, 0, 2).getCurrentLanguageValue() );
	}

	@Test
	public void testLiteralValuesForSHORT() {
		LanguageType lt = getLanguageType(NeutralType.SHORT, NONE );
		assertEquals("1", getLiteralValuesProvider().generateLiteralValue(lt, 0, 1).getCurrentLanguageValue() );
		assertEquals("2", getLiteralValuesProvider().generateLiteralValue(lt, 0, 2).getCurrentLanguageValue() );
	}

	@Test
	public void testLiteralValuesForINTEGER() {
		LanguageType lt = getLanguageType(NeutralType.INTEGER, NONE );
		assertEquals("100", getLiteralValuesProvider().generateLiteralValue(lt, 0, 1).getCurrentLanguageValue() );
		assertEquals("200", getLiteralValuesProvider().generateLiteralValue(lt, 0, 2).getCurrentLanguageValue() );
	}

	@Test
	public void testLiteralValuesForLONG() {
		LanguageType lt = getLanguageType(NeutralType.LONG, NONE );
		assertEquals("1000", getLiteralValuesProvider().generateLiteralValue(lt, 0, 1).getCurrentLanguageValue() );
		assertEquals("2000", getLiteralValuesProvider().generateLiteralValue(lt, 0, 2).getCurrentLanguageValue() );
	}

	@Test
	public void testLiteralValuesForFLOAT() {
		LanguageType lt = getLanguageType(NeutralType.FLOAT, NONE );
		assertEquals("1000.5", getLiteralValuesProvider().generateLiteralValue(lt, 0, 1).getCurrentLanguageValue() );
		assertEquals("2000.5", getLiteralValuesProvider().generateLiteralValue(lt, 0, 2).getCurrentLanguageValue() );
	}

	@Test
	public void testLiteralValuesForDOUBLE() {
		LanguageType lt = getLanguageType(NeutralType.DOUBLE, NONE );
		assertEquals("1000.66", getLiteralValuesProvider().generateLiteralValue(lt, 0, 1).getCurrentLanguageValue() );
		assertEquals("2000.66", getLiteralValuesProvider().generateLiteralValue(lt, 0, 2).getCurrentLanguageValue() );
	}

	@Test
	public void testLiteralValuesForDECIMAL() {
		LanguageType lt = getLanguageType(NeutralType.DECIMAL, NONE );
		assertEquals("10000.77", getLiteralValuesProvider().generateLiteralValue(lt, 0, 1).getCurrentLanguageValue() );
		assertEquals("20000.77", getLiteralValuesProvider().generateLiteralValue(lt, 0, 2).getCurrentLanguageValue() );
	}

	@Test
	public void testEqualsStatement() {
		assertEquals(" == foo", getLiteralValuesProvider().getEqualsStatement("foo", getLanguageType(NeutralType.STRING, NONE )) );
		assertEquals(" == foo", getLiteralValuesProvider().getEqualsStatement("foo", getLanguageType(NeutralType.BOOLEAN, NONE )) );
		assertEquals(" == foo", getLiteralValuesProvider().getEqualsStatement("foo", getLanguageType(NeutralType.INTEGER, NONE )) );
		assertEquals(" == foo", getLiteralValuesProvider().getEqualsStatement("foo", getLanguageType(NeutralType.FLOAT, NONE )) );
	}

}
