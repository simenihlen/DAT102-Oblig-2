package no.hvl.dat102.medlemstabell;

import no.hvl.dat102.medlemstabell.*;

public class Datakontakt {
	
	private Medlem[] medlem;
	private int antallMedlemmer;
	
	public Datakontakt(int storrelse) {
		antallMedlemmer = 0;
		medlem = new Medlem[storrelse];
	}
	
	public Medlem[] getMedlem() {
		return medlem;
	}

	public void setMedlem(Medlem[] medlem) {
		this.medlem = medlem;
	}

	public int getAntallMedlemmer() {
		return antallMedlemmer;
	}

	public void setAntallMedlemmer(int antallMedlemmer) {
		this.antallMedlemmer = antallMedlemmer;
	}

	public void leggTilMedlem(Medlem person) {
		if (medlem.length == antallMedlemmer) {
			int lengde = medlem.length;
			Medlem[] nyMedlem = new Medlem[lengde * 2];
			System.arraycopy(medlem, 0, nyMedlem, 0, lengde);
			medlem = nyMedlem;
		}
		medlem[antallMedlemmer] = person;
		antallMedlemmer++;
	}
	
	public int finnMedlemIndeks(String medlemsnavn) {
		for (int i = 0; i < antallMedlemmer; i++) {
			if (medlem[i].getNavn().equals(medlemsnavn)) {
				return i;
			}
		}
		return -1;
	}
	
	public void finnPartnerFor(String medlemsnavn) {
		int medIndeks = finnMedlemIndeks(medlemsnavn);
		Medlem medlem = this.medlem[medIndeks];
		for (int i = 0; i < antallMedlemmer; i++) {
			if (!(this.medlem[i].equals(medlem))) {
				if (this.medlem[i].passerTil(medlem) && this.medlem[i].getStatusIndeks() == -1) {
					this.medlem[i].setStatusIndeks(medIndeks);
					medlem.setStatusIndeks(i);
					return;
				}
			}
		}
	}
	
	public void tilbakeStillIndeks(String medlemsnavn) {
		Medlem medlem = this.medlem[finnMedlemIndeks(medlemsnavn)];
		if(medlem.getStatusIndeks() == -1) {
			return;
		}
		Medlem partner = this.medlem[medlem.getStatusIndeks()];
		partner.setStatusIndeks(-1);
		medlem.setStatusIndeks(-1);
	}
}
