package ex7.exam22;

public class Exam22 {
	public static void main(String[] args) {
		Shape[] shape = { new Circle(new Point(6, 9), 5), new Rectangle(new Point(4, 5), 7, 3) };
		for (int i = 0; i < shape.length; i++) {
			System.out.println(shape[i].calcArea());
		}
	}
}