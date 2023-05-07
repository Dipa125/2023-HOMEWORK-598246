package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	
	private Borsa borsa;
	private Attrezzo osso;
	private Attrezzo penna;
	private Attrezzo sasso;
	private Attrezzo astuccio;
	
	
	
	@BeforeEach
	void SetUp() {
		this.borsa = new Borsa();
		this.osso = new Attrezzo("osso", 1);
		this.penna = new Attrezzo("penna", 1);
		this.astuccio = new Attrezzo("astuccio",5);
		this.sasso = new Attrezzo("sasso", 30);
		this.borsa.addAttrezzo(osso);
	}
	
	@Test
	void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(penna));
		assertFalse(this.borsa.addAttrezzo(sasso));
	}
	
	@Test
	void testRemoveAttrezzo() {
		assertEquals(this.osso, this.borsa.removeAttrezzo("osso"));
	}
	
	@Test
	void testHasAttrezzo() {
		assertTrue(this.borsa.hasAttrezzo("osso"));
		assertFalse(this.borsa.hasAttrezzo("penna"));
	}
	
	@Test
	void testgetAttrezzo() {
		assertEquals(this.osso, this.borsa.getAttrezzo("osso"));
	}
	
	@Test
	void testGetContenutoOrdinatoPerPeso() {
		this.borsa.addAttrezzo(astuccio);
		this.borsa.addAttrezzo(penna);
		List<Attrezzo> test = new ArrayList<Attrezzo>();
		test.add(osso);test.add(penna);test.add(astuccio);
		assertEquals(test,this.borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	void testGetContenutoOrdinatoPerNome() {
		this.borsa.addAttrezzo(astuccio);
		this.borsa.addAttrezzo(penna);
		Set<Attrezzo> test = new HashSet<Attrezzo>();
		test.add(astuccio);test.add(osso);test.add(penna);
		assertEquals(test,this.borsa.getContenutoOrdinatoPerNome());
	}
	
	@Test
	void  testgetContenutoRaggruppatoPerPeso() {
		this.borsa.addAttrezzo(astuccio);
		this.borsa.addAttrezzo(penna);
		Map<Integer,Set<Attrezzo>> test = new TreeMap<Integer,Set<Attrezzo>>();
		Set<Attrezzo> insieme1 = new HashSet<Attrezzo>();
		insieme1.add(osso);insieme1.add(penna);
		Set<Attrezzo> insieme2 = new HashSet<Attrezzo>();
		insieme2.add(astuccio);
		test.put(osso.getPeso(),insieme1);test.put(astuccio.getPeso(), insieme2);
	}

}
