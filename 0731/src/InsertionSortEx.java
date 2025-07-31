
public class InsertionSortEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 8, 5, 6, 2, 4 };
		int cnt = data.length;
		for (int i = 1; i < cnt; i++) {
			int key = data[i];
			int j;
			for (j = i - 1; j >= 0 && data[j] > key; j--) {
				data[j + 1] = data[j];
			}
			data[j + 1] = key;
		}

		for (int i = 0; i < cnt; i++) {
			System.out.print(data[i] + " ");
		}
	}

}
