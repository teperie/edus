

class MyData<T> {
	T data;

	void setData(T data) {
		this.data = data;
	}

	T getData() {
		return data;
	}
}

class Data {
	Object data;

	void setData(Object data) {
		this.data = data;

	}

	Object getData() {
		return data;
	}
}

public class GenericTest {
	public static void main(String[] args) {
		MyData<Integer> imd = new MyData<>();
		imd.setData(100);
		System.out.println(imd.getData());

		Data d = new Data();
		d.setData("hong");
		String name = (String) d.getData();

		Data d2 = new Data();
		d2.setData(300);
		Integer n = (Integer) d2.getData();

		MyData<String> smd = new MyData<>();

		String smddata = smd.getData();
	}
}
