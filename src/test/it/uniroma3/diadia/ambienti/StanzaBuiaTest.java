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
		atrio.addAttrezzo(penna);
		assertEquals("qui c'è un buio pesto", atrio.getDescrizione());
	}
	
	@Test
	void stanzaConLuceTest() {
		atrio.addAttrezzo(torcia);
		assertEquals("Stanza Corrente: Atrio\n"
				   + "Uscite:\n"
				   + "Attrezzi nella stanza: torcia(2kg) ", atrio.getDescrizione());
	}

}
