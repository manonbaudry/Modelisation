import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import math.Matrice;

class MatriceTest {

	@Test
	void test() {
		Matrice m1 = new Matrice(3, 3, 1);
		Matrice m2 = new Matrice(3, 2, 1);
		Matrice m3 = new Matrice(3, 3, 1);
		Matrice mTestAdd = new Matrice(3, 3, 1);
		
		for (int i = 0; i < m1.getWidth(); i++) {
			for (int j = 0; j < m1.getHeight(); j++) {
				m1.setCoord(i+j, i, j);
			}
		}
		
		for (int i = 0; i < m2.getWidth(); i++) {
			for (int j = 0; j < m2.getHeight(); j++) {
				m2.setCoord(3-(i+j), i, j);
			}
		}
		
		for (int i = 0; i < m3.getWidth(); i++) {
			for (int j = 0; j < m3.getHeight(); j++) {
				m3.setCoord(3-(i+j), i, j);
			}
		}
		
		for (int i = 0; i < mTestAdd.getWidth(); i++) {
			for (int j = 0; j < mTestAdd.getHeight(); j++) {
				mTestAdd.setCoord(3, i, j);
			}
		}
		
		assertNull(m1.addMatrice(m2));
		assertNotNull(m1.addMatrice(m3));
		
		assertEquals(mTestAdd, m1);
	}

}
