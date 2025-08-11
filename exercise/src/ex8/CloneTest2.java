package ex8;

class Circle implements Cloneable {
	int radius;
	Point center = new Point();

	Circle(int x, int y, int radius) {
		center.x = x;
		center.y = y;
		this.radius = radius;
	}

	@Override
	public String toString() {
		return String.format("[원: 중심점-%s, 반지름-%d]", center, radius);
	}

	@Override
	protected Object clone() {
		Circle circle = null;
		try {
			circle = (Circle) super.clone();
			circle.center = new Point(center.x, center.y);
		} catch (CloneNotSupportedException e) {
		}
		return circle;
	}

//	@Override
//	protected Object clone() {
//		Object obj = null;
//		try {
//			return super.clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return obj;
//	}
//
}

public class CloneTest2 {
	public static void main(String[] args) {
		Circle c1 = new Circle(4, 5, 10);
		System.out.println(c1);

		Circle c2 = (Circle) c1.clone();
		System.out.println(c2);
		System.out.println("==================");

		c1.center.x = 8;
		c1.radius = 20;

		System.out.println(c1);
		System.out.println(c2);
	}
}
