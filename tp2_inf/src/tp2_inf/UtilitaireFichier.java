package tp2_inf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import clinique.Clinique;

/**
 * Auteurs: Alec Durocher, Ali Joudad et Ayoub Moudrika
 * 
 * Cette classe abstraite permet de sauvegarder une instance de Clinique, qui contient les listes de docteurs, 
 * d'infirmiers et de patients ainsi qu'un calendrier des rendezVous. Cette sauvegarde se fait dans un fichier 
 * BIN nomm� "clinique.bin".
 *
 * STRAT�GIE:
 * D�-s�rializer une instance de la classe Clinique pour permettre d'utiliser les donn�es sauvegard�es dans l'instance.
 * S�rializer une instance de la classe Clinique pour sauvegarder les donn�es enregistr�es par l'administrateur
 */
public abstract class UtilitaireFichier {

	
	private static String fileName = "clinique.bin"; //Nom du fichier � sauvegarder

	/**
	 * Cette m�thode permet de d�-s�rialiser l'instance de Clinique
	 * pr�alablement sauvegard�e.
	 * 
	 * @return une clinique
	 */
	public static Clinique getCliniqueSauvegardee() {
		
		FileInputStream fichierClinique = null;
        ObjectInputStream objetFichierClinique = null;
        
        /* Tentative de r�cup�ration du fichier et d�-s�rialization en object Clinique */
        try {
        	fichierClinique = new FileInputStream("fileName");
        	objetFichierClinique = new ObjectInputStream(fichierClinique);
        	
        	Clinique clinique = (Clinique)objetFichierClinique.readObject();
        	objetFichierClinique.close();
        	
        	return clinique;
        	
        } catch (Exception e) {
        	
        	/* Au cas ou le fichier n'est pas existant ou bien la d�s�rialization en object Clinique
        	 * est impossible, nous devons retourner un null. */
        	return null;
        }		
	}
	
	/**
	 * S�rialize une instance de Clinique dans un fichier binaire.
	 * @param clinique � sauvegarder
	 */
	public static void sauvegardeClinique(Clinique clinique) {
		
		try {
			
			FileOutputStream fichierDestination = new FileOutputStream(fileName);
			ObjectOutputStream  objectFichierDestination = new ObjectOutputStream (fichierDestination);
			
			objectFichierDestination.writeObject(clinique);
			objectFichierDestination.close();
			
			fichierDestination.close();
			
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}
}
