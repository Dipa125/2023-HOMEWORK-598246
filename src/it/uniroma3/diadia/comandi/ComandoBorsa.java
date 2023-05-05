package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoBorsa implements Comando {

	private String tipologia;
	
/*------------------------FUNZIONI PER IL COMANDO-----------------------*/	

//--Stampa tutti gli oggetti della borsa	
	@Override
	public void esegui(Partita partita) {
		if(tipologia == null)
			partita.getIO().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		else if(tipologia.equals("peso"))
			partita.getIO().mostraMessaggio(partita.getGiocatore().getBorsa().getContenutoOrdinatoPerPeso().toString());
		else if(tipologia.equals("nome"))
			partita.getIO().mostraMessaggio(partita.getGiocatore().getBorsa().getContenutoOrdinatoPerNome().toString());
		else if(tipologia.equals("group"))
			partita.getIO().mostraMessaggio(partita.getGiocatore().getBorsa().getContenutoRaggruppatoPerPeso().toString());
		else
			partita.getIO().mostraMessaggio("Parametro non valido");
	}

//--Setta il parametro per il comando se è presente		
	@Override
	public void setParametro(String parametro) {
		this.tipologia = parametro;
	}

	
	
	
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
