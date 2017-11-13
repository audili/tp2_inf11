package clinique;

import intervenants.*;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * 
 * @author Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 * 
 *  Derni�re date de modification: 11-05-2017
 *
 */
@SuppressWarnings("serial")
public class Clinique implements Serializable {
	
	/**
	 *  Variables qui contiennent la liste des docteurs, Infirmiers et patients.
	 */


	private LinkedList<Docteur> listeDocteurs = new LinkedList<Docteur>();
	private LinkedList<Infirmier> listeInfirmiers = new LinkedList<Infirmier>();
	private LinkedList<Patient> listePatients = new LinkedList<Patient>();
	private Calendrier calendrier = new Calendrier();
	
	/**
	 *  M�thode accesseur qui retourne un calendrier.
	 * @return calendrier
	 */

	public Calendrier getCalendrier() {
		return calendrier;
	}
	
	/**
	 * M�thode mutateur qui modifie un calendrier.
	 * @param calendrier
	 */

	public void setCalendrier(Calendrier calendrier) {
		this.calendrier = calendrier;
	}

	/**
	 * M�thode accesseur qui retourne une liste de Docteurs.
	 * @return listeDocteurs
	 */

	public LinkedList<Docteur> getListeDocteur() {
		return listeDocteurs;
	}

	/**
	 * M�thode accesseur qui retourne un Docteur selon l'index choisi
	 * @return listeDocteurs
	 */

	public Docteur getDocteur(int index) {

		if(index < 0 || index > listeDocteurs.size() -1) {
			return null;
		}
		return listeDocteurs.get(index);
	}

	
	/**
	 * M�thode mutateur qui modifie la liste des docteurs.
	 * @param listeDocteurs
	 */
	public void setListeDocteurs(LinkedList<Docteur> listeDocteurs) {
		this.listeDocteurs = listeDocteurs;
	}

	/**
	 * M�thode qui ajoute un Docteur dans la liste des Docteurs. Si le docteur
	 * existe d�j�, aucune action n'est effectu�e.
	 * @param docteur
	 * @return true, false
	 */

	public boolean ajouterDocteur(Docteur docteur) {

		for(int i = 0; i < listeDocteurs.size(); i ++) {
			if(listeDocteurs.get(i).equals(docteur)) {
				return false;
			}
		}
		listeDocteurs.add(docteur);
		return true;
	}

	/**
	 * M�thode qui retourne la liste des infirmiers.
	 * @return ListeInfirmiers
	 */

	public LinkedList<Infirmier> getListeInfirmiers() {
		return listeInfirmiers;
	}

	/**
	 * M�thode accesseur qui retourne un Infirmier selon l'index choisi.
	 * 
	 * @return listeInfirmiers
	 */

	public Infirmier getInfirmier(int index) {

		if(index < 0 || index > listeInfirmiers.size() -1) {
			return null;
		}
		return listeInfirmiers.get(index);
	}

	/**
	 * M�thode mutateur qui modifie la liste des Infirmiers avec une nouvelle
	 * liste envoy�e en param�tre.
	 * @param listeInfirmiers
	 */

	public void setListeInfirmiers(LinkedList<Infirmier> listeInfirmiers) {
		this.listeInfirmiers = listeInfirmiers;
	}

	/**
	 * M�thode qui ajoute un Infirmier dans la liste des Infirmiers. Si
	 * l'infirmier existe d�j�, aucune action n'est effectu�e.
	 * @param Infirmier
	 * @return true or false
	 */

	public boolean ajouterInfirmier(Infirmier infirmier) {

		for(int i = 0; i < listeInfirmiers.size(); i ++) {
			if(listeInfirmiers.get(i).equals(infirmier)) {
				return false;
			}
		}
		listeInfirmiers.add(infirmier);
		return true;
	}

	/**
	 * M�thode accesseur qui retourne la liste des patients
	 * @return
	 */

	public LinkedList<Patient> getListePatient() {
		return listePatients;
	}

	/**
	 * M�thode accesseur qui retourne un Patient dans la liste selon l'index
	 * choisi
	 * @param index
	 * @return patient
	 */

	public Patient getPatient(int index) {

		if(index < 0 || index > listePatients.size() -1) {
			return null;
		}
		return listePatients.get(index);
	}

	/**
	 *  M�thode mutateur qui modifie la liste des patients.
	 * @param listePatient
	 */

	public void setListePatient(LinkedList<Patient> listePatient) {
		this.listePatients = listePatient;
	}

	/**
	 *  M�thode qui ajoute un patient � la liste des Patients, n'effectue 
	 *  aucune action si le patient existe d�j�.
	 * @param patient
	 * @return true or false
	 */

	public boolean ajouterPatient(Patient patient) {

		for(int i = 0; i < listePatients.size(); i ++) {
			if(listePatients.get(i).equals(patient)) {
				return false;
			}
		}
		listePatients.add(patient);
		return true;
	}

	/**
	 * M�thode qui affiche les docteurs de la clinique.
	 */
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

	/**
	 * M�thode qui affiche les infirmiers de la clinique.
	 */
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
	
	/**
	 * M�thode qui affiche les patients de la clinique.
	 */
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
