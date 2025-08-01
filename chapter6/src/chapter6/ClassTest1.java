package chapter6;

class Person { // class	
	int age; // 속성
	String name; // 속성

	void info() { // 메서드
		System.out.println(name + ": " + age + "세");
	}
}

public class ClassTest1 {

	public static void main(String[] args) {
		Person p = new Person();
		p.age = 20;
		p.name = "홍길동";
		Person p2 = new Person();
		p2.age = 30;
		p2.name = "박길동";
		
		p2 = p;
		
		p.name = "김길동";
		
		p.info();		
		p2.info();
	}

}
