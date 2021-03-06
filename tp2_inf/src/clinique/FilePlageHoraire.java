package clinique;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FilePlageHoraire  implements Serializable {

	private Maillon tete ; 

	@Override
	public String toString() {
		return "FilePlageHoraire tete=" + tete + ")";
	}

	public boolean estVide() {

		return this.tete == null ; 

	}

	public void enFile(PlageHoraire plageHoraire) {

		Maillon pointeur = tete;

		while (pointeur.getProchain() != null) {

			pointeur = pointeur.getProchain();
		}
		pointeur.setProchain(new Maillon(plageHoraire));
	}
	
	

	public PlageHoraire defile() {

		Maillon maillonSupprime = this.tete;
		this.tete = this.tete.getProchain();

		return maillonSupprime.getPlageHoraire();

	}

	public Maillon getTete() {
		return tete;
	}

	public void setTete(Maillon tete) {
		this.tete = tete;
	} 

}
