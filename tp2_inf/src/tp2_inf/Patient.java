package tp2_inf;

import java.io.Serializable;

/**
 * 
 * @author ak37700
 *
 */

public class Patient implements Serializable {
	
	private Identification identification = new Identification(); //Identification du patient
	private int numeroAssuranceSociale; //Numéro d'assurance sociale du patient
	

	/**
	 * Crée un patient avec son identification et son numéro d'assurance sociale
	 * @param identification Nom et prénom du patient
	 * @param numeroAssuranceSociale Numéro d'assurance sociale du patient
	 */
	public Patient(Identification identification,int numeroAssuranceSociale){
	
		this.identification = identification;
		this.numeroAssuranceSociale = numeroAssuranceSociale;
		
	}
	
	public Identification getIdentification(){
		return identification;
	}
	
	public void setIdentification(Identification identification){
		
	}
	
	public int getNumeroAssuranceSociale(){
		return numeroAssuranceSociale;
			
	}
	
	public void setNumeroAssuranceSociale(){
		

}

}