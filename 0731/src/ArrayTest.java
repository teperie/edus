
public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[3];
		System.out.println(arr);

		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		int[] arr2 = new int[5];
		arr2[0] = 1;
		arr2[1] = 2;
		arr2[2] = 3;
		arr2[3] = 4;
		arr2[4] = 5;

		int[] arr3 = new int[] { 1, 2, 3, 4, 5 };

		int[] arr4 = { 1, 2, 3, 4, 5 };

		int[] arr5;
		arr5 = new int[] { 1, 2, 3, 4, 5 };

//		int[] arr6;
//		arr6={1,2,3,4,5}; // error

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			sum += arr[i];
		}
		System.out.println(sum);
	}

}
