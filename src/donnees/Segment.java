package donnees;

public class Segment {
	private Point pointA;
	private Point pointB;
	/**
	 * Classe qui definit un segment en fonction de deux points
	 * @param A le premier point
	 * @param B le deuxieme point
	 */
	public Segment(Point A, Point B) {
		this.pointA = A;
		this.pointB = B;
	}
	/**
	 * affiche les coordonnees des points du segment
	 */
	public String toString() {
		return "{"+ this.pointA.toString() + "\n" + this.pointB.toString()+"}";
	}
	/**
	 * recupere le premier point
	 * @return le premier point
	 */
	public Point getPointA() {
		return pointA;
	}
	/**
	 * definit le premier point
	 * @param pointA la point a definir
	 */
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	/**
	 * recupere le deuxieme point
	 * @return le deuxieme point
	 */
	public Point getPointB() {
		return pointB;
	}
	/**
	 * definit le deuxieme point
	 * @param pointB le deuxieme point a definir
	 */
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	
	
}
