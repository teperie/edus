
public class SwitchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor = 99, eng = 80, math = 99;
		int tot = kor + eng + math;
		double avg = tot / 3.0;
		String grade;

		switch ((int) avg / 10) {
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		
		System.out.println(String.format("총점: %d, 평균: %.2f, 학점: %s", tot, avg, grade));
	}

}
