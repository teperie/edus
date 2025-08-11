package ex9;

public class Exam8 {
	/*
	 * (1) round메서드를 작성하시오.
	 * 
	 */

	static double round(double d, int n) {
		double scale = Math.pow(10, n);

		return Math.round(d * scale) / scale;
	}

	public static void main(String[] args) {
		System.out.println(round(3.1415, 1));
		System.out.println(round(3.1415, 2));
		System.out.println(round(3.1415, 3));
		System.out.println(round(3.1415, 4));
		System.out.println(round(3.1415, 5));
	}
}
