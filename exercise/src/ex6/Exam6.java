package ex6;

public class Exam6 {

	static double getDistance(int x, int y, int x1, int y1) {
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 */
		return Math.sqrt(((x1 - x) + (y1 - y)) * ((x1 - x) + (y1 - y)));
	}

	public static void main(String args[]) {
		System.out.println(getDistance(1, 1, 2, 2));
	}

}
