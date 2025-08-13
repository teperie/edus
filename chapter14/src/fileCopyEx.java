import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileCopyEx {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			fis = new FileInputStream("file.txt");
			fos = new FileOutputStream("copy.txt");

			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);

			byte[] buff = new byte[1024];
			int len;

			while ((len = bis.read(buff)) > 0) {
				bos.write(buff, 0, len);
			}

			int data;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
