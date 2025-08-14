package ex14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class Exam1 {
	public static void main(String[] args) {
		try {
			int line = Integer.parseInt(args[0]);
			String fileName = args[1];

			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String str = null;

			for (int i = 0; i < line; i++) {
				str = br.readLine();
				if (str == null)
					break;
				System.out.println(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
