
public class ShapeMain {

	public static void main(String[] args) {
		Circle c1 = new Circle("Red", new Point(2, 5), 10);
		Circle c2 = new Circle("Orange", new Point(10, 34), 23);
		Circle c3 = new Circle();

		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());

		Rectangle rect1 = new Rectangle("Blue", new Point(4, 5), 20, 10);
		Rectangle rect2 = new Rectangle("Sky", 32, 12, 42, 25);
		Rectangle rect3 = new Rectangle();

		System.out.println(rect1.toString());
		System.out.println(rect2.toString());
		System.out.println(rect3.toString());

		ShapeSet set = new ShapeSet();
		set.addShape(c1);
		set.addShape(c2);
		set.addShape(c3);
		set.addShape(rect1);
		set.addShape(rect2);
		set.addShape(rect3);

		set.addShape(new Triangle("Green", new Point(3, 4), new Point(5, 6), new Point(8, 5)));
		set.addShape(new Triangle("Yellow", 6, 7, 8, 9, 1, 3));
		set.addShape(new Triangle());
	}

}
// [원: 색-Red, 중심점-(2,5), 반지름-10]
// [원: 색-Orange, 중심점-(2,5), 반지름-23]
// [원: 색-White, 중심점-(0,0), 반지름-0]
// [사각형: 색-Blue, 시작점-(0,0), 너비-10,높이-10]
// [사각형: 색-Sky, 시작점-(0,0), 너비-42,높이-25]
// [사각형: 색-White, 시작점-(0,0), 너비-0,높이-0]