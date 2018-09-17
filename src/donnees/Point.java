package donnees;

public class Point {
	
	int x;
	int y;
	int z;
	
	public Point (int x ,int y ,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	

}
