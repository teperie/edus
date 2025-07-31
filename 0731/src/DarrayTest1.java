
public class DarrayTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] darr = new int[4][3];
		System.out.println(darr);
		System.out.println(darr[0]);

		darr[0][0] = 1;
		darr[0][1] = 2;
		darr[0][2] = 3;
//		darr[0][3] = 1;
		darr[3][2] = 34;

		int[][] darr2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

		
		
		System.out.println(darr.length);

		int[] arr = new int[3];
		System.out.println(arr);
		System.out.println(arr[0]);
	}

}
