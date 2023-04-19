package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	private String oggetto;
	
	public StanzaBuia(String nome, String oggetto) {
		super(nome);
		this.oggetto = oggetto;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(oggetto)) {
			return super.getDescrizione();
		}
		return "qui c'è un buio pesto";
	}
}
