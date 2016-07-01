package org.telosys.tools.generic.model.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.telosys.tools.generic.model.DateType;

public class TypeReverserTest {

	private void check(String javaType, DateType dateType, String expectedType) {
		
		TypeReverser typeReverser = TypeReverser.getInstance() ;
		
		String nt = typeReverser.getNeutralType(javaType, dateType);
		System.out.println("'" + javaType + "' ( " + dateType + " ) --> " + nt );
		assertNotNull(nt);
		assertEquals(expectedType, nt);
		assertFalse(false);
		assertTrue(true);
	}
	
	private void checkTypeInfo(String javaType, AttributeTypeInfo expectedTypeInfo) {
		
		TypeReverser typeReverser = TypeReverser.getInstance() ;
		
		AttributeTypeInfo r = typeReverser.getTypeInfo(javaType);
		System.out.println("'" + javaType + "' --> " + r );
		assertNotNull(r);
		// compare with expected result
		assertEquals(expectedTypeInfo.isPrimitiveTypeExpected(), r.isPrimitiveTypeExpected());
		assertEquals(expectedTypeInfo.isUnsignedTypeExpected(),  r.isUnsignedTypeExpected());
		assertEquals(expectedTypeInfo.isObjectTypeExpected(),    r.isObjectTypeExpected());
		assertEquals(expectedTypeInfo.isSqlTypeExpected(),       r.isSqlTypeExpected());
	}
	
	@Test
	public void test1() {
		System.out.println("---");
		check ( "boolean", DateType.UNDEFINED, NeutralType.BOOLEAN ) ;
		check ( "byte",    DateType.UNDEFINED, NeutralType.BYTE ) ;
		check ( "short",   DateType.UNDEFINED, NeutralType.SHORT ) ;
		check ( "int",     DateType.UNDEFINED, NeutralType.INTEGER ) ;
		check ( "long",    DateType.UNDEFINED, NeutralType.LONG ) ;
		check ( "float",   DateType.UNDEFINED, NeutralType.FLOAT ) ;
		check ( "double",  DateType.UNDEFINED, NeutralType.DOUBLE ) ;
		check ( "byte[]",  DateType.UNDEFINED, NeutralType.BINARY ) ;
	}
	
	@Test
	public void test2() {
		System.out.println("---");
		check ( "boolean", null, NeutralType.BOOLEAN ) ;
		check ( "byte",    null, NeutralType.BYTE ) ;
		check ( "short",   null, NeutralType.SHORT ) ;
		check ( "int",     null, NeutralType.INTEGER ) ;
		check ( "long",    null, NeutralType.LONG ) ;
		check ( "float",   null, NeutralType.FLOAT ) ;
		check ( "double",  null, NeutralType.DOUBLE ) ;
		check ( "byte[]",  null, NeutralType.BINARY ) ;
	}
	
	@Test
	public void test3() {
		System.out.println("---");
		check ( "java.lang.String", DateType.UNDEFINED, NeutralType.STRING ) ;
		check ( "java.lang.Boolean", DateType.UNDEFINED, NeutralType.BOOLEAN ) ;
		check ( "java.lang.Byte", DateType.UNDEFINED, NeutralType.BYTE ) ;
		check ( "java.lang.Short", DateType.UNDEFINED, NeutralType.SHORT ) ;
		check ( "java.lang.Integer", DateType.UNDEFINED, NeutralType.INTEGER ) ;
		check ( "java.lang.Long", DateType.UNDEFINED, NeutralType.LONG ) ;
		check ( "java.lang.Float", DateType.UNDEFINED, NeutralType.FLOAT ) ;
		check ( "java.lang.Double", DateType.UNDEFINED, NeutralType.DOUBLE ) ;
		check ( "java.math.BigDecimal", DateType.UNDEFINED, NeutralType.DECIMAL ) ;
		
		check ( "java.util.Date", DateType.UNDEFINED, NeutralType.DATE ) ;
		check ( "java.util.Date", DateType.DATE_ONLY, NeutralType.DATE ) ;
		check ( "java.util.Date", DateType.TIME_ONLY, NeutralType.TIME ) ;
		check ( "java.util.Date", DateType.DATE_AND_TIME, NeutralType.TIMESTAMP ) ;

//		check ( "java.nio.ByteBuffer", DateType.UNDEFINED, NeutralType.BINARY ) ;

		check ( "java.sql.Date", DateType.UNDEFINED, NeutralType.DATE ) ;
		check ( "java.sql.Time", DateType.UNDEFINED, NeutralType.TIME ) ;
		check ( "java.sql.Timestamp", DateType.UNDEFINED, NeutralType.TIMESTAMP ) ;
//		check ( "java.sql.Clob", DateType.UNDEFINED, NeutralType.LONGTEXT ) ;
		check ( "java.sql.Clob", DateType.UNDEFINED, NeutralType.STRING ) ;
		check ( "java.sql.Blob", DateType.UNDEFINED, NeutralType.BINARY ) ;
	}

	@Test
	public void test4() {
		System.out.println("---");
		check ( "java.lang.String",  null, NeutralType.STRING ) ;
		check ( "java.lang.Boolean", null, NeutralType.BOOLEAN ) ;
		check ( "java.lang.Byte",    null, NeutralType.BYTE ) ;
		check ( "java.lang.Short",   null, NeutralType.SHORT ) ;
		check ( "java.lang.Integer", null, NeutralType.INTEGER ) ;
		check ( "java.lang.Long",    null, NeutralType.LONG ) ;
		check ( "java.lang.Float",   null, NeutralType.FLOAT ) ;
		check ( "java.lang.Double",   null, NeutralType.DOUBLE ) ;
		check ( "java.math.BigDecimal", null, NeutralType.DECIMAL ) ;
		
		check ( "java.util.Date", null, NeutralType.DATE ) ;

//		check ( "java.nio.ByteBuffer", null, NeutralType.BINARY ) ;

		check ( "java.sql.Date", null, NeutralType.DATE ) ;
		check ( "java.sql.Time", null, NeutralType.TIME ) ;
		check ( "java.sql.Timestamp", null, NeutralType.TIMESTAMP ) ;
//		check ( "java.sql.Clob", null, NeutralType.LONGTEXT ) ;
		check ( "java.sql.Clob", null, NeutralType.STRING ) ;
		check ( "java.sql.Blob", null, NeutralType.BINARY ) ;
	}

	@Test
	public void test10() {
		System.out.println("---");
		
		AttributeTypeInfo primitiveType = new AttributeTypeInfo( "", AttributeTypeInfo.PRIMITIVE_TYPE );
		AttributeTypeInfo objectType = new AttributeTypeInfo( "", AttributeTypeInfo.OBJECT_TYPE );
		AttributeTypeInfo sqlType    = new AttributeTypeInfo( "", AttributeTypeInfo.SQL_TYPE );
		
		checkTypeInfo("boolean", primitiveType  ) ;
		checkTypeInfo("byte", primitiveType  ) ;
		checkTypeInfo("short", primitiveType  ) ;
		checkTypeInfo("int", primitiveType  ) ;
		checkTypeInfo("long", primitiveType  ) ;
		checkTypeInfo("float", primitiveType  ) ;
		checkTypeInfo("double", primitiveType  ) ;
		checkTypeInfo("byte[]", primitiveType  ) ;

		checkTypeInfo("java.lang.String", objectType  ) ;
		checkTypeInfo("java.lang.Boolean", objectType  ) ;
		checkTypeInfo("java.lang.Byte", objectType  ) ;
		checkTypeInfo("java.lang.Short", objectType  ) ;
		checkTypeInfo("java.lang.Integer", objectType  ) ;
		// checkTypeInfo("java.lang.String", new AttributeTypeInfo("", AttributeTypeInfo.PRIMITIVE_TYPE )  ) ;
		checkTypeInfo("java.math.BigDecimal", objectType  ) ;

		checkTypeInfo("java.sql.Date", sqlType  ) ;
		checkTypeInfo("java.sql.Time", sqlType  ) ;
		checkTypeInfo("java.sql.Timestamp", sqlType  ) ;
	}
}
