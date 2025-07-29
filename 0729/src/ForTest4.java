import java.util.Scanner;

public class ForTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int dan = sc.nextInt();

		for (int j = 1; j <= 9; j++) {
			for (int i = 2; i < 10; i++) {
				System.out.print(String.format("%d x %d =%3d      ", i, j, i * j));
			}
			System.out.println();
		}
	}

}
