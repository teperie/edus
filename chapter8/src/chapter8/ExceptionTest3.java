package chapter8;

import java.util.Scanner;

public class ExceptionTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			String str = sc.nextLine();
			int num = Integer.parseInt(str);
			if (num < 0 || num > 6)
				throw new NumberFormatException("뭐요");
		} catch (NumberFormatException e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}
