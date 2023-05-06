package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.*;

/**
Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
Per giocare crea un'istanza di questa classe e invoca il letodo gioca

Questa e' la classe principale crea e istanzia tutte le altre
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
		

	private Partita partita;
	private Labirinto labirinto;
	private IO io;

/*-----------------------------COSTRUTTORE-----------------------------*/	

//--Costruttore di tutto il gioco
	public DiaDia(Labirinto labirinto, IO io) {
		this.partita = new Partita(labirinto,io);
		this.labirinto = labirinto;
		this.io = io;
	}

	
	
/*----------------------------GIOCO-----------------------------*/

//--Funzione che permette di giocare ocn un ciclo
	public void gioca() {
		String istruzione;
		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}

//--Processa le istruzione
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.vinta())
			System.out.println("Hai vinto!");
		
		if (!this.partita.giocatoreIsVivo())
			System.out.println("Hai esaurito i CFU...");

		return this.partita.isFinita();
	} 

	
	
/*----------------------------MAIN-----------------------------*/

//--Prima parte di codice eseguita
	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto labirinto = new Labirinto();
		DiaDia gioco = new DiaDia(labirinto,io);
		gioco.gioca();
	}

}