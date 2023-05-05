package it.uniroma3.diadia;

public class IOSimulator implements IO {

	private String[] input;
	private int contoInput;
	private int contoIstruzioniConsumate;
	private String[] output;
	private int contoOutput;

/*-----------------------------COSTRUTTORE-----------------------------*/	
	
	public IOSimulator(String[] istruzioni) {
		this.input = istruzioni;
		this.contoInput = istruzioni.length;
		this.contoIstruzioniConsumate = 0;
		this.output = new String[this.contoInput + 1];
		this.contoOutput = 0;
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
		System.out.println("-------------------------------------------------------------------------");
		this.output[this.contoOutput] = messaggio;
		this.contoOutput++;
	}

	@Override
	public String leggiRiga() {
		String riga = "fine";
		if(contoIstruzioniConsumate < contoInput) {
			riga = this.input[this.contoIstruzioniConsumate];
			this.contoIstruzioniConsumate++;
		}
		else {
			this.mostraMessaggio("ISTRUZIONI FINITE --> PARTITA PERSA");
		}
		return riga;
	}
	
	public String[] getOutput() {
		return this.output;
	}
}
