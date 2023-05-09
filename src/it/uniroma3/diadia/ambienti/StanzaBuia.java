package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	private String oggetto;

/*-----------------------------COSTRUTTORE-----------------------------*/
	
//--Costruttore di una Stanza Buia
	public StanzaBuia(String nome, String oggetto) {
		super(nome);
		this.oggetto = oggetto;
	}

/*------------------------SOVRASCRITTURE DI STANZA------------------------*/	
	
//--Ritorna una descrizione personalizzata se stanza è ancora buia
	@Override
	public String toString() {
		if(this.hasAttrezzo(oggetto)) {
			return super.toString();
		}
		return "qui c'è un buio pesto";
	}
}
