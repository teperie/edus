import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("info.bin");
			dis = new DataInputStream(fis);

			int age = dis.readInt();
			double height = dis.readDouble();
			boolean isMarried = dis.readBoolean();
			String name = dis.readUTF();

			System.out.println(age);
			System.out.println(height);
			System.out.println(isMarried);
			System.out.println(name);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
