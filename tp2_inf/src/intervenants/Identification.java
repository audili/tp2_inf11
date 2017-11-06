/**
 * 
 */
package intervenants;

import java.io.Serializable;

/**
 * 
 * @author Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 * 
 *  Derni�re date de modification: 11-05-2017
 *
 */
@SuppressWarnings("serial")
public class Identification implements Serializable {

	private String prenom;		// Pr�nom de l'intervenant
	private String nom;			// Nom de famille de l'intervenant
	
	/**
	 * Cr�� une Identification avec un pr�nom et un nom par d�faut.
	 */
	public Identification() {
		prenom = "DefautPrenom";
		nom = "DefautNom";
	}
	
	/**
	 * Cr�� une Identification avec un pr�nom et un nom donn�.
	 * @param nom Nom de famille de l'intervenant
	 * @param prenom Pr�nom de l'intervenant
	 */
	public Identification(String nom, String prenom) {
		this.prenom = prenom;
		this.nom = nom;
	}
	
	/**
	 * Cr�� une nouvelle Identification similaire � l'identification pass�e en param�tre
	 * @param identification Idenfication qu'on veut copier
	 */
	public Identification(Identification identification) {
		prenom = identification.getPrenom();
		nom = identification.getNom();
	}
	
	//M�thode accesseur pour le pr�nom.
	public String getPrenom() {
		return prenom;
	}
	
	//M�thode mutateur pour le pr�nom.
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	//M�thode accesseur pour le nom.
	public String getNom() {
		return nom;
	}
	
	//M�thode mutateur pour le nom.
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return nom + " " + prenom;
	}

	/**
	 *  M�thode qui v�rifie si deux objets infirmiers sont similaires (donc sont
	 *  le m�me infirmier). En v�rifiant l'identifiant et la disponibilit�.
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
