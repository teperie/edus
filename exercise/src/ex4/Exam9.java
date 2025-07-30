package ex4;

public class Exam9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "12345";
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			/*
			 * 알맞은코드를넣어완성하시오(1) .
			 */
			sum += str.charAt(i) - '0';
		}
		System.out.println("sum=" + sum);
	}

}
