package intervenants;

import java.io.Serializable;

import clinique.PlageHoraire;
import clinique.RendezVous;

/**
 * 
 * @author Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 * 
 *  Derni�re date de modification: 11-05-2017
 *
 */

@SuppressWarnings("serial")
public class Infirmier implements Serializable {

	private Identification identifiant = new Identification();

	/**
	 * Cr�� un Infirmier avec des valeurs d'Identification et de 
	 * disponibilit� par d�faut.
	 */
	public Infirmier(){
		identifiant = new Identification();
	}

	/**
	 * Cr�� un Infirmier � partir d'un autre infirmier
	 * @param infirmier Infirmier source
	 */
	public Infirmier(Infirmier infirmier) {
		identifiant = infirmier.getIdentification();
	}

	/**
	 * Cr�� un Infirmier selon une Identification et une disponibilit� donn�e.
	 * @param identifiant Identification de l'infirmier
	 * @param disponibilite Disponibilit� de l'infirmier
	 */
	public Infirmier(Identification identifiant, boolean disponibilite) {
		this.identifiant = identifiant;
	}


	/*Encapsulation des attributs  priv�s
	   de la classe identification  et l'attribut 
	   disponibilit� de l'infirmier
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
	 * Obtient la disponibilit� d'un infirmier pour une PlageHoraire
	 * @param plageHoraire PlageHoraire � v�rifier
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
	 *  M�thode qui renvoie une String qui affiche la disponibilit� d'un 
	 *  infirmier
	 */
	@Override
	public String toString() {
		return "Infirmier " + identifiant;
	}

	/**
	 *  M�thode qui v�rifie si deux objets infirmiers sont similaires (donc sont
	 *  le m�me infirmier). En v�rifiant l'identifiant et la disponibilit�.
	 */
	@Override
	public boolean equals(Object obj) {

		/**
		 *  Si l'infirmier actuellement cr�e et l'infirmier pass� en param�tre
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

	// M�thode qui clone l'infirmier actuel.
	public Infirmier clone() {
		return new Infirmier(this);
	}
}
