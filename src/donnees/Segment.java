package donnees;

public class Segment {
	private Point pointA;
	private Point pointB;
	
	public Segment(Point A, Point B) {
		this.pointA = A;
		this.pointB = B;
	}
	
	public String toString() {
		return "{"+ this.pointA.toString() + "\n" + this.pointB.toString()+"}";
	}
}
