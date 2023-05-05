package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

/*------------------------FUNZIONI PER IL COMANDO-----------------------*/		

//--Finisce la partita in corso
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("Mancava così poco...");
		partita.setFinita();
	}
	
//--Setta il parametro per il comando se è presente		
	@Override
	public void setParametro(String parametro){}

	
	
/*------------------------FUNZIONI PER I TEST-----------------------*/
	
	@Override
	public String getNome() {
		return "fine";
	}
	
	@Override
	public String getParametro() {
		return "";
	}

}
