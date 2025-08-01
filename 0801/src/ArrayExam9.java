import java.util.Scanner;

public class ArrayExam9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		byte[][] sticks = new byte[3][4];
		char[] result = {'A','A','A'};

		for (int i = 0; i < sticks.length; i++) {
			for (int j = 0; j < sticks[i].length; j++) {
				byte in = sc.nextByte();
				if (in > 0) {
					result[i]++;
					sticks[i][j]++;
				}
			}
		}
		
		sc.close();

	}

}
