package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static it.uniroma3.diadia.properties.Costanti.NUMERO_MASSIMO_ATTREZZI;

class StanzaMagica extends Stanza {
	
	private int contatoreAttrezziPosati;
	private int sogliaMagica;

/*-----------------------------COSTRUTTORE-----------------------------*/	

//--Costruttore di una Stanza Magica
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}

/*------------------------MODIFICHE STANZA MAGICA------------------------*/
	
//--Inverte il nome di un attrezzo
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		return attrezzo;
	}
	
//--True se è attivo l'effetto magico
	public boolean isMagica() {
		if(this.getClass() == StanzaMagica.class) {return true;}
		return false;
	}
	
/*------------------------SOVRASCRITTURE DI STANZA------------------------*/

//--Inverte il nome dell'attrezzo inserito se è attivo il funzionamento magico
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
	
	
}
