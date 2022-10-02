package no.hvl.dat102.medlemstabell;

import no.hvl.dat102.mengde.adt.*;
import no.hvl.dat102.mengde.tabell.*;

public class Medlem {
	
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;
	
	public Medlem(String navn) {
		this.navn = navn;
		hobbyer = new TabellMengde<>();
		statusIndeks = -1;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}
	
	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}
	
	public int getStatusIndeks() {
		return statusIndeks;
	}
	
	public void setStatusIndeks(int stautsIndeks) {
		this.statusIndeks = stautsIndeks;
	}
	
	public boolean passerTil (Medlem medlem2) {
		return hobbyer.equals(medlem2.getHobbyer());
	}
	
	

}
