
public class BubbleSortEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 6, 3, 8, 5, 7, 9, 2 };
		int[][] data1 = { { 1, 2, 3 }, { 6, 7, 8 }, { 10, 12, 14 } };

		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data.length - i; j++) {
				if (data[j] > data[j + 1]) {
					int tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;
				}
			}
		}

		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

}
