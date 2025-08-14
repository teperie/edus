import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest1 {
	public static void main(String[] args) {
//		try (FileInputStream fis = new FileInputStream("news2.txt");) {
//			int data;
//			while ((data = fis.read()) != -1) {
//				System.out.print((char) data);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		try (FileReader fr = new FileReader("news2.txt")) {
			int data;
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
