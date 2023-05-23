package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		int pesoMezzi = a.getPeso()/2;
		Attrezzo nuovo = new Attrezzo(a.getNome(),pesoMezzi);
		partita.getStanzaCorrente().addAttrezzo(nuovo);
		return "Come facevi ad andare in giro con quel coso cosi pesante.";
	}
	
	@Override
	public String saluta() {
		return "Salve giovane, sono il mago dell'università";
	}

}
