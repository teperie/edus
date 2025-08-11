
public class StringTest4 {
	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("abc");
		StringBuilder sb2 = new StringBuilder("abc");

		StringBuffer sbf1 = new StringBuffer("abcd");
		StringBuffer sbf2 = new StringBuffer("abcd");
		
		System.out.println(sb1 == sb2);
		System.out.println(sb1.equals(sb2));
		
		System.out.println(sbf1 == sbf2);
		System.out.println(sbf1.toString().equals(sbf2.toString()));
		
		sbf1.append("efg");
		System.out.println(sbf1);
		
		Math.ceil(1);
		
		Boolean b ;
	}
	

}
