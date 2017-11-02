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
 * Cette classe abstraite permet de sauvegarder l'objet clinique, qui contient
 * les listes de docteurs, infirmiers et patients. Cette sauvegarde ce fait 
 * dans un fichier BIN.
 *
 *
 * STRAT�GIE:
 */
public abstract class UtilitaireFichier {

	
	private String fileName = "clinique.bin"; //Nom du fichier � sauvegarder

	/**
	 * Cette m�thode permet d'importer un fichier clinique.bin 
	 * pr�alablement sauvegard�e.
	 * 
	 * @return une clinique
	 */
	public Clinique getCliniqueSauvegardee() {
		
		FileInputStream fichierClinique = null;
        ObjectInputStream dataFichierClinique = null;
        try {
        	fichierClinique = new FileInputStream("fileName");
        	dataFichierClinique = new ObjectInputStream(fichierClinique);
        	Clinique clinique = (Clinique)dataFichierClinique.readObject();
        	dataFichierClinique.close();
        	return clinique;
        } catch (Exception e) {
        	return null;
        }		
	}
	
	/**
	 *  Inversement, cette m�thode permet de sauvegarder
	 * @param clinique
	 */
	public void sauvegardeClinique(Clinique clinique) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream  out = new ObjectOutputStream (fileOut);
			out.writeObject(clinique);
			out.close();
			fileOut.close();
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}
}
