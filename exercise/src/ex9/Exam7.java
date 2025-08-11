package ex9;

public class Exam7 {
	/*
	 * (1) contains메서드를 작성하시오.
	 */
	static boolean contains(String src, String target) {

		return src.indexOf(target) >= 0;

	}

	public static void main(String[] args) {
		System.out.println(contains("12345", "23"));
		System.out.println(contains("12345", "67"));
	}
}
