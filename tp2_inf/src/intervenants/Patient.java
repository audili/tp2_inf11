package intervenants;

import java.io.Serializable;


/**
 * Cette classe cr�e un patient dans la clinique. Un patient peut �tre cr�e
 * sans informations. Sinon, l'identification et le num�ro d'assurance sociale
 * seront aux attributs du patient.
 * 
 * Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 * 
 * Derni�re date de modification: 11-05-2017
 *
 */
@SuppressWarnings("serial")
public class Patient implements Serializable {

	private Identification identification = new Identification();
	private String numeroAssuranceSociale;

	/**
	 * Cr�e un patient avec son identification et son num�ro d'assurance sociale
	 * @param identification Nom et pr�nom du patient
	 * @param numeroAssuranceSociale Num�ro d'assurance sociale du patient
	 */
	public Patient(Identification identification,String numeroAssuranceSociale){

		this.identification = identification;
		this.numeroAssuranceSociale = numeroAssuranceSociale;
	}

	/**
	 * Constructeur 2 de l'objet patient.
	 * @param patient
	 */
	public Patient(Patient patient) {
		identification = new Identification();
		numeroAssuranceSociale = "N/A";
	}

	/**
	 * Accesseur de l'identification du patient.
	 * @return numeroAssuranceSociale
	 */

	public Identification getIdentification(){
		return identification;
	}

	//Mutateur de l'identification du patient.
	public void setIdentification(Identification identification){

	}

	/**
	 * Accesseur du num�ro d'assurance sociale du patient.
	 * @return numeroAssuranceSociale
	 */
	public String getNumeroAssuranceSociale(){
		return numeroAssuranceSociale;
	}

	/**
	 * Mutateur du num�ro d'assurance sociale du patient.
	 * @param numeroAssuranceSociale
	 */
	public void setNumeroAssuranceSociale(String numeroAssuranceSociale){
		this.numeroAssuranceSociale = numeroAssuranceSociale;
	}
	/**
	 * M�thode bool�nne qui nous retour ''false'' si deux objets ne sont pas
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
		Patient other = (Patient) obj;
		if (identification == null) {
			if (other.identification != null)
				return false;
		} else if (!identification.equals(other.identification))
			return false;
		if (numeroAssuranceSociale == null) {
			if (other.numeroAssuranceSociale != null)
				return false;
		} else if (!numeroAssuranceSociale.equals(other.numeroAssuranceSociale))
			return false;
		return true;
	}
	
	/**
	 * M�thode qui sert � l'affichage de l'objet Patient.
	 */
	@Override
	public String toString(){
		return ("Patient " + identification+ ", NAS: "+numeroAssuranceSociale);
	}

	/**
	 *  Clone le patient en cours.
	 */
	public Patient clone (){
		return new Patient(this);
	}

}