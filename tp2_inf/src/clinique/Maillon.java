package clinique;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Maillon implements Serializable {
	
	/**
	 * 
	 * @author Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
	 * 
	 *  Derni�re date de modification: 11-12-2017
	 * 
	 * La classe maillon cr�e les maillons de la liste de PlageHoraire.
	 * 
	 */

	private Maillon prochain; 
	private PlageHoraire  plageHoraire;

	/*
	 * Constructeur du maillon 
	 * */

	public Maillon(PlageHoraire plageHoraire) {

		this.plageHoraire = plageHoraire;

	}

	/* Getters et Setters pour le prochain maillon de la file  simple chain�e 
	 * dynamiquement. Les attributs sont le prochain maillon (prochain) et la 
	 * valeur du maillon courant (valeur)
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
