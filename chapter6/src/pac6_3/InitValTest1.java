package pac6_3;

class Test {
	int num = 20;

	Test() {

	}

	Test(int num) {
		this.num = num;
	}

	{
		num = 40;
	}
}

public class InitValTest1 {

	public static void main(String[] args) {
		Test t1 = new Test(30);

		System.out.println(t1.num);
	}

}

// num : 0 기본값 -> 20 명시적 초기화 -> 40 초기화블럭 -> 30 생성자