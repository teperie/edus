package chapter7;

public class OverrideTest1 {

	public static void main(String[] args) {
		Person p1 = new Person(20, "홍길동");
		System.out.println(p1.info());

		Student s1 = new Student(23, "고길동", "산업공학");
		System.out.println(s1.info());
	}

}
