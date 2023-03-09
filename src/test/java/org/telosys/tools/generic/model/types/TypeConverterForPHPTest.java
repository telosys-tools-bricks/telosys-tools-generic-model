package org.telosys.tools.generic.model.types;

import static org.telosys.tools.generic.model.types.AttributeTypeInfo.NONE;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.NOT_NULL;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.OBJECT_TYPE;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.PRIMITIVE_TYPE;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.UNSIGNED_TYPE;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TypeConverterForPHPTest  {

	private TypeConverter getTypeConverter() {
		return new TypeConverterForPHP();
	}
	
	private LanguageType getType(String neutralType, int typeInfo ) {
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(neutralType, typeInfo);
		return getType(attributeTypeInfo);
	}

	private LanguageType getType(AttributeTypeInfo typeInfo ) {
		return getTypeConverter().getType(typeInfo);
	}
	
	
	private void checkPrimitiveType( LanguageType lt, String primitiveType) {
		assertNotNull(lt);
		assertTrue ( lt.isPrimitiveType() ) ;
		assertEquals(primitiveType, lt.getSimpleType() );
		assertEquals(primitiveType, lt.getFullType() );
		assertEquals(primitiveType, lt.getWrapperType() );
	}

	private void checkObjectType( LanguageType lt, String simpleType, String fullType) {
		assertNotNull(lt);
		assertFalse ( lt.isPrimitiveType() ) ;
		assertEquals(simpleType, lt.getSimpleType() );
		assertEquals(fullType,   lt.getFullType() );
		assertEquals(simpleType, lt.getWrapperType() );
	}

	private void checkPrimitiveTypeExpected(String neutralType, String targetType) {
		String nullableTargetType = "?" + targetType;
		checkPrimitiveType( getType( neutralType, NONE ),               nullableTargetType );
		checkPrimitiveType( getType( neutralType, PRIMITIVE_TYPE ),     nullableTargetType );
		checkPrimitiveType( getType( neutralType, OBJECT_TYPE),         nullableTargetType );
		checkPrimitiveType( getType( neutralType, UNSIGNED_TYPE ),      nullableTargetType);

		checkPrimitiveType( getType( neutralType, NOT_NULL ),                  targetType );
		checkPrimitiveType( getType( neutralType, NOT_NULL + PRIMITIVE_TYPE),  targetType );
		checkPrimitiveType( getType( neutralType, NOT_NULL + OBJECT_TYPE ),    targetType );
		checkPrimitiveType( getType( neutralType, NOT_NULL + UNSIGNED_TYPE ),  targetType );
	}
	
	@Test
	public void testString() {
		checkPrimitiveTypeExpected(NeutralType.STRING,  "string");
	}

	@Test
	public void testBoolean() {
		checkPrimitiveTypeExpected(NeutralType.BOOLEAN,  "bool");
	}

	@Test
	public void testByte() {
		checkPrimitiveTypeExpected(NeutralType.BYTE,  "int");
	}

	@Test
	public void testShort() {
		checkPrimitiveTypeExpected(NeutralType.SHORT,  "int");
	}

	@Test
	public void testInteger() {
		checkPrimitiveTypeExpected(NeutralType.INTEGER,  "int");
	}

	@Test
	public void testLong() {
		checkPrimitiveTypeExpected(NeutralType.LONG,  "int");
	}

	@Test
	public void testFloat() {
		checkPrimitiveTypeExpected(NeutralType.FLOAT,  "float");
	}

	@Test
	public void testDouble() {
		checkPrimitiveTypeExpected(NeutralType.DOUBLE,  "float");
	}

	@Test
	public void testDecimal() {
		checkPrimitiveTypeExpected(NeutralType.DECIMAL,  "float");
	}

	private void checkDateTimeExpected(String neutralType) {
		checkObjectType( getType( neutralType, NONE ),                  "?DateTime", "?\\DateTime" );
		checkObjectType( getType( neutralType, PRIMITIVE_TYPE ),        "?DateTime", "?\\DateTime");
		checkObjectType( getType( neutralType, OBJECT_TYPE),            "?DateTime", "?\\DateTime" );
		checkObjectType( getType( neutralType, UNSIGNED_TYPE ),         "?DateTime", "?\\DateTime");

		checkObjectType( getType( neutralType, NOT_NULL ),                 "DateTime", "\\DateTime");
		checkObjectType( getType( neutralType, NOT_NULL + PRIMITIVE_TYPE), "DateTime", "\\DateTime" );
		checkObjectType( getType( neutralType, NOT_NULL + OBJECT_TYPE),    "DateTime", "\\DateTime" );
		checkObjectType( getType( neutralType, NOT_NULL + UNSIGNED_TYPE ), "DateTime", "\\DateTime");
	}

	@Test
	public void testTimestamp() {
		checkDateTimeExpected(NeutralType.TIMESTAMP);
	}

	private void checkVoidExpected(String neutralType) {
		checkObjectType( getType( neutralType, NONE ),                  "", "" );
		checkObjectType( getType( neutralType, PRIMITIVE_TYPE ),        "", "" );
		checkObjectType( getType( neutralType, OBJECT_TYPE),            "", "" );
		checkObjectType( getType( neutralType, UNSIGNED_TYPE),          "", "" );

		checkObjectType( getType( neutralType, NOT_NULL ),                  "", "");
		checkObjectType( getType( neutralType, NOT_NULL + PRIMITIVE_TYPE ), "", "");
		checkObjectType( getType( neutralType, NOT_NULL + OBJECT_TYPE ),    "", "");
		checkObjectType( getType( neutralType, NOT_NULL + UNSIGNED_TYPE),   "", "");
	}

	@Test
	public void testDate() {
		checkVoidExpected(NeutralType.DATE);
	}

	@Test
	public void testTime() {
		checkVoidExpected(NeutralType.TIME);
	}

	@Test
	public void testBinary() {
		checkVoidExpected(NeutralType.BINARY);
	}

}
