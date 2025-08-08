

public class ExceptionTest5 {

	public static void main(String[] args) {
		int[] arr1 = { 10, 20, 30, 40, 50 };
		int[] arr2 = { 2, 4, 0, 8 };

		for (int i = 0; i < arr1.length; i++) {
			try {
				System.out.println(arr1[i] / arr2[i]);
			} catch (ArithmeticException e) {
				System.out.println("0");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(arr1[i]);
			}
		}

	}

}
