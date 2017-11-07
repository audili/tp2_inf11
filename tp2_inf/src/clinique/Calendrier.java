package clinique;


import java.io.Serializable;
import java.util.Date;

import intervenants.Docteur;
import intervenants.Infirmier;
import intervenants.Patient;

@SuppressWarnings("serial")
public class Calendrier implements Serializable {

	private FilePlageHoraire  filePlageHoraire;

	public FilePlageHoraire getPlageHoraire()   {

		if(filePlageHoraire == null) {
			filePlageHoraire = new FilePlageHoraire(null);
		}
		return filePlageHoraire;	
	}

	public void setPlageHoraire(FilePlageHoraire plageHoraire) {
		this.filePlageHoraire = plageHoraire;
	}

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

	public RendezVous obtenirProchainRendezVousPatient (Patient patient ,PlageHoraire plageHoraire ){

		for (int i =0; i < plageHoraire.getRendezVous().size(); i++) {			
			if (plageHoraire.getRendezVous().get(i).getPatient() == patient ) {
				getPlageHoraire().defile() ; 
			}
			return getPlageHoraire().getTete().getPlageHoraire().getRendezVous().get(i);
		}

		return null ; 
	}

	public RendezVous obtenirProchainRendezVousInfirmier(Infirmier infirmier , PlageHoraire plageHoraire) {
		for (int i=0; i < plageHoraire.getRendezVous().size() ; i++  ) {

			if (plageHoraire.getRendezVous().get(i).getInfirmier() == infirmier ) {

				getPlageHoraire().defile() ; 
			}
			return getPlageHoraire().getTete().getPlageHoraire().getRendezVous().get(i);
		}

		return null ; 
	}

	public RendezVous obtenirProchainRendezVousDocteur(Docteur  docteur , PlageHoraire plageHoraire) {
		for (int i=0; i < plageHoraire.getRendezVous().size() ; i++  ) {

			if (plageHoraire.getRendezVous().get(i).getDocteur() == docteur ) {

				getPlageHoraire().defile() ; 
			}
			return getPlageHoraire().getTete().getPlageHoraire().getRendezVous().get(i);
		}

		return null ; 
	}

	public PlageHoraire obtenirProchainePlageHoraire(PlageHoraire plageHoraire){
		if (plageHoraire == getPlageHoraire().getTete().getPlageHoraire()) {

			getPlageHoraire().defile() ; 
			return plageHoraire ; 
		}


		return null ; 
	}


	public boolean annulerRendezVous( RendezVous rendezvous , PlageHoraire plageHoraire  ) {

		for (int i=0 ; i < getPlageHoraire().getTete().getPlageHoraire().getRendezVous().size() ; i++){

			if (getPlageHoraire().equals(rendezvous)) {
				getPlageHoraire().defile();

				return true ; 
			}

		}

		return false ;
	}



	private PlageHoraire getPlageHoraireRendezVous(PlageHoraire plageHorairee , RendezVous rendezvous){

		Date date ; 
		date = plageHorairee.getDate() ; 

		getPlageHoraire().getTete().setValeur(plageHorairee);

		plageHorairee = getPlageHoraire().getTete().getPlageHoraire();


		return plageHorairee;

	}


}
