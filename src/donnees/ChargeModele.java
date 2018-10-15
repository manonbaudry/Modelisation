package donnees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Class permettant de charger le modele .ply
 * 
 * @author prunierf
 *
 */
public class ChargeModele {

	/**
	 * Charge le modele avec le fichier
	 * 
	 * @param m - Modele
	 * @param f - file
	 */
	public static void chargeModele(Modele m, File f) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			String element;
			boolean header = true;
			int nbVertex = 0;
			int nbFaces = 0;
			while ((line = br.readLine()) != null) {
				if (header) {
					if (line.equals("end_header")) {
						header = false;
					}
					if (line.contains(new StringBuffer("element"))) {
						Scanner sc = new Scanner(line);
						sc.useDelimiter(" ");
						sc.next();
						element = sc.next();
						if (element.equals("vertex")) {
							nbVertex = Integer.parseInt(sc.next());
						}else {
							nbFaces = Integer.parseInt(sc.next());
						}
						sc.close();
					}
				}else {
					if (nbVertex != 0) {
						Scanner sc = new Scanner(line);
						sc.useDelimiter(" ");
						m.getPoints().add(new Point(Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next())));
						nbVertex--;
					}else if(nbFaces != 0){
						Scanner sc = new Scanner(line);
						sc.useDelimiter(" ");
						sc.next();
						int point1 = Integer.parseInt(sc.next());
						int point2 = Integer.parseInt(sc.next());
						int point3 = Integer.parseInt(sc.next());
						Segment s1 = new Segment(m.getPoints().get(point1), m.getPoints().get(point2));
						Segment s2 = new Segment(m.getPoints().get(point2), m.getPoints().get(point3));
						Segment s3 = new Segment(m.getPoints().get(point3), m.getPoints().get(point1));
						m.getSegments().add(s1);	
						m.getSegments().add(s2);
						m.getSegments().add(s3);
						
						m.getFaces().add(new Face(s1, s2, s3));
						nbFaces--;
					}
				}
			}
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}	

}
