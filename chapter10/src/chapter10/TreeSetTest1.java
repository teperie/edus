package chapter10;

import java.util.Comparator;
import java.util.TreeSet;

class AgeCompare implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		return o1.age - o2.age;
	}
}

public class TreeSetTest1 {
	public static void main(String[] args) {
		TreeSet<Integer> its = new TreeSet<Integer>();
		its.add(4);
		its.add(1);
		its.add(8);
		its.add(7);
		its.add(5);

		System.out.println(its);

		TreeSet<String> sis = new TreeSet<String>();

		sis.add("a");
		sis.add("b");
		sis.add("c");
		sis.add("d");
		sis.add("e");
		System.out.println(sis);

		TreeSet<Person> pis = new TreeSet<Person>();

		pis.add(new Person(20, "홍"));
		pis.add(new Person(20, "홍"));
		pis.add(new Person(20, "홍"));
		pis.add(new Person(30, "고"));
		pis.add(new Person(10, "김"));
		pis.add(new Person(40, "박"));

		System.out.println(pis);

		TreeSet<Person> pis2 = new TreeSet<Person>(new AgeCompare());

		pis2.addAll(pis);
		System.out.println(pis2);
	}
}
