import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {
	public static void main(String[] args) {
		int age = 20;
		double height = 175.2;
		boolean isMarried = true;
		String name = "hong gil dong";

		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("info.bin");
			dos = new DataOutputStream(fos);
			dos.writeInt(age);
			dos.writeDouble(height);
			dos.writeBoolean(isMarried);
			dos.writeUTF(name);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null)
					dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
