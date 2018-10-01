package donnees;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	public double getBarycentre (Face face) { 
		return (face.getS1().getPointA().getZ()+face.getS2().getPointB().getZ()+face.getS3().getPointB().getZ()/3);
	}
	
	
	public void triFaces (ArrayList<Face> faces) {
		Face stock1 = faces.get(0);
		Face stock2;
		Face tmp;
		Iterator <Face> i = faces.iterator();
		while (i.hasNext()) {
			stock2 = i.next();
			if (getBarycentre(stock2) < getBarycentre(stock1)){
				tmp = stock1;
				faces.set(faces.indexOf(stock1), stock2);
				faces.set(faces.indexOf(stock2), tmp);
				stock1 = stock2;
			}
		}
		/*for (int i = 1; i < faces.size(); i ++) {
			for (int j = 0; j < faces.size()-1; j++) {
				if (getBarycentre(faces.get(i)) > getBarycentre(faces.get(j))){
					stock = faces.get(j);
					faces.add(j, faces.get(i));
					faces.add(i, stock);
				}
			}
		}*/
		
	}
	
}
