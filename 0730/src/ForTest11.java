import java.util.Scanner;

public class ForTest11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print("$");
			}
			for (char j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
