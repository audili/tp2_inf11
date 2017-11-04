package clinique;

import intervenants.*;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * 
 * @author Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 *
 */
@SuppressWarnings("serial")
public class Clinique implements Serializable {

	private LinkedList<Docteur> listeDocteurs = new LinkedList<Docteur>();
	private LinkedList<Infirmier> listeInfirmiers = new LinkedList<Infirmier>();
	private LinkedList<Patient> listePatients = new LinkedList<Patient>();

	public LinkedList<Docteur> getListeDocteur() {
		return listeDocteurs;
	}

	public Docteur getDocteur(int index) {

		if(index < 0 || index > listeDocteurs.size() -1) {
			return null;
		}
		return listeDocteurs.get(index);
	}

	public void setListeDocteurs(LinkedList<Docteur> listeDocteurs) {
		this.listeDocteurs = listeDocteurs;
	}

	public boolean ajouterDocteur(Docteur docteur) {

		for(int i = 0; i < listeDocteurs.size(); i ++) {
			if(listeDocteurs.get(i).equals(docteur)) {
				return false;
			}
		}
		listeDocteurs.add(docteur);
		return true;
	}

	public LinkedList<Infirmier> getListeInfirmiers() {
		return listeInfirmiers;
	}

	public Infirmier getInfirmier(int index) {

		if(index < 0 || index > listeInfirmiers.size() -1) {
			return null;
		}
		return listeInfirmiers.get(index);
	}

	public void setListeInfirmiers(LinkedList<Infirmier> listeInfirmiers) {
		this.listeInfirmiers = listeInfirmiers;
	}

	public boolean ajouterInfirmier(Infirmier infirmier) {

		for(int i = 0; i < listeInfirmiers.size(); i ++) {
			if(listeInfirmiers.get(i).equals(infirmier)) {
				return false;
			}
		}
		listeInfirmiers.add(infirmier);
		return true;
	}

	public LinkedList<Patient> getListePatient() {
		return listePatients;
	}

	public Patient getPatient(int index) {

		if(index < 0 || index > listePatients.size() -1) {
			return null;
		}
		return listePatients.get(index);
	}

	public void setListePatient(LinkedList<Patient> listePatient) {
		this.listePatients = listePatient;
	}

	public boolean ajouterPatient(Patient patient) {

		for(int i = 0; i < listePatients.size(); i ++) {
			if(listePatients.get(i).equals(patient)) {
				return false;
			}
		}
		listePatients.add(patient);
		return true;
	}

	public void afficherDocteurs() {
		
		if(listeDocteurs.size() == 0) {
			System.out.println("La clinique ne contient aucun docteur.");
		}
		
		else {
			System.out.println("Les docteurs de la clinique sont : ");

			for (Docteur docteur : listeDocteurs) {
				System.out.println("    - " +  docteur);
			}
		}
		
		System.out.println("");
	}

	public void afficherInfirmiers() {
		
		if(listeInfirmiers.size() == 0) {
			System.out.println("La clinique ne contient aucun infirmier.");
		}
		
		else {
			System.out.println("Les infirmiers de la clinique sont : ");

			for (Infirmier infirmier : listeInfirmiers) {
				System.out.println("    - "  +  infirmier);
			}
		}
		
		System.out.println("");
	}
	
	public void afficherPatients() {

		if(listePatients.size() == 0) {
			System.out.println("La clinique ne contient aucun patient.");
		}
		
		else {
			System.out.println("Les patients de la clinique sont : ");

			for (Patient patient : listePatients) {
				System.out.println("    - " +  patient);
			}
		}
		
		System.out.println("");
	}
	
}
