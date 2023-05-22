package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoBorsa extends AbstractComando {

	private String tipologia;
	
/*------------------------FUNZIONI PER IL COMANDO-----------------------*/	

//--Stampa tutti gli oggetti della borsa	
	@Override
	public void esegui(Partita partita) {
		if(tipologia == null)
			partita.getIO().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		else if(tipologia.equals("peso"))
			partita.getIO().mostraMessaggio("Contenuto borsa" + partita.getGiocatore().getBorsa().getContenutoOrdinatoPerPeso().toString());
		else if(tipologia.equals("nome"))
			partita.getIO().mostraMessaggio("Contenuto borsa" + partita.getGiocatore().getBorsa().getContenutoOrdinatoPerNome().toString());
		else if(tipologia.equals("group"))
			partita.getIO().mostraMessaggio("Contenuto borsa" + partita.getGiocatore().getBorsa().getContenutoRaggruppatoPerPeso().toString());
		else
			partita.getIO().mostraMessaggio("Parametro non valido");
	}
	
//--Fornisce una descrizione del funzionamento del comando
	public String getDescrizione() {
		return "borsa 'peso-nome-group' --> contenuto della borsa ordinata secondo il parametro(se non inserito fa una stampa standard)";
	}
	
//--Imposta il modo in cui ordinare al borsa
	@Override
	public void setParametro(String parametro) {
		this.tipologia = parametro;
	}
	
}
