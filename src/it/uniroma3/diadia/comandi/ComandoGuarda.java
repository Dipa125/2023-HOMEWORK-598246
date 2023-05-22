package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

/*------------------------FUNZIONI PER IL COMANDO-----------------------*/	
	
//--Stampa le caratteristiche della stanza corrente
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio(partita.getStanzaCorrente().toString());

	}

//--Fornisce una descrizione del funzionamento del comando
	public String getDescrizione() {
		return "guarda --> fornisce informazioni sulla stanza corrente";
	}
}
