package it.uniroma3.diadia;
import java.util.Scanner;

public class IOConsole implements IO {

//--Stampa il messaggio sul terminale
	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
	}

//--Legge le scritte sul terminale
	@Override
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		return riga;
	}
}