package math;

/**
 * Class de calcul matricielle
 * 
 * @author prunierf
 *
 */
public class CalculMatrice {

	/**
	 * Addition entre la matrice m1 et m2
	 * 
	 * @param m1
	 *            - Matrice
	 * @param m2
	 *            - Matrice
	 * @return matrice m1 modifie
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

	/**
	 * Soustraction entre la matrice m1 et m2
	 * 
	 * @param m1
	 *            - Matrice
	 * @param m2
	 *            - Matrice
	 * @return matrice m1 modifie
	 */
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

	/**
	 * Multiplication matrice m1 et un nombre
	 * 
	 * @param m
	 *            - Matrice
	 * @param nb
	 *            - nombre
	 * @return matrice m modifie
	 */
	public static Matrice multMatriceNb(Matrice m, int nb) {
		return multMatriceNb(m, Double.valueOf(nb));
	}

	/**
	 * Multiplication matrice m1 et un nombre
	 * 
	 * @param m
	 *            - Matrice
	 * @param nb
	 *            - nombre
	 * @return m modifie
	 */
	public static Matrice multMatriceNb(Matrice m, double nb) {
		for (int i = 0; i < m.getHeight(); i++) {
			for (int j = 0; j < m.getWidth(); j++) {
				m.setCoord(m.getCoord(i, j) * nb, i, j);
			}
		}
		return m;
	}

	/**
	 * Multiplication matrice m1 et Matrice m2
	 * 
	 * @param m1
	 *            - Matrice
	 * @param m2
	 *            - Matrice
	 * @return nouvelle matrice
	 */
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

	/**
	 * Cree un vecteur de taille 4*1
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return Matrice
	 */
	public static Matrice vecteur(double x, double y, double z) {
		Matrice vecteur = new Matrice(4);
		vecteur.setCoord(x, 0, 0);
		vecteur.setCoord(y, 1, 0);
		vecteur.setCoord(z, 2, 0);
		vecteur.setCoord(1, 3, 0);
		return vecteur;
	}

	/**
	 * Cree matrice iodentite de taille l
	 * 
	 * @param l
	 * @return matrice identite
	 */
	public static Matrice identite(int l) {
		Matrice identite = new Matrice(l, l);
		for (int i = 0; i < identite.getHeight(); i++) {
			identite.setCoord(1, i, i);
		}
		return identite;
	}

	/**
	 * Transaltion de Matrice dest sur la Matrice chgmt
	 * 
	 * @param dest
	 *            - Matrice
	 * @param chgmt
	 *            - Matrice
	 * @return nouvelle matrice
	 */
	public static Matrice translation(Matrice dest, Matrice chgmt) {
		Matrice res = CalculMatrice.addMatrice(chgmt, dest);
		res.setCoord(1, res.getHeight() - 1, 0);
		return res;
	}

	/**
	 * Changement d'echelle de Matrice dest sur la Matrice chgmt
	 * 
	 * @param dest
	 *            - Matrice
	 * @param chgmt
	 *            - Matrice
	 * @return Matrice dest
	 */
	public static Matrice chgmtEchelle(Matrice dest, Matrice chgmt) {
		Matrice id = identite(chgmt.getHeight());
		for (int i = 0; i < id.getHeight(); i++) {
			id.setCoord(chgmt.getCoord(i, 0), i, i);
		}
		return CalculMatrice.multMatrice(id, dest);
	}

	/**
	 * Rotation X de la matrice m d angle teta
	 * 
	 * @param m
	 *            - Matrice
	 * @param teta
	 *            - radian
	 * @return Matrice m transforme
	 */
	public static Matrice rotationX(Matrice m, double teta) {
		Matrice id = identite(m.getHeight());
		id.setCoord(Math.cos(teta), 1, 1);
		id.setCoord(-Math.sin(teta), 1, 2);
		id.setCoord(Math.sin(teta), 2, 1);
		id.setCoord(Math.cos(teta), 2, 2);
		return CalculMatrice.multMatrice(id, m);
	}

	/**
	 * Rotation Y de la matrice m d angle teta
	 * 
	 * @param m
	 *            - Matrice
	 * @param teta
	 *            - radian
	 * @return Matrice m transforme
	 */
	public static Matrice rotationY(Matrice m, double teta) {
		Matrice id = identite(m.getHeight());
		id.setCoord(Math.cos(teta), 0, 0);
		id.setCoord(Math.sin(teta), 0, 2);
		id.setCoord(-Math.sin(teta), 2, 0);
		id.setCoord(Math.cos(teta), 2, 2);
		return CalculMatrice.multMatrice(id, m);
	}

	/**
	 * Rotation Z de la matrice m d angle teta
	 * 
	 * @param m
	 *            - Matrice
	 * @param teta
	 *            - radian
	 * @return Matrice m transforme
	 */
	public static Matrice rotationZ(Matrice m, double teta) {
		Matrice id = identite(m.getHeight());
		id.setCoord(Math.cos(teta), 0, 0);
		id.setCoord(-Math.sin(teta), 0, 1);
		id.setCoord(Math.sin(teta), 1, 0);
		id.setCoord(Math.cos(teta), 1, 1);
		return CalculMatrice.multMatrice(id, m);
	}

}
