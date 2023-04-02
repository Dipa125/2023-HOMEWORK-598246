package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;

/**
Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
Per giocare crea un'istanza di questa classe e invoca il letodo gioca

Questa e' la classe principale crea e istanzia tutte le altre

@author  docente di POO 
(da un'idea di Michael Kolling and David J. Barnes) 
          
@version base
**/
public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'."; 
		
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	private Partita partita;
	private IOConsole IO;

	public DiaDia(IOConsole io) {
		this.partita = new Partita();
		this.IO = io;
	}

	public void gioca() {
		String istruzione;
		
		this.IO.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		do		
			istruzione = this.IO.leggiRiga();
		while (!processaIstruzione(istruzione));
	}

	/**
	Processa una istruzione 
	
	@return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	**/
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome() == null) {
			this.IO.mostraMessaggio("Comando sconosciuto");
		}
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		}
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		
		else
			this.IO.mostraMessaggio("Comando sconosciuto");
		
		if (this.partita.vinta()) {
			this.IO.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	
	// implementazioni dei comandi dell'utente:

	/**
	Stampa informazioni di aiuto.
	**/
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.IO.mostraMessaggio(elencoComandi[i]+" ");
		this.IO.mostraMessaggio("");
	}

	/**
	Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	e ne stampa il nome, altrimenti stampa un messaggio di errore
	**/
	private void vai(String direzione) {
		if(direzione==null)
			this.IO.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.IO.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getPlayer().getCfu();
			this.partita.getPlayer().setCfu(cfu--);
		}
		this.IO.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	Comando "Prendi".
	**/
	private void prendi(String nome) {
		if(nome == null) {
			this.IO.mostraMessaggio("Quale oggetto vuoi prendere?");
			String lista = "";
			for(Attrezzo a : this.partita.getStanzaCorrente().getAttrezzi()) {
				if(a != null) {
					lista += a;
					lista += "     ";
				}
			}
			this.IO.mostraMessaggio(lista);
		}
		else {
			Attrezzo daPrendere = this.partita.getStanzaCorrente().getAttrezzo(nome);
			if(daPrendere == null)
				this.IO.mostraMessaggio("Attrezzo inesistente");
			else {
				if(this.partita.getPlayer().getBorsa().addAttrezzo(daPrendere)) {
					this.partita.getStanzaCorrente().removeAttrezzo(daPrendere);
					this.IO.mostraMessaggio("Attrezzo preso");
				}
				else
					this.IO.mostraMessaggio("Borsa piena");
			}
			this.IO.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		}
	}
	
	/**
	Comando "Posa".
	**/
	private void posa(String nome) {
		if(nome == null) {
			this.IO.mostraMessaggio("Quale oggetto vuoi posare?");
			String lista = "";
			for(Attrezzo a : this.partita.getPlayer().getBorsa().getAttrezzi()) {
				if(a != null) {
					lista += a;
					lista += "     ";
				}
			}
			this.IO.mostraMessaggio(lista);
		}
		else {
			Attrezzo daPosare = this.partita.getPlayer().getBorsa().getAttrezzo(nome);
			if(daPosare == null)
				this.IO.mostraMessaggio("Attrezzo inesistente");
			else {
				if(this.partita.getStanzaCorrente().addAttrezzo(daPosare)) {
					this.partita.getPlayer().getBorsa().removeAttrezzo(nome);
					this.IO.mostraMessaggio("Attrezzo posato");
				}
				else
					this.IO.mostraMessaggio("Stanza piena");	
			}
			this.IO.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		}
	}
	
	/**
	Comando "Fine".
	**/
	private void fine() {
		this.IO.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
		
	}

}