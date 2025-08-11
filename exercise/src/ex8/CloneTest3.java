package ex8;

class IntArray implements Cloneable {
	int[] arr = new int[100];

	@Override
	protected Object clone() {
		IntArray ia = null;
		try {
			ia = (IntArray) super.clone();
			ia.arr = arr.clone();
		} catch (CloneNotSupportedException e) {

		}
		return ia;
	}

}

public class CloneTest3 {
	public static void main(String[] args) {
		IntArray ia1 = new IntArray();
		IntArray ia2 = (IntArray) ia1.clone();
		ia1.arr[0] = 100;

		System.out.println(ia1.arr[0]);
		System.out.println(ia2.arr[0]);
		
	}

}
