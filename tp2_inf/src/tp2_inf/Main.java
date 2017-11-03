package tp2_inf;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.InputMap;

import clinique.*;
import intervenants.*;
import intervenants.Docteur.enuDepartements;

/**
 * 
 * Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 *
 * Ce logiciel gère le calendrier des docteurs et infirmiers d'une clinique. 
 * Il gère aussi le calendrier des clients, c'est-à-dire les patients et leurs 
 * rendez-vous.
 */

public class Main {

	private static Clinique clinique;
	private static Scanner clavier;

	public static void main(String[] args) {

		Clinique cliniqueSauvegardee = UtilitaireFichier.getCliniqueSauvegardee();

		if(cliniqueSauvegardee == null) {
			clinique = new Clinique();
		} else {
			clinique = cliniqueSauvegardee;
		}

		//Déclaration de la lecture du clavier
		clavier = new Scanner(System.in);

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
				/* TODO : enlever ces lignes de test */
				clinique.afficherDocteurs();
				clinique.afficherInfirmiers();
				clinique.afficherPatients();

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
					ajouterDocteur();
					break;

				case 2:
					ajouterInfirmier();
					break;

				case 3:
					ajouterPatient();
					break;

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
					UtilitaireFichier.sauvegardeClinique(clinique);
					System.exit(0);
					break;
				}

			} while ( choix < 1 || choix > 14);			
		}
	}
	
	
	
	/**
	 * Ajoute un docteur dans la clinique depuis les données saisies par l'utilisateur.
	 */
	public static void ajouterDocteur() {

		Identification identification = creerIdentification(clavier, "du docteur.");
		enuDepartements departement = null;

		while(departement == null) {
			
			System.out.println("Pour quel département ce docteur travaille-t-il ? " + Arrays.toString(getTableauNomsDeDepartements()));
			
			/* Nous séparons la ligne écrite par l'utilisateur par espaces et prenons le premier mot que nous mettons en majuscule. */
			String nomDepartement =  clavier.nextLine().split(" ")[0].toUpperCase();
			
			try {
				/* Nous essayons de récupérér un département depuis le nomDepartement entré par l'utilisateur */
				departement = enuDepartements.valueOf(nomDepartement);
				
			} catch (IllegalArgumentException e) {
				/* Si aucune valeur n'a été retrouvée dans l'énumération de départements, laisser departement a null */
			}
		}
		
		Docteur docteur = new Docteur(identification, departement); 
		clinique.ajouterDocteur(docteur);
		System.out.println(docteur + " a été ajouté(e).");
	}
	
	/**
	 * Ajoute un infirmier dans la clinique depuis les données saisies par l'utilisateur.
	 */
	public static void ajouterInfirmier() {
		
		Identification identification = creerIdentification(clavier, "de l'infirmier.");
		Infirmier infirmier = new Infirmier(identification,true);
		
		clinique.ajouterInfirmier(infirmier);
		System.out.println(infirmier + " a été ajouté(e).");
	}
	
	/**
	 * Ajoute un patient dans la clinique depuis les données saisies par l'utilisateur
	 */
	public static void ajouterPatient() {
		
		Identification identification = creerIdentification(clavier, "du patient.");
		String numeroAssuranceSociale = null;
		
		while(!estUnNASValide(numeroAssuranceSociale)) {
			System.out.println("Veuillez entrer le numéro d'assurance sociale du patient (sans tirets et sans espaces).");
			numeroAssuranceSociale = clavier.nextLine().split(" ")[0];
		}
		
		Patient patient = new Patient(identification, numeroAssuranceSociale);
		clinique.ajouterPatient(patient);
		System.out.println(patient + " a été ajouté(e).");
	}
	
	/* ----------------------------------------------------------------------------------------------------------------------- */
	/* Méthodes privées */
	
	/**
	 * Récupère tous les noms de départements possibles
	 * @return Tableau contenant les noms de départements possibles en majuscule.
	 */
	private static String[] getTableauNomsDeDepartements() {
		
		int nbDepartements = enuDepartements.values().length;
		String[] nomsDepartements = new String[nbDepartements];
		
		for(int i =0; i < nbDepartements; i ++) {

			nomsDepartements[i] = enuDepartements.values()[i].name().toUpperCase();
		}
		return nomsDepartements;
	}
	
	/**
	 * Créer une identification selon les données saisies par un Scanner.
	 * @param clavier Scanner permettant d'utiliser les entrées de l'utilisateur
	 * @param suffixeIntervenant Suffixe qui indiquera à l'utilisateur quel type d'intervenant il est en train de créer
	 * @return
	 */
	private static Identification creerIdentification(Scanner clavier, String suffixeIntervenant) {
		
		String messageUtilisateurIdentification = "Veuillez entrer le nom et prénom " + suffixeIntervenant;
		
		/* Nous prenons la prochaine ligne écrite par l'utilisateur et la divisions avec les espaces pour en faire un tableau de mots.*/
		String[] tabNomPrenom = clavier.nextLine().split(" ");

		while(tabNomPrenom.length != 2) {

			System.out.println(messageUtilisateurIdentification);
			tabNomPrenom = clavier.nextLine().split(" ");
		}
		return new Identification(tabNomPrenom[0],tabNomPrenom[1]);
	}
	
	/**
	 * Détermine si une String est un numéro d'assurance sociale (NAS) valide.
	 * @param numeroAssuranceSociale String à vérifier
	 * @return Vrai si la String est valide, faux sinon.
	 */
	private static boolean estUnNASValide(String numeroAssuranceSociale) {
		
		/* Un NAS canadien doit contenir 9 chiffres */
		if(numeroAssuranceSociale == null || numeroAssuranceSociale.length() != 9) {
			return false;
		}
		
		try {
			
			/* Si il est impossible de convertir la String numeroAssuranceSociale en integer, cela signifie qu'elle ne contient pas seulement
			 * des chiffres, donc que c'est invalide. */
			Integer.parseInt(numeroAssuranceSociale);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
