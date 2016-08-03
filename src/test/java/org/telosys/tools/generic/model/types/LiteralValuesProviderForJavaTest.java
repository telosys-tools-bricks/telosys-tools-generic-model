package org.telosys.tools.generic.model.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class LiteralValuesProviderForJavaTest {
	
	private void setByte(byte v)   { /* nothing */ } 
	private void setShort(short v) { /* nothing */ } 
	private void setInt(int v)     { /* nothing */ } 
	private void setLong(long v)   { /* nothing */ } 

	private void setByteObj(Byte v)   { /* nothing */ } 
	private void setShortObj(Short v) { /* nothing */ } 
	private void setIntObj(Integer v)     { /* nothing */ } 
	private void setLongObj(Long v)   { /* nothing */ } 

	@Test
	public void testLiteral() {
		setByte((byte)12);
		setShort((short)12);
		setInt(12);
		setLong(12L);
		
		setByteObj((byte)12);
		setShortObj((short)12);
		setIntObj(12);
		setLongObj(12L);
		
		byte  b =  12;
		System.out.println("b = " + b);
		Byte  b2 =  127 ; // Byte.MAX_VALUE;
		//Byte  b3 =  128 ; // Too high
		System.out.println("b2 = " + b2);
		
		short sh = (short)12;
		System.out.println("sh = " + sh + " MAX = " + Short.MAX_VALUE );
		
		float  f = 12345.60F ;
		System.out.println("f = " + f);
		f = 12345F ;
		System.out.println("f = " + f);
		
		double d = 456.89D ;
		System.out.println("d = " + d);

		long   l = 12345L ;
		System.out.println("l = " + l);

		
		BigDecimal bigDecimal = (new BigDecimal(12345678.5));
		System.out.println("bigDecimal = " + bigDecimal);

		
		java.util.Date utilDate = Calendar.getInstance().getTime() ;
		System.out.println("utilDate = " + utilDate);
		//(new SimpleDateFormat("yyyy-MM-dd")).parse("1901-01-01");

		java.sql.Date sqlDate = (new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		System.out.println("sqlDate = " + sqlDate);

		java.sql.Time sqlTime = (new java.sql.Time(Calendar.getInstance().getTime().getTime()));
		System.out.println("sqlTime = " + sqlTime);

		java.sql.Timestamp sqlTimestamp = (new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
		System.out.println("sqlTimestamp = " + sqlTimestamp);
	}

	@Test
	public void testCompare() {
		
		byte  b =  12;
		System.out.println("b = " + b);
		Byte  b2 =  34;
		Assert.assertTrue( b2 == 34 ) ;
		
		Float  f = 12345.60F ;
		Assert.assertTrue( f == 12345.60F ) ;
		
		Double d = 456.89D ;
		Assert.assertTrue( d == 456.89D ) ;

		Long   l = 12345L ;
		Assert.assertTrue( l == 12345L ) ;

		BigDecimal bigDecimal = (new BigDecimal(12345678.5));
		Assert.assertTrue( bigDecimal.equals( (new BigDecimal(12345678.5)) ) ) ;
		//System.out.println("bigDecimal = " + bigDecimal);

	}

	@Test
	public void testLiteralNull() {

		LiteralValuesProvider  literalValuesProvider = new LiteralValuesProviderForJava();
		assertEquals("null", literalValuesProvider.getLiteralNull() ) ;
	}
	
	private LanguageType buildLanguageType(String neutralType, Class<?> clazz ) {
		LanguageType languageType = new LanguageType(neutralType, clazz.getSimpleName(), clazz.getCanonicalName(), clazz.isPrimitive(), clazz.getSimpleName());
		System.out.println("LanguageType : " + languageType );
		return languageType ;
	}
	
	//-------------------------------------------------------------------------------------------

	private void checkEqualsStatement(String value, Class<?> clazz, String expected ) {
		LanguageType languageType = buildLanguageType("", clazz); // Neutral type is not used
		LiteralValuesProvider  literalValuesProvider = new LiteralValuesProviderForJava();
		String equalsStatement = literalValuesProvider.getEqualsStatement(value, languageType) ;
		System.out.println("Equals statement : '" + equalsStatement + "'" );
		assertEquals(expected, equalsStatement ) ;
	}
	
	@Test
	public void testEqualsStatement() {

		// booleans
		boolean  bool1 = false ;  
		assertTrue( bool1 == false ) ;
		checkEqualsStatement("true", boolean.class, " == true");
		
		Boolean  bool2 = true ;   
		assertTrue( bool2 == true ) ;
		assertTrue( bool2.equals(true)) ;
		checkEqualsStatement("true", java.lang.Boolean.class, ".equals(true)");

		// numbers
		int i = 123 ; 
		assertTrue( i == 123 ) ;
		checkEqualsStatement("123",  int.class,     " == 123");
		Integer i2 = 456 ;
		assertTrue( i2 == 456 ) ;
		assertTrue( i2.equals(456) ) ;
		checkEqualsStatement("456", java.lang.Integer.class, ".equals(456)");
		
		java.math.BigDecimal bd = new BigDecimal(1234567890);
		assertTrue( bd.equals((new BigDecimal(1234567890))) ) ;
		checkEqualsStatement("(new BigDecimal(1234567890))", java.math.BigDecimal.class, ".equals((new BigDecimal(1234567890)))");

		// strings
		String s = "ABC" ;
		assertTrue( s.equals("ABC") ) ;
		checkEqualsStatement("\"ABC\"", java.lang.String.class, ".equals(\"ABC\")");
	}

	//-------------------------------------------------------------------------------------------
	
	private void checkLiteralValue(Class<?> clazz, int maxLength, int step, String expected ) {
		checkLiteralValue("", clazz, maxLength, step, expected );
	}
	private void checkLiteralValue(String neutralType, Class<?> clazz, int maxLength, int step, String expected ) {
		LanguageType languageType = buildLanguageType(neutralType, clazz);
		LiteralValuesProvider  literalValuesProvider = new LiteralValuesProviderForJava();
		String value = literalValuesProvider.generateLiteralValue(languageType, maxLength, step);
		System.out.println("Literal value : '" + value + "'" );
		assertEquals(expected, value ) ;
	}

	@Test
	public void testBooleanValues() {

		checkLiteralValue(boolean.class, 0, 1, "true");
		checkLiteralValue(boolean.class, 0, 2, "false");
		checkLiteralValue(boolean.class, 0, 3, "true");
		checkLiteralValue(boolean.class, 0, 4, "false");
		checkLiteralValue(boolean.class, 0, 5, "true");
	}
	
	@Test
	public void testStringValues() {
		checkLiteralValue(String.class, 5,  0, "\"AAAAA\""); // step 0 
		
		checkLiteralValue(String.class, 5,  1, "\"AAAAA\""); // start with "A"
		checkLiteralValue(String.class, 5,  2, "\"BBBBB\"");
		checkLiteralValue(String.class, 5, 26, "\"ZZZZZ\"");  // MAX STEP
		
		checkLiteralValue(String.class, 5, 27, "\"AAAAA\"");  // restart with "A"
		checkLiteralValue(String.class, 5, 28, "\"BBBBB\"");
		checkLiteralValue(String.class, 5, 52, "\"ZZZZZ\"");  // MAX STEP
		
		checkLiteralValue(String.class, 5, 53, "\"AAAAA\"");  // restart with "A"		

		checkLiteralValue(String.class, 0,  1, "\"\""); 
		checkLiteralValue(String.class, 1,  1, "\"A\""); 
		checkLiteralValue(String.class, 2,  1, "\"AA\""); 
	}
	
	@Test
	public void testNumberValues() {
		
		// primitive types

		checkLiteralValue(byte.class, 0, 0, "(byte)0");
		checkLiteralValue(byte.class, 0, 1, "(byte)1");
		checkLiteralValue(byte.class, 0, 2, "(byte)2");

		checkLiteralValue(short.class, 0, 1, "(short)1");
		checkLiteralValue(short.class, 0, 2, "(short)2");
		checkLiteralValue(short.class, 0, 32767, "(short)32767"); // MAX VALUE
		checkLiteralValue(short.class, 0, 32768, "(short)1"); // restart with % 32767 --> 1

		checkLiteralValue(int.class, 0, 0, "0");
		checkLiteralValue(int.class, 0, 1, "100");
		checkLiteralValue(int.class, 0, 2, "200");

		checkLiteralValue(long.class, 0, 0, "0L");
		checkLiteralValue(long.class, 0, 1, "1000L");
		checkLiteralValue(long.class, 0, 2, "2000L");

		checkLiteralValue(float.class, 0, 0, "0.5F");
		checkLiteralValue(float.class, 0, 1, "1000.5F");
		checkLiteralValue(float.class, 0, 2, "2000.5F");

		checkLiteralValue(double.class, 0, 0, "0.66D");
		checkLiteralValue(double.class, 0, 1, "1000.66D");
		checkLiteralValue(double.class, 0, 2, "2000.66D");
		
		// wrapper types
		
		checkLiteralValue(Byte.class, 0,   0, "(byte)0");
		checkLiteralValue(Byte.class, 0,   1, "(byte)1");
		checkLiteralValue(Byte.class, 0,   2, "(byte)2");
		checkLiteralValue(Byte.class, 0, 127, "(byte)127"); // MAX VALUE
		checkLiteralValue(Byte.class, 0, 128, "(byte)1"); // restart with % 127 --> 1
		checkLiteralValue(Byte.class, 0, 253, "(byte)126"); 
		checkLiteralValue(Byte.class, 0, 254, "(byte)127"); // MAX VALUE BIS 
		checkLiteralValue(Byte.class, 0, 255, "(byte)1"); // restart with % 127 --> 1

		checkLiteralValue(Short.class, 0, 0, "(short)0");
		checkLiteralValue(Short.class, 0, 1, "(short)1");
		checkLiteralValue(Short.class, 0, 2, "(short)2");

		checkLiteralValue(Integer.class, 0, 0, "0");
		checkLiteralValue(Integer.class, 0, 1, "100");
		checkLiteralValue(Integer.class, 0, 2, "200");
		checkLiteralValue(Integer.class, 0, 2000, "200000");
		checkLiteralValue(Integer.class, 0, 2000000, "200000000");

		checkLiteralValue(Long.class, 0, 0, "0L");
		checkLiteralValue(Long.class, 0, 1, "1000L");
		checkLiteralValue(Long.class, 0, 2, "2000L");

		checkLiteralValue(Float.class, 0, 0, "0.5F");
		checkLiteralValue(Float.class, 0, 1, "1000.5F");
		checkLiteralValue(Float.class, 0, 2, "2000.5F");

		checkLiteralValue(Double.class, 0, 0, "0.66D");
		checkLiteralValue(Double.class, 0, 1, "1000.66D");
		checkLiteralValue(Double.class, 0, 2, "2000.66D");
		
		checkLiteralValue(BigDecimal.class, 0, 0, "(new BigDecimal(0))");
		checkLiteralValue(BigDecimal.class, 0, 1, "(new BigDecimal(10000))");
		checkLiteralValue(BigDecimal.class, 0, 2, "(new BigDecimal(20000))");
	}

	@Test
	public void testUtilDateValues() {
		
		java.util.Date d = java.sql.Date.valueOf("2000-06-22");
		System.out.println(" d = " + d);
		checkLiteralValue(java.util.Date.class, 0,    0, "java.sql.Date.valueOf(\"2000-06-22\")");
		checkLiteralValue(java.util.Date.class, 0,    1, "java.sql.Date.valueOf(\"2001-06-22\")");
		checkLiteralValue(java.util.Date.class, 0,    2, "java.sql.Date.valueOf(\"2002-06-22\")");
		checkLiteralValue(java.util.Date.class, 0,  999, "java.sql.Date.valueOf(\"2999-06-22\")");
		checkLiteralValue(java.util.Date.class, 0, 1000, "java.sql.Date.valueOf(\"3000-06-22\")");

		checkLiteralValue(NeutralType.DATE, java.util.Date.class, 0,    0, "java.sql.Date.valueOf(\"2000-06-22\")");
		checkLiteralValue(NeutralType.DATE, java.util.Date.class, 0,    1, "java.sql.Date.valueOf(\"2001-06-22\")");
		checkLiteralValue(NeutralType.DATE, java.util.Date.class, 0,    2, "java.sql.Date.valueOf(\"2002-06-22\")");
		checkLiteralValue(NeutralType.DATE, java.util.Date.class, 0,  999, "java.sql.Date.valueOf(\"2999-06-22\")");
		checkLiteralValue(NeutralType.DATE, java.util.Date.class, 0, 1000, "java.sql.Date.valueOf(\"3000-06-22\")");

		java.util.Date t1 = java.sql.Time.valueOf("00:46:52");
		System.out.println(" t1 = " + t1);
		SimpleDateFormat fmt = new SimpleDateFormat("dd MMM yyyy HH:mm:ss"); // 01 janv. 1970 00:46:52
		System.out.println(" t1 = " + fmt.format(t1));

		java.sql.Time t2 = java.sql.Time.valueOf("00:46:52") ;
		System.out.println(" t2 = " + t2);
		checkLiteralValue(NeutralType.TIME, java.util.Date.class, 0,    0, "java.sql.Time.valueOf(\"00:46:52\")");
		checkLiteralValue(NeutralType.TIME, java.util.Date.class, 0,    1, "java.sql.Time.valueOf(\"01:46:52\")");
		checkLiteralValue(NeutralType.TIME, java.util.Date.class, 0,    2, "java.sql.Time.valueOf(\"02:46:52\")");
		checkLiteralValue(NeutralType.TIME, java.util.Date.class, 0,   23, "java.sql.Time.valueOf(\"23:46:52\")");
		checkLiteralValue(NeutralType.TIME, java.util.Date.class, 0,   24, "java.sql.Time.valueOf(\"00:46:52\")");
		checkLiteralValue(NeutralType.TIME, java.util.Date.class, 0,   25, "java.sql.Time.valueOf(\"01:46:52\")");
		checkLiteralValue(NeutralType.TIME, java.util.Date.class, 0,   47, "java.sql.Time.valueOf(\"23:46:52\")");
		checkLiteralValue(NeutralType.TIME, java.util.Date.class, 0,   48, "java.sql.Time.valueOf(\"00:46:52\")");

		java.util.Date ts = java.sql.Timestamp.valueOf("2000-05-21 00:46:52");
		System.out.println(" ts = " + ts);
		checkLiteralValue(NeutralType.TIMESTAMP, java.util.Date.class, 0,    0, "java.sql.Timestamp.valueOf(\"2000-05-21 00:46:52\")");
		checkLiteralValue(NeutralType.TIMESTAMP, java.util.Date.class, 0,    1, "java.sql.Timestamp.valueOf(\"2001-05-21 01:46:52\")");
		checkLiteralValue(NeutralType.TIMESTAMP, java.util.Date.class, 0,    2, "java.sql.Timestamp.valueOf(\"2002-05-21 02:46:52\")");
		checkLiteralValue(NeutralType.TIMESTAMP, java.util.Date.class, 0,   23, "java.sql.Timestamp.valueOf(\"2023-05-21 23:46:52\")");
		checkLiteralValue(NeutralType.TIMESTAMP, java.util.Date.class, 0,   24, "java.sql.Timestamp.valueOf(\"2024-05-21 00:46:52\")");
	}

	@Test
	public void testSqlDateValues() {
		
		java.sql.Date d2 = java.sql.Date.valueOf("2001-06-22");
		System.out.println(" d2 = " + d2);
		checkLiteralValue(java.sql.Date.class, 0,    0, "java.sql.Date.valueOf(\"2000-06-22\")");
		checkLiteralValue(java.sql.Date.class, 0,    1, "java.sql.Date.valueOf(\"2001-06-22\")");
		checkLiteralValue(java.sql.Date.class, 0,    2, "java.sql.Date.valueOf(\"2002-06-22\")");
		checkLiteralValue(java.sql.Date.class, 0,  999, "java.sql.Date.valueOf(\"2999-06-22\")");
		checkLiteralValue(java.sql.Date.class, 0, 1000, "java.sql.Date.valueOf(\"3000-06-22\")");

		java.sql.Time t1 = java.sql.Time.valueOf("00:46:52");
		System.out.println(" t1 = " + t1);
		SimpleDateFormat fmt = new SimpleDateFormat("dd MMM yyyy HH:mm:ss"); // 01 janv. 1970 00:46:52
		System.out.println(" t1 = " + fmt.format(t1));

		java.sql.Time t2 = java.sql.Time.valueOf("00:46:52") ;
		System.out.println(" t2 = " + t2);
		checkLiteralValue(java.sql.Time.class, 0,    0, "java.sql.Time.valueOf(\"00:46:52\")");
		checkLiteralValue(java.sql.Time.class, 0,    1, "java.sql.Time.valueOf(\"01:46:52\")");
		checkLiteralValue(java.sql.Time.class, 0,    2, "java.sql.Time.valueOf(\"02:46:52\")");
		checkLiteralValue(java.sql.Time.class, 0,   23, "java.sql.Time.valueOf(\"23:46:52\")");
		checkLiteralValue(java.sql.Time.class, 0,   24, "java.sql.Time.valueOf(\"00:46:52\")");
		checkLiteralValue(java.sql.Time.class, 0,   25, "java.sql.Time.valueOf(\"01:46:52\")");
		checkLiteralValue(java.sql.Time.class, 0,   47, "java.sql.Time.valueOf(\"23:46:52\")");
		checkLiteralValue(java.sql.Time.class, 0,   48, "java.sql.Time.valueOf(\"00:46:52\")");

		java.sql.Timestamp ts = java.sql.Timestamp.valueOf("2000-05-21 00:46:52");
		System.out.println(" ts = " + ts);
		checkLiteralValue(java.sql.Timestamp.class, 0,    0, "java.sql.Timestamp.valueOf(\"2000-05-21 00:46:52\")");
		checkLiteralValue(java.sql.Timestamp.class, 0,    1, "java.sql.Timestamp.valueOf(\"2001-05-21 01:46:52\")");
		checkLiteralValue(java.sql.Timestamp.class, 0,    2, "java.sql.Timestamp.valueOf(\"2002-05-21 02:46:52\")");
		checkLiteralValue(java.sql.Timestamp.class, 0,   23, "java.sql.Timestamp.valueOf(\"2023-05-21 23:46:52\")");
		checkLiteralValue(java.sql.Timestamp.class, 0,   24, "java.sql.Timestamp.valueOf(\"2024-05-21 00:46:52\")");
	}

	@Test
	public void testInvalidTypes() {
		checkLiteralValue(java.math.BigInteger.class, 0,    0, "null");
		checkLiteralValue(java.util.Calendar.class,   0,    0, "null");
		checkLiteralValue(byte[].class,               0,    0, "null");
	}
	
}
