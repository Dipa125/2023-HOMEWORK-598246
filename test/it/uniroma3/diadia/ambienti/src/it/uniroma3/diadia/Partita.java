package it.uniroma3.diadia;

import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.ambienti.*;

/*
Questa classe modella una partita del gioco
*/
public class Partita {

	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private Giocatore giocatore;
	private boolean finita;
	private IO io;

/*-----------------------------COSTRUTTORE-----------------------------*/		
	
	public Partita(Labirinto labirinto,IO io){
		this.labirinto = labirinto;
		this.stanzaCorrente = labirinto.getStanzaIniziale();
		this.giocatore = new Giocatore();	
		this.finita = false;
		this.io = io;
	}

/*------------------------------SET/GET-------------------------------*/

//--Imposta la stanza in cui è il giocatore
	public void setStanzaCorrente(Stanza stanzaCorrente) {this.stanzaCorrente = stanzaCorrente;}

//--Ritorna la stanza in cui è il giocatore	
	public Stanza getStanzaCorrente() {return this.stanzaCorrente;}

//--Ritorna il Giocatore		
	public Giocatore getGiocatore() {return this.giocatore;}

//--Ritorna IO	
	public IO getIO() {return this.io;}
	
//--Imposta la partita come finita
	public void setFinita() {this.finita = true;}
	
//--Imposta il labirinto
	public void setLabirinto(Labirinto labirinto) {this.labirinto = labirinto;}
	
/*-------------------------GESTIONE DEL GIOCO--------------------------*/
	
//--Restituisce vero se e solo se la partita e' stata vinta
	public boolean vinta() {
		return this.getStanzaCorrente() == labirinto.getStanzaVincente();
	}


//--Restituisce vero se e solo se la partita e' finita
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}


//--Restituisce vero solo se il giocatore è ancora vivo
	public boolean giocatoreIsVivo() {
		if(this.giocatore.getCfu() <= 0) {
			return false;
		}
		return true;
	}
	
}
