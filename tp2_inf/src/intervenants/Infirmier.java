package intervenants;

import java.io.Serializable;

/**
 * 
 * @author Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 *
 */

@SuppressWarnings("serial")
public class Infirmier implements Serializable {
	
	private Identification identifiant = new Identification();
	private boolean estDisponible;

	/**
	 * Cr�� un Infirmier avec des valeurs d'Identification et de disponibilit� par d�faut.
	 */
	public Infirmier(){
		identifiant = new Identification();
		estDisponible = true;
	}

	/**
	 * Cr�� un Infirmier � partir d'un autre infirmier
	 * @param infirmier Infirmier source
	 */
	public Infirmier(Infirmier infirmier) {
		identifiant = infirmier.getIdentification();
		estDisponible = infirmier.getDisponibilite();
	}

	/**
	 * Cr�� un Infirmier selon une Identification et une disponibilit� donn�e.
	 * @param identifiant Identification de l'infirmier
	 * @param disponibilite Disponibilit� de l'infirmier
	 */
	public Infirmier(Identification identifiant, boolean disponibilite) {
		this.identifiant = identifiant;
		this.estDisponible = disponibilite;
	}


	/*Encapsulation des attributs  priv�s
	 *  de la classe identification  et l'attribut 
	 *  disponibilit� de l'infirmier
	 *  */

	public Identification getIdentification() {
		return identifiant;

	}

	public void setIdentification(Identification identifiant) {

		this.identifiant = identifiant;

	}

	public boolean getDisponibilite() {

		return estDisponible;
	}

	public void setDisponibilite(boolean estDisponible) {

		this.estDisponible = estDisponible;

	}

	@Override
	public String toString() {
		String disponibilit� = estDisponible ? "disponible" : "indisponible";
		return identifiant + ", Disponibilit� : " + disponibilit�;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

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

	public Infirmier clone() {
		return new Infirmier(this);
	}
}
