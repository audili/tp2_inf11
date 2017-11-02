package intervenants;

import java.io.Serializable;


/**
 * Cette classe cr�e un patient dans la clinique. Un patient peut �tre cr�e
 * sans informations. Sinon, l'identification et le num�ro d'assurance sociale
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
	 * Cr�e un patient avec son identification et son num�ro d'assurance sociale
	 * @param identification Nom et pr�nom du patient
	 * @param numeroAssuranceSociale Num�ro d'assurance sociale du patient
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
	 * Accesseur du num�ro d'assurance sociale du patient.
	 * @return numeroAssuranceSociale
	 */
	public int getNumeroAssuranceSociale(){
		return numeroAssuranceSociale;

	}

	/**
	 * Mutateur du num�ro d'assurance sociale du patient.
	 * @param numeroAssuranceSociale
	 */
	public void setNumeroAssuranceSociale(int numeroAssuranceSociale){
		this.numeroAssuranceSociale = numeroAssuranceSociale;

	}
	/**
	 * M�thode bool�nne qui nous retour ''false'' si deux objets ne sont pas
	 * identiques.
	 */
	@Override
	public boolean equals (Object obj){
		return false;

	}
	
	/**
	 * M�thode qui sert � l'affichage de l'objet Patient.
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