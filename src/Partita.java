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
	private Giocatore player;
	private boolean finita;
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.stanzaCorrente = labirinto.getStanzaIniziale();
		this.player = new Giocatore();	
		this.finita = false;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Giocatore getPlayer() {
		return this.player;
	}
	
	/**
	Restituisce vero se e solo se la partita e' stata vinta
	@return vero se partita vinta
	**/
	public boolean vinta() {
		return this.getStanzaCorrente()== labirinto.getStanzaVincente();
	}

	/**
	Restituisce vero se e solo se la partita e' finita
	@return vero se partita finita
	**/
	public boolean isFinita() {
		return finita || vinta() || (player.getCfu() == 0);
	}

	/**
	Imposta la partita come finita
	**/
	public void setFinita() {
		this.finita = true;
	}

}
