package it.uniroma3.diadia;

import java.util.ArrayList;

public class IOSimulator implements IO {

	private ArrayList<String> input;
	private int conto;
	private ArrayList<String> output;

/*-----------------------------COSTRUTTORE-----------------------------*/	
	
	public IOSimulator(ArrayList<String> istruzioni) {
		this.input = istruzioni;
		this.conto = 0;
		this.output = new ArrayList<String>();
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
		System.out.println("-------------------------------------------------------------------------");
		this.output.add(messaggio);
	}

	@Override
	public String leggiRiga() {
		String riga = "fine";
		if(conto < this.input.size()) {
			riga = this.input.get(conto);
			this.conto++;
		}
		else {
			this.mostraMessaggio("ISTRUZIONI FINITE --> PARTITA PERSA");
		}
		return riga;
	}
	
	public ArrayList<String> getOutput() {
		return this.output;
	}
}
