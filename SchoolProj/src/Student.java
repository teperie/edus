
public class Student {
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	Student() {

	}

	Student(int ban, int no, int kor, int eng, int math) {
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getTotal() {
		return kor + eng + math;
	}

	public float getAverage() {
		return Math.round(getTotal() / 3f * 100) / 100;
	}

	public String info() {
		return String.format("반:%d, 번: %d 국어: %d, 영어: %d, 수학: %d, 총점: %d, 평균: %f", ban, no, kor, eng, math, getTotal(),
				getAverage());
	}
}
