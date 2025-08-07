package ex7.exam22;

public class Circle extends Shape {
	double r;

	public Circle(double r) {
		this.r = r;
	}

	public Circle(Point point, double r) {
		super(point);
		this.r = r;
	}

	@Override
	double calcArea() {
		return Math.PI * r * r;
	}
}