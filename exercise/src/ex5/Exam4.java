package ex5;

public class Exam4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 }, { 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30 } };
		int total = 0;
		float average = 0;

		int qty = 0;
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 */
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
			}
			qty += arr[i].length;
		}
		average = (float) total / qty;
		System.out.println("totat=" + total);
		System.out.println("average=" + average);
	}

}
