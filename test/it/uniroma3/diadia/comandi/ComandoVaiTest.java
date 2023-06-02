package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {
	
	private Stanza corrente;
	private Partita partita;
	private IOConsole io;
	private AbstractComando cmdVai;

	@BeforeEach
	void SetUp() throws FileNotFoundException, FormatoFileNonValidoException {
		String bilocale = "Stanze: atrio, N1\r\n"
				+ "StanzeBloccate: \r\n"
				+ "StanzeBuie: \r\n"
				+ "StanzeMagiche: \r\n"
				+ "Inizio: atrio\r\n"
				+ "Vincente: atrio\r\n"
				+ "Attrezzi: chiave 1 atrio\r\n"
				+ "Uscite: atrio nord N1\r\n"
				+ "Personaggi: ";
		Labirinto labirinto = new Labirinto(bilocale);
		this.corrente = new Stanza("atrio");
		Scanner scannerDiLinee = new Scanner(System.in);
		this.io = new IOConsole(scannerDiLinee);
		this.partita = new Partita(labirinto,this.io);
		this.cmdVai = new ComandoVai();
		this.cmdVai.setParametro("nord");
	}
	@Test
	void comandoVaiTest() {
		assertEquals(this.corrente.getNome(),this.partita.getStanzaCorrente().getNome());
		cmdVai.esegui(partita);
		this.corrente = new Stanza("N1");
		assertEquals(this.corrente.getNome(),this.partita.getStanzaCorrente().getNome());
		
	}

}