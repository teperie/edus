import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest3 {

	public static void main(String[] args) throws IOException {
		Properties pros = new Properties();
		FileInputStream fis = new FileInputStream("info.txt");
		pros.load(fis);
		fis.close();

		System.out.println(pros.getProperty("name").getBytes("ISO-8859-1,utf-8"));
		System.out.println(pros.getProperty("age"));
		System.out.println(pros.getProperty("address"));
	}

}
