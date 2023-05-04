package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagica extends Stanza {
	
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	static final private int SOGLIA_MAGICA_DEFAULT = 3;
	
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
		
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
				
		if (this.getNumeroAttrezzi() < NUMERO_MASSIMO_ATTREZZI) {
			this.contatoreAttrezziPosati++;
			
			if (this.contatoreAttrezziPosati > this.sogliaMagica)
				attrezzo = this.modificaAttrezzo(attrezzo);
			
			this.getAttrezzi().add(attrezzo);
			return true;
		}
		else return false;
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		return attrezzo;
	}
}
