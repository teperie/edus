import java.util.Scanner;

public class ForTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();

		for (int i = 1; i < 10; i++) {
			System.out.println(String.format("%d x %d =%3d", dan, i, dan * i));
		}
	}
}
