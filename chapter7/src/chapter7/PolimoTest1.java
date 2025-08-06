package chapter7;

public class PolimoTest1 {
	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();

		p.method1(); // 부모 메서드 호출
		c.method1(); // 자식 메서드 호출

		// 자식 메서드가 있으면 자식 메서드가 호출됨. 없으면 부모 메서드가 호출됨.
		// 자식에만 있고 부모에는 없는 메서드는 호출 불가
		Parent p2 = new Child(); // 업캐스팅
		p2.method1(); // 자식 메서드 호출
		p2.method2(); // 부모 메서드 호출

		// p2.method3(); // 자식 객체라 하더라도 부모 타입으로 선언된 객체에서는 자식 메서드 호출 불가

		// 다운캐스팅 시 자식 타입으로 형변환 해야 함.
		// Child c2 = new Parent(); // 다운캐스팅 불가
		Child c2 = (Child) p2; // 다운캐스팅
		c2.method1(); // 자식 메서드 호출
		c2.method2(); // 부모 메서드 호출
		c2.method3(); // 자식 메서드 호출

		Child c3 = (Child) p;
	}

}
