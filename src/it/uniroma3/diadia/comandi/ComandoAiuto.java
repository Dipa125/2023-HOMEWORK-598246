package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {

	static final String[] elencoComandi = {"aiuto","borsa","fine","guarda",
										   "posa","prendi","vai","regala"};
	
/*------------------------FUNZIONI PER IL COMANDO-----------------------*/	

//--Stampa tutti i comandi del gioco
	@Override
	public void esegui(Partita partita) {
		AbstractComando comando;
		for(String nomeComando: elencoComandi) 
			try{
				StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
				nomeClasse.append( Character.toUpperCase(nomeComando.charAt(0)) );
				nomeClasse.append( nomeComando.substring(1) );
				comando = (AbstractComando)Class.forName(nomeClasse.toString()).getDeclaredConstructor().newInstance();
				partita.getIO().mostraMessaggio(comando.getDescrizione());
			}catch (Exception e) {
				System.err.println(e);
			}
	}

//--Fornisce una descrizione del funzionamento del comando
	public String getDescrizione() {
		return "aiuto --> mostra la lista dei comandi";
	}
}
