package chapter7;

public class Student extends Person {
	String major;

	Student(int age, String name, String major) {
		this.age = age;
		this.name = name;
		this.major = major;
	}

	@Override
	String info() {
		return super.info() + ", 전공:" + major;
	}

}
