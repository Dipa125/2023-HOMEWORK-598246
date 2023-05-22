package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {

	private String oggetto;
	
	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio() == null) {
			partita.getIO().mostraMessaggio("Non c'è nessun personaggio qui");
		}
		else if(this.oggetto == null) {
			partita.getIO().mostraMessaggio("Indica cosa vuoi regalare");
		}
		else if(partita.getGiocatore().getBorsa().hasAttrezzo(oggetto)) {
			Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(oggetto);
			String out = partita.getStanzaCorrente().getPersonaggio().riceviRegalo(a, partita);
			partita.getIO().mostraMessaggio(out);
		}
		else {
			partita.getIO().mostraMessaggio("Non hai quell'oggetto nella borsa");
		}
		
	}

	@Override
	public String getDescrizione() {
		return "regala --> scegli un oggetto dalla tua borsa e dallo al personaggio nella stanza";
	}
	
	@Override
	public void setParametro(String parametro) {
		this.oggetto = parametro;
	}

}
