package ex4;

public class Exam10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 12345;
		int sum = 0;
		/*
		 * 알맞은코드를넣어완성하시오(1) .
		 */
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}

		System.out.println("sum=" + sum);
	}

}
