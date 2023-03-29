package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza vuota;
	private Stanza nonVuota;
	private Attrezzo osso;
	
	@BeforeEach
	void setUp() {
		System.out.println("Test Stanza");
		this.vuota = new Stanza("Vuota");
		this.nonVuota = new Stanza("Non Vuota");
		this.osso = new Attrezzo("osso", 1);
		this.nonVuota.addAttrezzo(this.osso);
		
		
	}
	
	@Test
	void testHasAttrezzo() {
		assertFalse(this.vuota.hasAttrezzo("osso"));
		assertTrue(this.nonVuota.hasAttrezzo("osso"));
	}
	

	@Test
	void testRemoveAttrezzo() {
		assertTrue(this.nonVuota.removeAttrezzo(this.osso));
		assertFalse(this.vuota.removeAttrezzo(this.osso));
	}
	
	@Test
	void testaddAttrezzo() {
		assertTrue(this.vuota.addAttrezzo(this.osso));
	}

}
