package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class ComandoPosaTest {

	private Partita partita;
	private IO io;
	private AbstractComando comando;
	private Attrezzo chiave;
	
	
	@BeforeEach
	void SetUp() throws FileNotFoundException, FormatoFileNonValidoException {
		io = new IOConsole();
		String monolocale = "Stanze: atrio\r\n"
				+ "StanzeBloccate: \r\n"
				+ "StanzeBuie: \r\n"
				+ "StanzeMagiche: \r\n"
				+ "Inizio: atrio\r\n"
				+ "Vincente: atrio\r\n"
				+ "Attrezzi: \r\n"
				+ "Uscite: \r\n"
				+ "Personaggi: ";
		Labirinto labirinto = new Labirinto(monolocale);
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
