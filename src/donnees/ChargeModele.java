package donnees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ChargeModele {

	public static void chargeModele(Modele m, File f) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			int nbVertex;
			while ((line = br.readLine()) != null) {
				
			}
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

}
