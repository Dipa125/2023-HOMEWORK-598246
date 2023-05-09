package it.uniroma3.diadia.ambienti;

import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	
	private Map<String,String> direzioni;
	
	private Labirinto labirinto;
	private Stanza ultimaStanza;
	private Map<String,Stanza> listaStanze;
	
/*-----------------------------COSTRUTTORE-----------------------------*/
	
//--Crea un labirinto vuoto
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.listaStanze = new HashMap<String,Stanza>();
		this.ultimaStanza = null;
		
	//--Direzioni ammissibili
		this.direzioni = new HashMap<String,String>();
		direzioni.put("nord", "sud");
		direzioni.put("sud", "nord");
		direzioni.put("est", "ovest");
		direzioni.put("ovest", "est");
	}
	
	
	
/*---------------------------------GET---------------------------------*/
	
//--Ritorna il labirinto creato
	public Labirinto getLabirinto() {return this.labirinto;}
	
//--Ritorna una stanza del nome indicato
	public Stanza getStanza(String nomeStanza) {
		return this.listaStanze.get(nomeStanza);
	}
	
//--Ritona la lista delle stanze
	public Map<String,Stanza> getListaStanze(){
		return this.listaStanze;
	}
	
	
	
/*-------------------------------STANZA--------------------------------*/

//--Crea una stanza e la imposta come stanza iniziale del labirinto
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		Stanza stanzaIniziale = new Stanza(nomeStanza);
		this.listaStanze.put(nomeStanza,stanzaIniziale);
		this.ultimaStanza = stanzaIniziale;
		this.labirinto.setStanzaIniziale(stanzaIniziale);
		return this;
	}

//--Imposta la stanza vincente, se non è quella iniziale ne crea una nuova
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		Stanza stanzaVincente = new Stanza(nomeStanza);
		this.listaStanze.put(nomeStanza,stanzaVincente);
		this.ultimaStanza = stanzaVincente;
		this.labirinto.setStanzaVincente(stanzaVincente);
		return this;
	}

//--Collega due stanze
	public LabirintoBuilder addAdiacenza(String nomeStanzaCorrente, String nomeStanzaCollegata, String direzione) {
		Stanza stanzaCorrente = this.getStanza(nomeStanzaCorrente);
		Stanza stanzaCollegata = this.getStanza(nomeStanzaCollegata);
		if((stanzaCorrente != null) && (stanzaCollegata != null) && direzioni.containsKey(direzione)) {
			stanzaCorrente.impostaStanzaAdiacente(direzione, stanzaCollegata);
			stanzaCollegata.impostaStanzaAdiacente(direzioni.get(direzione), stanzaCorrente);
		}
		else {System.out.println("Stanza non trovata o direzione non ammissibile");}
		return this;
	}

//--Crea una stanza Normale
	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza nuova = new Stanza(nomeStanza);
		this.listaStanze.put(nomeStanza, nuova);
		this.ultimaStanza = nuova;
		return this;
	}

//--Crea una stanza Magica con soglia di default
	public LabirintoBuilder addStanzaMagica(String nomeStanza) {
		StanzaMagica nuova = new StanzaMagica(nomeStanza);
		this.listaStanze.put(nomeStanza, nuova);
		this.ultimaStanza = nuova;
		return this;
	}
	
//--Crea una stanza Magica con soglia impostata
	public LabirintoBuilder addStanzaMagica(String nomeStanza, int soglia) {
		StanzaMagica nuova = new StanzaMagica(nomeStanza,soglia);
		this.listaStanze.put(nomeStanza, nuova);
		this.ultimaStanza = nuova;
		return this;
	}
	
//--Crea una stanza Bloccata
	public LabirintoBuilder addStanzaBloccata(String nomeStanza, String direzione, String oggetto) {
		StanzaBloccata nuova = new StanzaBloccata(nomeStanza,direzione,oggetto);
		this.listaStanze.put(nomeStanza, nuova);
		this.ultimaStanza = nuova;
		return this;
	}
	
//--Crea una stanza Buia
	public LabirintoBuilder addStanzaBuia(String nomeStanza, String oggetto) {
		StanzaBuia nuova = new StanzaBuia(nomeStanza,oggetto);
		this.listaStanze.put(nomeStanza, nuova);
		this.ultimaStanza = nuova;
		return this;
	}	
/*-------------------------------ATTREZZO------------------------------*/
	
//--Aggiunge un attrezzo nell'ultima stanza inserita nel labirinto
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo ,int peso) {
		if(this.ultimaStanza == null) {
			System.out.println("Ancora nessuna stanza inerita");
			return this;
		}
		Attrezzo nuovo = new Attrezzo(nomeAttrezzo, peso);
		this.ultimaStanza.addAttrezzo(nuovo);
		return this;
	}
	
	
}
