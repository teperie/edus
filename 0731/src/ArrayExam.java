import java.util.Scanner;

public class ArrayExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] inputs = new int[10];

		int oddSum = 0, evenSum = 0;

		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = sc.nextInt();
			if (i % 2 == 0) {
				oddSum += inputs[i];
			} else {
				evenSum += inputs[i];
			}
		}
		System.out.printf("odd: %d\n", oddSum);
		System.out.printf("even: %d\n", evenSum);
		
		sc.close();
	}

}
/*
 * 10 20 25 66 83 7 22 90 1 100
 */