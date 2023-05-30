package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class interaPartitaTest {

	private ArrayList<String> istruzioni;
	private IOSimulator io;
	private DiaDia gioco;
	
	@BeforeEach
	void SetUp() throws FileNotFoundException, FormatoFileNonValidoException{
		this.istruzioni = new ArrayList<String>();
		this.istruzioni.add("vai nord");		//1
		this.istruzioni.add("vai ovest");		//2
		this.istruzioni.add("prendi torcia");	//3
		this.istruzioni.add("vai est");			//4
		this.istruzioni.add("vai sud");			//5
		this.istruzioni.add("vai est");			//6
		this.istruzioni.add("vai est");			//7
		this.istruzioni.add("vai nord");		//8
		this.istruzioni.add("prendi chiave");	//9
		this.istruzioni.add("vai sud");			//10
		this.istruzioni.add("vai ovest");		//11
		this.istruzioni.add("vai ovest");		//12
		this.istruzioni.add("vai sud");			//13
		this.istruzioni.add("posa chiave");		//14
		this.istruzioni.add("vai sud");			//15
		this.istruzioni.add("prendi moneta");	//16
		this.istruzioni.add("vai nord");		//17
		this.istruzioni.add("vai nord");		//18
		this.istruzioni.add("vai est");			//19
		this.istruzioni.add("vai est");			//20
		this.istruzioni.add("posa moneta");		//21
		this.istruzioni.add("vai est");			//22


		this.io = new IOSimulator(istruzioni);
		this.gioco = new DiaDia(io);
		gioco.gioca();
	}
	
	@Test
	void test() {		
		assertEquals("Sei entrato in: laboratorio",this.io.getOutput().get(1));
		assertEquals("Sei entrato in: N9",this.io.getOutput().get(2));
		assertEquals("Sei entrato in: N10",this.io.getOutput().get(11));
		assertEquals("Sei entrato in: dispensa",this.io.getOutput().get(15));
		assertEquals("Sei entrato in: biblioteca",this.io.getOutput().get(22));
	}

}
