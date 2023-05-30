package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.*;

import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {

	private String nomeStanzaIniziale = "atrio";
	private String nomeStanzaVincente = "uscita";


	@Test//----------------------------------------------------------------------------------------//
	public void testMonolocale() throws FileNotFoundException, FormatoFileNonValidoException {
		String labString = "Stanze: atrio\r\n"
				+ "StanzeBloccate: \r\n"
				+ "StanzeBuie: \r\n"
				+ "StanzeMagiche: \r\n"
				+ "Inizio: atrio\r\n"
				+ "Vincente: atrio\r\n"
				+ "Attrezzi: \r\n"
				+ "Uscite: \r\n"
				+ "Personaggi: ";
		Labirinto monolocale = new Labirinto(labString);
	
		assertEquals(nomeStanzaIniziale,monolocale.getStanzaIniziale().getNome());
		assertEquals(nomeStanzaIniziale,monolocale.getStanzaVincente().getNome());
	}

	@Test//----------------------------------------------------------------------------------------//
	public void testMonolocaleConAttrezzo() throws FileNotFoundException, FormatoFileNonValidoException {
		String labString = "Stanze: atrio\r\n"
				+ "StanzeBloccate: \r\n"
				+ "StanzeBuie: \r\n"
				+ "StanzeMagiche: \r\n"
				+ "Inizio: atrio\r\n"
				+ "Vincente: atrio\r\n"
				+ "Attrezzi: spada 1 atrio, spadina 1 atrio\r\n"
				+ "Uscite: \r\n"
				+ "Personaggi: ";
		Labirinto monolocale = new Labirinto(labString);
	
		assertEquals(nomeStanzaIniziale,monolocale.getStanzaIniziale().getNome());
		assertEquals(nomeStanzaIniziale,monolocale.getStanzaVincente().getNome());
		assertEquals("spada",monolocale.getStanzaIniziale().getAttrezzo("spada").getNome());
		assertEquals("spadina",monolocale.getStanzaVincente().getAttrezzo("spadina").getNome());
	}
	
	@Test//----------------------------------------------------------------------------------------//
	public void testMonolocaleConAttrezzoSingoloDuplicato() throws FileNotFoundException, FormatoFileNonValidoException {
		String labString = "Stanze: atrio\r\n"
				+ "StanzeBloccate: \r\n"
				+ "StanzeBuie: \r\n"
				+ "StanzeMagiche: \r\n"
				+ "Inizio: atrio\r\n"
				+ "Vincente: atrio\r\n"
				+ "Attrezzi: spada 1 atrio\r\n"
				+ "Uscite: \r\n"
				+ "Personaggi: ";
		Labirinto monolocale = new Labirinto(labString);
		int size = monolocale.getStanzaIniziale().getAttrezzi().size();
		Set<Attrezzo> test = new HashSet<Attrezzo>();	test.add(new Attrezzo("spada",1));
		
		assertTrue(size==1);
		assertEquals(test,monolocale.getStanzaIniziale().getAttrezzi());
	}
	
	@Test//----------------------------------------------------------------------------------------//
	public void testBilocale() throws FileNotFoundException, FormatoFileNonValidoException {
		String labString = "Stanze: atrio, uscita\r\n"
				+ "StanzeBloccate: \r\n"
				+ "StanzeBuie: \r\n"
				+ "StanzeMagiche: \r\n"
				+ "Inizio: atrio\r\n"
				+ "Vincente: uscita\r\n"
				+ "Attrezzi: spada 1 atrio, spadina 1 uscita\r\n"
				+ "Uscite: atrio nord uscita\r\n"
				+ "Personaggi: ";
		Labirinto bilocale = new Labirinto(labString);
		Set<String> test1 = new HashSet<String>();		test1.add("nord");
		Set<String> test2 = new HashSet<String>();		test2.add("sud");
		
		assertEquals(bilocale.getStanzaVincente(),bilocale.getStanzaIniziale().getStanzaAdiacente("nord"));
		assertEquals(test1,bilocale.getStanzaIniziale().getDirezioni());
		assertEquals(test2,bilocale.getStanzaVincente().getDirezioni());
	}
	
	@Test//----------------------------------------------------------------------------------------//
	public void testTrilocale() throws FileNotFoundException, FormatoFileNonValidoException{
		String labString = "Stanze: atrio, biblioteca, uscita\r\n"
				+ "StanzeBloccate: \r\n"
				+ "StanzeBuie: \r\n"
				+ "StanzeMagiche: \r\n"
				+ "Inizio: atrio\r\n"
				+ "Vincente: uscita\r\n"
				+ "Attrezzi: sedia 1 atrio, libroAntico 5 biblioteca\r\n"
				+ "Uscite: atrio sud biblioteca, biblioteca est uscita\r\n"
				+ "Personaggi: ";
		Labirinto trilocale = new Labirinto(labString);
		
		assertEquals(nomeStanzaIniziale, trilocale.getStanzaIniziale().getNome());
		assertEquals(nomeStanzaVincente, trilocale.getStanzaVincente().getNome());
		assertEquals("biblioteca",trilocale.getStanzaIniziale().getStanzaAdiacente("sud").getNome());
	}
	
	@Test//----------------------------------------------------------------------------------------//
	public void testTrilocaleConStanzaDuplicata() throws FileNotFoundException, FormatoFileNonValidoException {
		String labString = "Stanze: atrio, stanzaGenerica, stanzaGenerica\r\n"
				+ "StanzeBloccate: \r\n"
				+ "StanzeBuie: \r\n"
				+ "StanzeMagiche: \r\n"
				+ "Inizio: atrio\r\n"
				+ "Vincente: stanzaGenerica\r\n"
				+ "Attrezzi: \r\n"
				+ "Uscite: atrio nord stanzaGenerica\n"
				+ "Personaggi: ";
		Labirinto trilocale = new Labirinto(labString);
		
		assertTrue(trilocale.getMappaStanze().size()<=2);
	}
	
	@Test//----------------------------------------------------------------------------------------//
	public void testPiuDiQuattroAdiacenti() throws FileNotFoundException, FormatoFileNonValidoException {
		String labString = "Stanze: atrio, stanza1, stanza2, stanza3, stanza4, stanza5\r\n"
				+ "StanzeBloccate: \r\n"
				+ "StanzeBuie: \r\n"
				+ "StanzeMagiche: \r\n"
				+ "Inizio: atrio\r\n"
				+ "Vincente: stanza5\r\n"
				+ "Attrezzi: \r\n"
				+ "Uscite: atrio nord stanza1, atrio ovest stanza2, atrio sud stanza3, atrio est stanza4, atrio nord-est stanza5\n"
				+ "Personaggi: ";
		Labirinto maze = new Labirinto(labString);
				Stanza test = new Stanza("stanza 5");
		assertNull(maze.getStanzaIniziale().getStanzaAdiacente("nord-est"));
		assertTrue(maze.getStanzaIniziale().getMapStanzeAdiacenti().size()<=4);
		assertTrue(!maze.getStanzaIniziale().getMapStanzeAdiacenti().containsValue(test));
		Map<String,Stanza> mappa = new HashMap<>();
		mappa.put("nord", new Stanza("stanza 1"));
		mappa.put("ovest", new Stanza("stanza 2"));
		mappa.put("sud", new Stanza("stanza 3"));
		mappa.put("est", new Stanza("stanza 4"));
		assertEquals(mappa.keySet(),maze.getStanzaIniziale().getMapStanzeAdiacenti().keySet());
	}
	
	@Test//----------------------------------------------------------------------------------------//
	public void testAggiuntaAttrezziAStanze_Iniziale() throws FileNotFoundException, FormatoFileNonValidoException {
		String labString = "Stanze: atrio\r\n"
				+ "StanzeBloccate: \r\n"
				+ "StanzeBuie: \r\n"
				+ "StanzeMagiche: \r\n"
				+ "Inizio: atrio\r\n"
				+ "Vincente: atrio\r\n"
				+ "Attrezzi: attrezzo 1 atrio \r\n"
				+ "Uscite: \n"
				+ "Personaggi: ";
		Labirinto maze = new Labirinto(labString);
		
		String nomeAttrezzo = "attrezzo";
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo,1);
		assertEquals(attrezzo,maze.getStanzaIniziale().getAttrezzo(nomeAttrezzo));
	}
}













