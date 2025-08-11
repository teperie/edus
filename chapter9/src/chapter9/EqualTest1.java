package chapter9;

class Person {
	int age;
	String name;

	Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person))
			return false;
		if (this == obj)
			return true;
		Person p = (Person) obj;
		return age == p.age && name.equals(p.name);
	}

	@Override
	public String toString() {
		return String.format("이름: %s, 나이: %d", name, age);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (name + age).hashCode();
	}
}

public class EqualTest1 {
	public static void main(String[] args) {
		Person p1 = new Person(20, "sdaf");
		Person p2 = new Person(20, "sdaf");
		Person p3 = new Person(30, "sdaf");
		Person p4 = new Person(20, "ssadfdaf");

		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));

		System.out.println(p1.equals(p3));
		System.out.println(p1.equals(p4));

		System.err.println(p1);
		System.err.println(p2);
		System.err.println(p3);
		System.err.println(p4);
	}
}
