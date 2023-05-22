package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class ComandoPosaTest {

	private Partita partita;
	private IO io;
	private AbstractComando comando;
	private Attrezzo chiave;
	
	
	@BeforeEach
	void SetUp() {
		io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder().addStanzaIniziale("Atrio")
													.getLabirinto();
		partita = new Partita(labirinto, io);
		chiave = new Attrezzo("chiave",1);
		partita.getGiocatore().getBorsa().addAttrezzo(chiave);
		comando = new ComandoPosa();
		comando.setParametro("chiave");
	}
	
	@Test
	void testEsegui() {
		assertEquals(chiave,partita.getGiocatore().getBorsa().getAttrezzo("chiave"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("chiave"));
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("chiave"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("chiave"));
	}

}
