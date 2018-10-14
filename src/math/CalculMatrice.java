package math;

import donnees.Point;

public class CalculMatrice {
	
	/**
	 * Addition entre la matrice courante et celle passe en parametre
	 * 
	 * @param m1
	 *            - matrice
	 * @return matrice courante
	 */
	public static Matrice addMatrice(Matrice m1, Matrice m2) {
		if (m2.getWidth() == m1.getWidth() && m2.getHeight() == m1.getHeight()) {
			for (int i = 0; i < m1.getHeight(); i++) {
				for (int j = 0; j < m2.getWidth(); j++) {
					m1.setCoord(m1.getCoord(i, j) + m2.getCoord(i, j), i, j);
				}
			}
			return m1;
		}
		return null;
	}

	public static Matrice supprMatrice(Matrice m1, Matrice m2) {
		if (m2.getWidth() == m1.getWidth() && m2.getHeight() == m1.getHeight()) {
			for (int i = 0; i < m1.getHeight(); i++) {
				for (int j = 0; j < m1.getWidth(); j++) {
					m1.setCoord(m1.getCoord(i, j) - m2.getCoord(i, j), i, j);
				}
			}
			return m1;
		}
		return null;
	}

	public static Matrice multMatriceNb(Matrice m, int nb) {
		return multMatriceNb(m, Double.valueOf(nb));
	}

	public static Matrice multMatriceNb(Matrice m, double nb) {
		for (int i = 0; i < m.getHeight(); i++) {
			for (int j = 0; j < m.getWidth(); j++) {
				m.setCoord(m.getCoord(i, j) * nb, i, j);
			}
		}
		return m;
	}

	public static Matrice multMatrice(Matrice m1, Matrice m2) {
		if (m1.getWidth() == m2.getHeight()) {
			Matrice newMatrice = new Matrice(m1.getHeight(), m2.getWidth());
			for (int i = 0; i < m1.getHeight(); i++) {
				for (int j = 0; j < m2.getWidth(); j++) {
					newMatrice.setCoord(0.0, i, j);
					for (int k = 0; k < m1.getHeight(); k++) {
						newMatrice.setCoord(newMatrice.getCoord(i, j) + (m1.getCoord(i, k) * m2.getCoord(k, j)), i, j);
					}
				}
			}
			return newMatrice;
		}
		return null;
	}
	
	public static Matrice vecteur(int x, int y, int z) {
		Matrice vecteur = new Matrice(4);
		vecteur.setCoord(x, 0, 0);
		vecteur.setCoord(y, 1, 0);
		vecteur.setCoord(z, 2, 0);
		vecteur.setCoord(1, 3, 0);
		return vecteur;
	}
	
	public static Matrice identite(int l) {
		Matrice identite = new Matrice(l, l);
		for (int i = 0; i < identite.getHeight(); i++) {
			identite.setCoord(1, i, i);
		}
		return identite;
	}
	
	public static Matrice translation(Matrice dest, Matrice chgmt) {
		Matrice res = CalculMatrice.addMatrice(chgmt, dest);
		res.setCoord(1, res.getHeight()-1, 0);
		return res;
	}
	
	public static Matrice chgmtEchelle(Matrice dest, Matrice chgmt) {
		Matrice id = identite(chgmt.getHeight());
		for (int i = 0; i < id.getHeight(); i++) {
			id.setCoord(chgmt.getCoord(i, 0), i, i);
		}
		return CalculMatrice.multMatrice(id, dest);
	}
	
	public static Matrice rotationX(Matrice m, double teta) {
		Matrice id = identite(m.getHeight());
		id.setCoord(Math.cos(teta), 1, 1);
		id.setCoord(-Math.sin(teta), 1, 2);
		id.setCoord(Math.sin(teta), 2, 1);
		id.setCoord(Math.cos(teta), 2, 2);
		return CalculMatrice.multMatrice(id, m);
	}
	
	public static Matrice rotationY(Matrice m, double teta) {
		Matrice id = identite(m.getHeight());
		id.setCoord(Math.cos(teta), 0, 0);
		id.setCoord(Math.sin(teta), 0, 2);
		id.setCoord(-Math.sin(teta), 2, 0);
		id.setCoord(Math.cos(teta), 2, 2);
		return CalculMatrice.multMatrice(id, m);
	}
	
	public static Matrice rotationZ(Matrice m, double teta) {
		Matrice id = identite(m.getHeight());
		id.setCoord(Math.cos(teta), 0, 0);
		id.setCoord(-Math.sin(teta), 0, 1);
		id.setCoord(Math.sin(teta), 1, 0);
		id.setCoord(Math.cos(teta), 1, 1);
		return CalculMatrice.multMatrice(id, m);
	}
	
}
