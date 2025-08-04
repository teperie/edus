package chapter6;

class MyClass {

	int iv;
	static int cv;

	void method1() {

	}

	void method2() {
		iv = 100; // instance method에서 instance 변수 사용 가능
		cv = 200; // instance method에서 class 변수 사용 가능
		method1();// instance method에서 instance method 호출 가능
		method3(); // instance method에서 static method 호출 가능
	}

	static void method3() {
//		iv = 10; // static method에서 instance 변수 사용 불가능
		cv = 20; // static method에서 static 변수 사용 가능
//		method1(); // static method에서 instance method 호출 불가능
		method4(); // static method에서 static method 호출 가능
	}

	static void method4() {

	}

}

public class StaticMethodTest2 {

	public static void main(String[] args) {

	}

}
