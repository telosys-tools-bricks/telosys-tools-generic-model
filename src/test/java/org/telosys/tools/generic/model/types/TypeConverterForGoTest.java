package org.telosys.tools.generic.model.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.NONE;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.NOT_NULL;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.OBJECT_TYPE;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.PRIMITIVE_TYPE;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.SQL_TYPE;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.UNSIGNED_TYPE;

import org.junit.Test;

public class TypeConverterForGoTest  {

	private TypeConverter getTypeConverter() {
		return new TypeConverterForGo() ;
	}
	
	private LanguageType getType(String neutralType, int typeInfo ) {
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(neutralType, typeInfo);
		System.out.println("AttributeTypeInfo : " + attributeTypeInfo);
		return getType(attributeTypeInfo);
	}

	private LanguageType getType(AttributeTypeInfo typeInfo ) {
		System.out.println( typeInfo + " --> " + typeInfo );
		LanguageType lt = getTypeConverter().getType(typeInfo);
		return lt ;
	}
	
	
	private void checkPrimitiveType( LanguageType lt, String primitiveType, String wrapperType) {
		assertNotNull(lt);
		assertTrue ( lt.isPrimitiveType() ) ;
		assertEquals(primitiveType, lt.getSimpleType() );
		assertEquals(primitiveType, lt.getFullType() );
		assertEquals(wrapperType, lt.getWrapperType() );
	}

	private void checkObjectType( LanguageType lt, String simpleType, String fullType) {
		assertNotNull(lt);
		assertFalse ( lt.isPrimitiveType() ) ;
		assertEquals(simpleType, lt.getSimpleType() );
		assertEquals(fullType,   lt.getFullType() );
		assertEquals(simpleType, lt.getWrapperType() );
	}
	
	@Test
	public void testString() {
		System.out.println("--- ");
		checkPrimitiveType( getType(NeutralType.STRING, NONE ),            "string", "string");
		checkPrimitiveType( getType(NeutralType.STRING, NOT_NULL ),        "string", "string");
		checkPrimitiveType( getType(NeutralType.STRING, PRIMITIVE_TYPE ),  "string", "string");
		checkPrimitiveType( getType(NeutralType.STRING, UNSIGNED_TYPE ),   "string", "string");
		checkPrimitiveType( getType(NeutralType.STRING, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "string", "string");
		checkPrimitiveType( getType(NeutralType.STRING, OBJECT_TYPE),            "string", "string" );
		checkPrimitiveType( getType(NeutralType.STRING, SQL_TYPE),               "string", "string" );
		checkPrimitiveType( getType(NeutralType.STRING, OBJECT_TYPE + SQL_TYPE), "string", "string" );
	}

	@Test
	public void testBoolean() {
		System.out.println("--- ");
		checkPrimitiveType( getType( NeutralType.BOOLEAN, NONE ),                   "bool", "bool" );
		checkPrimitiveType( getType( NeutralType.BOOLEAN, NOT_NULL ),               "bool", "bool" );
		checkPrimitiveType( getType( NeutralType.BOOLEAN, PRIMITIVE_TYPE ),         "bool", "bool" );
		checkPrimitiveType( getType( NeutralType.BOOLEAN, UNSIGNED_TYPE ),          "bool", "bool" );
		checkPrimitiveType( getType( NeutralType.BOOLEAN, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "bool", "bool");
		checkPrimitiveType( getType( NeutralType.BOOLEAN, OBJECT_TYPE),             "bool", "bool" );
		checkPrimitiveType( getType( NeutralType.BOOLEAN, SQL_TYPE),                "bool", "bool" );
		checkPrimitiveType( getType( NeutralType.BOOLEAN, OBJECT_TYPE + SQL_TYPE),  "bool", "bool" );
		checkPrimitiveType( getType( NeutralType.BOOLEAN, NOT_NULL + OBJECT_TYPE),  "bool", "bool" );
		checkPrimitiveType( getType( NeutralType.BOOLEAN, NOT_NULL + SQL_TYPE),     "bool", "bool" );
	}

	@Test
	public void testByte() {
		System.out.println("--- ");
		checkPrimitiveType( getType( NeutralType.BYTE, NONE ),                  "byte", "byte" );
		checkPrimitiveType( getType( NeutralType.BYTE, NOT_NULL ),              "byte", "byte" );
		checkPrimitiveType( getType( NeutralType.BYTE, PRIMITIVE_TYPE ),        "byte", "byte" );
		checkPrimitiveType( getType( NeutralType.BYTE, OBJECT_TYPE),            "byte", "byte" );
		checkPrimitiveType( getType( NeutralType.BYTE, SQL_TYPE),               "byte", "byte" );
		checkPrimitiveType( getType( NeutralType.BYTE, OBJECT_TYPE + SQL_TYPE), "byte", "byte" );
		checkPrimitiveType( getType( NeutralType.BYTE, NOT_NULL + OBJECT_TYPE), "byte", "byte" );
		checkPrimitiveType( getType( NeutralType.BYTE, NOT_NULL + SQL_TYPE),    "byte", "byte" );
		// UNSIGNED 
		checkPrimitiveType( getType( NeutralType.BYTE, UNSIGNED_TYPE ),                  "uint8", "uint8");
		checkPrimitiveType( getType( NeutralType.BYTE, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "uint8", "uint8");
		checkPrimitiveType( getType( NeutralType.BYTE, OBJECT_TYPE + UNSIGNED_TYPE ),    "uint8", "uint8");
	}

	@Test
	public void testShort() {
		System.out.println("--- ");
		checkPrimitiveType( getType( NeutralType.SHORT, NONE ),                  "int16", "int16" );
		checkPrimitiveType( getType( NeutralType.SHORT, NOT_NULL ),              "int16", "int16" );
		checkPrimitiveType( getType( NeutralType.SHORT, PRIMITIVE_TYPE ),        "int16", "int16" );
		checkPrimitiveType( getType( NeutralType.SHORT, OBJECT_TYPE),            "int16", "int16" );
		checkPrimitiveType( getType( NeutralType.SHORT, SQL_TYPE),               "int16", "int16" );
		checkPrimitiveType( getType( NeutralType.SHORT, OBJECT_TYPE + SQL_TYPE), "int16", "int16" );
		checkPrimitiveType( getType( NeutralType.SHORT, NOT_NULL + OBJECT_TYPE), "int16", "int16" );
		checkPrimitiveType( getType( NeutralType.SHORT, NOT_NULL + SQL_TYPE),    "int16", "int16" );
		// UNSIGNED 
		checkPrimitiveType( getType( NeutralType.SHORT, UNSIGNED_TYPE ),                  "uint16", "uint16");
		checkPrimitiveType( getType( NeutralType.SHORT, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "uint16", "uint16");
		checkPrimitiveType( getType( NeutralType.SHORT, OBJECT_TYPE + UNSIGNED_TYPE ),    "uint16", "uint16");
	}

	@Test
	public void testInteger() {
		System.out.println("--- ");
		checkPrimitiveType( getType( NeutralType.INTEGER, NONE ),                  "int32", "int32" );
		checkPrimitiveType( getType( NeutralType.INTEGER, NOT_NULL ),              "int32", "int32" );
		checkPrimitiveType( getType( NeutralType.INTEGER, PRIMITIVE_TYPE ),        "int32", "int32" );
		checkPrimitiveType( getType( NeutralType.INTEGER, OBJECT_TYPE),            "int32", "int32" );
		checkPrimitiveType( getType( NeutralType.INTEGER, SQL_TYPE),               "int32", "int32" );
		checkPrimitiveType( getType( NeutralType.INTEGER, OBJECT_TYPE + SQL_TYPE), "int32", "int32" );
		checkPrimitiveType( getType( NeutralType.INTEGER, NOT_NULL + OBJECT_TYPE), "int32", "int32" );
		checkPrimitiveType( getType( NeutralType.INTEGER, NOT_NULL + SQL_TYPE),    "int32", "int32" );
		// UNSIGNED 
		checkPrimitiveType( getType( NeutralType.INTEGER, UNSIGNED_TYPE ),                  "uint32", "uint32");
		checkPrimitiveType( getType( NeutralType.INTEGER, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "uint32", "uint32");
		checkPrimitiveType( getType( NeutralType.INTEGER, OBJECT_TYPE + UNSIGNED_TYPE ),    "uint32", "uint32");
	}

	@Test
	public void testLong() {
		System.out.println("--- ");
		checkPrimitiveType( getType( NeutralType.LONG, NONE ),                  "int64", "int64" );
		checkPrimitiveType( getType( NeutralType.LONG, NOT_NULL ),              "int64", "int64");
		checkPrimitiveType( getType( NeutralType.LONG, PRIMITIVE_TYPE ),        "int64", "int64");
		checkPrimitiveType( getType( NeutralType.LONG, OBJECT_TYPE),            "int64", "int64" );
		checkPrimitiveType( getType( NeutralType.LONG, SQL_TYPE),               "int64", "int64" );
		checkPrimitiveType( getType( NeutralType.LONG, OBJECT_TYPE + SQL_TYPE), "int64", "int64" );
		checkPrimitiveType( getType( NeutralType.LONG, NOT_NULL + OBJECT_TYPE), "int64", "int64" );
		checkPrimitiveType( getType( NeutralType.LONG, NOT_NULL + SQL_TYPE),    "int64", "int64" );
		// UNSIGNED 
		checkPrimitiveType( getType( NeutralType.LONG, UNSIGNED_TYPE ),                  "uint64", "uint64");
		checkPrimitiveType( getType( NeutralType.LONG, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "uint64", "uint64");
		checkPrimitiveType( getType( NeutralType.LONG, OBJECT_TYPE + UNSIGNED_TYPE ),    "uint64", "uint64");
	}

	@Test
	public void testFloat() {
		System.out.println("--- ");
		checkPrimitiveType( getType( NeutralType.FLOAT, NONE ),                  "float32", "float32" );
		checkPrimitiveType( getType( NeutralType.FLOAT, NOT_NULL ),              "float32", "float32");
		checkPrimitiveType( getType( NeutralType.FLOAT, PRIMITIVE_TYPE ),        "float32", "float32");
		checkPrimitiveType( getType( NeutralType.FLOAT, OBJECT_TYPE),            "float32", "float32" );
		checkPrimitiveType( getType( NeutralType.FLOAT, SQL_TYPE),               "float32", "float32" );
		checkPrimitiveType( getType( NeutralType.FLOAT, OBJECT_TYPE + SQL_TYPE), "float32", "float32" );
		checkPrimitiveType( getType( NeutralType.FLOAT, NOT_NULL + OBJECT_TYPE), "float32", "float32" );
		checkPrimitiveType( getType( NeutralType.FLOAT, NOT_NULL + SQL_TYPE),    "float32", "float32" );
		// UNSIGNED : no difference 
		checkPrimitiveType( getType( NeutralType.FLOAT, UNSIGNED_TYPE ),                  "float32", "float32");
		checkPrimitiveType( getType( NeutralType.FLOAT, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "float32", "float32");
		checkPrimitiveType( getType( NeutralType.FLOAT, OBJECT_TYPE + UNSIGNED_TYPE ),    "float32", "float32");
	}

	@Test
	public void testDouble() {
		System.out.println("--- ");
		checkPrimitiveType( getType( NeutralType.DOUBLE, NONE ),                  "float64", "float64" );
		checkPrimitiveType( getType( NeutralType.DOUBLE, NOT_NULL ),              "float64", "float64");
		checkPrimitiveType( getType( NeutralType.DOUBLE, PRIMITIVE_TYPE ),        "float64", "float64");
		checkPrimitiveType( getType( NeutralType.DOUBLE, OBJECT_TYPE),            "float64", "float64" );
		checkPrimitiveType( getType( NeutralType.DOUBLE, SQL_TYPE),               "float64", "float64" );
		checkPrimitiveType( getType( NeutralType.DOUBLE, OBJECT_TYPE + SQL_TYPE), "float64", "float64" );
		checkPrimitiveType( getType( NeutralType.DOUBLE, NOT_NULL + OBJECT_TYPE), "float64", "float64" );
		checkPrimitiveType( getType( NeutralType.DOUBLE, NOT_NULL + SQL_TYPE),    "float64", "float64" );
		// UNSIGNED  : no difference 
		checkPrimitiveType( getType( NeutralType.DOUBLE, UNSIGNED_TYPE ),                  "float64", "float64");
		checkPrimitiveType( getType( NeutralType.DOUBLE, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "float64", "float64");
		checkPrimitiveType( getType( NeutralType.DOUBLE, OBJECT_TYPE + UNSIGNED_TYPE ),    "float64", "float64");
	}

	@Test
	public void testDecimal() {
		System.out.println("--- ");
		checkPrimitiveType( getType( NeutralType.DECIMAL, NONE ),                  "float64", "float64" );
		checkPrimitiveType( getType( NeutralType.DECIMAL, NOT_NULL ),              "float64", "float64");
		checkPrimitiveType( getType( NeutralType.DECIMAL, PRIMITIVE_TYPE ),        "float64", "float64");
		checkPrimitiveType( getType( NeutralType.DECIMAL, OBJECT_TYPE),            "float64", "float64" );
		checkPrimitiveType( getType( NeutralType.DECIMAL, SQL_TYPE),               "float64", "float64" );
		checkPrimitiveType( getType( NeutralType.DECIMAL, OBJECT_TYPE + SQL_TYPE), "float64", "float64" );
		checkPrimitiveType( getType( NeutralType.DECIMAL, NOT_NULL + OBJECT_TYPE), "float64", "float64" );
		checkPrimitiveType( getType( NeutralType.DECIMAL, NOT_NULL + SQL_TYPE),    "float64", "float64" );
		// UNSIGNED  : no difference 
		checkPrimitiveType( getType( NeutralType.DECIMAL, UNSIGNED_TYPE ),                  "float64", "float64");
		checkPrimitiveType( getType( NeutralType.DECIMAL, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "float64", "float64");
		checkPrimitiveType( getType( NeutralType.DECIMAL, OBJECT_TYPE + UNSIGNED_TYPE ),    "float64", "float64");
	}

	@Test
	public void testBinary() {
		System.out.println("--- ");
		checkPrimitiveType( getType( NeutralType.BINARY, NONE ),                  "[]byte", "[]byte" );
		checkPrimitiveType( getType( NeutralType.BINARY, NOT_NULL ),              "[]byte", "[]byte");
		checkPrimitiveType( getType( NeutralType.BINARY, PRIMITIVE_TYPE ),        "[]byte", "[]byte");
		checkPrimitiveType( getType( NeutralType.BINARY, OBJECT_TYPE),            "[]byte", "[]byte" );
		checkPrimitiveType( getType( NeutralType.BINARY, SQL_TYPE),               "[]byte", "[]byte" );
		checkPrimitiveType( getType( NeutralType.BINARY, OBJECT_TYPE + SQL_TYPE), "[]byte", "[]byte" );
		checkPrimitiveType( getType( NeutralType.BINARY, NOT_NULL + OBJECT_TYPE), "[]byte", "[]byte" );
		checkPrimitiveType( getType( NeutralType.BINARY, NOT_NULL + SQL_TYPE),    "[]byte", "[]byte" );
		// UNSIGNED  : no difference 
		checkPrimitiveType( getType( NeutralType.BINARY, UNSIGNED_TYPE ),                  "[]byte", "[]byte");
		checkPrimitiveType( getType( NeutralType.BINARY, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "[]byte", "[]byte");
		checkPrimitiveType( getType( NeutralType.BINARY, OBJECT_TYPE + UNSIGNED_TYPE ),    "[]byte", "[]byte");
	}

	@Test
	public void testDate() {
		System.out.println("--- ");
		// Go example :
		//   import "time" 
		//   x := time.Date(2009, 11, 17, 20, 34, 58, 651387237, time.UTC)
		checkObjectType( getType( NeutralType.DATE, NONE ),                           "Date", "time.Date" );
		checkObjectType( getType( NeutralType.DATE, NOT_NULL ),                       "Date", "time.Date" );
		checkObjectType( getType( NeutralType.DATE, PRIMITIVE_TYPE ),                 "Date", "time.Date" );
		checkObjectType( getType( NeutralType.DATE, OBJECT_TYPE),                     "Date", "time.Date" );
		checkObjectType( getType( NeutralType.DATE, SQL_TYPE),                        "Date", "time.Date" );
		checkObjectType( getType( NeutralType.DATE, OBJECT_TYPE + SQL_TYPE),          "Date", "time.Date" );
		checkObjectType( getType( NeutralType.DATE, NOT_NULL + OBJECT_TYPE),          "Date", "time.Date" );
		checkObjectType( getType( NeutralType.DATE, NOT_NULL + SQL_TYPE),             "Date", "time.Date" );
		checkObjectType( getType( NeutralType.DATE, UNSIGNED_TYPE ),                  "Date", "time.Date" );
		checkObjectType( getType( NeutralType.DATE, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "Date", "time.Date" );
		checkObjectType( getType( NeutralType.DATE, OBJECT_TYPE + UNSIGNED_TYPE ),    "Date", "time.Date" );
	}

	@Test
	public void testTime() {
		System.out.println("--- ");
		// Go example :
		//   import "time" 
		//   x := time.Date(2009, 11, 17, 20, 34, 58, 651387237, time.UTC)
		checkObjectType( getType( NeutralType.TIME, NONE ),                           "Time", "time.Time" );
		checkObjectType( getType( NeutralType.TIME, NOT_NULL ),                       "Time", "time.Time" );
		checkObjectType( getType( NeutralType.TIME, PRIMITIVE_TYPE ),                 "Time", "time.Time" );
		checkObjectType( getType( NeutralType.TIME, OBJECT_TYPE),                     "Time", "time.Time" );
		checkObjectType( getType( NeutralType.TIME, SQL_TYPE),                        "Time", "time.Time" );
		checkObjectType( getType( NeutralType.TIME, OBJECT_TYPE + SQL_TYPE),          "Time", "time.Time" );
		checkObjectType( getType( NeutralType.TIME, NOT_NULL + OBJECT_TYPE),          "Time", "time.Time" );
		checkObjectType( getType( NeutralType.TIME, NOT_NULL + SQL_TYPE),             "Time", "time.Time" );
		checkObjectType( getType( NeutralType.TIME, UNSIGNED_TYPE ),                  "Time", "time.Time" );
		checkObjectType( getType( NeutralType.TIME, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "Time", "time.Time" );
		checkObjectType( getType( NeutralType.TIME, OBJECT_TYPE + UNSIGNED_TYPE ),    "Time", "time.Time" );
	}

	@Test
	public void testTimestamp() {
		System.out.println("--- ");
//		TypeConverter tc = new TypeConverterForTypeScript() ;
//		
//		// Supposed to always return BigDecimal (in any cases) 
//		check( getType(tc, NeutralType.TIMESTAMP, NONE ), java.util.Date.class);
//		check( getType(tc, NeutralType.TIMESTAMP, NOT_NULL ), java.util.Date.class);
//		
//		check( getType(tc, NeutralType.TIMESTAMP, PRIMITIVE_TYPE ), java.util.Date.class);
//		check( getType(tc, NeutralType.TIMESTAMP, UNSIGNED_TYPE ), java.util.Date.class);
//		check( getType(tc, NeutralType.TIMESTAMP, PRIMITIVE_TYPE + UNSIGNED_TYPE ), java.util.Date.class);
//		
//		check( getType(tc, NeutralType.TIMESTAMP, OBJECT_TYPE ), java.util.Date.class);
//		check( getType(tc, NeutralType.TIMESTAMP, NOT_NULL + OBJECT_TYPE ), java.util.Date.class);
//
//		check( getType(tc, NeutralType.TIMESTAMP, SQL_TYPE ), java.sql.Timestamp.class);	 // SQL Time	
//		check( getType(tc, NeutralType.TIMESTAMP, NOT_NULL + SQL_TYPE ), java.sql.Timestamp.class); // SQL Time	
//		check( getType(tc, NeutralType.TIMESTAMP, OBJECT_TYPE + SQL_TYPE ), java.sql.Timestamp.class); // SQL Time	
//		check( getType(tc, NeutralType.TIMESTAMP, PRIMITIVE_TYPE + SQL_TYPE ), java.sql.Timestamp.class); // not compatible (no Prim type => SQL Time)	
	}

	@Test
	public void testPrimitiveTypes() {
		System.out.println("--- ");
//		TypeConverter tc = new TypeConverterForTypeScript() ;
//		LanguageType lt ;
//		
//		lt = getType(tc, NeutralType.BOOLEAN, PRIMITIVE_TYPE ) ;
//		assertEquals("boolean", lt.getSimpleType());
//		assertEquals("boolean", lt.getFullType());
//		assertEquals("Boolean", lt.getWrapperType());
//		assertTrue(lt.isPrimitiveType());
//		
//		lt = getType(tc, NeutralType.SHORT, PRIMITIVE_TYPE ) ;
//		assertEquals("short", lt.getSimpleType());
//		assertEquals("short", lt.getFullType());
//		assertEquals("Short", lt.getWrapperType());
//		assertTrue(lt.isPrimitiveType());
//
//		lt = getType(tc, NeutralType.INTEGER, PRIMITIVE_TYPE ) ;
//		assertEquals("int", lt.getSimpleType());
//		assertEquals("int", lt.getFullType());
//		assertEquals("Integer", lt.getWrapperType());
//		assertTrue(lt.isPrimitiveType());
//
//		lt = getType(tc, NeutralType.LONG, PRIMITIVE_TYPE ) ;
//		assertEquals("long", lt.getSimpleType());
//		assertEquals("long", lt.getFullType());
//		assertEquals("Long", lt.getWrapperType());
//		assertTrue(lt.isPrimitiveType());
	}
	
	@Test
	public void testObjectTypes() {
		System.out.println("--- ");
//		TypeConverter tc = new TypeConverterForTypeScript() ;
//		LanguageType lt ;
//		
//		lt = getType(tc, NeutralType.BOOLEAN, OBJECT_TYPE ) ;
//		assertEquals("Boolean", lt.getSimpleType());
//		assertEquals("java.lang.Boolean", lt.getFullType());
//		assertEquals("Boolean", lt.getWrapperType());
//		assertFalse(lt.isPrimitiveType());
//
//		lt = getType(tc, NeutralType.SHORT, OBJECT_TYPE ) ;
//		assertEquals("Short", lt.getSimpleType());
//		assertEquals("java.lang.Short", lt.getFullType());
//		assertEquals("Short", lt.getWrapperType());
//		assertFalse(lt.isPrimitiveType());
//
//		lt = getType(tc, NeutralType.INTEGER, OBJECT_TYPE ) ;
//		assertEquals("Integer", lt.getSimpleType());
//		assertEquals("java.lang.Integer", lt.getFullType());
//		assertEquals("Integer", lt.getWrapperType());
//		assertFalse(lt.isPrimitiveType());
//
	}
}
