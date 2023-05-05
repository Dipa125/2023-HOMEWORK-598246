package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public interface Comando {

//--Lista dei comandi
	static final String[] elencoComandi = {"vai","aiuto","fine","prendi","posa","guarda","borsa"};

/*-------------TUTTE LE FUNZIONI DELL'INTERFACCIA---------------*/
	
	public void esegui(Partita partita);
	public void setParametro(String parametro);
	public String getNome();
	public String getParametro();
}