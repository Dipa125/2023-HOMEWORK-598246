package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza atrio;
	private Attrezzo osso;
	private Attrezzo penna;
	
	@BeforeEach
	void setUp() {
		this.atrio = new Stanza("atrio");
		this.osso = new Attrezzo("osso", 1);
		this.penna = new Attrezzo("penna",1);
		this.atrio.addAttrezzo(osso);
		
		
	}
	
	@Test
	void testHasAttrezzo() {
		assertTrue(this.atrio.hasAttrezzo("osso"));
		assertFalse(this.atrio.hasAttrezzo("penna"));
	}
	

	@Test
	void testRemoveAttrezzo() {
		assertTrue(this.atrio.removeAttrezzo(this.osso));
		assertFalse(this.atrio.hasAttrezzo("osso"));
	}
	
	@Test
	void testaddAttrezzo() {
		assertTrue(this.atrio.addAttrezzo(this.penna));
		assertTrue(this.atrio.hasAttrezzo("penna"));
	}

	@Test
	void testGetAttrezzo() {
		assertEquals(this.osso,this.atrio.getAttrezzo("osso"));
	}
}
