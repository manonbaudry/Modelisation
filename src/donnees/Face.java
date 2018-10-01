/**
 * 
 */
package donnees;

/**
 * @author ?
 * groupe O3
 *
 */
public class Face {
	
	private Segment s1;
	private Segment s2;
	private Segment s3;
	
	/**
	 * @param s1
	 * @param s2
	 * @param s3
	 *  création d'une face à partir de 3 segments
	 */
	public Face(Segment s1, Segment s2, Segment s3) {
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}

	/**
	 * @return the s1
	 */
	public Segment getS1() {
		return s1;
	}

	/**
	 * @return the s2
	 */
	public Segment getS2() {
		return s2;
	}

	/**
	 * @return the s3
	 */
	public Segment getS3() {
		return s3;
	}
	
	public double[] xPoints() {
		return new double[] {s1.getPointA().getX(), s2.getPointA().getX(), s3.getPointA().getX()};
	}
	
	public double[] yPoints() {
		return new double[] {s1.getPointA().getY(), s2.getPointA().getY(), s3.getPointA().getY()};
	}
}