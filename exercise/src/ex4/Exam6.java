package ex4;

public class Exam6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;

		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				if (i + j == 6) {
					System.out.println(String.format("(%d, %d)", i, j));
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
