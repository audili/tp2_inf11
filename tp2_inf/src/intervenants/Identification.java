/**
 * 
 */
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
public class Identification implements Serializable {

	private String prenom;		// Prénom de l'intervenant
	private String nom;			// Nom de famille de l'intervenant
	
	/**
	 * Créé une Identification avec un prénom et un nom par défaut.
	 */
	public Identification() {
		prenom = "DefautPrenom";
		nom = "DefautNom";
	}
	
	/**
	 * Créé une Identification avec un prénom et un nom donné.
	 * @param nom Nom de famille de l'intervenant
	 * @param prenom Prénom de l'intervenant
	 */
	public Identification(String nom, String prenom) {
		this.prenom = prenom;
		this.nom = nom;
	}
	
	/**
	 * Créé une nouvelle Identification similaire à l'identification passée en paramètre
	 * @param identification Idenfication qu'on veut copier
	 */
	public Identification(Identification identification) {
		prenom = identification.getPrenom();
		nom = identification.getNom();
	}
	
	//Méthode accesseur pour le prénom.
	public String getPrenom() {
		return prenom;
	}
	
	//Méthode mutateur pour le prénom.
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	//Méthode accesseur pour le nom.
	public String getNom() {
		return nom;
	}
	
	//Méthode mutateur pour le nom.
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return nom + " " + prenom;
	}

	/**
	 *  Méthode qui vérifie si deux objets infirmiers sont similaires (donc sont
	 *  le même infirmier). En vérifiant l'identifiant et la disponibilité.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Identification other = (Identification) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
	public Identification clone() {
		return new Identification(this);
	}
	
}
