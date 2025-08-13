package chapter10;

import java.util.ArrayList;
import java.util.HashMap;

class SClass {
	int grade;
	int ban;

	SClass(int grade, int ban) {
		this.grade = grade;
		this.ban = ban;
	}
	
	@Override
	public String toString() {
		return grade + "학년 " + ban + "반";
	}
}

public class HashMapTest1 {
	public static void main(String[] args) {
		ArrayList<Person> pal = new ArrayList<Person>();
		pal.add(new Person(20, "홍길동"));
		pal.add(new Person(10, "고길동"));
		pal.add(new Person(30, "박길동"));

		HashMap<String, Object> hm = new HashMap<>();

		hm.put("pers", pal);
		hm.put("class", new SClass(2, 1));

		@SuppressWarnings("unchecked")
		ArrayList<Person> pers = (ArrayList<Person>) hm.get("pers");
		SClass sclass = (SClass) hm.get("class");
		System.out.println(pers);
		System.out.println(sclass);
	}

}
