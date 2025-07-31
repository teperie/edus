
public class DarrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] darr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

		int sum = 0;

		for (int i = 0; i < darr.length; i++) {
			for (int j = 0; j < darr[i].length; j++) {
				sum += darr[i][j];
			}
		}

		System.out.println(sum);

		System.out.println(darr[1][1]);
		darr[1][1] = 9;
		System.out.println(darr[1][1]);

		int[][] varr = new int[3][];
		varr[0] = new int[3];
		varr[1] = new int[2];
		varr[2] = new int[4];

		int[][] varr2 = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9 } };
		for (int i = 0; i < varr2.length; i++) {
			for (int j = 0; j < varr2[i].length; j++) {
				System.out.print(varr2[i][j] + " ");
			}
			System.out.println();
		}

	}

}
