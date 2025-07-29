
public class Operator4 {
	public static void main(String[] args) {
		int m = 10, n = 20;
		int max = m > n ? m : n;

		System.out.println(max);

		int max2;
		if (m > n) {
			max2 = m;
		} else {
			max2 = n;
		}

		int x = -10;
		int absX = x > 0 ? x : -x;
		System.out.println(absX);

		int y = 20;
		y += 5;
		System.out.println(y);
		
		int i = 3;
		i *= 10 + 2;
		System.out.println(i);
	}
}
