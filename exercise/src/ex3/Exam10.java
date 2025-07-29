package ex3;

import java.util.Scanner;

public class Exam10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("두 개의 수를 입력하시오");
		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.println(String.format("%d + %d = %d", a, b, a + b));
		System.out.println(String.format("%d - %d = %d", a, b, a - b));
		System.out.println(String.format("%d * %d = %d", a, b, a * b));
		System.out.println(String.format("%d / %d = %d", a, b, a / b));
		System.out.println(String.format("%d %% %d = %d", a, b, a % b));

//		char ch = 'A';
//		char lowerCase = (ch >= 'A' && ch <= 'Z') ? (char) (ch + 32) : ch;
//		System.out.println("ch:" + ch);
//		System.out.println("ch to lowerCase:" + lowerCase);
	}

}
