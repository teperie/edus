import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;



public class PipedTest {
	
	public static void main(String[] args) {
		
	}
}

class InputThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
}

class OutputThread extends Thread {
	PipedWriter output = new PipedWriter();

	public OutputThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void connect(PipedReader input) {
		try {
			output.connect(input);

		} catch (IOException e) {

		}
	}

	@Override
	public void run() {
		try {
			String msg = "Hello";
			System.out.println(getName() + " seng: " + msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
		super.run();
	}

}