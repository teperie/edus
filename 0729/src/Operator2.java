
public class Operator2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2440000;
		int b = 2440000;

		System.out.println(10 / (float) 4);

		int k = 98, e = 87, m = 99;
		int tot = k + e + m;
		double avg = tot / 3.0;
//		avg = avg * 100;
//		avg = Math.round(avg);
//		avg = avg / 100;

		avg = Math.round(avg * 100) / 100d;

		System.out.println(avg);

		long c = (long) a * b;
		System.out.println(c);

		int d = (int) (1000000l * 1000000 / 1000000);
		int g = 1000000 / 1000000 * 1000000;

		System.out.println(d);
		System.out.println(g);

		char c1 = 'a';
		char c2 = (char) (c1 + 1);
		char c3 = ++c1;

		System.out.println(c1);

		int z = 0;
		char cz = '0';
		System.out.println(cz + 0);
		int n = '9' - '0';
		System.out.println(n);

		float pi = 3.141592f;
		float changePi = pi * 1000;
		changePi = Math.round(changePi);
		changePi = (int) changePi;
		changePi = changePi / 1000;
		System.out.println(changePi);

		Math.round(changePi);
		
		System.out.println((int)'\n');
	}

}
