package model;

public interface IEtablissement <F extends Formulaire> {
	
	int[] donnerPossibilites(F formulaire);
}
