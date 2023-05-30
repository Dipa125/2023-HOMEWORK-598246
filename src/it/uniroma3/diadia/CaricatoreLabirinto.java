package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.*;
import static it.uniroma3.diadia.properties.Costanti.*;

import java.io.*;
import java.util.*;

public class CaricatoreLabirinto {

	private LineNumberReader reader;
	private LabirintoBuilder labBuilder;


	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		try {
			this.reader = new LineNumberReader(new FileReader(nomeFile));
		}catch (Exception e) {
			this.reader = new LineNumberReader(new StringReader(nomeFile));
		}
		
		this.labBuilder = new LabirintoBuilder();
	}

	public Map<String,Stanza> carica() throws FormatoFileNonValidoException {
		try {
			this.leggiECreaStanze();
			this.leggiECreaStanzeBloccate();
			this.leggiECreaStanzeBuie();
			this.leggiECreaStanzeMagiche();
			this.leggiInizialeEvincente();
			this.leggiECollocaAttrezzi();
			this.leggiEImpostaUscite();
			this.leggiEImpostaPersonaggi();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return this.labBuilder.getMappaStanze();
	}
	
	public Stanza getStanzaIniziale() throws FormatoFileNonValidoException {
		return this.labBuilder.getStanzaIniziale();
	}
	
	public Stanza getStanzaVincente(){
		return this.labBuilder.getStanzaVincente();
	}

	private String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
		try {
			String riga = this.reader.readLine();
			check(riga.startsWith(marker),"era attesa una riga che cominciasse per "+marker);
			return riga.substring(marker.length());
		} catch (IOException e) {
			throw new FormatoFileNonValidoException(e.getMessage());
		}
	}

	private void leggiECreaStanze() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER);
		for(String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
			this.labBuilder.addStanza(nomeStanza);
		}
	}
	
	private void leggiECreaStanzeBloccate() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER_BLOCCATE);
		for(String SpecificaStanzaBloccata : separaStringheAlleVirgole(nomiStanze)) {
			String nomeStanza = null;
			String direzione = null;
			String nomeAttrezzo = null; 
			try (Scanner scannerLinea = new Scanner(SpecificaStanzaBloccata)) {
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di una stanza bloccata."));
				nomeStanza = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("la direzione "+direzione+" bloccata."));
				direzione = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome dell'oggetto per sbloccarla "+nomeAttrezzo+"."));
				nomeAttrezzo = scannerLinea.next();
			}
			this.labBuilder.addStanzaBloccata(nomeStanza,direzione,nomeAttrezzo);
		}
	}
	
	private void leggiECreaStanzeBuie() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER_BUIE);
		for(String SpecificaStanzaBuia : separaStringheAlleVirgole(nomiStanze)) {
			String nomeStanza = null;
			String nomeAttrezzo = null; 
			try (Scanner scannerLinea = new Scanner(SpecificaStanzaBuia)) {
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di una stanza buia."));
				nomeStanza = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome dell'oggetto per illuminarla "+nomeAttrezzo+"."));
				nomeAttrezzo = scannerLinea.next();
			}
			this.labBuilder.addStanzaBuia(nomeStanza,nomeAttrezzo);
		}
	}
	private void leggiECreaStanzeMagiche() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER_MAGICHE);
		for(String SpecificaStanzaMagica : separaStringheAlleVirgole(nomiStanze)) {
			String nomeStanza = null;
			String sogliaStr = null; 
			try (Scanner scannerLinea = new Scanner(SpecificaStanzaMagica)) {
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di una stanza magica."));
				nomeStanza = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il numero della sua soglia "+sogliaStr+"."));
				sogliaStr = scannerLinea.next();
			}
			int sogliaInt = Integer.parseInt(sogliaStr);
			this.labBuilder.addStanzaMagica(nomeStanza,sogliaInt);
		}
	}
	
	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		String nomeStanzaIniziale = this.leggiRigaCheCominciaPer(STANZA_INIZIALE_MARKER);
		check(this.isStanzaValida(nomeStanzaIniziale), nomeStanzaIniziale +" non definita");
		
		String nomeStanzaVincente = this.leggiRigaCheCominciaPer(STANZA_VINCENTE_MARKER);
		check(this.isStanzaValida(nomeStanzaVincente), nomeStanzaVincente + " non definita");
		
		this.labBuilder.setStanzaIniziale(nomeStanzaIniziale);
		this.labBuilder.setStanzaVincente(nomeStanzaVincente);
	}

	private List<String> separaStringheAlleVirgole(String string) {
		List<String> result = new LinkedList<>();
		try (Scanner scanner = new Scanner(string)) {
			scanner.useDelimiter(", ");
			while(scanner.hasNext()) {
				result.add(scanner.next());			
			}
		}
		return result;
	}

	private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
		String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);

		for(String specificaAttrezzo : separaStringheAlleVirgole(specificheAttrezzi)) {
			String nomeAttrezzo = null;
			String pesoAttrezzo = null;
			String nomeStanza = null; 
			try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di un attrezzo."));
				nomeAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il peso dell'attrezzo "+nomeAttrezzo+"."));
				pesoAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza in cui collocare l'attrezzo "+nomeAttrezzo+"."));
				nomeStanza = scannerLinea.next();
			}				
			posaAttrezzo(nomeAttrezzo, pesoAttrezzo, nomeStanza);
		}
	}

	private void posaAttrezzo(String nomeAttrezzo, String pesoAttrezzo, String nomeStanza) throws FormatoFileNonValidoException {
		int peso;
		try {
			peso = Integer.parseInt(pesoAttrezzo);
			check(isStanzaValida(nomeStanza),"Attrezzo "+ nomeAttrezzo+" non collocabile: stanza " +nomeStanza+" inesistente");
			this.labBuilder.addAttrezzo(nomeAttrezzo, peso, nomeStanza);
		}
		catch (NumberFormatException e) {
			check(false, "Peso attrezzo "+nomeAttrezzo+" non valido");
		}
	}


	private boolean isStanzaValida(String nomeStanza) {
		return this.labBuilder.getMappaStanze().containsKey(nomeStanza);
	}

	private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
		String specificheUscite = this.leggiRigaCheCominciaPer(USCITE_MARKER);
		for(String infoCollegamenti : separaStringheAlleVirgole(specificheUscite)) {
			try (Scanner scannerDiLinea = new Scanner(infoCollegamenti)) {
				while (scannerDiLinea.hasNext()) {
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("le uscite di una stanza."));
					String stanzaPartenza = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la direzione di una uscita della stanza "+stanzaPartenza));
					String dir = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la destinazione di una uscita della stanza "+stanzaPartenza+" nella direzione "+dir));
					String stanzaDestinazione = scannerDiLinea.next();
					impostaUscita(stanzaPartenza, dir, stanzaDestinazione);
				}
			}
		}
	}
	
	private String msgTerminazionePrecoce(String msg) {
		return "Terminazione precoce del file prima di leggere "+msg;
	}

	private void impostaUscita(String stanzaDa, String dir, String nomeA) throws FormatoFileNonValidoException {
		check(isStanzaValida(stanzaDa),"Stanza di partenza sconosciuta "+dir);
		check(isStanzaValida(nomeA),"Stanza di destinazione sconosciuta "+ nomeA);
		this.labBuilder.addAdiacenza(stanzaDa, nomeA, dir);
	}


	final private void check(boolean condizioneCheDeveEsseraVera, String messaggioErrore) throws FormatoFileNonValidoException {
		if (!condizioneCheDeveEsseraVera)
			throw new FormatoFileNonValidoException("Formato file non valido [" + this.reader.getLineNumber() + "]"+messaggioErrore);		
	}
	
	private void leggiEImpostaPersonaggi() throws FormatoFileNonValidoException{
		String nomiPersonaggi = this.leggiRigaCheCominciaPer(PERSONAGGI_MARKER);
		for(String SpecificaStanzaBuia : separaStringheAlleVirgole(nomiPersonaggi)) {
			String nomeClassePersoanggio = null;
			String nomeStanza = null; 
			try (Scanner scannerLinea = new Scanner(SpecificaStanzaBuia)) {
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("Classe del personaggio "+nomeClassePersoanggio+"."));
				nomeClassePersoanggio = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("Stanza in cui collocarlo "+nomeStanza+"."));
				nomeStanza = scannerLinea.next();
			}
			
			this.labBuilder.addPersonaggio(nomeClassePersoanggio,nomeStanza);
		}
	}
}
