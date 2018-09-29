package donnees;

public class Point {
	
	private double x;
	private double y;
	private double z;
	
	/**
	 * Constructeur 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point (double x ,double y ,double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	/**
	 * Methode toString()
	 */
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	/**
	 * 
	 * @return l'indice x.
	 */
	public double getX() {
		return x;
	}

	/**
	 * permet de changer la valeur de x.
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return l'indice y.
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * permet de changer la valeur de y.
	 * @param y
	 */

	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * 
	 * @return l'indice de z.
	 */

	public double getZ() {
		return z;
	}

	/**
	 * permet de changer la valeur de z.
	 * @param z
	 */
	public void setZ(int z) {
		this.z = z;
	}
}
