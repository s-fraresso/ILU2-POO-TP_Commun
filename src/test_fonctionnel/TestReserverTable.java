package test_fonctionnel;

import control.ControlConnecterClient;
import control.ControlCreerClient;
import control.ControlReserverTable;
import control.ControlVisualiserCarnetClientele;
import frontiere.BoundaryConnecterClient;
import frontiere.BoundaryCreerClient;
import frontiere.BoundaryReserverTable;
import model.CarnetClientele;
import model.Client;
import model.Restaurant;

public class TestReserverTable {
	
	public static void main(String[] args) {
		System.out.println("---------- CREER CLIENT ----------");
		
		CarnetClientele carnetClientele = new CarnetClientele();
		ControlCreerClient controlCreerClient = new ControlCreerClient(carnetClientele);
		BoundaryCreerClient boundaryCreerClient = new BoundaryCreerClient(controlCreerClient);
		boundaryCreerClient.creerClient();

		System.out.println("\n---------- CONNECTER CLIENT ----------");
		
		ControlConnecterClient controlConnecterClient = new ControlConnecterClient(carnetClientele);
		BoundaryConnecterClient boundaryConnecterClient = new BoundaryConnecterClient(controlConnecterClient);
		int numClient = boundaryConnecterClient.connecterClient();

		System.out.println("\n---------- RESERVER TABLE ----------");
		
		Restaurant restaurant = new Restaurant();
		restaurant.ajouterTable(2);
		restaurant.ajouterTable(2);
		restaurant.ajouterTable(3);
		restaurant.ajouterTable(4);
		restaurant.ajouterTable(4);
		restaurant.ajouterTable(6);
		restaurant.ajouterTable(8);
		
		ControlReserverTable controlReserverTable = new ControlReserverTable(restaurant, carnetClientele);
		BoundaryReserverTable boundaryReserverTable = new BoundaryReserverTable(controlReserverTable);
		boundaryReserverTable.reserverTable(numClient);
		
		System.out.println("\n\n---------- CONTROLE DES DONNEES ----------");
		
		Client client = carnetClientele.getClient(numClient);
		System.out.println("Client :\n" + client);
		System.out.println("Reservation :\n" + client.getReservationRestaurant(0));
	}
}
