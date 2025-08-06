package chapter7;

class Base {
	int bnum;

	Base() {
		System.out.println("Base()");
	}

	Base(int num) {
		this.bnum = num;
		System.out.println("Base(int num)");
	}
}

class Derived extends Base {
	int dnum;

	Derived(int bnum, int dnum) {
		this.bnum = bnum;
		this.dnum = dnum;
		System.out.println("Derived(int bnum, int dnum)");
	}
}

public class ConstructorTest1 {

	public static void main(String[] args) {
		Base b = new Derived(1, 2);
	}

}
