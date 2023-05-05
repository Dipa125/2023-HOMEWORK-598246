package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private String direzioneBloccata;
	private String oggetto;

//--Costruttore di una Stanza Bloccata
	public StanzaBloccata(String nome,String direzioneBloccata, String oggetto) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.oggetto = oggetto;
	}

/*------------------------SOVRASCRITTURE DI STANZA------------------------*/	

//--Ritorna se stessa se la direzione selezionata è bloccata
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(dir == direzioneBloccata && !this.hasAttrezzo(oggetto)) {
			return this;
		}
		return super.getStanzaAdiacente(dir);
	}

//--Ritorna una descrizione personalizzata se la direzione selezionata è bloccata
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(oggetto)) {
			String ret =  "Qui la stanza in direzione " 
						+  direzioneBloccata + " "
						+ "è bloccata, prova con "
						+  oggetto + "\n";
			return ret + super.getDescrizione();
		}
		return super.getDescrizione();
	}
}
