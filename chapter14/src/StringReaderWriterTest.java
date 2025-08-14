import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderWriterTest {

	public static void main(String[] args) {
		String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
		StringReader reader = new StringReader(str);
		StringWriter writer = new StringWriter();

		int data;
		try {
			while ((data = reader.read()) != -1) {
				writer.write(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(writer.getBuffer().toString());

		StringBuffer sb = new StringBuffer();
		System.out.println(sb.toString());
	}

}
