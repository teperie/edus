package ex6;

public class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	int getTotal() {
		return kor + eng + math;
	}

	float getAverage() {
		return Math.round(getTotal() * 10 / (float) 3) / 10f;
	}

	String info() {
		return String.format("이름: %s\n반: %d\n번호: %d\n국어: %d\n영어: %d\n수학: %d\n총점: %d\n평균: %f\n", name, ban, no, kor, eng,
				math, getTotal(), getAverage());
	}
}
