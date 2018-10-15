package math;

import java.util.Arrays;

/**
 * Class creant des Matrice
 * 
 * @author prunierf
 *
 */
public class Matrice {

	double[][] mat;

	/**
	 * Cree une Matrice de hauteur x et de largeur 1 (vecteur)
	 * 
	 * @param x
	 *            - taille en hauteur
	 */
	public Matrice(int x) {
		this(x, 1);
	}

	/**
	 * Cree une Matrice de hauteur x et de largeur y
	 * 
	 * @param x
	 *            - taille en hauteur
	 * @param y
	 *            - taille en largeur
	 */
	public Matrice(int x, int y) {
		mat = new double[x][y];

	}

	/**
	 * Retourne la taille en hauteur de la matrice courante
	 * 
	 * @return taille
	 */
	public int getHeight() {
		return mat.length;
	}

	/**
	 * Retourne la taille en largeur de la matrice courante
	 * 
	 * @return taille
	 */
	public int getWidth() {
		return mat[0].length;
	}

	/**
	 * Retourne la coordonne (x, y) de la matrice
	 * 
	 * @param x
	 *            - coordonne en hauteur
	 * @param y
	 *            - coordonne en largeur
	 * @return coordonne
	 */
	public double getCoord(int x, int y) {
		return mat[x][y];
	}

	/**
	 * Remplace la coordonne (x, y) de la matrice
	 * 
	 * @param coord
	 *            - nouvelle valeur
	 * @param x
	 *            - coordonne en hauteur
	 * @param y
	 *            - coordonne en largeur
	 */
	public void setCoord(double coord, int x, int y) {
		mat[x][y] = coord;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrice other = (Matrice) obj;
		if (!Arrays.deepEquals(mat, other.mat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String string = "";
		for (int i = 0; i < getHeight(); i++) {
			string += "{ ";
			for (int j = 0; j < getWidth(); j++) {
				string += getCoord(i, j) + " ";
			}
			string += "}\n";
		}
		return string;
	}

}
