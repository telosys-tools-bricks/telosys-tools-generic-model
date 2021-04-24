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

public class TypeConverterForTypeScriptTest  {

	private TypeConverter getTypeConverter() {
		return new TypeConverterForTypeScript() ;
	}
	
	private LanguageType getType(TypeConverter tc, AttributeTypeInfo typeInfo ) {
		LanguageType lt = tc.getType(typeInfo);
		System.out.println( "AttributeTypeInfo : " + typeInfo + " --> " + lt );
		return lt ;
	}
	
	private LanguageType getType(TypeConverter tc, String neutralType, int typeInfo ) {
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(neutralType, typeInfo);
		return getType(tc, attributeTypeInfo);
	}
	
	private void checkStringPrimitiveType(TypeConverter tc, int typeInfo ) {
		checkPrimitiveType( getType(tc, NeutralType.STRING, typeInfo ), "string", "String");
	}
//	private void checkStringObjectType(TypeConverter tc, int typeInfo ) {
//		checkObjectType( getType(tc, NeutralType.STRING, typeInfo ), "String", "String");
//	}
	private void checkBooleanPrimitiveType(TypeConverter tc, int typeInfo ) {
		checkPrimitiveType( getType(tc, NeutralType.BOOLEAN, typeInfo ), "boolean", "Boolean");
	}
//	private void checkBooleanObjectType(TypeConverter tc, int typeInfo ) {
//		checkObjectType( getType(tc, NeutralType.BOOLEAN, typeInfo ), "Boolean", "Boolean");
//	}
	private void checkShortPrimitiveType(TypeConverter tc, int typeInfo ) {
		checkPrimitiveType( getType(tc, NeutralType.SHORT, typeInfo ), "number", "Number");
	}
//	private void checkShortObjectType(TypeConverter tc, int typeInfo ) {
//		checkObjectType( getType(tc, NeutralType.SHORT, typeInfo ), "Number", "Number");
//	}
	private void checkDecimalPrimitiveType(TypeConverter tc, int typeInfo ) {
		checkPrimitiveType( getType(tc, NeutralType.DECIMAL, typeInfo ), "number", "Number");
	}
//	private void checkDecimalObjectType(TypeConverter tc, int typeInfo ) {
//		checkObjectType( getType(tc, NeutralType.DECIMAL, typeInfo ), "Number", "Number");
//	}
	private void checkDateObjectType(TypeConverter tc, int typeInfo ) {
		checkObjectType( getType(tc, NeutralType.DATE, typeInfo ), "Date", "Date");
	}
	private void checkTimeObjectType(TypeConverter tc, int typeInfo ) {
		checkObjectType( getType(tc, NeutralType.TIME, typeInfo ), "Date", "Date");
	}
	private void checkTimestampObjectType(TypeConverter tc, int typeInfo ) {
		checkObjectType( getType(tc, NeutralType.TIMESTAMP, typeInfo ), "Date", "Date");
	}
	
	private void checkPrimitiveType( LanguageType lt, String primitiveType, String wrapperType) {
		assertNotNull(lt);
		assertEquals(primitiveType, lt.getSimpleType() );
		assertEquals(primitiveType, lt.getFullType() );
		assertTrue ( lt.isPrimitiveType() ) ;
		assertEquals(wrapperType, lt.getWrapperType() );
	}

	private void checkObjectType( LanguageType lt, String simpleType, String fullType) {
		assertNotNull(lt);
		assertEquals(simpleType, lt.getSimpleType() );
		assertEquals(fullType,   lt.getFullType() );
		assertFalse ( lt.isPrimitiveType() ) ;
		assertEquals(fullType,   lt.getWrapperType() );
	}
	
	@Test
	public void testString() {
		System.out.println("--- ");
		TypeConverter tc = getTypeConverter() ;
		
		// Primitive type expected
		checkStringPrimitiveType(tc, NONE);
		checkStringPrimitiveType(tc, NOT_NULL);
		checkStringPrimitiveType(tc, PRIMITIVE_TYPE);
		checkStringPrimitiveType(tc, UNSIGNED_TYPE);
		checkStringPrimitiveType(tc, PRIMITIVE_TYPE + UNSIGNED_TYPE);
//		checkStringPrimitiveType(tc, SQL_TYPE);
//		checkStringPrimitiveType(tc, NOT_NULL + SQL_TYPE);
		checkStringPrimitiveType(tc, PRIMITIVE_TYPE + OBJECT_TYPE );
		
		// Object type expected
		checkStringPrimitiveType( tc, OBJECT_TYPE );
//		checkStringPrimitiveType( tc, OBJECT_TYPE + SQL_TYPE );
		checkStringPrimitiveType( tc, OBJECT_TYPE + NOT_NULL );
//		checkStringPrimitiveType( tc, OBJECT_TYPE + NOT_NULL + SQL_TYPE );
		checkStringPrimitiveType( tc, OBJECT_TYPE + UNSIGNED_TYPE );
//		checkStringPrimitiveType( tc, OBJECT_TYPE + UNSIGNED_TYPE + SQL_TYPE );
	}

	@Test
	public void testBoolean() {
		System.out.println("--- ");
		TypeConverter tc = getTypeConverter() ;

		// Primitive type expected
		checkBooleanPrimitiveType(tc, NONE);
		checkBooleanPrimitiveType(tc, NOT_NULL);
		checkBooleanPrimitiveType(tc, PRIMITIVE_TYPE);
		checkBooleanPrimitiveType(tc, UNSIGNED_TYPE);
		checkBooleanPrimitiveType(tc, PRIMITIVE_TYPE + UNSIGNED_TYPE);
//		checkBooleanPrimitiveType(tc, SQL_TYPE);
//		checkBooleanPrimitiveType(tc, NOT_NULL + SQL_TYPE);
		checkBooleanPrimitiveType(tc, PRIMITIVE_TYPE + OBJECT_TYPE );
				
		// Object type expected
		checkBooleanPrimitiveType( tc, OBJECT_TYPE );
//		checkBooleanPrimitiveType( tc, OBJECT_TYPE + SQL_TYPE );
		checkBooleanPrimitiveType( tc, OBJECT_TYPE + NOT_NULL );
//		checkBooleanPrimitiveType( tc, OBJECT_TYPE + NOT_NULL + SQL_TYPE );
		checkBooleanPrimitiveType( tc, OBJECT_TYPE + UNSIGNED_TYPE );
//		checkBooleanPrimitiveType( tc, OBJECT_TYPE + UNSIGNED_TYPE + SQL_TYPE );
	}

	@Test
	public void testShort() {
		System.out.println("--- ");
		TypeConverter tc = getTypeConverter() ;
		
		// Primitive type expected
		checkShortPrimitiveType(tc, NONE);
		checkShortPrimitiveType(tc, NOT_NULL);
		checkShortPrimitiveType(tc, PRIMITIVE_TYPE);
		checkShortPrimitiveType(tc, UNSIGNED_TYPE);
		checkShortPrimitiveType(tc, PRIMITIVE_TYPE + UNSIGNED_TYPE);
//		checkShortPrimitiveType(tc, SQL_TYPE);
//		checkShortPrimitiveType(tc, NOT_NULL + SQL_TYPE);
		checkShortPrimitiveType(tc, PRIMITIVE_TYPE + OBJECT_TYPE );
				
		// Object type expected
		checkShortPrimitiveType( tc, OBJECT_TYPE );
//		checkShortPrimitiveType( tc, OBJECT_TYPE + SQL_TYPE );
		checkShortPrimitiveType( tc, OBJECT_TYPE + NOT_NULL );
//		checkShortPrimitiveType( tc, OBJECT_TYPE + NOT_NULL + SQL_TYPE );
		checkShortPrimitiveType( tc, OBJECT_TYPE + UNSIGNED_TYPE );
//		checkShortPrimitiveType( tc, OBJECT_TYPE + UNSIGNED_TYPE + SQL_TYPE );
	}

	@Test
	public void testDecimal() {
		System.out.println("--- ");
		TypeConverter tc = getTypeConverter() ;
		
		// Primitive type expected
		checkDecimalPrimitiveType(tc, NONE);
		checkDecimalPrimitiveType(tc, NOT_NULL);
		checkDecimalPrimitiveType(tc, PRIMITIVE_TYPE);
		checkDecimalPrimitiveType(tc, UNSIGNED_TYPE);
		checkDecimalPrimitiveType(tc, PRIMITIVE_TYPE + UNSIGNED_TYPE);
//		checkDecimalPrimitiveType(tc, SQL_TYPE);
//		checkDecimalPrimitiveType(tc, NOT_NULL + SQL_TYPE);
		checkDecimalPrimitiveType(tc, PRIMITIVE_TYPE + OBJECT_TYPE );
				
		// Object type expected
		checkDecimalPrimitiveType( tc, OBJECT_TYPE );
//		checkDecimalPrimitiveType( tc, OBJECT_TYPE + SQL_TYPE );
		checkDecimalPrimitiveType( tc, OBJECT_TYPE + NOT_NULL );
//		checkDecimalPrimitiveType( tc, OBJECT_TYPE + NOT_NULL + SQL_TYPE );
		checkDecimalPrimitiveType( tc, OBJECT_TYPE + UNSIGNED_TYPE );
//		checkDecimalPrimitiveType( tc, OBJECT_TYPE + UNSIGNED_TYPE + SQL_TYPE );
	}

	@Test
	public void testDate() {
		System.out.println("--- DATE --> Date");
		TypeConverter tc = getTypeConverter() ;
		
		// Supposed to always return Date (in any cases) 
		checkDateObjectType(tc, NONE);
		checkDateObjectType(tc, NOT_NULL);
		checkDateObjectType(tc, PRIMITIVE_TYPE);
		checkDateObjectType(tc, UNSIGNED_TYPE);
		checkDateObjectType(tc, PRIMITIVE_TYPE + UNSIGNED_TYPE);
//		checkDateObjectType(tc, SQL_TYPE);
//		checkDateObjectType(tc, NOT_NULL + SQL_TYPE);
		checkDateObjectType(tc, PRIMITIVE_TYPE + OBJECT_TYPE );

		checkDateObjectType( tc, OBJECT_TYPE );
//		checkDateObjectType( tc, OBJECT_TYPE + SQL_TYPE );
		checkDateObjectType( tc, OBJECT_TYPE + NOT_NULL );
//		checkDateObjectType( tc, OBJECT_TYPE + NOT_NULL + SQL_TYPE );
		checkDateObjectType( tc, OBJECT_TYPE + UNSIGNED_TYPE );
//		checkDateObjectType( tc, OBJECT_TYPE + UNSIGNED_TYPE + SQL_TYPE );
	}

	@Test
	public void testTime() {
		System.out.println("--- TIME --> Date");
		TypeConverter tc = getTypeConverter() ;
		// Supposed to always return Date (in any cases) 
		checkTimeObjectType(tc, NONE);
		checkTimeObjectType(tc, NOT_NULL);
		checkTimeObjectType(tc, PRIMITIVE_TYPE);
		checkTimeObjectType(tc, UNSIGNED_TYPE);
		checkTimeObjectType(tc, PRIMITIVE_TYPE + UNSIGNED_TYPE);
//		checkTimeObjectType(tc, SQL_TYPE);
//		checkTimeObjectType(tc, NOT_NULL + SQL_TYPE);
		checkTimeObjectType(tc, PRIMITIVE_TYPE + OBJECT_TYPE );

		checkTimeObjectType( tc, OBJECT_TYPE );
//		checkTimeObjectType( tc, OBJECT_TYPE + SQL_TYPE );
		checkTimeObjectType( tc, OBJECT_TYPE + NOT_NULL );
//		checkTimeObjectType( tc, OBJECT_TYPE + NOT_NULL + SQL_TYPE );
		checkTimeObjectType( tc, OBJECT_TYPE + UNSIGNED_TYPE );
//		checkTimeObjectType( tc, OBJECT_TYPE + UNSIGNED_TYPE + SQL_TYPE );
	}

	@Test
	public void testTimestamp() {
		System.out.println("--- TIMESTAMP --> Date");
		TypeConverter tc = getTypeConverter() ;
		// Supposed to always return Date (in any cases) 
		checkTimestampObjectType(tc, NONE);
		checkTimestampObjectType(tc, NOT_NULL);
		checkTimestampObjectType(tc, PRIMITIVE_TYPE);
		checkTimestampObjectType(tc, UNSIGNED_TYPE);
		checkTimestampObjectType(tc, PRIMITIVE_TYPE + UNSIGNED_TYPE);
//		checkTimestampObjectType(tc, SQL_TYPE);
//		checkTimestampObjectType(tc, NOT_NULL + SQL_TYPE);
		checkTimestampObjectType(tc, PRIMITIVE_TYPE + OBJECT_TYPE );

		checkTimestampObjectType( tc, OBJECT_TYPE );
//		checkTimestampObjectType( tc, OBJECT_TYPE + SQL_TYPE );
		checkTimestampObjectType( tc, OBJECT_TYPE + NOT_NULL );
//		checkTimestampObjectType( tc, OBJECT_TYPE + NOT_NULL + SQL_TYPE );
		checkTimestampObjectType( tc, OBJECT_TYPE + UNSIGNED_TYPE );
//		checkTimestampObjectType( tc, OBJECT_TYPE + UNSIGNED_TYPE + SQL_TYPE );
	}

	@Test
	public void testPrimitiveTypes() {
		System.out.println("--- ");
		TypeConverter tc = new TypeConverterForTypeScript() ;
		LanguageType lt ;
		
		lt = getType(tc, NeutralType.BOOLEAN, PRIMITIVE_TYPE ) ;
		assertEquals("boolean", lt.getSimpleType());
		assertEquals("boolean", lt.getFullType());
		assertEquals("Boolean", lt.getWrapperType());
		assertTrue(lt.isPrimitiveType());
		
		lt = getType(tc, NeutralType.SHORT, PRIMITIVE_TYPE ) ;
		assertEquals("number", lt.getSimpleType());
		assertEquals("number", lt.getFullType());
		assertEquals("Number", lt.getWrapperType());
		assertTrue(lt.isPrimitiveType());

		lt = getType(tc, NeutralType.INTEGER, PRIMITIVE_TYPE ) ;
		assertEquals("number", lt.getSimpleType());
		assertEquals("number", lt.getFullType());
		assertEquals("Number", lt.getWrapperType());
		assertTrue(lt.isPrimitiveType());

		lt = getType(tc, NeutralType.LONG, PRIMITIVE_TYPE ) ;
		assertEquals("number", lt.getSimpleType());
		assertEquals("number", lt.getFullType());
		assertEquals("Number", lt.getWrapperType());
		assertTrue(lt.isPrimitiveType());
	}
	
	@Test
	public void testObjectTypes() {
		System.out.println("--- ");
		TypeConverter tc = new TypeConverterForTypeScript() ;
		LanguageType lt ;
		
		lt = getType(tc, NeutralType.DATE, OBJECT_TYPE ) ;
		assertEquals("Date", lt.getSimpleType());
		assertEquals("Date", lt.getFullType());
		assertEquals("Date", lt.getWrapperType());
		assertFalse(lt.isPrimitiveType());

		lt = getType(tc, NeutralType.TIME, OBJECT_TYPE ) ;
		assertEquals("Date", lt.getSimpleType());
		assertEquals("Date", lt.getFullType());
		assertEquals("Date", lt.getWrapperType());
		assertFalse(lt.isPrimitiveType());

		lt = getType(tc, NeutralType.TIMESTAMP, OBJECT_TYPE ) ;
		assertEquals("Date", lt.getSimpleType());
		assertEquals("Date", lt.getFullType());
		assertEquals("Date", lt.getWrapperType());
		assertFalse(lt.isPrimitiveType());
	}
}
