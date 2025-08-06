
public class Circle extends Shape {
	Point center;
	int radius;

	Circle() {
		color = "White";
		center = new Point();
		radius = 0;
	}

	Circle(String color, Point center, int radius) {
		this.color = color;
		this.radius = radius;
		this.center = center;
	}

	Circle(String color, int x, int y, int radius) {
		this.color = color;
		this.center = new Point(x, y);
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println(String.format("[원: 색-%s, 중심점-%s, 반지름-%d]", color, center.toString(), radius));
	}
}
