/**
 * 
 */
package tp2_inf;

import java.io.Serializable;

/**
 * @author AP09730
 *
 */
public class Identification implements Serializable {

	/**
	 * Serialization ID
	 */
	private static final long serialVersionUID = -4624840770544994780L;

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
	 * @param prenom Pr�nom de l'intervenant
	 * @param nom Nom de famille de l'intervenant
	 */
	public Identification(String prenom, String nom) {
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
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return nom + ", " + prenom;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
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
