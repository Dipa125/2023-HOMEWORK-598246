package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	
	private Borsa borsa;
	private Attrezzo osso;
	private Attrezzo penna;
	private Attrezzo sasso;
	
	
	
	@BeforeEach
	void SetUp() {
		this.borsa = new Borsa();
		this.osso = new Attrezzo("osso", 1);
		this.penna = new Attrezzo("penna", 1);
		this.sasso = new Attrezzo("sasso", 30);
		this.borsa.addAttrezzo(osso);
	}
	
	@Test
	void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(penna));
		assertFalse(this.borsa.addAttrezzo(sasso));
	}
	
	@Test
	void testRemoveAttrezzo() {
		assertEquals(this.osso, this.borsa.removeAttrezzo("osso"));
	}
	
	@Test
	void testHasAttrezzo() {
		assertTrue(this.borsa.hasAttrezzo("osso"));
		assertFalse(this.borsa.hasAttrezzo("penna"));
	}
	
	@Test
	void getAttrezzo() {
		assertEquals(this.osso, this.borsa.getAttrezzo("osso"));
	}

}
