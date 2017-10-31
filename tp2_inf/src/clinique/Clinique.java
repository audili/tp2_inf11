package clinique;

import intervenants.*;
import java.util.LinkedList;

public class Clinique {

	private LinkedList<Docteur> listeDocteur = new LinkedList<Docteur>();
	private LinkedList<Infirmier> listeInfirmier = new LinkedList<Infirmier>();
	private LinkedList<Patient> listePatient = new LinkedList<Patient>();

	public LinkedList<Docteur> getListeDocteur() {

		return listeDocteur;

	}

	public void setListeDocteur(LinkedList<Docteur> listeDocteur) {

		this.listeDocteur = listeDocteur;

	}

	public LinkedList<Infirmier> getListeInfirmier() {

		return listeInfirmier;

	}


	public void setListeInfirmier(LinkedList<Infirmier> listeInfirmier) {

		this.listeInfirmier = listeInfirmier;

	}

	public LinkedList<Patient> getListePatient() {

		return listePatient;

	}

	public void setListePatient(LinkedList<Patient> listePatient) {

		this.listePatient = listePatient;

	}

}
