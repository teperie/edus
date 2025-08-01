import java.util.Scanner;

public class ArrayExam7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		int[][] arr = new int[size][size];

		arr[0][0] = 1;
		for (int i = 1; i < arr.length; i++) {
			arr[i][0] = 1;
			for (int j = 1; j < arr[i].length; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		sc.close();
	}

}
/*
 * 
 */