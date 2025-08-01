import java.util.Scanner;

public class ArrayExam2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] scores = new int[100];
		int[] grades = new int[11];

		for (int i = 0; i < scores.length; i++) {
//			int score = sc.nextInt();

			int score = (int)(Math.random() * 101);
			
			if (score == 0)
				break;

			scores[i] = score;
			grades[score / 10]++;

		}

		for (int i = grades.length - 1; i >= 0; i--) {
			if (grades[i] > 0)
				System.out.printf("%d : %d person\n", i * 10, grades[i]);
		}

		sc.close();
	}

}
