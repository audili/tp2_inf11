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
	 * 
	 *
	 * getter et setter  de la file contenant les plages horaires 
	 * 
	 */
	
	/*================================================================================================================
	 * ===============================================================================================================
	 * ===============================================================================================================*/
	public FilePlageHoraire getPlageHoraire()   {

		if(filePlageHoraire == null) {
			filePlageHoraire = new FilePlageHoraire(null);
		}
		return filePlageHoraire;	
	}
	

	public void setPlageHoraire(FilePlageHoraire plageHoraire) { 
		this.filePlageHoraire = plageHoraire;
	}
	/*================================================================================================================
	 * ===============================================================================================================
	 * ===============================================================================================================*/
	
	/**
	 * Ajouter un rendez vous dans le calendrier de la clinique en respectant les conditions des heures d'ouverture  
	 * et les intervalles des plages horaire en un quart d'heure 
	 * 
	 * @param plageHoraire
	 * @param rendezvous
	 * @return
	 */

	public boolean  ajouterRendezvous(PlageHoraire plageHoraire , RendezVous rendezvous) {
		getPlageHoraire().enFile(plageHoraire);

		getPlageHoraireRendezVous(plageHoraire ,rendezvous); 
		int minutes = plageHoraire.getDate().getMinutes() ; 


		if ( ( plageHoraire.getDate().getHours() > 8 && plageHoraire.getDate().getHours() < 20) && (minutes == 15 || minutes == 30 || minutes == 45) ){
			plageHoraire.addRendezVous(rendezvous);

			return true ; 

		}
		return false ; 

	}

	/**
	 * Obtenir les prochains rendez-vous du patient avec les informations  du  patient et ainsi chaque plage horaire  passés en paramètre 
	 * @param patient
	 * @param plageHoraire
	 * @return
	 */
	public RendezVous obtenirProchainRendezVousPatient (Patient patient, PlageHoraire plageHoraire ){

		for (int i =0; i < plageHoraire.getRendezVous().size(); i++) {			
			if (plageHoraire.getRendezVous().get(i).getPatient() == patient ) {
				getPlageHoraire().defile() ; 
			}
			return getPlageHoraire().getTete().getPlageHoraire().getRendezVous().get(i);
		}

		return null ; 
	}
	
	/**
	 * Obtenir les prochains rendez-vous du patient avec les informations  de l'infirmier  et ainsi chaque plage horaire  passés en paramètre
	 * @param infirmier
	 * @param plageHoraire
	 * @return
	 */

	public RendezVous obtenirProchainRendezVousInfirmier(Infirmier infirmier , PlageHoraire plageHoraire) {
		for (int i=0; i < plageHoraire.getRendezVous().size() ; i++  ) {

			if (plageHoraire.getRendezVous().get(i).getInfirmier() == infirmier ) {

				getPlageHoraire().defile() ; 
			}
			return getPlageHoraire().getTete().getPlageHoraire().getRendezVous().get(i);
		}

		return null ; 
	}
	
	/**
	 * Obtenir les prochains rendez-vous du patient avec les informations  du docteur   et ainsi chaque plage horaire  passés en paramètre
	 * @param Docteur
	 * @param plageHoraire
	 * @return
	 */

	public RendezVous obtenirProchainRendezVousDocteur(Docteur  docteur , PlageHoraire plageHoraire) {
		for (int i=0; i < plageHoraire.getRendezVous().size() ; i++  ) {

			if (plageHoraire.getRendezVous().get(i).getDocteur() == docteur ) {

				getPlageHoraire().defile() ; 
			}
			return getPlageHoraire().getTete().getPlageHoraire().getRendezVous().get(i);
		}

		return null ; 
	}
/**
 * Obtenir la prochaine plage horaire qui est dans la file filePlageHoraire
 * @param plageHoraire
 * @return
 */
	public PlageHoraire obtenirProchainePlageHoraire(PlageHoraire plageHoraire){
		if (plageHoraire == getPlageHoraire().getTete().getPlageHoraire()) {

			getPlageHoraire().defile() ; 
			return plageHoraire ; 
		}


		return null ; 
	}
	/**
	 * Sous programme pour annuler un rendez vous en vérifiant la présence du rendez vous présent dans la plage horaire dans le 
	 * calendrier passé en paramètre et annulez le rendez-vous passécen paramètre 
	 * 
	 * @param rendezvous
	 * @param plageHoraire
	 * @return
	 */


	public boolean annulerRendezVous( RendezVous rendezvous , PlageHoraire plageHoraire  ) {

		for (int i=0 ; i < getPlageHoraire().getTete().getPlageHoraire().getRendezVous().size() ; i++){

			if (getPlageHoraire().getTete().getPlageHoraire().getRendezVous().get(i).equals(rendezvous)) {
				getPlageHoraire().defile();

				return true ; 
			}

		}

		return false ;
	}
	
	  public void obtenirCalendrierInfirmier(Infirmier infirmier) {
		 	   
		 	   Calendrier calendrier = new Calendrier();
		 	   for (int i=0; i <getPlageHoraire().getTete().getPlageHoraire().getRendezVous().size() ; i++  ) {
		 			
		 			if (getPlageHoraire().getTete().getPlageHoraire().getRendezVous().get(i).getInfirmier() == infirmier ) {
		 				
		 				calendrier.ajouterRendezvous(getPlageHoraire().getTete().getPlageHoraire(), getPlageHoraire().getTete().getPlageHoraire().getRendezVous().get(i));
		 			}
		 			
		 			
		 	   }
		   }
	  
	  public void obtenirCalendrierDocteur(Docteur docteur) {
		  	   
		  	   Calendrier calendrier = new Calendrier();
		  	   for (int i=0; i <this.getPlageHoraire().getTete().getPlageHoraire().getRendezVous().size() ; i++  ) {
		  			
		  			if (this.getPlageHoraire().getTete().getPlageHoraire().getRendezVous().get(i).getDocteur() == docteur ) {
		  				
		  				calendrier.ajouterRendezvous(getPlageHoraire().getTete().getPlageHoraire(), this.getPlageHoraire().getTete().getPlageHoraire().getRendezVous().get(i));
		  			}
		  	   }
		     }



	private PlageHoraire getPlageHoraireRendezVous(PlageHoraire plageHorairee , RendezVous rendezvous){

		Date date ; 
		date = plageHorairee.getDate() ; 

		getPlageHoraire().getTete().setValeur(plageHorairee);

		plageHorairee = getPlageHoraire().getTete().getPlageHoraire();


		return plageHorairee;

	}


}
