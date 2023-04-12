package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio(partita.getStanzaCorrente().toString());

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String getNome() {
		return "guarda";
	}
	
	@Override
	public String getParametro() {
		return "";
	}

}