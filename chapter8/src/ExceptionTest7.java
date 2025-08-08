

import java.io.FileInputStream;

public class ExceptionTest7 {

	public static void main(String[] args) {
		try {

			String str = null;
			System.out.println(str.toString());

			int[] arr = new int[3];

			arr[3] = 100;

			FileInputStream fis = new FileInputStream("a.txt");

			return;
			
		} catch (NullPointerException e) {
		} catch (ArrayIndexOutOfBoundsException e) {
		} catch (RuntimeException e) {
		} catch (Exception e) {
		} finally {
			System.out.println("finally");
		}
	}

}