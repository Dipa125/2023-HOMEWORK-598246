package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;


class AbstractComandoTest {

	public AbstractComando comando;

	@Test
	void testComandoNonValido() {
		comando = new ComandoNonValido();
		assertEquals(ComandoNonValido.class, comando.getClass());
	}
	
	@Test
	void testComandoGuarda() {
		comando = new ComandoFine();
		assertEquals(ComandoFine.class, comando.getClass());
	}

}
