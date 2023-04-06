package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public interface Comando {
	
	static final String[] elencoComandi = {"vai","aiuto","fine","prendi","posa","guarda"};
	
	/**
	* esecuzione del comando
	*/
	public void esegui(Partita partita);
	
	/**
	* set parametro del comando
	*/
	public void setParametro(String parametro);
}