package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private String oggetto;
	
	@Override
	public void esegui(Partita partita) {
		if(oggetto == null) {
			partita.getIO().mostraMessaggio("Non mi hai detto che vuoi prendere\n"+
											"Qui vedo: ");
			String lista = "";
			for(Attrezzo a : partita.getStanzaCorrente().getAttrezzi()) {
				if(a != null) {
					lista += a;
					lista += "     ";
				}
			}
			partita.getIO().mostraMessaggio(lista);
		}
		else {
			Attrezzo daPrendere = partita.getStanzaCorrente().getAttrezzo(oggetto);
			if(daPrendere == null)
				partita.getIO().mostraMessaggio("Non vedo nessuna cosa che possa"+
												" assomigliare a questo attrezzo");
			else {
				if(partita.getGiocatore().getBorsa().addAttrezzo(daPrendere)) {
					partita.getStanzaCorrente().removeAttrezzo(daPrendere);
					partita.getIO().mostraMessaggio("Questo lo mettiamo nella borsa,"+
													" magari ci torna utile dopo");
				}
				else
					partita.getIO().mostraMessaggio("La borsa sta per esplorere,"+
													" dovresti priam posare qualcosa");
			}
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.oggetto = parametro;
	}
	
	@Override
	public String getNome() {
		return "prendi";
	}
	
	@Override
	public String getParametro() {
		return oggetto;
	}

}
