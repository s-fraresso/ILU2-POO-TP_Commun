package model;

public class ReservationHotel extends Reservation {
	
	private int nbSimple;
	private int nbDouble;
	private int numChambre;
	
	public ReservationHotel(int jour, int mois, int nbSimple, int nbDouble, int numChambre) {
		super(jour, mois);
		this.nbSimple = nbSimple;
		this.nbDouble = nbDouble;
		this.numChambre = numChambre;
	}
	
	@Override
	public String toString() {
		return "Le " + jour + "/" + mois + "\nChambre " + numChambre + ", " + nbSimple + " lits simples et " + nbDouble + " lits doubles."; 
	}
}
