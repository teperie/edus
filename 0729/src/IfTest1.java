
public class IfTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;

		if (x > 0) {
			System.out.println("양수에요");
		} else if (x < 0) {
			System.out.println("음수에요");
		} else {
			System.out.println("0이에요");
		}

		int kor = 99, eng = 80, math = 99;
		int tot = kor + eng + math;
		double avg = tot / 3.0;
		String grade;

		if (avg >= 90) {
			grade = "A";
			if (avg >= 98) {
				grade += "+";
			} else if (avg <= 94) {
				grade += "-";
			} else {
				grade += "0";
			}
		} else if (avg >= 80) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg > 60) {
			grade = "D";
		} else {
			grade = "F";
		}

		System.out.println(String.format("총점: %d, 평균: %.2f, 학점: %s", tot, avg, grade));
	}

}
