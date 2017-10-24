package tp2_inf;
import java.util.Scanner;

/**
 * 
 * @author ak37700
 *
 * Ce logiciel gère le calendrier des docteurs et infirmiers d'une clinique. 
 * Il gère aussi le calendrier des clients, c'est-à-dire les patients et leurs rendez-vous.
 */
public class Main {

	public static void main(String[] args) {

		Scanner clavier = new Scanner(System.in); //Déclaration de la lecture du clavier
		int choix = 0; //choix de l'administrateur à la console


		// L'administrateur aura le choix entre 14 options décrites ci-dessous. Les options sont réaffichées si l'administrateur presse une option qui n'est pas entre 1 et 14.

		while (choix != 14) {

			do{


				System.out.print("Bienvenue à la clinique\nQue voulez-vous faire ?\n1) Ajouter un docteur\n2) Ajouter un infirmier\n3) Ajouter un patient\n4) Ajouter un rendez-vous"
						+ "\n5) Trouver un rendez-vous pour un patient\n6) Afficher le prochain rendez-vous d'un docteur\n7) Afficher le prochain rendez-vous d'un infirmier\n"
						+ "8) Afficher le prochain rendez-vous d'un patient\n9) Passer à la prochaine plage horaire\n10) Afficher le calendrier complet\n"
						+ "11) Afficher le calendrier complet d'un docteur\n12) Afficher le calendrier complet d'un infirmier\n13) Annuler un rendez-vous\n14) Quitter\n ");

				choix = clavier.nextInt();

				switch (choix){

				case 1:

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

}
