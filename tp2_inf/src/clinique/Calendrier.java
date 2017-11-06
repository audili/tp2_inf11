package clinique;


import java.io.Serializable;
import java.util.Date;

import intervenants.Docteur;
import intervenants.Infirmier;
import intervenants.Patient;

public class Calendrier implements Serializable {
	
	private FilePlageHoraire  plageHoraire;
	
	
	public FilePlageHoraire getPlageHoraire()   {
		return plageHoraire;	
	}

	public void setPlageHoraire(FilePlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}
	
	public boolean  ajouterRendezvous(PlageHoraire plageHoraire , RendezVous rendezvous) {
	//	this.getPlageHoraire().enFile(plageHoraire);
		getPlageHoraireRendezVous(plageHoraire ,rendezvous); 
		int minutes = plageHoraire.getDate().getMinutes() ; 
		
		
		if ( ( plageHoraire.getDate().getHours() > 8 && plageHoraire.getDate().getHours() < 20) && (minutes == 15 || minutes == 30 || minutes == 45) ){
			plageHoraire.addRendezVous(rendezvous);
		
			return true ; 
			
		}
		return false ; 
		
		
	}
	
	public   RendezVous obtenirProchainRendezVousPatient (Patient patient ,PlageHoraire plageHoraire ){
		for (int i=0; i < plageHoraire.getRendezVous().size() ; i++  ) {
			
			if (plageHoraire.getRendezVous().get(i).getPatient() == patient ) {
				
				this.plageHoraire.defile() ; 
				
				
				
			}
		 
			
			
			return  this.plageHoraire.getTete().getPlageHoraire().getRendezVous().get(i);
		}
	
		
		return null ; 
		
	}
	
  public RendezVous obtenirProchainRendezVousInfirmier(Infirmier infirmier , PlageHoraire plageHoraire) {
	for (int i=0; i < plageHoraire.getRendezVous().size() ; i++  ) {
			
			if (plageHoraire.getRendezVous().get(i).getInfirmier() == infirmier ) {
				
				this.plageHoraire.defile() ; 
			}
			return  this.plageHoraire.getTete().getPlageHoraire().getRendezVous().get(i);
		}

	  return null ; 
  }
  
  public RendezVous obtenirProchainRendezVousDocteur(Docteur  docteur , PlageHoraire plageHoraire) {
	for (int i=0; i < plageHoraire.getRendezVous().size() ; i++  ) {
			
			if (plageHoraire.getRendezVous().get(i).getDocteur() == docteur ) {
				
				this.plageHoraire.defile() ; 
			}
			return  this.plageHoraire.getTete().getPlageHoraire().getRendezVous().get(i);
		}

	  return null ; 
  }
  
   public PlageHoraire obtenirProchainePlageHoraire(PlageHoraire plageHoraire){
	   if (plageHoraire == this.plageHoraire.getTete().getPlageHoraire()) {
		   
		   this.plageHoraire.defile() ; 
		   return plageHoraire ; 
	   }
	   
	   
	   return null ; 
   }
   

  
	
	
	private PlageHoraire getPlageHoraireRendezVous(PlageHoraire plageHorairee , RendezVous rendezvous){
		
		Date date ; 
		date = plageHorairee.getDate() ; 
		
		this.plageHoraire.getTete().setValeur(plageHorairee);
		
		 plageHorairee = this.plageHoraire.getTete().getPlageHoraire();
		
		
		return plageHorairee;
		
	}
	
	
	
}
