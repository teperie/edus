package ex4;

public class Exam11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Fibonnaci 1,1 .
		int num1 = 1;
		int num2 = 1;
		int num3 = 0; //
		System.out.print(num1 + "," + num2);
		for (int i = 0; i < 8; i++) {
			/*
			 * 알맞은코드를넣어완성하시오(1) .
			 */
			num3 = num1 + num2;
			System.out.print("," + num3);
			
			num1 = num2;
			num2 = num3;
		}
	}

}
