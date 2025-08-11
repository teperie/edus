package ex9;

public class Exam12 {
	/*
	 * (1) getRand메서드를 작성하시오.
	 */
	public static int getRand(int from, int to) {
		int min = Math.min(from, to);
		int max = Math.max(from, to);

		double random = Math.random() * (max - min + 1);
		random += min;
		return Math.abs(random);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++)
			System.out.print(getRand(1, -3) + ",");
	}
}
