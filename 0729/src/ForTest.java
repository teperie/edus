
public class ForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 2; i <= 10; i += 2) {
			sum += i;
		}

		System.out.println(sum);

		sum = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		
		System.out.println(sum);
	}

}
