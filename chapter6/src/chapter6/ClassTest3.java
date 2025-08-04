package chapter6;

class Point {
	int x = (int)pi;
	int y;
	static float pi = 3.14f;
}

public class ClassTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Point[] parr = { new Point(), new Point(), new Point() };
		int cnt = 0;
		Point[] parr = new Point[100];
		parr[0] = new Point();
		parr[0].x = 10;
		parr[0].y = 20;
		System.out.println();
		cnt++;

		parr[1] = new Point();
		parr[1].x = 100;
		parr[1].y = 200;
		cnt++;
		
		for (int i = 0; i < cnt; i++) {
			System.out.println(parr[i].x + " " + parr[i].y);
		}
	}

}
