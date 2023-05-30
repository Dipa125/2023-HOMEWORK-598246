package it.uniroma3.diadia.giocatore;

import static it.uniroma3.diadia.properties.Costanti.CFU_INIZIALI;

public class Giocatore {
	
	private int cfu;
	private Borsa borsa;

/*-----------------------------COSTRUTTORE-----------------------------*/

//--Costruttore di giocatore
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}

/*---------------------------------GET----------------------------------*/	
	
//--Ritorna i CFU
	public int getCfu() {return cfu;}
	
//--Setta i CFU
	public void setCfu(int cfu) {this.cfu = cfu;}
	
//--Ritorna la borsa
	public Borsa getBorsa() {return borsa;}
	
}
