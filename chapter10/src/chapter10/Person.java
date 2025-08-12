package chapter10;

public class Person implements Comparable<Person> {
	Integer age;
	String name;

	Person(Integer age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("[이름:%s, 나이:%d]", name, age);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person))
			return false;
		Person p = (Person) obj;
		return this.age == p.age && this.name == p.name;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}

	@Override
	public int compareTo(Person o) {

		return name.compareTo(o.name);
	}
}