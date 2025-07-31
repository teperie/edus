import java.util.Scanner;

public class ArrayExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputs = new int[100];

		Scanner sc = new Scanner(System.in);

		int[] result = null;

		int max = 3;

		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = sc.nextInt();
			if (inputs[i] == -1) {
				result = new int[i >= max ? max : i];
				for (int j = 0; j < result.length; j++) {
					result[j] = inputs[i - j - 1];
				}
				break;
			}
		}

		sc.close();

		/*
		 * Test data
		 * 30 20 10 60 80 -1
		 */

		for (int i = result.length - 1; i >= 0; i--) {
			System.out.print(result[i] + " ");
		}

	}

}