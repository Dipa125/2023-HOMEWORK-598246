package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbrica;
	private Comando comando;
	
	@BeforeEach
	void SetUp() {
		fabbrica = new FabbricaDiComandiFisarmonica();
	}
	
	@Test
	void testAiuto() {
		comando = fabbrica.costruisciComando("aiuto");
		assertEquals("aiuto", comando.getNome());
		assertEquals("", comando.getParametro());
	}
	
	@Test
	void testFine() {
		comando = fabbrica.costruisciComando("fine");
		assertEquals("fine", comando.getNome());
		assertEquals("", comando.getParametro());
	}
	
	@Test
	void testGuarda() {
		comando = fabbrica.costruisciComando("guarda");
		assertEquals("guarda", comando.getNome());
		assertEquals("", comando.getParametro());
	}
	
	@Test
	void testNonValido() {
		comando = fabbrica.costruisciComando("niente");
		assertEquals("non valido", comando.getNome());
		assertEquals("", comando.getParametro());
	}
	
	@Test
	void testPosa() {
		comando = fabbrica.costruisciComando("posa osso");
		assertEquals("posa", comando.getNome());
		assertEquals("osso", comando.getParametro());
	}
	
	@Test
	void testPrendi() {
		comando = fabbrica.costruisciComando("prendi chiave");
		assertEquals("prendi", comando.getNome());
		assertEquals("chiave", comando.getParametro());
	}
	
	@Test
	void testVai() {
		comando = fabbrica.costruisciComando("vai nord");
		assertEquals("vai", comando.getNome());
		assertEquals("nord", comando.getParametro());
	}

}
