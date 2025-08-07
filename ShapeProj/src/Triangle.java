public class Triangle extends Shape {
	Point p1;
	Point p2;
	Point p3;

	public Triangle() {
		p1 = new Point();
		p2 = new Point();
		p3 = new Point();
	}

	public Triangle(String color, Point p1, Point p2, Point p3) {
		super(color);
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
		this.p3 = new Point(x3, y3);
	}

	public Triangle(String color, int x1, int y1, int x2, int y2, int x3, int y3) {
		super(color);
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
		this.p3 = new Point(x3, y3);
	}

	public void draw() {
		System.out.println(String.format("[삼각형: 색-%s, 점1-%s, 점2-%s, 점3-%s]", color, p1.draw(), p2.draw(), p3.draw()));
	}
}
