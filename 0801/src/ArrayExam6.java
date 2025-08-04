import java.util.Scanner;

public class ArrayExam6 {

	public static void main(String[] args) {
		int[][] src = new int[4][2];

		int[] rtot = new int[src.length];
		int[] ctot = new int[src[0].length];
		int atot = 0;

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < rtot.length; i++) {
			for (int j = 0; j < ctot.length; j++) {
				src[i][j] = sc.nextInt();
				rtot[i] += src[i][j];
				ctot[j] += src[i][j];
				atot += src[i][j];
			}
		}

//		for (int i = 0; i < rtot.length; i++) {
//			for (int j = 0; j < ctot.length; j++) {
//				
//			}
//		}

		for (int i = 0; i < rtot.length; i++) {
			System.out.print((double)rtot[i] / src[0].length + " ");
		}
		System.out.println();

		for (int i = 0; i < ctot.length; i++) {
			System.out.print((double)ctot[i] / src.length + " ");
		}
		System.out.println();

		System.out.println((double)atot / (ctot.length * rtot.length));

//		for (int i = 0; i < ctot.length; i++) {
//			for (int j = 0; j < rtot.length; j++) {
//				ctot[i] += arr[i][j];
//			}
//		}
		System.out.println();
	}

}

//
//16 27
//39 100
//19 88
//61 20