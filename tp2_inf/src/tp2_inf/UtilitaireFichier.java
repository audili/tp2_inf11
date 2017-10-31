package tp2_inf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import clinique.Clinique;

public abstract class UtilitaireFichier {
	
	private String fileName = "clinique.bin";

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
