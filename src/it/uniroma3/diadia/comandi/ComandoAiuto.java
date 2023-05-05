package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

/*------------------------FUNZIONI PER IL COMANDO-----------------------*/	

//--Stampa tutti i comandi del gioco
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			partita.getIO().mostraMessaggio(elencoComandi[i]+" ");
		partita.getIO().mostraMessaggio("");

	}

//--Setta il parametro per il comando se è presente	
	@Override
	public void setParametro(String parametro){}

	
	
/*------------------------FUNZIONI PER I TEST-----------------------*/
	
	@Override
	public String getNome() {
		return "aiuto";
	}
	
	@Override
	public String getParametro() {
		return "";
	}

}
