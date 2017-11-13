package clinique;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 * 
 * Dernière date de modification: 11-12-2017
 * 
 * La classe PlageHoraire crée une liste de RendezVous avec la date et l'heure.
 * 
 * 
 */

@SuppressWarnings("serial")
public class PlageHoraire implements Serializable {
	
	/**
	 * 
	 */
	private Date dateHeure;
	private ArrayList<RendezVous> listeRendezVous;

	public PlageHoraire(Date date) {
		dateHeure = date;
		listeRendezVous = new ArrayList<RendezVous>();
	}
	
	/**
	 * Accesseur de la date (Heure)
	 * @return
	 */
	public Date getDate() {
		return dateHeure;
	}
	
	/**
	 *  Mutateur de la date (Heure)
	 * @param dateHeure
	 */
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

	/**
	 * Affichage de la plage horaire
	 */
	public String toString() {
		return "PlageHoraire du " + dateHeure + ", RendezVous: "
				+ listeRendezVous + "]";
	}
}
