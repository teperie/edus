
public class LottoExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ball = new int[46];

		for (int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
		}

		for (int i = 0; i < 10000; i++) {
			int rIdx1 = (int) (Math.random() * 46);
			int rIdx2 = (int) (Math.random() * 46);

			int tmp = ball[rIdx1];
			ball[rIdx1] = ball[rIdx2];
			ball[rIdx2] = tmp;
		}

		for (int i = 0; i < 6; i++) {
			System.out.printf("%d%s", ball[i], i != 5 ? ", " : "");
		}
	}

}
