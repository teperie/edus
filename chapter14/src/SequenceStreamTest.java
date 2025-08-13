import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class SequenceStreamTest {
	public static void main(String[] args) {
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		FileOutputStream fos = null;
		SequenceInputStream sis = null;
		try {
			fis1 = new FileInputStream("news2.txt");
			fis2 = new FileInputStream("news3.txt");

			fos = new FileOutputStream("totnews.txt");
			sis = new SequenceInputStream(fis1, fis2);

			byte[] buff = new byte[1024];
			int len;
			while ((len = sis.read(buff)) > 0) {
				fos.write(buff, 0, len);

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
