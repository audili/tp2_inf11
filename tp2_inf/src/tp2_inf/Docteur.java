package tp2_inf;

public class Docteur {

	 private Identification identification;			// Identification du docteur
	 private enuDepartements departement; 			// D�partement o� travaille le docteur
	 
	 public enum enuDepartements {
			CHIRURGIE,URGENCE,UROLOGIE
	 }
	 
	 /**
	  * Cr�� un Docteur selon une identification donn�ee et un d�partement o� il travaille.
	  * @param identification Identifciation du Docteur
	  * @param departement D�partement o� travaille le Docteur
	  */
	 public Docteur(Identification identification, enuDepartements departement) {
		 this.identification = identification;
		 this.departement = departement;
	 }
	 
	 public Identification getIdentification() {
		 return identification;
	 }
	 
	 public void setIdentification(Identification identification) {
		 this.identification = identification;
	 }
	 
	 public enuDepartements getDepartement() {
		 return departement;
	 }
	 
	 public void setDepartement(enuDepartements departement) {
		 this.departement = departement;
	 }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Docteur " + identification.toString() + ", " + departement;
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
	 
	public Docteur clone() {
		return new Docteur(identification, departement);
	}
	 
}
