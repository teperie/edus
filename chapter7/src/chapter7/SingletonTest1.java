package chapter7;

class SingleArray {
	private int[] arr = new int[10];
	private int cnt;

	private static SingleArray singleArray;

	private SingleArray() {
	}

	public static SingleArray getReferenceSingleArray() {
		if (singleArray == null)
			singleArray = new SingleArray();
		return singleArray;
	}

	public void setData(int data) {
		arr[cnt++] = data;
	}

	public int getData(int index) {
		return arr[index];
	}

}

public class SingletonTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleArray sa = SingleArray.getReferenceSingleArray();
		sa.setData(100);
		System.out.println(sa.getData(0));
		SingleArray sa2 = SingleArray.getReferenceSingleArray();
		System.out.println(sa.getData(0));
	}

}
