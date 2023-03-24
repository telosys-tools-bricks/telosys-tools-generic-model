package org.telosys.tools.generic.model.languages.literals;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.telosys.tools.commons.JavaTypeUtil;
import org.telosys.tools.generic.model.languages.literals.LiteralValue;
import org.telosys.tools.generic.model.languages.literals.LiteralValuesProvider;
import org.telosys.tools.generic.model.languages.literals.LiteralValuesProviderForJava;
import org.telosys.tools.generic.model.languages.types.LanguageType;
import org.telosys.tools.generic.model.languages.types.LanguageTypeBuilder;
import org.telosys.tools.generic.model.languages.types.TypeConverterForJava;
import org.telosys.tools.generic.model.types.NeutralType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void testEqualsStatement() {
		LiteralValuesProvider  literalValuesProvider = new LiteralValuesProviderForJava();

		// booleans
		boolean  bool1 = false ;  
		assertTrue( bool1 == false ) ;
		//literalValuesProvider.getEqualsStatement("true", buildLanguagePrimitiveType("", "boolean")) ;
		assertEquals(" == true", literalValuesProvider.getEqualsStatement("true", buildFakeLanguageTypePrimitive())  ) ;
		//checkEqualsStatement("true", boolean.class, " == true");
		
		Boolean  bool2 = true ;   
		assertTrue( bool2 == true ) ;
		assertTrue( bool2.equals(true)) ;
//		checkEqualsStatement("true", java.lang.Boolean.class, ".equals(true)");
		assertEquals(".equals(true)", literalValuesProvider.getEqualsStatement("true", buildFakeLanguageTypeObject())  ) ;

		// numbers
		int i = 123 ; 
		assertTrue( i == 123 ) ;
//		checkEqualsStatement("123",  int.class,     " == 123");
		assertEquals(" == 123", literalValuesProvider.getEqualsStatement("123", buildFakeLanguageTypePrimitive())  ) ;
		Integer i2 = 456 ;
		assertTrue( i2 == 456 ) ;
		assertTrue( i2.equals(456) ) ;
//		checkEqualsStatement("456", java.lang.Integer.class, ".equals(456)");
		assertEquals(".equals(456)", literalValuesProvider.getEqualsStatement("456", buildFakeLanguageTypeObject())  ) ;
		
		java.math.BigDecimal bd = new BigDecimal(1234567890);
		assertTrue( bd.equals((new BigDecimal(1234567890))) ) ;
//		checkEqualsStatement("(new BigDecimal(1234567890))", java.math.BigDecimal.class, ".equals((new BigDecimal(1234567890)))");
		assertEquals(".equals((new BigDecimal(1234567890)))", literalValuesProvider.getEqualsStatement("(new BigDecimal(1234567890))", buildFakeLanguageTypeObject())  ) ;

		// strings
		String s = "ABC" ;
		assertTrue( s.equals("ABC") ) ;
//		checkEqualsStatement("\"ABC\"", java.lang.String.class, ".equals(\"ABC\")");
		assertEquals(".equals(\"ABC\")", literalValuesProvider.getEqualsStatement("\"ABC\"", buildFakeLanguageTypeObject())  ) ;
	}

	//-------------------------------------------------------------------------------------------
	
	private void checkLiteralValue(Class<?> clazz, int maxLength, int step, String expected ) {
		checkLiteralValue("", clazz, maxLength, step, expected );
	}
	private void checkLiteralValue(String neutralType, Class<?> clazz, int maxLength, int step, String expected ) {
		// LanguageType languageType = buildLanguageObjectType(neutralType, clazz);
		LanguageType languageType = LanguageTypeBuilder.build(neutralType, clazz.getSimpleName(), clazz.getCanonicalName(), clazz.isPrimitive(), clazz.getSimpleName() );
		checkLiteralValue(languageType, maxLength, step, expected );
	}
	private void checkLiteralValue(LanguageType languageType, int maxLength, int step, String expected ) {
		LiteralValuesProvider  literalValuesProvider = new LiteralValuesProviderForJava();
		LiteralValue value = literalValuesProvider.generateLiteralValue(languageType, maxLength, step);
		System.out.println("Literal value : '" + value + "'" );
		assertEquals(expected, value.getCurrentLanguageValue() ) ;
	}

	@Test
	public void testBooleanValues() {

		checkLiteralValue(boolean.class, 0, 1, "true");
		checkLiteralValue(boolean.class, 0, 2, "false");
		checkLiteralValue(boolean.class, 0, 3, "true");
		checkLiteralValue(boolean.class, 0, 4, "false");
		checkLiteralValue(boolean.class, 0, 5, "true");

		checkLiteralValue(Boolean.class, 0, 1, "Boolean.valueOf(true)"  );
		checkLiteralValue(Boolean.class, 0, 2, "Boolean.valueOf(false)" );
		checkLiteralValue(Boolean.class, 0, 3, "Boolean.valueOf(true)"  );
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
		
		checkLiteralValue(Byte.class, 0,   0, "Byte.valueOf((byte)0)");
		checkLiteralValue(Byte.class, 0,   1, "Byte.valueOf((byte)1)");
		checkLiteralValue(Byte.class, 0,   2, "Byte.valueOf((byte)2)");
		checkLiteralValue(Byte.class, 0, 127, "Byte.valueOf((byte)127)"); // MAX VALUE
		checkLiteralValue(Byte.class, 0, 128, "Byte.valueOf((byte)1)"); // restart with % 127 --> 1
		checkLiteralValue(Byte.class, 0, 253, "Byte.valueOf((byte)126)"); 
		checkLiteralValue(Byte.class, 0, 254, "Byte.valueOf((byte)127)"); // MAX VALUE BIS 
		checkLiteralValue(Byte.class, 0, 255, "Byte.valueOf((byte)1)"); // restart with % 127 --> 1

		checkLiteralValue(Short.class, 0, 0, "Short.valueOf((short)0)" );
		checkLiteralValue(Short.class, 0, 1, "Short.valueOf((short)1)" );
		checkLiteralValue(Short.class, 0, 2, "Short.valueOf((short)2)" );

		checkLiteralValue(Integer.class, 0, 0, "Integer.valueOf(0)");
		checkLiteralValue(Integer.class, 0, 1, "Integer.valueOf(100)");
		checkLiteralValue(Integer.class, 0, 2, "Integer.valueOf(200)");
		checkLiteralValue(Integer.class, 0, 2000, "Integer.valueOf(200000)");
		checkLiteralValue(Integer.class, 0, 2000000, "Integer.valueOf(200000000)");

		checkLiteralValue(Long.class, 0, 0, "Long.valueOf(0L)"     );
		checkLiteralValue(Long.class, 0, 1, "Long.valueOf(1000L)"  );
		checkLiteralValue(Long.class, 0, 2, "Long.valueOf(2000L)"  );

		checkLiteralValue(Float.class, 0, 0, "Float.valueOf(0.5F)"    );
		checkLiteralValue(Float.class, 0, 1, "Float.valueOf(1000.5F)" );
		checkLiteralValue(Float.class, 0, 2, "Float.valueOf(2000.5F)" );

		checkLiteralValue(Double.class, 0, 0, "Double.valueOf(0.66D)"    );
		checkLiteralValue(Double.class, 0, 1, "Double.valueOf(1000.66D)" );
		checkLiteralValue(Double.class, 0, 2, "Double.valueOf(2000.66D)" );
		
		checkLiteralValue(BigDecimal.class, 0, 0, "java.math.BigDecimal.valueOf(0.77)"     );
		checkLiteralValue(BigDecimal.class, 0, 1, "java.math.BigDecimal.valueOf(10000.77)" );
		checkLiteralValue(BigDecimal.class, 0, 2, "java.math.BigDecimal.valueOf(20000.77)" );
	}

	@Test
	public void testUtilDateValues() {
		
		java.util.Date d = java.sql.Date.valueOf("2000-06-22");
		System.out.println(" d = " + d);
		checkLiteralValue(java.util.Date.class, 0,    0, "java.sql.Date.valueOf(\"2000-06-22\")");
		checkLiteralValue(java.util.Date.class, 0,    1, "java.sql.Date.valueOf(\"2001-06-22\")");
		checkLiteralValue(java.util.Date.class, 0,    2, "java.sql.Date.valueOf(\"2002-06-22\")");
		checkLiteralValue(java.util.Date.class, 0,  999, "java.sql.Date.valueOf(\"2999-06-22\")");
		checkLiteralValue(java.util.Date.class, 0, 1000, "java.sql.Date.valueOf(\"2000-06-22\")");
		checkLiteralValue(java.util.Date.class, 0, 1256, "java.sql.Date.valueOf(\"2256-06-22\")");

		checkLiteralValue(java.util.Date.class, 0, 10000589, "java.sql.Date.valueOf(\"2589-06-22\")");

		checkLiteralValue(NeutralType.DATE, java.util.Date.class, 0,    0, "java.sql.Date.valueOf(\"2000-06-22\")");
		checkLiteralValue(NeutralType.DATE, java.util.Date.class, 0,    1, "java.sql.Date.valueOf(\"2001-06-22\")");
		checkLiteralValue(NeutralType.DATE, java.util.Date.class, 0,    2, "java.sql.Date.valueOf(\"2002-06-22\")");
		checkLiteralValue(NeutralType.DATE, java.util.Date.class, 0,  999, "java.sql.Date.valueOf(\"2999-06-22\")");
		checkLiteralValue(NeutralType.DATE, java.util.Date.class, 0, 1000, "java.sql.Date.valueOf(\"2000-06-22\")");

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
		checkLiteralValue(java.sql.Date.class, 0, 1000, "java.sql.Date.valueOf(\"2000-06-22\")");

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

	private LanguageType buildLanguageObjectType(String neutralType, String javaClassCanonicalName) {
		String javaClassSimpleName = JavaTypeUtil.shortType(javaClassCanonicalName);
		return LanguageTypeBuilder.build(neutralType, javaClassSimpleName, javaClassCanonicalName, false, javaClassSimpleName );
	}
	private LanguageType buildFakeLanguageTypePrimitive() {
		return LanguageTypeBuilder.build("neutralType", "xxx", "xxx", true, "Xxx" );
	}
	private LanguageType buildFakeLanguageTypeObject() {
		return LanguageTypeBuilder.build("neutralType", "xxx", "xxx", false, "Xxx" );
	}
	
	@Test
	public void testLocalDateValues() {
		LanguageType languageType = buildLanguageObjectType("date", TypeConverterForJava.LOCAL_DATE_CLASS );
		checkLiteralValue(languageType, 0, 0, "java.time.LocalDate.parse(\"2000-06-22\")" );
		checkLiteralValue(languageType, 0, 1, "java.time.LocalDate.parse(\"2001-06-22\")" );
	}

	@Test
	public void testLocalTimeValues() {
		LanguageType languageType = buildLanguageObjectType("time", TypeConverterForJava.LOCAL_TIME_CLASS );
		checkLiteralValue(languageType, 0, 0, "java.time.LocalTime.parse(\"00:46:52\")" );
		checkLiteralValue(languageType, 0, 1, "java.time.LocalTime.parse(\"01:46:52\")" );
	}
	
	@Test
	public void testLocalDateTimeValues() {
		LanguageType languageType = buildLanguageObjectType("timestamp", TypeConverterForJava.LOCAL_DATE_TIME_CLASS );
		checkLiteralValue(languageType, 0, 0, "java.time.LocalDateTime.parse(\"2000-05-21T00:46:52\")" );
		checkLiteralValue(languageType, 0, 1, "java.time.LocalDateTime.parse(\"2001-05-21T01:46:52\")" );
	}
	
	@Test
	public void testInvalidTypes() {
		checkLiteralValue(java.math.BigInteger.class, 0,    0, "null");
		checkLiteralValue(java.util.Calendar.class,   0,    0, "null");
		checkLiteralValue(byte[].class,               0,    0, "null");
	}
	
}
