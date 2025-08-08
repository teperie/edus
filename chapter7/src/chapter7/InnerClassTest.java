package chapter7;

abstract class Kosta {

	void method1() {

	}

	abstract void method2();
}

class Kosta2 extends Kosta {

	@Override
	void method2() {
		// TODO Auto-generated method stub
		System.out.println("Kosta2");
	}

}

public class InnerClassTest {
	
	
	public static void main(String[] args) {
		Kosta2 k2 = new Kosta2();
		k2.method2();
		k2.method2();

		Kosta k = new Kosta() { // Kosta 클래스를 상속받아 method2를 오버라이드해서 새로운 클래스를 만든 후 생성
			@Override
			void method2() {
				// TODO Auto-generated method stub
				System.out.println("No name class method2");
			}
		};
		
		k.method2();
	}

}
