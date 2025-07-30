
public class ForTest9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int depth = 100;
		int up = 5;
		int down = 2;

		int day = 0;
		int now = 0;

		while (now < depth) {
			now += up;
			day++;
			if (now >= depth)
				break;

			now -= down;

			System.out.printf("%d일 뒤, %d미터\n", day, now);
		}
		System.out.printf("%d일 걸려서 도착, %d미터\n", day, now);
	}

}
