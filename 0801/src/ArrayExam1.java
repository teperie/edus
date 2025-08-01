import java.util.Scanner;

public class ArrayExam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dices = new int[10];
		int[] times = new int[6];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < dices.length; i++) {
//			dices[i] = (int) (Math.random() * 6) + 1;
			dices[i] = sc.nextInt();
//			System.out.print(dices[i] + " ");
			times[dices[i] - 1]++;
		}
//		System.out.println();

		for (int i = 0; i < times.length; i++) {
			System.out.printf("%d : %d\n", i + 1, times[i]);
		}
		
		sc.close();
	}
}
