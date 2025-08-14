import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {
	public static void main(String[] args) {
		try (FileReader fr = new FileReader("pers.txt"); BufferedReader br = new BufferedReader(fr)) {
			String str = null;
			while ((str = br.readLine()) != null) {
				String[] prop = str.split(",");
				Person p = new Person(Integer.parseInt(prop[0]), prop[1]);
				System.out.println(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
