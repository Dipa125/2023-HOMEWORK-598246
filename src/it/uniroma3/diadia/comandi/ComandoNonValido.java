package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("Questo comando non esiste non so cosa fare");
	}
	
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	}
	@Override
	public String getNome() {
		return "non valido";
	}
	
	@Override
	public String getParametro() {
		return "";
	}

}
