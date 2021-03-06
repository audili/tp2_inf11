package tp2_inf;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.InputMap;

import clinique.*;
import intervenants.*;
import intervenants.Docteur.enuDepartements;

/**
 * 
 * Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 *
 * Ce logiciel g�re le calendrier des docteurs et infirmiers d'une clinique. 
 * Il g�re aussi le calendrier des clients, c'est-�-dire les patients et leurs 
 * rendez-vous.
 */

public class Main {

	private static Clinique clinique;
	private static Scanner clavier;

	public static void main(String[] args) {

		Clinique cliniqueSauvegardee = UtilitaireFichier
				.getCliniqueSauvegardee();

		if(cliniqueSauvegardee == null) {
			clinique = new Clinique();
		} else {
			clinique = cliniqueSauvegardee;
		}

		//D�claration de la lecture du clavier
		clavier = new Scanner(System.in);

		int choix = 0; //choix de l'administrateur � la console

		/* L'administrateur aura le choix entre 14 options d�crites ci-dessous. 
		 * Les options sont r�affich�es si l'administrateur 
		 * presse une option qui n'est pas entre 1 et 14.
		 * On r�affiche le menu tant que l'administrateur n'a pas choisi 
		 *l'option de quitter (14).
		 */
		while (choix != 14) {

			do{

				// Affichage du menu principal
				System.out.println
				("Bienvenue � la clinique, que voulez-vous faire ?\n"
						+ "1) Ajouter un docteur \n"
						+ "2) Ajouter un infirmier \n"
						+ "3) Ajouter un patient \n"
						+ "4) Ajouter un rendez-vous \n"
						+ "5) Trouver un rendez-vous pour un patient \n"
						+ "6) Afficher le prochain rendez-vous d'un docteur \n"
						+ "7) Afficher le prochain rendez-vous d'un infirmier \n"
						+ "8) Afficher le prochain rendez-vous d'un patient \n"
						+ "9) Passer � la prochaine plage horaire \n"
						+ "10) Afficher le calendrier complet \n"
						+ "11) Afficher le calendrier complet d'un docteur \n"
						+ "12) Afficher le calendrier complet d'un infirmier \n"
						+ "13) Annuler un rendez-vous \n"
						+ "14) Quitter \n ");

				/* Saisie de clavier de l'administrateur. 
				Nous devons v�rifier que l'administrateur entre un 
				chiffre valide. */
				if(clavier.hasNextInt()) {
					choix = clavier.nextInt();
				}
				else {

					/* S'il est impossible d'interpr�ter l'entr�e de 
					 * l'administrateur en integer, nous devons consommer 
					 * la prochaine ligne du Scanner pour emp�cher 
					 * la boucle infinie. */
					clavier.nextLine();
					choix = 0;
				}

				/* Si l'entr�e de l'utilisateur �tait invalide 
				 * (pas un nombre) ou que le nombre inscrit n'est pas entre
				 *  1 et 14, avertir l'administrateur de son erreur. */
				if(choix < 1 || choix > 14) {
					System.out.println("Erreur : Veuillez saisir un nombre "
							+ "correspondant aux options num�rot�es. "
							+ "Retour au menu principal.");
				}

				/*Ce code fait un appel de m�thode selon le choix de 
				 * fonctionnalit� de l'administrateur.*/
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
					trouverRendezVous();
					break;

				case 6:
					afficherProchainRDVDocteur();
					break;

				case 7:
					afficherProchainRDVInfirmier();
					break;

				case 8:
					afficherProchainRDVPatient();
					break;

				case 9:
					System.out.println(afficherRdvProchainePlageHoraire
							(clinique.
									getCalendrier()));
					break;
				case 10:
					System.out.println(afficherCalendrierComplet
							(clinique.getCalendrier() ));

					break;

				case 11:
					System.out.println(afficherCalendrierDocteur(clinique.
							getCalendrier()));
					break;

				case 12:
					System.out.println(afficherCalendrierInfirmier
							(clinique.getCalendrier()));
					break;	

				case 13:
					annulerRendezvous(clinique.getCalendrier());

					break;

				case 14:
					UtilitaireFichier.sauvegardeClinique(clinique);
					System.exit(0);
					break;
				}
			} while (true);			
		}
	}

	/**
	 * M�thode qui affiche le prochain RDV d'un docteur qu'on choisi
	 */
	public static void afficherProchainRDVDocteur() {

		Docteur docteur = choisirDocteur();

		Calendrier calendrierDocteur = clinique.getCalendrier()
				.obtenirCalendrierDocteur(docteur);

		if(calendrierDocteur.getFilePlageHoraire().estVide()) {
			System.out.println(docteur + " n'a aucun rendez-vous � son horaire."
					+ "");
			return;
		}

		PlageHoraire plageHoraire = new PlageHoraire(new Date());

		RendezVous rdv = calendrierDocteur.obtenirProchainRendezVousDocteur
				(docteur,plageHoraire);

		System.out.println(rdv);
	}


	/**
	 * M�thode qui affiche le prochain RDV d'un infirmier qu'on choisi
	 */
	public static void afficherProchainRDVInfirmier() {

		Infirmier infirmier = choisirInfirmier();

		Calendrier calendrierInfirmier = clinique.getCalendrier()
				.obtenirCalendrierInfirmier(infirmier);

		if(calendrierInfirmier.getFilePlageHoraire().estVide()) {

			System.out.println(infirmier + " n'a aucun rendez-vous � son "
					+ "horaire.");
			return;
		}

		PlageHoraire plageHoraire = new PlageHoraire(new Date());

		RendezVous rdv = calendrierInfirmier.obtenirProchainRendezVousInfirmier
				(infirmier,plageHoraire);

		System.out.println(rdv);

	}

	/**
	 * M�thode qui affiche le prochain RDV d'un patient qu'on choisi
	 */
	public static void afficherProchainRDVPatient() {

		Patient patient = choisirPatient();

		Calendrier calendrierPatient = clinique.getCalendrier()
				.obtenirCalendrierPatient(patient);

		if(calendrierPatient.getFilePlageHoraire().estVide()) {

			System.out.println(patient + " n'a aucun rendez-vous � son "
					+ "horaire.");
			return;
		}

		PlageHoraire plageHoraire = new PlageHoraire(new Date());

		RendezVous rdv = calendrierPatient.obtenirProchainRendezVousPatient
				(patient,plageHoraire);

		System.out.println(rdv);

	}

	/**
	 * Ajoute un docteur dans la clinique depuis les donn�es saisies par 
	 * l'administrateur
	 */
	public static void ajouterDocteur() {

		Identification identification = creerIdentification(clavier, 
				"du docteur.");
		enuDepartements departement = null;

		while(departement == null) {

			System.out.println("Pour quel d�partement ce docteur travaille-t-il"
					+ " ? " + Arrays.toString(getTableauNomsDeDepartements()));

			/* Nous s�parons la ligne �crite par l'utilisateur par espaces et 
			 * prenons le premier mot que nous mettons en majuscule. */
			String nomDepartement =  clavier.nextLine()
					.split(" ")[0].toUpperCase();

			try {
				/* Nous essayons de r�cup�r�r un d�partement depuis le 
				 * nomDepartement entr� par l'utilisateur */
				departement = enuDepartements.valueOf(nomDepartement);

			} catch (IllegalArgumentException e) {
				/* Si aucune valeur n'a �t� retrouv�e dans l'�num�ration de 
				 * d�partements, laisser departement a null */
			}
		}

		Docteur docteur = new Docteur(identification, departement); 
		clinique.ajouterDocteur(docteur);
		System.out.println(docteur + " a �t� ajout�(e).");
	}

	/**
	 * Ajoute un infirmier dans la clinique depuis les donn�es saisies par 
	 * l'administrateur
	 */
	public static void ajouterInfirmier() {

		Identification identification = creerIdentification(clavier, 
				"de l'infirmier.");
		Infirmier infirmier = new Infirmier(identification,true);

		clinique.ajouterInfirmier(infirmier);
		System.out.println(infirmier + " a �t� ajout�(e).");
	}

	/**
	 * Ajoute un patient dans la clinique depuis les donn�es saisies par 
	 * l'administrateur
	 */
	public static void ajouterPatient() {

		Identification identification = creerIdentification(clavier, 
				"du patient.");
		String numeroAssuranceSociale = null;

		while(!estUnNASValide(numeroAssuranceSociale)) {
			System.out.println("Veuillez entrer le num�ro d'assurance sociale "
					+ "du patient (sans tirets et sans espaces).");
			numeroAssuranceSociale = clavier.nextLine().split(" ")[0];
		}

		Patient patient = new Patient(identification, numeroAssuranceSociale);
		clinique.ajouterPatient(patient);
		System.out.println(patient + " a �t� ajout�(e).");
	}

	/**
	 * Cr�� un rendez-vous en demandant � l'administrateur de choisir un docteur, 
	 * un infirmier, un patient et une PlageHoraire.
	 */
	public static void ajouterRendezVous() {

		if(!peuxCreerRendezVous()) {
			return;
		}

		System.out.println("Pour cr�er un rendez-vous, il vous faut choisir "
				+ "un docteur, un infirmier disponible, "
				+ "un patient, une date et une heure.");

		System.out.println("");

		System.out.println("1) Choisisez un docteur.");
		Docteur docteurChoisi = null;

		while(docteurChoisi == null) {
			docteurChoisi = choisirDocteur();
		}

		System.out.println("2) Choisisez un infirmier.");
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

		RendezVous rendezVous = new RendezVous(patientChoisi, docteurChoisi, 
				infirmierChoisi);

		clinique.getCalendrier().ajouterRendezvous(dateRdv, rendezVous);
	}

	/**
	 * Cr�� un rendez-vous pour un patient choisi par l'administrateur. Il
	 * doit aussi choisir une PlageHoraire pour le rendez-vous. Nous informons
	 * l'administrateur si le patient a d�j� un rendez-vous ou si il n'y a pas
	 * de personnel disponible pour cette PlageHoraire.
	 */
	public static void trouverRendezVous() {

		if(!peuxCreerRendezVous()) {
			return;
		}

		Patient patientChoisi = null;

		while(patientChoisi == null) {
			patientChoisi = choisirPatient();
		}

		System.out.println("Choisisez la date du rendez-vous (AAAA-mm-jj).");
		Date dateRdv = null;

		while(dateRdv == null) {
			dateRdv = choisirDate();
		}

		System.out.println("Choisisez l'heure du rendez-vous (HH:mm).");
		boolean heureEstValide = false;

		while(!heureEstValide) {
			heureEstValide = choisirHeure(dateRdv);
		}

		PlageHoraire plageHoraire = new PlageHoraire(dateRdv);
		RendezVous rdv = clinique.getCalendrier().
				obtenirProchainRendezVousPatient(patientChoisi, plageHoraire);

		/* Si le client a d�j� un rendez-vous pour cette plage horaire, 
		 * retour au menu principal */
		if(rdv != null) {
			System.out.println("Erreur : Impossible de cr�er le rendez-vous car"
					+ patientChoisi + " a d�j� un rendez-vous le "
					+ plageHoraire);
		}

		/* Si le patient n'en a pas, en cr�er un en trouvant un docteur et
		 * un infirmier disponible. */
		Docteur docteurChoisi = obtenirDocteurDisponible(plageHoraire);
		Infirmier infirmierChois = obtenirInfirmierDisponible(plageHoraire);

		if(docteurChoisi != null && infirmierChois != null) {

			rdv = new RendezVous(patientChoisi, docteurChoisi, infirmierChois);
			clinique.getCalendrier().ajouterRendezvous(dateRdv, rdv);
			System.out.println(rdv + " cr��.");
		}
	}


	/**
	 * Quitte l'application et sauvegarde la clinique sous un fichier binaire.
	 */
	public static void quitter() {

		System.out.println("�tes-vous s�r de vouloir quitter ?");
		System.out.println("Oui/Non");

		String ligne;
		boolean estValide = false;

		while (!estValide) {
			ligne = clavier.next().toLowerCase();

			if(ligne.equals("oui")) {
				UtilitaireFichier.sauvegardeClinique(clinique);
				System.exit(0);
			}
			if(ligne.equals("non")) {
				return;
			}
		}
	}
	/**
	 *  Affiche le calendrier de la prochaine plage horaire de la clinique.
	 * @param calendrier
	 * @return
	 */
	public static String afficherRdvProchainePlageHoraire(Calendrier calendrier){
		Maillon maillon = calendrier.getFilePlageHoraire().getTete().
				getProchain();
		String rdv = null;
		if (calendrier.getFilePlageHoraire().getTete().getProchain()!=null){		
			for(int i=0; i<calendrier.getFilePlageHoraire().getTete().
					getProchain().getPlageHoraire().getRendezVous().size();i++){


				rdv =   maillon.getPlageHoraire().getRendezVous()
						.get(i).toString();
			}
		}else {
			rdv= "PlageHoraireInexistante";
			System.out.println(rdv);

		}
		return  rdv; 
	}
	/**
	 *  Affiche tout le calendrier
	 * @param calendrier
	 * @return
	 */
	public static  String  afficherCalendrierComplet(Calendrier calendrier ){
		Maillon maillon = calendrier.getFilePlageHoraire().getTete();
		String afficher =calendrier.toString();

		for (int i=0; i<maillon.getPlageHoraire().getRendezVous().size(); i++){


			if ( !(calendrier.getFilePlageHoraire().estVide())) {

				maillon.getPlageHoraire().getRendezVous().get(i);


			}	
		}
		maillon =  maillon.getProchain();
		if (maillon !=null) {
			for (int i=0; i<maillon.getPlageHoraire().getRendezVous().size(); i++){


				if ( !(calendrier.getFilePlageHoraire().estVide())) {

					maillon.getPlageHoraire().getRendezVous().get(i);


				}	
			}
		}
		return afficher ;
	}
	/**
	 *  Affiche le calendrier d'un docteur qu'on a choisi
	 * @param calendrier
	 * @return
	 */
	public static String afficherCalendrierDocteur(Calendrier calendrier){

		Docteur docteur = choisirDocteur();
		calendrier = calendrier.obtenirCalendrierDocteur(docteur);

		return calendrier.toString() ; 

	}
	/**
	 *  Affiche le calendrier d'un infirmier qu'on a choisi
	 * @param calendrier
	 * @return
	 */
	public static String afficherCalendrierInfirmier(Calendrier calendrier){

		Infirmier infirmier = choisirInfirmier();
		calendrier = calendrier.obtenirCalendrierInfirmier(infirmier); 
		return calendrier.toString() ; 

	}
	/** M�thode qui annule un RDV qu'on choisi
	 * 
	 * @param calendrier
	 */
	public static  void annulerRendezvous(Calendrier calendrier){

		RendezVous rdv =null; 


		for (int i=0; i<calendrier.getFilePlageHoraire().getTete().
				getPlageHoraire().getRendezVous().size();i++){

			if (calendrier.getFilePlageHoraire().getTete().getPlageHoraire()
					.getRendezVous().get(0).equals(rdv)){

				calendrier.annulerRendezVous(rdv, calendrier.getFilePlageHoraire
						().getTete().getPlageHoraire());
			}
		}
		System.out.println("Rendez vous annul�  ");
	}




	/* ---------------------M�thodes priv�es-------------------------------- */

	/**
	 * R�cup�re tous les noms de d�partements possibles
	 * @return Tableau contenant les noms de d�partements en majuscule.
	 */
	private static String[] getTableauNomsDeDepartements() {

		int nbDepartements = enuDepartements.values().length;
		String[] nomsDepartements = new String[nbDepartements];

		for(int i =0; i < nbDepartements; i ++) {
			nomsDepartements[i] = enuDepartements.values()[i]
					.name().toUpperCase();
		}
		return nomsDepartements;
	}

	/**
	 * Cr�er une identification selon les donn�es saisies par un Scanner.
	 * @param clavier Scanner permettant d'utiliser les entr�es de l'utilisateur
	 * @param suffixeIntervenant Suffixe qui indiquera � l'utilisateur quel 
	 * type d'intervenant il est en train de cr�er
	 * @return
	 */
	private static Identification creerIdentification(Scanner clavier, 
			String suffixeIntervenant) {

		String messageUtilisateurIdentification = "Veuillez entrer le nom et "
				+ "pr�nom " + suffixeIntervenant;

		/* Nous prenons la prochaine ligne �crite par l'utilisateur et la 
		 * division avec les espaces pour en faire un tableau de mots.*/
		String[] tabNomPrenom = clavier.nextLine().split(" ");

		while(tabNomPrenom.length != 2) {

			System.out.println(messageUtilisateurIdentification);
			tabNomPrenom = clavier.nextLine().split(" ");
		}
		return new Identification(tabNomPrenom[0],tabNomPrenom[1]);
	}

	/**
	 * D�termine si une String est un num�ro d'assurance sociale (NAS) valide.
	 * @param numeroAssuranceSociale String � v�rifier
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
	 * D�termine si l'utilisateur peux cr�er un rendez-vous et affiche pour 
	 * quelles sont les conditions manquantes s'il y a lieu.
	 * @return Vrai si la clinique contient un nombre minimum d'intervenants 
	 * recquis, faux sinon.
	 */
	private static boolean peuxCreerRendezVous() {

		boolean peuxCreerRendezVous = true;

		if(clinique.getListeDocteur().size() == 0) {
			System.out.println("Erreur : Il doit y avoir au moins "
					+ "un docteur d'ajout� dans la clinique.");
			System.out.println("");
			peuxCreerRendezVous = false;
		}

		if(clinique.getListeInfirmiers().size() == 0) {
			System.out.println("Erreur : Il doit y avoir au moins "
					+ "un infirmier d'ajout� dans la clinique.");
			System.out.println("");
			peuxCreerRendezVous = false;
		}

		if(clinique.getListePatient().size() == 0) {
			System.out.println("Erreur : Il doit y avoir au moins "
					+ "un patient d'ajout� dans la clinique.");
			System.out.println("");
			peuxCreerRendezVous = false;
		}

		return peuxCreerRendezVous;
	}

	/**
	 * Recherche un docteur en comparant l'identification entr�e par 
	 * l'utilisateur avec l'identification de tous les docteurs de la clinique.
	 * @return Docteur correspondant � l'identification entr�e, null 
	 * si aucun Docteur retrouv�.
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
	 * Recherche un infirmier en comparant l'identification entr�e par 
	 * l'utilisateur avec l'identification de tous les infirmiers de la clinique.
	 * @return Infirmier correspondant � l'identification entr�e, null si aucun 
	 * infirmier retrouv�.
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
	 * Recherche un infirmier en comparant l'identification entr�e par 
	 * l'utilisateur avec les identifications des infirmiers de la clinique.
	 * @return Infirmier correspondant � l'identification entr�e, null 
	 * si aucun infirmier retrouv�.
	 */
	private static Patient choisirPatient() {

		clinique.afficherPatients();
		Patient patientChoisi = null;
		Identification identification = creerIdentification(clavier, 
				"du patient");

		for (Patient patient : clinique.getListePatient()) {

			if(patient.getIdentification().equals(identification)) {
				patientChoisi = patient;
				break;
			}
		}

		return patientChoisi;
	}

	/**
	 * Cr�� une date � partir de l'entr�e au clavier de l'administrateur.
	 * @return Date form�e par l'entr�e de l'administrateur, null si impossible
	 * de convertir en date valide.
	 */
	private static Date choisirDate() {

		String ligne = clavier.nextLine();
		String[] tabDate = ligne.split("-");

		if(tabDate.length != 3) {
			System.out.println("Erreur : Veuillez entrer la date sous le format"
					+ " suivant : AAAA-mm-JJ");
			return null;
		}

		try {

			/* Nous essayons de construir une date avec l'entr�e de 
			 * l'administrateur. Si le format est bon mais il est impossible de
			 *  convertir en date valide, en avertir l'administrateur */
			int ann�e = Integer.parseInt(tabDate[0]);

			// Nous devons faire -1 car l'intervalle est de 0-11 
			int mois = Integer.parseInt(tabDate[1]) - 1;
			int jour = Integer.parseInt(tabDate[2]);

			Calendar calendrier = Calendar.getInstance();
			Date dateAjd = calendrier.getTime();

			// Ligne n�c�ssaire pour valider les dates (ex: les mois sans 31)
			calendrier.setLenient(false); 

			calendrier.set(ann�e, mois, jour);
			Date dateRdv = calendrier.getTime();

			// Il faut emp�cher l'administrateur de cr�er un rdv dans le pass�.
			if(dateRdv.before(dateAjd)) {
				System.out.println("Erreur : Impossible de cr�er un rendez-vous"
						+ " dans le pass�.");
				return null;
			}

			return dateRdv;

		} catch(Exception e) {
			System.out.println("Erreur : Impossible de convertir "
					+ "en date valide.");
			return null;
		}
	}

	/**
	 * D�finie l'heure pour une date pass�e en param�tre selon l'entr�e saisie 
	 * par l'administrateur.
	 * @param date Date o� l'on veut choisir l'heure.
	 * @return Vrai si une heure valide a put �tre affect�e � la date, 
	 * faux sinon.
	 */
	@SuppressWarnings("deprecation")
	private static boolean choisirHeure(Date date) {

		String ligne = clavier.nextLine();
		String[] tabHeure = ligne.split(":");

		if(tabHeure.length != 2) {
			System.out.println("Erreur : Veuillez entrer l'heure sous le "
					+ "format suivant : HH:mm");
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
			System.out.println("Erreur : Impossible de convertir en "
					+ "heure valide.");
			return false;
		}

		return heureEstValide(date);
	}

	/**
	 * Obtient le premier docteur disponible pendant la PlageHoraire.
	 * @param plageHoraire PlageHoraire � v�rifier
	 * @return Premier Docteur disponible, null si aucun docteur disponible.
	 */
	private static Docteur obtenirDocteurDisponible(PlageHoraire plageHoraire) {

		LinkedList<Docteur> docteursDisponibles = 
				clinique.getListeDocteur();

		if(plageHoraire.getRendezVous().isEmpty()) {

			return docteursDisponibles.getFirst();
		}
		else {

			for (RendezVous rendezVous : plageHoraire.getRendezVous()) {
				docteursDisponibles.remove(rendezVous.getDocteur());
			}

			if(docteursDisponibles.isEmpty()) {
				System.out.println("Erreur : Aucun docteur n'est disponible"
						+ " pour le " + plageHoraire);
				return null;
			}
			else {
				return docteursDisponibles.getFirst();
			}
		}
	}

	/**
	 * Obtient le premier Infirmier disponible pendant la PlageHoraire.
	 * @param plageHoraire PlageHoraire � v�rifier
	 * @return Premier Infirmier disponible, null si aucun infirmier disponible.
	 */
	private static Infirmier obtenirInfirmierDisponible(PlageHoraire 
			plageHoraire) {

		LinkedList<Infirmier> infirmiersDisponibles = 
				clinique.getListeInfirmiers();

		if(plageHoraire.getRendezVous().isEmpty()) {

			return infirmiersDisponibles.getFirst();
		}
		else {
			for (RendezVous rendezVous : plageHoraire.getRendezVous()) {
				infirmiersDisponibles.remove(rendezVous.getInfirmier());
			}

			if(infirmiersDisponibles.isEmpty()) {
				System.out.println("Erreur : Aucun infirmier n'est disponible "
						+ "pour le " + plageHoraire);
				return null;
			}
			else {
				return infirmiersDisponibles.getFirst();
			}
		}
	}
	
	/**
	 * M�thode v�rificatrice si l'heure entr�e est valide (Intervallle 
	 * de 15 minutes et entre 8h00 et 20h).
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private static boolean heureEstValide(Date date) {

		int minutes = date.getMinutes() ; 
		if ((date.getHours() > 8 && date.getHours() < 20) && 
				(minutes == 0 || minutes == 15 || minutes == 30 
				|| minutes == 45) ){
			return true;
		}

		System.out.println("Erreur : L'heure doit �tre comprise entre 8h00 "
				+ "et 20h00, sur des intervalles de 15 minutes.");
		return false ;
	}
}
