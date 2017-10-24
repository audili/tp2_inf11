package tp2_inf;

public class Infirmier {

	private Identification identifiant = new Identification();
	 private boolean disponibilite;
	 

	 /*Constructeur par d�fault 
	  * 
	  * */
	 public Infirmier(){
		 identifiant.setNom("Defaut");
		 identifiant.setPrenom("Defaut");
		disponibilite = true;
		
		 
	 }
	 
	 public Infirmier(Infirmier infirmier) {
			identifiant = infirmier.getIdentifiant();
			disponibilite = infirmier.isDisponibilite();
			
		}
	 
	 /*Constructeur pour cr�er un infirmier avec son indentification (nom et pr�nom)
	  * et 
	  * sa disponibilit� (disponible ou pas disponible)
	  * */
	 public Infirmier(Identification identifiant, boolean disponibilite) {
		this.identifiant = identifiant;
		this.disponibilite = disponibilite;
	}


	 /*Encapsulation des attributs  priv�s
	  *  de la classe identification  et l'attribut 
	  *  disponibilit� de l'infirmier
	  *  */
	 
	public Identification getIdentifiant() {
		
		return identifiant;
		
	}
	public void setIdentifiant(Identification identifiant) {
		
		this.identifiant = identifiant;
		
	}
	public boolean isDisponibilite() {
		
		return disponibilite;
		
	}
	public void setDisponibilite(boolean disponibilite) {
		
		this.disponibilite = disponibilite;
		
	}
	
	/*Permet l'affichage d'un infirmier avec ses informations (nom , pr�nom et sa disponibilit�)*/
	
	@Override
	public String toString() {
		return "Infirmier [identifiant=" + identifiant.getNom() + identifiant.getPrenom()+  ", disponibilite="
				+ disponibilite + "]";
	}
	
	/*
	 * Verifier s'il y a un infirmier ayant les m�mes attributs qu'un autre nom ,pr�nom et sa disponibilit� 
	 */

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Infirmier other = (Infirmier) obj;
		
		if (disponibilite != other.disponibilite)
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
