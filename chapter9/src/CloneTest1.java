
class Point implements Cloneable {
	int x, y;

	Point() {
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}

}

public class CloneTest1 {
	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = (Point) p1.clone();
		
		System.out.println();
	}
}
