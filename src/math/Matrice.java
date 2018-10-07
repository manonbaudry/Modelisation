package math;

import java.util.Arrays;

import donnees.Point;

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
