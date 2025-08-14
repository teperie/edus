import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Person {
	int age;
	String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[이름: " + name + ", 나이: " + age + "]";
	}
}

public class BufferedWriterTest {

	public static void main(String[] args) {
		Person[] pers = { new Person(20, "aaaa"), new Person(30, "bbbb") };

		try (FileWriter fw = new FileWriter("pers.txt"); BufferedWriter bw = new BufferedWriter(fw);) {
			for (Person person : pers) {
				String pstr = person.age + "," + person.name;
				bw.write(pstr);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
