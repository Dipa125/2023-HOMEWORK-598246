package it.uniroma3.diadia;
import java.util.Scanner;

public class IOConsole implements IO {
	
	Scanner scannerDiLinee;
	
	public IOConsole(Scanner scannerDiLinee) {
		this.scannerDiLinee = scannerDiLinee;
	}

//--Stampa il messaggio sul terminale
	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
	}

//--Legge le scritte sul terminale
	@Override
	public String leggiRiga() {
		String riga = this.scannerDiLinee.nextLine();
		return riga;
	}
}