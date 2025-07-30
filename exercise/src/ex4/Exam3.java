package ex4;

public class Exam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 0;
		
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= i; j++) {
				total += j;
			}
		}
		
		System.out.println(total);
	}

}
