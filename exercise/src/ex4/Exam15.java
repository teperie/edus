package ex4;

public class Exam15 {

	public static void main(String[] args) {
		long number = 12321;
		long tmp = number;
		long result = 0; // number변수를거꾸로변환해서담을변수
		while (tmp != 0) {
			/*
			 * 알맞은코드를넣어완성하시오(1) .
			 */
			result *= 10;
			result += tmp % 10;
			tmp /= 10;
		}
		if (number == result)
			System.out.println(number + "는 회문수입니다.");
		else
			System.out.println(number + "는 회문수가 아닙니다.");
	}

}
