package chapter8;

public class ExceptionTest1 {

	public static void main(String[] args) {
		String str = "String";
//		String str = null;
		try {
			System.out.println(str.toString());
			System.out.println("두번째 코드 처리");
			System.out.println(1);
			System.out.println(2);
			System.out.println(3);
			System.out.println(0 / 0);
			System.out.println(4);
		} catch (NullPointerException e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println("Null 예외");
		} catch (ArithmeticException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
