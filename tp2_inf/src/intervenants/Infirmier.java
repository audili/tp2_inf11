package intervenants;

import java.io.Serializable;

import clinique.PlageHoraire;
import clinique.RendezVous;

/**
 * 
 * @author Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 * 
 *  Dernière date de modification: 11-05-2017
 *
 */

@SuppressWarnings("serial")
public class Infirmier implements Serializable {

	private Identification identifiant = new Identification();

	/**
	 * Créé un Infirmier avec des valeurs d'Identification et de 
	 * disponibilité par défaut.
	 */
	public Infirmier(){
		identifiant = new Identification();
	}

	/**
	 * Créé un Infirmier à partir d'un autre infirmier
	 * @param infirmier Infirmier source
	 */
	public Infirmier(Infirmier infirmier) {
		identifiant = infirmier.getIdentification();
	}

	/**
	 * Créé un Infirmier selon une Identification et une disponibilité donnée.
	 * @param identifiant Identification de l'infirmier
	 * @param disponibilite Disponibilité de l'infirmier
	 */
	public Infirmier(Identification identifiant, boolean disponibilite) {
		this.identifiant = identifiant;
	}


	/*Encapsulation des attributs  privés
	   de la classe identification  et l'attribut 
	   disponibilité de l'infirmier
	 */

	public Identification getIdentification() {
		return identifiant;

	}

	/**
	 * Mutateur de l'attribut identification d'un infirmer.
	 * @param identifiant
	 */
	public void setIdentification(Identification identifiant) {

		this.identifiant = identifiant;

	}

	/**
	 * Obtient la disponibilité d'un infirmier pour une PlageHoraire
	 * @param plageHoraire PlageHoraire à vérifier
	 * @return Vrai si l'infirmier n'a pas de rendez-vous pendant cette 
	 * PlageHoraire, faux sinon.
	 */
	public boolean getDisponibilite(PlageHoraire plageHoraire) {

		for (RendezVous rendezVous : plageHoraire.getRendezVous()) {
			if(rendezVous.getInfirmier().equals(this)) {
				return false;
			}
		}
		return true;
	}

	/**
	 *  Méthode qui renvoie une String qui affiche la disponibilité d'un 
	 *  infirmier
	 */
	@Override
	public String toString() {
		return "Infirmier " + identifiant;
	}

	/**
	 *  Méthode qui vérifie si deux objets infirmiers sont similaires (donc sont
	 *  le même infirmier). En vérifiant l'identifiant et la disponibilité.
	 */
	@Override
	public boolean equals(Object obj) {

		/**
		 *  Si l'infirmier actuellement crée et l'infirmier passé en paramètre
		 *	sont identiques, alors on retourne vrai.
		 *
		 */

		if (this == obj)
			return true;

		// Si l'infirmier ne contient aucun attributs, alors on retourne faux.
		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Infirmier other = (Infirmier) obj;

		if (identifiant == null) {
			if (other.identifiant != null)
				return false;

		} else if (!identifiant.equals(other.identifiant))
			return false;
		return true;
	}

	// Méthode qui clone l'infirmier actuel.
	public Infirmier clone() {
		return new Infirmier(this);
	}
}
