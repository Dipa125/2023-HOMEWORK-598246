package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	private String oggetto;

//--Costruttore di una Stanza Buia
	public StanzaBuia(String nome, String oggetto) {
		super(nome);
		this.oggetto = oggetto;
	}

/*------------------------SOVRASCRITTURE DI STANZA------------------------*/	
	
//--Ritorna una descrizione personalizzata se stanza è ancora buia
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(oggetto)) {
			return super.getDescrizione();
		}
		return "qui c'è un buio pesto";
	}
}
