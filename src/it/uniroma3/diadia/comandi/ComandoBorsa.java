package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoBorsa implements Comando {

/*------------------------FUNZIONI PER IL COMANDO-----------------------*/	

//--Stampa tutti gli oggetti della borsa	
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		
	}

//--Setta il parametro per il comando se è presente		
	@Override
	public void setParametro(String parametro) {}

	
	
	
/*------------------------FUNZIONI PER I TEST-----------------------*/
	
	@Override
	public String getNome() {
		return "borsa";
	}

	@Override
	public String getParametro() {
		return "";
	}
	
}
