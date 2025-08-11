
public class StringTest2 {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = str1.concat("def");
		String str3 = str1 + "def";

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

		String str4 = "java.lang";
		int idx1 = str4.lastIndexOf('a');
		System.out.println(idx1);
		int idx2 = str4.indexOf("la");
		System.out.println(idx2);

		String f = "apple banana orange banana";
		System.out.println(f.contains("banana"));
		System.out.println(f.indexOf("banana") != -1);

		System.out.println("============================");

		String str5 = str4.replace('a', 'e');
		System.out.println(str4);
		System.out.println(str5);

		String f2 = f.replace("banana", "melon");
		System.out.println(f);
		System.out.println(f2);

		String[] fitem = f.split(" ");

		for (int i = 0; i < fitem.length; i++) {
			System.out.println(fitem[i]);
		}

		String[] fitem2 = f.split(" ", 3);
		for (int i = 0; i < fitem2.length; i++) {
			System.out.println(fitem2[i]);
		}
	}

}
