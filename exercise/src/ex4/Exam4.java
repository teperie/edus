package ex4;

public class Exam4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 0;
		int result = 0;
		int neg = 1;

		for (int i = 1; total < 100; i++) {
//			if (i % 2 == 0) {
//				total += -i;
//			} else {
//				total += i;
//			}
//			result = i;
			total += i * neg;
			result = i;
			neg = -neg;
		}
		System.out.println(total);
		System.out.println(result);
	}

}
