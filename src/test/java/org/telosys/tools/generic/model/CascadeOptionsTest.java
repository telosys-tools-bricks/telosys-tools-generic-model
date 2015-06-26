package org.telosys.tools.generic.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class CascadeOptionsTest {

	@Test
	public void test0() {
		System.out.println("\nCascadeOptionsTest : test0 : ");
		System.out.println("CascadeOption.values().length = " + CascadeOption.values().length);
		assertEquals(5, CascadeOption.values().length );
	}
	
	@Test
	public void testInitialState() {
		System.out.println("\nCascadeOptionsTest : initial state ");
		CascadeOptions cascadeOptions = new CascadeOptions();
		//--- All cascade options are supposed to be "false"
		assertFalse(cascadeOptions.isCascadeAll());
		assertFalse(cascadeOptions.isCascadeMerge());
		assertFalse(cascadeOptions.isCascadePersist());
		assertFalse(cascadeOptions.isCascadeRefresh());
		assertFalse(cascadeOptions.isCascadeRemove());
		//--- List of "active options" is supposed to be void
		List<CascadeOption> activeOptions = cascadeOptions.getActiveOptions();
		assertEquals(0, activeOptions.size());
	}
	
	@Test
	public void test1() {
		System.out.println("\nCascadeOptionsTest : test1 : ");
		CascadeOptions cascadeOptions = new CascadeOptions();
		
		assertFalse(cascadeOptions.isCascadeAll());
		assertFalse(cascadeOptions.isCascadeMerge());
		assertFalse(cascadeOptions.isCascadePersist());
		
		cascadeOptions.add(CascadeOption.MERGE);
		assertTrue(cascadeOptions.isCascadeMerge());
		assertFalse(cascadeOptions.isCascadePersist());
		assertFalse(cascadeOptions.isCascadeRefresh());

		cascadeOptions.add(CascadeOption.PERSIST);
		assertTrue(cascadeOptions.isCascadeMerge());
		assertTrue(cascadeOptions.isCascadePersist());
		assertFalse(cascadeOptions.isCascadeRefresh());
		assertFalse(cascadeOptions.isCascadeRemove());

		cascadeOptions.add(CascadeOption.REFRESH);
		assertTrue(cascadeOptions.isCascadeMerge());
		assertTrue(cascadeOptions.isCascadePersist());
		assertTrue(cascadeOptions.isCascadeRefresh());
		assertFalse(cascadeOptions.isCascadeRemove());
		
		cascadeOptions.add(CascadeOption.REMOVE);
		assertTrue(cascadeOptions.isCascadeRemove());
		
		cascadeOptions.add(CascadeOption.ALL);
		assertTrue(cascadeOptions.isCascadeAll());
		
		String s = cascadeOptions.toString();
		System.out.println("toString() = " + s);
	}

	@Test
	public void test2() {
		System.out.println("\nCascadeOptionsTest : test2 : ");
		CascadeOptions cascadeOptions = new CascadeOptions();
		
		assertFalse(cascadeOptions.isCascadeAll());
		assertFalse(cascadeOptions.isCascadeMerge());
		assertFalse(cascadeOptions.isCascadePersist());

		String s = cascadeOptions.toString();
		System.out.println("toString() = " + s);
		assertEquals("", s);
		
		cascadeOptions.add(CascadeOption.ALL);

		assertTrue(cascadeOptions.isCascadeAll());
		assertFalse(cascadeOptions.isCascadeMerge());
		assertFalse(cascadeOptions.isCascadePersist());

		s = cascadeOptions.toString();
		System.out.println("toString() = " + s);
		assertEquals("ALL", s);

		cascadeOptions.add(CascadeOption.PERSIST);
		s = cascadeOptions.toString();
		System.out.println("toString() = " + s);
		assertEquals("ALL", s);
	}
	
	@Test
	public void test3() {
		System.out.println("\nCascadeOptionsTest : test3 : ");
		CascadeOptions cascadeOptions = new CascadeOptions();

		String s = cascadeOptions.toString();
		System.out.println("toString() = " + s);
		assertTrue(s.indexOf("MERGE") < 0 );
		assertTrue(s.indexOf("REMOVE") < 0 );
		
		cascadeOptions.add(CascadeOption.MERGE);
		s = cascadeOptions.toString();
		System.out.println("toString() = " + s);
		assertTrue(s.indexOf("MERGE") >= 0 );
		assertTrue(s.indexOf("REMOVE") < 0 );
	}

	@Test
	public void test4() {
		System.out.println("\nCascadeOptionsTest : test4 : ");
		CascadeOptions cascadeOptions = new CascadeOptions();

		System.out.println("toString() = " + cascadeOptions.toString());		
		assertEquals(0,	cascadeOptions.getActiveOptions().size() );
		
		cascadeOptions.add(CascadeOption.MERGE);
		System.out.println("toString() = " + cascadeOptions.toString());		
		assertEquals(1,	cascadeOptions.getActiveOptions().size() );

		cascadeOptions.add(CascadeOption.MERGE);
		System.out.println("toString() = " + cascadeOptions.toString());		
		assertEquals(1,	cascadeOptions.getActiveOptions().size() );

		cascadeOptions.add(CascadeOption.PERSIST);
		System.out.println("toString() = " + cascadeOptions.toString());		
		assertEquals(2,	cascadeOptions.getActiveOptions().size() );

		cascadeOptions.add(CascadeOption.ALL);
		System.out.println("toString() = " + cascadeOptions.toString());		
		assertEquals(3,	cascadeOptions.getActiveOptions().size() );

	}
}
