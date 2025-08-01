
public class ArrayCopyTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[] { 1, 2, 3, 4, 5 };
		int[] arr2 = new int[arr1.length];

//		for (int i = 0; i < arr2.length; i++) {
//			arr2[i] = arr1[i];
//		}

		System.arraycopy(arr1, 0, arr2, 0, arr1.length);

		int[] arr3 = arr1.clone();

		arr1[0] = 100;

		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}

		System.out.println();

		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		
		System.out.println();

		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}

	}

}
