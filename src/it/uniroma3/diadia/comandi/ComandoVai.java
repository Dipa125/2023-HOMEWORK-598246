package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.properties.Direzione;

public class ComandoVai extends AbstractComando{
	
	private Direzione direzione;
	
/*------------------------FUNZIONI PER IL COMANDO-----------------------*/

//--Muove il giocatore nella stanza adiacente selezionata
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if (this.direzione == null) {
			partita.getIO().mostraMessaggio("Hai inserito una direzione non esistente");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		
		if(prossimaStanza == null) {
			partita.getIO().mostraMessaggio("Da quel lato c'è solo un muro...");			return;
		}
		
		partita.setStanzaCorrente(prossimaStanza);
		partita.getIO().mostraMessaggio("Sei entrato in: "+partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	
//--Fornisce una descrizione del funzionamento del comando
	public String getDescrizione() {
		return "vai 'direzione' --> sposta il personaggio nella direzione seleziona";
	}	

//--Imposta la direzione da prendere
	@Override
	public void setParametro(String parametro) {
		this.direzione = Direzione.valueOf(parametro.toUpperCase());
		
	}}
