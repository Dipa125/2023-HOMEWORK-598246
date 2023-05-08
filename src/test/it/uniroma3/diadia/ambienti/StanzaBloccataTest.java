package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

	private StanzaBloccata atrio;
	private Stanza mensa;
	private Attrezzo chiave;
	private Attrezzo gomma;
	
	@BeforeEach
	void SetUp() {
		this.atrio = new StanzaBloccata("Atrio","nord","chiave");
		this.mensa = new Stanza("Mensa");
		this.chiave = new Attrezzo("chiave", 2);
		this.gomma = new Attrezzo("gomma", 1);
		
		this.atrio.impostaStanzaAdiacente("nord", mensa);
	}
	@Test
	void stanzaChiusatest() {
		this.atrio.addAttrezzo(gomma);
		assertEquals(atrio,this.atrio.getStanzaAdiacente("nord"));
	}
	
	@Test
	void stanzaApertaTest() {
		this.atrio.addAttrezzo(chiave);
		assertEquals(mensa,this.atrio.getStanzaAdiacente("nord"));
	}
	
	@Test
	void getDescrizioneConBloccoTest() {
		this.atrio.addAttrezzo(gomma);
		assertEquals("Qui la stanza in direzione nord " 
				  +  "è bloccata, prova con chiave\n"
				  +  "Stanza Corrente: Atrio\n"
				  +  "Uscite: nord\n"
				  +  "Attrezzi nella stanza: gomma(1kg) ", this.atrio.getDescrizione());
	}
	
	@Test
	void getDescrizioneSenzaBloccoTest() {
		this.atrio.addAttrezzo(chiave);
		assertEquals("Stanza Corrente: Atrio\n"
				  +  "Uscite: nord\n"
				  +  "Attrezzi nella stanza: chiave(2kg) ", this.atrio.getDescrizione());
	}
}
