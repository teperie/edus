package chapter6;

public class RecursiveTest1 {
	public static int factorial(int n) {
		if (n == 1)
			return 1;
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		int result = factorial(24);
		System.out.println(result);
	}

}
