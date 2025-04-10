package model;

public abstract class Reservation {
	protected int jour;
	protected int mois;
	
	protected Reservation(int jour, int mois) {
		this.jour = jour;
		this.mois = mois;
	}
	
	@Override
	public String toString() {
		return "Le " + jour + "/" + mois + ".";
	}
}
