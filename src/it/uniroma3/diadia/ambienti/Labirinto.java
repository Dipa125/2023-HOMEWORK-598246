package it.uniroma3.diadia.ambienti;

public class Labirinto {

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

/*-----------------------------COSTRUTTORE-----------------------------*/	

/*-------------------------------GET/SET------------------------------------*/
	public Stanza getStanzaIniziale() {return stanzaIniziale;}
    
    public Stanza getStanzaVincente() {return stanzaVincente;}
   
    public void setStanzaIniziale(Stanza iniziale) {this.stanzaIniziale = iniziale;}
    
    public void setStanzaVincente(Stanza vincente) {this.stanzaVincente = vincente;}
   
}
