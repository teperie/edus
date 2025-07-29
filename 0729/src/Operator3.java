
public class Operator3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(10.0d == 10.0f);
		System.out.println(0.1d == 0.1f);
		System.out.println((float) 0.1d == 0.1f);
		System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1);

		char ch = '1';
		System.out.println(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z');

		char num = '8';
		System.out.println(num >= '0' && num <= '9');
		
		char hangul = '뭐';
		System.out.println(hangul >= '가' && hangul <='힣');
	}

}
