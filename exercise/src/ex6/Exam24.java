package ex6;

public class Exam24 {

	static int abs(int value) {
		return value >= 0 ? value : -value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = 5;
		System.out.println(value + "의 절대값:" + abs(value));
		value = -10;
		System.out.println(value + "의 절대값:" + abs(value));
	}

}
