import java.util.Scanner;

public class ArrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 100, 200, 300 };
		
		//////////////////

		char[] array2 = new char[26];
		char ch = 'A';
		for (int i = 0; i < array2.length; i++) {
			array2[i] = ch++;
		}
		
		//////////////////
		
		int[] score = new int[3];
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			System.out.println("점수 입력");
			score[i] = sc.nextInt();
			sum += score[i];
		}
		System.out.println(sum / score.length);
		sc.close();
	}

}
