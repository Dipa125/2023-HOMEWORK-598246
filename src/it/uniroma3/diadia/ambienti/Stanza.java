package it.uniroma3.diadia.ambienti;
import java.util.*;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

import static it.uniroma3.diadia.properties.Costanti.NUMERO_MASSIMO_ATTREZZI;

public class Stanza {
	
	private String nome;
	private Set<Attrezzo> attrezzi;
	private Map<String,Stanza> stanzeAdiacenti;
	private AbstractPersonaggio personaggio;

/*-----------------------------COSTRUTTORE-----------------------------*/	
	
//--Costruttore di una stanza vuota senza uscite e senza personaggio
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<String,Stanza>();
        this.attrezzi = new HashSet<Attrezzo>();
        this.personaggio = null;
    }

/*---------------------------------GET----------------------------------*/
    
//--Restituisce il nome della stanza
    public String getNome() {return this.nome;}
    
//--Restituisce la collezione di attrezzi presenti nella stanza
    public Set<Attrezzo> getAttrezzi() {return this.attrezzi;}
  
//--Numero di attrezzi nella stanza
	public int getNumeroAttrezzi() {return this.attrezzi.size();}
	

//--Ritorna un insieme con tutte le direzioni di uscita dalla stanza
	public Set<String> getDirezioni() {return this.stanzeAdiacenti.keySet();}
	
//--Restituisce la stanza adiacente nella direzione specificata
	public Stanza getStanzaAdiacente(String direzione) {return this.stanzeAdiacenti.get(direzione);}
    
//--Restituisce le stanze adiacenti
    public Map<String, Stanza>getMapStanzeAdiacenti(){return this.stanzeAdiacenti;}
    
//--Restituisce il personaggio nella stanza, altrimenti null
    public AbstractPersonaggio getPersonaggio() {return this.personaggio;}
    
    
/*-------------------------------STANZA-------------------------------*/

//  Imposta una stanza adiacente
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
    	this.stanzeAdiacenti.put(direzione, stanza);
    }
    
    
    
/*-------------------------------ATTREZZO-------------------------------*/

//--Mette un attrezzo nella stanza
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if(this.attrezzi.size() < NUMERO_MASSIMO_ATTREZZI)
        	return this.attrezzi.add(attrezzo);
        
        return false;
    }

//--Controlla se un attrezzo esiste nella stanza
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!= null;
	}

//--Restituisce l'attrezzo nomeAttrezzo se presente nella stanza
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
		
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			Attrezzo a = iteratore.next();
			if(nomeAttrezzo.equals(a.getNome()))
				attrezzoCercato = a;	
		}
		return attrezzoCercato;
	}

//--Rimuove un attrezzo dalla stanza
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.remove(attrezzo);
			
	}	

/*-------------------------------PERSONAGGIO-------------------------------*/
	
//--Mette un attrezzo nella stanza
    public boolean addPersonaggio(AbstractPersonaggio p) {
        if(this.personaggio == null) {
            this.personaggio = p;
        	return true;
        }        
        return false;
    }	
	
/*--------------------------------OVERRIDE----------------------------------*/	
	
//--Restituisce una rappresentazione stringa di questa stanza
    @Override
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append("Stanza Corrente: " + this.nome);
    	risultato.append("\nUscite:");
    	
    	for (String direzione : this.stanzeAdiacenti.keySet())
    		risultato.append(" " + direzione);
    	
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo attrezzo : this.attrezzi)
    		risultato.append(attrezzo.toString()+" ");
    	risultato.append("\nPersonaggio: ");
    	if(this.personaggio != null) {risultato.append(this.personaggio.getClass().getSimpleName());}
    	
    	return risultato.toString();	
    }
	
	@Override
	public boolean equals(Object o) {
		Stanza test = (Stanza) o;
		if(this.nome == test.getNome()) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}
}