package it.uniroma3.diadia.giocatore;

/*
Una classe per modellare il giocatore.
Ha dei CFU che se finiscono perde la partita.
Ha anche uan borsa con gli attrezzi
*/

public class Giocatore {
	
	static final private int CFU_INIZIALI = 30;
	
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
