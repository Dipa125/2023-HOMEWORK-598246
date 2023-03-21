import java.util.Scanner;

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

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   

	/**
	Processa una istruzione 
	
	@return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	**/
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome() == null) {
			System.out.println("Comando sconosciuto");
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
			System.out.println("Comando sconosciuto");
		
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
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
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	e ne stampa il nome, altrimenti stampa un messaggio di errore
	**/
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getPlayer().getCfu();
			this.partita.getPlayer().setCfu(cfu--);
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	Comando "Prendi".
	**/
	private void prendi(String nome) {
		if(nome==null){
			System.out.println("Cosa vuoi prendere?");
			String lista_attrezzi = "";
			for(Attrezzo elem : this.partita.getStanzaCorrente().getAttrezzi()){
				if(elem != null) {
					lista_attrezzi += elem;
					lista_attrezzi += "		";
				}
				else
					break;
			}
			System.out.println(lista_attrezzi);
		}
		Attrezzo attrezzoDaPrendere = null;
		attrezzoDaPrendere = this.partita.getStanzaCorrente().getAttrezzo(nome);
		if (attrezzoDaPrendere == null)
			System.out.println("Attrezzo inesistente");
		else {
			if(this.partita.getPlayer().getBorsa().addAttrezzo(attrezzoDaPrendere)) {
				System.out.println("Attrezzo preso");
				this.partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);				
			}
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}
	
	/**
	Comando "Posa".
	**/
	private void posa(String nome) {
		if(nome==null){
			System.out.println("Cosa vuoi posare?");
			String lista_attrezzi = "";
			for(Attrezzo elem : this.partita.getPlayer().getBorsa().getAttrezzi()){
				if(elem != null) {
					lista_attrezzi += elem;
					lista_attrezzi += "		";
				}
				else
					break;
			}
			System.out.println(lista_attrezzi);
		}
		Attrezzo attrezzoDaPosare = null;
		attrezzoDaPosare = this.partita.getPlayer().getBorsa().getAttrezzo(nome);
		if (attrezzoDaPosare == null)
			System.out.println("Attrezzo inesistente");
		else {
			if(this.partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare)) {
				System.out.println("Attrezzo posato");
				this.partita.getPlayer().getBorsa().removeAttrezzo(nome);
			}
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}
	
	/**
	Comando "Fine".
	**/
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}

}