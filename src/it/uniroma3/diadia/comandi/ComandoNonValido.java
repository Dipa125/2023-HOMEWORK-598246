package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {

/*------------------------FUNZIONI PER IL COMANDO-----------------------*/

//--Ogni volta che il comando non esiste
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("Questo comando non esiste non so cosa fare");
	}
	
//--Fornisce una descrizione del funzionamento del comando
	public String getDescrizione() {
		return "NonValido --> ogni volta che viene usato un camando inesistente";
	}
}
