package ex9;

public class Exam12 {
	/*
	 * (1) getRand메서드를 작성하시오.
	 */
	public static int getRand(int from, int to) {
		return Math.min(from, to) + (int) (Math.random() * (Math.abs(from - to) + 1));
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++)
			System.out.print(getRand(1, -3) + ",");
	}
}
