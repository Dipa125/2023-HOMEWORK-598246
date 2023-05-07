package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {
	
	private Giocatore player;
	private int cfu5;
	
	@BeforeEach
	void SetUp() {
		this.player = new Giocatore();
		this.cfu5 = 5;
	}
	
	
	@Test
	void testGetCfu() {
		assertEquals(20,this.player.getCfu());
	}

	@Test
	void testSetCfu() {
		this.player.setCfu(cfu5);
		assertEquals(5,this.player.getCfu());
		
	}

}
