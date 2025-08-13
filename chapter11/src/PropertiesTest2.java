import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest2 {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties(), prop2 = new Properties();
		FileInputStream fis = new FileInputStream("db.properties");
		prop.load(fis);
		fis.close();

		System.out.println(prop.getProperty("driver"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));

		FileInputStream fis2 = new FileInputStream("db2.properties");
		prop2.loadFromXML(fis2);
		fis2.close();

		System.out.println(prop2.getProperty("driver"));
		System.out.println(prop2.getProperty("url"));
		System.out.println(prop2.getProperty("username"));
		System.out.println(prop2.getProperty("password"));

	}
}
