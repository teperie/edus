
package ex14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exam2 {

	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream(args[0])) {
			int len;
			byte[] buff = new byte[16];
			while ((len = fis.read(buff)) != -1) {
				for (int i = 0; i < len; i++) {
					System.out.printf("%02X ", buff[i]);
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
