import java.util.Scanner;

public class ArrayExam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] natures = new int[10];

		natures[0] = sc.nextInt();
		natures[1] = sc.nextInt();

		for (int i = 2; i < natures.length; i++) {
			natures[i] = (natures[i - 2] + natures[i - 1]) % 10;
		}

		for (int i = 0; i < natures.length; i++) {
			System.out.print(natures[i] + " ");
		}
		
		System.out.println();

		int first = natures[0];
		int second = natures[1];

		System.out.print(first + " ");
		System.out.print(second + " ");

		for (int i = 2; i < 80; i++) {
			int tmp = first;
			first = second;
			second = (tmp + first) % 10;
			System.out.print(second + " ");
		}

	}

}
