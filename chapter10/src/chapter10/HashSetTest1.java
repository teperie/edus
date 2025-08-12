package chapter10;

import java.util.HashSet;

class Person2 {
	Integer age;
	String name;

	Person2(Integer age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("이름:%s, 나이:%d", name, age);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person2))
			return false;
		Person2 p = (Person2) obj;
		return this.age == p.age && this.name == p.name;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
}

public class HashSetTest1 {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(100);
		hs.add(200);
		hs.add(100);
		System.out.println(hs);
		System.out.println(hs.size());

		HashSet<Person2> psh = new HashSet<>();
		psh.add(new Person2(20, "홍길동"));
		psh.add(new Person2(20, "홍길동"));
		System.out.println(psh);
		System.out.println(psh.size());
	}
}
