package pac6_3;

class Person {
	int age;
	String name;

	Person() { // 기본 생성자
		this(10, "모름");
	}

	Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	Person(int age) {
		this(age, "모름");
	}

	Person(String name) {
		this(0, name);
	}

	Person(Person person) {
		this.age = person.age;
		this.name = person.name;
	}

	String info() {
		return String.format("이름: %s, 나이: %d", name, age);
	}
}

public class ConstructorTest1 {

	public static void main(String[] args) {
		Person p1 = new Person();
		System.out.println(p1.info());

		Person p2 = new Person(20, "홍길동");
		System.out.println(p2.info());

		Person p3 = new Person(30);
		System.out.println(p3.info());

		Person p4 = new Person("고길동");
		System.out.println(p4.info());

		Person p5 = new Person(p2);
		System.out.println(p5.info());
	}

}
