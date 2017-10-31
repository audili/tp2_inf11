package clinique;

import intervenants.Docteur;
import intervenants.Infirmier;
import intervenants.Patient;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RendezVous implements Serializable {

	private Docteur docteur;		// Docteur consulté pendant le rendez-vous
	private Patient patient; 		// Patient ayant consulté le Docteur
	private Infirmier infirmier;	// Infirmier ayant aidé le Docteur

	public RendezVous(Patient patient, Docteur docteur, Infirmier infirmier) {

		if(patient == null || docteur == null || infirmier == null) {
			throw new NullPointerException("Un attribut nul pour un rendezvous est interdit");
		}

		this.patient = patient;
		this.docteur = docteur;
		this.infirmier = infirmier;
	}

	public Docteur getDocteur() {
		return docteur;
	}

	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Infirmier getInfirmier() {
		return infirmier;
	}

	public void setInfirmier(Infirmier infirmier) {
		this.infirmier = infirmier;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	public String toString() {
		return docteur.toString() + " " + infirmier.toString() + " " + patient.toString();
	}
}
