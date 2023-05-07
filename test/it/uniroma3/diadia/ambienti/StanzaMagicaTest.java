package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {

	private int soglia;
	private StanzaMagica mensa;
	private Attrezzo penna;
	private Attrezzo gomma;
	
	
	@BeforeEach
	void SetUp() {
		this.soglia = 1;
		this.mensa = new StanzaMagica("mensa", soglia);
		this.gomma = new Attrezzo("gomma",1);
		this.penna = new Attrezzo("penna",1);
	}

	
	@Test
	void testAddAttrezzoNormale() {
		assertTrue(this.mensa.addAttrezzo(gomma));
		assertTrue(this.mensa.hasAttrezzo("gomma"));
	}

	@Test
	void testAddAttrezzoMagico() {
		assertTrue(this.mensa.addAttrezzo(gomma));
		assertTrue(this.mensa.addAttrezzo(penna));
		assertFalse(this.mensa.hasAttrezzo("penna"));
		assertTrue(this.mensa.hasAttrezzo("annep"));
	}
}
