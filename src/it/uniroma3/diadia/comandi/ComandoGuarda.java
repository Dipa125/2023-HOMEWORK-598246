package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

public class ComandoGuarda implements Comando {

/*------------------------FUNZIONI PER IL COMANDO-----------------------*/	
	
//--Stampa le caratteristiche della stanza corrente
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio(partita.getStanzaCorrente().toString());

	}

//--Setta il parametro per il comando se è presente	
	@Override
	public void setParametro(String parametro){}


	
/*------------------------FUNZIONI PER I TEST-----------------------*/	
	
	@Override
	public String getNome() {
		return "guarda";
	}
	
	@Override
	public String getParametro() {
		return "";
	}

}
