package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi{

/*-----------------------------SCELTA COMANDO------------------------------*/	
	
	
	@Override
	public AbstractComando costruisciComando(String istruzione){
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		AbstractComando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();//prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();//seconda parola: eventuale parametro
		
		try {
			StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
			nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)) );
			nomeClasse.append(nomeComando.substring(1) );
			comando = (AbstractComando)Class.forName(nomeClasse.toString()).getDeclaredConstructor().newInstance();
			comando.setParametro(parametro);
		} catch (Exception e) {
			comando = new ComandoNonValido();
		} finally {
			scannerDiParole.close();
		}
		return comando;
	}

}
