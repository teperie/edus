import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayStreamTest {
	public static void main(String[] args) throws IOException {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		ByteArrayInputStream bais = null;
		ByteArrayOutputStream baos = null;

		bais = new ByteArrayInputStream(inSrc);
		baos = new ByteArrayOutputStream();

		byte[] buff = new byte[inSrc.length];
		bais.read(buff);
		baos.write(buff);
		
//		int data;
//		while ((data = bais.read()) != -1) {
//			baos.write(data);
//		}

		byte[] outSrc = baos.toByteArray();
		inSrc[0] = 10;
		
		System.out.println(Arrays.toString(inSrc));
		System.out.println(Arrays.toString(outSrc));
		
		byte[] outSrc2 = inSrc.clone();
		System.out.println(Arrays.toString(outSrc2));
	}
}
