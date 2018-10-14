package donnees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Modele {

	private ArrayList<Point> points;
	private ArrayList<Segment> segments;
	private ArrayList<Face> faces;
	
	public Modele() {
		points = new ArrayList<Point>();
		segments = new ArrayList<Segment>();
		faces = new ArrayList<Face>();
	}
	
	public ArrayList<Face> getFaces() {
		return faces;
	}
	
	public ArrayList<Point> getPoints() {
		return points;
	}
	
	public ArrayList<Segment> getSegments() {
		return segments;
	}
	
	public void setFaces(ArrayList<Face> faces) {
		this.faces = faces;
	}
	
	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}
	
	public void setSegments(ArrayList<Segment> segments) {
		this.segments = segments;
	}
	
	/**
	 * 
	 * @param face
	 * @return Retourne la valeur Z du barycentre d'une face
	 */
	public double getBarycentre (Face face) { 
		//return (face.getS1().getPointA().getZ()+face.getS2().getPointB().getZ()+face.getS3().getPointB().getZ()/3);
		Segment s1 = face.getS1(); 
		Segment s2 = face.getS2();
		Point p1s1 = s1.getPointA();
		Point p2s1 = s1.getPointB();
		Point p2s2 = s2.getPointB();
		double sommeX = (p1s1.getX()+p2s2.getX()+p2s1.getX()/3);
		double sommeY = (p1s1.getY()+p2s2.getY()+p2s1.getY()/3);
		double sommeZ = (p1s1.getZ()+p2s2.getZ()+p2s1.getZ()/3);
		Point barycentre = new Point (sommeX, sommeY, sommeZ);
		return barycentre.getZ();
	}
	
	
	/**
	 * Classe permettant l'utilisation de la methode Collections.sort()
	 * @author FievetF
	 *
	 */
	class SortByBarycentre implements Comparator <Face>{

		@Override
		public int compare(Face o1, Face o2) {
			return Double.compare(getBarycentre(o1), getBarycentre(o2));
		}
		
	}
	
	/**
	 * Methode qui trie une ArrayList de faces
	 * @param faces
	 */
	public void triFaces (ArrayList<Face> faces) {
		Collections.sort(faces, new SortByBarycentre());
	}
	
}
