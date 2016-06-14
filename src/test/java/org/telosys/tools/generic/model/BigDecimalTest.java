package org.telosys.tools.generic.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalTest {

	@Test
	public void test1() {
		System.out.println("BigDecimal test1 : ");
		check("123", "123");
		check("000", "0");
		check("0.00", "0.00");
		check(".00", "0.00");
		check("12.3400", "12.3400");
		check("000012.3400", "12.3400");
		check("+12.3400", "12.3400");
		check("-12.3400", "-12.3400");
		check("00012.340000", "12.340000");
		//check("- 12.3400", "-12.3400"); // NumberFormatException
	}
	
	public void check(String s, String result) {
		BigDecimal v = new BigDecimal(s);
		System.out.println("BigDecimal : '" + s + "' --> '" + v + "'");
		assertEquals(result,  v.toString() );
	}

	@Test
	public void test2() {
		BigDecimal v = new BigDecimal("123.45");
		
		// A BigDecimal cannot be compared => no comparison in ".vm" files 
//		if ( v > 100 ) {
//			
//		}
		assertTrue( v.compareTo(new BigDecimal("12") ) > 0 ) ;
	}

	public void test3() {
		Integer v = new Integer("123.45");
		if  ( v > 100 ) {
			
		}
	}

}
