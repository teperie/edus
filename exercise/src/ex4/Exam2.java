package ex4;

public class Exam2 {

	public static void main(String[] args) {
		int total = 0;

		for (int i = 1; i <= 20; i++) {
			if ((i & 1) != 0 && i % 3 != 0) {
				total += i;
			}
		}

		System.out.println(total);
	}

}
