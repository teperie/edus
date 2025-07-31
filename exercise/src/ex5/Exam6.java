package ex5;

public class Exam6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// .
		int[] coinUnit = { 500, 100, 50, 10 };
		int money = 2680;
		System.out.println("money=" + money);
		for (int i = 0; i < coinUnit.length; i++) {
			/*
			 * 알맞은코드를넣어완성하시오(1) .
			 */
			int qty = money / coinUnit[i];
			money %= coinUnit[i];

			System.out.printf("%d원: %d개\n", coinUnit[i], qty);
		}
	}

}
