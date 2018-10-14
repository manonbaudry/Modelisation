package donnees;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class ModeleTest {
	
	Face face1;
	Segment s1;
	Segment s2;
	Segment s3;
	Point p1a;
	Point p1b;
	Point p2a;
	Point p2b;
	Point p3a;
	Point p3b;
	
	
	
	@Before
	public void init () {
		Point p1a = new Point (1.0, 2.7, 53.94);
		Point p1b = new Point (1.0, 2.7, 53.94);
		Point p2a = new Point (1.0, 2.7, 53.94);
		Point p2b = new Point (1.0, 2.7, 53.94);
		Point p3a = new Point (1.0, 2.7, 53.94);
		Point p3b = new Point (1.0, 2.7, 53.94);
		s1 = new Segment (p1a, p1b);
		s2 = new Segment (p2a, p2b);
		s3 = new Segment (p3a, p3b);
		face1 = new Face (s1, s2, s3);
		
		
	}

	@Test
	public void getBarycentreTest() {
		
	}

}
