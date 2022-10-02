package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		bak--;
		resultat = liste[bak];
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		bak--;
		if (bak >= 0) {
			System.arraycopy(liste, 1, liste, 0, bak);
		}
		resultat = liste[bak];
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		
		T resultat = null;
		resultat = liste[bak - 1];

		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
		if (liste.length == bak) {
			utvid();
		}
		if (erTom()) {
			liste[bak] = element;
		}
		int finnEl = 0;
		while (finnEl < bak && liste[finnEl].compareTo(element) < 0) {
			finnEl++;
		}
		if (bak - finnEl >= 0) {
			System.arraycopy(liste, finnEl, liste, finnEl + 1, bak - finnEl);
		}
		liste[finnEl] = element;
		bak++;
		
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		if (inneholder(element)) {
			for (int i = 0; i < bak; i++) {
				liste[i] = liste[i + 1];
			}
			bak--;
		}
		return element;

	}

	private int finn(T el) {
		int resultat = IKKE_FUNNET;
		for (int i = 0; i < bak; i++) {
			if (liste[i] == null) {
				return resultat;
			}
			if (liste[i].equals(el)) {
				return i;
			}
		}
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
