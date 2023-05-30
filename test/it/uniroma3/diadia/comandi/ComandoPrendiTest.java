package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

class ComandoPrendiTest {

	private Partita partita;
	private IOConsole io;
	private AbstractComando comando;
	
	
	@BeforeEach
	void SetUp() throws FileNotFoundException, FormatoFileNonValidoException {
		io = new IOConsole();
		String monolocale = "Stanze: atrio\r\n"
				+ "StanzeBloccate: \r\n"
				+ "StanzeBuie: \r\n"
				+ "StanzeMagiche: \r\n"
				+ "Inizio: atrio\r\n"
				+ "Vincente: atrio\r\n"
				+ "Attrezzi: chiave 1 atrio\r\n"
				+ "Uscite: \r\n"
				+ "Personaggi: ";
		Labirinto labirinto = new Labirinto(monolocale);
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
