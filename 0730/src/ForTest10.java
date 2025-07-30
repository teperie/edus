import java.util.Scanner;

public class ForTest10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int num = 1;
		char ch = 'A';

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.printf("%2d ", num);
				num++;
			}
			for (char j = 1; j <= i + 1; j++) {
				System.out.printf("%2c ", ch);
				ch++;
			}
			System.out.println();
		}
	}

}
