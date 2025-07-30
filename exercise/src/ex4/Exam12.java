package ex4;

public class Exam12 {

	public static void main(String[] args) {
		int minDan = 2;
		int maxDan = 9;
		int tabs = 3;

		for (int cell = 0; cell < maxDan / tabs; cell++) {
			for (int i = 1; i <= 9; i++) {
				int start = minDan + cell * tabs;
				int end = start + tabs;

				while (start <= maxDan && start < end) {
					System.out.printf("%d*%d=%d\t", start, i, i * start);
					start++;
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
