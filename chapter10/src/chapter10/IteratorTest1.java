package chapter10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class IteratorTest1 {
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<>();
		a1.add(10);
		a1.add(70);
		a1.add(30);
		a1.add(50);
		a1.add(40);

		int size = a1.size();
		for (int i = 0; i < size; i++) {
			if (a1.get(i) == 30) {
				a1.add(i, 60);
			}
		}

		ListIterator<Integer> it = a1.listIterator();
		while (it.hasNext()) {
			if (it.next() == 30)
				it.add(60);
		}
		
		System.out.println(a1);

		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		
		for (Integer integer : a1) {

		}

		System.out.println(a1);
	}
}
