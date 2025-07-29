package ex4;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char ch;
		int x;
		String input;

		try {
			input = sc.nextLine();
			x = Integer.parseInt(input);
			if (x > 10 && x < 20) {
				System.out.println(x + "는 10보다 크거나 20보다 작음");
			}

			ch = sc.nextLine().charAt(0);
			if (ch == ' ' || ch != '\t') {
				System.out.println(ch + "는 곰백임 또는 탭이 아님");
			}

			ch = sc.nextLine().charAt(0);
			if (ch == 'x' || ch == 'X') {
				System.out.println(ch + "는 x 또는 X임");
			}

			ch = sc.nextLine().charAt(0);
			if (ch >= '0' && ch <= '9') {
				System.out.println(ch + "는 문자 0에서 문자 9사이임");
			}
			
			ch = sc.nextLine().charAt(0);
			if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch<='z') {
				System.out.println(ch + "는 알파벳임");
			}
			
			input = sc.nextLine();
			int year = Integer.parseInt(input);
			if ((year % 400 == 0 || year % 4 == 0) && year % 100 > 0) {
				System.out.println(year + "는 400이나 4료 나눠떨어지고 100으로 나눠떨어지지않음");
			}
			
			input = sc.nextLine();
			boolean powerOn = Boolean.parseBoolean(input);
			if (!powerOn) {
				System.out.println("true임");
			}
			
			String str = sc.nextLine();
			if (str == "yes") {
				System.out.println("true임");
			}
			
		} catch (Exception e) {
			throw e;
//			System.out.println(e);
		}
	}

}
