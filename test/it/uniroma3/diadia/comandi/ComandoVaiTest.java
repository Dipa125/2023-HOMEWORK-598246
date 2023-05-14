package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {

	private Labirinto labirinto;
	private Stanza corrente;
	private Partita partita;
	private IOConsole io;
	private ComandoVai cmdVai;

	@BeforeEach
	void SetUp() {
		this.labirinto = new LabirintoBuilder().addStanzaIniziale("Atrio").addStanza("N11").addAdiacenza("Atrio", "N11", "nord").getLabirinto();
		this.corrente = new Stanza("Atrio");
		this.io = new IOConsole();
		this.partita = new Partita(this.labirinto,this.io);
		this.cmdVai = new ComandoVai();
		this.cmdVai.setParametro("nord");
	}
	@Test
	void comandoVaiTest() {
		assertEquals(this.corrente,this.partita.getStanzaCorrente());
		cmdVai.esegui(partita);
		this.corrente = new Stanza("N11");
		assertEquals(this.corrente,this.partita.getStanzaCorrente());
		
	}

}