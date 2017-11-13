package clinique;

import intervenants.Docteur;
import intervenants.Infirmier;
import intervenants.Patient;

import java.io.Serializable;

@SuppressWarnings("serial")
/**
 * 
 * @author Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 * 
 *  Derni�re date de modification: 11-05-2017
 * 
 * La classe rendez-vous, prends comme attribut un docteur, infirmier et 
 * patient.
 * 
 */


public class RendezVous implements Serializable {

	private Docteur docteur;		// Docteur consult� pendant le rendez-vous
	private Patient patient; 		// Patient ayant consult� le Docteur
	private Infirmier infirmier;	// Infirmier ayant aid� le Docteur

	/**
	 * M�thode constructeur d'un rendez-vous, qui prend en param�tre:
	 * @param patient
	 * @param docteur
	 * @param infirmier
	 */
	public RendezVous(Patient patient, Docteur docteur, Infirmier infirmier) {

		if(patient == null || docteur == null || infirmier == null) {
			throw new NullPointerException("Un attribut nul pour un rendezvous est interdit");
		}

		this.patient = patient;
		this.docteur = docteur;
		this.infirmier = infirmier;
	}
	
	/**
	 *  M�thode accesseur qui retourne le Docteur.
	 * @return
	 */
	public Docteur getDocteur() {
		return docteur;
	}
	
	/**
	 * M�thode mutateur qui modifie le Docteur.
	 * @param docteur
	 */
	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}
	
	/**
	 * M�thode accesseur qui retourne le patient.
	 * @return
	 */
	public Patient getPatient() {
		return patient;
	}
	
	/**
	 * M�thode mutateur qui modifie le patient.
	 * @param patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	/**
	 *  M�thode accesseur qui retourne un infirmier.
	 * @return
	 */
	public Infirmier getInfirmier() {
		return infirmier;
	}
	
	/**
	 *  M�thode mutateur qui retourne un infirmier.
	 * @param infirmier
	 */
	public void setInfirmier(Infirmier infirmier) {
		this.infirmier = infirmier;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RendezVous other = (RendezVous) obj;
		if (docteur == null) {
			if (other.docteur != null)
				return false;
		} else if (!docteur.equals(other.docteur))
			return false;
		if (infirmier == null) {
			if (other.infirmier != null)
				return false;
		} else if (!infirmier.equals(other.infirmier))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		return true;
	}

	// M�thode qui retourne un String.
	public String toString() {
		return "Le prochain rendez-vous du Docteur "+docteur.toString()
				+ " avec l'infirmier " + infirmier.
				toString() + " et le patient " + patient.toString();
	}
}
