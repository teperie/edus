import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		prop.put("driver", "org.mariadb.jdbc.Driver");
		prop.put("url", "jdbc:mariadb://localhost:3306/testdb25_2");
		prop.put("username", "root");
		prop.put("password", "7564");

		FileOutputStream fos = new FileOutputStream("db2.properties");
		
		prop.storeToXML(fos, "Database Connection");
		
		fos.close();
		
		Properties prop2 = new Properties();
	}
}
