
public class Hello {
	
	static boolean asdf;
	static int nn;
	static double dd;
	static float ff;
	static char cc;
	static short ss;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("asdffdas");

		boolean b = true;
		int n = 10;
		double d = 3.14;
		float f = 3.14f;
		char ch = 'c';
		System.out.println(ch);

		ch = 'h';

		System.out.println(ch);

		System.out.println(b);

		String str = "홍갈동";
		System.out.println(str);

		String name = "이창준";
		short age = 32;
		float height = 173.0f;
		char gender = '남';
		boolean married = false;

		System.out.println(String.format("이름:%s, 나이:%d, 키:%f, 성별:%c, 결혼여부:%b", name, age, height, gender, married));
		
		System.out.println(asdf);
		System.out.println(nn);
		System.out.println(dd);
		System.out.println(ff);
		System.out.println(cc);
		System.out.println(ss);
		
		
		
		StringBuilder strb = new StringBuilder("asdf");
		strb.append(str).append(b);
		
		System.out.println(strb);
	}

}