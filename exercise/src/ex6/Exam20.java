package ex6;

public class Exam20 {
	static int[] shuffle(int[] original) {
		int[] result = original.clone();

		for (int i = 0; i < original.length * 100; i++) {
			int random1 = (int) (Math.random() * original.length);
			int random2 = (int) (Math.random() * original.length);

			int temp = result[random1];
			result[random1] = result[random2];
			result[random2] = temp;
		}
	
		return result;
	}

	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}

}
