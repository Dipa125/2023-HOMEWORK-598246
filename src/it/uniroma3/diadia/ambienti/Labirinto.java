package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

public class Labirinto {

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	private Map<String,Stanza> listaStanze;
	
	public Labirinto(){
		this.listaStanze = new HashMap<String,Stanza>();
	}

/*-----------------------------COSTRUTTORE-----------------------------*/	

/*-------------------------------GET/SET------------------------------------*/
	public Stanza getStanzaIniziale() {return this.stanzaIniziale;}
    
    public Stanza getStanzaVincente() {return this.stanzaVincente;}
    
    public Map<String,Stanza> getMappaStanze() {return this.listaStanze;}
   
    public void setStanzaIniziale(Stanza iniziale) {this.stanzaIniziale = iniziale;}
    
    public void setStanzaVincente(Stanza vincente) {this.stanzaVincente = vincente;}
   
}
