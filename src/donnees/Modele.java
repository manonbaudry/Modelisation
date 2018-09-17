package donnees;

import java.util.ArrayList;

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
	
}
