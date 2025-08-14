package ex14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Exam4 {
	public static void main(String[] args) {

		ArrayList<FileInputStream> al = new ArrayList<>();

		for (String fileName : args) {
			if (fileName.equals(args[0]))
				continue;
			try {
				FileInputStream fis = new FileInputStream(fileName);
				al.add(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(al));
				FileOutputStream fos = new FileOutputStream(args[0])) {

			byte[] buff = new byte[1024];

			int len;
			while ((len = sis.read(buff)) != -1) {
				fos.write(buff, 0, len);
			}
		} catch (IOException | ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} finally {
			for (FileInputStream fis : al) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
