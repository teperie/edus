package chapter6;

// 메소드 오버로딩 : 하나의 클래스에 메서드의 이름이 같은 것이 여러개 올 수 있다. 단, 매개변수의 타입이나 갯수가 달라야 한다.
class MyAdd {
	static int add(int x, int y) {
		return x + y;
	}
	
	static long add(long x, long y) {
		return x + y;
	}

	// 리턴 타입만 다른것은 overloading이 성립하지 않는다.
//	static float add(int x, int y) {
//		return (float) x + y;
//	}

	static int add(int x, int y, int z) {
		return x + y + z;
	}

	// 매개변수 이름만 다른 것은 overloading이 성립하지 않는다.
//	static int add(int a, int b) {
//		return a + b;
//	}

	static float add(float x, float y) {
		return x + y;
	}

	static String add(String x, String y) {
		return x + y;
	}

	static double add(double x, double y) {
		return x + y;
	}
}

public class OverloadTest1 {

	public static void main(String[] args) {
		MyAdd.add(3, 4);
		MyAdd.add(3.5f, 4.1f);
		MyAdd.add(1000L, 2000L);
		MyAdd.add("hong", "gildong");
		MyAdd.add("3", 2.7 + "");
		
		System.out.println();
	}

}
