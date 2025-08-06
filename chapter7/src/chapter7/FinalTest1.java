package chapter7;

class Product {
	// static final 변수는 명시적 초기화 또는 static 블록에서 초기화 해야 함. 생성자에서 초기화 불가
	static final int size;
	static {
		size = 10;
	}

	// instance final 변수는 명시적 초기화나 인스턴스 블럭을 통해서도 초기화가 가능하긴 하지만
	// 객체마다 다른값으로 초기화하기 때문에 생성자에서 초기화 해야 함.
	final String name;

	Product(String name) {
		this.name = name;
	}

	Product() {
		this.name = "상품";
	}
}

public class FinalTest1 {

	public static void main(String[] args) {
		final int n;
		n = 20;
		// n = 30;
		System.out.println(n);

		Product p = new Product();
		System.out.println(p.name);
		System.out.println(Product.size);
		Product p2 = new Product("TV");
		System.out.println(p2.name);

		// Product p3 = new Product();
		// System.out.println(p3.name);
		// System.out.println(Product.size);
	}

}
