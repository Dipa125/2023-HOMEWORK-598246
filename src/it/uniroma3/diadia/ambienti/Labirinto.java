package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;

public class Labirinto {

	private Map<String,Stanza> listaStanze;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	public Labirinto(String nomeFile) throws FormatoFileNonValidoException, FileNotFoundException{
		this.listaStanze = new HashMap<String,Stanza>();
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		this.listaStanze = c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}

/*-----------------------------COSTRUTTORE-----------------------------*/	

/*-------------------------------GET/SET------------------------------------*/
	public Stanza getStanzaIniziale() {return this.stanzaIniziale;}
    
    public Stanza getStanzaVincente() {return this.stanzaVincente;}
    
    public Map<String,Stanza> getMappaStanze() {return this.listaStanze;}
   
    public void setStanzaIniziale(Stanza iniziale) {this.stanzaIniziale = iniziale;}
    
    public void setStanzaVincente(Stanza vincente) {this.stanzaVincente = vincente;}
   
}
