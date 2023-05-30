package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;

class CaricatoreLabirintoTest {

	@Test
	void testStanza() throws FileNotFoundException, FormatoFileNonValidoException {
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
	
		assertEquals("atrio",monolocale.getStanzaIniziale().getNome());
		assertEquals("atrio",monolocale.getStanzaVincente().getNome());
	}
	public void tesAttrezzo() throws FileNotFoundException, FormatoFileNonValidoException {
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
	
		assertEquals("atrio",monolocale.getStanzaIniziale().getNome());
		assertEquals("atrio",monolocale.getStanzaVincente().getNome());
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
	public void testUsscite() throws FileNotFoundException, FormatoFileNonValidoException {
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
	public void testPersonaggi()throws FileNotFoundException, FormatoFileNonValidoException {
		String labString = "Stanze: atrio\r\n"
				+ "StanzeBloccate: \r\n"
				+ "StanzeBuie: \r\n"
				+ "StanzeMagiche: \r\n"
				+ "Inizio: atrio\r\n"
				+ "Vincente: atrio\r\n"
				+ "Attrezzi: \r\n"
				+ "Uscite: \n"
				+ "Personaggi: cane atrio";
		Labirinto monolocale = new Labirinto(labString);
		assertEquals(Cane.class, monolocale.getStanzaIniziale().getPersonaggio().getClass());
	}
}
