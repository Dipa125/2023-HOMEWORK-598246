package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class PartitaTest {

	private Partita partita;
	
	
	@BeforeEach
	void SetUp() {
		System.out.println("Test Partita");
		this.partita = new Partita();
		
		
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
