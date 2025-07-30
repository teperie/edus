package ex4;

public class Exam14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = (int) (Math.random() * 100) + 1;
		int input = 0; //
		int count = 0; //
		java.util.Scanner s = new java.util.Scanner(System.in);
		do {
			count++;
			System.out.print("1과 100 사이의 값을 입력하세요 :");
			input = s.nextInt();// input .
			/*
			 * 알맞은코드를넣어완성하시오(2) .
			 */

			if (input > answer)
				System.out.println("더 적어요");
			else if (input < answer)
				System.out.println("더 커요");
			else {
				System.out.println("정답!! 시도횝수: " + count);
				break;
			}

		} while (true);
	}

}
