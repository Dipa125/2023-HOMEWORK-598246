package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.properties.Direzione;

public class StanzaBloccata extends Stanza{

	private Direzione direzioneBloccata;
	private String oggetto;

/*-----------------------------COSTRUTTORE-----------------------------*/	
	
//--Costruttore di una Stanza Bloccata
	public StanzaBloccata(String nome, Direzione direzioneBloccata, String oggetto) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.oggetto = oggetto;
	}

/*------------------------SOVRASCRITTURE DI STANZA------------------------*/	

//--Ritorna se stessa se la direzione selezionata è bloccata
	@Override
	public Stanza getStanzaAdiacente(Direzione dir) {
		if(dir.equals(direzioneBloccata) && !this.hasAttrezzo(oggetto)) {
			return this;
		}
		return super.getStanzaAdiacente(dir);
	}

//--Ritorna una descrizione personalizzata se la direzione selezionata è bloccata
	@Override
	public String toString() {
		if(!this.hasAttrezzo(oggetto)) {
			String ret =  "Qui la stanza in direzione " 
						+  direzioneBloccata.getString() + " "
						+ "è bloccata, prova con "
						+  oggetto + "\n";
			return ret + super.toString();
		}
		return super.toString();
	}
}
