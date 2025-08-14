import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Parent {

	String name;
	String password;

	public Parent(String name, String password) {
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "name=" + name + ", password=" + password;
	}

}
