package model;

public class Restaurant implements IEtablissement<FormulaireRestaurant>{

	private static final int NB_TABLES = 10;
	private CentraleReservation<EntiteReservable<FormulaireRestaurant>, FormulaireRestaurant> centrale = 
			new CentraleReservation<>(new Table[NB_TABLES]);
	
	public void ajouterTable(int nbChaises) {
		centrale.ajouterEntite(new Table(nbChaises));
	}
	
	@Override
	public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
		return centrale.donnerPossibilites(formulaire);
	}

	@Override
	public Reservation reserver(int numEntite, FormulaireRestaurant formulaire) {
		return centrale.reserver(numEntite, formulaire);
	}
	
	private static class Table extends EntiteReservable<FormulaireRestaurant> {
		private CalendrierAnnuel calendrierDeuxiemeService = new CalendrierAnnuel();
		private int nbChaises;
			
		public Table(int nbChaises) {
			this.nbChaises = nbChaises;
		}
		
		@Override
		public boolean compatible(FormulaireRestaurant formulaire) {
			if (formulaire.getNombrePersonnes() > nbChaises || formulaire.getNombrePersonnes() < nbChaises - 1) {
				return false;
			}
			CalendrierAnnuel calendrierService = (formulaire.getNumService() == 1) ? 
												calendrier : calendrierDeuxiemeService;
			return calendrierService.estLibre(formulaire.getJour(), formulaire.getMois());
		}

		@Override
		public Reservation reserver(FormulaireRestaurant formulaire) {
			CalendrierAnnuel calendrierService = (formulaire.getNumService() == 1) ? 
					calendrier : calendrierDeuxiemeService;
			if (calendrierService.reserver(formulaire.getJour(), formulaire.getMois())) {
				return new ReservationRestaurant(formulaire.getJour(), formulaire.getMois(), 
						formulaire.getNumService(), formulaire.getIdentificationEntite());
			}

			return null;
		}
	}
}
