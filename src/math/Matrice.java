package math;

import java.util.Arrays;

public class Matrice {

	double[][] mat;

	public Matrice(int x) {
		this(x, 1);
	}

	public Matrice(int x, int y) {
		mat = new double[x][y];

	}

	public int getHeight() {
		return mat.length;
	}

	public int getWidth() {
		return mat[0].length;
	}

	public double getCoord(int x, int y) {
		return mat[x][y];
	}

	public void setCoord(double coord, int x, int y) {
		mat[x][y] = coord;
	}

	/**
	 * Addition entre la matrice courante et celle passe en parametre
	 * 
	 * @param m
	 *            - matrice
	 * @return matrice courante
	 */
	public Matrice addMatrice(Matrice m) {
		if (this.getWidth() == m.getWidth() && this.getHeight() == m.getHeight()) {
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[i].length; j++) {
					setCoord(getCoord(i, j) + m.getCoord(i, j), i, j);
				}
			}
			return this;
		}
		return null;
	}

	public Matrice supprMatrice(Matrice m) {
		if (this.getWidth() == m.getWidth() && this.getHeight() == m.getHeight()) {
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[i].length; j++) {
					setCoord(getCoord(i, j) - m.getCoord(i, j), i, j);
				}
			}
			return this;
		}
		return null;
	}

	public Matrice multMatriceNb(int nb) {
		return multMatriceNb(Double.valueOf(nb));
	}

	public Matrice multMatriceNb(double nb) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				setCoord(getCoord(i, j) * nb, i, j);
			}
		}
		return this;
	}

	public Matrice multMatrice(Matrice m) {
		if (this.getWidth() == m.getHeight() && this.getHeight() == m.getWidth()) {
			Matrice newMatrice = new Matrice(this.getWidth(), m.getWidth());
			for (int i = 0; i < this.getWidth(); i++) {
				for (int j = 0; j < m.getHeight(); j++) {
					newMatrice.setCoord(0.0, i, j);
					for (int k = 0; k < m.getHeight(); k++) {
						newMatrice.setCoord(newMatrice.getCoord(i, j) + (this.getCoord(i, k) * m.getCoord(k, j)), i, j);
					}
				}
			}
			return newMatrice;
		}
		return null;
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
		return Arrays.deepToString(mat);
	}

}
