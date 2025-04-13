package model;

public abstract class EntiteReservable <F extends Formulaire> {

	protected CalendrierAnnuel calendrier = new CalendrierAnnuel();
	protected int numero;

	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public boolean estLibre(F formulaire) {
		return calendrier.estLibre(formulaire.getJour(), formulaire.getMois());
	}
	
	public abstract boolean compatible(F formulaire);
	
	public abstract Reservation reserver(F formulaire);
}
