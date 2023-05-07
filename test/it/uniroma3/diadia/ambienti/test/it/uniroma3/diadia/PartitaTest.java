package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;



class PartitaTest {

	private Partita partita;
	private IOConsole io;
	
	@BeforeEach
	void SetUp() {
		this.io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder().addStanzaIniziale("Atrio").getLabirinto();
		this.partita = new Partita(labirinto, io);
	}
	
	@Test
	void testVinta() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	void testIsFinita() {
		assertFalse(this.partita.isFinita());
	}
	
	@Test
	void testGetStanzaCorrente() {
		assertEquals("Atrio",this.partita.getStanzaCorrente().getNome());
	}

}
