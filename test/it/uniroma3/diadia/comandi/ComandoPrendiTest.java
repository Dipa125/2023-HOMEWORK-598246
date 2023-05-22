package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

class ComandoPrendiTest {

	private Partita partita;
	private IOConsole io;
	private AbstractComando comando;
	
	
	@BeforeEach
	void SetUp() {
		io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder().addStanzaIniziale("Atrio").addAttrezzo("chiave", 1)
													.getLabirinto();
		partita = new Partita(labirinto, io);
		comando = new ComandoPrendi();
		comando.setParametro("chiave");
	}
	
	@Test
	void testEsegui() {
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("chiave"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("chiave"));
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("chiave"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("chiave"));
	}

}
