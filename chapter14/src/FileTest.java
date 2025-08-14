import java.io.File;

public class FileTest {

	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.println("디렉토리를 입력하세요");
			System.exit(0);

		}

		File file = new File(args[0]);
		if (!(file.exists() && file.isDirectory())) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}

		File[] files = file.listFiles();
		for (File f : files) {
			String fileName = f.getName();
			System.out.println(f.isDirectory() ? "[" + fileName + "]" : fileName);
		}

	}

}
