package chapter7;

public class Person {
	int age;
	String name;
	int major;

	Person() {
	}

	Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	String info() {
		return String.format("이름:%s, 나이:%d", name, age);
	}
}
