package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class PartitaTest {

	private Partita partita;
	private IOConsole IO;
	
	@BeforeEach
	void SetUp() {
		this.IO = new IOConsole();
		this.partita = new Partita(IO);
		
		
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
