package chapter6;

class Calculator1 {
	int x, y;

	int add() {
		return x + y;
	}

	int sub() {
		return x - y;
	}

	int mul() {
		return x * y;

	}

	double div() {
		return y == 0 ? 0 : (double) x / y;
	}
}

class Calculator2 {
	static int add(int x, int y) {
		return x + y;
	}

	static int sub(int x, int y) {
		return x - y;
	}

	static int mul(int x, int y) {
		return x * y;
	}

	static double div(int x, int y) {
		return y == 0 ? 0 : (double) x / y;
	}

}

public class StaticMethodTest1 {
	public static void main(String[] args) {
		Calculator1 calc1 = new Calculator1();
		calc1.x = 10;
		calc1.y = 3;

		System.out.println(calc1.add());
		System.out.println(calc1.sub());
		System.out.println(calc1.mul());
		System.out.println(calc1.div());
	
		System.out.println(Calculator2.add(7, 3));
		System.out.println(Calculator2.sub(4, 5));
		System.out.println(Calculator2.mul(6, 2));
		System.out.println(Calculator2.div(13, 3));
	}
}
