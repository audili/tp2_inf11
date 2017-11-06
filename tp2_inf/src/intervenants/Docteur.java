package intervenants;

import java.io.Serializable;

@SuppressWarnings("serial")

/**
 * Cette classe crée un docteur dans la clinique. Pour créer un docteur, il faut
 * son identifiant et son département.
 * 
 * @author Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 * 
 * Dernière date de modification: 11-05-2017
 *
 */
public class Docteur implements Serializable {
	
	private Identification identification;
	private enuDepartements departement;

	public enum enuDepartements {
		CHIRURGIE,URGENCE,UROLOGIE
	}
	
	public Docteur() {
		identification = new Identification();
	}

	/**
	 * Créé un Docteur selon une identification donnéee et un département 
	 * où il travaille.
	 * @param identification Identifciation du Docteur.
	 * @param departement Département où travaille le Docteur.
	 */
	public Docteur(Identification identification, enuDepartements departement) {
		this.identification = identification;
		this.departement = departement;
	}
	
	//Accesseur de l'identification du Docteur.
	public Identification getIdentification() {
		return identification;
	}
	
	//Mutateur de l'identification du Docteur.
	public void setIdentification(Identification identification) {
		this.identification = identification;
	}
	
	//Accesseur du département du Docteur.
	public enuDepartements getDepartement() {
		return departement;
	}
	
	//Mutateur du département du Docteur.
	public void setDepartement(enuDepartements departement) {
		this.departement = departement;
	}
	
	/**
	 * Méthode qui sert à l'affichage de l'objet Docteur.
	 */
	@Override
	public String toString() {
		return identification + ", Département: " + departement;
	}
	
	/**
	 * Méthode boolénne qui nous retour ''false'' si deux objets ne sont pas
	 * identiques.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Docteur other = (Docteur) obj;
		if (departement != other.departement)
			return false;
		if (identification == null) {
			if (other.identification != null)
				return false;
		} else if (!identification.equals(other.identification))
			return false;
		return true;
	}
	
	//Clone un docteur avec ses attributs.
	public Docteur clone() {
		return new Docteur(identification, departement);
	}

}
