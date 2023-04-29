package it.uniroma3.diadia;

import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.ambienti.*;

/**
Questa classe modella una partita del gioco

@author  docente di POO
@see Stanza
@version base
**/
public class Partita {

	//static final private int CFU_INIZIALI = 20;

	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private Giocatore giocatore;
	private boolean finita;
	private IO io;
	
	public Partita(IO io){
		this.labirinto = new Labirinto();
		this.stanzaCorrente = labirinto.getStanzaIniziale();
		this.giocatore = new Giocatore();	
		this.finita = false;
		this.io = io;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public IO getIO() {
		return this.io;
	}
	
	/**
	Restituisce vero se e solo se la partita e' stata vinta
	@return vero se partita vinta
	**/
	public boolean vinta() {
		return this.getStanzaCorrente() == labirinto.getStanzaVincente();
	}

	/**
	Restituisce vero se e solo se la partita e' finita
	@return vero se partita finita
	**/
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	Imposta la partita come finita
	**/
	public void setFinita() {
		this.finita = true;
	}
	
	public boolean giocatoreIsVivo() {
		if(this.giocatore.getCfu() <= 0) {
			return false;
		}
		return true;
	}
	
}
