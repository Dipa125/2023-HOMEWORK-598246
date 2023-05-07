package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.comparatori.ComparatoreAttrezzoPerNome;

import java.util.*;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;

/*-----------------------------COSTRUTTORE-----------------------------*/	
	
//--Costruttore di una Borsa senza peso massimo
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

//--Costruttore di una Borsa con peso massimo
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>();
	}

/*-------------------------------GET-------------------------------*/
	
//--Restituisce il peso massimo della borsa
	public int getPesoMax() {return pesoMax;}

//--Restituisce una lista con tutti gli attrezzi della borsa
	public List<Attrezzo> getAttrezzi() {return attrezzi;}

//--Restituisce il peso di tutti gli attrezzi nella borsa
	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext())
			peso += iteratore.next().getPeso();
						
		return peso;
	}

/*-------------------------------ATTREZZO-------------------------------*/
	
//--Aggiunge un attrezzo alla borsa se non è piena
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
			
		return this.attrezzi.add(attrezzo);
	}

//--Aggiunge un attrezzo alla borsa se non è piena
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			Attrezzo a = iteratore.next();
			if(nomeAttrezzo.equals(a.getNome()))
				return a;
		}
		return null;
	}

//--Restituisce se un attrezzo è presente nella borsa
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!= null;
	}

//--Rimuove e ritorna l'attrezzo con nome nel parametro
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = this.getAttrezzo(nomeAttrezzo);
		if(this.attrezzi.remove(a))
			return a;
		
		return null;
	}

	
	
/*-----------------------------ORDINAMENTO-----------------------------*/
	
//--Restituisce la lista degli attrezzi ordinati per peso e poi per nome	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> lista = this.attrezzi;
		Collections.sort(lista);
		return lista;
	}

//--Restituisce l'insieme degli attrezzi nella borsa ordinati per nome
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		ComparatoreAttrezzoPerNome comparatoreNome = new ComparatoreAttrezzoPerNome();
		SortedSet<Attrezzo> insieme= new TreeSet<Attrezzo>(comparatoreNome);
		insieme.addAll(this.attrezzi);
		return insieme;
	}

//--Restituisce una mappa: CHIAVE(peso) --> VALORE(attrezzi con stesso peso)
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> mappa = new TreeMap<Integer,Set<Attrezzo>>();
		for(Attrezzo a : this.attrezzi) {
			if(!mappa.containsKey(a.getPeso())) {
				Set<Attrezzo> insieme = new HashSet<Attrezzo>();
				insieme.add(a);
				mappa.put(a.getPeso(),insieme);
			}
			else
				mappa.get(a.getPeso()).add(a);
		}	
		return mappa;
	}
	
/*--------------------------OVERRIDE--------------------------*/

//--Rappresentazione di stringa di Borsa
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.attrezzi.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
			while(iteratore.hasNext())
				s.append(iteratore.next().toString()+" ");
		}
		else
			s.append("Borsa vuota");
		
		return s.toString();
	}
}