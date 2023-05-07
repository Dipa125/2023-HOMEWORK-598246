package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {
	
	private Labirinto labirinto;
	private Stanza iniziale;
	private Stanza finale;
	
	
	@BeforeEach
	void SetUp() {
		this.labirinto = new Labirinto();
		this.iniziale = new Stanza("Atrio");
		this.finale = new Stanza("Biblioteca");
	}

	@Test
	void testGetStanzaIniziale() {
		assertEquals(this.iniziale.getNome(), this.labirinto.getStanzaIniziale().getNome());
	}

	@Test
	void testGetStanzaVincente() {
		assertEquals(this.finale.getNome(),this.labirinto.getStanzaVincente().getNome());
	}


}
