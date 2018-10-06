import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import math.Matrice;

public class MatriceTest {
	
	private Matrice m1;
	private Matrice m2;
	private Matrice m3;
	
	
	@Before
	public void init() {
		m1 = new Matrice(3, 3);
		m2 = new Matrice(3, 2);
		m3 = new Matrice(3, 3);
		
		for (int i = 0; i < m1.getHeight(); i++) {
			for (int j = 0; j < m1.getWidth(); j++) {
				m1.setCoord(i+j, i, j);
			}
		}
		
		for (int i = 0; i < m2.getHeight(); i++) {
			for (int j = 0; j < m2.getWidth(); j++) {
				m2.setCoord(3-(i+j), i, j);
			}
		}
		
		for (int i = 0; i < m3.getHeight(); i++) {
			for (int j = 0; j < m3.getWidth(); j++) {
				m3.setCoord(3-(i+j), i, j);
			}
		}
	}
	
	@Test
	public void testTaille() {
		assertNull(m1.addMatrice(m2));
		assertNotNull(m1.addMatrice(m3));
	}
	
	@Test
	public void testAdd() {
		Matrice mTestAdd = new Matrice(3, 3);
		for (int i = 0; i < mTestAdd.getHeight(); i++) {
			for (int j = 0; j < mTestAdd.getWidth(); j++) {
				mTestAdd.setCoord(3, i, j);
			}
		}
		assertEquals(mTestAdd, m1.addMatrice(m3));
	}
	
	@Test
	public void testSuppr() {
		Matrice mTestSuppr = new Matrice(3, 3);
		mTestSuppr.setCoord(-3.0, 0, 0);
		mTestSuppr.setCoord(-1.0, 0, 1);
		mTestSuppr.setCoord(1.0, 0, 2);
		mTestSuppr.setCoord(-1.0, 1, 0);
		mTestSuppr.setCoord(1.0, 1, 1);
		mTestSuppr.setCoord(3.0, 1, 2);
		mTestSuppr.setCoord(1.0, 2, 0);
		mTestSuppr.setCoord(3.0, 2, 1);
		mTestSuppr.setCoord(5.0, 2, 2);
		
		assertEquals(mTestSuppr, m1.supprMatrice(m3));
	}
	
	@Test
	public void testMultNb() {
		Matrice mTestMultNb = new Matrice(3, 3);
		for (int i = 0; i < mTestMultNb.getHeight(); i++) {
			for (int j = 0; j < mTestMultNb.getWidth(); j++) {
				mTestMultNb.setCoord((i+j)*2, i, j);
			}
		}
		assertEquals(mTestMultNb, m1.multMatriceNb(2));
	}
	
	@Test
	public void testErrorMult() {
		assertNull(m1.multMatrice(m2));
		assertNotNull(m1.multMatrice(m3));
	}
	
	@Test
	public void testMult() {
		Matrice mTestMult = new Matrice(3, 3);
		mTestMult.setCoord(4.0, 0, 0);
		mTestMult.setCoord(1.0, 0, 1);
		mTestMult.setCoord(-2.0, 0, 2);
		mTestMult.setCoord(10.0, 1, 0);
		mTestMult.setCoord(4.0, 1, 1);
		mTestMult.setCoord(-2.0, 1, 2);
		mTestMult.setCoord(16.0, 2, 0);
		mTestMult.setCoord(7.0, 2, 1);
		mTestMult.setCoord(-2.0, 2, 2);
		
		assertEquals(mTestMult, m1.multMatrice(m3));
	}
	

}
