
public class Rectangle extends Shape {
	Point startPos;
	int width;
	int height;

	Rectangle() {
		this.startPos = new Point(0, 0);
		this.width = 0;
		this.height = 0;
	}

	Rectangle(String color, Point startPos, int width, int height) {
		this.startPos = startPos;
		this.width = width;
		this.height = height;
	}

	Rectangle(String color, int x, int y, int width, int height) {
		this.startPos = new Point(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println(String.format("[사각형: 색-%s, 시작점-(%d,%d), 너비-%d,높이-%d]",
				"White", startPos.x, startPos.y, width, height));
	}
}
