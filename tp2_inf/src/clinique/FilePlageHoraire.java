package clinique;


public class FilePlageHoraire {

	private Maillon tete ; 


	public FilePlageHoraire (PlageHoraire plageHoraire) {

		this.tete = new Maillon(plageHoraire) ; 

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
