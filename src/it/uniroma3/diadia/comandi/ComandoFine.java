package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {

/*------------------------FUNZIONI PER IL COMANDO-----------------------*/		

//--Finisce la partita in corso
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("Mancava così poco...");
		partita.setFinita();
	}

//--Fornisce una descrizione del funzionamento del comando
	public String getDescrizione() {
		return "fine --> termina la partita";
	}

}
