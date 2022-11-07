package org.telosys.tools.generic.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.telosys.tools.generic.model.enums.CascadeOption;

public class CascadeOptionsTest {

	@Test
	public void testEnum() {
		assertEquals(5, CascadeOption.values().length );
	}
	
	@Test
	public void testInitialState() {
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
	public void testAdd() {
		CascadeOptions cascadeOptions = new CascadeOptions();
		
		assertFalse(cascadeOptions.isCascadeAll());
		assertFalse(cascadeOptions.isCascadeMerge());
		assertFalse(cascadeOptions.isCascadePersist());
		assertEquals(0, cascadeOptions.size());
		assertTrue(cascadeOptions.isEmpty());
		
		cascadeOptions.add(CascadeOption.MERGE);
		assertTrue(cascadeOptions.isCascadeMerge());
		assertFalse(cascadeOptions.isCascadePersist());
		assertFalse(cascadeOptions.isCascadeRefresh());
		assertEquals(1, cascadeOptions.size());
		assertFalse(cascadeOptions.isEmpty());

		cascadeOptions.add(CascadeOption.PERSIST);
		assertTrue(cascadeOptions.isCascadeMerge());
		assertTrue(cascadeOptions.isCascadePersist());
		assertFalse(cascadeOptions.isCascadeRefresh());
		assertFalse(cascadeOptions.isCascadeRemove());
		assertEquals(2, cascadeOptions.size());
		assertFalse(cascadeOptions.isEmpty());

		cascadeOptions.add(CascadeOption.REFRESH);
		assertTrue(cascadeOptions.isCascadeMerge());
		assertTrue(cascadeOptions.isCascadePersist());
		assertTrue(cascadeOptions.isCascadeRefresh());
		assertFalse(cascadeOptions.isCascadeRemove());
		
		cascadeOptions.add(CascadeOption.REMOVE);
		assertTrue(cascadeOptions.isCascadeRemove());
		
		cascadeOptions.add(CascadeOption.ALL);
		assertTrue(cascadeOptions.isCascadeAll());
	}

	@Test
	public void testAllPlusOther() {
		CascadeOptions cascadeOptions = new CascadeOptions();
		
		assertFalse(cascadeOptions.isCascadeAll());
		assertFalse(cascadeOptions.isCascadeMerge());
		assertFalse(cascadeOptions.isCascadePersist());

		assertEquals("", cascadeOptions.toString() );
		
		cascadeOptions.add(CascadeOption.ALL);

		assertTrue(cascadeOptions.isCascadeAll());
		assertFalse(cascadeOptions.isCascadeMerge());
		assertFalse(cascadeOptions.isCascadePersist());

		assertEquals("ALL", cascadeOptions.toString() );

		cascadeOptions.add(CascadeOption.PERSIST);
		assertEquals("ALL", cascadeOptions.toString() );
	}
	
	@Test
	public void testToString() {
		CascadeOptions cascadeOptions = new CascadeOptions();
		String s = cascadeOptions.toString();
		assertTrue(s.length() == 0);
		assertFalse(s.contains("MERGE") );
		assertFalse(s.contains("REMOVE") );
		
		cascadeOptions.add(CascadeOption.MERGE);
		s = cascadeOptions.toString();
		assertTrue(s.contains("MERGE") );
		assertFalse(s.contains("REMOVE") );
	}

	@Test
	public void testGetActiveOptions() {
		CascadeOptions cascadeOptions = new CascadeOptions();
		assertEquals(0,	cascadeOptions.getActiveOptions().size() );
		
		cascadeOptions.add(CascadeOption.MERGE);
		assertEquals(1,	cascadeOptions.getActiveOptions().size() );
		cascadeOptions.add(CascadeOption.MERGE);
		assertEquals(1,	cascadeOptions.getActiveOptions().size() );

		cascadeOptions.add(CascadeOption.PERSIST);
		assertEquals(2,	cascadeOptions.getActiveOptions().size() );

		cascadeOptions.add(CascadeOption.ALL);
		assertEquals(3,	cascadeOptions.getActiveOptions().size() );
	}
}
