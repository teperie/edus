import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputTest2 {

	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("oos.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			Child child = (Child) ois.readObject();
			System.out.println(child);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
