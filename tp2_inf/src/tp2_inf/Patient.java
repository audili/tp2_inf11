package tp2_inf;

import java.io.Serializable;

/**
 * 
 * @author ak37700
 *
 */

public class Patient implements Serializable {

	private Identification identification = new Identification(); //Identification du patient
	private int numeroAssuranceSociale; //Num�ro d'assurance sociale du patient


	/**
	 * Cr�e un patient avec son identification et son num�ro d'assurance sociale
	 * @param identification Nom et pr�nom du patient
	 * @param numeroAssuranceSociale Num�ro d'assurance sociale du patient
	 */

	public Patient(Identification identification,int numeroAssuranceSociale){

		this.identification = identification;
		this.numeroAssuranceSociale = numeroAssuranceSociale;

	}

	public Patient(Patient patient) {

	}

	public Identification getIdentification(){
		return identification;
	}

	public void setIdentification(Identification identification){

	}
	
	/**
	 * Accesseur du num�ro d'assurance sociale du patient
	 * @return numeroAssuranceSociale
	 */
	public int getNumeroAssuranceSociale(){
		return numeroAssuranceSociale;

	}

	/**
	 * Mutateur du num�ro d'assurance sociale du patient
	 * @param numeroAssuranceSociale
	 */

	public void setNumeroAssuranceSociale(int numeroAssuranceSociale){
		this.numeroAssuranceSociale = numeroAssuranceSociale;

	}

	public boolean equals (Object obj){


		return false;

	}

	public String toString(){

		return (""+identification+" "+numeroAssuranceSociale);

	}

	public Patient clone (){
		return new Patient(this);
	}

}