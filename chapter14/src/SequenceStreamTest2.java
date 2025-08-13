import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Vector;

public class SequenceStreamTest2 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		SequenceInputStream sis = null;
		Vector<FileInputStream> v = new Vector<>();

		try {
			v.add(new FileInputStream("news2.txt"));
			v.add(new FileInputStream("news3.txt"));
			v.add(new FileInputStream("file.txt"));

			sis = new SequenceInputStream(v.elements());
			fos = new FileOutputStream("totnews2.txt");

			byte[] buff = new byte[1024];
			int len;
			while ((len = sis.read(buff)) != -1) {
				fos.write(buff, 0, len);

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (sis != null)
					sis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
