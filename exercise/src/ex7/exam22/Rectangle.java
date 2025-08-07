package ex7.exam22;

public class Rectangle extends Shape {
	int width, height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point point, int width, int height) {
		super(point);
		this.width = width;
		this.height = height;
	}

	boolean isSquare() {
		return width == height;
	}

	@Override
	double calcArea() {
		return width * height;
	}
}