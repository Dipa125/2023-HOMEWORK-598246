package it.uniroma3.diadia.properties;

public class Costanti {
	
//-------------PREFISSI PER CARICATORE DEL LABIRINTO-------------------------------------
	static final public String STANZE_MARKER = "Stanze: ";
	static final public String STANZE_MARKER_BLOCCATE = "StanzeBloccate: ";
	static final public String STANZE_MARKER_BUIE = "StanzeBuie: ";
	static final public String STANZE_MARKER_MAGICHE = "StanzeMagiche: ";
	static final public String PERSONAGGI_MARKER = "Personaggi: ";
	static final public String STANZA_INIZIALE_MARKER = "Inizio: ";
	static final public String STANZA_VINCENTE_MARKER = "Vincente: ";
	static final public String ATTREZZI_MARKER = "Attrezzi: ";
	static final public String USCITE_MARKER = "Uscite: ";
	
//------------MESSAGGIO PER DIA DIA-------------------------------------------------------

	static final public String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'."; 
	
//------------------------ATTREZZI-------------------------------------------------------
	static final public int NUMERO_MASSIMO_ATTREZZI = 10;
	
//------------------------BORSA----------------------------------------------------------
	final static public int DEFAULT_PESO_MAX_BORSA = 10;
	
//-----------------------GIOCATORE-------------------------------------------------------
	public final static int CFU_INIZIALI = 10;
	
	

}
