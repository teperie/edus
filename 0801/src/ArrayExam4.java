import java.util.Scanner;

public class ArrayExam4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] score = new int[4][3];
		int[] sum = new int[4];

		for (int i = 0; i < score.length; i++) {
			System.out.print(i + 1 + "class? ");
			for (int j = 0; j < score[i].length; j++) {
				score[i][j] = sc.nextInt();

				sum[i] += score[i][j];
			}
		}

		for (int i = 0; i < sum.length; i++) {
			System.out.printf("%dclass : %d\n", i + 1, sum[i]);
		}
		
		sc.close();

//		15 2 35
//		33 1 6
//		5 10 19
//		1 8 55

//		for (int i = 0; i < score.length; i++) {
//			for (int sum = 0, j = 0; j < score[i].length; j++) {
//				sum += score[i][j];
//			}
//		}
	}
}
