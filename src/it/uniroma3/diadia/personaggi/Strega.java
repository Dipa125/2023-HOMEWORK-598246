package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		return "HAHAHA... La strega ride e non succede nulla";
	}
	
	@Override
	public String saluta() {
		return "Ohhhh ciao, non sto tanto bene avrei bisogno di un oggetto";
	}

}
