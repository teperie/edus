package ex6;

public class Exam23 {

	static int max(int[] arr) {
		int result = -999999;

		if (arr != null)
			for (int i = 0; i < arr.length; i++) {
				result = result < arr[i] ? arr[i] : result;
			}

		return result;
	}

	public static void main(String[] args) {
		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:" + max(data));
		System.out.println("최대값:" + max(null));
		System.out.println("최대값:" + max(new int[] {})); // 크기가 0인 배열
	}

}
