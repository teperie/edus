package ex4;

public class Exam8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				if (2 * x + 4 * y == 10) {
					System.out.println(String.format("x=%d, y=%d", x, y));
				}
			}
		}
	}

}
