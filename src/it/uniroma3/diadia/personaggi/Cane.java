package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {

	private String nomeAttrezzoPreferito;
	private Attrezzo attrezzoRegalo;
	
	public Cane() {
		this.nomeAttrezzoPreferito = "osso";
		this.attrezzoRegalo = new Attrezzo("bastone",2);
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo.getNome().equals(this.nomeAttrezzoPreferito)) {
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzoPreferito);
			partita.getStanzaCorrente().addAttrezzo(this.attrezzoRegalo);
			return "Il cane prende "+nomeAttrezzoPreferito+" tutto contento e lascia cadere qualcosa";
		}
		else {
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzoPreferito);
			partita.getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzoPreferito));
			return "il cane sputa"+this.attrezzoRegalo.getNome()+" e ti morde una gamba";
		}
	}
	
	@Override
	public String saluta() {
		return "BAU BAU BAU";
	}

}
