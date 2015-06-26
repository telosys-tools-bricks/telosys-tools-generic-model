package org.telosys.tools.generic.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardinalityTest {

	@Test
	public void test1() {
		System.out.println("Cardinality test1 : ");
		check(Cardinality.ONE_TO_MANY,  1, "OneToMany");
		check(Cardinality.MANY_TO_ONE,  2, "ManyToOne");
		check(Cardinality.ONE_TO_ONE,   3, "OneToOne");
		check(Cardinality.MANY_TO_MANY, 4, "ManyToMany");
	}
	public void check(Cardinality cardinality, int value, String text) {
		System.out.println(" . " + cardinality + " : " + cardinality.getValue() + " / '" + cardinality.getText() + "'" );
		assertEquals(value, cardinality.getValue() );
		assertEquals(text,  cardinality.getText() );
	}

	@Test
	public void test2() {
		System.out.println("Cardinality test2 : ");
		check2(Cardinality.ONE_TO_ONE);
		check2(Cardinality.ONE_TO_MANY);
		check2(Cardinality.MANY_TO_ONE);
		check2(Cardinality.MANY_TO_MANY);
	}
	public void check2(Cardinality cardinality) {
		System.out.println(" check2 : " + cardinality + " : " + cardinality.getValue() + " / '" + cardinality.getText() + "'" );
		switch ( cardinality ) {
		case ONE_TO_ONE :
			assertEquals("OneToOne",  cardinality.getText() );
			break;
		case ONE_TO_MANY :
			assertEquals("OneToMany",  cardinality.getText() );
			break;
		case MANY_TO_ONE :
			assertEquals("ManyToOne",  cardinality.getText() );
			break;
		case MANY_TO_MANY :
			assertEquals("ManyToMany",  cardinality.getText() );
			break;
		default :
			fail("unexpected cardinality");
			break;
		}
	}

	@Test
	public void test3() {
		System.out.println("Cardinality test3 : ");
		
		assertTrue(Cardinality.ONE_TO_MANY.isToMany() );
		assertFalse(Cardinality.ONE_TO_MANY.isToOne());
		
		assertTrue(Cardinality.MANY_TO_MANY.isToMany() );
		assertFalse(Cardinality.MANY_TO_MANY.isToOne() );

		assertFalse(Cardinality.MANY_TO_ONE.isToMany() );
		assertTrue(Cardinality.MANY_TO_ONE.isToOne() );

		assertFalse(Cardinality.ONE_TO_ONE.isToMany() );
		assertTrue(Cardinality.ONE_TO_ONE.isToOne() );

		assertFalse(Cardinality.UNDEFINED.isToMany() );
		assertFalse(Cardinality.UNDEFINED.isToOne() );

		Cardinality cardinality = null ;
		
		cardinality = Cardinality.ONE_TO_MANY ;
		System.out.println(cardinality);
		assertTrue(cardinality.isToMany());
		assertFalse(cardinality.isToOne());

		cardinality = Cardinality.MANY_TO_MANY ;
		System.out.println(cardinality);
		assertTrue(cardinality.isToMany());
		assertFalse(cardinality.isToOne());
		
		cardinality = Cardinality.MANY_TO_ONE ;
		System.out.println(cardinality);
		assertFalse(cardinality.isToMany());
		assertTrue(cardinality.isToOne());
		
		cardinality = Cardinality.ONE_TO_ONE ;
		System.out.println(cardinality);
		assertFalse(cardinality.isToMany());
		assertTrue(cardinality.isToOne());
		
		cardinality = Cardinality.UNDEFINED ;
		System.out.println(cardinality);
		assertFalse(cardinality.isToMany());
		assertFalse(cardinality.isToOne());
		
	}
}
