package clinique;


public class Maillon {

	private Maillon prochain; 
	private PlageHoraire  plageHoraire;

	/*
	 * Constructeur du maillon 
	 * */

	public Maillon(PlageHoraire plageHoraire) {

		this.plageHoraire=plageHoraire;

	}

	/*getters et setters pour le prochain maillon de la file  simple chainée dynamiquement 
	 * 
	 * les attributs sont le prochain maillon (prochain) et la valeur du maillon courant (valeur)
	 * 
	 * */
	public Maillon getProchain() {
		return prochain;
	}

	public void setProchain(Maillon prochain) {
		this.prochain = prochain;
	}

	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}

	public void setValeur(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	} 



}
