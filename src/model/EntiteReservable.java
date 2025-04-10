package model;

public abstract class EntiteReservable <T extends Formulaire> {

	protected CalendrierAnnuel calendrier = new CalendrierAnnuel();
	protected int identifiant;

	
	public int getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public boolean estLibre(T formulaire) {
		return calendrier.estLibre(formulaire.getJour(), formulaire.getMois());
	}
	
	public abstract boolean compatible(T formulaire);
	
	public abstract void reserver(T formulaire);
}
