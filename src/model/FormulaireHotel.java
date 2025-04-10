package model;

public class FormulaireHotel extends Formulaire {
	
	private int nombreLitSimple;
	private int nombreLitDouble;
	
	public FormulaireHotel(int jour, int mois, int nombreLitSimple, int nombreLitDouble) {
		super(jour, mois);
		this.nombreLitSimple = nombreLitSimple;
		this.nombreLitDouble = nombreLitDouble;
	}
	
	public int getNombreLitDouble() {
		return nombreLitDouble;
	}
	
	public int getNombreLitSimple() {
		return nombreLitSimple;
	}
}
