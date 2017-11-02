package tp2_inf;
import java.util.Scanner;

import intervenants.*;

/**
 * 
 * Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 *
 * Ce logiciel gère le calendrier des docteurs et infirmiers d'une clinique. 
 * Il gère aussi le calendrier des clients, c'est-à-dire les patients et leurs 
 * rendez-vous.
 */

public class Main {

	public static void main(String[] args) {

		//Déclaration de la lecture du clavier
		Scanner clavier = new Scanner(System.in);

		int choix = 0; //choix de l'administrateur à la console

		/* L'administrateur aura le choix entre 14 options décrites ci-dessous. 
		 * Les options sont réaffichées si l'administrateur 
		 * presse une option qui n'est pas entre 1 et 14.
		 * On réaffiche le menu tant que l'administrateur n'a pas choisi 
		 *l'option de quitter (14).
		 */
		while (choix != 14) {

			do{

				//Affichage du menu principal

				System.out.println
				("Bienvenue à la clinique, que voulez-vous faire ?\n"
						+ "1) Ajouter un docteur \n"
						+ "2) Ajouter un infirmier \n"
						+ "3) Ajouter un patient \n"
						+ "4) Ajouter un rendez-vous \n"
						+ "5) Trouver un rendez-vous pour un patient \n"
						+ "6) Afficher le prochain rendez-vous d'un docteur \n"
						+ "7) Afficher le prochain rendez-vous d'un infirmier \n"
						+ "8) Afficher le prochain rendez-vous d'un patient \n"
						+ "9) Passer à la prochaine plage horaire \n"
						+ "10) Afficher le calendrier complet \n"
						+ "11) Afficher le calendrier complet d'un docteur \n"
						+ "12) Afficher le calendrier complet d'un infirmier \n"
						+ "13) Annuler un rendez-vous \n"
						+ "14) Quitter \n ");

				//Saisie de clavier de l'administrateur
				choix = clavier.nextInt(); 

				/*Ce code fait un appel de méthode selon le choix 
				de l'administrateur.*/
				switch (choix){

				case 1:
					ajouterDocteur(clavier);

				case 2:

				case 3:

				case 4:

				case 5:

				case 6:

				case 7:

				case 8:

				case 9:

				case 10:

				case 11:

				case 12:

				case 13:

				case 14:

				}

			} while ( choix < 1 || choix > 14);			
		}
	}


	/**
	 * 
	 * @param clavier 
	 * 
	 * Cette méthode demande le nom et le prénom d'un docteur à ajouter.
	 * 
	 * STRATÉGIE: Une fois le nom et prénom saisit, nous créons un objet
	 * nommé "identification".
	 */
	public static void ajouterDocteur(Scanner clavier) {

		String prenom = "";

		while(prenom != null){

			System.out.println("Veuillez entrer le prénom du docteur: ");
			prenom = clavier.nextLine();

		}

		System.out.println("Veuillez entrer le nom du docteur: ");
		String nom = clavier.nextLine();

		Identification identification = new Identification(prenom, nom);
		System.out.println("Le Dr. " + identification.toString() + " ajouté.");
	}
}
