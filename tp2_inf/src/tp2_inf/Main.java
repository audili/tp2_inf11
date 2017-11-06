package tp2_inf;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

				// Affichage du menu principal
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

				// Saisie de clavier de l'administrateur. Nous devons vérifier que l'administrateur entre un chiffre valide.
				if(clavier.hasNextInt()) {
					choix = clavier.nextInt();
				}
				else {
					
					/* S'il est impossible d'interpréter l'entrée de l'administrateur en integer, nous devons consommer 
					 * la prochaine ligne du Scanner pour empêcher la boucle infinie. */
					clavier.nextLine();
					choix = 0;
				}
				
				/* Si l'entrée de l'utilisateur était invalide (pas un nombre) ou que le nombre inscrit 
				 * n'est pas entre 1 et 14, avertir l'administrateur de son erreur. */
				if(choix < 1 || choix > 14) {
					System.out.println("Erreur : Veuillez saisir un nombre correspondant aux options numérotées. Retour au menu principal.");
				}
				
				/*Ce code fait un appel de méthode selon le choix de fonctionnalité de l'administrateur.*/
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
					ajouterRendezVous();
					break;

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
	 * Ajoute un docteur dans la clinique depuis les données saisies par 
	 * l'utilisateur.
	 */
	public static void ajouterDocteur() {

		Identification identification = creerIdentification(clavier, "du docteur.");
		enuDepartements departement = null;

		while(departement == null) {

			System.out.println("Pour quel département ce docteur travaille-t-il "
					+ "? " + Arrays.toString(getTableauNomsDeDepartements()));

			/* Nous séparons la ligne écrite par l'utilisateur par espaces et 
			 * prenons le premier mot que nous mettons en majuscule. */
			String nomDepartement =  clavier.nextLine().split(" ")[0].toUpperCase();

			try {
				/* Nous essayons de récupérér un département depuis le 
				 * nomDepartement entré par l'utilisateur */
				departement = enuDepartements.valueOf(nomDepartement);

			} catch (IllegalArgumentException e) {
				/* Si aucune valeur n'a été retrouvée dans l'énumération de 
				 * départements, laisser departement a null */
			}
		}

		Docteur docteur = new Docteur(identification, departement); 
		clinique.ajouterDocteur(docteur);
		System.out.println(docteur + " a été ajouté(e).");
	}

	/**
	 * Ajoute un infirmier dans la clinique depuis les données saisies par 
	 * l'utilisateur.
	 */
	public static void ajouterInfirmier() {

		Identification identification = creerIdentification(clavier, "de l'infirmier.");
		Infirmier infirmier = new Infirmier(identification,true);

		clinique.ajouterInfirmier(infirmier);
		System.out.println(infirmier + " a été ajouté(e).");
	}

	/**
	 * Ajoute un patient dans la clinique depuis les données saisies par 
	 * l'utilisateur
	 */
	public static void ajouterPatient() {

		Identification identification = creerIdentification(clavier, 
				"du patient.");
		String numeroAssuranceSociale = null;

		while(!estUnNASValide(numeroAssuranceSociale)) {
			System.out.println("Veuillez entrer le numéro d'assurance sociale "
					+ "du patient (sans tirets et sans espaces).");
			numeroAssuranceSociale = clavier.nextLine().split(" ")[0];
		}

		Patient patient = new Patient(identification, numeroAssuranceSociale);
		clinique.ajouterPatient(patient);
		System.out.println(patient + " a été ajouté(e).");
	}

	/**
	 * Créé un rendez-vous en demandant à l'utilisateur de choisir un docteur, 
	 * un infirmier et un patient.
	 */
	public static void ajouterRendezVous() {

		if(!peuxCreerRendezVous()) {
			return;
		}

		System.out.println("Pour créer un rendez-vous, il vous faut choisir "
				+ "un docteur, un infirmier disponible, un patient, une date et une heure.");
		System.out.println("");

		System.out.println("1) Choisisez un docteur.");
		Docteur docteurChoisi = null;

		while(docteurChoisi == null) {
			docteurChoisi = choisirDocteur();
		}

		System.out.println("2) Choisisez un infirmier disponible.");
		Infirmier infirmierChoisi = null;

		while(infirmierChoisi == null) {
			infirmierChoisi = choisirInfirmier();
		}

		System.out.println("3) Choisisez un patient.");
		Patient patientChoisi = null;

		while(patientChoisi == null) {
			patientChoisi = choisirPatient();
		}

		System.out.println("4) Choisisez la date du rendez-vous (AAAA-mm-jj).");
		Date dateRdv = null;
		
		while(dateRdv == null) {
			dateRdv = choisirDate();
		}
		
		System.out.println("5) Choisisez l'heure du rendez-vous (HH:mm).");
		boolean heureEstValide = false;
		
		while(!heureEstValide) {
			heureEstValide = choisirHeure(dateRdv);
		}
		
		// TODO : récupérer le calendrier de la clinique et vérifier si une plage horaire pour cette date existe.
		// En créer une sinon et l'ajouter au calendrier. Dans les deux cas, crééer un nouveau rdv avec docteurChoisi, infirmierChoisi et patientChoisi
		// et l'ajouter dans la collection rdv de la plageHoraire.

	}

	/* ---------------------Méthodes privées-------------------------------- */

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
	 * @param suffixeIntervenant Suffixe qui indiquera à l'utilisateur quel 
	 * type d'intervenant il est en train de créer
	 * @return
	 */
	private static Identification creerIdentification(Scanner clavier, String suffixeIntervenant) {

		String messageUtilisateurIdentification = "Veuillez entrer le nom et "
				+ "prénom " + suffixeIntervenant;

		/* Nous prenons la prochaine ligne écrite par l'utilisateur et la 
		 * division avec les espaces pour en faire un tableau de mots.*/
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
		if(numeroAssuranceSociale == null || numeroAssuranceSociale.length() 
				!= 9) {
			return false;
		}

		try {

			/* Si il est impossible de convertir la String numeroAssurance
			 * Sociale en integer, cela signifie qu'elle ne contient pas 
			 * seulement des chiffres, donc que c'est invalide. */
			Integer.parseInt(numeroAssuranceSociale);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * Détermine si l'utilisateur peux créer un rendez-vous et affiche pour 
	 * quelles sont les conditions manquantes s'il y a lieu.
	 * @return Vrai si la clinique contient un nombre minimum d'intervenants 
	 * recquis, faux sinon.
	 */
	private static boolean peuxCreerRendezVous() {

		boolean peuxCreerRendezVous = true;

		if(clinique.getListeDocteur().size() == 0) {
			System.out.println("Erreur : Il doit y avoir au moins "
					+ "un docteur d'ajouté dans la clinique.");
			System.out.println("");
			peuxCreerRendezVous = false;
		}

		if(clinique.getListeInfirmiers().size() == 0) {
			System.out.println("Erreur : Il doit y avoir au moins "
					+ "un infirmier d'ajouté dans la clinique.");
			System.out.println("");
			peuxCreerRendezVous = false;
		}

		if(clinique.getListePatient().size() == 0) {
			System.out.println("Erreur : Il doit y avoir au moins "
					+ "un patient d'ajouté dans la clinique.");
			System.out.println("");
			peuxCreerRendezVous = false;
		}

		return peuxCreerRendezVous;
	}

	/**
	 * Recherche un docteur en comparant l'identification entrée par 
	 * l'utilisateur avec l'identification de tous les docteurs de la clinique.
	 * @return Docteur correspondant à l'identification entrée, null 
	 * si aucun Docteur retrouvé.
	 */
	private static Docteur choisirDocteur() {

		clinique.afficherDocteurs();
		Docteur docteurChoisi = null;
		Identification identification = creerIdentification
				(clavier, "du docteur");

		for (Docteur docteur : clinique.getListeDocteur()) {

			if(docteur.getIdentification().equals(identification)) {
				docteurChoisi = docteur;
			}
		}

		return docteurChoisi;
	}

	/**
	 * Recherche un infirmier en comparant l'identification entrée par 
	 * l'utilisateur avec l'identification de tous les infirmiers de la clinique.
	 * @return Infirmier correspondant à l'identification entrée, null si aucun 
	 * infirmier retrouvé.
	 */
	private static Infirmier choisirInfirmier() {

		clinique.afficherInfirmiers();
		Infirmier infirmierChoisi = null;
		Identification identification = creerIdentification(clavier, 
				"de l'infirmier");

		for (Infirmier infirmier : clinique.getListeInfirmiers()) {

			if(infirmier.getIdentification().equals(identification)) {
				infirmierChoisi = infirmier;
			}
		}

		return infirmierChoisi;
	}

	/**
	 * Recherche un infirmier en comparant l'identification entrée par 
	 * l'utilisateur avec l'identification de tous les infirmiers de la clinique.
	 * @return Infirmier correspondant à l'identification entrée, null 
	 * si aucun infirmier retrouvé.
	 */
	private static Patient choisirPatient() {

		clinique.afficherPatients();
		Patient patientChoisi = null;
		Identification identification = creerIdentification(clavier, 
				"du patient");

		for (Patient patient : clinique.getListePatient()) {

			if(patient.getIdentification().equals(identification)) {
				patientChoisi = patient;
			}
		}

		return patientChoisi;
	}
	
	/**
	 * Créé une date à partir de l'entrée au clavier de l'administrateur.
	 * @return Date formée par l'entrée de l'administrateur, null si impossible de convertir en date valide.
	 */
	private static Date choisirDate() {
		
		String ligne = clavier.nextLine();
		String[] tabDate = ligne.split("-");
		
		if(tabDate.length != 3) {
			System.out.println("Erreur : Veuillez entrer la date sous le format suivant : AAAA-mm-JJ");
			return null;
		}
		
		try {
			
			/* Nous essayons de construir une date avec l'entrée de l'administrateur. Si le format
			 * est bon mais il est impossible de convertir en date valide, en avertir l'administrateur */
			int année = Integer.parseInt(tabDate[0]); 
			int mois = Integer.parseInt(tabDate[1]) - 1; // Nous faisons -1 car l'intervalle est de 0-11 
			int jour = Integer.parseInt(tabDate[2]);
			
			Calendar calendrier = Calendar.getInstance();
			Date dateAjd = calendrier.getTime();
			calendrier.setLenient(false); // Nécéssaire pour valider les dates (ex: les mois sans 31)
			
			calendrier.set(année, mois, jour);
			Date dateRdv = calendrier.getTime();
			
			/* Il faut empêcher l'administrateur de créer un rdv dans le passé. */
			if(dateRdv.before(dateAjd)) {
				System.out.println("Erreur : Impossible de créer un rendez-vous dans le passé.");
				return null;
			}
			
			return dateRdv;
			
		} catch(Exception e) {
			System.out.println("Erreur : Impossible de convertir en date valide.");
			return null;
		}
	}
	
	/**
	 * Définie l'heure pour une date passée en paramètre selon l'entrée saisie par l'administrateur.
	 * @param date Date où l'on veut choisir l'heure.
	 * @return Vrai si une heure valide a put être affectée à la date, faux sinon.
	 */
	@SuppressWarnings("deprecation")
	private static boolean choisirHeure(Date date) {
		
		String ligne = clavier.nextLine();
		String[] tabHeure = ligne.split(":");
		
		if(tabHeure.length != 2) {
			System.out.println("Erreur : Veuillez entrer l'heure sout le format suivant : HH:mm");
			return false;
		}
		
		try {
			
			int heure = Integer.parseInt(tabHeure[0]);
			int minutes = Integer.parseInt(tabHeure[1]);
			
			if(heure < 0 || heure > 23 || minutes < 0 || minutes > 59) {
				throw new Exception();
			}
			
			date.setHours(heure);
			date.setMinutes(minutes);
			
		} catch(Exception e) {
			System.out.println("Erreur : Impossible de convertir en heure valide.");
			return false;
		}
		return true;
	}
}
