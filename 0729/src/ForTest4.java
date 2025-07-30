public class ForTest4 {

	public static void main(String[] args) {

		for (int j = 1; j <= 9; j++) {
			for (int i = 2; i <= 9; i++) {
				System.out.print(String.format("%d x %d =%3d\t", i, j, i * j));
			}
			System.out.println();
		}
	}

}
