package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {

	private Partita partita;
	private IOConsole IO;
	private Comando comando;
	private Attrezzo chiave;
	
	
	@BeforeEach
	void SetUp() {
		IO = new IOConsole();
		partita = new Partita(IO);
		chiave = new Attrezzo("chiave",1);
		partita.getStanzaCorrente().addAttrezzo(chiave);
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
