package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;

class LabirintoTest {
	
	private Labirinto labirinto;
	private Stanza iniziale;
	private Stanza finale;
	
	
	@BeforeEach
	void SetUp() throws FileNotFoundException, FormatoFileNonValidoException {
		this.labirinto = new Labirinto("LabFile.txt");
		this.iniziale = new Stanza("Atrio");
		this.finale = new Stanza("Biblioteca");
		this.labirinto.setStanzaIniziale(iniziale);
		this.labirinto.setStanzaVincente(finale);
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
