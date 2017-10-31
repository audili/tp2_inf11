package intervenants;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Infirmier implements Serializable {
	
	private Identification identifiant = new Identification();
	private boolean estDisponible;

	/**
	 * Créé un Infirmier avec des valeurs d'Identification et de disponibilit par défaut.
	 */
	public Infirmier(){
		identifiant.setNom("Defaut");
		identifiant.setPrenom("Defaut");
		estDisponible = true;
	}

	/**
	 * Créé un Infirmier à partir d'un autre infirmier
	 * @param infirmier Infirmier source
	 */
	public Infirmier(Infirmier infirmier) {
		identifiant = infirmier.getIdentifiant();
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
	 *  de la classe identification  et l'attribut 
	 *  disponibilité de l'infirmier
	 *  */

	public Identification getIdentifiant() {
		return identifiant;

	}

	public void setIdentifiant(Identification identifiant) {

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
		return "Infirmier [identifiant=" + identifiant.getNom() + identifiant.getPrenom()+  ", disponibilite="
				+ estDisponible + "]";
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
