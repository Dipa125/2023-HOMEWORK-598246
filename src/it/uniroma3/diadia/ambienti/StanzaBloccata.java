package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private String direzioneBloccata;
	private String oggetto;
	
	public StanzaBloccata(String nome,String direzioneBloccata, String oggetto) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.oggetto = oggetto;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(dir == direzioneBloccata && !this.hasAttrezzo(oggetto)) {
			return this;
		}
		return super.getStanzaAdiacente(dir);
	}
	
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
