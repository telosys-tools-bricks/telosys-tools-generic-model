package org.telosys.tools.generic.model.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.telosys.tools.generic.model.DateType;

public class TypeReverserTest {

	private void check(String javaType, DateType dateType, String expectedType) {
		TypeReverser typeReverser = new TypeReverser() ;
		
		String nt = typeReverser.getNeutralType(javaType, dateType);
		System.out.println("'" + javaType + "' ( " + dateType + " ) --> " + nt );
		assertEquals(expectedType, nt);
		assertFalse(false);
		assertTrue(true);
	}
	
	@Test
	public void test1() {
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

		check ( "java.nio.ByteBuffer", DateType.UNDEFINED, NeutralType.BINARY ) ;

		check ( "java.sql.Date", DateType.UNDEFINED, NeutralType.DATE ) ;
		check ( "java.sql.Time", DateType.UNDEFINED, NeutralType.TIME ) ;
		check ( "java.sql.Timestamp", DateType.UNDEFINED, NeutralType.TIMESTAMP ) ;
		check ( "java.sql.Clob", DateType.UNDEFINED, NeutralType.LONGTEXT ) ;
		check ( "java.sql.Blob", DateType.UNDEFINED, NeutralType.BINARY ) ;		
	}

	@Test
	public void test2() {
		System.out.println("---");
		check ( "boolean", DateType.UNDEFINED, NeutralType.BOOLEAN ) ;
		check ( "byte", DateType.UNDEFINED, NeutralType.BYTE ) ;
		check ( "short", DateType.UNDEFINED, NeutralType.SHORT ) ;
		check ( "int", DateType.UNDEFINED, NeutralType.INTEGER ) ;
		check ( "long", DateType.UNDEFINED, NeutralType.LONG ) ;
		check ( "float", DateType.UNDEFINED, NeutralType.FLOAT ) ;
		check ( "double", DateType.UNDEFINED, NeutralType.DOUBLE ) ;
		check ( "byte[]", DateType.UNDEFINED, NeutralType.BINARY ) ;
	}

}
