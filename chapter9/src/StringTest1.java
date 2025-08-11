
public class StringTest1 {
	public static void main(String[] args) {
		String str1 = "hong";
		String str2 = "hong";

		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));

		String name = "hong gil dong";
		String first = name.substring(0, 4);

		System.out.println(first);
		
		String asdf = "hong";

		System.out.println(str1 == first);
		System.out.println(str1.equals(first));

		String str3 = new String("abc");
		String str4 = new String("abc");

		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));
		
		System.out.println(str1.equals(asdf));
		
		String str5 = null;
		String str6 = "\2";
		System.out.println("\0");
	}
}
