package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	private String oggetto;
	
	@Override
	public void esegui(Partita partita) {
		if(oggetto == null) {
			partita.getIO().mostraMessaggio("Dovresti dirmi anche cosa vuoi posare.\n"+
											"Nello zaino hai: ");
			String lista = "";
			for(Attrezzo a : partita.getGiocatore().getBorsa().getAttrezzi()) {
				if(a != null) {
					lista += a;
					lista += "     ";
				}
			}
			partita.getIO().mostraMessaggio(lista);
		}
		else {
			Attrezzo daPosare = partita.getGiocatore().getBorsa().getAttrezzo(oggetto);
			if(daPosare == null)
				partita.getIO().mostraMessaggio("Non credo che questa cosa sia nello zaino ");
			else {
				if(partita.getStanzaCorrente().addAttrezzo(daPosare)) {
					partita.getGiocatore().getBorsa().removeAttrezzo(oggetto);
					partita.getIO().mostraMessaggio("Questo lo lascio qui, speriamo non ci serva dopo...");
				}
				else
					partita.getIO().mostraMessaggio("Questa stanza è già un casino, non entra più niente");	
			}
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.oggetto = parametro;

	}

}
