import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class UserInfo implements Serializable {
	String id;
	String name;
	transient String password;
	Integer age;

	UserInfo(String id, String name, String password, Integer age) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age;
	}
}

public class ObjectOutputStreamTest {

	public static void main(String[] args) {
		UserInfo userInfo = new UserInfo("1001", "홍길동", "1234", 20);

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("user.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(userInfo);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
