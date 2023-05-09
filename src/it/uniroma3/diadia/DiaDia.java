package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
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
	private IO io;

/*-----------------------------COSTRUTTORE-----------------------------*/	

//--Costruttore di tutto il gioco
	public DiaDia(IO io) {
		
		Labirinto labirinto = new LabirintoBuilder().addStanzaIniziale("Atrio").addAttrezzo("secchio", 5).addAttrezzo("cartaccia", 1)
							  .addStanzaMagica("Laboratorio").addAttrezzo("tavolo", 15).addAttrezzo("pc", 5)
							  .addStanza("N10").addAttrezzo("lim", 30)
							  .addStanzaBloccata("N11","est","moneta").addAttrezzo("lavagna", 20).addAttrezzo("gesso", 1)
							  .addStanza("Portineria").addAttrezzo("chiaveLunga", 3).addAttrezzo("chiave", 2)
							  .addStanza("N9").addAttrezzo("Torcia", 4)
							  .addStanzaBloccata("Mensa","sud","chiave").addAttrezzo("avanzi", 3)
							  .addStanzaBuia("Dispensa","torcia").addAttrezzo("moneta", 1)
							  .addStanzaVincente("Biblioteca")
							  .addAdiacenza("Atrio", "Laboratorio", "nord")
							  .addAdiacenza("Atrio", "Mensa", "sud")
							  .addAdiacenza("Atrio", "N10", "est")
							  .addAdiacenza("Laboratorio", "N9", "ovest")
							  .addAdiacenza("Mensa", "Dispensa", "sud")
							  .addAdiacenza("N10", "N11", "est")
							  .addAdiacenza("N11", "Portineria", "nord")
							  .addAdiacenza("N11", "Biblioteca", "est")
							  .getLabirinto();
		
		this.partita = new Partita(labirinto,io);
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
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}

}