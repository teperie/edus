package ex7.exam22;

public class Exam23 {

	static double sumArea(Shape[] arr) {
		double totArea = 0;
		for (int i = 0; i < arr.length; i++) {
			totArea += arr[i].calcArea();
		}
		return totArea;
	}

	public static void main(String[] args) {
		Shape[] arr = { new Circle(5.0), new Rectangle(3, 4), new Circle(1) };
		System.out.println("면적의 합:" + sumArea(arr));
	}

}
