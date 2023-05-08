package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	private StanzaBuia atrio;
	private Attrezzo torcia;
	private Attrezzo penna;
	
	@BeforeEach
	void SetUp() {
		this.atrio = new StanzaBuia("Atrio","torcia");
		this.torcia = new Attrezzo("torcia", 2);
		this.penna = new Attrezzo("penna", 1);
	}
	
	@Test
	void stanzaSenzaLuceTest() {
		this.atrio.addAttrezzo(penna);
		assertEquals("qui c'è un buio pesto", this.atrio.getDescrizione());
	}
	
	@Test
	void stanzaConLuceTest() {
		this.atrio.addAttrezzo(torcia);
		assertEquals("Stanza Corrente: Atrio\n"
				   + "Uscite:\n"
				   + "Attrezzi nella stanza: torcia(2kg) ", this.atrio.getDescrizione());
	}

	@Test
	void testGetDescrizioneBuia() {
		this.atrio.addAttrezzo(penna);
		assertEquals("qui c'è un buio pesto",this.atrio.getDescrizione());
	}
	
}
