package model;

public class CentraleReservation <E extends EntiteReservable<F>, F extends Formulaire> {

	private E[] entites;
	private int nbEntite = 0;
	
	public CentraleReservation(E[] entites) {
		this.entites = entites;
	}
	
	public int ajouterEntite(E entite) {
		entites[nbEntite++] = entite;
		entite.setNumero(nbEntite);
		return entite.getNumero();
	}
	
	public int[] donnerPossibilites(F formulaire) {
		int[] possibilites = new int[nbEntite];
		
		for (int i = 0; i < nbEntite; i++) {
			if (entites[i].compatible(formulaire)) {
				possibilites[i] = entites[i].getNumero();
			}
			else {
				possibilites[i] = 0;
			}
		}
		
		return possibilites;
	}
	
	public Reservation reserver(int numeroEntite, F formulaire) {
		E entite = null;
		for (int i = 0; i < nbEntite; i++) {
			if (entites[i].getNumero() == numeroEntite) {
				entite = entites[i];
				break;
			}
		}
		
		if (entite == null) {
			throw new IllegalArgumentException("aucune entite n a ce numero");
		}
		
		formulaire.setIdentificationEntite(numeroEntite);
		return entite.reserver(formulaire);
	}
}
