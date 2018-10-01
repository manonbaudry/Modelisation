package math;

import java.util.Arrays;

public class Matrice {

	double[][][] mat;
	
	public Matrice(int x, int y, int z) {
		mat = new double[x][y][z];
	}
	
	public int getWidth() {
		return mat.length;
	}
	
	public int getHeight() {
		return mat[0].length;
	}
	
	public int getDepth() {
		return mat[0][0].length;
	}
	
	public double getCoord(int x, int y, int z) {
		return mat[x][y][z];
	}
	
	public void setCoord(double coord, int x, int y) {
		mat[x][y][0] = coord;
	}
	
	public void setCoord(double coord, int x, int y, int z) {
		mat[x][y][z] = coord;
	}
	
	/**
	 * Addition entre la matrice courante et celle passe en parametre
	 * 
	 * @param m - matrice
	 * @return matrice courante
	 */
	public Matrice addMatrice(Matrice m) {
		if (this.getWidth() == m.getWidth() && this.getHeight() == m.getHeight() && this.getDepth() == m.getDepth()) {
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[i].length; j++) {
					for (int k = 0; k < mat[i][j].length; k++) {
						setCoord(getCoord(i, j, k)+m.getCoord(i, j, k), i, j, k);
					}
				}
			}
			return this;
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
