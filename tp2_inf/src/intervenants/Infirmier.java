package intervenants;

import java.io.Serializable;

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
	private boolean estDisponible;

	/**
	 * Créé un Infirmier avec des valeurs d'Identification et de 
	 * disponibilité par défaut.
	 */
	public Infirmier(){
		identifiant = new Identification();
		estDisponible = true;
	}

	/**
	 * Créé un Infirmier à partir d'un autre infirmier
	 * @param infirmier Infirmier source
	 */
	public Infirmier(Infirmier infirmier) {
		identifiant = infirmier.getIdentification();
		estDisponible = infirmier.getDisponibilite();
	}

	/**
	 * Créé un Infirmier selon une Identification et une disponibilité donnée.
	 * @param identifiant Identification de l'infirmier
	 * @param disponibilite Disponibilité de l'infirmier
	 */
	public Infirmier(Identification identifiant, boolean disponibilite) {
		this.identifiant = identifiant;
		this.estDisponible = disponibilite;
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
	 *  Accesseur de la disponibilité d'un infirmier. 
	 * @return
	 */
	public boolean getDisponibilite() {

		return estDisponible;
	}

	/**
	 * Mutateur de la disponibilité d'un infirmier.
	 * @param estDisponible
	 */

	public void setDisponibilite(boolean estDisponible) {

		this.estDisponible = estDisponible;

	}

	/**
	 *  Méthode qui renvoie une String qui affiche la disponibilité d'un 
	 *  infirmier
	 */
	@Override
	public String toString() {
		String disponibilité = estDisponible ? "disponible" : "indisponible";
		return identifiant + ", Disponibilité : " + disponibilité;
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

		if (estDisponible != other.estDisponible)
			return false;

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
