package chapter10;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest2 {
	public static void main(String[] args) {
		ArrayList<Integer> iar = new ArrayList<>();
		iar.add(100);
		iar.add(200);
		iar.add(300);
		iar.add(400);
		iar.add(500);

		ArrayList<Person> par = new ArrayList<>();
		par.add(new Person(null, null));

		int sum = 0;
		for (int i = 0; i < iar.size(); i++) {
			sum += iar.get(i);
		}
		System.out.println(sum);

		sum = 0;
		for (Integer n : iar) {
			sum += n;
		}
		
		System.out.println(sum);
		
		sum = 0;
		Iterator<Integer> it = iar.iterator();
		while(it.hasNext()) {
			sum += it.next();
		}

		System.out.println(sum);
	}
}
