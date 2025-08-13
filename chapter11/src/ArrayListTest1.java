

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest1 {
	public static void main(String[] args) {
		ArrayList ar1 = new ArrayList();
		ar1.add(3);
		ar1.add(7);
		ar1.add(4);
		ar1.add(2);
		ar1.add(1);
		System.out.println(ar1);

		ArrayList ar2 = new ArrayList(ar1.subList(1, 4));
		System.out.println(ar2);
		System.out.println();
		
		Collections.sort(ar1);
		System.out.println(ar1);
		
		ar2.add("AB");
		ar2.add("B");
		ar2.add("C");
		System.out.println(ar2);
		ar2.set(2, "D");
		System.out.println(ar2);
	}
}
