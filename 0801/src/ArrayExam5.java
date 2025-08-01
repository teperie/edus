public class ArrayExam5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][7];
		arr[0][1] = 1;
		arr[0][3] = 1;
		arr[0][5] = 1;

		for (int i = 1; i < arr[0].length-1; i++) {
			System.out.print(arr[0][i] + " ");
		}
		System.out.println();

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length - 1; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j + 1];

				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
