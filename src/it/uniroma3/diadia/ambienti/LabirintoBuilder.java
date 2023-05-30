package it.uniroma3.diadia.ambienti;

import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class LabirintoBuilder {
	
	private Map<String,String> direzioni;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	Map<String,Stanza> mappaStanze;
	
	
/*-----------------------------COSTRUTTORE-----------------------------*/
	
//--Crea un labirinto vuoto
	public LabirintoBuilder() {
		this.mappaStanze = new HashMap<>();
		this.stanzaIniziale = null;
		this.stanzaVincente = null;
		
	//--Direzioni ammissibili
		this.direzioni = new HashMap<String,String>();
		direzioni.put("nord", "sud");
		direzioni.put("sud", "nord");
		direzioni.put("est", "ovest");
		direzioni.put("ovest", "est");
	}
	
	
	
/*---------------------------------GET---------------------------------*/
	
//--Ritorna la mappa delle stanze
	public Map<String,Stanza> getMappaStanze() {return this.mappaStanze;}
	
//--Ritorna una stanza del nome indicato
	public Stanza getStanza(String nomeStanza) {
		return this.mappaStanze.get(nomeStanza);
	}
	
//--Ritorna la iniziale
		public Stanza getStanzaIniziale() {
			return this.stanzaIniziale;
		}
	
//--Ritorna la stanza vincente
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
//--Ritorna la iniziale
		public void setStanzaIniziale(String nomeStanza) {
			this.stanzaIniziale = this.getStanza(nomeStanza);
		}
		
//--Ritorna la stanza vincente
	public void setStanzaVincente(String nomeStanza) {
		this.stanzaVincente = this.getStanza(nomeStanza);
	}
	
	
	
	
	
/*-------------------------------STANZA--------------------------------*/

//--Crea una stanza e la imposta come stanza iniziale del labirinto
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		Stanza stanzaIniziale = new Stanza(nomeStanza);
		this.mappaStanze.put(nomeStanza,stanzaIniziale);
		return this;
	}

//--Imposta la stanza vincente, se non è quella iniziale ne crea una nuova
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		Stanza stanzaVincente = new Stanza(nomeStanza);
		this.mappaStanze.put(nomeStanza,stanzaVincente);
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
		this.mappaStanze.put(nomeStanza, nuova);
		return this;
	}
	
//--Crea una stanza Magica con soglia impostata
	public LabirintoBuilder addStanzaMagica(String nomeStanza, int soglia) {
		StanzaMagica nuova = new StanzaMagica(nomeStanza,soglia);
		this.mappaStanze.put(nomeStanza, nuova);
		return this;
	}
	
//--Crea una stanza Bloccata
	public LabirintoBuilder addStanzaBloccata(String nomeStanza, String direzione, String oggetto) {
		StanzaBloccata nuova = new StanzaBloccata(nomeStanza,direzione,oggetto);
		this.mappaStanze.put(nomeStanza, nuova);
		return this;
	}
	
//--Crea una stanza Buia
	public LabirintoBuilder addStanzaBuia(String nomeStanza, String oggetto) {
		StanzaBuia nuova = new StanzaBuia(nomeStanza,oggetto);
		this.mappaStanze.put(nomeStanza, nuova);
		return this;
	}	
/*-------------------------------ATTREZZO------------------------------*/
	
//--Aggiunge un attrezzo nell'ultima stanza inserita nel labirinto
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo ,int peso, String stanza) {
		if(this.mappaStanze.containsKey(stanza)) {
			Attrezzo nuovo = new Attrezzo(nomeAttrezzo, peso);
			this.mappaStanze.get(stanza).addAttrezzo(nuovo);
			return this;
		}
		System.out.println("Ancora nessuna stanza con questo nome");
		return this;
	}
	
/*-------------------------------Personaggio------------------------------*/	

//--Aggiunge un personaggio nell'ultima stanza inserita nel labirinto
	public LabirintoBuilder addPersonaggio(String nomePersonaggio, String stanza) {
		try {
			StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.personaggi.");
			nomeClasse.append(Character.toUpperCase(nomePersonaggio.charAt(0)) );
			nomeClasse.append(nomePersonaggio.substring(1) );
			AbstractPersonaggio personaggio = (AbstractPersonaggio)Class.forName(nomeClasse.toString()).getDeclaredConstructor().newInstance();

			if(this.mappaStanze.containsKey(stanza)) {
				this.mappaStanze.get(stanza).addPersonaggio(personaggio);
				return this;
			}
			System.out.println("Ancora nessuna stanza con questo nome");
			return this;
		}catch (Exception e) {
			System.out.println("Nome personaggio non valido");
		}
		return this;
	}
}