package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

/*------------------------FUNZIONI PER IL COMANDO-----------------------*/

//--Ogni volta che il comando non esiste
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("Questo comando non esiste non so cosa fare");
	}

//--Setta il parametro per il comando se è presente	
	@Override
	public void setParametro(String parametro){}
	
	
	
	
/*------------------------FUNZIONI PER I TEST-----------------------*/	
	
	@Override
	public String getNome() {
		return "non valido";
	}
	
	@Override
	public String getParametro() {
		return "";
	}

}
