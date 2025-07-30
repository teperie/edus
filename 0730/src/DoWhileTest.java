import java.util.Scanner;

public class DoWhileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		String input;
		do {
			System.out.println("숫자를 입력하세요(종요시 x입력)");
			input = sc.nextLine();
			int num = 0;
			
			try {
				num = Integer.parseInt(input);
			} catch(Exception e) {
//				System.out.println("숫자가 아님");
			}
			sum += num;

		} while (!(input.equals("x") || input.equals("X")));
		System.out.println(sum);
	}

}
