package chapter6;

class Time {
	int hour;
	int minute;
	int second;
}

class Point {
	int x, y;
}

public class ClassTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time time = new Time();

		Time[] tarr = new Time[3]; // Time 객체 3개가 아니라 참조변수 3개가 만들어지고 null로 초기화됨
		// 각 객채를 생성하여 배열에 담은 후 사용해야 한다.
		tarr[0] = new Time();
		tarr[1] = new Time();
		tarr[2] = new Time();

		Point p = new Point();
	}

}
