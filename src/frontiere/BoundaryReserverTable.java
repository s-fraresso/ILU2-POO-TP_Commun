package frontiere;

import control.ControlReserverTable;

public class BoundaryReserverTable {

	private ControlReserverTable controlReserverTable;
	private final static int[] nbJoursMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	
	public BoundaryReserverTable(ControlReserverTable controlReserverTable) {
		this.controlReserverTable = controlReserverTable;
	}
	
	
	public void reserverTable(int numClient) {
		System.out.println("Quand souhaitez-vous reserver ?");
		int mois;
		do {
			mois = Clavier.entrerEntier("Pour quel mois ?");
		} while (mois > 12);
		
		int jour;
		do {
			jour = Clavier.entrerEntier("Pour quel jour ?");
		} while (jour > nbJoursMois[mois]);
		
		int nombrePersonnes = Clavier.entrerEntier("Pour combien de personnes ?");
		
		int numService;
		do {
			numService = Clavier.entrerEntier("Pour quel service ?");
		} while (numService > 2);
		
		int[] possibilites = controlReserverTable.trouverPossibilite(jour, mois, nombrePersonnes, numService);
		
		if (possibilites.length == 1) {
			System.out.println("Desole, aucune table correspondant a votre recherche n est disponible.");
			return;
		}
		
		StringBuilder tableDispo = new StringBuilder();
		for (int i = 1; i < possibilites.length; i++) {
			if (possibilites[i] != 0) {
				tableDispo.append("numero de table : " + possibilites[i] + "\n");
			}
		}
		System.out.println(tableDispo.toString());
		
		int numTable;
		do {
			numTable = Clavier.entrerEntier("Choisissez votre table");
		} while (!estTableDansPossibilites(numTable, possibilites));
		
		controlReserverTable.reserver(numClient, numTable, possibilites[0]);
	}
	
	
	private boolean estTableDansPossibilites(int numTable, int[] possibilites) {
		boolean estDansPossibilites = false;
		
		for (int i = 1; i < possibilites.length; i++) {
			if (possibilites[i] == numTable) {
				estDansPossibilites = true;
				break;
			}
		}
		
		return estDansPossibilites;
	}
}
