
public class StringTest3 {

	public static void main(String[] args) {
		String str1 = "java.lang.Object";
		String str2 = str1.substring(5);
		System.out.println(str2);
		String str3 = str1.substring(5, 9);
		System.out.println(str3);

		String s100 = String.valueOf(100);
//		String s100 = 100 + "";

		int n100 = Integer.parseInt(s100);

		String strue = String.valueOf(true);
		System.out.println(strue);
		
		
		
	}
}
