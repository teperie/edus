package chapter8;

public class ExceptionTest4 {

	static void func1() throws Exception {
		String str = null;
		try {
			System.out.println(str.toString());
		} catch (Exception e) {
			System.out.println("1");
			throw new Exception("asdf");
		}
	}

	static void func2() throws Exception {
		func1();
	}

	public static void main(String[] args) {
		try {
			func2();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("2");
		}
		System.out.println("end");
	}

}
