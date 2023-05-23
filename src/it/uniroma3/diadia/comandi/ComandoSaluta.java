package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio() != null) {
			partita.getIO().mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().getClass().getSimpleName()
					+": "+partita.getStanzaCorrente().getPersonaggio().saluta());
		}
		else {
			partita.getIO().mostraMessaggio("Qui non c'è nessun personaggio da salutare");
		}
		
	}

	@Override
	public String getDescrizione() {
		return "saluta --> Se è presente un personaggio nella stanza puoi salutarlo";
	}

}
