package it.uniroma3.diadia;

import java.io.FileNotFoundException;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.*;
import static it.uniroma3.diadia.properties.Costanti.MESSAGGIO_BENVENUTO;

public class DiaDia {
		
	private Partita partita;
	private IO io;

/*-----------------------------COSTRUTTORE-----------------------------*/	

//--Costruttore di tutto il gioco con un labirinto standard
	public DiaDia(IO io) throws FileNotFoundException, FormatoFileNonValidoException{
		
		
		Labirinto labirinto = new Labirinto("LabFile.txt");
		
		this.partita = new Partita(labirinto,io);
		this.io = io;
	}
	
//--Costruttore di tutto il gioco con un labirinto implementato nel main 
public DiaDia(Labirinto lab,IO io) {
		
		Labirinto labirinto = lab;
		this.partita = new Partita(labirinto,io);
		this.io = io;
	}
	
/*----------------------------GIOCO-----------------------------*/

//--Funzione che permette di giocare ocn un ciclo
	public void gioca(){
		String istruzione;
		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}

//--Processa le istruzione
	private boolean processaIstruzione(String istruzione){
		AbstractComando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva();
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
	public static void main(String[] argc) throws FileNotFoundException, FormatoFileNonValidoException{
		
		Scanner scannerDiLinee = new Scanner(System.in);
		IO io = new IOConsole(scannerDiLinee);
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
		scannerDiLinee.close();
	}

}