package clinique;

import intervenants.*;

import java.io.Serializable;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class Clinique implements Serializable {

	private LinkedList<Docteur> listeDocteur = new LinkedList<Docteur>();
	private LinkedList<Infirmier> listeInfirmier = new LinkedList<Infirmier>();
	private LinkedList<Patient> listePatient = new LinkedList<Patient>();

	public LinkedList<Docteur> getListeDocteur() {
		return listeDocteur;
	}

	public Docteur getDocteur(int index) {

		if(index < 0 || index > listeDocteur.size() -1) {
			return null;
		}
		return listeDocteur.get(index);
	}

	public void setListeDocteur(LinkedList<Docteur> listeDocteur) {
		this.listeDocteur = listeDocteur;
	}

	public boolean ajouterDocteur(Docteur docteur) {

		for(int i = 0; i < listeDocteur.size(); i ++) {
			if(listeDocteur.get(i).equals(docteur)) {
				return false;
			}
		}
		listeDocteur.add(docteur);
		return true;
	}

	public LinkedList<Infirmier> getListeInfirmier() {
		return listeInfirmier;
	}

	public Infirmier getInfirmier(int index) {

		if(index < 0 || index > listeInfirmier.size() -1) {
			return null;
		}
		return listeInfirmier.get(index);
	}

	public void setListeInfirmier(LinkedList<Infirmier> listeInfirmier) {
		this.listeInfirmier = listeInfirmier;
	}

	public boolean ajouterInfirmier(Infirmier infirmier) {

		for(int i = 0; i < listeInfirmier.size(); i ++) {
			if(listeInfirmier.get(i).equals(infirmier)) {
				return false;
			}
		}
		listeInfirmier.add(infirmier);
		return true;
	}

	public LinkedList<Patient> getListePatient() {
		return listePatient;
	}

	public Patient getPatient(int index) {

		if(index < 0 || index > listePatient.size() -1) {
			return null;
		}
		return listePatient.get(index);
	}

	public void setListePatient(LinkedList<Patient> listePatient) {
		this.listePatient = listePatient;
	}
	
	public boolean ajouterPatient(Patient patient) {

		for(int i = 0; i < listePatient.size(); i ++) {
			if(listePatient.get(i).equals(patient)) {
				return false;
			}
		}
		listePatient.add(patient);
		return true;
	}
}
