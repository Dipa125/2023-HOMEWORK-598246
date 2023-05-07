package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public interface Comando {

//--Lista dei comandi
	static final String[] elencoComandi = {"vai --> scegli una direzione in cui andare (nord/sud/est/ovest)",
										   "aiuto --> mostra la lista dei comandi",
										   "fine --> termina la partita",
										   "prendi 'nome' --> prende l'oggetto chiamato 'nome' dalla stanza e lo mette in borsa",
										   "posa 'nome' --> prende l'oggetto chiamato 'nome' dalla borsa e lo mette nella borsa",
										   "guarda --> fornisce informazioni sulla stanza corrente",
										   "borsa 'peso-nome-group' --> contenuto della borsa ordinata secondo il parametro(se non inserito fa una stampa standard) "};

/*-------------TUTTE LE FUNZIONI DELL'INTERFACCIA---------------*/
	
	public void esegui(Partita partita);
	public void setParametro(String parametro);
	public String getNome();
	public String getParametro();
}