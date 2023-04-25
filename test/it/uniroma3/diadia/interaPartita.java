package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class interaPartita {

	private String[] istruzioni;
	private IOSimulator io;
	private DiaDia gioco;
	
	@BeforeEach
	void SetUp() {
		this.istruzioni = new String[6];
		this.istruzioni[0] = "vai nord";
		this.io = new IOSimulator(istruzioni);
		this.gioco = new DiaDia(io);
		gioco.gioca();
	}
	
	@Test
	void test() {
		assertEquals("Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
				+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
				+ "I locali sono popolati da strani personaggi, alcuni amici, altri... chissa!\n"
				+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
				+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
				+ "o regalarli se pensi che possano ingraziarti qualcuno.\n"
				+ "\n"
				+ "Per conoscere le istruzioni usa il comando 'aiuto'.",this.io.getOutput()[0]);
		
		assertEquals("Sei entrato in: Biblioteca",this.io.getOutput()[1]);
	}

}
