package ex5;

public class Exam11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] score = { { 100, 100, 100 }, { 20, 20, 20 }, { 30, 30, 30 }, { 40, 40, 40 }, { 50, 50, 50 } };
		int[][] result = new int[score.length + 1][score[0].length + 1];
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				/*
				 * (1) 알맞은 코드를 넣어 완성하시오.
				 */
				result[i][j] = score[i][j];
				
				int sumRow = result.length - 1;
				int sumCol = result[i].length - 1;
				
				result[i][sumCol] += score[i][j];
				result[sumRow][j] += score[i][j];
				result[sumRow][sumCol] += score[i][j];
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.printf("%4d", result[i][j]);
			}
			System.out.println();
		}
	}

}
