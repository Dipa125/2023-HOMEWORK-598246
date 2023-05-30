package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;



class PartitaTest {

	private Partita partita;
	private IOConsole io;
	
	@BeforeEach
	void SetUp() throws FileNotFoundException, FormatoFileNonValidoException {
		this.io = new IOConsole();
		Labirinto labirinto = new Labirinto("LabFile.txt");
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
