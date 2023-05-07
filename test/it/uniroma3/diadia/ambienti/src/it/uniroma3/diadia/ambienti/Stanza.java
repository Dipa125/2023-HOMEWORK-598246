package it.uniroma3.diadia.ambienti;
import java.util.*;

import it.uniroma3.diadia.attrezzi.*;

/**
Una stanza e' un luogo fisico nel gioco.
E' collegata ad altre stanze attraverso delle uscite.
Ogni uscita e' associata ad una direzione.
Alcune stanze contengono degli oggetti
**/

public class Stanza {

	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
	private Set<Attrezzo> attrezzi;
	private Map<String,Stanza> stanzeAdiacenti;

/*-----------------------------COSTRUTTORE-----------------------------*/	
	
//--Costruttore di una stanza vuota senza uscite
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<String,Stanza>();
        this.attrezzi = new HashSet<Attrezzo>();
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
    
//--Restituisce la descrizione della stanza
    public String getDescrizione() {return this.toString();}

//--Restituisce le stanze adiacenti
    public Map<String, Stanza>getMapStanzeAdiacenti(){return this.stanzeAdiacenti;}
    
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

	
	
/*--------------------------OVERRIDE--------------------------*/	
	
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