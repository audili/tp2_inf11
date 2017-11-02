package intervenants;

import java.io.Serializable;


/**
 * Cette classe crée un patient dans la clinique. Un patient peut être crée
 * sans informations. Sinon, l'identification et le numéro d'assurance sociale
 * seront aux attributs du patient.
 * 
 * Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 *
 */
@SuppressWarnings("serial")
public class Patient implements Serializable {
	
	private Identification identification = new Identification();
	private int numeroAssuranceSociale;


	/**
	 * Crée un patient avec son identification et son numéro d'assurance sociale
	 * @param identification Nom et prénom du patient
	 * @param numeroAssuranceSociale Numéro d'assurance sociale du patient
	 */
	public Patient(Identification identification,int numeroAssuranceSociale){

		this.identification = identification;
		this.numeroAssuranceSociale = numeroAssuranceSociale;

	}
	
	/**
	 * Constructeur 2 de l'objet patient.
	 * @param patient
	 */
	public Patient(Patient patient) {

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
	 * Accesseur du numéro d'assurance sociale du patient.
	 * @return numeroAssuranceSociale
	 */
	public int getNumeroAssuranceSociale(){
		return numeroAssuranceSociale;

	}

	/**
	 * Mutateur du numéro d'assurance sociale du patient.
	 * @param numeroAssuranceSociale
	 */
	public void setNumeroAssuranceSociale(int numeroAssuranceSociale){
		this.numeroAssuranceSociale = numeroAssuranceSociale;

	}
	/**
	 * Méthode boolénne qui nous retour ''false'' si deux objets ne sont pas
	 * identiques.
	 */
	@Override
	public boolean equals (Object obj){
		return false;

	}
	
	/**
	 * Méthode qui sert à l'affichage de l'objet Patient.
	 */
	@Override
	public String toString(){

		return (""+identification+" "+numeroAssuranceSociale);

	}
	
	/**
	 *  Clone le patient en cours.
	 */
	public Patient clone (){
		return new Patient(this);
	}

}