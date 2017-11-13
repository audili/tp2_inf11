package clinique;


import java.io.Serializable;
import java.util.Date;

import intervenants.Docteur;
import intervenants.Infirmier;
import intervenants.Patient;




/*
 * Auteur : Ali Joudad , Alec Durocher , Ayoub Moudrika 
 * Dernière modification : 2017-11-07
 * Classe calendrier  
 */
@SuppressWarnings("serial")
public class Calendrier implements Serializable {

	private FilePlageHoraire  filePlageHoraire;


	
    /**
     * Constructeur de la classe Calendrier 
     */
	public Calendrier() {
		setFilePlageHoraire(new FilePlageHoraire());
	}

	/*=======================Encapsulation======================================
	 * =========================================================================
	 * =======================================================================*/
	/**
	 * 
	 *
	 * getter et setter  de la file contenant les plages horaires 
	 * 
	 */
	public FilePlageHoraire getFilePlageHoraire()   {

		if(filePlageHoraire == null) {
			filePlageHoraire = new FilePlageHoraire();
		}
		return filePlageHoraire;	
	}


	public void setFilePlageHoraire(FilePlageHoraire plageHoraire) { 
		this.filePlageHoraire = plageHoraire;
	}
	/*==========================================================================
	 * =========================================================================
	 * =========================================================================
	 * =======================================================================*/

	/**
	 * Ajouter un rendez vous dans le calendrier de la clinique en respectant 
	 * les conditions des heures d'ouverture  
	 * et les intervalles des plages horaire en un quart d'heure 
	 * 
	 * @param plageHoraire
	 * @param rendezvous
	 */

	public void  ajouterRendezvous(Date date, RendezVous rendezVous) {

		if(getFilePlageHoraire().estVide()) {

			PlageHoraire plageHoraire = new PlageHoraire(date);
			plageHoraire.addRendezVous(rendezVous);

			getFilePlageHoraire().setTete(new Maillon(plageHoraire));
			System.out.println(rendezVous + " créé.");
			return;
		}

		PlageHoraire plageHoraire = getPlageHoraire(date);						
		boolean plageHoraireExiste = plageHoraire != null;

		if(!plageHoraireExiste) {
			plageHoraire = new PlageHoraire(date);
		}

		if(!rendezVous.getInfirmier().getDisponibilite(plageHoraire)) {

			System.out.println("Erreur : " + rendezVous.getInfirmier() + 
					" pour " + plageHoraire);
			return;
		}

		plageHoraire.addRendezVous(rendezVous);
		getFilePlageHoraire().enFile(plageHoraire);

		System.out.println(rendezVous + " créé.");
	}

	/**
	 * Obtenir les prochains rendez-vous du patient avec les informations  du  
	 * patient et ainsi chaque plage horaire  passés en paramètre 
	 * @param patient
	 * @param plageHoraire
	 * @return
	 */
	public RendezVous obtenirProchainRendezVousPatient (Patient patient,
			PlageHoraire plageHoraire ){

		Calendrier calendrier = obtenirCalendrierPatient(patient);

		Maillon maillon = calendrier.getFilePlageHoraire().getTete();
		while (maillon != null) {

			if(maillon.getPlageHoraire().getDate().
					before(plageHoraire.getDate())) {
				maillon = maillon.getProchain();
			}
			else {
				return maillon.getPlageHoraire().getRendezVous().get(0);
			}
		}
		return null;
	}

	/**
	 * Obtenir les prochains rendez-vous du patient avec les informations  de 
	 * l'infirmier  et ainsi chaque plage horaire  passés en paramètre
	 * @param infirmier
	 * @param plageHoraire
	 * @return
	 */

	public RendezVous obtenirProchainRendezVousInfirmier(Infirmier infirmier ,
			PlageHoraire plageHoraire) {

		Calendrier calendrier = obtenirCalendrierInfirmier(infirmier);

		Maillon maillon = calendrier.getFilePlageHoraire().getTete();
		while (maillon != null) {

			if(maillon.getPlageHoraire().getDate().
					before(plageHoraire.getDate())) {
				maillon = maillon.getProchain();
			}
			else {
				return maillon.getPlageHoraire().getRendezVous().get(0);
			}
		}
		return null;
	}

	/**
	 * Obtenir les prochains rendez-vous du patient avec les informations  du 
	 * docteur   et ainsi chaque plage horaire  passés en paramètre
	 * @param Docteur
	 * @param plageHoraire
	 * @return
	 */

	public RendezVous obtenirProchainRendezVousDocteur(Docteur  docteur , 
			PlageHoraire plageHoraire) {

		Calendrier calendrier = obtenirCalendrierDocteur(docteur);

		Maillon maillon = calendrier.getFilePlageHoraire().getTete();
		while (maillon != null) {

			if(maillon.getPlageHoraire().getDate().before(
					plageHoraire.getDate())) {
				maillon = maillon.getProchain();
			}
			else {
				return maillon.getPlageHoraire().getRendezVous().get(0);
			}
		}
		return null;

	}
	/**
	 * Obtenir la prochaine plage horaire qui est dans la file filePlageHoraire
	 * @param plageHoraire
	 * @return
	 */
	public PlageHoraire obtenirProchainePlageHoraire(PlageHoraire plageHoraire){
		if (plageHoraire == getFilePlageHoraire().getTete().getPlageHoraire()) {

			getFilePlageHoraire().defile() ; 
			return plageHoraire ; 
		}


		return null ; 
	}
	/**
	 * Sous programme pour annuler un rendez vous en vérifiant la présence du 
	 * rendez vous présent dans la plage horaire dans le 
	 * calendrier passé en paramètre et annulez le rendez-vous passé
	 * en 
	 * paramètre 
	 * 
	 * @param rendezvous
	 * @param plageHoraire
	 * @return
	 */


	public boolean annulerRendezVous( RendezVous rendezvous , PlageHoraire 
			plageHoraire  ) {

		for (int i=0 ; i < getFilePlageHoraire().getTete().getPlageHoraire().
				getRendezVous().size() ; i++){

			if (getFilePlageHoraire().getTete().getPlageHoraire().
					getRendezVous().get(i).equals(rendezvous)) {
				
				
				getFilePlageHoraire().getTete().getProchain().getPlageHoraire()
				.getRendezVous().remove(i);

				return true ; 
			}
		}

		return false ;
	}
	/**
	 * Dans  ce sous-programme on obtient le calendrier du patient avec ses 
	 * informations données en paramètres 
	 * @param patient
	 * @return
	 */

	public Calendrier obtenirCalendrierPatient(Patient patient) {

		Calendrier calendrier = new Calendrier();

		Maillon maillon = getFilePlageHoraire().getTete();
		while (maillon != null) {

			PlageHoraire plageHoraire = maillon.getPlageHoraire();
			PlageHoraire plageHorairePatient = 
					new PlageHoraire(plageHoraire.getDate());

			for (RendezVous rendezVous : plageHoraire.getRendezVous()) {
				if(rendezVous.getPatient().equals(patient)) {
					plageHorairePatient.addRendezVous(rendezVous);
				}
			}

			if(!plageHorairePatient.getRendezVous().isEmpty()) {
				FilePlageHoraire filePlageHoraire = calendrier.
						getFilePlageHoraire();

				if(filePlageHoraire.estVide()) {
					filePlageHoraire.setTete(new Maillon(plageHorairePatient));
				}
				else {
					calendrier.getFilePlageHoraire().
					enFile(plageHorairePatient);
				}
			}
			maillon = maillon.getProchain();
		}
		return calendrier;
	}
/**
 * Dans  ce sous-programme on obtient le calendrier de l'informations avec ses 
 * * informations données en paramètre 
 * @param infirmier
 * @return
 */
	public Calendrier obtenirCalendrierInfirmier(Infirmier infirmier) {

		Calendrier calendrier = new Calendrier();

		Maillon maillon = getFilePlageHoraire().getTete();
		while (maillon != null) {

			PlageHoraire plageHoraire = maillon.getPlageHoraire();
			PlageHoraire plageHoraireInfirmier = 
					new PlageHoraire(plageHoraire.getDate());

			for (RendezVous rendezVous : plageHoraire.getRendezVous()) {
				if(rendezVous.getInfirmier().equals(infirmier)) {
					plageHoraireInfirmier.addRendezVous(rendezVous);
				}
			}

			if(!plageHoraireInfirmier.getRendezVous().isEmpty()) {
				FilePlageHoraire filePlageHoraire = calendrier.
						getFilePlageHoraire();

				if(filePlageHoraire.estVide()) {
					filePlageHoraire.setTete
					(new Maillon(plageHoraireInfirmier));
				}
				else {
					calendrier.getFilePlageHoraire()
					.enFile(plageHoraireInfirmier);
				}
			}
			maillon = maillon.getProchain();
		}
		return calendrier;
	}
/**
 * Dans  ce sous-programme on obtient le calendrier du docteur avec ses 
 * informations données en paramètre 
 * @param docteur
 * @return
 */
	public Calendrier obtenirCalendrierDocteur(Docteur docteur) {

		Calendrier calendrier = new Calendrier();

		Maillon maillon = getFilePlageHoraire().getTete();
		while (maillon != null) {

			PlageHoraire plageHoraire = maillon.getPlageHoraire();
			PlageHoraire plageHoraireDocteur = 
					new PlageHoraire(plageHoraire.getDate());

			for (RendezVous rendezVous : plageHoraire.getRendezVous()) {
				if(rendezVous.getDocteur().equals(docteur)) {
					plageHoraireDocteur.addRendezVous(rendezVous);
				}
			}

			if(!plageHoraireDocteur.getRendezVous().isEmpty()) {
				FilePlageHoraire filePlageHoraire = 
						calendrier.getFilePlageHoraire();

				if(filePlageHoraire.estVide()) {
					filePlageHoraire.setTete
					(new Maillon(plageHoraireDocteur));
				}
				else {
					calendrier.getFilePlageHoraire().
					enFile(plageHoraireDocteur);
				}
			}
			maillon = maillon.getProchain();
		}
		return calendrier;
	}
	/* 
	 * ========================== Fonctions privées ============================
	 * =========================================================================
	 * =========================================================================
	 * =======================================================================*/
	
	
	/**
	 * Obtenir la plage horaire du calendrier  du rendez vous .
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private PlageHoraire getPlageHoraire(Date date){

		Maillon maillon = getFilePlageHoraire().getTete();

		while (maillon != null) {

			Date dateMaillon = maillon.getPlageHoraire().getDate();
			if(dateMaillon.getDay() == date.getDay() && 
					dateMaillon.getYear() == date.getYear() &&
					dateMaillon.getMonth() == date.getMonth() &&
					dateMaillon.getHours() == date.getHours() &&
					dateMaillon.getMinutes() == date.getMinutes()) {

				return maillon.getPlageHoraire();
			}

			maillon = maillon.getProchain();
		}

		return null;
	}
	/**
	 * Afficher les plages horaires dans le calendrier 
	 */

	@Override
	public String toString() {
		
		return "Calendrier [" + filePlageHoraire.getTete().getPlageHoraire().
				getRendezVous().get(0) + "]";
	
	}
}
