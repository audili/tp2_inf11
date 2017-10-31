package clinique;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("serial")
public class PlageHoraire implements Serializable {

	private Date dateHeure;
	private ArrayList<RendezVous> listeRendezVous;

	public PlageHoraire(Date date) {
		dateHeure = date;
		listeRendezVous = new ArrayList<RendezVous>();
	}

	public Date getDate() {
		return dateHeure;
	}

	public void setDate(Date dateHeure) {
		this.dateHeure = dateHeure;
	}

	/**
	 * Retourne une copie de la liste des RendezVous
	 * @return
	 */
	public ArrayList<RendezVous> getRendezVous() {
		return new ArrayList<RendezVous>(listeRendezVous);
	}

	/**
	 * Ajoute un rendez vous dans la PlageHoraire
	 * @param rendezVous
	 */
	public void addRendezVous(RendezVous rendezVous) {
		listeRendezVous.add(rendezVous);
	}

	public String toString() {
		return "PlageHoraire du " + dateHeure + ", RendezVous: "
				+ listeRendezVous + "]";
	}
}
